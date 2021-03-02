package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class s {
    public String appId;
    public int jjN;

    public s(String str, int i2) {
        this.appId = str;
        this.jjN = i2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(151791);
        if (obj == null) {
            AppMethodBeat.o(151791);
            return false;
        } else if (!(obj instanceof s)) {
            AppMethodBeat.o(151791);
            return false;
        } else {
            s sVar = (s) obj;
            if (!sVar.appId.equals(this.appId) || sVar.jjN != this.jjN) {
                AppMethodBeat.o(151791);
                return false;
            }
            AppMethodBeat.o(151791);
            return true;
        }
    }

    public final String toString() {
        AppMethodBeat.i(151792);
        String str = this.appId + this.jjN;
        AppMethodBeat.o(151792);
        return str;
    }
}
