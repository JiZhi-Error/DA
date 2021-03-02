package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShortField extends NumberField {
    private short data;

    ShortField(short s, int i2) {
        super(i2);
        this.data = s;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public final Number getNumber() {
        AppMethodBeat.i(109562);
        Short valueOf = Short.valueOf(this.data);
        AppMethodBeat.o(109562);
        return valueOf;
    }

    public final short get() {
        return this.data;
    }

    public final void set(short s) {
        this.data = s;
    }
}
