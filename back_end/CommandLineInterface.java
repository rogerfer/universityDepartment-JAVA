package back_end;
import java.util.Date;
import java.util.Scanner;

public class CommandLineInterface {
    private Admnistrador admnistrador;

    public CommandLineInterface(Admnistrador admnistrador) {
        this.admnistrador = admnistrador;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        admnistrador.carregarEstado("C:\\Users\\roger\\Desktop\\LEGSI_PCO_94632\\estado.txt");
        
        
        while (true) {
            // Mostrar o menu
            System.out.println("======== Sistema Universitário ========");
            System.out.println("1. Lista de Professores");
            System.out.println("2. Lista de Cursos");
            System.out.println("3. Adicionar Professor");
            System.out.println("4. Remover Professor");
            System.out.println("5. Adicionar Curso");
            System.out.println("6. Remover Curso");
            System.out.println("7. Designar Director de Curso");
            System.out.println("8. Designar Regente de UC");
            System.out.println("0. Sair");
            System.out.print("Escolha a opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            // Ações perante a escolha
            switch (escolha) {
                case 1:
                    admnistrador.listaProfessores();
                    break;
                case 2:
                    admnistrador.listaCursos();
                    break;
                case 3:
                    adicionarProfessor(scanner);
                    break;
                case 4:
                    removerProfessor(scanner);
                    break;
                case 5:
                    adicionarCurso(scanner);
                    break;
                case 6:
                    removerCurso(scanner);
                    break;
                case 7:
                    designarDirectorCurso(scanner);
                    break;
                case 8:
                    designarRegenteUc(scanner);
                    break;
                case 0:
                	admnistrador.salvarEstado("C:\\\\Users\\\\roger\\\\Desktop\\\\LEGSI_PCO_94632\\\\estado.txt");
                    System.out.println("A sair...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

    // Metodo para adicionar curso
    private void adicionarCurso(Scanner scanner) {
        System.out.print("Introduza designacao curso: ");
        String designcacao = scanner.nextLine();

        // Cria uma novo curso
        Curso curso = new Curso(designcacao, null); // Supondo que o director de curso nao e fornecido inicialmente
        admnistrador.adicionarCurso(curso);
        System.out.println("Curso adicionado com sucesso!");

        // Opcao para adicionar UCS ao curso
        System.out.print("Deseja adicionar disciplinas a este curso?? (sim/nao): ");
        String adicionarEscolhaUc = scanner.nextLine().toLowerCase();

        if (adicionarEscolhaUc.equals("sim")) {
            adicionarUCParaCurso(scanner, curso);
        }

        // Opcao para adicionar alunos ao curso
        System.out.print("Deseja adicionar alunos a este curso? (sim/nao): ");
        String adicionarEscolhaEstudante = scanner.nextLine().toLowerCase();

        if (adicionarEscolhaEstudante.equals("sim")) {
            adicionarEstudanteParaCurso(scanner, curso);
        }
    }

    

    /**
    *Metodo para adicionar ucs a um curso
    */
    private void adicionarUCParaCurso(Scanner scanner, Curso curso) {
        System.out.println("Adicionando UCs ao curso...");

        while (true) {
            System.out.print("Insira designacao da UC(ou 'sair' para terminar de adicionar UCs): ");
            String designacaoUc = scanner.nextLine();

            if (designacaoUc.equalsIgnoreCase("sair")) { //para ignorar maiusculas e minusculas
                break;
            }

            // Cria uma nova UC
            UCs ucs = new UCs(designacaoUc, null); // Supondo que o regente da disciplina nao e adicionado inicialmente
            curso.adicionarUCs(ucs);
            System.out.println("UC adicionada ao curso.");
        }
    }

  
     /**
    *Metodo para adicionar estudantes a um curso
    */
    private void adicionarEstudanteParaCurso(Scanner scanner, Curso curso) {
        System.out.println("Adicionando estudantes ao curso..");

        while (true) {
            System.out.print("Digite o nome do estudante (ou 'sair' para terminar de adicionar estudantes): ");
            String nomeAluno = scanner.nextLine();

            if (nomeAluno.equalsIgnoreCase("sair")) {
                break;
            }

            // Cria novo estudante
            Estudante estudante = new Estudante(nomeAluno, 0, curso); // Supondo que o numero estudante nao e fornecido inicialmente
           // curso.adicionarEstudante(estudante);
            System.out.println("Estudante adicionado ao curso.");
        }
    }

    
    /**
    *Metodo para adicionar Professor
    */
    private void adicionarProfessor(Scanner scanner) {
        System.out.print("Introduza nome do Professor: ");
        String nome = scanner.nextLine();

        System.out.print("Introduza numero do Professor: ");
        int numero = scanner.nextInt();
        scanner.nextLine();


        // Cria um novo objecto Professor
        Professor professor = new Professor(nome, numero, new Date());
        admnistrador.adicionarProfessor(professor);
        System.out.println("Professor adicionado com sucesso!");
    }

   
    /**
    *Metodo para remover professor
    */
    private void removerProfessor(Scanner scanner) {
        System.out.print("Introduza numero Professor para remover: ");
        int professorNumero = scanner.nextInt();
        scanner.nextLine();

        // remove professor
        admnistrador.removerProfessor(professorNumero);
        System.out.println("Professor removido com sucesso!");
    }


    /**
    *Metodo para designar um director de curso
    */
    private void designarDirectorCurso(Scanner scanner) {
        System.out.print("Introduza numero do Professor: ");
        int professorNumero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduza designacao do curso: ");
        String designacaoCurso = scanner.nextLine();

        // Designar um director de curso
        admnistrador.designarDirectorCurso(professorNumero, designacaoCurso);
    }

   
    /**
    *Metodo para atribuir um regente de disciplina
    */
    private void designarRegenteUc(Scanner scanner) {
        System.out.print("Introduza numero do Professorr: ");
        int professorNumero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduza nome da UC: ");
        String designacaoUC = scanner.nextLine();

        System.out.print("Introduza nome do curso: ");
        String designacaoCurso = scanner.nextLine();

        // Desingar um regente de disciplina
        admnistrador.designarRegenteUc(professorNumero, designacaoUC, designacaoCurso);
    }

    
    /**
    *Metodo para remover curso
    */
    private void removerCurso(Scanner scanner) {
        System.out.print("Introduza designacao UC a remover: ");
        String designacaoCurso = scanner.nextLine();

        // remove curso
        admnistrador.removerCurso(designacaoCurso);
        System.out.println("Course removed successfully!");
    }
}
