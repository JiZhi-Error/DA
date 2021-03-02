package com.tencent.matrix.iocanary;

import android.app.Application;
import com.tencent.matrix.e.b;
import com.tencent.matrix.e.c;
import com.tencent.matrix.iocanary.core.IOCanaryCore;

public final class a extends b {
    private IOCanaryCore cUy;
    public final com.tencent.matrix.iocanary.a.a mIOConfig;

    public a(com.tencent.matrix.iocanary.a.a aVar) {
        this.mIOConfig = aVar;
    }

    @Override // com.tencent.matrix.e.b
    public final void init(Application application, c cVar) {
        super.init(application, cVar);
        com.tencent.matrix.iocanary.c.a.setPackageName(application);
        this.cUy = new IOCanaryCore(this);
    }

    @Override // com.tencent.matrix.e.b
    public final void start() {
        super.start();
        this.cUy.start();
    }

    @Override // com.tencent.matrix.e.b
    public final void stop() {
        super.stop();
        this.cUy.stop();
    }

    @Override // com.tencent.matrix.e.b
    public final void destroy() {
        super.destroy();
    }

    @Override // com.tencent.matrix.e.b
    public final String getTag() {
        return "io";
    }
}
