package com.tencent.matrix.a;

import android.app.Application;
import android.os.Message;
import com.tencent.matrix.a;
import com.tencent.matrix.a.b.a.g;
import com.tencent.matrix.a.b.c;
import com.tencent.matrix.g.d;

public class b extends com.tencent.matrix.e.b {
    private static String cQi = null;
    private static String sPackageName = null;
    public final c cQh;

    public b(com.tencent.matrix.a.b.b bVar) {
        this.cQh = new c(bVar);
        com.tencent.matrix.g.c.i("Matrix.battery.BatteryMonitorPlugin", "setUp battery monitor plugin with configs: ".concat(String.valueOf(bVar)), new Object[0]);
    }

    @Override // com.tencent.matrix.e.b
    public void init(Application application, com.tencent.matrix.e.c cVar) {
        super.init(application, cVar);
        if (!this.cQh.cSe.cRU) {
            a.INSTANCE.b(this);
        }
    }

    @Override // com.tencent.matrix.e.b
    public String getTag() {
        return "BatteryMonitorPlugin";
    }

    @Override // com.tencent.matrix.e.b
    public void start() {
        super.start();
        c cVar = this.cQh;
        synchronized (c.class) {
            if (!cVar.cSg) {
                for (g gVar : cVar.cSe.cRZ) {
                    gVar.Se();
                }
                cVar.cSg = true;
            }
        }
    }

    @Override // com.tencent.matrix.e.b
    public void stop() {
        super.stop();
        c cVar = this.cQh;
        synchronized (c.class) {
            if (cVar.cSg) {
                cVar.mHandler.removeCallbacksAndMessages(null);
                for (g gVar : cVar.cSe.cRZ) {
                    gVar.Sf();
                }
                cVar.cSg = false;
            }
        }
    }

    @Override // com.tencent.matrix.e.b, com.tencent.matrix.b.c
    public void onForeground(boolean z) {
        c cVar = this.cQh;
        if (!com.tencent.matrix.b.isInstalled()) {
            com.tencent.matrix.g.c.e("Matrix.battery.BatteryMonitorCore", "Matrix was not installed yet, just ignore the event", new Object[0]);
            return;
        }
        cVar.cSh = z;
        if (!z) {
            cVar.mHandler.removeCallbacksAndMessages(null);
            Message obtain = Message.obtain(cVar.mHandler);
            obtain.what = 1;
            cVar.mHandler.sendMessageDelayed(obtain, c.cSk);
            if (cVar.cSj) {
                if (cVar.cSd != null) {
                    cVar.mHandler.removeCallbacks(cVar.cSd);
                    cVar.cSd = null;
                }
                cVar.cSd = new c.a(cVar, (byte) 0);
                cVar.mHandler.postDelayed(cVar.cSd, c.cSm);
            }
        } else if (!cVar.mHandler.hasMessages(1)) {
            if (cVar.cSd != null) {
                cVar.mHandler.removeCallbacks(cVar.cSd);
                cVar.cSd = null;
            }
            Message obtain2 = Message.obtain(cVar.mHandler);
            obtain2.what = 2;
            cVar.mHandler.sendMessageAtFrontOfQueue(obtain2);
            if (cVar.cSi && cVar.cSc != null) {
                cVar.mHandler.removeCallbacks(cVar.cSc);
                cVar.cSc.cSp = 1;
                cVar.mHandler.post(cVar.cSc);
            }
        }
        for (g gVar : cVar.cSe.cRZ) {
            gVar.onForeground(z);
        }
    }

    @Override // com.tencent.matrix.e.b
    public boolean isForeground() {
        return this.cQh.cSh;
    }

    public final String getProcessName() {
        if (cQi == null) {
            synchronized (this) {
                if (cQi == null) {
                    Application application = getApplication();
                    if (application == null) {
                        throw new IllegalStateException(getTag() + " is not yet init!");
                    }
                    cQi = d.getProcessName(application);
                }
            }
        }
        return cQi;
    }

    public final String getPackageName() {
        if (sPackageName == null) {
            synchronized (this) {
                if (sPackageName == null) {
                    if (getApplication() == null) {
                        throw new IllegalStateException(getTag() + " is not yet init!");
                    }
                    sPackageName = getApplication().getPackageName();
                }
            }
        }
        return sPackageName;
    }
}
