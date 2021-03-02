package com.tencent.mm.plugin.emoji.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class h {
    private d.a rbA = new d.a() {
        /* class com.tencent.mm.plugin.emoji.model.h.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.emoji.model.d.a
        public final void a(boolean z, EmojiInfo emojiInfo) {
            AppMethodBeat.i(108590);
            if (emojiInfo == null || !z || Util.isNullOrNil(emojiInfo.field_md5) || !h.this.rby.remove(emojiInfo.getMd5())) {
                Log.i("MicroMsg.FTS.FTSEmojiLogic", "somethings error.");
                AppMethodBeat.o(108590);
                return;
            }
            Log.i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", emojiInfo.getMd5());
            gr grVar = new gr();
            grVar.dKH.dDe = 2;
            grVar.dKH.dKJ = emojiInfo.field_designerID;
            grVar.dKH.name = emojiInfo.field_name;
            grVar.dKH.aeskey = emojiInfo.field_aeskey;
            grVar.dKH.dKK = emojiInfo.field_encrypturl;
            grVar.dKH.thumbUrl = emojiInfo.field_thumbUrl;
            grVar.dKH.md5 = emojiInfo.field_md5;
            grVar.dKH.productId = emojiInfo.field_groupId;
            String hYx = emojiInfo.hYx();
            EmojiInfo blk = k.getEmojiStorageMgr().OpN.blk(emojiInfo.getMd5());
            if (blk == null || (blk.field_reserved4 & EmojiInfo.Vll) != EmojiInfo.Vll) {
                grVar.dKI.path = hYx;
            } else if (MMApplicationContext.getContext().getExternalCacheDir() == null) {
                AppMethodBeat.o(108590);
                return;
            } else {
                String z2 = aa.z(new o(MMApplicationContext.getContext().getExternalCacheDir(), g.getMessageDigest(emojiInfo.getMd5().getBytes())).her());
                if (s.YS(hYx) && !s.YS(z2)) {
                    byte[] a2 = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(blk);
                    if (a2 != null) {
                        s.e(z2, a2, a2.length);
                    } else {
                        Log.w("MicroMsg.FTS.FTSEmojiLogic", "onDownload: decrypt failed");
                    }
                }
                grVar.dKI.path = z2;
            }
            EventCenter.instance.asyncPublish(grVar, Looper.getMainLooper());
            AppMethodBeat.o(108590);
        }
    };
    Set<String> rby = Collections.synchronizedSet(new HashSet());
    IListener<gr> rbz = new IListener<gr>() {
        /* class com.tencent.mm.plugin.emoji.model.h.AnonymousClass1 */

        {
            AppMethodBeat.i(161079);
            this.__eventId = gr.class.getName().hashCode();
            AppMethodBeat.o(161079);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gr grVar) {
            AppMethodBeat.i(108589);
            gr grVar2 = grVar;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_designerID = grVar2.dKH.dKJ;
            emojiInfo.field_name = grVar2.dKH.name;
            emojiInfo.field_aeskey = grVar2.dKH.aeskey;
            emojiInfo.field_encrypturl = grVar2.dKH.dKK;
            emojiInfo.field_thumbUrl = grVar2.dKH.thumbUrl;
            emojiInfo.field_md5 = grVar2.dKH.md5;
            emojiInfo.field_groupId = grVar2.dKH.productId;
            EmojiInfo blk = k.getEmojiStorageMgr().OpN.blk(emojiInfo.getMd5());
            if (grVar2.dKH.dDe == 3) {
                String hYx = emojiInfo.hYx();
                if (blk == null || (blk.field_reserved4 & EmojiInfo.Vll) != EmojiInfo.Vll) {
                    grVar2.dKI.path = hYx;
                } else {
                    String z = aa.z(new o(MMApplicationContext.getContext().getCacheDir(), g.getMessageDigest(grVar2.dKH.md5.getBytes())).her());
                    if (s.YS(hYx) && !s.YS(z)) {
                        byte[] s = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().s(blk);
                        s.e(z, s, s.length);
                    }
                    grVar2.dKI.path = z;
                }
                Log.i("MicroMsg.FTS.FTSEmojiLogic", "gen path: %s", grVar2.dKI.path);
            } else if (grVar2.dKH.dDe == 1) {
                Log.i("MicroMsg.FTS.FTSEmojiLogic", "emoji download: %s", emojiInfo.getMd5());
                h.this.rby.add(emojiInfo.getMd5());
                k.cGd().u(emojiInfo);
            }
            AppMethodBeat.o(108589);
            return false;
        }
    };

    public h() {
        AppMethodBeat.i(108591);
        k.cGd().rbg = this.rbA;
        this.rbz.alive();
        AppMethodBeat.o(108591);
    }
}
