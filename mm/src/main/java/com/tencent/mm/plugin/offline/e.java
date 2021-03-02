package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.b;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class e extends a<b> {
    public String AIf = "";
    private i.a AIg = new i.a() {
        /* class com.tencent.mm.plugin.offline.e.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.offline.i.a
        public final void ezg() {
            AppMethodBeat.i(66205);
            e.this.onChange();
            AppMethodBeat.o(66205);
        }
    };

    public final void onChange() {
        b bVar;
        AppMethodBeat.i(66206);
        if (this.AIc == null) {
            AppMethodBeat.o(66206);
            return;
        }
        for (int i2 = 0; i2 < this.AIc.size(); i2++) {
            WeakReference weakReference = (WeakReference) this.AIc.get(i2);
            if (!(weakReference == null || (bVar = (b) weakReference.get()) == null)) {
                bVar.ctk();
            }
        }
        AppMethodBeat.o(66206);
    }

    public e() {
        AppMethodBeat.i(66207);
        k.ezn();
        if (k.ezq() != null) {
            k.ezn();
            k.ezq().AIJ = this.AIg;
        }
        AppMethodBeat.o(66207);
    }

    private static void ezd() {
        AppMethodBeat.i(66208);
        k.ezn();
        k.ezq().hF(1, 1);
        AppMethodBeat.o(66208);
    }

    private static void eze() {
        AppMethodBeat.i(66209);
        k.ezn();
        k.ezq().TV(2);
        AppMethodBeat.o(66209);
    }

    private static void b(int i2, int i3, int i4, String str) {
        AppMethodBeat.i(66210);
        o oVar = new o(i2, i3, i4, str);
        g.aAi();
        g.aAg().hqi.a(oVar, 0);
        AppMethodBeat.o(66210);
    }

    public final String A(int i2, int i3, String str) {
        AppMethodBeat.i(66211);
        Log.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", Integer.valueOf(i2), Integer.valueOf(i3), Util.getStack().toString());
        String B = B(i2, i3, str);
        AppMethodBeat.o(66211);
        return B;
    }

    public final String B(int i2, int i3, String str) {
        String concat;
        int i4 = 0;
        AppMethodBeat.i(66212);
        int ezf = ezf();
        if (ezf > 0) {
            if (ezf < k.AIY) {
                Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount < %s", Integer.valueOf(k.AIY));
                eze();
            }
            k.ezn();
            String TX = k.TX(196617);
            if (TextUtils.isEmpty(TX)) {
                Log.e("MicroMsg.OfflineCodesMgr", "generateKey_V3 cn is null, the csr is not exist! cn:".concat(String.valueOf(TX)));
                AppMethodBeat.o(66212);
                return "";
            }
            b.hhj();
            String token = b.getToken(TX);
            if (TextUtils.isEmpty(token)) {
                ezd();
                Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null");
                AppMethodBeat.o(66212);
                return "";
            }
            if (token != null) {
                Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code length : %s ext_business_attach %s %s", Integer.valueOf(token.length()), str, token);
            }
            b(ezf - 1, i2, i3, str);
            Log.i("MicroMsg.OfflineCodesMgr", "doNetSceneShowCode count " + (ezf - 1));
            LinkedList<a.C1566a> aJm = a.aJm(a.eAA());
            if (aJm == null || aJm.size() == 0) {
                Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 cardList is null");
                ezd();
                AppMethodBeat.o(66212);
                return "";
            } else if (token == null || !a.isNumeric(token)) {
                Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null or is not isNumeric");
                AppMethodBeat.o(66212);
                return "";
            } else {
                long longValue = Long.valueOf(token, 10).longValue();
                long j2 = 0;
                while (i4 < aJm.size()) {
                    a.C1566a aVar = aJm.get(i4);
                    if (!(aVar == null || aVar.ANo == null || !aVar.ANo.equals(this.AIf))) {
                        j2 = (long) aVar.ANn;
                    }
                    i4++;
                }
                String valueOf = String.valueOf((j2 << 48) | longValue);
                if (valueOf.length() == 15) {
                    valueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(valueOf));
                } else if (valueOf.length() == 14) {
                    valueOf = "00".concat(String.valueOf(valueOf));
                } else if (valueOf.length() == 13) {
                    valueOf = "000".concat(String.valueOf(valueOf));
                } else if (valueOf.length() == 12) {
                    valueOf = "0000".concat(String.valueOf(valueOf));
                }
                if (!TextUtils.isEmpty(a.getTokenPin())) {
                    concat = a.getTokenPin() + valueOf;
                } else {
                    concat = "12".concat(String.valueOf(valueOf));
                }
                AppMethodBeat.o(66212);
                return concat;
            }
        } else {
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[3];
            objArr[0] = 2;
            objArr[1] = Integer.valueOf(a.isAppOnForeground(MMApplicationContext.getContext()) ? 0 : 1);
            if (NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
                i4 = 1;
            }
            objArr[2] = Integer.valueOf(i4);
            hVar.a(14163, objArr);
            h.INSTANCE.idkeyStat(135, 29, 1, true);
            if (NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
                h.INSTANCE.idkeyStat(135, 31, 1, true);
            } else {
                h.INSTANCE.idkeyStat(135, 30, 1, true);
            }
            ezd();
            Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount is 0");
            AppMethodBeat.o(66212);
            return "";
        }
    }

    public static int ezf() {
        AppMethodBeat.i(66213);
        k.ezn();
        k.ezq();
        int ezm = i.ezm();
        AppMethodBeat.o(66213);
        return ezm;
    }
}
