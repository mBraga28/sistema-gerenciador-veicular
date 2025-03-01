package br.com.fuctura;

import java.time.Instant;
import java.util.List;
import java.util.Scanner;

import br.com.fuctura.entity.Cliente;
import br.com.fuctura.entity.Loja;
import br.com.fuctura.entity.Tipo;
import br.com.fuctura.entity.Veiculo;
import br.com.fuctura.entity.Venda;
import br.com.fuctura.entity.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Aplicacao {
    private static EntityManager em;

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU");
		em = emf.createEntityManager();
		em.getTransaction();
		
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
                    em.close();
                    emf.close();
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
                    System.out.print("Digite a placa do veículo: ");
                    String consultarPlaca = scanner.nextLine();
                    Veiculo veiculo = em.createQuery("SELECT v FROM Veiculo v WHERE v.placa = :placa", Veiculo.class)
                      .setParameter("placa", consultarPlaca)
                      .getResultList()
                      .stream()
                      .findFirst()
                      .orElse(null);
                    if (veiculo != null) {
                        System.out.println("Veículo encontrado: " + veiculo);
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }

                    em.getTransaction().begin();
                    em.persist(veiculo);
                    em.getTransaction().commit();
                    System.out.println("Veículo cadastrado com sucesso!");
                    
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
                    List<Loja> lojas = em.createQuery("SELECT l FROM Loja l", Loja.class).getResultList();
                    lojas.forEach(System.out::println);
                    
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
                    System.out.print("Digite o nome do vendedor: ");
                    String consultarNome = scanner.nextLine();
                    Vendedor vendedor = em.createQuery("SELECT v FROM Vendedor v WHERE v.nome = :nome", Vendedor.class)
                      .setParameter("nome", consultarNome)
                      .getResultList()
                      .stream()
                      .findFirst()
                      .orElse(null);
                    if (vendedor != null) {
                        System.out.println("Vendedor encontrado: " + vendedor);
                    } else {
                        System.out.println("Vendedor não encontrado.");
                    }
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
                    System.out.println("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite o celular: ");
                    Cliente cliente = new Cliente();
                    cliente.setNome(nome);
                    cliente.setCpf(cpf);
                    cliente.setCelular(scanner.nextLine());
                    em.getTransaction().begin();
                    em.persist(cliente);
                    em.getTransaction().commit();
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case "2":
                    System.out.println("Consultando Cliente por CPF...");
                    // Lógica para consulta de cliente
                    System.out.print("Digite o CPF do cliente: ");
                    String consultarCpf = scanner.nextLine();
                    Cliente cliente2 = em.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf", Cliente.class)
                      .setParameter("cpf", consultarCpf)
                      .getResultList()
                      .stream()
                      .findFirst()
                      .orElse(null);
                    if (cliente2 != null) {
                        System.out.println("Cliente encontrado: " + cliente2);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
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
                    System.out.println("Digite o código do Clinete:");
                    String codCliente = scanner.nextLine();
                    System.out.println("Digite o código do Vendedor:");
                    String codVendedor = scanner.nextLine();
                    System.out.println("Digite o código do Veículo:");
                    String codVeiculo = scanner.nextLine();
                    System.out.println("Digite o código da Loja:");
                    String codLoja = scanner.nextLine();
                    System.out.println("Digite o valor da venda:");
                    String valor = scanner.nextLine();
                    // inserção da data e hora da criação da venda no momento do cadastro
                    Venda venda = new Venda();
                    
                    Cliente c = em.find(Cliente.class, Integer.parseInt(codCliente));
                    venda.setCliente(c);

                    Vendedor ven = em.find(Vendedor.class, Integer.parseInt(codVendedor));
                    venda.setVendedor(ven);

                    Veiculo vei = em.find(Veiculo.class, Integer.parseInt(codVeiculo));
                    venda.setVeiculo(vei);

                    Loja l = em.find(Loja.class, Integer.parseInt(codLoja));
                    venda.setLoja(l);

                    venda.setValor(Double.parseDouble(valor));
                    venda.setDhVenda(Instant.now());
                    em.getTransaction().begin();
                    em.persist(venda);
                    em.getTransaction().commit();
                    System.out.println("Venda cadastrada com sucesso!");
                    
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
                    System.out.println("Digite a placa: ");
                    String placa = scanner.nextLine();
                    System.out.println("Digite o modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.println("Digite o ano: ");
                    String ano = scanner.nextLine();
                    System.out.println("Digite o valor: ");
                    String valor = scanner.nextLine();
                    System.out.println("Digite o código do tipo: ");
                    String codTipo = scanner.nextLine();
                    Tipo tipo = em.find(Tipo.class, Integer.parseInt(codTipo));
                    System.out.println("Digite o código da loja: ");
                    String codLoja = scanner.nextLine();
                    Loja loja = em.find(Loja.class, Integer.parseInt(codLoja));

                    Veiculo veiculo = new Veiculo();
                    veiculo.setPlaca(placa);
                    veiculo.setModelo(modelo);
                    veiculo.setAno(Integer.parseInt(ano));
                    veiculo.setValor(Double.parseDouble(valor));
                    veiculo.setTipo(tipo);
                    veiculo.setLoja(loja);

                    em.getTransaction().begin();
                    em.persist(veiculo);
                    em.getTransaction().commit();
                    System.out.println("Veículo cadastrado com sucesso!");
                    break;
                case "2":
                    System.out.println("Excluindo veículo...");
                    // Lógica para excluir veículo
                    System.out.println("Digite o código do veículo: ");
                    String codigo = scanner.nextLine();
                    Veiculo veiculoExcluir = em.find(Veiculo.class, Integer.parseInt(codigo));
                    
                    em.getTransaction().begin();
                    em.remove(veiculoExcluir);
                    em.getTransaction().commit();
                    System.out.println("Veículo excluido com sucesso!");
                    break;
                case "3":
                    System.out.println("Alterando dados do veículo...");
                    // Lógica para alterar veículo
                    System.out.println("Digite o código do veículo: ");
                    String codigoAlterar = scanner.nextLine();
                    Veiculo veiculoAlterar = em.find(Veiculo.class, Integer.parseInt(codigoAlterar));
                    System.out.println("Digite a placa: ");
                    String placaAlterar = scanner.nextLine();
                    System.out.println("Digite o modelo: ");
                    String modeloAlterar = scanner.nextLine();
                    System.out.println("Digite o ano: ");
                    String anoAlterar = scanner.nextLine();
                    System.out.println("Digite o valor: ");
                    String valorAlterar = scanner.nextLine();

                    veiculoAlterar.setPlaca(placaAlterar);
                    veiculoAlterar.setModelo(modeloAlterar);
                    veiculoAlterar.setAno(Integer.parseInt(anoAlterar));
                    veiculoAlterar.setValor(Double.parseDouble(valorAlterar));

                    em.getTransaction().begin();
                    em.persist(veiculoAlterar);
                    em.getTransaction().commit();
                    System.out.println("Veículo alterado com sucesso!");
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
                    System.out.println("Digite o nome: ");
                    String nome = scanner.nextLine();
                    Loja loja = new Loja();
                    loja.setNome(nome);

                    em.getTransaction().begin();
                    em.persist(loja);
                    em.getTransaction().commit();
                    System.out.println("Loja cadastrada com sucesso!");
                    break;
                case "2":
                    System.out.println("Excluindo Loja...");
                    // Lógica para excluir loja
                    System.out.println("Digite o código da loja: ");
                    String codigo = scanner.nextLine();
                    Loja lojaExcluir = em.find(Loja.class, Integer.parseInt(codigo));
                    
                    em.getTransaction().begin();
                    em.remove(lojaExcluir);
                    em.getTransaction().commit();
                    System.out.println("Loja excluida com sucesso!");
                    break;
                case "3":
                    System.out.println("Alterando dados da Loja...");
                    // Lógica para alterar loja
                    System.out.println("Digite o código da loja: ");
                    String codigoAlterar = scanner.nextLine();
                    Loja lojaAlterar = em.find(Loja.class, Integer.parseInt(codigoAlterar));
                    System.out.println("Digite o nome: ");  
                    String nomeAlterar = scanner.nextLine();
                    lojaAlterar.setNome(nomeAlterar);

                    em.getTransaction().begin();
                    em.persist(lojaAlterar);
                    em.getTransaction().commit();
                    System.out.println("Loja alterada com sucesso!");
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
                    System.out.println("Digite o nome: ");
                    String nome = scanner.nextLine();

                    Vendedor vendedor = new Vendedor();
                    vendedor.setNome(nome);

                    em.getTransaction().begin();
                    em.persist(vendedor);
                    em.getTransaction().commit();
                    System.out.println("Vendedor cadastrado com sucesso!");

                    break;
                case "2":
                    System.out.println("Excluindo Vendedor...");
                    // Lógica para excluir vendedor
                    System.out.println("Digite o código do vendedor: ");
                    String codigo = scanner.nextLine();
                    Vendedor vendedorExcluir = em.find(Vendedor.class, Integer.parseInt(codigo));
                    
                    em.getTransaction().begin();
                    em.remove(vendedorExcluir);
                    em.getTransaction().commit();
                    System.out.println("Vendedor excluido com sucesso!");
                    break;
                case "3":
                    System.out.println("Alterando dados do Vendedor...");
                    // Lógica para alterar vendedor
                    System.out.println("Digite o código do vendedor: ");
                    String codigoAlterar = scanner.nextLine();
                    Vendedor vendedorAlterar = em.find(Vendedor.class, Integer.parseInt(codigoAlterar));
                    System.out.println("Digite o nome: ");  
                    String nomeAlterar = scanner.nextLine();
                    vendedorAlterar.setNome(nomeAlterar);

                    em.getTransaction().begin();
                    em.persist(vendedorAlterar);
                    em.getTransaction().commit();
                    System.out.println("Vendedor alterado com sucesso!");
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
            System.out.println("1 - Excluir Cliente");
            System.out.println("2 - Alterar dados do Cliente");
            System.out.println("3 - Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("Excluindo Cliente...");
                    // Lógica para excluir cliente
                    System.out.println("Digite o código do cliente: ");
                    String codigo = scanner.nextLine();
                    Cliente clienteExcluir = em.find(Cliente.class, Integer.parseInt(codigo));
                    
                    em.getTransaction().begin();
                    em.remove(clienteExcluir);
                    em.getTransaction().commit();
                    System.out.println("Cliente excluido com sucesso!");
                    break;
                case "2":
                    System.out.println("Alterando dados do Cliente...");
                    // Lógica para alterar cliente
                    System.out.println("Digite o código do cliente: ");
                    String codigoAlterar = scanner.nextLine();
                    Cliente clienteAlterar = em.find(Cliente.class, Integer.parseInt(codigoAlterar));
                    System.out.println("Digite o nome: ");
                    String nomeAlterar = scanner.nextLine();
                    System.out.println("Digite o telefone: ");
                    String telefoneAlterar = scanner.nextLine();

                    clienteAlterar.setNome(nomeAlterar);
                    clienteAlterar.setCelular(telefoneAlterar);

                    em.getTransaction().begin();
                    em.persist(clienteAlterar);
                    em.getTransaction().commit();
                    System.out.println("Cliente alterado com sucesso!");
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
                    System.out.println("Digite o código da venda: ");
                    String codigo = scanner.nextLine();
                    Venda vendaExcluir = em.find(Venda.class, Integer.parseInt(codigo));
                    
                    em.getTransaction().begin();
                    em.remove(vendaExcluir);
                    em.getTransaction().commit();
                    System.out.println("Venda excluida com sucesso!");
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