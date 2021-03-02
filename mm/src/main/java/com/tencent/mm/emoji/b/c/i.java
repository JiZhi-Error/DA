package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.c;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.g.b.a.jz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.dbh;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/emoji/model/search/EmojiSuggestWordsSync;", "", "()V", "requestRunning", "", "checkWordListUpdate", "", "updateWordList", "plugin-emojisdk_release"})
public final class i {
    private static boolean gZI;
    public static final i gZJ = new i();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ jz gZL;

        b(jz jzVar) {
            this.gZL = jzVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            int i2;
            LinkedList<dbh> linkedList;
            LinkedList<dbh> linkedList2;
            AppMethodBeat.i(199953);
            c.a aVar = (c.a) obj;
            int i3 = aVar.errType;
            int i4 = aVar.errCode;
            bmw bmw = (bmw) aVar.iLC;
            Log.i(h.TAG, "updateWordList: " + i3 + ", " + i4 + "; " + ((bmw == null || (linkedList2 = bmw.LVv) == null) ? null : Integer.valueOf(linkedList2.size())));
            i iVar = i.gZJ;
            i.gZI = false;
            this.gZL.te(Util.nowMilliSecond());
            if (i3 == 0 && i4 == 0) {
                this.gZL.tf(1);
                jz jzVar = this.gZL;
                if (bmw == null || (linkedList = bmw.LVv) == null) {
                    i2 = 0;
                } else {
                    i2 = linkedList.size();
                }
                jzVar.tg((long) i2);
                this.gZL.xj(String.valueOf(bmw != null ? bmw.LVx : 0));
                if (bmw != null && bmw.LVv.size() > 0) {
                    k kVar = k.gXr;
                    k.getKV().putInt("word_list_update_time", (int) Util.nowSecond());
                    byte[] byteArray = bmw.toByteArray();
                    bj gCJ = bj.gCJ();
                    p.g(gCJ, "EmojiStorageMgr.getInstance()");
                    gCJ.gCM().l("cache_type_words_list", byteArray);
                    g gVar = g.gZH;
                    g.avL();
                }
            } else {
                this.gZL.tf(2);
            }
            Boolean valueOf = Boolean.valueOf(this.gZL.bfK());
            AppMethodBeat.o(199953);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(199956);
        AppMethodBeat.o(199956);
    }

    private i() {
    }

    public static void avN() {
        AppMethodBeat.i(199954);
        if (!MMApplicationContext.isMainProcess()) {
            AppMethodBeat.o(199954);
            return;
        }
        d.b("EmojiSuggestWordsSync_checkWordListUpdate", a.gZK);
        AppMethodBeat.o(199954);
    }

    public static void avO() {
        AppMethodBeat.i(199955);
        jz jzVar = new jz();
        jzVar.td(Util.nowMilliSecond());
        new com.tencent.mm.emoji.b.c().aYI().g(new b(jzVar));
        AppMethodBeat.o(199955);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        public static final a gZK = new a();

        static {
            AppMethodBeat.i(199952);
            AppMethodBeat.o(199952);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(199951);
            int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_suggest_personal_words_interval, 0);
            k kVar = k.gXr;
            int auR = k.auR();
            String str = h.TAG;
            StringBuilder append = new StringBuilder("checkWordListUpdate: config ").append(a2).append(", last ").append(auR).append(", running ");
            i iVar = i.gZJ;
            Log.i(str, append.append(i.gZI).toString());
            if (a2 > 0 && Util.secondsToNow((long) auR) >= ((long) a2) * 3600) {
                i iVar2 = i.gZJ;
                if (!i.gZI) {
                    i iVar3 = i.gZJ;
                    i.gZI = true;
                    i iVar4 = i.gZJ;
                    i.avO();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(199951);
            return xVar;
        }
    }
}
