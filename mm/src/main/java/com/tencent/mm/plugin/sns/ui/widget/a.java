package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends Animation {
    private final float FdR;
    private final float FdS;
    private final float FdT;
    private final boolean FdU;
    private Camera FdV;
    private Context context;
    private final float dhi;
    private final float dhj;
    private float scale = 1.0f;

    public a(Context context2, float f2, float f3, float f4, float f5, boolean z) {
        AppMethodBeat.i(100450);
        this.context = context2;
        this.FdR = f2;
        this.FdS = f3;
        this.dhi = f4;
        this.dhj = f5;
        this.FdT = 150.0f;
        this.FdU = z;
        this.scale = context2.getResources().getDisplayMetrics().density;
        AppMethodBeat.o(100450);
    }

    public final void initialize(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(100451);
        super.initialize(i2, i3, i4, i5);
        this.FdV = new Camera();
        AppMethodBeat.o(100451);
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f2, Transformation transformation) {
        AppMethodBeat.i(100452);
        float f3 = this.FdR + ((this.FdS - this.FdR) * f2);
        float f4 = this.dhi;
        float f5 = this.dhj;
        Camera camera = this.FdV;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.FdU) {
            camera.translate(0.0f, 0.0f, this.FdT * f2);
        } else {
            camera.translate(0.0f, 0.0f, this.FdT * (1.0f - f2));
        }
        camera.rotateY(f3);
        camera.getMatrix(matrix);
        camera.restore();
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        matrix.getValues(fArr);
        fArr[6] = fArr[6] / this.scale;
        matrix.setValues(fArr);
        matrix.preTranslate(-f4, -f5);
        matrix.postTranslate(f4, f5);
        AppMethodBeat.o(100452);
    }
}
