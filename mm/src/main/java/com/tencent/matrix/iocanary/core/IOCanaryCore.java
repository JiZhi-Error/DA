package com.tencent.matrix.iocanary.core;

import com.tencent.matrix.g.c;
import com.tencent.matrix.iocanary.b.a;
import com.tencent.matrix.report.d;
import java.util.List;

public class IOCanaryCore implements OnJniIssuePublishListener, d.a {
    static final /* synthetic */ boolean $assertionsDisabled = (!IOCanaryCore.class.desiredAssertionStatus());
    private static final String TAG = "Matrix.IOCanaryCore";
    private a mCloseGuardHooker;
    private final com.tencent.matrix.iocanary.a.a mIOConfig;
    private final com.tencent.matrix.iocanary.a mIoCanaryPlugin;
    private boolean mIsStart;

    public IOCanaryCore(com.tencent.matrix.iocanary.a aVar) {
        this.mIOConfig = aVar.mIOConfig;
        this.mIoCanaryPlugin = aVar;
    }

    public void start() {
        initDetectorsAndHookers(this.mIOConfig);
        synchronized (this) {
            this.mIsStart = true;
        }
    }

    public synchronized boolean isStart() {
        return this.mIsStart;
    }

    public void stop() {
        synchronized (this) {
            this.mIsStart = false;
        }
        if (this.mCloseGuardHooker != null) {
            a aVar = this.mCloseGuardHooker;
            c.i("Matrix.CloseGuardHooker", "unHook unHookRet=%b", Boolean.valueOf(a.Sy()));
            aVar.cUz = false;
        }
        IOCanaryJniBridge.uninstall();
    }

    @Override // com.tencent.matrix.report.d.a
    public void onDetectIssue(com.tencent.matrix.report.c cVar) {
        this.mIoCanaryPlugin.onDetectIssue(cVar);
    }

    private void initDetectorsAndHookers(com.tencent.matrix.iocanary.a.a aVar) {
        if ($assertionsDisabled || aVar != null) {
            if (aVar.St() || aVar.Sv() || aVar.Su()) {
                IOCanaryJniBridge.install(aVar, this);
            }
            if (aVar.Sw()) {
                this.mCloseGuardHooker = new a(this);
                a aVar2 = this.mCloseGuardHooker;
                c.i("Matrix.CloseGuardHooker", "hook sIsTryHook=%b", Boolean.valueOf(aVar2.cUz));
                if (!aVar2.cUz) {
                    c.i("Matrix.CloseGuardHooker", "hook hookRet=%b", Boolean.valueOf(aVar2.Sx()));
                    aVar2.cUz = true;
                    return;
                }
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    @Override // com.tencent.matrix.iocanary.core.OnJniIssuePublishListener
    public void onIssuePublish(List<IOIssue> list) {
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.mIoCanaryPlugin.onDetectIssue(com.tencent.matrix.iocanary.c.a.a(list.get(i2)));
            }
        }
    }
}
