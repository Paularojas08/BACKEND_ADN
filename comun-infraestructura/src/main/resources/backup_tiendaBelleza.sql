--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

-- Started on 2021-01-12 17:51:46

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
-- TOC entry 201 (class 1259 OID 16941)
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
-- TOC entry 200 (class 1259 OID 16939)
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
-- TOC entry 3076 (class 0 OID 0)
-- Dependencies: 200
-- Name: clientes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.clientes_id_seq OWNED BY public.clientes.id;


--
-- TOC entry 205 (class 1259 OID 16969)
-- Name: detallepedidos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detallepedidos (
    id integer NOT NULL,
    cantidadpedida bigint NOT NULL,
    vendedor_id bigint,
    cliente_id bigint,
    producto_id character varying(50) NOT NULL,
    pedido_id bigint NOT NULL
);


ALTER TABLE public.detallepedidos OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16967)
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
-- TOC entry 3077 (class 0 OID 0)
-- Dependencies: 204
-- Name: detallepedidos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.detallepedidos_id_seq OWNED BY public.detallepedidos.id;


--
-- TOC entry 211 (class 1259 OID 17017)
-- Name: municipios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.municipios (
    id integer NOT NULL,
    nombre character varying(50) NOT NULL,
    codigomunicipio bigint NOT NULL
);


ALTER TABLE public.municipios OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 17015)
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
-- TOC entry 3078 (class 0 OID 0)
-- Dependencies: 210
-- Name: municipios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.municipios_id_seq OWNED BY public.municipios.id;


--
-- TOC entry 207 (class 1259 OID 16977)
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
-- TOC entry 206 (class 1259 OID 16975)
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
-- TOC entry 3079 (class 0 OID 0)
-- Dependencies: 206
-- Name: pedidos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pedidos_id_seq OWNED BY public.pedidos.id;


--
-- TOC entry 209 (class 1259 OID 16987)
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
-- TOC entry 208 (class 1259 OID 16985)
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
-- TOC entry 3080 (class 0 OID 0)
-- Dependencies: 208
-- Name: productos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.productos_id_seq OWNED BY public.productos.id;


--
-- TOC entry 213 (class 1259 OID 17025)
-- Name: tarifas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarifas (
    id integer NOT NULL,
    idmunicipio bigint,
    precio double precision NOT NULL
);


ALTER TABLE public.tarifas OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 17023)
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
-- TOC entry 3081 (class 0 OID 0)
-- Dependencies: 212
-- Name: tarifas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tarifas_id_seq OWNED BY public.tarifas.id;


--
-- TOC entry 203 (class 1259 OID 16954)
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
-- TOC entry 202 (class 1259 OID 16952)
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
-- TOC entry 3082 (class 0 OID 0)
-- Dependencies: 202
-- Name: vendedores_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vendedores_id_seq OWNED BY public.vendedores.id;


--
-- TOC entry 2888 (class 2604 OID 16944)
-- Name: clientes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes ALTER COLUMN id SET DEFAULT nextval('public.clientes_id_seq'::regclass);


--
-- TOC entry 2890 (class 2604 OID 16972)
-- Name: detallepedidos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallepedidos ALTER COLUMN id SET DEFAULT nextval('public.detallepedidos_id_seq'::regclass);


--
-- TOC entry 2893 (class 2604 OID 17020)
-- Name: municipios id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.municipios ALTER COLUMN id SET DEFAULT nextval('public.municipios_id_seq'::regclass);


--
-- TOC entry 2891 (class 2604 OID 16980)
-- Name: pedidos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos ALTER COLUMN id SET DEFAULT nextval('public.pedidos_id_seq'::regclass);


--
-- TOC entry 2892 (class 2604 OID 16990)
-- Name: productos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productos ALTER COLUMN id SET DEFAULT nextval('public.productos_id_seq'::regclass);


--
-- TOC entry 2894 (class 2604 OID 17028)
-- Name: tarifas id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarifas ALTER COLUMN id SET DEFAULT nextval('public.tarifas_id_seq'::regclass);


--
-- TOC entry 2889 (class 2604 OID 16957)
-- Name: vendedores id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendedores ALTER COLUMN id SET DEFAULT nextval('public.vendedores_id_seq'::regclass);


--
-- TOC entry 3058 (class 0 OID 16941)
-- Dependencies: 201
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3062 (class 0 OID 16969)
-- Dependencies: 205
-- Data for Name: detallepedidos; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.detallepedidos (id, cantidadpedida, vendedor_id, cliente_id, producto_id, pedido_id) VALUES (2, 2, NULL, NULL, '354', 3);
INSERT INTO public.detallepedidos (id, cantidadpedida, vendedor_id, cliente_id, producto_id, pedido_id) VALUES (3, 1, NULL, NULL, '12', 3);


--
-- TOC entry 3068 (class 0 OID 17017)
-- Dependencies: 211
-- Data for Name: municipios; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.municipios (id, nombre, codigomunicipio) VALUES (1, 'Armenia', 1);


--
-- TOC entry 3064 (class 0 OID 16977)
-- Dependencies: 207
-- Data for Name: pedidos; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pedidos (id, identificadorseguimiento, fechapedido, fechaenvio, preciototal, estado) VALUES (3, '1ce71597-be84-4c95-9eae-5a9ef00e02c3', '2021-01-12', NULL, 167000, 'CREADO');


--
-- TOC entry 3066 (class 0 OID 16987)
-- Dependencies: 209
-- Data for Name: productos; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.productos (id, codigo, nombre, precio) VALUES (1, '354', 'plancha', 120000);
INSERT INTO public.productos (id, codigo, nombre, precio) VALUES (2, '12', 'cepillo', 45000);


--
-- TOC entry 3070 (class 0 OID 17025)
-- Dependencies: 213
-- Data for Name: tarifas; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tarifas (id, idmunicipio, precio) VALUES (1, 1, 2000);


--
-- TOC entry 3060 (class 0 OID 16954)
-- Dependencies: 203
-- Data for Name: vendedores; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3083 (class 0 OID 0)
-- Dependencies: 200
-- Name: clientes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clientes_id_seq', 1, false);


--
-- TOC entry 3084 (class 0 OID 0)
-- Dependencies: 204
-- Name: detallepedidos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.detallepedidos_id_seq', 3, true);


--
-- TOC entry 3085 (class 0 OID 0)
-- Dependencies: 210
-- Name: municipios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.municipios_id_seq', 1, true);


--
-- TOC entry 3086 (class 0 OID 0)
-- Dependencies: 206
-- Name: pedidos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedidos_id_seq', 3, true);


--
-- TOC entry 3087 (class 0 OID 0)
-- Dependencies: 208
-- Name: productos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.productos_id_seq', 2, true);


--
-- TOC entry 3088 (class 0 OID 0)
-- Dependencies: 212
-- Name: tarifas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tarifas_id_seq', 1, true);


--
-- TOC entry 3089 (class 0 OID 0)
-- Dependencies: 202
-- Name: vendedores_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.vendedores_id_seq', 1, false);


--
-- TOC entry 2896 (class 2606 OID 16951)
-- Name: clientes clientes_cedula_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_cedula_key UNIQUE (cedula);


--
-- TOC entry 2898 (class 2606 OID 16949)
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (id);


--
-- TOC entry 2906 (class 2606 OID 16974)
-- Name: detallepedidos detallepedidos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallepedidos
    ADD CONSTRAINT detallepedidos_pkey PRIMARY KEY (id);


--
-- TOC entry 2916 (class 2606 OID 17022)
-- Name: municipios municipios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.municipios
    ADD CONSTRAINT municipios_pkey PRIMARY KEY (id);


--
-- TOC entry 2908 (class 2606 OID 16984)
-- Name: pedidos pedidos_identificadorseguimiento_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedidos_identificadorseguimiento_key UNIQUE (identificadorseguimiento);


--
-- TOC entry 2910 (class 2606 OID 16982)
-- Name: pedidos pedidos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedidos_pkey PRIMARY KEY (id);


--
-- TOC entry 2912 (class 2606 OID 16994)
-- Name: productos productos_codigo_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_codigo_key UNIQUE (codigo);


--
-- TOC entry 2914 (class 2606 OID 16992)
-- Name: productos productos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (id);


--
-- TOC entry 2918 (class 2606 OID 17032)
-- Name: tarifas tarifas_idmunicipio_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarifas
    ADD CONSTRAINT tarifas_idmunicipio_key UNIQUE (idmunicipio);


--
-- TOC entry 2920 (class 2606 OID 17030)
-- Name: tarifas tarifas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarifas
    ADD CONSTRAINT tarifas_pkey PRIMARY KEY (id);


--
-- TOC entry 2900 (class 2606 OID 16964)
-- Name: vendedores vendedores_cedula_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendedores
    ADD CONSTRAINT vendedores_cedula_key UNIQUE (cedula);


--
-- TOC entry 2902 (class 2606 OID 16966)
-- Name: vendedores vendedores_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendedores
    ADD CONSTRAINT vendedores_email_key UNIQUE (email);


--
-- TOC entry 2904 (class 2606 OID 16962)
-- Name: vendedores vendedores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendedores
    ADD CONSTRAINT vendedores_pkey PRIMARY KEY (id);


--
-- TOC entry 2923 (class 2606 OID 17000)
-- Name: detallepedidos fk_clientes_idcliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallepedidos
    ADD CONSTRAINT fk_clientes_idcliente FOREIGN KEY (cliente_id) REFERENCES public.clientes(id);


--
-- TOC entry 2921 (class 2606 OID 17038)
-- Name: clientes fk_municipios_idmunicipio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT fk_municipios_idmunicipio FOREIGN KEY (idmunicipio) REFERENCES public.municipios(id);


--
-- TOC entry 2925 (class 2606 OID 17010)
-- Name: detallepedidos fk_pedidos_idpedido; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallepedidos
    ADD CONSTRAINT fk_pedidos_idpedido FOREIGN KEY (pedido_id) REFERENCES public.pedidos(id);


--
-- TOC entry 2924 (class 2606 OID 17005)
-- Name: detallepedidos fk_productos_idproducto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallepedidos
    ADD CONSTRAINT fk_productos_idproducto FOREIGN KEY (producto_id) REFERENCES public.productos(codigo);


--
-- TOC entry 2922 (class 2606 OID 16995)
-- Name: detallepedidos fk_vendedores_idvendedor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallepedidos
    ADD CONSTRAINT fk_vendedores_idvendedor FOREIGN KEY (vendedor_id) REFERENCES public.vendedores(id);


--
-- TOC entry 2926 (class 2606 OID 17033)
-- Name: tarifas tarifas_idmunicipio_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarifas
    ADD CONSTRAINT tarifas_idmunicipio_fkey FOREIGN KEY (idmunicipio) REFERENCES public.municipios(id);


-- Completed on 2021-01-12 17:51:47

--
-- PostgreSQL database dump complete
--

