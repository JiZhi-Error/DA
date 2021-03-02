package com.tencent.mm.storagebase;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
public final class c {
    private static f.a OsX = null;
    private static long OsY = 0;
    private static int OsZ = 0;
    private static int index = 0;
    private static boolean on = false;

    public static void p(Exception exc) {
        AppMethodBeat.i(133326);
        if (on) {
            Log.e("MicroMsg.DKTest", "exception:%s", Util.stackTraceToString(exc));
        }
        AppMethodBeat.o(133326);
    }

    static void begin() {
        AppMethodBeat.i(133327);
        if (!on) {
            AppMethodBeat.o(133327);
            return;
        }
        OsX = new f.a();
        index++;
        AppMethodBeat.o(133327);
    }

    private static void r(Cursor cursor) {
        AppMethodBeat.i(133328);
        if (!on) {
            AppMethodBeat.o(133328);
        } else if (cursor == null) {
            AppMethodBeat.o(133328);
        } else {
            OsZ = cursor.getCount();
            f.a aVar = new f.a();
            for (int i2 = 0; i2 < OsZ; i2++) {
                cursor.moveToPosition(i2);
            }
            cursor.moveToPosition(-1);
            OsY = aVar.apr();
            AppMethodBeat.o(133328);
        }
    }

    static void a(String str, Cursor cursor, long j2) {
        AppMethodBeat.i(133329);
        if (!on) {
            AppMethodBeat.o(133329);
            return;
        }
        String str2 = ("Thread:[" + Thread.currentThread().getId() + "," + Thread.currentThread().getName() + "]") + "[" + index + "][" + OsX.apr() + "]";
        if (j2 != 0) {
            str2 = str2 + "[INTRANS]";
        }
        if (cursor != null) {
            r(cursor);
            str2 = str2 + "[cuCnt:" + OsZ + ",cuTime:" + OsY + "]";
        }
        Log.v("MicroMsg.dbtest", (str2 + "[" + str + "]--") + Util.getStack());
        AppMethodBeat.o(133329);
    }
}
