package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.dgw;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class CgiLqtPlanOrderList extends c<dgx> {
    public CgiLqtPlanOrderList(int i2, int i3, int i4) {
        AppMethodBeat.i(68445);
        d.a aVar = new d.a();
        aVar.iLN = new dgw();
        aVar.iLO = new dgx();
        aVar.funcId = 1916;
        aVar.uri = "/cgi-bin/mmpay-bin/qryautoplanorderlist";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        dgw dgw = (dgw) aXF.iLK.iLR;
        dgw.MLr = (long) i2;
        dgw.offset = (long) i3;
        dgw.MLs = (long) i4;
        c(aXF);
        Log.i("MicroMsg.CgiLqtPlanOrderList", "CgiLqtPlanOrderList Req：plan_id: %s, offset: %s, limit: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(68445);
    }

    public static PlanItemParcel a(dbt dbt) {
        AppMethodBeat.i(68446);
        if (dbt == null) {
            AppMethodBeat.o(68446);
            return null;
        }
        PlanItemParcel planItemParcel = new PlanItemParcel();
        planItemParcel.Htr = dbt.Htr;
        planItemParcel.eht = dbt.eht;
        planItemParcel.grV = dbt.grV;
        planItemParcel.CiX = dbt.CiX;
        planItemParcel.ynT = dbt.ynT;
        planItemParcel.dDj = dbt.dDj;
        planItemParcel.AOk = dbt.AOk;
        planItemParcel.state = dbt.state;
        planItemParcel.Hts = dbt.Hts;
        if (dbt.MGH != null) {
            planItemParcel.Htu = new MngPlanItemParcel();
            planItemParcel.Htu.Htd = dbt.MGH.Htd;
            planItemParcel.Htu.Hte = dbt.MGH.Hte;
            Iterator<Integer> it = dbt.MGH.Mvb.iterator();
            while (it.hasNext()) {
                planItemParcel.Htu.Htf.add(it.next());
            }
        }
        AppMethodBeat.o(68446);
        return planItemParcel;
    }

    public static class PlanItemParcel implements Parcelable {
        public static final Parcelable.Creator<PlanItemParcel> CREATOR = new Parcelable.Creator<PlanItemParcel>() {
            /* class com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList.PlanItemParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PlanItemParcel[] newArray(int i2) {
                return new PlanItemParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PlanItemParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(68441);
                PlanItemParcel planItemParcel = new PlanItemParcel(parcel);
                AppMethodBeat.o(68441);
                return planItemParcel;
            }
        };
        public String AOk;
        public String CiX;
        public int Htr;
        public String Hts;
        public MngPlanItemParcel Htu;
        public String dDj;
        public long eht;
        public int grV;
        public int state;
        public String ynT;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(68442);
            parcel.writeInt(this.grV);
            parcel.writeLong(this.eht);
            parcel.writeString(this.dDj);
            parcel.writeString(this.AOk);
            parcel.writeParcelable(this.Htu, i2);
            parcel.writeInt(this.Htr);
            parcel.writeInt(this.state);
            parcel.writeString(this.ynT);
            parcel.writeString(this.CiX);
            parcel.writeString(this.Hts);
            AppMethodBeat.o(68442);
        }

        public PlanItemParcel() {
        }

        protected PlanItemParcel(Parcel parcel) {
            AppMethodBeat.i(68443);
            this.grV = parcel.readInt();
            this.eht = parcel.readLong();
            this.dDj = parcel.readString();
            this.AOk = parcel.readString();
            this.Htu = (MngPlanItemParcel) parcel.readParcelable(MngPlanItemParcel.class.getClassLoader());
            this.Htr = parcel.readInt();
            this.state = parcel.readInt();
            this.ynT = parcel.readString();
            this.CiX = parcel.readString();
            this.Hts = parcel.readString();
            AppMethodBeat.o(68443);
        }

        static {
            AppMethodBeat.i(68444);
            AppMethodBeat.o(68444);
        }
    }

    public static class MngPlanItemParcel implements Parcelable {
        public static final Parcelable.Creator<MngPlanItemParcel> CREATOR = new Parcelable.Creator<MngPlanItemParcel>() {
            /* class com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList.MngPlanItemParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ MngPlanItemParcel[] newArray(int i2) {
                return new MngPlanItemParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MngPlanItemParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(68436);
                MngPlanItemParcel mngPlanItemParcel = new MngPlanItemParcel(parcel);
                AppMethodBeat.o(68436);
                return mngPlanItemParcel;
            }
        };
        public boolean Htd;
        public String Hte;
        public ArrayList<Integer> Htf = new ArrayList<>();

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(68437);
            parcel.writeByte(this.Htd ? (byte) 1 : 0);
            parcel.writeString(this.Hte);
            parcel.writeList(this.Htf);
            AppMethodBeat.o(68437);
        }

        public MngPlanItemParcel() {
            AppMethodBeat.i(68438);
            AppMethodBeat.o(68438);
        }

        protected MngPlanItemParcel(Parcel parcel) {
            AppMethodBeat.i(68439);
            this.Htd = parcel.readByte() != 0;
            this.Hte = parcel.readString();
            this.Htf = new ArrayList<>();
            parcel.readList(this.Htf, Integer.class.getClassLoader());
            AppMethodBeat.o(68439);
        }

        static {
            AppMethodBeat.i(68440);
            AppMethodBeat.o(68440);
        }
    }
}
