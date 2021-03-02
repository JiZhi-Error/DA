package com.tencent.mm.z;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.smtt.sdk.WebView;

public final class a implements Cloneable {
    public static Rect Ui = new Rect();
    private static int hnT = ((int) MMApplicationContext.getResources().getDimension(R.dimen.u7));
    private static int hnU = ((int) MMApplicationContext.getResources().getDimension(R.dimen.u6));
    public static float hnV = MMApplicationContext.getResources().getDimension(R.dimen.yc);
    public static float hnW = MMApplicationContext.getResources().getDimension(R.dimen.yb);
    public static Path hnX = new Path();
    public static Path hnY = new Path();
    public static Paint hnZ = new Paint();
    public static Paint hoa = new Paint();
    public static Paint hob = new Paint();
    public static Paint hoc = new Paint();
    public static Paint hod = new Paint();
    public Rect dgS;
    public Rect hoe = new Rect();
    public Rect hof = new Rect();
    public Matrix mMatrix = new Matrix();

    static {
        AppMethodBeat.i(9245);
        hob.setColor(WebView.NIGHT_MODE_COLOR);
        hnZ.setColor(-1);
        hnZ.setStrokeWidth((float) hnT);
        hnZ.setStyle(Paint.Style.STROKE);
        hnZ.setAntiAlias(true);
        hoc.set(hnZ);
        hoc.setStrokeWidth((float) hnU);
        hod.set(hnZ);
        hod.setStrokeWidth(hnV);
        hoa.set(hnZ);
        hoa.setStrokeWidth((float) (hnT * 7));
        hoa.setColor(549174203);
        AppMethodBeat.o(9245);
    }

    public a(Rect rect) {
        AppMethodBeat.i(9240);
        this.dgS = rect;
        AppMethodBeat.o(9240);
    }

    public a() {
        AppMethodBeat.i(9241);
        AppMethodBeat.o(9241);
    }

    public static void pN(int i2) {
        AppMethodBeat.i(9242);
        hod.setAlpha(i2);
        hnZ.setAlpha(i2);
        hoc.setAlpha((int) (0.7058824f * ((float) i2)));
        AppMethodBeat.o(9242);
    }

    public static void pO(int i2) {
        AppMethodBeat.i(9243);
        hob.setAlpha((int) (0.9019608f * ((float) i2)));
        AppMethodBeat.o(9243);
    }

    public final void setMatrix(Matrix matrix) {
        AppMethodBeat.i(204752);
        this.mMatrix.set(matrix);
        AppMethodBeat.o(204752);
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(9244);
        Object clone = super.clone();
        AppMethodBeat.o(9244);
        return clone;
    }
}
