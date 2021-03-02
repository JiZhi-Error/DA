package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;

public final class b {
    public boolean AxH = false;
    private a QBP;
    private boolean QBQ = false;
    private int QBR;
    private int QBS;
    Runnable QBT;
    Runnable QBU;
    private int maxHeight;
    private int oXi;
    private int uZv;
    private Rect vPN = new Rect();
    private View view;

    public interface a {
        void f(boolean z, int i2);
    }

    public b(View view2, a aVar) {
        AppMethodBeat.i(143328);
        this.view = view2;
        this.QBP = aVar;
        this.QBS = ao.aD(view2.getContext()) * 2;
        this.oXi = KeyBoardUtil.getKeyBordHeightPx(view2.getContext(), true);
        AppMethodBeat.o(143328);
    }

    public final void aou(int i2) {
        boolean z;
        AppMethodBeat.i(143329);
        if (!gYB() || isInMultiWindowMode()) {
            Log.i("MicroMsg.InputPanelHelper", "onMeasure: delay call runnable");
            AppMethodBeat.o(143329);
            return;
        }
        int i3 = this.uZv;
        int i4 = this.vPN.bottom;
        this.uZv = View.MeasureSpec.getSize(i2);
        this.view.getWindowVisibleDisplayFrame(this.vPN);
        if (!this.QBQ) {
            this.QBQ = i4 != this.vPN.bottom;
        }
        this.QBR = this.vPN.bottom;
        if (this.QBR > this.maxHeight - this.QBS) {
            this.maxHeight = this.QBR;
        }
        int i5 = this.maxHeight - this.QBR;
        if (i5 > this.QBS) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.oXi = i5;
        }
        if (this.QBQ && z != this.AxH) {
            if (i5 == this.QBS) {
                this.QBP.f(false, this.oXi - i5);
            } else {
                this.QBP.f(z, this.oXi);
            }
        }
        this.AxH = z;
        if ((this.QBQ && i3 > this.uZv + this.QBS) || i3 < this.uZv - this.QBS) {
            Log.i("MicroMsg.InputPanelHelper", "onMeasure: run, %s", Boolean.valueOf(z));
            this.QBQ = false;
            if (z) {
                if (this.QBT != null) {
                    this.QBT.run();
                    this.QBT = null;
                    AppMethodBeat.o(143329);
                    return;
                }
            } else if (this.QBU != null) {
                this.QBU.run();
                this.QBU = null;
            }
        }
        AppMethodBeat.o(143329);
    }

    public final void aP(Runnable runnable) {
        AppMethodBeat.i(143330);
        this.QBT = runnable;
        this.QBU = null;
        this.view.postDelayed(new Runnable() {
            /* class com.tencent.mm.ui.widget.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(143326);
                if (b.this.QBT != null) {
                    Log.w("MicroMsg.InputPanelHelper", "onKeyboardShowOnce not run in measure");
                    b.this.QBT.run();
                    b.this.QBT = null;
                }
                AppMethodBeat.o(143326);
            }
        }, 200);
        AppMethodBeat.o(143330);
    }

    public final void aQ(Runnable runnable) {
        AppMethodBeat.i(143331);
        this.QBU = runnable;
        this.QBT = null;
        this.view.postDelayed(new Runnable() {
            /* class com.tencent.mm.ui.widget.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(143327);
                if (b.this.QBU != null) {
                    Log.w("MicroMsg.InputPanelHelper", "onKeyboardHideOnce not run in measure");
                    b.this.QBU.run();
                    b.this.QBU = null;
                }
                AppMethodBeat.o(143327);
            }
        }, 200);
        AppMethodBeat.o(143331);
    }

    private boolean gYB() {
        AppMethodBeat.i(143332);
        boolean isPortOrientation = KeyBoardUtil.isPortOrientation(this.view.getContext());
        AppMethodBeat.o(143332);
        return isPortOrientation;
    }

    private boolean isInMultiWindowMode() {
        AppMethodBeat.i(143333);
        if (!d.oD(24) || !(this.view.getContext() instanceof Activity)) {
            AppMethodBeat.o(143333);
            return false;
        }
        boolean isInMultiWindowMode = ((Activity) this.view.getContext()).isInMultiWindowMode();
        AppMethodBeat.o(143333);
        return isInMultiWindowMode;
    }
}
