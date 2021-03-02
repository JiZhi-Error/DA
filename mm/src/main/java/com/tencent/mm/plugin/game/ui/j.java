package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class j extends BitmapDrawable implements u.a {
    private static Bitmap dku;
    private static MMHandler iuH = new MMHandler(Looper.getMainLooper());
    private Runnable iuJ;
    private String mUrl;
    private Bitmap xRS;

    public static class a {
    }

    /* synthetic */ j(String str, byte b2) {
        this(str);
    }

    static {
        AppMethodBeat.i(42083);
        AppMethodBeat.o(42083);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private j(java.lang.String r4) {
        /*
            r3 = this;
            r2 = 42078(0xa45e, float:5.8964E-41)
            r1 = 8
            android.graphics.Bitmap r0 = com.tencent.mm.plugin.game.ui.j.dku
            if (r0 == 0) goto L_0x001d
            android.graphics.Bitmap r0 = com.tencent.mm.plugin.game.ui.j.dku
            boolean r0 = r0.isRecycled()
            if (r0 != 0) goto L_0x001d
            android.graphics.Bitmap r0 = com.tencent.mm.plugin.game.ui.j.dku
        L_0x0013:
            r3.<init>(r4, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        L_0x001d:
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r1, r1, r0)
            com.tencent.mm.plugin.game.ui.j.dku = r0
            goto L_0x0013
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.ui.j.<init>(java.lang.String):void");
    }

    private j(String str, Bitmap bitmap) {
        super(bitmap);
        AppMethodBeat.i(42079);
        this.iuJ = new Runnable() {
            /* class com.tencent.mm.plugin.game.ui.j.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(42076);
                j.this.invalidateSelf();
                AppMethodBeat.o(42076);
            }
        };
        Paint paint = getPaint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        u.a(this);
        setUrl(str);
        AppMethodBeat.o(42079);
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, Bitmap bitmap) {
        AppMethodBeat.i(42080);
        if (this.mUrl != null && new StringBuilder().append(this.mUrl.hashCode()).toString().equals(str) && bitmap != null && !bitmap.isRecycled()) {
            Log.i("MicroMsg.GameDrawable", "onGerPictureFinish() function has been invoke.");
            this.xRS = bitmap;
            iuH.post(this.iuJ);
        }
        AppMethodBeat.o(42080);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(42081);
        if (this.xRS == null || this.xRS.isRecycled()) {
            super.draw(canvas);
            AppMethodBeat.o(42081);
            return;
        }
        Rect bounds = getBounds();
        canvas.drawBitmap(this.xRS, new Rect(0, 0, this.xRS.getWidth(), this.xRS.getHeight()), bounds, getPaint());
        AppMethodBeat.o(42081);
    }

    public final void setUrl(String str) {
        AppMethodBeat.i(42082);
        if (str != null && !str.equals(this.mUrl)) {
            Log.i("MicroMsg.GameDrawable", "set a new url for the drawable,url:[%s]", str);
            this.mUrl = str;
            Bitmap a2 = u.a(new ai(this.mUrl));
            if (a2 != null && !a2.isRecycled()) {
                this.xRS = a2;
            }
            iuH.post(this.iuJ);
        }
        AppMethodBeat.o(42082);
    }
}
