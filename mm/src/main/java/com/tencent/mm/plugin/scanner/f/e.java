package com.tencent.mm.plugin.scanner.f;

import android.content.Context;
import android.os.Bundle;
import com.tencent.scanlib.ui.ScanView;

public abstract class e {
    protected ScanView CIW;
    protected b CIX;
    protected Context context;
    protected int mode;

    public interface a {
        void r(int i2, Bundle bundle);
    }

    public interface b {
        void cvn();
    }

    public abstract void c(long j2, Bundle bundle);

    public abstract void destroy();

    public void F(long j2, boolean z) {
    }
}
