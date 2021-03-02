package com.b.a.a;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* access modifiers changed from: package-private */
public final class o {
    private static String ckb;
    private static final SimpleDateFormat ckc = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", Locale.US);
    private static final SimpleDateFormat ckd = new SimpleDateFormat("yyyMMddHHmmss", Locale.US);

    protected static boolean t(String str, String str2) {
        boolean z;
        String str3 = null;
        AppMethodBeat.i(87920);
        if (ckb == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                File file = new File(Environment.getExternalStorageDirectory() + FilePathGenerator.ANDROID_DIR_SEP + y.cnp);
                boolean exists = file.exists();
                if (!exists) {
                    exists = file.mkdir();
                }
                if (exists) {
                    str3 = file.toString();
                }
                ckb = str3;
                z = exists;
            } else {
                ckb = null;
                z = false;
            }
            if (!z) {
                AppMethodBeat.o(87920);
                return false;
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(String.valueOf(ckb) + FilePathGenerator.ANDROID_DIR_SEP + str + ".txt", true);
            fileWriter.write("\n" + ckc.format(new Date()) + ',' + str2);
            fileWriter.flush();
            fileWriter.close();
            AppMethodBeat.o(87920);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(87920);
            return false;
        }
    }

    static {
        AppMethodBeat.i(87919);
        AppMethodBeat.o(87919);
    }

    protected static String Jf() {
        AppMethodBeat.i(87921);
        String format = ckd.format(new Date());
        AppMethodBeat.o(87921);
        return format;
    }
}
