package com.tencent.mm.plugin.finder.megavideo.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
final class a extends q implements b<r, Boolean> {
    public static final a uNl = new a();

    static {
        AppMethodBeat.i(248640);
        AppMethodBeat.o(248640);
    }

    a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ Boolean invoke(r rVar) {
        AppMethodBeat.i(248639);
        p.h(rVar, LocaleUtil.ITALIAN);
        Boolean bool = Boolean.TRUE;
        AppMethodBeat.o(248639);
        return bool;
    }
}
