package com.tencent.mm.plugin.finder.megavideo.bullet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.b.e;
import com.tencent.mm.danmaku.c.a;
import com.tencent.mm.danmaku.d.b;
import com.tencent.mm.danmaku.d.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/bullet/TextDanmaku;", "Lcom/tencent/mm/danmaku/data/ViewDanmaku;", "danmakuContext", "Lcom/tencent/mm/danmaku/inject/DanmakuContext;", "(Lcom/tencent/mm/danmaku/inject/DanmakuContext;)V", "onClick", "Lcom/tencent/mm/danmaku/tool/ClickResult;", "touchPoint", "Lcom/tencent/mm/danmaku/tool/TouchPoint;", "plugin-finder_release"})
public final class c extends e {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(a aVar) {
        super(aVar);
        p.h(aVar, "danmakuContext");
        AppMethodBeat.i(248277);
        AppMethodBeat.o(248277);
    }

    @Override // com.tencent.mm.danmaku.b.e, com.tencent.mm.danmaku.b.a
    public final b b(h hVar) {
        AppMethodBeat.i(248276);
        super.b(hVar);
        b bVar = new b(0);
        AppMethodBeat.o(248276);
        return bVar;
    }
}
