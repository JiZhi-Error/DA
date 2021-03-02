package com.tencent.mm.media.j.b;

import android.opengl.GLES30;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.c.a;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wxmm.v2helper;
import java.nio.Buffer;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 02\u00020\u0001:\u00010B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0014J\u000e\u0010'\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0003H\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u0003H\u0016J\u0018\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0003H\u0016J\u0016\u0010/\u001a\u00020#2\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0003R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00110\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/media/render/proc/RGB2YUVCropRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "(IIIII)V", "attributePosition", "attributeTextureCoord", "hwPixelFormat", "", "hwProgramId", "mInputTexture", "needUpdateMatrix", "rotateIdxMap", "", "[[Ljava/lang/Integer;", "softProgramId", "surfaceHeight", "surfaceWidth", "textureBottom", "", "textureLeft", "textureRight", "textureTop", "uniformFlipX", "uniformFlipY", "uniformTexLeft", "uniformTexture", "uniformUseY", "uniformXOffset", "uniformYOffset", "initDrawCoordBuffer", "", "refreshToHwProgram", "refreshToSoftProgram", "renderImpl", "setHwPixelFormat", "setInputTexture", "texture", "setRotate", "degree", "updateDrawViewSize", "width", "height", "updateSurfaceSize", "Companion", "plugin-mediaeditor_release"})
public final class g extends a {
    public static final a ilh = new a((byte) 0);
    public int hEA;
    private final int hEy;
    private final int hEz;
    public final int ikR;
    public final int ikS;
    public int ikT;
    public int ikU;
    public int ikV;
    public int ikW;
    public int ikX;
    public int ikY;
    public int ikZ;
    private boolean ila;
    private float ilb;
    private float ilc;
    private float ild;
    private float ile;
    public boolean ilf;
    private final Integer[][] ilg;
    public int surfaceHeight;
    public int surfaceWidth;

    static {
        AppMethodBeat.i(218776);
        AppMethodBeat.o(218776);
    }

    public g() {
        this(0, 31);
    }

    private g(int i2) {
        super(0, 0, 0, 0, i2, 1);
        AppMethodBeat.i(218774);
        this.ikZ = -1;
        this.ila = true;
        this.ilc = 1.0f;
        this.ile = 1.0f;
        this.ilf = true;
        c.a aVar = c.ilt;
        a.C0412a aVar2 = com.tencent.mm.media.c.a.idP;
        String str = com.tencent.mm.media.c.a.idL;
        a.C0412a aVar3 = com.tencent.mm.media.c.a.idP;
        this.ikR = c.a.aB(str, com.tencent.mm.media.c.a.idM);
        c.a aVar4 = c.ilt;
        a.C0412a aVar5 = com.tencent.mm.media.c.a.idP;
        String str2 = com.tencent.mm.media.c.a.idN;
        a.C0412a aVar6 = com.tencent.mm.media.c.a.idP;
        this.ikS = c.a.aB(str2, com.tencent.mm.media.c.a.idO);
        this.hEy = 0;
        this.hEz = 1;
        qx(0);
        this.ilg = new Integer[][]{new Integer[]{0, 1, 2, 3}, new Integer[]{2, 0, 3, 1}, new Integer[]{3, 2, 1, 0}, new Integer[]{1, 3, 0, 2}};
        AppMethodBeat.o(218774);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(int i2, int i3) {
        this((i3 & 16) != 0 ? 2 : i2);
        AppMethodBeat.i(218775);
        AppMethodBeat.o(218775);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/render/proc/RGB2YUVCropRenderProc$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void rl(int i2) {
        this.ikZ = i2;
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void cY(int i2, int i3) {
        AppMethodBeat.i(218770);
        int i4 = i3 / 4;
        int i5 = (i2 * 3) / 2;
        if (i4 == this.hEp && i5 == this.hEq) {
            AppMethodBeat.o(218770);
            return;
        }
        float f2 = ((float) i3) / ((float) this.hDo);
        float f3 = ((float) i2) / ((float) this.hDn);
        super.cY(i4, i5);
        if (f2 > f3) {
            this.ilb = (1.0f - (f3 / f2)) / 2.0f;
            this.ilc = 1.0f - this.ilb;
        } else {
            this.ild = (1.0f - (f2 / f3)) / 2.0f;
            this.ile = 1.0f - this.ild;
        }
        Log.i("RGB2YUVRenderProc", "Crop Texture Coordinate: " + this.ilb + ", " + this.ilc + ", " + this.ild + ", " + this.ile);
        this.ila = true;
        AppMethodBeat.o(218770);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void qx(int i2) {
        AppMethodBeat.i(218771);
        int i3 = ((i2 + v2helper.VOIP_ENC_HEIGHT_LV1) - 90) % v2helper.VOIP_ENC_HEIGHT_LV1;
        if (i3 != this.ijt) {
            this.ila = true;
        }
        super.qx(i3);
        AppMethodBeat.o(218771);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.j.b.a
    public final void aMS() {
        AppMethodBeat.i(218772);
        if (!this.ila) {
            AppMethodBeat.o(218772);
            return;
        }
        float[] fArr = {this.ilb, this.ild, this.ilc, this.ild, this.ilb, this.ile, this.ilc, this.ile};
        Integer[] numArr = this.ilg[(this.ijt / 90) % 4];
        float[] fArr2 = new float[8];
        int length = numArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            fArr2[i2 * 2] = fArr[numArr[i2].intValue() * 2];
            fArr2[(i2 * 2) + 1] = fArr[(numArr[i2].intValue() * 2) + 1];
        }
        this.hDT.put(fArr2).position(0);
        this.hDU.position(0);
        this.hDU.put(c.ilm);
        this.hDU.position(0);
        this.ila = false;
        AppMethodBeat.o(218772);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.j.b.a
    public final void aMV() {
        float f2;
        float f3 = 1.0f;
        AppMethodBeat.i(218773);
        if (this.ikZ == -1) {
            AppMethodBeat.o(218773);
            return;
        }
        GLES30.glViewport(0, this.surfaceHeight - this.hEq, this.hEp, this.hEq);
        if (this.ilf) {
            GLES30.glUseProgram(this.ikR);
        } else {
            GLES30.glUseProgram(this.ikS);
            GLES30.glUniform1f(this.ikU, 2.0f / ((float) this.hEq));
        }
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(3553, this.ikZ);
        GLES30.glTexParameteri(3553, 10241, 9729);
        GLES30.glTexParameteri(3553, Task.EXTRAS_LIMIT_BYTES, 9729);
        GLES30.glTexParameteri(3553, 10242, 33071);
        GLES30.glTexParameteri(3553, 10243, 33071);
        GLES30.glUniform1i(this.hEA, 0);
        GLES30.glUniform1f(this.ikY, this.ilb);
        GLES30.glUniform1f(this.ikT, (1.0f / ((float) this.hEp)) / 4.0f);
        GLES30.glUniform1f(this.ikV, (Math.abs(this.ijt) == 90 || Math.abs(this.ijt) == 270) ? 0.0f : 1.0f);
        int i2 = this.ikW;
        if (this.ijt == -90 || this.ijt == 270) {
            f2 = 1.0f;
        } else {
            f2 = 0.0f;
        }
        GLES30.glUniform1f(i2, f2);
        int i3 = this.ikX;
        if (Math.abs(this.ijt) != 180) {
            f3 = 0.0f;
        }
        GLES30.glUniform1f(i3, f3);
        this.hDU.position(0);
        GLES30.glVertexAttribPointer(this.hEy, 2, 5126, false, 0, (Buffer) this.hDU);
        GLES30.glEnableVertexAttribArray(this.hEy);
        this.hDT.position(0);
        GLES30.glVertexAttribPointer(this.hEz, 2, 5126, false, 0, (Buffer) this.hDT);
        GLES30.glEnableVertexAttribArray(this.hEz);
        GLES30.glDrawArrays(5, 0, 4);
        GLES30.glDisableVertexAttribArray(this.hEy);
        GLES30.glDisableVertexAttribArray(this.hEz);
        GLES30.glBindTexture(3553, 0);
        GLES30.glBindTexture(36197, 0);
        AppMethodBeat.o(218773);
    }
}
