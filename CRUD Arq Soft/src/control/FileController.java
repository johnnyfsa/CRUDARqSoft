package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import model.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileController {
	
	@SuppressWarnings("unchecked")
    public static void jsonWrite () {
         
        //Cria um Objeto JSON
        JSONObject jsonObject = new JSONObject();
         
        FileWriter writeFile = null;
         
        //Armazena dados em um Objeto JSON
        jsonObject.put("nome", "Allan");
        jsonObject.put("sobrenome", "Romanato");
        jsonObject.put("pais", "Brasil");
        jsonObject.put("estado", "SP");
         
        try{
            writeFile = new FileWriter("saida.json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
         
    }
	
	public static void jsonRead(ListaCliente L) {
        JSONObject jsonObject;
        JSONArray jsonArray;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        //Variaveis que irao armazenar os dados do arquivo JSON
        try {
        	FileReader file = new FileReader("saida.json");
        	if(file.read() ==-1) 
        	{
        		System.out.println("Arquivo vazio\n");
        		return;
        	}
        	else
        	{
        		//o java não aceita resetar a filereader pra posição inicial, então cria outro filereader
        		file = new FileReader("saida.json");
        	}
        	jsonArray = (JSONArray) parser.parse(file);
        	Iterator<JSONObject> externalIterator = jsonArray.iterator();
  
            while(externalIterator.hasNext()) 
            {
            	Cliente c = new Cliente();
            	jsonObject = externalIterator.next();
            	 Long aux = new Long(0);
                 //Salva nas variaveis os dados retirados do arquivo
                 aux = (Long) jsonObject.get("ClienteFlag");
                 c.setClienteFlag(aux.intValue());
                 c.setNome((String) jsonObject.get("Nome"));
                 c.setData_nascimento((String) jsonObject.get("Data_Nascimento"));
                 c.setRg((String) jsonObject.get("RG"));
                 c.setCpf((String) jsonObject.get("CPF"));
                JSONArray arrayJson = new JSONArray();
                 arrayJson = (JSONArray) jsonObject.get("Dependentes");
                 Pessoa[] arrayPessoas = new Pessoa[10];
                 Iterator<JSONObject> internalIterator = arrayJson.iterator();
                 int i =0;
                 while(internalIterator.hasNext()) 
                 {
                 	arrayPessoas[i] = new Pessoa();
                 	jsonObject = internalIterator.next();
                 	arrayPessoas[i].setCpf((String) jsonObject.get("CPF"));
                 	arrayPessoas[i].setData_nascimento((String) jsonObject.get("Data_Nascimento"));
                 	arrayPessoas[i].setNome((String) jsonObject.get("Nome"));
                 	arrayPessoas[i].setRg((String) jsonObject.get("RG"));
                 	i++;
                 	
                 }
                 c.setDependentes(arrayPessoas);
                 L.getListaCliente().add(c);
            }
        } 
        //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
	
}
