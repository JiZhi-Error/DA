package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.j;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0010H&J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataStore;", "()V", "dispatcher", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DispatcherMachine;", "merger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getMerger", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "viewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/IViewActionCallback;", "createDataMerger", "onAlive", "", "onDead", "register", "callback", "unregister", "STATUS", "plugin-finder_release"})
public abstract class Dispatcher<T extends i> extends DataStore<T> {
    private final d<T> dispatcher = new d<>(this.viewCallbacks);
    private final b<T> merger = createDataMerger();
    private final LinkedList<j> viewCallbacks = new LinkedList<>();

    public abstract b<T> createDataMerger();

    public abstract void onAlive();

    public abstract void onDead();

    public final b<T> getMerger() {
        return this.merger;
    }

    public final d<T> dispatcher() {
        return this.dispatcher;
    }

    public final void register(j jVar) {
        p.h(jVar, "callback");
        this.viewCallbacks.add(jVar);
        Log.i(getTAG(), "register callback " + jVar + " size:" + this.viewCallbacks.size());
        if (this.viewCallbacks.size() == 1) {
            onAlive();
        }
    }

    public final void unregister(j jVar) {
        p.h(jVar, "callback");
        LinkedList<j> linkedList = this.viewCallbacks;
        synchronized (linkedList) {
            for (T t : linkedList) {
                if (p.j(t, jVar)) {
                    this.viewCallbacks.remove(t);
                }
            }
            x xVar = x.SXb;
        }
        Log.i(getTAG(), "unregister callback " + jVar + " size " + this.viewCallbacks.size() + " from " + Util.getStack() + '}');
        if (this.viewCallbacks.size() == 0) {
            onDead();
        }
    }
}
