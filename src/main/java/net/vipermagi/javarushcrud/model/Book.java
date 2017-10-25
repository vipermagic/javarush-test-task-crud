package net.vipermagi.javarushcrud.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    /*
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `author` VARCHAR(100) NOT NULL,
  `isbn` VARCHAR(20) NOT NULL,
  `printYear` INT NOT NULL,
  `readAlready` BIT(1) NOT NULL,*/

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "printYear")
    private int printYear;

    @Column(name = "readAlready")
    private boolean readAlready;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrintYear() {
        return printYear;
    }

    public void setPrintYear(int printYear) {
        this.printYear = printYear;
    }

    public boolean isReadAlready() {
        return readAlready;
    }

    public void setReadAlready(boolean readAlready) {
        this.readAlready = readAlready;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", printYear=" + printYear +
                ", readAlready=" + readAlready +
                '}';
    }
}
