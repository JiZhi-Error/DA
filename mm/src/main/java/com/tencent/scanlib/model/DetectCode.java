package com.tencent.scanlib.model;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class DetectCode implements Parcelable {
    public static final Parcelable.Creator<DetectCode> CREATOR = new Parcelable.Creator<DetectCode>() {
        /* class com.tencent.scanlib.model.DetectCode.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DetectCode[] newArray(int i2) {
            return new DetectCode[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DetectCode createFromParcel(Parcel parcel) {
            AppMethodBeat.i(3564);
            ArrayList arrayList = new ArrayList();
            parcel.readTypedList(arrayList, Point.CREATOR);
            DetectCode detectCode = new DetectCode(parcel.readInt(), arrayList, parcel.readFloat());
            AppMethodBeat.o(3564);
            return detectCode;
        }
    };
    public int ROK;
    public float ROL;
    public List<Point> points;

    public DetectCode(int i2, List<Point> list, float f2) {
        this.ROK = i2;
        this.points = list;
        this.ROL = f2;
    }

    static {
        AppMethodBeat.i(3566);
        AppMethodBeat.o(3566);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(3565);
        parcel.writeInt(this.ROK);
        parcel.writeTypedList(this.points);
        parcel.writeFloat(this.ROL);
        AppMethodBeat.o(3565);
    }
}
