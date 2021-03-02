package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class SampleTask1 extends MainProcessTask {
    public static final Parcelable.Creator<SampleTask1> CREATOR = new Parcelable.Creator<SampleTask1>() {
        /* class com.tencent.mm.plugin.appbrand.ipc.SampleTask1.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SampleTask1[] newArray(int i2) {
            return new SampleTask1[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SampleTask1 createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134858);
            SampleTask1 sampleTask1 = new SampleTask1(parcel);
            AppMethodBeat.o(134858);
            return sampleTask1;
        }
    };
    public String lxb;
    public String lxc;

    public SampleTask1(Parcel parcel) {
        AppMethodBeat.i(134859);
        f(parcel);
        AppMethodBeat.o(134859);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(134860);
        Log.e("SampleTask", this.lxb);
        this.lxc = "String from Main Process";
        bDU();
        AppMethodBeat.o(134860);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(134861);
        Log.e("SampleTask", this.lxc);
        AppMethodBeat.o(134861);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(134862);
        this.lxb = parcel.readString();
        this.lxc = parcel.readString();
        AppMethodBeat.o(134862);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(134863);
        parcel.writeString(this.lxb);
        parcel.writeString(this.lxc);
        AppMethodBeat.o(134863);
    }

    static {
        AppMethodBeat.i(134864);
        AppMethodBeat.o(134864);
    }
}
