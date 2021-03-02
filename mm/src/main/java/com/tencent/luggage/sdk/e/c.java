package com.tencent.luggage.sdk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksManager;", "", "()V", "TAG", "", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "addTasksCollection", "", "collection", "id", "finishByInstanceId", "instanceId", "getTasksCollectionById", "luggage-wechat-full-sdk_release"})
public final class c {
    private static final ConcurrentHashMap<String, b> cCB = new ConcurrentHashMap<>();
    public static final c cCC = new c();

    static {
        AppMethodBeat.i(230048);
        AppMethodBeat.o(230048);
    }

    private c() {
    }

    public static b dJ(String str) {
        AppMethodBeat.i(230045);
        p.h(str, "instanceId");
        if (cCB.get(str) == null) {
            cCB.put(str, new b());
        }
        b bVar = cCB.get(str);
        if (bVar == null) {
            p.hyc();
        }
        b bVar2 = bVar;
        AppMethodBeat.o(230045);
        return bVar2;
    }

    public static void a(b bVar, String str) {
        AppMethodBeat.i(230046);
        p.h(bVar, "collection");
        p.h(str, "id");
        if (cCB.put(str, bVar) != null) {
            Log.e("Luggage.AppBrandParallelTasksManager", "add duplicate collection id = [%s]", str);
        }
        AppMethodBeat.o(230046);
    }

    public static void dK(String str) {
        AppMethodBeat.i(230047);
        p.h(str, "instanceId");
        b remove = cCB.remove(str);
        if (remove != null) {
            Log.i("Luggage.AppBrandParallelTasksCollection", "finishAllTask: ");
            for (Map.Entry<Integer, a<?>> entry : remove.cCy.entrySet()) {
                a<?> value = entry.getValue();
                if (value.OZ()) {
                    value.cancel();
                }
            }
            remove.cCy.clear();
            Iterator<T> it = remove.cCz.iterator();
            while (it.hasNext()) {
                it.next().invoke();
            }
            remove.cCz.clear();
            AppMethodBeat.o(230047);
            return;
        }
        AppMethodBeat.o(230047);
    }
}
