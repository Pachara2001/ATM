package ATMapp.services;

import ATMapp.models.BankAccount;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReadWriteAccount {
    private final String fileName = "Account.csv";

    public ReadWriteAccount(){
        CheckPath();
    }
    public void readAccount(ArrayList<BankAccount> account){
        CSVReader reader = null;
        try{
            CSVParser csvParser = new CSVParserBuilder().withEscapeChar('\0').build();
            reader = new CSVReaderBuilder(new FileReader(fileName)).withCSVParser(csvParser).build();
            String[] accountArr;
            while((accountArr=reader.readNext())!=null){
                BankAccount temp = new BankAccount(accountArr[0],accountArr[1],accountArr[2]);
                account.add(temp);
            }
        }
        catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
    public void updateAccount(ArrayList<BankAccount> accountList)  {
        ArrayList <String []> accountStr = new ArrayList<>();
        CSVWriter writer = null;
        try{
            writer = new CSVWriter(new FileWriter(fileName));
            for(BankAccount accountUp : accountList){
                String[] q = accountUp.getInformation();
                accountStr.add(q);
            }
            writer.writeAll(accountStr);} catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private void CheckPath(){
       File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Cannot create " + fileName);
            }
        }
    }
}
