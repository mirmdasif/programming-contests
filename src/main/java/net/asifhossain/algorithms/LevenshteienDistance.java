package net.asifhossain.algorithms;

/**
 * @author asif.hossain
 * @since 3/1/15
 */
public class LevenshteienDistance {
   
    private int min(int x , int y , int z){
        return Math.min(Math.min(x,y),z);
    }
    
    public int recursiveLevenshteienDistance(String str1, int length1 ,String str2 , int length2) {
        
        int distance;
        if(length1==0) {
            return length2;
        }
        if (length2 == 0) {
            return length1;
        }
        
        int cost;
        if(str1.charAt(length1 -1) == str2.charAt(length2 -1)){
            cost = 0;
        }
        else {
            cost = 1;
        }
        
        return this.min(
                recursiveLevenshteienDistance(str1, length1 - 1, str2, length2 - 1) + cost,
                recursiveLevenshteienDistance(str1, length1, str2, length2 - 1) + cost,
                recursiveLevenshteienDistance(str1, length1 - 1, str2, length2) + cost
        );
        
    }
    
    private void printMatrix(int a[][], int length1, int length2) {
        
        for (int i=0;i<=length1;i++) {
            for (int j =0; j<=length2;j++) {

                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
    
    public int dynamicLevenshteienDistance(String str1 , int length1 , String str2, int length2 ) {

        int m[][] = new int[length1+1][length2+1];
        
        for (int i = 0; i<=length1;i++) {
            
            m[i][0] = i;
        }
        for (int j = 0; j<=length2;j++) {

            m[0][j] = j;
        }
        
        for (int i=1;i<=length1;i++) {
            
            for (int j=1;j<=length2;j++) {
                
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    m[i][j] = m[i-1][j-1];
                } else {
                    
                    m[i][j] = min(
                            m[i-1][j-1] + 1,
                            m[i-1][j] + 1,
                            m[i][j-1] + 1
                    );
                }
            }
        }
            
        return m[length1][length2];
    }
    
}
