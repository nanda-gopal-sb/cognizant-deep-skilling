public class TaskManagementSystemDemo {
    public static void main(String[] args) {
        TaskLinkedList tasks = new TaskLinkedList();
        tasks.addTask(new Task(1, "Design UI", "Pending"));
        tasks.addTask(new Task(2, "Build API", "In Progress"));

        System.out.println(tasks.searchTask(2));
        tasks.traverseTasks();
        tasks.deleteTask(1);
        tasks.traverseTasks();
    }
}
