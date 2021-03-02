package com.tencent.mm.plugin.emoji.model;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.d.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;
import java.util.List;

public final class c implements i {
    private boolean raZ = false;
    List<a> rba = new LinkedList();
    List<String> rbb = new LinkedList();
    private q rbc;

    public c() {
        AppMethodBeat.i(240141);
        g.aAg().hqi.a(3862, this);
        g.aAg().hqi.a(697, this);
        AppMethodBeat.o(240141);
    }

    /* access modifiers changed from: package-private */
    public class a {
        EmojiInfo dEz;
        String dJX;
        String dJw;
        long msgId;

        public a(long j2, String str, EmojiInfo emojiInfo, String str2) {
            this.msgId = j2;
            this.dJw = str;
            this.dEz = emojiInfo;
            this.dJX = str2;
        }
    }

    public final void b(String str, EmojiInfo emojiInfo, ca caVar) {
        long j2;
        long j3;
        AppMethodBeat.i(240142);
        if (Util.isNullOrNil(str) || emojiInfo == null) {
            AppMethodBeat.o(240142);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        if (b.w(emojiInfo)) {
            z = k.cGj().amF(emojiInfo.field_groupId);
            Log.i("MicroMsg.emoji.EmojiBypService", "isNeedShowRewardTip:%b", Boolean.valueOf(z));
        } else {
            k.cGj().cFU();
        }
        if (caVar == null) {
            ca caVar2 = new ca();
            if (emojiInfo.field_type > 3 || emojiInfo.field_type <= 0) {
                Toast.makeText(MMApplicationContext.getContext(), (int) R.string.btk, 0).show();
                Log.i("MicroMsg.emoji.EmojiBypService", "gamelife fobidden image: wrong format: emoji Type:%d", Integer.valueOf(emojiInfo.field_type));
                AppMethodBeat.o(240142);
                return;
            }
            caVar2.setType(47);
            caVar2.Cy(str);
            caVar2.nv(1);
            caVar2.setContent(be.a("", currentTimeMillis, !emojiInfo.NA() && !emojiInfo.isGif(), emojiInfo.getMd5(), z, ""));
            caVar2.Cz(emojiInfo.getMd5());
            caVar2.setCreateTime(bp.Kw(caVar2.field_talker));
            j2 = ((l) g.af(l.class)).eiy().aC(caVar2);
            j3 = currentTimeMillis;
        } else {
            long j4 = caVar.field_msgId;
            be bkr = be.bkr(caVar.field_content);
            if (bkr.time == 0) {
                caVar.setStatus(5);
                ((l) g.af(l.class)).eiy().a(j4, caVar);
                AppMethodBeat.o(240142);
                return;
            }
            j2 = j4;
            j3 = bkr.time;
        }
        Log.i("MicroMsg.emoji.EmojiBypService", "add Emoji: msgId = %s, md5 %s, len %s", Long.valueOf(j2), emojiInfo.getMd5(), Integer.valueOf(emojiInfo.field_size));
        this.rba.add(new a(j2, str, emojiInfo, String.valueOf(j3)));
        if (!this.raZ || this.rba.size() == 1) {
            this.raZ = true;
            if (emojiInfo.field_catalog == EmojiInfo.VkV || emojiInfo.field_catalog == EmojiInfo.VkU) {
                cFV();
                AppMethodBeat.o(240142);
                return;
            }
            this.rbb.clear();
            this.rbb.add(this.rba.get(0).dEz.field_md5);
            g.aAg().hqi.a(new f((LinkedList) this.rbb), 0);
        }
        AppMethodBeat.o(240142);
    }

    public final void cFV() {
        AppMethodBeat.i(240143);
        if (this.rba.isEmpty()) {
            Log.e("MicroMsg.emoji.EmojiBypService", "no emoji to upload");
            AppMethodBeat.o(240143);
            return;
        }
        a aVar = this.rba.get(0);
        String str = aVar.dJw;
        EmojiInfo emojiInfo = aVar.dEz;
        Long valueOf = Long.valueOf(aVar.msgId);
        String str2 = aVar.dJX;
        com.tencent.mm.plugin.emoji.a cEL = com.tencent.mm.plugin.emoji.a.cEL();
        cEL.fQY = String.valueOf(str2);
        cEL.gWm = emojiInfo;
        cEL.toUser = str;
        cEL.msgId = valueOf.longValue();
        o.b bdQ = cEL.bdQ();
        this.rbc = bdQ.jdJ;
        bdQ.execute();
        AppMethodBeat.o(240143);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        kb kbVar;
        int i4 = 2;
        AppMethodBeat.i(240144);
        Log.i("MicroMsg.emoji.EmojiBypService", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (!(qVar instanceof f) || this.rba.isEmpty()) {
            if (this.rbc != null && this.rbc.getClass().isInstance(qVar)) {
                if (!(i2 == 0 && i3 == 0)) {
                    Log.e("MicroMsg.emoji.EmojiBypService", "handleBypSendResult errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    i4 = 5;
                }
                FV(i4);
            }
            AppMethodBeat.o(240144);
        } else if (i2 == 0 && i3 == 0) {
            f fVar = (f) qVar;
            if (fVar.rr == null) {
                kbVar = null;
            } else {
                kbVar = (kb) fVar.rr.iLL.iLR;
            }
            if (!kbVar.KOp.isEmpty()) {
                ait first = kbVar.KOp.getFirst();
                if (first.Md5.equals(this.rbb.get(0)) && first.Url != null) {
                    cFV();
                    AppMethodBeat.o(240144);
                    return;
                }
            } else {
                Log.e("MicroMsg.emoji.EmojiBypService", "handleDownloadResult: BatchEmojiDownLoadResponse resp EmojiList empty ");
            }
            if (this.rba.isEmpty()) {
                Log.e("MicroMsg.emoji.EmojiBypService", "no emoji to upload");
                AppMethodBeat.o(240144);
                return;
            }
            new com.tencent.mm.emoji.d.f(this.rba.get(0).dEz, false, new d.a() {
                /* class com.tencent.mm.plugin.emoji.model.c.AnonymousClass1 */

                @Override // com.tencent.mm.emoji.d.d.a
                public final void A(int i2, String str) {
                    AppMethodBeat.i(240139);
                    if (i2 == 0) {
                        c.this.cFV();
                        AppMethodBeat.o(240139);
                        return;
                    }
                    c.this.FV(5);
                    Log.e("MicroMsg.emoji.EmojiBypService", "uploadCDN error");
                    AppMethodBeat.o(240139);
                }
            });
            AppMethodBeat.o(240144);
        } else {
            Log.e("MicroMsg.emoji.EmojiBypService", "handleDownloadResult errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            FV(5);
            AppMethodBeat.o(240144);
        }
    }

    /* access modifiers changed from: package-private */
    public final void FV(int i2) {
        AppMethodBeat.i(240145);
        if (this.rba.size() <= 0) {
            this.raZ = false;
            AppMethodBeat.o(240145);
            return;
        }
        a remove = this.rba.remove(0);
        ca Hb = ((l) g.af(l.class)).eiy().Hb(remove.msgId);
        Hb.setStatus(i2);
        ((l) g.af(l.class)).eiy().a(remove.msgId, Hb);
        if (this.rba.size() > 0) {
            this.rbb.clear();
            this.rbb.add(this.rba.get(0).dEz.field_md5);
            g.aAg().hqi.a(new f((LinkedList) this.rbb), 0);
            AppMethodBeat.o(240145);
            return;
        }
        this.raZ = false;
        AppMethodBeat.o(240145);
    }
}
