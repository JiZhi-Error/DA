package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.protocal.protobuf.ddl;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.u;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J*\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\b\u0010#\u001a\u00020\u0004H\u0002J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0004J\u0006\u0010*\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020\u0004J\u001a\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010&J<\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020!2\"\u00103\u001a\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020&04j\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020&`52\b\u00106\u001a\u0004\u0018\u000107J\u0010\u00108\u001a\u00020\u001b2\b\u00109\u001a\u0004\u0018\u00010:J\u000e\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u0004J\u001e\u0010=\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u000e\u0010\u0019\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006?"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderSdkShareUtil;", "", "()V", "FROM_STR", "", "getFROM_STR", "()Ljava/lang/String;", "REQ_DESC", "getREQ_DESC", "REQ_EXTEND_URL", "getREQ_EXTEND_URL", "REQ_FROM", "getREQ_FROM", "REQ_FROMAPP", "getREQ_FROMAPP", "REQ_PARAMSJSON", "getREQ_PARAMSJSON", "REQ_PATH", "getREQ_PATH", "REQ_URL", "getREQ_URL", "RET_ERRCODE", "getRET_ERRCODE", "RET_ERRMSG", "getRET_ERRMSG", "TAG", "dealShare", "", "businessType", "appid", IssueStorage.COLUMN_EXT_INFO, "fallback", "errcode", "", "errMsg", "genTestConfig", "genTestPostActionSheet", "", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "getShareAppSwitch", "", AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "getTestJson", "getTestJson2", "onClickPostAction", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "context", "Landroid/content/Context;", "actionSheet", "readPostAction", "startId", "actionMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "savePostAction", "actionList", "Lcom/tencent/mm/protocal/protobuf/PostActionSheetList;", "showToast", "wording", "startPostAction", ShareConstants.MEDIA_URI, "plugin-finder_release"})
public final class r {
    public static final String TAG = TAG;
    private static final String UVh = "desc";
    private static final String UVi = UVi;
    private static final String vWf = vWf;
    private static final String vWg = vWg;
    private static final String vWh = vWh;
    private static final String vWi = vWi;
    private static final String vWj = vWj;
    private static final String vWk = vWk;
    private static final String vWl = vWl;
    private static final String vWm = "channels";
    public static final r vWn = new r();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<ddk, Boolean> {
        public static final c vWr = new c();

        static {
            AppMethodBeat.i(253480);
            AppMethodBeat.o(253480);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(ddk ddk) {
            boolean z;
            AppMethodBeat.i(253479);
            r rVar = r.vWn;
            String str = ddk.MIA;
            if (str == null) {
                str = "";
            }
            if (!r.awj(str)) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(253479);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(253491);
        AppMethodBeat.o(253491);
    }

    private r() {
    }

    public static String dCc() {
        return vWh;
    }

    public static String dCd() {
        return vWi;
    }

    public static String dCe() {
        return vWj;
    }

    public static String dCf() {
        return vWk;
    }

    public static String dCg() {
        return vWl;
    }

    public static String hVu() {
        return UVh;
    }

    public static String hVv() {
        return UVi;
    }

    public static String dCh() {
        return vWm;
    }

    public static String dCi() {
        AppMethodBeat.i(253482);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(vWh, "content://media/external/video/media/3426");
        jSONObject.put(vWi, "https://1500000419.vod2.myqcloud.com/6c9781f6vodcq1500000419/fcc5b21b5285890810062810511/NZQdSMAkg1AA.mp4");
        jSONObject.put(vWj, 2);
        jSONObject.put(vWk, "{\"file_id\":\"5285890810062810511\",\"media_source\":2,\"media_type\":\"video\",\"act_style\":11010,\"service_type\":2,\"media_scene\":1,\"service\":\"build\"}");
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "extInfo.toString()");
        AppMethodBeat.o(253482);
        return jSONObject2;
    }

    public static String dCj() {
        AppMethodBeat.i(253483);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(vWh, "content://media/external/video/media/3426");
        jSONObject.put(vWi, "");
        jSONObject.put(vWj, 1);
        jSONObject.put(vWk, "");
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "extInfo.toString()");
        AppMethodBeat.o(253483);
        return jSONObject2;
    }

    public static void showToast(String str) {
        AppMethodBeat.i(253484);
        p.h(str, "wording");
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
            com.tencent.mm.ac.d.h(new d(str));
        }
        AppMethodBeat.o(253484);
    }

    public static void e(int i2, String str, String str2, String str3) {
        AppMethodBeat.i(253485);
        p.h(str, "errMsg");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(vWf, i2);
        jSONObject.put(vWg, str);
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "retJson.toString()");
        showToast(jSONObject2);
        if (str2 == null) {
            str2 = "";
        }
        String jSONObject3 = jSONObject.toString();
        if (str3 == null) {
            str3 = "";
        }
        n.d(str2, jSONObject3, str3, -1, "");
        AppMethodBeat.o(253485);
    }

    public static boolean awj(String str) {
        JSONObject optJSONObject;
        int optInt;
        AppMethodBeat.i(253486);
        p.h(str, AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        try {
            String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_jump_app_switch, "{\"com.tencent.phoenix\":{\"minApi\":26}}");
            if (!Util.isNullOrNil(a2) && a2 != null && (optJSONObject = new JSONObject(a2).optJSONObject(str)) != null && (optInt = optJSONObject.optInt("minApi", 0)) > 0 && Build.VERSION.SDK_INT < optInt) {
                AppMethodBeat.o(253486);
                return false;
            }
        } catch (Throwable th) {
            Log.printErrStackTrace("FinderConfig", th, "SHARE_SDK_SWITCH", new Object[0]);
        }
        AppMethodBeat.o(253486);
        return true;
    }

    public static void a(ddl ddl) {
        AppMethodBeat.i(253487);
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
            if (ddl == null) {
                ddl = new ddl();
            }
            LinkedList<ddk> linkedList = ddl.MIC;
            ArrayList arrayList = new ArrayList();
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dsG().value().intValue() == 1) {
                ddk ddk = new ddk();
                ddk.title = "用秒剪制作视频（仅测试）";
                ddk.icon = "";
                ddk.desc = "";
                ddk.type = 1;
                ddk.value = "wxa5e0de08d96cc09d";
                ddk.MIy = "miaojian://createvideo?scene=channels&page=1&from=channels";
                ddk.MIz = "https://miaojian.weixin.qq.com/download/apps/?channel=debug";
                ddk.MIA = "com.tencent.phoenix";
                ddk.MIB = "A24DC0755072F64C480DC06DCD3412BF";
                arrayList.add(ddk);
            }
            linkedList.addAll(arrayList);
        }
        if (ddl != null) {
            LinkedList<ddk> linkedList2 = ddl.MIC;
            p.g(linkedList2, "actionSheetList.sheets");
            com.tencent.mm.ac.d.a((LinkedList) linkedList2, (kotlin.g.a.b) c.vWr);
            LinkedList<ddk> linkedList3 = ddl.MIC;
            p.g(linkedList3, "actionSheetList.sheets");
            for (T t : linkedList3) {
                h.a(t.value, t.MIA, (h.a) null);
            }
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_MY_FINDER_POST_ACTION_SHEET_LIST_STRING_SYNC, Util.encodeHexString(ddl.toByteArray()));
            AppMethodBeat.o(253487);
            return;
        }
        e aAh2 = g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_MY_FINDER_POST_ACTION_SHEET_LIST_STRING_SYNC, "");
        AppMethodBeat.o(253487);
    }

    public static void a(HashMap<Integer, ddk> hashMap, m mVar) {
        LinkedList<ddk> linkedList;
        int i2 = 0;
        AppMethodBeat.i(253488);
        p.h(hashMap, "actionMap");
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_MY_FINDER_POST_ACTION_SHEET_LIST_STRING_SYNC, "");
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(253488);
            throw tVar;
        }
        String str = (String) obj;
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(253488);
            return;
        }
        byte[] decodeHexString = Util.decodeHexString(str);
        if (Util.isNullOrNil(decodeHexString)) {
            AppMethodBeat.o(253488);
            return;
        }
        ddl ddl = new ddl();
        try {
            ddl.parseFrom(decodeHexString);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            ddl = null;
        }
        ddl ddl2 = ddl;
        if (ddl2 == null || (linkedList = ddl2.MIC) == null) {
            AppMethodBeat.o(253488);
            return;
        }
        for (T t : linkedList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t2 = t;
            hashMap.put(Integer.valueOf(i2 + 1010), t2);
            if (mVar != null) {
                mVar.d(i2 + 1010, t2.title);
                i2 = i3;
            } else {
                i2 = i3;
            }
        }
        AppMethodBeat.o(253488);
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, ddk ddk) {
        boolean G;
        String string;
        AppMethodBeat.i(253489);
        p.h(context, "context");
        if (ddk == null || Util.isNullOrNil(ddk.MIA)) {
            AppMethodBeat.o(253489);
            return null;
        }
        if (Util.isNullOrNil(ddk.MIA)) {
            G = false;
        } else {
            com.tencent.mm.plugin.recordvideo.e.a aVar = com.tencent.mm.plugin.recordvideo.e.a.ChV;
            String str = ddk.MIA;
            if (str == null) {
                str = "";
            }
            String str2 = ddk.MIB;
            if (str2 == null) {
                str2 = "";
            }
            G = com.tencent.mm.plugin.recordvideo.e.a.G(context, str, str2);
        }
        String r = h.r(context, ddk.value);
        if (r == null) {
            r = "";
        }
        if (G) {
            string = context.getString(R.string.d8h, r);
        } else {
            string = context.getString(R.string.d8g, r);
        }
        com.tencent.mm.ui.widget.a.d c2 = com.tencent.mm.ui.base.h.c(context, string, "", context.getString(R.string.x_), context.getString(R.string.sz), new a(G, context, ddk), b.vWq);
        AppMethodBeat.o(253489);
        return c2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
    static final class a implements DialogInterface.OnClickListener {
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean vWo;
        final /* synthetic */ ddk vWp;

        a(boolean z, Context context, ddk ddk) {
            this.vWo = z;
            this.$context = context;
            this.vWp = ddk;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(253476);
            dialogInterface.dismiss();
            r rVar = r.vWn;
            Log.i(r.TAG, "dialog ok isInstall:" + this.vWo);
            if (this.vWo) {
                r rVar2 = r.vWn;
                Context context = this.$context;
                String str = this.vWp.MIy;
                if (str == null) {
                    str = "";
                }
                String str2 = this.vWp.MIA;
                if (str2 == null) {
                    str2 = "";
                }
                r.A(context, str, str2);
                AppMethodBeat.o(253476);
                return;
            }
            com.tencent.mm.plugin.recordvideo.e.a aVar = com.tencent.mm.plugin.recordvideo.e.a.ChV;
            Context context2 = this.$context;
            String str3 = this.vWp.MIz;
            if (str3 == null) {
                str3 = "";
            }
            com.tencent.mm.plugin.recordvideo.e.a.bt(context2, str3);
            AppMethodBeat.o(253476);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
    static final class b implements DialogInterface.OnClickListener {
        public static final b vWq = new b();

        static {
            AppMethodBeat.i(253478);
            AppMethodBeat.o(253478);
        }

        b() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(253477);
            r rVar = r.vWn;
            Log.i(r.TAG, "dialog cancel");
            dialogInterface.dismiss();
            AppMethodBeat.o(253477);
        }
    }

    public static void A(Context context, String str, String str2) {
        AppMethodBeat.i(253490);
        p.h(context, "context");
        p.h(str, ShareConstants.MEDIA_URI);
        p.h(str2, AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        Log.i(TAG, "startPostAction " + str2 + ", " + str);
        Intent intent = new Intent();
        intent.setData(Uri.parse(str));
        intent.setPackage(str2);
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(268435456);
        try {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/utils/FinderSdkShareUtil", "startPostAction", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/utils/FinderSdkShareUtil", "startPostAction", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(253490);
        } catch (Exception e2) {
            Log.e(TAG, "startPostAction: error " + e2.getMessage());
            AppMethodBeat.o(253490);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String vWs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str) {
            super(0);
            this.vWs = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(253481);
            u.makeText(MMApplicationContext.getContext(), this.vWs, 0).show();
            x xVar = x.SXb;
            AppMethodBeat.o(253481);
            return xVar;
        }
    }
}
