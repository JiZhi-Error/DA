package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.m;
import android.support.v4.view.o;
import android.support.v4.view.u;
import android.support.v7.view.menu.o;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import com.tencent.mm.R;

public class ActionBarOverlayLayout extends ViewGroup implements m, t {
    static final int[] QA = {R.attr.z, 16842841};
    private final o UV;
    private u ZU;
    private boolean aaK;
    private int ahS = 0;
    private ContentFrameLayout ahT;
    ActionBarContainer ahU;
    private Drawable ahV;
    private boolean ahW;
    public boolean ahX;
    private boolean ahY;
    boolean ahZ;
    private int aia;
    private int aib;
    private final Rect aic = new Rect();
    private final Rect aie = new Rect();
    private final Rect aif = new Rect();
    private final Rect aig = new Rect();
    private final Rect aih = new Rect();
    private final Rect aii = new Rect();
    private final Rect aij = new Rect();
    private a aik;
    private OverScroller ail;
    ViewPropertyAnimator aim;
    final AnimatorListenerAdapter ain = new AnimatorListenerAdapter() {
        /* class android.support.v7.widget.ActionBarOverlayLayout.AnonymousClass1 */

        public final void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout.this.aim = null;
            ActionBarOverlayLayout.this.ahZ = false;
        }

        public final void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout.this.aim = null;
            ActionBarOverlayLayout.this.ahZ = false;
        }
    };
    private final Runnable aio = new Runnable() {
        /* class android.support.v7.widget.ActionBarOverlayLayout.AnonymousClass2 */

        public final void run() {
            ActionBarOverlayLayout.this.iA();
            ActionBarOverlayLayout.this.aim = ActionBarOverlayLayout.this.ahU.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.ain);
        }
    };
    private final Runnable aip = new Runnable() {
        /* class android.support.v7.widget.ActionBarOverlayLayout.AnonymousClass3 */

        public final void run() {
            ActionBarOverlayLayout.this.iA();
            ActionBarOverlayLayout.this.aim = ActionBarOverlayLayout.this.ahU.animate().translationY((float) (-ActionBarOverlayLayout.this.ahU.getHeight())).setListener(ActionBarOverlayLayout.this.ain);
        }
    };
    private int mActionBarHeight;

    public interface a {
        void T(boolean z);

        void gX();

        void gZ();

        void ha();

        void onWindowVisibilityChanged(int i2);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
        this.UV = new o(this);
    }

    private void init(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(QA);
        this.mActionBarHeight = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.ahV = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.ahV == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.ahW = z;
        this.ail = new OverScroller(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        iA();
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.aik = aVar;
        if (getWindowToken() != null) {
            this.aik.onWindowVisibilityChanged(this.ahS);
            if (this.aib != 0) {
                onWindowSystemUiVisibilityChanged(this.aib);
                u.ap(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.ahX = z;
        this.ahW = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.ahY = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        init(getContext());
        u.ap(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i2) {
        boolean z;
        boolean z2 = true;
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i2);
        }
        iz();
        int i3 = this.aib ^ i2;
        this.aib = i2;
        boolean z3 = (i2 & 4) == 0;
        if ((i2 & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.aik != null) {
            a aVar = this.aik;
            if (z) {
                z2 = false;
            }
            aVar.T(z2);
            if (z3 || !z) {
                this.aik.gX();
            } else {
                this.aik.gZ();
            }
        }
        if ((i3 & 256) != 0 && this.aik != null) {
            u.ap(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.ahS = i2;
        if (this.aik != null) {
            this.aik.onWindowVisibilityChanged(i2);
        }
    }

    private static boolean a(View view, Rect rect, boolean z) {
        boolean z2 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z2 = true;
        }
        if (layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z2 = true;
        }
        if (layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z2 = true;
        }
        if (!z || layoutParams.bottomMargin == rect.bottom) {
            return z2;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        iz();
        u.ao(this);
        boolean a2 = a(this.ahU, rect, false);
        this.aig.set(rect);
        bh.a(this, this.aig, this.aic);
        if (!this.aih.equals(this.aig)) {
            this.aih.set(this.aig);
            a2 = true;
        }
        if (!this.aie.equals(this.aic)) {
            this.aie.set(this.aic);
            a2 = true;
        }
        if (a2) {
            requestLayout();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int measuredHeight;
        iz();
        measureChildWithMargins(this.ahU, i2, 0, i3, 0);
        LayoutParams layoutParams = (LayoutParams) this.ahU.getLayoutParams();
        int max = Math.max(0, this.ahU.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, layoutParams.bottomMargin + this.ahU.getMeasuredHeight() + layoutParams.topMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.ahU.getMeasuredState());
        boolean z = (u.ao(this) & 256) != 0;
        if (z) {
            measuredHeight = this.mActionBarHeight;
            if (this.ahY && this.ahU.getTabContainer() != null) {
                measuredHeight += this.mActionBarHeight;
            }
        } else {
            measuredHeight = this.ahU.getVisibility() != 8 ? this.ahU.getMeasuredHeight() : 0;
        }
        this.aif.set(this.aic);
        this.aii.set(this.aig);
        if (this.ahX || z) {
            Rect rect = this.aii;
            rect.top = measuredHeight + rect.top;
            this.aii.bottom += 0;
        } else {
            Rect rect2 = this.aif;
            rect2.top = measuredHeight + rect2.top;
            this.aif.bottom += 0;
        }
        a(this.ahT, this.aif, true);
        if (!this.aij.equals(this.aii)) {
            this.aij.set(this.aii);
            this.ahT.g(this.aii);
        }
        measureChildWithMargins(this.ahT, i2, 0, i3, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.ahT.getLayoutParams();
        int max3 = Math.max(max, this.ahT.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, layoutParams2.bottomMargin + this.ahT.getMeasuredHeight() + layoutParams2.topMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.ahT.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = layoutParams.leftMargin + paddingLeft;
                int i8 = layoutParams.topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.ahV != null && !this.ahW) {
            int bottom = this.ahU.getVisibility() == 0 ? (int) (((float) this.ahU.getBottom()) + this.ahU.getTranslationY() + 0.5f) : 0;
            this.ahV.setBounds(0, bottom, getWidth(), this.ahV.getIntrinsicHeight() + bottom);
            this.ahV.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.support.v4.view.m
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.ahU.getVisibility() != 0) {
            return false;
        }
        return this.aaK;
    }

    @Override // android.support.v4.view.m
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.UV.Qb = i2;
        this.aia = getActionBarHideOffset();
        iA();
        if (this.aik != null) {
            this.aik.ha();
        }
    }

    @Override // android.support.v4.view.m
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        this.aia += i3;
        setActionBarHideOffset(this.aia);
    }

    @Override // android.support.v4.view.m
    public void onStopNestedScroll(View view) {
        if (this.aaK && !this.ahZ) {
            if (this.aia <= this.ahU.getHeight()) {
                iA();
                postDelayed(this.aio, 600);
                return;
            }
            iA();
            postDelayed(this.aip, 600);
        }
    }

    @Override // android.support.v4.view.m
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        boolean z2 = false;
        if (!this.aaK || !z) {
            return false;
        }
        this.ail.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.ail.getFinalY() > this.ahU.getHeight()) {
            z2 = true;
        }
        if (z2) {
            iA();
            this.aip.run();
        } else {
            iA();
            this.aio.run();
        }
        this.ahZ = true;
        return true;
    }

    @Override // android.support.v4.view.m
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    @Override // android.support.v4.view.m
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.UV.Qb;
    }

    private void iz() {
        if (this.ahT == null) {
            this.ahT = (ContentFrameLayout) findViewById(R.id.c8);
            this.ahU = (ActionBarContainer) findViewById(R.id.c_);
            this.ZU = bb(findViewById(R.id.c7));
        }
    }

    private static u bb(View view) {
        if (view instanceof u) {
            return (u) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.aaK) {
            this.aaK = z;
            if (!z) {
                iA();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        if (this.ahU != null) {
            return -((int) this.ahU.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int i2) {
        iA();
        this.ahU.setTranslationY((float) (-Math.max(0, Math.min(i2, this.ahU.getHeight()))));
    }

    /* access modifiers changed from: package-private */
    public final void iA() {
        removeCallbacks(this.aio);
        removeCallbacks(this.aip);
        if (this.aim != null) {
            this.aim.cancel();
        }
    }

    @Override // android.support.v7.widget.t
    public void setWindowCallback(Window.Callback callback) {
        iz();
        this.ZU.setWindowCallback(callback);
    }

    @Override // android.support.v7.widget.t
    public void setWindowTitle(CharSequence charSequence) {
        iz();
        this.ZU.setWindowTitle(charSequence);
    }

    public CharSequence getTitle() {
        iz();
        return this.ZU.getTitle();
    }

    @Override // android.support.v7.widget.t
    public final void bw(int i2) {
        iz();
        switch (i2) {
            case 2:
            case 5:
            default:
                return;
            case 109:
                setOverlayMode(true);
                return;
        }
    }

    public void setUiOptions(int i2) {
    }

    public void setIcon(int i2) {
        iz();
        this.ZU.setIcon(i2);
    }

    public void setIcon(Drawable drawable) {
        iz();
        this.ZU.setIcon(drawable);
    }

    public void setLogo(int i2) {
        iz();
        this.ZU.setLogo(i2);
    }

    @Override // android.support.v7.widget.t
    public final boolean iB() {
        iz();
        return this.ZU.iB();
    }

    @Override // android.support.v7.widget.t
    public final boolean isOverflowMenuShowing() {
        iz();
        return this.ZU.isOverflowMenuShowing();
    }

    @Override // android.support.v7.widget.t
    public final boolean iC() {
        iz();
        return this.ZU.iC();
    }

    @Override // android.support.v7.widget.t
    public final boolean showOverflowMenu() {
        iz();
        return this.ZU.showOverflowMenu();
    }

    @Override // android.support.v7.widget.t
    public final boolean hideOverflowMenu() {
        iz();
        return this.ZU.hideOverflowMenu();
    }

    @Override // android.support.v7.widget.t
    public final void iD() {
        iz();
        this.ZU.iD();
    }

    @Override // android.support.v7.widget.t
    public final void a(Menu menu, o.a aVar) {
        iz();
        this.ZU.a(menu, aVar);
    }

    @Override // android.support.v7.widget.t
    public final void gM() {
        iz();
        this.ZU.dismissPopupMenus();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
