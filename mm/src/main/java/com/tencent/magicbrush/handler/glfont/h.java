package com.tencent.magicbrush.handler.glfont;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class h {
    private List<k> cNf = new ArrayList();
    private g cNj;
    private e cNk;
    private Canvas cNl;
    j cNm;
    Paint cNn;
    c cNo;
    private char[] cNp = new char[1];
    private Rect cNq = new Rect();
    Paint.FontMetrics cNr = new Paint.FontMetrics();
    private Rect lo = new Rect();

    h(e eVar, g gVar) {
        AppMethodBeat.i(140032);
        this.cNk = eVar;
        this.cNl = new Canvas(this.cNk.cMT);
        this.cNj = gVar;
        this.cNn = new Paint(1);
        this.cNn.setTextAlign(Paint.Align.LEFT);
        this.cNn.setColor(-1);
        AppMethodBeat.o(140032);
    }

    /* access modifiers changed from: package-private */
    public final k u(char c2) {
        AppMethodBeat.i(140033);
        k Rz = this.cNj.cNd.Rz();
        Rz.cNM = false;
        a(Rz, (int) Math.ceil((double) v(c2)), (int) Math.ceil((double) (this.cNr.bottom - this.cNr.ascent)));
        if (!this.cNk.b((int) Math.ceil((double) Rz.width), (int) Math.ceil((double) Rz.height), this.lo)) {
            AppMethodBeat.o(140033);
            return null;
        }
        a(Rz, this.lo);
        a(c2, this.lo, Rz, this.cNn);
        AppMethodBeat.o(140033);
        return Rz;
    }

    private float v(char c2) {
        AppMethodBeat.i(140034);
        this.cNp[0] = c2;
        this.cNn.getTextBounds(this.cNp, 0, 1, this.lo);
        float max = Math.max((float) this.lo.width(), this.cNn.measureText(this.cNp, 0, 1)) + 1.0f;
        AppMethodBeat.o(140034);
        return max;
    }

    private void a(k kVar, int i2, int i3) {
        AppMethodBeat.i(140035);
        if (kVar == null) {
            AppMethodBeat.o(140035);
            return;
        }
        kVar.cNG = (float) i2;
        kVar.cNH = 0.0f;
        kVar.u((float) i2, (float) i3);
        if (isItalic()) {
            float ceil = (float) Math.ceil((double) (((float) i2) * 0.5f));
            kVar.cNH -= ceil / 2.0f;
            kVar.width = ceil + kVar.width;
        }
        if (RA()) {
            kVar.cNH -= this.cNm.strokeWidth / 2.0f;
            kVar.width += this.cNm.strokeWidth;
        }
        if (isBold()) {
            kVar.cNH -= 1.0f;
            kVar.width += 2.0f;
        }
        AppMethodBeat.o(140035);
    }

    private void a(k kVar, Rect rect) {
        AppMethodBeat.i(140036);
        kVar.k(((float) rect.left) / ((float) this.cNk.width()), ((float) rect.top) / ((float) this.cNk.height()), ((float) rect.right) / ((float) this.cNk.width()), ((float) rect.bottom) / ((float) this.cNk.height()));
        AppMethodBeat.o(140036);
    }

    private void a(char c2, Rect rect, k kVar, Paint paint) {
        AppMethodBeat.i(140037);
        if (paint == null || kVar == null || rect == null) {
            AppMethodBeat.o(140037);
            return;
        }
        this.cNp[0] = c2;
        this.cNl.save();
        this.cNl.clipRect(rect);
        this.cNl.drawText(this.cNp, 0, 1, ((float) rect.left) - kVar.cNH, ((((float) rect.top) + kVar.height) - this.cNr.bottom) - 1.0f, paint);
        this.cNl.restore();
        AppMethodBeat.o(140037);
    }

    private boolean RA() {
        if (this.cNm == null) {
            return false;
        }
        return this.cNm.cNx;
    }

    private boolean isBold() {
        AppMethodBeat.i(175886);
        if (this.cNm == null) {
            AppMethodBeat.o(175886);
            return false;
        }
        boolean isBold = this.cNm.cNy.isBold();
        AppMethodBeat.o(175886);
        return isBold;
    }

    private boolean isItalic() {
        AppMethodBeat.i(140038);
        if (this.cNm == null) {
            AppMethodBeat.o(140038);
            return false;
        }
        boolean isItalic = this.cNm.cNy.isItalic();
        AppMethodBeat.o(140038);
        return isItalic;
    }

    /* access modifiers changed from: package-private */
    public final k a(Drawable drawable, int i2, int i3) {
        AppMethodBeat.i(140039);
        if (i2 <= 0 || i3 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("width or height unexpected");
            AppMethodBeat.o(140039);
            throw illegalArgumentException;
        }
        k Rz = this.cNj.cNd.Rz();
        Rz.cNG = (float) i2;
        Rz.cNH = 0.0f;
        this.cNk.b(i2, i3, this.lo);
        Rect rect = this.lo;
        if (rect.left < 0 || rect.right < 0 || rect.width() <= 0 || rect.height() <= 0) {
            AppMethodBeat.o(140039);
            return null;
        }
        Rz.u((float) i2, (float) i3);
        Rz.k(((float) rect.left) / ((float) this.cNk.width()), ((float) rect.top) / ((float) this.cNk.height()), ((float) rect.right) / ((float) this.cNk.width()), ((float) rect.bottom) / ((float) this.cNk.height()));
        Rz.cNM = true;
        this.cNl.save();
        this.cNl.clipRect(rect);
        drawable.setBounds(rect);
        drawable.draw(this.cNl);
        this.cNl.restore();
        AppMethodBeat.o(140039);
        return Rz;
    }

    static float I(List<k> list) {
        AppMethodBeat.i(140040);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(140040);
            return 0.0f;
        }
        float f2 = 0.0f;
        for (k kVar : list) {
            if (kVar != null) {
                f2 = kVar.cNG + f2;
            }
        }
        AppMethodBeat.o(140040);
        return f2;
    }
}
