package Ejer2;

public enum Propina {
    PROPINA_2porCiento ((float) 2/100),
    PROPINA_3porCiento ((float) 3/100),
    PROPINA_5porCiento ((float) 5/100);

    private final float montoElegido;

    Propina(float monto){
        this.montoElegido = monto;
    }

    public float getMontoElegido(){
        return montoElegido;
    }
}
