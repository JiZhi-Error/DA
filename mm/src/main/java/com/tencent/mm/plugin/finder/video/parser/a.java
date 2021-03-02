package com.tencent.mm.plugin.finder.video.parser;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/parser/FinderMp4Parser;", "Lcom/tencent/mm/plugin/Atom/Mp4Parser2;", "()V", "TAG", "", "setLazyParse", "", "plugin-finder_release"})
public final class a extends k {
    private final String TAG = "Finder.FinderMp4Parser";

    @Override // com.tencent.mm.plugin.a.k
    public final void blT() {
        AppMethodBeat.i(254441);
        Log.i(this.TAG, "setLazyParse false");
        this.jQI = false;
        AppMethodBeat.o(254441);
    }
}
