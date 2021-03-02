package com.tencent.mm.danmaku.e;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.danmaku.f.a;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private static final Rect gQM = new Rect();
    private static final TextPaint gQN = new TextPaint();
    private static final Map<Float, Float> gQO = new HashMap();
    private static final Map<Float, Float> gQP = new HashMap();
    private static final Map<Float, Float> gQQ = new HashMap();
    public static Paint gQR;
    public static Paint gQS;
    private static int gQT;

    static {
        AppMethodBeat.i(241766);
        Paint paint = new Paint();
        gQR = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        AppMethodBeat.o(241766);
    }

    public static void a(Canvas canvas, String str) {
        AppMethodBeat.i(241761);
        if (gQS == null) {
            Paint paint = new Paint();
            gQS = paint;
            paint.setColor(-256);
            gQS.setTextSize(a.atr().getResources().getDisplayMetrics().density * 12.5f);
            Paint.FontMetrics fontMetrics = gQS.getFontMetrics();
            gQT = (int) Math.ceil((double) (fontMetrics.descent - fontMetrics.ascent));
        }
        canvas.drawText(str, 10.0f, (float) (canvas.getHeight() - gQT), gQS);
        AppMethodBeat.o(241761);
    }

    public static void n(Canvas canvas) {
        AppMethodBeat.i(241762);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        AppMethodBeat.o(241762);
    }

    public static float ap(float f2) {
        AppMethodBeat.i(241764);
        gQN.setTextSize(f2);
        Float f3 = gQO.get(Float.valueOf(f2));
        if (f3 == null) {
            Paint.FontMetrics fontMetrics = gQN.getFontMetrics();
            f3 = Float.valueOf(fontMetrics.leading + (fontMetrics.descent - fontMetrics.ascent));
            gQO.put(Float.valueOf(f2), f3);
        }
        float floatValue = f3.floatValue();
        AppMethodBeat.o(241764);
        return floatValue;
    }

    public static float a(float f2, String str) {
        AppMethodBeat.i(241765);
        gQN.setTextSize(f2);
        float measureText = gQN.measureText(str);
        AppMethodBeat.o(241765);
        return measureText;
    }

    public static float a(m mVar) {
        AppMethodBeat.i(241763);
        float ap = ap(mVar.gPN) + ((float) (com.tencent.mm.danmaku.c.a.asO().gPI * 2)) + (mVar.gPO * 2.0f) + (mVar.gPP * 2.0f);
        AppMethodBeat.o(241763);
        return ap;
    }
}
