import java.io.Serializable;

public class Zoo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String type;
	private String family;

	public Zoo(String type, String family) {
		this.type = type;
		this.family = family;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Override
	public String toString() {
		return "gatunek='" + type + '\'' + ", rodzina='" + family + '\'';
	}
}
