package com.tencent.mm.plugin.profile.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001d\b\u0002\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0013H\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/profile/model/WxaRegisterInfo;", "Landroid/os/Parcelable;", "wxaRelateWeAppList", "Lcom/tencent/mm/protocal/protobuf/WxaRelateWeAppList;", "(Lcom/tencent/mm/protocal/protobuf/WxaRelateWeAppList;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "registerName", "", "entryInfos", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaEntryInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getEntryInfos", "()Ljava/util/List;", "getRegisterName", "()Ljava/lang/String;", "describeContents", "", "isValid", "", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class WxaRegisterInfo implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    public final String BcS;
    public final List<WxaAttributes.WxaEntryInfo> BcT;

    static {
        AppMethodBeat.i(229785);
        AppMethodBeat.o(229785);
    }

    private WxaRegisterInfo(String str, List<WxaAttributes.WxaEntryInfo> list) {
        this.BcS = str;
        this.BcT = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WxaRegisterInfo(com.tencent.mm.protocal.protobuf.feh r7) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.model.WxaRegisterInfo.<init>(com.tencent.mm.protocal.protobuf.feh):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WxaRegisterInfo(android.os.Parcel r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parcel"
            kotlin.g.b.p.h(r5, r0)
            java.lang.String r0 = r5.readString()
            if (r0 != 0) goto L_0x0029
            java.lang.String r0 = ""
            r2 = r0
        L_0x0010:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0 = r1
            java.util.List r0 = (java.util.List) r0
            android.os.Parcelable$Creator<com.tencent.mm.plugin.appbrand.config.WxaAttributes$WxaEntryInfo> r3 = com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo.CREATOR
            r5.readTypedList(r0, r3)
            java.util.List r1 = (java.util.List) r1
            r4.<init>(r2, r1)
            r0 = 229784(0x38198, float:3.21996E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r0)
            return
        L_0x0029:
            r2 = r0
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.model.WxaRegisterInfo.<init>(android.os.Parcel):void");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(229782);
        p.h(parcel, "parcel");
        parcel.writeString(this.BcS);
        parcel.writeTypedList(this.BcT);
        AppMethodBeat.o(229782);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/profile/model/WxaRegisterInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/profile/model/WxaRegisterInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/profile/model/WxaRegisterInfo;", "plugin-appbrand-integration_release"})
    public static final class a implements Parcelable.Creator<WxaRegisterInfo> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WxaRegisterInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(229781);
            p.h(parcel, "parcel");
            WxaRegisterInfo wxaRegisterInfo = new WxaRegisterInfo(parcel);
            AppMethodBeat.o(229781);
            return wxaRegisterInfo;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WxaRegisterInfo[] newArray(int i2) {
            return new WxaRegisterInfo[i2];
        }
    }
}
