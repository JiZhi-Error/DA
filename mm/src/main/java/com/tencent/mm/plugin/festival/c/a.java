package com.tencent.mm.plugin.festival.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.festival.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.blur.b;
import com.tencent.mm.ui.blur.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0016R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/festival/util/FestivalBlurHelper;", "", "()V", "bitmapCache", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "snapshotBlurAlgo", "Lcom/tencent/mm/ui/blur/BlurAlgorithm;", "allocBitmap", "cacheIndex", "", "width", "height", "allocBlurAlgorithm", "captureViewBlurSnapshot", "view", "Landroid/view/View;", "_blurRadius", "", "_downscaleFactor", "destroy", "", "Companion", "plugin-festival_release"})
public final class a {
    @Deprecated
    public static final C1052a UFZ = new C1052a((byte) 0);
    private b UFX;
    private final Bitmap[] UFY = new Bitmap[2];

    static {
        AppMethodBeat.i(263473);
        AppMethodBeat.o(263473);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/util/FestivalBlurHelper$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    /* renamed from: com.tencent.mm.plugin.festival.c.a$a  reason: collision with other inner class name */
    static final class C1052a {
        private C1052a() {
        }

        public /* synthetic */ C1052a(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(263472);
        AppMethodBeat.o(263472);
    }

    private final Bitmap ae(int i2, int i3, int i4) {
        AppMethodBeat.i(263468);
        Bitmap bitmap = this.UFY[i2];
        if (bitmap == null || bitmap.isRecycled()) {
            this.UFY[i2] = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        } else if (!(bitmap.getWidth() == i3 && bitmap.getHeight() == i4)) {
            try {
                bitmap.reconfigure(i3, i4, Bitmap.Config.ARGB_8888);
            } catch (Exception e2) {
                j jVar = j.UGJ;
                j.aQ(bitmap);
                this.UFY[i2] = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            }
        }
        Bitmap bitmap2 = this.UFY[i2];
        if (bitmap2 == null) {
            p.hyc();
        }
        AppMethodBeat.o(263468);
        return bitmap2;
    }

    private final b hSs() {
        AppMethodBeat.i(263469);
        if (this.UFX == null) {
            this.UFX = new e(MMApplicationContext.getContext());
        }
        b bVar = this.UFX;
        if (bVar == null) {
            p.hyc();
        }
        AppMethodBeat.o(263469);
        return bVar;
    }

    public final Bitmap gD(View view) {
        AppMethodBeat.i(263470);
        c cVar = c.UxA;
        if (!c.gFg()) {
            AppMethodBeat.o(263470);
            return null;
        }
        float p = android.support.v4.b.a.p(25.0f, 1.0f, 25.0f);
        float p2 = android.support.v4.b.a.p(0.25f, 0.1f, 1.0f);
        if (view != null) {
            try {
                if (view.isLaidOut()) {
                    Bitmap ae = ae(0, view.getWidth(), view.getHeight());
                    view.draw(new Canvas(ae));
                    Bitmap ae2 = ae(1, kotlin.h.a.cR(((float) view.getWidth()) * p2), kotlin.h.a.cR(((float) view.getHeight()) * p2));
                    Canvas canvas = new Canvas(ae2);
                    Matrix matrix = new Matrix();
                    matrix.setScale(p2, p2);
                    canvas.drawBitmap(ae, matrix, null);
                    hSs().b(ae2, p);
                    Canvas canvas2 = new Canvas(ae);
                    Matrix matrix2 = new Matrix();
                    matrix2.setScale(1.0f / p2, 1.0f / p2);
                    canvas2.drawBitmap(ae2, matrix2, null);
                    hSs().b(ae, p);
                    AppMethodBeat.o(263470);
                    return ae;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.FestivalBlurHelper", "captureViewBlurSnapshot(blurRadius:" + p + "), exception=" + e2);
                AppMethodBeat.o(263470);
                return null;
            }
        }
        AppMethodBeat.o(263470);
        return null;
    }

    public final void destroy() {
        AppMethodBeat.i(263471);
        try {
            b bVar = this.UFX;
            if (bVar != null) {
                bVar.destroy();
            }
            this.UFX = null;
        } catch (Exception e2) {
            this.UFX = null;
        } catch (Throwable th) {
            this.UFX = null;
            AppMethodBeat.o(263471);
            throw th;
        }
        Bitmap[] bitmapArr = this.UFY;
        for (Bitmap bitmap : bitmapArr) {
            if (bitmap != null) {
                j jVar = j.UGJ;
                j.aQ(bitmap);
            }
        }
        kotlin.a.e.P(this.UFY);
        AppMethodBeat.o(263471);
    }
}
