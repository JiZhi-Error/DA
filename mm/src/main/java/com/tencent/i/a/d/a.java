package com.tencent.i.a.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.h.c.d;
import com.tencent.h.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private String Str;

    public final File lv(Context context) {
        AppMethodBeat.i(214820);
        if (context == null) {
            AppMethodBeat.o(214820);
            return null;
        }
        if (TextUtils.isEmpty(this.Str)) {
            this.Str = d.V(d.SpV);
        }
        if (TextUtils.isEmpty(this.Str)) {
            AppMethodBeat.o(214820);
            return null;
        }
        h.d("Persistence", "dir : " + this.Str);
        File dir = context.getDir(this.Str, 0);
        AppMethodBeat.o(214820);
        return dir;
    }

    public static File i(File file, String str) {
        AppMethodBeat.i(214821);
        if (file == null) {
            AppMethodBeat.o(214821);
            return null;
        }
        File file2 = new File(file.getAbsolutePath() + File.separator + str);
        if (file2.exists() || file2.mkdirs()) {
            AppMethodBeat.o(214821);
            return file2;
        }
        AppMethodBeat.o(214821);
        return null;
    }

    public static boolean nR(String str, String str2) {
        boolean z = false;
        AppMethodBeat.i(214822);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(214822);
        } else {
            File[] brd = brd(str);
            if (brd == null || brd.length <= 0) {
                AppMethodBeat.o(214822);
            } else {
                int length = brd.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (brd[i2].getName().startsWith(str2)) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                AppMethodBeat.o(214822);
            }
        }
        return z;
    }

    public static List<File> brc(String str) {
        AppMethodBeat.i(214823);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(214823);
            return null;
        }
        File[] brd = brd(str);
        if (brd == null || brd.length <= 0) {
            AppMethodBeat.o(214823);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : brd) {
            if (TextUtils.isEmpty(null) || file.getName().startsWith(null)) {
                arrayList.add(file);
            }
        }
        AppMethodBeat.o(214823);
        return arrayList;
    }

    public static File[] brd(String str) {
        AppMethodBeat.i(214824);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(214824);
            return null;
        }
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            File[] listFiles = file.listFiles();
            AppMethodBeat.o(214824);
            return listFiles;
        }
        AppMethodBeat.o(214824);
        return null;
    }

    static /* synthetic */ long ah(File file) {
        AppMethodBeat.i(214825);
        if (file == null) {
            AppMethodBeat.o(214825);
            return MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        String[] split = file.getName().split("_");
        if (split.length != 2) {
            AppMethodBeat.o(214825);
            return MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        long parseLong = Long.parseLong(split[1]);
        AppMethodBeat.o(214825);
        return parseLong;
    }
}
