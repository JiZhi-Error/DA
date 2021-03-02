package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.al.ag;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.brandservice.a.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.o;

public final class al implements o.g {
    private Context mContext;
    b pxE;
    private long pxY;
    private boolean pxZ = false;

    public al(b bVar, Context context) {
        this.pxE = bVar;
        this.mContext = context;
    }

    @Override // com.tencent.mm.ui.base.o.g
    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
        String string;
        AppMethodBeat.i(6036);
        if (this.pxE.pqY == null) {
            Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "onMMMenuItemSelected mInfo == null");
            AppMethodBeat.o(6036);
            return;
        }
        final z zVar = this.pxE.pqY;
        this.pxY = Util.nowSecond();
        switch (menuItem.getItemId()) {
            case 1:
                as Kn = ((l) g.af(l.class)).aSN().Kn(zVar.field_talker);
                if (Kn == null) {
                    Log.e("MicroMsg.BizTimeLineMMMenuItemListener", "changed biz stick status failed, contact is null, talker = " + zVar.field_talker);
                    AppMethodBeat.o(6036);
                    return;
                } else if (Kn.arE()) {
                    h.INSTANCE.a(13307, Kn.field_username, 1, 2, 3);
                    ab.F(zVar.field_talker, true);
                    com.tencent.mm.ui.base.h.cD(this.mContext, this.mContext.getString(R.string.aj0));
                    this.pxE.pqZ.a(zVar, false);
                    AppMethodBeat.o(6036);
                    return;
                } else {
                    h.INSTANCE.a(13307, Kn.field_username, 1, 1, 3);
                    ab.E(zVar.field_talker, true);
                    com.tencent.mm.ui.base.h.cD(this.mContext, this.mContext.getString(R.string.ais));
                    this.pxE.pqZ.a(zVar, true);
                    AppMethodBeat.o(6036);
                    return;
                }
            case 2:
                as Kn2 = ((l) g.af(l.class)).aSN().Kn(zVar.field_talker);
                ((a) g.af(a.class)).b(ag.bah().MT(zVar.field_talker), (Activity) this.mContext, Kn2);
                this.pxE.pqZ.f(zVar, 2);
                AppMethodBeat.o(6036);
                return;
            case 3:
                Intent intent = new Intent();
                intent.putExtra("Contact_User", zVar.field_talker);
                intent.putExtra("Contact_Scene", 90);
                c.b(this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                this.pxE.pqZ.f(zVar, 1);
                AppMethodBeat.o(6036);
                return;
            case 4:
                if (this.pxZ) {
                    ((a) g.af(a.class)).a(this.pxE.pra, this.mContext, zVar.field_content, zVar.field_talker, zVar.field_msgId, zVar.field_msgSvrId);
                    AppMethodBeat.o(6036);
                    return;
                }
                String a2 = m.a(this.mContext, this.pxE.pra, zVar.field_content, zVar.field_talker, zVar.field_msgId);
                if (!Util.isNullOrNil(a2)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Retr_Msg_content", a2);
                    intent2.putExtra("Retr_Msg_Type", 2);
                    intent2.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.pxE.pra);
                    intent2.putExtra("Retr_Msg_Id", zVar.field_msgId);
                    intent2.putExtra("Retr_MsgFromScene", 1);
                    String str = zVar.field_talker;
                    String JX = ad.JX(new StringBuilder().append(zVar.field_msgSvrId).toString());
                    intent2.putExtra("reportSessionId", JX);
                    ad.b G = ad.aVe().G(JX, true);
                    G.l("prePublishId", "msg_" + zVar.field_msgSvrId);
                    G.l("preUsername", str);
                    G.l("preChatName", str);
                    G.l("preMsgIndex", Integer.valueOf(this.pxE.pra));
                    G.l("sendAppMsgScene", 1);
                    c.f(this.mContext, ".ui.transmit.MsgRetransmitUI", intent2);
                    AppMethodBeat.o(6036);
                    return;
                }
                break;
            case 5:
                ca Hb = ((l) g.af(l.class)).eiy().Hb(zVar.field_msgId);
                if (Hb.field_msgId == 0) {
                    Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
                    AppMethodBeat.o(6036);
                    return;
                }
                ((a) g.af(a.class)).a(this.pxY, this.pxE.pra, this.mContext, (Activity) this.mContext, Hb);
                AppMethodBeat.o(6036);
                return;
            case 6:
                ca Hb2 = ((l) g.af(l.class)).eiy().Hb(zVar.field_msgId);
                if (Hb2.field_msgId == 0) {
                    Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
                    AppMethodBeat.o(6036);
                    return;
                }
                ((a) g.af(a.class)).a(Hb2, this.mContext);
                AppMethodBeat.o(6036);
                return;
            case 7:
                ca Hb3 = ((l) g.af(l.class)).eiy().Hb(zVar.field_msgId);
                if (Hb3.field_msgId == 0) {
                    Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
                    AppMethodBeat.o(6036);
                    return;
                }
                ((a) g.af(a.class)).a(Hb3, (Activity) this.mContext);
                AppMethodBeat.o(6036);
                return;
            case 8:
                Intent intent3 = new Intent();
                intent3.putExtra("Retr_Msg_content", zVar.field_content);
                intent3.putExtra("Retr_Msg_Type", 4);
                c.f(this.mContext, ".ui.transmit.MsgRetransmitUI", intent3);
                AppMethodBeat.o(6036);
                return;
            case 9:
                ClipboardHelper.setText(MMApplicationContext.getContext(), zVar.field_content);
                com.tencent.mm.ui.base.h.cD(this.mContext, this.mContext.getString(R.string.ta));
                com.tencent.mm.plugin.secinforeport.a.a aVar = com.tencent.mm.plugin.secinforeport.a.a.INSTANCE;
                com.tencent.mm.plugin.secinforeport.a.a.q(1, new StringBuilder().append(zVar.field_msgSvrId).toString(), Util.getUTF8ByteLength(zVar.field_content));
                break;
            case 10:
                if (zVar.gAu()) {
                    string = this.mContext.getString(R.string.aiz);
                } else {
                    string = this.mContext.getString(R.string.aiy);
                }
                com.tencent.mm.ui.base.h.a(this.mContext, string, "", this.mContext.getString(R.string.x_), this.mContext.getString(R.string.sz), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.al.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        pi piVar;
                        AppMethodBeat.i(6035);
                        if (zVar.gAu()) {
                            ag.ban().MX(zVar.field_msgId);
                            l.a(3, zVar.gAD(), null, zVar);
                        } else {
                            bp.Ad(zVar.field_msgId);
                        }
                        f fVar = al.this.pxE.pqZ;
                        z zVar = zVar;
                        if (zVar.gAu()) {
                            ege gAD = zVar.gAD();
                            if (gAD != null && gAD.style == 101) {
                                ale ale = gAD.Nga;
                                pi piVar2 = ale.KUf.get(0).KWy.get(0);
                                String str = piVar2.KSj;
                                int i3 = 0;
                                long j2 = 0;
                                if (!Util.isNullOrNil(str)) {
                                    try {
                                        Uri parse = Uri.parse(str);
                                        i3 = Util.getInt(parse.getQueryParameter("idx"), 0);
                                        j2 = Util.getLong(parse.getQueryParameter("mid"), 0);
                                    } catch (Exception e2) {
                                    }
                                }
                                fVar.a(ale.KUf.get(0).UserName, j2, i3, 3, gAD.MOC, "", 0, ale.KUo, gAD.event, ale.KUk, piVar2.KWv, gAD.style, piVar2.KWw);
                            } else if (gAD != null && (gAD.style == 102 || gAD.style == 103)) {
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= gAD.Nga.KUf.size()) {
                                        break;
                                    }
                                    ale ale2 = gAD.Nga;
                                    if (ale2.KUf.get(i4).KHa != 0 || (piVar = ale2.KUf.get(i4).KWy.get(0)) == null) {
                                        i4++;
                                    } else {
                                        String str2 = piVar.KSj;
                                        int i5 = 0;
                                        long j3 = 0;
                                        if (!Util.isNullOrNil(str2)) {
                                            try {
                                                Uri parse2 = Uri.parse(str2);
                                                i5 = Util.getInt(parse2.getQueryParameter("idx"), 0);
                                                j3 = Util.getLong(parse2.getQueryParameter("mid"), 0);
                                            } catch (Exception e3) {
                                            }
                                        }
                                        fVar.a(ale2.KUf.get(i4).UserName, j3, i5, 3, gAD.MOC, "", 0, ale2.KUo, gAD.event, ale2.KUk, piVar.KWv, gAD.style, piVar.KWw);
                                    }
                                }
                            }
                        } else {
                            fVar.f(zVar, 3);
                        }
                        al.this.pxE.prb.p(zVar);
                        AppMethodBeat.o(6035);
                    }
                }, (DialogInterface.OnClickListener) null, (int) R.color.a5c);
                AppMethodBeat.o(6036);
                return;
            case 11:
                AppMethodBeat.o(6036);
                return;
        }
        AppMethodBeat.o(6036);
    }
}
