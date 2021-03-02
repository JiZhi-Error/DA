package com.tencent.mm.live.view.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/live/view/adapter/MembersData;", "", ch.COL_USERNAME, "", "(Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "setUsername", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-logic_release"})
public final class g {
    String username;

    public final boolean equals(Object obj) {
        AppMethodBeat.i(208685);
        if (this == obj || ((obj instanceof g) && p.j(this.username, ((g) obj).username))) {
            AppMethodBeat.o(208685);
            return true;
        }
        AppMethodBeat.o(208685);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(208684);
        String str = this.username;
        if (str != null) {
            int hashCode = str.hashCode();
            AppMethodBeat.o(208684);
            return hashCode;
        }
        AppMethodBeat.o(208684);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(208683);
        String str = "MembersData(username=" + this.username + ")";
        AppMethodBeat.o(208683);
        return str;
    }

    public g(String str) {
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(208682);
        this.username = str;
        AppMethodBeat.o(208682);
    }
}
