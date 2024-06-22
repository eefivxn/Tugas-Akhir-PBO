package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Optional;

import books.Book;
import data.Admin;
import data.Student;
import data.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AdminController {
	
	private Stage stage;
	private Parent root;
	private Scene scene;

    @FXML
    private HBox data_form;

    @FXML
    private AnchorPane crudStudent_form;

    @FXML
    private TableView<Student> studenTable_fix;

    @FXML
    private TableColumn<Student, String> name_stdTableFix;

    @FXML
    private TableColumn<Student, String> nim_stdTableFix;

    @FXML
    private TableColumn<Student, String> faculty_stdTableFix;
    
    @FXML 
    private TableColumn<Student, String> major_stdTableFix;
    
    @FXML
    private TextField nameInput;

    @FXML
    private TextField nimInput;

    @FXML
    private ComboBox<String> facultyCbox;

    @FXML
    private ComboBox<String> majorCbox;

    @FXML
    private TableView<Student> studentTable_temporary;

    @FXML
    private TableColumn<Student, String> name_stdTableTemp;

    @FXML
    private TableColumn<Student, String> nim_stdTableTemp;

    @FXML
    private TableColumn<Student, String> faculty_stdTableTemp;

    @FXML
    private TableColumn<Student, String> major_stdTableTemp;
    
    @FXML
    private Button addTempStudent_btn;

    @FXML
    private Button addAllStudent_btn;

    @FXML
    private Button deleteAllStudent_btn;

    @FXML
    private Button chooseDeleteStudent_btn;

    @FXML
    private ComboBox<Student> chooseStudent_cBox;

    @FXML
    private Button deleteChoosenStudent_btn;
    
    @FXML 
    private AnchorPane deletStd_form;
    
    @FXML
    private TableView<Student> tempDeleteStudent_table;
    
    @FXML
    private TableColumn<Student, String> dForm_nama_column;
    
    @FXML
    private TableColumn<Student, String> dForm_nim_column;
    
    @FXML
    private TableColumn<Student, String> dForm_fakultas_column;
    
    @FXML
    private TableColumn<Student, String> dForm_major_column;
    
    @FXML
    private ComboBox<Student> pilihNim_cBox;
    
    @FXML
    private Button dForm_addTempStd_btn;
    
    @FXML
    private Button dForm_deleteStd_btn;
    
    @FXML
    private Button cancelAll_btn;
    
    @FXML
    private Button cancelStd_btn;
    
    @FXML
    private ComboBox<Student> chooseCancelStudent_cBox;
    
    @FXML
    private Button fixCancel_btn;
    
    @FXML
    private AnchorPane stdMenu_form;
 
    @FXML
    private AnchorPane crudBook_form;
    
    @FXML
    private Group addStudent_group;
    
    @FXML
    private Group deleteStudent_group;

    @FXML
    private TableView<Book> booksTable_fix;

    @FXML
    private TableColumn<Book, String> id_bkTablefix;

    @FXML
    private TableColumn<Book, String> title_bkTablefix;

    @FXML
    private TableColumn<Book, String> author_bkTablefix;

    @FXML
    private TableColumn<Book, String> kategori_bkTablefix;

    @FXML
    private TableColumn<Book, Integer> stock_bkTablefix;
    
    @FXML
    private TextField bookId_input;

    @FXML
    private TextField bookAuthor_input;

    @FXML
    private ComboBox<String> bookCategory_input;

    @FXML
    private TableView<Book> bookTable_temp;

    @FXML
    private TableColumn<Book, String> id_bkTableTemp;

    @FXML
    private TableColumn<Book, String> title_bkTableTemp;

    @FXML
    private TableColumn<Book, String> author_bkTableTemp;

    @FXML
    private TableColumn<Book, String> kategori_bkTableTemp;
    
    @FXML
    private TableColumn<Book, Integer> stock_bkTableTemp;

    @FXML
    private TextField bookTitle_input;

    @FXML
    private TextField stockBook_input;

    @FXML
    private ComboBox<Book> chooseBook_cBox;

    @FXML
    private Button deleteChoosenBook_btn;

    @FXML
    private Button chooseDeleteBook_btn;

    @FXML
    private Button deleteAllBook_btn;

    @FXML
    private Button addAllBook_btn;

    @FXML
    private Button addTempBook_btn;
    
    @FXML
    private AnchorPane deleteBook_form;
    
    @FXML
    private ComboBox<Book> dForm_pilihBuku_cBox;
    
    @FXML
    private Button dForm_addTempBk_btn;
    
    @FXML 
    private TableView<Book> dForm_tempTableBook;
    
    @FXML
    private TableColumn<Book, String> dForm_idTemp_column;
    
    @FXML
    private TableColumn<Book, String> dForm_judulTemp_column;
    
    @FXML
    private TableColumn<Book, String> dForm_authorTemp_column;
    
    @FXML
    private TableColumn<Book, String> dForm_kategori_column;
    
    @FXML
    private TableColumn<Book, String> dForm_stockTemp_column;
    
    @FXML
    private Button dForm_deleteAllBk_btn;
    
    @FXML
    private Button dForm_cancelAllBk_btn;
    
    @FXML
    private Button dForm_cancelBk_btn;
    
    @FXML
    private Button dFormFixCancel_btn;
    
    @FXML
    private ComboBox<Book> dFormChooseToCancel_cBox;
    
    @FXML
    private Button crudStudents_btn;

    @FXML
    private Button crudBooks_btn;

    @FXML
    private Button home_btn;
    
    @FXML
    private AnchorPane bookMenu_form;

    private ObservableList<Student> addTempStudents = FXCollections.observableArrayList();
    private ObservableList<Book> addTempBooks = FXCollections.observableArrayList();
    
    private ObservableList<Student> deleteTempStudents = FXCollections.observableArrayList();
    private ObservableList<Book> deleteTempBooks = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
    	ObservableList<Student> student = FXCollections.observableArrayList(Admin.getStudentList());
    	ObservableList<Book> books = FXCollections.observableArrayList(User.getBookList());
        // Set up the columns in the studentTable_fix
        name_stdTableFix.setCellValueFactory(new PropertyValueFactory<>("name"));
        nim_stdTableFix.setCellValueFactory(new PropertyValueFactory<>("nim"));
        faculty_stdTableFix.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        major_stdTableFix.setCellValueFactory(new PropertyValueFactory<>("programStudi"));

        // Set up the columns in the booksTable_fix
        id_bkTablefix.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        title_bkTablefix.setCellValueFactory(new PropertyValueFactory<>("title"));
        author_bkTablefix.setCellValueFactory(new PropertyValueFactory<>("author"));
        kategori_bkTablefix.setCellValueFactory(new PropertyValueFactory<>("category"));
        stock_bkTablefix.setCellValueFactory(new PropertyValueFactory<>("stock"));

        // Set up the columns in the temporary student table
        name_stdTableTemp.setCellValueFactory(new PropertyValueFactory<>("name"));
        nim_stdTableTemp.setCellValueFactory(new PropertyValueFactory<>("nim"));
        faculty_stdTableTemp.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        major_stdTableTemp.setCellValueFactory(new PropertyValueFactory<>("programStudi"));

        // Set up the columns in the temporary book table
        id_bkTableTemp.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        title_bkTableTemp.setCellValueFactory(new PropertyValueFactory<>("title"));
        author_bkTableTemp.setCellValueFactory(new PropertyValueFactory<>("author"));
        kategori_bkTableTemp.setCellValueFactory(new PropertyValueFactory<>("category"));
        stock_bkTableTemp.setCellValueFactory(new PropertyValueFactory<>("stock"));
        
        dForm_nama_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        dForm_nim_column.setCellValueFactory(new PropertyValueFactory<>("nim"));
        dForm_fakultas_column.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        dForm_major_column.setCellValueFactory(new PropertyValueFactory<>("programStudi"));
        
        dForm_idTemp_column.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        dForm_judulTemp_column.setCellValueFactory(new PropertyValueFactory<>("title"));
        dForm_authorTemp_column.setCellValueFactory(new PropertyValueFactory<>("author"));
        dForm_kategori_column.setCellValueFactory(new PropertyValueFactory<>("category"));
        dForm_stockTemp_column.setCellValueFactory(new PropertyValueFactory<>("stock"));


        // Populate ComboBoxes with example data
        facultyCbox.setItems(FXCollections.observableArrayList("Science", "Engineering", "Arts"));
        majorCbox.setItems(FXCollections.observableArrayList("Physics", "Computer Science", "Fine Arts"));
        bookCategory_input.setItems(FXCollections.observableArrayList("Fiction", "Non-Fiction", "Science", "Art"));
        
        pilihNim_cBox.setItems(student);
        dForm_pilihBuku_cBox.setItems(books);
        studenTable_fix.setItems(student);
        booksTable_fix.setItems(books);
        
    }
    
    @FXML
    private void handleMouseClickAddBook(MouseEvent e) {
    	bookMenu_form.setVisible(false);
    	deleteBook_form.setVisible(false);
    	crudBook_form.setVisible(true);
    }
    
    @FXML
    private void handleMouseClickDeleteBook(MouseEvent e) {
    	bookMenu_form.setVisible(false);
    	deleteBook_form.setVisible(true);
    	crudBook_form.setVisible(true);
    }
    
    @FXML
    private void handleMouseClickAddStd(MouseEvent e) {
    	stdMenu_form.setVisible(false);
    	deletStd_form.setVisible(false);
    	crudStudent_form.setVisible(true);
    }
    
    @FXML
    private void handleMouseClickDeleteStd(MouseEvent e) {
    	stdMenu_form.setVisible(false);
    	deletStd_form.setVisible(true);
    	crudStudent_form.setVisible(true);
    }

    @FXML
    private void switchForm(ActionEvent e) {
        if (e.getSource() == home_btn) {
            home_btn.setStyle("-fx-background-color: #471069");
            crudStudents_btn.setStyle("-fx-background-color: transparent");
            crudBooks_btn.setStyle("-fx-background-color: transparent");

            data_form.setVisible(true);
            crudStudent_form.setVisible(false);
            crudBook_form.setVisible(false);
        } else if (e.getSource() == crudStudents_btn) {
            crudStudents_btn.setStyle("-fx-background-color: #471069");
            home_btn.setStyle("-fx-background-color: transparent");
            crudBooks_btn.setStyle("-fx-background-color: transparent");

            data_form.setVisible(false);
            crudStudent_form.setVisible(true);
            deletStd_form.setVisible(true);
            stdMenu_form.setVisible(true);
            crudBook_form.setVisible(false);
        } else if (e.getSource() == crudBooks_btn) {
            crudBooks_btn.setStyle("-fx-background-color: #471069");
            crudStudents_btn.setStyle("-fx-background-color: transparent");
            home_btn.setStyle("-fx-background-color: transparent");

            data_form.setVisible(false);
            crudStudent_form.setVisible(true);
            crudBook_form.setVisible(true);
            deleteBook_form.setVisible(true);
            bookMenu_form.setVisible(true);
        }
    }

    @FXML
    private void addTempStudent(ActionEvent event) {
        String name = nameInput.getText();
        String nim = nimInput.getText();
        String faculty = facultyCbox.getValue();
        String major = majorCbox.getValue();

        if (name.isEmpty() || nim.isEmpty() || faculty == null || major == null) {
            return;
        }

        Student student = new Student(name, nim, faculty, major, "", "");
        addTempStudents.add(student);
        studentTable_temporary.setItems(addTempStudents);
        chooseStudent_cBox.setItems(addTempStudents);
        clearStudentForm();
    }
    
    @FXML
    private void addTempStudentDform(ActionEvent event) {
        Student student = pilihNim_cBox.getValue();

        if (student == null) {
            return;
        }

        deleteTempStudents.add(student);
        tempDeleteStudent_table.setItems(deleteTempStudents);
        chooseCancelStudent_cBox.setItems(deleteTempStudents);
        pilihNim_cBox.setValue(null);
    }

    @FXML
    private void addAllStudents(ActionEvent event) {
        for (Student student : addTempStudents) {
            Admin.addStudentList(student);
        }
        addTempStudents.clear();
        studentTable_temporary.setItems(addTempStudents);
        chooseStudent_cBox.setItems(addTempStudents);
        refreshStudentTable();
    }
    
    @FXML
    private void deleteAllStudentsDform(ActionEvent event) {
        for (Student student : addTempStudents) {
            Admin.getStudentList().remove(student);
        }
        deleteTempStudents.clear();
        tempDeleteStudent_table.setItems(deleteTempStudents);
        chooseCancelStudent_cBox.setItems(deleteTempStudents);
        refreshStudentTable();
    }

    private void refreshStudentTable() {
        studenTable_fix.setItems(Admin.getStudentList());
        pilihNim_cBox.setItems(Admin.getStudentList());
    }
    
    @FXML
    private void cancelAllStudents(ActionEvent event) {
    	deleteTempStudents.clear();
        tempDeleteStudent_table.setItems(deleteTempStudents);
        chooseCancelStudent_cBox.setItems(deleteTempStudents);
    }
    
    @FXML
    private void deleteAllStudents(ActionEvent event) {
    	addTempStudents.clear();
    	studentTable_temporary.setItems(addTempStudents);
    	chooseStudent_cBox.setItems(addTempStudents);
    }
    
    @FXML
    private void chooseCancelStudent(ActionEvent event) {
    	chooseCancelStudent_cBox.setVisible(true);
    	fixCancel_btn.setVisible(true);
    }
    
    @FXML
    private void chooseDeleteStudent(ActionEvent event) {
    	chooseStudent_cBox.setVisible(true);
    	deleteChoosenStudent_btn.setVisible(true);
    }

    @FXML
    private void deleteSelectedStudent(ActionEvent event) {
        Student selectedStudent = studentTable_temporary.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            addTempStudents.remove(selectedStudent);
            studentTable_temporary.setItems(addTempStudents);
            chooseStudent_cBox.setItems(addTempStudents);
            chooseStudent_cBox.setVisible(false);
        	deleteChoosenStudent_btn.setVisible(false);
        }
    }
    
    @FXML
    private void cancelSelectedStudent(ActionEvent event) {
        Student selectedStudent =  tempDeleteStudent_table.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            deleteTempStudents.remove(selectedStudent);
            tempDeleteStudent_table.setItems(deleteTempStudents);
            chooseCancelStudent_cBox.setItems(deleteTempStudents);
            chooseCancelStudent_cBox.setVisible(true);
        	fixCancel_btn.setVisible(true);
        }
    }
    
    private void refreshBooksTable() {
        booksTable_fix.setItems(User.getBookList());
        dForm_pilihBuku_cBox.setItems(User.getBookList());
    }

    @FXML
    private void addTempBook(ActionEvent event) {
        String bookId = bookId_input.getText();
        String title = bookTitle_input.getText();
        String author = bookAuthor_input.getText();
        String category = bookCategory_input.getValue();
        int stock;

        try {
            stock = Integer.parseInt(stockBook_input.getText());
        } catch (NumberFormatException e) {
            // Show error message (implementation not shown)
            return;
        }

        if (bookId.isEmpty() || title.isEmpty() || author.isEmpty() || category == null || stock <= 0) {
            // Show error message (implementation not shown)
            return;
        }

        Book book = new Book(stock, author, bookId, title);
        book.setCategory(category);
        addTempBooks.add(book);
        bookTable_temp.setItems(addTempBooks);
        chooseBook_cBox.setItems(addTempBooks);
        clearBookForm();
    }
    
    @FXML
    private void addTempBookDform(ActionEvent event) {
        
        Book book = dForm_pilihBuku_cBox.getValue();
       

        if (book == null) {
            // Show error message (implementation not shown)
            return;
        }
        
        deleteTempBooks.add(book);
        dForm_tempTableBook.setItems(deleteTempBooks);
        dFormChooseToCancel_cBox.setItems(deleteTempBooks);
        clearBookForm();
    }
    
    @FXML
    private void chooseCancelBook(ActionEvent event) {
    	dFormChooseToCancel_cBox.setVisible(true);
    	dFormFixCancel_btn.setVisible(true);
    }
    
    @FXML
    private void chooseDeleteBook(ActionEvent event) {
    	chooseBook_cBox.setVisible(true);
    	deleteChoosenBook_btn.setVisible(true);
    }

    @FXML
    private void addAllBooks(ActionEvent event) {
        for (Book book : addTempBooks) {
            User.addBookList(book);
        }
        addTempBooks.clear();
        bookTable_temp.setItems(addTempBooks);
        chooseBook_cBox.setItems(addTempBooks);
        refreshBooksTable();
        // Refresh the main book table (implementation not shown)
    }
    
    @FXML
    private void deleteAllBooksDform(ActionEvent event) {
        for (Book book : deleteTempBooks) {
            User.getBookList().remove(book);
        }
        deleteTempBooks.clear();
        dForm_tempTableBook.setItems(deleteTempBooks);
        dFormChooseToCancel_cBox.setItems(deleteTempBooks);
        refreshBooksTable();
        // Refresh the main book table (implementation not shown)
    }
    
    @FXML
    private void cancelAllBooks(ActionEvent event) {
    	deleteTempBooks.clear();
        dForm_tempTableBook.setItems(deleteTempBooks);
        dFormChooseToCancel_cBox.setItems(deleteTempBooks);
    }

    @FXML
    private void deleteAllBooks(ActionEvent event) {
        addTempBooks.clear();
        bookTable_temp.setItems(addTempBooks);
        chooseBook_cBox.setItems(addTempBooks);
    }

    @FXML
    private void deleteSelectedBook(ActionEvent event) {
        Book selectedBook = chooseBook_cBox.getValue();;
        if (selectedBook != null) {
            addTempBooks.remove(selectedBook);
            bookTable_temp.setItems(addTempBooks);
            chooseBook_cBox.setItems(addTempBooks);
            chooseBook_cBox.setVisible(false);
        	deleteChoosenBook_btn.setVisible(false);
        }
    }
    
    @FXML
    private void cancelSelectedBook(ActionEvent event) {
        Book selectedBook = dFormChooseToCancel_cBox.getValue();
        if (selectedBook != null) {
            deleteTempBooks.remove(selectedBook);
            dForm_tempTableBook.setItems(deleteTempBooks);
            dFormChooseToCancel_cBox.setItems(deleteTempBooks);
            dFormChooseToCancel_cBox.setVisible(false);
        	dFormFixCancel_btn.setVisible(false);
        }
    }
    
    @FXML
    private void logout(ActionEvent event) {
        // Create an alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText("You are about to logout!");
        alert.setContentText("Are you sure you want to logout?");

        // Capture the user's response
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setFullScreen(true);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void clearStudentForm() {
        nameInput.clear();
        nimInput.clear();
        facultyCbox.setValue(null);
        majorCbox.setValue(null);
    }

    private void clearBookForm() {
        bookId_input.clear();
        bookTitle_input.clear();
        bookAuthor_input.clear();
        bookCategory_input.setValue(null);
        stockBook_input.clear();
    }
}
