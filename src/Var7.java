
import java.io.*;
import java.lang.System;
import java.util.Scanner;
public class Var7 {
    public static void main(String[] args) throws IOException{
        DataOutputStream wr=null;
        DataInputStream rd=null;
        DataInputStream rd2=null;
        File f2=null;
        try {
            File f1 = new File("C:\\Me\\look.txt");
            f1.createNewFile();

            Scanner sc=new Scanner(System.in);
            wr=new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));

            System.out.println("Введите количество символов:");
            double count=sc.nextDouble();

            System.out.println("Введите числа типа double:");
            for (double i=0; i<count; i++) wr.writeDouble(sc.nextDouble());

            f2=new File("C:\\Me\\took.txt");
            if (f2.exists()) f2.delete();
            f2.createNewFile();

            rd=new DataInputStream(new FileInputStream(f1.getAbsolutePath()));
            wr=new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));

            double numpol;
            double max=0;
            try {
                while (true){
                    numpol=rd.readDouble();
                    if(numpol>0){
                        wr.writeDouble(numpol);
                        System.out.println("Number" + numpol);
                        if (numpol>max)
                            max=numpol;
                    }
                }
            } catch (EOFException e){
                if (max==0){
                    wr.writeDouble(max);
                    System.out.println("Нет положительных чисел");
                }
                else{
                    System.out.println("Максимальное число равна" + max);
                    wr.writeDouble(max);
                }
                System.out.println("End of file Exception");
            }
        } catch (IOException e){
            System.out.println("IOException");
        }
        finally {
            wr.flush();
            wr.close();
            rd.close();
        }
        try {
            rd2=new DataInputStream(new FileInputStream(f2));
            try {
                while (true){
                    System.out.println(rd2.readDouble());
                }
            }
            catch (Exception e){
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            rd.close();
        }
        }
    }



