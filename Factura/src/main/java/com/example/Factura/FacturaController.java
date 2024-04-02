package com.example.Factura;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


@RestController
public class FacturaController {

    @GetMapping("/Factura")
    public double factura(@RequestParam double valor1, @RequestParam double valor2) {
        double total_siniva= (valor1 + valor2);
        double iva = (valor1 + valor2) * 0.19;
        double total = (valor1 + valor2) + iva;
        String IvaFactura = Double.toString(iva);
        String Total_iva_Java = Double.toString(total);
        ZonedDateTime fecha = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        LocalDateTime localDateTime = fecha.toLocalDateTime();
        System.out.println("La factura de el producto Java es " + total + "");
        String rutaArchivo = "//Users//luiscorreabetancur//vscode//Factura.txt"; // Ruta del archivo (ajústala según tu ubicación)

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            String mensaje = "El valor de la factura Java sin iva es " + total_siniva + " y el iva  es " + IvaFactura + "  y el total con iva  es " + Total_iva_Java + " en la fecha " + localDateTime + ""; // Mensaje a escribir
            writer.write(mensaje);
            writer.newLine(); // Agrega un salto de línea
            System.out.println("Se ha escrito en el archivo correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al escribir en el archivo");
        }
        return total;

    }
}


