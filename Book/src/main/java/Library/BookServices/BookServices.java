package Library.BookServices;

import Library.BookDomain.Book;
import Library.BookRepository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {


    @Autowired
    private BookRepository repository;




    public ResponseEntity<List<Book>> getBook() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<Book> getBookById(Long id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }

    public void deleteBook() {
        repository.deleteAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ResponseEntity<Book> addNewBook(Book book) {
        return ResponseEntity.ok(repository.save(book));
    }

    public ResponseEntity<Book> updateBook(Long id, Book updated) {
        Book book = repository.findById(id).get();
        book.setDescription(updated.getDescription());
        book.setTitle(updated.getTitle());

        return ResponseEntity.ok(repository.save(book));
    }




}





