package com.tencent.mm.plugin.walletlock.a;

import android.app.Activity;
import android.content.Intent;

public interface b extends com.tencent.mm.kernel.c.a {

    public interface a {
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.a.b$b  reason: collision with other inner class name */
    public interface AbstractC1929b {
        boolean aR(Activity activity);
    }

    void a(Activity activity, AbstractC1929b bVar, a aVar);

    boolean a(Activity activity, AbstractC1929b bVar);

    void aQ(Activity activity);

    void aeZ(int i2);

    void b(Activity activity, int i2, int i3);

    void c(Activity activity, Intent intent, int i2);

    AbstractC1929b fUE();

    boolean fUF();

    boolean fUG();

    void init();

    void j(Activity activity, Intent intent);

    void l(Activity activity, int i2);

    void m(Activity activity, int i2);
}
