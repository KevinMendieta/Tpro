/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpro;

/**
 *
 * @author kevin
 */
public class Logic {
    
    private int[] ft;
    
    public void fact(int n){
        ft = new int[n];
        ft[0] = 1; ft[1] = 1;
        for (int i = 2; i < ft.length ; i++){
            ft[i] = i*ft[i-1];
        }
    }
    
    public int comb(int n, int k){
        return (ft[n]/((ft[n-k])*ft[k]));
    }   
    
    public int calculate(int n){
        fact(n+1);
        int[] a = new int[n+1];
        a[0] = 1;a[1] = 1;int sum;
        for(int k = 2; k<n+1 ; k++){
            sum = 0;
            for(int i = 0; i<k ;i++){
                sum += a[i]*comb(k,k-i);
            }
            a[k]=sum;
        }        
        return a[n];
    }
}
