/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugas2_struktur.data_alifiany;

/**
 *
 * @author u
 */
public class MergeSort {
    //mengurutkan data dari terbesar ke terkecil dengan merge sort, min 8 elemen
    void merge(int arr[], int left, int mid, int right){
        
        //buat ukuran subarray
        int n1 = mid - left +1; //subarray kiri
        int n2 = right - mid;   //subarray kanan
        
        //array sementara L dan R
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        //salin data ke array sementara
        for(int i=0; i<n1; i++)
            L[i] = arr[left +i];
        for(int j=0; j<n2; j++)
            R[j] = arr[mid+1 +j];
        
        //indeks awal subarray
        int i=0, j=0;
        int k = left; //indeks awal gabungan
        
        //menggabungkan dua subarray yang sudah di urutkan
        while(i<n1 && j<n2){
            if(L[i] >= R[j]){ //urutan dari besar ke kecil
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        //menyalin sisa elemen (jika ada)
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    //fungsi rekursif
    void sort(int arr[], int left, int right){
        if(left<right){
            int mid = (left + right)/2;
            
            //rekursif bagian kanan dan kiri
            sort(arr, left, mid);
            sort(arr, mid+1, right);
            
            //gabungkan dua bagian yang sudah diurutkan
            merge(arr, left, mid, right);
        }
    }
    //mencetak array
    static void printArray(int arr[]){
        for(int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //input elemen
        int arr[] = {12,23,15,21,27,14,31,29};
        System.out.println("Data sebelum diurutkan = ");
        printArray(arr);
        
        //membuat objek sesuai kelas
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0,arr.length-1);
        
        //menampilkan hasil
        System.out.println("\n Data setelah diurutkan = ");
        printArray(arr);
    }
    
}
