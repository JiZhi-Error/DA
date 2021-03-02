package com.tencent.mm.ui.chatting.gallery.a;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0003'()B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u001a\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0002J&\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00072\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00140\u001bH\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ\u0006\u0010\"\u001a\u00020\u0014J\n\u0010#\u001a\u00020$*\u00020%J\f\u0010&\u001a\u00020$*\u0004\u0018\u00010%R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000RR\u0010\u0005\u001aF\u0012\u0004\u0012\u00020\u0007\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\t`\n0\u0006j\"\u0012\u0004\u0012\u00020\u0007\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\t`\n`\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f`\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0011j\b\u0012\u0004\u0012\u00020\u0007`\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager;", "", "()V", "mPreviewImageCallback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "previewCallbackMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/chatting/gallery/scan/GallerySearchImagePreviewResultCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "previewFilter", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePreviewFilter;", "previewRequestMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/GalleryScanOpImageRequestWrapper;", "previewRequestSessionSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "cancelPreviewImage", "", "session", "doPreviewImage", "requestWrapper", "callback", "getImagePHashByMsgId", "msgId", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "getImagePath", "onPreviewCallbackWrapper", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME, "release", "canPreview", "", "Lcom/tencent/mm/protocal/protobuf/ImageSearchPreviewResult;", "valid", "Companion", "ImagePHashInfoWrapper", "ImagePreviewFilter", "app_release"})
public final class l {
    private static final HashMap<String, ccx> PCN = new HashMap<>();
    private static final ConcurrentHashMap<Long, b> PCO = new ConcurrentHashMap<>();
    public static final a PCP = new a((byte) 0);
    private c PCI = new c();
    public HashSet<Long> PCJ = new HashSet<>();
    public HashMap<Long, ArrayList<c>> PCK = new HashMap<>();
    public HashMap<Long, a> PCL = new HashMap<>();
    private com.tencent.mm.plugin.scanner.api.g PCM;

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "", "()V", "imagePath", "", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "pHashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "getPHashInfo", "()Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "setPHashInfo", "(Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;)V", "app_release"})
    public static final class b {
        ScanImagePHashInfo CAW;
        String imagePath;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "pHashInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<b, x> {
        final /* synthetic */ c PCS;
        final /* synthetic */ long pwg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(c cVar, long j2) {
            super(1);
            this.PCS = cVar;
            this.pwg = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(b bVar) {
            String str;
            AppMethodBeat.i(231281);
            b bVar2 = bVar;
            c cVar = this.PCS;
            if (cVar != null) {
                if (bVar2 == null || (str = bVar2.imagePath) == null) {
                    str = "";
                }
                cVar.bmZ(str);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(231281);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "pHashInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "invoke"})
    public static final class g extends q implements kotlin.g.a.b<b, x> {
        final /* synthetic */ c PCS;
        final /* synthetic */ l PCT;
        final /* synthetic */ long PCU;
        final /* synthetic */ long pwg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(l lVar, c cVar, long j2, long j3) {
            super(1);
            this.PCT = lVar;
            this.PCS = cVar;
            this.pwg = j2;
            this.PCU = j3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(b bVar) {
            String str;
            boolean z;
            Integer num;
            int i2;
            ScanImagePHashInfo scanImagePHashInfo;
            String str2;
            AppMethodBeat.i(231284);
            b bVar2 = bVar;
            if (bVar2 == null || (str2 = bVar2.imagePath) == null) {
                str = "";
            } else {
                str = str2;
            }
            c cVar = this.PCS;
            if (cVar != null) {
                cVar.bmZ(str);
            }
            String str3 = (bVar2 == null || (scanImagePHashInfo = bVar2.CAW) == null) ? null : scanImagePHashInfo.pHash;
            Log.i("MicroMsg.ImageSearchPreviewManager", "alvinluo previewImage msgId: %d, imagePath: %s, pHash: %s", Long.valueOf(this.pwg), str, str3);
            String str4 = str3;
            if (str4 == null || str4.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                c cVar2 = this.PCS;
                if (cVar2 != null) {
                    long j2 = this.PCU;
                    b bVar3 = new b();
                    bVar3.msgId = this.pwg;
                    bVar3.resultCode = 1;
                    com.tencent.mm.plugin.scanner.api.f fVar = new com.tencent.mm.plugin.scanner.api.f();
                    fVar.CAT = 2;
                    fVar.success = false;
                    fVar.dDZ = this.PCU;
                    fVar.errType = 3;
                    fVar.errMsg = "compute pHash failed";
                    fVar.errCode = -1;
                    bVar3.PBQ = fVar;
                    cVar2.c(j2, bVar3);
                }
            } else {
                c cVar3 = this.PCT.PCI;
                p.h(str3, "pHash");
                ccx ccx = (ccx) l.PCN.get(str3);
                Object[] objArr = new Object[2];
                objArr[0] = str3;
                if (ccx != null) {
                    num = Integer.valueOf(ccx.result);
                } else {
                    num = null;
                }
                objArr[1] = num;
                Log.i("MicroMsg.ImageSearchPreviewManager", "alvinluo filterPreviewByMemory pHash: %s, previewResult: %s", objArr);
                if (ccx == null) {
                    byte[] decodeBytes = ((MultiProcessMMKV) cVar3.pvV.getSlot()).decodeBytes(str3);
                    Log.i("MicroMsg.ImageSearchPreviewManager", "alvinluo filterPreviewByMMKV pHash: %s, result: %s", str3, decodeBytes);
                    if (decodeBytes != null) {
                        ccx = new ccx();
                        ccx.parseFrom(decodeBytes);
                        c.ci(str3, ccx.timestamp);
                    } else {
                        ccx = null;
                    }
                    if (ccx == null) {
                        ccx = null;
                    }
                }
                if (l.b(ccx)) {
                    if (ccx == null) {
                        p.hyc();
                    }
                    if (!l.a(ccx)) {
                        c cVar4 = this.PCS;
                        if (cVar4 != null) {
                            long j3 = this.PCU;
                            b bVar4 = new b();
                            bVar4.msgId = this.pwg;
                            if (ccx.result == 2) {
                                i2 = 3;
                            } else {
                                i2 = ccx.result;
                            }
                            bVar4.resultCode = i2;
                            com.tencent.mm.plugin.scanner.api.f fVar2 = new com.tencent.mm.plugin.scanner.api.f();
                            fVar2.CAT = 2;
                            fVar2.success = false;
                            fVar2.dDZ = this.PCU;
                            fVar2.errType = 3;
                            fVar2.errMsg = "preview result: " + bVar4.resultCode;
                            fVar2.errCode = -2;
                            bVar4.PBQ = fVar2;
                            cVar4.c(j3, bVar4);
                        }
                    }
                }
                a aVar = new a();
                aVar.msgId = this.pwg;
                com.tencent.mm.plugin.scanner.api.e eVar = new com.tencent.mm.plugin.scanner.api.e();
                eVar.imagePath = str;
                eVar.sessionId = this.PCU;
                eVar.CAT = 2;
                eVar.msgId = this.pwg;
                eVar.CAW = bVar2.CAW;
                aVar.CEZ = eVar;
                l.a(this.PCT, aVar, this.PCS);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(231284);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012`\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$Companion;", "", "()V", "COMPUTE_PHASH_LOOP_TAG", "", "ENABLE_PREVIEW_FILTER_BY_KV", "", "ENABLE_PREVIEW_FILTER_BY_MEMORY", "IMAGE_SEARCH_PREVIEW_VALID_DAYS", "", "IMAGE_SEARCH_PREVIEW_VALID_MS", "", "TAG", "pHashCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "previewResultCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/ImageSearchPreviewResult;", "Lkotlin/collections/HashMap;", "clearCache", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public l() {
        AppMethodBeat.i(231288);
        Log.i("MicroMsg.ImageSearchPreviewManager", "alvinluo ImageSearchPreviewManager init cache size: %d", Integer.valueOf(PCN.size()));
        this.PCM = new f(this);
        AppMethodBeat.o(231288);
    }

    static {
        AppMethodBeat.i(231289);
        AppMethodBeat.o(231289);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
    static final class f implements com.tencent.mm.plugin.scanner.api.g {
        final /* synthetic */ l PCT;

        f(l lVar) {
            this.PCT = lVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // com.tencent.mm.plugin.scanner.api.a
        public final /* synthetic */ void c(long j2, com.tencent.mm.plugin.scanner.api.f fVar) {
            AppMethodBeat.i(231282);
            a(j2, fVar);
            AppMethodBeat.o(231282);
        }

        @Override // com.tencent.mm.plugin.scanner.api.g
        public final void a(long j2, com.tencent.mm.plugin.scanner.api.f fVar) {
            AppMethodBeat.i(231283);
            p.h(fVar, "result");
            l.a(this.PCT, j2, fVar);
            AppMethodBeat.o(231283);
        }
    }

    public static void Is(long j2) {
        AppMethodBeat.i(231285);
        Log.i("MicroMsg.ImageSearchPreviewManager", "alvinluo cancelPreviewImage session: %d", Long.valueOf(j2));
        ((com.tencent.mm.plugin.scanner.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.c.class)).Is(j2);
        AppMethodBeat.o(231285);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ long pwg;

        d(long j2, kotlin.g.a.b bVar) {
            this.pwg = j2;
            this.gWe = bVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x006e, code lost:
            if (r0 != false) goto L_0x0070;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 200
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.a.l.d.run():void");
        }
    }

    public static void a(long j2, kotlin.g.a.b<? super b, x> bVar) {
        AppMethodBeat.i(231286);
        h.RTc.e(new d(j2, bVar), "search_preview_compute_phash");
        AppMethodBeat.o(231286);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0012J\u0018\u0010\u0015\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0012J\u0018\u0010\u0016\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePreviewFilter;", "", "()V", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", ch.COL_USERNAME, "", "kotlin.jvm.PlatformType", "filterPreview", "", "pHash", "filterPreviewByMMKV", "Lcom/tencent/mm/protocal/protobuf/ImageSearchPreviewResult;", "filterPreviewByMemory", "getPreviewResult", "saveRequest", "", AppMeasurement.Param.TIMESTAMP, "", "saveRequestInMMKV", "requestTime", "saveRequestInMemory", "saveResult", "result", "FilterResult", "app_release"})
    public static final class c {
        final MMKVSlotManager pvV;
        private final String username = z.aTY();

        public c() {
            AppMethodBeat.i(231278);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(this.username + "__image_gallery_search_preview_slot_mmkv_key__");
            p.g(mmkv, "MultiProcessMMKV.getMMKV…preview_slot_mmkv_key__\")");
            this.pvV = new MMKVSlotManager(mmkv, 604800);
            AppMethodBeat.o(231278);
        }

        public static void ci(String str, long j2) {
            AppMethodBeat.i(231277);
            Log.d("MicroMsg.ImageSearchPreviewManager", "alvinluo saveRequestInMemory pHash: %s, requestTime: %d", str, Long.valueOf(j2));
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                AppMethodBeat.o(231277);
                return;
            }
            ccx ccx = (ccx) l.PCN.get(str);
            if (ccx != null) {
                ccx.timestamp = j2;
                AppMethodBeat.o(231277);
                return;
            }
            AppMethodBeat.o(231277);
        }
    }

    public static boolean a(ccx ccx) {
        AppMethodBeat.i(231287);
        p.h(ccx, "$this$canPreview");
        if (ccx.timestamp <= 0 || System.currentTimeMillis() - ccx.timestamp <= 604800000) {
            AppMethodBeat.o(231287);
            return false;
        }
        AppMethodBeat.o(231287);
        return true;
    }

    public static boolean b(ccx ccx) {
        return ccx != null && ccx.timestamp > 0;
    }

    public static final /* synthetic */ long a(l lVar, a aVar, c cVar) {
        String str;
        ScanImagePHashInfo scanImagePHashInfo;
        AppMethodBeat.i(231290);
        com.tencent.mm.plugin.scanner.api.e eVar = aVar.CEZ;
        if (eVar == null) {
            p.hyc();
        }
        long j2 = eVar.sessionId;
        if (!lVar.PCK.containsKey(Long.valueOf(j2))) {
            lVar.PCK.put(Long.valueOf(j2), new ArrayList<>());
        }
        ArrayList<c> arrayList = lVar.PCK.get(Long.valueOf(j2));
        if (arrayList == null) {
            p.hyc();
        }
        if (!arrayList.contains(cVar)) {
            ArrayList<c> arrayList2 = lVar.PCK.get(Long.valueOf(j2));
            if (arrayList2 == null) {
                p.hyc();
            }
            arrayList2.add(cVar);
        }
        lVar.PCL.put(Long.valueOf(j2), aVar);
        c cVar2 = lVar.PCI;
        com.tencent.mm.plugin.scanner.api.e eVar2 = aVar.CEZ;
        if (eVar2 == null || (scanImagePHashInfo = eVar2.CAW) == null) {
            str = null;
        } else {
            str = scanImagePHashInfo.pHash;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("MicroMsg.ImageSearchPreviewManager", "alvinluo saveRequest pHash: %s, timestamp: %d", str, Long.valueOf(currentTimeMillis));
        c.ci(str, currentTimeMillis);
        Log.d("MicroMsg.ImageSearchPreviewManager", "alvinluo saveRequestInMMKV pHash: %s, requestTime: %d", str, Long.valueOf(currentTimeMillis));
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            byte[] decodeBytes = ((MultiProcessMMKV) cVar2.pvV.getSlot()).decodeBytes(str);
            ccx ccx = new ccx();
            if (decodeBytes != null) {
                ccx.parseFrom(decodeBytes);
            } else {
                ccx.result = 1;
            }
            ccx.timestamp = currentTimeMillis;
        }
        com.tencent.mm.plugin.scanner.api.c cVar3 = (com.tencent.mm.plugin.scanner.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.c.class);
        com.tencent.mm.plugin.scanner.api.e eVar3 = aVar.CEZ;
        if (eVar3 == null) {
            p.hyc();
        }
        long c2 = cVar3.c(eVar3, lVar.PCM);
        AppMethodBeat.o(231290);
        return c2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.tencent.mm.ui.chatting.gallery.a.l r11, long r12, com.tencent.mm.plugin.scanner.api.f r14) {
        /*
        // Method dump skipped, instructions count: 200
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.a.l.a(com.tencent.mm.ui.chatting.gallery.a.l, long, com.tencent.mm.plugin.scanner.api.f):void");
    }
}
