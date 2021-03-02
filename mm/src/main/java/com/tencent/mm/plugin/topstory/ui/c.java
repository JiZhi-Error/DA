package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.xx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.protocal.protobuf.eis;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tav.coremedia.TimeUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static com.tencent.mm.av.a.a.c GjU;
    public static com.tencent.mm.av.a.a.c GjV;

    static {
        AppMethodBeat.i(125890);
        c.a aVar = new c.a();
        aVar.jbf = true;
        aVar.jbe = true;
        aVar.iaT = true;
        aVar.jbq = R.drawable.bca;
        GjU = aVar.bdv();
        c.a aVar2 = new c.a();
        aVar2.jbf = true;
        aVar2.jbe = true;
        aVar2.jbq = R.drawable.bca;
        GjV = aVar2.bdv();
        AppMethodBeat.o(125890);
    }

    public static void aW(String str, String str2, String str3) {
        AppMethodBeat.i(125872);
        Log.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI, appid:%s", str2);
        if (h.o(str2, true, false) == null) {
            n.d(str, "", str2, -1, "appinfo error: not found.");
            Log.i("MicroMsg.TopStory.TopStoryUILogic", "startTopStoryUploadUI appinfo error");
            AppMethodBeat.o(125872);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            JSONObject jSONObject2 = jSONObject.getJSONObject("source");
            int optInt = jSONObject2.optInt("type");
            String string = jSONObject2.getString("title");
            String optString = jSONObject2.optString("description", "");
            String string2 = jSONObject2.getString("thumbUrl");
            String string3 = jSONObject.getString("appVersion");
            String optString2 = jSONObject2.optString("mediaName", "");
            String optString3 = jSONObject2.optString("mediaHeadUrl", "");
            Intent intent = new Intent();
            intent.putExtra("KEY_TYPE", optInt);
            intent.putExtra("KEY_BIZTYPE", str);
            intent.putExtra("KEY_APPID", str2);
            intent.putExtra("KEY_EXTINFO", str3);
            intent.putExtra("KEY_TITLE", string);
            intent.putExtra("KEY_DESC", optString);
            intent.putExtra("KEY_THUMBURL", string2);
            intent.putExtra("KEY_APPVERSION", string3);
            intent.putExtra("KEY_MEDIANAME", optString2);
            intent.putExtra("KEY_MEDIAHEADURL", optString3);
            intent.addFlags(268435456).addFlags(32768);
            ai.e(MMApplicationContext.getContext(), ".ui.home.TopStoryUploadUI", intent);
            AppMethodBeat.o(125872);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryUILogic", e2, "startTopStoryUploadUI", new Object[0]);
            n.d(str, "", str2, -1, "extInfo error: parse failed.");
            AppMethodBeat.o(125872);
        }
    }

    public static void as(Context context, int i2) {
        AppMethodBeat.i(125873);
        a(context, i2, (Bundle) null, "");
        AppMethodBeat.o(125873);
    }

    public static void a(Context context, int i2, Bundle bundle, String str) {
        int i3;
        String str2;
        String str3;
        int i4;
        int abP;
        int i5;
        boolean z;
        int i6;
        AppMethodBeat.i(125874);
        Log.i("MicroMsg.TopStory.TopStoryUILogic", "click top story scene %d version %d ", Integer.valueOf(i2), Integer.valueOf(ai.aft(1)));
        if (((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxl()) {
            eiq fxo = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxo();
            String str4 = fxo.msgId;
            ar.a(fxo, 102, 1, 0, 0, "");
            i3 = 1;
            str2 = str4;
        } else {
            i3 = 0;
            str2 = "";
        }
        int fxu = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxu();
        if (fxu > 0) {
            ar.a(((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxw(), 102, 2, fxu, 0, "");
        }
        if (((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxB()) {
            ar.a(((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxr(), 102, 3, 0, 0, "");
        }
        if (fyg()) {
            fyh();
            Log.i("MicroMsg.TopStory.TopStoryUILogic", "TopStoryHomeUI Exist And Clear");
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        String string = context.getString(R.string.dkf);
        final eii eii = new eii();
        eii.sGQ = fyi();
        eii.scene = i2;
        eii.hes = "";
        eii.dDv = string;
        eii.channelId = 100;
        eii.GjO = ((PluginTopStoryUI) g.ah(PluginTopStoryUI.class)).getFirstLoadWebView();
        String afq = ai.afq(i2);
        eii.sessionId = afq;
        eii.dVO = afq;
        eii.nbg = string;
        eii.Nhz = 1;
        eii.wib = ai.ait();
        eii.NhA = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType().name();
        a((List<aca>) eii.IDO, str2, valueOf, true);
        b(eii, "clickTopStory", System.currentTimeMillis());
        final boolean z2 = true;
        Intent intent = new Intent();
        try {
            if (d.KyO >= 654311424 || d.KyS) {
                str3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_topstory_top_tab_params, "{\"tabs\":[{\"wording\":\"好看\",\"wording_cn\":\"好看\",\"wording_en\":\"Wow\",\"wording_hk\":\"好看\",\"wording_tw\":\"好看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"精选\",\"wording_cn\":\"精选\",\"wording_en\":\"Recommended\",\"wording_hk\":\"精選\",\"wording_tw\":\"精選\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
            } else {
                str3 = "";
            }
            String fxC = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxC();
            List<b> aTy = aTy(str3);
            if (!aTy.isEmpty()) {
                boolean z3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_topstory_tab_reddot_select, 0) == 0;
                Log.i("MicroMsg.TopStory.TopStoryUILogic", "haokanfirst:%s", Boolean.valueOf(z3));
                if (z3) {
                    int fyf = fyf();
                    if (fyf == 0) {
                        i6 = 110;
                    } else {
                        i6 = fyf;
                    }
                    abP = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().abP(i6);
                } else {
                    int fyf2 = fyf();
                    if (fyf2 == 0) {
                        i4 = 100;
                    } else {
                        i4 = fyf2;
                    }
                    abP = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().abP(i4);
                }
                int i7 = aTy.get(0).category;
                String str5 = aTy.get(0).Gkb;
                int i8 = 0;
                while (true) {
                    if (i8 >= aTy.size()) {
                        i5 = i7;
                        break;
                    } else if (aTy.get(i8).category == abP) {
                        str5 = aTy.get(i8).Gkb;
                        i5 = abP;
                        break;
                    } else {
                        i8++;
                    }
                }
                eii.url = com.tencent.mm.plugin.topstory.a.h.a(i2, afq, string, valueOf, str2, str5, i3, fxu, fxC, str);
                intent.putExtra("key_tabconfig", str3);
                intent.putExtra("key_chosetab", i5);
                if (i5 == 110) {
                    z = false;
                } else {
                    z = true;
                }
                z2 = z;
            } else {
                eii.url = com.tencent.mm.plugin.topstory.a.h.a(i2, afq, string, valueOf, str2, "", 0, 0, fxC, str);
                intent.putExtra("key_tabconfig", "");
                intent.putExtra("key_chosetab", 0);
            }
            intent.putExtra("key_context", eii.toByteArray());
        } catch (IOException e2) {
        }
        if (bundle != null) {
            intent.putExtra("key_extra_data", bundle);
        }
        intent.addFlags(67108864);
        ai.e(context, ".ui.home.TopStoryHomeUI", intent);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(125865);
                ((b) g.ah(b.class)).getWebViewMgr().a(eii, z2);
                AppMethodBeat.o(125865);
            }
        });
        ((PluginTopStoryUI) g.ah(PluginTopStoryUI.class)).setFirstLoadWebView(1);
        g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_HOME_UI_TIMESTAMP_LONG, Long.valueOf(System.currentTimeMillis()));
        ((com.tencent.mm.plugin.boots.a.c) g.af(com.tencent.mm.plugin.boots.a.c.class)).fb(com.tencent.mm.plugin.boots.a.b.pkr, 884);
        AppMethodBeat.o(125874);
    }

    public static void a(Context context, eii eii) {
        AppMethodBeat.i(236380);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("path", "good-look-history");
            jSONObject.put("subscene", 6);
            jSONObject.put("tagId", 10802);
            jSONObject.put("nickname", URLEncoder.encode((String) g.aAh().azQ().get(4, (Object) null), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryUILogic", e2, "goUserProfiler", new Object[0]);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("scene", "21");
        hashMap.put("sessionId", eii.sessionId);
        hashMap.put("extParams", jSONObject.toString());
        hashMap.put(IssueStorage.COLUMN_EXT_INFO, ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxG());
        hashMap.put(Scopes.PROFILE, "1");
        try {
            hashMap.put("deviceName", URLEncoder.encode(d.DEVICE_NAME, "utf8"));
            hashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
            hashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
            hashMap.put("ostype", d.KyK);
        } catch (UnsupportedEncodingException e3) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryUILogic", e3, "", new Object[0]);
        }
        eii eii2 = new eii();
        eii2.sGQ = fyi();
        eii2.scene = 21;
        eii2.hes = "";
        eii2.dDv = "";
        eii2.sessionId = eii.sessionId;
        eii2.dVO = eii.dVO;
        eii2.Nhz = 2;
        eii2.url = com.tencent.mm.plugin.topstory.a.h.n(hashMap);
        eii2.nbg = "";
        eii2.channelId = 10802;
        eii2.wib = ai.ait();
        eii2.wwG = context.getResources().getColor(R.color.afz);
        aca aca = new aca();
        aca.key = "rec_category";
        aca.LmC = (long) eii.channelId;
        aca.LmD = String.valueOf(eii.channelId);
        eii2.IDO.add(aca);
        a(context, eii2, "", false);
        AppMethodBeat.o(236380);
    }

    public static int fyf() {
        AppMethodBeat.i(125875);
        if (g.aAh().azQ().getInt(ar.a.USERINFO_TOP_STORY_HAS_HAOKAN_RESULT_INT, 1) == 1) {
            int i2 = g.aAh().azQ().getInt(ar.a.USERINFO_TOP_STORY_LAST_ENTER_TAB_REC_INT, 0);
            AppMethodBeat.o(125875);
            return i2;
        }
        AppMethodBeat.o(125875);
        return 100;
    }

    public static List<b> aTy(String str) {
        eiq fxo;
        eiq fxw;
        AppMethodBeat.i(125876);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("tabs");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                b bVar = new b();
                bVar.category = jSONObject.getInt("category");
                String applicationLanguage = LocaleUtil.getApplicationLanguage();
                if (applicationLanguage.equals(LocaleUtil.TAIWAN)) {
                    bVar.dQx = jSONObject.getString("wording_tw");
                } else if (applicationLanguage.equals(LocaleUtil.HONGKONG)) {
                    bVar.dQx = jSONObject.getString("wording_hk");
                } else if (applicationLanguage.equals(LocaleUtil.CHINA)) {
                    bVar.dQx = jSONObject.getString("wording_cn");
                } else {
                    bVar.dQx = jSONObject.getString("wording_en");
                }
                if (Util.isNullOrNil(bVar.dQx)) {
                    arrayList.clear();
                    AppMethodBeat.o(125876);
                    return arrayList;
                }
                bVar.Gka = jSONObject.getInt("showWhenRedDot") == 1;
                bVar.Gkb = jSONObject.getString("tabInfo");
                if (bVar.category == 110) {
                    bVar.Gkc = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxl() ? 1 : 0;
                    bVar.Gkd = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxu();
                    if (bVar.Gkd > 0 && (fxw = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxw()) != null) {
                        bVar.Gkf = fxw.msgId;
                    }
                    if (bVar.Gkc > 0 && (fxo = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxo()) != null) {
                        bVar.Gke = fxo.msgId;
                    }
                } else if (bVar.category == 100) {
                    bVar.Gkc = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxB() ? 1 : 0;
                    if (bVar.Gkc > 0) {
                        bVar.Gke = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxC();
                    }
                }
                arrayList.add(bVar);
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.TopStory.TopStoryUILogic", "parse tabconfig failed: %s", e2.getMessage());
            arrayList.clear();
        }
        AppMethodBeat.o(125876);
        return arrayList;
    }

    public static void a(Context context, eii eii, String str) {
        AppMethodBeat.i(125877);
        a(context, eii, str, true);
        AppMethodBeat.o(125877);
    }

    public static void a(Context context, final eii eii, String str, final boolean z) {
        AppMethodBeat.i(125878);
        a((List<aca>) eii.IDO, "", str, false);
        b(eii, "clickTopStory", System.currentTimeMillis());
        Intent intent = new Intent();
        try {
            intent.putExtra("key_context", eii.toByteArray());
        } catch (IOException e2) {
        }
        ai.e(context, ".ui.home.TopStoryTabHomeUI", intent);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(125866);
                ((b) g.ah(b.class)).getWebViewMgr().a(eii, z);
                AppMethodBeat.o(125866);
            }
        });
        AppMethodBeat.o(125878);
    }

    public static final String bu(String str, long j2) {
        AppMethodBeat.i(125879);
        String str2 = str + "_" + j2;
        AppMethodBeat.o(125879);
        return str2;
    }

    private static void a(List<aca> list, String str, String str2, boolean z) {
        AppMethodBeat.i(125880);
        aca aca = new aca();
        aca.key = "redPointMsgId";
        aca.LmD = String.valueOf(str);
        list.add(aca);
        aca aca2 = new aca();
        aca2.key = "currentPage";
        aca2.LmC = 1;
        list.add(aca2);
        aca aca3 = new aca();
        aca3.key = "is_prefetch";
        aca3.LmC = 0;
        list.add(aca3);
        if (!Util.isNullOrNil(str2)) {
            aca aca4 = new aca();
            aca4.key = "seq";
            aca4.LmD = str2;
            list.add(aca4);
            aca aca5 = new aca();
            aca5.key = "requestId";
            aca5.LmD = str2;
            list.add(aca5);
        }
        aca aca6 = new aca();
        aca6.key = "recType";
        aca6.LmC = 0;
        list.add(aca6);
        if (z) {
            aca aca7 = new aca();
            aca7.key = TencentLocation.EXTRA_DIRECTION;
            aca7.LmC = 1;
            list.add(aca7);
            aca aca8 = new aca();
            aca8.key = "time_zone_min";
            TimeZone timeZone = TimeZone.getDefault();
            aca8.LmD = new StringBuilder().append(((0 - timeZone.getOffset(GregorianCalendar.getInstance(timeZone).getTimeInMillis())) / 1000) / 60).toString();
            list.add(aca8);
        }
        AppMethodBeat.o(125880);
    }

    private static boolean fyg() {
        AppMethodBeat.i(125881);
        xx xxVar = new xx();
        xxVar.eei.actionType = 1;
        EventCenter.instance.publish(xxVar);
        boolean z = xxVar.eej.eek;
        AppMethodBeat.o(125881);
        return z;
    }

    private static void fyh() {
        AppMethodBeat.i(125882);
        xx xxVar = new xx();
        xxVar.eei.actionType = 2;
        EventCenter.instance.publish(xxVar);
        AppMethodBeat.o(125882);
    }

    public static final String fyi() {
        AppMethodBeat.i(125883);
        xx xxVar = new xx();
        xxVar.eei.actionType = 3;
        EventCenter.instance.publish(xxVar);
        String str = "";
        if (xxVar.eej.eel != null) {
            str = xxVar.eej.eel.sGQ;
        }
        if (Util.isNullOrNil(str)) {
            String uuid = UUID.randomUUID().toString();
            AppMethodBeat.o(125883);
            return uuid;
        }
        AppMethodBeat.o(125883);
        return str;
    }

    private static void b(eii eii, String str, long j2) {
        AppMethodBeat.i(125884);
        i.a(eii, str, j2);
        if (eii.Nhy.size() != 0) {
            AppMethodBeat.o(125884);
            return;
        }
        eis eis = new eis();
        eis.name = str;
        eis.timestamp = j2;
        eii.Nhy.add(eis);
        AppMethodBeat.o(125884);
    }

    public static final void c(eii eii, String str, long j2) {
        AppMethodBeat.i(125885);
        i.a(eii, str, j2);
        if (eii.Nhy.size() > 0) {
            eis eis = new eis();
            eis.name = str;
            eis.timestamp = j2;
            eii.Nhy.add(eis);
        }
        AppMethodBeat.o(125885);
    }

    public static final String a(eii eii) {
        AppMethodBeat.i(125886);
        Collections.sort(eii.Nhy, new Comparator<eis>() {
            /* class com.tencent.mm.plugin.topstory.ui.c.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(eis eis, eis eis2) {
                AppMethodBeat.i(125867);
                int compare = Long.compare(eis.timestamp, eis2.timestamp);
                AppMethodBeat.o(125867);
                return compare;
            }
        });
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 1; i2 < eii.Nhy.size(); i2++) {
            stringBuffer.append(eii.Nhy.get(i2 - 1).name);
            stringBuffer.append("->");
            stringBuffer.append(eii.Nhy.get(i2).name);
            stringBuffer.append(":");
            stringBuffer.append(eii.Nhy.get(i2).timestamp - eii.Nhy.get(i2 - 1).timestamp);
            stringBuffer.append("\n");
        }
        if (eii.Nhy.size() > 2) {
            stringBuffer.append("TotalUseTime:");
            stringBuffer.append(eii.Nhy.get(eii.Nhy.size() - 1).timestamp - eii.Nhy.get(0).timestamp);
            stringBuffer.append("\n");
        }
        eii.Nhy.clear();
        stringBuffer.append("============");
        stringBuffer.append("\n");
        if (com.tencent.mm.plugin.topstory.a.h.fxR()) {
            ThreadPool.post(new a(stringBuffer.toString()), "TopStory.SaveTraceTask");
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(125886);
        return stringBuffer2;
    }

    public static void aTz(String str) {
        AppMethodBeat.i(125887);
        final com.tencent.mm.plugin.topstory.a.c.d dVar = new com.tencent.mm.plugin.topstory.a.c.d(str);
        g.azz().a(dVar.getType(), new com.tencent.mm.ak.i() {
            /* class com.tencent.mm.plugin.topstory.ui.c.AnonymousClass4 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(125868);
                g.azz().b(dVar.getType(), this);
                if (i2 == 0 && i3 == 0) {
                    String str2 = ((com.tencent.mm.plugin.topstory.a.c.d) qVar).fyb().username;
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", str2);
                    intent.putExtra("Contact_Scene", 3);
                    if (str2 != null && str2.length() > 0) {
                        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    }
                    AppMethodBeat.o(125868);
                    return;
                }
                Log.e("MicroMsg.TopStory.TopStoryUILogic", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                AppMethodBeat.o(125868);
            }
        });
        g.azz().a(dVar, 0);
        AppMethodBeat.o(125887);
    }

    public static void hw(Context context) {
        AppMethodBeat.i(125888);
        com.tencent.mm.plugin.websearch.api.ar.q("", 0, 0, 100);
        ai.e(context, ".ui.home.TopStorySettingUI", new Intent());
        AppMethodBeat.o(125888);
    }

    static class a implements Runnable {
        String GjZ;

        public a(String str) {
            this.GjZ = str;
        }

        public final void run() {
            AppMethodBeat.i(125869);
            o oVar = new o(com.tencent.mm.loader.j.b.aKJ() + "topstory/trace.info");
            if (oVar.exists() && oVar.length() > 2048) {
                oVar.delete();
            }
            if (!oVar.heq().exists()) {
                oVar.heq().mkdirs();
            }
            this.GjZ = "Trace:\n" + f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, System.currentTimeMillis() / 1000) + "\n" + this.GjZ;
            String z = aa.z(oVar.her());
            byte[] bytes = this.GjZ.getBytes();
            s.e(z, bytes, bytes.length);
            AppMethodBeat.o(125869);
        }
    }

    public static class b {
        public boolean Gka;
        public String Gkb = "";
        public int Gkc = 0;
        public int Gkd = 0;
        public String Gke = "";
        public String Gkf = "";
        public TextView Gkg;
        public View Gkh;
        public int category = 0;
        public String dQx = "";
        public TextView titleTv;
        public TabLayout.f vq;
        public View xYN;

        public final void cA(int i2, String str) {
            AppMethodBeat.i(125870);
            this.Gkd = i2;
            this.Gkf = str;
            if (this.Gkd <= 0) {
                this.Gkg.setText("");
                this.Gkg.setVisibility(4);
                if (this.Gkc > 0) {
                    cB(this.Gkc, this.Gke);
                    AppMethodBeat.o(125870);
                    return;
                }
            } else {
                String sb = new StringBuilder().append(this.Gkd).toString();
                if (this.Gkd > 99) {
                    sb = "99+";
                }
                this.Gkg.setText(sb);
                this.Gkg.setVisibility(0);
                this.Gkh.setVisibility(8);
            }
            AppMethodBeat.o(125870);
        }

        public final void cB(int i2, String str) {
            AppMethodBeat.i(125871);
            this.Gkc = i2;
            this.Gke = str;
            if (i2 <= 0) {
                this.Gkh.setVisibility(8);
            } else if (this.Gkd <= 0) {
                this.Gkg.setVisibility(4);
                this.Gkh.setVisibility(0);
                AppMethodBeat.o(125871);
                return;
            }
            AppMethodBeat.o(125871);
        }
    }

    public static final String abR(int i2) {
        AppMethodBeat.i(125889);
        String string = MMApplicationContext.getContext().getString(R.string.hpv);
        if (MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cb.a.iX(MMApplicationContext.getContext())) >= com.tencent.mm.cb.a.ja(MMApplicationContext.getContext())) {
            AppMethodBeat.o(125889);
        } else {
            if (i2 <= 0 || LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()) != LocaleUtil.CHINA) {
                if (i2 > 99999) {
                    string = string + String.format(" 100%s+", MMApplicationContext.getContext().getString(R.string.hpf));
                } else if (i2 > 999) {
                    string = string + String.format(" %.1f%s", Float.valueOf(((float) i2) / 1000.0f), MMApplicationContext.getContext().getString(R.string.hpf));
                } else if (i2 > 0) {
                    string = string + " " + i2;
                }
            } else if (i2 > 9999) {
                string = string + String.format(" %.1f%s", Float.valueOf(((float) i2) / 10000.0f), MMApplicationContext.getContext().getString(R.string.hpg));
            } else if (i2 > 99999) {
                string = string + String.format(" 10%s+", MMApplicationContext.getContext().getString(R.string.hpg));
            } else {
                string = string + " " + i2;
            }
            AppMethodBeat.o(125889);
        }
        return string;
    }
}
