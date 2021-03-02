package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ListAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.b;
import com.tencent.mm.bi.c;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.multitalk.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.LiveTalkRoomTipsBar;
import com.tencent.mm.ui.MultiTalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.a.d;
import java.util.LinkedList;

@a(gRF = as.class)
public class bd extends a implements com.tencent.mm.bh.a, c, d.a, as, q.a {
    public LiveTalkRoomTipsBar OFq;
    private final MStorage.IOnStorageChange Pnh = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.ui.chatting.d.bd.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(35650);
            Log.v("MicroMsg.ChattingUI.TrackRoomComponent", "roommember watcher notify ".concat(String.valueOf(str)));
            if (!Util.isNullOrNil(str)) {
                bd.a(bd.this);
            }
            AppMethodBeat.o(35650);
        }
    };
    public TalkRoomPopupNav PuB;
    public MultiTalkRoomPopupNav PuC;
    private View PuD;
    private TalkRoomPopupNav.a PuE = new TalkRoomPopupNav.a() {
        /* class com.tencent.mm.ui.chatting.d.bd.AnonymousClass7 */

        @Override // com.tencent.mm.ui.base.TalkRoomPopupNav.a
        public final void gLw() {
            AppMethodBeat.i(35657);
            if (com.tencent.mm.q.a.cC(bd.this.dom.Pwc.getContext()) || com.tencent.mm.q.a.cA(bd.this.dom.Pwc.getContext()) || com.tencent.mm.q.a.cE(bd.this.dom.Pwc.getContext())) {
                Log.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
                AppMethodBeat.o(35657);
                return;
            }
            Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "Click banner : %d", Integer.valueOf(com.tencent.mm.bi.d.jpA.PY(bd.this.dom.GUe.field_username).size()));
            if (com.tencent.mm.bi.d.jpA.PZ(bd.this.dom.GUe.field_username)) {
                bd.b(bd.this);
                AppMethodBeat.o(35657);
                return;
            }
            bd.this.BU(true);
            AppMethodBeat.o(35657);
        }

        @Override // com.tencent.mm.ui.base.TalkRoomPopupNav.a
        public final void bme(String str) {
            AppMethodBeat.i(233189);
            if (b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
                if (!(com.tencent.mm.pluginsdk.permission.b.n(bd.this.dom.Pwc.getContext(), "android.permission.ACCESS_FINE_LOCATION") && com.tencent.mm.pluginsdk.permission.b.n(bd.this.dom.Pwc.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {
                    if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                        com.tencent.mm.plugin.account.a.b.a.b(bd.this.dom.Pwc.getContext(), bd.this.dom.Pwc.getMMResources().getString(R.string.el_, LocaleUtil.getApplicationLanguage()), 30762, true);
                        AppMethodBeat.o(233189);
                        return;
                    }
                    com.tencent.mm.pluginsdk.permission.b.a(bd.this.dom.Pwc.getContext(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 68);
                    AppMethodBeat.o(233189);
                    return;
                }
            } else {
                boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(bd.this.dom.Pwc.getContext(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 68, (String) null, (String) null);
                Log.d("MicroMsg.ChattingUI.TrackRoomComponent", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(a2));
                if (!a2) {
                    AppMethodBeat.o(233189);
                    return;
                }
            }
            bd.this.bmP(str);
            AppMethodBeat.o(233189);
        }
    };
    private IListener qCu = new IListener<zj>() {
        /* class com.tencent.mm.ui.chatting.d.bd.AnonymousClass4 */

        {
            AppMethodBeat.i(161533);
            this.__eventId = zj.class.getName().hashCode();
            AppMethodBeat.o(161533);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zj zjVar) {
            AppMethodBeat.i(35655);
            zj zjVar2 = zjVar;
            if (!g.aAc()) {
                AppMethodBeat.o(35655);
                return false;
            }
            if (zjVar2.efx.dKy == 5 || zjVar2.efx.dKy == 3) {
                fo foVar = new fo();
                foVar.dIN.username = com.tencent.mm.bi.d.jpB.bgL();
                EventCenter.instance.publish(foVar);
            }
            AppMethodBeat.o(35655);
            return true;
        }
    };

    static /* synthetic */ void a(bd bdVar) {
        AppMethodBeat.i(35683);
        bdVar.BT(false);
        AppMethodBeat.o(35683);
    }

    static /* synthetic */ void a(bd bdVar, String str) {
        AppMethodBeat.i(35685);
        bdVar.bmQ(str);
        AppMethodBeat.o(35685);
    }

    public bd() {
        AppMethodBeat.i(35663);
        AppMethodBeat.o(35663);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.as
    public final boolean gRh() {
        AppMethodBeat.i(35664);
        if (this.PuB == null) {
            AppMethodBeat.o(35664);
            return false;
        } else if (this.PuB.getVisibility() == 0) {
            AppMethodBeat.o(35664);
            return true;
        } else {
            AppMethodBeat.o(35664);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.as
    public final boolean gRi() {
        AppMethodBeat.i(35665);
        if (this.PuC == null) {
            AppMethodBeat.o(35665);
            return false;
        } else if (this.PuC.getVisibility() == 0) {
            AppMethodBeat.o(35665);
            return true;
        } else {
            AppMethodBeat.o(35665);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.as
    public final boolean gRj() {
        AppMethodBeat.i(233190);
        if (this.OFq == null) {
            AppMethodBeat.o(233190);
            return false;
        } else if (this.OFq.getVisibility() == 0) {
            AppMethodBeat.o(233190);
            return true;
        } else {
            AppMethodBeat.o(233190);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.as
    public final int gRk() {
        AppMethodBeat.i(35666);
        if (this.PuB == null) {
            AppMethodBeat.o(35666);
            return 0;
        }
        int height = this.PuB.getHeight();
        AppMethodBeat.o(35666);
        return height;
    }

    @Override // com.tencent.mm.bh.a
    public final void h(String str, String str2, String str3) {
        AppMethodBeat.i(35668);
        if (this.dom != null && str.equals(this.dom.getTalkerUserName())) {
            BT(false);
        }
        AppMethodBeat.o(35668);
    }

    @Override // com.tencent.mm.bi.c
    public final void Qa(String str) {
        AppMethodBeat.i(35669);
        if (this.dom != null && str.equals(this.dom.getTalkerUserName())) {
            BT(false);
        }
        AppMethodBeat.o(35669);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.d.a
    public final void aFR(String str) {
        AppMethodBeat.i(35670);
        if (this.dom != null && str.equals(this.dom.getTalkerUserName())) {
            BT(false);
        }
        AppMethodBeat.o(35670);
    }

    @Override // com.tencent.mm.ui.q.a
    public final void blQ(String str) {
        AppMethodBeat.i(233191);
        if (this.dom != null && str.equals(this.dom.getTalkerUserName())) {
            BT(false);
        }
        AppMethodBeat.o(233191);
    }

    private void a(TalkRoomPopupNav.a aVar) {
        AppMethodBeat.i(35671);
        if (this.PuB == null) {
            l.a(this.dom.Pwc, (int) R.id.j88);
            this.PuB = (TalkRoomPopupNav) this.dom.findViewById(R.id.ihu);
            this.PuD = this.dom.findViewById(R.id.iph);
            this.PuB.setRootTipsBarBackground(this.PuD);
            this.PuB.setChattingContext(this.dom);
            if (this.PuB == null) {
                AppMethodBeat.o(35671);
                return;
            }
        }
        if (this.PuB != null) {
            this.PuB.setOnClickListener(aVar);
        }
        AppMethodBeat.o(35671);
    }

    private void gRl() {
        AppMethodBeat.i(35672);
        if (this.PuC == null) {
            this.PuD = this.dom.findViewById(R.id.iph);
            l.a(this.dom.Pwc, (int) R.id.j83);
            this.PuC = (MultiTalkRoomPopupNav) this.dom.findViewById(R.id.fp9);
            this.PuC.setRootTipsBarBackground(this.PuD);
            this.PuC.setChattingContext(this.dom);
        }
        AppMethodBeat.o(35672);
    }

    private void gRm() {
        AppMethodBeat.i(233192);
        if (this.OFq == null) {
            this.PuD = this.dom.findViewById(R.id.iph);
            l.a(this.dom.Pwc, (int) R.id.j81);
            this.OFq = (LiveTalkRoomTipsBar) this.dom.findViewById(R.id.em1);
            LiveTalkRoomTipsBar liveTalkRoomTipsBar = this.OFq;
            if (liveTalkRoomTipsBar.OFb == null) {
                liveTalkRoomTipsBar.OFb = new q(liveTalkRoomTipsBar);
            }
            liveTalkRoomTipsBar.gID();
            if (liveTalkRoomTipsBar.OFj != null) {
                liveTalkRoomTipsBar.OFj.setAdapter((ListAdapter) liveTalkRoomTipsBar.OFb.OFs);
            }
            this.OFq.setRootTipsBarBackground(this.PuD);
            this.OFq.setChattingUserName(this.dom.getTalkerUserName());
            AppMethodBeat.o(233192);
            return;
        }
        this.OFq.gID();
        AppMethodBeat.o(233192);
    }

    private void BT(boolean z) {
        AppMethodBeat.i(35673);
        Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "[tomys] FOR_DEBUG checkTalkroomBanner, isResume: %s, stacks: %s", Boolean.valueOf(z), Util.getStack().toString());
        if (this.dom == null) {
            Log.w("MicroMsg.ChattingUI.TrackRoomComponent", "[checkTalkroomBanner] isResume:%s mChattingContext == null! maybe chattingui has Exited! this event come from post msg", Boolean.valueOf(z));
            AppMethodBeat.o(35673);
            return;
        }
        boolean z2 = ((f) this.dom.bh(f.class)).gPi() || ((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOV();
        if (!ab.Eq(this.dom.getTalkerUserName()) || z2) {
            gRn();
            if (((ai) this.dom.bh(ai.class)).gQN()) {
                Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "isRecordSelect");
                AppMethodBeat.o(35673);
                return;
            }
            gRo();
            if (com.tencent.mm.bi.d.jpA == null || !com.tencent.mm.bi.d.jpA.PZ(this.dom.GUe.field_username)) {
                if (com.tencent.mm.bh.g.jpy == null || !com.tencent.mm.bh.g.jpy.PW(this.dom.getTalkerUserName())) {
                    if (ab.Eq(this.dom.getTalkerUserName())) {
                        com.tencent.mm.bh.f aFI = ((d) g.af(d.class)).aFI(this.dom.getTalkerUserName());
                        if (aFI == null || aFI.field_wxGroupId == null || !aFI.field_wxGroupId.equals(this.dom.getTalkerUserName())) {
                            String talkerUserName = this.dom.getTalkerUserName();
                            LinkedList<com.tencent.mm.live.b.c.b> blP = q.blP(talkerUserName);
                            gRm();
                            if (!(blP == null || blP.size() <= 0 || this.OFq == null)) {
                                Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "show liveTalkRoomTipsBar, hostRoomId:%s, size:%d", talkerUserName, Integer.valueOf(blP.size()));
                                this.dom.Pwc.getController().hideActionbarLine();
                                this.OFq.setInChatRoom(z2);
                                this.OFq.setChattingContext(this.dom);
                                this.OFq.gIE();
                                ((com.tencent.mm.ui.chatting.d.b.ab) this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(1);
                            }
                        } else {
                            gRl();
                            if (this.PuC != null) {
                                Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "show multiTalkBanner! ");
                                this.PuC.setGroupUserName(this.dom.getTalkerUserName());
                                this.PuC.setCurrentSenderUserName(this.dom.gRI());
                                this.PuC.setInChatRoom(z2);
                                this.PuC.Bp(z);
                                this.PuC.setMultiTalkInfo(aFI);
                                ((com.tencent.mm.ui.chatting.d.b.ab) this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(1);
                                AppMethodBeat.o(35673);
                                return;
                            }
                        }
                        AppMethodBeat.o(35673);
                        return;
                    }
                    gRn();
                }
                AppMethodBeat.o(35673);
                return;
            }
            a(this.PuE);
            if (this.PuB == null) {
                AppMethodBeat.o(35673);
                return;
            }
            LinkedList<String> PY = com.tencent.mm.bi.d.jpA.PY(this.dom.GUe.field_username);
            String str = "";
            if (PY == null || !PY.contains(this.dom.gRI())) {
                this.PuB.gLu();
                this.PuB.stop();
                this.PuB.setBgViewResource(R.drawable.azy);
                if (PY != null && PY.size() == 1) {
                    str = this.dom.Pwc.getMMResources().getString(R.string.hra, aa.getDisplayName(PY.get(0)));
                } else if (PY != null) {
                    str = this.dom.Pwc.getMMResources().getString(R.string.hrc, Integer.valueOf(PY.size()));
                }
                this.PuB.setIconRes$255f295(this.dom.Pwc.getMMResources().getColor(R.color.Brand));
            } else {
                this.PuB.setBgViewResource(R.drawable.azy);
                str = this.dom.Pwc.getMMResources().getString(R.string.hrb);
            }
            this.PuB.updateView();
            this.PuB.jc(PY);
            this.PuB.setVisibility(0);
            this.PuB.setNavContent(str);
            ((com.tencent.mm.ui.chatting.d.b.ab) this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(1);
            AppMethodBeat.o(35673);
            return;
        }
        if (this.PuB != null) {
            this.PuB.setVisibility(8);
            this.PuB.gLv();
            ((com.tencent.mm.ui.chatting.d.b.ab) this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(-1);
        }
        if (this.PuC != null) {
            this.PuC.setInChatRoom(false);
            this.PuC.setVisibility(8);
        }
        if (this.OFq != null) {
            this.OFq.setInChatRoom(false);
            this.OFq.setVisibility(8);
            if (this.PuD != null) {
                this.PuD.setVisibility(8);
            }
            this.dom.Pwc.getController().showActionbarLine();
            ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().GZ(this.dom.getTalkerUserName());
            ((com.tencent.mm.ui.chatting.d.b.ab) this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(-1);
        }
        AppMethodBeat.o(35673);
    }

    private void gRn() {
        AppMethodBeat.i(35674);
        if (this.PuB != null) {
            this.PuB.setVisibility(8);
            this.PuB.gLv();
            this.PuB.gLu();
            this.PuB.stop();
            ((com.tencent.mm.ui.chatting.d.b.ab) this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(-1);
        }
        if (this.PuC != null) {
            if (!((d) g.af(d.class)).aFH(this.dom.getTalkerUserName())) {
                this.PuC.gJt();
            }
            this.PuC.setVisibility(8);
            ((com.tencent.mm.ui.chatting.d.b.ab) this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(-1);
        }
        if (this.OFq != null) {
            this.OFq.setVisibility(8);
            if (this.PuD != null) {
                this.PuD.setVisibility(8);
            }
            this.dom.Pwc.getController().showActionbarLine();
            if (this.PuB == null && this.PuC == null) {
                ((com.tencent.mm.ui.chatting.d.b.ab) this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).amC(-1);
            }
        }
        AppMethodBeat.o(35674);
    }

    private void gRo() {
        AppMethodBeat.i(233193);
        if (this.OFq != null) {
            this.OFq.setChattingUserName(this.dom.getTalkerUserName());
        }
        AppMethodBeat.o(233193);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.as
    public final void BU(final boolean z) {
        String string;
        int i2;
        AppMethodBeat.i(35675);
        boolean z2 = ((f) this.dom.bh(f.class)).gPi() || ((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOV();
        if (!ab.Eq(this.dom.getTalkerUserName()) || z2) {
            xq xqVar = new xq();
            xqVar.edR.edT = true;
            EventCenter.instance.publish(xqVar);
            if (!z) {
                if (com.tencent.mm.bi.d.jpA != null && com.tencent.mm.bi.d.jpA.PZ(this.dom.GUe.field_username)) {
                    LinkedList<String> PY = com.tencent.mm.bi.d.jpA.PY(this.dom.GUe.field_username);
                    if (PY == null || !PY.contains(this.dom.gRI())) {
                        string = this.dom.Pwc.getMMResources().getString(R.string.hkg);
                        i2 = R.string.e9z;
                    } else {
                        string = this.dom.Pwc.getMMResources().getString(R.string.hkf);
                        i2 = R.string.bx3;
                    }
                    h.INSTANCE.a(10997, 19, 0, 0, 0);
                    d.a aVar = new d.a(this.dom.Pwc.getContext());
                    aVar.boo(string);
                    aVar.aoV(R.string.sz).c(new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.bd.AnonymousClass8 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(35659);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(35659);
                        }
                    });
                    aVar.aoW(i2).d(new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.bd.AnonymousClass9 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(35660);
                            bd.this.bmP(z ? "fromBanner" : "fromPluginTalk");
                            AppMethodBeat.o(35660);
                        }
                    });
                    aVar.hbn().show();
                    AppMethodBeat.o(35675);
                } else if (Util.isNullOrNil(xqVar.edS.edV) || this.dom.getTalkerUserName().equals(xqVar.edS.edV)) {
                    bmQ(this.dom.getTalkerUserName());
                    AppMethodBeat.o(35675);
                } else {
                    com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.hka), (String) null, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.bd.AnonymousClass10 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(35661);
                            xq xqVar = new xq();
                            xqVar.edR.edU = true;
                            EventCenter.instance.publish(xqVar);
                            bd.a(bd.this, bd.this.dom.getTalkerUserName());
                            AppMethodBeat.o(35661);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.bd.AnonymousClass11 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(35662);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(35662);
                        }
                    });
                    AppMethodBeat.o(35675);
                }
            } else if (Util.isNullOrNil(xqVar.edS.edV) || this.dom.getTalkerUserName().equals(xqVar.edS.edV)) {
                bmQ(this.dom.getTalkerUserName());
                AppMethodBeat.o(35675);
            } else {
                if (this.PuB == null || this.PuB.getVisibility() != 0) {
                    com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.hka), (String) null, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.bd.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(35651);
                            xq xqVar = new xq();
                            xqVar.edR.edU = true;
                            EventCenter.instance.publish(xqVar);
                            bd.a(bd.this, bd.this.dom.getTalkerUserName());
                            AppMethodBeat.o(35651);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.bd.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(35652);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(35652);
                        }
                    });
                }
                AppMethodBeat.o(35675);
            }
        } else {
            com.tencent.mm.ui.base.h.c(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.hkk), null, true);
            AppMethodBeat.o(35675);
        }
    }

    private void gRp() {
        AppMethodBeat.i(35676);
        dq("fromBanner", false);
        AppMethodBeat.o(35676);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.as
    public final void dq(String str, boolean z) {
        LinkedList<String> PY;
        AppMethodBeat.i(35677);
        if (com.tencent.mm.q.a.cC(this.dom.Pwc.getContext()) || com.tencent.mm.q.a.cA(this.dom.Pwc.getContext()) || com.tencent.mm.q.a.cE(this.dom.Pwc.getContext())) {
            Log.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
            AppMethodBeat.o(35677);
        } else if (((com.tencent.mm.bi.d.jpA == null || !com.tencent.mm.bi.d.jpA.PZ(this.dom.GUe.field_username)) && !z) || ((PY = com.tencent.mm.bi.d.jpA.PY(this.dom.GUe.field_username)) != null && PY.contains(this.dom.gRI()))) {
            bmP(str);
            AppMethodBeat.o(35677);
        } else {
            h.INSTANCE.a(10997, 13, 0, 0, 0);
            this.PuB.setDialogContent(this.dom.Pwc.getMMResources().getString(R.string.bx6));
            this.PuB.N(str, PY);
            AppMethodBeat.o(35677);
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.as
    public final void bmP(String str) {
        AppMethodBeat.i(35678);
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 6);
        intent.putExtra("map_sender_name", this.dom.gRI());
        intent.putExtra("map_talker_name", this.dom.getTalkerUserName());
        intent.putExtra("fromWhereShare", str);
        com.tencent.mm.br.c.b(this.dom.Pwc.getContext(), FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent);
        AppMethodBeat.o(35678);
    }

    private void bmQ(String str) {
        AppMethodBeat.i(35679);
        Intent intent = new Intent();
        intent.putExtra("enter_room_username", str);
        intent.setFlags(268435456);
        com.tencent.mm.br.c.b(this.dom.Pwc.getContext(), "talkroom", ".ui.TalkRoomUI", intent);
        AppMethodBeat.o(35679);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35680);
        super.gOK();
        if (this.PuB != null) {
            this.PuB.stop();
        }
        AppMethodBeat.o(35680);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        AppMethodBeat.i(35681);
        Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingResume]");
        if (com.tencent.mm.bh.g.jpy != null) {
            com.tencent.mm.bh.g.jpy.a(this);
        }
        if (com.tencent.mm.bi.d.jpA != null) {
            com.tencent.mm.bi.d.jpA.a(this);
        }
        if (g.af(com.tencent.mm.plugin.multitalk.model.d.class) != null) {
            ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).a(this);
        }
        q.a(this);
        EventCenter.instance.addListener(this.qCu);
        BT(true);
        AppMethodBeat.o(35681);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(35682);
        Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingPause]");
        if (com.tencent.mm.bh.g.jpy != null) {
            com.tencent.mm.bh.g.jpy.b(this);
        }
        if (com.tencent.mm.bi.d.jpA != null) {
            com.tencent.mm.bi.d.jpA.b(this);
        }
        q.b(this);
        EventCenter.instance.removeListener(this.qCu);
        ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).b(this);
        AppMethodBeat.o(35682);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIo() {
        AppMethodBeat.i(233194);
        if (this.OFq != null) {
            this.OFq.bc(true, false);
            if (this.OFq.OFb != null) {
                q.gIG();
            }
        }
        gRn();
        AppMethodBeat.o(233194);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.as
    public final void aL(final Runnable runnable) {
        AppMethodBeat.i(35667);
        if (com.tencent.mm.bi.d.jpA == null || !com.tencent.mm.bi.d.jpA.bB(this.dom.GUe.field_username, this.dom.gRI())) {
            if (this.PuB != null) {
                TalkRoomPopupNav talkRoomPopupNav = this.PuB;
                if (talkRoomPopupNav.OWw.getVisibility() == 0) {
                    talkRoomPopupNav.Bo(false);
                    talkRoomPopupNav.OWw.setVisibility(8);
                }
            }
            if (this.PuC != null) {
                MultiTalkRoomPopupNav multiTalkRoomPopupNav = this.PuC;
                if (!(multiTalkRoomPopupNav.OJp == null || multiTalkRoomPopupNav.OJp.OJy == null || multiTalkRoomPopupNav.OJp.OJy.getVisibility() != 0)) {
                    multiTalkRoomPopupNav.OJp.close();
                    multiTalkRoomPopupNav.OJp.OJy.setVisibility(8);
                }
            }
            if (this.OFq != null) {
                LiveTalkRoomTipsBar liveTalkRoomTipsBar = this.OFq;
                if (liveTalkRoomTipsBar.OFd.getVisibility() == 0) {
                    liveTalkRoomTipsBar.bc(true, false);
                    liveTalkRoomTipsBar.OFd.setVisibility(8);
                }
            }
            runnable.run();
            AppMethodBeat.o(35667);
            return;
        }
        com.tencent.mm.ui.base.h.a((Context) this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.hr8), this.dom.Pwc.getMMResources().getString(R.string.zb), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.d.bd.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(35656);
                runnable.run();
                fo foVar = new fo();
                foVar.dIN.username = bd.this.dom.getTalkerUserName();
                EventCenter.instance.publish(foVar);
                AppMethodBeat.o(35656);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.d.bd.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(35667);
    }

    static /* synthetic */ void b(bd bdVar) {
        AppMethodBeat.i(35684);
        boolean z = ((f) bdVar.dom.bh(f.class)).gPi() || ((com.tencent.mm.ui.chatting.d.b.d) bdVar.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOV();
        if (!ab.Eq(bdVar.dom.getTalkerUserName()) || z) {
            xq xqVar = new xq();
            xqVar.edR.edT = true;
            EventCenter.instance.publish(xqVar);
            if (Util.isNullOrNil(xqVar.edS.edV) || bdVar.dom.getTalkerUserName().equals(xqVar.edS.edV)) {
                bdVar.dom.getTalkerUserName();
                bdVar.gRp();
                AppMethodBeat.o(35684);
                return;
            }
            xq xqVar2 = new xq();
            xqVar2.edR.edU = true;
            EventCenter.instance.publish(xqVar2);
            bdVar.dom.getTalkerUserName();
            bdVar.gRp();
            AppMethodBeat.o(35684);
            return;
        }
        com.tencent.mm.ui.base.h.c(bdVar.dom.Pwc.getContext(), bdVar.dom.Pwc.getMMResources().getString(R.string.hr_), null, true);
        AppMethodBeat.o(35684);
    }
}
