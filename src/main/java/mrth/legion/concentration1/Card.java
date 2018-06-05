package mrth.legion.concentration1;

public class Card {
    private Integer value;
    private Boolean bitten;

    Card(int value)
    {
        this.value = value;
        this.bitten = false;
    }

    public int getValue()
    {
        return this.value;
    }

    public boolean compare(Card anotherCard)
    {
        boolean answer = this.openCard() == anotherCard.openCard() && !this.bitten;
        if (answer)
        {
            this.bitten = true;
            anotherCard.bitten = true;
        }
        return answer;
    }
    public int openCard()
    {
        return this.value;
    }

}
