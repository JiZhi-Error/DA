package com.tencent.matrix.resource.c.a;

import java.util.Arrays;

public final class b {
    public final byte[] cZp;

    public b(byte[] bArr) {
        int length = bArr.length;
        this.cZp = new byte[length];
        System.arraycopy(bArr, 0, this.cZp, 0, length);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return Arrays.equals(this.cZp, ((b) obj).cZp);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.cZp);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        for (byte b2 : this.cZp) {
            sb.append(Integer.toHexString(b2 & 255));
        }
        return sb.toString();
    }
}
