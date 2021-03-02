package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class SampleTask2 extends MainProcessTask {
    public static final Parcelable.Creator<SampleTask2> CREATOR = new Parcelable.Creator<SampleTask2>() {
        /* class com.tencent.mm.plugin.appbrand.ipc.SampleTask2.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SampleTask2[] newArray(int i2) {
            return new SampleTask2[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SampleTask2 createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134865);
            SampleTask2 sampleTask2 = new SampleTask2();
            AppMethodBeat.o(134865);
            return sampleTask2;
        }
    };

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(134866);
        Log.e("SampleTask2", "Run in Main Process");
        AppMethodBeat.o(134866);
    }

    static {
        AppMethodBeat.i(134867);
        AppMethodBeat.o(134867);
    }
}
