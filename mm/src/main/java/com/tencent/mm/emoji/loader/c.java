package com.tencent.mm.emoji.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.h.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/emoji/loader/EmojiGroupDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "()V", "downloader", "Lcom/tencent/mm/loader/impr/DefaultImageDownloader;", "loadDataImp", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "plugin-emojisdk_release"})
public final class c extends b<a> {
    private final com.tencent.mm.loader.e.b gVD = new com.tencent.mm.loader.e.b();

    public c() {
        AppMethodBeat.i(105385);
        AppMethodBeat.o(105385);
    }

    @Override // com.tencent.mm.loader.d.b
    public final void a(a<a> aVar, g gVar, b.AbstractC0401b bVar) {
        AppMethodBeat.i(105384);
        p.h(aVar, "url");
        p.h(gVar, "fileNameCreator");
        p.h(bVar, "callback");
        this.gVD.a(new a<>(aVar.value().gVA.hYg()), gVar, bVar);
        AppMethodBeat.o(105384);
    }
}
