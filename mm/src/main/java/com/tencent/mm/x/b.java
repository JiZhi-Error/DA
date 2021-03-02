package com.tencent.mm.x;

import android.graphics.Bitmap;
import android.media.ImageReader;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010O\u001a\u00020F2\u0006\u0010P\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\u00142\u0006\u0010R\u001a\u00020\u0014J\u0016\u0010S\u001a\u00020F2\u0006\u0010Q\u001a\u00020\u00142\u0006\u0010R\u001a\u00020\u0014J(\u0010T\u001a\u00020F2\u0006\u0010U\u001a\u00020>2\u0006\u0010Q\u001a\u00020\u00142\u0006\u0010R\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\u0014H\u0002J\u001e\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140X2\b\u0010Y\u001a\u0004\u0018\u00010&H\u0002J*\u0010Z\u001a\u00020F2\u0006\u0010[\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020]2\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020F0EJ\u0006\u0010_\u001a\u00020FJ\u0010\u0010`\u001a\u00020F2\u0006\u0010a\u001a\u00020,H\u0002J\u0016\u0010b\u001a\u00020F2\u0006\u0010c\u001a\u00020,2\u0006\u0010d\u001a\u00020eJ\u0006\u0010f\u001a\u00020FR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001a\u0010%\u001a\u00020&X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R\u001a\u00104\u001a\u000205X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR#\u0010C\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020F0E0D¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006g"}, hxF = {"Lcom/tencent/mm/glrender/FilterRender;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callbackHandler", "Landroid/os/Handler;", "getCallbackHandler", "()Landroid/os/Handler;", "setCallbackHandler", "(Landroid/os/Handler;)V", "callbackThread", "Landroid/os/HandlerThread;", "getCallbackThread", "()Landroid/os/HandlerThread;", "setCallbackThread", "(Landroid/os/HandlerThread;)V", "curHeight", "", "getCurHeight", "()I", "setCurHeight", "(I)V", "curWidth", "getCurWidth", "setCurWidth", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "handlerThread", "getHandlerThread", "setHandlerThread", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "inputBitmap", "Landroid/graphics/Bitmap;", "getInputBitmap", "()Landroid/graphics/Bitmap;", "setInputBitmap", "(Landroid/graphics/Bitmap;)V", "inputTextureId", "getInputTextureId", "setInputTextureId", "mEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getMEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setMEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "outputTextureId", "getOutputTextureId", "setOutputTextureId", "renderOutputBuffer", "Ljava/nio/ByteBuffer;", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "waitingList", "", "Lkotlin/Function1;", "", "getWaitingList", "()Ljava/util/List;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "getXLabEffect", "()Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "setXLabEffect", "(Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;)V", "allocTexutreMem", "texture", "width", "height", "checkInitOutputBuffer", "copyToByteArray", "buffer", "rowPadding", "extractBitmapBuffer", "Lkotlin/Pair;", "reader", "filter", "lutFilePath", "colorWeight", "", "callback", "initGL", "setBitmap", "bitmap", "start", "originBitmap", "context", "Landroid/content/Context;", "stop", "plugin-photoedit-sdk_release"})
public final class b {
    final String TAG = "MicroMsg.FilterRender";
    public Handler callbackHandler;
    MMHandler handler;
    HandlerThread handlerThread;
    public HandlerThread hiB;
    public ImageReader hiC;
    public c.b hiD;
    public Bitmap hiE;
    int hiF;
    int hiG;
    com.tencent.mm.plugin.xlabeffect.b hiH;
    int hiI;
    int hiJ;
    final List<kotlin.g.a.b<Bitmap, x>> hiK = new ArrayList();

    public b() {
        AppMethodBeat.i(163164);
        HandlerThread hC = d.hC("FilterRenderHandlerThread", 5);
        p.g(hC, "SpecialThreadFactory.cre…d\", Thread.NORM_PRIORITY)");
        this.handlerThread = hC;
        this.handlerThread.start();
        this.handler = new MMHandler(this.handlerThread.getLooper());
        AppMethodBeat.o(163164);
    }

    public final HandlerThread axi() {
        AppMethodBeat.i(163161);
        HandlerThread handlerThread2 = this.hiB;
        if (handlerThread2 == null) {
            p.btv("callbackThread");
        }
        AppMethodBeat.o(163161);
        return handlerThread2;
    }

    public final c.b axj() {
        AppMethodBeat.i(163162);
        c.b bVar = this.hiD;
        if (bVar == null) {
            p.btv("mEGLEnvironment");
        }
        AppMethodBeat.o(163162);
        return bVar;
    }

    public final Bitmap axk() {
        AppMethodBeat.i(163163);
        Bitmap bitmap = this.hiE;
        if (bitmap == null) {
            p.btv("inputBitmap");
        }
        AppMethodBeat.o(163163);
        return bitmap;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ b hiL;
        final /* synthetic */ String hiM;
        final /* synthetic */ float hiN;

        a(b bVar, kotlin.g.a.b bVar2, String str, float f2) {
            this.hiL = bVar;
            this.gWe = bVar2;
            this.hiM = str;
            this.hiN = f2;
        }

        public final void run() {
            AppMethodBeat.i(163158);
            synchronized (this.hiL.hiK) {
                try {
                    this.hiL.hiK.add(this.gWe);
                } finally {
                    AppMethodBeat.o(163158);
                }
            }
            c.a aVar = com.tencent.mm.media.k.c.ilt;
            c.a.aMY();
            com.tencent.mm.plugin.xlabeffect.b bVar = this.hiL.hiH;
            if (bVar != null) {
                bVar.m(this.hiM, this.hiN);
                com.tencent.mm.plugin.xlabeffect.b.a(bVar, this.hiL.hiF, this.hiL.hiG, false, 60);
            }
            synchronized (this.hiL.hiK) {
                try {
                    if (this.hiL.hiK.size() > 0) {
                        c.a aVar2 = com.tencent.mm.media.k.c.ilt;
                        this.hiL.hiK.remove(0).invoke(c.a.L(this.hiL.hiG, this.hiL.hiI, this.hiL.hiJ));
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    throw th;
                }
            }
            c.a aVar3 = com.tencent.mm.media.k.c.ilt;
            c.a.a(this.hiL.axj().ilu, this.hiL.axj().eglSurface);
            AppMethodBeat.o(163158);
        }
    }

    public final void initGL() {
        AppMethodBeat.i(204700);
        c.a aVar = com.tencent.mm.media.k.c.ilt;
        ImageReader imageReader = this.hiC;
        if (imageReader == null) {
            p.btv("imageReader");
        }
        this.hiD = c.a.a(aVar, imageReader.getSurface(), 0, 0, null, 16);
        com.tencent.mm.plugin.xlabeffect.b bVar = this.hiH;
        if (bVar != null) {
            bVar.destroy();
        }
        this.hiH = new com.tencent.mm.plugin.xlabeffect.b(this.hiI, this.hiJ, 1);
        com.tencent.mm.plugin.xlabeffect.b bVar2 = this.hiH;
        if (bVar2 != null) {
            bVar2.zG(false);
        }
        c.a aVar2 = com.tencent.mm.media.k.c.ilt;
        this.hiF = c.a.aMZ();
        c.a aVar3 = com.tencent.mm.media.k.c.ilt;
        this.hiG = c.a.aMZ();
        c.a aVar4 = com.tencent.mm.media.k.c.ilt;
        Bitmap bitmap = this.hiE;
        if (bitmap == null) {
            p.btv("inputBitmap");
        }
        c.a.c(bitmap, this.hiF);
        int i2 = this.hiG;
        int i3 = this.hiI;
        int i4 = this.hiJ;
        GLES20.glBindTexture(3553, i2);
        GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, i3, i4, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.o(204700);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.x.b$b  reason: collision with other inner class name */
    public static final class RunnableC2174b implements Runnable {
        final /* synthetic */ b hiL;

        RunnableC2174b(b bVar) {
            this.hiL = bVar;
        }

        public final void run() {
            AppMethodBeat.i(163159);
            Log.i(this.hiL.TAG, "initGL");
            b bVar = this.hiL;
            HandlerThread hz = d.hz("FilterRenderCallbackHandlerThread", 5);
            p.g(hz, "SpecialThreadFactory.cre…d\", Thread.NORM_PRIORITY)");
            p.h(hz, "<set-?>");
            bVar.hiB = hz;
            this.hiL.axi().start();
            b bVar2 = this.hiL;
            Handler handler = new Handler(this.hiL.axi().getLooper());
            p.h(handler, "<set-?>");
            bVar2.callbackHandler = handler;
            b bVar3 = this.hiL;
            ImageReader newInstance = ImageReader.newInstance(this.hiL.hiI, this.hiL.hiJ, 1, 3);
            p.g(newInstance, "ImageReader.newInstance(…PixelFormat.RGBA_8888, 3)");
            p.h(newInstance, "<set-?>");
            bVar3.hiC = newInstance;
            ImageReader imageReader = this.hiL.hiC;
            if (imageReader == null) {
                p.btv("imageReader");
            }
            AnonymousClass1 r0 = new ImageReader.OnImageAvailableListener() {
                /* class com.tencent.mm.x.b.RunnableC2174b.AnonymousClass1 */

                public final void onImageAvailable(ImageReader imageReader) {
                }
            };
            Handler handler2 = this.hiL.callbackHandler;
            if (handler2 == null) {
                p.btv("callbackHandler");
            }
            imageReader.setOnImageAvailableListener(r0, handler2);
            this.hiL.initGL();
            AppMethodBeat.o(163159);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ b hiL;

        c(b bVar) {
            this.hiL = bVar;
        }

        public final void run() {
            AppMethodBeat.i(163160);
            c.a aVar = com.tencent.mm.media.k.c.ilt;
            c.a.a(this.hiL.axj());
            this.hiL.handlerThread.quit();
            this.hiL.axi().quit();
            com.tencent.mm.plugin.xlabeffect.b bVar = this.hiL.hiH;
            if (bVar != null) {
                bVar.destroy();
            }
            this.hiL.hiH = null;
            AppMethodBeat.o(163160);
        }
    }
}
