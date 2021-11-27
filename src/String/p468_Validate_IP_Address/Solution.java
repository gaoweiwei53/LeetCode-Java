package p468_Validate_IP_Address;

public class Solution {
    public String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        } else if (isIPv6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }

    }
    private boolean isIPv4(String IP){
        if(IP.startsWith(".") || IP.endsWith(".")){
            return false;
        }
        String[] splits = IP.split("\\.");
        if (splits.length != 4) {
            return false;
        }
        for (String s : splits) {
            if (s.equals("")) {
                return false;
            }
            if(s.length() > 3){
                return false;
            }
            if(s.length() != 1 && s.startsWith("0")){
                return false;
            }
            int num = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c < '0' || c > '9') {
                    return false;
                }
                num = num * 10 + c - '0';
            }
            if(num > 255){
                return false;
            }
        }
        return true;

    }
    private boolean isIPv6(String IP){
        if(IP.startsWith(":") || IP.endsWith(":")){
            return false;
        }
        String[] splits = IP.split(":");
        if (splits.length != 8) {
            return false;
        }
        for (String s : splits) {
            if (s.equals("")) {
                return false;
            }
            if(s.length() > 4){
                return false;
            }
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c < '0' || c > '9' && c < 'A' || c > 'F' && c < 'a' || c > 'f'){
                    return false;
                }

            }
        }
        return true;
    }
}
