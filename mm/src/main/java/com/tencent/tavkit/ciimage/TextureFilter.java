package com.tencent.tavkit.ciimage;

import android.graphics.Matrix;
import android.opengl.EGL14;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
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

/* access modifiers changed from: package-private */
public class TextureFilter {
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final String FRAGMENT_SHADER = "uniform sampler2D sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
    private static final String FRAGMENT_SHADER_END = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
    private static final String FRAGMENT_SHADER_OES = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
    private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
    private static final String VERTEX_SHADER = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
    private final String TAG = ("TextureFilter@" + Integer.toHexString(hashCode()));
    private int aPositionHandle;
    private GLBlendStateCache glBlendStateCache;
    private int outputFrameBufferId = -1;
    private TextureInfo outputTextureInfo = null;
    protected int program;
    private int rendererHeight;
    private int rendererWidth;
    private final int[] shaderIndexes = new int[2];
    private int stMatrixHandle;
    private FloatBuffer triangleVertices;
    private int uAlphaHandle;
    private int uMatrixHandle;
    private int uScreenSizeHandle;
    private int uTextureSizeHandle;

    public TextureFilter() {
        AppMethodBeat.i(197336);
        Logger.d(this.TAG, "TextureFilter() called");
        AppMethodBeat.o(197336);
    }

    public void setOutputTextureInfo(TextureInfo textureInfo) {
        AppMethodBeat.i(197337);
        if (textureInfo == null) {
            RuntimeException runtimeException = new RuntimeException("outputTextureInfo 为空");
            AppMethodBeat.o(197337);
            throw runtimeException;
        } else if (textureInfo.isReleased()) {
            RuntimeException runtimeException2 = new RuntimeException("outputTextureInfo 已经被释放了");
            AppMethodBeat.o(197337);
            throw runtimeException2;
        } else if (textureInfo.textureType != 3553) {
            RuntimeException runtimeException3 = new RuntimeException("目标纹理类型需要GLES20.GL_TEXTURE_2D");
            AppMethodBeat.o(197337);
            throw runtimeException3;
        } else {
            this.rendererWidth = textureInfo.width;
            this.rendererHeight = textureInfo.height;
            if (!isEqualsCurrentOutputTexture(textureInfo)) {
                checkAndInitFrameBuffer(textureInfo);
            }
            AppMethodBeat.o(197337);
        }
    }

    private boolean isEqualsCurrentOutputTexture(TextureInfo textureInfo) {
        AppMethodBeat.i(197338);
        if (this.outputTextureInfo == null) {
            AppMethodBeat.o(197338);
            return false;
        } else if (this.outputTextureInfo.equals(textureInfo)) {
            AppMethodBeat.o(197338);
            return true;
        } else if (this.outputTextureInfo.textureID == textureInfo.textureID && this.outputTextureInfo.width == textureInfo.width && this.outputTextureInfo.height == textureInfo.height) {
            AppMethodBeat.o(197338);
            return true;
        } else {
            AppMethodBeat.o(197338);
            return false;
        }
    }

    private void checkAndInitFrameBuffer(TextureInfo textureInfo) {
        AppMethodBeat.i(197339);
        int frameBuffer = textureInfo.getFrameBuffer();
        if (frameBuffer == -1) {
            GLES20.glBindTexture(3553, textureInfo.textureID);
            GLES20.glTexImage2D(3553, 0, textureInfo.getFormat(), textureInfo.width, textureInfo.height, 0, textureInfo.getFormat(), NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            frameBuffer = iArr[0];
            GLES20.glBindFramebuffer(36160, frameBuffer);
            RenderContext.checkEglError("glBindFramebuffer outputFrameBufferId");
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, textureInfo.textureID, 0);
            RenderContext.checkEglError("glCheckFramebufferStatus outputFrameBufferId");
            if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
                new RuntimeException("EGL error encountered: FramebufferStatus is not complete.");
                AppMethodBeat.o(197339);
                return;
            }
            GLES20.glBindFramebuffer(36160, 0);
        }
        this.outputFrameBufferId = frameBuffer;
        textureInfo.setFrameBuffer(frameBuffer);
        this.outputTextureInfo = textureInfo;
        AppMethodBeat.o(197339);
    }

    public TextureInfo applyFilter(TextureInfo textureInfo, Matrix matrix, Matrix matrix2, float f2, CGRect cGRect) {
        AppMethodBeat.i(197340);
        if (textureInfo == null) {
            AppMethodBeat.o(197340);
            return null;
        }
        if (this.glBlendStateCache == null) {
            this.glBlendStateCache = new GLBlendStateCache();
        }
        this.glBlendStateCache.cache();
        if (this.program == 0) {
            initShaderForTextureInfo(textureInfo);
        }
        RenderContext.checkEglError("onDrawFrame start");
        if (cGRect == null) {
            cGRect = new CGRect(0.0f, 0.0f, (float) textureInfo.width, (float) textureInfo.height);
        } else {
            cGRect.size.width = Math.min((float) textureInfo.width, cGRect.size.width);
            cGRect.size.height = Math.min((float) textureInfo.height, cGRect.size.height);
        }
        float f3 = cGRect.origin.x + cGRect.size.width;
        if (f3 > ((float) textureInfo.width)) {
            f3 = (float) textureInfo.width;
            Logger.e(this.TAG, "applyFilter: crop right pixel exceed texture width");
        }
        float f4 = cGRect.origin.y + cGRect.size.height;
        if (f4 > ((float) textureInfo.height)) {
            f4 = (float) textureInfo.height;
            Logger.e(this.TAG, "applyFilter: crop bottom pixel exceed texture height");
        }
        float[] fArr = {cGRect.origin.x, f4, cGRect.origin.x, cGRect.origin.y, f3, f4, f3, cGRect.origin.y};
        this.triangleVertices.rewind();
        this.triangleVertices.put(fArr);
        int[] iArr = new int[4];
        GLES20.glGetIntegerv(2978, iArr, 0);
        if (this.outputFrameBufferId != -1) {
            GLES20.glBindFramebuffer(36160, this.outputFrameBufferId);
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
        }
        GLES20.glUseProgram(this.program);
        RenderContext.checkEglError("glUseProgram");
        GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, DecoderUtils.toOpenGL2DMatrix(matrix2), 0);
        GLES20.glUniform1f(this.uAlphaHandle, f2);
        GLES20.glEnable(3042);
        if (!textureInfo.isMixAlpha()) {
            GLES20.glBlendEquationSeparate(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETDEVICELIST, TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETDEVICELIST);
            GLES20.glBlendFuncSeparate(1, 771, 1, 771);
        } else {
            GLES20.glBlendEquationSeparate(TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETDEVICELIST, TraeAudioManager.TraeAudioManagerLooper.MESSAGE_GETDEVICELIST);
            GLES20.glBlendFuncSeparate(770, 771, 1, 771);
        }
        prepareDraw(textureInfo, DecoderUtils.toOpenGL2DMatrix(matrix));
        GLES20.glDrawArrays(5, 0, 4);
        RenderContext.checkEglError("glDrawArrays");
        finishDraw(textureInfo);
        if (this.outputFrameBufferId != -1) {
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        this.glBlendStateCache.restore();
        TextureInfo textureInfo2 = this.outputTextureInfo;
        AppMethodBeat.o(197340);
        return textureInfo2;
    }

    private void initShaderForTextureInfo(TextureInfo textureInfo) {
        AppMethodBeat.i(197341);
        if (textureInfo.textureType == 36197) {
            initShaders(VERTEX_SHADER, FRAGMENT_SHADER_OES);
            AppMethodBeat.o(197341);
            return;
        }
        initShaders(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.o(197341);
    }

    private void initShaders(String str, String str2) {
        AppMethodBeat.i(197342);
        this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.program = Program.createProgram(str, str2, this.shaderIndexes);
        if (this.program == 0) {
            new RuntimeException("failed creating program");
            AppMethodBeat.o(197342);
            return;
        }
        this.aPositionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
        RenderContext.checkEglError("glGetAttribLocation aPosition");
        if (this.aPositionHandle == -1) {
            new RuntimeException("Could not get attribute location for aPosition");
            AppMethodBeat.o(197342);
            return;
        }
        this.uMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMatrix");
        RenderContext.checkEglError("glGetUniformLocation uMatrix");
        if (this.uMatrixHandle == -1) {
            new RuntimeException("Could not get uniform location for uMatrix");
            AppMethodBeat.o(197342);
            return;
        }
        this.uAlphaHandle = GLES20.glGetUniformLocation(this.program, "uAlpha");
        RenderContext.checkEglError("glGetUniformLocation uAlpha");
        if (this.uAlphaHandle == -1) {
            new RuntimeException("Could not get uniform location for uAlpha");
            AppMethodBeat.o(197342);
            return;
        }
        this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
        RenderContext.checkEglError("glGetUniformLocation stMatrix");
        if (this.stMatrixHandle == -1) {
            new RuntimeException("Could not get uniform location for stMatrix");
            AppMethodBeat.o(197342);
            return;
        }
        this.uScreenSizeHandle = GLES20.glGetUniformLocation(this.program, "uScreenSize");
        RenderContext.checkEglError("glGetUniformLocation uScreenSize");
        if (this.uScreenSizeHandle == -1) {
            new RuntimeException("Could not get uniform location for uScreenSize");
            AppMethodBeat.o(197342);
            return;
        }
        this.uTextureSizeHandle = GLES20.glGetUniformLocation(this.program, "uTextureSize");
        RenderContext.checkEglError("glGetUniformLocation uTextureSize");
        if (this.uTextureSizeHandle == -1) {
            new RuntimeException("Could not get uniform location for uTextureSize");
        }
        AppMethodBeat.o(197342);
    }

    public void clearBufferBuffer(int i2) {
        AppMethodBeat.i(197343);
        clearBufferBuffer(i2, 0.0f);
        AppMethodBeat.o(197343);
    }

    public void clearBufferBuffer(int i2, float f2) {
        AppMethodBeat.i(197344);
        if (this.outputFrameBufferId != -1) {
            GLES20.glBindFramebuffer(36160, this.outputFrameBufferId);
            GLES20.glClearColor(((float) ((16711680 & i2) >> 16)) / 255.0f, ((float) ((65280 & i2) >> 8)) / 255.0f, ((float) (i2 & 255)) / 255.0f, f2);
            GLES20.glClear(16384);
        }
        AppMethodBeat.o(197344);
    }

    private void prepareDraw(TextureInfo textureInfo, float[] fArr) {
        AppMethodBeat.i(197345);
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
        AppMethodBeat.o(197345);
    }

    private void finishDraw(TextureInfo textureInfo) {
        AppMethodBeat.i(197346);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(textureInfo.textureType, 0);
        AppMethodBeat.o(197346);
    }

    public void release() {
        AppMethodBeat.i(197347);
        Logger.d(this.TAG, "release: start, thread = " + Thread.currentThread().getName() + ", egl = " + EGL14.eglGetCurrentContext());
        if (this.outputTextureInfo != null) {
            GLES20.glDeleteTextures(1, new int[]{this.outputTextureInfo.textureID}, 0);
            this.outputTextureInfo = null;
        }
        if (this.outputFrameBufferId != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.outputFrameBufferId}, 0);
            this.outputFrameBufferId = -1;
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
        Logger.d(this.TAG, "release: end");
        AppMethodBeat.o(197347);
    }

    public String toString() {
        AppMethodBeat.i(197348);
        String str = "TextureFilter{program=" + this.program + ", rendererWidth=" + this.rendererWidth + ", rendererHeight=" + this.rendererHeight + ", outputTextureInfo=" + this.outputTextureInfo + ", outputFrameBufferId=" + this.outputFrameBufferId + '}';
        AppMethodBeat.o(197348);
        return str;
    }
}
