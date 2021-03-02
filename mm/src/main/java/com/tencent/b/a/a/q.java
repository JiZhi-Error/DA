package com.tencent.b.a.a;

import android.content.Context;

public abstract class q {
    protected Context context = null;

    /* access modifiers changed from: protected */
    public abstract boolean TW();

    /* access modifiers changed from: protected */
    public abstract a TX();

    /* access modifiers changed from: protected */
    public abstract void a(a aVar);

    /* access modifiers changed from: protected */
    public abstract String read();

    /* access modifiers changed from: protected */
    public abstract void write(String str);

    protected q(Context context2) {
        this.context = context2;
    }

    public final g Ud() {
        String str;
        if (TW()) {
            str = s.decode(read());
        } else {
            str = null;
        }
        if (str != null) {
            return g.eX(str);
        }
        return null;
    }

    public final void b(g gVar) {
        if (gVar != null) {
            String gVar2 = gVar.toString();
            if (TW()) {
                write(s.encode(gVar2));
            }
        }
    }

    public final a Ue() {
        if (TW()) {
            return TX();
        }
        return null;
    }

    public final void b(a aVar) {
        if (aVar != null && TW()) {
            a(aVar);
        }
    }
}
