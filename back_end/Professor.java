package back_end;
import java.util.*;

import front_end.SistemaUniversitario;


public class Professor {
    private String nome;
    private int numero;
    private Date dataInicio;

    // Constructor para inicializar um Professor com nome, numero, data de inicio
    public Professor(String nome, int numero, Date dataInicio) {
        this.nome = nome;
        this.numero = numero;
        this.dataInicio = dataInicio;
    }

    // Getter para recuperar o número do professor
    public int getNumero() {
        return numero;
    }

    // Getter para recuperar o nome do professor
    public String getNome() {
        return nome;
    }

    // Getter para recuperar a data inicio do professor
    public Date getDataInicio() {
        return dataInicio;
    }

    // Método para criar um resumo da licao e adiciona-lo a uma disciplina de um curso
    public void criarLicaoSumario(String titulo, String tipo, String sumario, String nomeUC, String nomeCurso) {
        // Encontra curso e UC
        Curso curso = SistemaUniversitario.getCurso(nomeCurso);
        if (curso != null) {
            UCs uc = curso.encontrarUcNome(nomeUC);
            if (uc != null) {
                // Cria um novo sumario
                LicaoSumario licaoSumario = new LicaoSumario(titulo, tipo, sumario);
                // Adiciona o sumario na UC
                uc.adicionaSumario(licaoSumario);
                System.out.println("Sumário criado com sucesso!");
            } else {
                System.out.println("UC inválida.");
            }
        } else {
            System.out.println("Curso inválido.");
        }
    }

    // Override toString metodo para fornececer a representaçao string do Professor
    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                ", inicioData=" + dataInicio +
                '}';
    }
}
