package com.tencent.mm.plugin.appbrand.phonenumber;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 12\u00020\u0001:\u00011BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003Jc\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tHÆ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0013\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\t\u0010)\u001a\u00020%HÖ\u0001J\u0006\u0010*\u001a\u00020\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%HÖ\u0001R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000f\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u000f\"\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Landroid/os/Parcelable;", "mobile", "", "showMobile", "encryptedData", "iv", "cloud_id", "needAuth", "", "allowSendSms", "isWechat", "isCheck", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ)V", "getAllowSendSms", "()Z", "getCloud_id", "()Ljava/lang/String;", "getEncryptedData", "setCheck", "(Z)V", "setWechat", "getIv", "getMobile", "getNeedAuth", "getShowMobile", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toJSONStr", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "luggage-wechat-full-sdk_release"})
public final class PhoneItem implements Parcelable {
    public static final Parcelable.Creator CREATOR = new b();
    public static final a nzA = new a((byte) 0);
    public final String bxK;
    public final String dSf;
    final String nzt;
    public final String nzu;
    public final String nzv;
    public final boolean nzw;
    final boolean nzx;
    public boolean nzy;
    public boolean nzz;

    @l(hxD = {1, 1, 16})
    public static class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(230146);
            p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            boolean z4 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                z = false;
            }
            PhoneItem phoneItem = new PhoneItem(readString, readString2, readString3, readString4, readString5, z2, z3, z4, z);
            AppMethodBeat.o(230146);
            return phoneItem;
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i2) {
            return new PhoneItem[i2];
        }
    }

    static {
        AppMethodBeat.i(148075);
        AppMethodBeat.o(148075);
    }

    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        int i2 = 1;
        int i3 = 0;
        AppMethodBeat.i(148077);
        String str = this.dSf;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nzt;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.nzu;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
        String str4 = this.bxK;
        int hashCode4 = ((str4 != null ? str4.hashCode() : 0) + hashCode3) * 31;
        String str5 = this.nzv;
        if (str5 != null) {
            i3 = str5.hashCode();
        }
        int i4 = (hashCode4 + i3) * 31;
        boolean z = this.nzw;
        if (z) {
            z = true;
        }
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = z ? 1 : 0;
        int i8 = (i5 + i4) * 31;
        boolean z2 = this.nzx;
        if (z2) {
            z2 = true;
        }
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = z2 ? 1 : 0;
        int i12 = (i9 + i8) * 31;
        boolean z3 = this.nzy;
        if (z3) {
            z3 = true;
        }
        int i13 = z3 ? 1 : 0;
        int i14 = z3 ? 1 : 0;
        int i15 = z3 ? 1 : 0;
        int i16 = (i13 + i12) * 31;
        boolean z4 = this.nzz;
        if (!z4) {
            i2 = z4 ? 1 : 0;
        }
        int i17 = i16 + i2;
        AppMethodBeat.o(148077);
        return i17;
    }

    public final String toString() {
        AppMethodBeat.i(148076);
        String str = "PhoneItem(mobile=" + this.dSf + ", showMobile=" + this.nzt + ", encryptedData=" + this.nzu + ", iv=" + this.bxK + ", cloud_id=" + this.nzv + ", needAuth=" + this.nzw + ", allowSendSms=" + this.nzx + ", isWechat=" + this.nzy + ", isCheck=" + this.nzz + ")";
        AppMethodBeat.o(148076);
        return str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(148072);
        p.h(parcel, "parcel");
        parcel.writeString(this.dSf);
        parcel.writeString(this.nzt);
        parcel.writeString(this.nzu);
        parcel.writeString(this.bxK);
        parcel.writeString(this.nzv);
        parcel.writeInt(this.nzw ? 1 : 0);
        parcel.writeInt(this.nzx ? 1 : 0);
        parcel.writeInt(this.nzy ? 1 : 0);
        parcel.writeInt(this.nzz ? 1 : 0);
        AppMethodBeat.o(148072);
    }

    public PhoneItem(String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, boolean z3, boolean z4) {
        p.h(str, "mobile");
        p.h(str2, "showMobile");
        p.h(str3, "encryptedData");
        p.h(str4, "iv");
        p.h(str5, "cloud_id");
        AppMethodBeat.i(148073);
        this.dSf = str;
        this.nzt = str2;
        this.nzu = str3;
        this.bxK = str4;
        this.nzv = str5;
        this.nzw = z;
        this.nzx = z2;
        this.nzy = z3;
        this.nzz = z4;
        AppMethodBeat.o(148073);
    }

    public /* synthetic */ PhoneItem(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, str5, false, true, false, true);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(148071);
        if (!(obj instanceof PhoneItem)) {
            boolean equals = super.equals(obj);
            AppMethodBeat.o(148071);
            return equals;
        } else if (!p.j(((PhoneItem) obj).dSf, this.dSf) || ((PhoneItem) obj).nzy != this.nzy) {
            AppMethodBeat.o(148071);
            return false;
        } else {
            AppMethodBeat.o(148071);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem$Companion;", "", "()V", "TAG", "", "parseFromJson", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "jsonStr", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static PhoneItem aet(String str) {
            AppMethodBeat.i(148070);
            p.h(str, "jsonStr");
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("mobile");
                String optString2 = jSONObject.optString("show_mobile");
                boolean optBoolean = jSONObject.optBoolean("need_auth", true);
                boolean optBoolean2 = jSONObject.optBoolean("allow_send_sms", true);
                String optString3 = jSONObject.optString("encryptedData");
                String optString4 = jSONObject.optString("iv");
                boolean optBoolean3 = jSONObject.optBoolean("is_wechat", false);
                boolean optBoolean4 = jSONObject.optBoolean("is_check", false);
                String optString5 = jSONObject.optString("cloud_id", "");
                p.g(optString, "mobile");
                p.g(optString2, "showMobile");
                p.g(optString3, "encryptedData");
                p.g(optString4, "iv");
                p.g(optString5, "cloud_id");
                PhoneItem phoneItem = new PhoneItem(optString, optString2, optString3, optString4, optString5, optBoolean, optBoolean2, optBoolean3, optBoolean4);
                AppMethodBeat.o(148070);
                return phoneItem;
            } catch (JSONException e2) {
                Log.e("MicroMsg.PhoneItem", "jsonStr:%s", str);
                AppMethodBeat.o(148070);
                return null;
            }
        }
    }
}
