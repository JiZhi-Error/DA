package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.c.a;
import com.tencent.mm.media.k.c;
import java.nio.Buffer;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0016R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/media/render/proc/RGB2YUVRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "(IIIII)V", "attributePosition", "attributeTextureCoord", "mInputTexture", "programId", "uniformMatrix", "uniformTexture", "uniformXOffset", "uniformYuvGap", "renderImpl", "", "setInputTexture", "texture", "updateDrawViewSize", "width", "height", "Companion", "plugin-mediaeditor_release"})
public final class i extends a {
    public static final a ilk = new a((byte) 0);
    private final int hEA;
    private final int hEy;
    private final int hEz;
    private final int ikT;
    public int ikZ;
    private final int ikw;
    private final int ili;
    private final int programId;

    static {
        AppMethodBeat.i(218785);
        AppMethodBeat.o(218785);
    }

    public i() {
        this(0, 31);
    }

    private i(int i2) {
        super(0, 0, 0, 0, i2, 1);
        AppMethodBeat.i(218783);
        this.ikZ = -1;
        c.a aVar = c.ilt;
        a.C0412a aVar2 = com.tencent.mm.media.c.a.idP;
        String str = com.tencent.mm.media.c.a.vertexShaderCode;
        a.C0412a aVar3 = com.tencent.mm.media.c.a.idP;
        this.programId = c.a.aB(str, com.tencent.mm.media.c.a.idJ);
        this.ikT = GLES30.glGetUniformLocation(this.programId, "xoffset");
        this.ili = GLES30.glGetUniformLocation(this.programId, "yuvGap");
        this.hEA = GLES30.glGetUniformLocation(this.programId, "inTexture");
        this.hEy = 0;
        this.hEz = 1;
        this.ikw = GLES20.glGetUniformLocation(this.programId, "uMatrix");
        this.ijH = true;
        AppMethodBeat.o(218783);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(int i2, int i3) {
        this((i3 & 16) != 0 ? 2 : i2);
        AppMethodBeat.i(218784);
        AppMethodBeat.o(218784);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/render/proc/RGB2YUVRenderProc$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
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
        AppMethodBeat.i(218781);
        super.cY(i2 / 4, (i3 * 3) / 2);
        super.dc(i2 / 4, (i3 * 3) / 2);
        AppMethodBeat.o(218781);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.j.b.a
    public final void aMV() {
        AppMethodBeat.i(218782);
        if (this.ikZ == -1) {
            AppMethodBeat.o(218782);
            return;
        }
        GLES30.glUseProgram(this.programId);
        GLES30.glActiveTexture(33984);
        GLES30.glBindTexture(3553, this.ikZ);
        GLES30.glTexParameteri(3553, 10241, 9729);
        GLES30.glTexParameteri(3553, Task.EXTRAS_LIMIT_BYTES, 9729);
        GLES30.glTexParameteri(3553, 10242, 10497);
        GLES30.glTexParameteri(3553, 10243, 10497);
        GLES30.glUniform1i(this.hEA, 0);
        GLES30.glUniform1f(this.ikT, (1.0f / ((float) this.hEp)) / 4.0f);
        GLES30.glUniform1f(this.ili, 0.33333334f);
        GLES30.glUniformMatrix4fv(this.ikw, 1, false, this.ijG, 0);
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
        AppMethodBeat.o(218782);
    }
}
