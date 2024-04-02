package com.example.Factura.alertas;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FacturaAlertasApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturaAlertasApplication.class, args);

		/*String rutaArchivo = "//Users//luiscorreabetancur//vscode//Factura.txt";*/
		String valorABuscar1 = "Total_iva_Nodejs";
		String valorABuscar2 = "Total_iva_Java";
		//String valorABuscar3 = "Total_iva_csharp ";*/

		//if (!lineas.get(i).contains(valorABuscar1)==(lineas.get(j).contains(valorABuscar2)))

		String rutaArchivo = "//Users//luiscorreabetancur//vscode//Factura.txt";

		ArrayList<String> lineas = new ArrayList<>();

		try (FileReader reader = new FileReader(rutaArchivo)) {
			BufferedReader br = new BufferedReader(reader);
			String linea;
			while ((linea = br.readLine()) != null) {
				lineas.add(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < lineas.size(); i++) {
			for (int j = i + 1; j < lineas.size(); j++) {
				{
					if (!lineas.get(i).equals(lineas.get(j))) {
						// Se encontró una diferencia
						System.out.println("Diferencia entre líneas " + (i + 1) + " y " + (j + 1) + ": " + lineas.get(i) + " vs " + lineas.get(j));
					}
				}
			}
		}
	}
}

//if (!lineas.get(i).equals(lineas.get(j))) if (!lineas.get(i).equals(lineas.get(j))&& lineas.contains(valorABuscar1) != lineas.contains(valorABuscar2))