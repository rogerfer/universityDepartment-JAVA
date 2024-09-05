package back_end;
public class Estudante {
    private String nome;
    private int numero;
    private Curso curso;

    // Constructor para inicializar um Aluno com um nome, numero, e curso
    public Estudante(String nome, int numero, Curso curso) {
        this.nome = nome;
        this.numero = numero;
        this.curso = curso;
    }

    // Getter para recuperar o nome do aluno
    public String getNome() {
        return nome;
    }

    // Setter para definir o nome do aluno
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para recuperar o numero do aluno
    public int getNumero() {
        return numero;
    }

    // Setter para definir o numero do aluno
    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Getter para recuperar o curso associado ao aluno
    public Curso getCurso() {
        return curso;
    }

    // Setter para definir o curso associado ao aluno
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    // Override toString para fornecer uma representçao da string ALuno
    @Override
    public String toString() {
        return "Aluno{" +
                "aluno='" + nome + '\'' +
                ", numero=" + numero +
                ", curso=" + curso +
                '}';
    }
}
