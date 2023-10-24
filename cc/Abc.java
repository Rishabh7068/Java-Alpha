public class Abc {
    public static void main(String[] args) {
        String s = "abababababaa";// 
        int ct = 0;
       
        
        while(s.length() != 0){

        int count[] = new int[26];
        int occur[] = new int[26];
        char cha[]  = new char[26];

        // 1st element
        count[s.charAt(0) - 'a']++;
        cha[s.charAt(0) - 'a'] = s.charAt(0);
        if (s.charAt(0) != s.charAt(1)) {
            occur[s.charAt(0) - 'a']++;
        }

        // middle
        for (int i = 1; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++;
            cha[ch - 'a'] = ch;
            if (s.charAt(i) != s.charAt(i+1)) {
                 occur[s.charAt(i) - 'a']++;
            }
        }

        // last
        count[s.charAt(s.length() - 1) - 'a']++;  
        occur[s.charAt(s.length() - 1) - 'a']++;
        cha[s.charAt(s.length() - 1) - 'a'] = s.charAt(s.length() - 1);
    
        


        // sorting
         
        for(int i=0; i < 26; i++){  
                 for(int j=1; j < 26-i; j++){  
                          if(count[j-1] > count[j]){  
                                //swap elements  
                                 int temp = occur[j-1];  
                                 occur[j-1] = occur[j]; 
                                 occur[j] = temp;  
                                 //swap abc
                                 char c = cha[j-1];
                                 cha[j-1] = cha[j];
                                 cha[j] = c;
                                 //swap count
                                 temp = count[j-1];  
                                 count[j-1] = count[j]; 
                                 count[j] = temp;  
                         }  
                          
                 }  
         } 
         
         for(int i=0; i < 26; i++){  
                 for(int j=1; j < 26-i; j++){  
                          if(occur[j-1] > occur[j]){  
                                 //swap elements  
                                 int temp = occur[j-1];  
                                 occur[j-1] = occur[j]; 
                                 occur[j] = temp;  
                                 //swap abc
                                 char c = cha[j-1];
                                 cha[j-1] = cha[j];
                                 cha[j] = c;
                                 //swap count
                                 temp = count[j-1];  
                                 count[j-1] = count[j]; 
                                 count[j] = temp;  
                         }  
                 }  
         } 
         
         
        //  for(int i =0;i<26;i++){
        //     System.out.print(occur[i]);
        //     System.out.print(count[i]);
        //     System.out.println(cha[i]);
        // }
            
         
         
         // remove                   
         for(int i=0;i<26;i++){
            if(occur[i] > 0){
             
                String ss=String.valueOf(cha[i]);  
                String strNew = s.replace(ss, "");
                s =strNew;             
                ct+=occur[i];
                occur[i] = 0;
                count[i] =0 ;
                break;
            }
         }
         
        }
        System.out.println(ct);
    }
}

