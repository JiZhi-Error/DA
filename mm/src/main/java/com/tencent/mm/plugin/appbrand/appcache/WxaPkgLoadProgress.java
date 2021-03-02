package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.pluginsdk.j.a.c.k;

public class WxaPkgLoadProgress implements Parcelable, c, k {
    public static final Parcelable.Creator<WxaPkgLoadProgress> CREATOR = new Parcelable.Creator<WxaPkgLoadProgress>() {
        /* class com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WxaPkgLoadProgress[] newArray(int i2) {
            return new WxaPkgLoadProgress[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WxaPkgLoadProgress createFromParcel(Parcel parcel) {
            AppMethodBeat.i(90639);
            WxaPkgLoadProgress wxaPkgLoadProgress = new WxaPkgLoadProgress(parcel);
            AppMethodBeat.o(90639);
            return wxaPkgLoadProgress;
        }
    };
    public long kNs = -1;
    public long kNt = -1;
    public int progress = 0;

    public WxaPkgLoadProgress(int i2, long j2, long j3) {
        AppMethodBeat.i(230564);
        this.progress = i2;
        this.kNs = j2;
        this.kNt = j3;
        if (this.progress <= 0 && this.kNs > 0 && this.kNt > 0) {
            this.progress = Math.max(Math.round((((float) this.kNs) / ((float) this.kNt)) * 100.0f), 0);
        }
        AppMethodBeat.o(230564);
    }

    public WxaPkgLoadProgress() {
    }

    protected WxaPkgLoadProgress(Parcel parcel) {
        AppMethodBeat.i(90640);
        this.progress = parcel.readInt();
        this.kNs = parcel.readLong();
        this.kNt = parcel.readLong();
        AppMethodBeat.o(90640);
    }

    static {
        AppMethodBeat.i(90643);
        AppMethodBeat.o(90643);
    }

    public String toString() {
        AppMethodBeat.i(90641);
        String str = "WxaPkgLoadProgress{progress=" + this.progress + ", writtenLength=" + this.kNs + ", totalLength=" + this.kNt + '}';
        AppMethodBeat.o(90641);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(90642);
        parcel.writeInt(this.progress);
        parcel.writeLong(this.kNs);
        parcel.writeLong(this.kNt);
        AppMethodBeat.o(90642);
    }

    @Override // com.tencent.mm.plugin.appbrand.p.c
    public final int getProgress() {
        return this.progress;
    }

    @Override // com.tencent.mm.plugin.appbrand.p.c
    public final long bww() {
        return this.kNs;
    }

    @Override // com.tencent.mm.plugin.appbrand.p.c
    public final long getTotalLength() {
        return this.kNt;
    }
}
