package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ad;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.vfs.s;
import java.io.InputStream;

public final class w implements j {
    private a OIz;
    private String PgT;
    private boolean Pjh = true;
    private boolean Pji = true;
    private int Pjj;
    private as contact;

    public w(a aVar, as asVar, String str) {
        String str2;
        AppMethodBeat.i(34684);
        this.OIz = aVar;
        this.contact = asVar;
        this.PgT = str;
        if (as.IG(this.PgT)) {
            this.Pji = false;
        }
        if (as.bjo(this.PgT)) {
            this.Pjh = false;
        }
        if (as.bjm(this.PgT)) {
            this.Pjh = false;
        }
        if (this.contact == null || !as.IG(this.contact.field_username)) {
            str2 = this.contact == null ? null : this.contact.field_username;
        } else {
            str2 = this.PgT;
        }
        if (ab.II(str2)) {
            this.Pji = false;
        }
        AppMethodBeat.o(34684);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.j
    public final void B(EmojiInfo emojiInfo) {
        boolean z;
        String str;
        AppMethodBeat.i(34685);
        bg.aVF();
        if (!c.isSDCardAvailable()) {
            u.g(this.OIz.Pwc.getContext(), this.OIz.Pwc.getContentView());
            AppMethodBeat.o(34685);
        } else if (emojiInfo == null) {
            AppMethodBeat.o(34685);
        } else {
            if (!this.contact.field_username.equals("medianote") || (z.aUc() & 16384) != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                emojiInfo.field_start = 0;
                emojiInfo.field_state = EmojiInfo.Vle;
                ((d) g.ah(d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
                ca caVar = new ca();
                caVar.setType(47);
                caVar.Cy("medianote");
                caVar.nv(1);
                if (emojiInfo.NA()) {
                    caVar.setContent(be.a(z.aTY(), 0, false, emojiInfo.getMd5(), false, ""));
                }
                caVar.Cz(emojiInfo.getMd5());
                caVar.setCreateTime(bp.Kw(caVar.field_talker));
                caVar.setStatus(2);
                bg.aVF();
                c.aSQ().aC(caVar);
                AppMethodBeat.o(34685);
                return;
            }
            com.tencent.mm.pluginsdk.a.d emojiMgr = ((d) g.ah(d.class)).getEmojiMgr();
            if (Util.isNullOrNil(this.PgT)) {
                str = this.contact.field_username;
            } else {
                str = this.PgT;
            }
            emojiMgr.a(str, emojiInfo, (ca) null);
            this.OIz.BN(true);
            AppMethodBeat.o(34685);
        }
    }

    public final void N(EmojiInfo emojiInfo) {
        InputStream inputStream;
        Throwable th;
        Exception e2;
        AppMethodBeat.i(34686);
        bg.aVF();
        if (!c.isSDCardAvailable()) {
            u.g(this.OIz.Pwc.getContext(), this.OIz.Pwc.getContentView());
            AppMethodBeat.o(34686);
        } else if (emojiInfo == null) {
            AppMethodBeat.o(34686);
        } else {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            StringBuilder sb = new StringBuilder();
            bg.aVF();
            String sb2 = sb.append(c.aTd()).append(emojiInfo.getMd5()).toString();
            if (s.YS(sb2 + "_thumb")) {
                wXMediaMessage.thumbData = s.aW(sb2 + "_thumb", 0, (int) s.boW(sb2 + "_thumb"));
            } else {
                try {
                    inputStream = s.openRead(sb2);
                    try {
                        wXMediaMessage.setThumbImage(BackwardSupportUtil.BitmapFactory.decodeStream(inputStream, 1.0f));
                        Util.qualityClose(inputStream);
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            Log.printErrStackTrace("MicroMsg.ChattingSmileyPanelImpl", e2, "", new Object[0]);
                            Log.e("MicroMsg.ChattingSmileyPanelImpl", "sendAppMsgEmoji Fail cause there is no thumb");
                            Util.qualityClose(inputStream);
                            wXMediaMessage.mediaObject = new WXEmojiObject(sb2);
                            m.a(wXMediaMessage, emojiInfo.field_app_id, (String) null, this.PgT, 1, emojiInfo.getMd5());
                            AppMethodBeat.o(34686);
                        } catch (Throwable th2) {
                            th = th2;
                            Util.qualityClose(inputStream);
                            AppMethodBeat.o(34686);
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    inputStream = null;
                    Log.printErrStackTrace("MicroMsg.ChattingSmileyPanelImpl", e2, "", new Object[0]);
                    Log.e("MicroMsg.ChattingSmileyPanelImpl", "sendAppMsgEmoji Fail cause there is no thumb");
                    Util.qualityClose(inputStream);
                    wXMediaMessage.mediaObject = new WXEmojiObject(sb2);
                    m.a(wXMediaMessage, emojiInfo.field_app_id, (String) null, this.PgT, 1, emojiInfo.getMd5());
                    AppMethodBeat.o(34686);
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    Util.qualityClose(inputStream);
                    AppMethodBeat.o(34686);
                    throw th;
                }
            }
            wXMediaMessage.mediaObject = new WXEmojiObject(sb2);
            m.a(wXMediaMessage, emojiInfo.field_app_id, (String) null, this.PgT, 1, emojiInfo.getMd5());
            AppMethodBeat.o(34686);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.j
    public final void ein() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.j
    public final void N(boolean z, int i2) {
        AppMethodBeat.i(232881);
        ChatFooter gPO = ((com.tencent.mm.ui.chatting.d.b.u) this.OIz.bh(com.tencent.mm.ui.chatting.d.b.u.class)).gPO();
        if (z) {
            this.Pjj = gPO.getCurrentScrollHeight();
            gPO.aiA(ad.bD(this.OIz.Pwc.getContext()) + i2);
            gPO.Kjf = false;
            gPO.setIgnoreScroll(Boolean.TRUE);
            AppMethodBeat.o(232881);
            return;
        }
        if (this.Pjj > 0) {
            gPO.aiA(this.Pjj);
        } else {
            gPO.aiA(ad.bD(this.OIz.Pwc.getContext()) + i2);
        }
        gPO.Kjf = true;
        gPO.setIgnoreScroll(Boolean.FALSE);
        AppMethodBeat.o(232881);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.j
    public final void eio() {
        AppMethodBeat.i(232882);
        ((com.tencent.mm.ui.chatting.d.b.u) this.OIz.bh(com.tencent.mm.ui.chatting.d.b.u.class)).gPO().gqi();
        AppMethodBeat.o(232882);
    }
}
