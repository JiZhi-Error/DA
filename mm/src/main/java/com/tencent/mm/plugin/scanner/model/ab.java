package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.facebook.share.internal.ShareConstants;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.a.m;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005()*+,B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\u001d\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0007J \u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0018\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r`\u000eX\u0004¢\u0006\u0002\n\u0000R.\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00100\fj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0010`\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\tX\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager;", "", "()V", "SCAN_RESOURCE_LOOP_TAG", "", "SCAN_RESOURCE_RELEASE_DELAY_MS", "", "TAG", "bitmapCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "cachedRequest", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "Lkotlin/collections/HashMap;", "callbackMap", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceLoadCallback;", "pendingReleaseRequestSet", "", "batchDecodeImage", "", "batchImageDecodeInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$BatchImageDecodeInfo;", "getBatchImageDecodeInfo", "requestId", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "getRequestKey", "getResource", "imagePath", "loadResource", "callback", "onCallback", "errCode", "", "errMsg", "releaseBitmap", "key", "releaseRequest", "requestKey", "releaseResource", "BatchImageDecodeInfo", "DecodeTask", "ErrCode", "ImageDecodeInfo", "Status", "plugin-scan_release"})
public final class ab {
    public static final HashMap<Long, ScanGoodsRequest> CGr = new HashMap<>();
    private static final ConcurrentHashMap<String, Bitmap> CGs = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, Boolean> CGt = new ConcurrentHashMap<>();
    public static final ab CGu = new ab();
    public static final HashMap<Long, aa> hdu = new HashMap<>();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "decodeInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$batchDecodeImage$1$1"})
    public static final class d extends q implements m<c, Bitmap, x> {
        final /* synthetic */ z.a CGw;
        final /* synthetic */ a CGx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(z.a aVar, a aVar2) {
            super(2);
            this.CGw = aVar;
            this.CGx = aVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(c cVar, Bitmap bitmap) {
            boolean z;
            AppMethodBeat.i(240434);
            c cVar2 = cVar;
            p.h(cVar2, "decodeInfo");
            if (cVar2.result == 0) {
                a aVar = this.CGx;
                Iterator<T> it = aVar.BLy.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar.status = 2;
                        Log.i("MicroMsg.ScanGoodsResourceManager", "alvinluo checkFinish finish");
                        z = true;
                        break;
                    }
                    T next = it.next();
                    if (next.status != 2) {
                        aVar.status = next.status;
                        Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo checkFinish not finish status: %d", Integer.valueOf(next.status));
                        z = false;
                        break;
                    }
                }
                if (z) {
                    a aVar2 = this.CGx;
                    Iterator<c> it2 = aVar2.BLy.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            aVar2.result = 0;
                            aVar2.eQf();
                            break;
                        }
                        c next2 = it2.next();
                        if (next2.result != 0) {
                            aVar2.result = next2.result;
                            aVar2.eQf();
                            break;
                        }
                    }
                    h.RTc.aV(new Runnable(this) {
                        /* class com.tencent.mm.plugin.scanner.model.ab.d.AnonymousClass1 */
                        final /* synthetic */ d CGy;

                        {
                            this.CGy = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(240433);
                            ab abVar = ab.CGu;
                            ab.h(this.CGy.CGx.ulj, this.CGy.CGx.result, this.CGy.CGx.errMsg);
                            AppMethodBeat.o(240433);
                        }
                    });
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(240434);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(240442);
        AppMethodBeat.o(240442);
    }

    private ab() {
    }

    public static final /* synthetic */ String d(ScanGoodsRequest scanGoodsRequest) {
        AppMethodBeat.i(240443);
        String c2 = c(scanGoodsRequest);
        AppMethodBeat.o(240443);
        return c2;
    }

    public static final /* synthetic */ void h(long j2, int i2, String str) {
        AppMethodBeat.i(240447);
        g(j2, i2, str);
        AppMethodBeat.o(240447);
    }

    public static long a(ScanGoodsRequest scanGoodsRequest, aa aaVar) {
        AppMethodBeat.i(240437);
        if (scanGoodsRequest == null) {
            AppMethodBeat.o(240437);
            return -1;
        } else if (!scanGoodsRequest.isValid()) {
            Log.e("MicroMsg.ScanGoodsResourceManager", "alvinluo prepare request not valid");
            AppMethodBeat.o(240437);
            return -1;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("MicroMsg.ScanGoodsResourceManager", "alvinluo loadResource requestId: %d", Long.valueOf(currentTimeMillis));
            hdu.put(Long.valueOf(currentTimeMillis), aaVar);
            CGr.put(Long.valueOf(currentTimeMillis), scanGoodsRequest);
            h.RTc.e(new e(scanGoodsRequest, currentTimeMillis), "ScanResourceTag");
            AppMethodBeat.o(240437);
            return currentTimeMillis;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ long CGA;
        final /* synthetic */ ScanGoodsRequest CGz;

        e(ScanGoodsRequest scanGoodsRequest, long j2) {
            this.CGz = scanGoodsRequest;
            this.CGA = j2;
        }

        public final void run() {
            AppMethodBeat.i(240435);
            ab abVar = ab.CGu;
            String d2 = ab.d(this.CGz);
            ab abVar2 = ab.CGu;
            if (ab.CGt.containsKey(d2)) {
                Log.i("MicroMsg.ScanGoodsResourceManager", "alvinluo loadResource set can not release");
                ab abVar3 = ab.CGu;
                ab.CGt.put(d2, Boolean.FALSE);
            }
            ab abVar4 = ab.CGu;
            a a2 = ab.a(this.CGA, this.CGz);
            ab abVar5 = ab.CGu;
            ab.a(a2);
            AppMethodBeat.o(240435);
        }
    }

    public static Bitmap aMy(String str) {
        AppMethodBeat.i(240438);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(240438);
            return null;
        }
        Bitmap bitmap = CGs.get(str);
        AppMethodBeat.o(240438);
        return bitmap;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ String $key;
        final /* synthetic */ ScanGoodsRequest CGz;

        public f(String str, ScanGoodsRequest scanGoodsRequest) {
            this.$key = str;
            this.CGz = scanGoodsRequest;
        }

        public final void run() {
            AppMethodBeat.i(240436);
            ab abVar = ab.CGu;
            if (p.j((Boolean) ab.CGt.get(this.$key), Boolean.TRUE)) {
                ab abVar2 = ab.CGu;
                ab.a(this.$key, this.CGz);
                AppMethodBeat.o(240436);
                return;
            }
            Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource not need to release requestKey: %s", this.$key);
            AppMethodBeat.o(240436);
        }
    }

    private static void g(long j2, int i2, String str) {
        AppMethodBeat.i(240439);
        aa aaVar = hdu.get(Long.valueOf(j2));
        if (aaVar != null) {
            aaVar.cn(i2, str);
        }
        hdu.remove(Long.valueOf(j2));
        AppMethodBeat.o(240439);
    }

    private static void aMz(String str) {
        AppMethodBeat.i(240440);
        Bitmap bitmap = CGs.get(str);
        if (bitmap != null) {
            bitmap.recycle();
        }
        CGs.remove(str);
        AppMethodBeat.o(240440);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0014J\u0006\u0010\u001f\u001a\u00020 R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$BatchImageDecodeInfo;", "", "requestId", "", "imageList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "Lkotlin/collections/ArrayList;", "(JLjava/util/ArrayList;)V", "errMsg", "", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getImageList", "()Ljava/util/ArrayList;", "getRequestId", "()J", "result", "", "getResult", "()I", "setResult", "(I)V", "status", "getStatus", "setStatus", "checkFinish", "", "checkResult", "fillErrMsg", "", "plugin-scan_release"})
    public static final class a {
        final ArrayList<c> BLy;
        String errMsg = "";
        int result = -1;
        int status;
        final long ulj;

        public a(long j2, ArrayList<c> arrayList) {
            p.h(arrayList, "imageList");
            AppMethodBeat.i(240427);
            this.ulj = j2;
            this.BLy = arrayList;
            AppMethodBeat.o(240427);
        }

        public final void eQf() {
            String str;
            if (this.result == 0) {
                str = "ok";
            } else if (this.result == 2) {
                str = "image not exist";
            } else if (this.result == 3) {
                str = "decode fail";
            } else {
                str = "unknown error";
            }
            this.errMsg = str;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "", "imagePath", "", "(Ljava/lang/String;)V", "getImagePath", "()Ljava/lang/String;", "result", "", "getResult", "()I", "setResult", "(I)V", "status", "getStatus", "setStatus", "plugin-scan_release"})
    public static final class c {
        final String imagePath;
        int result = -1;
        int status;

        public c(String str) {
            p.h(str, "imagePath");
            AppMethodBeat.i(240432);
            this.imagePath = str;
            AppMethodBeat.o(240432);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001a\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0002R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$DecodeTask;", "Ljava/lang/Runnable;", "info", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "(Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;Lkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getInfo", "()Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "doDecodeImage", "finishDecode", "bitmap", "run", "startDecode", "plugin-scan_release"})
    public static final class b implements Runnable {
        private final c CGv;
        private final m<c, Bitmap, x> gWp;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.g.a.m<? super com.tencent.mm.plugin.scanner.model.ab$c, ? super android.graphics.Bitmap, kotlin.x> */
        /* JADX WARN: Multi-variable type inference failed */
        public b(c cVar, m<? super c, ? super Bitmap, x> mVar) {
            p.h(cVar, "info");
            p.h(mVar, "callback");
            AppMethodBeat.i(240431);
            this.CGv = cVar;
            this.gWp = mVar;
            AppMethodBeat.o(240431);
        }

        public final void run() {
            AppMethodBeat.i(240428);
            Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo startDecode image: %s", this.CGv.imagePath);
            this.CGv.status = 1;
            this.gWp.invoke(this.CGv, a(this.CGv));
            AppMethodBeat.o(240428);
        }

        private static void a(c cVar, Bitmap bitmap) {
            AppMethodBeat.i(240429);
            cVar.status = 2;
            if (bitmap != null && !bitmap.isRecycled()) {
                ab abVar = ab.CGu;
                ab.CGs.put(cVar.imagePath, bitmap);
            }
            Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo finishDecode image: %s, status: %d, result: %d", cVar.imagePath, Integer.valueOf(cVar.status), Integer.valueOf(cVar.result));
            AppMethodBeat.o(240429);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0047 A[Catch:{ Exception -> 0x0060 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static android.graphics.Bitmap a(com.tencent.mm.plugin.scanner.model.ab.c r10) {
            /*
            // Method dump skipped, instructions count: 117
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.model.ab.b.a(com.tencent.mm.plugin.scanner.model.ab$c):android.graphics.Bitmap");
        }
    }

    public static String c(ScanGoodsRequest scanGoodsRequest) {
        AppMethodBeat.i(240441);
        ae aeVar = ae.SYK;
        String format = String.format("deco:%s,succ:%s,tips:%s", Arrays.copyOf(new Object[]{scanGoodsRequest.CAN, scanGoodsRequest.CAO, scanGoodsRequest.CAP}, 3));
        p.g(format, "java.lang.String.format(format, *args)");
        AppMethodBeat.o(240441);
        return format;
    }

    public static final /* synthetic */ a a(long j2, ScanGoodsRequest scanGoodsRequest) {
        AppMethodBeat.i(240444);
        ArrayList arrayList = new ArrayList();
        String str = scanGoodsRequest.CAN;
        p.g(str, "request.decorationImagePath");
        arrayList.add(new c(str));
        String str2 = scanGoodsRequest.CAO;
        p.g(str2, "request.successImagePath");
        arrayList.add(new c(str2));
        String str3 = scanGoodsRequest.CAP;
        p.g(str3, "request.scanTipsImagePath");
        arrayList.add(new c(str3));
        a aVar = new a(j2, arrayList);
        AppMethodBeat.o(240444);
        return aVar;
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(240445);
        Log.i("MicroMsg.ScanGoodsResourceManager", "batchDecodeImage start");
        z.a aVar2 = new z.a();
        aVar2.SYB = false;
        for (T t : aVar.BLy) {
            Bitmap bitmap = CGs.get(t.imagePath);
            if (bitmap == null || bitmap.isRecycled()) {
                aVar2.SYB = true;
                h.RTc.aZ(new b(t, new d(aVar2, aVar)));
            } else {
                Log.v("MicroMsg.ScanGoodsResourceManager", "alvinluo batchDecodeImage imagePath: %s, exist bitmap", t.imagePath);
                t.status = 2;
                t.result = 0;
            }
        }
        if (!aVar2.SYB) {
            Log.i("MicroMsg.ScanGoodsResourceManager", "alvinluo batchDecodeImage use cache no need to decode");
            g(aVar.ulj, 0, "ok");
        }
        AppMethodBeat.o(240445);
    }

    public static final /* synthetic */ void a(String str, ScanGoodsRequest scanGoodsRequest) {
        AppMethodBeat.i(240446);
        Log.i("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource requestKey: %s", str);
        CGt.remove(str);
        String str2 = scanGoodsRequest.CAN;
        p.g(str2, "request.decorationImagePath");
        aMz(str2);
        String str3 = scanGoodsRequest.CAO;
        p.g(str3, "request.successImagePath");
        aMz(str3);
        String str4 = scanGoodsRequest.CAP;
        p.g(str4, "request.scanTipsImagePath");
        aMz(str4);
        AppMethodBeat.o(240446);
    }
}
