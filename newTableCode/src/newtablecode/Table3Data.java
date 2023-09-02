/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newtablecode;

/**
 *
 * @author moayed elamin
 */
public class Table3Data {
    
  int NO;
  String Decription;
  String Unit;
  double Quantity;
  double UnitPrice;
  double Amount;

    public Table3Data(int NO, String Decription, String Unit, double Quantity, double UnitPrice) {
        this.NO = NO;
        this.Decription = Decription;
        this.Unit = Unit;
        this.Quantity = Quantity;
        this.UnitPrice = UnitPrice;
        this.Amount = Quantity * UnitPrice ;
    }

    public int getNO() {
        return NO;
    }

    public void setNO(int NO) {
        this.NO = NO;
    }

    public String getDecription() {
        return Decription;
    }

    public void setDecription(String Decription) {
        this.Decription = Decription;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double Quantity) {
        this.Quantity = Quantity;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Quantity * UnitPrice;
    }
  
    
  
  
  
}
