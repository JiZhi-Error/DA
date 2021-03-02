package com.tencent.e.d.a;

import android.text.TextUtils;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class e {
    public static boolean hkx() {
        AppMethodBeat.i(138350);
        try {
            String str = System.getenv("PATH");
            if (TextUtils.isEmpty(str)) {
                String[] split = str.split(":");
                for (String str2 : split) {
                    File file = new File(str2, "su");
                    if (file.exists()) {
                        new StringBuilder("SuFile found : ").append(file.toString());
                        h.hkR();
                        AppMethodBeat.o(138350);
                        return true;
                    }
                }
            } else if (new File("/system/bin/su").exists()) {
                h.hkR();
                AppMethodBeat.o(138350);
                return true;
            } else if (new File("/system/xbin/su").exists()) {
                h.hkR();
                AppMethodBeat.o(138350);
                return true;
            }
        } catch (Throwable th) {
            h.w(th);
        }
        h.hkR();
        AppMethodBeat.o(138350);
        return false;
    }
}
