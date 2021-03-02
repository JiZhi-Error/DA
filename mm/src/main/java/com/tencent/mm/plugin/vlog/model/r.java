package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/ImageSource;", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "width", "", "height", "path", "", "(IILjava/lang/String;)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "plugin-vlog_release"})
public final class r extends z {
    String path;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(int i2, int i3, String str) {
        super(i2, i3, 1, (byte) 0);
        p.h(str, "path");
        AppMethodBeat.i(190587);
        this.path = str;
        AppMethodBeat.o(190587);
    }
}
