package com.tencent.mm.plugin.mv.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMvRecommendListCacheKey;", "", "songInfoBase64", "", "(Ljava/lang/String;)V", "getSongInfoBase64", "()Ljava/lang/String;", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-mv_release"})
public final class j {
    private final String Aqk;

    public final boolean equals(Object obj) {
        AppMethodBeat.i(256809);
        if (this == obj || ((obj instanceof j) && p.j(this.Aqk, ((j) obj).Aqk))) {
            AppMethodBeat.o(256809);
            return true;
        }
        AppMethodBeat.o(256809);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(256808);
        String str = this.Aqk;
        if (str != null) {
            int hashCode = str.hashCode();
            AppMethodBeat.o(256808);
            return hashCode;
        }
        AppMethodBeat.o(256808);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(256807);
        String str = "MusicMvRecommendListCacheKey(songInfoBase64=" + this.Aqk + ")";
        AppMethodBeat.o(256807);
        return str;
    }

    public j(String str) {
        p.h(str, "songInfoBase64");
        AppMethodBeat.i(256806);
        this.Aqk = str;
        AppMethodBeat.o(256806);
    }
}
