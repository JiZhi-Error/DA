package com.tencent.mm.plugin.finder.upload;

import com.tencent.mm.loader.g.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\rJ\b\u0010\u0013\u001a\u00020\rH&R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "()V", "TAG", "", "costTime", "", "taskStartTime", "getTaskStartTime", "()J", "setTaskStartTime", "(J)V", "call", "", "callback", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "getTaskCostTime", "resetCost", "start", "plugin-finder_release"})
public abstract class j extends c {
    private final String TAG = "Finder.LogPost.FinderTask";
    private long costTime;
    private long taskStartTime;

    public abstract void start();

    @Override // com.tencent.mm.loader.g.c
    public void call() {
        Log.i(this.TAG, "task-" + auK() + " start");
        dBj();
        start();
    }

    @Override // com.tencent.mm.loader.g.c
    public final void a(com.tencent.mm.loader.g.j jVar) {
        p.h(jVar, "status");
        Log.i(this.TAG, "task-" + auK() + " callback, " + jVar.name());
        this.costTime = cl.aWz() - this.taskStartTime;
        super.a(jVar);
    }

    public final long dBi() {
        if (this.costTime == 0) {
            return cl.aWz() - this.taskStartTime;
        }
        return this.costTime;
    }

    public final void dBj() {
        this.taskStartTime = cl.aWz();
        this.costTime = 0;
    }
}
