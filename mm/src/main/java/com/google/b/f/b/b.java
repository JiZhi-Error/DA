package com.google.b.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class b {
    final byte[][] cfD;
    public final int height;
    public final int width;

    public b(int i2, int i3) {
        AppMethodBeat.i(12242);
        this.cfD = (byte[][]) Array.newInstance(Byte.TYPE, i3, i2);
        this.width = i2;
        this.height = i3;
        AppMethodBeat.o(12242);
    }

    public final byte bO(int i2, int i3) {
        return this.cfD[i3][i2];
    }

    public final void set(int i2, int i3, int i4) {
        this.cfD[i3][i2] = (byte) i4;
    }

    public final void set(int i2, int i3, boolean z) {
        this.cfD[i3][i2] = (byte) (z ? 1 : 0);
    }

    public final String toString() {
        AppMethodBeat.i(12243);
        StringBuilder sb = new StringBuilder((this.width * 2 * this.height) + 2);
        for (int i2 = 0; i2 < this.height; i2++) {
            for (int i3 = 0; i3 < this.width; i3++) {
                switch (this.cfD[i2][i3]) {
                    case 0:
                        sb.append(" 0");
                        break;
                    case 1:
                        sb.append(" 1");
                        break;
                    default:
                        sb.append("  ");
                        break;
                }
            }
            sb.append('\n');
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(12243);
        return sb2;
    }
}
