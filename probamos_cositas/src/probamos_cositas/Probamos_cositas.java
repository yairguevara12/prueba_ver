/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probamos_cositas;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author yair
 */
public class Probamos_cositas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        /*  Probamos_cositas pc = new Probamos_cositas();
        pc.Inicio();*/
        WebClient client = new WebClient();
        Page page = client.getPage("https://pokeapi.co/api/v2/pokemon-species/?limit=898");
        WebResponse response = page.getWebResponse();
        // System.out.println(response.getContentAsString());
        if (response.getContentType().equals("application/json")) {
            String json = response.getContentAsString();

            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            md_pokemon_species student = gson.fromJson(json, md_pokemon_species.class);
            System.out.println(student);
            String jsonString;
            jsonString = gson.toJson(student);
            System.out.println(jsonString);
        }
    }

    public void Inicio() {

        try {
            WebClient client = new WebClient();
            Page page = client.getPage("https://pokeapi.co/api/v2/pokemon-species/?limit=898");
            WebResponse response = page.getWebResponse();
            /* System.out.println(response.getContentAsString());*/
            if (response.getContentType().equals("application/json")) {
                String json = response.getContentAsString();
                Map<String[], String[]> map = new Gson().fromJson(json, new TypeToken<Map<String[], String[]>>() {
                }.getType());

                //Gson gson = new Gson(); 
                //   results[] userArray = gson.fromJson(userJson, results[].class);  
                // System.out.println(map.size());
                //   System.out.println(" results :" + map.get("results"));
                /* System.out.println("Venta :" + map.get("venta"));
            System.out.println("Fecha :" + map.get("fecha"));*/
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void iniciar2() {

    }

}

class arraynombre_name {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Student {

    private String name;
    private int age;
    private arraynombre_name[] arraynombre;

    public arraynombre_name[] getArraynombre() {
        return arraynombre;
    }

    public void setArraynombre(arraynombre_name[] arraynombre) {
        this.arraynombre = arraynombre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student [ name: " + name + ", age: " + age + " ]";
    }

}
