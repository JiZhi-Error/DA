package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class UserAuthItemParcelable implements Parcelable {
    public static final Parcelable.Creator<UserAuthItemParcelable> CREATOR = new Parcelable.Creator<UserAuthItemParcelable>() {
        /* class com.tencent.mm.plugin.setting.model.UserAuthItemParcelable.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserAuthItemParcelable[] newArray(int i2) {
            return new UserAuthItemParcelable[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserAuthItemParcelable createFromParcel(Parcel parcel) {
            AppMethodBeat.i(73802);
            UserAuthItemParcelable userAuthItemParcelable = new UserAuthItemParcelable();
            userAuthItemParcelable.scope = parcel.readString();
            userAuthItemParcelable.CYp = parcel.readString();
            userAuthItemParcelable.state = parcel.readInt();
            userAuthItemParcelable.CYq = parcel.readInt();
            AppMethodBeat.o(73802);
            return userAuthItemParcelable;
        }
    };
    public String CYp;
    public int CYq;
    public String scope;
    public int state;

    static {
        AppMethodBeat.i(73804);
        AppMethodBeat.o(73804);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(73803);
        parcel.writeString(this.scope);
        parcel.writeString(this.CYp);
        parcel.writeInt(this.state);
        parcel.writeInt(this.CYq);
        AppMethodBeat.o(73803);
    }
}
