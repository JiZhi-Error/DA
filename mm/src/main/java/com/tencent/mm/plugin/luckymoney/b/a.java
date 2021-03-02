package com.tencent.mm.plugin.luckymoney.b;

import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.h;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.co.c;
import com.tencent.mm.g.a.aaj;
import com.tencent.mm.g.a.abh;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.bj;
import com.tencent.mm.plugin.luckymoney.model.bk;
import com.tencent.mm.plugin.luckymoney.model.m;
import com.tencent.mm.plugin.luckymoney.model.n;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.luckymoney.model.v;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.luckymoney.story.b.b;
import com.tencent.mm.plugin.luckymoney.story.b.d;
import com.tencent.mm.plugin.luckymoney.story.b.e;
import com.tencent.mm.plugin.luckymoney.story.b.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a implements o, bd, i.a, g {
    public static int UXs = -1;
    private static HashMap<Integer, h.b> baseDBFactories;
    private bk UXr;
    private IListener<abh> UXt = new IListener<abh>() {
        /* class com.tencent.mm.plugin.luckymoney.b.a.AnonymousClass2 */

        {
            AppMethodBeat.i(258561);
            this.__eventId = abh.class.getName().hashCode();
            AppMethodBeat.o(258561);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(abh abh) {
            AppMethodBeat.i(258562);
            Log.d("MicroMsg.SubCoreLuckyMoney", "exit chatting ui");
            a.UXs = -1;
            AppMethodBeat.o(258562);
            return false;
        }
    };
    private cj.a qvw = new cj.a() {
        /* class com.tencent.mm.plugin.luckymoney.b.a.AnonymousClass3 */

        {
            AppMethodBeat.i(213246);
            AppMethodBeat.o(213246);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(258563);
            Map<String, String> parseXml = XmlParser.parseXml(z.a(aVar.heO.KHn), "sysmsg", null);
            Log.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
            if (parseXml == null) {
                Log.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
                AppMethodBeat.o(258563);
                return;
            }
            String str = parseXml.get(".sysmsg.paymsg.PayMsgType");
            if ("14".equals(str)) {
                String decode = URLDecoder.decode(parseXml.get(".sysmsg.paymsg.appmsgcontent"));
                if (TextUtils.isEmpty(decode)) {
                    Log.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
                    AppMethodBeat.o(258563);
                    return;
                }
                Map<String, String> parseXml2 = XmlParser.parseXml(decode, "msg", null);
                if (parseXml2 == null) {
                    Log.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
                    AppMethodBeat.o(258563);
                    return;
                }
                String str2 = parseXml2.get(".msg.appmsg.wcpayinfo.paymsgid");
                if (Util.isNullOrNil(str2)) {
                    Log.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
                    AppMethodBeat.o(258563);
                    return;
                }
                String str3 = parseXml.get(".sysmsg.paymsg.tousername");
                if (Util.isNullOrNil(decode) || Util.isNullOrNil(str3)) {
                    Log.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
                    AppMethodBeat.o(258563);
                    return;
                }
                if (a.this.eeB().aDu(str2)) {
                    Log.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
                    if (!af.ac(decode, str3, 1)) {
                        a.this.eeB().aDv(str2);
                    }
                }
                AppMethodBeat.o(258563);
                return;
            }
            if ("47".equals(str)) {
                String nullAs = Util.nullAs(parseXml.get(".sysmsg.paymsg.OrderId"), "");
                ae aVC = t.fQE().aVC(nullAs);
                if (aVC == null) {
                    Log.w("MicroMsg.SubCoreLuckyMoney", "can't find sendid: %s", nullAs);
                    AppMethodBeat.o(258563);
                    return;
                }
                aVC.field_hbStatus = 5;
                t.fQE().a(aVC);
                a.this.aDq(aVC.field_sender);
            }
            AppMethodBeat.o(258563);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private p yPb;
    private com.tencent.mm.plugin.luckymoney.model.ae yPc;
    private w yPd;
    private n yPe = new n();
    private bj yPf;
    private com.tencent.mm.co.h<v> yPg = new com.tencent.mm.co.h<>(new c<v>() {
        /* class com.tencent.mm.plugin.luckymoney.b.a.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ v get() {
            AppMethodBeat.i(64856);
            v vVar = new v(com.tencent.mm.kernel.g.aAh().hqK);
            AppMethodBeat.o(64856);
            return vVar;
        }
    });
    private com.tencent.mm.co.h<b> yPh = new com.tencent.mm.co.h<>(new c<b>() {
        /* class com.tencent.mm.plugin.luckymoney.b.a.AnonymousClass6 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ b get() {
            AppMethodBeat.i(163533);
            b bVar = new b(com.tencent.mm.kernel.g.aAh().hqK);
            AppMethodBeat.o(163533);
            return bVar;
        }
    });
    private com.tencent.mm.co.h<d> yPi = new com.tencent.mm.co.h<>(new c<d>() {
        /* class com.tencent.mm.plugin.luckymoney.b.a.AnonymousClass7 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ d get() {
            AppMethodBeat.i(163534);
            d dVar = new d(com.tencent.mm.kernel.g.aAh().hqK);
            AppMethodBeat.o(163534);
            return dVar;
        }
    });
    private com.tencent.mm.co.h<f> yPj = new com.tencent.mm.co.h<>(new c<f>() {
        /* class com.tencent.mm.plugin.luckymoney.b.a.AnonymousClass8 */

        {
            AppMethodBeat.i(160800);
            AppMethodBeat.o(160800);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ f get() {
            AppMethodBeat.i(213251);
            f fVar = new f(com.tencent.mm.kernel.g.aAh().hqK);
            AppMethodBeat.o(213251);
            return fVar;
        }
    });
    private com.tencent.mm.plugin.luckymoney.model.t yPk = new com.tencent.mm.plugin.luckymoney.model.t();
    public IListener<fp> yPl = new IListener<fp>() {
        /* class com.tencent.mm.plugin.luckymoney.b.a.AnonymousClass13 */

        {
            AppMethodBeat.i(213252);
            this.__eventId = fp.class.getName().hashCode();
            AppMethodBeat.o(213252);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fp fpVar) {
            AppMethodBeat.i(213253);
            com.tencent.mm.plugin.luckymoney.ui.a.a.gW(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_hongbao_android_time_limit_promo_percentage, -1), ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_hongbao_android_time_limit_promo_unix_timestamp, 0));
            AppMethodBeat.o(213253);
            return false;
        }
    };
    private IListener<aaj> yPm = new IListener<aaj>() {
        /* class com.tencent.mm.plugin.luckymoney.b.a.AnonymousClass4 */

        {
            AppMethodBeat.i(258565);
            this.__eventId = aaj.class.getName().hashCode();
            AppMethodBeat.o(258565);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aaj aaj) {
            AppMethodBeat.i(258567);
            boolean a2 = a(aaj);
            AppMethodBeat.o(258567);
            return a2;
        }

        private boolean a(final aaj aaj) {
            String str;
            AppMethodBeat.i(258566);
            if (!Util.isNullOrNil(aaj.ehg.dWG)) {
                k.b HD = k.b.HD(aaj.ehg.dWG);
                if (!Util.isNullOrNil(HD.iyr)) {
                    Log.i("MicroMsg.SubCoreLuckyMoney", "receive lucky money: %s", HD.iyr);
                    try {
                        str = Uri.parse(Util.nullAsNil(HD.iyr)).getQueryParameter("sendid");
                    } catch (Exception e2) {
                        str = "";
                    }
                    com.tencent.mm.ag.c cVar = (com.tencent.mm.ag.c) HD.as(com.tencent.mm.ag.c.class);
                    ae aVA = t.fQE().aVA(HD.iyr);
                    if (aVA == null) {
                        aVA = new ae();
                    }
                    if (Util.isNullOrNil(aVA.field_mNativeUrl)) {
                        aVA.field_mNativeUrl = HD.iyr;
                        aVA.field_receiveStatus = 0;
                        if (!Util.isNullOrNil(cVar.iwa)) {
                            aVA.field_hbType = 3;
                            aVA.field_exclusiveUsername = cVar.iwa;
                        }
                        aVA.field_invalidtime = HD.ixR;
                        aVA.field_sender = aaj.ehg.ehh;
                        aVA.field_sendId = str;
                        aVA.field_msgSvrId = aaj.ehg.dTS;
                    }
                    t.fQE().a(aVA);
                    if (aVA.field_hbType == 3) {
                        com.tencent.f.h.RTc.o(new Runnable() {
                            /* class com.tencent.mm.plugin.luckymoney.b.a.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(258564);
                                a.this.aDq(aaj.ehg.ehh);
                                AppMethodBeat.o(258564);
                            }
                        }, 50);
                    }
                    e eVar = new e();
                    eVar.field_send_id = str;
                    if (!a.this.eew().get(eVar, new String[0])) {
                        eVar.field_open_count = 0;
                        Log.d("MicroMsg.SubCoreLuckyMoney", "insert record: %s, %s", str, Boolean.valueOf(a.this.eew().insert(eVar)));
                    }
                }
            }
            AppMethodBeat.o(258566);
            return false;
        }
    };

    static {
        AppMethodBeat.i(64867);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("LuckyMoneyEnvelopeResource".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.luckymoney.b.a.AnonymousClass9 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return v.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("LocalRedPacketStoryInfo".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.luckymoney.b.a.AnonymousClass10 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.luckymoney.story.b.b.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("LocalStoryDetail".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.luckymoney.b.a.AnonymousClass11 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return d.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("LuckyMoneyDetailOpenRecord".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.luckymoney.b.a.AnonymousClass12 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return f.SQL_CREATE;
            }
        });
        AppMethodBeat.o(64867);
    }

    public final v eet() {
        AppMethodBeat.i(64859);
        v vVar = this.yPg.get();
        AppMethodBeat.o(64859);
        return vVar;
    }

    public final com.tencent.mm.plugin.luckymoney.story.b.b eeu() {
        AppMethodBeat.i(163538);
        com.tencent.mm.plugin.luckymoney.story.b.b bVar = this.yPh.get();
        AppMethodBeat.o(163538);
        return bVar;
    }

    public final d eev() {
        AppMethodBeat.i(163539);
        d dVar = this.yPi.get();
        AppMethodBeat.o(163539);
        return dVar;
    }

    public final f eew() {
        AppMethodBeat.i(213254);
        f fVar = this.yPj.get();
        AppMethodBeat.o(213254);
        return fVar;
    }

    public static a eex() {
        AppMethodBeat.i(64860);
        a aVar = (a) y.at(a.class);
        AppMethodBeat.o(64860);
        return aVar;
    }

    public a() {
        AppMethodBeat.i(64861);
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(eeA());
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        AppMethodBeat.o(64861);
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
        AppMethodBeat.i(64862);
        ap gni = ap.gni();
        if (com.tencent.mm.kernel.g.aAc()) {
            com.tencent.mm.plugin.r.a.eAV().a(4, gni);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(1060, gni);
        }
        com.tencent.mm.plugin.luckymoney.model.t tVar = this.yPk;
        com.tencent.mm.pluginsdk.j.a.a.b.gnC();
        com.tencent.mm.pluginsdk.j.a.a.b.ahP(58);
        com.tencent.mm.kernel.g.azz().a(721, tVar);
        this.yPk.alive();
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("paymsg", this.qvw, true);
        ((l) com.tencent.mm.kernel.g.af(l.class)).aST().a(this);
        ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this, (Looper) null);
        AppForegroundDelegate.INSTANCE.a(this);
        boolean z2 = false;
        com.tencent.mm.kernel.g.aAi();
        if (System.currentTimeMillis() - com.tencent.mm.kernel.g.aAh().azQ().akg(352276) >= 43200000) {
            z2 = true;
        }
        Log.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + z2 + ", isUpdate=" + z);
        if (z || z2) {
            Log.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
            ap.gni().iv(MMApplicationContext.getContext());
        }
        EventCenter.instance.addListener(this.yPe);
        EventCenter.instance.addListener(this.yPm);
        this.yPl.alive();
        this.UXt.alive();
        this.yPf = new bj();
        m.efc();
        AppMethodBeat.o(64862);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(64863);
        ap gni = ap.gni();
        if (com.tencent.mm.kernel.g.aAc()) {
            com.tencent.mm.plugin.r.a.eAV().b(4, gni);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.b(1060, gni);
            gni.JXl = false;
            gni.JXm = false;
        }
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("paymsg", this.qvw, true);
        ((l) com.tencent.mm.kernel.g.af(l.class)).aST().b(this);
        ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this);
        AppForegroundDelegate.INSTANCE.b(this);
        synchronized (this) {
            try {
                this.yPd = null;
            } catch (Throwable th) {
                AppMethodBeat.o(64863);
                throw th;
            }
        }
        EventCenter.instance.removeListener(this.yPe);
        EventCenter.instance.removeListener(this.yPm);
        this.yPl.dead();
        this.UXt.dead();
        if (this.yPf != null) {
            bj bjVar = this.yPf;
            EventCenter.instance.removeListener(bjVar.yYb);
            if (bjVar.yXY != null) {
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAg().hqi.a(bjVar.yXY);
                bjVar.yXY = null;
            }
            if (bjVar.yXZ != null) {
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAg().hqi.a(bjVar.yXZ);
                bjVar.yXZ = null;
            }
        }
        m.unInit();
        com.tencent.mm.kernel.g.azz().b(721, this.yPk);
        this.yPk.dead();
        AppMethodBeat.o(64863);
    }

    public static p eey() {
        AppMethodBeat.i(64864);
        Log.i("MicroMsg.SubCoreLuckyMoney", "getConfigMgr()");
        com.tencent.mm.kernel.g.aAf().azk();
        if (eex().yPb == null) {
            eex().yPb = new p();
        }
        p pVar = eex().yPb;
        AppMethodBeat.o(64864);
        return pVar;
    }

    public static com.tencent.mm.plugin.luckymoney.model.ae eez() {
        AppMethodBeat.i(213255);
        Log.i("MicroMsg.SubCoreLuckyMoney", "getConfigMgrUnion()");
        com.tencent.mm.kernel.g.aAf().azk();
        if (eex().yPc == null) {
            eex().yPc = new com.tencent.mm.plugin.luckymoney.model.ae();
        }
        com.tencent.mm.plugin.luckymoney.model.ae aeVar = eex().yPc;
        AppMethodBeat.o(213255);
        return aeVar;
    }

    public static bk hWa() {
        AppMethodBeat.i(258569);
        Log.i("MicroMsg.SubCoreLuckyMoney", "getConfigMgrLive()");
        com.tencent.mm.kernel.g.aAf().azk();
        if (eex().UXr == null) {
            eex().UXr = new bk();
        }
        bk bkVar = eex().UXr;
        AppMethodBeat.o(258569);
        return bkVar;
    }

    public static String eeA() {
        AppMethodBeat.i(64865);
        if (com.tencent.mm.kernel.g.aAc()) {
            String str = com.tencent.mm.plugin.image.d.aSY() + "luckymoney";
            AppMethodBeat.o(64865);
            return str;
        }
        AppMethodBeat.o(64865);
        return "";
    }

    public final synchronized w eeB() {
        w wVar;
        AppMethodBeat.i(64866);
        if (this.yPd == null) {
            this.yPd = new w();
        }
        wVar = this.yPd;
        AppMethodBeat.o(64866);
        return wVar;
    }

    public final void aDq(final String str) {
        AppMethodBeat.i(213256);
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.luckymoney.b.a.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(213250);
                Log.i("MicroMsg.SubCoreLuckyMoney", "start update");
                long currentTicks = Util.currentTicks();
                boolean aDs = a.aDs(str);
                az bjY = ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bjY(str);
                if (bjY != null && ab.Eq(str)) {
                    Log.i("MicroMsg.SubCoreLuckyMoney", "update red flag: %s, %s", str, Boolean.valueOf(aDs));
                    bjY.nD(aDs ? 1 : 0);
                    Log.i("MicroMsg.SubCoreLuckyMoney", "update ret: %s", Integer.valueOf(((l) com.tencent.mm.kernel.g.af(l.class)).aST().a(bjY, str)));
                }
                Log.i("MicroMsg.SubCoreLuckyMoney", "finish update red flag: %s", Long.valueOf(Util.currentTicks() - currentTicks));
                AppMethodBeat.o(213250);
            }
        }, "update_hb_red_flag");
        AppMethodBeat.o(213256);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.g
    public final void a(ca caVar, i.c cVar, boolean[] zArr) {
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.g
    public final void a(ca caVar, az azVar, boolean z, i.c cVar) {
        AppMethodBeat.i(213258);
        if (z && !ab.Eq(azVar.field_username)) {
            aDq(azVar.field_username);
        }
        AppMethodBeat.o(213258);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.g
    public final void b(ca caVar, az azVar, boolean z, i.c cVar) {
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i.a
    public final void a(i iVar, i.c cVar) {
        AppMethodBeat.i(213259);
        if (cVar.zqn.equals("delete")) {
            Log.i("MicroMsg.SubCoreLuckyMoney", "update red flag when delete msg: %s", cVar.talker);
            aDq(cVar.talker);
        }
        AppMethodBeat.o(213259);
    }

    @Override // com.tencent.mm.app.o
    public void onAppForeground(String str) {
    }

    @Override // com.tencent.mm.app.o
    public void onAppBackground(String str) {
        AppMethodBeat.i(213260);
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.luckymoney.b.a.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(258568);
                a.a(a.this);
                AppMethodBeat.o(258568);
            }
        }, "check_hb_red_flag_background");
        AppMethodBeat.o(213260);
    }

    static /* synthetic */ boolean aDs(String str) {
        boolean z;
        AppMethodBeat.i(213257);
        if (!ab.Eq(str)) {
            AppMethodBeat.o(213257);
            return false;
        }
        List<ae> aVB = t.fQE().aVB(str);
        if (aVB != null && !aVB.isEmpty()) {
            Log.i("MicroMsg.SubCoreLuckyMoney", "query record count: %s", Integer.valueOf(aVB.size()));
            Iterator<ae> it = aVB.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ae next = it.next();
                if (next.field_hbType == 3 && com.tencent.mm.model.z.aTY().equals(next.field_exclusiveUsername) && next.field_hbStatus != 4 && next.field_hbStatus != 5 && (((long) next.field_invalidtime) * 1000) - cl.aWA() > 0 && ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aJ(str, next.field_msgSvrId).field_msgId > 0) {
                    Log.i("MicroMsg.SubCoreLuckyMoney", "need mark red: %s, %s", Long.valueOf(next.field_msgSvrId), next.field_sendId);
                    z = true;
                    break;
                }
            }
            AppMethodBeat.o(213257);
            return z;
        }
        z = false;
        AppMethodBeat.o(213257);
        return z;
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(213262);
        if (cl.aWA() - ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_HB_RED_FLAG_CHECK_LONG_SYNC, (Object) 0L)).longValue() > 43200000) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_HB_RED_FLAG_CHECK_LONG_SYNC, Long.valueOf(cl.aWA()));
            List<ae> fSt = t.fQE().fSt();
            HashSet hashSet = new HashSet();
            for (ae aeVar : fSt) {
                Log.d("MicroMsg.SubCoreLuckyMoney", "check status: %s, type: %s", Integer.valueOf(aeVar.field_hbStatus), Integer.valueOf(aeVar.field_hbType));
                if (!hashSet.contains(aeVar.field_sender)) {
                    aVar.aDq(aeVar.field_sender);
                    hashSet.add(aeVar.field_sender);
                }
            }
            Cursor all = t.fQE().getAll();
            if (all != null) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(22303, Integer.valueOf(all.getCount()));
                Log.i("MicroMsg.SubCoreLuckyMoney", "get record count: %s", all);
            }
            AppMethodBeat.o(213262);
            return;
        }
        Log.i("MicroMsg.SubCoreLuckyMoney", "not time");
        AppMethodBeat.o(213262);
    }
}
