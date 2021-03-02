package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LongField extends NumberField {
    private long data;

    LongField(long j2, int i2) {
        super(i2);
        this.data = j2;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public Number getNumber() {
        AppMethodBeat.i(109568);
        Long valueOf = Long.valueOf(this.data);
        AppMethodBeat.o(109568);
        return valueOf;
    }

    public long get() {
        return this.data;
    }

    public void set(long j2) {
        this.data = j2;
    }
}
