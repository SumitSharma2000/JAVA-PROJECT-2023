import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;


class Note implements Serializable {
    private String title;
    private String content;
    private String category;

    public Note(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }
}

public class NoteAppFrame extends JFrame {
    private JTextArea noteTextArea;
    private JComboBox<String> categoryComboBox;
    private ArrayList<Note> notes;

    public NoteAppFrame() {
        setTitle("JavaNote - Note Taking Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        notes = new ArrayList<>();

        noteTextArea = new JTextArea();
        categoryComboBox = new JComboBox<>();

        JButton createButton = new JButton("Create");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        JButton saveButton = new JButton("Save");

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(createButton);
        controlPanel.add(editButton);
        controlPanel.add(deleteButton);
        controlPanel.add(saveButton);
        controlPanel.add(categoryComboBox);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNote();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editNote();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteNote();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveNotes();
            }
        });

        add(controlPanel, BorderLayout.NORTH);
        add(new JScrollPane(noteTextArea), BorderLayout.CENTER);

        loadNotes();
    }

    private void loadNotes() {
        try {
            FileInputStream fileIn = new FileInputStream("notes.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            notes = (ArrayList<Note>) in.readObject();
            in.close();
            fileIn.close();
            populateCategoryComboBox();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void saveNotes() {
        try {
            FileOutputStream fileOut = new FileOutputStream("notes.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(notes);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void createNote() {
        String title = JOptionPane.showInputDialog(this, "Enter note title:");
        if (title == null || title.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Title cannot be empty.");
            return;
        }
        String content = noteTextArea.getText();
        String category = categoryComboBox.getSelectedItem() != null ? categoryComboBox.getSelectedItem().toString() : "";

        Note note = new Note(title, content, category);
        notes.add(note);
        populateCategoryComboBox();
        saveNotes();

        noteTextArea.setText("");
        JOptionPane.showMessageDialog(this, "Note created successfully!");
    }

    private void editNote() {
        int selectedNoteIndex = categoryComboBox.getSelectedIndex();

        if (selectedNoteIndex >= 0) {
            Note selectedNote = notes.get(selectedNoteIndex);
            selectedNote.setContent(noteTextArea.getText());
            saveNotes();
            JOptionPane.showMessageDialog(this, "Note edited successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "No note selected.");
        }
    }

    private void deleteNote() {
        int selectedNoteIndex = categoryComboBox.getSelectedIndex();

        if (selectedNoteIndex >= 0) {
            notes.remove(selectedNoteIndex);
            populateCategoryComboBox();
            saveNotes();
            noteTextArea.setText("");
            JOptionPane.showMessageDialog(this, "Note deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "No note selected.");
        }
    }

    private void populateCategoryComboBox() {
        categoryComboBox.removeAllItems();
        for (Note note : notes) {
            categoryComboBox.addItem(note.getTitle());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new NoteAppFrame();
            frame.setVisible(true);
        });
    }
}
