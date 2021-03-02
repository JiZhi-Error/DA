package com.tencent.mm.msgsubscription.presenter;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.WordingInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0001-B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120!2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\"H\u0002J\b\u0010#\u001a\u00020$H\u0016J\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0012H\u0002J\u000e\u0010)\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020\u0003J\u0018\u0010+\u001a\u00020*2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010,\u001a\u00020$H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u0006."}, hxF = {"Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "Landroid/os/Parcelable;", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "filter", "", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "exampleTitle", "", "getExampleTitle", "()Ljava/lang/String;", "setExampleTitle", "(Ljava/lang/String;)V", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "originalData", "showEntry", "getShowEntry", "()Z", "setShowEntry", "(Z)V", "subscribeSwitch", "getSubscribeSwitch", "setSubscribeSwitch", "copyItem", "", "Ljava/util/ArrayList;", "describeContents", "", "getItemChanged", "isSubscribeMsgTmpItemChanged", "a", "b", "refresh", "", "writeToParcel", "flags", "CREATOR", "plugin-comm_release"})
public final class SubscribeMsgSettingData implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    public List<SubscribeMsgTmpItem> iHf;
    public boolean iQD;
    public String jAi;
    public SubscribeMsgRequestResult jAj;
    public boolean jyp;

    static {
        AppMethodBeat.i(149578);
        AppMethodBeat.o(149578);
    }

    public /* synthetic */ SubscribeMsgSettingData(SubscribeMsgRequestResult subscribeMsgRequestResult, byte b2) {
        this(subscribeMsgRequestResult);
    }

    public SubscribeMsgSettingData(SubscribeMsgRequestResult subscribeMsgRequestResult) {
        String str;
        p.h(subscribeMsgRequestResult, "result");
        AppMethodBeat.i(149576);
        this.jAj = subscribeMsgRequestResult;
        this.jyp = subscribeMsgRequestResult.jyp;
        this.iQD = subscribeMsgRequestResult.jyo;
        WordingInfo wordingInfo = subscribeMsgRequestResult.jyn;
        this.jAi = (wordingInfo == null || (str = wordingInfo.jyL) == null) ? "" : str;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = subscribeMsgRequestResult.jyk.iterator();
        while (it.hasNext()) {
            Parcel obtain = Parcel.obtain();
            p.g(obtain, "Parcel.obtain()");
            it.next().writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            arrayList.add(new SubscribeMsgTmpItem(obtain));
            obtain.recycle();
        }
        this.iHf = arrayList;
        AppMethodBeat.o(149576);
    }

    public SubscribeMsgSettingData(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        p.h(parcel, "parcel");
        AppMethodBeat.i(149577);
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.jyp = z;
        this.iQD = parcel.readByte() == 0 ? false : z2;
        ArrayList createTypedArrayList = parcel.createTypedArrayList(SubscribeMsgTmpItem.CREATOR);
        if (createTypedArrayList == null) {
            p.hyc();
        }
        this.iHf = createTypedArrayList;
        this.jAi = String.valueOf(parcel.readString());
        Parcelable readParcelable = parcel.readParcelable(SubscribeMsgRequestResult.class.getClassLoader());
        if (readParcelable == null) {
            p.hyc();
        }
        this.jAj = (SubscribeMsgRequestResult) readParcelable;
        AppMethodBeat.o(149577);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        byte b2 = 1;
        AppMethodBeat.i(149575);
        p.h(parcel, "parcel");
        parcel.writeByte(this.jyp ? (byte) 1 : 0);
        if (!this.iQD) {
            b2 = 0;
        }
        parcel.writeByte(b2);
        parcel.writeTypedList(this.iHf);
        parcel.writeString(this.jAi);
        parcel.writeParcelable(this.jAj, i2);
        AppMethodBeat.o(149575);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "plugin-comm_release"})
    public static final class a implements Parcelable.Creator<SubscribeMsgSettingData> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SubscribeMsgSettingData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(149574);
            p.h(parcel, "parcel");
            SubscribeMsgSettingData subscribeMsgSettingData = new SubscribeMsgSettingData(parcel);
            AppMethodBeat.o(149574);
            return subscribeMsgSettingData;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SubscribeMsgSettingData[] newArray(int i2) {
            return new SubscribeMsgSettingData[i2];
        }
    }
}
