package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.wcdb.FileUtils;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@Keep
@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 /2\u00020\u0001:\u0001/BW\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rB\u0007\b\u0016¢\u0006\u0002\u0010\u000eB\u000f\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u001e\u001a\u00020\u0003H\u0015J\b\u0010\u001f\u001a\u00020\u0001H\u0016J\b\u0010 \u001a\u00020\tH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\u0016\u0010#\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010$H\u0014J\b\u0010'\u001a\u00020\tH\u0016J\b\u0010(\u001a\u00020\u0003H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0001H\u0016J\u0018\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\tH\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "icon", "", "title", "appID", "appEntryPage", "appUserName", "handOffType", "", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAppEntryPage", "()Ljava/lang/String;", "setAppEntryPage", "(Ljava/lang/String;)V", "getAppID", "setAppID", "getAppUserName", "setAppUserName", "getIcon", "setIcon", "getTitle", "setTitle", "body", "copy", "describeContents", "doCreateBallInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "doCreateMultiTaskInfo", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "", "getDataType", "toString", "update", "", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
public class HandOffMP extends HandOff {
    public static final Parcelable.Creator<HandOffMP> CREATOR = new b();
    public static final a Companion = new a((byte) 0);
    private String appEntryPage;
    private String appID;
    private String appUserName;
    private String icon;
    private String title;

    public HandOffMP(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, str5, 0, null, null, null, 480, null);
    }

    public HandOffMP(String str, String str2, String str3, String str4, String str5, int i2) {
        this(str, str2, str3, str4, str5, i2, null, null, null, FileUtils.S_IRWXU, null);
        AppMethodBeat.i(121727);
        AppMethodBeat.o(121727);
    }

    public HandOffMP(String str, String str2, String str3, String str4, String str5, int i2, String str6) {
        this(str, str2, str3, str4, str5, i2, str6, null, null, 384, null);
    }

    public HandOffMP(String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7) {
        this(str, str2, str3, str4, str5, i2, str6, str7, null, 256, null);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        AppMethodBeat.i(238054);
        p.h(str, "<set-?>");
        this.icon = str;
        AppMethodBeat.o(238054);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        AppMethodBeat.i(238055);
        p.h(str, "<set-?>");
        this.title = str;
        AppMethodBeat.o(238055);
    }

    public final String getAppID() {
        return this.appID;
    }

    public final void setAppID(String str) {
        AppMethodBeat.i(238056);
        p.h(str, "<set-?>");
        this.appID = str;
        AppMethodBeat.o(238056);
    }

    public final String getAppEntryPage() {
        return this.appEntryPage;
    }

    public final void setAppEntryPage(String str) {
        AppMethodBeat.i(238057);
        p.h(str, "<set-?>");
        this.appEntryPage = str;
        AppMethodBeat.o(238057);
    }

    public final String getAppUserName() {
        return this.appUserName;
    }

    public final void setAppUserName(String str) {
        AppMethodBeat.i(238058);
        p.h(str, "<set-?>");
        this.appUserName = str;
        AppMethodBeat.o(238058);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HandOffMP(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, kotlin.g.b.j r22) {
        /*
            r11 = this;
            r1 = r21 & 32
            if (r1 == 0) goto L_0x0040
            r7 = 1
        L_0x0005:
            r1 = r21 & 64
            if (r1 == 0) goto L_0x003d
            java.lang.String r8 = ""
        L_0x000c:
            r0 = r21
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x003a
            java.lang.String r9 = ""
        L_0x0015:
            r0 = r21
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0037
            r1 = 3
            java.lang.String r10 = com.tencent.mm.plugin.handoff.model.HandOff.a.generateKey(r1, r7)
        L_0x0020:
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = 238059(0x3a1eb, float:3.33592E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            r1 = 238059(0x3a1eb, float:3.33592E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        L_0x0037:
            r10 = r20
            goto L_0x0020
        L_0x003a:
            r9 = r19
            goto L_0x0015
        L_0x003d:
            r8 = r18
            goto L_0x000c
        L_0x0040:
            r7 = r17
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.handoff.model.HandOffMP.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.j):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandOffMP(String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8) {
        super(i2, str6, str7, str8, null, 0, 48, null);
        p.h(str, "icon");
        p.h(str2, "title");
        p.h(str3, "appID");
        p.h(str4, "appEntryPage");
        p.h(str5, "appUserName");
        p.h(str6, "from");
        p.h(str7, "to");
        p.h(str8, "key");
        AppMethodBeat.i(121726);
        this.icon = str;
        this.title = str2;
        this.appID = str3;
        this.appEntryPage = str4;
        this.appUserName = str5;
        AppMethodBeat.o(121726);
    }

    public HandOffMP() {
        this("", "", "", "", "", 0, null, null, null, 480, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandOffMP(Parcel parcel) {
        super(parcel);
        p.h(parcel, "source");
        AppMethodBeat.i(121728);
        String readString = parcel.readString();
        if (readString == null) {
            p.hyc();
        }
        this.icon = readString;
        String readString2 = parcel.readString();
        if (readString2 == null) {
            p.hyc();
        }
        this.title = readString2;
        String readString3 = parcel.readString();
        if (readString3 == null) {
            p.hyc();
        }
        this.appID = readString3;
        String readString4 = parcel.readString();
        if (readString4 == null) {
            p.hyc();
        }
        this.appEntryPage = readString4;
        String readString5 = parcel.readString();
        if (readString5 == null) {
            p.hyc();
        }
        this.appUserName = readString5;
        AppMethodBeat.o(121728);
    }

    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public int getDataType() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public void update(HandOff handOff) {
        AppMethodBeat.i(121721);
        p.h(handOff, "newHandOff");
        super.update(handOff);
        if (handOff instanceof HandOffMP) {
            this.icon = ((HandOffMP) handOff).icon;
            this.title = ((HandOffMP) handOff).title;
            this.appID = ((HandOffMP) handOff).appID;
            this.appEntryPage = ((HandOffMP) handOff).appEntryPage;
            this.appUserName = ((HandOffMP) handOff).appUserName;
        }
        AppMethodBeat.o(121721);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public String body() {
        AppMethodBeat.i(121722);
        String buv = n.buv("\n        <icon>" + a.du(this.icon) + "</icon>\n        <title>" + a.du(this.title) + "</title>\n        <appid>" + a.du(this.appID) + "</appid>\n        <appentrypage>" + a.du(this.appEntryPage) + "</appentrypage>\n        <appusername>" + a.du(this.appUserName) + "</appusername>\n    ");
        AppMethodBeat.o(121722);
        return buv;
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(121723);
        p.h(parcel, "dest");
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.icon);
        parcel.writeString(this.title);
        parcel.writeString(this.appID);
        parcel.writeString(this.appEntryPage);
        parcel.writeString(this.appUserName);
        AppMethodBeat.o(121723);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/handoff/model/HandOffMP$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "api-handoff_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/handoff/model/HandOffMP$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "api-handoff_release"})
    public static final class b implements Parcelable.Creator<HandOffMP> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ HandOffMP createFromParcel(Parcel parcel) {
            AppMethodBeat.i(121719);
            p.h(parcel, "source");
            HandOffMP handOffMP = new HandOffMP(parcel);
            AppMethodBeat.o(121719);
            return handOffMP;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ HandOffMP[] newArray(int i2) {
            return new HandOffMP[i2];
        }
    }

    static {
        AppMethodBeat.i(121729);
        AppMethodBeat.o(121729);
    }

    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public HandOff copy() {
        AppMethodBeat.i(121724);
        HandOffMP handOffMP = new HandOffMP(this.icon, this.title, this.appID, this.appEntryPage, this.appUserName, getHandOffType(), getFrom(), getTo(), getKey());
        handOffMP.setId(getId());
        HandOffMP handOffMP2 = handOffMP;
        AppMethodBeat.o(121724);
        return handOffMP2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public BallInfo doCreateBallInfo() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public o<cru, byte[]> doCreateMultiTaskInfo() {
        return null;
    }

    public String toString() {
        AppMethodBeat.i(121725);
        String str = "HandOffMP(key='" + getKey() + "', id='" + getId() + "', createTime='" + getCreateTime() + ", icon='" + this.icon + "', title='" + this.title + "', appID='" + this.appID + "', appEntryPage='" + this.appEntryPage + "', appUserName='" + this.appUserName + "')";
        AppMethodBeat.o(121725);
        return str;
    }
}
