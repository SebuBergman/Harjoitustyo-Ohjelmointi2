-- Pizza taulukko

CREATE TABLE reseptipankki(
reseptiId int auto_increment not null,
annoksia varchar(20),
reseptinimi varchar(60) not null,
valmistusAika varchar(50),
ainesosat varchar(400) not null,
ohje varchar(800) not null,
primary key(reseptiId)
)engine=InnoDB;