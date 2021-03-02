package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.k;
import com.tencent.mm.network.n;
import com.tencent.mm.network.q;
import com.tencent.mm.network.t;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class v implements g {
    public final h iML;
    private u iMM;

    public v(h hVar) {
        this.iML = hVar;
    }

    @Override // com.tencent.mm.network.g
    public final int a(t tVar, n nVar) {
        AppMethodBeat.i(132385);
        try {
            int a2 = this.iML.a(tVar, nVar);
            AppMethodBeat.o(132385);
            return a2;
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "remote dispatcher lost, send failed, %s", e2);
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132385);
            return -1;
        }
    }

    @Override // com.tencent.mm.network.g
    public final String getNetworkServerIp() {
        AppMethodBeat.i(132386);
        try {
            String networkServerIp = this.iML.getNetworkServerIp();
            AppMethodBeat.o(132386);
            return networkServerIp;
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", e2);
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132386);
            return null;
        }
    }

    @Override // com.tencent.mm.network.g
    public final String[] getIPsString(boolean z) {
        AppMethodBeat.i(132387);
        try {
            String[] iPsString = this.iML.getIPsString(z);
            AppMethodBeat.o(132387);
            return iPsString;
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", e2);
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132387);
            return null;
        }
    }

    @Override // com.tencent.mm.network.g
    public final void cancel(int i2) {
        AppMethodBeat.i(132388);
        try {
            this.iML.cancel(i2);
            AppMethodBeat.o(132388);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "cancel remote rr failed, netid=%d, %s", Integer.valueOf(i2), e2);
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132388);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void reset() {
        AppMethodBeat.i(132389);
        try {
            this.iML.reset();
            AppMethodBeat.o(132389);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "reset failed, core service down, %s", e2);
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132389);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i2, int i3, String str3, String str4) {
        AppMethodBeat.i(132390);
        try {
            this.iML.a(z, str, str2, iArr, iArr2, i2, i3, str3, str4);
            AppMethodBeat.o(132390);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "dkidc setIDCHostInfo ip failed, core service down, %s", e2);
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132390);
        }
    }

    @Override // com.tencent.mm.network.g
    public final e aZh() {
        AppMethodBeat.i(132391);
        try {
            if (this.iMM == null) {
                this.iMM = new u(this.iML.bjw());
            }
            u uVar = this.iMM;
            AppMethodBeat.o(132391);
            return uVar;
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "getAccInfo failed, core service down, %s", e2);
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132391);
            return null;
        }
    }

    @Override // com.tencent.mm.network.g
    public final void a(b bVar) {
        AppMethodBeat.i(132392);
        try {
            this.iML.a(bVar);
            AppMethodBeat.o(132392);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132392);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void fy(boolean z) {
        AppMethodBeat.i(132393);
        try {
            this.iML.fy(z);
            AppMethodBeat.o(132393);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "change active status failed, core service down, %s", e2);
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132393);
        }
    }

    @Override // com.tencent.mm.network.g
    public final boolean aYT() {
        boolean z = true;
        AppMethodBeat.i(132394);
        try {
            z = this.iML.aYT();
            AppMethodBeat.o(132394);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "core service down, guess network stable, %s", e2);
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132394);
        }
        return z;
    }

    @Override // com.tencent.mm.network.g
    public final k aZi() {
        AppMethodBeat.i(132395);
        try {
            k bjy = this.iML.bjy();
            AppMethodBeat.o(132395);
            return bjy;
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132395);
            return null;
        }
    }

    @Override // com.tencent.mm.network.g
    public final void a(ab abVar) {
        AppMethodBeat.i(132396);
        try {
            this.iML.a(abVar);
            AppMethodBeat.o(132396);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132396);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void MH(String str) {
        AppMethodBeat.i(132397);
        try {
            this.iML.MH(str);
            AppMethodBeat.o(132397);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "ipxxStatistics remote call error, %s", e2);
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132397);
        }
    }

    @Override // com.tencent.mm.network.g
    public final int getHostByName(String str, List<String> list) {
        AppMethodBeat.i(132398);
        try {
            int hostByName = this.iML.getHostByName(str, list);
            AppMethodBeat.o(132398);
            return hostByName;
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132398);
            return -1;
        }
    }

    @Override // com.tencent.mm.network.g
    public final int a(String str, boolean z, List<String> list) {
        AppMethodBeat.i(132399);
        try {
            int a2 = this.iML.a(str, z, list);
            AppMethodBeat.o(132399);
            return a2;
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132399);
            return -1;
        }
    }

    @Override // com.tencent.mm.network.g
    public final void setHostInfo(String[] strArr, String[] strArr2, int[] iArr) {
        AppMethodBeat.i(132400);
        try {
            this.iML.setHostInfo(strArr, strArr2, iArr);
            AppMethodBeat.o(132400);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132400);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void addHostInfo(String[] strArr, String[] strArr2, int[] iArr) {
        AppMethodBeat.i(132401);
        try {
            this.iML.addHostInfo(strArr, strArr2, iArr);
            AppMethodBeat.o(132401);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132401);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void a(int i2, String str, int i3, boolean z) {
        AppMethodBeat.i(132402);
        try {
            this.iML.a(i2, str, i3, z);
            AppMethodBeat.o(132402);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132402);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void d(String str, long j2, String str2) {
        AppMethodBeat.i(132403);
        try {
            this.iML.d(str, j2, str2);
            AppMethodBeat.o(132403);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132403);
        }
    }

    @Override // com.tencent.mm.network.g
    public final String getIspId() {
        AppMethodBeat.i(132404);
        try {
            String ispId = this.iML.getIspId();
            AppMethodBeat.o(132404);
            return ispId;
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132404);
            return null;
        }
    }

    @Override // com.tencent.mm.network.g
    public final void setSignallingStrategy(long j2, long j3) {
        AppMethodBeat.i(132405);
        try {
            this.iML.setSignallingStrategy(j2, j3);
            AppMethodBeat.o(132405);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132405);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void keepSignalling() {
        AppMethodBeat.i(132406);
        try {
            this.iML.keepSignalling();
            AppMethodBeat.o(132406);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132406);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void stopSignalling() {
        AppMethodBeat.i(132407);
        try {
            this.iML.stopSignalling();
            AppMethodBeat.o(132407);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132407);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void a(q qVar) {
        AppMethodBeat.i(132408);
        try {
            this.iML.a(qVar);
            AppMethodBeat.o(132408);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132408);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void reportFailIp(String str) {
        AppMethodBeat.i(132409);
        try {
            this.iML.reportFailIp(str);
            AppMethodBeat.o(132409);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132409);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void MI(String str) {
        AppMethodBeat.i(132410);
        try {
            this.iML.MI(str);
            AppMethodBeat.o(132410);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132410);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void fz(boolean z) {
        AppMethodBeat.i(132411);
        try {
            this.iML.fz(z);
            AppMethodBeat.o(132411);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132411);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void fA(boolean z) {
        AppMethodBeat.i(132412);
        try {
            this.iML.fA(z);
            AppMethodBeat.o(132412);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132412);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void fB(boolean z) {
        AppMethodBeat.i(132413);
        try {
            this.iML.fB(z);
            AppMethodBeat.o(132413);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132413);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void aZj() {
        AppMethodBeat.i(132414);
        try {
            this.iML.aZj();
            AppMethodBeat.o(132414);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132414);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void a(j jVar) {
        AppMethodBeat.i(132415);
        try {
            this.iML.a(jVar);
            AppMethodBeat.o(132415);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132415);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void aZk() {
        AppMethodBeat.i(132416);
        try {
            this.iML.aZk();
            AppMethodBeat.o(132416);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132416);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void MJ(String str) {
        AppMethodBeat.i(132417);
        try {
            this.iML.MJ(str);
            AppMethodBeat.o(132417);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132417);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void reportV6Status(boolean z) {
        AppMethodBeat.i(176841);
        try {
            this.iML.reportV6Status(z);
            AppMethodBeat.o(176841);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(176841);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void forceUseV6(boolean z) {
        AppMethodBeat.i(176842);
        try {
            this.iML.forceUseV6(z);
            AppMethodBeat.o(176842);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(176842);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void switchProcessActiveState(boolean z) {
        AppMethodBeat.i(197063);
        try {
            this.iML.switchProcessActiveState(z);
            AppMethodBeat.o(197063);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(197063);
        }
    }

    @Override // com.tencent.mm.network.g
    public final void setDebugHost(String str) {
        AppMethodBeat.i(197064);
        try {
            this.iML.setDebugHost(str);
            AppMethodBeat.o(197064);
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(197064);
        }
    }

    @Override // com.tencent.mm.network.g
    public final String[] aZl() {
        AppMethodBeat.i(197065);
        try {
            String[] aZl = this.iML.aZl();
            AppMethodBeat.o(197065);
            return aZl;
        } catch (Exception e2) {
            Log.e("MicroMsg.RDispatcher", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(197065);
            return null;
        }
    }
}
