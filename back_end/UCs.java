package back_end;
import java.util.ArrayList;
import java.util.List;

public class UCs {
	private String designacao;
	private Professor regenteUc;
	private List<LicaoSumario> sumarios = new ArrayList<>();

	// Constructor para inicializar uma designacao e um regente 
	public UCs(String designacao, Professor regenteUc) {
		this.designacao = designacao;
		this.regenteUc = regenteUc;
	}

	// Metodo para adicionar sumario a lista de resumos de aula na uc
	public void adicionaSumario(LicaoSumario sumario) {
		sumarios.add(sumario);
	}

	// Setter para definir o regente da disciplina 
	public void setRegenteUc(Professor regenteUc) {
		this.regenteUc = regenteUc;
	}

	// Getter para recuperar a designacao do assunto
	public String getDesignacao() {
		return designacao;
	}

	// Getter para recuperar o regente da disicplina 
	public Professor getRegenteUc() {
		return regenteUc;
	}

	// Getter para recuperar a lista de resumos das aulas da uc
	public List<LicaoSumario> getSumarios() {
		return sumarios;
	}

	// Override toString para fornecer uma representacao de string da UC
	@Override
	public String toString() {
		return "UC{" +
				"designacao='" + designacao + '\'' +
				", regenteUC=" + regenteUc +
				", sumario=" + sumarios +
				'}';
	}

    void adicionarUCs(UCs ucs) {
        //nao esta a funcionar ainda
    }
}
