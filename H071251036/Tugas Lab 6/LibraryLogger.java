import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class LibraryLogger {
    private List<String> logs = new ArrayList<>();

    public void logBorrow(String type, String memberName) {
        addLog("[" + type + "] dipinjam oleh " + memberName);
    }

    public void logReturn(String type, String memberName) {
        addLog("[" + type + "] dikembalikan oleh " + memberName);
    }

    private void addLog(String activity) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = LocalDateTime.now().format(formatter);
        logs.add(time + " " + activity);
    }

    public String getLogs() {
        if (logs.isEmpty()) return "Belum ada log";
        StringBuilder sb = new StringBuilder();
        for (String log : logs) {
            sb.append(log).append("\n");
        }
        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
    }
}