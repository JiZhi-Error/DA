package com.tencent.mm.xeffect;

import android.opengl.GLES31;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.List;

public class VLogDirector {
    private long RxK = 0;
    private long Rxd;
    private int height;
    private int outputHeight;
    private int outputWidth;
    private long threadId;
    private int width;

    private static native int nAddInputTexture(long j2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, float f2, float f3, boolean z, boolean z2);

    private static native void nDestroy(long j2);

    private static native long nInit();

    private static native int nRender(long j2, int i2, int i3, int i4, long j3);

    private static native void nSetEffectManager(long j2, long j3);

    private static native int nSetOutputTexCropRet(long j2, int i2, int i3, int i4, int i5);

    private static native int nSetRenderArea(long j2, int i2, int i3, int i4, int i5);

    static {
        AppMethodBeat.i(236760);
        d.load("xlabeffect");
        d.load("pag");
        AppMethodBeat.o(236760);
    }

    public final void setSize(int i2, int i3) {
        AppMethodBeat.i(236752);
        this.width = i2;
        this.height = i3;
        mm(i2, i3);
        AppMethodBeat.o(236752);
    }

    public final void init() {
        AppMethodBeat.i(236753);
        this.threadId = Thread.currentThread().getId();
        this.Rxd = nInit();
        AppMethodBeat.o(236753);
    }

    public final void destroy() {
        AppMethodBeat.i(236754);
        checkThread();
        if (this.Rxd != 0) {
            nDestroy(this.Rxd);
            this.Rxd = 0;
        }
        AppMethodBeat.o(236754);
    }

    public final void mm(int i2, int i3) {
        AppMethodBeat.i(236755);
        checkThread();
        if (this.Rxd != 0) {
            nSetRenderArea(this.Rxd, 0, 0, i2, i3);
        }
        AppMethodBeat.o(236755);
    }

    public final void V(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(236756);
        checkThread();
        if (this.Rxd != 0) {
            nSetOutputTexCropRet(this.Rxd, i2, i3, i4, i5);
        }
        AppMethodBeat.o(236756);
    }

    public final void setOutputSize(int i2, int i3) {
        this.outputWidth = i2;
        this.outputHeight = i3;
    }

    public final void a(List<b> list, int i2, long j2) {
        boolean z;
        AppMethodBeat.i(236757);
        checkThread();
        if (this.Rxd != 0) {
            for (b bVar : list) {
                if (bVar == null) {
                    XEffectLog.e("VLogDirector", "input is null", new Object[0]);
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    nAddInputTexture(this.Rxd, bVar.textureId, bVar.width, bVar.height, bVar.dYT, bVar.RxJ.left, bVar.RxJ.top, bVar.RxJ.right, bVar.RxJ.bottom, bVar.RxI.left, bVar.RxI.top, bVar.RxI.right, bVar.RxI.bottom, bVar.translateX, bVar.translateY, bVar.scale, (float) bVar.ijt, bVar.HmG, bVar.RxH);
                }
            }
            if (this.outputWidth <= 0 || this.outputHeight <= 0) {
                int[] iArr = new int[2];
                GLES31.glBindTexture(3553, i2);
                GLES31.glGetTexLevelParameteriv(3553, 0, 4096, iArr, 0);
                GLES31.glGetTexLevelParameteriv(3553, 0, 4097, iArr, 1);
                this.outputWidth = iArr[0];
                this.outputHeight = iArr[1];
            }
            XEffectLog.d("VLogDirector", "render output size, width:%d, height:%d", Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight));
            nRender(this.Rxd, i2, this.outputWidth, this.outputHeight, j2);
        }
        AppMethodBeat.o(236757);
    }

    public final void b(EffectManager effectManager) {
        AppMethodBeat.i(236758);
        if (!(effectManager == null || effectManager.Rxd == 0 || effectManager.Rxd == this.RxK)) {
            nSetEffectManager(this.Rxd, effectManager.Rxd);
            this.RxK = effectManager.Rxd;
        }
        AppMethodBeat.o(236758);
    }

    private void checkThread() {
        AppMethodBeat.i(236759);
        if (Thread.currentThread().getId() != this.threadId) {
            XEffectLog.e("VLogDirector", "Thread error", new Object[0]);
        }
        AppMethodBeat.o(236759);
    }
}
