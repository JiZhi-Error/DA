package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B_\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eB\u000f\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u001fH\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013¨\u0006%"}, hxF = {"Lcom/tencent/mm/msgsubscription/WordingInfo;", "Landroid/os/Parcelable;", "PopupTitle", "", "PopupAllow", "PopupCancel", "PopupBottom", "ExampleTitle", "AlwaysReject", "PopupDesc", "SendWording", "MultiRemind", "WxaMultiRemind", "SendBelowMsg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAlwaysReject", "()Ljava/lang/String;", "getExampleTitle", "getMultiRemind", "getPopupAllow", "getPopupBottom", "getPopupCancel", "getPopupDesc", "getPopupTitle", "getSendBelowMsg", "getSendWording", "getWxaMultiRemind", "describeContents", "", "toString", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class WordingInfo implements Parcelable {
    public static final Parcelable.Creator<WordingInfo> CREATOR = new b();
    public static final a jyS = new a((byte) 0);
    public final String jyH;
    public final String jyI;
    public final String jyJ;
    public final String jyK;
    public final String jyL;
    public final String jyM;
    public final String jyN;
    public final String jyO;
    private final String jyP;
    public final String jyQ;
    public final String jyR;

    public WordingInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        p.h(str, "PopupTitle");
        p.h(str2, "PopupAllow");
        p.h(str3, "PopupCancel");
        p.h(str4, "PopupBottom");
        p.h(str5, "ExampleTitle");
        p.h(str6, "AlwaysReject");
        p.h(str7, "PopupDesc");
        p.h(str8, "SendWording");
        p.h(str9, "MultiRemind");
        p.h(str10, "WxaMultiRemind");
        p.h(str11, "SendBelowMsg");
        AppMethodBeat.i(149558);
        this.jyH = str;
        this.jyI = str2;
        this.jyJ = str3;
        this.jyK = str4;
        this.jyL = str5;
        this.jyM = str6;
        this.jyN = str7;
        this.jyO = str8;
        this.jyP = str9;
        this.jyQ = str10;
        this.jyR = str11;
        AppMethodBeat.o(149558);
    }

    public WordingInfo(Parcel parcel) {
        p.h(parcel, "parcel");
        AppMethodBeat.i(149559);
        String readString = parcel.readString();
        this.jyH = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.jyI = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.jyJ = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.jyK = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.jyL = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        this.jyM = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
        this.jyN = readString7 == null ? "" : readString7;
        String readString8 = parcel.readString();
        this.jyO = readString8 == null ? "" : readString8;
        String readString9 = parcel.readString();
        this.jyP = readString9 == null ? "" : readString9;
        String readString10 = parcel.readString();
        this.jyQ = readString10 == null ? "" : readString10;
        String readString11 = parcel.readString();
        this.jyR = readString11 == null ? "" : readString11;
        AppMethodBeat.o(149559);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(149556);
        p.h(parcel, "parcel");
        parcel.writeString(this.jyH);
        parcel.writeString(this.jyI);
        parcel.writeString(this.jyJ);
        parcel.writeString(this.jyK);
        parcel.writeString(this.jyL);
        parcel.writeString(this.jyM);
        parcel.writeString(this.jyN);
        parcel.writeString(this.jyO);
        parcel.writeString(this.jyP);
        parcel.writeString(this.jyQ);
        parcel.writeString(this.jyR);
        AppMethodBeat.o(149556);
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(149557);
        String str = "WordingInfo(PopupTitle='" + this.jyH + "', PopupAllow='" + this.jyI + "', PopupCancel='" + this.jyJ + "', PopupBottom='" + this.jyK + "', ExampleTitle='" + this.jyL + "', AlwaysReject='" + this.jyM + "', PopupDesc='" + this.jyN + "', SendWording='" + this.jyO + "', MultiRemind='" + this.jyP + "', WxaMultiRemind='" + this.jyQ + "')";
        AppMethodBeat.o(149557);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/msgsubscription/WordingInfo$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "wxbiz-msgsubscription-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/msgsubscription/WordingInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/WordingInfo;", "wxbiz-msgsubscription-sdk_release"})
    public static final class b implements Parcelable.Creator<WordingInfo> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WordingInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(149555);
            p.h(parcel, "parcel");
            WordingInfo wordingInfo = new WordingInfo(parcel);
            AppMethodBeat.o(149555);
            return wordingInfo;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WordingInfo[] newArray(int i2) {
            return new WordingInfo[i2];
        }
    }

    static {
        AppMethodBeat.i(149560);
        AppMethodBeat.o(149560);
    }
}
