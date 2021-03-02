package com.tencent.mm.plugin.performance.elf;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ElfCheckResponse implements Parcelable {
    public static final Parcelable.Creator<ElfCheckResponse> CREATOR = new Parcelable.Creator<ElfCheckResponse>() {
        /* class com.tencent.mm.plugin.performance.elf.ElfCheckResponse.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ElfCheckResponse[] newArray(int i2) {
            return new ElfCheckResponse[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ElfCheckResponse createFromParcel(Parcel parcel) {
            AppMethodBeat.i(124979);
            ElfCheckResponse elfCheckResponse = new ElfCheckResponse(parcel);
            AppMethodBeat.o(124979);
            return elfCheckResponse;
        }
    };
    boolean AUn;
    boolean AUo;
    private String AUp;
    private long AUq;
    long AUr;
    Bundle Ew;
    public long dap;
    public boolean ded;
    String processName;

    public ElfCheckResponse(boolean z, long j2, boolean z2, boolean z3, String str, String str2) {
        this.AUo = z3;
        this.AUn = z2;
        this.processName = str;
        this.AUp = str2;
        this.AUr = 1000;
        this.dap = j2;
        this.ded = z;
    }

    public String toString() {
        AppMethodBeat.i(124980);
        String str = this.AUn + "," + this.AUo + "," + this.AUq + "," + this.processName + "," + this.AUp + "," + this.AUr;
        AppMethodBeat.o(124980);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        byte b2;
        byte b3 = 1;
        AppMethodBeat.i(124981);
        parcel.writeByte(this.AUn ? (byte) 1 : 0);
        if (this.ded) {
            b2 = 1;
        } else {
            b2 = 0;
        }
        parcel.writeByte(b2);
        parcel.writeLong(this.dap);
        if (!this.AUo) {
            b3 = 0;
        }
        parcel.writeByte(b3);
        parcel.writeString(this.AUp);
        parcel.writeString(this.processName);
        parcel.writeLong(this.AUq);
        parcel.writeLong(this.AUr);
        parcel.writeBundle(this.Ew);
        AppMethodBeat.o(124981);
    }

    protected ElfCheckResponse(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(124982);
        this.AUn = parcel.readByte() != 0;
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.ded = z;
        this.dap = parcel.readLong();
        this.AUo = parcel.readByte() == 0 ? false : z2;
        this.AUp = parcel.readString();
        this.processName = parcel.readString();
        this.AUq = parcel.readLong();
        this.AUr = parcel.readLong();
        this.Ew = parcel.readBundle();
        AppMethodBeat.o(124982);
    }

    static {
        AppMethodBeat.i(124983);
        AppMethodBeat.o(124983);
    }
}
