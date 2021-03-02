package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InvalidClassException;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 B2\u00020\u0001:\u0001BB\u0001\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012.\u0010\b\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n0\tj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n`\u000b\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006¢\u0006\u0002\u0010\u0013B?\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012.\u0010\b\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n0\tj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n`\u000b¢\u0006\u0002\u0010\u0016Bo\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012.\u0010\b\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n0\tj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n`\u000b\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0017B'\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u000e¢\u0006\u0002\u0010\u0019B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cB\u000f\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\b\u0010<\u001a\u00020\u0006H\u0016J\b\u0010=\u001a\u00020\u0003H\u0016J\u001a\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u001e2\u0006\u0010A\u001a\u00020\u0006H\u0016R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010$R\u001a\u0010%\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010$\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010'R9\u0010\b\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n0\tj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0017\u0010\u0005\u001a\u00020\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b1\u00102\u001a\u0004\b3\u0010!R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010-R\u001a\u00106\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010-¨\u0006C"}, hxF = {"Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Landroid/os/Parcelable;", "title", "", "templateId", "templateType", "", "chooseStatus", "keyWordList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "settingStatus", "isOpened", "", "sceneDesc", "wxaSubscribeStatusString", "isBaned", "tid", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;IZLjava/lang/String;Ljava/lang/String;ZI)V", "item", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;", "(Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;Ljava/util/ArrayList;)V", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;IZLjava/lang/String;)V", "switchOpened", "(Ljava/lang/String;IIZ)V", AppMeasurement.Param.TIMESTAMP, "", "(Ljava/lang/String;J)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getChooseStatus", "()I", "setChooseStatus", "(I)V", "()Z", "isFromProfile", "setFromProfile", "(Z)V", "isOpen", "setOpen", "getKeyWordList", "()Ljava/util/ArrayList;", "getSceneDesc", "()Ljava/lang/String;", "getSettingStatus", "setSettingStatus", "getTemplateId", "templateType$annotations", "()V", "getTemplateType", "getTid", "getTitle", "updateTimestamp", "getUpdateTimestamp", "()J", "setUpdateTimestamp", "(J)V", "getWxaSubscribeStatusString", "describeContents", "toString", "writeToParcel", "", "dest", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class SubscribeMsgTmpItem implements Parcelable {
    public static final Parcelable.Creator<SubscribeMsgTmpItem> CREATOR = new b();
    public static final a jyG = new a((byte) 0);
    public boolean VC;
    public final String ixM;
    public final ArrayList<o<String, String>> jyA;
    public int jyB;
    public long jyC;
    public boolean jyD;
    public final String jyE;
    public final boolean jyF;
    public int jyd;
    public final String jyy;
    public final int jyz;
    public final int tid;
    public final String title;

    private /* synthetic */ SubscribeMsgTmpItem(String str, String str2, int i2, int i3, ArrayList arrayList, int i4, boolean z, String str3, String str4) {
        this(str, str2, i2, i3, arrayList, i4, z, str3, str4, false, -1);
        AppMethodBeat.i(149550);
        AppMethodBeat.o(149550);
    }

    private SubscribeMsgTmpItem(String str, String str2, int i2, int i3, ArrayList<o<String, String>> arrayList, int i4, boolean z, String str3, String str4, boolean z2, int i5) {
        this.title = str;
        this.ixM = str2;
        this.jyz = i2;
        this.jyd = i3;
        this.jyA = arrayList;
        this.jyB = i4;
        this.VC = z;
        this.jyC = 0;
        this.jyy = str3;
        this.jyD = false;
        this.jyE = str4;
        this.tid = i5;
        this.jyF = z2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SubscribeMsgTmpItem(com.tencent.mm.protocal.protobuf.efc r14, java.util.ArrayList<kotlin.o<java.lang.String, java.lang.String>> r15) {
        /*
            r13 = this;
            r12 = 174563(0x2a9e3, float:2.44615E-40)
            r5 = 0
            r0 = 1
            java.lang.String r1 = "item"
            kotlin.g.b.p.h(r14, r1)
            java.lang.String r1 = "keyWordList"
            kotlin.g.b.p.h(r15, r1)
            java.lang.String r1 = r14.Title
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = ""
        L_0x0018:
            java.lang.String r2 = r14.Mqy
            if (r2 != 0) goto L_0x001f
            java.lang.String r2 = ""
        L_0x001f:
            int r3 = r14.NeU
            int r4 = r14.NeX
            int r6 = r14.NeY
            int r7 = r14.NeZ
            if (r7 != r0) goto L_0x004b
            r7 = r0
        L_0x002a:
            java.lang.String r8 = r14.Nfb
            if (r8 != 0) goto L_0x0031
            java.lang.String r8 = ""
        L_0x0031:
            java.lang.String r9 = r14.Nfc
            if (r9 != 0) goto L_0x0038
            java.lang.String r9 = ""
        L_0x0038:
            int r10 = r14.Nfa
            if (r10 != r0) goto L_0x004d
            r10 = r0
        L_0x003d:
            int r11 = r14.Nfd
            r0 = r13
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r12)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r12)
            return
        L_0x004b:
            r7 = r5
            goto L_0x002a
        L_0x004d:
            r10 = r5
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.msgsubscription.SubscribeMsgTmpItem.<init>(com.tencent.mm.protocal.protobuf.efc, java.util.ArrayList):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SubscribeMsgTmpItem(String str, String str2, int i2, int i3, ArrayList<o<String, String>> arrayList, int i4, boolean z, String str3) {
        this(str, str2, i2, i3, arrayList, i4, z, str3, "");
        p.h(str, "title");
        p.h(str2, "templateId");
        p.h(arrayList, "keyWordList");
        p.h(str3, "sceneDesc");
        AppMethodBeat.i(149551);
        AppMethodBeat.o(149551);
    }

    public SubscribeMsgTmpItem(String str, int i2, int i3, boolean z) {
        p.h(str, "templateId");
        AppMethodBeat.i(149552);
        this.title = "";
        this.ixM = str;
        this.jyz = i2;
        this.jyd = -1;
        this.jyB = i3;
        this.jyA = new ArrayList<>();
        this.VC = z;
        this.jyC = 0;
        this.jyy = "";
        this.jyD = false;
        this.jyE = "";
        this.tid = -1;
        this.jyF = false;
        AppMethodBeat.o(149552);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SubscribeMsgTmpItem(String str, long j2) {
        this(str, 0, 0, false);
        p.h(str, "templateId");
        AppMethodBeat.i(194258);
        this.jyC = j2;
        AppMethodBeat.o(194258);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int i3 = 1;
        AppMethodBeat.i(149548);
        if (parcel != null) {
            parcel.writeString(this.title);
        }
        if (parcel != null) {
            parcel.writeString(this.ixM);
        }
        if (parcel != null) {
            parcel.writeInt(this.jyz);
        }
        if (parcel != null) {
            parcel.writeInt(this.jyd);
        }
        if (parcel != null) {
            parcel.writeInt(this.jyA.size());
        }
        for (T t : this.jyA) {
            if (parcel != null) {
                parcel.writeSerializable(t);
            }
        }
        if (parcel != null) {
            parcel.writeInt(this.jyB);
        }
        if (parcel != null) {
            parcel.writeByte(this.VC ? (byte) 1 : 0);
        }
        if (parcel != null) {
            parcel.writeLong(this.jyC);
        }
        if (parcel != null) {
            parcel.writeString(this.jyy);
        }
        if (parcel != null) {
            parcel.writeByte(this.jyD ? (byte) 1 : 0);
        }
        if (parcel != null) {
            parcel.writeString(this.jyE);
        }
        if (parcel != null) {
            parcel.writeInt(this.tid);
        }
        if (parcel != null) {
            if (!this.jyF) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            AppMethodBeat.o(149548);
            return;
        }
        AppMethodBeat.o(149548);
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(149549);
        String str = "SubscribeMsgTmpItem(title='" + this.title + "', templateId='" + this.ixM + "', templateType=" + this.jyz + ", chooseStatus=" + this.jyd + ", settingStatus=" + this.jyB + ", settingStatus=" + this.jyB + ", CREATOR=" + CREATOR + ')';
        AppMethodBeat.o(149549);
        return str;
    }

    public SubscribeMsgTmpItem(Parcel parcel) {
        boolean z = true;
        p.h(parcel, "parcel");
        AppMethodBeat.i(149553);
        String readString = parcel.readString();
        this.title = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.ixM = readString2 == null ? "" : readString2;
        this.jyz = parcel.readInt();
        this.jyd = parcel.readInt();
        int readInt = parcel.readInt();
        this.jyA = new ArrayList<>(readInt);
        for (int i2 = readInt; i2 != 0; i2--) {
            try {
                ArrayList<o<String, String>> arrayList = this.jyA;
                Serializable readSerializable = parcel.readSerializable();
                if (readSerializable == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Pair<kotlin.String, kotlin.String>");
                    AppMethodBeat.o(149553);
                    throw tVar;
                }
                arrayList.add((o) readSerializable);
            } catch (InvalidClassException e2) {
            }
        }
        this.jyB = parcel.readInt();
        this.VC = parcel.readByte() != 0;
        this.jyC = parcel.readLong();
        String readString3 = parcel.readString();
        this.jyy = readString3 == null ? "" : readString3;
        this.jyD = parcel.readByte() != 0;
        String readString4 = parcel.readString();
        this.jyE = readString4 == null ? "" : readString4;
        this.tid = parcel.readInt();
        this.jyF = parcel.readInt() != 1 ? false : z;
        AppMethodBeat.o(149553);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001:\u0003\u0012\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem$Companion;", "", "()V", "CHOOSE_STATUS_CHECKED", "", "CHOOSE_STATUS_UNCHECK", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "OP_ALWAYS_ALLOW", "OP_ALWAYS_REJECT", "OP_DEFAULT", "SHOW_STYLE_LIST", "SHOW_STYLE_SINGLE", "STATUS_SUBSCRIBED", "STATUS_UNSUBSCRIBED", "TYPE_TMPL_FOREVER", "TYPE_TMPL_ONCE", "OpType", "SubscribeStatus", "TMPL_TYPE", "wxbiz-msgsubscription-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/msgsubscription/SubscribeMsgTmpItem$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "wxbiz-msgsubscription-sdk_release"})
    public static final class b implements Parcelable.Creator<SubscribeMsgTmpItem> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SubscribeMsgTmpItem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(149547);
            p.h(parcel, "source");
            SubscribeMsgTmpItem subscribeMsgTmpItem = new SubscribeMsgTmpItem(parcel);
            AppMethodBeat.o(149547);
            return subscribeMsgTmpItem;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SubscribeMsgTmpItem[] newArray(int i2) {
            return new SubscribeMsgTmpItem[i2];
        }
    }

    static {
        AppMethodBeat.i(149554);
        AppMethodBeat.o(149554);
    }
}
