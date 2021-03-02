package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class a extends IListener<cz> {
    public a() {
        AppMethodBeat.i(160915);
        this.__eventId = cz.class.getName().hashCode();
        AppMethodBeat.o(160915);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(cz czVar) {
        int i2;
        int i3 = -2;
        AppMethodBeat.i(106600);
        cz czVar2 = czVar;
        if (-2 == czVar2.dFZ.type) {
            long j2 = Util.getLong(czVar2.dFZ.dFN, -1);
            if (0 >= j2) {
                Log.w("MicroMsg.Fav.FavAddItemListener", "error fav info local id");
            } else {
                g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(j2);
                if (DY == null) {
                    Log.w("MicroMsg.Fav.FavAddItemListener", "error fav info null");
                } else {
                    if (Util.isNullOrNil(DY.field_favProto.remark)) {
                        h.INSTANCE.a(10873, 6);
                    } else {
                        h.INSTANCE.a(10874, 6);
                    }
                    DY.field_favProto.bhc(czVar2.dFZ.desc);
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(DY, "rowid");
                    String str = czVar2.dFZ.desc;
                    if (DY == null) {
                        Log.w("MicroMsg.Fav.FavAddItemListener", "modRemark, item info is null");
                    } else if (DY.field_id <= 0) {
                        Log.w("MicroMsg.Fav.FavAddItemListener", "modRemark favid:%d", Integer.valueOf(DY.field_id));
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        LinkedList linkedList = new LinkedList();
                        cps cps = new cps();
                        cps.MvI = 4;
                        cps.MvJ = 0;
                        linkedList.add(cps);
                        LinkedList linkedList2 = new LinkedList();
                        cpv cpv = new cpv();
                        cpv.xMo = "favitem.remark";
                        cpv.Cyk = str;
                        linkedList2.add(cpv);
                        cpv cpv2 = new cpv();
                        cpv2.xMo = "favitem.remark";
                        cpv2.MvO = "time";
                        cpv2.Cyk = String.valueOf(currentTimeMillis);
                        linkedList2.add(cpv2);
                        com.tencent.mm.kernel.g.azz().a(new am(DY.field_id, linkedList, linkedList2), 0);
                    }
                }
            }
        } else {
            cz.b bVar = czVar2.dGa;
            if (czVar2 == null || czVar2.dFZ == null) {
                i3 = -1;
            } else {
                if (czVar2.dFZ.dGb == null) {
                    Log.w("MicroMsg.Fav.FavAddService", "handleEvent error, event is null");
                    if (czVar2.dFZ.dGe == 0) {
                        czVar2.dFZ.dGe = R.string.c_2;
                    }
                    i2 = czVar2.dFZ.dGe;
                } else {
                    i2 = 0;
                }
                if (czVar2.dFZ.activity == null && czVar2.dFZ.fragment == null) {
                    Log.i("MicroMsg.Fav.FavAddService", "handleEvent context = null && frament = null");
                }
                if (czVar2.dFZ.dGe > 0) {
                    i3 = czVar2.dFZ.dGe;
                } else {
                    if (b.HS(czVar2.dFZ.type)) {
                        hb hbVar = new hb();
                        hbVar.dLm.type = 36;
                        EventCenter.instance.publish(hbVar);
                        if (hbVar.dLn.ret != 1) {
                            i3 = czVar2.dFZ.dGe;
                            czVar2.dFZ.dGg = new DialogInterface.OnClickListener(czVar2) {
                                /* class com.tencent.mm.plugin.fav.ui.b.AnonymousClass1 */
                                final /* synthetic */ cz tcU;

                                {
                                    this.tcU = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(106601);
                                    if (i2 == -2) {
                                        b.b(this.tcU);
                                    }
                                    AppMethodBeat.o(106601);
                                }
                            };
                        }
                    } else {
                        i3 = i2;
                    }
                    if (i3 == 0 && !b.a(czVar2)) {
                        i3 = -10;
                    }
                }
                if (((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(225281, (Object) 0)).intValue() != 1) {
                    Log.i("MicroMsg.Fav.FavAddService", "try show intro ui");
                    b.b(czVar2.dFZ.activity, ".ui.FavTipsUI", new Intent());
                    com.tencent.mm.kernel.g.aAh().azQ().set(225281, (Object) 1);
                }
                e.a(czVar2.dFZ.type, i3, czVar2.dFZ.activity, czVar2.dFZ.fragment, czVar2.dFZ.dGh, czVar2.dFZ.dGg, null, czVar2.dFZ.dGi);
                Log.i("MicroMsg.Fav.FavAddService", "err Type = %d", Integer.valueOf(i3));
                if (i3 == -9 || i3 == 0) {
                    i3 = b.b(czVar2);
                }
            }
            bVar.ret = i3;
        }
        AppMethodBeat.o(106600);
        return false;
    }
}
