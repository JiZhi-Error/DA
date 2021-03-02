package com.tencent.tav.core;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.Program;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class MultiTextureFilter {
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float uAlpha;\nvoid main() {\n   vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
    private static final String FRAGMENT_SHADER_OES = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTextureOES;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTextureOES, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
    private static final String TAG = "MultiTextureFilter";
    private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
    private static final String VERTEX_SHADER = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
    private TextureInfo _textureInfo = null;
    private int aPositionHandle;
    private int[] defaultViewport = new int[4];
    private int frameBuffer = -1;
    protected int program;
    private boolean renderForScreen = false;
    private int rendererHeight;
    private int rendererWidth;
    private final int[] shaderIndexes = new int[2];
    private int stMatrixHandle;
    public MultiTextureFilter subFilter;
    private FloatBuffer triangleVertices;
    private int uAlphaHandle;
    private int uMatrixHandle;
    private int uScreenSizeHandle;
    private int uTextureSizeHandle;

    public MultiTextureFilter() {
        AppMethodBeat.i(217915);
        AppMethodBeat.o(217915);
    }

    public void setRenderForScreen(boolean z) {
        this.renderForScreen = z;
    }

    public void setSubFilter(MultiTextureFilter multiTextureFilter) {
        this.subFilter = multiTextureFilter;
    }

    /* access modifiers changed from: protected */
    public void initShaders(String str, String str2) {
        AppMethodBeat.i(217916);
        this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.program = Program.createProgram(str, str2, this.shaderIndexes);
        if (this.program == 0) {
            new RuntimeException("failed creating program");
            AppMethodBeat.o(217916);
            return;
        }
        this.aPositionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
        RenderContext.checkEglError("glGetAttribLocation aPosition");
        if (this.aPositionHandle == -1) {
            new RuntimeException("Could not get attribute location for aPosition");
            AppMethodBeat.o(217916);
            return;
        }
        this.uMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMatrix");
        RenderContext.checkEglError("glGetUniformLocation uMatrix");
        if (this.uMatrixHandle == -1) {
            new RuntimeException("Could not get uniform location for uMatrix");
            AppMethodBeat.o(217916);
            return;
        }
        this.uAlphaHandle = GLES20.glGetUniformLocation(this.program, "uAlpha");
        RenderContext.checkEglError("glGetUniformLocation uAlpha");
        if (this.uAlphaHandle == -1) {
            new RuntimeException("Could not get uniform location for uAlpha");
            AppMethodBeat.o(217916);
            return;
        }
        this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
        RenderContext.checkEglError("glGetUniformLocation stMatrix");
        if (this.stMatrixHandle == -1) {
            new RuntimeException("Could not get uniform location for stMatrix");
            AppMethodBeat.o(217916);
            return;
        }
        this.uScreenSizeHandle = GLES20.glGetUniformLocation(this.program, "uScreenSize");
        RenderContext.checkEglError("glGetUniformLocation uScreenSize");
        if (this.uScreenSizeHandle == -1) {
            new RuntimeException("Could not get uniform location for uScreenSize");
            AppMethodBeat.o(217916);
            return;
        }
        this.uTextureSizeHandle = GLES20.glGetUniformLocation(this.program, "uTextureSize");
        RenderContext.checkEglError("glGetUniformLocation uTextureSize");
        if (this.uTextureSizeHandle == -1) {
            new RuntimeException("Could not get uniform location for uTextureSize");
        }
        AppMethodBeat.o(217916);
    }

    public TextureInfo textureInfo() {
        return this._textureInfo;
    }

    private void initFrameBuffer(TextureInfo textureInfo) {
        AppMethodBeat.i(217917);
        if (textureInfo.textureType != 3553) {
            RuntimeException runtimeException = new RuntimeException("纹理类型不可为OES");
            AppMethodBeat.o(217917);
            throw runtimeException;
        }
        GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGB, this.rendererWidth, this.rendererHeight, 0, NativeBitmapStruct.GLFormat.GL_RGB, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        this._textureInfo = textureInfo;
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i2 = iArr[0];
        GLES20.glBindFramebuffer(36160, i2);
        RenderContext.checkEglError("glBindFramebuffer frameBuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, textureInfo.textureID, 0);
        RenderContext.checkEglError("glCheckFramebufferStatus frameBuffer");
        if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
            new RuntimeException("EGL error encountered: FramebufferStatus is not complete.");
            AppMethodBeat.o(217917);
            return;
        }
        GLES20.glBindFramebuffer(36160, 0);
        this.frameBuffer = i2;
        AppMethodBeat.o(217917);
    }

    public void setDesTextureInfo(TextureInfo textureInfo) {
        AppMethodBeat.i(217918);
        if (this._textureInfo == null || !this._textureInfo.equals(textureInfo)) {
            initFrameBuffer(textureInfo);
        }
        this._textureInfo = textureInfo;
        AppMethodBeat.o(217918);
    }

    public void clearBufferBuffer(int i2) {
        AppMethodBeat.i(217919);
        if (this.frameBuffer != -1) {
            GLES20.glBindFramebuffer(36160, this.frameBuffer);
            GLES20.glClearColor(((float) ((16711680 & i2) >> 16)) / 255.0f, ((float) ((65280 & i2) >> 8)) / 255.0f, ((float) (i2 & 255)) / 255.0f, 1.0f);
            GLES20.glClear(16384);
        }
        AppMethodBeat.o(217919);
    }

    public TextureInfo applyFilter(TextureInfo textureInfo, Matrix matrix, Matrix matrix2, float f2, CGRect cGRect) {
        CGRect cGRect2;
        AppMethodBeat.i(217920);
        if (textureInfo == null) {
            AppMethodBeat.o(217920);
            return null;
        }
        if (!this.renderForScreen && this.frameBuffer == -1) {
            initFrameBuffer(this._textureInfo);
        }
        if (this.program == 0) {
            initShaderForTextureInfo(textureInfo);
        }
        RenderContext.checkEglError("onDrawFrame start");
        if (cGRect == null) {
            cGRect2 = new CGRect(0.0f, 0.0f, (float) textureInfo.width, (float) textureInfo.height);
        } else {
            cGRect.size.width = Math.min((float) textureInfo.width, cGRect.size.width);
            cGRect.size.height = Math.min((float) textureInfo.height, cGRect.size.height);
            cGRect2 = cGRect;
        }
        float f3 = cGRect2.origin.x + cGRect2.size.width;
        if (f3 > ((float) textureInfo.width)) {
            f3 = (float) textureInfo.width;
            Logger.e(TAG, "applyFilter: crop right pixel exceed texture width");
        }
        float f4 = cGRect2.origin.y + cGRect2.size.height;
        if (f4 > ((float) textureInfo.height)) {
            f4 = (float) textureInfo.height;
            Logger.e(TAG, "applyFilter: crop bottom pixel exceed texture height");
        }
        float[] fArr = {cGRect2.origin.x, f4, cGRect2.origin.x, cGRect2.origin.y, f3, f4, f3, cGRect2.origin.y};
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
        GLES20.glDrawArrays(5, 0, 4);
        RenderContext.checkEglError("glDrawArrays");
        finishDraw(textureInfo);
        if (this.frameBuffer != -1) {
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(this.defaultViewport[0], this.defaultViewport[1], this.defaultViewport[2], this.defaultViewport[3]);
        }
        if (this.renderForScreen) {
            if (this.subFilter != null) {
                this.subFilter.applyFilter(this._textureInfo, matrix, matrix2, f2, cGRect2);
            }
            TextureInfo textureInfo2 = this._textureInfo;
            AppMethodBeat.o(217920);
            return textureInfo2;
        }
        AppMethodBeat.o(217920);
        return null;
    }

    /* access modifiers changed from: protected */
    public void initShaderForTextureInfo(TextureInfo textureInfo) {
        AppMethodBeat.i(217921);
        if (textureInfo.textureType == 36197) {
            initShaders(VERTEX_SHADER, FRAGMENT_SHADER_OES);
            AppMethodBeat.o(217921);
            return;
        }
        initShaders(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.o(217921);
    }

    /* access modifiers changed from: protected */
    public void prepareDraw(TextureInfo textureInfo, float[] fArr) {
        AppMethodBeat.i(217922);
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
        AppMethodBeat.o(217922);
    }

    /* access modifiers changed from: protected */
    public void finishDraw(TextureInfo textureInfo) {
        AppMethodBeat.i(217923);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(textureInfo.textureType, 0);
        AppMethodBeat.o(217923);
    }

    public void release() {
        AppMethodBeat.i(217924);
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
        AppMethodBeat.o(217924);
    }

    public MultiTextureFilter clone() {
        AppMethodBeat.i(217925);
        MultiTextureFilter multiTextureFilter = new MultiTextureFilter();
        if (this.subFilter != null) {
            multiTextureFilter.setSubFilter(this.subFilter.clone());
        }
        AppMethodBeat.o(217925);
        return multiTextureFilter;
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
