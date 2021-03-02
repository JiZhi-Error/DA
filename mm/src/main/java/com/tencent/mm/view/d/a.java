package com.tencent.mm.view.d;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.af;
import com.tencent.mm.emoji.b.b.ag;
import com.tencent.mm.emoji.b.b.ak;
import com.tencent.mm.emoji.b.b.al;
import com.tencent.mm.emoji.b.b.i;
import com.tencent.mm.emoji.b.b.j;
import com.tencent.mm.emoji.b.b.v;
import com.tencent.mm.emoji.b.b.w;
import com.tencent.mm.emoji.b.b.y;
import com.tencent.mm.emoji.panel.a.ab;
import com.tencent.mm.emoji.panel.a.ad;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.emoji.panel.a.g;
import com.tencent.mm.emoji.panel.layout.EmojiPanelLayoutManager;
import com.tencent.mm.emoji.panel.layout.a;
import com.tencent.mm.g.a.Cdo;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.g.a.xf;
import com.tencent.mm.g.b.a.aq;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.emoji.ui.b;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.u;
import java.util.List;
import kotlin.g.b.p;

public final class a {
    private static boolean RpJ = true;
    public String RpA = null;
    public boolean RpB = false;
    public RecyclerView RpC;
    public g RpD;
    public d RpE;
    public View RpF;
    public ImageView RpG;
    public RecyclerView RpH;
    public ad RpI;
    public i RpK;
    public final j RpL;
    private v RpM;
    public boolean RpN = false;
    public ak RpO;
    public final com.tencent.mm.emoji.panel.a.j RpP = new com.tencent.mm.emoji.panel.a.j();
    public final ab RpQ = new ab();
    public af RpR = new af();
    public b RpS;
    public final IListener<Cdo> RpT = new IListener<Cdo>() {
        /* class com.tencent.mm.view.d.a.AnonymousClass10 */

        {
            AppMethodBeat.i(161806);
            this.__eventId = Cdo.class.getName().hashCode();
            AppMethodBeat.o(161806);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(Cdo doVar) {
            final String str;
            AppMethodBeat.i(105289);
            Cdo doVar2 = doVar;
            if (doVar2.dGz.type == 1) {
                str = com.tencent.mm.emoji.b.b.ad.avC();
            } else if (doVar2.dGz.type == 2) {
                str = com.tencent.mm.emoji.b.b.ad.avD();
            } else {
                str = null;
            }
            if (!Util.isNullOrNil(str)) {
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.view.d.a.AnonymousClass10.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(105288);
                        a.this.blU(str);
                        AppMethodBeat.o(105288);
                    }
                }, 500);
                doVar2.dGA.dGB = true;
                Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update custom panel.");
            }
            AppMethodBeat.o(105289);
            return false;
        }
    };
    public ad.b RpU = new ad.b() {
        /* class com.tencent.mm.view.d.a.AnonymousClass11 */

        @Override // com.tencent.mm.emoji.panel.a.ad.b
        public final void b(int i2, View view) {
            AppMethodBeat.i(105290);
            ag pp = a.this.RpI.pp(i2);
            if (pp == null) {
                Log.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab is null. ignore click action.");
                AppMethodBeat.o(105290);
            } else if (pp.type == 1) {
                a.kN(view.getContext());
                AppMethodBeat.o(105290);
            } else if (pp.type != 2) {
                EmojiGroupInfo emojiGroupInfo = pp.gVA;
                com.tencent.mm.emoji.c.g gVar = com.tencent.mm.emoji.c.g.hcn;
                com.tencent.mm.emoji.c.g.B(pp.bEC + 1, emojiGroupInfo.field_productID);
                a.this.setTabSelected(pp.bEC);
                RecyclerView recyclerView = a.this.RpC;
                com.tencent.mm.hellhoundlib.b.a a2 = c.a(pp.bEC, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
                if (emojiGroupInfo.field_productID.equals(com.tencent.mm.emoji.b.b.ad.avD()) && a.this.RpK.gYk) {
                    if (com.tencent.mm.kernel.g.aAe().azG().aBb()) {
                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_EMOJI_CAPTURE_TAB_RED_DOT_BOOLEAN, Boolean.TRUE);
                    }
                    View findViewById = view.findViewById(R.id.htc);
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                }
                AppMethodBeat.o(105290);
            } else if (com.tencent.mm.search.a.gxp()) {
                a.a(a.this, view.getContext());
                AppMethodBeat.o(105290);
            } else {
                a.b(a.this, view.getContext());
                AppMethodBeat.o(105290);
            }
        }
    };
    public a.b RpV = new a.b() {
        /* class com.tencent.mm.view.d.a.AnonymousClass2 */

        @Override // com.tencent.mm.emoji.panel.layout.a.b
        public final void onPageSelected(int i2) {
            AppMethodBeat.i(105281);
            a.this.setTabSelected(i2);
            AppMethodBeat.o(105281);
        }
    };
    public IListener<xf> RpW = new IListener<xf>() {
        /* class com.tencent.mm.view.d.a.AnonymousClass3 */

        {
            AppMethodBeat.i(199831);
            this.__eventId = xf.class.getName().hashCode();
            AppMethodBeat.o(199831);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xf xfVar) {
            AppMethodBeat.i(199832);
            Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "kv stat update click cell item");
            h.INSTANCE.kvStat(11076, "1," + xfVar.edz.productId);
            a.this.RpW.dead();
            AppMethodBeat.o(199832);
            return true;
        }
    };
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    public Context context;
    public ChatFooterPanel.a har;
    public boolean isResume = false;
    public String rgD;
    public String rgH;
    public com.tencent.mm.pluginsdk.ui.chat.j rgI;
    public LinearLayoutManager vKp;
    public final MStorage.IOnStorageChange wKe = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.view.d.a.AnonymousClass7 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(105285);
            if (!TextUtils.isEmpty(str) && str.equals("event_update_group")) {
                Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
                a.this.RpL.avu();
            }
            AppMethodBeat.o(105285);
        }
    };
    public final MStorage.IOnStorageChange wKf = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.view.d.a.AnonymousClass8 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(105286);
            Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "emoji storage notify %s", str);
            if (str == null) {
                AppMethodBeat.o(105286);
                return;
            }
            a.this.RpL.avu();
            AppMethodBeat.o(105286);
        }
    };
    public final IListener wKg = new IListener<rj>() {
        /* class com.tencent.mm.view.d.a.AnonymousClass9 */

        {
            AppMethodBeat.i(161805);
            this.__eventId = rj.class.getName().hashCode();
            AppMethodBeat.o(161805);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(rj rjVar) {
            AppMethodBeat.i(105287);
            Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "REFRESH_PANEL_EVENT");
            a.this.RpL.avu();
            AppMethodBeat.o(105287);
            return false;
        }
    };

    public a(Context context2) {
        AppMethodBeat.i(199833);
        this.context = context2;
        if (RpJ) {
            RpJ = false;
            for (EmojiInfo emojiInfo : com.tencent.mm.emoji.b.j.auL().dU(true)) {
                if (EmojiInfo.a.STATUS_MIXING == emojiInfo.hYs()) {
                    emojiInfo.a(EmojiInfo.a.STATUS_MIX_FAIL);
                    emojiInfo.a(EmojiInfo.b.ERR_MIX_PROCESS_KILL);
                    ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
                    EmojiCaptureReporter.g(emojiInfo.field_captureEnterTime, 5, emojiInfo.field_captureScene);
                } else if (emojiInfo.hYs() == EmojiInfo.a.STATUS_UPLOADING) {
                    emojiInfo.a(EmojiInfo.a.STATUS_UPLOAD_FAIL);
                    ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
                    EmojiCaptureReporter.f(emojiInfo.field_captureEnterTime, 3, emojiInfo.field_captureScene);
                }
            }
        }
        this.RpK = new i();
        this.RpK.gYl = true;
        this.RpK.gYj = true;
        this.RpI = new ad(this.RpK);
        this.RpD = new g(this.RpK, this.RpR, this.RpQ, this.RpP);
        this.vKp = new EmojiPanelLayoutManager(context2);
        this.RpA = com.tencent.mm.emoji.b.j.auL().gXo;
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager: select %s", this.RpA);
        this.RpL = new j(this.RpK, new y(this.RpD, this.RpI) {
            /* class com.tencent.mm.view.d.a.AnonymousClass1 */
            private boolean BiE = true;

            @Override // com.tencent.mm.emoji.b.b.g
            public final void a(v vVar) {
                int i2;
                AppMethodBeat.i(105280);
                a.this.RpM = vVar;
                if (a.this.RpM.avw().size() > 0) {
                    com.tencent.mm.emoji.b.b.ab<?> abVar = a.this.RpM.avw().get(0);
                    if (abVar instanceof ak) {
                        a.this.RpO = (ak) abVar;
                        com.tencent.mm.emoji.c.c.awc().gZj = a.this.RpO.gZk.gZj;
                    } else {
                        a.this.RpO = null;
                    }
                    if (a.this.RpM.avw().size() != 1 || a.this.RpO == null) {
                        a.this.RpH.setVisibility(0);
                    } else {
                        a.this.RpH.setVisibility(8);
                    }
                }
                ad adVar = a.this.RpI;
                List<ag> avx = a.this.RpM.avx();
                p.h(avx, "data");
                adVar.mData.clear();
                adVar.mData.addAll(avx);
                Log.i(ad.TAG, "update %s, %s", Integer.valueOf(adVar.mData.size()), Integer.valueOf(avx.size()));
                g gVar = a.this.RpD;
                List<EmojiGroupInfo> avv = a.this.RpM.avv();
                List<com.tencent.mm.emoji.b.b.ab<?>> avw = a.this.RpM.avw();
                p.h(avv, "groups");
                p.h(avw, "models");
                gVar.haH.clear();
                gVar.haH.addAll(avv);
                gVar.haI.clear();
                gVar.haI.addAll(avw);
                if (this.BiE) {
                    String str = a.this.RpA;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= a.this.RpM.avv().size()) {
                            i2 = 0;
                            break;
                        } else if (Util.isEqual(a.this.RpM.avv().get(i3).field_productID, str)) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    RecyclerView recyclerView = a.this.RpC;
                    com.tencent.mm.hellhoundlib.b.a a2 = c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
                    recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
                    a.this.setTabSelected(i2);
                    if (i2 < a.this.RpM.avw().size()) {
                        a.this.RpM.avw().get(i2).avu();
                        this.BiE = false;
                    }
                }
                AppMethodBeat.o(105280);
            }
        });
        AppMethodBeat.o(199833);
    }

    public final void onDestroy() {
        AppMethodBeat.i(105292);
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onDestroy %s", this);
        removeListener();
        this.RpR.clear();
        AppMethodBeat.o(105292);
    }

    public final void removeListener() {
        AppMethodBeat.i(105293);
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager remove listener. %s", this);
        ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().j(this.wKe);
        ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().h(this.wKf);
        EventCenter.instance.removeListener(this.wKg);
        EventCenter.instance.removeListener(this.RpT);
        this.RpB = false;
        AppMethodBeat.o(105293);
    }

    public final void setShowStore(boolean z) {
        AppMethodBeat.i(199834);
        boolean z2 = z != this.RpK.gYm;
        this.RpK.gYm = z;
        if (z2) {
            this.RpL.avu();
        }
        AppMethodBeat.o(199834);
    }

    public final void setShowSend(boolean z) {
        AppMethodBeat.i(169245);
        this.RpK.eb(z);
        AppMethodBeat.o(169245);
    }

    public final void apY(int i2) {
        AppMethodBeat.i(105294);
        setTabSelected(i2);
        RecyclerView recyclerView = this.RpC;
        com.tencent.mm.hellhoundlib.b.a a2 = c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(105294);
    }

    public final void setTabSelected(int i2) {
        int i3;
        int i4 = 2;
        AppMethodBeat.i(105295);
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setTabSelected: %s, %s", Integer.valueOf(i2), this.RpA);
        if (this.RpM == null) {
            AppMethodBeat.o(105295);
            return;
        }
        if (i2 >= 0 && i2 < this.RpM.avv().size()) {
            final int pi = this.RpM.pi(i2);
            if (!(this.RpH == null || this.RpI == null)) {
                this.RpI.setSelection(pi);
                this.RpH.post(new Runnable() {
                    /* class com.tencent.mm.view.d.a.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(105283);
                        RecyclerView recyclerView = a.this.RpH;
                        com.tencent.mm.hellhoundlib.b.a a2 = c.a(pi, new com.tencent.mm.hellhoundlib.b.a());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                        recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                        AppMethodBeat.o(105283);
                    }
                });
            }
            String str = this.RpM.avv().get(i2).field_productID;
            this.RpA = str;
            w avp = this.RpM.avw().get(i2).avp();
            if (avp instanceof al) {
                com.tencent.mm.emoji.c.d dVar = com.tencent.mm.emoji.c.d.hcj;
                com.tencent.mm.emoji.c.d.awd().it(str);
                com.tencent.mm.emoji.c.d dVar2 = com.tencent.mm.emoji.c.d.hcj;
                aq awd = com.tencent.mm.emoji.c.d.awd();
                if (((al) avp).gYN) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                awd.eqf = i3;
                com.tencent.mm.emoji.c.d dVar3 = com.tencent.mm.emoji.c.d.hcj;
                com.tencent.mm.emoji.c.d.awd().eqh = i2 + 1;
                com.tencent.mm.emoji.c.d dVar4 = com.tencent.mm.emoji.c.d.hcj;
                com.tencent.mm.emoji.c.d.pl(1);
            } else {
                com.tencent.mm.emoji.c.d dVar5 = com.tencent.mm.emoji.c.d.hcj;
                com.tencent.mm.emoji.c.d.awd().it("");
                com.tencent.mm.emoji.c.d dVar6 = com.tencent.mm.emoji.c.d.hcj;
                com.tencent.mm.emoji.c.d.awd().eqh = 0;
            }
            com.tencent.mm.emoji.c.h.awf().hcq = i2;
            com.tencent.mm.emoji.c.h awf = com.tencent.mm.emoji.c.h.awf();
            if (Util.isEqual(str, com.tencent.mm.emoji.b.b.ad.avC())) {
                i4 = 1;
            } else if (!Util.isEqual(str, com.tencent.mm.emoji.b.b.ad.avD())) {
                i4 = 3;
            }
            awf.hcp = i4;
            com.tencent.mm.emoji.c.h.awf().hcr = this.RpM.avw().get(i2).avp().avo();
            this.RpN = Util.isEqual(str, com.tencent.mm.emoji.b.b.ad.avB());
            if (this.har != null) {
                this.har.eP(this.RpN);
            }
            if (!this.RpN && this.RpO != null) {
                this.RpO.avu();
            }
            if (this.isResume && Util.isEqual(str, com.tencent.mm.emoji.b.b.ad.avD()) && this.RpK.gYl) {
                h.INSTANCE.a(15982, 0);
            }
        }
        AppMethodBeat.o(105295);
    }

    public final void blU(String str) {
        AppMethodBeat.i(105296);
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setCurrentTab: %s", str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(105296);
            return;
        }
        this.RpA = str;
        if (this.RpM == null) {
            AppMethodBeat.o(105296);
            return;
        }
        for (int i2 = 0; i2 < this.RpM.avv().size(); i2++) {
            if (Util.isEqual(this.RpM.avv().get(i2).field_productID, str)) {
                apY(i2);
                AppMethodBeat.o(105296);
                return;
            }
        }
        AppMethodBeat.o(105296);
    }

    static /* synthetic */ void kN(Context context2) {
        AppMethodBeat.i(105297);
        com.tencent.mm.br.c.b(context2, "emoji", ".ui.EmojiMineUI", new Intent());
        AppMethodBeat.o(105297);
    }

    static /* synthetic */ void a(a aVar, Context context2) {
        AppMethodBeat.i(105298);
        aVar.RpS = null;
        aVar.RpS = new b(((u) context2).getBaseContext(), aVar.rgD, aVar.rgH, aVar.rgI);
        Window window = aVar.RpS.getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        aVar.RpS.show();
        AppMethodBeat.o(105298);
    }

    static /* synthetic */ void b(a aVar, Context context2) {
        AppMethodBeat.i(199835);
        Intent intent = new Intent();
        intent.putExtra("preceding_scence", 13);
        intent.putExtra("download_entrance_scene", 17);
        intent.putExtra("check_clickflag", false);
        if (!Util.isNullOrNil(aVar.rgD)) {
            intent.putExtra("to_talker_name", aVar.rgD);
        }
        com.tencent.mm.br.c.b(context2, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
        h.INSTANCE.a(11594, 2);
        h.INSTANCE.a(12065, 8);
        AppMethodBeat.o(199835);
    }
}
