package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class CgiLqtPlanIndex extends c<dbs> {
    public CgiLqtPlanIndex() {
        AppMethodBeat.i(68434);
        d.a aVar = new d.a();
        aVar.iLN = new dbr();
        aVar.iLO = new dbs();
        aVar.funcId = 2796;
        aVar.uri = "/cgi-bin/mmpay-bin/planindex";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiLqtPlanIndex", "isfirstclick: %s");
        AppMethodBeat.o(68434);
    }

    public static PlanIndexParcel a(dbs dbs) {
        AppMethodBeat.i(68435);
        if (dbs == null) {
            AppMethodBeat.o(68435);
            return null;
        }
        PlanIndexParcel planIndexParcel = new PlanIndexParcel();
        planIndexParcel.pTZ = dbs.pTZ;
        planIndexParcel.pUa = dbs.pUa;
        Iterator<dbt> it = dbs.MGC.iterator();
        while (it.hasNext()) {
            dbt next = it.next();
            PlanItemParcel planItemParcel = new PlanItemParcel();
            planItemParcel.grV = next.grV;
            planItemParcel.eht = next.eht;
            planItemParcel.dDj = next.dDj;
            planItemParcel.AOk = next.AOk;
            planItemParcel.Htm = next.Htm;
            planItemParcel.Htn = next.Htn;
            planItemParcel.CiX = next.CiX;
            planItemParcel.Hts = next.Hts;
            if (next.MGF != null) {
                planItemParcel.Hto = new TransTipsItemParcel();
                planItemParcel.Hto.Htt = next.MGF.Htt;
                planItemParcel.Hto.ixw = next.MGF.ixw;
            }
            if (next.MGG != null) {
                planItemParcel.Htp = new MoreRecordsParcel();
                planItemParcel.Htp.title = next.MGG.title;
                planItemParcel.Htp.url = next.MGG.url;
            }
            if (next.MGH != null) {
                planItemParcel.Htq = new MngPlanItemParcel();
                planItemParcel.Htq.Htd = next.MGH.Htd;
                planItemParcel.Htq.Hte = next.MGH.Hte;
                Iterator<Integer> it2 = next.MGH.Mvb.iterator();
                while (it2.hasNext()) {
                    planItemParcel.Htq.Htf.add(it2.next());
                }
            }
            planItemParcel.Htr = next.Htr;
            planItemParcel.state = next.state;
            planItemParcel.ynT = next.ynT;
            planIndexParcel.Htg.add(planItemParcel);
        }
        planIndexParcel.Hth = dbs.Hth;
        planIndexParcel.Hti = dbs.Hti;
        if (dbs.MGD != null) {
            planIndexParcel.Htj = new BannerParcel();
            planIndexParcel.Htj.title = dbs.MGD.title;
            planIndexParcel.Htj.url = dbs.MGD.url;
        }
        planIndexParcel.Htk = dbs.Htk;
        planIndexParcel.Htl = dbs.Htl;
        AppMethodBeat.o(68435);
        return planIndexParcel;
    }

    public static class PlanIndexParcel implements Parcelable {
        public static final Parcelable.Creator<PlanIndexParcel> CREATOR = new Parcelable.Creator<PlanIndexParcel>() {
            /* class com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.PlanIndexParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PlanIndexParcel[] newArray(int i2) {
                return new PlanIndexParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PlanIndexParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(68421);
                PlanIndexParcel planIndexParcel = new PlanIndexParcel(parcel);
                AppMethodBeat.o(68421);
                return planIndexParcel;
            }
        };
        public ArrayList<PlanItemParcel> Htg = new ArrayList<>();
        public long Hth;
        public String Hti;
        public BannerParcel Htj;
        public String Htk;
        public String Htl;
        public int pTZ;
        public String pUa;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(68422);
            parcel.writeInt(this.pTZ);
            parcel.writeString(this.pUa);
            parcel.writeList(this.Htg);
            parcel.writeLong(this.Hth);
            parcel.writeString(this.Hti);
            parcel.writeParcelable(this.Htj, i2);
            parcel.writeString(this.Htk);
            parcel.writeString(this.Htl);
            AppMethodBeat.o(68422);
        }

        public PlanIndexParcel() {
            AppMethodBeat.i(68423);
            AppMethodBeat.o(68423);
        }

        protected PlanIndexParcel(Parcel parcel) {
            AppMethodBeat.i(68424);
            this.pTZ = parcel.readInt();
            this.pUa = parcel.readString();
            this.Htg = new ArrayList<>();
            parcel.readList(this.Htg, PlanItemParcel.class.getClassLoader());
            this.Hth = parcel.readLong();
            this.Hti = parcel.readString();
            this.Htj = (BannerParcel) parcel.readParcelable(BannerParcel.class.getClassLoader());
            this.Htk = parcel.readString();
            this.Htl = parcel.readString();
            AppMethodBeat.o(68424);
        }

        static {
            AppMethodBeat.i(68425);
            AppMethodBeat.o(68425);
        }
    }

    public static class PlanItemParcel implements Parcelable {
        public static final Parcelable.Creator<PlanItemParcel> CREATOR = new Parcelable.Creator<PlanItemParcel>() {
            /* class com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.PlanItemParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PlanItemParcel[] newArray(int i2) {
                return new PlanItemParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PlanItemParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(68426);
                PlanItemParcel planItemParcel = new PlanItemParcel(parcel);
                AppMethodBeat.o(68426);
                return planItemParcel;
            }
        };
        public String AOk;
        public String CiX;
        public String Htm;
        public String Htn;
        public TransTipsItemParcel Hto;
        public MoreRecordsParcel Htp;
        public MngPlanItemParcel Htq;
        public int Htr;
        public String Hts;
        public String dDj;
        public long eht;
        public int grV;
        public int state;
        public String ynT;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(68427);
            parcel.writeInt(this.grV);
            parcel.writeLong(this.eht);
            parcel.writeString(this.dDj);
            parcel.writeString(this.AOk);
            parcel.writeString(this.Htm);
            parcel.writeString(this.Htn);
            parcel.writeParcelable(this.Hto, i2);
            parcel.writeParcelable(this.Htp, i2);
            parcel.writeParcelable(this.Htq, i2);
            parcel.writeInt(this.Htr);
            parcel.writeInt(this.state);
            parcel.writeString(this.ynT);
            parcel.writeString(this.CiX);
            parcel.writeString(this.Hts);
            AppMethodBeat.o(68427);
        }

        public PlanItemParcel() {
        }

        protected PlanItemParcel(Parcel parcel) {
            AppMethodBeat.i(68428);
            this.grV = parcel.readInt();
            this.eht = parcel.readLong();
            this.dDj = parcel.readString();
            this.AOk = parcel.readString();
            this.Htm = parcel.readString();
            this.Htn = parcel.readString();
            this.Hto = (TransTipsItemParcel) parcel.readParcelable(TransTipsItemParcel.class.getClassLoader());
            this.Htp = (MoreRecordsParcel) parcel.readParcelable(MoreRecordsParcel.class.getClassLoader());
            this.Htq = (MngPlanItemParcel) parcel.readParcelable(MngPlanItemParcel.class.getClassLoader());
            this.Htr = parcel.readInt();
            this.state = parcel.readInt();
            this.ynT = parcel.readString();
            this.CiX = parcel.readString();
            this.Hts = parcel.readString();
            AppMethodBeat.o(68428);
        }

        static {
            AppMethodBeat.i(68429);
            AppMethodBeat.o(68429);
        }
    }

    public static class BannerParcel implements Parcelable {
        public static final Parcelable.Creator<BannerParcel> CREATOR = new Parcelable.Creator<BannerParcel>() {
            /* class com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.BannerParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ BannerParcel[] newArray(int i2) {
                return new BannerParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BannerParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(68408);
                BannerParcel bannerParcel = new BannerParcel(parcel);
                AppMethodBeat.o(68408);
                return bannerParcel;
            }
        };
        public String title;
        public String url;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(68409);
            parcel.writeString(this.title);
            parcel.writeString(this.url);
            AppMethodBeat.o(68409);
        }

        public BannerParcel() {
        }

        protected BannerParcel(Parcel parcel) {
            AppMethodBeat.i(68410);
            this.title = parcel.readString();
            this.url = parcel.readString();
            AppMethodBeat.o(68410);
        }

        static {
            AppMethodBeat.i(68411);
            AppMethodBeat.o(68411);
        }
    }

    public static class TransTipsItemParcel implements Parcelable {
        public static final Parcelable.Creator<TransTipsItemParcel> CREATOR = new Parcelable.Creator<TransTipsItemParcel>() {
            /* class com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.TransTipsItemParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ TransTipsItemParcel[] newArray(int i2) {
                return new TransTipsItemParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TransTipsItemParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(68430);
                TransTipsItemParcel transTipsItemParcel = new TransTipsItemParcel(parcel);
                AppMethodBeat.o(68430);
                return transTipsItemParcel;
            }
        };
        public String Htt;
        public String ixw;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(68431);
            parcel.writeString(this.Htt);
            parcel.writeString(this.ixw);
            AppMethodBeat.o(68431);
        }

        public TransTipsItemParcel() {
        }

        protected TransTipsItemParcel(Parcel parcel) {
            AppMethodBeat.i(68432);
            this.Htt = parcel.readString();
            this.ixw = parcel.readString();
            AppMethodBeat.o(68432);
        }

        static {
            AppMethodBeat.i(68433);
            AppMethodBeat.o(68433);
        }
    }

    public static class MoreRecordsParcel implements Parcelable {
        public static final Parcelable.Creator<MoreRecordsParcel> CREATOR = new Parcelable.Creator<MoreRecordsParcel>() {
            /* class com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.MoreRecordsParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ MoreRecordsParcel[] newArray(int i2) {
                return new MoreRecordsParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MoreRecordsParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(68417);
                MoreRecordsParcel moreRecordsParcel = new MoreRecordsParcel(parcel);
                AppMethodBeat.o(68417);
                return moreRecordsParcel;
            }
        };
        public String title;
        public String url;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(68418);
            parcel.writeString(this.title);
            parcel.writeString(this.url);
            AppMethodBeat.o(68418);
        }

        public MoreRecordsParcel() {
        }

        protected MoreRecordsParcel(Parcel parcel) {
            AppMethodBeat.i(68419);
            this.title = parcel.readString();
            this.url = parcel.readString();
            AppMethodBeat.o(68419);
        }

        static {
            AppMethodBeat.i(68420);
            AppMethodBeat.o(68420);
        }
    }

    public static class MngPlanItemParcel implements Parcelable {
        public static final Parcelable.Creator<MngPlanItemParcel> CREATOR = new Parcelable.Creator<MngPlanItemParcel>() {
            /* class com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.MngPlanItemParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ MngPlanItemParcel[] newArray(int i2) {
                return new MngPlanItemParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MngPlanItemParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(68412);
                MngPlanItemParcel mngPlanItemParcel = new MngPlanItemParcel(parcel);
                AppMethodBeat.o(68412);
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
            AppMethodBeat.i(68413);
            parcel.writeByte(this.Htd ? (byte) 1 : 0);
            parcel.writeString(this.Hte);
            parcel.writeList(this.Htf);
            AppMethodBeat.o(68413);
        }

        public MngPlanItemParcel() {
            AppMethodBeat.i(68414);
            AppMethodBeat.o(68414);
        }

        protected MngPlanItemParcel(Parcel parcel) {
            AppMethodBeat.i(68415);
            this.Htd = parcel.readByte() != 0;
            this.Hte = parcel.readString();
            this.Htf = new ArrayList<>();
            parcel.readList(this.Htf, Integer.class.getClassLoader());
            AppMethodBeat.o(68415);
        }

        static {
            AppMethodBeat.i(68416);
            AppMethodBeat.o(68416);
        }
    }
}
