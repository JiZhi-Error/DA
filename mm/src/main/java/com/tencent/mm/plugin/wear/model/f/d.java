package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.sdk.platformtools.Log;

public abstract class d implements Runnable {
    /* access modifiers changed from: protected */
    public abstract void execute();

    public abstract String getName();

    public d() {
        Log.i("MicroMsg.WearBaseWorkerTask", "Create %s", getName());
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            execute();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WearBaseWorkerTask", e2, "run task %s occur exception: %s", getName(), e2.getMessage());
        }
        Log.i("MicroMsg.WearBaseWorkerTask", "execute %s | use time %d", getName(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }
}
