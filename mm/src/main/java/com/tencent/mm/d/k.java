package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2encoder;

public final class k implements Cloneable {
    long value;

    public k(byte[] bArr) {
        this(bArr, (byte) 0);
    }

    private k(byte[] bArr, byte b2) {
        AppMethodBeat.i(965);
        this.value = ((long) (bArr[3] << 24)) & 4278190080L;
        this.value += (long) ((bArr[2] << v2encoder.enumCODEC_vcodec2) & 16711680);
        this.value += (long) ((bArr[1] << 8) & 65280);
        this.value += (long) (bArr[0] & 255);
        AppMethodBeat.o(965);
    }

    public k(long j2) {
        this.value = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof k) || this.value != ((k) obj).value) {
            return false;
        }
        return true;
    }

    public final byte[] getBytes() {
        return new byte[]{(byte) ((int) (this.value & 255)), (byte) ((int) ((this.value & 65280) >> 8)), (byte) ((int) ((this.value & 16711680) >> 16)), (byte) ((int) ((this.value & 4278190080L) >> 24))};
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
