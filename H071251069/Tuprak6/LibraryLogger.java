import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private List<String> logs;
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LibraryLogger() {
        this.logs = new ArrayList<>();
    }

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String entry = timestamp + " " + activity;
        logs.add(entry);
        return entry;
    }

    public String getLogs() {
        if (logs.isEmpty()) return "Tidak ada log aktivitas";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < logs.size(); i++) {
            sb.append(logs.get(i));
            if (i < logs.size() - 1) sb.append("\n");
        }
        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
    }

    public List<String> getRawLogs() { return logs; }
}
