package com.tencent.mm.plugin.finder.storage.config;

import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ck;
import com.tencent.mm.sdk.event.IListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R6\u0010\u0006\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/config/FinderSvrConfigMonitor;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ConfigUpdatedEvent;", "()V", "TAG", "", "keyItemMap", "Ljava/util/HashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/storage/config/item/IConfigItem;", "Lkotlin/collections/HashMap;", "callback", "", "event", "register", "", "key", "item", "plugin-finder_release"})
public final class d extends IListener<ck> {
    private static HashMap<String, WeakReference<com.tencent.mm.plugin.finder.storage.config.item.d>> vFG = new HashMap<>();
    public static final d vFH;

    static {
        AppMethodBeat.i(251927);
        d dVar = new d();
        vFH = dVar;
        dVar.alive();
        AppMethodBeat.o(251927);
    }

    private d() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ck ckVar) {
        WeakReference<com.tencent.mm.plugin.finder.storage.config.item.d> weakReference;
        com.tencent.mm.plugin.finder.storage.config.item.d dVar;
        AppMethodBeat.i(251926);
        ck ckVar2 = ckVar;
        if (ckVar2 != null) {
            String str = ckVar2.dFF.dFG;
            if (!((str == null || str.length() == 0) || (weakReference = vFG.get(ckVar2.dFF.dFG)) == null || (dVar = weakReference.get()) == null)) {
                new StringBuilder("config: ").append(ckVar2.dFF.dFG).append(" has update");
                h.hkS();
                dVar.dys();
                dVar.dyt();
            }
        }
        AppMethodBeat.o(251926);
        return true;
    }

    public static void a(String str, com.tencent.mm.plugin.finder.storage.config.item.d dVar) {
        AppMethodBeat.i(251925);
        p.h(str, "key");
        p.h(dVar, "item");
        if (!vFG.containsKey(str)) {
            vFG.put(str, new WeakReference<>(dVar));
        }
        AppMethodBeat.o(251925);
    }
}
