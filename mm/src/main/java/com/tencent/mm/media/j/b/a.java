package com.tencent.mm.media.j.b;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0011\b&\u0018\u0000 ¨\u00012\u00020\u0001:\u0002¨\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010z\u001a\u000202H\u0014J\b\u0010{\u001a\u000202H\u0014J\b\u0010|\u001a\u000202H\u0004J\b\u0010}\u001a\u000202H\u0004J\b\u0010~\u001a\u000202H\u0002J\u001a\u0010\u001a\u0002022\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001J\u000f\u0010\u0001\u001a\u0002022\u0006\u0010\u0018\u001a\u00020\u0017J\u000f\u0010\u0001\u001a\u0002022\u0006\u0010%\u001a\u00020\u0017J\t\u0010\u0001\u001a\u0004\u0018\u00010=J\t\u0010\u0001\u001a\u0004\u0018\u000108J\t\u0010\u0001\u001a\u0004\u0018\u00010 J\t\u0010\u0001\u001a\u0004\u0018\u00010 J\u0007\u0010\u0001\u001a\u00020\u0003J\t\u0010\u0001\u001a\u0004\u0018\u000108J\t\u0010\u0001\u001a\u0004\u0018\u00010fJ\n\u0010\u0001\u001a\u00030\u0001H\u0004J\t\u0010\u0001\u001a\u000202H\u0014J\t\u0010\u0001\u001a\u000202H\u0004J\u0010\u0010\u0001\u001a\u00020l2\u0007\u0010\u0001\u001a\u00020lJ\u0007\u0010\u0001\u001a\u00020\u0017J\t\u0010\u0001\u001a\u000202H\u0016J\t\u0010\u0001\u001a\u000202H\u0016J\t\u0010\u0001\u001a\u000202H$J\u0013\u0010\u0001\u001a\u0002022\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0011\u0010\u0001\u001a\u0002022\u0006\u00101\u001a\u00020\u0003H\u0016J\u0012\u0010\u0001\u001a\u0002022\u0007\u0010\u0001\u001a\u00020\u0003H\u0016J\u0019\u0010\u0001\u001a\u0002022\u0007\u0010\u0001\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020\u0003J\u0012\u0010\u0001\u001a\u0002022\t\u0010 \u0001\u001a\u0004\u0018\u00010fJ\t\u0010¡\u0001\u001a\u000202H\u0016J\u001b\u0010¢\u0001\u001a\u0002022\u0007\u0010\u0001\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020\u0003H\u0016J\t\u0010£\u0001\u001a\u000202H\u0004J\u001b\u0010¤\u0001\u001a\u0002022\u0007\u0010\u0001\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020\u0003H\u0016J\u0019\u0010¥\u0001\u001a\u0002022\u0007\u0010¦\u0001\u001a\u00020r2\u0007\u0010§\u0001\u001a\u00020rR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R9\u0010-\u001a!\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R7\u00107\u001a\u001f\u0012\u0013\u0012\u001108¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(9\u0012\u0004\u0012\u000202\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00104\"\u0004\b;\u00106R7\u0010<\u001a\u001f\u0012\u0013\u0012\u00110=¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(9\u0012\u0004\u0012\u000202\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\u001a\u0010@\u001a\u00020AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u000108X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0011\"\u0004\bL\u0010\u0013R\u001a\u0010M\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0011\"\u0004\bO\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0011\"\u0004\bQ\u0010\u0013R\u0010\u0010R\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010S\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0011\"\u0004\bU\u0010\u0013R\u001a\u0010V\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0011\"\u0004\bX\u0010\u0013R\u0014\u0010Y\u001a\b\u0012\u0004\u0012\u0002080ZX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u00020AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010C\"\u0004\b]\u0010ER\u001a\u0010^\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010'\"\u0004\b`\u0010)R\u000e\u0010a\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010b\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\r\"\u0004\bd\u0010\u000fR\u0010\u0010e\u001a\u0004\u0018\u00010fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0011\"\u0004\bh\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0011\"\u0004\bj\u0010\u0013R\u001a\u0010k\u001a\u00020lX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001a\u0010q\u001a\u00020rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001a\u0010w\u001a\u00020rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010t\"\u0004\by\u0010v¨\u0006©\u0001"}, hxF = {"Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "cubeBuffer", "Ljava/nio/FloatBuffer;", "getCubeBuffer", "()Ljava/nio/FloatBuffer;", "setCubeBuffer", "(Ljava/nio/FloatBuffer;)V", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "enableSnapshot", "", "flip", "glFrameBufferObject", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "getGlFrameBufferObject", "()Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "setGlFrameBufferObject", "(Lcom/tencent/mm/media/globject/GLFrameBufferObject;)V", "glTextureObject", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getGlTextureObject", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setGlTextureObject", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "mirror", "getMirror", "()Z", "setMirror", "(Z)V", "needProfile", "getNeedProfile", "setNeedProfile", "onFBOAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "", "getOnFBOAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFBOAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "onRGBByteBufferAvailableListener", "Ljava/nio/ByteBuffer;", "buffer", "getOnRGBByteBufferAvailableListener", "setOnRGBByteBufferAvailableListener", "onRGBDataAvailableListener", "Ljava/nio/IntBuffer;", "getOnRGBDataAvailableListener", "setOnRGBDataAvailableListener", "renderCost", "", "getRenderCost", "()J", "setRenderCost", "(J)V", "renderOutputBuffer", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "getRenderOutputType", "setRenderOutputType", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "setScaleType", "snapShotBuffer", "snapShotHeight", "getSnapShotHeight", "setSnapShotHeight", "snapShotWidth", "getSnapShotWidth", "setSnapShotWidth", "snapshotBufferQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "snapshotCost", "getSnapshotCost", "setSnapshotCost", "snapshotDirectBuffer", "getSnapshotDirectBuffer", "setSnapshotDirectBuffer", "takeSnapshot", "textureCoordBuff", "getTextureCoordBuff", "setTextureCoordBuff", "textureCropRect", "Landroid/graphics/Rect;", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "transformMatrix", "", "getTransformMatrix", "()[F", "setTransformMatrix", "([F)V", "validLeftTopPoint", "Landroid/graphics/Point;", "getValidLeftTopPoint", "()Landroid/graphics/Point;", "setValidLeftTopPoint", "(Landroid/graphics/Point;)V", "validRightBottomPoint", "getValidRightBottomPoint", "setValidRightBottomPoint", "afterRender", "beforeRender", "checkInitRenderOutputBuffer", "checkInitSnapShotBuffer", "checkInitSnapShotMatrix", "fitCenter", "aspectPlane", "", "aspectTexture", "flipUpsideDown", "frameMirror", "getOutputBuffer", "getOutputByteBuffer", "getOutputTexture", "getOutputTextureObj", "getRotate", "getSnapshotOutputByteBuffer", "getTextureCropRect", "getValidTextureArea", "Landroid/graphics/RectF;", "initDrawCoordBuffer", "initMatrix", "initWithoutMatrix", "array", "isMirror", "release", "render", "renderImpl", "setFrame", "frame", "", "setInputTexture", "setRotate", "degree", "setSnapshotSize", "width", "height", "setTextureCropRect", "rect", "takeSnapShot", "updateDrawViewSize", "updateRenderTypeStatus", "updateTextureSize", "updateTextureValidPoint", "leftTop", "rightBottom", "Companion", "plugin-mediaeditor_release"})
public abstract class a {
    public static final C0423a ijW = new C0423a((byte) 0);
    protected FloatBuffer hDT;
    protected FloatBuffer hDU;
    protected int hDn;
    protected int hDo;
    protected int hEp;
    protected int hEq;
    public Rect ijA;
    public d ijD;
    protected com.tencent.mm.media.g.a ijE;
    public ByteBuffer ijF;
    protected float[] ijG = new float[16];
    public boolean ijH;
    private kotlin.g.a.b<? super d, x> ijI;
    public kotlin.g.a.b<? super IntBuffer, x> ijJ;
    public kotlin.g.a.b<? super ByteBuffer, x> ijK;
    public boolean ijL = true;
    public volatile boolean ijM;
    private boolean ijN;
    public int ijO = -1;
    public int ijP = -1;
    private LinkedBlockingQueue<ByteBuffer> ijQ = new LinkedBlockingQueue<>();
    public ByteBuffer ijR;
    public Point ijS = new Point(0, this.hDo);
    public Point ijT = new Point(this.hDn, 0);
    private long ijU;
    private boolean ijV;
    protected int ijt;
    public boolean iju;
    protected int ijy;
    protected int scaleType;

    /* access modifiers changed from: protected */
    public abstract void aMV();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"valid", "", "size", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<Float, Float> {
        public static final b ijX = new b();

        static {
            AppMethodBeat.i(218759);
            AppMethodBeat.o(218759);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Float invoke(Float f2) {
            AppMethodBeat.i(218758);
            Float valueOf = Float.valueOf(au(f2.floatValue()));
            AppMethodBeat.o(218758);
            return valueOf;
        }

        public static float au(float f2) {
            if (f2 > 1.0f) {
                return 1.0f;
            }
            if (f2 < 0.0f) {
                return 0.0f;
            }
            return f2;
        }
    }

    public a(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.hDn = i2;
        this.hDo = i3;
        this.hEp = i4;
        this.hEq = i5;
        this.ijy = i6;
        this.scaleType = i7;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(c.iln.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        p.g(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.hDT = asFloatBuffer;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(c.ilm.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        p.g(asFloatBuffer2, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.hDU = asFloatBuffer2;
        if (this.ijy == 2) {
            this.ijD = com.tencent.mm.media.g.c.a(true, 3);
            com.tencent.mm.media.g.c cVar = com.tencent.mm.media.g.c.igu;
            this.ijE = com.tencent.mm.media.g.c.zI(3);
        } else if (this.ijy == 3) {
            aMQ();
        }
    }

    private void aMQ() {
        if (this.hEp > 0 && this.hEq > 0 && this.ijF == null) {
            this.ijF = ByteBuffer.allocateDirect(this.hEp * this.hEq * 4).order(ByteOrder.nativeOrder());
        }
    }

    public void qx(int i2) {
        this.ijt = i2;
    }

    public final void dc(int i2, int i3) {
        Log.i("MicroMsg.GLTextureRenderProc", "setSnapshotSize:" + i2 + " x " + i3);
        if (!(i2 == this.ijO && i3 == this.ijP)) {
            Log.i("MicroMsg.GLTextureRenderProc", "SnapshotSize Changed: res: " + i2 + " x " + i3 + " ori: " + this.ijO + " x " + this.ijP + " buffQuesize: " + this.ijQ.size());
            this.ijQ.clear();
        }
        this.ijO = i2;
        this.ijP = i3;
    }

    public final void E(float f2, float f3) {
        float f4;
        float f5;
        float f6;
        float f7;
        if (f3 > f2) {
            f7 = f3 / f2;
            f6 = -f7;
            f5 = 1.0f;
            f4 = -1.0f;
        } else {
            f4 = (-f2) / f3;
            f5 = -f4;
            f6 = -1.0f;
            f7 = 1.0f;
        }
        Matrix.orthoM(this.ijG, 0, f4, f5, f6, f7, 1.0f, -1.0f);
    }

    public final float[] k(float[] fArr) {
        p.h(fArr, "array");
        c.a aVar = c.ilt;
        c.a.e(this.ijt, fArr);
        if (this.iju) {
            c.a aVar2 = c.ilt;
            p.h(fArr, "textureCoords");
            fArr[1] = 1.0f - fArr[1];
            fArr[3] = 1.0f - fArr[3];
            fArr[5] = 1.0f - fArr[5];
            fArr[7] = 1.0f - fArr[7];
        }
        return fArr;
    }

    public void rl(int i2) {
    }

    public void ag(byte[] bArr) {
        p.h(bArr, "frame");
    }

    /* access modifiers changed from: protected */
    public final RectF aMR() {
        return new RectF(((float) this.ijS.x) / ((float) this.hDn), (((float) this.ijS.y) - 1.0f) / ((float) this.hDo), (((float) this.ijT.x) - 1.0f) / ((float) this.hDn), ((float) this.ijT.y) / ((float) this.hDo));
    }

    /* access modifiers changed from: protected */
    public void aMS() {
        float f2;
        float f3;
        float f4;
        float f5;
        int i2;
        float f6;
        float f7;
        RectF aMR = aMR();
        float f8 = aMR.left;
        float f9 = aMR.top;
        float f10 = aMR.right;
        float f11 = aMR.bottom;
        if (this.scaleType == 1 || this.scaleType == 5) {
            this.hDT.position(0);
            this.hDT.put(new float[]{f8, f9, f10, f9, f8, f11, f10, f11});
            this.hDT.position(0);
        } else if (this.scaleType == 2) {
            float[] fArr = c.iln;
            float[] copyOf = Arrays.copyOf(fArr, fArr.length);
            boolean z = this.ijt == 90 || this.ijt == 270;
            int i3 = this.ijT.x - this.ijS.x;
            int i4 = this.ijS.y - this.ijT.y;
            if (z) {
                i2 = i4;
            } else {
                i2 = i3;
            }
            if (!z) {
                i3 = i4;
            }
            float f12 = ((float) this.hEp) / ((float) i2);
            float f13 = ((float) this.hEq) / ((float) i3);
            float f14 = 0.0f;
            float f15 = 0.0f;
            if (f12 < f13) {
                f14 = ((float) i2) - (((float) this.hEp) / f13);
            } else if (f12 > f13) {
                f15 = ((float) i3) - (((float) this.hEq) / f12);
            }
            this.ijO = i2 - ((int) f14);
            this.ijP = i3 - ((int) f15);
            if (z) {
                f7 = (f15 / 2.0f) / ((float) i3);
                f6 = (f14 / 2.0f) / ((float) i2);
            } else {
                f6 = (f15 / 2.0f) / ((float) i3);
                f7 = (f14 / 2.0f) / ((float) i2);
            }
            float f16 = f8 + f7;
            float f17 = f10 - f7;
            float f18 = f11 + f6;
            float f19 = f9 - f6;
            copyOf[0] = f16;
            copyOf[1] = f19;
            copyOf[2] = f17;
            copyOf[3] = f19;
            copyOf[4] = f16;
            copyOf[5] = f18;
            copyOf[6] = f17;
            copyOf[7] = f18;
            this.hDT.put(c.iln);
            this.hDT.position(0);
            this.hDT.put(copyOf);
            this.hDT.position(0);
            this.hDU.position(0);
        } else if (this.scaleType == 3) {
            if (this.ijA != null) {
                float[] fArr2 = c.iln;
                float[] copyOf2 = Arrays.copyOf(fArr2, fArr2.length);
                Rect rect = this.ijA;
                Integer valueOf = rect != null ? Integer.valueOf(rect.width()) : null;
                if (valueOf == null) {
                    p.hyc();
                }
                int intValue = valueOf.intValue();
                Rect rect2 = this.ijA;
                Integer valueOf2 = rect2 != null ? Integer.valueOf(rect2.height()) : null;
                if (valueOf2 == null) {
                    p.hyc();
                }
                int intValue2 = valueOf2.intValue();
                Rect rect3 = this.ijA;
                if (rect3 == null || rect3.left != 0) {
                    f2 = ((float) (this.hDn - intValue)) / ((float) this.hDn);
                    f3 = 1.0f - f2;
                } else {
                    f3 = ((float) (this.hDn - intValue)) / ((float) this.hDn);
                    f2 = 1.0f - f3;
                }
                Rect rect4 = this.ijA;
                if (rect4 == null || rect4.top != 0) {
                    f4 = ((float) (this.hDo - intValue2)) / ((float) this.hDo);
                    f5 = 1.0f - f4;
                } else {
                    f5 = ((float) (this.hDo - intValue2)) / ((float) this.hDo);
                    f4 = 1.0f - f5;
                }
                copyOf2[0] = f3;
                copyOf2[1] = f5;
                copyOf2[2] = f2;
                copyOf2[3] = f5;
                copyOf2[4] = f3;
                copyOf2[5] = f4;
                copyOf2[6] = f2;
                copyOf2[7] = f4;
                this.hDT.put(c.iln);
                this.hDT.position(0);
                this.hDT.put(copyOf2);
                this.hDT.position(0);
                this.hDU.position(0);
            } else {
                this.hDT.position(0);
                this.hDT.put(new float[]{f8, f9, f10, f9, f8, f11, f10, f11});
                this.hDT.position(0);
            }
        } else if (this.scaleType == 4) {
            if (this.ijA != null) {
                float[] fArr3 = c.iln;
                float[] copyOf3 = Arrays.copyOf(fArr3, fArr3.length);
                b bVar = b.ijX;
                int i5 = this.hDn;
                int i6 = this.hDo;
                Rect rect5 = this.ijA;
                if (rect5 == null) {
                    p.hyc();
                }
                float au = b.au(((float) rect5.left) / ((float) i5));
                Rect rect6 = this.ijA;
                if (rect6 == null) {
                    p.hyc();
                }
                float au2 = b.au(((float) rect6.right) / ((float) i5));
                Rect rect7 = this.ijA;
                if (rect7 == null) {
                    p.hyc();
                }
                float au3 = b.au(((float) rect7.bottom) / ((float) i6));
                Rect rect8 = this.ijA;
                if (rect8 == null) {
                    p.hyc();
                }
                float au4 = b.au(((float) rect8.top) / ((float) i6));
                float abs = Math.abs(f10 - f8);
                float abs2 = Math.abs(f11 - f9);
                float f20 = (au * abs) + f8;
                float f21 = (au2 * abs) + f8;
                float min = (au3 * abs2) + Math.min(f9, f11);
                float min2 = (au4 * abs2) + Math.min(f9, f11);
                copyOf3[0] = f20;
                copyOf3[1] = min2;
                copyOf3[2] = f21;
                copyOf3[3] = min2;
                copyOf3[4] = f20;
                copyOf3[5] = min;
                copyOf3[6] = f21;
                copyOf3[7] = min;
                this.hDT.put(c.iln);
                this.hDT.position(0);
                this.hDT.put(copyOf3);
                this.hDT.position(0);
                this.hDU.position(0);
            } else {
                this.hDT.position(0);
                this.hDT.put(new float[]{f8, f9, f10, f9, f8, f11, f10, f11});
                this.hDT.position(0);
            }
        }
        this.hDU.position(0);
        this.hDU.put(c.ilm);
        this.hDU.position(0);
    }

    /* access modifiers changed from: protected */
    public final void aMT() {
        if (this.ijy == 2) {
            if (this.ijD == null) {
                this.ijD = com.tencent.mm.media.g.c.a(true, 3);
                com.tencent.mm.media.g.c cVar = com.tencent.mm.media.g.c.igu;
                this.ijE = com.tencent.mm.media.g.c.zI(3);
            }
            c.a aVar = c.ilt;
            c.a.a(this.ijE, this.ijD, this.hEp, this.hEq);
        }
        GLES20.glViewport(0, 0, this.hEp, this.hEq);
        if (this.ijM) {
            if (this.ijD == null) {
                this.ijD = com.tencent.mm.media.g.c.a(true, 3);
                com.tencent.mm.media.g.c cVar2 = com.tencent.mm.media.g.c.igu;
                this.ijE = com.tencent.mm.media.g.c.zI(3);
            }
            c.a aVar2 = c.ilt;
            c.a.a(this.ijE, this.ijD, this.ijO, this.ijP);
            GLES20.glViewport(0, 0, this.ijO, this.ijP);
            if (this.ijt == 90 || this.ijt == 270) {
                Matrix.scaleM(this.ijG, 0, -1.0f, 1.0f, 1.0f);
            } else {
                Matrix.scaleM(this.ijG, 0, 1.0f, -1.0f, 1.0f);
            }
            Log.i("MicroMsg.GLTextureRenderProc", "rotateDegree " + this.ijt + "  transformMatrix:" + this.ijG + " snapShotWidth:" + this.ijO + " snapShotHeight:" + this.ijP);
            this.ijN = true;
        }
    }

    /* access modifiers changed from: protected */
    public void aEB() {
        Matrix.setIdentityM(this.ijG, 0);
        Matrix.setRotateM(this.ijG, 0, (float) this.ijt, 0.0f, 0.0f, -1.0f);
        if (!this.ijH && this.ijy != 3) {
            Matrix.scaleM(this.ijG, 0, 1.0f, 1.0f, 1.0f);
        } else if (this.ijt == 90 || this.ijt == 270) {
            Matrix.scaleM(this.ijG, 0, -1.0f, 1.0f, 1.0f);
        } else {
            Matrix.scaleM(this.ijG, 0, 1.0f, -1.0f, 1.0f);
        }
        if (this.iju) {
            Matrix.scaleM(this.ijG, 0, 1.0f, -1.0f, 1.0f);
        }
        if (this.scaleType == 5) {
            E(((float) this.hEp) / ((float) this.hEq), ((float) this.hDn) / ((float) this.hDo));
        }
        aMS();
        aMT();
    }

    public final void aED() {
        aEB();
        if (this.ijV) {
            GLES20.glFinish();
        }
        long currentTicks = Util.currentTicks();
        aMV();
        if (this.ijV) {
            GLES20.glFinish();
            this.ijU = Util.ticksToNow(currentTicks);
        }
        aMU();
    }

    /* access modifiers changed from: protected */
    public void aMU() {
        if (!this.ijM || !this.ijN) {
            if (this.ijy == 3) {
                if (this.ijF == null) {
                    aMQ();
                }
                if (this.ijF != null) {
                    ByteBuffer byteBuffer = this.ijF;
                    if (byteBuffer != null) {
                        byteBuffer.clear();
                    }
                    GLES20.glReadPixels(0, 0, this.hEp, this.hEq, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.ijF);
                    GLES20.glFinish();
                    kotlin.g.a.b<? super IntBuffer, x> bVar = this.ijJ;
                    if (bVar != null) {
                        ByteBuffer byteBuffer2 = this.ijF;
                        IntBuffer asIntBuffer = byteBuffer2 != null ? byteBuffer2.asIntBuffer() : null;
                        if (asIntBuffer == null) {
                            p.hyc();
                        }
                        bVar.invoke(asIntBuffer);
                    }
                }
            } else if (this.ijy == 2) {
                GLES20.glBindFramebuffer(36160, 0);
                kotlin.g.a.b<? super d, x> bVar2 = this.ijI;
                if (bVar2 != null) {
                    bVar2.invoke(this.ijD);
                }
            }
            GLES20.glUseProgram(0);
            GLES30.glBindFramebuffer(36160, 0);
            return;
        }
        long currentTicks = Util.currentTicks();
        this.ijN = false;
        if (this.ijQ.size() < 2 && this.ijO > 0 && this.ijP > 0 && this.ijQ.size() < 2) {
            if (this.ijL) {
                int size = 2 - this.ijQ.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.ijQ.add(ByteBuffer.allocateDirect(this.ijO * this.ijP * 4).order(ByteOrder.nativeOrder()));
                }
            } else {
                int size2 = 2 - this.ijQ.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    this.ijQ.add(ByteBuffer.allocate(this.ijO * this.ijP * 4).order(ByteOrder.nativeOrder()));
                }
            }
        }
        if (this.ijQ.size() < 2 || this.ijO < 0 || this.ijP < 0) {
            this.ijM = false;
            return;
        }
        Log.i("MicroMsg.GLTextureRenderProc", hashCode() + " after render takeSnapshot, renderOutputTextureFbo:" + this.ijE + ", renderOutputTexture:" + this.ijD);
        com.tencent.mm.media.g.a aVar = this.ijE;
        if (aVar != null) {
            GLES20.glBindFramebuffer(36160, aVar.igo);
        }
        ByteBuffer remove = this.ijQ.size() > 0 ? this.ijQ.remove() : ByteBuffer.allocate(this.ijO * this.ijP * 4).order(ByteOrder.nativeOrder());
        if (remove != null) {
            remove.position(0);
        }
        GLES20.glReadPixels(0, 0, this.ijO, this.ijP, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, remove);
        GLES20.glFinish();
        kotlin.g.a.b<? super ByteBuffer, x> bVar3 = this.ijK;
        if (bVar3 != null) {
            if (remove == null) {
                p.hyc();
            }
            bVar3.invoke(remove);
        }
        kotlin.g.a.b<? super IntBuffer, x> bVar4 = this.ijJ;
        if (bVar4 != null) {
            IntBuffer asIntBuffer2 = remove != null ? remove.asIntBuffer() : null;
            if (asIntBuffer2 == null) {
                p.hyc();
            }
            bVar4.invoke(asIntBuffer2);
        }
        GLES30.glBindFramebuffer(36160, 0);
        this.ijM = false;
        if (this.ijQ.size() < 2) {
            this.ijQ.add(remove);
        }
        this.ijR = remove;
        Log.i("MicroMsg.GLTextureRenderProc", hashCode() + " takeSnapShot cost " + Util.ticksToNow(currentTicks) + ", size:" + this.ijO + 'x' + this.ijP + "  rotate: " + this.ijt + " snapshotBufferQueue.size:" + this.ijQ.size());
    }

    public void cY(int i2, int i3) {
        this.hEq = i3;
        this.hEp = i2;
        dc(i2, i3);
        if (this.ijy == 3) {
            aMQ();
        }
    }

    public void cZ(int i2, int i3) {
        this.hDn = i2;
        this.hDo = i3;
        this.ijS.x = 0;
        this.ijS.y = i3;
        this.ijT.x = i2;
        this.ijT.y = 0;
    }

    public void release() {
        Log.i("MicroMsg.GLTextureRenderProc", hashCode() + " release renderOutputTexture:" + this.ijD + ", renderOutputTextureFbo:" + this.ijE + ", drawWidth:" + this.hEp + ", drawHeight:" + this.hEq);
        d dVar = this.ijD;
        if (dVar != null) {
            dVar.close();
        }
        com.tencent.mm.media.g.a aVar = this.ijE;
        if (aVar != null) {
            aVar.close();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/media/render/proc/GLTextureRenderProc$Companion;", "", "()V", "RENDER_OUTPUT_RGB_BUFFER", "", "RENDER_OUTPUT_SCREEN", "RENDER_OUTPUT_TEXTURE", "SCALE_TYPE_CENTER_CROP", "SCALE_TYPE_CROP_RECT", "SCALE_TYPE_CROP_RECT_ALIGN_ONE_SIDE", "SCALE_TYPE_FIT_MODE", "SCALE_TYPE_NOT_SCALE", "SnapshotBufferQueueSize", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.j.b.a$a  reason: collision with other inner class name */
    public static final class C0423a {
        private C0423a() {
        }

        public /* synthetic */ C0423a(byte b2) {
            this();
        }
    }
}
