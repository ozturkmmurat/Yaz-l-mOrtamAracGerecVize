package tr.edu.medipol.muratozturk.MebisRestServisiOdev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/deneme")
public class OgrenciBilgileriTest {
	// Kişileri Kontrol Testi
	@Test
	public void testSonucuBul() {
		//Given  - Koşullar - Ön Şartlar
	List<String> ogrenciler = new ArrayList<>();
		 {
			 String ogrenci1 ="Murat";
			 String ogrenci2 ="Metehan";
			 String ogrenci3 ="Mücahit";
			 
	   //When 	
		
		ogrenciler.add(ogrenci1);
		ogrenciler.add(ogrenci2);
		ogrenciler.add(ogrenci3);
			
	  //Then - Kontrol	
			assertEquals("Murat",ogrenci1);
			assertEquals("Metehan",ogrenci2);
			assertEquals("Mücahit",ogrenci3);

			
		}
		 
		
		
	}
@GetMapping("/ogrenciEkle/{ogrenciAdi}")
@Test
//OgrenciEkleTesti
//Given
public void   OgrenciEkle() {
	List<String> ogrenciler = new ArrayList<>();
	 {
		 String ogrenci1 ="Murat";
		 String ogrenci2 ="Metehan";
		 String ogrenci3 ="Mücahit";
	 }
	 //When
	 String yeniogrenci="Mehmet";
	 ogrenciler.add(yeniogrenci);
	 //Then
	 assertEquals(yeniogrenci,"Mehmet");
   
}
@GetMapping("/ogrenciSil/{ogrenciAdi}")
@Test	
public void OgrenciSil() {
//OgrenciSil Testi
	//Given
		List<String> ogrenciler = new ArrayList<>();
		 {
			 String ogrenci1 ="Murat";
			 String ogrenci2 ="Metehan";
			 String ogrenci3 ="Mücahit";
			 
		//When	 
			 
			 ogrenciler.remove(ogrenci3);
	    
		//Then	 
			 assertEquals(ogrenci3,"Mücahit");
		 }	
	
	
}
@GetMapping("/ogrenciGuncelle")
@Test
public void OgrenciGuncelle() {
	//OgrenciGuncelletesti
	
	//Given
	List<String> ogrenciler = new ArrayList<>();
	 {
		 String ogrenci1 ="Murat";
		 String ogrenci2 ="Metehan";
		 String ogrenci3 ="Mücahit";
	//When	 
		ogrenci1 = "Hakan";
		 ogrenciler.remove(ogrenci1);
			ogrenciler.add(ogrenci1);
	//Then		
			assertEquals(ogrenci1,"Hakan");
			
	 }
	 
}

@GetMapping("/ogrenciNotEkle")
@Test
public void ogrenciNotEkle() {
	//OgrenciNotEkle testi
	List<String> ogrenciler = new ArrayList<>();
	 {
		 String ogrenci1 ="Murat";
		 String ogrenci2 ="Metehan";
		 String ogrenci3 ="Mücahit";
		 
		 String eklenenNot="50";
		 String guncelNot ="80";		
		 ogrenciler.remove(ogrenci1+" "+eklenenNot);
			ogrenciler.add(ogrenci1+" "+eklenenNot.replace(eklenenNot, guncelNot));
			ogrenciler.remove(ogrenci1+" "+eklenenNot);
		 
			assertEquals(ogrenci1,"Murat");
			assertEquals(eklenenNot,"50");
			assertEquals(guncelNot,"80");
			
	 }
	
}

}



