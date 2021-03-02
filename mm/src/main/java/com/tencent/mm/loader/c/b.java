package com.tencent.mm.loader.c;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.mm.loader.b.a.d;
import com.tencent.mm.loader.b.b.c;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.e.f;
import com.tencent.mm.loader.e.h;
import com.tencent.mm.loader.f.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J \u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010&J\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010(J\"\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nJ&\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bJ \u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006J\u001a\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u00100\u001a\u00020\fJ\u001a\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u00102\u001a\u00020\u0018J\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u00104\u001a\u00020\u0010J\u001a\u00105\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u00106\u001a\u00020\u0012J&\u00107\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016J \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cJ\u001a\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u00109\u001a\u00020\u000eJ\u001a\u0010:\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010;\u001a\u00020\u0014J\"\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX.¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, hxF = {"Lcom/tencent/mm/loader/cfg/Builder;", "T", "R", "", "()V", "builder_dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "builder_diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "builder_imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "builder_imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "builder_imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "builder_imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "builder_imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "builder_imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "builder_memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "headHeadResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "imageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "appendResourceTranscoder", "transcoder", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "build", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "setImageBatchGet", "batchFetcher", "setImageDiskCache", "cache", "setImageDownloader", "downloader", "setImageFileBrokenCallback", "fileBrokenCallback", "setImageFileNameCreator", "creater", "setImageLoaderOptions", "options", "setImageMd5Checker", "md5checker", "setImageMemoryCache", "setImageReport", "report", "setImageRetryListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setLoaderWorkTask", "task", "libimageloader_release"})
public class b<T, R> {
    e hYW = e.b.aJU();
    com.tencent.mm.loader.b.b.e<T, R> hYX = new c();
    d<T, R> hYY;
    com.tencent.mm.loader.d.b<T> hYZ;
    public com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hYm;
    g hZa = new com.tencent.mm.loader.e.a();
    protected com.tencent.mm.loader.d.d<R> hZb;
    com.tencent.mm.loader.e.c.a<R> hZc;
    com.tencent.mm.loader.d.e hZd = new f();
    com.tencent.mm.loader.d.c hZe;
    com.tencent.mm.loader.f.b hZf = new com.tencent.mm.loader.e.c();
    com.tencent.mm.loader.f.f hZg = new h();
    com.tencent.mm.loader.d.a<T> hZh;

    public b() {
        e.b bVar = e.hZH;
    }

    /* access modifiers changed from: protected */
    public final void a(com.tencent.mm.loader.d.d<R> dVar) {
        p.h(dVar, "<set-?>");
        this.hZb = dVar;
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.loader.d.d<R> aJD() {
        com.tencent.mm.loader.d.d<R> dVar = this.hZb;
        if (dVar == null) {
            p.btv("imageProducer");
        }
        return dVar;
    }

    public final b<T, R> b(com.tencent.mm.loader.d.d<R> dVar) {
        p.h(dVar, "imageProducer");
        this.hZb = dVar;
        return this;
    }

    public final b<T, R> b(com.tencent.mm.loader.e.c.b<R> bVar) {
        p.h(bVar, "transcoder");
        if (this.hZc == null) {
            this.hZc = new com.tencent.mm.loader.e.c.a<>(bVar);
        } else {
            com.tencent.mm.loader.e.c.a<R> aVar = this.hZc;
            if (aVar != null) {
                aVar.c(bVar);
            }
        }
        return this;
    }

    public final b<T, R> b(e eVar) {
        p.h(eVar, "options");
        this.hYW = eVar;
        return this;
    }

    public final b<T, R> a(com.tencent.mm.loader.b.b.e<T, R> eVar) {
        p.h(eVar, "cache");
        this.hYX = eVar;
        return this;
    }

    public final b<T, R> a(d<T, R> dVar) {
        p.h(dVar, "cache");
        this.hYY = dVar;
        return this;
    }

    public final b<T, R> a(com.tencent.mm.loader.d.b<T> bVar) {
        p.h(bVar, "downloader");
        this.hYZ = bVar;
        return this;
    }

    public final b<T, R> a(g gVar) {
        p.h(gVar, "creater");
        this.hZa = gVar;
        return this;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R \u00108\u001a\b\u0012\u0004\u0012\u00028\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010P\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR&\u0010W\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010XX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\¨\u0006]"}, hxF = {"com/tencent/mm/loader/cfg/Builder$build$1", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "dataFetcher", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getDataFetcher", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setDataFetcher", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getHeadResourceTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setHeadResourceTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getImageBatchGet", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setImageBatchGet", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "getImageDownloadTaskExecutor", "()Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "setImageDownloadTaskExecutor", "(Lcom/tencent/mm/loader/common/IImageLoaderExecutor;)V", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setImageLoaderOptions", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getImageMd5CheckListener", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setImageMd5CheckListener", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "imageResourceProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getImageResourceProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setImageResourceProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "getImageTempFileCleanExecutor", "()Ljava/util/concurrent/Executor;", "setImageTempFileCleanExecutor", "(Ljava/util/concurrent/Executor;)V", "loadFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getLoadFileNameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setLoadFileNameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "loaderTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getLoaderTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setLoaderTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "libimageloader_release"})
    public static final class a implements d<T, R> {
        private com.tencent.mm.loader.b.b.e<T, R> hZi;
        private d<T, R> hZj;
        private com.tencent.mm.loader.d.b<T> hZk;
        private com.tencent.mm.loader.d.d<R> hZl;
        private g hZm;
        private com.tencent.mm.loader.e.c.a<R> hZn;
        private e hZo;
        private com.tencent.mm.loader.f.f hZp;
        private com.tencent.mm.loader.d.c hZq;
        private com.tencent.mm.loader.f.b hZr;
        private com.tencent.mm.loader.d.e hZs;
        private com.tencent.mm.loader.d.a<T> hZt;
        private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hZu;
        final /* synthetic */ b hZv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(b bVar) {
            this.hZv = bVar;
            this.hZi = bVar.hYX;
            d<T, R> dVar = bVar.hYY;
            if (dVar == null) {
                p.btv("builder_diskCache");
            }
            this.hZj = dVar;
            com.tencent.mm.loader.d.b<T> bVar2 = bVar.hYZ;
            if (bVar2 == null) {
                p.btv("builder_dataFetcher");
            }
            this.hZk = bVar2;
            this.hZl = bVar.aJD();
            this.hZm = bVar.hZa;
            this.hZn = bVar.hZc;
            this.hZo = bVar.hYW;
            this.hZp = bVar.hZg;
            this.hZq = bVar.hZe;
            this.hZr = bVar.hZf;
            this.hZs = bVar.hZd;
            this.hZt = bVar.hZh;
            this.hZu = bVar.hYm;
        }

        @Override // com.tencent.mm.loader.c.d
        public final com.tencent.mm.loader.b.b.e<T, R> aJF() {
            return this.hZi;
        }

        @Override // com.tencent.mm.loader.c.d
        public final d<T, R> aJG() {
            return this.hZj;
        }

        @Override // com.tencent.mm.loader.c.d
        public final com.tencent.mm.loader.d.b<T> aJH() {
            return this.hZk;
        }

        @Override // com.tencent.mm.loader.c.d
        public final com.tencent.mm.loader.d.d<R> aJI() {
            return this.hZl;
        }

        @Override // com.tencent.mm.loader.c.d
        public final g aJJ() {
            return this.hZm;
        }

        @Override // com.tencent.mm.loader.c.d
        public final com.tencent.mm.loader.e.c.a<R> aJK() {
            return this.hZn;
        }

        @Override // com.tencent.mm.loader.c.d
        public final e aJL() {
            return this.hZo;
        }

        @Override // com.tencent.mm.loader.c.d
        public final com.tencent.mm.loader.f.f aJM() {
            return this.hZp;
        }

        @Override // com.tencent.mm.loader.c.d
        public final com.tencent.mm.loader.d.c aJN() {
            return this.hZq;
        }

        @Override // com.tencent.mm.loader.c.d
        public final com.tencent.mm.loader.f.b aJO() {
            return this.hZr;
        }

        @Override // com.tencent.mm.loader.c.d
        public final com.tencent.mm.loader.d.e aJP() {
            return this.hZs;
        }

        @Override // com.tencent.mm.loader.c.d
        public final com.tencent.mm.loader.d.a<T> aJQ() {
            return this.hZt;
        }

        @Override // com.tencent.mm.loader.c.d
        public final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> aJR() {
            return this.hZu;
        }
    }

    public final d<T, R> aJE() {
        return new a(this);
    }
}
