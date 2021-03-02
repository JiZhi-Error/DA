package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetPixelsActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;

public final class ad implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144962);
        SetPixelsActionArg setPixelsActionArg = new SetPixelsActionArg();
        AppMethodBeat.o(144962);
        return setPixelsActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "__setPixels";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144963);
        try {
            boolean a2 = a(dVar, canvas, (Bitmap) jSONArray.get(4), g.c(jSONArray, 0), g.c(jSONArray, 1), g.c(jSONArray, 2), g.c(jSONArray, 3));
            AppMethodBeat.o(144963);
            return a2;
        } catch (Exception e2) {
            Log.w("MicroMsg.SetPixelsAction", "get bitmap data error, %s", android.util.Log.getStackTraceString(e2));
            AppMethodBeat.o(144963);
            return false;
        }
    }

    private static boolean a(d dVar, Canvas canvas, Bitmap bitmap, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(144964);
        if (canvas.isHardwareAccelerated()) {
            if (canvas instanceof f) {
                ((f) canvas).l((float) i2, (float) i3, (float) (i2 + i4), (float) (i3 + i5));
                Log.v("MicroMsg.SetPixelsAction", "MCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            } else if (dVar.kZq != null) {
                canvas.drawRect((float) i2, (float) i3, (float) (i2 + i4), (float) (i3 + i5), dVar.kZq);
                Log.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            } else {
                Log.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) failed", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            }
        } else if (dVar.kZq != null) {
            canvas.drawRect((float) i2, (float) i3, (float) (i2 + i4), (float) (i3 + i5), dVar.kZq);
            Log.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        } else {
            canvas.drawRect((float) i2, (float) i3, (float) (i2 + i4), (float) (i3 + i5), dVar.kZp);
            Log.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with default clearPaint", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        }
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(144964);
            return false;
        }
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new RectF((float) i2, (float) i3, (float) (i2 + i4), (float) (i3 + i5)), dVar.kZl);
        AppMethodBeat.o(144964);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144965);
        SetPixelsActionArg setPixelsActionArg = (SetPixelsActionArg) drawActionArg;
        if (setPixelsActionArg == null) {
            AppMethodBeat.o(144965);
            return false;
        }
        boolean a2 = a(dVar, canvas, setPixelsActionArg.bitmap, setPixelsActionArg.x, setPixelsActionArg.y, setPixelsActionArg.width, setPixelsActionArg.height);
        AppMethodBeat.o(144965);
        return a2;
    }
}
