package com.bumptech.glide.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    private Class<?> aNV;
    private Class<?> aNW;
    private Class<?> aNX;

    public i() {
    }

    public i(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        AppMethodBeat.i(77762);
        e(cls, cls2, cls3);
        AppMethodBeat.o(77762);
    }

    public final void e(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.aNV = cls;
        this.aNW = cls2;
        this.aNX = cls3;
    }

    public final String toString() {
        AppMethodBeat.i(77763);
        String str = "MultiClassKey{first=" + this.aNV + ", second=" + this.aNW + '}';
        AppMethodBeat.o(77763);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(77764);
        if (this == obj) {
            AppMethodBeat.o(77764);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(77764);
            return false;
        } else {
            i iVar = (i) obj;
            if (!this.aNV.equals(iVar.aNV)) {
                AppMethodBeat.o(77764);
                return false;
            } else if (!this.aNW.equals(iVar.aNW)) {
                AppMethodBeat.o(77764);
                return false;
            } else if (!k.h(this.aNX, iVar.aNX)) {
                AppMethodBeat.o(77764);
                return false;
            } else {
                AppMethodBeat.o(77764);
                return true;
            }
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(77765);
        int hashCode = (this.aNX != null ? this.aNX.hashCode() : 0) + (((this.aNV.hashCode() * 31) + this.aNW.hashCode()) * 31);
        AppMethodBeat.o(77765);
        return hashCode;
    }
}
