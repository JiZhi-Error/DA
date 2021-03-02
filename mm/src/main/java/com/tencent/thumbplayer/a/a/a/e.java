package com.tencent.thumbplayer.a.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.http.HttpClientWrapper;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.thumbplayer.a.a.a.a;
import com.tencent.thumbplayer.a.a.c;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.core.common.TPGeneralError;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.utils.g;
import com.tencent.thumbplayer.utils.j;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class e implements com.tencent.thumbplayer.a.a.b {
    com.tencent.thumbplayer.f.a RVN;
    private c.f RVZ;
    private Object RVt;
    boolean RWP = false;
    long RWQ = 0;
    long RWR = 0;
    private FileDescriptor RWS;
    private float RWT = 1.0f;
    private float RWU = 1.0f;
    int RWV = 0;
    long RWW = -1;
    private long RWX = -1;
    int RWY = -1;
    int RWZ = -1;
    c.AbstractC2201c RWa;
    c.e RWb;
    c.d RWc;
    c.g RWd;
    c.m RWe;
    c.i RWf;
    long RXA = 0;
    private f RXB = null;
    @TargetApi(16)
    private MediaPlayer.OnTimedTextListener RXC = new MediaPlayer.OnTimedTextListener() {
        /* class com.tencent.thumbplayer.a.a.a.e.AnonymousClass6 */

        public final void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            AppMethodBeat.i(188851);
            if (e.this.RWf != null) {
                TPSubtitleData tPSubtitleData = new TPSubtitleData();
                tPSubtitleData.subtitleData = timedText != null ? timedText.getText() : "";
                tPSubtitleData.trackIndex = (long) e.this.RXu;
                tPSubtitleData.startPositionMs = e.this.getCurrentPositionMs();
                e.this.RWf.a(tPSubtitleData);
            }
            AppMethodBeat.o(188851);
        }
    };
    private boolean RXa = true;
    private d RXb;
    private com.tencent.thumbplayer.b.c RXc;
    private Future<?> RXd = null;
    private final Object RXe = new Object();
    private long RXf = 25000;
    private a RXg;
    private final Object RXh = new Object();
    int RXi = 3;
    int RXj = 30;
    final Object RXk = new Object();
    Future<?> RXl = null;
    boolean RXm = false;
    volatile EnumC2199e RXn;
    volatile EnumC2199e RXo;
    private boolean RXp = false;
    long RXq = 0;
    long RXr = -1;
    volatile boolean RXs = false;
    int RXt = 0;
    int RXu = -1;
    private int RXv = 0;
    private int RXw = -1;
    private List<b> RXx = new ArrayList();
    private List<b> RXy = new ArrayList();
    private a RXz;
    boolean gPs = false;
    private Map<String, String> jEZ;
    volatile MediaPlayer mBq;
    private Context mContext;
    private boolean mMute = false;
    private String mUrl;
    int mVideoHeight = 0;
    int mVideoWidth = 0;

    /* access modifiers changed from: package-private */
    public static class a {
        boolean RXF;
        Future<?> RXG;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public TPTrackInfo RXH;
        public String keyId;
        public String url;

        private b() {
            this.keyId = "";
            this.url = "";
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.thumbplayer.a.a.a.e$e  reason: collision with other inner class name */
    public enum EnumC2199e {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED,
        STARTED,
        PAUSED,
        STOPPED,
        COMPLETE,
        ERROR,
        RELEASE;

        public static EnumC2199e valueOf(String str) {
            AppMethodBeat.i(188860);
            EnumC2199e eVar = (EnumC2199e) Enum.valueOf(EnumC2199e.class, str);
            AppMethodBeat.o(188860);
            return eVar;
        }

        static {
            AppMethodBeat.i(188861);
            AppMethodBeat.o(188861);
        }
    }

    /* access modifiers changed from: package-private */
    public static class c implements Handler.Callback {
        private Handler RXI;

        c(Handler handler) {
            this.RXI = handler;
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(188852);
            try {
                this.RXI.handleMessage(message);
            } catch (Exception e2) {
                g.e("TPSystemMediaPlayer", "mediaPlayerExceptionHook, HookCallback, " + Log.getStackTraceString(e2));
            }
            AppMethodBeat.o(188852);
            return true;
        }
    }

    private void a(MediaPlayer mediaPlayer) {
        AppMethodBeat.i(188862);
        try {
            Field declaredField = MediaPlayer.class.getDeclaredField("mEventHandler");
            declaredField.setAccessible(true);
            Handler handler = (Handler) declaredField.get(mediaPlayer);
            Field declaredField2 = Handler.class.getDeclaredField("mCallback");
            declaredField2.setAccessible(true);
            if (((Handler.Callback) declaredField2.get(handler)) == null) {
                declaredField2.set(handler, new c(handler));
            }
            AppMethodBeat.o(188862);
        } catch (Exception e2) {
            this.RVN.error("mediaPlayerExceptionHook, " + Log.getStackTraceString(e2));
            AppMethodBeat.o(188862);
        }
    }

    public e(Context context, com.tencent.thumbplayer.f.b bVar) {
        AppMethodBeat.i(188863);
        this.RVN = new com.tencent.thumbplayer.f.a(bVar, "TPSystemMediaPlayer");
        this.mContext = context;
        this.RXb = new d(this, (byte) 0);
        b bVar2 = new b((byte) 0);
        bVar2.RXH = new TPTrackInfo();
        bVar2.RXH.isSelected = true;
        bVar2.RXH.name = "audio_1";
        this.RXx.add(bVar2);
        b bVar3 = new b();
        if (Build.VERSION.SDK_INT <= 19) {
            a(bVar3);
        }
        bVar3.setOnPreparedListener(this.RXb);
        bVar3.setOnCompletionListener(this.RXb);
        bVar3.setOnErrorListener(this.RXb);
        bVar3.setOnInfoListener(this.RXb);
        bVar3.setOnBufferingUpdateListener(this.RXb);
        bVar3.setOnSeekCompleteListener(this.RXb);
        bVar3.setOnVideoSizeChangedListener(this.RXb);
        if (Build.VERSION.SDK_INT >= 16) {
            bVar3.setOnTimedTextListener(this.RXC);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            bVar3.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(4).build());
        } else {
            bVar3.setAudioStreamType(3);
        }
        this.mBq = bVar3;
        this.RXn = EnumC2199e.IDLE;
        this.RXo = EnumC2199e.IDLE;
        this.RXz = new c();
        this.RXz.a(new a.AbstractC2198a() {
            /* class com.tencent.thumbplayer.a.a.a.e.AnonymousClass1 */

            @Override // com.tencent.thumbplayer.a.a.a.a.AbstractC2198a
            public final void a(a.c cVar) {
                AppMethodBeat.i(188846);
                TPSubtitleData tPSubtitleData = new TPSubtitleData();
                tPSubtitleData.subtitleData = cVar.text;
                c.i iVar = e.this.RWf;
                if (iVar != null) {
                    iVar.a(tPSubtitleData);
                }
                AppMethodBeat.o(188846);
            }
        });
        this.RXz.a(new a.b() {
            /* class com.tencent.thumbplayer.a.a.a.e.AnonymousClass2 */

            @Override // com.tencent.thumbplayer.a.a.a.a.b
            public final long getCurrentPosition() {
                AppMethodBeat.i(188847);
                if (e.this.RXn == EnumC2199e.PAUSED || e.this.RXn == EnumC2199e.STARTED) {
                    long currentPositionMs = e.this.getCurrentPositionMs();
                    AppMethodBeat.o(188847);
                    return currentPositionMs;
                }
                AppMethodBeat.o(188847);
                return -1;
            }
        });
        AppMethodBeat.o(188863);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void updateLoggerContext(com.tencent.thumbplayer.f.b bVar) {
        AppMethodBeat.i(188864);
        this.RVN.a(new com.tencent.thumbplayer.f.b(bVar, "TPSystemMediaPlayer"));
        AppMethodBeat.o(188864);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.thumbplayer.a.a.b
    public final void setPlayerOptionalParam(TPOptionalParam tPOptionalParam) {
        AppMethodBeat.i(188865);
        switch (tPOptionalParam.getKey()) {
            case 1:
                this.RWX = tPOptionalParam.getParamLong().value;
                AppMethodBeat.o(188865);
                return;
            case 2:
                this.RWZ = (int) tPOptionalParam.getParamLong().value;
                this.RVN.info("setPlayerOptionalParam, video width:" + this.RWZ);
                AppMethodBeat.o(188865);
                return;
            case 3:
                this.RWY = (int) tPOptionalParam.getParamLong().value;
                this.RVN.info("setPlayerOptionalParam, video height:" + this.RWY);
                AppMethodBeat.o(188865);
                return;
            case 4:
                this.gPs = tPOptionalParam.getParamBoolean().value;
                this.RXm = true;
                this.RVN.info("setPlayerOptionalParam, is live:" + this.gPs);
                AppMethodBeat.o(188865);
                return;
            case 5:
                this.RXa = tPOptionalParam.getParamBoolean().value;
                AppMethodBeat.o(188865);
                return;
            case 7:
                this.RXi = (int) (tPOptionalParam.getParamLong().value / 400);
                this.RVN.info("setPlayerOptionalParam, on buffer timeout:" + tPOptionalParam.getParamLong().value + "(ms)");
                break;
            case 100:
                this.RWV = (int) tPOptionalParam.getParamLong().value;
                this.RVN.info("setPlayerOptionalParam, start position:" + this.RWV);
                AppMethodBeat.o(188865);
                return;
            case 107:
                this.RXj = (int) ((tPOptionalParam.getParamLong().value + 400) / 400);
                this.RVN.info("setPlayerOptionalParam, buffer timeout:" + tPOptionalParam.getParamLong().value + "(ms)");
                AppMethodBeat.o(188865);
                return;
            case 128:
                this.RXf = tPOptionalParam.getParamLong().value;
                this.RVN.info("setPlayerOptionalParam, prepare timeout:" + this.RXf + "(ms)");
                AppMethodBeat.o(188865);
                return;
            case 500:
                this.RWW = tPOptionalParam.getParamLong().value;
                this.RVN.info("setPlayerOptionalParam, skip end position:" + this.RWW);
                AppMethodBeat.o(188865);
                return;
        }
        AppMethodBeat.o(188865);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.f fVar) {
        this.RVZ = fVar;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.AbstractC2201c cVar) {
        this.RWa = cVar;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.e eVar) {
        this.RWb = eVar;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.d dVar) {
        this.RWc = dVar;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.g gVar) {
        this.RWd = gVar;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.m mVar) {
        this.RWe = mVar;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.i iVar) {
        this.RWf = iVar;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.j jVar) {
        AppMethodBeat.i(188866);
        IllegalStateException illegalStateException = new IllegalStateException("system Mediaplayer cannot support subtitle frame out");
        AppMethodBeat.o(188866);
        throw illegalStateException;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.k kVar) {
        AppMethodBeat.i(188867);
        IllegalStateException illegalStateException = new IllegalStateException("system Mediaplayer cannot support video frame out");
        AppMethodBeat.o(188867);
        throw illegalStateException;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.a aVar) {
        AppMethodBeat.i(188868);
        IllegalStateException illegalStateException = new IllegalStateException("system Mediaplayer cannot support audio frame out");
        AppMethodBeat.o(188868);
        throw illegalStateException;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.l lVar) {
        AppMethodBeat.i(188869);
        IllegalStateException illegalStateException = new IllegalStateException("system Mediaplayer cannot support video postprocess frame out");
        AppMethodBeat.o(188869);
        throw illegalStateException;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.b bVar) {
        AppMethodBeat.i(188870);
        IllegalStateException illegalStateException = new IllegalStateException("system Mediaplayer cannot support audio postprocess frame out");
        AppMethodBeat.o(188870);
        throw illegalStateException;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setSurface(Surface surface) {
        AppMethodBeat.i(188871);
        this.RVN.info("setSurface, surface: ".concat(String.valueOf(surface)));
        this.RVt = surface;
        this.mBq.setSurface(surface);
        this.RVN.info("setSurface over, surface: ".concat(String.valueOf(surface)));
        AppMethodBeat.o(188871);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(188872);
        this.RVN.info("setSurfaceHolder, sh: ".concat(String.valueOf(surfaceHolder)));
        this.RVt = surfaceHolder;
        this.mBq.setDisplay(surfaceHolder);
        this.RVN.info("setSurfaceHolder over, sh: ".concat(String.valueOf(surfaceHolder)));
        AppMethodBeat.o(188872);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setDataSource(String str, Map<String, String> map) {
        AppMethodBeat.i(188873);
        this.RVN.info("setDataSource httpHeader, url: ".concat(String.valueOf(str)));
        this.mUrl = str;
        this.jEZ = map;
        this.mBq.setDataSource(this.mContext, Uri.parse(this.mUrl), this.jEZ);
        this.RXc = new com.tencent.thumbplayer.b.c(str);
        this.RXn = EnumC2199e.INITIALIZED;
        this.RXo = EnumC2199e.INITIALIZED;
        AppMethodBeat.o(188873);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setDataSource(ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(188874);
        if (parcelFileDescriptor == null) {
            this.RVN.info("setDataSource pfd is null ");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("pfd is null");
            AppMethodBeat.o(188874);
            throw illegalArgumentException;
        }
        this.RVN.info("setDataSource pfd， pfd: " + parcelFileDescriptor.toString());
        this.RWS = parcelFileDescriptor.getFileDescriptor();
        this.mBq.setDataSource(parcelFileDescriptor.getFileDescriptor());
        this.RXc = new com.tencent.thumbplayer.b.c(parcelFileDescriptor.getFileDescriptor());
        this.RXn = EnumC2199e.INITIALIZED;
        this.RXo = EnumC2199e.INITIALIZED;
        AppMethodBeat.o(188874);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setDataSource(ITPMediaAsset iTPMediaAsset) {
        AppMethodBeat.i(188875);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("setDataSource by asset, android mediaplayer not support");
        AppMethodBeat.o(188875);
        throw illegalArgumentException;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void addSubtitleSource(String str, String str2, String str3) {
        AppMethodBeat.i(188876);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            this.RVN.error("addSubtitleSource, illegal argument.");
            AppMethodBeat.o(188876);
            return;
        }
        TPTrackInfo tPTrackInfo = new TPTrackInfo();
        tPTrackInfo.name = str3;
        tPTrackInfo.isExclusive = true;
        tPTrackInfo.isInternal = false;
        tPTrackInfo.isSelected = false;
        tPTrackInfo.trackType = 3;
        b bVar = new b((byte) 0);
        bVar.RXH = tPTrackInfo;
        bVar.url = str;
        this.RVN.info("addSubtitleSource, name:" + tPTrackInfo.name + ", url:" + str3);
        this.RXy.add(bVar);
        AppMethodBeat.o(188876);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void g(String str, String str2, List<TPOptionalParam> list) {
        AppMethodBeat.i(188877);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            this.RVN.error("addAudioTrackSource, illegal argument.");
            AppMethodBeat.o(188877);
            return;
        }
        TPTrackInfo tPTrackInfo = new TPTrackInfo();
        tPTrackInfo.name = str2;
        tPTrackInfo.isExclusive = true;
        tPTrackInfo.isInternal = false;
        tPTrackInfo.isSelected = false;
        tPTrackInfo.trackType = 2;
        b bVar = new b((byte) 0);
        bVar.RXH = tPTrackInfo;
        bVar.url = str;
        Iterator<TPOptionalParam> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TPOptionalParam next = it.next();
            if (next.getKey() == 6) {
                bVar.keyId = next.getParamString().value;
                break;
            }
        }
        this.RVN.info("addAudioTrackSource, name:" + tPTrackInfo.name + ", url:" + str2);
        this.RXx.add(bVar);
        AppMethodBeat.o(188877);
    }

    /* access modifiers changed from: package-private */
    public static class f {
        long RVK;
        int RXU;
        int RXV;
        int RXW;
        int RXX;
        EnumC2199e RXY;
        long position;
        String url;

        private f() {
        }

        /* synthetic */ f(byte b2) {
            this();
        }
    }

    private void hmT() {
        boolean z;
        AppMethodBeat.i(188878);
        EnumC2199e eVar = this.RXo;
        if (eVar == EnumC2199e.PREPARED || eVar == EnumC2199e.STARTED || eVar == EnumC2199e.PAUSED) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.RXo = EnumC2199e.STOPPED;
            this.RVN.info("MediaPlayer stop.");
            this.mBq.stop();
        }
        AppMethodBeat.o(188878);
    }

    private synchronized void a(f fVar) {
        int i2;
        AppMethodBeat.i(188880);
        String str = fVar.url;
        fVar.position = getCurrentPositionMs();
        fVar.RXY = this.RXn;
        fVar.RXW = this.RXw;
        fVar.RXX = this.RXu;
        this.RVN.info("playerResetStart, pos:" + fVar.position + ", state:" + fVar.RXY);
        this.RXp = true;
        hmX();
        hmZ();
        hna();
        hmU();
        b bVar = new b();
        if (Build.VERSION.SDK_INT <= 19) {
            a(bVar);
        }
        bVar.setOnPreparedListener(this.RXb);
        bVar.setOnCompletionListener(this.RXb);
        bVar.setOnErrorListener(this.RXb);
        bVar.setOnInfoListener(this.RXb);
        bVar.setOnBufferingUpdateListener(this.RXb);
        bVar.setOnSeekCompleteListener(this.RXb);
        bVar.setOnVideoSizeChangedListener(this.RXb);
        if (Build.VERSION.SDK_INT >= 16) {
            bVar.setOnTimedTextListener(this.RXC);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            bVar.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(4).build());
        } else {
            bVar.setAudioStreamType(3);
        }
        if (this.mMute) {
            this.mBq.setVolume(0.0f, 0.0f);
        } else if (this.RWT != 1.0f) {
            this.mBq.setVolume(this.RWT, this.RWT);
        }
        if (((double) this.RWU) != 1.0d) {
            setPlaySpeedRatio(this.RWU);
        }
        if (this.RWP) {
            this.mBq.setLooping(this.RWP);
        }
        this.mBq = bVar;
        this.RXo = EnumC2199e.IDLE;
        if (this.RWS != null) {
            this.mBq.setDataSource(this.RWS);
        } else {
            int i3 = fVar.RXV;
            if (i3 > 0) {
                b bVar2 = this.RXx.get(i3);
                c.e eVar = this.RWb;
                if (eVar != null) {
                    TPPlayerMsg.TPAudioTrackInfo tPAudioTrackInfo = new TPPlayerMsg.TPAudioTrackInfo();
                    tPAudioTrackInfo.audioTrackUrl = bVar2.url;
                    tPAudioTrackInfo.keyId = bVar2.keyId;
                    this.RVN.info("handleDataSource, audioTrack url:" + tPAudioTrackInfo.audioTrackUrl + ", keyId:" + tPAudioTrackInfo.keyId);
                    eVar.a(1011, 0, 0, tPAudioTrackInfo);
                }
            }
            if (this.jEZ == null || this.jEZ.isEmpty()) {
                this.mBq.setDataSource(str);
            } else {
                this.mBq.setDataSource(this.mContext, Uri.parse(str), this.jEZ);
            }
        }
        this.RXo = EnumC2199e.INITIALIZED;
        if (this.RVt == null) {
            this.mBq.setDisplay(null);
        } else if (this.RVt instanceof SurfaceHolder) {
            this.mBq.setDisplay((SurfaceHolder) this.RVt);
        } else if (this.RVt instanceof Surface) {
            this.mBq.setSurface((Surface) this.RVt);
        }
        f fVar2 = this.RXB;
        if (!(fVar2 == null || fVar2.RXU == fVar.RXU)) {
            c.e eVar2 = this.RWb;
            if (fVar2.RXU == 1) {
                i2 = 3;
            } else {
                i2 = 4;
            }
            if (eVar2 != null) {
                eVar2.a(i2, fVar2.RVK, 0, null);
            }
            fVar.RXY = fVar2.RXY;
            fVar.position = fVar2.position;
        }
        this.RXB = fVar;
        if (fVar.RXY == EnumC2199e.PREPARING || fVar.RXY == EnumC2199e.PREPARED || fVar.RXY == EnumC2199e.STARTED || fVar.RXY == EnumC2199e.PAUSED) {
            this.mBq.prepareAsync();
            this.RXn = EnumC2199e.PREPARING;
            this.RXo = EnumC2199e.PREPARING;
            hmW();
        }
        AppMethodBeat.o(188880);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void hmV() {
        int i2;
        AppMethodBeat.i(188881);
        f fVar = this.RXB;
        this.RVN.info("playerResetEnd, actionInfo:" + fVar + ", mSuspend:" + this.RXp);
        if (fVar == null || !this.RXp) {
            if (this.RWV > 0 && !this.RXm) {
                this.RVN.info("onPrepared(), and seekto:" + this.RWV);
                try {
                    this.mBq.seekTo(this.RWV);
                } catch (Exception e2) {
                    this.RVN.r(e2);
                }
            }
            this.RXn = EnumC2199e.PREPARED;
            c.f fVar2 = this.RVZ;
            if (fVar2 != null) {
                fVar2.tf();
            }
            AppMethodBeat.o(188881);
        } else {
            c.e eVar = this.RWb;
            if (fVar.RXU == 1) {
                i2 = 3;
            } else {
                i2 = 4;
            }
            if (eVar != null) {
                eVar.a(i2, 1000, 0, Long.valueOf(fVar.RVK));
            }
            if (Build.VERSION.SDK_INT >= 16) {
                if (fVar.RXW > 0) {
                    this.mBq.selectTrack(fVar.RXW);
                }
                if (fVar.RXX > 0) {
                    this.mBq.selectTrack(fVar.RXX);
                }
            }
            if (fVar.position > 0 && !this.RXm) {
                this.RVN.info("playerResetEnd, onPrepared(), and seek to:" + fVar.position);
                try {
                    this.mBq.seekTo((int) fVar.position);
                } catch (Exception e3) {
                    this.RVN.r(e3);
                }
            }
            this.RVN.info("playerResetEnd, restore state:" + fVar.RXY);
            if (fVar.RXY == EnumC2199e.IDLE || fVar.RXY == EnumC2199e.INITIALIZED || fVar.RXY == EnumC2199e.PREPARING) {
                this.RXn = EnumC2199e.PREPARED;
                c.f fVar3 = this.RVZ;
                if (fVar3 != null) {
                    fVar3.tf();
                }
            } else if (fVar.RXY == EnumC2199e.PREPARED || fVar.RXY == EnumC2199e.PAUSED) {
                this.RXn = fVar.RXY;
            } else if (fVar.RXY == EnumC2199e.STARTED) {
                this.RVN.info("playerResetEnd,  MediaPlayer.start().");
                this.mBq.start();
                this.RXn = fVar.RXY;
                this.RXo = EnumC2199e.STARTED;
                hmY();
            } else {
                this.RVN.error("illegal state, state:" + fVar.RXY);
                this.RXn = EnumC2199e.ERROR;
                hmU();
                c.d dVar = this.RWc;
                if (dVar != null) {
                    dVar.a(2000, aqV(HttpClientWrapper.RET_CODE_FILE_NOT_FOUND), 0, 0);
                }
            }
            this.RXp = false;
            this.RXB = null;
            AppMethodBeat.o(188881);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void selectTrack(int i2, long j2) {
        AppMethodBeat.i(188882);
        this.RVN.info("selectTrack, trackID:" + i2 + ", opaque:" + j2);
        int size = this.RXx.size();
        int size2 = this.RXy.size();
        c.e eVar = this.RWb;
        if (i2 >= 0 && i2 < size) {
            try {
                f fVar = new f((byte) 0);
                fVar.RVK = j2;
                fVar.RXV = i2;
                fVar.RXU = 2;
                fVar.url = this.mUrl;
                a(fVar);
                this.RXx.get(this.RXv).RXH.isSelected = false;
                this.RXx.get(i2).RXH.isSelected = true;
                this.RXv = i2;
                AppMethodBeat.o(188882);
            } catch (Exception e2) {
                this.RVN.r(e2);
                if (eVar != null) {
                    eVar.a(4, (long) aqV(-10000), 0, Long.valueOf(j2));
                }
                AppMethodBeat.o(188882);
            }
        } else if (i2 < size || i2 >= size + size2) {
            int i3 = i2 - (size + size2);
            if (Build.VERSION.SDK_INT < 16) {
                this.RVN.error("selectTrack, android mediaplayer not support ");
                if (eVar != null) {
                    eVar.a(4, (long) aqV(-10001), 0, Long.valueOf(j2));
                }
                AppMethodBeat.o(188882);
            } else if (this.RXn == EnumC2199e.PREPARED || this.RXn == EnumC2199e.STARTED || this.RXn == EnumC2199e.PAUSED) {
                MediaPlayer.TrackInfo[] trackInfoArr = null;
                try {
                    trackInfoArr = this.mBq.getTrackInfo();
                } catch (Exception e3) {
                    this.RVN.error("getTrackInfo, android getTrackInfo crash");
                }
                if (trackInfoArr == null || trackInfoArr.length <= i3) {
                    if (eVar != null) {
                        eVar.a(4, (long) aqV(HttpClientWrapper.RET_CODE_PROTOCOL), 0, Long.valueOf(j2));
                    }
                    AppMethodBeat.o(188882);
                    return;
                }
                MediaPlayer.TrackInfo trackInfo = trackInfoArr[i3];
                if (trackInfo.getTrackType() == 2) {
                    this.RXw = i3;
                } else if (trackInfo.getTrackType() == 4) {
                    this.RXu = i3;
                } else {
                    if (eVar != null) {
                        eVar.a(4, (long) aqV(HttpClientWrapper.RET_CODE_ILLEGAL_STATE), 0, Long.valueOf(j2));
                    }
                    AppMethodBeat.o(188882);
                    return;
                }
                this.mBq.selectTrack(i3);
                if (eVar != null) {
                    eVar.a(4, 1000, 0, Long.valueOf(j2));
                }
                AppMethodBeat.o(188882);
            } else {
                this.RVN.error("selectTrack, illegal state:" + this.RXn);
                AppMethodBeat.o(188882);
            }
        } else {
            int i4 = i2 - size;
            try {
                this.RXz.reset();
                this.RXz.setDataSource(this.RXy.get(i4).url);
                this.RXz.prepare();
                AppMethodBeat.o(188882);
            } catch (Exception e4) {
                this.RVN.r(e4);
                if (eVar != null) {
                    eVar.a(4, (long) aqV(-10000), 0, Long.valueOf(j2));
                }
                AppMethodBeat.o(188882);
            }
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    @TargetApi(16)
    public final void deselectTrack(int i2, long j2) {
        AppMethodBeat.i(188883);
        if (Build.VERSION.SDK_INT < 16) {
            this.RVN.error("deselectTrack, android mediaplayer not support ");
            AppMethodBeat.o(188883);
            return;
        }
        this.mBq.deselectTrack(i2);
        AppMethodBeat.o(188883);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void prepare() {
        AppMethodBeat.i(188884);
        this.RVN.info("prepare ");
        this.RXn = EnumC2199e.PREPARING;
        this.RXo = EnumC2199e.PREPARING;
        this.mBq.prepare();
        AppMethodBeat.o(188884);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void prepareAsync() {
        AppMethodBeat.i(188885);
        this.RVN.info("prepareAsync ");
        this.RXn = EnumC2199e.PREPARING;
        this.RXo = EnumC2199e.PREPARING;
        this.mBq.prepareAsync();
        hmW();
        AppMethodBeat.o(188885);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void start() {
        AppMethodBeat.i(188886);
        this.RVN.info("start ");
        if (this.RXp) {
            if (this.RXB != null) {
                this.RXB.RXY = EnumC2199e.STARTED;
            }
            this.RVN.warn("system player is busy.");
            AppMethodBeat.o(188886);
        } else if (this.RXn == EnumC2199e.PREPARED || this.RXn == EnumC2199e.PAUSED) {
            this.mBq.start();
            this.RXn = EnumC2199e.STARTED;
            this.RXo = EnumC2199e.STARTED;
            if (((double) this.RWU) != 1.0d) {
                setPlaySpeedRatio(this.RWU);
            }
            hmY();
            AppMethodBeat.o(188886);
        } else {
            this.RVN.warn("start(), illegal state, state:" + this.RXn);
            AppMethodBeat.o(188886);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final synchronized void pause() {
        AppMethodBeat.i(188887);
        this.RVN.info("pause ");
        if (this.RXp) {
            if (this.RXB != null) {
                this.RXB.RXY = EnumC2199e.PAUSED;
            }
            this.RVN.warn("system player is busy.");
            AppMethodBeat.o(188887);
        } else {
            this.mBq.pause();
            this.RXn = EnumC2199e.PAUSED;
            this.RXo = EnumC2199e.PAUSED;
            AppMethodBeat.o(188887);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final synchronized void stop() {
        AppMethodBeat.i(188888);
        this.RVN.info("stop ");
        hmX();
        hmZ();
        hna();
        this.RXn = EnumC2199e.STOPPED;
        hmT();
        this.RXv = 0;
        this.RXB = null;
        this.RXu = -1;
        this.RXw = -1;
        this.RXz.stop();
        this.RXA = 0;
        this.RVN.info("stop over.");
        AppMethodBeat.o(188888);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final synchronized void reset() {
        AppMethodBeat.i(188889);
        this.RVN.info("reset ");
        this.RXn = EnumC2199e.IDLE;
        this.RXz.reset();
        hmT();
        hmX();
        hmZ();
        hna();
        this.RVN.info("reset over.");
        AppMethodBeat.o(188889);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final synchronized void release() {
        AppMethodBeat.i(188890);
        this.RVN.info("release ");
        this.RXz.release();
        hmX();
        hmZ();
        hna();
        this.RXn = EnumC2199e.RELEASE;
        hmU();
        this.RVZ = null;
        this.RWa = null;
        this.RWb = null;
        this.RWc = null;
        this.RWd = null;
        this.RWe = null;
        this.RWf = null;
        this.RVt = null;
        this.RVN.info("release over.");
        AppMethodBeat.o(188890);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void seekTo(int i2) {
        AppMethodBeat.i(188891);
        this.RVN.info("seekTo, position: ".concat(String.valueOf(i2)));
        if (this.RXm) {
            this.RVN.info("current media is not seekable, ignore");
            AppMethodBeat.o(188891);
        } else if (this.RXp) {
            if (this.RXB != null) {
                this.RXB.position = (long) i2;
            }
            AppMethodBeat.o(188891);
        } else {
            this.mBq.seekTo(i2);
            AppMethodBeat.o(188891);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    @TargetApi(26)
    public final void seekTo(int i2, @TPCommonEnum.TPSeekMode int i3) {
        int i4 = 0;
        AppMethodBeat.i(188892);
        this.RVN.info("seekTo, position: " + i2 + ", mode: " + i3);
        if (this.RXm) {
            this.RVN.info("current media is not seekable, ignore");
            AppMethodBeat.o(188892);
        } else if (this.RXp) {
            if (this.RXB != null) {
                this.RXB.position = (long) i2;
            }
            AppMethodBeat.o(188892);
        } else {
            MediaPlayer mediaPlayer = this.mBq;
            if (Build.VERSION.SDK_INT < 26) {
                this.RVN.info("os ver is too low, current sdk int:" + Build.VERSION.SDK_INT + ", is less than 26, use seekTo(int positionMs) instead");
                mediaPlayer.seekTo(i2);
                AppMethodBeat.o(188892);
                return;
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    i4 = 1;
                } else if (i3 == 3) {
                    i4 = 2;
                }
            }
            try {
                mediaPlayer.seekTo((long) i2, i4);
                AppMethodBeat.o(188892);
            } catch (Exception e2) {
                this.RVN.r(e2);
                try {
                    mediaPlayer.seekTo(i2);
                    AppMethodBeat.o(188892);
                } catch (Exception e3) {
                    this.RVN.r(e3);
                    AppMethodBeat.o(188892);
                }
            }
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void L(String str, @TPCommonEnum.TPSwitchDefMode int i2, long j2) {
        AppMethodBeat.i(188893);
        this.RVN.info("switchDefinition, defUrl: ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            this.RVN.info("switchDefinition, defUrl is null");
            AppMethodBeat.o(188893);
            return;
        }
        this.mUrl = str;
        f fVar = new f((byte) 0);
        fVar.RVK = j2;
        fVar.RXV = this.RXv;
        fVar.RXU = 1;
        fVar.url = str;
        try {
            a(fVar);
            AppMethodBeat.o(188893);
        } catch (Exception e2) {
            IllegalStateException illegalStateException = new IllegalStateException("playerResetStart");
            AppMethodBeat.o(188893);
            throw illegalStateException;
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(ITPMediaAsset iTPMediaAsset, @TPCommonEnum.TPSwitchDefMode int i2, long j2) {
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setOutputMute(boolean z) {
        AppMethodBeat.i(188894);
        this.RVN.info("setOutputMute, : ".concat(String.valueOf(z)));
        this.mMute = z;
        if (z) {
            try {
                this.mBq.setVolume(0.0f, 0.0f);
                this.RVN.info("setOutputMute, true");
                AppMethodBeat.o(188894);
            } catch (Exception e2) {
                this.RVN.info("setOutputMute, Exception: " + e2.toString());
                AppMethodBeat.o(188894);
            }
        } else {
            this.mBq.setVolume(this.RWT, this.RWT);
            this.RVN.info("setOutputMute, false, mAudioGain: " + this.RWT);
            AppMethodBeat.o(188894);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setAudioGainRatio(float f2) {
        AppMethodBeat.i(188895);
        this.RVN.info("setAudioGainRatio, : ".concat(String.valueOf(f2)));
        this.RWT = f2;
        try {
            if (this.mBq != null) {
                this.mBq.setVolume(this.RWT, this.RWT);
            }
            AppMethodBeat.o(188895);
        } catch (IllegalStateException e2) {
            this.RVN.info("setAudioGainRatio ex : " + e2.toString());
            AppMethodBeat.o(188895);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setAudioNormalizeVolumeParams(String str) {
        AppMethodBeat.i(188896);
        this.RVN.info("setAudioNormalizeVolumeParams not supported.");
        AppMethodBeat.o(188896);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    @TargetApi(23)
    public final void setPlaySpeedRatio(float f2) {
        AppMethodBeat.i(188897);
        this.RVN.info("setPlaySpeedRatio, : ".concat(String.valueOf(f2)));
        if (Build.VERSION.SDK_INT < 23) {
            this.RVN.info("os version is too low: " + Build.VERSION.SDK_INT);
            AppMethodBeat.o(188897);
            return;
        }
        this.RWU = f2;
        this.RVN.info("setPlaySpeedRatio play speed:".concat(String.valueOf(f2)));
        try {
            PlaybackParams playbackParams = this.mBq.getPlaybackParams();
            if (playbackParams.getSpeed() != f2) {
                playbackParams.setSpeed(f2);
                this.mBq.setPlaybackParams(playbackParams);
            }
            AppMethodBeat.o(188897);
        } catch (Exception e2) {
            this.RVN.r(e2);
            AppMethodBeat.o(188897);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setLoopback(boolean z) {
        AppMethodBeat.i(188898);
        this.RVN.info("setLoopback, : ".concat(String.valueOf(z)));
        this.RWP = z;
        this.mBq.setLooping(z);
        AppMethodBeat.o(188898);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setLoopback(boolean z, long j2, long j3) {
        AppMethodBeat.i(188899);
        this.RVN.info("setLoopback, : " + z + ", loopStart: " + j2 + ", loopEnd: " + j3);
        if (j2 < 0 || j2 > this.RXq || j3 > this.RXq) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("position error, must more than 0 and less than duration");
            AppMethodBeat.o(188899);
            throw illegalArgumentException;
        }
        this.RWP = z;
        this.RWQ = j2;
        this.RWR = j3;
        this.mBq.setLooping(z);
        AppMethodBeat.o(188899);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getPropertyLong(int i2) {
        return -1;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final String getPropertyString(int i2) {
        return null;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getDurationMs() {
        AppMethodBeat.i(188900);
        if (this.gPs) {
            AppMethodBeat.o(188900);
            return 0;
        } else if (this.RXp) {
            long j2 = this.RXq;
            AppMethodBeat.o(188900);
            return j2;
        } else if (this.RXn == EnumC2199e.PREPARED || this.RXn == EnumC2199e.STARTED || this.RXn == EnumC2199e.PAUSED) {
            if (this.RXq <= 0) {
                this.RXq = (long) this.mBq.getDuration();
            }
            if (this.RWX > 0) {
                if (this.RXq <= 0) {
                    this.RXq = this.RWX;
                } else if ((Math.abs(this.RWX - this.RXq) * 100) / this.RWX > 1) {
                    this.RXq = this.RWX;
                }
            }
            long j3 = this.RXq;
            AppMethodBeat.o(188900);
            return j3;
        } else {
            AppMethodBeat.o(188900);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getCurrentPositionMs() {
        AppMethodBeat.i(188901);
        if (this.gPs) {
            AppMethodBeat.o(188901);
            return 0;
        } else if (this.RXp || this.RXn == EnumC2199e.ERROR) {
            if (this.RXr == -1) {
                long j2 = (long) this.RWV;
                AppMethodBeat.o(188901);
                return j2;
            }
            long j3 = this.RXr;
            AppMethodBeat.o(188901);
            return j3;
        } else if (this.RXn == EnumC2199e.IDLE || this.RXn == EnumC2199e.INITIALIZED || this.RXn == EnumC2199e.PREPARING || this.RXn == EnumC2199e.STOPPED || this.RXn == EnumC2199e.PREPARED) {
            long j4 = (long) this.RWV;
            AppMethodBeat.o(188901);
            return j4;
        } else {
            long currentPosition = (long) this.mBq.getCurrentPosition();
            AppMethodBeat.o(188901);
            return currentPosition;
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getPlayableDurationMs() {
        return 0;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final int getVideoWidth() {
        AppMethodBeat.i(188902);
        this.RVN.info("getVideoWidth, width:" + this.mVideoWidth);
        int i2 = this.mVideoWidth;
        AppMethodBeat.o(188902);
        return i2;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final int getVideoHeight() {
        AppMethodBeat.i(188903);
        this.RVN.info("getVideoHeight, height:" + this.mVideoHeight);
        int i2 = this.mVideoHeight;
        AppMethodBeat.o(188903);
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c A[LOOP:0: B:24:0x0066->B:26:0x006c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0088 A[LOOP:1: B:29:0x0082->B:31:0x0088, LOOP_END] */
    @Override // com.tencent.thumbplayer.a.a.b
    @android.annotation.TargetApi(16)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.thumbplayer.api.TPTrackInfo[] getTrackInfo() {
        /*
        // Method dump skipped, instructions count: 211
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.a.a.a.e.getTrackInfo():com.tencent.thumbplayer.api.TPTrackInfo[]");
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void selectProgram(int i2, long j2) {
        AppMethodBeat.i(188905);
        this.RVN.error("selectProgram, android mediaplayer not support");
        AppMethodBeat.o(188905);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final TPProgramInfo[] getProgramInfo() {
        return new TPProgramInfo[0];
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void captureVideo(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        AppMethodBeat.i(188906);
        if (this.RXc != null) {
            TPImageGeneratorParams tPImageGeneratorParams = new TPImageGeneratorParams();
            tPImageGeneratorParams.width = tPCaptureParams.width;
            tPImageGeneratorParams.height = tPCaptureParams.height;
            tPImageGeneratorParams.format = tPCaptureParams.format;
            tPImageGeneratorParams.requestedTimeMsToleranceBefore = tPCaptureParams.requestedTimeMsToleranceBefore;
            tPImageGeneratorParams.requestedTimeMsToleranceAfter = tPCaptureParams.requestedTimeMsToleranceAfter;
            this.RXc.a(getCurrentPositionMs(), tPImageGeneratorParams, tPCaptureCallBack);
            AppMethodBeat.o(188906);
            return;
        }
        tPCaptureCallBack.onCaptureVideoFailed(TPGeneralError.UNMATCHED_STATE);
        AppMethodBeat.o(188906);
    }

    private void hmW() {
        AppMethodBeat.i(188907);
        this.RVN.info("startCheckPrepareTimeoutTimer");
        synchronized (this.RXe) {
            try {
                if (this.RXd == null) {
                    this.RXd = j.getScheduledExecutorServiceInstance().schedule(new Runnable() {
                        /* class com.tencent.thumbplayer.a.a.a.e.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(188848);
                            if (e.this.RXn == EnumC2199e.PREPARING) {
                                e.this.RVN.error("startCheckPrepareTimeoutTimer, post error");
                                e.this.RXn = EnumC2199e.ERROR;
                                e.this.hmU();
                                e.this.hmX();
                                c.d dVar = e.this.RWc;
                                if (dVar != null) {
                                    dVar.a(2001, e.aqV(ExportErrorStatus.APPEND_BUFFER), 0, 0);
                                }
                            }
                            AppMethodBeat.o(188848);
                        }
                    }, this.RXf, TimeUnit.MILLISECONDS);
                }
            } finally {
                AppMethodBeat.o(188907);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void hmX() {
        AppMethodBeat.i(188908);
        synchronized (this.RXe) {
            try {
                if (this.RXd != null) {
                    this.RXd.cancel(true);
                    this.RXd = null;
                }
            } finally {
                AppMethodBeat.o(188908);
            }
        }
    }

    private void hmY() {
        AppMethodBeat.i(188909);
        synchronized (this.RXh) {
            try {
                if (!hnb()) {
                    this.RVN.info("startCheckBufferingTimer, forbidden check buffer by position");
                    return;
                }
                if (this.RXg == null) {
                    this.RXg = new a((byte) 0);
                    final a aVar = this.RXg;
                    this.RXg.RXF = false;
                    this.RXg.RXG = j.getScheduledExecutorServiceInstance().schedule(new Runnable() {
                        /* class com.tencent.thumbplayer.a.a.a.e.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(188849);
                            while (!aVar.RXF) {
                                e eVar = e.this;
                                long currentPositionMs = eVar.getCurrentPositionMs();
                                long j2 = eVar.RXr;
                                eVar.RXr = currentPositionMs;
                                if (eVar.RXn == EnumC2199e.STARTED) {
                                    if (eVar.RWP) {
                                        if (eVar.RWR > 0 && currentPositionMs >= eVar.RWR && !eVar.RXm) {
                                            eVar.RVN.info("checkBuffingEvent, loopback skip end, curPosition:" + currentPositionMs + ", mLoopStartPositionMs:" + eVar.RWQ);
                                            eVar.mBq.seekTo((int) eVar.RWQ);
                                        }
                                    } else if (eVar.RWW > 0 && currentPositionMs >= eVar.getDurationMs() - eVar.RWW) {
                                        eVar.RVN.info("checkBuffingEvent, skip end, mBaseDuration: " + eVar.RXq + ", curPosition:" + currentPositionMs + ", mSkipEndMilsec:" + eVar.RWW);
                                        eVar.RXn = EnumC2199e.COMPLETE;
                                        eVar.hmU();
                                        eVar.hmZ();
                                        c.AbstractC2201c cVar = eVar.RWa;
                                        if (cVar != null) {
                                            cVar.onCompletion();
                                        }
                                    }
                                    if (currentPositionMs != j2) {
                                        eVar.RXA++;
                                    }
                                    if (currentPositionMs != j2 || currentPositionMs <= 0) {
                                        if (eVar.RXs) {
                                            eVar.RVN.info("checkBuffingEvent, position change, send end buffering");
                                            c.e eVar2 = eVar.RWb;
                                            if (eVar2 != null) {
                                                eVar2.a(201, currentPositionMs, eVar.RXq, Long.valueOf(eVar.RXA));
                                            }
                                        }
                                        eVar.RXs = false;
                                        eVar.RXt = 0;
                                    } else {
                                        int i2 = eVar.RXt + 1;
                                        eVar.RXt = i2;
                                        if (i2 >= eVar.RXi && !eVar.RXs) {
                                            eVar.RXs = true;
                                            eVar.RVN.info("checkBuffingEvent, position no change,send start buffering");
                                            c.e eVar3 = eVar.RWb;
                                            if (eVar3 != null) {
                                                eVar3.a(200, currentPositionMs, eVar.RXq, Long.valueOf(eVar.RXA));
                                            }
                                        }
                                        if (eVar.RXt >= eVar.RXj) {
                                            eVar.RVN.error("checkBuffingEvent post error");
                                            eVar.RXn = EnumC2199e.ERROR;
                                            eVar.hmU();
                                            eVar.RXs = false;
                                            eVar.hmZ();
                                            c.d dVar = eVar.RWc;
                                            if (dVar != null) {
                                                dVar.a(2001, e.aqV(ExportErrorStatus.APPEND_BUFFER), 0, 0);
                                            }
                                        }
                                    }
                                } else if (eVar.RXn == EnumC2199e.PAUSED && eVar.RXs) {
                                    eVar.RVN.info("checkBuffingEvent, pause state and send end buffering");
                                    eVar.RXs = false;
                                    eVar.RXt = 0;
                                    c.e eVar4 = eVar.RWb;
                                    if (eVar4 != null) {
                                        eVar4.a(201, 0, 0, null);
                                    }
                                }
                                try {
                                    Thread.sleep(400);
                                } catch (InterruptedException e2) {
                                }
                            }
                            AppMethodBeat.o(188849);
                        }
                    }, 0, TimeUnit.MILLISECONDS);
                }
                AppMethodBeat.o(188909);
            } finally {
                AppMethodBeat.o(188909);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void hmZ() {
        AppMethodBeat.i(188910);
        synchronized (this.RXh) {
            try {
                if (this.RXg != null) {
                    this.RXg.RXF = true;
                    if (this.RXg.RXG != null) {
                        this.RXg.RXG.cancel(true);
                    }
                    this.RXg.RXG = null;
                    this.RXg = null;
                }
            } finally {
                AppMethodBeat.o(188910);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void hna() {
        AppMethodBeat.i(188911);
        synchronized (this.RXk) {
            try {
                if (this.RXl != null) {
                    this.RXl.cancel(true);
                    this.RXl = null;
                }
            } finally {
                AppMethodBeat.o(188911);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean hnb() {
        if (this.gPs) {
            return false;
        }
        return this.RXa;
    }

    /* access modifiers changed from: package-private */
    public class d implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        private d() {
        }

        /* synthetic */ d(e eVar, byte b2) {
            this();
        }

        public final void onPrepared(MediaPlayer mediaPlayer) {
            AppMethodBeat.i(188853);
            if (e.this.RXn != EnumC2199e.PREPARING) {
                e.this.RVN.info("onPrepared() is called in a wrong situation, mState = " + e.this.RXn);
                AppMethodBeat.o(188853);
                return;
            }
            e.this.RXo = EnumC2199e.PREPARED;
            long duration = (long) e.this.mBq.getDuration();
            if (duration <= 0) {
                e.this.RXm = true;
            }
            e.this.RVN.info("onPrepared() , mStartPositionMs=" + e.this.RWV + ", duration:" + duration + ", mIsLive:" + e.this.gPs);
            e.this.hmX();
            e.this.hmV();
            AppMethodBeat.o(188853);
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.i(188854);
            if (e.this.gPs) {
                e.this.RVN.warn("onCompletion, unknown err.");
                AppMethodBeat.o(188854);
                return;
            }
            e.this.RVN.info("onCompletion.");
            e.this.RXn = EnumC2199e.COMPLETE;
            e.this.hmU();
            e.this.hmZ();
            c.AbstractC2201c cVar = e.this.RWa;
            if (cVar != null) {
                cVar.onCompletion();
            }
            AppMethodBeat.o(188854);
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            int i4 = 2000;
            AppMethodBeat.i(188855);
            if (e.this.RXn == EnumC2199e.COMPLETE || e.this.RXn == EnumC2199e.STOPPED || e.this.RXn == EnumC2199e.RELEASE || e.this.RXn == EnumC2199e.IDLE || e.this.RXn == EnumC2199e.ERROR) {
                e.this.RVN.info("onError, illegal state:" + e.this.RXn + ", what:" + i2 + ", extra:" + i3);
                AppMethodBeat.o(188855);
            } else {
                e.this.RVN.info("onError, what: " + i2 + ", extra: " + i3);
                e.this.hmX();
                e.this.hmZ();
                e.this.RXn = EnumC2199e.ERROR;
                switch (i3) {
                    case -1010:
                    case -1007:
                        break;
                    case -1005:
                    case -1004:
                    case -1003:
                    case ExportErrorStatus.APPEND_BUFFER:
                        i4 = 2001;
                        break;
                    default:
                        switch (i2) {
                            case 100:
                                i4 = 2001;
                                break;
                        }
                }
                e.this.hmU();
                c.d dVar = e.this.RWc;
                if (dVar != null) {
                    dVar.a(i4, e.aqV(i2), (long) i3, 0);
                }
                AppMethodBeat.o(188855);
            }
            return true;
        }

        public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            AppMethodBeat.i(188856);
            e.this.RVN.info("mediaplayer, onInfo. what:" + i2 + ", extra:" + i3);
            int i4 = -1;
            switch (i2) {
                case 3:
                    i4 = 106;
                    break;
                case 701:
                    i4 = 200;
                    break;
                case 702:
                    i4 = 201;
                    break;
                case 801:
                    e.this.RXm = true;
                    break;
                default:
                    i4 = -1;
                    break;
            }
            if (i4 != -1) {
                if (200 == i4 || 201 == i4) {
                    if (!e.this.hnb()) {
                        if (200 == i4) {
                            e.this.RXs = true;
                            e eVar = e.this;
                            synchronized (eVar.RXk) {
                                try {
                                    if (eVar.RXl == null) {
                                        eVar.RXl = j.getScheduledExecutorServiceInstance().schedule(new Runnable() {
                                            /* class com.tencent.thumbplayer.a.a.a.e.AnonymousClass5 */

                                            public final void run() {
                                                AppMethodBeat.i(188850);
                                                if (e.this.RXn != EnumC2199e.PAUSED && e.this.RXs) {
                                                    e.this.RVN.error("startCheckBufferTimeOutByInfo, buffer last too long");
                                                    e.this.RXn = EnumC2199e.ERROR;
                                                    e.this.hmU();
                                                    e.this.RXs = false;
                                                    e.this.hna();
                                                    c.d dVar = e.this.RWc;
                                                    if (dVar != null) {
                                                        dVar.a(2001, e.aqV(ExportErrorStatus.APPEND_BUFFER), 0, 0);
                                                    }
                                                }
                                                AppMethodBeat.o(188850);
                                            }
                                        }, (long) (eVar.RXj * 400), TimeUnit.MILLISECONDS);
                                    }
                                } catch (Throwable th) {
                                    AppMethodBeat.o(188856);
                                    throw th;
                                }
                            }
                        } else {
                            e.this.RXs = false;
                            e.this.hna();
                        }
                        if (e.this.RWb != null) {
                            e.this.RWb.a(i4, 0, 0, null);
                        }
                    }
                } else if (e.this.RWb != null) {
                    e.this.RWb.a(106, 0, 0, null);
                }
            }
            if (i4 == 106) {
                int aqW = aqW(mediaPlayer.getVideoWidth());
                int aqX = aqX(mediaPlayer.getVideoHeight());
                if (!(aqX == e.this.mVideoHeight && aqW == e.this.mVideoWidth) && aqX > 0 && aqW > 0) {
                    e.this.mVideoHeight = aqX;
                    e.this.mVideoWidth = aqW;
                    if (e.this.RWe != null) {
                        e.this.RWe.aI((long) e.this.mVideoWidth, (long) e.this.mVideoHeight);
                    }
                }
            }
            AppMethodBeat.o(188856);
            return true;
        }

        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            AppMethodBeat.i(188857);
            if (e.this.mBq == null) {
                AppMethodBeat.o(188857);
                return;
            }
            e.this.RVN.info("onSeekComplete().");
            if (!(EnumC2199e.PREPARED == e.this.RXn || e.this.RWd == null)) {
                e.this.RWd.cJH();
            }
            AppMethodBeat.o(188857);
        }

        private int aqW(int i2) {
            if (e.this.RWZ > 0) {
                return e.this.RWZ;
            }
            return i2;
        }

        private int aqX(int i2) {
            if (e.this.RWY > 0) {
                return e.this.RWY;
            }
            return i2;
        }

        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            AppMethodBeat.i(188858);
            if (i2 == 0 || i3 == 0) {
                e.this.RVN.error("onVideoSizeChanged() size error, width:" + i2 + " height:" + i3);
                AppMethodBeat.o(188858);
                return;
            }
            int aqW = aqW(i2);
            int aqX = aqX(i3);
            try {
                if (!(aqW == e.this.mVideoWidth && aqX == e.this.mVideoHeight) && aqX > 0 && aqW > 0) {
                    e.this.RWe.aI((long) aqW, (long) aqX);
                }
            } catch (Exception e2) {
                e.this.RVN.warn(e2.toString());
            }
            e.this.mVideoWidth = aqW;
            e.this.mVideoHeight = aqX;
            e.this.RVN.info("onVideoSizeChanged(), width:" + aqW + " height:" + aqX);
            AppMethodBeat.o(188858);
        }

        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        }
    }

    static int aqV(int i2) {
        long j2;
        long j3 = 2147483647L;
        if (i2 < 0) {
            j2 = 10000000 - ((long) i2);
        } else {
            j2 = ((long) i2) + 10000000;
        }
        if (j2 < 2147483647L) {
            j3 = j2;
        }
        return (int) j3;
    }

    /* access modifiers changed from: package-private */
    public final void hmU() {
        boolean z;
        AppMethodBeat.i(188879);
        this.mBq.setOnPreparedListener(null);
        this.mBq.setOnCompletionListener(null);
        this.mBq.setOnErrorListener(null);
        this.mBq.setOnInfoListener(null);
        this.mBq.setOnBufferingUpdateListener(null);
        this.mBq.setOnSeekCompleteListener(null);
        this.mBq.setOnVideoSizeChangedListener(null);
        hmT();
        if (this.RXo != EnumC2199e.RELEASE) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.RXo = EnumC2199e.RELEASE;
            this.RVN.info("MediaPlayer release.");
            this.mBq.release();
        }
        AppMethodBeat.o(188879);
    }
}
