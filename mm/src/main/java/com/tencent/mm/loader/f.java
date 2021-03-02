package com.tencent.mm.loader;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.facebook.share.internal.ShareConstants;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.e.b.e;
import com.tencent.mm.loader.e.g;
import com.tencent.mm.loader.f.a;
import com.tencent.mm.loader.f.b;
import com.tencent.mm.loader.f.c;
import com.tencent.mm.loader.f.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ±\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0002±\u0001B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0002\u0010\bJ\n\u0010©\u0001\u001a\u00030ª\u0001H\u0002J\u001c\u0010«\u0001\u001a\u00030ª\u00012\u0010\u0010¬\u0001\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030­\u0001H\u0002J\b\u0010®\u0001\u001a\u00030ª\u0001J\b\u0010¯\u0001\u001a\u00030ª\u0001J\n\u0010°\u0001\u001a\u00030ª\u0001H\u0002R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001a\u0010,\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u001a\u0010/\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R \u00105\u001a\b\u0012\u0002\b\u0003\u0018\u000106X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0011\u0010H\u001a\u00020I8F¢\u0006\u0006\u001a\u0004\bH\u0010JR\u0011\u0010K\u001a\u00020I8F¢\u0006\u0006\u001a\u0004\bK\u0010JR\"\u0010L\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SX\u0004¢\u0006\u0002\n\u0000R\"\u0010T\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010O\"\u0004\bV\u0010QR&\u0010W\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010XX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R \u0010]\u001a\b\u0012\u0004\u0012\u00028\u00000^X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001c\u0010c\u001a\u0004\u0018\u00010dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010i\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010jX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020pX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u0013\u0010u\u001a\u0004\u0018\u00010v¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u001d\u0010y\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010z¢\u0006\b\n\u0000\u001a\u0004\b{\u0010|R\u0012\u0010}\u001a\u00020~¢\u0006\t\n\u0000\u001a\u0005\b\u0010\u0001R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R,\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R&\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\u00020IX\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0001\u0010J\"\u0006\b\u0001\u0010\u0001R&\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0001X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R&\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000¤\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001¨\u0006²\u0001"}, hxF = {"Lcom/tencent/mm/loader/Reaper;", "T", "R", "", "builder", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/builder/RequestBuilder;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "batchFetcher", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getBatchFetcher", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setBatchFetcher", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "getBuilder", "()Lcom/tencent/mm/loader/builder/RequestBuilder;", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "defaultAnimation", "Landroid/view/animation/Animation;", "getDefaultAnimation", "()Landroid/view/animation/Animation;", "setDefaultAnimation", "(Landroid/view/animation/Animation;)V", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getDefaultBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setDefaultBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "defaultBackgroundResId", "", "getDefaultBackgroundResId", "()I", "setDefaultBackgroundResId", "(I)V", "defaultDrawable", "getDefaultDrawable", "setDefaultDrawable", "defaultResId", "getDefaultResId", "setDefaultResId", "filenameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getFilenameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setFilenameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "holder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "getHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setHolder", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "imageDownloadListener", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "getImageDownloadListener", "()Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "setImageDownloadListener", "(Lcom/tencent/mm/loader/listener/IImageDownloadListener;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getImageWorkTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setImageWorkTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "isShowDefaultBackground", "", "()Z", "isShowDefaultImage", "mDynamicTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getMDynamicTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setMDynamicTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "mEmptyImageLoaderListener", "Lcom/tencent/mm/loader/impr/IDefaultImageLoaderListener;", "mHeadTranscoder", "getMHeadTranscoder", "setMHeadTranscoder", "mImageDiskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getMImageDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setMImageDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "mImageDownloader", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getMImageDownloader", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setMImageDownloader", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "mImageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getMImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setMImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "mImageLoadListener", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "getMImageLoadListener", "()Lcom/tencent/mm/loader/listener/IImageLoadListener;", "setMImageLoadListener", "(Lcom/tencent/mm/loader/listener/IImageLoadListener;)V", "mImageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getMImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setMImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "mImageLoaderAnimation", "Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "getMImageLoaderAnimation", "()Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "mImageLoaderListener", "Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "getMImageLoaderListener", "()Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "mImageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getMImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mImageMD5Checker", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getMImageMD5Checker", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setMImageMD5Checker", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "mImageMemoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMImageMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMImageMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "mImageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getMImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setMImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "mImageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getMImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setMImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "onlyDownload", "getOnlyDownload", "setOnlyDownload", "(Z)V", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "uriValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "getUriValue", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUriValue", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "checkIfNeedInitExecutor", "", "doLoadImage", "task", "Lcom/tencent/mm/loader/task/LoadTask;", "download", "load", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Companion", "libimageloader_release"})
public final class f<T, R> {
    private static final String TAG = TAG;
    public static final a hYx = new a((byte) 0);
    private final g<T, R> hXV = new g<>();
    private com.tencent.mm.loader.e.b.g<?> hXW;
    public final e hXX;
    public final com.tencent.mm.loader.f.e<T, R> hXY;
    public final d hXZ;
    private com.tencent.mm.loader.f.f hYa;
    public c<T> hYb;
    public com.tencent.mm.loader.d.b<T> hYc;
    public com.tencent.mm.loader.b.b.e<T, R> hYd;
    public com.tencent.mm.loader.b.a.d<T, R> hYe;
    private com.tencent.mm.loader.d.c hYf;
    private b hYg;
    public com.tencent.mm.loader.d.e hYh;
    public com.tencent.mm.loader.d.d<R> hYi;
    public com.tencent.mm.loader.e.c.a<R> hYj;
    public com.tencent.mm.loader.e.c.a<R> hYk;
    public a hYl;
    private com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hYm;
    private com.tencent.mm.loader.d.a<T> hYn;
    public com.tencent.mm.loader.f.g hYo;
    public int hYp;
    private Animation hYq;
    public Drawable hYr;
    public com.tencent.mm.loader.h.a.a<T> hYs;
    public com.tencent.mm.loader.e.b.d<R> hYt;
    public String hYu;
    public boolean hYv;
    public final com.tencent.mm.loader.a.b<T, R> hYw;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "R", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ z.f hYA;
        final /* synthetic */ f hYy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(f fVar, z.f fVar2) {
            super(0);
            this.hYy = fVar;
            this.hYA = fVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            if (this.hYA.SYG != null) {
                if (this.hYA.SYG.value() != null) {
                    com.tencent.mm.loader.h.e aKq = this.hYA.SYG.aKq();
                    while (true) {
                        if (aKq == null) {
                            z = false;
                            break;
                        } else if (aKq.value() == null) {
                            z = true;
                            break;
                        } else {
                            aKq = aKq.aKq();
                            if (!(aKq instanceof com.tencent.mm.loader.h.e)) {
                                aKq = null;
                            }
                        }
                    }
                } else {
                    z = true;
                }
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    public f(com.tencent.mm.loader.a.b<T, R> bVar, com.tencent.mm.loader.c.d<T, R> dVar) {
        ColorDrawable drawable;
        p.h(bVar, "builder");
        p.h(dVar, "mImageLoaderConfiguration");
        this.hYw = bVar;
        e eVar = this.hYw.hXX;
        this.hXX = eVar == null ? dVar.aJL() : eVar;
        g<T, R> gVar = this.hYw.hXY;
        this.hXY = gVar == null ? this.hXV : gVar;
        this.hXZ = this.hYw.hXZ;
        com.tencent.mm.loader.f.f fVar = this.hYw.hYa;
        this.hYa = fVar == null ? dVar.aJM() : fVar;
        this.hYb = this.hYw.hYb;
        com.tencent.mm.loader.d.b<T> bVar2 = this.hYw.hYc;
        this.hYc = bVar2 == null ? dVar.aJH() : bVar2;
        com.tencent.mm.loader.b.b.e<T, R> eVar2 = this.hYw.hYd;
        this.hYd = eVar2 == null ? dVar.aJF() : eVar2;
        com.tencent.mm.loader.b.a.d<T, R> dVar2 = this.hYw.hYe;
        this.hYe = dVar2 == null ? dVar.aJG() : dVar2;
        com.tencent.mm.loader.d.c cVar = this.hYw.hYf;
        this.hYf = cVar == null ? dVar.aJN() : cVar;
        b bVar3 = this.hYw.hYg;
        this.hYg = bVar3 == null ? dVar.aJO() : bVar3;
        com.tencent.mm.loader.d.e eVar3 = this.hYw.hYh;
        this.hYh = eVar3 == null ? dVar.aJP() : eVar3;
        com.tencent.mm.loader.d.d<R> dVar3 = this.hYw.hYi;
        this.hYi = dVar3 == null ? dVar.aJI() : dVar3;
        com.tencent.mm.loader.e.c.a<R> aVar = this.hYw.hYj;
        this.hYj = aVar == null ? dVar.aJK() : aVar;
        this.hYk = this.hYw.hYk;
        this.hYl = this.hYw.hYl;
        com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> dVar4 = this.hYw.hYm;
        this.hYm = dVar4 == null ? dVar.aJR() : dVar4;
        this.hYn = dVar.aJQ();
        com.tencent.mm.loader.f.g gVar2 = this.hYw.hYo;
        this.hYo = gVar2 == null ? dVar.aJJ() : gVar2;
        this.hYp = this.hXX.hYp;
        this.hYq = this.hXX.hYq;
        e eVar4 = this.hXX;
        Resources resources = MMApplicationContext.getResources();
        p.g(resources, "MMApplicationContext.getResources()");
        p.h(resources, "resources");
        if (eVar4.hZD != 0) {
            drawable = new ColorDrawable(resources.getColor(eVar4.hZD));
        } else {
            drawable = eVar4.hYp != 0 ? resources.getDrawable(eVar4.hYp) : eVar4.hYr;
        }
        this.hYr = drawable;
        this.hYs = this.hYw.hYD;
        this.hYu = "";
    }

    public final com.tencent.mm.loader.e.b.d<R> aJt() {
        com.tencent.mm.loader.e.b.d<R> dVar = this.hYt;
        if (dVar == null) {
            p.btv("target");
        }
        return dVar;
    }

    public final void vC() {
        this.hYs = this.hYw.hYD;
        aJu();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v16, resolved type: com.tencent.mm.loader.e.b.d<R> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v30, resolved type: com.tencent.mm.loader.f.e<T, R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005d, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil((java.lang.String) r0) != false) goto L_0x005f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aJu() {
        /*
        // Method dump skipped, instructions count: 468
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.loader.f.aJu():void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/loader/Reaper$request$5$2", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "uiDone", "", "isRemove", "", "libimageloader_release"})
    public static final class b implements com.tencent.mm.loader.e.b.b {
        final /* synthetic */ f hYy;
        final /* synthetic */ boolean hYz;

        b(f fVar, boolean z) {
            this.hYy = fVar;
            this.hYz = z;
        }

        @Override // com.tencent.mm.loader.e.b.b
        public final void eR(boolean z) {
            if (z) {
                e.a aVar = com.tencent.mm.loader.e.b.e.iay;
                com.tencent.mm.loader.e.b.e aJX = e.a.aJX();
                com.tencent.mm.loader.e.b.d<R> aJt = this.hYy.aJt();
                if (aJt == null) {
                    throw new t("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
                }
                aJX.a((com.tencent.mm.loader.e.b.d<Object>) aJt, (com.tencent.mm.loader.h.a.a<?>) this.hYy.hYs, "may be hit cache");
            }
        }
    }

    private final synchronized void aJv() {
        if (this.hYm == null) {
            com.tencent.mm.loader.g.a.e eVar = com.tencent.mm.loader.g.a.e.ibM;
            this.hYm = com.tencent.mm.loader.g.a.e.aKh();
        }
    }

    private final void a(com.tencent.mm.loader.k.b<?, ?> bVar) {
        aJv();
        com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> dVar = this.hYm;
        if (dVar != null) {
            dVar.b(bVar);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/loader/Reaper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "libimageloader_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
