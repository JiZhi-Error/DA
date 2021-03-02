package com.tencent.thumbplayer.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.appbrand.jsapi.pay.s;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.api.ITPSurface;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.g.f;
import com.tencent.thumbplayer.utils.g;
import com.tencent.thumbplayer.utils.i;
import java.util.Map;

public final class c implements ITPPlayListener {
    private long RZU;
    f.m SaK = new f.m();
    f.k SaL = new f.k();
    f.g SaM = new f.g();
    long SaN;
    String SaO;
    private Object SaP;
    private Object SaQ;
    private Object SaR;
    private int SaS;
    private int SaT;
    private int SaU;
    private String SaV;
    int SaW;
    int SaX;
    private b SaY;
    private a SaZ;
    private i Sba = new i();
    private String mContentType;
    private Looper mLooper;

    public interface b {
        int A(int i2, String str, int i3);

        void DX(boolean z);

        void DY(boolean z);

        void V(int i2, int i3, String str);

        Object a(int i2, Object obj, Object obj2);

        void a(int i2, int i3, long j2, long j3, String str);

        void a(ITPSurface iTPSurface);

        void a(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack);

        void a(ITPMediaAsset iTPMediaAsset, long j2, TPVideoInfo tPVideoInfo, int i2);

        void a(f.b bVar);

        void a(String str, long j2, TPVideoInfo tPVideoInfo, int i2);

        void a(String str, String str2, TPDownloadParamData tPDownloadParamData);

        void a(String str, String str2, String str3, TPDownloadParamData tPDownloadParamData);

        void aY(int i2, long j2);

        void aZ(int i2, long j2);

        void arA(int i2);

        String arx(int i2);

        long ary(int i2);

        String arz(int i2);

        void asf();

        int b(int i2, String str, long j2, long j3);

        void b(TPOptionalParam tPOptionalParam);

        void b(TPVideoInfo tPVideoInfo);

        void ba(int i2, long j2);

        void bqD(String str);

        void bqE(String str);

        void bu(String str, String str2, String str3);

        void c(SurfaceHolder surfaceHolder);

        void cN(float f2);

        void cO(float f2);

        void co(Map<String, String> map);

        void d(boolean z, long j2, long j3);

        long dw(int i2, String str);

        String dx(int i2, String str);

        void hnF();

        void hnG();

        void hnH();

        void hnI();

        void hnJ();

        void hnK();

        void hnL();

        void hnM();

        long hnN();

        long hnO();

        int hnP();

        int hnQ();

        long hnR();

        int hnS();

        int hnT();

        int hnU();

        TPTrackInfo[] hnV();

        TPProgramInfo[] hnW();

        void hnX();

        long hnY();

        int hnZ();

        long hoa();

        void l(Surface surface);

        void mz(int i2, int i3);

        void nO(String str, String str2);

        int t(int i2, long j2, long j3);
    }

    static /* synthetic */ void a(c cVar, Message message) {
        AppMethodBeat.i(189484);
        cVar.a(message, true);
        AppMethodBeat.o(189484);
    }

    c(Looper looper, b bVar) {
        AppMethodBeat.i(189442);
        this.mLooper = looper;
        this.SaZ = new a(looper);
        this.SaY = bVar;
        AppMethodBeat.o(189442);
    }

    /* access modifiers changed from: package-private */
    public final void addSubtitleSource(String str, String str2, String str3, TPDownloadParamData tPDownloadParamData) {
        AppMethodBeat.i(189443);
        f.h hVar = new f.h();
        hVar.url = str;
        hVar.mimeType = str2;
        hVar.name = str3;
        hVar.SbH = tPDownloadParamData;
        a(6, 0, 0, hVar, true, false);
        AppMethodBeat.o(189443);
    }

    /* access modifiers changed from: package-private */
    public final void addAudioTrackSource(String str, String str2, TPDownloadParamData tPDownloadParamData) {
        AppMethodBeat.i(189444);
        f.a aVar = new f.a();
        aVar.url = str;
        aVar.name = str2;
        aVar.Sbv = tPDownloadParamData;
        a(7, 0, 0, aVar, true, false);
        AppMethodBeat.o(189444);
    }

    /* access modifiers changed from: package-private */
    public final void switchDefinition(String str, long j2, TPVideoInfo tPVideoInfo, int i2) {
        AppMethodBeat.i(189445);
        f.j jVar = new f.j();
        jVar.url = str;
        jVar.SbK = j2;
        jVar.SbL = tPVideoInfo;
        jVar.mode = i2;
        a(31, 0, 0, jVar, true, true);
        AppMethodBeat.o(189445);
    }

    /* access modifiers changed from: package-private */
    public final void switchDefinition(ITPMediaAsset iTPMediaAsset, long j2, TPVideoInfo tPVideoInfo, int i2) {
        AppMethodBeat.i(189446);
        f.j jVar = new f.j();
        jVar.Sby = iTPMediaAsset;
        jVar.SbK = j2;
        jVar.SbL = tPVideoInfo;
        jVar.mode = i2;
        a(31, 0, 0, jVar, true, true);
        AppMethodBeat.o(189446);
    }

    /* access modifiers changed from: package-private */
    public final long getDurationMs() {
        AppMethodBeat.i(189447);
        try {
            long hnN = this.SaY.hnN();
            AppMethodBeat.o(189447);
            return hnN;
        } catch (Throwable th) {
            g.e("TPThumbPlayer[TPPlayerInternal.java]", th);
            AppMethodBeat.o(189447);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final long getCurrentPositionMs() {
        AppMethodBeat.i(189448);
        try {
            long hnO = this.SaY.hnO();
            AppMethodBeat.o(189448);
            return hnO;
        } catch (Throwable th) {
            g.e("TPThumbPlayer[TPPlayerInternal.java]", th);
            AppMethodBeat.o(189448);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final int getBufferPercent() {
        AppMethodBeat.i(189449);
        try {
            int hnQ = this.SaY.hnQ();
            AppMethodBeat.o(189449);
            return hnQ;
        } catch (Throwable th) {
            g.e("TPThumbPlayer[TPPlayerInternal.java]", th);
            AppMethodBeat.o(189449);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final long getPlayableDurationMs() {
        AppMethodBeat.i(189450);
        try {
            long hnR = this.SaY.hnR();
            AppMethodBeat.o(189450);
            return hnR;
        } catch (Throwable th) {
            g.e("TPThumbPlayer[TPPlayerInternal.java]", th);
            AppMethodBeat.o(189450);
            return 0;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadProgressUpdate(int i2, int i3, long j2, long j3, String str) {
        AppMethodBeat.i(189451);
        TPPlayerMsg.TPDownLoadProgressInfo tPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
        tPDownLoadProgressInfo.playableDurationMS = (long) i2;
        tPDownLoadProgressInfo.downloadSpeedKBps = i3;
        tPDownLoadProgressInfo.currentDownloadSize = j2;
        tPDownLoadProgressInfo.totalFileSize = j3;
        tPDownLoadProgressInfo.extraInfo = str;
        a(83, 0, 0, tPDownLoadProgressInfo, false, false);
        AppMethodBeat.o(189451);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadFinish() {
        AppMethodBeat.i(189452);
        a(70, 0, 0, null, false, false);
        AppMethodBeat.o(189452);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadError(int i2, int i3, String str) {
        AppMethodBeat.i(189453);
        a(71, i2, i3, str, false, false);
        AppMethodBeat.o(189453);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final Object onPlayCallback(int i2, Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.i(189454);
        hoh();
        f.d dVar = new f.d();
        dVar.bca = i2;
        dVar.SbB = obj;
        dVar.SbC = obj2;
        dVar.SbD = obj3;
        dVar.SbE = obj4;
        a(77, 0, 0, dVar, false, false);
        hoj();
        hoi();
        Object obj5 = this.SaP;
        AppMethodBeat.o(189454);
        return obj5;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadCdnUrlUpdate(String str) {
        AppMethodBeat.i(189455);
        a(72, 0, 0, str, false, false);
        AppMethodBeat.o(189455);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(189456);
        TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
        tPCDNURLInfo.url = str;
        tPCDNURLInfo.cdnIp = str2;
        tPCDNURLInfo.uIp = str3;
        tPCDNURLInfo.errorStr = str4;
        a(73, 0, 0, tPCDNURLInfo, false, false);
        AppMethodBeat.o(189456);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadCdnUrlExpired(Map<String, String> map) {
        AppMethodBeat.i(189457);
        a(76, 0, 0, map, false, false);
        AppMethodBeat.o(189457);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadStatusUpdate(int i2) {
        AppMethodBeat.i(189458);
        a(74, i2, 0, null, false, false);
        AppMethodBeat.o(189458);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadProtocolUpdate(String str, String str2) {
        AppMethodBeat.i(189459);
        TPPlayerMsg.TPProtocolInfo tPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
        tPProtocolInfo.protocolVersion = str2;
        tPProtocolInfo.protocolName = str;
        a(75, 0, 0, tPProtocolInfo, false, false);
        AppMethodBeat.o(189459);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final long getPlayerBufferLength() {
        AppMethodBeat.i(189460);
        try {
            long hnY = this.SaY.hnY();
            AppMethodBeat.o(189460);
            return hnY;
        } catch (Throwable th) {
            g.e("TPThumbPlayer[TPPlayerInternal.java]", th);
            AppMethodBeat.o(189460);
            return 0;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final long getCurrentPosition() {
        AppMethodBeat.i(189461);
        long currentPositionMs = getCurrentPositionMs();
        AppMethodBeat.o(189461);
        return currentPositionMs;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final int getCurrentPlayClipNo() {
        AppMethodBeat.i(189462);
        try {
            int hnZ = this.SaY.hnZ();
            AppMethodBeat.o(189462);
            return hnZ;
        } catch (Throwable th) {
            g.e("TPThumbPlayer[TPPlayerInternal.java]", th);
            AppMethodBeat.o(189462);
            return 0;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final long getAdvRemainTime() {
        AppMethodBeat.i(189463);
        try {
            long hoa = this.SaY.hoa();
            AppMethodBeat.o(189463);
            return hoa;
        } catch (Throwable th) {
            g.e("TPThumbPlayer[TPPlayerInternal.java]", th);
            AppMethodBeat.o(189463);
            return 0;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final Object getPlayInfo(long j2) {
        AppMethodBeat.i(189464);
        hoh();
        a(82, 0, 0, Long.valueOf(j2), false, false);
        hoj();
        hoi();
        Object obj = this.SaQ;
        AppMethodBeat.o(189464);
        return obj;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final Object getPlayInfo(String str) {
        AppMethodBeat.i(189465);
        hoh();
        a(84, 0, 0, str, false, false);
        hoj();
        hoi();
        Object obj = this.SaR;
        AppMethodBeat.o(189465);
        return obj;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final int onStartReadData(int i2, String str, long j2, long j3) {
        AppMethodBeat.i(189466);
        int b2 = this.SaY.b(i2, str, j2, j3);
        AppMethodBeat.o(189466);
        return b2;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final int onReadData(int i2, String str, long j2, long j3) {
        AppMethodBeat.i(189467);
        int t = this.SaY.t(i2, j2, j3);
        AppMethodBeat.o(189467);
        return t;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final int onStopReadData(int i2, String str, int i3) {
        AppMethodBeat.i(189468);
        int A = this.SaY.A(i2, str, i3);
        AppMethodBeat.o(189468);
        return A;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final long getDataTotalSize(int i2, String str) {
        AppMethodBeat.i(189469);
        long dw = this.SaY.dw(i2, str);
        AppMethodBeat.o(189469);
        return dw;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final String getDataFilePath(int i2, String str) {
        AppMethodBeat.i(189470);
        String arx = this.SaY.arx(i2);
        AppMethodBeat.o(189470);
        return arx;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final String getContentType(int i2, String str) {
        AppMethodBeat.i(189471);
        String dx = this.SaY.dx(i2, str);
        AppMethodBeat.o(189471);
        return dx;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3, int i4, Object obj, boolean z, boolean z2) {
        AppMethodBeat.i(189472);
        hog();
        if (this.SaZ == null) {
            g.i("TPThumbPlayer[TPPlayerInternal.java]", arB(i2) + " , send failed , handler null");
            hof();
            AppMethodBeat.o(189472);
        } else if (!z || obj != null) {
            if (z2) {
                this.SaZ.removeMessages(i2);
            }
            Message obtainMessage = this.SaZ.obtainMessage();
            obtainMessage.what = i2;
            obtainMessage.arg1 = i3;
            obtainMessage.arg2 = i4;
            obtainMessage.obj = obj;
            if (hoe()) {
                a(obtainMessage, false);
            } else {
                this.SaZ.sendMessageDelayed(obtainMessage, 0);
            }
            hof();
            AppMethodBeat.o(189472);
        } else {
            g.i("TPThumbPlayer[TPPlayerInternal.java]", arB(i2) + ", send failed , params null");
            hof();
            AppMethodBeat.o(189472);
        }
    }

    private boolean hoe() {
        AppMethodBeat.i(189473);
        if (Looper.myLooper() == this.mLooper) {
            AppMethodBeat.o(189473);
            return true;
        }
        AppMethodBeat.o(189473);
        return false;
    }

    private void hof() {
        AppMethodBeat.i(189474);
        if (!hoe()) {
            this.Sba.readLock().unlock();
        }
        AppMethodBeat.o(189474);
    }

    private void hog() {
        AppMethodBeat.i(189475);
        if (!hoe()) {
            this.Sba.readLock().lock();
        }
        AppMethodBeat.o(189475);
    }

    /* access modifiers changed from: package-private */
    public final void hoh() {
        AppMethodBeat.i(189476);
        if (!hoe()) {
            this.Sba.writeLock().lock();
        }
        AppMethodBeat.o(189476);
    }

    /* access modifiers changed from: package-private */
    public final void hoi() {
        AppMethodBeat.i(189477);
        if (!hoe()) {
            this.Sba.writeLock().unlock();
        }
        AppMethodBeat.o(189477);
    }

    private static String arB(int i2) {
        AppMethodBeat.i(189479);
        switch (i2) {
            case 1:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> set player params";
            case 2:
            case 3:
            case 9:
            case 24:
            case 25:
            case 26:
            case 34:
            case 40:
            case 44:
            case 45:
            case 46:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case n.CTRL_INDEX:
            case 58:
            case bv.CTRL_INDEX:
            case 60:
            case PlayerException.EXCEPTION_TYPE_INITLIB:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case TPCodecParamers.TP_PROFILE_H264_MAIN:
            case h.a.CTRL_INDEX:
            case 79:
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL:
            case 81:
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE:
            case 83:
            case com.tencent.mm.plugin.appbrand.jsapi.r.f.CTRL_INDEX:
            default:
                String concat = "[tpPlayer] -> ".concat(String.valueOf(i2));
                AppMethodBeat.o(189479);
                return concat;
            case 4:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> set surface";
            case 5:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> set data source";
            case 6:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> set subtitle source";
            case 7:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> add audio source";
            case 8:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> add select track";
            case 10:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> prepare async";
            case 11:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> start";
            case 12:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> pause";
            case 13:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> stop";
            case 14:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> reset";
            case 15:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> release";
            case 16:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> seek to";
            case 17:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> set output mute";
            case 18:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> set audio gain ratio";
            case 19:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> set speed ratio";
            case 20:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> set loopback with param";
            case 21:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> get video width";
            case 22:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> get video height";
            case 23:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> get track info";
            case 27:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> get property long";
            case 28:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> get property string";
            case 29:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> set video info";
            case 30:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> capture video";
            case 31:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> switch def";
            case 32:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> select program";
            case 33:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> get program";
            case 35:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> set loopback";
            case 36:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> deselect track";
            case 37:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> stopAsync";
            case 38:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> set audio normalize volume params";
            case 39:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> set surfaceHolder";
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> pauseDownload";
            case 42:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> resumeDownload";
            case 43:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> get current player state";
            case d.CTRL_INDEX:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> cdn info update";
            case s.CTRL_INDEX:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> start read data";
            case com.tencent.mm.plugin.appbrand.jsapi.pay.b.CTRL_INDEX:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> read data";
            case 87:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> stop read data";
            case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> get data total size";
            case PlayerException.EXCEPTION_IN_CHECK_STATE:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> get data file path";
            case 90:
                AppMethodBeat.o(189479);
                return "[tpPlayer] -> get content type";
        }
    }

    /* access modifiers changed from: package-private */
    public final void hoj() {
        AppMethodBeat.i(189480);
        if (hoe()) {
            AppMethodBeat.o(189480);
            return;
        }
        hok();
        AppMethodBeat.o(189480);
    }

    private void hok() {
        AppMethodBeat.i(189481);
        this.Sba.OG(500);
        AppMethodBeat.o(189481);
    }

    private void a(Message message, boolean z) {
        AppMethodBeat.i(189482);
        if (!(message.what == 83 || message.what == 73 || message.what == 74 || message.what == 43 || message.what == 86)) {
            g.i("TPThumbPlayer[TPPlayerInternal.java]", "internalMessage " + arB(message.what));
        }
        switch (message.what) {
            case 1:
                this.SaY.b((TPOptionalParam) message.obj);
                AppMethodBeat.o(189482);
                return;
            case 4:
                this.SaY.l((Surface) message.obj);
                AppMethodBeat.o(189482);
                return;
            case 5:
                this.SaY.a((f.b) message.obj);
                AppMethodBeat.o(189482);
                return;
            case 6:
                f.h hVar = (f.h) message.obj;
                if (hVar != null) {
                    this.SaY.a(hVar.url, hVar.mimeType, hVar.name, hVar.SbH);
                    AppMethodBeat.o(189482);
                    return;
                }
                break;
            case 7:
                f.a aVar = (f.a) message.obj;
                if (aVar != null) {
                    this.SaY.a(aVar.url, aVar.name, aVar.Sbv);
                    AppMethodBeat.o(189482);
                    return;
                }
                break;
            case 8:
                this.SaY.aY(message.arg1, (long) message.arg2);
                AppMethodBeat.o(189482);
                return;
            case 10:
                this.SaY.hnH();
                AppMethodBeat.o(189482);
                return;
            case 11:
                this.SaY.hnI();
                AppMethodBeat.o(189482);
                return;
            case 12:
                this.SaY.asf();
                AppMethodBeat.o(189482);
                return;
            case 13:
                this.SaY.hnJ();
                DZ(z);
                AppMethodBeat.o(189482);
                return;
            case 14:
                this.SaY.hnL();
                DZ(z);
                AppMethodBeat.o(189482);
                return;
            case 15:
                this.SaY.hnM();
                DZ(z);
                this.SaZ.removeCallbacksAndMessages(null);
                AppMethodBeat.o(189482);
                return;
            case 16:
                this.SaY.mz(message.arg1, message.arg2);
                AppMethodBeat.o(189482);
                return;
            case 17:
                this.SaY.DX(((Boolean) message.obj).booleanValue());
                AppMethodBeat.o(189482);
                return;
            case 18:
                this.SaY.cN(((Float) message.obj).floatValue());
                AppMethodBeat.o(189482);
                return;
            case 19:
                this.SaY.cO(((Float) message.obj).floatValue());
                AppMethodBeat.o(189482);
                return;
            case 20:
                f.c cVar = (f.c) message.obj;
                if (cVar != null) {
                    this.SaY.d(cVar.RVI, cVar.Sbz, cVar.SbA);
                    AppMethodBeat.o(189482);
                    return;
                }
                break;
            case 21:
            case 22:
            case 23:
            case 27:
            case 28:
            case 33:
            case 40:
            case 43:
                Q(message.what, message.arg1, z);
                AppMethodBeat.o(189482);
                return;
            case 29:
                this.SaY.b((TPVideoInfo) message.obj);
                AppMethodBeat.o(189482);
                return;
            case 30:
                this.SaY.a(((f.l) message.obj).SbN, ((f.l) message.obj).SbO);
                AppMethodBeat.o(189482);
                return;
            case 31:
                f.j jVar = (f.j) message.obj;
                if (jVar != null) {
                    if (!TextUtils.isEmpty(jVar.url)) {
                        this.SaY.a(jVar.url, jVar.SbK, jVar.SbL, jVar.mode);
                        AppMethodBeat.o(189482);
                        return;
                    }
                    this.SaY.a(jVar.Sby, jVar.SbK, jVar.SbL, jVar.mode);
                    AppMethodBeat.o(189482);
                    return;
                }
                break;
            case 32:
                this.SaY.ba(message.arg1, (long) message.arg2);
                AppMethodBeat.o(189482);
                return;
            case 35:
                this.SaY.DY(((Boolean) message.obj).booleanValue());
                AppMethodBeat.o(189482);
                return;
            case 36:
                this.SaY.aZ(message.arg1, (long) message.arg2);
                AppMethodBeat.o(189482);
                return;
            case 37:
                this.SaY.hnK();
                AppMethodBeat.o(189482);
                return;
            case 38:
                this.SaY.bqD((String) message.obj);
                AppMethodBeat.o(189482);
                return;
            case 39:
                this.SaY.c((SurfaceHolder) message.obj);
                AppMethodBeat.o(189482);
                return;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                this.SaY.hnF();
                AppMethodBeat.o(189482);
                return;
            case 42:
                this.SaY.hnG();
                AppMethodBeat.o(189482);
                return;
            case 44:
                this.SaY.a((ITPSurface) message.obj);
                AppMethodBeat.o(189482);
                return;
            case 70:
                this.SaY.hnX();
                AppMethodBeat.o(189482);
                return;
            case 71:
                this.SaY.V(message.arg1, message.arg2, (String) message.obj);
                AppMethodBeat.o(189482);
                return;
            case 72:
                this.SaY.bqE((String) message.obj);
                AppMethodBeat.o(189482);
                return;
            case d.CTRL_INDEX:
                TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = (TPPlayerMsg.TPCDNURLInfo) message.obj;
                this.SaY.bu(tPCDNURLInfo.url, tPCDNURLInfo.cdnIp, tPCDNURLInfo.uIp);
                AppMethodBeat.o(189482);
                return;
            case 74:
                this.SaY.arA(message.arg1);
                AppMethodBeat.o(189482);
                return;
            case 75:
                TPPlayerMsg.TPProtocolInfo tPProtocolInfo = (TPPlayerMsg.TPProtocolInfo) message.obj;
                this.SaY.nO(tPProtocolInfo.protocolName, tPProtocolInfo.protocolVersion);
                AppMethodBeat.o(189482);
                return;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                this.SaY.co((Map) message.obj);
                AppMethodBeat.o(189482);
                return;
            case TPCodecParamers.TP_PROFILE_H264_MAIN:
                f.d dVar = (f.d) message.obj;
                this.SaP = this.SaY.a(dVar.bca, dVar.SbB, dVar.SbD);
                DZ(z);
                AppMethodBeat.o(189482);
                return;
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE:
                ((Long) message.obj).longValue();
                this.SaQ = null;
                DZ(z);
                AppMethodBeat.o(189482);
                return;
            case 83:
                TPPlayerMsg.TPDownLoadProgressInfo tPDownLoadProgressInfo = (TPPlayerMsg.TPDownLoadProgressInfo) message.obj;
                this.SaY.a((int) tPDownLoadProgressInfo.playableDurationMS, tPDownLoadProgressInfo.downloadSpeedKBps, tPDownLoadProgressInfo.currentDownloadSize, tPDownLoadProgressInfo.totalFileSize, tPDownLoadProgressInfo.extraInfo);
                AppMethodBeat.o(189482);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.r.f.CTRL_INDEX:
                Object obj = message.obj;
                this.SaR = null;
                DZ(z);
                AppMethodBeat.o(189482);
                return;
            case s.CTRL_INDEX:
                f.C2210f fVar = (f.C2210f) message.obj;
                this.SaS = this.SaY.b(fVar.SbF, fVar.fileKey, fVar.requestStart, fVar.requestEnd);
                DZ(z);
                AppMethodBeat.o(189482);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.pay.b.CTRL_INDEX:
                f.e eVar = (f.e) message.obj;
                this.SaT = this.SaY.t(eVar.SbF, eVar.offset, eVar.length);
                DZ(z);
                AppMethodBeat.o(189482);
                return;
            case 87:
                this.SaU = this.SaY.A(message.arg1, (String) message.obj, message.arg2);
                DZ(z);
                AppMethodBeat.o(189482);
                return;
            case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
                this.RZU = this.SaY.dw(message.arg1, (String) message.obj);
                DZ(z);
                AppMethodBeat.o(189482);
                return;
            case PlayerException.EXCEPTION_IN_CHECK_STATE:
                b bVar = this.SaY;
                int i2 = message.arg1;
                Object obj2 = message.obj;
                this.SaV = bVar.arx(i2);
                DZ(z);
                AppMethodBeat.o(189482);
                return;
            case 90:
                this.mContentType = this.SaY.dx(message.arg1, (String) message.obj);
                DZ(z);
                break;
        }
        AppMethodBeat.o(189482);
    }

    private void Q(int i2, int i3, boolean z) {
        AppMethodBeat.i(189483);
        switch (i2) {
            case 21:
                this.SaK.width = this.SaY.hnS();
                break;
            case 22:
                this.SaK.height = this.SaY.hnT();
                break;
            case 23:
                this.SaL.SbM = this.SaY.hnV();
                break;
            case 27:
                this.SaN = this.SaY.ary(i3);
                break;
            case 28:
                this.SaO = this.SaY.arz(i3);
                break;
            case 33:
                this.SaM.SbG = this.SaY.hnW();
                break;
            case 40:
                this.SaX = this.SaY.hnU();
                break;
            case 43:
                this.SaW = this.SaY.hnP();
                break;
        }
        DZ(z);
        AppMethodBeat.o(189483);
    }

    /* access modifiers changed from: package-private */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(189441);
            c.a(c.this, message);
            AppMethodBeat.o(189441);
        }
    }

    private void DZ(boolean z) {
        AppMethodBeat.i(189478);
        if (z) {
            this.Sba.writeLock().lock();
        }
        if (z) {
            this.Sba.Sfu.signalAll();
        }
        if (z) {
            this.Sba.writeLock().unlock();
        }
        AppMethodBeat.o(189478);
    }
}
