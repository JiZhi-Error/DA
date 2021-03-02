package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.byp.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.k;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ah;
import com.tencent.mm.plugin.i.a.an;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.plugin.i.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.blur.f;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.h;
import com.tencent.mm.ui.chatting.d.b.u;
import java.util.Collections;
import java.util.List;
import kotlin.g.b.p;

@a(gRF = h.class)
class i extends a implements h {
    private f EBK = null;
    private MStorage.IOnStorageChange PnQ = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.ui.chatting.d.i.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(233052);
            if (mStorageEventData.event.equals(i.this.dom.GUe.field_username)) {
                i.a(i.this);
            }
            AppMethodBeat.o(233052);
        }
    };
    private final MStorage.IOnStorageChange PnR = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.ui.chatting.d.i.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(233053);
            if (mStorageEventData.event.equals("FinderContact")) {
                Log.i("MicroMsg.ChattingBypComponent", "onNotifyChange ".concat(String.valueOf(str)));
                bg.aVF();
                as Kn = c.aSN().Kn(i.this.dom.getTalkerUserName());
                if (!(Kn == null || ((int) Kn.gMZ) == 0)) {
                    if (Util.isNullOrNil(Kn.field_nickname)) {
                        Kn.setNickname(i.this.dom.GUe.field_nickname);
                    }
                    i.this.dom.aw(Kn);
                    ((aa) i.this.dom.bh(aa.class)).gPx();
                    ((aa) i.this.dom.bh(aa.class)).BR(true);
                    i.this.dom.cmy();
                    i.this.gPx();
                    i.a(i.this);
                }
            }
            AppMethodBeat.o(233053);
        }
    };

    i() {
        AppMethodBeat.i(233055);
        AppMethodBeat.o(233055);
    }

    static /* synthetic */ void a(i iVar) {
        AppMethodBeat.i(233063);
        iVar.gPv();
        AppMethodBeat.o(233063);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.h
    public final boolean gPu() {
        AppMethodBeat.i(233056);
        boolean avl = as.avl(this.dom.getTalkerUserName());
        AppMethodBeat.o(233056);
        return avl;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.h
    public final boolean bjt(String str) {
        AppMethodBeat.i(233057);
        boolean bjt = as.bjt(str);
        AppMethodBeat.o(233057);
        return bjt;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.h
    public final boolean bmH(String str) {
        AppMethodBeat.i(233058);
        boolean bjs = as.bjs(str);
        AppMethodBeat.o(233058);
        return bjs;
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        long j2;
        AppMethodBeat.i(233059);
        super.gIm();
        if (!gPu()) {
            AppMethodBeat.o(233059);
            return;
        }
        gPv();
        ((n) g.af(n.class)).ave(this.dom.getTalkerUserName());
        if (!Util.isNullOrNil(this.dom.getTalkerUserName())) {
            com.tencent.f.h.RTc.aY(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.i.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(233054);
                    List<ca> fw = ((l) g.af(l.class)).eiy().fw(Collections.singletonList("findermessage006"));
                    for (ca caVar : fw) {
                        a.C0899a aVar = com.tencent.mm.plugin.byp.b.a.pPx;
                        if (!com.tencent.mm.plugin.byp.b.a.pPw.contains(Long.valueOf(caVar.field_msgId))) {
                            caVar.setStatus(5);
                            ((l) g.af(l.class)).eiy().a(caVar.field_msgId, caVar);
                        }
                    }
                    Log.i("MicroMsg.ChattingBypComponent", "sending msg size=%s talker=%s username=%s", Integer.valueOf(fw.size()), i.this.dom.gOZ(), i.this.dom.getTalkerUserName());
                    AppMethodBeat.o(233054);
                }
            });
        }
        String avi = ((com.tencent.mm.plugin.i.a.aa) g.af(com.tencent.mm.plugin.i.a.aa.class)).avi(this.dom.getTalkerUserName());
        ((an) g.af(an.class)).bxX(this.dom.getTalkerUserName());
        d dVar = d.vdp;
        d.C1267d dnJ = d.dnJ();
        if (as.bjt(avi)) {
            j2 = 2;
        } else {
            j2 = 1;
        }
        String talkerUserName = this.dom.getTalkerUserName();
        p.h(avi, "talkUserName");
        p.h(talkerUserName, "chatName");
        dnJ.vdx = j2;
        dnJ.vdz = avi;
        dnJ.vdD = talkerUserName;
        dnJ.sTp = cl.aWA();
        dnJ.vdB = String.valueOf(dnJ.sTp);
        d dVar2 = d.vdp;
        if (d.dnG().viM) {
            d dVar3 = d.vdp;
            dnJ.vdA = d.dnG().viN.vdr;
        } else {
            d dVar4 = d.vdp;
            if (d.dnF().viM) {
                d dVar5 = d.vdp;
                dnJ.vdA = d.dnF().viN.vdr;
            }
        }
        Log.i(dnJ.TAG, "onEnterChat:talkUserNameL" + dnJ.vdz + ", chatNameL" + dnJ.vdD + "， accountTypeL" + dnJ.vdx);
        AppMethodBeat.o(233059);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(233060);
        super.gIl();
        if (!gPu()) {
            AppMethodBeat.o(233060);
            return;
        }
        ((PluginFinder) g.ah(PluginFinder.class)).getSessionInfoStorage().add(this.PnQ);
        ((m) g.af(m.class)).m(this.PnR);
        gPx();
        AppMethodBeat.o(233060);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.h
    public final void gPx() {
        AppMethodBeat.i(258935);
        ah ava = ((m) g.af(m.class)).ava(((com.tencent.mm.plugin.i.a.aa) g.af(com.tencent.mm.plugin.i.a.aa.class)).avi(this.dom.getTalkerUserName()));
        if (ava == null) {
            ((aa) this.dom.bh(aa.class)).setMMTitle("");
            AppMethodBeat.o(258935);
            return;
        }
        long hSF = ava.hSF();
        if (hSF > 0) {
            String string = this.dom.Pwc.getContext().getResources().getString(R.string.jcz, Long.valueOf(hSF));
            if (!com.tencent.mm.plugin.freewifi.m.eP(string)) {
                ((aa) this.dom.bh(aa.class)).setMMSubTitle(string);
            }
        }
        ((aa) this.dom.bh(aa.class)).setMMTitle(ava.arJ());
        AppMethodBeat.o(258935);
    }

    private void gPv() {
        AppMethodBeat.i(233061);
        k avz = ((PluginFinder) g.ah(PluginFinder.class)).getSessionInfoStorage().avz(this.dom.GUe.field_username);
        ChatFooter gPO = ((u) this.dom.bh(u.class)).gPO();
        if (gPO != null && as.avl(this.dom.GUe.field_username)) {
            gPO.setFooterStatus(avz.field_disableSendMsg != 1);
            String gRI = this.dom.gRI();
            as bjJ = ((l) g.af(l.class)).aSN().bjJ(gRI);
            Boolean valueOf = Boolean.valueOf(as.bjt(this.dom.gRI()));
            if (valueOf.booleanValue()) {
                gPO.a(this.dom.gRI(), valueOf, this.dom.Pwc.getContext().getString(R.string.d6c, new Object[]{bjJ.arI()}));
                AppMethodBeat.o(233061);
                return;
            } else if (((m) g.af(m.class)).ava(gRI) == null) {
                gPO.a(this.dom.gRI(), valueOf, this.dom.Pwc.getContext().getString(R.string.d6c, new Object[]{bjJ.arI()}));
                AppMethodBeat.o(233061);
                return;
            } else {
                gPO.a(this.dom.gRI(), Boolean.valueOf(as.bjt(gRI)), this.dom.Pwc.getContext().getString(R.string.d6c, new Object[]{bjJ.arI()}));
            }
        }
        AppMethodBeat.o(233061);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIo() {
        int i2;
        String str;
        String str2;
        AppMethodBeat.i(233062);
        super.gIo();
        if (!gPu()) {
            AppMethodBeat.o(233062);
            return;
        }
        ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage().avs(this.dom.getTalkerUserName());
        ((PluginFinder) g.ah(PluginFinder.class)).getSessionInfoStorage().remove(this.PnQ);
        ((m) g.af(m.class)).l(this.PnR);
        if (as.bjt(((PluginFinder) g.ah(PluginFinder.class)).getSessionInfoStorage().avz(this.dom.GUe.field_username).field_talker)) {
            ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager().tJB.dat();
        } else {
            ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager().tJB.das();
        }
        if (this.EBK != null) {
            this.EBK.destroy();
        }
        String talkerUserName = this.dom.getTalkerUserName();
        String cMD = ((com.tencent.mm.plugin.expt.b.c) g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
        if (this.dom == null || this.dom.Pwc.getContext() == null) {
            i2 = 0;
        } else {
            i2 = this.dom.Pwc.getContext().getIntent().getIntExtra("key_comment_scene", 0);
        }
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        String MG = FinderReporterUIC.a.MG(i2 + 100);
        d dVar = d.vdp;
        d.C1267d dnJ = d.dnJ();
        if (talkerUserName == null) {
            talkerUserName = "";
        }
        p.h(talkerUserName, "talker");
        com.tencent.mm.g.b.a.bg bgVar = new com.tencent.mm.g.b.a.bg();
        bgVar.esa = (long) i2;
        if (cMD == null) {
            str = "";
        } else {
            str = cMD;
        }
        bgVar.els = bgVar.x("sessionid", str, true);
        if (MG == null) {
            str2 = "";
        } else {
            str2 = MG;
        }
        bgVar.esd = bgVar.x("clicktabcontextid", str2, true);
        bgVar.esb = dnJ.vdx;
        bgVar.esc = bgVar.x("talkerUsername", dnJ.vdz, true);
        bgVar.esf = bgVar.x("chatSessionid", dnJ.vdB, true);
        bgVar.ese = bgVar.x("chatListSessionid", dnJ.vdA, true);
        bgVar.esg = cl.aWA() - dnJ.sTp;
        bgVar.esh = bgVar.x("chatName", dnJ.vdD, true);
        bgVar.esi = dnJ.vdE;
        bgVar.esl = dnJ.vdH;
        long j2 = dnJ.sTp;
        p.h(talkerUserName, "talker");
        p.h(bgVar, "chatEnterStruct");
        dnJ.vdy.post(new d.C1267d.a(dnJ, talkerUserName, j2, bgVar));
        dnJ.vdx = 0;
        dnJ.vdz = "";
        dnJ.vdA = "";
        dnJ.vdB = "";
        dnJ.vdC = 0;
        dnJ.vdD = "";
        dnJ.vdE = 0;
        dnJ.vdF = 0;
        dnJ.vdG = 0;
        dnJ.vdH = 0;
        dnJ.sTp = 0;
        AppMethodBeat.o(233062);
    }
}
