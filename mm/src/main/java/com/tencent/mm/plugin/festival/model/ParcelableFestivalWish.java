package com.tencent.mm.plugin.festival.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.festival.ui.view.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 C2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001CB\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0000H\u0016J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0000H\u0016J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\t\u0010+\u001a\u00020\u000fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010/\u001a\u00020\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u00108\u001a\u00020\u0004HÖ\u0001J\u0013\u00109\u001a\u00020\u001c2\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u0004HÖ\u0001J\t\u0010=\u001a\u00020\u0007HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0015¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/ParcelableFestivalWish;", "Landroid/os/Parcelable;", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$DanmakuComparable;", "sx", "", "sy", "wishId", "", "wishText", ch.COL_USERNAME, "encUsername", "hashUsername", "userNickname", "userHeadImgUrl", "createTime", "", UserDataStore.COUNTRY, "province", "city", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCity", "()Ljava/lang/String;", "getCountry", "getCreateTime", "()J", "getEncUsername", "getHashUsername", "isMyWish", "", "()Z", "getProvince", "getSx", "()I", "getSy", "getUserHeadImgUrl", "getUserNickname", "getUsername", "getWishId", "getWishText", "canCompare", "o", "compareTo", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Convert", "plugin-festival_release"})
public final class ParcelableFestivalWish implements Parcelable, c.b<ParcelableFestivalWish> {
    public static final Parcelable.Creator CREATOR = new b();
    public static final a UzR = new a((byte) 0);
    public final String UzM;
    public final String UzN;
    public final String UzO;
    private final String UzP;
    public final String UzQ;
    public final String country;
    private final long createTime;
    public final String fuJ;
    public final String fuK;
    public final String iEB;
    private final int kZy;
    private final int kZz;
    public final String username;

    @l(hxD = {1, 1, 16})
    public static class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(263151);
            p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
            ParcelableFestivalWish parcelableFestivalWish = new ParcelableFestivalWish(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
            AppMethodBeat.o(263151);
            return parcelableFestivalWish;
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i2) {
            return new ParcelableFestivalWish[i2];
        }
    }

    static {
        AppMethodBeat.i(263155);
        AppMethodBeat.o(263155);
    }

    public final int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
        if (kotlin.g.b.p.j(r5.fuK, r6.fuK) != false) goto L_0x0086;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 144
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.festival.model.ParcelableFestivalWish.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(263157);
        int i3 = ((this.kZy * 31) + this.kZz) * 31;
        String str = this.UzM;
        int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
        String str2 = this.UzN;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.username;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
        String str4 = this.UzO;
        int hashCode4 = ((str4 != null ? str4.hashCode() : 0) + hashCode3) * 31;
        String str5 = this.UzP;
        int hashCode5 = ((str5 != null ? str5.hashCode() : 0) + hashCode4) * 31;
        String str6 = this.iEB;
        int hashCode6 = ((str6 != null ? str6.hashCode() : 0) + hashCode5) * 31;
        String str7 = this.UzQ;
        int hashCode7 = str7 != null ? str7.hashCode() : 0;
        long j2 = this.createTime;
        int i4 = (((hashCode7 + hashCode6) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str8 = this.country;
        int hashCode8 = ((str8 != null ? str8.hashCode() : 0) + i4) * 31;
        String str9 = this.fuJ;
        int hashCode9 = ((str9 != null ? str9.hashCode() : 0) + hashCode8) * 31;
        String str10 = this.fuK;
        if (str10 != null) {
            i2 = str10.hashCode();
        }
        int i5 = hashCode9 + i2;
        AppMethodBeat.o(263157);
        return i5;
    }

    public final String toString() {
        AppMethodBeat.i(263156);
        String str = "ParcelableFestivalWish(sx=" + this.kZy + ", sy=" + this.kZz + ", wishId=" + this.UzM + ", wishText=" + this.UzN + ", username=" + this.username + ", encUsername=" + this.UzO + ", hashUsername=" + this.UzP + ", userNickname=" + this.iEB + ", userHeadImgUrl=" + this.UzQ + ", createTime=" + this.createTime + ", country=" + this.country + ", province=" + this.fuJ + ", city=" + this.fuK + ")";
        AppMethodBeat.o(263156);
        return str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(263159);
        p.h(parcel, "parcel");
        parcel.writeInt(this.kZy);
        parcel.writeInt(this.kZz);
        parcel.writeString(this.UzM);
        parcel.writeString(this.UzN);
        parcel.writeString(this.username);
        parcel.writeString(this.UzO);
        parcel.writeString(this.UzP);
        parcel.writeString(this.iEB);
        parcel.writeString(this.UzQ);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.country);
        parcel.writeString(this.fuJ);
        parcel.writeString(this.fuK);
        AppMethodBeat.o(263159);
    }

    public ParcelableFestivalWish(int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8, String str9, String str10) {
        this.kZy = i2;
        this.kZz = i3;
        this.UzM = str;
        this.UzN = str2;
        this.username = str3;
        this.UzO = str4;
        this.UzP = str5;
        this.iEB = str6;
        this.UzQ = str7;
        this.createTime = j2;
        this.country = str8;
        this.fuJ = str9;
        this.fuK = str10;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.festival.ui.view.c.b
    public final /* synthetic */ boolean gS(ParcelableFestivalWish parcelableFestivalWish) {
        AppMethodBeat.i(263153);
        ParcelableFestivalWish parcelableFestivalWish2 = parcelableFestivalWish;
        p.h(parcelableFestivalWish2, "o");
        String str = this.UzP;
        if (str == null) {
            str = "";
        }
        if (!p.j(str, parcelableFestivalWish2.UzP)) {
            String str2 = this.username;
            if (str2 == null) {
                str2 = "";
            }
            if (!p.j(str2, parcelableFestivalWish2.username)) {
                String str3 = this.UzM;
                if (str3 == null) {
                    str3 = "";
                }
                if (!p.j(str3, parcelableFestivalWish2.UzM) && !p.j(this, parcelableFestivalWish2)) {
                    AppMethodBeat.o(263153);
                    return false;
                }
            }
        }
        AppMethodBeat.o(263153);
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.festival.ui.view.c.b
    public final /* synthetic */ long gT(ParcelableFestivalWish parcelableFestivalWish) {
        AppMethodBeat.i(263154);
        ParcelableFestivalWish parcelableFestivalWish2 = parcelableFestivalWish;
        p.h(parcelableFestivalWish2, "o");
        String str = this.UzM;
        if (str == null) {
            str = "";
        }
        if (p.j(str, parcelableFestivalWish2.UzM) || p.j(this, parcelableFestivalWish2)) {
            AppMethodBeat.o(263154);
            return 0;
        }
        long j2 = this.createTime - parcelableFestivalWish2.createTime;
        AppMethodBeat.o(263154);
        return j2;
    }

    public final boolean hRT() {
        AppMethodBeat.i(263152);
        String str = this.username;
        if ((str == null || str.length() == 0) || !p.j(this.username, z.aTY())) {
            AppMethodBeat.o(263152);
            return false;
        }
        AppMethodBeat.o(263152);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/ParcelableFestivalWish$Convert;", "", "()V", "convertFrom", "Lcom/tencent/mm/plugin/festival/model/ParcelableFestivalWish;", "dao", "Lcom/tencent/mm/plugin/festival/model/LocalFestivalWishInfo;", "pb", "Lcom/tencent/mm/plugin/festival/proto/FestivalWish;", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static ParcelableFestivalWish a(ai aiVar) {
            AppMethodBeat.i(263150);
            p.h(aiVar, "dao");
            ParcelableFestivalWish parcelableFestivalWish = new ParcelableFestivalWish(aiVar.field_x, aiVar.field_y, aiVar.field_wishId, aiVar.field_wishText, aiVar.field_userName, aiVar.field_liveEncUsername, aiVar.field_hashUsername, aiVar.field_nickName, aiVar.field_headImgUrl, aiVar.field_createTime, aiVar.field_country, aiVar.field_province, aiVar.field_city);
            AppMethodBeat.o(263150);
            return parcelableFestivalWish;
        }
    }
}
