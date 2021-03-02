package com.tencent.mm.msgsubscription.d;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0016\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0010X\u0004¢\u0006\u0002\n\u0000R6\u0010\u0011\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000fj\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012`\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgStorageTaskManager;", "", "()V", "LOOP_TAG_PREFIX", "", "MANAGER_THREAD_LOOP_TAG", "TAG", "TASK_TYPE_GET_ALL_SUBSCRIBE_MSG_LIST", "", "TASK_TYPE_GET_SUBSCRIBE_MSG_LIST_FOR_DIALOG", "TASK_TYPE_GET_SUBSCRIBE_MSG_UI_STATUS", "TASK_TYPE_LOAD_LOCAL_SUBSCRIBE_MSG_LIST", "TASK_TYPE_SAVE_SUBSCRIBE_MSG_UI_STATUS", "TASK_TYPE_UPDATE_SUBSCRIBE_MSG_LIST", "loopTagMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "taskMap", "", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "addTask", "", "task", "finishTask", "getLoopTag", "key", "onTaskRunAfter", "onTaskRunBefore", "removeTask", "runTask", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "plugin-comm_release"})
public final class d {
    private static final HashMap<String, List<com.tencent.mm.msgsubscription.e.a>> gVI = new HashMap<>();
    private static final HashMap<String, String> jAQ = new HashMap<>();
    public static final d jAR = new d();

    static {
        AppMethodBeat.i(149659);
        AppMethodBeat.o(149659);
    }

    private d() {
    }

    public static void a(a aVar, com.tencent.mm.msgsubscription.e.a aVar2) {
        AppMethodBeat.i(149657);
        p.h(aVar, "storageManager");
        p.h(aVar2, "task");
        Log.i("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo runTask storageManager: %s, task className: %s, async: %b", Integer.valueOf(aVar.hashCode()), aVar2.getClass().getSimpleName(), Boolean.valueOf(aVar2.jzf));
        if (!aVar2.jzf) {
            aVar2.run();
            AppMethodBeat.o(149657);
            return;
        }
        h.RTc.b(new b(aVar, aVar2), "manager_thread");
        AppMethodBeat.o(149657);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ com.tencent.mm.msgsubscription.e.a jAS;
        final /* synthetic */ a jAT;

        b(a aVar, com.tencent.mm.msgsubscription.e.a aVar2) {
            this.jAT = aVar;
            this.jAS = aVar2;
        }

        public final void run() {
            AppMethodBeat.i(149656);
            String valueOf = String.valueOf(this.jAT.hashCode());
            d dVar = d.jAR;
            String RC = d.RC(valueOf);
            d dVar2 = d.jAR;
            d.b(this.jAS);
            h.RTc.b(new Runnable(this) {
                /* class com.tencent.mm.msgsubscription.d.d.b.AnonymousClass1 */
                final /* synthetic */ b jAU;

                {
                    this.jAU = r1;
                }

                public final void run() {
                    AppMethodBeat.i(149655);
                    if (!this.jAU.jAS.cancelled) {
                        this.jAU.jAS.run();
                        AppMethodBeat.o(149655);
                        return;
                    }
                    Log.i("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo task %s has cancelled", this.jAU.jAS.getKey());
                    AppMethodBeat.o(149655);
                }
            }, RC);
            AppMethodBeat.o(149656);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ com.tencent.mm.msgsubscription.e.a jAS;

        a(com.tencent.mm.msgsubscription.e.a aVar) {
            this.jAS = aVar;
        }

        public final void run() {
            AppMethodBeat.i(149654);
            Log.d("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo onTaskAfter removeTask: %s", Integer.valueOf(this.jAS.hashCode()));
            d dVar = d.jAR;
            d.c(this.jAS);
            AppMethodBeat.o(149654);
        }
    }

    public static void a(com.tencent.mm.msgsubscription.e.a aVar) {
        AppMethodBeat.i(149658);
        p.h(aVar, "task");
        if (aVar.jzf) {
            h.RTc.b(new a(aVar), "manager_thread");
        }
        AppMethodBeat.o(149658);
    }

    public static final /* synthetic */ String RC(String str) {
        AppMethodBeat.i(149660);
        String str2 = jAQ.get(str);
        if (str2 == null) {
            String concat = "SubscribeMsgTask".concat(String.valueOf(str));
            jAQ.put(str, concat);
            str2 = concat;
        }
        AppMethodBeat.o(149660);
        return str2;
    }

    public static final /* synthetic */ void b(com.tencent.mm.msgsubscription.e.a aVar) {
        ArrayList arrayList;
        AppMethodBeat.i(149661);
        Log.d("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo onTaskRunBefore addTask: %s", Integer.valueOf(aVar.hashCode()));
        if (aVar.jzg && aVar.jzf) {
            List<com.tencent.mm.msgsubscription.e.a> list = gVI.get(aVar.getKey());
            Object[] objArr = new Object[1];
            objArr[0] = list != null ? Integer.valueOf(list.size()) : null;
            Log.d("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo onTaskRunBefore oldTask size: %s", objArr);
            if (list != null) {
                for (T t : list) {
                    Log.v("MicroMsg.SubscribeMsgStorageTaskManager", "alvinluo onTaskRunBefore cancel old task: %s", Integer.valueOf(t.hashCode()));
                    t.cancel();
                }
            }
            if (list != null) {
                list.clear();
            }
        }
        List<com.tencent.mm.msgsubscription.e.a> list2 = gVI.get(aVar.getKey());
        List<com.tencent.mm.msgsubscription.e.a> list3 = list2;
        if (list3 == null || list3.isEmpty()) {
            arrayList = new ArrayList();
        } else {
            arrayList = list2;
        }
        if (arrayList != null) {
            arrayList.add(aVar);
        }
        HashMap<String, List<com.tencent.mm.msgsubscription.e.a>> hashMap = gVI;
        String key = aVar.getKey();
        if (arrayList == null) {
            p.hyc();
        }
        hashMap.put(key, arrayList);
        AppMethodBeat.o(149661);
    }

    public static final /* synthetic */ void c(com.tencent.mm.msgsubscription.e.a aVar) {
        AppMethodBeat.i(149662);
        List<com.tencent.mm.msgsubscription.e.a> list = gVI.get(aVar.getKey());
        if (list != null) {
            list.remove(aVar);
            AppMethodBeat.o(149662);
            return;
        }
        AppMethodBeat.o(149662);
    }
}
