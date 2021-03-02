package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCAudioParamRequest implements Parcelable {
    public static final Parcelable.Creator<IPCAudioParamRequest> CREATOR = new Parcelable.Creator<IPCAudioParamRequest>() {
        /* class com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IPCAudioParamRequest[] newArray(int i2) {
            return new IPCAudioParamRequest[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IPCAudioParamRequest createFromParcel(Parcel parcel) {
            AppMethodBeat.i(137207);
            IPCAudioParamRequest iPCAudioParamRequest = new IPCAudioParamRequest(parcel);
            AppMethodBeat.o(137207);
            return iPCAudioParamRequest;
        }
    };
    public int AiS = 0;
    public String dSF = "";
    public byte[] jfA;
    public String mimeType = "";

    public IPCAudioParamRequest() {
    }

    public IPCAudioParamRequest(Parcel parcel) {
        AppMethodBeat.i(137208);
        this.dSF = parcel.readString();
        this.AiS = parcel.readInt();
        this.mimeType = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.jfA = new byte[readInt];
            parcel.readByteArray(this.jfA);
        }
        AppMethodBeat.o(137208);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(137209);
        parcel.writeString(this.dSF);
        parcel.writeInt(this.AiS);
        parcel.writeString(this.mimeType);
        if (this.jfA != null) {
            parcel.writeInt(this.jfA.length);
            parcel.writeByteArray(this.jfA);
            AppMethodBeat.o(137209);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.o(137209);
    }

    static {
        AppMethodBeat.i(137210);
        AppMethodBeat.o(137210);
    }
}
