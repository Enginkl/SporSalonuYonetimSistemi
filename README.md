# Vücut Geliştirme ve Spor Salonu Yönetim Sistemi

Bu proje, Nesne Yönelimli Programlama (OOP) prensipleri eksiksiz şekilde kullanılarak geliştirilmiş, konsol tabanlı dinamik bir spor salonu yönetim sistemidir. Sistem, üyelerin ve eğitmenlerin verilerini bellek üzerinde güvenli bir şekilde yönetmekte, VIP üyelere özel eğitmen ataması yapmakta ve hoca kapasitelerini otomatik olarak kontrol etmektedir.

## 🚀 Özellikler

*   **Dinamik Üye Yönetimi:** Standart ve VIP olmak üzere iki farklı üye tipi eklenebilir ve ID numaraları üzerinden sistemden silinebilir. Otomatik ID ataması ile veri çakışmaları engellenmiştir.
*   **Eğitmen Kontenjan Sistemi:** Her eğitmenin kapasitesi 5 kişi ile sınırlandırılmıştır. Kontenjanı dolan eğitmene yeni bir VIP üye ataması sistem tarafından reddedilir.
*   **Vücut Kitle İndeksi (VKİ) ve Antrenman Ataması:** Üyelerin güncel boy ve kilo metriklerine göre VKİ hesaplanır ve amaca uygun (Bulking, Definisyon, Güç) idman programı otomatik olarak atanır.
*   **Çok Biçimli (Polymorphic) Fiyatlandırma:** Üye tipine göre aidat tutarları (Standart veya VIP farkı) dinamik olarak hesaplanarak listelenir.

## 🛠️ Kullanılan Teknolojiler ve Mimari Kavramlar

*   **Dil:** Java
*   **OOP Prensipleri:** 
    *   **Kalıtım (Inheritance):** Üye ve Eğitmen sınıflarının temel `Kisi` soyut sınıfından türetilmesi.
    *   **Çok Biçimlilik (Polymorphism):** Ortak metodların (örn: aidat hesaplama, rol bildirme) alt sınıflarda ihtiyaca göre ezilmesi (Override).
    *   **Kapsülleme (Encapsulation):** Kritik verilerin (kontenjan, özel ölçümler) dışarıdan manipüle edilmesini engellemek için `private` değişkenler ve erişim belirleyiciler.
    *   **Soyutlama (Abstraction):** Ortak davranış şablonlarını belirlemek.
*   **Veri Yapıları:** Nesnelerin dinamik ve esnek bir şekilde bellekte tutulabilmesi için Java Collections Framework (`ArrayList`) kullanımı.
*   **Tasarım Mimarisi:** VIP üyelerin, salt metin (String) yerine doğrudan Eğitmen nesneleriyle eşleştirilmesini sağlayan **Composition (Bileştirme)** yaklaşımı.
*   **İleri Seviye Java:** Arayüzler (Interfaces), Soyut Sınıflar (Abstract Classes) ve Jenerik Yapılar (Generics - `IslemCevabi<T>`).

## 📂 Proje (Paket) Yapısı

Proje, sorumlulukların ayrılması (Separation of Concerns) kuralına sadık kalarak şu paketlere bölünmüştür:

*   `models/`: Veri kalıplarını oluşturan temel ve türetilmiş sınıflar (`Kisi`, `Uye`, `StandartUye`, `VIPUye`, `Egitmen`). 
*   `services/`: Verilerin saklandığı, ArrayList yönetiminin, kontrollerin ve ana iş mantığının yürütüldüğü merkez sınıf (`SporSalonuManager`).
*   `interfaces/`: Ortak eylem şablonlarının belirlendiği arayüzler (`IAntrenmanYapilabilir`).
*   `Main.java`: Kullanıcıyla etkileşimi (Scanner) ve sonsuz döngü ana menüsünü barındıran vitrin sınıfı.

## ⚙️ Nasıl Çalıştırılır?

1.  Bu depoyu kendi bilgisayarınıza klonlayın.
2.  Projeyi tercih ettiğiniz geliştirme ortamında (IntelliJ IDEA, Eclipse vb.) açın.
3.  `src/sporsalonu/Main.java` dosyasını derleyip çalıştırarak konsol menüsü üzerinden sistemi kullanmaya başlayabilirsiniz.
