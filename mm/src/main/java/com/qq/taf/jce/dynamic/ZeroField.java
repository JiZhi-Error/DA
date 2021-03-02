package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ZeroField extends NumberField {
    ZeroField(int i2) {
        super(i2);
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public final Number getNumber() {
        AppMethodBeat.i(109569);
        AppMethodBeat.o(109569);
        return 0;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public final byte byteValue() {
        return 0;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public final double doubleValue() {
        return 0.0d;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public final float floatValue() {
        return 0.0f;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public final int intValue() {
        return 0;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public final long longValue() {
        return 0;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public final short shortValue() {
        return 0;
    }
}
