package br.com.fuctura;

import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        while (!sair) {
            System.out.println("\n# Interface com Usuário");
            System.out.println("1 - Frente de Loja");
            System.out.println("2 - Manutenção no Cadastro");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    menuFrenteDeLoja(scanner);
                    break;
                case "2":
                    menuManutencao(scanner);
                    break;
                case "3":
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }

    private static void menuFrenteDeLoja(Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n## Frente de Loja");
            System.out.println("1 - Gerenciar Veículo");
            System.out.println("2 - Gerenciar Loja");
            System.out.println("3 - Gerenciar Vendedor");
            System.out.println("4 - Gerenciar Cliente");
            System.out.println("5 - Gerenciar Venda");
            System.out.println("6 - Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    gerenciarVeiculoFrente(scanner);
                    break;
                case "2":
                    gerenciarLojaFrente(scanner);
                    break;
                case "3":
                    gerenciarVendedorFrente(scanner);
                    break;
                case "4":
                    gerenciarClienteFrente(scanner);
                    break;
                case "5":
                    gerenciarVendaFrente(scanner);
                    break;
                case "6":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void gerenciarVeiculoFrente(Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Gerenciar Veículo");
            System.out.println("1 - Consultar Veículo por Placa");
            System.out.println("2 - Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("Consultando Veículo por Placa...");
                    // Aqui pode ser implementada a lógica de consulta
                    break;
                case "2":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void gerenciarLojaFrente(Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Gerenciar Loja");
            System.out.println("1 - Listar todas as Lojas");
            System.out.println("2 - Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("Listando todas as Lojas...");
                    // Lógica para listar lojas
                    break;
                case "2":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void gerenciarVendedorFrente(Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Gerenciar Vendedor");
            System.out.println("1 - Consultar Vendedor por Nome");
            System.out.println("2 - Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("Consultando Vendedor por Nome...");
                    // Lógica para consulta de vendedor
                    break;
                case "2":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void gerenciarClienteFrente(Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Gerenciar Cliente");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Consultar Cliente por CPF");
            System.out.println("3 - Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("Cadastrando Cliente...");
                    // Lógica para cadastrar cliente
                    break;
                case "2":
                    System.out.println("Consultando Cliente por CPF...");
                    // Lógica para consulta de cliente
                    break;
                case "3":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void gerenciarVendaFrente(Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Gerenciar Venda");
            System.out.println("1 - Cadastrar Venda");
            System.out.println("2 - Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("Cadastrando Venda...");
                    // Lógica para cadastrar venda
                    break;
                case "2":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void menuManutencao(Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n## Manutenção no Cadastro");
            System.out.println("1 - Gerenciar Veículo");
            System.out.println("2 - Gerenciar Loja");
            System.out.println("3 - Gerenciar Vendedor");
            System.out.println("4 - Gerenciar Cliente");
            System.out.println("5 - Cadastrar Venda");
            System.out.println("6 - Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    gerenciarVeiculoManutencao(scanner);
                    break;
                case "2":
                    gerenciarLojaManutencao(scanner);
                    break;
                case "3":
                    gerenciarVendedorManutencao(scanner);
                    break;
                case "4":
                    gerenciarClienteManutencao(scanner);
                    break;
                case "5":
                    gerenciarVendaManutencao(scanner);
                    break;
                case "6":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void gerenciarVeiculoManutencao(Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Gerenciar Veículo");
            System.out.println("1 - Cadastrar veículo");
            System.out.println("2 - Excluir veículo");
            System.out.println("3 - Alterar dados do veículo");
            System.out.println("4 - Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("Cadastrando veículo...");
                    // Lógica para cadastrar veículo
                    break;
                case "2":
                    System.out.println("Excluindo veículo...");
                    // Lógica para excluir veículo
                    break;
                case "3":
                    System.out.println("Alterando dados do veículo...");
                    // Lógica para alterar veículo
                    break;
                case "4":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void gerenciarLojaManutencao(Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Gerenciar Loja");
            System.out.println("1 - Cadastrar Loja");
            System.out.println("2 - Excluir Loja");
            System.out.println("3 - Alterar dados da Loja");
            System.out.println("4 - Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("Cadastrando Loja...");
                    // Lógica para cadastrar loja
                    break;
                case "2":
                    System.out.println("Excluindo Loja...");
                    // Lógica para excluir loja
                    break;
                case "3":
                    System.out.println("Alterando dados da Loja...");
                    // Lógica para alterar loja
                    break;
                case "4":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void gerenciarVendedorManutencao(Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Gerenciar Vendedor");
            System.out.println("1 - Cadastrar Vendedor");
            System.out.println("2 - Excluir Vendedor");
            System.out.println("3 - Alterar dados do Vendedor");
            System.out.println("4 - Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("Cadastrando Vendedor...");
                    // Lógica para cadastrar vendedor
                    break;
                case "2":
                    System.out.println("Excluindo Vendedor...");
                    // Lógica para excluir vendedor
                    break;
                case "3":
                    System.out.println("Alterando dados do Vendedor...");
                    // Lógica para alterar vendedor
                    break;
                case "4":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void gerenciarClienteManutencao(Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Gerenciar Cliente");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Excluir Cliente");
            System.out.println("3 - Alterar dados do Cliente");
            System.out.println("4 - Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("Cadastrando Cliente...");
                    // Lógica para cadastrar cliente
                    break;
                case "2":
                    System.out.println("Excluindo Cliente...");
                    // Lógica para excluir cliente
                    break;
                case "3":
                    System.out.println("Alterando dados do Cliente...");
                    // Lógica para alterar cliente
                    break;
                case "4":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void gerenciarVendaManutencao(Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Cadastrar Venda");
            System.out.println("1 - Excluir Venda");
            System.out.println("2 - Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("Excluindo Venda...");
                    // Lógica para excluir venda
                    break;
                case "2":
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}