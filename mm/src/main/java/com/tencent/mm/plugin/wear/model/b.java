package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.g;
import com.tencent.mm.g.a.aap;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.eys;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import java.util.LinkedList;

public final class b implements i {
    boolean IxA;
    IListener IxB = new IListener<aap>() {
        /* class com.tencent.mm.plugin.wear.model.b.AnonymousClass1 */

        {
            AppMethodBeat.i(161462);
            this.__eventId = aap.class.getName().hashCode();
            AppMethodBeat.o(161462);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0067, code lost:
            if (r10.IxD.IxA != false) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0038, code lost:
            if (r11.ehC.isSuccess != false) goto L_0x003a;
         */
        @Override // com.tencent.mm.sdk.event.IListener
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.aap r11) {
            /*
            // Method dump skipped, instructions count: 274
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wear.model.b.AnonymousClass1.callback(com.tencent.mm.sdk.event.IEvent):boolean");
        }
    };
    MTimerHandler IxC = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.wear.model.b.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(29968);
            b.a(a.fVM().IxH.Iyu);
            AppMethodBeat.o(29968);
            return true;
        }
    }, true);
    MStorageEx.IOnStorageChange wYc = new MStorageEx.IOnStorageChange() {
        /* class com.tencent.mm.plugin.wear.model.b.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(29967);
            if (obj == null || !(obj instanceof String)) {
                Log.d("MicroMsg.Wear.WearBizLogic", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
                AppMethodBeat.o(29967);
                return;
            }
            String str = (String) obj;
            if (str != null && str.equals("gh_43f2581f6fd6")) {
                if (!b.fVS() && b.this.IxA) {
                    b.this.IxA = false;
                    AppMethodBeat.o(29967);
                    return;
                } else if (b.fVS() && !b.this.IxA) {
                    b.this.connect();
                }
            }
            AppMethodBeat.o(29967);
        }
    };

    public b() {
        AppMethodBeat.i(29971);
        EventCenter.instance.addListener(this.IxB);
        bg.aVF();
        c.aSN().add(this.wYc);
        AppMethodBeat.o(29971);
    }

    public final void connect() {
        AppMethodBeat.i(29972);
        eys eys = a.fVM().IxH.Iyu;
        if (eys == null) {
            Log.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
            AppMethodBeat.o(29972);
        } else if (!fVS()) {
            bg.aVF();
            boolean booleanValue = ((Boolean) c.azQ().get(327825, Boolean.FALSE)).booleanValue();
            Log.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", Boolean.valueOf(booleanValue));
            if (!booleanValue) {
                if (Util.isOverseasUser(MMApplicationContext.getContext())) {
                    Log.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
                    AppMethodBeat.o(29972);
                    return;
                }
                a.fVN().a(new a(this, (byte) 0));
                a.fVN().a(new C1930b(eys));
            }
            AppMethodBeat.o(29972);
        } else if (!aWi(eys.Nvp)) {
            Log.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", eys.Nvp);
            a.fVN().a(new C1930b(eys));
            AppMethodBeat.o(29972);
        } else if (!this.IxA) {
            Log.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", eys.Nvp);
            String str = eys.Nvp;
            if (!this.IxA && aWi(str)) {
                Log.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", str, "gh_43f2581f6fd6");
                aap aap = new aap();
                aap.ehC.dDe = 7;
                aap.ehC.dGL = str;
                aap.ehC.dGP = "gh_43f2581f6fd6";
                EventCenter.instance.publish(aap);
            }
            AppMethodBeat.o(29972);
        } else {
            if (this.IxC.stopped()) {
                Log.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
                this.IxC.startTimer(Util.MILLSECONDS_OF_HOUR);
            } else {
                Log.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
                this.IxC.stopTimer();
                this.IxC.startTimer(Util.MILLSECONDS_OF_HOUR);
            }
            a(eys);
            AppMethodBeat.o(29972);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.wear.model.b$b  reason: collision with other inner class name */
    public class C1930b extends d {
        private eys IxE;

        public C1930b(eys eys) {
            this.IxE = eys;
        }

        @Override // com.tencent.mm.plugin.wear.model.f.d
        public final void execute() {
            AppMethodBeat.i(29970);
            bg.azz().a(1091, b.this);
            bg.azz().a(new com.tencent.mm.plugin.wear.model.d.a(this.IxE.Nvp, "gh_43f2581f6fd6"), 0);
            AppMethodBeat.o(29970);
        }

        @Override // com.tencent.mm.plugin.wear.model.f.d
        public final String getName() {
            return "RegisterDeviceTask";
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends d {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.wear.model.f.d
        public final void execute() {
            AppMethodBeat.i(29969);
            bg.azz().a(30, b.this);
            LinkedList linkedList = new LinkedList();
            linkedList.add("gh_43f2581f6fd6");
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(1);
            bg.azz().a(new p(linkedList, linkedList2, "", ""), 0);
            AppMethodBeat.o(29969);
        }

        @Override // com.tencent.mm.plugin.wear.model.f.d
        public final String getName() {
            return "AddContactTask";
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(29973);
        if (qVar instanceof com.tencent.mm.plugin.wear.model.d.a) {
            bg.azz().b(1091, this);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.wear.model.d.a aVar = (com.tencent.mm.plugin.wear.model.d.a) qVar;
                String str2 = aVar.dGL;
                String str3 = aVar.dGP;
                aap aap = new aap();
                aap.ehC.dDe = 1;
                aap.ehC.dGL = str2;
                aap.ehC.dGP = str3;
                EventCenter.instance.publish(aap);
                AppMethodBeat.o(29973);
                return;
            }
            Log.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            AppMethodBeat.o(29973);
            return;
        }
        if (qVar instanceof p) {
            bg.azz().b(30, this);
            if (i2 == 0 && i3 == 0) {
                String gmD = ((p) qVar).gmD();
                Log.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", gmD);
                bg.aVF();
                as Kn = c.aSN().Kn("gh_43f2581f6fd6");
                if (Kn == null || Util.isNullOrNil(gmD)) {
                    Log.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + gmD + ", contact = " + Kn);
                } else {
                    com.tencent.mm.api.c cVar = null;
                    if (ab.IR(Kn.field_username)) {
                        String nullAsNil = Util.nullAsNil(Kn.field_username);
                        cVar = g.fJ(nullAsNil);
                        if (cVar != null) {
                            cVar.field_username = gmD;
                        }
                        ag.bah().delete(nullAsNil);
                        Kn.BK(nullAsNil);
                    }
                    Kn.setUsername(gmD);
                    if (((int) Kn.gMZ) == 0) {
                        bg.aVF();
                        c.aSN().aq(Kn);
                    }
                    if (((int) Kn.gMZ) <= 0) {
                        Log.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
                    } else {
                        ab.B(Kn);
                        bg.aVF();
                        as Kn2 = c.aSN().Kn(Kn.field_username);
                        if (cVar != null) {
                            ag.bah().g(cVar);
                        } else {
                            com.tencent.mm.api.c fJ = g.fJ(Kn2.field_username);
                            if (fJ == null || fJ.Uz()) {
                                Log.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
                                ay.a.iDq.aL(Kn2.field_username, "");
                                com.tencent.mm.aj.c.Mf(Kn2.field_username);
                            } else if (Kn2.gBQ()) {
                                Log.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", Integer.valueOf(Kn2.fuP));
                                ay.a.iDq.aL(Kn2.field_username, "");
                                com.tencent.mm.aj.c.Mf(Kn2.field_username);
                            }
                        }
                    }
                }
                ag.bah().h(ag.bah().MT(Kn.field_username));
                bg.aVF();
                c.azQ().set(327825, Boolean.TRUE);
                connect();
            } else {
                Log.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 == 4 && i3 == -24 && !Util.isNullOrNil(str)) {
                    Toast.makeText(MMApplicationContext.getContext(), str, 1).show();
                    AppMethodBeat.o(29973);
                    return;
                }
            }
        }
        AppMethodBeat.o(29973);
    }

    static boolean aWi(String str) {
        AppMethodBeat.i(29974);
        aap aap = new aap();
        aap.ehC.dDe = 3;
        aap.ehC.dGL = str;
        aap.ehC.dGP = "gh_43f2581f6fd6";
        EventCenter.instance.publish(aap);
        Log.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", Boolean.valueOf(aap.ehC.isSuccess));
        boolean z = aap.ehC.isSuccess;
        AppMethodBeat.o(29974);
        return z;
    }

    static boolean fVS() {
        AppMethodBeat.i(29975);
        bg.aVF();
        boolean oR = com.tencent.mm.contact.c.oR(c.aSN().Kn("gh_43f2581f6fd6").field_type);
        AppMethodBeat.o(29975);
        return oR;
    }

    public static void a(eys eys) {
        AppMethodBeat.i(29976);
        if (eys != null) {
            aap aap = new aap();
            aap.ehC.dDe = 6;
            aap.ehC.dGL = eys.Nvp;
            EventCenter.instance.publish(aap);
            AppMethodBeat.o(29976);
            return;
        }
        Log.i("MicroMsg.Wear.WearBizLogic", "request is null");
        AppMethodBeat.o(29976);
    }
}
