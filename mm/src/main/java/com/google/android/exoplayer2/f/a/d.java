package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.e;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.a;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract class d implements e {
    private final LinkedList<h> bBA = new LinkedList<>();
    final LinkedList<i> bBB;
    private final PriorityQueue<h> bBC;
    private h bBD;
    private long buZ;

    /* access modifiers changed from: protected */
    public abstract void a(h hVar);

    /* access modifiers changed from: protected */
    public abstract boolean we();

    /* access modifiers changed from: protected */
    public abstract com.google.android.exoplayer2.f.d wf();

    public d() {
        for (int i2 = 0; i2 < 10; i2++) {
            this.bBA.add(new h());
        }
        this.bBB = new LinkedList<>();
        for (int i3 = 0; i3 < 2; i3++) {
            this.bBB.add(new e(this));
        }
        this.bBC = new PriorityQueue<>();
    }

    @Override // com.google.android.exoplayer2.f.e
    public void ah(long j2) {
        this.buZ = j2;
    }

    /* renamed from: wj */
    public h uf() {
        a.checkState(this.bBD == null);
        if (this.bBA.isEmpty()) {
            return null;
        }
        this.bBD = this.bBA.pollFirst();
        return this.bBD;
    }

    /* renamed from: b */
    public void af(h hVar) {
        a.checkArgument(hVar == this.bBD);
        if (hVar.uc()) {
            c(hVar);
        } else {
            this.bBC.add(hVar);
        }
        this.bBD = null;
    }

    /* renamed from: wi */
    public i ug() {
        if (this.bBB.isEmpty()) {
            return null;
        }
        while (!this.bBC.isEmpty() && this.bBC.peek().timeUs <= this.buZ) {
            h poll = this.bBC.poll();
            if (poll.ud()) {
                i pollFirst = this.bBB.pollFirst();
                pollFirst.dK(4);
                c(poll);
                return pollFirst;
            }
            a(poll);
            if (we()) {
                com.google.android.exoplayer2.f.d wf = wf();
                if (!poll.uc()) {
                    i pollFirst2 = this.bBB.pollFirst();
                    pollFirst2.a(poll.timeUs, wf, MAlarmHandler.NEXT_FIRE_INTERVAL);
                    c(poll);
                    return pollFirst2;
                }
            }
            c(poll);
        }
        return null;
    }

    private void c(h hVar) {
        hVar.clear();
        this.bBA.add(hVar);
    }

    @Override // com.google.android.exoplayer2.b.c
    public void flush() {
        this.buZ = 0;
        while (!this.bBC.isEmpty()) {
            c(this.bBC.poll());
        }
        if (this.bBD != null) {
            c(this.bBD);
            this.bBD = null;
        }
    }

    @Override // com.google.android.exoplayer2.b.c
    public void release() {
    }
}
