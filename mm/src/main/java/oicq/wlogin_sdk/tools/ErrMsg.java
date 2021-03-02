package oicq.wlogin_sdk.tools;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ErrMsg implements Parcelable, Cloneable {
    public static final Parcelable.Creator<ErrMsg> CREATOR = new Parcelable.Creator<ErrMsg>() {
        /* class oicq.wlogin_sdk.tools.ErrMsg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ErrMsg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(88191);
            ErrMsg errMsg = new ErrMsg(parcel, (byte) 0);
            AppMethodBeat.o(88191);
            return errMsg;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ErrMsg[] newArray(int i2) {
            return new ErrMsg[i2];
        }
    };
    public String UdY;
    public String message;
    public String title;
    private int type;

    public ErrMsg() {
        this.type = 0;
        this.title = "";
        this.message = "";
        this.UdY = "";
    }

    public final void hPF() {
        this.type = 0;
        this.title = "";
        this.message = "";
        this.UdY = "";
    }

    @Override // java.lang.Object
    public Object clone() {
        AppMethodBeat.i(88193);
        Object clone = super.clone();
        AppMethodBeat.o(88193);
        return clone;
    }

    private ErrMsg(Parcel parcel) {
        AppMethodBeat.i(88194);
        this.type = parcel.readInt();
        this.title = parcel.readString();
        this.message = parcel.readString();
        this.UdY = parcel.readString();
        AppMethodBeat.o(88194);
    }

    /* synthetic */ ErrMsg(Parcel parcel, byte b2) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88195);
        parcel.writeInt(this.type);
        parcel.writeString(this.title);
        parcel.writeString(this.message);
        parcel.writeString(this.UdY);
        AppMethodBeat.o(88195);
    }

    static {
        AppMethodBeat.i(88192);
        AppMethodBeat.o(88192);
    }
}
