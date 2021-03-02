package com.tencent.magicbrush;

import android.os.Handler;
import android.util.SparseLongArray;
import com.tencent.magicbrush.utils.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

public final class d {
    private final MBRuntime cKJ;
    public SparseLongArray cKL = new SparseLongArray();
    private a cKM = new a((byte) 0);
    final b cKN = new b(this, (byte) 0);
    private int cKO;
    private int cKP;
    private float cKQ;
    private Queue<Float> cKR = new LinkedList();
    private float cKS;
    private int cKT;
    private int cKU;
    private boolean cKV;
    private a cKW = new a();
    private a cKX = new a();
    Handler handler;
    private boolean hasInit;

    public class a {
        public int cKY;
        public int cKZ;

        public a() {
        }
    }

    d(MBRuntime mBRuntime) {
        AppMethodBeat.i(139930);
        this.cKJ = mBRuntime;
        this.hasInit = false;
        AppMethodBeat.o(139930);
    }

    public final void a(int i2, int i3, float f2, int i4, boolean z) {
        synchronized (this.cKJ) {
            this.cKO = i2;
            this.cKQ = f2;
            this.cKP = i2 * i3;
            this.cKU = i4;
            this.cKV = z;
            this.hasInit = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void QO() {
        AppMethodBeat.i(139931);
        if (this.handler != null) {
            this.handler.removeCallbacks(this.cKN);
            this.handler = null;
        }
        AppMethodBeat.o(139931);
    }

    public final float ii(int i2) {
        AppMethodBeat.i(139932);
        float QV = (((float) (QV() - i2)) * 1000.0f) / ((float) h.ticksToNow(this.cKL.get(i2)));
        AppMethodBeat.o(139932);
        return QV;
    }

    public final a QP() {
        a aVar;
        synchronized (this.cKJ) {
            aVar = this.cKM;
        }
        return aVar;
    }

    public final a QQ() {
        a aVar;
        synchronized (this.cKJ) {
            this.cKX.cKZ = this.cKW.cKZ;
            this.cKX.cKY = this.cKW.cKY;
            this.cKW.cKZ = 0;
            this.cKW.cKY = 0;
            aVar = this.cKX;
        }
        return aVar;
    }

    public final int QR() {
        int i2;
        synchronized (this.cKJ) {
            i2 = this.cKW.cKY;
        }
        return i2;
    }

    public final int QS() {
        int i2;
        synchronized (this.cKJ) {
            i2 = this.cKW.cKZ;
        }
        return i2;
    }

    public final float QT() {
        float nativeGetCurrentFpsVariance;
        AppMethodBeat.i(139933);
        synchronized (this.cKJ) {
            try {
                if (this.cKJ.mNativeInst == 0) {
                    nativeGetCurrentFpsVariance = -1.0f;
                } else {
                    nativeGetCurrentFpsVariance = this.cKJ.nativeGetCurrentFpsVariance(this.cKJ.mNativeInst);
                    AppMethodBeat.o(139933);
                }
            } finally {
                AppMethodBeat.o(139933);
            }
        }
        return nativeGetCurrentFpsVariance;
    }

    public final void QU() {
        AppMethodBeat.i(139934);
        synchronized (this.cKJ) {
            try {
                if (this.cKJ.mNativeInst != 0) {
                    this.cKJ.nativeSetEnableInspectFpsVariance(this.cKJ.mNativeInst, true);
                    AppMethodBeat.o(139934);
                }
            } finally {
                AppMethodBeat.o(139934);
            }
        }
    }

    public final int QV() {
        int nativeGetFrameCounter;
        AppMethodBeat.i(139935);
        synchronized (this.cKJ) {
            try {
                if (this.cKJ.mNativeInst == 0) {
                    nativeGetFrameCounter = -1;
                } else {
                    nativeGetFrameCounter = this.cKJ.nativeGetFrameCounter(this.cKJ.mNativeInst);
                    AppMethodBeat.o(139935);
                }
            } finally {
                AppMethodBeat.o(139935);
            }
        }
        return nativeGetFrameCounter;
    }

    public final int QW() {
        int nativeGetDrawCalls;
        AppMethodBeat.i(139936);
        synchronized (this.cKJ) {
            try {
                if (this.cKJ.mNativeInst == 0) {
                    nativeGetDrawCalls = 0;
                } else {
                    nativeGetDrawCalls = this.cKJ.nativeGetDrawCalls(this.cKJ.mNativeInst);
                    AppMethodBeat.o(139936);
                }
            } finally {
                AppMethodBeat.o(139936);
            }
        }
        return nativeGetDrawCalls;
    }

    public final int QX() {
        int nativeGetVertexes;
        AppMethodBeat.i(139937);
        synchronized (this.cKJ) {
            try {
                if (this.cKJ.mNativeInst == 0) {
                    nativeGetVertexes = 0;
                } else {
                    nativeGetVertexes = this.cKJ.nativeGetVertexes(this.cKJ.mNativeInst);
                    AppMethodBeat.o(139937);
                }
            } finally {
                AppMethodBeat.o(139937);
            }
        }
        return nativeGetVertexes;
    }

    public final int QY() {
        int nativeGetTriangles;
        AppMethodBeat.i(139938);
        synchronized (this.cKJ) {
            try {
                if (this.cKJ.mNativeInst == 0) {
                    nativeGetTriangles = 0;
                } else {
                    nativeGetTriangles = this.cKJ.nativeGetTriangles(this.cKJ.mNativeInst);
                    AppMethodBeat.o(139938);
                }
            } finally {
                AppMethodBeat.o(139938);
            }
        }
        return nativeGetTriangles;
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(d dVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(139929);
            d.this.QZ();
            d.this.handler.postDelayed(d.this.cKN, 1000);
            AppMethodBeat.o(139929);
        }
    }

    public final void QZ() {
        AppMethodBeat.i(139939);
        synchronized (this.cKJ) {
            try {
                if (this.cKJ.mNativeInst != 0) {
                    float[] nativeGetCurrentFps = this.cKJ.nativeGetCurrentFps(this.cKJ.mNativeInst);
                    this.cKM.cKu = nativeGetCurrentFps[0];
                    this.cKM.cKv = nativeGetCurrentFps[1];
                    if (this.hasInit) {
                        this.cKT++;
                        if (this.cKT > this.cKU) {
                            this.cKT = 1;
                            if (this.cKV) {
                                this.cKW.cKZ = 0;
                                this.cKW.cKY = 0;
                            }
                        }
                        if (this.cKM.cKu < this.cKQ) {
                            this.cKW.cKZ++;
                        }
                        if (this.cKR.size() >= this.cKO && this.cKO > 0) {
                            if ((this.cKM.cKu * ((float) this.cKO)) + ((float) this.cKP) < this.cKS) {
                                this.cKW.cKY++;
                            }
                            this.cKS -= this.cKR.remove().floatValue();
                        }
                        this.cKR.add(Float.valueOf(this.cKM.cKu));
                        this.cKS += this.cKM.cKu;
                    }
                    AppMethodBeat.o(139939);
                }
            } finally {
                AppMethodBeat.o(139939);
            }
        }
    }
}
