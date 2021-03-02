package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.a.y;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.al.i;
import com.tencent.mm.al.p;
import com.tencent.mm.api.c;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.g.a.es;
import com.tencent.mm.g.a.te;
import com.tencent.mm.g.a.w;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.msgsubscription.b.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.bizchat.BizChatroomInfoUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.viewitems.bq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.d.a.a(gRF = d.class)
public class c extends a implements p, d {
    private com.tencent.mm.api.c Bdk;
    public k BeV;
    private com.tencent.mm.ui.widget.a.d Bfe = null;
    private d.a PaQ = new d.a() {
        /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass11 */

        @Override // com.tencent.mm.al.a.d.a
        public final void a(d.a.b bVar) {
            AppMethodBeat.i(35092);
            if (c.this.tca && bVar != null && bVar.iPE == c.this.gPc()) {
                if (!c.this.dom.cQp) {
                    Log.i("MicroMsg.ChattingUI.BizComponent", "onNotifyChange fragment not foreground, return");
                    AppMethodBeat.o(35092);
                    return;
                } else if (bVar.iPO != d.a.EnumC0249a.DELETE) {
                    Log.i("MicroMsg.ChattingUI.BizComponent", "bizChatExtension bizChat change");
                    c.this.Pag = ag.baj().bs(c.this.gPc());
                    if (!c.this.PmM) {
                        k fB = ag.bal().fB(c.this.Pag.field_bizChatServId);
                        if (fB != null) {
                            c.this.BeV = fB;
                        }
                    } else {
                        c.this.PmU = e.c(c.this.Pag);
                        ((aa) c.this.dom.bh(aa.class)).gQp();
                    }
                    ((aa) c.this.dom.bh(aa.class)).gPx();
                    AppMethodBeat.o(35092);
                    return;
                } else if (c.this.PmM) {
                    Toast.makeText(MMApplicationContext.getContext(), c.this.dom.Pwc.getMMResources().getString(R.string.g75), 1).show();
                    c.this.dom.Pwc.gNh();
                }
            }
            AppMethodBeat.o(35092);
        }
    };
    public com.tencent.mm.al.a.c Pag;
    protected final ChatFooter.g PdR = new ChatFooter.g() {
        /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass10 */

        @Override // com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g
        public final boolean An(boolean z) {
            AppMethodBeat.i(35091);
            if (c.this.Bdk == null) {
                AppMethodBeat.o(35091);
                return false;
            }
            c.b cG = c.this.Bdk.cG(false);
            if (cG == null) {
                AppMethodBeat.o(35091);
                return false;
            }
            c.b.C0262c Ve = cG.Ve();
            if (Ve == null || Ve.dij == null || Ve.dij.isEmpty()) {
                AppMethodBeat.o(35091);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(Ve.dij.get(0).value);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1083;
                appBrandStatObject.dCw = c.this.Bdk.field_username;
                ((r) g.af(r.class)).a(MMApplicationContext.getContext(), jSONObject.optString("userName"), null, 0, 0, jSONObject.optString("pagePath"), appBrandStatObject, c.this.Bdk.field_appId);
                AppMethodBeat.o(35091);
                return true;
            } catch (JSONException e2) {
                AppMethodBeat.o(35091);
                return false;
            }
        }
    };
    protected final a PeP = new a() {
        /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass1 */

        @Override // com.tencent.mm.ui.chatting.d.c.a
        public final boolean gPf() {
            AppMethodBeat.i(35086);
            if (c.this.PmO == null) {
                l.a(c.this.dom.Pwc, (int) R.id.j7r);
                c.this.PmO = (RelativeLayout) c.this.dom.findViewById(R.id.a_h);
                c.this.PmP = (TextView) c.this.dom.findViewById(R.id.a_i);
                c.this.PmP.setText(R.string.aw4);
            }
            c.this.PmO.setVisibility(0);
            com.tencent.mm.ui.chatting.e.a.gRP().postDelayed(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(35085);
                    if (!(c.this.PmO == null || c.this.PmO.getVisibility() == 8)) {
                        c.this.PmO.setVisibility(8);
                    }
                    if (c.this.dom == null) {
                        Log.e("MicroMsg.ChattingUI.BizComponent", "[onProcecssClick] mChattingContext is null!");
                        AppMethodBeat.o(35085);
                        return;
                    }
                    ((aa) c.this.dom.bh(aa.class)).gPx();
                    c.this.dom.cmy();
                    AppMethodBeat.o(35085);
                }
            }, 5000);
            AppMethodBeat.o(35086);
            return true;
        }
    };
    private com.tencent.mm.app.plugin.a.a PmJ;
    private long PmK = 0;
    private ca PmL;
    public boolean PmM = false;
    private long PmN = -1;
    private RelativeLayout PmO;
    private TextView PmP;
    private int PmQ;
    private boolean PmR = false;
    private boolean PmS = false;
    private f.a PmT = new f.a() {
        /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass12 */

        @Override // com.tencent.mm.al.f.a
        public final void a(final f.a.b bVar) {
            AppMethodBeat.i(35094);
            if (bVar != null && bVar.iOh == f.a.EnumC0255a.UPDATE && bVar.iNV != null && bVar.iNV.equals(c.this.dom.getTalkerUserName())) {
                bg.aVF();
                final as Kn = com.tencent.mm.model.c.aSN().Kn(bVar.iNV);
                if (Kn == null || ((int) Kn.gMZ) == 0) {
                    Log.i("MicroMsg.ChattingUI.BizComponent", "Get contact from db return null.(username : %s)", bVar.iNV);
                    AppMethodBeat.o(35094);
                    return;
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass12.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(35093);
                        if (c.this.PmR && bVar.iNV.equals(c.this.dom.getTalkerUserName())) {
                            Log.i("MicroMsg.ChattingUI.BizComponent", "try to refresh footer.");
                            c.this.Bdk = com.tencent.mm.al.g.fJ(bVar.iNV);
                            if (c.this.dom != null && c.this.PmS) {
                                ((u) c.this.dom.bh(u.class)).au(Kn);
                            }
                        }
                        AppMethodBeat.o(35093);
                    }
                });
            }
            AppMethodBeat.o(35094);
        }
    };
    private boolean PmU = false;
    private dvm iOA = null;
    private IListener pti = new IListener<w>() {
        /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass13 */

        {
            AppMethodBeat.i(161524);
            this.__eventId = w.class.getName().hashCode();
            AppMethodBeat.o(161524);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(w wVar) {
            AppMethodBeat.i(35095);
            Log.i("MicroMsg.ChattingUI.BizComponent", "AppMsgRelatedInfoUpdateEvent scene %d", Integer.valueOf(wVar.dCO.scene));
            c.this.dom.cmy();
            AppMethodBeat.o(35095);
            return false;
        }
    };
    public boolean tca = false;

    public interface a {
        boolean gPf();
    }

    public c() {
        AppMethodBeat.i(35100);
        AppMethodBeat.o(35100);
    }

    static /* synthetic */ void f(c cVar) {
        AppMethodBeat.i(35127);
        cVar.gPe();
        AppMethodBeat.o(35127);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final com.tencent.mm.api.c gOM() {
        return this.Bdk;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final com.tencent.mm.al.a.c gON() {
        return this.Pag;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final k gOO() {
        return this.BeV;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final boolean gOP() {
        return this.tca;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final boolean gOQ() {
        return this.PmM;
    }

    public static boolean bC(Intent intent) {
        AppMethodBeat.i(35101);
        String stringExtra = intent.getStringExtra("Chat_User");
        boolean booleanExtra = intent.getBooleanExtra("key_is_biz_chat", false);
        if (!booleanExtra && stringExtra == null) {
            Log.e("MicroMsg.ChattingUI.BizComponent", "talker is null !!!");
            AppMethodBeat.o(35101);
            return true;
        } else if (!booleanExtra || intent.getLongExtra("key_biz_chat_id", -1) != -1) {
            AppMethodBeat.o(35101);
            return false;
        } else {
            Log.e("MicroMsg.ChattingUI.BizComponent", "bizChatId is null !!");
            AppMethodBeat.o(35101);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final boolean gOR() {
        AppMethodBeat.i(35102);
        if (this.tca) {
            if (this.PmM) {
                int Ar = e.Ar(gPc());
                if (!Util.isNullOrNil(this.Pag.field_chatName)) {
                    ((aa) this.dom.bh(aa.class)).setMMTitle(this.dom.Pwc.getMMResources().getString(R.string.dea, this.Pag.field_chatName, Integer.valueOf(Ar)));
                } else if (Ar == 0) {
                    this.dom.Pwc.setMMTitle(this.dom.Pwc.getMMResources().getString(R.string.b25));
                } else {
                    this.dom.Pwc.setMMTitle(this.dom.Pwc.getMMResources().getString(R.string.dea, this.dom.Pwc.getMMResources().getString(R.string.b25), Integer.valueOf(Ar)));
                }
            } else {
                this.dom.Pwc.setMMTitle(this.BeV.field_userName);
            }
            AppMethodBeat.o(35102);
            return true;
        }
        AppMethodBeat.o(35102);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final a gOS() {
        return this.PeP;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final ChatFooter.g gOT() {
        return this.PdR;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final String NI(String str) {
        AppMethodBeat.i(35103);
        k NC = this.Pag.NC(str);
        if (NC != null) {
            String str2 = NC.field_headImageUrl;
            AppMethodBeat.o(35103);
            return str2;
        }
        AppMethodBeat.o(35103);
        return null;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final List<ca> gOU() {
        int i2 = 100;
        AppMethodBeat.i(35104);
        com.tencent.mm.al.a.a Al = ag.bak().Al(gPc());
        if (Al.field_unReadCount <= 100) {
            i2 = Al.field_unReadCount;
        }
        bg.aVF();
        List<ca> s = com.tencent.mm.model.c.aSR().s(this.dom.GUe.field_username, gPc(), i2);
        AppMethodBeat.o(35104);
        return s;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final boolean gOV() {
        return this.PmU;
    }

    private void gpe() {
        int i2;
        AppMethodBeat.i(35105);
        br.I("bizflag", false);
        this.pti.dead();
        if (this.tca) {
            gPe();
            ag.bav();
            com.tencent.mm.al.a.c cVar = this.Pag;
            if (com.tencent.mm.kernel.a.qd(g.aAf().hpS)) {
                String format = String.format("%s;%s;%d", cVar.field_brandUserName, cVar.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000));
                ab.b(cVar.field_brandUserName, 8, "EnterpriseChatStatus", format);
                Log.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", format);
            }
        }
        if (this.PmK != 0) {
            i2 = ((int) (System.currentTimeMillis() - this.PmK)) / 1000;
        } else {
            i2 = 0;
        }
        if (bg.aAc()) {
            if (this.tca) {
                ag.baj().a(this.PaQ);
            }
            if (this.dom.GUe != null && this.dom.GUe.gBM()) {
                ag.bah().a(this.PmT);
            }
            if (com.tencent.mm.contact.c.oR(this.dom.GUe.field_type) && this.dom.GUe.gBM() && !com.tencent.mm.al.g.DQ(this.dom.getTalkerUserName())) {
                if (this.Bdk != null && this.Bdk.UC()) {
                    if (this.iOA == null) {
                        this.iOA = new dvm();
                    }
                    this.iOA.MWy = i2;
                    this.iOA.MWC = this.dom.Pwc.getIntExtra("Main_IndexInSessionList", 0);
                    this.iOA.MWA = this.dom.Pwc.getIntExtra("Main_UnreadCount", 0);
                    if (this.PmL != null) {
                        this.iOA.MWB = this.PmL.getType();
                        if (this.iOA.MWA > 0) {
                            this.iOA.MWz = ((int) (this.PmK - this.PmL.field_createTime)) / 1000;
                        }
                    }
                }
                ag.bat().a(this.dom.getTalkerUserName(), this.iOA);
            }
        }
        if (com.tencent.mm.app.plugin.a.a.d(this.Bdk) && this.PmJ != null) {
            Log.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s, notify exit chattingui", gOZ());
            this.PmJ.a(2, this.Bdk);
            this.dom.Pwc.setMMSubTitle((String) null);
        }
        if (com.tencent.mm.contact.c.oR(this.dom.GUe.field_type) && this.dom.GUe.gBM() && i2 != 0) {
            h.INSTANCE.a(10638, this.dom.getTalkerUserName(), Integer.valueOf(i2), Integer.valueOf(this.dom.Pwc.getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(this.dom.Pwc.getIntExtra("biz_click_item_position", 0)), Integer.valueOf(this.dom.Pwc.getIntExtra("specific_chat_from_scene", 0)), Integer.valueOf(com.tencent.mm.storage.ab.getSessionId()));
        }
        if (this.PmJ != null) {
            com.tencent.mm.app.plugin.a.a aVar = this.PmJ;
            Log.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
            if (aVar.don != null) {
                EventCenter.instance.removeListener(aVar.don);
                aVar.don = null;
                if (aVar.doq != null) {
                    aVar.doq.clear();
                }
            }
            aVar.dor = false;
            if (aVar.doo != null) {
                EventCenter.instance.removeListener(aVar.doo);
                aVar.doo = null;
            }
            this.PmJ = null;
        }
        com.tencent.mm.storage.ab.bja(null);
        this.PmK = 0;
        AppMethodBeat.o(35105);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final void gOW() {
        String string;
        AppMethodBeat.i(35106);
        if (this.Bdk == null) {
            AppMethodBeat.o(35106);
            return;
        }
        final boolean z = !com.tencent.mm.modelgeo.d.bcc() && !com.tencent.mm.modelgeo.d.bcd();
        if (this.Bdk.field_hadAlert == 0 && z) {
            string = this.dom.Pwc.getMMResources().getString(R.string.axs, this.dom.GUe.arJ());
        } else if (z) {
            string = this.dom.Pwc.getMMResources().getString(R.string.axt);
        } else {
            string = this.dom.Pwc.getMMResources().getString(R.string.axr, this.dom.GUe.arJ());
        }
        this.Bfe = com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), string, this.dom.Pwc.getMMResources().getString(R.string.zb), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass16 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(35098);
                c.this.Bdk.field_hadAlert = 1;
                com.tencent.mm.api.c cVar = c.this.Bdk;
                if (cVar != null) {
                    cVar.field_brandFlag |= 4;
                    com.tencent.mm.al.g.j(cVar);
                }
                if (z) {
                    Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                    BaseChattingUIFragment baseChattingUIFragment = c.this.dom.Pwc;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    baseChattingUIFragment.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(35098);
                    return;
                }
                ag.bat().Ns(c.this.dom.getTalkerUserName());
                AppMethodBeat.o(35098);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass17 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(35099);
                c.this.Bdk.field_hadAlert = 1;
                com.tencent.mm.api.c cVar = c.this.Bdk;
                if (cVar != null) {
                    cVar.field_brandFlag &= -5;
                    com.tencent.mm.al.g.j(cVar);
                }
                ag.bat().Ns(c.this.dom.getTalkerUserName());
                AppMethodBeat.o(35099);
            }
        });
        AppMethodBeat.o(35106);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final void gOX() {
        AppMethodBeat.i(35107);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", this.dom.getTalkerUserName());
        intent.putExtra("key_start_biz_profile_setting_from_scene", 1);
        com.tencent.mm.br.c.b(this.dom.Pwc.getContext(), Scopes.PROFILE, ".ui.newbizinfo.NewBizInfoSettingUI", intent);
        AppMethodBeat.o(35107);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final int gOY() {
        return this.PmQ;
    }

    private boolean i(KeyEvent keyEvent) {
        AppMethodBeat.i(35108);
        if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1 && (this.Bdk == null || this.Bdk.cG(false) == null || this.Bdk.cG(false).Ve() == null || this.Bdk.cG(false).Ve().dij == null || this.Bdk.cG(false).Ve().dij.isEmpty())) {
            ((u) this.dom.bh(u.class)).gPO().go(null);
        }
        AppMethodBeat.o(35108);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final String gOZ() {
        if (this.tca) {
            if (this.PmM) {
                if (this.Pag == null) {
                    return null;
                }
                return this.Pag.field_chatName;
            } else if (this.BeV != null) {
                return this.BeV.field_userName;
            } else {
                return null;
            }
        } else if (this.dom.GUe != null) {
            return this.dom.GUe.field_nickname;
        } else {
            return null;
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final boolean gPa() {
        boolean z;
        AppMethodBeat.i(35109);
        Intent intent = new Intent(this.dom.Pwc.getContext(), ChatroomInfoUI.class);
        if ((this.dom.gRL() || this.PmM) && !this.tca) {
            intent.putExtra("Chat_User", this.dom.GUe.field_username);
            intent.putExtra("RoomInfo_Id", this.dom.getTalkerUserName());
            intent.putExtra("Is_Chatroom", this.dom.gRL());
            intent.putExtra("fromChatting", true);
            com.tencent.mm.ui.chatting.e.a aVar = this.dom;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            aVar.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35109);
            return true;
        } else if (this.tca) {
            intent.setClass(this.dom.Pwc.getContext(), BizChatroomInfoUI.class);
            intent.putExtra("Chat_User", this.dom.GUe.field_username);
            intent.putExtra("key_biz_chat_id", gPc());
            if (this.dom.Pwc.thisActivity() instanceof ChattingUI) {
                intent.putExtra("key_biz_chat_info_from_scene", 1);
            } else {
                intent.putExtra("key_biz_chat_info_from_scene", 2);
            }
            BaseChattingUIFragment baseChattingUIFragment = this.dom.Pwc;
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl2.axQ(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            baseChattingUIFragment.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35109);
            return true;
        } else if (com.tencent.mm.model.ab.Jz(this.dom.getTalkerUserName()) || as.bjm(this.dom.getTalkerUserName()) || as.bjo(this.dom.getTalkerUserName()) || com.tencent.mm.model.ab.Jv(this.dom.getTalkerUserName()) || as.IG(this.dom.getTalkerUserName()) || this.dom.GUe.gBM()) {
            Intent intent2 = new Intent();
            com.tencent.mm.ui.contact.e.s(intent2, this.dom.getTalkerUserName());
            if (this.dom.Pwc.getIntExtra("chat_from_scene", 0) == 2) {
                intent2.putExtra("Kdel_from", 2);
            } else {
                intent2.putExtra("Kdel_from", 0);
            }
            intent2.putExtra("chat_from_scene", this.dom.Pwc.getIntExtra("chat_from_scene", 0));
            intent2.putExtra("preUsername", this.dom.getTalkerUserName());
            intent2.putExtra("preChatName", this.dom.getTalkerUserName());
            intent2.putExtra("preChatTYPE", this.dom.Pwc.getIntExtra("preChatTYPE", (this.Bdk == null || !this.Bdk.UC()) ? 7 : 6));
            Intent intent3 = this.dom.Pwc.getContext().getIntent();
            int intExtra = intent3.getIntExtra("key_temp_session_scene", 5);
            if (intExtra == 16 || intExtra == 17 || intent3.getBooleanExtra("key_biz_profile_stay_after_follow_op", false)) {
                intent2.putExtra("Kdel_from", 1);
                z = true;
            } else {
                z = false;
            }
            intent2.putExtra("key_biz_profile_stay_after_follow_op", z);
            if (((ae) this.dom.bh(ae.class)).gQM() && l.bmI(this.dom.getTalkerUserName())) {
                if (intExtra == 16) {
                    intent2.putExtra("Contact_Scene", 92);
                } else if (intExtra == 17) {
                    intent2.putExtra("Contact_Scene", 93);
                } else if (intExtra == 18) {
                    intent2.putExtra("Contact_Scene", 94);
                } else {
                    intent2.putExtra("Contact_Scene", 81);
                }
            }
            if (this.dom.getTalkerUserName().equals("gh_43f2581f6fd6")) {
                com.tencent.mm.plugin.sport.a.c.pl(2);
                com.tencent.mm.plugin.newtips.a.exo();
                if (com.tencent.mm.plugin.newtips.a.e.Ty(com.tencent.mm.plugin.newtips.a.d.ADd)) {
                    com.tencent.mm.plugin.newtips.a.exl();
                    i.TA(com.tencent.mm.plugin.newtips.a.d.ADd);
                    intent2.putExtra("key_from_wesport_right_newtips", true);
                }
            }
            intent2.putExtra("KOpenArticleSceneFromScene", 0);
            com.tencent.mm.br.c.b(this.dom.Pwc.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent2, 213);
            AppMethodBeat.o(35109);
            return true;
        } else {
            AppMethodBeat.o(35109);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final boolean gPb() {
        AppMethodBeat.i(35110);
        if (this.dom == null) {
            Log.e("MicroMsg.ChattingUI.BizComponent", "[writeOpLogAndMarkReadTContact] mChattingContext is null!");
            AppMethodBeat.o(35110);
            return false;
        }
        if (this.dom.GUe.gBM() && this.Bdk != null) {
            if (this.tca) {
                boolean An = ag.bak().An(gPc());
                AppMethodBeat.o(35110);
                return An;
            } else if (this.Bdk.UG()) {
                if (!(this.Bdk.cG(false) == null || this.Bdk.cG(false).Vh() == null || Util.isNullOrNil(this.Bdk.UN()))) {
                    bg.aVF();
                    az bkm = com.tencent.mm.model.c.aST().bkm(this.Bdk.UN());
                    if (bkm != null && bkm.field_username.equals(this.dom.getTalkerUserName()) && bkm.field_unReadCount > 0) {
                        if (this.dom.Pwc.getIntExtra("chat_from_scene", 0) == 2) {
                            AppMethodBeat.o(35110);
                            return false;
                        }
                        bg.aVF();
                        com.tencent.mm.model.c.aST().bka(this.Bdk.UN());
                    }
                }
            } else if (!this.Bdk.UC() && !this.Bdk.UE()) {
                if (!com.tencent.mm.storage.ab.clc()) {
                    bg.aVF();
                    az gCB = com.tencent.mm.model.c.aST().gCB();
                    if (gCB != null && gCB.field_username.equals(this.dom.getTalkerUserName()) && gCB.field_unReadCount > 0) {
                        bg.aVF();
                        com.tencent.mm.model.c.aST().bka("officialaccounts");
                    }
                } else if (ag.ban().gAR() > 0) {
                    com.tencent.mm.storage.aa ban = ag.ban();
                    ban.iFy.execSQL("BizTimeLineInfo", "update BizTimeLineInfo set hasShow = 1 where hasShow < 1  and talker = '" + this.dom.getTalkerUserName() + "' ");
                    aa.a aVar = new aa.a();
                    aVar.NQE = aa.b.UPDATE;
                    ban.a(aVar);
                }
            }
        }
        if (com.tencent.mm.model.ab.Js(this.dom.getTalkerUserName())) {
            AppMethodBeat.o(35110);
            return true;
        }
        bg.aVF();
        boolean bka = com.tencent.mm.model.c.aST().bka(this.dom.getTalkerUserName());
        AppMethodBeat.o(35110);
        return bka;
    }

    @Override // com.tencent.mm.al.p
    public final void a(int i2, q qVar) {
        AppMethodBeat.i(35111);
        if (qVar.getType() == 1357) {
            this.dom.dismissDialog();
            if (i2 != 0) {
                Toast.makeText(MMApplicationContext.getContext(), this.dom.Pwc.getMMResources().getString(R.string.g6_), 0).show();
            }
        }
        AppMethodBeat.o(35111);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final long gPc() {
        if (this.Pag == null) {
            return -1;
        }
        return this.Pag.field_bizChatLocalId;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final void gPd() {
        AppMethodBeat.i(35112);
        bg.aAk().postToWorkerDelayed(new Runnable() {
            /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(35087);
                if (c.this.dom == null) {
                    AppMethodBeat.o(35087);
                    return;
                }
                boolean isInEditMode = ((com.tencent.mm.ui.chatting.d.b.k) c.this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).isInEditMode();
                if (c.this.tca && !isInEditMode) {
                    e.d(c.this.Pag);
                }
                AppMethodBeat.o(35087);
            }
        }, 500);
        AppMethodBeat.o(35112);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final String bmE(String str) {
        c.b cG;
        AppMethodBeat.i(35113);
        if (!TextUtils.isEmpty(str) && str.contains(HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2m) + "/emoticonstore/")) {
            String substring = str.substring(str.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP) + 1);
            if (com.tencent.mm.contact.c.oR(this.dom.GUe.field_type) && this.dom.GUe.gBM() && this.Bdk != null && (cG = this.Bdk.cG(false)) != null && !TextUtils.isEmpty(cG.Vd()) && substring.contains(cG.Vd())) {
                AppMethodBeat.o(35113);
                return substring;
            }
        }
        AppMethodBeat.o(35113);
        return null;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final void bL(LinkedList<String> linkedList) {
        AppMethodBeat.i(35114);
        ag.baj().bs(gPc());
        final LinkedList<String> linkedList2 = new LinkedList<>();
        List<String> bax = this.Pag.bax();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (bax != null && bax.contains(next)) {
                linkedList2.add(next);
            }
        }
        if (linkedList2.size() != 0) {
            com.tencent.mm.ui.base.h.a((Context) this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.g6q, bM(linkedList2)), (String) null, this.dom.Pwc.getMMResources().getString(R.string.g6z), this.dom.Pwc.getMMResources().getString(R.string.sz), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(35088);
                    nw nwVar = new nw();
                    for (int i3 = 0; i3 < linkedList2.size(); i3++) {
                        nv nvVar = new nv();
                        nvVar.KTu = (String) linkedList2.get(i3);
                        nwVar.KTv.add(nvVar);
                    }
                    c.a(c.this, nwVar);
                    AppMethodBeat.o(35088);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(35114);
        } else if (linkedList.size() == 1) {
            com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.g6x), (String) null, this.dom.Pwc.getMMResources().getString(R.string.g6y), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(35114);
        } else {
            com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.g6s), (String) null, this.dom.Pwc.getMMResources().getString(R.string.g6y), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(35114);
        }
    }

    private String bM(LinkedList<String> linkedList) {
        AppMethodBeat.i(35115);
        if (linkedList.size() <= 0) {
            AppMethodBeat.o(35115);
            return null;
        }
        StringBuilder sb = new StringBuilder(this.Pag.getDisplayName(linkedList.get(0)));
        for (int i2 = 1; i2 < linkedList.size(); i2++) {
            sb.append(this.dom.Pwc.getContext().getString(R.string.awt)).append(this.Pag.getDisplayName(linkedList.get(i2)));
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(35115);
        return sb2;
    }

    private void gPe() {
        AppMethodBeat.i(35116);
        if (!this.tca) {
            AppMethodBeat.o(35116);
            return;
        }
        ag.baq();
        com.tencent.mm.al.a.h.k(this.dom.getTalkerUserName(), this.Pag.field_bizChatServId, (int) (System.currentTimeMillis() / 1000));
        AppMethodBeat.o(35116);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final long ahy() {
        return this.PmK;
    }

    @Override // com.tencent.mm.ui.l
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(35117);
        boolean i3 = i(keyEvent);
        AppMethodBeat.o(35117);
        return i3;
    }

    @Override // com.tencent.mm.ui.l
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(35118);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 12001:
                if (this.PmJ != null) {
                    com.tencent.mm.app.plugin.a.a aVar = this.PmJ;
                    if (aVar.dom != null) {
                        if (i3 != -1) {
                            if (i3 == 0) {
                                Toast.makeText(aVar.dom.Pwc.getContext(), (int) R.string.c0v, 0).show();
                                break;
                            }
                        } else {
                            Toast.makeText(aVar.dom.Pwc.getContext(), (int) R.string.c0w, 0).show();
                            es esVar = new es();
                            esVar.dIa.op = 0;
                            esVar.dIa.userName = aVar.dom.getTalkerUserName();
                            esVar.dIa.context = aVar.dom.Pwc.getContext();
                            EventCenter.instance.publish(esVar);
                            AppMethodBeat.o(35118);
                            return;
                        }
                    } else {
                        Log.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
                        AppMethodBeat.o(35118);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(35118);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        boolean z = false;
        AppMethodBeat.i(35119);
        this.PmN = this.dom.Pwc.getLongExtra("key_biz_chat_id", -1);
        this.tca = this.dom.Pwc.getBooleanExtra("key_is_biz_chat", false).booleanValue();
        Log.i("MicroMsg.ChattingUI.BizComponent", "rawBizUserid %s %s", Long.valueOf(this.PmN), Boolean.valueOf(this.tca));
        if (this.tca) {
            this.Pag = ag.baj().bs(this.PmN);
            this.Pag = e.a(this.Pag, this.PmN);
            this.PmQ = ag.bak().Al(gPc()).field_unReadCount;
        }
        if (this.tca && e.NG(this.Pag.field_bizChatServId)) {
            z = true;
        }
        this.PmM = z;
        if (this.tca && !this.PmM) {
            this.BeV = ag.bal().fB(this.Pag.field_bizChatServId);
            this.BeV = e.a(this.BeV, this.Pag.field_bizChatServId);
        }
        if (this.PmM) {
            this.PmU = e.c(this.Pag);
        }
        this.Bdk = com.tencent.mm.al.g.fJ(this.dom.getTalkerUserName());
        this.PmR = true;
        AppMethodBeat.o(35119);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35121);
        if (com.tencent.mm.contact.c.oR(this.dom.GUe.field_type) && this.dom.GUe.gBM() && com.tencent.mm.contact.c.oR(this.dom.GUe.field_type) && this.dom.GUe.gBM() && !com.tencent.mm.al.g.DQ(this.dom.getTalkerUserName())) {
            int intExtra = this.dom.Pwc.getIntExtra("specific_chat_from_scene", 0);
            if (this.iOA == null) {
                this.iOA = new dvm();
            }
            this.iOA.MWC = this.dom.Pwc.getIntExtra("Main_IndexInSessionList", 0);
            this.iOA.MWA = this.dom.Pwc.getIntExtra("Main_UnreadCount", 0);
            if (this.PmL != null) {
                this.iOA.MWB = this.PmL.getType();
                if (this.iOA.MWA > 0) {
                    this.iOA.MWz = ((int) (this.PmK - this.PmL.field_createTime)) / 1000;
                }
            }
            ag.bat().a(this.dom.getTalkerUserName(), this.PmL, intExtra, this.iOA);
        }
        if (com.tencent.mm.model.ab.Jx(this.dom.getTalkerUserName())) {
            com.tencent.f.h.RTc.e(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(232994);
                    c.h(c.this);
                    AppMethodBeat.o(232994);
                }
            }, "ReportEnterNotifyMessage");
        }
        AppMethodBeat.o(35121);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        boolean z;
        c.b cG;
        AppMethodBeat.i(35122);
        this.PmS = true;
        br.I("bizflag", ((ae) this.dom.bh(ae.class)).gQM());
        if (this.Bdk == null || com.tencent.mm.app.plugin.a.a.d(this.Bdk)) {
            Log.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, onresume: %s, notify switch view enter chattingui", gOZ());
            if (this.PmJ != null) {
                this.PmJ.a(1, this.Bdk);
            }
        }
        com.tencent.mm.api.c cVar = this.Bdk;
        if (cVar == null || cVar == null || (cG = cVar.cG(false)) == null || !cG.UP()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass14 */

                public final void run() {
                    AppMethodBeat.i(35096);
                    te teVar = new te();
                    if (c.this.Bdk != null) {
                        teVar.dZD.userName = c.this.Bdk.field_username;
                        EventCenter.instance.publish(teVar);
                    }
                    AppMethodBeat.o(35096);
                }
            });
        }
        if (com.tencent.mm.contact.c.oR(this.dom.GUe.field_type) && this.dom.GUe.gBM() && this.Bdk != null) {
            c.b cG2 = this.Bdk.cG(false);
            if (cG2 != null && cG2.UB()) {
                if (this.Bdk.field_hadAlert == 0) {
                    String string = this.dom.Pwc.getContext().getResources().getString(R.string.axu, this.dom.GUe.arJ());
                    String string2 = this.dom.Pwc.getContext().getResources().getString(R.string.axv);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("<sysmsg type=\"reportbizlocation\">");
                    stringBuffer.append("<reportbizlocation>");
                    stringBuffer.append("<text><![CDATA[").append(string).append("]]></text>");
                    stringBuffer.append("<link>");
                    stringBuffer.append("<scene>reportbizlocation</scene>");
                    stringBuffer.append("<text><![CDATA[").append(string2).append("]]></text>");
                    stringBuffer.append("</link>");
                    stringBuffer.append("</reportbizlocation>");
                    stringBuffer.append("</sysmsg>");
                    ca caVar = new ca();
                    caVar.Cy(this.dom.getTalkerUserName());
                    caVar.nv(2);
                    caVar.setType(10002);
                    caVar.setCreateTime(bp.aVP());
                    caVar.setContent(stringBuffer.toString());
                    bp.x(caVar);
                    this.Bdk.field_hadAlert = 1;
                    ag.bah().update(this.Bdk, new String[0]);
                } else {
                    ag.bat().Ns(this.dom.getTalkerUserName());
                }
            }
            if (this.Bdk.Uz() && (!this.dom.GUe.gBM() || !com.tencent.mm.al.a.aZz())) {
                ay.a.iDq.aL(this.dom.GUe.field_username, "");
                com.tencent.mm.aj.c.Mf(this.dom.GUe.field_username);
            }
            if (this.Bdk.field_status == 1) {
                this.Bdk.field_status = 0;
                ag.bah().h(this.Bdk);
            }
        } else if (!this.dom.Pwc.getBooleanExtra("key_has_add_contact", false).booleanValue() && !com.tencent.mm.contact.c.oR(this.dom.GUe.field_type) && this.dom.GUe.gBM()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass15 */

                public final void run() {
                    AppMethodBeat.i(35097);
                    if (!com.tencent.mm.contact.c.oR(c.this.dom.GUe.field_type) && c.this.dom.GUe.gBM()) {
                        c.this.dom.Pwc.setMMSubTitle(R.string.axq);
                    }
                    AppMethodBeat.o(35097);
                }
            });
        }
        gPd();
        AppMethodBeat.o(35122);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(35123);
        this.PmS = false;
        if (com.tencent.mm.contact.c.oR(this.dom.GUe.field_type) && this.dom.GUe.gBM() && this.Bdk != null) {
            ag.bat().aZU();
            if (this.Bfe != null) {
                this.Bfe.dismiss();
            }
        }
        a.C0464a aVar = com.tencent.mm.msgsubscription.b.a.jzz;
        Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo clearNotifyCallback");
        com.tencent.mm.msgsubscription.b.a.jzy.clear();
        AppMethodBeat.o(35123);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35124);
        this.PmR = false;
        gpe();
        AppMethodBeat.o(35124);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35125);
        super.gOK();
        gpe();
        AppMethodBeat.o(35125);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final boolean a(com.tencent.mm.ui.chatting.e.a aVar, bq bqVar) {
        String str;
        com.tencent.mm.plugin.appbrand.api.g gVar;
        boolean z;
        AppMethodBeat.i(232995);
        String aTY = z.aTY();
        String str2 = bqVar.userName;
        if (Util.isNullOrNil(bqVar.PQF)) {
            str = "";
        } else {
            str = bqVar.PQF;
        }
        int i2 = bqVar.iEt;
        if (com.tencent.mm.al.g.Nb(str2)) {
            Log.d("MicroMsg.ChattingUI.BizComponent", "alvinluo reportBizAvatarClick brand: %s, username: %s, kfWorker: %s, kfType: %d", str2, aTY, str, Integer.valueOf(i2));
            h.INSTANCE.a(20008, Long.valueOf(this.PmK), str2, 1, str, Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()));
        }
        if (!Util.isNullOrNil(bqVar.PQF) && !Util.isNullOrNil(bqVar.userName) && ag.bai() != null && ag.bai().sP(bqVar.iEt)) {
            com.tencent.mm.al.i bai = ag.bai();
            String str3 = bqVar.userName;
            String str4 = bqVar.PQF;
            int i3 = bqVar.iEt;
            Log.i("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle username: %s, brandUsername: %s, kfOpenId: %s, kfType: %d", aTY, str3, str4, Integer.valueOf(i3));
            if (bai.sP(i3)) {
                i.a aVar2 = bai.iOj;
                if (Util.isNullOrNil(aVar2.appId) || aVar2.path == null) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    gVar = new com.tencent.mm.plugin.appbrand.api.g();
                    gVar.appId = bai.iOj.appId;
                    gVar.iOo = (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) ? bai.iOj.iOo : 0;
                    gVar.scene = 1166;
                    gVar.dCw = str3;
                    Uri.Builder buildUpon = Uri.parse(bai.iOj.path).buildUpon();
                    buildUpon.appendQueryParameter(ch.COL_USERNAME, aTY);
                    buildUpon.appendQueryParameter("brandUsername", str3);
                    buildUpon.appendQueryParameter("kfOpenId", str4);
                    buildUpon.appendQueryParameter("kfType", String.valueOf(i3));
                    gVar.kHw = buildUpon.build().toString();
                    Log.v("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle enterPath: %s", gVar.kHw);
                    if (!(gVar == null || aVar.Pwc.getContext() == null)) {
                        ((r) g.af(r.class)).a(aVar.Pwc.getContext(), gVar);
                        AppMethodBeat.o(232995);
                        return true;
                    }
                }
            }
            gVar = null;
            ((r) g.af(r.class)).a(aVar.Pwc.getContext(), gVar);
            AppMethodBeat.o(232995);
            return true;
        }
        AppMethodBeat.o(232995);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.d
    public final void ha(String str, int i2) {
        ca caVar;
        int i3;
        String aTY;
        AppMethodBeat.i(232996);
        if (!Util.isNullOrNil(str) && com.tencent.mm.al.g.Nb(str)) {
            com.tencent.mm.ui.chatting.d.b.k kVar = (com.tencent.mm.ui.chatting.d.b.k) this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class);
            if (kVar.getCount() > 0) {
                caVar = kVar.amt(kVar.getCount() - 1);
            } else {
                caVar = null;
            }
            if (caVar == null) {
                i3 = 1;
            } else if (caVar.getType() == 285212721) {
                i3 = 2;
            } else if (caVar.getType() == 318767153) {
                i3 = 5;
            } else {
                if (!Util.isNullOrNil(caVar.fQZ)) {
                    if (caVar.fRf == 1) {
                        i3 = 3;
                    } else if (caVar.fRf == 2) {
                        i3 = 4;
                    }
                }
                i3 = 0;
            }
            if (caVar == null) {
                aTY = "";
            } else if (!Util.isNullOrNil(caVar.fQZ)) {
                aTY = caVar.fQZ;
            } else if (caVar.field_isSend == 0) {
                aTY = caVar.field_talker;
            } else {
                aTY = z.aTY();
            }
            Log.d("MicroMsg.ChattingUI.BizComponent", "alvinluo onFooterSwitchInput talker: %s, switchType: %d, lastMsgType: %d, sender: %s", str, Integer.valueOf(i2), Integer.valueOf(i3), aTY);
            h.INSTANCE.a(20018, Long.valueOf(this.PmK), str, Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i3), aTY, 1);
        }
        AppMethodBeat.o(232996);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(35120);
        this.PmK = System.currentTimeMillis();
        com.tencent.mm.ui.chatting.d.b.k kVar = (com.tencent.mm.ui.chatting.d.b.k) this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class);
        this.PmL = kVar.getCount() > 0 ? kVar.amt(kVar.getCount() - 1) : null;
        com.tencent.mm.storage.ab.bja(this.dom.getTalkerUserName());
        this.dom.Pwc.getLongExtra("key_biz_chat_id", -1);
        if (this.tca) {
            Log.d("MicroMsg.ChattingUI.BizComponent", "getBizChatInfo");
            bg.aAk().postToWorkerDelayed(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(35090);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!c.this.tca || c.this.Pag == null || c.this.dom.GUe == null) {
                        Log.i("MicroMsg.ChattingUI.BizComponent", "bizChatInfo:%s  talker:%s", c.this.Pag, c.this.dom.GUe);
                    } else {
                        c.f(c.this);
                        ag.bav();
                        com.tencent.mm.al.a.c cVar = c.this.Pag;
                        if (com.tencent.mm.kernel.a.qd(g.aAf().hpS)) {
                            String format = String.format("%s;%s;%d", cVar.field_brandUserName, cVar.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000));
                            ab.b(cVar.field_brandUserName, 7, "EnterpriseChatStatus", format);
                            Log.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", format);
                        }
                        if (c.this.PmM) {
                            if (c.this.Pag.bay()) {
                                ag.baq();
                                com.tencent.mm.al.a.h.bn(c.this.Pag.field_bizChatServId, c.this.dom.GUe.field_username);
                            } else {
                                e.f(c.this.Pag);
                            }
                        }
                        c.g(c.this);
                    }
                    Log.d("MicroMsg.ChattingUI.BizComponent", "willen test  updateBizChatInfo use time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(35090);
                }
            }, 500);
        }
        if (this.dom.GUe != null && this.dom.GUe.gBM()) {
            ag.bau().MN(this.dom.GUe.field_username);
        }
        this.pti.alive();
        this.PmN = this.dom.Pwc.getLongExtra("key_biz_chat_id", -1);
        if (com.tencent.mm.app.plugin.a.a.d(this.Bdk) && this.PmJ == null) {
            Log.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s", gOZ());
            this.PmJ = new com.tencent.mm.app.plugin.a.a(this.dom);
        }
        if (this.dom.GUe.gBM()) {
            com.tencent.mm.bg.d.chatType = 2;
        }
        if (this.tca) {
            ag.baj().a(this.PaQ, Looper.getMainLooper());
        }
        if (this.dom.GUe != null && this.dom.GUe.gBM()) {
            ag.bah().a(this.PmT, Looper.getMainLooper());
        }
        AppMethodBeat.o(35120);
    }

    static /* synthetic */ void a(c cVar, nw nwVar) {
        AppMethodBeat.i(35126);
        Log.i("MicroMsg.ChattingUI.BizComponent", "updateBizChatMemberList()");
        String string = cVar.dom.Pwc.getMMResources().getString(R.string.g6m);
        ag.baq();
        final y a2 = com.tencent.mm.al.a.h.a(cVar.Pag.field_brandUserName, cVar.Pag.field_bizChatServId, null, nwVar, cVar);
        cVar.dom.b(cVar.dom.Pwc.getContext(), cVar.dom.Pwc.getMMResources().getString(R.string.zb), string, new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.chatting.d.c.AnonymousClass7 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(35089);
                bg.azz().a(a2);
                AppMethodBeat.o(35089);
            }
        });
        AppMethodBeat.o(35126);
    }

    static /* synthetic */ void g(c cVar) {
        boolean z = true;
        AppMethodBeat.i(35128);
        if (!cVar.tca || cVar.Pag == null || Util.isNullOrNil(cVar.Pag.field_brandUserName)) {
            AppMethodBeat.o(35128);
            return;
        }
        String fC = ag.bal().fC(cVar.Pag.field_brandUserName);
        k fB = ag.bal().fB(fC);
        Object[] objArr = new Object[3];
        objArr[0] = cVar.Pag.field_brandUserName;
        objArr[1] = fC;
        if (fB != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        Log.i("MicroMsg.ChattingUI.BizComponent", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", objArr);
        if (Util.isNullOrNil(fC) || fB == null || fB.bay() || Util.isNullOrNil(fB.field_addMemberUrl)) {
            ag.baq();
            com.tencent.mm.al.a.h.a(cVar.Pag.field_brandUserName, cVar);
        }
        AppMethodBeat.o(35128);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void h(com.tencent.mm.ui.chatting.d.c r14) {
        /*
        // Method dump skipped, instructions count: 174
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.c.h(com.tencent.mm.ui.chatting.d.c):void");
    }
}
