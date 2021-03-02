package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.x;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderBlurUrlImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "blurUrl", "", "blurMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "uniqueValue", "plugin-finder_release"})
public final class e extends p {
    private final String uIm;
    private final x uIn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(String str, x xVar) {
        super(str, xVar);
        p.h(xVar, "blurMediaType");
        AppMethodBeat.i(248212);
        this.uIm = str;
        this.uIn = xVar;
        AppMethodBeat.o(248212);
    }

    @Override // com.tencent.mm.plugin.finder.loader.p, com.tencent.mm.loader.h.a.c
    public final String auA() {
        AppMethodBeat.i(248211);
        String str = this.uIn.detail + "_finder_blur_" + this.md5;
        AppMethodBeat.o(248211);
        return str;
    }
}
