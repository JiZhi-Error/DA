package com.tencent.mm.plugin.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0003¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "Lcom/tencent/mm/vfs/VFSFile;", "path", "", "(Ljava/lang/String;)V", "clearAll", "", "contains", "id", "content", "webview-sdk_release"})
public final class b extends o {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(String str) {
        super(str);
        p.h(str, "path");
        AppMethodBeat.i(224912);
        AppMethodBeat.o(224912);
    }

    public final boolean contains(String str) {
        AppMethodBeat.i(224909);
        p.h(str, "id");
        boolean YS = s.YS(getPath() + '/' + str);
        AppMethodBeat.o(224909);
        return YS;
    }

    public final o aWR(String str) {
        AppMethodBeat.i(224910);
        p.h(str, "id");
        o oVar = new o(getPath() + '/' + str);
        AppMethodBeat.o(224910);
        return oVar;
    }

    public final boolean clearAll() {
        AppMethodBeat.i(224911);
        boolean dy = s.dy(getPath(), true);
        AppMethodBeat.o(224911);
        return dy;
    }
}
