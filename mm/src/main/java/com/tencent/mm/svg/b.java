package com.tencent.mm.svg;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class b {
    private static a<Paint> Ouk = new a<>();
    private static a<float[]> Oul = new a<>();
    private static a<Matrix> Oum = new a<>();
    private static a<Path> Oun = new a<>();
    private static final float[] Ouo = new float[9];

    static {
        AppMethodBeat.i(148689);
        AppMethodBeat.o(148689);
    }

    protected static synchronized void h(Looper looper) {
        synchronized (b.class) {
            AppMethodBeat.i(148684);
            Ouk.g(looper);
            Oul.g(looper);
            Oum.g(looper);
            Oun.g(looper);
            AppMethodBeat.o(148684);
        }
    }

    protected static synchronized Paint a(Looper looper, Paint paint) {
        Paint gFM;
        synchronized (b.class) {
            AppMethodBeat.i(148685);
            gFM = Ouk.gFM();
            if (gFM == null) {
                gFM = new Paint();
            } else {
                gFM.reset();
            }
            if (paint != null) {
                gFM.set(paint);
            }
            Ouk.a(looper, gFM);
            AppMethodBeat.o(148685);
        }
        return gFM;
    }

    protected static synchronized float[] instanceMatrixArray(Looper looper) {
        float[] gFM;
        synchronized (b.class) {
            AppMethodBeat.i(148686);
            gFM = Oul.gFM();
            if (gFM == null) {
                gFM = new float[9];
            } else {
                System.arraycopy(Ouo, 0, gFM, 0, 9);
            }
            Oul.a(looper, gFM);
            AppMethodBeat.o(148686);
        }
        return gFM;
    }

    protected static synchronized Matrix instanceMatrix(Looper looper) {
        Matrix gFM;
        synchronized (b.class) {
            AppMethodBeat.i(148687);
            gFM = Oum.gFM();
            if (gFM == null) {
                gFM = new Matrix();
            } else {
                gFM.reset();
            }
            Oum.a(looper, gFM);
            AppMethodBeat.o(148687);
        }
        return gFM;
    }

    protected static synchronized Path a(Looper looper, Path path) {
        Path gFM;
        synchronized (b.class) {
            AppMethodBeat.i(214354);
            gFM = Oun.gFM();
            if (gFM == null) {
                gFM = new Path();
            } else {
                gFM.reset();
            }
            if (path != null) {
                gFM.set(path);
            }
            Oun.a(looper, gFM);
            AppMethodBeat.o(214354);
        }
        return gFM;
    }
}
