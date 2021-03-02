package com.tencent.mm.plugin.appbrand.floatball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.ball.f.c;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public final class a extends f {
    final String cDW = ("MicroMsg.AppBrand.AppBrandAudioOfVideoBackgroundPlayFloatBallHelper#" + hashCode());
    final q kBw;
    private final com.tencent.mm.plugin.appbrand.backgroundrunning.f lqo;
    volatile boolean lqp = false;
    private f.b lqq = new f.b() {
        /* class com.tencent.mm.plugin.appbrand.floatball.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.f.b
        public final void b(AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel) {
            AppMethodBeat.i(226513);
            if (appBrandBackgroundRunningOperationParcel == null) {
                AppMethodBeat.o(226513);
            } else if (!a.this.kBw.mAppId.equals(appBrandBackgroundRunningOperationParcel.appId) || a.this.kBw.kAq.eix != appBrandBackgroundRunningOperationParcel.iOo) {
                AppMethodBeat.o(226513);
            } else if (appBrandBackgroundRunningOperationParcel.beL != 8) {
                AppMethodBeat.o(226513);
            } else if (appBrandBackgroundRunningOperationParcel.dDe == 1) {
                a aVar = a.this;
                if (!aVar.ciq()) {
                    Log.i(aVar.cDW, "onSendBackgroundRunningOperation, add passive audio of video background play float ball");
                    aVar.agT(aVar.bCD());
                    aVar.jT(true);
                    aVar.jU(false);
                    aVar.BH(d.eV(aVar.oWE.state, 128));
                    aVar.ciw().hDa = 13;
                    aVar.cit();
                    aVar.cis();
                    aVar.lqp = true;
                    AppMethodBeat.o(226513);
                    return;
                }
                Log.i(aVar.cDW, "onSendBackgroundRunningOperation, add audio of video background play state to float ball");
                aVar.BH(d.eV(aVar.oWE.state, 128));
                aVar.jT(true);
                AppMethodBeat.o(226513);
            } else {
                if (appBrandBackgroundRunningOperationParcel.dDe == 2 || appBrandBackgroundRunningOperationParcel.dDe == 3) {
                    a aVar2 = a.this;
                    BallInfo cil = aVar2.cil();
                    if (cil == null) {
                        Log.i(aVar2.cDW, "removeBackgroundPlayAudioBall, no this float ball");
                        aVar2.BH(d.eW(aVar2.oWE.state, 128));
                    } else if (cil.oWr) {
                        Log.i(aVar2.cDW, "removeBackgroundPlayAudioBall, remove passive float ball");
                        aVar2.cir();
                        aVar2.lqp = false;
                        AppMethodBeat.o(226513);
                        return;
                    } else {
                        Log.w(aVar2.cDW, "removeBackgroundPlayAudioBall, passive is false");
                        AppMethodBeat.o(226513);
                        return;
                    }
                }
                AppMethodBeat.o(226513);
            }
        }
    };

    static /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(226529);
        aVar.wv(i2);
        AppMethodBeat.o(226529);
    }

    public a(com.tencent.mm.plugin.ball.a.f fVar, q qVar) {
        super(fVar);
        AppMethodBeat.i(226517);
        this.kBw = qVar;
        Log.i(this.cDW, "create, runtime:%s", Integer.valueOf(qVar.hashCode()));
        this.lqo = (com.tencent.mm.plugin.appbrand.backgroundrunning.f) g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class);
        AppMethodBeat.o(226517);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGg() {
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGh() {
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void G(int i2, String str) {
        AppMethodBeat.i(226518);
        Log.i(this.cDW, "onCreate, type:%s, key:%s", Integer.valueOf(i2), str);
        super.G(i2, str);
        if (this.lqo != null) {
            this.lqo.a(this.lqq);
        }
        AppMethodBeat.o(226518);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final boolean wu(final int i2) {
        AppMethodBeat.i(226519);
        Log.i(this.cDW, "onClose, runtime:%s", Integer.valueOf(this.kBw.hashCode()));
        h.d Uc = h.Uc(this.kBw.mAppId);
        Log.i(this.cDW, "onRuntimeBackground, type: ".concat(String.valueOf(Uc)));
        com.tencent.mm.plugin.appbrand.jsapi.ag.a aVar = (com.tencent.mm.plugin.appbrand.jsapi.ag.a) this.kBw.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.a.class);
        if (aVar == null) {
            Log.w(this.cDW, "onRuntimeBackground, audioOfVideoBackgroundPlayManager is null");
        } else {
            aVar.c(Uc);
        }
        if (ciq() || this.lqp) {
            if (!b.cx(this.oXA.getActivity())) {
                AppBrandFloatBallPermissionHelper.a(this.oXA.getActivity(), 18, new c.a() {
                    /* class com.tencent.mm.plugin.appbrand.floatball.a.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.ball.f.c.a
                    public final void ha(boolean z) {
                        AppMethodBeat.i(226514);
                        Log.i(a.this.cDW, "onClose, checkFloatBallPermission isOK:%b", Boolean.valueOf(z));
                        if (z) {
                            a.a(a.this, i2);
                            a.a(a.this, true);
                            AppMethodBeat.o(226514);
                            return;
                        }
                        Log.w(a.this.cDW, "onClose, refuse permission, remove ball and stop background play");
                        a.this.cir();
                        a.this.lqp = false;
                        a.this.bCC();
                        a.a(a.this, false);
                        a.this.oXA.hb(true);
                        AppMethodBeat.o(226514);
                    }
                });
            } else {
                wv(i2);
            }
            AppMethodBeat.o(226519);
            return true;
        }
        AppMethodBeat.o(226519);
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void onDestroy() {
        AppMethodBeat.i(226520);
        Log.i(this.cDW, "onDestroy, runtime:%s", Integer.valueOf(this.kBw.hashCode()));
        super.onDestroy();
        if (this.lqo != null) {
            this.lqo.b(this.lqq);
        }
        AppMethodBeat.o(226520);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCA() {
        AppMethodBeat.i(226521);
        Log.i(this.cDW, "onEnterPage, runtime:%s", Integer.valueOf(this.kBw.hashCode()));
        if (cin() != null) {
            U(false);
        }
        AppMethodBeat.o(226521);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGj() {
        AppMethodBeat.i(226522);
        Log.i(this.cDW, "onExitPage, runtime:%s", Integer.valueOf(this.kBw.hashCode()));
        if (cin() != null) {
            U(true);
        }
        AppMethodBeat.o(226522);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(226523);
        Log.i(this.cDW, "onReceivedFinishWhenSwitchBallEvent, runtime:%s", Integer.valueOf(this.kBw.hashCode()));
        this.oXA.hb(true);
        AppMethodBeat.o(226523);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCB() {
        AppMethodBeat.i(226524);
        Log.i(this.cDW, "onReceivedBallInfoRemovedEvent, runtime:%s", Integer.valueOf(this.kBw.hashCode()));
        super.bCB();
        this.lqp = false;
        bCC();
        AppMethodBeat.o(226524);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final void ag(int i2, String str) {
        AppMethodBeat.i(226525);
        Log.i(this.cDW, "onReceivedBallInfoAddedEvent, runtime:%s, type: %d, key: %s", Integer.valueOf(this.kBw.hashCode()), Integer.valueOf(i2), str);
        super.ag(i2, str);
        if (this.oWE != null) {
            Log.i(this.cDW, "onReceivedBallInfoAddedEvent, myType: %d, myKey: %s", Integer.valueOf(this.oWE.type), this.oWE.key);
        }
        if (this.oWE == null || i2 != this.oWE.type || !Objects.equals(str, this.oWE.key)) {
            if (6 == i2 || 18 == i2 || 9 == i2 || 17 == i2) {
                cir();
                this.lqp = false;
            }
            AppMethodBeat.o(226525);
            return;
        }
        Log.i(this.cDW, "onReceivedBallInfoAddedEvent, myself");
        AppMethodBeat.o(226525);
    }

    private void wv(int i2) {
        AppMethodBeat.i(226526);
        ciw().opType = BI(i2);
        cit();
        com.tencent.mm.plugin.ball.ui.c.a(this.oXA, this.oWG.getBallPosition(), new com.tencent.mm.plugin.ball.d.a() {
            /* class com.tencent.mm.plugin.appbrand.floatball.a.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.ball.d.a
            public final void onAnimationEnd() {
                AppMethodBeat.i(226515);
                Log.i(a.this.cDW, "onCloseWithAnimation, transform to float ball animation end");
                a.this.oXA.hb(false);
                AppMethodBeat.o(226515);
            }

            @Override // com.tencent.mm.plugin.ball.d.a
            public final void awJ() {
                AppMethodBeat.i(226516);
                Log.i(a.this.cDW, "onCloseWithAnimation, transform to float ball animation cancel");
                a.this.oXA.hb(true);
                AppMethodBeat.o(226516);
            }
        });
        AppMethodBeat.o(226526);
    }

    /* access modifiers changed from: package-private */
    public final void bCC() {
        AppMethodBeat.i(226527);
        if (this.lqo == null) {
            AppMethodBeat.o(226527);
            return;
        }
        MMBackgroundRunningOperationParcel mMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
        mMBackgroundRunningOperationParcel.appId = this.kBw.mAppId;
        mMBackgroundRunningOperationParcel.beL = 8;
        mMBackgroundRunningOperationParcel.dDe = 2;
        Log.i(this.cDW, "maybeStopBackgroundPlayAudio, appId:%s", this.kBw.mAppId);
        this.lqo.a(mMBackgroundRunningOperationParcel);
        AppMethodBeat.o(226527);
    }

    /* access modifiers changed from: package-private */
    public final String bCD() {
        String str;
        AppMethodBeat.i(226528);
        com.tencent.mm.plugin.appbrand.jsapi.ag.a aVar = (com.tencent.mm.plugin.appbrand.jsapi.ag.a) this.kBw.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.a.class);
        if (aVar != null) {
            str = aVar.bLQ();
        } else {
            str = null;
        }
        if (Util.isNullOrNil(str)) {
            str = this.kBw.bsC().brandName;
        }
        AppMethodBeat.o(226528);
        return str;
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        boolean z2;
        AppMethodBeat.i(226530);
        Log.i(aVar.cDW, "ignoreRuntimeResumePauseOnce");
        com.tencent.mm.plugin.appbrand.jsapi.ag.a aVar2 = (com.tencent.mm.plugin.appbrand.jsapi.ag.a) aVar.kBw.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.a.class);
        if (aVar2 == null) {
            Log.w(aVar.cDW, "ignoreRuntimeResumePauseOnce, audioOfVideoBackgroundPlayManager is null");
            AppMethodBeat.o(226530);
            return;
        }
        if (!z) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "ignoreRuntimeResumePauseOnce, ignoreBackgroundAudioPlayer: ".concat(String.valueOf(z2)));
        aVar2.mIP.set(true);
        aVar2.mIQ.set(z2);
        AppMethodBeat.o(226530);
    }
}
