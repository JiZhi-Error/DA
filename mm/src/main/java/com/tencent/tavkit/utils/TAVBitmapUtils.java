package com.tencent.tavkit.utils;

import android.media.ExifInterface;
import android.support.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public class TAVBitmapUtils {
    public static int readImagePreferRotation(String str) {
        int i2 = 1;
        AppMethodBeat.i(197683);
        try {
            switch (new ExifInterface(str).getAttributeInt(a.TAG_ORIENTATION, 1)) {
                case 3:
                    i2 = 2;
                    break;
                case 4:
                case 5:
                case 7:
                default:
                    i2 = 0;
                    break;
                case 6:
                    i2 = 3;
                    break;
                case 8:
                    break;
            }
            AppMethodBeat.o(197683);
            return i2;
        } catch (IOException e2) {
            AppMethodBeat.o(197683);
            return 0;
        }
    }
}
