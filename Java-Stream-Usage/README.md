<h1 align="center"> :bookmark_tabs: Enuygun - Test Automation Bootcamp - HW6_1 </h1>
 

> ##  ```Stream map, stream filter foreach vb. çalışılacak.  ```



 ![0_QCmZZpGs_rcF5y2-](https://user-images.githubusercontent.com/102550569/184213834-657b8456-a054-4aad-96a8-335c1b8881ab.jpg)
 
### **Stream Api nedir? ?**
---
Hepimiz bir şekilde veri setleri ile işlemler yapıyoruz. En basitinden küçükten büyüğe veya büyükten küçüğe sıralamak bir veri seti işlemi. Veri setleri deyince aklımıza ilk gelen veri yapıları Listeler veya Diziler olabilir. Java 8 ile birlikte gelen Stream Api desteği, veriler üzerinde yapacağımız işlemleri temiz ve anlaşılır bir şekilde ifade edebilmemize olanak sağlıyor.


Stream Api İşlemleri

1. filter(): Filtreleme işlemi yapmamızı sağlar, verilen kriterlere göre arama yapar. Bu filtreleme birden fazla şekilde de yapabilir. startsWith baş harfine göre arama yapar.


2. sorted(): Sıralama yapmamızı sağlar. Yazı ise harf sırası ( sözlük mantığı şeklinde ) sayı ise küçükten büyüğe.


3. reduce(): Yapılan işlemi teker teker basamaklarını göstererek işlemi yapar. Bir veri setinde sırayla işlem yapmak istieniyorsa ve bir önceki yapılan işlem de dahil edilmek isteniyorsa reduce metodu kullanılabilir. 


4. map(): Stream içerisindeki elemanları başka tiplere dönüştürmek veya üzerlerinde işlem yapmak için Map kullanılmaktadır.


5. Match: Match operasyonu bir akışın belirli kriterleri sağlayıp sağlamadığını ölçmek için kullanılır. Map den farkı her iterasyonu tek tek değerlendirip sonucu yansıtmaz bunun yerine tüm koleksiyonu değerlendirerek sonucu yansıtmasıdır. Match operasyonunun 3 çeşit kullanımı bulunmaktadır.

   - noneMatch: Belirtilen kriter listede hiçbir elemanda bulunmuyor ise true döndürür.

   - allMatch: Belirtilen kriter listede tüm elemanlarda bulunuyor ise true döndürür.

   - anyMatch: Belirtilen kriter listede herhangi bir elemanlarda bulunuyor ise true döndürür. 

6. distinct(): Listede aynı değere sahip olanları tek bir değere indirger.


7. count(): Toplam veri sayısını gösterir.


