package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h {

    public interface a {
        void iN(int i2);
    }

    public static int bH(Context context) {
        int i2 = 0;
        AppMethodBeat.i(125019);
        if (context == null) {
            AppMethodBeat.o(125019);
        } else {
            try {
                i2 = context.getSharedPreferences("crash_status_file", 4).getInt("channel", -1);
                AppMethodBeat.o(125019);
            } catch (Throwable th) {
                AppMethodBeat.o(125019);
            }
        }
        return i2;
    }

    public static int bI(Context context) {
        int i2 = 0;
        AppMethodBeat.i(125020);
        if (context == null) {
            AppMethodBeat.o(125020);
        } else {
            try {
                i2 = context.getSharedPreferences("crash_status_file", 4).getInt("googleplaysizelimit", 8192);
                AppMethodBeat.o(125020);
            } catch (Throwable th) {
                AppMethodBeat.o(125020);
            }
        }
        return i2;
    }

    public static void d(Context context, String str, String str2) {
        AppMethodBeat.i(125021);
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
            String string = sharedPreferences.getString("crashlist", "");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("crashlist", string + ";" + str + "," + str2);
            edit.commit();
            AppMethodBeat.o(125021);
        } catch (Throwable th) {
            AppMethodBeat.o(125021);
        }
    }
}
