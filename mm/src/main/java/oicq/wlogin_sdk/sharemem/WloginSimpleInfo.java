package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class WloginSimpleInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<WloginSimpleInfo> CREATOR = new Parcelable.Creator<WloginSimpleInfo>() {
        /* class oicq.wlogin_sdk.sharemem.WloginSimpleInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WloginSimpleInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(88087);
            WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo(parcel, null);
            AppMethodBeat.o(88087);
            return wloginSimpleInfo;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WloginSimpleInfo[] newArray(int i2) {
            return new WloginSimpleInfo[i2];
        }
    };
    private static final long serialVersionUID = 1;
    public byte[] _age;
    public byte[] _face;
    public byte[] _gender;
    public byte[] _nick;
    public long _uin;

    public WloginSimpleInfo(long j2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        AppMethodBeat.i(88089);
        this._uin = j2;
        this._face = (byte[]) bArr.clone();
        this._age = (byte[]) bArr2.clone();
        this._gender = (byte[]) bArr3.clone();
        this._nick = (byte[]) bArr4.clone();
        AppMethodBeat.o(88089);
    }

    public WloginSimpleInfo() {
        AppMethodBeat.i(88090);
        this._uin = 0;
        this._face = new byte[0];
        this._age = new byte[0];
        this._gender = new byte[0];
        this._nick = new byte[0];
        AppMethodBeat.o(88090);
    }

    public void get_clone(WloginSimpleInfo wloginSimpleInfo) {
        AppMethodBeat.i(88091);
        this._uin = wloginSimpleInfo._uin;
        this._face = (byte[]) wloginSimpleInfo._face.clone();
        this._age = (byte[]) wloginSimpleInfo._age.clone();
        this._gender = (byte[]) wloginSimpleInfo._gender.clone();
        this._nick = (byte[]) wloginSimpleInfo._nick.clone();
        AppMethodBeat.o(88091);
    }

    public WloginSimpleInfo get_clone() {
        AppMethodBeat.i(88092);
        WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
        wloginSimpleInfo._uin = this._uin;
        wloginSimpleInfo._face = (byte[]) this._face.clone();
        wloginSimpleInfo._age = (byte[]) this._age.clone();
        wloginSimpleInfo._gender = (byte[]) this._gender.clone();
        wloginSimpleInfo._nick = (byte[]) this._nick.clone();
        AppMethodBeat.o(88092);
        return wloginSimpleInfo;
    }

    static {
        AppMethodBeat.i(88088);
        AppMethodBeat.o(88088);
    }

    private WloginSimpleInfo(Parcel parcel) {
        AppMethodBeat.i(88093);
        readFromParcel(parcel);
        AppMethodBeat.o(88093);
    }

    /* synthetic */ WloginSimpleInfo(Parcel parcel, WloginSimpleInfo wloginSimpleInfo) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88094);
        parcel.writeLong(this._uin);
        parcel.writeByteArray(this._face);
        parcel.writeByteArray(this._age);
        parcel.writeByteArray(this._gender);
        parcel.writeByteArray(this._nick);
        AppMethodBeat.o(88094);
    }

    public void readFromParcel(Parcel parcel) {
        AppMethodBeat.i(88095);
        this._uin = parcel.readLong();
        this._face = parcel.createByteArray();
        this._age = parcel.createByteArray();
        this._gender = parcel.createByteArray();
        this._nick = parcel.createByteArray();
        AppMethodBeat.o(88095);
    }
}
