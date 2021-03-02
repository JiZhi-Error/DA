package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.u;
import android.support.v4.view.w;
import android.support.v4.widget.Space;
import android.support.v7.e.a;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.mm.R;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GridLayout extends ViewGroup {
    private static final int ORIENTATION = 3;
    public static final a aoA = new a() {
        /* class android.support.v7.widget.GridLayout.AnonymousClass6 */

        /* access modifiers changed from: package-private */
        @Override // android.support.v7.widget.GridLayout.a
        public final int B(View view, int i2) {
            return i2 >> 1;
        }

        @Override // android.support.v7.widget.GridLayout.a
        public final int k(View view, int i2, int i3) {
            return i2 >> 1;
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.v7.widget.GridLayout.a
        public final String jS() {
            return "CENTER";
        }
    };
    public static final a aoB = new a() {
        /* class android.support.v7.widget.GridLayout.AnonymousClass7 */

        /* access modifiers changed from: package-private */
        @Override // android.support.v7.widget.GridLayout.a
        public final int B(View view, int i2) {
            return 0;
        }

        @Override // android.support.v7.widget.GridLayout.a
        public final int k(View view, int i2, int i3) {
            if (view.getVisibility() == 8) {
                return 0;
            }
            int baseline = view.getBaseline();
            if (baseline == -1) {
                return Integer.MIN_VALUE;
            }
            return baseline;
        }

        @Override // android.support.v7.widget.GridLayout.a
        public final e jT() {
            return new e() {
                /* class android.support.v7.widget.GridLayout.AnonymousClass7.AnonymousClass1 */
                private int size;

                /* access modifiers changed from: protected */
                @Override // android.support.v7.widget.GridLayout.e
                public final void reset() {
                    super.reset();
                    this.size = Integer.MIN_VALUE;
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v7.widget.GridLayout.e
                public final void U(int i2, int i3) {
                    super.U(i2, i3);
                    this.size = Math.max(this.size, i2 + i3);
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v7.widget.GridLayout.e
                public final int ai(boolean z) {
                    return Math.max(super.ai(z), this.size);
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v7.widget.GridLayout.e
                public final int a(GridLayout gridLayout, View view, a aVar, int i2, boolean z) {
                    return Math.max(0, super.a(gridLayout, view, aVar, i2, z));
                }
            };
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.v7.widget.GridLayout.a
        public final String jS() {
            return "BASELINE";
        }
    };
    public static final a aoC = new a() {
        /* class android.support.v7.widget.GridLayout.AnonymousClass8 */

        /* access modifiers changed from: package-private */
        @Override // android.support.v7.widget.GridLayout.a
        public final int B(View view, int i2) {
            return 0;
        }

        @Override // android.support.v7.widget.GridLayout.a
        public final int k(View view, int i2, int i3) {
            return Integer.MIN_VALUE;
        }

        @Override // android.support.v7.widget.GridLayout.a
        public final int V(int i2, int i3) {
            return i3;
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.v7.widget.GridLayout.a
        public final String jS() {
            return "FILL";
        }
    };
    static final Printer aod = new LogPrinter(3, GridLayout.class.getName());
    static final Printer aoe = new Printer() {
        /* class android.support.v7.widget.GridLayout.AnonymousClass1 */

        public final void println(String str) {
        }
    };
    private static final int aof = 4;
    private static final int aog = 1;
    private static final int aoh = 6;
    private static final int aoi = 0;
    private static final int aoj = 5;
    private static final int aok = 2;
    static final a aor = new a() {
        /* class android.support.v7.widget.GridLayout.AnonymousClass2 */

        /* access modifiers changed from: package-private */
        @Override // android.support.v7.widget.GridLayout.a
        public final int B(View view, int i2) {
            return Integer.MIN_VALUE;
        }

        @Override // android.support.v7.widget.GridLayout.a
        public final int k(View view, int i2, int i3) {
            return Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.v7.widget.GridLayout.a
        public final String jS() {
            return "UNDEFINED";
        }
    };
    private static final a aos = new a() {
        /* class android.support.v7.widget.GridLayout.AnonymousClass3 */

        /* access modifiers changed from: package-private */
        @Override // android.support.v7.widget.GridLayout.a
        public final int B(View view, int i2) {
            return 0;
        }

        @Override // android.support.v7.widget.GridLayout.a
        public final int k(View view, int i2, int i3) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.v7.widget.GridLayout.a
        public final String jS() {
            return "LEADING";
        }
    };
    private static final a aot = new a() {
        /* class android.support.v7.widget.GridLayout.AnonymousClass4 */

        /* access modifiers changed from: package-private */
        @Override // android.support.v7.widget.GridLayout.a
        public final int B(View view, int i2) {
            return i2;
        }

        @Override // android.support.v7.widget.GridLayout.a
        public final int k(View view, int i2, int i3) {
            return i2;
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.v7.widget.GridLayout.a
        public final String jS() {
            return "TRAILING";
        }
    };
    public static final a aou = aos;
    public static final a aov = aot;
    public static final a aow = aos;
    public static final a aox = aot;
    public static final a aoy = a(aow, aox);
    public static final a aoz = a(aox, aow);
    final d aol;
    final d aom;
    boolean aon;
    int aoo;
    int aop;
    int aoq;
    int mOrientation;
    Printer mPrinter;

    public GridLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.aol = new d(true);
        this.aom = new d(false);
        this.mOrientation = 0;
        this.aon = false;
        this.aoo = 1;
        this.aoq = 0;
        this.mPrinter = aod;
        this.aop = context.getResources().getDimensionPixelOffset(R.dimen.yn);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0048a.GridLayout);
        try {
            setRowCount(obtainStyledAttributes.getInt(aof, Integer.MIN_VALUE));
            setColumnCount(obtainStyledAttributes.getInt(aog, Integer.MIN_VALUE));
            setOrientation(obtainStyledAttributes.getInt(ORIENTATION, 0));
            setUseDefaultMargins(obtainStyledAttributes.getBoolean(aoh, false));
            setAlignmentMode(obtainStyledAttributes.getInt(aoi, 1));
            setRowOrderPreserved(obtainStyledAttributes.getBoolean(aoj, true));
            setColumnOrderPreserved(obtainStyledAttributes.getBoolean(aok, true));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i2) {
        if (this.mOrientation != i2) {
            this.mOrientation = i2;
            jN();
            requestLayout();
        }
    }

    public int getRowCount() {
        return this.aom.getCount();
    }

    public void setRowCount(int i2) {
        this.aom.setCount(i2);
        jN();
        requestLayout();
    }

    public int getColumnCount() {
        return this.aol.getCount();
    }

    public void setColumnCount(int i2) {
        this.aol.setCount(i2);
        jN();
        requestLayout();
    }

    public boolean getUseDefaultMargins() {
        return this.aon;
    }

    public void setUseDefaultMargins(boolean z) {
        this.aon = z;
        requestLayout();
    }

    public int getAlignmentMode() {
        return this.aoo;
    }

    public void setAlignmentMode(int i2) {
        this.aoo = i2;
        requestLayout();
    }

    public void setRowOrderPreserved(boolean z) {
        this.aom.aj(z);
        jN();
        requestLayout();
    }

    public void setColumnOrderPreserved(boolean z) {
        this.aol.aj(z);
        jN();
        requestLayout();
    }

    public Printer getPrinter() {
        return this.mPrinter;
    }

    public void setPrinter(Printer printer) {
        if (printer == null) {
            printer = aoe;
        }
        this.mPrinter = printer;
    }

    static int j(int[] iArr) {
        int i2 = -1;
        for (int i3 : iArr) {
            i2 = Math.max(i2, i3);
        }
        return i2;
    }

    static <T> T[] a(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length));
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    static a j(int i2, boolean z) {
        switch (((z ? 7 : 112) & i2) >> (z ? 0 : 4)) {
            case 1:
                return aoA;
            case 3:
                return z ? aoy : aou;
            case 5:
                return z ? aoz : aov;
            case 7:
                return aoC;
            case 8388611:
                return aow;
            case 8388613:
                return aox;
            default:
                return aor;
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(View view, boolean z, boolean z2) {
        int i2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z) {
            i2 = z2 ? layoutParams.leftMargin : layoutParams.rightMargin;
        } else {
            i2 = z2 ? layoutParams.topMargin : layoutParams.bottomMargin;
        }
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (!this.aon) {
            return 0;
        }
        i iVar = z ? layoutParams.apE : layoutParams.apD;
        d dVar = z ? this.aol : this.aom;
        f fVar = iVar.aoG;
        if (z && jM()) {
            if (!z2) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (!z2) {
            dVar.getCount();
        } else if (fVar.min != 0) {
        }
        if (view.getClass() == Space.class || view.getClass() == android.widget.Space.class) {
            return 0;
        }
        return this.aop / 2;
    }

    private boolean jM() {
        return u.Z(this) == 1;
    }

    private int b(View view, boolean z, boolean z2) {
        int[] iArr;
        if (this.aoo == 1) {
            return a(view, z, z2);
        }
        d dVar = z ? this.aol : this.aom;
        if (z2) {
            if (dVar.aoU == null) {
                dVar.aoU = new int[(dVar.getCount() + 1)];
            }
            if (!dVar.aoV) {
                dVar.al(true);
                dVar.aoV = true;
            }
            iArr = dVar.aoU;
        } else {
            if (dVar.aoW == null) {
                dVar.aoW = new int[(dVar.getCount() + 1)];
            }
            if (!dVar.aoX) {
                dVar.al(false);
                dVar.aoX = true;
            }
            iArr = dVar.aoW;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        i iVar = z ? layoutParams.apE : layoutParams.apD;
        return iArr[z2 ? iVar.aoG.min : iVar.aoG.max];
    }

    /* access modifiers changed from: package-private */
    public final int g(View view, boolean z) {
        return b(view, z, true) + b(view, z, false);
    }

    private static void a(LayoutParams layoutParams, int i2, int i3, int i4, int i5) {
        layoutParams.apD = layoutParams.apD.a(new f(i2, i2 + i3));
        layoutParams.apE = layoutParams.apE.a(new f(i4, i4 + i5));
    }

    private void jN() {
        this.aoq = 0;
        if (this.aol != null) {
            this.aol.jN();
        }
        if (this.aom != null) {
            this.aom.jN();
        }
        jO();
    }

    private void jO() {
        if (this.aol != null && this.aom != null) {
            this.aol.jO();
            this.aom.jO();
        }
    }

    static LayoutParams bl(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    static void F(String str) {
        throw new IllegalArgumentException(str + ". ");
    }

    private void a(LayoutParams layoutParams, boolean z) {
        String str = z ? "column" : "row";
        f fVar = (z ? layoutParams.apE : layoutParams.apD).aoG;
        if (fVar.min != Integer.MIN_VALUE && fVar.min < 0) {
            F(str + " indices must be positive");
        }
        int i2 = (z ? this.aol : this.aom).aoM;
        if (i2 != Integer.MIN_VALUE) {
            if (fVar.max > i2) {
                F(str + " indices (start + span) mustn't exceed the " + str + " count");
            }
            if (fVar.size() > i2) {
                F(str + " span mustn't exceed the " + str + " count");
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams)) {
            return false;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        a(layoutParams2, true);
        a(layoutParams2, false);
        return true;
    }

    private int jP() {
        int i2;
        int i3 = 1;
        int childCount = getChildCount();
        int i4 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                i2 = ((LayoutParams) childAt.getLayoutParams()).hashCode() + (i3 * 31);
            } else {
                i2 = i3;
            }
            i4++;
            i3 = i2;
        }
        return i3;
    }

    private void jQ() {
        int i2;
        boolean z;
        while (this.aoq != 0) {
            if (this.aoq != jP()) {
                this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
                jN();
            } else {
                return;
            }
        }
        boolean z2 = this.mOrientation == 0;
        d dVar = z2 ? this.aol : this.aom;
        int i3 = dVar.aoM != Integer.MIN_VALUE ? dVar.aoM : 0;
        int i4 = 0;
        int i5 = 0;
        int[] iArr = new int[i3];
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i6).getLayoutParams();
            i iVar = z2 ? layoutParams.apD : layoutParams.apE;
            f fVar = iVar.aoG;
            boolean z3 = iVar.apJ;
            int size = fVar.size();
            if (z3) {
                i4 = fVar.min;
            }
            i iVar2 = z2 ? layoutParams.apE : layoutParams.apD;
            f fVar2 = iVar2.aoG;
            boolean z4 = iVar2.apJ;
            int size2 = fVar2.size();
            if (i3 != 0) {
                size2 = Math.min(size2, i3 - (z4 ? Math.min(fVar2.min, i3) : 0));
            }
            if (z4) {
                i2 = fVar2.min;
            } else {
                i2 = i5;
            }
            if (i3 != 0) {
                if (!z3 || !z4) {
                    while (true) {
                        int i7 = i2 + size2;
                        if (i7 <= iArr.length) {
                            int i8 = i2;
                            while (true) {
                                if (i8 >= i7) {
                                    z = true;
                                    break;
                                } else if (iArr[i8] > i4) {
                                    z = false;
                                    break;
                                } else {
                                    i8++;
                                }
                            }
                        } else {
                            z = false;
                        }
                        if (z) {
                            break;
                        } else if (z4) {
                            i4++;
                        } else if (i2 + size2 <= i3) {
                            i2++;
                        } else {
                            i2 = 0;
                            i4++;
                        }
                    }
                }
                int length = iArr.length;
                Arrays.fill(iArr, Math.min(i2, length), Math.min(i2 + size2, length), i4 + size);
            }
            if (z2) {
                a(layoutParams, i4, size, i2, size2);
            } else {
                a(layoutParams, i2, size2, i4, size);
            }
            i5 = i2 + size2;
        }
        this.aoq = jP();
    }

    private void g(View view, int i2, int i3, int i4, int i5) {
        view.measure(getChildMeasureSpec(i2, g(view, true), i4), getChildMeasureSpec(i3, g(view, false), i5));
    }

    private void d(int i2, int i3, boolean z) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    g(childAt, i2, i3, layoutParams.width, layoutParams.height);
                } else {
                    boolean z2 = this.mOrientation == 0;
                    i iVar = z2 ? layoutParams.apE : layoutParams.apD;
                    if (iVar.am(z2) == aoC) {
                        f fVar = iVar.aoG;
                        int[] ke = (z2 ? this.aol : this.aom).ke();
                        int g2 = (ke[fVar.max] - ke[fVar.min]) - g(childAt, z2);
                        if (z2) {
                            g(childAt, i2, i3, g2, layoutParams.height);
                        } else {
                            g(childAt, i2, i3, layoutParams.width, g2);
                        }
                    }
                }
            }
        }
    }

    private static int T(int i2, int i3) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2 + i3), View.MeasureSpec.getMode(i2));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int bR;
        int bR2;
        jQ();
        jO();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int T = T(i2, -paddingLeft);
        int T2 = T(i3, -paddingTop);
        d(T, T2, true);
        if (this.mOrientation == 0) {
            bR2 = this.aol.bR(T);
            d(T, T2, false);
            bR = this.aom.bR(T2);
        } else {
            bR = this.aom.bR(T2);
            d(T, T2, false);
            bR2 = this.aol.bR(T);
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(bR2 + paddingLeft, getSuggestedMinimumWidth()), i2, 0), View.resolveSizeAndState(Math.max(bR + paddingTop, getSuggestedMinimumHeight()), i3, 0));
    }

    static int h(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    public void requestLayout() {
        super.requestLayout();
        jN();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        jQ();
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        this.aol.bS((i6 - paddingLeft) - paddingRight);
        this.aom.bS(((i5 - i3) - paddingTop) - paddingBottom);
        int[] ke = this.aol.ke();
        int[] ke2 = this.aom.ke();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                i iVar = layoutParams.apE;
                i iVar2 = layoutParams.apD;
                f fVar = iVar.aoG;
                f fVar2 = iVar2.aoG;
                int i8 = ke[fVar.min];
                int i9 = ke2[fVar2.min];
                int i10 = ke[fVar.max] - i8;
                int i11 = ke2[fVar2.max] - i9;
                int h2 = h(childAt, true);
                int h3 = h(childAt, false);
                a am = iVar.am(true);
                a am2 = iVar2.am(false);
                e bU = this.aol.jY().bU(i7);
                e bU2 = this.aom.jY().bU(i7);
                int B = am.B(childAt, i10 - bU.ai(true));
                int B2 = am2.B(childAt, i11 - bU2.ai(true));
                int b2 = b(childAt, true, true);
                int b3 = b(childAt, false, true);
                int b4 = b(childAt, true, false);
                int i12 = b2 + b4;
                int b5 = b3 + b(childAt, false, false);
                int a2 = bU.a(this, childAt, am, h2 + i12, true);
                int a3 = bU2.a(this, childAt, am2, h3 + b5, false);
                int V = am.V(h2, i10 - i12);
                int V2 = am2.V(h3, i11 - b5);
                int i13 = a2 + i8 + B;
                int i14 = !jM() ? i13 + paddingLeft + b2 : (((i6 - V) - paddingRight) - b4) - i13;
                int i15 = a3 + paddingTop + i9 + B2 + b3;
                if (!(V == childAt.getMeasuredWidth() && V2 == childAt.getMeasuredHeight())) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(V, 1073741824), View.MeasureSpec.makeMeasureSpec(V2, 1073741824));
                }
                childAt.layout(i14, i15, V + i14, V2 + i15);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final class d {
        static final /* synthetic */ boolean $assertionsDisabled = (!GridLayout.class.desiredAssertionStatus());
        public final boolean aoL;
        public int aoM = Integer.MIN_VALUE;
        private int aoN = Integer.MIN_VALUE;
        h<i, e> aoO;
        public boolean aoP = false;
        h<f, g> aoQ;
        public boolean aoR = false;
        h<f, g> aoS;
        public boolean aoT = false;
        public int[] aoU;
        public boolean aoV = false;
        public int[] aoW;
        public boolean aoX = false;
        public b[] aoY;
        public boolean aoZ = false;
        public int[] apa;
        public boolean apb = false;
        public boolean apc;
        public boolean apd = false;
        public int[] ape;
        boolean apf = true;
        private g apg = new g(0);
        private g aph = new g(TXLiteAVCode.ERR_SERVER_INFO_UNPACKING_ERROR);

        d(boolean z) {
            this.aoL = z;
        }

        private int jV() {
            if (this.aoN == Integer.MIN_VALUE) {
                int childCount = GridLayout.this.getChildCount();
                int i2 = -1;
                for (int i3 = 0; i3 < childCount; i3++) {
                    LayoutParams bl = GridLayout.bl(GridLayout.this.getChildAt(i3));
                    f fVar = (this.aoL ? bl.apE : bl.apD).aoG;
                    i2 = Math.max(Math.max(Math.max(i2, fVar.min), fVar.max), fVar.size());
                }
                this.aoN = Math.max(0, i2 == -1 ? Integer.MIN_VALUE : i2);
            }
            return this.aoN;
        }

        public final int getCount() {
            return Math.max(this.aoM, jV());
        }

        public final void setCount(int i2) {
            if (i2 != Integer.MIN_VALUE && i2 < jV()) {
                GridLayout.F((this.aoL ? "column" : "row") + "Count must be greater than or equal to the maximum of all grid indices (and spans) defined in the LayoutParams of each child");
            }
            this.aoM = i2;
        }

        public final void aj(boolean z) {
            this.apf = z;
            jN();
        }

        private h<i, e> jW() {
            c a2 = c.a(i.class, e.class);
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                LayoutParams bl = GridLayout.bl(GridLayout.this.getChildAt(i2));
                i iVar = this.aoL ? bl.apE : bl.apD;
                a2.f(iVar, iVar.am(this.aoL).jT());
            }
            return a2.jU();
        }

        private void jX() {
            V[] vArr;
            for (V v : this.aoO.apH) {
                v.reset();
            }
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = GridLayout.this.getChildAt(i2);
                LayoutParams bl = GridLayout.bl(childAt);
                i iVar = this.aoL ? bl.apE : bl.apD;
                GridLayout gridLayout = GridLayout.this;
                boolean z = this.aoL;
                this.aoO.bU(i2).a(GridLayout.this, childAt, iVar, this, (childAt.getVisibility() == 8 ? 0 : gridLayout.g(childAt, z) + GridLayout.h(childAt, z)) + (iVar.weight == 0.0f ? 0 : kd()[i2]));
            }
        }

        public final h<i, e> jY() {
            if (this.aoO == null) {
                this.aoO = jW();
            }
            if (!this.aoP) {
                jX();
                this.aoP = true;
            }
            return this.aoO;
        }

        private h<f, g> ak(boolean z) {
            f fVar;
            c a2 = c.a(f.class, g.class);
            K[] kArr = jY().apG;
            int length = kArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (z) {
                    fVar = kArr[i2].aoG;
                } else {
                    f fVar2 = kArr[i2].aoG;
                    fVar = new f(fVar2.max, fVar2.min);
                }
                a2.f(fVar, new g());
            }
            return a2.jU();
        }

        private void a(h<f, g> hVar, boolean z) {
            V[] vArr;
            for (V v : hVar.apH) {
                v.value = Integer.MIN_VALUE;
            }
            V[] vArr2 = jY().apH;
            for (int i2 = 0; i2 < vArr2.length; i2++) {
                int ai = vArr2[i2].ai(z);
                g bU = hVar.bU(i2);
                int i3 = bU.value;
                if (!z) {
                    ai = -ai;
                }
                bU.value = Math.max(i3, ai);
            }
        }

        private h<f, g> jZ() {
            if (this.aoQ == null) {
                this.aoQ = ak(true);
            }
            if (!this.aoR) {
                a(this.aoQ, true);
                this.aoR = true;
            }
            return this.aoQ;
        }

        private h<f, g> ka() {
            if (this.aoS == null) {
                this.aoS = ak(false);
            }
            if (!this.aoT) {
                a(this.aoS, false);
                this.aoT = true;
            }
            return this.aoS;
        }

        private static void a(List<b> list, f fVar, g gVar, boolean z) {
            if (fVar.size() != 0) {
                if (z) {
                    for (b bVar : list) {
                        if (bVar.aoG.equals(fVar)) {
                            return;
                        }
                    }
                }
                list.add(new b(fVar, gVar));
            }
        }

        private static void a(List<b> list, f fVar, g gVar) {
            a(list, fVar, gVar, true);
        }

        /* access modifiers changed from: package-private */
        public final b[][] a(b[] bVarArr) {
            int count = getCount() + 1;
            b[][] bVarArr2 = new b[count][];
            int[] iArr = new int[count];
            for (b bVar : bVarArr) {
                int i2 = bVar.aoG.min;
                iArr[i2] = iArr[i2] + 1;
            }
            for (int i3 = 0; i3 < iArr.length; i3++) {
                bVarArr2[i3] = new b[iArr[i3]];
            }
            Arrays.fill(iArr, 0);
            for (b bVar2 : bVarArr) {
                int i4 = bVar2.aoG.min;
                b[] bVarArr3 = bVarArr2[i4];
                int i5 = iArr[i4];
                iArr[i4] = i5 + 1;
                bVarArr3[i5] = bVar2;
            }
            return bVarArr2;
        }

        private b[] o(List<b> list) {
            final b[] bVarArr = (b[]) list.toArray(new b[list.size()]);
            AnonymousClass1 r1 = new Object() {
                /* class android.support.v7.widget.GridLayout.d.AnonymousClass1 */
                static final /* synthetic */ boolean $assertionsDisabled = (!GridLayout.class.desiredAssertionStatus());
                b[] apj = new b[bVarArr.length];
                int apk = (this.apj.length - 1);
                b[][] apl = d.this.a(bVarArr);
                int[] apm = new int[(d.this.getCount() + 1)];

                /* access modifiers changed from: package-private */
                public final void bT(int i2) {
                    switch (this.apm[i2]) {
                        case 0:
                            this.apm[i2] = 1;
                            b[] bVarArr = this.apl[i2];
                            for (b bVar : bVarArr) {
                                bT(bVar.aoG.max);
                                b[] bVarArr2 = this.apj;
                                int i3 = this.apk;
                                this.apk = i3 - 1;
                                bVarArr2[i3] = bVar;
                            }
                            this.apm[i2] = 2;
                            return;
                        case 1:
                            if (!$assertionsDisabled) {
                                throw new AssertionError();
                            }
                            return;
                        default:
                            return;
                    }
                }
            };
            int length = r1.apl.length;
            for (int i2 = 0; i2 < length; i2++) {
                r1.bT(i2);
            }
            if (AnonymousClass1.$assertionsDisabled || r1.apk == -1) {
                return r1.apj;
            }
            throw new AssertionError();
        }

        private static void a(List<b> list, h<f, g> hVar) {
            for (int i2 = 0; i2 < hVar.apG.length; i2++) {
                a(list, hVar.apG[i2], hVar.apH[i2], false);
            }
        }

        private void kb() {
            jZ();
            ka();
        }

        private b[] kc() {
            if (this.aoY == null) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                a(arrayList, jZ());
                a(arrayList2, ka());
                if (this.apf) {
                    for (int i2 = 0; i2 < getCount(); i2++) {
                        a(arrayList, new f(i2, i2 + 1), new g(0));
                    }
                }
                int count = getCount();
                a(arrayList, new f(0, count), this.apg, false);
                a(arrayList2, new f(count, 0), this.aph, false);
                this.aoY = (b[]) GridLayout.a(o(arrayList), o(arrayList2));
            }
            if (!this.aoZ) {
                kb();
                this.aoZ = true;
            }
            return this.aoY;
        }

        private static boolean a(int[] iArr, b bVar) {
            if (!bVar.aoI) {
                return false;
            }
            f fVar = bVar.aoG;
            int i2 = fVar.min;
            int i3 = fVar.max;
            int i4 = iArr[i2] + bVar.aoH.value;
            if (i4 <= iArr[i3]) {
                return false;
            }
            iArr[i3] = i4;
            return true;
        }

        private String p(List<b> list) {
            String str = this.aoL ? "x" : "y";
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (b bVar : list) {
                if (z) {
                    z = false;
                } else {
                    sb = sb.append(", ");
                }
                int i2 = bVar.aoG.min;
                int i3 = bVar.aoG.max;
                int i4 = bVar.aoH.value;
                sb.append(i2 < i3 ? str + i3 + "-" + str + i2 + ">=" + i4 : str + i2 + "-" + str + i3 + "<=" + (-i4));
            }
            return sb.toString();
        }

        private boolean a(b[] bVarArr, int[] iArr, boolean z) {
            String str = this.aoL ? MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL : "vertical";
            int count = getCount() + 1;
            boolean[] zArr = null;
            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                Arrays.fill(iArr, 0);
                for (int i3 = 0; i3 < count; i3++) {
                    boolean z2 = false;
                    for (b bVar : bVarArr) {
                        z2 |= a(iArr, bVar);
                    }
                    if (!z2) {
                        if (zArr != null) {
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            for (int i4 = 0; i4 < bVarArr.length; i4++) {
                                b bVar2 = bVarArr[i4];
                                if (zArr[i4]) {
                                    arrayList.add(bVar2);
                                }
                                if (!bVar2.aoI) {
                                    arrayList2.add(bVar2);
                                }
                            }
                            GridLayout.this.mPrinter.println(str + " constraints: " + p(arrayList) + " are inconsistent; permanently removing: " + p(arrayList2) + ". ");
                        }
                        return true;
                    }
                }
                if (!z) {
                    return false;
                }
                boolean[] zArr2 = new boolean[bVarArr.length];
                for (int i5 = 0; i5 < count; i5++) {
                    int length = bVarArr.length;
                    for (int i6 = 0; i6 < length; i6++) {
                        zArr2[i6] = zArr2[i6] | a(iArr, bVarArr[i6]);
                    }
                }
                if (i2 == 0) {
                    zArr = zArr2;
                }
                int i7 = 0;
                while (true) {
                    if (i7 >= bVarArr.length) {
                        break;
                    }
                    if (zArr2[i7]) {
                        b bVar3 = bVarArr[i7];
                        if (bVar3.aoG.min >= bVar3.aoG.max) {
                            bVar3.aoI = false;
                            break;
                        }
                    }
                    i7++;
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void al(boolean z) {
            int[] iArr = z ? this.aoU : this.aoW;
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = GridLayout.this.getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    LayoutParams bl = GridLayout.bl(childAt);
                    f fVar = (this.aoL ? bl.apE : bl.apD).aoG;
                    int i3 = z ? fVar.min : fVar.max;
                    iArr[i3] = Math.max(iArr[i3], GridLayout.this.a(childAt, this.aoL, z));
                }
            }
        }

        private boolean k(int[] iArr) {
            return a(kc(), iArr, true);
        }

        private int[] kd() {
            if (this.ape == null) {
                this.ape = new int[GridLayout.this.getChildCount()];
            }
            return this.ape;
        }

        private void f(int i2, float f2) {
            float f3;
            Arrays.fill(this.ape, 0);
            int childCount = GridLayout.this.getChildCount();
            int i3 = 0;
            float f4 = f2;
            int i4 = i2;
            while (i3 < childCount) {
                View childAt = GridLayout.this.getChildAt(i3);
                if (childAt.getVisibility() != 8) {
                    LayoutParams bl = GridLayout.bl(childAt);
                    float f5 = (this.aoL ? bl.apE : bl.apD).weight;
                    if (f5 != 0.0f) {
                        int round = Math.round((((float) i4) * f5) / f4);
                        this.ape[i3] = round;
                        i4 -= round;
                        f3 = f4 - f5;
                        i3++;
                        f4 = f3;
                    }
                }
                f3 = f4;
                i3++;
                f4 = f3;
            }
        }

        private void l(int[] iArr) {
            float f2;
            boolean z;
            float f3 = 0.0f;
            boolean z2 = true;
            if (!this.apd) {
                int childCount = GridLayout.this.getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        z = false;
                        break;
                    }
                    View childAt = GridLayout.this.getChildAt(i2);
                    if (childAt.getVisibility() != 8) {
                        LayoutParams bl = GridLayout.bl(childAt);
                        if ((this.aoL ? bl.apE : bl.apD).weight != 0.0f) {
                            z = true;
                            break;
                        }
                    }
                    i2++;
                }
                this.apc = z;
                this.apd = true;
            }
            if (!this.apc) {
                k(iArr);
            } else {
                Arrays.fill(kd(), 0);
                k(iArr);
                int childCount2 = (this.apg.value * GridLayout.this.getChildCount()) + 1;
                if (childCount2 >= 2) {
                    int childCount3 = GridLayout.this.getChildCount();
                    int i3 = 0;
                    while (i3 < childCount3) {
                        View childAt2 = GridLayout.this.getChildAt(i3);
                        if (childAt2.getVisibility() != 8) {
                            LayoutParams bl2 = GridLayout.bl(childAt2);
                            f2 = (this.aoL ? bl2.apE : bl2.apD).weight + f3;
                        } else {
                            f2 = f3;
                        }
                        i3++;
                        f3 = f2;
                    }
                    int i4 = -1;
                    int i5 = 0;
                    int i6 = childCount2;
                    while (i5 < i6) {
                        int i7 = (int) ((((long) i5) + ((long) i6)) / 2);
                        jO();
                        f(i7, f3);
                        z2 = a(kc(), iArr, false);
                        if (z2) {
                            i5 = i7 + 1;
                            i4 = i7;
                        } else {
                            i6 = i7;
                        }
                    }
                    if (i4 > 0 && !z2) {
                        jO();
                        f(i4, f3);
                        k(iArr);
                    }
                }
            }
            if (!this.apf) {
                int i8 = iArr[0];
                int length = iArr.length;
                for (int i9 = 0; i9 < length; i9++) {
                    iArr[i9] = iArr[i9] - i8;
                }
            }
        }

        public final int[] ke() {
            if (this.apa == null) {
                this.apa = new int[(getCount() + 1)];
            }
            if (!this.apb) {
                l(this.apa);
                this.apb = true;
            }
            return this.apa;
        }

        private void W(int i2, int i3) {
            this.apg.value = i2;
            this.aph.value = -i3;
            this.apb = false;
        }

        private int X(int i2, int i3) {
            W(i2, i3);
            return ke()[getCount()];
        }

        public final int bR(int i2) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return X(0, size);
                case 0:
                    return X(0, 100000);
                case 1073741824:
                    return X(size, size);
                default:
                    if ($assertionsDisabled) {
                        return 0;
                    }
                    throw new AssertionError();
            }
        }

        public final void bS(int i2) {
            W(i2, i2);
            ke();
        }

        public final void jN() {
            this.aoN = Integer.MIN_VALUE;
            this.aoO = null;
            this.aoQ = null;
            this.aoS = null;
            this.aoU = null;
            this.aoW = null;
            this.aoY = null;
            this.apa = null;
            this.ape = null;
            this.apd = false;
            jO();
        }

        public final void jO() {
            this.aoP = false;
            this.aoR = false;
            this.aoT = false;
            this.aoV = false;
            this.aoX = false;
            this.aoZ = false;
            this.apb = false;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int BOTTOM_MARGIN = 6;
        private static final int LEFT_MARGIN = 3;
        private static final int RIGHT_MARGIN = 5;
        private static final int TOP_MARGIN = 4;
        private static final int apA = 12;
        private static final int apB = 13;
        private static final int apC = 10;
        private static final f apt;
        private static final int apu;
        private static final int apv = 2;
        private static final int apw = 7;
        private static final int apx = 8;
        private static final int apy = 9;
        private static final int apz = 11;
        public i apD;
        public i apE;

        static {
            f fVar = new f(Integer.MIN_VALUE, -2147483647);
            apt = fVar;
            apu = fVar.size();
        }

        private LayoutParams(i iVar, i iVar2) {
            super(-2, -2);
            this.apD = i.apI;
            this.apE = i.apI;
            setMargins(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
            this.apD = iVar;
            this.apE = iVar2;
        }

        private LayoutParams(i iVar, i iVar2, byte b2) {
            this(iVar, iVar2);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public LayoutParams() {
            /*
                r2 = this;
                android.support.v7.widget.GridLayout$i r0 = android.support.v7.widget.GridLayout.i.apI
                r1 = 0
                r2.<init>(r0, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayout.LayoutParams.<init>():void");
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.apD = i.apI;
            this.apE = i.apI;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.apD = i.apI;
            this.apE = i.apI;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.apD = i.apI;
            this.apE = i.apI;
            this.apD = layoutParams.apD;
            this.apE = layoutParams.apE;
        }

        /* JADX INFO: finally extract failed */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.apD = i.apI;
            this.apE = i.apI;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0048a.GridLayout_Layout);
            try {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(apv, Integer.MIN_VALUE);
                this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(LEFT_MARGIN, dimensionPixelSize);
                this.topMargin = obtainStyledAttributes.getDimensionPixelSize(TOP_MARGIN, dimensionPixelSize);
                this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(RIGHT_MARGIN, dimensionPixelSize);
                this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(BOTTOM_MARGIN, dimensionPixelSize);
                obtainStyledAttributes.recycle();
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.C0048a.GridLayout_Layout);
                try {
                    int i2 = obtainStyledAttributes2.getInt(apC, 0);
                    this.apE = GridLayout.a(obtainStyledAttributes2.getInt(apw, Integer.MIN_VALUE), obtainStyledAttributes2.getInt(apx, apu), GridLayout.j(i2, true), obtainStyledAttributes2.getFloat(apy, 0.0f));
                    this.apD = GridLayout.a(obtainStyledAttributes2.getInt(apz, Integer.MIN_VALUE), obtainStyledAttributes2.getInt(apA, apu), GridLayout.j(i2, false), obtainStyledAttributes2.getFloat(apB, 0.0f));
                } finally {
                    obtainStyledAttributes2.recycle();
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public void setBaseAttributes(TypedArray typedArray, int i2, int i3) {
            this.width = typedArray.getLayoutDimension(i2, -2);
            this.height = typedArray.getLayoutDimension(i3, -2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            LayoutParams layoutParams = (LayoutParams) obj;
            if (!this.apE.equals(layoutParams.apE)) {
                return false;
            }
            return this.apD.equals(layoutParams.apD);
        }

        public int hashCode() {
            return (this.apD.hashCode() * 31) + this.apE.hashCode();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        public final f aoG;
        public final g aoH;
        public boolean aoI = true;

        public b(f fVar, g gVar) {
            this.aoG = fVar;
            this.aoH = gVar;
        }

        public final String toString() {
            return this.aoG + " " + (!this.aoI ? "+>" : "->") + " " + this.aoH;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class g {
        public int value;

        public g() {
            this.value = Integer.MIN_VALUE;
        }

        public g(int i2) {
            this.value = i2;
        }

        public final String toString() {
            return Integer.toString(this.value);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c<K, V> extends ArrayList<Pair<K, V>> {
        private final Class<K> aoJ;
        private final Class<V> aoK;

        private c(Class<K> cls, Class<V> cls2) {
            this.aoJ = cls;
            this.aoK = cls2;
        }

        public static <K, V> c<K, V> a(Class<K> cls, Class<V> cls2) {
            return new c<>(cls, cls2);
        }

        public final void f(K k, V v) {
            add(Pair.create(k, v));
        }

        public final h<K, V> jU() {
            int size = size();
            Object[] objArr = (Object[]) Array.newInstance((Class<?>) this.aoJ, size);
            Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) this.aoK, size);
            for (int i2 = 0; i2 < size; i2++) {
                objArr[i2] = ((Pair) get(i2)).first;
                objArr2[i2] = ((Pair) get(i2)).second;
            }
            return new h<>(objArr, objArr2);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class h<K, V> {
        public final int[] apF;
        public final K[] apG;
        public final V[] apH;

        h(K[] kArr, V[] vArr) {
            this.apF = c(kArr);
            this.apG = (K[]) a(kArr, this.apF);
            this.apH = (V[]) a(vArr, this.apF);
        }

        public final V bU(int i2) {
            return this.apH[this.apF[i2]];
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.HashMap */
        /* JADX WARN: Multi-variable type inference failed */
        private static <K> int[] c(K[] kArr) {
            int length = kArr.length;
            int[] iArr = new int[length];
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < length; i2++) {
                K k = kArr[i2];
                Integer num = (Integer) hashMap.get(k);
                if (num == null) {
                    num = Integer.valueOf(hashMap.size());
                    hashMap.put(k, num);
                }
                iArr[i2] = num.intValue();
            }
            return iArr;
        }

        private static <K> K[] a(K[] kArr, int[] iArr) {
            int length = kArr.length;
            K[] kArr2 = (K[]) ((Object[]) Array.newInstance(kArr.getClass().getComponentType(), GridLayout.j(iArr) + 1));
            for (int i2 = 0; i2 < length; i2++) {
                kArr2[iArr[i2]] = kArr[i2];
            }
            return kArr2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class e {
        public int apq;
        public int apr;
        public int aps;

        e() {
            reset();
        }

        /* access modifiers changed from: protected */
        public void reset() {
            this.apq = Integer.MIN_VALUE;
            this.apr = Integer.MIN_VALUE;
            this.aps = 2;
        }

        /* access modifiers changed from: protected */
        public void U(int i2, int i3) {
            this.apq = Math.max(this.apq, i2);
            this.apr = Math.max(this.apr, i3);
        }

        /* access modifiers changed from: protected */
        public int ai(boolean z) {
            if (z || !GridLayout.bQ(this.aps)) {
                return this.apq + this.apr;
            }
            return 100000;
        }

        /* access modifiers changed from: protected */
        public int a(GridLayout gridLayout, View view, a aVar, int i2, boolean z) {
            return this.apq - aVar.k(view, i2, w.b(gridLayout));
        }

        /* access modifiers changed from: protected */
        public final void a(GridLayout gridLayout, View view, i iVar, d dVar, int i2) {
            int i3;
            int i4 = this.aps;
            if (iVar.apK == GridLayout.aor && iVar.weight == 0.0f) {
                i3 = 0;
            } else {
                i3 = 2;
            }
            this.aps = i3 & i4;
            int k = iVar.am(dVar.aoL).k(view, i2, w.b(gridLayout));
            U(k, i2 - k);
        }

        public String toString() {
            return "Bounds{before=" + this.apq + ", after=" + this.apr + '}';
        }
    }

    /* access modifiers changed from: package-private */
    public static final class f {
        public final int max;
        public final int min;

        public f(int i2, int i3) {
            this.min = i2;
            this.max = i3;
        }

        /* access modifiers changed from: package-private */
        public final int size() {
            return this.max - this.min;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            if (this.max != fVar.max) {
                return false;
            }
            return this.min == fVar.min;
        }

        public final int hashCode() {
            return (this.min * 31) + this.max;
        }

        public final String toString() {
            return "[" + this.min + ", " + this.max + "]";
        }
    }

    public static class i {
        static final i apI = GridLayout.jR();
        final f aoG;
        final boolean apJ;
        final a apK;
        final float weight;

        private i(boolean z, f fVar, a aVar, float f2) {
            this.apJ = z;
            this.aoG = fVar;
            this.apK = aVar;
            this.weight = f2;
        }

        i(boolean z, int i2, int i3, a aVar, float f2) {
            this(z, new f(i2, i2 + i3), aVar, f2);
        }

        public final a am(boolean z) {
            if (this.apK != GridLayout.aor) {
                return this.apK;
            }
            if (this.weight == 0.0f) {
                return z ? GridLayout.aow : GridLayout.aoB;
            }
            return GridLayout.aoC;
        }

        /* access modifiers changed from: package-private */
        public final i a(f fVar) {
            return new i(this.apJ, fVar, this.apK, this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            i iVar = (i) obj;
            if (!this.apK.equals(iVar.apK)) {
                return false;
            }
            return this.aoG.equals(iVar.aoG);
        }

        public int hashCode() {
            return (this.aoG.hashCode() * 31) + this.apK.hashCode();
        }
    }

    public static i a(int i2, int i3, a aVar, float f2) {
        return new i(i2 != Integer.MIN_VALUE, i2, i3, aVar, f2);
    }

    public static i jR() {
        return a(Integer.MIN_VALUE, 1, aor, 0.0f);
    }

    public static abstract class a {
        /* access modifiers changed from: package-private */
        public abstract int B(View view, int i2);

        /* access modifiers changed from: package-private */
        public abstract String jS();

        /* access modifiers changed from: package-private */
        public abstract int k(View view, int i2, int i3);

        a() {
        }

        /* access modifiers changed from: package-private */
        public int V(int i2, int i3) {
            return i2;
        }

        /* access modifiers changed from: package-private */
        public e jT() {
            return new e();
        }

        public String toString() {
            return "Alignment:" + jS();
        }
    }

    private static a a(final a aVar, final a aVar2) {
        return new a() {
            /* class android.support.v7.widget.GridLayout.AnonymousClass5 */

            /* access modifiers changed from: package-private */
            @Override // android.support.v7.widget.GridLayout.a
            public final int B(View view, int i2) {
                boolean z = true;
                if (u.Z(view) != 1) {
                    z = false;
                }
                return (!z ? aVar : aVar2).B(view, i2);
            }

            @Override // android.support.v7.widget.GridLayout.a
            public final int k(View view, int i2, int i3) {
                boolean z = true;
                if (u.Z(view) != 1) {
                    z = false;
                }
                return (!z ? aVar : aVar2).k(view, i2, i3);
            }

            /* access modifiers changed from: package-private */
            @Override // android.support.v7.widget.GridLayout.a
            public final String jS() {
                return "SWITCHING[L:" + aVar.jS() + ", R:" + aVar2.jS() + "]";
            }
        };
    }

    static boolean bQ(int i2) {
        return (i2 & 2) != 0;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
