package com.tencent.mm.loader.g;

import com.tencent.mm.loader.g.a.f;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\n\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u0018J\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "", "name", "", "(Ljava/lang/String;)V", "increment", "Ljava/util/concurrent/atomic/AtomicInteger;", "isRunningTask", "", "postCallback", "com/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/SingleTask;", "token", "", "getToken", "()I", "setToken", "(I)V", "waitingTask", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "checkNextTask", "", "clean", "postTask", "task", "postTaskOfHead", "reset", "start", "stop", "Companion", "libimageloader_release"})
public final class i {
    public static final a ibs = new a((byte) 0);
    private d<h> ibn = new d<>(new f(new com.tencent.mm.loader.g.a.a(1), new g(1, (byte) 0), 1, "SingleTaskExecutor"));
    public ConcurrentLinkedDeque<h> ibo = new ConcurrentLinkedDeque<>();
    public boolean ibp;
    private final AtomicInteger ibq = new AtomicInteger(0);
    private final b ibr = new b(this);
    public final String name;
    public int token = this.ibq.get();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/loader/loader/SingleTaskExecutor$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public i(String str) {
        p.h(str, "name");
        this.name = str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/SingleTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "libimageloader_release"})
    public static final class b implements f<h> {
        final /* synthetic */ i ibt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(i iVar) {
            this.ibt = iVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(h hVar, j jVar) {
            p.h(hVar, "task");
            p.h(jVar, "status");
            Log.i("Loader.SingleTaskExecutor", "[onLoaderFin] name=" + this.ibt.name + " status=" + jVar);
            this.ibt.ibp = false;
            this.ibt.aKc();
        }
    }

    public final void start() {
        Log.i("Loader.SingleTaskExecutor", "[start] name=" + this.name);
        this.ibn.a(this.ibr);
    }

    public final void stop() {
        Log.i("Loader.SingleTaskExecutor", "[stop] name=" + this.name);
        this.ibn.b(this.ibr);
        this.ibn.clean();
        this.ibo.clear();
        this.ibp = false;
    }

    public final void clean() {
        Log.i("Loader.SingleTaskExecutor", "[clean] name=" + this.name);
        this.ibo.clear();
    }

    public final void reset() {
        this.token = this.ibq.incrementAndGet();
        Log.i("Loader.SingleTaskExecutor", "[reset] name=" + this.name);
        this.ibn.clean();
        this.ibo.clear();
        this.ibp = false;
    }

    public final void a(h hVar) {
        p.h(hVar, "task");
        Log.i("Loader.SingleTaskExecutor", "[postTask] name=" + this.name + " isRunningTask=" + this.ibp + " task=" + hVar);
        hVar.token = this.token;
        this.ibo.add(hVar);
        aKc();
    }

    public final synchronized void aKc() {
        h poll;
        Log.i("Loader.SingleTaskExecutor", "[checkNextTask] name=" + this.name + " isRunningTask=" + this.ibp + " waitSize=" + this.ibo.size());
        if (!this.ibp && (poll = this.ibo.poll()) != null) {
            this.ibn.c(poll);
            this.ibp = true;
        }
    }
}
