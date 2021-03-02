package com.qq.taf.jce.dynamic;

public final class ListField extends JceField {
    private JceField[] data;

    ListField(JceField[] jceFieldArr, int i2) {
        super(i2);
        this.data = jceFieldArr;
    }

    public final JceField[] get() {
        return this.data;
    }

    public final JceField get(int i2) {
        return this.data[i2];
    }

    public final void set(int i2, JceField jceField) {
        this.data[i2] = jceField;
    }

    public final void set(JceField[] jceFieldArr) {
        this.data = jceFieldArr;
    }

    public final int size() {
        return this.data.length;
    }
}
