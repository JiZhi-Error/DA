package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.f;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.List;

public abstract class i extends f implements d {
    private d bAk;
    private long bdC;

    public abstract void release();

    public final void a(long j2, d dVar, long j3) {
        this.timeUs = j2;
        this.bAk = dVar;
        if (j3 == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            j3 = this.timeUs;
        }
        this.bdC = j3;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final int wa() {
        return this.bAk.wa();
    }

    @Override // com.google.android.exoplayer2.f.d
    public final long eH(int i2) {
        return this.bAk.eH(i2) + this.bdC;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final int ai(long j2) {
        return this.bAk.ai(j2 - this.bdC);
    }

    @Override // com.google.android.exoplayer2.f.d
    public final List<a> aj(long j2) {
        return this.bAk.aj(j2 - this.bdC);
    }

    @Override // com.google.android.exoplayer2.b.a
    public final void clear() {
        super.clear();
        this.bAk = null;
    }
}
