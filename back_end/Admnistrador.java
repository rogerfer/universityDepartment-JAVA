package back_end;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class Admnistrador {
    // Maps para guardar professores e cursos
    private Map<Integer, Professor> professores = new HashMap<>(); //HashMap armazenar chaves-valor
    private Map<String, Curso> cursos = new HashMap<>();

    /**
     * @author Rogério
     * Atribuir um director de curso a um curso
     *
     * professorNumero --> o numero do professor a ser atriuido como director de curso
     * designacaoCurso --> designacao do curso em que o director de curso esta atribuido
     */
    public void designarDirectorCurso(int professorNumero, String designacaoCurso) {
        // Recuperar o professor e o curso com base nas informacoes
        Professor professor = professores.get(professorNumero);
        Curso curso = cursos.get(designacaoCurso);

        // Verifica se o professor e o curso existem
        if (professor != null && curso != null) {
            // Designar o professor como director do curso
            curso.setDirectorCurso(professor);
            System.out.println("Director de Curso atribuído com sucesso!");
        } else {
            System.out.println("Professor ou curso inválido.");
        }
    }

    /** 
     * 
     * Atribui um regente da uc para uma disiciplina de um curso
     *
     *  professorNumero:     o numero do professor passa a ser designado como regente da uc
     *  designacaoUc:   Designacao da disciplina a que esta atribuido o regente da uc
     * designacaoCurso:  Designacao do curso que contem a disciplina
     */
    public void designarRegenteUc(int professorNumero, String designacaoUc, String designacaoCurso) {
        // Recupera o profesor e o curso com base nas informacoes fornecidas 
        Professor professor = professores.get(professorNumero);
        Curso curso = cursos.get(designacaoCurso);

        // Verifica se o professor e o curso existem
        if (professor != null && curso != null) {
            // Encontra a uc dentro do curso
            UCs ucs = curso.encontrarUcNome(designacaoUc);
            if (ucs != null) {
                // Designar o professor como regente da UC
                ucs.setRegenteUc(professor);
                System.out.println("Regente de UC, atribuído com sucesso!");
            } else {
                System.out.println("UC inválida.");
            }
        } else {
            System.out.println("Professor ou curso, inválidos.");
        }
    }

    /**
     * Adicionar professor ao sistema
     *
     */
    public void adicionarProfessor(Professor professor) {
        professores.put(professor.getNumero(), professor);
    }

    /**
     * Remove professor do sistema
     *
     * professorNumero  do professor é removido
     */
    public void removerProfessor(int numeroProfessor) {
        professores.remove(numeroProfessor);
    }

    /**
     * Adiciona curso ao sistema
     */
    public void adicionarCurso(Curso curso) {
        cursos.put(curso.getDesignacao(), curso);
    }

    /**
     * remove curso do sistema
     */
    public void removerCurso(String designacaoCurso) {
        cursos.remove(designacaoCurso);
    }


    /**
     * Lista todos os professores do sistema
     */
    public void listaProfessores() {
        System.out.println("Lista de Professores:");
        for (Professor professor : professores.values()) {
            System.out.println(professor);
        }
    }

    /**
     * Lista todos os curso do sistema
     */
    public void listaCursos() {
        System.out.println("Lista de Cursos:");
        for (Curso curso : cursos.values()) {
            System.out.println(curso);
        }
    }
    
    /**
     * Salva o estado do sistema num ficheiro
     *
     */
    public void salvarEstado(String nomeFicheiro) {
        try (PrintWriter imprime = new PrintWriter(nomeFicheiro)) {
            // Grava Professores
            for (Professor professor : professores.values()) {
                imprime.println("Professor," + professor.getNumero() + "," + professor.getNome());
            }

            // Grava Cursos
            for (Curso curso : cursos.values()) {
                imprime.println("Curso," + curso.getDesignacao() + "," + curso.getDirectorCurso().getNumero());
            }

            System.out.println("Estado do sistema salvo com sucesso.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carrega o estado do sistema a partir de um arquivo de texto
    *
     */
    public void carregarEstado(String nomeFicheiro) {
        try (Scanner scanner = new Scanner(new File(nomeFicheiro))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(",");

                if (partes.length > 1) {
                    String tipo = partes[0];

                    if (tipo.equals("Professor")) {
                        // Carrega Professor
                        int numero = Integer.parseInt(partes[1]);
                        String nome = partes[2];
                        Professor professor = new Professor(nome, numero, null); // supondo que a data de inicio nao esta carregada
                        adicionarProfessor(professor);
                    } else if (tipo.equals("Curso")) {
                        // Carrega Curso
                        String designacao = partes[1];
                        Professor professor = professores.get(Integer.parseInt(partes[2]));
                        if (professor != null) {
                            Curso curso = new Curso(designacao, professor);
                            adicionarCurso(curso);
                        }
                    }
                }
            }
            System.out.println("Estado do sistema carregado com sucesso.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
