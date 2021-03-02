package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0006H\u0016R\u001a\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/msgsubscription/ShowInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "showType", "", "title", "", "content", "(ILjava/lang/String;Ljava/lang/String;)V", "alertContent", "getAlertContent", "()Ljava/lang/String;", "setAlertContent", "(Ljava/lang/String;)V", "alertTitle", "getAlertTitle", "setAlertTitle", "getShowType", "()I", "setShowType", "(I)V", "describeContents", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class ShowInfo implements Parcelable {
    public static final Parcelable.Creator<ShowInfo> CREATOR = new b();
    public static final a jxT = new a((byte) 0);
    public int dDG;
    public String jxR;
    public String jxS;

    public ShowInfo(Parcel parcel) {
        p.h(parcel, "parcel");
        AppMethodBeat.i(149527);
        this.dDG = parcel.readInt();
        String readString = parcel.readString();
        this.jxR = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.jxS = readString2 == null ? "" : readString2;
        AppMethodBeat.o(149527);
    }

    public ShowInfo(int i2, String str, String str2) {
        p.h(str, "title");
        p.h(str2, "content");
        AppMethodBeat.i(149528);
        this.dDG = i2;
        this.jxR = str;
        this.jxS = str2;
        AppMethodBeat.o(149528);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(149526);
        p.h(parcel, "parcel");
        parcel.writeInt(this.dDG);
        parcel.writeString(this.jxR);
        parcel.writeString(this.jxS);
        AppMethodBeat.o(149526);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/msgsubscription/ShowInfo$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/ShowInfo;", "SHOW_TYPE_ALERT", "", "SHOW_TYPE_GO_TO_SETTING_PAGE", "SHOW_TYPE_POPUP", "SHOW_TYPE_SUCCESS_TOAST", "SHOW_TYPE_TOAST", "wxbiz-msgsubscription-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/msgsubscription/ShowInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/ShowInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/ShowInfo;", "wxbiz-msgsubscription-sdk_release"})
    public static final class b implements Parcelable.Creator<ShowInfo> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ShowInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(149525);
            p.h(parcel, "parcel");
            ShowInfo showInfo = new ShowInfo(parcel);
            AppMethodBeat.o(149525);
            return showInfo;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ShowInfo[] newArray(int i2) {
            return new ShowInfo[i2];
        }
    }

    static {
        AppMethodBeat.i(149529);
        AppMethodBeat.o(149529);
    }
}
