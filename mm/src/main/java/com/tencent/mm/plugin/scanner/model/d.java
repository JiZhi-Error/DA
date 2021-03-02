package com.tencent.mm.plugin.scanner.model;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.ms;
import com.tencent.mm.protocal.protobuf.mt;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 G2\u00020\u0001:\u0004FGHIB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tJ\u001a\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000bJ\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0014\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0014\u0010\"\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0018\u0010#\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J \u0010$\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0003H\u0002J\b\u0010&\u001a\u00020\u0015H\u0002J*\u0010'\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0018\u0010+\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-H\u0002J*\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010*2\b\u00100\u001a\u0004\u0018\u000101J\u0006\u00102\u001a\u00020\u0015J\u0010\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u0003H\u0002J\u0010\u00105\u001a\u00020\u00152\b\u00106\u001a\u0004\u0018\u00010\u000eJ\u0001\u00107\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\b\b\u0002\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010=\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001a\u00020\u000b2\b\b\u0002\u0010B\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u001d2\b\u0010D\u001a\u0004\u0018\u00010!2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010E\u001a\u00020\u0015H\u0002R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0018\u00010\u0011R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0018\u00010\u0011R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;", "", "source", "", "callback", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "(ILcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;)V", "count", "currentSession", "", "isCancelled", "", "isFinished", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "needLocation", "runningRequest", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "scanResultCallback", "waitingRequest", "cancelResult", "", "session", "doHandleResult", "result", "Landroid/os/Bundle;", "finishResult", "success", "getAdInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "getJsApiInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;", "getScanGoodsRequest", "handleResult", "notifyEvent", "event", "onError", "onScanFailed", "errCode", "errMsg", "", "onScanSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveTimeOut", "timeOut", "setLocation", FirebaseAnalytics.b.LOCATION, "uploadImage", "frameId", "imageData", "", "mode", "requestType", "originWidth", "originHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "usingAI", "isAiCrop", "adInfo", "jsApiInfo", "uploadNext", "AiScanImageUploadCallback", "Companion", "Event", "RequestInfo", "plugin-scan_release"})
public final class d {
    public static final b CFk = new b((byte) 0);
    public mu CAV;
    private long CFg;
    private final a CFh;
    private c CFi;
    private c CFj;
    private boolean isCancelled;
    private boolean isFinished;
    private boolean pRi;
    private int source;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H&J*\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "", "onUploadError", "", "errCode", "", "onUploadEvent", "source", "session", "", "event", "onUploadFailed", "errMsg", "", "onUploadSuccess", "result", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "plugin-scan_release"})
    public interface a {
        void a(int i2, long j2, int i3, String str);

        void a(z zVar);

        void aD(int i2, long j2);

        void ePM();
    }

    static {
        AppMethodBeat.i(52157);
        AppMethodBeat.o(52157);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "", "(Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;)V", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "isFinished", "", "()Z", "setFinished", "(Z)V", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getNetScene", "()Lcom/tencent/mm/modelbase/NetSceneBase;", "setNetScene", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "session", "", "getSession", "()J", "setSession", "(J)V", "source", "", "getSource", "()I", "setSource", "(I)V", "plugin-scan_release"})
    public final class c {
        q CFl;
        long dDZ;
        Bundle dQL;
        boolean isFinished;
        int source;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }
    }

    public d(int i2, a aVar) {
        p.h(aVar, "callback");
        AppMethodBeat.i(52156);
        this.source = i2;
        this.CFh = aVar;
        AppMethodBeat.o(52156);
    }

    public final void c(long j2, Bundle bundle) {
        c cVar;
        AppMethodBeat.i(52147);
        if (bundle == null) {
            AppMethodBeat.o(52147);
            return;
        }
        int i2 = bundle.getInt("scan_source", 0);
        if (this.CFj == null || ((cVar = this.CFj) != null && cVar.isFinished)) {
            c cVar2 = new c();
            cVar2.source = i2;
            cVar2.dDZ = j2;
            cVar2.isFinished = false;
            cVar2.dQL = bundle;
            this.CFj = cVar2;
            d(j2, bundle);
            AppMethodBeat.o(52147);
            return;
        }
        Log.i("MicroMsg.AiScanImageUploader", "alvinluo handleResult replace waiting request");
        if (this.CFi == null) {
            this.CFi = new c();
        }
        c cVar3 = this.CFi;
        if (cVar3 != null) {
            cVar3.source = i2;
            cVar3.dDZ = j2;
            cVar3.isFinished = false;
            cVar3.dQL = bundle;
            AppMethodBeat.o(52147);
            return;
        }
        AppMethodBeat.o(52147);
    }

    public final void F(long j2, boolean z) {
        q qVar;
        AppMethodBeat.i(161972);
        Log.i("MicroMsg.AiScanImageUploader", "alvinluo finishResult current: %d, session: %d, success: %b", Long.valueOf(this.CFg), Long.valueOf(j2), Boolean.valueOf(z));
        if (this.CFg == j2) {
            this.pRi = false;
            this.isFinished = true;
            t azz = g.azz();
            c cVar = this.CFj;
            if (cVar != null) {
                qVar = cVar.CFl;
            } else {
                qVar = null;
            }
            azz.a(qVar);
            this.CFi = null;
            this.CFj = null;
        }
        AppMethodBeat.o(161972);
    }

    public final void Ix(long j2) {
        q qVar;
        AppMethodBeat.i(52149);
        Log.i("MicroMsg.AiScanImageUploader", "alvinluo cancelResult session: %d", Long.valueOf(j2));
        if (this.CFg == j2) {
            this.isCancelled = true;
            this.pRi = false;
            t azz = g.azz();
            c cVar = this.CFj;
            if (cVar != null) {
                qVar = cVar.CFl;
            } else {
                qVar = null;
            }
            azz.a(qVar);
            this.CFi = null;
            this.CFj = null;
        }
        AppMethodBeat.o(52149);
    }

    public static void release() {
        AppMethodBeat.i(52150);
        Log.i("MicroMsg.AiScanImageUploader", "alvinluo release");
        AppMethodBeat.o(52150);
    }

    private final void d(long j2, Bundle bundle) {
        AppMethodBeat.i(52151);
        if (bundle == null) {
            AppMethodBeat.o(52151);
            return;
        }
        if (this.CFg != j2) {
            this.isFinished = false;
            this.CFg = j2;
        }
        int i2 = bundle.getInt("scan_source", 0);
        byte[] byteArray = bundle.getByteArray("result_best_img");
        int i3 = bundle.getInt("key_scan_goods_mode", 0);
        ScanGoodsRequest ax = ax(bundle);
        mt b2 = b(ax);
        int i4 = ax != null ? ax.requestType : 0;
        Log.i("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage doHandleResult session: %d, source: %d, mode: %d", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 1) {
            int i5 = bundle.getInt("result_best_img_id", 0);
            int i6 = bundle.getInt("result_img_origin_width", 0);
            int i7 = bundle.getInt("result_img_origin_height", 0);
            GoodsObject goodsObject = new GoodsObject();
            try {
                goodsObject.parseFrom(bundle.getByteArray("result_crop_object"));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AiScanImageUploader", e2, "alvinluo handleResult cropObject parseFrom exception", new Object[0]);
            }
            if (byteArray != null) {
                a(j2, i5, byteArray, i3, i4, i2, i6, i7, goodsObject, x.isUsingAI(), x.isAICrop(), a(ax), b2, this.CAV);
                AppMethodBeat.o(52151);
                return;
            }
            onError();
            AppMethodBeat.o(52151);
        } else if (i2 != 2) {
            onError();
            AppMethodBeat.o(52151);
        } else if (byteArray != null) {
            a(this, j2, byteArray, i3, i4, i2, b2);
            AppMethodBeat.o(52151);
        } else {
            onError();
            AppMethodBeat.o(52151);
        }
    }

    private final void onError() {
        AppMethodBeat.i(52152);
        this.CFh.ePM();
        AppMethodBeat.o(52152);
    }

    private static /* synthetic */ void a(d dVar, long j2, byte[] bArr, int i2, int i3, int i4, mt mtVar) {
        AppMethodBeat.i(240398);
        dVar.a(j2, 0, bArr, i2, i3, i4, 0, 0, null, false, false, null, mtVar, null);
        AppMethodBeat.o(240398);
    }

    private final void a(long j2, int i2, byte[] bArr, int i3, int i4, int i5, int i6, int i7, GoodsObject goodsObject, boolean z, boolean z2, ms msVar, mt mtVar, mu muVar) {
        AppMethodBeat.i(240397);
        Log.i("MicroMsg.AiScanImageUploader", "alvinluo uploadImage imageData: %d, mode: %d", Integer.valueOf(bArr.length), Integer.valueOf(i3));
        g gVar = new g(bArr, i5, i3, i4, j2, i2, z, z2, i6, i7, goodsObject, msVar, mtVar, muVar);
        c cVar = this.CFj;
        if (cVar != null) {
            cVar.CFl = gVar;
        }
        g.azz().b(gVar);
        AppMethodBeat.o(240397);
    }

    private static ScanGoodsRequest ax(Bundle bundle) {
        AppMethodBeat.i(240399);
        if (bundle == null) {
            AppMethodBeat.o(240399);
            return null;
        }
        try {
            ScanGoodsRequest scanGoodsRequest = (ScanGoodsRequest) bundle.getParcelable("key_scan_request");
            AppMethodBeat.o(240399);
            return scanGoodsRequest;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AiScanImageUploader", e2, "getScanGoodsRequest exception", new Object[0]);
            AppMethodBeat.o(240399);
            return null;
        }
    }

    private static ms a(ScanGoodsRequest scanGoodsRequest) {
        AppMethodBeat.i(240400);
        if (scanGoodsRequest == null) {
            AppMethodBeat.o(240400);
            return null;
        }
        try {
            ms msVar = new ms();
            msVar.gTk = scanGoodsRequest.getExtra("key_sns_ad_ux_info", "");
            msVar.KQZ = Util.safeParseInt(scanGoodsRequest.getExtra("key_gesture_id", ""));
            Log.d("MicroMsg.AiScanImageUploader", "getAdInfo uxInfo: %s, gestureId: %s", msVar.gTk, Integer.valueOf(msVar.KQZ));
            AppMethodBeat.o(240400);
            return msVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AiScanImageUploader", e2, "getAdInfo exception", new Object[0]);
            AppMethodBeat.o(240400);
            return null;
        }
    }

    private static mt b(ScanGoodsRequest scanGoodsRequest) {
        AppMethodBeat.i(240401);
        if (scanGoodsRequest == null) {
            AppMethodBeat.o(240401);
            return null;
        }
        try {
            mt mtVar = new mt();
            mtVar.KRa = scanGoodsRequest.extInfo;
            Log.d("MicroMsg.AiScanImageUploader", "getJsApiInfo %s", mtVar.KRa);
            AppMethodBeat.o(240401);
            return mtVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AiScanImageUploader", e2, "getJsApiInfo exception", new Object[0]);
            AppMethodBeat.o(240401);
            return null;
        }
    }

    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        mw mwVar;
        boolean z2;
        c cVar;
        AppMethodBeat.i(52155);
        if (qVar != null) {
            if (qVar.getType() == 2580) {
                boolean z3 = true;
                if (i2 == 0 && i3 == 0) {
                    g gVar = (g) qVar;
                    if (gVar.rr.aYK() != null) {
                        com.tencent.mm.bw.a aYK = gVar.rr.aYK();
                        if (aYK == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageResponse");
                            AppMethodBeat.o(52155);
                            throw tVar;
                        }
                        mwVar = (mw) aYK;
                    } else {
                        mwVar = null;
                    }
                    if (!(mwVar == null || !mwVar.KRz || mwVar.KRz == this.pRi)) {
                        this.pRi = true;
                        int i4 = this.source;
                        long j2 = mwVar.KRi;
                        if (this.isFinished || this.isCancelled) {
                            Log.w("MicroMsg.AiScanImageUploader", "alvinluo notifyEvent isFinished and ignore");
                        } else {
                            Log.d("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage notifyEvent source: %d, session: %d, event: %d", Integer.valueOf(i4), Long.valueOf(j2), 1);
                            this.CFh.aD(i4, j2);
                        }
                    }
                    if (mwVar == null || mwVar.KRi != ((g) qVar).dDZ) {
                        Log.w("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd success sessionId not the same");
                    } else {
                        Log.d("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd sessionId: %s, scanId: %s", Long.valueOf(mwVar.KRi), Integer.valueOf(mwVar.KRh));
                        int i5 = this.source;
                        Log.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, isFinished: %b, isCancelled: %b", Integer.valueOf(i5), Boolean.valueOf(this.isFinished), Boolean.valueOf(this.isCancelled));
                        if (this.isFinished || this.isCancelled) {
                            Log.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess isFinished and ignore");
                        } else if (this.CFj == null || ((cVar = this.CFj) != null && cVar.isFinished)) {
                            Object[] objArr = new Object[2];
                            if (this.CFj == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objArr[0] = Boolean.valueOf(z2);
                            c cVar2 = this.CFj;
                            objArr[1] = cVar2 != null ? Boolean.valueOf(cVar2.isFinished) : null;
                            Log.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess runningRequest invalid and ignore isNull: %b, isFinished: %s", objArr);
                        } else {
                            x.a(new C1675d(this, mwVar, i5));
                        }
                    }
                } else {
                    if (i3 == 1003) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!this.isCancelled && !this.isFinished) {
                        int i6 = this.source;
                        long j3 = ((g) qVar).dDZ;
                        Log.e("MicroMsg.AiScanImageUploader", "alvinluo onScanFailed source: %d, errCode: %d, errMsg: %s", Integer.valueOf(i6), Integer.valueOf(i3), str);
                        if (i6 == 1) {
                            x.ePZ();
                        }
                        this.CFh.a(i6, j3, i3, str);
                    }
                    z3 = z;
                }
                this.CFj = null;
                if (z3) {
                    Log.d("MicroMsg.AiScanImageUploader", "alvinluo uploadNext: %b, isCancelled: %b", Boolean.valueOf(this.isFinished), Boolean.valueOf(this.isCancelled));
                    c cVar3 = this.CFj;
                    if (cVar3 != null) {
                        cVar3.isFinished = true;
                    }
                    this.CFj = null;
                    if (this.isFinished || this.isCancelled) {
                        AppMethodBeat.o(52155);
                        return;
                    } else if (this.CFi != null) {
                        c cVar4 = this.CFi;
                        if (cVar4 == null) {
                            p.hyc();
                        }
                        if (!cVar4.isFinished) {
                            this.CFj = this.CFi;
                            c cVar5 = this.CFi;
                            if (cVar5 == null) {
                                p.hyc();
                            }
                            long j4 = cVar5.dDZ;
                            c cVar6 = this.CFi;
                            if (cVar6 == null) {
                                p.hyc();
                            }
                            Bundle bundle = cVar6.dQL;
                            this.CFi = null;
                            d(j4, bundle);
                        }
                    }
                }
            }
            AppMethodBeat.o(52155);
            return;
        }
        AppMethodBeat.o(52155);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.scanner.model.d$d  reason: collision with other inner class name */
    static final class C1675d implements y {
        final /* synthetic */ d CFm;
        final /* synthetic */ mw CFn;
        final /* synthetic */ int CFo;

        C1675d(d dVar, mw mwVar, int i2) {
            this.CFm = dVar;
            this.CFn = mwVar;
            this.CFo = i2;
        }

        public final void run() {
            AppMethodBeat.i(52146);
            final z a2 = x.a(this.CFn, this.CFo);
            h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.plugin.scanner.model.d.C1675d.AnonymousClass1 */
                final /* synthetic */ C1675d CFp;

                {
                    this.CFp = r1;
                }

                public final void run() {
                    AppMethodBeat.i(52145);
                    a2.source = this.CFp.CFo;
                    Log.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, showResult: %b, isFinish: %b, isCancelled: %b", Integer.valueOf(this.CFp.CFo), Boolean.valueOf(a2.CGj), Boolean.valueOf(this.CFp.CFm.isFinished), Boolean.valueOf(this.CFp.CFm.isCancelled));
                    if (!this.CFp.CFm.isFinished && !this.CFp.CFm.isCancelled) {
                        this.CFp.CFm.CFh.a(a2);
                    }
                    AppMethodBeat.o(52145);
                }
            });
            AppMethodBeat.o(52146);
        }
    }
}
