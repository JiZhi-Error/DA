package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class ReloadNotify implements Parcelable {
    public static Parcelable.Creator<ReloadNotify> CREATOR = new Parcelable.Creator<ReloadNotify>() {
        /* class com.tencent.mm.plugin.wepkg.event.ReloadNotify.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ReloadNotify[] newArray(int i2) {
            return new ReloadNotify[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ReloadNotify createFromParcel(Parcel parcel) {
            AppMethodBeat.i(110645);
            ReloadNotify reloadNotify = new ReloadNotify(parcel, (byte) 0);
            AppMethodBeat.o(110645);
            return reloadNotify;
        }
    };
    public static Set<String> JMM = new HashSet();
    public String[] JMN;

    /* synthetic */ ReloadNotify(Parcel parcel, byte b2) {
        this(parcel);
    }

    static {
        AppMethodBeat.i(110648);
        AppMethodBeat.o(110648);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(110646);
        parcel.writeStringArray(this.JMN);
        AppMethodBeat.o(110646);
    }

    private ReloadNotify(Parcel parcel) {
        AppMethodBeat.i(110647);
        this.JMN = parcel.createStringArray();
        AppMethodBeat.o(110647);
    }
}
