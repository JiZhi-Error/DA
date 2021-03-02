package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class n implements i<Object> {
    private static final Charset RAF = Charset.forName("UTF8");
    public static final n SSp = new n();
    private static final boolean SSq = (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN);

    static {
        AppMethodBeat.i(9865);
        AppMethodBeat.o(9865);
    }

    @Override // io.flutter.plugin.a.i
    public final ByteBuffer eP(Object obj) {
        AppMethodBeat.i(9851);
        if (obj == null) {
            AppMethodBeat.o(9851);
            return null;
        }
        a aVar = new a();
        a(aVar, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.buffer(), 0, aVar.size());
        AppMethodBeat.o(9851);
        return allocateDirect;
    }

    @Override // io.flutter.plugin.a.i
    public final Object J(ByteBuffer byteBuffer) {
        AppMethodBeat.i(9852);
        if (byteBuffer == null) {
            AppMethodBeat.o(9852);
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        Object O = O(byteBuffer);
        if (byteBuffer.hasRemaining()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Message corrupted");
            AppMethodBeat.o(9852);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(9852);
        return O;
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, int i2) {
        AppMethodBeat.i(9853);
        if (i2 < 254) {
            byteArrayOutputStream.write(i2);
            AppMethodBeat.o(9853);
        } else if (i2 <= 65535) {
            byteArrayOutputStream.write(254);
            if (SSq) {
                byteArrayOutputStream.write(i2);
                byteArrayOutputStream.write(i2 >>> 8);
                AppMethodBeat.o(9853);
                return;
            }
            byteArrayOutputStream.write(i2 >>> 8);
            byteArrayOutputStream.write(i2);
            AppMethodBeat.o(9853);
        } else {
            byteArrayOutputStream.write(255);
            b(byteArrayOutputStream, i2);
            AppMethodBeat.o(9853);
        }
    }

    private static void b(ByteArrayOutputStream byteArrayOutputStream, int i2) {
        AppMethodBeat.i(9854);
        if (SSq) {
            byteArrayOutputStream.write(i2);
            byteArrayOutputStream.write(i2 >>> 8);
            byteArrayOutputStream.write(i2 >>> 16);
            byteArrayOutputStream.write(i2 >>> 24);
            AppMethodBeat.o(9854);
            return;
        }
        byteArrayOutputStream.write(i2 >>> 24);
        byteArrayOutputStream.write(i2 >>> 16);
        byteArrayOutputStream.write(i2 >>> 8);
        byteArrayOutputStream.write(i2);
        AppMethodBeat.o(9854);
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, long j2) {
        AppMethodBeat.i(9855);
        if (SSq) {
            byteArrayOutputStream.write((byte) ((int) j2));
            byteArrayOutputStream.write((byte) ((int) (j2 >>> 8)));
            byteArrayOutputStream.write((byte) ((int) (j2 >>> 16)));
            byteArrayOutputStream.write((byte) ((int) (j2 >>> 24)));
            byteArrayOutputStream.write((byte) ((int) (j2 >>> 32)));
            byteArrayOutputStream.write((byte) ((int) (j2 >>> 40)));
            byteArrayOutputStream.write((byte) ((int) (j2 >>> 48)));
            byteArrayOutputStream.write((byte) ((int) (j2 >>> 56)));
            AppMethodBeat.o(9855);
            return;
        }
        byteArrayOutputStream.write((byte) ((int) (j2 >>> 56)));
        byteArrayOutputStream.write((byte) ((int) (j2 >>> 48)));
        byteArrayOutputStream.write((byte) ((int) (j2 >>> 40)));
        byteArrayOutputStream.write((byte) ((int) (j2 >>> 32)));
        byteArrayOutputStream.write((byte) ((int) (j2 >>> 24)));
        byteArrayOutputStream.write((byte) ((int) (j2 >>> 16)));
        byteArrayOutputStream.write((byte) ((int) (j2 >>> 8)));
        byteArrayOutputStream.write((byte) ((int) j2));
        AppMethodBeat.o(9855);
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, double d2) {
        AppMethodBeat.i(9856);
        a(byteArrayOutputStream, Double.doubleToLongBits(d2));
        AppMethodBeat.o(9856);
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        AppMethodBeat.i(9857);
        a(byteArrayOutputStream, bArr.length);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
        AppMethodBeat.o(9857);
    }

    private static void c(ByteArrayOutputStream byteArrayOutputStream, int i2) {
        AppMethodBeat.i(9858);
        int size = byteArrayOutputStream.size() % i2;
        if (size != 0) {
            for (int i3 = 0; i3 < i2 - size; i3++) {
                byteArrayOutputStream.write(0);
            }
        }
        AppMethodBeat.o(9858);
    }

    /* access modifiers changed from: protected */
    public final void a(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        int i2 = 0;
        AppMethodBeat.i(9859);
        if (obj == null || obj.equals(null)) {
            byteArrayOutputStream.write(0);
            AppMethodBeat.o(9859);
        } else if (obj == Boolean.TRUE) {
            byteArrayOutputStream.write(1);
            AppMethodBeat.o(9859);
        } else if (obj == Boolean.FALSE) {
            byteArrayOutputStream.write(2);
            AppMethodBeat.o(9859);
        } else if (obj instanceof Number) {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                byteArrayOutputStream.write(3);
                b(byteArrayOutputStream, ((Number) obj).intValue());
                AppMethodBeat.o(9859);
            } else if (obj instanceof Long) {
                byteArrayOutputStream.write(4);
                a(byteArrayOutputStream, ((Long) obj).longValue());
                AppMethodBeat.o(9859);
            } else if ((obj instanceof Float) || (obj instanceof Double)) {
                byteArrayOutputStream.write(6);
                c(byteArrayOutputStream, 8);
                a(byteArrayOutputStream, ((Number) obj).doubleValue());
                AppMethodBeat.o(9859);
            } else if (obj instanceof BigInteger) {
                byteArrayOutputStream.write(5);
                a(byteArrayOutputStream, ((BigInteger) obj).toString(16).getBytes(RAF));
                AppMethodBeat.o(9859);
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported Number type: " + obj.getClass());
                AppMethodBeat.o(9859);
                throw illegalArgumentException;
            }
        } else if (obj instanceof String) {
            byteArrayOutputStream.write(7);
            a(byteArrayOutputStream, ((String) obj).getBytes(RAF));
            AppMethodBeat.o(9859);
        } else if (obj instanceof byte[]) {
            byteArrayOutputStream.write(8);
            a(byteArrayOutputStream, (byte[]) obj);
            AppMethodBeat.o(9859);
        } else if (obj instanceof int[]) {
            byteArrayOutputStream.write(9);
            int[] iArr = (int[]) obj;
            a(byteArrayOutputStream, iArr.length);
            c(byteArrayOutputStream, 4);
            int length = iArr.length;
            while (i2 < length) {
                b(byteArrayOutputStream, iArr[i2]);
                i2++;
            }
            AppMethodBeat.o(9859);
        } else if (obj instanceof long[]) {
            byteArrayOutputStream.write(10);
            long[] jArr = (long[]) obj;
            a(byteArrayOutputStream, jArr.length);
            c(byteArrayOutputStream, 8);
            int length2 = jArr.length;
            while (i2 < length2) {
                a(byteArrayOutputStream, jArr[i2]);
                i2++;
            }
            AppMethodBeat.o(9859);
        } else if (obj instanceof double[]) {
            byteArrayOutputStream.write(11);
            double[] dArr = (double[]) obj;
            a(byteArrayOutputStream, dArr.length);
            c(byteArrayOutputStream, 8);
            int length3 = dArr.length;
            while (i2 < length3) {
                a(byteArrayOutputStream, dArr[i2]);
                i2++;
            }
            AppMethodBeat.o(9859);
        } else if (obj instanceof List) {
            byteArrayOutputStream.write(12);
            List<Object> list = (List) obj;
            a(byteArrayOutputStream, list.size());
            for (Object obj2 : list) {
                a(byteArrayOutputStream, obj2);
            }
            AppMethodBeat.o(9859);
        } else if (obj instanceof Map) {
            byteArrayOutputStream.write(13);
            Map map = (Map) obj;
            a(byteArrayOutputStream, map.size());
            for (Map.Entry entry : map.entrySet()) {
                a(byteArrayOutputStream, entry.getKey());
                a(byteArrayOutputStream, entry.getValue());
            }
            AppMethodBeat.o(9859);
        } else {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Unsupported value: ".concat(String.valueOf(obj)));
            AppMethodBeat.o(9859);
            throw illegalArgumentException2;
        }
    }

    private static int M(ByteBuffer byteBuffer) {
        AppMethodBeat.i(9860);
        if (!byteBuffer.hasRemaining()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Message corrupted");
            AppMethodBeat.o(9860);
            throw illegalArgumentException;
        }
        int i2 = byteBuffer.get() & 255;
        if (i2 < 254) {
            AppMethodBeat.o(9860);
            return i2;
        } else if (i2 == 254) {
            char c2 = byteBuffer.getChar();
            AppMethodBeat.o(9860);
            return c2;
        } else {
            int i3 = byteBuffer.getInt();
            AppMethodBeat.o(9860);
            return i3;
        }
    }

    private static byte[] N(ByteBuffer byteBuffer) {
        AppMethodBeat.i(9861);
        byte[] bArr = new byte[M(byteBuffer)];
        byteBuffer.get(bArr);
        AppMethodBeat.o(9861);
        return bArr;
    }

    private static void f(ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(9862);
        int position = byteBuffer.position() % i2;
        if (position != 0) {
            byteBuffer.position((byteBuffer.position() + i2) - position);
        }
        AppMethodBeat.o(9862);
    }

    /* access modifiers changed from: protected */
    public final Object O(ByteBuffer byteBuffer) {
        AppMethodBeat.i(9863);
        if (!byteBuffer.hasRemaining()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Message corrupted");
            AppMethodBeat.o(9863);
            throw illegalArgumentException;
        }
        Object a2 = a(byteBuffer.get(), byteBuffer);
        AppMethodBeat.o(9863);
        return a2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0018 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v16, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Map, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2, types: [double[]] */
    /* JADX WARN: Type inference failed for: r0v3, types: [long[]] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int[]] */
    /* JADX WARN: Type inference failed for: r0v5, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.math.BigInteger] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v17 */
    private Object a(byte b2, ByteBuffer byteBuffer) {
        Object hashMap;
        int i2 = 0;
        AppMethodBeat.i(9864);
        switch (b2) {
            case 0:
                hashMap = 0;
                break;
            case 1:
                hashMap = Boolean.TRUE;
                break;
            case 2:
                hashMap = Boolean.FALSE;
                break;
            case 3:
                hashMap = Integer.valueOf(byteBuffer.getInt());
                break;
            case 4:
                hashMap = Long.valueOf(byteBuffer.getLong());
                break;
            case 5:
                hashMap = new BigInteger(new String(N(byteBuffer), RAF), 16);
                break;
            case 6:
                f(byteBuffer, 8);
                hashMap = Double.valueOf(byteBuffer.getDouble());
                break;
            case 7:
                hashMap = new String(N(byteBuffer), RAF);
                break;
            case 8:
                hashMap = N(byteBuffer);
                break;
            case 9:
                int M = M(byteBuffer);
                hashMap = new int[M];
                f(byteBuffer, 4);
                byteBuffer.asIntBuffer().get((int[]) hashMap);
                byteBuffer.position((M * 4) + byteBuffer.position());
                break;
            case 10:
                int M2 = M(byteBuffer);
                hashMap = new long[M2];
                f(byteBuffer, 8);
                byteBuffer.asLongBuffer().get((long[]) hashMap);
                byteBuffer.position((M2 * 8) + byteBuffer.position());
                break;
            case 11:
                int M3 = M(byteBuffer);
                hashMap = new double[M3];
                f(byteBuffer, 8);
                byteBuffer.asDoubleBuffer().get((double[]) hashMap);
                byteBuffer.position((M3 * 8) + byteBuffer.position());
                break;
            case 12:
                int M4 = M(byteBuffer);
                hashMap = new ArrayList(M4);
                while (i2 < M4) {
                    hashMap.add(O(byteBuffer));
                    i2++;
                }
                break;
            case 13:
                int M5 = M(byteBuffer);
                hashMap = new HashMap();
                while (i2 < M5) {
                    hashMap.put(O(byteBuffer), O(byteBuffer));
                    i2++;
                }
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Message corrupted");
                AppMethodBeat.o(9864);
                throw illegalArgumentException;
        }
        AppMethodBeat.o(9864);
        return hashMap;
    }

    static final class a extends ByteArrayOutputStream {
        a() {
        }

        /* access modifiers changed from: package-private */
        public final byte[] buffer() {
            return this.buf;
        }
    }
}
