package com.google.android.flexbox;

import android.support.v4.view.g;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* access modifiers changed from: package-private */
public class c {
    static final /* synthetic */ boolean $assertionsDisabled = (!c.class.desiredAssertionStatus());
    private final a bJk;
    private boolean[] bJl;
    int[] bJm;
    long[] bJn;
    private long[] bJo;

    static {
        AppMethodBeat.i(62264);
        AppMethodBeat.o(62264);
    }

    c(a aVar) {
        this.bJk = aVar;
    }

    /* access modifiers changed from: package-private */
    public final int[] a(View view, int i2, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        AppMethodBeat.i(62217);
        int flexItemCount = this.bJk.getFlexItemCount();
        List<b> fl = fl(flexItemCount);
        b bVar = new b((byte) 0);
        if (view == null || !(layoutParams instanceof FlexItem)) {
            bVar.order = 1;
        } else {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        }
        if (i2 == -1 || i2 == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i2 < this.bJk.getFlexItemCount()) {
            bVar.index = i2;
            while (i2 < flexItemCount) {
                fl.get(i2).index++;
                i2++;
            }
        } else {
            bVar.index = flexItemCount;
        }
        fl.add(bVar);
        int[] a2 = a(flexItemCount + 1, fl, sparseIntArray);
        AppMethodBeat.o(62217);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final int[] a(SparseIntArray sparseIntArray) {
        AppMethodBeat.i(62218);
        int flexItemCount = this.bJk.getFlexItemCount();
        int[] a2 = a(flexItemCount, fl(flexItemCount), sparseIntArray);
        AppMethodBeat.o(62218);
        return a2;
    }

    private List<b> fl(int i2) {
        AppMethodBeat.i(62219);
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            b bVar = new b((byte) 0);
            bVar.order = ((FlexItem) this.bJk.fj(i3).getLayoutParams()).getOrder();
            bVar.index = i3;
            arrayList.add(bVar);
        }
        AppMethodBeat.o(62219);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(SparseIntArray sparseIntArray) {
        AppMethodBeat.i(62220);
        int flexItemCount = this.bJk.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            AppMethodBeat.o(62220);
            return true;
        }
        for (int i2 = 0; i2 < flexItemCount; i2++) {
            View fj = this.bJk.fj(i2);
            if (fj != null && ((FlexItem) fj.getLayoutParams()).getOrder() != sparseIntArray.get(i2)) {
                AppMethodBeat.o(62220);
                return true;
            }
        }
        AppMethodBeat.o(62220);
        return false;
    }

    private static int[] a(int i2, List<b> list, SparseIntArray sparseIntArray) {
        AppMethodBeat.i(62221);
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i2];
        int i3 = 0;
        for (b bVar : list) {
            iArr[i3] = bVar.index;
            sparseIntArray.append(bVar.index, bVar.order);
            i3++;
        }
        AppMethodBeat.o(62221);
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar, int i2, int i3, int i4, int i5, List<b> list) {
        AppMethodBeat.i(62222);
        a(aVar, i2, i3, i4, i5, -1, list);
        AppMethodBeat.o(62222);
    }

    /* access modifiers changed from: package-private */
    public final void b(a aVar, int i2, int i3, int i4, int i5, List<b> list) {
        AppMethodBeat.i(62223);
        a(aVar, i2, i3, i4, 0, i5, list);
        AppMethodBeat.o(62223);
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar, int i2, int i3) {
        AppMethodBeat.i(62224);
        a(aVar, i3, i2, Integer.MAX_VALUE, 0, -1, (List<b>) null);
        AppMethodBeat.o(62224);
    }

    /* access modifiers changed from: package-private */
    public final void c(a aVar, int i2, int i3, int i4, int i5, List<b> list) {
        AppMethodBeat.i(62225);
        a(aVar, i3, i2, i4, i5, -1, list);
        AppMethodBeat.o(62225);
    }

    /* access modifiers changed from: package-private */
    public final void d(a aVar, int i2, int i3, int i4, int i5, List<b> list) {
        AppMethodBeat.i(62226);
        a(aVar, i3, i2, i4, 0, i5, list);
        AppMethodBeat.o(62226);
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar, int i2, int i3, int i4, int i5, int i6, List<b> list) {
        int i7;
        boolean z;
        int i8;
        int i9;
        b bVar;
        int i10;
        int i11;
        int i12;
        AppMethodBeat.i(62227);
        boolean xC = this.bJk.xC();
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int i13 = 0;
        if (list == null) {
            list = new ArrayList<>();
        }
        aVar.bJp = list;
        boolean z2 = i6 == -1;
        int aZ = aZ(xC);
        int ba = ba(xC);
        int bb = bb(xC);
        int bc = bc(xC);
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        int i16 = 0;
        b bVar2 = new b();
        bVar2.bJj = i5;
        bVar2.bJa = aZ + ba;
        int flexItemCount = this.bJk.getFlexItemCount();
        boolean z3 = z2;
        int i17 = i5;
        while (true) {
            if (i17 >= flexItemCount) {
                i7 = i13;
                break;
            }
            View fk = this.bJk.fk(i17);
            if (fk != null) {
                if (fk.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) fk.getLayoutParams();
                    if (flexItem.xD() == 4) {
                        bVar2.bJi.add(Integer.valueOf(i17));
                    }
                    int a2 = a(flexItem, xC);
                    if (flexItem.xF() != -1.0f && mode == 1073741824) {
                        a2 = Math.round(((float) size) * flexItem.xF());
                    }
                    if (xC) {
                        int t = this.bJk.t(i2, aZ + ba + c(flexItem, true) + d(flexItem, true), a2);
                        int u = this.bJk.u(i3, bb + bc + e(flexItem, true) + f(flexItem, true) + i15, b(flexItem, true));
                        fk.measure(t, u);
                        a(i17, t, u, fk);
                        i9 = t;
                    } else {
                        int t2 = this.bJk.t(i3, bb + bc + e(flexItem, false) + f(flexItem, false) + i15, b(flexItem, false));
                        int u2 = this.bJk.u(i2, aZ + ba + c(flexItem, false) + d(flexItem, false), a2);
                        fk.measure(t2, u2);
                        a(i17, t2, u2, fk);
                        i9 = u2;
                    }
                    this.bJk.a(i17, fk);
                    H(fk, i17);
                    i7 = View.combineMeasuredStates(i13, fk.getMeasuredState());
                    if (a(fk, mode, size, bVar2.bJa, d(flexItem, xC) + j(fk, xC) + c(flexItem, xC), flexItem, i17, i16, list.size())) {
                        if (bVar2.xJ() > 0) {
                            a(list, bVar2, i17 > 0 ? i17 - 1 : 0, i15);
                            i11 = i15 + bVar2.bJc;
                        } else {
                            i11 = i15;
                        }
                        if (xC) {
                            if (flexItem.getHeight() == -1) {
                                a aVar2 = this.bJk;
                                fk.measure(i9, aVar2.u(i3, aVar2.getPaddingTop() + this.bJk.getPaddingBottom() + flexItem.xH() + flexItem.getMarginBottom() + i11, flexItem.getHeight()));
                                H(fk, i17);
                            }
                        } else if (flexItem.getWidth() == -1) {
                            a aVar3 = this.bJk;
                            fk.measure(aVar3.t(i3, aVar3.getPaddingLeft() + this.bJk.getPaddingRight() + flexItem.xG() + flexItem.xI() + i11, flexItem.getWidth()), i9);
                            H(fk, i17);
                        }
                        b bVar3 = new b();
                        bVar3.auc = 1;
                        bVar3.bJa = aZ + ba;
                        bVar3.bJj = i17;
                        i10 = 0;
                        i12 = Integer.MIN_VALUE;
                        bVar = bVar3;
                    } else {
                        bVar2.auc++;
                        bVar = bVar2;
                        i10 = i16 + 1;
                        i11 = i15;
                        i12 = i14;
                    }
                    if (this.bJm != null) {
                        this.bJm[i17] = list.size();
                    }
                    bVar.bJa += j(fk, xC) + c(flexItem, xC) + d(flexItem, xC);
                    bVar.bJe += flexItem.getFlexGrow();
                    bVar.bJf += flexItem.getFlexShrink();
                    this.bJk.a(fk, i17, i10, bVar);
                    i14 = Math.max(i12, k(fk, xC) + e(flexItem, xC) + f(flexItem, xC) + this.bJk.bV(fk));
                    bVar.bJc = Math.max(bVar.bJc, i14);
                    if (xC) {
                        if (this.bJk.getFlexWrap() != 2) {
                            bVar.bJg = Math.max(bVar.bJg, fk.getBaseline() + flexItem.xH());
                        } else {
                            bVar.bJg = Math.max(bVar.bJg, (fk.getMeasuredHeight() - fk.getBaseline()) + flexItem.getMarginBottom());
                        }
                    }
                    if (a(i17, flexItemCount, bVar)) {
                        a(list, bVar, i17, i11);
                        i15 = i11 + bVar.bJc;
                    } else {
                        i15 = i11;
                    }
                    if (i6 == -1 || list.size() <= 0 || list.get(list.size() - 1).acn < i6 || i17 < i6 || z3) {
                        z = z3;
                    } else {
                        i15 = -bVar.bJc;
                        z = true;
                    }
                    if (i15 > i4 && z) {
                        break;
                    }
                    bVar2 = bVar;
                    i16 = i10;
                    i8 = i7;
                } else {
                    bVar2.bJd++;
                    bVar2.auc++;
                    if (a(i17, flexItemCount, bVar2)) {
                        a(list, bVar2, i17, i15);
                        z = z3;
                        i8 = i13;
                    }
                    z = z3;
                    i8 = i13;
                }
            } else {
                if (a(i17, flexItemCount, bVar2)) {
                    a(list, bVar2, i17, i15);
                    z = z3;
                    i8 = i13;
                }
                z = z3;
                i8 = i13;
            }
            i17++;
            z3 = z;
            i13 = i8;
        }
        aVar.bJq = i7;
        AppMethodBeat.o(62227);
    }

    private int aZ(boolean z) {
        AppMethodBeat.i(62228);
        if (z) {
            int paddingStart = this.bJk.getPaddingStart();
            AppMethodBeat.o(62228);
            return paddingStart;
        }
        int paddingTop = this.bJk.getPaddingTop();
        AppMethodBeat.o(62228);
        return paddingTop;
    }

    private int ba(boolean z) {
        AppMethodBeat.i(62229);
        if (z) {
            int paddingEnd = this.bJk.getPaddingEnd();
            AppMethodBeat.o(62229);
            return paddingEnd;
        }
        int paddingBottom = this.bJk.getPaddingBottom();
        AppMethodBeat.o(62229);
        return paddingBottom;
    }

    private int bb(boolean z) {
        AppMethodBeat.i(62230);
        if (z) {
            int paddingTop = this.bJk.getPaddingTop();
            AppMethodBeat.o(62230);
            return paddingTop;
        }
        int paddingStart = this.bJk.getPaddingStart();
        AppMethodBeat.o(62230);
        return paddingStart;
    }

    private int bc(boolean z) {
        AppMethodBeat.i(62231);
        if (z) {
            int paddingBottom = this.bJk.getPaddingBottom();
            AppMethodBeat.o(62231);
            return paddingBottom;
        }
        int paddingEnd = this.bJk.getPaddingEnd();
        AppMethodBeat.o(62231);
        return paddingEnd;
    }

    private static int j(View view, boolean z) {
        AppMethodBeat.i(62232);
        if (z) {
            int measuredWidth = view.getMeasuredWidth();
            AppMethodBeat.o(62232);
            return measuredWidth;
        }
        int measuredHeight = view.getMeasuredHeight();
        AppMethodBeat.o(62232);
        return measuredHeight;
    }

    private static int k(View view, boolean z) {
        AppMethodBeat.i(62233);
        if (z) {
            int measuredHeight = view.getMeasuredHeight();
            AppMethodBeat.o(62233);
            return measuredHeight;
        }
        int measuredWidth = view.getMeasuredWidth();
        AppMethodBeat.o(62233);
        return measuredWidth;
    }

    private static int a(FlexItem flexItem, boolean z) {
        AppMethodBeat.i(62234);
        if (z) {
            int width = flexItem.getWidth();
            AppMethodBeat.o(62234);
            return width;
        }
        int height = flexItem.getHeight();
        AppMethodBeat.o(62234);
        return height;
    }

    private static int b(FlexItem flexItem, boolean z) {
        AppMethodBeat.i(62235);
        if (z) {
            int height = flexItem.getHeight();
            AppMethodBeat.o(62235);
            return height;
        }
        int width = flexItem.getWidth();
        AppMethodBeat.o(62235);
        return width;
    }

    private static int c(FlexItem flexItem, boolean z) {
        AppMethodBeat.i(62236);
        if (z) {
            int xG = flexItem.xG();
            AppMethodBeat.o(62236);
            return xG;
        }
        int xH = flexItem.xH();
        AppMethodBeat.o(62236);
        return xH;
    }

    private static int d(FlexItem flexItem, boolean z) {
        AppMethodBeat.i(62237);
        if (z) {
            int xI = flexItem.xI();
            AppMethodBeat.o(62237);
            return xI;
        }
        int marginBottom = flexItem.getMarginBottom();
        AppMethodBeat.o(62237);
        return marginBottom;
    }

    private static int e(FlexItem flexItem, boolean z) {
        AppMethodBeat.i(62238);
        if (z) {
            int xH = flexItem.xH();
            AppMethodBeat.o(62238);
            return xH;
        }
        int xG = flexItem.xG();
        AppMethodBeat.o(62238);
        return xG;
    }

    private static int f(FlexItem flexItem, boolean z) {
        AppMethodBeat.i(62239);
        if (z) {
            int marginBottom = flexItem.getMarginBottom();
            AppMethodBeat.o(62239);
            return marginBottom;
        }
        int xI = flexItem.xI();
        AppMethodBeat.o(62239);
        return xI;
    }

    private boolean a(View view, int i2, int i3, int i4, int i5, FlexItem flexItem, int i6, int i7, int i8) {
        AppMethodBeat.i(62240);
        if (this.bJk.getFlexWrap() == 0) {
            AppMethodBeat.o(62240);
            return false;
        } else if (flexItem.xE()) {
            AppMethodBeat.o(62240);
            return true;
        } else if (i2 == 0) {
            AppMethodBeat.o(62240);
            return false;
        } else {
            int maxLine = this.bJk.getMaxLine();
            if (maxLine == -1 || maxLine > i8 + 1) {
                int m = this.bJk.m(view, i6, i7);
                if (m > 0) {
                    i5 += m;
                }
                if (i3 < i4 + i5) {
                    AppMethodBeat.o(62240);
                    return true;
                }
                AppMethodBeat.o(62240);
                return false;
            }
            AppMethodBeat.o(62240);
            return false;
        }
    }

    private static boolean a(int i2, int i3, b bVar) {
        AppMethodBeat.i(62241);
        if (i2 != i3 - 1 || bVar.xJ() == 0) {
            AppMethodBeat.o(62241);
            return false;
        }
        AppMethodBeat.o(62241);
        return true;
    }

    private void a(List<b> list, b bVar, int i2, int i3) {
        AppMethodBeat.i(62242);
        bVar.bJh = i3;
        this.bJk.a(bVar);
        bVar.acn = i2;
        list.add(bVar);
        AppMethodBeat.o(62242);
    }

    private void H(View view, int i2) {
        int i3;
        boolean z = true;
        AppMethodBeat.i(62243);
        boolean z2 = false;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth < flexItem.getMinWidth()) {
            measuredWidth = flexItem.getMinWidth();
            z2 = true;
        } else if (measuredWidth > flexItem.getMaxWidth()) {
            measuredWidth = flexItem.getMaxWidth();
            z2 = true;
        }
        if (measuredHeight < flexItem.getMinHeight()) {
            i3 = flexItem.getMinHeight();
        } else if (measuredHeight > flexItem.getMaxHeight()) {
            i3 = flexItem.getMaxHeight();
        } else {
            i3 = measuredHeight;
            z = z2;
        }
        if (z) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            a(i2, makeMeasureSpec, makeMeasureSpec2, view);
            this.bJk.a(i2, view);
        }
        AppMethodBeat.o(62243);
    }

    /* access modifiers changed from: package-private */
    public final void bk(int i2, int i3) {
        AppMethodBeat.i(62244);
        v(i2, i3, 0);
        AppMethodBeat.o(62244);
    }

    /* access modifiers changed from: package-private */
    public final void v(int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        AppMethodBeat.i(62245);
        fm(this.bJk.getFlexItemCount());
        if (i4 >= this.bJk.getFlexItemCount()) {
            AppMethodBeat.o(62245);
            return;
        }
        int flexDirection = this.bJk.getFlexDirection();
        switch (this.bJk.getFlexDirection()) {
            case 0:
            case 1:
                int mode = View.MeasureSpec.getMode(i2);
                int size = View.MeasureSpec.getSize(i2);
                if (mode != 1073741824) {
                    size = this.bJk.getLargestMainSize();
                }
                paddingTop = this.bJk.getPaddingLeft() + this.bJk.getPaddingRight();
                i5 = size;
                break;
            case 2:
            case 3:
                int mode2 = View.MeasureSpec.getMode(i3);
                int size2 = View.MeasureSpec.getSize(i3);
                if (mode2 != 1073741824) {
                    size2 = this.bJk.getLargestMainSize();
                }
                paddingTop = this.bJk.getPaddingTop() + this.bJk.getPaddingBottom();
                i5 = size2;
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                AppMethodBeat.o(62245);
                throw illegalArgumentException;
        }
        int i6 = this.bJm != null ? this.bJm[i4] : 0;
        List<b> flexLinesInternal = this.bJk.getFlexLinesInternal();
        int size3 = flexLinesInternal.size();
        for (int i7 = i6; i7 < size3; i7++) {
            b bVar = flexLinesInternal.get(i7);
            if (bVar.bJa < i5) {
                a(i2, i3, bVar, i5, paddingTop, false);
            } else {
                b(i2, i3, bVar, i5, paddingTop, false);
            }
        }
        AppMethodBeat.o(62245);
    }

    private void fm(int i2) {
        AppMethodBeat.i(62246);
        if (this.bJl == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.bJl = new boolean[i2];
            AppMethodBeat.o(62246);
        } else if (this.bJl.length < i2) {
            int length = this.bJl.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.bJl = new boolean[i2];
            AppMethodBeat.o(62246);
        } else {
            Arrays.fill(this.bJl, false);
            AppMethodBeat.o(62246);
        }
    }

    private void a(int i2, int i3, b bVar, int i4, int i5, boolean z) {
        float f2;
        boolean z2;
        int i6;
        int i7;
        int i8;
        float f3;
        boolean z3;
        int i9;
        int i10;
        float f4;
        boolean z4;
        AppMethodBeat.i(62247);
        while (bVar.bJe > 0.0f && i4 >= bVar.bJa) {
            int i11 = bVar.bJa;
            boolean z5 = false;
            float f5 = ((float) (i4 - bVar.bJa)) / bVar.bJe;
            bVar.bJa = bVar.bJb + i5;
            int i12 = 0;
            if (!z) {
                bVar.bJc = Integer.MIN_VALUE;
            }
            float f6 = 0.0f;
            for (int i13 = 0; i13 < bVar.auc; i13++) {
                int i14 = bVar.bJj + i13;
                View fk = this.bJk.fk(i14);
                if (!(fk == null || fk.getVisibility() == 8)) {
                    FlexItem flexItem = (FlexItem) fk.getLayoutParams();
                    int flexDirection = this.bJk.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = fk.getMeasuredWidth();
                        if (this.bJo != null) {
                            measuredWidth = (int) this.bJo[i14];
                        }
                        int measuredHeight = fk.getMeasuredHeight();
                        if (this.bJo != null) {
                            measuredHeight = (int) (this.bJo[i14] >> 32);
                        }
                        if (this.bJl[i14] || flexItem.getFlexGrow() <= 0.0f) {
                            i7 = measuredHeight;
                            i8 = measuredWidth;
                            z2 = z5;
                            f2 = f6;
                        } else {
                            float flexGrow = ((float) measuredWidth) + (flexItem.getFlexGrow() * f5);
                            if (i13 == bVar.auc - 1) {
                                f3 = 0.0f;
                                flexGrow = f6 + flexGrow;
                            } else {
                                f3 = f6;
                            }
                            int round = Math.round(flexGrow);
                            if (round > flexItem.getMaxWidth()) {
                                z3 = true;
                                int maxWidth = flexItem.getMaxWidth();
                                this.bJl[i14] = true;
                                bVar.bJe -= flexItem.getFlexGrow();
                                round = maxWidth;
                            } else {
                                f3 += flexGrow - ((float) round);
                                if (((double) f3) > 1.0d) {
                                    round++;
                                    f3 = (float) (((double) f3) - 1.0d);
                                    z3 = z5;
                                } else if (((double) f3) < -1.0d) {
                                    round--;
                                    f3 = (float) (((double) f3) + 1.0d);
                                    z3 = z5;
                                } else {
                                    z3 = z5;
                                }
                            }
                            int b2 = b(i3, flexItem, bVar.bJh);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                            fk.measure(makeMeasureSpec, b2);
                            int measuredWidth2 = fk.getMeasuredWidth();
                            int measuredHeight2 = fk.getMeasuredHeight();
                            a(i14, makeMeasureSpec, b2, fk);
                            this.bJk.a(i14, fk);
                            i7 = measuredHeight2;
                            i8 = measuredWidth2;
                            z2 = z3;
                            f2 = f3;
                        }
                        int max = Math.max(i12, flexItem.xH() + i7 + flexItem.getMarginBottom() + this.bJk.bV(fk));
                        bVar.bJa = flexItem.xI() + flexItem.xG() + i8 + bVar.bJa;
                        i6 = max;
                    } else {
                        int measuredHeight3 = fk.getMeasuredHeight();
                        if (this.bJo != null) {
                            measuredHeight3 = (int) (this.bJo[i14] >> 32);
                        }
                        int measuredWidth3 = fk.getMeasuredWidth();
                        if (this.bJo != null) {
                            measuredWidth3 = (int) this.bJo[i14];
                        }
                        if (this.bJl[i14] || flexItem.getFlexGrow() <= 0.0f) {
                            i9 = measuredWidth3;
                            i10 = measuredHeight3;
                            z2 = z5;
                            f2 = f6;
                        } else {
                            float flexGrow2 = ((float) measuredHeight3) + (flexItem.getFlexGrow() * f5);
                            if (i13 == bVar.auc - 1) {
                                f4 = 0.0f;
                                flexGrow2 = f6 + flexGrow2;
                            } else {
                                f4 = f6;
                            }
                            int round2 = Math.round(flexGrow2);
                            if (round2 > flexItem.getMaxHeight()) {
                                z4 = true;
                                int maxHeight = flexItem.getMaxHeight();
                                this.bJl[i14] = true;
                                bVar.bJe -= flexItem.getFlexGrow();
                                round2 = maxHeight;
                            } else {
                                f4 += flexGrow2 - ((float) round2);
                                if (((double) f4) > 1.0d) {
                                    round2++;
                                    f4 = (float) (((double) f4) - 1.0d);
                                    z4 = z5;
                                } else if (((double) f4) < -1.0d) {
                                    round2--;
                                    f4 = (float) (((double) f4) + 1.0d);
                                    z4 = z5;
                                } else {
                                    z4 = z5;
                                }
                            }
                            int a2 = a(i2, flexItem, bVar.bJh);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                            fk.measure(a2, makeMeasureSpec2);
                            int measuredWidth4 = fk.getMeasuredWidth();
                            int measuredHeight4 = fk.getMeasuredHeight();
                            a(i14, a2, makeMeasureSpec2, fk);
                            this.bJk.a(i14, fk);
                            i9 = measuredWidth4;
                            i10 = measuredHeight4;
                            z2 = z4;
                            f2 = f4;
                        }
                        int max2 = Math.max(i12, flexItem.xG() + i9 + flexItem.xI() + this.bJk.bV(fk));
                        bVar.bJa = flexItem.getMarginBottom() + flexItem.xH() + i10 + bVar.bJa;
                        i6 = max2;
                    }
                    bVar.bJc = Math.max(bVar.bJc, i6);
                    i12 = i6;
                    z5 = z2;
                    f6 = f2;
                }
            }
            if (!z5 || i11 == bVar.bJa) {
                AppMethodBeat.o(62247);
                return;
            }
            z = true;
        }
        AppMethodBeat.o(62247);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r19, int r20, com.google.android.flexbox.b r21, int r22, int r23, boolean r24) {
        /*
        // Method dump skipped, instructions count: 620
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.c.b(int, int, com.google.android.flexbox.b, int, int, boolean):void");
    }

    private int a(int i2, FlexItem flexItem, int i3) {
        AppMethodBeat.i(62249);
        a aVar = this.bJk;
        int t = aVar.t(i2, aVar.getPaddingLeft() + this.bJk.getPaddingRight() + flexItem.xG() + flexItem.xI() + i3, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(t);
        if (size > flexItem.getMaxWidth()) {
            t = View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(t));
        } else if (size < flexItem.getMinWidth()) {
            t = View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(t));
        }
        AppMethodBeat.o(62249);
        return t;
    }

    private int b(int i2, FlexItem flexItem, int i3) {
        AppMethodBeat.i(62250);
        a aVar = this.bJk;
        int u = aVar.u(i2, aVar.getPaddingTop() + this.bJk.getPaddingBottom() + flexItem.xH() + flexItem.getMarginBottom() + i3, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(u);
        if (size > flexItem.getMaxHeight()) {
            u = View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(u));
        } else if (size < flexItem.getMinHeight()) {
            u = View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(u));
        }
        AppMethodBeat.o(62250);
        return u;
    }

    /* access modifiers changed from: package-private */
    public final void w(int i2, int i3, int i4) {
        int mode;
        int size;
        float f2;
        float f3;
        int i5;
        AppMethodBeat.i(62251);
        int flexDirection = this.bJk.getFlexDirection();
        switch (flexDirection) {
            case 0:
            case 1:
                mode = View.MeasureSpec.getMode(i3);
                size = View.MeasureSpec.getSize(i3);
                break;
            case 2:
            case 3:
                mode = View.MeasureSpec.getMode(i2);
                size = View.MeasureSpec.getSize(i2);
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                AppMethodBeat.o(62251);
                throw illegalArgumentException;
        }
        List<b> flexLinesInternal = this.bJk.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.bJk.getSumOfCrossSize() + i4;
            if (flexLinesInternal.size() != 1) {
                if (flexLinesInternal.size() >= 2) {
                    switch (this.bJk.getAlignContent()) {
                        case 1:
                            int i6 = size - sumOfCrossSize;
                            b bVar = new b();
                            bVar.bJc = i6;
                            flexLinesInternal.add(0, bVar);
                            break;
                        case 2:
                            this.bJk.setFlexLines(a(flexLinesInternal, size, sumOfCrossSize));
                            AppMethodBeat.o(62251);
                            return;
                        case 3:
                            if (sumOfCrossSize < size) {
                                float size2 = ((float) (size - sumOfCrossSize)) / ((float) (flexLinesInternal.size() - 1));
                                float f4 = 0.0f;
                                ArrayList arrayList = new ArrayList();
                                int size3 = flexLinesInternal.size();
                                int i7 = 0;
                                while (i7 < size3) {
                                    arrayList.add(flexLinesInternal.get(i7));
                                    if (i7 != flexLinesInternal.size() - 1) {
                                        b bVar2 = new b();
                                        if (i7 == flexLinesInternal.size() - 2) {
                                            bVar2.bJc = Math.round(size2 + f4);
                                            f3 = 0.0f;
                                        } else {
                                            bVar2.bJc = Math.round(size2);
                                            f3 = f4;
                                        }
                                        f2 = f3 + (size2 - ((float) bVar2.bJc));
                                        if (f2 > 1.0f) {
                                            bVar2.bJc++;
                                            f2 -= 1.0f;
                                        } else if (f2 < -1.0f) {
                                            bVar2.bJc--;
                                            f2 += 1.0f;
                                        }
                                        arrayList.add(bVar2);
                                    } else {
                                        f2 = f4;
                                    }
                                    i7++;
                                    f4 = f2;
                                }
                                this.bJk.setFlexLines(arrayList);
                                AppMethodBeat.o(62251);
                                return;
                            }
                            break;
                        case 4:
                            if (sumOfCrossSize >= size) {
                                this.bJk.setFlexLines(a(flexLinesInternal, size, sumOfCrossSize));
                                AppMethodBeat.o(62251);
                                return;
                            }
                            int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                            ArrayList arrayList2 = new ArrayList();
                            b bVar3 = new b();
                            bVar3.bJc = size4;
                            for (b bVar4 : flexLinesInternal) {
                                arrayList2.add(bVar3);
                                arrayList2.add(bVar4);
                                arrayList2.add(bVar3);
                            }
                            this.bJk.setFlexLines(arrayList2);
                            AppMethodBeat.o(62251);
                            return;
                        case 5:
                            if (sumOfCrossSize < size) {
                                float size5 = ((float) (size - sumOfCrossSize)) / ((float) flexLinesInternal.size());
                                float f5 = 0.0f;
                                int size6 = flexLinesInternal.size();
                                for (int i8 = 0; i8 < size6; i8++) {
                                    b bVar5 = flexLinesInternal.get(i8);
                                    float f6 = ((float) bVar5.bJc) + size5;
                                    if (i8 == flexLinesInternal.size() - 1) {
                                        f6 += f5;
                                        f5 = 0.0f;
                                    }
                                    int round = Math.round(f6);
                                    f5 += f6 - ((float) round);
                                    if (f5 > 1.0f) {
                                        i5 = round + 1;
                                        f5 -= 1.0f;
                                    } else if (f5 < -1.0f) {
                                        i5 = round - 1;
                                        f5 += 1.0f;
                                    } else {
                                        i5 = round;
                                    }
                                    bVar5.bJc = i5;
                                }
                                AppMethodBeat.o(62251);
                                return;
                            }
                            break;
                    }
                }
            } else {
                flexLinesInternal.get(0).bJc = size - i4;
                AppMethodBeat.o(62251);
                return;
            }
        }
        AppMethodBeat.o(62251);
    }

    private static List<b> a(List<b> list, int i2, int i3) {
        AppMethodBeat.i(62252);
        ArrayList arrayList = new ArrayList();
        b bVar = new b();
        bVar.bJc = (i2 - i3) / 2;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(bVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(bVar);
            }
        }
        AppMethodBeat.o(62252);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final void xK() {
        AppMethodBeat.i(62253);
        fn(0);
        AppMethodBeat.o(62253);
    }

    /* access modifiers changed from: package-private */
    public final void fn(int i2) {
        View fk;
        AppMethodBeat.i(62254);
        if (i2 >= this.bJk.getFlexItemCount()) {
            AppMethodBeat.o(62254);
            return;
        }
        int flexDirection = this.bJk.getFlexDirection();
        if (this.bJk.getAlignItems() == 4) {
            int i3 = 0;
            if (this.bJm != null) {
                i3 = this.bJm[i2];
            }
            List<b> flexLinesInternal = this.bJk.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i4 = i3; i4 < size; i4++) {
                b bVar = flexLinesInternal.get(i4);
                int i5 = bVar.auc;
                for (int i6 = 0; i6 < i5; i6++) {
                    int i7 = bVar.bJj + i6;
                    if (!(i6 >= this.bJk.getFlexItemCount() || (fk = this.bJk.fk(i7)) == null || fk.getVisibility() == 8)) {
                        FlexItem flexItem = (FlexItem) fk.getLayoutParams();
                        if (flexItem.xD() == -1 || flexItem.xD() == 4) {
                            switch (flexDirection) {
                                case 0:
                                case 1:
                                    n(fk, bVar.bJc, i7);
                                    break;
                                case 2:
                                case 3:
                                    o(fk, bVar.bJc, i7);
                                    break;
                                default:
                                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                                    AppMethodBeat.o(62254);
                                    throw illegalArgumentException;
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(62254);
            return;
        }
        for (b bVar2 : this.bJk.getFlexLinesInternal()) {
            Iterator<Integer> it = bVar2.bJi.iterator();
            while (true) {
                if (it.hasNext()) {
                    Integer next = it.next();
                    View fk2 = this.bJk.fk(next.intValue());
                    switch (flexDirection) {
                        case 0:
                        case 1:
                            n(fk2, bVar2.bJc, next.intValue());
                            break;
                        case 2:
                        case 3:
                            o(fk2, bVar2.bJc, next.intValue());
                            break;
                        default:
                            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                            AppMethodBeat.o(62254);
                            throw illegalArgumentException2;
                    }
                }
            }
        }
        AppMethodBeat.o(62254);
    }

    private void n(View view, int i2, int i3) {
        int measuredWidth;
        AppMethodBeat.i(62255);
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i2 - flexItem.xH()) - flexItem.getMarginBottom()) - this.bJk.bV(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.bJo != null) {
            measuredWidth = (int) this.bJo[i3];
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        a(i3, makeMeasureSpec, makeMeasureSpec2, view);
        this.bJk.a(i3, view);
        AppMethodBeat.o(62255);
    }

    private void o(View view, int i2, int i3) {
        int measuredHeight;
        AppMethodBeat.i(62256);
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i2 - flexItem.xG()) - flexItem.xI()) - this.bJk.bV(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.bJo != null) {
            measuredHeight = (int) (this.bJo[i3] >> 32);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        a(i3, makeMeasureSpec2, makeMeasureSpec, view);
        this.bJk.a(i3, view);
        AppMethodBeat.o(62256);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public final void a(View view, b bVar, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(62257);
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.bJk.getAlignItems();
        if (flexItem.xD() != -1) {
            alignItems = flexItem.xD();
        }
        int i6 = bVar.bJc;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.bJk.getFlexWrap() != 2) {
                    view.layout(i2, flexItem.xH() + i3, i4, flexItem.xH() + i5);
                    AppMethodBeat.o(62257);
                    return;
                }
                view.layout(i2, i3 - flexItem.getMarginBottom(), i4, i5 - flexItem.getMarginBottom());
                AppMethodBeat.o(62257);
                return;
            case 1:
                if (this.bJk.getFlexWrap() != 2) {
                    view.layout(i2, ((i3 + i6) - view.getMeasuredHeight()) - flexItem.getMarginBottom(), i4, (i6 + i3) - flexItem.getMarginBottom());
                    AppMethodBeat.o(62257);
                    return;
                }
                view.layout(i2, (i3 - i6) + view.getMeasuredHeight() + flexItem.xH(), i4, flexItem.xH() + (i5 - i6) + view.getMeasuredHeight());
                AppMethodBeat.o(62257);
                return;
            case 2:
                int measuredHeight = (((i6 - view.getMeasuredHeight()) + flexItem.xH()) - flexItem.getMarginBottom()) / 2;
                if (this.bJk.getFlexWrap() == 2) {
                    view.layout(i2, i3 - measuredHeight, i4, (i3 - measuredHeight) + view.getMeasuredHeight());
                    break;
                } else {
                    view.layout(i2, i3 + measuredHeight, i4, measuredHeight + i3 + view.getMeasuredHeight());
                    AppMethodBeat.o(62257);
                    return;
                }
            case 3:
                if (this.bJk.getFlexWrap() != 2) {
                    int max = Math.max(bVar.bJg - view.getBaseline(), flexItem.xH());
                    view.layout(i2, i3 + max, i4, max + i5);
                    AppMethodBeat.o(62257);
                    return;
                }
                int max2 = Math.max((bVar.bJg - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                view.layout(i2, i3 - max2, i4, i5 - max2);
                AppMethodBeat.o(62257);
                return;
        }
        AppMethodBeat.o(62257);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public final void a(View view, b bVar, boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(62258);
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.bJk.getAlignItems();
        if (flexItem.xD() != -1) {
            alignItems = flexItem.xD();
        }
        int i6 = bVar.bJc;
        switch (alignItems) {
            case 0:
            case 3:
            case 4:
                if (!z) {
                    view.layout(flexItem.xG() + i2, i3, flexItem.xG() + i4, i5);
                    AppMethodBeat.o(62258);
                    return;
                }
                view.layout(i2 - flexItem.xI(), i3, i4 - flexItem.xI(), i5);
                AppMethodBeat.o(62258);
                return;
            case 1:
                if (!z) {
                    view.layout(((i2 + i6) - view.getMeasuredWidth()) - flexItem.xI(), i3, ((i6 + i4) - view.getMeasuredWidth()) - flexItem.xI(), i5);
                    AppMethodBeat.o(62258);
                    return;
                }
                view.layout((i2 - i6) + view.getMeasuredWidth() + flexItem.xG(), i3, flexItem.xG() + (i4 - i6) + view.getMeasuredWidth(), i5);
                AppMethodBeat.o(62258);
                return;
            case 2:
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i6 - view.getMeasuredWidth()) + g.a(marginLayoutParams)) - g.b(marginLayoutParams)) / 2;
                if (z) {
                    view.layout(i2 - measuredWidth, i3, i4 - measuredWidth, i5);
                    break;
                } else {
                    view.layout(i2 + measuredWidth, i3, measuredWidth + i4, i5);
                    AppMethodBeat.o(62258);
                    return;
                }
        }
        AppMethodBeat.o(62258);
    }

    /* access modifiers changed from: package-private */
    public final void fo(int i2) {
        AppMethodBeat.i(62259);
        if (this.bJo == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.bJo = new long[i2];
            AppMethodBeat.o(62259);
            return;
        }
        if (this.bJo.length < i2) {
            int length = this.bJo.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.bJo = Arrays.copyOf(this.bJo, i2);
        }
        AppMethodBeat.o(62259);
    }

    /* access modifiers changed from: package-private */
    public final void fp(int i2) {
        AppMethodBeat.i(62260);
        if (this.bJn == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.bJn = new long[i2];
            AppMethodBeat.o(62260);
            return;
        }
        if (this.bJn.length < i2) {
            int length = this.bJn.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.bJn = Arrays.copyOf(this.bJn, i2);
        }
        AppMethodBeat.o(62260);
    }

    static int at(long j2) {
        return (int) j2;
    }

    static int au(long j2) {
        return (int) (j2 >> 32);
    }

    private static long bl(int i2, int i3) {
        return (((long) i3) << 32) | (((long) i2) & Util.MAX_32BIT_VALUE);
    }

    private void a(int i2, int i3, int i4, View view) {
        AppMethodBeat.i(62261);
        if (this.bJn != null) {
            this.bJn[i2] = bl(i3, i4);
        }
        if (this.bJo != null) {
            this.bJo[i2] = bl(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
        AppMethodBeat.o(62261);
    }

    /* access modifiers changed from: package-private */
    public final void fq(int i2) {
        AppMethodBeat.i(62262);
        if (this.bJm == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.bJm = new int[i2];
            AppMethodBeat.o(62262);
            return;
        }
        if (this.bJm.length < i2) {
            int length = this.bJm.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.bJm = Arrays.copyOf(this.bJm, i2);
        }
        AppMethodBeat.o(62262);
    }

    /* access modifiers changed from: package-private */
    public final void c(List<b> list, int i2) {
        AppMethodBeat.i(62263);
        if (!$assertionsDisabled && this.bJm == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(62263);
            throw assertionError;
        } else if ($assertionsDisabled || this.bJn != null) {
            int i3 = this.bJm[i2];
            if (i3 == -1) {
                i3 = 0;
            }
            for (int size = list.size() - 1; size >= i3; size--) {
                list.remove(size);
            }
            int length = this.bJm.length - 1;
            if (i2 > length) {
                Arrays.fill(this.bJm, -1);
            } else {
                Arrays.fill(this.bJm, i2, length, -1);
            }
            int length2 = this.bJn.length - 1;
            if (i2 > length2) {
                Arrays.fill(this.bJn, 0L);
                AppMethodBeat.o(62263);
                return;
            }
            Arrays.fill(this.bJn, i2, length2, 0L);
            AppMethodBeat.o(62263);
        } else {
            AssertionError assertionError2 = new AssertionError();
            AppMethodBeat.o(62263);
            throw assertionError2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements Comparable<b> {
        int index;
        int order;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(b bVar) {
            b bVar2 = bVar;
            if (this.order != bVar2.order) {
                return this.order - bVar2.order;
            }
            return this.index - bVar2.index;
        }

        public final String toString() {
            AppMethodBeat.i(62216);
            String str = "Order{order=" + this.order + ", index=" + this.index + '}';
            AppMethodBeat.o(62216);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        List<b> bJp;
        int bJq;

        a() {
        }

        /* access modifiers changed from: package-private */
        public final void reset() {
            this.bJp = null;
            this.bJq = 0;
        }
    }
}
