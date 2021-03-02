package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.pb.common.c.b;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkGroup implements Parcelable {
    public static final Parcelable.Creator<MultiTalkGroup> CREATOR = new Parcelable.Creator<MultiTalkGroup>() {
        /* class com.tencent.pb.talkroom.sdk.MultiTalkGroup.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MultiTalkGroup[] newArray(int i2) {
            return new MultiTalkGroup[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MultiTalkGroup createFromParcel(Parcel parcel) {
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.zHD = parcel.readString();
            multiTalkGroup.RGY = parcel.readString();
            multiTalkGroup.zHE = parcel.readString();
            multiTalkGroup.RCJ = parcel.readInt();
            multiTalkGroup.RGZ = parcel.readString();
            int readInt = parcel.readInt();
            multiTalkGroup.RHa = new ArrayList();
            for (int i2 = 0; i2 < readInt; i2++) {
                MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) parcel.readParcelable(MultiTalkGroupMember.class.getClassLoader());
                if (multiTalkGroupMember != null) {
                    multiTalkGroup.RHa.add(multiTalkGroupMember);
                } else {
                    b.d("MultiTalkGroup", "CLTNOT readParcelable member = null");
                }
            }
            return multiTalkGroup;
        }
    };
    public int RCJ;
    public String RGY = "";
    public String RGZ = "";
    public List<MultiTalkGroupMember> RHa = new ArrayList();
    public String zHD = "";
    public String zHE = "";

    public final String hjv() {
        return this.zHD;
    }

    public String toString() {
        return "MultiTalkGroup [mMultiTalkGroupId=" + this.zHD + ", mMultiTalkClientGroupId=" + this.RGY + ", mWxGroupId=" + this.zHE + ", mRouteId=" + this.RCJ + ", mCreatorUsrName=" + this.RGZ + ", mMultiTalkGroupMemberList=" + this.RHa + "]";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.zHD == null ? "" : this.zHD);
        parcel.writeString(this.RGY == null ? "" : this.RGY);
        parcel.writeString(this.zHE == null ? "" : this.zHE);
        parcel.writeInt(this.RCJ);
        parcel.writeString(this.RGZ == null ? "" : this.RGZ);
        int size = this.RHa == null ? 0 : this.RHa.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeParcelable(this.RHa.get(i3), i2);
        }
    }

    public int describeContents() {
        return 0;
    }
}
