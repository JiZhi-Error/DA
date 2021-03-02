package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new Parcelable.Creator<TimeSignalCommand>() {
        /* class com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeSignalCommand[] newArray(int i2) {
            return new TimeSignalCommand[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeSignalCommand createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92504);
            TimeSignalCommand timeSignalCommand = new TimeSignalCommand(parcel.readLong(), parcel.readLong(), (byte) 0);
            AppMethodBeat.o(92504);
            return timeSignalCommand;
        }
    };
    public final long buY;
    public final long buZ;

    /* synthetic */ TimeSignalCommand(long j2, long j3, byte b2) {
        this(j2, j3);
    }

    private TimeSignalCommand(long j2, long j3) {
        this.buY = j2;
        this.buZ = j3;
    }

    static TimeSignalCommand b(m mVar, long j2, u uVar) {
        AppMethodBeat.i(92505);
        long c2 = c(mVar, j2);
        TimeSignalCommand timeSignalCommand = new TimeSignalCommand(c2, uVar.ao(c2));
        AppMethodBeat.o(92505);
        return timeSignalCommand;
    }

    static long c(m mVar, long j2) {
        AppMethodBeat.i(92506);
        long readUnsignedByte = (long) mVar.readUnsignedByte();
        long j3 = -9223372036854775807L;
        if ((128 & readUnsignedByte) != 0) {
            j3 = ((((1 & readUnsignedByte) << 32) | mVar.dE()) + j2) & 8589934591L;
        }
        AppMethodBeat.o(92506);
        return j3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(92507);
        parcel.writeLong(this.buY);
        parcel.writeLong(this.buZ);
        AppMethodBeat.o(92507);
    }

    static {
        AppMethodBeat.i(92508);
        AppMethodBeat.o(92508);
    }
}
