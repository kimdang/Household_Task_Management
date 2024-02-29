## Household Task Management

* application.properties contains properties that Spring Boot use to configure the application.

* Spring Data JPA Specification is used to build dynamic queries for filtering.

### Set up database
1) Run `docker-compose up` at the root directory to create PostgreSQL and pgAdmin4 containers
2) Go to localhost:8080 and sign in (see docker-compose.yaml for credential)
3) Create a new server named postgres (see docker-compose.yaml for credential and port)
4) Create the following tables
```
CREATE TABLE public.persons
(
    person_id bigserial NOT NULL,
    first_name character varying NOT NULL,
    last_name character varying,
    family_id bigint,
    PRIMARY KEY (person_id)
);
```

```
CREATE TABLE public.tasks
(
    task_id bigserial NOT NULL,
    name character varying NOT NULL,
    description character varying,
    create_date date,
    due_date date,
    completed boolean,
    assigned_to bigint,
    create_by bigint,
    PRIMARY KEY (task_id)
);
```
