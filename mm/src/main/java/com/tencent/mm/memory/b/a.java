package com.tencent.mm.memory.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class a extends Drawable implements i {
    boolean DEBUG = false;
    protected final Paint iuG = new Paint();
    private final MMHandler iuH;
    protected n iuI;
    private Runnable iuJ = new Runnable() {
        /* class com.tencent.mm.memory.b.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(156522);
            Log.d("MicroMsg.MaskBitmapDrawable", "refresh tag=%s", a.this.tag);
            a.this.invalidateSelf();
            AppMethodBeat.o(156522);
        }
    };
    protected String tag;

    public a(String str, n nVar) {
        AppMethodBeat.i(156523);
        this.tag = str;
        this.iuI = nVar;
        this.iuG.setAntiAlias(true);
        this.iuG.setFilterBitmap(false);
        this.iuG.setColor(-1118482);
        this.iuH = new MMHandler(Looper.getMainLooper());
        AppMethodBeat.o(156523);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(156524);
        Rect bounds = getBounds();
        n nVar = this.iuI;
        if (nVar == null || nVar.isRecycled()) {
            canvas.drawColor(-1118482);
            AppMethodBeat.o(156524);
            return;
        }
        canvas.drawBitmap(nVar.bitmap, (Rect) null, bounds, this.iuG);
        AppMethodBeat.o(156524);
    }

    @Override // com.tencent.mm.memory.i
    public final void aRW() {
        AppMethodBeat.i(156525);
        if (this.iuI != null) {
            this.iuI.aRW();
        }
        AppMethodBeat.o(156525);
    }

    @Override // com.tencent.mm.memory.i
    public final void aRX() {
        AppMethodBeat.i(156526);
        if (this.iuI != null) {
            this.iuI.aRX();
        }
        AppMethodBeat.o(156526);
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getIntrinsicWidth() {
        AppMethodBeat.i(156527);
        if (this.iuI == null) {
            AppMethodBeat.o(156527);
            return 0;
        }
        n nVar = this.iuI;
        if (nVar == null || nVar.isRecycled()) {
            AppMethodBeat.o(156527);
            return 0;
        }
        int width = nVar.bitmap.getWidth();
        AppMethodBeat.o(156527);
        return width;
    }

    public int getIntrinsicHeight() {
        AppMethodBeat.i(156528);
        if (this.iuI == null) {
            AppMethodBeat.o(156528);
            return 0;
        }
        n nVar = this.iuI;
        if (nVar == null || nVar.isRecycled()) {
            AppMethodBeat.o(156528);
            return 0;
        }
        int height = nVar.bitmap.getHeight();
        AppMethodBeat.o(156528);
        return height;
    }

    public final n aSr() {
        if (this.iuI != null) {
            return this.iuI;
        }
        return null;
    }

    public String toString() {
        AppMethodBeat.i(156529);
        if (this.DEBUG) {
            String str = super.toString() + " code: " + hashCode();
            if (this.iuI != null) {
                str = str + this.iuI;
            }
            AppMethodBeat.o(156529);
            return str;
        }
        String obj = super.toString();
        AppMethodBeat.o(156529);
        return obj;
    }
}
