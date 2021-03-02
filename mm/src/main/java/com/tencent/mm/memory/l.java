package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.FileSeekingInputStream;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class l {
    private static j itB = new j();
    private static m itC = new m();
    private static int itD = -1;

    public abstract Bitmap a(String str, BitmapFactory.Options options);

    public abstract Bitmap a(String str, Rect rect, BitmapFactory.Options options);

    public abstract void x(Bitmap bitmap);

    public static boolean aRZ() {
        boolean oD = d.oD(19);
        Log.i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", Boolean.valueOf(oD), Boolean.valueOf(Util.isART()), Boolean.valueOf(oD));
        return oD;
    }

    protected static InputStream u(InputStream inputStream) {
        if (inputStream.markSupported()) {
            return inputStream;
        }
        if (inputStream instanceof FileInputStream) {
            return new FileSeekingInputStream((FileInputStream) inputStream);
        }
        return new BufferedInputStream(inputStream);
    }

    protected static void v(InputStream inputStream) {
        try {
            inputStream.reset();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.PlatformBitmapFactory", e2, "reset stream error: %s", e2.getMessage());
        }
    }

    public static l aRY() {
        if (itD == -1) {
            if (aRZ()) {
                itD = 1;
            } else {
                itD = 2;
            }
        }
        switch (itD) {
            case 1:
                return itB;
            case 2:
                return itC;
            default:
                return itC;
        }
    }
}
