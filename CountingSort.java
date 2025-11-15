/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas2_struktur.data_alifiany;

/**
 *
 * @author u
 */
public class CountingSort {
    //fungsi Counting sort
    void coutingSort(int arr[]){
        int n = arr.length;
        
        //mencari nilai maksimum untuk array count[]
        int max = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        
        //buat array count dan output
        int count[] = new int[max+1];
        int output[] = new int[n];
        
        //hitung frekuensi elemen
        for(int i=0; i<n; i++){
            count[arr[i]]++;
        }
        
        //akumulasi (dari besar ke kecil)
        for(int i=max-1; i>=0; i--){
            count[i] += count[i+1];
        }
        
        //isi output
        for(int i=0; i<n; i++){
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }
        
        //salin ke array asli
        System.arraycopy(output, 0, arr, 0, n);
    }
    
    //mencetak array
    static void printArray(int arr[]){
        for(int value : arr){
            System.out.print((value + " "));
        }
    }
    
    //fungsi main
    public static void main(String[] args){
        //masukkan elemen
        int arr[] = {21,16,11,24,31,25,33,43};
        System.out.println("Data sebelum diurutkan = ");
        printArray(arr);
        
        //membuat objek dari kelas
        CountingSort cs = new CountingSort();
        cs.coutingSort(arr);
        
        //menampilkan hasil
        System.out.println("\n Data setelah diurutkan = ");
        printArray(arr);
    }
}

