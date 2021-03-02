package com.qq.taf.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class JceInputStream {
    private ByteBuffer bs;
    protected String sServerEncoding = "GBK";

    public static class HeadData {
        public int tag;
        public byte type;

        public void clear() {
            this.type = 0;
            this.tag = 0;
        }
    }

    public JceInputStream() {
    }

    public JceInputStream(ByteBuffer byteBuffer) {
        this.bs = byteBuffer;
    }

    public JceInputStream(byte[] bArr) {
        AppMethodBeat.i(109696);
        this.bs = ByteBuffer.wrap(bArr);
        AppMethodBeat.o(109696);
    }

    public JceInputStream(byte[] bArr, int i2) {
        AppMethodBeat.i(109697);
        this.bs = ByteBuffer.wrap(bArr);
        this.bs.position(i2);
        AppMethodBeat.o(109697);
    }

    public final void warp(byte[] bArr) {
        AppMethodBeat.i(109698);
        wrap(bArr);
        AppMethodBeat.o(109698);
    }

    public final void wrap(byte[] bArr) {
        AppMethodBeat.i(109699);
        this.bs = ByteBuffer.wrap(bArr);
        AppMethodBeat.o(109699);
    }

    public static int readHead(HeadData headData, ByteBuffer byteBuffer) {
        AppMethodBeat.i(109700);
        byte b2 = byteBuffer.get();
        headData.type = (byte) (b2 & 15);
        headData.tag = (b2 & 240) >> 4;
        if (headData.tag == 15) {
            headData.tag = byteBuffer.get() & 255;
            AppMethodBeat.o(109700);
            return 2;
        }
        AppMethodBeat.o(109700);
        return 1;
    }

    public final void readHead(HeadData headData) {
        AppMethodBeat.i(109701);
        readHead(headData, this.bs);
        AppMethodBeat.o(109701);
    }

    private int peakHead(HeadData headData) {
        AppMethodBeat.i(109702);
        int readHead = readHead(headData, this.bs.duplicate());
        AppMethodBeat.o(109702);
        return readHead;
    }

    private void skip(int i2) {
        AppMethodBeat.i(109703);
        this.bs.position(this.bs.position() + i2);
        AppMethodBeat.o(109703);
    }

    public final boolean skipToTag(int i2) {
        AppMethodBeat.i(109704);
        try {
            HeadData headData = new HeadData();
            while (true) {
                int peakHead = peakHead(headData);
                if (i2 > headData.tag && headData.type != 11) {
                    skip(peakHead);
                    skipField(headData.type);
                }
            }
            if (i2 == headData.tag) {
                AppMethodBeat.o(109704);
                return true;
            }
            AppMethodBeat.o(109704);
            return false;
        } catch (JceDecodeException | BufferUnderflowException e2) {
            AppMethodBeat.o(109704);
            return false;
        }
    }

    public final void skipToStructEnd() {
        AppMethodBeat.i(109705);
        HeadData headData = new HeadData();
        do {
            readHead(headData);
            skipField(headData.type);
        } while (headData.type != 11);
        AppMethodBeat.o(109705);
    }

    private void skipField() {
        AppMethodBeat.i(109706);
        HeadData headData = new HeadData();
        readHead(headData);
        skipField(headData.type);
        AppMethodBeat.o(109706);
    }

    private void skipField(byte b2) {
        int i2 = 0;
        AppMethodBeat.i(109707);
        switch (b2) {
            case 0:
                skip(1);
                AppMethodBeat.o(109707);
                return;
            case 1:
                skip(2);
                AppMethodBeat.o(109707);
                return;
            case 2:
                skip(4);
                AppMethodBeat.o(109707);
                return;
            case 3:
                skip(8);
                AppMethodBeat.o(109707);
                return;
            case 4:
                skip(4);
                AppMethodBeat.o(109707);
                return;
            case 5:
                skip(8);
                AppMethodBeat.o(109707);
                return;
            case 6:
                int i3 = this.bs.get();
                if (i3 < 0) {
                    i3 += 256;
                }
                skip(i3);
                AppMethodBeat.o(109707);
                return;
            case 7:
                skip(this.bs.getInt());
                AppMethodBeat.o(109707);
                return;
            case 8:
                int read = read(0, 0, true);
                while (i2 < read * 2) {
                    skipField();
                    i2++;
                }
                AppMethodBeat.o(109707);
                return;
            case 9:
                int read2 = read(0, 0, true);
                while (i2 < read2) {
                    skipField();
                    i2++;
                }
                AppMethodBeat.o(109707);
                return;
            case 10:
                skipToStructEnd();
                AppMethodBeat.o(109707);
                return;
            case 11:
            case 12:
                AppMethodBeat.o(109707);
                return;
            case 13:
                HeadData headData = new HeadData();
                readHead(headData);
                if (headData.type != 0) {
                    JceDecodeException jceDecodeException = new JceDecodeException("skipField with invalid type, type value: " + ((int) b2) + ", " + ((int) headData.type));
                    AppMethodBeat.o(109707);
                    throw jceDecodeException;
                }
                skip(read(0, 0, true));
                AppMethodBeat.o(109707);
                return;
            default:
                JceDecodeException jceDecodeException2 = new JceDecodeException("invalid type.");
                AppMethodBeat.o(109707);
                throw jceDecodeException2;
        }
    }

    public final boolean read(boolean z, int i2, boolean z2) {
        AppMethodBeat.i(109708);
        if (read((byte) 0, i2, z2) != 0) {
            AppMethodBeat.o(109708);
            return true;
        }
        AppMethodBeat.o(109708);
        return false;
    }

    public final byte read(byte b2, int i2, boolean z) {
        AppMethodBeat.i(109709);
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case 0:
                    b2 = this.bs.get();
                    break;
                case 12:
                    b2 = 0;
                    break;
                default:
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109709);
                    throw jceDecodeException;
            }
        } else if (z) {
            JceDecodeException jceDecodeException2 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109709);
            throw jceDecodeException2;
        }
        AppMethodBeat.o(109709);
        return b2;
    }

    public final short read(short s, int i2, boolean z) {
        AppMethodBeat.i(109710);
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case 0:
                    s = (short) this.bs.get();
                    break;
                case 1:
                    s = this.bs.getShort();
                    break;
                case 12:
                    s = 0;
                    break;
                default:
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109710);
                    throw jceDecodeException;
            }
        } else if (z) {
            JceDecodeException jceDecodeException2 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109710);
            throw jceDecodeException2;
        }
        AppMethodBeat.o(109710);
        return s;
    }

    public final int read(int i2, int i3, boolean z) {
        AppMethodBeat.i(109711);
        if (skipToTag(i3)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case 0:
                    i2 = this.bs.get();
                    break;
                case 1:
                    i2 = this.bs.getShort();
                    break;
                case 2:
                    i2 = this.bs.getInt();
                    break;
                case 12:
                    i2 = 0;
                    break;
                default:
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109711);
                    throw jceDecodeException;
            }
        } else if (z) {
            JceDecodeException jceDecodeException2 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109711);
            throw jceDecodeException2;
        }
        AppMethodBeat.o(109711);
        return i2;
    }

    public final long read(long j2, int i2, boolean z) {
        AppMethodBeat.i(109712);
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case 0:
                    j2 = (long) this.bs.get();
                    break;
                case 1:
                    j2 = (long) this.bs.getShort();
                    break;
                case 2:
                    j2 = (long) this.bs.getInt();
                    break;
                case 3:
                    j2 = this.bs.getLong();
                    break;
                case 12:
                    j2 = 0;
                    break;
                default:
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109712);
                    throw jceDecodeException;
            }
        } else if (z) {
            JceDecodeException jceDecodeException2 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109712);
            throw jceDecodeException2;
        }
        AppMethodBeat.o(109712);
        return j2;
    }

    public final float read(float f2, int i2, boolean z) {
        AppMethodBeat.i(109713);
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case 4:
                    f2 = this.bs.getFloat();
                    break;
                case 12:
                    f2 = 0.0f;
                    break;
                default:
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109713);
                    throw jceDecodeException;
            }
        } else if (z) {
            JceDecodeException jceDecodeException2 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109713);
            throw jceDecodeException2;
        }
        AppMethodBeat.o(109713);
        return f2;
    }

    public final double read(double d2, int i2, boolean z) {
        AppMethodBeat.i(109714);
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case 4:
                    d2 = (double) this.bs.getFloat();
                    break;
                case 5:
                    d2 = this.bs.getDouble();
                    break;
                case 12:
                    d2 = 0.0d;
                    break;
                default:
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109714);
                    throw jceDecodeException;
            }
        } else if (z) {
            JceDecodeException jceDecodeException2 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109714);
            throw jceDecodeException2;
        }
        AppMethodBeat.o(109714);
        return d2;
    }

    public final String readByteString(String str, int i2, boolean z) {
        AppMethodBeat.i(109715);
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case 6:
                    int i3 = this.bs.get();
                    if (i3 < 0) {
                        i3 += 256;
                    }
                    byte[] bArr = new byte[i3];
                    this.bs.get(bArr);
                    str = HexUtil.bytes2HexStr(bArr);
                    break;
                case 7:
                    int i4 = this.bs.getInt();
                    if (i4 <= 104857600 && i4 >= 0) {
                        byte[] bArr2 = new byte[i4];
                        this.bs.get(bArr2);
                        str = HexUtil.bytes2HexStr(bArr2);
                        break;
                    } else {
                        JceDecodeException jceDecodeException = new JceDecodeException("String too long: ".concat(String.valueOf(i4)));
                        AppMethodBeat.o(109715);
                        throw jceDecodeException;
                    }
                default:
                    JceDecodeException jceDecodeException2 = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109715);
                    throw jceDecodeException2;
            }
        } else if (z) {
            JceDecodeException jceDecodeException3 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109715);
            throw jceDecodeException3;
        }
        AppMethodBeat.o(109715);
        return str;
    }

    public final String read(String str, int i2, boolean z) {
        AppMethodBeat.i(109716);
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case 6:
                    int i3 = this.bs.get();
                    if (i3 < 0) {
                        i3 += 256;
                    }
                    byte[] bArr = new byte[i3];
                    this.bs.get(bArr);
                    try {
                        str = new String(bArr, this.sServerEncoding);
                        break;
                    } catch (UnsupportedEncodingException e2) {
                        str = new String(bArr);
                        break;
                    }
                case 7:
                    int i4 = this.bs.getInt();
                    if (i4 <= 104857600 && i4 >= 0) {
                        byte[] bArr2 = new byte[i4];
                        this.bs.get(bArr2);
                        try {
                            str = new String(bArr2, this.sServerEncoding);
                            break;
                        } catch (UnsupportedEncodingException e3) {
                            str = new String(bArr2);
                            break;
                        }
                    } else {
                        JceDecodeException jceDecodeException = new JceDecodeException("String too long: ".concat(String.valueOf(i4)));
                        AppMethodBeat.o(109716);
                        throw jceDecodeException;
                    }
                default:
                    JceDecodeException jceDecodeException2 = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109716);
                    throw jceDecodeException2;
            }
        } else if (z) {
            JceDecodeException jceDecodeException3 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109716);
            throw jceDecodeException3;
        }
        AppMethodBeat.o(109716);
        return str;
    }

    public final String readString(int i2, boolean z) {
        AppMethodBeat.i(109717);
        String str = null;
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case 6:
                    int i3 = this.bs.get();
                    if (i3 < 0) {
                        i3 += 256;
                    }
                    byte[] bArr = new byte[i3];
                    this.bs.get(bArr);
                    try {
                        str = new String(bArr, this.sServerEncoding);
                        break;
                    } catch (UnsupportedEncodingException e2) {
                        str = new String(bArr);
                        break;
                    }
                case 7:
                    int i4 = this.bs.getInt();
                    if (i4 <= 104857600 && i4 >= 0) {
                        byte[] bArr2 = new byte[i4];
                        this.bs.get(bArr2);
                        try {
                            str = new String(bArr2, this.sServerEncoding);
                            break;
                        } catch (UnsupportedEncodingException e3) {
                            str = new String(bArr2);
                            break;
                        }
                    } else {
                        JceDecodeException jceDecodeException = new JceDecodeException("String too long: ".concat(String.valueOf(i4)));
                        AppMethodBeat.o(109717);
                        throw jceDecodeException;
                    }
                default:
                    JceDecodeException jceDecodeException2 = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109717);
                    throw jceDecodeException2;
            }
        } else if (z) {
            JceDecodeException jceDecodeException3 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109717);
            throw jceDecodeException3;
        }
        AppMethodBeat.o(109717);
        return str;
    }

    public final String[] read(String[] strArr, int i2, boolean z) {
        AppMethodBeat.i(109718);
        String[] strArr2 = (String[]) readArray(strArr, i2, z);
        AppMethodBeat.o(109718);
        return strArr2;
    }

    public final Map<String, String> readStringMap(int i2, boolean z) {
        AppMethodBeat.i(109719);
        HashMap hashMap = new HashMap();
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                default:
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109719);
                    throw jceDecodeException;
                case 8:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        for (int i3 = 0; i3 < read; i3++) {
                            hashMap.put(readString(0, true), readString(1, true));
                        }
                        break;
                    } else {
                        JceDecodeException jceDecodeException2 = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                        AppMethodBeat.o(109719);
                        throw jceDecodeException2;
                    }
            }
        } else if (z) {
            JceDecodeException jceDecodeException3 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109719);
            throw jceDecodeException3;
        }
        AppMethodBeat.o(109719);
        return hashMap;
    }

    public final <K, V> HashMap<K, V> readMap(Map<K, V> map, int i2, boolean z) {
        AppMethodBeat.i(109720);
        HashMap<K, V> hashMap = (HashMap) readMap(new HashMap(), map, i2, z);
        AppMethodBeat.o(109720);
        return hashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> readMap(Map<K, V> map, Map<K, V> map2, int i2, boolean z) {
        AppMethodBeat.i(109721);
        if (map2 == null || map2.isEmpty()) {
            HashMap hashMap = new HashMap();
            AppMethodBeat.o(109721);
            return hashMap;
        }
        Map.Entry<K, V> next = map2.entrySet().iterator().next();
        K key = next.getKey();
        V value = next.getValue();
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                default:
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109721);
                    throw jceDecodeException;
                case 8:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        for (int i3 = 0; i3 < read; i3++) {
                            map.put(read((Object) key, 0, true), read((Object) value, 1, true));
                        }
                        break;
                    } else {
                        JceDecodeException jceDecodeException2 = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                        AppMethodBeat.o(109721);
                        throw jceDecodeException2;
                    }
            }
        } else if (z) {
            JceDecodeException jceDecodeException3 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109721);
            throw jceDecodeException3;
        }
        AppMethodBeat.o(109721);
        return map;
    }

    public final List readList(int i2, boolean z) {
        AppMethodBeat.i(109722);
        ArrayList arrayList = new ArrayList();
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                default:
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109722);
                    throw jceDecodeException;
                case 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        for (int i3 = 0; i3 < read; i3++) {
                            HeadData headData2 = new HeadData();
                            readHead(headData2);
                            switch (headData2.type) {
                                case 0:
                                    skip(1);
                                    break;
                                case 1:
                                    skip(2);
                                    break;
                                case 2:
                                    skip(4);
                                    break;
                                case 3:
                                    skip(8);
                                    break;
                                case 4:
                                    skip(4);
                                    break;
                                case 5:
                                    skip(8);
                                    break;
                                case 6:
                                    int i4 = this.bs.get();
                                    if (i4 < 0) {
                                        i4 += 256;
                                    }
                                    skip(i4);
                                    break;
                                case 7:
                                    skip(this.bs.getInt());
                                    break;
                                case 8:
                                case 9:
                                    break;
                                case 10:
                                    try {
                                        JceStruct jceStruct = (JceStruct) Class.forName(JceStruct.class.getName()).getConstructor(new Class[0]).newInstance(new Object[0]);
                                        jceStruct.readFrom(this);
                                        skipToStructEnd();
                                        arrayList.add(jceStruct);
                                        break;
                                    } catch (Exception e2) {
                                        JceDecodeException jceDecodeException2 = new JceDecodeException("type mismatch.".concat(String.valueOf(e2)));
                                        AppMethodBeat.o(109722);
                                        throw jceDecodeException2;
                                    }
                                case 11:
                                default:
                                    JceDecodeException jceDecodeException3 = new JceDecodeException("type mismatch.");
                                    AppMethodBeat.o(109722);
                                    throw jceDecodeException3;
                                case 12:
                                    arrayList.add(0);
                                    break;
                            }
                        }
                        break;
                    } else {
                        JceDecodeException jceDecodeException4 = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                        AppMethodBeat.o(109722);
                        throw jceDecodeException4;
                    }
            }
        } else if (z) {
            JceDecodeException jceDecodeException5 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109722);
            throw jceDecodeException5;
        }
        AppMethodBeat.o(109722);
        return arrayList;
    }

    public final boolean[] read(boolean[] zArr, int i2, boolean z) {
        AppMethodBeat.i(109723);
        boolean[] zArr2 = null;
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                default:
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109723);
                    throw jceDecodeException;
                case 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        zArr2 = new boolean[read];
                        for (int i3 = 0; i3 < read; i3++) {
                            zArr2[i3] = read(zArr2[0], 0, true);
                        }
                        break;
                    } else {
                        JceDecodeException jceDecodeException2 = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                        AppMethodBeat.o(109723);
                        throw jceDecodeException2;
                    }
            }
        } else if (z) {
            JceDecodeException jceDecodeException3 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109723);
            throw jceDecodeException3;
        }
        AppMethodBeat.o(109723);
        return zArr2;
    }

    public final byte[] read(byte[] bArr, int i2, boolean z) {
        AppMethodBeat.i(109724);
        byte[] bArr2 = null;
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        bArr2 = new byte[read];
                        for (int i3 = 0; i3 < read; i3++) {
                            bArr2[i3] = read(bArr2[0], 0, true);
                        }
                        break;
                    } else {
                        JceDecodeException jceDecodeException = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                        AppMethodBeat.o(109724);
                        throw jceDecodeException;
                    }
                case 13:
                    HeadData headData2 = new HeadData();
                    readHead(headData2);
                    if (headData2.type == 0) {
                        int read2 = read(0, 0, true);
                        if (read2 >= 0) {
                            bArr2 = new byte[read2];
                            this.bs.get(bArr2);
                            break;
                        } else {
                            JceDecodeException jceDecodeException2 = new JceDecodeException("invalid size, tag: " + i2 + ", type: " + ((int) headData.type) + ", " + ((int) headData2.type) + ", size: " + read2);
                            AppMethodBeat.o(109724);
                            throw jceDecodeException2;
                        }
                    } else {
                        JceDecodeException jceDecodeException3 = new JceDecodeException("type mismatch, tag: " + i2 + ", type: " + ((int) headData.type) + ", " + ((int) headData2.type));
                        AppMethodBeat.o(109724);
                        throw jceDecodeException3;
                    }
                default:
                    JceDecodeException jceDecodeException4 = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109724);
                    throw jceDecodeException4;
            }
        } else if (z) {
            JceDecodeException jceDecodeException5 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109724);
            throw jceDecodeException5;
        }
        AppMethodBeat.o(109724);
        return bArr2;
    }

    public final short[] read(short[] sArr, int i2, boolean z) {
        AppMethodBeat.i(109725);
        short[] sArr2 = null;
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                default:
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109725);
                    throw jceDecodeException;
                case 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        sArr2 = new short[read];
                        for (int i3 = 0; i3 < read; i3++) {
                            sArr2[i3] = read(sArr2[0], 0, true);
                        }
                        break;
                    } else {
                        JceDecodeException jceDecodeException2 = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                        AppMethodBeat.o(109725);
                        throw jceDecodeException2;
                    }
            }
        } else if (z) {
            JceDecodeException jceDecodeException3 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109725);
            throw jceDecodeException3;
        }
        AppMethodBeat.o(109725);
        return sArr2;
    }

    public final int[] read(int[] iArr, int i2, boolean z) {
        AppMethodBeat.i(109726);
        int[] iArr2 = null;
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                default:
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109726);
                    throw jceDecodeException;
                case 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        iArr2 = new int[read];
                        for (int i3 = 0; i3 < read; i3++) {
                            iArr2[i3] = read(iArr2[0], 0, true);
                        }
                        break;
                    } else {
                        JceDecodeException jceDecodeException2 = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                        AppMethodBeat.o(109726);
                        throw jceDecodeException2;
                    }
            }
        } else if (z) {
            JceDecodeException jceDecodeException3 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109726);
            throw jceDecodeException3;
        }
        AppMethodBeat.o(109726);
        return iArr2;
    }

    public final long[] read(long[] jArr, int i2, boolean z) {
        AppMethodBeat.i(109727);
        long[] jArr2 = null;
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                default:
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109727);
                    throw jceDecodeException;
                case 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        jArr2 = new long[read];
                        for (int i3 = 0; i3 < read; i3++) {
                            jArr2[i3] = read(jArr2[0], 0, true);
                        }
                        break;
                    } else {
                        JceDecodeException jceDecodeException2 = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                        AppMethodBeat.o(109727);
                        throw jceDecodeException2;
                    }
            }
        } else if (z) {
            JceDecodeException jceDecodeException3 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109727);
            throw jceDecodeException3;
        }
        AppMethodBeat.o(109727);
        return jArr2;
    }

    public final float[] read(float[] fArr, int i2, boolean z) {
        AppMethodBeat.i(109728);
        float[] fArr2 = null;
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                default:
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109728);
                    throw jceDecodeException;
                case 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        fArr2 = new float[read];
                        for (int i3 = 0; i3 < read; i3++) {
                            fArr2[i3] = read(fArr2[0], 0, true);
                        }
                        break;
                    } else {
                        JceDecodeException jceDecodeException2 = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                        AppMethodBeat.o(109728);
                        throw jceDecodeException2;
                    }
            }
        } else if (z) {
            JceDecodeException jceDecodeException3 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109728);
            throw jceDecodeException3;
        }
        AppMethodBeat.o(109728);
        return fArr2;
    }

    public final double[] read(double[] dArr, int i2, boolean z) {
        AppMethodBeat.i(109729);
        double[] dArr2 = null;
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                default:
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109729);
                    throw jceDecodeException;
                case 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        dArr2 = new double[read];
                        for (int i3 = 0; i3 < read; i3++) {
                            dArr2[i3] = read(dArr2[0], 0, true);
                        }
                        break;
                    } else {
                        JceDecodeException jceDecodeException2 = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                        AppMethodBeat.o(109729);
                        throw jceDecodeException2;
                    }
            }
        } else if (z) {
            JceDecodeException jceDecodeException3 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109729);
            throw jceDecodeException3;
        }
        AppMethodBeat.o(109729);
        return dArr2;
    }

    public final <T> T[] readArray(T[] tArr, int i2, boolean z) {
        AppMethodBeat.i(109730);
        if (tArr == null || tArr.length == 0) {
            JceDecodeException jceDecodeException = new JceDecodeException("unable to get type of key and value.");
            AppMethodBeat.o(109730);
            throw jceDecodeException;
        }
        T[] tArr2 = (T[]) readArrayImpl(tArr[0], i2, z);
        AppMethodBeat.o(109730);
        return tArr2;
    }

    public final <T> List<T> readArray(List<T> list, int i2, boolean z) {
        AppMethodBeat.i(109731);
        if (list == null || list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(109731);
            return arrayList;
        }
        Object[] readArrayImpl = readArrayImpl(list.get(0), i2, z);
        if (readArrayImpl == null) {
            AppMethodBeat.o(109731);
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : readArrayImpl) {
            arrayList2.add(obj);
        }
        AppMethodBeat.o(109731);
        return arrayList2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] readArrayImpl(T t, int i2, boolean z) {
        AppMethodBeat.i(109732);
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case 9:
                    int read = read(0, 0, true);
                    if (read < 0) {
                        JceDecodeException jceDecodeException = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                        AppMethodBeat.o(109732);
                        throw jceDecodeException;
                    }
                    T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), read));
                    for (int i3 = 0; i3 < read; i3++) {
                        tArr[i3] = read((Object) t, 0, true);
                    }
                    AppMethodBeat.o(109732);
                    return tArr;
                default:
                    JceDecodeException jceDecodeException2 = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109732);
                    throw jceDecodeException2;
            }
        } else if (z) {
            JceDecodeException jceDecodeException3 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109732);
            throw jceDecodeException3;
        } else {
            AppMethodBeat.o(109732);
            return null;
        }
    }

    public final JceStruct directRead(JceStruct jceStruct, int i2, boolean z) {
        AppMethodBeat.i(109733);
        JceStruct jceStruct2 = null;
        if (skipToTag(i2)) {
            try {
                jceStruct2 = jceStruct.newInit();
                HeadData headData = new HeadData();
                readHead(headData);
                if (headData.type != 10) {
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109733);
                    throw jceDecodeException;
                }
                jceStruct2.readFrom(this);
                skipToStructEnd();
            } catch (Exception e2) {
                JceDecodeException jceDecodeException2 = new JceDecodeException(e2.getMessage());
                AppMethodBeat.o(109733);
                throw jceDecodeException2;
            }
        } else if (z) {
            JceDecodeException jceDecodeException3 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109733);
            throw jceDecodeException3;
        }
        AppMethodBeat.o(109733);
        return jceStruct2;
    }

    public final JceStruct read(JceStruct jceStruct, int i2, boolean z) {
        AppMethodBeat.i(109734);
        JceStruct jceStruct2 = null;
        if (skipToTag(i2)) {
            try {
                jceStruct2 = (JceStruct) jceStruct.getClass().newInstance();
                HeadData headData = new HeadData();
                readHead(headData);
                if (headData.type != 10) {
                    JceDecodeException jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.o(109734);
                    throw jceDecodeException;
                }
                jceStruct2.readFrom(this);
                skipToStructEnd();
            } catch (Exception e2) {
                JceDecodeException jceDecodeException2 = new JceDecodeException(e2.getMessage());
                AppMethodBeat.o(109734);
                throw jceDecodeException2;
            }
        } else if (z) {
            JceDecodeException jceDecodeException3 = new JceDecodeException("require field not exist.");
            AppMethodBeat.o(109734);
            throw jceDecodeException3;
        }
        AppMethodBeat.o(109734);
        return jceStruct2;
    }

    public final JceStruct[] read(JceStruct[] jceStructArr, int i2, boolean z) {
        AppMethodBeat.i(109735);
        JceStruct[] jceStructArr2 = (JceStruct[]) readArray(jceStructArr, i2, z);
        AppMethodBeat.o(109735);
        return jceStructArr2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.qq.taf.jce.JceInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object read(T t, int i2, boolean z) {
        AppMethodBeat.i(109736);
        if (t instanceof Byte) {
            Byte valueOf = Byte.valueOf(read((byte) 0, i2, z));
            AppMethodBeat.o(109736);
            return valueOf;
        } else if (t instanceof Boolean) {
            Boolean valueOf2 = Boolean.valueOf(read(false, i2, z));
            AppMethodBeat.o(109736);
            return valueOf2;
        } else if (t instanceof Short) {
            Short valueOf3 = Short.valueOf(read((short) 0, i2, z));
            AppMethodBeat.o(109736);
            return valueOf3;
        } else if (t instanceof Integer) {
            Integer valueOf4 = Integer.valueOf(read(0, i2, z));
            AppMethodBeat.o(109736);
            return valueOf4;
        } else if (t instanceof Long) {
            Long valueOf5 = Long.valueOf(read(0L, i2, z));
            AppMethodBeat.o(109736);
            return valueOf5;
        } else if (t instanceof Float) {
            Float valueOf6 = Float.valueOf(read(0.0f, i2, z));
            AppMethodBeat.o(109736);
            return valueOf6;
        } else if (t instanceof Double) {
            Double valueOf7 = Double.valueOf(read(0.0d, i2, z));
            AppMethodBeat.o(109736);
            return valueOf7;
        } else if (t instanceof String) {
            String readString = readString(i2, z);
            AppMethodBeat.o(109736);
            return readString;
        } else if (t instanceof Map) {
            HashMap readMap = readMap(t, i2, z);
            AppMethodBeat.o(109736);
            return readMap;
        } else if (t instanceof List) {
            List readArray = readArray(t, i2, z);
            AppMethodBeat.o(109736);
            return readArray;
        } else if (t instanceof JceStruct) {
            JceStruct read = read((JceStruct) t, i2, z);
            AppMethodBeat.o(109736);
            return read;
        } else if (!t.getClass().isArray()) {
            JceDecodeException jceDecodeException = new JceDecodeException("read object error: unsupport type.");
            AppMethodBeat.o(109736);
            throw jceDecodeException;
        } else if ((t instanceof byte[]) || (t instanceof Byte[])) {
            byte[] read2 = read((byte[]) null, i2, z);
            AppMethodBeat.o(109736);
            return read2;
        } else if (t instanceof boolean[]) {
            boolean[] read3 = read((boolean[]) null, i2, z);
            AppMethodBeat.o(109736);
            return read3;
        } else if (t instanceof short[]) {
            short[] read4 = read((short[]) null, i2, z);
            AppMethodBeat.o(109736);
            return read4;
        } else if (t instanceof int[]) {
            int[] read5 = read((int[]) null, i2, z);
            AppMethodBeat.o(109736);
            return read5;
        } else if (t instanceof long[]) {
            long[] read6 = read((long[]) null, i2, z);
            AppMethodBeat.o(109736);
            return read6;
        } else if (t instanceof float[]) {
            float[] read7 = read((float[]) null, i2, z);
            AppMethodBeat.o(109736);
            return read7;
        } else if (t instanceof double[]) {
            double[] read8 = read((double[]) null, i2, z);
            AppMethodBeat.o(109736);
            return read8;
        } else {
            Object[] readArray2 = readArray((Object[]) t, i2, z);
            AppMethodBeat.o(109736);
            return readArray2;
        }
    }

    public final int setServerEncoding(String str) {
        this.sServerEncoding = str;
        return 0;
    }

    public static void main(String[] strArr) {
    }

    public final ByteBuffer getBs() {
        return this.bs;
    }
}
