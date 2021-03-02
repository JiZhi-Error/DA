package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.media.j.d;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 O2\u00020\u0001:\u0001OB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020\u001aH\u0014J\u000e\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\bJ\b\u00101\u001a\u00020\u0006H\u0002J\b\u00102\u001a\u00020\u000fH\u0002J\n\u00103\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u00104\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u0003H\u0016J\u0006\u0010\u0015\u001a\u00020\bJ\"\u00105\u001a\u00020\u001e2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0016J\u001c\u0010:\u001a\u00020\u001e2\b\u00106\u001a\u0004\u0018\u0001072\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u0003H\u0016J\b\u0010?\u001a\u00020\u001eH\u0016J\u0006\u0010@\u001a\u00020\u001eJ\u0010\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020\bH\u0016J\u000e\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\bJ\u0016\u0010E\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\b2\u0006\u0010F\u001a\u00020GJ\u0010\u0010H\u001a\u00020\u001e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0018\u0010I\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0016J\u0010\u0010J\u001a\u00020\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010K\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\u0003J\u000e\u0010M\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\bJ\u0018\u0010N\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bX\u000e¢\u0006\u0002\n\u0000RD\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001d2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001d@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u0004¨\u0006P"}, hxF = {"Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "useCPUCrop", "", "(Z)V", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "cropHeight", "", "cropWidth", "cubeBuffer", "Ljava/nio/FloatBuffer;", "faceBeautyProgram", "Lcom/tencent/mm/live/core/render/LiveYTFaceBeautyRendererProgram;", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "finalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "mFps", "mTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mirrorMode", "outputHeight", "outputWidth", "renderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lkotlin/collections/ArrayList;", "value", "Lkotlin/Function1;", "", "rendererFpsCountCallback", "getRendererFpsCountCallback", "()Lkotlin/jvm/functions/Function1;", "setRendererFpsCountCallback", "(Lkotlin/jvm/functions/Function1;)V", "rendererPerFrameCostCallback", "getRendererPerFrameCostCallback", "setRendererPerFrameCostCallback", "screenRender", "Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "textureCoordBuff", "getUseCPUCrop", "()Z", "setUseCPUCrop", "calculateTextureSize", "doInitRenderProc", "endScaleAnimation", "time", "genDefaultBeautyConfig", "genDefaultFilterConfig", "getOutputTexture", "mirror", "onSurfaceChanged", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "reset", "setRotate", "degree", "setup", "scene", "startScaleAnimation", "scale", "", "updateBeautyConfig", "updateDrawViewSize", "updateFilterConfig", "updateMirror", "isMirror", "updateMirrorMode", "updateTextureSize", "Companion", "plugin-core_release"})
public final class g extends d {
    public static final a hEc = new a((byte) 0);
    private ArrayList<com.tencent.mm.media.j.b.a> hDN;
    public f hDO;
    private com.tencent.mm.media.g.d hDP;
    private int hDQ;
    private int hDR;
    k hDS;
    private FloatBuffer hDT;
    private FloatBuffer hDU;
    a hDV;
    b hDW;
    private int hDX;
    kotlin.g.a.b<? super Integer, x> hDY;
    kotlin.g.a.b<? super Integer, x> hDZ;
    private MTimerHandler hEa;
    public int hEb;
    private boolean hzi;
    private int outputHeight;
    private int outputWidth;

    static {
        AppMethodBeat.i(196666);
        AppMethodBeat.o(196666);
    }

    private /* synthetic */ g() {
        this(false);
    }

    public g(boolean z) {
        super(2);
        AppMethodBeat.i(196665);
        this.hzi = z;
        this.hDN = new ArrayList<>();
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(c.iln.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        p.g(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.hDT = asFloatBuffer;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(c.ilm.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        p.g(asFloatBuffer2, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.hDU = asFloatBuffer2;
        e.g gVar = e.g.hxV;
        this.hEb = e.g.aCQ();
        AppMethodBeat.o(196665);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/core/render/LiveTexEditRenderer$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void g(kotlin.g.a.b<? super Integer, x> bVar) {
        MTimerHandler mTimerHandler;
        AppMethodBeat.i(196653);
        if (bVar == null) {
            MTimerHandler mTimerHandler2 = this.hEa;
            if (mTimerHandler2 != null) {
                mTimerHandler2.stopTimer();
            }
            MTimerHandler mTimerHandler3 = this.hEa;
            if (mTimerHandler3 != null) {
                mTimerHandler3.quitSafely();
            }
        } else {
            if (this.hEa == null || ((mTimerHandler = this.hEa) != null && mTimerHandler.isQuit())) {
                this.hEa = new MTimerHandler("LiveRenderFpsCounter", (MTimerHandler.CallBack) new b(this), true);
            }
            MTimerHandler mTimerHandler4 = this.hEa;
            if (mTimerHandler4 != null) {
                mTimerHandler4.startTimer(1000);
            }
        }
        this.hDY = bVar;
        AppMethodBeat.o(196653);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class b implements MTimerHandler.CallBack {
        final /* synthetic */ g hEd;

        b(g gVar) {
            this.hEd = gVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(196652);
            kotlin.g.a.b<? super Integer, x> bVar = this.hEd.hDY;
            if (bVar != null) {
                bVar.invoke(Integer.valueOf(this.hEd.hDX));
            }
            this.hEd.hDX = 0;
            AppMethodBeat.o(196652);
            return true;
        }
    }

    @Override // com.tencent.mm.media.j.a
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.i(196654);
        super.onSurfaceCreated(gl10, eGLConfig);
        this.hDO = new f(this.hDn, this.hDo, this.outputWidth, this.outputHeight);
        AppMethodBeat.o(196654);
    }

    @Override // com.tencent.mm.media.j.a
    public final void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        AppMethodBeat.i(196655);
        this.outputWidth = i2;
        this.outputHeight = i3;
        f fVar = this.hDO;
        if (fVar != null) {
            fVar.cY(i2, i3);
        }
        aEF();
        com.tencent.mm.media.j.b.a aVar = this.ijo;
        if (aVar != null) {
            aVar.ijH = true;
            AppMethodBeat.o(196655);
            return;
        }
        AppMethodBeat.o(196655);
    }

    @Override // com.tencent.mm.media.j.a
    public final com.tencent.mm.media.j.b.a aEC() {
        AppMethodBeat.i(196656);
        this.hDS = new k();
        if (this.hzi) {
            f fVar = new f(this.hDn, this.hDo, this.outputWidth, this.outputHeight, this.ijy, this.scaleType);
            AppMethodBeat.o(196656);
            return fVar;
        }
        com.tencent.mm.media.j.b.c cVar = new com.tencent.mm.media.j.b.c(this.hDn, this.hDo, this.outputWidth, this.outputHeight, this.ijy, this.scaleType);
        AppMethodBeat.o(196656);
        return cVar;
    }

    @Override // com.tencent.mm.media.j.a
    public final void aED() {
        com.tencent.mm.media.g.d dVar;
        int i2;
        int i3;
        AppMethodBeat.i(196657);
        long currentTicks = Util.currentTicks();
        super.aED();
        k kVar = this.hDS;
        if (kVar != null) {
            int i4 = this.outputWidth;
            int i5 = this.outputHeight;
            FloatBuffer floatBuffer = this.hDU;
            FloatBuffer floatBuffer2 = this.hDT;
            com.tencent.mm.media.j.b.a aVar = this.ijo;
            if (aVar == null) {
                p.hyc();
            }
            com.tencent.mm.media.g.d dVar2 = aVar.ijD;
            if (dVar2 == null) {
                p.hyc();
            }
            a aVar2 = this.hDV;
            if (aVar2 == null) {
                a aVar3 = new a();
                e.c cVar = e.c.hxm;
                aVar3.hDh.put(Integer.valueOf(e.c.aCh()), -1);
                e.c cVar2 = e.c.hxm;
                aVar3.hDh.put(Integer.valueOf(e.c.aCi()), -1);
                e.c cVar3 = e.c.hxm;
                aVar3.hDh.put(Integer.valueOf(e.c.aCl()), -1);
                e.c cVar4 = e.c.hxm;
                aVar3.hDh.put(Integer.valueOf(e.c.aCj()), -1);
                e.c cVar5 = e.c.hxm;
                aVar3.hDh.put(Integer.valueOf(e.c.aCm()), -1);
                e.c cVar6 = e.c.hxm;
                aVar3.hDh.put(Integer.valueOf(e.c.aCk()), -1);
                aVar2 = aVar3;
            }
            b bVar = this.hDW;
            if (bVar == null) {
                bVar = new b(-1, "", -1);
            }
            p.h(floatBuffer, "cubeBuffer");
            p.h(floatBuffer2, "textureCoordBuff");
            p.h(dVar2, "texture");
            p.h(aVar2, "beautyParam");
            p.h(bVar, "filterParam");
            if (dVar2.igv != -1) {
                int i6 = dVar2.igv;
                if (kVar.hEp == 0 || kVar.hEq == 0) {
                    if (kVar.hEv == null) {
                        kVar.hEv = com.tencent.mm.media.g.c.a(true, 18);
                        kVar.hEw = new c();
                        c cVar7 = kVar.hEw;
                        if (cVar7 != null) {
                            com.tencent.mm.media.g.d dVar3 = kVar.hEv;
                            if (dVar3 == null) {
                                p.hyc();
                            }
                            cVar7.a(i6, dVar3, aVar2, bVar);
                        }
                    } else if (!(kVar.hEp == i4 && kVar.hEq == i5)) {
                        com.tencent.mm.media.g.d dVar4 = kVar.hEv;
                        if (dVar4 != null) {
                            dVar4.close();
                        }
                        kVar.hEv = com.tencent.mm.media.g.c.a(true, 18);
                        c cVar8 = kVar.hEw;
                        if (cVar8 != null) {
                            com.tencent.mm.media.g.d dVar5 = kVar.hEv;
                            if (dVar5 == null) {
                                p.hyc();
                            }
                            p.h(dVar5, "outputTexture");
                            cVar8.hDm = dVar5;
                        }
                    }
                    kVar.hEp = i4;
                    kVar.hEq = i5;
                }
                c cVar9 = kVar.hEw;
                if (cVar9 != null) {
                    int i7 = kVar.hEp;
                    int i8 = kVar.hEq;
                    if (!(i8 == cVar9.hDo && i7 == cVar9.hDn)) {
                        Log.i(c.TAG, "updateTextureSize:%s, %s", Integer.valueOf(i7), Integer.valueOf(i8));
                    }
                    cVar9.hDn = i7;
                    cVar9.hDo = i8;
                    if (cVar9.hiH != null) {
                        com.tencent.mm.plugin.xlabeffect.b bVar2 = cVar9.hiH;
                        if (bVar2 == null) {
                            p.hyc();
                        }
                        bVar2.setSize(i7, i8);
                    }
                    cVar9.hDl = dVar2.igv;
                    cVar9.aEw();
                }
                dVar = kVar.hEv;
            } else {
                dVar = dVar2;
            }
        } else {
            dVar = null;
        }
        this.hDP = dVar;
        for (T t : this.hDN) {
            com.tencent.mm.media.g.d dVar6 = this.hDP;
            if (dVar6 != null) {
                i3 = dVar6.igv;
            } else {
                i3 = -1;
            }
            t.rl(i3);
            t.aED();
            this.hDP = t.ijD;
        }
        f fVar = this.hDO;
        if (fVar != null) {
            com.tencent.mm.media.g.d dVar7 = this.hDP;
            if (dVar7 != null) {
                i2 = dVar7.igv;
            } else {
                i2 = -1;
            }
            fVar.hDl = i2;
        }
        f fVar2 = this.hDO;
        if (fVar2 != null) {
            fVar2.aED();
        }
        this.hDX++;
        kotlin.g.a.b<? super Integer, x> bVar3 = this.hDZ;
        if (bVar3 != null) {
            bVar3.invoke(Integer.valueOf((int) Util.ticksToNow(currentTicks)));
            AppMethodBeat.o(196657);
            return;
        }
        AppMethodBeat.o(196657);
    }

    @Override // com.tencent.mm.media.j.a
    public final void cZ(int i2, int i3) {
        AppMethodBeat.i(196658);
        super.cZ(i2, i3);
        aEF();
        AppMethodBeat.o(196658);
    }

    @Override // com.tencent.mm.media.j.a
    public final void cY(int i2, int i3) {
        AppMethodBeat.i(196659);
        f fVar = this.hDO;
        if (fVar != null) {
            fVar.cY(i2, i3);
            AppMethodBeat.o(196659);
            return;
        }
        AppMethodBeat.o(196659);
    }

    @Override // com.tencent.mm.media.j.a
    public final void qx(int i2) {
        AppMethodBeat.i(196660);
        super.qx(i2);
        aEF();
        AppMethodBeat.o(196660);
    }

    @Override // com.tencent.mm.media.j.a
    public final com.tencent.mm.media.g.d aEE() {
        AppMethodBeat.i(196661);
        com.tencent.mm.media.g.d dVar = this.hDP;
        if (dVar != null) {
            dVar.setSize(this.hDQ, this.hDR);
        }
        com.tencent.mm.media.g.d dVar2 = this.hDP;
        AppMethodBeat.o(196661);
        return dVar2;
    }

    private final void aEF() {
        int i2;
        int i3;
        AppMethodBeat.i(196662);
        if (this.outputWidth <= 0 || this.hDn <= 0) {
            AppMethodBeat.o(196662);
            return;
        }
        boolean z = this.ijt == 90 || this.ijt == 270;
        if (z) {
            i2 = this.hDo;
        } else {
            i2 = this.hDn;
        }
        if (z) {
            i3 = this.hDn;
        } else {
            i3 = this.hDo;
        }
        float f2 = ((float) this.outputWidth) / ((float) i2);
        float f3 = ((float) this.outputHeight) / ((float) i3);
        if (f2 < f3) {
            this.hDQ = i2 - (i2 - ((int) (((float) this.outputWidth) / f3)));
            this.hDR = i3;
        } else if (f2 > f3) {
            this.hDR = i3 - (i3 - ((int) (((float) this.outputHeight) / f2)));
            this.hDQ = i2;
        } else {
            this.hDR = i3;
            this.hDQ = i2;
        }
        Log.i("MicroMsg.LiveTexEditRenderer", "calculate crop texture width:" + this.hDQ + " height:" + this.hDR);
        for (T t : this.hDN) {
            t.cZ(this.hDQ, this.hDR);
            t.cZ(this.hDQ, this.hDR);
        }
        super.cY(this.hDQ, this.hDR);
        f fVar = this.hDO;
        if (fVar != null) {
            fVar.cZ(this.hDQ, this.hDR);
            AppMethodBeat.o(196662);
            return;
        }
        AppMethodBeat.o(196662);
    }

    @Override // com.tencent.mm.media.j.a
    public final void eD(boolean z) {
        AppMethodBeat.i(196663);
        Log.i("MicroMsg.LiveTexEditRenderer", "mirror mirrorMode:" + this.hEb + " mirror:" + z);
        if (z) {
            int i2 = this.hEb;
            e.g gVar = e.g.hxV;
            if (i2 == e.g.aCQ()) {
                f fVar = this.hDO;
                if (fVar != null) {
                    fVar.iju = true;
                }
                super.eD(false);
                AppMethodBeat.o(196663);
                return;
            }
            int i3 = this.hEb;
            e.g gVar2 = e.g.hxV;
            if (i3 == e.g.aCR()) {
                f fVar2 = this.hDO;
                if (fVar2 != null) {
                    fVar2.iju = false;
                }
                super.eD(true);
            }
            AppMethodBeat.o(196663);
            return;
        }
        f fVar3 = this.hDO;
        if (fVar3 != null) {
            fVar3.iju = false;
        }
        super.eD(false);
        AppMethodBeat.o(196663);
    }

    @Override // com.tencent.mm.media.j.a
    public final void release(boolean z) {
        AppMethodBeat.i(196664);
        super.release(z);
        Iterator<T> it = this.hDN.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        com.tencent.mm.media.g.d dVar = this.hDP;
        if (dVar != null) {
            dVar.close();
        }
        f fVar = this.hDO;
        if (fVar != null) {
            fVar.release();
        }
        k kVar = this.hDS;
        if (kVar != null) {
            com.tencent.mm.media.j.b.e eVar = kVar.hEx;
            if (eVar != null) {
                eVar.release();
            }
            com.tencent.mm.media.g.d dVar2 = kVar.hEv;
            if (dVar2 != null) {
                dVar2.close();
            }
            c cVar = kVar.hEw;
            if (cVar != null) {
                String str = c.TAG;
                Thread currentThread = Thread.currentThread();
                p.g(currentThread, "Thread.currentThread()");
                Log.i(str, "clear %s %d", cVar, Long.valueOf(currentThread.getId()));
                try {
                    com.tencent.mm.media.g.d dVar3 = cVar.hDm;
                    if (dVar3 != null) {
                        dVar3.close();
                    }
                    if (cVar.hiH != null) {
                        com.tencent.mm.plugin.xlabeffect.b bVar = cVar.hiH;
                        if (bVar == null) {
                            p.hyc();
                        }
                        bVar.destroy();
                        cVar.hiH = null;
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace(c.TAG, e2, "clear error: %s", e2.getMessage());
                }
            }
            GLES20.glDeleteProgram(kVar.programId);
        }
        MTimerHandler mTimerHandler = this.hEa;
        if (mTimerHandler != null) {
            mTimerHandler.stopTimer();
        }
        MTimerHandler mTimerHandler2 = this.hEa;
        if (mTimerHandler2 != null) {
            mTimerHandler2.quit();
            AppMethodBeat.o(196664);
            return;
        }
        AppMethodBeat.o(196664);
    }
}
