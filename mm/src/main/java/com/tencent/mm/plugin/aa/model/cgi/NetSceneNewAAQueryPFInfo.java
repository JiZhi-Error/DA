package com.tencent.mm.plugin.aa.model.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;
import java.util.ArrayList;
import java.util.Iterator;

public final class NetSceneNewAAQueryPFInfo extends r {
    private i callback;
    private d hJu;
    private dhz jTq = ((dhz) this.hJu.iLK.iLR);
    public dia jTr;

    public NetSceneNewAAQueryPFInfo(String str, String str2) {
        AppMethodBeat.i(63416);
        d.a aVar = new d.a();
        aVar.iLN = new dhz();
        aVar.iLO = new dia();
        aVar.funcId = 1809;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerypfinfo";
        this.hJu = aVar.aXF();
        this.jTq.KBC = str;
        this.jTq.dNI = str2;
        Log.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "do scene NetSceneNewAAQueryPFInfo pf_order_no:%s appid:%s", str, str2);
        AppMethodBeat.o(63416);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1809;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63417);
        Log.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(63417);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(63418);
        Log.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.jTr = (dia) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.jTr.dDN), this.jTr.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(63418);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        dia dia = (dia) ((d) sVar).iLL.iLR;
        this.RtZ = dia.dDN;
        this.Rua = dia.qwn;
    }

    public static PfInfoParcel a(dia dia) {
        AppMethodBeat.i(63419);
        if (dia == null) {
            AppMethodBeat.o(63419);
            return null;
        }
        PfInfoParcel pfInfoParcel = new PfInfoParcel();
        pfInfoParcel.eht = dia.eht;
        pfInfoParcel.jTz = dia.jTz;
        Iterator<l> it = dia.KBx.iterator();
        while (it.hasNext()) {
            l next = it.next();
            AALaunchItemParcel aALaunchItemParcel = new AALaunchItemParcel();
            aALaunchItemParcel.username = next.username;
            aALaunchItemParcel.eht = next.eht;
            pfInfoParcel.jTA.add(aALaunchItemParcel);
        }
        pfInfoParcel.jTB = dia.jTB;
        pfInfoParcel.remark = dia.remark;
        if (dia.MMH != null) {
            pfInfoParcel.jTC = new SessionIdListParcel();
            Iterator<String> it2 = dia.MMH.KKJ.iterator();
            while (it2.hasNext()) {
                pfInfoParcel.jTC.jTF.add(it2.next());
            }
            Iterator<String> it3 = dia.MMH.MWk.iterator();
            while (it3.hasNext()) {
                pfInfoParcel.jTC.jTG.add(it3.next());
            }
        }
        pfInfoParcel.jTD = dia.jTD;
        pfInfoParcel.jTE = new AAOperationInfoParcel();
        pfInfoParcel.jTE.jTs = dia.MMI.jTs;
        pfInfoParcel.jTE.jTt = dia.MMI.jTt;
        pfInfoParcel.jTE.jTu = dia.MMI.jTu;
        pfInfoParcel.jTE.jTv = dia.MMI.jTv;
        pfInfoParcel.jTE.jTw = dia.MMI.jTw;
        pfInfoParcel.jTE.jTx = dia.MMI.jTx;
        pfInfoParcel.jTE.jTy = dia.MMI.jTy;
        AppMethodBeat.o(63419);
        return pfInfoParcel;
    }

    public static class PfInfoParcel implements Parcelable {
        public static final Parcelable.Creator<PfInfoParcel> CREATOR = new Parcelable.Creator<PfInfoParcel>() {
            /* class com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.PfInfoParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PfInfoParcel[] newArray(int i2) {
                return new PfInfoParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PfInfoParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(63404);
                PfInfoParcel pfInfoParcel = new PfInfoParcel(parcel);
                AppMethodBeat.o(63404);
                return pfInfoParcel;
            }
        };
        public long eht;
        public ArrayList<AALaunchItemParcel> jTA = new ArrayList<>();
        public String jTB;
        public SessionIdListParcel jTC;
        public String jTD;
        public AAOperationInfoParcel jTE;
        public String jTz;
        public String remark;

        public String toString() {
            AppMethodBeat.i(63405);
            String str = "PfInfoParcel{amount=" + this.eht + ", receiver_username='" + this.jTz + '\'' + ", payer_list=" + this.jTA + ", pic_url='" + this.jTB + '\'' + ", remark='" + this.remark + '\'' + ", sessionid_list=" + this.jTC + ", pic_sign='" + this.jTD + '\'' + ", operation_info=" + this.jTE + '}';
            AppMethodBeat.o(63405);
            return str;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(63406);
            parcel.writeLong(this.eht);
            parcel.writeString(this.jTz);
            parcel.writeTypedList(this.jTA);
            parcel.writeString(this.jTB);
            parcel.writeString(this.remark);
            parcel.writeParcelable(this.jTC, i2);
            parcel.writeString(this.jTD);
            parcel.writeParcelable(this.jTE, i2);
            AppMethodBeat.o(63406);
        }

        public PfInfoParcel() {
            AppMethodBeat.i(63407);
            AppMethodBeat.o(63407);
        }

        protected PfInfoParcel(Parcel parcel) {
            AppMethodBeat.i(63408);
            this.eht = parcel.readLong();
            this.jTz = parcel.readString();
            this.jTA = parcel.createTypedArrayList(AALaunchItemParcel.CREATOR);
            this.jTB = parcel.readString();
            this.remark = parcel.readString();
            this.jTC = (SessionIdListParcel) parcel.readParcelable(SessionIdListParcel.class.getClassLoader());
            this.jTD = parcel.readString();
            this.jTE = (AAOperationInfoParcel) parcel.readParcelable(AAOperationInfoParcel.class.getClassLoader());
            AppMethodBeat.o(63408);
        }

        static {
            AppMethodBeat.i(63409);
            AppMethodBeat.o(63409);
        }
    }

    public static class AALaunchItemParcel implements Parcelable {
        public static final Parcelable.Creator<AALaunchItemParcel> CREATOR = new Parcelable.Creator<AALaunchItemParcel>() {
            /* class com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.AALaunchItemParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AALaunchItemParcel[] newArray(int i2) {
                return new AALaunchItemParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AALaunchItemParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(63394);
                AALaunchItemParcel aALaunchItemParcel = new AALaunchItemParcel(parcel);
                AppMethodBeat.o(63394);
                return aALaunchItemParcel;
            }
        };
        public long eht;
        public String username;

        public String toString() {
            AppMethodBeat.i(63395);
            String str = "AALaunchItemParcel{username='" + this.username + '\'' + ", amount=" + this.eht + '}';
            AppMethodBeat.o(63395);
            return str;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(63396);
            parcel.writeString(this.username);
            parcel.writeLong(this.eht);
            AppMethodBeat.o(63396);
        }

        public AALaunchItemParcel() {
        }

        protected AALaunchItemParcel(Parcel parcel) {
            AppMethodBeat.i(63397);
            this.username = parcel.readString();
            this.eht = parcel.readLong();
            AppMethodBeat.o(63397);
        }

        static {
            AppMethodBeat.i(63398);
            AppMethodBeat.o(63398);
        }
    }

    public static class SessionIdListParcel implements Parcelable {
        public static final Parcelable.Creator<SessionIdListParcel> CREATOR = new Parcelable.Creator<SessionIdListParcel>() {
            /* class com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.SessionIdListParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SessionIdListParcel[] newArray(int i2) {
                return new SessionIdListParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SessionIdListParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(63410);
                SessionIdListParcel sessionIdListParcel = new SessionIdListParcel(parcel);
                AppMethodBeat.o(63410);
                return sessionIdListParcel;
            }
        };
        public ArrayList<String> jTF = new ArrayList<>();
        public ArrayList<String> jTG = new ArrayList<>();

        public String toString() {
            AppMethodBeat.i(63411);
            String str = "SessionIdListParcel{username=" + this.jTF + ", groupid=" + this.jTG + '}';
            AppMethodBeat.o(63411);
            return str;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(63412);
            parcel.writeStringList(this.jTF);
            parcel.writeStringList(this.jTG);
            AppMethodBeat.o(63412);
        }

        public SessionIdListParcel() {
            AppMethodBeat.i(63413);
            AppMethodBeat.o(63413);
        }

        protected SessionIdListParcel(Parcel parcel) {
            AppMethodBeat.i(63414);
            this.jTF = parcel.createStringArrayList();
            this.jTG = parcel.createStringArrayList();
            AppMethodBeat.o(63414);
        }

        static {
            AppMethodBeat.i(63415);
            AppMethodBeat.o(63415);
        }
    }

    public static class AAOperationInfoParcel implements Parcelable {
        public static final Parcelable.Creator<AAOperationInfoParcel> CREATOR = new Parcelable.Creator<AAOperationInfoParcel>() {
            /* class com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.AAOperationInfoParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AAOperationInfoParcel[] newArray(int i2) {
                return new AAOperationInfoParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AAOperationInfoParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(63399);
                AAOperationInfoParcel aAOperationInfoParcel = new AAOperationInfoParcel(parcel);
                AppMethodBeat.o(63399);
                return aAOperationInfoParcel;
            }
        };
        public int jTs;
        public int jTt;
        public int jTu;
        public long jTv;
        public long jTw;
        public String jTx;
        public String jTy;

        public String toString() {
            AppMethodBeat.i(63400);
            String str = "AAOperationInfoParcel{max_payer_num=" + this.jTs + ", max_receiver_num=" + this.jTt + ", max_total_num=" + this.jTu + ", max_total_amount=" + this.jTv + ", max_per_amount=" + this.jTw + ", notice='" + this.jTx + '\'' + ", notice_url='" + this.jTy + '\'' + '}';
            AppMethodBeat.o(63400);
            return str;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(63401);
            parcel.writeInt(this.jTs);
            parcel.writeInt(this.jTt);
            parcel.writeInt(this.jTu);
            parcel.writeLong(this.jTv);
            parcel.writeLong(this.jTw);
            parcel.writeString(this.jTx);
            parcel.writeString(this.jTy);
            AppMethodBeat.o(63401);
        }

        public AAOperationInfoParcel() {
        }

        protected AAOperationInfoParcel(Parcel parcel) {
            AppMethodBeat.i(63402);
            this.jTs = parcel.readInt();
            this.jTt = parcel.readInt();
            this.jTu = parcel.readInt();
            this.jTv = parcel.readLong();
            this.jTw = parcel.readLong();
            this.jTx = parcel.readString();
            this.jTy = parcel.readString();
            AppMethodBeat.o(63402);
        }

        static {
            AppMethodBeat.i(63403);
            AppMethodBeat.o(63403);
        }
    }
}
