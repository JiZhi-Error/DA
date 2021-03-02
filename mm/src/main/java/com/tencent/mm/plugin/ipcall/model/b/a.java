package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a implements i {
    protected int errCode = 0;
    protected int errType = 0;
    protected c yoW;
    protected AbstractC1441a ypE;

    /* renamed from: com.tencent.mm.plugin.ipcall.model.b.a$a  reason: collision with other inner class name */
    public interface AbstractC1441a {
        void a(int i2, Object obj, int i3, int i4);

        void b(int i2, Object obj, int i3, int i4);
    }

    public abstract void MC();

    public abstract void b(c cVar);

    public abstract int[] eaF();

    public abstract int getServiceType();

    public abstract void onDestroy();

    public final void a(AbstractC1441a aVar) {
        this.ypE = aVar;
    }

    public void init() {
        for (int i2 : eaF()) {
            bg.azz().a(i2, this);
        }
        MC();
    }

    public void destroy() {
        for (int i2 : eaF()) {
            bg.azz().b(i2, this);
        }
        this.ypE = null;
        onDestroy();
    }

    public void a(c cVar) {
        Log.d("MicroMsg.BaseIPCallService", "start service, type: %d", Integer.valueOf(getServiceType()));
        this.yoW = cVar;
        b(this.yoW);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        Log.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(qVar.getType()), Integer.valueOf(getServiceType()));
        this.errType = i2;
        this.errCode = i3;
        if (i2 == 0 && i3 == 0) {
            if (this.ypE != null) {
                this.ypE.a(getServiceType(), qVar, i2, i3);
            }
        } else if (this.ypE != null) {
            this.ypE.b(getServiceType(), qVar, i2, i3);
        }
    }
}
