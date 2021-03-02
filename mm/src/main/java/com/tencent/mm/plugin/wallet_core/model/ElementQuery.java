package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ElementQuery implements Parcelable {
    public static final Parcelable.Creator<ElementQuery> CREATOR = new Parcelable.Creator<ElementQuery>() {
        /* class com.tencent.mm.plugin.wallet_core.model.ElementQuery.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ElementQuery[] newArray(int i2) {
            return new ElementQuery[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ElementQuery createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70268);
            ElementQuery elementQuery = new ElementQuery(parcel);
            AppMethodBeat.o(70268);
            return elementQuery;
        }
    };
    public static String HXb = "bind_serial";
    public String ANo;
    public int HQg;
    public String HUU;
    public boolean HXA;
    public String HXB;
    private List<Integer> HXC = null;
    public boolean HXD;
    public String HXE;
    public int HXF;
    public ArrayList<CreTypeRuleInfo> HXG;
    public boolean HXH = false;
    public String HXc;
    public boolean HXd;
    public boolean HXe;
    public boolean HXf;
    public boolean HXg;
    public String HXh;
    public String HXi;
    public boolean HXj;
    public int HXk;
    public int HXl;
    public String HXm;
    public String HXn;
    public String HXo;
    public String HXp;
    public String HXq;
    public String HXr;
    public boolean HXs;
    public boolean HXt;
    public boolean HXu;
    public boolean HXv;
    public boolean HXw;
    public boolean HXx;
    public boolean HXy;
    public boolean HXz;
    public String dDj;
    public JSONObject dhz;
    public String ynT;

    static {
        AppMethodBeat.i(70274);
        AppMethodBeat.o(70274);
    }

    public final boolean isError() {
        AppMethodBeat.i(70269);
        boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(Util.nullAs(this.HXn, "").trim());
        AppMethodBeat.o(70269);
        return equals;
    }

    public final boolean fQd() {
        return 2 == this.HXl;
    }

    public final boolean fQr() {
        return 1 == this.HXl;
    }

    public final List<Integer> fQs() {
        AppMethodBeat.i(70270);
        if (this.HXC != null) {
            List<Integer> list = this.HXC;
            AppMethodBeat.o(70270);
            return list;
        } else if (!Util.isNullOrNil(this.HXB)) {
            this.HXC = new ArrayList();
            for (String str : this.HXB.split("\\|")) {
                int i2 = Util.getInt(str, 0);
                if (i2 > 0) {
                    this.HXC.add(Integer.valueOf(i2));
                }
            }
            List<Integer> list2 = this.HXC;
            AppMethodBeat.o(70270);
            return list2;
        } else {
            AppMethodBeat.o(70270);
            return null;
        }
    }

    public static ArrayList<CreTypeRuleInfo> bG(JSONObject jSONObject) {
        JSONArray optJSONArray;
        AppMethodBeat.i(70271);
        ArrayList<CreTypeRuleInfo> arrayList = new ArrayList<>();
        if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray("cre_rule_array")) == null)) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                CreTypeRuleInfo bE = CreTypeRuleInfo.bE(optJSONArray.optJSONObject(i2));
                if (bE != null) {
                    arrayList.add(bE);
                }
            }
        }
        AppMethodBeat.o(70271);
        return arrayList;
    }

    public ElementQuery() {
    }

    public ElementQuery(Parcel parcel) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14 = true;
        AppMethodBeat.i(70272);
        this.ANo = parcel.readString();
        this.ynT = parcel.readString();
        this.HXc = parcel.readString();
        this.HXd = 1 == parcel.readInt();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.HXe = z;
        if (1 == parcel.readInt()) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.HXf = z2;
        if (1 == parcel.readInt()) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.HXg = z3;
        this.HXi = parcel.readString();
        this.ANo = parcel.readString();
        if (1 == parcel.readInt()) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.HXj = z4;
        this.HXk = parcel.readInt();
        this.HXl = parcel.readInt();
        this.dDj = parcel.readString();
        this.HXm = parcel.readString();
        this.HXn = parcel.readString();
        this.HXo = parcel.readString();
        this.HXr = parcel.readString();
        this.HXq = parcel.readString();
        this.HXp = parcel.readString();
        this.HXs = 1 == parcel.readInt();
        if (1 == parcel.readInt()) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.HXt = z5;
        if (1 == parcel.readInt()) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.HXu = z6;
        if (1 == parcel.readInt()) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.HXv = z7;
        if (1 == parcel.readInt()) {
            z8 = true;
        } else {
            z8 = false;
        }
        this.HXw = z8;
        if (1 == parcel.readInt()) {
            z9 = true;
        } else {
            z9 = false;
        }
        this.HXx = z9;
        if (1 == parcel.readInt()) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.HXz = z10;
        if (1 == parcel.readInt()) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.HXy = z11;
        if (1 == parcel.readInt()) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.HXA = z12;
        this.HQg = parcel.readInt();
        this.HXB = parcel.readString();
        if (1 == parcel.readInt()) {
            z13 = true;
        } else {
            z13 = false;
        }
        this.HXH = z13;
        this.HUU = parcel.readString();
        this.HXD = 1 != parcel.readInt() ? false : z14;
        this.HXE = parcel.readString();
        this.HXF = parcel.readInt();
        this.HXG = parcel.readArrayList(CreTypeRuleInfo.class.getClassLoader());
        AppMethodBeat.o(70272);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = 1;
        AppMethodBeat.i(70273);
        parcel.writeString(Util.nullAs(this.ANo, ""));
        parcel.writeString(Util.nullAs(this.ynT, ""));
        parcel.writeString(Util.nullAs(this.HXc, ""));
        parcel.writeInt(this.HXd ? 1 : 0);
        if (this.HXe) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        if (this.HXf) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        parcel.writeInt(i4);
        if (this.HXg) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        parcel.writeInt(i5);
        parcel.writeString(Util.nullAs(this.HXi, ""));
        parcel.writeString(Util.nullAs(this.ANo, ""));
        if (this.HXj) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        parcel.writeInt(i6);
        parcel.writeInt(this.HXk);
        parcel.writeInt(this.HXl);
        parcel.writeString(Util.nullAs(this.dDj, ""));
        parcel.writeString(Util.nullAs(this.HXm, ""));
        parcel.writeString(Util.nullAs(this.HXn, ""));
        parcel.writeString(Util.nullAs(this.HXo, ""));
        parcel.writeString(Util.nullAs(this.HXr, ""));
        parcel.writeString(Util.nullAs(this.HXq, ""));
        parcel.writeString(Util.nullAs(this.HXp, ""));
        parcel.writeInt(this.HXs ? 1 : 0);
        if (this.HXt) {
            i7 = 1;
        } else {
            i7 = 0;
        }
        parcel.writeInt(i7);
        if (this.HXu) {
            i8 = 1;
        } else {
            i8 = 0;
        }
        parcel.writeInt(i8);
        if (this.HXv) {
            i9 = 1;
        } else {
            i9 = 0;
        }
        parcel.writeInt(i9);
        if (this.HXw) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        parcel.writeInt(i10);
        if (this.HXx) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        parcel.writeInt(i11);
        if (this.HXz) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        parcel.writeInt(i12);
        if (this.HXy) {
            i13 = 1;
        } else {
            i13 = 0;
        }
        parcel.writeInt(i13);
        if (this.HXA) {
            i14 = 1;
        } else {
            i14 = 0;
        }
        parcel.writeInt(i14);
        parcel.writeInt(this.HQg);
        parcel.writeString(this.HXB);
        if (this.HXH) {
            i15 = 1;
        } else {
            i15 = 0;
        }
        parcel.writeInt(i15);
        parcel.writeString(this.HUU);
        if (!this.HXD) {
            i16 = 0;
        }
        parcel.writeInt(i16);
        parcel.writeString(this.HXE);
        parcel.writeInt(this.HXF);
        parcel.writeList(this.HXG);
        AppMethodBeat.o(70273);
    }
}
