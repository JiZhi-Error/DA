package com.tencent.mm.ipcinvoker.wx_extension.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.ipcinvoker.wx_extension.a;

public class IPCRunCgiRespWrapper implements Parcelable {
    public static final Parcelable.Creator<IPCRunCgiRespWrapper> CREATOR = new Parcelable.Creator<IPCRunCgiRespWrapper>() {
        /* class com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IPCRunCgiRespWrapper[] newArray(int i2) {
            return new IPCRunCgiRespWrapper[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IPCRunCgiRespWrapper createFromParcel(Parcel parcel) {
            AppMethodBeat.i(146434);
            IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper(parcel);
            AppMethodBeat.o(146434);
            return iPCRunCgiRespWrapper;
        }
    };
    public int errCode;
    public String errMsg;
    public int errType;
    public d rr;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(146435);
        parcel.writeInt(this.errType);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.errMsg);
        c.a(this.rr, parcel);
        AppMethodBeat.o(146435);
    }

    public IPCRunCgiRespWrapper() {
    }

    IPCRunCgiRespWrapper(Parcel parcel) {
        AppMethodBeat.i(146436);
        this.errType = parcel.readInt();
        this.errCode = parcel.readInt();
        this.errMsg = parcel.readString();
        this.rr = (d) c.a(a.class.getName(), parcel);
        AppMethodBeat.o(146436);
    }

    static {
        AppMethodBeat.i(146438);
        AppMethodBeat.o(146438);
    }

    public static IPCRunCgiRespWrapper b(d dVar) {
        AppMethodBeat.i(225236);
        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
        iPCRunCgiRespWrapper.rr = dVar;
        iPCRunCgiRespWrapper.errMsg = null;
        iPCRunCgiRespWrapper.errType = 3;
        iPCRunCgiRespWrapper.errCode = -2;
        AppMethodBeat.o(225236);
        return iPCRunCgiRespWrapper;
    }
}
