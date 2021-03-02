package com.tencent.liteav.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class TXCYuvTextureRender {
    private static final int BYTES_PER_FLOAT = 4;
    private static final int INVALID_TEXTURE_ID = -12345;
    private static final int POSITION_COMPONENT_COUNT = 2;
    private static final String TAG = TXCYuvTextureRender.class.getSimpleName();
    private static final int TEXTURE_COORDINATES_COMPONENT_COUNT = 2;
    private static final String mFragmentShaderCode = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D yTexture;\nuniform sampler2D uTexture;\nuniform mat3 convertMatrix;\nuniform vec3 offset;\n\nvoid main()\n{\n    highp vec3 yuvColor;\n    highp vec3 rgbColor;\n\n    // Get the YUV values\n    yuvColor.x = texture2D(yTexture, textureCoordinate).r;\n    yuvColor.y = texture2D(uTexture, vec2(textureCoordinate.x * 0.5, textureCoordinate.y * 0.5)).r;\n    yuvColor.z = texture2D(uTexture, vec2(textureCoordinate.x * 0.5, textureCoordinate.y * 0.5 + 0.5)).r;\n\n    // Do the color transform   \n    yuvColor += offset;\n    rgbColor = convertMatrix * yuvColor; \n\n    gl_FragColor = vec4(rgbColor, 1.0);\n}\n";
    private static final String mVertexShaderCode = "uniform mat4 uMatrix;uniform mat4 uTextureMatrix;attribute vec2 position;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {vec4 pos  = vec4(position, 0.0, 1.0);gl_Position = uMatrix * pos;textureCoordinate = (uTextureMatrix*vec4(inputTextureCoordinate, 0.0, 0.0)).xy;}";
    float[] bt601_fullrage_ffmpeg_matrix = {1.0f, 1.0f, 1.0f, 0.0f, -0.3441f, 1.772f, 1.402f, -0.7141f, 0.0f};
    float[] bt601_fullrange_ffmpeg_offset = {0.0f, -0.5019608f, -0.5019608f};
    float[] bt601_videorage_ffmpeg_matrix = {1.1644f, 1.1644f, 1.1644f, 0.0f, -0.3918f, 2.0172f, 1.596f, -0.813f, 0.0f};
    float[] bt601_videorange_ffmpeg_offset = {-0.0627451f, -0.5019608f, -0.5019608f};
    private final int def_InputType_YUVJ420 = 4;
    private int mConvertMatrixUniform = -1;
    private int mConvertOffsetUniform = -1;
    private int mFrameBufferID = INVALID_TEXTURE_ID;
    private int mFrameBufferTextureID = INVALID_TEXTURE_ID;
    private int mHeight;
    private short[] mIndices = {0, 1, 2, 1, 3, 2};
    private ShortBuffer mIndicesBuffer;
    private float[] mMVPMatrix = new float[16];
    private boolean mNeedReLoadFrameBuffer = false;
    private int mPositionHandle;
    private int mProgram;
    private int mRawDataFrameType = -1;
    private FloatBuffer mTextureBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private int mTextureCoordinatesHandle;
    private int[] mTextureIds;
    private float[] mTextureMatrix = new float[16];
    private int mTextureMatrixHandle;
    private int mTextureUnitHandle0;
    private int mTextureUnitHandle1;
    private FloatBuffer mVertexBuffer;
    private int mVertexMatrixHandle;
    private float[] mVerticesCoordinates = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private int mVideoHeight = 0;
    private int mVideoWidth = 0;
    private int mWidth;
    private float[] mbt601_fullRange_matrix3 = {1.0f, 1.0f, 1.0f, 0.0f, -0.343f, 1.765f, 1.4f, -0.711f, 0.0f};
    private float[] mbt601_offset_matrix = {0.0f, -0.5f, -0.5f};
    private float[] mbt601_videoRange_matrix3 = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
    private float[] mbt709_videoRange_matrix3 = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

    public static native void nativeLoadTexture(ByteBuffer byteBuffer, int i2, int i3, int[] iArr);

    static {
        AppMethodBeat.i(16749);
        f.f();
        AppMethodBeat.o(16749);
    }

    public TXCYuvTextureRender() {
        AppMethodBeat.i(16741);
        this.mTextureBuffer.put(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        this.mTextureBuffer.position(0);
        this.mVertexBuffer = ByteBuffer.allocateDirect(this.mVerticesCoordinates.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mVertexBuffer.put(this.mVerticesCoordinates);
        this.mVertexBuffer.position(0);
        this.mIndicesBuffer = ByteBuffer.allocateDirect(this.mIndices.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        this.mIndicesBuffer.put(this.mIndices);
        this.mIndicesBuffer.position(0);
        AppMethodBeat.o(16741);
    }

    public void setVideoSize(int i2, int i3) {
        this.mVideoWidth = i2;
        this.mVideoHeight = i3;
    }

    public void createTexture() {
        AppMethodBeat.i(16742);
        int glCreateShader = GLES20.glCreateShader(35633);
        checkError();
        GLES20.glShaderSource(glCreateShader, mVertexShaderCode);
        checkError();
        GLES20.glCompileShader(glCreateShader);
        checkError();
        int glCreateShader2 = GLES20.glCreateShader(35632);
        checkError();
        GLES20.glShaderSource(glCreateShader2, mFragmentShaderCode);
        checkError();
        GLES20.glCompileShader(glCreateShader2);
        this.mProgram = GLES20.glCreateProgram();
        checkError();
        GLES20.glAttachShader(this.mProgram, glCreateShader);
        checkError();
        GLES20.glAttachShader(this.mProgram, glCreateShader2);
        checkError();
        GLES20.glLinkProgram(this.mProgram);
        checkError();
        GLES20.glDeleteShader(glCreateShader);
        GLES20.glDeleteShader(glCreateShader2);
        this.mVertexMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMatrix");
        checkError();
        this.mTextureMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uTextureMatrix");
        checkError();
        this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "position");
        checkError();
        this.mTextureCoordinatesHandle = GLES20.glGetAttribLocation(this.mProgram, "inputTextureCoordinate");
        checkError();
        this.mTextureUnitHandle0 = GLES20.glGetUniformLocation(this.mProgram, "yTexture");
        checkError();
        this.mTextureUnitHandle1 = GLES20.glGetUniformLocation(this.mProgram, "uTexture");
        checkError();
        this.mConvertOffsetUniform = GLES20.glGetUniformLocation(this.mProgram, "offset");
        GLES20.glUniform3fv(this.mConvertOffsetUniform, 1, FloatBuffer.wrap(this.bt601_fullrange_ffmpeg_offset));
        this.mConvertMatrixUniform = GLES20.glGetUniformLocation(this.mProgram, "convertMatrix");
        GLES20.glUniformMatrix3fv(this.mConvertMatrixUniform, 1, false, this.bt601_fullrage_ffmpeg_matrix, 0);
        this.mTextureIds = new int[2];
        GLES20.glGenTextures(2, this.mTextureIds, 0);
        AppMethodBeat.o(16742);
    }

    public void onSurfaceDestroy() {
        AppMethodBeat.i(16743);
        if (this.mTextureIds != null) {
            GLES20.glDeleteTextures(2, this.mTextureIds, 0);
            this.mTextureIds = null;
        }
        destroyFrameBuffer();
        GLES20.glDeleteProgram(this.mProgram);
        AppMethodBeat.o(16743);
    }

    public void setHasFrameBuffer(int i2, int i3) {
        if (this.mWidth != i2 || this.mHeight != i3) {
            this.mWidth = i2;
            this.mHeight = i3;
            this.mNeedReLoadFrameBuffer = true;
        }
    }

    public void flipVertical(boolean z) {
        float[] fArr;
        AppMethodBeat.i(222345);
        if (z) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        } else {
            fArr = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        }
        this.mTextureBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTextureBuffer.put(fArr);
        this.mTextureBuffer.position(0);
        AppMethodBeat.o(222345);
    }

    private void reloadFrameBuffer() {
        AppMethodBeat.i(16744);
        if (!this.mNeedReLoadFrameBuffer) {
            AppMethodBeat.o(16744);
            return;
        }
        TXCLog.i(TAG, "reloadFrameBuffer. size = " + this.mWidth + "*" + this.mHeight);
        destroyFrameBuffer();
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.mFrameBufferTextureID = iArr[0];
        this.mFrameBufferID = iArr2[0];
        TXCLog.d(TAG, "frameBuffer id = " + this.mFrameBufferID + ", texture id = " + this.mFrameBufferTextureID);
        GLES20.glBindTexture(3553, this.mFrameBufferTextureID);
        GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, this.mWidth, this.mHeight, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glBindFramebuffer(36160, this.mFrameBufferID);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFrameBufferTextureID, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        this.mNeedReLoadFrameBuffer = false;
        AppMethodBeat.o(16744);
    }

    private void destroyFrameBuffer() {
        AppMethodBeat.i(16745);
        if (this.mFrameBufferID != INVALID_TEXTURE_ID) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.mFrameBufferID}, 0);
            this.mFrameBufferID = INVALID_TEXTURE_ID;
        }
        if (this.mFrameBufferTextureID != INVALID_TEXTURE_ID) {
            GLES20.glDeleteTextures(1, new int[]{this.mFrameBufferTextureID}, 0);
            this.mFrameBufferTextureID = INVALID_TEXTURE_ID;
        }
        AppMethodBeat.o(16745);
    }

    public int drawToTexture(TXSVideoFrame tXSVideoFrame) {
        AppMethodBeat.i(16746);
        reloadFrameBuffer();
        if (this.mFrameBufferID == INVALID_TEXTURE_ID) {
            TXCLog.w(TAG, "invalid frame buffer id");
            AppMethodBeat.o(16746);
            return INVALID_TEXTURE_ID;
        }
        GLES20.glBindFramebuffer(36160, this.mFrameBufferID);
        GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
        drawFrame(tXSVideoFrame);
        GLES20.glBindFramebuffer(36160, 0);
        int i2 = this.mFrameBufferTextureID;
        AppMethodBeat.o(16746);
        return i2;
    }

    public void drawFrame(TXSVideoFrame tXSVideoFrame) {
        AppMethodBeat.i(16747);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        Matrix.setIdentityM(this.mTextureMatrix, 0);
        GLES20.glUseProgram(this.mProgram);
        checkError();
        GLES20.glEnableVertexAttribArray(this.mPositionHandle);
        checkError();
        this.mVertexBuffer.position(0);
        GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 8, (Buffer) this.mVertexBuffer);
        checkError();
        GLES20.glEnableVertexAttribArray(this.mTextureCoordinatesHandle);
        checkError();
        this.mTextureBuffer.position(0);
        GLES20.glVertexAttribPointer(this.mTextureCoordinatesHandle, 2, 5126, false, 8, (Buffer) this.mTextureBuffer);
        checkError();
        GLES20.glUniformMatrix4fv(this.mVertexMatrixHandle, 1, false, this.mMVPMatrix, 0);
        checkError();
        GLES20.glUniformMatrix4fv(this.mTextureMatrixHandle, 1, false, this.mTextureMatrix, 0);
        checkError();
        int i2 = tXSVideoFrame.frameType;
        if (4 == i2) {
            GLES20.glUniform3fv(this.mConvertOffsetUniform, 1, FloatBuffer.wrap(this.bt601_fullrange_ffmpeg_offset));
            GLES20.glUniformMatrix3fv(this.mConvertMatrixUniform, 1, false, this.bt601_fullrage_ffmpeg_matrix, 0);
            if (i2 != this.mRawDataFrameType) {
                this.mRawDataFrameType = i2;
                TXCLog.i(TAG, " frame type " + i2 + " matrix_test fullRange");
            }
        } else {
            GLES20.glUniform3fv(this.mConvertOffsetUniform, 1, FloatBuffer.wrap(this.bt601_videorange_ffmpeg_offset));
            GLES20.glUniformMatrix3fv(this.mConvertMatrixUniform, 1, false, this.bt601_videorage_ffmpeg_matrix, 0);
            if (i2 != this.mRawDataFrameType) {
                this.mRawDataFrameType = i2;
                TXCLog.i(TAG, " frame type " + i2 + " matrix_test videoRange");
            }
        }
        GLES20.glUniform1i(this.mTextureUnitHandle0, 0);
        checkError();
        GLES20.glUniform1i(this.mTextureUnitHandle1, 1);
        checkError();
        if (!(tXSVideoFrame.buffer == null || this.mTextureIds == null)) {
            nativeLoadTexture(tXSVideoFrame.buffer, tXSVideoFrame.width, tXSVideoFrame.height, this.mTextureIds);
        }
        tXSVideoFrame.release();
        GLES20.glDrawElements(4, this.mIndices.length, 5123, this.mIndicesBuffer);
        GLES20.glDisableVertexAttribArray(this.mPositionHandle);
        GLES20.glDisableVertexAttribArray(this.mTextureCoordinatesHandle);
        AppMethodBeat.o(16747);
    }

    public int checkError() {
        AppMethodBeat.i(16748);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("gl error=".concat(String.valueOf(glGetError)));
            AppMethodBeat.o(16748);
            throw illegalStateException;
        }
        AppMethodBeat.o(16748);
        return glGetError;
    }
}
