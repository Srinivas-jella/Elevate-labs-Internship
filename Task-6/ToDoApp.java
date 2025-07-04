import javax.swing.*;

public class ToDoApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("ToDoApp");
        frame.setSize(400, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        
        JTextField textField = new JTextField();
        textField.setBounds(50, 30, 300, 30);
        frame.add(textField);

        
        JButton addButton = new JButton("Add Task");
        addButton.setBounds(50, 80, 120, 40);
        frame.add(addButton);

       
        JButton deleteButton = new JButton("Delete Task");
        deleteButton.setBounds(230, 80, 120, 40);
        frame.add(deleteButton);

     
        DefaultListModel<String> taskListModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(50, 140, 300, 250);
        frame.add(scrollPane);

      
        JButton clearAllButton = new JButton("Clear All");
        clearAllButton.setBounds(130, 410, 120, 30);
        frame.add(clearAllButton);

      
        JLabel countLabel = new JLabel("Total Tasks: 0");
        countLabel.setBounds(150, 450, 150, 30);
        frame.add(countLabel);

        
        addButton.addActionListener(e -> {
            String task = textField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                textField.setText("");
                countLabel.setText("Total Tasks: " + taskListModel.size());
            }
        });

        
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
                countLabel.setText("Total Tasks: " + taskListModel.size());
            }
        });

       
        clearAllButton.addActionListener(e -> {
            if (!taskListModel.isEmpty()) {
                taskListModel.clear();
                countLabel.setText("Total Tasks: 0");
            }
        });

        frame.setVisible(true);
    }
}
