package com.qq.taf.jce.dynamic;

public final class MapField extends JceField {
    private JceField[] keys;
    private JceField[] values;

    MapField(JceField[] jceFieldArr, JceField[] jceFieldArr2, int i2) {
        super(i2);
        this.keys = jceFieldArr;
        this.values = jceFieldArr2;
    }

    public final JceField[] getKeys() {
        return this.keys;
    }

    public final JceField[] getValues() {
        return this.values;
    }

    public final int size() {
        return this.keys.length;
    }

    public final JceField getKey(int i2) {
        return this.keys[i2];
    }

    public final JceField getValue(int i2) {
        return this.values[i2];
    }

    public final void setKey(int i2, JceField jceField) {
        this.keys[i2] = jceField;
    }

    public final void setValue(int i2, JceField jceField) {
        this.values[i2] = jceField;
    }
}
