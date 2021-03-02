package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\fR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/emoji/loader/fetcher/FetcherFactory;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fetch", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "plugin-emojisdk_release"})
public final class h {
    private static final String TAG = TAG;
    public static final h gWs = new h();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "success", "", "config", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "invoke"})
    static final class a extends q implements m<Boolean, e, x> {
        final /* synthetic */ b gWe;
        final /* synthetic */ EmojiInfo gWf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(EmojiInfo emojiInfo, b bVar) {
            super(2);
            this.gWf = emojiInfo;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, e eVar) {
            g gVar;
            AppMethodBeat.i(105441);
            e eVar2 = eVar;
            if (!bool.booleanValue() || eVar2 == null) {
                h hVar = h.gWs;
                Log.i(h.getTAG(), "fetch: get config fail " + this.gWf.getMd5());
                b bVar = this.gWe;
                if (bVar != null) {
                    bVar.invoke(Boolean.FALSE);
                }
            } else {
                h hVar2 = h.gWs;
                Log.i(h.getTAG(), eVar2.gWn + ' ' + eVar2.gWm.getMd5());
                if (eVar2.gWn == 3) {
                    gVar = new a();
                } else if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_download_cdn, false)) {
                    gVar = new b();
                } else {
                    gVar = new g();
                }
                gVar.a(eVar2, this.gWe);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105441);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(105443);
        AppMethodBeat.o(105443);
    }

    private h() {
    }

    public static String getTAG() {
        return TAG;
    }

    public static void d(EmojiInfo emojiInfo, kotlin.g.a.b<? super Boolean, x> bVar) {
        AppMethodBeat.i(105442);
        p.h(emojiInfo, "emojiInfo");
        new f(emojiInfo, new a(emojiInfo, bVar));
        AppMethodBeat.o(105442);
    }
}
