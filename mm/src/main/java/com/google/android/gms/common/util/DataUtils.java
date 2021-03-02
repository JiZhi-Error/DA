package com.google.android.gms.common.util;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.CharArrayBuffer;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class DataUtils {
    public static void copyStringToBuffer(String str, CharArrayBuffer charArrayBuffer) {
        AppMethodBeat.i(5165);
        if (TextUtils.isEmpty(str)) {
            charArrayBuffer.sizeCopied = 0;
        } else if (charArrayBuffer.data == null || charArrayBuffer.data.length < str.length()) {
            charArrayBuffer.data = str.toCharArray();
        } else {
            str.getChars(0, str.length(), charArrayBuffer.data, 0);
        }
        charArrayBuffer.sizeCopied = str.length();
        AppMethodBeat.o(5165);
    }

    public static byte[] loadImageBytes(AssetManager assetManager, String str) {
        AppMethodBeat.i(5167);
        try {
            byte[] readInputStreamFully = IOUtils.readInputStreamFully(assetManager.open(str));
            AppMethodBeat.o(5167);
            return readInputStreamFully;
        } catch (IOException e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(5167);
            throw runtimeException;
        }
    }

    @VisibleForTesting
    public static byte[] loadImageBytes(Resources resources, int i2) {
        AppMethodBeat.i(5166);
        try {
            byte[] readInputStreamFully = IOUtils.readInputStreamFully(resources.openRawResource(i2));
            AppMethodBeat.o(5166);
            return readInputStreamFully;
        } catch (IOException e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(5166);
            throw runtimeException;
        }
    }

    public static byte[] loadImageBytes(Bitmap bitmap) {
        AppMethodBeat.i(5169);
        byte[] loadImageBytes = loadImageBytes(bitmap, 100);
        AppMethodBeat.o(5169);
        return loadImageBytes;
    }

    public static byte[] loadImageBytes(Bitmap bitmap, int i2) {
        AppMethodBeat.i(5170);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(5170);
        return byteArray;
    }

    public static byte[] loadImageBytes(BitmapDrawable bitmapDrawable) {
        AppMethodBeat.i(5168);
        byte[] loadImageBytes = loadImageBytes(bitmapDrawable.getBitmap());
        AppMethodBeat.o(5168);
        return loadImageBytes;
    }
}
