package com.tencent.mm.plugin.recordvideo.background.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.b.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public final class f extends a {
    public final float[] BLK = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private final float[] BLg = {-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
    private final float[] BLh = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private FloatBuffer BLi;
    private FloatBuffer BLj;
    private int BLk;
    private int BLm;

    public f() {
        AppMethodBeat.i(75012);
        AppMethodBeat.o(75012);
    }

    public final void eJi() {
        AppMethodBeat.i(75013);
        int[] iArr = new int[1];
        int loadShader = loadShader(35633, "attribute vec4 a_position;    \nattribute vec2 a_texCoords; \nvarying vec2 v_texCoords; \nuniform mat4 uMVPMatrix; \nvoid main()                  \n{                            \n   gl_Position = uMVPMatrix * a_position;  \n    v_texCoords = a_texCoords; \n}                            \n");
        int loadShader2 = loadShader(35632, "precision mediump float;\t\t\t\t\t  \nuniform sampler2D u_Texture; \nvarying vec2 v_texCoords; \nvoid main()                                  \n{                                            \n  vec4 fcolor = texture2D(u_Texture, v_texCoords) ;\n  gl_FragColor = fcolor ;\n}                                            \n");
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram == 0) {
            AppMethodBeat.o(75013);
            return;
        }
        GLES20.glAttachShader(glCreateProgram, loadShader);
        GLES20.glAttachShader(glCreateProgram, loadShader2);
        GLES20.glBindAttribLocation(glCreateProgram, 0, "a_position");
        GLES20.glBindAttribLocation(glCreateProgram, 1, "a_texCoords");
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glGetProgramInfoLog(glCreateProgram);
            GLES20.glDeleteProgram(glCreateProgram);
            AppMethodBeat.o(75013);
            return;
        }
        this.BLm = GLES20.glGetUniformLocation(glCreateProgram, "uMVPMatrix");
        this.BLk = GLES20.glGetUniformLocation(glCreateProgram, "u_Texture");
        this.BLb = glCreateProgram;
        AppMethodBeat.o(75013);
    }

    public final void Vz(int i2) {
        AppMethodBeat.i(75014);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1f(this.BLk, 0.0f);
        AppMethodBeat.o(75014);
    }

    public final void m(float[] fArr) {
        AppMethodBeat.i(75015);
        GLES20.glUniformMatrix4fv(this.BLm, 1, false, fArr, 0);
        AppMethodBeat.o(75015);
    }

    public static void eJj() {
        AppMethodBeat.i(75016);
        GLES20.glDrawArrays(5, 0, 4);
        AppMethodBeat.o(75016);
    }

    public final void a(a.EnumC1641a aVar, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        AppMethodBeat.i(75017);
        long currentTimeMillis = System.currentTimeMillis();
        float f4 = ((float) i2) / ((float) i4);
        float f5 = ((float) i3) / ((float) i5);
        float f6 = -1.0f;
        float f7 = 1.0f;
        float f8 = 1.0f;
        float f9 = -1.0f;
        float f10 = 0.0f;
        float f11 = 1.0f;
        float[] copyOf = Arrays.copyOf(this.BLh, this.BLh.length);
        float[] copyOf2 = Arrays.copyOf(this.BLg, this.BLg.length);
        switch (aVar) {
            case CenterCrop:
                float f12 = 0.0f;
                float f13 = 0.0f;
                if (f4 < f5) {
                    f12 = (float) (i4 - ((int) (((float) i2) / f5)));
                } else if (f4 > f5) {
                    f13 = (float) (i5 - ((int) (((float) i3) / f4)));
                }
                float f14 = (f12 / 2.0f) / ((float) i4);
                f3 = (f13 / 2.0f) / ((float) i5);
                f2 = 1.0f - f3;
                f11 = 1.0f - f14;
                f10 = f14;
                break;
            case Default:
            case CenterInside:
                float f15 = (float) i2;
                float f16 = (float) i3;
                if (f4 < f5) {
                    f16 = ((float) i5) * f4;
                } else if (f4 > f5) {
                    f15 = ((float) i4) * f5;
                }
                f7 = f15 / ((float) i2);
                f6 = 0.0f - f7;
                f8 = f16 / ((float) i3);
                f9 = 0.0f - f8;
                f2 = 1.0f;
                f3 = 0.0f;
                break;
            default:
                f2 = 1.0f;
                f3 = 0.0f;
                break;
        }
        copyOf[0] = f10;
        copyOf[1] = f2;
        copyOf[2] = f11;
        copyOf[3] = f2;
        copyOf[4] = f10;
        copyOf[5] = f3;
        copyOf[6] = f11;
        copyOf[7] = f3;
        copyOf2[0] = f6;
        copyOf2[1] = f9;
        copyOf2[3] = f7;
        copyOf2[4] = f9;
        copyOf2[6] = f6;
        copyOf2[7] = f8;
        copyOf2[9] = f7;
        copyOf2[10] = f8;
        this.BLi = ByteBuffer.allocateDirect(copyOf2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.BLi.put(copyOf2).position(0);
        GLES20.glVertexAttribPointer(0, 3, 5126, false, 0, (Buffer) this.BLi);
        GLES20.glEnableVertexAttribArray(0);
        this.BLj = ByteBuffer.allocateDirect(copyOf.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.BLj.put(copyOf).position(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) this.BLj);
        GLES20.glEnableVertexAttribArray(1);
        new StringBuilder("scale cost:").append(System.currentTimeMillis() - currentTimeMillis);
        AppMethodBeat.o(75017);
    }
}
