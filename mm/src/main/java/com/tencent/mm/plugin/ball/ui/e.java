package com.tencent.mm.plugin.ball.ui;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.view.FloatIndicatorView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public final class e {
    private boolean iqo;
    public f oXA;
    private com.tencent.mm.plugin.ball.d.e oXB;
    private boolean oYA;
    private long oYB = -1;
    public FloatIndicatorView oYu;
    int oYv;
    int oYw;
    FrameLayout.LayoutParams oYx;
    private boolean oYy;
    private boolean oYz;

    public e(f fVar, com.tencent.mm.plugin.ball.d.e eVar) {
        AppMethodBeat.i(106321);
        this.oXA = fVar;
        this.oXB = eVar;
        this.oYu = new FloatIndicatorView(this.oXA.getActivity());
        this.oYu.setOnOrientationChangedListener(new FloatIndicatorView.a() {
            /* class com.tencent.mm.plugin.ball.ui.e.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.ball.view.FloatIndicatorView.a
            public final void jY(boolean z) {
                AppMethodBeat.i(106316);
                Log.i("MicroMsg.FloatIndicatorController", "onOrientationChanged, isLandscape:%s", Boolean.valueOf(z));
                e.this.jX(z);
                e.this.oYx.bottomMargin = e.this.oYw;
                e.this.oYx.rightMargin = e.this.oYv;
                e.this.oYu.setLayoutParams(e.this.oYx);
                Log.i("MicroMsg.FloatIndicatorController", "onOrientationChanged layoutParams, right:%s, bottom:%s", Integer.valueOf(e.this.oYx.rightMargin), Integer.valueOf(e.this.oYx.bottomMargin));
                AppMethodBeat.o(106316);
            }
        });
        jX(a.jn(MMApplicationContext.getContext()) > a.jo(MMApplicationContext.getContext()));
        this.oYx = new FrameLayout.LayoutParams(-2, -2);
        this.oYx.gravity = 8388693;
        this.oYx.bottomMargin = this.oYw;
        this.oYx.rightMargin = this.oYv;
        this.oYu.setLayoutParams(this.oYx);
        Log.i("MicroMsg.FloatIndicatorController", "createFloatIndicator layoutParams, right:%s, bottom:%s", Integer.valueOf(this.oYx.rightMargin), Integer.valueOf(this.oYx.bottomMargin));
        AppMethodBeat.o(106321);
    }

    /* access modifiers changed from: package-private */
    public final void jX(boolean z) {
        AppMethodBeat.i(106322);
        Log.i("MicroMsg.FloatIndicatorController", "updateOrientation, isLandscape:%b", Boolean.valueOf(z));
        this.iqo = z;
        bKU();
        AppMethodBeat.o(106322);
    }

    private void bKU() {
        AppMethodBeat.i(106323);
        com.tencent.mm.plugin.ball.f.e.eG(this.oXA.getActivity());
        if (this.iqo) {
            this.oYw = -com.tencent.mm.plugin.ball.f.e.oYP;
            this.oYv = cjc() - com.tencent.mm.plugin.ball.f.e.oYP;
            AppMethodBeat.o(106323);
            return;
        }
        this.oYv = -com.tencent.mm.plugin.ball.f.e.oYP;
        this.oYw = cjc() - com.tencent.mm.plugin.ball.f.e.oYP;
        AppMethodBeat.o(106323);
    }

    private int cjc() {
        AppMethodBeat.i(106324);
        if (this.oXA.chH() >= 0) {
            int chH = this.oXA.chH();
            AppMethodBeat.o(106324);
            return chH;
        }
        int i2 = com.tencent.mm.plugin.ball.f.e.oYU;
        AppMethodBeat.o(106324);
        return i2;
    }

    public final void start() {
        AppMethodBeat.i(106325);
        Log.i("MicroMsg.FloatIndicatorController", "start FloatIndicatorController");
        cjd();
        this.oYB = -1;
        this.oYy = false;
        this.oYz = false;
        this.oYA = false;
        if (!this.oXA.aGg()) {
            AppMethodBeat.o(106325);
            return;
        }
        this.oXA.a(new f.a() {
            /* class com.tencent.mm.plugin.ball.ui.e.AnonymousClass2 */
        });
        cje();
        AppMethodBeat.o(106325);
    }

    private void cjd() {
        AppMethodBeat.i(106327);
        if (!this.oYz) {
            AppMethodBeat.o(106327);
            return;
        }
        if (this.oYu != null) {
            this.oYu.setVisibility(8);
            this.oYz = false;
        }
        AppMethodBeat.o(106327);
    }

    private void cje() {
        AppMethodBeat.i(106328);
        if (this.oYu != null) {
            this.oYu.setVisibility(8);
            ViewGroup chG = this.oXA.chG();
            try {
                if (this.oYu.getParent() == null) {
                    int childCount = chG.getChildCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= chG.getChildCount()) {
                            break;
                        } else if (chG.getChildAt(i2) instanceof SwipeBackLayout) {
                            childCount = i2 + 1;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    chG.addView(this.oYu, childCount);
                    AppMethodBeat.o(106328);
                    return;
                }
                Log.w("MicroMsg.FloatIndicatorController", "attachFloatIndicatorView, already attached");
                AppMethodBeat.o(106328);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FloatIndicatorController", e2, "attachFloatIndicatorView exception:%s", e2);
            }
        }
        AppMethodBeat.o(106328);
    }
}
