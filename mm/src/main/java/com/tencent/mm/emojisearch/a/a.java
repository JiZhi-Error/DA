package com.tencent.mm.emojisearch.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0001H\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J,\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/emojisearch/data/EmojiSearchManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/emojisearch/data/IEmojiSearchManager;", "()V", "callback", "timeStart", "", "getEmojiSearchList", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onCrate", "onDestroy", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-emojisdk_release"})
public final class a implements i, b {
    public static final C0340a hej = new C0340a((byte) 0);
    private i callback;
    private long hei;

    static {
        AppMethodBeat.i(200019);
        AppMethodBeat.o(200019);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/emojisearch/data/EmojiSearchManager$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emojisearch.a.a$a  reason: collision with other inner class name */
    public static final class C0340a {
        private C0340a() {
        }

        public /* synthetic */ C0340a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.emojisearch.a.b
    public final void awy() {
        AppMethodBeat.i(200015);
        b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3793, this);
        AppMethodBeat.o(200015);
    }

    @Override // com.tencent.mm.emojisearch.a.b
    public final void onDestroy() {
        AppMethodBeat.i(200016);
        this.callback = null;
        b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3793, this);
        b aAg2 = g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().cancel(3793);
        AppMethodBeat.o(200016);
    }

    @Override // com.tencent.mm.emojisearch.a.b
    public final void a(SimilarEmojiQueryModel similarEmojiQueryModel, i iVar) {
        AppMethodBeat.i(200017);
        p.h(similarEmojiQueryModel, "model");
        p.h(iVar, "callback");
        Log.i("MicroMsg.EmojiSearch", "do net request:[" + similarEmojiQueryModel + ']');
        this.callback = iVar;
        com.tencent.mm.emojisearch.c.a aVar = new com.tencent.mm.emojisearch.c.a(similarEmojiQueryModel);
        this.hei = System.currentTimeMillis();
        b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(aVar);
        AppMethodBeat.o(200017);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(200018);
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i2, i3, str, qVar);
            AppMethodBeat.o(200018);
            return;
        }
        AppMethodBeat.o(200018);
    }
}
