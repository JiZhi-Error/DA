package com.tencent.mm.plugin.appbrand.task;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.a;
import kotlin.x;

public class AppBrandPreloadProfiler implements Parcelable {
    public static final Parcelable.Creator<AppBrandPreloadProfiler> CREATOR = new Parcelable.Creator<AppBrandPreloadProfiler>() {
        /* class com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandPreloadProfiler[] newArray(int i2) {
            return new AppBrandPreloadProfiler[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandPreloadProfiler createFromParcel(Parcel parcel) {
            AppMethodBeat.i(48361);
            AppBrandPreloadProfiler appBrandPreloadProfiler = new AppBrandPreloadProfiler(parcel);
            AppMethodBeat.o(48361);
            return appBrandPreloadProfiler;
        }
    };
    public long endTime = MAlarmHandler.NEXT_FIRE_INTERVAL;
    public int level;
    public long nOC = MAlarmHandler.NEXT_FIRE_INTERVAL;
    public int nOD = 0;
    public long nOE = MAlarmHandler.NEXT_FIRE_INTERVAL;
    public long nOF = MAlarmHandler.NEXT_FIRE_INTERVAL;
    public long startTime = MAlarmHandler.NEXT_FIRE_INTERVAL;

    public final long bVM() {
        AppMethodBeat.i(227438);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.nOC = elapsedRealtime;
        AppMethodBeat.o(227438);
        return elapsedRealtime;
    }

    public final long bVN() {
        AppMethodBeat.i(48362);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.endTime = elapsedRealtime;
        AppMethodBeat.o(48362);
        return elapsedRealtime;
    }

    static void A(a<x> aVar) {
        AppMethodBeat.i(227439);
        aVar.invoke();
        AppMethodBeat.o(227439);
    }

    public String toString() {
        AppMethodBeat.i(48363);
        if (this.nOC == MAlarmHandler.NEXT_FIRE_INTERVAL || this.nOE == MAlarmHandler.NEXT_FIRE_INTERVAL || this.startTime == MAlarmHandler.NEXT_FIRE_INTERVAL || this.endTime == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            String safeFormatString = Util.safeFormatString("[AppBrandPreloadProfiler] in panic req = [%d]ms, process = [%d]ms, start = [%d]ms, end = [%d]ms", Long.valueOf(this.nOC), Long.valueOf(this.nOE), Long.valueOf(this.startTime), Long.valueOf(this.endTime));
            AppMethodBeat.o(48363);
            return safeFormatString;
        }
        String safeFormatString2 = Util.safeFormatString("[AppBrandPreloadProfiler] process-start costs [%d]ms, trans-thread costs [%d]ms, preload component costs [%d]ms", Long.valueOf(this.nOE - this.nOC), Long.valueOf(this.startTime - this.nOE), Long.valueOf(this.endTime - this.startTime));
        AppMethodBeat.o(48363);
        return safeFormatString2;
    }

    public AppBrandPreloadProfiler() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(48364);
        parcel.writeLong(this.nOC);
        parcel.writeLong(this.nOE);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeLong(this.nOF);
        AppMethodBeat.o(48364);
    }

    protected AppBrandPreloadProfiler(Parcel parcel) {
        AppMethodBeat.i(48365);
        this.nOC = parcel.readLong();
        this.nOE = parcel.readLong();
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.nOF = parcel.readLong();
        AppMethodBeat.o(48365);
    }

    static {
        AppMethodBeat.i(48366);
        AppMethodBeat.o(48366);
    }
}
