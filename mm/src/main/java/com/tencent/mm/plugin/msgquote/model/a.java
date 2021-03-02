package com.tencent.mm.plugin.msgquote.model;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.Pair;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.msgquote.a.b;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.util.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class a {
    public static String aH(ca caVar) {
        as Kn;
        ah Kd;
        AppMethodBeat.i(88794);
        if (caVar == null) {
            AppMethodBeat.o(88794);
            return "";
        }
        String cT = e.cT(caVar);
        String str = "";
        if (ab.Eq(caVar.field_talker) && (Kd = ((c) g.af(c.class)).aSX().Kd(caVar.field_talker)) != null) {
            String displayName = Kd.getDisplayName(cT);
            if (!Util.isNullOrNil(displayName)) {
                str = displayName;
            }
        }
        if (Util.isNullOrNil(str) && (Kn = ((l) g.af(l.class)).aSN().Kn(cT)) != null) {
            str = Kn.field_nickname;
        }
        if (Util.isNullOrNil(str)) {
            str = cT;
        }
        AppMethodBeat.o(88794);
        return str;
    }

    public static CharSequence a(Context context, float f2, ca caVar) {
        AppMethodBeat.i(88795);
        StringBuilder sb = new StringBuilder();
        String aH = aH(caVar);
        if (aH == null || aH.length() <= 0) {
            aH = BuildConfig.COMMAND;
        }
        sb.append((CharSequence) com.tencent.mm.pluginsdk.ui.span.l.b(context, aH, f2));
        sb.append("：");
        String a2 = a(context, caVar, ab.Eq(caVar.field_talker));
        if (!Util.isNullOrNil(a2)) {
            sb.append((CharSequence) com.tencent.mm.pluginsdk.ui.span.l.b(context, a2, f2));
        }
        AppMethodBeat.o(88795);
        return sb;
    }

    public static Pair<Boolean, CharSequence> a(Context context, float f2, ca caVar, MsgQuoteItem msgQuoteItem) {
        AppMethodBeat.i(88796);
        if (msgQuoteItem == null) {
            Pair<Boolean, CharSequence> pair = new Pair<>(Boolean.FALSE, "");
            AppMethodBeat.o(88796);
            return pair;
        }
        b Hk = ((com.tencent.mm.plugin.msgquote.a) g.ah(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().Hk(msgQuoteItem.zFI);
        if (Hk == null || Hk.field_status != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) com.tencent.mm.pluginsdk.ui.span.l.b(context, Util.nullAs(msgQuoteItem.zFL, BuildConfig.COMMAND), f2));
            sb.append("：");
            ca caVar2 = new ca();
            caVar2.setType(msgQuoteItem.type);
            caVar2.setContent(msgQuoteItem.content);
            caVar2.setMsgId(caVar.field_msgId);
            caVar2.Cy(msgQuoteItem.zFJ);
            String a2 = a(context, caVar2, false);
            if (!Util.isNullOrNil(a2)) {
                sb.append((CharSequence) com.tencent.mm.pluginsdk.ui.span.l.b(context, a2, f2));
            }
            if (Hk == null) {
                Log.e("MicroMsg.msgquote.MsgQuoteHelp", "getShowSummary() msgQute is null");
                if (Util.isNullOrNil(sb.toString())) {
                    Pair<Boolean, CharSequence> pair2 = new Pair<>(Boolean.FALSE, "");
                    AppMethodBeat.o(88796);
                    return pair2;
                }
            }
            Pair<Boolean, CharSequence> pair3 = new Pair<>(Boolean.TRUE, sb);
            AppMethodBeat.o(88796);
            return pair3;
        }
        Pair<Boolean, CharSequence> pair4 = new Pair<>(Boolean.FALSE, context.getString(R.string.f4f));
        AppMethodBeat.o(88796);
        return pair4;
    }

    private static String a(Context context, ca caVar, boolean z) {
        int Kp;
        AppMethodBeat.i(88797);
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        if (caVar == null) {
            AppMethodBeat.o(88797);
            return "";
        }
        String str = "";
        switch (caVar.getType()) {
            case 1:
            case 11:
            case 21:
            case 31:
            case 36:
            case 301989937:
                str = caVar.field_content;
                if (z && !aI(caVar) && (Kp = bp.Kp(str)) != -1) {
                    str = str.substring(Kp + 1);
                }
                if (str != null) {
                    str = str.trim();
                    break;
                }
                break;
            case 3:
            case 13:
            case 23:
            case 33:
            case 39:
            case 268435505:
                str = context.getString(R.string.f4e);
                break;
            case 43:
            case 44:
            case 62:
                str = context.getString(R.string.f4i);
                break;
            case 47:
                str = context.getString(R.string.f4_);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                str = context.getString(R.string.f4b);
                if (com.tencent.mm.br.c.aZU(FirebaseAnalytics.b.LOCATION)) {
                    ly lyVar = new ly();
                    lyVar.dRv.dRq = 1;
                    lyVar.dRv.dCM = caVar;
                    EventCenter.instance.publish(lyVar);
                    String str2 = lyVar.dRw.dRy;
                    String str3 = lyVar.dRw.dNk;
                    if (!g(str2, context)) {
                        if (aFt(lyVar.dRw.dNk)) {
                            str = str + str3;
                            break;
                        }
                    } else {
                        str = str + str2;
                        break;
                    }
                }
                break;
            case 49:
            case 805306417:
            case 822083633:
                k.b HD = k.b.HD(caVar.field_content);
                if (HD != null) {
                    switch (HD.type) {
                        case 1:
                        case 53:
                        case n.CTRL_INDEX:
                            if (HD.title != null && HD.title.length() > 0) {
                                str = HD.title;
                                break;
                            }
                        case 3:
                        case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                            if (HD.title != null && HD.title.length() > 0) {
                                str = context.getString(R.string.f4c, HD.title);
                                break;
                            } else {
                                str = context.getString(R.string.f4c, "");
                                break;
                            }
                            break;
                        case 4:
                            str = context.getString(R.string.f4i);
                            break;
                        case 5:
                            if (HD.title != null && HD.title.length() > 0) {
                                str = context.getString(R.string.f4h, HD.title);
                                break;
                            } else {
                                str = context.getString(R.string.f4h, "");
                                break;
                            }
                            break;
                        case 6:
                            if (HD.title != null && HD.title.length() > 0) {
                                str = context.getString(R.string.f4a, HD.title);
                                break;
                            } else {
                                str = context.getString(R.string.f4a, "");
                                break;
                            }
                        case 24:
                            str = context.getString(R.string.f4d, e(HD));
                            break;
                        case 33:
                        case 36:
                        case 44:
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            if (HD.title != null && HD.title.length() > 0) {
                                str = context.getString(R.string.f48, HD.title);
                                break;
                            } else {
                                str = context.getString(R.string.f48, "");
                                break;
                            }
                    }
                }
                break;
            case 1040187441:
                k.b HD2 = k.b.HD(caVar.field_content);
                if (HD2.title != null && HD2.title.length() > 0) {
                    str = context.getString(R.string.f4c, HD2.title);
                    break;
                } else {
                    str = context.getString(R.string.f4c, "");
                    break;
                }
                break;
            default:
                str = context.getString(R.string.f49);
                break;
        }
        if (!Util.isNullOrNil(str)) {
            str = str.replace('\n', ' ');
        }
        AppMethodBeat.o(88797);
        return str;
    }

    private static boolean g(String str, Context context) {
        AppMethodBeat.i(88798);
        if (str == null || str.equals("") || str.equals(context.getResources().getString(R.string.f4b))) {
            AppMethodBeat.o(88798);
            return false;
        }
        AppMethodBeat.o(88798);
        return true;
    }

    private static boolean aFt(String str) {
        AppMethodBeat.i(88799);
        if (str == null || str.equals("") || str.equals("err_not_started")) {
            AppMethodBeat.o(88799);
            return false;
        }
        AppMethodBeat.o(88799);
        return true;
    }

    private static String e(k.b bVar) {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(88800);
        rc rcVar = new rc();
        rcVar.dXF.type = 0;
        rcVar.dXF.dXH = bVar.ixl;
        EventCenter.instance.publish(rcVar);
        com.tencent.mm.protocal.b.a.c cVar = rcVar.dXG.dXP;
        String str4 = null;
        Iterator<aml> it = cVar.iAd.iterator();
        boolean z = false;
        while (it.hasNext()) {
            aml next = it.next();
            if (!com.tencent.mm.plugin.fav.ui.l.j(next) || Util.isNullOrNil(next.Lwp) || !next.Lwp.equals("WeNoteHtmlFile")) {
                switch (next.dataType) {
                    case 1:
                        if (!z) {
                            String str5 = next.desc;
                            if (Util.isNullOrNil(str5)) {
                                break;
                            } else {
                                if (!Util.isNullOrNil(str5.replaceAll("\n", "").trim())) {
                                    str3 = next.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                                } else {
                                    str3 = str4;
                                }
                                z = true;
                                str4 = str3;
                                break;
                            }
                        } else {
                            continue;
                        }
                }
            }
        }
        if (str4 != null) {
            String[] split = str4.split("\n", 2);
            ArrayList arrayList = new ArrayList();
            if (split.length > 0) {
                for (String str6 : split) {
                    if (str6.length() > 0) {
                        arrayList.add(str6);
                    }
                }
            }
            if (arrayList.size() == 1 && cVar.iAd.size() == 2) {
                str2 = "";
            } else {
                str2 = (String) arrayList.get(0);
            }
            str = str2.trim();
        } else {
            str = "";
        }
        if (str != null) {
            str = str.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        }
        AppMethodBeat.o(88800);
        return str;
    }

    public static MsgQuoteItem a(ca caVar, int i2, CharSequence charSequence, int i3, HashMap<String, String> hashMap) {
        String charSequence2;
        AppMethodBeat.i(201796);
        if (caVar == null) {
            AppMethodBeat.o(201796);
            return null;
        }
        MsgQuoteItem msgQuoteItem = new MsgQuoteItem();
        msgQuoteItem.type = i2;
        msgQuoteItem.zFI = caVar.field_msgSvrId;
        msgQuoteItem.zFJ = Util.nullAs(caVar.field_talker, "");
        msgQuoteItem.zFK = Util.nullAs(e.cT(caVar), "");
        if (Util.isNullOrNil(charSequence)) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence.toString();
        }
        msgQuoteItem.zFL = Util.nullAs(charSequence2, "");
        msgQuoteItem.zFM = Util.nullAs(caVar.fqK, "");
        if (caVar.gDy()) {
            String nullAs = Util.nullAs(e.cU(caVar), "");
            try {
                int indexOf = nullAs.indexOf("<refermsg>", 0);
                int lastIndexOf = nullAs.lastIndexOf("</refermsg>");
                msgQuoteItem.content = nullAs.substring(0, indexOf) + "<refermsg>" + nullAs.substring(lastIndexOf);
            } catch (Exception e2) {
                msgQuoteItem.content = nullAs;
                Log.e("MicroMsg.msgquote.MsgQuoteHelp", "getMsgQuoteItem Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            }
        } else {
            msgQuoteItem.content = Util.nullAs(e.cU(caVar), "");
        }
        String b2 = e.b(((w) g.af(w.class)).Z(caVar), hashMap, i3);
        if (!Util.isNullOrNil(b2)) {
            Log.d("MicroMsg.msgquote.MsgQuoteHelp", "MsgSource:%s", b2);
        }
        msgQuoteItem.fqK = Util.nullAs(b2, "");
        AppMethodBeat.o(201796);
        return msgQuoteItem;
    }

    public static boolean elr() {
        AppMethodBeat.i(88801);
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_msg_quote_sencond_stage_switch, 0) == 1) {
            AppMethodBeat.o(88801);
            return true;
        }
        AppMethodBeat.o(88801);
        return false;
    }

    private static boolean aI(ca caVar) {
        if (caVar.field_isSend == 1) {
            return true;
        }
        return false;
    }
}
