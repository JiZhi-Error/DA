package com.plattysoft.leonids;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public class ParticleField extends View {
    ArrayList<a> hNt;

    public ParticleField(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public ParticleField(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ParticleField(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(261908);
        super.onDraw(canvas);
        synchronized (this.hNt) {
            for (int i2 = 0; i2 < this.hNt.size(); i2++) {
                try {
                    a aVar = this.hNt.get(i2);
                    aVar.mMatrix.reset();
                    aVar.mMatrix.postRotate(aVar.SM, (float) aVar.hHw, (float) aVar.hHx);
                    aVar.mMatrix.postScale(aVar.dhh, aVar.dhh, (float) aVar.hHw, (float) aVar.hHx);
                    aVar.mMatrix.postTranslate(aVar.gVp, aVar.huc);
                    aVar.mPaint.setAlpha(aVar.mAlpha);
                    canvas.drawBitmap(aVar.gtH, aVar.mMatrix, aVar.mPaint);
                } finally {
                    AppMethodBeat.o(261908);
                }
            }
        }
    }
}
