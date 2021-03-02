package com.tencent.mm.aj;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.ArrayList;
import java.util.List;

public final class o {
    private static List<String> iLk = null;
    private static int iLl = 0;
    private static a iLm = new a(new b());

    static /* synthetic */ int aYz() {
        int i2 = iLl;
        iLl = i2 + 1;
        return i2;
    }

    static {
        AppMethodBeat.i(150317);
        AppMethodBeat.o(150317);
    }

    public static void H(Runnable runnable) {
        AppMethodBeat.i(150315);
        if (!g.aAf().azp()) {
            AppMethodBeat.o(150315);
            return;
        }
        j aYB = p.aYB();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = aYB.iFy.rawQuery("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
        while (rawQuery.moveToNext()) {
            arrayList.add(rawQuery.getString(0));
        }
        rawQuery.close();
        iLk = arrayList;
        if (arrayList.size() <= 0) {
            AppMethodBeat.o(150315);
            return;
        }
        iLm.iLn.iLo = runnable;
        iLm.startTimer(10);
        AppMethodBeat.o(150315);
    }

    public static void aYx() {
        AppMethodBeat.i(150316);
        iLl = 0;
        iLm.stopTimer();
        AppMethodBeat.o(150316);
    }

    static class b implements MTimerHandler.CallBack {
        Runnable iLo;

        b() {
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(150314);
            int size = o.iLk.size();
            Log.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:".concat(String.valueOf(size)));
            if (size <= 2000 || o.iLl >= 300) {
                if (this.iLo != null) {
                    this.iLo.run();
                }
                int unused = o.iLl = 0;
                AppMethodBeat.o(150314);
                return false;
            }
            long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
            for (int i2 = size - 1; i2 >= size - 30; i2--) {
                o.aYz();
                String str = (String) o.iLk.get(i2);
                o.iLk.remove(i2);
                p.aYn();
                e.N(str, false);
                p.aYn();
                e.N(str, true);
                p.aYB().My(str);
            }
            g.aAh().hqK.endTransaction(beginTransaction);
            AppMethodBeat.o(150314);
            return true;
        }
    }

    static class a extends MTimerHandler {
        final b iLn;

        public a(b bVar) {
            super(bVar, true);
            this.iLn = bVar;
        }
    }
}
