package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;

public class MultiTalkGroupMemberData implements Parcelable {
    public static final Parcelable.Creator<MultiTalkGroupMemberData> CREATOR = new Parcelable.Creator<MultiTalkGroupMemberData>() {
        /* class com.tencent.mm.plugin.multitalk.data.MultiTalkGroupMemberData.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MultiTalkGroupMemberData[] newArray(int i2) {
            return new MultiTalkGroupMemberData[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MultiTalkGroupMemberData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(114411);
            MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
            multiTalkGroupMember.RHb = Util.nullAs(parcel.readString(), "");
            multiTalkGroupMember.RHc = Util.nullAs(parcel.readString(), "");
            multiTalkGroupMember.status = parcel.readInt();
            multiTalkGroupMember.bDZ = parcel.readInt();
            multiTalkGroupMember.RGf = parcel.readInt();
            MultiTalkGroupMemberData multiTalkGroupMemberData = new MultiTalkGroupMemberData(multiTalkGroupMember);
            AppMethodBeat.o(114411);
            return multiTalkGroupMemberData;
        }
    };
    MultiTalkGroupMember zHg;

    public MultiTalkGroupMemberData(MultiTalkGroupMember multiTalkGroupMember) {
        this.zHg = multiTalkGroupMember;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(114412);
        parcel.writeString(Util.nullAs(this.zHg.RHb, ""));
        parcel.writeString(Util.nullAs(this.zHg.RHc, ""));
        parcel.writeInt(this.zHg.status);
        parcel.writeInt(this.zHg.bDZ);
        parcel.writeInt(this.zHg.RGf);
        AppMethodBeat.o(114412);
    }

    static {
        AppMethodBeat.i(114413);
        AppMethodBeat.o(114413);
    }
}
