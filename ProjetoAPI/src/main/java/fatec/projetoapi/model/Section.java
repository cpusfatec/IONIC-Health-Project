package fatec.projetoapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_sections") 
public class Section {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String section;		
	
	@Column(nullable = false)
	private String path;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="document_id")
	private Document document;

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	

	
	

	
}
	