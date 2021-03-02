package com.tencent.magicbrush.b;

import android.util.Base64;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b;
import com.tencent.magicbrush.utils.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;

public final class b implements com.github.henryye.nativeiv.b.b {
    private static String[] cOo = {"jpeg", "png", "gif", "svg+xml"};

    private static int ee(String str) {
        boolean z;
        int i2 = 11;
        AppMethodBeat.i(140064);
        if (h.isNullOrNil(str)) {
            AppMethodBeat.o(140064);
            return 0;
        } else if (!str.startsWith("data:image/")) {
            AppMethodBeat.o(140064);
            return 0;
        } else {
            String[] strArr = cOo;
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z = false;
                    break;
                }
                String str2 = strArr[i3];
                if (str.startsWith(str2, 11)) {
                    i2 = str2.length() + 11;
                    z = true;
                    break;
                }
                i3++;
            }
            if (!z) {
                AppMethodBeat.o(140064);
                return 0;
            } else if (!str.startsWith(";base64,", i2)) {
                AppMethodBeat.o(140064);
                return 0;
            } else {
                int i4 = i2 + 8;
                AppMethodBeat.o(140064);
                return i4;
            }
        }
    }

    @Override // com.github.henryye.nativeiv.b.b
    public final boolean accept(Object obj) {
        AppMethodBeat.i(140065);
        if (!(obj instanceof String)) {
            AppMethodBeat.o(140065);
            return false;
        } else if (ee((String) obj) > 0) {
            AppMethodBeat.o(140065);
            return true;
        } else {
            AppMethodBeat.o(140065);
            return false;
        }
    }

    @Override // com.github.henryye.nativeiv.b.b
    public final b.a a(Object obj, ImageDecodeConfig imageDecodeConfig) {
        AppMethodBeat.i(206814);
        String str = (String) obj;
        b.a aVar = new b.a(new ByteArrayInputStream(Base64.decode(str.substring(ee(str)), 2)));
        AppMethodBeat.o(206814);
        return aVar;
    }

    @Override // com.github.henryye.nativeiv.b.b
    public final String sS() {
        return "base64";
    }
}
