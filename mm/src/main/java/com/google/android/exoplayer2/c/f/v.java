package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.util.Collections;
import java.util.List;

public interface v {

    public interface c {
        v a(int i2, b bVar);

        SparseArray<v> uS();
    }

    void a(m mVar, boolean z);

    void a(u uVar, g gVar, d dVar);

    void uK();

    public static final class b {
        public final List<a> bsK;
        public final byte[] bsL;
        public final String language;
        public final int streamType;

        public b(int i2, String str, List<a> list, byte[] bArr) {
            List<a> unmodifiableList;
            AppMethodBeat.i(92300);
            this.streamType = i2;
            this.language = str;
            if (list == null) {
                unmodifiableList = Collections.emptyList();
            } else {
                unmodifiableList = Collections.unmodifiableList(list);
            }
            this.bsK = unmodifiableList;
            this.bsL = bArr;
            AppMethodBeat.o(92300);
        }
    }

    public static final class a {
        public final byte[] bsJ;
        public final String language;
        public final int type;

        public a(String str, int i2, byte[] bArr) {
            this.language = str;
            this.type = i2;
            this.bsJ = bArr;
        }
    }

    public static final class d {
        private String bqA;
        private final String bsM;
        private final int bsN;
        private final int bsO;
        private int trackId;

        public d(int i2, int i3) {
            this(Integer.MIN_VALUE, i2, i3);
        }

        public d(int i2, int i3, int i4) {
            AppMethodBeat.i(92301);
            this.bsM = i2 != Integer.MIN_VALUE ? i2 + FilePathGenerator.ANDROID_DIR_SEP : "";
            this.bsN = i3;
            this.bsO = i4;
            this.trackId = Integer.MIN_VALUE;
            AppMethodBeat.o(92301);
        }

        public final void uW() {
            AppMethodBeat.i(92302);
            this.trackId = this.trackId == Integer.MIN_VALUE ? this.bsN : this.trackId + this.bsO;
            this.bqA = this.bsM + this.trackId;
            AppMethodBeat.o(92302);
        }

        public final int getTrackId() {
            AppMethodBeat.i(92303);
            uY();
            int i2 = this.trackId;
            AppMethodBeat.o(92303);
            return i2;
        }

        public final String uX() {
            AppMethodBeat.i(92304);
            uY();
            String str = this.bqA;
            AppMethodBeat.o(92304);
            return str;
        }

        private void uY() {
            AppMethodBeat.i(92305);
            if (this.trackId == Integer.MIN_VALUE) {
                IllegalStateException illegalStateException = new IllegalStateException("generateNewId() must be called before retrieving ids.");
                AppMethodBeat.o(92305);
                throw illegalStateException;
            }
            AppMethodBeat.o(92305);
        }
    }
}
