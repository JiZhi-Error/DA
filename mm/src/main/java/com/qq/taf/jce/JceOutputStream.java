package com.qq.taf.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class JceOutputStream {
    private ByteBuffer bs;
    protected String sServerEncoding;

    public JceOutputStream(ByteBuffer byteBuffer) {
        this.sServerEncoding = "GBK";
        this.bs = byteBuffer;
    }

    public JceOutputStream(int i2) {
        AppMethodBeat.i(109661);
        this.sServerEncoding = "GBK";
        this.bs = ByteBuffer.allocate(i2);
        AppMethodBeat.o(109661);
    }

    public JceOutputStream() {
        this(128);
    }

    public ByteBuffer getByteBuffer() {
        return this.bs;
    }

    public byte[] toByteArray() {
        AppMethodBeat.i(109662);
        byte[] bArr = new byte[this.bs.position()];
        System.arraycopy(this.bs.array(), 0, bArr, 0, this.bs.position());
        AppMethodBeat.o(109662);
        return bArr;
    }

    public void reserve(int i2) {
        AppMethodBeat.i(109663);
        if (this.bs.remaining() < i2) {
            ByteBuffer allocate = ByteBuffer.allocate((this.bs.capacity() + i2) * 2);
            allocate.put(this.bs.array(), 0, this.bs.position());
            this.bs = allocate;
        }
        AppMethodBeat.o(109663);
    }

    public void writeHead(byte b2, int i2) {
        AppMethodBeat.i(109664);
        if (i2 < 15) {
            this.bs.put((byte) ((i2 << 4) | b2));
            AppMethodBeat.o(109664);
        } else if (i2 < 256) {
            this.bs.put((byte) (b2 | 240));
            this.bs.put((byte) i2);
            AppMethodBeat.o(109664);
        } else {
            JceEncodeException jceEncodeException = new JceEncodeException("tag is too large: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(109664);
            throw jceEncodeException;
        }
    }

    public void write(boolean z, int i2) {
        AppMethodBeat.i(109665);
        write((byte) (z ? 1 : 0), i2);
        AppMethodBeat.o(109665);
    }

    public void write(byte b2, int i2) {
        AppMethodBeat.i(109666);
        reserve(3);
        if (b2 == 0) {
            writeHead(JceStruct.ZERO_TAG, i2);
            AppMethodBeat.o(109666);
            return;
        }
        writeHead((byte) 0, i2);
        this.bs.put(b2);
        AppMethodBeat.o(109666);
    }

    public void write(short s, int i2) {
        AppMethodBeat.i(109667);
        reserve(4);
        if (s < -128 || s > 127) {
            writeHead((byte) 1, i2);
            this.bs.putShort(s);
            AppMethodBeat.o(109667);
            return;
        }
        write((byte) s, i2);
        AppMethodBeat.o(109667);
    }

    public void write(int i2, int i3) {
        AppMethodBeat.i(109668);
        reserve(6);
        if (i2 < -32768 || i2 > 32767) {
            writeHead((byte) 2, i3);
            this.bs.putInt(i2);
            AppMethodBeat.o(109668);
            return;
        }
        write((short) i2, i3);
        AppMethodBeat.o(109668);
    }

    public void write(long j2, int i2) {
        AppMethodBeat.i(109669);
        reserve(10);
        if (j2 < -2147483648L || j2 > 2147483647L) {
            writeHead((byte) 3, i2);
            this.bs.putLong(j2);
            AppMethodBeat.o(109669);
            return;
        }
        write((int) j2, i2);
        AppMethodBeat.o(109669);
    }

    public void write(float f2, int i2) {
        AppMethodBeat.i(109670);
        reserve(6);
        writeHead((byte) 4, i2);
        this.bs.putFloat(f2);
        AppMethodBeat.o(109670);
    }

    public void write(double d2, int i2) {
        AppMethodBeat.i(109671);
        reserve(10);
        writeHead((byte) 5, i2);
        this.bs.putDouble(d2);
        AppMethodBeat.o(109671);
    }

    public void writeStringByte(String str, int i2) {
        AppMethodBeat.i(109672);
        byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(str);
        reserve(hexStr2Bytes.length + 10);
        if (hexStr2Bytes.length > 255) {
            writeHead((byte) 7, i2);
            this.bs.putInt(hexStr2Bytes.length);
            this.bs.put(hexStr2Bytes);
            AppMethodBeat.o(109672);
            return;
        }
        writeHead((byte) 6, i2);
        this.bs.put((byte) hexStr2Bytes.length);
        this.bs.put(hexStr2Bytes);
        AppMethodBeat.o(109672);
    }

    public void writeByteString(String str, int i2) {
        AppMethodBeat.i(109673);
        reserve(str.length() + 10);
        byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(str);
        if (hexStr2Bytes.length > 255) {
            writeHead((byte) 7, i2);
            this.bs.putInt(hexStr2Bytes.length);
            this.bs.put(hexStr2Bytes);
            AppMethodBeat.o(109673);
            return;
        }
        writeHead((byte) 6, i2);
        this.bs.put((byte) hexStr2Bytes.length);
        this.bs.put(hexStr2Bytes);
        AppMethodBeat.o(109673);
    }

    public void write(String str, int i2) {
        byte[] bytes;
        AppMethodBeat.i(109674);
        try {
            bytes = str.getBytes(this.sServerEncoding);
        } catch (UnsupportedEncodingException e2) {
            bytes = str.getBytes();
        }
        reserve(bytes.length + 10);
        if (bytes.length > 255) {
            writeHead((byte) 7, i2);
            this.bs.putInt(bytes.length);
            this.bs.put(bytes);
            AppMethodBeat.o(109674);
            return;
        }
        writeHead((byte) 6, i2);
        this.bs.put((byte) bytes.length);
        this.bs.put(bytes);
        AppMethodBeat.o(109674);
    }

    public <K, V> void write(Map<K, V> map, int i2) {
        AppMethodBeat.i(109675);
        reserve(8);
        writeHead((byte) 8, i2);
        write(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                write((Object) entry.getKey(), 0);
                write((Object) entry.getValue(), 1);
            }
        }
        AppMethodBeat.o(109675);
    }

    public void write(boolean[] zArr, int i2) {
        AppMethodBeat.i(109676);
        reserve(8);
        writeHead((byte) 9, i2);
        write(zArr.length, 0);
        for (boolean z : zArr) {
            write(z, 0);
        }
        AppMethodBeat.o(109676);
    }

    public void write(byte[] bArr, int i2) {
        AppMethodBeat.i(109677);
        reserve(bArr.length + 8);
        writeHead(JceStruct.SIMPLE_LIST, i2);
        writeHead((byte) 0, 0);
        write(bArr.length, 0);
        this.bs.put(bArr);
        AppMethodBeat.o(109677);
    }

    public void write(short[] sArr, int i2) {
        AppMethodBeat.i(109678);
        reserve(8);
        writeHead((byte) 9, i2);
        write(sArr.length, 0);
        for (short s : sArr) {
            write(s, 0);
        }
        AppMethodBeat.o(109678);
    }

    public void write(int[] iArr, int i2) {
        AppMethodBeat.i(109679);
        reserve(8);
        writeHead((byte) 9, i2);
        write(iArr.length, 0);
        for (int i3 : iArr) {
            write(i3, 0);
        }
        AppMethodBeat.o(109679);
    }

    public void write(long[] jArr, int i2) {
        AppMethodBeat.i(109680);
        reserve(8);
        writeHead((byte) 9, i2);
        write(jArr.length, 0);
        for (long j2 : jArr) {
            write(j2, 0);
        }
        AppMethodBeat.o(109680);
    }

    public void write(float[] fArr, int i2) {
        AppMethodBeat.i(109681);
        reserve(8);
        writeHead((byte) 9, i2);
        write(fArr.length, 0);
        for (float f2 : fArr) {
            write(f2, 0);
        }
        AppMethodBeat.o(109681);
    }

    public void write(double[] dArr, int i2) {
        AppMethodBeat.i(109682);
        reserve(8);
        writeHead((byte) 9, i2);
        write(dArr.length, 0);
        for (double d2 : dArr) {
            write(d2, 0);
        }
        AppMethodBeat.o(109682);
    }

    public <T> void write(T[] tArr, int i2) {
        AppMethodBeat.i(109683);
        writeArray(tArr, i2);
        AppMethodBeat.o(109683);
    }

    private void writeArray(Object[] objArr, int i2) {
        AppMethodBeat.i(109684);
        reserve(8);
        writeHead((byte) 9, i2);
        write(objArr.length, 0);
        for (Object obj : objArr) {
            write(obj, 0);
        }
        AppMethodBeat.o(109684);
    }

    public <T> void write(Collection<T> collection, int i2) {
        AppMethodBeat.i(109685);
        reserve(8);
        writeHead((byte) 9, i2);
        write(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T t : collection) {
                write((Object) t, 0);
            }
        }
        AppMethodBeat.o(109685);
    }

    public void write(JceStruct jceStruct, int i2) {
        AppMethodBeat.i(109686);
        reserve(2);
        writeHead((byte) 10, i2);
        jceStruct.writeTo(this);
        reserve(2);
        writeHead(JceStruct.STRUCT_END, 0);
        AppMethodBeat.o(109686);
    }

    public void write(Byte b2, int i2) {
        AppMethodBeat.i(109687);
        write(b2.byteValue(), i2);
        AppMethodBeat.o(109687);
    }

    public void write(Boolean bool, int i2) {
        AppMethodBeat.i(109688);
        write(bool.booleanValue(), i2);
        AppMethodBeat.o(109688);
    }

    public void write(Short sh, int i2) {
        AppMethodBeat.i(109689);
        write(sh.shortValue(), i2);
        AppMethodBeat.o(109689);
    }

    public void write(Integer num, int i2) {
        AppMethodBeat.i(109690);
        write(num.intValue(), i2);
        AppMethodBeat.o(109690);
    }

    public void write(Long l, int i2) {
        AppMethodBeat.i(109691);
        write(l.longValue(), i2);
        AppMethodBeat.o(109691);
    }

    public void write(Float f2, int i2) {
        AppMethodBeat.i(109692);
        write(f2.floatValue(), i2);
        AppMethodBeat.o(109692);
    }

    public void write(Double d2, int i2) {
        AppMethodBeat.i(109693);
        write(d2.doubleValue(), i2);
        AppMethodBeat.o(109693);
    }

    public void write(Object obj, int i2) {
        AppMethodBeat.i(109694);
        if (obj instanceof Byte) {
            write(((Byte) obj).byteValue(), i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof Boolean) {
            write(((Boolean) obj).booleanValue(), i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof Short) {
            write(((Short) obj).shortValue(), i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof Integer) {
            write(((Integer) obj).intValue(), i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof Long) {
            write(((Long) obj).longValue(), i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof Float) {
            write(((Float) obj).floatValue(), i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof Double) {
            write(((Double) obj).doubleValue(), i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof String) {
            write((String) obj, i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof Map) {
            write((Map) obj, i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof List) {
            write((Collection) ((List) obj), i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof JceStruct) {
            write((JceStruct) obj, i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof byte[]) {
            write((byte[]) obj, i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof boolean[]) {
            write((boolean[]) obj, i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof short[]) {
            write((short[]) obj, i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof int[]) {
            write((int[]) obj, i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof long[]) {
            write((long[]) obj, i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof float[]) {
            write((float[]) obj, i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof double[]) {
            write((double[]) obj, i2);
            AppMethodBeat.o(109694);
        } else if (obj.getClass().isArray()) {
            writeArray((Object[]) obj, i2);
            AppMethodBeat.o(109694);
        } else if (obj instanceof Collection) {
            write((Collection) obj, i2);
            AppMethodBeat.o(109694);
        } else {
            JceEncodeException jceEncodeException = new JceEncodeException("write object error: unsupport type. " + obj.getClass());
            AppMethodBeat.o(109694);
            throw jceEncodeException;
        }
    }

    public int setServerEncoding(String str) {
        this.sServerEncoding = str;
        return 0;
    }

    public static void main(String[] strArr) {
        AppMethodBeat.i(109695);
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.write(1311768467283714885L, 0);
        System.out.println(HexUtil.bytes2HexStr(jceOutputStream.getByteBuffer().array()));
        System.out.println(Arrays.toString(jceOutputStream.toByteArray()));
        AppMethodBeat.o(109695);
    }
}
