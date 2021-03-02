package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class WloginLoginInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<WloginLoginInfo> CREATOR = new Parcelable.Creator<WloginLoginInfo>() {
        /* class oicq.wlogin_sdk.sharemem.WloginLoginInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WloginLoginInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(88096);
            WloginLoginInfo wloginLoginInfo = new WloginLoginInfo(parcel, null);
            AppMethodBeat.o(88096);
            return wloginLoginInfo;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WloginLoginInfo[] newArray(int i2) {
            return new WloginLoginInfo[i2];
        }
    };
    public static int TYPE_LOACL = 1;
    public static int TYPE_REMOTE = 2;
    private static final long serialVersionUID = 5551948389726789420L;
    public String mAccount;
    public long mAppid;
    public long mCreateTime;
    public int mType;
    public long mUin;

    static {
        AppMethodBeat.i(88097);
        AppMethodBeat.o(88097);
    }

    public WloginLoginInfo(String str, long j2, long j3, long j4, int i2) {
        this.mAccount = str;
        this.mUin = j2;
        this.mAppid = j3;
        this.mCreateTime = j4;
        this.mType = i2;
    }

    private WloginLoginInfo(Parcel parcel) {
        AppMethodBeat.i(88098);
        readFromParcel(parcel);
        AppMethodBeat.o(88098);
    }

    /* synthetic */ WloginLoginInfo(Parcel parcel, WloginLoginInfo wloginLoginInfo) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88099);
        parcel.writeString(this.mAccount);
        parcel.writeLong(this.mUin);
        parcel.writeLong(this.mAppid);
        parcel.writeLong(this.mCreateTime);
        parcel.writeInt(this.mType);
        AppMethodBeat.o(88099);
    }

    public void readFromParcel(Parcel parcel) {
        AppMethodBeat.i(88100);
        this.mAccount = parcel.readString();
        this.mUin = parcel.readLong();
        this.mAppid = parcel.readLong();
        this.mCreateTime = parcel.readLong();
        this.mType = parcel.readInt();
        AppMethodBeat.o(88100);
    }
}
