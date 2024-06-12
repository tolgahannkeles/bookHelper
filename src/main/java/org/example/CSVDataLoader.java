package org.example;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class CSVDataLoader {

    String root = "C:\\Users\\tolga\\Desktop\\bookHelper\\src\\main\\java\\org\\example\\";
    DatabaseTransactions db;

    public CSVDataLoader() throws SQLException {
        db = new DatabaseTransactions();
    }

    public void loadAuthorFromCSV() throws IOException {
        String filePath = root + "books raw data - author.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // İlk satırı atla (başlık satırı olduğunu varsayıyoruz)
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                String id = nextLine[0];
                String name = nextLine[1];
                String surname = nextLine[2];
                String biography = nextLine[3];
                String imageLink = nextLine[4];
                db.insertAuthors(Integer.parseInt(id), name, surname, biography, imageLink);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    public void loadBookFromCSV() throws IOException {
        String filePath = root + "books raw data - book.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // İlk satırı atla (başlık satırı olduğunu varsayıyoruz)
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                String authorId = nextLine[0];
                String publisherId = nextLine[1];
                String languageId = nextLine[2];
                String name = nextLine[3];
                String description = nextLine[4];
                String isbn = nextLine[5];
                String imageLink = nextLine[6];
                String releaseYear = nextLine[7];
                String pageCount = nextLine[8];
                db.insertBooks(authorId, publisherId, languageId, name, description, isbn, imageLink, releaseYear, Integer.parseInt(pageCount));
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    public void loadCategoriesFromCSV() throws IOException {
        String filePath = root + "books raw data - category.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // İlk satırı atla (başlık satırı olduğunu varsayıyoruz)
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                String id = nextLine[0];
                String name = nextLine[1];
                String imageLink = nextLine[2];
                db.insertCategories(Integer.parseInt(id), name, imageLink);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    public void loadCategoryJuncFromCSV() throws IOException {
        String filePath = root + "books raw data - categoryJunction.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // İlk satırı atla (başlık satırı olduğunu varsayıyoruz)
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                String bookId = nextLine[0];
                String categoryId = nextLine[1];
                db.insertCategoryJun(Integer.parseInt(bookId),Integer.parseInt(categoryId));
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    public void loadTypeJuncFromCSV() throws IOException {
        String filePath = root + "books raw data - typeJunction.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // İlk satırı atla (başlık satırı olduğunu varsayıyoruz)
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                String bookId = nextLine[0];
                String typeId = nextLine[1];
                db.insertTypeJun(Integer.parseInt(bookId),Integer.parseInt(typeId));
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            throw e;
        }
    }


    public void loadTypeFromCSV() throws IOException {
        String filePath = root + "books raw data - type.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // İlk satırı atla (başlık satırı olduğunu varsayıyoruz)
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                String id = nextLine[0];
                String name = nextLine[1];
                db.insertTypes(Integer.parseInt(id), name);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    public void loadPublisherFromCSV() throws IOException {
        String filePath = root + "books raw data - publisher.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // İlk satırı atla (başlık satırı olduğunu varsayıyoruz)
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                String id = nextLine[0];
                String name = nextLine[1];
                db.insertPublishers(Integer.parseInt(id), name);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    public void loadLanguageFromCSV() throws IOException {
        String filePath = root + "books raw data - language.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // İlk satırı atla (başlık satırı olduğunu varsayıyoruz)
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                String id = nextLine[0];
                String language = nextLine[1];
                db.insertLanguages(Integer.parseInt(id), language);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    public void loadCategoryJunctionFromCSV() throws IOException {
        String filePath = root + "books raw data - categoryJunction.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // İlk satırı atla (başlık satırı olduğunu varsayıyoruz)
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                String bookId = nextLine[0];
                String categoryId = nextLine[1];
                System.out.println(bookId + categoryId);
                db.insertCategoryJun(Integer.parseInt(bookId),Integer.parseInt(categoryId));
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            throw e;
        }
    }



}
