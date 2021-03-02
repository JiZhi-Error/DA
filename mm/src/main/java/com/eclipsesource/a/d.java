package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d extends h {
    private final String string;

    d(String str) {
        AppMethodBeat.i(74710);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("string is null");
            AppMethodBeat.o(74710);
            throw nullPointerException;
        }
        this.string = str;
        AppMethodBeat.o(74710);
    }

    @Override // com.eclipsesource.a.h
    public final String toString() {
        return this.string;
    }

    /* access modifiers changed from: package-private */
    @Override // com.eclipsesource.a.h
    public final void a(i iVar) {
        AppMethodBeat.i(74711);
        iVar.aY(this.string);
        AppMethodBeat.o(74711);
    }

    @Override // com.eclipsesource.a.h
    public final boolean isNumber() {
        return true;
    }

    @Override // com.eclipsesource.a.h
    public final int sf() {
        AppMethodBeat.i(74712);
        int parseInt = Integer.parseInt(this.string, 10);
        AppMethodBeat.o(74712);
        return parseInt;
    }

    @Override // com.eclipsesource.a.h
    public final long sg() {
        AppMethodBeat.i(74713);
        long parseLong = Long.parseLong(this.string, 10);
        AppMethodBeat.o(74713);
        return parseLong;
    }

    @Override // com.eclipsesource.a.h
    public final double sh() {
        AppMethodBeat.i(74714);
        double parseDouble = Double.parseDouble(this.string);
        AppMethodBeat.o(74714);
        return parseDouble;
    }

    @Override // com.eclipsesource.a.h
    public final int hashCode() {
        AppMethodBeat.i(74715);
        int hashCode = this.string.hashCode();
        AppMethodBeat.o(74715);
        return hashCode;
    }

    @Override // com.eclipsesource.a.h
    public final boolean equals(Object obj) {
        AppMethodBeat.i(74716);
        if (this == obj) {
            AppMethodBeat.o(74716);
            return true;
        } else if (obj == null) {
            AppMethodBeat.o(74716);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.o(74716);
            return false;
        } else {
            boolean equals = this.string.equals(((d) obj).string);
            AppMethodBeat.o(74716);
            return equals;
        }
    }
}
