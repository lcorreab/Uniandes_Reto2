const express = require('express');
const fs = require('fs');
const app = express();

app.use(express.json());

const misParametros = [
    {id:1, iva: 0.19, nombreMS:'NodeJS', pathFactura:'//Users//luiscorreabetancur//vscode//Factura.txt', ivamalo: 0.16, meterError:false},
];

app.get('/', (req, res) =>{
    res.send('node js api');
});

// Funcion a modificar
app.get('/api/reto2/:valor1/:valor2', (req, res) => {
    const parametros = misParametros.find(c=>c.id === 1);
    let now = new Date();
    const elIva = parametros.meterError ? parametros.ivamalo : parametros.iva;

    var valor1 = parseInt(req.params.valor1);
    var valor2 = parseInt(req.params.valor2);

    var multiplicacion = valor1*valor2;

    var iva = elIva*multiplicacion;
    var Total_iva_Nodejs = multiplicacion+iva;
    var valorsiniva = valor1*valor2;

    res.send('numero1: '+ parseFloat(req.params.valor1)
        +' numero2: '+ parseFloat(req.params.valor2) 
    );
 
    fs.appendFile(""+parametros.pathFactura,
        "El valor de la factura NodeJS sin iva es "+ multiplicacion +" y el iva es "
            + iva +" y el total con iva es "
                + Total_iva_Nodejs +" en la fecha " + now + "\n",
        (error)=>{
            if(error){
                throw error;
            }
            console.log("Registro creado");
    });

});

const port = process.env.port || 80;
app.listen(port, () => console.log(`Escuchando en el puerto ${port}...`));
