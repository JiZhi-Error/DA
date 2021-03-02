package com.tencent.thumbplayer.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.c.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.thumbplayer.a.a.c;
import com.tencent.thumbplayer.a.d;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener;
import com.tencent.thumbplayer.api.ITPSurface;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.g.a.a.e;
import com.tencent.thumbplayer.g.c;
import com.tencent.thumbplayer.g.f;
import com.tencent.thumbplayer.utils.f;
import com.tencent.thumbplayer.utils.g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ugc.TXRecordCommon;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class b implements ITPPlayer, c.b {
    private static AtomicInteger SaF = new AtomicInteger(1000);
    private static String Saq = "api call:";
    private com.tencent.thumbplayer.f.a RVN;
    private int SaA;
    private ArrayList<String> SaB;
    private long SaC;
    private long SaD;
    private long SaE;
    private AtomicInteger SaG;
    private boolean SaH;
    private com.tencent.thumbplayer.a.a Sar;
    private c Sas;
    private d Sat;
    private com.tencent.thumbplayer.e.a Sau;
    private com.tencent.thumbplayer.g.a.a.c Sav;
    private com.tencent.thumbplayer.e.a.a Saw;
    private com.tencent.thumbplayer.g.a.b Sax;
    private a Say;
    private boolean Saz;
    private Context mContext;
    private HandlerThread mHandlerThread;
    private String mUrl;

    static /* synthetic */ void a(b bVar, int i2, int i3) {
        AppMethodBeat.i(189438);
        bVar.mA(i2, i3);
        AppMethodBeat.o(189438);
    }

    static /* synthetic */ void a(b bVar, int i2, int i3, int i4, Object obj) {
        AppMethodBeat.i(189434);
        bVar.f(i2, i3, i4, obj);
        AppMethodBeat.o(189434);
    }

    static /* synthetic */ void a(b bVar, int i2, Object obj) {
        AppMethodBeat.i(189433);
        bVar.a(i2, 0, 0, (String) null, obj);
        AppMethodBeat.o(189433);
    }

    static /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(189439);
        bVar.hod();
        AppMethodBeat.o(189439);
    }

    static {
        AppMethodBeat.i(189440);
        AppMethodBeat.o(189440);
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, Looper looper) {
        this(context, looper, null);
    }

    public b(Context context, Looper looper, Looper looper2) {
        this(context, looper, looper2, null);
    }

    public b(Context context, Looper looper, Looper looper2, com.tencent.thumbplayer.f.b bVar) {
        com.tencent.thumbplayer.f.b bVar2;
        AppMethodBeat.i(189313);
        this.mUrl = null;
        this.Saz = true;
        this.SaA = -1;
        this.SaG = new AtomicInteger(1000);
        this.SaH = false;
        if (bVar != null) {
            bVar2 = new com.tencent.thumbplayer.f.b(bVar, "TPPlayer");
        } else {
            com.tencent.thumbplayer.f.b bVar3 = new com.tencent.thumbplayer.f.b("ThumbPlayer", String.valueOf(SaF.incrementAndGet()), String.valueOf(this.SaG.incrementAndGet()), "TPPlayer");
            this.SaH = true;
            bVar2 = bVar3;
        }
        this.RVN = new com.tencent.thumbplayer.f.a(bVar2);
        this.RVN.info("create TPPlayer");
        this.mContext = context.getApplicationContext();
        this.Sax = new com.tencent.thumbplayer.g.a.c();
        this.Sav = new com.tencent.thumbplayer.g.a.a.c(this.mContext);
        this.Sax.a(this.Sav);
        a(100, 0, 0, (String) null, new f().S("stime", Long.valueOf(System.currentTimeMillis())).map);
        if (looper2 == null) {
            this.Say = new a(this);
        } else {
            this.Say = new a(this, looper2);
        }
        C2209b bVar4 = new C2209b();
        this.Sat = new d(this.RVN.RVM.tag);
        this.Sar = new d(this.mContext, bVar2);
        this.Sar.a((c.f) bVar4);
        this.Sar.a((c.AbstractC2201c) bVar4);
        this.Sar.a((c.e) bVar4);
        this.Sar.a((c.m) bVar4);
        this.Sar.a((c.d) bVar4);
        this.Sar.a((c.g) bVar4);
        this.Sar.a((c.m) bVar4);
        this.Sar.a((c.i) bVar4);
        this.Sar.a((c.j) bVar4);
        this.Sar.a((c.a) bVar4);
        this.Sar.a((c.k) bVar4);
        this.Sar.a((c.l) bVar4);
        this.Sar.a((c.b) bVar4);
        this.Sar.setOnPlayerStateChangeListener(bVar4);
        if (looper == null || looper == Looper.getMainLooper()) {
            this.mHandlerThread = new HandlerThread("TP-workthread");
            this.mHandlerThread.start();
            looper = this.mHandlerThread.getLooper();
        }
        this.Sas = new c(looper, this);
        a(101, 0, 0, (String) null, new f().S("etime", Long.valueOf(System.currentTimeMillis())).map);
        this.Sau = new com.tencent.thumbplayer.e.c(context);
        this.Sau.a(bVar4);
        this.Sax.a(new e()).a(new com.tencent.thumbplayer.g.a.a.b());
        this.SaB = new ArrayList<>();
        AppMethodBeat.o(189313);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void updateLoggerContext(com.tencent.thumbplayer.f.b bVar) {
        AppMethodBeat.i(189314);
        if (bVar != null) {
            this.SaH = false;
            this.RVN.a(new com.tencent.thumbplayer.f.b(bVar, "TPPlayer"));
            this.Sar.updateLoggerContext(this.RVN.RVM);
            if (this.Sat != null) {
                this.Sat.bqx(this.RVN.RVM.tag);
            }
        }
        AppMethodBeat.o(189314);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setPlayerOptionalParam(TPOptionalParam tPOptionalParam) {
        AppMethodBeat.i(189315);
        this.Sas.a(1, 0, 0, tPOptionalParam, true, false);
        AppMethodBeat.o(189315);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public ITPPlayerProxy getPlayerProxy() {
        return this.Sau;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public ITPBusinessReportManager getReportManager() {
        return this.Sav;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void enableTPAssetResourceLoader(ITPAssetResourceLoaderListener iTPAssetResourceLoaderListener, Looper looper) {
        AppMethodBeat.i(189316);
        if (iTPAssetResourceLoaderListener != null) {
            this.Sau.DV(true);
            if (this.Saw != null) {
                this.Saw.release();
                this.Saw = null;
            }
            this.Saw = new com.tencent.thumbplayer.e.a.b(this.mContext, looper);
            this.Saw.a(iTPAssetResourceLoaderListener);
            this.Saw.hnB();
            AppMethodBeat.o(189316);
            return;
        }
        this.Sau.DV(false);
        AppMethodBeat.o(189316);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void enableTPAssetResourceLoader(com.tencent.thumbplayer.e.a.a aVar) {
        AppMethodBeat.i(189317);
        this.RVN.info(Saq + "enableTPAssetResourceLoader, assetResourceLoader:" + aVar);
        if (aVar != null) {
            this.Sau.DV(true);
            if (this.Saw != null) {
                this.Saw.release();
                this.Saw = null;
            }
            this.Saw = aVar;
            AppMethodBeat.o(189317);
            return;
        }
        this.Sau.DV(false);
        AppMethodBeat.o(189317);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener iOnPreparedListener) {
        if (this.Sat != null) {
            d dVar = this.Sat;
            if (iOnPreparedListener == null) {
                iOnPreparedListener = dVar.Sbq;
            }
            dVar.Sbc = iOnPreparedListener;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener iOnCompletionListener) {
        if (this.Sat != null) {
            d dVar = this.Sat;
            if (iOnCompletionListener == null) {
                iOnCompletionListener = dVar.Sbq;
            }
            dVar.Sbd = iOnCompletionListener;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnInfoListener(ITPPlayerListener.IOnInfoListener iOnInfoListener) {
        if (this.Sat != null) {
            d dVar = this.Sat;
            if (iOnInfoListener == null) {
                iOnInfoListener = dVar.Sbq;
            }
            dVar.Sbe = iOnInfoListener;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnErrorListener(ITPPlayerListener.IOnErrorListener iOnErrorListener) {
        if (this.Sat != null) {
            d dVar = this.Sat;
            if (iOnErrorListener == null) {
                iOnErrorListener = dVar.Sbq;
            }
            dVar.Sbf = iOnErrorListener;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener) {
        if (this.Sat != null) {
            d dVar = this.Sat;
            if (iOnSeekCompleteListener == null) {
                iOnSeekCompleteListener = dVar.Sbq;
            }
            dVar.Sbg = iOnSeekCompleteListener;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener) {
        if (this.Sat != null) {
            d dVar = this.Sat;
            if (iOnVideoSizeChangedListener == null) {
                iOnVideoSizeChangedListener = dVar.Sbq;
            }
            dVar.Sbh = iOnVideoSizeChangedListener;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener iOnSubtitleDataListener) {
        if (this.Sat != null) {
            d dVar = this.Sat;
            if (iOnSubtitleDataListener == null) {
                iOnSubtitleDataListener = dVar.Sbq;
            }
            dVar.Sbi = iOnSubtitleDataListener;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener iOnSubtitleFrameOutListener) {
        if (this.Sat != null) {
            d dVar = this.Sat;
            if (iOnSubtitleFrameOutListener == null) {
                iOnSubtitleFrameOutListener = dVar.Sbq;
            }
            dVar.Sbj = iOnSubtitleFrameOutListener;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener iOnVideoFrameOutListener) {
        if (this.Sat != null) {
            d dVar = this.Sat;
            if (iOnVideoFrameOutListener == null) {
                iOnVideoFrameOutListener = dVar.Sbq;
            }
            dVar.Sbk = iOnVideoFrameOutListener;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnAudioFrameOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener iOnAudioFrameOutputListener) {
        if (this.Sat != null) {
            d dVar = this.Sat;
            if (iOnAudioFrameOutputListener == null) {
                iOnAudioFrameOutputListener = dVar.Sbq;
            }
            dVar.Sbl = iOnAudioFrameOutputListener;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnAudioProcessFrameOutputListener(ITPPlayerListener.IOnAudioProcessFrameOutputListener iOnAudioProcessFrameOutputListener) {
        if (this.Sat != null) {
            d dVar = this.Sat;
            if (iOnAudioProcessFrameOutputListener == null) {
                iOnAudioProcessFrameOutputListener = dVar.Sbq;
            }
            dVar.Sbn = iOnAudioProcessFrameOutputListener;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnVideoProcessFrameOutputListener(ITPPlayerListener.IOnVideoProcessFrameOutputListener iOnVideoProcessFrameOutputListener) {
        if (this.Sat != null) {
            d dVar = this.Sat;
            if (iOnVideoProcessFrameOutputListener == null) {
                iOnVideoProcessFrameOutputListener = dVar.Sbq;
            }
            dVar.Sbm = iOnVideoProcessFrameOutputListener;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener iOnStateChangeListener) {
        if (this.Sat != null) {
            d dVar = this.Sat;
            if (iOnStateChangeListener == null) {
                iOnStateChangeListener = dVar.Sbq;
            }
            dVar.Sbo = iOnStateChangeListener;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener iOnStopAsyncCompleteListener) {
        if (this.Sat != null) {
            d dVar = this.Sat;
            if (iOnStopAsyncCompleteListener == null) {
                iOnStopAsyncCompleteListener = dVar.Sbq;
            }
            dVar.Sbp = iOnStopAsyncCompleteListener;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setSurface(Surface surface) {
        AppMethodBeat.i(189318);
        this.RVN.info(Saq + "setSurface, surface:" + surface);
        this.Sas.a(4, 0, 0, surface, false, false);
        AppMethodBeat.o(189318);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(189319);
        this.RVN.info(Saq + "setSurfaceHolder, SurfaceHolder:" + surfaceHolder);
        this.Sas.a(39, 0, 0, surfaceHolder, false, false);
        AppMethodBeat.o(189319);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setTPSurface(ITPSurface iTPSurface) {
        AppMethodBeat.i(189320);
        this.RVN.info(Saq + "setTPSurface, tpSurface:" + iTPSurface);
        this.Sas.a(44, 0, 0, iTPSurface, false, false);
        AppMethodBeat.o(189320);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setDataSource(String str) {
        AppMethodBeat.i(189321);
        this.RVN.info(Saq + "setDataSource, url:" + str);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("error : setDataSource , data source invalid");
            AppMethodBeat.o(189321);
            throw illegalArgumentException;
        }
        c cVar = this.Sas;
        f.b bVar = new f.b();
        bVar.url = str;
        cVar.a(5, 0, 0, bVar, true, false);
        AppMethodBeat.o(189321);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setDataSource(String str, Map<String, String> map) {
        AppMethodBeat.i(189322);
        this.RVN.info(Saq + "setDataSource, url:" + str + ", httpHeader:" + map);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("error : setDataSource , data source invalid");
            AppMethodBeat.o(189322);
            throw illegalArgumentException;
        }
        c cVar = this.Sas;
        f.b bVar = new f.b();
        bVar.url = str;
        bVar.Sbw = map;
        cVar.a(5, 0, 0, bVar, true, false);
        AppMethodBeat.o(189322);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setDataSource(ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(189323);
        this.RVN.info(Saq + "setDataSource, ParcelFileDescriptor");
        if (parcelFileDescriptor == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("error : setDataSource , pfd invalid");
            AppMethodBeat.o(189323);
            throw illegalArgumentException;
        }
        c cVar = this.Sas;
        f.b bVar = new f.b();
        bVar.Sbx = parcelFileDescriptor;
        cVar.a(5, 0, 0, bVar, true, false);
        AppMethodBeat.o(189323);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setDataSource(ITPMediaAsset iTPMediaAsset) {
        AppMethodBeat.i(189324);
        this.RVN.info(Saq + "setDataSource, ITPMediaAsset");
        if (iTPMediaAsset == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("asset is null");
            AppMethodBeat.o(189324);
            throw illegalArgumentException;
        } else if (!(iTPMediaAsset instanceof ITPMediaDRMAsset) || (!TextUtils.isEmpty(iTPMediaAsset.getUrl()) && ((ITPMediaDRMAsset) iTPMediaAsset).getDrmAllProperties() != null && !((ITPMediaDRMAsset) iTPMediaAsset).getDrmAllProperties().isEmpty())) {
            c cVar = this.Sas;
            f.b bVar = new f.b();
            bVar.Sby = iTPMediaAsset;
            cVar.a(5, 0, 0, bVar, true, false);
            AppMethodBeat.o(189324);
        } else {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("drm asset url is null or drm property is null");
            AppMethodBeat.o(189324);
            throw illegalArgumentException2;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setVideoInfo(TPVideoInfo tPVideoInfo) {
        AppMethodBeat.i(189325);
        this.Sas.a(29, 0, 0, tPVideoInfo, true, false);
        AppMethodBeat.o(189325);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void addSubtitleSource(String str, String str2, String str3) {
        AppMethodBeat.i(189326);
        this.RVN.info(Saq + "addSubtitleSource, url:" + str + ", mimeType:" + str2 + ", name:" + str3);
        this.Sas.addSubtitleSource(str, str2, str3, null);
        AppMethodBeat.o(189326);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void addSubtitleSource(String str, String str2, String str3, TPDownloadParamData tPDownloadParamData) {
        AppMethodBeat.i(189327);
        this.RVN.info(Saq + "addSubtitleSource, url:" + str + ", name:" + str3 + ", downloadParamData:" + tPDownloadParamData);
        this.Sas.addSubtitleSource(str, str2, str3, tPDownloadParamData);
        AppMethodBeat.o(189327);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void addAudioTrackSource(String str, String str2) {
        AppMethodBeat.i(189328);
        this.RVN.info(Saq + "addAudioTrackSource, url:" + str + ", name:" + str2);
        this.Sas.addAudioTrackSource(str, str2, null);
        AppMethodBeat.o(189328);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void addAudioTrackSource(String str, String str2, TPDownloadParamData tPDownloadParamData) {
        AppMethodBeat.i(189329);
        this.RVN.info(Saq + "addAudioTrackSource, url:" + str + ", name:" + str2 + ", downloadParamData:" + tPDownloadParamData);
        this.Sas.addAudioTrackSource(str, str2, tPDownloadParamData);
        AppMethodBeat.o(189329);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void selectTrack(int i2, long j2) {
        AppMethodBeat.i(189330);
        this.RVN.info(Saq + "selectTrack, trackIndex:" + i2 + ", opaque:" + j2);
        this.Sas.a(8, i2, (int) j2, null, false, false);
        AppMethodBeat.o(189330);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void deselectTrack(int i2, long j2) {
        AppMethodBeat.i(189331);
        this.RVN.info(Saq + "deselectTrack, trackIndex:" + i2 + ", opaque:" + j2);
        this.Sas.a(36, i2, (int) j2, null, false, false);
        AppMethodBeat.o(189331);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void selectProgram(int i2, long j2) {
        AppMethodBeat.i(189332);
        this.RVN.info(Saq + "selectProgram, programIndex:" + i2 + ", opaque:" + j2);
        this.Sas.a(32, i2, (int) j2, null, false, false);
        AppMethodBeat.o(189332);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public TPProgramInfo[] getProgramInfo() {
        AppMethodBeat.i(189333);
        this.RVN.info(Saq + "getProgramInfo");
        c cVar = this.Sas;
        cVar.hoh();
        cVar.SaM.SbG = null;
        g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get program info");
        cVar.a(33, 0, 0, null, false, false);
        cVar.hoj();
        cVar.hoi();
        TPProgramInfo[] tPProgramInfoArr = cVar.SaM.SbG;
        AppMethodBeat.o(189333);
        return tPProgramInfoArr;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void prepareAsync() {
        AppMethodBeat.i(189334);
        this.RVN.info(Saq + "prepareAsync");
        this.Sas.a(10, 0, 0, null, false, false);
        AppMethodBeat.o(189334);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void start() {
        AppMethodBeat.i(189335);
        this.RVN.info(Saq + "start");
        this.Sas.a(11, 0, 0, null, false, false);
        AppMethodBeat.o(189335);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void pause() {
        AppMethodBeat.i(189336);
        this.RVN.info(Saq + "pause");
        this.Sas.a(12, 0, 0, null, false, false);
        AppMethodBeat.o(189336);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void stop() {
        AppMethodBeat.i(189337);
        this.RVN.info(Saq + "stop");
        c cVar = this.Sas;
        cVar.hoh();
        g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : stop");
        cVar.a(13, 0, 0, null, false, false);
        cVar.hoj();
        cVar.hoi();
        AppMethodBeat.o(189337);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void stopAsync() {
        AppMethodBeat.i(189338);
        this.RVN.info(Saq + "stopAsync");
        c cVar = this.Sas;
        g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : stopAsync");
        cVar.a(37, 0, 0, null, false, false);
        AppMethodBeat.o(189338);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void reset() {
        AppMethodBeat.i(189339);
        this.RVN.info(Saq + "reset");
        if (this.SaH) {
            com.tencent.thumbplayer.f.a aVar = this.RVN;
            String valueOf = String.valueOf(this.SaG.incrementAndGet());
            com.tencent.thumbplayer.f.b bVar = aVar.RVM;
            bVar.taskId = valueOf;
            bVar.hnE();
            this.Sar.updateLoggerContext(this.RVN.RVM);
            if (this.Sat != null) {
                this.Sat.bqx(this.RVN.RVM.tag);
            }
        }
        c cVar = this.Sas;
        cVar.hoh();
        g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : reset");
        cVar.a(14, 0, 0, null, false, false);
        cVar.hoj();
        cVar.hoi();
        AppMethodBeat.o(189339);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void release() {
        AppMethodBeat.i(189340);
        this.RVN.info(Saq + "release");
        c cVar = this.Sas;
        cVar.hoh();
        g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : release");
        cVar.a(15, 0, 0, null, false, false);
        cVar.hoj();
        cVar.hoi();
        this.Sax.release();
        AppMethodBeat.o(189340);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void seekTo(int i2) {
        AppMethodBeat.i(189341);
        this.RVN.info(Saq + "seekTo, positionMs:" + i2);
        this.Sas.a(16, i2, 0, null, false, false);
        AppMethodBeat.o(189341);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void seekTo(int i2, int i3) {
        AppMethodBeat.i(189342);
        this.RVN.info(Saq + "seekTo, positionMs:" + i2 + ", mode:" + i3);
        this.Sas.a(16, i2, i3, null, false, false);
        AppMethodBeat.o(189342);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOutputMute(boolean z) {
        AppMethodBeat.i(189343);
        this.RVN.info(Saq + "setOutputMute, isOutputMute:" + z);
        this.Sas.a(17, 0, 0, Boolean.valueOf(z), false, true);
        AppMethodBeat.o(189343);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setAudioGainRatio(float f2) {
        AppMethodBeat.i(189344);
        this.RVN.info(Saq + "setAudioGainRatio, gainRatio:" + f2);
        this.Sas.a(18, 0, 0, Float.valueOf(f2), false, true);
        AppMethodBeat.o(189344);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setAudioNormalizeVolumeParams(String str) {
        AppMethodBeat.i(189345);
        this.RVN.info(Saq + "setAudioNormalizeVolumeParams, audioNormalizeVolumeParams:" + str);
        this.Sas.a(38, 0, 0, str, false, true);
        AppMethodBeat.o(189345);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setPlaySpeedRatio(float f2) {
        AppMethodBeat.i(189346);
        this.RVN.info(Saq + "setPlaySpeedRatio, speedRatio:" + f2);
        this.Sas.a(19, 0, 0, Float.valueOf(f2), false, true);
        AppMethodBeat.o(189346);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setLoopback(boolean z) {
        AppMethodBeat.i(189347);
        this.RVN.info(Saq + "setLoopback, isLoopback:" + z);
        this.Sas.a(35, 0, 0, Boolean.valueOf(z), true, true);
        AppMethodBeat.o(189347);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setLoopback(boolean z, long j2, long j3) {
        AppMethodBeat.i(189348);
        this.RVN.info(Saq + "setLoopback, isLoopback:" + z + ", loopStartPositionMs:" + j2 + ", loopEndPositionMs:" + j3);
        c cVar = this.Sas;
        f.c cVar2 = new f.c();
        cVar2.RVI = z;
        cVar2.Sbz = j2;
        cVar2.SbA = j3;
        cVar.a(20, 0, 0, cVar2, true, true);
        AppMethodBeat.o(189348);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void switchDefinition(String str, long j2, TPVideoInfo tPVideoInfo) {
        AppMethodBeat.i(189349);
        this.RVN.info(Saq + "switchDefinition, defUrl:" + str + ", defID:" + j2);
        this.Sas.switchDefinition(str, j2, tPVideoInfo, 2);
        AppMethodBeat.o(189349);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void switchDefinition(ITPMediaAsset iTPMediaAsset, long j2, TPVideoInfo tPVideoInfo) {
        AppMethodBeat.i(189350);
        this.RVN.info(Saq + "switchDefinition, mediaAsset:" + iTPMediaAsset + ", defID:" + j2 + ", videoInfo:" + tPVideoInfo);
        this.Sas.switchDefinition(iTPMediaAsset, j2, tPVideoInfo, 2);
        AppMethodBeat.o(189350);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void switchDefinition(String str, long j2, TPVideoInfo tPVideoInfo, int i2) {
        AppMethodBeat.i(189351);
        this.RVN.info(Saq + "switchDefinition, defUrl:" + str + ", defID:" + j2 + ", mode:" + i2);
        this.Sas.switchDefinition(str, j2, tPVideoInfo, i2);
        AppMethodBeat.o(189351);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void switchDefinition(ITPMediaAsset iTPMediaAsset, long j2, TPVideoInfo tPVideoInfo, int i2) {
        AppMethodBeat.i(189352);
        this.RVN.info(Saq + "switchDefinition, mediaAsset:" + iTPMediaAsset + ", defID:" + j2 + ", videoInfo:" + tPVideoInfo + ", mode:" + i2);
        this.Sas.switchDefinition(iTPMediaAsset, j2, tPVideoInfo, i2);
        AppMethodBeat.o(189352);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public long getPropertyLong(int i2) {
        AppMethodBeat.i(189353);
        this.RVN.info(Saq + "getPropertyLong, paramId:" + i2);
        c cVar = this.Sas;
        cVar.hoh();
        cVar.SaN = 0;
        g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get property long");
        cVar.a(27, i2, 0, null, false, false);
        cVar.hoj();
        cVar.hoi();
        long j2 = cVar.SaN;
        AppMethodBeat.o(189353);
        return j2;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public String getPropertyString(int i2) {
        AppMethodBeat.i(189354);
        this.RVN.info(Saq + "getPropertyString, paramId:" + i2);
        c cVar = this.Sas;
        cVar.hoh();
        cVar.SaO = null;
        g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get property string");
        cVar.a(28, i2, 0, null, false, false);
        cVar.hoj();
        cVar.hoi();
        String str = cVar.SaO;
        AppMethodBeat.o(189354);
        return str;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public long getDurationMs() {
        AppMethodBeat.i(189355);
        long durationMs = this.Sas.getDurationMs();
        AppMethodBeat.o(189355);
        return durationMs;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public long getCurrentPositionMs() {
        AppMethodBeat.i(189356);
        long currentPositionMs = this.Sas.getCurrentPositionMs();
        AppMethodBeat.o(189356);
        return currentPositionMs;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public int getCurrentState() {
        AppMethodBeat.i(189357);
        c cVar = this.Sas;
        cVar.hoh();
        cVar.SaW = 1;
        cVar.a(43, 0, 0, null, false, false);
        cVar.hoj();
        cVar.hoi();
        int i2 = cVar.SaW;
        AppMethodBeat.o(189357);
        return i2;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public int getBufferPercent() {
        AppMethodBeat.i(189358);
        int bufferPercent = this.Sas.getBufferPercent();
        AppMethodBeat.o(189358);
        return bufferPercent;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public long getPlayableDurationMs() {
        AppMethodBeat.i(189359);
        long playableDurationMs = this.Sas.getPlayableDurationMs();
        AppMethodBeat.o(189359);
        return playableDurationMs;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public int getVideoWidth() {
        AppMethodBeat.i(189360);
        this.RVN.info(Saq + "getVideoWidth");
        c cVar = this.Sas;
        cVar.hoh();
        cVar.a(21, 0, 0, null, false, false);
        cVar.hoj();
        cVar.hoi();
        int i2 = cVar.SaK.width;
        AppMethodBeat.o(189360);
        return i2;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public int getVideoHeight() {
        AppMethodBeat.i(189361);
        this.RVN.info(Saq + "getVideoHeight");
        c cVar = this.Sas;
        cVar.hoh();
        cVar.a(22, 0, 0, null, false, false);
        cVar.hoj();
        cVar.hoi();
        int i2 = cVar.SaK.height;
        AppMethodBeat.o(189361);
        return i2;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public TPTrackInfo[] getTrackInfo() {
        AppMethodBeat.i(189362);
        this.RVN.info(Saq + "getTrackInfo");
        c cVar = this.Sas;
        cVar.hoh();
        cVar.SaL.SbM = null;
        g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get trackInfo");
        cVar.a(23, 0, 0, null, false, false);
        cVar.hoj();
        cVar.hoi();
        TPTrackInfo[] tPTrackInfoArr = cVar.SaL.SbM;
        AppMethodBeat.o(189362);
        return tPTrackInfoArr;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void pauseDownload() {
        AppMethodBeat.i(189363);
        this.RVN.info(Saq + "pauseDownload");
        this.Sas.a(41, 0, 0, null, false, false);
        AppMethodBeat.o(189363);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void hnF() {
        AppMethodBeat.i(189364);
        try {
            this.Sar.setPlayerOptionalParam(new TPOptionalParam().buildLong(502, 0));
        } catch (Exception e2) {
            this.RVN.r(e2);
        }
        this.Sau.pauseDownload();
        AppMethodBeat.o(189364);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void resumeDownload() {
        AppMethodBeat.i(189365);
        this.RVN.info(Saq + "resumeDownload");
        this.Sas.a(42, 0, 0, null, false, false);
        AppMethodBeat.o(189365);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void hnG() {
        AppMethodBeat.i(189366);
        this.Sau.resumeDownload();
        try {
            this.Sar.setPlayerOptionalParam(new TPOptionalParam().buildLong(502, 1));
            AppMethodBeat.o(189366);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189366);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public int getPlayerType() {
        AppMethodBeat.i(189367);
        this.RVN.info(Saq + "getPlayerType");
        c cVar = this.Sas;
        cVar.hoh();
        cVar.SaX = 0;
        g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get player type");
        cVar.a(40, 0, 0, null, false, false);
        cVar.hoj();
        cVar.hoi();
        int i2 = cVar.SaX;
        AppMethodBeat.o(189367);
        return i2;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void captureVideo(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        AppMethodBeat.i(189368);
        this.RVN.info(Saq + "captureVideo, params:" + tPCaptureParams + ", captureCallBack:" + tPCaptureCallBack);
        c cVar = this.Sas;
        cVar.hoh();
        g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : captureVideo");
        f.l lVar = new f.l();
        lVar.SbO = tPCaptureCallBack;
        lVar.SbN = tPCaptureParams;
        cVar.a(30, 0, 0, lVar, true, false);
        cVar.hoj();
        cVar.hoi();
        AppMethodBeat.o(189368);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void b(TPOptionalParam tPOptionalParam) {
        AppMethodBeat.i(189369);
        if (tPOptionalParam == null || tPOptionalParam.getKey() != 205) {
            this.Sau.setPlayerOptionalParam(tPOptionalParam);
            try {
                this.Sar.setPlayerOptionalParam(tPOptionalParam);
                AppMethodBeat.o(189369);
            } catch (Exception e2) {
                this.RVN.r(e2);
                AppMethodBeat.o(189369);
            }
        } else {
            this.Saz = tPOptionalParam.getParamBoolean().value;
            AppMethodBeat.o(189369);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void l(Surface surface) {
        AppMethodBeat.i(189370);
        try {
            this.Sar.setSurface(surface);
            AppMethodBeat.o(189370);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189370);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void c(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(189371);
        try {
            this.Sar.setSurfaceHolder(surfaceHolder);
            AppMethodBeat.o(189371);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189371);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void a(ITPSurface iTPSurface) {
        AppMethodBeat.i(189372);
        try {
            if (iTPSurface instanceof e) {
                this.Sar.setSurface(((e) iTPSurface).Sbr);
            }
            AppMethodBeat.o(189372);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189372);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void a(f.b bVar) {
        AppMethodBeat.i(189373);
        if (bVar != null) {
            try {
                if (!TextUtils.isEmpty(bVar.url)) {
                    this.mUrl = bVar.url;
                    com.tencent.thumbplayer.a.a.e eVar = new com.tencent.thumbplayer.a.a.e(bVar.url);
                    this.RVN.info("handleSetDataSource originalUrl=" + bVar.url);
                    if (hoc()) {
                        eVar = this.Sau.bqC(bVar.url);
                        this.RVN.info("handleSetDataSource selfPlayerUrl=" + eVar.RWt);
                        this.RVN.info("handleSetDataSource systemPlayerUrl=" + eVar.RWs);
                    }
                    if (bVar.Sbw != null) {
                        this.Sar.a(eVar, bVar.Sbw);
                        AppMethodBeat.o(189373);
                        return;
                    }
                    this.Sar.a(eVar);
                    AppMethodBeat.o(189373);
                    return;
                } else if (bVar.Sby != null) {
                    if (hoc()) {
                        bVar.Sby = this.Sau.b(bVar.Sby);
                    }
                    if (bVar.Sby != null) {
                        this.RVN.info("handleSetDataSource mediaAsset=" + bVar.Sby.getUrl());
                        this.Sar.setDataSource(bVar.Sby);
                    }
                    AppMethodBeat.o(189373);
                    return;
                } else {
                    this.Sar.setDataSource(bVar.Sbx);
                    AppMethodBeat.o(189373);
                    return;
                }
            } catch (Exception e2) {
                this.RVN.r(e2);
            }
        }
        AppMethodBeat.o(189373);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void b(TPVideoInfo tPVideoInfo) {
        AppMethodBeat.i(189374);
        if (tPVideoInfo != null) {
            try {
                this.Sau.setVideoInfo(tPVideoInfo);
                this.Sar.setVideoInfo(tPVideoInfo);
            } catch (Exception e2) {
                this.RVN.r(e2);
                AppMethodBeat.o(189374);
                return;
            }
        }
        AppMethodBeat.o(189374);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void a(String str, String str2, String str3, TPDownloadParamData tPDownloadParamData) {
        AppMethodBeat.i(189375);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (!hoc() || !com.tencent.thumbplayer.utils.b.bnL(str)) {
                this.Sar.addSubtitleSource(str, str2, str3);
            } else {
                String a2 = this.Sau.a(3, str, tPDownloadParamData);
                this.SaB.add(a2);
                this.Sar.addSubtitleSource(a2, str2, str3);
            }
            a(118, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("stime", Long.valueOf(currentTimeMillis)).S("etime", Long.valueOf(System.currentTimeMillis())).S("url", str).map);
            AppMethodBeat.o(189375);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189375);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void a(String str, String str2, TPDownloadParamData tPDownloadParamData) {
        AppMethodBeat.i(189376);
        if (!hoc()) {
            this.RVN.error("handleAddAudioSource, proxy is not enable.");
            AppMethodBeat.o(189376);
        } else if (TextUtils.isEmpty(str2) || !com.tencent.thumbplayer.utils.b.bnL(str)) {
            this.RVN.error("handleAddAudioSource, illegal argument.");
            AppMethodBeat.o(189376);
        } else {
            try {
                ArrayList arrayList = new ArrayList();
                TPOptionalParam tPOptionalParam = new TPOptionalParam();
                if (tPDownloadParamData != null) {
                    tPOptionalParam.buildString(6, tPDownloadParamData.getAudioTrackKeyId());
                }
                arrayList.add(tPOptionalParam);
                this.Sar.g(str, str2, arrayList);
                AppMethodBeat.o(189376);
            } catch (Exception e2) {
                this.RVN.r(e2);
                AppMethodBeat.o(189376);
            }
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void aY(int i2, long j2) {
        AppMethodBeat.i(189377);
        try {
            TPTrackInfo[] trackInfo = this.Sar.getTrackInfo();
            if (trackInfo != null && trackInfo.length > i2) {
                a(122, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("opaque", Long.valueOf(j2)).S("tracktype", Integer.valueOf(trackInfo[i2].getTrackType())).S("stime", Long.valueOf(System.currentTimeMillis())).map);
            }
            this.Sar.selectTrack(i2, j2);
            AppMethodBeat.o(189377);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189377);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void aZ(int i2, long j2) {
        AppMethodBeat.i(189378);
        try {
            this.Sar.deselectTrack(i2, j2);
            AppMethodBeat.o(189378);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189378);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void ba(int i2, long j2) {
        AppMethodBeat.i(189379);
        try {
            this.Sar.selectProgram(i2, j2);
            AppMethodBeat.o(189379);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189379);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void hnH() {
        AppMethodBeat.i(189380);
        try {
            this.Sar.prepareAsync();
            a(102, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("stime", Long.valueOf(System.currentTimeMillis())).S("url", this.mUrl).S("p2p", Boolean.valueOf(hoc())).S("flowid", UUID.randomUUID().toString() + System.nanoTime() + "_" + com.tencent.thumbplayer.d.a.getPlatform()).map);
            f.i iVar = new f.i();
            iVar.edr = hoc() ? 1 : 0;
            f(261, 1009, 0, iVar);
            AppMethodBeat.o(189380);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189380);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void hnI() {
        AppMethodBeat.i(189381);
        try {
            this.Sar.start();
            a(104, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("stime", Long.valueOf(System.currentTimeMillis())).map);
            this.Sau.aro(0);
            AppMethodBeat.o(189381);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189381);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void asf() {
        AppMethodBeat.i(189382);
        try {
            this.Sar.pause();
            a(106, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("stime", Long.valueOf(System.currentTimeMillis())).map);
            this.Sau.aro(5);
            AppMethodBeat.o(189382);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189382);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final int b(int i2, String str, long j2, long j3) {
        AppMethodBeat.i(189383);
        if (this.Saw == null) {
            this.RVN.error("mAssetResourceLoader not set");
            AppMethodBeat.o(189383);
            return -1;
        }
        int onStartReadData = this.Saw.onStartReadData(i2, str, j2, j3);
        AppMethodBeat.o(189383);
        return onStartReadData;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final int t(int i2, long j2, long j3) {
        AppMethodBeat.i(189384);
        if (this.Saw == null) {
            this.RVN.error("mAssetResourceLoader not set");
            AppMethodBeat.o(189384);
            return -1;
        }
        int k = this.Saw.k(i2, j2, j3);
        AppMethodBeat.o(189384);
        return k;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final int A(int i2, String str, int i3) {
        AppMethodBeat.i(189385);
        if (this.Saw == null) {
            this.RVN.error("mAssetResourceLoader not set");
            AppMethodBeat.o(189385);
            return -1;
        }
        int onStopReadData = this.Saw.onStopReadData(i2, str, i3);
        AppMethodBeat.o(189385);
        return onStopReadData;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final long dw(int i2, String str) {
        AppMethodBeat.i(189386);
        if (this.Saw == null) {
            this.RVN.error("mAssetResourceLoader not set");
            AppMethodBeat.o(189386);
            return -1;
        }
        long dataTotalSize = this.Saw.getDataTotalSize(i2, str);
        AppMethodBeat.o(189386);
        return dataTotalSize;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final String arx(int i2) {
        AppMethodBeat.i(189387);
        if (this.Saw == null) {
            this.RVN.error("mAssetResourceLoader not set");
            AppMethodBeat.o(189387);
            return "";
        }
        String Mf = this.Saw.Mf(i2);
        AppMethodBeat.o(189387);
        return Mf;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final String dx(int i2, String str) {
        AppMethodBeat.i(189388);
        if (this.Saw == null) {
            this.RVN.error("mAssetResourceLoader not set");
            AppMethodBeat.o(189388);
            return "";
        }
        String contentType = this.Saw.getContentType(i2, str);
        AppMethodBeat.o(189388);
        return contentType;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void hnJ() {
        AppMethodBeat.i(189389);
        hob();
        AppMethodBeat.o(189389);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void hnK() {
        AppMethodBeat.i(189390);
        hob();
        f(280, 0, 0, null);
        AppMethodBeat.o(189390);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void hnL() {
        AppMethodBeat.i(189391);
        this.Sar.reset();
        a(113, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("etime", Long.valueOf(System.currentTimeMillis())).S("reason", 1).map);
        this.Sau.stopDownload();
        this.SaA = -1;
        this.SaB.clear();
        if (this.Saw != null) {
            this.Saw.reset();
        }
        this.SaC = -1;
        this.SaD = -1;
        this.SaE = -1;
        AppMethodBeat.o(189391);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void hnM() {
        AppMethodBeat.i(189392);
        this.Sar.release();
        a(112, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("etime", Long.valueOf(System.currentTimeMillis())).S("reason", 1).map);
        if (this.Say != null) {
            this.Say.removeCallbacksAndMessages(null);
            this.Say = null;
        }
        if (this.Sat != null) {
            d dVar = this.Sat;
            dVar.Sbc = dVar.Sbq;
            dVar.Sbd = dVar.Sbq;
            dVar.Sbe = dVar.Sbq;
            dVar.Sbf = dVar.Sbq;
            dVar.Sbg = dVar.Sbq;
            dVar.Sbh = dVar.Sbq;
            dVar.Sbi = dVar.Sbq;
            dVar.Sbk = dVar.Sbq;
            dVar.Sbl = dVar.Sbq;
            dVar.Sbo = dVar.Sbq;
            dVar.Sbp = dVar.Sbq;
            this.Sat = null;
        }
        this.Sau.release();
        this.SaB.clear();
        if (this.Saw != null) {
            this.Saw.release();
            this.Saw = null;
        }
        this.SaC = -1;
        this.SaD = -1;
        this.SaE = -1;
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
            this.mHandlerThread = null;
        }
        AppMethodBeat.o(189392);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void mz(int i2, int i3) {
        AppMethodBeat.i(189393);
        a(109, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("stime", Long.valueOf(System.currentTimeMillis())).S("format", 0).S("pstime", Long.valueOf(hnO())).map);
        if (i3 > 0) {
            try {
                this.Sar.seekTo(i2, i3);
            } catch (Exception e2) {
                this.RVN.r(e2);
            }
        } else {
            this.Sar.seekTo(i2);
        }
        this.Sau.aro(1);
        AppMethodBeat.o(189393);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void DX(boolean z) {
        AppMethodBeat.i(189394);
        try {
            this.Sar.setOutputMute(z);
            AppMethodBeat.o(189394);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189394);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void cN(float f2) {
        AppMethodBeat.i(189395);
        try {
            this.Sar.setAudioGainRatio(f2);
            AppMethodBeat.o(189395);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189395);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void bqD(String str) {
        AppMethodBeat.i(189396);
        try {
            this.Sar.setAudioNormalizeVolumeParams(str);
            AppMethodBeat.o(189396);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189396);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void cO(float f2) {
        AppMethodBeat.i(189397);
        try {
            this.Sar.setPlaySpeedRatio(f2);
        } catch (Exception e2) {
            this.RVN.r(e2);
        }
        a(116, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("scene", Float.valueOf(f2)).map);
        AppMethodBeat.o(189397);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void DY(boolean z) {
        AppMethodBeat.i(189398);
        try {
            this.Sar.setLoopback(z);
            AppMethodBeat.o(189398);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189398);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void d(boolean z, long j2, long j3) {
        AppMethodBeat.i(189399);
        try {
            this.Sar.setLoopback(z, j2, j3);
            AppMethodBeat.o(189399);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189399);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final long ary(int i2) {
        AppMethodBeat.i(189400);
        try {
            long propertyLong = this.Sar.getPropertyLong(i2);
            AppMethodBeat.o(189400);
            return propertyLong;
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189400);
            return 0;
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final String arz(int i2) {
        AppMethodBeat.i(189401);
        try {
            String propertyString = this.Sar.getPropertyString(i2);
            AppMethodBeat.o(189401);
            return propertyString;
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189401);
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final long hnN() {
        AppMethodBeat.i(189402);
        long durationMs = this.Sar.getDurationMs();
        AppMethodBeat.o(189402);
        return durationMs;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final long hnO() {
        AppMethodBeat.i(189403);
        long currentPositionMs = this.Sar.getCurrentPositionMs();
        AppMethodBeat.o(189403);
        return currentPositionMs;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final int hnP() {
        AppMethodBeat.i(189404);
        int currentState = this.Sar.getCurrentState();
        AppMethodBeat.o(189404);
        return currentState;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final int hnQ() {
        AppMethodBeat.i(189405);
        if (this.Sar.getDurationMs() == 0) {
            AppMethodBeat.o(189405);
            return 0;
        }
        int playableDurationMs = (int) ((100.0f * ((float) (this.Sar.getPlayableDurationMs() - this.Sar.getCurrentPositionMs()))) / ((float) this.Sar.getDurationMs()));
        AppMethodBeat.o(189405);
        return playableDurationMs;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final long hnR() {
        AppMethodBeat.i(189406);
        if (!hoc()) {
            long playableDurationMs = this.Sar.getPlayableDurationMs();
            AppMethodBeat.o(189406);
            return playableDurationMs;
        } else if (this.SaD <= 0 || this.SaE <= 0) {
            long j2 = this.SaC;
            AppMethodBeat.o(189406);
            return j2;
        } else {
            long durationMs = (long) (((((double) this.SaD) * 1.0d) / ((double) this.SaE)) * ((double) this.Sar.getDurationMs()));
            AppMethodBeat.o(189406);
            return durationMs;
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final int hnS() {
        AppMethodBeat.i(189407);
        int videoWidth = this.Sar.getVideoWidth();
        AppMethodBeat.o(189407);
        return videoWidth;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final int hnT() {
        AppMethodBeat.i(189408);
        int videoHeight = this.Sar.getVideoHeight();
        AppMethodBeat.o(189408);
        return videoHeight;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final int hnU() {
        AppMethodBeat.i(189409);
        int playerType = this.Sar.getPlayerType();
        AppMethodBeat.o(189409);
        return playerType;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final TPTrackInfo[] hnV() {
        AppMethodBeat.i(189410);
        TPTrackInfo[] trackInfo = this.Sar.getTrackInfo();
        AppMethodBeat.o(189410);
        return trackInfo;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final TPProgramInfo[] hnW() {
        AppMethodBeat.i(189411);
        TPProgramInfo[] programInfo = this.Sar.getProgramInfo();
        AppMethodBeat.o(189411);
        return programInfo;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void a(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        AppMethodBeat.i(189412);
        try {
            this.Sar.captureVideo(tPCaptureParams, tPCaptureCallBack);
            AppMethodBeat.o(189412);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189412);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void a(String str, long j2, TPVideoInfo tPVideoInfo, int i2) {
        AppMethodBeat.i(189413);
        com.tencent.thumbplayer.a.a.e a2 = this.Sau.a(j2, str, tPVideoInfo);
        try {
            this.RVN.info("handleSwitchDef, proxyUrl:" + str + ", defID:" + j2);
            this.Sar.a(tPVideoInfo);
            this.Sar.a(a2, i2, j2);
            a(120, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("switch", String.valueOf(j2)).map);
            AppMethodBeat.o(189413);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189413);
        }
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void a(ITPMediaAsset iTPMediaAsset, long j2, TPVideoInfo tPVideoInfo, int i2) {
        AppMethodBeat.i(189414);
        ITPMediaAsset a2 = this.Sau.a(iTPMediaAsset, j2, tPVideoInfo);
        if (a2 != null) {
            try {
                this.RVN.info("handleSwitchDef, proxyMediaAsset:" + a2 + ", defID:" + j2);
                this.Sar.a(tPVideoInfo);
                this.Sar.a(a2, i2, j2);
                a(120, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("switch", String.valueOf(j2)).map);
                AppMethodBeat.o(189414);
                return;
            } catch (Exception e2) {
                this.RVN.r(e2);
            }
        }
        AppMethodBeat.o(189414);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void a(int i2, int i3, long j2, long j3, String str) {
        AppMethodBeat.i(189415);
        this.SaC = (long) i2;
        this.SaD = j2;
        this.SaE = j3;
        TPPlayerMsg.TPDownLoadProgressInfo tPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
        tPDownLoadProgressInfo.playableDurationMS = (long) i2;
        tPDownLoadProgressInfo.downloadSpeedKBps = i3;
        tPDownLoadProgressInfo.currentDownloadSize = j2;
        tPDownLoadProgressInfo.totalFileSize = j3;
        tPDownLoadProgressInfo.extraInfo = str;
        this.RVN.info("handleOnDownloadProgressUpdate");
        a(200, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("speed", Integer.valueOf(i3)).S("spanId", str).map);
        f(a.C0693a.CTRL_INDEX, 0, 0, tPDownLoadProgressInfo);
        AppMethodBeat.o(189415);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void hnX() {
        AppMethodBeat.i(189416);
        this.RVN.info("onDownloadFinish");
        f(a.C0691a.CTRL_INDEX, 0, 0, 0);
        AppMethodBeat.o(189416);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void V(int i2, int i3, String str) {
        AppMethodBeat.i(189417);
        this.RVN.info("handleOnDownloadError, moduleID:" + i2 + ", errorCode:" + i3 + ", extInfo:" + str);
        mA(i2, i3);
        f(268, i2, i3, str);
        AppMethodBeat.o(189417);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void bqE(String str) {
        AppMethodBeat.i(189418);
        this.RVN.info("handleOnDownloadCdnUrlUpdate, url:".concat(String.valueOf(str)));
        f(269, 0, 0, str);
        AppMethodBeat.o(189418);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void bu(String str, String str2, String str3) {
        AppMethodBeat.i(189419);
        TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
        tPCDNURLInfo.url = str;
        tPCDNURLInfo.cdnIp = str2;
        tPCDNURLInfo.uIp = str3;
        a(201, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("url", str).S("cdnip", str2).S("cdnuip", str3).map);
        f(270, 0, 0, tPCDNURLInfo);
        AppMethodBeat.o(189419);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void arA(int i2) {
        AppMethodBeat.i(189420);
        f(272, i2, 0, null);
        AppMethodBeat.o(189420);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void nO(String str, String str2) {
        AppMethodBeat.i(189421);
        this.RVN.info("onDownloadProtocolUpdate, protocol:" + str + ", protocolVer:" + str2);
        TPPlayerMsg.TPProtocolInfo tPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
        tPProtocolInfo.protocolVersion = str2;
        tPProtocolInfo.protocolName = str;
        f(273, 0, 0, tPProtocolInfo);
        AppMethodBeat.o(189421);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final void co(Map<String, String> map) {
        AppMethodBeat.i(189422);
        this.RVN.info("onDownloadCdnUrlExpired");
        f(275, 0, 0, map);
        AppMethodBeat.o(189422);
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final Object a(int i2, Object obj, Object obj2) {
        AppMethodBeat.i(189423);
        switch (i2) {
            case 1:
                this.RVN.info("onDownloadNoMoreData");
                f(276, 0, 0, obj);
                break;
            case 2:
                if (obj2 instanceof Integer) {
                    f(278, ((Integer) obj2).intValue(), 0, null);
                    break;
                } else {
                    this.RVN.info("MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION, err ext3.");
                    break;
                }
        }
        AppMethodBeat.o(189423);
        return null;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final long hnY() {
        AppMethodBeat.i(189424);
        com.tencent.thumbplayer.a.a aVar = this.Sar;
        if (aVar != null) {
            long playableDurationMs = aVar.getPlayableDurationMs() - this.Sar.getCurrentPositionMs();
            AppMethodBeat.o(189424);
            return playableDurationMs;
        }
        AppMethodBeat.o(189424);
        return 0;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final int hnZ() {
        AppMethodBeat.i(189425);
        com.tencent.thumbplayer.a.a aVar = this.Sar;
        if (aVar != null) {
            int currentPlayClipNo = aVar.getCurrentPlayClipNo();
            AppMethodBeat.o(189425);
            return currentPlayClipNo;
        }
        AppMethodBeat.o(189425);
        return 0;
    }

    @Override // com.tencent.thumbplayer.g.c.b
    public final long hoa() {
        AppMethodBeat.i(189426);
        ITPPlayerProxyListener hnw = this.Sau.hnw();
        if (hnw != null) {
            long advRemainTimeMs = hnw.getAdvRemainTimeMs();
            AppMethodBeat.o(189426);
            return advRemainTimeMs;
        }
        AppMethodBeat.o(189426);
        return -1;
    }

    private void hob() {
        AppMethodBeat.i(189427);
        try {
            this.Sar.stop();
        } catch (Exception e2) {
            this.RVN.r(e2);
        }
        a(107, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("etime", Long.valueOf(System.currentTimeMillis())).S("reason", 1).map);
        this.Sau.aro(5);
        this.SaC = -1;
        this.SaD = -1;
        this.SaE = -1;
        AppMethodBeat.o(189427);
    }

    private boolean hoc() {
        AppMethodBeat.i(189428);
        if (!this.Sau.isEnable() || !com.tencent.thumbplayer.d.a.hnj() || !this.Saz) {
            AppMethodBeat.o(189428);
            return false;
        }
        AppMethodBeat.o(189428);
        return true;
    }

    private void mA(int i2, int i3) {
        AppMethodBeat.i(189429);
        a(108, i2, i3, "", new com.tencent.thumbplayer.utils.f().S("etime", Long.valueOf(System.currentTimeMillis())).S("reason", 3).S(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, i2 + "." + i3).map);
        this.Sau.aro(3);
        AppMethodBeat.o(189429);
    }

    private void hod() {
        AppMethodBeat.i(189430);
        this.Sau.aro(this.Sar.isPlaying() ? 0 : 5);
        AppMethodBeat.o(189430);
    }

    private void a(int i2, int i3, int i4, String str, Object obj) {
        AppMethodBeat.i(189431);
        try {
            if (this.Sax != null) {
                this.Sax.b(i2, i3, i4, str, obj);
            }
            AppMethodBeat.o(189431);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(189431);
        }
    }

    /* renamed from: com.tencent.thumbplayer.g.b$b  reason: collision with other inner class name */
    class C2209b implements c.a, c.b, c.AbstractC2201c, c.d, c.e, c.f, c.g, c.h, c.i, c.j, c.k, c.l, c.m, ITPPlayListener {
        C2209b() {
        }

        @Override // com.tencent.thumbplayer.a.a.c.f
        public final void tf() {
            int i2;
            AppMethodBeat.i(189281);
            b.this.Sau.aro(0);
            com.tencent.thumbplayer.a.b hmK = b.this.Sar.hmK();
            String str = hmK.width + "*" + hmK.height;
            TPTrackInfo[] trackInfo = b.this.Sar.getTrackInfo();
            if (trackInfo != null) {
                i2 = 0;
                for (TPTrackInfo tPTrackInfo : trackInfo) {
                    if (tPTrackInfo.trackType == 2) {
                        i2++;
                    }
                }
            } else {
                i2 = 0;
            }
            b.a(b.this, 103, new com.tencent.thumbplayer.utils.f().S("playertype", Integer.valueOf(b.this.Sar.getPlayerType())).S("definition", str).S("rate", Long.valueOf(hmK.RVl)).S(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Long.valueOf(hmK.durationMs)).S("fmt", hmK.RVh).S("etime", Long.valueOf(System.currentTimeMillis())).S("multitrack", Boolean.valueOf(i2 > 1)).map);
            b.a(b.this, (int) CdnLogic.kAppTypeFestivalImage, 0, 0, (Object) null);
            AppMethodBeat.o(189281);
        }

        @Override // com.tencent.thumbplayer.a.a.c.AbstractC2201c
        public final void onCompletion() {
            AppMethodBeat.i(189282);
            b.a(b.this, 111, new com.tencent.thumbplayer.utils.f().S("etime", Long.valueOf(System.currentTimeMillis())).S("reason", 0).map);
            b.a(b.this, 260, 0, 0, (Object) null);
            AppMethodBeat.o(189282);
        }

        @Override // com.tencent.thumbplayer.a.a.c.e
        public final void a(int i2, long j2, long j3, Object obj) {
            AppMethodBeat.i(189283);
            b.a(b.this, i2, j2, j3, obj);
            if (i2 == 1011) {
                b.a(b.this, obj);
                AppMethodBeat.o(189283);
            } else if (i2 == 1012) {
                b.b(b.this, obj);
                AppMethodBeat.o(189283);
            } else {
                f.i iVar = new f.i();
                iVar.edr = j2;
                iVar.SbI = j3;
                iVar.SbJ = obj;
                b.a(b.this, 261, i2, 0, (Object) iVar);
                AppMethodBeat.o(189283);
            }
        }

        @Override // com.tencent.thumbplayer.a.a.c.d
        public final void a(int i2, int i3, long j2, long j3) {
            AppMethodBeat.i(189284);
            String hnv = b.this.Sau.hnv();
            b.this.RVN.info("onError playerErrorCodeStr=".concat(String.valueOf(hnv)));
            if (!TextUtils.isEmpty(hnv)) {
                try {
                    i3 = Integer.parseInt(hnv);
                    i2 = 4000;
                } catch (Exception e2) {
                    b.this.RVN.r(e2);
                }
            }
            b.a(b.this, i2, i3);
            b.this.RVN.info("onError errorTypeReal=" + i2 + ", errorCodeReal=" + i3);
            f.i iVar = new f.i();
            iVar.edr = j2;
            iVar.SbI = j3;
            b.a(b.this, 262, i2, i3, (Object) iVar);
            AppMethodBeat.o(189284);
        }

        @Override // com.tencent.thumbplayer.a.a.c.g
        public final void cJH() {
            AppMethodBeat.i(189285);
            b.d(b.this);
            b.a(b.this, 110, new com.tencent.thumbplayer.utils.f().S("etime", Long.valueOf(System.currentTimeMillis())).S("petime", Long.valueOf(b.this.hnO())).map);
            b.a(b.this, 263, 0, 0, (Object) null);
            AppMethodBeat.o(189285);
        }

        @Override // com.tencent.thumbplayer.a.a.c.m
        public final void aI(long j2, long j3) {
            AppMethodBeat.i(189286);
            f.i iVar = new f.i();
            iVar.edr = j2;
            iVar.SbI = j3;
            b.a(b.this, 264, 0, 0, (Object) iVar);
            AppMethodBeat.o(189286);
        }

        @Override // com.tencent.thumbplayer.a.a.c.h
        public final void onStateChange(int i2, int i3) {
            AppMethodBeat.i(189287);
            b.a(b.this, 277, i2, i3, (Object) null);
            AppMethodBeat.o(189287);
        }

        @Override // com.tencent.thumbplayer.a.a.c.i
        public final void a(TPSubtitleData tPSubtitleData) {
            AppMethodBeat.i(189288);
            b.a(b.this, 265, 0, 0, (Object) tPSubtitleData);
            AppMethodBeat.o(189288);
        }

        @Override // com.tencent.thumbplayer.a.a.c.j
        public final void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
            AppMethodBeat.i(189289);
            b.a(b.this, 279, 0, 0, (Object) tPSubtitleFrameBuffer);
            AppMethodBeat.o(189289);
        }

        @Override // com.tencent.thumbplayer.a.a.c.k
        public final void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
            AppMethodBeat.i(189290);
            d dVar = b.this.Sat;
            if (dVar != null) {
                dVar.onVideoFrameOut(b.this, tPVideoFrameBuffer);
            }
            AppMethodBeat.o(189290);
        }

        @Override // com.tencent.thumbplayer.a.a.c.a
        public final void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
            AppMethodBeat.i(189291);
            d dVar = b.this.Sat;
            if (dVar != null) {
                dVar.onAudioFrameOut(b.this, tPAudioFrameBuffer);
            }
            AppMethodBeat.o(189291);
        }

        @Override // com.tencent.thumbplayer.a.a.c.l
        public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            AppMethodBeat.i(189292);
            d dVar = b.this.Sat;
            if (dVar != null) {
                TPPostProcessFrameBuffer onVideoProcessFrameOut = dVar.onVideoProcessFrameOut(b.this, tPPostProcessFrameBuffer);
                AppMethodBeat.o(189292);
                return onVideoProcessFrameOut;
            }
            AppMethodBeat.o(189292);
            return null;
        }

        @Override // com.tencent.thumbplayer.a.a.c.b
        public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            AppMethodBeat.i(189293);
            d dVar = b.this.Sat;
            if (dVar != null) {
                TPPostProcessFrameBuffer onAudioProcessFrameOut = dVar.onAudioProcessFrameOut(b.this, tPPostProcessFrameBuffer);
                AppMethodBeat.o(189293);
                return onAudioProcessFrameOut;
            }
            AppMethodBeat.o(189293);
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadProgressUpdate(int i2, int i3, long j2, long j3, String str) {
            AppMethodBeat.i(189294);
            b.this.Sas.onDownloadProgressUpdate(i2, i3, j2, j3, str);
            AppMethodBeat.o(189294);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadFinish() {
            AppMethodBeat.i(189295);
            b.this.RVN.info("onDownloadFinish");
            b.this.Sas.onDownloadFinish();
            AppMethodBeat.o(189295);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadError(int i2, int i3, String str) {
            AppMethodBeat.i(189296);
            b.this.RVN.info("onDownloadError, moduleID:" + i2 + ", errorCode:" + i3 + ", extInfo:" + str);
            b.this.Sas.onDownloadError(4000, i3, str);
            AppMethodBeat.o(189296);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadCdnUrlUpdate(String str) {
            AppMethodBeat.i(189297);
            b.this.RVN.info("onDownloadCdnUrlUpdate, url:".concat(String.valueOf(str)));
            b.this.Sas.onDownloadCdnUrlUpdate(str);
            AppMethodBeat.o(189297);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
            AppMethodBeat.i(189298);
            b.this.RVN.info("onDownloadCdnUrlInfoUpdate, url:" + str + ", cdnIp:" + str2 + ", uip:" + str3 + ", errorCodeStr:" + str4);
            b.this.Sas.onDownloadCdnUrlInfoUpdate(str, str2, str3, str4);
            AppMethodBeat.o(189298);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadStatusUpdate(int i2) {
            AppMethodBeat.i(189299);
            if (i2 != b.this.SaA) {
                b.this.RVN.info("onDownloadStatusUpdate, status:".concat(String.valueOf(i2)));
                b.this.SaA = i2;
            }
            b.this.Sas.onDownloadStatusUpdate(i2);
            AppMethodBeat.o(189299);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadProtocolUpdate(String str, String str2) {
            AppMethodBeat.i(189300);
            b.this.RVN.info("onDownloadProtocolUpdate, protocol:" + str + ", protocolVer:" + str2);
            b.this.Sas.onDownloadProtocolUpdate(str, str2);
            AppMethodBeat.o(189300);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadCdnUrlExpired(Map<String, String> map) {
            AppMethodBeat.i(189301);
            b.this.RVN.info("onDownloadCdnUrlExpired");
            b.this.Sas.onDownloadCdnUrlExpired(map);
            AppMethodBeat.o(189301);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final Object onPlayCallback(int i2, Object obj, Object obj2, Object obj3, Object obj4) {
            AppMethodBeat.i(189302);
            Object onPlayCallback = b.this.Sas.onPlayCallback(i2, obj, obj2, obj3, obj4);
            AppMethodBeat.o(189302);
            return onPlayCallback;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final long getPlayerBufferLength() {
            AppMethodBeat.i(189303);
            long playerBufferLength = b.this.Sas.getPlayerBufferLength();
            AppMethodBeat.o(189303);
            return playerBufferLength;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final long getCurrentPosition() {
            AppMethodBeat.i(189304);
            long currentPosition = b.this.Sas.getCurrentPosition();
            AppMethodBeat.o(189304);
            return currentPosition;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final int getCurrentPlayClipNo() {
            AppMethodBeat.i(189305);
            int currentPlayClipNo = b.this.Sas.getCurrentPlayClipNo();
            AppMethodBeat.o(189305);
            return currentPlayClipNo;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final long getAdvRemainTime() {
            AppMethodBeat.i(189306);
            long advRemainTime = b.this.Sas.getAdvRemainTime();
            AppMethodBeat.o(189306);
            return advRemainTime;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final Object getPlayInfo(long j2) {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final Object getPlayInfo(String str) {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final int onStartReadData(int i2, String str, long j2, long j3) {
            AppMethodBeat.i(189307);
            int onStartReadData = b.this.Sas.onStartReadData(i2, str, j2, j3);
            AppMethodBeat.o(189307);
            return onStartReadData;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final int onReadData(int i2, String str, long j2, long j3) {
            AppMethodBeat.i(189308);
            int onReadData = b.this.Sas.onReadData(i2, str, j2, j3);
            AppMethodBeat.o(189308);
            return onReadData;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final int onStopReadData(int i2, String str, int i3) {
            AppMethodBeat.i(189309);
            int onStopReadData = b.this.Sas.onStopReadData(i2, str, i3);
            AppMethodBeat.o(189309);
            return onStopReadData;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final long getDataTotalSize(int i2, String str) {
            AppMethodBeat.i(189310);
            long dataTotalSize = b.this.Sas.getDataTotalSize(i2, str);
            AppMethodBeat.o(189310);
            return dataTotalSize;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final String getDataFilePath(int i2, String str) {
            AppMethodBeat.i(189311);
            String dataFilePath = b.this.Sas.getDataFilePath(i2, str);
            AppMethodBeat.o(189311);
            return dataFilePath;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final String getContentType(int i2, String str) {
            AppMethodBeat.i(189312);
            String contentType = b.this.Sas.getContentType(i2, str);
            AppMethodBeat.o(189312);
            return contentType;
        }
    }

    private void f(int i2, int i3, int i4, Object obj) {
        AppMethodBeat.i(189432);
        if (this.Say != null) {
            Message obtainMessage = this.Say.obtainMessage();
            obtainMessage.what = i2;
            obtainMessage.arg1 = i3;
            obtainMessage.arg2 = i4;
            obtainMessage.obj = obj;
            this.Say.sendMessage(obtainMessage);
        }
        AppMethodBeat.o(189432);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"HandlerLeak"})
    public class a extends Handler {
        private b SaI;

        a(b bVar) {
            this.SaI = bVar;
        }

        a(b bVar, Looper looper) {
            super(looper);
            this.SaI = bVar;
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(189280);
            b.this.RVN.debug("mTransformHandler msg : " + message.what);
            d dVar = b.this.Sat;
            if (dVar == null) {
                AppMethodBeat.o(189280);
                return;
            }
            switch (message.what) {
                case CdnLogic.kAppTypeFestivalImage:
                    b.this.RVN.info("onPrepared");
                    dVar.onPrepared(this.SaI);
                    AppMethodBeat.o(189280);
                    return;
                case 260:
                    dVar.onCompletion(this.SaI);
                    AppMethodBeat.o(189280);
                    return;
                case 261:
                    f.i iVar = (f.i) message.obj;
                    if (iVar != null && !b.this.Sau.hnu()) {
                        dVar.onInfo(this.SaI, message.arg1, iVar.edr, iVar.SbI, iVar.SbJ);
                        AppMethodBeat.o(189280);
                        return;
                    } else if (iVar != null) {
                        dVar.onInfo(this.SaI, message.arg1, iVar.edr, iVar.SbI, iVar.SbJ);
                        AppMethodBeat.o(189280);
                        return;
                    }
                    break;
                case 262:
                    f.i iVar2 = (f.i) message.obj;
                    if (iVar2 != null) {
                        dVar.onError(this.SaI, message.arg1, message.arg2, iVar2.edr, iVar2.SbI);
                        AppMethodBeat.o(189280);
                        return;
                    }
                    break;
                case 263:
                    dVar.onSeekComplete(this.SaI);
                    AppMethodBeat.o(189280);
                    return;
                case 264:
                    f.i iVar3 = (f.i) message.obj;
                    if (iVar3 != null) {
                        dVar.onVideoSizeChanged(this.SaI, iVar3.edr, iVar3.SbI);
                        AppMethodBeat.o(189280);
                        return;
                    }
                    break;
                case 265:
                    dVar.onSubtitleData(this.SaI, (TPSubtitleData) message.obj);
                    AppMethodBeat.o(189280);
                    return;
                case 266:
                    dVar.onVideoFrameOut(this.SaI, (TPVideoFrameBuffer) message.obj);
                    AppMethodBeat.o(189280);
                    return;
                case 267:
                    dVar.onAudioFrameOut(this.SaI, (TPAudioFrameBuffer) message.obj);
                    AppMethodBeat.o(189280);
                    return;
                case 268:
                    dVar.onError(this.SaI, message.arg1, message.arg2, 0, 0);
                    AppMethodBeat.o(189280);
                    return;
                case 269:
                    dVar.onInfo(this.SaI, 1002, (long) message.arg1, (long) message.arg2, message.obj);
                    AppMethodBeat.o(189280);
                    return;
                case 270:
                    dVar.onInfo(this.SaI, 1003, (long) message.arg1, (long) message.arg2, message.obj);
                    AppMethodBeat.o(189280);
                    return;
                case a.C0691a.CTRL_INDEX:
                    dVar.onInfo(this.SaI, 1001, (long) message.arg1, (long) message.arg2, message.obj);
                    AppMethodBeat.o(189280);
                    return;
                case 272:
                    dVar.onInfo(this.SaI, 1004, (long) message.arg1, (long) message.arg2, message.obj);
                    AppMethodBeat.o(189280);
                    return;
                case 273:
                    dVar.onInfo(this.SaI, 1005, (long) message.arg1, (long) message.arg2, message.obj);
                    AppMethodBeat.o(189280);
                    return;
                case a.C0693a.CTRL_INDEX:
                    dVar.onInfo(this.SaI, 1006, (long) message.arg1, (long) message.arg2, message.obj);
                    AppMethodBeat.o(189280);
                    return;
                case 275:
                    dVar.onInfo(this.SaI, 1007, (long) message.arg1, (long) message.arg2, message.obj);
                    AppMethodBeat.o(189280);
                    return;
                case 276:
                    dVar.onInfo(this.SaI, 1008, (long) message.arg1, (long) message.arg2, message.obj);
                    AppMethodBeat.o(189280);
                    return;
                case 277:
                    dVar.onStateChange(message.arg1, message.arg2);
                    AppMethodBeat.o(189280);
                    return;
                case 278:
                    if (b.this.Sar != null) {
                        b.this.Sar.setPlayerOptionalParam(new TPOptionalParam().buildLong(TXRecordCommon.AUDIO_SAMPLERATE_8000, (long) message.arg1));
                    }
                    dVar.onInfo(this.SaI, 1010, (long) message.arg1, (long) message.arg2, message.obj);
                    AppMethodBeat.o(189280);
                    return;
                case 279:
                    dVar.onSubtitleFrameOut(this.SaI, (TPSubtitleFrameBuffer) message.obj);
                    AppMethodBeat.o(189280);
                    return;
                case 280:
                    dVar.onStopAsyncComplete(this.SaI);
                    break;
            }
            AppMethodBeat.o(189280);
        }
    }

    static /* synthetic */ void a(b bVar, int i2, long j2, long j3, Object obj) {
        long j4;
        AppMethodBeat.i(189435);
        if (i2 == 200) {
            bVar.Sau.aro(4);
            bVar.a(114, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("stime", Long.valueOf(System.currentTimeMillis())).S("format", 0).S("ptime", Long.valueOf(bVar.hnO())).S("url", bVar.mUrl).map);
            AppMethodBeat.o(189435);
        } else if (i2 == 201) {
            bVar.hod();
            bVar.a(115, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("etime", Long.valueOf(System.currentTimeMillis())).map);
            AppMethodBeat.o(189435);
        } else if (i2 == 3) {
            if (obj instanceof Long) {
                j4 = ((Long) obj).longValue();
            } else {
                j4 = -1;
            }
            bVar.RVN.info("switch definition finish defId:".concat(String.valueOf(j4)));
            if (j4 > 0) {
                bVar.Sau.OE(j4);
            }
            bVar.a(121, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("switch", String.valueOf(j4)).map);
            AppMethodBeat.o(189435);
        } else if (i2 == 106) {
            bVar.a(105, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("etime", Long.valueOf(System.currentTimeMillis())).map);
            AppMethodBeat.o(189435);
        } else if (i2 == 501) {
            bVar.a(117, 0, 0, (String) null, obj);
            AppMethodBeat.o(189435);
        } else if (i2 == 107) {
            bVar.a(119, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("stime", Long.valueOf(System.currentTimeMillis())).map);
            AppMethodBeat.o(189435);
        } else if (i2 == 4) {
            bVar.a(123, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("opaque", obj).S("etime", Long.valueOf(System.currentTimeMillis())).S(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, j2 + "." + j3).map);
            AppMethodBeat.o(189435);
        } else {
            if (i2 == 101) {
                bVar.a(124, 0, 0, (String) null, new com.tencent.thumbplayer.utils.f().S("stime", Long.valueOf(System.currentTimeMillis())).map);
            }
            AppMethodBeat.o(189435);
        }
    }

    static /* synthetic */ void a(b bVar, Object obj) {
        AppMethodBeat.i(189436);
        if (obj instanceof TPPlayerMsg.TPAudioTrackInfo) {
            TPPlayerMsg.TPAudioTrackInfo tPAudioTrackInfo = (TPPlayerMsg.TPAudioTrackInfo) obj;
            bVar.RVN.info("handleSelectAudioTrack, audioTrack url:" + tPAudioTrackInfo.audioTrackUrl);
            if (!TextUtils.isEmpty(tPAudioTrackInfo.audioTrackUrl)) {
                try {
                    bVar.Sau.nM(tPAudioTrackInfo.audioTrackUrl, tPAudioTrackInfo.keyId);
                    AppMethodBeat.o(189436);
                    return;
                } catch (Exception e2) {
                    bVar.RVN.r(e2);
                    AppMethodBeat.o(189436);
                    return;
                }
            } else {
                try {
                    bVar.Sau.hnt();
                    AppMethodBeat.o(189436);
                    return;
                } catch (Exception e3) {
                    bVar.RVN.r(e3);
                }
            }
        }
        AppMethodBeat.o(189436);
    }

    static /* synthetic */ void b(b bVar, Object obj) {
        AppMethodBeat.i(189437);
        if (obj instanceof TPPlayerMsg.TPAudioTrackInfo) {
            TPPlayerMsg.TPAudioTrackInfo tPAudioTrackInfo = (TPPlayerMsg.TPAudioTrackInfo) obj;
            String a2 = bVar.Sau.a(2, tPAudioTrackInfo.audioTrackUrl, (TPDownloadParamData) null);
            bVar.SaB.add(a2);
            tPAudioTrackInfo.proxyUrl = a2;
        }
        AppMethodBeat.o(189437);
    }
}
