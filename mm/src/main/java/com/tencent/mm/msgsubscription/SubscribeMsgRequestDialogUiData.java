package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.ui.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR*\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "isAlways", "", "()I", "setAlways", "(I)V", "opType", "getOpType", "setOpType", "uIItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "Lkotlin/collections/ArrayList;", "getUIItem", "()Ljava/util/ArrayList;", "setUIItem", "(Ljava/util/ArrayList;)V", "describeContents", "writeToParcel", "", "flags", "Companion", "ItemUiData", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgRequestDialogUiData implements Parcelable {
    public static final Parcelable.Creator<SubscribeMsgRequestDialogUiData> CREATOR = new b();
    private static final int jxW = 0;
    private static final int jxX = 1;
    private static final int jxY = 2;
    private static final int jxZ = 3;
    private static final int jya = 1;
    private static final int jyb = 0;
    public static final a jyc = new a((byte) 0);
    public int jxU;
    public ArrayList<ItemUiData> jxV;
    public int opType;

    public SubscribeMsgRequestDialogUiData() {
        AppMethodBeat.i(149537);
        this.opType = jxW;
        this.jxV = new ArrayList<>();
        AppMethodBeat.o(149537);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SubscribeMsgRequestDialogUiData(Parcel parcel) {
        this();
        p.h(parcel, "parcel");
        AppMethodBeat.i(149538);
        this.opType = parcel.readInt();
        this.jxU = parcel.readInt();
        ArrayList<ItemUiData> arrayList = new ArrayList<>();
        parcel.readList(arrayList, ItemUiData.class.getClassLoader());
        this.jxV = arrayList;
        AppMethodBeat.o(149538);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "chooseStatus", "", "getChooseStatus", "()I", "setChooseStatus", "(I)V", "templateId", "", "getTemplateId", "()Ljava/lang/String;", "setTemplateId", "(Ljava/lang/String;)V", "describeContents", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
    public static final class ItemUiData implements Parcelable {
        public static final Parcelable.Creator<ItemUiData> CREATOR = new b();
        private static final int jye = 1;
        private static final int jyf = 0;
        public static final a jyg = new a((byte) 0);
        public String ixM;
        public int jyd;

        public ItemUiData() {
            this.ixM = "";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public ItemUiData(Parcel parcel) {
            this();
            p.h(parcel, "parcel");
            AppMethodBeat.i(149534);
            String readString = parcel.readString();
            this.ixM = readString == null ? "" : readString;
            this.jyd = parcel.readInt();
            AppMethodBeat.o(149534);
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(149533);
            p.h(parcel, "parcel");
            parcel.writeString(this.ixM);
            parcel.writeInt(this.jyd);
            AppMethodBeat.o(149533);
        }

        public final int describeContents() {
            return 0;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData$Companion;", "", "()V", "CHOOSE_STATUS_CHECK", "", "getCHOOSE_STATUS_CHECK", "()I", "CHOOSE_STATUS_UNCHECK", "getCHOOSE_STATUS_UNCHECK", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "wxbiz-msgsubscription-sdk_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(149535);
            AppMethodBeat.o(149535);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "wxbiz-msgsubscription-sdk_release"})
        public static final class b implements Parcelable.Creator<ItemUiData> {
            b() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ItemUiData createFromParcel(Parcel parcel) {
                AppMethodBeat.i(149532);
                p.h(parcel, "parcel");
                ItemUiData itemUiData = new ItemUiData(parcel);
                AppMethodBeat.o(149532);
                return itemUiData;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ItemUiData[] newArray(int i2) {
                return new ItemUiData[i2];
            }
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(149536);
        p.h(parcel, "parcel");
        parcel.writeInt(this.opType);
        parcel.writeInt(this.jxU);
        parcel.writeList(this.jxV);
        AppMethodBeat.o(149536);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\t¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "IS_ALWAYS_NO", "", "getIS_ALWAYS_NO", "()I", "IS_ALWAYS_YES", "getIS_ALWAYS_YES", "OP_TYPE_CANCEL", "getOP_TYPE_CANCEL", "OP_TYPE_CONFIRM", "getOP_TYPE_CONFIRM", "OP_TYPE_NONE", "getOP_TYPE_NONE", "OP_TYPE_REJECT", "getOP_TYPE_REJECT", "build", "event", "itemsShowOnDialog", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "isAlwaysCbCheck", "", "wxbiz-msgsubscription-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static SubscribeMsgRequestDialogUiData a(int i2, List<b.C0477b> list, boolean z) {
            int i3;
            int i4;
            int i5;
            AppMethodBeat.i(149531);
            p.h(list, "itemsShowOnDialog");
            SubscribeMsgRequestDialogUiData subscribeMsgRequestDialogUiData = new SubscribeMsgRequestDialogUiData();
            if (z) {
                i3 = SubscribeMsgRequestDialogUiData.jya;
            } else {
                i3 = SubscribeMsgRequestDialogUiData.jyb;
            }
            subscribeMsgRequestDialogUiData.jxU = i3;
            if (i2 == 1) {
                i4 = SubscribeMsgRequestDialogUiData.jxX;
            } else if (i2 == 3) {
                i4 = SubscribeMsgRequestDialogUiData.jxZ;
            } else {
                i4 = SubscribeMsgRequestDialogUiData.jxY;
            }
            subscribeMsgRequestDialogUiData.opType = i4;
            for (b.C0477b bVar : list) {
                ArrayList<ItemUiData> arrayList = subscribeMsgRequestDialogUiData.jxV;
                ItemUiData itemUiData = new ItemUiData();
                String str = bVar.ixM;
                p.h(str, "<set-?>");
                itemUiData.ixM = str;
                if (bVar.jCx) {
                    ItemUiData.a aVar = ItemUiData.jyg;
                    i5 = ItemUiData.jye;
                } else {
                    ItemUiData.a aVar2 = ItemUiData.jyg;
                    i5 = ItemUiData.jyf;
                }
                itemUiData.jyd = i5;
                arrayList.add(itemUiData);
            }
            AppMethodBeat.o(149531);
            return subscribeMsgRequestDialogUiData;
        }
    }

    static {
        AppMethodBeat.i(149539);
        AppMethodBeat.o(149539);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "wxbiz-msgsubscription-sdk_release"})
    public static final class b implements Parcelable.Creator<SubscribeMsgRequestDialogUiData> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SubscribeMsgRequestDialogUiData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(149530);
            p.h(parcel, "parcel");
            SubscribeMsgRequestDialogUiData subscribeMsgRequestDialogUiData = new SubscribeMsgRequestDialogUiData(parcel);
            AppMethodBeat.o(149530);
            return subscribeMsgRequestDialogUiData;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SubscribeMsgRequestDialogUiData[] newArray(int i2) {
            return new SubscribeMsgRequestDialogUiData[i2];
        }
    }
}
