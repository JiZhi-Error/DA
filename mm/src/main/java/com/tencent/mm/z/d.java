package com.tencent.mm.z;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.x.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/items/FilterItem;", "", "type", "", "(I)V", "TAG", "", "cacheColorWeight", "", "getCacheColorWeight", "()F", "setCacheColorWeight", "(F)V", "cacheFilteredBitmap", "Landroid/graphics/Bitmap;", "getCacheFilteredBitmap", "()Landroid/graphics/Bitmap;", "setCacheFilteredBitmap", "(Landroid/graphics/Bitmap;)V", "getType", "()I", "draw", "", "canvas", "Landroid/graphics/Canvas;", "preBitmap", "colorWeight", "filterBitmap", "plugin-photoedit-sdk_release"})
public final class d implements Cloneable {
    private final String TAG = "MicroMsg.FilterItem";
    private Bitmap hox;
    private float hoy;
    private final int type;

    public d(int i2) {
        this.type = i2;
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(163167);
        Object clone = super.clone();
        AppMethodBeat.o(163167);
        return clone;
    }

    public final void a(Canvas canvas, Bitmap bitmap, float f2) {
        AppMethodBeat.i(163165);
        p.h(canvas, "canvas");
        p.h(bitmap, "preBitmap");
        Log.i(this.TAG, "draw cacheColorWeight " + this.hoy + ", colorWeight:" + f2 + ", cacheFilteredBitmap:" + this.hox);
        if (this.hox == null || f2 != this.hoy) {
            this.hoy = f2;
            C(bitmap);
        }
        Bitmap bitmap2 = this.hox;
        if (bitmap2 == null) {
            p.hyc();
        }
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        Log.i(this.TAG, "lxl item draw");
        AppMethodBeat.o(163165);
    }

    private void C(Bitmap bitmap) {
        AppMethodBeat.i(163166);
        p.h(bitmap, "preBitmap");
        a aVar = a.hiy;
        this.hox = a.a(bitmap, this.type, bitmap.getWidth(), bitmap.getHeight(), this.hoy);
        AppMethodBeat.o(163166);
    }
}
