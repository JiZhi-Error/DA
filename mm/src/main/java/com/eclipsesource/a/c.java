package com.eclipsesource.a;

import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;

final class c extends h {
    private final boolean aZH;
    private final boolean aZI;
    private final boolean aZJ;
    private final String value;

    c(String str) {
        AppMethodBeat.i(74705);
        this.value = str;
        this.aZH = BuildConfig.COMMAND.equals(str);
        this.aZI = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(str);
        this.aZJ = "false".equals(str);
        AppMethodBeat.o(74705);
    }

    /* access modifiers changed from: package-private */
    @Override // com.eclipsesource.a.h
    public final void a(i iVar) {
        AppMethodBeat.i(74706);
        iVar.aX(this.value);
        AppMethodBeat.o(74706);
    }

    @Override // com.eclipsesource.a.h
    public final String toString() {
        return this.value;
    }

    @Override // com.eclipsesource.a.h
    public final int hashCode() {
        AppMethodBeat.i(74707);
        int hashCode = this.value.hashCode();
        AppMethodBeat.o(74707);
        return hashCode;
    }

    @Override // com.eclipsesource.a.h
    public final boolean isBoolean() {
        return this.aZI || this.aZJ;
    }

    @Override // com.eclipsesource.a.h
    public final boolean se() {
        AppMethodBeat.i(74708);
        if (this.aZH) {
            boolean se = super.se();
            AppMethodBeat.o(74708);
            return se;
        }
        boolean z = this.aZI;
        AppMethodBeat.o(74708);
        return z;
    }

    @Override // com.eclipsesource.a.h
    public final boolean equals(Object obj) {
        AppMethodBeat.i(74709);
        if (this == obj) {
            AppMethodBeat.o(74709);
            return true;
        } else if (obj == null) {
            AppMethodBeat.o(74709);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.o(74709);
            return false;
        } else {
            boolean equals = this.value.equals(((c) obj).value);
            AppMethodBeat.o(74709);
            return equals;
        }
    }
}
