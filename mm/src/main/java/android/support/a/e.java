package android.support.a;

import android.support.a.b;

public final class e {
    double gm = Math.sqrt(1500.0d);
    double gn = 0.5d;
    double go;
    double gp;
    private double gq;
    private double gr;
    private double gs;
    double gt = Double.MAX_VALUE;
    private final b.a gu = new b.a();
    private boolean mInitialized = false;

    public e() {
    }

    public e(float f2) {
        this.gt = (double) f2;
    }

    public final e g(float f2) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.gm = Math.sqrt((double) f2);
        this.mInitialized = false;
        return this;
    }

    public final e h(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.gn = (double) f2;
        this.mInitialized = false;
        return this;
    }

    private void init() {
        if (!this.mInitialized) {
            if (this.gt == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            if (this.gn > 1.0d) {
                this.gq = ((-this.gn) * this.gm) + (this.gm * Math.sqrt((this.gn * this.gn) - 1.0d));
                this.gr = ((-this.gn) * this.gm) - (this.gm * Math.sqrt((this.gn * this.gn) - 1.0d));
            } else if (this.gn >= 0.0d && this.gn < 1.0d) {
                this.gs = this.gm * Math.sqrt(1.0d - (this.gn * this.gn));
            }
            this.mInitialized = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final b.a a(double d2, double d3, long j2) {
        double pow;
        double cos;
        init();
        double d4 = ((double) j2) / 1000.0d;
        double d5 = d2 - this.gt;
        if (this.gn > 1.0d) {
            double d6 = d5 - (((this.gr * d5) - d3) / (this.gr - this.gq));
            double d7 = ((this.gr * d5) - d3) / (this.gr - this.gq);
            pow = (Math.pow(2.718281828459045d, this.gr * d4) * d6) + (Math.pow(2.718281828459045d, this.gq * d4) * d7);
            cos = (Math.pow(2.718281828459045d, d4 * this.gq) * d7 * this.gq) + (d6 * this.gr * Math.pow(2.718281828459045d, this.gr * d4));
        } else if (this.gn == 1.0d) {
            double d8 = d3 + (this.gm * d5);
            pow = ((d8 * d4) + d5) * Math.pow(2.718281828459045d, (-this.gm) * d4);
            cos = (Math.pow(2.718281828459045d, d4 * (-this.gm)) * d8) + ((d5 + (d8 * d4)) * Math.pow(2.718281828459045d, (-this.gm) * d4) * (-this.gm));
        } else {
            double d9 = ((this.gn * this.gm * d5) + d3) * (1.0d / this.gs);
            pow = Math.pow(2.718281828459045d, (-this.gn) * this.gm * d4) * ((Math.cos(this.gs * d4) * d5) + (Math.sin(this.gs * d4) * d9));
            cos = (((Math.cos(d4 * this.gs) * d9 * this.gs) + (d5 * (-this.gs) * Math.sin(this.gs * d4))) * Math.pow(2.718281828459045d, (-this.gn) * this.gm * d4)) + ((-this.gm) * pow * this.gn);
        }
        this.gu.fZ = (float) (pow + this.gt);
        this.gu.fY = (float) cos;
        return this.gu;
    }
}
