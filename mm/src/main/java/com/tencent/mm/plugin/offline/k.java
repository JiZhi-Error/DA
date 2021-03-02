package com.tencent.mm.plugin.offline;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.zy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.auth.a.c;
import com.tencent.mm.plugin.offline.a.q;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.b.a;
import com.tencent.mm.plugin.offline.ui.d;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vending.b.b;
import java.util.HashMap;
import java.util.Map;

public class k implements bd {
    public static boolean AIX = false;
    public static int AIY = 10;
    private static HashMap<Integer, h.b> baseDBFactories = new HashMap<>();
    private static Map<String, String> mMap = new HashMap();
    private s AIR = null;
    private e AIS = null;
    private i AIT = null;
    private a AIU = null;
    private d AIV = new d();
    public f AIW = new f();
    private IListener<zy> AIZ = new IListener<zy>() {
        /* class com.tencent.mm.plugin.offline.k.AnonymousClass1 */

        {
            AppMethodBeat.i(160814);
            this.__eventId = zy.class.getName().hashCode();
            AppMethodBeat.o(160814);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zy zyVar) {
            AppMethodBeat.i(66255);
            zy zyVar2 = zyVar;
            if (!Util.isNullOrNil(zyVar2.egE.egF)) {
                com.tencent.mm.plugin.offline.c.a.aJk(zyVar2.egE.egF);
            }
            AppMethodBeat.o(66255);
            return false;
        }
    };
    private IListener<lj> AJa = new IListener<lj>() {
        /* class com.tencent.mm.plugin.offline.k.AnonymousClass2 */

        {
            AppMethodBeat.i(182485);
            this.__eventId = lj.class.getName().hashCode();
            AppMethodBeat.o(182485);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lj ljVar) {
            AppMethodBeat.i(182486);
            if (com.tencent.mm.plugin.offline.c.a.eAj()) {
                g.azz().a(new q(""), 0);
            }
            AppMethodBeat.o(182486);
            return false;
        }
    };
    private IListener<og> AJb = new IListener<og>() {
        /* class com.tencent.mm.plugin.offline.k.AnonymousClass3 */

        {
            AppMethodBeat.i(182487);
            this.__eventId = og.class.getName().hashCode();
            AppMethodBeat.o(182487);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(og ogVar) {
            AppMethodBeat.i(182488);
            Log.i("MicroMsg.SubCoreOffline", "update card list: %s", Integer.valueOf(ogVar.dUv.scene));
            if (com.tencent.mm.plugin.offline.c.a.eAj()) {
                g.azz().a(new q(""), 0);
            }
            AppMethodBeat.o(182488);
            return false;
        }
    };
    private m AJc;
    private IListener<jm> AJd = new IListener<jm>() {
        /* class com.tencent.mm.plugin.offline.k.AnonymousClass7 */

        {
            AppMethodBeat.i(182492);
            this.__eventId = jm.class.getName().hashCode();
            AppMethodBeat.o(182492);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jm jmVar) {
            AppMethodBeat.i(182493);
            Log.i("MicroMsg.SubCoreOffline", "receive disaster update token");
            k.ezq().hE(0, 0);
            AppMethodBeat.o(182493);
            return false;
        }
    };
    private IListener<ar> AJe = new IListener<ar>() {
        /* class com.tencent.mm.plugin.offline.k.AnonymousClass8 */

        {
            AppMethodBeat.i(182494);
            this.__eventId = ar.class.getName().hashCode();
            AppMethodBeat.o(182494);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ar arVar) {
            AppMethodBeat.i(182495);
            ar arVar2 = arVar;
            Log.d("MicroMsg.SubCoreOffline", "receive broadcase event: %s", Integer.valueOf(arVar2.dDD.type));
            if (arVar2.dDD.type == 4) {
                Log.i("MicroMsg.SubCoreOffline", "receive old disaster event");
                k.ezq().hE(0, 0);
            }
            AppMethodBeat.o(182495);
            return false;
        }
    };
    private b kJs;
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    private cj.a qvw = new cj.a() {
        /* class com.tencent.mm.plugin.offline.k.AnonymousClass6 */

        {
            AppMethodBeat.i(160816);
            AppMethodBeat.o(160816);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(final h.a aVar) {
            AppMethodBeat.i(182491);
            final String a2 = z.a(aVar.heO.KHn);
            Log.d("MicroMsg.SubCoreOffline", "OfflinePayMsg:".concat(String.valueOf(a2)));
            k.this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.offline.k.AnonymousClass6.AnonymousClass1 */

                public final void run() {
                    boolean z;
                    int i2;
                    AppMethodBeat.i(182490);
                    s ezo = k.ezo();
                    String str = a2;
                    long j2 = aVar.heO.Brn;
                    Log.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :".concat(String.valueOf(j2)));
                    Log.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :".concat(String.valueOf(str)));
                    if (!TextUtils.isEmpty(str)) {
                        if (ezo.AHb != null && ezo.AHb.size() != 0) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= ezo.AHb.size()) {
                                    break;
                                } else if (ezo.AHb.get(i3).longValue() == j2) {
                                    z = true;
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                        } else {
                            Log.e("MicroMsg.WalletOfflineMsgManager", "mMsgIdList is null or size == 0");
                        }
                        z = false;
                        if (z) {
                            Log.e("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is exist in list:".concat(String.valueOf(j2)));
                            AppMethodBeat.o(182490);
                            return;
                        }
                        String str2 = null;
                        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
                        if (parseXml != null) {
                            i2 = Util.getInt(parseXml.get(".sysmsg.paymsg.PayMsgType"), -1);
                            str2 = parseXml.get(".sysmsg.paymsg.ack_key");
                        } else {
                            i2 = -1;
                        }
                        if (com.tencent.mm.plugin.offline.c.a.eAL()) {
                            Log.i("MicroMsg.WalletOfflineMsgManager", "pos is enabled. PayMsgType is %d", Integer.valueOf(i2));
                            if (i2 == 7 || i2 == 10) {
                                ezo.aJc(str);
                                ezo.aJd(str);
                            } else if (g.ji(str2, str)) {
                                Log.i("MicroMsg.WalletOfflineMsgManager", "process msg from push");
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(135, 70, 1, true);
                                ezo.aJc(str);
                                ezo.aJd(str);
                            }
                        } else {
                            g.ji(str2, str);
                            ezo.aJc(str);
                            ezo.aJd(str);
                        }
                        if (ezo.AHb.size() > 10) {
                            ezo.AHb.remove(ezo.AHb.size() - 1);
                        }
                        ezo.AHb.add(0, Long.valueOf(j2));
                    }
                    AppMethodBeat.o(182490);
                }
            });
            AppMethodBeat.o(182491);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };

    public k() {
        AppMethodBeat.i(66261);
        AppMethodBeat.o(66261);
    }

    static {
        AppMethodBeat.i(66271);
        com.tencent.mm.wallet_core.a.j("OfflineBindCardRegProcess", d.class);
        com.tencent.mm.wallet_core.a.j("OfflineBindCardProcess", c.class);
        baseDBFactories.put(Integer.valueOf("OFFLINE_ORDER_STATUS".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.offline.k.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return a.SQL_CREATE;
            }
        });
        AppMethodBeat.o(66271);
    }

    public static k ezn() {
        AppMethodBeat.i(66262);
        k kVar = (k) y.at(k.class);
        AppMethodBeat.o(66262);
        return kVar;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(66263);
        AIY = g.aAh().azQ().getInt(ar.a.BUSINESS_OFFLINE_REGET_TOKEN_NUM_SYNC_INT, 10);
        Log.i("MicroMsg.SubCoreOffline", "init get token count: %s", Integer.valueOf(AIY));
        this.kJs = ((c) g.ah(c.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.b() {
            /* class com.tencent.mm.plugin.offline.k.AnonymousClass5 */

            {
                AppMethodBeat.i(160815);
                AppMethodBeat.o(160815);
            }

            @Override // com.tencent.mm.plugin.auth.a.b
            public final void a(j.h hVar, j.i iVar, boolean z) {
                AppMethodBeat.i(182489);
                Log.i("MicroMsg.SubCoreOffline", "autoAuth: %s", Boolean.valueOf(z));
                if (!z) {
                    k.ezq().hE(7, 7);
                }
                AppMethodBeat.o(182489);
            }

            @Override // com.tencent.mm.plugin.auth.a.b
            public final void a(x.b bVar, String str, int i2, String str2, String str3, int i3) {
            }
        });
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("paymsg", this.qvw, true);
        EventCenter.instance.addListener(this.AIV);
        EventCenter.instance.addListener(this.AIZ);
        this.AJd.alive();
        this.AJe.alive();
        this.AJa.alive();
        this.AJb.alive();
        this.AIR = null;
        this.AIS = null;
        this.AIT = null;
        this.AJc = new m();
        AppMethodBeat.o(66263);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(66264);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("paymsg", this.qvw, true);
        EventCenter.instance.removeListener(this.AIV);
        EventCenter.instance.removeListener(this.AIZ);
        this.AJd.dead();
        this.AJe.dead();
        this.AJa.dead();
        this.AJb.dead();
        if (this.AJc != null) {
            m mVar = this.AJc;
            ezn();
            ezo().b(mVar);
            EventCenter.instance.removeListener(mVar.yYb);
        }
        this.AJc = null;
        this.kJs.dead();
        AppMethodBeat.o(66264);
    }

    public static s ezo() {
        AppMethodBeat.i(66265);
        g.aAf().azk();
        if (ezn().AIR == null) {
            ezn().AIR = new s();
        }
        s sVar = ezn().AIR;
        AppMethodBeat.o(66265);
        return sVar;
    }

    public static e ezp() {
        AppMethodBeat.i(66266);
        g.aAf().azk();
        if (ezn().AIS == null) {
            ezn().AIS = new e();
        }
        e eVar = ezn().AIS;
        AppMethodBeat.o(66266);
        return eVar;
    }

    public static i ezq() {
        AppMethodBeat.i(66267);
        g.aAf().azk();
        if (ezn().AIT == null) {
            ezn().AIT = new i();
        }
        i iVar = ezn().AIT;
        AppMethodBeat.o(66267);
        return iVar;
    }

    public static void bN(int i2, String str) {
        AppMethodBeat.i(66268);
        if (str != null) {
            g.aAi();
            g.aAh().azQ().set(i2, str);
            g.aAi();
            g.aAh().azQ().gBI();
        }
        AppMethodBeat.o(66268);
    }

    public static String TX(int i2) {
        AppMethodBeat.i(66269);
        g.aAi();
        String str = (String) g.aAh().azQ().get(i2, (Object) null);
        AppMethodBeat.o(66269);
        return str;
    }

    public static a ezr() {
        AppMethodBeat.i(66270);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(66270);
            throw bVar;
        }
        if (ezn().AIU == null) {
            k ezn = ezn();
            g.aAi();
            ezn.AIU = new a(g.aAh().hqK);
        }
        a aVar = ezn().AIU;
        AppMethodBeat.o(66270);
        return aVar;
    }
}
