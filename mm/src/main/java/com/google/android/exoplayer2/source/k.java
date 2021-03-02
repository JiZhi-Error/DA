package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public interface k {

    public interface a {
        void a(w wVar, Object obj);
    }

    j a(b bVar, com.google.android.exoplayer2.h.b bVar2);

    void a(f fVar, a aVar);

    void b(j jVar);

    void vt();

    void vu();

    public static final class b {
        public static final b bww = new b(-1, -1, -1);
        public final int bwx;
        public final int bwy;
        public final int bwz;

        static {
            AppMethodBeat.i(92680);
            AppMethodBeat.o(92680);
        }

        public b(int i2) {
            this(i2, -1, -1);
        }

        public b(int i2, int i3, int i4) {
            this.bwx = i2;
            this.bwy = i3;
            this.bwz = i4;
        }

        public final b eA(int i2) {
            AppMethodBeat.i(92678);
            if (this.bwx == i2) {
                AppMethodBeat.o(92678);
                return this;
            }
            b bVar = new b(i2, this.bwy, this.bwz);
            AppMethodBeat.o(92678);
            return bVar;
        }

        public final boolean isAd() {
            return this.bwy != -1;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(92679);
            if (this == obj) {
                AppMethodBeat.o(92679);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.o(92679);
                return false;
            } else {
                b bVar = (b) obj;
                if (this.bwx == bVar.bwx && this.bwy == bVar.bwy && this.bwz == bVar.bwz) {
                    AppMethodBeat.o(92679);
                    return true;
                }
                AppMethodBeat.o(92679);
                return false;
            }
        }

        public final int hashCode() {
            return ((((this.bwx + JsApiGetABTestConfig.CTRL_INDEX) * 31) + this.bwy) * 31) + this.bwz;
        }
    }
}
