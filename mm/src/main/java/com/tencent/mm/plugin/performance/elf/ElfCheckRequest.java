package com.tencent.mm.plugin.performance.elf;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ElfCheckRequest implements Parcelable {
    public static final Parcelable.Creator<ElfCheckRequest> CREATOR = new Parcelable.Creator<ElfCheckRequest>() {
        /* class com.tencent.mm.plugin.performance.elf.ElfCheckRequest.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ElfCheckRequest[] newArray(int i2) {
            return new ElfCheckRequest[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ElfCheckRequest createFromParcel(Parcel parcel) {
            AppMethodBeat.i(124974);
            ElfCheckRequest elfCheckRequest = new ElfCheckRequest(parcel);
            AppMethodBeat.o(124974);
            return elfCheckRequest;
        }
    };
    public long dap = 0;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(124975);
        parcel.writeLong(this.dap);
        AppMethodBeat.o(124975);
    }

    public ElfCheckRequest() {
    }

    protected ElfCheckRequest(Parcel parcel) {
        AppMethodBeat.i(124976);
        this.dap = parcel.readLong();
        AppMethodBeat.o(124976);
    }

    static {
        AppMethodBeat.i(124977);
        AppMethodBeat.o(124977);
    }
}
