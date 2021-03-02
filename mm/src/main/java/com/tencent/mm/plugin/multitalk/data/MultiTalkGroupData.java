package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;

public class MultiTalkGroupData implements Parcelable {
    public static final Parcelable.Creator<MultiTalkGroupData> CREATOR = new Parcelable.Creator<MultiTalkGroupData>() {
        /* class com.tencent.mm.plugin.multitalk.data.MultiTalkGroupData.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MultiTalkGroupData[] newArray(int i2) {
            return new MultiTalkGroupData[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MultiTalkGroupData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(114408);
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.zHD = Util.nullAs(parcel.readString(), "");
            multiTalkGroup.RGY = Util.nullAs(parcel.readString(), "");
            multiTalkGroup.zHE = Util.nullAs(parcel.readString(), "");
            multiTalkGroup.RCJ = parcel.readInt();
            multiTalkGroup.RGZ = Util.nullAs(parcel.readString(), "");
            int readInt = parcel.readInt();
            multiTalkGroup.RHa = new ArrayList();
            for (int i2 = 0; i2 < readInt; i2++) {
                multiTalkGroup.RHa.add(((MultiTalkGroupMemberData) parcel.readParcelable(MultiTalkGroupMemberData.class.getClassLoader())).zHg);
            }
            MultiTalkGroupData multiTalkGroupData = new MultiTalkGroupData(multiTalkGroup);
            AppMethodBeat.o(114408);
            return multiTalkGroupData;
        }
    };
    private MultiTalkGroup zHf;

    public MultiTalkGroupData() {
    }

    public MultiTalkGroupData(MultiTalkGroup multiTalkGroup) {
        this.zHf = multiTalkGroup;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(114409);
        parcel.writeString(Util.nullAs(this.zHf.zHD, ""));
        parcel.writeString(Util.nullAs(this.zHf.RGY, ""));
        parcel.writeString(Util.nullAs(this.zHf.zHE, ""));
        parcel.writeInt(this.zHf.RCJ);
        parcel.writeString(Util.nullAs(this.zHf.RGZ, ""));
        parcel.writeInt(this.zHf.RHa.size());
        for (int i3 = 0; i3 < this.zHf.RHa.size(); i3++) {
            parcel.writeParcelable(new MultiTalkGroupMemberData(this.zHf.RHa.get(i3)), i2);
        }
        AppMethodBeat.o(114409);
    }

    static {
        AppMethodBeat.i(114410);
        AppMethodBeat.o(114410);
    }
}
