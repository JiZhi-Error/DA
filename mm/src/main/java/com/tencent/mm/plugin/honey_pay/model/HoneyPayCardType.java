package com.tencent.mm.plugin.honey_pay.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public class HoneyPayCardType implements Parcelable {
    public static final Parcelable.Creator<HoneyPayCardType> CREATOR = new Parcelable.Creator<HoneyPayCardType>() {
        /* class com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ HoneyPayCardType[] newArray(int i2) {
            return new HoneyPayCardType[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ HoneyPayCardType createFromParcel(Parcel parcel) {
            AppMethodBeat.i(64640);
            HoneyPayCardType honeyPayCardType = new HoneyPayCardType(parcel);
            AppMethodBeat.o(64640);
            return honeyPayCardType;
        }
    };
    public byte[] zy;

    public HoneyPayCardType(cak cak) {
        AppMethodBeat.i(64641);
        try {
            this.zy = cak.toByteArray();
            AppMethodBeat.o(64641);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.HoneyPayCardType", e2, "", new Object[0]);
            AppMethodBeat.o(64641);
        }
    }

    protected HoneyPayCardType(Parcel parcel) {
        AppMethodBeat.i(64642);
        this.zy = new byte[parcel.readInt()];
        parcel.readByteArray(this.zy);
        AppMethodBeat.o(64642);
    }

    static {
        AppMethodBeat.i(64644);
        AppMethodBeat.o(64644);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(64643);
        parcel.writeInt(this.zy.length);
        parcel.writeByteArray(this.zy);
        AppMethodBeat.o(64643);
    }
}
