package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class i {
    h Otw;
    private BlockingQueue<a> queue = new LinkedBlockingQueue();
    private String table = null;
    private MTimerHandler timer = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.storagebase.i.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(133428);
            if (!i.this.Otw.isOpen()) {
                AppMethodBeat.o(133428);
            } else {
                i.this.gFI();
                AppMethodBeat.o(133428);
            }
            return false;
        }
    }, false);

    public i(h hVar, String str) {
        AppMethodBeat.i(133430);
        this.Otw = hVar;
        this.table = str;
        AppMethodBeat.o(133430);
    }

    private int a(a aVar) {
        AppMethodBeat.i(133431);
        if (aVar == null) {
            Log.w("MicroMsg.MemoryStorage.Holder", "appendToDisk Holder == null. table:%s", this.table);
            AppMethodBeat.o(133431);
            return -2;
        } else if (this.Otw == null || !this.Otw.isOpen()) {
            Log.e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", this.table);
            AppMethodBeat.o(133431);
            return -3;
        } else {
            if (aVar.funcType == 2) {
                this.Otw.insert(this.table, aVar.primaryKey, aVar.values);
            } else if (aVar.funcType == 5) {
                this.Otw.delete(this.table, aVar.OtI, aVar.OtJ);
            } else if (aVar.funcType == 1) {
                this.Otw.execSQL(this.table, aVar.sql);
            } else if (aVar.funcType == 4) {
                this.Otw.replace(this.table, aVar.primaryKey, aVar.values);
            } else if (aVar.funcType == 3) {
                this.Otw.update(this.table, aVar.values, aVar.OtI, aVar.OtJ);
            } else {
                AppMethodBeat.o(133431);
                return -1;
            }
            AppMethodBeat.o(133431);
            return 0;
        }
    }

    public final int gFI() {
        long j2;
        AppMethodBeat.i(133432);
        Log.d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", this.table, Boolean.valueOf(this.Otw.inTransaction()), Integer.valueOf(this.queue.size()));
        if (this.queue.isEmpty()) {
            AppMethodBeat.o(133432);
        } else {
            if (!this.Otw.inTransaction()) {
                j2 = this.Otw.beginTransaction(Thread.currentThread().getId());
            } else {
                j2 = 0;
            }
            while (!this.queue.isEmpty()) {
                a(this.queue.poll());
            }
            if (j2 > 0) {
                this.Otw.endTransaction(j2);
            }
            AppMethodBeat.o(133432);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int b(a aVar) {
        AppMethodBeat.i(133433);
        this.queue.add(aVar);
        if (this.queue.size() >= 40) {
            gFI();
        }
        if (this.timer.stopped()) {
            this.timer.startTimer(Util.MILLSECONDS_OF_MINUTE);
        }
        AppMethodBeat.o(133433);
        return 0;
    }

    public static class a {
        public String OtI;
        public String[] OtJ;
        public int funcType;
        public String primaryKey;
        public String sql;
        public ContentValues values;

        public final void Z(String[] strArr) {
            AppMethodBeat.i(133429);
            if (strArr == null || strArr.length <= 0) {
                AppMethodBeat.o(133429);
                return;
            }
            this.OtJ = new String[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                this.OtJ[i2] = new String(strArr[i2]);
            }
            AppMethodBeat.o(133429);
        }
    }
}
