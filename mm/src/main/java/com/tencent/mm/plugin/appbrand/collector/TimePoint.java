package com.tencent.mm.plugin.appbrand.collector;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class TimePoint implements Parcelable {
    public static final Parcelable.Creator<TimePoint> CREATOR = new Parcelable.Creator<TimePoint>() {
        /* class com.tencent.mm.plugin.appbrand.collector.TimePoint.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimePoint[] newArray(int i2) {
            return new TimePoint[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimePoint createFromParcel(Parcel parcel) {
            AppMethodBeat.i(146125);
            TimePoint timePoint = new TimePoint();
            timePoint.name = parcel.readString();
            timePoint.lbp.set(parcel.readLong());
            timePoint.lbo.set(parcel.readInt());
            timePoint.lbq.set((TimePoint) parcel.readParcelable(TimePoint.class.getClassLoader()));
            AppMethodBeat.o(146125);
            return timePoint;
        }
    };
    final AtomicInteger lbo;
    final AtomicLong lbp;
    final AtomicReference<TimePoint> lbq;
    String name;

    TimePoint() {
        AppMethodBeat.i(146126);
        this.lbo = new AtomicInteger();
        this.lbp = new AtomicLong();
        this.lbq = new AtomicReference<>();
        this.name = "";
        AppMethodBeat.o(146126);
    }

    public TimePoint(String str, long j2) {
        AppMethodBeat.i(146127);
        this.lbo = new AtomicInteger();
        this.lbp = new AtomicLong();
        this.lbq = new AtomicReference<>();
        this.name = str;
        this.lbp.set(j2);
        AppMethodBeat.o(146127);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(146128);
        parcel.writeString(this.name);
        parcel.writeLong(this.lbp.get());
        parcel.writeInt(this.lbo.get());
        parcel.writeParcelable(this.lbq.get(), i2);
        AppMethodBeat.o(146128);
    }

    static {
        AppMethodBeat.i(146129);
        AppMethodBeat.o(146129);
    }
}
