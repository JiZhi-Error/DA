package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.g.a.xi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.shake.c.a.d;
import com.tencent.mm.plugin.shake.c.a.f;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class m implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private IListener AgM = new IListener<mw>() {
        /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass6 */

        {
            AppMethodBeat.i(161432);
            this.__eventId = mw.class.getName().hashCode();
            AppMethodBeat.o(161432);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mw mwVar) {
            AppMethodBeat.i(28157);
            mw mwVar2 = mwVar;
            if (mwVar2 instanceof mw) {
                switch (mwVar2.dSw.action) {
                    case -4:
                        Cursor eTV = m.eUm().eTV();
                        mwVar2.dSx.dLA = new ArrayList();
                        while (eTV != null && eTV.moveToNext()) {
                            d dVar = new d();
                            dVar.convertFrom(eTV);
                            mwVar2.dSx.dLA.add(i.e(dVar.field_lvbuffer, 0));
                        }
                        if (eTV != null) {
                            eTV.close();
                            break;
                        }
                        break;
                    case 12:
                        mwVar2.dSx.dSD = a.aKj(mwVar2.dSw.songAlbumUrl);
                        break;
                }
            }
            AppMethodBeat.o(28157);
            return false;
        }
    };
    private bv.a AzD = new bv.a() {
        /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass14 */

        @Override // com.tencent.mm.storage.bv.a
        public final void a(bv bvVar, as asVar) {
            AppMethodBeat.i(28162);
            if (!(bvVar == null || asVar == null || !asVar.ary())) {
                m.eUm().aNj(asVar.field_username);
            }
            AppMethodBeat.o(28162);
        }

        @Override // com.tencent.mm.storage.bv.a
        public final as Kn(String str) {
            return null;
        }

        @Override // com.tencent.mm.storage.bv.a
        public final int b(as asVar, boolean z) {
            return 0;
        }
    };
    private e Dhc;
    private g Dhd;
    private f Dhe;
    private d Dhf;
    private o Dhg;
    private n Dhh = new n();
    com.tencent.mm.pluginsdk.c.d Dhi = new com.tencent.mm.pluginsdk.c.d() {
        /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.c.d
        public final IEvent azl(String str) {
            AppMethodBeat.i(28149);
            uo uoVar = new uo();
            uoVar.eaR.event = str;
            AppMethodBeat.o(28149);
            return uoVar;
        }

        @Override // com.tencent.mm.pluginsdk.c.d
        public final MStorage dSG() {
            AppMethodBeat.i(28150);
            g eUn = m.eUn();
            AppMethodBeat.o(28150);
            return eUn;
        }
    };
    private cj.a Dhj = new cj.a() {
        /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass13 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(28161);
            m.eUt();
            if (m.eUq() != null) {
                m.eUt();
                m.eUq();
                String a2 = z.a(aVar.heO.KHn);
                Log.v("MicroMsg.ShakeMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(a2)));
                if (Util.isNullOrNil(a2)) {
                    Log.d("MicroMsg.ShakeMsgMgr", "func[onResvMsg] Msg content empty");
                    AppMethodBeat.o(28161);
                    return;
                }
                Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
                int i2 = Util.getInt(parseXml.get(".sysmsg.shake.$type"), 0);
                switch (i2) {
                    case 1:
                        f fVar = new f();
                        int i3 = Util.getInt(parseXml.get(".sysmsg.shake.shaketv.msgtype"), 0);
                        if (i3 == 0) {
                            fVar.field_type = 1;
                            fVar.field_subtype = i3;
                            fVar.field_svrid = aVar.heO.Brn;
                            fVar.field_createtime = Util.nowSecond();
                            fVar.field_tag = parseXml.get(".sysmsg.shake.shaketv.jumpurl");
                            fVar.field_status = 0;
                            fVar.field_title = parseXml.get(".sysmsg.shake.shaketv.title");
                            fVar.field_thumburl = parseXml.get(".sysmsg.shake.shaketv.iconurl");
                            fVar.field_desc = parseXml.get(".sysmsg.shake.shaketv.desc");
                            fVar.field_reserved1 = Util.nullAsNil(parseXml.get(".sysmsg.shake.shaketv.pid"));
                            m.eUn().a(fVar);
                            AppMethodBeat.o(28161);
                            return;
                        }
                        Log.w("MicroMsg.ShakeMsgMgr", "Unknown subType:".concat(String.valueOf(i3)));
                        AppMethodBeat.o(28161);
                        return;
                    default:
                        Log.d("MicroMsg.ShakeMsgMgr", "Unrecognized type :".concat(String.valueOf(i2)));
                        AppMethodBeat.o(28161);
                        return;
                }
            } else {
                Log.w("MicroMsg.SubCoreShake", "func[onRecieveMsg] getShakeMsgMgr null");
                AppMethodBeat.o(28161);
            }
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private IListener Dhk = new IListener<rv>() {
        /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass3 */

        {
            AppMethodBeat.i(161431);
            this.__eventId = rv.class.getName().hashCode();
            AppMethodBeat.o(161431);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(rv rvVar) {
            AppMethodBeat.i(28152);
            rv rvVar2 = rvVar;
            if (!(rvVar2 instanceof rv)) {
                Log.e("MicroMsg.SubCoreShake", "mismatch event listener for ReportClickFindFriendShakeEvent");
                AppMethodBeat.o(28152);
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10221, Integer.valueOf(rvVar2.dYq.scene));
                AppMethodBeat.o(28152);
            }
            return false;
        }
    };
    private cj.a Dhl = new cj.a() {
        /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass4 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(final h.a aVar) {
            AppMethodBeat.i(28154);
            final String a2 = z.a(aVar.heO.KHn);
            if (a2 == null || a2.length() == 0) {
                Log.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardEntranceMsg msgContent is null");
                AppMethodBeat.o(28154);
                return;
            }
            m.this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass4.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(28153);
                    m.eUr().m(a2, aVar.heO.Brn, 0);
                    AppMethodBeat.o(28153);
                }
            });
            AppMethodBeat.o(28154);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private cj.a Dhm = new cj.a() {
        /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass5 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(final h.a aVar) {
            AppMethodBeat.i(28156);
            final String a2 = z.a(aVar.heO.KHn);
            if (a2 == null || a2.length() == 0) {
                Log.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
                AppMethodBeat.o(28156);
                return;
            }
            m.this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass5.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(28155);
                    m.eUr().m(a2, aVar.heO.Brn, 1);
                    AppMethodBeat.o(28155);
                }
            });
            AppMethodBeat.o(28156);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private IListener grk = new IListener<xi>() {
        /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass7 */

        {
            AppMethodBeat.i(161433);
            this.__eventId = xi.class.getName().hashCode();
            AppMethodBeat.o(161433);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xi xiVar) {
            AppMethodBeat.i(28158);
            xi xiVar2 = xiVar;
            if (xiVar2.edC.edD.equals(uo.class.getName())) {
                if (xiVar2.edC.dJY == 1) {
                    m.this.Dhi.LW();
                } else {
                    m.this.Dhi.unregister();
                }
            }
            AppMethodBeat.o(28158);
            return false;
        }
    };
    private bw.a iDJ = new bw.a() {
        /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass2 */

        @Override // com.tencent.mm.storage.bw.a
        public final void a(az azVar, bw bwVar) {
            AppMethodBeat.i(28151);
            if (azVar != null && ab.Jw(azVar.field_username)) {
                azVar.setUsername("");
            }
            AppMethodBeat.o(28151);
        }
    };
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper());

    public m() {
        AppMethodBeat.i(28163);
        AppMethodBeat.o(28163);
    }

    static /* synthetic */ m eUt() {
        AppMethodBeat.i(28176);
        m eUl = eUl();
        AppMethodBeat.o(28176);
        return eUl;
    }

    private static m eUl() {
        AppMethodBeat.i(28164);
        bg.aVz();
        m mVar = (m) cg.KG("plugin.shake");
        if (mVar == null) {
            mVar = new m();
            bg.aVz().a("plugin.shake", mVar);
        }
        AppMethodBeat.o(28164);
        return mVar;
    }

    public static e eUm() {
        AppMethodBeat.i(28165);
        g.aAf().azk();
        if (eUl().Dhc == null) {
            m eUl = eUl();
            bg.aVF();
            eUl.Dhc = new e(c.getDataDB());
        }
        e eVar = eUl().Dhc;
        AppMethodBeat.o(28165);
        return eVar;
    }

    public static g eUn() {
        AppMethodBeat.i(28166);
        g.aAf().azk();
        if (eUl().Dhd == null) {
            m eUl = eUl();
            bg.aVF();
            eUl.Dhd = new g(c.getDataDB());
        }
        g gVar = eUl().Dhd;
        AppMethodBeat.o(28166);
        return gVar;
    }

    public static o eUo() {
        AppMethodBeat.i(28167);
        g.aAf().azk();
        if (eUl().Dhg == null) {
            m eUl = eUl();
            bg.aVF();
            eUl.Dhg = new o(c.getDataDB());
        }
        o oVar = eUl().Dhg;
        AppMethodBeat.o(28167);
        return oVar;
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(28168);
        bg.aVF();
        c.aST().d(this.iDJ);
        EventCenter.instance.removeListener(this.grk);
        EventCenter.instance.removeListener(this.Dhk);
        EventCenter.instance.removeListener(this.Dhh);
        EventCenter.instance.removeListener(this.AgM);
        bg.aVF();
        c.aSN().b(this.AzD);
        bg.getSysCmdMsgExtension().b("shake", this.Dhj, true);
        bg.getSysCmdMsgExtension().b("ShakeCardEntrance", this.Dhl, true);
        bg.getSysCmdMsgExtension().b("ShakeCardRedDot", this.Dhm, true);
        o.a.JSX = null;
        AppMethodBeat.o(28168);
    }

    static {
        AppMethodBeat.i(28177);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("SHAKEITEM_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass8 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return e.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("SHAKEMSG_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass9 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return g.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("SHAKETVHISTORY_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass10 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.shake.d.a.o.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("SHAKENEWYEARFRIENDINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass11 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return k.SQL_CREATE;
            }
        });
        AppMethodBeat.o(28177);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    public static void eUp() {
        AppMethodBeat.i(28169);
        eUm().eUb();
        com.tencent.mm.bj.d.bgP().byC();
        AppMethodBeat.o(28169);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(28170);
        o.a.JSX = new h();
        bg.aVF();
        c.aST().c(this.iDJ);
        EventCenter.instance.addListener(this.grk);
        EventCenter.instance.addListener(this.Dhk);
        EventCenter.instance.addListener(this.Dhh);
        EventCenter.instance.addListener(this.AgM);
        bg.aVF();
        c.aSN().a(this.AzD);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.shake.b.m.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(28159);
                if (!bg.aAc()) {
                    AppMethodBeat.o(28159);
                    return;
                }
                bg.aVF();
                Util.deleteOutOfDateFile(c.aTe(), "Sk", 604800000);
                AppMethodBeat.o(28159);
            }

            public final String toString() {
                AppMethodBeat.i(28160);
                String str = super.toString() + "|onAccountPostReset";
                AppMethodBeat.o(28160);
                return str;
            }
        });
        bg.getSysCmdMsgExtension().a("shake", this.Dhj, true);
        bg.getSysCmdMsgExtension().a("ShakeCardEntrance", this.Dhl, true);
        bg.getSysCmdMsgExtension().a("ShakeCardRedDot", this.Dhm, true);
        this.Dhe = null;
        this.Dhf = null;
        AppMethodBeat.o(28170);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    public static i eUq() {
        AppMethodBeat.i(28171);
        g.aAf().azk();
        i iVar = i.INSTANCE;
        AppMethodBeat.o(28171);
        return iVar;
    }

    public static String ON(String str) {
        AppMethodBeat.i(28172);
        if (bg.aAc()) {
            bg.aVF();
            String format = String.format("%s/Sk_%s", c.aTe(), com.tencent.mm.b.g.getMessageDigest(str.getBytes()));
            AppMethodBeat.o(28172);
            return format;
        }
        AppMethodBeat.o(28172);
        return "";
    }

    public static String jP(String str, String str2) {
        AppMethodBeat.i(28173);
        if (!bg.aAc() || Util.isNullOrNil(str)) {
            AppMethodBeat.o(28173);
            return "";
        }
        bg.aVF();
        String format = String.format("%s/Sk%s_%s", c.aTe(), str2, com.tencent.mm.b.g.getMessageDigest(str.getBytes()));
        AppMethodBeat.o(28173);
        return format;
    }

    public static f eUr() {
        AppMethodBeat.i(28174);
        g.aAf().azk();
        if (eUl().Dhe == null) {
            eUl().Dhe = new f();
        }
        f fVar = eUl().Dhe;
        AppMethodBeat.o(28174);
        return fVar;
    }

    public static d eUs() {
        AppMethodBeat.i(28175);
        g.aAf().azk();
        if (eUl().Dhf == null) {
            eUl().Dhf = new d();
        }
        d dVar = eUl().Dhf;
        AppMethodBeat.o(28175);
        return dVar;
    }
}
