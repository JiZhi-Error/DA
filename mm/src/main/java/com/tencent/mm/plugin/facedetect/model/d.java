package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d {
    private static final Object mLock = new Object();
    private static volatile d sQC = null;
    private List<a> sQD = null;

    public interface b {
        void bC(byte[] bArr);

        com.tencent.mm.memory.a<byte[]> cSS();
    }

    static {
        AppMethodBeat.i(103701);
        AppMethodBeat.o(103701);
    }

    public static final d cSR() {
        d dVar;
        AppMethodBeat.i(103697);
        if (sQC == null) {
            synchronized (mLock) {
                try {
                    if (sQC == null) {
                        sQC = new d();
                    }
                    dVar = sQC;
                } finally {
                    AppMethodBeat.o(103697);
                }
            }
            return dVar;
        }
        d dVar2 = sQC;
        AppMethodBeat.o(103697);
        return dVar2;
    }

    public final synchronized void a(b bVar) {
        AppMethodBeat.i(103698);
        if (bVar == null) {
            Log.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: invalid callbacker");
            AppMethodBeat.o(103698);
        } else {
            synchronized (mLock) {
                try {
                    if (this.sQD == null) {
                        this.sQD = Collections.synchronizedList(new ArrayList(5));
                    }
                    this.sQD.add(new a(bVar));
                } finally {
                    AppMethodBeat.o(103698);
                }
            }
        }
    }

    public final void bB(byte[] bArr) {
        AppMethodBeat.i(103699);
        synchronized (mLock) {
            try {
                Log.v("MicroMsg.FaceCameraDataCallbackHolder", "hy: publish data:".concat(String.valueOf(bArr)));
                if (this.sQD == null || this.sQD.size() == 0) {
                    Log.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: nothing's listening to preview data");
                } else if (bArr == null || bArr.length == 0) {
                    Log.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: null camera data got");
                    AppMethodBeat.o(103699);
                } else {
                    for (a aVar : this.sQD) {
                        int length = bArr.length;
                        aVar.data = aVar.sQE.cSS().e(Integer.valueOf(length));
                        System.arraycopy(bArr, 0, aVar.data, 0, length);
                        aVar.sQE.bC(aVar.data);
                    }
                    AppMethodBeat.o(103699);
                }
            } finally {
                AppMethodBeat.o(103699);
            }
        }
    }

    public final void b(b bVar) {
        AppMethodBeat.i(103700);
        synchronized (mLock) {
            try {
                if (this.sQD != null) {
                    this.sQD.remove(new a(bVar));
                }
            } finally {
                AppMethodBeat.o(103700);
            }
        }
    }

    public final void clear() {
        AppMethodBeat.i(186365);
        synchronized (mLock) {
            try {
                if (this.sQD != null) {
                    this.sQD.clear();
                }
            } finally {
                AppMethodBeat.o(186365);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class a {
        byte[] data;
        b sQE;

        a(b bVar) {
            this.sQE = bVar;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(186364);
            if (!(obj instanceof a)) {
                AppMethodBeat.o(186364);
                return false;
            }
            boolean equals = this.sQE.equals(((a) obj).sQE);
            AppMethodBeat.o(186364);
            return equals;
        }
    }
}
