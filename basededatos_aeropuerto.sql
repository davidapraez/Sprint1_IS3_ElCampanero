--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-09-18 22:51:19

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 204 (class 1259 OID 26281)
-- Name: aerolineas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.aerolineas (
    idaerolinea text NOT NULL,
    nombre_aerolinea text NOT NULL,
    correo text
);


ALTER TABLE public.aerolineas OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 26300)
-- Name: avion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.avion (
    id_avion text NOT NULL,
    tipo_avion text,
    capacidad text,
    modelo text,
    tipo_propulsion text,
    numero_motores text,
    peso_nominal text,
    idaerolinea text NOT NULL
);


ALTER TABLE public.avion OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 26103)
-- Name: hangares; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hangares (
    id_hangar text NOT NULL,
    ubicacion text,
    capacidad text
);


ALTER TABLE public.hangares OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 26162)
-- Name: piloto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.piloto (
    cedula text NOT NULL,
    nombre text,
    apellido text,
    licencia text,
    horas_experiencia_acumuladas text,
    fecha_revision_medica date
);


ALTER TABLE public.piloto OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 26046)
-- Name: usuario_aeropuerto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario_aeropuerto (
    cedula text NOT NULL,
    primer_nombre text NOT NULL,
    primer_apellido text NOT NULL,
    correo text NOT NULL
);


ALTER TABLE public.usuario_aeropuerto OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 26289)
-- Name: usuario_sistema_aerolinea; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario_sistema_aerolinea (
    idaerolinea text NOT NULL,
    usuario text,
    password text
);


ALTER TABLE public.usuario_sistema_aerolinea OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 26054)
-- Name: usuario_sistema_aeropuerto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario_sistema_aeropuerto (
    id_usuario_sistema_aeropuerto text NOT NULL,
    usuario_aeropuerto_cedula text NOT NULL,
    password text NOT NULL
);


ALTER TABLE public.usuario_sistema_aeropuerto OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 42574)
-- Name: vuelo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vuelo (
    idvuelo text NOT NULL,
    tipo_de_vuelo text NOT NULL,
    fecha date NOT NULL,
    hora text NOT NULL,
    minutos text NOT NULL,
    copiloto text,
    id_avion text NOT NULL,
    piloto_cedula text NOT NULL
);


ALTER TABLE public.vuelo OWNER TO postgres;

--
-- TOC entry 3037 (class 0 OID 26281)
-- Dependencies: 204
-- Data for Name: aerolineas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.aerolineas (idaerolinea, nombre_aerolinea, correo) FROM stdin;
R-115	Avianca	avianca@gmail.com
12345	SATENA	satena
\.


--
-- TOC entry 3039 (class 0 OID 26300)
-- Dependencies: 206
-- Data for Name: avion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.avion (id_avion, tipo_avion, capacidad, modelo, tipo_propulsion, numero_motores, peso_nominal, idaerolinea) FROM stdin;
12345	Avion comercial	1000	K fir	A reaccion	2	500	R-115
AIRBUS	Avion comercial	100	737	REACCION3	3	300	R-115
\.


--
-- TOC entry 3035 (class 0 OID 26103)
-- Dependencies: 202
-- Data for Name: hangares; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hangares (id_hangar, ubicacion, capacidad) FROM stdin;
\.


--
-- TOC entry 3036 (class 0 OID 26162)
-- Dependencies: 203
-- Data for Name: piloto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.piloto (cedula, nombre, apellido, licencia, horas_experiencia_acumuladas, fecha_revision_medica) FROM stdin;
1085935397	David	Apraez	l-154	500	2021-06-09
123	Juan	Perez	123456	100	2021-02-09
\.


--
-- TOC entry 3033 (class 0 OID 26046)
-- Dependencies: 200
-- Data for Name: usuario_aeropuerto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario_aeropuerto (cedula, primer_nombre, primer_apellido, correo) FROM stdin;
1085935397	Omar	Apraez	omarapraez@hotmail.com
\.


--
-- TOC entry 3038 (class 0 OID 26289)
-- Dependencies: 205
-- Data for Name: usuario_sistema_aerolinea; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario_sistema_aerolinea (idaerolinea, usuario, password) FROM stdin;
R-115	avianca	123
12345	satena	123
\.


--
-- TOC entry 3034 (class 0 OID 26054)
-- Dependencies: 201
-- Data for Name: usuario_sistema_aeropuerto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario_sistema_aeropuerto (id_usuario_sistema_aeropuerto, usuario_aeropuerto_cedula, password) FROM stdin;
admin	1085935397	123
\.


--
-- TOC entry 3040 (class 0 OID 42574)
-- Dependencies: 207
-- Data for Name: vuelo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vuelo (idvuelo, tipo_de_vuelo, fecha, hora, minutos, copiloto, id_avion, piloto_cedula) FROM stdin;
2	LLegada	2021-07-16	5	50		12345	1085935397
3	Salida	2021-07-14	12	50		12345	1085935397
5	LLegada	2021-08-18	3	3		12345	1085935397
7	LLegada	2021-08-18	4	0		12345	1085935397
8	LLegada	2021-08-18	3	5		12345	1085935397
9	LLegada	2021-08-18	3	5		12345	1085935397
10	LLegada	2021-08-18	3	5		12345	1085935397
11	LLegada	2021-08-18	3	5		12345	1085935397
12	LLegada	2021-08-18	3	5		12345	1085935397
14	LLegada	2021-08-18	3	0		12345	1085935397
15	LLegada	2021-08-18	3	0		12345	123
\.


--
-- TOC entry 2893 (class 2606 OID 26288)
-- Name: aerolineas aerolineas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aerolineas
    ADD CONSTRAINT aerolineas_pkey PRIMARY KEY (idaerolinea);


--
-- TOC entry 2895 (class 2606 OID 26307)
-- Name: avion avion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.avion
    ADD CONSTRAINT avion_pkey PRIMARY KEY (id_avion);


--
-- TOC entry 2889 (class 2606 OID 26110)
-- Name: hangares hangares_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hangares
    ADD CONSTRAINT hangares_pkey PRIMARY KEY (id_hangar);


--
-- TOC entry 2891 (class 2606 OID 26169)
-- Name: piloto piloto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.piloto
    ADD CONSTRAINT piloto_pkey PRIMARY KEY (cedula);


--
-- TOC entry 2885 (class 2606 OID 26053)
-- Name: usuario_aeropuerto usuario_aeropuerto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_aeropuerto
    ADD CONSTRAINT usuario_aeropuerto_pkey PRIMARY KEY (cedula);


--
-- TOC entry 2887 (class 2606 OID 26171)
-- Name: usuario_sistema_aeropuerto usuario_sistema_aeropuerto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_sistema_aeropuerto
    ADD CONSTRAINT usuario_sistema_aeropuerto_pkey PRIMARY KEY (usuario_aeropuerto_cedula);


--
-- TOC entry 2897 (class 2606 OID 42581)
-- Name: vuelo vuelo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vuelo
    ADD CONSTRAINT vuelo_pkey PRIMARY KEY (idvuelo);


--
-- TOC entry 2900 (class 2606 OID 26308)
-- Name: avion fk_avion_aerolineas1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.avion
    ADD CONSTRAINT fk_avion_aerolineas1 FOREIGN KEY (idaerolinea) REFERENCES public.aerolineas(idaerolinea);


--
-- TOC entry 2899 (class 2606 OID 26338)
-- Name: usuario_sistema_aerolinea fk_usuario_sistema_aerolinea_aerolineas1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_sistema_aerolinea
    ADD CONSTRAINT fk_usuario_sistema_aerolinea_aerolineas1 FOREIGN KEY (idaerolinea) REFERENCES public.aerolineas(idaerolinea) ON DELETE CASCADE;


--
-- TOC entry 2898 (class 2606 OID 34364)
-- Name: usuario_sistema_aeropuerto fk_usuarios_aeropuerto_usuario_aeropuerto1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_sistema_aeropuerto
    ADD CONSTRAINT fk_usuarios_aeropuerto_usuario_aeropuerto1 FOREIGN KEY (usuario_aeropuerto_cedula) REFERENCES public.usuario_aeropuerto(cedula) ON DELETE CASCADE;


--
-- TOC entry 2901 (class 2606 OID 42582)
-- Name: vuelo fk_vuelo_avion1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vuelo
    ADD CONSTRAINT fk_vuelo_avion1 FOREIGN KEY (id_avion) REFERENCES public.avion(id_avion);


--
-- TOC entry 2902 (class 2606 OID 42587)
-- Name: vuelo fk_vuelo_piloto1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vuelo
    ADD CONSTRAINT fk_vuelo_piloto1 FOREIGN KEY (piloto_cedula) REFERENCES public.piloto(cedula);


-- Completed on 2021-09-18 22:51:19

--
-- PostgreSQL database dump complete
--

