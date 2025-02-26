class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder wordBuilder = new StringBuilder();
            
            if (vowels.indexOf(word.charAt(0)) != -1) {
                wordBuilder.append(word).append("ma");
            } else {
                wordBuilder.append(word.substring(1)).append(word.charAt(0)).append("ma");
            }
            
            for (int j = 0; j < i + 1; j++) {
                wordBuilder.append("a");
            }
            
            result.append(wordBuilder.toString());
            
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
}
