package com.tencent.mm.plugin.festival.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001;Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020/HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020/HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalWishContextBundle;", "Landroid/os/Parcelable;", "wishContent", "", "statusVerifyBuf", "afterAction", "Lcom/tencent/mm/plugin/festival/model/FestivalWishContextBundle$AfterAction;", "afterDonationTitle", "afterDonationDesc", "afterDonationLinkText", "afterDonationLinkUrl", "statusSourceName", "statusSourceActivityId", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/festival/model/FestivalWishContextBundle$AfterAction;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAfterAction", "()Lcom/tencent/mm/plugin/festival/model/FestivalWishContextBundle$AfterAction;", "setAfterAction", "(Lcom/tencent/mm/plugin/festival/model/FestivalWishContextBundle$AfterAction;)V", "getAfterDonationDesc", "()Ljava/lang/String;", "setAfterDonationDesc", "(Ljava/lang/String;)V", "getAfterDonationLinkText", "setAfterDonationLinkText", "getAfterDonationLinkUrl", "setAfterDonationLinkUrl", "getAfterDonationTitle", "setAfterDonationTitle", "getStatusSourceActivityId", "setStatusSourceActivityId", "getStatusSourceName", "setStatusSourceName", "getStatusVerifyBuf", "setStatusVerifyBuf", "getWishContent", "setWishContent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "AfterAction", "plugin-festival_release"})
public final class FestivalWishContextBundle implements Parcelable {
    public static final Parcelable.Creator CREATOR = new b();
    public String Uzg;
    public String Uzh;
    public a Uzi;
    public String Uzj;
    public String Uzk;
    public String Uzl;
    public String Uzm;
    public String Uzn;
    public String Uzo;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalWishContextBundle$AfterAction;", "", "(Ljava/lang/String;I)V", "NONE", "GoSetState", "ShowDonation", "plugin-festival_release"})
    public enum a {
        NONE,
        GoSetState,
        ShowDonation;

        static {
            AppMethodBeat.i(263086);
            AppMethodBeat.o(263086);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(263088);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(263088);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16})
    public static class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(263089);
            p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
            FestivalWishContextBundle festivalWishContextBundle = new FestivalWishContextBundle(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (a) Enum.valueOf(a.class, parcel.readString()) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            AppMethodBeat.o(263089);
            return festivalWishContextBundle;
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i2) {
            return new FestivalWishContextBundle[i2];
        }
    }

    static {
        AppMethodBeat.i(263095);
        AppMethodBeat.o(263095);
    }

    public final int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        if (kotlin.g.b.p.j(r3.Uzo, r4.Uzo) != false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
        // Method dump skipped, instructions count: 114
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.festival.model.FestivalWishContextBundle.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(263092);
        String str = this.Uzg;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.Uzh;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        a aVar = this.Uzi;
        int hashCode3 = ((aVar != null ? aVar.hashCode() : 0) + hashCode2) * 31;
        String str3 = this.Uzj;
        int hashCode4 = ((str3 != null ? str3.hashCode() : 0) + hashCode3) * 31;
        String str4 = this.Uzk;
        int hashCode5 = ((str4 != null ? str4.hashCode() : 0) + hashCode4) * 31;
        String str5 = this.Uzl;
        int hashCode6 = ((str5 != null ? str5.hashCode() : 0) + hashCode5) * 31;
        String str6 = this.Uzm;
        int hashCode7 = ((str6 != null ? str6.hashCode() : 0) + hashCode6) * 31;
        String str7 = this.Uzn;
        int hashCode8 = ((str7 != null ? str7.hashCode() : 0) + hashCode7) * 31;
        String str8 = this.Uzo;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        int i3 = hashCode8 + i2;
        AppMethodBeat.o(263092);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(263091);
        String str = "FestivalWishContextBundle(wishContent=" + this.Uzg + ", statusVerifyBuf=" + this.Uzh + ", afterAction=" + this.Uzi + ", afterDonationTitle=" + this.Uzj + ", afterDonationDesc=" + this.Uzk + ", afterDonationLinkText=" + this.Uzl + ", afterDonationLinkUrl=" + this.Uzm + ", statusSourceName=" + this.Uzn + ", statusSourceActivityId=" + this.Uzo + ")";
        AppMethodBeat.o(263091);
        return str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(263094);
        p.h(parcel, "parcel");
        parcel.writeString(this.Uzg);
        parcel.writeString(this.Uzh);
        a aVar = this.Uzi;
        if (aVar != null) {
            parcel.writeInt(1);
            parcel.writeString(aVar.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.Uzj);
        parcel.writeString(this.Uzk);
        parcel.writeString(this.Uzl);
        parcel.writeString(this.Uzm);
        parcel.writeString(this.Uzn);
        parcel.writeString(this.Uzo);
        AppMethodBeat.o(263094);
    }

    public FestivalWishContextBundle(String str, String str2, a aVar, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.Uzg = str;
        this.Uzh = str2;
        this.Uzi = aVar;
        this.Uzj = str3;
        this.Uzk = str4;
        this.Uzl = str5;
        this.Uzm = str6;
        this.Uzn = str7;
        this.Uzo = str8;
    }

    public /* synthetic */ FestivalWishContextBundle() {
        this(null, null, a.GoSetState, null, null, null, null, null, null);
        AppMethodBeat.i(263090);
        AppMethodBeat.o(263090);
    }
}
