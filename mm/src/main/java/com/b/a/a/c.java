package com.b.a.a;

import android.os.Handler;
import com.b.a.a.d;

abstract class c extends d {
    private boolean cht;

    /* access modifiers changed from: package-private */
    public abstract void IW();

    /* access modifiers changed from: package-private */
    public abstract void IX();

    c() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public synchronized void a(Handler handler, d.a aVar) {
        this.cht = false;
        super.a(handler, aVar);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void bJ(boolean z) {
        if (this.cht ^ z) {
            this.cht = z;
            if (this.cht) {
                IW();
            } else {
                IX();
            }
        }
    }
}
