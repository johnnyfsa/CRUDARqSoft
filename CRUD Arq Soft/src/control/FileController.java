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
    public static void jsonWrite (ListaCliente L) {
         
        //Cria um Objeto JSON
        JSONArray arrJson = new JSONArray();
        
        FileWriter writeFile = null;
        
        Iterator<Cliente> clienteIterator = L.getListaCliente().iterator();
        while(clienteIterator.hasNext()) 
        {
        	JSONObject jsonObject = new JSONObject();
        	Cliente aux = new Cliente();
        	aux = clienteIterator.next();
        	 //Armazena dados em um Objeto JSON
        	jsonObject.put("ClienteFlag", aux.getClienteFlag());
            jsonObject.put("Nome", aux.getNome());
            jsonObject.put("Data_Nascimento", aux.getData_nascimento());
            jsonObject.put("RG", aux.getRg());
            jsonObject.put("CPF", aux.getCpf());
            if(aux.getDependentes().length > 0) 
            {
            	JSONArray depList = new JSONArray();
            	Pessoa Paux[] = new Pessoa[10];
            	Paux = aux.getDependentes();
            	for(int i =0; i< aux.getDependentes().length;i++ ) 
            	{
            		if(Paux[i]!=null) 
            		{
            			JSONObject auxObj = new JSONObject();
                		auxObj.put("nome", Paux[i].getNome());
                		auxObj.put("Data_Nascimento", Paux[i].getData_nascimento());
                		auxObj.put("RG", Paux[i].getRg());
                		auxObj.put("CPF", Paux[i].getCpf());
                		depList.add(auxObj);
            		}
            		
            	}
            	jsonObject.put("Dependentes", depList);
            }
           arrJson.add(jsonObject);
        }
         
        try{
            writeFile = new FileWriter("saida.json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(arrJson.toJSONString());
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
