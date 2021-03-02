package com.tencent.mm.plugin.webwx.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.support.v4.app.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.o.a;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import com.tencent.smtt.sdk.TbsListener;
import java.util.HashMap;
import java.util.List;

public final class g implements bd {
    private f JFe = new f();
    private a JFf;
    private bc JFg = new bc() {
        /* class com.tencent.mm.plugin.webwx.a.g.AnonymousClass2 */

        @Override // com.tencent.mm.model.bc
        public final void aVw() {
            AppMethodBeat.i(30184);
            bg.aVF();
            if (c.azn()) {
                g.gjc();
            }
            AppMethodBeat.o(30184);
        }
    };
    private IListener JFh = new IListener<tm>() {
        /* class com.tencent.mm.plugin.webwx.a.g.AnonymousClass3 */

        {
            AppMethodBeat.i(161474);
            this.__eventId = tm.class.getName().hashCode();
            AppMethodBeat.o(161474);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tm tmVar) {
            AppMethodBeat.i(30187);
            boolean a2 = a(tmVar);
            AppMethodBeat.o(30187);
            return a2;
        }

        private boolean a(final tm tmVar) {
            AppMethodBeat.i(30186);
            if (tmVar != null && (tmVar instanceof tm)) {
                final d dVar = new d(tmVar.dZV.dZW);
                bg.azz().a(971, new i() {
                    /* class com.tencent.mm.plugin.webwx.a.g.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                        String str2;
                        Intent intent;
                        int i4;
                        AppMethodBeat.i(30185);
                        bg.azz().b(971, this);
                        akw akw = (akw) dVar.iUB.iLL.iLR;
                        Log.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", Integer.valueOf(i3), str);
                        if (i2 == 0 && i3 == 0) {
                            if (akw.LtF != null) {
                                Intent intent2 = new Intent();
                                intent2.putExtra("intent.key.login.url", tmVar.dZV.dZW);
                                intent2.putExtra("intent.key.type", 0);
                                intent2.putExtra("intent.key.icon.type", akw.LtF.LtB);
                                intent2.putExtra("intent.key.ok.string", akw.LtF.LtP);
                                intent2.putExtra("intent.key.cancel.string", akw.LtF.LtQ);
                                intent2.putExtra("intent.key.title.string", akw.LtF.LtC);
                                intent2.putExtra("intent.key.content.string", akw.LtF.LtU);
                                intent2.putExtra("intent.key.login.client.version", akw.LtJ);
                                intent2.putExtra("intent.key.function.control", akw.LtK);
                                intent2.putExtra("intent.key.usage.link", akw.LtF.LtV);
                                String str3 = akw.LtF.LtC;
                                StringBuilder sb = new StringBuilder();
                                Cursor cursor = null;
                                try {
                                    bg.aVF();
                                    Cursor a2 = c.aST().a(ab.iCF, (List<String>) null, a.gNj, true);
                                    if (a2 != null) {
                                        if (a2.getCount() < akw.LtF.LtR) {
                                            i4 = a2.getCount();
                                        } else {
                                            i4 = akw.LtF.LtR;
                                        }
                                        int columnIndex = a2.getColumnIndex(ch.COL_USERNAME);
                                        for (int i5 = 0; i5 < i4; i5++) {
                                            if (a2.moveToPosition(i5)) {
                                                sb.append(a2.getString(columnIndex));
                                                if (i5 < i4 - 1) {
                                                    sb.append(",");
                                                }
                                            }
                                        }
                                    }
                                    intent2.putExtra("intent.key.ok.session.list", sb.toString());
                                    if (a2 != null) {
                                        a2.close();
                                        str2 = str3;
                                        intent = intent2;
                                    }
                                } catch (Exception e2) {
                                    Log.printErrStackTrace("MicroMsg.SubCoreWebWX", e2, "[oneliang]get session list error.", new Object[0]);
                                    if (0 != 0) {
                                        cursor.close();
                                        str2 = str3;
                                        intent = intent2;
                                    }
                                } catch (Throwable th) {
                                    if (0 != 0) {
                                        cursor.close();
                                    }
                                    AppMethodBeat.o(30185);
                                    throw th;
                                }
                                str2 = str3;
                                intent = intent2;
                            }
                            str2 = null;
                            intent = null;
                        } else if (i3 == -1) {
                            if (akw.LtG != null) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("intent.key.login.url", tmVar.dZV.dZW);
                                intent3.putExtra("intent.key.type", -1);
                                intent3.putExtra("intent.key.title.string", akw.LtG.LtD);
                                intent3.putExtra("intent.key.icon.type", akw.LtG.LtB);
                                intent3.putExtra("intent.key.ok.string", akw.LtG.LtE);
                                intent3.putExtra("intent.key.content.string", akw.LtG.LtC);
                                str2 = akw.LtG.LtC;
                                intent = intent3;
                            }
                            str2 = null;
                            intent = null;
                        } else {
                            if (i3 == -2 && akw.LtH != null) {
                                Intent intent4 = new Intent();
                                intent4.putExtra("intent.key.login.url", tmVar.dZV.dZW);
                                intent4.putExtra("intent.key.type", -2);
                                intent4.putExtra("intent.key.title.string", akw.LtH.LtD);
                                intent4.putExtra("intent.key.icon.type", akw.LtH.LtB);
                                intent4.putExtra("intent.key.ok.string", akw.LtH.LtE);
                                intent4.putExtra("intent.key.content.string", akw.LtH.LtC);
                                str2 = akw.LtH.LtC;
                                intent = intent4;
                            }
                            str2 = null;
                            intent = null;
                        }
                        if (intent != null) {
                            intent.setFlags(268435456);
                            intent.setClass(MMApplicationContext.getContext(), ExtDeviceWXLoginUI.class);
                            Context context = MMApplicationContext.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webwx/model/SubCoreWebWX$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            Intent intent5 = new Intent(intent);
                            intent5.setFlags(67108864);
                            if (tmVar.dZV.type == 1) {
                                PendingIntent activity = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, intent5, 134217728);
                                s.c g2 = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i((CharSequence) null).i(System.currentTimeMillis()).f(MMApplicationContext.getContext().getString(R.string.wx)).g(str2);
                                g2.Hv = activity;
                                Notification build = g2.build();
                                build.icon = com.tencent.mm.bq.a.ezb();
                                build.flags |= 16;
                                build.sound = RingtoneManager.getDefaultUri(2);
                                bg.getNotification().notify(38, build);
                            }
                        }
                        AppMethodBeat.o(30185);
                    }
                });
                bg.azz().a(dVar, 0);
            }
            AppMethodBeat.o(30186);
            return false;
        }
    };
    private IListener JFi = new IListener<tn>() {
        /* class com.tencent.mm.plugin.webwx.a.g.AnonymousClass4 */

        {
            AppMethodBeat.i(232128);
            this.__eventId = tn.class.getName().hashCode();
            AppMethodBeat.o(232128);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tn tnVar) {
            AppMethodBeat.i(232129);
            tn tnVar2 = tnVar;
            if (tnVar2 != null && (tnVar2 instanceof tn)) {
                Intent intent = new Intent();
                intent.putExtra("intent.key.login.url", tnVar2.dZX.dZW);
                intent.putExtra("intent.key.device.name", tnVar2.dZX.deviceName);
                intent.setFlags(268435456);
                com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "kidswatch", ".ui.login.KidsWatchEntranceUI", intent);
            }
            AppMethodBeat.o(232129);
            return false;
        }
    };
    private y JFj = new y<de>() {
        /* class com.tencent.mm.plugin.webwx.a.g.AnonymousClass5 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
        @Override // com.tencent.mm.plugin.messenger.foundation.a.y
        public final /* bridge */ /* synthetic */ void a(de deVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
        @Override // com.tencent.mm.plugin.messenger.foundation.a.y
        public final /* synthetic */ void b(de deVar) {
            AppMethodBeat.i(232130);
            de deVar2 = deVar;
            if (deVar2.xKb == 51 || !z.aTY().equals(deVar2.KHl.MTo)) {
                AppMethodBeat.o(232130);
                return;
            }
            bg.aVF();
            ca aJ = c.aSQ().aJ(deVar2.KHm.MTo, deVar2.Brn);
            if (aJ.field_msgSvrId == 0) {
                Log.i("MicroMsg.SubCoreWebWX", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", Long.valueOf(deVar2.Brn));
                AppMethodBeat.o(232130);
                return;
            }
            Log.i("MicroMsg.SubCoreWebWX", "[MicroMsg.MultiTerminalSyncMgr] selfSend msg, svrID:%d, localId:%d", Long.valueOf(deVar2.Brn), Long.valueOf(aJ.field_msgId));
            g.gjb().gjd().Mh(aJ.field_msgId);
            AppMethodBeat.o(232130);
        }
    };
    private cj.a oUZ = new cj.a() {
        /* class com.tencent.mm.plugin.webwx.a.g.AnonymousClass1 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(30183);
            String str = XmlParser.parseXml(com.tencent.mm.platformtools.z.a(aVar.heO.KHn), "sysmsg", null).get(".sysmsg.pushloginurl.url");
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
            }
            tm tmVar = new tm();
            tmVar.dZV.dZW = str;
            tmVar.dZV.type = 1;
            EventCenter.instance.publish(tmVar);
            aVar.heO.KHr = null;
            AppMethodBeat.o(30183);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };

    public g() {
        AppMethodBeat.i(30189);
        AppMethodBeat.o(30189);
    }

    public static g gjb() {
        AppMethodBeat.i(30190);
        bg.aVz();
        g gVar = (g) cg.KG("plugin.webwx");
        if (gVar == null) {
            gVar = new g();
            bg.aVz().a("plugin.webwx", gVar);
        }
        AppMethodBeat.o(30190);
        return gVar;
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(30191);
        h.d.b(51, this.JFe);
        bg.getSysCmdMsgExtension().b("pushloginurl", this.oUZ, true);
        bg.aVF();
        c.b(this.JFg);
        EventCenter.instance.removeListener(this.JFh);
        EventCenter.instance.removeListener(this.JFi);
        gjc();
        if (this.JFf != null) {
            a aVar = this.JFf;
            o.bhj().a(aVar);
            com.tencent.mm.kernel.g.azz().b(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, aVar);
        }
        com.tencent.mm.plugin.messenger.foundation.a.ab.a(this.JFj);
        AppMethodBeat.o(30191);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(30192);
        h.d.a(51, this.JFe);
        bg.getSysCmdMsgExtension().a("pushloginurl", this.oUZ, true);
        bg.aVF();
        c.a(this.JFg);
        EventCenter.instance.addListener(this.JFh);
        EventCenter.instance.addListener(this.JFi);
        this.JFf = null;
        com.tencent.mm.plugin.messenger.foundation.a.ab.a(5, this.JFj);
        AppMethodBeat.o(30192);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    static void gjc() {
        AppMethodBeat.i(30193);
        bg.getNotification().cancel(38);
        AppMethodBeat.o(30193);
    }

    public final a gjd() {
        AppMethodBeat.i(30194);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.JFf == null) {
            this.JFf = new a();
        }
        a aVar = this.JFf;
        AppMethodBeat.o(30194);
        return aVar;
    }
}
