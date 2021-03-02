package com.tencent.mm.search.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0001H\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J,\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/search/data/SimilarEmojiManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "()V", "callback", "timeStart", "", "getSimilarEmojiList", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onCrate", "onDestroy", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-emojisdk_release"})
public final class c implements i, a {
    public static final a NJj = new a((byte) 0);
    private i callback;
    private long hei;

    static {
        AppMethodBeat.i(105825);
        AppMethodBeat.o(105825);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/search/data/SimilarEmojiManager$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.search.data.a
    public final void awy() {
        AppMethodBeat.i(105821);
        b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3793, this);
        AppMethodBeat.o(105821);
    }

    @Override // com.tencent.mm.search.data.a
    public final void onDestroy() {
        AppMethodBeat.i(105822);
        this.callback = null;
        b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3793, this);
        b aAg2 = g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().cancel(3793);
        AppMethodBeat.o(105822);
    }

    @Override // com.tencent.mm.search.data.a
    public final void b(SimilarEmojiQueryModel similarEmojiQueryModel, i iVar) {
        AppMethodBeat.i(105823);
        p.h(similarEmojiQueryModel, "model");
        p.h(iVar, "callback");
        Log.i("MicroMsg.SimilarEmoji", "do net request:[" + similarEmojiQueryModel + ']');
        this.callback = iVar;
        b bVar = new b(similarEmojiQueryModel);
        this.hei = System.currentTimeMillis();
        b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(bVar);
        AppMethodBeat.o(105823);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(105824);
        com.tencent.mm.search.c.a aVar = com.tencent.mm.search.c.a.NJv;
        if (com.tencent.mm.search.c.a.MH(this.hei)) {
            com.tencent.mm.search.c.a aVar2 = com.tencent.mm.search.c.a.NJv;
            com.tencent.mm.search.c.a.gxw();
            com.tencent.mm.search.c.a aVar3 = com.tencent.mm.search.c.a.NJv;
            com.tencent.mm.search.c.a.MF(System.currentTimeMillis() - this.hei);
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i2, i3, str, qVar);
            AppMethodBeat.o(105824);
            return;
        }
        AppMethodBeat.o(105824);
    }
}
