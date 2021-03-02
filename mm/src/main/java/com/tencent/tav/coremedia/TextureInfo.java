package com.tencent.tav.coremedia;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TextureInfo {
    private int format;
    private int frameBuffer;
    public final int height;
    private boolean mixAlpha;
    private boolean needRelease;
    public final int preferRotation;
    private boolean released;
    public final int textureID;
    private Matrix textureMatrix;
    public final int textureType;
    public final int width;

    public TextureInfo(int i2, int i3, int i4, int i5, int i6) {
        this.frameBuffer = -1;
        this.needRelease = false;
        this.mixAlpha = true;
        this.format = NativeBitmapStruct.GLFormat.GL_RGB;
        this.textureMatrix = null;
        this.textureID = i2;
        this.textureType = i3;
        this.width = i4;
        this.height = i5;
        this.preferRotation = i6;
    }

    public TextureInfo(int i2, int i3, int i4, int i5, Matrix matrix, int i6) {
        this.frameBuffer = -1;
        this.needRelease = false;
        this.mixAlpha = true;
        this.format = NativeBitmapStruct.GLFormat.GL_RGB;
        this.textureMatrix = matrix;
        this.textureID = i2;
        this.textureType = i3;
        this.width = i4;
        this.height = i5;
        this.preferRotation = i6;
    }

    public TextureInfo clone() {
        AppMethodBeat.i(199462);
        TextureInfo textureInfo = new TextureInfo(this.textureID, this.textureType, this.width, this.height, this.textureMatrix, this.preferRotation);
        textureInfo.needRelease = true;
        AppMethodBeat.o(199462);
        return textureInfo;
    }

    public int getFrameBuffer() {
        return this.frameBuffer;
    }

    public Matrix getTextureMatrix() {
        return this.textureMatrix;
    }

    public void release() {
        AppMethodBeat.i(199463);
        this.released = true;
        if (this.frameBuffer != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.frameBuffer}, 0);
            this.frameBuffer = -1;
        }
        GLES20.glDeleteTextures(1, new int[]{this.textureID}, 0);
        AppMethodBeat.o(199463);
    }

    public boolean isNeedRelease() {
        return this.needRelease;
    }

    public boolean isReleased() {
        return this.released;
    }

    public void setFrameBuffer(int i2) {
        this.frameBuffer = i2;
    }

    public void setTextureMatrix(Matrix matrix) {
        this.textureMatrix = matrix;
    }

    public boolean isMixAlpha() {
        return this.mixAlpha;
    }

    public void setMixAlpha(boolean z) {
        this.mixAlpha = z;
    }

    public int getFormat() {
        return this.format;
    }

    public void setFormat(int i2) {
        this.format = i2;
    }

    public String toString() {
        AppMethodBeat.i(199464);
        String str = "TextureInfo{textureID=" + this.textureID + ", textureType=" + this.textureType + ", width=" + this.width + ", height=" + this.height + ", preferRotation=" + this.preferRotation + ", textureMatrix=" + this.textureMatrix + ", frameBuffer=" + this.frameBuffer + ", needRelease=" + this.needRelease + ", mixAlpha=" + this.mixAlpha + ", format=" + this.format + '}';
        AppMethodBeat.o(199464);
        return str;
    }
}
