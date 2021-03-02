package com.tencent.mm.plugin.appbrand.collector;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public class CollectSession implements Parcelable {
    public static final Parcelable.Creator<CollectSession> CREATOR = new Parcelable.Creator<CollectSession>() {
        /* class com.tencent.mm.plugin.appbrand.collector.CollectSession.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CollectSession[] newArray(int i2) {
            return new CollectSession[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CollectSession createFromParcel(Parcel parcel) {
            AppMethodBeat.i(146078);
            CollectSession collectSession = new CollectSession();
            collectSession.groupId = parcel.readString();
            collectSession.id = parcel.readString();
            collectSession.lbd = (TimePoint) parcel.readParcelable(CollectSession.class.getClassLoader());
            collectSession.lbg = parcel.readString();
            Bundle readBundle = parcel.readBundle();
            if (readBundle != null) {
                collectSession.dNV.putAll(readBundle);
            }
            TimePoint timePoint = collectSession.lbd;
            if (timePoint != null) {
                collectSession.lbf.put(timePoint.name, timePoint);
                while (timePoint.lbq.get() != null) {
                    timePoint = timePoint.lbq.get();
                    collectSession.lbf.put(timePoint.name, timePoint);
                }
                collectSession.lbe = timePoint;
            }
            AppMethodBeat.o(146078);
            return collectSession;
        }
    };
    public final Bundle dNV = new Bundle();
    String groupId;
    String id;
    TimePoint lbd;
    TimePoint lbe;
    final Map<String, TimePoint> lbf = new HashMap();
    String lbg;

    CollectSession() {
        AppMethodBeat.i(146079);
        AppMethodBeat.o(146079);
    }

    public CollectSession(String str) {
        AppMethodBeat.i(146080);
        this.id = str;
        AppMethodBeat.o(146080);
    }

    public final void EL(String str) {
        AppMethodBeat.i(146081);
        Assert.assertNull(this.lbd);
        this.lbd = new TimePoint(str, System.nanoTime());
        this.lbe = this.lbd;
        this.lbd.lbo.set(1);
        this.lbf.put(str, this.lbd);
        AppMethodBeat.o(146081);
    }

    public final void WI(String str) {
        AppMethodBeat.i(146082);
        Assert.assertNotNull(this.lbe);
        long nanoTime = System.nanoTime();
        TimePoint timePoint = this.lbf.get(str);
        if (timePoint == null) {
            TimePoint timePoint2 = new TimePoint(str, nanoTime);
            timePoint2.lbo.set(1);
            this.lbf.put(str, timePoint2);
            this.lbe.lbq.set(timePoint2);
            this.lbe = timePoint2;
            AppMethodBeat.o(146082);
            return;
        }
        timePoint.lbp.set((nanoTime + (timePoint.lbp.get() * ((long) timePoint.lbo.get()))) / ((long) (timePoint.lbo.get() + 1)));
        timePoint.lbo.incrementAndGet();
        AppMethodBeat.o(146082);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(146083);
        parcel.writeString(this.groupId);
        parcel.writeString(this.id);
        parcel.writeParcelable(this.lbd, i2);
        parcel.writeString(this.lbg);
        parcel.writeBundle(this.dNV);
        AppMethodBeat.o(146083);
    }

    static {
        AppMethodBeat.i(146084);
        AppMethodBeat.o(146084);
    }
}
