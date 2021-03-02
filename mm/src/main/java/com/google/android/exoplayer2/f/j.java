package com.google.android.exoplayer2.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.Collections;
import java.util.List;

public final class j extends com.google.android.exoplayer2.a implements Handler.Callback {
    private final a bAl;
    private final g bAm;
    private int bAn;
    private Format bAo;
    private e bAp;
    private h bAq;
    private i bAr;
    private i bAs;
    private int bAt;
    private boolean btF;
    private boolean btG;
    private final k btf;
    private final Handler bub;

    public interface a {
        void s(List<a> list);
    }

    public j(a aVar, Looper looper) {
        this(aVar, looper, g.bAj);
    }

    private j(a aVar, Looper looper, g gVar) {
        super(3);
        AppMethodBeat.i(92825);
        this.bAl = (a) com.google.android.exoplayer2.i.a.checkNotNull(aVar);
        this.bub = looper == null ? null : new Handler(looper, this);
        this.bAm = gVar;
        this.btf = new k();
        AppMethodBeat.o(92825);
    }

    @Override // com.google.android.exoplayer2.s
    public final int b(Format format) {
        AppMethodBeat.i(92826);
        if (this.bAm.g(format)) {
            AppMethodBeat.o(92826);
            return 4;
        } else if (com.google.android.exoplayer2.i.j.bz(format.bdq)) {
            AppMethodBeat.o(92826);
            return 1;
        } else {
            AppMethodBeat.o(92826);
            return 0;
        }
    }

    @Override // com.google.android.exoplayer2.a
    public final void a(Format[] formatArr, long j2) {
        AppMethodBeat.i(92827);
        this.bAo = formatArr[0];
        if (this.bAp != null) {
            this.bAn = 1;
            AppMethodBeat.o(92827);
            return;
        }
        this.bAp = this.bAm.k(this.bAo);
        AppMethodBeat.o(92827);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 175
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    @Override // com.google.android.exoplayer2.r
    public final void e(long r10, long r12) {
        /*
        // Method dump skipped, instructions count: 301
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f.j.e(long, long):void");
    }

    @Override // com.google.android.exoplayer2.a
    public final void te() {
        AppMethodBeat.i(92830);
        this.bAo = null;
        w(Collections.emptyList());
        releaseDecoder();
        AppMethodBeat.o(92830);
    }

    @Override // com.google.android.exoplayer2.r
    public final boolean tB() {
        return this.btG;
    }

    @Override // com.google.android.exoplayer2.r
    public final boolean isReady() {
        return true;
    }

    private void wb() {
        AppMethodBeat.i(92831);
        this.bAq = null;
        this.bAt = -1;
        if (this.bAr != null) {
            this.bAr.release();
            this.bAr = null;
        }
        if (this.bAs != null) {
            this.bAs.release();
            this.bAs = null;
        }
        AppMethodBeat.o(92831);
    }

    private void releaseDecoder() {
        AppMethodBeat.i(92832);
        wb();
        this.bAp.release();
        this.bAp = null;
        this.bAn = 0;
        AppMethodBeat.o(92832);
    }

    private void wc() {
        AppMethodBeat.i(92833);
        releaseDecoder();
        this.bAp = this.bAm.k(this.bAo);
        AppMethodBeat.o(92833);
    }

    private long wd() {
        AppMethodBeat.i(92834);
        if (this.bAt == -1 || this.bAt >= this.bAr.wa()) {
            AppMethodBeat.o(92834);
            return MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        long eH = this.bAr.eH(this.bAt);
        AppMethodBeat.o(92834);
        return eH;
    }

    private void w(List<a> list) {
        AppMethodBeat.i(92835);
        if (this.bub != null) {
            this.bub.obtainMessage(0, list).sendToTarget();
            AppMethodBeat.o(92835);
            return;
        }
        x(list);
        AppMethodBeat.o(92835);
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(92836);
        switch (message.what) {
            case 0:
                x((List) message.obj);
                AppMethodBeat.o(92836);
                return true;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(92836);
                throw illegalStateException;
        }
    }

    private void x(List<a> list) {
        AppMethodBeat.i(92837);
        this.bAl.s(list);
        AppMethodBeat.o(92837);
    }

    @Override // com.google.android.exoplayer2.a
    public final void a(long j2, boolean z) {
        AppMethodBeat.i(92828);
        w(Collections.emptyList());
        this.btF = false;
        this.btG = false;
        if (this.bAn != 0) {
            wc();
            AppMethodBeat.o(92828);
            return;
        }
        wb();
        this.bAp.flush();
        AppMethodBeat.o(92828);
    }
}
