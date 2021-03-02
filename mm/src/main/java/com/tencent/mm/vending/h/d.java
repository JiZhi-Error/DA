package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.mm.vending.i.a;
import com.tencent.mm.vending.i.b;

public abstract class d {
    public static final h HEAVY_WORK = new h(a.hdK().RaN.getLooper(), "Vending.HEAVY_WORK");
    public static final h LOGIC = new h(b.hdL().RaP.getLooper(), "Vending.LOGIC");
    public static final h UI = new h(Looper.getMainLooper(), "Vending.UI");

    public abstract void arrange(Runnable runnable);

    public abstract void arrangeInterval(Runnable runnable, long j2);

    public abstract void cancel();

    public abstract String getType();

    static {
        g.hdI();
    }

    public static d current() {
        return g.current();
    }

    public static d find(String str) {
        return g.boH(str);
    }
}
