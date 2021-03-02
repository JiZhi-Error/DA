package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FloatBufferInfo {
    public int bufferSize;
    public float[] floatBuffer;
    public float[] tempFloatBuffer;

    public void setFloatBufferCapacity(int i2) {
        if (this.floatBuffer == null || this.floatBuffer.length < i2) {
            this.floatBuffer = new float[i2];
        }
    }

    public void setTempFloatBufferCapacity(int i2) {
        if (this.tempFloatBuffer == null || this.tempFloatBuffer.length < i2) {
            this.tempFloatBuffer = new float[i2];
        }
    }

    public void appendFloat(float[] fArr, int i2, int i3) {
        AppMethodBeat.i(103523);
        if (fArr != null && i2 >= 0 && i3 > 0 && i2 + i3 <= fArr.length) {
            setFloatBufferCapacity(this.bufferSize + i3);
            System.arraycopy(fArr, i2, this.floatBuffer, this.bufferSize, i3);
        }
        AppMethodBeat.o(103523);
    }

    public void fillFloat(float[] fArr, int i2) {
        if (fArr != null && i2 > 0 && i2 <= fArr.length) {
            this.floatBuffer = fArr;
            this.bufferSize = i2;
        }
    }

    public FloatBufferInfo copy(FloatBufferInfo floatBufferInfo) {
        floatBufferInfo.bufferSize = this.bufferSize;
        floatBufferInfo.floatBuffer = this.floatBuffer;
        floatBufferInfo.tempFloatBuffer = this.tempFloatBuffer;
        return floatBufferInfo;
    }
}
