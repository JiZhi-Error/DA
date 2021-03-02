package com.tencent.mm.plugin.voip.video.render;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.voip.video.c.d;
import com.tencent.mm.plugin.voip.video.c.h;
import java.nio.FloatBuffer;
import java.util.Arrays;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003J(\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0003J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0014J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0003J\u0018\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "renderSide", "", "textureWidth", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIIII)V", "TAG", "", "inputTexture", "mRenderOnScreenProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipRenderOnScreenProgram;", "renderMode", "beforeRender", "", "drawFrame", "pBuff", "", "w", "h", "flag", "", "getRenderMode", "release", "renderImpl", "setInputTexture", "texture", "setShowMode", "mode", "updateDrawViewSize", "width", "height", "plugin-voip_release"})
public final class l extends a {
    public d Hpi;
    private final String TAG;
    public int hDl;
    int hEi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(int i2, int i3) {
        super(0, 0, 0, 0, i3, 2);
        int i4 = 0;
        AppMethodBeat.i(236334);
        this.Hpi = new d(i2);
        this.hDl = -1;
        this.TAG = "MicroMsg.VoipRenderProcExternalTexture";
        this.hEi = i2 == 0 ? 1 : i4;
        AppMethodBeat.o(236334);
    }

    public /* synthetic */ l(int i2) {
        this(i2, 1);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void rl(int i2) {
        this.hDl = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x03af  */
    @Override // com.tencent.mm.media.j.b.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aMV() {
        /*
        // Method dump skipped, instructions count: 1328
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.video.render.l.aMV():void");
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void release() {
        AppMethodBeat.i(236333);
        super.release();
        d dVar = this.Hpi;
        h hVar = dVar.Hmy;
        if (hVar != null) {
            hVar.HmK.fLF();
        }
        GLES20.glDeleteProgram(dVar.Hmx.programId);
        AppMethodBeat.o(236333);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void aEB() {
        boolean z;
        int i2;
        float f2;
        float f3;
        float f4;
        float f5;
        AppMethodBeat.i(236330);
        float f6 = ((float) this.ijS.x) / ((float) this.hDn);
        float f7 = (((float) this.ijS.y) - 1.0f) / ((float) this.hDo);
        float f8 = (((float) this.ijT.x) - 1.0f) / ((float) this.hDn);
        float f9 = ((float) this.ijT.y) / ((float) this.hDo);
        float[] fArr = c.iln;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        if (this.ijt == 90 || this.ijt == 270) {
            z = true;
        } else {
            z = false;
        }
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
        float f10 = ((float) this.hEp) / ((float) i2);
        float f11 = ((float) this.hEq) / ((float) i3);
        if (f10 < f11) {
            f3 = ((float) i2) - (((float) this.hEp) / f11);
            f2 = 0.0f;
        } else if (f10 > f11) {
            f2 = ((float) i3) - (((float) this.hEq) / f10);
            f3 = 0.0f;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        this.ijO = i2 - ((int) f3);
        this.ijP = i3 - ((int) f2);
        if (z) {
            f5 = (f2 / 2.0f) / ((float) i3);
            f4 = (f3 / 2.0f) / ((float) i2);
        } else {
            f4 = (f2 / 2.0f) / ((float) i3);
            f5 = (f3 / 2.0f) / ((float) i2);
        }
        float f12 = f6 + f5;
        float f13 = f8 - f5;
        float f14 = f9 + f4;
        float f15 = f7 - f4;
        copyOf[0] = f12;
        copyOf[1] = f15;
        copyOf[2] = f13;
        copyOf[3] = f15;
        copyOf[4] = f12;
        copyOf[5] = f14;
        copyOf[6] = f13;
        copyOf[7] = f14;
        this.hDT.position(0);
        FloatBuffer floatBuffer = this.hDT;
        p.g(copyOf, "cropTextureCoord");
        floatBuffer.put(k(copyOf));
        this.hDT.position(0);
        this.hDU.position(0);
        this.hDU.put(c.ilm);
        this.hDU.position(0);
        GLES20.glViewport(0, 0, this.hEp, this.hEq);
        AppMethodBeat.o(236330);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void cY(int i2, int i3) {
        AppMethodBeat.i(236332);
        if (!(i2 == this.hEp && i3 == this.hEq)) {
            super.cY(i2, i3);
            h hVar = this.Hpi.Hmy;
            if (hVar != null) {
                hVar.Hif = i2;
                hVar.Hig = i3;
                AppMethodBeat.o(236332);
                return;
            }
        }
        AppMethodBeat.o(236332);
    }
}
