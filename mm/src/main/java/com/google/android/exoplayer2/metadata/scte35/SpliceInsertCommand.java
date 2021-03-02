package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new Parcelable.Creator<SpliceInsertCommand>() {
        /* class com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SpliceInsertCommand[] newArray(int i2) {
            return new SpliceInsertCommand[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SpliceInsertCommand createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92487);
            SpliceInsertCommand spliceInsertCommand = new SpliceInsertCommand(parcel, (byte) 0);
            AppMethodBeat.o(92487);
            return spliceInsertCommand;
        }
    };
    public final long buG;
    public final boolean buH;
    public final boolean buI;
    public final boolean buJ;
    public final boolean buK;
    public final long buL;
    public final long buM;
    public final List<a> buN;
    public final boolean buO;
    public final long buP;
    public final int buQ;
    public final int buR;
    public final int buS;

    /* synthetic */ SpliceInsertCommand(Parcel parcel, byte b2) {
        this(parcel);
    }

    private SpliceInsertCommand(long j2, boolean z, boolean z2, boolean z3, boolean z4, long j3, long j4, List<a> list, boolean z5, long j5, int i2, int i3, int i4) {
        AppMethodBeat.i(92488);
        this.buG = j2;
        this.buH = z;
        this.buI = z2;
        this.buJ = z3;
        this.buK = z4;
        this.buL = j3;
        this.buM = j4;
        this.buN = Collections.unmodifiableList(list);
        this.buO = z5;
        this.buP = j5;
        this.buQ = i2;
        this.buR = i3;
        this.buS = i4;
        AppMethodBeat.o(92488);
    }

    private SpliceInsertCommand(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(92489);
        this.buG = parcel.readLong();
        this.buH = parcel.readByte() == 1;
        this.buI = parcel.readByte() == 1;
        this.buJ = parcel.readByte() == 1;
        this.buK = parcel.readByte() == 1;
        this.buL = parcel.readLong();
        this.buM = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(new a(parcel.readInt(), parcel.readLong(), parcel.readLong()));
        }
        this.buN = Collections.unmodifiableList(arrayList);
        this.buO = parcel.readByte() != 1 ? false : z;
        this.buP = parcel.readLong();
        this.buQ = parcel.readInt();
        this.buR = parcel.readInt();
        this.buS = parcel.readInt();
        AppMethodBeat.o(92489);
    }

    static SpliceInsertCommand a(m mVar, long j2, u uVar) {
        long j3;
        long j4;
        boolean z;
        AppMethodBeat.i(92490);
        long dE = mVar.dE();
        boolean z2 = (mVar.readUnsignedByte() & 128) != 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        long j5 = -9223372036854775807L;
        List emptyList = Collections.emptyList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z6 = false;
        if (!z2) {
            int readUnsignedByte = mVar.readUnsignedByte();
            boolean z7 = (readUnsignedByte & 128) != 0;
            boolean z8 = (readUnsignedByte & 64) != 0;
            boolean z9 = (readUnsignedByte & 32) != 0;
            z5 = (readUnsignedByte & 16) != 0;
            if (z8 && !z5) {
                j5 = TimeSignalCommand.c(mVar, j2);
            }
            if (!z8) {
                int readUnsignedByte2 = mVar.readUnsignedByte();
                emptyList = new ArrayList(readUnsignedByte2);
                for (int i5 = 0; i5 < readUnsignedByte2; i5++) {
                    int readUnsignedByte3 = mVar.readUnsignedByte();
                    long j6 = -9223372036854775807L;
                    if (!z5) {
                        j6 = TimeSignalCommand.c(mVar, j2);
                    }
                    emptyList.add(new a(readUnsignedByte3, j6, uVar.ao(j6), (byte) 0));
                }
            }
            if (z9) {
                long readUnsignedByte4 = (long) mVar.readUnsignedByte();
                z = (128 & readUnsignedByte4) != 0;
                j4 = ((readUnsignedByte4 & 1) << 32) | mVar.dE();
            } else {
                j4 = -9223372036854775807L;
                z = false;
            }
            i2 = mVar.readUnsignedShort();
            i3 = mVar.readUnsignedByte();
            i4 = mVar.readUnsignedByte();
            j3 = j4;
            z6 = z;
            z4 = z8;
            z3 = z7;
        } else {
            j3 = -9223372036854775807L;
        }
        SpliceInsertCommand spliceInsertCommand = new SpliceInsertCommand(dE, z2, z3, z4, z5, j5, uVar.ao(j5), emptyList, z6, j3, i2, i3, i4);
        AppMethodBeat.o(92490);
        return spliceInsertCommand;
    }

    public static final class a {
        public final int buT;
        public final long buU;
        public final long buV;

        /* synthetic */ a(int i2, long j2, long j3, byte b2) {
            this(i2, j2, j3);
        }

        a(int i2, long j2, long j3) {
            this.buT = i2;
            this.buU = j2;
            this.buV = j3;
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int i3 = 1;
        AppMethodBeat.i(92491);
        parcel.writeLong(this.buG);
        parcel.writeByte((byte) (this.buH ? 1 : 0));
        parcel.writeByte((byte) (this.buI ? 1 : 0));
        parcel.writeByte((byte) (this.buJ ? 1 : 0));
        parcel.writeByte((byte) (this.buK ? 1 : 0));
        parcel.writeLong(this.buL);
        parcel.writeLong(this.buM);
        int size = this.buN.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            a aVar = this.buN.get(i4);
            parcel.writeInt(aVar.buT);
            parcel.writeLong(aVar.buU);
            parcel.writeLong(aVar.buV);
        }
        if (!this.buO) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeLong(this.buP);
        parcel.writeInt(this.buQ);
        parcel.writeInt(this.buR);
        parcel.writeInt(this.buS);
        AppMethodBeat.o(92491);
    }

    static {
        AppMethodBeat.i(92492);
        AppMethodBeat.o(92492);
    }
}
