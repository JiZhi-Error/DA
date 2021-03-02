package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.a;
import android.support.design.internal.f;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.b;
import android.support.v4.e.j;
import android.support.v4.view.ac;
import android.support.v4.view.p;
import android.support.v4.view.u;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.mm.R;

public class CollapsingToolbarLayout extends FrameLayout {
    private final Rect mC;
    ac mZ;
    private boolean pG;
    private int pH;
    private Toolbar pI;
    private View pJ;
    private View pK;
    private int pL;
    private int pM;
    private int pN;
    private int pO;
    final d pP;
    private boolean pQ;
    private boolean pR;
    private Drawable pS;
    Drawable pT;
    private int pU;
    private boolean pV;
    private ValueAnimator pW;
    private long pX;
    private int pY;
    private AppBarLayout.b pZ;
    int qa;

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.pG = true;
        this.mC = new Rect();
        this.pY = -1;
        this.pP = new d(this);
        this.pP.a(android.support.design.a.a.gO);
        TypedArray a2 = f.a(context, attributeSet, a.C0008a.CollapsingToolbarLayout, i2, R.style.a3s, new int[0]);
        this.pP.M(a2.getInt(3, 8388691));
        this.pP.N(a2.getInt(0, 8388627));
        int dimensionPixelSize = a2.getDimensionPixelSize(4, 0);
        this.pO = dimensionPixelSize;
        this.pN = dimensionPixelSize;
        this.pM = dimensionPixelSize;
        this.pL = dimensionPixelSize;
        if (a2.hasValue(7)) {
            this.pL = a2.getDimensionPixelSize(7, 0);
        }
        if (a2.hasValue(6)) {
            this.pN = a2.getDimensionPixelSize(6, 0);
        }
        if (a2.hasValue(8)) {
            this.pM = a2.getDimensionPixelSize(8, 0);
        }
        if (a2.hasValue(5)) {
            this.pO = a2.getDimensionPixelSize(5, 0);
        }
        this.pQ = a2.getBoolean(14, true);
        setTitle(a2.getText(13));
        this.pP.P(R.style.wx);
        this.pP.O(R.style.w8);
        if (a2.hasValue(9)) {
            this.pP.P(a2.getResourceId(9, 0));
        }
        if (a2.hasValue(1)) {
            this.pP.O(a2.getResourceId(1, 0));
        }
        this.pY = a2.getDimensionPixelSize(11, -1);
        this.pX = (long) a2.getInt(10, 600);
        setContentScrim(a2.getDrawable(2));
        setStatusBarScrim(a2.getDrawable(12));
        this.pH = a2.getResourceId(15, -1);
        a2.recycle();
        setWillNotDraw(false);
        u.a(this, new p() {
            /* class android.support.design.widget.CollapsingToolbarLayout.AnonymousClass1 */

            @Override // android.support.v4.view.p
            public final ac a(View view, ac acVar) {
                CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
                ac acVar2 = null;
                if (u.aq(collapsingToolbarLayout)) {
                    acVar2 = acVar;
                }
                if (!j.equals(collapsingToolbarLayout.mZ, acVar2)) {
                    collapsingToolbarLayout.mZ = acVar2;
                    collapsingToolbarLayout.requestLayout();
                }
                return acVar.fI();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            u.e(this, u.aq((View) parent));
            if (this.pZ == null) {
                this.pZ = new a();
            }
            ((AppBarLayout) parent).a(this.pZ);
            u.ap(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.pZ != null && (parent instanceof AppBarLayout)) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            AppBarLayout.b bVar = this.pZ;
            if (!(appBarLayout.listeners == null || bVar == null)) {
                appBarLayout.listeners.remove(bVar);
            }
        }
        super.onDetachedFromWindow();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        cr();
        if (this.pI == null && this.pS != null && this.pU > 0) {
            this.pS.mutate().setAlpha(this.pU);
            this.pS.draw(canvas);
        }
        if (this.pQ && this.pR) {
            this.pP.draw(canvas);
        }
        if (this.pT != null && this.pU > 0) {
            int systemWindowInsetTop = this.mZ != null ? this.mZ.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.pT.setBounds(0, -this.qa, getWidth(), systemWindowInsetTop - this.qa);
                this.pT.mutate().setAlpha(this.pU);
                this.pT.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z;
        boolean z2;
        if (this.pS != null && this.pU > 0) {
            if (this.pJ == null || this.pJ == this) {
                z2 = view == this.pI;
            } else {
                z2 = view == this.pJ;
            }
            if (z2) {
                this.pS.mutate().setAlpha(this.pU);
                this.pS.draw(canvas);
                z = true;
                return !super.drawChild(canvas, view, j2) || z;
            }
        }
        z = false;
        if (!super.drawChild(canvas, view, j2)) {
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.pS != null) {
            this.pS.setBounds(0, 0, i2, i3);
        }
    }

    private void cr() {
        Toolbar toolbar;
        if (this.pG) {
            this.pI = null;
            this.pJ = null;
            if (this.pH != -1) {
                this.pI = (Toolbar) findViewById(this.pH);
                if (this.pI != null) {
                    this.pJ = n(this.pI);
                }
            }
            if (this.pI == null) {
                int childCount = getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        toolbar = null;
                        break;
                    }
                    View childAt = getChildAt(i2);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i2++;
                }
                this.pI = toolbar;
            }
            cs();
            this.pG = false;
        }
    }

    private View n(View view) {
        ViewParent parent = view.getParent();
        View view2 = view;
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view2 = (View) parent;
            }
            parent = parent.getParent();
        }
        return view2;
    }

    private void cs() {
        if (!this.pQ && this.pK != null) {
            ViewParent parent = this.pK.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.pK);
            }
        }
        if (this.pQ && this.pI != null) {
            if (this.pK == null) {
                this.pK = new View(getContext());
            }
            if (this.pK.getParent() == null) {
                this.pI.addView(this.pK, -1, -1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        cr();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        int systemWindowInsetTop = this.mZ != null ? this.mZ.getSystemWindowInsetTop() : 0;
        if (mode == 0 && systemWindowInsetTop > 0) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(systemWindowInsetTop + getMeasuredHeight(), 1073741824));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        boolean z2 = true;
        super.onLayout(z, i2, i3, i4, i5);
        if (this.mZ != null) {
            int systemWindowInsetTop = this.mZ.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (!u.aq(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    u.s(childAt, systemWindowInsetTop);
                }
            }
        }
        if (this.pQ && this.pK != null) {
            this.pR = u.aD(this.pK) && this.pK.getVisibility() == 0;
            if (this.pR) {
                if (u.Z(this) != 1) {
                    z2 = false;
                }
                int q = q(this.pJ != null ? this.pJ : this.pI);
                f.a(this, this.pK, this.mC);
                this.pP.d(this.mC.left + (z2 ? this.pI.getTitleMarginEnd() : this.pI.getTitleMarginStart()), this.pI.getTitleMarginTop() + this.mC.top + q, (z2 ? this.pI.getTitleMarginStart() : this.pI.getTitleMarginEnd()) + this.mC.right, (q + this.mC.bottom) - this.pI.getTitleMarginBottom());
                d dVar = this.pP;
                int i8 = z2 ? this.pN : this.pL;
                int i9 = this.mC.top + this.pM;
                int i10 = i4 - i2;
                if (z2) {
                    i6 = this.pL;
                } else {
                    i6 = this.pN;
                }
                dVar.c(i8, i9, i10 - i6, (i5 - i3) - this.pO);
                this.pP.cp();
            }
        }
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            p(getChildAt(i11)).dx();
        }
        if (this.pI != null) {
            if (this.pQ && TextUtils.isEmpty(this.pP.text)) {
                setTitle(this.pI.getTitle());
            }
            if (this.pJ == null || this.pJ == this) {
                setMinimumHeight(o(this.pI));
            } else {
                setMinimumHeight(o(this.pJ));
            }
        }
        ct();
    }

    private static int o(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + view.getHeight() + marginLayoutParams.topMargin;
    }

    static p p(View view) {
        p pVar = (p) view.getTag(R.id.j7j);
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p(view);
        view.setTag(R.id.j7j, pVar2);
        return pVar2;
    }

    public void setTitle(CharSequence charSequence) {
        this.pP.setText(charSequence);
        cu();
    }

    public CharSequence getTitle() {
        if (this.pQ) {
            return this.pP.text;
        }
        return null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.pQ) {
            this.pQ = z;
            cu();
            cs();
            requestLayout();
        }
    }

    public void setScrimsShown(boolean z) {
        boolean z2;
        int i2 = 255;
        if (!u.az(this) || isInEditMode()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (this.pV != z) {
            if (z2) {
                int i3 = z ? 255 : 0;
                cr();
                if (this.pW == null) {
                    this.pW = new ValueAnimator();
                    this.pW.setDuration(this.pX);
                    this.pW.setInterpolator(i3 > this.pU ? android.support.design.a.a.gM : android.support.design.a.a.gN);
                    this.pW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        /* class android.support.design.widget.CollapsingToolbarLayout.AnonymousClass2 */

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                } else if (this.pW.isRunning()) {
                    this.pW.cancel();
                }
                this.pW.setIntValues(this.pU, i3);
                this.pW.start();
            } else {
                if (!z) {
                    i2 = 0;
                }
                setScrimAlpha(i2);
            }
            this.pV = z;
        }
    }

    /* access modifiers changed from: package-private */
    public void setScrimAlpha(int i2) {
        if (i2 != this.pU) {
            if (!(this.pS == null || this.pI == null)) {
                u.X(this.pI);
            }
            this.pU = i2;
            u.X(this);
        }
    }

    /* access modifiers changed from: package-private */
    public int getScrimAlpha() {
        return this.pU;
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.pS != drawable) {
            if (this.pS != null) {
                this.pS.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.pS = drawable2;
            if (this.pS != null) {
                this.pS.setBounds(0, 0, getWidth(), getHeight());
                this.pS.setCallback(this);
                this.pS.setAlpha(this.pU);
            }
            u.X(this);
        }
    }

    public void setContentScrimColor(int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(int i2) {
        setContentScrim(b.l(getContext(), i2));
    }

    public Drawable getContentScrim() {
        return this.pS;
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.pT != drawable) {
            if (this.pT != null) {
                this.pT.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.pT = drawable2;
            if (this.pT != null) {
                if (this.pT.isStateful()) {
                    this.pT.setState(getDrawableState());
                }
                android.support.v4.graphics.drawable.a.b(this.pT, u.Z(this));
                this.pT.setVisible(getVisibility() == 0, false);
                this.pT.setCallback(this);
                this.pT.setAlpha(this.pU);
            }
            u.X(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        boolean z = false;
        Drawable drawable = this.pT;
        if (drawable != null && drawable.isStateful()) {
            z = drawable.setState(drawableState) | false;
        }
        Drawable drawable2 = this.pS;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (this.pP != null) {
            z |= this.pP.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.pS || drawable == this.pT;
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        if (!(this.pT == null || this.pT.isVisible() == z)) {
            this.pT.setVisible(z, false);
        }
        if (this.pS != null && this.pS.isVisible() != z) {
            this.pS.setVisible(z, false);
        }
    }

    public void setStatusBarScrimColor(int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(int i2) {
        setStatusBarScrim(b.l(getContext(), i2));
    }

    public Drawable getStatusBarScrim() {
        return this.pT;
    }

    public void setCollapsedTitleTextAppearance(int i2) {
        this.pP.O(i2);
    }

    public void setCollapsedTitleTextColor(int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.pP.d(colorStateList);
    }

    public void setCollapsedTitleGravity(int i2) {
        this.pP.N(i2);
    }

    public int getCollapsedTitleGravity() {
        return this.pP.oW;
    }

    public void setExpandedTitleTextAppearance(int i2) {
        this.pP.P(i2);
    }

    public void setExpandedTitleColor(int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.pP.e(colorStateList);
    }

    public void setExpandedTitleGravity(int i2) {
        this.pP.M(i2);
    }

    public int getExpandedTitleGravity() {
        return this.pP.oV;
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        d dVar = this.pP;
        if (dVar.pi != typeface) {
            dVar.pi = typeface;
            dVar.cp();
        }
    }

    public Typeface getCollapsedTitleTypeface() {
        d dVar = this.pP;
        return dVar.pi != null ? dVar.pi : Typeface.DEFAULT;
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        d dVar = this.pP;
        if (dVar.pj != typeface) {
            dVar.pj = typeface;
            dVar.cp();
        }
    }

    public Typeface getExpandedTitleTypeface() {
        d dVar = this.pP;
        return dVar.pj != null ? dVar.pj : Typeface.DEFAULT;
    }

    public int getExpandedTitleMarginStart() {
        return this.pL;
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.pL = i2;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.pM;
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.pM = i2;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.pN;
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.pN = i2;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.pO;
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.pO = i2;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(int i2) {
        if (this.pY != i2) {
            this.pY = i2;
            ct();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        if (this.pY >= 0) {
            return this.pY;
        }
        int systemWindowInsetTop = this.mZ != null ? this.mZ.getSystemWindowInsetTop() : 0;
        int ag = u.ag(this);
        if (ag > 0) {
            return Math.min(systemWindowInsetTop + (ag * 2), getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j2) {
        this.pX = j2;
    }

    public long getScrimAnimationDuration() {
        return this.pX;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        int qc = 0;
        float qd = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0008a.CollapsingToolbarLayout_Layout);
            this.qc = obtainStyledAttributes.getInt(0, 0);
            this.qd = obtainStyledAttributes.getFloat(1, 0.5f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* access modifiers changed from: package-private */
    public final void ct() {
        if (this.pS != null || this.pT != null) {
            setScrimsShown(getHeight() + this.qa < getScrimVisibleHeightTrigger());
        }
    }

    /* access modifiers changed from: package-private */
    public final int q(View view) {
        return ((getHeight() - p(view).wE) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    private void cu() {
        setContentDescription(getTitle());
    }

    class a implements AppBarLayout.b {
        a() {
        }

        @Override // android.support.design.widget.AppBarLayout.a, android.support.design.widget.AppBarLayout.b
        public final void c(AppBarLayout appBarLayout, int i2) {
            CollapsingToolbarLayout.this.qa = i2;
            int systemWindowInsetTop = CollapsingToolbarLayout.this.mZ != null ? CollapsingToolbarLayout.this.mZ.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                p p = CollapsingToolbarLayout.p(childAt);
                switch (layoutParams.qc) {
                    case 1:
                        p.G(android.support.v4.b.a.clamp(-i2, 0, CollapsingToolbarLayout.this.q(childAt)));
                        break;
                    case 2:
                        p.G(Math.round(layoutParams.qd * ((float) (-i2))));
                        break;
                }
            }
            CollapsingToolbarLayout.this.ct();
            if (CollapsingToolbarLayout.this.pT != null && systemWindowInsetTop > 0) {
                u.X(CollapsingToolbarLayout.this);
            }
            CollapsingToolbarLayout.this.pP.k(((float) Math.abs(i2)) / ((float) ((CollapsingToolbarLayout.this.getHeight() - u.ag(CollapsingToolbarLayout.this)) - systemWindowInsetTop)));
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
