package base;

import java.math.BigDecimal;

public class TaxCalculator {
    public BigDecimal order;
    public String state;
    public String county;
    public BigDecimal tax;
    public BigDecimal taxValue;
    public BigDecimal total;

    public void setOrder(BigDecimal order) {
        this.order = order;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void decideTax()
    {
        //else ifs and nested ifs to zero in on tax
        if(state.equals("WISCONSIN"))
        {
            tax = BigDecimal.valueOf(.05);
            if(county.equals("EAU CLAIRE"))
                tax = tax.add(BigDecimal.valueOf(.005));

            else if(county.equals("DUNN"))
                tax = tax.add(BigDecimal.valueOf(.004));

        }
        else if(state.equals("ILLINOIS"))
        {
            tax = BigDecimal.valueOf(.08);
        }
        else
        {
            tax = BigDecimal.valueOf(0.0);
        }
    }
    public void calculateTotal()
    {   taxValue = order.multiply(tax);
        total = (order.multiply((tax.add(BigDecimal.valueOf(1.0)))));
    }
}
