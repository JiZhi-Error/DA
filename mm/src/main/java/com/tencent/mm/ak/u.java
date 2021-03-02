package com.tencent.mm.ak;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class u implements e {
    private final f iMK;

    public u(f fVar) {
        this.iMK = fVar;
    }

    @Override // com.tencent.mm.network.e
    public final byte[] aZa() {
        AppMethodBeat.i(132359);
        try {
            byte[] aZa = this.iMK.aZa();
            AppMethodBeat.o(132359);
            return aZa;
        } catch (RemoteException e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132359);
            return null;
        }
    }

    @Override // com.tencent.mm.network.e
    public final byte[] qe(int i2) {
        AppMethodBeat.i(132360);
        try {
            byte[] qe = this.iMK.qe(i2);
            AppMethodBeat.o(132360);
            return qe;
        } catch (RemoteException e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132360);
            return null;
        }
    }

    @Override // com.tencent.mm.network.e
    public final int getUin() {
        int i2 = 0;
        AppMethodBeat.i(132361);
        try {
            i2 = this.iMK.getUin();
            AppMethodBeat.o(132361);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132361);
        }
        return i2;
    }

    @Override // com.tencent.mm.network.e
    public final String getUsername() {
        AppMethodBeat.i(132362);
        try {
            String username = this.iMK.getUsername();
            AppMethodBeat.o(132362);
            return username;
        } catch (RemoteException e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132362);
            return null;
        }
    }

    @Override // com.tencent.mm.network.e
    public final boolean aZb() {
        boolean z = false;
        AppMethodBeat.i(132363);
        try {
            z = this.iMK.aZb();
            AppMethodBeat.o(132363);
        } catch (Exception e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132363);
        }
        return z;
    }

    @Override // com.tencent.mm.network.e
    public final void setUsername(String str) {
        AppMethodBeat.i(132364);
        try {
            this.iMK.setUsername(str);
            AppMethodBeat.o(132364);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132364);
        }
    }

    @Override // com.tencent.mm.network.e
    public final void a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2) {
        AppMethodBeat.i(132365);
        try {
            this.iMK.a(bArr, bArr2, bArr3, i2);
            AppMethodBeat.o(132365);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132365);
        }
    }

    @Override // com.tencent.mm.network.e
    public final void reset() {
        AppMethodBeat.i(132366);
        try {
            this.iMK.reset();
            AppMethodBeat.o(132366);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132366);
        }
    }

    public final String toString() {
        AppMethodBeat.i(132367);
        String str = (((((("RAccInfo:\n" + "|-uin     =" + getUin() + "\n") + "|-user    =" + getUsername() + "\n") + "|-singlesession =" + Util.dumpHex(qe(1)) + "\n") + "|-clientsession =" + Util.dumpHex(qe(2)) + "\n") + "|-serversession =" + Util.dumpHex(qe(3)) + "\n") + "|-ecdhkey =" + Util.dumpHex(aZc()) + "\n") + "`-cookie  =" + Util.dumpHex(aZa());
        AppMethodBeat.o(132367);
        return str;
    }

    @Override // com.tencent.mm.network.e
    public final void i(String str, byte[] bArr) {
        AppMethodBeat.i(132368);
        try {
            this.iMK.i(str, bArr);
            AppMethodBeat.o(132368);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132368);
        }
    }

    @Override // com.tencent.mm.network.e
    public final byte[] MC(String str) {
        AppMethodBeat.i(132369);
        try {
            byte[] MC = this.iMK.MC(str);
            AppMethodBeat.o(132369);
            return MC;
        } catch (RemoteException e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132369);
            return null;
        }
    }

    @Override // com.tencent.mm.network.e
    public final byte[] aZc() {
        AppMethodBeat.i(132370);
        try {
            byte[] aZc = this.iMK.aZc();
            AppMethodBeat.o(132370);
            return aZc;
        } catch (RemoteException e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132370);
            return null;
        }
    }

    @Override // com.tencent.mm.network.e
    public final void setForeground(boolean z) {
        AppMethodBeat.i(132371);
        try {
            this.iMK.setForeground(z);
            AppMethodBeat.o(132371);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132371);
        }
    }

    @Override // com.tencent.mm.network.e
    public final boolean isForeground() {
        boolean z = true;
        AppMethodBeat.i(132372);
        try {
            z = this.iMK.isForeground();
            AppMethodBeat.o(132372);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132372);
        }
        return z;
    }

    @Override // com.tencent.mm.network.e
    public final String aZd() {
        AppMethodBeat.i(132373);
        try {
            String aZd = this.iMK.aZd();
            AppMethodBeat.o(132373);
            return aZd;
        } catch (RemoteException e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132373);
            return null;
        }
    }

    @Override // com.tencent.mm.network.e
    public final byte[] aZe() {
        AppMethodBeat.i(132374);
        try {
            byte[] aZe = this.iMK.aZe();
            AppMethodBeat.o(132374);
            return aZe;
        } catch (Exception e2) {
            Log.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132374);
            return null;
        }
    }

    @Override // com.tencent.mm.network.e
    public final int al(byte[] bArr) {
        AppMethodBeat.i(132375);
        try {
            int al = this.iMK.al(bArr);
            AppMethodBeat.o(132375);
            return al;
        } catch (Exception e2) {
            Log.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132375);
            return -6;
        }
    }

    @Override // com.tencent.mm.network.e
    public final void setUin(int i2) {
        AppMethodBeat.i(132376);
        try {
            this.iMK.setUin(i2);
            AppMethodBeat.o(132376);
        } catch (Exception e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132376);
        }
    }

    @Override // com.tencent.mm.network.e
    public final void h(int i2, byte[] bArr) {
        AppMethodBeat.i(132377);
        try {
            this.iMK.h(i2, bArr);
            AppMethodBeat.o(132377);
        } catch (Exception e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132377);
        }
    }

    @Override // com.tencent.mm.network.e
    public final void b(int i2, byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(132378);
        try {
            this.iMK.b(i2, bArr, bArr2);
            AppMethodBeat.o(132378);
        } catch (Exception e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132378);
        }
    }

    @Override // com.tencent.mm.network.e
    public final byte[] MD(String str) {
        AppMethodBeat.i(132379);
        try {
            byte[] MD = this.iMK.MD(str);
            AppMethodBeat.o(132379);
            return MD;
        } catch (Exception e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132379);
            return null;
        }
    }

    @Override // com.tencent.mm.network.e
    public final void aZf() {
        AppMethodBeat.i(132380);
        try {
            this.iMK.aZf();
            AppMethodBeat.o(132380);
        } catch (Exception e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132380);
        }
    }

    @Override // com.tencent.mm.network.e
    public final void aZg() {
        AppMethodBeat.i(132381);
        try {
            this.iMK.aZg();
            AppMethodBeat.o(132381);
        } catch (Exception e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132381);
        }
    }

    @Override // com.tencent.mm.network.e
    public final byte[] ME(String str) {
        AppMethodBeat.i(132382);
        try {
            byte[] ME = this.iMK.ME(str);
            AppMethodBeat.o(132382);
            return ME;
        } catch (Exception e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132382);
            return null;
        }
    }

    @Override // com.tencent.mm.network.e
    public final byte[] MF(String str) {
        AppMethodBeat.i(132383);
        try {
            byte[] MF = this.iMK.MF(str);
            AppMethodBeat.o(132383);
            return MF;
        } catch (Exception e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132383);
            return null;
        }
    }

    @Override // com.tencent.mm.network.e
    public final boolean MG(String str) {
        boolean z = false;
        AppMethodBeat.i(132384);
        try {
            z = this.iMK.MG(str);
            AppMethodBeat.o(132384);
        } catch (Exception e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132384);
        }
        return z;
    }

    @Override // com.tencent.mm.network.e
    public final int am(byte[] bArr) {
        AppMethodBeat.i(197062);
        try {
            int am = this.iMK.am(bArr);
            AppMethodBeat.o(197062);
            return am;
        } catch (Exception e2) {
            Log.e("MicroMsg.RAccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(197062);
            return -1;
        }
    }
}
