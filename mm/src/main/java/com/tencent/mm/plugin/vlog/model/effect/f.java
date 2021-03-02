package com.tencent.mm.plugin.vlog.model.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/effect/MagicListTitleItem;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "title", "", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "plugin-vlog_release"})
public final class f extends e {
    public final String title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(String str) {
        super(1);
        p.h(str, "title");
        AppMethodBeat.i(190733);
        this.title = str;
        AppMethodBeat.o(190733);
    }
}
