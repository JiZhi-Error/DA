package com.tencent.mm.plugin.luckymoney.model;

import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aan;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Iterator;

public final class bj implements i {
    boolean yXX;
    public bd yXY;
    public ay yXZ;
    private ao yYa;
    public IListener yYb = new IListener<aan>() {
        /* class com.tencent.mm.plugin.luckymoney.model.bj.AnonymousClass1 */

        {
            AppMethodBeat.i(160803);
            this.__eventId = aan.class.getName().hashCode();
            AppMethodBeat.o(160803);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aan aan) {
            AppMethodBeat.i(65314);
            boolean a2 = a(aan);
            AppMethodBeat.o(65314);
            return a2;
        }

        private boolean a(aan aan) {
            k.b bVar;
            AppMethodBeat.i(65313);
            if (aan instanceof aan) {
                switch (aan.ehq.action) {
                    case 1:
                        bj bjVar = bj.this;
                        long j2 = aan.ehq.dFm;
                        if (!bjVar.yXX) {
                            bjVar.yXX = true;
                            ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
                            String str = Hb.field_content;
                            if (str != null) {
                                bVar = k.b.aD(str, Hb.field_reserved);
                            } else {
                                bVar = null;
                            }
                            if (bVar != null) {
                                String nullAsNil = Util.nullAsNil(bVar.iyr);
                                Uri parse = Uri.parse(nullAsNil);
                                String queryParameter = parse.getQueryParameter("sendid");
                                int i2 = Util.getInt(parse.getQueryParameter("channelid"), 1);
                                if (bjVar.yXY != null) {
                                    g.aAi();
                                    g.aAg().hqi.a(bjVar.yXY);
                                    bjVar.yXY = null;
                                }
                                g.aAi();
                                g.aAg().hqi.a(1581, bjVar);
                                bjVar.yXY = new bd(i2, queryParameter, nullAsNil, 3, "v1.0", "");
                                bjVar.yXY.talker = Hb.field_talker;
                                bjVar.yXY.msgId = j2;
                                g.aAi();
                                g.aAg().hqi.a(bjVar.yXY, 0);
                                break;
                            }
                        }
                        break;
                }
            }
            AppMethodBeat.o(65313);
            return false;
        }
    };

    public bj() {
        AppMethodBeat.i(65315);
        EventCenter.instance.addListener(this.yYb);
        AppMethodBeat.o(65315);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(65316);
        g.aAi();
        g.aAg().hqi.b(1581, this);
        g.aAi();
        g.aAg().hqi.b(1685, this);
        g.aAi();
        g.aAg().hqi.b(1585, this);
        if (qVar instanceof bd) {
            bd bdVar = (bd) qVar;
            if (i2 != 0 || i3 != 0) {
                this.yXX = false;
                GZ(bdVar.msgId);
                AppMethodBeat.o(65316);
            } else if (bdVar.egZ == 4) {
                if (this.yYa != null) {
                    g.aAi();
                    g.aAg().hqi.a(this.yYa);
                    this.yYa = null;
                }
                g.aAi();
                g.aAg().hqi.a(1585, this);
                this.yYa = new ao(bdVar.yQE, 11, 0, bdVar.egX, "v1.0");
                this.yYa.talker = bdVar.talker;
                this.yYa.msgId = bdVar.msgId;
                g.aAi();
                g.aAg().hqi.a(this.yYa, 0);
                Log.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
                AppMethodBeat.o(65316);
            } else if (bdVar.eha == 1 || bdVar.egZ == 5 || bdVar.egZ == 1) {
                this.yXX = false;
                Log.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
                GZ(bdVar.msgId);
                AppMethodBeat.o(65316);
            } else {
                if (this.yXZ != null) {
                    g.aAi();
                    g.aAg().hqi.a(this.yXZ);
                    this.yXZ = null;
                }
                g.aAi();
                g.aAg().hqi.a(1685, this);
                this.yXZ = new ay(bdVar.msgType, bdVar.channelId, bdVar.yQE, bdVar.egX, af.efj(), z.aUa(), bdVar.talker, "v1.0", bdVar.yXR);
                this.yXZ.msgId = bdVar.msgId;
                g.aAi();
                g.aAg().hqi.a(this.yXZ, 0);
                Log.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
                AppMethodBeat.o(65316);
            }
        } else if (qVar instanceof ay) {
            this.yXX = false;
            ay ayVar = (ay) qVar;
            if (i2 == 0 && i3 == 0) {
                q qVar2 = ayVar.yWT;
                if (qVar2.eha == 2) {
                    a(qVar2, ayVar.msgId, ayVar.talker);
                    AppMethodBeat.o(65316);
                    return;
                }
                GZ(ayVar.msgId);
                AppMethodBeat.o(65316);
                return;
            }
            GZ(ayVar.msgId);
            AppMethodBeat.o(65316);
        } else {
            if (qVar instanceof ao) {
                this.yXX = false;
                ao aoVar = (ao) qVar;
                if (i2 == 0 && i3 == 0) {
                    a(aoVar.yWT, aoVar.msgId, aoVar.talker);
                } else {
                    GZ(aoVar.msgId);
                    AppMethodBeat.o(65316);
                    return;
                }
            }
            AppMethodBeat.o(65316);
        }
    }

    private static void GZ(long j2) {
        AppMethodBeat.i(65317);
        aan aan = new aan();
        aan.ehq.action = 2;
        aan.ehr.dFm = j2;
        aan.ehr.eht = 0;
        aan.ehr.ehu = "";
        EventCenter.instance.asyncPublish(aan, Looper.getMainLooper());
        AppMethodBeat.o(65317);
    }

    private static void a(q qVar, long j2, String str) {
        AppMethodBeat.i(65318);
        aan aan = new aan();
        aan.ehq.action = 2;
        aan.ehr.dFm = j2;
        aan.ehr.eht = qVar.eht;
        aan.ehr.ehu = qVar.yVo;
        aan.ehr.ehv = new ArrayList();
        if (ab.Eq(str)) {
            Iterator<ad> it = qVar.yVw.iterator();
            while (it.hasNext()) {
                ad next = it.next();
                aan.ehr.ehv.add(p.aYD().Mj(next.yWE) + "=" + next.yWD + "=" + next.yWo);
            }
        }
        EventCenter.instance.asyncPublish(aan, Looper.getMainLooper());
        AppMethodBeat.o(65318);
    }
}
