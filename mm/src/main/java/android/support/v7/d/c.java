package android.support.v7.d;

public final class c {
    public static final c abK;
    public static final c abL;
    public static final c abM;
    public static final c abN;
    public static final c abO;
    public static final c abP;
    final float[] abQ = new float[3];
    final float[] abR = new float[3];
    final float[] abS = new float[3];
    boolean abT = true;

    static {
        c cVar = new c();
        abK = cVar;
        c(cVar);
        d(abK);
        c cVar2 = new c();
        abL = cVar2;
        b(cVar2);
        d(abL);
        c cVar3 = new c();
        abM = cVar3;
        a(cVar3);
        d(abM);
        c cVar4 = new c();
        abN = cVar4;
        c(cVar4);
        e(abN);
        c cVar5 = new c();
        abO = cVar5;
        b(cVar5);
        e(abO);
        c cVar6 = new c();
        abP = cVar6;
        a(cVar6);
        e(abP);
    }

    c() {
        f(this.abQ);
        f(this.abR);
        this.abS[0] = 0.24f;
        this.abS[1] = 0.52f;
        this.abS[2] = 0.24f;
    }

    private static void f(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    private static void a(c cVar) {
        cVar.abR[1] = 0.26f;
        cVar.abR[2] = 0.45f;
    }

    private static void b(c cVar) {
        cVar.abR[0] = 0.3f;
        cVar.abR[1] = 0.5f;
        cVar.abR[2] = 0.7f;
    }

    private static void c(c cVar) {
        cVar.abR[0] = 0.55f;
        cVar.abR[1] = 0.74f;
    }

    private static void d(c cVar) {
        cVar.abQ[0] = 0.35f;
        cVar.abQ[1] = 1.0f;
    }

    private static void e(c cVar) {
        cVar.abQ[1] = 0.3f;
        cVar.abQ[2] = 0.4f;
    }
}
