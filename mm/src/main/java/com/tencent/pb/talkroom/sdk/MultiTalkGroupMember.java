package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;

public class MultiTalkGroupMember implements Parcelable {
    public static final Parcelable.Creator<MultiTalkGroupMember> CREATOR = new Parcelable.Creator<MultiTalkGroupMember>() {
        /* class com.tencent.pb.talkroom.sdk.MultiTalkGroupMember.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MultiTalkGroupMember[] newArray(int i2) {
            return new MultiTalkGroupMember[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MultiTalkGroupMember createFromParcel(Parcel parcel) {
            MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
            multiTalkGroupMember.RHb = parcel.readString();
            multiTalkGroupMember.RHc = parcel.readString();
            multiTalkGroupMember.status = parcel.readInt();
            multiTalkGroupMember.bDZ = parcel.readInt();
            multiTalkGroupMember.RGf = parcel.readInt();
            return multiTalkGroupMember;
        }
    };
    public int RGf;
    public String RHb = "";
    public String RHc = "";
    public int bDZ;
    public int status;

    public String toString() {
        return "MultiTalkGroupMember [usrName=" + this.RHb + ", inviteUsrName=" + this.RHc + ", status=" + this.status + ", reason=" + this.bDZ + ", inviteTime=" + this.RGf + "]";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.RHb == null ? "" : this.RHb);
        parcel.writeString(this.RHc == null ? "" : this.RHc);
        parcel.writeInt(this.status);
        parcel.writeInt(this.bDZ);
        parcel.writeInt(this.RGf);
    }
}
