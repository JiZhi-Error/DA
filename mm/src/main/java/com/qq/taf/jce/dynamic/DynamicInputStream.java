package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;
import com.qq.taf.jce.JceInputStream;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public final class DynamicInputStream {
    private ByteBuffer bs;
    private String sServerEncoding = "GBK";

    public DynamicInputStream(ByteBuffer byteBuffer) {
        this.bs = byteBuffer;
    }

    public DynamicInputStream(byte[] bArr) {
        AppMethodBeat.i(109587);
        this.bs = ByteBuffer.wrap(bArr);
        AppMethodBeat.o(109587);
    }

    public final int setServerEncoding(String str) {
        this.sServerEncoding = str;
        return 0;
    }

    public final JceField read() {
        AppMethodBeat.i(109588);
        try {
            JceInputStream.HeadData headData = new JceInputStream.HeadData();
            JceInputStream.readHead(headData, this.bs);
            switch (headData.type) {
                case 0:
                    JceField create = JceField.create(this.bs.get(), headData.tag);
                    AppMethodBeat.o(109588);
                    return create;
                case 1:
                    JceField create2 = JceField.create(this.bs.getShort(), headData.tag);
                    AppMethodBeat.o(109588);
                    return create2;
                case 2:
                    JceField create3 = JceField.create(this.bs.getInt(), headData.tag);
                    AppMethodBeat.o(109588);
                    return create3;
                case 3:
                    JceField create4 = JceField.create(this.bs.getLong(), headData.tag);
                    AppMethodBeat.o(109588);
                    return create4;
                case 4:
                    JceField create5 = JceField.create(this.bs.getFloat(), headData.tag);
                    AppMethodBeat.o(109588);
                    return create5;
                case 5:
                    JceField create6 = JceField.create(this.bs.getDouble(), headData.tag);
                    AppMethodBeat.o(109588);
                    return create6;
                case 6:
                    int i2 = this.bs.get();
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    JceField readString = readString(headData, i2);
                    AppMethodBeat.o(109588);
                    return readString;
                case 7:
                    JceField readString2 = readString(headData, this.bs.getInt());
                    AppMethodBeat.o(109588);
                    return readString2;
                case 8:
                    int intValue = ((NumberField) read()).intValue();
                    JceField[] jceFieldArr = new JceField[intValue];
                    JceField[] jceFieldArr2 = new JceField[intValue];
                    for (int i3 = 0; i3 < intValue; i3++) {
                        jceFieldArr[i3] = read();
                        jceFieldArr2[i3] = read();
                    }
                    JceField createMap = JceField.createMap(jceFieldArr, jceFieldArr2, headData.tag);
                    AppMethodBeat.o(109588);
                    return createMap;
                case 9:
                    int intValue2 = ((NumberField) read()).intValue();
                    JceField[] jceFieldArr3 = new JceField[intValue2];
                    for (int i4 = 0; i4 < intValue2; i4++) {
                        jceFieldArr3[i4] = read();
                    }
                    JceField createList = JceField.createList(jceFieldArr3, headData.tag);
                    AppMethodBeat.o(109588);
                    return createList;
                case 10:
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        JceField read = read();
                        if (read != null) {
                            arrayList.add(read);
                        } else {
                            JceField createStruct = JceField.createStruct((JceField[]) arrayList.toArray(new JceField[0]), headData.tag);
                            AppMethodBeat.o(109588);
                            return createStruct;
                        }
                    }
                case 11:
                    AppMethodBeat.o(109588);
                    return null;
                case 12:
                    JceField createZero = JceField.createZero(headData.tag);
                    AppMethodBeat.o(109588);
                    return createZero;
                case 13:
                    int i5 = headData.tag;
                    JceInputStream.readHead(headData, this.bs);
                    if (headData.type != 0) {
                        JceDecodeException jceDecodeException = new JceDecodeException("type mismatch, simple_list only support byte, tag: " + i5 + ", type: " + ((int) headData.type));
                        AppMethodBeat.o(109588);
                        throw jceDecodeException;
                    }
                    byte[] bArr = new byte[((NumberField) read()).intValue()];
                    this.bs.get(bArr);
                    JceField create7 = JceField.create(bArr, i5);
                    AppMethodBeat.o(109588);
                    return create7;
                default:
                    AppMethodBeat.o(109588);
                    return null;
            }
        } catch (BufferUnderflowException e2) {
            AppMethodBeat.o(109588);
            return null;
        }
    }

    private JceField readString(JceInputStream.HeadData headData, int i2) {
        String str;
        AppMethodBeat.i(109589);
        byte[] bArr = new byte[i2];
        this.bs.get(bArr);
        try {
            str = new String(bArr, this.sServerEncoding);
        } catch (UnsupportedEncodingException e2) {
            str = new String(bArr);
        }
        JceField create = JceField.create(str, headData.tag);
        AppMethodBeat.o(109589);
        return create;
    }
}
