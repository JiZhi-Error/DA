package com.tencent.mm.loader.k;

import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.e.b.d;
import com.tencent.mm.loader.e.b.e;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001;B5\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0002\u0010\nJD\u0010$\u001a\u00020%2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010)2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010)2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000J\b\u0010,\u001a\u00020%H\u0016J\b\u0010-\u001a\u00020%H\u0002J\u001e\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000102H$J\u000e\u00103\u001a\u00020%2\u0006\u00104\u001a\u000205J\u0018\u00106\u001a\u00020%2\u000e\u00107\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u000108H\u0004J\u0016\u00109\u001a\u00020%2\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u000108H\u0004J\b\u0010:\u001a\u00020\u0010H\u0016R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006<"}, hxF = {"Lcom/tencent/mm/loader/task/LoadTask;", "T", "R", "Lcom/tencent/mm/loader/loader/IWorkTask;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "REAPER", "Lcom/tencent/mm/loader/Reaper;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Lcom/tencent/mm/loader/Reaper;)V", "getREAPER", "()Lcom/tencent/mm/loader/Reaper;", "setREAPER", "(Lcom/tencent/mm/loader/Reaper;)V", "TAG", "", "debugInfo", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "taskStatus", "Lcom/tencent/mm/loader/loader/WorkStatus;", "getTaskStatus", "()Lcom/tencent/mm/loader/loader/WorkStatus;", "setTaskStatus", "(Lcom/tencent/mm/loader/loader/WorkStatus;)V", "getUrl", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUrl", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "cacheImageToDisk", "", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/Resource;", "resource", "task", "call", "debugCheck", "execute", "fileType", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "taskListener", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "reportReadCacheTime", "time", "", "taskEnd", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "taskEndBefore", "uniqueId", "ITask", "libimageloader_release"})
public abstract class b<T, R> extends c {
    final String TAG = "MicroMsg.Loader.ImageLoader.ImageLoadTask";
    d<R> hYt;
    public String hYu;
    com.tencent.mm.loader.h.a.a<T> iaG;
    j icQ = j.Init;
    f<T, R> icR;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006H&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/loader/task/LoadTask$ITask;", "RR", "", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskRemove", "ontaskLoadFin", "libimageloader_release"})
    public interface a<RR> {
        void aLM();

        void c(com.tencent.mm.loader.h.c<RR> cVar);

        void d(com.tencent.mm.loader.h.c<RR> cVar);
    }

    /* access modifiers changed from: protected */
    public abstract void a(e.c cVar, a<R> aVar);

    public b(com.tencent.mm.loader.h.a.a<T> aVar, d<R> dVar, f<T, R> fVar) {
        p.h(aVar, "url");
        p.h(dVar, "target");
        p.h(fVar, "REAPER");
        this.iaG = aVar;
        this.hYt = dVar;
        this.icR = fVar;
    }

    public final void b(j jVar) {
        p.h(jVar, "<set-?>");
        this.icQ = jVar;
    }

    @Override // com.tencent.mm.loader.g.c
    public final void call() {
        System.currentTimeMillis();
        a(this.icR.hXX.hZy, new C0408b(this));
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/loader/task/LoadTask$call$1", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskRemove", "ontaskLoadFin", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.k.b$b  reason: collision with other inner class name */
    public static final class C0408b implements a<R> {
        final /* synthetic */ b icS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0408b(b bVar) {
            this.icS = bVar;
        }

        @Override // com.tencent.mm.loader.k.b.a
        public final void d(com.tencent.mm.loader.h.c<R> cVar) {
            p.h(cVar, "resultData");
            this.icS.b(j.OK);
            this.icS.b(cVar);
            if ((cVar.isValid() ? cVar : null) != null) {
                Log.i(this.icS.TAG, "[ImageLoader] ontaskLoadFin. get bitmap successs. " + this.icS.iaG + ' ' + ((Object) cVar.value));
                e.a aVar = com.tencent.mm.loader.e.b.e.iay;
                e.a.aJX().a((com.tencent.mm.loader.h.a.a<?>) this.icS.iaG, (com.tencent.mm.loader.h.c) cVar);
            }
            this.icS.a(cVar);
            this.icS.a(this.icS.icQ);
        }

        @Override // com.tencent.mm.loader.k.b.a
        public final void c(com.tencent.mm.loader.h.c<R> cVar) {
            p.h(cVar, "resultData");
            this.icS.b(j.OK);
            this.icS.b(cVar);
            if ((cVar.isValid() ? cVar : null) != null) {
                Log.i(this.icS.TAG, "[ImageLoader] onTaskDownFin. get bitmap successs. " + this.icS.iaG + ' ' + ((Object) cVar.value));
                e.a aVar = com.tencent.mm.loader.e.b.e.iay;
                e.a.aJX().a((com.tencent.mm.loader.h.a.a<?>) this.icS.iaG, (com.tencent.mm.loader.h.c) cVar);
            }
            this.icS.a(cVar);
            this.icS.a(this.icS.icQ);
        }

        @Override // com.tencent.mm.loader.k.b.a
        public final void aLM() {
            this.icS.b(j.Fail);
            Log.i(this.icS.TAG, "onTaskFail " + this.icS.iaG);
            this.icS.a(this.icS.icQ);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(com.tencent.mm.loader.h.c<R> cVar) {
        R r;
        f<T, R> fVar = this.icR;
        if (fVar.hYb != null) {
            fVar.aJt();
        }
        com.tencent.mm.loader.f.e<T, R> eVar = fVar.hXY;
        com.tencent.mm.loader.h.a.a<T> aVar = this.iaG;
        g<?> gVar = fVar.aJt().ias;
        if (cVar != null) {
            r = cVar.value;
        } else {
            r = null;
        }
        eVar.a(aVar, gVar, r);
    }

    /* access modifiers changed from: protected */
    public final void b(com.tencent.mm.loader.h.c<R> cVar) {
        com.tencent.mm.loader.f.d dVar;
        p.h(cVar, "resultData");
        f<T, R> fVar = this.icR;
        if (!cVar.isValid()) {
            cVar = null;
        }
        if (cVar != null && (dVar = fVar.hXZ) != null) {
            dVar.a(fVar.aJt().ias);
        }
    }

    public final void a(com.tencent.mm.loader.h.f<?> fVar, com.tencent.mm.loader.h.e<R> eVar, com.tencent.mm.loader.h.e<R> eVar2, b<T, R> bVar) {
        p.h(fVar, "httpResponse");
        p.h(eVar, "source");
        p.h(bVar, "task");
        if (this.icR.hXX.hZx) {
            this.icR.hYe.a(this.iaG, fVar, eVar, eVar2, this.icR.hXX, this.icR);
        }
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        String aVar = this.iaG.toString();
        p.g(aVar, "url.toString()");
        return aVar;
    }
}
