package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;

public final class a extends View {
    private c Ebh;

    public a(Context context, c cVar) {
        super(context);
        this.Ebh = cVar;
    }

    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(96344);
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int min = (int) (((double) (((float) Math.min(height, width)) / 2.0f)) * 0.8d);
        int i2 = (int) (((float) width) / 2.0f);
        int i3 = (int) (((float) height) / 2.0f);
        Bitmap bitmap = this.Ebh.EaQ;
        if (bitmap != null) {
            int i4 = (int) (((float) (min * 2)) + (this.Ebh.EaR * 2.0f));
            int width2 = (bitmap.getWidth() * i4) / bitmap.getHeight();
            canvas.drawBitmap(Bitmap.createScaledBitmap(bitmap, width2, i4, false), (float) (i2 - (width2 >>> 1)), (float) (i3 - (i4 >>> 1)), (Paint) null);
        }
        AppMethodBeat.o(96344);
    }
}
