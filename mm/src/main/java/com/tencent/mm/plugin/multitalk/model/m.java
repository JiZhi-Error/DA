package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.multitalk.b.t;
import com.tencent.mm.plugin.multitalk.b.u;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\f\u0018\u0000 \\2\u00020\u0001:\u0003\\]^B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00107\u001a\u0002082\b\u00101\u001a\u0004\u0018\u000102J\u0016\u00109\u001a\u0002082\f\u0010:\u001a\b\u0012\u0004\u0012\u0002080;H\u0002J\u0016\u0010<\u001a\u0002082\f\u0010:\u001a\b\u0012\u0004\u0012\u0002080;H\u0002J\u0006\u0010=\u001a\u000208J\u0006\u0010>\u001a\u00020?J\b\u0010@\u001a\u000208H\u0016J\u0018\u0010A\u001a\u0002082\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CH\u0016J:\u0010E\u001a\u0002082\b\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020C2\u0006\u0010I\u001a\u00020C2\u0006\u0010J\u001a\u00020C2\u0006\u0010K\u001a\u00020C2\u0006\u0010L\u001a\u00020CH\u0002JB\u0010M\u001a\u0002082\b\u0010F\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020$2\u0006\u0010H\u001a\u00020C2\u0006\u0010I\u001a\u00020C2\u0006\u0010P\u001a\u00020C2\u0006\u0010Q\u001a\u00020C2\u0006\u0010R\u001a\u00020SH\u0016J\u0006\u0010T\u001a\u000208J\u0014\u0010U\u001a\u0002082\f\u0010V\u001a\b\u0012\u0004\u0012\u0002080;J\u0006\u0010W\u001a\u000208J\u0006\u0010X\u001a\u000208J\b\u0010Y\u001a\u000208H\u0002J\u0006\u0010Z\u001a\u000208J\u0006\u0010[\u001a\u000208R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006_"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager;", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "()V", "captureRender", "Lcom/tencent/mm/plugin/multitalk/model/MultitalkCaptureRenderer;", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "eglHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getEglHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setEglHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "eglThread", "Landroid/os/HandlerThread;", "getEglThread", "()Landroid/os/HandlerThread;", "setEglThread", "(Landroid/os/HandlerThread;)V", "externalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getExternalTexture", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setExternalTexture", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "frameTransObj", "Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;", "getFrameTransObj", "()Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;", "setFrameTransObj", "(Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;)V", "lastFrameTick", "", "nativeDrawerObj", "Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameObj;", "getNativeDrawerObj", "()Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameObj;", "setNativeDrawerObj", "(Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameObj;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;", "getUiCallback", "()Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;", "setUiCallback", "(Lcom/tencent/mm/plugin/multitalk/model/IMultiTalkUICallback;)V", "addUiCallback", "", "checkCreate", "initCallback", "Lkotlin/Function0;", "createContext", "exchangeCapture", "isCameraOpen", "", "onCameraError", "onCameraPreviewApply", "width", "", "height", "onDrawerReady", "pBuffer", "", "w", "h", "MediaFmt", "mirror", "angle", "onFrameDataReady", "", "lBufferSize", "cameraFrameFormat", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "dblSampleTime", "", "onTimeTick", "queue", "callback", "release", "removeUiCallback", "startCapture", "startCaptureRenderer", "stopCaptureRender", "Companion", "FrameObj", "FrameTrans", "plugin-multitalk_release"})
public final class m implements com.tencent.mm.plugin.voip.video.camera.a.b {
    public static final a zLW = new a((byte) 0);
    HandlerThread hDq;
    MMHandler hDr;
    c.b ilw;
    SurfaceTexture surfaceTexture;
    com.tencent.mm.media.g.d zLQ;
    public e zLR;
    public long zLS;
    public x zLT;
    private c zLU = new c();
    private b zLV = new b((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameTrans;", "", "()V", "h", "", "getH", "()I", "setH", "(I)V", "outImg", "", "getOutImg", "()[I", "setOutImg", "([I)V", "w", "getW", "setW", "plugin-multitalk_release"})
    public static final class c {

        /* renamed from: h  reason: collision with root package name */
        int f1508h;
        int w;
        int[] zLY;
    }

    static {
        AppMethodBeat.i(239619);
        AppMethodBeat.o(239619);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public m() {
        AppMethodBeat.i(239618);
        AppMethodBeat.o(239618);
    }

    public static final /* synthetic */ void c(m mVar) {
        AppMethodBeat.i(239621);
        mVar.sz();
        AppMethodBeat.o(239621);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
    public static final class f implements SurfaceTexture.OnFrameAvailableListener {
        public static final f zMc = new f();

        static {
            AppMethodBeat.i(239605);
            AppMethodBeat.o(239605);
        }

        f() {
        }

        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(239604);
            try {
                surfaceTexture.updateTexImage();
                AppMethodBeat.o(239604);
            } catch (Exception e2) {
                Log.e("MicroMsg.MultiTalkCameraManager", "updateTexImage error");
                AppMethodBeat.o(239604);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$createContext$1$2"})
    public static final class e implements Runnable {
        final /* synthetic */ m zLZ;
        final /* synthetic */ kotlin.g.a.a zMb;

        e(m mVar, kotlin.g.a.a aVar) {
            this.zLZ = mVar;
            this.zMb = aVar;
        }

        public final void run() {
            AppMethodBeat.i(239603);
            this.zMb.invoke();
            AppMethodBeat.o(239603);
        }
    }

    public final void emE() {
        AppMethodBeat.i(239609);
        if (this.zLT != null && !emo()) {
            sz();
        }
        AppMethodBeat.o(239609);
    }

    private void k(kotlin.g.a.a<x> aVar) {
        MMHandler mMHandler;
        AppMethodBeat.i(239610);
        p.h(aVar, "callback");
        HandlerThread handlerThread = this.hDq;
        if (handlerThread == null) {
            AppMethodBeat.o(239610);
        } else if (!handlerThread.isAlive() || (mMHandler = this.hDr) == null) {
            AppMethodBeat.o(239610);
        } else {
            mMHandler.post(new n(aVar));
            AppMethodBeat.o(239610);
        }
    }

    public final void release() {
        AppMethodBeat.i(239611);
        this.zLS = 0;
        k(new g(this));
        AppMethodBeat.o(239611);
    }

    public final void emF() {
        AppMethodBeat.i(239612);
        h hVar = new h(this);
        this.hDq = com.tencent.f.c.d.hz("MultiTalkCameraManager_Thread" + hashCode(), 5);
        HandlerThread handlerThread = this.hDq;
        if (handlerThread != null) {
            handlerThread.start();
        }
        HandlerThread handlerThread2 = this.hDq;
        this.hDr = new MMHandler(handlerThread2 != null ? handlerThread2.getLooper() : null);
        k(new d(this, hVar));
        AppMethodBeat.o(239612);
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void cza() {
        AppMethodBeat.i(239613);
        e eVar = this.zLR;
        if (eVar != null) {
            eVar.emy();
            AppMethodBeat.o(239613);
            return;
        }
        AppMethodBeat.o(239613);
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void fs(int i2, int i3) {
        AppMethodBeat.i(239614);
        Log.i("MicroMsg.MultiTalkCameraManager", "camera preview size applye is " + i2 + " and " + i3);
        AppMethodBeat.o(239614);
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void a(byte[] bArr, long j2, int i2, int i3, int i4, int i5) {
        Boolean bool;
        int i6;
        int b2;
        long j3;
        int i7;
        int i8;
        AppMethodBeat.i(239615);
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        if (!eom.ent()) {
            release();
            AppMethodBeat.o(239615);
        } else if (bArr == null) {
            AppMethodBeat.o(239615);
        } else if (this.zLT == null) {
            AppMethodBeat.o(239615);
        } else {
            x xVar = this.zLT;
            if (xVar != null) {
                bool = xVar.zNV;
            } else {
                bool = null;
            }
            if (bool == null) {
                AppMethodBeat.o(239615);
                return;
            }
            if (this.zLU.zLY == null) {
                this.zLU.w = i2;
                this.zLU.f1508h = i3;
                this.zLU.zLY = new int[(this.zLU.w * this.zLU.f1508h)];
            }
            q eom2 = ac.eom();
            p.g(eom2, "SubCoreMultiTalk.getMultiTalkManager()");
            if (!eom2.eno()) {
                ac.eom().aF(3, ac.eom().zMz);
            }
            q eom3 = ac.eom();
            p.g(eom3, "SubCoreMultiTalk.getMultiTalkManager()");
            boolean ens = eom3.ens();
            q eom4 = ac.eom();
            p.g(eom4, "SubCoreMultiTalk.getMultiTalkManager()");
            if (!eom4.eno()) {
                ac.eom().aF(3, ac.eom().zMz);
            }
            long currentTimeMillis = System.currentTimeMillis();
            q eom5 = ac.eom();
            p.g(eom5, "SubCoreMultiTalk.getMultiTalkManager()");
            x xVar2 = this.zLT;
            if (xVar2 == null) {
                p.hyc();
            }
            eom5.rL(xVar2.zNU);
            x xVar3 = this.zLT;
            if (xVar3 == null) {
                p.hyc();
            }
            int i9 = xVar3.zNU ? OpenGlRender.FLAG_Mirror : 0;
            x xVar4 = this.zLT;
            if (xVar4 == null) {
                p.hyc();
            }
            int i10 = p.j(xVar4.zNV, Boolean.TRUE) ? OpenGlRender.FLAG_Angle270 : OpenGlRender.FLAG_Angle90;
            if (ens) {
                com.tencent.mm.plugin.multitalk.b.p pVar = com.tencent.mm.plugin.multitalk.b.p.INSTANCE;
                u a2 = com.tencent.mm.plugin.multitalk.b.p.a(bArr, (int) j2, this.zLU.w, this.zLU.f1508h, (i4 + i5) & 31, this.zLU.zLY);
                if (a2.ret < 0 || this.zLU.zLY == null || a2.zKK == 0 || a2.zKL == 0) {
                    Log.e("MicroMsg.MultiTalkCameraManager", "ilink mv ret: %d", Integer.valueOf(a2.ret));
                    AppMethodBeat.o(239615);
                    return;
                }
                i8 = a2.zKK;
                i7 = a2.zKL;
                t elQ = com.tencent.mm.plugin.multitalk.b.p.INSTANCE.elQ();
                p.g(elQ, "ILinkService.INSTANCE.videoMgr");
                if (!elQ.isStarted()) {
                    AppMethodBeat.o(239615);
                    return;
                } else {
                    j3 = System.currentTimeMillis();
                    b2 = com.tencent.mm.plugin.multitalk.b.p.INSTANCE.g(bArr, i2, i3, i4 + i5);
                }
            } else {
                o eol = ac.eol();
                p.g(eol, "SubCoreMultiTalk.getMultiEngine()");
                com.tencent.pb.talkroom.sdk.g b3 = eol.emG().b(bArr, (int) j2, this.zLU.w, this.zLU.f1508h, (i4 + i5) & 31, this.zLU.zLY);
                if (b3.ret < 0 || this.zLU.zLY == null || b3.zKK == 0 || b3.zKL == 0) {
                    Log.e("MicroMsg.MultiTalkCameraManager", "mv ret: %d", Integer.valueOf(b3.ret));
                    AppMethodBeat.o(239615);
                    return;
                }
                int i11 = b3.zKK;
                int i12 = b3.zKL;
                long currentTimeMillis2 = System.currentTimeMillis();
                int i13 = i9 == OpenGlRender.FLAG_Mirror ? CdnLogic.kAppTypeFestivalImage : 1;
                q eom6 = ac.eom();
                p.g(eom6, "SubCoreMultiTalk.getMultiTalkManager()");
                if (eom6.enO()) {
                    i6 = i9 == OpenGlRender.FLAG_Mirror ? 259 : 3;
                } else {
                    i6 = i13;
                }
                q eom7 = ac.eom();
                p.g(eom7, "SubCoreMultiTalk.getMultiTalkManager()");
                b2 = eom7.enx().b(bArr, j2, i2, i3, i4 + i5, i6);
                j3 = currentTimeMillis2;
                i7 = i12;
                i8 = i11;
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            long j4 = currentTimeMillis3 - currentTimeMillis;
            if (j4 > 30) {
                Log.d("MicroMsg.MultiTalkCameraManager", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", Integer.valueOf(i8), Integer.valueOf(i7), Long.valueOf(j4), Long.valueOf(j3 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - j3));
            }
            if (b2 <= 0) {
                Log.v("MicroMsg.MultiTalkCameraManager", "send ret = %d", Integer.valueOf(b2));
            }
            if (this.zLU.zLY != null) {
                q eom8 = ac.eom();
                p.g(eom8, "SubCoreMultiTalk.getMultiTalkManager()");
                ae enz = eom8.enz();
                String aTY = z.aTY();
                p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
                int[] iArr = this.zLU.zLY;
                if (iArr == null) {
                    p.hyc();
                }
                enz.a(aTY, iArr, i8, i7, i9, i10);
            }
            this.zLS = Util.currentTicks();
            AppMethodBeat.o(239615);
        }
    }

    private final void sz() {
        Boolean bool;
        Boolean bool2 = null;
        AppMethodBeat.i(239616);
        this.zLT = new x();
        x xVar = this.zLT;
        if (xVar != null) {
            q eom = ac.eom();
            p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
            xVar.a(this, eom.enP());
        }
        x xVar2 = this.zLT;
        if (xVar2 != null) {
            xVar2.mSurfaceTexture = this.surfaceTexture;
        }
        x xVar3 = this.zLT;
        if (xVar3 != null) {
            xVar3.eob();
        }
        Object[] objArr = new Object[2];
        x xVar4 = this.zLT;
        if (xVar4 != null) {
            bool = Boolean.valueOf(xVar4.zNU);
        } else {
            bool = null;
        }
        objArr[0] = bool;
        x xVar5 = this.zLT;
        if (xVar5 != null) {
            bool2 = xVar5.zNV;
        }
        objArr[1] = bool2;
        Log.i("MicroMsg.MultiTalkCameraManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", objArr);
        AppMethodBeat.o(239616);
    }

    public final boolean emo() {
        AppMethodBeat.i(239617);
        if (this.zLT == null) {
            AppMethodBeat.o(239617);
            return false;
        } else if (this.zLS == 0 || Util.ticksToNow(this.zLS) <= 1000) {
            AppMethodBeat.o(239617);
            return true;
        } else {
            Log.i("MicroMsg.MultiTalkCameraManager", "current camera is open but has no video ");
            AppMethodBeat.o(239617);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003J]\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0005HÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameObj;", "", "isBusy", "", "w", "", "h", "MediaFmt", "mirror", "angle", "outImg", "", "bmp", "Landroid/graphics/Bitmap;", "(ZIIIII[ILandroid/graphics/Bitmap;)V", "getMediaFmt", "()I", "setMediaFmt", "(I)V", "getAngle", "setAngle", "getBmp", "()Landroid/graphics/Bitmap;", "setBmp", "(Landroid/graphics/Bitmap;)V", "getH", "setH", "()Z", "setBusy", "(Z)V", "getMirror", "setMirror", "getOutImg", "()[I", "setOutImg", "([I)V", "getW", "setW", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-multitalk_release"})
    public static final class b {
        private int angle;

        /* renamed from: h  reason: collision with root package name */
        private int f1507h;
        private boolean hho;
        private int mirror;
        private int w;
        private Bitmap xqp;
        private int zLX;
        private int[] zLY;

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
            if (kotlin.g.b.p.j(r3.xqp, r4.xqp) != false) goto L_0x0046;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 239601(0x3a7f1, float:3.35753E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0046
                boolean r0 = r4 instanceof com.tencent.mm.plugin.multitalk.model.m.b
                if (r0 == 0) goto L_0x004b
                com.tencent.mm.plugin.multitalk.model.m$b r4 = (com.tencent.mm.plugin.multitalk.model.m.b) r4
                boolean r0 = r3.hho
                boolean r1 = r4.hho
                if (r0 != r1) goto L_0x004b
                int r0 = r3.w
                int r1 = r4.w
                if (r0 != r1) goto L_0x004b
                int r0 = r3.f1507h
                int r1 = r4.f1507h
                if (r0 != r1) goto L_0x004b
                int r0 = r3.zLX
                int r1 = r4.zLX
                if (r0 != r1) goto L_0x004b
                int r0 = r3.mirror
                int r1 = r4.mirror
                if (r0 != r1) goto L_0x004b
                int r0 = r3.angle
                int r1 = r4.angle
                if (r0 != r1) goto L_0x004b
                int[] r0 = r3.zLY
                int[] r1 = r4.zLY
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x004b
                android.graphics.Bitmap r0 = r3.xqp
                android.graphics.Bitmap r1 = r4.xqp
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x004b
            L_0x0046:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x004a:
                return r0
            L_0x004b:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x004a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.m.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(239600);
            boolean z = this.hho;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = ((((((((((i3 * 31) + this.w) * 31) + this.f1507h) * 31) + this.zLX) * 31) + this.mirror) * 31) + this.angle) * 31;
            int[] iArr = this.zLY;
            int hashCode = ((iArr != null ? Arrays.hashCode(iArr) : 0) + i6) * 31;
            Bitmap bitmap = this.xqp;
            if (bitmap != null) {
                i2 = bitmap.hashCode();
            }
            int i7 = hashCode + i2;
            AppMethodBeat.o(239600);
            return i7;
        }

        public final String toString() {
            AppMethodBeat.i(239599);
            String str = "FrameObj(isBusy=" + this.hho + ", w=" + this.w + ", h=" + this.f1507h + ", MediaFmt=" + this.zLX + ", mirror=" + this.mirror + ", angle=" + this.angle + ", outImg=" + Arrays.toString(this.zLY) + ", bmp=" + this.xqp + ")";
            AppMethodBeat.o(239599);
            return str;
        }

        private b() {
            this.hho = false;
            this.w = 0;
            this.f1507h = 0;
            this.zLX = 0;
            this.mirror = 0;
            this.angle = 0;
            this.zLY = null;
            this.xqp = null;
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ m zLZ;
        final /* synthetic */ kotlin.g.a.a zMa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(m mVar, kotlin.g.a.a aVar) {
            super(0);
            this.zLZ = mVar;
            this.zMa = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(239602);
            m.a(this.zLZ, this.zMa);
            x xVar = x.SXb;
            AppMethodBeat.o(239602);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ m zLZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(m mVar) {
            super(0);
            this.zLZ = mVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(239606);
            SurfaceTexture surfaceTexture = this.zLZ.surfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
            this.zLZ.surfaceTexture = null;
            com.tencent.mm.media.g.d dVar = this.zLZ.zLQ;
            if (dVar != null) {
                dVar.close();
            }
            c.b bVar = this.zLZ.ilw;
            if (bVar != null) {
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                c.a.a(bVar);
            }
            x xVar = this.zLZ.zLT;
            if (xVar != null) {
                xVar.eoc();
            }
            this.zLZ.zLT = null;
            MMHandler mMHandler = this.zLZ.hDr;
            if (mMHandler != null) {
                mMHandler.quitSafely();
            }
            this.zLZ.hDr = null;
            HandlerThread handlerThread = this.zLZ.hDq;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(239606);
            return xVar2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ m zLZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(m mVar) {
            super(0);
            this.zLZ = mVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(239608);
            m.c(this.zLZ);
            x xVar = x.SXb;
            AppMethodBeat.o(239608);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(m mVar, kotlin.g.a.a aVar) {
        AppMethodBeat.i(239620);
        mVar.ilw = c.a.a(com.tencent.mm.media.k.c.ilt, null, 1, 1, null, 16);
        mVar.zLQ = new com.tencent.mm.media.g.d(false, 19);
        com.tencent.mm.media.g.d dVar = mVar.zLQ;
        if (dVar != null) {
            mVar.surfaceTexture = new SurfaceTexture(dVar.igv);
            SurfaceTexture surfaceTexture2 = mVar.surfaceTexture;
            if (surfaceTexture2 != null) {
                surfaceTexture2.setOnFrameAvailableListener(f.zMc);
            }
            com.tencent.f.h.RTc.aV(new e(mVar, aVar));
        }
        Log.i("MicroMsg.MultiTalkCameraManager", "init create mulititalk camera PboSurfaceRender");
        AppMethodBeat.o(239620);
    }
}
