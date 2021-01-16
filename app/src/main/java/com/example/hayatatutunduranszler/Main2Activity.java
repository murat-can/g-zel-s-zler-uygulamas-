package com.example.hayatatutunduranszler;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Main2Activity extends AppCompatActivity {
    private AdView banner;
    int ayniGelmesin;
    int ilksoz;
    int sayi=-1;
    final String[] sozlerDizisiString = {
            "Bir şeyden ümitsiz olan, ondan uzak olur.\n-Hz.Ömer(R.A)-",
            "Sabrın mükâfatı zaferdir\n-Said Nursi(R.A)-",
            "Sabır boyun eğmek değil mücadele etmektir\n-Hz.Ömer(R.A)-",
            "Çalışanlar kötülük etmeye vakit bulamazlar, çalışmayanlar ise kendilerini kötülüklerden kurtaramazlar.\n-Hz.Ali(R.A.)-",
            "İnsana ancak çalıştığının karşılığı vardır.\n-Kur’anı Kerim (Necm,53/39)-",
            "Sabredin! Hüzünsüz bir neşe ve darlıksız bir bolluk olmaz.\n-Abdülkadir Geylani(K.S)-",
            "Ey Can, sana bir daralma gelirse, yararınadır; Kaygılanma. Sürekli yaz mevsimi olsaydı, güneş bahçeyi yakıp kavururdu.\n-Hz.Mevlana Celalettin-i Rumi (K.S.)-",
            "Allah’tan gelene razı olursak Allah da bizden razı olur.\n-Hz.Mevlana Celalettin-i Rumi (K.S.)-",
            "Daha iyisini bilene kadar elinizden gelenin en iyisini yapın. Sonrasında, daha iyisini bildiğinizde, daha iyisini yaparsınız.\n-Maya Angelou-",
            "Başlamak için koşulların mükemmel olmasını beklemeyin. Başlangıç, koşulları mükemmel hale getirecektir.\n-Alan Cohen-",
            "Bir hizmette bulundu isem, bu çalışmaktan ve sabırla düşünmekten, başka bir şey değildir.\n-S.I.Newton-",
            "Çalışma, namussuzluğa giden ilk yolu kapar; her türlü kabiliyetin gösterilebilmesi için geniş sahalar açar ve bütün sosyal ve dini görevlerin yerine getirilebilmesi için insana yeni bir kuvvet verir.\n-Samuel Smiles-",
            "Bilginin efendisi olmak için çalışmanın kölesi olmak gerekir.\n-Balzac-",
            "Taşı delen suyun gücü değil, damlaların sürekliliğidir.\n-Anonim-",
            "İz bırakanlarla senin aranda basit bir fark var sadece. Onlar ömür boyu gayret ediyorlar; sen ömür boyu hayret ediyorsun.\n-Mehmet Akif Ersoy-",
            "Yaşamı olduğu gibi kabul etmelisiniz, fakat kabul edebileceğiniz gibi olması için de çaba göstermelisiniz.\n-Alman Atasözü-",
            "Ümit gidince, yaşamak zevki de gider.\n-Emile Zola-",
            "Umut yoksa girişim de yoktur.\n-Samuel Johnson-",
            "Umutla yaşayan, müzik olmadan da dans eder.\n-George Herbert-",
            "Hayat dardır, doğru, ama umut da geniş.\n-Goethe-",
            "Hayatta insanı mahveden üç şey: Korkaklık, gurur ve öfkedir.\n-Visdomsord-",
            "Korkularımızın, bizi umutlarımızın ardına düşmekten alıkoymasına izin vermemeliyiz.\n-J.F.Kennedy-",
            "Sevinç kapısının anahtarı, sabırdır.\n-W.Jacobs-",
            "Gidişata bakıp üzülme, sabırlı ol sabır acıdır, fakat meyvesi tatlıdır.\n-Sadi Şirazi-",
            "Hata değil, çare bulun.\n-Henry Ford-",
            "Coşku, zekadan daha önemlidir.\n-Albert Einstein-",
            "Birşey tamamıyla elde edilemediği takdirde o şeyi tamamıyla terketmek caiz değildir.\n-Said Nursi (R.A)-",
            "Diş ağrısı çekenler, dişleri sağlam olanları; yoksulluk çekenler, parası bol olanları mutlu sanırlar.\n-G.Bernard Shaw-",
            "Uçamıyorsan, koş; koşamıyorsan, yürü; Eğer yürüyemiyorsan, sürün, ama hareket etmeye devam et. Geleceğe yürümeyi sürdür.\n-Martin Luther King-",
            "Olmadı diye sızlandığın duaya, gün gelir olmadı diye şükredersin.\n-Şems-i Tebrizi (K.S.)-",
            "Dün tecrübedir öğren. Yarın tahmindir planla. Bugün fırsattır kullan.\n-Cemil Meriç-",
            "Bugün uygulamaya geçirilen iyi bir plan, yarın uygulanacak mükemmel bir plandan daha iyidir.\n-G.S.Patton-",
            "Kendi geleceğini planlamayanlar, başkalarının planlanının bir parçası olurlar.\n-A.Robbins-",
            "Mutlu bir hayat yaşamak istiyorsan bir amaca bağlan. İnsanlara ya da eşyalara değil.\n-Albert Einstein-",
            "Hata yapmaktan korkmak, ilerlemenin ölümüdür.\n-Alfred N. Whitehead-",
            "Mutluluğa giden iki yol; kendinden çok şey, başkalarından az şey bekle.\n-Auberon Herbert-",
            "Akıllı adam, aklını kullanır. Daha akıllı adam, başkalarının aklını da kullanır.\n-George B. Shaw-",
            "Ne etrafınızı kıracak kadar sert, ne de karşınızdakilere cesaret verecek kadar yumuşak olunuz.\n-Sadi Şirazi-",
            "Kolaylaştırınız! Zorlaştırmayınız! Müjdeleyiniz, nefret ettirmeyiniz! Birbirinizle anlaşın, iyi geçinin, ihtilâfa düşmeyin.\n-Hz. Muhammed(S.A.V.)(Buharî, 3:72.)-",
            "Cahille oturup bal yiyeceğine, alimle oturup kuru ekmek ye \n-Hz.Mevlana Celalettin-i Rumi (K.S.)-",
            "Bilseniz ki, gayret ne kadar kıymettardır; bir dakika boş durmazdınız\n-Zübeyir Gündüzalp-",
            "Yaptığın işi bütün mevcudiyetinle, hayatın ve mevcudiyetin ona bağlı imiş gibi yap.\n-Zübeyir Gündüzalp-",
            "Deha dikkati değil,dikkat dehayı verir.\n-Zübeyir Gündüzalp-",
            "Yardım almaya alışan, emir almayada alışır.\n-Sultan IV. Murad-",
            "Söz ola kese savaşı söz ola bitire başı\nSöz ola ağılı aşı bal ile yağ ede bir söz\n-Yunus Emre-",
            "Nereye gittiğini bilen kişiye yol vermek için dünya bile bir kenara çekilir.\n-David Starr Jordan-",
            "Başarının sırrı, bir hedefi durmaksızın takip etmektir.\n-Anna Pavlova-",
            "Siz yolunuza bakın. Böyle yaparsanız hedefe kendiliğinden varırsınız.\n-Gandhi-",
            "Bir derdinizin olması, yaşamda bir amacınızın olduğunu gösterir.\n-Alan Coren-",
            "Başarı için plan yapmıyorsanız, o zaman hükmen başarısızlığı planlıyorsunuz demektir.\n-Roz Townsend-",
            "Amacı kesinleştirmek, her başarının başlangıç noktasıdır.\n-W. Clement Stone-",
            "Başarı, hareket halinde olmakla bağlantılıdır. Başarılı insanlar hareket halinde olmaya devam ediyorlar. Hatalar yapıyorlar; ama vazgeçmiyorlar.\n-Conrad Hilton-",
            "Ayağın taşa takıldığında ‘Allah kahretsin’ bile deme, dua et ki taşa takılan bir ayağın var.\n-Necip Fazıl Kısakürek-",


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ilkyazimetodu();
        reklammetodu();
        rastgeleButonuMetodu();
        ileriButonuMetodu();
        geriButonuMetodu();
        paylasButonuMetodu();

    }
    private void ilkyazimetodu() {
        final TextView degisenText = (TextView) findViewById(R.id.degisenYazi);
        int random = (int) (Math.random() * sozlerDizisiString.length);
        ilksoz=random;
        degisenText.setText(sozlerDizisiString[ilksoz]);
    }
    private void reklammetodu() {
        MobileAds.initialize(this,"ca-app-pub-5714708973241718~7006881345");
        banner=findViewById(R.id.banner);
        AdRequest adRequest = new AdRequest.Builder().build();
        banner.loadAd(adRequest);
        banner.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
    }
    private void paylasButonuMetodu() {
        Button paylasatiklandiginda=(Button)findViewById(R.id.paylasButonu);

        paylasatiklandiginda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sayi==-1)
                {sayi=ilksoz;}
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,sozlerDizisiString[sayi] );
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
    }
    private void geriButonuMetodu() {
        Button geriTiklandiginda=(Button)findViewById(R.id.geriButonu);
        final TextView degisenText = (TextView) findViewById(R.id.degisenYazi);
        geriTiklandiginda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sayi==-1){
                    sayi=ilksoz;

                }
                sayi--;
                if(sayi<=-1){
                    sayi=sozlerDizisiString.length-1;;
                    degisenText.setText(sozlerDizisiString[sayi]);
                }
                degisenText.setText(sozlerDizisiString[sayi]);
            }
        });
    }
    private void ileriButonuMetodu() {
        Button ileriTiklandiginda=(Button) findViewById(R.id.ileriButonu);
        final TextView degisenText = (TextView) findViewById(R.id.degisenYazi);
        ileriTiklandiginda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sayi==-1){
                    sayi=ilksoz;
                }
                sayi++;
                if (sayi>=sozlerDizisiString.length){
                    sayi=0;
                    degisenText.setText(sozlerDizisiString[sayi]);
                }
                degisenText.setText(sozlerDizisiString[sayi]);
            }
        });
    }
    private void rastgeleButonuMetodu() {
        final TextView degisenText = (TextView) findViewById(R.id.degisenYazi);
        Button degistirenButon = (Button) findViewById(R.id.rastgeleDegistirenButon);
        degistirenButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int random = (int) (Math.random() * sozlerDizisiString.length);
                if (random == ayniGelmesin) {
                    random = (int) (Math.random() * sozlerDizisiString.length);
                }
                degisenText.setText(sozlerDizisiString[random]);
                ayniGelmesin = random;

            }
        });
    }
}

