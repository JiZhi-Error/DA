package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DoubleField extends NumberField {
    private double data;

    DoubleField(double d2, int i2) {
        super(i2);
        this.data = d2;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public Number getNumber() {
        AppMethodBeat.i(109570);
        Double valueOf = Double.valueOf(this.data);
        AppMethodBeat.o(109570);
        return valueOf;
    }

    public double get() {
        return this.data;
    }

    public void set(double d2) {
        this.data = d2;
    }
}
