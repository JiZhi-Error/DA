package com.tencent.mm.plugin.appbrand.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u00010BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003JM\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0013\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\b\u0010*\u001a\u00020\u0005H\u0016J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenDeclarePromptBundle;", "Landroid/os/Parcelable;", "bizType", "", "funcId", "", "promptTitle", "promptMessage", "promptOkBtnText", "cancelable", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getBizType", "()I", "setBizType", "(I)V", "getCancelable", "()Z", "setCancelable", "(Z)V", "getFuncId", "()Ljava/lang/String;", "setFuncId", "(Ljava/lang/String;)V", "getPromptMessage", "setPromptMessage", "getPromptOkBtnText", "setPromptOkBtnText", "getPromptTitle", "setPromptTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "PromptBizType", "api-protocol_release"})
public final class WeAppOpenDeclarePromptBundle implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public int fuQ;
    public String kHR;
    public String kHS;
    public String kHT;
    public String kHU;
    public boolean ox;

    @l(hxD = {1, 1, 16})
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(194315);
            p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
            WeAppOpenDeclarePromptBundle weAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
            AppMethodBeat.o(194315);
            return weAppOpenDeclarePromptBundle;
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i2) {
            return new WeAppOpenDeclarePromptBundle[i2];
        }
    }

    static {
        AppMethodBeat.i(194320);
        AppMethodBeat.o(194320);
    }

    public WeAppOpenDeclarePromptBundle(byte b2) {
        this();
    }

    public final int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r3.ox == r4.ox) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 194318(0x2f70e, float:2.72298E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0042
            boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle
            if (r0 == 0) goto L_0x0047
            com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle r4 = (com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle) r4
            int r0 = r3.fuQ
            int r1 = r4.fuQ
            if (r0 != r1) goto L_0x0047
            java.lang.String r0 = r3.kHR
            java.lang.String r1 = r4.kHR
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0047
            java.lang.String r0 = r3.kHS
            java.lang.String r1 = r4.kHS
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0047
            java.lang.String r0 = r3.kHT
            java.lang.String r1 = r4.kHT
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0047
            java.lang.String r0 = r3.kHU
            java.lang.String r1 = r4.kHU
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0047
            boolean r0 = r3.ox
            boolean r1 = r4.ox
            if (r0 != r1) goto L_0x0047
        L_0x0042:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0046:
            return r0
        L_0x0047:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0046
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(194317);
        int i3 = this.fuQ * 31;
        String str = this.kHR;
        int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
        String str2 = this.kHS;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.kHT;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
        String str4 = this.kHU;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i4 = (hashCode3 + i2) * 31;
        boolean z = this.ox;
        if (z) {
            z = true;
        }
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = z ? 1 : 0;
        int i8 = i5 + i4;
        AppMethodBeat.o(194317);
        return i8;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(194319);
        p.h(parcel, "parcel");
        parcel.writeInt(this.fuQ);
        parcel.writeString(this.kHR);
        parcel.writeString(this.kHS);
        parcel.writeString(this.kHT);
        parcel.writeString(this.kHU);
        parcel.writeInt(this.ox ? 1 : 0);
        AppMethodBeat.o(194319);
    }

    public WeAppOpenDeclarePromptBundle(int i2, String str, String str2, String str3, String str4, boolean z) {
        this.fuQ = i2;
        this.kHR = str;
        this.kHS = str2;
        this.kHT = str3;
        this.kHU = str4;
        this.ox = z;
    }

    private /* synthetic */ WeAppOpenDeclarePromptBundle() {
        this(0, null, null, null, null, false);
    }

    public final String toString() {
        AppMethodBeat.i(194316);
        String str = "WeAppOpenDeclarePromptBundle(bizType=" + this.fuQ + ", funcI=" + this.kHR + ", promptTitle=" + Util.nullAs(this.kHS, "") + ", promptMessage=" + Util.nullAs(this.kHT, "") + ", promptOkBtnText=" + Util.nullAs(this.kHU, "") + ", cancelabl=" + Util.nullAs(Boolean.valueOf(this.ox), false);
        AppMethodBeat.o(194316);
        return str;
    }
}
