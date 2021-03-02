package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public class GroupIDKeyDataInfo implements Parcelable {
    public static final Parcelable.Creator<GroupIDKeyDataInfo> CREATOR = new Parcelable.Creator<GroupIDKeyDataInfo>() {
        /* class com.tencent.mm.plugin.report.service.GroupIDKeyDataInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GroupIDKeyDataInfo[] newArray(int i2) {
            return new GroupIDKeyDataInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GroupIDKeyDataInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(143811);
            GroupIDKeyDataInfo groupIDKeyDataInfo = new GroupIDKeyDataInfo(parcel);
            AppMethodBeat.o(143811);
            return groupIDKeyDataInfo;
        }
    };
    ArrayList<IDKey> CxX = new ArrayList<>();
    public boolean CxY;

    GroupIDKeyDataInfo(ArrayList<IDKey> arrayList) {
        AppMethodBeat.i(143812);
        this.CxX = arrayList;
        this.CxY = false;
        AppMethodBeat.o(143812);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(143813);
        parcel.writeTypedList(this.CxX);
        parcel.writeInt(this.CxY ? 1 : 0);
        AppMethodBeat.o(143813);
    }

    protected GroupIDKeyDataInfo(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(143814);
        parcel.readTypedList(this.CxX, IDKey.CREATOR);
        this.CxY = parcel.readInt() != 1 ? false : z;
        AppMethodBeat.o(143814);
    }

    static {
        AppMethodBeat.i(143815);
        AppMethodBeat.o(143815);
    }
}
