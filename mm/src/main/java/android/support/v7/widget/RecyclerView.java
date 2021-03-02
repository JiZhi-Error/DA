package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.a.c;
import android.support.v7.f.a;
import android.support.v7.widget.ac;
import android.support.v7.widget.bf;
import android.support.v7.widget.bg;
import android.support.v7.widget.d;
import android.support.v7.widget.s;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.huawei.easygo.sdk.constant.EasyGoCode;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements android.support.v4.view.k {
    private static final int[] arL = {16843830};
    private static final int[] arM = {16842987};
    static final boolean arN = (Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20);
    static final boolean arO;
    static final boolean arP;
    static final boolean arQ;
    private static final boolean arR;
    private static final boolean arS;
    private static final Class<?>[] arT = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final Interpolator atg = new Interpolator() {
        /* class android.support.v7.widget.RecyclerView.AnonymousClass3 */

        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private final int[] UN;
    final int[] UO;
    private final Rect Zi;
    a adj;
    private final p arU;
    final n arV;
    private SavedState arW;
    d arX;
    final bg arY;
    boolean arZ;
    private EdgeEffect asA;
    private EdgeEffect asB;
    f asC;
    private int asD;
    private int asE;
    private int asF;
    private int asG;
    private int asH;
    private j asI;
    private final int asJ;
    private final int asK;
    private float asL;
    private float asM;
    private boolean asN;
    final u asO;
    ac asP;
    ac.a asQ;
    final s asR;
    private l asS;
    private List<l> asT;
    boolean asU;
    boolean asV;
    private f.b asW;
    boolean asX;
    al asY;
    private d asZ;
    final Runnable asa;
    final RectF asb;
    LayoutManager asc;
    o asd;
    final ArrayList<h> ase;
    private final ArrayList<k> asf;
    private k asg;
    boolean ash;
    boolean asi;
    boolean asj;
    boolean ask;
    private int asl;
    boolean asm;
    public boolean asn;
    private boolean aso;
    private int asp;
    boolean asq;
    private final AccessibilityManager asr;
    public List<i> ass;
    boolean ast;
    boolean asu;
    private int asv;
    private int asw;
    private e asx;
    private EdgeEffect asy;
    private EdgeEffect asz;
    private final int[] ata;
    private android.support.v4.view.l atb;
    private final int[] atc;
    final int[] atd;
    final List<v> ate;
    private Runnable atf;
    private final bg.b ath;
    s mChildHelper;
    private int mScrollState;
    final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public interface d {
        int au(int i2, int i3);
    }

    public interface i {
        void bD(View view);

        void bE(View view);
    }

    public static abstract class j {
        public abstract boolean av(int i2, int i3);
    }

    public interface k {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void ah(boolean z);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public interface o {
    }

    public static abstract class t {
    }

    static {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (Build.VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        arO = z;
        if (Build.VERSION.SDK_INT >= 16) {
            z2 = true;
        } else {
            z2 = false;
        }
        arP = z2;
        if (Build.VERSION.SDK_INT >= 21) {
            z3 = true;
        } else {
            z3 = false;
        }
        arQ = z3;
        if (Build.VERSION.SDK_INT <= 15) {
            z4 = true;
        } else {
            z4 = false;
        }
        arR = z4;
        if (Build.VERSION.SDK_INT <= 15) {
            z5 = true;
        } else {
            z5 = false;
        }
        arS = z5;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        boolean z;
        String str;
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        Object[] objArr;
        this.arU = new p();
        this.arV = new n();
        this.arY = new bg();
        this.asa = new Runnable() {
            /* class android.support.v7.widget.RecyclerView.AnonymousClass1 */

            public final void run() {
                if (RecyclerView.this.ask && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.ash) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.asn) {
                        RecyclerView.this.asm = true;
                    } else {
                        RecyclerView.this.kO();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.Zi = new Rect();
        this.asb = new RectF();
        this.ase = new ArrayList<>();
        this.asf = new ArrayList<>();
        this.asl = 0;
        this.ast = false;
        this.asu = false;
        this.asv = 0;
        this.asw = 0;
        this.asx = new e();
        this.asC = new v();
        this.mScrollState = 0;
        this.asD = -1;
        this.asL = Float.MIN_VALUE;
        this.asM = Float.MIN_VALUE;
        this.asN = true;
        this.asO = new u();
        this.asQ = arQ ? new ac.a() : null;
        this.asR = new s();
        this.asU = false;
        this.asV = false;
        this.asW = new g();
        this.asX = false;
        this.ata = new int[2];
        this.UN = new int[2];
        this.UO = new int[2];
        this.atc = new int[2];
        this.atd = new int[2];
        this.ate = new ArrayList();
        this.atf = new Runnable() {
            /* class android.support.v7.widget.RecyclerView.AnonymousClass2 */

            public final void run() {
                if (RecyclerView.this.asC != null) {
                    RecyclerView.this.asC.jD();
                }
                RecyclerView.this.asX = false;
            }
        };
        this.ath = new bg.b() {
            /* class android.support.v7.widget.RecyclerView.AnonymousClass4 */

            @Override // android.support.v7.widget.bg.b
            public final void a(v vVar, f.c cVar, f.c cVar2) {
                RecyclerView.this.arV.u(vVar);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f(vVar);
                vVar.av(false);
                if (recyclerView.asC.d(vVar, cVar, cVar2)) {
                    recyclerView.le();
                }
            }

            @Override // android.support.v7.widget.bg.b
            public final void b(v vVar, f.c cVar, f.c cVar2) {
                RecyclerView recyclerView = RecyclerView.this;
                vVar.av(false);
                if (recyclerView.asC.e(vVar, cVar, cVar2)) {
                    recyclerView.le();
                }
            }

            @Override // android.support.v7.widget.bg.b
            public final void c(v vVar, f.c cVar, f.c cVar2) {
                vVar.av(false);
                if (RecyclerView.this.ast) {
                    if (RecyclerView.this.asC.a(vVar, vVar, cVar, cVar2)) {
                        RecyclerView.this.le();
                    }
                } else if (RecyclerView.this.asC.f(vVar, cVar, cVar2)) {
                    RecyclerView.this.le();
                }
            }

            @Override // android.support.v7.widget.bg.b
            public final void j(v vVar) {
                RecyclerView.this.asc.removeAndRecycleView(vVar.aus, RecyclerView.this.arV);
            }
        };
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, arM, i2, 0);
            this.arZ = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.arZ = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.asL = android.support.v4.view.v.a(viewConfiguration, context);
        this.asM = android.support.v4.view.v.b(viewConfiguration, context);
        this.asJ = viewConfiguration.getScaledMinimumFlingVelocity();
        this.asK = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.asC.atl = this.asW;
        this.arX = new d(new d.a() {
            /* class android.support.v7.widget.RecyclerView.AnonymousClass6 */

            @Override // android.support.v7.widget.d.a
            public final v bG(int i2) {
                v k = RecyclerView.this.k(i2, true);
                if (k != null && !RecyclerView.this.mChildHelper.bh(k.aus)) {
                    return k;
                }
                return null;
            }

            @Override // android.support.v7.widget.d.a
            public final void N(int i2, int i3) {
                RecyclerView.this.e(i2, i3, true);
                RecyclerView.this.asU = true;
                RecyclerView.this.asR.aua += i3;
            }

            @Override // android.support.v7.widget.d.a
            public final void O(int i2, int i3) {
                RecyclerView.this.e(i2, i3, false);
                RecyclerView.this.asU = true;
            }

            @Override // android.support.v7.widget.d.a
            public final void d(int i2, int i3, Object obj) {
                int i4;
                RecyclerView recyclerView = RecyclerView.this;
                int jA = recyclerView.mChildHelper.jA();
                int i5 = i2 + i3;
                for (int i6 = 0; i6 < jA; i6++) {
                    View bM = recyclerView.mChildHelper.bM(i6);
                    v bv = RecyclerView.bv(bM);
                    if (bv != null && !bv.lP() && bv.mPosition >= i2 && bv.mPosition < i5) {
                        bv.addFlags(2);
                        bv.O(obj);
                        ((LayoutParams) bM.getLayoutParams()).atx = true;
                    }
                }
                n nVar = recyclerView.arV;
                int i7 = i2 + i3;
                for (int size = nVar.atH.size() - 1; size >= 0; size--) {
                    v vVar = nVar.atH.get(size);
                    if (vVar != null && (i4 = vVar.mPosition) >= i2 && i4 < i7) {
                        vVar.addFlags(2);
                        nVar.cr(size);
                    }
                }
                RecyclerView.this.asV = true;
            }

            @Override // android.support.v7.widget.d.a
            public final void d(d.b bVar) {
                f(bVar);
            }

            private void f(d.b bVar) {
                switch (bVar.EX) {
                    case 1:
                        RecyclerView.this.asc.onItemsAdded(RecyclerView.this, bVar.ajZ, bVar.akb);
                        return;
                    case 2:
                        RecyclerView.this.asc.onItemsRemoved(RecyclerView.this, bVar.ajZ, bVar.akb);
                        return;
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    default:
                        return;
                    case 4:
                        RecyclerView.this.asc.onItemsUpdated(RecyclerView.this, bVar.ajZ, bVar.akb, bVar.aka);
                        return;
                    case 8:
                        RecyclerView.this.asc.onItemsMoved(RecyclerView.this, bVar.ajZ, bVar.akb, 1);
                        return;
                }
            }

            @Override // android.support.v7.widget.d.a
            public final void e(d.b bVar) {
                f(bVar);
            }

            @Override // android.support.v7.widget.d.a
            public final void P(int i2, int i3) {
                RecyclerView recyclerView = RecyclerView.this;
                int jA = recyclerView.mChildHelper.jA();
                for (int i4 = 0; i4 < jA; i4++) {
                    v bv = RecyclerView.bv(recyclerView.mChildHelper.bM(i4));
                    if (bv != null && !bv.lP() && bv.mPosition >= i2) {
                        bv.m(i3, false);
                        recyclerView.asR.aud = true;
                    }
                }
                n nVar = recyclerView.arV;
                int size = nVar.atH.size();
                for (int i5 = 0; i5 < size; i5++) {
                    v vVar = nVar.atH.get(i5);
                    if (vVar != null && vVar.mPosition >= i2) {
                        vVar.m(i3, true);
                    }
                }
                recyclerView.requestLayout();
                RecyclerView.this.asU = true;
            }

            @Override // android.support.v7.widget.d.a
            public final void Q(int i2, int i3) {
                int i4;
                int i5;
                int i6;
                int i7;
                int i8;
                int i9 = -1;
                RecyclerView recyclerView = RecyclerView.this;
                int jA = recyclerView.mChildHelper.jA();
                if (i2 < i3) {
                    i4 = -1;
                    i5 = i3;
                    i6 = i2;
                } else {
                    i4 = 1;
                    i5 = i2;
                    i6 = i3;
                }
                for (int i10 = 0; i10 < jA; i10++) {
                    v bv = RecyclerView.bv(recyclerView.mChildHelper.bM(i10));
                    if (bv != null && bv.mPosition >= i6 && bv.mPosition <= i5) {
                        if (bv.mPosition == i2) {
                            bv.m(i3 - i2, false);
                        } else {
                            bv.m(i4, false);
                        }
                        recyclerView.asR.aud = true;
                    }
                }
                n nVar = recyclerView.arV;
                if (i2 < i3) {
                    i7 = i3;
                    i8 = i2;
                } else {
                    i9 = 1;
                    i7 = i2;
                    i8 = i3;
                }
                int size = nVar.atH.size();
                for (int i11 = 0; i11 < size; i11++) {
                    v vVar = nVar.atH.get(i11);
                    if (vVar != null && vVar.mPosition >= i8 && vVar.mPosition <= i7) {
                        if (vVar.mPosition == i2) {
                            vVar.m(i3 - i2, false);
                        } else {
                            vVar.m(i9, false);
                        }
                    }
                }
                recyclerView.requestLayout();
                RecyclerView.this.asU = true;
            }
        });
        this.mChildHelper = new s(new s.b() {
            /* class android.support.v7.widget.RecyclerView.AnonymousClass5 */

            @Override // android.support.v7.widget.s.b
            public final int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            @Override // android.support.v7.widget.s.b
            public final void addView(View view, int i2) {
                RecyclerView.this.addView(view, i2);
                RecyclerView recyclerView = RecyclerView.this;
                v bv = RecyclerView.bv(view);
                if (!(recyclerView.adj == null || bv == null)) {
                    recyclerView.adj.k(bv);
                }
                if (recyclerView.ass != null) {
                    for (int size = recyclerView.ass.size() - 1; size >= 0; size--) {
                        recyclerView.ass.get(size).bD(view);
                    }
                }
            }

            @Override // android.support.v7.widget.s.b
            public final int indexOfChild(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // android.support.v7.widget.s.b
            public final void removeViewAt(int i2) {
                View childAt = RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    RecyclerView.this.bA(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i2);
            }

            @Override // android.support.v7.widget.s.b
            public final View getChildAt(int i2) {
                return RecyclerView.this.getChildAt(i2);
            }

            @Override // android.support.v7.widget.s.b
            public final v bi(View view) {
                return RecyclerView.bv(view);
            }

            @Override // android.support.v7.widget.s.b
            public final void attachViewToParent(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                v bv = RecyclerView.bv(view);
                if (bv != null) {
                    if (bv.mb() || bv.lP()) {
                        bv.lZ();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + bv + RecyclerView.this.kL());
                    }
                }
                RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }

            @Override // android.support.v7.widget.s.b
            public final void detachViewFromParent(int i2) {
                v bv;
                View childAt = getChildAt(i2);
                if (!(childAt == null || (bv = RecyclerView.bv(childAt)) == null)) {
                    if (!bv.mb() || bv.lP()) {
                        bv.addFlags(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + bv + RecyclerView.this.kL());
                    }
                }
                RecyclerView.this.detachViewFromParent((RecyclerView) i2);
            }

            @Override // android.support.v7.widget.s.b
            public final void bj(View view) {
                v bv = RecyclerView.bv(view);
                if (bv != null) {
                    RecyclerView recyclerView = RecyclerView.this;
                    if (bv.auH != -1) {
                        bv.auG = bv.auH;
                    } else {
                        bv.auG = android.support.v4.view.u.Y(bv.aus);
                    }
                    recyclerView.b(bv, 4);
                }
            }

            @Override // android.support.v7.widget.s.b
            public final void bk(View view) {
                v bv = RecyclerView.bv(view);
                if (bv != null) {
                    RecyclerView.this.b(bv, bv.auG);
                    bv.auG = 0;
                }
            }

            @Override // android.support.v7.widget.s.b
            public final void removeAllViews() {
                int childCount = RecyclerView.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    RecyclerView.this.bA(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }
        });
        if (android.support.v4.view.u.T(this) == 0) {
            android.support.v4.view.u.U(this);
        }
        if (android.support.v4.view.u.Y(this) == 0) {
            android.support.v4.view.u.p(this, 1);
        }
        this.asr = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new al(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.C0049a.RecyclerView, i2, 0);
            String string = obtainStyledAttributes2.getString(7);
            if (obtainStyledAttributes2.getInt(1, -1) == -1) {
                setDescendantFocusability(TPMediaCodecProfileLevel.HEVCMainTierLevel52);
            }
            this.asj = obtainStyledAttributes2.getBoolean(2, false);
            if (this.asj) {
                StateListDrawable stateListDrawable = (StateListDrawable) obtainStyledAttributes2.getDrawable(5);
                Drawable drawable = obtainStyledAttributes2.getDrawable(6);
                StateListDrawable stateListDrawable2 = (StateListDrawable) obtainStyledAttributes2.getDrawable(3);
                Drawable drawable2 = obtainStyledAttributes2.getDrawable(4);
                if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                    throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + kL());
                }
                Resources resources = getContext().getResources();
                new z(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.a45), resources.getDimensionPixelSize(R.dimen.a47), resources.getDimensionPixelOffset(R.dimen.a46));
            }
            obtainStyledAttributes2.recycle();
            if (string != null) {
                String trim = string.trim();
                if (!trim.isEmpty()) {
                    if (trim.charAt(0) == '.') {
                        str = context.getPackageName() + trim;
                    } else if (trim.contains(".")) {
                        str = trim;
                    } else {
                        str = RecyclerView.class.getPackage().getName() + '.' + trim;
                    }
                    try {
                        if (isInEditMode()) {
                            classLoader = getClass().getClassLoader();
                        } else {
                            classLoader = context.getClassLoader();
                        }
                        Class<? extends U> asSubclass = classLoader.loadClass(str).asSubclass(LayoutManager.class);
                        try {
                            constructor = asSubclass.getConstructor(arT);
                            objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), 0};
                        } catch (NoSuchMethodException e2) {
                            try {
                                constructor = asSubclass.getConstructor(new Class[0]);
                                objArr = null;
                            } catch (NoSuchMethodException e3) {
                                e3.initCause(e2);
                                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e3);
                            }
                        }
                        constructor.setAccessible(true);
                        setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                    } catch (ClassNotFoundException e4) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e4);
                    } catch (InvocationTargetException e5) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e5);
                    } catch (InstantiationException e6) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e6);
                    } catch (IllegalAccessException e7) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e7);
                    } catch (ClassCastException e8) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e8);
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, arL, i2, 0);
                z = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
            }
            z = true;
        } else {
            setDescendantFocusability(TPMediaCodecProfileLevel.HEVCMainTierLevel52);
            z = true;
        }
        setNestedScrollingEnabled(z);
    }

    /* access modifiers changed from: package-private */
    public final String kL() {
        return " " + super.toString() + ", adapter:" + this.adj + ", layout:" + this.asc + ", context:" + getContext();
    }

    public al getCompatAccessibilityDelegate() {
        return this.asY;
    }

    public void setAccessibilityDelegateCompat(al alVar) {
        this.asY = alVar;
        android.support.v4.view.u.a(this, this.asY);
    }

    public void setHasFixedSize(boolean z) {
        this.asi = z;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.arZ) {
            kX();
        }
        this.arZ = z;
        super.setClipToPadding(z);
        if (this.ask) {
            requestLayout();
        }
    }

    public boolean getClipToPadding() {
        return this.arZ;
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i2) {
            case 0:
                break;
            case 1:
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                new StringBuilder("setScrollingTouchSlop(): bad argument constant ").append(i2).append("; using default value");
                break;
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        if (this.adj != null) {
            this.adj.b(this.arU);
            this.adj.c(this);
        }
        kM();
        this.arX.reset();
        a aVar2 = this.adj;
        this.adj = aVar;
        if (aVar != null) {
            aVar.a(this.arU);
            aVar.b(this);
        }
        if (this.asc != null) {
            this.asc.onAdapterChanged(aVar2, this.adj);
        }
        n nVar = this.arV;
        a aVar3 = this.adj;
        nVar.clear();
        m recycledViewPool = nVar.getRecycledViewPool();
        if (aVar2 != null) {
            recycledViewPool.detach();
        }
        if (recycledViewPool.atA == 0) {
            recycledViewPool.clear();
        }
        if (aVar3 != null) {
            recycledViewPool.lH();
        }
        this.asR.aud = true;
        at(false);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public final void kM() {
        if (this.asC != null) {
            this.asC.jF();
        }
        if (this.asc != null) {
            this.asc.removeAndRecycleAllViews(this.arV);
            this.asc.removeAndRecycleScrapInt(this.arV);
        }
        this.arV.clear();
    }

    public a getAdapter() {
        return this.adj;
    }

    public void setRecyclerListener(o oVar) {
        this.asd = oVar;
    }

    public int getBaseline() {
        if (this.asc != null) {
            return this.asc.getBaseline();
        }
        return super.getBaseline();
    }

    public final void a(i iVar) {
        if (this.ass == null) {
            this.ass = new ArrayList();
        }
        this.ass.add(iVar);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.asc) {
            kQ();
            if (this.asc != null) {
                if (this.asC != null) {
                    this.asC.jF();
                }
                this.asc.removeAndRecycleAllViews(this.arV);
                this.asc.removeAndRecycleScrapInt(this.arV);
                this.arV.clear();
                if (this.ash) {
                    this.asc.dispatchDetachedFromWindow(this, this.arV);
                }
                this.asc.setRecyclerView(null);
                this.asc = null;
            } else {
                this.arV.clear();
            }
            s sVar = this.mChildHelper;
            s.a aVar = sVar.alY;
            while (true) {
                aVar.ama = 0;
                if (aVar.amb == null) {
                    break;
                }
                aVar = aVar.amb;
            }
            for (int size = sVar.alZ.size() - 1; size >= 0; size--) {
                sVar.alX.bk(sVar.alZ.get(size));
                sVar.alZ.remove(size);
            }
            sVar.alX.removeAllViews();
            this.asc = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.mRecyclerView != null) {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.mRecyclerView.kL());
                }
                this.asc.setRecyclerView(this);
                if (this.ash) {
                    this.asc.dispatchAttachedToWindow(this);
                }
            }
            this.arV.lI();
            requestLayout();
        }
    }

    public void setOnFlingListener(j jVar) {
        this.asI = jVar;
    }

    public j getOnFlingListener() {
        return this.asI;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.arW != null) {
            savedState.atN = this.arW.atN;
        } else if (this.asc != null) {
            savedState.atN = this.asc.onSaveInstanceState();
        } else {
            savedState.atN = null;
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.arW = (SavedState) parcelable;
        super.onRestoreInstanceState(this.arW.Pm);
        if (this.asc != null && this.arW.atN != null) {
            this.asc.onRestoreInstanceState(this.arW.atN);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: package-private */
    public final void f(v vVar) {
        View view = vVar.aus;
        boolean z = view.getParent() == this;
        this.arV.u(bi(view));
        if (vVar.mb()) {
            this.mChildHelper.a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.a(view, -1, true);
        } else {
            s sVar = this.mChildHelper;
            int indexOfChild = sVar.alX.indexOfChild(view);
            if (indexOfChild < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
            }
            sVar.alY.set(indexOfChild);
            sVar.bf(view);
        }
    }

    public LayoutManager getLayoutManager() {
        return this.asc;
    }

    public m getRecycledViewPool() {
        return this.arV.getRecycledViewPool();
    }

    public void setRecycledViewPool(m mVar) {
        n nVar = this.arV;
        if (nVar.atL != null) {
            nVar.atL.detach();
        }
        nVar.atL = mVar;
        if (nVar.atL != null && RecyclerView.this.getAdapter() != null) {
            nVar.atL.lH();
        }
    }

    public void setViewCacheExtension(t tVar) {
        this.arV.atM = tVar;
    }

    public void setItemViewCacheSize(int i2) {
        n nVar = this.arV;
        nVar.atJ = i2;
        nVar.lI();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (i2 != this.mScrollState) {
            this.mScrollState = i2;
            if (i2 != 2) {
                kR();
            }
            if (this.asc != null) {
                this.asc.onScrollStateChanged(i2);
            }
            if (this.asS != null) {
                this.asS.onScrollStateChanged(this, i2);
            }
            if (this.asT != null) {
                for (int size = this.asT.size() - 1; size >= 0; size--) {
                    this.asT.get(size).onScrollStateChanged(this, i2);
                }
            }
        }
    }

    public final void a(h hVar) {
        if (this.asc != null) {
            this.asc.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.ase.isEmpty()) {
            setWillNotDraw(false);
        }
        this.ase.add(hVar);
        lo();
        requestLayout();
    }

    public final void b(h hVar) {
        a(hVar);
    }

    public int getItemDecorationCount() {
        return this.ase.size();
    }

    public final void kN() {
        int itemDecorationCount = getItemDecorationCount();
        if (itemDecorationCount <= 0) {
            throw new IndexOutOfBoundsException("0 is an invalid index for size ".concat(String.valueOf(itemDecorationCount)));
        }
        int itemDecorationCount2 = getItemDecorationCount();
        if (itemDecorationCount2 <= 0) {
            throw new IndexOutOfBoundsException("0 is an invalid index for size " + itemDecorationCount2);
        }
        c(this.ase.get(0));
    }

    public final void c(h hVar) {
        if (this.asc != null) {
            this.asc.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.ase.remove(hVar);
        if (this.ase.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        lo();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar != this.asZ) {
            this.asZ = dVar;
            setChildrenDrawingOrderEnabled(this.asZ != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(l lVar) {
        this.asS = lVar;
    }

    public final void a(l lVar) {
        if (this.asT == null) {
            this.asT = new ArrayList();
        }
        this.asT.add(lVar);
    }

    public final void b(l lVar) {
        if (this.asT != null) {
            this.asT.remove(lVar);
        }
    }

    public void scrollToPosition(int i2) {
        if (!this.asn) {
            kQ();
            if (this.asc != null) {
                LayoutManager layoutManager = this.asc;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(layoutManager, a2.axQ(), "android/support/v7/widget/RecyclerView", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
                layoutManager.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(layoutManager, "android/support/v7/widget/RecyclerView", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
                awakenScrollBars();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void cf(int i2) {
        if (this.asc != null) {
            LayoutManager layoutManager = this.asc;
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(layoutManager, a2.axQ(), "android/support/v7/widget/RecyclerView", "jumpToPositionForSmoothScroller", "(I)V", "Undefined", "scrollToPosition", "(I)V");
            layoutManager.scrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(layoutManager, "android/support/v7/widget/RecyclerView", "jumpToPositionForSmoothScroller", "(I)V", "Undefined", "scrollToPosition", "(I)V");
            awakenScrollBars();
        }
    }

    public void smoothScrollToPosition(int i2) {
        if (!this.asn && this.asc != null) {
            this.asc.smoothScrollToPosition(this, this.asR, i2);
        }
    }

    public void scrollTo(int i2, int i3) {
    }

    public void scrollBy(int i2, int i3) {
        if (this.asc != null && !this.asn) {
            boolean canScrollHorizontally = this.asc.canScrollHorizontally();
            boolean canScrollVertically = this.asc.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i2 = 0;
                }
                if (!canScrollVertically) {
                    i3 = 0;
                }
                a(i2, i3, (MotionEvent) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2, int i3, int[] iArr) {
        kP();
        la();
        android.support.v4.os.e.beginSection("RV Scroll");
        f(this.asR);
        int scrollHorizontallyBy = i2 != 0 ? this.asc.scrollHorizontallyBy(i2, this.arV, this.asR) : 0;
        int scrollVerticallyBy = i3 != 0 ? this.asc.scrollVerticallyBy(i3, this.arV, this.asR) : 0;
        android.support.v4.os.e.endSection();
        int childCount = this.mChildHelper.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = this.mChildHelper.getChildAt(i4);
            v bi = bi(childAt);
            if (!(bi == null || bi.auz == null)) {
                View view = bi.auz.aus;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        as(true);
        ar(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    /* access modifiers changed from: package-private */
    public final void kO() {
        boolean z = false;
        if (!this.ask || this.ast) {
            android.support.v4.os.e.beginSection("RV FullInvalidate");
            lh();
            android.support.v4.os.e.endSection();
        } else if (!this.arX.jc()) {
        } else {
            if (this.arX.bD(4) && !this.arX.bD(11)) {
                android.support.v4.os.e.beginSection("RV PartialInvalidate");
                kP();
                la();
                this.arX.ja();
                if (!this.asm) {
                    int childCount = this.mChildHelper.getChildCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 < childCount) {
                            v bv = bv(this.mChildHelper.getChildAt(i2));
                            if (bv != null && !bv.lP() && bv.mh()) {
                                z = true;
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                    if (z) {
                        lh();
                    } else {
                        this.arX.jb();
                    }
                }
                ar(true);
                as(true);
                android.support.v4.os.e.endSection();
            } else if (this.arX.jc()) {
                android.support.v4.os.e.beginSection("RV FullInvalidate");
                lh();
                android.support.v4.os.e.endSection();
            }
        }
    }

    private boolean a(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        kO();
        if (this.adj != null) {
            b(i2, i3, this.atd);
            i5 = this.atd[0];
            i4 = this.atd[1];
            i7 = i2 - i5;
            i6 = i3 - i4;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.ase.isEmpty()) {
            invalidate();
        }
        if (a(i5, i4, i7, i6, this.UN, 0)) {
            this.asG -= this.UN[0];
            this.asH -= this.UN[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.UN[0], (float) this.UN[1]);
            }
            int[] iArr = this.atc;
            iArr[0] = iArr[0] + this.UN[0];
            int[] iArr2 = this.atc;
            iArr2[1] = iArr2[1] + this.UN[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !android.support.v4.view.i.h(motionEvent)) {
                h(motionEvent.getX(), (float) i7, motionEvent.getY(), (float) i6);
            }
            al(i2, i3);
        }
        if (!(i5 == 0 && i4 == 0)) {
            ap(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i5 == 0 && i4 == 0) ? false : true;
    }

    public int computeHorizontalScrollOffset() {
        if (this.asc != null && this.asc.canScrollHorizontally()) {
            return this.asc.computeHorizontalScrollOffset(this.asR);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.asc != null && this.asc.canScrollHorizontally()) {
            return this.asc.computeHorizontalScrollExtent(this.asR);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.asc != null && this.asc.canScrollHorizontally()) {
            return this.asc.computeHorizontalScrollRange(this.asR);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.asc != null && this.asc.canScrollVertically()) {
            return this.asc.computeVerticalScrollOffset(this.asR);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.asc != null && this.asc.canScrollVertically()) {
            return this.asc.computeVerticalScrollExtent(this.asR);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.asc != null && this.asc.canScrollVertically()) {
            return this.asc.computeVerticalScrollRange(this.asR);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final void kP() {
        this.asl++;
        if (this.asl == 1 && !this.asn) {
            this.asm = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void ar(boolean z) {
        if (this.asl <= 0) {
            this.asl = 1;
        }
        if (!z && !this.asn) {
            this.asm = false;
        }
        if (this.asl == 1) {
            if (z && this.asm && !this.asn && this.asc != null && this.adj != null) {
                lh();
            }
            if (!this.asn) {
                this.asm = false;
            }
        }
        this.asl--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.asn) {
            assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.asn = false;
                if (!(!this.asm || this.asc == null || this.adj == null)) {
                    requestLayout();
                }
                this.asm = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.asn = true;
            this.aso = true;
            kQ();
        }
    }

    public final void smoothScrollBy(int i2, int i3) {
        a(i2, i3, (Interpolator) null);
    }

    public void a(int i2, int i3, Interpolator interpolator) {
        int i4 = 0;
        if (this.asc != null && !this.asn) {
            if (!this.asc.canScrollHorizontally()) {
                i2 = 0;
            }
            if (this.asc.canScrollVertically()) {
                i4 = i3;
            }
            if (i2 != 0 || i4 != 0) {
                u uVar = this.asO;
                int az = uVar.az(i2, i4);
                if (interpolator == null) {
                    interpolator = atg;
                }
                uVar.b(i2, i4, az, interpolator);
            }
        }
    }

    public boolean ak(int i2, int i3) {
        boolean z;
        int i4;
        if (this.asc == null || this.asn) {
            return false;
        }
        boolean canScrollHorizontally = this.asc.canScrollHorizontally();
        boolean canScrollVertically = this.asc.canScrollVertically();
        if (!canScrollHorizontally || Math.abs(i2) < this.asJ) {
            i2 = 0;
        }
        if (!canScrollVertically || Math.abs(i3) < this.asJ) {
            i3 = 0;
        }
        if ((i2 == 0 && i3 == 0) || dispatchNestedPreFling((float) i2, (float) i3)) {
            return false;
        }
        if (canScrollHorizontally || canScrollVertically) {
            z = true;
        } else {
            z = false;
        }
        dispatchNestedFling((float) i2, (float) i3, z);
        if (this.asI != null && this.asI.av(i2, i3)) {
            return true;
        }
        if (!z) {
            return false;
        }
        if (canScrollHorizontally) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (canScrollVertically) {
            i4 |= 2;
        }
        A(i4, 1);
        int max = Math.max(-this.asK, Math.min(i2, this.asK));
        int max2 = Math.max(-this.asK, Math.min(i3, this.asK));
        u uVar = this.asO;
        RecyclerView.this.setScrollState(2);
        uVar.aup = 0;
        uVar.auo = 0;
        uVar.UD.fling(0, 0, max, max2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        uVar.lM();
        return true;
    }

    public void kQ() {
        setScrollState(0);
        kR();
    }

    private void kR() {
        this.asO.stop();
        if (this.asc != null) {
            this.asc.stopSmoothScroller();
        }
    }

    public int getMinFlingVelocity() {
        return this.asJ;
    }

    public int getMaxFlingVelocity() {
        return this.asK;
    }

    private void h(float f2, float f3, float f4, float f5) {
        boolean z = true;
        boolean z2 = false;
        if (f3 < 0.0f) {
            kT();
            android.support.v4.widget.i.a(this.asy, (-f3) / ((float) getWidth()), 1.0f - (f4 / ((float) getHeight())));
            z2 = true;
        } else if (f3 > 0.0f) {
            kU();
            android.support.v4.widget.i.a(this.asA, f3 / ((float) getWidth()), f4 / ((float) getHeight()));
            z2 = true;
        }
        if (f5 < 0.0f) {
            kV();
            android.support.v4.widget.i.a(this.asz, (-f5) / ((float) getHeight()), f2 / ((float) getWidth()));
        } else if (f5 > 0.0f) {
            kW();
            android.support.v4.widget.i.a(this.asB, f5 / ((float) getHeight()), 1.0f - (f2 / ((float) getWidth())));
        } else {
            z = z2;
        }
        if (z || f3 != 0.0f || f5 != 0.0f) {
            android.support.v4.view.u.X(this);
        }
    }

    private void kS() {
        boolean z = false;
        if (this.asy != null) {
            this.asy.onRelease();
            z = this.asy.isFinished();
        }
        if (this.asz != null) {
            this.asz.onRelease();
            z |= this.asz.isFinished();
        }
        if (this.asA != null) {
            this.asA.onRelease();
            z |= this.asA.isFinished();
        }
        if (this.asB != null) {
            this.asB.onRelease();
            z |= this.asB.isFinished();
        }
        if (z) {
            android.support.v4.view.u.X(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final void al(int i2, int i3) {
        boolean z = false;
        if (this.asy != null && !this.asy.isFinished() && i2 > 0) {
            this.asy.onRelease();
            z = this.asy.isFinished();
        }
        if (this.asA != null && !this.asA.isFinished() && i2 < 0) {
            this.asA.onRelease();
            z |= this.asA.isFinished();
        }
        if (this.asz != null && !this.asz.isFinished() && i3 > 0) {
            this.asz.onRelease();
            z |= this.asz.isFinished();
        }
        if (this.asB != null && !this.asB.isFinished() && i3 < 0) {
            this.asB.onRelease();
            z |= this.asB.isFinished();
        }
        if (z) {
            android.support.v4.view.u.X(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final void am(int i2, int i3) {
        if (i2 < 0) {
            kT();
            this.asy.onAbsorb(-i2);
        } else if (i2 > 0) {
            kU();
            this.asA.onAbsorb(i2);
        }
        if (i3 < 0) {
            kV();
            this.asz.onAbsorb(-i3);
        } else if (i3 > 0) {
            kW();
            this.asB.onAbsorb(i3);
        }
        if (i2 != 0 || i3 != 0) {
            android.support.v4.view.u.X(this);
        }
    }

    private void kT() {
        if (this.asy == null) {
            this.asy = e.d(this);
            if (this.arZ) {
                this.asy.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.asy.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    private void kU() {
        if (this.asA == null) {
            this.asA = e.d(this);
            if (this.arZ) {
                this.asA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.asA.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    private void kV() {
        if (this.asz == null) {
            this.asz = e.d(this);
            if (this.arZ) {
                this.asz.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.asz.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private void kW() {
        if (this.asB == null) {
            this.asB = e.d(this);
            if (this.arZ) {
                this.asB.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.asB.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private void kX() {
        this.asB = null;
        this.asz = null;
        this.asA = null;
        this.asy = null;
    }

    public void setEdgeEffectFactory(e eVar) {
        android.support.v4.e.m.checkNotNull(eVar);
        this.asx = eVar;
        kX();
    }

    public e getEdgeEffectFactory() {
        return this.asx;
    }

    public View focusSearch(View view, int i2) {
        View findNextFocus;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        char c2 = 65535;
        boolean z4 = false;
        View onInterceptFocusSearch = this.asc.onInterceptFocusSearch(view, i2);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z5 = this.adj != null && this.asc != null && !ld() && !this.asn;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z5 || !(i2 == 2 || i2 == 1)) {
            findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus == null && z5) {
                kO();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                kP();
                findNextFocus = this.asc.onFocusSearchFailed(view, i2, this.arV, this.asR);
                ar(false);
            }
        } else {
            if (this.asc.canScrollVertically()) {
                int i4 = i2 == 2 ? 130 : 33;
                if (instance.findNextFocus(this, view, i4) == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (arR) {
                    i2 = i4;
                }
            } else {
                z = false;
            }
            if (!z && this.asc.canScrollHorizontally()) {
                if (this.asc.getLayoutDirection() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (i2 == 2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                int i5 = z3 ^ z2 ? 66 : 17;
                if (instance.findNextFocus(this, view, i5) == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (arR) {
                    i2 = i5;
                }
            }
            if (z) {
                kO();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                kP();
                this.asc.onFocusSearchFailed(view, i2, this.arV, this.asR);
                ar(false);
            }
            findNextFocus = instance.findNextFocus(this, view, i2);
        }
        if (findNextFocus == null || findNextFocus.hasFocusable()) {
            if (!(findNextFocus == null || findNextFocus == this || findContainingItemView(findNextFocus) == null)) {
                if (view == null) {
                    z4 = true;
                } else if (findContainingItemView(view) == null) {
                    z4 = true;
                } else {
                    this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
                    this.Zi.set(0, 0, findNextFocus.getWidth(), findNextFocus.getHeight());
                    offsetDescendantRectToMyCoords(view, this.mTempRect);
                    offsetDescendantRectToMyCoords(findNextFocus, this.Zi);
                    int i6 = this.asc.getLayoutDirection() == 1 ? -1 : 1;
                    if ((this.mTempRect.left < this.Zi.left || this.mTempRect.right <= this.Zi.left) && this.mTempRect.right < this.Zi.right) {
                        i3 = 1;
                    } else if ((this.mTempRect.right > this.Zi.right || this.mTempRect.left >= this.Zi.right) && this.mTempRect.left > this.Zi.left) {
                        i3 = -1;
                    } else {
                        i3 = 0;
                    }
                    if ((this.mTempRect.top < this.Zi.top || this.mTempRect.bottom <= this.Zi.top) && this.mTempRect.bottom < this.Zi.bottom) {
                        c2 = 1;
                    } else if ((this.mTempRect.bottom <= this.Zi.bottom && this.mTempRect.top < this.Zi.bottom) || this.mTempRect.top <= this.Zi.top) {
                        c2 = 0;
                    }
                    switch (i2) {
                        case 1:
                            if (c2 < 0 || (c2 == 0 && i6 * i3 <= 0)) {
                                z4 = true;
                                break;
                            }
                        case 2:
                            if (c2 > 0 || (c2 == 0 && i6 * i3 >= 0)) {
                                z4 = true;
                                break;
                            }
                        case 17:
                            if (i3 < 0) {
                                z4 = true;
                                break;
                            }
                            break;
                        case 33:
                            if (c2 < 0) {
                                z4 = true;
                                break;
                            }
                            break;
                        case 66:
                            if (i3 > 0) {
                                z4 = true;
                                break;
                            }
                            break;
                        case 130:
                            if (c2 > 0) {
                                z4 = true;
                                break;
                            }
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid direction: " + i2 + kL());
                    }
                }
            }
            return z4 ? findNextFocus : super.focusSearch(view, i2);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        } else {
            f(findNextFocus, null);
            return view;
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.asc.onRequestChildFocus(this, this.asR, view, view2) && view2 != null) {
            f(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void f(View view, View view2) {
        boolean z = true;
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.atx) {
                Rect rect = layoutParams2.apS;
                this.mTempRect.left -= rect.left;
                this.mTempRect.right += rect.right;
                this.mTempRect.top -= rect.top;
                Rect rect2 = this.mTempRect;
                rect2.bottom = rect.bottom + rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        LayoutManager layoutManager = this.asc;
        Rect rect3 = this.mTempRect;
        boolean z2 = !this.ask;
        if (view2 != null) {
            z = false;
        }
        layoutManager.requestChildRectangleOnScreen(this, view, rect3, z2, z);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.asc.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (this.asc == null || !this.asc.onAddFocusables(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (ld()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        if (r0 >= 30.0f) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
        // Method dump skipped, instructions count: 110
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onAttachedToWindow():void");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.asC != null) {
            this.asC.jF();
        }
        kQ();
        this.ash = false;
        if (this.asc != null) {
            this.asc.dispatchDetachedFromWindow(this, this.arV);
        }
        this.ate.clear();
        removeCallbacks(this.atf);
        bg.a.nn();
        if (arQ && this.asP != null) {
            this.asP.anR.remove(this);
            this.asP = null;
        }
    }

    public boolean isAttachedToWindow() {
        return this.ash;
    }

    /* access modifiers changed from: package-private */
    public final void assertInLayoutOrScroll(String str) {
        if (ld()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + kL());
        }
        throw new IllegalStateException(str + kL());
    }

    /* access modifiers changed from: package-private */
    public final void assertNotInLayoutOrScroll(String str) {
        if (ld()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + kL());
            }
            throw new IllegalStateException(str);
        } else if (this.asw > 0) {
            new IllegalStateException(kL());
        }
    }

    public final void a(k kVar) {
        this.asf.add(kVar);
    }

    public final void b(k kVar) {
        this.asf.remove(kVar);
        if (this.asg == kVar) {
            this.asg = null;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int i2;
        if (this.asn) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.asg = null;
        }
        int size = this.asf.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                z = false;
                break;
            }
            k kVar = this.asf.get(i3);
            if (kVar.a(this, motionEvent) && action != 3) {
                this.asg = kVar;
                z = true;
                break;
            }
            i3++;
        }
        if (z) {
            kZ();
            return true;
        } else if (this.asc == null) {
            return false;
        } else {
            boolean canScrollHorizontally = this.asc.canScrollHorizontally();
            boolean canScrollVertically = this.asc.canScrollVertically();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            switch (actionMasked) {
                case 0:
                    if (this.aso) {
                        this.aso = false;
                    }
                    this.asD = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.asG = x;
                    this.asE = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.asH = y;
                    this.asF = y;
                    if (this.mScrollState == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.atc;
                    this.atc[1] = 0;
                    iArr[0] = 0;
                    if (canScrollHorizontally) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (canScrollVertically) {
                        i2 |= 2;
                    }
                    A(i2, 0);
                    break;
                case 1:
                    this.mVelocityTracker.clear();
                    aM(0);
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.asD);
                    if (findPointerIndex >= 0) {
                        int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                        int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                        if (this.mScrollState != 1) {
                            int i4 = x2 - this.asE;
                            int i5 = y2 - this.asF;
                            if (!canScrollHorizontally || Math.abs(i4) <= this.mTouchSlop) {
                                z2 = false;
                            } else {
                                this.asG = x2;
                                z2 = true;
                            }
                            if (canScrollVertically && Math.abs(i5) > this.mTouchSlop) {
                                this.asH = y2;
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                                break;
                            }
                        }
                    } else {
                        new StringBuilder("Error processing scroll; pointer index for id ").append(this.asD).append(" not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    break;
                case 3:
                    kZ();
                    break;
                case 5:
                    this.asD = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.asG = x3;
                    this.asE = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.asH = y3;
                    this.asF = y3;
                    break;
                case 6:
                    l(motionEvent);
                    break;
            }
            return this.mScrollState == 1;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.asf.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.asf.get(i2).ah(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
        // Method dump skipped, instructions count: 542
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void kY() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
        }
        aM(0);
        kS();
    }

    private void kZ() {
        kY();
        setScrollState(0);
    }

    private void l(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.asD) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.asD = motionEvent.getPointerId(i2);
            int x = (int) (motionEvent.getX(i2) + 0.5f);
            this.asG = x;
            this.asE = x;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.asH = y;
            this.asF = y;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        float f4;
        if (this.asc != null && !this.asn && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                if (this.asc.canScrollVertically()) {
                    f4 = -motionEvent.getAxisValue(9);
                } else {
                    f4 = 0.0f;
                }
                if (this.asc.canScrollHorizontally()) {
                    f2 = motionEvent.getAxisValue(10);
                    f3 = f4;
                } else {
                    f2 = 0.0f;
                    f3 = f4;
                }
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                float axisValue = motionEvent.getAxisValue(26);
                if (this.asc.canScrollVertically()) {
                    f2 = 0.0f;
                    f3 = -axisValue;
                } else if (this.asc.canScrollHorizontally()) {
                    f2 = axisValue;
                    f3 = 0.0f;
                } else {
                    f2 = 0.0f;
                    f3 = 0.0f;
                }
            } else {
                f2 = 0.0f;
                f3 = 0.0f;
            }
            if (!(f3 == 0.0f && f2 == 0.0f)) {
                a((int) (this.asL * f2), (int) (this.asM * f3), motionEvent);
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z = false;
        if (this.asc == null) {
            an(i2, i3);
        } else if (this.asc.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.asc.onMeasure(this.arV, this.asR, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (!z && this.adj != null) {
                if (this.asR.aub == 1) {
                    ll();
                }
                this.asc.setMeasureSpecs(i2, i3);
                this.asR.aug = true;
                lm();
                this.asc.setMeasuredDimensionFromChildren(i2, i3);
                if (this.asc.shouldMeasureTwice()) {
                    this.asc.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.asR.aug = true;
                    lm();
                    this.asc.setMeasuredDimensionFromChildren(i2, i3);
                }
            }
        } else if (this.asi) {
            this.asc.onMeasure(this.arV, this.asR, i2, i3);
        } else {
            if (this.asq) {
                kP();
                la();
                lg();
                as(true);
                if (this.asR.aui) {
                    this.asR.aue = true;
                } else {
                    this.arX.jd();
                    this.asR.aue = false;
                }
                this.asq = false;
                ar(false);
            } else if (this.asR.aui) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            if (this.adj != null) {
                this.asR.auc = this.adj.getItemCount();
            } else {
                this.asR.auc = 0;
            }
            kP();
            this.asc.onMeasure(this.arV, this.asR, i2, i3);
            ar(false);
            this.asR.aue = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void an(int i2, int i3) {
        setMeasuredDimension(LayoutManager.chooseSize(i2, getPaddingLeft() + getPaddingRight(), android.support.v4.view.u.af(this)), LayoutManager.chooseSize(i3, getPaddingTop() + getPaddingBottom(), android.support.v4.view.u.ag(this)));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            kX();
        }
    }

    public void setItemAnimator(f fVar) {
        if (this.asC != null) {
            this.asC.jF();
            this.asC.atl = null;
        }
        this.asC = fVar;
        if (this.asC != null) {
            this.asC.atl = this.asW;
        }
    }

    /* access modifiers changed from: package-private */
    public final void la() {
        this.asv++;
    }

    /* access modifiers changed from: package-private */
    public final void as(boolean z) {
        this.asv--;
        if (this.asv <= 0) {
            this.asv = 0;
            if (z) {
                lc();
                lu();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean lb() {
        return this.asr != null && this.asr.isEnabled();
    }

    private void lc() {
        int i2 = this.asp;
        this.asp = 0;
        if (i2 != 0 && lb()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            android.support.v4.view.a.a.a(obtain, i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public final boolean ld() {
        return this.asv > 0;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i2;
        int i3 = 0;
        if (ld()) {
            if (accessibilityEvent == null) {
                i2 = 0;
            } else if (Build.VERSION.SDK_INT >= 19) {
                i2 = accessibilityEvent.getContentChangeTypes();
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                i3 = i2;
            }
            this.asp |= i3;
            i3 = 1;
        }
        if (i3 == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public f getItemAnimator() {
        return this.asC;
    }

    /* access modifiers changed from: package-private */
    public final void le() {
        if (!this.asX && this.ash) {
            android.support.v4.view.u.b(this, this.atf);
            this.asX = true;
        }
    }

    private boolean lf() {
        return this.asC != null && this.asc.supportsPredictiveItemAnimations();
    }

    private void lg() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (this.ast) {
            this.arX.reset();
            if (this.asu) {
                this.asc.onItemsChanged(this);
            }
        }
        if (lf()) {
            this.arX.ja();
        } else {
            this.arX.jd();
        }
        if (this.asU || this.asV) {
            z = true;
        } else {
            z = false;
        }
        s sVar = this.asR;
        if (!this.ask || this.asC == null || ((!this.ast && !z && !this.asc.mRequestedSimpleAnimations) || (this.ast && !this.adj.atk))) {
            z2 = false;
        } else {
            z2 = true;
        }
        sVar.auh = z2;
        s sVar2 = this.asR;
        if (!this.asR.auh || !z || this.ast || !lf()) {
            z3 = false;
        }
        sVar2.aui = z3;
    }

    private void lh() {
        if (this.adj != null && this.asc != null) {
            this.asR.aug = false;
            if (this.asR.aub == 1) {
                ll();
                this.asc.setExactMeasureSpecsFrom(this);
                lm();
            } else if (!this.arX.je() && this.asc.getWidth() == getWidth() && this.asc.getHeight() == getHeight()) {
                this.asc.setExactMeasureSpecsFrom(this);
            } else {
                this.asc.setExactMeasureSpecsFrom(this);
                lm();
            }
            ln();
        }
    }

    private void li() {
        View view;
        long j2;
        int lR;
        if (!this.asN || !hasFocus() || this.adj == null) {
            view = null;
        } else {
            view = getFocusedChild();
        }
        v bu = view == null ? null : bu(view);
        if (bu == null) {
            lj();
            return;
        }
        s sVar = this.asR;
        if (this.adj.atk) {
            j2 = bu.auv;
        } else {
            j2 = -1;
        }
        sVar.auk = j2;
        s sVar2 = this.asR;
        if (this.ast) {
            lR = -1;
        } else if (bu.isRemoved()) {
            lR = bu.auu;
        } else {
            lR = bu.lR();
        }
        sVar2.auj = lR;
        s sVar3 = this.asR;
        View view2 = bu.aus;
        int id = view2.getId();
        while (!view2.isFocused() && (view2 instanceof ViewGroup) && view2.hasFocus()) {
            view2 = ((ViewGroup) view2).getFocusedChild();
            if (view2.getId() != -1) {
                id = view2.getId();
            }
        }
        sVar3.aul = id;
    }

    private void lj() {
        this.asR.auk = -1;
        this.asR.auj = -1;
        this.asR.aul = -1;
    }

    private void lk() {
        v vVar;
        View view;
        View view2;
        View view3 = null;
        if (this.asN && this.adj != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!arS || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.mChildHelper.bh(focusedChild)) {
                            return;
                        }
                    } else if (this.mChildHelper.getChildCount() == 0) {
                        requestFocus();
                        return;
                    }
                }
                if (this.asR.auk == -1 || !this.adj.atk) {
                    vVar = null;
                } else {
                    vVar = m(this.asR.auk);
                }
                if (vVar != null && !this.mChildHelper.bh(vVar.aus) && vVar.aus.hasFocusable()) {
                    view3 = vVar.aus;
                } else if (this.mChildHelper.getChildCount() > 0) {
                    int i2 = this.asR.auj != -1 ? this.asR.auj : 0;
                    int itemCount = this.asR.getItemCount();
                    int i3 = i2;
                    while (true) {
                        if (i3 < itemCount) {
                            v ch = ch(i3);
                            if (ch == null) {
                                break;
                            } else if (ch.aus.hasFocusable()) {
                                view2 = ch.aus;
                                break;
                            } else {
                                i3++;
                            }
                        } else {
                            break;
                        }
                    }
                    int min = Math.min(itemCount, i2) - 1;
                    while (true) {
                        if (min >= 0) {
                            v ch2 = ch(min);
                            if (ch2 == null) {
                                break;
                            } else if (ch2.aus.hasFocusable()) {
                                view2 = ch2.aus;
                                break;
                            } else {
                                min--;
                            }
                        } else {
                            break;
                        }
                    }
                    view2 = null;
                    view3 = view2;
                }
                if (view3 != null) {
                    if (((long) this.asR.aul) == -1 || (view = view3.findViewById(this.asR.aul)) == null || !view.isFocusable()) {
                        view = view3;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void f(s sVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.asO.UD;
            sVar.aum = overScroller.getFinalX() - overScroller.getCurrX();
            sVar.aun = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        sVar.aum = 0;
        sVar.aun = 0;
    }

    private void ll() {
        this.asR.cu(1);
        f(this.asR);
        this.asR.aug = false;
        kP();
        this.arY.clear();
        la();
        lg();
        li();
        this.asR.auf = this.asR.auh && this.asV;
        this.asV = false;
        this.asU = false;
        this.asR.aue = this.asR.aui;
        this.asR.auc = this.adj.getItemCount();
        m(this.ata);
        if (this.asR.auh) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                v bv = bv(this.mChildHelper.getChildAt(i2));
                if (!bv.lP() && (!bv.isInvalid() || this.adj.atk)) {
                    this.arY.b(bv, this.asC.a(this.asR, bv, f.m(bv), bv.me()));
                    if (this.asR.auf && bv.mh() && !bv.isRemoved() && !bv.lP() && !bv.isInvalid()) {
                        this.arY.a(g(bv), bv);
                    }
                }
            }
        }
        if (this.asR.aui) {
            lp();
            boolean z = this.asR.aud;
            this.asR.aud = false;
            this.asc.onLayoutChildren(this.arV, this.asR);
            this.asR.aud = z;
            for (int i3 = 0; i3 < this.mChildHelper.getChildCount(); i3++) {
                v bv2 = bv(this.mChildHelper.getChildAt(i3));
                if (!bv2.lP() && !this.arY.H(bv2)) {
                    int m2 = f.m(bv2);
                    boolean cv = bv2.cv(8192);
                    if (!cv) {
                        m2 |= 4096;
                    }
                    f.c a2 = this.asC.a(this.asR, bv2, m2, bv2.me());
                    if (cv) {
                        a(bv2, a2);
                    } else {
                        this.arY.c(bv2, a2);
                    }
                }
            }
            lq();
        } else {
            lq();
        }
        as(true);
        ar(false);
        this.asR.aub = 2;
    }

    private void lm() {
        boolean z;
        kP();
        la();
        this.asR.cu(6);
        this.arX.jd();
        this.asR.auc = this.adj.getItemCount();
        this.asR.aua = 0;
        this.asR.aue = false;
        this.asc.onLayoutChildren(this.arV, this.asR);
        this.asR.aud = false;
        this.arW = null;
        s sVar = this.asR;
        if (!this.asR.auh || this.asC == null) {
            z = false;
        } else {
            z = true;
        }
        sVar.auh = z;
        this.asR.aub = 4;
        as(true);
        ar(false);
    }

    private void ln() {
        this.asR.cu(4);
        kP();
        la();
        this.asR.aub = 1;
        if (this.asR.auh) {
            for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
                v bv = bv(this.mChildHelper.getChildAt(childCount));
                if (!bv.lP()) {
                    long g2 = g(bv);
                    f.c c2 = new f.c().c(bv, 0);
                    v n2 = this.arY.n(g2);
                    if (n2 != null && !n2.lP()) {
                        boolean G = this.arY.G(n2);
                        boolean G2 = this.arY.G(bv);
                        if (!G || n2 != bv) {
                            f.c d2 = this.arY.d(n2, 4);
                            this.arY.d(bv, c2);
                            f.c d3 = this.arY.d(bv, 8);
                            if (d2 == null) {
                                a(g2, bv, n2);
                            } else {
                                a(n2, bv, d2, d3, G, G2);
                            }
                        }
                    }
                    this.arY.d(bv, c2);
                }
            }
            this.arY.a(this.ath);
        }
        this.asc.removeAndRecycleScrapInt(this.arV);
        this.asR.atZ = this.asR.auc;
        this.ast = false;
        this.asu = false;
        this.asR.auh = false;
        this.asR.aui = false;
        this.asc.mRequestedSimpleAnimations = false;
        if (this.arV.atG != null) {
            this.arV.atG.clear();
        }
        if (this.asc.mPrefetchMaxObservedInInitialPrefetch) {
            this.asc.mPrefetchMaxCountObserved = 0;
            this.asc.mPrefetchMaxObservedInInitialPrefetch = false;
            this.arV.lI();
        }
        this.asc.onLayoutCompleted(this.asR);
        as(true);
        ar(false);
        this.arY.clear();
        if (ao(this.ata[0], this.ata[1])) {
            ap(0, 0);
        }
        lk();
        lj();
    }

    private void a(long j2, v vVar, v vVar2) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            v bv = bv(this.mChildHelper.getChildAt(i2));
            if (bv != vVar && g(bv) == j2) {
                if (this.adj == null || !this.adj.atk) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + bv + " \n View Holder 2:" + vVar + kL());
                } else {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + bv + " \n View Holder 2:" + vVar + kL());
                }
            }
        }
        new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(vVar2).append(" cannot be found but it is necessary for ").append(vVar).append(kL());
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, f.c cVar) {
        vVar.setFlags(0, 8192);
        if (this.asR.auf && vVar.mh() && !vVar.isRemoved() && !vVar.lP()) {
            this.arY.a(g(vVar), vVar);
        }
        this.arY.b(vVar, cVar);
    }

    private void m(int[] iArr) {
        int i2;
        int childCount = this.mChildHelper.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        int i5 = 0;
        while (i5 < childCount) {
            v bv = bv(this.mChildHelper.getChildAt(i5));
            if (!bv.lP()) {
                i2 = bv.lQ();
                if (i2 < i3) {
                    i3 = i2;
                }
                if (i2 > i4) {
                    i5++;
                    i4 = i2;
                }
            }
            i2 = i4;
            i5++;
            i4 = i2;
        }
        iArr[0] = i3;
        iArr[1] = i4;
    }

    private boolean ao(int i2, int i3) {
        m(this.ata);
        return (this.ata[0] == i2 && this.ata[1] == i3) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z) {
        v bv = bv(view);
        if (bv != null) {
            if (bv.mb()) {
                bv.lZ();
            } else if (!bv.lP()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + bv + kL());
            }
        }
        view.clearAnimation();
        bA(view);
        super.removeDetachedView(view, z);
    }

    private long g(v vVar) {
        if (this.adj.atk) {
            return vVar.auv;
        }
        return (long) vVar.mPosition;
    }

    private void a(v vVar, v vVar2, f.c cVar, f.c cVar2, boolean z, boolean z2) {
        vVar.av(false);
        if (z) {
            f(vVar);
        }
        if (vVar != vVar2) {
            if (z2) {
                f(vVar2);
            }
            vVar.auy = vVar2;
            f(vVar);
            this.arV.u(vVar);
            vVar2.av(false);
            vVar2.auz = vVar;
        }
        if (this.asC.a(vVar, vVar2, cVar, cVar2)) {
            le();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        android.support.v4.os.e.beginSection("RV OnLayout");
        lh();
        android.support.v4.os.e.endSection();
        this.ask = true;
    }

    public void requestLayout() {
        if (this.asl != 0 || this.asn) {
            this.asm = true;
        } else {
            super.requestLayout();
        }
    }

    public void lo() {
        int jA = this.mChildHelper.jA();
        for (int i2 = 0; i2 < jA; i2++) {
            ((LayoutParams) this.mChildHelper.bM(i2).getLayoutParams()).atx = true;
        }
        n nVar = this.arV;
        int size = nVar.atH.size();
        for (int i3 = 0; i3 < size; i3++) {
            LayoutParams layoutParams = (LayoutParams) nVar.atH.get(i3).aus.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.atx = true;
            }
        }
    }

    public void draw(Canvas canvas) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        super.draw(canvas);
        int size = this.ase.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.ase.get(i2).b(canvas, this, this.asR);
        }
        if (this.asy == null || this.asy.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.arZ ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (paddingBottom + (-getHeight())), 0.0f);
            z = this.asy != null && this.asy.draw(canvas);
            canvas.restoreToCount(save);
        }
        if (this.asz != null && !this.asz.isFinished()) {
            int save2 = canvas.save();
            if (this.arZ) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            z |= this.asz != null && this.asz.draw(canvas);
            canvas.restoreToCount(save2);
        }
        if (this.asA != null && !this.asA.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.arZ ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            z |= this.asA != null && this.asA.draw(canvas);
            canvas.restoreToCount(save3);
        }
        if (this.asB != null && !this.asB.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.arZ) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.asB != null && this.asB.draw(canvas)) {
                z3 = true;
            }
            z |= z3;
            canvas.restoreToCount(save4);
        }
        if (z || this.asC == null || this.ase.size() <= 0 || !this.asC.isRunning()) {
            z2 = z;
        }
        if (z2) {
            android.support.v4.view.u.X(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.ase.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.ase.get(i2).a(canvas, this, this.asR);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.asc.checkLayoutParams((LayoutParams) layoutParams);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.asc != null) {
            return this.asc.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + kL());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.asc != null) {
            return this.asc.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + kL());
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.asc != null) {
            return this.asc.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + kL());
    }

    private void lp() {
        int jA = this.mChildHelper.jA();
        for (int i2 = 0; i2 < jA; i2++) {
            v bv = bv(this.mChildHelper.bM(i2));
            if (!bv.lP()) {
                bv.lO();
            }
        }
    }

    private void lq() {
        int jA = this.mChildHelper.jA();
        for (int i2 = 0; i2 < jA; i2++) {
            v bv = bv(this.mChildHelper.bM(i2));
            if (!bv.lP()) {
                bv.lN();
            }
        }
        this.arV.lq();
    }

    /* access modifiers changed from: package-private */
    public final void e(int i2, int i3, boolean z) {
        int i4 = i2 + i3;
        int jA = this.mChildHelper.jA();
        for (int i5 = 0; i5 < jA; i5++) {
            v bv = bv(this.mChildHelper.bM(i5));
            if (bv != null && !bv.lP()) {
                if (bv.mPosition >= i4) {
                    bv.m(-i3, z);
                    this.asR.aud = true;
                } else if (bv.mPosition >= i2) {
                    bv.addFlags(8);
                    bv.m(-i3, z);
                    bv.mPosition = i2 - 1;
                    this.asR.aud = true;
                }
            }
        }
        n nVar = this.arV;
        int i6 = i2 + i3;
        for (int size = nVar.atH.size() - 1; size >= 0; size--) {
            v vVar = nVar.atH.get(size);
            if (vVar != null) {
                if (vVar.mPosition >= i6) {
                    vVar.m(-i3, z);
                } else if (vVar.mPosition >= i2) {
                    vVar.addFlags(8);
                    nVar.cr(size);
                }
            }
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public final void at(boolean z) {
        this.asu |= z;
        this.ast = true;
        lr();
    }

    private void lr() {
        int jA = this.mChildHelper.jA();
        for (int i2 = 0; i2 < jA; i2++) {
            v bv = bv(this.mChildHelper.bM(i2));
            if (bv != null && !bv.lP()) {
                bv.addFlags(6);
            }
        }
        lo();
        this.arV.lr();
    }

    public final void ls() {
        if (this.ase.size() != 0) {
            if (this.asc != null) {
                this.asc.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            lo();
            requestLayout();
        }
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.asN;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.asN = z;
    }

    public final v bi(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return bv(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            view2 = (View) parent;
            parent = view2.getParent();
        }
        if (parent == this) {
            return view2;
        }
        return null;
    }

    public final v bu(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return bi(findContainingItemView);
    }

    static v bv(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).atw;
    }

    public static int bw(View view) {
        v bv = bv(view);
        if (bv != null) {
            return bv.lR();
        }
        return -1;
    }

    public static int bx(View view) {
        v bv = bv(view);
        if (bv != null) {
            return bv.lQ();
        }
        return -1;
    }

    public final v cg(int i2) {
        return k(i2, false);
    }

    public final v ch(int i2) {
        if (this.ast) {
            return null;
        }
        int jA = this.mChildHelper.jA();
        int i3 = 0;
        v vVar = null;
        while (i3 < jA) {
            v bv = bv(this.mChildHelper.bM(i3));
            if (bv == null || bv.isRemoved() || i(bv) != i2) {
                bv = vVar;
            } else if (!this.mChildHelper.bh(bv.aus)) {
                return bv;
            }
            i3++;
            vVar = bv;
        }
        return vVar;
    }

    public final v k(int i2, boolean z) {
        int jA = this.mChildHelper.jA();
        v vVar = null;
        for (int i3 = 0; i3 < jA; i3++) {
            v bv = bv(this.mChildHelper.bM(i3));
            if (bv != null && !bv.isRemoved()) {
                if (z) {
                    if (bv.mPosition != i2) {
                        continue;
                    }
                } else if (bv.lQ() != i2) {
                    continue;
                }
                if (!this.mChildHelper.bh(bv.aus)) {
                    return bv;
                }
                vVar = bv;
            }
        }
        return vVar;
    }

    public final v m(long j2) {
        if (this.adj == null || !this.adj.atk) {
            return null;
        }
        int jA = this.mChildHelper.jA();
        int i2 = 0;
        v vVar = null;
        while (i2 < jA) {
            v bv = bv(this.mChildHelper.bM(i2));
            if (bv == null || bv.isRemoved() || bv.auv != j2) {
                bv = vVar;
            } else if (!this.mChildHelper.bh(bv.aus)) {
                return bv;
            }
            i2++;
            vVar = bv;
        }
        return vVar;
    }

    public final View o(float f2, float f3) {
        for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mChildHelper.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f2 >= ((float) childAt.getLeft()) + translationX && f2 <= translationX + ((float) childAt.getRight()) && f3 >= ((float) childAt.getTop()) + translationY && f3 <= ((float) childAt.getBottom()) + translationY) {
                return childAt;
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public static void getDecoratedBoundsWithMargins(View view, Rect rect) {
        c(view, rect);
    }

    static void c(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.apS;
        int left = (view.getLeft() - rect2.left) - layoutParams.leftMargin;
        int top = (view.getTop() - rect2.top) - layoutParams.topMargin;
        int right = view.getRight() + rect2.right + layoutParams.rightMargin;
        int bottom = view.getBottom();
        rect.set(left, top, right, layoutParams.bottomMargin + rect2.bottom + bottom);
    }

    /* access modifiers changed from: package-private */
    public final Rect by(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.atx) {
            return layoutParams.apS;
        }
        if (this.asR.aue && (layoutParams.atw.mh() || layoutParams.atw.isInvalid())) {
            return layoutParams.apS;
        }
        Rect rect = layoutParams.apS;
        rect.set(0, 0, 0, 0);
        int size = this.ase.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.ase.get(i2).a(this.mTempRect, view, this, this.asR);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        layoutParams.atx = false;
        return rect;
    }

    /* access modifiers changed from: package-private */
    public final void ap(int i2, int i3) {
        this.asw++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        if (this.asS != null) {
            this.asS.onScrolled(this, i2, i3);
        }
        if (this.asT != null) {
            for (int size = this.asT.size() - 1; size >= 0; size--) {
                this.asT.get(size).onScrolled(this, i2, i3);
            }
        }
        this.asw--;
    }

    public final boolean lt() {
        return !this.ask || this.ast || this.arX.jc();
    }

    /* access modifiers changed from: package-private */
    public class u implements Runnable {
        OverScroller UD;
        int auo;
        int aup;
        private boolean auq = false;
        private boolean aur = false;
        Interpolator mInterpolator = RecyclerView.atg;

        u() {
            this.UD = new OverScroller(RecyclerView.this.getContext(), RecyclerView.atg);
        }

        public final void run() {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            if (RecyclerView.this.asc == null) {
                stop();
                return;
            }
            this.aur = false;
            this.auq = true;
            RecyclerView.this.kO();
            OverScroller overScroller = this.UD;
            r rVar = RecyclerView.this.asc.mSmoothScroller;
            if (overScroller.computeScrollOffset()) {
                int[] iArr = RecyclerView.this.UO;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i9 = currX - this.auo;
                int i10 = currY - this.aup;
                this.auo = currX;
                this.aup = currY;
                if (RecyclerView.this.a(i9, i10, iArr, null, 1)) {
                    int i11 = i9 - iArr[0];
                    i2 = i10 - iArr[1];
                    i3 = i11;
                } else {
                    i2 = i10;
                    i3 = i9;
                }
                if (RecyclerView.this.adj != null) {
                    RecyclerView.this.b(i3, i2, RecyclerView.this.atd);
                    i7 = RecyclerView.this.atd[0];
                    i6 = RecyclerView.this.atd[1];
                    i5 = i3 - i7;
                    i4 = i2 - i6;
                    if (rVar != null && !rVar.atP && rVar.gc) {
                        int itemCount = RecyclerView.this.asR.getItemCount();
                        if (itemCount == 0) {
                            rVar.stop();
                        } else {
                            if (rVar.atO >= itemCount) {
                                rVar.atO = itemCount - 1;
                            }
                            rVar.ax(i3 - i5, i2 - i4);
                        }
                    }
                } else {
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                }
                if (!RecyclerView.this.ase.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.al(i3, i2);
                }
                if (!RecyclerView.this.a(i7, i6, i5, i4, (int[]) null, 1) && !(i5 == 0 && i4 == 0)) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    if (i5 != currX) {
                        i8 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                    } else {
                        i8 = 0;
                    }
                    if (i4 == currY) {
                        currVelocity = 0;
                    } else if (i4 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i4 <= 0) {
                        currVelocity = 0;
                    }
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        RecyclerView.this.am(i8, currVelocity);
                    }
                    if ((i8 != 0 || i5 == currX || overScroller.getFinalX() == 0) && (currVelocity != 0 || i4 == currY || overScroller.getFinalY() == 0)) {
                        overScroller.abortAnimation();
                    }
                }
                if (!(i7 == 0 && i6 == 0)) {
                    RecyclerView.this.ap(i7, i6);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = (i3 == 0 && i2 == 0) || (i3 != 0 && RecyclerView.this.asc.canScrollHorizontally() && i7 == i3) || (i2 != 0 && RecyclerView.this.asc.canScrollVertically() && i6 == i2);
                if (overScroller.isFinished() || (!z && !RecyclerView.this.getScrollingChildHelper().aN(1))) {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.arQ) {
                        RecyclerView.this.asQ.jL();
                    }
                    RecyclerView.this.aM(1);
                } else {
                    lM();
                    if (RecyclerView.this.asP != null) {
                        RecyclerView.this.asP.a(RecyclerView.this, i3, i2);
                    }
                }
            }
            if (rVar != null) {
                if (rVar.atP) {
                    rVar.ax(0, 0);
                }
                if (!this.aur) {
                    rVar.stop();
                }
            }
            this.auq = false;
            if (this.aur) {
                lM();
            }
        }

        /* access modifiers changed from: package-private */
        public final void lM() {
            if (this.auq) {
                this.aur = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            android.support.v4.view.u.b(RecyclerView.this, this);
        }

        /* access modifiers changed from: package-private */
        public final void ay(int i2, int i3) {
            l(i2, i3, az(i2, i3));
        }

        private static float distanceInfluenceForSnapDuration(float f2) {
            return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
        }

        /* access modifiers changed from: package-private */
        public final int az(int i2, int i3) {
            int i4;
            int i5;
            int abs = Math.abs(i2);
            int abs2 = Math.abs(i3);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt(0.0d);
            int sqrt2 = (int) Math.sqrt((double) ((i2 * i2) + (i3 * i3)));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i6 = width / 2;
            float distanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i6)) + ((float) i6);
            if (sqrt > 0) {
                i5 = Math.round(1000.0f * Math.abs(distanceInfluenceForSnapDuration / ((float) sqrt))) * 4;
            } else {
                if (z) {
                    i4 = abs;
                } else {
                    i4 = abs2;
                }
                i5 = (int) (((((float) i4) / ((float) width)) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        public final void l(int i2, int i3, int i4) {
            b(i2, i3, i4, RecyclerView.atg);
        }

        public final void b(int i2, int i3, int i4, Interpolator interpolator) {
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.UD = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.aup = 0;
            this.auo = 0;
            this.UD.startScroll(0, 0, i2, i3, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.UD.computeScrollOffset();
            }
            lM();
        }

        public final void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.UD.abortAnimation();
        }
    }

    class p extends c {
        p() {
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView.this.asR.aud = true;
            RecyclerView.this.at(true);
            if (!RecyclerView.this.arX.jc()) {
                RecyclerView.this.requestLayout();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0023, code lost:
            if (r1.ajS.size() == 1) goto L_0x0025;
         */
        @Override // android.support.v7.widget.RecyclerView.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onItemRangeChanged(int r5, int r6, java.lang.Object r7) {
            /*
                r4 = this;
                r0 = 1
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                r2 = 0
                r1.assertNotInLayoutOrScroll(r2)
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.d r1 = r1.arX
                if (r6 <= 0) goto L_0x002b
                java.util.ArrayList<android.support.v7.widget.d$b> r2 = r1.ajS
                r3 = 4
                android.support.v7.widget.d$b r3 = r1.a(r3, r5, r6, r7)
                r2.add(r3)
                int r2 = r1.ajY
                r2 = r2 | 4
                r1.ajY = r2
                java.util.ArrayList<android.support.v7.widget.d$b> r1 = r1.ajS
                int r1 = r1.size()
                if (r1 != r0) goto L_0x002b
            L_0x0025:
                if (r0 == 0) goto L_0x002a
                r4.lK()
            L_0x002a:
                return
            L_0x002b:
                r0 = 0
                goto L_0x0025
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.p.onItemRangeChanged(int, int, java.lang.Object):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0022, code lost:
            if (r1.ajS.size() == 1) goto L_0x0024;
         */
        @Override // android.support.v7.widget.RecyclerView.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onItemRangeInserted(int r5, int r6) {
            /*
                r4 = this;
                r3 = 0
                r0 = 1
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                r1.assertNotInLayoutOrScroll(r3)
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.d r1 = r1.arX
                if (r6 <= 0) goto L_0x002a
                java.util.ArrayList<android.support.v7.widget.d$b> r2 = r1.ajS
                android.support.v7.widget.d$b r3 = r1.a(r0, r5, r6, r3)
                r2.add(r3)
                int r2 = r1.ajY
                r2 = r2 | 1
                r1.ajY = r2
                java.util.ArrayList<android.support.v7.widget.d$b> r1 = r1.ajS
                int r1 = r1.size()
                if (r1 != r0) goto L_0x002a
            L_0x0024:
                if (r0 == 0) goto L_0x0029
                r4.lK()
            L_0x0029:
                return
            L_0x002a:
                r0 = 0
                goto L_0x0024
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.p.onItemRangeInserted(int, int):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0023, code lost:
            if (r1.ajS.size() == 1) goto L_0x0025;
         */
        @Override // android.support.v7.widget.RecyclerView.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onItemRangeRemoved(int r6, int r7) {
            /*
                r5 = this;
                r4 = 0
                r0 = 1
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                r1.assertNotInLayoutOrScroll(r4)
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.d r1 = r1.arX
                if (r7 <= 0) goto L_0x002b
                java.util.ArrayList<android.support.v7.widget.d$b> r2 = r1.ajS
                r3 = 2
                android.support.v7.widget.d$b r3 = r1.a(r3, r6, r7, r4)
                r2.add(r3)
                int r2 = r1.ajY
                r2 = r2 | 2
                r1.ajY = r2
                java.util.ArrayList<android.support.v7.widget.d$b> r1 = r1.ajS
                int r1 = r1.size()
                if (r1 != r0) goto L_0x002b
            L_0x0025:
                if (r0 == 0) goto L_0x002a
                r5.lK()
            L_0x002a:
                return
            L_0x002b:
                r0 = 0
                goto L_0x0025
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.p.onItemRangeRemoved(int, int):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x002f, code lost:
            if (r1.ajS.size() == 1) goto L_0x0031;
         */
        @Override // android.support.v7.widget.RecyclerView.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onItemRangeMoved(int r6, int r7, int r8) {
            /*
                r5 = this;
                r4 = 0
                r0 = 1
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                r1.assertNotInLayoutOrScroll(r4)
                android.support.v7.widget.RecyclerView r1 = android.support.v7.widget.RecyclerView.this
                android.support.v7.widget.d r1 = r1.arX
                if (r6 == r7) goto L_0x0037
                if (r8 == r0) goto L_0x0018
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = "Moving more than 1 item is not supported yet"
                r0.<init>(r1)
                throw r0
            L_0x0018:
                java.util.ArrayList<android.support.v7.widget.d$b> r2 = r1.ajS
                r3 = 8
                android.support.v7.widget.d$b r3 = r1.a(r3, r6, r7, r4)
                r2.add(r3)
                int r2 = r1.ajY
                r2 = r2 | 8
                r1.ajY = r2
                java.util.ArrayList<android.support.v7.widget.d$b> r1 = r1.ajS
                int r1 = r1.size()
                if (r1 != r0) goto L_0x0037
            L_0x0031:
                if (r0 == 0) goto L_0x0036
                r5.lK()
            L_0x0036:
                return
            L_0x0037:
                r0 = 0
                goto L_0x0031
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.p.onItemRangeMoved(int, int, int):void");
        }

        private void lK() {
            if (!RecyclerView.arP || !RecyclerView.this.asi || !RecyclerView.this.ash) {
                RecyclerView.this.asq = true;
                RecyclerView.this.requestLayout();
                return;
            }
            android.support.v4.view.u.b(RecyclerView.this, RecyclerView.this.asa);
        }
    }

    public static class e {
        protected static EdgeEffect d(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static class m {
        int atA = 0;
        SparseArray<a> atz = new SparseArray<>();

        /* access modifiers changed from: package-private */
        public static class a {
            final ArrayList<v> atB = new ArrayList<>();
            int atC = 5;
            long atD = 0;
            long atE = 0;

            a() {
            }
        }

        public final void clear() {
            for (int i2 = 0; i2 < this.atz.size(); i2++) {
                this.atz.valueAt(i2).atB.clear();
            }
        }

        public final void aw(int i2, int i3) {
            a cn = cn(i2);
            cn.atC = i3;
            ArrayList<v> arrayList = cn.atB;
            while (arrayList.size() > i3) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        public final int cl(int i2) {
            return cn(i2).atB.size();
        }

        public v cm(int i2) {
            a aVar = this.atz.get(i2);
            if (aVar == null || aVar.atB.isEmpty()) {
                return null;
            }
            ArrayList<v> arrayList = aVar.atB;
            return arrayList.remove(arrayList.size() - 1);
        }

        static long c(long j2, long j3) {
            return j2 == 0 ? j3 : ((j2 / 4) * 3) + (j3 / 4);
        }

        /* access modifiers changed from: package-private */
        public final void d(int i2, long j2) {
            a cn = cn(i2);
            cn.atD = c(cn.atD, j2);
        }

        /* access modifiers changed from: package-private */
        public final boolean b(int i2, long j2, long j3) {
            long j4 = cn(i2).atD;
            return j4 == 0 || j4 + j2 < j3;
        }

        /* access modifiers changed from: package-private */
        public final void lH() {
            this.atA++;
        }

        /* access modifiers changed from: package-private */
        public final void detach() {
            this.atA--;
        }

        /* access modifiers changed from: package-private */
        public final a cn(int i2) {
            a aVar = this.atz.get(i2);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.atz.put(i2, aVar2);
            return aVar2;
        }

        public void q(v vVar) {
            int i2 = vVar.auw;
            ArrayList<v> arrayList = cn(i2).atB;
            if (this.atz.get(i2).atC > arrayList.size()) {
                vVar.resetInternal();
                arrayList.add(vVar);
            }
        }
    }

    static RecyclerView bz(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView bz = bz(viewGroup.getChildAt(i2));
            if (bz != null) {
                return bz;
            }
        }
        return null;
    }

    static void h(v vVar) {
        if (vVar.aut != null) {
            RecyclerView recyclerView = vVar.aut.get();
            while (recyclerView != null) {
                if (recyclerView != vVar.aus) {
                    ViewParent parent = recyclerView.getParent();
                    recyclerView = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            vVar.aut = null;
        }
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (arQ) {
            return System.nanoTime();
        }
        return 0;
    }

    public final class n {
        final ArrayList<v> atF = new ArrayList<>();
        ArrayList<v> atG = null;
        final ArrayList<v> atH = new ArrayList<>();
        final List<v> atI = Collections.unmodifiableList(this.atF);
        int atJ = 2;
        int atK = 2;
        m atL;
        t atM;

        public n() {
        }

        public final void clear() {
            this.atF.clear();
            lJ();
        }

        /* access modifiers changed from: package-private */
        public final void lI() {
            this.atK = (RecyclerView.this.asc != null ? RecyclerView.this.asc.mPrefetchMaxCountObserved : 0) + this.atJ;
            for (int size = this.atH.size() - 1; size >= 0 && this.atH.size() > this.atK; size--) {
                cr(size);
            }
        }

        private boolean r(v vVar) {
            if (vVar.isRemoved()) {
                return RecyclerView.this.asR.aue;
            }
            if (vVar.mPosition < 0 || vVar.mPosition >= RecyclerView.this.adj.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + vVar + RecyclerView.this.kL());
            } else if (!RecyclerView.this.asR.aue && RecyclerView.this.adj.getItemViewType(vVar.mPosition) != vVar.auw) {
                return false;
            } else {
                if (RecyclerView.this.adj.atk) {
                    return vVar.auv == RecyclerView.this.adj.getItemId(vVar.mPosition);
                }
                return true;
            }
        }

        private boolean a(v vVar, int i2, int i3, long j2) {
            boolean z;
            vVar.auI = RecyclerView.this;
            int i4 = vVar.auw;
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j2 != MAlarmHandler.NEXT_FIRE_INTERVAL) {
                long j3 = this.atL.cn(i4).atE;
                if (j3 == 0 || j3 + nanoTime < j2) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
            a aVar = RecyclerView.this.adj;
            vVar.mPosition = i2;
            if (aVar.atk) {
                vVar.auv = aVar.getItemId(i2);
            }
            vVar.setFlags(1, com.tencent.mm.plugin.appbrand.jsapi.openvoice.n.CTRL_INDEX);
            android.support.v4.os.e.beginSection("RV OnBindView");
            aVar.a(vVar, i2, vVar.me());
            vVar.md();
            ViewGroup.LayoutParams layoutParams = vVar.aus.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).atx = true;
            }
            android.support.v4.os.e.endSection();
            m.a cn = this.atL.cn(vVar.auw);
            cn.atE = m.c(cn.atE, RecyclerView.this.getNanoTime() - nanoTime);
            if (RecyclerView.this.lb()) {
                View view = vVar.aus;
                if (android.support.v4.view.u.Y(view) == 0) {
                    android.support.v4.view.u.p(view, 1);
                }
                if (!android.support.v4.view.u.V(view)) {
                    vVar.addFlags(16384);
                    android.support.v4.view.u.a(view, RecyclerView.this.asY.auJ);
                }
            }
            if (RecyclerView.this.asR.aue) {
                vVar.aux = i3;
            }
            return true;
        }

        public final int co(int i2) {
            if (i2 >= 0 && i2 < RecyclerView.this.asR.getItemCount()) {
                return !RecyclerView.this.asR.aue ? i2 : RecyclerView.this.arX.bE(i2);
            }
            throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + RecyclerView.this.asR.getItemCount() + RecyclerView.this.kL());
        }

        public final View cp(int i2) {
            return cq(i2);
        }

        /* access modifiers changed from: package-private */
        public final View cq(int i2) {
            return e(i2, MAlarmHandler.NEXT_FIRE_INTERVAL).aus;
        }

        /* access modifiers changed from: package-private */
        public final v e(int i2, long j2) {
            v vVar;
            boolean z;
            v vVar2;
            v vVar3;
            boolean z2;
            boolean a2;
            LayoutParams layoutParams;
            boolean z3;
            RecyclerView bz;
            boolean z4 = true;
            if (i2 < 0 || i2 >= RecyclerView.this.asR.getItemCount()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i2 + "(" + i2 + "). Item count:" + RecyclerView.this.asR.getItemCount() + RecyclerView.this.kL());
            }
            if (RecyclerView.this.asR.aue) {
                vVar = cs(i2);
                z = vVar != null;
            } else {
                vVar = null;
                z = false;
            }
            if (vVar == null) {
                vVar2 = l(i2, false);
                if (vVar2 != null) {
                    if (!r(vVar2)) {
                        vVar2.addFlags(4);
                        if (vVar2.lV()) {
                            RecyclerView.this.removeDetachedView(vVar2.aus, false);
                            vVar2.lW();
                        } else if (vVar2.lX()) {
                            vVar2.lY();
                        }
                        t(vVar2);
                        vVar2 = null;
                    } else {
                        z = true;
                    }
                }
            } else {
                vVar2 = vVar;
            }
            if (vVar2 == null) {
                int bE = RecyclerView.this.arX.bE(i2);
                if (bE < 0 || bE >= RecyclerView.this.adj.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i2 + "(offset:" + bE + ").state:" + RecyclerView.this.asR.getItemCount() + RecyclerView.this.kL());
                }
                int itemViewType = RecyclerView.this.adj.getItemViewType(bE);
                if (!RecyclerView.this.adj.atk || (vVar2 = a(RecyclerView.this.adj.getItemId(bE), itemViewType, false)) == null) {
                    z3 = z;
                } else {
                    vVar2.mPosition = bE;
                    z3 = true;
                }
                if (vVar2 == null && (vVar2 = getRecycledViewPool().cm(itemViewType)) != null) {
                    vVar2.resetInternal();
                    if (RecyclerView.arN) {
                        s(vVar2);
                    }
                }
                if (vVar2 == null) {
                    long nanoTime = RecyclerView.this.getNanoTime();
                    if (j2 != MAlarmHandler.NEXT_FIRE_INTERVAL && !this.atL.b(itemViewType, nanoTime, j2)) {
                        return null;
                    }
                    vVar2 = RecyclerView.this.adj.d(RecyclerView.this, itemViewType);
                    if (RecyclerView.arQ && (bz = RecyclerView.bz(vVar2.aus)) != null) {
                        vVar2.aut = new WeakReference<>(bz);
                    }
                    this.atL.d(itemViewType, RecyclerView.this.getNanoTime() - nanoTime);
                }
                vVar3 = vVar2;
                z2 = z3;
            } else {
                vVar3 = vVar2;
                z2 = z;
            }
            if (z2 && !RecyclerView.this.asR.aue && vVar3.cv(8192)) {
                vVar3.setFlags(0, 8192);
                if (RecyclerView.this.asR.auh) {
                    RecyclerView.this.a(vVar3, RecyclerView.this.asC.a(RecyclerView.this.asR, vVar3, f.m(vVar3) | 4096, vVar3.me()));
                }
            }
            if (RecyclerView.this.asR.aue && vVar3.isBound()) {
                vVar3.aux = i2;
                a2 = false;
            } else if (!vVar3.isBound() || vVar3.ma() || vVar3.isInvalid()) {
                a2 = a(vVar3, RecyclerView.this.arX.bE(i2), i2, j2);
            } else {
                a2 = false;
            }
            ViewGroup.LayoutParams layoutParams2 = vVar3.aus.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                vVar3.aus.setLayoutParams(layoutParams);
            } else if (!RecyclerView.this.checkLayoutParams(layoutParams2)) {
                layoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams2);
                vVar3.aus.setLayoutParams(layoutParams);
            } else {
                layoutParams = (LayoutParams) layoutParams2;
            }
            layoutParams.atw = vVar3;
            if (!z2 || !a2) {
                z4 = false;
            }
            layoutParams.aty = z4;
            return vVar3;
        }

        private void s(v vVar) {
            if (vVar.aus instanceof ViewGroup) {
                d((ViewGroup) vVar.aus, false);
            }
        }

        private void d(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    d((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public final void bF(View view) {
            v bv = RecyclerView.bv(view);
            if (bv.mb()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (bv.lV()) {
                bv.lW();
            } else if (bv.lX()) {
                bv.lY();
            }
            t(bv);
        }

        private void lJ() {
            for (int size = this.atH.size() - 1; size >= 0; size--) {
                cr(size);
            }
            this.atH.clear();
            if (RecyclerView.arQ) {
                RecyclerView.this.asQ.jL();
            }
        }

        /* access modifiers changed from: package-private */
        public final void cr(int i2) {
            a(this.atH.get(i2), true);
            this.atH.remove(i2);
        }

        /* access modifiers changed from: package-private */
        public final void t(v vVar) {
            boolean z;
            boolean z2 = true;
            if (vVar.lV() || vVar.aus.getParent() != null) {
                throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + vVar.lV() + " isAttached:" + (vVar.aus.getParent() != null) + RecyclerView.this.kL());
            } else if (vVar.mb()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + vVar + RecyclerView.this.kL());
            } else if (vVar.lP()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.kL());
            } else {
                boolean mg = vVar.mg();
                if (vVar.mf()) {
                    if (this.atK <= 0 || vVar.cv(com.tencent.mm.plugin.appbrand.jsapi.k.ac.CTRL_INDEX)) {
                        z = false;
                    } else {
                        int size = this.atH.size();
                        if (size >= this.atK && size > 0) {
                            cr(0);
                            size--;
                        }
                        if (RecyclerView.arQ && size > 0 && !RecyclerView.this.asQ.bP(vVar.mPosition)) {
                            int i2 = size - 1;
                            while (i2 >= 0) {
                                if (!RecyclerView.this.asQ.bP(this.atH.get(i2).mPosition)) {
                                    break;
                                }
                                i2--;
                            }
                            size = i2 + 1;
                        }
                        this.atH.add(size, vVar);
                        z = true;
                    }
                    if (!z) {
                        a(vVar, true);
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                    z = false;
                }
                RecyclerView.this.arY.K(vVar);
                if (!z && !z2 && mg) {
                    vVar.auI = null;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(v vVar, boolean z) {
            RecyclerView.h(vVar);
            if (vVar.cv(16384)) {
                vVar.setFlags(0, 16384);
                android.support.v4.view.u.a(vVar.aus, (android.support.v4.view.a) null);
            }
            if (z) {
                v(vVar);
            }
            vVar.auI = null;
            getRecycledViewPool().q(vVar);
        }

        /* access modifiers changed from: package-private */
        public final void bG(View view) {
            v bv = RecyclerView.bv(view);
            bv.auE = null;
            bv.auF = false;
            bv.lY();
            t(bv);
        }

        /* access modifiers changed from: package-private */
        public final void bH(View view) {
            boolean z;
            v bv = RecyclerView.bv(view);
            if (!bv.cv(12) && bv.mh()) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.asC == null || recyclerView.asC.a(bv, bv.me())) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    if (this.atG == null) {
                        this.atG = new ArrayList<>();
                    }
                    bv.a(this, true);
                    this.atG.add(bv);
                    return;
                }
            }
            if (!bv.isInvalid() || bv.isRemoved() || RecyclerView.this.adj.atk) {
                bv.a(this, false);
                this.atF.add(bv);
                return;
            }
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.kL());
        }

        /* access modifiers changed from: package-private */
        public final void u(v vVar) {
            if (vVar.auF) {
                this.atG.remove(vVar);
            } else {
                this.atF.remove(vVar);
            }
            vVar.auE = null;
            vVar.auF = false;
            vVar.lY();
        }

        private v cs(int i2) {
            int size;
            int M;
            if (this.atG == null || (size = this.atG.size()) == 0) {
                return null;
            }
            for (int i3 = 0; i3 < size; i3++) {
                v vVar = this.atG.get(i3);
                if (!vVar.lX() && vVar.lQ() == i2) {
                    vVar.addFlags(32);
                    return vVar;
                }
            }
            if (RecyclerView.this.adj.atk && (M = RecyclerView.this.arX.M(i2, 0)) > 0 && M < RecyclerView.this.adj.getItemCount()) {
                long itemId = RecyclerView.this.adj.getItemId(M);
                for (int i4 = 0; i4 < size; i4++) {
                    v vVar2 = this.atG.get(i4);
                    if (!vVar2.lX() && vVar2.auv == itemId) {
                        vVar2.addFlags(32);
                        return vVar2;
                    }
                }
            }
            return null;
        }

        private v l(int i2, boolean z) {
            View view;
            int size = this.atF.size();
            for (int i3 = 0; i3 < size; i3++) {
                v vVar = this.atF.get(i3);
                if (!vVar.lX() && vVar.lQ() == i2 && !vVar.isInvalid() && (RecyclerView.this.asR.aue || !vVar.isRemoved())) {
                    vVar.addFlags(32);
                    return vVar;
                }
            }
            s sVar = RecyclerView.this.mChildHelper;
            int size2 = sVar.alZ.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size2) {
                    view = null;
                    break;
                }
                View view2 = sVar.alZ.get(i4);
                v bi = sVar.alX.bi(view2);
                if (!(bi.lQ() != i2 || bi.isInvalid() || bi.isRemoved())) {
                    view = view2;
                    break;
                }
                i4++;
            }
            if (view != null) {
                v bv = RecyclerView.bv(view);
                s sVar2 = RecyclerView.this.mChildHelper;
                int indexOfChild = sVar2.alX.indexOfChild(view);
                if (indexOfChild < 0) {
                    throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
                } else if (!sVar2.alY.get(indexOfChild)) {
                    throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(view)));
                } else {
                    sVar2.alY.clear(indexOfChild);
                    sVar2.bg(view);
                    int indexOfChild2 = RecyclerView.this.mChildHelper.indexOfChild(view);
                    if (indexOfChild2 == -1) {
                        throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + bv + RecyclerView.this.kL());
                    }
                    RecyclerView.this.mChildHelper.detachViewFromParent(indexOfChild2);
                    bH(view);
                    bv.addFlags(8224);
                    return bv;
                }
            } else {
                int size3 = this.atH.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    v vVar2 = this.atH.get(i5);
                    if (!vVar2.isInvalid() && vVar2.lQ() == i2) {
                        this.atH.remove(i5);
                        return vVar2;
                    }
                }
                return null;
            }
        }

        private v a(long j2, int i2, boolean z) {
            for (int size = this.atF.size() - 1; size >= 0; size--) {
                v vVar = this.atF.get(size);
                if (vVar.auv == j2 && !vVar.lX()) {
                    if (i2 == vVar.auw) {
                        vVar.addFlags(32);
                        if (!vVar.isRemoved() || RecyclerView.this.asR.aue) {
                            return vVar;
                        }
                        vVar.setFlags(2, 14);
                        return vVar;
                    }
                    this.atF.remove(size);
                    RecyclerView.this.removeDetachedView(vVar.aus, false);
                    bG(vVar.aus);
                }
            }
            for (int size2 = this.atH.size() - 1; size2 >= 0; size2--) {
                v vVar2 = this.atH.get(size2);
                if (vVar2.auv == j2) {
                    if (i2 == vVar2.auw) {
                        this.atH.remove(size2);
                        return vVar2;
                    } else {
                        cr(size2);
                        return null;
                    }
                }
            }
            return null;
        }

        private void v(v vVar) {
            if (RecyclerView.this.adj != null) {
                RecyclerView.this.adj.a(vVar);
            }
            if (RecyclerView.this.asR != null) {
                RecyclerView.this.arY.K(vVar);
            }
        }

        /* access modifiers changed from: package-private */
        public final m getRecycledViewPool() {
            if (this.atL == null) {
                this.atL = new m();
            }
            return this.atL;
        }

        /* access modifiers changed from: package-private */
        public final void lr() {
            int size = this.atH.size();
            for (int i2 = 0; i2 < size; i2++) {
                v vVar = this.atH.get(i2);
                if (vVar != null) {
                    vVar.addFlags(6);
                    vVar.O(null);
                }
            }
            if (RecyclerView.this.adj == null || !RecyclerView.this.adj.atk) {
                lJ();
            }
        }

        /* access modifiers changed from: package-private */
        public final void lq() {
            int size = this.atH.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.atH.get(i2).lN();
            }
            int size2 = this.atF.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.atF.get(i3).lN();
            }
            if (this.atG != null) {
                int size3 = this.atG.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    this.atG.get(i4).lN();
                }
            }
        }
    }

    public static abstract class a<VH extends v> {
        public final b atj = new b();
        protected boolean atk = false;

        public abstract VH a(ViewGroup viewGroup, int i2);

        public abstract void a(VH vh, int i2);

        public abstract int getItemCount();

        public void a(VH vh, int i2, List<Object> list) {
            a(vh, i2);
        }

        public final VH d(ViewGroup viewGroup, int i2) {
            try {
                android.support.v4.os.e.beginSection("RV CreateView");
                VH a2 = a(viewGroup, i2);
                if (a2.aus.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                a2.auw = i2;
                return a2;
            } finally {
                android.support.v4.os.e.endSection();
            }
        }

        public int getItemViewType(int i2) {
            return 0;
        }

        public long getItemId(int i2) {
            return -1;
        }

        public void a(VH vh) {
        }

        public void k(VH vh) {
        }

        public void l(VH vh) {
        }

        public void a(c cVar) {
            this.atj.registerObserver(cVar);
        }

        public void b(c cVar) {
            this.atj.unregisterObserver(cVar);
        }

        public void b(RecyclerView recyclerView) {
        }

        public void c(RecyclerView recyclerView) {
        }

        public final void notifyDataSetChanged() {
            this.atj.notifyChanged();
        }

        public final void ci(int i2) {
            this.atj.aq(i2, 1);
        }

        public final void b(int i2, Object obj) {
            this.atj.e(i2, 1, obj);
        }

        public final void aq(int i2, int i3) {
            this.atj.aq(i2, i3);
        }

        public final void e(int i2, int i3, Object obj) {
            this.atj.e(i2, i3, obj);
        }

        public final void cj(int i2) {
            this.atj.as(i2, 1);
        }

        public final void ar(int i2, int i3) {
            this.atj.ar(i2, i3);
        }

        public final void as(int i2, int i3) {
            this.atj.as(i2, i3);
        }

        public final void ck(int i2) {
            this.atj.at(i2, 1);
        }

        public final void at(int i2, int i3) {
            this.atj.at(i2, i3);
        }

        public void au(boolean z) {
            if (this.atj.hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.atk = z;
        }
    }

    /* access modifiers changed from: package-private */
    public final void bA(View view) {
        v bv = bv(view);
        if (!(this.adj == null || bv == null)) {
            this.adj.l(bv);
        }
        if (this.ass != null) {
            for (int size = this.ass.size() - 1; size >= 0; size--) {
                this.ass.get(size).bE(view);
            }
        }
    }

    public static abstract class LayoutManager {
        boolean mAutoMeasure = false;
        s mChildHelper;
        private int mHeight;
        private int mHeightMode;
        bf mHorizontalBoundCheck = new bf(this.mHorizontalBoundCheckCallback);
        private final bf.b mHorizontalBoundCheckCallback = new bf.b() {
            /* class android.support.v7.widget.RecyclerView.LayoutManager.AnonymousClass1 */

            @Override // android.support.v7.widget.bf.b
            public final View getChildAt(int i2) {
                return LayoutManager.this.getChildAt(i2);
            }

            @Override // android.support.v7.widget.bf.b
            public final int lE() {
                return LayoutManager.this.getPaddingLeft();
            }

            @Override // android.support.v7.widget.bf.b
            public final int lF() {
                return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
            }

            @Override // android.support.v7.widget.bf.b
            public final int bB(View view) {
                return LayoutManager.this.getDecoratedLeft(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            @Override // android.support.v7.widget.bf.b
            public final int bC(View view) {
                return ((LayoutParams) view.getLayoutParams()).rightMargin + LayoutManager.this.getDecoratedRight(view);
            }
        };
        boolean mIsAttachedToWindow = false;
        private boolean mItemPrefetchEnabled = true;
        private boolean mMeasurementCacheEnabled = true;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        protected RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations = false;
        r mSmoothScroller;
        bf mVerticalBoundCheck = new bf(this.mVerticalBoundCheckCallback);
        private final bf.b mVerticalBoundCheckCallback = new bf.b() {
            /* class android.support.v7.widget.RecyclerView.LayoutManager.AnonymousClass2 */

            @Override // android.support.v7.widget.bf.b
            public final View getChildAt(int i2) {
                return LayoutManager.this.getChildAt(i2);
            }

            @Override // android.support.v7.widget.bf.b
            public final int lE() {
                return LayoutManager.this.getPaddingTop();
            }

            @Override // android.support.v7.widget.bf.b
            public final int lF() {
                return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
            }

            @Override // android.support.v7.widget.bf.b
            public final int bB(View view) {
                return LayoutManager.this.getDecoratedTop(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            @Override // android.support.v7.widget.bf.b
            public final int bC(View view) {
                return ((LayoutParams) view.getLayoutParams()).bottomMargin + LayoutManager.this.getDecoratedBottom(view);
            }
        };
        private int mWidth;
        private int mWidthMode;

        public interface a {
            void S(int i2, int i3);
        }

        public static class b {
            public int att;
            public boolean atu;
            public boolean atv;
            public int orientation;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        /* access modifiers changed from: package-private */
        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        /* access modifiers changed from: package-private */
        public void setMeasureSpecs(int i2, int i3) {
            this.mWidth = View.MeasureSpec.getSize(i2);
            this.mWidthMode = View.MeasureSpec.getMode(i2);
            if (this.mWidthMode == 0 && !RecyclerView.arO) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i3);
            this.mHeightMode = View.MeasureSpec.getMode(i3);
            if (this.mHeightMode == 0 && !RecyclerView.arO) {
                this.mHeight = 0;
            }
        }

        /* access modifiers changed from: package-private */
        public void setMeasuredDimensionFromChildren(int i2, int i3) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.an(i2, i3);
                return;
            }
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MAX_VALUE;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                if (rect.left < i7) {
                    i7 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i6) {
                    i6 = rect.top;
                }
                if (rect.bottom > i4) {
                    i4 = rect.bottom;
                }
            }
            this.mRecyclerView.mTempRect.set(i7, i6, i5, i4);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i2, i3);
        }

        public void setMeasuredDimension(Rect rect, int i2, int i3) {
            setMeasuredDimension(chooseSize(i2, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i3, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void requestLayout() {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.requestLayout();
            }
        }

        public void assertInLayoutOrScroll(String str) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.assertInLayoutOrScroll(str);
            }
        }

        public static int chooseSize(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i3, i4));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i3, i4);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                if (this.mRecyclerView != null) {
                    this.mRecyclerView.arV.lI();
                }
            }
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public void collectAdjacentPrefetchPositions(int i2, int i3, s sVar, a aVar) {
        }

        public void collectInitialPrefetchPositions(int i2, a aVar) {
        }

        /* access modifiers changed from: package-private */
        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        /* access modifiers changed from: package-private */
        public void dispatchDetachedFromWindow(RecyclerView recyclerView, n nVar) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, nVar);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public void postOnAnimation(Runnable runnable) {
            if (this.mRecyclerView != null) {
                android.support.v4.view.u.b(this.mRecyclerView, runnable);
            }
        }

        public boolean removeCallbacks(Runnable runnable) {
            if (this.mRecyclerView != null) {
                return this.mRecyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, n nVar) {
            onDetachedFromWindow(recyclerView);
        }

        public boolean getClipToPadding() {
            return this.mRecyclerView != null && this.mRecyclerView.arZ;
        }

        public void onLayoutChildren(n nVar, s sVar) {
        }

        public void onLayoutCompleted(s sVar) {
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public int scrollHorizontallyBy(int i2, n nVar, s sVar) {
            return 0;
        }

        public int scrollVerticallyBy(int i2, n nVar, s sVar) {
            return 0;
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public void scrollToPosition(int i2) {
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, s sVar, int i2) {
        }

        public void startSmoothScroll(r rVar) {
            if (!(this.mSmoothScroller == null || rVar == this.mSmoothScroller || !this.mSmoothScroller.gc)) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = rVar;
            r rVar2 = this.mSmoothScroller;
            RecyclerView recyclerView = this.mRecyclerView;
            if (rVar2.mStarted) {
                new StringBuilder("An instance of ").append(rVar2.getClass().getSimpleName()).append(" was started more than once. Each instance of").append(rVar2.getClass().getSimpleName()).append(" is intended to only be used once. You should create a new instance for each use.");
            }
            rVar2.mRecyclerView = recyclerView;
            rVar2.arI = this;
            if (rVar2.atO == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            rVar2.mRecyclerView.asR.atO = rVar2.atO;
            rVar2.gc = true;
            rVar2.atP = true;
            rVar2.atQ = rVar2.mRecyclerView.asc.findViewByPosition(rVar2.atO);
            rVar2.mRecyclerView.asO.lM();
            rVar2.mStarted = true;
        }

        public boolean isSmoothScrolling() {
            return this.mSmoothScroller != null && this.mSmoothScroller.gc;
        }

        public int getLayoutDirection() {
            return android.support.v4.view.u.Z(this.mRecyclerView);
        }

        public void endAnimation(View view) {
            if (this.mRecyclerView.asC != null) {
                this.mRecyclerView.asC.d(RecyclerView.bv(view));
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int i2) {
            addViewInt(view, i2, true);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void addView(View view, int i2) {
            addViewInt(view, i2, false);
        }

        private void addViewInt(View view, int i2, boolean z) {
            v bv = RecyclerView.bv(view);
            if (z || bv.isRemoved()) {
                this.mRecyclerView.arY.I(bv);
            } else {
                this.mRecyclerView.arY.J(bv);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (bv.lX() || bv.lV()) {
                if (bv.lV()) {
                    bv.lW();
                } else {
                    bv.lY();
                }
                this.mChildHelper.a(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int indexOfChild = this.mChildHelper.indexOfChild(view);
                if (i2 == -1) {
                    i2 = this.mChildHelper.getChildCount();
                }
                if (indexOfChild == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.kL());
                } else if (indexOfChild != i2) {
                    this.mRecyclerView.asc.moveView(indexOfChild, i2);
                }
            } else {
                this.mChildHelper.a(view, i2, false);
                layoutParams.atx = true;
                if (this.mSmoothScroller != null && this.mSmoothScroller.gc) {
                    r rVar = this.mSmoothScroller;
                    if (RecyclerView.bx(view) == rVar.atO) {
                        rVar.atQ = view;
                    }
                }
            }
            if (layoutParams.aty) {
                bv.aus.invalidate();
                layoutParams.aty = false;
            }
        }

        public void removeView(View view) {
            s sVar = this.mChildHelper;
            int indexOfChild = sVar.alX.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (sVar.alY.remove(indexOfChild)) {
                    sVar.bg(view);
                }
                sVar.alX.removeViewAt(indexOfChild);
            }
        }

        public void removeViewAt(int i2) {
            if (getChildAt(i2) != null) {
                this.mChildHelper.removeViewAt(i2);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.removeViewAt(childCount);
            }
        }

        public int getBaseline() {
            return -1;
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).atw.lQ();
        }

        public int getItemViewType(View view) {
            return RecyclerView.bv(view).auw;
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            if (this.mRecyclerView == null || (findContainingItemView = this.mRecyclerView.findContainingItemView(view)) == null || this.mChildHelper.bh(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i2) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                v bv = RecyclerView.bv(childAt);
                if (bv != null && bv.lQ() == i2 && !bv.lP() && (this.mRecyclerView.asR.aue || !bv.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public void detachView(View view) {
            int indexOfChild = this.mChildHelper.indexOfChild(view);
            if (indexOfChild >= 0) {
                detachViewInternal(indexOfChild, view);
            }
        }

        public void detachViewAt(int i2) {
            detachViewInternal(i2, getChildAt(i2));
        }

        private void detachViewInternal(int i2, View view) {
            this.mChildHelper.detachViewFromParent(i2);
        }

        public void attachView(View view, int i2, LayoutParams layoutParams) {
            v bv = RecyclerView.bv(view);
            if (bv.isRemoved()) {
                this.mRecyclerView.arY.I(bv);
            } else {
                this.mRecyclerView.arY.J(bv);
            }
            this.mChildHelper.a(view, i2, layoutParams, bv.isRemoved());
        }

        public void attachView(View view, int i2) {
            attachView(view, i2, (LayoutParams) view.getLayoutParams());
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void moveView(int i2, int i3) {
            View childAt = getChildAt(i2);
            if (childAt == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2 + this.mRecyclerView.toString());
            }
            detachViewAt(i2);
            attachView(childAt, i3);
        }

        public void detachAndScrapView(View view, n nVar) {
            scrapOrRecycleView(nVar, this.mChildHelper.indexOfChild(view), view);
        }

        public void detachAndScrapViewAt(int i2, n nVar) {
            scrapOrRecycleView(nVar, i2, getChildAt(i2));
        }

        public void removeAndRecycleView(View view, n nVar) {
            removeView(view);
            nVar.bF(view);
        }

        public void removeAndRecycleViewAt(int i2, n nVar) {
            View childAt = getChildAt(i2);
            removeViewAt(i2);
            nVar.bF(childAt);
        }

        public int getChildCount() {
            if (this.mChildHelper != null) {
                return this.mChildHelper.getChildCount();
            }
            return 0;
        }

        public View getChildAt(int i2) {
            if (this.mChildHelper != null) {
                return this.mChildHelper.getChildAt(i2);
            }
            return null;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getPaddingLeft() {
            if (this.mRecyclerView != null) {
                return this.mRecyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingTop() {
            if (this.mRecyclerView != null) {
                return this.mRecyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPaddingRight() {
            if (this.mRecyclerView != null) {
                return this.mRecyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingBottom() {
            if (this.mRecyclerView != null) {
                return this.mRecyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingStart() {
            if (this.mRecyclerView != null) {
                return android.support.v4.view.u.ac(this.mRecyclerView);
            }
            return 0;
        }

        public int getPaddingEnd() {
            if (this.mRecyclerView != null) {
                return android.support.v4.view.u.ad(this.mRecyclerView);
            }
            return 0;
        }

        public boolean isFocused() {
            return this.mRecyclerView != null && this.mRecyclerView.isFocused();
        }

        public boolean hasFocus() {
            return this.mRecyclerView != null && this.mRecyclerView.hasFocus();
        }

        public View getFocusedChild() {
            View focusedChild;
            if (this.mRecyclerView == null || (focusedChild = this.mRecyclerView.getFocusedChild()) == null || this.mChildHelper.bh(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getItemCount() {
            a adapter = this.mRecyclerView != null ? this.mRecyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void offsetChildrenHorizontal(int i2) {
            if (this.mRecyclerView != null) {
                RecyclerView recyclerView = this.mRecyclerView;
                int childCount = recyclerView.mChildHelper.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    recyclerView.mChildHelper.getChildAt(i3).offsetLeftAndRight(i2);
                }
            }
        }

        public void offsetChildrenVertical(int i2) {
            if (this.mRecyclerView != null) {
                RecyclerView recyclerView = this.mRecyclerView;
                int childCount = recyclerView.mChildHelper.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    recyclerView.mChildHelper.getChildAt(i3).offsetTopAndBottom(i2);
                }
            }
        }

        public void ignoreView(View view) {
            if (view.getParent() != this.mRecyclerView || this.mRecyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.kL());
            }
            v bv = RecyclerView.bv(view);
            bv.addFlags(128);
            this.mRecyclerView.arY.K(bv);
        }

        public void stopIgnoringView(View view) {
            v bv = RecyclerView.bv(view);
            bv.FV &= -129;
            bv.resetInternal();
            bv.addFlags(4);
        }

        public void detachAndScrapAttachedViews(n nVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(nVar, childCount, getChildAt(childCount));
            }
        }

        private void scrapOrRecycleView(n nVar, int i2, View view) {
            v bv = RecyclerView.bv(view);
            if (!bv.lP()) {
                if (!bv.isInvalid() || bv.isRemoved() || this.mRecyclerView.adj.atk) {
                    detachViewAt(i2);
                    nVar.bH(view);
                    this.mRecyclerView.arY.J(bv);
                    return;
                }
                removeViewAt(i2);
                nVar.t(bv);
            }
        }

        /* access modifiers changed from: package-private */
        public void removeAndRecycleScrapInt(n nVar) {
            int size = nVar.atF.size();
            for (int i2 = size - 1; i2 >= 0; i2--) {
                View view = nVar.atF.get(i2).aus;
                v bv = RecyclerView.bv(view);
                if (!bv.lP()) {
                    bv.av(false);
                    if (bv.mb()) {
                        this.mRecyclerView.removeDetachedView(view, false);
                    }
                    if (this.mRecyclerView.asC != null) {
                        this.mRecyclerView.asC.d(bv);
                    }
                    bv.av(true);
                    nVar.bG(view);
                }
            }
            nVar.atF.clear();
            if (nVar.atG != null) {
                nVar.atG.clear();
            }
            if (size > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void measureChild(View view, int i2, int i3) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect by = this.mRecyclerView.by(view);
            int i4 = by.top;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), by.left + by.right + i2 + getPaddingLeft() + getPaddingRight(), layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), by.bottom + i4 + i3 + getPaddingTop() + getPaddingBottom(), layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean shouldReMeasureChild(View view, int i2, int i3, LayoutParams layoutParams) {
            return !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getMeasuredWidth(), i2, layoutParams.width) || !isMeasurementUpToDate(view.getMeasuredHeight(), i3, layoutParams.height);
        }

        /* access modifiers changed from: package-private */
        public boolean shouldMeasureChild(View view, int i2, int i3, LayoutParams layoutParams) {
            return view.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getWidth(), i2, layoutParams.width) || !isMeasurementUpToDate(view.getHeight(), i3, layoutParams.height);
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        private static boolean isMeasurementUpToDate(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            switch (mode) {
                case Integer.MIN_VALUE:
                    return size >= i2;
                case 0:
                    return true;
                case 1073741824:
                    return size == i2;
                default:
                    return false;
            }
        }

        public void measureChildWithMargins(View view, int i2, int i3) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect by = this.mRecyclerView.by(view);
            int i4 = by.top;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), by.left + by.right + i2 + getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), by.bottom + i4 + i3 + getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        @Deprecated
        public static int getChildMeasureSpec(int i2, int i3, int i4, boolean z) {
            int i5 = 1073741824;
            int max = Math.max(0, i2 - i3);
            if (z) {
                if (i4 < 0) {
                    i5 = 0;
                    i4 = 0;
                }
            } else if (i4 < 0) {
                if (i4 == -1) {
                    i4 = max;
                } else if (i4 == -2) {
                    i5 = Integer.MIN_VALUE;
                    i4 = max;
                } else {
                    i5 = 0;
                    i4 = 0;
                }
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i5);
        }

        public static int getChildMeasureSpec(int i2, int i3, int i4, int i5, boolean z) {
            int max = Math.max(0, i2 - i4);
            if (z) {
                if (i5 >= 0) {
                    i3 = 1073741824;
                    max = i5;
                } else if (i5 == -1) {
                    switch (i3) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            break;
                        case 0:
                        default:
                            i3 = 0;
                            max = 0;
                            break;
                    }
                } else {
                    if (i5 == -2) {
                        max = 0;
                        i3 = 0;
                    }
                    i3 = 0;
                    max = 0;
                }
            } else if (i5 >= 0) {
                i3 = 1073741824;
                max = i5;
            } else if (i5 != -1) {
                if (i5 == -2) {
                    if (i3 == Integer.MIN_VALUE || i3 == 1073741824) {
                        i3 = Integer.MIN_VALUE;
                    }
                    i3 = 0;
                }
                i3 = 0;
                max = 0;
            }
            return View.MeasureSpec.makeMeasureSpec(max, i3);
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).apS;
            return rect.right + view.getMeasuredWidth() + rect.left;
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).apS;
            return rect.bottom + view.getMeasuredHeight() + rect.top;
        }

        public void layoutDecorated(View view, int i2, int i3, int i4, int i5) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).apS;
            view.layout(rect.left + i2, rect.top + i3, i4 - rect.right, i5 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i2, int i3, int i4, int i5) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.apS;
            view.layout(rect.left + i2 + layoutParams.leftMargin, rect.top + i3 + layoutParams.topMargin, (i4 - rect.right) - layoutParams.rightMargin, (i5 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).apS;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, rect2.bottom + view.getHeight());
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.mRecyclerView == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.mRecyclerView.asb;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.c(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            if (this.mRecyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.mRecyclerView.by(view));
            }
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).apS.top;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).apS.bottom;
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).apS.left;
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).apS.right;
        }

        public View onFocusSearchFailed(View view, int i2, n nVar, s sVar) {
            return null;
        }

        public View onInterceptFocusSearch(View view, int i2) {
            return null;
        }

        private int[] getChildRectangleOnScreenScrollAmount(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int min;
            int i2;
            int min2;
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = left + rect.width();
            int height2 = top + rect.height();
            int min3 = Math.min(0, left - paddingLeft);
            int min4 = Math.min(0, top - paddingTop);
            int max = Math.max(0, width2 - width);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() == 1) {
                if (max == 0) {
                    max = Math.max(min3, width2 - width);
                }
                i2 = max;
            } else {
                if (min3 != 0) {
                    min = min3;
                } else {
                    min = Math.min(left - paddingLeft, max);
                }
                i2 = min;
            }
            if (min4 != 0) {
                min2 = min4;
            } else {
                min2 = Math.min(top - paddingTop, max2);
            }
            iArr[0] = i2;
            iArr[1] = min2;
            return iArr;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(recyclerView, view, rect, z);
            int i2 = childRectangleOnScreenScrollAmount[0];
            int i3 = childRectangleOnScreenScrollAmount[1];
            if (z2 && !isFocusedChildVisibleAfterScrolling(recyclerView, i2, i3)) {
                return false;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i2, i3);
            } else {
                recyclerView.a(i2, i3, (Interpolator) null);
            }
            return true;
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3;
            if (!this.mHorizontalBoundCheck.bR(view) || !this.mVerticalBoundCheck.bR(view)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z) {
                return z3;
            }
            return !z3;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i2, int i3) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            if (rect.left - i2 >= width || rect.right - i2 <= paddingLeft || rect.top - i3 >= height || rect.bottom - i3 <= paddingTop) {
                return false;
            }
            return true;
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.ld();
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, s sVar, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public void onAdapterChanged(a aVar, a aVar2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i2, int i3) {
            return false;
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
            onItemsUpdated(recyclerView, i2, i3);
        }

        public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public int computeHorizontalScrollExtent(s sVar) {
            return 0;
        }

        public int computeHorizontalScrollOffset(s sVar) {
            return 0;
        }

        public int computeHorizontalScrollRange(s sVar) {
            return 0;
        }

        public int computeVerticalScrollExtent(s sVar) {
            return 0;
        }

        public int computeVerticalScrollOffset(s sVar) {
            return 0;
        }

        public int computeVerticalScrollRange(s sVar) {
            return 0;
        }

        public void onMeasure(n nVar, s sVar, int i2, int i3) {
            this.mRecyclerView.an(i2, i3);
        }

        public void setMeasuredDimension(int i2, int i3) {
            this.mRecyclerView.setMeasuredDimension(i2, i3);
        }

        public int getMinimumWidth() {
            return android.support.v4.view.u.af(this.mRecyclerView);
        }

        public int getMinimumHeight() {
            return android.support.v4.view.u.ag(this.mRecyclerView);
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        /* access modifiers changed from: package-private */
        public void stopSmoothScroller() {
            if (this.mSmoothScroller != null) {
                this.mSmoothScroller.stop();
            }
        }

        /* access modifiers changed from: package-private */
        public void onSmoothScrollerStopped(r rVar) {
            if (this.mSmoothScroller == rVar) {
                this.mSmoothScroller = null;
            }
        }

        public void onScrollStateChanged(int i2) {
        }

        public void removeAndRecycleAllViews(n nVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.bv(getChildAt(childCount)).lP()) {
                    removeAndRecycleViewAt(childCount, nVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfo(android.support.v4.view.a.c cVar) {
            onInitializeAccessibilityNodeInfo(this.mRecyclerView.arV, this.mRecyclerView.asR, cVar);
        }

        public void onInitializeAccessibilityNodeInfo(n nVar, s sVar, android.support.v4.view.a.c cVar) {
            c.b bVar;
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                cVar.addAction(8192);
                cVar.setScrollable(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                cVar.addAction(4096);
                cVar.setScrollable(true);
            }
            int rowCountForAccessibility = getRowCountForAccessibility(nVar, sVar);
            int columnCountForAccessibility = getColumnCountForAccessibility(nVar, sVar);
            boolean isLayoutHierarchical = isLayoutHierarchical(nVar, sVar);
            int selectionModeForAccessibility = getSelectionModeForAccessibility(nVar, sVar);
            if (Build.VERSION.SDK_INT >= 21) {
                bVar = new c.b(AccessibilityNodeInfo.CollectionInfo.obtain(rowCountForAccessibility, columnCountForAccessibility, isLayoutHierarchical, selectionModeForAccessibility));
            } else if (Build.VERSION.SDK_INT >= 19) {
                bVar = new c.b(AccessibilityNodeInfo.CollectionInfo.obtain(rowCountForAccessibility, columnCountForAccessibility, isLayoutHierarchical));
            } else {
                bVar = new c.b(null);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                cVar.Ro.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) bVar.RY);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onInitializeAccessibilityEvent(this.mRecyclerView.arV, this.mRecyclerView.asR, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(n nVar, s sVar, AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            if (this.mRecyclerView != null && accessibilityEvent != null) {
                if (!this.mRecyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                if (this.mRecyclerView.adj != null) {
                    accessibilityEvent.setItemCount(this.mRecyclerView.adj.getItemCount());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfoForItem(View view, android.support.v4.view.a.c cVar) {
            v bv = RecyclerView.bv(view);
            if (bv != null && !bv.isRemoved() && !this.mChildHelper.bh(bv.aus)) {
                onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.arV, this.mRecyclerView.asR, view, cVar);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(n nVar, s sVar, View view, android.support.v4.view.a.c cVar) {
            int i2;
            int position = canScrollVertically() ? getPosition(view) : 0;
            if (canScrollHorizontally()) {
                i2 = getPosition(view);
            } else {
                i2 = 0;
            }
            cVar.H(c.C0036c.a(position, 1, i2, 1, false));
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int getSelectionModeForAccessibility(n nVar, s sVar) {
            return 0;
        }

        public int getRowCountForAccessibility(n nVar, s sVar) {
            if (this.mRecyclerView == null || this.mRecyclerView.adj == null || !canScrollVertically()) {
                return 1;
            }
            return this.mRecyclerView.adj.getItemCount();
        }

        public int getColumnCountForAccessibility(n nVar, s sVar) {
            if (this.mRecyclerView == null || this.mRecyclerView.adj == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.mRecyclerView.adj.getItemCount();
        }

        public boolean isLayoutHierarchical(n nVar, s sVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean performAccessibilityAction(int i2, Bundle bundle) {
            return performAccessibilityAction(this.mRecyclerView.arV, this.mRecyclerView.asR, i2, bundle);
        }

        public boolean performAccessibilityAction(n nVar, s sVar, int i2, Bundle bundle) {
            int i3;
            int i4;
            if (this.mRecyclerView == null) {
                return false;
            }
            switch (i2) {
                case 4096:
                    if (this.mRecyclerView.canScrollVertically(1)) {
                        i3 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                    } else {
                        i3 = 0;
                    }
                    if (this.mRecyclerView.canScrollHorizontally(1)) {
                        i4 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                        break;
                    }
                    i4 = 0;
                    break;
                case 8192:
                    if (this.mRecyclerView.canScrollVertically(-1)) {
                        i3 = -((getHeight() - getPaddingTop()) - getPaddingBottom());
                    } else {
                        i3 = 0;
                    }
                    if (this.mRecyclerView.canScrollHorizontally(-1)) {
                        i4 = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                        break;
                    }
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    i3 = 0;
                    break;
            }
            if (i3 == 0 && i4 == 0) {
                return false;
            }
            this.mRecyclerView.a(i4, i3, (Interpolator) null);
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean performAccessibilityActionForItem(View view, int i2, Bundle bundle) {
            return performAccessibilityActionForItem(this.mRecyclerView.arV, this.mRecyclerView.asR, view, i2, bundle);
        }

        public boolean performAccessibilityActionForItem(n nVar, s sVar, View view, int i2, Bundle bundle) {
            return false;
        }

        public static b getProperties(Context context, AttributeSet attributeSet, int i2, int i3) {
            b bVar = new b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0049a.RecyclerView, i2, i3);
            bVar.orientation = obtainStyledAttributes.getInt(0, 1);
            bVar.att = obtainStyledAttributes.getInt(9, 1);
            bVar.atu = obtainStyledAttributes.getBoolean(8, false);
            bVar.atv = obtainStyledAttributes.getBoolean(10, false);
            obtainStyledAttributes.recycle();
            return bVar;
        }

        /* access modifiers changed from: package-private */
        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* access modifiers changed from: package-private */
        public boolean shouldMeasureTwice() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public static abstract class h {
        public void a(Canvas canvas, RecyclerView recyclerView, s sVar) {
        }

        public void b(Canvas canvas, RecyclerView recyclerView, s sVar) {
        }

        @Deprecated
        public void a(Rect rect, int i2, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
            a(rect, ((LayoutParams) view.getLayoutParams()).atw.lQ(), recyclerView);
        }
    }

    public static class q implements k {
        @Override // android.support.v7.widget.RecyclerView.k
        public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            return false;
        }

        @Override // android.support.v7.widget.RecyclerView.k
        public final void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        @Override // android.support.v7.widget.RecyclerView.k
        public final void ah(boolean z) {
        }
    }

    public static abstract class l {
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        }

        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        }
    }

    public static abstract class v {
        private static final List<Object> auA = Collections.emptyList();
        int FV;
        List<Object> auB = null;
        List<Object> auC = null;
        private int auD = 0;
        n auE = null;
        boolean auF = false;
        int auG = 0;
        int auH = -1;
        RecyclerView auI;
        public final View aus;
        WeakReference<RecyclerView> aut;
        public int auu = -1;
        public long auv = -1;
        public int auw = -1;
        int aux = -1;
        v auy = null;
        v auz = null;
        int mPosition = -1;

        public v(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.aus = view;
        }

        /* access modifiers changed from: package-private */
        public final void m(int i2, boolean z) {
            if (this.auu == -1) {
                this.auu = this.mPosition;
            }
            if (this.aux == -1) {
                this.aux = this.mPosition;
            }
            if (z) {
                this.aux += i2;
            }
            this.mPosition += i2;
            if (this.aus.getLayoutParams() != null) {
                ((LayoutParams) this.aus.getLayoutParams()).atx = true;
            }
        }

        /* access modifiers changed from: package-private */
        public final void lN() {
            this.auu = -1;
            this.aux = -1;
        }

        /* access modifiers changed from: package-private */
        public final void lO() {
            if (this.auu == -1) {
                this.auu = this.mPosition;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean lP() {
            return (this.FV & 128) != 0;
        }

        @Deprecated
        public final int getPosition() {
            return this.aux == -1 ? this.mPosition : this.aux;
        }

        public final int lQ() {
            return this.aux == -1 ? this.mPosition : this.aux;
        }

        public final int lR() {
            if (this.auI == null) {
                return -1;
            }
            return this.auI.i(this);
        }

        public final int lS() {
            return this.auu;
        }

        public final long lT() {
            return this.auv;
        }

        public final int lU() {
            return this.auw;
        }

        /* access modifiers changed from: package-private */
        public final boolean lV() {
            return this.auE != null;
        }

        /* access modifiers changed from: package-private */
        public final void lW() {
            this.auE.u(this);
        }

        /* access modifiers changed from: package-private */
        public final boolean lX() {
            return (this.FV & 32) != 0;
        }

        /* access modifiers changed from: package-private */
        public final void lY() {
            this.FV &= -33;
        }

        /* access modifiers changed from: package-private */
        public final void lZ() {
            this.FV &= -257;
        }

        /* access modifiers changed from: package-private */
        public final void a(n nVar, boolean z) {
            this.auE = nVar;
            this.auF = z;
        }

        /* access modifiers changed from: package-private */
        public final boolean isInvalid() {
            return (this.FV & 4) != 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean ma() {
            return (this.FV & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean isBound() {
            return (this.FV & 1) != 0;
        }

        public final boolean isRemoved() {
            return (this.FV & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean cv(int i2) {
            return (this.FV & i2) != 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean mb() {
            return (this.FV & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        public final void setFlags(int i2, int i3) {
            this.FV = (this.FV & (i3 ^ -1)) | (i2 & i3);
        }

        /* access modifiers changed from: package-private */
        public final void addFlags(int i2) {
            this.FV |= i2;
        }

        /* access modifiers changed from: package-private */
        public final void O(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((this.FV & 1024) == 0) {
                mc();
                this.auB.add(obj);
            }
        }

        private void mc() {
            if (this.auB == null) {
                this.auB = new ArrayList();
                this.auC = Collections.unmodifiableList(this.auB);
            }
        }

        /* access modifiers changed from: package-private */
        public final void md() {
            if (this.auB != null) {
                this.auB.clear();
            }
            this.FV &= -1025;
        }

        /* access modifiers changed from: package-private */
        public final List<Object> me() {
            if ((this.FV & 1024) != 0) {
                return auA;
            }
            if (this.auB == null || this.auB.size() == 0) {
                return auA;
            }
            return this.auC;
        }

        /* access modifiers changed from: package-private */
        public final void resetInternal() {
            this.FV = 0;
            this.mPosition = -1;
            this.auu = -1;
            this.auv = -1;
            this.aux = -1;
            this.auD = 0;
            this.auy = null;
            this.auz = null;
            md();
            this.auG = 0;
            this.auH = -1;
            RecyclerView.h(this);
        }

        public String toString() {
            boolean z;
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.auv + ", oldPos=" + this.auu + ", pLpos:" + this.aux);
            if (lV()) {
                sb.append(" scrap ").append(this.auF ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (ma()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (lP()) {
                sb.append(" ignored");
            }
            if (mb()) {
                sb.append(" tmpDetached");
            }
            if (!mf()) {
                sb.append(" not recyclable(" + this.auD + ")");
            }
            if ((this.FV & 512) != 0 || isInvalid()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                sb.append(" undefined adapter position");
            }
            if (this.aus.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void av(boolean z) {
            this.auD = z ? this.auD - 1 : this.auD + 1;
            if (this.auD < 0) {
                this.auD = 0;
                new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
            } else if (!z && this.auD == 1) {
                this.FV |= 16;
            } else if (z && this.auD == 0) {
                this.FV &= -17;
            }
        }

        public final boolean mf() {
            return (this.FV & 16) == 0 && !android.support.v4.view.u.W(this.aus);
        }

        /* access modifiers changed from: package-private */
        public final boolean mg() {
            return (this.FV & 16) == 0 && android.support.v4.view.u.W(this.aus);
        }

        /* access modifiers changed from: package-private */
        public final boolean mh() {
            return (this.FV & 2) != 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b(v vVar, int i2) {
        if (ld()) {
            vVar.auH = i2;
            this.ate.add(vVar);
            return false;
        }
        android.support.v4.view.u.p(vVar.aus, i2);
        return true;
    }

    private void lu() {
        int i2;
        for (int size = this.ate.size() - 1; size >= 0; size--) {
            v vVar = this.ate.get(size);
            if (vVar.aus.getParent() == this && !vVar.lP() && (i2 = vVar.auH) != -1) {
                android.support.v4.view.u.p(vVar.aus, i2);
                vVar.auH = -1;
            }
        }
        this.ate.clear();
    }

    /* access modifiers changed from: package-private */
    public final int i(v vVar) {
        if (vVar.cv(EasyGoCode.InvokedErrCode.SECURITY_EXCEPTION) || !vVar.isBound()) {
            return -1;
        }
        return this.arX.bF(vVar.mPosition);
    }

    @Override // android.support.v4.view.j
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    @Override // android.support.v4.view.j
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().PY;
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().A(i2, 0);
    }

    private boolean A(int i2, int i3) {
        return getScrollingChildHelper().A(i2, i3);
    }

    @Override // android.support.v4.view.j
    public void stopNestedScroll() {
        getScrollingChildHelper().aM(0);
    }

    @Override // android.support.v4.view.k
    public final void aM(int i2) {
        getScrollingChildHelper().aM(i2);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().aN(0);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    public final boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    public final boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f2, f3, z);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().dispatchNestedPreFling(f2, f3);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        final Rect apS = new Rect();
        public v atw;
        boolean atx = true;
        boolean aty = false;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
        }

        public final int lG() {
            return this.atw.lR();
        }
    }

    public static abstract class c {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i2, int i3) {
        }

        public void onItemRangeChanged(int i2, int i3, Object obj) {
            onItemRangeChanged(i2, i3);
        }

        public void onItemRangeInserted(int i2, int i3) {
        }

        public void onItemRangeRemoved(int i2, int i3) {
        }

        public void onItemRangeMoved(int i2, int i3, int i4) {
        }
    }

    public static abstract class r {
        LayoutManager arI;
        public int atO = -1;
        boolean atP;
        View atQ;
        private final a atR = new a();
        boolean gc;
        RecyclerView mRecyclerView;
        boolean mStarted;

        public interface b {
            PointF bZ(int i2);
        }

        /* access modifiers changed from: protected */
        public abstract void a(int i2, int i3, a aVar);

        /* access modifiers changed from: protected */
        public abstract void a(View view, s sVar, a aVar);

        /* access modifiers changed from: protected */
        public abstract void onStop();

        public final void ct(int i2) {
            this.atO = i2;
        }

        public final LayoutManager getLayoutManager() {
            return this.arI;
        }

        /* access modifiers changed from: protected */
        public final void stop() {
            if (this.gc) {
                this.gc = false;
                onStop();
                this.mRecyclerView.asR.atO = -1;
                this.atQ = null;
                this.atO = -1;
                this.atP = false;
                this.arI.onSmoothScrollerStopped(this);
                this.arI = null;
                this.mRecyclerView = null;
            }
        }

        public final boolean isRunning() {
            return this.gc;
        }

        /* access modifiers changed from: package-private */
        public final void ax(int i2, int i3) {
            PointF bZ;
            boolean z = false;
            RecyclerView recyclerView = this.mRecyclerView;
            if (!this.gc || this.atO == -1 || recyclerView == null) {
                stop();
            }
            if (!(!this.atP || this.atQ != null || this.arI == null || (bZ = bZ(this.atO)) == null || (bZ.x == 0.0f && bZ.y == 0.0f))) {
                recyclerView.b((int) Math.signum(bZ.x), (int) Math.signum(bZ.y), (int[]) null);
            }
            this.atP = false;
            if (this.atQ != null) {
                if (RecyclerView.bx(this.atQ) == this.atO) {
                    a(this.atQ, recyclerView.asR, this.atR);
                    this.atR.e(recyclerView);
                    stop();
                } else {
                    this.atQ = null;
                }
            }
            if (this.gc) {
                a(i2, i3, this.atR);
                if (this.atR.atV >= 0) {
                    z = true;
                }
                this.atR.e(recyclerView);
                if (!z) {
                    return;
                }
                if (this.gc) {
                    this.atP = true;
                    recyclerView.asO.lM();
                    return;
                }
                stop();
            }
        }

        public static class a {
            private int atS;
            private int atT;
            private int atU;
            int atV;
            private boolean atW;
            private int atX;
            private Interpolator mInterpolator;

            public a() {
                this((byte) 0);
            }

            private a(byte b2) {
                this.atV = -1;
                this.atW = false;
                this.atX = 0;
                this.atS = 0;
                this.atT = 0;
                this.atU = Integer.MIN_VALUE;
                this.mInterpolator = null;
            }

            /* access modifiers changed from: package-private */
            public final void e(RecyclerView recyclerView) {
                if (this.atV >= 0) {
                    int i2 = this.atV;
                    this.atV = -1;
                    recyclerView.cf(i2);
                    this.atW = false;
                } else if (this.atW) {
                    validate();
                    if (this.mInterpolator != null) {
                        recyclerView.asO.b(this.atS, this.atT, this.atU, this.mInterpolator);
                    } else if (this.atU == Integer.MIN_VALUE) {
                        recyclerView.asO.ay(this.atS, this.atT);
                    } else {
                        recyclerView.asO.l(this.atS, this.atT, this.atU);
                    }
                    this.atX++;
                    this.atW = false;
                } else {
                    this.atX = 0;
                }
            }

            private void validate() {
                if (this.mInterpolator != null && this.atU <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.atU <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public final void a(int i2, int i3, int i4, Interpolator interpolator) {
                this.atS = i2;
                this.atT = i3;
                this.atU = i4;
                this.mInterpolator = interpolator;
                this.atW = true;
            }
        }

        public PointF bZ(int i2) {
            LayoutManager layoutManager = this.arI;
            if (layoutManager instanceof b) {
                return ((b) layoutManager).bZ(i2);
            }
            new StringBuilder("You should override computeScrollVectorForPosition when the LayoutManager does not implement ").append(b.class.getCanonicalName());
            return null;
        }
    }

    public static class b extends Observable<c> {
        b() {
        }

        public final boolean hasObservers() {
            return !this.mObservers.isEmpty();
        }

        public final void notifyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onChanged();
            }
        }

        public final void aq(int i2, int i3) {
            e(i2, i3, null);
        }

        public final void e(int i2, int i3, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeChanged(i2, i3, obj);
            }
        }

        public final void as(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeInserted(i2, i3);
            }
        }

        public final void at(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeRemoved(i2, i3);
            }
        }

        public final void ar(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeMoved(i2, i3, 1);
            }
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class android.support.v7.widget.RecyclerView.SavedState.AnonymousClass1 */

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
        Parcelable atN;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.atN = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.atN, 0);
        }
    }

    public static class s {
        int atO = -1;
        private SparseArray<Object> atY;
        int atZ = 0;
        int aua = 0;
        int aub = 1;
        int auc = 0;
        boolean aud = false;
        public boolean aue = false;
        boolean auf = false;
        boolean aug = false;
        boolean auh = false;
        public boolean aui = false;
        int auj;
        long auk;
        int aul;
        int aum;
        int aun;

        /* access modifiers changed from: package-private */
        public final void cu(int i2) {
            if ((this.aub & i2) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.aub));
            }
        }

        public final boolean lL() {
            return this.aue;
        }

        public final int getItemCount() {
            return this.aue ? this.atZ - this.aua : this.auc;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.atO + ", mData=" + this.atY + ", mItemCount=" + this.auc + ", mIsMeasuring=" + this.aug + ", mPreviousLayoutItemCount=" + this.atZ + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.aua + ", mStructureChanged=" + this.aud + ", mInPreLayout=" + this.aue + ", mRunSimpleAnimations=" + this.auh + ", mRunPredictiveAnimations=" + this.aui + '}';
        }
    }

    class g implements f.b {
        g() {
        }

        @Override // android.support.v7.widget.RecyclerView.f.b
        public final void o(v vVar) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            vVar.av(true);
            if (vVar.auy != null && vVar.auz == null) {
                vVar.auy = null;
            }
            vVar.auz = null;
            if ((vVar.FV & 16) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                RecyclerView recyclerView = RecyclerView.this;
                View view = vVar.aus;
                recyclerView.kP();
                s sVar = recyclerView.mChildHelper;
                int indexOfChild = sVar.alX.indexOfChild(view);
                if (indexOfChild == -1) {
                    sVar.bg(view);
                    z2 = true;
                } else if (sVar.alY.get(indexOfChild)) {
                    sVar.alY.remove(indexOfChild);
                    sVar.bg(view);
                    sVar.alX.removeViewAt(indexOfChild);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    v bv = RecyclerView.bv(view);
                    recyclerView.arV.u(bv);
                    recyclerView.arV.t(bv);
                }
                if (z2) {
                    z3 = false;
                }
                recyclerView.ar(z3);
                if (!z2 && vVar.mb()) {
                    RecyclerView.this.removeDetachedView(vVar.aus, false);
                }
            }
        }
    }

    public static abstract class f {
        b atl = null;
        private ArrayList<a> atm = new ArrayList<>();
        public long atn = 120;
        public long ato = 120;
        public long atp = 250;
        public long atq = 250;

        public interface a {
            void lD();
        }

        interface b {
            void o(v vVar);
        }

        public abstract boolean a(v vVar, v vVar2, c cVar, c cVar2);

        public abstract void d(v vVar);

        public abstract boolean d(v vVar, c cVar, c cVar2);

        public abstract boolean e(v vVar, c cVar, c cVar2);

        public abstract boolean f(v vVar, c cVar, c cVar2);

        public abstract boolean isRunning();

        public abstract void jD();

        public abstract void jF();

        public final long lv() {
            return this.atp;
        }

        public final void lw() {
            this.atp = 0;
        }

        public long lx() {
            return this.atn;
        }

        public long ly() {
            return this.ato;
        }

        public final void lz() {
            this.ato = 2000;
        }

        public final long lA() {
            return this.atq;
        }

        public final void lB() {
            this.atq = 0;
        }

        static int m(v vVar) {
            int i2 = vVar.FV & 14;
            if (vVar.isInvalid()) {
                return 4;
            }
            if ((i2 & 4) != 0) {
                return i2;
            }
            int i3 = vVar.auu;
            int lR = vVar.lR();
            if (i3 == -1 || lR == -1 || i3 == lR) {
                return i2;
            }
            return i2 | 2048;
        }

        public final void n(v vVar) {
            o(vVar);
            if (this.atl != null) {
                this.atl.o(vVar);
            }
        }

        public void o(v vVar) {
        }

        public final boolean a(a aVar) {
            boolean isRunning = isRunning();
            if (aVar != null) {
                if (!isRunning) {
                    aVar.lD();
                } else {
                    this.atm.add(aVar);
                }
            }
            return isRunning;
        }

        public boolean p(v vVar) {
            return true;
        }

        public boolean a(v vVar, List<Object> list) {
            return p(vVar);
        }

        public final void lC() {
            int size = this.atm.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.atm.get(i2).lD();
            }
            this.atm.clear();
        }

        public static class c {
            public int atr;
            public int bottom;
            public int left;
            public int right;
            public int top;

            public c c(v vVar, int i2) {
                View view = vVar.aus;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }

        public c a(s sVar, v vVar, int i2, List<Object> list) {
            return new c().c(vVar, 0);
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.asZ == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return this.asZ.au(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public android.support.v4.view.l getScrollingChildHelper() {
        if (this.atb == null) {
            this.atb = new android.support.v4.view.l(this);
        }
        return this.atb;
    }
}
