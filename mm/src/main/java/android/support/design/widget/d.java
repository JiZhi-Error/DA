package android.support.design.widget;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v4.d.e;
import android.support.v4.view.u;
import android.support.v7.a.a;
import android.support.v7.widget.az;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public final class d {
    private static final boolean oO = (Build.VERSION.SDK_INT < 18);
    private static final Paint oP = null;
    private final TextPaint iW;
    private boolean oQ;
    float oR;
    private final Rect oS;
    private final Rect oT;
    private final RectF oU;
    int oV = 16;
    int oW = 16;
    float oX = 15.0f;
    private float oY = 15.0f;
    private ColorStateList oZ;
    private float pA;
    private int pB;
    private float pC;
    private float pD;
    private float pE;
    private int pF;
    ColorStateList pa;
    private float pb;
    private float pc;
    private float pd;
    private float pe;
    private float pg;
    private float ph;
    Typeface pi;
    Typeface pj;
    private Typeface pk;
    private CharSequence pl;
    private boolean pm;
    private boolean pn;
    private Bitmap po;
    private Paint pp;
    private float pq;
    private float pr;
    private float ps;
    private int[] pt;
    private boolean pu;
    private final TextPaint pv;
    TimeInterpolator pw;
    private TimeInterpolator px;
    private float py;
    private float pz;
    private float scale;
    CharSequence text;
    private final View view;

    public d(View view2) {
        this.view = view2;
        this.iW = new TextPaint(129);
        this.pv = new TextPaint(this.iW);
        this.oT = new Rect();
        this.oS = new Rect();
        this.oU = new RectF();
    }

    public final void a(TimeInterpolator timeInterpolator) {
        this.px = timeInterpolator;
        cp();
    }

    public final void d(ColorStateList colorStateList) {
        if (this.pa != colorStateList) {
            this.pa = colorStateList;
            cp();
        }
    }

    public final void e(ColorStateList colorStateList) {
        if (this.oZ != colorStateList) {
            this.oZ = colorStateList;
            cp();
        }
    }

    public final void c(int i2, int i3, int i4, int i5) {
        if (!a(this.oS, i2, i3, i4, i5)) {
            this.oS.set(i2, i3, i4, i5);
            this.pu = true;
            cj();
        }
    }

    public final void d(int i2, int i3, int i4, int i5) {
        if (!a(this.oT, i2, i3, i4, i5)) {
            this.oT.set(i2, i3, i4, i5);
            this.pu = true;
            cj();
        }
    }

    private float ch() {
        if (this.text == null) {
            return 0.0f;
        }
        a(this.pv);
        return this.pv.measureText(this.text, 0, this.text.length());
    }

    public final float ci() {
        a(this.pv);
        return -this.pv.ascent();
    }

    public final void a(RectF rectF) {
        float ch;
        boolean c2 = c(this.text);
        if (!c2) {
            ch = (float) this.oT.left;
        } else {
            ch = ((float) this.oT.right) - ch();
        }
        rectF.left = ch;
        rectF.top = (float) this.oT.top;
        rectF.right = !c2 ? rectF.left + ch() : (float) this.oT.right;
        rectF.bottom = ((float) this.oT.top) + ci();
    }

    private void a(TextPaint textPaint) {
        textPaint.setTextSize(this.oY);
        textPaint.setTypeface(this.pi);
    }

    private void cj() {
        this.oQ = this.oT.width() > 0 && this.oT.height() > 0 && this.oS.width() > 0 && this.oS.height() > 0;
    }

    public final void M(int i2) {
        if (this.oV != i2) {
            this.oV = i2;
            cp();
        }
    }

    public final void N(int i2) {
        if (this.oW != i2) {
            this.oW = i2;
            cp();
        }
    }

    public final void O(int i2) {
        az a2 = az.a(this.view.getContext(), i2, a.C0040a.TextAppearance);
        if (a2.hasValue(3)) {
            this.pa = a2.getColorStateList(3);
        }
        if (a2.hasValue(0)) {
            this.oY = (float) a2.getDimensionPixelSize(0, (int) this.oY);
        }
        this.pB = a2.getInt(6, 0);
        this.pz = a2.getFloat(7, 0.0f);
        this.pA = a2.getFloat(8, 0.0f);
        this.py = a2.getFloat(9, 0.0f);
        a2.ayy.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.pi = Q(i2);
        }
        cp();
    }

    public final void P(int i2) {
        az a2 = az.a(this.view.getContext(), i2, a.C0040a.TextAppearance);
        if (a2.hasValue(3)) {
            this.oZ = a2.getColorStateList(3);
        }
        if (a2.hasValue(0)) {
            this.oX = (float) a2.getDimensionPixelSize(0, (int) this.oX);
        }
        this.pF = a2.getInt(6, 0);
        this.pD = a2.getFloat(7, 0.0f);
        this.pE = a2.getFloat(8, 0.0f);
        this.pC = a2.getFloat(9, 0.0f);
        a2.ayy.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.pj = Q(i2);
        }
        cp();
    }

    private Typeface Q(int i2) {
        TypedArray obtainStyledAttributes = this.view.getContext().obtainStyledAttributes(i2, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void b(Typeface typeface) {
        this.pj = typeface;
        this.pi = typeface;
        cp();
    }

    public final void k(float f2) {
        float p = android.support.v4.b.a.p(f2, 0.0f, 1.0f);
        if (p != this.oR) {
            this.oR = p;
            ck();
        }
    }

    public final boolean setState(int[] iArr) {
        boolean z;
        this.pt = iArr;
        if ((this.pa == null || !this.pa.isStateful()) && (this.oZ == null || !this.oZ.isStateful())) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        cp();
        return true;
    }

    private void ck() {
        l(this.oR);
    }

    private void l(float f2) {
        m(f2);
        this.pg = a(this.pd, this.pe, f2, this.pw);
        this.ph = a(this.pb, this.pc, f2, this.pw);
        n(a(this.oX, this.oY, f2, this.px));
        if (this.pa != this.oZ) {
            this.iW.setColor(c(cl(), cm(), f2));
        } else {
            this.iW.setColor(cm());
        }
        this.iW.setShadowLayer(a(this.pC, this.py, f2, null), a(this.pD, this.pz, f2, null), a(this.pE, this.pA, f2, null), c(this.pF, this.pB, f2));
        u.X(this.view);
    }

    private int cl() {
        if (this.pt != null) {
            return this.oZ.getColorForState(this.pt, 0);
        }
        return this.oZ.getDefaultColor();
    }

    public final int cm() {
        if (this.pt != null) {
            return this.pa.getColorForState(this.pt, 0);
        }
        return this.pa.getDefaultColor();
    }

    private void cn() {
        int i2;
        int i3 = 1;
        float f2 = 0.0f;
        float f3 = this.ps;
        o(this.oY);
        float measureText = this.pl != null ? this.iW.measureText(this.pl, 0, this.pl.length()) : 0.0f;
        int i4 = this.oW;
        if (this.pm) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(i4, i2);
        switch (absoluteGravity & 112) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                this.pc = ((float) this.oT.top) - this.iW.ascent();
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                this.pc = (float) this.oT.bottom;
                break;
            default:
                this.pc = (((this.iW.descent() - this.iW.ascent()) / 2.0f) - this.iW.descent()) + ((float) this.oT.centerY());
                break;
        }
        switch (absoluteGravity & 8388615) {
            case 1:
                this.pe = ((float) this.oT.centerX()) - (measureText / 2.0f);
                break;
            case 5:
                this.pe = ((float) this.oT.right) - measureText;
                break;
            default:
                this.pe = (float) this.oT.left;
                break;
        }
        o(this.oX);
        if (this.pl != null) {
            f2 = this.iW.measureText(this.pl, 0, this.pl.length());
        }
        int i5 = this.oV;
        if (!this.pm) {
            i3 = 0;
        }
        int absoluteGravity2 = android.support.v4.view.d.getAbsoluteGravity(i5, i3);
        switch (absoluteGravity2 & 112) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                this.pb = ((float) this.oS.top) - this.iW.ascent();
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                this.pb = (float) this.oS.bottom;
                break;
            default:
                this.pb = (((this.iW.descent() - this.iW.ascent()) / 2.0f) - this.iW.descent()) + ((float) this.oS.centerY());
                break;
        }
        switch (absoluteGravity2 & 8388615) {
            case 1:
                this.pd = ((float) this.oS.centerX()) - (f2 / 2.0f);
                break;
            case 5:
                this.pd = ((float) this.oS.right) - f2;
                break;
            default:
                this.pd = (float) this.oS.left;
                break;
        }
        cq();
        n(f3);
    }

    private void m(float f2) {
        this.oU.left = a((float) this.oS.left, (float) this.oT.left, f2, this.pw);
        this.oU.top = a(this.pb, this.pc, f2, this.pw);
        this.oU.right = a((float) this.oS.right, (float) this.oT.right, f2, this.pw);
        this.oU.bottom = a((float) this.oS.bottom, (float) this.oT.bottom, f2, this.pw);
    }

    public final void draw(Canvas canvas) {
        float f2;
        int save = canvas.save();
        if (this.pl != null && this.oQ) {
            float f3 = this.pg;
            float f4 = this.ph;
            boolean z = this.pn && this.po != null;
            if (z) {
                f2 = this.pq * this.scale;
            } else {
                this.iW.ascent();
                f2 = 0.0f;
                this.iW.descent();
            }
            if (z) {
                f4 += f2;
            }
            if (this.scale != 1.0f) {
                canvas.scale(this.scale, this.scale, f3, f4);
            }
            if (z) {
                canvas.drawBitmap(this.po, f3, f4, this.pp);
            } else {
                canvas.drawText(this.pl, 0, this.pl.length(), f3, f4, this.iW);
            }
        }
        canvas.restoreToCount(save);
    }

    private boolean c(CharSequence charSequence) {
        boolean z = true;
        if (u.Z(this.view) != 1) {
            z = false;
        }
        return (z ? e.Ot : e.Os).a(charSequence, charSequence.length());
    }

    private void n(float f2) {
        o(f2);
        this.pn = oO && this.scale != 1.0f;
        if (this.pn) {
            co();
        }
        u.X(this.view);
    }

    private void o(float f2) {
        float f3;
        boolean z;
        boolean z2 = true;
        if (this.text != null) {
            float width = (float) this.oT.width();
            float width2 = (float) this.oS.width();
            if (c(f2, this.oY)) {
                f3 = this.oY;
                this.scale = 1.0f;
                if (this.pk != this.pi) {
                    this.pk = this.pi;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                f3 = this.oX;
                if (this.pk != this.pj) {
                    this.pk = this.pj;
                    z = true;
                } else {
                    z = false;
                }
                if (c(f2, this.oX)) {
                    this.scale = 1.0f;
                } else {
                    this.scale = f2 / this.oX;
                }
                float f4 = this.oY / this.oX;
                width = width2 * f4 > width ? Math.min(width / f4, width2) : width2;
            }
            if (width > 0.0f) {
                if (this.ps != f3 || this.pu || z) {
                    z = true;
                } else {
                    z = false;
                }
                this.ps = f3;
                this.pu = false;
            }
            if (this.pl == null || z) {
                this.iW.setTextSize(this.ps);
                this.iW.setTypeface(this.pk);
                TextPaint textPaint = this.iW;
                if (this.scale == 1.0f) {
                    z2 = false;
                }
                textPaint.setLinearText(z2);
                CharSequence ellipsize = TextUtils.ellipsize(this.text, this.iW, width, TextUtils.TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.pl)) {
                    this.pl = ellipsize;
                    this.pm = c(this.pl);
                }
            }
        }
    }

    private void co() {
        if (this.po == null && !this.oS.isEmpty() && !TextUtils.isEmpty(this.pl)) {
            l(0.0f);
            this.pq = this.iW.ascent();
            this.pr = this.iW.descent();
            int round = Math.round(this.iW.measureText(this.pl, 0, this.pl.length()));
            int round2 = Math.round(this.pr - this.pq);
            if (round > 0 && round2 > 0) {
                this.po = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                new Canvas(this.po).drawText(this.pl, 0, this.pl.length(), 0.0f, ((float) round2) - this.iW.descent(), this.iW);
                if (this.pp == null) {
                    this.pp = new Paint(3);
                }
            }
        }
    }

    public final void cp() {
        if (this.view.getHeight() > 0 && this.view.getWidth() > 0) {
            cn();
            ck();
        }
    }

    public final void setText(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.text)) {
            this.text = charSequence;
            this.pl = null;
            cq();
            cp();
        }
    }

    private void cq() {
        if (this.po != null) {
            this.po.recycle();
            this.po = null;
        }
    }

    private static boolean c(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private static int c(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f3) + (((float) Color.alpha(i3)) * f2)), (int) ((((float) Color.red(i2)) * f3) + (((float) Color.red(i3)) * f2)), (int) ((((float) Color.green(i2)) * f3) + (((float) Color.green(i3)) * f2)), (int) ((f3 * ((float) Color.blue(i2))) + (((float) Color.blue(i3)) * f2)));
    }

    private static float a(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return android.support.design.a.a.lerp(f2, f3, f4);
    }

    private static boolean a(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }
}
