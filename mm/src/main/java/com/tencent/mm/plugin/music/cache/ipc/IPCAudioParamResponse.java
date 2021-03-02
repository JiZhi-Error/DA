package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.j;

public class IPCAudioParamResponse implements Parcelable {
    public static final Parcelable.Creator<IPCAudioParamResponse> CREATOR = new Parcelable.Creator<IPCAudioParamResponse>() {
        /* class com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IPCAudioParamResponse[] newArray(int i2) {
            return new IPCAudioParamResponse[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IPCAudioParamResponse createFromParcel(Parcel parcel) {
            AppMethodBeat.i(137211);
            IPCAudioParamResponse iPCAudioParamResponse = new IPCAudioParamResponse(parcel);
            AppMethodBeat.o(137211);
            return iPCAudioParamResponse;
        }
    };
    public String dSF;
    public String fileName;
    public byte[] jfA;
    public int jfB;
    public String jfC;
    public int jfD;
    public String musicUrl;

    public IPCAudioParamResponse() {
    }

    public IPCAudioParamResponse(j jVar) {
        this.dSF = jVar.dSF;
        this.musicUrl = jVar.musicUrl;
        this.fileName = jVar.fileName;
        this.jfB = jVar.jfB;
        this.jfC = jVar.jfC;
        this.jfA = jVar.jfA;
        this.jfD = jVar.jfD;
    }

    public IPCAudioParamResponse(Parcel parcel) {
        AppMethodBeat.i(137212);
        this.dSF = parcel.readString();
        this.musicUrl = parcel.readString();
        this.fileName = parcel.readString();
        this.jfC = parcel.readString();
        this.jfB = parcel.readInt();
        this.jfD = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.jfA = new byte[readInt];
            parcel.readByteArray(this.jfA);
        }
        AppMethodBeat.o(137212);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(137213);
        parcel.writeString(this.dSF);
        parcel.writeString(this.musicUrl);
        parcel.writeString(this.fileName);
        parcel.writeString(this.jfC);
        parcel.writeInt(this.jfB);
        parcel.writeInt(this.jfD);
        if (this.jfA != null) {
            parcel.writeInt(this.jfA.length);
            parcel.writeByteArray(this.jfA);
            AppMethodBeat.o(137213);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.o(137213);
    }

    static {
        AppMethodBeat.i(137214);
        AppMethodBeat.o(137214);
    }
}
