//MOVIES

show tables

/**/
CREATE TABLE Movie (
	id int,
	title varchar(255),
	director varchar(255),
	stars mediumText ,
	music varchar(255),
	runTime smallint,
	country varchar(100),
	filmGenre varchar(50),
	plot mediumText
)
/*AÑADIR EL PRIMARY KEY*/
alter table movie add primary key (id);

/*NOT NULL Y AUTO INCREMENTABLE*/
ALTER TABLE movies.movie MODIFY COLUMN id int auto_increment NOT NULL;

/*Insertar datos*/
insert into movie (title,director,stars,music,runTime,country,filmGenre,plot)
values
		('2001: A Space Odyssey','Stanley Kubrick','Keir Dullea, Gary Lockwood',' Alex North',142,'Reino Unido, Estados Unidos','Ciencia Ficcion','La supercomputadora HAL 9000 guía a un equipo de tres astronautas en un viaje en el que buscan descubrir los orígenes de la humanidad.'),
		('Solaris','Andréi Tarkovski','	Natalya Bondarchuk,Donatas Banionis,Jüri Järvet,Nikolay Grinko,Anatoliy Solonitsyn','Eduard Artemiev',166,'Rusia','Ciencia Ficcion','Un cosmonauta investiga reportajes de un equipo abordo de una estación espacial que están teniendo visiones.'),
		('Encuentros cercanos del tercer tipo','Steven Spielberg','Richard Dreyfuss,Teri Garr','John Williams,Isao Tomita',135,'Estados Unidos','Ciencia Ficcion','La historia de Steven Spielberg, sobre un trabajador de una compañía de luz y su obsesión con los ovnis.'),
		('Scanners','David Cronenberg','Stephen Lack,Michael Ironside','Howard Shore',103,'Canadá','Ciencia Ficcion','Se incrementa el conflicto entre dos grupos cuyos poderes psíquicos incluyen la habilidad de matar por telepatía.'),
		('Blade Runner','Ridley Scott','Harrison Ford','Vangelis',117,'Estados Unidos','Ciencia Ficcion','La historia de este film se ambienta en la ciudad de Los Ángeles. El personaje principal, Rick Deckard, es un Blade Runner al que se le encarga eliminar a los replicantes'),
		('Volver al futuro','Robert Zemeckis','Michael J. Fox,Christopher Lloyd','Alan Silvestri',117,'Estados Unidos','Ciencia Ficcion','Una máquina del tiempo transporta a un adolescente a los años 50, cuando sus padres todavía estudiaban en la secundaria.'),
		('Akira','Katsuhiro Otomo','Shotaro Kaneda,Tetsuo Shima','Shoji Yamashiro',124,'Japón','Cyberpunk','Un joven telépata deambula por las calles de Tokio al darse cuenta de que los poderes que posee son asombrosos.'),
		('El padrino','Francis Ford Coppola','Marlon Brando, Al Pacino, James Caan','Nino Rota',177,'Estados Unidos','Drama','Don Vito Corleone es el respetado y temido jefe de una de las cinco familias de la mafia de Nueva York en los años 40. Cuando otro capo, Sollozzo, intenta asesinar a Corleone, empieza una cruenta lucha entre los distintos clanes.'),
		('Medianeras','Gustavo Taretto','Javier Drolas,Pilar López de Ayala','Gabriel Chwojnik',95,'Argentina','Drama,Romance','Una mujer que acaba de sufrir un rompimiento doloroso, y un diseñador web fóbico viven en el mismo vecindario pero sufren de la soledad urbana.');

insert into movie (title,director,stars,music,runTime,country,filmGenre,plot)
values
('Magallanes','Salvador del Solar','Magaly Solier,Damián Alcázar','Federico Jusid',109,'Perú','Drama,Suspenso','La vida de un taxista da un giro inesperado el día que una mujer que conoció hace 25 años, teniendo un reencuentro inesperado con su pasado oscuro, lo que lo impulsa a realizar un riesgoso plan para tratar de ayudarla a conseguir dinero.');

/*Actualizar*/
UPDATE movie SET filmGenre='Romance' WHERE id=9;

/*Eliminar*/
delete FROM movie  WHERE id=10;

/*Consultar*/
select * from Movie



/*CREANCION DE SP*/
create procedure actualizar ( in p_id int,in p_filmGenre varchar(50))
begin
	update movie
	set
	filmGenre = p_filmGenre where id = p_id;
end

call actualizar(12,"Drama histórico");



create procedure eliminar ( in p_id int)
begin
	delete from  movie
	where id = p_id;
end

call eliminar(12);