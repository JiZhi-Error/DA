package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.drd;
import com.tencent.mm.protocal.protobuf.dre;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B7\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\b\u0010$\u001a\u00020\tH\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\tH\u0016R\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "scopeRiskPopUpInfo", "Lcom/tencent/mm/protocal/protobuf/ScopeRiskPopUpInfo;", "(Lcom/tencent/mm/protocal/protobuf/ScopeRiskPopUpInfo;)V", "route_type", "", "wording", "", "left_button_wording", "right_button_wording", "right_button_h5_url", "wxa_app_info", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;)V", "getLeft_button_wording", "()Ljava/lang/String;", "setLeft_button_wording", "(Ljava/lang/String;)V", "getRight_button_h5_url", "setRight_button_h5_url", "getRight_button_wording", "setRight_button_wording", "getRoute_type", "()I", "setRoute_type", "(I)V", "getWording", "setWording", "getWxa_app_info", "()Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "setWxa_app_info", "(Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;)V", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public class MMAuthScopeRiskInfo implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    public String dQx;
    public String lHA;
    public String lHB;
    public String lHC;
    public MMAuthScopeRiskWxaAppInfo lHD;
    public int lHz;

    static {
        AppMethodBeat.i(228316);
        AppMethodBeat.o(228316);
    }

    private MMAuthScopeRiskInfo(int i2, String str, String str2, String str3, String str4, MMAuthScopeRiskWxaAppInfo mMAuthScopeRiskWxaAppInfo) {
        p.h(str, "wording");
        p.h(str2, "left_button_wording");
        p.h(str3, "right_button_wording");
        p.h(str4, "right_button_h5_url");
        AppMethodBeat.i(228313);
        this.lHz = i2;
        this.dQx = str;
        this.lHA = str2;
        this.lHB = str3;
        this.lHC = str4;
        this.lHD = mMAuthScopeRiskWxaAppInfo;
        AppMethodBeat.o(228313);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MMAuthScopeRiskInfo(Parcel parcel) {
        this(parcel.readInt(), String.valueOf(parcel.readString()), String.valueOf(parcel.readString()), String.valueOf(parcel.readString()), String.valueOf(parcel.readString()), (MMAuthScopeRiskWxaAppInfo) parcel.readParcelable(MMAuthScopeRiskWxaAppInfo.class.getClassLoader()));
        p.h(parcel, "parcel");
        AppMethodBeat.i(228314);
        AppMethodBeat.o(228314);
    }

    public MMAuthScopeRiskInfo(drd drd) {
        MMAuthScopeRiskWxaAppInfo mMAuthScopeRiskWxaAppInfo;
        MMAuthScopeRiskInfo mMAuthScopeRiskInfo;
        p.h(drd, "scopeRiskPopUpInfo");
        int i2 = drd.lHz;
        String yO = drd.MTL.yO();
        p.g(yO, "scopeRiskPopUpInfo.wording.toStringUtf8()");
        String yO2 = drd.MTM.yO();
        p.g(yO2, "scopeRiskPopUpInfo.left_…on_wording.toStringUtf8()");
        String yO3 = drd.MTN.yO();
        p.g(yO3, "scopeRiskPopUpInfo.right…on_wording.toStringUtf8()");
        String yO4 = drd.MTO.yO();
        p.g(yO4, "scopeRiskPopUpInfo.right…ton_h5_url.toStringUtf8()");
        dre dre = drd.MTP;
        if (dre != null) {
            mMAuthScopeRiskWxaAppInfo = new MMAuthScopeRiskWxaAppInfo(dre);
            mMAuthScopeRiskInfo = this;
        } else {
            mMAuthScopeRiskWxaAppInfo = null;
            mMAuthScopeRiskInfo = this;
        }
        new MMAuthScopeRiskInfo(i2, yO, yO2, yO3, yO4, mMAuthScopeRiskWxaAppInfo);
        AppMethodBeat.o(228315);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(228312);
        p.h(parcel, "parcel");
        parcel.writeInt(this.lHz);
        parcel.writeString(this.dQx);
        parcel.writeString(this.lHA);
        parcel.writeString(this.lHB);
        parcel.writeString(this.lHC);
        parcel.writeParcelable(this.lHD, i2);
        AppMethodBeat.o(228312);
    }

    public int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "plugin-appbrand-integration_release"})
    public static final class a implements Parcelable.Creator<MMAuthScopeRiskInfo> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MMAuthScopeRiskInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(228311);
            p.h(parcel, "parcel");
            MMAuthScopeRiskInfo mMAuthScopeRiskInfo = new MMAuthScopeRiskInfo(parcel);
            AppMethodBeat.o(228311);
            return mMAuthScopeRiskInfo;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MMAuthScopeRiskInfo[] newArray(int i2) {
            return new MMAuthScopeRiskInfo[i2];
        }
    }
}
