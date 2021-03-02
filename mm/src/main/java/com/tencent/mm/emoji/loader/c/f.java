package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.d;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00128\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J*\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u001cH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000RC\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfigRetriever;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "config", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "scene", "Lcom/tencent/mm/plugin/emoji/net/NetSceneBatchEmojiDownLoad;", "createFetcherConfig", "onSceneEnd", "errType", "", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-emojisdk_release"})
public final class f implements i {
    private final String TAG = "MicroMsg.EmojiFetcherConfigRetriever";
    private final EmojiInfo gWm;
    private final e gWo;
    final m<Boolean, e, x> gWp;

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.g.a.m<? super java.lang.Boolean, ? super com.tencent.mm.emoji.loader.c.e, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    public f(EmojiInfo emojiInfo, m<? super Boolean, ? super e, x> mVar) {
        p.h(emojiInfo, "emojiInfo");
        p.h(mVar, "callback");
        AppMethodBeat.i(105438);
        this.gWm = emojiInfo;
        this.gWp = mVar;
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.gWm.getMd5());
        this.gWo = new e(linkedList);
        e g2 = g(this.gWm);
        if (g2.url.length() > 0) {
            this.gWp.invoke(Boolean.TRUE, g2);
            AppMethodBeat.o(105438);
            return;
        }
        Log.i(this.TAG, "config retriever: db url is empty");
        d.CK(9);
        b aAg = g.aAg();
        p.g(aAg, "network()");
        aAg.azz().a(697, this);
        b aAg2 = g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().b(this.gWo);
        AppMethodBeat.o(105438);
    }

    private final e g(EmojiInfo emojiInfo) {
        String str;
        String str2;
        int i2 = 0;
        AppMethodBeat.i(105436);
        String str3 = emojiInfo.hYx() + "_temp";
        if (i.i(emojiInfo)) {
            Log.i(this.TAG, "createFetcherConfig: " + emojiInfo.getMd5() + " use wxam");
            str = emojiInfo.field_externUrl;
            p.g(str, "emojiInfo.field_externUrl");
            i2 = 2;
        } else if (i.j(emojiInfo)) {
            Log.i(this.TAG, "createFetcherConfig: " + emojiInfo.getMd5() + " use encrypt");
            str = emojiInfo.field_encrypturl;
            p.g(str, "emojiInfo.field_encrypturl");
            i2 = 1;
        } else if (!Util.isNullOrNil(emojiInfo.field_cdnUrl)) {
            Log.i(this.TAG, "createFetcherConfig: " + emojiInfo.getMd5() + " use cdn url");
            str = emojiInfo.field_cdnUrl;
            p.g(str, "emojiInfo.field_cdnUrl");
        } else if (i.h(emojiInfo)) {
            Log.i(this.TAG, "createFetcherConfig: " + emojiInfo.getMd5() + " use tp url");
            str = emojiInfo.field_tpurl;
            p.g(str, "emojiInfo.field_tpurl");
            i2 = 3;
        } else {
            str = "";
        }
        if (emojiInfo.field_tpauthkey == null) {
            str2 = "";
        } else {
            str2 = emojiInfo.field_tpauthkey;
        }
        p.g(str2, "if (null == emojiInfo.fi…emojiInfo.field_tpauthkey");
        e eVar = new e(emojiInfo, str, str3, str2, i2);
        AppMethodBeat.o(105436);
        return eVar;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        EmojiInfo emojiInfo;
        boolean z2;
        AppMethodBeat.i(105437);
        p.h(qVar, "scene");
        int type = qVar.getType();
        Log.i(this.TAG, "onSceneEnd: " + i2 + ", " + i3 + ", " + type);
        if (type == 697 && p.j(qVar, this.gWo)) {
            b aAg = g.aAg();
            p.g(aAg, "network()");
            aAg.azz().b(697, this);
            kb cGq = this.gWo.cGq();
            LinkedList<ait> linkedList = cGq != null ? cGq.KOp : null;
            if (linkedList == null || linkedList.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i(this.TAG, "onSceneEnd: response list is empty");
                h.INSTANCE.F(164, 11);
                if ((((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_sync_test, 0) & 4) > 0 && com.tencent.mm.plugin.emoji.h.b.x(this.gWm)) {
                    c cVar = new c(0, 2, j.listOf(this.gWm.getMd5()));
                    com.tencent.mm.kernel.b aAg2 = g.aAg();
                    p.g(aAg2, "MMKernel.network()");
                    aAg2.azz().b(cVar);
                    bj gCJ = bj.gCJ();
                    p.g(gCJ, "EmojiStorageMgr.getInstance()");
                    gCJ.cgN().I(j.listOf(this.gWm.getMd5()), 0);
                }
                this.gWp.invoke(Boolean.FALSE, null);
                AppMethodBeat.o(105437);
                return;
            }
            bj gCJ2 = bj.gCJ();
            p.g(gCJ2, "EmojiStorageMgr.getInstance()");
            EmojiInfo blk = gCJ2.cgN().blk(this.gWm.getMd5());
            if (blk == null) {
                emojiInfo = this.gWm;
            } else {
                emojiInfo = blk;
            }
            com.tencent.mm.plugin.emoji.h.b.a(cGq.KOp.get(0), emojiInfo);
            com.tencent.mm.plugin.emoji.h.b.a(cGq.KOp.get(0), this.gWm);
            e g2 = g(emojiInfo);
            if (g2.url.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
                ((com.tencent.mm.plugin.emoji.b.d) ah).getProvider().updateEmojiInfo(emojiInfo);
                com.tencent.mm.ac.d.b("EmojiFetcherConfigRetriever_onSceneEnd", new a(this, g2));
                AppMethodBeat.o(105437);
                return;
            }
            this.gWp.invoke(Boolean.FALSE, null);
        }
        AppMethodBeat.o(105437);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ f gWq;
        final /* synthetic */ e gWr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(f fVar, e eVar) {
            super(0);
            this.gWq = fVar;
            this.gWr = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            AppMethodBeat.i(105435);
            this.gWq.gWp.invoke(Boolean.TRUE, this.gWr);
            x xVar = x.SXb;
            AppMethodBeat.o(105435);
            return xVar;
        }
    }
}
