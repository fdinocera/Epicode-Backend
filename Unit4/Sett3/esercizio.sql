


--SELECT * FROM public.clienti where nome='mario';

--select nome, cognome from public.clienti where anno_di_nascita='1982';


select * from public.fatture where iva='20';

select * from public.prodotti where EXTRACT (YEAR FROM data_attivazione)='2017';


--select * from public.fatture f  where f.importo<1000;

select * from public.fatture f  inner join public.clienti c  on f.id_cliente=c.numero_cliente
where f.importo<1000;


select numero_fattura, importo, iva, data_fattura, o.denominazione from public.fatture f inner join public.fornitori o 
on f.numero_fornitore=o.numero_fornitore;

