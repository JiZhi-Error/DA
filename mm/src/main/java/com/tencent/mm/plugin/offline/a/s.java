package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zx;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class s {
    public ArrayList<Long> AHb = new ArrayList<>();
    public b AKa = null;
    private HashSet<String> AKb = new HashSet<>();
    private List<WeakReference<a>> pQG = new ArrayList();

    public interface a {
        boolean a(c cVar);
    }

    public s() {
        Map<String, String> parseXml;
        int i2;
        AppMethodBeat.i(66322);
        String eAu = com.tencent.mm.plugin.offline.c.a.eAu();
        if (!TextUtils.isEmpty(eAu) && (parseXml = XmlParser.parseXml(eAu, "sysmsg", null)) != null && (i2 = Util.getInt(parseXml.get(".sysmsg.paymsg.PayMsgType"), -1)) >= 0 && i2 == 4) {
            Log.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
            b(au(parseXml));
        }
        this.AHb.clear();
        AppMethodBeat.o(66322);
    }

    public class c {
        public int AKh;

        public c() {
        }
    }

    public class b extends c {
        public String AKe;
        public String AKf;
        public String AKg;

        public b() {
            super();
        }
    }

    public class e extends c {
        public String AKi;
        public String AKj;
        public String AKk;
        public String AKl;
        public String AKm;
        public boolean AKn = true;

        public e() {
            super();
        }
    }

    public class f extends c {
        public String AKo;
        public Orders AKp;
        public h egD;

        public f() {
            super();
        }
    }

    public class g extends c {
        public String AKq;
        public String AKr;
        public String dNQ;
        public String id;
        public int qGa;

        public g() {
            super();
        }
    }

    public class d extends c {
        public String dNQ;

        public d() {
            super();
        }
    }

    public class h {
        public boolean AKs;
        public String egd;
        public String ege;
        public String egf;
        public String egg;
        public String egh;

        public h(Map<String, String> map) {
            AppMethodBeat.i(66321);
            this.egd = map.get(".sysmsg.paymsg.guide_flag");
            this.ege = map.get(".sysmsg.paymsg.guide_wording");
            this.egf = map.get(".sysmsg.paymsg.left_button_wording");
            this.egg = map.get(".sysmsg.paymsg.right_button_wording");
            this.egh = map.get(".sysmsg.paymsg.upload_credit_url");
            this.AKs = "1".equals(map.get(".sysmsg.paymsg.guide_block"));
            AppMethodBeat.o(66321);
        }
    }

    private void b(c cVar) {
        AppMethodBeat.i(66323);
        if (this.pQG == null) {
            AppMethodBeat.o(66323);
            return;
        }
        int i2 = 0;
        while (i2 < this.pQG.size() && ((r0 = this.pQG.get(i2)) == null || (r0 = r0.get()) == null || !r0.a(cVar))) {
            i2++;
        }
        AppMethodBeat.o(66323);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(66324);
        if (this.pQG == null) {
            this.pQG = new ArrayList();
        }
        this.pQG.add(new WeakReference<>(aVar));
        AppMethodBeat.o(66324);
    }

    public final void b(a aVar) {
        a aVar2;
        AppMethodBeat.i(66325);
        if (this.pQG == null) {
            AppMethodBeat.o(66325);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (weakReference != null && (aVar2 = weakReference.get()) != null && aVar2.equals(aVar)) {
                this.pQG.remove(weakReference);
                AppMethodBeat.o(66325);
                return;
            }
        }
        AppMethodBeat.o(66325);
    }

    public final void aJc(String str) {
        boolean z;
        AppMethodBeat.i(66326);
        com.tencent.mm.plugin.offline.c.a.aJs("");
        com.tencent.mm.plugin.offline.c.a.aJu("");
        com.tencent.mm.plugin.offline.c.a.aJt("");
        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
        if (parseXml == null) {
            AppMethodBeat.o(66326);
            return;
        }
        int i2 = Util.getInt(parseXml.get(".sysmsg.paymsg.PayMsgType"), -1);
        int i3 = Util.getInt(parseXml.get(".sysmsg.paymsg.pay_cmd"), -1);
        com.tencent.mm.plugin.offline.c.a.aJs(parseXml.get(".sysmsg.paymsg.ack_key"));
        com.tencent.mm.plugin.offline.c.a.Ug(i2);
        com.tencent.mm.plugin.offline.c.a.aJt(parseXml.get(".sysmsg.paymsg.req_key"));
        int i4 = Util.getInt(parseXml.get(".sysmsg.paymsg.PayMsgType"), -1);
        Log.i("MicroMsg.WalletOfflineMsgManager", "msg type is ".concat(String.valueOf(i4)));
        Log.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", Integer.valueOf(i4), str);
        if (i4 >= 0 && i4 == 4) {
            b(au(parseXml));
            com.tencent.mm.plugin.offline.c.a.aJj(str);
            AppMethodBeat.o(66326);
        } else if (i4 >= 0 && i4 == 5) {
            if (i3 == 1) {
                Log.i("MicroMsg.WalletOfflineMsgManager", "payCmd is PAY_CMD_OFFLINE_PAY_REFRESH_TOKEN (value is 1), refresh offline token");
                k.ezn();
                k.ezq().hE(4, 4);
                z = false;
            } else {
                z = true;
            }
            e av = av(parseXml);
            av.AKn = z;
            b(av);
            AppMethodBeat.o(66326);
        } else if (i4 >= 0 && i4 == 6) {
            String str2 = parseXml.get(".sysmsg.paymsg.transid");
            Log.i("helios", "MSG_TYPE_ORDER trasid=".concat(String.valueOf(str2)));
            if (!Util.isNullOrNil(str2)) {
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
            }
            Log.i("MicroMsg.WalletOfflineMsgManager", "orders xml: %s", str);
            b(aw(parseXml));
            AppMethodBeat.o(66326);
        } else if (i4 >= 0 && i4 == 7) {
            t.fQI().and();
            AppMethodBeat.o(66326);
        } else if (i4 >= 0 && i4 == 8) {
            b(ay(parseXml));
            AppMethodBeat.o(66326);
        } else if (i4 >= 0 && i4 == 10) {
            k.ezn();
            k.ezq().hE(4, 4);
            AppMethodBeat.o(66326);
        } else if (i4 >= 0 && i4 == 20) {
            zx zxVar = new zx();
            zxVar.egC.egD = new h(parseXml);
            EventCenter.instance.publish(zxVar);
            AppMethodBeat.o(66326);
        } else if (i4 >= 0 && i4 == 23) {
            d ax = ax(parseXml);
            synchronized (this.AKb) {
                try {
                    if (this.AKb.contains(ax.dNQ)) {
                        Log.i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", ax.dNQ);
                        return;
                    }
                    this.AKb.add(ax.dNQ);
                    b(ax);
                    AppMethodBeat.o(66326);
                } finally {
                    AppMethodBeat.o(66326);
                }
            }
        } else if (i4 < 0 || i4 != 24) {
            AppMethodBeat.o(66326);
        } else {
            b(at(parseXml));
            AppMethodBeat.o(66326);
        }
    }

    private d at(Map<String, String> map) {
        AppMethodBeat.i(66327);
        d dVar = new d();
        dVar.AKh = Util.getInt(map.get(".sysmsg.paymsg.PayMsgType"), -1);
        dVar.dNQ = map.get(".sysmsg.paymsg.req_key");
        AppMethodBeat.o(66327);
        return dVar;
    }

    private b au(Map<String, String> map) {
        AppMethodBeat.i(66328);
        if (this.AKa == null) {
            this.AKa = new b();
        }
        this.AKa.AKh = Util.getInt(map.get(".sysmsg.paymsg.PayMsgType"), -1);
        this.AKa.AKe = map.get(".sysmsg.paymsg.isfreeze");
        this.AKa.AKf = map.get(".sysmsg.paymsg.freezetype");
        this.AKa.AKg = map.get(".sysmsg.paymsg.freezemsg");
        b bVar = this.AKa;
        AppMethodBeat.o(66328);
        return bVar;
    }

    private e av(Map<String, String> map) {
        AppMethodBeat.i(66329);
        e eVar = new e();
        eVar.AKh = Util.getInt(map.get(".sysmsg.paymsg.PayMsgType"), -1);
        eVar.AKi = map.get(".sysmsg.paymsg.cftretcode");
        eVar.AKj = map.get(".sysmsg.paymsg.cftretmsg");
        eVar.AKk = map.get(".sysmsg.paymsg.wxretcode");
        eVar.AKl = map.get(".sysmsg.paymsg.wxretmsg");
        eVar.AKm = map.get(".sysmsg.paymsg.error_detail_url");
        eVar.AKn = true;
        AppMethodBeat.o(66329);
        return eVar;
    }

    private f aw(Map<String, String> map) {
        AppMethodBeat.i(66330);
        f fVar = new f();
        fVar.AKh = Util.getInt(map.get(".sysmsg.paymsg.PayMsgType"), -1);
        fVar.AKo = map.get(".sysmsg.paymsg.transid");
        fVar.AKp = com.tencent.mm.plugin.offline.c.a.az(map);
        if (fVar.AKp.HZd.size() > 0) {
            com.tencent.mm.plugin.offline.c.a.aJu(fVar.AKp.HZd.get(0).dDM);
        }
        if (map.containsKey(".sysmsg.paymsg.real_name_info")) {
            fVar.egD = new h(map);
        }
        AppMethodBeat.o(66330);
        return fVar;
    }

    private d ax(Map<String, String> map) {
        AppMethodBeat.i(66331);
        d dVar = new d();
        dVar.AKh = Util.getInt(map.get(".sysmsg.paymsg.PayMsgType"), -1);
        dVar.dNQ = map.get(".sysmsg.paymsg.req_key");
        AppMethodBeat.o(66331);
        return dVar;
    }

    private g ay(Map<String, String> map) {
        AppMethodBeat.i(66332);
        g gVar = new g();
        gVar.AKh = Util.getInt(map.get(".sysmsg.paymsg.PayMsgType"), -1);
        gVar.AKq = map.get(".sysmsg.paymsg.good_name");
        gVar.AKr = map.get(".sysmsg.paymsg.total_fee");
        gVar.dNQ = map.get(".sysmsg.paymsg.req_key");
        gVar.id = map.get(".sysmsg.paymsg.id");
        String str = map.get(".sysmsg.paymsg.confirm_type");
        Log.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + gVar.qGa);
        if (TextUtils.isEmpty(str) || !str.equals("1")) {
            gVar.qGa = 0;
        } else {
            gVar.qGa = 1;
        }
        AppMethodBeat.o(66332);
        return gVar;
    }

    public final void aJd(String str) {
        AppMethodBeat.i(66333);
        int i2 = Util.getInt(XmlParser.parseXml(str, "sysmsg", null).get(".sysmsg.paymsg.PayMsgType"), -1);
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.AIr));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.AIq));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.AIs));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.AIp));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.AIm));
        if (hashSet.contains(Integer.valueOf(i2))) {
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.offline.a.s.AnonymousClass1 */
                final /* synthetic */ boolean AKc = false;

                public final void run() {
                    AppMethodBeat.i(66320);
                    Log.v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
                    com.tencent.mm.kernel.g.aAi();
                    com.tencent.mm.kernel.g.aAg().hqi.a(new b(this.AKc), 0);
                    AppMethodBeat.o(66320);
                }
            });
        }
        AppMethodBeat.o(66333);
    }
}
