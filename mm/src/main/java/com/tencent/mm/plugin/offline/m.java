package com.tencent.mm.plugin.offline;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aan;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import java.io.ByteArrayOutputStream;

public final class m implements s.a {
    IListener yYb = new IListener<aan>() {
        /* class com.tencent.mm.plugin.offline.m.AnonymousClass1 */

        {
            AppMethodBeat.i(160817);
            this.__eventId = aan.class.getName().hashCode();
            AppMethodBeat.o(160817);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aan aan) {
            AppMethodBeat.i(66275);
            aan aan2 = aan;
            if (aan2 instanceof aan) {
                switch (aan2.ehq.action) {
                    case 3:
                        if (!((b) g.af(b.class)).fUF()) {
                            if (!t.fQI().fRp()) {
                                if (!t.fQI().fRm()) {
                                    if (!t.fQI().fRk() || !a.eAj()) {
                                        if (!t.fQI().fRk() || a.eAj()) {
                                            if (t.fQI().fRl()) {
                                                aan2.ehr.ehs = 3;
                                                break;
                                            }
                                        } else {
                                            aan2.ehr.ehs = 4;
                                            break;
                                        }
                                    } else {
                                        k.ezn();
                                        e ezp = k.ezp();
                                        Log.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", 9, 0, Util.getStack().toString());
                                        String B = ezp.B(9, 0, "");
                                        Bitmap b2 = com.tencent.mm.by.a.a.b(MMApplicationContext.getContext(), B, 5, 0);
                                        Bitmap b3 = com.tencent.mm.by.a.a.b(MMApplicationContext.getContext(), B, 12, 3);
                                        aan2.ehr.ehs = 1;
                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        b2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                        aan2.ehr.ehw = byteArrayOutputStream.toByteArray();
                                        byteArrayOutputStream.reset();
                                        b3.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                        aan2.ehr.ehx = byteArrayOutputStream.toByteArray();
                                        aan2.ehr.ehy = f.bpw(B);
                                        Bankcard eAl = a.eAl();
                                        if (eAl == null) {
                                            Log.i("MicroMsg.Wear.WearOfflineLogic", "get payway fail");
                                            break;
                                        } else {
                                            aan2.ehr.ehz = MMApplicationContext.getContext().getString(R.string.iun, eAl.field_desc);
                                            Log.i("MicroMsg.Wear.WearOfflineLogic", "payway %s", aan2.ehr.ehz);
                                            break;
                                        }
                                    }
                                } else {
                                    aan2.ehr.ehs = 3;
                                    break;
                                }
                            } else {
                                aan2.ehr.ehs = 2;
                                break;
                            }
                        } else {
                            aan2.ehr.ehs = 5;
                            break;
                        }
                        break;
                }
            }
            AppMethodBeat.o(66275);
            return false;
        }
    };

    public m() {
        AppMethodBeat.i(66276);
        EventCenter.instance.addListener(this.yYb);
        k.ezn();
        k.ezo().a(this);
        AppMethodBeat.o(66276);
    }

    private static void bO(int i2, String str) {
        AppMethodBeat.i(66277);
        aan aan = new aan();
        aan.ehq.ehs = i2;
        aan.ehq.action = 4;
        aan.ehq.content = str;
        EventCenter.instance.publish(aan);
        AppMethodBeat.o(66277);
    }

    @Override // com.tencent.mm.plugin.offline.a.s.a
    public final boolean a(s.c cVar) {
        AppMethodBeat.i(66278);
        if (cVar.AKh == 6) {
            s.f fVar = (s.f) cVar;
            if (fVar.AKp.HZd == null || fVar.AKp.HZd.size() <= 0) {
                bO(9, MMApplicationContext.getContext().getString(R.string.iu9));
            } else {
                Orders.Commodity commodity = fVar.AKp.HZd.get(0);
                bO(0, MMApplicationContext.getContext().getString(R.string.iua, f.d(commodity.qwJ, commodity.AOl)));
            }
        } else if (cVar.AKh == 8) {
            bO(6, MMApplicationContext.getContext().getString(R.string.iu9));
        } else if (cVar.AKh == 5) {
            bO(7, Util.nullAs(((s.e) cVar).AKl, ""));
        } else if (cVar.AKh == 4) {
            bO(8, MMApplicationContext.getContext().getString(R.string.iu_));
        }
        AppMethodBeat.o(66278);
        return false;
    }
}
