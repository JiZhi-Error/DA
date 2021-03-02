package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tav.coremedia.TextureInfo;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public class Filter {
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float uAlpha;\nvoid main() {\n   vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
    private static final String FRAGMENT_SHADER_OES = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTextureOES;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTextureOES, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
    private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
    private static final String VERTEX_SHADER = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
    private TextureInfo _textureInfo = null;
    private int aPositionHandle;
    private int bgColor = WebView.NIGHT_MODE_COLOR;
    private int[] defaultViewport = new int[4];
    private int frameBuffer = -1;
    protected int program;
    private boolean renderForScreen = true;
    private int rendererHeight;
    private int rendererWidth;
    private final int[] shaderIndexes = new int[2];
    private int stMatrixHandle;
    private FloatBuffer triangleVertices;
    private int uAlphaHandle;
    private int uMatrixHandle;
    private int uScreenSizeHandle;
    private int uTextureSizeHandle;

    public Filter() {
        AppMethodBeat.i(218197);
        AppMethodBeat.o(218197);
    }

    public void setRenderForScreen(boolean z) {
        this.renderForScreen = z;
    }

    /* access modifiers changed from: protected */
    public void initShaders(String str, String str2) {
        AppMethodBeat.i(218198);
        this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.program = Program.createProgram(str, str2, this.shaderIndexes);
        if (this.program == 0) {
            new RuntimeException("failed creating program");
            AppMethodBeat.o(218198);
            return;
        }
        this.aPositionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
        RenderContext.checkEglError("glGetAttribLocation aPosition");
        if (this.aPositionHandle == -1) {
            new RuntimeException("Could not get attribute location for aPosition");
            AppMethodBeat.o(218198);
            return;
        }
        this.uMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMatrix");
        RenderContext.checkEglError("glGetUniformLocation uMatrix");
        if (this.uMatrixHandle == -1) {
            new RuntimeException("Could not get uniform location for uMatrix");
            AppMethodBeat.o(218198);
            return;
        }
        this.uAlphaHandle = GLES20.glGetUniformLocation(this.program, "uAlpha");
        RenderContext.checkEglError("glGetUniformLocation uAlpha");
        if (this.uAlphaHandle == -1) {
            new RuntimeException("Could not get uniform location for uAlpha");
            AppMethodBeat.o(218198);
            return;
        }
        this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
        RenderContext.checkEglError("glGetUniformLocation stMatrix");
        if (this.stMatrixHandle == -1) {
            new RuntimeException("Could not get uniform location for stMatrix");
            AppMethodBeat.o(218198);
            return;
        }
        this.uScreenSizeHandle = GLES20.glGetUniformLocation(this.program, "uScreenSize");
        RenderContext.checkEglError("glGetUniformLocation uScreenSize");
        if (this.uScreenSizeHandle == -1) {
            new RuntimeException("Could not get uniform location for uScreenSize");
            AppMethodBeat.o(218198);
            return;
        }
        this.uTextureSizeHandle = GLES20.glGetUniformLocation(this.program, "uTextureSize");
        RenderContext.checkEglError("glGetUniformLocation uTextureSize");
        if (this.uTextureSizeHandle == -1) {
            new RuntimeException("Could not get uniform location for uTextureSize");
        }
        AppMethodBeat.o(218198);
    }

    public TextureInfo textureInfo() {
        return this._textureInfo;
    }

    public int getFrameBuffer() {
        return this.frameBuffer;
    }

    private void initFrameBuffer() {
        AppMethodBeat.i(218199);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i2 = iArr[0];
        GLES20.glBindTexture(3553, i2);
        RenderContext.checkEglError("glBindTexture mTextureID");
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        RenderContext.checkEglError("glTexParameter");
        GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGB, this.rendererWidth, this.rendererHeight, 0, NativeBitmapStruct.GLFormat.GL_RGB, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        this._textureInfo = new TextureInfo(i2, 3553, this.rendererWidth, this.rendererHeight, null, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        int i3 = iArr2[0];
        GLES20.glBindFramebuffer(36160, i3);
        RenderContext.checkEglError("glBindFramebuffer frameBuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        RenderContext.checkEglError("glCheckFramebufferStatus frameBuffer");
        if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
            new RuntimeException("EGL error encountered: FramebufferStatus is not complete.");
            AppMethodBeat.o(218199);
            return;
        }
        GLES20.glBindFramebuffer(36160, 0);
        this.frameBuffer = i3;
        AppMethodBeat.o(218199);
    }

    public TextureInfo applyFilter(TextureInfo textureInfo) {
        AppMethodBeat.i(218200);
        TextureInfo applyFilter = applyFilter(textureInfo, null, null, 1.0f);
        AppMethodBeat.o(218200);
        return applyFilter;
    }

    public TextureInfo applyFilter(TextureInfo textureInfo, Matrix matrix, Matrix matrix2) {
        AppMethodBeat.i(218201);
        TextureInfo applyFilter = applyFilter(textureInfo, matrix, matrix2, 1.0f);
        AppMethodBeat.o(218201);
        return applyFilter;
    }

    public TextureInfo applyFilter(TextureInfo textureInfo, Matrix matrix, Matrix matrix2, float f2) {
        AppMethodBeat.i(218202);
        if (!this.renderForScreen && this.frameBuffer == -1) {
            initFrameBuffer();
        }
        if (this.program == 0) {
            initShaderForTextureInfo(textureInfo);
        }
        RenderContext.checkEglError("onDrawFrame start");
        Rectangle rectangle = new Rectangle(0.0f, 0.0f, (float) textureInfo.width, (float) textureInfo.height);
        float[] fArr = {rectangle.x, rectangle.y + rectangle.height, rectangle.x, rectangle.y, rectangle.x + rectangle.width, rectangle.y + rectangle.height, rectangle.x + rectangle.width, rectangle.y};
        this.triangleVertices.rewind();
        this.triangleVertices.put(fArr);
        GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
        if (this.frameBuffer != -1) {
            GLES20.glBindFramebuffer(36160, this.frameBuffer);
            GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
            GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
        }
        GLES20.glUseProgram(this.program);
        RenderContext.checkEglError("glUseProgram");
        GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, DecoderUtils.toOpenGL2DMatrix(matrix2), 0);
        GLES20.glUniform1f(this.uAlphaHandle, f2);
        prepareDraw(textureInfo, DecoderUtils.toOpenGL2DMatrix(matrix));
        GLES20.glClearColor(((float) ((this.bgColor & 16711680) >> 16)) / 255.0f, ((float) ((this.bgColor & 65280) >> 8)) / 255.0f, ((float) (this.bgColor & 255)) / 255.0f, 1.0f);
        GLES20.glClear(16640);
        GLES20.glDrawArrays(5, 0, 4);
        RenderContext.checkEglError("glDrawArrays");
        finishDraw(textureInfo);
        if (this.frameBuffer != -1) {
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(this.defaultViewport[0], this.defaultViewport[1], this.defaultViewport[2], this.defaultViewport[3]);
        }
        if (!this.renderForScreen) {
            TextureInfo textureInfo2 = this._textureInfo;
            AppMethodBeat.o(218202);
            return textureInfo2;
        }
        AppMethodBeat.o(218202);
        return null;
    }

    /* access modifiers changed from: protected */
    public void initShaderForTextureInfo(TextureInfo textureInfo) {
        AppMethodBeat.i(218203);
        if (textureInfo.textureType == 36197) {
            initShaders(VERTEX_SHADER, FRAGMENT_SHADER_OES);
            AppMethodBeat.o(218203);
            return;
        }
        initShaders(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.o(218203);
    }

    /* access modifiers changed from: protected */
    public void prepareDraw(TextureInfo textureInfo, float[] fArr) {
        AppMethodBeat.i(218204);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(textureInfo.textureType, textureInfo.textureID);
        this.triangleVertices.position(0);
        GLES20.glVertexAttribPointer(this.aPositionHandle, 2, 5126, false, 8, (Buffer) this.triangleVertices);
        RenderContext.checkEglError("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.aPositionHandle);
        RenderContext.checkEglError("glEnableVertexAttribArray aPositionHandle");
        GLES20.glUniformMatrix3fv(this.uMatrixHandle, 1, false, fArr, 0);
        GLES20.glUniform2f(this.uTextureSizeHandle, (float) textureInfo.width, (float) textureInfo.height);
        GLES20.glUniform2f(this.uScreenSizeHandle, (float) this.rendererWidth, (float) this.rendererHeight);
        AppMethodBeat.o(218204);
    }

    /* access modifiers changed from: protected */
    public void finishDraw(TextureInfo textureInfo) {
        AppMethodBeat.i(218205);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(textureInfo.textureType, 0);
        AppMethodBeat.o(218205);
    }

    public void release() {
        AppMethodBeat.i(218206);
        if (this.frameBuffer != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.frameBuffer}, 0);
            this.frameBuffer = -1;
        }
        if (this._textureInfo != null) {
            GLES20.glDeleteTextures(1, new int[]{this._textureInfo.textureID}, 0);
            this._textureInfo = null;
        }
        if (this.program > 0) {
            GLES20.glDeleteProgram(this.program);
            this.program = 0;
        }
        for (int i2 = 0; i2 < this.shaderIndexes.length; i2++) {
            if (this.shaderIndexes[i2] > 0) {
                GLES20.glDeleteShader(this.shaderIndexes[i2]);
                this.shaderIndexes[i2] = 0;
            }
        }
        AppMethodBeat.o(218206);
    }

    public Filter clone() {
        AppMethodBeat.i(218207);
        Filter filter = new Filter();
        AppMethodBeat.o(218207);
        return filter;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(218208);
        if (this == obj) {
            AppMethodBeat.o(218208);
            return true;
        } else if (obj.getClass() != getClass()) {
            AppMethodBeat.o(218208);
            return false;
        } else {
            Filter filter = (Filter) obj;
            if (this.rendererHeight == filter.rendererHeight && this.rendererWidth == filter.rendererWidth && this.renderForScreen == filter.renderForScreen) {
                AppMethodBeat.o(218208);
                return true;
            }
            AppMethodBeat.o(218208);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(218209);
        int hashCode = (((((this.renderForScreen ? 1 : 0) + ((((((((((((((((((this.program + 0) * 31) + this.uScreenSizeHandle) * 31) + this.uTextureSizeHandle) * 31) + this.uMatrixHandle) * 31) + this.uAlphaHandle) * 31) + this.stMatrixHandle) * 31) + this.aPositionHandle) * 31) + this.rendererWidth) * 31) + this.rendererHeight) * 31)) * 31) + this.frameBuffer) * 31) + Arrays.hashCode(this.defaultViewport);
        AppMethodBeat.o(218209);
        return hashCode;
    }

    public void setBgColor(int i2) {
        this.bgColor = i2;
    }

    public void setRendererHeight(int i2) {
        this.rendererHeight = i2;
    }

    public int getRendererHeight() {
        return this.rendererHeight;
    }

    public int getRendererWidth() {
        return this.rendererWidth;
    }

    public void setRendererWidth(int i2) {
        this.rendererWidth = i2;
    }
}
