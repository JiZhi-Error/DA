package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends LinearLayoutCompat implements h.b, p {
    h aaQ;
    private Context ahr;
    private int aiD;
    private int aiS;
    ActionMenuPresenter aiT;
    private o.a aiU;
    h.a aiV;
    private boolean aiW;
    private int aiX;
    private int aiY;
    d aiZ;
    boolean aiu;

    public interface a {
        boolean hM();

        boolean hN();
    }

    public interface d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat
    public final /* synthetic */ LinearLayoutCompat.LayoutParams c(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return iJ();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat
    public final /* synthetic */ LinearLayoutCompat.LayoutParams iL() {
        return iJ();
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.aiD = (int) (56.0f * f2);
        this.aiY = (int) (f2 * 4.0f);
        this.ahr = context;
        this.aiS = 0;
    }

    public void setPopupTheme(int i2) {
        if (this.aiS != i2) {
            this.aiS = i2;
            if (i2 == 0) {
                this.ahr = getContext();
            } else {
                this.ahr = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public int getPopupTheme() {
        return this.aiS;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.aiT = actionMenuPresenter;
        this.aiT.a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aiT != null) {
            this.aiT.p(false);
            if (this.aiT.isOverflowMenuShowing()) {
                this.aiT.hideOverflowMenu();
                this.aiT.showOverflowMenu();
            }
        }
    }

    public void setOnMenuItemClickListener(d dVar) {
        this.aiZ = dVar;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02c7  */
    @Override // android.support.v7.widget.LinearLayoutCompat
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r33, int r34) {
        /*
        // Method dump skipped, instructions count: 870
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionMenuView.onMeasure(int, int):void");
    }

    static int f(View view, int i2, int i3, int i4, int i5) {
        boolean z;
        int i6;
        boolean z2 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4) - i5, View.MeasureSpec.getMode(i4));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        if (actionMenuItemView == null || !actionMenuItemView.hasText()) {
            z = false;
        } else {
            z = true;
        }
        if (i3 <= 0 || (z && i3 < 2)) {
            i6 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i3, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i6 = measuredWidth / i2;
            if (measuredWidth % i2 != 0) {
                i6++;
            }
            if (z && i6 < 2) {
                i6 = 2;
            }
        }
        if (!layoutParams.aja && z) {
            z2 = true;
        }
        layoutParams.ajd = z2;
        layoutParams.ajb = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i6 * i2, 1073741824), makeMeasureSpec);
        return i6;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        boolean z2;
        int i8;
        int width;
        int i9;
        if (!this.aiW) {
            super.onLayout(z, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i10 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i11 = 0;
        int paddingRight = ((i4 - i2) - getPaddingRight()) - getPaddingLeft();
        boolean z3 = false;
        boolean d2 = bh.d(this);
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.aja) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (bx(i12)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (d2) {
                        i9 = getPaddingLeft() + layoutParams.leftMargin;
                        width = i9 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i9 = width - measuredWidth;
                    }
                    int i13 = i10 - (measuredHeight / 2);
                    childAt.layout(i9, i13, width, measuredHeight + i13);
                    z2 = true;
                    i8 = paddingRight - measuredWidth;
                } else {
                    i8 = paddingRight - (layoutParams.rightMargin + (childAt.getMeasuredWidth() + layoutParams.leftMargin));
                    bx(i12);
                    z2 = z3;
                    i11++;
                }
            } else {
                z2 = z3;
                i8 = paddingRight;
            }
            i12++;
            z3 = z2;
            paddingRight = i8;
        }
        if (childCount != 1 || z3) {
            int i14 = i11 - (z3 ? 0 : 1);
            int max = Math.max(0, i14 > 0 ? paddingRight / i14 : 0);
            if (d2) {
                int width2 = getWidth() - getPaddingRight();
                int i15 = 0;
                while (i15 < childCount) {
                    View childAt2 = getChildAt(i15);
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() == 8 || layoutParams2.aja) {
                        i7 = width2;
                    } else {
                        int i16 = width2 - layoutParams2.rightMargin;
                        int measuredWidth2 = childAt2.getMeasuredWidth();
                        int measuredHeight2 = childAt2.getMeasuredHeight();
                        int i17 = i10 - (measuredHeight2 / 2);
                        childAt2.layout(i16 - measuredWidth2, i17, i16, measuredHeight2 + i17);
                        i7 = i16 - ((layoutParams2.leftMargin + measuredWidth2) + max);
                    }
                    i15++;
                    width2 = i7;
                }
                return;
            }
            int paddingLeft = getPaddingLeft();
            int i18 = 0;
            while (i18 < childCount) {
                View childAt3 = getChildAt(i18);
                LayoutParams layoutParams3 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8 || layoutParams3.aja) {
                    i6 = paddingLeft;
                } else {
                    int i19 = paddingLeft + layoutParams3.leftMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i20 = i10 - (measuredHeight3 / 2);
                    childAt3.layout(i19, i20, i19 + measuredWidth3, measuredHeight3 + i20);
                    i6 = layoutParams3.rightMargin + measuredWidth3 + max + i19;
                }
                i18++;
                paddingLeft = i6;
            }
            return;
        }
        View childAt4 = getChildAt(0);
        int measuredWidth4 = childAt4.getMeasuredWidth();
        int measuredHeight4 = childAt4.getMeasuredHeight();
        int i21 = ((i4 - i2) / 2) - (measuredWidth4 / 2);
        int i22 = i10 - (measuredHeight4 / 2);
        childAt4.layout(i21, i22, measuredWidth4 + i21, measuredHeight4 + i22);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.aiT;
        if (actionMenuPresenter.air != null) {
            actionMenuPresenter.air.setImageDrawable(drawable);
            return;
        }
        actionMenuPresenter.ait = true;
        actionMenuPresenter.ais = drawable;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.aiT;
        if (actionMenuPresenter.air != null) {
            return actionMenuPresenter.air.getDrawable();
        }
        if (actionMenuPresenter.ait) {
            return actionMenuPresenter.ais;
        }
        return null;
    }

    public void setOverflowReserved(boolean z) {
        this.aiu = z;
    }

    private static LayoutParams iJ() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.gravity = 16;
        return layoutParams;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected static LayoutParams b(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return iJ();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity > 0) {
            return layoutParams2;
        }
        layoutParams2.gravity = 16;
        return layoutParams2;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public static LayoutParams iK() {
        LayoutParams iJ = iJ();
        iJ.aja = true;
        return iJ;
    }

    @Override // android.support.v7.view.menu.h.b
    public final boolean f(j jVar) {
        return this.aaQ.a(jVar, (o) null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.support.v7.view.menu.p
    public final void a(h hVar) {
        this.aaQ = hVar;
    }

    public Menu getMenu() {
        o.a bVar;
        if (this.aaQ == null) {
            Context context = getContext();
            this.aaQ = new h(context);
            this.aaQ.a(new c());
            this.aiT = new ActionMenuPresenter(context);
            this.aiT.iF();
            ActionMenuPresenter actionMenuPresenter = this.aiT;
            if (this.aiU != null) {
                bVar = this.aiU;
            } else {
                bVar = new b();
            }
            actionMenuPresenter.afg = bVar;
            this.aaQ.a(this.aiT, this.ahr);
            this.aiT.a(this);
        }
        return this.aaQ;
    }

    public final void a(o.a aVar, h.a aVar2) {
        this.aiU = aVar;
        this.aiV = aVar2;
    }

    public final void dismissPopupMenus() {
        if (this.aiT != null) {
            this.aiT.iG();
        }
    }

    private boolean bx(int i2) {
        boolean z = false;
        if (i2 == 0) {
            return false;
        }
        View childAt = getChildAt(i2 - 1);
        View childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof a)) {
            z = ((a) childAt).hN() | false;
        }
        if (i2 <= 0 || !(childAt2 instanceof a)) {
            return z;
        }
        return ((a) childAt2).hM() | z;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.aiT.aiC = z;
    }

    /* access modifiers changed from: package-private */
    public class c implements h.a {
        c() {
        }

        @Override // android.support.v7.view.menu.h.a
        public final boolean a(h hVar, MenuItem menuItem) {
            return ActionMenuView.this.aiZ != null && ActionMenuView.this.aiZ.onMenuItemClick(menuItem);
        }

        @Override // android.support.v7.view.menu.h.a
        public final void b(h hVar) {
            if (ActionMenuView.this.aiV != null) {
                ActionMenuView.this.aiV.b(hVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements o.a {
        b() {
        }

        @Override // android.support.v7.view.menu.o.a
        public final void a(h hVar, boolean z) {
        }

        @Override // android.support.v7.view.menu.o.a
        public final boolean d(h hVar) {
            return false;
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty
        public boolean aja;
        @ViewDebug.ExportedProperty
        public int ajb;
        @ViewDebug.ExportedProperty
        public int ajc;
        @ViewDebug.ExportedProperty
        public boolean ajd;
        @ViewDebug.ExportedProperty
        public boolean aje;
        boolean jT;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.aja = layoutParams.aja;
        }

        public LayoutParams() {
            super(-2, -2);
            this.aja = false;
        }
    }
}
