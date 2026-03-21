
public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean before(SimpleDate compared) {
        if (this.year < compared.year) {
            return true;
        }

        if (this.year == compared.year && this.month < compared.month) {
            return true;
        }

        if (this.year == compared.year && this.month == compared.month &&
                 this.day < compared.day) {
            return true;
        }

        return false;
    }

    public void advance() {
        if (day != 30) {
            day++;
        } else {
            this.day = 1;
            if (month != 12) {
                month++;
            } else {
                this.month = 1;
                year++;
            }
        }
    }

    public void advance(int howManyDays) {
        if (day != 30) {
            this.day += howManyDays;
        } else {
            this.day = howManyDays;
            if (month != 12) {
                month++;
            } else {
                this.month = 1;
                year++;
            }
        }
    }

    public SimpleDate afterNumberOfDays(int days) {
        SimpleDate newDate = new SimpleDate(day, month, year);
        newDate.advance(days);
        return newDate;
    }

}
