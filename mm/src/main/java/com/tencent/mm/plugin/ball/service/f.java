package com.tencent.mm.plugin.ball.service;

import android.graphics.Point;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.d.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.plugin.ball.ui.b;
import com.tencent.mm.plugin.ball.ui.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.u;

public class f extends FloatBallHelper {
    public com.tencent.mm.plugin.ball.a.f oXA;
    protected e oXB;
    protected com.tencent.mm.plugin.ball.ui.e oXC;
    protected b oXD;
    protected com.tencent.mm.plugin.ball.d.a oXE;

    public interface a {
        void proceed();
    }

    public f(com.tencent.mm.plugin.ball.a.f fVar) {
        this.oXA = fVar;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public void G(int i2, String str) {
        AppMethodBeat.i(106244);
        super.G(i2, str);
        this.oXB = new e() {
            /* class com.tencent.mm.plugin.ball.service.f.AnonymousClass4 */
        };
        this.oXE = new com.tencent.mm.plugin.ball.d.a() {
            /* class com.tencent.mm.plugin.ball.service.f.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.ball.d.a
            public final void onAnimationEnd() {
                AppMethodBeat.i(106239);
                Log.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation end");
                if (f.this.oWG != null) {
                    f.this.oWG.setEnableClick(true);
                }
                f.this.oXA.hb(false);
                f.a(f.this);
                AppMethodBeat.o(106239);
            }

            @Override // com.tencent.mm.plugin.ball.d.a
            public final void awJ() {
                AppMethodBeat.i(106240);
                Log.i("MicroMsg.PageFloatBallHelper", "transform to float ball animation cancel");
                if (f.this.oWG != null) {
                    f.this.oWG.setEnableClick(true);
                }
                f.this.oXA.hb(true);
                f.a(f.this);
                AppMethodBeat.o(106240);
            }
        };
        if (aGg()) {
            BallInfo cim = cim();
            if (cim == null || cim.oWr) {
                this.oXC = new com.tencent.mm.plugin.ball.ui.e(this.oXA, this.oXB);
                this.oXC.start();
                int cip = cip();
                Log.i("MicroMsg.PageFloatBallHelper", "onCreate, activeCount:%s", Integer.valueOf(cip));
                if (this.oXC.oYu != null) {
                    this.oXC.oYu.CC(cip);
                }
                AppMethodBeat.o(106244);
                return;
            }
            this.oXD = new b(this.oXA, this.oXB);
            b bVar = this.oXD;
            Log.i("MicroMsg.FloatBallFadeInController", "start FloatBallFadeInController");
            if (bVar.oXA.aGg()) {
                bVar.oXA.a(new f.a() {
                    /* class com.tencent.mm.plugin.ball.ui.b.AnonymousClass1 */
                });
            }
            AppMethodBeat.o(106244);
            return;
        }
        Log.i("MicroMsg.PageFloatBallHelper", "onCreate, do not support swipe to float ball");
        AppMethodBeat.o(106244);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public boolean wu(int i2) {
        AppMethodBeat.i(106245);
        if (!ciq() || this.oWG == null) {
            AppMethodBeat.o(106245);
            return false;
        }
        Log.i("MicroMsg.PageFloatBallHelper", "onClose, resume this ball");
        ciw().opType = BI(i2);
        cit();
        c.a(this.oXA, this.oWG.getBallPosition(), new com.tencent.mm.plugin.ball.d.a() {
            /* class com.tencent.mm.plugin.ball.service.f.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.ball.d.a
            public final void onAnimationEnd() {
                AppMethodBeat.i(106236);
                Log.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation end");
                f.this.oXA.hb(false);
                AppMethodBeat.o(106236);
            }

            @Override // com.tencent.mm.plugin.ball.d.a
            public final void awJ() {
                AppMethodBeat.i(106237);
                Log.i("MicroMsg.PageFloatBallHelper", "onClose, transform to float ball animation cancel");
                f.this.oXA.hb(true);
                AppMethodBeat.o(106237);
            }
        });
        AppMethodBeat.o(106245);
        return true;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public void onDestroy() {
        AppMethodBeat.i(106246);
        super.onDestroy();
        if (this.oXC != null) {
            com.tencent.mm.plugin.ball.ui.e eVar = this.oXC;
            Log.i("MicroMsg.FloatIndicatorController", "stop FloatIndicatorController");
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.ball.ui.e.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(106320);
                    if (e.this.oYu != null) {
                        try {
                            if (e.this.oYu.getParent() != null) {
                                ((ViewGroup) e.this.oYu.getParent()).removeView(e.this.oYu);
                            }
                            AppMethodBeat.o(106320);
                            return;
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.FloatIndicatorController", e2, "detachFloatIndicatorView exception:%s", e2);
                        }
                    }
                    AppMethodBeat.o(106320);
                }
            });
            eVar.oXA.a((f.a) null);
        }
        AppMethodBeat.o(106246);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public void bCA() {
        AppMethodBeat.i(106247);
        super.bCA();
        AppMethodBeat.o(106247);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public void aGf() {
        AppMethodBeat.i(106248);
        super.aGf();
        AppMethodBeat.o(106248);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public void aGj() {
        AppMethodBeat.i(106249);
        super.aGj();
        AppMethodBeat.o(106249);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public void bCB() {
        AppMethodBeat.i(106250);
        super.bCB();
        ciQ();
        AppMethodBeat.o(106250);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public void aGi() {
        AppMethodBeat.i(106251);
        super.aGi();
        AppMethodBeat.o(106251);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final void BG(int i2) {
        AppMethodBeat.i(106252);
        super.BG(i2);
        if (!(this.oXC == null || this.oXC.oYu == null)) {
            this.oXC.oYu.CC(i2);
        }
        AppMethodBeat.o(106252);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public void y(boolean z, final int i2) {
        AppMethodBeat.i(217039);
        if (z) {
            Log.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
            a(new a() {
                /* class com.tencent.mm.plugin.ball.service.f.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.ball.service.f.a
                public final void proceed() {
                    AppMethodBeat.i(217038);
                    if (!f.this.cio()) {
                        FloatBallProxyUI.a(f.this.oXA.getActivity(), 1, f.this.oWE, f.this.cij(), f.this.oWH);
                        AppMethodBeat.o(217038);
                        return;
                    }
                    if (f.this.oWG != null) {
                        f.this.ciw().hCZ = i2;
                        f.this.cit();
                        Point ballPosition = f.this.oWG.getBallPosition();
                        if (ballPosition != null) {
                            c.a(f.this.oXA, ballPosition, f.this.oXE);
                        }
                    }
                    AppMethodBeat.o(217038);
                }
            });
            AppMethodBeat.o(217039);
            return;
        }
        Log.i("MicroMsg.PageFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
        BallInfo cim = cim();
        if (cim == null) {
            AppMethodBeat.o(217039);
        } else if (cim.state != 0) {
            jT(true);
            AppMethodBeat.o(217039);
        } else {
            ciw().opType = 8;
            cit();
            cir();
            ciQ();
            if (this.oXA.getActivity() != null) {
                u.cG(this.oXA.getActivity(), this.oXA.getActivity().getString(R.string.gm));
            }
            AppMethodBeat.o(217039);
        }
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        AppMethodBeat.i(217040);
        aVar.proceed();
        AppMethodBeat.o(217040);
    }

    private void ciQ() {
        AppMethodBeat.i(106254);
        if (this.oXD != null) {
            this.oXD.stop();
        }
        if (aGg()) {
            this.oXC = new com.tencent.mm.plugin.ball.ui.e(this.oXA, this.oXB);
            this.oXC.start();
        }
        AppMethodBeat.o(106254);
    }

    protected static int BI(int i2) {
        if (i2 == 1) {
            return 4;
        }
        if (i2 == 2) {
            return 7;
        }
        if (i2 == 3) {
            return 5;
        }
        return 6;
    }

    static /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(106255);
        fVar.jT(false);
        if (!fVar.ciq()) {
            if (super.ciz()) {
                fVar.oWE.type = fVar.oWE.beK;
                fVar.oWE.state = 0;
                Log.v("MicroMsg.FloatBallHelper", "alvinluo resetFloatBallInfo ballInfo: %s", fVar.oWE);
            }
            fVar.cis();
        }
        AppMethodBeat.o(106255);
    }
}
