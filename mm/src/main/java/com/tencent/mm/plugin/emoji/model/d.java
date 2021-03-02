package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.g.a.xf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.smtt.sdk.TbsListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class d implements i {
    private boolean raZ = false;
    List<b> rba = new LinkedList();
    public HashMap<Long, String> rbe = new HashMap<>();
    private xf rbf;
    public a rbg;

    public interface a {
        void a(boolean z, EmojiInfo emojiInfo);
    }

    public d() {
        AppMethodBeat.i(108574);
        g.aAg().hqi.a(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, this);
        AppMethodBeat.o(108574);
    }

    private static void CL(long j2) {
        AppMethodBeat.i(108575);
        ((ba) ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(((l) g.af(l.class)).eiy().Hb(j2));
        AppMethodBeat.o(108575);
    }

    /* access modifiers changed from: package-private */
    public class b {
        EmojiInfo dEz;
        String dJX;
        String dJw;
        long msgId;

        public b(long j2, String str, EmojiInfo emojiInfo, String str2) {
            this.msgId = j2;
            this.dJw = str;
            this.dEz = emojiInfo;
            this.dJX = str2;
        }
    }

    public final void a(String str, EmojiInfo emojiInfo, ca caVar) {
        long j2;
        long j3;
        AppMethodBeat.i(108576);
        if (Util.isNullOrNil(str) || emojiInfo == null) {
            AppMethodBeat.o(108576);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        if (com.tencent.mm.plugin.emoji.h.b.w(emojiInfo)) {
            z = k.cGj().amF(emojiInfo.field_groupId);
            Log.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", Boolean.valueOf(z));
        } else {
            k.cGj().cFU();
        }
        if (caVar == null) {
            ca caVar2 = new ca();
            if (emojiInfo.field_type == EmojiInfo.Vla || emojiInfo.field_type == EmojiInfo.Vlb) {
                caVar2.setType(1048625);
            } else {
                caVar2.setType(47);
            }
            caVar2.Cy(str);
            caVar2.nv(1);
            caVar2.setContent(be.a(z.aTY(), currentTimeMillis, !emojiInfo.NA() && !emojiInfo.isGif(), emojiInfo.getMd5(), z, ""));
            caVar2.Cz(emojiInfo.getMd5());
            caVar2.setCreateTime(bp.Kw(caVar2.field_talker));
            j2 = ((l) g.af(l.class)).eiy().aC(caVar2);
            j3 = currentTimeMillis;
        } else {
            long j4 = caVar.field_msgId;
            be bkr = be.bkr(caVar.field_content);
            if (bkr.time == 0) {
                AppMethodBeat.o(108576);
                return;
            } else {
                j2 = j4;
                j3 = bkr.time;
            }
        }
        Log.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = %s, md5 %s, len %s", Long.valueOf(j2), emojiInfo.getMd5(), Integer.valueOf(emojiInfo.field_size));
        this.rba.add(new b(j2, str, emojiInfo, String.valueOf(j3)));
        if (!this.raZ || this.rba.size() == 1) {
            this.raZ = true;
            g.aAg().hqi.a(new s(String.valueOf(j3), str, emojiInfo, j2), 0);
        }
        amP(emojiInfo.field_groupId);
        AppMethodBeat.o(108576);
    }

    private void fB(int i2, int i3) {
        int i4;
        b bVar;
        AppMethodBeat.i(240147);
        if (this.rba.size() <= 0) {
            this.raZ = false;
            AppMethodBeat.o(240147);
            return;
        }
        b remove = this.rba.remove(0);
        if (i2 == 0 && i3 == 0) {
            i4 = 2;
        } else {
            e.INSTANCE.idkeyStat(111, 35, 1, true);
            i4 = 5;
        }
        ca Hb = ((l) g.af(l.class)).eiy().Hb(remove.msgId);
        if (Hb.field_msgId > 0) {
            Hb.setStatus(i4);
            ((l) g.af(l.class)).eiy().a(remove.msgId, Hb);
        }
        if (this.rba.size() > 0) {
            bVar = this.rba.get(0);
            if (((l) g.af(l.class)).eiy().Hb(bVar.msgId).field_msgId > 0) {
                g.aAg().hqi.a(new s(bVar.dJX, bVar.dJw, bVar.dEz, bVar.msgId), 0);
            } else {
                fB(-1, -1);
            }
        } else {
            this.raZ = false;
            bVar = remove;
        }
        if (this.rbf == null) {
            this.rbf = new xf();
        }
        this.rbf.edz.productId = bVar.dEz.field_groupId;
        EventCenter.instance.publish(this.rbf);
        AppMethodBeat.o(240147);
    }

    public final void amP(final String str) {
        AppMethodBeat.i(108577);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.emoji.model.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(108572);
                if (k.getEmojiStorageMgr().OpP.bli(str)) {
                    k.cGf();
                    f.amx(str);
                }
                AppMethodBeat.o(108572);
            }
        });
        AppMethodBeat.o(108577);
    }

    @Deprecated
    public final boolean u(EmojiInfo emojiInfo) {
        AppMethodBeat.i(108578);
        bi I = bi.I(emojiInfo);
        if (I == null) {
            Log.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
            AppMethodBeat.o(108578);
        } else {
            I.talker = emojiInfo == null ? "" : emojiInfo.talker;
            I.OpK = false;
            a(I, (h.a) null, true);
            amP(emojiInfo == null ? null : emojiInfo.field_groupId);
            AppMethodBeat.o(108578);
        }
        return true;
    }

    public final void a(bi biVar, h.a aVar, boolean z) {
        AppMethodBeat.i(108579);
        if (biVar == null) {
            Log.w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
            AppMethodBeat.o(108579);
            return;
        }
        if (!(aVar == null || aVar.heO == null || aVar.heO.Brn != biVar.dTS)) {
            biVar.fqJ = bp.d(aVar);
            biVar.jvu = aVar.heO.KHs;
            biVar.createTime = (long) aVar.heO.CreateTime;
        }
        EmojiInfo blk = k.getEmojiStorageMgr().OpN.blk(biVar.md5);
        if (blk != null) {
            Log.i("MicroMsg.emoji.EmojiService", "downloadEmoji: db emoji info not null %s msgInfomd5 %s svrId %s", blk.field_md5, biVar.md5, Long.valueOf(biVar.dTS));
            com.tencent.mm.plugin.emoji.h.b.b(biVar, blk);
            k.getEmojiStorageMgr().OpN.L(blk);
        } else {
            Log.i("MicroMsg.emoji.EmojiService", "downloadEmoji: create emoji info %s", biVar.md5);
            blk = a(biVar);
        }
        if (biVar.OpK) {
            a(biVar, blk, aVar);
        }
        Log.i("MicroMsg.emoji.EmojiService", "start download emoji %s, fileExist %b, download %b", blk.getMd5(), Boolean.valueOf(blk.hYi()), Boolean.valueOf(z));
        if (!blk.hYi()) {
            if (z) {
                a(biVar, blk);
                AppMethodBeat.o(108579);
                return;
            }
            Log.i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", Boolean.valueOf(z));
            b(biVar);
        }
        AppMethodBeat.o(108579);
    }

    private void a(final bi biVar, final EmojiInfo emojiInfo) {
        AppMethodBeat.i(108580);
        com.tencent.mm.emoji.loader.e eVar = com.tencent.mm.emoji.loader.e.gVM;
        com.tencent.mm.emoji.loader.e.a(emojiInfo, true, (i.a) new i.a() {
            /* class com.tencent.mm.plugin.emoji.model.d.AnonymousClass2 */

            @Override // com.tencent.mm.emoji.loader.d.i.a
            public final void dQ(boolean z) {
                AppMethodBeat.i(108573);
                d.b(biVar);
                if (d.this.rbg != null) {
                    d.this.rbg.a(z, emojiInfo);
                }
                AppMethodBeat.o(108573);
            }
        });
        AppMethodBeat.o(108580);
    }

    private static EmojiInfo a(bi biVar) {
        AppMethodBeat.i(108581);
        Log.i("MicroMsg.emoji.EmojiService", "createEmojiInfo: %s", biVar.md5);
        EmojiInfo emojiInfo = new EmojiInfo();
        com.tencent.mm.plugin.emoji.h.b.b(biVar, emojiInfo);
        emojiInfo.field_temp = 1;
        emojiInfo.field_state = EmojiInfo.Vlg;
        emojiInfo.field_catalog = EmojiInfo.VkQ;
        k.getEmojiStorageMgr().OpN.J(emojiInfo);
        AppMethodBeat.o(108581);
        return emojiInfo;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(108582);
        Log.i("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar instanceof s) {
            fB(i2, i3);
        }
        AppMethodBeat.o(108582);
    }

    private long a(bi biVar, EmojiInfo emojiInfo, h.a aVar) {
        boolean z;
        AppMethodBeat.i(108583);
        Log.i("MicroMsg.emoji.EmojiService", "insertEmojiMsg: %s, %s msgSvrId: %s", biVar.md5, emojiInfo.field_md5, Long.valueOf(biVar.dTS));
        if (biVar.dTS != 0) {
            ca aJ = ((l) g.af(l.class)).eiy().aJ(biVar.talker, biVar.dTS);
            if (aJ.field_msgSvrId == biVar.dTS) {
                long j2 = aJ.field_msgId;
                AppMethodBeat.o(108583);
                return j2;
            }
        }
        as Kn = ((l) g.af(l.class)).aSN().Kn(biVar.talker);
        if (Kn == null || ((int) Kn.gMZ) == 0) {
            as asVar = new as(biVar.talker);
            asVar.setType(2);
            ((l) g.af(l.class)).aSN().ap(asVar);
        }
        ca caVar = new ca();
        caVar.setType(47);
        caVar.Cy(biVar.talker);
        caVar.nv(z.Im(biVar.jsh) ? 1 : 0);
        caVar.Cz(emojiInfo.getMd5());
        caVar.yF(biVar.dTS);
        String str = biVar.jsh;
        if (emojiInfo.NA() || emojiInfo.isGif()) {
            z = false;
        } else {
            z = true;
        }
        caVar.setContent(be.a(str, 0, z, emojiInfo.getMd5(), false, biVar.OpG));
        caVar.setCreateTime(bp.C(caVar.field_talker, biVar.createTime));
        caVar.setStatus(3);
        if (!Util.isNullOrNil(biVar.fqK)) {
            caVar.BB(biVar.fqK);
        }
        if (aVar == null) {
            int i2 = biVar.fqJ;
            if (i2 != 0) {
                caVar.setFlag(i2);
                if (caVar.field_msgId == 0 && caVar.field_isSend == 0 && (i2 & 2) != 0) {
                    caVar.setCreateTime(biVar.createTime);
                }
            }
            if (biVar.jvu != 0) {
                caVar.yH((long) biVar.jvu);
            }
            Log.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", Integer.valueOf(i2), Integer.valueOf(biVar.jvu));
        } else {
            bp.a(caVar, aVar);
        }
        if (this.rbe != null && this.rbe.containsKey(Long.valueOf(caVar.field_msgSvrId))) {
            Log.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
            caVar.setContent(this.rbe.get(Long.valueOf(caVar.field_msgSvrId)));
            caVar.setType(10000);
            this.rbe.remove(Long.valueOf(caVar.field_msgSvrId));
        }
        long x = bp.x(caVar);
        if (!z.Im(biVar.jsh)) {
            CL(x);
        }
        AppMethodBeat.o(108583);
        return x;
    }

    static void b(bi biVar) {
        AppMethodBeat.i(108584);
        if (biVar == null) {
            AppMethodBeat.o(108584);
            return;
        }
        ((l) g.af(l.class)).eiy().a(new i.c(biVar.talker, "update", null));
        AppMethodBeat.o(108584);
    }
}
