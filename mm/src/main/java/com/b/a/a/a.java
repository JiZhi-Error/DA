package com.b.a.a;

import android.content.Context;
import android.os.Handler;
import com.b.a.a.d;

abstract class a extends d implements m {
    private final d[] chn;
    private final Handler[] cho = new Handler[this.chn.length];
    private final d.a[] chp = new d.a[this.cho.length];

    /* access modifiers changed from: package-private */
    public abstract void a(Handler handler, Handler[] handlerArr);

    /* access modifiers changed from: package-private */
    public abstract void a(d.a aVar, d.a[] aVarArr);

    a(d... dVarArr) {
        this.chn = dVarArr;
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void au(Context context) {
        for (d dVar : this.chn) {
            try {
                dVar.a(context, this);
            } catch (Exception e2) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public void a(Context context, Handler handler, d.a aVar) {
        a(handler, this.cho);
        a(aVar, this.chp);
        for (int i2 = 0; i2 < this.chn.length; i2++) {
            try {
                this.chn[i2].a(this.cho[i2], this.chp[i2]);
            } catch (Exception e2) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void av(Context context) {
        for (d dVar : this.chn) {
            dVar.stop();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void IV() {
        for (d dVar : this.chn) {
            dVar.IY();
        }
    }
}
