package com.plattysoft.leonids;

import android.os.SystemClock;
import android.view.Choreographer;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.plattysoft.leonids.a.c;
import com.plattysoft.leonids.a.d;
import com.plattysoft.leonids.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class b {
    private static long hNu = 16;
    private ViewGroup WN;
    private List<com.plattysoft.leonids.b.b> hHy;
    private ArrayList<a> hNt;
    private int hNv;
    private Random hNw;
    public boolean isPaused;
    private ParticleField kRP;
    private final ArrayList<a> kRQ;
    private float kRR;
    private int kRS;
    private a kRT;
    private List<com.plattysoft.leonids.a.b> kRU;
    private long kRV;
    private float kSc;
    private int[] kSd;
    private int kSe;
    private long mTimeToLive;
    private int nkN;
    private int nkV;
    private int nkW;
    private a nkX;
    private float nkY;

    /* access modifiers changed from: package-private */
    public static class a implements Choreographer.FrameCallback {
        private final WeakReference<b> olg;

        public a(b bVar) {
            AppMethodBeat.i(261909);
            this.olg = new WeakReference<>(bVar);
            AppMethodBeat.o(261909);
        }

        public final void doFrame(long j2) {
            AppMethodBeat.i(261910);
            if (this.olg.get() != null) {
                b.a(this.olg.get(), SystemClock.uptimeMillis());
            }
            AppMethodBeat.o(261910);
        }
    }

    private b(ViewGroup viewGroup, int i2, long j2) {
        AppMethodBeat.i(261911);
        this.kRQ = new ArrayList<>();
        this.isPaused = true;
        this.nkX = new a(this);
        this.hNw = new Random();
        this.kSd = new int[2];
        this.WN = viewGroup;
        if (this.WN != null) {
            this.WN.getLocationInWindow(this.kSd);
        }
        this.hHy = new ArrayList();
        this.kRU = new ArrayList();
        this.hNv = i2;
        this.hNt = new ArrayList<>();
        this.mTimeToLive = j2;
        this.kSc = viewGroup.getContext().getResources().getDisplayMetrics().xdpi / 160.0f;
        AppMethodBeat.o(261911);
    }

    public b(ViewGroup viewGroup, int i2, long j2, byte b2) {
        this(viewGroup, i2, j2);
        AppMethodBeat.i(261912);
        for (int i3 = 0; i3 < this.hNv; i3++) {
            this.hNt.add(new a());
        }
        AppMethodBeat.o(261912);
    }

    public final b a(com.plattysoft.leonids.b.b bVar) {
        AppMethodBeat.i(261913);
        this.hHy.add(bVar);
        AppMethodBeat.o(261913);
        return this;
    }

    public final b aK(float f2, float f3) {
        AppMethodBeat.i(261914);
        this.kRU.add(new com.plattysoft.leonids.a.a(this.kSc * f2, this.kSc * f3));
        AppMethodBeat.o(261914);
        return this;
    }

    public final b aL(float f2, float f3) {
        AppMethodBeat.i(261915);
        this.kRU.add(new d(f2, f3));
        AppMethodBeat.o(261915);
        return this;
    }

    public final b qh() {
        AppMethodBeat.i(261916);
        this.kRU.add(new c());
        AppMethodBeat.o(261916);
        return this;
    }

    public final b a(com.plattysoft.leonids.a.b bVar) {
        AppMethodBeat.i(261917);
        this.kRU.add(bVar);
        AppMethodBeat.o(261917);
        return this;
    }

    public final b Pz(long j2) {
        AppMethodBeat.i(261918);
        a aVar = new a(-j2, new LinearInterpolator());
        this.kRT = aVar;
        this.hHy.add(aVar);
        this.kRU.add(aVar);
        AppMethodBeat.o(261918);
        return this;
    }

    public final void acY() {
        AppMethodBeat.i(261919);
        this.kRS = 0;
        if (this.kRP == null) {
            this.kRP = new ParticleField(this.WN.getContext());
            this.WN.addView(this.kRP);
            this.kRP.hNt = this.kRQ;
        }
        this.isPaused = false;
        Choreographer.getInstance().postFrameCallback(this.nkX);
        this.kRV = SystemClock.uptimeMillis();
        AppMethodBeat.o(261919);
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(261920);
        boolean isEmpty = this.kRQ.isEmpty();
        AppMethodBeat.o(261920);
        return isEmpty;
    }

    public final boolean acZ() {
        AppMethodBeat.i(261921);
        if (this.kRQ.isEmpty()) {
            AppMethodBeat.o(261921);
            return false;
        }
        this.kRV = SystemClock.uptimeMillis();
        Iterator<a> it = this.kRQ.iterator();
        while (it.hasNext()) {
            a next = it.next();
            next.mTimeToLive = 2000;
            next.c(this.kRV, this.hHy);
            this.kRT.a(next, this.hNw);
        }
        Choreographer.getInstance().postFrameCallback(this.nkX);
        AppMethodBeat.o(261921);
        return true;
    }

    public final void aff() {
        this.isPaused = true;
    }

    public final void rf(int i2) {
        this.kRR = ((float) i2) / 1000.0f;
    }

    public final void zY(int i2) {
        this.nkY = ((float) i2) * this.kSc;
    }

    public final void eI(int i2, int i3) {
        this.kSe = (int) (((float) (i2 - this.kSd[0])) - (this.nkY / 2.0f));
        this.nkN = (int) (((float) this.kSe) + (this.nkY / 2.0f));
        this.nkV = (int) (((float) (i3 - this.kSd[1])) - (this.nkY / 2.0f));
        this.nkW = (int) (((float) this.nkV) + (this.nkY / 2.0f));
    }

    private void a(long j2, a aVar) {
        AppMethodBeat.i(261922);
        aVar.dhh = 1.0f;
        aVar.mAlpha = 255;
        aVar.hNs = this;
        aVar.mTimeToLive = this.mTimeToLive;
        for (int i2 = 0; i2 < this.kRU.size(); i2++) {
            this.kRU.get(i2).a(aVar, this.hNw);
        }
        float nextFloat = (float) (((double) (this.hNw.nextFloat() * 2.0f)) * 3.141592653589793d);
        float nextFloat2 = (((float) (this.nkN - this.kSe)) / 2.0f) * this.hNw.nextFloat();
        double sin = ((double) nextFloat2) * Math.sin((double) nextFloat);
        long j3 = this.mTimeToLive;
        float cos = (float) ((int) ((float) (((double) (((float) (this.nkN + this.kSe)) / 2.0f)) + (Math.cos((double) nextFloat) * ((double) nextFloat2)))));
        aVar.hHw = aVar.gtH.getWidth() / 2;
        aVar.hHx = aVar.gtH.getHeight() / 2;
        aVar.hHr = cos - ((float) aVar.hHw);
        aVar.hHs = ((float) ((int) ((float) (sin + ((double) (((float) (this.nkW + this.nkV)) / 2.0f)))))) - ((float) aVar.hHx);
        aVar.gVp = aVar.hHr;
        aVar.huc = aVar.hHs;
        aVar.mTimeToLive = Math.min(j3, aVar.hBT.mEndTime);
        aVar.c(j2, this.hHy);
        this.kRQ.add(aVar);
        this.kRS++;
        AppMethodBeat.o(261922);
    }

    static /* synthetic */ void a(b bVar, long j2) {
        boolean z;
        AppMethodBeat.i(261923);
        long j3 = j2 - bVar.kRV;
        while (!bVar.isPaused && ((float) bVar.kRS) < bVar.kRR * ((float) j3)) {
            if (!bVar.hNt.isEmpty()) {
                bVar.a(j2, bVar.hNt.remove(0));
            } else {
                bVar.a(j2, bVar.kRQ.remove(0));
            }
        }
        synchronized (bVar.kRQ) {
            int i2 = 0;
            while (i2 < bVar.kRQ.size()) {
                try {
                    if (!bVar.kRQ.get(i2).c(j2)) {
                        i2--;
                        bVar.hNt.add(bVar.kRQ.remove(i2));
                    }
                    i2++;
                } finally {
                    AppMethodBeat.o(261923);
                }
            }
            z = !bVar.kRQ.isEmpty();
        }
        bVar.kRP.invalidate();
        if (!bVar.isPaused || z) {
            Choreographer.getInstance().postFrameCallback(bVar.nkX);
        }
    }
}
