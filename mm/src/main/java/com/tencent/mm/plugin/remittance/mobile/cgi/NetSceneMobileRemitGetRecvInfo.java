package com.tencent.mm.plugin.remittance.mobile.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.ejz;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class NetSceneMobileRemitGetRecvInfo extends a {
    public String ClX;
    private eka ClY;
    private final String TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo";
    public String pSm;

    public NetSceneMobileRemitGetRecvInfo(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(67647);
        d.a aVar = new d.a();
        aVar.iLN = new ejz();
        aVar.iLO = new eka();
        aVar.funcId = 1495;
        aVar.uri = "/cgi-bin/mmpay-bin/transferphonegetrcvr";
        this.rr = aVar.aXF();
        ejz ejz = (ejz) this.rr.iLK.iLR;
        ejz.pSm = str;
        ejz.Njh = str2;
        ejz.Njj = str3;
        ejz.MRS = i2;
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo", "do scene NetSceneMobileRemitGetRecvInfo phone:%s rcvr_id:%s input_type:%s", str, str2, Integer.valueOf(i2));
        this.ClX = str2;
        this.pSm = str;
        AppMethodBeat.o(67647);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1495;
    }

    public final eka eNn() {
        if (this.ClY == null) {
            return null;
        }
        return this.ClY;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67648);
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ClY = (eka) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetRecvInfo", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.ClY.pTZ), this.ClY.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67648);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        eka eka = (eka) ((d) sVar).iLL.iLR;
        this.RtZ = eka.pTZ;
        this.Rua = eka.pUa;
    }

    public static class DelayOptionParcel implements Parcelable {
        public static final Parcelable.Creator<DelayOptionParcel> CREATOR = new Parcelable.Creator<DelayOptionParcel>() {
            /* class com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo.DelayOptionParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ DelayOptionParcel[] newArray(int i2) {
                return new DelayOptionParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DelayOptionParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(67643);
                DelayOptionParcel delayOptionParcel = new DelayOptionParcel(parcel);
                AppMethodBeat.o(67643);
                return delayOptionParcel;
            }
        };
        public String ClZ;
        public int code;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(67644);
            parcel.writeString(this.ClZ);
            parcel.writeInt(this.code);
            AppMethodBeat.o(67644);
        }

        public DelayOptionParcel() {
        }

        protected DelayOptionParcel(agg agg) {
            this.ClZ = agg.ClZ;
            this.code = agg.code;
        }

        protected DelayOptionParcel(Parcel parcel) {
            AppMethodBeat.i(67645);
            this.ClZ = parcel.readString();
            this.code = parcel.readInt();
            AppMethodBeat.o(67645);
        }

        static {
            AppMethodBeat.i(67646);
            AppMethodBeat.o(67646);
        }
    }

    public static ArrayList<DelayOptionParcel> bm(LinkedList<agg> linkedList) {
        AppMethodBeat.i(67649);
        if (linkedList == null) {
            AppMethodBeat.o(67649);
            return null;
        }
        ArrayList<DelayOptionParcel> arrayList = new ArrayList<>();
        Iterator<agg> it = linkedList.iterator();
        while (it.hasNext()) {
            arrayList.add(new DelayOptionParcel(it.next()));
        }
        AppMethodBeat.o(67649);
        return arrayList;
    }

    public static ArrayList<agg> gq(List<DelayOptionParcel> list) {
        AppMethodBeat.i(67650);
        if (list == null) {
            AppMethodBeat.o(67650);
            return null;
        }
        ArrayList<agg> arrayList = new ArrayList<>();
        for (DelayOptionParcel delayOptionParcel : list) {
            agg agg = new agg();
            agg.ClZ = delayOptionParcel.ClZ;
            agg.code = delayOptionParcel.code;
            arrayList.add(agg);
        }
        AppMethodBeat.o(67650);
        return arrayList;
    }
}
