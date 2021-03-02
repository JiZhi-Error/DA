package com.tencent.mm.plugin.byp;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.a.at;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.byp.a;
import com.tencent.mm.plugin.byp.b.f;
import com.tencent.mm.protocal.protobuf.ss;
import com.tencent.mm.protocal.protobuf.sw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\bJ0\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/byp/BypSyncCore;", "", "()V", "bypDispatcher", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "bysSyncHandlers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/byp/api/IBypSyncHandler;", "getBysSyncHandlers", "()Ljava/util/concurrent/ConcurrentHashMap;", "newSyncEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNewSyncEvent;", "getNewSyncEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "serialExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "addSyncHandler", "", "bizSyncKeyType", "handler", "doSync", "selector", "", "source", "Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "isContinue", "", "retryCount", "removeSyncHandler", "Companion", "SyncSource", "plugin-byp_release"})
public final class c {
    public static final a pPb = new a((byte) 0);
    final ConcurrentHashMap<Integer, com.tencent.mm.plugin.byp.a.b> pOX = new ConcurrentHashMap<>();
    final IListener<at> pOY = new e(this);
    private final i pOZ;
    private final MMHandler pPa;

    static {
        AppMethodBeat.i(199097);
        AppMethodBeat.o(199097);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "singleTask", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<h, x> {
        final /* synthetic */ c pPj;
        final /* synthetic */ List pPk;
        final /* synthetic */ b pPl;
        final /* synthetic */ boolean pPm;
        final /* synthetic */ int pPn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(c cVar, List list, b bVar, boolean z, int i2) {
            super(1);
            this.pPj = cVar;
            this.pPk = list;
            this.pPl = bVar;
            this.pPm = z;
            this.pPn = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(h hVar) {
            AppMethodBeat.i(199092);
            final h hVar2 = hVar;
            p.h(hVar2, "singleTask");
            new f(this.pPk, this.pPl).aYI().j(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.byp.c.d.AnonymousClass1 */
                final /* synthetic */ d pPo;

                {
                    this.pPo = r1;
                }

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(199091);
                    c.a aVar = (c.a) obj;
                    try {
                        boolean aUh = z.aUh();
                        if (aUh) {
                            Log.w("Byp.BypSyncCore", "[doSync#CallBack] selector=" + this.pPo.pPk + " source=" + this.pPo.pPl + " isContinue=" + this.pPo.pPm + " retryCount=" + this.pPo.pPn + " isExDeviceEnv=" + aUh);
                            hVar2.a(j.OK);
                        } else {
                            if (aVar.errType == 0 && aVar.errCode == 0) {
                                LinkedList<Integer> linkedList = ((sw) aVar.iLC).LaO;
                                p.g(linkedList, "it.resp.resp_continue_flag");
                                if (!linkedList.isEmpty()) {
                                    c cVar = this.pPo.pPj;
                                    LinkedList<Integer> linkedList2 = ((sw) aVar.iLC).LaO;
                                    p.g(linkedList2, "it.resp.resp_continue_flag");
                                    c.a(cVar, linkedList2, b.CONTINUE, true, 8);
                                }
                                this.pPo.pPj.pPa.sendMessage(this.pPo.pPj.pPa.obtainMessage(1, ((sw) aVar.iLC).LaQ));
                            } else {
                                if (aVar.errType != 3) {
                                    this.pPo.pPj.a(this.pPo.pPk, b.RETRY, false, this.pPo.pPn + 1);
                                }
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(20845, Integer.valueOf(aVar.errType), 1, aVar.errType + ':' + aVar.errCode + ':' + aVar.errMsg, 1);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1465, 100, 1);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1465, 100 + ((long) aVar.errType), 1);
                            }
                            hVar2.a(j.OK);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(199091);
                        return xVar;
                    } catch (Throwable th) {
                        hVar2.a(j.OK);
                        AppMethodBeat.o(199091);
                        throw th;
                    }
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(199092);
            return xVar;
        }
    }

    public c() {
        AppMethodBeat.i(199096);
        i iVar = new i("BypSyncExecutor");
        iVar.start();
        this.pOZ = iVar;
        this.pPa = new MMHandler("BypDispatcher", new C0900c(this));
        AppMethodBeat.o(199096);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/byp/BypSyncCore$Companion;", "", "()V", "BYP_DISPATCHER", "", "BYP_SYNC_EXECUTOR", "RETRY_LIMIT_COUNT", "", "TAG", "WHAT_DISPATCH_SYNC_RESULT", "plugin-byp_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "AUTO_AUTH", "NEW_SYNC", "NOTIFY", "CONTINUE", "RETRY", "plugin-byp_release"})
    public enum b {
        DEFAULT(0),
        AUTO_AUTH(1),
        NEW_SYNC(2),
        NOTIFY(3),
        CONTINUE(4),
        RETRY(5);
        
        public final int value;

        public static b valueOf(String str) {
            AppMethodBeat.i(199089);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(199089);
            return bVar;
        }

        private b(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(199087);
            AppMethodBeat.o(199087);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/byp/BypSyncCore$newSyncEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNewSyncEvent;", "callback", "", "event", "plugin-byp_release"})
    public static final class e extends IListener<at> {
        final /* synthetic */ c pPj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(c cVar) {
            this.pPj = cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(at atVar) {
            AppMethodBeat.i(199093);
            c cVar = this.pPj;
            a.C0898a aVar = a.C0898a.pOV;
            c.a(cVar, a.C0898a.crQ(), b.NEW_SYNC, false, 12);
            AppMethodBeat.o(199093);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/byp/BypSyncCore$bypDispatcher$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler$Callback;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-byp_release"})
    /* renamed from: com.tencent.mm.plugin.byp.c$c  reason: collision with other inner class name */
    public static final class C0900c implements MMHandler.Callback {
        final /* synthetic */ c pPj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0900c(c cVar) {
            this.pPj = cVar;
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(199090);
            p.h(message, "msg");
            if (message.what == 1) {
                Object obj = message.obj;
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.BypSyncItem>");
                    AppMethodBeat.o(199090);
                    throw tVar;
                }
                LinkedList<ss> linkedList = (LinkedList) obj;
                Log.i("Byp.BypSyncCore", "[WHAT_DISPATCH_SYNC_RESULT] list=" + linkedList.size());
                HashMap hashMap = new HashMap();
                for (ss ssVar : linkedList) {
                    LinkedList linkedList2 = (LinkedList) hashMap.get(Integer.valueOf(ssVar.LaJ));
                    if (linkedList2 == null) {
                        LinkedList linkedList3 = new LinkedList();
                        hashMap.put(Integer.valueOf(ssVar.LaJ), linkedList3);
                        linkedList2 = linkedList3;
                    }
                    p.g(linkedList2, "map[it.sync_key_type] ?:…ist\n                    }");
                    linkedList2.add(ssVar);
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    com.tencent.mm.plugin.byp.a.b bVar = this.pPj.pOX.get(entry.getKey());
                    if (bVar != null) {
                        bVar.O((LinkedList) entry.getValue());
                    }
                }
                AppMethodBeat.o(199090);
                return true;
            }
            AppMethodBeat.o(199090);
            return false;
        }
    }

    public static /* synthetic */ void a(c cVar, List list, b bVar, boolean z, int i2) {
        AppMethodBeat.i(199095);
        if ((i2 & 4) != 0) {
            z = false;
        }
        cVar.a(list, bVar, z, 0);
        AppMethodBeat.o(199095);
    }

    public final void a(List<Integer> list, b bVar, boolean z, int i2) {
        AppMethodBeat.i(199094);
        p.h(list, "selector");
        p.h(bVar, "source");
        boolean aUh = z.aUh();
        Log.i("Byp.BypSyncCore", "[doSync] selector=" + list + " source=" + bVar + " isContinue=" + z + " retryCount=" + i2 + " isExDeviceEnv=" + aUh);
        if (aUh) {
            AppMethodBeat.o(199094);
        } else if (i2 >= 3) {
            Log.e("Byp.BypSyncCore", "[doSync] over limit retry count[" + i2 + "] limit=3");
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1465, 130, 1);
            AppMethodBeat.o(199094);
        } else {
            h hVar = new h(new d(this, list, bVar, z, i2));
            if (z) {
                i iVar = this.pOZ;
                p.h(hVar, "task");
                Log.i("Loader.SingleTaskExecutor", "[postTask] name=" + iVar.name + " isRunningTask=" + iVar.ibp + " task=" + hVar);
                hVar.token = iVar.token;
                iVar.ibo.addFirst(hVar);
                iVar.aKc();
                AppMethodBeat.o(199094);
                return;
            }
            this.pOZ.a(hVar);
            AppMethodBeat.o(199094);
        }
    }
}
