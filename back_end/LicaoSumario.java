package back_end;
public class LicaoSumario {
    private String titulo;
    private String tipo;
    private String sumario;

    // Constructor tpara inicializar um Sumario com titulo, tipo e resumo
    public LicaoSumario(String titulo, String tipo, String sumario) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.sumario = sumario;
    }

    // Getter para recuperar o titulo do resumo da licao
    public String getTitulo() {
        return titulo;
    }

    // Setter para definir o titulo do resumo da licao
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter fpara recuperar o tipo de resumo da licao
    public String getTipo() {
        return tipo;
    }

    // Setter para definir o tipo de resumo da licao
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Getter para recueprar o resumo da licao
    public String getSumario() {
        return sumario;
    }

    // Setter para definir o resumo da licao
    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    // Override toString metodo para fornecer uma representacao string licaoSumario
    @Override
    public String toString() {
        return "Sumario{" +
                "titulo='" + titulo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", sumario='" + sumario + '\'' +
                '}';
    }
}
