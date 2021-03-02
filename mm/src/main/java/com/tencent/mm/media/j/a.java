package com.tencent.mm.media.j;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 s2\u00020\u0001:\u0001sBA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0006\u0010J\u001a\u00020\u000bJ\u0006\u0010\n\u001a\u00020\u001dJ\b\u0010\u0010\u001a\u00020\u001dH\u0002J\b\u0010K\u001a\u00020#H$J\u000e\u0010L\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020\u000bJ\n\u0010M\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010N\u001a\u0004\u0018\u00010OJ\n\u0010P\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010Q\u001a\u00020\u0003H\u0016J\b\u0010R\u001a\u00020\u0003H\u0016J\n\u0010S\u001a\u0004\u0018\u000100H\u0016J\b\u0010T\u001a\u00020\u001dH\u0002J\u0012\u0010U\u001a\u00020\u001d2\b\b\u0002\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010V\u001a\u00020\u001d2\u0006\u0010W\u001a\u00020\u00122\b\b\u0002\u0010X\u001a\u00020\u000bJ\u000e\u0010V\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020\u0003J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u000bH\u0016J\u0012\u0010Z\u001a\u00020\u001d2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\"\u0010]\u001a\u00020\u001d2\b\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010^\u001a\u00020\u00032\u0006\u0010_\u001a\u00020\u0003H\u0016J\u001c\u0010`\u001a\u00020\u001d2\b\u0010[\u001a\u0004\u0018\u00010\\2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0012\u0010c\u001a\u00020\u001d2\b\b\u0002\u0010d\u001a\u00020\u000bH\u0016J\b\u0010e\u001a\u00020\u001dH\u0016J\b\u0010f\u001a\u00020\u001dH\u0002J+\u0010g\u001a\u00020\u001d2#\u0010h\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(Y\u0012\u0004\u0012\u00020\u001d0/J+\u0010i\u001a\u00020\u001d2!\u0010h\u001a\u001d\u0012\u0013\u0012\u00110O¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(j\u0012\u0004\u0012\u00020\u001d0/H\u0016J\u0010\u0010k\u001a\u00020\u001d2\u0006\u0010l\u001a\u00020\u0003H\u0016J\b\u0010m\u001a\u00020\u001dH\u0016J\u0018\u0010n\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u00032\u0006\u0010_\u001a\u00020\u0003H\u0016J\u0018\u0010o\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u00032\u0006\u0010_\u001a\u00020\u0003H\u0016J\u000e\u0010p\u001a\u00020\u001d2\u0006\u0010q\u001a\u00020rR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001a\u0010+\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR7\u0010.\u001a\u001f\u0012\u0013\u0012\u001100¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u001d\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016R\u001a\u0010:\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\r\"\u0004\b<\u0010\u000fR\u001a\u0010=\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0014\"\u0004\b?\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0014\"\u0004\bA\u0010\u0016R\u001c\u00103\u001a\u0004\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0014\"\u0004\bG\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0014\"\u0004\bI\u0010\u0016¨\u0006t"}, hxF = {"Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "clearFrame", "", "getClearFrame", "()Z", "setClearFrame", "(Z)V", "createSurfaceTexture", "currentDrawFrame", "", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "externalTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "frameDrawCallback", "Lkotlin/Function0;", "", "getFrameDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "glTextureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getGlTextureRenderProc", "()Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setGlTextureRenderProc", "(Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;)V", "inputTexture", "getInputTexture", "setInputTexture", "mirror", "getMirror", "setMirror", "onFrameAvailableListener", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surfaceTexture", "getOnFrameAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "getRenderOutputType", "setRenderOutputType", "renderProcInited", "getRenderProcInited", "setRenderProcInited", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "setScaleType", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "checkHasInit", "doInitRenderProc", "flip", "getExternalTexture", "getOutputBuffer", "Ljava/nio/IntBuffer;", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getTexture", "initGLTextureRender", "initRenderProcInGlesThread", "input", "frame", "copyFrame", "texture", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "resetRender", "setOnFBOAvailableListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnRGBDataAvailableListener", "buffer", "setRotate", "degree", "takePhoto", "updateDrawViewSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "format", "Landroid/media/MediaFormat;", "Companion", "plugin-mediaeditor_release"})
public abstract class a implements GLSurfaceView.Renderer {
    public static final C0421a ijz = new C0421a((byte) 0);
    private int hDl;
    public int hDn;
    public int hDo;
    public int hEp;
    public int hEq;
    public com.tencent.mm.media.j.b.a ijo;
    private byte[] ijp;
    public d ijq;
    public boolean ijr;
    private boolean ijs;
    public int ijt;
    public boolean iju;
    public b<? super SurfaceTexture, x> ijv;
    public kotlin.g.a.a<x> ijw;
    public boolean ijx;
    protected int ijy;
    protected int scaleType;
    SurfaceTexture surfaceTexture;

    public a() {
        this(0, 0, 0, 0, 63);
    }

    /* access modifiers changed from: protected */
    public abstract com.tencent.mm.media.j.b.a aEC();

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(int r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            r6 = 1
            r2 = 0
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0021
            r1 = r2
        L_0x0007:
            r0 = r12 & 4
            if (r0 == 0) goto L_0x001f
            r3 = r1
        L_0x000c:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x001d
            r5 = r6
        L_0x0011:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x001b
        L_0x0015:
            r0 = r7
            r4 = r2
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        L_0x001b:
            r6 = r11
            goto L_0x0015
        L_0x001d:
            r5 = r10
            goto L_0x0011
        L_0x001f:
            r3 = r9
            goto L_0x000c
        L_0x0021:
            r1 = r8
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.j.a.<init>(int, int, int, int, int):void");
    }

    public a(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.hDn = i2;
        this.hDo = i3;
        this.hEp = i4;
        this.hEq = i5;
        this.ijy = i6;
        this.scaleType = i7;
        this.hDl = -1;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/render/AbsSurfaceRenderer$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.j.a$a  reason: collision with other inner class name */
    public static final class C0421a {
        private C0421a() {
        }

        public /* synthetic */ C0421a(byte b2) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14, types: [kotlin.g.a.b<? super android.graphics.SurfaceTexture, kotlin.x>, kotlin.g.a.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void eY(boolean r6) {
        /*
        // Method dump skipped, instructions count: 277
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.j.a.eY(boolean):void");
    }

    public final void input(int i2) {
        this.hDl = i2;
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (aVar != null) {
            aVar.rl(i2);
        }
    }

    public static /* synthetic */ void a(a aVar, byte[] bArr) {
        byte[] bArr2;
        p.h(bArr, "frame");
        if (Util.isNullOrNil(aVar.ijp) || (bArr2 = aVar.ijp) == null || bArr2.length != bArr.length) {
            aVar.ijp = new byte[bArr.length];
        }
        System.arraycopy(bArr, 0, aVar.ijp, 0, bArr.length);
        com.tencent.mm.media.j.b.a aVar2 = aVar.ijo;
        if (aVar2 != null) {
            byte[] bArr3 = aVar.ijp;
            if (bArr3 == null) {
                p.hyc();
            }
            aVar2.ag(bArr3);
        }
    }

    public void eD(boolean z) {
        Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " set mirror: " + z);
        this.iju = z;
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (aVar != null) {
            aVar.iju = z;
        }
    }

    public void aED() {
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (aVar != null) {
            aVar.aED();
        }
    }

    public void release(boolean z) {
        SurfaceTexture surfaceTexture2;
        Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " called release, shouldDestroySurfaceTexture: " + z);
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (aVar != null) {
            aVar.release();
        }
        if (z && (surfaceTexture2 = this.surfaceTexture) != null) {
            surfaceTexture2.release();
        }
        d dVar = this.ijq;
        if (dVar != null) {
            dVar.close();
        }
        synchronized (this) {
            this.surfaceTexture = null;
            x xVar = x.SXb;
        }
        this.ijx = false;
    }

    public void cZ(int i2, int i3) {
        Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateTextureSize ,width : " + i2 + " , height : " + i3, new Object[0]);
        this.hDn = i2;
        this.hDo = i3;
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (aVar != null) {
            aVar.cZ(i2, i3);
        }
    }

    public void cY(int i2, int i3) {
        Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateDrawViewSize ,width : " + i2 + " , height : " + i3, new Object[0]);
        this.hEp = i2;
        this.hEq = i3;
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (aVar != null) {
            aVar.cY(i2, i3);
        }
    }

    public void qx(int i2) {
        Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " change rotate ,old degree : " + this.ijt + " , new degree : " + i2, new Object[0]);
        this.ijt = i2;
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (aVar != null) {
            aVar.qx(i2);
        }
    }

    public void onDrawFrame(GL10 gl10) {
        if (this.ijr) {
            Log.i("MicroMsg.Media.AbsSurfaceRenderer", "do clear frame");
            this.ijr = false;
        } else if (this.ijp == null && this.hDl == -1) {
            Log.e("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " there is no input ,do you dismiss setting input");
        } else {
            aED();
            kotlin.g.a.a<x> aVar = this.ijw;
            if (aVar != null) {
                aVar.invoke();
            }
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceChanged width:" + i2 + ", height:" + i3);
        cY(i2, i3);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceCreated");
        c.a aVar = c.ilt;
        c.a.aMY();
    }

    public final SurfaceTexture getTexture() {
        SurfaceTexture surfaceTexture2;
        synchronized (this) {
            surfaceTexture2 = this.surfaceTexture;
        }
        return surfaceTexture2;
    }

    public void aML() {
        Log.i("MicroMsg.Media.AbsSurfaceRenderer", "takePhoto");
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (aVar != null) {
            aVar.ijM = true;
        }
    }

    public void m(b<? super IntBuffer, x> bVar) {
        boolean z;
        p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        StringBuilder sb = new StringBuilder("glTextureRenderProc is null ?");
        if (this.ijo == null) {
            z = true;
        } else {
            z = false;
        }
        Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", sb.append(z).toString(), new Object[0]);
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (aVar != null) {
            aVar.ijJ = bVar;
        }
    }

    public int aMM() {
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (aVar != null) {
            return aVar.ijO;
        }
        return 0;
    }

    public int aMN() {
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (aVar != null) {
            return aVar.ijP;
        }
        return 0;
    }

    public d aEE() {
        return this.ijq;
    }
}
