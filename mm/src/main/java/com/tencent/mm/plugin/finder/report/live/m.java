package com.tencent.mm.plugin.finder.report.live;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.b.a.bd;
import com.tencent.mm.g.b.a.co;
import com.tencent.mm.g.b.a.cr;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.hellhound.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.t;
import com.tencent.mm.plugin.finder.live.viewmodel.c;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vending.j.d;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.n.n;
import org.apache.commons.b.g;
import org.json.JSONObject;

public final class m {
    private static s.bg UTa = s.bg.ANCHOR;
    private static boolean UTb;
    private static long enterTime;
    private static long feedId;
    private static long liveId;
    private static int liveStatus;
    private static String sBN = "";
    private static String sessionBuffer = "";
    private static int vkA;
    private static boolean vkB;
    private static long vkC;
    private static long vkD;
    private static long vkE;
    private static long vkF;
    private static boolean vkG;
    private static boolean vkH;
    private static boolean vkI;
    private static s.n vkJ = s.n.LIVE_LIVING;
    private static boolean vkK;
    private static s.am vkL = s.am.LIVE_SCREEN_HORIZONTAL;
    private static long vkM;
    private static long vkN;
    private static long vkO;
    private static long vkP;
    private static int vkQ;
    private static boolean vkR;
    private static boolean vkS;
    private static int vkT;
    private static int vkU;
    private static String vkV = "";
    private static final ArrayList<d<s.z, Long, Boolean>> vkW = new ArrayList<>();
    private static boolean vkX;
    private static boolean vkY;
    private static s.z vkZ = s.z.INVALIDATE;
    private static long vkg;
    private static String vkh = "";
    private static String vki = "";
    private static int vkj;
    private static int vkk;
    private static s.an vkl = s.an.LIVE_NO_SHOP_PERMIT;
    private static int vkm;
    private static int vkn;
    private static int vko;
    private static int vkp;
    private static int vkq;
    private static int vkr;
    private static ArrayList<String> vks = new ArrayList<>();
    private static int vkt;
    private static int vku;
    private static int vkv;
    private static int vkw;
    private static int vkx;
    private static int vky;
    private static int vkz;
    private static int vla;
    private static String vlb = "";
    private static boolean vlc;
    private static boolean vld;
    private static boolean vle;
    private static boolean vlf;
    private static String vlg = "";
    private static boolean vlh;
    public static final m vli = new m();

    static {
        AppMethodBeat.i(251005);
        AppMethodBeat.o(251005);
    }

    private m() {
    }

    public static long ahy() {
        return enterTime;
    }

    public static String getSessionBuffer() {
        return sessionBuffer;
    }

    public static void dpm() {
        vkB = true;
    }

    public static void a(s.n nVar) {
        AppMethodBeat.i(250984);
        p.h(nVar, "<set-?>");
        vkJ = nVar;
        AppMethodBeat.o(250984);
    }

    public static boolean dpn() {
        return vkR;
    }

    public static void ou(boolean z) {
        vkX = z;
    }

    public static void auP(String str) {
        AppMethodBeat.i(250985);
        p.h(str, "<set-?>");
        vlb = str;
        AppMethodBeat.o(250985);
    }

    public final void a(Integer num, int i2, s.al alVar) {
        boolean z = true;
        AppMethodBeat.i(250986);
        p.h(alVar, "event");
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            AppMethodBeat.o(250986);
            return;
        }
        KK(i2);
        if (vld) {
            vld = false;
            AppMethodBeat.o(250986);
        } else if (num == null) {
            AppMethodBeat.o(250986);
        } else {
            if (num.intValue() == 0) {
                switch (n.$EnumSwitchMapping$0[alVar.ordinal()]) {
                    case 1:
                    case 2:
                        break;
                    default:
                        kotlin.m mVar2 = new kotlin.m();
                        AppMethodBeat.o(250986);
                        throw mVar2;
                    case 3:
                        z = false;
                        break;
                }
                if (z) {
                    a(s.ar.EXPLORE_SCREEN_SWITCH_BTN, "");
                }
            }
            AppMethodBeat.o(250986);
        }
    }

    public final void KJ(int i2) {
        s.aj ajVar;
        AppMethodBeat.i(250987);
        vld = true;
        switch (i2) {
            case 1:
                if (!vlc) {
                    vkP++;
                    ajVar = s.aj.PORTRAIT_BY_ROTATE_PHONE;
                    break;
                } else {
                    vlc = false;
                    AppMethodBeat.o(250987);
                    return;
                }
            case 2:
                if (!vlc) {
                    vkN++;
                    ajVar = s.aj.HORIZONTAL_BY_ROTATE_PHONE;
                    break;
                } else {
                    vlc = false;
                    AppMethodBeat.o(250987);
                    return;
                }
            default:
                Log.e("HABBYGE-MALI.HellLiveVisitorReoprter", "reportSwitchScreen err:isAuto=true,screenAction=" + i2);
                AppMethodBeat.o(250987);
                return;
        }
        if (ajVar == s.aj.PORTRAIT_BY_ROTATE_PHONE || ajVar == s.aj.PORTRAIT_BY_CLICK_BTN) {
            vkL = s.am.LIVE_SCREEN_HORIZONTAL;
        } else if (ajVar == s.aj.HORIZONTAL_BY_ROTATE_PHONE || ajVar == s.aj.HORIZONTAL_BY_ROTATE_PHONE) {
            vkL = s.am.LIVE_SCREEN_PORTRAIT;
        }
        a(s.ar.SWITCH_SCREEN, String.valueOf(ajVar.action));
        if (vkL == s.am.LIVE_SCREEN_PORTRAIT) {
            vkL = s.am.LIVE_SCREEN_HORIZONTAL;
            AppMethodBeat.o(250987);
            return;
        }
        if (vkL == s.am.LIVE_SCREEN_HORIZONTAL) {
            vkL = s.am.LIVE_SCREEN_PORTRAIT;
        }
        AppMethodBeat.o(250987);
    }

    private static void KK(int i2) {
        s.am amVar;
        switch (i2) {
            case 1:
                amVar = s.am.LIVE_SCREEN_PORTRAIT;
                break;
            case 2:
                amVar = s.am.LIVE_SCREEN_HORIZONTAL;
                break;
            default:
                amVar = s.am.LIVE_SCREEN_PORTRAIT;
                break;
        }
        vkL = amVar;
    }

    public final void a(c cVar, int i2) {
        String str;
        s.an anVar;
        String str2;
        int i3;
        AppMethodBeat.i(261331);
        p.h(cVar, "liveData");
        long currentTimeMillis = System.currentTimeMillis();
        vkg = ((long) cVar.uCs.liveInfo.dvv) * 1000;
        liveId = cVar.uCs.liveInfo.liveId;
        sBN = cVar.uCs.hwd;
        c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        c.a.apC(sBN);
        List<t> list = cVar.uCs.uDs;
        p.g(list, "liveData.liveRoomData.msgList");
        t tVar = (t) j.kt(list);
        if (tVar == null || (str = tVar.getContent()) == null) {
            str = "";
        }
        vkh = str;
        feedId = cVar.uCs.hFK;
        String cNn = a.cNn();
        if (cNn == null) {
            cNn = "";
        }
        vki = cNn;
        k kVar = k.vkd;
        vkj = k.dpl().vma.type;
        k kVar2 = k.vkd;
        vkk = s.auU(sBN);
        Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "reportJoinLive: commentScene=" + vki + ", isPrivate=" + vkk);
        boolean z = cVar.uCs.uEk;
        boolean z2 = cVar.uCs.uit;
        if (z && z2) {
            anVar = s.an.LIVE_SHOP_PERMIT_SMALL_STORE;
        } else if (z) {
            anVar = s.an.LIVE_SHOP_PERMIT_NO_SMALL_STORE;
        } else {
            anVar = s.an.LIVE_NO_SHOP_PERMIT;
        }
        vkl = anVar;
        liveStatus = cVar.uCs.liveInfo.liveStatus;
        enterTime = currentTimeMillis;
        if (TextUtils.isEmpty(cVar.uCr.getSessionBuffer())) {
            str2 = n.j(bxW(vki), ",", ";", false);
        } else {
            String sessionBuffer2 = cVar.uCr.getSessionBuffer();
            if (sessionBuffer2 == null || (str2 = n.j(sessionBuffer2, ",", ";", false)) == null) {
                str2 = "";
            }
        }
        sessionBuffer = str2;
        vkm = 0;
        vkn = 0;
        vko = 0;
        vkp = 0;
        vkq = 0;
        vkr = 0;
        vks.clear();
        vkt = 0;
        vku = 0;
        vkv = 0;
        vkw = 0;
        vkx = 0;
        vkA = 0;
        KK(i2);
        c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
        if (c.a.asJ(sBN)) {
            i3 = s.EnumC1269s.FOLLOWED.state;
        } else {
            i3 = s.EnumC1269s.UNFOLLOW.state;
        }
        vky = i3;
        vkz = i3;
        vkB = false;
        vkC = currentTimeMillis;
        vkD = 0;
        vkE = 0;
        vkF = 0;
        vkG = false;
        vkH = false;
        vkI = false;
        vkJ = s.n.LIVE_LIVING;
        vkK = false;
        vkM = 0;
        vkN = 0;
        vkO = 0;
        vkP = 0;
        vkQ = 0;
        vlf = false;
        vlg = "";
        vkR = false;
        c.a aVar3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.hSh = true;
        vkS = true;
        vkX = false;
        vkY = false;
        vkZ = s.z.vpH;
        vkT = 0;
        vkU = 0;
        vkV = "";
        vkW.clear();
        vlh = false;
        vle = false;
        c.a aVar4 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEo = null;
        c.a aVar5 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEp = 0;
        Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "HABBYGE-MALI, reportJoinLive, liveId=" + liveId + ", feedId=" + feedId);
        a(s.ar.EnterRoom, (String) null);
        AppMethodBeat.o(261331);
    }

    public final void a(s.at atVar) {
        int i2;
        s.ax axVar;
        s.ax axVar2;
        AppMethodBeat.i(250988);
        p.h(atVar, "type");
        if (!vkS) {
            AppMethodBeat.o(250988);
            return;
        }
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        if (c.a.asJ(sBN)) {
            i2 = s.EnumC1269s.FOLLOWED.state;
        } else {
            i2 = s.EnumC1269s.UNFOLLOW.state;
        }
        vkz = i2;
        vkS = false;
        switch (n.vke[atVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                if (vkY) {
                    vkX = true;
                    switch (n.haE[vkZ.ordinal()]) {
                        case 1:
                            axVar = s.ax.ACTIVE_STOP_VIDEO_LINKMIC;
                            break;
                        case 2:
                            axVar = s.ax.ACTIVE_STOP_AUDIO_LINKMIC;
                            break;
                        default:
                            axVar = s.ax.INVALIDATE;
                            break;
                    }
                    a(this, axVar, (s.z) null, 6);
                    break;
                }
                break;
            default:
                if (vkY) {
                    vkX = false;
                    switch (n.uqL[vkZ.ordinal()]) {
                        case 1:
                            axVar2 = s.ax.ACTIVE_STOP_VIDEO_LINKMIC;
                            break;
                        case 2:
                            axVar2 = s.ax.ACTIVE_STOP_AUDIO_LINKMIC;
                            break;
                        default:
                            axVar2 = s.ax.INVALIDATE;
                            break;
                    }
                    a(this, axVar2, (s.z) null, 6);
                    break;
                }
                break;
        }
        a(s.ar.QuitRoom, String.valueOf(atVar.type));
        b(atVar);
        vkJ = s.n.LIVE_STOPPED;
        c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        if (c.a.apL(sBN)) {
            c.a aVar3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            c.a.cPl();
        }
        c.a aVar4 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.hSh = false;
        c.a aVar5 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        c.a.apC("");
        vkY = false;
        vkZ = s.z.vpH;
        vkW.clear();
        vkV = "";
        vkT = 0;
        vkU = 0;
        vla = 0;
        vlh = false;
        vle = false;
        c.a aVar6 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEo = null;
        c.a aVar7 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEp = 0;
        AppMethodBeat.o(250988);
    }

    public final void a(boolean z, s.r rVar) {
        AppMethodBeat.i(250989);
        p.h(rVar, "floatType");
        if (rVar == s.r.LIVE_FLOAT_ACTION_MAXIMIZE) {
            vkR = false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (vkG) {
                AppMethodBeat.o(250989);
                return;
            }
            if (vkC > 0) {
                long j2 = currentTimeMillis - vkC;
                long j3 = vkE;
                if (j2 <= 0) {
                    j2 = 0;
                }
                vkE = j2 + j3;
                vkC = 0;
            }
            vkD = currentTimeMillis;
            vkG = true;
            vko++;
        } else if (!vkG) {
            AppMethodBeat.o(250989);
            return;
        } else {
            if (vkD > 0) {
                long j4 = currentTimeMillis - vkD;
                long j5 = vkF;
                if (j4 <= 0) {
                    j4 = 0;
                }
                vkF = j4 + j5;
                vkD = 0;
            }
            vkC = currentTimeMillis;
            vkG = false;
        }
        if (rVar == s.r.LIVE_FLOAT_ACTION_UNKNOWN) {
            if (a.syQ) {
                rVar = s.r.LIVE_FLOAT_ACTION_MINIMIZE_FOR_BG;
            } else if (vkH) {
                rVar = s.r.LIVE_FLOAT_ACTION_MINIMIZE_FOR_WEAPP;
                vkH = false;
            } else {
                rVar = s.r.LIVE_FLOAT_ACTION_MINIMIZE_INTERACTIVE;
            }
        } else if (rVar == s.r.LIVE_FLOAT_ACTION_MAXIMIZE) {
            vkH = false;
        }
        if (vkK) {
            rVar = s.r.LIVE_FLOAT_ACTION_ENTER_PROFILE;
            vkK = false;
        }
        a(s.ar.Float, String.valueOf(rVar.type));
        AppMethodBeat.o(250989);
    }

    public final void a(String str, s.ba baVar) {
        AppMethodBeat.i(250990);
        p.h(baVar, "type");
        i iVar = new i();
        if (!g.eP(str)) {
            iVar.h(ch.COL_USERNAME, str);
        }
        iVar.U("type", baVar.type);
        if (baVar == s.ba.PERSIONAL_STATE_SHARE_SUCC) {
            c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEo = null;
        }
        a(s.ar.Share, iVar.toString());
        if (baVar != s.ba.Chat) {
            if (baVar == s.ba.Timeline) {
                vkp++;
            }
            AppMethodBeat.o(250990);
        } else if (str == null || !n.a((CharSequence) str, (CharSequence) "@chatroom", false)) {
            vkq++;
            AppMethodBeat.o(250990);
        } else {
            vkr++;
            AppMethodBeat.o(250990);
        }
    }

    public static void dpo() {
        AppMethodBeat.i(250991);
        vkx++;
        Log.d("HABBYGE-MALI.HellLiveVisitorReoprter", "HABBYGE-MALI, setForbidden: " + vkx);
        AppMethodBeat.o(250991);
    }

    public final void gP(String str, String str2) {
        AppMethodBeat.i(261332);
        JSONObject jSONObject = new JSONObject();
        if (str == null) {
            str = "";
        }
        jSONObject.put("content", URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        if (str2 == null) {
            str2 = "";
        }
        jSONObject.put("title", URLEncoder.encode(str2, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        a(s.ar.Message, jSONObject.toString());
        vkm++;
        AppMethodBeat.o(261332);
    }

    public final void hUG() {
        AppMethodBeat.i(261333);
        a(s.ar.Like, "1");
        vkn++;
        AppMethodBeat.o(261333);
    }

    public final void a(String str, s.k kVar) {
        AppMethodBeat.i(250992);
        p.h(kVar, "source");
        JSONObject jSONObject = new JSONObject();
        if (str == null) {
            str = "";
        }
        jSONObject.put(ch.COL_USERNAME, str);
        jSONObject.put("source", kVar.source);
        a(s.ar.CommentExpose, jSONObject.toString());
        vkw++;
        AppMethodBeat.o(250992);
    }

    public final void hUH() {
        AppMethodBeat.i(261334);
        a(s.ar.ComplaintEntry, (String) null);
        vkv++;
        AppMethodBeat.o(261334);
    }

    public final void a(s.h hVar) {
        AppMethodBeat.i(250993);
        p.h(hVar, NativeProtocol.WEB_DIALOG_ACTION);
        a(s.ar.HideOpearation, String.valueOf(hVar.action));
        if (hVar != s.h.CLICK_CLEAR_SCREEN_CANCEL) {
            vkt++;
        }
        AppMethodBeat.o(250993);
    }

    public final void hUI() {
        AppMethodBeat.i(261335);
        vkK = true;
        a(s.ar.EnterProfile, (String) null);
        vku++;
        AppMethodBeat.o(261335);
    }

    public static /* synthetic */ void a(m mVar, s.au auVar, String str, String str2) {
        AppMethodBeat.i(261337);
        mVar.a(auVar, str, str2, "", "", "");
        AppMethodBeat.o(261337);
    }

    public final void a(s.au auVar, String str, String str2, String str3, String str4, String str5) {
        Object obj;
        AppMethodBeat.i(261336);
        p.h(auVar, NativeProtocol.WEB_DIALOG_ACTION);
        p.h(str3, "canvasid");
        p.h(str4, "aid");
        p.h(str5, "uxinfo");
        i iVar = new i();
        switch (n.vkf[auVar.ordinal()]) {
            case 1:
                if (!vkI) {
                    vkI = true;
                    iVar.U("type", auVar.action);
                    iVar.h("canvasid", str3);
                    iVar.h("aid", str4);
                    iVar.h("uxinfo", str5);
                    break;
                } else {
                    AppMethodBeat.o(261336);
                    return;
                }
            case 2:
            case 3:
                vkI = false;
                iVar.U("type", auVar.action);
                iVar.h("canvasid", str3);
                iVar.h("aid", str4);
                iVar.h("uxinfo", str5);
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                iVar.U("type", auVar.action);
                iVar.h("canvasid", str3);
                iVar.h("aid", str4);
                iVar.h("uxinfo", str5);
                break;
        }
        iVar.U("commerceAction", auVar.action);
        if (!g.eP(str)) {
            iVar.h("session", str);
        }
        if (!g.eP(str2)) {
            iVar.h("productid", str2);
        }
        c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        iVar.h("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sED);
        c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        iVar.h("appid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEE);
        c.a aVar3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        if (TextUtils.isEmpty(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEF)) {
            obj = Long.valueOf(liveId);
        } else {
            c.a aVar4 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            obj = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEF;
        }
        iVar.h("liveid", obj);
        c.a aVar5 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        iVar.h("shopwindowid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEG);
        c.a aVar6 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        iVar.h("sessionid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEH);
        c.a aVar7 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        c.a.djP();
        a(s.ar.Commerce, iVar.toString());
        Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "reportCommerceAction, action=" + auVar.name() + ", shopSessionId=" + str + ", productId=" + str2);
        if ((auVar == s.au.CommerceActionBubbleTipClick || auVar == s.au.CommerceActionGoodsItemClick || auVar == s.au.CommerceActionPurchaseButtonClick) && str2 != null && !vks.contains(str2)) {
            vks.add(str2);
        }
        if (auVar == s.au.CommerceActionGoodsItemClick || auVar == s.au.CommerceActionGoodsOrderButtonClick) {
            vkH = true;
        }
        AppMethodBeat.o(261336);
    }

    public final void a(s.as asVar) {
        AppMethodBeat.i(250995);
        p.h(asVar, NativeProtocol.WEB_DIALOG_ACTION);
        a(s.ar.Auth, String.valueOf(asVar.action));
        AppMethodBeat.o(250995);
    }

    public final void bxV(String str) {
        AppMethodBeat.i(261338);
        p.h(str, "replyContent");
        i iVar = new i();
        iVar.h("content", str);
        a(s.ar.REPLY, iVar.toString());
        vkA++;
        AppMethodBeat.o(261338);
    }

    public static /* synthetic */ void a(m mVar, s.ax axVar, s.z zVar, int i2) {
        AppMethodBeat.i(250997);
        if ((i2 & 2) != 0) {
            zVar = s.z.INVALIDATE;
        }
        mVar.a(axVar, zVar, 0);
        AppMethodBeat.o(250997);
    }

    public final void a(s.ax axVar, s.z zVar, int i2) {
        AppMethodBeat.i(250996);
        p.h(axVar, NativeProtocol.WEB_DIALOG_ACTION);
        p.h(zVar, "linkeType");
        switch (n.vlj[axVar.ordinal()]) {
            case 1:
                if (i2 == 0) {
                    if (!vle) {
                        vle = true;
                        break;
                    } else {
                        AppMethodBeat.o(250996);
                        return;
                    }
                } else {
                    AppMethodBeat.o(250996);
                    return;
                }
            case 2:
                AppMethodBeat.o(250996);
                return;
            case 3:
            case 4:
                Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "reportLinkMic, action=" + axVar.name() + ", gLinkMicTimeList=" + vkW.size() + ", activeCloselinkMic=" + vkX);
                vkY = false;
                int size = vkW.size() - 1;
                while (true) {
                    if (size >= 0) {
                        d<s.z, Long, Boolean> dVar = vkW.get(size);
                        p.g(dVar, "gLinkMicTimeList[i]");
                        d<s.z, Long, Boolean> dVar2 = dVar;
                        if (dVar2.hdM() == a(axVar) && dVar2.hdN().longValue() > 0 && p.j(dVar2.hdO(), Boolean.FALSE)) {
                            long currentTimeMillis = System.currentTimeMillis();
                            Long hdN = dVar2.hdN();
                            p.g(hdN, "tuple.`$2`()");
                            long longValue = (currentTimeMillis - hdN.longValue()) / 1000;
                            if (longValue >= 0) {
                                vkW.set(size, com.tencent.mm.vending.j.a.i(dVar2.hdM(), Long.valueOf(longValue), Boolean.TRUE));
                            }
                        }
                        size--;
                    }
                }
                if (vkX) {
                    vkX = false;
                    break;
                } else {
                    AppMethodBeat.o(250996);
                    return;
                }
            case 5:
            case 6:
                vkT++;
                break;
            case 7:
                vkY = true;
                vkU++;
                if (zVar != s.z.INVALIDATE) {
                    vkZ = zVar;
                }
                vkW.add(com.tencent.mm.vending.j.a.i(vkZ, Long.valueOf(System.currentTimeMillis()), Boolean.FALSE));
                break;
            case 8:
                if (vkY) {
                    AppMethodBeat.o(250996);
                    return;
                }
                break;
        }
        a(s.ar.LINKMIC, String.valueOf(axVar.action));
        AppMethodBeat.o(250996);
    }

    public final void a(s.ay ayVar, String str) {
        String str2;
        AppMethodBeat.i(250998);
        p.h(ayVar, "type");
        switch (n.vlk[ayVar.ordinal()]) {
            case 1:
                vlf = false;
                vlg = "";
                break;
            case 2:
                vlf = true;
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                vlg = str2;
                break;
            case 3:
                if (vlf && !TextUtils.isEmpty(vlg)) {
                    str = vlg;
                    break;
                } else {
                    AppMethodBeat.o(250998);
                    return;
                }
            case 4:
                vkQ++;
                break;
            case 5:
                vkR = true;
                break;
            default:
                Log.e("HABBYGE-MALI.HellLiveVisitorReoprter", "reportLettery ERROR: " + ayVar.name());
                break;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", ayVar.type);
        if (str == null) {
            str = "";
        }
        jSONObject.put("result", str);
        a(s.ar.LOTTERY, jSONObject.toString());
        AppMethodBeat.o(250998);
    }

    public static void a(s.aw awVar, String str, int i2) {
        AppMethodBeat.i(250999);
        p.h(awVar, "type");
        long currentTimeMillis = System.currentTimeMillis();
        switch (n.vll[awVar.ordinal()]) {
            case 1:
                if (i2 == 0) {
                    if (!vlh) {
                        vlh = true;
                        break;
                    } else {
                        AppMethodBeat.o(250999);
                        return;
                    }
                } else {
                    AppMethodBeat.o(250999);
                    return;
                }
            case 2:
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEw = String.valueOf(enterTime);
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEx = currentTimeMillis;
                vla += i2;
                break;
            case 3:
            case 4:
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEw = String.valueOf(enterTime);
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEx = currentTimeMillis;
                break;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", awVar.type);
        jSONObject.put("giftid", str);
        jSONObject.put("num", i2);
        a(s.ar.GIFT, jSONObject.toString(), currentTimeMillis);
        AppMethodBeat.o(250999);
    }

    public final void a(s.ag agVar) {
        AppMethodBeat.i(251000);
        p.h(agVar, "result");
        a(s.ar.NEARBY_LIVE_MORE, String.valueOf(agVar.result));
        AppMethodBeat.o(251000);
    }

    public final void a(s.bh bhVar, s.bg bgVar, boolean z) {
        String valueOf;
        AppMethodBeat.i(261339);
        p.h(bhVar, "type");
        p.h(bgVar, "src");
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            AppMethodBeat.o(261339);
            return;
        }
        switch (n.TLD[bhVar.ordinal()]) {
            case 1:
                UTb = z;
                if (!z) {
                    AppMethodBeat.o(261339);
                    return;
                }
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                if (!UTb) {
                    AppMethodBeat.o(261339);
                    return;
                }
                break;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", bhVar.type);
        if (bgVar == s.bg.UNKNOWN) {
            valueOf = String.valueOf(UTa.src);
        } else {
            UTa = bgVar;
            valueOf = String.valueOf(bgVar.src);
        }
        jSONObject.put("source", valueOf);
        a(s.ar.RED_PACKET, jSONObject.toString());
        AppMethodBeat.o(261339);
    }

    public final void a(s.bd bdVar) {
        AppMethodBeat.i(261340);
        p.h(bdVar, NativeProtocol.WEB_DIALOG_ACTION);
        a(s.ar.FOLLOW_LIVE, String.valueOf(bdVar.action));
        AppMethodBeat.o(261340);
    }

    public final void a(s.bh bhVar, s.bg bgVar) {
        AppMethodBeat.i(261341);
        p.h(bhVar, "type");
        p.h(bgVar, "src");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", bhVar.type);
        jSONObject.put("source", bgVar.src);
        a(s.ar.RED_PACKET, jSONObject.toString());
        AppMethodBeat.o(261341);
    }

    public static /* synthetic */ void a(s.ar arVar, String str) {
        AppMethodBeat.i(261342);
        a(arVar, str, -1);
        AppMethodBeat.o(261342);
    }

    private static void a(s.ar arVar, String str, long j2) {
        String j3;
        boolean z;
        boolean z2;
        s.an anVar;
        long j4;
        long j5;
        String str2;
        String str3;
        String str4;
        long j6 = 0;
        AppMethodBeat.i(251001);
        if (vkJ == s.n.LIVE_STOPPED) {
            Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21084, LIVE_STOPPED, do need to report !");
            AppMethodBeat.o(251001);
            return;
        }
        if (j2 <= 0) {
            j2 = System.currentTimeMillis();
        }
        bd bdVar = new bd();
        bdVar.iQ(b.zs(liveId));
        bdVar.iR(b.zs(feedId));
        bdVar.iS(sBN);
        bdVar.iT(URLEncoder.encode(vkh, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        bdVar.iU(vki);
        bdVar.dg((long) vkk);
        String cND = b.cND();
        if (cND == null) {
            cND = "";
        }
        bdVar.iV(cND);
        String cNB = b.cNB();
        if (cNB == null) {
            cNB = "";
        }
        bdVar.iW(cNB);
        String cMD = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
        if (cMD == null) {
            cMD = "";
        }
        bdVar.iX(cMD);
        if (TextUtils.isEmpty(sessionBuffer)) {
            j3 = n.j(bxW(vki), ",", ";", false);
            sessionBuffer = j3;
        } else {
            j3 = n.j(sessionBuffer, ",", ";", false);
        }
        bdVar.iY(j3);
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
        if (dfZ != null) {
            z = dfZ.uEk;
        } else {
            z = false;
        }
        o oVar2 = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = o.dfZ();
        if (dfZ2 != null) {
            z2 = dfZ2.uit;
        } else {
            z2 = false;
        }
        if (z && z2) {
            anVar = s.an.LIVE_SHOP_PERMIT_SMALL_STORE;
        } else if (z) {
            anVar = s.an.LIVE_SHOP_PERMIT_NO_SMALL_STORE;
        } else {
            anVar = s.an.LIVE_NO_SHOP_PERMIT;
        }
        vkl = anVar;
        bdVar.dh((long) vkl.action);
        bdVar.di(enterTime);
        long j7 = j2 - vkg;
        if (j7 <= 0) {
            j7 = 0;
        }
        bdVar.dj(j7);
        long j8 = vkE;
        long j9 = vkF;
        if (vkG) {
            if (vkD > 0) {
                long j10 = j2 - vkD;
                if (j10 > 0) {
                    j6 = j10;
                }
                j4 = j9 + j6;
                j5 = j8;
            }
            j4 = j9;
            j5 = j8;
        } else {
            if (vkC > 0) {
                long j11 = j2 - vkC;
                if (j11 > 0) {
                    j6 = j11;
                }
                j5 = j6 + j8;
                j4 = j9;
            }
            j4 = j9;
            j5 = j8;
        }
        bdVar.dl(j4);
        bdVar.dk(j5);
        bdVar.dm(vkJ.jii);
        bdVar.dn(j2);
        bdVar.m8do((long) arVar.action);
        if (str == null || (str2 = n.j(str, ",", ";", false)) == null) {
            str2 = "";
        }
        bdVar.iZ(str2);
        k kVar = k.vkd;
        bdVar.dp(s.as(bdVar.ach(), (long) vkj));
        bdVar.dq((long) vkL.action);
        c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        bdVar.ja(n.j(c.a.apM(sBN), ",", ";", false));
        String str5 = vlb;
        if (str5 == null || (str3 = n.j(str5, ",", ";", false)) == null) {
            str3 = "";
        }
        bdVar.jb(str3);
        bdVar.PI(hUJ());
        o oVar3 = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ3 = o.dfZ();
        if (dfZ3 == null || (str4 = dfZ3.dPI) == null) {
            str4 = "";
        }
        bdVar.ahU(str4);
        bdVar.bfK();
        Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21084, liveId=" + bdVar.ace() + ", feedId=" + bdVar.acf() + ", username=" + bdVar.getUserName() + ", topic=" + bdVar.acg() + ", commentScene=" + bdVar.ach() + ", isPrivate=" + bdVar.aci() + ", contextId=" + bdVar.acj() + ", clickTabContextId=" + bdVar.ack() + ", sessionId=" + bdVar.acl() + ", sessionBuffer=" + bdVar.getSessionBuffer() + ", shopPermit=" + bdVar.acm() + ", enterSessionId=" + bdVar.acn() + ", liveTime=" + bdVar.aco() + ", floatDuration=" + bdVar.acq() + ", fullDuration=" + bdVar.acp() + ", enterStatus=" + bdVar.acr() + ", actionTS=" + bdVar.acs() + ", action=" + bdVar.act() + ", enterIconType=" + bdVar.acv() + ", pageType=" + bdVar.acw() + ", adData=" + bdVar.acx() + ", scenenote=" + bdVar.acy() + ", identityType=" + bdVar.ajX() + ", request_id=" + bdVar.ajY() + ", actionResult=" + bdVar.acu());
        AppMethodBeat.o(251001);
    }

    private static void b(s.at atVar) {
        long j2;
        long j3;
        long j4;
        String j5;
        String str;
        String str2;
        long j6 = 0;
        AppMethodBeat.i(251003);
        if (vkJ == s.n.LIVE_STOPPED) {
            Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21178, LIVE_STOPPED, do need to report !");
            AppMethodBeat.o(251003);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        co coVar = new co();
        coVar.mE(b.zs(liveId));
        coVar.mF(b.zs(feedId));
        coVar.mG(sBN);
        coVar.mH(URLEncoder.encode(vkh, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        coVar.gP(enterTime);
        long j7 = enterTime - vkg;
        if (j7 <= 0) {
            j7 = 0;
        }
        coVar.gQ(j7);
        long j8 = currentTimeMillis - vkg;
        if (j8 <= 0) {
            j8 = 0;
        }
        coVar.gR(j8);
        long j9 = currentTimeMillis - enterTime;
        if (j9 <= 0) {
            j9 = 0;
        }
        coVar.gS(j9);
        long j10 = vkF;
        long j11 = vkE;
        if (vkG) {
            if (vkD > 0) {
                long j12 = currentTimeMillis - vkD;
                if (j12 > 0) {
                    j6 = j12;
                }
                j3 = j6 + j10;
                j2 = coVar.getDuration() - j3;
            }
            j2 = j11;
            j3 = j10;
        } else {
            if (vkC > 0) {
                long j13 = currentTimeMillis - vkC;
                if (j13 > 0) {
                    j6 = j13;
                }
                j2 = j11 + j6;
                j3 = coVar.getDuration() - j2;
            }
            j2 = j11;
            j3 = j10;
        }
        coVar.gT(j3);
        coVar.gU(j2);
        coVar.gV(vkJ.jii);
        coVar.gW((long) vkm);
        coVar.adp();
        coVar.adr();
        coVar.gX((long) vkn);
        coVar.adu();
        coVar.gY((long) vks.size());
        coVar.gZ((long) vkt);
        coVar.ha((long) vko);
        coVar.hb((long) vkp);
        coVar.hc((long) vkq);
        coVar.hd((long) vkr);
        coVar.he((long) vku);
        coVar.hf((long) vkv);
        coVar.hg((long) vkw);
        coVar.hh((long) vkx);
        coVar.hi((long) vky);
        coVar.hj((long) vkz);
        if (vkB) {
            j4 = (long) s.bb.EXPOSURE.state;
        } else {
            j4 = (long) s.bb.NO_EXPOSURE.state;
        }
        coVar.hm(j4);
        coVar.hk((long) atVar.type);
        String cND = b.cND();
        if (cND == null) {
            cND = "";
        }
        coVar.mI(cND);
        String cNB = b.cNB();
        if (cNB == null) {
            cNB = "";
        }
        coVar.mJ(cNB);
        if (TextUtils.isEmpty(sessionBuffer)) {
            j5 = n.j(bxW(vki), ",", ";", false);
            sessionBuffer = j5;
        } else {
            j5 = n.j(sessionBuffer, ",", ";", false);
        }
        coVar.mK(j5);
        String cMD = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
        if (cMD == null) {
            cMD = "";
        }
        coVar.mL(cMD);
        coVar.hl((long) vkk);
        coVar.mM(vki);
        k kVar = k.vkd;
        coVar.hn(s.as(coVar.ach(), (long) vkj));
        coVar.ho(vkM);
        coVar.hp(vkN);
        coVar.hq(vkO);
        coVar.hr(vkP);
        coVar.hs((long) vkA);
        c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        coVar.mN(n.j(c.a.apM(sBN), ",", ";", false));
        coVar.ht((long) vkQ);
        coVar.hu((long) vkT);
        coVar.hv((long) vkU);
        c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        coVar.hx((long) com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEp);
        coVar.hw((long) vla);
        if (vkW.isEmpty()) {
            coVar.mO("");
        } else {
            String str3 = "";
            Iterator<d<s.z, Long, Boolean>> it = vkW.iterator();
            while (it.hasNext()) {
                d<s.z, Long, Boolean> next = it.next();
                Boolean hdO = next.hdO();
                p.g(hdO, "tuple.`$3`()");
                if (hdO.booleanValue()) {
                    str = str3 + next.hdM().type + '|' + next.hdN() + ';';
                } else {
                    str = str3;
                }
                str3 = str;
            }
            if (!p.j(str3, "")) {
                int length = str3.length() - 1;
                if (str3 == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(251003);
                    throw tVar;
                }
                str3 = str3.substring(0, length);
                p.g(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            coVar.mO(str3);
        }
        String str4 = vlb;
        if (str4 == null || (str2 = n.j(str4, ",", ";", false)) == null) {
            str2 = "";
        }
        coVar.mP(str2);
        coVar.bfK();
        Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21178, duration=" + coVar.getDuration() + ", floatDuration=" + coVar.acq() + ", fullDuration=" + coVar.acp() + ", diffTime=" + ((coVar.acp() + coVar.acq()) - coVar.getDuration()) + ", commentScene=" + coVar.ach() + ", pressLikeCount=" + coVar.ads() + ", enterStatus=" + coVar.acr() + ", acclaimCount=" + coVar.adv() + ", clickLikeCount=" + coVar.adq() + ", goodsClickCount=" + coVar.adw() + ", floatingCount=" + coVar.adx() + ", shareMoments=" + coVar.ady() + ", singleChat=" + coVar.adz() + ", groupChat=" + coVar.adA() + ", profileCount=" + coVar.adB() + ", complainAnchor=" + coVar.adC() + ", complainAudience=" + coVar.adD() + ", forbidden=" + coVar.adE() + ", enterFollow=" + coVar.adF() + ", exitFollow=" + coVar.adG() + ", exitType=" + coVar.adH() + ", contextId=" + coVar.acj() + ", clickTabContextId=" + coVar.ack() + ", sessionBuffer=" + coVar.getSessionBuffer() + ", sessionID=" + coVar.acl() + ", isPrivate=" + coVar.aci() + ", shopExp=" + coVar.adI() + ", enterIconType=" + coVar.acv() + ", clickToLandscape=" + coVar.adJ() + ", clickToPortrait=" + coVar.adL() + ", rotateToLandscape=" + coVar.adK() + ", rotateToPortrait=" + coVar.adM() + ", lotteryCount=" + coVar.adO() + ", adData=" + coVar.acx() + ", commentsCount=" + coVar.ado() + ", replycount=" + coVar.adN() + ", tryToConnectCount=" + coVar.adP() + ", connectSuccessCount=" + coVar.adQ() + ", connectDuration=" + coVar.adR() + ", giftCount=" + coVar.adS() + ", scenenote=" + coVar.acy() + "shareToStatus=" + coVar.adT() + "emojiCount=" + coVar.adt());
        AppMethodBeat.o(251003);
    }

    public static void a(s.az azVar, String str, long j2, String str2) {
        String str3;
        AppMethodBeat.i(251004);
        p.h(azVar, NativeProtocol.WEB_DIALOG_ACTION);
        if (s.az.Click == azVar) {
            a.lX(true);
        }
        cr crVar = new cr();
        if (str == null) {
            str = "";
        }
        crVar.ne(str);
        String cMD = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
        if (cMD == null) {
            cMD = "";
        }
        crVar.nf(cMD);
        crVar.hL(System.currentTimeMillis());
        crVar.hM((long) azVar.action);
        crVar.ng(b.zs(j2));
        crVar.aeh();
        if (str2 == null) {
            str2 = "";
        }
        crVar.nh(str2);
        String cND = b.cND();
        if (cND == null) {
            cND = "";
        }
        crVar.ni(cND);
        String cNB = b.cNB();
        if (cNB == null) {
            cNB = "";
        }
        crVar.nj(cNB);
        c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        crVar.nk(n.j(c.a.apM(crVar.aef()), ",", ";", false));
        String str4 = vlb;
        if (str4 == null || (str3 = n.j(str4, ",", ";", false)) == null) {
            str3 = "";
        }
        crVar.nl(str3);
        crVar.bfK();
        Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", "report21158, finderUsrName=" + crVar.aef() + ", finderSessionId=" + crVar.acJ() + ", actionTimeMs=" + crVar.acK() + ", actionType=" + crVar.acL() + ", enterLiveId=" + crVar.aeg() + ", enterStatus=" + crVar.acr() + ", commentscene=" + crVar.aei() + ", contextid=" + crVar.aej() + ", adData=" + crVar.acx() + ", scenenote=" + crVar.acy() + ", clickTabContextId=" + crVar.ack());
        AppMethodBeat.o(251004);
    }

    private static s.z a(s.ax axVar) {
        AppMethodBeat.i(261343);
        switch (n.UTc[axVar.ordinal()]) {
            case 1:
                s.z zVar = s.z.AUDIO;
                AppMethodBeat.o(261343);
                return zVar;
            case 2:
                s.z zVar2 = s.z.vpH;
                AppMethodBeat.o(261343);
                return zVar2;
            default:
                s.z zVar3 = s.z.INVALIDATE;
                AppMethodBeat.o(261343);
                return zVar3;
        }
    }

    private static long hUJ() {
        AppMethodBeat.i(261344);
        e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        long j2 = (long) aAh.azQ().getInt(ar.a.USERINFO_FINDER_LIVE_VISITOR_ROLE_INT_SYNC, 0);
        AppMethodBeat.o(261344);
        return j2;
    }

    private static String bxW(String str) {
        String str2;
        String G;
        String str3;
        AppMethodBeat.i(261345);
        if (!TextUtils.isEmpty(sessionBuffer)) {
            String str4 = sessionBuffer;
            AppMethodBeat.o(261345);
            return str4;
        }
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
        if (dfZ != null) {
            str2 = dfZ.sessionBuffer;
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (str2 == null || (str3 = n.j(str2, ",", ";", false)) == null) {
                str3 = "";
            }
            AppMethodBeat.o(261345);
            return str3;
        }
        if (p.j(str, s.j.COMMENT_SCENE_LIVE_ROOM_SLIDE.scene)) {
            k kVar = k.vkd;
            G = k.dpl().vlV;
        } else {
            if (!g.eP(str) && !n.a((CharSequence) str, (CharSequence) "temp", false)) {
                k kVar2 = k.vfA;
                G = k.G(feedId, Integer.parseInt(str));
                if (G == null) {
                    G = "";
                }
            }
            if (str2 == null || (r0 = n.j(str2, ",", ";", false)) == null) {
                String str5 = "";
            }
            AppMethodBeat.o(261345);
            return str5;
        }
        str2 = G;
        String str52 = "";
        AppMethodBeat.o(261345);
        return str52;
    }

    public static String hUK() {
        String str;
        AppMethodBeat.i(261346);
        if (!TextUtils.isEmpty(sessionBuffer)) {
            String str2 = sessionBuffer;
            AppMethodBeat.o(261346);
            return str2;
        }
        if (p.j(vki, s.j.COMMENT_SCENE_LIVE_ROOM_SLIDE.scene)) {
            k kVar = k.vkd;
            str = k.dpl().vlV;
        } else if (g.eP(vki) || n.a((CharSequence) vki, (CharSequence) "temp", false)) {
            str = "";
        } else {
            k kVar2 = k.vfA;
            str = k.G(feedId, Integer.parseInt(vki));
            if (str == null) {
                str = "";
            }
        }
        String j2 = n.j(str, ",", ";", false);
        AppMethodBeat.o(261346);
        return j2;
    }
}
