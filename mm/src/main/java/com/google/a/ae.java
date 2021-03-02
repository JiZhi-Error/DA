package com.google.a;

import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

public final class ae {
    public static final byte[] EMPTY_BYTE_ARRAY;
    static final Charset ISO_8859_1 = Charset.forName(KindaConfigCacheStg.SAVE_CHARSET);
    static final Charset UTF_8 = Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
    public static final ByteBuffer bXp;
    public static final h bXq = h.B(EMPTY_BYTE_ARRAY);

    public interface a {
        int getNumber();
    }

    public interface b<T extends a> {
    }

    public interface c {
    }

    public interface d extends e<Integer> {
        d gE(int i2);

        void gF(int i2);

        int getInt(int i2);
    }

    public interface e<E> extends List<E>, RandomAccess {
        e<E> gI(int i2);

        boolean yJ();

        void yK();
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        bXp = ByteBuffer.wrap(bArr);
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean F(byte[] bArr) {
        return ci.F(bArr);
    }

    public static String G(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int aF(long j2) {
        return (int) ((j2 >>> 32) ^ j2);
    }

    public static int bF(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int a(a aVar) {
        return aVar.getNumber();
    }

    public static int B(List<? extends a> list) {
        int i2 = 1;
        for (a aVar : list) {
            i2 = aVar.getNumber() + (i2 * 31);
        }
        return i2;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int a2 = a(length, bArr, 0, length);
        if (a2 == 0) {
            return 1;
        }
        return a2;
    }

    static int a(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    static Object l(Object obj, Object obj2) {
        return ((aw) obj).AN().a((aw) obj2).Bo();
    }
}
