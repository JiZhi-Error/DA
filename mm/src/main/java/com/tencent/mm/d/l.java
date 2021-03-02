package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l implements Cloneable {
    public int value;

    public l(byte[] bArr) {
        this(bArr, (byte) 0);
    }

    private l(byte[] bArr, byte b2) {
        AppMethodBeat.i(958);
        this.value = (bArr[1] << 8) & 65280;
        this.value += bArr[0] & 255;
        AppMethodBeat.o(958);
    }

    public l(int i2) {
        this.value = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof l) || this.value != ((l) obj).value) {
            return false;
        }
        return true;
    }

    public final byte[] getBytes() {
        return new byte[]{(byte) (this.value & 255), (byte) ((this.value & 65280) >> 8)};
    }

    public final int hashCode() {
        return this.value;
    }
}
