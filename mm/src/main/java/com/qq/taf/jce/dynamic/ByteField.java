package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ByteField extends NumberField {
    private byte data;

    ByteField(byte b2, int i2) {
        super(i2);
        this.data = b2;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public final Number getNumber() {
        AppMethodBeat.i(109571);
        Byte valueOf = Byte.valueOf(this.data);
        AppMethodBeat.o(109571);
        return valueOf;
    }

    public final byte get() {
        return this.data;
    }

    public final void set(byte b2) {
        this.data = b2;
    }
}
