package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aap;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.c.k;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.model.i;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class af implements i {
    IListener gmC = new IListener<aap>() {
        /* class com.tencent.mm.plugin.exdevice.model.af.AnonymousClass1 */

        {
            AppMethodBeat.i(161356);
            this.__eventId = aap.class.getName().hashCode();
            AppMethodBeat.o(161356);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aap aap) {
            AppMethodBeat.i(23476);
            boolean a2 = a(aap);
            AppMethodBeat.o(23476);
            return a2;
        }

        private boolean a(final aap aap) {
            boolean z = true;
            AppMethodBeat.i(23475);
            if (aap instanceof aap) {
                switch (aap.ehC.dDe) {
                    case 1:
                        Log.i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", aap.ehC.dGL);
                        i.INSTANCE.a(MMApplicationContext.getContext(), new i.a() {
                            /* class com.tencent.mm.plugin.exdevice.model.af.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.exdevice.model.i.a
                            public final void lP(boolean z) {
                                AppMethodBeat.i(23474);
                                if (!z) {
                                    Log.e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", aap.ehC.dGL, aap.ehC.dGP);
                                    af.aU(aap.ehC.dGL, false);
                                    AppMethodBeat.o(23474);
                                    return;
                                }
                                af.aU(aap.ehC.dGL, true);
                                AppMethodBeat.o(23474);
                            }
                        });
                        break;
                    case 3:
                        b anJ = ad.cKL().anJ(aap.ehC.dGL);
                        aap.a aVar = aap.ehC;
                        if (anJ == null) {
                            z = false;
                        }
                        aVar.isSuccess = z;
                        break;
                    case 4:
                        Log.i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", aap.ehC.dGL);
                        bg.azz().a(538, af.this);
                        bg.azz().a(new w(0, aap.ehC.dGP, aap.ehC.dGL, k.f.cKo(), Util.nowMilliSecond(), aap.ehC.data, 1), 0);
                        break;
                    case 7:
                        bg.azz().a(541, af.this);
                        bg.azz().a(new r("AndroidWear", aap.ehC.dGP, aap.ehC.dGL, 1, new byte[0]), 0);
                        break;
                    case 11:
                        if (!Util.isProcessRunning(MMApplicationContext.getContext(), MMApplicationContext.getPackageName() + ":exdevice")) {
                            d.fd(MMApplicationContext.getContext());
                            break;
                        }
                        break;
                }
            }
            AppMethodBeat.o(23475);
            return false;
        }
    };

    public af() {
        AppMethodBeat.i(23477);
        EventCenter.instance.addListener(this.gmC);
        AppMethodBeat.o(23477);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(23478);
        if (qVar instanceof r) {
            bg.azz().b(541, this);
            r rVar = (r) qVar;
            if (i2 == 0 && i3 == 0) {
                aS(rVar.rAx, true);
                AppMethodBeat.o(23478);
                return;
            }
            aS(rVar.rAx, false);
            AppMethodBeat.o(23478);
            return;
        }
        if (qVar instanceof w) {
            bg.azz().b(538, this);
            w wVar = (w) qVar;
            if (i2 == 0 && i3 == 0) {
                aT(wVar.rAz, true);
                AppMethodBeat.o(23478);
                return;
            }
            aT(wVar.rAz, false);
        }
        AppMethodBeat.o(23478);
    }

    private static void aS(String str, boolean z) {
        AppMethodBeat.i(23479);
        Log.i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", str, Boolean.valueOf(z));
        aap aap = new aap();
        aap.ehC.dDe = 8;
        aap.ehC.isSuccess = z;
        aap.ehC.dGL = str;
        EventCenter.instance.publish(aap);
        AppMethodBeat.o(23479);
    }

    private static void aT(String str, boolean z) {
        AppMethodBeat.i(23480);
        Log.i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", str, Boolean.valueOf(z));
        aap aap = new aap();
        aap.ehC.dDe = 5;
        aap.ehC.isSuccess = z;
        aap.ehC.dGL = str;
        EventCenter.instance.publish(aap);
        AppMethodBeat.o(23480);
    }

    static /* synthetic */ void aU(String str, boolean z) {
        AppMethodBeat.i(23481);
        Log.i("MicroMsg.WearHardDeviceLogic", "publish register response deviceId=%s | isSuccess=%b", str, Boolean.valueOf(z));
        aap aap = new aap();
        aap.ehC.dDe = 2;
        aap.ehC.isSuccess = z;
        aap.ehC.dGL = str;
        EventCenter.instance.publish(aap);
        AppMethodBeat.o(23481);
    }
}
