package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0006\u0010\u0014\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/engine/FunctionMsgQueue;", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "(Lcom/tencent/mm/engine/FunctionMsgTimer;)V", "lock", "mList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/engine/FunctionMsgTask;", "mMap", "Ljava/util/HashMap;", "", "mTimer", "add", "", "task", "isNeedRemove", "", "old", "new", "loop", "Companion", "plugin-functionmsg_release"})
public final class c {
    public static final a heT = new a((byte) 0);
    private final e heK;
    private final LinkedList<d> heS = new LinkedList<>();
    private final Object lock;
    private final HashMap<String, d> mMap = new HashMap<>();

    static {
        AppMethodBeat.i(114119);
        AppMethodBeat.o(114119);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/engine/FunctionMsgQueue$Companion;", "", "()V", "TAG", "", "plugin-functionmsg_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public c(e eVar) {
        p.h(eVar, "timer");
        AppMethodBeat.i(114118);
        this.heK = eVar;
        this.lock = new Object();
        AppMethodBeat.o(114118);
    }

    public final void a(d dVar) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        boolean z;
        AppMethodBeat.i(114116);
        p.h(dVar, "task");
        synchronized (this.lock) {
            try {
                z.f fVar = new z.f();
                fVar.SYG = null;
                if (this.mMap.containsKey(dVar.heU.Vk())) {
                    fVar.SYG = (T) this.mMap.remove(dVar.heU.Vk());
                }
                if (fVar.SYG != null) {
                    T t = fVar.SYG;
                    if (101 == dVar.dKp) {
                        z = true;
                    } else if (1 == dVar.dKp) {
                        z = t.heU.getVersion() < dVar.heU.getVersion() || dVar.heU.getVersion() == 0;
                    } else {
                        z = t.heU.getVersion() < dVar.heU.getVersion();
                    }
                    if (z) {
                        Log.w("FunctionMsg.FunctionMsgQueue", "[add] remove old task[%s]", fVar.SYG);
                        this.heS.remove(fVar.SYG);
                        objArr = new Object[2];
                        objArr[0] = dVar;
                        if (fVar.SYG != null || (r0 = fVar.SYG) == null) {
                            objArr3 = objArr;
                            objArr2 = objArr;
                            T t2 = "@null";
                        } else {
                            objArr3 = objArr;
                            objArr2 = objArr;
                        }
                        objArr3[1] = t2;
                        Log.i("FunctionMsg.FunctionMsgQueue", "[add] add task[%s] old Task[%s]", objArr2);
                        this.heS.add(dVar);
                        String Vk = dVar.heU.Vk();
                        p.g(Vk, "task.mItem.functionMsgId");
                        this.mMap.put(Vk, dVar);
                        x xVar = x.SXb;
                    }
                }
                if (fVar.SYG != null) {
                    Log.e("FunctionMsg.FunctionMsgQueue", "[add] is wrong! new task:%s old task:%s", dVar, fVar.SYG);
                    AppMethodBeat.o(114116);
                    return;
                }
                objArr = new Object[2];
                objArr[0] = dVar;
                if (fVar.SYG != null) {
                }
                objArr3 = objArr;
                objArr2 = objArr;
                T t22 = "@null";
                objArr3[1] = t22;
                Log.i("FunctionMsg.FunctionMsgQueue", "[add] add task[%s] old Task[%s]", objArr2);
                this.heS.add(dVar);
                String Vk2 = dVar.heU.Vk();
                p.g(Vk2, "task.mItem.functionMsgId");
                this.mMap.put(Vk2, dVar);
                x xVar2 = x.SXb;
            } finally {
                AppMethodBeat.o(114116);
            }
        }
    }

    public final void loop() {
        AppMethodBeat.i(114117);
        synchronized (this.lock) {
            try {
                Log.i("FunctionMsg.FunctionMsgQueue", "[loop] size:" + this.heS.size());
                ListIterator<d> listIterator = this.heS.listIterator();
                p.g(listIterator, "mList.listIterator()");
                while (listIterator.hasNext()) {
                    d next = listIterator.next();
                    p.g(next, "iterator.next()");
                    d dVar = next;
                    if (dVar.heU.Vq() <= cl.aWy() / 1000) {
                        listIterator.remove();
                        this.mMap.remove(dVar.heU.Vk());
                        e eVar = this.heK;
                        p.h(dVar, "task");
                        eVar.heW.a(dVar.dKp, dVar);
                    }
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(114117);
            }
        }
    }
}
