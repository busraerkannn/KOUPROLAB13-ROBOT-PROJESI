Robot Projesi

Büþra Erkan - 170201018
Gözde Örgü  - 170201005

Bu readme.txt dosyasý,Robot  Projesi'ne aittir.
Bu paket, kaynak kodu ile ayný dizin içerisinde bulunacaktýr.

1-PAKETÝN ÝÇERÝÐÝ:
------------
170201018-170201005.txt -Projenin tek dosyaya indirgenmiþ salt kaynak kodu.
readme.txt - Bu dosya.
kaynak.zip - Projenin kaynak kodunun ve yardýmcý dosyalarýn ziplenmiþ hali.
rapor.pdf - Proje raporu
------------

2-SÝSTEM GEREKSÝNÝMLERÝ:
------------
java - Oracle Java™ - http://java.com/
------------

3-KURULUM
------------
Paket içeriðini yukarýda görebilirsiniz.

Bu kod, iki adet Windows kurulu makinede çalýþtýrýldý.

Bu iki durumda da kod, herhangi bir hata vermeden, daha önceden belirlenen kriterlere
uygun çalýþtý.

Ön gereklilik:

Projeyi çalýþtýrmak için NetBeans IDE kullanýldý.

-------------------

4-KODU DERLEMEK:
------------------
Artýk bilgisayarýmýzda kurulu olan Java ile kodu kolayca derleyebiliriz.

Projeyi derlemek için NetBeans IDE'de Run file butonuna
týklayabilirsiniz.

Derleme bittikten sonra kolayca programý çalýþtýrabilirsiniz.
------------------

5- PARAMETRELER
------------------
Kodun çalýþmasý için baþlangýçta herhangi bir parametre gerekmiyor.
------------------

6- PROGRAMIN KULLANIMI
------------------
Program sizden tanýmlanacak robot sayýsýný isteyecek. Robot sayýsýný girdikten sonra robot sayýsý
kadar tanmlanacak robot tipi istenecek. Robot tipi olarak "gezgin, gezmeyen/manipülatör, hibrit"
seçeneklerinden birini girmeniz gerekmektedir.

Robot tipi gezgin ise "Tekerlekli, Paletli, Spider" türlerinden birini seçmeniz gerekmektedir. Seçim
sonucunda sizden motor sayýsý, yük miktarý ve tekerlek sayýsý/ palet sayýsý/ bacak sayýsý girmeniz
beklenir. 

Robot tipi manipülatör ise "Seri, Paralel" türlerinden birini seçmeniz gerekmektedir. Seçim
sonucunda sizden motor sayýsý, yük miktarý, yük taþýma kapasitesi, taþýma hýzý ve kol uzunluðu
girmeniz beklenir.

Robot tipi hibrit ise "Tekerlekli-Seri, Paletli-Seri, Spider-Seri, Tekerlekli-Paralel, Paletli-Paralel, 
Spider-Paralel" türlerinden birini seçmeniz gerekmektedir.Seçim sonucunda sizden motor sayýsý, 
yük miktarý, tekerlek sayýsý/ palet sayýsý/ bacak sayýsý, yük taþýma kapasitesi, taþýma hýzý ve kol 
uzunluðu girmeniz beklenir. 

Daha sonra program sizden hangi sýradaki robotu hareket ettirmek istediðinizi soracaktýr.
Ýstediðiniz robotun sýrasýný girmelisiniz. Eðer seçtiðiniz robot gezgin veya hibrit ise engel
yerleþtirmek isteyip istemediðiniz sorulacaktýr. Ýstiyorsanýz engel sayýsýný girmelisiniz. 

(Varsa engel sayýsý kadar) engel konumu, robotun baþlangýç noktasý ve yön bilgilerini 
girdikten sonra 20x20 boyutlu ýzgara üzerindeki (varsa) engeli, robotun ilk ve son konumlarýný
ekranda görebilirsiniz.

------------------