
-- 1)
SELECT * FROM public.clienti where nome='mario';

-- 2)
select nome, cognome from public.clienti where anno_di_nascita='1982';

-- 3)
select * from public.fatture where iva='20';

-- 4)
select * from public.prodotti where EXTRACT (YEAR FROM data_attivazione)='2017' 
and (in_produzione=true or in_commercio=true);

-- 5)
select * from public.fatture f inner join public.clienti c 
on f.id_cliente=c.numero_cliente
where f.importo<1000;

-- 6)
select numero_fattura, importo, iva, data_fattura, o.denominazione 
from public.fatture f inner join public.fornitori o 
on f.numero_fornitore=o.numero_fornitore;

-- 7)
select extract (year from data_fattura) anno, count(*) numero_fatture
from public.fatture where iva='20'
group by anno;

-- 8)
select extract (year from data_fattura) anno, count(*) numero_fatture, sum(importo) importo_totale
from public.fatture 
group by anno;

-- 9 EXTRA
select extract (year from data_fattura) anno, count(*) numero_fatture
from public.fatture where tipologia='A' 
group by anno
having count(*)>2

--10 EXTRA Totale importo fatture divisi per regione di residenza clienti
select sum(importo), regione_residenza from public.clienti c inner join public.fatture f
on c.numero_cliente=f.id_cliente
group by c.regione_residenza;

--EXTRA 
select count(distinct numero_cliente) from public.clienti c
inner join public.fatture f
on c.numero_cliente=f.id_cliente
where f.importo>50 and c.anno_di_nascita='1980';








