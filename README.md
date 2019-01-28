# MotivationalApp
Frases motivacionales de famosas celebridades.
En esta app obtengo un JSONarraylist desde un servicio REST. Cada elemento es un JSONObject, de donde obtengo una frase y su autor. Lo coloco en un objeto "Quote" para luego agregarlo a un array de objetos ( List<Quotes>). Esta lista envio como parametro a un Adapter el cual se encargara de crear tantos fragmentos como elementos tenga el Array, para luego unirlos a un ViewPager, de manera de mostrar todos las frases en forma de SLIDE.
Utilizo ViewPager, Fragments y AdapterViewPager.
  Adjunto Screenshots sobre app e implementacion.
  
![alt text](https://github.com/waltersinger/MotivationalApp/blob/master/ENTORNO%20TRABAJO%20APP.png)

![alt text](https://github.com/waltersinger/MotivationalApp/blob/master/MAIN%20SCREEN.png)

Choosing sharig method:
![alt text](https://github.com/waltersinger/MotivationalApp/blob/master/SHARE%20QUOTE.png)

Sharing:
![alt text](https://github.com/waltersinger/MotivationalApp/blob/master/ADDING%20SHARE.png)
