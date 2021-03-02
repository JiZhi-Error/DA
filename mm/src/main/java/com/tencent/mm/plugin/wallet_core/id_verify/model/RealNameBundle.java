package com.tencent.mm.plugin.wallet_core.id_verify.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class RealNameBundle implements Parcelable {
    public static final Parcelable.Creator<RealNameBundle> CREATOR = new Parcelable.Creator<RealNameBundle>() {
        /* class com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RealNameBundle[] newArray(int i2) {
            return new RealNameBundle[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RealNameBundle createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70164);
            RealNameBundle realNameBundle = new RealNameBundle(parcel);
            AppMethodBeat.o(70164);
            return realNameBundle;
        }
    };
    public String HTZ;
    public String HUA;
    public String HUa;
    public String HUb;
    public int HUc;
    public String HUd;
    public Profession HUe;
    public String HUf;
    public String HUg;
    public String HUh;
    public String HUi;
    public int HUj;
    public String HUk;
    public int HUl;
    public int HUm;
    public int HUn;
    public String HUo;
    public int HUp;
    public int HUq;
    public int HUr;
    public String HUs;
    public String HUt;
    public String HUu;
    public String HUv;
    public String HUw;
    public int HUx;
    public int HUy;
    public int HUz;
    public int fuA;

    public RealNameBundle() {
    }

    protected RealNameBundle(Parcel parcel) {
        AppMethodBeat.i(70165);
        this.HTZ = parcel.readString();
        this.HUa = parcel.readString();
        this.HUb = parcel.readString();
        this.HUc = parcel.readInt();
        this.HUd = parcel.readString();
        this.HUe = (Profession) parcel.readParcelable(Profession.class.getClassLoader());
        this.HUf = parcel.readString();
        this.HUg = parcel.readString();
        this.HUh = parcel.readString();
        this.HUi = parcel.readString();
        this.HUj = parcel.readInt();
        this.HUk = parcel.readString();
        this.HUl = parcel.readInt();
        this.HUm = parcel.readInt();
        this.HUn = parcel.readInt();
        this.HUo = parcel.readString();
        this.HUp = parcel.readInt();
        this.HUq = parcel.readInt();
        this.HUr = parcel.readInt();
        this.HUs = parcel.readString();
        this.HUt = parcel.readString();
        this.HUu = parcel.readString();
        this.HUv = parcel.readString();
        this.HUw = parcel.readString();
        this.HUx = parcel.readInt();
        this.HUy = parcel.readInt();
        this.HUz = parcel.readInt();
        this.HUA = parcel.readString();
        this.fuA = parcel.readInt();
        AppMethodBeat.o(70165);
    }

    static {
        AppMethodBeat.i(70167);
        AppMethodBeat.o(70167);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(70166);
        parcel.writeString(this.HTZ);
        parcel.writeString(this.HUa);
        parcel.writeString(this.HUb);
        parcel.writeInt(this.HUc);
        parcel.writeString(this.HUd);
        parcel.writeParcelable(this.HUe, 1);
        parcel.writeString(this.HUf);
        parcel.writeString(this.HUg);
        parcel.writeString(this.HUh);
        parcel.writeString(this.HUi);
        parcel.writeInt(this.HUj);
        parcel.writeString(this.HUk);
        parcel.writeInt(this.HUl);
        parcel.writeInt(this.HUm);
        parcel.writeInt(this.HUn);
        parcel.writeString(this.HUo);
        parcel.writeInt(this.HUp);
        parcel.writeInt(this.HUq);
        parcel.writeInt(this.HUr);
        parcel.writeString(this.HUs);
        parcel.writeString(this.HUt);
        parcel.writeString(this.HUu);
        parcel.writeString(this.HUv);
        parcel.writeString(this.HUw);
        parcel.writeInt(this.HUx);
        parcel.writeInt(this.HUy);
        parcel.writeInt(this.HUz);
        parcel.writeString(this.HUA);
        parcel.writeInt(this.fuA);
        AppMethodBeat.o(70166);
    }

    public final void aY(Map<String, String> map) {
        AppMethodBeat.i(174505);
        map.put("detail_address", this.HUv);
        map.put("phone_no", this.HUA);
        map.put("sex", String.valueOf(this.fuA));
        map.put("nationality", this.HUs);
        map.put("birth_date", this.HUo);
        map.put("profession_name", this.HUe != null ? this.HUe.HTX : "");
        map.put("user_country", this.HUf);
        map.put("user_province", this.HUg);
        map.put("user_city", this.HUh);
        map.put("cre_expire_date", this.HUk);
        map.put("creid_renewal", String.valueOf(this.HUj));
        map.put("cre_effect_date", this.HUw);
        AppMethodBeat.o(174505);
    }
}
