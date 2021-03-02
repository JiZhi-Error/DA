package com.tencent.mm.plugin.flutter.f;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.util.HashMap;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0010\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u001c\u0010\u0016\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\"\u0010\u0019\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J*\u0010\u001d\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\"\u0010!\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001c\u0010\"\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0016J,\u0010$\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u0006H\u0016J,\u0010&\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J(\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000fH\u0016J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u000fH\u0016J&\u0010.\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u000fJ/\u00100\u001a\b\u0012\u0004\u0012\u00020\u0006012\b\u00102\u001a\u0004\u0018\u00010\u00062\u0006\u00103\u001a\u00020 2\b\u00104\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0002\u00106R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;", "Lcom/tencent/mars/cdn/CdnLogic$VideoStreamingCallback;", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "Lcom/tencent/mars/cdn/CdnLogic$AppCallback;", "()V", "RSAPUBKEY_E", "", "RSAPUBKEY_N", "RSA_VERSION", "TAG", "USERKEY", "mTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", JsApiAddDownloadTask.NAME, "", "task", JsApiCancelDownloadTask.NAME, "mediaId", "clearAll", "", "onBadNetworkProbed", "onC2CDownloadCompleted", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDataAvailable", "offset", "", "length", "onDownloadProgressChanged", "total", "tryshow", "", "onDownloadToEnd", "onM3U8Ready", "m3u8", "onMoovReadyWithFlag", "svrflag", "onPreloadCompletedWithResult", "reportFlow", "wifi_recv", "wifi_send", "mobile_recv", "mobile_send", "requestGetCDN", "reason", "requestVideoData", "duration_ms", "resolveHost", "", "host", "is_dcip", "dnstype", "", "(Ljava/lang/String;Z[I)[Ljava/lang/String;", "plugin-flutter_release"})
public final class c implements CdnLogic.AppCallback, CdnLogic.DownloadCallback, CdnLogic.VideoStreamingCallback {
    private final String TAG = "MicroMsg.FlutterCdnService";
    private final String wKX = "1";
    private final String wKY = EncryptUtil.KEY_E;
    private final String wKZ = "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1";
    private final String wLa = "cdnwx2013usrname";
    final HashMap<String, h> wLb = new HashMap<>();

    public c() {
        AppMethodBeat.i(241143);
        StringBuilder sb = new StringBuilder();
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        CdnLogic.Initialize(sb.append(context.getFilesDir().toString()).append("/NativeCDNInfo").toString(), this, this.wKX, this.wKZ, this.wKY, this.wLa);
        AppMethodBeat.o(241143);
    }

    public final int g(h hVar) {
        AppMethodBeat.i(241133);
        p.h(hVar, "task");
        Log.d(this.TAG, "FlutterCdnService addDownloadTask mediaId:" + hVar.field_mediaId);
        CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
        c2CDownloadRequest.fileKey = hVar.field_mediaId;
        c2CDownloadRequest.url = hVar.url;
        c2CDownloadRequest.referer = hVar.referer;
        c2CDownloadRequest.setSavePath(hVar.field_fullpath);
        c2CDownloadRequest.fileSize = 0;
        c2CDownloadRequest.fileType = CdnLogic.kMediaTypeAdVideo;
        c2CDownloadRequest.concurrentCount = 10;
        c2CDownloadRequest.preloadRatio = hVar.field_preloadRatio;
        c2CDownloadRequest.preloadMinSize = hVar.preloadMinSize;
        int startHttpVideoStreamingDownload = CdnLogic.startHttpVideoStreamingDownload(c2CDownloadRequest, this, this, hVar.gqU);
        Log.d(this.TAG, "FlutterCdnService startHttpVideoStreamingDownload result:".concat(String.valueOf(startHttpVideoStreamingDownload)));
        if (startHttpVideoStreamingDownload == 0) {
            String str = hVar.field_mediaId;
            p.g(str, "task.field_mediaId");
            this.wLb.put(str, hVar);
        }
        AppMethodBeat.o(241133);
        return startHttpVideoStreamingDownload;
    }

    public final int axz(String str) {
        AppMethodBeat.i(241134);
        Log.d(this.TAG, "FlutterCdnService cancelDownloadTask mediaId:".concat(String.valueOf(str)));
        int cancelDownloadTaskWithResult = CdnLogic.cancelDownloadTaskWithResult(str, new CdnLogic.C2CDownloadResult());
        if (cancelDownloadTaskWithResult == 0) {
            HashMap<String, h> hashMap = this.wLb;
            if (hashMap == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                AppMethodBeat.o(241134);
                throw tVar;
            }
            af.fd(hashMap).remove(str);
        }
        AppMethodBeat.o(241134);
        return cancelDownloadTaskWithResult;
    }

    public final int z(String str, long j2, long j3) {
        AppMethodBeat.i(241135);
        p.h(str, "mediaId");
        Log.d(this.TAG, "FlutterCdnService requestVideoData mediaId:" + str + " offset:" + j2 + " length:" + j3);
        int requestVideoData = CdnLogic.requestVideoData(str, j2, j3, 0);
        AppMethodBeat.o(241135);
        return requestVideoData;
    }

    @Override // com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback
    public final void onM3U8Ready(String str, String str2) {
        h.a aVar;
        AppMethodBeat.i(241136);
        Log.d(this.TAG, "FlutterCdnService onM3U8Ready mediaId:".concat(String.valueOf(str)));
        h hVar = this.wLb.get(str);
        if (hVar == null || (aVar = hVar.gre) == null) {
            AppMethodBeat.o(241136);
            return;
        }
        aVar.Ds(str);
        AppMethodBeat.o(241136);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback
    public final void onMoovReadyWithFlag(String str, long j2, long j3, String str2) {
        h.a aVar;
        AppMethodBeat.i(241137);
        Log.d(this.TAG, "FlutterCdnService onMoovReadyWithFlag mediaId:" + str + " offset:" + j2 + " length:" + j3);
        h hVar = this.wLb.get(str);
        if (hVar == null || (aVar = hVar.gre) == null) {
            AppMethodBeat.o(241137);
            return;
        }
        aVar.a(str, j2, j3, str2);
        AppMethodBeat.o(241137);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback
    public final void onDataAvailable(String str, long j2, long j3) {
        h.a aVar;
        AppMethodBeat.i(241138);
        Log.d(this.TAG, "FlutterCdnService onDataAvailable mediaId:" + str + " offset:" + j2 + " length:" + j3);
        h hVar = this.wLb.get(str);
        if (hVar == null || (aVar = hVar.gre) == null) {
            AppMethodBeat.o(241138);
            return;
        }
        aVar.onDataAvailable(str, j2, j3);
        AppMethodBeat.o(241138);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback
    public final void onDownloadToEnd(String str, long j2, long j3) {
        AppMethodBeat.i(241139);
        Log.d(this.TAG, "FlutterCdnService onDownloadToEnd mediaId:" + str + " offset:" + j2 + " length:" + j3);
        AppMethodBeat.o(241139);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback
    public final void onPreloadCompletedWithResult(String str, long j2, long j3, CdnLogic.C2CDownloadResult c2CDownloadResult) {
        h.a aVar;
        AppMethodBeat.i(241140);
        Log.d(this.TAG, "FlutterCdnService onPreloadCompletedWithResult mediaId:" + str + " offset:" + j2 + " total:" + j3);
        h hVar = this.wLb.get(str);
        if (hVar == null || (aVar = hVar.gre) == null) {
            AppMethodBeat.o(241140);
            return;
        }
        aVar.i(str, j2, j3);
        AppMethodBeat.o(241140);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.DownloadCallback
    public final void onDownloadProgressChanged(String str, long j2, long j3, boolean z) {
        h.a aVar;
        AppMethodBeat.i(241141);
        Log.d(this.TAG, "FlutterCdnService onDownloadProgressChanged mediaId:" + str + " offset:" + j2 + " total:" + j3);
        h hVar = this.wLb.get(str);
        if (hVar == null || (aVar = hVar.gre) == null) {
            AppMethodBeat.o(241141);
            return;
        }
        aVar.i(str, j2, j3);
        AppMethodBeat.o(241141);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.DownloadCallback
    public final void onC2CDownloadCompleted(String str, CdnLogic.C2CDownloadResult c2CDownloadResult) {
        h.a aVar;
        h.a aVar2;
        AppMethodBeat.i(241142);
        Log.d(this.TAG, "FlutterCdnService onC2CDownloadCompleted mediaId:" + str + " result:" + c2CDownloadResult);
        h hVar = this.wLb.get(str);
        d dVar = new d();
        if (c2CDownloadResult != null) {
            dVar.field_recvedBytes = c2CDownloadResult.recvedBytes;
            dVar.field_fileLength = c2CDownloadResult.fileSize;
            if (hVar == null || (aVar2 = hVar.gre) == null) {
                AppMethodBeat.o(241142);
                return;
            }
            aVar2.a(str, c2CDownloadResult.errorCode, dVar);
            AppMethodBeat.o(241142);
        } else if (hVar == null || (aVar = hVar.gre) == null) {
            AppMethodBeat.o(241142);
        } else {
            aVar.a(str, -1, null);
            AppMethodBeat.o(241142);
        }
    }

    @Override // com.tencent.mars.cdn.CdnLogic.AppCallback
    public final void requestGetCDN(int i2) {
    }

    @Override // com.tencent.mars.cdn.CdnLogic.AppCallback
    public final void reportFlow(int i2, int i3, int i4, int i5) {
    }

    @Override // com.tencent.mars.cdn.CdnLogic.AppCallback
    public final String[] resolveHost(String str, boolean z, int[] iArr) {
        return new String[0];
    }

    @Override // com.tencent.mars.cdn.CdnLogic.AppCallback
    public final void onBadNetworkProbed() {
    }
}
