package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new Parcelable.Creator<SpliceScheduleCommand>() {
        /* class com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SpliceScheduleCommand[] newArray(int i2) {
            return new SpliceScheduleCommand[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SpliceScheduleCommand createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92495);
            SpliceScheduleCommand spliceScheduleCommand = new SpliceScheduleCommand(parcel, (byte) 0);
            AppMethodBeat.o(92495);
            return spliceScheduleCommand;
        }
    };
    public final List<b> buW;

    /* synthetic */ SpliceScheduleCommand(Parcel parcel, byte b2) {
        this(parcel);
    }

    public static final class b {
        public final long buG;
        public final boolean buH;
        public final boolean buI;
        public final boolean buJ;
        public final List<a> buN;
        public final boolean buO;
        public final long buP;
        public final int buQ;
        public final int buR;
        public final int buS;
        public final long buX;

        private b(long j2, boolean z, boolean z2, boolean z3, List<a> list, long j3, boolean z4, long j4, int i2, int i3, int i4) {
            AppMethodBeat.i(92496);
            this.buG = j2;
            this.buH = z;
            this.buI = z2;
            this.buJ = z3;
            this.buN = Collections.unmodifiableList(list);
            this.buX = j3;
            this.buO = z4;
            this.buP = j4;
            this.buQ = i2;
            this.buR = i3;
            this.buS = i4;
            AppMethodBeat.o(92496);
        }

        b(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(92497);
            this.buG = parcel.readLong();
            this.buH = parcel.readByte() == 1;
            this.buI = parcel.readByte() == 1;
            this.buJ = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(new a(parcel.readInt(), parcel.readLong()));
            }
            this.buN = Collections.unmodifiableList(arrayList);
            this.buX = parcel.readLong();
            this.buO = parcel.readByte() != 1 ? false : z;
            this.buP = parcel.readLong();
            this.buQ = parcel.readInt();
            this.buR = parcel.readInt();
            this.buS = parcel.readInt();
            AppMethodBeat.o(92497);
        }

        static b z(m mVar) {
            long j2;
            ArrayList arrayList;
            long j3;
            AppMethodBeat.i(92498);
            long dE = mVar.dE();
            boolean z = (mVar.readUnsignedByte() & 128) != 0;
            boolean z2 = false;
            boolean z3 = false;
            long j4 = -9223372036854775807L;
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            boolean z4 = false;
            if (!z) {
                int readUnsignedByte = mVar.readUnsignedByte();
                z2 = (readUnsignedByte & 128) != 0;
                boolean z5 = (readUnsignedByte & 64) != 0;
                boolean z6 = (readUnsignedByte & 32) != 0;
                if (z5) {
                    j4 = mVar.dE();
                }
                if (!z5) {
                    int readUnsignedByte2 = mVar.readUnsignedByte();
                    arrayList = new ArrayList(readUnsignedByte2);
                    for (int i5 = 0; i5 < readUnsignedByte2; i5++) {
                        arrayList.add(new a(mVar.readUnsignedByte(), mVar.dE(), (byte) 0));
                    }
                } else {
                    arrayList = arrayList2;
                }
                if (z6) {
                    long readUnsignedByte3 = (long) mVar.readUnsignedByte();
                    boolean z7 = (128 & readUnsignedByte3) != 0;
                    j3 = ((readUnsignedByte3 & 1) << 32) | mVar.dE();
                    z4 = z7;
                } else {
                    j3 = -9223372036854775807L;
                }
                i2 = mVar.readUnsignedShort();
                i3 = mVar.readUnsignedByte();
                i4 = mVar.readUnsignedByte();
                j2 = j3;
                arrayList2 = arrayList;
                z3 = z5;
            } else {
                j2 = -9223372036854775807L;
            }
            b bVar = new b(dE, z, z2, z3, arrayList2, j4, z4, j2, i2, i3, i4);
            AppMethodBeat.o(92498);
            return bVar;
        }
    }

    public static final class a {
        public final int buT;
        public final long buX;

        /* synthetic */ a(int i2, long j2, byte b2) {
            this(i2, j2);
        }

        a(int i2, long j2) {
            this.buT = i2;
            this.buX = j2;
        }
    }

    private SpliceScheduleCommand(List<b> list) {
        AppMethodBeat.i(92499);
        this.buW = Collections.unmodifiableList(list);
        AppMethodBeat.o(92499);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        AppMethodBeat.i(92500);
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(new b(parcel));
        }
        this.buW = Collections.unmodifiableList(arrayList);
        AppMethodBeat.o(92500);
    }

    static SpliceScheduleCommand y(m mVar) {
        AppMethodBeat.i(92501);
        int readUnsignedByte = mVar.readUnsignedByte();
        ArrayList arrayList = new ArrayList(readUnsignedByte);
        for (int i2 = 0; i2 < readUnsignedByte; i2++) {
            arrayList.add(b.z(mVar));
        }
        SpliceScheduleCommand spliceScheduleCommand = new SpliceScheduleCommand(arrayList);
        AppMethodBeat.o(92501);
        return spliceScheduleCommand;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(92502);
        int size = this.buW.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.buW.get(i3);
            parcel.writeLong(bVar.buG);
            parcel.writeByte((byte) (bVar.buH ? 1 : 0));
            parcel.writeByte((byte) (bVar.buI ? 1 : 0));
            parcel.writeByte((byte) (bVar.buJ ? 1 : 0));
            int size2 = bVar.buN.size();
            parcel.writeInt(size2);
            for (int i4 = 0; i4 < size2; i4++) {
                a aVar = bVar.buN.get(i4);
                parcel.writeInt(aVar.buT);
                parcel.writeLong(aVar.buX);
            }
            parcel.writeLong(bVar.buX);
            parcel.writeByte((byte) (bVar.buO ? 1 : 0));
            parcel.writeLong(bVar.buP);
            parcel.writeInt(bVar.buQ);
            parcel.writeInt(bVar.buR);
            parcel.writeInt(bVar.buS);
        }
        AppMethodBeat.o(92502);
    }

    static {
        AppMethodBeat.i(92503);
        AppMethodBeat.o(92503);
    }
}
