package com.tencent.mm.ui.chatting.d;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.AbsListView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.l;
import com.tencent.mm.av.q;
import com.tencent.mm.ba.f;
import com.tencent.mm.bg.d;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.y;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.fav.b.c.a;
import com.tencent.mm.plugin.i.a.n;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.d.b.ak;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.chatting.d.b.h;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.viewitems.bd;
import com.tencent.mm.ui.chatting.viewitems.bf;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.LinkedList;
import java.util.List;

@a(gRF = ae.class)
@Deprecated
public class al extends a implements ae {
    private List<ca> Psg;
    private int Psh;
    private String Psi;
    private boolean Psj = false;
    private ac Psk = null;

    @Override // com.tencent.mm.ui.l
    public final void onActivityResult(int i2, int i3, Intent intent) {
        Cursor cursor = null;
        AppMethodBeat.i(35479);
        super.onActivityResult(i2, i3, intent);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Boolean.valueOf(intent == null);
        objArr[2] = this.dom.getTalkerUserName();
        Log.i("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ", objArr);
        switch (i2) {
            case 211:
                if (i3 == -1) {
                    Uri data = intent.getData();
                    if (this.dom != null) {
                        cursor = this.dom.Pwc.getContext().managedQuery(data, null, null, null, null);
                    }
                    if (cursor.moveToFirst()) {
                        Intent intent2 = new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(cursor.getString(cursor.getColumnIndexOrThrow("_id"))))));
                        BaseChattingUIFragment baseChattingUIFragment = this.dom.Pwc;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                        com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "doActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        baseChattingUIFragment.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "doActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    AppMethodBeat.o(35479);
                    return;
                }
                break;
            case 212:
            default:
                Log.e("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult: not found this requestCode");
                break;
            case 213:
                if (intent != null && intent.getBooleanExtra("_delete_ok_", false)) {
                    this.dom.Pwc.gNh();
                    AppMethodBeat.o(35479);
                    return;
                }
        }
        AppMethodBeat.o(35479);
    }

    @Override // com.tencent.mm.ui.l
    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(35480);
        super.onScrollStateChanged(absListView, i2);
        if (i2 == 0) {
            yh yhVar = new yh();
            yhVar.eeC.type = 5;
            yhVar.eeC.eeD = this.dom.getFirstVisiblePosition();
            yhVar.eeC.eeE = this.dom.getLastVisiblePosition();
            yhVar.eeC.eeF = this.dom.getHeaderViewsCount();
            EventCenter.instance.publish(yhVar);
        }
        AppMethodBeat.o(35480);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35481);
        super.gOK();
        bg.aVF();
        if (c.azn()) {
            ab.av(this.dom.getTalkerUserName(), 5);
        }
        AppMethodBeat.o(35481);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ae
    public final List<ca> gQL() {
        return this.Psg;
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        int i2;
        AppMethodBeat.i(35483);
        b alj = b.alj();
        String talkerUserName = this.dom.getTalkerUserName();
        if (!Util.isNullOrNil(talkerUserName)) {
            alj.gor.remove(talkerUserName);
        }
        if (this.dom.gRM()) {
            d.chatType = 1;
        } else {
            d.chatType = 0;
        }
        if (this.Psg != null) {
            this.Psg.clear();
        }
        if (((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()) {
            this.Psg = ((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOU();
        } else if (((h) this.dom.bh(h.class)).gPu()) {
            int min = Math.min(100, ((n) g.af(n.class)).avf(this.dom.getTalkerUserName()));
            if (min > 0) {
                bg.aVF();
                this.Psg = c.aSQ().ex(this.dom.getTalkerUserName(), min);
            }
        } else if (((i) this.dom.bh(i.class)).gPw()) {
            int min2 = Math.min(100, ((com.tencent.mm.plugin.gamelife.a.c) g.af(com.tencent.mm.plugin.gamelife.a.c.class)).avf(this.dom.getTalkerUserName()));
            if (min2 > 0) {
                bg.aVF();
                this.Psg = c.aSQ().ex(this.dom.getTalkerUserName(), min2);
            }
        } else {
            bg.aVF();
            az bjY = c.aST().bjY(this.dom.getTalkerUserName());
            if (bjY != null && bjY.field_unReadCount > 0) {
                if (bjY.field_unReadCount > 100) {
                    i2 = 100;
                } else {
                    i2 = bjY.field_unReadCount;
                }
                if (i2 > 0) {
                    bg.aVF();
                    this.Psg = c.aSQ().ex(this.dom.getTalkerUserName(), i2);
                }
            }
        }
        if (this.Psg == null) {
            this.Psg = new LinkedList();
        }
        this.Psh = this.Psg.size();
        AppMethodBeat.o(35483);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35484);
        yh yhVar = new yh();
        yhVar.eeC.type = 4;
        EventCenter.instance.publish(yhVar);
        if (this.dom != null) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                /* class com.tencent.mm.ui.chatting.d.al.AnonymousClass2 */

                public final boolean queueIdle() {
                    AppMethodBeat.i(233141);
                    Looper.myQueue().removeIdleHandler(this);
                    if (al.this.dom == null) {
                        AppMethodBeat.o(233141);
                    } else {
                        Log.i("MicroMsg.ChattingUI.MessBoxComponent", "now try to activity the tools process");
                        com.tencent.mm.cr.d.hiy();
                        AppMethodBeat.o(233141);
                    }
                    return false;
                }
            });
        }
        ot otVar = new ot();
        otVar.dUN.talker = this.dom.getTalkerUserName();
        EventCenter.instance.publish(otVar);
        bg.aVF();
        if (c.azn()) {
            ab.av(this.dom.getTalkerUserName(), 2);
        }
        if (com.tencent.matrix.b.isInstalled() && this.dom.Pwc.getActivity() != null) {
            this.Psi = com.tencent.matrix.a.INSTANCE.cPE;
            com.tencent.matrix.a.INSTANCE.eg(this.dom.Pwc.getActivity().getClass().getName() + "#" + this.dom.Pwc.getClass().getSimpleName());
        }
        AppMethodBeat.o(35484);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ae
    public final int aqG() {
        return this.Psh;
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        AppMethodBeat.i(35485);
        com.tencent.mm.pluginsdk.wallet.h.setPayChannel(6);
        yh yhVar = new yh();
        yhVar.eeC.type = 0;
        if (this.dom != null) {
            yhVar.eeC.eeF = this.dom.getHeaderViewsCount();
            yhVar.eeC.eeD = this.dom.getFirstVisiblePosition();
            yhVar.eeC.eeE = this.dom.getLastVisiblePosition();
        }
        EventCenter.instance.publish(yhVar);
        MMEntryLock.lock("keep_chatting_silent" + this.dom.getTalkerUserName());
        bg.getNotification().CY(this.dom.getTalkerUserName());
        MMAppMgr.Xc();
        AppMethodBeat.o(35485);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(35486);
        yh yhVar = new yh();
        yhVar.eeC.type = 1;
        EventCenter.instance.publish(yhVar);
        bg.getNotification().CY("");
        MMEntryLock.unlock("keep_app_silent");
        MMEntryLock.unlock("keep_chatting_silent" + this.dom.getTalkerUserName());
        AppMethodBeat.o(35486);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35487);
        Log.i("MicroMsg.ChattingUI.MessBoxComponent", "[onChattingExitAnimStart]");
        yh yhVar = new yh();
        yhVar.eeC.type = 3;
        EventCenter.instance.publish(yhVar);
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.ui.chatting.d.al.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(233140);
                bg.aVF();
                az bjY = c.aST().bjY(al.this.dom.getTalkerUserName());
                if (bjY != null) {
                    bg.aVF();
                    c.aST().a(al.this.dom.getTalkerUserName(), TPMediaCodecProfileLevel.HEVCHighTierLevel62, false, bjY.field_attrflag);
                }
                AppMethodBeat.o(233140);
            }
        });
        if (com.tencent.matrix.b.isInstalled()) {
            com.tencent.matrix.a.INSTANCE.eg(this.Psi);
        }
        AppMethodBeat.o(35487);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ae
    public final boolean gQM() {
        return this.Psj;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ae
    public final void a(MenuItem menuItem, com.tencent.mm.ui.chatting.viewitems.c cVar) {
        String str;
        final String str2;
        final String str3;
        final String str4;
        String str5;
        boolean z;
        String str6;
        int P;
        boolean z2;
        AppMethodBeat.i(35488);
        final ca amt = ((k) this.dom.bh(k.class)).amt(menuItem.getGroupId());
        if (amt == null) {
            Log.e("MicroMsg.ChattingUI.MessBoxComponent", "context item select failed, null msg");
            AppMethodBeat.o(35488);
        } else if (cVar instanceof com.tencent.mm.ui.chatting.viewitems.d) {
            Log.i("MicroMsg.ChattingUI.MessBoxComponent", "appbrand notify item long click, skip");
            AppMethodBeat.o(35488);
        } else {
            ((af) this.dom.bh(af.class)).h(menuItem);
            switch (menuItem.getItemId()) {
                case 100:
                    com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getContext().getString(R.string.b91), "", this.dom.Pwc.getContext().getString(R.string.blj), this.dom.Pwc.getContext().getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.al.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(233142);
                            if (amt.cWJ()) {
                                m.bds(amt.field_imgPath);
                            }
                            bp.Ad(amt.field_msgId);
                            if (amt.dOQ()) {
                                com.tencent.mm.modelstat.b.jmd.d(amt, l.t(amt));
                            } else {
                                com.tencent.mm.modelstat.b.jmd.ad(amt);
                            }
                            Log.i("MicroMsg.ChattingUI.MessBoxComponent", "delete msg, id:%d", Long.valueOf(amt.field_msgId));
                            if (!al.this.dom.getTalkerUserName().equals("medianote")) {
                                bg.aVF();
                                c.aSM().d(new f(amt.field_talker, amt.field_msgSvrId));
                            }
                            if (amt.field_status == 1 && amt.field_isSend == 1) {
                                Log.d("MicroMsg.ChattingUI.MessBoxComponent", "delete a sending msg, publish SendMsgFailEvent");
                                tx txVar = new tx();
                                txVar.ear.dCM = amt;
                                EventCenter.instance.publish(txVar);
                            }
                            AppMethodBeat.o(233142);
                        }
                    }, (DialogInterface.OnClickListener) null, (int) R.color.cd);
                    AppMethodBeat.o(35488);
                    return;
                case 114:
                    if (amt.isText()) {
                        an.m(bp.b(this.dom.gRM(), amt.field_content, amt.field_isSend), this.dom.Pwc.getContext());
                    } else if (amt.gAy()) {
                        an.b(amt, this.dom.Pwc.getContext());
                    } else if (amt.gAz()) {
                        an.a(amt, this.dom.Pwc.getContext(), cVar.a(this.dom, amt), this.dom.gRM());
                    } else if (amt.cWJ()) {
                        an.c(amt, this.dom.Pwc.getContext());
                    } else if (amt.dOS()) {
                        an.n(amt.field_content, this.dom.Pwc.getContext());
                    } else if (amt.gDl()) {
                        an.o(amt.field_content, this.dom.Pwc.getContext());
                    }
                    Log.i("MicroMsg.ChattingUI.MessBoxComponent", "type is %d", Integer.valueOf(amt.getType()));
                    AppMethodBeat.o(35488);
                    return;
                case 116:
                    if (!ac.bB(amt)) {
                        com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getContext().getString(R.string.fim), "", this.dom.Pwc.getContext().getString(R.string.j34), (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(35488);
                        return;
                    } else if (!bf.a(this.dom, amt, R.string.avv) && !bf.b(this.dom, amt, R.string.avt)) {
                        com.tencent.mm.plugin.fav.b.c.a aVar = new com.tencent.mm.plugin.fav.b.c.a(((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP(), this.dom.gRL(), this.dom.getTalkerUserName(), amt, new a.AbstractC1044a() {
                            /* class com.tencent.mm.ui.chatting.d.al.AnonymousClass6 */

                            @Override // com.tencent.mm.plugin.fav.b.c.a.AbstractC1044a
                            public final void cVq() {
                                AppMethodBeat.i(233144);
                                al.this.dom.hideVKB();
                                AppMethodBeat.o(233144);
                            }
                        });
                        if (this.Psk == null) {
                            this.Psk = new ac();
                        }
                        this.Psk.a(this.dom.Pwc, this.dom.Pwc.getContext(), aVar);
                        if ((cVar instanceof bd.a) || (cVar instanceof bd.b)) {
                            if (amt != null && (P = br.P(amt)) > 0) {
                                ga gaVar = new ga();
                                int i2 = 1;
                                if (com.tencent.mm.model.ab.Eq(amt.field_talker) || com.tencent.mm.model.ab.Iy(amt.field_talker)) {
                                    i2 = 2;
                                }
                                int i3 = 0;
                                if (amt.field_isSend == 1) {
                                    i3 = 1;
                                }
                                gaVar.eHz = amt.field_msgSvrId;
                                gaVar.erW = (long) i2;
                                gaVar.eIq = (long) i3;
                                gaVar.erY = (long) P;
                                gaVar.ejA = 5;
                                gaVar.eIr = 0;
                                gaVar.bfK();
                            }
                            AppMethodBeat.o(35488);
                            return;
                        }
                    }
                case 122:
                    ((com.tencent.mm.ui.chatting.d.b.l) this.dom.bh(com.tencent.mm.ui.chatting.d.b.l.class)).bV(amt);
                    AppMethodBeat.o(35488);
                    return;
                case 123:
                    Log.d("MicroMsg.ChattingUI.MessBoxComponent", "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d", Integer.valueOf(amt.getType()), Integer.valueOf(menuItem.getGroupId()));
                    if (amt.gDp()) {
                        String str7 = amt.field_content;
                        if (str7 != null) {
                            k.b aD = k.b.aD(str7, amt.field_reserved);
                            if (aD != null) {
                                if (((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).curLiveId() == Long.parseLong(((y) aD.as(y.class)).hJs)) {
                                    ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).forceStopCurLive(this.dom.Pwc.getContext());
                                }
                            }
                        } else {
                            Log.e("MicroMsg.ChattingUI.MessBoxComponent", "deal revoke live xml is null, msgid:%s", Long.valueOf(amt.field_msgId));
                        }
                    }
                    ((ak) this.dom.bh(ak.class)).ce(amt);
                    AppMethodBeat.o(35488);
                    return;
                case 129:
                    k.b HD = k.b.HD(bp.b(this.dom.gRM(), amt.field_content, amt.field_isSend));
                    boolean z3 = true;
                    if (HD == null || !(HD.type == 6 || HD.type == 2)) {
                        if (amt.gAz()) {
                            q.bcR();
                            if (Util.isNullOrNil(com.tencent.mm.av.i.W(amt))) {
                                z2 = false;
                            }
                        }
                        z2 = true;
                    } else {
                        com.tencent.mm.pluginsdk.model.app.c bdx = ao.cgO().bdx(HD.dCK);
                        if (bdx == null || !s.YS(bdx.field_fileFullPath)) {
                            z3 = false;
                        }
                        z2 = z3;
                    }
                    if (!((av) this.dom.bh(av.class)).h(amt, z2)) {
                        com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.bir), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.d.al.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        }, (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(35488);
                        return;
                    }
                    Intent intent = new Intent(this.dom.Pwc.getContext(), ChattingSendDataToDeviceUI.class);
                    intent.putExtra("exdevice_open_scene_type", 1);
                    intent.putExtra("Retr_Msg_Id", amt.field_msgId);
                    BaseChattingUIFragment baseChattingUIFragment = this.dom.Pwc;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    baseChattingUIFragment.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(35488);
                    return;
                case r.CTRL_INDEX:
                    ((u) this.dom.bh(u.class)).aT(amt);
                    AppMethodBeat.o(35488);
                    return;
                case 137:
                    if (WeChatBrands.Business.Entries.ContextSearch.checkAvailable(this.dom.Pwc.getContext())) {
                        if (!amt.isText() && !amt.gDy() && !amt.gDq()) {
                            if (amt.gAz()) {
                                o oVar = new o();
                                oVar.dGf = 1;
                                oVar.dTX = amt;
                                oVar.context = this.dom.Pwc.getContext();
                                ((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(oVar);
                                break;
                            }
                        } else {
                            boolean Eq = com.tencent.mm.model.ab.Eq(amt.field_talker);
                            if (Eq) {
                                str = bp.Kq(amt.field_content);
                            } else {
                                str = amt.field_content;
                            }
                            if (amt.gDq() || amt.gDy()) {
                                k.b HD2 = k.b.HD(str);
                                if (HD2 != null) {
                                    str6 = HD2.title;
                                } else {
                                    str6 = "";
                                }
                                str2 = str6;
                            } else {
                                str2 = str;
                            }
                            if (Util.isNullOrNil(str2)) {
                                AppMethodBeat.o(35488);
                                return;
                            }
                            final String Nj = com.tencent.mm.plugin.fts.a.d.Nj(34);
                            final int i4 = this.dom.gRL() ? 2 : 1;
                            if (this.dom.gRL()) {
                                str3 = this.dom.getTalkerUserName();
                            } else {
                                str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            }
                            if (amt.field_isSend != 0) {
                                str4 = this.dom.gRI();
                            } else if (Eq) {
                                str4 = bp.Ks(amt.field_content);
                            } else {
                                str4 = amt.field_talker;
                            }
                            final String sb = new StringBuilder().append(amt.field_msgSvrId).toString();
                            final String wordBankVersionForStat = ((com.tencent.mm.plugin.box.d) g.ah(com.tencent.mm.plugin.box.d.class)).getWordBankVersionForStat();
                            if (((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {
                                str5 = ((com.tencent.mm.plugin.box.d) g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(str2);
                            } else {
                                str5 = "";
                            }
                            if (!Util.isNullOrNil(str5)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            final int searchDuration = ((com.tencent.mm.plugin.box.d) g.ah(com.tencent.mm.plugin.box.d.class)).getSearchDuration();
                            if (z) {
                                com.tencent.f.h.RTc.aX(new Runnable() {
                                    /* class com.tencent.mm.ui.chatting.d.al.AnonymousClass5 */

                                    public final void run() {
                                        AppMethodBeat.i(233143);
                                        ar.a(2, Nj, 34, 1, ((com.tencent.mm.plugin.box.d) g.ah(com.tencent.mm.plugin.box.d.class)).checkAllHotWords(str2), wordBankVersionForStat, sb, i4, str3, (long) searchDuration, (long) str2.length());
                                        AppMethodBeat.o(233143);
                                    }
                                });
                            } else {
                                ar.a(2, Nj, 34, 0, "", wordBankVersionForStat, sb, i4, str3, (long) searchDuration, (long) str2.length());
                            }
                            ag agVar = new ag();
                            agVar.context = this.dom.Pwc.getContext();
                            agVar.scene = 34;
                            agVar.query = str2;
                            agVar.sessionId = Nj;
                            agVar.IEk = true;
                            agVar.IEl = true;
                            agVar.IEm = true;
                            agVar.IEn = 1;
                            agVar.statusBarColor = com.tencent.mm.cb.a.n(this.dom.Pwc.getContext(), R.color.afz);
                            agVar.IEo = true;
                            agVar.dVU.put("chatSearch", "1");
                            if (z) {
                                String exposedFingerWord = ((com.tencent.mm.plugin.box.d) g.ah(com.tencent.mm.plugin.box.d.class)).getExposedFingerWord(str5);
                                String matchedFingerWord = ((com.tencent.mm.plugin.box.d) g.ah(com.tencent.mm.plugin.box.d.class)).getMatchedFingerWord(str5, str2);
                                if (!TextUtils.isEmpty(exposedFingerWord)) {
                                    agVar.IEt.put("exposedFingerWord", exposedFingerWord);
                                }
                                if (!TextUtils.isEmpty(matchedFingerWord)) {
                                    agVar.IEt.put("matchedFingerWord", matchedFingerWord);
                                }
                            }
                            ((com.tencent.mm.plugin.websearch.api.h) g.af(com.tencent.mm.plugin.websearch.api.h.class)).a(agVar);
                            AppMethodBeat.o(35488);
                            return;
                        }
                    }
                    break;
                case 150:
                    Intent intent2 = new Intent();
                    intent2.setClassName(this.dom.Pwc.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                    intent2.putExtra("app_msg_id", amt.field_msgId);
                    intent2.putExtra("choose_way", true);
                    BaseChattingUIFragment baseChattingUIFragment2 = this.dom.Pwc;
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment2, bl2.axQ(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    baseChattingUIFragment2.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment2, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(35488);
                    return;
            }
            AppMethodBeat.o(35488);
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ae
    public final boolean bmN(String str) {
        boolean z = true;
        AppMethodBeat.i(35489);
        Log.i("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] username:%s isTContact:%s thread name:%s", str, Boolean.valueOf(as.bjm(str)), Thread.currentThread().getName());
        if (!g.aAf().azp()) {
            Log.w("MicroMsg.ChattingUI.MessBoxComponent", "account not init.");
            AppMethodBeat.o(35489);
            return false;
        } else if (as.bjm(str) || this.dom == null) {
            bg.aVF();
            Cursor aEH = c.aSQ().aEH(str);
            if (aEH.getCount() <= 0) {
                z = false;
            }
            aEH.close();
            if (z) {
                bg.aVF();
                c.aST().bka(str);
                bg.aVF();
                c.aSQ().aEF(str);
            }
            AppMethodBeat.o(35489);
            return z;
        } else {
            com.tencent.mm.ui.chatting.d.b.d dVar = (com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class);
            if (dVar == null) {
                Log.e("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] ");
                AppMethodBeat.o(35489);
                return false;
            }
            boolean gPb = dVar.gPb();
            AppMethodBeat.o(35489);
            return gPb;
        }
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(35482);
        this.Psj = this.dom.Pwc.getBooleanExtra("key_is_temp_session", false).booleanValue();
        if (this.Psj) {
            bg.azz().a(new com.tencent.mm.modelsimple.k(this.dom.getTalkerUserName(), this.dom.Pwc.getIntExtra("key_temp_session_scene", 5), this.dom.Pwc.getStringExtra("key_temp_session_from"), null), 0);
        }
        if (!this.dom.GUe.gBM() || com.tencent.mm.contact.c.oR(this.dom.GUe.field_type)) {
            this.Psj = false;
        } else {
            bg.aVF();
            az bjY = c.aST().bjY(this.dom.getTalkerUserName());
            if (bjY == null) {
                if (this.Psj) {
                    az azVar = new az(this.dom.getTalkerUserName());
                    azVar.oT(4194304);
                    azVar.gCr();
                    bg.aVF();
                    c.aST().e(azVar);
                }
            } else if (bjY.oV(4194304)) {
                this.Psj = true;
            } else if (bjY.field_conversationTime < com.tencent.mm.al.ag.baw()) {
                bg.aVF();
                Log.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a old version temp session, Set attr flag(talker : %s), %s", this.dom.getTalkerUserName(), Boolean.valueOf(c.aST().a(this.dom.getTalkerUserName(), 4194304, true, bjY.field_attrflag)));
                this.Psj = true;
            } else if (this.Psj) {
                bg.aVF();
                Log.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a temp session, Set attr flag(talker : %s), %s", this.dom.getTalkerUserName(), Boolean.valueOf(c.aST().a(this.dom.getTalkerUserName(), 4194304, true, bjY.field_attrflag)));
            }
        }
        Log.d("MicroMsg.ChattingUI.MessBoxComponent", "is temp session : %s.", Boolean.valueOf(this.Psj));
        AppMethodBeat.o(35482);
    }
}
