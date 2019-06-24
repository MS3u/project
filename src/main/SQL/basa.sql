create table magazyn
(
  id    int auto_increment
    primary key,
  nazwa varchar(30) not null,
  stan  int         not null
)
  charset = latin1;

create table users
(
  id         int(250) auto_increment
    primary key,
  imie       varchar(30)  not null,
  nazwisko   varchar(30)  not null,
  stanowisko varchar(30)  not null,
  haslo      varchar(255) not null
)
  charset = latin1;

create table zlecenie
(
  id       int auto_increment
    primary key,
  nr       varchar(30)  not null,
  imie     varchar(255) not null,
  nazwisko varchar(30)  not null,
  pesel    varchar(30)  not null,
  telefon  varchar(30)  not null,
  opis     varchar(30)  not null,
  data     varchar(30)  null
)
  charset = latin1;

create table serwis
(
  id           int auto_increment
    primary key,
  zlecenie_id  int         not null,
  magazyn_id   int         not null,
  status       varchar(30) not null,
  serwisant_id int         not null,
  constraint serwis_ibfk_1
    foreign key (magazyn_id) references magazyn (id),
  constraint serwis_ibfk_2
    foreign key (zlecenie_id) references zlecenie (id)
)
  charset = latin1;

create index magazyn_id
  on serwis (magazyn_id);

create index zlecenie_id
  on serwis (zlecenie_id);

