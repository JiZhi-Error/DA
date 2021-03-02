package com.tencent.smtt.export.external;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.X5Graphics.GraphicsLib;
import java.io.IOException;
import java.io.InputStream;

public class libwebp {
    private static final int BITMAP_ALPHA_8 = 1;
    private static final int BITMAP_ARGB_4444 = 3;
    private static final int BITMAP_ARGB_8888 = 4;
    private static final int BITMAP_RGB_565 = 2;
    private static final String LOGTAG = "[image]";
    private static boolean isMultiCore = false;
    private static libwebp mInstance = null;
    private static boolean mIsLoadLibSuccess = false;
    private int mBitmapType = 4;

    public native int[] nativeDecode(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public native int[] nativeDecodeInto(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public native int[] nativeDecode_16bit(byte[] bArr, boolean z, int i2);

    public native int nativeGetInfo(byte[] bArr, int[] iArr, int[] iArr2);

    public native int[] nativeIDecode(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public static libwebp getInstance(Context context) {
        AppMethodBeat.i(53227);
        if (mInstance == null) {
            mIsLoadLibSuccess = GraphicsLib.loadWepLibraryIfNeed(context);
            mInstance = new libwebp();
        }
        libwebp libwebp = mInstance;
        AppMethodBeat.o(53227);
        return libwebp;
    }

    public static void loadWepLibraryIfNeed(Context context, String str) {
        AppMethodBeat.i(53228);
        mIsLoadLibSuccess = GraphicsLib.loadWepLibraryIfNeed(context, str);
        AppMethodBeat.o(53228);
    }

    public static void loadWepLibraryIfNeed(Context context) {
        AppMethodBeat.i(53229);
        mIsLoadLibSuccess = GraphicsLib.loadWepLibraryIfNeed(context);
        AppMethodBeat.o(53229);
    }

    private boolean isMultiCore() {
        AppMethodBeat.i(53230);
        boolean contains = getCPUinfo().contains("processor");
        AppMethodBeat.o(53230);
        return contains;
    }

    private String getCPUinfo() {
        AppMethodBeat.i(53231);
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start().getInputStream();
            byte[] bArr = new byte[1024];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (IOException e2) {
        }
        AppMethodBeat.o(53231);
        return str;
    }

    public int getInfo(byte[] bArr, int[] iArr, int[] iArr2) {
        AppMethodBeat.i(53232);
        if (!mIsLoadLibSuccess) {
            AppMethodBeat.o(53232);
            return 0;
        }
        int nativeGetInfo = nativeGetInfo(bArr, iArr, iArr2);
        AppMethodBeat.o(53232);
        return nativeGetInfo;
    }

    public int[] decodeBase(byte[] bArr, int[] iArr, int[] iArr2) {
        AppMethodBeat.i(53233);
        if (!mIsLoadLibSuccess) {
            AppMethodBeat.o(53233);
            return null;
        }
        int[] nativeDecode = nativeDecode(bArr, isMultiCore, iArr, iArr2);
        AppMethodBeat.o(53233);
        return nativeDecode;
    }

    public int[] decodeBase_16bit(byte[] bArr, Bitmap.Config config) {
        AppMethodBeat.i(53234);
        if (!mIsLoadLibSuccess) {
            AppMethodBeat.o(53234);
            return null;
        }
        switch (AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
            case 1:
                this.mBitmapType = 3;
                break;
            case 2:
                this.mBitmapType = 2;
                break;
            default:
                this.mBitmapType = 2;
                break;
        }
        int[] nativeDecode_16bit = nativeDecode_16bit(bArr, isMultiCore, this.mBitmapType);
        AppMethodBeat.o(53234);
        return nativeDecode_16bit;
    }

    /* renamed from: com.tencent.smtt.export.external.libwebp$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Bitmap.Config.values().length];

        static {
            AppMethodBeat.i(53226);
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
                AppMethodBeat.o(53226);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.o(53226);
            }
        }
    }

    public int[] decodeInto(byte[] bArr, int[] iArr, int[] iArr2) {
        AppMethodBeat.i(53235);
        if (!mIsLoadLibSuccess) {
            AppMethodBeat.o(53235);
            return null;
        }
        int[] nativeDecodeInto = nativeDecodeInto(bArr, isMultiCore, iArr, iArr2);
        AppMethodBeat.o(53235);
        return nativeDecodeInto;
    }

    public int[] incDecode(byte[] bArr, int[] iArr, int[] iArr2) {
        AppMethodBeat.i(53236);
        if (!mIsLoadLibSuccess) {
            AppMethodBeat.o(53236);
            return null;
        }
        int[] nativeIDecode = nativeIDecode(bArr, isMultiCore, iArr, iArr2);
        AppMethodBeat.o(53236);
        return nativeIDecode;
    }

    public static int checkIsHuaModel() {
        int i2 = 1;
        AppMethodBeat.i(53237);
        String lowerCase = Build.BRAND.trim().toLowerCase();
        String lowerCase2 = Build.MODEL.trim().toLowerCase();
        int i3 = 0;
        if (lowerCase != null && lowerCase.length() > 0 && lowerCase.contains("huawei")) {
            i3 = 1;
        }
        if (lowerCase2 == null || lowerCase2.length() <= 0 || !lowerCase2.contains("huawei")) {
            i2 = i3;
        }
        AppMethodBeat.o(53237);
        return i2;
    }
}
