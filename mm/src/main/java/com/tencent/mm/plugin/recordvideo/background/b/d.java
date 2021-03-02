package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.Bitmap;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaCodec;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.media.d.f;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.background.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.coremedia.TimeUtil;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0001\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u00120\b\u0002\u0010\u0013\u001a*\u0012\u0004\u0012\u00020\u0000\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0014¢\u0006\u0002\b\u0019¢\u0006\u0002\u0010\u001aJ\u0006\u0010T\u001a\u00020\u0018J\b\u0010U\u001a\u00020\u0018H\u0016J\u0006\u0010V\u001a\u00020\u0018J\u0010\u0010W\u001a\u00020\u00182\u0006\u0010X\u001a\u00020\u0011H\u0016J\u001e\u0010Y\u001a\u00020\u00182\u0016\u0010Z\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001cJ\b\u0010[\u001a\u00020\u0018H\u0016R*\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R0\u0010'\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010(\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u001a\u0010.\u001a\u00020/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R9\u0010\u0013\u001a*\u0012\u0004\u0012\u00020\u0000\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0014¢\u0006\u0002\b\u0019¢\u0006\b\n\u0000\u001a\u0004\b@\u0010*R\u001a\u0010A\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0011\u0010F\u001a\u00020G¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010C\"\u0004\bR\u0010ER\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u00105¨\u0006]"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "surface", "Landroid/view/Surface;", "width", "", "height", "enableOutputBuffer", "", "outputFps", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "succ", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/ArrayList;JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IIZILkotlin/jvm/functions/Function2;)V", "blendProvider", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getBlendProvider", "()Lkotlin/jvm/functions/Function1;", "setBlendProvider", "(Lkotlin/jvm/functions/Function1;)V", "decodeFinish", "getDecodeFinish", "()Z", "setDecodeFinish", "(Z)V", "drawCallback", "Ljava/nio/Buffer;", "getDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "getEnableOutputBuffer", "glThread", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "getGlThread", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "setGlThread", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;)V", "getHeight", "()I", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "getInit", "pts", "getPts", "()J", "setPts", "(J)V", "render", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "getRender", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "renderOutputBuffer", "Ljava/nio/ByteBuffer;", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "stepTime", "getStepTime", "setStepTime", "getWidth", "checkInitRenderOutputBuffer", "releaseDecoder", "requestRender", "setPauseDecoder", "pause", "setVideoBlendBitmapProvider", "blendBitmapProvider", "startDecode", "Companion", "plugin-recordvideo_release"})
public final class d extends f {
    public static final a BLB = new a((byte) 0);
    private static final String TAG = TAG;
    final m<d, Boolean, x> BLA;
    final h BLs = new h();
    c BLt;
    long BLu;
    boolean BLv;
    kotlin.g.a.b<? super Long, Bitmap> BLw;
    m<? super Boolean, ? super Buffer, x> BLx;
    ArrayList<String> BLy;
    final boolean BLz;
    private final int height;
    private ImageReader hiC;
    ByteBuffer ijF;
    long pts;
    private final int width;

    /* JADX DEBUG: Multi-variable search result rejected for r21v0, resolved type: kotlin.g.a.m<? super com.tencent.mm.plugin.recordvideo.background.b.d, ? super java.lang.Boolean, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(ArrayList<String> arrayList, long j2, long j3, Surface surface, int i2, int i3, boolean z, int i4, m<? super d, ? super Boolean, x> mVar) {
        super(j2, j3, surface, i4);
        p.h(arrayList, "imageList");
        AppMethodBeat.i(75275);
        this.BLy = arrayList;
        this.width = i2;
        this.height = i3;
        this.BLz = z;
        this.BLA = mVar;
        e eVar = e.BNm;
        this.BLu = 1000 / ((long) e.getFrameRate());
        this.BLs.BMh = this.BLu;
        if (this.ieD == null && this.BLz) {
            this.hiC = ImageReader.newInstance(this.width, this.height, 1, 3);
            ImageReader imageReader = this.hiC;
            if (imageReader == null) {
                p.hyc();
            }
            imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener(this) {
                /* class com.tencent.mm.plugin.recordvideo.background.b.d.AnonymousClass1 */
                final /* synthetic */ d BLC;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.BLC = r1;
                }

                public final void onImageAvailable(ImageReader imageReader) {
                    AppMethodBeat.i(75266);
                    if (imageReader == null) {
                        p.hyc();
                    }
                    Image acquireNextImage = imageReader.acquireNextImage();
                    p.g(acquireNextImage, "image");
                    Image.Plane[] planes = acquireNextImage.getPlanes();
                    int width = acquireNextImage.getWidth();
                    int height = acquireNextImage.getHeight();
                    Image.Plane plane = planes[0];
                    p.g(plane, "planes[0]");
                    int rowStride = plane.getRowStride();
                    Image.Plane plane2 = planes[0];
                    p.g(plane2, "planes[0]");
                    int pixelStride = rowStride - (plane2.getPixelStride() * width);
                    Image.Plane plane3 = planes[0];
                    p.g(plane3, "planes[0]");
                    ByteBuffer buffer = plane3.getBuffer();
                    p.g(buffer, "planes[0].buffer");
                    long currentTicks = Util.currentTicks();
                    this.BLC.aMQ();
                    ByteBuffer byteBuffer = this.BLC.ijF;
                    if (byteBuffer == null) {
                        p.hyc();
                    }
                    byteBuffer.clear();
                    ByteBuffer byteBuffer2 = this.BLC.ijF;
                    if (byteBuffer2 == null) {
                        p.hyc();
                    }
                    byteBuffer2.order(buffer.order());
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < height) {
                        buffer.limit((i2 * pixelStride) + i3 + (width * 4));
                        buffer.position((i2 * pixelStride) + i3);
                        ByteBuffer byteBuffer3 = this.BLC.ijF;
                        if (byteBuffer3 == null) {
                            p.hyc();
                        }
                        byteBuffer3.put(buffer);
                        i2++;
                        i3 = (width * 4) + i3;
                    }
                    a aVar = d.BLB;
                    Log.i(d.TAG, "copyToByteArray cost: " + Util.ticksToNow(currentTicks));
                    acquireNextImage.close();
                    m<? super Boolean, ? super Buffer, x> mVar = this.BLC.BLx;
                    if (mVar != null) {
                        mVar.invoke(Boolean.TRUE, this.BLC.ijF);
                        AppMethodBeat.o(75266);
                        return;
                    }
                    AppMethodBeat.o(75266);
                }
            }, null);
            ImageReader imageReader2 = this.hiC;
            if (imageReader2 == null) {
                p.hyc();
            }
            this.ieD = imageReader2.getSurface();
        }
        this.BLt = new c(this.ieD, this.BLs);
        this.BLt.dL(this.width, this.height);
        if (this.BLz) {
            Log.i(TAG, "init useX264Encoder width:%s, height:%s", Integer.valueOf(this.width), Integer.valueOf(this.height));
            aMQ();
            this.BLt.BLq = true;
        }
        this.BLt.start();
        this.BLt.ax(new Runnable(this) {
            /* class com.tencent.mm.plugin.recordvideo.background.b.d.AnonymousClass2 */
            final /* synthetic */ d BLC;

            {
                this.BLC = r1;
            }

            public final void run() {
                AppMethodBeat.i(75267);
                m<d, Boolean, x> mVar = this.BLC.BLA;
                if (mVar != null) {
                    mVar.invoke(this.BLC, Boolean.TRUE);
                    AppMethodBeat.o(75267);
                    return;
                }
                AppMethodBeat.o(75267);
            }
        });
        AppMethodBeat.o(75275);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(75276);
        AppMethodBeat.o(75276);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ d BLC;

        c(d dVar) {
            this.BLC = dVar;
        }

        public final void run() {
            AppMethodBeat.i(75269);
            this.BLC.BLs.ge(this.BLC.BLy);
            AppMethodBeat.o(75269);
        }
    }

    @Override // com.tencent.mm.media.d.f
    public final void startDecode() {
        AppMethodBeat.i(75270);
        this.BLt.ax(new c(this));
        requestRender();
        AppMethodBeat.o(75270);
    }

    private void requestRender() {
        AppMethodBeat.i(75271);
        Log.i(TAG, "requestRender");
        if (this.BLv) {
            AppMethodBeat.o(75271);
            return;
        }
        this.BLt.ax(new b(this));
        AppMethodBeat.o(75271);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ d BLC;

        b(d dVar) {
            this.BLC = dVar;
        }

        public final void run() {
            m<? super Boolean, ? super Buffer, x> mVar;
            AppMethodBeat.i(75268);
            this.BLC.pts += this.BLC.BLu;
            this.BLC.BLs.onDrawFrame();
            kotlin.g.a.b<? super Long, Bitmap> bVar = this.BLC.BLw;
            Bitmap invoke = bVar != null ? bVar.invoke(Long.valueOf(this.BLC.pts * 1000)) : null;
            if (invoke != null) {
                h hVar = this.BLC.BLs;
                p.h(invoke, "bitmap");
                hVar.BMj.eJh();
                hVar.BMj.a(a.EnumC1641a.CenterInside, hVar.mWidth, hVar.mHeight, invoke.getWidth(), invoke.getHeight());
                GLES20.glActiveTexture(33984);
                hVar.BMl = f.i(invoke, hVar.BMl);
                hVar.BMj.Vz(hVar.BMl);
                float[] fArr = hVar.BMj.BLK;
                if (hVar.BMk) {
                    Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
                }
                hVar.BMj.m(fArr);
                f.eJj();
            }
            this.BLC.BLt.setPresentationTime(this.BLC.pts * TimeUtil.SECOND_TO_US);
            this.BLC.BLt.eJk();
            r rVar = this.BLC.ieo;
            if (rVar != null) {
                rVar.invoke(null, Long.valueOf(this.BLC.pts * 1000), new MediaCodec.BufferInfo(), Boolean.FALSE);
            }
            if (!this.BLC.BLz && (mVar = this.BLC.BLx) != null) {
                mVar.invoke(Boolean.TRUE, this.BLC.ijF);
            }
            long j2 = this.BLC.pts;
            e eVar = e.BNm;
            if (j2 >= ((long) e.eJs())) {
                this.BLC.BLv = true;
                kotlin.g.a.a aVar = this.BLC.iep;
                if (aVar != null) {
                    aVar.invoke();
                    AppMethodBeat.o(75268);
                    return;
                }
            }
            AppMethodBeat.o(75268);
        }
    }

    public final void aMQ() {
        AppMethodBeat.i(75272);
        if (this.width > 0 && this.height > 0 && this.ijF == null) {
            this.ijF = ByteBuffer.allocateDirect(this.width * this.height * 4);
        }
        AppMethodBeat.o(75272);
    }

    @Override // com.tencent.mm.media.d.f
    public final void eU(boolean z) {
        AppMethodBeat.i(75273);
        Log.d(TAG, "setPauseDecoder ".concat(String.valueOf(z)));
        this.dLD = z;
        if (!z) {
            requestRender();
        }
        AppMethodBeat.o(75273);
    }

    @Override // com.tencent.mm.media.d.f
    public final void releaseDecoder() {
        AppMethodBeat.i(75274);
        super.releaseDecoder();
        this.BLt.stop();
        AppMethodBeat.o(75274);
    }
}
