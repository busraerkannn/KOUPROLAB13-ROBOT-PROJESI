Robot Projesi

B��ra Erkan - 170201018
G�zde �rg�  - 170201005

Bu readme.txt dosyas�,Robot  Projesi'ne aittir.
Bu paket, kaynak kodu ile ayn� dizin i�erisinde bulunacakt�r.

1-PAKET�N ��ER���:
------------
170201018-170201005.txt -Projenin tek dosyaya indirgenmi� salt kaynak kodu.
readme.txt - Bu dosya.
kaynak.zip - Projenin kaynak kodunun ve yard�mc� dosyalar�n ziplenmi� hali.
rapor.pdf - Proje raporu
------------

2-S�STEM GEREKS�N�MLER�:
------------
java - Oracle Java� - http://java.com/
------------

3-KURULUM
------------
Paket i�eri�ini yukar�da g�rebilirsiniz.

Bu kod, iki adet Windows kurulu makinede �al��t�r�ld�.

Bu iki durumda da kod, herhangi bir hata vermeden, daha �nceden belirlenen kriterlere
uygun �al��t�.

�n gereklilik:

Projeyi �al��t�rmak i�in NetBeans IDE kullan�ld�.

-------------------

4-KODU DERLEMEK:
------------------
Art�k bilgisayar�m�zda kurulu olan Java ile kodu kolayca derleyebiliriz.

Projeyi derlemek i�in NetBeans IDE'de Run file butonuna
t�klayabilirsiniz.

Derleme bittikten sonra kolayca program� �al��t�rabilirsiniz.
------------------

5- PARAMETRELER
------------------
Kodun �al��mas� i�in ba�lang��ta herhangi bir parametre gerekmiyor.
------------------

6- PROGRAMIN KULLANIMI
------------------
Program sizden tan�mlanacak robot say�s�n� isteyecek. Robot say�s�n� girdikten sonra robot say�s�
kadar tanmlanacak robot tipi istenecek. Robot tipi olarak "gezgin, gezmeyen/manip�lat�r, hibrit"
se�eneklerinden birini girmeniz gerekmektedir.

Robot tipi gezgin ise "Tekerlekli, Paletli, Spider" t�rlerinden birini se�meniz gerekmektedir. Se�im
sonucunda sizden motor say�s�, y�k miktar� ve tekerlek say�s�/ palet say�s�/ bacak say�s� girmeniz
beklenir. 

Robot tipi manip�lat�r ise "Seri, Paralel" t�rlerinden birini se�meniz gerekmektedir. Se�im
sonucunda sizden motor say�s�, y�k miktar�, y�k ta��ma kapasitesi, ta��ma h�z� ve kol uzunlu�u
girmeniz beklenir.

Robot tipi hibrit ise "Tekerlekli-Seri, Paletli-Seri, Spider-Seri, Tekerlekli-Paralel, Paletli-Paralel, 
Spider-Paralel" t�rlerinden birini se�meniz gerekmektedir.Se�im sonucunda sizden motor say�s�, 
y�k miktar�, tekerlek say�s�/ palet say�s�/ bacak say�s�, y�k ta��ma kapasitesi, ta��ma h�z� ve kol 
uzunlu�u girmeniz beklenir. 

Daha sonra program sizden hangi s�radaki robotu hareket ettirmek istedi�inizi soracakt�r.
�stedi�iniz robotun s�ras�n� girmelisiniz. E�er se�ti�iniz robot gezgin veya hibrit ise engel
yerle�tirmek isteyip istemedi�iniz sorulacakt�r. �stiyorsan�z engel say�s�n� girmelisiniz. 

(Varsa engel say�s� kadar) engel konumu, robotun ba�lang�� noktas� ve y�n bilgilerini 
girdikten sonra 20x20 boyutlu �zgara �zerindeki (varsa) engeli, robotun ilk ve son konumlar�n�
ekranda g�rebilirsiniz.

------------------