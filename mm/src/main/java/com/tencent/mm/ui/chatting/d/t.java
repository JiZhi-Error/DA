package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.MenuItem;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.api.ad;
import com.tencent.mm.ba.f;
import com.tencent.mm.emoji.e.c;
import com.tencent.mm.g.a.u;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.d.b;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.q;
import com.tencent.mm.ui.chatting.viewitems.l;
import com.tencent.mm.ui.chatting.w;
import java.io.IOException;
import java.util.LinkedList;
import kotlin.x;

@a(gRF = q.class)
public class t extends a implements q {
    private b NJK;
    private IListener Ppc = new IListener<u>() {
        /* class com.tencent.mm.ui.chatting.d.t.AnonymousClass1 */

        {
            AppMethodBeat.i(161527);
            this.__eventId = u.class.getName().hashCode();
            AppMethodBeat.o(161527);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(u uVar) {
            AppMethodBeat.i(35284);
            final u uVar2 = uVar;
            if (t.this.dom != null) {
                if (uVar2.dCJ.status == 1) {
                    com.tencent.mm.ui.chatting.e.a.gRP().post(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.d.t.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(35282);
                            t.this.dom.cmy();
                            AppMethodBeat.o(35282);
                        }
                    });
                } else {
                    com.tencent.mm.ui.chatting.e.a.gRP().post(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.d.t.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(35283);
                            l.b.u(uVar2.dCJ.dCK, uVar2.dCJ.percentage, uVar2.dCJ.status);
                            AppMethodBeat.o(35283);
                        }
                    });
                }
            }
            AppMethodBeat.o(35284);
            return false;
        }
    };

    public t() {
        AppMethodBeat.i(35286);
        AppMethodBeat.o(35286);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.q
    public final boolean a(MenuItem menuItem, final com.tencent.mm.ui.chatting.e.a aVar, final ca caVar) {
        EmojiInfo aml;
        String str;
        k.b aD;
        EmojiInfo cc;
        String str2;
        AppMethodBeat.i(35287);
        switch (menuItem.getItemId()) {
            case 103:
                boolean ca = ca(caVar);
                AppMethodBeat.o(35287);
                return ca;
            case 104:
                if ((caVar.gDn() || caVar.gDo()) && (cc = cc(caVar)) != null) {
                    String str3 = caVar.field_talker;
                    if (ab.Eq(str3)) {
                        str2 = bp.Ks(caVar.field_content);
                    } else {
                        str2 = str3;
                    }
                    h.INSTANCE.a(12789, 3, cc.getMd5(), 0, cc.field_designerID, cc.field_groupId, "", "", "", "", "", cc.field_activityid);
                    ((d) g.ah(d.class)).getEmojiMgr().a(aVar.Pwc.getContext(), cc, 0, str2);
                }
                AppMethodBeat.o(35287);
                return true;
            case 113:
                if (caVar.gDn() || caVar.gDo()) {
                    EmojiInfo emojiInfo = null;
                    if (caVar.gDn()) {
                        emojiInfo = ((d) g.ah(d.class)).getEmojiMgr().aml(caVar.field_imgPath);
                    } else {
                        String str4 = caVar.field_content;
                        if (!(str4 == null || (aD = k.b.aD(str4, caVar.field_reserved)) == null)) {
                            emojiInfo = ((d) g.ah(d.class)).getEmojiMgr().aml(aD.iwK);
                        }
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(emojiInfo != null);
                        Log.i("MicroMsg.ChattingUI.EmojiComponent", "longCLickRetransmitEmoji: emoji from xml %s", objArr);
                        if (emojiInfo == null) {
                            be bkr = be.bkr(caVar.field_content);
                            if (!Util.isNullOrNil(bkr.md5) && !bkr.md5.equals("-1")) {
                                emojiInfo = ((d) g.ah(d.class)).getEmojiMgr().aml(bkr.md5);
                            }
                            Object[] objArr2 = new Object[1];
                            objArr2[0] = Boolean.valueOf(emojiInfo != null);
                            Log.i("MicroMsg.ChattingUI.EmojiComponent", "longCLickRetransmitEmoji: emoji from content %s", objArr2);
                        }
                    }
                    AnonymousClass2 r1 = new c.a() {
                        /* class com.tencent.mm.ui.chatting.d.t.AnonymousClass2 */

                        @Override // com.tencent.mm.emoji.e.c.a
                        public final void dQ(boolean z) {
                            AppMethodBeat.i(233098);
                            if (z) {
                                LinkedList linkedList = new LinkedList();
                                linkedList.add(caVar);
                                com.tencent.mm.ui.chatting.l.a(aVar.Pwc.getContext(), linkedList, ((com.tencent.mm.ui.chatting.d.b.d) aVar.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ() || aVar.gRL(), aVar.getTalkerUserName(), null);
                            }
                            AppMethodBeat.o(233098);
                        }
                    };
                    if (emojiInfo != null) {
                        new c(aVar.Pwc.getContext(), emojiInfo, true, r1);
                        String talkerUserName = aVar.getTalkerUserName();
                        if (ab.Eq(talkerUserName)) {
                            talkerUserName = bp.Ks(caVar.field_content);
                        }
                        h.INSTANCE.a(12789, 1, emojiInfo.getMd5(), 0, emojiInfo.field_designerID, emojiInfo.field_groupId, talkerUserName, "", "", "", emojiInfo.field_activityid);
                    } else if (caVar.gDo()) {
                        r1.dQ(true);
                    }
                }
                AppMethodBeat.o(35287);
                return true;
            case 114:
                if (caVar.gDn() || caVar.gDo()) {
                    an.d(caVar, aVar.Pwc.getContext());
                    AppMethodBeat.o(35287);
                    return true;
                }
                AppMethodBeat.o(35287);
                return false;
            case 115:
                a(caVar, aVar);
                AppMethodBeat.o(35287);
                return true;
            case 128:
                if (caVar.gDn()) {
                    aml = ((d) g.ah(d.class)).getEmojiMgr().aml(caVar.field_imgPath);
                } else {
                    be bkr2 = be.bkr(caVar.field_content);
                    if (!Util.isNullOrNil(bkr2.md5) && !bkr2.md5.equals("-1")) {
                        aml = ((d) g.ah(d.class)).getEmojiMgr().aml(bkr2.md5);
                    }
                    AppMethodBeat.o(35287);
                    return true;
                }
                if (aml != null) {
                    h.INSTANCE.a(12789, 2, aml.getMd5(), 0, aml.field_designerID, aml.field_groupId, "", "", "", "", "", aml.field_activityid);
                }
                if (aml == null) {
                    str = "";
                } else {
                    str = aml.field_groupId;
                }
                if (!Util.isNullOrNil(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("preceding_scence", 3);
                    intent.putExtra("download_entrance_scene", 16);
                    intent.putExtra("extra_id", str);
                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
                }
                AppMethodBeat.o(35287);
                return true;
            case com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX:
                EmojiInfo cc2 = cc(caVar);
                if (cc2 != null) {
                    h.INSTANCE.a(12789, 5, cc2.getMd5(), 0, cc2.field_designerID, cc2.field_groupId, "", "", "", "", "", cc2.field_activityid);
                    com.tencent.mm.plugin.emojicapture.api.b.w(aVar.Pwc.getContext(), cc2.getMd5(), aVar.getTalkerUserName());
                }
                AppMethodBeat.o(35287);
                return true;
            default:
                AppMethodBeat.o(35287);
                return false;
        }
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35288);
        Log.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingEnterAnimEnd]");
        EventCenter.instance.addListener(this.Ppc);
        AppMethodBeat.o(35288);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35289);
        Log.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingExitAnimStart]");
        EventCenter.instance.removeListener(this.Ppc);
        AppMethodBeat.o(35289);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35290);
        super.gOK();
        Log.i("MicroMsg.ChattingUI.EmojiComponent", "[onComponentUnInstall]");
        EventCenter.instance.removeListener(this.Ppc);
        AppMethodBeat.o(35290);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.q
    public final boolean ca(ca caVar) {
        AppMethodBeat.i(35291);
        Log.i("MicroMsg.ChattingUI.EmojiComponent", "[resendEmoji] %d", Long.valueOf(caVar.field_msgId));
        if (caVar.gDn()) {
            cb(caVar);
            AppMethodBeat.o(35291);
            return true;
        } else if (caVar.gDo()) {
            bJ(caVar);
            AppMethodBeat.o(35291);
            return true;
        } else {
            AppMethodBeat.o(35291);
            return false;
        }
    }

    private void cb(ca caVar) {
        AppMethodBeat.i(35292);
        bg.aVF();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            com.tencent.mm.ui.base.u.g(this.dom.Pwc.getContext(), this.dom.Pwc.getContentView());
            AppMethodBeat.o(35292);
            return;
        }
        Log.d("MicroMsg.ChattingUI.EmojiComponent", "resendEmoji");
        if (!this.dom.getTalkerUserName().equals("medianote")) {
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new f(caVar.field_talker, caVar.field_msgSvrId));
        }
        ak.bI(caVar);
        AppMethodBeat.o(35292);
    }

    private void bJ(ca caVar) {
        AppMethodBeat.i(35293);
        Log.d("MicroMsg.ChattingUI.EmojiComponent", "resendAppMsgEmoji");
        if (!this.dom.getTalkerUserName().equals("medianote")) {
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new f(caVar.field_talker, caVar.field_msgSvrId));
        }
        ak.bJ(caVar);
        this.dom.BN(true);
        AppMethodBeat.o(35293);
    }

    private void a(ca caVar, com.tencent.mm.ui.chatting.e.a aVar) {
        final boolean z;
        EmojiInfo cc;
        AppMethodBeat.i(35294);
        if (caVar.gDn() || caVar.gDo()) {
            EmojiInfo cc2 = cc(caVar);
            if (cc2 == null) {
                AppMethodBeat.o(35294);
                return;
            }
            com.tencent.mm.search.c.b bVar = com.tencent.mm.search.c.b.NJx;
            com.tencent.mm.search.c.b.E(cc2);
            final ChatFooter gPO = ((com.tencent.mm.ui.chatting.d.b.u) aVar.bh(com.tencent.mm.ui.chatting.d.b.u.class)).gPO();
            final int currentScrollHeight = gPO.getCurrentScrollHeight();
            gPO.aiA(ad.bD(aVar.Pwc.getContext()));
            com.tencent.mm.ui.chatting.d.b.k kVar = (com.tencent.mm.ui.chatting.d.b.k) aVar.bh(com.tencent.mm.ui.chatting.d.b.k.class);
            int count = kVar.getCount() - 1;
            cyv cyv = new cyv();
            while (count >= 0 && cyv.MDT.size() <= 20) {
                cyu cyu = new cyu();
                ca amt = kVar.amt(count);
                cyu.MDN = amt.getType();
                cyu.MDO = com.tencent.mm.ag.l.t(amt);
                cyu.MDP = com.tencent.mm.ag.l.u(amt);
                cyu.MDQ = amt.field_createTime;
                cyu.MDR = amt.field_isSend;
                if (amt.gDn() && (cc = cc(amt)) != null) {
                    cyu.xNU = cc.field_md5;
                    if (cc.field_md5.equals(cc2.field_md5)) {
                        cyu.MDS = 1;
                        cyu.Lso = cc.field_lensId;
                    }
                }
                count--;
                cyv.MDT.add(cyu);
            }
            Log.i("MicroMsg.ChattingUI.EmojiComponent", " add ctxs size:%d", Integer.valueOf(cyv.MDT.size()));
            w wVar = new w(aVar, aVar.GUe, aVar.getTalkerUserName());
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_enable_sos_emoji, true);
            try {
                String str = cc2.field_md5;
                String talkerUserName = aVar.getTalkerUserName();
                com.tencent.mm.search.c.b bVar2 = com.tencent.mm.search.c.b.NJx;
                SimilarEmojiQueryModel similarEmojiQueryModel = new SimilarEmojiQueryModel("", str, talkerUserName, com.tencent.mm.search.c.b.getTimestamp(), 3, aVar.getTalkerUserName(), com.tencent.mm.bw.b.cD(cyv.toByteArray()), a2, wVar);
                if (gPO.KiY == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    gPO.setIgnoreScroll(Boolean.TRUE);
                    gPO.hideVKB();
                }
                this.NJK = null;
                this.NJK = new com.tencent.mm.search.d.b(aVar.Pwc.getContext(), similarEmojiQueryModel, new kotlin.g.a.a<x>() {
                    /* class com.tencent.mm.ui.chatting.d.t.AnonymousClass3 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(233099);
                        if (z) {
                            gPO.setKeyboardShow(Boolean.FALSE);
                            gPO.setIgnoreScroll(Boolean.FALSE);
                            gPO.showVKB();
                        } else {
                            gPO.aiA(currentScrollHeight);
                        }
                        AppMethodBeat.o(233099);
                        return null;
                    }
                });
                Window window = this.NJK.getWindow();
                if (window != null) {
                    window.setDimAmount(0.0f);
                    window.setFlags(131072, 131072);
                    window.setSoftInputMode(48);
                }
                this.NJK.show();
                AppMethodBeat.o(35294);
            } catch (IOException e2) {
                Log.i("MicroMsg.ChattingUI.EmojiComponent", "SimilarEmojiQueryModel make error");
                AppMethodBeat.o(35294);
            }
        } else {
            AppMethodBeat.o(35294);
        }
    }

    private static EmojiInfo cc(ca caVar) {
        k.b bVar;
        EmojiInfo aml;
        AppMethodBeat.i(35295);
        if (caVar.gDn()) {
            aml = ((d) g.ah(d.class)).getEmojiMgr().aml(caVar.field_imgPath);
        } else {
            be bkr = be.bkr(caVar.field_content);
            k.b aD = k.b.aD(caVar.field_content, caVar.field_reserved);
            if (aD == null) {
                k.b bVar2 = new k.b();
                bVar2.iwK = bkr.md5;
                bVar = bVar2;
            } else {
                bVar = aD;
            }
            if (Util.isNullOrNil(bVar.iwK) || bVar.iwK.equals("-1")) {
                AppMethodBeat.o(35295);
                return null;
            }
            aml = ((d) g.ah(d.class)).getEmojiMgr().aml(bVar.iwK);
        }
        AppMethodBeat.o(35295);
        return aml;
    }

    @Override // com.tencent.mm.ui.l
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(35296);
        super.onConfigurationChanged(configuration);
        if (this.NJK != null && this.NJK.isShowing()) {
            this.NJK.dismiss();
            this.NJK = null;
        }
        AppMethodBeat.o(35296);
    }
}
