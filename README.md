# Waduh-Based-Dev

Kelompok 43
| NIM | Nama |
| -------- | ------------------------- |
| 13520013 | Ilham Prasetyo Wibowo |
| 13520037 | Muhammad Akmal Arifin |
| 13520158 | Azmi Alfatith Shalahuddin |

## Description

Web service dengan protokol REST yang diimplementasikan menggunakan NodeJS. Sebagai tugas besar 2 mata kuliah IF3110 Web Based Development.

## Requirements

- java jdk
- Docker (Optional)

## Running the server

```
cd webservice
mvn clean compile assembly:single
java -jar ./target/webservice-1.0-SNAPSHOT-jar-with-dependencies.jar
```

Server bisa diakses pada `localhost:9999`

## Database Schema

![Db Schema](./images/skema.png?raw=true "skema basis data")

## Task assignments

Check Request : 13520158<br>
Logging : 13520013<br>
Subscription service : 13520037 <br>
