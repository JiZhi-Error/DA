package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.a;
import android.support.design.internal.f;
import android.support.design.internal.g;
import android.support.v4.content.b;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.a.c;
import android.support.v4.view.u;
import android.support.v4.widget.q;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.az;
import android.support.v7.widget.x;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.tav.core.ExportErrorStatus;

public class TextInputLayout extends LinearLayout {
    private ValueAnimator animator;
    private CharSequence hint;
    private final Rect mC;
    final d pP;
    private Typeface sB;
    private final j vA;
    boolean vB;
    private int vC;
    private boolean vD;
    private TextView vE;
    private final int vF;
    private final int vG;
    private boolean vH;
    boolean vI;
    private GradientDrawable vJ;
    private final int vK;
    private final int vL;
    private int vM;
    private final int vN;
    private float vO;
    private float vP;
    private float vQ;
    private float vR;
    private int vS;
    private final int vT;
    private final int vU;
    private int vV;
    private int vW;
    private Drawable vX;
    private final RectF vY;
    private boolean vZ;
    private final FrameLayout vx;
    EditText vy;
    private CharSequence vz;
    private Drawable wa;
    private CharSequence wb;
    private CheckableImageButton wd;
    private boolean we;
    private Drawable wf;
    private Drawable wg;
    private ColorStateList wh;
    private boolean wi;
    private PorterDuff.Mode wj;
    private boolean wk;
    private ColorStateList wl;
    private ColorStateList wm;
    private final int wn;
    private final int wo;
    private int wp;
    private final int wq;
    private boolean wr;
    private boolean ws;
    private boolean wt;
    private boolean wv;
    private boolean ww;

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.a2a);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.vA = new j(this);
        this.mC = new Rect();
        this.vY = new RectF();
        this.pP = new d(this);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.vx = new FrameLayout(context);
        this.vx.setAddStatesFromChildren(true);
        addView(this.vx);
        this.pP.a(android.support.design.a.a.gK);
        d dVar = this.pP;
        dVar.pw = android.support.design.a.a.gK;
        dVar.cp();
        this.pP.N(8388659);
        az b2 = f.b(context, attributeSet, a.C0008a.TextInputLayout, i2, R.style.a3y, new int[0]);
        this.vH = b2.getBoolean(21, true);
        setHint(b2.getText(1));
        this.ws = b2.getBoolean(20, true);
        this.vK = context.getResources().getDimensionPixelOffset(R.dimen.aer);
        this.vL = context.getResources().getDimensionPixelOffset(R.dimen.aeu);
        this.vN = b2.getDimensionPixelOffset(4, 0);
        this.vO = b2.cV(8);
        this.vP = b2.cV(7);
        this.vQ = b2.cV(5);
        this.vR = b2.cV(6);
        this.vW = b2.getColor(2, 0);
        this.wp = b2.getColor(9, 0);
        this.vT = context.getResources().getDimensionPixelSize(R.dimen.aew);
        this.vU = context.getResources().getDimensionPixelSize(R.dimen.aex);
        this.vS = this.vT;
        setBoxBackgroundMode(b2.getInt(3, 0));
        if (b2.hasValue(0)) {
            ColorStateList colorStateList = b2.getColorStateList(0);
            this.wm = colorStateList;
            this.wl = colorStateList;
        }
        this.wn = b.n(context, R.color.a1e);
        this.wq = b.n(context, R.color.a1f);
        this.wo = b.n(context, R.color.a1h);
        if (b2.getResourceId(22, -1) != -1) {
            setHintTextAppearance(b2.getResourceId(22, 0));
        }
        int resourceId = b2.getResourceId(16, 0);
        boolean z = b2.getBoolean(15, false);
        int resourceId2 = b2.getResourceId(19, 0);
        boolean z2 = b2.getBoolean(18, false);
        CharSequence text = b2.getText(17);
        boolean z3 = b2.getBoolean(11, false);
        setCounterMaxLength(b2.getInt(12, -1));
        this.vG = b2.getResourceId(14, 0);
        this.vF = b2.getResourceId(13, 0);
        this.vZ = b2.getBoolean(25, false);
        this.wa = b2.getDrawable(24);
        this.wb = b2.getText(23);
        if (b2.hasValue(26)) {
            this.wi = true;
            this.wh = b2.getColorStateList(26);
        }
        if (b2.hasValue(27)) {
            this.wk = true;
            this.wj = g.a(b2.getInt(27, -1), null);
        }
        b2.ayy.recycle();
        setHelperTextEnabled(z2);
        setHelperText(text);
        setHelperTextTextAppearance(resourceId2);
        setErrorEnabled(z);
        setErrorTextAppearance(resourceId);
        setCounterEnabled(z3);
        ds();
        u.p(this, 2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & ExportErrorStatus.APPEND_VIDEO_SAMPLE_SWAP_BUFFERS) | 16;
            this.vx.addView(view, layoutParams2);
            this.vx.setLayoutParams(layoutParams);
            dg();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    private Drawable getBoxBackground() {
        if (this.vM == 1 || this.vM == 2) {
            return this.vJ;
        }
        throw new IllegalStateException();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 != this.vM) {
            this.vM = i2;
            de();
        }
    }

    private void de() {
        df();
        if (this.vM != 0) {
            dg();
        }
        dh();
    }

    private void df() {
        if (this.vM == 0) {
            this.vJ = null;
        } else if (this.vM == 2 && this.vH && !(this.vJ instanceof e)) {
            this.vJ = new e();
        } else if (!(this.vJ instanceof GradientDrawable)) {
            this.vJ = new GradientDrawable();
        }
    }

    public void setBoxStrokeColor(int i2) {
        if (this.wp != i2) {
            this.wp = i2;
            dw();
        }
    }

    public int getBoxStrokeColor() {
        return this.wp;
    }

    public void setBoxBackgroundColorResource(@android.support.annotation.a int i2) {
        setBoxBackgroundColor(b.n(getContext(), i2));
    }

    public void setBoxBackgroundColor(int i2) {
        if (this.vW != i2) {
            this.vW = i2;
            dm();
        }
    }

    public int getBoxBackgroundColor() {
        return this.vW;
    }

    public float getBoxCornerRadiusTopStart() {
        return this.vO;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.vP;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.vQ;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.vR;
    }

    private float[] getCornerRadiiAsArray() {
        if (!g.d(this)) {
            return new float[]{this.vO, this.vO, this.vP, this.vP, this.vQ, this.vQ, this.vR, this.vR};
        }
        return new float[]{this.vP, this.vP, this.vO, this.vO, this.vR, this.vR, this.vQ, this.vQ};
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.sB) {
            this.sB = typeface;
            this.pP.b(typeface);
            j jVar = this.vA;
            if (typeface != jVar.sB) {
                jVar.sB = typeface;
                j.a(jVar.su, typeface);
                j.a(jVar.sz, typeface);
            }
            if (this.vE != null) {
                this.vE.setTypeface(typeface);
            }
        }
    }

    public Typeface getTypeface() {
        return this.sB;
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        if (this.vz == null || this.vy == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        boolean z = this.vI;
        this.vI = false;
        CharSequence hint2 = this.vy.getHint();
        this.vy.setHint(this.vz);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
        } finally {
            this.vy.setHint(hint2);
            this.vI = z;
        }
    }

    private void setEditText(EditText editText) {
        if (this.vy != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        this.vy = editText;
        de();
        setTextInputAccessibilityDelegate(new a(this));
        if (!dq()) {
            this.pP.b(this.vy.getTypeface());
        }
        d dVar = this.pP;
        float textSize = this.vy.getTextSize();
        if (dVar.oX != textSize) {
            dVar.oX = textSize;
            dVar.cp();
        }
        int gravity = this.vy.getGravity();
        this.pP.N((gravity & ExportErrorStatus.APPEND_VIDEO_SAMPLE_SWAP_BUFFERS) | 48);
        this.pP.M(gravity);
        this.vy.addTextChangedListener(new TextWatcher() {
            /* class android.support.design.widget.TextInputLayout.AnonymousClass1 */

            public final void afterTextChanged(Editable editable) {
                boolean z;
                TextInputLayout textInputLayout = TextInputLayout.this;
                if (!TextInputLayout.this.ww) {
                    z = true;
                } else {
                    z = false;
                }
                textInputLayout.d(z, false);
                if (TextInputLayout.this.vB) {
                    TextInputLayout.this.ak(editable.length());
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        if (this.wl == null) {
            this.wl = this.vy.getHintTextColors();
        }
        if (this.vH) {
            if (TextUtils.isEmpty(this.hint)) {
                this.vz = this.vy.getHint();
                setHint(this.vz);
                this.vy.setHint((CharSequence) null);
            }
            this.vI = true;
        }
        if (this.vE != null) {
            ak(this.vy.getText().length());
        }
        this.vA.cQ();
        dp();
        d(false, true);
    }

    private void dg() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.vx.getLayoutParams();
        int dj = dj();
        if (dj != layoutParams.topMargin) {
            layoutParams.topMargin = dj;
            this.vx.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public final void d(boolean z, boolean z2) {
        boolean z3 = true;
        boolean isEnabled = isEnabled();
        boolean z4 = this.vy != null && !TextUtils.isEmpty(this.vy.getText());
        if (this.vy == null || !this.vy.hasFocus()) {
            z3 = false;
        }
        boolean cR = this.vA.cR();
        if (this.wl != null) {
            this.pP.d(this.wl);
            this.pP.e(this.wl);
        }
        if (!isEnabled) {
            this.pP.d(ColorStateList.valueOf(this.wq));
            this.pP.e(ColorStateList.valueOf(this.wq));
        } else if (cR) {
            this.pP.d(this.vA.cT());
        } else if (this.vD && this.vE != null) {
            this.pP.d(this.vE.getTextColors());
        } else if (z3 && this.wm != null) {
            this.pP.d(this.wm);
        }
        if (z4 || (isEnabled() && (z3 || cR))) {
            if (z2 || this.wr) {
                z(z);
            }
        } else if (z2 || !this.wr) {
            A(z);
        }
    }

    public EditText getEditText() {
        return this.vy;
    }

    public void setHint(CharSequence charSequence) {
        if (this.vH) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.hint)) {
            this.hint = charSequence;
            this.pP.setText(charSequence);
            if (!this.wr) {
                du();
            }
        }
    }

    public CharSequence getHint() {
        if (this.vH) {
            return this.hint;
        }
        return null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.vH) {
            this.vH = z;
            if (!this.vH) {
                this.vI = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.vy.getHint())) {
                    this.vy.setHint(this.hint);
                }
                setHintInternal(null);
            } else {
                CharSequence hint2 = this.vy.getHint();
                if (!TextUtils.isEmpty(hint2)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint2);
                    }
                    this.vy.setHint((CharSequence) null);
                }
                this.vI = true;
            }
            if (this.vy != null) {
                dg();
            }
        }
    }

    public void setHintTextAppearance(int i2) {
        this.pP.O(i2);
        this.wm = this.pP.pa;
        if (this.vy != null) {
            d(false, false);
            dg();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.wl = colorStateList;
        this.wm = colorStateList;
        if (this.vy != null) {
            d(false, false);
        }
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.wl;
    }

    public void setErrorEnabled(boolean z) {
        j jVar = this.vA;
        if (jVar.st != z) {
            jVar.cP();
            if (z) {
                jVar.su = new AppCompatTextView(jVar.context);
                jVar.su.setId(R.id.iky);
                if (jVar.sB != null) {
                    jVar.su.setTypeface(jVar.sB);
                }
                jVar.setErrorTextAppearance(jVar.sv);
                jVar.su.setVisibility(4);
                u.r(jVar.su, 1);
                jVar.a(jVar.su, 0);
            } else {
                jVar.cO();
                jVar.b(jVar.su, 0);
                jVar.su = null;
                jVar.si.dn();
                jVar.si.dw();
            }
            jVar.st = z;
        }
    }

    public void setErrorTextAppearance(int i2) {
        this.vA.setErrorTextAppearance(i2);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        j jVar = this.vA;
        if (jVar.su != null) {
            jVar.su.setTextColor(colorStateList);
        }
    }

    public int getErrorCurrentTextColors() {
        return this.vA.cS();
    }

    public void setHelperTextTextAppearance(int i2) {
        this.vA.Y(i2);
    }

    public void setHelperTextEnabled(boolean z) {
        j jVar = this.vA;
        if (jVar.sy != z) {
            jVar.cP();
            if (z) {
                jVar.sz = new AppCompatTextView(jVar.context);
                jVar.sz.setId(R.id.ikz);
                if (jVar.sB != null) {
                    jVar.sz.setTypeface(jVar.sB);
                }
                jVar.sz.setVisibility(4);
                u.r(jVar.sz, 1);
                jVar.Y(jVar.sA);
                jVar.a(jVar.sz, 1);
            } else {
                jVar.cP();
                if (jVar.sq == 2) {
                    jVar.sr = 0;
                }
                jVar.a(jVar.sq, jVar.sr, jVar.a(jVar.sz, (CharSequence) null));
                jVar.b(jVar.sz, 1);
                jVar.sz = null;
                jVar.si.dn();
                jVar.si.dw();
            }
            jVar.sy = z;
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!this.vA.sy) {
                setHelperTextEnabled(true);
            }
            j jVar = this.vA;
            jVar.cP();
            jVar.sx = charSequence;
            jVar.sz.setText(charSequence);
            if (jVar.sq != 2) {
                jVar.sr = 2;
            }
            jVar.a(jVar.sq, jVar.sr, jVar.a(jVar.sz, charSequence));
        } else if (this.vA.sy) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        j jVar = this.vA;
        if (jVar.sz != null) {
            jVar.sz.setTextColor(colorStateList);
        }
    }

    public int getHelperTextCurrentTextColor() {
        j jVar = this.vA;
        if (jVar.sz != null) {
            return jVar.sz.getCurrentTextColor();
        }
        return -1;
    }

    public void setError(CharSequence charSequence) {
        if (!this.vA.st) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            j jVar = this.vA;
            jVar.cP();
            jVar.ss = charSequence;
            jVar.su.setText(charSequence);
            if (jVar.sq != 1) {
                jVar.sr = 1;
            }
            jVar.a(jVar.sq, jVar.sr, jVar.a(jVar.su, charSequence));
            return;
        }
        this.vA.cO();
    }

    public void setCounterEnabled(boolean z) {
        if (this.vB != z) {
            if (z) {
                this.vE = new AppCompatTextView(getContext());
                this.vE.setId(R.id.ikx);
                if (this.sB != null) {
                    this.vE.setTypeface(this.sB);
                }
                this.vE.setMaxLines(1);
                c(this.vE, this.vG);
                this.vA.a(this.vE, 2);
                if (this.vy == null) {
                    ak(0);
                } else {
                    ak(this.vy.getText().length());
                }
            } else {
                this.vA.b(this.vE, 2);
                this.vE = null;
            }
            this.vB = z;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.vC != i2) {
            if (i2 > 0) {
                this.vC = i2;
            } else {
                this.vC = -1;
            }
            if (this.vB) {
                ak(this.vy == null ? 0 : this.vy.getText().length());
            }
        }
    }

    public void setEnabled(boolean z) {
        a(this, z);
        super.setEnabled(z);
    }

    private static void a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.vC;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getCounterOverflowDescription() {
        if (!this.vB || !this.vD || this.vE == null) {
            return null;
        }
        return this.vE.getContentDescription();
    }

    /* access modifiers changed from: package-private */
    public final void ak(int i2) {
        boolean z = this.vD;
        if (this.vC == -1) {
            this.vE.setText(String.valueOf(i2));
            this.vE.setContentDescription(null);
            this.vD = false;
        } else {
            if (u.ab(this.vE) == 1) {
                u.r(this.vE, 0);
            }
            this.vD = i2 > this.vC;
            if (z != this.vD) {
                c(this.vE, this.vD ? this.vF : this.vG);
                if (this.vD) {
                    u.r(this.vE, 1);
                }
            }
            this.vE.setText(getContext().getString(R.string.au9, Integer.valueOf(i2), Integer.valueOf(this.vC)));
            this.vE.setContentDescription(getContext().getString(R.string.au8, Integer.valueOf(i2), Integer.valueOf(this.vC)));
        }
        if (this.vy != null && z != this.vD) {
            d(false, false);
            dw();
            dn();
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(TextView textView, int i2) {
        boolean z = true;
        try {
            q.d(textView, i2);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z = false;
            }
        } catch (Exception e2) {
        }
        if (z) {
            q.d(textView, R.style.vg);
            textView.setTextColor(b.n(getContext(), R.color.l9));
        }
    }

    private void dh() {
        if (this.vM != 0 && this.vJ != null && this.vy != null && getRight() != 0) {
            int left = this.vy.getLeft();
            int di = di();
            int right = this.vy.getRight();
            int bottom = this.vy.getBottom() + this.vK;
            if (this.vM == 2) {
                left += this.vU / 2;
                di -= this.vU / 2;
                right -= this.vU / 2;
                bottom += this.vU / 2;
            }
            this.vJ.setBounds(left, di, right, bottom);
            dm();
            dk();
        }
    }

    private int di() {
        if (this.vy == null) {
            return 0;
        }
        switch (this.vM) {
            case 1:
                return this.vy.getTop();
            case 2:
                return this.vy.getTop() + dj();
            default:
                return 0;
        }
    }

    private int dj() {
        if (!this.vH) {
            return 0;
        }
        switch (this.vM) {
            case 0:
            case 1:
                return (int) this.pP.ci();
            case 2:
                return (int) (this.pP.ci() / 2.0f);
            default:
                return 0;
        }
    }

    private void dk() {
        Drawable background;
        if (this.vy != null && (background = this.vy.getBackground()) != null) {
            if (x.t(background)) {
                background = background.mutate();
            }
            f.a(this, this.vy, new Rect());
            Rect bounds = background.getBounds();
            if (bounds.left != bounds.right) {
                Rect rect = new Rect();
                background.getPadding(rect);
                background.setBounds(bounds.left - rect.left, bounds.top, (rect.right * 2) + bounds.right, this.vy.getBottom());
            }
        }
    }

    private void dl() {
        switch (this.vM) {
            case 1:
                this.vS = 0;
                return;
            case 2:
                if (this.wp == 0) {
                    this.wp = this.wm.getColorForState(getDrawableState(), this.wm.getDefaultColor());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dm() {
        if (this.vJ != null) {
            dl();
            if (this.vy != null && this.vM == 2) {
                if (this.vy.getBackground() != null) {
                    this.vX = this.vy.getBackground();
                }
                u.a(this.vy, (Drawable) null);
            }
            if (!(this.vy == null || this.vM != 1 || this.vX == null)) {
                u.a(this.vy, this.vX);
            }
            if (this.vS >= 0 && this.vV != 0) {
                this.vJ.setStroke(this.vS, this.vV);
            }
            this.vJ.setCornerRadii(getCornerRadiiAsArray());
            this.vJ.setColor(this.vW);
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public final void dn() {
        Drawable background;
        if (this.vy != null && (background = this.vy.getBackground()) != null) {
            m0do();
            if (x.t(background)) {
                background = background.mutate();
            }
            if (this.vA.cR()) {
                background.setColorFilter(android.support.v7.widget.g.b(this.vA.cS(), PorterDuff.Mode.SRC_IN));
            } else if (!this.vD || this.vE == null) {
                android.support.v4.graphics.drawable.a.h(background);
                this.vy.refreshDrawableState();
            } else {
                background.setColorFilter(android.support.v7.widget.g.b(this.vE.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m0do() {
        Drawable background;
        int i2 = Build.VERSION.SDK_INT;
        if ((i2 == 21 || i2 == 22) && (background = this.vy.getBackground()) != null && !this.wt) {
            Drawable newDrawable = background.getConstantState().newDrawable();
            if (background instanceof DrawableContainer) {
                this.wt = g.a((DrawableContainer) background, newDrawable.getConstantState());
            }
            if (!this.wt) {
                u.a(this.vy, newDrawable);
                this.wt = true;
                de();
            }
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class android.support.design.widget.TextInputLayout.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        boolean wA;
        CharSequence wz;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.wz = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.wA = parcel.readInt() == 1;
        }

        @Override // android.support.v4.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.wz, parcel, i2);
            parcel.writeInt(this.wA ? 1 : 0);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.wz) + "}";
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.vA.cR()) {
            savedState.wz = getError();
        }
        savedState.wA = this.we;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.Pm);
        setError(savedState.wz);
        if (savedState.wA) {
            y(true);
        }
        requestLayout();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.ww = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.ww = false;
    }

    public CharSequence getError() {
        if (this.vA.st) {
            return this.vA.ss;
        }
        return null;
    }

    public CharSequence getHelperText() {
        if (this.vA.sy) {
            return this.vA.sx;
        }
        return null;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.ws = z;
    }

    public void draw(Canvas canvas) {
        if (this.vJ != null) {
            this.vJ.draw(canvas);
        }
        super.draw(canvas);
        if (this.vH) {
            this.pP.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        dp();
        super.onMeasure(i2, i3);
    }

    private void dp() {
        if (this.vy != null) {
            if (dr()) {
                if (this.wd == null) {
                    this.wd = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.zk, (ViewGroup) this.vx, false);
                    this.wd.setImageDrawable(this.wa);
                    this.wd.setContentDescription(this.wb);
                    this.vx.addView(this.wd);
                    this.wd.setOnClickListener(new View.OnClickListener() {
                        /* class android.support.design.widget.TextInputLayout.AnonymousClass2 */

                        public final void onClick(View view) {
                            TextInputLayout.this.y(false);
                        }
                    });
                }
                if (this.vy != null && u.ag(this.vy) <= 0) {
                    this.vy.setMinimumHeight(u.ag(this.wd));
                }
                this.wd.setVisibility(0);
                this.wd.setChecked(this.we);
                if (this.wf == null) {
                    this.wf = new ColorDrawable();
                }
                this.wf.setBounds(0, 0, this.wd.getMeasuredWidth(), 1);
                Drawable[] c2 = q.c(this.vy);
                if (c2[2] != this.wf) {
                    this.wg = c2[2];
                }
                q.a(this.vy, c2[0], c2[1], this.wf, c2[3]);
                this.wd.setPadding(this.vy.getPaddingLeft(), this.vy.getPaddingTop(), this.vy.getPaddingRight(), this.vy.getPaddingBottom());
                return;
            }
            if (this.wd != null && this.wd.getVisibility() == 0) {
                this.wd.setVisibility(8);
            }
            if (this.wf != null) {
                Drawable[] c3 = q.c(this.vy);
                if (c3[2] == this.wf) {
                    q.a(this.vy, c3[0], c3[1], this.wg, c3[3]);
                    this.wf = null;
                }
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? android.support.v7.c.a.a.l(getContext(), i2) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.wa = drawable;
        if (this.wd != null) {
            this.wd.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.wb = charSequence;
        if (this.wd != null) {
            this.wd.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.wa;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.wb;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.vZ != z) {
            this.vZ = z;
            if (!z && this.we && this.vy != null) {
                this.vy.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.we = false;
            dp();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.wh = colorStateList;
        this.wi = true;
        ds();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.wj = mode;
        this.wk = true;
        ds();
    }

    public final void y(boolean z) {
        if (this.vZ) {
            int selectionEnd = this.vy.getSelectionEnd();
            if (dq()) {
                this.vy.setTransformationMethod(null);
                this.we = true;
            } else {
                this.vy.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.we = false;
            }
            this.wd.setChecked(this.we);
            if (z) {
                this.wd.jumpDrawablesToCurrentState();
            }
            this.vy.setSelection(selectionEnd);
        }
    }

    public void setTextInputAccessibilityDelegate(a aVar) {
        if (this.vy != null) {
            u.a(this.vy, aVar);
        }
    }

    private boolean dq() {
        return this.vy != null && (this.vy.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean dr() {
        return this.vZ && (dq() || this.we);
    }

    private void ds() {
        if (this.wa == null) {
            return;
        }
        if (this.wi || this.wk) {
            this.wa = android.support.v4.graphics.drawable.a.i(this.wa).mutate();
            if (this.wi) {
                android.support.v4.graphics.drawable.a.a(this.wa, this.wh);
            }
            if (this.wk) {
                android.support.v4.graphics.drawable.a.a(this.wa, this.wj);
            }
            if (this.wd != null && this.wd.getDrawable() != this.wa) {
                this.wd.setImageDrawable(this.wa);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        super.onLayout(z, i2, i3, i4, i5);
        if (this.vJ != null) {
            dh();
        }
        if (this.vH && this.vy != null) {
            Rect rect = this.mC;
            f.a(this, this.vy, rect);
            int compoundPaddingLeft = this.vy.getCompoundPaddingLeft() + rect.left;
            int compoundPaddingRight = rect.right - this.vy.getCompoundPaddingRight();
            switch (this.vM) {
                case 1:
                    i6 = getBoxBackground().getBounds().top + this.vN;
                    break;
                case 2:
                    i6 = getBoxBackground().getBounds().top - dj();
                    break;
                default:
                    i6 = getPaddingTop();
                    break;
            }
            this.pP.c(compoundPaddingLeft, rect.top + this.vy.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.vy.getCompoundPaddingBottom());
            this.pP.d(compoundPaddingLeft, i6, compoundPaddingRight, (i5 - i3) - getPaddingBottom());
            this.pP.cp();
            if (dt() && !this.wr) {
                du();
            }
        }
    }

    private void z(boolean z) {
        if (this.animator != null && this.animator.isRunning()) {
            this.animator.cancel();
        }
        if (!z || !this.ws) {
            this.pP.k(1.0f);
        } else {
            v(1.0f);
        }
        this.wr = false;
        if (dt()) {
            du();
        }
    }

    private boolean dt() {
        return this.vH && !TextUtils.isEmpty(this.hint) && (this.vJ instanceof e);
    }

    private void du() {
        if (dt()) {
            RectF rectF = this.vY;
            this.pP.a(rectF);
            c(rectF);
            ((e) this.vJ).b(rectF);
        }
    }

    private void dv() {
        if (dt()) {
            ((e) this.vJ).a(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void c(RectF rectF) {
        rectF.left -= (float) this.vL;
        rectF.top -= (float) this.vL;
        rectF.right += (float) this.vL;
        rectF.bottom += (float) this.vL;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        boolean z;
        boolean z2 = true;
        if (!this.wv) {
            this.wv = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            if (!u.az(this) || !isEnabled()) {
                z2 = false;
            }
            d(z2, false);
            dn();
            dh();
            dw();
            if (this.pP != null) {
                z = this.pP.setState(drawableState) | false;
            } else {
                z = false;
            }
            if (z) {
                invalidate();
            }
            this.wv = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void dw() {
        boolean z = true;
        if (this.vJ != null && this.vM != 0) {
            boolean z2 = this.vy != null && this.vy.hasFocus();
            if (this.vy == null || !this.vy.isHovered()) {
                z = false;
            }
            if (this.vM == 2) {
                if (!isEnabled()) {
                    this.vV = this.wq;
                } else if (this.vA.cR()) {
                    this.vV = this.vA.cS();
                } else if (this.vD && this.vE != null) {
                    this.vV = this.vE.getCurrentTextColor();
                } else if (z2) {
                    this.vV = this.wp;
                } else if (z) {
                    this.vV = this.wo;
                } else {
                    this.vV = this.wn;
                }
                if ((z || z2) && isEnabled()) {
                    this.vS = this.vU;
                } else {
                    this.vS = this.vT;
                }
                dm();
            }
        }
    }

    private void A(boolean z) {
        if (this.animator != null && this.animator.isRunning()) {
            this.animator.cancel();
        }
        if (!z || !this.ws) {
            this.pP.k(0.0f);
        } else {
            v(0.0f);
        }
        if (dt() && ((e) this.vJ).cz()) {
            dv();
        }
        this.wr = true;
    }

    private void v(float f2) {
        if (this.pP.oR != f2) {
            if (this.animator == null) {
                this.animator = new ValueAnimator();
                this.animator.setInterpolator(android.support.design.a.a.gL);
                this.animator.setDuration(167L);
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class android.support.design.widget.TextInputLayout.AnonymousClass3 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TextInputLayout.this.pP.k(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.animator.setFloatValues(this.pP.oR, f2);
            this.animator.start();
        }
    }

    /* access modifiers changed from: package-private */
    public final int getHintCurrentCollapsedTextColor() {
        return this.pP.cm();
    }

    /* access modifiers changed from: package-private */
    public final float getHintCollapsedTextHeight() {
        return this.pP.ci();
    }

    /* access modifiers changed from: package-private */
    public final int getErrorTextCurrentColor() {
        return this.vA.cS();
    }

    public static class a extends android.support.v4.view.a {
        private final TextInputLayout wy;

        public a(TextInputLayout textInputLayout) {
            this.wy = textInputLayout;
        }

        @Override // android.support.v4.view.a
        public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            CharSequence charSequence;
            boolean z5;
            Bundle bundle;
            int i2 = 0;
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            EditText editText = this.wy.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.wy.getHint();
            CharSequence error = this.wy.getError();
            CharSequence counterOverflowDescription = this.wy.getCounterOverflowDescription();
            if (!TextUtils.isEmpty(text)) {
                z = true;
            } else {
                z = false;
            }
            if (!TextUtils.isEmpty(hint)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!TextUtils.isEmpty(error)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 || !TextUtils.isEmpty(counterOverflowDescription)) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z) {
                cVar.setText(text);
            } else if (z2) {
                cVar.setText(hint);
            }
            if (z2) {
                if (Build.VERSION.SDK_INT >= 26) {
                    cVar.Ro.setHintText(hint);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    cVar.Ro.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", hint);
                }
                if (z || !z2) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    cVar.Ro.setShowingHintText(z5);
                } else {
                    if (Build.VERSION.SDK_INT >= 19) {
                        bundle = cVar.Ro.getExtras();
                    } else {
                        bundle = new Bundle();
                    }
                    if (bundle != null) {
                        int i3 = bundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & -5;
                        if (z5) {
                            i2 = 4;
                        }
                        bundle.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i3 | i2);
                    }
                }
            }
            if (z4) {
                if (z3) {
                    charSequence = error;
                } else {
                    charSequence = counterOverflowDescription;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    cVar.Ro.setError(charSequence);
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    cVar.Ro.setContentInvalid(true);
                }
            }
        }

        @Override // android.support.v4.view.a
        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            EditText editText = this.wy.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            if (TextUtils.isEmpty(text)) {
                text = this.wy.getHint();
            }
            if (!TextUtils.isEmpty(text)) {
                accessibilityEvent.getText().add(text);
            }
        }
    }
}
