package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import org.b.g.d;

public final class i implements Serializable {
    public final String Mte;
    private final String rawResponse;
    public final String token;

    public i(String str, String str2) {
        this(str, str2, null);
    }

    public i(String str, String str2, String str3) {
        AppMethodBeat.i(40536);
        d.j(str, "Token can't be null");
        d.j(str2, "Secret can't be null");
        this.token = str;
        this.Mte = str2;
        this.rawResponse = str3;
        AppMethodBeat.o(40536);
    }

    public final String toString() {
        AppMethodBeat.i(40537);
        String format = String.format("Token[%s , %s]", this.token, this.Mte);
        AppMethodBeat.o(40537);
        return format;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(40538);
        if (this == obj) {
            AppMethodBeat.o(40538);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(40538);
            return false;
        } else {
            i iVar = (i) obj;
            if (!this.token.equals(iVar.token) || !this.Mte.equals(iVar.Mte)) {
                AppMethodBeat.o(40538);
                return false;
            }
            AppMethodBeat.o(40538);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(40539);
        int hashCode = (this.token.hashCode() * 31) + this.Mte.hashCode();
        AppMethodBeat.o(40539);
        return hashCode;
    }
}
