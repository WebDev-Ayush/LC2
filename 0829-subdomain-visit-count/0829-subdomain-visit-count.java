import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainCount = new HashMap<>();
        
        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split(" ");
            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];
            
            String[] subdomains = domain.split("\\.");
            StringBuilder currentDomain = new StringBuilder();
            
            for (int i = subdomains.length - 1; i >= 0; i--) {
                if (i != subdomains.length - 1) {
                    currentDomain.insert(0, ".");
                }
                currentDomain.insert(0, subdomains[i]);
                
                String subdomain = currentDomain.toString();
                domainCount.put(subdomain, domainCount.getOrDefault(subdomain, 0) + count);
            }
        }
        
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        
        return result;
    }
}
