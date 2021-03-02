package com.tencent.mm.plugin.recordvideo.background.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public final class b extends a {
    private final float[] BLg = {-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
    private final float[] BLh = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private FloatBuffer BLi;
    private FloatBuffer BLj;
    private int BLk;
    private int BLl;
    private int BLm;
    private int BLn;
    private int BLo;

    public b() {
        AppMethodBeat.i(74995);
        AppMethodBeat.o(74995);
    }

    public final void eJi() {
        AppMethodBeat.i(74996);
        Log.i("MicroMsg.Story.FadeImageShader", "comipleAndLinkProgram");
        int[] iArr = new int[1];
        int loadShader = loadShader(35633, "attribute vec4 a_position;\nattribute vec2 a_texCoords;\nattribute vec2 a_texBgCoords;\nvarying vec2 v_texCoords;\nvarying vec2 v_texBgCoords;\nuniform mat4 uMVPMatrix; \nvoid main()\n{\n  gl_Position = uMVPMatrix * a_position;\n  v_texCoords = a_texCoords;\n  v_texBgCoords = a_texBgCoords;\n}");
        int loadShader2 = loadShader(35632, "precision mediump float;\nuniform sampler2D u_Texture;\nuniform sampler2D u_TextureBg;\nvarying vec2 v_texCoords;\nvarying vec2 v_texBgCoords;\nuniform float u_texAlphaRatio;\nuniform vec4 centerPic; // 按top bottom left right来传\nvoid main()\n{\n    vec4 fcolor = vec4(0.0);\n    if (gl_FragCoord.y > centerPic[0] || gl_FragCoord.y < centerPic[1] || \n        gl_FragCoord.x > centerPic[3] || gl_FragCoord.x < centerPic[2]) {\n        // >top <bottom >right <left, 不是中间的图片区域，取背景色\n        fcolor = texture2D(u_TextureBg, v_texBgCoords);\n    } else {\n        fcolor = texture2D(u_Texture, v_texCoords);\n    } \n    fcolor.a *= u_texAlphaRatio;\n    gl_FragColor = fcolor;\n}");
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram == 0) {
            AppMethodBeat.o(74996);
            return;
        }
        GLES20.glAttachShader(glCreateProgram, loadShader);
        GLES20.glAttachShader(glCreateProgram, loadShader2);
        GLES20.glBindAttribLocation(glCreateProgram, 0, "a_position");
        GLES20.glBindAttribLocation(glCreateProgram, 1, "a_texCoords");
        GLES20.glBindAttribLocation(glCreateProgram, 2, "a_texBgCoords");
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("MicroMsg.Story.FadeImageShader", "Error linking program:");
            Log.e("MicroMsg.Story.FadeImageShader", GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            AppMethodBeat.o(74996);
            return;
        }
        this.BLm = GLES20.glGetUniformLocation(glCreateProgram, "uMVPMatrix");
        this.BLn = GLES20.glGetUniformLocation(glCreateProgram, "u_texAlphaRatio");
        this.BLo = GLES20.glGetUniformLocation(glCreateProgram, "centerPic");
        this.BLk = GLES20.glGetUniformLocation(glCreateProgram, "u_Texture");
        this.BLl = GLES20.glGetUniformLocation(glCreateProgram, "u_TextureBg");
        this.BLb = glCreateProgram;
        AppMethodBeat.o(74996);
    }

    public final void hT(int i2, int i3) {
        AppMethodBeat.i(74997);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1i(this.BLk, i3);
        AppMethodBeat.o(74997);
    }

    public final void hU(int i2, int i3) {
        AppMethodBeat.i(74998);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1i(this.BLl, i3);
        AppMethodBeat.o(74998);
    }

    public final void m(float[] fArr) {
        AppMethodBeat.i(74999);
        GLES20.glUniformMatrix4fv(this.BLm, 1, false, fArr, 0);
        AppMethodBeat.o(74999);
    }

    public static void eJj() {
        AppMethodBeat.i(75000);
        GLES20.glDrawArrays(5, 0, 4);
        AppMethodBeat.o(75000);
    }

    public final void bK(float f2) {
        AppMethodBeat.i(75001);
        GLES20.glUniform1f(this.BLn, f2);
        AppMethodBeat.o(75001);
    }

    public final void a(int i2, int i3, int i4, int i5, float f2) {
        AppMethodBeat.i(75002);
        long currentTimeMillis = System.currentTimeMillis();
        this.BLi = ByteBuffer.allocateDirect(this.BLg.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.BLi.put(this.BLg).position(0);
        GLES20.glVertexAttribPointer(0, 3, 5126, false, 0, (Buffer) this.BLi);
        GLES20.glEnableVertexAttribArray(0);
        float f3 = ((float) i2) / ((float) i4);
        float f4 = ((float) i3) / ((float) i5);
        float[] copyOf = Arrays.copyOf(this.BLh, this.BLh.length);
        float f5 = 0.0f;
        float f6 = 0.0f;
        if (f3 < f4) {
            f5 = (float) (i4 - ((int) (((float) i2) / f4)));
        } else if (f3 > f4) {
            f6 = (float) (i5 - ((int) (((float) i3) / f3)));
        }
        float f7 = (f5 / 2.0f) / ((float) i4);
        float f8 = 1.0f - f7;
        float f9 = (f6 / 2.0f) / ((float) i5);
        float f10 = 1.0f - f9;
        copyOf[0] = f7;
        copyOf[1] = f10;
        copyOf[2] = f8;
        copyOf[3] = f10;
        copyOf[4] = f7;
        copyOf[5] = f9;
        copyOf[6] = f8;
        copyOf[7] = f9;
        this.BLj = ByteBuffer.allocateDirect(copyOf.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.BLj.put(copyOf).position(0);
        GLES20.glVertexAttribPointer(2, 2, 5126, false, 0, (Buffer) this.BLj);
        GLES20.glEnableVertexAttribArray(2);
        float f11 = 0.0f;
        float f12 = 1.0f;
        float f13 = 0.0f;
        float f14 = 1.0f;
        if (f3 < f4) {
            float f15 = (f4 / f3) - 1.0f;
            f14 = (f15 / 2.0f) + 1.0f;
            f13 = 0.0f - (f15 / 2.0f);
        } else if (f3 > f4) {
            float f16 = (f3 / f4) - 1.0f;
            f12 = (f16 / 2.0f) + 1.0f;
            f11 = 0.0f - (f16 / 2.0f);
        }
        copyOf[0] = f11;
        copyOf[1] = f14;
        copyOf[2] = f12;
        copyOf[3] = f14;
        copyOf[4] = f11;
        copyOf[5] = f13;
        copyOf[6] = f12;
        copyOf[7] = f13;
        this.BLj = ByteBuffer.allocateDirect(copyOf.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.BLj.put(copyOf).position(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) this.BLj);
        GLES20.glEnableVertexAttribArray(1);
        float[] fArr = {(float) i3, 0.0f, 0.0f, (float) i2};
        if (f3 < f4) {
            float f17 = ((float) i5) * f3;
            fArr[0] = (((float) i3) + (f17 * f2)) / 2.0f;
            fArr[1] = (((float) i3) - (f17 * f2)) / 2.0f;
        } else if (f3 > f4) {
            float f18 = ((float) i4) * f4;
            fArr[2] = (((float) i2) - (f18 * f2)) / 2.0f;
            fArr[3] = ((f18 * f2) + ((float) i2)) / 2.0f;
        }
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr).position(0);
        GLES20.glUniform4fv(this.BLo, 1, asFloatBuffer);
        Log.i("MicroMsg.Story.FadeImageShader", "scale cost:" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(75002);
    }
}
