
package com.mycompany.tarea3;

enum Precios {
    COCACOLA(900),
    SPRITE(900),
    TRENCITO(1200),
    SUPER8(300);

    private int precio;

    private Precios(int precioMod) {
        this.precio = precioMod;
    }

    public int getPrecio() {
        return precio;
    }
    
    @Override
    public String toString(){
        return "Producto " +this.name() +" y su precio es: "+ this.getPrecio();
    }
}
