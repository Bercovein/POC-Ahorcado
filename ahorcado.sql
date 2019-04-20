create database ahorcado;

use ahorcado;



create table palabras(

	id_palabra int auto_increment,
    palabra varchar (50),
    primary key (id_palabra)
);

insert into palabras (palabra) 
	values ("interfaz"), ("estrategia"),
	 ("clase"),("abstracto"), ("modularizacion"),
     ("protocolo"), ("estatico"), ("polimorfia"),
     ("herencia"), ("sangandrolfio");

create table jugadores(

	id_jugador int auto_increment,
    nombre_jugador varchar(50),
    primary key(id_jugador)
);

insert into jugadores (nombre_jugador) 
	values ("Gianni"), ("Marco"),
	 ("Marcos"),("Nicolas"), ("German"),
     ("Pablo"), ("Guillermo"), ("Marcelo"),
     ("Gustavo"), ("Paula"), ("Marito");


create table resultados(

    id_ganador int not null,
    id_palabra int not null,
    fecha date,
    primary key(id_ganador,id_palabra),
    foreign key (id_ganador) references jugadores(id_jugador),
    foreign key (id_palabra) references palabras (id_palabra)
);



