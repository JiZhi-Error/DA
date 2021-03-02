package com.tencent.mm.plugin.editor.model.nativenote.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.editor.model.nativenote.a.b;
import com.tencent.mm.plugin.editor.model.nativenote.c.a;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public final class e implements a.AbstractC0950a {
    public static boolean mHasInit = false;
    public static volatile e qSp = null;
    public MMHandler mHandler = null;
    public int mScreenHeight = 0;
    public int mScreenWidth = 0;
    public int qSA = 0;
    public int[] qSB = null;
    public int[] qSC = null;
    public int[] qSD = null;
    public int[] qSE = null;
    public PopupWindow qSF = null;
    public PopupWindow qSG = null;
    public PopupWindow qSH = null;
    public PopupWindow qSI = null;
    public com.tencent.mm.plugin.editor.model.nativenote.b.a qSJ = null;
    public d qSK = null;
    public b qSL = null;
    public MTimerHandler qSM = null;
    public MTimerHandler qSN = null;
    public TextView qSO = null;
    public TextView qSP = null;
    public TextView qSQ = null;
    public TextView qSR = null;
    public TextView qSS = null;
    public TextView qST = null;
    public TextView qSU = null;
    public TextView qSV = null;
    public boolean qSq = true;
    public int qSr = 0;
    public int qSs = 0;
    public int qSt = 14;
    public int qSu = 0;
    public int qSv = 0;
    public int qSw = 0;
    public int qSx = 0;
    public int qSy = 0;
    public int qSz = 0;

    static /* synthetic */ int a(e eVar, RecyclerView recyclerView) {
        AppMethodBeat.i(181913);
        int j2 = eVar.j(recyclerView);
        AppMethodBeat.o(181913);
        return j2;
    }

    static /* synthetic */ RecyclerView a(e eVar) {
        AppMethodBeat.i(181911);
        RecyclerView recyclerView = eVar.getRecyclerView();
        AppMethodBeat.o(181911);
        return recyclerView;
    }

    static /* synthetic */ SpannableStringBuilder a(e eVar, boolean z, ArrayList arrayList, String str) {
        AppMethodBeat.i(181920);
        SpannableStringBuilder a2 = eVar.a(z, arrayList, str);
        AppMethodBeat.o(181920);
        return a2;
    }

    static /* synthetic */ ArrayList b(e eVar, boolean z, ArrayList arrayList, String str) {
        AppMethodBeat.i(181921);
        ArrayList<com.tencent.mm.plugin.editor.model.a.a> b2 = eVar.b(z, arrayList, str);
        AppMethodBeat.o(181921);
        return b2;
    }

    static /* synthetic */ boolean b(e eVar) {
        AppMethodBeat.i(181912);
        boolean FC = eVar.FC(2);
        AppMethodBeat.o(181912);
        return FC;
    }

    static /* synthetic */ int d(e eVar) {
        AppMethodBeat.i(181914);
        int cEg = eVar.cEg();
        AppMethodBeat.o(181914);
        return cEg;
    }

    static /* synthetic */ void e(e eVar) {
        AppMethodBeat.i(181915);
        eVar.cDX();
        AppMethodBeat.o(181915);
    }

    static /* synthetic */ void f(e eVar) {
        AppMethodBeat.i(181916);
        eVar.lo(false);
        AppMethodBeat.o(181916);
    }

    static /* synthetic */ void h(e eVar) {
        AppMethodBeat.i(181917);
        eVar.cEh();
        AppMethodBeat.o(181917);
    }

    private e() {
        mHasInit = false;
    }

    public static e cDT() {
        AppMethodBeat.i(181865);
        if (qSp == null) {
            synchronized (c.class) {
                try {
                    if (qSp == null) {
                        qSp = new e();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(181865);
                    throw th;
                }
            }
        }
        e eVar = qSp;
        AppMethodBeat.o(181865);
        return eVar;
    }

    public static boolean isEnabled() {
        return mHasInit;
    }

    public final boolean isEditable() {
        return mHasInit && this.qSq;
    }

    private RecyclerView getRecyclerView() {
        AppMethodBeat.i(181866);
        if (this.qSJ != null) {
            RecyclerView cCH = this.qSJ.cCH();
            AppMethodBeat.o(181866);
            return cCH;
        }
        AppMethodBeat.o(181866);
        return null;
    }

    private int cDU() {
        AppMethodBeat.i(181867);
        if (this.qSJ != null) {
            int cCE = this.qSJ.cCE() + this.qSJ.cCF();
            AppMethodBeat.o(181867);
            return cCE;
        }
        AppMethodBeat.o(181867);
        return 0;
    }

    public final int getSelectType() {
        AppMethodBeat.i(181868);
        if (!mHasInit) {
            AppMethodBeat.o(181868);
            return 0;
        }
        if (this.qSK == null) {
            this.qSK = new d();
        }
        int selectType = this.qSK.getSelectType();
        AppMethodBeat.o(181868);
        return selectType;
    }

    public final d cDV() {
        AppMethodBeat.i(181869);
        if (!mHasInit) {
            d dVar = new d();
            AppMethodBeat.o(181869);
            return dVar;
        }
        if (this.qSK == null) {
            this.qSK = new d();
        }
        d dVar2 = new d(this.qSK.bNu, this.qSK.startOffset, this.qSK.endPos, this.qSK.qSo);
        AppMethodBeat.o(181869);
        return dVar2;
    }

    public final boolean B(int i2, int i3, int i4, int i5) {
        boolean z;
        AppMethodBeat.i(181870);
        if (!mHasInit) {
            AppMethodBeat.o(181870);
            return false;
        }
        if (this.qSK == null) {
            this.qSK = new d(i2, i3, i4, i5);
            z = true;
        } else if (this.qSK.bNu == i2 && this.qSK.startOffset == i3 && this.qSK.endPos == i4 && this.qSK.qSo == i5) {
            z = false;
        } else {
            this.qSK.set(i2, i3, i4, i5);
            z = true;
        }
        if (z) {
            Log.d("EditorSelectManager", "setSelectInfo: %d:%d - %d:%d", Integer.valueOf(this.qSK.bNu), Integer.valueOf(this.qSK.startOffset), Integer.valueOf(this.qSK.endPos), Integer.valueOf(this.qSK.qSo));
        }
        AppMethodBeat.o(181870);
        return z;
    }

    private void cDW() {
        AppMethodBeat.i(181871);
        B(-1, -1, -1, -1);
        AppMethodBeat.o(181871);
    }

    public final int FB(int i2) {
        AppMethodBeat.i(181872);
        if (!mHasInit || this.qSK == null) {
            AppMethodBeat.o(181872);
            return 0;
        } else if (getSelectType() == 0 || i2 < this.qSK.bNu || i2 > this.qSK.endPos) {
            AppMethodBeat.o(181872);
            return 0;
        } else if (i2 == this.qSK.bNu && i2 == this.qSK.endPos) {
            AppMethodBeat.o(181872);
            return 1;
        } else if (i2 > this.qSK.bNu && i2 < this.qSK.endPos) {
            AppMethodBeat.o(181872);
            return 2;
        } else if (i2 == this.qSK.bNu && i2 < this.qSK.endPos) {
            AppMethodBeat.o(181872);
            return 4;
        } else if (i2 <= this.qSK.bNu || i2 != this.qSK.endPos) {
            AppMethodBeat.o(181872);
            return 0;
        } else {
            AppMethodBeat.o(181872);
            return 3;
        }
    }

    private void Y(int i2, int i3, int i4) {
        if (mHasInit) {
            switch (i2) {
                case 2:
                    if (this.qSC != null && this.qSC.length == 2) {
                        this.qSC[0] = i3;
                        this.qSC[1] = i4;
                        return;
                    }
                    return;
                case 3:
                    if (this.qSD != null && this.qSD.length == 2) {
                        this.qSD[0] = i3;
                        this.qSD[1] = i4;
                        return;
                    }
                    return;
                case 4:
                    if (this.qSE != null && this.qSE.length == 2) {
                        this.qSE[0] = i3;
                        this.qSE[1] = i4;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private static boolean A(int[] iArr) {
        return (!mHasInit || iArr == null || iArr.length != 2 || iArr[0] == -1 || iArr[1] == -1) ? false : true;
    }

    private void cDX() {
        AppMethodBeat.i(181873);
        if (this.qSJ != null) {
            this.qSJ.cCD();
        }
        AppMethodBeat.o(181873);
    }

    public final void cDY() {
        AppMethodBeat.i(181874);
        if (!mHasInit) {
            AppMethodBeat.o(181874);
            return;
        }
        cDW();
        f(true, 0);
        cEc();
        cEa();
        AppMethodBeat.o(181874);
    }

    public final void I(boolean z, boolean z2) {
        AppMethodBeat.i(181875);
        if (!mHasInit) {
            AppMethodBeat.o(181875);
            return;
        }
        cEc();
        cEa();
        f(true, 50);
        ln(z);
        ll(z2);
        AppMethodBeat.o(181875);
    }

    public final void f(final boolean z, long j2) {
        AppMethodBeat.i(181876);
        if (!mHasInit || this.mHandler == null) {
            AppMethodBeat.o(181876);
            return;
        }
        this.mHandler.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.editor.model.nativenote.c.e.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(181852);
                RecyclerView a2 = e.a(e.this);
                if (a2 == null) {
                    AppMethodBeat.o(181852);
                    return;
                }
                for (int i2 = 0; i2 < a2.getChildCount(); i2++) {
                    View childAt = a2.getChildAt(i2);
                    c dG = f.dG(childAt);
                    if (dG != null) {
                        if (dG.qSl != null) {
                            if (z) {
                                dG.qSl.postInvalidate();
                            }
                        } else if (!(dG.qSm == null || dG.qSn == null)) {
                            e.this.a((LinearLayout) childAt.findViewById(R.id.g7d), (LinearLayout) childAt.findViewById(R.id.g7l), (LinearLayout) childAt.findViewById(R.id.g7g), dG.qSm.getPosInDataList());
                        }
                    }
                }
                AppMethodBeat.o(181852);
            }
        }, j2);
        AppMethodBeat.o(181876);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(View view, View view2, View view3, int i2) {
        AppMethodBeat.i(181877);
        if (!mHasInit || view == null || view2 == null || view3 == null || this.qSK == null) {
            AppMethodBeat.o(181877);
            return;
        }
        switch (FB(i2)) {
            case 0:
                view.setVisibility(8);
                view2.setVisibility(4);
                view3.setVisibility(4);
                AppMethodBeat.o(181877);
                return;
            case 1:
                if (this.qSK.startOffset == this.qSK.qSo) {
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                }
                view2.setVisibility(4);
                view3.setVisibility(4);
                AppMethodBeat.o(181877);
                return;
            case 2:
                view.setVisibility(0);
                view2.setVisibility(0);
                view3.setVisibility(0);
                AppMethodBeat.o(181877);
                return;
            case 3:
                if (this.qSK.qSo != 0) {
                    view.setVisibility(0);
                    view2.setVisibility(0);
                    view3.setVisibility(4);
                    AppMethodBeat.o(181877);
                    return;
                }
                break;
            case 4:
                if (this.qSK.startOffset == 0) {
                    view.setVisibility(0);
                    view2.setVisibility(4);
                    view3.setVisibility(0);
                    AppMethodBeat.o(181877);
                    return;
                }
                view.setVisibility(8);
                view2.setVisibility(4);
                view3.setVisibility(4);
                AppMethodBeat.o(181877);
                return;
        }
        view.setVisibility(8);
        view2.setVisibility(4);
        view3.setVisibility(4);
        AppMethodBeat.o(181877);
    }

    public final boolean cDZ() {
        AppMethodBeat.i(181878);
        if (this.qSI == null || !this.qSI.isShowing()) {
            AppMethodBeat.o(181878);
            return false;
        }
        AppMethodBeat.o(181878);
        return true;
    }

    public final void cEa() {
        AppMethodBeat.i(181879);
        if (this.qSI != null) {
            this.qSI.dismiss();
        }
        AppMethodBeat.o(181879);
    }

    public final void ll(final boolean z) {
        AppMethodBeat.i(181880);
        this.mHandler.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.editor.model.nativenote.c.e.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(181857);
                e.this.lm(z);
                AppMethodBeat.o(181857);
            }
        }, 50);
        AppMethodBeat.o(181880);
    }

    public final void lm(boolean z) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(181881);
        if (!mHasInit || this.qSI == null) {
            AppMethodBeat.o(181881);
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        int selectType = getSelectType();
        if (recyclerView == null || selectType == 0 || ((selectType == 1 && !z) || (this.qSL != null && this.qSL.getType() == 1))) {
            cEa();
            AppMethodBeat.o(181881);
        } else if (!cEj()) {
            cEa();
            AppMethodBeat.o(181881);
        } else {
            int i5 = -1;
            int i6 = -1000;
            int j2 = j(recyclerView);
            int cEg = cEg();
            int i7 = 0;
            int i8 = 0;
            if (!(this.qSI == null || this.qSI.getContentView() == null)) {
                this.qSI.getContentView().measure(0, 0);
                i7 = (this.qSu * 2) + this.qSI.getContentView().getMeasuredHeight();
                i8 = this.qSI.getContentView().getMeasuredWidth() + (this.qSu * 2);
            }
            int i9 = i7 == 0 ? this.qSw : i7;
            if (i8 == 0) {
                i2 = this.qSx;
            } else {
                i2 = i8;
            }
            if (this.qSF == null || !this.qSF.isShowing() || !A(this.qSC)) {
                if (this.qSG != null && this.qSG.isShowing() && A(this.qSD)) {
                    int i10 = this.qSD[1] - i9;
                    int height = (this.qSD[1] + this.qSG.getHeight()) - this.qSy;
                    if (i10 >= j2 && i10 <= cEg) {
                        i6 = this.qSD[0];
                        i5 = i10;
                    } else if (height >= j2 && height <= cEg) {
                        i6 = this.qSD[0];
                        i5 = height;
                    }
                }
                if (this.qSH != null && this.qSH.isShowing() && A(this.qSE)) {
                    i4 = this.qSE[1] - i9;
                    int height2 = (this.qSE[1] + this.qSH.getHeight()) - this.qSy;
                    if (i5 == -1) {
                        if (i4 >= j2 && i4 <= cEg) {
                            i3 = this.qSE[0];
                        } else if (height2 >= j2 && height2 <= cEg) {
                            i3 = this.qSE[0];
                            i4 = height2;
                        }
                    } else if (i5 + i9 > this.qSE[1] && height2 >= j2 && height2 <= cEg) {
                        i3 = this.qSE[0];
                        i4 = height2;
                    }
                }
                i3 = i6;
                i4 = i5;
            } else {
                int i11 = this.qSC[1] - i9;
                i4 = (this.qSC[1] + this.qSF.getHeight()) - this.qSy;
                if (i11 < j2 || i11 > cEg) {
                    if (i4 >= j2 && i4 <= cEg) {
                        i3 = this.qSC[0];
                    }
                    i3 = i6;
                    i4 = i5;
                } else {
                    i3 = this.qSC[0];
                    i4 = i11;
                }
            }
            if (i4 == -1) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (layoutManager instanceof LinearLayoutManager)) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    int ks = linearLayoutManager.ks();
                    int ku = linearLayoutManager.ku();
                    if (this.qSK.bNu <= ks && this.qSK.endPos >= ku) {
                        i4 = 300;
                        i3 = -1000;
                    }
                }
                i3 = -1000;
            }
            if (i4 == -1) {
                cEa();
                AppMethodBeat.o(181881);
                return;
            }
            int i12 = this.mScreenWidth / 3;
            int i13 = (this.mScreenWidth * 2) / 3;
            if (i3 == -1000 || (i3 >= i12 && i3 <= i13)) {
                d(recyclerView, (this.mScreenWidth - i2) / 2, i4);
                AppMethodBeat.o(181881);
            } else if (i3 < i12) {
                d(recyclerView, this.qSv, i4);
                AppMethodBeat.o(181881);
            } else {
                d(recyclerView, (this.mScreenWidth - i2) - this.qSv, i4);
                AppMethodBeat.o(181881);
            }
        }
    }

    public final boolean cEb() {
        AppMethodBeat.i(181882);
        if (this.qSF == null || !this.qSF.isShowing()) {
            AppMethodBeat.o(181882);
            return false;
        }
        AppMethodBeat.o(181882);
        return true;
    }

    public final void cEc() {
        AppMethodBeat.i(181883);
        if (!mHasInit) {
            AppMethodBeat.o(181883);
            return;
        }
        FC(2);
        FC(3);
        FC(4);
        AppMethodBeat.o(181883);
    }

    private boolean FC(int i2) {
        boolean z = true;
        AppMethodBeat.i(181884);
        if (this.qSL != null && this.qSL.qcr == i2 && this.qSL.getType() == 1) {
            AppMethodBeat.o(181884);
            return false;
        }
        if (i2 == 2 && this.qSF != null) {
            this.qSF.dismiss();
            Y(2, -1, -1);
        } else if (i2 == 3 && this.qSG != null) {
            this.qSG.dismiss();
            Y(3, -1, -1);
        } else if (i2 != 4 || this.qSH == null) {
            z = false;
        } else {
            this.qSH.dismiss();
            Y(4, -1, -1);
        }
        AppMethodBeat.o(181884);
        return z;
    }

    public final void ln(boolean z) {
        AppMethodBeat.i(181885);
        if (!mHasInit) {
            AppMethodBeat.o(181885);
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        int selectType = getSelectType();
        if (recyclerView == null || selectType == 0 || (selectType == 1 && !z)) {
            cEc();
            AppMethodBeat.o(181885);
            return;
        }
        View d2 = f.d(recyclerView, this.qSK.bNu);
        View d3 = f.d(recyclerView, this.qSK.endPos);
        if (selectType == 1) {
            FC(3);
            FC(4);
            a(2, recyclerView, d2, this.qSK.startOffset);
            AppMethodBeat.o(181885);
            return;
        }
        FC(2);
        a(3, recyclerView, d2, this.qSK.startOffset);
        a(4, recyclerView, d3, this.qSK.qSo);
        AppMethodBeat.o(181885);
    }

    private void a(int i2, RecyclerView recyclerView, View view, int i3) {
        WXRTEditText wXRTEditText;
        boolean a2;
        AppMethodBeat.i(181886);
        if (!mHasInit || recyclerView == null) {
            AppMethodBeat.o(181886);
            return;
        }
        c dG = f.dG(view);
        if (dG == null) {
            FC(i2);
            AppMethodBeat.o(181886);
            return;
        }
        if (dG.qSl != null) {
            wXRTEditText = dG.qSl;
        } else {
            if (!(dG.qSm == null || dG.qSn == null)) {
                if (i3 == 0) {
                    i3 = 0;
                    wXRTEditText = dG.qSm;
                } else if (i3 == 1) {
                    i3 = 0;
                    wXRTEditText = dG.qSn;
                }
            }
            wXRTEditText = null;
        }
        if (wXRTEditText == null) {
            FC(i2);
            AppMethodBeat.o(181886);
            return;
        }
        Editable text = wXRTEditText.getText();
        if (text == null || i3 < 0 || i3 > text.length()) {
            FC(i2);
            AppMethodBeat.o(181886);
            return;
        }
        Layout layout = wXRTEditText.getLayout();
        if (layout == null) {
            FC(i2);
            AppMethodBeat.o(181886);
            return;
        }
        float primaryHorizontal = layout.getPrimaryHorizontal(i3) + ((float) wXRTEditText.getPaddingLeft());
        float lineTop = (float) (layout.getLineTop(layout.getLineForOffset(i3)) + wXRTEditText.getPaddingTop());
        if (wXRTEditText.getEditTextType() != 0) {
            lineTop = (lineTop + ((float) wXRTEditText.getHeight())) - ((float) this.qSr);
            if (i2 == 3) {
                primaryHorizontal += (float) this.qSA;
            } else if (i2 == 4) {
                primaryHorizontal -= (float) this.qSA;
            }
        }
        int[] iArr = new int[2];
        wXRTEditText.getLocationOnScreen(iArr);
        switch (i2) {
            case 2:
                a2 = a(2, recyclerView, this.qSF, (int) ((primaryHorizontal + ((float) iArr[0])) - ((float) this.qSz)), (int) (((float) iArr[1]) + lineTop));
                break;
            case 3:
                a2 = a(3, recyclerView, this.qSG, (int) ((primaryHorizontal + ((float) iArr[0])) - ((float) this.qSG.getWidth())), (int) (((float) iArr[1]) + lineTop));
                break;
            case 4:
                a2 = a(4, recyclerView, this.qSH, (int) (primaryHorizontal + ((float) iArr[0])), (int) (((float) iArr[1]) + lineTop));
                break;
            default:
                a2 = false;
                break;
        }
        if (!a2) {
            FC(i2);
        }
        AppMethodBeat.o(181886);
    }

    private boolean a(int i2, RecyclerView recyclerView, PopupWindow popupWindow, int i3, int i4) {
        AppMethodBeat.i(181887);
        if (!mHasInit || recyclerView == null || popupWindow == null) {
            AppMethodBeat.o(181887);
            return false;
        } else if (i4 < j(recyclerView) || i4 > this.mScreenHeight - cDU()) {
            AppMethodBeat.o(181887);
            return false;
        } else {
            if (popupWindow.isShowing()) {
                popupWindow.update(i3, i4, -1, -1, false);
                Y(i2, i3, i4);
            } else {
                popupWindow.showAtLocation(recyclerView, 0, i3, i4);
                Y(i2, i3, i4);
            }
            if (i2 == 2) {
                cEd();
                this.qSN.startTimer(3000, 0);
            }
            AppMethodBeat.o(181887);
            return true;
        }
    }

    private void cEd() {
        AppMethodBeat.i(181888);
        if (this.qSN == null) {
            this.qSN = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.editor.model.nativenote.c.e.AnonymousClass7 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(181858);
                    if (e.this.getSelectType() == 1 && e.b(e.this)) {
                        e.this.cEa();
                    }
                    AppMethodBeat.o(181858);
                    return true;
                }
            }, false);
            AppMethodBeat.o(181888);
            return;
        }
        this.qSN.stopTimer();
        AppMethodBeat.o(181888);
    }

    private boolean d(RecyclerView recyclerView, int i2, int i3) {
        AppMethodBeat.i(181889);
        if (!mHasInit || recyclerView == null || this.qSI == null) {
            AppMethodBeat.o(181889);
            return false;
        } else if (i3 < j(recyclerView) || i3 > this.mScreenHeight - cDU()) {
            AppMethodBeat.o(181889);
            return false;
        } else {
            if (this.qSI.isShowing()) {
                this.qSI.update(i2, i3, -1, -1, false);
            } else {
                this.qSI.showAtLocation(recyclerView, 0, i2, i3);
            }
            AppMethodBeat.o(181889);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.c.a.AbstractC0950a
    public final void a(int i2, MotionEvent motionEvent) {
        AppMethodBeat.i(181890);
        if (!mHasInit || this.mHandler == null) {
            AppMethodBeat.o(181890);
        } else if (this.qSL == null || this.qSL.getType() != 1 || this.qSL.qcr == i2) {
            switch (motionEvent.getAction()) {
                case 0:
                    cEe();
                    if (!cDZ()) {
                        lm(true);
                    }
                    this.qSL.a(i2, motionEvent.getRawX(), motionEvent.getRawY(), motionEvent.getX(), motionEvent.getY(), 0);
                    AppMethodBeat.o(181890);
                    return;
                case 1:
                case 3:
                    cEe();
                    this.mHandler.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.editor.model.nativenote.c.e.AnonymousClass8 */

                        public final void run() {
                            AppMethodBeat.i(181859);
                            e.this.ln(true);
                            e.this.lm(true);
                            AppMethodBeat.o(181859);
                        }
                    }, 200);
                    break;
                case 2:
                    if (this.qSL != null && this.qSL.getType() == 1) {
                        this.qSL.qSd = motionEvent.getRawX();
                        this.qSL.qSe = motionEvent.getRawY();
                        lo(true);
                        AppMethodBeat.o(181890);
                        return;
                    }
            }
            AppMethodBeat.o(181890);
        } else {
            AppMethodBeat.o(181890);
        }
    }

    private void lo(boolean z) {
        int i2;
        WXRTEditText wXRTEditText;
        int i3;
        int i4;
        boolean z2;
        AppMethodBeat.i(181891);
        if (!mHasInit || this.qSF == null || this.qSG == null || this.qSH == null || this.qSK == null) {
            AppMethodBeat.o(181891);
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null) {
            AppMethodBeat.o(181891);
        } else if (this.qSL == null || this.qSL.getType() != 1) {
            AppMethodBeat.o(181891);
        } else {
            int i5 = this.qSL.qcr;
            if (i5 == 2 || i5 == 3 || i5 == 4) {
                float f2 = this.qSL.qSd - this.qSL.deo;
                float f3 = ((float) (this.qSr / 2)) + (this.qSL.qSe - this.qSL.dep);
                if (i5 == 2) {
                    f2 += (float) (this.qSF.getWidth() / 2);
                } else if (i5 == 3) {
                    f2 += (float) this.qSG.getWidth();
                }
                recyclerView.getLocationOnScreen(this.qSB);
                View o = recyclerView.o(f2 - ((float) this.qSB[0]), f3 - ((float) this.qSB[1]));
                c dG = f.dG(o);
                WXRTEditText wXRTEditText2 = null;
                if (dG == null) {
                    i2 = 2;
                } else if (dG.qSl != null) {
                    wXRTEditText2 = dG.qSl;
                    int[] iArr = new int[2];
                    wXRTEditText2.getLocationOnScreen(iArr);
                    i2 = Z(i5, wXRTEditText2.getPosInDataList(), wXRTEditText2.getOffsetForPosition(f2 - ((float) iArr[0]), f3 - ((float) iArr[1])));
                } else if (dG.qSm == null || dG.qSn == null) {
                    i2 = 0;
                } else {
                    if (i5 == 3) {
                        wXRTEditText = dG.qSm;
                        i3 = Z(i5, wXRTEditText.getPosInDataList(), 0);
                        if (i3 == 2 || i3 == 3) {
                            a(i5, recyclerView, this.qSG, (int) (this.qSL.qSd - this.qSL.deo), (int) (this.qSL.qSe - this.qSL.dep));
                            i2 = i3;
                            wXRTEditText2 = wXRTEditText;
                        }
                    } else if (i5 == 4) {
                        wXRTEditText = dG.qSn;
                        i3 = Z(i5, wXRTEditText.getPosInDataList(), 1);
                        if (i3 == 2 || i3 == 3) {
                            a(i5, recyclerView, this.qSH, (int) (this.qSL.qSd - this.qSL.deo), (int) (this.qSL.qSe - this.qSL.dep));
                            i2 = i3;
                            wXRTEditText2 = wXRTEditText;
                        }
                    } else {
                        int[] iArr2 = new int[2];
                        o.getLocationOnScreen(iArr2);
                        if (f2 <= ((float) (iArr2[0] + (o.getWidth() / 2)))) {
                            wXRTEditText = dG.qSm;
                            i3 = Z(i5, wXRTEditText.getPosInDataList(), 0);
                        } else {
                            wXRTEditText = dG.qSn;
                            i3 = Z(i5, wXRTEditText.getPosInDataList(), 1);
                        }
                        if (i3 == 2 || i3 == 3) {
                            a(i5, recyclerView, this.qSF, (int) (this.qSL.qSd - this.qSL.deo), (int) (this.qSL.qSe - this.qSL.dep));
                        }
                    }
                    i2 = i3;
                    wXRTEditText2 = wXRTEditText;
                }
                switch (i2) {
                    case 1:
                        z2 = false;
                        break;
                    case 2:
                        z2 = true;
                        break;
                    case 3:
                        Editable text = wXRTEditText2.getText();
                        int selectType = getSelectType();
                        if (this.qSq && text != null && selectType == 1) {
                            if (!wXRTEditText2.hasFocus()) {
                                wXRTEditText2.requestFocus();
                            }
                            if (wXRTEditText2.getEditTextType() == 1 || wXRTEditText2.getEditTextType() == 2) {
                                wXRTEditText2.setIgnoreSelectChangeByMultiSelect(true);
                                wXRTEditText2.setSelection(0);
                                wXRTEditText2.setIgnoreSelectChangeByMultiSelect(false);
                            } else if (this.qSK.startOffset <= text.length()) {
                                wXRTEditText2.setIgnoreSelectChangeByMultiSelect(true);
                                wXRTEditText2.setSelection(this.qSK.startOffset);
                                wXRTEditText2.setIgnoreSelectChangeByMultiSelect(false);
                            }
                        } else if (this.qSq && text != null && selectType == 2 && wXRTEditText2.hasFocus()) {
                            if (wXRTEditText2.getEditTextType() == 1 || wXRTEditText2.getEditTextType() == 2) {
                                wXRTEditText2.setIgnoreSelectChangeByMultiSelect(true);
                                wXRTEditText2.setSelection(0);
                                wXRTEditText2.setIgnoreSelectChangeByMultiSelect(false);
                            } else if (this.qSK.startOffset <= text.length() && this.qSK.qSo <= text.length()) {
                                wXRTEditText2.setIgnoreSelectChangeByMultiSelect(true);
                                wXRTEditText2.setSelection(this.qSK.startOffset, this.qSK.qSo);
                                wXRTEditText2.setIgnoreSelectChangeByMultiSelect(false);
                            }
                        }
                        if (selectType == 3 || selectType == 0) {
                            cDX();
                        }
                        cEa();
                        f(true, 0);
                        if (i5 == 4) {
                            i4 = this.qSK.qSo;
                        } else {
                            i4 = this.qSK.startOffset;
                        }
                        a(i5, recyclerView, o, i4);
                        z2 = true;
                        break;
                    default:
                        AppMethodBeat.o(181891);
                        return;
                }
                if (!z2) {
                    cEf();
                } else if (z && ((this.qSL.qSe < ((float) j(recyclerView)) || this.qSL.qSe > ((float) cEg())) && (this.qSM == null || this.qSM.stopped()))) {
                    cEf();
                    this.qSM.startTimer(100);
                    AppMethodBeat.o(181891);
                    return;
                }
                AppMethodBeat.o(181891);
                return;
            }
            AppMethodBeat.o(181891);
        }
    }

    private int Z(int i2, int i3, int i4) {
        boolean B;
        AppMethodBeat.i(181892);
        if (!mHasInit) {
            AppMethodBeat.o(181892);
            return 0;
        }
        switch (i2) {
            case 2:
                B = B(i3, i4, i3, i4);
                break;
            case 3:
                if (this.qSK != null && i3 <= this.qSK.endPos && (i3 != this.qSK.endPos || i4 < this.qSK.qSo)) {
                    B = B(i3, i4, this.qSK.endPos, this.qSK.qSo);
                    break;
                } else {
                    AppMethodBeat.o(181892);
                    return 1;
                }
                break;
            case 4:
                if (this.qSK != null && i3 >= this.qSK.bNu && (i3 != this.qSK.bNu || i4 > this.qSK.startOffset)) {
                    B = B(this.qSK.bNu, this.qSK.startOffset, i3, i4);
                    break;
                } else {
                    AppMethodBeat.o(181892);
                    return 1;
                }
            default:
                AppMethodBeat.o(181892);
                return 0;
        }
        if (B) {
            AppMethodBeat.o(181892);
            return 3;
        }
        AppMethodBeat.o(181892);
        return 2;
    }

    private void cEe() {
        AppMethodBeat.i(181893);
        if (this.qSL == null) {
            this.qSL = new b();
            AppMethodBeat.o(181893);
            return;
        }
        this.qSL.reset();
        AppMethodBeat.o(181893);
    }

    private void cEf() {
        AppMethodBeat.i(181894);
        if (this.qSM == null) {
            this.qSM = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.editor.model.nativenote.c.e.AnonymousClass9 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    boolean z;
                    AppMethodBeat.i(181860);
                    Log.d("EditorSelectManager", "onTimerExpired: ");
                    RecyclerView a2 = e.a(e.this);
                    boolean z2 = e.this.qSL != null && e.this.qSL.qSe < ((float) e.a(e.this, a2));
                    if (e.this.qSL == null || e.this.qSL.qSe <= ((float) e.d(e.this))) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!e.mHasInit || a2 == null || e.this.qSL == null || e.this.qSL.getType() != 1 || (!z2 && !z)) {
                        if (e.this.qSM != null) {
                            e.this.qSM.stopTimer();
                        }
                    } else if (z2 && a2.canScrollVertically(-1)) {
                        if (e.this.qSL.qcr == 3) {
                            e.e(e.this);
                        }
                        e.f(e.this);
                        e.this.cEc();
                        e.this.cEa();
                        a2.a(0, -300, (Interpolator) null);
                    } else if (z && a2.canScrollVertically(1)) {
                        e.f(e.this);
                        e.this.cEc();
                        e.this.cEa();
                        a2.a(0, 300, (Interpolator) null);
                    }
                    AppMethodBeat.o(181860);
                    return true;
                }
            }, true);
            AppMethodBeat.o(181894);
            return;
        }
        this.qSM.stopTimer();
        AppMethodBeat.o(181894);
    }

    private int j(RecyclerView recyclerView) {
        AppMethodBeat.i(181895);
        int i2 = 150;
        if (recyclerView != null) {
            recyclerView.getLocationOnScreen(this.qSB);
            if (A(this.qSB)) {
                i2 = this.qSB[1];
            }
        }
        AppMethodBeat.o(181895);
        return i2;
    }

    private int cEg() {
        AppMethodBeat.i(181896);
        int i2 = 0;
        if (this.qSJ != null) {
            i2 = this.qSJ.cCE();
        }
        if (i2 == 0 && this.qSJ != null) {
            i2 = this.qSJ.cCF();
        }
        if (i2 == 0) {
            i2 = 150;
        }
        int i3 = this.mScreenHeight - i2;
        AppMethodBeat.o(181896);
        return i3;
    }

    public static void i(TextView textView, int i2) {
        AppMethodBeat.i(181897);
        if (textView != null) {
            textView.setTextSize(1, (float) i2);
        }
        AppMethodBeat.o(181897);
    }

    private void cEh() {
        AppMethodBeat.i(181898);
        if (this.qSJ != null) {
            this.qSJ.cCC();
        }
        AppMethodBeat.o(181898);
    }

    public final void cEi() {
        AppMethodBeat.i(181899);
        Log.i("EditorSelectManager", "deleteSelectedData");
        if (!mHasInit) {
            Log.e("EditorSelectManager", "deleteSelectedData: not init");
            AppMethodBeat.o(181899);
            return;
        }
        cEa();
        int selectType = getSelectType();
        if (selectType == 2) {
            a(true, (ArrayList<com.tencent.mm.plugin.editor.model.a.a>) null, "");
            AppMethodBeat.o(181899);
        } else if (selectType == 3) {
            b(true, null, "");
            AppMethodBeat.o(181899);
        } else {
            Log.e("EditorSelectManager", "deleteSelectedData: not in select");
            cEh();
            AppMethodBeat.o(181899);
        }
    }

    private SpannableStringBuilder a(boolean z, ArrayList<com.tencent.mm.plugin.editor.model.a.a> arrayList, String str) {
        SpannableStringBuilder spannableStringBuilder;
        ArrayList<com.tencent.mm.plugin.editor.model.a.a> arrayList2;
        int i2 = 2;
        AppMethodBeat.i(181900);
        d cDV = cDV();
        cDY();
        int selectType = cDV.getSelectType();
        if (selectType == 1 || selectType == 2) {
            com.tencent.mm.plugin.editor.model.a.a Fw = c.cDo().Fw(cDV.bNu);
            if (Fw == null) {
                Log.e("EditorSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
                AppMethodBeat.o(181900);
                return null;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (Fw.getType() != 1) {
                if (selectType == 1 && z) {
                    if (cDV.startOffset == 0) {
                        i2 = 1;
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        arrayList2 = arrayList;
                    } else if (!Util.isNullOrNil(str)) {
                        arrayList2 = new ArrayList<>();
                        j jVar = new j();
                        jVar.content = str;
                        jVar.qPA = false;
                        jVar.qPC = -1;
                        arrayList2.add(jVar);
                    } else {
                        AppMethodBeat.o(181900);
                        return spannableStringBuilder2;
                    }
                    c.cDo().a(arrayList2, i2, cDV.bNu, cDV.startOffset, cDV.qSo);
                    c.cDo().fx(cDV.bNu - 1, arrayList2.size() + cDV.bNu + 1);
                }
                spannableStringBuilder = spannableStringBuilder2;
            } else if (!z || arrayList == null || arrayList.size() <= 0) {
                spannableStringBuilder = a((j) Fw, cDV.startOffset, cDV.qSo, false, z, str, true);
                if (this.qSJ != null) {
                    this.qSJ.Fr(cDV.bNu);
                }
                if (z) {
                    c.cDo().cDy();
                }
            } else {
                spannableStringBuilder = a((j) Fw, cDV.startOffset, cDV.qSo, false, false, "", true);
                c.cDo().a(arrayList, 0, cDV.bNu, cDV.startOffset, cDV.qSo);
                c.cDo().fx(cDV.bNu, cDV.bNu + arrayList.size() + 1);
            }
            AppMethodBeat.o(181900);
            return spannableStringBuilder;
        }
        Log.e("EditorSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
        AppMethodBeat.o(181900);
        return null;
    }

    private ArrayList<com.tencent.mm.plugin.editor.model.a.a> b(boolean z, ArrayList<com.tencent.mm.plugin.editor.model.a.a> arrayList, String str) {
        int i2;
        AppMethodBeat.i(181901);
        d cDV = cDV();
        cDY();
        ArrayList<com.tencent.mm.plugin.editor.model.a.a> arrayList2 = new ArrayList<>();
        if (cDV.getSelectType() != 3) {
            Log.e("EditorSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
            AppMethodBeat.o(181901);
            return null;
        }
        int i3 = cDV.bNu;
        int i4 = cDV.endPos;
        while (true) {
            i2 = i3;
            if (i4 < cDV.bNu) {
                break;
            }
            com.tencent.mm.plugin.editor.model.a.a Fw = c.cDo().Fw(i4);
            if (Fw != null) {
                if (i4 == cDV.endPos && Fw.getType() == 1) {
                    j jVar = (j) Fw;
                    SpannableStringBuilder a2 = a(jVar, 0, cDV.qSo, false, z, "", false);
                    if (!Util.isNullOrNil(a2)) {
                        j jVar2 = new j();
                        jVar2.content = b.a(a2);
                        jVar2.qPC = -1;
                        jVar2.qPA = false;
                        arrayList2.add(jVar2);
                    }
                    if (z && Util.isNullOrNil(jVar.content)) {
                        c.cDo().ae(i4, true);
                    }
                } else if (i4 == cDV.bNu && Fw.getType() == 1) {
                    j jVar3 = (j) Fw;
                    SpannableStringBuilder a3 = a(jVar3, cDV.startOffset, 0, true, z, "", false);
                    if (!Util.isNullOrNil(a3)) {
                        j jVar4 = new j();
                        jVar4.content = b.a(a3);
                        jVar4.qPC = -1;
                        jVar4.qPA = false;
                        arrayList2.add(jVar4);
                    }
                    if (!z || !Util.isNullOrNil(jVar3.content)) {
                        i2++;
                    } else {
                        c.cDo().ae(i4, true);
                    }
                } else {
                    arrayList2.add(com.tencent.mm.plugin.editor.b.a(Fw));
                    if (z) {
                        c.cDo().ae(i4, true);
                    }
                }
            }
            i3 = i2;
            i4--;
        }
        if (z) {
            int i5 = i2 - 1;
            int i6 = i2 + 1;
            if (arrayList == null || arrayList.size() <= 0) {
                j jVar5 = new j();
                if (str == null) {
                    str = "";
                }
                jVar5.content = str;
                jVar5.qPA = false;
                jVar5.qPC = -1;
                c.cDo().a(i2, jVar5);
            } else {
                c.cDo().b(i2, arrayList);
                i6 = arrayList.size() + i2;
            }
            c.cDo().fx(i5, i6);
        }
        Collections.reverse(arrayList2);
        AppMethodBeat.o(181901);
        return arrayList2;
    }

    private static SpannableStringBuilder a(j jVar, int i2, int i3, boolean z, boolean z2, String str, boolean z3) {
        int i4;
        Spanned alS;
        SpannableStringBuilder spannableStringBuilder = null;
        AppMethodBeat.i(181902);
        if (jVar == null) {
            Log.e("EditorSelectManager", "processTextDataItem: textDataItem is null");
            AppMethodBeat.o(181902);
        } else {
            Spanned alS2 = com.tencent.mm.plugin.editor.model.nativenote.a.a.alS(jVar.content);
            if (alS2 == null) {
                Log.e("EditorSelectManager", "processTextDataItem: spannedText is null");
                AppMethodBeat.o(181902);
            } else {
                if (z) {
                    i4 = alS2.length();
                } else {
                    i4 = i3;
                }
                if (str == null) {
                    str = "";
                }
                if (i2 < 0 || i2 > alS2.length() || i4 < 0 || i4 > alS2.length() || i2 > i4) {
                    Log.e("EditorSelectManager", "processTextDataItem: incorrect offset");
                    AppMethodBeat.o(181902);
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) alS2.subSequence(0, i2);
                    spannableStringBuilder = (SpannableStringBuilder) alS2.subSequence(i2, i4);
                    SpannableStringBuilder spannableStringBuilder3 = (SpannableStringBuilder) alS2.subSequence(i4, alS2.length());
                    if (z2) {
                        i4 = spannableStringBuilder2.length();
                        if (!Util.isNullOrNil(str) && (alS = com.tencent.mm.plugin.editor.model.nativenote.a.a.alS(str)) != null) {
                            i4 += alS.length();
                        }
                        jVar.content = b.a(spannableStringBuilder2) + str + b.a(spannableStringBuilder3);
                    }
                    if (z3) {
                        jVar.qPA = true;
                        jVar.qPC = i4;
                    } else {
                        jVar.qPA = false;
                        jVar.qPC = -1;
                    }
                    AppMethodBeat.o(181902);
                }
            }
        }
        return spannableStringBuilder;
    }

    private boolean cEj() {
        AppMethodBeat.i(181903);
        boolean o = o(this.qSO, false);
        boolean o2 = o(this.qSP, false);
        boolean o3 = o(this.qSQ, cEk());
        boolean o4 = o(this.qSR, cEl());
        boolean o5 = o(this.qSS, cEm());
        boolean o6 = o(this.qST, cEn());
        boolean o7 = o(this.qSU, cEo());
        boolean o8 = o(this.qSV, cEp());
        if (o || o2 || o3 || o4 || o5 || o6 || o7 || o8) {
            AppMethodBeat.o(181903);
            return true;
        }
        AppMethodBeat.o(181903);
        return false;
    }

    private static boolean o(View view, boolean z) {
        AppMethodBeat.i(181904);
        if (view == null) {
            AppMethodBeat.o(181904);
            return false;
        } else if (z) {
            view.setVisibility(0);
            AppMethodBeat.o(181904);
            return true;
        } else {
            view.setVisibility(8);
            AppMethodBeat.o(181904);
            return false;
        }
    }

    private boolean cEk() {
        AppMethodBeat.i(181905);
        if (getSelectType() != 1) {
            AppMethodBeat.o(181905);
            return false;
        }
        com.tencent.mm.plugin.editor.model.a.a Fw = c.cDo().Fw(this.qSK.bNu);
        if (Fw == null || (c.cDo().size() <= 1 && Fw.getType() == 1 && Util.isNullOrNil(((j) Fw).content))) {
            AppMethodBeat.o(181905);
            return false;
        }
        AppMethodBeat.o(181905);
        return true;
    }

    private boolean cEl() {
        AppMethodBeat.i(181906);
        int cDz = c.cDo().cDz();
        int cDA = c.cDo().cDA();
        com.tencent.mm.plugin.editor.model.a.a Fw = c.cDo().Fw(cDz);
        com.tencent.mm.plugin.editor.model.a.a Fw2 = c.cDo().Fw(cDA);
        if (Fw == null || Fw2 == null) {
            AppMethodBeat.o(181906);
            return false;
        }
        if (this.qSK != null && this.qSK.bNu == cDz && this.qSK.startOffset == 0 && this.qSK.endPos == cDA) {
            if (Fw2.getType() == 1) {
                Spanned alS = com.tencent.mm.plugin.editor.model.nativenote.a.a.alS(((j) Fw2).content);
                if (alS == null) {
                    AppMethodBeat.o(181906);
                    return false;
                } else if (this.qSK.qSo == alS.length()) {
                    AppMethodBeat.o(181906);
                    return false;
                }
            } else if (Fw2.getType() != 1 && this.qSK.qSo == 1) {
                AppMethodBeat.o(181906);
                return false;
            }
        }
        AppMethodBeat.o(181906);
        return true;
    }

    private boolean cEm() {
        boolean z = true;
        AppMethodBeat.i(181907);
        if (!this.qSq) {
            AppMethodBeat.o(181907);
            return false;
        }
        int selectType = getSelectType();
        if (selectType == 0 || selectType == 1) {
            AppMethodBeat.o(181907);
            return false;
        }
        if (this.qSJ != null && this.qSJ.cCG()) {
            z = false;
        }
        AppMethodBeat.o(181907);
        return z;
    }

    private boolean cEn() {
        AppMethodBeat.i(181908);
        int selectType = getSelectType();
        if (!this.qSq || !(selectType == 2 || selectType == 3)) {
            AppMethodBeat.o(181908);
            return false;
        }
        AppMethodBeat.o(181908);
        return true;
    }

    private boolean cEo() {
        AppMethodBeat.i(181909);
        int selectType = getSelectType();
        if (selectType == 2 || selectType == 3) {
            AppMethodBeat.o(181909);
            return true;
        }
        AppMethodBeat.o(181909);
        return false;
    }

    private boolean cEp() {
        AppMethodBeat.i(181910);
        if (!this.qSq || getSelectType() == 0) {
            AppMethodBeat.o(181910);
            return false;
        }
        MMApplicationContext.getContext();
        if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.cDn() != 1) {
            AppMethodBeat.o(181910);
            return true;
        }
        AppMethodBeat.o(181910);
        return false;
    }

    static /* synthetic */ void j(e eVar) {
        AppMethodBeat.i(181918);
        eVar.f(true, 300);
        AppMethodBeat.o(181918);
    }

    static /* synthetic */ boolean l(e eVar) {
        AppMethodBeat.i(181919);
        if (eVar.getSelectType() == 3) {
            for (int i2 = eVar.qSK.bNu; i2 <= eVar.qSK.endPos; i2++) {
                com.tencent.mm.plugin.editor.model.a.a Fw = c.cDo().Fw(i2);
                if (Fw != null && Fw.getType() == 4 && ((m) Fw).qPX.booleanValue()) {
                    AppMethodBeat.o(181919);
                    return true;
                }
            }
        }
        AppMethodBeat.o(181919);
        return false;
    }

    static /* synthetic */ boolean a(e eVar, ArrayList arrayList, String str) {
        int i2;
        int i3;
        int alJ;
        AppMethodBeat.i(181922);
        int selectType = eVar.getSelectType();
        if (selectType == 0) {
            AppMethodBeat.o(181922);
            return false;
        }
        StringBuilder sb = new StringBuilder(str);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            i2 = 0;
            while (it.hasNext()) {
                com.tencent.mm.plugin.editor.model.a.a aVar = (com.tencent.mm.plugin.editor.model.a.a) it.next();
                if (aVar != null) {
                    if (aVar.getType() != 1) {
                        i2++;
                    } else {
                        sb.append(((j) aVar).content);
                    }
                }
            }
        } else {
            i2 = 0;
        }
        int alJ2 = com.tencent.mm.plugin.editor.b.alJ(sb.toString());
        if (selectType == 2 || selectType == 3) {
            int i4 = eVar.qSK.bNu;
            while (i4 <= eVar.qSK.endPos) {
                com.tencent.mm.plugin.editor.model.a.a Fw = c.cDo().Fw(i4);
                if (Fw != null) {
                    if (Fw.getType() == 1) {
                        if (i4 == eVar.qSK.bNu && i4 == eVar.qSK.endPos) {
                            alJ = com.tencent.mm.plugin.editor.b.b(((j) Fw).content, eVar.qSK.startOffset, eVar.qSK.qSo, false) + 0;
                        } else if (i4 == eVar.qSK.bNu) {
                            alJ = com.tencent.mm.plugin.editor.b.b(((j) Fw).content, eVar.qSK.startOffset, -1, true) + 0;
                        } else if (i4 == eVar.qSK.endPos) {
                            alJ = com.tencent.mm.plugin.editor.b.b(((j) Fw).content, 0, eVar.qSK.qSo, false) + 0;
                        } else {
                            alJ = com.tencent.mm.plugin.editor.b.alJ(((j) Fw).content) + 0;
                        }
                        alJ2 -= alJ;
                        i3 = i2;
                    } else if (Fw.getType() != 1) {
                        i3 = i2 - 1;
                    }
                    i4++;
                    i2 = i3;
                }
                i3 = i2;
                i4++;
                i2 = i3;
            }
        }
        boolean fw = c.cDo().fw(alJ2, i2);
        AppMethodBeat.o(181922);
        return fw;
    }
}
