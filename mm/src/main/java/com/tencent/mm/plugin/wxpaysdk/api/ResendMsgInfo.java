package com.tencent.mm.plugin.wxpaysdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResendMsgInfo implements Parcelable {
    public static final Parcelable.Creator<ResendMsgInfo> CREATOR = new Parcelable.Creator<ResendMsgInfo>() {
        /* class com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ResendMsgInfo[] newArray(int i2) {
            return new ResendMsgInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ResendMsgInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(117562);
            ResendMsgInfo resendMsgInfo = new ResendMsgInfo(parcel);
            AppMethodBeat.o(117562);
            return resendMsgInfo;
        }
    };
    public String JQW;
    public String description;
    public String lHA;
    public String lHB;
    public String title;

    public String toString() {
        AppMethodBeat.i(117563);
        String str = "ResendMsgInfo{title='" + this.title + '\'' + ", pic='" + this.JQW + '\'' + ", description='" + this.description + '\'' + ", left_button_wording='" + this.lHA + '\'' + ", right_button_wording='" + this.lHB + '\'' + '}';
        AppMethodBeat.o(117563);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(117564);
        parcel.writeString(this.title);
        parcel.writeString(this.JQW);
        parcel.writeString(this.description);
        parcel.writeString(this.lHA);
        parcel.writeString(this.lHB);
        AppMethodBeat.o(117564);
    }

    public ResendMsgInfo() {
    }

    protected ResendMsgInfo(Parcel parcel) {
        AppMethodBeat.i(117565);
        this.title = parcel.readString();
        this.JQW = parcel.readString();
        this.description = parcel.readString();
        this.lHA = parcel.readString();
        this.lHB = parcel.readString();
        AppMethodBeat.o(117565);
    }

    static {
        AppMethodBeat.i(117566);
        AppMethodBeat.o(117566);
    }
}
