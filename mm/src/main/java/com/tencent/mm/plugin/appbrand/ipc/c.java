package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.ui.MMActivity;

public interface c {
    void b(AppBrandProxyUIProcessTask.ProcessResult processResult);

    MMActivity bDF();

    boolean bDG();

    void c(AppBrandProxyUIProcessTask.ProcessResult processResult);

    void runOnUiThread(Runnable runnable);
}
