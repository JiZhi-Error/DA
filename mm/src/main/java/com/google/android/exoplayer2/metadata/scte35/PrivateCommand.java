package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new Parcelable.Creator<PrivateCommand>() {
        /* class com.google.android.exoplayer2.metadata.scte35.PrivateCommand.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PrivateCommand[] newArray(int i2) {
            return new PrivateCommand[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PrivateCommand createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92480);
            PrivateCommand privateCommand = new PrivateCommand(parcel, (byte) 0);
            AppMethodBeat.o(92480);
            return privateCommand;
        }
    };
    public final long buC;
    public final long buD;
    public final byte[] buE;

    /* synthetic */ PrivateCommand(Parcel parcel, byte b2) {
        this(parcel);
    }

    private PrivateCommand(long j2, byte[] bArr, long j3) {
        this.buC = j3;
        this.buD = j2;
        this.buE = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        AppMethodBeat.i(92481);
        this.buC = parcel.readLong();
        this.buD = parcel.readLong();
        this.buE = new byte[parcel.readInt()];
        parcel.readByteArray(this.buE);
        AppMethodBeat.o(92481);
    }

    static PrivateCommand a(m mVar, int i2, long j2) {
        AppMethodBeat.i(92482);
        long dE = mVar.dE();
        byte[] bArr = new byte[(i2 - 4)];
        mVar.readBytes(bArr, 0, bArr.length);
        PrivateCommand privateCommand = new PrivateCommand(dE, bArr, j2);
        AppMethodBeat.o(92482);
        return privateCommand;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(92483);
        parcel.writeLong(this.buC);
        parcel.writeLong(this.buD);
        parcel.writeInt(this.buE.length);
        parcel.writeByteArray(this.buE);
        AppMethodBeat.o(92483);
    }

    static {
        AppMethodBeat.i(92484);
        AppMethodBeat.o(92484);
    }
}
