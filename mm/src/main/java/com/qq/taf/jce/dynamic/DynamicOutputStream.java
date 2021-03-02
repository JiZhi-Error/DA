package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class DynamicOutputStream extends JceOutputStream {
    public DynamicOutputStream(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public DynamicOutputStream(int i2) {
        super(i2);
    }

    public DynamicOutputStream() {
    }

    public final void write(JceField jceField) {
        int i2 = 0;
        AppMethodBeat.i(109573);
        int tag = jceField.getTag();
        if (jceField instanceof ZeroField) {
            write(0, tag);
            AppMethodBeat.o(109573);
        } else if (jceField instanceof IntField) {
            write(((IntField) jceField).get(), tag);
            AppMethodBeat.o(109573);
        } else if (jceField instanceof ShortField) {
            write(((ShortField) jceField).get(), tag);
            AppMethodBeat.o(109573);
        } else if (jceField instanceof ByteField) {
            write(((ByteField) jceField).get(), tag);
            AppMethodBeat.o(109573);
        } else if (jceField instanceof StringField) {
            write(((StringField) jceField).get(), tag);
            AppMethodBeat.o(109573);
        } else if (jceField instanceof ByteArrayField) {
            write(((ByteArrayField) jceField).get(), tag);
            AppMethodBeat.o(109573);
        } else if (jceField instanceof ListField) {
            ListField listField = (ListField) jceField;
            reserve(8);
            writeHead((byte) 9, tag);
            write(listField.size(), 0);
            JceField[] jceFieldArr = listField.get();
            int length = jceFieldArr.length;
            while (i2 < length) {
                write(jceFieldArr[i2]);
                i2++;
            }
            AppMethodBeat.o(109573);
        } else if (jceField instanceof MapField) {
            MapField mapField = (MapField) jceField;
            reserve(8);
            writeHead((byte) 8, tag);
            int size = mapField.size();
            write(size, 0);
            while (i2 < size) {
                write(mapField.getKey(i2));
                write(mapField.getValue(i2));
                i2++;
            }
            AppMethodBeat.o(109573);
        } else if (jceField instanceof StructField) {
            reserve(2);
            writeHead((byte) 10, tag);
            for (JceField jceField2 : ((StructField) jceField).get()) {
                write(jceField2);
            }
            reserve(2);
            writeHead(JceStruct.STRUCT_END, 0);
            AppMethodBeat.o(109573);
        } else if (jceField instanceof LongField) {
            write(((LongField) jceField).get(), tag);
            AppMethodBeat.o(109573);
        } else if (jceField instanceof FloatField) {
            write(((FloatField) jceField).get(), tag);
            AppMethodBeat.o(109573);
        } else if (jceField instanceof DoubleField) {
            write(((DoubleField) jceField).get(), tag);
            AppMethodBeat.o(109573);
        } else {
            JceDecodeException jceDecodeException = new JceDecodeException("unknow JceField type: " + jceField.getClass().getName());
            AppMethodBeat.o(109573);
            throw jceDecodeException;
        }
    }
}
