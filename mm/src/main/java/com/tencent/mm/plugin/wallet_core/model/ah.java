package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class ah {
    private static ah Ibk = null;
    static ArrayList<l> eN = null;
    cj.a qvw = new cj.a() {
        /* class com.tencent.mm.plugin.wallet_core.model.ah.AnonymousClass1 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(70436);
            String a2 = z.a(aVar.heO.KHn);
            Log.d("MicroMsg.WalletPushNotifyManager", "PayMsg:".concat(String.valueOf(a2)));
            Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
            int i2 = Util.getInt(parseXml.get(".sysmsg.paymsg.PayMsgType"), -1);
            Object[] objArr = new Object[1];
            if (!ah.a(ah.this, i2, parseXml, a2, objArr)) {
                ah.a(i2, parseXml, objArr);
            }
            AppMethodBeat.o(70436);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };

    static /* synthetic */ boolean a(ah ahVar, int i2, Map map, String str, Object[] objArr) {
        AppMethodBeat.i(70444);
        boolean a2 = ahVar.a(i2, map, str, objArr);
        AppMethodBeat.o(70444);
        return a2;
    }

    private ah() {
        AppMethodBeat.i(70439);
        AppMethodBeat.o(70439);
    }

    public static ah fQU() {
        AppMethodBeat.i(70440);
        if (Ibk == null) {
            Ibk = new ah();
        }
        ah ahVar = Ibk;
        AppMethodBeat.o(70440);
        return ahVar;
    }

    private boolean a(final int i2, final Map<String, String> map, String str, Object[] objArr) {
        AppMethodBeat.i(70441);
        if (map == null) {
            Log.w("MicroMsg.WalletPushNotifyManager", "hy: log is null. handle failed");
            AppMethodBeat.o(70441);
            return true;
        } else if (i2 < 0) {
            Log.w("MicroMsg.WalletPushNotifyManager", "hy: paymsgtype error. maybe not found in xml");
            AppMethodBeat.o(70441);
            return true;
        } else {
            Log.i("MicroMsg.WalletPushNotifyManager", "handle paymsg type: %s", Integer.valueOf(i2));
            if (i2 == 12) {
                final int i3 = Util.getInt(map.get(".sysmsg.paymsg.avail_balance"), -1);
                final long j2 = Util.getLong(map.get(".sysmsg.paymsg.balance_version"), -1);
                final long j3 = Util.getLong(map.get(".sysmsg.paymsg.time_out"), 7200);
                f.a(new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"}, new f.a() {
                    /* class com.tencent.mm.plugin.wallet_core.model.ah.AnonymousClass3 */

                    @Override // com.tencent.mm.wallet_core.ui.f.a
                    public final void bb(Map<String, Object> map) {
                        AppMethodBeat.i(70438);
                        if (map != null) {
                            long nullAs = Util.nullAs((Long) map.get("wallet_balance_version"), -1);
                            long nullAs2 = Util.nullAs((Long) map.get("wallet_balance_last_update_time"), -1);
                            if (nullAs2 < 0 || nullAs < 0 || nullAs2 + j3 > Util.currentTicks() || j2 >= nullAs) {
                                f.a(new f.c("wallet_balance_version", Long.valueOf(j2)), new f.c("wallet_balance_last_update_time", Long.valueOf(Util.currentTicks())), new f.c("wallet_balance", Double.valueOf(((double) i3) / 100.0d)));
                                ah.a(i2, map, null);
                                AppMethodBeat.o(70438);
                                return;
                            }
                            Log.w("MicroMsg.WalletPushNotifyManager", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
                        }
                        AppMethodBeat.o(70438);
                    }
                });
                AppMethodBeat.o(70441);
                return true;
            } else if (i2 == 43) {
                w ba = w.ba(map);
                if (ba != null) {
                    objArr[0] = ba;
                }
                w.aVh(str);
                AppMethodBeat.o(70441);
                return false;
            } else {
                AppMethodBeat.o(70441);
                return false;
            }
        }
    }

    public static boolean a(l lVar) {
        AppMethodBeat.i(70442);
        if (eN == null) {
            eN = new ArrayList<>();
        }
        eN.add(lVar);
        AppMethodBeat.o(70442);
        return true;
    }

    public static boolean b(l lVar) {
        AppMethodBeat.i(70443);
        if (eN == null) {
            Log.e("MicroMsg.WalletPushNotifyManager", "hy: callback pool is null. release failed");
            AppMethodBeat.o(70443);
            return false;
        }
        eN.remove(lVar);
        AppMethodBeat.o(70443);
        return true;
    }

    static /* synthetic */ void a(final int i2, final Map map, final Object[] objArr) {
        AppMethodBeat.i(70445);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.wallet_core.model.ah.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(70437);
                if (ah.eN != null) {
                    Iterator it = ah.eN.iterator();
                    while (it.hasNext()) {
                        l lVar = (l) it.next();
                        if (lVar != null) {
                            lVar.j(i2, objArr);
                        }
                    }
                }
                AppMethodBeat.o(70437);
            }
        });
        AppMethodBeat.o(70445);
    }
}
