package com.tencent.mm.plugin.appbrand.floatball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.ball.d.a;
import com.tencent.mm.plugin.ball.f.c;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.service.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends f {
    q kGW;
    private com.tencent.mm.plugin.appbrand.backgroundrunning.f lqJ;
    private f.b lqK = new f.b() {
        /* class com.tencent.mm.plugin.appbrand.floatball.e.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.f.b
        public final void b(AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel) {
            AppMethodBeat.i(44996);
            if (appBrandBackgroundRunningOperationParcel != null && e.this.kGW != null && e.this.kGW.mAppId.equals(appBrandBackgroundRunningOperationParcel.appId) && e.this.kGW.kAq.eix == appBrandBackgroundRunningOperationParcel.iOo && appBrandBackgroundRunningOperationParcel.beL == 2 && appBrandBackgroundRunningOperationParcel.dDe == 1) {
                e eVar = e.this;
                if (!eVar.ciq()) {
                    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add passive location float ball");
                    eVar.jT(true);
                    eVar.jU(true);
                    eVar.BH(d.eV(eVar.oWE.state, 1));
                    eVar.cis();
                    AppMethodBeat.o(44996);
                    return;
                }
                Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onBackgroundLocationStateChanged, add location state to float ball");
                eVar.BH(d.eV(eVar.oWE.state, 1));
            }
            AppMethodBeat.o(44996);
        }
    };

    static /* synthetic */ void a(e eVar, int i2) {
        AppMethodBeat.i(45007);
        eVar.wx(i2);
        AppMethodBeat.o(45007);
    }

    public e(com.tencent.mm.plugin.ball.a.f fVar, q qVar) {
        super(fVar);
        AppMethodBeat.i(44997);
        this.kGW = qVar;
        Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "create, runtime:%s", Integer.valueOf(qVar.hashCode()));
        this.lqJ = (com.tencent.mm.plugin.appbrand.backgroundrunning.f) g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class);
        AppMethodBeat.o(44997);
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
        AppMethodBeat.i(44998);
        Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCreate, type:%s, key:%s", Integer.valueOf(i2), str);
        super.G(i2, str);
        if (this.lqJ != null) {
            this.lqJ.a(this.lqK);
        }
        AppMethodBeat.o(44998);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final boolean wu(final int i2) {
        AppMethodBeat.i(44999);
        Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        if (ciq()) {
            if (!b.cx(this.oXA.getActivity())) {
                AppBrandFloatBallPermissionHelper.a(this.oXA.getActivity(), 7, new c.a() {
                    /* class com.tencent.mm.plugin.appbrand.floatball.e.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.ball.f.c.a
                    public final void ha(boolean z) {
                        AppMethodBeat.i(44993);
                        Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, checkFloatBallPermission isOK:%b", Boolean.valueOf(z));
                        if (z) {
                            e.a(e.this, i2);
                            AppMethodBeat.o(44993);
                            return;
                        }
                        Log.w("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, refuse permission, remove ball and stop location");
                        e.this.cir();
                        e.this.bCK();
                        e.this.oXA.hb(true);
                        AppMethodBeat.o(44993);
                    }
                });
            } else {
                wx(i2);
            }
            AppMethodBeat.o(44999);
            return true;
        }
        AppMethodBeat.o(44999);
        return false;
    }

    private void wx(int i2) {
        AppMethodBeat.i(45000);
        ciw().opType = BI(i2);
        cit();
        com.tencent.mm.plugin.ball.ui.c.a(this.oXA, this.oWG.getBallPosition(), new a() {
            /* class com.tencent.mm.plugin.appbrand.floatball.e.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.ball.d.a
            public final void onAnimationEnd() {
                AppMethodBeat.i(44994);
                Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation end");
                e.this.oXA.hb(false);
                AppMethodBeat.o(44994);
            }

            @Override // com.tencent.mm.plugin.ball.d.a
            public final void awJ() {
                AppMethodBeat.i(44995);
                Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
                e.this.oXA.hb(true);
                AppMethodBeat.o(44995);
            }
        });
        AppMethodBeat.o(45000);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void onDestroy() {
        AppMethodBeat.i(45001);
        Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onDestroy, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        super.onDestroy();
        if (this.lqJ != null) {
            this.lqJ.b(this.lqK);
        }
        AppMethodBeat.o(45001);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCA() {
        AppMethodBeat.i(45002);
        Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onEnterPage, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        if (cin() != null) {
            U(false);
        }
        AppMethodBeat.o(45002);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGj() {
        AppMethodBeat.i(45003);
        Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onExitPage, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        if (cin() != null) {
            U(true);
        }
        AppMethodBeat.o(45003);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(45004);
        Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        this.oXA.hb(true);
        AppMethodBeat.o(45004);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCB() {
        AppMethodBeat.i(45005);
        Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        super.bCB();
        bCK();
        AppMethodBeat.o(45005);
    }

    /* access modifiers changed from: package-private */
    public final void bCK() {
        AppMethodBeat.i(45006);
        if (g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class) != null) {
            MMBackgroundRunningOperationParcel mMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
            mMBackgroundRunningOperationParcel.appId = this.kGW.mAppId;
            mMBackgroundRunningOperationParcel.beL = 2;
            mMBackgroundRunningOperationParcel.dDe = 2;
            Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "stopLocationBackground, appId:%s", this.kGW.mAppId);
            ((com.tencent.mm.plugin.appbrand.backgroundrunning.f) g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class)).a(mMBackgroundRunningOperationParcel);
        }
        AppMethodBeat.o(45006);
    }
}
