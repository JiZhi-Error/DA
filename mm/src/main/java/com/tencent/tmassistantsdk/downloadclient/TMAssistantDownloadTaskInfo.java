package com.tencent.tmassistantsdk.downloadclient;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TMAssistantDownloadTaskInfo implements Parcelable {
    public static final Parcelable.Creator<TMAssistantDownloadTaskInfo> CREATOR = new Parcelable.Creator<TMAssistantDownloadTaskInfo>() {
        /* class com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final TMAssistantDownloadTaskInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(101921);
            TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readString());
            AppMethodBeat.o(101921);
            return tMAssistantDownloadTaskInfo;
        }

        @Override // android.os.Parcelable.Creator
        public final TMAssistantDownloadTaskInfo[] newArray(int i2) {
            return new TMAssistantDownloadTaskInfo[i2];
        }
    };
    public String mContentType;
    public long mReceiveDataLen;
    public String mSavePath;
    public int mState;
    public long mTotalDataLen;
    public String mUrl;

    public TMAssistantDownloadTaskInfo(String str, String str2, int i2, long j2, long j3, String str3) {
        this.mUrl = str;
        this.mSavePath = str2;
        this.mState = i2;
        this.mReceiveDataLen = j2;
        this.mTotalDataLen = j3;
        this.mContentType = str3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101924);
        if (this.mUrl != null) {
            parcel.writeString(this.mUrl);
        } else {
            parcel.writeString("");
        }
        if (this.mSavePath != null) {
            parcel.writeString(this.mSavePath);
        } else {
            parcel.writeString("");
        }
        parcel.writeInt(this.mState);
        parcel.writeLong(this.mReceiveDataLen);
        parcel.writeLong(this.mTotalDataLen);
        parcel.writeString(this.mContentType);
        AppMethodBeat.o(101924);
    }

    static {
        AppMethodBeat.i(101925);
        AppMethodBeat.o(101925);
    }
}
