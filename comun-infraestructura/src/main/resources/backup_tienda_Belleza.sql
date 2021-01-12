--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

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
-- Name: clientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clientes (
    id integer NOT NULL,
    idmunicipio bigint NOT NULL,
    cedula character varying(50) NOT NULL,
    nombre character varying(255) NOT NULL,
    telefono character varying(50) NOT NULL,
    direccion character varying(255) NOT NULL
);


ALTER TABLE public.clientes OWNER TO postgres;

--
-- Name: clientes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clientes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clientes_id_seq OWNER TO postgres;

--
-- Name: clientes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.clientes_id_seq OWNED BY public.clientes.id;


--
-- Name: detallepedidos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detallepedidos (
    id integer NOT NULL,
    cantidadpedida bigint NOT NULL,
    vendedor_id bigint,
    cliente_id bigint,
    producto_id bigint NOT NULL,
    pedido_id bigint NOT NULL
);


ALTER TABLE public.detallepedidos OWNER TO postgres;

--
-- Name: detallepedidos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.detallepedidos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detallepedidos_id_seq OWNER TO postgres;

--
-- Name: detallepedidos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.detallepedidos_id_seq OWNED BY public.detallepedidos.id;


--
-- Name: municipios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.municipios (
    id integer NOT NULL,
    nombre character varying(50) NOT NULL,
    codigomunicipio bigint NOT NULL
);


ALTER TABLE public.municipios OWNER TO postgres;

--
-- Name: municipios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.municipios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.municipios_id_seq OWNER TO postgres;

--
-- Name: municipios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.municipios_id_seq OWNED BY public.municipios.id;


--
-- Name: pedidos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedidos (
    id integer NOT NULL,
    identificadorseguimiento character varying(50) NOT NULL,
    fechapedido character varying(50) NOT NULL,
    fechaenvio character varying(50),
    preciototal double precision NOT NULL,
    estado character varying(50) NOT NULL
);


ALTER TABLE public.pedidos OWNER TO postgres;

--
-- Name: pedidos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pedidos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pedidos_id_seq OWNER TO postgres;

--
-- Name: pedidos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pedidos_id_seq OWNED BY public.pedidos.id;


--
-- Name: productos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.productos (
    id integer NOT NULL,
    codigo character varying(50) NOT NULL,
    nombre character varying(50) NOT NULL,
    precio double precision NOT NULL
);


ALTER TABLE public.productos OWNER TO postgres;

--
-- Name: productos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.productos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.productos_id_seq OWNER TO postgres;

--
-- Name: productos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.productos_id_seq OWNED BY public.productos.id;


--
-- Name: tarifas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarifas (
    id integer NOT NULL,
    idmunicipio bigint,
    precio double precision NOT NULL
);


ALTER TABLE public.tarifas OWNER TO postgres;

--
-- Name: tarifas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tarifas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tarifas_id_seq OWNER TO postgres;

--
-- Name: tarifas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tarifas_id_seq OWNED BY public.tarifas.id;


--
-- Name: vendedores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendedores (
    id integer NOT NULL,
    cedula character varying(50) NOT NULL,
    nombre character varying(255) NOT NULL,
    password character varying(50) NOT NULL,
    email character varying(255) NOT NULL
);


ALTER TABLE public.vendedores OWNER TO postgres;

--
-- Name: vendedores_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vendedores_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vendedores_id_seq OWNER TO postgres;

--
-- Name: vendedores_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vendedores_id_seq OWNED BY public.vendedores.id;


--
-- Name: clientes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes ALTER COLUMN id SET DEFAULT nextval('public.clientes_id_seq'::regclass);


--
-- Name: detallepedidos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallepedidos ALTER COLUMN id SET DEFAULT nextval('public.detallepedidos_id_seq'::regclass);


--
-- Name: municipios id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.municipios ALTER COLUMN id SET DEFAULT nextval('public.municipios_id_seq'::regclass);


--
-- Name: pedidos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos ALTER COLUMN id SET DEFAULT nextval('public.pedidos_id_seq'::regclass);


--
-- Name: productos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productos ALTER COLUMN id SET DEFAULT nextval('public.productos_id_seq'::regclass);


--
-- Name: tarifas id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarifas ALTER COLUMN id SET DEFAULT nextval('public.tarifas_id_seq'::regclass);


--
-- Name: vendedores id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendedores ALTER COLUMN id SET DEFAULT nextval('public.vendedores_id_seq'::regclass);


--
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: detallepedidos; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.detallepedidos VALUES (13, 2, NULL, NULL, 1, 25);
INSERT INTO public.detallepedidos VALUES (14, 1, NULL, NULL, 2, 25);
INSERT INTO public.detallepedidos VALUES (15, 2, NULL, NULL, 1, 26);
INSERT INTO public.detallepedidos VALUES (16, 1, NULL, NULL, 2, 26);
INSERT INTO public.detallepedidos VALUES (17, 2, NULL, NULL, 1, 27);
INSERT INTO public.detallepedidos VALUES (18, 1, NULL, NULL, 2, 27);
INSERT INTO public.detallepedidos VALUES (19, 2, NULL, NULL, 1, 28);
INSERT INTO public.detallepedidos VALUES (20, 1, NULL, NULL, 2, 28);
INSERT INTO public.detallepedidos VALUES (21, 2, NULL, NULL, 1, 29);
INSERT INTO public.detallepedidos VALUES (22, 1, NULL, NULL, 2, 29);
INSERT INTO public.detallepedidos VALUES (23, 2, NULL, NULL, 1, 30);
INSERT INTO public.detallepedidos VALUES (24, 1, NULL, NULL, 2, 30);


--
-- Data for Name: municipios; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.municipios VALUES (1, 'ARMENIA', 1);


--
-- Data for Name: pedidos; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pedidos VALUES (25, 'e21a70d0-131b-41c7-b90e-cfee9abf7ec0', '2021-01-11 -05', NULL, 1015500, 'CREADO');
INSERT INTO public.pedidos VALUES (26, 'cc28d846-9171-47f3-99c9-6350e010eb8b', '2021-01-11 -05', NULL, 1015500, 'CREADO');
INSERT INTO public.pedidos VALUES (27, '1de18d39-30d8-449d-bb43-6b34bb46c5d6', '2021-01-11 -05', NULL, 1523250, 'CREADO');
INSERT INTO public.pedidos VALUES (28, '0f7d51af-9c50-43b0-bdcc-7983674fc622', '2021-01-11 -05', NULL, 1015500, 'CREADO');
INSERT INTO public.pedidos VALUES (29, '28bdbc04-38fe-4d40-8703-8c325684b4d7', '2021-01-11 -05', NULL, 1015500, 'CREADO');
INSERT INTO public.pedidos VALUES (30, 'ed8385a6-92da-4e73-8038-e8458097ec03', '2021-01-12 -05', NULL, 1015500, 'CREADO');


--
-- Data for Name: productos; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.productos VALUES (1, '354', 'cepillo secador', 225000);
INSERT INTO public.productos VALUES (2, '12', 'plancha', 450000);


--
-- Data for Name: tarifas; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tarifas VALUES (1, 1, 2000);


--
-- Data for Name: vendedores; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: clientes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clientes_id_seq', 1, false);


--
-- Name: detallepedidos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.detallepedidos_id_seq', 24, true);


--
-- Name: municipios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.municipios_id_seq', 1, false);


--
-- Name: pedidos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedidos_id_seq', 30, true);


--
-- Name: productos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.productos_id_seq', 2, true);


--
-- Name: tarifas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tarifas_id_seq', 1, false);


--
-- Name: vendedores_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.vendedores_id_seq', 1, false);


--
-- Name: clientes clientes_cedula_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_cedula_key UNIQUE (cedula);


--
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (id);


--
-- Name: detallepedidos detallepedidos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallepedidos
    ADD CONSTRAINT detallepedidos_pkey PRIMARY KEY (id);


--
-- Name: municipios municipios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.municipios
    ADD CONSTRAINT municipios_pkey PRIMARY KEY (id);


--
-- Name: pedidos pedidos_identificadorseguimiento_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedidos_identificadorseguimiento_key UNIQUE (identificadorseguimiento);


--
-- Name: pedidos pedidos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedidos_pkey PRIMARY KEY (id);


--
-- Name: productos productos_codigo_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_codigo_key UNIQUE (codigo);


--
-- Name: productos productos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (id);


--
-- Name: tarifas tarifas_idmunicipio_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarifas
    ADD CONSTRAINT tarifas_idmunicipio_key UNIQUE (idmunicipio);


--
-- Name: tarifas tarifas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarifas
    ADD CONSTRAINT tarifas_pkey PRIMARY KEY (id);


--
-- Name: vendedores vendedores_cedula_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendedores
    ADD CONSTRAINT vendedores_cedula_key UNIQUE (cedula);


--
-- Name: vendedores vendedores_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendedores
    ADD CONSTRAINT vendedores_email_key UNIQUE (email);


--
-- Name: vendedores vendedores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendedores
    ADD CONSTRAINT vendedores_pkey PRIMARY KEY (id);


--
-- Name: detallepedidos fk_clientes_idcliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallepedidos
    ADD CONSTRAINT fk_clientes_idcliente FOREIGN KEY (cliente_id) REFERENCES public.clientes(id);


--
-- Name: clientes fk_municipios_idmunicipio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT fk_municipios_idmunicipio FOREIGN KEY (idmunicipio) REFERENCES public.municipios(id);


--
-- Name: detallepedidos fk_pedidos_idpedido; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallepedidos
    ADD CONSTRAINT fk_pedidos_idpedido FOREIGN KEY (pedido_id) REFERENCES public.pedidos(id);


--
-- Name: detallepedidos fk_productos_idproducto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallepedidos
    ADD CONSTRAINT fk_productos_idproducto FOREIGN KEY (producto_id) REFERENCES public.productos(id);


--
-- Name: detallepedidos fk_vendedores_idvendedor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallepedidos
    ADD CONSTRAINT fk_vendedores_idvendedor FOREIGN KEY (vendedor_id) REFERENCES public.vendedores(id);


--
-- Name: tarifas tarifas_idmunicipio_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarifas
    ADD CONSTRAINT tarifas_idmunicipio_fkey FOREIGN KEY (idmunicipio) REFERENCES public.municipios(id);


--
-- PostgreSQL database dump complete
--

