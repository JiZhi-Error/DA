package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public interface m {
    int a(f fVar, int i2, boolean z);

    void a(long j2, int i2, int i3, int i4, a aVar);

    void a(com.google.android.exoplayer2.i.m mVar, int i2);

    void f(Format format);

    public static final class a {
        public final int bhd;
        public final int bhe;
        public final int big;
        public final byte[] bih;

        public a(int i2, byte[] bArr, int i3, int i4) {
            this.big = i2;
            this.bih = bArr;
            this.bhd = i3;
            this.bhe = i4;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(92188);
            if (this == obj) {
                AppMethodBeat.o(92188);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.o(92188);
                return false;
            } else {
                a aVar = (a) obj;
                if (this.big == aVar.big && this.bhd == aVar.bhd && this.bhe == aVar.bhe && Arrays.equals(this.bih, aVar.bih)) {
                    AppMethodBeat.o(92188);
                    return true;
                }
                AppMethodBeat.o(92188);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(92189);
            int hashCode = (((((this.big * 31) + Arrays.hashCode(this.bih)) * 31) + this.bhd) * 31) + this.bhe;
            AppMethodBeat.o(92189);
            return hashCode;
        }
    }
}
