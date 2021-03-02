package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.c.a;
import android.support.constraint.ConstraintLayout;
import android.support.v4.e.j;
import android.support.v4.e.l;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ac;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.u;
import android.support.v4.widget.h;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.mm.R;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tavkit.component.TAVExporter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements n {
    static final String qe;
    static final Class<?>[] qf = {Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<Behavior>>> qg = new ThreadLocal<>();
    static final Comparator<View> qh;
    private static final l.a<Rect> qi = new l.c(12);
    private boolean mIsAttachedToWindow;
    private final o qA;
    private final List<View> qj;
    private final h<View> qk;
    private final List<View> ql;
    private final List<View> qm;
    private final int[] qn;
    private boolean qo;
    private int[] qp;
    private View qr;
    private View qs;
    private e qt;
    private boolean qu;
    ac qv;
    boolean qw;
    private Drawable qx;
    ViewGroup.OnHierarchyChangeListener qy;
    private p qz;

    public interface a {
        Behavior getBehavior();
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        Class<? extends Behavior> value();
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        qe = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            qh = new f();
        } else {
            qh = null;
        }
    }

    private static Rect cv() {
        Rect acquire = qi.acquire();
        if (acquire == null) {
            return new Rect();
        }
        return acquire;
    }

    private static void a(Rect rect) {
        rect.setEmpty();
        qi.release(rect);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.i9);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes;
        this.qj = new ArrayList();
        this.qk = new h<>();
        this.ql = new ArrayList();
        this.qm = new ArrayList();
        this.qn = new int[2];
        this.qA = new o(this);
        if (i2 == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0006a.CoordinatorLayout, 0, R.style.a4z);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0006a.CoordinatorLayout, i2, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.qp = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.qp.length;
            for (int i3 = 0; i3 < length; i3++) {
                int[] iArr = this.qp;
                iArr[i3] = (int) (((float) iArr[i3]) * f2);
            }
        }
        this.qx = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        cx();
        super.setOnHierarchyChangeListener(new c());
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.qy = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        w(false);
        if (this.qu) {
            if (this.qt == null) {
                this.qt = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.qt);
        }
        if (this.qv == null && u.aq(this)) {
            u.ap(this);
        }
        this.mIsAttachedToWindow = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w(false);
        if (this.qu && this.qt != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.qt);
        }
        if (this.qs != null) {
            onStopNestedScroll(this.qs);
        }
        this.mIsAttachedToWindow = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.qx != drawable) {
            if (this.qx != null) {
                this.qx.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.qx = drawable2;
            if (this.qx != null) {
                if (this.qx.isStateful()) {
                    this.qx.setState(getDrawableState());
                }
                android.support.v4.graphics.drawable.a.b(this.qx, u.Z(this));
                this.qx.setVisible(getVisibility() == 0, false);
                this.qx.setCallback(this);
            }
            u.X(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.qx;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        boolean z = false;
        Drawable drawable = this.qx;
        if (drawable != null && drawable.isStateful()) {
            z = drawable.setState(drawableState) | false;
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.qx;
    }

    public void setVisibility(int i2) {
        boolean z;
        super.setVisibility(i2);
        if (i2 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.qx != null && this.qx.isVisible() != z) {
            this.qx.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(int i2) {
        setStatusBarBackground(i2 != 0 ? android.support.v4.content.b.l(getContext(), i2) : null);
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public final ac getLastWindowInsets() {
        return this.qv;
    }

    private void w(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Behavior behavior = ((d) childAt.getLayoutParams()).qC;
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    behavior.b(this, childAt, obtain);
                } else {
                    behavior.a(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((d) getChildAt(i3).getLayoutParams()).qM = false;
        }
        this.qr = null;
        this.qo = false;
    }

    private boolean a(MotionEvent motionEvent, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        MotionEvent motionEvent2;
        int i3;
        boolean z4 = false;
        boolean z5 = false;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.ql;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            if (isChildrenDrawingOrderEnabled) {
                i3 = getChildDrawingOrder(childCount, i4);
            } else {
                i3 = i4;
            }
            list.add(getChildAt(i3));
        }
        if (qh != null) {
            Collections.sort(list, qh);
        }
        int size = list.size();
        int i5 = 0;
        MotionEvent motionEvent3 = null;
        while (true) {
            if (i5 < size) {
                View view = list.get(i5);
                d dVar = (d) view.getLayoutParams();
                Behavior behavior = dVar.qC;
                if (!(z4 || z5) || actionMasked == 0) {
                    if (!z4 && behavior != null) {
                        switch (i2) {
                            case 0:
                                z4 = behavior.b(this, view, motionEvent);
                                break;
                            case 1:
                                z4 = behavior.a(this, view, motionEvent);
                                break;
                        }
                        if (z4) {
                            this.qr = view;
                        }
                    }
                    z = z4;
                    if (dVar.qC == null) {
                        dVar.qM = false;
                    }
                    boolean z6 = dVar.qM;
                    if (dVar.qM) {
                        z2 = true;
                    } else {
                        boolean z7 = dVar.qM | false;
                        dVar.qM = z7;
                        z2 = z7;
                    }
                    z3 = z2 && !z6;
                    if (!z2 || z3) {
                        motionEvent2 = motionEvent3;
                    }
                } else if (behavior != null) {
                    if (motionEvent3 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    } else {
                        motionEvent2 = motionEvent3;
                    }
                    switch (i2) {
                        case 0:
                            behavior.b(this, view, motionEvent2);
                            z3 = z5;
                            z = z4;
                            break;
                        case 1:
                            behavior.a(this, view, motionEvent2);
                        default:
                            z3 = z5;
                            z = z4;
                            break;
                    }
                } else {
                    motionEvent2 = motionEvent3;
                    z3 = z5;
                    z = z4;
                }
                i5++;
                motionEvent3 = motionEvent2;
                z5 = z3;
                z4 = z;
            } else {
                z = z4;
            }
        }
        list.clear();
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            w(true);
        }
        boolean a2 = a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            w(true);
        }
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r12) {
        /*
            r11 = this;
            r4 = 3
            r10 = 1
            r5 = 0
            r7 = 0
            r2 = 0
            int r9 = r12.getActionMasked()
            android.view.View r0 = r11.qr
            if (r0 != 0) goto L_0x0055
            boolean r0 = r11.a(r12, r10)
            if (r0 == 0) goto L_0x0052
            r1 = r0
        L_0x0014:
            android.view.View r0 = r11.qr
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.support.design.widget.CoordinatorLayout$d r0 = (android.support.design.widget.CoordinatorLayout.d) r0
            android.support.design.widget.CoordinatorLayout$Behavior r0 = r0.qC
            if (r0 == 0) goto L_0x0050
            android.view.View r3 = r11.qr
            boolean r0 = r0.a(r11, r3, r12)
            r8 = r0
        L_0x0027:
            android.view.View r0 = r11.qr
            if (r0 != 0) goto L_0x003e
            boolean r0 = super.onTouchEvent(r12)
            r8 = r8 | r0
            r0 = r2
        L_0x0031:
            if (r0 == 0) goto L_0x0036
            r0.recycle()
        L_0x0036:
            if (r9 == r10) goto L_0x003a
            if (r9 != r4) goto L_0x003d
        L_0x003a:
            r11.w(r7)
        L_0x003d:
            return r8
        L_0x003e:
            if (r1 == 0) goto L_0x004e
            long r0 = android.os.SystemClock.uptimeMillis()
            r2 = r0
            r6 = r5
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r0, r2, r4, r5, r6, r7)
            super.onTouchEvent(r0)
            goto L_0x0031
        L_0x004e:
            r0 = r2
            goto L_0x0031
        L_0x0050:
            r8 = r7
            goto L_0x0027
        L_0x0052:
            r1 = r0
            r8 = r7
            goto L_0x0027
        L_0x0055:
            r1 = r7
            goto L_0x0014
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.qo) {
            w(false);
            this.qo = true;
        }
    }

    private int R(int i2) {
        if (this.qp == null) {
            new StringBuilder("No keylines defined for ").append(this).append(" - attempted index lookup ").append(i2);
            return 0;
        } else if (i2 >= 0 && i2 < this.qp.length) {
            return this.qp[i2];
        } else {
            new StringBuilder("Keyline index ").append(i2).append(" out of range for ").append(this);
            return 0;
        }
    }

    static Behavior a(Context context, AttributeSet attributeSet, String str) {
        HashMap hashMap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(qe)) {
            str = qe + '.' + str;
        }
        try {
            Map<String, Constructor<Behavior>> map = qg.get();
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                qg.set(hashMap2);
                hashMap = hashMap2;
            } else {
                hashMap = map;
            }
            Constructor<Behavior> constructor = hashMap.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(qf);
                constructor.setAccessible(true);
                hashMap.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass ".concat(String.valueOf(str)), e2);
        }
    }

    private static d r(View view) {
        d dVar = (d) view.getLayoutParams();
        if (!dVar.qD) {
            if (view instanceof a) {
                dVar.a(((a) view).getBehavior());
                dVar.qD = true;
            } else {
                b bVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    bVar = (b) cls.getAnnotation(b.class);
                    if (bVar != null) {
                        break;
                    }
                }
                if (bVar != null) {
                    try {
                        dVar.a((Behavior) bVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        new StringBuilder("Default behavior class ").append(bVar.value().getName()).append(" could not be instantiated. Did you forget a default constructor?");
                    }
                }
                dVar.qD = true;
            }
        }
        return dVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00be, code lost:
        if (r0 == false) goto L_0x00c0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x019a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cw() {
        /*
        // Method dump skipped, instructions count: 437
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.cw():void");
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public final void a(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z4;
        cw();
        int childCount = getChildCount();
        int i9 = 0;
        while (true) {
            if (i9 >= childCount) {
                z = false;
                break;
            }
            View childAt = getChildAt(i9);
            h<View> hVar = this.qk;
            int size = hVar.Tx.size();
            int i10 = 0;
            while (true) {
                if (i10 < size) {
                    ArrayList<T> valueAt = hVar.Tx.valueAt(i10);
                    if (valueAt != null && valueAt.contains(childAt)) {
                        z4 = true;
                        break;
                    }
                    i10++;
                } else {
                    z4 = false;
                    break;
                }
            }
            if (z4) {
                z = true;
                break;
            }
            i9++;
        }
        if (z != this.qu) {
            if (z) {
                if (this.mIsAttachedToWindow) {
                    if (this.qt == null) {
                        this.qt = new e();
                    }
                    getViewTreeObserver().addOnPreDrawListener(this.qt);
                }
                this.qu = true;
            } else {
                if (this.mIsAttachedToWindow && this.qt != null) {
                    getViewTreeObserver().removeOnPreDrawListener(this.qt);
                }
                this.qu = false;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int Z = u.Z(this);
        if (Z == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size3 = View.MeasureSpec.getSize(i3);
        int i11 = paddingLeft + paddingRight;
        int i12 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int i13 = 0;
        if (this.qv == null || !u.aq(this)) {
            z3 = false;
        } else {
            z3 = true;
        }
        int size4 = this.qj.size();
        int i14 = 0;
        while (i14 < size4) {
            View view = this.qj.get(i14);
            if (view.getVisibility() != 8) {
                d dVar = (d) view.getLayoutParams();
                int i15 = 0;
                if (dVar.qE >= 0 && mode != 0) {
                    int R = R(dVar.qE);
                    int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(T(dVar.gravity), Z) & 7;
                    if ((absoluteGravity == 3 && !z2) || (absoluteGravity == 5 && z2)) {
                        i15 = Math.max(0, (size2 - paddingRight) - R);
                    } else if ((absoluteGravity == 5 && !z2) || (absoluteGravity == 3 && z2)) {
                        i15 = Math.max(0, R - paddingLeft);
                    }
                }
                if (!z3 || u.aq(view)) {
                    i7 = i3;
                    i8 = i2;
                } else {
                    int systemWindowInsetLeft = this.qv.getSystemWindowInsetLeft() + this.qv.getSystemWindowInsetRight();
                    int systemWindowInsetTop = this.qv.getSystemWindowInsetTop() + this.qv.getSystemWindowInsetBottom();
                    i8 = View.MeasureSpec.makeMeasureSpec(size2 - systemWindowInsetLeft, mode);
                    i7 = View.MeasureSpec.makeMeasureSpec(size3 - systemWindowInsetTop, mode2);
                }
                Behavior behavior = dVar.qC;
                if (behavior == null || !behavior.a(this, view, i8, i15, i7, 0)) {
                    a(view, i8, i15, i7, 0);
                }
                int max = Math.max(suggestedMinimumWidth, view.getMeasuredWidth() + i11 + dVar.leftMargin + dVar.rightMargin);
                i5 = Math.max(suggestedMinimumHeight, view.getMeasuredHeight() + i12 + dVar.topMargin + dVar.bottomMargin);
                i4 = View.combineMeasuredStates(i13, view.getMeasuredState());
                i6 = max;
            } else {
                i4 = i13;
                i5 = suggestedMinimumHeight;
                i6 = suggestedMinimumWidth;
            }
            i14++;
            i13 = i4;
            suggestedMinimumHeight = i5;
            suggestedMinimumWidth = i6;
        }
        setMeasuredDimension(View.resolveSizeAndState(suggestedMinimumWidth, i2, -16777216 & i13), View.resolveSizeAndState(suggestedMinimumHeight, i3, i13 << 16));
    }

    public final void g(View view, int i2) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.cy()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (dVar.qK != null) {
            a(view, dVar.qK, i2);
        } else if (dVar.qE >= 0) {
            c(view, dVar.qE, i2);
        } else {
            h(view, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Behavior behavior;
        int Z = u.Z(this);
        int size = this.qj.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.qj.get(i6);
            if (view.getVisibility() != 8 && ((behavior = ((d) view.getLayoutParams()).qC) == null || !behavior.a(this, view, Z))) {
                g(view, Z);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.qw && this.qx != null) {
            int systemWindowInsetTop = this.qv != null ? this.qv.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.qx.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.qx.draw(canvas);
            }
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        cx();
    }

    private void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            android.support.v4.widget.u.a(this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private static void a(int i2, Rect rect, Rect rect2, d dVar, int i3, int i4) {
        int width;
        int height;
        int i5 = dVar.gravity;
        if (i5 == 0) {
            i5 = 17;
        }
        int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(i5, i2);
        int absoluteGravity2 = android.support.v4.view.d.getAbsoluteGravity(S(dVar.anchorGravity), i2);
        int i6 = absoluteGravity & 7;
        int i7 = absoluteGravity & 112;
        int i8 = absoluteGravity2 & 112;
        switch (absoluteGravity2 & 7) {
            case 1:
                width = (rect.width() / 2) + rect.left;
                break;
            case 5:
                width = rect.right;
                break;
            default:
                width = rect.left;
                break;
        }
        switch (i8) {
            case 16:
                height = rect.top + (rect.height() / 2);
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                height = rect.bottom;
                break;
            default:
                height = rect.top;
                break;
        }
        switch (i6) {
            case 1:
                width -= i3 / 2;
                break;
            case 5:
                break;
            default:
                width -= i3;
                break;
        }
        switch (i7) {
            case 16:
                height -= i4 / 2;
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                break;
            default:
                height -= i4;
                break;
        }
        rect2.set(width, height, width + i3, height + i4);
    }

    private void a(d dVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - dVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + dVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - dVar.bottomMargin));
        rect.set(max, max2, max + i2, max2 + i3);
    }

    private void a(View view, int i2, Rect rect, Rect rect2) {
        d dVar = (d) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(i2, rect, rect2, dVar, measuredWidth, measuredHeight);
        a(dVar, rect2, measuredWidth, measuredHeight);
    }

    private void a(View view, View view2, int i2) {
        Rect cv = cv();
        Rect cv2 = cv();
        try {
            android.support.v4.widget.u.a(this, view2, cv);
            a(view, i2, cv, cv2);
            view.layout(cv2.left, cv2.top, cv2.right, cv2.bottom);
        } finally {
            a(cv);
            a(cv2);
        }
    }

    private void c(View view, int i2, int i3) {
        d dVar = (d) view.getLayoutParams();
        int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(T(dVar.gravity), i3);
        int i4 = absoluteGravity & 7;
        int i5 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i3 == 1) {
            i2 = width - i2;
        }
        int R = R(i2) - measuredWidth;
        int i6 = 0;
        switch (i4) {
            case 1:
                R += measuredWidth / 2;
                break;
            case 5:
                R += measuredWidth;
                break;
        }
        switch (i5) {
            case 16:
                i6 = (measuredHeight / 2) + 0;
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                i6 = measuredHeight + 0;
                break;
        }
        int max = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(R, ((width - getPaddingRight()) - measuredWidth) - dVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + dVar.topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - dVar.bottomMargin));
        view.layout(max, max2, max + measuredWidth, max2 + measuredHeight);
    }

    private void h(View view, int i2) {
        d dVar = (d) view.getLayoutParams();
        Rect cv = cv();
        cv.set(getPaddingLeft() + dVar.leftMargin, getPaddingTop() + dVar.topMargin, (getWidth() - getPaddingRight()) - dVar.rightMargin, (getHeight() - getPaddingBottom()) - dVar.bottomMargin);
        if (this.qv != null && u.aq(this) && !u.aq(view)) {
            cv.left += this.qv.getSystemWindowInsetLeft();
            cv.top += this.qv.getSystemWindowInsetTop();
            cv.right -= this.qv.getSystemWindowInsetRight();
            cv.bottom -= this.qv.getSystemWindowInsetBottom();
        }
        Rect cv2 = cv();
        android.support.v4.view.d.apply(S(dVar.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), cv, cv2, i2);
        view.layout(cv2.left, cv2.top, cv2.right, cv2.bottom);
        a(cv);
        a(cv2);
    }

    private static int S(int i2) {
        int i3;
        if ((i2 & 7) == 0) {
            i3 = 8388611 | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 112) == 0) {
            return i3 | 48;
        }
        return i3;
    }

    private static int T(int i2) {
        if (i2 == 0) {
            return 8388661;
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        view.getLayoutParams();
        return super.drawChild(canvas, view, j2);
    }

    /* access modifiers changed from: package-private */
    public final void U(int i2) {
        boolean z;
        boolean z2;
        int width;
        int i3;
        int height;
        int i4;
        Behavior behavior;
        int Z = u.Z(this);
        int size = this.qj.size();
        Rect cv = cv();
        Rect cv2 = cv();
        Rect cv3 = cv();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.qj.get(i5);
            d dVar = (d) view.getLayoutParams();
            if (i2 != 0 || view.getVisibility() != 8) {
                for (int i6 = 0; i6 < i5; i6++) {
                    if (dVar.qL == this.qj.get(i6)) {
                        d dVar2 = (d) view.getLayoutParams();
                        if (dVar2.qK != null) {
                            Rect cv4 = cv();
                            Rect cv5 = cv();
                            Rect cv6 = cv();
                            android.support.v4.widget.u.a(this, dVar2.qK, cv4);
                            a(view, false, cv5);
                            int measuredWidth = view.getMeasuredWidth();
                            int measuredHeight = view.getMeasuredHeight();
                            a(Z, cv4, cv6, dVar2, measuredWidth, measuredHeight);
                            boolean z3 = (cv6.left == cv5.left && cv6.top == cv5.top) ? false : true;
                            a(dVar2, cv6, measuredWidth, measuredHeight);
                            int i7 = cv6.left - cv5.left;
                            int i8 = cv6.top - cv5.top;
                            if (i7 != 0) {
                                u.u(view, i7);
                            }
                            if (i8 != 0) {
                                u.s(view, i8);
                            }
                            if (z3 && (behavior = dVar2.qC) != null) {
                                behavior.a(this, view, dVar2.qK);
                            }
                            a(cv4);
                            a(cv5);
                            a(cv6);
                        }
                    }
                }
                a(view, true, cv2);
                if (dVar.qG != 0 && !cv2.isEmpty()) {
                    int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(dVar.qG, Z);
                    switch (absoluteGravity & 112) {
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            cv.top = Math.max(cv.top, cv2.bottom);
                            break;
                        case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                            cv.bottom = Math.max(cv.bottom, getHeight() - cv2.top);
                            break;
                    }
                    switch (absoluteGravity & 7) {
                        case 3:
                            cv.left = Math.max(cv.left, cv2.right);
                            break;
                        case 5:
                            cv.right = Math.max(cv.right, getWidth() - cv2.left);
                            break;
                    }
                }
                if (dVar.qH != 0 && view.getVisibility() == 0 && u.az(view) && view.getWidth() > 0 && view.getHeight() > 0) {
                    d dVar3 = (d) view.getLayoutParams();
                    Behavior behavior2 = dVar3.qC;
                    Rect cv7 = cv();
                    Rect cv8 = cv();
                    cv8.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                    if (behavior2 == null || !behavior2.a(this, view, cv7)) {
                        cv7.set(cv8);
                    } else if (!cv8.contains(cv7)) {
                        throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + cv7.toShortString() + " | Bounds:" + cv8.toShortString());
                    }
                    a(cv8);
                    if (!cv7.isEmpty()) {
                        int absoluteGravity2 = android.support.v4.view.d.getAbsoluteGravity(dVar3.qH, Z);
                        boolean z4 = false;
                        if ((absoluteGravity2 & 48) == 48 && (i4 = (cv7.top - dVar3.topMargin) - dVar3.qJ) < cv.top) {
                            j(view, cv.top - i4);
                            z4 = true;
                        }
                        if ((absoluteGravity2 & 80) == 80 && (height = ((getHeight() - cv7.bottom) - dVar3.bottomMargin) + dVar3.qJ) < cv.bottom) {
                            j(view, height - cv.bottom);
                            z4 = true;
                        }
                        if (!z4) {
                            j(view, 0);
                        }
                        boolean z5 = false;
                        if ((absoluteGravity2 & 3) == 3 && (i3 = (cv7.left - dVar3.leftMargin) - dVar3.qI) < cv.left) {
                            i(view, cv.left - i3);
                            z5 = true;
                        }
                        if ((absoluteGravity2 & 5) != 5 || (width = dVar3.qI + ((getWidth() - cv7.right) - dVar3.rightMargin)) >= cv.right) {
                            z2 = z5;
                        } else {
                            i(view, width - cv.right);
                            z2 = true;
                        }
                        if (!z2) {
                            i(view, 0);
                        }
                    }
                    a(cv7);
                }
                if (i2 != 2) {
                    cv3.set(((d) view.getLayoutParams()).qQ);
                    if (!cv3.equals(cv2)) {
                        ((d) view.getLayoutParams()).qQ.set(cv2);
                    }
                }
                for (int i9 = i5 + 1; i9 < size; i9++) {
                    View view2 = this.qj.get(i9);
                    d dVar4 = (d) view2.getLayoutParams();
                    Behavior behavior3 = dVar4.qC;
                    if (behavior3 != null && behavior3.a(view2, view)) {
                        if (i2 != 0 || !dVar4.qP) {
                            switch (i2) {
                                case 2:
                                    z = true;
                                    break;
                                default:
                                    z = behavior3.a(this, view2, view);
                                    break;
                            }
                            if (i2 == 1) {
                                dVar4.qP = z;
                            }
                        } else {
                            dVar4.qP = false;
                        }
                    }
                }
            }
        }
        a(cv);
        a(cv2);
        a(cv3);
    }

    private static void i(View view, int i2) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.qI != i2) {
            u.u(view, i2 - dVar.qI);
            dVar.qI = i2;
        }
    }

    private static void j(View view, int i2) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.qJ != i2) {
            u.s(view, i2 - dVar.qJ);
            dVar.qJ = i2;
        }
    }

    public final void s(View view) {
        List J = this.qk.J(view);
        if (!(J == null || J.isEmpty())) {
            for (int i2 = 0; i2 < J.size(); i2++) {
                View view2 = (View) J.get(i2);
                Behavior behavior = ((d) view2.getLayoutParams()).qC;
                if (behavior != null) {
                    behavior.a(this, view2, view);
                }
            }
        }
    }

    public final List<View> t(View view) {
        List<View> K = this.qk.K(view);
        this.qm.clear();
        if (K != null) {
            this.qm.addAll(K);
        }
        return this.qm;
    }

    public final List<View> u(View view) {
        List J = this.qk.J(view);
        this.qm.clear();
        if (J != null) {
            this.qm.addAll(J);
        }
        return this.qm;
    }

    /* access modifiers changed from: package-private */
    public final List<View> getDependencySortedChildren() {
        cw();
        return Collections.unmodifiableList(this.qj);
    }

    public final boolean d(View view, int i2, int i3) {
        Rect cv = cv();
        android.support.v4.widget.u.a(this, view, cv);
        try {
            return cv.contains(i2, i3);
        } finally {
            a(cv);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.support.v4.view.m
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return a(view, view2, i2, 0);
    }

    @Override // android.support.v4.view.n
    public final boolean a(View view, View view2, int i2, int i3) {
        boolean z;
        boolean z2 = false;
        int childCount = getChildCount();
        int i4 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                Behavior behavior = dVar.qC;
                if (behavior != null) {
                    boolean a2 = behavior.a(this, childAt, view, view2, i2, i3);
                    z = z2 | a2;
                    dVar.d(i3, a2);
                    i4++;
                    z2 = z;
                } else {
                    dVar.d(i3, false);
                }
            }
            z = z2;
            i4++;
            z2 = z;
        }
        return z2;
    }

    @Override // android.support.v4.view.m
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        b(view, view2, i2, 0);
    }

    @Override // android.support.v4.view.n
    public final void b(View view, View view2, int i2, int i3) {
        this.qA.Qb = i2;
        this.qs = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            getChildAt(i4).getLayoutParams();
        }
    }

    @Override // android.support.v4.view.m
    public void onStopNestedScroll(View view) {
        k(view, 0);
    }

    @Override // android.support.v4.view.n
    public final void k(View view, int i2) {
        this.qA.Qb = 0;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.V(i2)) {
                Behavior behavior = dVar.qC;
                if (behavior != null) {
                    behavior.a(this, childAt, view, i2);
                }
                dVar.d(i2, false);
                dVar.qP = false;
            }
        }
        this.qs = null;
    }

    @Override // android.support.v4.view.m
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        a(view, i2, i3, i4, i5, 0);
    }

    @Override // android.support.v4.view.n
    public final void a(View view, int i2, int i3, int i4, int i5, int i6) {
        boolean z;
        Behavior behavior;
        int childCount = getChildCount();
        boolean z2 = false;
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.V(i6) && (behavior = dVar.qC) != null) {
                    behavior.a(this, childAt, view, i2, i3, i4, i5, i6);
                    z = true;
                    i7++;
                    z2 = z;
                }
            }
            z = z2;
            i7++;
            z2 = z;
        }
        if (z2) {
            U(1);
        }
    }

    @Override // android.support.v4.view.m
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        a(view, i2, i3, iArr, 0);
    }

    @Override // android.support.v4.view.n
    public final void a(View view, int i2, int i3, int[] iArr, int i4) {
        int i5;
        int i6;
        Behavior behavior;
        int i7 = 0;
        int i8 = 0;
        boolean z = false;
        int childCount = getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.V(i4) && (behavior = dVar.qC) != null) {
                    int[] iArr2 = this.qn;
                    this.qn[1] = 0;
                    iArr2[0] = 0;
                    behavior.a(this, childAt, view, i2, i3, this.qn, i4);
                    if (i2 > 0) {
                        i6 = Math.max(i7, this.qn[0]);
                    } else {
                        i6 = Math.min(i7, this.qn[0]);
                    }
                    if (i3 > 0) {
                        i5 = Math.max(i8, this.qn[1]);
                    } else {
                        i5 = Math.min(i8, this.qn[1]);
                    }
                    z = true;
                    i9++;
                    i8 = i5;
                    i7 = i6;
                }
            }
            i5 = i8;
            i6 = i7;
            i9++;
            i8 = i5;
            i7 = i6;
        }
        iArr[0] = i7;
        iArr[1] = i8;
        if (z) {
            U(1);
        }
    }

    @Override // android.support.v4.view.m
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        boolean z2;
        Behavior behavior;
        int childCount = getChildCount();
        int i2 = 0;
        boolean z3 = false;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.V(0) && (behavior = dVar.qC) != null) {
                    z2 = behavior.a(this, childAt, view, f2, f3, z) | z3;
                    i2++;
                    z3 = z2;
                }
            }
            z2 = z3;
            i2++;
            z3 = z2;
        }
        if (z3) {
            U(1);
        }
        return z3;
    }

    @Override // android.support.v4.view.m
    public boolean onNestedPreFling(View view, float f2, float f3) {
        boolean z;
        Behavior behavior;
        int childCount = getChildCount();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.V(0) && (behavior = dVar.qC) != null) {
                    z = behavior.a(this, childAt, view, f2, f3) | z2;
                    i2++;
                    z2 = z;
                }
            }
            z = z2;
            i2++;
            z2 = z;
        }
        return z2;
    }

    public int getNestedScrollAxes() {
        return this.qA.Qb;
    }

    class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        public final boolean onPreDraw() {
            CoordinatorLayout.this.U(0);
            return true;
        }
    }

    static class f implements Comparator<View> {
        f() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(View view, View view2) {
            float aA = u.aA(view);
            float aA2 = u.aA(view2);
            if (aA > aA2) {
                return -1;
            }
            if (aA < aA2) {
                return 1;
            }
            return 0;
        }
    }

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void a(d dVar) {
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4, int i5) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
            return false;
        }

        @Deprecated
        public boolean B(int i2) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                return B(i2);
            }
            return false;
        }

        @Deprecated
        public void b(V v, View view) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
            if (i2 == 0) {
                b(v, view);
            }
        }

        @Deprecated
        public void a(V v, int i2) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6) {
            if (i6 == 0) {
                a(v, i3);
            }
        }

        @Deprecated
        public void a(V v, View view, int i2, int[] iArr) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
            if (i4 == 0) {
                a(v, view, i3, iArr);
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
            return false;
        }

        public static ac b(ac acVar) {
            return acVar;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }
    }

    public static class d extends ViewGroup.MarginLayoutParams {
        public int anchorGravity = 0;
        public int gravity = 0;
        public Behavior qC;
        boolean qD = false;
        public int qE = -1;
        int qF = -1;
        public int qG = 0;
        public int qH = 0;
        int qI;
        int qJ;
        View qK;
        View qL;
        boolean qM;
        private boolean qN;
        private boolean qO;
        boolean qP;
        final Rect qQ = new Rect();
        Object qR;

        public d(int i2, int i3) {
            super(i2, i3);
        }

        d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0006a.CoordinatorLayout_Layout);
            this.gravity = obtainStyledAttributes.getInteger(0, 0);
            this.qF = obtainStyledAttributes.getResourceId(1, -1);
            this.anchorGravity = obtainStyledAttributes.getInteger(2, 0);
            this.qE = obtainStyledAttributes.getInteger(6, -1);
            this.qG = obtainStyledAttributes.getInt(5, 0);
            this.qH = obtainStyledAttributes.getInt(4, 0);
            this.qD = obtainStyledAttributes.hasValue(3);
            if (this.qD) {
                this.qC = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(3));
            }
            obtainStyledAttributes.recycle();
            if (this.qC != null) {
                this.qC.a(this);
            }
        }

        public d(d dVar) {
            super((ViewGroup.MarginLayoutParams) dVar);
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final void a(Behavior behavior) {
            if (this.qC != behavior) {
                this.qC = behavior;
                this.qR = null;
                this.qD = true;
                if (behavior != null) {
                    behavior.a(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean cy() {
            return this.qK == null && this.qF != -1;
        }

        /* access modifiers changed from: package-private */
        public final void d(int i2, boolean z) {
            switch (i2) {
                case 0:
                    this.qN = z;
                    return;
                case 1:
                    this.qO = z;
                    return;
                default:
                    return;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean V(int i2) {
            switch (i2) {
                case 0:
                    return this.qN;
                case 1:
                    return this.qO;
                default:
                    return false;
            }
        }
    }

    class c implements ViewGroup.OnHierarchyChangeListener {
        c() {
        }

        public final void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.qy != null) {
                CoordinatorLayout.this.qy.onChildViewAdded(view, view2);
            }
        }

        public final void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.U(2);
            if (CoordinatorLayout.this.qy != null) {
                CoordinatorLayout.this.qy.onChildViewRemoved(view, view2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.Pm);
        SparseArray<Parcelable> sparseArray = savedState.qS;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            Behavior behavior = r(childAt).qC;
            if (!(id == -1 || behavior == null || (parcelable2 = sparseArray.get(id)) == null)) {
                behavior.a(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable b2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            Behavior behavior = ((d) childAt.getLayoutParams()).qC;
            if (!(id == -1 || behavior == null || (b2 = behavior.b(this, childAt)) == null)) {
                sparseArray.append(id, b2);
            }
        }
        savedState.qS = sparseArray;
        return savedState;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behavior = ((d) view.getLayoutParams()).qC;
        if (behavior == null || !behavior.a(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    private void cx() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (u.aq(this)) {
                if (this.qz == null) {
                    this.qz = new p() {
                        /* class android.support.design.widget.CoordinatorLayout.AnonymousClass1 */

                        @Override // android.support.v4.view.p
                        public final ac a(View view, ac acVar) {
                            ac acVar2;
                            boolean z = true;
                            int i2 = 0;
                            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
                            if (j.equals(coordinatorLayout.qv, acVar)) {
                                return acVar;
                            }
                            coordinatorLayout.qv = acVar;
                            coordinatorLayout.qw = acVar != null && acVar.getSystemWindowInsetTop() > 0;
                            if (coordinatorLayout.qw || coordinatorLayout.getBackground() != null) {
                                z = false;
                            }
                            coordinatorLayout.setWillNotDraw(z);
                            if (!acVar.isConsumed()) {
                                int childCount = coordinatorLayout.getChildCount();
                                ac acVar3 = acVar;
                                while (true) {
                                    if (i2 >= childCount) {
                                        acVar2 = acVar3;
                                        break;
                                    }
                                    View childAt = coordinatorLayout.getChildAt(i2);
                                    if (u.aq(childAt) && ((d) childAt.getLayoutParams()).qC != null) {
                                        acVar2 = Behavior.b(acVar3);
                                        if (acVar2.isConsumed()) {
                                            break;
                                        }
                                    } else {
                                        acVar2 = acVar3;
                                    }
                                    i2++;
                                    acVar3 = acVar2;
                                }
                            } else {
                                acVar2 = acVar;
                            }
                            coordinatorLayout.requestLayout();
                            return acVar2;
                        }
                    };
                }
                u.a(this, this.qz);
                setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
                return;
            }
            u.a(this, (p) null);
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class android.support.design.widget.CoordinatorLayout.SavedState.AnonymousClass1 */

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
        SparseArray<Parcelable> qS;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.qS = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                this.qS.append(iArr[i2], readParcelableArray[i2]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            int size = this.qS != null ? this.qS.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = this.qS.keyAt(i3);
                parcelableArr[i3] = this.qS.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d(-2, -2);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof d) {
            return new d((d) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new d((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new d(layoutParams);
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }
}
