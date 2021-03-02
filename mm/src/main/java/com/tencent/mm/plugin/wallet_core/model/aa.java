package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.d.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.Date;

public final class aa extends IListener<zt> implements i {
    private zt Ibh;
    private String mScene = null;

    public aa() {
        AppMethodBeat.i(160876);
        this.__eventId = zt.class.getName().hashCode();
        AppMethodBeat.o(160876);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(zt ztVar) {
        AppMethodBeat.i(70421);
        this.Ibh = ztVar;
        this.mScene = this.Ibh.efM.scene;
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_WALLET_BULLETIN_GET_TIME_LONG, (Object) 0L)).longValue();
        long time = new Date().getTime();
        long longValue2 = ((Long) g.aAh().azQ().get(ar.a.USERINFO_WALLET_BULLETIN_UPDATE_INTERVAL_LONG, (Object) 600000L)).longValue();
        if (longValue2 <= 0) {
            longValue2 = 600000;
        }
        if (time - longValue > longValue2 || Util.isNullOrNil(this.mScene)) {
            Log.i("MicroMsg.WalletGetBulletinEventListener", "data is out of date,do NetSceneGetBannerInfo for update");
            com.tencent.mm.plugin.wallet_core.c.g gVar = new com.tencent.mm.plugin.wallet_core.c.g();
            g.aAi();
            t tVar = g.aAg().hqi;
            tVar.a(385, this);
            tVar.a(gVar, 0);
        } else if (!Util.isNullOrNil(this.mScene)) {
            Log.i("MicroMsg.WalletGetBulletinEventListener", "get bulletin data from db");
            fQS();
        } else {
            Log.e("MicroMsg.WalletGetBulletinEventListener", "mScene is null");
            this.Ibh.callback.run();
            this.Ibh = null;
        }
        AppMethodBeat.o(70421);
        return true;
    }

    private void fQS() {
        AppMethodBeat.i(70419);
        e fQM = t.fQM();
        y yVar = new y();
        yVar.field_bulletin_scene = this.mScene;
        if (!fQM.get(yVar, new String[0])) {
            Log.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
        } else {
            this.Ibh.efN.efO = yVar.field_bulletin_scene;
            this.Ibh.efN.content = yVar.field_bulletin_content;
            this.Ibh.efN.url = yVar.field_bulletin_url;
        }
        this.Ibh.callback.run();
        this.Ibh = null;
        AppMethodBeat.o(70419);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(70420);
        Log.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + i2 + ";errCode=" + i3);
        g.aAi();
        g.aAg().hqi.b(385, this);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_WALLET_BULLETIN_GET_TIME_LONG, Long.valueOf(new Date().getTime()));
        fQS();
        AppMethodBeat.o(70420);
    }
}
