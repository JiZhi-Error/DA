package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class a implements com.google.android.exoplayer2.metadata.a {
    private u bnh;
    private final m bsn = new m();
    private final l buF = new l();

    public a() {
        AppMethodBeat.i(92485);
        AppMethodBeat.o(92485);
    }

    @Override // com.google.android.exoplayer2.metadata.a
    public final Metadata a(d dVar) {
        SpliceCommand a2;
        AppMethodBeat.i(92486);
        if (this.bnh == null || dVar.bdC != this.bnh.xs()) {
            this.bnh = new u(dVar.timeUs);
            this.bnh.ap(dVar.timeUs - dVar.bdC);
        }
        ByteBuffer byteBuffer = dVar.aKP;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.bsn.n(array, limit);
        this.buF.n(array, limit);
        this.buF.en(39);
        long em = ((long) this.buF.em(32)) | (((long) this.buF.em(1)) << 32);
        this.buF.en(20);
        int em2 = this.buF.em(12);
        int em3 = this.buF.em(8);
        this.bsn.eZ(14);
        switch (em3) {
            case 0:
                a2 = new SpliceNullCommand();
                break;
            case 4:
                a2 = SpliceScheduleCommand.y(this.bsn);
                break;
            case 5:
                a2 = SpliceInsertCommand.a(this.bsn, em, this.bnh);
                break;
            case 6:
                a2 = TimeSignalCommand.b(this.bsn, em, this.bnh);
                break;
            case 255:
                a2 = PrivateCommand.a(this.bsn, em2, em);
                break;
            default:
                a2 = null;
                break;
        }
        if (a2 == null) {
            Metadata metadata = new Metadata(new Metadata.Entry[0]);
            AppMethodBeat.o(92486);
            return metadata;
        }
        Metadata metadata2 = new Metadata(a2);
        AppMethodBeat.o(92486);
        return metadata2;
    }
}
