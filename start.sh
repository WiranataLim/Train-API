#!/bin/bash

pg_ctlcluster $PG_MAJOR main start

gosu postgres psql -c "CREATE DATABASE ${POSTGRES_DB};"
gosu postgres psql -c "CREATE USER ${POSTGRES_USER} PASSWORD '${POSTGRES_PASSWORD}';"

gosu postgres psql -d ${POSTGRES_DB} -f "/docker-entrypoint-initdb.d/1-schema.sql"

gosu postgres psql -d ${POSTGRES_DB} -f "/docker-entrypoint-initdb.d/2-data.sql"

gosu postgres psql -d ${POSTGRES_DB} -c "GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO ${POSTGRES_USER};"

java -jar /app/app.jar
