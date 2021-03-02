package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.a.wo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class FavUrlTask extends MainProcessTask {
    public static final Parcelable.Creator<FavUrlTask> CREATOR = new Parcelable.Creator<FavUrlTask>() {
        /* class com.tencent.mm.plugin.webview.luggage.FavUrlTask.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FavUrlTask[] newArray(int i2) {
            return new FavUrlTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FavUrlTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(78187);
            FavUrlTask favUrlTask = new FavUrlTask(parcel, (byte) 0);
            AppMethodBeat.o(78187);
            return favUrlTask;
        }
    };
    public boolean ISL;
    public boolean ISM;
    public int actionType;
    public Bundle dQL;
    public boolean result;
    public int ret;
    public int type;

    /* synthetic */ FavUrlTask(Parcel parcel, byte b2) {
        this(parcel);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        boolean z;
        AppMethodBeat.i(78188);
        switch (this.actionType) {
            case 1:
                if (this.dQL != null) {
                    long j2 = this.dQL.getLong("msg_id", Long.MIN_VALUE);
                    String string = this.dQL.getString("sns_local_id");
                    int i2 = this.dQL.getInt("news_svr_id", 0);
                    String string2 = this.dQL.getString("news_svr_tweetid");
                    cz czVar = new cz();
                    if (Long.MIN_VALUE != j2) {
                        czVar.dFZ.dGd = this.dQL.getInt("message_index", 0);
                        z = ((ad) g.af(ad.class)).a(czVar, j2);
                    } else if (!Util.isNullOrNil(string)) {
                        wo woVar = new wo();
                        woVar.ecC.ecF = string;
                        woVar.ecC.ecG = czVar;
                        woVar.ecC.url = this.dQL.getString("rawUrl");
                        EventCenter.instance.publish(woVar);
                        z = woVar.ecD.dFE;
                    } else if (i2 != 0) {
                        qn qnVar = new qn();
                        qnVar.dWV.opType = 3;
                        qnVar.dWV.dWX = czVar;
                        qnVar.dWV.dWY = i2;
                        qnVar.dWV.dWZ = string2;
                        EventCenter.instance.publish(qnVar);
                        z = qnVar.dWW.dFE;
                    } else {
                        this.ISL = true;
                        AppMethodBeat.o(78188);
                        return;
                    }
                    if (z) {
                        String nullAsNil = Util.nullAsNil(this.dQL.getString("prePublishId"));
                        String JX = com.tencent.mm.model.ad.JX(nullAsNil);
                        ad.b G = com.tencent.mm.model.ad.aVe().G(JX, true);
                        G.l("sendAppMsgScene", 2);
                        G.l("preChatName", this.dQL.getString("preChatName"));
                        G.l("preMsgIndex", Integer.valueOf(this.dQL.getInt("preMsgIndex")));
                        G.l("prePublishId", nullAsNil);
                        G.l("preUsername", this.dQL.getString("preUsername"));
                        G.l("getA8KeyScene", this.dQL.getString("getA8KeyScene"));
                        G.l("referUrl", this.dQL.getString("referUrl"));
                        Bundle bundle = this.dQL.getBundle("jsapiargs");
                        if (bundle != null) {
                            G.l("adExtStr", bundle.getString("key_snsad_statextstr"));
                        }
                        czVar.dFZ.sessionId = JX;
                        EventCenter.instance.publish(czVar);
                    } else {
                        if (czVar.dFZ.dGe == 0) {
                            czVar.dFZ.dGe = R.string.c__;
                        }
                        EventCenter.instance.publish(czVar);
                    }
                    this.ret = czVar.dGa.ret;
                }
                AppMethodBeat.o(78188);
                return;
            case 2:
                hb hbVar = new hb();
                hbVar.dLm.type = 35;
                EventCenter.instance.publish(hbVar);
                AppMethodBeat.o(78188);
                return;
            case 3:
                this.ISM = c.aZU("favorite");
                AppMethodBeat.o(78188);
                return;
            case 4:
                cu cuVar = new cu();
                cuVar.dFU.dFW = this.dQL.getLong("fav_local_id", -1);
                EventCenter.instance.publish(cuVar);
                Log.i("MicroMsg.FavUrlTask", "do del fav web url, local id %d, result %B", Long.valueOf(cuVar.dFU.dFW), Boolean.valueOf(cuVar.dFV.dFE));
                this.result = cuVar.dFV.dFE;
                break;
        }
        AppMethodBeat.o(78188);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(78189);
        this.actionType = parcel.readInt();
        this.dQL = parcel.readBundle();
        this.ISL = parcel.readByte() == 1;
        if (parcel.readByte() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.result = z;
        this.ret = parcel.readInt();
        this.type = parcel.readInt();
        if (parcel.readByte() != 1) {
            z2 = false;
        }
        this.ISM = z2;
        AppMethodBeat.o(78189);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4 = 1;
        AppMethodBeat.i(78190);
        parcel.writeInt(this.actionType);
        parcel.writeBundle(this.dQL);
        parcel.writeByte((byte) (this.ISL ? 1 : 0));
        if (this.result) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(this.ret);
        parcel.writeInt(this.type);
        if (!this.ISM) {
            i4 = 0;
        }
        parcel.writeByte((byte) i4);
        AppMethodBeat.o(78190);
    }

    public FavUrlTask() {
    }

    private FavUrlTask(Parcel parcel) {
        AppMethodBeat.i(78191);
        f(parcel);
        AppMethodBeat.o(78191);
    }

    static {
        AppMethodBeat.i(78192);
        AppMethodBeat.o(78192);
    }
}
