package com.tencent.mm.plugin.appbrand.task.preload;

import android.annotation.SuppressLint;
import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadMemoryStressReceiver;", "Lcom/tencent/mm/plugin/appbrand/utils/ApplicationTrimMemoryListener;", "()V", "onTrimMemory", "", "level", "", "setup", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class h extends i {
    public static final h nRd = new h();

    static {
        AppMethodBeat.i(51092);
        AppMethodBeat.o(51092);
    }

    private h() {
    }

    public static final void c(Application application) {
        AppMethodBeat.i(51090);
        p.h(application, "app");
        application.registerComponentCallbacks(nRd);
        AppMethodBeat.o(51090);
    }

    @SuppressLint({"SwitchIntDef"})
    public final void onTrimMemory(int i2) {
        AppMethodBeat.i(51091);
        switch (i2) {
            case 5:
            case 10:
            case 15:
                e.onTrimMemory(i2);
                break;
        }
        AppMethodBeat.o(51091);
    }
}
