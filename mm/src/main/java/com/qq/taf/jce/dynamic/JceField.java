package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class JceField {
    private static ZeroField[] zs = new ZeroField[256];
    private int tag;

    JceField(int i2) {
        this.tag = i2;
    }

    public int getTag() {
        return this.tag;
    }

    public static JceField create(byte b2, int i2) {
        AppMethodBeat.i(109575);
        ByteField byteField = new ByteField(b2, i2);
        AppMethodBeat.o(109575);
        return byteField;
    }

    public static JceField create(short s, int i2) {
        AppMethodBeat.i(109576);
        ShortField shortField = new ShortField(s, i2);
        AppMethodBeat.o(109576);
        return shortField;
    }

    public static JceField create(int i2, int i3) {
        AppMethodBeat.i(109577);
        IntField intField = new IntField(i2, i3);
        AppMethodBeat.o(109577);
        return intField;
    }

    public static JceField create(long j2, int i2) {
        AppMethodBeat.i(109578);
        LongField longField = new LongField(j2, i2);
        AppMethodBeat.o(109578);
        return longField;
    }

    public static JceField create(float f2, int i2) {
        AppMethodBeat.i(109579);
        FloatField floatField = new FloatField(f2, i2);
        AppMethodBeat.o(109579);
        return floatField;
    }

    public static JceField create(double d2, int i2) {
        AppMethodBeat.i(109580);
        DoubleField doubleField = new DoubleField(d2, i2);
        AppMethodBeat.o(109580);
        return doubleField;
    }

    public static JceField create(String str, int i2) {
        AppMethodBeat.i(109581);
        StringField stringField = new StringField(str, i2);
        AppMethodBeat.o(109581);
        return stringField;
    }

    public static JceField create(byte[] bArr, int i2) {
        AppMethodBeat.i(109582);
        ByteArrayField byteArrayField = new ByteArrayField(bArr, i2);
        AppMethodBeat.o(109582);
        return byteArrayField;
    }

    public static JceField createList(JceField[] jceFieldArr, int i2) {
        AppMethodBeat.i(109583);
        ListField listField = new ListField(jceFieldArr, i2);
        AppMethodBeat.o(109583);
        return listField;
    }

    public static JceField createMap(JceField[] jceFieldArr, JceField[] jceFieldArr2, int i2) {
        AppMethodBeat.i(109584);
        MapField mapField = new MapField(jceFieldArr, jceFieldArr2, i2);
        AppMethodBeat.o(109584);
        return mapField;
    }

    public static JceField createStruct(JceField[] jceFieldArr, int i2) {
        AppMethodBeat.i(109585);
        StructField structField = new StructField(jceFieldArr, i2);
        AppMethodBeat.o(109585);
        return structField;
    }

    static {
        AppMethodBeat.i(109574);
        for (int i2 = 0; i2 < zs.length; i2++) {
            zs[i2] = new ZeroField(i2);
        }
        AppMethodBeat.o(109574);
    }

    public static JceField createZero(int i2) {
        AppMethodBeat.i(109586);
        if (i2 < 0 || i2 >= 255) {
            JceDecodeException jceDecodeException = new JceDecodeException("invalid tag: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(109586);
            throw jceDecodeException;
        }
        ZeroField zeroField = zs[i2];
        AppMethodBeat.o(109586);
        return zeroField;
    }
}
