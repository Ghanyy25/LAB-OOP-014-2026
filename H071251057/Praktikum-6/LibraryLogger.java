import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;
import java.util.ArrayList; 
import java.util.List;

class LibraryLogger {
    private List<String> logs = new ArrayList<>();

    public String logActivity(String title, String member, boolean returned){ 
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
        String time = LocalDateTime.now().format(format); 

        String log; 

        if (!returned){ //blm d kmbalikan
            log = String.format ("| %-20s| %-21s| %-12s | %-19s |", time, title, member, "-");
        } else { //yg sdh d kmbalikn
            log = String.format ("| %-20s| %-21s| %-12s | %-19s |", "-", title, member, time);
        }

        logs.add(log); 
        return log;
    }

    public String getLogs(){
        StringBuilder sb = new StringBuilder(); 
                                                                                                          
        sb.append("+---------------------+----------------------+--------------+---------------------+\n");
        sb.append("| Dipinjam pada       | Judul                | Member       | Dikembalikan pada   |\n");
        sb.append("+---------------------+----------------------+--------------+---------------------+\n");
        
        for (String log : logs) { 
            sb.append(log).append("\n"); 
        }
        sb.append("+---------------------+----------------------+--------------+---------------------+\n");
        return sb.toString();
    }

    public void clearLogs(){ 
        logs.clear(); 
    }
}