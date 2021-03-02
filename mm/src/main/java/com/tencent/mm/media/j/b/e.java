package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import java.nio.Buffer;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "inputTexture", "programId", "uniformMatrix", "uniformTexture", "renderImpl", "", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public class e extends a {
    public int hDl;
    private int hEA;
    private int hEy;
    private int hEz;
    private int ikw;
    private int programId;

    public e(int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i2, i3, i4, i5, i6, i7);
        AppMethodBeat.i(93862);
        this.hDl = -1;
        c.a aVar = c.ilt;
        this.programId = c.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
        this.hEy = GLES20.glGetAttribLocation(this.programId, "a_position");
        this.hEz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
        this.hEA = GLES20.glGetUniformLocation(this.programId, "texture");
        this.ikw = GLES20.glGetUniformLocation(this.programId, "uMatrix");
        AppMethodBeat.o(93862);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ e(int r9, int r10, int r11, int r12, int r13, int r14, int r15) {
        /*
            r8 = this;
            r7 = 218769(0x35691, float:3.0656E-40)
            r6 = 1
            r0 = r15 & 4
            if (r0 == 0) goto L_0x002a
            r3 = r9
        L_0x0009:
            r0 = r15 & 8
            if (r0 == 0) goto L_0x0028
            r4 = r10
        L_0x000e:
            r0 = r15 & 16
            if (r0 == 0) goto L_0x0026
            r5 = r6
        L_0x0013:
            r0 = r15 & 32
            if (r0 == 0) goto L_0x0024
        L_0x0017:
            r0 = r8
            r1 = r9
            r2 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            return
        L_0x0024:
            r6 = r14
            goto L_0x0017
        L_0x0026:
            r5 = r13
            goto L_0x0013
        L_0x0028:
            r4 = r12
            goto L_0x000e
        L_0x002a:
            r3 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.j.b.e.<init>(int, int, int, int, int, int, int):void");
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void rl(int i2) {
        this.hDl = i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.j.b.a
    public final void aMV() {
        AppMethodBeat.i(93861);
        if (this.hDl != -1) {
            GLES20.glUseProgram(this.programId);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.hDl);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 10497.0f);
            GLES20.glTexParameterf(3553, 10243, 10497.0f);
            GLES20.glUniform1i(this.hEA, 0);
            GLES20.glUniformMatrix4fv(this.ikw, 1, false, this.ijG, 0);
            this.hDU.position(0);
            GLES20.glVertexAttribPointer(this.hEy, 2, 5126, false, 0, (Buffer) this.hDU);
            GLES20.glEnableVertexAttribArray(this.hEy);
            this.hDT.position(0);
            GLES20.glVertexAttribPointer(this.hEz, 2, 5126, false, 0, (Buffer) this.hDT);
            GLES20.glEnableVertexAttribArray(this.hEz);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.hEy);
            GLES20.glDisableVertexAttribArray(this.hEz);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindTexture(36197, 0);
        }
        AppMethodBeat.o(93861);
    }
}
