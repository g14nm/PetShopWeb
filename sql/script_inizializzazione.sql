drop schema if exists petshopweb;
create schema petshopweb;
use petshopweb;

create table utente (
    id bigint not null auto_increment,
    nome varchar(255) not null,
    cognome varchar(255) not null,
    username varchar(255) not null,
    email varchar(255) not null,
    dataDiNascita date not null,
    cellulare varchar(255) not null,
    `password` varchar(255) not null,
    ruolo char(1) not null default 'g',
    stato char(1) not null default 'a',
    loginRimanenti int not null default 3,
    primary key (id)
);

insert into utente
(cellulare, cognome, dataDiNascita, email, nome, password, ruolo, username)
values
('3547698321', 'Rossi', '1978-01-04', 'mariorossi@betacom.it', 'Mario', 'betacom', 'm', 'maro1978'),
('3654789120', 'Bianchi', '1989-01-04', 'lucabianchi@betacom.it', 'Luca', 'betacom', 'g', 'luba1989');

create table cliente (
    id bigint not null auto_increment,
    nome varchar(255) not null,
    cognome varchar(255) not null,
    indirizzo varchar(255) not null,
    città varchar(255) not null,
    telefono varchar(255) not null,
    primary key (id)
);

create table animale (
    matricola bigint not null auto_increment,
    nomeAnimale varchar(255) not null,
    dataAcquisto date,
    prezzo double,
    tipoAnimale varchar(255) not null,
    idCliente bigint,
    primary key (matricola),
    constraint animale_cliente_fk foreign key (idCliente) references cliente(id)
);

insert into cliente
(nome, cognome, indirizzo, città, telefono)
values
('Marco', 'Rossi', 'Via Roma 34', 'Milano', '33498756'),
('Francesco', 'Bianchi', 'Via Milano 55', 'Roma', '33500099'),
('Pietro', 'Verdi', 'Via Cantore 3', 'Torino', '33356777'),
('Giorgio', 'Rossi', 'Piazza Italia 4', 'Bari', '33467788');


insert into animale
(nomeAnimale, dataAcquisto, prezzo, tipoAnimale, idCliente)
values
('Luna', '2023-03-01', 50, 'Gatto', 1),
('Billy', '2022-01-03', 20, 'Criceto', 1),
('Pluto', '2023-01-04', 100, 'Cane', 1),
('Fluffy', '2023-01-05', 45, 'Gatto', 2),
('Blob', '2023-01-06', 10, 'Pesce', 2),
('Billy', '2023-01-07', 15, 'Criceto', 3),
('Stella', '2023-01-08', 65, 'Gatto', 4),
('Luna', '2023-01-19', 50, 'Gatto', 4);