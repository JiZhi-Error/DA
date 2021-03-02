package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 C2\u00020\u0001:\u0001CB·\u0001\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0005¢\u0006\u0002\u0010\u001eB'\b\u0016\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u001fB\u000f\b\u0016\u0012\u0006\u0010 \u001a\u00020!¢\u0006\u0002\u0010\"J\b\u0010>\u001a\u00020\bH\u0016J\b\u0010?\u001a\u00020\u0005H\u0016J\u0018\u0010@\u001a\u00020A2\u0006\u0010 \u001a\u00020!2\u0006\u0010B\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u001d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010$\"\u0004\b-\u0010.R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0015\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010&R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u001a\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010&R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010$¨\u0006D"}, hxF = {"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "Landroid/os/Parcelable;", "alwaysChosenStatus", "", "appIconUrl", "", "appName", "cacheMaxSize", "", "subscribeMsgItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "notShowAlways", "notShowReject", "wordingInfo", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "isOpened", "showEntry", "buffer", "", "showStyle", "showInfo", "Lcom/tencent/mm/msgsubscription/ShowInfo;", "mainDescription", "subDescription", "wxaErrorCode", "wxaErrorMessage", "wxaUserCancel", "extData", "(ZLjava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;ZZLcom/tencent/mm/msgsubscription/WordingInfo;ZZ[BILcom/tencent/mm/msgsubscription/ShowInfo;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;)V", "(Ljava/util/ArrayList;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAlwaysChosenStatus", "()Z", "getAppIconUrl", "()Ljava/lang/String;", "getAppName", "getBuffer", "()[B", "getCacheMaxSize", "()I", "getExtData", "setOpened", "(Z)V", "getMainDescription", "getNotShowAlways", "getNotShowReject", "getShowEntry", "getShowInfo", "()Lcom/tencent/mm/msgsubscription/ShowInfo;", "getShowStyle", "getSubDescription", "getSubscribeMsgItems", "()Ljava/util/ArrayList;", "getWordingInfo", "()Lcom/tencent/mm/msgsubscription/WordingInfo;", "getWxaErrorCode", "getWxaErrorMessage", "getWxaUserCancel", "describeContents", "toString", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgRequestResult implements Parcelable {
    public static final Parcelable.Creator<SubscribeMsgRequestResult> CREATOR = new b();
    public static final a jyx = new a((byte) 0);
    public final String appName;
    public final byte[] buffer;
    public final String extData;
    private final boolean jyh;
    public final String jyi;
    public final int jyj;
    public final ArrayList<SubscribeMsgTmpItem> jyk;
    public final boolean jyl;
    public final boolean jym;
    public final WordingInfo jyn;
    public boolean jyo;
    public final boolean jyp;
    public final int jyq;
    public final ShowInfo jyr;
    public final String jys;
    public final String jyt;
    public final int jyu;
    public final String jyv;
    public final boolean jyw;

    public SubscribeMsgRequestResult(boolean z, String str, String str2, int i2, ArrayList<SubscribeMsgTmpItem> arrayList, boolean z2, boolean z3, WordingInfo wordingInfo, boolean z4, boolean z5, byte[] bArr, int i3, ShowInfo showInfo, String str3, String str4, int i4, String str5, boolean z6, String str6) {
        p.h(str, "appIconUrl");
        p.h(str2, "appName");
        p.h(arrayList, "subscribeMsgItems");
        p.h(bArr, "buffer");
        p.h(str5, "wxaErrorMessage");
        p.h(str6, "extData");
        AppMethodBeat.i(194257);
        this.jyh = z;
        this.jyi = str;
        this.appName = str2;
        this.jyj = i2;
        this.jyk = arrayList;
        this.jyl = z2;
        this.jym = z3;
        this.jyn = wordingInfo;
        this.jyo = z4;
        this.jyp = z5;
        this.buffer = bArr;
        this.jyq = i3;
        this.jyr = showInfo;
        this.jys = str3;
        this.jyt = str4;
        this.jyu = i4;
        this.jyv = str5;
        this.jyw = z6;
        this.extData = str6;
        AppMethodBeat.o(194257);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SubscribeMsgRequestResult(ArrayList<SubscribeMsgTmpItem> arrayList, boolean z) {
        this(false, "", "", 0, arrayList, false, false, null, z, true, new byte[0], -1, null, "", "", 0, "", false, "");
        p.h(arrayList, "subscribeMsgItems");
        AppMethodBeat.i(149544);
        AppMethodBeat.o(149544);
    }

    public SubscribeMsgRequestResult(Parcel parcel) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        p.h(parcel, "parcel");
        AppMethodBeat.i(149545);
        this.jyh = parcel.readByte() != 0;
        String readString = parcel.readString();
        this.jyi = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.appName = readString2 == null ? "" : readString2;
        this.jyj = parcel.readInt();
        this.jyn = (WordingInfo) parcel.readParcelable(WordingInfo.class.getClassLoader());
        ArrayList<SubscribeMsgTmpItem> arrayList = new ArrayList<>();
        parcel.readList(arrayList, SubscribeMsgTmpItem.class.getClassLoader());
        this.jyk = arrayList;
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.jyl = z;
        if (parcel.readByte() != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.jyo = z2;
        if (parcel.readByte() != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.jyp = z3;
        this.buffer = new byte[parcel.readInt()];
        parcel.readByteArray(this.buffer);
        this.jyq = parcel.readInt();
        this.jyr = (ShowInfo) parcel.readParcelable(ShowInfo.class.getClassLoader());
        String readString3 = parcel.readString();
        this.jys = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.jyt = readString4 == null ? "" : readString4;
        this.jyu = parcel.readInt();
        String readString5 = parcel.readString();
        this.jyv = readString5 == null ? "" : readString5;
        this.jyw = parcel.readByte() != 0;
        this.jym = parcel.readByte() == 0 ? false : z4;
        String readString6 = parcel.readString();
        this.extData = readString6 == null ? "" : readString6;
        AppMethodBeat.o(149545);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        byte b6 = 1;
        AppMethodBeat.i(149541);
        p.h(parcel, "parcel");
        parcel.writeByte(this.jyh ? (byte) 1 : 0);
        parcel.writeString(this.jyi);
        parcel.writeString(this.appName);
        parcel.writeInt(this.jyj);
        parcel.writeParcelable(this.jyn, i2);
        parcel.writeList(this.jyk);
        if (this.jyl) {
            b2 = 1;
        } else {
            b2 = 0;
        }
        parcel.writeByte(b2);
        if (this.jyo) {
            b3 = 1;
        } else {
            b3 = 0;
        }
        parcel.writeByte(b3);
        if (this.jyp) {
            b4 = 1;
        } else {
            b4 = 0;
        }
        parcel.writeByte(b4);
        parcel.writeInt(this.buffer.length);
        parcel.writeByteArray(this.buffer);
        parcel.writeInt(this.jyq);
        parcel.writeParcelable(this.jyr, i2);
        String str = this.jys;
        if (str == null) {
            str = "";
        }
        parcel.writeString(str);
        String str2 = this.jyt;
        if (str2 == null) {
            str2 = "";
        }
        parcel.writeString(str2);
        parcel.writeInt(this.jyu);
        parcel.writeString(this.jyv);
        if (this.jyw) {
            b5 = 1;
        } else {
            b5 = 0;
        }
        parcel.writeByte(b5);
        if (!this.jym) {
            b6 = 0;
        }
        parcel.writeByte(b6);
        parcel.writeString(this.extData);
        AppMethodBeat.o(149541);
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(149542);
        String str = "SubscribeMsgRequestResult(alwaysChosenStatus=" + this.jyh + ", appIconUrl='" + this.jyi + "', appName='" + this.appName + "', cacheMaxSize=" + this.jyj + ", subscribeMsgItems=" + this.jyk + ", notShowAlways=" + this.jyl + ", wordingInfo=" + this.jyn + ", CREATOR=" + CREATOR + ')';
        AppMethodBeat.o(149542);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "from", "response", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgResp;", "wxbiz-msgsubscription-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/msgsubscription/SubscribeMsgRequestResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "wxbiz-msgsubscription-sdk_release"})
    public static final class b implements Parcelable.Creator<SubscribeMsgRequestResult> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SubscribeMsgRequestResult createFromParcel(Parcel parcel) {
            AppMethodBeat.i(149540);
            p.h(parcel, "parcel");
            SubscribeMsgRequestResult subscribeMsgRequestResult = new SubscribeMsgRequestResult(parcel);
            AppMethodBeat.o(149540);
            return subscribeMsgRequestResult;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SubscribeMsgRequestResult[] newArray(int i2) {
            return new SubscribeMsgRequestResult[i2];
        }
    }

    static {
        AppMethodBeat.i(149546);
        AppMethodBeat.o(149546);
    }
}
