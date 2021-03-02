package com.tencent.magicbrush.handler.glfont;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class e {
    Bitmap cMT;
    private d cMU = new l();
    Rect cMV = new Rect();
    int[] cMW = new int[4];

    e(int i2, int i3) {
        AppMethodBeat.i(140012);
        i2 = i2 <= 0 ? 512 : i2;
        i3 = i3 <= 0 ? 512 : i3;
        this.cMT = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        this.cMU.init(i2, i3);
        this.cMV.setEmpty();
        AppMethodBeat.o(140012);
    }

    /* access modifiers changed from: package-private */
    public final boolean b(int i2, int i3, Rect rect) {
        AppMethodBeat.i(140013);
        if (rect == null) {
            AppMethodBeat.o(140013);
            return false;
        } else if (i2 <= 0 || i3 <= 0) {
            rect.setEmpty();
            AppMethodBeat.o(140013);
            return false;
        } else {
            this.cMU.a(i2, i3, rect);
            if (rect.left < 0 || rect.right < 0 || rect.width() <= 0 || rect.height() <= 0) {
                AppMethodBeat.o(140013);
                return false;
            }
            this.cMV.union(rect);
            AppMethodBeat.o(140013);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void clear() {
        AppMethodBeat.i(140014);
        this.cMV.setEmpty();
        this.cMU.reset();
        if (this.cMT != null) {
            this.cMT.eraseColor(0);
        }
        AppMethodBeat.o(140014);
    }

    /* access modifiers changed from: package-private */
    public final int width() {
        AppMethodBeat.i(140015);
        if (this.cMT != null) {
            int width = this.cMT.getWidth();
            AppMethodBeat.o(140015);
            return width;
        }
        AppMethodBeat.o(140015);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int height() {
        AppMethodBeat.i(140016);
        if (this.cMT != null) {
            int height = this.cMT.getHeight();
            AppMethodBeat.o(140016);
            return height;
        }
        AppMethodBeat.o(140016);
        return 0;
    }
}
