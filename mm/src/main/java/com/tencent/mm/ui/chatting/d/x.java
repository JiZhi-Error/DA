package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.m;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.k;
import com.tencent.mm.api.c;
import com.tencent.mm.emoji.b.c.f;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.g.b.a.jy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.a;
import com.tencent.mm.pluginsdk.ui.chat.m;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.ab;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.d.b.t;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.d.b.y;
import com.tencent.mm.ui.chatting.i;
import com.tencent.mm.ui.chatting.i.b;
import com.tencent.mm.ui.chatting.q;
import com.tencent.mm.ui.chatting.w;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.d.a.a(gRF = u.class)
public class x extends a implements MStorage.IOnStorageChange, MStorageEx.IOnStorageChange, u {
    private static ArrayList<a.C2027a> PpE = null;
    private static long PpF = 0;
    private final ChatFooter.g KiE = new ChatFooter.g() {
        /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass12 */
        private Animation PpW;
        private Animation PpX;

        @Override // com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g
        public final boolean An(boolean z) {
            int i2 = 1;
            AppMethodBeat.i(35305);
            if (this.PpW == null) {
                this.PpW = AnimationUtils.loadAnimation(x.this.dom.Pwc.getContext(), R.anim.dq);
                this.PpX = AnimationUtils.loadAnimation(x.this.dom.Pwc.getContext(), R.anim.f6do);
            }
            if (z) {
                Log.i("MicroMsg.ChattingUI.FootComponent", "switchFooterToInput customFooter is %s", x.this.PpH);
                if (x.this.PpH != null) {
                    x.this.PpH.startAnimation(this.PpX);
                }
                x.this.gPU();
                x.this.znD.startAnimation(this.PpW);
                x.this.znD.postInvalidateDelayed(this.PpW.getDuration());
            } else {
                x.this.znD.startAnimation(this.PpX);
                x.this.gPT();
                if (x.this.PpH != null) {
                    x.this.PpH.startAnimation(this.PpW);
                    x.this.PpH.postInvalidateDelayed(this.PpW.getDuration());
                }
            }
            d dVar = (d) x.this.dom.bh(d.class);
            if (dVar != null) {
                String talkerUserName = x.this.dom.getTalkerUserName();
                if (!z) {
                    i2 = 2;
                }
                dVar.ha(talkerUserName, i2);
            }
            AppMethodBeat.o(35305);
            return false;
        }
    };
    private q PpG;
    protected ChatFooterCustom PpH;
    private int PpI = 0;
    private com.tencent.mm.ui.chatting.u PpJ;
    private com.tencent.mm.ui.chatting.x PpK;
    private i PpL;
    private AnimationSet PpM;
    private String PpN = null;
    private int PpO;
    private int PpP;
    private boolean PpQ = false;
    public boolean PpR = false;
    private boolean PpS = false;
    public boolean PpT = false;
    private long PpU = 0;
    private IListener gsS = new IListener<sx>() {
        /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass1 */

        {
            AppMethodBeat.i(161528);
            this.__eventId = sx.class.getName().hashCode();
            AppMethodBeat.o(161528);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sx sxVar) {
            AppMethodBeat.i(35300);
            sx sxVar2 = sxVar;
            if ((sxVar2 instanceof sx) && x.this.znD != null) {
                x.this.znD.l(true, sxVar2.dZt.msgId);
            }
            AppMethodBeat.o(35300);
            return false;
        }
    };
    private IListener gsT = new IListener<sw>() {
        /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass11 */

        {
            AppMethodBeat.i(161529);
            this.__eventId = sw.class.getName().hashCode();
            AppMethodBeat.o(161529);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sw swVar) {
            AppMethodBeat.i(35304);
            sw swVar2 = swVar;
            if ((swVar2 instanceof sw) && x.this.znD != null) {
                x.this.znD.l(false, swVar2.dZp.msgId);
            }
            AppMethodBeat.o(35304);
            return false;
        }
    };
    protected ChatFooter znD;

    public x() {
        AppMethodBeat.i(35314);
        AppMethodBeat.o(35314);
    }

    static /* synthetic */ void a(x xVar, String str, as asVar, ArrayList arrayList) {
        AppMethodBeat.i(163319);
        xVar.a(str, asVar, arrayList);
        AppMethodBeat.o(163319);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.u
    public final ChatFooter gPO() {
        return this.znD;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.u
    public final ChatFooterCustom gPP() {
        return this.PpH;
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(233103);
        this.PpR = this.dom.Pwc.getBooleanExtra("show_footer", false).booleanValue();
        AppMethodBeat.o(233103);
    }

    private void gPQ() {
        AppMethodBeat.i(35315);
        if (((MMFragment) this.dom.Pwc).isCurrentActivity) {
            AppMethodBeat.o(35315);
            return;
        }
        this.dom.Pwe.gNZ();
        if (this.znD != null) {
            ChatFooter chatFooter = this.znD;
            View findViewById = chatFooter.findViewById(R.id.ax8);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            chatFooter.setSwitchButtonMode(0);
            chatFooter.mHandler.removeMessages(1002);
            if (chatFooter.Kir != null) {
                chatFooter.Kir.setVisibility(8);
            }
            if (chatFooter.Kis != null) {
                chatFooter.Kis.setVisibility(8);
            }
            if (chatFooter.Kit != null) {
                chatFooter.Kit.setVisibility(8);
            }
            if (chatFooter.Kiw != null) {
                chatFooter.Kiw.setVisibility(8);
            }
            if (chatFooter.Kiu != null) {
                chatFooter.Kiu.setVisibility(8);
            }
            if (chatFooter.Kix != null) {
                chatFooter.Kix.setVisibility(8);
            }
            chatFooter.han.setVisibility(8);
            if (chatFooter.tfb != null) {
                chatFooter.tfb.setVisibility(8);
            }
            if (chatFooter.KjC != null) {
                chatFooter.KjC.setVisibility(8);
            }
            if (chatFooter.tfc != null) {
                chatFooter.tfc.setVisibility(8);
            }
            if (chatFooter.teZ != null) {
                chatFooter.teZ.setVisibility(8);
            }
            if (chatFooter.Kdp != null) {
                chatFooter.Kdp.setVisibility(8);
                chatFooter.Kds = false;
                chatFooter.Kdp.destroy();
            }
            if (chatFooter.KiN != null) {
                chatFooter.KiN.setVisibility(8);
            }
            if (chatFooter.FQV != null) {
                chatFooter.FQV.setVisibility(8);
            }
            if (chatFooter.FQS != null) {
                chatFooter.FQS.update();
            }
            if (chatFooter.Kil != null) {
                chatFooter.Kil.setVisibility(8);
            }
            if (chatFooter.Kip != null) {
                chatFooter.Kip.setVisibility(4);
                if (chatFooter.rum != null) {
                    chatFooter.rum.setVisibility(4);
                }
            }
            chatFooter.Kik = (AppPanel) chatFooter.findViewById(R.id.arx);
            if (chatFooter.Kik != null) {
                chatFooter.setAppPanelVisible(8);
                AppPanel appPanel = chatFooter.Kik;
                if (appPanel.COD != null) {
                    appPanel.COD.setToScreen(0);
                }
                appPanel.KgO = 0;
            }
            chatFooter.a(ChatFooter.h.Reset);
            chatFooter.i(0, false, -1);
            chatFooter.KiJ = false;
            this.znD.gqi();
            this.znD.gqj();
            this.znD.KiG.Kml = null;
        }
        AppMethodBeat.o(35315);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.u
    public final String gPR() {
        return this.PpN;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.u
    public final void gPS() {
        AppMethodBeat.i(35316);
        try {
            if (this.znD.gqJ()) {
                this.znD.setBottomPanelVisibility(8);
            }
            AppMethodBeat.o(35316);
        } catch (Exception e2) {
            AppMethodBeat.o(35316);
        }
    }

    public final void gPT() {
        AppMethodBeat.i(35317);
        this.dom.hideVKB();
        Log.i("MicroMsg.ChattingUI.FootComponent", "visibleCustomFooter customFooter is %s", this.PpH);
        if (this.PpH == null) {
            AppMethodBeat.o(35317);
            return;
        }
        this.PpH.setVisibility(0);
        if (this.znD != null) {
            this.znD.Ak(false);
            this.znD.setVisibility(8);
        }
        AppMethodBeat.o(35317);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.u
    public final void gPU() {
        AppMethodBeat.i(35318);
        if (this.znD == null) {
            AppMethodBeat.o(35318);
            return;
        }
        this.znD.setVisibility(0);
        if (this.PpH != null) {
            this.PpH.setVisibility(8);
        }
        AppMethodBeat.o(35318);
    }

    private void gPV() {
        AppMethodBeat.i(35319);
        Log.i("MicroMsg.ChattingUI.FootComponent", "[goneFooter] %s", Util.getStack());
        if (this.znD != null) {
            this.znD.Ak(false);
            this.znD.setVisibility(8);
        }
        if (this.PpH != null) {
            this.PpH.setVisibility(8);
        }
        this.znD.Ah(false);
        this.dom.hideVKB();
        AppMethodBeat.o(35319);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.u
    public final void gPW() {
        AppMethodBeat.i(35320);
        this.PpM = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.PpM.setInterpolator(new DecelerateInterpolator(1.5f));
        this.PpM.addAnimation(translateAnimation);
        this.PpM.addAnimation(alphaAnimation);
        this.PpM.setDuration(300);
        this.PpM.setFillBefore(true);
        if (this.znD != null) {
            this.znD.startAnimation(this.PpM);
        }
        AppMethodBeat.o(35320);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.u
    public final void gPX() {
        AppMethodBeat.i(35321);
        Log.i("MicroMsg.ChattingUI.FootComponent", "triggerFooter, originChatFooterVisibility:%s", Integer.valueOf(this.PpO));
        if (this.znD == null) {
            this.znD = (ChatFooter) this.dom.findViewById(R.id.ftn);
            this.znD.a(new ChatFooter.b() {
                /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass13 */

                @Override // com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b
                public final String getTalkerUserName() {
                    AppMethodBeat.i(35306);
                    String talkerUserName = x.this.dom.getTalkerUserName();
                    AppMethodBeat.o(35306);
                    return talkerUserName;
                }

                @Override // com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b
                public final b grp() {
                    return x.this.dom.Pwa;
                }

                @Override // com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b
                public final com.tencent.mm.ui.chatting.e.a grq() {
                    return x.this.dom;
                }
            });
            ((t) this.dom.bh(t.class)).bD(this.znD);
            gPZ();
        }
        boolean gPB = ((l) this.dom.bh(l.class)).gPB();
        boolean gQN = ((ai) this.dom.bh(ai.class)).gQN();
        if (gPB || gQN || com.tencent.mm.ui.widget.snackbar.b.bJw()) {
            if (!this.PpQ) {
                this.PpO = this.znD.getVisibility();
            }
            this.znD.Ak(true);
            if (this.PpH == null) {
                this.PpP = -1;
            } else if (!this.PpQ) {
                this.PpP = this.PpH.getVisibility();
            }
            gPV();
            this.PpQ = true;
            AppMethodBeat.o(35321);
            return;
        }
        this.PpQ = false;
        if (this.PpO == 8 && this.PpP == 8) {
            gPV();
            AppMethodBeat.o(35321);
        } else if (this.PpO == 0) {
            gPU();
            AppMethodBeat.o(35321);
        } else {
            gPT();
            AppMethodBeat.o(35321);
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.u
    public final boolean au(as asVar) {
        AppMethodBeat.i(35322);
        boolean gRa = ((am) this.dom.bh(am.class)).gRa();
        boolean gQZ = ((am) this.dom.bh(am.class)).gQZ();
        boolean gPB = ((l) this.dom.bh(l.class)).gPB();
        boolean gPN = ((s) this.dom.bh(s.class)).gPN();
        boolean gQN = ((ai) this.dom.bh(ai.class)).gQN();
        if (this.PpR) {
            AppMethodBeat.o(35322);
            return true;
        } else if (gRa || gQZ || gPB || gPN || gQN) {
            Log.i("MicroMsg.ChattingUI.FootComponent", gRa + ", " + gQZ + ", " + gPB + ", " + gPN + ", " + gQN);
            gPV();
            AppMethodBeat.o(35322);
            return false;
        } else if (asVar == null || !ab.IP(asVar.field_username)) {
            if (asVar != null && asVar.gBM()) {
                d dVar = (d) this.dom.bh(d.class);
                if (dVar.gOM() != null) {
                    c.b cG = dVar.gOM().cG(false);
                    if (cG != null) {
                        if (cG.dhz != null) {
                            cG.dhB = "1".equals(cG.dhz.optString("IsHideInputToolbarInMsg"));
                        }
                        if (cG.dhB) {
                            Log.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + asVar.field_username + " is hide tool bar");
                            gPV();
                            AppMethodBeat.o(35322);
                            return false;
                        }
                    }
                    if (!Util.isNullOrNil(asVar.field_username) && cG != null) {
                        int intExtra = this.dom.Pwc.getIntExtra("key_temp_session_show_type", 0);
                        switch (cG.UX()) {
                            case 2:
                                Log.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + asVar.field_username + " is show custom menu");
                                if (this.PpH == null) {
                                    l.a(this.dom.Pwc, (int) R.id.ftm);
                                    this.PpH = (ChatFooterCustom) this.dom.findViewById(R.id.fto);
                                    if (this.PpH != null) {
                                        this.PpH.M((ViewGroup) this.dom.findViewById(R.id.auh));
                                    }
                                }
                                c.b.C0262c Ve = cG.Ve();
                                try {
                                    for (k kVar : Ve.dij) {
                                        if (!Util.isNullOrNil(kVar.egX)) {
                                            ((e) g.af(e.class)).a(kVar.egX, -1, "", Util.nullAs(kVar.name, ""), "", "", 4);
                                        }
                                        if (!Util.isNullOrNil(kVar.value)) {
                                            ((e) g.af(e.class)).a(kVar.value, -1, "", Util.nullAs(kVar.name, ""), "", "", 4);
                                        }
                                        for (k kVar2 : kVar.iOs) {
                                            if (!Util.isNullOrNil(kVar2.egX)) {
                                                ((e) g.af(e.class)).a(kVar2.egX, -1, "", Util.nullAs(kVar2.name, ""), "", "", 4);
                                            }
                                            if (!Util.isNullOrNil(kVar2.value)) {
                                                ((e) g.af(e.class)).a(kVar2.value, -1, "", Util.nullAs(kVar2.name, ""), "", "", 4);
                                            }
                                        }
                                    }
                                } catch (Exception e2) {
                                    Log.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", e2, "preauth when chat foot", new Object[0]);
                                }
                                if (Ve == null || Ve.type != 1) {
                                    this.znD.setSwitchButtonMode(0);
                                    try {
                                        if (ab.IJ(asVar.field_username)) {
                                            this.PpK = new com.tencent.mm.ui.chatting.x(this.PpH);
                                            this.PpK.gKK();
                                            gPT();
                                            break;
                                        } else {
                                            ChatFooterCustom chatFooterCustom = this.PpH;
                                            if (!(chatFooterCustom.PeN == null || chatFooterCustom.PeM == null)) {
                                                chatFooterCustom.PeN.setVisibility(0);
                                                chatFooterCustom.PeM.setVisibility(0);
                                            }
                                            if (chatFooterCustom.PeO != null) {
                                                chatFooterCustom.PeO.gNq();
                                            }
                                            this.PpH.setTalker(this.dom.GUe);
                                            this.PpH.a(this.dom.Pwc, dVar.gOM(), asVar.field_username);
                                            this.PpH.setOnFooterSwitchListener(this.KiE);
                                            this.PpH.setOnProcessClickListener(((d) this.dom.bh(d.class)).gOS());
                                            this.znD.setOnFooterSwitchListener(this.KiE);
                                            if (!((ae) this.dom.bh(ae.class)).gQM() || intExtra != 1) {
                                                gPT();
                                                break;
                                            } else {
                                                gPU();
                                                break;
                                            }
                                        }
                                    } catch (Exception e3) {
                                        if (Ve == null || Ve.dij == null || Ve.dij.size() == 0) {
                                            gPU();
                                        } else {
                                            this.KiE.An(true);
                                        }
                                        Log.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", e3, "", new Object[0]);
                                        break;
                                    }
                                } else {
                                    this.znD.setSwitchButtonMode(1);
                                    this.znD.setOnFooterSwitchListener(((d) this.dom.bh(d.class)).gOT());
                                    gPU();
                                    break;
                                }
                                break;
                            default:
                                gPU();
                                Object[] objArr = new Object[3];
                                objArr[0] = asVar.field_username;
                                objArr[1] = Boolean.valueOf(cG != null);
                                objArr[2] = Integer.valueOf(cG.UX());
                                Log.e("MicroMsg.ChattingUI.FootComponent", "bizinfo name=%s, %b, %d", objArr);
                                break;
                        }
                    }
                }
            }
            AppMethodBeat.o(35322);
            return true;
        } else {
            this.PpL = new i(this.PpH);
            this.PpL.gKK();
            gPT();
            AppMethodBeat.o(35322);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.u
    public final boolean aT(ca caVar) {
        AppMethodBeat.i(35323);
        if (this.znD != null) {
            this.znD.aT(caVar);
        }
        AppMethodBeat.o(35323);
        return true;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.u
    public final void gPY() {
        int i2;
        AppMethodBeat.i(35324);
        String talkerUserName = this.dom.getTalkerUserName();
        if (ab.IY(talkerUserName) || as.bjm(talkerUserName)) {
            i2 = 1;
        } else if (ab.Jp(talkerUserName)) {
            i2 = 2;
        } else {
            i2 = this.dom.Pwc.getIntExtra("Chat_Mode", 0);
            Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.PpI), Integer.valueOf(i2));
            if (this.PpI != 0) {
                i2 = this.PpI;
            }
            String value = h.aqJ().getValue("DefaultMsgType");
            if (this.PpI == 0 && value != null) {
                Log.d("MicroMsg.ChattingUI.FootComponent", "config def chatmode is %s", value);
                i2 = Util.getInt(h.aqJ().getValue("DefaultMsgType"), 0);
            }
            if (i2 == 0 && com.tencent.mm.contact.c.oR(this.dom.GUe.field_type)) {
                bg.aVF();
                i2 = ((Integer) com.tencent.mm.model.c.azQ().get(18, (Object) 0)).intValue();
            }
            if (i2 == 0) {
                i2 = 1;
            }
            Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.PpI), Integer.valueOf(i2));
        }
        if (i2 == 2) {
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this.dom.Pwc.getContext(), "android.permission.RECORD_AUDIO", 80, "", "");
            Log.i("MicroMsg.ChattingUI.FootComponent", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this.dom.Pwc.getContext());
            if (!a2) {
                this.znD.bA(1, false);
                AppMethodBeat.o(35324);
                return;
            }
        }
        this.znD.bA(i2, false);
        AppMethodBeat.o(35324);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x046e  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0479  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0484  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0497  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x049c  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x04a4  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x04b6  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x04c8  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x04f0  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0500  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0517  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x05a5  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0667  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0695  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0836  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0839  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x083c  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0847  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x087f  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x08af  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x037a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x043f  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0448  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0451  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0463  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bmK(final java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 2344
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.x.bmK(java.lang.String):void");
    }

    private void gPZ() {
        AppMethodBeat.i(184963);
        if (this.znD == null) {
            Log.e("MicroMsg.ChattingUI.FootComponent", "initTodoView footer == null");
            AppMethodBeat.o(184963);
            return;
        }
        Log.i("MicroMsg.ChattingUI.FootComponent", "initTodoView()");
        ((y) this.dom.bh(y.class)).a(this.znD.getIOnToDoBarCallback());
        this.znD.setIOnTodoViewCallback(new ab.c() {
            /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass16 */

            @Override // com.tencent.mm.ui.chatting.d.ab.c
            public final void BP(boolean z) {
                AppMethodBeat.i(185864);
                ((y) x.this.dom.bh(y.class)).BP(z);
                AppMethodBeat.o(185864);
            }

            @Override // com.tencent.mm.ui.chatting.d.ab.c
            public final void BQ(boolean z) {
                AppMethodBeat.i(185865);
                ((y) x.this.dom.bh(y.class)).BQ(z);
                AppMethodBeat.o(185865);
            }

            @Override // com.tencent.mm.ui.chatting.d.ab.c
            public final int dYg() {
                AppMethodBeat.i(185866);
                int dYg = ((y) x.this.dom.bh(y.class)).dYg();
                AppMethodBeat.o(185866);
                return dYg;
            }
        });
        AppMethodBeat.o(184963);
    }

    private void a(final String str, final ay.b.a aVar) {
        AppMethodBeat.i(163315);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass17 */

            public final String toString() {
                AppMethodBeat.i(184962);
                String str = super.toString() + "|getContactCallBack2";
                AppMethodBeat.o(184962);
                return str;
            }

            public final void run() {
                AppMethodBeat.i(184961);
                ay.a.iDq.a(str, "", aVar);
                AppMethodBeat.o(184961);
            }
        });
        AppMethodBeat.o(163315);
    }

    private void a(String str, as asVar, ArrayList<a.C2027a> arrayList) {
        long j2;
        AppMethodBeat.i(163316);
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (asVar == null) {
            j2 = 0;
        } else {
            j2 = asVar.fvd;
        }
        objArr[1] = Long.valueOf(j2);
        Log.i("MicroMsg.ChattingUI.FootComponent", "ChatroomBusinessType user %s %s", objArr);
        if (!(!this.dom.gRL() || asVar == null || asVar.fvd == 0)) {
            if (PpE == null) {
                PpE = new ArrayList<>();
                gQa();
                PpF = cl.aWy();
            } else {
                long aWy = cl.aWy();
                if (aWy - PpF > ((long) ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_app_panel_dynamic_update_time, 1800))) {
                    PpF = aWy;
                    PpE.clear();
                    gQa();
                }
            }
            ArrayList<a.C2027a> arrayList2 = PpE;
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator<a.C2027a> it = arrayList2.iterator();
                while (it.hasNext()) {
                    a.C2027a next = it.next();
                    if ((next.Kie & asVar.fvd) != 0) {
                        next.kHG = asVar.field_username;
                        arrayList.add(next);
                    }
                }
            }
        }
        this.znD.setAppPanelUnCertainEnterArrayList(arrayList);
        AppMethodBeat.o(163316);
    }

    private static void gQa() {
        AppMethodBeat.i(163317);
        bmL(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_app_panel_dynamic_config1, ""));
        bmL(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_app_panel_dynamic_config2, ""));
        bmL(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_app_panel_dynamic_config3, ""));
        bmL(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_app_panel_dynamic_config4, ""));
        bmL(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_app_panel_dynamic_config5, ""));
        bmL(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_app_panel_dynamic_config6, ""));
        bmL(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_app_panel_dynamic_config7, ""));
        bmL(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_app_panel_dynamic_config8, ""));
        bmL(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_app_panel_dynamic_config9, ""));
        bmL(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_app_panel_dynamic_config10, ""));
        AppMethodBeat.o(163317);
    }

    private static void bmL(String str) {
        AppMethodBeat.i(163318);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(163318);
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("wxapp");
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = new JSONObject(jSONArray.getString(i2));
                a.C2027a aVar = new a.C2027a();
                aVar.KhQ = jSONObject.optString("enter_id");
                aVar.KhR = jSONObject.optInt("red_dot");
                aVar.uSc = jSONObject.optInt("jump_type");
                aVar.KhS = jSONObject.optString("wa_un");
                aVar.KhU = jSONObject.optInt("wa_ver");
                aVar.KhV = jSONObject.optString("wa_path");
                aVar.KhW = jSONObject.optString("wa_dgmode");
                aVar.nnB = jSONObject.optString("h5_url");
                aVar.iconUrl = jSONObject.optString("icon_url");
                aVar.Kib = jSONObject.optString("icon_url_dark");
                if (Util.isNullOrNil(aVar.iconUrl)) {
                    Log.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.iconUrl is null");
                } else {
                    aVar.Kie = jSONObject.optLong("busi_type");
                    JSONObject optJSONObject = jSONObject.optJSONObject("title");
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("desc");
                    if (optJSONObject == null) {
                        Log.e("MicroMsg.ChattingUI.FootComponent", "titleJson is null");
                    } else {
                        aVar.KhX.title = optJSONObject.optString("zh_cn");
                        if (Util.isNullOrNil(aVar.KhX.title)) {
                            Log.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.simpleChWord.title is null");
                        } else {
                            aVar.KhZ.title = Util.isNullOrNil(optJSONObject.optString("zh_tw")) ? aVar.KhX.title : optJSONObject.optString("zh_tw");
                            aVar.KhY.title = Util.isNullOrNil(optJSONObject.optString("zh_hk")) ? aVar.KhX.title : optJSONObject.optString("zh_hk");
                            aVar.Kia.title = Util.isNullOrNil(optJSONObject.optString(LocaleUtil.ENGLISH)) ? aVar.KhX.title : optJSONObject.optString(LocaleUtil.ENGLISH);
                            if (optJSONObject2 != null) {
                                aVar.KhX.desc = optJSONObject2.optString("zh_cn");
                                aVar.KhZ.desc = Util.isNullOrNil(optJSONObject2.optString("zh_tw")) ? aVar.KhX.desc : optJSONObject2.optString("zh_tw");
                                aVar.KhY.desc = Util.isNullOrNil(optJSONObject2.optString("zh_hk")) ? aVar.KhX.desc : optJSONObject2.optString("zh_hk");
                                aVar.Kia.desc = Util.isNullOrNil(optJSONObject2.optString(LocaleUtil.ENGLISH)) ? aVar.KhX.desc : optJSONObject2.optString(LocaleUtil.ENGLISH);
                            }
                            PpE.add(aVar);
                        }
                    }
                }
            }
            AppMethodBeat.o(163318);
        } catch (Exception e2) {
            Log.e("MicroMsg.ChattingUI.FootComponent", "handleAppPanelUnCertainEnterConfig() Exception:%s", e2.getMessage());
            AppMethodBeat.o(163318);
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(35327);
        if (obj != null) {
            obj.equals("");
        }
        Log.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", obj, this.dom.getTalkerUserName());
        if (obj.equals(this.dom.getTalkerUserName())) {
            bmK(this.dom.getTalkerUserName());
            gPY();
        }
        AppMethodBeat.o(35327);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(35328);
        if (str != null) {
            str.equals("");
        }
        Log.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", str, this.dom.getTalkerUserName());
        if (com.tencent.mm.model.ab.Iy(this.dom.getTalkerUserName())) {
            bmK(this.dom.getTalkerUserName());
            gPY();
        }
        AppMethodBeat.o(35328);
    }

    class a implements TextWatcher {
        private boolean Pqa;
        private List<String> Pqb;

        private a() {
            this.Pqa = false;
            this.Pqb = null;
        }

        /* synthetic */ a(x xVar, byte b2) {
            this();
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        private static void c(List<String> list, String[] strArr) {
            AppMethodBeat.i(233102);
            for (String str : strArr) {
                if (str.length() > 0 && str.substring(str.length() - 1, str.length()).matches("[_0-9a-zA-Z]$")) {
                    list.add(str);
                }
            }
            AppMethodBeat.o(233102);
        }

        private boolean hb(String str, int i2) {
            AppMethodBeat.i(35312);
            if (str == null || i2 < 0 || str.length() <= i2) {
                AppMethodBeat.o(35312);
                return false;
            } else if (i2 == 0) {
                AppMethodBeat.o(35312);
                return true;
            } else if (str.substring(i2 - 1, i2).matches("[_0-9a-zA-Z]$")) {
                if (this.Pqb == null) {
                    this.Pqb = new LinkedList();
                    c(this.Pqb, x.this.dom.Pwc.getMMResources().getStringArray(R.array.a3));
                    c(this.Pqb, x.this.dom.Pwc.getMMResources().getStringArray(R.array.a4));
                }
                String substring = str.substring(0, i2);
                for (String str2 : this.Pqb) {
                    if (substring.endsWith(str2)) {
                        AppMethodBeat.o(35312);
                        return true;
                    }
                }
                AppMethodBeat.o(35312);
                return false;
            } else {
                AppMethodBeat.o(35312);
                return true;
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(35313);
            Log.i("MicroMsg.ChattingUI.FootComponent", "[onTextChanged]");
            ((ao) x.this.dom.bh(ao.class)).amF(1);
            d dVar = (d) x.this.dom.bh(d.class);
            String valueOf = String.valueOf(charSequence);
            String substring = valueOf.substring(i2, i2 + i4);
            if (x.this.dom.gRL() && "@".equals(substring) && !valueOf.equals(x.this.znD.getLastContent()) && !x.this.znD.KiH) {
                x.this.znD.setLastContent(valueOf);
                x.this.znD.setInsertPos(i2 + 1);
                if (hb(valueOf, i2)) {
                    String listToString = Util.listToString(v.Ic(x.this.dom.getTalkerUserName()), ",");
                    Intent intent = new Intent();
                    intent.setClass(x.this.dom.Pwc.getContext(), AtSomeoneUI.class);
                    intent.putExtra("Block_list", z.aTY());
                    intent.putExtra("Chatroom_member_list", listToString);
                    intent.putExtra("Chat_User", x.this.dom.getTalkerUserName());
                    intent.putExtra("Add_address_titile", x.this.dom.Pwc.getMMString(R.string.g60));
                    x.this.dom.Pwc.startActivityForResult(intent, 212);
                }
            } else if (dVar.gOQ() && "@".equals(substring) && !valueOf.equals(x.this.znD.getLastContent()) && !x.this.znD.KiH) {
                x.this.znD.setLastContent(valueOf);
                x.this.znD.setInsertPos(i2 + 1);
                if (hb(valueOf, i2)) {
                    String str = dVar.gON().field_userList;
                    Intent intent2 = new Intent();
                    intent2.setClass(x.this.dom.Pwc.getContext(), BizChatAtSomeoneUI.class);
                    intent2.putExtra("Block_list", ag.bal().fC(x.this.dom.getTalkerUserName()));
                    intent2.putExtra("Chatroom_member_list", str);
                    intent2.putExtra("Chat_User", x.this.dom.getTalkerUserName());
                    intent2.putExtra("Add_address_titile", x.this.dom.Pwc.getMMString(R.string.g60));
                    intent2.putExtra("key_biz_chat_id", ((d) x.this.dom.bh(d.class)).gPc());
                    x.this.dom.Pwc.startActivityForResult(intent2, 212);
                }
            } else if (!valueOf.equals(x.this.znD.getLastContent())) {
                x.this.znD.setLastContent(valueOf);
            }
            ((an) x.this.dom.bh(an.class)).Q(valueOf, i2, substring);
            if (!dVar.gOP() && !as.bjw(x.this.dom.getTalkerUserName())) {
                ChatFooter chatFooter = x.this.znD;
                if (!(chatFooter.KiB == null || chatFooter.han == null)) {
                    chatFooter.KiB.Knv = true;
                    m mVar = chatFooter.KiB;
                    String talkerUserName = chatFooter.Kjy.getTalkerUserName();
                    if (Util.isNullOrNil(valueOf)) {
                        mVar.mHandler.removeMessages(20003);
                        mVar.mHandler.sendEmptyMessage(20001);
                        mVar.ygH = valueOf;
                        if (mVar.Knz != null) {
                            mVar.Knz.dead();
                            mVar.Knz = null;
                        }
                    } else {
                        if (!valueOf.equals(mVar.ygH)) {
                            mVar.hide();
                            if (mVar.Knz != null) {
                                mVar.Knz.dead();
                                mVar.Knz = null;
                            }
                            mVar.Knz = new com.tencent.mm.vending.e.c<>();
                            String valueOf2 = String.valueOf(Util.nowMilliSecond());
                            jy jyVar = mVar.KnA;
                            jyVar.eiB = jyVar.x("SessionId", valueOf2, true);
                            jy jyVar2 = mVar.KnA;
                            jyVar2.ekv = jyVar2.x("ChatId", talkerUserName, true);
                            mVar.Knx.clear();
                            mVar.KnB = 0;
                            com.tencent.mm.emoji.b.c.b bVar = new com.tencent.mm.emoji.b.c.b(mVar.Knz);
                            p.h(valueOf2, "sessionId");
                            f fVar = bVar.gZo;
                            p.h(valueOf2, "sessionId");
                            fVar.username = talkerUserName;
                            fVar.sessionId = valueOf2;
                            m.AnonymousClass5 r3 = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x028c: CONSTRUCTOR  (r3v8 'r3' com.tencent.mm.pluginsdk.ui.chat.m$5) = 
                                  (r1v47 'mVar' com.tencent.mm.pluginsdk.ui.chat.m)
                                  (wrap: long : 0x0286: INVOKE  (r6v9 long) =  type: STATIC call: com.tencent.mm.sdk.platformtools.Util.nowMilliSecond():long)
                                 call: com.tencent.mm.pluginsdk.ui.chat.m.5.<init>(com.tencent.mm.pluginsdk.ui.chat.m, long):void type: CONSTRUCTOR in method: com.tencent.mm.ui.chatting.d.x.a.onTextChanged(java.lang.CharSequence, int, int, int):void, file: classes5.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.pluginsdk.ui.chat.m, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 34 more
                                */
                            /*
                            // Method dump skipped, instructions count: 684
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.x.a.onTextChanged(java.lang.CharSequence, int, int, int):void");
                        }
                    }

                    @Override // com.tencent.mm.ui.l
                    public final void onActivityResult(int i2, int i3, Intent intent) {
                        AppMethodBeat.i(35329);
                        super.onActivityResult(i2, i3, intent);
                        if (1111 == i2 && -1 == i3) {
                            this.znD.gqo();
                        }
                        if (i3 != -1) {
                            if (i2 == 200 || i2 == 201 || i2 == 203) {
                                this.znD.clearFocus();
                            }
                            AppMethodBeat.o(35329);
                            return;
                        }
                        if (!(i2 == 217 || this.PpH == null)) {
                            this.PpH.s(i2, intent);
                        }
                        switch (i2) {
                            case 202:
                                if (intent != null) {
                                    int intExtra = intent.getIntExtra("Chat_Mode", 1);
                                    if (this.znD != null) {
                                        this.znD.setMode(intExtra);
                                        break;
                                    }
                                } else {
                                    Log.e("MicroMsg.ChattingUI.FootComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                                    AppMethodBeat.o(35329);
                                    return;
                                }
                                break;
                        }
                        AppMethodBeat.o(35329);
                    }

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.l
                    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                        int i3 = 0;
                        AppMethodBeat.i(35330);
                        super.onRequestPermissionsResult(i2, strArr, iArr);
                        if (iArr == null || iArr.length <= 0) {
                            Object[] objArr = new Object[4];
                            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
                            objArr[1] = Integer.valueOf(i2);
                            objArr[2] = strArr;
                            objArr[3] = Util.getStack();
                            Log.w("MicroMsg.ChattingUI.FootComponent", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", objArr);
                            AppMethodBeat.o(35330);
                            return;
                        }
                        switch (i2) {
                            case 18:
                                if (iArr[0] == 0) {
                                    Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", this.PpG, Util.getStack());
                                    if (this.PpG != null) {
                                        q qVar = this.PpG;
                                        if (!this.znD.Kik.KgQ.KhF.value) {
                                            i3 = 2;
                                        }
                                        qVar.ami(i3);
                                    }
                                    AppMethodBeat.o(35330);
                                    return;
                                }
                                int i4 = "android.permission.CAMERA".equals(strArr[0]) ? R.string.fl0 : R.string.flb;
                                if (iArr[0] != 0) {
                                    com.tencent.mm.ui.base.h.a((Context) this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(i4), this.dom.Pwc.getMMResources().getString(R.string.flp), this.dom.Pwc.getMMResources().getString(R.string.e_k), this.dom.Pwc.getMMResources().getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass3 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(35302);
                                            dialogInterface.dismiss();
                                            BaseChattingUIFragment baseChattingUIFragment = x.this.dom.Pwc;
                                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/FootComponent$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            baseChattingUIFragment.startActivity((Intent) bl.pG(0));
                                            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/FootComponent$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            AppMethodBeat.o(35302);
                                        }
                                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass4 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(35303);
                                            dialogInterface.dismiss();
                                            AppMethodBeat.o(35303);
                                        }
                                    });
                                }
                                AppMethodBeat.o(35330);
                                return;
                            case 19:
                            case 21:
                            case 22:
                                if (iArr[0] != 0) {
                                    int i5 = "android.permission.CAMERA".equals(strArr[0]) ? R.string.fl0 : R.string.flb;
                                    if (iArr[0] != 0) {
                                        com.tencent.mm.ui.base.h.a((Context) this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(i5), this.dom.Pwc.getMMResources().getString(R.string.flp), this.dom.Pwc.getMMResources().getString(R.string.e_k), this.dom.Pwc.getMMResources().getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass5 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(163307);
                                                dialogInterface.dismiss();
                                                BaseChattingUIFragment baseChattingUIFragment = x.this.dom.Pwc;
                                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                                com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/FootComponent$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                                baseChattingUIFragment.startActivity((Intent) bl.pG(0));
                                                com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/FootComponent$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                                AppMethodBeat.o(163307);
                                            }
                                        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass6 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(163308);
                                                dialogInterface.dismiss();
                                                AppMethodBeat.o(163308);
                                            }
                                        });
                                    }
                                    AppMethodBeat.o(35330);
                                    return;
                                } else if (i2 == 19) {
                                    Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", this.PpG, Util.getStack());
                                    if (this.PpG != null) {
                                        this.PpG.eEL();
                                    }
                                    AppMethodBeat.o(35330);
                                    return;
                                } else if (i2 == 21) {
                                    Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", this.PpG, Util.getStack());
                                    if (this.PpG != null) {
                                        this.PpG.gNM();
                                    }
                                    AppMethodBeat.o(35330);
                                    return;
                                } else {
                                    Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", this.PpG, Util.getStack());
                                    if (this.PpG != null) {
                                        this.PpG.gNK();
                                    }
                                    AppMethodBeat.o(35330);
                                    return;
                                }
                            case 20:
                                if (iArr[0] == 0) {
                                    Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", this.PpG, Util.getStack());
                                    if (this.PpG != null) {
                                        this.PpG.gNO();
                                    }
                                    AppMethodBeat.o(35330);
                                    return;
                                }
                                com.tencent.mm.ui.base.h.a((Context) this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.fl0), this.dom.Pwc.getMMResources().getString(R.string.flp), this.dom.Pwc.getMMResources().getString(R.string.e_k), this.dom.Pwc.getMMResources().getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass7 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(169867);
                                        BaseChattingUIFragment baseChattingUIFragment = x.this.dom.Pwc;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                        com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/FootComponent$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        baseChattingUIFragment.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/FootComponent$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        AppMethodBeat.o(169867);
                                    }
                                }, (DialogInterface.OnClickListener) null);
                                AppMethodBeat.o(35330);
                                return;
                            case 25:
                                if (iArr[0] == 0) {
                                    Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterLiveRequest,footerEventImpl[%s], stack[%s]", this.PpG, Util.getStack());
                                    if (this.PpG != null) {
                                        this.PpG.zon.eij();
                                    }
                                    AppMethodBeat.o(35330);
                                    return;
                                }
                                int i6 = "android.permission.CAMERA".equals(strArr[0]) ? R.string.fl0 : R.string.flb;
                                if (iArr[0] != 0) {
                                    com.tencent.mm.ui.base.h.a((Context) this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(i6), this.dom.Pwc.getMMResources().getString(R.string.flp), this.dom.Pwc.getMMResources().getString(R.string.e_k), this.dom.Pwc.getMMResources().getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass18 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(35311);
                                            dialogInterface.dismiss();
                                            BaseChattingUIFragment baseChattingUIFragment = x.this.dom.Pwc;
                                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/FootComponent$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            baseChattingUIFragment.startActivity((Intent) bl.pG(0));
                                            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/FootComponent$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            AppMethodBeat.o(35311);
                                        }
                                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass2 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(35301);
                                            dialogInterface.dismiss();
                                            AppMethodBeat.o(35301);
                                        }
                                    });
                                }
                                AppMethodBeat.o(35330);
                                return;
                            case 81:
                                if (iArr[0] == 0) {
                                    Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", this.PpG, Util.getStack());
                                    if (this.PpG != null) {
                                        this.PpG.gNN();
                                    }
                                    AppMethodBeat.o(35330);
                                    return;
                                }
                                com.tencent.mm.ui.base.h.a((Context) this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.fl_), this.dom.Pwc.getMMResources().getString(R.string.flp), this.dom.Pwc.getMMResources().getString(R.string.e_k), this.dom.Pwc.getMMResources().getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass8 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(184958);
                                        BaseChattingUIFragment baseChattingUIFragment = x.this.dom.Pwc;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                        com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/FootComponent$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        baseChattingUIFragment.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/FootComponent$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        AppMethodBeat.o(184958);
                                    }
                                }, (DialogInterface.OnClickListener) null);
                                AppMethodBeat.o(35330);
                                return;
                            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                            case 83:
                                if (iArr[0] != 0) {
                                    com.tencent.mm.ui.base.h.a((Context) this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.flb), this.dom.Pwc.getMMResources().getString(R.string.flp), this.dom.Pwc.getMMResources().getString(R.string.e_k), this.dom.Pwc.getMMResources().getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass9 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(233100);
                                            BaseChattingUIFragment baseChattingUIFragment = x.this.dom.Pwc;
                                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/FootComponent$17", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            baseChattingUIFragment.startActivity((Intent) bl.pG(0));
                                            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/FootComponent$17", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            AppMethodBeat.o(233100);
                                        }
                                    }, (DialogInterface.OnClickListener) null);
                                    AppMethodBeat.o(35330);
                                    return;
                                } else if (i2 == 82) {
                                    Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", this.PpG, Util.getStack());
                                    if (this.PpG != null) {
                                        this.PpG.eEK();
                                    }
                                    AppMethodBeat.o(35330);
                                    return;
                                } else {
                                    Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", this.PpG, Util.getStack());
                                    if (this.PpG != null) {
                                        this.PpG.gNL();
                                    }
                                    AppMethodBeat.o(35330);
                                    return;
                                }
                            case 145:
                                if (iArr[0] != 0) {
                                    com.tencent.mm.ui.base.h.a((Context) this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.fli), this.dom.Pwc.getMMResources().getString(R.string.flp), this.dom.Pwc.getMMResources().getString(R.string.e_k), this.dom.Pwc.getMMResources().getString(R.string.dlk), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass10 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(233101);
                                            BaseChattingUIFragment baseChattingUIFragment = x.this.dom.Pwc;
                                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/FootComponent$18", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            baseChattingUIFragment.startActivity((Intent) bl.pG(0));
                                            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/FootComponent$18", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            AppMethodBeat.o(233101);
                                        }
                                    }, (DialogInterface.OnClickListener) null);
                                    break;
                                } else {
                                    Log.i("MicroMsg.ChattingUI.FootComponent", "doSendFileRequest, footerEventImpl[%s], stack[%s].", this.PpG, Util.getStack());
                                    if (this.PpG != null) {
                                        this.PpG.gNI();
                                    }
                                    AppMethodBeat.o(35330);
                                    return;
                                }
                        }
                        AppMethodBeat.o(35330);
                    }

                    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
                    public final void gOK() {
                        AppMethodBeat.i(35332);
                        super.gOK();
                        if (this.znD != null) {
                            this.znD.setFooterEventListener(null);
                            q qVar = this.PpG;
                            CaptureDataManager.BOb.BOa = null;
                            if (qVar.PgS != null) {
                                qVar.PgS.a((m.b) null);
                                qVar.PgS.a((m.a) null);
                            }
                            this.PpG = null;
                            this.znD.setSmileyPanelCallback(null);
                            this.znD.setSmileyPanelCallback2(null);
                        }
                        if (this.PpH != null) {
                            this.PpH.gNk();
                            this.PpH = null;
                        }
                        gPQ();
                        if (this.PpH != null) {
                            this.PpH.gNn();
                        }
                        com.tencent.mm.pluginsdk.ui.span.l.clearCache();
                        if (this.znD != null) {
                            this.znD.gqO();
                        }
                        if (((MMFragment) this.dom.Pwc).isCurrentActivity && this.znD != null) {
                            this.znD.destroy();
                        }
                        g.aAi();
                        ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().remove(this);
                        ((PluginOpenIM) g.ah(PluginOpenIM.class)).getWordingInfoStg().remove(this);
                        AppMethodBeat.o(35332);
                    }

                    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
                    public final void gIl() {
                        AppMethodBeat.i(35333);
                        this.PpS = false;
                        this.PpT = false;
                        this.PpU = 0;
                        bg.aVF();
                        az bjY = com.tencent.mm.model.c.aST().bjY(this.dom.getTalkerUserName());
                        if (bjY != null) {
                            this.PpI = bjY.field_chatmode;
                        }
                        Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm init old:%d   ", Integer.valueOf(this.PpI));
                        String talkerUserName = this.dom.getTalkerUserName();
                        if (this.znD == null) {
                            this.znD = (ChatFooter) this.dom.findViewById(R.id.ftn);
                            this.znD.a(new ChatFooter.b() {
                                /* class com.tencent.mm.ui.chatting.d.x.AnonymousClass14 */

                                @Override // com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b
                                public final String getTalkerUserName() {
                                    AppMethodBeat.i(35307);
                                    String talkerUserName = x.this.dom.getTalkerUserName();
                                    AppMethodBeat.o(35307);
                                    return talkerUserName;
                                }

                                @Override // com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b
                                public final com.tencent.mm.ui.chatting.i.b grp() {
                                    return x.this.dom.Pwa;
                                }

                                @Override // com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b
                                public final com.tencent.mm.ui.chatting.e.a grq() {
                                    return x.this.dom;
                                }
                            });
                            ((t) this.dom.bh(t.class)).bD(this.znD);
                            gPZ();
                        }
                        this.znD.setCattingRootLayoutId(R.id.auc);
                        Log.i("MicroMsg.ChattingUI.FootComponent", "resetFooter customFooter is %s", this.PpH);
                        if (this.PpH != null) {
                            this.PpH.gNk();
                            this.PpH.setOnFooterSwitchListener(null);
                            this.PpH.setOnProcessClickListener(null);
                            this.znD.setOnFooterSwitchListener(null);
                            this.PpH.gNn();
                        }
                        gPV();
                        this.znD.gqt();
                        boolean gRa = ((am) this.dom.bh(am.class)).gRa();
                        boolean gQZ = ((am) this.dom.bh(am.class)).gQZ();
                        boolean gQN = ((ai) this.dom.bh(ai.class)).gQN();
                        if (!this.PpR && (gRa || gQZ || gQN)) {
                            gPV();
                        } else if (com.tencent.mm.model.ab.IW(talkerUserName)) {
                            gPV();
                            l.a(this.dom.Pwc, (int) R.id.ftm);
                            boolean z = this.PpH == null;
                            this.PpH = (ChatFooterCustom) this.dom.findViewById(R.id.fto);
                            if (z) {
                                this.PpH.M((ViewGroup) this.dom.findViewById(R.id.auh));
                            }
                            this.PpJ = new com.tencent.mm.ui.chatting.u(this.PpH);
                            com.tencent.mm.ui.chatting.u uVar = this.PpJ;
                            boolean z2 = ChannelUtil.channelId == 1;
                            uVar.PhX.findViewById(R.id.avb).setVisibility(8);
                            uVar.rmL = (LinearLayout) uVar.PhX.findViewById(R.id.av7);
                            uVar.PhX.findViewById(R.id.av6).setVisibility(8);
                            uVar.rmL.setWeightSum(z2 ? 1.0f : 2.0f);
                            uVar.PhY = (FrameLayout) uVar.rmL.getChildAt(0);
                            uVar.PhY.setVisibility(0);
                            uVar.PhY.setOnClickListener(uVar.Pig);
                            ((TextView) uVar.PhY.findViewById(R.id.av9)).setText(R.string.aw3);
                            uVar.PhY.findViewById(R.id.av8).setVisibility(8);
                            if (z2) {
                                for (int i2 = 1; i2 < 6; i2++) {
                                    uVar.rmL.getChildAt(i2).setVisibility(8);
                                }
                            } else {
                                uVar.PhZ = (FrameLayout) uVar.rmL.getChildAt(1);
                                uVar.PhZ.setVisibility(0);
                                uVar.PhZ.setOnClickListener(uVar.Pih);
                                uVar.Pia = (TextView) uVar.PhZ.findViewById(R.id.av9);
                                uVar.Pib = (ImageView) uVar.PhZ.findViewById(R.id.av8);
                                uVar.Pib.setVisibility(0);
                                uVar.gNR();
                                bg.aVF();
                                uVar.xXB = ((Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, (Object) -1)).intValue();
                                if (uVar.xXB >= 0) {
                                    uVar.gNT();
                                } else {
                                    uVar.Pia.setText(R.string.awf);
                                }
                                for (int i3 = 2; i3 < 6; i3++) {
                                    uVar.rmL.getChildAt(i3).setVisibility(8);
                                }
                                uVar.Pif = h.aqK().getMailAppEnterUlAndroid();
                                if (Util.isNullOrNil(uVar.Pif)) {
                                    uVar.Pif = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
                                }
                                bg.aVF();
                                uVar.Pif = uVar.Pif.replace("$uin$", new com.tencent.mm.b.p(Util.nullAsNil((Integer) com.tencent.mm.model.c.azQ().get(9, (Object) null))).toString());
                                uVar.Bxl = h.aqK().aqC();
                                uVar.Pid = true;
                            }
                            gPT();
                        } else {
                            this.PpJ = null;
                            if (com.tencent.mm.model.ab.IJ(talkerUserName)) {
                                gPV();
                                l.a(this.dom.Pwc, (int) R.id.ftm);
                                boolean z3 = this.PpH == null;
                                this.PpH = (ChatFooterCustom) this.dom.findViewById(R.id.fto);
                                if (z3) {
                                    this.PpH.M((ViewGroup) this.dom.findViewById(R.id.auh));
                                }
                                this.PpK = new com.tencent.mm.ui.chatting.x(this.PpH);
                                this.PpK.gKK();
                                gPT();
                            } else {
                                this.PpK = null;
                                if (com.tencent.mm.model.ab.IP(talkerUserName)) {
                                    gPV();
                                    l.a(this.dom.Pwc, (int) R.id.ftm);
                                    boolean z4 = this.PpH == null;
                                    this.PpH = (ChatFooterCustom) this.dom.findViewById(R.id.fto);
                                    if (z4) {
                                        this.PpH.M((ViewGroup) this.dom.findViewById(R.id.auh));
                                    }
                                    this.PpL = new i(this.PpH);
                                    this.PpL.gKK();
                                    gPT();
                                } else {
                                    this.PpL = null;
                                    if (!com.tencent.mm.model.ab.IX(talkerUserName) && !com.tencent.mm.model.ab.IJ(talkerUserName) && !com.tencent.mm.model.ab.IW(talkerUserName) && !com.tencent.mm.model.ab.IP(talkerUserName)) {
                                        com.tencent.mm.model.ab.aUW();
                                        if (!com.tencent.mm.model.ab.Jx(talkerUserName) && !com.tencent.mm.model.ab.IN(talkerUserName) && !com.tencent.mm.model.ab.JC(talkerUserName)) {
                                            gPU();
                                            au(this.dom.GUe);
                                            this.znD.setUserName(talkerUserName);
                                            this.znD.mC(this.dom.gRI(), this.dom.getTalkerUserName());
                                            bmK(talkerUserName);
                                            l lVar = (l) this.dom.bh(l.class);
                                            am amVar = (am) this.dom.bh(am.class);
                                            if (lVar.gPB()) {
                                                if (amVar.gQX()) {
                                                    amVar.gQW();
                                                    lVar.gPC();
                                                } else {
                                                    lVar.gPz();
                                                }
                                            }
                                        }
                                    }
                                    gPV();
                                }
                            }
                        }
                        gPQ();
                        this.PpG = new q(this.dom, this.znD, this.dom.getTalkerUserName());
                        this.PpG.PgY = this.dom.Pwc.getBooleanExtra("key_need_send_video", true).booleanValue();
                        this.znD.setFooterEventListener(this.PpG);
                        w wVar = new w(this.dom, this.dom.GUe, this.dom.getTalkerUserName());
                        this.znD.setSmileyPanelCallback(wVar);
                        this.znD.setSmileyPanelCallback2(wVar);
                        gPY();
                        this.znD.gql();
                        int intExtra = this.dom.Pwc.getIntExtra("key_temp_session_show_type", 0);
                        ae aeVar = (ae) this.dom.bh(ae.class);
                        Log.i("MicroMsg.ChattingUI.FootComponent", "isTempSession : %s, showType : %d.", Boolean.valueOf(aeVar.gQM()), Integer.valueOf(intExtra));
                        Log.d("MicroMsg.ChattingUI.FootComponent", "is temp session : %s.", Boolean.valueOf(aeVar.gQM()));
                        if (aeVar.gQM()) {
                            if (intExtra == 1) {
                                this.KiE.An(true);
                            } else {
                                this.KiE.An(false);
                            }
                        }
                        au(this.dom.GUe);
                        g.aAi();
                        ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().add(this);
                        ((PluginOpenIM) g.ah(PluginOpenIM.class)).getWordingInfoStg().add(this);
                        AppMethodBeat.o(35333);
                    }

                    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
                    public final void gIm() {
                    }

                    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
                    public final void gIn() {
                    }

                    @Override // com.tencent.mm.ui.chatting.d.b.u
                    public final void setVoiceInputShowCallback(ChatFooter.d dVar) {
                        AppMethodBeat.i(35326);
                        this.znD.setVoiceInputShowCallback(dVar);
                        AppMethodBeat.o(35326);
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f4, code lost:
                        if (r3 == false) goto L_0x00f6;
                     */
                    /* JADX WARNING: Removed duplicated region for block: B:59:0x0147  */
                    /* JADX WARNING: Removed duplicated region for block: B:7:0x0041  */
                    @Override // com.tencent.mm.ui.l
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final boolean onKeyDown(int r12, android.view.KeyEvent r13) {
                        /*
                        // Method dump skipped, instructions count: 333
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.x.onKeyDown(int, android.view.KeyEvent):boolean");
                    }

                    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
                    public final void cFx() {
                        AppMethodBeat.i(35334);
                        this.PpN = this.dom.Pwc.getStringExtra("smiley_product_id");
                        if (this.znD.xfU) {
                            ((ao) this.dom.bh(ao.class)).keepSignalling();
                        }
                        if (com.tencent.mm.model.ab.IW(this.dom.getTalkerUserName()) && this.PpJ != null && this.PpJ.Pid) {
                            this.PpJ.gNS();
                        }
                        ChatFooter chatFooter = this.znD;
                        BaseChattingUIFragment baseChattingUIFragment = this.dom.Pwc;
                        chatFooter.Kjx = baseChattingUIFragment;
                        chatFooter.a(baseChattingUIFragment.getContext(), baseChattingUIFragment.thisActivity());
                        if (chatFooter.KjY != null && chatFooter.KjY.isShowing()) {
                            chatFooter.KjY.dismiss();
                        }
                        chatFooter.ECK.refresh(((PluginWebSearch) g.ah(PluginWebSearch.class)).isUseSysEditText());
                        if (!Util.isNullOrNil(this.PpN) && this.znD != null) {
                            Log.d("MicroMsg.ChattingUI.FootComponent", "deal use smiley panel in product: %s", this.PpN);
                            this.znD.setDefaultSmileyByDetail(this.PpN);
                            this.znD.gqo();
                        }
                        this.dom.Pwc.getContext().getIntent().putExtra("smiley_product_id", "");
                        this.znD.setUserName(this.dom.getTalkerUserName());
                        com.tencent.mm.live.d.e.hTN = this.dom.getTalkerUserName();
                        this.znD.mC(this.dom.gRI(), this.dom.getTalkerUserName());
                        if (this.dom.Pwc.getBooleanExtra("key_show_bottom_app_panel", false).booleanValue()) {
                            ChatFooter chatFooter2 = this.znD;
                            if (chatFooter2.Kir != null) {
                                chatFooter2.Kir.performClick();
                                Log.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
                            }
                        }
                        if (au(this.dom.GUe)) {
                            if (this.znD != null) {
                                bg.aVF();
                                boolean booleanValue = ((Boolean) com.tencent.mm.model.c.azQ().get(66832, Boolean.FALSE)).booleanValue();
                                Log.d("MicroMsg.ChattingUI.FootComponent", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", Boolean.valueOf(booleanValue));
                                this.znD.gqS();
                                if (booleanValue) {
                                    this.znD.gqF();
                                    this.znD.gql();
                                }
                                if (booleanValue) {
                                    this.znD.gqu();
                                }
                                ChatFooter chatFooter3 = this.znD;
                                if (chatFooter3.Kik != null) {
                                    chatFooter3.Kik.gpL();
                                }
                            }
                            ((com.tencent.mm.ui.chatting.d.b.ar) this.dom.bh(com.tencent.mm.ui.chatting.d.b.ar.class)).gPJ();
                            if (this.znD != null) {
                                this.znD.Kik.refresh();
                                this.znD.addTextChangedListener(new a(this, (byte) 0));
                                Log.i("MicroMsg.ChattingUI.FootComponent", "addTextChangedListener");
                            }
                        }
                        boolean gRa = ((am) this.dom.bh(am.class)).gRa();
                        boolean gQZ = ((am) this.dom.bh(am.class)).gQZ();
                        boolean gPB = ((l) this.dom.bh(l.class)).gPB();
                        boolean IN = com.tencent.mm.model.ab.IN(this.dom.getTalkerUserName());
                        boolean gQN = ((ai) this.dom.bh(ai.class)).gQN();
                        if (((gRa || gQZ || gPB) && !this.PpR) || this.dom.GUe == null || this.dom.GUe.gBM() || com.tencent.mm.model.ab.Jz(this.dom.getTalkerUserName()) || com.tencent.mm.ui.widget.snackbar.b.bJw() || com.tencent.mm.model.ab.IP(this.dom.getTalkerUserName()) || IN || gQN) {
                            Log.i("MicroMsg.ChattingUI.FootComponent", "no call visibleFooter again.");
                        } else {
                            Log.i("MicroMsg.ChattingUI.FootComponent", "call visibleFooter again.");
                            gPU();
                        }
                        this.gsT.alive();
                        this.gsS.alive();
                        AppMethodBeat.o(35334);
                    }

                    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
                    public final void cFy() {
                        AppMethodBeat.i(35335);
                        if (this.znD != null) {
                            ChatFooter chatFooter = this.znD;
                            if (chatFooter.KkX != null) {
                                chatFooter.ECK.removeTextChangedListener(chatFooter.KkX);
                                chatFooter.KkX = null;
                            }
                            Log.i("MicroMsg.ChattingUI.FootComponent", "removeTextChangeListener");
                            this.znD.onPause();
                            this.gsT.dead();
                            this.gsS.dead();
                            if (!g.aAc()) {
                                Log.w("MicroMsg.ChattingUI.FootComponent", "account not ready");
                                AppMethodBeat.o(35335);
                                return;
                            }
                            bg.aVF();
                            com.tencent.mm.model.c.azQ().set(18, Integer.valueOf(this.znD.getMode()));
                            Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm old:%d footer:%d ", Integer.valueOf(this.PpI), Integer.valueOf(this.znD.getMode()));
                            if (this.PpI != this.znD.getMode()) {
                                this.PpI = this.znD.getMode();
                                bg.aVF();
                                az bjY = com.tencent.mm.model.c.aST().bjY(this.dom.getTalkerUserName());
                                if (bjY != null && this.dom.getTalkerUserName().equals(bjY.field_username)) {
                                    bjY.nu(this.PpI);
                                    bg.aVF();
                                    com.tencent.mm.model.c.aST().a(bjY, this.dom.getTalkerUserName());
                                }
                            }
                            this.znD.a(ChatFooter.h.Pause);
                            AppMethodBeat.o(35335);
                            return;
                        }
                        AppMethodBeat.o(35335);
                    }
                }
