package com.tencent.mm.plugin.backup.j;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.ac;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.af;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a;
import com.tencent.mm.plugin.q.b;
import com.tencent.mm.plugin.q.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.Map;

public class a implements bd {
    private static a oUU;
    private IListener oUV = new IListener<ag>() {
        /* class com.tencent.mm.plugin.backup.j.a.AnonymousClass1 */

        {
            AppMethodBeat.i(161289);
            this.__eventId = ag.class.getName().hashCode();
            AppMethodBeat.o(161289);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ag agVar) {
            AppMethodBeat.i(22142);
            ag agVar2 = agVar;
            if (agVar2 != null && (agVar2 instanceof ag)) {
                c.BA(-1).o((Context) agVar2.dDf.dDg);
                Log.i("MicroMsg.BackupCore", "receive BackupUSBStopActionEvent.");
            }
            AppMethodBeat.o(22142);
            return false;
        }
    };
    private IListener oUW = new IListener<ac>() {
        /* class com.tencent.mm.plugin.backup.j.a.AnonymousClass2 */

        {
            AppMethodBeat.i(161290);
            this.__eventId = ac.class.getName().hashCode();
            AppMethodBeat.o(161290);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ac acVar) {
            AppMethodBeat.i(22143);
            ac acVar2 = acVar;
            if (acVar2 != null && (acVar2 instanceof ac)) {
                Log.i("MicroMsg.BackupCore", "receive BackupGetA8keyRedirectEvent.");
                String str = acVar2.dDa.url;
                c.BA(2).o(str);
            }
            AppMethodBeat.o(22143);
            return false;
        }
    };
    private IListener oUX = new IListener<ms>() {
        /* class com.tencent.mm.plugin.backup.j.a.AnonymousClass3 */

        {
            AppMethodBeat.i(161291);
            this.__eventId = ms.class.getName().hashCode();
            AppMethodBeat.o(161291);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ms msVar) {
            AppMethodBeat.i(22145);
            final ms msVar2 = msVar;
            if (!(msVar2 == null || !(msVar2 instanceof ms) || msVar2.dSm == null)) {
                Log.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent.");
                bg.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.backup.j.a.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(22144);
                        ms msVar = msVar2;
                        Log.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent run userCloseMsgSync[%b]", Boolean.valueOf(msVar.dSm.dSp));
                        if (msVar.dSm.dSp) {
                            h.INSTANCE.idkeyStat(466, 13, 1, false);
                            AppMethodBeat.o(22144);
                            return;
                        }
                        byte[] bArr = msVar.dSm.dSn;
                        if (bArr == null) {
                            Log.e("MicroMsg.BackupCore", "msgsynchronize loginconfirmok key is null!");
                            h.INSTANCE.idkeyStat(466, 14, 1, false);
                            AppMethodBeat.o(22144);
                            return;
                        }
                        int i2 = msVar.dSm.dSo;
                        f rr = f.rr(true);
                        String str = b.zFN;
                        rr.dSo = i2;
                        rr.d(str, "", bArr);
                        AppMethodBeat.o(22144);
                    }
                });
            }
            AppMethodBeat.o(22145);
            return false;
        }
    };
    private IListener oUY = new IListener<mr>() {
        /* class com.tencent.mm.plugin.backup.j.a.AnonymousClass4 */

        {
            AppMethodBeat.i(161292);
            this.__eventId = mr.class.getName().hashCode();
            AppMethodBeat.o(161292);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mr mrVar) {
            AppMethodBeat.i(22146);
            mr mrVar2 = mrVar;
            if (mrVar2 != null && (mrVar2 instanceof mr)) {
                Log.i("MicroMsg.BackupCore", "receive MsgSynchronizeABTestEvent.");
                b.elt();
                mrVar2.dSi.dSj = b.zFQ;
                mrVar2.dSi.dSk = b.zFR;
                mrVar2.dSi.dSl = b.zFS;
            }
            AppMethodBeat.o(22146);
            return false;
        }
    };
    private cj.a oUZ = new cj.a() {
        /* class com.tencent.mm.plugin.backup.j.a.AnonymousClass5 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(22147);
            Log.i("MicroMsg.BackupCore.BackupToPc", "sysMsgListener onreceive sysmsg");
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 0, 1, false);
            String str = XmlParser.parseXml(z.a(aVar.heO.KHn), "sysmsg", null).get(".sysmsg.MMBakChatNotify.url");
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.BackupCore.BackupToPc", "MMBakChatNotify url is null");
                AppMethodBeat.o(22147);
                return;
            }
            Intent className = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService");
            Intent createExplicitFromImplicitIntent = Util.createExplicitFromImplicitIntent(MMApplicationContext.getContext(), className);
            if (createExplicitFromImplicitIntent == null) {
                createExplicitFromImplicitIntent = className;
            }
            c.startService(createExplicitFromImplicitIntent.putExtra("url", str).putExtra("isFromWifi", true));
            AppMethodBeat.o(22147);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private cj.a oVa = new cj.a() {
        /* class com.tencent.mm.plugin.backup.j.a.AnonymousClass6 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(22149);
            Log.i("MicroMsg.BackupCore.MsgSynchronize", "appMsgListener onreceive appmsg");
            String a2 = z.a(aVar.heO.KHn);
            Map<String, String> parseXml = XmlParser.parseXml(a2, "appmsg", null);
            Log.d("MicroMsg.BackupCore.MsgSynchronize", "BackupCore msgcontent:%s", a2);
            if (parseXml.get(".appmsg.action").equals("phone")) {
                Log.i("MicroMsg.BackupCore.MsgSynchronize", "this appmsg is from phone, ignore.");
                AppMethodBeat.o(22149);
                return;
            }
            final String str = parseXml.get(".appmsg.messageaction");
            final String str2 = parseXml.get(".appmsg.extinfo");
            final byte[] bytes = parseXml.get(".appmsg.appattach.aeskey").getBytes();
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.backup.j.a.AnonymousClass6.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(22148);
                    Log.i("MicroMsg.BackupCore.MsgSynchronize", "start MsgSynchronizeServer");
                    f.rr(false).d(str, str2, bytes);
                    AppMethodBeat.o(22148);
                }
            });
            AppMethodBeat.o(22149);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private IListener oVb = new IListener<af>() {
        /* class com.tencent.mm.plugin.backup.j.a.AnonymousClass7 */

        {
            AppMethodBeat.i(161293);
            this.__eventId = af.class.getName().hashCode();
            AppMethodBeat.o(161293);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(af afVar) {
            AppMethodBeat.i(22154);
            af afVar2 = afVar;
            if (afVar2 != null && (afVar2 instanceof af)) {
                Log.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent, op:%d.", Integer.valueOf(afVar2.dDd.dDe));
                switch (afVar2.dDd.dDe) {
                    case 1:
                        if (CrashReportFactory.hasDebuger()) {
                            g.oJv = true;
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.backup.j.a.AnonymousClass7.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(22150);
                                    Toast.makeText(MMApplicationContext.getContext(), "test open", 0).show();
                                    AppMethodBeat.o(22150);
                                }
                            });
                            break;
                        }
                        break;
                    case 2:
                        com.tencent.mm.plugin.backup.d.b.cfv().cfy();
                        if (com.tencent.mm.plugin.backup.d.c.cfA()) {
                            bg.aAk().postToWorker(new Runnable() {
                                /* class com.tencent.mm.plugin.backup.j.a.AnonymousClass7.AnonymousClass3 */

                                public final void run() {
                                    AppMethodBeat.i(22152);
                                    com.tencent.mm.plugin.backup.d.b.cfv().cfy().jz(true);
                                    AppMethodBeat.o(22152);
                                }
                            });
                            break;
                        } else {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.backup.j.a.AnonymousClass7.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(22151);
                                    Toast.makeText(MMApplicationContext.getContext(), "no merge data", 0).show();
                                    AppMethodBeat.o(22151);
                                }
                            });
                            break;
                        }
                    case 3:
                        g.ceX();
                        g.agw(g.ceZ());
                        g.agw(g.cfa());
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.backup.j.a.AnonymousClass7.AnonymousClass4 */

                            public final void run() {
                                AppMethodBeat.i(22153);
                                Toast.makeText(MMApplicationContext.getContext(), "merge data delete", 0).show();
                                AppMethodBeat.o(22153);
                            }
                        });
                        break;
                }
            }
            AppMethodBeat.o(22154);
            return false;
        }
    };

    public a() {
        AppMethodBeat.i(22155);
        Log.i("MicroMsg.BackupCore", "BackupCore init");
        AppMethodBeat.o(22155);
    }

    public static void reset() {
        AppMethodBeat.i(22156);
        if (d.ceT()) {
            AppMethodBeat.o(22156);
            return;
        }
        oUU = null;
        com.tencent.mm.plugin.backup.b.a.ceG();
        d.ceU();
        AppMethodBeat.o(22156);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(22157);
        b chF = b.chF();
        Log.i("MicroMsg.BackupEventListener", "init addListener");
        chF.oVi = new IListener<ab>() {
            /* class com.tencent.mm.plugin.backup.j.b.AnonymousClass1 */

            {
                AppMethodBeat.i(161294);
                this.__eventId = ab.class.getName().hashCode();
                AppMethodBeat.o(161294);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ab abVar) {
                AppMethodBeat.i(22159);
                a.reset();
                AppMethodBeat.o(22159);
                return false;
            }
        };
        EventCenter.instance.addListener(chF.oVi);
        chF.oVj = new IListener<ad>() {
            /* class com.tencent.mm.plugin.backup.j.b.AnonymousClass2 */

            {
                AppMethodBeat.i(161295);
                this.__eventId = ad.class.getName().hashCode();
                AppMethodBeat.o(161295);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ad adVar) {
                AppMethodBeat.i(22160);
                boolean z = adVar.dDb.dDc;
                c.BA(1).o(Boolean.valueOf(z));
                AppMethodBeat.o(22160);
                return false;
            }
        };
        EventCenter.instance.addListener(chF.oVj);
        chF.oVk = new IListener<ak>() {
            /* class com.tencent.mm.plugin.backup.j.b.AnonymousClass3 */

            {
                AppMethodBeat.i(161296);
                this.__eventId = ak.class.getName().hashCode();
                AppMethodBeat.o(161296);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ak akVar) {
                AppMethodBeat.i(22161);
                ak akVar2 = akVar;
                Log.i("MicroMsg.BackupEventListener", "receive BannerOnInitEvent.");
                al alVar = new al();
                alVar.dDm.dDn = new a(akVar2.dDl.activity);
                alVar.dDm.independent = false;
                EventCenter.instance.publish(alVar);
                al alVar2 = new al();
                alVar2.dDm.dDn = new com.tencent.mm.plugin.backup.backupui.a(akVar2.dDl.activity);
                alVar2.dDm.independent = false;
                EventCenter.instance.publish(alVar2);
                AppMethodBeat.o(22161);
                return false;
            }
        };
        EventCenter.instance.addListener(chF.oVk);
        bg.getSysCmdMsgExtension().a("MMBakChatNotify", this.oUZ, true);
        bg.getSysCmdMsgExtension().a("ChatSync", this.oVa, true);
        EventCenter.instance.add(this.oUV);
        EventCenter.instance.add(this.oUW);
        EventCenter.instance.add(this.oUX);
        EventCenter.instance.add(this.oUY);
        EventCenter.instance.add(this.oVb);
        AppMethodBeat.o(22157);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(22158);
        b chF = b.chF();
        EventCenter.instance.removeListener(chF.oVi);
        EventCenter.instance.removeListener(chF.oVj);
        EventCenter.instance.removeListener(chF.oVk);
        bg.getSysCmdMsgExtension().b("MMBakChatNotify", this.oUZ, true);
        bg.getSysCmdMsgExtension().b("ChatSync", this.oVa, true);
        EventCenter.instance.removeListener(this.oUV);
        EventCenter.instance.removeListener(this.oUW);
        EventCenter.instance.removeListener(this.oUX);
        EventCenter.instance.removeListener(this.oUY);
        EventCenter.instance.removeListener(this.oVb);
        AppMethodBeat.o(22158);
    }
}
