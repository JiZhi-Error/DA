package com.qq.taf.jce.dynamic;

public class ByteArrayField extends JceField {
    private byte[] data;

    ByteArrayField(byte[] bArr, int i2) {
        super(i2);
        this.data = bArr;
    }

    public byte[] get() {
        return this.data;
    }

    public void set(byte[] bArr) {
        this.data = bArr;
    }
}
