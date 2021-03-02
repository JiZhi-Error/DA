package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.BoringLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.KeyListener;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

@SuppressLint({"ResourceAsColor"})
public class NoMeasuredTextView extends View {
    private static final BoringLayout.Metrics OVU = new BoringLayout.Metrics();
    private ColorStateList BpJ;
    private int Ku = 51;
    private String OOd;
    private int OOe;
    private int OOf;
    private boolean OSP;
    private boolean OVA = false;
    private boolean OVB = false;
    private int OVC = -1;
    private boolean OVD = true;
    private BoringLayout OVE;
    private boolean OVF = false;
    private int OVG;
    private Paint.FontMetricsInt OVH;
    private boolean OVI = false;
    private boolean OVJ = false;
    private b OVK;
    private boolean OVL = false;
    public boolean OVM = false;
    private boolean OVN = false;
    private boolean OVO = false;
    private int OVP = -1;
    private int OVQ = -1;
    private int OVR = -1;
    private int OVS = -1;
    private c OVT;
    private int OVm;
    private Editable.Factory OVn = Editable.Factory.getInstance();
    private Spannable.Factory OVo = Spannable.Factory.getInstance();
    private TextUtils.TruncateAt OVp = null;
    private CharSequence OVq = "";
    private a OVr = a.NORMAL;
    private KeyListener OVs;
    private Layout OVt;
    private float OVu = 1.0f;
    private float OVv = 0.0f;
    private int OVw = Integer.MAX_VALUE;
    private int OVx = 1;
    private int OVy = 0;
    private int OVz = 1;
    private TextPaint ayn = new TextPaint(1);
    private int mMaxWidth = Integer.MAX_VALUE;
    private int mMinWidth = 0;
    private CharSequence mText = "";

    public interface c {
        CharSequence a(NoMeasuredTextView noMeasuredTextView, CharSequence charSequence, String str, int i2, int i3);
    }

    /* access modifiers changed from: package-private */
    public class b {
        final Rect OVZ = new Rect();
        Drawable OWa;
        Drawable OWb;
        Drawable OWc;
        Drawable OWd;
        int OWe;
        int OWf;
        int OWg;
        int OWh;
        int OWi;
        int OWj;
        int OWk;
        int OWl;
        int OWm;

        b() {
            AppMethodBeat.i(142371);
            AppMethodBeat.o(142371);
        }
    }

    public void setDrawLeftDrawable(boolean z) {
        AppMethodBeat.i(142372);
        if (this.OVL != z) {
            invalidate();
        }
        this.OVL = z;
        AppMethodBeat.o(142372);
    }

    public void setDrawRightDrawable(boolean z) {
        AppMethodBeat.i(142373);
        if (this.OVM != z) {
            invalidate();
        }
        this.OVM = z;
        AppMethodBeat.o(142373);
    }

    public void setDrawTopDrawable(boolean z) {
        AppMethodBeat.i(142374);
        if (this.OVN != z) {
            invalidate();
        }
        this.OVN = z;
        AppMethodBeat.o(142374);
    }

    public void setDrawDownDrawable(boolean z) {
        AppMethodBeat.i(142375);
        if (this.OVO != z) {
            invalidate();
        }
        this.OVO = z;
        AppMethodBeat.o(142375);
    }

    static {
        AppMethodBeat.i(142448);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.measureText("H");
        AppMethodBeat.o(142448);
    }

    public void setShouldEllipsize(boolean z) {
        this.OVJ = z;
    }

    public NoMeasuredTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142376);
        this.ayn.density = getResources().getDisplayMetrics().density;
        setDrawingCacheEnabled(false);
        this.OVH = this.ayn.getFontMetricsInt();
        gLt();
        setSingleLine(true);
        setEllipsize(null);
        AppMethodBeat.o(142376);
    }

    /* access modifiers changed from: protected */
    public boolean getDefaultEditable() {
        return false;
    }

    /* access modifiers changed from: protected */
    public MovementMethod getDefaultMovementMethod() {
        return null;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getText() {
        return this.mText;
    }

    public Editable getEditableText() {
        if (this.mText instanceof Editable) {
            return (Editable) this.mText;
        }
        return null;
    }

    public int getLineHeight() {
        AppMethodBeat.i(142377);
        int round = Math.round((((float) this.ayn.getFontMetricsInt(null)) * this.OVu) + this.OVv);
        AppMethodBeat.o(142377);
        return round;
    }

    public final Layout getLayout() {
        return this.OVt;
    }

    private void a(Drawable drawable, Drawable drawable2) {
        AppMethodBeat.i(142378);
        b bVar = this.OVK;
        if ((drawable == null && drawable2 == null) ? false : true) {
            if (bVar == null) {
                bVar = new b();
                this.OVK = bVar;
            }
            if (!(bVar.OWc == drawable || bVar.OWc == null)) {
                bVar.OWc.setCallback(null);
            }
            bVar.OWc = drawable;
            if (!(bVar.OWa == null || bVar.OWa == null)) {
                bVar.OWa.setCallback(null);
            }
            bVar.OWa = null;
            if (!(bVar.OWd == drawable2 || bVar.OWd == null)) {
                bVar.OWd.setCallback(null);
            }
            bVar.OWd = drawable2;
            if (!(bVar.OWb == null || bVar.OWb == null)) {
                bVar.OWb.setCallback(null);
            }
            bVar.OWb = null;
            Rect rect = bVar.OVZ;
            int[] drawableState = getDrawableState();
            if (drawable != null) {
                drawable.setState(drawableState);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                bVar.OWg = rect.width();
                bVar.OWk = rect.height();
            } else {
                bVar.OWk = 0;
                bVar.OWg = 0;
            }
            if (drawable2 != null) {
                drawable2.setState(drawableState);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                bVar.OWh = rect.width();
                bVar.OWl = rect.height();
                bVar.OWi = 0;
                bVar.OWe = 0;
                bVar.OWj = 0;
                bVar.OWf = 0;
            }
            bVar.OWl = 0;
            bVar.OWh = 0;
            bVar.OWi = 0;
            bVar.OWe = 0;
            bVar.OWj = 0;
            bVar.OWf = 0;
        } else if (bVar != null) {
            if (bVar.OWm == 0) {
                this.OVK = null;
            } else {
                if (bVar.OWc != null) {
                    bVar.OWc.setCallback(null);
                }
                bVar.OWc = null;
                if (bVar.OWa != null) {
                    bVar.OWa.setCallback(null);
                }
                bVar.OWa = null;
                if (bVar.OWd != null) {
                    bVar.OWd.setCallback(null);
                }
                bVar.OWd = null;
                if (bVar.OWb != null) {
                    bVar.OWb.setCallback(null);
                }
                bVar.OWb = null;
                bVar.OWk = 0;
                bVar.OWg = 0;
                bVar.OWl = 0;
                bVar.OWh = 0;
                bVar.OWi = 0;
                bVar.OWe = 0;
                bVar.OWj = 0;
                bVar.OWf = 0;
            }
        }
        invalidate();
        AppMethodBeat.o(142378);
    }

    public void setCompoundLeftDrawablesWithIntrinsicBounds(Drawable drawable) {
        AppMethodBeat.i(142379);
        if (drawable == null) {
            AppMethodBeat.o(142379);
        } else if (this.OVK == null || this.OVK.OWc != drawable) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            a(drawable, (Drawable) null);
            AppMethodBeat.o(142379);
        } else {
            AppMethodBeat.o(142379);
        }
    }

    public void setCompoundRightDrawablesWithIntrinsicBounds(Drawable drawable) {
        AppMethodBeat.i(142380);
        if (drawable == null) {
            AppMethodBeat.o(142380);
        } else if (this.OVK == null || this.OVK.OWd != drawable) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            a((Drawable) null, drawable);
            AppMethodBeat.o(142380);
        } else {
            AppMethodBeat.o(142380);
        }
    }

    public void setCompoundLeftDrawablesWithIntrinsicBounds(int i2) {
        AppMethodBeat.i(142381);
        if (i2 != this.OVP) {
            this.OVP = i2;
            setCompoundLeftDrawablesWithIntrinsicBounds(getResources().getDrawable(i2));
        }
        AppMethodBeat.o(142381);
    }

    public void setCompoundRightDrawablesWithIntrinsicBounds(int i2) {
        AppMethodBeat.i(142382);
        if (i2 != this.OVQ) {
            this.OVQ = i2;
            setCompoundRightDrawablesWithIntrinsicBounds(getResources().getDrawable(i2));
        }
        AppMethodBeat.o(142382);
    }

    public Drawable[] getCompoundDrawables() {
        b bVar = this.OVK;
        if (bVar != null) {
            return new Drawable[]{bVar.OWc, bVar.OWa, bVar.OWd, bVar.OWb};
        }
        return new Drawable[]{null, null, null, null};
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        AppMethodBeat.i(142383);
        super.drawableStateChanged();
        if (this.BpJ != null && this.BpJ.isStateful()) {
            updateTextColors();
        }
        b bVar = this.OVK;
        if (bVar != null) {
            int[] drawableState = getDrawableState();
            if (bVar.OWa != null && bVar.OWa.isStateful()) {
                bVar.OWa.setState(drawableState);
            }
            if (bVar.OWb != null && bVar.OWb.isStateful()) {
                bVar.OWb.setState(drawableState);
            }
            if (bVar.OWc != null && bVar.OWc.isStateful()) {
                bVar.OWc.setState(drawableState);
            }
            if (bVar.OWd != null && bVar.OWd.isStateful()) {
                bVar.OWd.setState(drawableState);
            }
        }
        AppMethodBeat.o(142383);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        AppMethodBeat.i(142384);
        boolean verifyDrawable = super.verifyDrawable(drawable);
        if (verifyDrawable || this.OVK == null) {
            AppMethodBeat.o(142384);
            return verifyDrawable;
        } else if (drawable == this.OVK.OWc || drawable == this.OVK.OWa || drawable == this.OVK.OWd || drawable == this.OVK.OWb) {
            AppMethodBeat.o(142384);
            return true;
        } else {
            AppMethodBeat.o(142384);
            return false;
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        AppMethodBeat.i(142385);
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            b bVar = this.OVK;
            if (bVar != null) {
                if (drawable == bVar.OWc) {
                    int compoundPaddingTop = getCompoundPaddingTop();
                    int compoundPaddingBottom = getCompoundPaddingBottom();
                    scrollX += getPaddingLeft();
                    scrollY += (((((getBottom() - getTop()) - compoundPaddingBottom) - compoundPaddingTop) - bVar.OWk) / 2) + compoundPaddingTop;
                } else if (drawable == bVar.OWd) {
                    int compoundPaddingTop2 = getCompoundPaddingTop();
                    int compoundPaddingBottom2 = getCompoundPaddingBottom();
                    scrollX += ((getRight() - getLeft()) - getPaddingRight()) - bVar.OWh;
                    scrollY += (((((getBottom() - getTop()) - compoundPaddingBottom2) - compoundPaddingTop2) - bVar.OWl) / 2) + compoundPaddingTop2;
                } else if (drawable == bVar.OWa) {
                    int compoundPaddingLeft = getCompoundPaddingLeft();
                    scrollX += (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingLeft) - bVar.OWi) / 2) + compoundPaddingLeft;
                    scrollY += getPaddingTop();
                } else if (drawable == bVar.OWb) {
                    int compoundPaddingLeft2 = getCompoundPaddingLeft();
                    scrollX += compoundPaddingLeft2 + (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingLeft2) - bVar.OWj) / 2);
                    scrollY += ((getBottom() - getTop()) - getPaddingBottom()) - bVar.OWf;
                }
            }
            invalidate(bounds.left + scrollX, bounds.top + scrollY, scrollX + bounds.right, scrollY + bounds.bottom);
        }
        AppMethodBeat.o(142385);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        if (r0 != null) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCompoundDrawablePadding(int r3) {
        /*
            r2 = this;
            r1 = 142386(0x22c32, float:1.99525E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            com.tencent.mm.ui.base.NoMeasuredTextView$b r0 = r2.OVK
            if (r3 != 0) goto L_0x0018
            if (r0 == 0) goto L_0x000e
        L_0x000c:
            r0.OWm = r3
        L_0x000e:
            r2.invalidate()
            r2.requestLayout()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        L_0x0018:
            if (r0 != 0) goto L_0x000c
            com.tencent.mm.ui.base.NoMeasuredTextView$b r0 = new com.tencent.mm.ui.base.NoMeasuredTextView$b
            r0.<init>()
            r2.OVK = r0
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.base.NoMeasuredTextView.setCompoundDrawablePadding(int):void");
    }

    public int getCompoundDrawablePadding() {
        b bVar = this.OVK;
        if (bVar != null) {
            return bVar.OWm;
        }
        return 0;
    }

    public int getCompoundPaddingTop() {
        AppMethodBeat.i(142387);
        b bVar = this.OVK;
        if (bVar == null || bVar.OWa == null || !this.OVN) {
            int paddingTop = getPaddingTop();
            AppMethodBeat.o(142387);
            return paddingTop;
        }
        int paddingTop2 = bVar.OWe + getPaddingTop() + bVar.OWm;
        AppMethodBeat.o(142387);
        return paddingTop2;
    }

    public int getCompoundPaddingBottom() {
        AppMethodBeat.i(142388);
        b bVar = this.OVK;
        if (bVar == null || bVar.OWb == null || !this.OVO) {
            int paddingBottom = getPaddingBottom();
            AppMethodBeat.o(142388);
            return paddingBottom;
        }
        int paddingBottom2 = bVar.OWf + getPaddingBottom() + bVar.OWm;
        AppMethodBeat.o(142388);
        return paddingBottom2;
    }

    public int getCompoundPaddingLeft() {
        AppMethodBeat.i(142389);
        b bVar = this.OVK;
        if (bVar == null || bVar.OWc == null || !this.OVL) {
            int paddingLeft = getPaddingLeft();
            AppMethodBeat.o(142389);
            return paddingLeft;
        }
        int paddingLeft2 = bVar.OWg + getPaddingLeft() + bVar.OWm;
        AppMethodBeat.o(142389);
        return paddingLeft2;
    }

    public int getCompoundPaddingRight() {
        AppMethodBeat.i(142390);
        b bVar = this.OVK;
        if (bVar == null || bVar.OWd == null || !this.OVM) {
            int paddingRight = getPaddingRight();
            AppMethodBeat.o(142390);
            return paddingRight;
        }
        int paddingRight2 = bVar.OWh + getPaddingRight() + bVar.OWm;
        AppMethodBeat.o(142390);
        return paddingRight2;
    }

    public int getExtendedPaddingTop() {
        AppMethodBeat.i(142391);
        if (this.OVt == null || this.OVx != 1) {
            int compoundPaddingTop = getCompoundPaddingTop();
            AppMethodBeat.o(142391);
            return compoundPaddingTop;
        } else if (this.OVt.getLineCount() <= this.OVw) {
            int compoundPaddingTop2 = getCompoundPaddingTop();
            AppMethodBeat.o(142391);
            return compoundPaddingTop2;
        } else {
            int compoundPaddingTop3 = getCompoundPaddingTop();
            int height = (getHeight() - compoundPaddingTop3) - getCompoundPaddingBottom();
            int lineTop = this.OVt.getLineTop(this.OVw);
            if (lineTop >= height) {
                AppMethodBeat.o(142391);
                return compoundPaddingTop3;
            }
            int i2 = this.Ku & 112;
            if (i2 == 48) {
                AppMethodBeat.o(142391);
                return compoundPaddingTop3;
            } else if (i2 == 80) {
                int i3 = (compoundPaddingTop3 + height) - lineTop;
                AppMethodBeat.o(142391);
                return i3;
            } else {
                int i4 = compoundPaddingTop3 + ((height - lineTop) / 2);
                AppMethodBeat.o(142391);
                return i4;
            }
        }
    }

    public int getExtendedPaddingBottom() {
        AppMethodBeat.i(142392);
        if (this.OVt == null || this.OVx != 1) {
            int compoundPaddingBottom = getCompoundPaddingBottom();
            AppMethodBeat.o(142392);
            return compoundPaddingBottom;
        } else if (this.OVt.getLineCount() <= this.OVw) {
            int compoundPaddingBottom2 = getCompoundPaddingBottom();
            AppMethodBeat.o(142392);
            return compoundPaddingBottom2;
        } else {
            int compoundPaddingTop = getCompoundPaddingTop();
            int compoundPaddingBottom3 = getCompoundPaddingBottom();
            int height = (getHeight() - compoundPaddingTop) - compoundPaddingBottom3;
            int lineTop = this.OVt.getLineTop(this.OVw);
            if (lineTop >= height) {
                AppMethodBeat.o(142392);
                return compoundPaddingBottom3;
            }
            int i2 = this.Ku & 112;
            if (i2 == 48) {
                int i3 = (compoundPaddingBottom3 + height) - lineTop;
                AppMethodBeat.o(142392);
                return i3;
            } else if (i2 == 80) {
                AppMethodBeat.o(142392);
                return compoundPaddingBottom3;
            } else {
                int i4 = compoundPaddingBottom3 + ((height - lineTop) / 2);
                AppMethodBeat.o(142392);
                return i4;
            }
        }
    }

    public int getTotalPaddingLeft() {
        AppMethodBeat.i(142393);
        int compoundPaddingLeft = getCompoundPaddingLeft();
        AppMethodBeat.o(142393);
        return compoundPaddingLeft;
    }

    public int getTotalPaddingRight() {
        AppMethodBeat.i(142394);
        int compoundPaddingRight = getCompoundPaddingRight();
        AppMethodBeat.o(142394);
        return compoundPaddingRight;
    }

    public int getTotalPaddingTop() {
        AppMethodBeat.i(142395);
        int extendedPaddingTop = getExtendedPaddingTop() + getVerticalOffset$1385f2();
        AppMethodBeat.o(142395);
        return extendedPaddingTop;
    }

    public int getTotalPaddingBottom() {
        int measuredHeight;
        int height;
        AppMethodBeat.i(258013);
        int extendedPaddingBottom = getExtendedPaddingBottom();
        int i2 = 0;
        int i3 = this.Ku & 112;
        Layout layout = this.OVt;
        if (i3 != 80 && (height = layout.getHeight()) < (measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom())) {
            i2 = i3 == 48 ? measuredHeight - height : (measuredHeight - height) >> 1;
        }
        int i4 = i2 + extendedPaddingBottom;
        AppMethodBeat.o(258013);
        return i4;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(142397);
        if (!(i2 == getPaddingLeft() && i4 == getPaddingRight() && i3 == getPaddingTop() && i5 == getPaddingBottom())) {
            gLr();
        }
        super.setPadding(i2, i3, i4, i5);
        invalidate();
        AppMethodBeat.o(142397);
    }

    public float getTextSize() {
        AppMethodBeat.i(142398);
        float textSize = this.ayn.getTextSize();
        AppMethodBeat.o(142398);
        return textSize;
    }

    public void setTextSize(float f2) {
        AppMethodBeat.i(142399);
        setTextSize(2, f2);
        AppMethodBeat.o(142399);
    }

    public final void setTextSize(int i2, float f2) {
        Resources resources;
        AppMethodBeat.i(142400);
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
        AppMethodBeat.o(142400);
    }

    private void setRawTextSize(float f2) {
        AppMethodBeat.i(142401);
        if (f2 != this.ayn.getTextSize()) {
            this.ayn.setTextSize(f2);
            this.OVH = this.ayn.getFontMetricsInt();
            this.OVG = (int) (Math.ceil((double) (this.OVH.descent - this.OVH.ascent)) + 2.0d);
            if (this.OVt != null) {
                gLr();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(142401);
    }

    public float getTextScaleX() {
        AppMethodBeat.i(142402);
        float textScaleX = this.ayn.getTextScaleX();
        AppMethodBeat.o(142402);
        return textScaleX;
    }

    public void setTypeface(Typeface typeface) {
        AppMethodBeat.i(142403);
        if (this.ayn.getTypeface() != typeface) {
            this.ayn.setTypeface(typeface);
            if (this.OVt != null) {
                gLr();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(142403);
    }

    public Typeface getTypeface() {
        AppMethodBeat.i(142404);
        Typeface typeface = this.ayn.getTypeface();
        AppMethodBeat.o(142404);
        return typeface;
    }

    public void setTextColor(int i2) {
        AppMethodBeat.i(142405);
        this.BpJ = ColorStateList.valueOf(i2);
        updateTextColors();
        AppMethodBeat.o(142405);
    }

    public void setTextColor(ColorStateList colorStateList) {
        AppMethodBeat.i(142406);
        if (colorStateList == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(142406);
            throw nullPointerException;
        } else if (this.BpJ == colorStateList) {
            AppMethodBeat.o(142406);
        } else {
            this.BpJ = colorStateList;
            updateTextColors();
            AppMethodBeat.o(142406);
        }
    }

    public final ColorStateList getTextColors() {
        return this.BpJ;
    }

    public final int getCurrentTextColor() {
        return this.OVm;
    }

    public TextPaint getPaint() {
        return this.ayn;
    }

    public void setGravity(int i2) {
        int i3;
        AppMethodBeat.i(142407);
        if ((i2 & 7) == 0) {
            i3 = i2 | 3;
        } else {
            i3 = i2;
        }
        if ((i3 & 112) == 0) {
            i3 |= 48;
        }
        boolean z = false;
        if ((i3 & 7) != (this.Ku & 7)) {
            z = true;
        }
        if (i3 != this.Ku) {
            invalidate();
        }
        this.Ku = i3;
        if (this.OVt != null && z) {
            kZ(this.OVt.getWidth(), (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight());
        }
        AppMethodBeat.o(142407);
    }

    public int getGravity() {
        return this.Ku;
    }

    public int getPaintFlags() {
        AppMethodBeat.i(142408);
        int flags = this.ayn.getFlags();
        AppMethodBeat.o(142408);
        return flags;
    }

    public void setPaintFlags(int i2) {
        AppMethodBeat.i(142409);
        if (this.ayn.getFlags() != i2) {
            this.ayn.setFlags(i2);
            if (this.OVt != null) {
                gLr();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(142409);
    }

    public void setMinLines(int i2) {
        AppMethodBeat.i(142410);
        this.OVy = i2;
        this.OVz = 1;
        requestLayout();
        invalidate();
        AppMethodBeat.o(142410);
    }

    public void setMinHeight(int i2) {
        AppMethodBeat.i(142411);
        this.OVy = i2;
        this.OVz = 2;
        requestLayout();
        invalidate();
        AppMethodBeat.o(142411);
    }

    public void setMaxLines(int i2) {
        AppMethodBeat.i(142412);
        this.OVw = i2;
        this.OVx = 1;
        requestLayout();
        invalidate();
        AppMethodBeat.o(142412);
    }

    public void setMaxHeight(int i2) {
        AppMethodBeat.i(142413);
        this.OVw = i2;
        this.OVx = 2;
        requestLayout();
        invalidate();
        AppMethodBeat.o(142413);
    }

    public void setLines(int i2) {
        AppMethodBeat.i(142414);
        this.OVy = i2;
        this.OVw = i2;
        this.OVz = 1;
        this.OVx = 1;
        requestLayout();
        invalidate();
        AppMethodBeat.o(142414);
    }

    public void setHeight(int i2) {
        AppMethodBeat.i(142415);
        this.OVy = i2;
        this.OVw = i2;
        this.OVz = 2;
        this.OVx = 2;
        requestLayout();
        invalidate();
        AppMethodBeat.o(142415);
    }

    public void setMinWidth(int i2) {
        AppMethodBeat.i(142416);
        this.mMinWidth = i2;
        this.OVB = true;
        requestLayout();
        invalidate();
        AppMethodBeat.o(142416);
    }

    public void setMaxWidth(int i2) {
        AppMethodBeat.i(142417);
        this.mMaxWidth = i2;
        this.OVA = true;
        requestLayout();
        invalidate();
        AppMethodBeat.o(142417);
    }

    public void setWidth(int i2) {
        AppMethodBeat.i(142418);
        this.mMinWidth = i2;
        this.mMaxWidth = i2;
        this.OVB = true;
        this.OVA = true;
        requestLayout();
        invalidate();
        AppMethodBeat.o(142418);
    }

    private void updateTextColors() {
        boolean z = false;
        AppMethodBeat.i(142419);
        int colorForState = this.BpJ.getColorForState(getDrawableState(), 0);
        if (colorForState != this.OVm) {
            this.OVm = colorForState;
            z = true;
        }
        if (z) {
            invalidate();
        }
        AppMethodBeat.o(142419);
    }

    public final void setEditableFactory(Editable.Factory factory) {
        AppMethodBeat.i(142420);
        this.OVn = factory;
        setText(this.mText);
        AppMethodBeat.o(142420);
    }

    public final void setSpannableFactory(Spannable.Factory factory) {
        AppMethodBeat.i(142421);
        this.OVo = factory;
        setText(this.mText);
        AppMethodBeat.o(142421);
    }

    public final void setText(CharSequence charSequence) {
        AppMethodBeat.i(142422);
        a(charSequence, this.OVr);
        AppMethodBeat.o(142422);
    }

    public final void setTextKeepState(CharSequence charSequence) {
        AppMethodBeat.i(142423);
        a aVar = this.OVr;
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        int length = charSequence.length();
        a(charSequence, aVar);
        if ((selectionStart >= 0 || selectionEnd >= 0) && (this.mText instanceof Spannable)) {
            Selection.setSelection((Spannable) this.mText, Math.max(0, Math.min(selectionStart, length)), Math.max(0, Math.min(selectionEnd, length)));
        }
        AppMethodBeat.o(142423);
    }

    private void a(CharSequence charSequence, a aVar) {
        CharSequence charSequence2;
        AppMethodBeat.i(142424);
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence;
        }
        if (charSequence2.equals(this.mText)) {
            AppMethodBeat.o(142424);
            return;
        }
        if (getMeasuredWidth() > 0 && this.OVT != null && !Util.isNullOrNil(this.OOd)) {
            charSequence2 = this.OVT.a(this, charSequence2, this.OOd, this.OOe, this.OOf);
            this.OOd = null;
        }
        if (charSequence2 instanceof Spanned) {
            this.OVF = false;
        } else {
            this.OVF = true;
        }
        if (aVar == a.EDITABLE || this.OVs != null) {
            charSequence2 = this.OVn.newEditable(charSequence2);
        } else if (aVar == a.SPANNABLE) {
            charSequence2 = this.OVo.newSpannable(charSequence2);
        }
        int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
        if (this.OVJ) {
            if (this.OVA) {
                int i2 = this.mMaxWidth;
                if (getMeasuredWidth() > 0) {
                    i2 = Math.min(this.mMaxWidth, getMeasuredWidth());
                }
                charSequence2 = TextUtils.ellipsize(charSequence2, this.ayn, (float) (i2 - compoundPaddingLeft), TextUtils.TruncateAt.END);
            } else if (getMeasuredWidth() > 0) {
                charSequence2 = TextUtils.ellipsize(charSequence2, this.ayn, (float) (getMeasuredWidth() - compoundPaddingLeft), TextUtils.TruncateAt.END);
            } else {
                this.OVI = true;
            }
        }
        this.OVr = aVar;
        this.mText = charSequence2;
        this.OVq = charSequence2;
        alB(compoundPaddingLeft);
        AppMethodBeat.o(142424);
    }

    public final void aR(String str, int i2, int i3) {
        this.OOd = str;
        this.OOe = i2;
        this.OOf = i3;
    }

    public void setLayoutCallback(c cVar) {
        this.OVT = cVar;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(142425);
        super.onLayout(z, i2, i3, i4, i5);
        if (this.OVI && getMeasuredWidth() > 0) {
            if (Util.isNullOrNil(this.OOd) || this.OVT == null) {
                setText(TextUtils.ellipsize(this.mText, getPaint(), (float) ((getMeasuredWidth() - getCompoundPaddingRight()) - getCompoundPaddingLeft()), TextUtils.TruncateAt.END));
            } else {
                CharSequence a2 = this.OVT.a(this, this.mText, this.OOd, this.OOe, this.OOf);
                this.OOd = null;
                setText(a2);
            }
            this.OVI = false;
        }
        AppMethodBeat.o(142425);
    }

    public final void setText(int i2) {
        AppMethodBeat.i(142426);
        setText(getContext().getResources().getText(i2));
        AppMethodBeat.o(142426);
    }

    private int getVerticalOffset$1385f2() {
        int measuredHeight;
        int height;
        AppMethodBeat.i(142427);
        int i2 = 0;
        int i3 = this.Ku & 112;
        Layout layout = this.OVt;
        if (i3 != 48 && (height = layout.getHeight()) < (measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom())) {
            i2 = i3 == 80 ? measuredHeight - height : (measuredHeight - height) >> 1;
        }
        AppMethodBeat.o(142427);
        return i2;
    }

    private int getBottomVerticalOffset$1385f2() {
        int measuredHeight;
        int height;
        AppMethodBeat.i(259383);
        int i2 = 0;
        int i3 = this.Ku & 112;
        Layout layout = this.OVt;
        if (i3 != 80 && (height = layout.getHeight()) < (measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom())) {
            i2 = i3 == 48 ? measuredHeight - height : (measuredHeight - height) >> 1;
        }
        AppMethodBeat.o(259383);
        return i2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float ceil;
        float f2;
        AppMethodBeat.i(142429);
        super.onDraw(canvas);
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingRight = getCompoundPaddingRight();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int right = getRight();
        int left = getLeft();
        int bottom = getBottom();
        int top = getTop();
        int width = getWidth();
        int height = getHeight();
        b bVar = this.OVK;
        float f3 = -1.0f;
        if (bVar != null) {
            int i2 = ((bottom - top) - compoundPaddingBottom) - compoundPaddingTop;
            int i3 = ((right - left) - compoundPaddingRight) - compoundPaddingLeft;
            if (this.OVL && bVar.OWc != null) {
                canvas.save();
                canvas.translate((float) (getPaddingLeft() + scrollX), (float) (scrollY + compoundPaddingTop + ((i2 - bVar.OWk) / 2)));
                bVar.OWc.draw(canvas);
                canvas.restore();
            }
            if (this.OVM && bVar.OWd != null) {
                canvas.save();
                if (this.OVF) {
                    float measureText = this.ayn.measureText(this.mText, 0, this.mText.length());
                    ceil = measureText;
                    f2 = measureText;
                } else {
                    ceil = (float) Math.ceil((double) Layout.getDesiredWidth(this.OVq, this.ayn));
                    f2 = -1.0f;
                }
                canvas.translate((ceil + ((float) scrollX)) - ((float) getPaddingRight()), (float) (scrollY + compoundPaddingTop + ((i2 - bVar.OWl) / 2)));
                bVar.OWd.draw(canvas);
                canvas.restore();
                f3 = f2;
            }
            if (this.OVN && bVar.OWa != null) {
                canvas.save();
                canvas.translate((float) (scrollX + compoundPaddingLeft + ((i3 - bVar.OWi) / 2)), (float) (getPaddingTop() + scrollY));
                bVar.OWa.draw(canvas);
                canvas.restore();
            }
            if (this.OVO && bVar.OWb != null) {
                canvas.save();
                canvas.translate((float) (scrollX + compoundPaddingLeft + ((i3 - bVar.OWj) / 2)), (float) ((((scrollY + bottom) - top) - getPaddingBottom()) - bVar.OWf));
                bVar.OWb.draw(canvas);
                canvas.restore();
            }
        }
        this.ayn.setColor(this.OVm);
        this.ayn.drawableState = getDrawableState();
        canvas.save();
        int extendedPaddingTop = getExtendedPaddingTop();
        canvas.clipRect((float) (compoundPaddingLeft + scrollX), (float) (extendedPaddingTop + scrollY), (float) (((right - left) - compoundPaddingRight) + scrollX), (float) (((bottom - top) - getExtendedPaddingBottom()) + scrollY));
        int i4 = 0;
        int i5 = 0;
        if ((this.Ku & 112) != 48) {
            i4 = getVerticalOffset$1385f2();
            i5 = getVerticalOffset$1385f2();
        }
        canvas.translate((float) compoundPaddingLeft, (float) (extendedPaddingTop + i4));
        if (this.OVF) {
            float f4 = (float) (((height - (this.OVH.bottom - this.OVH.top)) / 2) - this.OVH.top);
            int i6 = 0;
            if ((this.Ku & 7) != 3) {
                switch (this.Ku & 7) {
                    case 1:
                        if (f3 == -1.0f) {
                            f3 = this.ayn.measureText(this.mText, 0, this.mText.length());
                        }
                        i6 = ((int) (((float) (width - getPaddingRight())) - f3)) / 2;
                        break;
                    case 5:
                        if (f3 == -1.0f) {
                            f3 = this.ayn.measureText(this.mText, 0, this.mText.length());
                        }
                        i6 = (int) (((float) (width - getPaddingRight())) - f3);
                        break;
                }
            }
            canvas.drawText(this.mText, 0, this.mText.length(), (float) i6, f4, this.ayn);
        } else {
            if (this.OVt == null) {
                gLs();
            }
            try {
                this.OVt.draw(canvas, null, null, i5 - i4);
            } catch (IndexOutOfBoundsException e2) {
                Log.printErrStackTrace("TextView", e2, "", new Object[0]);
            }
        }
        canvas.restore();
        AppMethodBeat.o(142429);
    }

    public void getFocusedRect(Rect rect) {
        AppMethodBeat.i(142430);
        if (this.OVt == null) {
            super.getFocusedRect(rect);
            AppMethodBeat.o(142430);
            return;
        }
        int selectionEnd = getSelectionEnd();
        if (selectionEnd < 0) {
            super.getFocusedRect(rect);
            AppMethodBeat.o(142430);
            return;
        }
        int lineForOffset = this.OVt.getLineForOffset(selectionEnd);
        rect.top = this.OVt.getLineTop(lineForOffset);
        rect.bottom = this.OVt.getLineBottom(lineForOffset);
        rect.left = (int) this.OVt.getPrimaryHorizontal(selectionEnd);
        rect.right = rect.left + 1;
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int extendedPaddingTop = getExtendedPaddingTop();
        if ((this.Ku & 112) != 48) {
            extendedPaddingTop += getVerticalOffset$1385f2();
        }
        rect.offset(compoundPaddingLeft, extendedPaddingTop);
        AppMethodBeat.o(142430);
    }

    public int getLineCount() {
        AppMethodBeat.i(142431);
        if (this.OVt != null) {
            int lineCount = this.OVt.getLineCount();
            AppMethodBeat.o(142431);
            return lineCount;
        }
        AppMethodBeat.o(142431);
        return 0;
    }

    public int getBaseline() {
        int i2;
        AppMethodBeat.i(142432);
        if (this.OVt == null) {
            int baseline = super.getBaseline();
            AppMethodBeat.o(142432);
            return baseline;
        }
        if ((this.Ku & 112) != 48) {
            i2 = getVerticalOffset$1385f2();
        } else {
            i2 = 0;
        }
        int extendedPaddingTop = i2 + getExtendedPaddingTop() + this.OVt.getLineBaseline(0);
        AppMethodBeat.o(142432);
        return extendedPaddingTop;
    }

    private void gLr() {
        if ((this.OVt instanceof BoringLayout) && this.OVE == null) {
            this.OVE = (BoringLayout) this.OVt;
        }
        this.OVt = null;
    }

    private void gLs() {
        int right;
        AppMethodBeat.i(142433);
        if (this.OVA) {
            right = (this.mMaxWidth - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        } else {
            right = ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        }
        if (right <= 0) {
            right = 0;
        }
        kZ(right, right);
        AppMethodBeat.o(142433);
    }

    private void kZ(int i2, int i3) {
        int i4;
        Layout.Alignment alignment;
        boolean z;
        AppMethodBeat.i(142434);
        if (i2 < 0) {
            i4 = 0;
        } else {
            i4 = i2;
        }
        switch (this.Ku & 7) {
            case 1:
                alignment = Layout.Alignment.ALIGN_CENTER;
                break;
            case 5:
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
                break;
            default:
                alignment = Layout.Alignment.ALIGN_NORMAL;
                break;
        }
        if (this.OVp == null || this.OVs != null) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.OVt = new StaticLayout(this.OVq, 0, this.OVq.length(), this.ayn, i4, alignment, this.OVu, this.OVv, this.OVD, this.OVp, i3);
            AppMethodBeat.o(142434);
            return;
        }
        this.OVt = new StaticLayout(this.OVq, this.ayn, i4, alignment, this.OVu, this.OVv, this.OVD);
        AppMethodBeat.o(142434);
    }

    public void setIncludeFontPadding(boolean z) {
        AppMethodBeat.i(142435);
        this.OVD = z;
        if (this.OVt != null) {
            gLr();
            requestLayout();
            invalidate();
        }
        AppMethodBeat.o(142435);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        boolean z;
        int desiredHeight;
        AppMethodBeat.i(142436);
        View.MeasureSpec.getMode(i2);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (size == 0) {
            setMeasuredDimension(size, this.OVG);
            AppMethodBeat.o(142436);
        } else if (this.OVF) {
            if (this.OVG == 0) {
                gLt();
            }
            setMeasuredDimension(size, this.OVG);
            AppMethodBeat.o(142436);
        } else {
            int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
            if (this.OVA) {
                i4 = this.mMaxWidth - compoundPaddingLeft;
            } else {
                i4 = size - compoundPaddingLeft;
            }
            if (this.OVt == null) {
                kZ(i4, i4);
            } else {
                if (this.OVt.getWidth() != i4) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    kZ(i4, i4);
                }
            }
            if (mode == 1073741824) {
                this.OVC = -1;
                desiredHeight = size2;
            } else {
                desiredHeight = getDesiredHeight();
                this.OVC = desiredHeight;
                if (mode == Integer.MIN_VALUE) {
                    desiredHeight = Math.min(desiredHeight, size2);
                }
            }
            scrollTo(0, 0);
            setMeasuredDimension(size, desiredHeight);
            AppMethodBeat.o(142436);
        }
    }

    private int getDesiredHeight() {
        AppMethodBeat.i(142437);
        Layout layout = this.OVt;
        if (layout == null) {
            AppMethodBeat.o(142437);
            return 0;
        }
        int lineCount = layout.getLineCount();
        int compoundPaddingBottom = getCompoundPaddingBottom() + getCompoundPaddingTop();
        int lineTop = layout.getLineTop(lineCount) + compoundPaddingBottom;
        if (this.OVx != 1) {
            lineTop = Math.min(lineTop, this.OVw);
        } else if (lineCount > this.OVw) {
            lineTop = layout.getLineTop(this.OVw) + layout.getBottomPadding() + compoundPaddingBottom;
            lineCount = this.OVw;
        }
        if (this.OVz != 1) {
            lineTop = Math.max(lineTop, this.OVy);
        } else if (lineCount < this.OVy) {
            lineTop += (this.OVy - lineCount) * getLineHeight();
        }
        int max = Math.max(lineTop, getSuggestedMinimumHeight());
        AppMethodBeat.o(142437);
        return max;
    }

    private void gLt() {
        AppMethodBeat.i(142438);
        if (this.OVG == 0) {
            this.OVG = (int) (Math.ceil((double) (this.OVH.descent - this.OVH.ascent)) + 2.0d);
        }
        AppMethodBeat.o(142438);
    }

    private void alB(int i2) {
        AppMethodBeat.i(142439);
        if (this.OVF) {
            gLt();
            invalidate();
            AppMethodBeat.o(142439);
        } else if (getWidth() == 0) {
            requestLayout();
            invalidate();
            AppMethodBeat.o(142439);
        } else if (this.OVt == null) {
            gLs();
            if (this.OVt.getHeight() != getHeight()) {
                requestLayout();
            }
            invalidate();
            AppMethodBeat.o(142439);
        } else {
            int height = this.OVt.getHeight();
            int width = this.OVt.getWidth();
            kZ(width, width - i2);
            if (this.OVp != TextUtils.TruncateAt.MARQUEE) {
                if (getLayoutParams().height == -2 || getLayoutParams().height == -1) {
                    int height2 = this.OVt.getHeight();
                    if (height2 == height && height2 == getHeight()) {
                        invalidate();
                        AppMethodBeat.o(142439);
                        return;
                    }
                } else {
                    invalidate();
                    AppMethodBeat.o(142439);
                    return;
                }
            }
            requestLayout();
            invalidate();
            AppMethodBeat.o(142439);
        }
    }

    @ViewDebug.ExportedProperty
    public int getSelectionStart() {
        AppMethodBeat.i(142440);
        int selectionStart = Selection.getSelectionStart(getText());
        AppMethodBeat.o(142440);
        return selectionStart;
    }

    @ViewDebug.ExportedProperty
    public int getSelectionEnd() {
        AppMethodBeat.i(142441);
        int selectionEnd = Selection.getSelectionEnd(getText());
        AppMethodBeat.o(142441);
        return selectionEnd;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        AppMethodBeat.i(142443);
        this.OVp = truncateAt;
        if (this.OVt != null) {
            gLr();
            requestLayout();
            invalidate();
        }
        AppMethodBeat.o(142443);
    }

    @ViewDebug.ExportedProperty
    public TextUtils.TruncateAt getEllipsize() {
        return this.OVp;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollRange() {
        AppMethodBeat.i(142444);
        if (this.OVt != null) {
            int width = this.OVt.getWidth();
            AppMethodBeat.o(142444);
            return width;
        }
        int computeHorizontalScrollRange = super.computeHorizontalScrollRange();
        AppMethodBeat.o(142444);
        return computeHorizontalScrollRange;
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollRange() {
        AppMethodBeat.i(142445);
        if (this.OVt != null) {
            int height = this.OVt.getHeight();
            AppMethodBeat.o(142445);
            return height;
        }
        int computeVerticalScrollRange = super.computeVerticalScrollRange();
        AppMethodBeat.o(142445);
        return computeVerticalScrollRange;
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollExtent() {
        AppMethodBeat.i(142446);
        int height = (getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom();
        AppMethodBeat.o(142446);
        return height;
    }

    public enum a {
        NORMAL,
        SPANNABLE,
        EDITABLE;

        public static a valueOf(String str) {
            AppMethodBeat.i(142369);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(142369);
            return aVar;
        }

        static {
            AppMethodBeat.i(142370);
            AppMethodBeat.o(142370);
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.i(142447);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        CharSequence contentDescription = getContentDescription();
        if (Util.isNullOrNil((String) contentDescription)) {
            contentDescription = getText();
        }
        accessibilityNodeInfo.setText(contentDescription);
        AppMethodBeat.o(142447);
    }

    public void setSingleLine(boolean z) {
        AppMethodBeat.i(142442);
        this.OSP = z;
        if (z) {
            setLines(1);
            AppMethodBeat.o(142442);
            return;
        }
        setMaxLines(Integer.MAX_VALUE);
        AppMethodBeat.o(142442);
    }
}
