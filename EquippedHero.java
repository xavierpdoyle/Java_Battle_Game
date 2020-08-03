
public class EquippedHero extends Hero {
    
    protected Equipment inHand;
    
    
     public  Equipment getEquipment() {
        return inHand;
    }
    
    

    public void setEquipment(Equipment eq) {
       eq =  this.inHand;
    }
    
       public EquippedHero(String name, Equipment eq){
        
        super(name);
        inHand = eq;
    }
   
    
    
    
    
    public void EquippedHero(String name) {
    this.name = name;
    //inHand = "Bare Hands";
  
}
}
  
 

