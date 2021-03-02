package com.tencent.mm.plugin.wenote.model.nativenote.c;

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
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.c.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public final class e implements a.AbstractC2006a {
    private static volatile e JIP = null;
    public static boolean mHasInit = false;
    public com.tencent.mm.plugin.wenote.model.nativenote.b.a JIQ = null;
    public d JIR = null;
    public b JIS = null;
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
    private MTimerHandler qSM = null;
    private MTimerHandler qSN = null;
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
        AppMethodBeat.i(30612);
        int j2 = eVar.j(recyclerView);
        AppMethodBeat.o(30612);
        return j2;
    }

    static /* synthetic */ RecyclerView a(e eVar) {
        AppMethodBeat.i(30610);
        RecyclerView recyclerView = eVar.getRecyclerView();
        AppMethodBeat.o(30610);
        return recyclerView;
    }

    static /* synthetic */ SpannableStringBuilder a(e eVar, boolean z, ArrayList arrayList, String str) {
        AppMethodBeat.i(30619);
        SpannableStringBuilder a2 = eVar.a(z, arrayList, str);
        AppMethodBeat.o(30619);
        return a2;
    }

    static /* synthetic */ ArrayList b(e eVar, boolean z, ArrayList arrayList, String str) {
        AppMethodBeat.i(30620);
        ArrayList<c> b2 = eVar.b(z, arrayList, str);
        AppMethodBeat.o(30620);
        return b2;
    }

    static /* synthetic */ boolean b(e eVar) {
        AppMethodBeat.i(30611);
        boolean FC = eVar.FC(2);
        AppMethodBeat.o(30611);
        return FC;
    }

    static /* synthetic */ int d(e eVar) {
        AppMethodBeat.i(30613);
        int cEg = eVar.cEg();
        AppMethodBeat.o(30613);
        return cEg;
    }

    static /* synthetic */ void e(e eVar) {
        AppMethodBeat.i(30614);
        eVar.cDX();
        AppMethodBeat.o(30614);
    }

    static /* synthetic */ void f(e eVar) {
        AppMethodBeat.i(30615);
        eVar.lo(false);
        AppMethodBeat.o(30615);
    }

    static /* synthetic */ void h(e eVar) {
        AppMethodBeat.i(30616);
        eVar.cEh();
        AppMethodBeat.o(30616);
    }

    private e() {
        mHasInit = false;
    }

    public static e gjW() {
        AppMethodBeat.i(30565);
        if (JIP == null) {
            synchronized (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.class) {
                try {
                    if (JIP == null) {
                        JIP = new e();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(30565);
                    throw th;
                }
            }
        }
        e eVar = JIP;
        AppMethodBeat.o(30565);
        return eVar;
    }

    public final void onDestroy() {
        AppMethodBeat.i(179746);
        Log.i("NoteSelectManager", "onDestroy");
        mHasInit = false;
        if (this.qSM != null) {
            this.qSM.stopTimer();
        }
        if (this.qSN != null) {
            this.qSN.stopTimer();
        }
        if (this.qSF != null) {
            this.qSF.dismiss();
        }
        if (this.qSG != null) {
            this.qSG.dismiss();
        }
        if (this.qSH != null) {
            this.qSH.dismiss();
        }
        if (this.qSI != null) {
            this.qSI.dismiss();
        }
        JIP = null;
        AppMethodBeat.o(179746);
    }

    public static boolean isEnabled() {
        return mHasInit;
    }

    public final boolean isEditable() {
        return mHasInit && this.qSq;
    }

    private RecyclerView getRecyclerView() {
        AppMethodBeat.i(30566);
        if (this.JIQ != null) {
            RecyclerView cCH = this.JIQ.cCH();
            AppMethodBeat.o(30566);
            return cCH;
        }
        AppMethodBeat.o(30566);
        return null;
    }

    private int cDU() {
        AppMethodBeat.i(30567);
        if (this.JIQ != null) {
            int cCE = this.JIQ.cCE() + this.JIQ.cCF();
            AppMethodBeat.o(30567);
            return cCE;
        }
        AppMethodBeat.o(30567);
        return 0;
    }

    public final int getSelectType() {
        AppMethodBeat.i(30568);
        if (!mHasInit) {
            AppMethodBeat.o(30568);
            return 0;
        }
        if (this.JIR == null) {
            this.JIR = new d();
        }
        int selectType = this.JIR.getSelectType();
        AppMethodBeat.o(30568);
        return selectType;
    }

    public final d gjX() {
        AppMethodBeat.i(30569);
        if (!mHasInit) {
            d dVar = new d();
            AppMethodBeat.o(30569);
            return dVar;
        }
        if (this.JIR == null) {
            this.JIR = new d();
        }
        d dVar2 = new d(this.JIR.bNu, this.JIR.startOffset, this.JIR.endPos, this.JIR.qSo);
        AppMethodBeat.o(30569);
        return dVar2;
    }

    public final boolean B(int i2, int i3, int i4, int i5) {
        boolean z;
        AppMethodBeat.i(30570);
        if (!mHasInit) {
            AppMethodBeat.o(30570);
            return false;
        }
        if (this.JIR == null) {
            this.JIR = new d(i2, i3, i4, i5);
            z = true;
        } else if (this.JIR.bNu == i2 && this.JIR.startOffset == i3 && this.JIR.endPos == i4 && this.JIR.qSo == i5) {
            z = false;
        } else {
            this.JIR.set(i2, i3, i4, i5);
            z = true;
        }
        if (z) {
            Log.d("NoteSelectManager", "setSelectInfo: %d:%d - %d:%d", Integer.valueOf(this.JIR.bNu), Integer.valueOf(this.JIR.startOffset), Integer.valueOf(this.JIR.endPos), Integer.valueOf(this.JIR.qSo));
        }
        AppMethodBeat.o(30570);
        return z;
    }

    public final int FB(int i2) {
        AppMethodBeat.i(30571);
        if (!mHasInit || this.JIR == null) {
            AppMethodBeat.o(30571);
            return 0;
        } else if (getSelectType() == 0 || i2 < this.JIR.bNu || i2 > this.JIR.endPos) {
            AppMethodBeat.o(30571);
            return 0;
        } else if (i2 == this.JIR.bNu && i2 == this.JIR.endPos) {
            AppMethodBeat.o(30571);
            return 1;
        } else if (i2 > this.JIR.bNu && i2 < this.JIR.endPos) {
            AppMethodBeat.o(30571);
            return 2;
        } else if (i2 == this.JIR.bNu && i2 < this.JIR.endPos) {
            AppMethodBeat.o(30571);
            return 4;
        } else if (i2 <= this.JIR.bNu || i2 != this.JIR.endPos) {
            AppMethodBeat.o(30571);
            return 0;
        } else {
            AppMethodBeat.o(30571);
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
        AppMethodBeat.i(30572);
        if (this.JIQ != null) {
            this.JIQ.cCD();
        }
        AppMethodBeat.o(30572);
    }

    public final void cDY() {
        AppMethodBeat.i(30573);
        if (!mHasInit) {
            AppMethodBeat.o(30573);
            return;
        }
        B(-1, -1, -1, -1);
        f(true, 0);
        cEc();
        cEa();
        AppMethodBeat.o(30573);
    }

    public final void I(boolean z, boolean z2) {
        AppMethodBeat.i(30574);
        if (!mHasInit) {
            AppMethodBeat.o(30574);
            return;
        }
        cEc();
        cEa();
        f(true, 50);
        ln(z);
        ll(z2);
        AppMethodBeat.o(30574);
    }

    public final void f(final boolean z, long j2) {
        AppMethodBeat.i(30575);
        if (!mHasInit || this.mHandler == null) {
            AppMethodBeat.o(30575);
            return;
        }
        this.mHandler.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.wenote.model.nativenote.c.e.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(30552);
                RecyclerView a2 = e.a(e.this);
                if (a2 == null) {
                    AppMethodBeat.o(30552);
                    return;
                }
                for (int i2 = 0; i2 < a2.getChildCount(); i2++) {
                    View childAt = a2.getChildAt(i2);
                    c gh = f.gh(childAt);
                    if (gh != null) {
                        if (gh.JIM != null) {
                            if (z) {
                                gh.JIM.postInvalidate();
                            }
                        } else if (!(gh.JIN == null || gh.JIO == null)) {
                            e.this.a((LinearLayout) childAt.findViewById(R.id.g7d), (LinearLayout) childAt.findViewById(R.id.g7l), (LinearLayout) childAt.findViewById(R.id.g7g), gh.JIN.getPosInDataList());
                        }
                    }
                }
                AppMethodBeat.o(30552);
            }
        }, j2);
        AppMethodBeat.o(30575);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(View view, View view2, View view3, int i2) {
        AppMethodBeat.i(30576);
        if (!mHasInit || view == null || view2 == null || view3 == null || this.JIR == null) {
            AppMethodBeat.o(30576);
            return;
        }
        switch (FB(i2)) {
            case 0:
                view.setVisibility(8);
                view2.setVisibility(4);
                view3.setVisibility(4);
                AppMethodBeat.o(30576);
                return;
            case 1:
                if (this.JIR.startOffset == this.JIR.qSo) {
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                }
                view2.setVisibility(4);
                view3.setVisibility(4);
                AppMethodBeat.o(30576);
                return;
            case 2:
                view.setVisibility(0);
                view2.setVisibility(0);
                view3.setVisibility(0);
                AppMethodBeat.o(30576);
                return;
            case 3:
                if (this.JIR.qSo != 0) {
                    view.setVisibility(0);
                    view2.setVisibility(0);
                    view3.setVisibility(4);
                    AppMethodBeat.o(30576);
                    return;
                }
                break;
            case 4:
                if (this.JIR.startOffset == 0) {
                    view.setVisibility(0);
                    view2.setVisibility(4);
                    view3.setVisibility(0);
                    AppMethodBeat.o(30576);
                    return;
                }
                view.setVisibility(8);
                view2.setVisibility(4);
                view3.setVisibility(4);
                AppMethodBeat.o(30576);
                return;
        }
        view.setVisibility(8);
        view2.setVisibility(4);
        view3.setVisibility(4);
        AppMethodBeat.o(30576);
    }

    public final boolean cDZ() {
        AppMethodBeat.i(30577);
        if (this.qSI == null || !this.qSI.isShowing()) {
            AppMethodBeat.o(30577);
            return false;
        }
        AppMethodBeat.o(30577);
        return true;
    }

    public final void cEa() {
        AppMethodBeat.i(30578);
        if (this.qSI != null) {
            this.qSI.dismiss();
        }
        AppMethodBeat.o(30578);
    }

    public final void ll(final boolean z) {
        AppMethodBeat.i(30579);
        this.mHandler.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.wenote.model.nativenote.c.e.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(30557);
                e.this.lm(z);
                AppMethodBeat.o(30557);
            }
        }, 50);
        AppMethodBeat.o(30579);
    }

    public final void lm(boolean z) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(30580);
        if (!mHasInit || this.qSI == null) {
            AppMethodBeat.o(30580);
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        int selectType = getSelectType();
        if (recyclerView == null || selectType == 0 || ((selectType == 1 && !z) || (this.JIS != null && this.JIS.getType() == 1))) {
            cEa();
            AppMethodBeat.o(30580);
        } else if (!cEj()) {
            cEa();
            AppMethodBeat.o(30580);
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
                    if (this.JIR.bNu <= ks && this.JIR.endPos >= ku) {
                        i4 = 300;
                        i3 = -1000;
                    }
                }
                i3 = -1000;
            }
            if (i4 == -1) {
                cEa();
                AppMethodBeat.o(30580);
                return;
            }
            int i12 = this.mScreenWidth / 3;
            int i13 = (this.mScreenWidth * 2) / 3;
            if (i3 == -1000 || (i3 >= i12 && i3 <= i13)) {
                d(recyclerView, (this.mScreenWidth - i2) / 2, i4);
                AppMethodBeat.o(30580);
            } else if (i3 < i12) {
                d(recyclerView, this.qSv, i4);
                AppMethodBeat.o(30580);
            } else {
                d(recyclerView, (this.mScreenWidth - i2) - this.qSv, i4);
                AppMethodBeat.o(30580);
            }
        }
    }

    public final boolean cEb() {
        AppMethodBeat.i(30581);
        if (this.qSF == null || !this.qSF.isShowing()) {
            AppMethodBeat.o(30581);
            return false;
        }
        AppMethodBeat.o(30581);
        return true;
    }

    public final void cEc() {
        AppMethodBeat.i(30582);
        if (!mHasInit) {
            AppMethodBeat.o(30582);
            return;
        }
        FC(2);
        FC(3);
        FC(4);
        AppMethodBeat.o(30582);
    }

    private boolean FC(int i2) {
        boolean z = true;
        AppMethodBeat.i(30583);
        if (this.JIS != null && this.JIS.qcr == i2 && this.JIS.getType() == 1) {
            AppMethodBeat.o(30583);
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
        AppMethodBeat.o(30583);
        return z;
    }

    public final void ln(boolean z) {
        AppMethodBeat.i(30584);
        if (!mHasInit) {
            AppMethodBeat.o(30584);
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        int selectType = getSelectType();
        if (recyclerView == null || selectType == 0 || (selectType == 1 && !z)) {
            cEc();
            AppMethodBeat.o(30584);
            return;
        }
        View d2 = f.d(recyclerView, this.JIR.bNu);
        View d3 = f.d(recyclerView, this.JIR.endPos);
        if (selectType == 1) {
            FC(3);
            FC(4);
            a(2, recyclerView, d2, this.JIR.startOffset);
            AppMethodBeat.o(30584);
            return;
        }
        FC(2);
        a(3, recyclerView, d2, this.JIR.startOffset);
        a(4, recyclerView, d3, this.JIR.qSo);
        AppMethodBeat.o(30584);
    }

    private void a(int i2, RecyclerView recyclerView, View view, int i3) {
        WXRTEditText wXRTEditText;
        boolean a2;
        AppMethodBeat.i(30585);
        if (!mHasInit || recyclerView == null) {
            AppMethodBeat.o(30585);
            return;
        }
        c gh = f.gh(view);
        if (gh == null) {
            FC(i2);
            AppMethodBeat.o(30585);
            return;
        }
        if (gh.JIM != null) {
            wXRTEditText = gh.JIM;
        } else {
            if (!(gh.JIN == null || gh.JIO == null)) {
                if (i3 == 0) {
                    i3 = 0;
                    wXRTEditText = gh.JIN;
                } else if (i3 == 1) {
                    i3 = 0;
                    wXRTEditText = gh.JIO;
                }
            }
            wXRTEditText = null;
        }
        if (wXRTEditText == null) {
            FC(i2);
            AppMethodBeat.o(30585);
            return;
        }
        Editable text = wXRTEditText.getText();
        if (text == null || i3 < 0 || i3 > text.length()) {
            FC(i2);
            AppMethodBeat.o(30585);
            return;
        }
        Layout layout = wXRTEditText.getLayout();
        if (layout == null) {
            FC(i2);
            AppMethodBeat.o(30585);
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
        AppMethodBeat.o(30585);
    }

    private boolean a(int i2, RecyclerView recyclerView, PopupWindow popupWindow, int i3, int i4) {
        AppMethodBeat.i(30586);
        if (!mHasInit || recyclerView == null || popupWindow == null) {
            AppMethodBeat.o(30586);
            return false;
        } else if (i4 < j(recyclerView) || i4 > this.mScreenHeight - cDU()) {
            AppMethodBeat.o(30586);
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
            AppMethodBeat.o(30586);
            return true;
        }
    }

    private void cEd() {
        AppMethodBeat.i(30587);
        if (this.qSN == null) {
            this.qSN = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.wenote.model.nativenote.c.e.AnonymousClass7 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(30558);
                    if (e.this.getSelectType() == 1 && e.b(e.this)) {
                        e.this.cEa();
                    }
                    AppMethodBeat.o(30558);
                    return true;
                }
            }, false);
            AppMethodBeat.o(30587);
            return;
        }
        this.qSN.stopTimer();
        AppMethodBeat.o(30587);
    }

    private boolean d(RecyclerView recyclerView, int i2, int i3) {
        AppMethodBeat.i(30588);
        if (!mHasInit || recyclerView == null || this.qSI == null) {
            AppMethodBeat.o(30588);
            return false;
        } else if (i3 < j(recyclerView) || i3 > this.mScreenHeight - cDU()) {
            AppMethodBeat.o(30588);
            return false;
        } else {
            if (this.qSI.isShowing()) {
                this.qSI.update(i2, i3, -1, -1, false);
            } else {
                this.qSI.showAtLocation(recyclerView, 0, i2, i3);
            }
            AppMethodBeat.o(30588);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.c.a.AbstractC2006a
    public final void a(int i2, MotionEvent motionEvent) {
        AppMethodBeat.i(30589);
        if (!mHasInit || this.mHandler == null) {
            AppMethodBeat.o(30589);
        } else if (this.JIS == null || this.JIS.getType() != 1 || this.JIS.qcr == i2) {
            switch (motionEvent.getAction()) {
                case 0:
                    cEe();
                    if (!cDZ()) {
                        lm(true);
                    }
                    this.JIS.a(i2, motionEvent.getRawX(), motionEvent.getRawY(), motionEvent.getX(), motionEvent.getY(), 0);
                    AppMethodBeat.o(30589);
                    return;
                case 1:
                case 3:
                    cEe();
                    this.mHandler.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.wenote.model.nativenote.c.e.AnonymousClass8 */

                        public final void run() {
                            AppMethodBeat.i(30559);
                            e.this.ln(true);
                            e.this.lm(true);
                            AppMethodBeat.o(30559);
                        }
                    }, 200);
                    break;
                case 2:
                    if (this.JIS != null && this.JIS.getType() == 1) {
                        this.JIS.qSd = motionEvent.getRawX();
                        this.JIS.qSe = motionEvent.getRawY();
                        lo(true);
                        AppMethodBeat.o(30589);
                        return;
                    }
            }
            AppMethodBeat.o(30589);
        } else {
            AppMethodBeat.o(30589);
        }
    }

    private void lo(boolean z) {
        int i2;
        WXRTEditText wXRTEditText;
        int i3;
        int i4;
        boolean z2;
        AppMethodBeat.i(30590);
        if (!mHasInit || this.qSF == null || this.qSG == null || this.qSH == null || this.JIR == null) {
            AppMethodBeat.o(30590);
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null) {
            AppMethodBeat.o(30590);
        } else if (this.JIS == null || this.JIS.getType() != 1) {
            AppMethodBeat.o(30590);
        } else {
            int i5 = this.JIS.qcr;
            if (i5 == 2 || i5 == 3 || i5 == 4) {
                float f2 = this.JIS.qSd - this.JIS.deo;
                float f3 = ((float) (this.qSr / 2)) + (this.JIS.qSe - this.JIS.dep);
                if (i5 == 2) {
                    f2 += (float) (this.qSF.getWidth() / 2);
                } else if (i5 == 3) {
                    f2 += (float) this.qSG.getWidth();
                }
                recyclerView.getLocationOnScreen(this.qSB);
                View o = recyclerView.o(f2 - ((float) this.qSB[0]), f3 - ((float) this.qSB[1]));
                c gh = f.gh(o);
                WXRTEditText wXRTEditText2 = null;
                if (gh == null) {
                    i2 = 2;
                } else if (gh.JIM != null) {
                    wXRTEditText2 = gh.JIM;
                    int[] iArr = new int[2];
                    wXRTEditText2.getLocationOnScreen(iArr);
                    i2 = Z(i5, wXRTEditText2.getPosInDataList(), wXRTEditText2.getOffsetForPosition(f2 - ((float) iArr[0]), f3 - ((float) iArr[1])));
                } else if (gh.JIN == null || gh.JIO == null) {
                    i2 = 0;
                } else {
                    if (i5 == 3) {
                        wXRTEditText = gh.JIN;
                        i3 = Z(i5, wXRTEditText.getPosInDataList(), 0);
                        if (i3 == 2 || i3 == 3) {
                            a(i5, recyclerView, this.qSG, (int) (this.JIS.qSd - this.JIS.deo), (int) (this.JIS.qSe - this.JIS.dep));
                            i2 = i3;
                            wXRTEditText2 = wXRTEditText;
                        }
                    } else if (i5 == 4) {
                        wXRTEditText = gh.JIO;
                        i3 = Z(i5, wXRTEditText.getPosInDataList(), 1);
                        if (i3 == 2 || i3 == 3) {
                            a(i5, recyclerView, this.qSH, (int) (this.JIS.qSd - this.JIS.deo), (int) (this.JIS.qSe - this.JIS.dep));
                            i2 = i3;
                            wXRTEditText2 = wXRTEditText;
                        }
                    } else {
                        int[] iArr2 = new int[2];
                        o.getLocationOnScreen(iArr2);
                        if (f2 <= ((float) (iArr2[0] + (o.getWidth() / 2)))) {
                            wXRTEditText = gh.JIN;
                            i3 = Z(i5, wXRTEditText.getPosInDataList(), 0);
                        } else {
                            wXRTEditText = gh.JIO;
                            i3 = Z(i5, wXRTEditText.getPosInDataList(), 1);
                        }
                        if (i3 == 2 || i3 == 3) {
                            a(i5, recyclerView, this.qSF, (int) (this.JIS.qSd - this.JIS.deo), (int) (this.JIS.qSe - this.JIS.dep));
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
                            } else if (this.JIR.startOffset <= text.length()) {
                                wXRTEditText2.setIgnoreSelectChangeByMultiSelect(true);
                                wXRTEditText2.setSelection(this.JIR.startOffset);
                                wXRTEditText2.setIgnoreSelectChangeByMultiSelect(false);
                            }
                        } else if (this.qSq && text != null && selectType == 2 && wXRTEditText2.hasFocus()) {
                            if (wXRTEditText2.getEditTextType() == 1 || wXRTEditText2.getEditTextType() == 2) {
                                wXRTEditText2.setIgnoreSelectChangeByMultiSelect(true);
                                wXRTEditText2.setSelection(0);
                                wXRTEditText2.setIgnoreSelectChangeByMultiSelect(false);
                            } else if (this.JIR.startOffset <= text.length() && this.JIR.qSo <= text.length()) {
                                wXRTEditText2.setIgnoreSelectChangeByMultiSelect(true);
                                wXRTEditText2.setSelection(this.JIR.startOffset, this.JIR.qSo);
                                wXRTEditText2.setIgnoreSelectChangeByMultiSelect(false);
                            }
                        }
                        if (selectType == 3 || selectType == 0) {
                            cDX();
                        }
                        cEa();
                        f(true, 0);
                        if (i5 == 4) {
                            i4 = this.JIR.qSo;
                        } else {
                            i4 = this.JIR.startOffset;
                        }
                        a(i5, recyclerView, o, i4);
                        z2 = true;
                        break;
                    default:
                        AppMethodBeat.o(30590);
                        return;
                }
                if (!z2) {
                    cEf();
                } else if (z && ((this.JIS.qSe < ((float) j(recyclerView)) || this.JIS.qSe > ((float) cEg())) && (this.qSM == null || this.qSM.stopped()))) {
                    cEf();
                    this.qSM.startTimer(100);
                    AppMethodBeat.o(30590);
                    return;
                }
                AppMethodBeat.o(30590);
                return;
            }
            AppMethodBeat.o(30590);
        }
    }

    private int Z(int i2, int i3, int i4) {
        boolean B;
        AppMethodBeat.i(30591);
        if (!mHasInit) {
            AppMethodBeat.o(30591);
            return 0;
        }
        switch (i2) {
            case 2:
                B = B(i3, i4, i3, i4);
                break;
            case 3:
                if (this.JIR != null && i3 <= this.JIR.endPos && (i3 != this.JIR.endPos || i4 < this.JIR.qSo)) {
                    B = B(i3, i4, this.JIR.endPos, this.JIR.qSo);
                    break;
                } else {
                    AppMethodBeat.o(30591);
                    return 1;
                }
                break;
            case 4:
                if (this.JIR != null && i3 >= this.JIR.bNu && (i3 != this.JIR.bNu || i4 > this.JIR.startOffset)) {
                    B = B(this.JIR.bNu, this.JIR.startOffset, i3, i4);
                    break;
                } else {
                    AppMethodBeat.o(30591);
                    return 1;
                }
            default:
                AppMethodBeat.o(30591);
                return 0;
        }
        if (B) {
            AppMethodBeat.o(30591);
            return 3;
        }
        AppMethodBeat.o(30591);
        return 2;
    }

    private void cEe() {
        AppMethodBeat.i(30592);
        if (this.JIS == null) {
            this.JIS = new b();
            AppMethodBeat.o(30592);
            return;
        }
        this.JIS.reset();
        AppMethodBeat.o(30592);
    }

    private void cEf() {
        AppMethodBeat.i(30593);
        if (this.qSM == null) {
            this.qSM = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.wenote.model.nativenote.c.e.AnonymousClass9 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    boolean z;
                    AppMethodBeat.i(30560);
                    Log.d("NoteSelectManager", "onTimerExpired: ");
                    RecyclerView a2 = e.a(e.this);
                    boolean z2 = e.this.JIS != null && e.this.JIS.qSe < ((float) e.a(e.this, a2));
                    if (e.this.JIS == null || e.this.JIS.qSe <= ((float) e.d(e.this))) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!e.mHasInit || a2 == null || e.this.JIS == null || e.this.JIS.getType() != 1 || (!z2 && !z)) {
                        if (e.this.qSM != null) {
                            e.this.qSM.stopTimer();
                        }
                    } else if (z2 && a2.canScrollVertically(-1)) {
                        if (e.this.JIS.qcr == 3) {
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
                    AppMethodBeat.o(30560);
                    return true;
                }
            }, true);
            AppMethodBeat.o(30593);
            return;
        }
        this.qSM.stopTimer();
        AppMethodBeat.o(30593);
    }

    private int j(RecyclerView recyclerView) {
        AppMethodBeat.i(30594);
        int i2 = 150;
        if (recyclerView != null) {
            recyclerView.getLocationOnScreen(this.qSB);
            if (A(this.qSB)) {
                i2 = this.qSB[1];
            }
        }
        AppMethodBeat.o(30594);
        return i2;
    }

    private int cEg() {
        AppMethodBeat.i(30595);
        int i2 = 0;
        if (this.JIQ != null) {
            i2 = this.JIQ.cCE();
        }
        if (i2 == 0 && this.JIQ != null) {
            i2 = this.JIQ.cCF();
        }
        if (i2 == 0) {
            i2 = 150;
        }
        int i3 = this.mScreenHeight - i2;
        AppMethodBeat.o(30595);
        return i3;
    }

    public static void i(TextView textView, int i2) {
        AppMethodBeat.i(30596);
        if (textView != null) {
            textView.setTextSize(1, (float) i2);
        }
        AppMethodBeat.o(30596);
    }

    private void cEh() {
        AppMethodBeat.i(30597);
        if (this.JIQ != null) {
            this.JIQ.gjI();
        }
        AppMethodBeat.o(30597);
    }

    public final void cEi() {
        AppMethodBeat.i(30598);
        Log.i("NoteSelectManager", "deleteSelectedData");
        if (!mHasInit) {
            Log.e("NoteSelectManager", "deleteSelectedData: not init");
            AppMethodBeat.o(30598);
            return;
        }
        cEa();
        int selectType = getSelectType();
        if (selectType == 2) {
            a(true, (ArrayList<c>) null, "");
            AppMethodBeat.o(30598);
        } else if (selectType == 3) {
            b(true, null, "");
            AppMethodBeat.o(30598);
        } else {
            Log.e("NoteSelectManager", "deleteSelectedData: not in select");
            cEh();
            AppMethodBeat.o(30598);
        }
    }

    private SpannableStringBuilder a(boolean z, ArrayList<c> arrayList, String str) {
        SpannableStringBuilder spannableStringBuilder;
        ArrayList<c> arrayList2;
        int i2 = 2;
        AppMethodBeat.i(30599);
        d gjX = gjX();
        cDY();
        int selectType = gjX.getSelectType();
        if (selectType == 1 || selectType == 2) {
            c ahp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(gjX.bNu);
            if (ahp == null) {
                Log.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
                AppMethodBeat.o(30599);
                return null;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (ahp.getType() != 1) {
                if (selectType == 1 && z) {
                    if (gjX.startOffset == 0) {
                        i2 = 1;
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        arrayList2 = arrayList;
                    } else if (!Util.isNullOrNil(str)) {
                        arrayList2 = new ArrayList<>();
                        i iVar = new i();
                        iVar.content = str;
                        iVar.qPA = false;
                        iVar.qPC = -1;
                        arrayList2.add(iVar);
                    } else {
                        AppMethodBeat.o(30599);
                        return spannableStringBuilder2;
                    }
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(arrayList2, i2, gjX.bNu, gjX.startOffset, gjX.qSo);
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().fx(gjX.bNu - 1, arrayList2.size() + gjX.bNu + 1);
                }
                spannableStringBuilder = spannableStringBuilder2;
            } else if (!z || arrayList == null || arrayList.size() <= 0) {
                spannableStringBuilder = a((i) ahp, gjX.startOffset, gjX.qSo, false, z, str, true);
                if (this.JIQ != null) {
                    this.JIQ.Fr(gjX.bNu);
                }
                if (z) {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDy();
                }
            } else {
                spannableStringBuilder = a((i) ahp, gjX.startOffset, gjX.qSo, false, false, "", true);
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(arrayList, 0, gjX.bNu, gjX.startOffset, gjX.qSo);
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().fx(gjX.bNu, gjX.bNu + arrayList.size() + 1);
            }
            AppMethodBeat.o(30599);
            return spannableStringBuilder;
        }
        Log.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
        AppMethodBeat.o(30599);
        return null;
    }

    private ArrayList<c> b(boolean z, ArrayList<c> arrayList, String str) {
        int i2;
        AppMethodBeat.i(30600);
        d gjX = gjX();
        cDY();
        ArrayList<c> arrayList2 = new ArrayList<>();
        if (gjX.getSelectType() != 3) {
            Log.e("NoteSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
            AppMethodBeat.o(30600);
            return null;
        }
        int i3 = gjX.bNu;
        int i4 = gjX.endPos;
        while (true) {
            i2 = i3;
            if (i4 < gjX.bNu) {
                break;
            }
            c ahp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(i4);
            if (ahp != null) {
                if (i4 == gjX.endPos && ahp.getType() == 1) {
                    i iVar = (i) ahp;
                    SpannableStringBuilder a2 = a(iVar, 0, gjX.qSo, false, z, "", false);
                    if (!Util.isNullOrNil(a2)) {
                        i iVar2 = new i();
                        iVar2.content = b.a(a2);
                        iVar2.qPC = -1;
                        iVar2.qPA = false;
                        arrayList2.add(iVar2);
                    }
                    if (z && Util.isNullOrNil(iVar.content)) {
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ae(i4, true);
                    }
                } else if (i4 == gjX.bNu && ahp.getType() == 1) {
                    i iVar3 = (i) ahp;
                    SpannableStringBuilder a3 = a(iVar3, gjX.startOffset, 0, true, z, "", false);
                    if (!Util.isNullOrNil(a3)) {
                        i iVar4 = new i();
                        iVar4.content = b.a(a3);
                        iVar4.qPC = -1;
                        iVar4.qPA = false;
                        arrayList2.add(iVar4);
                    }
                    if (!z || !Util.isNullOrNil(iVar3.content)) {
                        i2++;
                    } else {
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ae(i4, true);
                    }
                } else {
                    arrayList2.add(com.tencent.mm.plugin.wenote.c.c.c(ahp));
                    if (z) {
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ae(i4, true);
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
                i iVar5 = new i();
                if (str == null) {
                    str = "";
                }
                iVar5.content = str;
                iVar5.qPA = false;
                iVar5.qPC = -1;
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(i2, iVar5);
            } else {
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().b(i2, arrayList);
                i6 = arrayList.size() + i2;
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().fx(i5, i6);
        }
        Collections.reverse(arrayList2);
        AppMethodBeat.o(30600);
        return arrayList2;
    }

    private static SpannableStringBuilder a(i iVar, int i2, int i3, boolean z, boolean z2, String str, boolean z3) {
        int i4;
        Spanned alS;
        SpannableStringBuilder spannableStringBuilder = null;
        AppMethodBeat.i(30601);
        if (iVar == null) {
            Log.e("NoteSelectManager", "processTextDataItem: textDataItem is null");
            AppMethodBeat.o(30601);
        } else {
            Spanned alS2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.alS(iVar.content);
            if (alS2 == null) {
                Log.e("NoteSelectManager", "processTextDataItem: spannedText is null");
                AppMethodBeat.o(30601);
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
                    Log.e("NoteSelectManager", "processTextDataItem: incorrect offset");
                    AppMethodBeat.o(30601);
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) alS2.subSequence(0, i2);
                    spannableStringBuilder = (SpannableStringBuilder) alS2.subSequence(i2, i4);
                    SpannableStringBuilder spannableStringBuilder3 = (SpannableStringBuilder) alS2.subSequence(i4, alS2.length());
                    if (z2) {
                        i4 = spannableStringBuilder2.length();
                        if (!Util.isNullOrNil(str) && (alS = com.tencent.mm.plugin.wenote.model.nativenote.a.a.alS(str)) != null) {
                            i4 += alS.length();
                        }
                        iVar.content = b.a(spannableStringBuilder2) + str + b.a(spannableStringBuilder3);
                    }
                    if (z3) {
                        iVar.qPA = true;
                        iVar.qPC = i4;
                    } else {
                        iVar.qPA = false;
                        iVar.qPC = -1;
                    }
                    AppMethodBeat.o(30601);
                }
            }
        }
        return spannableStringBuilder;
    }

    private boolean cEj() {
        AppMethodBeat.i(30602);
        boolean o = o(this.qSO, false);
        boolean o2 = o(this.qSP, false);
        boolean o3 = o(this.qSQ, cEk());
        boolean o4 = o(this.qSR, cEl());
        boolean o5 = o(this.qSS, cEm());
        boolean o6 = o(this.qST, cEn());
        boolean o7 = o(this.qSU, cEo());
        boolean o8 = o(this.qSV, cEp());
        if (o || o2 || o3 || o4 || o5 || o6 || o7 || o8) {
            AppMethodBeat.o(30602);
            return true;
        }
        AppMethodBeat.o(30602);
        return false;
    }

    private static boolean o(View view, boolean z) {
        AppMethodBeat.i(30603);
        if (view == null) {
            AppMethodBeat.o(30603);
            return false;
        } else if (z) {
            view.setVisibility(0);
            AppMethodBeat.o(30603);
            return true;
        } else {
            view.setVisibility(8);
            AppMethodBeat.o(30603);
            return false;
        }
    }

    private boolean cEk() {
        AppMethodBeat.i(30604);
        if (getSelectType() != 1) {
            AppMethodBeat.o(30604);
            return false;
        }
        c ahp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(this.JIR.bNu);
        if (ahp == null || (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().size() <= 1 && ahp.getType() == 1 && Util.isNullOrNil(((i) ahp).content))) {
            AppMethodBeat.o(30604);
            return false;
        }
        AppMethodBeat.o(30604);
        return true;
    }

    private boolean cEl() {
        AppMethodBeat.i(30605);
        int cDz = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDz();
        int cDA = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDA();
        c ahp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(cDz);
        c ahp2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(cDA);
        if (ahp == null || ahp2 == null) {
            AppMethodBeat.o(30605);
            return false;
        }
        if (this.JIR != null && this.JIR.bNu == cDz && this.JIR.startOffset == 0 && this.JIR.endPos == cDA) {
            if (ahp2.getType() == 1) {
                Spanned alS = com.tencent.mm.plugin.wenote.model.nativenote.a.a.alS(((i) ahp2).content);
                if (alS == null) {
                    AppMethodBeat.o(30605);
                    return false;
                } else if (this.JIR.qSo == alS.length()) {
                    AppMethodBeat.o(30605);
                    return false;
                }
            } else if (ahp2.getType() != 1 && this.JIR.qSo == 1) {
                AppMethodBeat.o(30605);
                return false;
            }
        }
        AppMethodBeat.o(30605);
        return true;
    }

    private boolean cEm() {
        boolean z = true;
        AppMethodBeat.i(30606);
        if (!this.qSq) {
            AppMethodBeat.o(30606);
            return false;
        }
        int selectType = getSelectType();
        if (selectType == 0 || selectType == 1) {
            AppMethodBeat.o(30606);
            return false;
        }
        if (this.JIQ != null && this.JIQ.cCG()) {
            z = false;
        }
        AppMethodBeat.o(30606);
        return z;
    }

    private boolean cEn() {
        AppMethodBeat.i(30607);
        int selectType = getSelectType();
        if (!this.qSq || !(selectType == 2 || selectType == 3)) {
            AppMethodBeat.o(30607);
            return false;
        }
        AppMethodBeat.o(30607);
        return true;
    }

    private boolean cEo() {
        AppMethodBeat.i(30608);
        int selectType = getSelectType();
        if (selectType == 2 || selectType == 3) {
            AppMethodBeat.o(30608);
            return true;
        }
        AppMethodBeat.o(30608);
        return false;
    }

    private boolean cEp() {
        AppMethodBeat.i(30609);
        if (!this.qSq || getSelectType() == 0) {
            AppMethodBeat.o(30609);
            return false;
        }
        MMApplicationContext.getContext();
        if (f.cDn() != 1) {
            AppMethodBeat.o(30609);
            return true;
        }
        AppMethodBeat.o(30609);
        return false;
    }

    static /* synthetic */ void j(e eVar) {
        AppMethodBeat.i(30617);
        eVar.f(true, 300);
        AppMethodBeat.o(30617);
    }

    static /* synthetic */ boolean l(e eVar) {
        AppMethodBeat.i(30618);
        if (eVar.getSelectType() == 3) {
            for (int i2 = eVar.JIR.bNu; i2 <= eVar.JIR.endPos; i2++) {
                c ahp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(i2);
                if (ahp != null && ahp.getType() == 4 && ((l) ahp).qPX.booleanValue()) {
                    AppMethodBeat.o(30618);
                    return true;
                }
            }
        }
        AppMethodBeat.o(30618);
        return false;
    }

    static /* synthetic */ boolean a(e eVar, ArrayList arrayList, String str) {
        int i2;
        int i3;
        int alJ;
        AppMethodBeat.i(30621);
        int selectType = eVar.getSelectType();
        if (selectType == 0) {
            AppMethodBeat.o(30621);
            return false;
        }
        StringBuilder sb = new StringBuilder(str);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            i2 = 0;
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null) {
                    if (cVar.getType() != 1) {
                        i2++;
                    } else {
                        sb.append(((i) cVar).content);
                    }
                }
            }
        } else {
            i2 = 0;
        }
        int alJ2 = com.tencent.mm.plugin.wenote.c.c.alJ(sb.toString());
        if (selectType == 2 || selectType == 3) {
            int i4 = eVar.JIR.bNu;
            while (i4 <= eVar.JIR.endPos) {
                c ahp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(i4);
                if (ahp != null) {
                    if (ahp.getType() == 1) {
                        if (i4 == eVar.JIR.bNu && i4 == eVar.JIR.endPos) {
                            alJ = com.tencent.mm.plugin.wenote.c.c.b(((i) ahp).content, eVar.JIR.startOffset, eVar.JIR.qSo, false) + 0;
                        } else if (i4 == eVar.JIR.bNu) {
                            alJ = com.tencent.mm.plugin.wenote.c.c.b(((i) ahp).content, eVar.JIR.startOffset, -1, true) + 0;
                        } else if (i4 == eVar.JIR.endPos) {
                            alJ = com.tencent.mm.plugin.wenote.c.c.b(((i) ahp).content, 0, eVar.JIR.qSo, false) + 0;
                        } else {
                            alJ = com.tencent.mm.plugin.wenote.c.c.alJ(((i) ahp).content) + 0;
                        }
                        alJ2 -= alJ;
                        i3 = i2;
                    } else if (ahp.getType() != 1) {
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
        boolean fw = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().fw(alJ2, i2);
        AppMethodBeat.o(30621);
        return fw;
    }
}
