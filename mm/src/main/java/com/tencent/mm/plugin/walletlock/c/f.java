package com.tencent.mm.plugin.walletlock.c;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.g.a.zw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.fingerprint.a.a;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class f {
    public IListener IwP = new c();
    public IListener IwQ = new IListener<zw>() {
        /* class com.tencent.mm.plugin.walletlock.c.f.AnonymousClass1 */

        {
            AppMethodBeat.i(161151);
            this.__eventId = zw.class.getName().hashCode();
            AppMethodBeat.o(161151);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zw zwVar) {
            boolean z;
            long fUN;
            boolean z2;
            long fUN2;
            AppMethodBeat.i(129911);
            zw zwVar2 = zwVar;
            Log.i("MicroMsg.WalletLockInitTask", "alvinluo wallet lock protect request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", Integer.valueOf(zwVar2.egz.egB), Boolean.valueOf(i.INSTANCE.fVz()), Boolean.valueOf(i.INSTANCE.fVA()));
            switch (zwVar2.egz.egB) {
                case 0:
                    if (!(zwVar2.egz.activity instanceof GestureGuardLogicUI) && !(zwVar2.egz.activity instanceof FingerprintWalletLockUI)) {
                        g gVar = g.instance;
                        if (zwVar2 == null) {
                            z2 = false;
                        } else if (!i.INSTANCE.fVz()) {
                            Log.i("MicroMsg.WalletLockManager", "alvinluo current wallet lock type: %d", Integer.valueOf(gVar.mType));
                            if (gVar.mType == 2) {
                                fUN2 = a.fUN();
                            } else if (gVar.mType == 1) {
                                fUN2 = d.fUN();
                            } else {
                                z2 = false;
                            }
                            long elapsedRealtime = (SystemClock.elapsedRealtime() - fUN2) / 1000;
                            Log.i("MicroMsg.WalletLockManager", "alvinluo lastVerifyOkTime: %d, elapsedRealTime: %d, pastTime: %d, PREVENT_INPUT_PWD_SECONDS: %d", Long.valueOf(fUN2), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(elapsedRealtime), Integer.valueOf(com.tencent.mm.plugin.walletlock.gesture.a.a.Ivw));
                            if (fUN2 == -1 || elapsedRealtime >= ((long) com.tencent.mm.plugin.walletlock.gesture.a.a.Ivw) || g.instance.fUG()) {
                                Log.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
                                z2 = true;
                            } else {
                                Log.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                                i.INSTANCE.j(new WeakReference<>(zwVar2.egz.activity));
                                z2 = false;
                            }
                        } else {
                            Log.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                            i.INSTANCE.j(new WeakReference<>(zwVar2.egz.activity));
                            i.INSTANCE.yH(false);
                            z2 = false;
                        }
                        if (!z2) {
                            zwVar2.egA.data = 16;
                            break;
                        } else {
                            zwVar2.egA.data = 17;
                            break;
                        }
                    } else {
                        zwVar2.egA.data = 16;
                        break;
                    }
                    break;
                case 1:
                    if (!(zwVar2.egz.activity instanceof GestureGuardLogicUI) && !(zwVar2.egz.activity instanceof FingerprintWalletLockUI)) {
                        g gVar2 = g.instance;
                        if (zwVar2 == null) {
                            z = false;
                        } else if (i.INSTANCE.fVz()) {
                            Log.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                            i.INSTANCE.yH(false);
                            i.INSTANCE.yI(false);
                            z = false;
                        } else if (i.INSTANCE.fVA()) {
                            Log.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
                            i.INSTANCE.yH(false);
                            i.INSTANCE.yI(false);
                            z = false;
                        } else {
                            Log.i("MicroMsg.WalletLockManager", "alvinluo current wallet lock type: %d", Integer.valueOf(gVar2.mType));
                            if (gVar2.mType == 2) {
                                fUN = a.fUN();
                            } else if (gVar2.mType == 1) {
                                fUN = d.fUN();
                            } else {
                                z = false;
                            }
                            i.INSTANCE.j(new WeakReference<>(zwVar2.egz.activity));
                            long elapsedRealtime2 = (SystemClock.elapsedRealtime() - fUN) / 1000;
                            Log.i("MicroMsg.WalletLockManager", "alvinluo lastVerifyOkTime: %d, elapsedRealTime: %d, pastTime: %d, %d", Long.valueOf(fUN), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(elapsedRealtime2), Integer.valueOf(com.tencent.mm.plugin.walletlock.gesture.a.a.Ivw));
                            if (fUN == -1 || elapsedRealtime2 >= ((long) com.tencent.mm.plugin.walletlock.gesture.a.a.Ivw) || g.instance.fUG()) {
                                Log.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
                                z = true;
                            } else {
                                Log.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                                z = false;
                            }
                        }
                        if (!z) {
                            zwVar2.egA.data = 16;
                            break;
                        } else {
                            zwVar2.egA.data = 17;
                            break;
                        }
                    } else {
                        zwVar2.egA.data = 16;
                        break;
                    }
                    break;
            }
            zwVar2.egz.activity = null;
            Log.i("MicroMsg.WalletLockInitTask", "alvinluo protect result: %s", zwVar2.egA.data);
            AppMethodBeat.o(129911);
            return false;
        }
    };
    private IListener IwR = new IListener<zw>() {
        /* class com.tencent.mm.plugin.walletlock.c.f.AnonymousClass2 */

        {
            AppMethodBeat.i(161152);
            this.__eventId = zw.class.getName().hashCode();
            AppMethodBeat.o(161152);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zw zwVar) {
            AppMethodBeat.i(129913);
            boolean a2 = a(zwVar);
            AppMethodBeat.o(129913);
            return a2;
        }

        private static boolean a(zw zwVar) {
            AppMethodBeat.i(129912);
            Log.v("MicroMsg.WalletLockInitTask", "alvinluo gestureprotectListener request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", Integer.valueOf(zwVar.egz.egB), Boolean.valueOf(i.INSTANCE.fVz()), Boolean.valueOf(i.INSTANCE.fVA()));
            switch (zwVar.egz.egB) {
                case 0:
                    if (!(zwVar.egz.activity instanceof GestureGuardLogicUI)) {
                        if (i.INSTANCE.fVz()) {
                            Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                            zwVar.egA.data = 16;
                            i.INSTANCE.j(new WeakReference<>(zwVar.egz.activity));
                            i.INSTANCE.yH(false);
                            break;
                        } else {
                            long fUN = d.fUN();
                            long elapsedRealtime = (SystemClock.elapsedRealtime() - fUN) / 1000;
                            if (fUN != -1 && elapsedRealtime < ((long) com.tencent.mm.plugin.walletlock.gesture.a.a.Ivw) && (!b.fUW() || !b.fUV())) {
                                Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                                zwVar.egA.data = 16;
                                i.INSTANCE.j(new WeakReference<>(zwVar.egz.activity));
                                break;
                            } else {
                                Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
                                zwVar.egA.data = 17;
                                break;
                            }
                        }
                    } else {
                        Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                        zwVar.egA.data = 16;
                        break;
                    }
                    break;
                case 1:
                    if (!(zwVar.egz.activity instanceof GestureGuardLogicUI)) {
                        if (!i.INSTANCE.fVz()) {
                            if (!i.INSTANCE.fVA()) {
                                long fUN2 = d.fUN();
                                long elapsedRealtime2 = (SystemClock.elapsedRealtime() - fUN2) / 1000;
                                if ((fUN2 == -1 || elapsedRealtime2 >= ((long) com.tencent.mm.plugin.walletlock.gesture.a.a.Ivw) || b.fUW()) && b.fUV()) {
                                    Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
                                    zwVar.egA.data = 17;
                                } else {
                                    Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                                    zwVar.egA.data = 16;
                                }
                                i.INSTANCE.j(new WeakReference<>(zwVar.egz.activity));
                                break;
                            } else {
                                Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
                                i.INSTANCE.yH(false);
                                i.INSTANCE.yI(false);
                                zwVar.egA.data = 18;
                                break;
                            }
                        } else {
                            Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                            i.INSTANCE.yH(false);
                            i.INSTANCE.yI(false);
                            zwVar.egA.data = 16;
                            break;
                        }
                    } else {
                        Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                        zwVar.egA.data = 16;
                        break;
                    }
                    break;
                case 2:
                    zwVar.egA.data = Boolean.valueOf(e.fUV());
                    break;
                case 3:
                    zwVar.egA.data = Boolean.valueOf(b.fUW());
                    break;
                case 4:
                    i.INSTANCE.fVB();
                    break;
            }
            zwVar.egz.activity = null;
            AppMethodBeat.o(129912);
            return false;
        }
    };
    public IListener IwS = new IListener<ym>() {
        /* class com.tencent.mm.plugin.walletlock.c.f.AnonymousClass3 */

        {
            AppMethodBeat.i(161153);
            this.__eventId = ym.class.getName().hashCode();
            AppMethodBeat.o(161153);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ym ymVar) {
            AppMethodBeat.i(129915);
            boolean a2 = a(ymVar);
            AppMethodBeat.o(129915);
            return a2;
        }

        private static boolean a(ym ymVar) {
            AppMethodBeat.i(129914);
            czl czl = ymVar.eeL.eeM;
            g gVar = g.instance;
            g.fUM();
            boolean b2 = e.b(czl);
            if (b2) {
                Log.i("MicroMsg.WalletLockInitTask", "tom update PatternLockInfo, sign_len:%d,valid:%b,status:%d,ver:%d", Integer.valueOf(czl.MEK.getILen()), Boolean.valueOf(b2), Integer.valueOf(czl.MEL), Integer.valueOf(czl.MEJ));
                d.a(czl);
            } else {
                Log.w("MicroMsg.WalletLockInitTask", "UserInfoExt.PatternLockInfo is null or invalid.");
            }
            boolean fUV = e.fUV();
            Log.i("MicroMsg.WalletLockInitTask", "alvinluo after update gesture server info, isUserSetGesturePwd: %b", Boolean.valueOf(fUV));
            b.yD(fUV);
            ((com.tencent.mm.plugin.walletlock.a.b) g.af(com.tencent.mm.plugin.walletlock.a.b.class)).init();
            AppMethodBeat.o(129914);
            return false;
        }
    };

    public f() {
        AppMethodBeat.i(129916);
        AppMethodBeat.o(129916);
    }
}
