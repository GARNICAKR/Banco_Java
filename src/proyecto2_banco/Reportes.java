/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_banco;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import static java.lang.Character.isDigit;

/**
 *
 * @author Dell
 */
public class Reportes {
         RandomAccessFile archivo;
    File file;
    public void CreateFile() throws Exception{
        try{
            file = new File("Reportes.obj");
            archivo = new RandomAccessFile(file,"rw");                       
            if(!file.exists())
                file.createNewFile();
        }catch(IOException e){}
    }
    
    public void AddBeginng(String fichero ) throws Exception{
        file = new File("Reportes.obj");
        archivo = new RandomAccessFile(file,"rw");
        archivo.seek(0);
        archivo.writeChars(fichero);
        archivo.close();
    }    
    
    public void AddEnd(String fichero) throws Exception{            
        file = new File("Reportes.obj");
        archivo = new RandomAccessFile(file,"rw");
        archivo.seek(archivo.length());
        archivo.writeChars(fichero);
        archivo.close();
    }   
    
    public void Print()throws Exception{   
        file = new File("Reportes.obj");
        archivo = new RandomAccessFile(file,"rw");
        archivo.seek(0);
        try{
            while(true ){System.out.println(archivo.readLine());}
        }catch (IOException Ex){}
    }
    
    public void ReadFile() throws Exception{        
        file = new File("Reportes.obj");
        archivo = new RandomAccessFile(file,"r");
        if (archivo != null) {archivo.close();}
    }   
///////////////////////////////////////////////////////////////////////
    public void Write(String texto)throws Exception {       
            CreateFile();
//            file = new File("RandomAccessFile.txt");
//            archivo = new RandomAccessFile(file,"rw");
            archivo.seek(archivo.length());    
            archivo.writeChars(texto);
            archivo.close();
    }
    
    public String Read(){        
        String temp="";
        String brRead;
        try{
            file = new File("Reportes.obj");
            archivo = new RandomAccessFile(file,"r");
            archivo.seek(0);       
            while((brRead=archivo.readLine())!=null){               
                temp +=brRead+"\n";
            }           
        }catch(IOException e){}
        return temp;
    }
    
    
    public String buscar(String fichero, String id){
        String aux="";
        String linea="";
        int b=0;
        int a=0;
        for(int i=0;i<fichero.length();i++){
            if(fichero.charAt(i)=='°'){
                a=1;
            }
            if(fichero.charAt(i)=='#'){
                b=1;
            }else{
                linea=linea+fichero.charAt(i);
            }
            if(isDigit(fichero.charAt(i)) && a==0){
                aux=aux+fichero.charAt(i);
            }
            if(b==1){
               if(aux.equals(id)){
                   return linea;
                }else{
                   linea="";
                   aux="";
                   b=0;
                   a=0;
               }
            }
        }
        return "null";
    }    
    
        public String Exception(String fichero, String id){
        String aux="";
        String linea="";
        String temp="";
        int b=0;
        int a=0;
        for(int i=0;i<fichero.length();i++){
            if(fichero.charAt(i)=='°'){
                a=1;
            }
            if(fichero.charAt(i)=='#'){
                b=1;
            }else{
                linea=linea+fichero.charAt(i);
            }
            if(isDigit(fichero.charAt(i)) && a==0){
                aux=aux+fichero.charAt(i);
            }
            if(b==1){
               if(aux.equals(id)){
                       linea="";
                       aux="";
                       b=0;
                       a=0;                   
                }else{
                       temp+=linea+"#"+"\n";
                       linea="";
                       aux="";
                       b=0;
                       a=0;
               }
            }
        }
        return temp;
    }
    
    
    
    public void Eliminar(String fichero, String Id2) throws Exception{
        try{
////            int aux2=0;
////            String Id2="";
////            for(int i=0;i<registro.length();i++){
////                if(registro.charAt(i)=='°'){
////                    aux2++;                    
////                }
////                if(aux2==0){                         
////                    if(aux9==0){
////                        i++;
////                        aux9=9;}
////                    Id2+=registro.charAt(i);
////                }                    
////            }
//            AuxiliarId=Integer.parseInt(Id3);
//            CreateFile();
//            String brRead="";
//            String temp=""; 
//            String Id2="";
//            int AuxiliarId2=0;
//            while((brRead=archivo.readLine())!=null){
//               int aux=0;
//                String lol="";
//                lol+=  brRead + "\n";
//                for(int i=0;i<brRead.length();i++){
//                    if(brRead.charAt(i)=='°'){
//                        aux++;                    
//                    }
//                    if(aux==0){
//                        Id2+=brRead.charAt(i);
//                    }                   
//                }    
//                AuxiliarId2=Integer.parseInt(Id2);
//                if(!registro.equals("3°a°a#\n")){
//                    temp +=brRead+"\n";
//                }
//                lol="";
//                        
//            }

            String temp=Exception(fichero,Id2);
//            Auxiliar.setLength(0);
//            Auxiliar.seek(0);                
//            Auxiliar.writeChars(temp);
//            Auxiliar.close();
            CreateFile();
            archivo.setLength(0);          
            Write(temp);
            archivo.close();
//            file.delete();
//            file2.renameTo(file);
//            file2.delete();
        }catch(IOException e){}       
    }    
    public void Modificar(String registro, String Id2, String Modificado) throws Exception{
        try{            
            Eliminar(registro,Id2); 
            Write(Modificado);            
        }catch(IOException e){} 
    }
}



