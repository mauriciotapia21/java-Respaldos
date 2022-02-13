## XpertalExercises
Xpertal Exercises

#Desafio Spring 1


1-Mostrar-todos los hoteles.
esta funcion lo que me permitira es visualizar todos los hoteles que tenemos disponibles en nuestro json,
de esta manera podremos visualizar con los hoteles que contamos asi como la fecha en la cual podemos separarlo,
hasta cuando podemos y si se muestra disponible.
1.1-para poder visualizarlo entramos a lo que es nuestra herramienta postman.
1.2-ingresamos nuestra liga que es localhost:8080/api/v1/hotels
1.3-Damos a la opcion "SEND"
1.3- nos mostrara lo que son todos los hoteles con los que contamos.

2-Mostrar los hoteles con rango de fecha y donde se ubica.
esta funcion me va permitir visualizar los hoteles que estan disponibles en el rango de fecha en la que yo deseo visualizar si es que
esta disponible, asi mismo con el destino o ciudad donde yo me quisiera establecer.
2.1-para poder visualizarlo entramos a lo que es nuestra herramienta postman.
2.2-Mediante nuestra liga lo que haremos es ingresar nuestro rango de fechas.
2.3-Tambien ahi mismo en nuestra liuga de acceso agregaremos lo que es el destino o ciudad al cual quisieramos ver el hotel.
2.4- La liga de acceso nos debe de quedar de esta manera "localhost:8080/api/v1/hotels?dateFrom=10/02/2022&dateTo=15/02/2022&destination=Bogotá"
2.5- Damos click a la opcion SEND.
2.6-nos mostrara todos los hoteles en ese rango de fechas con el destino deseado, asi mismo siempre y cuando este disponible el hotel.

3-Realizar una reserva de hotel.
 Aqui se puede realizar una reserva de un hotel, indicando cantidad de personas, fecha de entrada, fecha de salida y tipo de habitación. 
 y de esta manera obtiene como respuesta el monto total de la reserva realizada.
3.1- para poder visualizarlo e ingresar nuestros valores entramos a lo que es nuestra herramienta postman.
3.2- Ingresamos los datos en una opcion de nuestra postman que se llama "BODY"
3.3- Recuerda agregar los datos en sintaxis Json.
3.4- ingresamos los datos como en la siguiente sintaxis de ejemplo:
	{
    "userName": "Nombre",
    "booking": {
        "dateFrom": "Fecha1",
        "dateTo": "Fecha2",
        "destination": "Destino",
        "hotelCode": "Codigo de hotel",
        "peopleAmount": NumeroDePersonas,
        "roomType": "Triple",
        "people": [
            {
                "dni": "Trabajador_numero",
                "name": "nombre_trabajador",
                "lastname": "Apellidos",
                "birthDate": "Fecha_nacimiento",
                "mail": "Correo_Electronico"
            },
            {
                "dni": "Trabajador_numero",
                "name": "nombre_trabajador",
                "lastname": "Apellidos",
                "birthDate": "Fecha_nacimiento",
                "mail": "Correo_Electronico"
            }
        ],
        "paymentMethod": {
            "type": "Tipo_De_Pago: CREDIT O DEBITO",
            "number": "Numero_Tarjeta",
            "dues": Numero_De_Dias
        }
    }
}
3.5- Damos click a la opcion SEND.
3.6- Nos generara lo que es el total a pagar y el status de la transaccion.
3.7- Listo la reserva del hotel ya queda lista.

4- Mostrar-todos los Vuelos.
esta funcion lo que me permitira es visualizar todos los Vuelos que tenemos disponibles en nuestro json,
de esta manera podremos visualizar con los Vuelos que contamos asi como la fecha en la cual podemos separarlo,
hasta cuando podemos separar un vuelo, destino al que se dirige asi como el origen del vuelo asi mismo se muestra si esta disponible.
4.1-para poder visualizarlo entramos a lo que es nuestra herramienta postman.
4.2-ingresamos nuestra liga que es localhost:8080/api/v1/flights
4.3-Damos a la opcion "SEND"
4.4- nos mostrara lo que son todos los Vuelos con los que contamos.

5- Mostrar los Vuelos con rango, origen y destino.
esta funcion me va permitir visualizar los Vuelos que estan disponibles en el rango de fecha en la que yo deseo visualizar si es que
esta disponible, asi mismo con el destino o ciudad donde yo me quisiera establecer y la ciudad en donde el vuelo va salir.
5.1-para poder visualizarlo entramos a lo que es nuestra herramienta postman.
5.2-Mediante nuestra liga lo que haremos es ingresar nuestro rango de fechas, tambien el la ciudad en donde yo voy a salir y la ciudad en la que yo voy a llegar de destino.
5.3-Tambien ahi mismo en nuestra liuga de acceso agregaremos lo que es el destino o ciudad al cual quisieramos ver el hotel.
5.4- La liga de acceso nos debe de quedar de esta manera "localhost:8080/api/v1/flights?dateFrom=10/02/2022&dateTo=14/02/2022&origin=Buenos Aires&destination=Puerto Iguazú
5.5- Damos click a la opcion SEND.
5.6-nos mostrara todos los Vuelos en ese rango de fechas con la ciudad en donde deseamos salir y el destino deseado.

6- Realizar una reserva de vuelo.
esta funcion me permite realizar una reserva de un vuelo, indicando cantidad de personas, origen, destino y fecha de ida. 
y nos obtiene como respuesta el monto total de la reserva realizada.

6.1- Realizar una reserva de un vuelo, indicando cantidad de personas, origen, destino y fecha de ida. Obtener como respuesta el monto total de la reserva realizada.
6.2- Ingresamos los datos en una opcion de nuestra postman que se llama "BODY"
6.3- Recuerda agregar los datos en sintaxis Json.
6.4- ingresamos los datos como en la siguiente sintaxis de ejemplo:
 "userName": "Nombre",
    "flightReservation": {
        "dateFrom": "Fecha1",
        "dateTo": "Fecha2",
        "origin": "Destino donde saldras del vuelo",
        "destination": "Destino al que quieres llegar",
        "flightNumber": "Numero_De_Vuelo",
        "seats": NumeroDePersonas,
        "seatType": "Tipo_de_Vuelo",
        "people": [
            {
                "dni": "DNI_Trabajador",
                "name": "Nombres",
                "lastname": "Apellidos",
                "birthDate": "Fecha_nacimiento",
                "mail": "Correo_Electronico"
            },
            {
                "dni": "DNI_Trabajador",
                "name": "Nombres",
                "lastname": "Apellidos",
                "birthDate": "Fecha_nacimiento",
                "mail": "Correo_Electronico"
            }
        ],
        "paymentMethod": {
            "type": "Tipo_De_Pago",
            "number": "Numero_Tarjeta",
            "dues": 3
        }
    }
}

6.5- Damos click a la opcion SEND.
6.6- Nos generara lo que es el total a pagar y el status de la transaccion.
6.7- Listo la reserva del Vuelo ya queda lista.



