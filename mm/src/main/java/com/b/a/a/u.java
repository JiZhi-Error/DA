package com.b.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import com.b.a.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/* access modifiers changed from: package-private */
public final class u extends d implements SensorEventListener {
    private static final int clc;
    private static final int cld;
    private static u clw;
    private int[] clA = new int[6];
    private float[] clB = new float[6];
    private float[] clC = new float[6];
    private float[] clD = {Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
    private float[][] clE = ((float[][]) Array.newInstance(Float.TYPE, 6, 20));
    private final d clF = new d((byte) 0);
    private final f clG = new f(this, (byte) 0);
    private final a clH = new a((byte) 0);
    private Sensor cle;
    private Sensor clf;
    private Sensor clg;
    private Sensor clh;
    private Sensor cli = null;
    private long clj = 0;
    private boolean clk = true;
    private float[][] cll = ((float[][]) Array.newInstance(Float.TYPE, 6, 9));
    private float[][] clm = ((float[][]) Array.newInstance(Float.TYPE, 6, 9));
    private float[][] cln = ((float[][]) Array.newInstance(Float.TYPE, 6, 9));
    private float[][] clo = ((float[][]) Array.newInstance(Float.TYPE, 6, 3));
    private float[][] clp = ((float[][]) Array.newInstance(Float.TYPE, 6, 3));
    private float[][] clq = ((float[][]) Array.newInstance(Float.TYPE, 6, 3));
    private float[][] clr = ((float[][]) Array.newInstance(Float.TYPE, 6, 3));
    private float[] cls = new float[4];
    private float[][] clt = ((float[][]) Array.newInstance(Float.TYPE, 6, 3));
    private float[][] clu = ((float[][]) Array.newInstance(Float.TYPE, 6, 3));
    private float[][] clv = ((float[][]) Array.newInstance(Float.TYPE, 6, 3));
    boolean clx;
    private c cly;
    private boolean[] clz = new boolean[6];
    private SensorManager mSensorManager = null;

    static {
        AppMethodBeat.i(87986);
        int round = Math.round(50000.0f);
        clc = round;
        cld = round;
        AppMethodBeat.o(87986);
    }

    static u Jx() {
        AppMethodBeat.i(87987);
        if (clw == null) {
            clw = new u();
        }
        u uVar = clw;
        AppMethodBeat.o(87987);
        return uVar;
    }

    private u() {
        AppMethodBeat.i(87988);
        AppMethodBeat.o(87988);
    }

    private static void a(float[][] fArr, float[][] fArr2) {
        AppMethodBeat.i(87989);
        for (int i2 = 0; i2 <= 5; i2++) {
            SensorManager.getOrientation(fArr[i2], fArr2[i2]);
        }
        AppMethodBeat.o(87989);
    }

    private static float[] b(float[] fArr, float[] fArr2) {
        return new float[]{(fArr[0] * fArr2[0]) + (fArr[1] * fArr2[3]) + (fArr[2] * fArr2[6]), (fArr[0] * fArr2[1]) + (fArr[1] * fArr2[4]) + (fArr[2] * fArr2[7]), (fArr[0] * fArr2[2]) + (fArr[1] * fArr2[5]) + (fArr[2] * fArr2[8]), (fArr[3] * fArr2[0]) + (fArr[4] * fArr2[3]) + (fArr[5] * fArr2[6]), (fArr[3] * fArr2[1]) + (fArr[4] * fArr2[4]) + (fArr[5] * fArr2[7]), (fArr[3] * fArr2[2]) + (fArr[4] * fArr2[5]) + (fArr[5] * fArr2[8]), (fArr[6] * fArr2[0]) + (fArr[7] * fArr2[3]) + (fArr[8] * fArr2[6]), (fArr[6] * fArr2[1]) + (fArr[7] * fArr2[4]) + (fArr[8] * fArr2[7]), (fArr[6] * fArr2[2]) + (fArr[7] * fArr2[5]) + (fArr[8] * fArr2[8])};
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void au(Context context) {
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void IV() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final synchronized void a(Handler handler, d.a aVar) {
        AppMethodBeat.i(87992);
        super.a(handler, aVar);
        AppMethodBeat.o(87992);
    }

    /* access modifiers changed from: package-private */
    public static class e extends p {
        final float bdN;
        final float cmB;
        final float cmC;
        final int cmD;
        final float x;
        final float y;

        /* synthetic */ e(float f2, float f3, int i2, float f4, float f5, float f6, byte b2) {
            this(f2, f3, i2, f4, f5, f6);
        }

        private e(float f2, float f3, int i2, float f4, float f5, float f6) {
            super(301);
            this.x = f2;
            this.y = f3;
            this.cmD = i2;
            this.cmB = f4;
            this.cmC = f5;
            this.bdN = f6;
        }
    }

    @TargetApi(19)
    private static boolean a(SensorManager sensorManager, SensorEventListener sensorEventListener, int i2, int i3, Handler handler, Sensor... sensorArr) {
        AppMethodBeat.i(87993);
        try {
            boolean z = Build.VERSION.SDK_INT >= 19;
            for (Sensor sensor : sensorArr) {
                if (!(z ? sensorManager.registerListener(sensorEventListener, sensor, i2, i3, handler) : sensorManager.registerListener(sensorEventListener, sensor, i2, handler))) {
                    sensorManager.unregisterListener(sensorEventListener);
                    AppMethodBeat.o(87993);
                    return false;
                }
            }
            AppMethodBeat.o(87993);
            return true;
        } catch (Error e2) {
            AppMethodBeat.o(87993);
            return false;
        } catch (Exception e3) {
            AppMethodBeat.o(87993);
            return false;
        }
    }

    class c extends e {
        c(Handler handler) {
            super(handler);
        }

        /* access modifiers changed from: package-private */
        @Override // com.b.a.a.e
        public final void IZ() {
            AppMethodBeat.i(87975);
            u.a(u.this);
            AppMethodBeat.o(87975);
        }
    }

    private static void a(float[] fArr, float[][] fArr2) {
        AppMethodBeat.i(87994);
        fArr2[0][0] = -fArr[1];
        fArr2[0][1] = fArr[0];
        fArr2[0][2] = fArr[2];
        fArr2[1][0] = fArr[1];
        fArr2[1][1] = -fArr[0];
        fArr2[1][2] = fArr[2];
        System.arraycopy(fArr, 0, fArr2[2], 0, 3);
        fArr2[3][0] = -fArr[0];
        fArr2[3][1] = -fArr[1];
        fArr2[3][2] = fArr[2];
        fArr2[4][0] = fArr[0];
        fArr2[4][1] = fArr[2];
        fArr2[4][2] = -fArr[1];
        fArr2[5][0] = fArr[0];
        fArr2[5][1] = -fArr[2];
        fArr2[5][2] = fArr[1];
        AppMethodBeat.o(87994);
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[][] fArr;
        int i2 = 0;
        AppMethodBeat.i(87995);
        switch (sensorEvent.sensor.getType()) {
            case 2:
                a(sensorEvent.values, this.clu);
                a aVar = this.clH;
                float[] fArr2 = sensorEvent.values;
                if (fArr2.length >= 3) {
                    aVar.clI++;
                    aVar.clJ = (float) (Math.sqrt((double) ((fArr2[0] * fArr2[0]) + (fArr2[1] * fArr2[1]) + (fArr2[2] * fArr2[2]))) + ((double) aVar.clJ));
                    break;
                }
                break;
            case 4:
                if (!(this.clo[2][0] == 0.0f && this.clo[2][1] == 0.0f && this.clo[2][2] == 0.0f)) {
                    if (this.clk) {
                        for (int i3 = 0; i3 <= 5; i3++) {
                            float[] fArr3 = this.cll[i3];
                            float[][] fArr4 = this.clm;
                            fArr4[i3] = b(fArr4[i3], fArr3);
                        }
                        this.clk = false;
                    }
                    float[][] fArr5 = (float[][]) Array.newInstance(Float.TYPE, 6, 4);
                    if (this.clj != 0) {
                        float f2 = 1.0E-9f * ((float) (sensorEvent.timestamp - this.clj));
                        a(sensorEvent.values, this.clt);
                        for (int i4 = 0; i4 <= 5; i4++) {
                            float[] fArr6 = this.clt[i4];
                            float[] fArr7 = fArr5[i4];
                            float f3 = f2 / 2.0f;
                            float[] fArr8 = new float[3];
                            float sqrt = (float) Math.sqrt((double) ((fArr6[0] * fArr6[0]) + (fArr6[1] * fArr6[1]) + (fArr6[2] * fArr6[2])));
                            if (sqrt > 1.0E-9f) {
                                fArr8[0] = fArr6[0] / sqrt;
                                fArr8[1] = fArr6[1] / sqrt;
                                fArr8[2] = fArr6[2] / sqrt;
                            }
                            float f4 = sqrt * f3;
                            float sin = (float) Math.sin((double) f4);
                            fArr7[0] = fArr8[0] * sin;
                            fArr7[1] = fArr8[1] * sin;
                            fArr7[2] = sin * fArr8[2];
                            fArr7[3] = (float) Math.cos((double) f4);
                        }
                    }
                    this.clj = sensorEvent.timestamp;
                    while (i2 <= 5) {
                        float[] fArr9 = new float[9];
                        try {
                            SensorManager.getRotationMatrixFromVector(fArr9, fArr5[i2]);
                        } catch (Exception e2) {
                        }
                        float[][] fArr10 = this.clm;
                        fArr10[i2] = b(fArr10[i2], fArr9);
                        i2++;
                    }
                    a(this.clm, this.clp);
                }
                AppMethodBeat.o(87995);
                return;
            case 9:
                a(sensorEvent.values, this.clv);
                if (!(this.clu[2][0] == 0.0f && this.clu[2][1] == 0.0f && this.clu[2][2] == 0.0f)) {
                    float[][] fArr11 = this.cll;
                    float[][] fArr12 = this.clv;
                    float[][] fArr13 = this.clu;
                    if (SensorManager.getRotationMatrix(fArr11[0], null, fArr12[0], fArr13[0]) && SensorManager.getRotationMatrix(fArr11[1], null, fArr12[1], fArr13[1]) && SensorManager.getRotationMatrix(fArr11[2], null, fArr12[2], fArr13[2]) && SensorManager.getRotationMatrix(fArr11[3], null, fArr12[3], fArr13[3]) && SensorManager.getRotationMatrix(fArr11[4], null, fArr12[4], fArr13[4]) && SensorManager.getRotationMatrix(fArr11[5], null, fArr12[5], fArr13[5])) {
                        a(this.cll, this.clo);
                        if (this.clp[2][0] == 0.0f && this.clp[2][1] == 0.0f && this.clp[2][2] == 0.0f) {
                            float[][] fArr14 = this.clo;
                            float[][] fArr15 = this.clp;
                            for (int i5 = 0; i5 <= 5; i5++) {
                                System.arraycopy(fArr14[i5], 0, fArr15[i5], 0, 3);
                            }
                        }
                    }
                    AppMethodBeat.o(87995);
                    return;
                }
                break;
            case 10:
                float[] fArr16 = new float[16];
                if (this.cli != null) {
                    fArr = this.cln;
                } else {
                    fArr = this.clm;
                }
                float[] fArr17 = fArr[2];
                float[] fArr18 = new float[16];
                if (fArr17.length == 9) {
                    fArr18[0] = fArr17[0];
                    fArr18[1] = fArr17[1];
                    fArr18[2] = fArr17[2];
                    fArr18[3] = 0.0f;
                    fArr18[4] = fArr17[3];
                    fArr18[5] = fArr17[4];
                    fArr18[6] = fArr17[5];
                    fArr18[7] = 0.0f;
                    fArr18[8] = fArr17[6];
                    fArr18[9] = fArr17[7];
                    fArr18[10] = fArr17[8];
                    fArr18[11] = 0.0f;
                    fArr18[12] = 0.0f;
                    fArr18[13] = 0.0f;
                    fArr18[14] = 0.0f;
                    fArr18[15] = 1.0f;
                }
                Matrix.invertM(fArr16, 0, fArr18, 0);
                Matrix.multiplyMV(this.cls, 0, fArr16, 0, new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2], 0.0f}, 0);
                this.clF.a(this.cls, sensorEvent.values, this.clv[2]);
                AppMethodBeat.o(87995);
                return;
            case 11:
                try {
                    SensorManager.getRotationMatrixFromVector(this.cln[2], sensorEvent.values);
                } catch (IllegalArgumentException e3) {
                    if (sensorEvent.values.length > 3) {
                        SensorManager.getRotationMatrixFromVector(this.cln[2], new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]});
                    }
                }
                SensorManager.remapCoordinateSystem(this.cln[2], 2, 129, this.cln[0]);
                SensorManager.remapCoordinateSystem(this.cln[2], 130, 1, this.cln[1]);
                SensorManager.remapCoordinateSystem(this.cln[2], 129, 130, this.cln[3]);
                SensorManager.remapCoordinateSystem(this.cln[2], 129, 3, this.cln[4]);
                SensorManager.remapCoordinateSystem(this.cln[2], 1, 3, this.cln[5]);
                while (i2 <= 5) {
                    SensorManager.getOrientation(this.cln[i2], this.clr[i2]);
                    i2++;
                }
                AppMethodBeat.o(87995);
                return;
        }
        AppMethodBeat.o(87995);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        float cmb;
        float cmc;
        float cmd;
        float cme;
        float cmf;
        float cmg;
        float cmh;
        float cmi;
        float cmj;
        float cmk;
        float cml;
        float[] cmm;
        float[] cmn;
        float[] cmo;
        float[] cmp;
        float[] cmq;
        long time;

        private b() {
            AppMethodBeat.i(87974);
            this.cmm = new float[6];
            this.cmn = new float[6];
            this.cmo = new float[6];
            this.cmp = new float[6];
            this.cmq = new float[6];
            AppMethodBeat.o(87974);
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static class d {
        private float cmA;
        private float cms;
        private float cmt;
        private float cmu;
        private float cmv;
        private float cmw;
        private float cmx;
        private float cmy;
        private float cmz;
        private int count;

        private d() {
            this.count = 0;
            this.cms = 0.0f;
            this.cmt = 0.0f;
            this.cmu = 0.0f;
            this.cmv = 0.0f;
            this.cmw = 0.0f;
            this.cmx = 0.0f;
            this.cmy = 0.0f;
            this.cmz = 0.0f;
            this.cmA = 0.0f;
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final synchronized void reset() {
            this.count = 0;
            this.cms = 0.0f;
            this.cmt = 0.0f;
            this.cmu = 0.0f;
            this.cmv = 0.0f;
            this.cmw = 0.0f;
            this.cmx = 0.0f;
            this.cmy = 0.0f;
            this.cmz = 0.0f;
            this.cmA = 0.0f;
        }

        /* access modifiers changed from: package-private */
        public final synchronized void a(float[] fArr, float[] fArr2, float[] fArr3) {
            if (fArr.length >= 3) {
                this.count++;
                this.cms += fArr[0];
                this.cmt += fArr[1];
                this.cmu += fArr[2];
                this.cmv += fArr2[0];
                this.cmw += fArr2[1];
                this.cmx += fArr2[2];
                this.cmy += fArr3[0];
                this.cmz += fArr3[1];
                this.cmA += fArr3[2];
            }
        }

        /* access modifiers changed from: package-private */
        public final synchronized b a(float[][] fArr) {
            b bVar;
            synchronized (this) {
                AppMethodBeat.i(87976);
                if (this.count <= 0 || fArr.length < 3) {
                    bVar = null;
                    AppMethodBeat.o(87976);
                } else {
                    bVar = new b((byte) 0);
                    bVar.time = SystemClock.elapsedRealtime();
                    for (int i2 = 0; i2 <= 5; i2++) {
                        bVar.cmm[i2] = fArr[i2][0];
                        bVar.cmn[i2] = fArr[i2][1];
                        bVar.cmo[i2] = fArr[i2][2];
                        bVar.cmp[i2] = (float) Math.sin((double) bVar.cmm[i2]);
                        bVar.cmq[i2] = (float) Math.cos((double) bVar.cmm[i2]);
                    }
                    bVar.cmb = this.cms / ((float) this.count);
                    bVar.cmc = this.cmt / ((float) this.count);
                    bVar.cmd = this.cmu / ((float) this.count);
                    bVar.cme = this.cmv / ((float) this.count);
                    bVar.cmf = this.cmw / ((float) this.count);
                    bVar.cmg = this.cmx / ((float) this.count);
                    bVar.cmh = this.cmy / ((float) this.count);
                    bVar.cmi = this.cmz / ((float) this.count);
                    bVar.cmj = this.cmA / ((float) this.count);
                    bVar.cml = (float) Math.sqrt((double) ((bVar.cmb * bVar.cmb) + (bVar.cmc * bVar.cmc)));
                    reset();
                    AppMethodBeat.o(87976);
                }
            }
            return bVar;
        }
    }

    /* access modifiers changed from: package-private */
    public class f {
        private ArrayList<b> cmE;
        private a[] cmF;
        private int cmG;
        private float[][] cmH;
        private float[][] cmI;
        private float[][] cmJ;
        private int[] cmK;
        private int cmL;
        private int cmM;
        private int cmN;

        private f() {
            AppMethodBeat.i(87979);
            this.cmE = new ArrayList<>();
            this.cmF = new a[5];
            this.cmG = 0;
            this.cmH = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.cmI = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.cmJ = (float[][]) Array.newInstance(Float.TYPE, 3, 3);
            this.cmK = new int[6];
            this.cmL = 5;
            this.cmM = -1;
            this.cmN = 0;
            AppMethodBeat.o(87979);
        }

        /* synthetic */ f(u uVar, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final synchronized void reset() {
            AppMethodBeat.i(87980);
            this.cmE.clear();
            this.cmF = new a[5];
            this.cmG = 0;
            this.cmH = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.cmI = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.cmJ = (float[][]) Array.newInstance(Float.TYPE, 3, 3);
            this.cmK = new int[6];
            this.cmL = 5;
            AppMethodBeat.o(87980);
        }

        private synchronized boolean Jy() {
            boolean z;
            AppMethodBeat.i(87981);
            if (this.cmG >= 20) {
                float[] fArr = this.cmH[0];
                fArr[2] = fArr[2] / 20.0f;
                float[] fArr2 = this.cmH[1];
                fArr2[2] = fArr2[2] / 20.0f;
                float[] fArr3 = this.cmH[2];
                fArr3[2] = fArr3[2] / 20.0f;
                float[] fArr4 = this.cmI[0];
                fArr4[2] = fArr4[2] / 20.0f;
                float[] fArr5 = this.cmI[1];
                fArr5[2] = fArr5[2] / 20.0f;
                float[] fArr6 = this.cmI[2];
                fArr6[2] = fArr6[2] / 20.0f;
                float f2 = this.cmI[0][2];
                float f3 = this.cmH[0][0] - this.cmH[0][2];
                float f4 = this.cmH[0][2] - this.cmH[0][1];
                float f5 = this.cmI[1][2];
                float f6 = this.cmH[1][0] - this.cmH[1][2];
                float f7 = this.cmH[1][2] - this.cmH[1][1];
                float f8 = this.cmI[2][2];
                float f9 = this.cmH[2][0] - this.cmH[2][2];
                float f10 = this.cmH[2][2] - this.cmH[2][1];
                this.cmJ[0][0] = (f2 * 0.32999998f) + (0.67f * this.cmJ[0][0]);
                this.cmJ[0][1] = (f3 * 0.32999998f) + (0.67f * this.cmJ[0][1]);
                this.cmJ[0][2] = (f4 * 0.32999998f) + (0.67f * this.cmJ[0][2]);
                this.cmJ[1][0] = (0.67f * this.cmJ[1][0]) + (f5 * 0.32999998f);
                this.cmJ[1][1] = (0.67f * this.cmJ[1][1]) + (0.32999998f * f6);
                this.cmJ[1][2] = (0.67f * this.cmJ[1][2]) + (0.32999998f * f7);
                this.cmJ[2][0] = (0.67f * this.cmJ[2][0]) + (0.32999998f * f8);
                this.cmJ[2][1] = (0.67f * this.cmJ[2][1]) + (0.32999998f * f9);
                this.cmJ[2][2] = (0.67f * this.cmJ[2][2]) + (0.32999998f * f10);
                a(Jz());
                this.cmG = 0;
                this.cmH = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
                this.cmI = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
                if (this.cmE.size() >= 100) {
                    this.cmE.subList(0, 20).clear();
                    this.cmE.trimToSize();
                }
                z = true;
                AppMethodBeat.o(87981);
            } else {
                z = false;
                AppMethodBeat.o(87981);
            }
            return z;
        }

        private synchronized a Jz() {
            int i2;
            boolean z;
            a aVar;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float sqrt;
            AppMethodBeat.i(87982);
            boolean z2 = this.cmN == 0;
            if (z2) {
                this.cmL = ((double) Math.abs(this.cmJ[2][0])) < 9.3d ? 5 : 2;
                this.cmK = new int[6];
                z = false;
            } else {
                boolean z3 = Math.abs(this.cmJ[0][0]) >= 7.0f && (this.cmJ[1][1] >= 2.3f || this.cmJ[1][2] >= 2.3f);
                if (z3) {
                    this.cmL = 2;
                    this.cmK = new int[6];
                    z = z3;
                } else {
                    float abs = Math.abs(this.cmJ[0][0]);
                    float abs2 = Math.abs(this.cmJ[1][0]);
                    float abs3 = Math.abs(this.cmJ[2][0]);
                    if (abs > abs2) {
                        if (abs > abs3) {
                            i2 = 0;
                        } else {
                            i2 = 2;
                        }
                    } else if (abs2 > abs3) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    float f8 = 0.0f;
                    int i3 = 0;
                    int i4 = 0;
                    for (int i5 = 0; i5 < 3; i5++) {
                        if (i5 != i2) {
                            for (int i6 = 1; i6 < 3; i6++) {
                                if (this.cmJ[i5][i6] > f8) {
                                    f8 = this.cmJ[i5][i6];
                                    i4 = i6;
                                    i3 = i5;
                                }
                            }
                        }
                    }
                    int i7 = ((i3 * 2) + i4) - 1;
                    int[] iArr = this.cmK;
                    iArr[i7] = iArr[i7] + 1;
                    for (int i8 = 0; i8 <= 5; i8++) {
                        if (i8 != this.cmL && this.cmK[i8] > this.cmK[this.cmL]) {
                            this.cmL = i8;
                        }
                    }
                    z = z3;
                }
            }
            if (this.cmM >= 0 && this.cmM <= 5) {
                this.cmL = this.cmM;
            }
            aVar = new a(this, (byte) 0);
            a aVar2 = new a(this, (byte) 0);
            if (this.cmF[0] != null) {
                aVar.cmS = this.cmF[0].cmS;
                aVar.cmP = this.cmF[0].cmP;
            }
            if (this.cmF[4] != null) {
                aVar2.cmS = this.cmF[4].cmS;
                aVar2.cmP = this.cmF[4].cmP;
            }
            if (!this.cmE.isEmpty()) {
                int size = this.cmE.size();
                float[] fArr = new float[6];
                float[] fArr2 = new float[6];
                Iterator<b> it = this.cmE.iterator();
                float f9 = 0.0f;
                float f10 = 0.0f;
                while (it.hasNext()) {
                    b next = it.next();
                    if (!z) {
                        f7 = next.cmd;
                    } else {
                        f7 = next.cmg;
                    }
                    f10 += f7;
                    if (!z) {
                        sqrt = next.cml;
                    } else {
                        sqrt = (float) Math.sqrt((double) ((next.cme * next.cme) + (next.cmf * next.cmf) + (next.cmg * next.cmg)));
                        next.cmk = sqrt;
                    }
                    f9 += sqrt;
                    for (int i9 = 0; i9 <= 5; i9++) {
                        fArr[i9] = fArr[i9] + next.cmp[i9];
                        fArr2[i9] = fArr2[i9] + next.cmq[i9];
                    }
                }
                float f11 = f10 / ((float) size);
                float f12 = f9 / ((float) size);
                float f13 = !z ? f11 : f12;
                float[] fArr3 = {(float) Math.atan2((double) fArr[0], (double) fArr2[0]), (float) Math.atan2((double) fArr[1], (double) fArr2[1]), (float) Math.atan2((double) fArr[2], (double) fArr2[2]), (float) Math.atan2((double) fArr[3], (double) fArr2[3]), (float) Math.atan2((double) fArr[4], (double) fArr2[4]), (float) Math.atan2((double) fArr[5], (double) fArr2[5])};
                float f14 = !z ? f11 : f12;
                float f15 = 0.0f;
                float f16 = !z ? 1.2f : 1.0f;
                float f17 = z2 ? 0.08726647f : 0.2617994f;
                Iterator<b> it2 = this.cmE.iterator();
                float f18 = f12;
                float f19 = 0.0f;
                float f20 = 0.0f;
                int i10 = 0;
                while (it2.hasNext()) {
                    b next2 = it2.next();
                    if (!z) {
                        f3 = next2.cmd;
                    } else {
                        f3 = next2.cmk;
                    }
                    if (!z) {
                        f4 = next2.cml;
                    } else {
                        f4 = next2.cmk;
                    }
                    float f21 = !z ? f11 : f12;
                    if (i10 > 0) {
                        if (f14 < f3) {
                            if (!z2) {
                                float f22 = f3 - f21;
                                if (f22 > 2.0f * f16) {
                                    f5 = f22 / 2.0f;
                                    f14 = f3;
                                }
                            }
                            f5 = f16;
                            f14 = f3;
                        } else {
                            f5 = f16;
                        }
                        if (f18 < f4) {
                            f6 = f4;
                        } else {
                            f6 = f18;
                        }
                        if (f3 > f21) {
                            f16 = f5;
                            f18 = f6;
                            i10++;
                        } else {
                            if (i10 <= 10) {
                                boolean z4 = true;
                                if (aVar.cmS != 0 && next2.time - aVar.cmS < 250) {
                                    z4 = false;
                                }
                                if (z4 && f6 - f12 < 0.3f) {
                                    z4 = false;
                                }
                                if (z4) {
                                    aVar.cmO++;
                                    f15 += f14;
                                    float atan2 = (float) Math.atan2((double) (next2.cmp[this.cmL] + f20), (double) (next2.cmq[this.cmL] + f19));
                                    float abs4 = Math.abs(atan2 - fArr3[this.cmL]);
                                    if (abs4 > 3.1415927f) {
                                        abs4 = 6.2831855f - abs4;
                                    }
                                    boolean z5 = abs4 >= f17;
                                    float f23 = 1.0f;
                                    if (z5) {
                                        f23 = 0.93f;
                                    } else {
                                        atan2 = fArr3[this.cmL];
                                    }
                                    float sin = (float) (Math.sin((double) atan2) * ((double) f23));
                                    float cos = (float) (((double) f23) * Math.cos((double) atan2));
                                    aVar.x += sin;
                                    aVar.y += cos;
                                    if (next2.time - aVar2.cmS > 250) {
                                        aVar2.x -= sin;
                                        aVar2.y -= cos;
                                        aVar2.cmO++;
                                    }
                                }
                                aVar.cmS = next2.time;
                            }
                            float f24 = next2.cmp[this.cmL];
                            f16 = f5;
                            f18 = f6;
                            f19 = next2.cmq[this.cmL];
                            f20 = f24;
                            i10 = 0;
                        }
                    } else if (f3 <= f21) {
                        float f25 = next2.cmp[this.cmL];
                        f19 = next2.cmq[this.cmL];
                        f20 = f25;
                    } else if (f3 - f21 >= f16) {
                        f18 = f4;
                        f14 = f3;
                        i10 = 1;
                    }
                }
                if (aVar.cmO > 0) {
                    if (!z) {
                        f2 = 0.0f;
                    } else {
                        f2 = 0.08f;
                    }
                    float f26 = f15 / ((float) aVar.cmO);
                    float f27 = aVar.cmP;
                    float f28 = f2 + ((f26 - f13) / 15.0f) + 0.537f;
                    if (f27 != 0.0f) {
                        f28 = (f28 * 0.67f) + (0.33f * f27);
                    }
                    aVar.cmP = f28;
                    aVar.x *= aVar.cmP;
                    aVar.y *= aVar.cmP;
                    aVar.cmQ = ((float) aVar.cmO) * aVar.cmP;
                }
            }
            aVar.cmR = aVar.cmQ / ((float) (this.cmE.size() / 20));
            if (this.cmF[0] != null) {
                aVar.x += this.cmF[0].x;
                aVar.y += this.cmF[0].y;
                aVar.z += this.cmF[0].z;
                aVar.cmO += this.cmF[0].cmO;
                aVar.cmQ += this.cmF[0].cmQ;
            }
            if (this.cmF[4] != null && aVar2.cmO > 0) {
                this.cmF[4].x = ((this.cmF[4].x + aVar.x) + (aVar2.x * aVar.cmP)) / 2.0f;
                this.cmF[4].y = ((this.cmF[4].y + aVar.y) + (aVar2.y * aVar.cmP)) / 2.0f;
            }
            AppMethodBeat.o(87982);
            return aVar;
        }

        private synchronized void a(a aVar) {
            AppMethodBeat.i(87983);
            System.arraycopy(this.cmF, 1, this.cmF, 0, 4);
            if (this.cmF[4] == null || SystemClock.elapsedRealtime() - aVar.cmS <= 1000) {
                this.cmF[4] = aVar;
                AppMethodBeat.o(87983);
            } else {
                a aVar2 = this.cmF[4];
                aVar2.x = (aVar2.x + aVar.x) / 2.0f;
                aVar2.y = (aVar2.y + aVar.y) / 2.0f;
                aVar2.z = (aVar2.z + aVar.z) / 2.0f;
                aVar2.cmO = Math.round(((float) (aVar2.cmO + aVar.cmO)) / 2.0f);
                aVar2.cmP = (aVar2.cmP + aVar.cmP) / 2.0f;
                aVar2.cmQ = (aVar2.cmQ + aVar.cmQ) / 2.0f;
                aVar2.cmS = aVar.cmS;
                aVar2.cmR = aVar.cmR;
                AppMethodBeat.o(87983);
            }
        }

        /* access modifiers changed from: package-private */
        public final synchronized void a(b bVar) {
            AppMethodBeat.i(87984);
            if (this.cmN > 0 && this.cmN < 101) {
                this.cmN--;
            }
            this.cmE.add(bVar);
            this.cmG++;
            if (bVar.cme > this.cmH[0][0]) {
                this.cmH[0][0] = bVar.cme;
            }
            if (bVar.cme < this.cmH[0][1]) {
                this.cmH[0][1] = bVar.cme;
            }
            float[] fArr = this.cmH[0];
            fArr[2] = fArr[2] + bVar.cme;
            if (bVar.cmf > this.cmH[1][0]) {
                this.cmH[1][0] = bVar.cmf;
            }
            if (bVar.cmf < this.cmH[1][1]) {
                this.cmH[1][1] = bVar.cmf;
            }
            float[] fArr2 = this.cmH[1];
            fArr2[2] = fArr2[2] + bVar.cmf;
            if (bVar.cmg > this.cmH[2][0]) {
                this.cmH[2][0] = bVar.cmg;
            }
            if (bVar.cmg < this.cmH[2][1]) {
                this.cmH[2][1] = bVar.cmg;
            }
            float[] fArr3 = this.cmH[2];
            fArr3[2] = fArr3[2] + bVar.cmg;
            if (bVar.cmh > this.cmI[0][0]) {
                this.cmI[0][0] = bVar.cmh;
            }
            if (bVar.cmh < this.cmI[0][1]) {
                this.cmI[0][1] = bVar.cmh;
            }
            float[] fArr4 = this.cmI[0];
            fArr4[2] = fArr4[2] + bVar.cmh;
            if (bVar.cmi > this.cmI[1][0]) {
                this.cmI[1][0] = bVar.cmi;
            }
            if (bVar.cmi < this.cmI[1][1]) {
                this.cmI[1][1] = bVar.cmi;
            }
            float[] fArr5 = this.cmI[1];
            fArr5[2] = fArr5[2] + bVar.cmi;
            if (bVar.cmj > this.cmI[2][0]) {
                this.cmI[2][0] = bVar.cmj;
            }
            if (bVar.cmj < this.cmI[2][1]) {
                this.cmI[2][1] = bVar.cmj;
            }
            float[] fArr6 = this.cmI[2];
            fArr6[2] = fArr6[2] + bVar.cmj;
            if (Jy()) {
                u.b(u.this);
            }
            AppMethodBeat.o(87984);
        }

        /* access modifiers changed from: package-private */
        public final synchronized a JA() {
            a aVar;
            AppMethodBeat.i(87985);
            if (this.cmF[4] != null) {
                aVar = this.cmF[4].JB();
                AppMethodBeat.o(87985);
            } else {
                aVar = null;
                AppMethodBeat.o(87985);
            }
            return aVar;
        }

        /* access modifiers changed from: package-private */
        public class a {
            int cmO;
            float cmP;
            float cmQ;
            float cmR;
            long cmS;
            float x;
            float y;
            float z;

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(87978);
                a JB = JB();
                AppMethodBeat.o(87978);
                return JB;
            }

            private a() {
                this.x = 0.0f;
                this.y = 0.0f;
                this.z = 0.0f;
                this.cmO = 0;
                this.cmP = 0.0f;
                this.cmQ = 0.0f;
                this.cmR = 0.0f;
                this.cmS = 0;
            }

            /* synthetic */ a(f fVar, byte b2) {
                this();
            }

            /* access modifiers changed from: protected */
            public final a JB() {
                AppMethodBeat.i(87977);
                a aVar = new a();
                aVar.x = this.x;
                aVar.y = this.y;
                aVar.z = this.z;
                aVar.cmO = this.cmO;
                aVar.cmP = this.cmP;
                aVar.cmQ = this.cmQ;
                aVar.cmS = this.cmS;
                aVar.cmR = this.cmR;
                AppMethodBeat.o(87977);
                return aVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        int clI;
        float clJ;
        long clK;
        float clL;
        boolean clM;
        long clN;
        float[] clO;
        float[] clP;
        float[] clQ;
        float[] clR;
        float[] clS;
        float[] clT;
        float[] clU;
        float[] clV;
        float[] clW;
        float clX;
        float clY;
        float clZ;
        boolean cma;

        private a() {
            AppMethodBeat.i(87973);
            this.clI = 0;
            this.clJ = 0.0f;
            this.clK = 0;
            this.clL = 0.0f;
            this.clM = false;
            this.clN = 0;
            this.clO = new float[6];
            this.clP = new float[6];
            this.clQ = new float[6];
            this.clR = new float[6];
            this.clS = new float[6];
            this.clT = new float[6];
            this.clU = new float[6];
            this.clV = new float[6];
            this.clW = new float[6];
            this.clX = 0.0f;
            this.clY = Float.NEGATIVE_INFINITY;
            this.clZ = Float.POSITIVE_INFINITY;
            this.cma = false;
            AppMethodBeat.o(87973);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void reset() {
            this.clI = 0;
            this.clJ = 0.0f;
            this.clK = 0;
            this.clL = 0.0f;
            this.clM = false;
            this.clN = 0;
            this.clO = new float[6];
            this.clP = new float[6];
            this.clQ = new float[6];
            this.clX = 0.0f;
            this.clY = Float.NEGATIVE_INFINITY;
            this.clZ = Float.POSITIVE_INFINITY;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0078  */
    @Override // com.b.a.a.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r9, android.os.Handler r10, com.b.a.a.d.a r11) {
        /*
        // Method dump skipped, instructions count: 298
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.u.a(android.content.Context, android.os.Handler, com.b.a.a.d$a):void");
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void av(Context context) {
        AppMethodBeat.i(87991);
        if (this.cly != null) {
            this.cly.stop();
        }
        if (this.mSensorManager != null) {
            try {
                this.mSensorManager.unregisterListener(this);
            } catch (Error | Exception e2) {
            }
        }
        this.mSensorManager = null;
        this.cli = null;
        this.clh = null;
        this.clg = null;
        this.clf = null;
        this.cle = null;
        this.clj = 0;
        this.clk = true;
        this.cll = (float[][]) Array.newInstance(Float.TYPE, 6, 9);
        this.clm = (float[][]) Array.newInstance(Float.TYPE, 6, 9);
        this.clo = (float[][]) Array.newInstance(Float.TYPE, 6, 3);
        this.clp = (float[][]) Array.newInstance(Float.TYPE, 6, 3);
        this.clq = (float[][]) Array.newInstance(Float.TYPE, 6, 3);
        this.clz = new boolean[6];
        this.clA = new int[6];
        this.clB = new float[6];
        this.clC = new float[6];
        this.clD = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
        this.clE = (float[][]) Array.newInstance(Float.TYPE, 6, 20);
        this.clH.reset();
        this.clF.reset();
        this.clG.reset();
        AppMethodBeat.o(87991);
    }

    static /* synthetic */ void a(u uVar) {
        float[][] fArr;
        boolean z;
        AppMethodBeat.i(87996);
        if (!(uVar.cle == null || uVar.clf == null || uVar.clg == null || uVar.clh == null)) {
            for (int i2 = 0; i2 <= 5; i2++) {
                boolean z2 = false;
                if (Float.isNaN(uVar.clD[i2])) {
                    uVar.clD[i2] = uVar.clp[i2][0];
                } else {
                    float f2 = uVar.clp[i2][0] - uVar.clq[i2][0];
                    if (f2 < -3.1415927f) {
                        f2 += 6.2831855f;
                    } else if (f2 > 3.1415927f) {
                        f2 -= 6.2831855f;
                    }
                    float[] fArr2 = uVar.clE[i2];
                    int[] iArr = uVar.clA;
                    int i3 = iArr[i2];
                    iArr[i2] = i3 + 1;
                    fArr2[i3] = f2;
                    if (uVar.clA[i2] == 20) {
                        uVar.clA[i2] = 0;
                        if (!uVar.clz[i2]) {
                            uVar.clz[i2] = true;
                        }
                    }
                    float[] fArr3 = uVar.clC;
                    fArr3[i2] = fArr3[i2] + f2;
                    float[] fArr4 = uVar.clB;
                    fArr4[i2] = f2 + fArr4[i2];
                    if (uVar.clz[i2]) {
                        if (Math.abs(uVar.clB[i2]) < 0.08726647f) {
                            if (Math.abs(uVar.clC[i2]) < 0.08726647f) {
                                float f3 = uVar.clp[i2][0] - uVar.clD[i2];
                                if (f3 < -3.1415927f) {
                                    f3 += 6.2831855f;
                                } else if (f3 > 3.1415927f) {
                                    f3 -= 6.2831855f;
                                }
                                uVar.clp[i2][0] = (f3 / 2.0f) + uVar.clD[i2];
                                if (uVar.clp[i2][0] < -3.1415927f) {
                                    uVar.clp[i2][0] = 6.2831855f + uVar.clp[i2][0];
                                } else if (uVar.clp[i2][0] > 3.1415927f) {
                                    uVar.clp[i2][0] = uVar.clp[i2][0] - 6.2831855f;
                                }
                                uVar.clD[i2] = uVar.clp[i2][0];
                                z = true;
                                float[] fArr5 = uVar.clB;
                                fArr5[i2] = fArr5[i2] - uVar.clE[i2][uVar.clA[i2]];
                                z2 = z;
                            } else {
                                float f4 = uVar.clC[i2] % 1.5707964f;
                                float abs = Math.abs(f4);
                                if (abs < 0.08726647f) {
                                    float[] fArr6 = uVar.clC;
                                    fArr6[i2] = fArr6[i2] - f4;
                                    float[] fArr7 = uVar.clD;
                                    fArr7[i2] = (fArr7[i2] + uVar.clC[i2]) % 6.2831855f;
                                    if (uVar.clD[i2] < -3.1415927f) {
                                        uVar.clD[i2] = 6.2831855f + uVar.clD[i2];
                                    } else if (uVar.clD[i2] > 3.1415927f) {
                                        float[] fArr8 = uVar.clD;
                                        fArr8[i2] = fArr8[i2] - 6.2831855f;
                                    }
                                } else if (abs > 1.4835299f) {
                                    if (uVar.clC[i2] > 0.0f) {
                                        float[] fArr9 = uVar.clC;
                                        fArr9[i2] = (fArr9[i2] - f4) + 1.5707964f;
                                    } else {
                                        float[] fArr10 = uVar.clC;
                                        fArr10[i2] = (fArr10[i2] - f4) - 1.5707964f;
                                    }
                                    float[] fArr11 = uVar.clD;
                                    fArr11[i2] = (fArr11[i2] + uVar.clC[i2]) % 6.2831855f;
                                    if (uVar.clD[i2] < -3.1415927f) {
                                        uVar.clD[i2] = 6.2831855f + uVar.clD[i2];
                                    } else if (uVar.clD[i2] > 3.1415927f) {
                                        float[] fArr12 = uVar.clD;
                                        fArr12[i2] = fArr12[i2] - 6.2831855f;
                                    }
                                } else {
                                    uVar.clD[i2] = uVar.clp[i2][0];
                                }
                                uVar.clC[i2] = 0.0f;
                            }
                        }
                        z = false;
                        float[] fArr52 = uVar.clB;
                        fArr52[i2] = fArr52[i2] - uVar.clE[i2][uVar.clA[i2]];
                        z2 = z;
                    }
                }
                a aVar = uVar.clH;
                float[] fArr13 = uVar.clp[i2];
                float[] fArr14 = uVar.clo[i2];
                float[] fArr15 = uVar.clq[i2];
                if (i2 == 0 && aVar.clI != 0) {
                    aVar.clK++;
                    aVar.clX = aVar.clJ / ((float) aVar.clI);
                    float f5 = aVar.clX - aVar.clL;
                    float abs2 = Math.abs(f5);
                    aVar.clL = (((aVar.clL == 0.0f || aVar.clK <= 20 || abs2 <= 1.25f) ? 1.0f : 1.25f / abs2) * (f5 / ((float) aVar.clK))) + aVar.clL;
                    aVar.clM = Math.abs(aVar.clX - aVar.clL) >= 1.25f;
                    if (aVar.clM) {
                        if (aVar.clN < 1200) {
                            aVar.clN++;
                        }
                    } else if (aVar.clN > 0) {
                        aVar.clN--;
                    }
                    aVar.clI = 0;
                    aVar.clJ = 0.0f;
                    if (aVar.clX < aVar.clZ) {
                        aVar.clZ = aVar.clX;
                    }
                    if (aVar.clX > aVar.clY) {
                        aVar.clY = aVar.clX;
                    }
                    if (aVar.clK == 20 && Math.max(aVar.clY - aVar.clL, aVar.clL - aVar.clZ) > 5.0f) {
                        aVar.reset();
                    }
                }
                if (aVar.clK <= 20) {
                    float[] fArr16 = aVar.clU;
                    float[] fArr17 = aVar.clV;
                    aVar.clW[i2] = 1.0f;
                    fArr17[i2] = 1.0f;
                    fArr16[i2] = 1.0f;
                    float[] fArr18 = aVar.clR;
                    float[] fArr19 = aVar.clS;
                    aVar.clT[i2] = 0.0f;
                    fArr19[i2] = 0.0f;
                    fArr18[i2] = 0.0f;
                } else if (aVar.clM || aVar.cma || z2) {
                    float[] fArr20 = aVar.clR;
                    float[] fArr21 = aVar.clS;
                    aVar.clT[i2] = 1.0f;
                    fArr21[i2] = 1.0f;
                    fArr20[i2] = 1.0f;
                    float[] fArr22 = aVar.clU;
                    float[] fArr23 = aVar.clV;
                    aVar.clW[i2] = 0.0f;
                    fArr23[i2] = 0.0f;
                    fArr22[i2] = 0.0f;
                } else {
                    if (aVar.clN > 0) {
                        aVar.clO[i2] = fArr15[0];
                        aVar.clP[i2] = fArr15[1];
                        aVar.clQ[i2] = fArr15[2];
                    }
                    float abs3 = Math.abs(fArr15[0] - fArr13[0]);
                    if (abs3 > 3.1415927f) {
                        abs3 = 6.2831855f - abs3;
                    }
                    float abs4 = Math.abs(aVar.clO[i2] - fArr14[0]);
                    if (abs4 > 3.1415927f) {
                        abs4 = 6.2831855f - abs4;
                    }
                    float max = Math.max(abs4, abs3);
                    float f6 = max != 0.0f ? (((abs4 - abs3) / max) + 1.0f) * 0.5f : 1.0f;
                    float[] fArr24 = aVar.clR;
                    fArr24[i2] = (f6 + fArr24[i2]) / 2.0f;
                    aVar.clU[i2] = 1.0f - aVar.clR[i2];
                    float abs5 = Math.abs(fArr15[1] - fArr13[1]);
                    if (abs5 > 3.1415927f) {
                        abs5 = 6.2831855f - abs5;
                    }
                    float abs6 = Math.abs(aVar.clP[i2] - fArr14[1]);
                    if (abs6 > 3.1415927f) {
                        abs6 = 6.2831855f - abs6;
                    }
                    float max2 = Math.max(abs6, abs5);
                    float f7 = max2 != 0.0f ? (((abs6 - abs5) / max2) + 1.0f) * 0.5f : 1.0f;
                    float[] fArr25 = aVar.clS;
                    fArr25[i2] = (f7 + fArr25[i2]) / 2.0f;
                    aVar.clV[i2] = 1.0f - aVar.clS[i2];
                    float abs7 = Math.abs(fArr15[2] - fArr13[2]);
                    if (abs7 > 3.1415927f) {
                        abs7 = 6.2831855f - abs7;
                    }
                    float abs8 = Math.abs(aVar.clQ[i2] - fArr14[2]);
                    if (abs8 > 3.1415927f) {
                        abs8 = 6.2831855f - abs8;
                    }
                    float max3 = Math.max(abs8, abs7);
                    float f8 = max3 != 0.0f ? (((abs8 - abs7) / max3) + 1.0f) * 0.5f : 1.0f;
                    float[] fArr26 = aVar.clT;
                    fArr26[i2] = (f8 + fArr26[i2]) / 2.0f;
                    aVar.clW[i2] = 1.0f - aVar.clT[i2];
                }
                aVar.clO[i2] = fArr14[0];
                aVar.clP[i2] = fArr14[1];
                aVar.clQ[i2] = fArr14[2];
                float f9 = uVar.clo[i2][0] - uVar.clp[i2][0];
                if (f9 < -3.1415927f) {
                    f9 += 6.2831855f;
                } else if (f9 > 3.1415927f) {
                    f9 -= 6.2831855f;
                }
                float f10 = (f9 * uVar.clH.clU[i2]) + uVar.clp[i2][0];
                if (f10 < -3.1415927f) {
                    f10 += 6.2831855f;
                } else if (f10 > 3.1415927f) {
                    f10 -= 6.2831855f;
                }
                uVar.clq[i2][0] = f10;
                float f11 = uVar.clo[i2][1] - uVar.clp[i2][1];
                if (f11 < -3.1415927f) {
                    f11 += 6.2831855f;
                } else if (f11 > 3.1415927f) {
                    f11 -= 6.2831855f;
                }
                float f12 = (f11 * uVar.clH.clV[i2]) + uVar.clp[i2][1];
                if (f12 < -3.1415927f) {
                    f12 += 6.2831855f;
                } else if (f12 > 3.1415927f) {
                    f12 -= 6.2831855f;
                }
                uVar.clq[i2][1] = f12;
                float f13 = uVar.clo[i2][2] - uVar.clp[i2][2];
                if (f13 < -3.1415927f) {
                    f13 += 6.2831855f;
                } else if (f13 > 3.1415927f) {
                    f13 -= 6.2831855f;
                }
                float f14 = (f13 * uVar.clH.clW[i2]) + uVar.clp[i2][2];
                if (f14 < -3.1415927f) {
                    f14 += 6.2831855f;
                } else if (f14 > 3.1415927f) {
                    f14 -= 6.2831855f;
                }
                uVar.clq[i2][2] = f14;
                float[][] fArr27 = uVar.clm;
                float[] fArr28 = uVar.clq[i2];
                float sin = (float) Math.sin((double) fArr28[1]);
                float cos = (float) Math.cos((double) fArr28[1]);
                float sin2 = (float) Math.sin((double) fArr28[2]);
                float cos2 = (float) Math.cos((double) fArr28[2]);
                float sin3 = (float) Math.sin((double) fArr28[0]);
                float cos3 = (float) Math.cos((double) fArr28[0]);
                fArr27[i2] = b(new float[]{cos3, sin3, 0.0f, -sin3, cos3, 0.0f, 0.0f, 0.0f, 1.0f}, b(new float[]{1.0f, 0.0f, 0.0f, 0.0f, cos, sin, 0.0f, -sin, cos}, new float[]{cos2, 0.0f, sin2, 0.0f, 1.0f, 0.0f, -sin2, 0.0f, cos2}));
                System.arraycopy(uVar.clq[i2], 0, uVar.clp[i2], 0, 3);
            }
        }
        d dVar = uVar.clF;
        if (uVar.cli != null) {
            fArr = uVar.clr;
        } else {
            fArr = uVar.clq;
        }
        b a2 = dVar.a(fArr);
        if (a2 != null) {
            uVar.clG.a(a2);
        }
        AppMethodBeat.o(87996);
    }

    static /* synthetic */ void b(u uVar) {
        AppMethodBeat.i(87997);
        f.a JA = uVar.clG.JA();
        if (JA != null) {
            uVar.c(new e(JA.x, JA.y, JA.cmO, JA.cmP, JA.cmQ, JA.cmR, (byte) 0));
        }
        AppMethodBeat.o(87997);
    }
}
