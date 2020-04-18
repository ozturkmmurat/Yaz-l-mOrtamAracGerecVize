package tr.edu.medipol.muratozturk.MebisRestServisiOdev;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Anasayfa")
public class OgrenciBilgiSerivisi {
	

	private static List<String> ogrenciler = new ArrayList<>();
	static {
		ogrenciler.add("Murat");
		ogrenciler.add("Metehan");
		ogrenciler.add("Mücahit");

	}
	
	@GetMapping("/tumBilgiler")
	public synchronized List<String> tumBilgilerbu(){
		return ogrenciler;
		
	}
	@GetMapping("/ogrenciEkle/{ogrenciAdi}")
		public synchronized List<String> ogrenciEkle(@PathVariable String ogrenciAdi 
		) {
			ogrenciler.add(ogrenciAdi);
			
			return ogrenciler;
			
	}

	
	@GetMapping("/ogrenciSil/{ogrenciAdi}")
	public synchronized List<String> ogrenciSil(@PathVariable String ogrenciAdi) {
		ogrenciler.remove(ogrenciAdi);
		return ogrenciler;
		
}
	@GetMapping("/ogrenciGuncelle")
	public synchronized List<String> ogrenciGuncelle(@RequestParam String eskiAd, @RequestParam String
			yeniAd) {
		ogrenciler.remove(eskiAd);
		ogrenciler.add(yeniAd);
		return ogrenciler;
		
}
	@GetMapping("/ogrenciNotEkleGuncelle")
	public synchronized List<String> ogrenciNotEkle(@RequestParam String ogrenciAdi, @RequestParam String eklenenNot,@RequestParam String guncelNot) {
		ogrenciler.remove(ogrenciAdi);

		ogrenciler.remove(ogrenciAdi+" "+eklenenNot);
		ogrenciler.add(ogrenciAdi+" "+eklenenNot.replace(eklenenNot, guncelNot));
		ogrenciler.remove(ogrenciAdi+" "+eklenenNot);
		
		
		return ogrenciler;
		
}

}
