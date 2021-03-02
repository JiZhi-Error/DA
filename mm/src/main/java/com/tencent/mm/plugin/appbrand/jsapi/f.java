package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Handler;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import java.util.Map;

public interface f {

    public interface a {
        void Zb(String str);

        void proceed();
    }

    public interface b {
        void V(int i2, String str);

        void a(bc bcVar, a aVar);

        void a(p pVar, String str, int i2, String str2);

        boolean a(p pVar, String str, int i2, a aVar);
    }

    <T extends com.tencent.luggage.a.b> T M(Class<T> cls);

    i Oo();

    Map<String, p> Op();

    void P(Runnable runnable);

    void a(bc bcVar);

    void a(bc bcVar, o oVar);

    void a(bc bcVar, int[] iArr);

    boolean a(n nVar);

    <T extends m> T av(Class<T> cls);

    <T extends n> T aw(Class<T> cls);

    void b(String str, String str2, int[] iArr);

    boolean bsV();

    void co(String str, String str2);

    String getAppId();

    com.tencent.mm.plugin.appbrand.a.b getAppState();

    Handler getAsyncHandler();

    int getComponentId();

    Context getContext();

    m getDialogContainer();

    q getFileSystem();

    i getJsRuntime();

    void i(int i2, String str);

    void i(Runnable runnable, long j2);

    boolean isRunning();
}
