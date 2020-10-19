package string.TextJustification;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	
	/*Approach 1 : 
	 * Time Complexity: 
	 * Space Complexity: 
	*/
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < words.length){
            int gaps=0; 
            int ii = i;
            int len = words[i].length();
            while((i+1) < words.length && len + words[i+1].length() + 1 <= maxWidth){
                i++;
                len = len + words[i].length() + 1;
                gaps++;
            }
            int extraSpace = maxWidth - len;
            StringBuilder sb = new StringBuilder();
            if(i == words.length - 1){
                for(int z = ii; z <= i; z++){
                    sb.append(words[z]);
                    if(z < i){
                        sb.append(" ");
                    }
                }
                while(extraSpace-- > 0) sb.append(" ");
            }else{
                if(ii == i){
                    sb.append(words[i]);
                    while(extraSpace-- > 0) sb.append(" ");
                }else{
                    for(int z = ii; z <= i; z++){
                        sb.append(words[z]);
                        if(z < i){
                            for(int k=0; k <= extraSpace/gaps; k++){
                                sb.append(" ");
                            }
                            if(z - ii < extraSpace%gaps){
                                sb.append(" ");
                            }
                        }
                    }
                }
            }
            res.add(sb.toString());
            i++;
        }
        return res;
    }
}
