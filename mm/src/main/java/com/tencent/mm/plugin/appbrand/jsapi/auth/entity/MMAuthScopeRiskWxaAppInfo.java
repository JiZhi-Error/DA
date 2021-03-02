package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B3\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0002\u0010\u000fJ\b\u0010\u001e\u001a\u00020\fH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\fH\u0016R\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\r\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "info", "Lcom/tencent/mm/protocal/protobuf/ScopeRiskWxaAppInfo;", "(Lcom/tencent/mm/protocal/protobuf/ScopeRiskWxaAppInfo;)V", ch.COL_USERNAME, "", "path", "version", "", "scene", "type", "(Ljava/lang/String;Ljava/lang/String;III)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getScene", "()I", "setScene", "(I)V", "getType", "setType", "getUsername", "setUsername", "getVersion", "setVersion", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public class MMAuthScopeRiskWxaAppInfo implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    public String path;
    public int scene;
    public int type;
    public String username;
    public int version;

    static {
        AppMethodBeat.i(228322);
        AppMethodBeat.o(228322);
    }

    private MMAuthScopeRiskWxaAppInfo(String str, String str2, int i2, int i3, int i4) {
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "path");
        AppMethodBeat.i(228319);
        this.username = str;
        this.path = str2;
        this.version = i2;
        this.scene = i3;
        this.type = i4;
        AppMethodBeat.o(228319);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MMAuthScopeRiskWxaAppInfo(Parcel parcel) {
        this(String.valueOf(parcel.readString()), String.valueOf(parcel.readString()), parcel.readInt(), parcel.readInt(), parcel.readInt());
        p.h(parcel, "parcel");
        AppMethodBeat.i(228320);
        AppMethodBeat.o(228320);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MMAuthScopeRiskWxaAppInfo(com.tencent.mm.protocal.protobuf.dre r8) {
        /*
            r7 = this;
            r6 = 228321(0x37be1, float:3.19946E-40)
            java.lang.String r0 = "info"
            kotlin.g.b.p.h(r8, r0)
            java.lang.String r1 = r8.username
            java.lang.String r0 = "info.username"
            kotlin.g.b.p.g(r1, r0)
            java.lang.String r2 = r8.path
            java.lang.String r0 = "info.path"
            kotlin.g.b.p.g(r2, r0)
            int r3 = r8.version
            int r4 = r8.scene
            int r5 = r8.type
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskWxaAppInfo.<init>(com.tencent.mm.protocal.protobuf.dre):void");
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(228318);
        p.h(parcel, "parcel");
        parcel.writeString(this.username);
        parcel.writeString(this.path);
        parcel.writeInt(this.version);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.type);
        AppMethodBeat.o(228318);
    }

    public int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "plugin-appbrand-integration_release"})
    public static final class a implements Parcelable.Creator<MMAuthScopeRiskWxaAppInfo> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MMAuthScopeRiskWxaAppInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(228317);
            p.h(parcel, "parcel");
            MMAuthScopeRiskWxaAppInfo mMAuthScopeRiskWxaAppInfo = new MMAuthScopeRiskWxaAppInfo(parcel);
            AppMethodBeat.o(228317);
            return mMAuthScopeRiskWxaAppInfo;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MMAuthScopeRiskWxaAppInfo[] newArray(int i2) {
            return new MMAuthScopeRiskWxaAppInfo[i2];
        }
    }
}
