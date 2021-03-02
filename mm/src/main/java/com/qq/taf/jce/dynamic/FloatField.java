package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FloatField extends NumberField {
    private float data;

    FloatField(float f2, int i2) {
        super(i2);
        this.data = f2;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public Number getNumber() {
        AppMethodBeat.i(109572);
        Float valueOf = Float.valueOf(this.data);
        AppMethodBeat.o(109572);
        return valueOf;
    }

    public void set(float f2) {
        this.data = f2;
    }

    public float get() {
        return this.data;
    }
}
