package com.tencent.mm.plugin.remittance.mobile.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cbp;
import com.tencent.mm.protocal.protobuf.ejx;
import com.tencent.mm.protocal.protobuf.ejy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class NetSceneMobileRemitGetRecord extends a {
    private ejy ClT;
    private final String TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord";

    public NetSceneMobileRemitGetRecord(String str, String str2) {
        AppMethodBeat.i(67639);
        d.a aVar = new d.a();
        aVar.iLN = new ejx();
        aVar.iLO = new ejy();
        aVar.funcId = 2993;
        aVar.uri = "/cgi-bin/mmpay-bin/transferphonegethisrcvrs";
        this.rr = aVar.aXF();
        ejx ejx = (ejx) this.rr.iLK.iLR;
        ejx.Nji = str;
        ejx.Njj = str2;
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "do scene NetSceneMobileRemitGetRecord last_id:%s homepage_ext:%s", str, str2);
        AppMethodBeat.o(67639);
    }

    public final ejy eNm() {
        if (this.ClT == null) {
            return null;
        }
        return this.ClT;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2993;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67640);
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ClT = (ejy) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecord", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.ClT.pTZ), this.ClT.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67640);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        ejy ejy = (ejy) ((d) sVar).iLL.iLR;
        this.RtZ = ejy.pTZ;
        this.Rua = ejy.pUa;
    }

    public static class HisRcvrParcel implements Parcelable {
        public static final Parcelable.Creator<HisRcvrParcel> CREATOR = new Parcelable.Creator<HisRcvrParcel>() {
            /* class com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord.HisRcvrParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ HisRcvrParcel[] newArray(int i2) {
                return new HisRcvrParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ HisRcvrParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(67635);
                HisRcvrParcel hisRcvrParcel = new HisRcvrParcel(parcel);
                AppMethodBeat.o(67635);
                return hisRcvrParcel;
            }
        };
        public String ClU;
        public String ClV;
        public int ClW;
        public String id;
        public String pSm;
        public long timestamp;

        public HisRcvrParcel() {
        }

        protected HisRcvrParcel(cbp cbp) {
            this.id = cbp.id;
            this.ClU = cbp.ClU;
            this.ClV = cbp.ClV;
            this.pSm = cbp.pSm;
            this.timestamp = cbp.timestamp;
            this.ClW = cbp.ClW;
        }

        protected HisRcvrParcel(Parcel parcel) {
            AppMethodBeat.i(67636);
            this.id = parcel.readString();
            this.ClU = parcel.readString();
            this.ClV = parcel.readString();
            this.pSm = parcel.readString();
            this.timestamp = parcel.readLong();
            this.ClW = parcel.readInt();
            AppMethodBeat.o(67636);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(67637);
            parcel.writeString(this.id);
            parcel.writeString(this.ClU);
            parcel.writeString(this.ClV);
            parcel.writeString(this.pSm);
            parcel.writeLong(this.timestamp);
            parcel.writeInt(this.ClW);
            AppMethodBeat.o(67637);
        }

        static {
            AppMethodBeat.i(67638);
            AppMethodBeat.o(67638);
        }
    }

    public static ArrayList<HisRcvrParcel> bl(LinkedList<cbp> linkedList) {
        AppMethodBeat.i(67641);
        if (linkedList == null) {
            AppMethodBeat.o(67641);
            return null;
        }
        ArrayList<HisRcvrParcel> arrayList = new ArrayList<>();
        Iterator<cbp> it = linkedList.iterator();
        while (it.hasNext()) {
            arrayList.add(new HisRcvrParcel(it.next()));
        }
        AppMethodBeat.o(67641);
        return arrayList;
    }

    public static ArrayList<cbp> gp(List<HisRcvrParcel> list) {
        AppMethodBeat.i(67642);
        if (list == null) {
            AppMethodBeat.o(67642);
            return null;
        }
        ArrayList<cbp> arrayList = new ArrayList<>();
        for (HisRcvrParcel hisRcvrParcel : list) {
            cbp cbp = new cbp();
            cbp.id = hisRcvrParcel.id;
            cbp.ClU = hisRcvrParcel.ClU;
            cbp.ClV = hisRcvrParcel.ClV;
            cbp.pSm = hisRcvrParcel.pSm;
            cbp.timestamp = hisRcvrParcel.timestamp;
            cbp.ClW = hisRcvrParcel.ClW;
            arrayList.add(cbp);
        }
        AppMethodBeat.o(67642);
        return arrayList;
    }
}
