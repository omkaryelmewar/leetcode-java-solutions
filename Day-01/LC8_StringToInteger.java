
    class Solution
     {
        public int myAtoi(String s) {
            s = s.trim(); // removes frond and end spaces 
            if(s.isEmpty()){
                return 0;
            }
            int n = s.length();
            int i = 0;
            int sign = 1; // initially +ve sign
            long num = 0;
            if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                sign = (s.charAt(i)=='-') ? -1 : 1;
                i++;
            }
            while(i < n && Character.isDigit(s.charAt(i))){
                num = num * 10 + (s.charAt(i)-'0');
                if(num * sign > Integer.MAX_VALUE){  //overflow check
                    return Integer.MAX_VALUE;
                }
                if(num * sign < Integer.MIN_VALUE){ // negative overflow check
                    return Integer.MIN_VALUE;
                }
                i++;
            }
            return (int)(num*sign);
        }
}

