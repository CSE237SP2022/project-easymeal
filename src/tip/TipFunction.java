package tip;

import menu.MenuItem;
import cart.UserCart;

public class TipFunction {

    double total;
    double rate0 = 0.0; //No tip
    double rate10 = 0.1; //10% tip
    double rate15 = 0.15; //15% tip
    double rate20 = 0.20; //20% tip
    double rate25 = 0.25; //25% tip

    //May add custom tipping to the next iteration
    //No tax rate implemented for this menu

public double tipRate0() {
  total = cartPrice.getItemPrice(total);
  total = total + (total*rate0);
  return total;
}

public double tipRate10() {
  total = getItemPrice(total);
  total = total + (total*rate10);
  return total;
}

public double tipRate15() {
  total = getItemPrice(total);
  total = total + (total*rate15);
  return total;
}

public double tipRate20() {
  total = getItemPrice(total);
  total = total + (total*rate20);
  return total;
}

public double tipRate25() {
  total = getItemPrice(total);
  total = total + (total*rate25);
  return total;
}

}
