package fr.polytech.dsl.processor.behavioral;


/**
 * Created by Akuni on 24/01/2017.
 */
public enum Type {
    LED("OUTPUT"),
    LCD("OUTPUT"),
    BUZZER("OUTPUT"),
    BUTTON("INPUT");

    public String category;

    Type(String s){
        this.category = s;
    }

    public static Type getTypeByName(String name){
        name = name.toUpperCase();
        for(Type t : Type.values()){
            if(t.name().equals(name)){
                return t;
            }
        }
        return null;
    }

}
