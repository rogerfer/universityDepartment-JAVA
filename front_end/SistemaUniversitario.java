package front_end;
import java.util.ArrayList;
import java.util.Date;
import back_end.*;
import java.util.List;

public class SistemaUniversitario {
    // Lista estática para armazenar cursos do sistema universitario
	
	
    static List<Curso> cursos = new ArrayList<>();
    static Admnistrador admnistrador = new Admnistrador();

    // Ponto de entrada do programa
    public static void main(String[] args) {
        // Criar a instância da classe Amdnistrador

        // Criar 2 professores   
    /*     Professor prof1 = new Professor("António Ferreira", 1, new Date());
        Professor prof2 = new Professor("Carla Andrade", 2, new Date());

        // Adicionar professores ao sistema usando o Admnistrador
        admnistrador.adicionarProfessor(prof1);
        admnistrador.adicionarProfessor(prof2);

        // Criar 2 cursos com os directores de curso associados (professores)
        Curso curso1 = new Curso("Sistemas Distribuidos", prof1);
        Curso curso2 = new Curso("Fisica", prof2);

        // Adiciona cursos ao sistema usando o Admnistrador
        admnistrador.adicionarCurso(curso1);
        admnistrador.adicionarCurso(curso2);
        */

    

        // Cria uma interface de linha de comando com o Admnistrador
        CommandLineInterface cli = new CommandLineInterface(admnistrador);

        // Executa a interface da linha de comandos para interagir com o sistema 
        cli.run();
    }

    // Método para obter um curso por sua designacao
    public static Curso getCurso(String cursoDesignacao) {
        for (Curso curso : cursos) { //for-each
            if (curso.getDesignacao().equalsIgnoreCase(cursoDesignacao)) {
                return curso;
            }
        }
        return null; // Curso não encontrado
    }

    // Método para encontrar a lista de todos os cursos no sistema 
    public static List<Curso> getCurso() {
        return cursos;
    }
    
   

	public void adicionarCurso(Curso curso) {
		cursos.add(curso);
		
	}


}
