package android.support.v7.app;

/* access modifiers changed from: package-private */
public final class h {
    private static h aad;
    public long aae;
    public long aaf;
    public int state;

    h() {
    }

    static h gS() {
        if (aad == null) {
            aad = new h();
        }
        return aad;
    }

    public final void b(long j2, double d2, double d3) {
        float f2 = ((float) (j2 - 946728000000L)) / 8.64E7f;
        float f3 = 6.24006f + (0.01720197f * f2);
        double sin = ((double) f3) + (0.03341960161924362d * Math.sin((double) f3)) + (3.4906598739326E-4d * Math.sin((double) (2.0f * f3))) + (5.236000106378924E-6d * Math.sin((double) (3.0f * f3))) + 1.796593063d + 3.141592653589793d;
        double d4 = (-d3) / 360.0d;
        double sin2 = (Math.sin((double) f3) * 0.0053d) + d4 + ((double) (((float) Math.round(((double) (f2 - 9.0E-4f)) - d4)) + 9.0E-4f)) + (-0.0069d * Math.sin(2.0d * sin));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d5 = 0.01745329238474369d * d2;
        double sin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(d5) * Math.sin(asin))) / (Math.cos(asin) * Math.cos(d5));
        if (sin3 >= 1.0d) {
            this.state = 1;
            this.aae = -1;
            this.aaf = -1;
        } else if (sin3 <= -1.0d) {
            this.state = 0;
            this.aae = -1;
            this.aaf = -1;
        } else {
            float acos = (float) (Math.acos(sin3) / 6.283185307179586d);
            this.aae = Math.round((((double) acos) + sin2) * 8.64E7d) + 946728000000L;
            this.aaf = Math.round((sin2 - ((double) acos)) * 8.64E7d) + 946728000000L;
            if (this.aaf >= j2 || this.aae <= j2) {
                this.state = 1;
            } else {
                this.state = 0;
            }
        }
    }
}
