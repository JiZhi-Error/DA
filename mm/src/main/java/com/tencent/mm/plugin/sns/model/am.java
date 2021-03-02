package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.r;
import java.util.HashMap;
import java.util.Map;

public final class am extends a {
    long DMd;
    boolean DMe = false;
    private Map<String, Boolean> DMf = new HashMap();
    int alpha = 255;

    public am(String str, n nVar, long j2) {
        super(str, nVar);
        AppMethodBeat.i(95854);
        if (j2 != 0) {
            this.DMd = j2;
            this.DMf.put(str, Boolean.TRUE);
            this.DMe = true;
            AppMethodBeat.o(95854);
            return;
        }
        if (!this.DMf.containsKey(str)) {
            this.DMd = SystemClock.uptimeMillis();
            this.DMf.put(str, Boolean.TRUE);
            this.DMe = true;
        }
        AppMethodBeat.o(95854);
    }

    @Override // com.tencent.mm.memory.b.a
    public final void draw(Canvas canvas) {
        AppMethodBeat.i(95855);
        Rect bounds = getBounds();
        Bitmap aSb = this.iuI.aSb();
        if (!r.M(aSb)) {
            canvas.drawColor(-1118482);
            this.DMd = 0;
            AppMethodBeat.o(95855);
            return;
        }
        if (this.DMe) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.DMd)) / 150.0f;
            if (this.DMd == 0) {
                uptimeMillis = 0.0f;
            }
            if (uptimeMillis >= 1.0f) {
                this.DMe = false;
            } else {
                this.iuG.setAlpha((int) (uptimeMillis * ((float) this.alpha)));
                canvas.drawBitmap(aSb, (Rect) null, bounds, this.iuG);
                invalidateSelf();
                AppMethodBeat.o(95855);
                return;
            }
        }
        this.iuG.setAlpha(this.alpha);
        canvas.drawBitmap(aSb, (Rect) null, bounds, this.iuG);
        AppMethodBeat.o(95855);
    }
}
