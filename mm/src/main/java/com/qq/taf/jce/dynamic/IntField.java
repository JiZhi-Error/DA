package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class IntField extends NumberField {
    private int data;

    IntField(int i2, int i3) {
        super(i3);
        this.data = i2;
    }

    public int get() {
        return this.data;
    }

    public void set(int i2) {
        this.data = i2;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public Number getNumber() {
        AppMethodBeat.i(109561);
        Integer valueOf = Integer.valueOf(this.data);
        AppMethodBeat.o(109561);
        return valueOf;
    }
}
