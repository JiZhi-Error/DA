package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.event.c;
import java.util.HashSet;
import java.util.Set;

public class ForceUpdateNotify implements Parcelable {
    public static Parcelable.Creator<ForceUpdateNotify> CREATOR = new Parcelable.Creator<ForceUpdateNotify>() {
        /* class com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ForceUpdateNotify[] newArray(int i2) {
            return new ForceUpdateNotify[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ForceUpdateNotify createFromParcel(Parcel parcel) {
            AppMethodBeat.i(110632);
            ForceUpdateNotify forceUpdateNotify = new ForceUpdateNotify(parcel, (byte) 0);
            AppMethodBeat.o(110632);
            return forceUpdateNotify;
        }
    };
    public static Set<String> JMM = new HashSet();
    public String[] JMN;

    /* synthetic */ ForceUpdateNotify(Parcel parcel, byte b2) {
        this(parcel);
    }

    static {
        AppMethodBeat.i(110637);
        AppMethodBeat.o(110637);
    }

    public static void add(String str) {
        AppMethodBeat.i(110633);
        JMM.add(str);
        AppMethodBeat.o(110633);
    }

    public static void dpY() {
        AppMethodBeat.i(110634);
        if (JMM.size() != 0) {
            Set<String> set = JMM;
            c.a(new ForceUpdateNotify((String[]) set.toArray(new String[set.size()])), new c.a() {
                /* class com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.wepkg.event.c.a
                public final void exp() {
                    AppMethodBeat.i(110631);
                    ForceUpdateNotify.JMM.clear();
                    AppMethodBeat.o(110631);
                }
            });
        }
        AppMethodBeat.o(110634);
    }

    private ForceUpdateNotify(String[] strArr) {
        this.JMN = strArr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(110635);
        parcel.writeStringArray(this.JMN);
        AppMethodBeat.o(110635);
    }

    private ForceUpdateNotify(Parcel parcel) {
        AppMethodBeat.i(110636);
        this.JMN = parcel.createStringArray();
        AppMethodBeat.o(110636);
    }
}
