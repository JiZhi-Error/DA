package com.tencent.mm.cm.a;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class a {
    private final LinkedList<Runnable> Rfa;
    private final String Rfb;
    private final String Rfc;
    protected int Rfd;
    protected int Rfe;
    protected int Rff;
    protected int Rfg;
    boolean Rfh;
    protected int mOutputHeight;
    protected int mOutputWidth;

    public a() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public a(String str, String str2) {
        AppMethodBeat.i(190218);
        this.Rfa = new LinkedList<>();
        this.Rfb = str;
        this.Rfc = str2;
        AppMethodBeat.o(190218);
    }

    public final void init() {
        AppMethodBeat.i(190219);
        MC();
        this.Rfh = true;
        AppMethodBeat.o(190219);
    }

    public void MC() {
        int ac;
        int i2 = 0;
        AppMethodBeat.i(190220);
        String str = this.Rfb;
        String str2 = this.Rfc;
        int[] iArr = new int[1];
        int ac2 = i.ac(str, 35633);
        if (!(ac2 == 0 || (ac = i.ac(str2, 35632)) == 0)) {
            int glCreateProgram = GLES20.glCreateProgram();
            GLES20.glAttachShader(glCreateProgram, ac2);
            GLES20.glAttachShader(glCreateProgram, ac);
            GLES20.glLinkProgram(glCreateProgram);
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] > 0) {
                GLES20.glDeleteShader(ac2);
                GLES20.glDeleteShader(ac);
                i2 = glCreateProgram;
            }
        }
        this.Rfd = i2;
        this.Rfe = GLES20.glGetAttribLocation(this.Rfd, "position");
        this.Rff = GLES20.glGetUniformLocation(this.Rfd, "inputImageTexture");
        this.Rfg = GLES20.glGetAttribLocation(this.Rfd, "inputTextureCoordinate");
        this.Rfh = true;
        AppMethodBeat.o(190220);
    }

    public final void destroy() {
        AppMethodBeat.i(190221);
        this.Rfh = false;
        GLES20.glDeleteProgram(this.Rfd);
        onDestroy();
        AppMethodBeat.o(190221);
    }

    public void onDestroy() {
    }

    public void lS(int i2, int i3) {
        this.mOutputWidth = i2;
        this.mOutputHeight = i3;
    }

    public void a(int i2, int i3, int i4, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        AppMethodBeat.i(190222);
        GLES20.glUseProgram(this.Rfd);
        heZ();
        if (!this.Rfh) {
            AppMethodBeat.o(190222);
            return;
        }
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.Rfe, 2, 5126, false, 8, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.Rfe);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.Rfg, 2, 5126, false, 8, (Buffer) floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.Rfg);
        if (i2 != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i2);
            GLES20.glUniform1i(this.Rff, 0);
        }
        b(floatBuffer2);
        GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.Rfe);
        GLES20.glDisableVertexAttribArray(this.Rfg);
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.o(190222);
    }

    /* access modifiers changed from: protected */
    public void b(FloatBuffer floatBuffer) {
    }

    /* access modifiers changed from: protected */
    public final void heZ() {
        AppMethodBeat.i(190223);
        while (!this.Rfa.isEmpty()) {
            this.Rfa.removeFirst().run();
        }
        AppMethodBeat.o(190223);
    }

    public final int hfa() {
        return this.Rfd;
    }

    public void apH(int i2) {
    }

    public void cH(float f2) {
    }

    /* access modifiers changed from: protected */
    public final void lT(final int i2, final int i3) {
        AppMethodBeat.i(190224);
        aR(new Runnable() {
            /* class com.tencent.mm.cm.a.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(190216);
                GLES20.glUniform1i(i2, i3);
                AppMethodBeat.o(190216);
            }
        });
        AppMethodBeat.o(190224);
    }

    /* access modifiers changed from: protected */
    public final void setFloat(final int i2, final float f2) {
        AppMethodBeat.i(190225);
        aR(new Runnable() {
            /* class com.tencent.mm.cm.a.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(190217);
                GLES20.glUniform1f(i2, f2);
                AppMethodBeat.o(190217);
            }
        });
        AppMethodBeat.o(190225);
    }

    /* access modifiers changed from: protected */
    public final void aR(Runnable runnable) {
        AppMethodBeat.i(190226);
        synchronized (this.Rfa) {
            try {
                this.Rfa.addLast(runnable);
            } finally {
                AppMethodBeat.o(190226);
            }
        }
    }
}
