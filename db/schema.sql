CREATE TABLE public.train
(
    id bigint NOT NULL,
    amenities character varying(255) COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    distance_between_stop character varying(255) COLLATE pg_catalog."default",
    grade_crossing boolean,
    max_speed character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    sharing_tracks boolean,
    train_frequency character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT train_pkey PRIMARY KEY (id)
)