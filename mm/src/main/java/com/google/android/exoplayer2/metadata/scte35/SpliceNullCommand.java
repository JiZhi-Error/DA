package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SpliceNullCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceNullCommand> CREATOR = new Parcelable.Creator<SpliceNullCommand>() {
        /* class com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SpliceNullCommand[] newArray(int i2) {
            return new SpliceNullCommand[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SpliceNullCommand createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92493);
            SpliceNullCommand spliceNullCommand = new SpliceNullCommand();
            AppMethodBeat.o(92493);
            return spliceNullCommand;
        }
    };

    public final void writeToParcel(Parcel parcel, int i2) {
    }

    static {
        AppMethodBeat.i(92494);
        AppMethodBeat.o(92494);
    }
}
