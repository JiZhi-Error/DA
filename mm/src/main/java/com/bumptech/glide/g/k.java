package com.bumptech.glide.g;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import com.bumptech.glide.load.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public final class k {
    private static final char[] aNY = "0123456789abcdef".toCharArray();
    private static final char[] aNZ = new char[64];

    static {
        AppMethodBeat.i(77784);
        AppMethodBeat.o(77784);
    }

    public static String m(byte[] bArr) {
        String str;
        AppMethodBeat.i(77771);
        synchronized (aNZ) {
            try {
                char[] cArr = aNZ;
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    int i3 = bArr[i2] & 255;
                    cArr[i2 * 2] = aNY[i3 >>> 4];
                    cArr[(i2 * 2) + 1] = aNY[i3 & 15];
                }
                str = new String(cArr);
            } finally {
                AppMethodBeat.o(77771);
            }
        }
        return str;
    }

    @TargetApi(19)
    public static int k(Bitmap bitmap) {
        AppMethodBeat.i(77772);
        if (bitmap.isRecycled()) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
            AppMethodBeat.o(77772);
            throw illegalStateException;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                int allocationByteCount = bitmap.getAllocationByteCount();
                AppMethodBeat.o(77772);
                return allocationByteCount;
            } catch (NullPointerException e2) {
            }
        }
        int height = bitmap.getHeight() * bitmap.getRowBytes();
        AppMethodBeat.o(77772);
        return height;
    }

    public static int i(int i2, int i3, Bitmap.Config config) {
        int i4;
        AppMethodBeat.i(77773);
        int i5 = i2 * i3;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        switch (AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
            case 1:
                i4 = 1;
                break;
            case 2:
            case 3:
                i4 = 2;
                break;
            case 4:
                i4 = 8;
                break;
            default:
                i4 = 4;
                break;
        }
        int i6 = i4 * i5;
        AppMethodBeat.o(77773);
        return i6;
    }

    /* renamed from: com.bumptech.glide.g.k$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Bitmap.Config.values().length];

        static {
            AppMethodBeat.i(77770);
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 5;
                AppMethodBeat.o(77770);
            } catch (NoSuchFieldError e6) {
                AppMethodBeat.o(77770);
            }
        }
    }

    public static boolean aT(int i2, int i3) {
        AppMethodBeat.i(77774);
        if (!dr(i2) || !dr(i3)) {
            AppMethodBeat.o(77774);
            return false;
        }
        AppMethodBeat.o(77774);
        return true;
    }

    private static boolean dr(int i2) {
        return i2 > 0 || i2 == Integer.MIN_VALUE;
    }

    public static void qv() {
        AppMethodBeat.i(77775);
        if (!qw()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must call this method on the main thread");
            AppMethodBeat.o(77775);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(77775);
    }

    public static boolean qw() {
        AppMethodBeat.i(77776);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.o(77776);
            return true;
        }
        AppMethodBeat.o(77776);
        return false;
    }

    public static boolean qx() {
        AppMethodBeat.i(77777);
        if (!qw()) {
            AppMethodBeat.o(77777);
            return true;
        }
        AppMethodBeat.o(77777);
        return false;
    }

    public static <T> Queue<T> ds(int i2) {
        AppMethodBeat.i(77778);
        ArrayDeque arrayDeque = new ArrayDeque(i2);
        AppMethodBeat.o(77778);
        return arrayDeque;
    }

    public static <T> List<T> c(Collection<T> collection) {
        AppMethodBeat.i(77779);
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        AppMethodBeat.o(77779);
        return arrayList;
    }

    public static boolean h(Object obj, Object obj2) {
        AppMethodBeat.i(77780);
        if (obj != null) {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.o(77780);
            return equals;
        } else if (obj2 == null) {
            AppMethodBeat.o(77780);
            return true;
        } else {
            AppMethodBeat.o(77780);
            return false;
        }
    }

    public static boolean i(Object obj, Object obj2) {
        AppMethodBeat.i(77781);
        if (obj == null) {
            if (obj2 == null) {
                AppMethodBeat.o(77781);
                return true;
            }
            AppMethodBeat.o(77781);
            return false;
        } else if (obj instanceof l) {
            boolean pt = ((l) obj).pt();
            AppMethodBeat.o(77781);
            return pt;
        } else {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.o(77781);
            return equals;
        }
    }

    public static int hashCode(int i2, int i3) {
        return (i3 * 31) + i2;
    }

    public static int a(Object obj, int i2) {
        int hashCode;
        AppMethodBeat.i(77783);
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        int i3 = hashCode + (i2 * 31);
        AppMethodBeat.o(77783);
        return i3;
    }

    public static int b(boolean z, int i2) {
        int i3;
        if (z) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        return i3 + (i2 * 31);
    }

    public static int hashCode(float f2) {
        AppMethodBeat.i(77782);
        int floatToIntBits = Float.floatToIntBits(f2) + JsApiGetABTestConfig.CTRL_INDEX;
        AppMethodBeat.o(77782);
        return floatToIntBits;
    }
}
