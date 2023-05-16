/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crypto;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
/**
 *
 * @author minji
 */
public class Crypto {
    public  Scanner inputFile = null;
    public PrintWriter outputFile1 = null;
    public  PrintWriter outputFile2 = null;
    
    private String plaintext_filename;
    private String ciphertext_filename;
    private int key;
    
    
    public Crypto(String pFile, String cFile, int num)
    {
        
        plaintext_filename = pFile;
        ciphertext_filename = cFile;
        key = num;
        
        
        Encrypt();
        
    }
    
    public void  Encrypt()
    {
        
        char ch;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String password = keyboard.nextLine();

        try
        {
            outputFile1 = new PrintWriter(new FileOutputStream(plaintext_filename));
            outputFile2 = new PrintWriter(new FileOutputStream(ciphertext_filename));
            
        }
        catch(FileNotFoundException e)
        {
           System.out.println("Problem opening files."); 
        }
        
        for(int i = 0; i < password.length();i++)
        {
            ch = password.charAt(i);
            
            outputFile1.print(ch);
            
            int number = (int)ch + key;
            outputFile2.print(number+ " ");
        }
        
        outputFile1.close();
        outputFile2.close();    
        
    }
    
    public void Decryption(String cFile, String pFile, int k)
    {
         try
        {
            inputFile = new Scanner(new FileInputStream(cFile));
            outputFile1 = new PrintWriter(new FileOutputStream(pFile));
            
        }
        
        
        catch(FileNotFoundException e)
        {
           System.out.println("Problem opening files."); 
        } 
         
         int next;
         while (inputFile.hasNextInt( ))
         {
             next = inputFile.nextInt( )- k;
             char ch = (char)next;
             outputFile1.print(ch);
         }
           
         inputFile.close();
         outputFile1.close();  
    }
    


    public static void main(String[] args) {
        
        Crypto C = new Crypto("input.txt","output.txt",5);
        
        C.Decryption("output.txt", "input2.txt", 5);
        
        System.out.println();
    }
}
