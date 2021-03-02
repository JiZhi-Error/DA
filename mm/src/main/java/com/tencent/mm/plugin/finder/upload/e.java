package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderPostClearTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "call", "", "uniqueId", "plugin-finder_release"})
public final class e extends h {
    private final String id;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(String str) {
        super(new FinderItem());
        p.h(str, "id");
        AppMethodBeat.i(167737);
        this.id = str;
        AppMethodBeat.o(167737);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001f, code lost:
        if (((java.lang.Boolean) com.tencent.mm.plugin.finder.storage.c.dtp().value()).booleanValue() != false) goto L_0x0021;
     */
    @Override // com.tencent.mm.plugin.finder.upload.j, com.tencent.mm.loader.g.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void call() {
        /*
        // Method dump skipped, instructions count: 330
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.e.call():void");
    }

    @Override // com.tencent.mm.plugin.finder.upload.h, com.tencent.mm.loader.g.c
    public final String auK() {
        return this.id;
    }
}
