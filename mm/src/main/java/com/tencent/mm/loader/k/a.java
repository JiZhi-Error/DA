package com.tencent.mm.loader.k;

import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.d.b;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 3*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u000234B5\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0002\u0010\nJ\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010%H\u0002J\u001e\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010%H\u0014J\u001e\u0010)\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010%H\u0002J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010+H\u0002J$\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010-2\n\u0010.\u001a\u0006\u0012\u0002\b\u00030/2\u0006\u00100\u001a\u000201H\u0002J,\u00102\u001a\u00020!2\f\u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u00010/2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010%H\u0002R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00065"}, hxF = {"Lcom/tencent/mm/loader/task/ImageLoadWorkTask;", "T", "R", "Lcom/tencent/mm/loader/task/LoadTask;", "_url", "Lcom/tencent/mm/loader/model/data/DataItem;", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Lcom/tencent/mm/loader/Reaper;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache$libimageloader_release", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache$libimageloader_release", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "isLocalFile", "", "()Z", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache$libimageloader_release", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache$libimageloader_release", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "producer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getProducer$libimageloader_release", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setProducer$libimageloader_release", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "batchGet", "", "readNetworkStart", "", "taskListener", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "execute", "fileType", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "executeTask", "loadFromDisk", "Lcom/tencent/mm/loader/model/LoadResult;", "producerThenCommitDisk", "Lcom/tencent/mm/loader/task/ImageLoadWorkTask$LazyTask;", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "whenDataReady", "Companion", "LazyTask", "libimageloader_release"})
public final class a<T, R> extends b<T, R> {
    public static final C0407a icE = new C0407a((byte) 0);
    private com.tencent.mm.loader.b.b.e<T, R> hZi = this.icR.hYd;
    private com.tencent.mm.loader.b.a.d<T, R> hZj = this.icR.hYe;
    private com.tencent.mm.loader.d.d<R> icD = this.icR.hYi;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "R", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        public static final e icP = new e();

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(com.tencent.mm.loader.h.a.a<T> aVar, com.tencent.mm.loader.e.b.d<R> dVar, f<T, R> fVar) {
        super(aVar, dVar, fVar);
        p.h(aVar, "_url");
        p.h(dVar, "target");
        p.h(fVar, "reaper");
    }

    private final boolean aLK() {
        if (this.iaG == null) {
            return false;
        }
        if (com.tencent.mm.loader.l.a.e(this.iaG)) {
            return true;
        }
        return this.icR.hXX.hZy == e.c.FILE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006d, code lost:
        if (r5 == null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0082, code lost:
        if (r3 == null) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b8, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b9, code lost:
        r4 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d8, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d9, code lost:
        r3 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.tencent.mm.loader.h.c<R> aLL() {
        /*
        // Method dump skipped, instructions count: 219
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.loader.k.a.aLL():com.tencent.mm.loader.h.c");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B#\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/loader/task/ImageLoadWorkTask$LazyTask;", "R", "", "result", "Lcom/tencent/mm/loader/model/Resource;", "block", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/loader/model/Resource;Lkotlin/jvm/functions/Function0;)V", "getBlock", "()Lkotlin/jvm/functions/Function0;", "getResult", "()Lcom/tencent/mm/loader/model/Resource;", "setResult", "(Lcom/tencent/mm/loader/model/Resource;)V", "commit", "libimageloader_release"})
    public static final class b<R> {
        com.tencent.mm.loader.h.e<R> icF;
        final kotlin.g.a.a<x> icG;

        public b(com.tencent.mm.loader.h.e<R> eVar, kotlin.g.a.a<x> aVar) {
            p.h(aVar, "block");
            this.icF = eVar;
            this.icG = aVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00d8, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00d9, code lost:
        r9 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00de, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00df, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041 A[Catch:{ all -> 0x00de, all -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044 A[Catch:{ all -> 0x00de, all -> 0x00d8 }, EDGE_INSN: B:74:0x0044->B:19:0x0044 ?: BREAK  ] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0091 A[LOOP:1: B:41:0x0091->B:49:0x00a4, LOOP_START, PHI: r1 
      PHI: (r1v26 com.tencent.mm.loader.e.c.b<?>) = (r1v25 com.tencent.mm.loader.e.c.b<?>), (r1v28 com.tencent.mm.loader.e.c.b<?>) binds: [B:18:0x0042, B:49:0x00a4] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.tencent.mm.loader.k.a.b<R> a(com.tencent.mm.loader.h.f<?> r12, com.tencent.mm.loader.h.b.a r13) {
        /*
        // Method dump skipped, instructions count: 225
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.loader.k.a.a(com.tencent.mm.loader.h.f, com.tencent.mm.loader.h.b.a):com.tencent.mm.loader.k.a$b");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fe, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ff, code lost:
        r4 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0133, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0134, code lost:
        r3 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(com.tencent.mm.loader.h.f<?> r12, com.tencent.mm.loader.k.b.a<R> r13) {
        /*
        // Method dump skipped, instructions count: 319
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.loader.k.a.a(com.tencent.mm.loader.h.f, com.tencent.mm.loader.k.b$a):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b¸\u0006\t"}, hxF = {"com/tencent/mm/loader/task/ImageLoadWorkTask$executeTask$1$1$1", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release", "com/tencent/mm/loader/task/ImageLoadWorkTask$$special$$inlined$also$lambda$1"})
    public static final class c implements b.a {
        final /* synthetic */ f icH;
        final /* synthetic */ long icI;
        final /* synthetic */ a icJ;
        final /* synthetic */ e.c icK;
        final /* synthetic */ b.a icL;

        c(f fVar, long j2, a aVar, e.c cVar, b.a aVar2) {
            this.icH = fVar;
            this.icI = j2;
            this.icJ = aVar;
            this.icK = cVar;
            this.icL = aVar2;
        }

        @Override // com.tencent.mm.loader.d.b.a
        public final void a(com.tencent.mm.loader.h.f<?> fVar) {
            p.h(fVar, "resp");
            this.icJ.a((a) fVar, (com.tencent.mm.loader.h.f) this.icL);
        }

        @Override // com.tencent.mm.loader.d.b.a
        public final void onError() {
            this.icJ.a((a) null, (com.tencent.mm.loader.h.f) this.icL);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/loader/task/ImageLoadWorkTask$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.k.a$a  reason: collision with other inner class name */
    public static final class C0407a {
        private C0407a() {
        }

        public /* synthetic */ C0407a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0007"}, hxF = {"<anonymous>", "", "T", "R", "invoke", "com/tencent/mm/loader/task/ImageLoadWorkTask$producerThenCommitDisk$1$1$1$2", "com/tencent/mm/loader/task/ImageLoadWorkTask$$special$$inlined$let$lambda$1", "com/tencent/mm/loader/task/ImageLoadWorkTask$$special$$inlined$use$lambda$1"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f icH;
        final /* synthetic */ a icJ;
        final /* synthetic */ com.tencent.mm.loader.h.e icM;
        final /* synthetic */ com.tencent.mm.loader.h.b.a icN;
        final /* synthetic */ com.tencent.mm.loader.h.f icO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(com.tencent.mm.loader.h.e eVar, f fVar, a aVar, com.tencent.mm.loader.h.b.a aVar2, com.tencent.mm.loader.h.f fVar2) {
            super(0);
            this.icM = eVar;
            this.icH = fVar;
            this.icJ = aVar;
            this.icN = aVar2;
            this.icO = fVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            this.icJ.a(this.icO, this.icM, null, this.icJ);
            return x.SXb;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.loader.k.b
    public final void a(e.c cVar, b.a<R> aVar) {
        boolean z = true;
        p.h(cVar, "fileType");
        p.h(aVar, "taskListener");
        try {
            System.currentTimeMillis();
            Log.i("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from disk. key:" + this.iaG + " fileType " + cVar + " [width:" + this.hYt + ".weakHolder.viewWidth height:" + this.hYt + ".weakHolder.viewHeight] diskCache " + this.hZj + " producer " + this.icD + " isLocalFile: " + aLK());
            com.tencent.mm.loader.h.c<R> aLL = aLL();
            if (aLK() || aLL.value != null) {
                z = false;
            }
            Log.i("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from disk. done result resultData " + aLL + " bitmap " + ((Object) aLL.value) + " isNeedDownload " + z);
            if (!z) {
                aVar.d(aLL);
                return;
            }
            f<T, R> fVar = this.icR;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                Log.d("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from memory failed.now try to get from network. " + this.iaG + " fileType: " + cVar);
                if (fVar.hYb != null) {
                    fVar.aJt();
                }
                com.tencent.mm.loader.d.b<T> bVar = fVar.hYc;
                if (!fVar.hYh.b(this.iaG)) {
                    bVar = null;
                }
                if (bVar == null) {
                    a((com.tencent.mm.loader.h.f<?>) null, aVar);
                    Log.i("MicroMsg.Loader.ImageLoadWorkTask", "can not download image, over limit " + this.iaG);
                    return;
                }
                com.tencent.mm.loader.d.b<T> bVar2 = fVar.hYc;
                com.tencent.mm.loader.h.a.a<T> aVar2 = this.iaG;
                g gVar = fVar.hYo;
                com.tencent.mm.loader.g.b bVar3 = this.iaV;
                if (bVar3 == null) {
                    p.btv("loader");
                }
                c cVar2 = new c(fVar, currentTimeMillis, this, cVar, aVar);
                p.h(aVar2, "url");
                p.h(gVar, "fileNameCreator");
                p.h(bVar3, "loader");
                p.h(cVar2, "callback");
                bVar3.D(new b.c(bVar2, bVar3, aVar2, gVar, cVar2));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Loader.ImageLoadWorkTask", e2, "[ImageLoader DownLoadException] run error %s [debug info %s]", this.iaG, fVar.hYu);
                x xVar = x.SXb;
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.Loader.ImageLoadWorkTask", e3, "[ImageLoader execute] " + e3.getMessage() + " run error " + this.iaG + " [debug info " + this.hYu + ']', new Object[0]);
            aVar.aLM();
        }
    }
}
