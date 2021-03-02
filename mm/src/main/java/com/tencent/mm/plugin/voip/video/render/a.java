package com.tencent.mm.plugin.voip.video.render;

import android.media.Image;
import android.media.ImageReader;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.opengl.GLES30;
import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.g;
import com.tencent.mm.media.j.b.i;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 C2\u00020\u0001:\u0002CDB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0005H\u0002J0\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u0002042\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0005H\u0002J\u0016\u00106\u001a\u00020\u000b2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b08H\u0002J\u0006\u00109\u001a\u00020\u000bJ\u0006\u0010:\u001a\u00020\u000bJ4\u0010;\u001a\u00020\u000b2,\u0010\t\u001a(\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0004\u0018\u0001`\fJ\u000e\u0010<\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u0005J\b\u0010?\u001a\u00020\u000bH\u0002J\u001e\u0010@\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u0005J\u0016\u0010B\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005R6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\bX\u0004¢\u0006\u0002\n\u0000R4\u0010\t\u001a(\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0004\u0018\u0001`\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n \u0016*\u0004\u0018\u00010#0#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\"\u0004\b(\u0010\u001aR\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "", "()V", "callbackBufferMap", "Ljava/util/HashMap;", "", "Ljava/util/concurrent/LinkedBlockingQueue;", "Ljava/nio/ByteBuffer;", "Lkotlin/collections/HashMap;", "dataCallback", "Lkotlin/Function4;", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "encHeight", "encType", "encWidth", "handler", "Landroid/os/Handler;", "handlerT", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "value", "height", "setHeight", "(I)V", "imgReader", "Landroid/media/ImageReader;", "outWH", "Lkotlin/Pair;", "renderInfoQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$RenderInfo;", "sharedContext", "Landroid/opengl/EGLContext;", "texture", "useGpuCrop", "", "width", "setWidth", "yuvCropEncodeProg", "Lcom/tencent/mm/media/render/proc/RGB2YUVCropRenderProc;", "yuvEncodeProg", "Lcom/tencent/mm/media/render/proc/RGB2YUVRenderProc;", "yuvHeight", "yuvWidth", "cacheCallbackBuffer", "size", "cpBuffer", "buffer", "byteArray", "", "padding", "post", "task", "Lkotlin/Function0;", "release", "requestRender", "setDataCallBack", "setInputTexture", "setRotate", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "setUpImageReader", "updateEncodeResType", "encoderType", "updateSize", "Companion", "RenderInfo", "plugin-voip_release"})
public final class a {
    public static final C1894a HmW = new C1894a((byte) 0);
    public int Gxi;
    private final boolean HdC;
    private final HandlerThread HmM = com.tencent.f.c.d.hz("voip_rgb2yuv_thread", -4);
    private ImageReader HmN;
    public r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> HmO;
    private i HmP;
    private g HmQ;
    private final ConcurrentLinkedQueue<b> HmR;
    private final HashMap<Integer, LinkedBlockingQueue<ByteBuffer>> HmS;
    private o<Integer, Integer> HmT;
    private int HmU;
    private int HmV;
    private c.b hDs;
    private final Handler handler;
    private int height;
    private int ifN;
    private int ifO;
    private int kOM;
    private final EGLContext sharedContext;
    private int width;

    static {
        AppMethodBeat.i(236197);
        AppMethodBeat.o(236197);
    }

    public a() {
        AppMethodBeat.i(236196);
        com.tencent.mm.plugin.voip.b.g gVar = com.tencent.mm.plugin.voip.b.g.HgZ;
        this.HdC = com.tencent.mm.plugin.voip.b.g.fKj();
        this.sharedContext = EGL14.eglGetCurrentContext();
        this.HmR = new ConcurrentLinkedQueue<>();
        this.HmS = new HashMap<>();
        this.HmT = new o<>(0, 0);
        this.Gxi = -1;
        if (this.HdC) {
            this.HmQ = new g(1, 15);
        } else {
            this.HmP = new i(1, 15);
        }
        this.HmM.start();
        HandlerThread handlerThread = this.HmM;
        p.g(handlerThread, "handlerT");
        this.handler = new Handler(handlerThread.getLooper());
        AppMethodBeat.o(236196);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$Companion;", "", "()V", "CallbackBufferMaxCacheSize", "", "TAG", "", "plugin-voip_release"})
    /* renamed from: com.tencent.mm.plugin.voip.video.render.a$a  reason: collision with other inner class name */
    public static final class C1894a {
        private C1894a() {
        }

        public /* synthetic */ C1894a(byte b2) {
            this();
        }
    }

    private final void setWidth(int i2) {
        this.width = i2;
        this.ifO = (this.width * 3) / 2;
    }

    private final void setHeight(int i2) {
        this.height = i2;
        this.ifN = this.height / 4;
    }

    private final void U(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(236191);
        this.handler.post(new b(aVar));
        AppMethodBeat.o(236191);
    }

    private final void fLP() {
        AppMethodBeat.i(236192);
        U(new d(this));
        AppMethodBeat.o(236192);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a Hna;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar) {
            super(0);
            this.Hna = aVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable", "com/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$setUpImageReader$1$2$1"})
        /* renamed from: com.tencent.mm.plugin.voip.video.render.a$d$a  reason: collision with other inner class name */
        static final class C1895a implements ImageReader.OnImageAvailableListener {
            final /* synthetic */ d Hnb;

            C1895a(d dVar) {
                this.Hnb = dVar;
            }

            public final void onImageAvailable(ImageReader imageReader) {
                int i2;
                Integer num;
                LinkedBlockingQueue linkedBlockingQueue;
                AppMethodBeat.i(236189);
                Image acquireLatestImage = imageReader.acquireLatestImage();
                if (acquireLatestImage != null) {
                    try {
                        Image.Plane plane = acquireLatestImage.getPlanes()[0];
                        ConcurrentLinkedQueue unused = this.Hnb.Hna.HmR;
                        b bVar = (b) this.Hnb.Hna.HmR.remove();
                        while (acquireLatestImage.getTimestamp() > bVar.HmZ) {
                            Log.i("EncoderSurfaceRender", "drop render info pts: " + acquireLatestImage.getTimestamp());
                            bVar = (b) this.Hnb.Hna.HmR.remove();
                        }
                        Log.i("EncoderSurfaceRender", "get render info pts: " + acquireLatestImage.getTimestamp());
                        int i3 = ((bVar.HmX * bVar.HmY) * 3) / 2;
                        a.a(this.Hnb.Hna, i3);
                        LinkedBlockingQueue linkedBlockingQueue2 = (LinkedBlockingQueue) this.Hnb.Hna.HmS.get(Integer.valueOf(i3));
                        ByteBuffer byteBuffer = linkedBlockingQueue2 != null ? (ByteBuffer) linkedBlockingQueue2.remove() : null;
                        this.Hnb.Hna.HmT = new o(Integer.valueOf(bVar.HmX), Integer.valueOf(bVar.HmY));
                        if (byteBuffer != null) {
                            p.g(plane, "plan");
                            SightVideoJNI.nativeBufferCopy(plane.getBuffer(), byteBuffer, bVar.HmY, (bVar.HmX * 3) / 2, plane.getRowStride() - bVar.HmY);
                            r rVar = this.Hnb.Hna.HmO;
                            if (rVar != null) {
                                rVar.invoke(byteBuffer, Integer.valueOf(bVar.HmY), Integer.valueOf(bVar.HmX), Integer.valueOf(bVar.dataType));
                            }
                            i iVar = i.HnR;
                            i.aO(4, Util.ticksToNow(acquireLatestImage.getTimestamp()));
                            LinkedBlockingQueue linkedBlockingQueue3 = (LinkedBlockingQueue) this.Hnb.Hna.HmS.get(Integer.valueOf(i3));
                            if (linkedBlockingQueue3 != null) {
                                i2 = linkedBlockingQueue3.size();
                            } else {
                                i2 = 0;
                            }
                            if (i2 < 2 && (linkedBlockingQueue = (LinkedBlockingQueue) this.Hnb.Hna.HmS.get(Integer.valueOf(i3))) != null) {
                                linkedBlockingQueue.add(byteBuffer);
                            }
                            StringBuilder sb = new StringBuilder("callback buffer, queue size:");
                            LinkedBlockingQueue linkedBlockingQueue4 = (LinkedBlockingQueue) this.Hnb.Hna.HmS.get(Integer.valueOf(i3));
                            if (linkedBlockingQueue4 != null) {
                                num = Integer.valueOf(linkedBlockingQueue4.size());
                            } else {
                                num = null;
                            }
                            Log.d("EncoderSurfaceRender", sb.append(num).toString());
                            x xVar = x.SXb;
                        }
                    } catch (NoSuchElementException e2) {
                        Log.e("EncoderSurfaceRender", e2.getMessage());
                        x xVar2 = x.SXb;
                    } catch (IllegalStateException e3) {
                        Log.e("EncoderSurfaceRender", e3.getMessage());
                        x xVar3 = x.SXb;
                    } finally {
                        acquireLatestImage.close();
                        AppMethodBeat.o(236189);
                    }
                } else {
                    AppMethodBeat.o(236189);
                }
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            a aVar;
            ImageReader imageReader = null;
            AppMethodBeat.i(236190);
            c.b bVar = this.Hna.hDs;
            if (bVar != null) {
                c.a aVar2 = com.tencent.mm.media.k.c.ilt;
                c.a.a(bVar);
            }
            this.Hna.hDs = null;
            ImageReader imageReader2 = this.Hna.HmN;
            if (imageReader2 != null) {
                imageReader2.close();
            }
            a aVar3 = this.Hna;
            ImageReader newInstance = ImageReader.newInstance(this.Hna.ifN, this.Hna.ifO, 1, 1);
            if (newInstance != null) {
                newInstance.setOnImageAvailableListener(new C1895a(this), this.Hna.handler);
                this.Hna.hDs = c.a.a(com.tencent.mm.media.k.c.ilt, newInstance.getSurface(), 0, 0, this.Hna.sharedContext, 14);
                imageReader = newInstance;
                aVar = aVar3;
            } else {
                aVar = aVar3;
            }
            aVar.HmN = imageReader;
            x xVar = x.SXb;
            AppMethodBeat.o(236190);
            return xVar;
        }
    }

    public final void jj(int i2, int i3) {
        AppMethodBeat.i(236193);
        if (this.width == i2 && this.height == i3) {
            AppMethodBeat.o(236193);
            return;
        }
        setWidth(i2);
        setHeight(i3);
        fLP();
        AppMethodBeat.o(236193);
    }

    public final void aF(int i2, int i3, int i4) {
        if (this.HdC) {
            this.HmU = i2;
            this.HmV = i3;
            this.kOM = i4;
        }
    }

    public final void requestRender() {
        AppMethodBeat.i(236194);
        U(new c(this));
        AppMethodBeat.o(236194);
    }

    public final void release() {
        AppMethodBeat.i(236195);
        c.b bVar = this.hDs;
        if (bVar != null) {
            c.a aVar = com.tencent.mm.media.k.c.ilt;
            c.a.a(bVar);
        }
        ImageReader imageReader = this.HmN;
        if (imageReader != null) {
            imageReader.close();
        }
        this.HmR.clear();
        this.hDs = null;
        this.HmM.quitSafely();
        i iVar = this.HmP;
        if (iVar != null) {
            iVar.release();
        }
        g gVar = this.HmQ;
        if (gVar != null) {
            gVar.release();
        }
        this.HmN = null;
        this.HmS.clear();
        this.HmO = null;
        AppMethodBeat.o(236195);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$RenderInfo;", "", "outW", "", "outH", "dataType", "presentationTime", "", "(IIIJ)V", "getDataType", "()I", "getOutH", "getOutW", "getPresentationTime", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-voip_release"})
    public static final class b {
        final int HmX;
        final int HmY;
        final long HmZ;
        final int dataType;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (!(this.HmX == bVar.HmX && this.HmY == bVar.HmY && this.dataType == bVar.dataType && this.HmZ == bVar.HmZ)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            long j2 = this.HmZ;
            return (((((this.HmX * 31) + this.HmY) * 31) + this.dataType) * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }

        public final String toString() {
            AppMethodBeat.i(236186);
            String str = "RenderInfo(outW=" + this.HmX + ", outH=" + this.HmY + ", dataType=" + this.dataType + ", presentationTime=" + this.HmZ + ")";
            AppMethodBeat.o(236186);
            return str;
        }

        public b(int i2, int i3, int i4, long j2) {
            this.HmX = i2;
            this.HmY = i3;
            this.dataType = i4;
            this.HmZ = j2;
        }
    }

    public static final /* synthetic */ void a(a aVar, int i2) {
        LinkedBlockingQueue<ByteBuffer> linkedBlockingQueue;
        AppMethodBeat.i(236198);
        LinkedBlockingQueue<ByteBuffer> linkedBlockingQueue2 = aVar.HmS.get(Integer.valueOf(i2));
        if ((linkedBlockingQueue2 != null ? linkedBlockingQueue2.size() : 0) <= 2) {
            LinkedBlockingQueue<ByteBuffer> linkedBlockingQueue3 = aVar.HmS.get(Integer.valueOf(i2));
            if (linkedBlockingQueue3 == null) {
                linkedBlockingQueue = new LinkedBlockingQueue<>();
            } else {
                linkedBlockingQueue = linkedBlockingQueue3;
            }
            p.g(linkedBlockingQueue, "callbackBufferMap[size] ?: LinkedBlockingQueue()");
            int size = 2 - linkedBlockingQueue.size();
            for (int i3 = 0; i3 < size; i3++) {
                linkedBlockingQueue.add(ByteBuffer.allocateDirect(i2));
            }
            aVar.HmS.put(Integer.valueOf(i2), linkedBlockingQueue);
        }
        AppMethodBeat.o(236198);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a Hna;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(0);
            this.Hna = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z;
            int i2 = 1;
            AppMethodBeat.i(236187);
            c.b bVar = this.Hna.hDs;
            if (bVar != null) {
                int i3 = this.Hna.kOM;
                int i4 = i3 != 0 ? this.Hna.HmU : this.Hna.height;
                int i5 = i3 != 0 ? this.Hna.HmV : this.Hna.width;
                if (!this.Hna.HdC) {
                    i iVar = this.Hna.HmP;
                    if (iVar != null) {
                        iVar.ikZ = this.Hna.Gxi;
                        iVar.cZ(this.Hna.width, this.Hna.height);
                        iVar.cY(this.Hna.height, this.Hna.width);
                        iVar.aED();
                    }
                } else if (i4 <= this.Hna.height || i5 <= this.Hna.width) {
                    g gVar = this.Hna.HmQ;
                    if (gVar != null) {
                        gVar.ikZ = this.Hna.Gxi;
                        gVar.cZ(this.Hna.width, this.Hna.height);
                        gVar.cY(i5, i4);
                        int i6 = this.Hna.ifN;
                        int i7 = this.Hna.ifO;
                        gVar.surfaceWidth = i6;
                        gVar.surfaceHeight = i7;
                        if (i3 == 2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (gVar.ilf != z) {
                            gVar.ilf = z;
                            if (z) {
                                gVar.ikT = GLES30.glGetUniformLocation(gVar.ikR, "xoffset");
                                gVar.ikV = GLES30.glGetUniformLocation(gVar.ikR, "useY");
                                gVar.ikW = GLES30.glGetUniformLocation(gVar.ikR, "flipX");
                                gVar.ikX = GLES30.glGetUniformLocation(gVar.ikR, "flipY");
                                gVar.hEA = GLES30.glGetUniformLocation(gVar.ikR, "inTexture");
                                gVar.ikY = GLES30.glGetUniformLocation(gVar.ikR, "texLeft");
                            } else {
                                gVar.ikT = GLES30.glGetUniformLocation(gVar.ikS, "xoffset");
                                gVar.ikU = GLES30.glGetUniformLocation(gVar.ikS, "yoffset");
                                gVar.ikV = GLES30.glGetUniformLocation(gVar.ikS, "useY");
                                gVar.ikW = GLES30.glGetUniformLocation(gVar.ikS, "flipX");
                                gVar.ikX = GLES30.glGetUniformLocation(gVar.ikS, "flipY");
                                gVar.hEA = GLES30.glGetUniformLocation(gVar.ikS, "inTexture");
                                gVar.ikY = GLES30.glGetUniformLocation(gVar.ikR, "texLeft");
                            }
                        }
                        gVar.aED();
                    }
                }
                long currentTicks = Util.currentTicks();
                ConcurrentLinkedQueue concurrentLinkedQueue = this.Hna.HmR;
                switch (i3) {
                    case 1:
                        i2 = 2;
                        break;
                    case 2:
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                concurrentLinkedQueue.add(new b(i5, i4, i2, currentTicks));
                Log.i("EncoderSurfaceRender", "enqueue render info pts: ".concat(String.valueOf(currentTicks)));
                EGLExt.eglPresentationTimeANDROID(bVar.ilu, bVar.eglSurface, currentTicks);
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                c.a.a(bVar.ilu, bVar.eglSurface);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236187);
            return xVar;
        }
    }
}
