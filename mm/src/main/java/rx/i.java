package rx;

import com.tencent.mm.sdk.platformtools.MAlarmHandler;

public abstract class i<T> implements e<T>, j {
    public final rx.internal.util.i Ukg;
    private final i<?> Ukh;
    private f Uki;
    private long Ukj;

    protected i() {
        this(null, false);
    }

    protected i(i<?> iVar) {
        this(iVar, true);
    }

    private i(i<?> iVar, boolean z) {
        this.Ukj = Long.MIN_VALUE;
        this.Ukh = iVar;
        this.Ukg = (!z || iVar == null) ? new rx.internal.util.i() : iVar.Ukg;
    }

    public final void b(j jVar) {
        this.Ukg.b(jVar);
    }

    @Override // rx.j
    public final void hQA() {
        this.Ukg.hQA();
    }

    @Override // rx.j
    public final boolean hQB() {
        return this.Ukg.UnB;
    }

    public void onStart() {
    }

    /* access modifiers changed from: protected */
    public final void Pw(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("number requested cannot be negative: ".concat(String.valueOf(j2)));
        }
        synchronized (this) {
            if (this.Uki != null) {
                this.Uki.Pw(j2);
                return;
            }
            if (this.Ukj == Long.MIN_VALUE) {
                this.Ukj = j2;
            } else {
                long j3 = this.Ukj + j2;
                if (j3 < 0) {
                    this.Ukj = MAlarmHandler.NEXT_FIRE_INTERVAL;
                } else {
                    this.Ukj = j3;
                }
            }
        }
    }

    public void a(f fVar) {
        long j2;
        boolean z = false;
        synchronized (this) {
            j2 = this.Ukj;
            this.Uki = fVar;
            if (this.Ukh != null && j2 == Long.MIN_VALUE) {
                z = true;
            }
        }
        if (z) {
            this.Ukh.a(this.Uki);
        } else if (j2 == Long.MIN_VALUE) {
            this.Uki.Pw(MAlarmHandler.NEXT_FIRE_INTERVAL);
        } else {
            this.Uki.Pw(j2);
        }
    }
}
