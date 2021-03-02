package com.tencent.mm.plugin.scanner.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.e.a;
import com.tencent.mm.plugin.scanner.model.a;
import com.tencent.mm.plugin.scanner.util.f;
import com.tencent.mm.protocal.protobuf.na;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.protocal.protobuf.pa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.bn;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0003-./B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J4\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\b\b\u0001\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J,\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020&H\u0002J\u0006\u0010'\u001a\u00020\u0010J\u001a\u0010(\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J \u0010+\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020\u0006R.\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\tX\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e`\u0007X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callbackMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "Lkotlin/collections/HashMap;", "cdnMediaMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "imageHandleCache", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader$ImageHandleResult;", "requestMap", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader$ScanOpImageRequestWrapper;", "cancel", "", "session", "doUploadImage", "requestWrapper", "onFailedWrapper", "opImageType", "", "errType", "errCode", "errMsg", "onPreviewScanSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageScenePreviewResponse;", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSuccessWrapper", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onUploadOcrSuccess", "Lcom/tencent/mm/protocal/protobuf/BizOcrChatImageResponse;", "onUploadScanSuccess", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSceneResponse;", "release", "uploadCdnImage", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "uploadImage", "callback", "Companion", "ImageHandleResult", "ScanOpImageRequestWrapper", "plugin-scan_release"})
public final class c implements i {
    public static final a CEU = new a((byte) 0);
    private final ConcurrentHashMap<String, b> CES = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, String> CET = new ConcurrentHashMap<>();
    private HashMap<Long, com.tencent.mm.plugin.scanner.api.g> hdu = new HashMap<>();
    private HashMap<Long, C1674c> lQW = new HashMap<>();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader$ScanOpImageRequestWrapper;", "", "()V", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "getRequest", "()Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "setRequest", "(Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;)V", "sceneHashCode", "", "getSceneHashCode", "()I", "setSceneHashCode", "(I)V", "plugin-scan_release"})
    /* renamed from: com.tencent.mm.plugin.scanner.model.c$c  reason: collision with other inner class name */
    public static final class C1674c {
        com.tencent.mm.plugin.scanner.api.e CEZ;
        int CFa;
    }

    static {
        AppMethodBeat.i(240394);
        AppMethodBeat.o(240394);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public c() {
        AppMethodBeat.i(240393);
        com.tencent.mm.kernel.g.azz().a(1100, this);
        com.tencent.mm.kernel.g.azz().a(5079, this);
        com.tencent.mm.kernel.g.azz().a(5131, this);
        AppMethodBeat.o(240393);
    }

    public static final /* synthetic */ void a(c cVar, long j2, int i2, int i3, int i4, String str) {
        AppMethodBeat.i(240396);
        cVar.b(j2, i2, i3, i4, str);
        AppMethodBeat.o(240396);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003JM\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader$ImageHandleResult;", "", "targetImagePath", "", "hashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "originWidth", "", "originHeight", "decodeResult", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "uploadResult", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;IILcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;)V", "getDecodeResult", "()Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "getHashInfo", "()Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "getOriginHeight", "()I", "getOriginWidth", "getTargetImagePath", "()Ljava/lang/String;", "getUploadResult", "()Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-scan_release"})
    public static final class b {
        final String CEV;
        final ScanImagePHashInfo CEW;
        final a.b CEX;
        final a.C1673a CEY;
        private final int xlg;
        private final int xlh;

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
            if (kotlin.g.b.p.j(r3.CEY, r4.CEY) != false) goto L_0x0042;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 240380(0x3aafc, float:3.36844E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0042
                boolean r0 = r4 instanceof com.tencent.mm.plugin.scanner.model.c.b
                if (r0 == 0) goto L_0x0047
                com.tencent.mm.plugin.scanner.model.c$b r4 = (com.tencent.mm.plugin.scanner.model.c.b) r4
                java.lang.String r0 = r3.CEV
                java.lang.String r1 = r4.CEV
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0047
                com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo r0 = r3.CEW
                com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo r1 = r4.CEW
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0047
                int r0 = r3.xlg
                int r1 = r4.xlg
                if (r0 != r1) goto L_0x0047
                int r0 = r3.xlh
                int r1 = r4.xlh
                if (r0 != r1) goto L_0x0047
                com.tencent.mm.plugin.scanner.model.a$b r0 = r3.CEX
                com.tencent.mm.plugin.scanner.model.a$b r1 = r4.CEX
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0047
                com.tencent.mm.plugin.scanner.model.a$a r0 = r3.CEY
                com.tencent.mm.plugin.scanner.model.a$a r1 = r4.CEY
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0047
            L_0x0042:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0046:
                return r0
            L_0x0047:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0046
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.model.c.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(240379);
            String str = this.CEV;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            ScanImagePHashInfo scanImagePHashInfo = this.CEW;
            int hashCode2 = ((((((scanImagePHashInfo != null ? scanImagePHashInfo.hashCode() : 0) + hashCode) * 31) + this.xlg) * 31) + this.xlh) * 31;
            a.b bVar = this.CEX;
            int hashCode3 = ((bVar != null ? bVar.hashCode() : 0) + hashCode2) * 31;
            a.C1673a aVar = this.CEY;
            if (aVar != null) {
                i2 = aVar.hashCode();
            }
            int i3 = hashCode3 + i2;
            AppMethodBeat.o(240379);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(240378);
            String str = "ImageHandleResult(targetImagePath=" + this.CEV + ", hashInfo=" + this.CEW + ", originWidth=" + this.xlg + ", originHeight=" + this.xlh + ", decodeResult=" + this.CEX + ", uploadResult=" + this.CEY + ")";
            AppMethodBeat.o(240378);
            return str;
        }

        public b(String str, ScanImagePHashInfo scanImagePHashInfo, int i2, int i3, a.b bVar, a.C1673a aVar) {
            this.CEV = str;
            this.CEW = scanImagePHashInfo;
            this.xlg = i2;
            this.xlh = i3;
            this.CEX = bVar;
            this.CEY = aVar;
        }
    }

    public final void a(long j2, com.tencent.mm.plugin.scanner.api.e eVar, com.tencent.mm.plugin.scanner.api.g gVar) {
        AppMethodBeat.i(240388);
        p.h(gVar, "callback");
        if (eVar == null) {
            AppMethodBeat.o(240388);
            return;
        }
        this.hdu.put(Long.valueOf(j2), gVar);
        Long valueOf = Long.valueOf(j2);
        C1674c cVar = new C1674c();
        cVar.CEZ = eVar;
        this.lQW.put(valueOf, cVar);
        Log.i("MicroMsg.AiScanImageSceneUploader", "alvinluo uploadImage session: %s, useCache: %s", Long.valueOf(j2), Boolean.valueOf(eVar.efT));
        if (eVar.CAT != 1 && eVar.CAT != 3) {
            com.tencent.f.h.RTc.aZ(new h(this, j2));
            AppMethodBeat.o(240388);
        } else if (eVar == null) {
            AppMethodBeat.o(240388);
        } else {
            C1674c cVar2 = new C1674c();
            cVar2.CEZ = eVar;
            kotlinx.coroutines.f.b(bn.TUK, (kotlin.d.f) null, new g(this, eVar, j2, cVar2, null), 3);
            AppMethodBeat.o(240388);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ c CFb;
        final /* synthetic */ long CFd;

        h(c cVar, long j2) {
            this.CFb = cVar;
            this.CFd = j2;
        }

        public final void run() {
            String str;
            boolean z;
            long j2;
            Integer num = null;
            AppMethodBeat.i(240387);
            C1674c cVar = (C1674c) this.CFb.lQW.get(Long.valueOf(this.CFd));
            if (cVar == null) {
                AppMethodBeat.o(240387);
            } else if (cVar.CEZ == null) {
                AppMethodBeat.o(240387);
            } else {
                com.tencent.mm.plugin.scanner.api.e eVar = cVar.CEZ;
                if (eVar != null) {
                    str = eVar.imagePath;
                } else {
                    str = null;
                }
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    com.tencent.mm.plugin.scanner.api.e eVar2 = cVar.CEZ;
                    if (eVar2 == null) {
                        p.hyc();
                    }
                    ac acVar = ac.CGB;
                    com.tencent.mm.plugin.scanner.api.e eVar3 = cVar.CEZ;
                    if (eVar3 != null) {
                        j2 = eVar3.msgId;
                    } else {
                        j2 = 0;
                    }
                    eVar2.imagePath = ac.G(j2, true);
                }
                com.tencent.mm.plugin.scanner.api.e eVar4 = cVar.CEZ;
                if (eVar4 == null || eVar4.CAT != 2) {
                    Object[] objArr = new Object[1];
                    com.tencent.mm.plugin.scanner.api.e eVar5 = cVar.CEZ;
                    if (eVar5 != null) {
                        num = Integer.valueOf(eVar5.CAT);
                    }
                    objArr[0] = num;
                    Log.e("MicroMsg.AiScanImageSceneUploader", "alvinluo uploadImage unknown opImageType: %d", objArr);
                    AppMethodBeat.o(240387);
                    return;
                }
                c.a(this.CFb, this.CFd, cVar);
                AppMethodBeat.o(240387);
            }
        }
    }

    public final void cancel(long j2) {
        AppMethodBeat.i(240389);
        Log.i("MicroMsg.AiScanImageSceneUploader", "cancel");
        this.hdu.remove(Long.valueOf(j2));
        C1674c remove = this.lQW.remove(Long.valueOf(j2));
        if (remove != null) {
            com.tencent.mm.kernel.g.azz().cancel(remove.CFa);
        }
        String remove2 = this.CET.remove(Long.valueOf(j2));
        if (remove2 != null) {
            p.g(remove2, "mediaId");
            a.aMw(remove2);
            AppMethodBeat.o(240389);
            return;
        }
        AppMethodBeat.o(240389);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "sucess", "", "image", "", "kotlin.jvm.PlatformType", "onCompressEnd"})
    public static final class d implements f.a {
        final /* synthetic */ c CFb;
        final /* synthetic */ com.tencent.mm.plugin.scanner.api.e CFc;
        final /* synthetic */ long CFd;
        final /* synthetic */ C1674c CFe;

        d(c cVar, com.tencent.mm.plugin.scanner.api.e eVar, long j2, C1674c cVar2) {
            this.CFb = cVar;
            this.CFc = eVar;
            this.CFd = j2;
            this.CFe = cVar2;
        }

        @Override // com.tencent.mm.plugin.scanner.util.f.a
        public final void a(boolean z, byte[] bArr) {
            q fVar;
            AppMethodBeat.i(240381);
            if (!z || bArr == null) {
                c.a(this.CFb, this.CFd, this.CFc.CAT, 3, 101, "decode image failed");
                AppMethodBeat.o(240381);
                return;
            }
            int i2 = this.CFc.mode;
            if (this.CFc.CAW == null) {
                com.tencent.mm.plugin.scanner.api.e eVar = this.CFc;
                ac acVar = ac.CGB;
                String str = this.CFc.imagePath;
                p.g(str, "request.imagePath");
                eVar.CAW = ac.aMA(str);
            }
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(bArr.length);
            objArr[1] = Long.valueOf(this.CFd);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = 0;
            ScanImagePHashInfo scanImagePHashInfo = this.CFc.CAW;
            objArr[4] = scanImagePHashInfo != null ? scanImagePHashInfo.pHash : null;
            ScanImagePHashInfo scanImagePHashInfo2 = this.CFc.CAW;
            objArr[5] = scanImagePHashInfo2 != null ? scanImagePHashInfo2.pHashVersion : null;
            Log.i("MicroMsg.AiScanImageSceneUploader", "doUploadImage imageData: %d, session: %d, mode: %d, frameId: %d, pHash: %s, %s", objArr);
            if (this.CFc.CAT == 1) {
                fVar = new h(bArr, this.CFd, this.CFc.type, i2, this.CFc.CAU, this.CFc.CAV, this.CFc.CAW);
            } else if (this.CFc.CAT == 2) {
                fVar = new i(this.CFd, this.CFc.CAW);
            } else {
                fVar = this.CFc.CAT == 3 ? new com.tencent.mm.plugin.scanner.e.f(bArr, this.CFc.sessionId, this.CFc.source) : null;
            }
            q qVar = fVar;
            if (qVar != null) {
                this.CFe.CFa = qVar.hashCode();
                com.tencent.mm.kernel.g.azz().b(qVar);
                AppMethodBeat.o(240381);
                return;
            }
            AppMethodBeat.o(240381);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        pa paVar;
        na naVar = null;
        nc ncVar = null;
        AppMethodBeat.i(240390);
        if (qVar == null || qVar.getType() != 1100) {
            if (qVar == null || qVar.getType() != 5079) {
                if (qVar != null) {
                    if (qVar.getType() == 5131) {
                        if (i2 == 0 && i3 == 0) {
                            com.tencent.mm.plugin.scanner.e.f fVar = (com.tencent.mm.plugin.scanner.e.f) qVar;
                            if (fVar.rr.aYK() != null) {
                                com.tencent.mm.bw.a aYK = fVar.rr.aYK();
                                if (aYK == null) {
                                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizOcrChatImageResponse");
                                    AppMethodBeat.o(240390);
                                    throw tVar;
                                }
                                paVar = (pa) aYK;
                            } else {
                                paVar = null;
                            }
                            if (paVar == null || paVar.KRi != ((com.tencent.mm.plugin.scanner.e.f) qVar).dDZ) {
                                Log.w("MicroMsg.AiScanImageSceneUploader", "uploadImageForOcr onSceneEnd success sessionId not the same");
                                AppMethodBeat.o(240390);
                                return;
                            }
                            Log.d("MicroMsg.AiScanImageSceneUploader", "previewImage onSceneEnd sessionId: %s, seqNum: %s", Long.valueOf(paVar.KRi), Integer.valueOf(paVar.KND));
                            com.tencent.mm.plugin.scanner.api.f fVar2 = new com.tencent.mm.plugin.scanner.api.f();
                            fVar2.CAT = 3;
                            fVar2.dDZ = paVar.KRi;
                            fVar2.success = true;
                            fVar2.errType = 0;
                            fVar2.errCode = 0;
                            fVar2.errMsg = "";
                            fVar2.dDL = paVar.dNQ;
                            fVar2.dZL = paVar.KRB;
                            fVar2.CBc = paVar.KVU;
                            b(paVar.KRi, fVar2);
                            AppMethodBeat.o(240390);
                            return;
                        }
                        b(((com.tencent.mm.plugin.scanner.e.f) qVar).dDZ, 3, i2, i3, str);
                    }
                    AppMethodBeat.o(240390);
                    return;
                }
                AppMethodBeat.o(240390);
            } else if (i2 == 0 && i3 == 0) {
                i iVar = (i) qVar;
                if (iVar.rr.aYK() != null) {
                    com.tencent.mm.bw.a aYK2 = iVar.rr.aYK();
                    if (aYK2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageScenePreviewResponse");
                        AppMethodBeat.o(240390);
                        throw tVar2;
                    }
                    naVar = (na) aYK2;
                }
                if (naVar == null || naVar.KRi != ((i) qVar).dDZ) {
                    Log.w("MicroMsg.AiScanImageSceneUploader", "previewImage onSceneEnd success sessionId not the same");
                    AppMethodBeat.o(240390);
                    return;
                }
                Log.d("MicroMsg.AiScanImageSceneUploader", "previewImage onSceneEnd sessionId: %s, seqNum: %s", Long.valueOf(naVar.KRi), Integer.valueOf(naVar.KND));
                com.tencent.mm.plugin.scanner.api.f fVar3 = new com.tencent.mm.plugin.scanner.api.f();
                fVar3.CAT = 2;
                fVar3.dDZ = naVar.KRi;
                fVar3.success = true;
                fVar3.errType = 0;
                fVar3.errCode = 0;
                fVar3.errMsg = "";
                String str2 = naVar.KRF;
                if (str2 == null) {
                    str2 = "";
                }
                fVar3.CBb = str2;
                b(naVar.KRi, fVar3);
                AppMethodBeat.o(240390);
            } else {
                b(((i) qVar).dDZ, 2, i2, i3, str);
                AppMethodBeat.o(240390);
            }
        } else if (i2 == 0 && i3 == 0) {
            h hVar = (h) qVar;
            if (hVar.rr.aYK() != null) {
                com.tencent.mm.bw.a aYK3 = hVar.rr.aYK();
                if (aYK3 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageSceneResponse");
                    AppMethodBeat.o(240390);
                    throw tVar3;
                }
                ncVar = (nc) aYK3;
            }
            if (ncVar == null || ncVar.KRi != ((h) qVar).dDZ) {
                Log.w("MicroMsg.AiScanImageSceneUploader", "uploadImage onSceneEnd success sessionId not the same");
                AppMethodBeat.o(240390);
                return;
            }
            Log.d("MicroMsg.AiScanImageSceneUploader", "uploadImage onSceneEnd sessionId: %s, seqNum: %s", Long.valueOf(ncVar.KRi), Integer.valueOf(ncVar.KND));
            com.tencent.mm.plugin.scanner.api.f fVar4 = new com.tencent.mm.plugin.scanner.api.f();
            fVar4.CAT = 1;
            fVar4.dDZ = ncVar.KRi;
            fVar4.success = true;
            fVar4.errType = 0;
            fVar4.errCode = 0;
            fVar4.errMsg = "";
            fVar4.dDL = ncVar.dNQ;
            fVar4.jumpType = ncVar.KRs;
            String str3 = ncVar.KRM;
            if (str3 == null) {
                str3 = "";
            }
            fVar4.CBa = str3;
            b(ncVar.KRi, fVar4);
            AppMethodBeat.o(240390);
        } else {
            b(((h) qVar).dDZ, 1, i2, i3, str);
            AppMethodBeat.o(240390);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ c CFb;
        final /* synthetic */ long CFd;
        final /* synthetic */ com.tencent.mm.plugin.scanner.api.f CFf;

        f(c cVar, long j2, com.tencent.mm.plugin.scanner.api.f fVar) {
            this.CFb = cVar;
            this.CFd = j2;
            this.CFf = fVar;
        }

        public final void run() {
            String str;
            com.tencent.mm.plugin.scanner.api.e eVar;
            e.a aVar;
            String str2;
            AppMethodBeat.i(240383);
            C1674c cVar = (C1674c) this.CFb.lQW.remove(Long.valueOf(this.CFd));
            if (cVar != null) {
                com.tencent.mm.plugin.scanner.api.f fVar = this.CFf;
                com.tencent.mm.plugin.scanner.api.e eVar2 = cVar.CEZ;
                if (eVar2 == null || (str2 = eVar2.imagePath) == null) {
                    str2 = "";
                }
                fVar.imagePath = str2;
            } else {
                cVar = null;
            }
            com.tencent.mm.plugin.scanner.e.a aVar2 = com.tencent.mm.plugin.scanner.e.a.CHU;
            String valueOf = String.valueOf(this.CFf.dDZ);
            a.C1669a aVar3 = new a.C1669a();
            if (cVar == null || (eVar = cVar.CEZ) == null || (aVar = eVar.CAY) == null || (str = aVar.CAZ) == null) {
                str = "";
            }
            p.h(str, "<set-?>");
            aVar3.CAZ = str;
            String str3 = this.CFf.dZL;
            if (str3 == null) {
                str3 = "";
            }
            p.h(str3, "<set-?>");
            aVar3.result = str3;
            com.tencent.mm.plugin.scanner.e.a.a(valueOf, aVar3);
            com.tencent.mm.plugin.scanner.api.g gVar = (com.tencent.mm.plugin.scanner.api.g) this.CFb.hdu.remove(Long.valueOf(this.CFd));
            Log.i("MicroMsg.AiScanImageSceneUploader", "onScanSuccess session: %d, callback: %s", Long.valueOf(this.CFd), gVar);
            if (gVar != null) {
                gVar.a(this.CFd, this.CFf);
                AppMethodBeat.o(240383);
                return;
            }
            AppMethodBeat.o(240383);
        }
    }

    private final void b(long j2, com.tencent.mm.plugin.scanner.api.f fVar) {
        AppMethodBeat.i(240391);
        com.tencent.f.h.RTc.aV(new f(this, j2, fVar));
        AppMethodBeat.o(240391);
    }

    private final void b(long j2, int i2, int i3, int i4, String str) {
        AppMethodBeat.i(240392);
        Log.e("MicroMsg.AiScanImageSceneUploader", "onScanFailed session: %d, errCode: %d, errMsg: %s", Long.valueOf(j2), Integer.valueOf(i4), str);
        com.tencent.mm.plugin.scanner.api.f fVar = new com.tencent.mm.plugin.scanner.api.f();
        fVar.CAT = i2;
        fVar.dDZ = j2;
        fVar.success = false;
        fVar.errType = i3;
        fVar.errCode = i4;
        fVar.errMsg = str;
        com.tencent.f.h.RTc.aV(new e(this, j2, fVar));
        AppMethodBeat.o(240392);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ c CFb;
        final /* synthetic */ long CFd;
        final /* synthetic */ com.tencent.mm.plugin.scanner.api.f CFf;

        e(c cVar, long j2, com.tencent.mm.plugin.scanner.api.f fVar) {
            this.CFb = cVar;
            this.CFd = j2;
            this.CFf = fVar;
        }

        public final void run() {
            String str;
            AppMethodBeat.i(240382);
            C1674c cVar = (C1674c) this.CFb.lQW.remove(Long.valueOf(this.CFd));
            if (cVar != null) {
                com.tencent.mm.plugin.scanner.api.f fVar = this.CFf;
                com.tencent.mm.plugin.scanner.api.e eVar = cVar.CEZ;
                if (eVar == null || (str = eVar.imagePath) == null) {
                    str = "";
                }
                fVar.imagePath = str;
            }
            com.tencent.mm.plugin.scanner.api.g gVar = (com.tencent.mm.plugin.scanner.api.g) this.CFb.hdu.remove(Long.valueOf(this.CFd));
            if (gVar != null) {
                gVar.a(this.CFd, this.CFf);
                AppMethodBeat.o(240382);
                return;
            }
            AppMethodBeat.o(240382);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.scanner.model.AiScanImageSceneUploader$uploadCdnImage$1", f = "AiScanImageSceneUploader.kt", hxM = {TbsListener.ErrorCode.STARTDOWNLOAD_6, 178}, m = "invokeSuspend")
    public static final class g extends j implements m<ai, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ c CFb;
        final /* synthetic */ com.tencent.mm.plugin.scanner.api.e CFc;
        final /* synthetic */ long CFd;
        final /* synthetic */ C1674c CFe;
        Object L$0;
        int label;
        private ai p$;
        Object pED;
        Object pEE;
        Object pEF;
        Object pEG;
        Object pEH;
        Object pEI;
        Object pEJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(c cVar, com.tencent.mm.plugin.scanner.api.e eVar, long j2, C1674c cVar2, kotlin.d.d dVar) {
            super(2, dVar);
            this.CFb = cVar;
            this.CFc = eVar;
            this.CFd = j2;
            this.CFe = cVar2;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(240385);
            p.h(dVar, "completion");
            g gVar = new g(this.CFb, this.CFc, this.CFd, this.CFe, dVar);
            gVar.p$ = (ai) obj;
            AppMethodBeat.o(240385);
            return gVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(240386);
            Object invokeSuspend = ((g) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(240386);
            return invokeSuspend;
        }

        /* JADX WARNING: Removed duplicated region for block: B:36:0x0100  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0104  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x011f  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0121  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x01aa  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x01c5  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0226  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x026a  */
        @Override // kotlin.d.b.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
            // Method dump skipped, instructions count: 682
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.model.c.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final /* synthetic */ void a(c cVar, long j2, C1674c cVar2) {
        AppMethodBeat.i(240395);
        com.tencent.mm.plugin.scanner.api.e eVar = cVar2.CEZ;
        if (eVar == null) {
            AppMethodBeat.o(240395);
        } else if (s.YS(eVar.imagePath)) {
            com.tencent.mm.plugin.scanner.util.f.a(eVar.imagePath, com.tencent.tinker.loader.shareutil.ShareConstants.MD5_FILE_BUF_LENGTH, new d(cVar, eVar, j2, cVar2));
            AppMethodBeat.o(240395);
        } else {
            cVar.b(j2, eVar.CAT, 3, 999, "image not exist");
            AppMethodBeat.o(240395);
        }
    }
}
