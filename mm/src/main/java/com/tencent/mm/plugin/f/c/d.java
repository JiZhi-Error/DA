package com.tencent.mm.plugin.f.c;

import android.database.Cursor;
import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class d extends b {
    public boolean isStop;
    private int limit;
    private String pQn;
    private long pQo;
    private a pQp;

    public interface a {
        void finish();
    }

    @Override // com.tencent.f.i.h, com.tencent.f.i.g
    public final String getKey() {
        return "ScanMsgTask";
    }

    public d(String str, long j2, int i2, a aVar) {
        AppMethodBeat.i(22754);
        this.pQn = str;
        this.pQo = j2;
        this.limit = i2;
        this.pQp = aVar;
        Log.d("MicroMsg.ScanMsgTask", "%d scan msg[%d %d]", Integer.valueOf(hashCode()), Long.valueOf(this.pQo), Integer.valueOf(this.limit));
        AppMethodBeat.o(22754);
    }

    public final void run() {
        int i2 = 0;
        AppMethodBeat.i(22755);
        if (this.isStop) {
            AppMethodBeat.o(22755);
            return;
        }
        long currentTicks = Util.currentTicks();
        Cursor cursor = null;
        try {
            bg.aVF();
            Cursor k = c.aSQ().k(this.pQn, this.pQo, this.limit);
            long ticksToNow = Util.ticksToNow(currentTicks);
            com.tencent.mm.plugin.f.b.crW();
            com.tencent.mm.plugin.f.b.M(this.limit, ticksToNow);
            while (k.moveToNext()) {
                i2++;
                ca caVar = new ca();
                caVar.convertFrom(k);
                com.tencent.mm.plugin.f.b.crW().an(caVar);
                com.tencent.mm.plugin.f.b.crW().BU(caVar.field_msgId);
                if (this.isStop) {
                    if (k != null) {
                        k.close();
                    }
                    AppMethodBeat.o(22755);
                    return;
                }
            }
            Log.d("MicroMsg.ScanMsgTask", "%d scan msg count[%d] limit[%d]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(this.limit));
            if (i2 < this.limit) {
                com.tencent.mm.plugin.f.b crW = com.tencent.mm.plugin.f.b.crW();
                com.tencent.mm.plugin.f.b.crW();
                crW.BU(com.tencent.mm.plugin.f.b.csa());
            }
            if (k != null) {
                k.close();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanMsgTask", e2, "", new Object[0]);
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(22755);
            throw th;
        }
        if (this.pQp != null) {
            this.pQp.finish();
        }
        AppMethodBeat.o(22755);
    }
}
