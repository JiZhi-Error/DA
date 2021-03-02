package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e extends com.google.android.exoplayer2.a implements Handler.Callback {
    private boolean btF;
    private final c btZ;
    private final k btf;
    private final a bua;
    private final Handler bub;
    private final d buc;
    private final Metadata[] bud;
    private final long[] bue;
    private int bug;
    private int buh;
    private a bui;

    public interface a {
        void b(Metadata metadata);
    }

    public e(a aVar, Looper looper) {
        this(aVar, looper, c.btY);
    }

    private e(a aVar, Looper looper, c cVar) {
        super(4);
        AppMethodBeat.i(92471);
        this.bua = (a) com.google.android.exoplayer2.i.a.checkNotNull(aVar);
        this.bub = looper == null ? null : new Handler(looper, this);
        this.btZ = (c) com.google.android.exoplayer2.i.a.checkNotNull(cVar);
        this.btf = new k();
        this.buc = new d();
        this.bud = new Metadata[5];
        this.bue = new long[5];
        AppMethodBeat.o(92471);
    }

    @Override // com.google.android.exoplayer2.s
    public final int b(Format format) {
        AppMethodBeat.i(92472);
        if (this.btZ.g(format)) {
            AppMethodBeat.o(92472);
            return 4;
        }
        AppMethodBeat.o(92472);
        return 0;
    }

    @Override // com.google.android.exoplayer2.a
    public final void a(Format[] formatArr, long j2) {
        AppMethodBeat.i(92473);
        this.bui = this.btZ.h(formatArr[0]);
        AppMethodBeat.o(92473);
    }

    @Override // com.google.android.exoplayer2.a
    public final void a(long j2, boolean z) {
        AppMethodBeat.i(92474);
        vj();
        this.btF = false;
        AppMethodBeat.o(92474);
    }

    @Override // com.google.android.exoplayer2.r
    public final void e(long j2, long j3) {
        AppMethodBeat.i(92475);
        if (!this.btF && this.buh < 5) {
            this.buc.clear();
            if (a(this.btf, (com.google.android.exoplayer2.b.e) this.buc, false) == -4) {
                if (this.buc.ud()) {
                    this.btF = true;
                } else if (!this.buc.uc()) {
                    this.buc.bdC = this.btf.bdF.bdC;
                    this.buc.ui();
                    try {
                        int i2 = (this.bug + this.buh) % 5;
                        this.bud[i2] = this.bui.a(this.buc);
                        this.bue[i2] = this.buc.timeUs;
                        this.buh++;
                    } catch (b e2) {
                        com.google.android.exoplayer2.e b2 = com.google.android.exoplayer2.e.b(e2, this.index);
                        AppMethodBeat.o(92475);
                        throw b2;
                    }
                }
            }
        }
        if (this.buh > 0 && this.bue[this.bug] <= j2) {
            Metadata metadata = this.bud[this.bug];
            if (this.bub != null) {
                this.bub.obtainMessage(0, metadata).sendToTarget();
            } else {
                d(metadata);
            }
            this.bud[this.bug] = null;
            this.bug = (this.bug + 1) % 5;
            this.buh--;
        }
        AppMethodBeat.o(92475);
    }

    @Override // com.google.android.exoplayer2.a
    public final void te() {
        AppMethodBeat.i(92476);
        vj();
        this.bui = null;
        AppMethodBeat.o(92476);
    }

    @Override // com.google.android.exoplayer2.r
    public final boolean tB() {
        return this.btF;
    }

    @Override // com.google.android.exoplayer2.r
    public final boolean isReady() {
        return true;
    }

    private void vj() {
        AppMethodBeat.i(92477);
        Arrays.fill(this.bud, (Object) null);
        this.bug = 0;
        this.buh = 0;
        AppMethodBeat.o(92477);
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(92478);
        switch (message.what) {
            case 0:
                d((Metadata) message.obj);
                AppMethodBeat.o(92478);
                return true;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(92478);
                throw illegalStateException;
        }
    }

    private void d(Metadata metadata) {
        AppMethodBeat.i(92479);
        this.bua.b(metadata);
        AppMethodBeat.o(92479);
    }
}
