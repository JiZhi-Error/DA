package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import java.nio.Buffer;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0003H\u0016R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributePosition", "attributeTextureCoord", "externalTexture", "getExternalTexture", "()I", "setExternalTexture", "(I)V", "programId", "uniformMatrix", "uniformTexture", "release", "", "renderImpl", "setInputTexture", "texture", "plugin-mediaeditor_release"})
public final class c extends a {
    private int hEA;
    private int hEy;
    private int hEz;
    private int ikw;
    public int ikx;
    private int programId;

    public c(int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i2, i3, i4, i5, i6, i7);
        AppMethodBeat.i(93860);
        this.ikx = -1;
        c.a aVar = com.tencent.mm.media.k.c.ilt;
        this.programId = c.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
        this.hEy = GLES20.glGetAttribLocation(this.programId, "a_position");
        this.hEz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
        this.hEA = GLES20.glGetUniformLocation(this.programId, "texture");
        this.ikw = GLES20.glGetUniformLocation(this.programId, "uMatrix");
        AppMethodBeat.o(93860);
    }

    public /* synthetic */ c(int i2, int i3) {
        this(i2, i3, i2, i3, 2, 1);
        AppMethodBeat.i(218762);
        AppMethodBeat.o(218762);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void rl(int i2) {
        this.ikx = i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.j.b.a
    public final void aMV() {
        AppMethodBeat.i(93858);
        if (this.ikx != -1) {
            GLES20.glUseProgram(this.programId);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, this.ikx);
            GLES20.glTexParameterf(36197, 10241, 9729.0f);
            GLES20.glTexParameterf(36197, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
            GLES20.glTexParameterf(36197, 10242, 33071.0f);
            GLES20.glTexParameterf(36197, 10243, 33071.0f);
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
            GLES20.glBindTexture(36197, 0);
            GLES20.glFinish();
        }
        AppMethodBeat.o(93858);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void release() {
        AppMethodBeat.i(93859);
        super.release();
        GLES20.glDeleteProgram(this.programId);
        AppMethodBeat.o(93859);
    }
}
