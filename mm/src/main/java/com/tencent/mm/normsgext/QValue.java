package com.tencent.mm.normsgext;

public final class QValue<TValue> {
    public TValue value;

    public final TValue getValue(TValue tvalue) {
        return this.value != null ? this.value : tvalue;
    }
}
