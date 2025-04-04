import java.util.*;

public class SecurityFireWall {
    public static void logTraffic(String appName, String destIp, int port, String protocol, long bytesSent, long bytesReceived) {
        String log = String.format(
                "%s | App: %s | IP: %s | Port: %d | Protocol: %s | Sent: %d | Received: %d",
                new Date(), appName, destIp, port, protocol, bytesSent, bytesReceived
        );
        System.out.println(log);

        
        sendToCentralConsole(appName, destIp, port, protocol, bytesSent, bytesReceived);
    }

    public static boolean isAnomalous(long bytesSent, long bytesReceived) {
        long thresholdSent = 100000;
        long thresholdReceived = 150000;
        return bytesSent > thresholdSent || bytesReceived > thresholdReceived;
    }

    public static void sendToCentralConsole(String app, String ip, int port, String protocol, long sent, long received) {
        
        System.out.println("Sending log to central console...");
        
    }

    public static void fetchAndApplyPolicies(String appName) {
        
        System.out.println("Fetching policy for " + appName + " from central console...");
    
        System.out.println("Policy fetched: Allow TCP, Block 123.123.123.123");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of traffic entries:");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Enter app name:");
            String app = scanner.nextLine();
            fetchAndApplyPolicies(app);

            System.out.println("Enter destination IP:");
            String ip = scanner.nextLine();
            System.out.println("Enter port:");
            int port = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter protocol (TCP/UDP):");
            String protocol = scanner.nextLine();
            System.out.println("Enter bytes sent:");
            long sent = scanner.nextLong();
            System.out.println("Enter bytes received:");
            long recv = scanner.nextLong();
            scanner.nextLine();

            logTraffic(app, ip, port, protocol, sent, recv);
            boolean anomaly = isAnomalous(sent, recv);
            System.out.println("Sample " + (i + 1) + ": " + (anomaly ? "🚨 Anomaly" : "✅ Normal"));
        }
    }
}

class TrafficLog {
    public String appName;
    public String destIp;
    public int port;
    public String protocol;
    public long bytesSent;
    public long bytesReceived;

    @Override
    public String toString() {
        return appName + " | " + destIp + ":" + port + " | " + protocol + " | Sent: " + bytesSent + ", Received: " + bytesReceived;
    }
}

class FirewallPolicy {
    public String appName;
    public List<String> allowedDomains;
    public List<String> blockedIPs;
    public List<String> allowedProtocols;

    @Override
    public String toString() {
        return "Policy for " + appName + ":\nDomains: " + allowedDomains + "\nBlocked IPs: " + blockedIPs + "\nProtocols: " + allowedProtocols;
    }
}