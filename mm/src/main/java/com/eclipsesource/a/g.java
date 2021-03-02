package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class g extends h {
    private final String string;

    g(String str) {
        AppMethodBeat.i(74767);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("string is null");
            AppMethodBeat.o(74767);
            throw nullPointerException;
        }
        this.string = str;
        AppMethodBeat.o(74767);
    }

    /* access modifiers changed from: package-private */
    @Override // com.eclipsesource.a.h
    public final void a(i iVar) {
        AppMethodBeat.i(74768);
        iVar.writeString(this.string);
        AppMethodBeat.o(74768);
    }

    @Override // com.eclipsesource.a.h
    public final boolean isString() {
        return true;
    }

    @Override // com.eclipsesource.a.h
    public final String sG() {
        return this.string;
    }

    @Override // com.eclipsesource.a.h
    public final int hashCode() {
        AppMethodBeat.i(74769);
        int hashCode = this.string.hashCode();
        AppMethodBeat.o(74769);
        return hashCode;
    }

    @Override // com.eclipsesource.a.h
    public final boolean equals(Object obj) {
        AppMethodBeat.i(74770);
        if (this == obj) {
            AppMethodBeat.o(74770);
            return true;
        } else if (obj == null) {
            AppMethodBeat.o(74770);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.o(74770);
            return false;
        } else {
            boolean equals = this.string.equals(((g) obj).string);
            AppMethodBeat.o(74770);
            return equals;
        }
    }
}
