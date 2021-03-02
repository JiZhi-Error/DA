package com.google.android.exoplayer2;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.source.n;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;

public abstract class a implements r, s {
    protected t bbE;
    protected n bbF;
    protected long bbG;
    protected boolean bbH = true;
    protected boolean bbI;
    protected int index;
    protected int state;
    private final int trackType;

    public a(int i2) {
        this.trackType = i2;
    }

    @Override // com.google.android.exoplayer2.r, com.google.android.exoplayer2.s
    public final int getTrackType() {
        return this.trackType;
    }

    @Override // com.google.android.exoplayer2.r
    public final s sW() {
        return this;
    }

    @Override // com.google.android.exoplayer2.r
    public final void setIndex(int i2) {
        this.index = i2;
    }

    @Override // com.google.android.exoplayer2.r
    public i sX() {
        return null;
    }

    @Override // com.google.android.exoplayer2.r
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.r
    public final void a(t tVar, Format[] formatArr, n nVar, long j2, boolean z, long j3) {
        com.google.android.exoplayer2.i.a.checkState(this.state == 0);
        this.bbE = tVar;
        this.state = 1;
        aN(z);
        a(formatArr, nVar, j3);
        a(j2, z);
    }

    @Override // com.google.android.exoplayer2.r
    public final void start() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        com.google.android.exoplayer2.i.a.checkState(z);
        this.state = 2;
        onStarted();
    }

    @Override // com.google.android.exoplayer2.r
    public final void a(Format[] formatArr, n nVar, long j2) {
        com.google.android.exoplayer2.i.a.checkState(!this.bbI);
        this.bbF = nVar;
        this.bbH = false;
        this.bbG = j2;
        a(formatArr, j2);
    }

    @Override // com.google.android.exoplayer2.r
    public final n sY() {
        return this.bbF;
    }

    @Override // com.google.android.exoplayer2.r
    public final boolean sZ() {
        return this.bbH;
    }

    @Override // com.google.android.exoplayer2.r
    public final void ta() {
        this.bbI = true;
    }

    @Override // com.google.android.exoplayer2.r
    public final boolean tb() {
        return this.bbI;
    }

    @Override // com.google.android.exoplayer2.r
    public final void tc() {
        this.bbF.vs();
    }

    @Override // com.google.android.exoplayer2.r
    public final void u(long j2) {
        this.bbI = false;
        this.bbH = false;
        a(j2, false);
    }

    @Override // com.google.android.exoplayer2.r
    public final void stop() {
        com.google.android.exoplayer2.i.a.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    @Override // com.google.android.exoplayer2.r
    public final void disable() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        com.google.android.exoplayer2.i.a.checkState(z);
        this.state = 0;
        this.bbF = null;
        this.bbI = false;
        te();
    }

    @Override // com.google.android.exoplayer2.s
    public int td() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.f.b
    public void c(int i2, Object obj) {
    }

    /* access modifiers changed from: protected */
    public void aN(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void a(Format[] formatArr, long j2) {
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
    }

    /* access modifiers changed from: protected */
    public void te() {
    }

    /* access modifiers changed from: protected */
    public final int a(k kVar, e eVar, boolean z) {
        int b2 = this.bbF.b(kVar, eVar, z);
        if (b2 == -4) {
            if (eVar.ud()) {
                this.bbH = true;
                if (this.bbI) {
                    return -4;
                }
                return -3;
            }
            eVar.timeUs += this.bbG;
        } else if (b2 == -5) {
            Format format = kVar.bdF;
            if (format.bdC != MAlarmHandler.NEXT_FIRE_INTERVAL) {
                kVar.bdF = format.D(format.bdC + this.bbG);
            }
        }
        return b2;
    }
}
