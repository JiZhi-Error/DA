package com.tencent.liteav.basic.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.nio.FloatBuffer;

public class i extends h {
    public boolean r = false;
    private float[] s = new float[16];
    private int t;

    public i() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        AppMethodBeat.i(222205);
        this.o = true;
        AppMethodBeat.o(222205);
    }

    @Override // com.tencent.liteav.basic.c.h
    public boolean b() {
        AppMethodBeat.i(222206);
        boolean b2 = super.b();
        this.t = GLES20.glGetUniformLocation(this.f300a, "textureTransform");
        if (!b2 || GLES20.glGetError() != 0) {
            AppMethodBeat.o(222206);
            return false;
        }
        AppMethodBeat.o(222206);
        return true;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(float[] fArr) {
        this.s = fArr;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        AppMethodBeat.i(222207);
        GLES20.glUseProgram(this.f300a);
        k();
        if (!m() || this.s == null) {
            AppMethodBeat.o(222207);
            return;
        }
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.f301b, 2, 5126, false, 0, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.f301b);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.f303d, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.f303d);
        GLES20.glUniformMatrix4fv(this.t, 1, false, this.s, 0);
        if (i2 != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i2);
            GLES20.glUniform1i(this.f302c, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f301b);
        GLES20.glDisableVertexAttribArray(this.f303d);
        GLES20.glBindTexture(36197, 0);
        AppMethodBeat.o(222207);
    }
}
