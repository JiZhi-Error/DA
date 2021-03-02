package com.tencent.tbs.one.impl.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.IOException;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f2426a;

    public static boolean a(String str, String str2) {
        int lastIndexOf;
        AppMethodBeat.i(173817);
        String name = new File(str2).getName();
        File file = new File(str, ((TextUtils.isEmpty(name) || (lastIndexOf = name.lastIndexOf(46)) <= 0) ? new String[]{name, null} : new String[]{name.substring(0, lastIndexOf), name.substring(lastIndexOf + 1)})[0] + ShareConstants.DEX_SUFFIX);
        if (!file.exists()) {
            f.a("The odex file %s does not exist", file.getAbsolutePath());
            AppMethodBeat.o(173817);
            return true;
        } else if (d.a(file)) {
            try {
                new d(file);
                f.a("The odex file %s is well-kept", file.getAbsolutePath());
                AppMethodBeat.o(173817);
                return true;
            } catch (IOException e2) {
                f.a("The odex file %s has broken", file.getAbsolutePath());
                AppMethodBeat.o(173817);
                return false;
            }
        } else {
            f.a("The odex file %s is not a elf file", file.getAbsolutePath());
            AppMethodBeat.o(173817);
            return true;
        }
    }

    public static File b(String str, String str2) {
        AppMethodBeat.i(173818);
        File file = new File(str, str2 + ".opt");
        AppMethodBeat.o(173818);
        return file;
    }
}
