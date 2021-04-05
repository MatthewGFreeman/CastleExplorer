FROM postgres
# change username to fit new design
ENV POSTGRES_USER castle
ENV POSTGRES_PASSWORD p4ssw0rd
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432