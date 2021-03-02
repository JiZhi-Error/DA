package com.tencent.xweb.util;

import android.os.Build;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import dalvik.system.DexClassLoader;
import java.io.File;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class i {
    static boolean SEQ = false;
    static int SER = -1;

    public static ClassLoader huI() {
        AppMethodBeat.i(219096);
        ClassLoader asW = asW(XWalkEnvironment.getAvailableVersion());
        AppMethodBeat.o(219096);
        return asW;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004b, code lost:
        if (r7 > com.tencent.xweb.util.i.SER) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.ClassLoader asW(int r7) {
        /*
        // Method dump skipped, instructions count: 186
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.util.i.asW(int):java.lang.ClassLoader");
    }

    public static ClassLoader bx(String str, String str2, String str3) {
        AppMethodBeat.i(183532);
        ClassLoader a2 = a(str, str2, str3, ClassLoader.getSystemClassLoader());
        AppMethodBeat.o(183532);
        return a2;
    }

    private static ClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        AppMethodBeat.i(183533);
        if (Build.VERSION.SDK_INT >= 29 && str.endsWith("classes.dex") && !ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(a.nS("NOT_USE_JAR_REPLACE_DEX", "tools"))) {
            String replace = str.replace("classes.dex", "classes.dex.jar");
            if (new File(replace).exists()) {
                Log.i("XWebClassLoaderWrapper", "do use .jar instead of .dex");
                str = replace;
            } else {
                Log.i("XWebClassLoaderWrapper", "try use .jar instead of .dex , but .jar not exist");
            }
        }
        DexClassLoader dexClassLoader = new DexClassLoader(str, str2, str3, classLoader);
        AppMethodBeat.o(183533);
        return dexClassLoader;
    }
}
