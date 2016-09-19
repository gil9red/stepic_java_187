package stepic.solutions_12769_step_9;

/**
 * Created by ipetrash on 19.09.2016.
 */
public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    // Переопределите в нем методы equals() и hashCode() так, чтобы equals() сравнивал экземпляры
    // ComplexNumber по содержимому полей re и im, а hashCode() был бы согласованным с реализацией equals().
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof ComplexNumber)) {
            return super.equals(obj);
        }

        ComplexNumber other = (ComplexNumber) obj;

        return Double.compare(this.re, other.getRe()) == 0
                && Double.compare(this.im, other.getIm()) == 0;
    }

    public int hashCode() {
        return Double.hashCode(re + im);
    }
}