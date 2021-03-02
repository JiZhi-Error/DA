package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\u0006\u0010\u0018\u001a\u00020\u0014J\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\nJ\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0016R\u000e\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "(IIII)V", "animationCost", "animationScale", "", "animationStartTime", "", "drawHeightStart", "drawWidthStart", "isScale", "", "originalDrawHeight", "originalDrawWidth", "beforeRender", "", "endScaleAnimation", "time", "initMatrixTemp", "reset", "startScaleAnimation", "scale", "updateDrawViewSize", "width", "height", "plugin-core_release"})
public final class f extends e {
    private int hDF;
    private int hDG;
    private long hDH;
    private int hDI;
    private float hDJ;
    public int hDK;
    public int hDL;
    private boolean hDM;

    public f(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5, 1, 1);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void aEB() {
        AppMethodBeat.i(196650);
        if (System.currentTimeMillis() - this.hDH <= ((long) this.hDI)) {
            if (this.hDM) {
                float currentTimeMillis = (((float) (System.currentTimeMillis() - this.hDH)) * (1.0f - this.hDJ)) / ((float) this.hDI);
                this.hEp = (int) (((float) this.hDF) * (1.0f - currentTimeMillis));
                this.hEq = (int) ((1.0f - currentTimeMillis) * ((float) this.hDG));
            } else {
                float currentTimeMillis2 = (((float) (System.currentTimeMillis() - this.hDH)) * (1.0f - this.hDJ)) / ((float) this.hDI);
                this.hEp = (int) (((float) this.hDF) * (this.hDJ + currentTimeMillis2));
                this.hEq = (int) ((currentTimeMillis2 + this.hDJ) * ((float) this.hDG));
                if (this.hEp > this.hDF) {
                    this.hEp = this.hDF;
                }
                if (this.hEq > this.hDG) {
                    this.hEp = this.hDG;
                }
            }
            this.hDK = (this.hDF - this.hEp) / 2;
            this.hDL = (this.hDG - this.hEq) / 2;
        }
        Matrix.setIdentityM(this.ijG, 0);
        Matrix.setRotateM(this.ijG, 0, (float) this.ijt, 0.0f, 0.0f, -1.0f);
        if (this.iju) {
            Matrix.scaleM(this.ijG, 0, -1.0f, 1.0f, 1.0f);
        }
        if (this.scaleType == 5) {
            E(((float) this.hEp) / ((float) this.hEq), ((float) this.hDn) / ((float) this.hDo));
        }
        aMS();
        aMT();
        GLES20.glViewport(this.hDK, this.hDL, this.hEp, this.hEq);
        AppMethodBeat.o(196650);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void cY(int i2, int i3) {
        AppMethodBeat.i(196651);
        super.cY(i2, i3);
        this.hDF = i2;
        this.hDG = i3;
        AppMethodBeat.o(196651);
    }
}
