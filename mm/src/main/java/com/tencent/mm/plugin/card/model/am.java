package com.tencent.mm.plugin.card.model;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.card.PluginCard;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.n;
import com.tencent.mm.plugin.card.model.a.e;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.c;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.plugin.card.ui.CardHomePageUI;
import com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI;
import com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class am implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    private b pUA;
    private c pUB;
    private al pUC;
    private h pUD;
    private m pUE;
    private a pUF;
    private k pUG;
    private o pUH;
    private c pUI;
    private com.tencent.mm.plugin.card.b.k pUJ = null;
    private e pUK = null;
    private l pUL = null;
    private d pUM = null;
    private j pUN = null;
    private com.tencent.mm.plugin.card.b.c pUO;
    private g pUP;
    private l pUQ;
    private j pUR;
    private IListener pUS = new n();
    private IListener pUT = new com.tencent.mm.plugin.card.b.o();
    private IListener pUU = new com.tencent.mm.plugin.card.b.a();
    private com.tencent.mm.plugin.card.ui.b pUV = new com.tencent.mm.plugin.card.ui.b();
    private IListener pUW = new IListener<ji>() {
        /* class com.tencent.mm.plugin.card.model.am.AnonymousClass1 */

        {
            AppMethodBeat.i(161195);
            this.__eventId = ji.class.getName().hashCode();
            AppMethodBeat.o(161195);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ji jiVar) {
            AppMethodBeat.i(112873);
            final ji jiVar2 = jiVar;
            Log.i("MicroMsg.SubCoreCard.cardGetCountListener", "deal with card notify event GetCardCountEvent");
            if (jiVar2 instanceof ji) {
                am.this.mHandler.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.card.model.am.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        int i2;
                        Long l;
                        AppMethodBeat.i(112872);
                        if (!com.tencent.mm.kernel.g.aAc()) {
                            AppMethodBeat.o(112872);
                            return;
                        }
                        boolean z = jiVar2.dOb.dOc;
                        Log.i("MicroMsg.SubCoreCard.cardGetCountListener", "GetCardCountEvent isForceGet is ".concat(String.valueOf(z)));
                        boolean cxF = com.tencent.mm.plugin.card.d.l.cxF();
                        boolean cxH = com.tencent.mm.plugin.card.d.l.cxH();
                        if (!cxF || !cxH) {
                            if (z) {
                                com.tencent.mm.kernel.g.aAg().hqi.a(new y(), 0);
                            } else {
                                Integer num = (Integer) com.tencent.mm.kernel.g.aAh().azQ().get(282882, (Object) null);
                                if (num != null) {
                                    i2 = num.intValue();
                                } else {
                                    i2 = 0;
                                }
                                if (((int) (System.currentTimeMillis() / 1000)) - i2 >= 7200) {
                                    com.tencent.mm.kernel.g.aAg().hqi.a(new y(), 0);
                                }
                            }
                            if (cxH && (l = (Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_CARD_REQUENCE_LONG_SYNC, (Object) 0L)) != null && l.longValue() == 0) {
                                am.ctX().cuu();
                            }
                            if (cxF && TextUtils.isEmpty((String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, (Object) null))) {
                                am.ctP();
                                b.Ef(1);
                            }
                            AppMethodBeat.o(112872);
                            return;
                        }
                        Log.i("MicroMsg.SubCoreCard.cardGetCountListener", "card entrance and share card entrance is open");
                        AppMethodBeat.o(112872);
                    }
                }, 10000);
            }
            AppMethodBeat.o(112873);
            return false;
        }
    };
    private IListener pUX = new IListener<sr>() {
        /* class com.tencent.mm.plugin.card.model.am.AnonymousClass5 */

        {
            AppMethodBeat.i(161197);
            this.__eventId = sr.class.getName().hashCode();
            AppMethodBeat.o(161197);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sr srVar) {
            AppMethodBeat.i(112876);
            Log.i("MicroMsg.SubCoreCard.ResetCardRetryCounter", "deal with reset card retry counter event");
            al ctR = am.ctR();
            Log.d("MicroMsg.PendingCardIdInfoStorage", "resetRetryCounter");
            ctR.db.execSQL("PendingCardId", "update PendingCardId set retryCount = 0 where retryCount >= 10");
            AppMethodBeat.o(112876);
            return false;
        }
    };
    private cj.a pUY = new cj.a() {
        /* class com.tencent.mm.plugin.card.model.am.AnonymousClass6 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(final h.a aVar) {
            AppMethodBeat.i(112878);
            final String a2 = z.a(aVar.heO.KHn);
            if (a2 == null || a2.length() == 0) {
                Log.e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
                AppMethodBeat.o(112878);
                return;
            }
            am.this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.card.model.am.AnonymousClass6.AnonymousClass1 */

                /* JADX WARNING: Removed duplicated region for block: B:125:0x04c0  */
                /* JADX WARNING: Removed duplicated region for block: B:128:0x04cf  */
                /* JADX WARNING: Removed duplicated region for block: B:136:0x0508  */
                /* JADX WARNING: Removed duplicated region for block: B:139:0x0516  */
                /* JADX WARNING: Removed duplicated region for block: B:142:0x051f  */
                /* JADX WARNING: Removed duplicated region for block: B:145:0x0532  */
                /* JADX WARNING: Removed duplicated region for block: B:159:0x057c  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    // Method dump skipped, instructions count: 1967
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.model.am.AnonymousClass6.AnonymousClass1.run():void");
                }
            });
            AppMethodBeat.o(112878);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private cj.a pUZ = new cj.a() {
        /* class com.tencent.mm.plugin.card.model.am.AnonymousClass7 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(final h.a aVar) {
            AppMethodBeat.i(112880);
            final String a2 = z.a(aVar.heO.KHn);
            if (a2 == null || a2.length() == 0) {
                Log.e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
                AppMethodBeat.o(112880);
                return;
            }
            am.this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.card.model.am.AnonymousClass7.AnonymousClass1 */

                public final void run() {
                    c.a aVar = null;
                    AppMethodBeat.i(112879);
                    c cua = am.cua();
                    String str = a2;
                    Log.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is ".concat(String.valueOf(new StringBuilder().append(aVar.heO.Brn).toString())));
                    if (!TextUtils.isEmpty(str)) {
                        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
                        if (parseXml != null) {
                            c.a aVar2 = new c.a();
                            String str2 = parseXml.get(".sysmsg.notifysharecard.state_flag");
                            if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.d.l.isNumeric(str2)) {
                                aVar2.pVR = 0;
                            } else {
                                aVar2.pVR = Util.getInt(str2, 0);
                            }
                            aVar2.username = parseXml.get(".sysmsg.notifysharecard.username");
                            aVar2.eaO = parseXml.get(".sysmsg.notifysharecard.card_id");
                            aVar = aVar2;
                        }
                        if (aVar == null) {
                            Log.e("MicroMsg.ShareCardMsgMgr", "card msg == null");
                            AppMethodBeat.o(112879);
                            return;
                        }
                        if (TextUtils.isEmpty(aVar.eaO)) {
                            Log.e("MicroMsg.ShareCardMsgMgr", "card id == null");
                        }
                        Log.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + aVar.eaO);
                        am.ctX().cuu();
                        com.tencent.mm.plugin.card.d.l.cxG();
                    }
                    AppMethodBeat.o(112879);
                }
            });
            AppMethodBeat.o(112880);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private IListener<kl> pVa = new IListener<kl>() {
        /* class com.tencent.mm.plugin.card.model.am.AnonymousClass4 */

        {
            AppMethodBeat.i(161196);
            this.__eventId = kl.class.getName().hashCode();
            AppMethodBeat.o(161196);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(kl klVar) {
            AppMethodBeat.i(112875);
            boolean a2 = a(klVar);
            AppMethodBeat.o(112875);
            return a2;
        }

        private static boolean a(kl klVar) {
            AppMethodBeat.i(112874);
            int intValue = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_CARD_ENTRANCE_SWITCH_INT_SYNC, (Object) 1)).intValue();
            int intValue2 = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_CARD_ENTRANCE_TRADE_AREA_INT_SYNC, (Object) 1)).intValue();
            boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_CARD_ENTRANCE_SWITCH_V2_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
            Log.i("MicroMsg.SubCoreCard", "goto card version: %s, trade area: %s, newVersion2: %s", Integer.valueOf(intValue), Integer.valueOf(intValue2), Boolean.valueOf(booleanValue));
            if (booleanValue) {
                if (klVar.dPA.context != null) {
                    Intent intent = new Intent(klVar.dPA.context, CardHomePageV3UI.class);
                    Context context = klVar.dPA.context;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.plugin.card.b.k.ctF();
                    if (klVar.dPA.enterScene == 1) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 3);
                    }
                }
            } else if (intValue2 == 2) {
                String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_CARD_ENTRANCE_TRADE_AREA_INFO_STRING_SYNC, "");
                if (!Util.isNullOrNil(str)) {
                    try {
                        un unVar = (un) new un().parseFrom(str.getBytes(kotlin.n.d.ISO_8859_1));
                        com.tencent.mm.plugin.card.d.b.H(unVar.Hwr, unVar.Hws, unVar.IhZ);
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.SubCoreCard", e2, "", new Object[0]);
                    }
                }
            } else if (intValue != 1) {
                if (klVar.dPA.context != null) {
                    Intent intent2 = new Intent(klVar.dPA.context, CardHomePageUI.class);
                    intent2.putExtra("key_from_scene", 22);
                    intent2.putExtra("key_home_page_from_scene", klVar.dPA.scene);
                    Context context2 = klVar.dPA.context;
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context2.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.plugin.card.b.k.ctF();
                    if (klVar.dPA.enterScene == 1) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 2);
                    }
                }
                klVar.dPB.targetActivity = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
            } else if (klVar.dPA.context != null) {
                Intent intent3 = new Intent(klVar.dPA.context, CardHomePageNewUI.class);
                Context context3 = klVar.dPA.context;
                com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                com.tencent.mm.hellhoundlib.a.a.a(context3, bl3.axQ(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context3.startActivity((Intent) bl3.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context3, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.plugin.card.b.k.ctF();
                if (klVar.dPA.enterScene == 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 3);
                }
            }
            e.a aVar = com.tencent.mm.plugin.card.model.a.e.pVr;
            e.a.cup();
            AppMethodBeat.o(112874);
            return true;
        }
    };

    public am() {
        AppMethodBeat.i(112881);
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(m.pTN);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        com.tencent.mm.vfs.o oVar2 = new com.tencent.mm.vfs.o(m.pTO);
        if (!oVar2.exists()) {
            oVar2.mkdirs();
        }
        AppMethodBeat.o(112881);
    }

    private static am getCore() {
        am amVar;
        AppMethodBeat.i(112882);
        com.tencent.mm.plugin.card.a.a aVar = (com.tencent.mm.plugin.card.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.card.a.a.class);
        if (aVar != null) {
            amVar = ((PluginCard) aVar).getCore();
        } else {
            amVar = null;
        }
        AppMethodBeat.o(112882);
        return amVar;
    }

    static {
        AppMethodBeat.i(112903);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("USERCARDINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.card.model.am.AnonymousClass8 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return c.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("PENDINGCARDIDINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.card.model.am.AnonymousClass9 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return al.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("CARDMSGINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.card.model.am.AnonymousClass10 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return h.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("SHARECARDINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.card.model.am.AnonymousClass11 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return k.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("SHARECARDSYNCITEMINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.card.model.am.AnonymousClass12 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return o.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("CARDQRCODECONFI_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.card.model.am.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return j.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("CARDQRCODEDATAINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.card.model.am.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return l.SQL_CREATE;
            }
        });
        AppMethodBeat.o(112903);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(112883);
        Log.i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", Boolean.valueOf(z));
        EventCenter.instance.addListener(this.pUW);
        EventCenter.instance.addListener(this.pUX);
        EventCenter.instance.addListener(this.pUS);
        EventCenter.instance.addListener(this.pUT);
        EventCenter.instance.addListener(this.pUU);
        EventCenter.instance.addListener(this.pVa);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("carditemmsg", this.pUY, true);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("notifysharecard", this.pUZ, true);
        this.pUJ = null;
        if (this.pUK != null) {
            this.pUK.pQY.clear();
            this.pUK = null;
        }
        if (this.pUE != null) {
            m mVar = this.pUE;
            synchronized (mVar.pRR) {
                try {
                    mVar.pRR.clear();
                } finally {
                    AppMethodBeat.o(112883);
                }
            }
            synchronized (mVar.pRS) {
                try {
                    mVar.pRS.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            com.tencent.mm.kernel.g.aAg().hqi.b(1058, mVar);
            com.tencent.mm.modelgeo.d bca = com.tencent.mm.modelgeo.d.bca();
            if (bca != null) {
                bca.c(mVar);
            }
            if (mVar.pRU != null) {
                com.tencent.mm.kernel.g.aAg().hqi.a(mVar.pRU);
            }
            this.pUE = null;
        }
        if (this.pUA != null) {
            this.pUA.detach();
            this.pUA = null;
        }
        if (this.pUF != null) {
            a aVar = this.pUF;
            synchronized (aVar.lock) {
                try {
                    aVar.pendingList.clear();
                    aVar.pQE.clear();
                } catch (Throwable th2) {
                    AppMethodBeat.o(112883);
                    throw th2;
                }
            }
            if (aVar.pVH != null) {
                com.tencent.mm.kernel.g.aAg().hqi.a(aVar.pVH);
            }
            com.tencent.mm.kernel.g.aAg().hqi.b(1132, aVar);
            this.pUF = null;
        }
        if (this.pUM != null) {
            this.pUM.release();
            d dVar = this.pUM;
            dVar.pQG.clear();
            dVar.pQS.clear();
            dVar.pQT.clear();
            dVar.pQU.clear();
            dVar.pQW = false;
            this.pUM = null;
        }
        if (this.pUN != null) {
            j jVar = this.pUN;
            com.tencent.mm.kernel.g.aAg().hqi.b(1078, jVar);
            Iterator<String> it = jVar.pRD.iterator();
            while (it.hasNext()) {
                String next = it.next();
                jVar.pRF.remove(next);
                jVar.pRE.removeCallbacks(jVar.pRF.get(next));
            }
            jVar.pRC.clear();
            jVar.pRD.clear();
            jVar.pRF.clear();
            this.pUN = null;
        }
        if (this.pUO != null) {
            this.pUO.release();
            this.pUO = null;
        }
        if (this.pUP != null) {
            this.pUP.release();
            this.pUP = null;
        }
        this.pUL = null;
        com.tencent.mm.plugin.card.ui.b.bWY().registerActivityLifecycleCallbacks(this.pUV);
        if (z) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_CARD_ENTRANCE_SWITCH_INT_SYNC, (Object) 1);
        }
        AppMethodBeat.o(112883);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(112884);
        if (getCore().pUA != null) {
            getCore().pUA.detach();
        }
        EventCenter.instance.removeListener(this.pUW);
        EventCenter.instance.removeListener(this.pUX);
        EventCenter.instance.removeListener(this.pUS);
        EventCenter.instance.removeListener(this.pUT);
        EventCenter.instance.removeListener(this.pUU);
        EventCenter.instance.removeListener(this.pVa);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("carditemmsg", this.pUY, true);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("notifysharecard", this.pUZ, true);
        com.tencent.mm.plugin.card.ui.b.bWY().unregisterActivityLifecycleCallbacks(this.pUV);
        AppMethodBeat.o(112884);
    }

    public static b ctP() {
        AppMethodBeat.i(112885);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUA == null) {
            getCore().pUA = new b();
        }
        b bVar = getCore().pUA;
        AppMethodBeat.o(112885);
        return bVar;
    }

    public static c ctQ() {
        AppMethodBeat.i(112886);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUB == null) {
            getCore().pUB = new c(com.tencent.mm.kernel.g.aAh().hqK);
        }
        c cVar = getCore().pUB;
        AppMethodBeat.o(112886);
        return cVar;
    }

    public static al ctR() {
        AppMethodBeat.i(112887);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUC == null) {
            getCore().pUC = new al(com.tencent.mm.kernel.g.aAh().hqK);
        }
        al alVar = getCore().pUC;
        AppMethodBeat.o(112887);
        return alVar;
    }

    public static h ctS() {
        AppMethodBeat.i(112888);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUD == null) {
            getCore().pUD = new h(com.tencent.mm.kernel.g.aAh().hqK);
        }
        h hVar = getCore().pUD;
        AppMethodBeat.o(112888);
        return hVar;
    }

    public static m ctT() {
        AppMethodBeat.i(112889);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUE == null) {
            getCore().pUE = new m();
        }
        m mVar = getCore().pUE;
        AppMethodBeat.o(112889);
        return mVar;
    }

    public static com.tencent.mm.plugin.card.b.k ctU() {
        AppMethodBeat.i(112890);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUJ == null) {
            getCore().pUJ = new com.tencent.mm.plugin.card.b.k();
        }
        com.tencent.mm.plugin.card.b.k kVar = getCore().pUJ;
        AppMethodBeat.o(112890);
        return kVar;
    }

    public static com.tencent.mm.plugin.card.b.e ctV() {
        AppMethodBeat.i(112891);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUK == null) {
            getCore().pUK = new com.tencent.mm.plugin.card.b.e();
        }
        com.tencent.mm.plugin.card.b.e eVar = getCore().pUK;
        AppMethodBeat.o(112891);
        return eVar;
    }

    public static l ctW() {
        AppMethodBeat.i(112892);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUL == null) {
            getCore().pUL = new l();
        }
        l lVar = getCore().pUL;
        AppMethodBeat.o(112892);
        return lVar;
    }

    public static a ctX() {
        AppMethodBeat.i(112893);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUF == null) {
            getCore().pUF = new a();
        }
        a aVar = getCore().pUF;
        AppMethodBeat.o(112893);
        return aVar;
    }

    public static k ctY() {
        AppMethodBeat.i(112894);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUG == null) {
            getCore().pUG = new k(com.tencent.mm.kernel.g.aAh().hqK);
        }
        k kVar = getCore().pUG;
        AppMethodBeat.o(112894);
        return kVar;
    }

    public static o ctZ() {
        AppMethodBeat.i(112895);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUH == null) {
            getCore().pUH = new o(com.tencent.mm.kernel.g.aAh().hqK);
        }
        o oVar = getCore().pUH;
        AppMethodBeat.o(112895);
        return oVar;
    }

    public static c cua() {
        AppMethodBeat.i(112896);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUI == null) {
            getCore().pUI = new c();
        }
        c cVar = getCore().pUI;
        AppMethodBeat.o(112896);
        return cVar;
    }

    public static d cub() {
        AppMethodBeat.i(112897);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUM == null) {
            getCore().pUM = new d();
        }
        d dVar = getCore().pUM;
        AppMethodBeat.o(112897);
        return dVar;
    }

    public static j cuc() {
        AppMethodBeat.i(112898);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUN == null) {
            getCore().pUN = new j();
        }
        j jVar = getCore().pUN;
        AppMethodBeat.o(112898);
        return jVar;
    }

    public static com.tencent.mm.plugin.card.b.c cud() {
        AppMethodBeat.i(112899);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUO == null) {
            getCore().pUO = new com.tencent.mm.plugin.card.b.c();
        }
        com.tencent.mm.plugin.card.b.c cVar = getCore().pUO;
        AppMethodBeat.o(112899);
        return cVar;
    }

    public static l cue() {
        AppMethodBeat.i(112900);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUQ == null) {
            getCore().pUQ = new l(com.tencent.mm.kernel.g.aAh().hqK);
        }
        l lVar = getCore().pUQ;
        AppMethodBeat.o(112900);
        return lVar;
    }

    public static j cuf() {
        AppMethodBeat.i(112901);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUR == null) {
            getCore().pUR = new j(com.tencent.mm.kernel.g.aAh().hqK);
        }
        j jVar = getCore().pUR;
        AppMethodBeat.o(112901);
        return jVar;
    }

    public static g cug() {
        AppMethodBeat.i(112902);
        com.tencent.mm.kernel.g.aAf().azk();
        if (getCore().pUP == null) {
            getCore().pUP = new g();
        }
        g gVar = getCore().pUP;
        AppMethodBeat.o(112902);
        return gVar;
    }
}
