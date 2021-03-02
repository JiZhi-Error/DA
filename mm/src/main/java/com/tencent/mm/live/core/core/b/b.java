package com.tencent.mm.live.core.core.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-core_release"})
public final class b {
    public String name;

    public final boolean equals(Object obj) {
        AppMethodBeat.i(196450);
        if (this == obj || ((obj instanceof b) && p.j(this.name, ((b) obj).name))) {
            AppMethodBeat.o(196450);
            return true;
        }
        AppMethodBeat.o(196450);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(196449);
        String str = this.name;
        if (str != null) {
            int hashCode = str.hashCode();
            AppMethodBeat.o(196449);
            return hashCode;
        }
        AppMethodBeat.o(196449);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(196448);
        String str = "LiveJumpInfo(name=" + this.name + ")";
        AppMethodBeat.o(196448);
        return str;
    }

    public b(String str) {
        p.h(str, "name");
        AppMethodBeat.i(196447);
        this.name = str;
        AppMethodBeat.o(196447);
    }
}
