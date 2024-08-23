CREATE TABLE "Elemento Catalogo"(
    "isbn" SERIAL NOT NULL,
    "titolo" VARCHAR(255) NOT NULL,
    "anno pubblicazione" INTEGER NOT NULL,
    "numero pagine" INTEGER NOT NULL
);
ALTER TABLE
    "Elemento Catalogo" ADD PRIMARY KEY("isbn");
CREATE TABLE "Utente"(
    "id" SERIAL NOT NULL,
    "nome" VARCHAR(255) NOT NULL,
    "cognome" VARCHAR(255) NOT NULL,
    "data di nascita" DATE NOT NULL,
    "numero tessera" BIGINT NOT NULL
);
ALTER TABLE
    "Utente" ADD PRIMARY KEY("id");
CREATE TABLE "Prestito"(
    "id" SERIAL NOT NULL,
    "data inizio prestito" DATE NOT NULL,
    "data restituzione prevista" DATE NOT NULL,
    "data restituzione effettiva" DATE NOT NULL
);
ALTER TABLE
    "Prestito" ADD PRIMARY KEY("id");
CREATE TABLE "rivista"(
    "periodicità" VARCHAR(255) CHECK
        ("periodicità" IN('')) NOT NULL
);
ALTER TABLE
    "rivista" ADD PRIMARY KEY("periodicità");
CREATE TABLE "Libro"(
    "autore" VARCHAR(255) NOT NULL,
    "genere" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "Libro" ADD PRIMARY KEY("autore");
ALTER TABLE
    "rivista" ADD CONSTRAINT "rivista_periodicità_foreign" FOREIGN KEY("periodicità") REFERENCES "Elemento Catalogo"("isbn");
ALTER TABLE
    "Prestito" ADD CONSTRAINT "prestito_id_foreign" FOREIGN KEY("id") REFERENCES "Utente"("id");
ALTER TABLE
    "Prestito" ADD CONSTRAINT "prestito_id_foreign" FOREIGN KEY("id") REFERENCES "Elemento Catalogo"("isbn");
ALTER TABLE
    "Libro" ADD CONSTRAINT "libro_autore_foreign" FOREIGN KEY("autore") REFERENCES "Elemento Catalogo"("isbn");