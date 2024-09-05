package back_end;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String designacao;
    private List<UCs> ucs = new ArrayList<>();
    private Professor directorCurso;
    

    // Constructor para inciar um Curso com a opçao da designacao e curso director 
    public Curso(String designacao, Professor directorCurso) {
        this.designacao = designacao;
        this.directorCurso = directorCurso;
    }

    // Metodo para adicionar uma disciplina à lista de disciplina do curso
    public void adicionarUCs(UCs ucs) {
        ucs.adicionarUCs(ucs);
    }

    // Metodo para adicionar uma disciplina à lista de disciplina do curso
 /*    public void adicionarEstudante(Estudante estudante) {
        estudante.adicionarEstudante(estudante);
    } */


    // Metodo para encontrar uma disciplina pela seu nome dentro do curso
    public UCs encontrarUcNome(String designacaoUc) {
        for (UCs ucs : ucs) {
            if (ucs.getDesignacao().equals(designacaoUc)) {
                return ucs;
            }
        }
        return null;
    }

    // Metodo para retirar uma disciplina do curso pela sua designaccao
    public void removeUc(String designacaoUc) {
        ucs.removeIf(uc -> uc.getDesignacao().equals(designacaoUc));
    }

    // Getter para a designacao do curso
    public String getDesignacao() {
        return designacao;
    }

    // Setter para designar um director de curso para o curso
    public void setDirectorCurso(Professor professor) {
        this.directorCurso = professor;
    }

    // Getter para o diretor de curso
    public Professor getDirectorCurso() {
        return directorCurso;
    }

    

    // Override toString metodo para fornecer uma reprsentacao de string do curso
    @Override
    public String toString() {
        return "Curso{" +
                "designacao='" + designacao + '\'' +
                ", ucs=" + ucs +
                ", directorCurso=" + directorCurso +
                '}';
    }
}
