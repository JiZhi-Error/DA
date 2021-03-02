package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.aq;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.l;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class PluginWebSearch extends f implements b, com.tencent.mm.kernel.api.a, c, com.tencent.mm.plugin.websearch.api.c {
    static final int[] ICU = {64};
    private static HashMap<Integer, h.b> dgj = new HashMap<>();
    private q GiO = new q() {
        /* class com.tencent.mm.plugin.websearch.PluginWebSearch.AnonymousClass6 */

        {
            AppMethodBeat.i(168798);
            AppMethodBeat.o(168798);
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
            int safeParseInt;
            AppMethodBeat.i(116516);
            if (map != null && str != null && str.equals("mmsearch_reddot_new") && (safeParseInt = Util.safeParseInt(map.get(".sysmsg.mmsearch_reddot_new.entry"))) == 1) {
                Log.i("MicroMsg.WebSearch.PluginWebSearch", "recv %s, %s", "mmsearch_reddot_new", map.toString());
                int safeParseInt2 = Util.safeParseInt(map.get(".sysmsg.mmsearch_reddot_new.clear"));
                String safeFormatString = Util.safeFormatString(map.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
                int safeParseInt3 = Util.safeParseInt(map.get(".sysmsg.mmsearch_reddot_new.discovery"));
                int safeParseInt4 = Util.safeParseInt(map.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
                long safeParseLong = Util.safeParseLong(map.get(".sysmsg.mmsearch_reddot_new.expire_time"));
                int safeParseInt5 = Util.safeParseInt(map.get(".sysmsg.mmsearch_reddot_new.h5_version"));
                int safeParseInt6 = Util.safeParseInt(map.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
                String str2 = map.get(".sysmsg.mmsearch_reddot_new.reddot_text");
                String str3 = map.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
                long safeParseLong2 = Util.safeParseLong(map.get(".sysmsg.mmsearch_reddot_new.timestamp"));
                aq fYk = aq.fYk();
                aq.a aVar2 = null;
                switch (safeParseInt) {
                    case 1:
                        aVar2 = fYk.IFk;
                        break;
                }
                if (aVar2 == null) {
                    aVar2 = new aq.a();
                }
                if (aVar2.timestamp < safeParseLong2) {
                    aVar2.id = safeFormatString;
                    aVar2.IFp = safeParseInt3;
                    aVar2.IFn = safeParseInt;
                    aVar2.IFo = safeParseInt4;
                    aVar2.jIU = safeParseLong;
                    aVar2.IEj = safeParseInt5;
                    aVar2.type = safeParseInt6;
                    aVar2.text = str2;
                    aVar2.icon = str3;
                    aVar2.timestamp = safeParseLong2;
                    aVar2.clear = safeParseInt2;
                    aVar2.iUm = System.currentTimeMillis();
                } else {
                    Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "timestamp %d not big than last msg %d", Long.valueOf(safeParseLong2), Long.valueOf(aVar2.timestamp));
                }
                fYk.save();
                EventCenter.instance.publish(new ts());
            }
            AppMethodBeat.o(116516);
        }
    };
    private a ICS;
    private b ICT;
    private final IListener checkLanguageChangeIListener = new IListener<bn>() {
        /* class com.tencent.mm.plugin.websearch.PluginWebSearch.AnonymousClass2 */

        {
            AppMethodBeat.i(161797);
            this.__eventId = bn.class.getName().hashCode();
            AppMethodBeat.o(161797);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bn bnVar) {
            AppMethodBeat.i(116510);
            b unused = PluginWebSearch.this.ICT;
            b.fXt();
            AppMethodBeat.o(116510);
            return false;
        }
    };
    private com.tencent.mm.plugin.teenmode.a.c kIM = new com.tencent.mm.plugin.teenmode.a.c() {
        /* class com.tencent.mm.plugin.websearch.PluginWebSearch.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.teenmode.a.c
        public final void onDataChanged() {
            AppMethodBeat.i(201753);
            ak.bq(20, true);
            AppMethodBeat.o(201753);
        }
    };
    private IListener kiA = new IListener<bp>() {
        /* class com.tencent.mm.plugin.websearch.PluginWebSearch.AnonymousClass4 */

        {
            AppMethodBeat.i(161798);
            this.__eventId = bp.class.getName().hashCode();
            AppMethodBeat.o(161798);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bp bpVar) {
            AppMethodBeat.i(116513);
            boolean a2 = a(bpVar);
            AppMethodBeat.o(116513);
            return a2;
        }

        private static boolean a(bp bpVar) {
            int i2;
            AppMethodBeat.i(116512);
            if (bpVar != null) {
                if (bpVar.dEN.dEO == 27 && bpVar.dEN.subType == 1) {
                    i2 = 0;
                } else if (bpVar.dEN.dEO == 27 && bpVar.dEN.subType == 2) {
                    i2 = 1;
                } else if (bpVar.dEN.dEO == 62 && bpVar.dEN.subType == 1) {
                    i2 = 2;
                } else if (bpVar.dEN.dEO == 40 && bpVar.dEN.subType == 1) {
                    i2 = 3;
                } else if (bpVar.dEN.dEO == 64 && bpVar.dEN.subType == 1) {
                    i2 = 4;
                } else if (bpVar.dEN.dEO == 66 && bpVar.dEN.subType == 1) {
                    i2 = 5;
                } else if (bpVar.dEN.dEO == 79 && bpVar.dEN.subType == 1) {
                    i2 = 6;
                } else if (bpVar.dEN.dEO == 85 && bpVar.dEN.subType == 1) {
                    i2 = 7;
                } else if (bpVar.dEN.dEO == 84 && bpVar.dEN.subType == 1) {
                    i2 = 8;
                } else {
                    AppMethodBeat.o(116512);
                    return false;
                }
                int i3 = i2 * 30;
                e.INSTANCE.idkeyStat(1181, (long) (i3 + 0), 1, false);
                int aXk = at.aXk(bpVar.dEN.filePath);
                if (aXk == 1) {
                    e.INSTANCE.idkeyStat(1181, (long) (i3 + 1), 1, false);
                } else {
                    e.INSTANCE.idkeyStat(1181, (long) (i3 + 2), 1, false);
                }
                at afr = ai.afr(i2);
                if (aXk >= afr.bbw()) {
                    e.INSTANCE.idkeyStat(1181, (long) (i3 + 4), 1, false);
                    for (int i4 = 0; i4 < 3; i4++) {
                        afr.aXj(bpVar.dEN.filePath);
                        if (afr.fYz()) {
                            break;
                        }
                        Log.i("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate invalid md5 and delete template folder retryTimes:%s", Integer.valueOf(i4));
                    }
                    if (afr.fYz()) {
                        e.INSTANCE.idkeyStat(1181, (long) (i3 + 6), 1, false);
                        Log.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final update success version %d", Integer.valueOf(aXk));
                        if (i2 == 0) {
                            ai.fXZ();
                        }
                        ar.afC(i2);
                    } else {
                        e.INSTANCE.idkeyStat(1181, (long) (i3 + 5), 1, false);
                        Log.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final md5 is invalid!");
                    }
                } else {
                    e.INSTANCE.idkeyStat(1181, (long) (i3 + 3), 1, false);
                }
            }
            AppMethodBeat.o(116512);
            return false;
        }
    };
    private IListener plI = new IListener<lx>() {
        /* class com.tencent.mm.plugin.websearch.PluginWebSearch.AnonymousClass5 */

        {
            AppMethodBeat.i(161799);
            this.__eventId = lx.class.getName().hashCode();
            AppMethodBeat.o(161799);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lx lxVar) {
            AppMethodBeat.i(116515);
            boolean a2 = a(lxVar);
            AppMethodBeat.o(116515);
            return a2;
        }

        private static boolean a(lx lxVar) {
            int i2 = 1;
            AppMethodBeat.i(116514);
            if (lxVar.dRu.dEO == 27 && lxVar.dRu.subType == 1) {
                i2 = 0;
            } else if (!(lxVar.dRu.dEO == 27 && lxVar.dRu.subType == 2)) {
                if (lxVar.dRu.dEO == 62 && lxVar.dRu.subType == 1) {
                    i2 = 2;
                } else if (lxVar.dRu.dEO == 40 && lxVar.dRu.subType == 1) {
                    i2 = 3;
                } else if (lxVar.dRu.dEO == 64 && lxVar.dRu.subType == 1) {
                    i2 = 4;
                } else if (lxVar.dRu.dEO == 66 && lxVar.dRu.subType == 1) {
                    i2 = 5;
                } else if (lxVar.dRu.dEO == 79 && lxVar.dRu.subType == 1) {
                    i2 = 6;
                } else if (lxVar.dRu.dEO == 85 && lxVar.dRu.subType == 1) {
                    i2 = 7;
                } else if (lxVar.dRu.dEO == 84 && lxVar.dRu.subType == 1) {
                    i2 = 8;
                } else {
                    AppMethodBeat.o(116514);
                    return false;
                }
            }
            ai.afr(i2).aXj(lxVar.dRu.filePath);
            if (i2 == 0) {
                ai.fXZ();
            }
            AppMethodBeat.o(116514);
            return false;
        }
    };

    public PluginWebSearch() {
        AppMethodBeat.i(116518);
        AppMethodBeat.o(116518);
    }

    static /* synthetic */ void access$100(PluginWebSearch pluginWebSearch, boolean z) {
        AppMethodBeat.i(116524);
        pluginWebSearch.checkWebSearchTemplate(z);
        AppMethodBeat.o(116524);
    }

    static {
        AppMethodBeat.i(116525);
        final String[] strArr = {MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.websearch.widget.a.a.info, "WidgetSafeMode")};
        dgj.put(Integer.valueOf("WidgetSafeMode".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.websearch.PluginWebSearch.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return strArr;
            }
        });
        AppMethodBeat.o(116525);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(116519);
        super.installed();
        AppMethodBeat.o(116519);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public void parallelsDependency() {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(116520);
        super.configure(gVar);
        this.ICS = new a();
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.h.class, new com.tencent.mm.kernel.c.e(this.ICS));
        com.tencent.mm.kernel.g.a(j.class, new com.tencent.mm.kernel.c.e(new c()));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.b()));
        com.tencent.mm.kernel.g.a(l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.c()));
        if (com.tencent.mm.kernel.g.aAe().azG().aBb()) {
            this.ICT = new b();
            com.tencent.mm.kernel.g.a(i.class, new com.tencent.mm.kernel.c.e(this.ICT));
        }
        AppMethodBeat.o(116520);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(116521);
        this.kiA.alive();
        this.plI.alive();
        manualCheckRes();
        this.checkLanguageChangeIListener.alive();
        b.init();
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.GiO);
        com.tencent.f.h.RTc.b(new a(cVar.hrc), "WebSearchThread");
        ai.LW(5000);
        ai.LX(5000);
        ar.afC(-1);
        ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).a(this.kIM);
        AppMethodBeat.o(116521);
    }

    private void manualCheckRes() {
        AppMethodBeat.i(168802);
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("MicroMsg.WebSearch.PluginWebSearch");
        long decodeLong = singleMMKV.decodeLong("last_check_res_time", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long abs = Math.abs(currentTimeMillis - decodeLong);
        if (abs < Util.MILLSECONDS_OF_DAY) {
            Log.i("MicroMsg.WebSearch.PluginWebSearch", "manualCheckRes return lastCheckTime %d, current %d, gap %d", Long.valueOf(decodeLong), Long.valueOf(currentTimeMillis), Long.valueOf(abs));
            AppMethodBeat.o(168802);
            return;
        }
        singleMMKV.encode("last_check_res_time", currentTimeMillis);
        Log.i("MicroMsg.WebSearch.PluginWebSearch", "manualCheckRes");
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.websearch.PluginWebSearch.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(116511);
                int[] iArr = PluginWebSearch.ICU;
                for (int i2 : iArr) {
                    com.tencent.mm.pluginsdk.j.a.a.b.gnC();
                    com.tencent.mm.pluginsdk.j.a.a.b.ahP(i2);
                }
                AppMethodBeat.o(116511);
            }
        }, 3000);
        AppMethodBeat.o(168802);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(201754);
        dependsOn(com.tencent.mm.plugin.teenmode.a.a.class);
        AppMethodBeat.o(201754);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(116522);
        ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).b(this.kIM);
        this.kiA.dead();
        this.plI.dead();
        this.checkLanguageChangeIListener.dead();
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", this.GiO);
        am.IEW = null;
        AppMethodBeat.o(116522);
    }

    private void checkWebSearchTemplate(boolean z) {
        boolean z2;
        AppMethodBeat.i(116523);
        Log.i("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate %b", Boolean.valueOf(z));
        int[] iArr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = iArr[i2];
            at afr = ai.afr(i3);
            int bbx = afr.bbx();
            afr.fYq();
            int bbw = afr.bbw();
            if (bbw == 1) {
                Log.i("MicroMsg.WebSearch.PluginWebSearch", "first time init template");
                z2 = true;
            } else {
                com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
                if (Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("search", "openResetTemplate")), 0) == 1) {
                    Log.i("MicroMsg.WebSearch.PluginWebSearch", "expt reset template");
                    z2 = true;
                } else if (bbw < bbx) {
                    Log.i("MicroMsg.WebSearch.PluginWebSearch", "update template currentVersion %d assetVersion %d", Integer.valueOf(bbw), Integer.valueOf(bbx));
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                afr.fYA();
            }
            if (!afr.fYz()) {
                for (int i4 = 1; i4 <= 3; i4++) {
                    Log.i("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate invalid md5 and delete template folder retryTimes:%s", Integer.valueOf(i4));
                    afr.fYA();
                    if (afr.fYz()) {
                        break;
                    }
                }
            }
            if (!afr.fYz()) {
                Log.w("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate final md5 is invalid!");
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1181, (long) ((i3 * 30) + 7), 1, false);
            }
        }
        AppMethodBeat.o(116523);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        return dgj;
    }

    class a implements Runnable {
        boolean ICW;

        a(boolean z) {
            this.ICW = z;
        }

        public final void run() {
            AppMethodBeat.i(116517);
            PluginWebSearch.access$100(PluginWebSearch.this, this.ICW);
            AppMethodBeat.o(116517);
        }
    }

    @Override // com.tencent.mm.plugin.websearch.api.c
    public boolean isOpenFingerSearch() {
        AppMethodBeat.i(201755);
        com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
        if (com.tencent.mm.util.c.hdg()) {
            AppMethodBeat.o(201755);
            return true;
        } else if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finger_search_flag, 0) == 1) {
            AppMethodBeat.o(201755);
            return true;
        } else {
            AppMethodBeat.o(201755);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.websearch.api.c
    public boolean isOpenHotWordSearch() {
        AppMethodBeat.i(201756);
        com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
        if (com.tencent.mm.util.c.hdg()) {
            AppMethodBeat.o(201756);
            return true;
        } else if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finger_hotword_search_flag, 0) == 1) {
            AppMethodBeat.o(201756);
            return true;
        } else {
            AppMethodBeat.o(201756);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.websearch.api.c
    public boolean isOpenImageSearch() {
        AppMethodBeat.i(201757);
        com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
        if (com.tencent.mm.util.c.hdg()) {
            com.tencent.mm.util.c cVar2 = com.tencent.mm.util.c.QYz;
            if (Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("websearch", "openImageSearch")), 0) == 1) {
                AppMethodBeat.o(201757);
                return true;
            }
            AppMethodBeat.o(201757);
            return false;
        } else if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_image_search_flag, 0) == 1) {
            AppMethodBeat.o(201757);
            return true;
        } else {
            AppMethodBeat.o(201757);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.websearch.api.c
    public boolean isOpenInlineC2CTag() {
        AppMethodBeat.i(201758);
        com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
        if (com.tencent.mm.util.c.hdg()) {
            AppMethodBeat.o(201758);
            return true;
        }
        b.a aVar = b.a.clicfg_open_inline_tag_c2c_flag;
        com.tencent.mm.util.c cVar2 = com.tencent.mm.util.c.QYz;
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, com.tencent.mm.util.c.hdi()) == 1) {
            AppMethodBeat.o(201758);
            return true;
        }
        AppMethodBeat.o(201758);
        return false;
    }

    @Override // com.tencent.mm.plugin.websearch.api.c
    public boolean isOpenInlineSnsTag() {
        AppMethodBeat.i(201759);
        com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
        if (com.tencent.mm.util.c.hdg()) {
            AppMethodBeat.o(201759);
            return true;
        }
        b.a aVar = b.a.clicfg_open_inline_tag_sns_flag;
        com.tencent.mm.util.c cVar2 = com.tencent.mm.util.c.QYz;
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, com.tencent.mm.util.c.hdj()) == 1) {
            AppMethodBeat.o(201759);
            return true;
        }
        AppMethodBeat.o(201759);
        return false;
    }

    @Override // com.tencent.mm.plugin.websearch.api.c
    public int getSosLimitLength() {
        AppMethodBeat.i(201761);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sos_limit_length, 100);
        AppMethodBeat.o(201761);
        return a2;
    }

    @Override // com.tencent.mm.plugin.websearch.api.c
    public String getExposedWord(String str) {
        AppMethodBeat.i(201762);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sos_exposed_words_and, (String) null);
        if (TextUtils.isEmpty(a2)) {
            AppMethodBeat.o(201762);
            return "";
        }
        try {
            JSONObject optJSONObject = new JSONObject(a2).optJSONObject("exposedWords");
            if (optJSONObject == null) {
                AppMethodBeat.o(201762);
                return "";
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
            if (optJSONObject2 == null) {
                AppMethodBeat.o(201762);
                return "";
            }
            String applicationLanguage = LocaleUtil.getApplicationLanguage();
            String optString = optJSONObject2.optString(applicationLanguage);
            if (TextUtils.isEmpty(optString) && !TextUtils.equals(applicationLanguage, LocaleUtil.ENGLISH)) {
                optString = optJSONObject2.optString(LocaleUtil.ENGLISH);
            }
            AppMethodBeat.o(201762);
            return optString;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", th, "getExposedWord:%s", str);
            AppMethodBeat.o(201762);
            return "";
        }
    }

    @Override // com.tencent.mm.plugin.websearch.api.c
    public List<String> getNeedReuseBrands() {
        AppMethodBeat.i(201763);
        List<String> optListFromJSONStr = optListFromJSONStr(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_editor_helper_conf, "{\n\t\"reuseBrands\":[\"vivo\",\"samsung\"],\n\t\"reuseItems\":[\"剪贴板\",\"Clipboard\",\"剪貼板\"]\n}"), "reuseBrands");
        AppMethodBeat.o(201763);
        return optListFromJSONStr;
    }

    @Override // com.tencent.mm.plugin.websearch.api.c
    public List<String> getNeedReuseItems() {
        AppMethodBeat.i(201764);
        List<String> optListFromJSONStr = optListFromJSONStr(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_editor_helper_conf, "{\n\t\"reuseBrands\":[\"vivo\",\"samsung\"],\n\t\"reuseItems\":[\"剪贴板\",\"Clipboard\",\"剪貼板\"]\n}"), "reuseItems");
        AppMethodBeat.o(201764);
        return optListFromJSONStr;
    }

    private static List<String> optListFromJSONStr(String str, String str2) {
        AppMethodBeat.i(201765);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(201765);
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray(str2);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString = optJSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        linkedList.add(optString);
                    }
                }
                AppMethodBeat.o(201765);
                return linkedList;
            }
        } catch (Throwable th) {
            Log.e("MicroMsg.WebSearch.PluginWebSearch", "optListFromJSONStr err! %s", Util.stackTraceToString(th));
        }
        AppMethodBeat.o(201765);
        return null;
    }

    @Override // com.tencent.mm.plugin.websearch.api.c
    public void startImageSearch(o oVar) {
        AppMethodBeat.i(201766);
        Intent intent = new Intent();
        int searchImageRequestType = getSearchImageRequestType(oVar.dTX, oVar.dGf);
        intent.putExtra("key_source", oVar.dGf);
        intent.putExtra("key_scan_goods_request_type", searchImageRequestType);
        switch (oVar.dGf) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                long Ni = d.Ni(81);
                intent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI");
                intent.putExtra("key_sns_id", oVar.dRS);
                intent.putExtra("key_sns_username", oVar.IDs);
                intent.putExtra("key_sns_image_path", oVar.dHq);
                intent.putExtra("key_session_id", Ni);
                if (oVar.DIq != null) {
                    try {
                        intent.putExtra("key_sns_media", oVar.DIq.toByteArray());
                    } catch (Exception e2) {
                    }
                }
                Log.i("MicroMsg.WebSearch.PluginWebSearch", "startImageSearch %s %s %s %s %s", oVar.dRS, oVar.IDs, oVar.dHq, Integer.valueOf(oVar.dGf), Long.valueOf(Ni));
                break;
            default:
                long Ni2 = d.Ni(67);
                intent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.websearch.ui.WebSearchImageLoadingUI");
                intent.putExtra("key_source", oVar.dGf);
                intent.putExtra("key_msg_id", oVar.dTX.field_msgId);
                intent.putExtra("key_session_id", Ni2);
                Log.i("MicroMsg.WebSearch.PluginWebSearch", "startImageSearch %s %s %s", Long.valueOf(oVar.dTX.field_msgId), Integer.valueOf(oVar.dGf), Long.valueOf(Ni2));
                break;
        }
        Context context = oVar.context;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/websearch/PluginWebSearch", "startImageSearch", "(Lcom/tencent/mm/plugin/websearch/api/ImageSearchContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/websearch/PluginWebSearch", "startImageSearch", "(Lcom/tencent/mm/plugin/websearch/api/ImageSearchContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(201766);
    }

    private int getSearchImageRequestType(ca caVar, int i2) {
        AppMethodBeat.i(201767);
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
                if (caVar == null) {
                    AppMethodBeat.o(201767);
                    return 0;
                } else if (ab.Eq(caVar.field_talker)) {
                    AppMethodBeat.o(201767);
                    return 4;
                } else {
                    AppMethodBeat.o(201767);
                    return 3;
                }
            case 5:
            case 10:
                AppMethodBeat.o(201767);
                return 5;
            case 6:
                AppMethodBeat.o(201767);
                return 6;
            case 7:
            case 8:
                AppMethodBeat.o(201767);
                return 7;
            case 9:
                AppMethodBeat.o(201767);
                return 9;
            default:
                AppMethodBeat.o(201767);
                return 0;
        }
    }

    public boolean isUseSysEditText() {
        AppMethodBeat.i(201760);
        boolean gKc = a.C2075a.OLX.gKc();
        if (gKc) {
            com.tencent.mm.ui.widget.cedit.api.b.aow(10);
        }
        b.a aVar = b.a.clicfg_is_use_sys_edit_text;
        com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("search", "isUseSysEditText")), 0)) == 1 || gKc || ao.gJX()) {
            AppMethodBeat.o(201760);
            return true;
        }
        AppMethodBeat.o(201760);
        return false;
    }
}
