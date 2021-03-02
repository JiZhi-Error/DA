package com.tencent.mm.plugin.ipcall.model.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public abstract class b extends a implements a.AbstractC1441a {
    protected boolean jqj = false;
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    public a ypF = null;

    public interface a {
        void a(int i2, q qVar, int i3, int i4);

        void b(int i2, q qVar, int i3, int i4);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public abstract void b(c cVar);

    public abstract void eaG();

    public abstract void eaH();

    public abstract int getTimerInterval();

    public abstract void onStop();

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void init() {
        a(this);
        super.init();
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void destroy() {
        super.destroy();
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void a(c cVar) {
        super.a(cVar);
        this.jqj = true;
        Log.d("MicroMsg.BaseIPCallTimerService", "start service, type: %d", Integer.valueOf(getServiceType()));
    }

    public final void stop() {
        this.jqj = false;
        onStop();
        Log.d("MicroMsg.BaseIPCallTimerService", "stop service, type: %d", Integer.valueOf(getServiceType()));
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a.AbstractC1441a
    public final void a(int i2, Object obj, int i3, int i4) {
        Log.i("MicroMsg.BaseIPCallTimerService", "timer request success!, type: %d, isLoop: %b, interval: %d", Integer.valueOf(i2), Boolean.valueOf(this.jqj), Integer.valueOf(getTimerInterval()));
        eaG();
        if (this.ypF != null) {
            this.ypF.a(i2, (q) obj, i3, i4);
        }
        if (this.jqj) {
            this.mHandler.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.ipcall.model.b.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(25406);
                    b.this.b(b.this.yoW);
                    AppMethodBeat.o(25406);
                }
            }, (long) getTimerInterval());
        }
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a.AbstractC1441a
    public final void b(int i2, Object obj, int i3, int i4) {
        Log.i("MicroMsg.BaseIPCallTimerService", "timer request failed, type: %d, isLoop: %b, interval: %d", Integer.valueOf(i2), Boolean.valueOf(this.jqj), Integer.valueOf(getTimerInterval()));
        eaH();
        if (this.ypF != null) {
            this.ypF.b(i2, (q) obj, i3, i4);
        }
        if (this.jqj) {
            this.mHandler.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.ipcall.model.b.b.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(25407);
                    b.this.b(b.this.yoW);
                    AppMethodBeat.o(25407);
                }
            }, (long) getTimerInterval());
        }
    }
}
