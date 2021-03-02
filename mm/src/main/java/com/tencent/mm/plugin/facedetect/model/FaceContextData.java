package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public class FaceContextData implements Parcelable {
    public static final Parcelable.Creator<FaceContextData> CREATOR = new Parcelable.Creator<FaceContextData>() {
        /* class com.tencent.mm.plugin.facedetect.model.FaceContextData.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FaceContextData[] newArray(int i2) {
            return new FaceContextData[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FaceContextData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103707);
            FaceContextData faceContextData = new FaceContextData(parcel);
            AppMethodBeat.o(103707);
            return faceContextData;
        }
    };
    private static volatile FaceContextData sQH = null;
    public long sQI = -1;

    static {
        AppMethodBeat.i(103712);
        AppMethodBeat.o(103712);
    }

    public static void a(FaceContextData faceContextData) {
        AppMethodBeat.i(103708);
        if (faceContextData == null) {
            sQH = null;
            AppMethodBeat.o(103708);
        } else if (sQH != null) {
            b(faceContextData);
            AppMethodBeat.o(103708);
        } else {
            synchronized (FaceContextData.class) {
                try {
                    if (sQH != null) {
                        b(faceContextData);
                        return;
                    }
                    sQH = faceContextData;
                    AppMethodBeat.o(103708);
                } finally {
                    AppMethodBeat.o(103708);
                }
            }
        }
    }

    private static void b(FaceContextData faceContextData) {
        AppMethodBeat.i(103709);
        Assert.assertTrue((sQH == null || faceContextData == null) ? false : true);
        sQH.sQI = faceContextData.sQI;
        AppMethodBeat.o(103709);
    }

    public static synchronized FaceContextData cST() {
        FaceContextData faceContextData;
        synchronized (FaceContextData.class) {
            faceContextData = sQH;
        }
        return faceContextData;
    }

    protected FaceContextData(Parcel parcel) {
        AppMethodBeat.i(103710);
        this.sQI = parcel.readLong();
        AppMethodBeat.o(103710);
    }

    public FaceContextData() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(103711);
        parcel.writeLong(this.sQI);
        AppMethodBeat.o(103711);
    }
}
