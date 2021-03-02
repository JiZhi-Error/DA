package com.tencent.matrix.d;

import android.app.Application;
import com.tencent.matrix.e.b;
import com.tencent.matrix.e.c;
import com.tencent.matrix.g.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends b {
    public final com.tencent.matrix.d.a.a cVv;
    private com.tencent.matrix.d.b.a cVw;

    public a(com.tencent.matrix.d.a.a aVar) {
        this.cVv = aVar;
    }

    @Override // com.tencent.matrix.e.b
    public final void init(Application application, c cVar) {
        super.init(application, cVar);
        this.cVw = new com.tencent.matrix.d.b.a(this);
    }

    @Override // com.tencent.matrix.e.b
    public final synchronized void start() {
        if (!isPluginStarted()) {
            super.start();
            com.tencent.matrix.d.b.a aVar = this.cVw;
            aVar.cVz = com.tencent.matrix.g.a.bj(aVar.mContext);
            if (!com.tencent.matrix.d.b.a.SL() || aVar.cVz == a.EnumC0223a.LOW || aVar.cVz == a.EnumC0223a.BAD || aVar.cVz == a.EnumC0223a.UN_KNOW) {
                aVar.mIsOpen = false;
            } else {
                aVar.mIsOpen = true;
                aVar.mStartTime = System.currentTimeMillis();
                aVar.cVF = 1;
                aVar.cVE = (aVar.mStartTime + aVar.SM()) - 5000;
                com.tencent.matrix.g.c.d("Matrix.MemoryCanaryCore", "next report delay:%d, starttime:%d", Long.valueOf(aVar.SM()), Long.valueOf(aVar.mStartTime));
                aVar.mHandler.postDelayed(aVar.cVI, aVar.SM());
                aVar.cVH = new HashMap<>();
                com.tencent.matrix.d.b.a.cVA = com.tencent.matrix.g.a.getTotalMemory(aVar.mContext) / 1024;
                com.tencent.matrix.d.b.a.cVB = com.tencent.matrix.g.a.bk(aVar.mContext) / 1024;
                com.tencent.matrix.d.b.a.cVC = com.tencent.matrix.g.a.bl(aVar.mContext);
                if (com.tencent.matrix.d.b.a.cVB >= com.tencent.matrix.d.b.a.cVA || com.tencent.matrix.d.b.a.cVB <= 0 || com.tencent.matrix.d.b.a.cVC <= 102400 || com.tencent.matrix.d.b.a.cVA <= 0) {
                    aVar.mIsOpen = false;
                } else {
                    ((Application) aVar.mContext).registerActivityLifecycleCallbacks(aVar.cVK);
                    aVar.mContext.registerComponentCallbacks(aVar.cVL);
                }
            }
        }
    }

    @Override // com.tencent.matrix.e.b
    public final synchronized void stop() {
        if (isPluginStarted()) {
            super.stop();
            com.tencent.matrix.d.b.a aVar = this.cVw;
            ((Application) aVar.mContext).unregisterActivityLifecycleCallbacks(aVar.cVK);
            aVar.mContext.unregisterComponentCallbacks(aVar.cVL);
            aVar.mIsOpen = false;
        }
    }

    @Override // com.tencent.matrix.e.b
    public final void destroy() {
        super.destroy();
    }

    @Override // com.tencent.matrix.e.b
    public final String getTag() {
        return "memoryinfo";
    }

    @Override // com.tencent.matrix.e.b, com.tencent.matrix.b.c
    public final synchronized void onForeground(boolean z) {
        com.tencent.matrix.g.c.i("Matrix.MemoryCanaryPlugin", "onForeground:".concat(String.valueOf(z)), new Object[0]);
        super.onForeground(z);
    }

    @Override // com.tencent.matrix.e.b
    public final JSONObject getJsonInfo() {
        return this.cVw.getJsonInfo();
    }
}
