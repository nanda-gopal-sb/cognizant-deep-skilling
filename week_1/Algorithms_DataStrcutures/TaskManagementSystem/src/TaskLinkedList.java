public class TaskLinkedList {
    private TaskNode head;
    private TaskNode tail;

    public void addTask(Task task) {
        TaskNode node = new TaskNode(task);
        if (head == null) {
            head = tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public Task searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public boolean deleteTask(int taskId) {
        TaskNode current = head;
        TaskNode previous = null;

        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                if (current == tail) {
                    tail = previous;
                }
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }
}
