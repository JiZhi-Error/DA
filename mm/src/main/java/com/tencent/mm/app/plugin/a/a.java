package com.tencent.mm.app.plugin.a;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.g;
import com.tencent.mm.api.c;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.g.a.es;
import com.tencent.mm.g.a.md;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class a {
    public com.tencent.mm.ui.chatting.e.a dom;
    public b don;
    public C0264a doo;
    private String dop;
    public Map<String, Boolean> doq;
    public boolean dor = true;

    public a(com.tencent.mm.ui.chatting.e.a aVar) {
        AppMethodBeat.i(19771);
        Log.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
        this.dom = aVar;
        if (this.don == null) {
            this.don = new b();
        }
        EventCenter.instance.addListener(this.don);
        if (this.doo == null) {
            this.doo = new C0264a();
        }
        EventCenter.instance.addListener(this.doo);
        AppMethodBeat.o(19771);
    }

    /* access modifiers changed from: package-private */
    public class b extends IListener<or> {
        b() {
            AppMethodBeat.i(161259);
            this.__eventId = or.class.getName().hashCode();
            AppMethodBeat.o(161259);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(or orVar) {
            AppMethodBeat.i(19770);
            or orVar2 = orVar;
            if (a.this.dom != null) {
                if (!a.this.dom.Pwc.isFinishing()) {
                    int i2 = orVar2.dUI.op;
                    String str = orVar2.dUI.dRD;
                    Log.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "opcode is %d, brand name is %s", Integer.valueOf(i2), str);
                    if (a.this.dom.getTalkerUserName().equals(str)) {
                        switch (i2) {
                            case 1:
                                a aVar = a.this;
                                Log.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "handleConnectFailedReason, reason : %d, brand name : %s", Integer.valueOf(orVar2.dUI.bDZ), str);
                                c fJ = g.fJ(str);
                                if (a.d(fJ)) {
                                    if (fJ.cG(false).UZ().dig == 1) {
                                        aVar.dom.Pwc.setMMSubTitle((String) null);
                                        break;
                                    }
                                } else {
                                    Log.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", str);
                                    break;
                                }
                                break;
                            case 2:
                                a.this.e(orVar2.dUI.dHO, str, orVar2.dUI.dGL);
                                break;
                            case 3:
                                if (a.this.doq != null) {
                                    a.this.doq.clear();
                                    Log.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "clear connected device ids successfully.");
                                    break;
                                }
                                break;
                        }
                    } else {
                        Log.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "not current brandname");
                    }
                } else {
                    Log.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context isFinishing");
                }
            } else {
                Log.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context == null");
            }
            AppMethodBeat.o(19770);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.app.plugin.a.a$a  reason: collision with other inner class name */
    public class C0264a extends IListener<dt> {
        C0264a() {
            AppMethodBeat.i(161258);
            this.__eventId = dt.class.getName().hashCode();
            AppMethodBeat.o(161258);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* bridge */ /* synthetic */ boolean callback(dt dtVar) {
            dtVar.dGM.dor = a.this.dor;
            return true;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public final synchronized void e(int i2, String str, String str2) {
        AppMethodBeat.i(19772);
        Log.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connect state : %d", Integer.valueOf(i2));
        if (this.dom != null && !Util.isNullOrNil(str)) {
            c fJ = g.fJ(str);
            if (d(fJ)) {
                if (this.doq == null) {
                    this.doq = new HashMap();
                }
                Map<String, Boolean> map = this.doq;
                if (!str.equals(this.dop)) {
                    this.dop = str;
                    map.clear();
                }
                if (fJ.cG(false).UZ().dig != 1) {
                    Log.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "connDeviceIds : (%s) , deviceId : (%s)", map, str2);
                    switch (i2) {
                        case -1:
                            this.dom.Pwc.setMMSubTitle((String) null);
                            AppMethodBeat.o(19772);
                            break;
                        case 0:
                            if (map.size() == 0) {
                                this.dom.Pwc.setMMSubTitle(R.string.c04);
                                AppMethodBeat.o(19772);
                                break;
                            }
                            AppMethodBeat.o(19772);
                            break;
                        case 1:
                            if (map.size() == 0) {
                                this.dom.Pwc.setMMSubTitle(R.string.c03);
                            }
                            AppMethodBeat.o(19772);
                            break;
                        case 2:
                            map.put(str2, Boolean.TRUE);
                            this.dom.Pwc.setMMSubTitle(this.dom.Pwc.getString(R.string.c02, Integer.valueOf(map.size())));
                            Log.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", str2);
                            AppMethodBeat.o(19772);
                            break;
                        case 3:
                        default:
                            AppMethodBeat.o(19772);
                            break;
                        case 4:
                            if (map.remove(str2) != null) {
                                Log.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", str2);
                            }
                            this.dom.Pwc.setMMSubTitle(this.dom.Pwc.getString(R.string.c02, Integer.valueOf(map.size())));
                            AppMethodBeat.o(19772);
                            break;
                    }
                } else {
                    this.dom.Pwc.setMMSubTitle((String) null);
                    AppMethodBeat.o(19772);
                }
            } else {
                Log.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", str);
                AppMethodBeat.o(19772);
            }
        } else {
            Log.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
            AppMethodBeat.o(19772);
        }
    }

    public final void a(final int i2, c cVar) {
        AppMethodBeat.i(19773);
        if (this.dom == null) {
            Log.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
            AppMethodBeat.o(19773);
            return;
        }
        if (ab.IT(this.dom.getTalkerUserName()) && d(cVar)) {
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.app.plugin.a.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(19769);
                    if (1 == i2) {
                        es esVar = new es();
                        esVar.dIa.op = 0;
                        esVar.dIa.userName = a.this.dom.getTalkerUserName();
                        esVar.dIa.context = a.this.dom.Pwc.getContext();
                        EventCenter.instance.publish(esVar);
                        if (a.this.dom.getTalkerUserName().equals("gh_43f2581f6fd6")) {
                            wp wpVar = new wp();
                            wpVar.ecH.action = 1;
                            EventCenter.instance.asyncPublish(wpVar, new Executor() {
                                /* class com.tencent.mm.app.plugin.a.a.AnonymousClass1.AnonymousClass1 */

                                public final void execute(Runnable runnable) {
                                    AppMethodBeat.i(179570);
                                    h.RTc.aX(runnable);
                                    AppMethodBeat.o(179570);
                                }
                            });
                        }
                    }
                    md mdVar = new md();
                    mdVar.dRC.opType = i2;
                    mdVar.dRC.viewId = 1;
                    mdVar.dRC.dRD = a.this.dom.getTalkerUserName();
                    EventCenter.instance.publish(mdVar);
                    AppMethodBeat.o(19769);
                }
            });
        }
        AppMethodBeat.o(19773);
    }

    public static boolean d(c cVar) {
        c.b cG;
        AppMethodBeat.i(19774);
        if (cVar == null) {
            AppMethodBeat.o(19774);
            return false;
        } else if (cVar == null || (cG = cVar.cG(false)) == null || cG.UZ() == null || !cG.UZ().Vi()) {
            AppMethodBeat.o(19774);
            return false;
        } else {
            AppMethodBeat.o(19774);
            return true;
        }
    }
}
