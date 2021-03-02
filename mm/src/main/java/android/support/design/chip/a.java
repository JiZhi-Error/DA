package android.support.design.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.a;
import android.support.design.a.h;
import android.support.design.d.b;
import android.support.v4.content.a.f;
import android.support.v4.graphics.drawable.e;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public final class a extends Drawable implements Drawable.Callback, e {
    private static final int[] iq = {16842910};
    private int alpha = 255;
    final Context context;
    ColorStateList hL;
    private final RectF hO = new RectF();
    boolean iA;
    private Drawable iB;
    ColorStateList iC;
    float iD;
    boolean iE;
    Drawable iF;
    ColorStateList iG;
    float iH;
    CharSequence iI;
    boolean iJ;
    boolean iK;
    Drawable iL;
    h iM;
    h iN;
    float iO;
    float iP;
    float iQ;
    float iR;
    float iS;
    float iT;
    float iU;
    float iV;
    private final TextPaint iW = new TextPaint(1);
    private final Paint iX = new Paint(1);
    private final Paint iY;
    private final Paint.FontMetrics iZ = new Paint.FontMetrics();
    private final f.a im = new f.a() {
        /* class android.support.design.chip.a.AnonymousClass1 */

        @Override // android.support.v4.content.a.f.a
        public final void a(Typeface typeface) {
            a.this.jp = true;
            a.this.bl();
            a.this.invalidateSelf();
        }

        @Override // android.support.v4.content.a.f.a
        public final void D(int i2) {
        }
    };
    ColorStateList ir;
    float is;
    float it;
    ColorStateList iu;
    float iw;
    CharSequence ix;
    private CharSequence iy;
    b iz;
    private final PointF ja = new PointF();
    private int jb;
    private int jc;
    private int jd;
    private int je;
    private boolean jf;
    private int jg;
    private ColorFilter jh;
    private PorterDuffColorFilter ji;
    private ColorStateList jj;
    private PorterDuff.Mode jk = PorterDuff.Mode.SRC_IN;
    private int[] jl;
    private boolean jm;
    private ColorStateList jn;
    private WeakReference<AbstractC0009a> jo = new WeakReference<>(null);
    private boolean jp = true;
    private float jq;
    TextUtils.TruncateAt jr;
    boolean js;
    int maxWidth;

    /* renamed from: android.support.design.chip.a$a  reason: collision with other inner class name */
    public interface AbstractC0009a {
        void bg();
    }

    public static a a(Context context2, AttributeSet attributeSet, int i2) {
        b bVar;
        int resourceId;
        a aVar = new a(context2);
        TypedArray a2 = android.support.design.internal.f.a(aVar.context, attributeSet, a.C0008a.Chip, i2, R.style.a4e, new int[0]);
        aVar.setChipBackgroundColor(android.support.design.d.a.b(aVar.context, a2, 8));
        aVar.setChipMinHeight(a2.getDimension(16, 0.0f));
        aVar.setChipCornerRadius(a2.getDimension(9, 0.0f));
        aVar.setChipStrokeColor(android.support.design.d.a.b(aVar.context, a2, 18));
        aVar.setChipStrokeWidth(a2.getDimension(19, 0.0f));
        aVar.setRippleColor(android.support.design.d.a.b(aVar.context, a2, 30));
        aVar.setText(a2.getText(3));
        Context context3 = aVar.context;
        if (!a2.hasValue(0) || (resourceId = a2.getResourceId(0, 0)) == 0) {
            bVar = null;
        } else {
            bVar = new b(context3, resourceId);
        }
        aVar.setTextAppearance(bVar);
        switch (a2.getInt(1, 0)) {
            case 1:
                aVar.jr = TextUtils.TruncateAt.START;
                break;
            case 2:
                aVar.jr = TextUtils.TruncateAt.MIDDLE;
                break;
            case 3:
                aVar.jr = TextUtils.TruncateAt.END;
                break;
        }
        aVar.setChipIconVisible(a2.getBoolean(15, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") != null)) {
            aVar.setChipIconVisible(a2.getBoolean(12, false));
        }
        aVar.setChipIcon(android.support.design.d.a.c(aVar.context, a2, 11));
        aVar.setChipIconTint(android.support.design.d.a.b(aVar.context, a2, 14));
        aVar.setChipIconSize(a2.getDimension(13, 0.0f));
        aVar.setCloseIconVisible(a2.getBoolean(26, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null)) {
            aVar.setCloseIconVisible(a2.getBoolean(21, false));
        }
        aVar.setCloseIcon(android.support.design.d.a.c(aVar.context, a2, 20));
        aVar.setCloseIconTint(android.support.design.d.a.b(aVar.context, a2, 25));
        aVar.setCloseIconSize(a2.getDimension(23, 0.0f));
        aVar.setCheckable(a2.getBoolean(4, false));
        aVar.setCheckedIconVisible(a2.getBoolean(7, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null)) {
            aVar.setCheckedIconVisible(a2.getBoolean(6, false));
        }
        aVar.setCheckedIcon(android.support.design.d.a.c(aVar.context, a2, 5));
        aVar.iM = h.a(aVar.context, a2, 31);
        aVar.iN = h.a(aVar.context, a2, 27);
        aVar.setChipStartPadding(a2.getDimension(17, 0.0f));
        aVar.setIconStartPadding(a2.getDimension(29, 0.0f));
        aVar.setIconEndPadding(a2.getDimension(28, 0.0f));
        aVar.setTextStartPadding(a2.getDimension(33, 0.0f));
        aVar.setTextEndPadding(a2.getDimension(32, 0.0f));
        aVar.setCloseIconStartPadding(a2.getDimension(24, 0.0f));
        aVar.setCloseIconEndPadding(a2.getDimension(22, 0.0f));
        aVar.setChipEndPadding(a2.getDimension(10, 0.0f));
        aVar.maxWidth = a2.getDimensionPixelSize(2, Integer.MAX_VALUE);
        a2.recycle();
        return aVar;
    }

    private a(Context context2) {
        this.context = context2;
        this.ix = "";
        this.iW.density = context2.getResources().getDisplayMetrics().density;
        this.iY = null;
        if (this.iY != null) {
            this.iY.setStyle(Paint.Style.STROKE);
        }
        setState(iq);
        b(iq);
        this.js = true;
    }

    public final void o(boolean z) {
        if (this.jm != z) {
            this.jm = z;
            bt();
            onStateChange(getState());
        }
    }

    public final void a(AbstractC0009a aVar) {
        this.jo = new WeakReference<>(aVar);
    }

    /* access modifiers changed from: protected */
    public final void bl() {
        AbstractC0009a aVar = this.jo.get();
        if (aVar != null) {
            aVar.bg();
        }
    }

    public final int getIntrinsicWidth() {
        return Math.min(Math.round(this.iO + bp() + this.iR + bq() + this.iS + br() + this.iV), this.maxWidth);
    }

    public final int getIntrinsicHeight() {
        return (int) this.is;
    }

    private boolean bm() {
        return this.iA && this.iB != null;
    }

    private boolean bn() {
        return this.iK && this.iL != null && this.jf;
    }

    private boolean bo() {
        return this.iE && this.iF != null;
    }

    /* access modifiers changed from: package-private */
    public final float bp() {
        if (bm() || bn()) {
            return this.iP + this.iD + this.iQ;
        }
        return 0.0f;
    }

    private float bq() {
        if (!this.jp) {
            return this.jq;
        }
        this.jq = b(this.iy);
        this.jp = false;
        return this.jq;
    }

    private float b(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.iW.measureText(charSequence, 0, charSequence.length());
    }

    private float br() {
        if (bo()) {
            return this.iT + this.iH + this.iU;
        }
        return 0.0f;
    }

    public final void draw(Canvas canvas) {
        int i2;
        int i3;
        int saveLayerAlpha;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            if (this.alpha < 255) {
                float f2 = (float) bounds.left;
                float f3 = (float) bounds.top;
                float f4 = (float) bounds.right;
                float f5 = (float) bounds.bottom;
                int i4 = this.alpha;
                if (Build.VERSION.SDK_INT > 21) {
                    saveLayerAlpha = canvas.saveLayerAlpha(f2, f3, f4, f5, i4);
                } else {
                    saveLayerAlpha = canvas.saveLayerAlpha(f2, f3, f4, f5, i4, 31);
                }
                i2 = saveLayerAlpha;
            } else {
                i2 = 0;
            }
            this.iX.setColor(this.jb);
            this.iX.setStyle(Paint.Style.FILL);
            this.iX.setColorFilter(bs());
            this.hO.set(bounds);
            canvas.drawRoundRect(this.hO, this.it, this.it, this.iX);
            if (this.iw > 0.0f) {
                this.iX.setColor(this.jc);
                this.iX.setStyle(Paint.Style.STROKE);
                this.iX.setColorFilter(bs());
                this.hO.set(((float) bounds.left) + (this.iw / 2.0f), ((float) bounds.top) + (this.iw / 2.0f), ((float) bounds.right) - (this.iw / 2.0f), ((float) bounds.bottom) - (this.iw / 2.0f));
                float f6 = this.it - (this.iw / 2.0f);
                canvas.drawRoundRect(this.hO, f6, f6, this.iX);
            }
            this.iX.setColor(this.jd);
            this.iX.setStyle(Paint.Style.FILL);
            this.hO.set(bounds);
            canvas.drawRoundRect(this.hO, this.it, this.it, this.iX);
            if (bm()) {
                a(bounds, this.hO);
                float f7 = this.hO.left;
                float f8 = this.hO.top;
                canvas.translate(f7, f8);
                this.iB.setBounds(0, 0, (int) this.hO.width(), (int) this.hO.height());
                this.iB.draw(canvas);
                canvas.translate(-f7, -f8);
            }
            if (bn()) {
                a(bounds, this.hO);
                float f9 = this.hO.left;
                float f10 = this.hO.top;
                canvas.translate(f9, f10);
                this.iL.setBounds(0, 0, (int) this.hO.width(), (int) this.hO.height());
                this.iL.draw(canvas);
                canvas.translate(-f9, -f10);
            }
            if (this.js && this.iy != null) {
                PointF pointF = this.ja;
                pointF.set(0.0f, 0.0f);
                Paint.Align align = Paint.Align.LEFT;
                if (this.iy != null) {
                    float bp = this.iO + bp() + this.iR;
                    if (android.support.v4.graphics.drawable.a.k(this) == 0) {
                        pointF.x = bp + ((float) bounds.left);
                        align = Paint.Align.LEFT;
                    } else {
                        pointF.x = ((float) bounds.right) - bp;
                        align = Paint.Align.RIGHT;
                    }
                    this.iW.getFontMetrics(this.iZ);
                    pointF.y = ((float) bounds.centerY()) - ((this.iZ.descent + this.iZ.ascent) / 2.0f);
                }
                RectF rectF = this.hO;
                rectF.setEmpty();
                if (this.iy != null) {
                    float bp2 = this.iO + bp() + this.iR;
                    float br = this.iV + br() + this.iS;
                    if (android.support.v4.graphics.drawable.a.k(this) == 0) {
                        rectF.left = bp2 + ((float) bounds.left);
                        rectF.right = ((float) bounds.right) - br;
                    } else {
                        rectF.left = br + ((float) bounds.left);
                        rectF.right = ((float) bounds.right) - bp2;
                    }
                    rectF.top = (float) bounds.top;
                    rectF.bottom = (float) bounds.bottom;
                }
                if (this.iz != null) {
                    this.iW.drawableState = getState();
                    this.iz.b(this.context, this.iW, this.im);
                }
                this.iW.setTextAlign(align);
                boolean z = Math.round(bq()) > Math.round(this.hO.width());
                if (z) {
                    int save = canvas.save();
                    canvas.clipRect(this.hO);
                    i3 = save;
                } else {
                    i3 = 0;
                }
                CharSequence charSequence = this.iy;
                if (z && this.jr != null) {
                    charSequence = TextUtils.ellipsize(this.iy, this.iW, this.hO.width(), this.jr);
                }
                canvas.drawText(charSequence, 0, charSequence.length(), this.ja.x, this.ja.y, this.iW);
                if (z) {
                    canvas.restoreToCount(i3);
                }
            }
            if (bo()) {
                b(bounds, this.hO);
                float f11 = this.hO.left;
                float f12 = this.hO.top;
                canvas.translate(f11, f12);
                this.iF.setBounds(0, 0, (int) this.hO.width(), (int) this.hO.height());
                this.iF.draw(canvas);
                canvas.translate(-f11, -f12);
            }
            if (this.iY != null) {
                this.iY.setColor(android.support.v4.graphics.b.x(WebView.NIGHT_MODE_COLOR, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH));
                canvas.drawRect(bounds, this.iY);
                if (bm() || bn()) {
                    a(bounds, this.hO);
                    canvas.drawRect(this.hO, this.iY);
                }
                if (this.iy != null) {
                    canvas.drawLine((float) bounds.left, bounds.exactCenterY(), (float) bounds.right, bounds.exactCenterY(), this.iY);
                }
                if (bo()) {
                    b(bounds, this.hO);
                    canvas.drawRect(this.hO, this.iY);
                }
                this.iY.setColor(android.support.v4.graphics.b.x(-65536, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH));
                RectF rectF2 = this.hO;
                rectF2.set(bounds);
                if (bo()) {
                    float f13 = this.iV + this.iU + this.iH + this.iT + this.iS;
                    if (android.support.v4.graphics.drawable.a.k(this) == 0) {
                        rectF2.right = ((float) bounds.right) - f13;
                    } else {
                        rectF2.left = f13 + ((float) bounds.left);
                    }
                }
                canvas.drawRect(this.hO, this.iY);
                this.iY.setColor(android.support.v4.graphics.b.x(-16711936, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH));
                c(bounds, this.hO);
                canvas.drawRect(this.hO, this.iY);
            }
            if (this.alpha < 255) {
                canvas.restoreToCount(i2);
            }
        }
    }

    private void a(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (bm() || bn()) {
            float f2 = this.iO + this.iP;
            if (android.support.v4.graphics.drawable.a.k(this) == 0) {
                rectF.left = f2 + ((float) rect.left);
                rectF.right = rectF.left + this.iD;
            } else {
                rectF.right = ((float) rect.right) - f2;
                rectF.left = rectF.right - this.iD;
            }
            rectF.top = rect.exactCenterY() - (this.iD / 2.0f);
            rectF.bottom = rectF.top + this.iD;
        }
    }

    private void b(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (bo()) {
            float f2 = this.iV + this.iU;
            if (android.support.v4.graphics.drawable.a.k(this) == 0) {
                rectF.right = ((float) rect.right) - f2;
                rectF.left = rectF.right - this.iH;
            } else {
                rectF.left = f2 + ((float) rect.left);
                rectF.right = rectF.left + this.iH;
            }
            rectF.top = rect.exactCenterY() - (this.iH / 2.0f);
            rectF.bottom = rectF.top + this.iH;
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (bo()) {
            float f2 = this.iV + this.iU + this.iH + this.iT + this.iS;
            if (android.support.v4.graphics.drawable.a.k(this) == 0) {
                rectF.right = (float) rect.right;
                rectF.left = rectF.right - f2;
            } else {
                rectF.left = (float) rect.left;
                rectF.right = f2 + ((float) rect.left);
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    public final boolean isStateful() {
        boolean z;
        boolean z2;
        if (!a(this.ir) && !a(this.iu) && (!this.jm || !a(this.jn))) {
            b bVar = this.iz;
            if (bVar == null || bVar.ld == null || !bVar.ld.isStateful()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (!this.iK || this.iL == null || !this.iJ) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2 && !b(this.iB) && !b(this.iL) && !a(this.jj)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean b(int[] iArr) {
        if (!Arrays.equals(this.jl, iArr)) {
            this.jl = iArr;
            if (bo()) {
                return b(getState(), iArr);
            }
        }
        return false;
    }

    private boolean b(int[] iArr, int[] iArr2) {
        boolean z;
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        int i4 = 0;
        boolean z4 = true;
        boolean onStateChange = super.onStateChange(iArr);
        int colorForState = this.ir != null ? this.ir.getColorForState(iArr, this.jb) : 0;
        if (this.jb != colorForState) {
            this.jb = colorForState;
            z = true;
        } else {
            z = onStateChange;
        }
        if (this.iu != null) {
            i2 = this.iu.getColorForState(iArr, this.jc);
        } else {
            i2 = 0;
        }
        if (this.jc != i2) {
            this.jc = i2;
            z = true;
        }
        if (this.jn != null) {
            i3 = this.jn.getColorForState(iArr, this.jd);
        } else {
            i3 = 0;
        }
        if (this.jd != i3) {
            this.jd = i3;
            if (this.jm) {
                z = true;
            }
        }
        int colorForState2 = (this.iz == null || this.iz.ld == null) ? 0 : this.iz.ld.getColorForState(iArr, this.je);
        if (this.je != colorForState2) {
            this.je = colorForState2;
            z = true;
        }
        if (!c(getState()) || !this.iJ) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (this.jf == z2 || this.iL == null) {
            z3 = false;
        } else {
            float bp = bp();
            this.jf = z2;
            if (bp != bp()) {
                z3 = true;
                z = true;
            } else {
                z3 = false;
                z = true;
            }
        }
        if (this.jj != null) {
            i4 = this.jj.getColorForState(iArr, this.jg);
        }
        if (this.jg != i4) {
            this.jg = i4;
            this.ji = android.support.design.b.a.a(this, this.jj, this.jk);
        } else {
            z4 = z;
        }
        if (b(this.iB)) {
            z4 |= this.iB.setState(iArr);
        }
        if (b(this.iL)) {
            z4 |= this.iL.setState(iArr);
        }
        if (b(this.iF)) {
            z4 |= this.iF.setState(iArr2);
        }
        if (z4) {
            invalidateSelf();
        }
        if (z3) {
            bl();
        }
        return z4;
    }

    private static boolean a(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    static boolean b(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    @TargetApi(23)
    public final boolean onLayoutDirectionChanged(int i2) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (bm()) {
            onLayoutDirectionChanged |= this.iB.setLayoutDirection(i2);
        }
        if (bn()) {
            onLayoutDirectionChanged |= this.iL.setLayoutDirection(i2);
        }
        if (bo()) {
            onLayoutDirectionChanged |= this.iF.setLayoutDirection(i2);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean onLevelChange(int i2) {
        boolean onLevelChange = super.onLevelChange(i2);
        if (bm()) {
            onLevelChange |= this.iB.setLevel(i2);
        }
        if (bn()) {
            onLevelChange |= this.iL.setLevel(i2);
        }
        if (bo()) {
            onLevelChange |= this.iF.setLevel(i2);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (bm()) {
            visible |= this.iB.setVisible(z, z2);
        }
        if (bn()) {
            visible |= this.iL.setVisible(z, z2);
        }
        if (bo()) {
            visible |= this.iF.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void setAlpha(int i2) {
        if (this.alpha != i2) {
            this.alpha = i2;
            invalidateSelf();
        }
    }

    public final int getAlpha() {
        return this.alpha;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.jh != colorFilter) {
            this.jh = colorFilter;
            invalidateSelf();
        }
    }

    public final ColorFilter getColorFilter() {
        return this.jh;
    }

    @Override // android.support.v4.graphics.drawable.e
    public final void setTintList(ColorStateList colorStateList) {
        if (this.jj != colorStateList) {
            this.jj = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.support.v4.graphics.drawable.e
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.jk != mode) {
            this.jk = mode;
            this.ji = android.support.design.b.a.a(this, this.jj, mode);
            invalidateSelf();
        }
    }

    public final int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public final void getOutline(Outline outline) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.it);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.it);
        }
        outline.setAlpha(((float) getAlpha()) / 255.0f);
    }

    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    private static void c(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void d(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            android.support.v4.graphics.drawable.a.b(drawable, android.support.v4.graphics.drawable.a.k(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.iF) {
                if (drawable.isStateful()) {
                    drawable.setState(this.jl);
                }
                android.support.v4.graphics.drawable.a.a(drawable, this.iG);
            } else if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    private ColorFilter bs() {
        return this.jh != null ? this.jh : this.ji;
    }

    private void bt() {
        this.jn = this.jm ? android.support.design.e.a.b(this.hL) : null;
    }

    private static boolean c(int[] iArr) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == 16842912) {
                return true;
            }
        }
        return false;
    }

    public final void setChipBackgroundColor(ColorStateList colorStateList) {
        if (this.ir != colorStateList) {
            this.ir = colorStateList;
            onStateChange(getState());
        }
    }

    public final void setChipMinHeight(float f2) {
        if (this.is != f2) {
            this.is = f2;
            invalidateSelf();
            bl();
        }
    }

    public final void setChipCornerRadius(float f2) {
        if (this.it != f2) {
            this.it = f2;
            invalidateSelf();
        }
    }

    public final void setChipStrokeColor(ColorStateList colorStateList) {
        if (this.iu != colorStateList) {
            this.iu = colorStateList;
            onStateChange(getState());
        }
    }

    public final void setChipStrokeWidth(float f2) {
        if (this.iw != f2) {
            this.iw = f2;
            this.iX.setStrokeWidth(f2);
            invalidateSelf();
        }
    }

    public final void setRippleColor(ColorStateList colorStateList) {
        if (this.hL != colorStateList) {
            this.hL = colorStateList;
            bt();
            onStateChange(getState());
        }
    }

    public final void setText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (this.ix != charSequence) {
            this.ix = charSequence;
            this.iy = android.support.v4.d.a.fg().unicodeWrap(charSequence);
            this.jp = true;
            invalidateSelf();
            bl();
        }
    }

    public final void setTextAppearanceResource(int i2) {
        setTextAppearance(new b(this.context, i2));
    }

    public final void setTextAppearance(b bVar) {
        if (this.iz != bVar) {
            this.iz = bVar;
            if (bVar != null) {
                bVar.c(this.context, this.iW, this.im);
                this.jp = true;
            }
            onStateChange(getState());
            bl();
        }
    }

    public final void setChipIconVisible(boolean z) {
        if (this.iA != z) {
            boolean bm = bm();
            this.iA = z;
            boolean bm2 = bm();
            if (bm != bm2) {
                if (bm2) {
                    d(this.iB);
                } else {
                    c(this.iB);
                }
                invalidateSelf();
                bl();
            }
        }
    }

    public final Drawable getChipIcon() {
        if (this.iB != null) {
            return android.support.v4.graphics.drawable.a.j(this.iB);
        }
        return null;
    }

    public final void setChipIcon(Drawable drawable) {
        Drawable chipIcon = getChipIcon();
        if (chipIcon != drawable) {
            float bp = bp();
            this.iB = drawable != null ? android.support.v4.graphics.drawable.a.i(drawable).mutate() : null;
            float bp2 = bp();
            c(chipIcon);
            if (bm()) {
                d(this.iB);
            }
            invalidateSelf();
            if (bp != bp2) {
                bl();
            }
        }
    }

    public final void setChipIconTint(ColorStateList colorStateList) {
        if (this.iC != colorStateList) {
            this.iC = colorStateList;
            if (bm()) {
                android.support.v4.graphics.drawable.a.a(this.iB, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void setChipIconSize(float f2) {
        if (this.iD != f2) {
            float bp = bp();
            this.iD = f2;
            float bp2 = bp();
            invalidateSelf();
            if (bp != bp2) {
                bl();
            }
        }
    }

    public final void setCloseIconVisible(boolean z) {
        if (this.iE != z) {
            boolean bo = bo();
            this.iE = z;
            boolean bo2 = bo();
            if (bo != bo2) {
                if (bo2) {
                    d(this.iF);
                } else {
                    c(this.iF);
                }
                invalidateSelf();
                bl();
            }
        }
    }

    public final Drawable getCloseIcon() {
        if (this.iF != null) {
            return android.support.v4.graphics.drawable.a.j(this.iF);
        }
        return null;
    }

    public final void setCloseIcon(Drawable drawable) {
        Drawable closeIcon = getCloseIcon();
        if (closeIcon != drawable) {
            float br = br();
            this.iF = drawable != null ? android.support.v4.graphics.drawable.a.i(drawable).mutate() : null;
            float br2 = br();
            c(closeIcon);
            if (bo()) {
                d(this.iF);
            }
            invalidateSelf();
            if (br != br2) {
                bl();
            }
        }
    }

    public final void setCloseIconTint(ColorStateList colorStateList) {
        if (this.iG != colorStateList) {
            this.iG = colorStateList;
            if (bo()) {
                android.support.v4.graphics.drawable.a.a(this.iF, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void setCloseIconSize(float f2) {
        if (this.iH != f2) {
            this.iH = f2;
            invalidateSelf();
            if (bo()) {
                bl();
            }
        }
    }

    public final void setCheckable(boolean z) {
        if (this.iJ != z) {
            this.iJ = z;
            float bp = bp();
            if (!z && this.jf) {
                this.jf = false;
            }
            float bp2 = bp();
            invalidateSelf();
            if (bp != bp2) {
                bl();
            }
        }
    }

    public final void setCheckedIconVisible(boolean z) {
        if (this.iK != z) {
            boolean bn = bn();
            this.iK = z;
            boolean bn2 = bn();
            if (bn != bn2) {
                if (bn2) {
                    d(this.iL);
                } else {
                    c(this.iL);
                }
                invalidateSelf();
                bl();
            }
        }
    }

    public final void setCheckedIcon(Drawable drawable) {
        if (this.iL != drawable) {
            float bp = bp();
            this.iL = drawable;
            float bp2 = bp();
            c(this.iL);
            d(this.iL);
            invalidateSelf();
            if (bp != bp2) {
                bl();
            }
        }
    }

    public final void setChipStartPadding(float f2) {
        if (this.iO != f2) {
            this.iO = f2;
            invalidateSelf();
            bl();
        }
    }

    public final void setIconStartPadding(float f2) {
        if (this.iP != f2) {
            float bp = bp();
            this.iP = f2;
            float bp2 = bp();
            invalidateSelf();
            if (bp != bp2) {
                bl();
            }
        }
    }

    public final void setIconEndPadding(float f2) {
        if (this.iQ != f2) {
            float bp = bp();
            this.iQ = f2;
            float bp2 = bp();
            invalidateSelf();
            if (bp != bp2) {
                bl();
            }
        }
    }

    public final void setTextStartPadding(float f2) {
        if (this.iR != f2) {
            this.iR = f2;
            invalidateSelf();
            bl();
        }
    }

    public final void setTextEndPadding(float f2) {
        if (this.iS != f2) {
            this.iS = f2;
            invalidateSelf();
            bl();
        }
    }

    public final void setCloseIconStartPadding(float f2) {
        if (this.iT != f2) {
            this.iT = f2;
            invalidateSelf();
            if (bo()) {
                bl();
            }
        }
    }

    public final void setCloseIconEndPadding(float f2) {
        if (this.iU != f2) {
            this.iU = f2;
            invalidateSelf();
            if (bo()) {
                bl();
            }
        }
    }

    public final void setChipEndPadding(float f2) {
        if (this.iV != f2) {
            this.iV = f2;
            invalidateSelf();
            bl();
        }
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        return b(iArr, this.jl);
    }
}
