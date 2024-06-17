/*package edu.eafit.katio.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Books")
public class Books {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Name;
    private String ISBN10;
    private String ISBN13;
    private Date Published;
    private String Edition;
    private String DeweyIndex;
    private long AuthorId;


    // Getters and Setters
    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getISBN10() {
        return ISBN10;
    }
    public void setISBN10(String iSBN10) {
        ISBN10 = iSBN10;
    }
    public String getISBN13() {
        return ISBN13;
    }
    public void setISBN13(String iSBN13) {
        ISBN13 = iSBN13;
    }
    public Date getPublished() {
        return Published;
    }
    public void setPublished(Date published) {
        Published = published;
    }
    public String getEdition() {
        return Edition;
    }
    public void setEdition(String edition) {
        Edition = edition;
    }
    public String getDeweyIndex() {
        return DeweyIndex;
    }
    public void setDeweyIndex(String deweyIndex) {
        DeweyIndex = deweyIndex;
    }
    public long getAuthorId() {
        return AuthorId;
    }
    public void setAuthorId(long authorId) {
        AuthorId = authorId;
    }


}

*/