# MotivationalApp
Frases motivacionales de famosas celebridades.
En esta app obtengo un JSONarraylist desde un servicio REST. Cada elemento es un JSONObject, de donde obtengo una frase y su autor. Lo coloco en un objeto "Quote" para luego agregarlo
a un array de objetos ( List<Quotes>). Esta lista envio como parametro a un Adapter el cual se encargara de crear tantos fragmentos como elementos tenga 
el Array, para luego unirlos a un ViewPager, de manera de mostrar todos las frases en forma de SLIDE.
Utilizo ViewPager, Fragments y AdapterViewPager.
  Adjunto Screenshots sobre app e implementacion.
