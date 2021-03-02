package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.a.a;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.o;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.liteav.renderer.a;
import com.tencent.liteav.renderer.g;
import com.tencent.liteav.renderer.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class f extends n implements TXCRenderAndDec.a, TXCRenderAndDec.b, c, d, b, com.tencent.liteav.network.f, a.AbstractC0159a, g {
    private int A = 0;
    private int B = 0;
    private h C = null;
    private h D = null;
    private float[] E = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    private float[] F = new float[16];
    private String G = "";
    private int H;
    private boolean I = false;
    private com.tencent.liteav.basic.a.b J = com.tencent.liteav.basic.a.b.UNKNOWN;
    private Object K = null;
    private com.tencent.liteav.basic.b.a L = new com.tencent.liteav.basic.b.a() {
        /* class com.tencent.liteav.f.AnonymousClass1 */

        @Override // com.tencent.liteav.basic.b.a
        public void onEvent(String str, int i2, String str2, String str3) {
            AppMethodBeat.i(221381);
            TXCLog.i("TXCLivePlayer", "onEvent => id:" + str + " code:" + i2 + " msg:" + str2 + " params:" + str3);
            WeakReference weakReference = f.this.f855d;
            if ((weakReference == null ? null : (b) weakReference.get()) != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("EVT_ID", i2);
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                if (str2 != null) {
                    StringBuilder append = new StringBuilder().append(str2);
                    if (str3 == null) {
                        str3 = "";
                    }
                    bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, append.append(str3).toString());
                }
                f.this.onNotifyEvent(i2, bundle);
            }
            AppMethodBeat.o(221381);
        }

        @Override // com.tencent.liteav.basic.b.a
        public void onError(String str, int i2, String str2, String str3) {
            AppMethodBeat.i(221382);
            TXCLog.e("TXCLivePlayer", "onError => id:" + str + " code:" + i2 + " msg:" + str2 + " params:" + str3);
            WeakReference weakReference = f.this.f855d;
            if ((weakReference == null ? null : (b) weakReference.get()) != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("EVT_ID", i2);
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                if (str2 != null) {
                    StringBuilder append = new StringBuilder().append(str2);
                    if (str3 == null) {
                        str3 = "";
                    }
                    bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, append.append(str3).toString());
                }
                f.this.onNotifyEvent(i2, bundle);
            }
            AppMethodBeat.o(221382);
        }
    };
    private TXLivePlayer.ITXAudioRawDataListener M;
    private String N = "";
    private boolean O = false;
    private long P = 0;
    private long Q = 0;
    private a R = null;

    /* renamed from: e  reason: collision with root package name */
    private TXCRenderAndDec f760e = null;

    /* renamed from: f  reason: collision with root package name */
    private com.tencent.liteav.renderer.a f761f = null;

    /* renamed from: g  reason: collision with root package name */
    private TXCStreamDownloader f762g = null;

    /* renamed from: h  reason: collision with root package name */
    private Handler f763h;

    /* renamed from: i  reason: collision with root package name */
    private TextureView f764i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f765j = false;
    private boolean k = false;
    private int l = 100;
    private int m = 0;
    private int n = 0;
    private boolean o = false;
    private Surface p;
    private int q = 2;
    private int r = 48000;
    private int s = 16;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private int w = 0;
    private com.tencent.liteav.a.a x;
    private TXRecordCommon.ITXVideoRecordListener y;
    private e z;

    static /* synthetic */ void d(f fVar) {
        AppMethodBeat.i(221755);
        fVar.t();
        AppMethodBeat.o(221755);
    }

    static /* synthetic */ void e(f fVar) {
        AppMethodBeat.i(221756);
        fVar.u();
        AppMethodBeat.o(221756);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context);
        boolean z2 = false;
        AppMethodBeat.i(221703);
        com.tencent.liteav.basic.d.c.a().a(context);
        TXCAudioEngine.CreateInstance(context, com.tencent.liteav.basic.d.c.a().c());
        TXCAudioEngine.getInstance().addEventCallback(new WeakReference<>(this.L));
        long a2 = com.tencent.liteav.basic.d.c.a().a("Audio", "EnableAutoRestartDevice");
        TXCAudioEngine.getInstance().enableAutoRestartDevice((a2 == 1 || a2 == -1) ? true : z2);
        this.f763h = new Handler(Looper.getMainLooper());
        this.f761f = new com.tencent.liteav.renderer.a();
        this.f761f.a((b) this);
        this.R = new a(this);
        TXCLog.i("TXCLivePlayer", "[FirstFramePath] TXCLivePlayer: create player success. instance:" + hashCode());
        AppMethodBeat.o(221703);
    }

    @Override // com.tencent.liteav.n
    public void a(TXCloudVideoView tXCloudVideoView) {
        TextureView videoView;
        AppMethodBeat.i(221704);
        if (!(this.f854c == null || this.f854c == tXCloudVideoView || (videoView = this.f854c.getVideoView()) == null)) {
            this.f854c.removeView(videoView);
        }
        super.a(tXCloudVideoView);
        if (this.f854c != null) {
            this.f764i = this.f854c.getVideoView();
            if (this.f764i == null) {
                this.f764i = new TextureView(this.f854c.getContext());
            }
            this.f854c.addVideoView(this.f764i);
        }
        if (this.f761f != null) {
            this.f761f.a(this.f764i);
        }
        AppMethodBeat.o(221704);
    }

    @Override // com.tencent.liteav.n
    public void a(Surface surface) {
        AppMethodBeat.i(221705);
        this.p = surface;
        if (this.f761f != null) {
            this.f761f.a(surface);
        }
        AppMethodBeat.o(221705);
    }

    @Override // com.tencent.liteav.n
    public void a(int i2, int i3) {
        AppMethodBeat.i(221706);
        if (this.f761f != null) {
            this.f761f.c(i2, i3);
        }
        AppMethodBeat.o(221706);
    }

    @Override // com.tencent.liteav.n
    public void a(h hVar) {
        AppMethodBeat.i(221707);
        super.a(hVar);
        if (this.f760e != null) {
            this.f760e.setConfig(hVar);
        }
        AppMethodBeat.o(221707);
    }

    @Override // com.tencent.liteav.n
    public int a(String str, int i2) {
        AppMethodBeat.i(221708);
        if (c()) {
            TXCLog.w("TXCLivePlayer", "play: ignore start play when is playing");
            AppMethodBeat.o(221708);
            return -2;
        } else if (this.f852a == null || this.f852a.f792c <= this.f852a.f791b) {
            if (this.f852a.f790a > this.f852a.f791b || this.f852a.f790a < this.f852a.f792c) {
                TXCLog.w("TXCLivePlayer", "play: invalid cacheTime " + this.f852a.f790a + ", need between minAutoAdjustCacheTime " + this.f852a.f792c + " and maxAutoAdjustCacheTime " + this.f852a.f791b + " , fix to maxAutoAdjustCacheTime");
                this.f852a.f790a = this.f852a.f791b;
            }
            TXCLog.i("TXCLivePlayer", "[FirstFramePath] TXCLivePlayer: start play. instance: " + hashCode());
            this.G = str;
            this.H = i2;
            b(str);
            this.o = true;
            this.w = 0;
            this.u = true;
            this.v = true;
            f(i2);
            n();
            int b2 = b(str, i2);
            if (b2 != 0) {
                this.o = false;
                p();
                m();
                o();
                if (this.f764i != null) {
                    this.f764i.setVisibility(8);
                }
            } else {
                a(this.p);
                q();
                u();
                if (this.J == com.tencent.liteav.basic.a.b.TEXTURE_2D && this.f764i == null && this.f761f != null) {
                    this.f761f.c(this.K);
                }
                TXCDRApi.txReportDAU(this.f853b, com.tencent.liteav.basic.datareport.a.bt);
                try {
                    if (Class.forName("com.tencent.liteav.demo.play.SuperPlayerView") != null) {
                        TXCDRApi.txReportDAU(this.f853b, com.tencent.liteav.basic.datareport.a.bE);
                    }
                } catch (Exception e2) {
                }
            }
            AppMethodBeat.o(221708);
            return b2;
        } else {
            TXCLog.e("TXCLivePlayer", "play: can not start play while invalid cache config [minAutoAdjustCacheTime(" + this.f852a.f792c + ") > maxAutoAdjustCacheTime(" + this.f852a.f791b + ")]!!!!!!");
            AppMethodBeat.o(221708);
            return -1;
        }
    }

    @Override // com.tencent.liteav.n
    public int a(boolean z2) {
        AppMethodBeat.i(221709);
        if (!c()) {
            TXCLog.w("TXCLivePlayer", "play: ignore stop play when not started");
            AppMethodBeat.o(221709);
            return -2;
        }
        TXCLog.v("TXCLivePlayer", "play: stop");
        this.o = false;
        p();
        m();
        if (this.f764i != null && z2) {
            this.f764i.setVisibility(8);
        }
        if (this.f761f != null) {
            this.f761f.a((Surface) null);
        }
        if (this.f764i == null && this.f761f != null) {
            this.f761f.e();
        }
        o();
        r();
        v();
        s();
        AppMethodBeat.o(221709);
        return 0;
    }

    @Override // com.tencent.liteav.n
    public int a(String str) {
        AppMethodBeat.i(221710);
        if (!c() || this.f762g == null) {
            AppMethodBeat.o(221710);
            return -1;
        }
        boolean switchStream = this.f762g.switchStream(str);
        long j2 = 0;
        long c2 = (long) TXCStatus.c(this.N, 2007);
        if (this.f760e != null) {
            j2 = this.f760e.getVideoCacheDuration();
        }
        TXCLog.i("TXCLivePlayer", "[SwitchStream] current jitter size when start switch stream. video:" + j2 + " audio:" + c2);
        if (switchStream) {
            this.G = str;
            AppMethodBeat.o(221710);
            return 0;
        }
        AppMethodBeat.o(221710);
        return -2;
    }

    @Override // com.tencent.liteav.n
    public void a() {
        AppMethodBeat.i(221711);
        a(false);
        AppMethodBeat.o(221711);
    }

    @Override // com.tencent.liteav.n
    public void b() {
        AppMethodBeat.i(221712);
        a(this.G, this.H);
        AppMethodBeat.o(221712);
    }

    @Override // com.tencent.liteav.n
    public boolean c() {
        return this.o;
    }

    @Override // com.tencent.liteav.n
    public void a(int i2) {
        AppMethodBeat.i(221713);
        this.n = i2;
        if (this.f760e != null) {
            this.f760e.setRenderMode(i2);
        }
        AppMethodBeat.o(221713);
    }

    @Override // com.tencent.liteav.n
    public void b(int i2) {
        AppMethodBeat.i(221714);
        this.m = i2;
        if (this.f760e != null) {
            this.f760e.setRenderRotation(i2);
        }
        AppMethodBeat.o(221714);
    }

    @Override // com.tencent.liteav.n
    public void b(boolean z2) {
        AppMethodBeat.i(221715);
        this.f765j = z2;
        TXCAudioEngine.getInstance().muteRemoteAudio(this.N, this.f765j);
        AppMethodBeat.o(221715);
    }

    @Override // com.tencent.liteav.n
    public void c(boolean z2) {
        AppMethodBeat.i(221716);
        this.k = z2;
        TXCAudioEngine.getInstance().muteRemoteAudioInSpeaker(this.N, z2);
        AppMethodBeat.o(221716);
    }

    @Override // com.tencent.liteav.n
    public void c(int i2) {
        AppMethodBeat.i(221717);
        this.l = i2;
        TXCAudioEngine.getInstance().setRemotePlayoutVolume(this.N, this.l);
        AppMethodBeat.o(221717);
    }

    @Override // com.tencent.liteav.n
    public void a(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.y = iTXVideoRecordListener;
    }

    @Override // com.tencent.liteav.n
    public int d(int i2) {
        AppMethodBeat.i(221719);
        if (this.t) {
            TXCLog.e("TXCLivePlayer", "startRecord: there is existing uncompleted record task");
            AppMethodBeat.o(221719);
            return -1;
        }
        this.t = true;
        this.f761f.a((g) this);
        this.f761f.a((a.AbstractC0159a) this);
        x();
        TXCDRApi.txReportDAU(this.f853b, com.tencent.liteav.basic.datareport.a.av);
        AppMethodBeat.o(221719);
        return 0;
    }

    @Override // com.tencent.liteav.n
    public void a(TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener) {
        AppMethodBeat.i(221720);
        this.M = iTXAudioRawDataListener;
        x();
        AppMethodBeat.o(221720);
    }

    @Override // com.tencent.liteav.n
    public int d() {
        AppMethodBeat.i(221721);
        if (!this.t) {
            TXCLog.w("TXCLivePlayer", "stopRecord: no recording task exist");
            AppMethodBeat.o(221721);
            return -1;
        }
        this.t = false;
        x();
        if (this.x != null) {
            this.x.a();
            this.x = null;
        }
        AppMethodBeat.o(221721);
        return 0;
    }

    @Override // com.tencent.liteav.n
    public void a(o oVar, com.tencent.liteav.basic.a.b bVar, Object obj) {
        AppMethodBeat.i(221722);
        this.J = bVar;
        this.K = obj;
        if (c() && this.J == com.tencent.liteav.basic.a.b.TEXTURE_2D && this.f764i == null && oVar != null && this.f761f != null) {
            this.f761f.c(this.K);
        }
        if (this.f760e != null) {
            this.f760e.setVideoFrameListener(oVar, bVar);
            AppMethodBeat.o(221722);
            return;
        }
        TXCLog.w("TXCLivePlayer", "setVideoFrameListener->enter with renderAndDec is empty");
        AppMethodBeat.o(221722);
    }

    @Override // com.tencent.liteav.n
    public boolean e() {
        return true;
    }

    @Override // com.tencent.liteav.n
    public void a(o oVar) {
        AppMethodBeat.i(221723);
        if (this.f761f != null) {
            this.f761f.a(oVar);
        }
        AppMethodBeat.o(221723);
    }

    private void j() {
        AppMethodBeat.i(221724);
        if (this.x == null) {
            this.A = this.f761f.i();
            this.B = this.f761f.j();
            a.C0153a l2 = l();
            this.x = new com.tencent.liteav.a.a(this.f853b);
            this.x.a(l2);
            this.x.a(new a.b() {
                /* class com.tencent.liteav.f.AnonymousClass2 */

                @Override // com.tencent.liteav.a.a.b
                public void a(int i2, String str, String str2, String str3) {
                    AppMethodBeat.i(222586);
                    if (f.this.y != null) {
                        TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
                        if (i2 == 0) {
                            tXRecordResult.retCode = 0;
                        } else {
                            tXRecordResult.retCode = -1;
                        }
                        tXRecordResult.descMsg = str;
                        tXRecordResult.videoPath = str2;
                        tXRecordResult.coverPath = str3;
                        f.this.y.onRecordComplete(tXRecordResult);
                    }
                    f.this.f761f.a((g) null);
                    f.this.f761f.a((a.AbstractC0159a) null);
                    AppMethodBeat.o(222586);
                }

                @Override // com.tencent.liteav.a.a.b
                public void a(long j2) {
                    AppMethodBeat.i(222587);
                    if (f.this.y != null) {
                        f.this.y.onRecordProgress(j2);
                    }
                    AppMethodBeat.o(222587);
                }
            });
        }
        if (this.C == null) {
            this.C = new h(Boolean.TRUE);
            this.C.b();
            this.C.b(this.A, this.B);
            this.C.a(this.A, this.B);
        }
        if (this.D == null) {
            this.D = new h(Boolean.FALSE);
            this.D.b();
            this.D.b(this.f761f.g(), this.f761f.h());
            this.D.a(this.f761f.g(), this.f761f.h());
            Matrix.setIdentityM(this.F, 0);
        }
        AppMethodBeat.o(221724);
    }

    private void k() {
        AppMethodBeat.i(221725);
        if (this.C != null) {
            this.C.c();
            this.C = null;
        }
        if (this.D != null) {
            this.D.c();
            this.D = null;
        }
        AppMethodBeat.o(221725);
    }

    private a.C0153a l() {
        AppMethodBeat.i(221726);
        int i2 = 480;
        int i3 = 640;
        if (this.A > 0 && this.B > 0) {
            i2 = this.A;
            i3 = this.B;
        }
        a.C0153a aVar = new a.C0153a();
        aVar.f136a = i2;
        aVar.f137b = i3;
        aVar.f138c = 20;
        aVar.f139d = (int) (Math.sqrt(((double) (i3 * i3)) + (((double) (i2 * i2)) * 1.0d)) * 1.2d);
        aVar.f143h = this.q;
        aVar.f144i = this.r;
        aVar.f145j = this.s;
        aVar.f141f = com.tencent.liteav.a.a.a(this.f853b, ".mp4");
        aVar.f142g = com.tencent.liteav.a.a.a(this.f853b, ".jpg");
        aVar.f140e = this.f761f.b();
        TXCLog.d("TXCLivePlayer", "record config: ".concat(String.valueOf(aVar)));
        AppMethodBeat.o(221726);
        return aVar;
    }

    private void f(int i2) {
        boolean z2 = false;
        AppMethodBeat.i(221727);
        if (this.f764i != null) {
            this.f764i.setVisibility(0);
        }
        this.f760e = new TXCRenderAndDec(this.f853b);
        this.f760e.setNotifyListener(this);
        this.f760e.setVideoRender(this.f761f);
        this.f760e.setDecListener(this);
        this.f760e.setRenderAndDecDelegate(this);
        this.f760e.setConfig(this.f852a);
        this.f760e.setID(this.N);
        TXCRenderAndDec tXCRenderAndDec = this.f760e;
        if (i2 == 5) {
            z2 = true;
        }
        tXCRenderAndDec.start(z2);
        this.f760e.setRenderMode(this.n);
        this.f760e.setRenderRotation(this.m);
        AppMethodBeat.o(221727);
    }

    private void m() {
        AppMethodBeat.i(221728);
        if (this.f760e != null) {
            this.f760e.stop();
            this.f760e.setVideoRender(null);
            this.f760e.setDecListener(null);
            this.f760e.setNotifyListener(null);
            this.f760e = null;
        }
        AppMethodBeat.o(221728);
    }

    private void n() {
        boolean z2 = true;
        AppMethodBeat.i(221729);
        boolean z3 = this.H == 5;
        TXCAudioEngine.getInstance();
        TXCAudioEngine.enableAudioVolumeEvaluation(this.I, 300);
        a(this.M);
        if (this.H == 5) {
            TXCAudioEngine instance = TXCAudioEngine.getInstance();
            String str = this.N;
            if (this.f852a.f796g) {
                z2 = false;
            }
            instance.setRemoteAudioCacheParams(str, z2, (int) (com.tencent.liteav.basic.a.a.f199b * 1000.0f), (int) (com.tencent.liteav.basic.a.a.f199b * 1000.0f), (int) (com.tencent.liteav.basic.a.a.f200c * 1000.0f));
        } else {
            TXCAudioEngine instance2 = TXCAudioEngine.getInstance();
            String str2 = this.N;
            if (this.f852a.f796g) {
                z2 = false;
            }
            instance2.setRemoteAudioCacheParams(str2, z2, (int) (this.f852a.f790a * 1000.0f), (int) (this.f852a.f792c * 1000.0f), (int) (this.f852a.f791b * 1000.0f));
        }
        TXCAudioEngine.getInstance().muteRemoteAudio(this.N, this.f765j);
        TXCAudioEngine.getInstance().muteRemoteAudioInSpeaker(this.N, this.k);
        TXCAudioEngine.getInstance().setRemotePlayoutVolume(this.N, this.l);
        TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener(this.N, this);
        x();
        TXCAudioEngine.getInstance().startRemoteAudio(this.N, z3);
        AppMethodBeat.o(221729);
    }

    private void o() {
        AppMethodBeat.i(221730);
        TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener(this.N, null);
        TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(this.N, null);
        TXCAudioEngine.getInstance().stopRemoteAudio(this.N);
        TXCAudioEngine.getInstance().UnInitAudioDevice();
        AppMethodBeat.o(221730);
    }

    private int b(String str, int i2) {
        boolean z2 = false;
        AppMethodBeat.i(221731);
        if (i2 == 0) {
            this.f762g = new TXCStreamDownloader(this.f853b, 1);
        } else if (i2 == 5) {
            this.f762g = new TXCStreamDownloader(this.f853b, 4);
        } else {
            this.f762g = new TXCStreamDownloader(this.f853b, 0);
            if (!TextUtils.isEmpty(this.f852a.l)) {
                this.f762g.setFlvSessionKey(this.f852a.l);
            }
        }
        this.f762g.setID(this.N);
        this.f762g.setListener(this);
        this.f762g.setNotifyListener(this);
        this.f762g.setHeaders(this.f852a.p);
        if (i2 == 5) {
            z2 = true;
        }
        if (z2) {
            this.f762g.setRetryTimes(5);
            this.f762g.setRetryInterval(1);
        } else {
            this.f762g.setRetryTimes(this.f852a.f794e);
            this.f762g.setRetryInterval(this.f852a.f795f);
        }
        int start = this.f762g.start(str, this.f852a.f798i, this.f852a.m, this.f852a.f799j, this.f852a.k);
        AppMethodBeat.o(221731);
        return start;
    }

    private void p() {
        AppMethodBeat.i(221732);
        if (this.f762g != null) {
            this.f762g.setListener(null);
            this.f762g.setNotifyListener(null);
            this.f762g.stop();
            this.f762g = null;
        }
        AppMethodBeat.o(221732);
    }

    private void q() {
        AppMethodBeat.i(221733);
        this.z = new e(this.f853b);
        this.z.a(this.G);
        this.z.a(this.H == 5);
        this.z.d(this.N);
        this.z.e(this.f762g.getRTMPProxyUserId());
        this.z.a();
        AppMethodBeat.o(221733);
    }

    private void r() {
        AppMethodBeat.i(221734);
        if (this.z != null) {
            this.z.c();
            this.z = null;
        }
        AppMethodBeat.o(221734);
    }

    private void b(String str) {
        AppMethodBeat.i(221735);
        this.N = String.format("%s-%d", str, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000));
        if (this.f760e != null) {
            this.f760e.setID(this.N);
        }
        if (this.f761f != null) {
            this.f761f.setID(this.N);
        }
        if (this.f762g != null) {
            this.f762g.setID(this.N);
        }
        if (this.z != null) {
            this.z.d(this.N);
        }
        AppMethodBeat.o(221735);
    }

    @Override // com.tencent.liteav.n
    public void f() {
        AppMethodBeat.i(221736);
        this.Q = 0;
        if (this.O) {
            AppMethodBeat.o(221736);
            return;
        }
        this.O = true;
        x();
        if (this.f763h != null) {
            this.f763h.postDelayed(new Runnable() {
                /* class com.tencent.liteav.f.AnonymousClass3 */

                public void run() {
                    AppMethodBeat.i(222646);
                    if (f.this.O) {
                        f.d(f.this);
                    }
                    AppMethodBeat.o(222646);
                }
            }, 1000);
        }
        AppMethodBeat.o(221736);
    }

    private void s() {
        AppMethodBeat.i(221737);
        this.O = false;
        x();
        AppMethodBeat.o(221737);
    }

    private void t() {
        AppMethodBeat.i(221738);
        if (this.P > 0) {
            Bundle bundle = new Bundle();
            bundle.putInt(TXLiveConstants.EVT_PLAY_PROGRESS, (int) (this.P / 1000));
            bundle.putInt(TXLiveConstants.EVT_PLAY_PROGRESS_MS, (int) this.P);
            onNotifyEvent(2005, bundle);
        }
        if (this.f763h != null && this.O) {
            this.f763h.postDelayed(new Runnable() {
                /* class com.tencent.liteav.f.AnonymousClass4 */

                public void run() {
                    AppMethodBeat.i(222017);
                    if (f.this.O) {
                        f.d(f.this);
                    }
                    AppMethodBeat.o(222017);
                }
            }, 1000);
        }
        AppMethodBeat.o(221738);
    }

    private void u() {
        AppMethodBeat.i(221739);
        if (this.f763h != null) {
            this.f763h.postDelayed(this.R, 2000);
        }
        AppMethodBeat.o(221739);
    }

    private void v() {
        AppMethodBeat.i(221740);
        if (this.f763h != null) {
            this.f763h.removeCallbacks(this.R);
        }
        AppMethodBeat.o(221740);
    }

    public void g() {
        int i2;
        AppMethodBeat.i(221741);
        w();
        int[] a2 = com.tencent.liteav.basic.util.f.a();
        String str = (a2[0] / 10) + FilePathGenerator.ANDROID_DIR_SEP + (a2[1] / 10) + "%";
        int c2 = TXCStatus.c(this.N, 7102);
        int c3 = TXCStatus.c(this.N, 7101);
        String b2 = TXCStatus.b(this.N, 7110);
        int d2 = (int) TXCStatus.d(this.N, 6002);
        Bundle bundle = new Bundle();
        if (this.f761f != null) {
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH, this.f761f.i());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT, this.f761f.j());
        }
        if (this.f760e != null) {
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE, (int) this.f760e.getVideoCacheDuration());
            bundle.putInt(TXLiveConstants.NET_STATUS_V_SUM_CACHE_SIZE, (int) this.f760e.getVideoCacheFrameCount());
            bundle.putInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE, this.f760e.getVideoDecCacheFrameCount());
            bundle.putInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL, (int) this.f760e.getAVPlayInterval());
            bundle.putInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL, (int) this.f760e.getAVNetRecvInterval());
            if (d2 == 0) {
                i2 = 15;
            } else {
                i2 = d2;
            }
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_GOP, (int) (((double) (((float) ((TXCStatus.c(this.N, 7120) * 10) / i2)) / 10.0f)) + 0.5d));
        }
        bundle.putString(TXLiveConstants.NET_STATUS_AUDIO_INFO, TXCAudioEngine.getInstance().getPlayAECType() + APLogFileUtil.SEPARATOR_LOG + TXCStatus.c(this.N, TXLiteAVCode.EVT_VOD_PLAY_SEEK_COMPLETE) + "," + TXCStatus.c(this.N, TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES) + APLogFileUtil.SEPARATOR_LOG + TXCAudioEngine.getInstance().getPlaySampleRate() + "," + TXCAudioEngine.getInstance().getPlayChannels());
        bundle.putInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE, TXCStatus.c(this.N, 2007));
        bundle.putInt(TXLiveConstants.NET_STATUS_NET_JITTER, TXCStatus.c(this.N, TXLiteAVCode.EVT_VOD_PLAY_DNS_RESOLVED));
        bundle.putFloat(TXLiveConstants.NET_STATUS_AUDIO_CACHE_THRESHOLD, ((float) TXCStatus.c(this.N, TXLiteAVCode.EVT_HW_DECODER_START_SUCC)) / 1000.0f);
        bundle.putInt(TXLiveConstants.NET_STATUS_NET_SPEED, c3 + c2);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_FPS, d2);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE, c3);
        bundle.putInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE, c2);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_SERVER_IP, b2);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_CPU_USAGE, str);
        this.w++;
        if (this.w == 5) {
            if (!this.v) {
                TXCStatus.a(this.N, 9009, (Object) 0L);
            } else {
                TXCStatus.a(this.N, 9009, (Object) 1L);
            }
        }
        com.tencent.liteav.basic.util.f.a(this.f855d, 15001, bundle);
        if (this.f760e != null) {
            this.f760e.updateLoadInfo();
        }
        if (this.z != null) {
            this.z.f();
        }
        AppMethodBeat.o(221741);
    }

    /* access modifiers changed from: package-private */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<f> f776a;

        a(f fVar) {
            AppMethodBeat.i(221778);
            this.f776a = new WeakReference<>(fVar);
            AppMethodBeat.o(221778);
        }

        public void run() {
            AppMethodBeat.i(221779);
            f fVar = this.f776a.get();
            if (fVar == null) {
                AppMethodBeat.o(221779);
                return;
            }
            fVar.g();
            f.e(fVar);
            AppMethodBeat.o(221779);
        }
    }

    private void w() {
        AppMethodBeat.i(221742);
        ArrayList arrayList = new ArrayList();
        if (this.N != null) {
            arrayList.add(this.N);
        }
        a.a("18446744073709551615", arrayList);
        AppMethodBeat.o(221742);
    }

    private void a(final int i2, String str) {
        AppMethodBeat.i(221743);
        if (this.f855d != null) {
            final Bundle bundle = new Bundle();
            bundle.putInt("EVT_ID", i2);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            if (str != null) {
                bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
            }
            if (this.f763h != null) {
                this.f763h.post(new Runnable() {
                    /* class com.tencent.liteav.f.AnonymousClass5 */

                    public void run() {
                        AppMethodBeat.i(221435);
                        com.tencent.liteav.basic.util.f.a(f.this.f855d, i2, bundle);
                        AppMethodBeat.o(221435);
                    }
                });
            }
        }
        AppMethodBeat.o(221743);
    }

    private void x() {
        AppMethodBeat.i(221744);
        if (this.t || this.M != null || this.O) {
            TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(this.N, this);
        }
        if (!this.t && this.M == null && !this.O) {
            TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(this.N, null);
        }
        AppMethodBeat.o(221744);
    }

    @Override // com.tencent.liteav.network.f
    public void onPullAudio(com.tencent.liteav.basic.structs.a aVar) {
    }

    @Override // com.tencent.liteav.network.f
    public void onPullNAL(TXSNALPacket tXSNALPacket) {
        AppMethodBeat.i(221745);
        if (!this.o) {
            AppMethodBeat.o(221745);
            return;
        }
        try {
            if (this.f760e != null) {
                this.f760e.decVideo(tXSNALPacket);
            }
            AppMethodBeat.o(221745);
        } catch (Exception e2) {
            TXCLog.e("TXCLivePlayer", "decode video failed." + e2.getMessage());
            AppMethodBeat.o(221745);
        }
    }

    @Override // com.tencent.liteav.basic.b.b
    public void onNotifyEvent(final int i2, final Bundle bundle) {
        AppMethodBeat.i(221746);
        if (2003 == i2 && this.v) {
            this.v = false;
        }
        if (2003 == i2 || 2026 == i2) {
            if (this.u) {
                a(2004, "Video play started");
                this.u = false;
            }
            if (2026 == i2) {
                TXCStatus.a(this.N, 2033, Long.valueOf(TXCTimeUtil.getTimeTick()));
                AppMethodBeat.o(221746);
                return;
            }
        }
        if (2025 == i2) {
            a(2004, "Video play started");
            AppMethodBeat.o(221746);
        } else if (2023 == i2 || 2024 == i2) {
            a(2007, "Video play loading");
            AppMethodBeat.o(221746);
        } else {
            if (this.f763h != null) {
                this.f763h.post(new Runnable() {
                    /* class com.tencent.liteav.f.AnonymousClass6 */

                    public void run() {
                        AppMethodBeat.i(221380);
                        com.tencent.liteav.basic.util.f.a(f.this.f855d, i2, bundle);
                        if (i2 == 2103 && f.this.f760e != null) {
                            f.this.f760e.restartDecoder();
                        }
                        AppMethodBeat.o(221380);
                    }
                });
            }
            AppMethodBeat.o(221746);
        }
    }

    @Override // com.tencent.liteav.renderer.g
    public int a(int i2, float[] fArr) {
        AppMethodBeat.i(221747);
        com.tencent.liteav.a.a aVar = this.x;
        if (!(!this.t || aVar == null || this.C == null)) {
            int d2 = this.C.d(i2);
            aVar.a(d2, TXCTimeUtil.getTimeTick());
            this.f761f.a(d2, this.A, this.B, false, 0);
        }
        if (this.t) {
            j();
        } else {
            k();
        }
        AppMethodBeat.o(221747);
        return i2;
    }

    @Override // com.tencent.liteav.renderer.a.AbstractC0159a
    public void onTextureProcess(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(221748);
        com.tencent.liteav.a.a aVar = this.x;
        if (!(!this.t || aVar == null || this.D == null)) {
            this.D.a(this.E);
            aVar.a(this.D.d(i2), TXCTimeUtil.getTimeTick());
            this.D.a(this.F);
            this.D.c(i2);
        }
        if (this.t) {
            j();
            AppMethodBeat.o(221748);
            return;
        }
        k();
        AppMethodBeat.o(221748);
    }

    @Override // com.tencent.liteav.TXCRenderAndDec.a
    public void a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(221749);
        k();
        d();
        AppMethodBeat.o(221749);
    }

    @Override // com.tencent.liteav.audio.d
    public void onAudioPlayPcmData(String str, byte[] bArr, long j2, int i2, int i3) {
        AppMethodBeat.i(221750);
        this.r = i2;
        this.q = i3;
        if (this.x != null) {
            if (j2 <= 0) {
                j2 = TXCTimeUtil.getTimeTick();
            }
            this.x.a(bArr, j2);
        }
        if (this.Q <= 0 && this.M != null) {
            this.M.onAudioInfoChanged(i2, i3, 16);
        }
        if (this.M != null) {
            this.M.onPcmDataAvailable(bArr, j2);
        }
        if (this.Q <= 0) {
            this.Q = j2;
            AppMethodBeat.o(221750);
            return;
        }
        this.P = j2 - this.Q;
        AppMethodBeat.o(221750);
    }

    @Override // com.tencent.liteav.audio.c
    public void onAudioJitterBufferNotify(String str, int i2, String str2) {
        AppMethodBeat.i(221751);
        onNotifyEvent(i2, null);
        AppMethodBeat.o(221751);
    }

    @Override // com.tencent.liteav.n
    public void a(boolean z2, int i2) {
        AppMethodBeat.i(221752);
        this.I = z2;
        TXCAudioEngine.getInstance();
        TXCAudioEngine.enableAudioVolumeEvaluation(z2, i2);
        AppMethodBeat.o(221752);
    }

    @Override // com.tencent.liteav.n
    public int h() {
        AppMethodBeat.i(221753);
        int remotePlayoutVolumeLevel = TXCAudioEngine.getInstance().getRemotePlayoutVolumeLevel(this.N);
        AppMethodBeat.o(221753);
        return remotePlayoutVolumeLevel;
    }

    @Override // com.tencent.liteav.TXCRenderAndDec.b
    public void onRequestKeyFrame(String str, int i2) {
        AppMethodBeat.i(221754);
        if (this.o && this.f762g != null) {
            this.f762g.requestKeyFrame(this.G);
        }
        AppMethodBeat.o(221754);
    }
}
