package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/ImageMaterial;", "Lcom/tencent/mm/plugin/vlog/model/Material;", "path", "", "startTime", "", "endTime", "animType", "Lcom/tencent/mm/plugin/vlog/model/ImageAnimType;", "(Ljava/lang/String;JJLcom/tencent/mm/plugin/vlog/model/ImageAnimType;)V", "getAnimType", "()Lcom/tencent/mm/plugin/vlog/model/ImageAnimType;", "plugin-vlog_release"})
public final class q extends s {
    private final p Gyp;

    public /* synthetic */ q(String str, long j2, long j3) {
        this(str, j2, j3, p.NO_ANIM);
        AppMethodBeat.i(110927);
        AppMethodBeat.o(110927);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private q(String str, long j2, long j3, p pVar) {
        super(y.CENTER_INSIDE, l.NO_FILTER, ab.NONE, j2, j3, 0, str, 416);
        p.h(str, "path");
        p.h(pVar, "animType");
        AppMethodBeat.i(110926);
        this.Gyp = pVar;
        AppMethodBeat.o(110926);
    }
}
