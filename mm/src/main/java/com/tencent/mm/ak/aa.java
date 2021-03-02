package com.tencent.mm.ak;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class aa {
    public static b iNn = null;

    public interface a {
        int a(int i2, int i3, String str, d dVar, q qVar);
    }

    public interface b {
        t azA();
    }

    public static boolean aZx() {
        AppMethodBeat.i(132489);
        if (iNn == null) {
            Log.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            AppMethodBeat.o(132489);
            return false;
        } else if (iNn.azA() == null) {
            Log.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            AppMethodBeat.o(132489);
            return false;
        } else {
            AppMethodBeat.o(132489);
            return true;
        }
    }

    public static void a(q qVar) {
        AppMethodBeat.i(132490);
        if (iNn == null) {
            Log.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            AppMethodBeat.o(132490);
        } else if (iNn.azA() == null) {
            Log.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            AppMethodBeat.o(132490);
        } else if (qVar == null) {
            Log.e("MicroMsg.RunCgi", "ERROR: Param scene  == null.");
            AppMethodBeat.o(132490);
        } else {
            iNn.azA().a(qVar);
            AppMethodBeat.o(132490);
        }
    }

    public static q a(d dVar, a aVar, boolean z) {
        AppMethodBeat.i(259567);
        q a2 = a(dVar, aVar, z, null);
        AppMethodBeat.o(259567);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public static final class c implements a, com.tencent.mm.vending.e.a {
        private a iNw;

        public c(a aVar) {
            this.iNw = aVar;
        }

        @Override // com.tencent.mm.vending.e.a
        public final void dead() {
            this.iNw = null;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, d dVar, q qVar) {
            AppMethodBeat.i(132488);
            if (this.iNw != null) {
                int a2 = this.iNw.a(i2, i3, str, dVar, qVar);
                AppMethodBeat.o(132488);
                return a2;
            }
            AppMethodBeat.o(132488);
            return TXLiteAVCode.ERR_SERVER_INFO_UNPACKING_ERROR;
        }
    }

    public static q a(d dVar, a aVar, boolean z, com.tencent.mm.vending.e.b bVar) {
        AppMethodBeat.i(132494);
        c cVar = new c(aVar);
        if (aVar == null) {
            cVar = null;
        }
        if (!(bVar == null || cVar == null)) {
            bVar.keep(cVar);
        }
        q b2 = b(dVar, cVar, z);
        AppMethodBeat.o(132494);
        return b2;
    }

    private static q b(final d dVar, final a aVar, final boolean z) {
        AppMethodBeat.i(197076);
        if (iNn == null) {
            Log.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            AppMethodBeat.o(197076);
            return null;
        } else if (iNn.azA() == null) {
            Log.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            AppMethodBeat.o(197076);
            return null;
        } else if (dVar == null) {
            Log.e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
            AppMethodBeat.o(197076);
            return null;
        } else {
            AnonymousClass1 r1 = new q() {
                /* class com.tencent.mm.ak.aa.AnonymousClass1 */
                i gNh = null;
                private m iLI = new m() {
                    /* class com.tencent.mm.ak.aa.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.network.m
                    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
                        AppMethodBeat.i(132479);
                        if (AnonymousClass1.this.iNp != 2) {
                            AnonymousClass1.this.iNq.stopTimer();
                            AnonymousClass1.this.iNp = 1;
                            aa.a(z, aVar, i3, i4, str, dVar, AnonymousClass1.this.iNo);
                        } else {
                            Log.w("MicroMsg.RunCgi", "Has been callback by protect:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(AnonymousClass1.this.iNo.hashCode()), Integer.valueOf(AnonymousClass1.this.getType()), Long.valueOf(Util.nowMilliSecond() - AnonymousClass1.this.startTime), Integer.valueOf(i3), Integer.valueOf(i4), str);
                        }
                        AnonymousClass1.this.gNh.onSceneEnd(i3, i4, str, AnonymousClass1.this.iNo);
                        Log.i("MicroMsg.RunCgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(AnonymousClass1.this.iNo.hashCode()), Integer.valueOf(AnonymousClass1.this.getType()), Long.valueOf(Util.nowMilliSecond() - AnonymousClass1.this.startTime), Integer.valueOf(i3), Integer.valueOf(i4), str);
                        AppMethodBeat.o(132479);
                    }
                };
                final q iNo = this;
                int iNp = 0;
                MTimerHandler iNq = new MTimerHandler(aa.iNn.azA().iMx.getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                    /* class com.tencent.mm.ak.aa.AnonymousClass1.AnonymousClass2 */

                    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                    public final boolean onTimerExpired() {
                        AppMethodBeat.i(132480);
                        Log.w("MicroMsg.RunCgi", "Warning: Never should go here. usr canceled:%b Or NetsceneQueue Not call onGYNetEnd! %d func:%d time:%d", Boolean.valueOf(AnonymousClass1.this.iNo.isCanceled()), Integer.valueOf(AnonymousClass1.this.iNo.hashCode()), Integer.valueOf(AnonymousClass1.this.getType()), Long.valueOf(Util.nowMilliSecond() - AnonymousClass1.this.startTime));
                        if (AnonymousClass1.this.iNo.isCanceled()) {
                            AppMethodBeat.o(132480);
                        } else if (AnonymousClass1.this.iNp == 1) {
                            AppMethodBeat.o(132480);
                        } else {
                            AnonymousClass1.this.iNp = 2;
                            aa.a(z, aVar, 3, -1, "", dVar, AnonymousClass1.this.iNo);
                            AppMethodBeat.o(132480);
                        }
                        return false;
                    }

                    public final String toString() {
                        AppMethodBeat.i(132481);
                        String str = super.toString() + "|protectNotCallback";
                        AppMethodBeat.o(132481);
                        return str;
                    }
                }, false);
                final long startTime = Util.nowMilliSecond();

                {
                    AppMethodBeat.i(132482);
                    AppMethodBeat.o(132482);
                }

                @Override // com.tencent.mm.ak.q
                public final int getType() {
                    AppMethodBeat.i(132483);
                    int type = dVar.getType();
                    AppMethodBeat.o(132483);
                    return type;
                }

                @Override // com.tencent.mm.ak.q
                public final int doScene(g gVar, i iVar) {
                    AppMethodBeat.i(132484);
                    this.gNh = iVar;
                    int dispatch = dispatch(gVar, dVar, this.iLI);
                    Log.i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", Integer.valueOf(this.iNo.hashCode()), Integer.valueOf(getType()), Integer.valueOf(dispatch), Long.valueOf(Util.nowMilliSecond() - this.startTime));
                    if (aVar != null) {
                        if (dispatch < 0) {
                            aa.a(z, aVar, 3, -1, "", dVar, this.iNo);
                        } else {
                            this.iNq.startTimer(Util.MILLSECONDS_OF_MINUTE);
                        }
                    }
                    AppMethodBeat.o(132484);
                    return dispatch;
                }
            };
            if (iNn.azA().a(r1, 0)) {
                AppMethodBeat.o(197076);
                return r1;
            }
            AppMethodBeat.o(197076);
            return null;
        }
    }

    public static d d(d dVar) {
        AppMethodBeat.i(132491);
        a(dVar, null, false, null);
        AppMethodBeat.o(132491);
        return dVar;
    }

    public static d a(d dVar, a aVar) {
        AppMethodBeat.i(132492);
        a(dVar, aVar, false, null);
        AppMethodBeat.o(132492);
        return dVar;
    }

    static /* synthetic */ int a(boolean z, final a aVar, final int i2, final int i3, final String str, final d dVar, final q qVar) {
        AppMethodBeat.i(132496);
        if (aVar != null) {
            if (z) {
                iNn.azA().iMx.postToWorker(new Runnable() {
                    /* class com.tencent.mm.ak.aa.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(132485);
                        aVar.a(i2, i3, str, dVar, qVar);
                        AppMethodBeat.o(132485);
                    }

                    public final String toString() {
                        AppMethodBeat.i(132486);
                        String str = super.toString() + "|tryCallback";
                        AppMethodBeat.o(132486);
                        return str;
                    }
                });
            } else {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ak.aa.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(132487);
                        aVar.a(i2, i3, str, dVar, qVar);
                        AppMethodBeat.o(132487);
                    }
                });
            }
        }
        AppMethodBeat.o(132496);
        return 0;
    }
}
