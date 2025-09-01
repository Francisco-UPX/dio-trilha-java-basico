package DesignJava;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class SistemaBoard {

    // Classe para representar um recado com mais funcionalidades
    static class Recado {
        private final int id;
        private String titulo;
        private String conteudo;
        private final LocalDateTime dataCriacao;
        private LocalDateTime dataModificacao;
        private boolean concluido;
        private int prioridade; // 1-5, onde 5 é mais importante

        public Recado(int id, String titulo, String conteudo, int prioridade) {
            this.id = id;
            this.titulo = titulo;
            this.conteudo = conteudo;
            this.dataCriacao = LocalDateTime.now();
            this.dataModificacao = LocalDateTime.now();
            this.concluido = false;
            this.prioridade = Math.max(1, Math.min(5, prioridade)); // Garante prioridade entre 1-5
        }

        // Getters e Setters
        public int getId() { return id; }
        public String getTitulo() { return titulo; }
        public String getConteudo() { return conteudo; }
        public LocalDateTime getDataCriacao() { return dataCriacao; }
        public LocalDateTime getDataModificacao() { return dataModificacao; }
        public boolean isConcluido() { return concluido; }
        public int getPrioridade() { return prioridade; }

        public void atualizar(String novoTitulo, String novoConteudo, int novaPrioridade) {
            this.titulo = novoTitulo;
            this.conteudo = novoConteudo;
            this.prioridade = Math.max(1, Math.min(5, novaPrioridade));
            this.dataModificacao = LocalDateTime.now();
        }

        public void marcarComoConcluido() {
            this.concluido = true;
            this.dataModificacao = LocalDateTime.now();
        }

        public void marcarComoPendente() {
            this.concluido = false;
            this.dataModificacao = LocalDateTime.now();
        }

        @Override
        public String toString() {
            String status = concluido ? "✓ CONCLUÍDO" : "⏳ PENDENTE";
            String estrelas = "★".repeat(prioridade) + "☆".repeat(5 - prioridade);
            
            return String.format(
                "\n📝 Recado #%d [%s]%n" +
                "🏷  Título: %s%n" +
                "📋 Conteúdo: %s%n" +
                "⭐ Prioridade: %s%n" +
                "📅 Criado: %s%n" +
                "🔄 Modificado: %s%n",
                id, status, titulo, conteudo, estrelas, 
                dataCriacao, dataModificacao
            );
        }
    }

    // Gerenciador usando HashMap e Streams
    static class GerenciadorRecadosAvancado {
        private final Map<Integer, Recado> recadosMap;
        private int contadorId;

        public GerenciadorRecadosAvancado() {
            this.recadosMap = new HashMap<>();
            this.contadorId = 1;
        }

        public void adicionarRecado(String titulo, String conteudo, int prioridade) {
            Recado novoRecado = new Recado(contadorId++, titulo, conteudo, prioridade);
            recadosMap.put(novoRecado.getId(), novoRecado);
            System.out.println("✅ Recado adicionado com sucesso!");
        }

        public void listarRecados(boolean apenasPendentes, boolean ordenarPorPrioridade) {
            Collection<Recado> recados = recadosMap.values();
            
            if (recados.isEmpty()) {
                System.out.println("📭 Nenhum recado cadastrado.");
                return;
            }

            List<Recado> listaRecados = new ArrayList<>(recados);
            
            // Filtro por status
            if (apenasPendentes) {
                listaRecados = listaRecados.stream()
                    .filter(recado -> !recado.isConcluido())
                    .collect(Collectors.toList());
            }

            // Ordenação
            if (ordenarPorPrioridade) {
                listaRecados.sort((r1, r2) -> Integer.compare(r2.getPrioridade(), r1.getPrioridade()));
            } else {
                listaRecados.sort((r1, r2) -> r2.getDataModificacao().compareTo(r1.getDataModificacao()));
            }

            System.out.println("\n=== 📋 LISTA DE RECADOS ===");
            listaRecados.forEach(System.out::println);
            
            // Estatísticas
            long total = recadosMap.size();
            long concluidos = recadosMap.values().stream().filter(Recado::isConcluido).count();
            System.out.printf("📊 Estatísticas: %d total | %d concluídos | %d pendentes%n", 
                total, concluidos, total - concluidos);
        }

        public Optional<Recado> buscarRecadoPorId(int id) {
            return Optional.ofNullable(recadosMap.get(id));
        }

        public void editarRecado(int id, String novoTitulo, String novoConteudo, int novaPrioridade) {
            buscarRecadoPorId(id).ifPresentOrElse(
                recado -> {
                    recado.atualizar(novoTitulo, novoConteudo, novaPrioridade);
                    System.out.println("✅ Recado editado com sucesso!");
                },
                () -> System.out.println("❌ Recado não encontrado com o ID: " + id)
            );
        }

        public void removerRecado(int id) {
            if (recadosMap.remove(id) != null) {
                System.out.println("✅ Recado removido com sucesso!");
            } else {
                System.out.println("❌ Recado não encontrado com o ID: " + id);
            }
        }

        public void buscarRecados(String termo) {
            List<Recado> resultados = recadosMap.values().stream()
                .filter(recado -> recado.getTitulo().toLowerCase().contains(termo.toLowerCase()) ||
                                 recado.getConteudo().toLowerCase().contains(termo.toLowerCase()))
                .collect(Collectors.toList());

            if (resultados.isEmpty()) {
                System.out.println("🔍 Nenhum recado encontrado com o termo: '" + termo + "'");
            } else {
                System.out.println("\n=== 🔍 RESULTADOS DA BUSCA ===");
                resultados.forEach(System.out::println);
                System.out.println("📊 Encontrados: " + resultados.size() + " recado(s)");
            }
        }

        public void alternarStatusRecado(int id) {
            buscarRecadoPorId(id).ifPresentOrElse(
                recado -> {
                    if (recado.isConcluido()) {
                        recado.marcarComoPendente();
                        System.out.println("🔄 Recado marcado como PENDENTE");
                    } else {
                        recado.marcarComoConcluido();
                        System.out.println("✅ Recado marcado como CONCLUÍDO");
                    }
                },
                () -> System.out.println("❌ Recado não encontrado com o ID: " + id)
            );
        }

        public void limparRecadosConcluidos() {
            boolean removidos = recadosMap.values().removeIf(Recado::isConcluido);
            System.out.println("🧹 " + removidos + " recado(s) concluído(s) removido(s)");
        }
    }

    // Método principal com interface melhorada
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorRecadosAvancado gerenciador = new GerenciadorRecadosAvancado();

        int opcao;
        do {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("🎯 SISTEMA BOARD AVANÇADO - GERENCIADOR DE RECADOS");
            System.out.println("=".repeat(50));
            System.out.println("1. ➕ Adicionar recado");
            System.out.println("2. 📋 Listar todos os recados");
            System.out.println("3. ⏳ Listar apenas pendentes");
            System.out.println("4. ✏  Editar recado");
            System.out.println("5. 🗑  Remover recado");
            System.out.println("6. 🔍 Buscar recados");
            System.out.println("7. ✅ Marcar como concluído/pendente");
            System.out.println("8. 🧹 Limpar recados concluídos");
            System.out.println("9. ⭐ Listar por prioridade");
            System.out.println("0. 🚪 Sair");
            System.out.print("🎲 Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    System.out.print("📝 Digite o título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("📋 Digite o conteúdo: ");
                    String conteudo = scanner.nextLine();
                    
                    int prioridade = 3;
                    try {
                        System.out.print("⭐ Prioridade (1-5, padrão 3): ");
                        String input = scanner.nextLine();
                        if (!input.isEmpty()) {
                            prioridade = Integer.parseInt(input);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("⚠  Prioridade inválida. Usando padrão 3.");
                    }
                    
                    gerenciador.adicionarRecado(titulo, conteudo, prioridade);
                    break;

                case 2:
                    gerenciador.listarRecados(false, false);
                    break;

                case 3:
                    gerenciador.listarRecados(true, false);
                    break;

                case 4:
                    try {
                        System.out.print("🔢 ID do recado a editar: ");
                        int idEditar = Integer.parseInt(scanner.nextLine());
                        
                        Optional<Recado> recadoOpt = gerenciador.buscarRecadoPorId(idEditar);
                        if (recadoOpt.isPresent()) {
                            Recado recado = recadoOpt.get();
                            System.out.print("📝 Novo título [" + recado.getTitulo() + "]: ");
                            String novoTitulo = scanner.nextLine();
                            if (novoTitulo.isEmpty()) novoTitulo = recado.getTitulo();
                            
                            System.out.print("📋 Novo conteúdo [" + recado.getConteudo() + "]: ");
                            String novoConteudo = scanner.nextLine();
                            if (novoConteudo.isEmpty()) novoConteudo = recado.getConteudo();
                            
                            System.out.print("⭐ Nova prioridade (1-5) [" + recado.getPrioridade() + "]: ");
                            String prioridadeInput = scanner.nextLine();
                            int novaPrioridade = prioridadeInput.isEmpty() ? recado.getPrioridade() : Integer.parseInt(prioridadeInput);
                            
                            gerenciador.editarRecado(idEditar, novoTitulo, novoConteudo, novaPrioridade);
                        } else {
                            System.out.println("❌ Recado não encontrado!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("⚠  ID inválido!");
                    }
                    break;

                case 5:
                    try {
                        System.out.print("🔢 ID do recado a remover: ");
                        int idRemover = Integer.parseInt(scanner.nextLine());
                        gerenciador.removerRecado(idRemover);
                    } catch (NumberFormatException e) {
                        System.out.println("⚠  ID inválido!");
                    }
                    break;

                case 6:
                    System.out.print("🔍 Termo de busca: ");
                    String termo = scanner.nextLine();
                    gerenciador.buscarRecados(termo);
                    break;

                case 7:
                    try {
                        System.out.print("🔢 ID do recado para alterar status: ");
                        int idStatus = Integer.parseInt(scanner.nextLine());
                        gerenciador.alternarStatusRecado(idStatus);
                    } catch (NumberFormatException e) {
                        System.out.println("⚠  ID inválido!");
                    }
                    break;

                case 8:
                    gerenciador.limparRecadosConcluidos();
                    break;

                case 9:
                    gerenciador.listarRecados(false, true);
                    break;

                case 0:
                    System.out.println("👋 Saindo do sistema... Até logo!");
                    break;

                default:
                    System.out.println("❌ Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}