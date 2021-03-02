package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.design.a;
import android.support.v4.e.l;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.support.v4.view.r;
import android.support.v4.view.u;
import android.support.v7.a.a;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.bb;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.a
public class TabLayout extends HorizontalScrollView {
    private static final l.a<f> ug = new l.c(16);
    private int contentInsetStart;
    int mode;
    int uA;
    private final int uB;
    private final int uC;
    private final int uD;
    int uE;
    int uF;
    int uG;
    boolean uH;
    boolean uI;
    boolean uJ;
    private b uK;
    private final ArrayList<b> uL;
    private b uM;
    private ValueAnimator uN;
    ViewPager uO;
    private q uP;
    private DataSetObserver uQ;
    private g uR;
    private a uS;
    private boolean uT;
    private final l.a<h> uU;
    private final ArrayList<f> uh;
    private f uj;
    private final RectF uk;
    private final e ul;
    int um;
    int un;
    int uo;
    int up;
    int uq;
    ColorStateList ur;
    ColorStateList ut;
    ColorStateList uu;
    Drawable uv;
    PorterDuff.Mode uw;
    float ux;
    float uy;
    final int uz;

    public interface b<T extends f> {
        void i(T t);

        void j(T t);

        void k(T t);
    }

    public interface c extends b {
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.a19);
    }

    /* JADX INFO: finally extract failed */
    public TabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.uh = new ArrayList<>();
        this.uk = new RectF();
        this.uA = Integer.MAX_VALUE;
        this.uL = new ArrayList<>();
        this.uU = new l.b(12);
        setHorizontalScrollBarEnabled(false);
        this.ul = new e(context);
        super.addView(this.ul, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray a2 = android.support.design.internal.f.a(context, attributeSet, a.C0008a.TabLayout, i2, R.style.a3x, 22);
        this.ul.ai(a2.getDimensionPixelSize(10, -1));
        this.ul.ah(a2.getColor(7, 0));
        setSelectedTabIndicator(android.support.design.d.a.c(context, a2, 5));
        setSelectedTabIndicatorGravity(a2.getInt(9, 0));
        setTabIndicatorFullWidth(a2.getBoolean(8, true));
        int dimensionPixelSize = a2.getDimensionPixelSize(15, 0);
        this.up = dimensionPixelSize;
        this.uo = dimensionPixelSize;
        this.un = dimensionPixelSize;
        this.um = dimensionPixelSize;
        this.um = a2.getDimensionPixelSize(18, this.um);
        this.un = a2.getDimensionPixelSize(19, this.un);
        this.uo = a2.getDimensionPixelSize(17, this.uo);
        this.up = a2.getDimensionPixelSize(16, this.up);
        this.uq = a2.getResourceId(22, R.style.x4);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.uq, a.C0040a.TextAppearance);
        try {
            this.ux = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.ur = android.support.design.d.a.b(context, obtainStyledAttributes, 3);
            obtainStyledAttributes.recycle();
            if (a2.hasValue(23)) {
                this.ur = android.support.design.d.a.b(context, a2, 23);
            }
            if (a2.hasValue(21)) {
                int color = a2.getColor(21, 0);
                int defaultColor = this.ur.getDefaultColor();
                this.ur = new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{color, defaultColor});
            }
            this.ut = android.support.design.d.a.b(context, a2, 3);
            this.uw = android.support.design.internal.g.a(a2.getInt(4, -1), null);
            this.uu = android.support.design.d.a.b(context, a2, 20);
            this.uF = a2.getInt(6, 300);
            this.uB = a2.getDimensionPixelSize(13, -1);
            this.uC = a2.getDimensionPixelSize(12, -1);
            this.uz = a2.getResourceId(0, 0);
            this.contentInsetStart = a2.getDimensionPixelSize(1, 0);
            this.mode = a2.getInt(14, 1);
            this.uE = a2.getInt(2, 0);
            this.uH = a2.getBoolean(11, false);
            this.uJ = a2.getBoolean(24, false);
            a2.recycle();
            Resources resources = getResources();
            this.uy = (float) resources.getDimensionPixelSize(R.dimen.zy);
            this.uD = resources.getDimensionPixelSize(R.dimen.zw);
            dc();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.ul.ah(i2);
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.ul.ai(i2);
    }

    private void setScrollPosition$4867b5c2(int i2) {
        a(i2, 0.0f, true, true);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, float f2, boolean z, boolean z2) {
        int round = Math.round(((float) i2) + f2);
        if (round >= 0 && round < this.ul.getChildCount()) {
            if (z2) {
                this.ul.c(i2, f2);
            }
            if (this.uN != null && this.uN.isRunning()) {
                this.uN.cancel();
            }
            scrollTo(b(i2, f2), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    public final void a(f fVar) {
        a(fVar, this.uh.isEmpty());
    }

    public final void a(f fVar, int i2) {
        a(fVar, i2, this.uh.isEmpty());
    }

    public final void a(f fVar, boolean z) {
        a(fVar, this.uh.size(), z);
    }

    private void a(f fVar, int i2, boolean z) {
        if (fVar.vl != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        b(fVar, i2);
        d(fVar);
        if (z) {
            fVar.select();
        }
    }

    private void a(TabItem tabItem) {
        f cW = cW();
        if (tabItem.text != null) {
            cW.d(tabItem.text);
        }
        if (tabItem.icon != null) {
            cW.icon = tabItem.icon;
            cW.updateView();
        }
        if (tabItem.uf != 0) {
            cW.aj(tabItem.uf);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            cW.vj = tabItem.getContentDescription();
            cW.updateView();
        }
        a(cW);
    }

    @Deprecated
    public void setOnTabSelectedListener(b bVar) {
        if (this.uK != null) {
            b(this.uK);
        }
        this.uK = bVar;
        if (bVar != null) {
            a(bVar);
        }
    }

    public final void a(b bVar) {
        if (!this.uL.contains(bVar)) {
            this.uL.add(bVar);
        }
    }

    public final void b(b bVar) {
        this.uL.remove(bVar);
    }

    public final f cW() {
        f cX = cX();
        cX.vl = this;
        cX.vm = c(cX);
        return cX;
    }

    private static f cX() {
        f acquire = ug.acquire();
        if (acquire == null) {
            return new f();
        }
        return acquire;
    }

    private static boolean b(f fVar) {
        return ug.release(fVar);
    }

    public int getTabCount() {
        return this.uh.size();
    }

    public final f ab(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.uh.get(i2);
    }

    public int getSelectedTabPosition() {
        if (this.uj != null) {
            return this.uj.position;
        }
        return -1;
    }

    public final void removeTabAt(int i2) {
        f fVar;
        int i3 = this.uj != null ? this.uj.position : 0;
        ad(i2);
        f remove = this.uh.remove(i2);
        if (remove != null) {
            remove.reset();
            b(remove);
        }
        int size = this.uh.size();
        for (int i4 = i2; i4 < size; i4++) {
            this.uh.get(i4).position = i4;
        }
        if (i3 == i2) {
            if (this.uh.isEmpty()) {
                fVar = null;
            } else {
                fVar = this.uh.get(Math.max(0, i2 - 1));
            }
            b(fVar, true);
        }
    }

    private void removeAllTabs() {
        for (int childCount = this.ul.getChildCount() - 1; childCount >= 0; childCount--) {
            ad(childCount);
        }
        Iterator<f> it = this.uh.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.reset();
            b(next);
        }
        this.uj = null;
    }

    public void setTabMode(int i2) {
        if (i2 != this.mode) {
            this.mode = i2;
            dc();
        }
    }

    public int getTabMode() {
        return this.mode;
    }

    public void setTabGravity(int i2) {
        if (this.uE != i2) {
            this.uE = i2;
            dc();
        }
    }

    public int getTabGravity() {
        return this.uE;
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.uG != i2) {
            this.uG = i2;
            u.X(this.ul);
        }
    }

    public int getTabIndicatorGravity() {
        return this.uG;
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.uI = z;
        u.X(this.ul);
    }

    public void setInlineLabel(boolean z) {
        if (this.uH != z) {
            this.uH = z;
            for (int i2 = 0; i2 < this.ul.getChildCount(); i2++) {
                View childAt = this.ul.getChildAt(i2);
                if (childAt instanceof h) {
                    h hVar = (h) childAt;
                    hVar.setOrientation(TabLayout.this.uH ? 0 : 1);
                    if (hVar.vt == null && hVar.vu == null) {
                        hVar.a(hVar.vr, hVar.vs);
                    } else {
                        hVar.a(hVar.vt, hVar.vu);
                    }
                }
            }
            dc();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    public void setUnboundedRipple(boolean z) {
        if (this.uJ != z) {
            this.uJ = z;
            for (int i2 = 0; i2 < this.ul.getChildCount(); i2++) {
                View childAt = this.ul.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).J(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.ur != colorStateList) {
            this.ur = colorStateList;
            cZ();
        }
    }

    public ColorStateList getTabTextColors() {
        return this.ur;
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.ut != colorStateList) {
            this.ut = colorStateList;
            cZ();
        }
    }

    public void setTabIconTintResource(@android.support.annotation.a int i2) {
        setTabIconTint(android.support.v7.c.a.a.m(getContext(), i2));
    }

    public ColorStateList getTabIconTint() {
        return this.ut;
    }

    public ColorStateList getTabRippleColor() {
        return this.uu;
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.uu != colorStateList) {
            this.uu = colorStateList;
            for (int i2 = 0; i2 < this.ul.getChildCount(); i2++) {
                View childAt = this.ul.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).J(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@android.support.annotation.a int i2) {
        setTabRippleColor(android.support.v7.c.a.a.m(getContext(), i2));
    }

    public Drawable getTabSelectedIndicator() {
        return this.uv;
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.uv != drawable) {
            this.uv = drawable;
            u.X(this.ul);
        }
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(android.support.v7.c.a.a.l(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public final void a(ViewPager viewPager, boolean z, boolean z2) {
        if (this.uO != null) {
            if (this.uR != null) {
                this.uO.removeOnPageChangeListener(this.uR);
            }
            if (this.uS != null) {
                this.uO.removeOnAdapterChangeListener(this.uS);
            }
        }
        if (this.uM != null) {
            b(this.uM);
            this.uM = null;
        }
        if (viewPager != null) {
            this.uO = viewPager;
            if (this.uR == null) {
                this.uR = new g(this);
            }
            this.uR.reset();
            viewPager.addOnPageChangeListener(this.uR);
            this.uM = new i(viewPager);
            a(this.uM);
            q adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z);
            }
            if (this.uS == null) {
                this.uS = new a();
            }
            this.uS.uW = z;
            viewPager.addOnAdapterChangeListener(this.uS);
            setScrollPosition$4867b5c2(viewPager.getCurrentItem());
        } else {
            this.uO = null;
            a((q) null, false);
        }
        this.uT = z2;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(q qVar) {
        a(qVar, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.uO == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.uT) {
            setupWithViewPager(null);
            this.uT = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.ul.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    /* access modifiers changed from: package-private */
    public final void a(q qVar, boolean z) {
        if (!(this.uP == null || this.uQ == null)) {
            this.uP.unregisterDataSetObserver(this.uQ);
        }
        this.uP = qVar;
        if (z && qVar != null) {
            if (this.uQ == null) {
                this.uQ = new d();
            }
            qVar.registerDataSetObserver(this.uQ);
        }
        cY();
    }

    /* access modifiers changed from: package-private */
    public final void cY() {
        int currentItem;
        removeAllTabs();
        if (this.uP != null) {
            int count = this.uP.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                a(cW().d(this.uP.getPageTitle(i2)), false);
            }
            if (this.uO != null && count > 0 && (currentItem = this.uO.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                b(ab(currentItem), true);
            }
        }
    }

    private void cZ() {
        int size = this.uh.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.uh.get(i2).updateView();
        }
    }

    private h c(f fVar) {
        h acquire = this.uU != null ? this.uU.acquire() : null;
        if (acquire == null) {
            acquire = new h(getContext());
        }
        acquire.l(fVar);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(fVar.vj)) {
            acquire.setContentDescription(fVar.text);
        } else {
            acquire.setContentDescription(fVar.vj);
        }
        return acquire;
    }

    private void d(f fVar) {
        this.ul.addView(fVar.vm, fVar.position, da());
    }

    public void addView(View view) {
        z(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        z(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        z(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        z(view);
    }

    private void z(View view) {
        if (view instanceof TabItem) {
            a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private LinearLayout.LayoutParams da() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.mode == 1 && this.uE == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final int ac(int i2) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i2));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.ul.getChildCount(); i2++) {
            View childAt = this.ul.getChildAt(i2);
            if (childAt instanceof h) {
                h.a((h) childAt, canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z;
        int ac;
        boolean z2 = true;
        int ac2 = ac(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        switch (View.MeasureSpec.getMode(i3)) {
            case Integer.MIN_VALUE:
                i3 = View.MeasureSpec.makeMeasureSpec(Math.min(ac2, View.MeasureSpec.getSize(i3)), 1073741824);
                break;
            case 0:
                i3 = View.MeasureSpec.makeMeasureSpec(ac2, 1073741824);
                break;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            if (this.uC > 0) {
                ac = this.uC;
            } else {
                ac = size - ac(56);
            }
            this.uA = ac;
        }
        super.onMeasure(i2, i3);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.mode) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 1:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        z2 = false;
                    }
                    z = z2;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    private void ad(int i2) {
        h hVar = (h) this.ul.getChildAt(i2);
        this.ul.removeViewAt(i2);
        if (hVar != null) {
            hVar.reset();
            this.uU.release(hVar);
        }
        requestLayout();
    }

    private void ag(int i2) {
        boolean z;
        if (i2 != -1) {
            if (getWindowToken() != null && u.az(this)) {
                e eVar = this.ul;
                int childCount = eVar.getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        z = false;
                        break;
                    } else if (eVar.getChildAt(i3).getWidth() <= 0) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    int scrollX = getScrollX();
                    int b2 = b(i2, 0.0f);
                    if (scrollX != b2) {
                        db();
                        this.uN.setIntValues(scrollX, b2);
                        this.uN.start();
                    }
                    this.ul.r(i2, this.uF);
                    return;
                }
            }
            setScrollPosition$4867b5c2(i2);
        }
    }

    private void db() {
        if (this.uN == null) {
            this.uN = new ValueAnimator();
            this.uN.setInterpolator(android.support.design.a.a.gL);
            this.uN.setDuration((long) this.uF);
            this.uN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class android.support.design.widget.TabLayout.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        db();
        this.uN.addListener(animatorListener);
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.ul.getChildCount();
        if (i2 < childCount) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.ul.getChildAt(i3);
                childAt.setSelected(i3 == i2);
                childAt.setActivated(i3 == i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void e(f fVar) {
        b(fVar, true);
    }

    /* access modifiers changed from: package-private */
    public final void b(f fVar, boolean z) {
        int i2;
        f fVar2 = this.uj;
        if (fVar2 != fVar) {
            if (fVar != null) {
                i2 = fVar.position;
            } else {
                i2 = -1;
            }
            if (z) {
                if ((fVar2 == null || fVar2.position == -1) && i2 != -1) {
                    setScrollPosition$4867b5c2(i2);
                } else {
                    ag(i2);
                }
                if (i2 != -1) {
                    setSelectedTabView(i2);
                }
            }
            this.uj = fVar;
            if (fVar2 != null) {
                g(fVar2);
            }
            if (fVar != null) {
                f(fVar);
            }
        } else if (fVar2 != null) {
            h(fVar);
            ag(fVar.position);
        }
    }

    private void f(f fVar) {
        for (int size = this.uL.size() - 1; size >= 0; size--) {
            this.uL.get(size).i(fVar);
        }
    }

    private void g(f fVar) {
        for (int size = this.uL.size() - 1; size >= 0; size--) {
            this.uL.get(size).j(fVar);
        }
    }

    private void h(f fVar) {
        for (int size = this.uL.size() - 1; size >= 0; size--) {
            this.uL.get(size).k(fVar);
        }
    }

    private int b(int i2, float f2) {
        int i3;
        int i4 = 0;
        if (this.mode != 0) {
            return 0;
        }
        View childAt = this.ul.getChildAt(i2);
        View childAt2 = i2 + 1 < this.ul.getChildCount() ? this.ul.getChildAt(i2 + 1) : null;
        if (childAt != null) {
            i3 = childAt.getWidth();
        } else {
            i3 = 0;
        }
        if (childAt2 != null) {
            i4 = childAt2.getWidth();
        }
        int left = (childAt.getLeft() + (i3 / 2)) - (getWidth() / 2);
        int i5 = (int) (((float) (i4 + i3)) * 0.5f * f2);
        return u.Z(this) == 0 ? i5 + left : left - i5;
    }

    private void dc() {
        int i2;
        if (this.mode == 0) {
            i2 = Math.max(0, this.contentInsetStart - this.um);
        } else {
            i2 = 0;
        }
        u.d(this.ul, i2, 0, 0, 0);
        switch (this.mode) {
            case 0:
                this.ul.setGravity(8388611);
                break;
            case 1:
                this.ul.setGravity(1);
                break;
        }
        x(true);
    }

    /* access modifiers changed from: package-private */
    public final void x(boolean z) {
        for (int i2 = 0; i2 < this.ul.getChildCount(); i2++) {
            View childAt = this.ul.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    public static class f {
        Drawable icon;
        int position = -1;
        private Object tag;
        CharSequence text;
        CharSequence vj;
        public View vk;
        public TabLayout vl;
        public h vm;

        public final Object getTag() {
            return this.tag;
        }

        public final f g(Object obj) {
            this.tag = obj;
            return this;
        }

        public final View getCustomView() {
            return this.vk;
        }

        private f A(View view) {
            this.vk = view;
            updateView();
            return this;
        }

        public final f aj(int i2) {
            return A(LayoutInflater.from(this.vm.getContext()).inflate(i2, (ViewGroup) this.vm, false));
        }

        public final int getPosition() {
            return this.position;
        }

        public final f d(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.vj) && !TextUtils.isEmpty(charSequence)) {
                this.vm.setContentDescription(charSequence);
            }
            this.text = charSequence;
            updateView();
            return this;
        }

        public final void select() {
            if (this.vl == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.vl.e(this);
        }

        public final boolean isSelected() {
            if (this.vl != null) {
                return this.vl.getSelectedTabPosition() == this.position;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        /* access modifiers changed from: package-private */
        public final void updateView() {
            if (this.vm != null) {
                this.vm.update();
            }
        }

        /* access modifiers changed from: package-private */
        public final void reset() {
            this.vl = null;
            this.vm = null;
            this.tag = null;
            this.icon = null;
            this.text = null;
            this.vj = null;
            this.position = -1;
            this.vk = null;
        }
    }

    /* access modifiers changed from: package-private */
    public class h extends LinearLayout {
        private View vk;
        private f vq;
        TextView vr;
        ImageView vs;
        TextView vt;
        ImageView vu;
        private Drawable vv;
        private int vw = 2;

        public h(Context context) {
            super(context);
            int i2;
            J(context);
            u.d(this, TabLayout.this.um, TabLayout.this.un, TabLayout.this.uo, TabLayout.this.up);
            setGravity(17);
            if (TabLayout.this.uH) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            setOrientation(i2);
            setClickable(true);
            u.a(this, r.Y(getContext()));
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void J(Context context) {
            GradientDrawable gradientDrawable = null;
            if (TabLayout.this.uz != 0) {
                this.vv = android.support.v7.c.a.a.l(context, TabLayout.this.uz);
                if (this.vv != null && this.vv.isStateful()) {
                    this.vv.setState(getDrawableState());
                }
            } else {
                this.vv = null;
            }
            Drawable gradientDrawable2 = new GradientDrawable();
            ((GradientDrawable) gradientDrawable2).setColor(0);
            if (TabLayout.this.uu != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList b2 = android.support.design.e.a.b(TabLayout.this.uu);
                if (Build.VERSION.SDK_INT >= 21) {
                    if (TabLayout.this.uJ) {
                        gradientDrawable2 = null;
                    }
                    if (!TabLayout.this.uJ) {
                        gradientDrawable = gradientDrawable3;
                    }
                    gradientDrawable2 = new RippleDrawable(b2, gradientDrawable2, gradientDrawable);
                } else {
                    Drawable i2 = android.support.v4.graphics.drawable.a.i(gradientDrawable3);
                    android.support.v4.graphics.drawable.a.a(i2, b2);
                    gradientDrawable2 = new LayerDrawable(new Drawable[]{gradientDrawable2, i2});
                }
            }
            u.a(this, gradientDrawable2);
            TabLayout.this.invalidate();
        }

        /* access modifiers changed from: protected */
        public final void drawableStateChanged() {
            super.drawableStateChanged();
            boolean z = false;
            int[] drawableState = getDrawableState();
            if (this.vv != null && this.vv.isStateful()) {
                z = this.vv.setState(drawableState) | false;
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public final boolean performClick() {
            boolean performClick = super.performClick();
            if (this.vq == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.vq.select();
            return true;
        }

        public final void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            if (this.vr != null) {
                this.vr.setSelected(z);
            }
            if (this.vs != null) {
                this.vs.setSelected(z);
            }
            if (this.vk != null) {
                this.vk.setSelected(z);
            }
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.a.class.getName());
        }

        @TargetApi(14)
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.a.class.getName());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
            if (((r2 / r4.getPaint().getTextSize()) * r4.getLineWidth(0)) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) goto L_0x008a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onMeasure(int r9, int r10) {
            /*
            // Method dump skipped, instructions count: 172
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TabLayout.h.onMeasure(int, int):void");
        }

        /* access modifiers changed from: package-private */
        public final void l(f fVar) {
            if (fVar != this.vq) {
                this.vq = fVar;
                update();
            }
        }

        /* access modifiers changed from: package-private */
        public final void reset() {
            l(null);
            setSelected(false);
        }

        /* access modifiers changed from: package-private */
        public final void update() {
            View view;
            boolean z;
            f fVar = this.vq;
            if (fVar != null) {
                view = fVar.vk;
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.vk = view;
                if (this.vr != null) {
                    this.vr.setVisibility(8);
                }
                if (this.vs != null) {
                    this.vs.setVisibility(8);
                    this.vs.setImageDrawable(null);
                }
                this.vt = (TextView) view.findViewById(16908308);
                if (this.vt != null) {
                    this.vw = android.support.v4.widget.q.b(this.vt);
                }
                this.vu = (ImageView) view.findViewById(16908294);
            } else {
                if (this.vk != null) {
                    removeView(this.vk);
                    this.vk = null;
                }
                this.vt = null;
                this.vu = null;
            }
            if (this.vk == null) {
                if (this.vs == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.zb, (ViewGroup) this, false);
                    addView(imageView, 0);
                    this.vs = imageView;
                }
                Drawable mutate = (fVar == null || fVar.icon == null) ? null : android.support.v4.graphics.drawable.a.i(fVar.icon).mutate();
                if (mutate != null) {
                    android.support.v4.graphics.drawable.a.a(mutate, TabLayout.this.ut);
                    if (TabLayout.this.uw != null) {
                        android.support.v4.graphics.drawable.a.a(mutate, TabLayout.this.uw);
                    }
                }
                if (this.vr == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.zc, (ViewGroup) this, false);
                    addView(textView);
                    this.vr = textView;
                    this.vw = android.support.v4.widget.q.b(this.vr);
                }
                android.support.v4.widget.q.d(this.vr, TabLayout.this.uq);
                if (TabLayout.this.ur != null) {
                    this.vr.setTextColor(TabLayout.this.ur);
                }
                a(this.vr, this.vs);
            } else if (!(this.vt == null && this.vu == null)) {
                a(this.vt, this.vu);
            }
            if (fVar != null && !TextUtils.isEmpty(fVar.vj)) {
                setContentDescription(fVar.vj);
            }
            if (fVar == null || !fVar.isSelected()) {
                z = false;
            } else {
                z = true;
            }
            setSelected(z);
        }

        /* access modifiers changed from: package-private */
        public final void a(TextView textView, ImageView imageView) {
            CharSequence charSequence;
            boolean z;
            CharSequence charSequence2;
            int i2;
            CharSequence charSequence3 = null;
            Drawable mutate = (this.vq == null || this.vq.icon == null) ? null : android.support.v4.graphics.drawable.a.i(this.vq.icon).mutate();
            if (this.vq != null) {
                charSequence = this.vq.text;
            } else {
                charSequence = null;
            }
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            if (!TextUtils.isEmpty(charSequence)) {
                z = true;
            } else {
                z = false;
            }
            if (textView != null) {
                if (z) {
                    textView.setText(charSequence);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (!z || imageView.getVisibility() != 0) {
                    i2 = 0;
                } else {
                    i2 = TabLayout.this.ac(8);
                }
                if (TabLayout.this.uH) {
                    if (i2 != android.support.v4.view.g.b(marginLayoutParams)) {
                        android.support.v4.view.g.a(marginLayoutParams, i2);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (i2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i2;
                    android.support.v4.view.g.a(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            if (this.vq != null) {
                charSequence2 = this.vq.vj;
            } else {
                charSequence2 = null;
            }
            if (!z) {
                charSequence3 = charSequence2;
            }
            bb.a(this, charSequence3);
        }

        /* access modifiers changed from: package-private */
        public final int getContentWidth() {
            View[] viewArr = {this.vr, this.vs, this.vk};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getLeft()) : view.getLeft();
                    i2 = z ? Math.max(i2, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i2 - i3;
        }

        static /* synthetic */ void a(h hVar, Canvas canvas) {
            if (hVar.vv != null) {
                hVar.vv.setBounds(hVar.getLeft(), hVar.getTop(), hVar.getRight(), hVar.getBottom());
                hVar.vv.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class e extends LinearLayout {
        private int indicatorLeft = -1;
        private int indicatorRight = -1;
        private int layoutDirection = -1;
        private int uX;
        private final Paint uY;
        private final GradientDrawable uZ;
        int va = -1;
        float vb;
        private ValueAnimator vc;

        e(Context context) {
            super(context);
            setWillNotDraw(false);
            this.uY = new Paint();
            this.uZ = new GradientDrawable();
        }

        /* access modifiers changed from: package-private */
        public final void ah(int i2) {
            if (this.uY.getColor() != i2) {
                this.uY.setColor(i2);
                u.X(this);
            }
        }

        /* access modifiers changed from: package-private */
        public final void ai(int i2) {
            if (this.uX != i2) {
                this.uX = i2;
                u.X(this);
            }
        }

        /* access modifiers changed from: package-private */
        public final void c(int i2, float f2) {
            if (this.vc != null && this.vc.isRunning()) {
                this.vc.cancel();
            }
            this.va = i2;
            this.vb = f2;
            dd();
        }

        public final void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT < 23 && this.layoutDirection != i2) {
                requestLayout();
                this.layoutDirection = i2;
            }
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i2, int i3) {
            boolean z;
            boolean z2;
            int i4;
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) == 1073741824 && TabLayout.this.mode == 1 && TabLayout.this.uE == 1) {
                int childCount = getChildCount();
                int i5 = 0;
                int i6 = 0;
                while (i5 < childCount) {
                    View childAt = getChildAt(i5);
                    if (childAt.getVisibility() == 0) {
                        i4 = Math.max(i6, childAt.getMeasuredWidth());
                    } else {
                        i4 = i6;
                    }
                    i5++;
                    i6 = i4;
                }
                if (i6 > 0) {
                    if (i6 * childCount <= getMeasuredWidth() - (TabLayout.this.ac(16) * 2)) {
                        z = false;
                        for (int i7 = 0; i7 < childCount; i7++) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i7).getLayoutParams();
                            if (layoutParams.width == i6 && layoutParams.weight == 0.0f) {
                                z2 = z;
                            } else {
                                layoutParams.width = i6;
                                layoutParams.weight = 0.0f;
                                z2 = true;
                            }
                            z = z2;
                        }
                    } else {
                        TabLayout.this.uE = 0;
                        TabLayout.this.x(false);
                        z = true;
                    }
                    if (z) {
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            if (this.vc == null || !this.vc.isRunning()) {
                dd();
                return;
            }
            this.vc.cancel();
            r(this.va, Math.round(((float) this.vc.getDuration()) * (1.0f - this.vc.getAnimatedFraction())));
        }

        private void dd() {
            int i2;
            int i3;
            int i4;
            View childAt = getChildAt(this.va);
            if (childAt == null || childAt.getWidth() <= 0) {
                i2 = -1;
                i3 = -1;
            } else {
                i3 = childAt.getLeft();
                i2 = childAt.getRight();
                if (!TabLayout.this.uI && (childAt instanceof h)) {
                    a((h) childAt, TabLayout.this.uk);
                    i3 = (int) TabLayout.this.uk.left;
                    i2 = (int) TabLayout.this.uk.right;
                }
                if (this.vb > 0.0f && this.va < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.va + 1);
                    int left = childAt2.getLeft();
                    int right = childAt2.getRight();
                    if (TabLayout.this.uI || !(childAt2 instanceof h)) {
                        i4 = right;
                    } else {
                        a((h) childAt2, TabLayout.this.uk);
                        int i5 = (int) TabLayout.this.uk.left;
                        i4 = (int) TabLayout.this.uk.right;
                        left = i5;
                    }
                    i3 = (int) ((((float) i3) * (1.0f - this.vb)) + (this.vb * ((float) left)));
                    i2 = (int) ((((float) i4) * this.vb) + (((float) i2) * (1.0f - this.vb)));
                }
            }
            q(i3, i2);
        }

        /* access modifiers changed from: package-private */
        public final void q(int i2, int i3) {
            if (i2 != this.indicatorLeft || i3 != this.indicatorRight) {
                this.indicatorLeft = i2;
                this.indicatorRight = i3;
                u.X(this);
            }
        }

        /* access modifiers changed from: package-private */
        public final void r(final int i2, int i3) {
            if (this.vc != null && this.vc.isRunning()) {
                this.vc.cancel();
            }
            View childAt = getChildAt(i2);
            if (childAt == null) {
                dd();
                return;
            }
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (!TabLayout.this.uI && (childAt instanceof h)) {
                a((h) childAt, TabLayout.this.uk);
                left = (int) TabLayout.this.uk.left;
                right = (int) TabLayout.this.uk.right;
            }
            final int i4 = this.indicatorLeft;
            final int i5 = this.indicatorRight;
            if (i4 != left || i5 != right) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.vc = valueAnimator;
                valueAnimator.setInterpolator(android.support.design.a.a.gL);
                valueAnimator.setDuration((long) i3);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class android.support.design.widget.TabLayout.e.AnonymousClass1 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        e.this.q(android.support.design.a.a.b(i4, left, animatedFraction), android.support.design.a.a.b(i5, right, animatedFraction));
                    }
                });
                valueAnimator.addListener(new AnimatorListenerAdapter() {
                    /* class android.support.design.widget.TabLayout.e.AnonymousClass2 */

                    public final void onAnimationEnd(Animator animator) {
                        e.this.va = i2;
                        e.this.vb = 0.0f;
                    }
                });
                valueAnimator.start();
            }
        }

        private void a(h hVar, RectF rectF) {
            int contentWidth = hVar.getContentWidth();
            if (contentWidth < TabLayout.this.ac(24)) {
                contentWidth = TabLayout.this.ac(24);
            }
            int left = (hVar.getLeft() + hVar.getRight()) / 2;
            rectF.set((float) (left - (contentWidth / 2)), 0.0f, (float) ((contentWidth / 2) + left), 0.0f);
        }

        public final void draw(Canvas canvas) {
            int i2;
            int i3;
            if (TabLayout.this.uv != null) {
                i2 = TabLayout.this.uv.getIntrinsicHeight();
            } else {
                i2 = 0;
            }
            if (this.uX >= 0) {
                i2 = this.uX;
            }
            switch (TabLayout.this.uG) {
                case 0:
                    int height = getHeight() - i2;
                    i2 = getHeight();
                    i3 = height;
                    break;
                case 1:
                    i2 = (i2 + getHeight()) / 2;
                    i3 = (getHeight() - i2) / 2;
                    break;
                case 2:
                    i3 = 0;
                    break;
                case 3:
                    i2 = getHeight();
                    i3 = 0;
                    break;
                default:
                    i2 = 0;
                    i3 = 0;
                    break;
            }
            if (this.indicatorLeft >= 0 && this.indicatorRight > this.indicatorLeft) {
                Drawable i4 = android.support.v4.graphics.drawable.a.i(TabLayout.this.uv != null ? TabLayout.this.uv : this.uZ);
                i4.setBounds(this.indicatorLeft, i3, this.indicatorRight, i2);
                if (this.uY != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        i4.setColorFilter(this.uY.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        android.support.v4.graphics.drawable.a.a(i4, this.uY.getColor());
                    }
                }
                i4.draw(canvas);
            }
            super.draw(canvas);
        }
    }

    private int getDefaultHeight() {
        boolean z;
        int size = this.uh.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                f fVar = this.uh.get(i2);
                if (fVar != null && fVar.icon != null && !TextUtils.isEmpty(fVar.text)) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                z = false;
                break;
            }
        }
        if (!z || this.uH) {
            return 48;
        }
        return 72;
    }

    private int getTabMinWidth() {
        if (this.uB != -1) {
            return this.uB;
        }
        if (this.mode == 0) {
            return this.uD;
        }
        return 0;
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: package-private */
    public int getTabMaxWidth() {
        return this.uA;
    }

    public static class g implements ViewPager.OnPageChangeListener {
        private final WeakReference<TabLayout> vn;
        private int vo;
        private int vp;

        public g(TabLayout tabLayout) {
            this.vn = new WeakReference<>(tabLayout);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i2) {
            this.vo = this.vp;
            this.vp = i2;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i2, float f2, int i3) {
            boolean z = false;
            TabLayout tabLayout = this.vn.get();
            if (tabLayout != null) {
                boolean z2 = this.vp != 2 || this.vo == 1;
                if (!(this.vp == 2 && this.vo == 0)) {
                    z = true;
                }
                tabLayout.a(i2, f2, z2, z);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i2) {
            TabLayout tabLayout = this.vn.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i2 && i2 < tabLayout.getTabCount()) {
                tabLayout.b(tabLayout.ab(i2), this.vp == 0 || (this.vp == 2 && this.vo == 0));
            }
        }

        /* access modifiers changed from: package-private */
        public final void reset() {
            this.vp = 0;
            this.vo = 0;
        }
    }

    public static class i implements c {
        private final ViewPager uO;

        public i(ViewPager viewPager) {
            this.uO = viewPager;
        }

        @Override // android.support.design.widget.TabLayout.b
        public final void i(f fVar) {
            this.uO.setCurrentItem(fVar.position);
        }

        @Override // android.support.design.widget.TabLayout.b
        public final void j(f fVar) {
        }

        @Override // android.support.design.widget.TabLayout.b
        public final void k(f fVar) {
        }
    }

    /* access modifiers changed from: package-private */
    public class d extends DataSetObserver {
        d() {
        }

        public final void onChanged() {
            TabLayout.this.cY();
        }

        public final void onInvalidated() {
            TabLayout.this.cY();
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements ViewPager.c {
        boolean uW;

        a() {
        }

        @Override // android.support.v4.view.ViewPager.c
        public final void a(ViewPager viewPager, q qVar, q qVar2) {
            if (TabLayout.this.uO == viewPager) {
                TabLayout.this.a(qVar2, this.uW);
            }
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        a(viewPager, true, false);
    }

    private void b(f fVar, int i2) {
        fVar.position = i2;
        this.uh.add(i2, fVar);
        int size = this.uh.size();
        for (int i3 = i2 + 1; i3 < size; i3++) {
            this.uh.get(i3).position = i3;
        }
    }
}
