package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.appbrand.launching.b.a.a;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class g {
    public static final String JSL = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/deeplink/noaccess#wechat_redirect");
    private static boolean JSM = false;
    public static final String JSN = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/security");
    public static final String JSO = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2e) + "/security");
    public static String JSP = "";
    private static final Map<String, Long> JSQ;

    public interface a {
        void a(int i2, int i3, String str, q qVar, boolean z);
    }

    static /* synthetic */ void d(i iVar) {
        AppMethodBeat.i(212220);
        c(iVar);
        AppMethodBeat.o(212220);
    }

    static {
        AppMethodBeat.i(124372);
        HashMap hashMap = new HashMap();
        JSQ = hashMap;
        hashMap.put("weixin://", 0L);
        JSQ.put("weixin://dl/stickers", 1L);
        JSQ.put("weixin://dl/games", 2L);
        JSQ.put("weixin://dl/moments", 4L);
        JSQ.put("weixin://dl/add", 8L);
        JSQ.put("weixin://dl/shopping", 16L);
        JSQ.put("weixin://dl/groupchat", 32L);
        JSQ.put("weixin://dl/scan", 64L);
        JSQ.put("weixin://dl/profile", 128L);
        JSQ.put("weixin://dl/settings", 256L);
        JSQ.put("weixin://dl/general", 512L);
        JSQ.put("weixin://dl/help", 1024L);
        JSQ.put("weixin://dl/notifications", 2048L);
        JSQ.put("weixin://dl/terms", 4096L);
        JSQ.put("weixin://dl/chat", 8192L);
        JSQ.put("weixin://dl/features", 16384L);
        JSQ.put("weixin://dl/clear", 32768L);
        JSQ.put("weixin://dl/feedback", 65536L);
        JSQ.put("weixin://dl/faq", 131072L);
        JSQ.put("weixin://dl/recommendation", 262144L);
        JSQ.put("weixin://dl/groups", Long.valueOf((long) com.tencent.mm.hardcoder.g.ACTION_MINI_PROGRAM_LAUNCH));
        JSQ.put("weixin://dl/tags", 1048576L);
        JSQ.put("weixin://dl/officialaccounts", 2097152L);
        JSQ.put("weixin://dl/posts", 4194304L);
        JSQ.put("weixin://dl/favorites", 8388608L);
        JSQ.put("weixin://dl/privacy", 16777216L);
        JSQ.put("weixin://dl/security", 33554432L);
        JSQ.put("weixin://dl/wallet", 67108864L);
        JSQ.put("weixin://dl/businessPay", 134217728L);
        JSQ.put("weixin://dl/businessPay/", 134217728L);
        JSQ.put("weixin://dl/wechatout", 268435456L);
        JSQ.put("weixin://dl/protection", Long.valueOf((long) TPAudioFrame.TP_CH_STEREO_RIGHT));
        JSQ.put("weixin://dl/card", 2147483648L);
        JSQ.put("weixin://dl/about", 1125899906842624L);
        JSQ.put("weixin://dl/blacklist", 4294967296L);
        JSQ.put("weixin://dl/textsize", 8589934592L);
        JSQ.put("weixin://dl/sight", 17179869184L);
        JSQ.put("weixin://dl/languages", 34359738368L);
        JSQ.put("weixin://dl/chathistory", 68719476736L);
        JSQ.put("weixin://dl/bindqq", 137438953472L);
        JSQ.put("weixin://dl/bindmobile", 274877906944L);
        JSQ.put("weixin://dl/bindemail", 549755813888L);
        JSQ.put("weixin://dl/securityassistant", 1099511627776L);
        JSQ.put("weixin://dl/broadcastmessage", 2199023255552L);
        JSQ.put("weixin://dl/setname", 4398046511104L);
        JSQ.put("weixin://dl/myQRcode", 8796093022208L);
        JSQ.put("weixin://dl/myaddress", 17592186044416L);
        JSQ.put("weixin://dl/hidemoments", 35184372088832L);
        JSQ.put("weixin://dl/blockmoments", 70368744177664L);
        JSQ.put("weixin://dl/stickersetting", 140737488355328L);
        JSQ.put("weixin://dl/log", 281474976710656L);
        JSQ.put("weixin://dl/wechatoutcoupon", 562949953421312L);
        JSQ.put("weixin://dl/wechatoutshare", 18014398509481984L);
        JSQ.put("weixin://dl/personalemoticon", 4503599627370496L);
        JSQ.put("weixin://dl/designeremoji", 9007199254740992L);
        JSQ.put("weixin://dl/sightdraft", 576460752303423488L);
        JSQ.put("weixin://dl/jumpWxa/", 576460752303423489L);
        JSQ.put("weixin://dl/offlinepay/", 576460752303423490L);
        JSQ.put("weixin://dl/channels/shareVideo/", 576460752303423492L);
        JSQ.put("weixin://dl/channels/profile/", 576460752303423496L);
        JSQ.put("weixin://dl/channels/live/", 576460752303423504L);
        JSQ.put("weixin://dl/channels/feed/", 576460752303423520L);
        AppMethodBeat.o(124372);
    }

    public static boolean bM(String str, long j2) {
        boolean z;
        long j3;
        AppMethodBeat.i(124347);
        if (!Util.isNullOrNil(str)) {
            String bdf = bdf(str);
            if (JSQ.containsKey(bdf)) {
                j3 = JSQ.get(bdf).longValue();
            } else {
                j3 = -1;
            }
            if (j3 != -1 && (j3 == 0 || (j3 & j2) == j3)) {
                z = true;
                AppMethodBeat.o(124347);
                return z;
            }
        }
        z = false;
        AppMethodBeat.o(124347);
        return z;
    }

    public static String bcY(String str) {
        AppMethodBeat.i(212216);
        if (WeChatBrands.AppInfo.current().isMainland()) {
            AppMethodBeat.o(212216);
        } else {
            if (str.startsWith("wechat://")) {
                str.replace("wechat://", "weixin://");
            }
            AppMethodBeat.o(212216);
        }
        return str;
    }

    public static boolean bcZ(String str) {
        boolean z;
        AppMethodBeat.i(124348);
        String bdf = bdf(bcY(str));
        if (!JSQ.containsKey(bdf) && !bdb(bdf) && !bdd(bdf)) {
            if (Util.isNullOrNil(bdf) || (!bdf.startsWith("weixin://dl/jumpFakeWxa/") && !bdf.startsWith("weixin://dl/openNativeView/"))) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                AppMethodBeat.o(124348);
                return false;
            }
        }
        AppMethodBeat.o(124348);
        return true;
    }

    public static boolean bda(String str) {
        AppMethodBeat.i(124349);
        boolean bdb = bdb(bcY(str));
        AppMethodBeat.o(124349);
        return bdb;
    }

    private static boolean bdb(String str) {
        AppMethodBeat.i(212217);
        if (Util.isNullOrNil(str) || !str.startsWith("weixin://dl/business")) {
            AppMethodBeat.o(212217);
            return false;
        }
        AppMethodBeat.o(212217);
        return true;
    }

    public static boolean bdc(String str) {
        AppMethodBeat.i(124350);
        boolean bdd = bdd(bcY(str));
        AppMethodBeat.o(124350);
        return bdd;
    }

    private static boolean bdd(String str) {
        AppMethodBeat.i(212218);
        if (Util.isNullOrNil(str) || !str.startsWith("weixin://dl/openbusinesswebview")) {
            AppMethodBeat.o(212218);
            return false;
        }
        AppMethodBeat.o(212218);
        return true;
    }

    public static boolean w(Uri uri) {
        AppMethodBeat.i(124351);
        if (uri == null) {
            AppMethodBeat.o(124351);
            return false;
        } else if (!Util.isNullOrNil(uri.getQueryParameter("ticket"))) {
            AppMethodBeat.o(124351);
            return true;
        } else {
            boolean x = x(uri);
            AppMethodBeat.o(124351);
            return x;
        }
    }

    public static boolean x(Uri uri) {
        AppMethodBeat.i(124352);
        if (uri == null) {
            AppMethodBeat.o(124352);
            return false;
        } else if (uri.toString().startsWith("weixin://dl/business/tempsession/") || uri.toString().startsWith("weixin://dl/businessTempSession/")) {
            AppMethodBeat.o(124352);
            return true;
        } else {
            AppMethodBeat.o(124352);
            return false;
        }
    }

    private static boolean glV() {
        AppMethodBeat.i(124353);
        if (!com.tencent.mm.kernel.g.aAc()) {
            AppMethodBeat.o(124353);
            return false;
        } else if (h.aqJ().getInt("WCOEntranceSwitch", 0) > 0) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.TRUE);
            AppMethodBeat.o(124353);
            return true;
        } else {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE);
            AppMethodBeat.o(124353);
            return false;
        }
    }

    private static boolean bde(String str) {
        AppMethodBeat.i(124354);
        if ((str.equals("weixin://dl/wechatout") || str.equals("weixin://dl/wechatoutcoupon") || str.equals("weixin://dl/wechatoutshare")) && !glV()) {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
            intent.putExtra("rawUrl", JSL);
            c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(124354);
            return true;
        }
        AppMethodBeat.o(124354);
        return false;
    }

    public static void a(final Context context, String str, final String str2, final int i2, String str3, final a aVar) {
        AppMethodBeat.i(124355);
        final String str4 = Util.isNullOrNil(str) ? str3 : str;
        if (bde(str4)) {
            AppMethodBeat.o(124355);
            return;
        }
        l lVar = new l(str4, str2, i2, 0, (int) System.currentTimeMillis(), new byte[0]);
        com.tencent.mm.kernel.g.azz().a(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, new com.tencent.mm.ak.i() {
            /* class com.tencent.mm.pluginsdk.g.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(124343);
                com.tencent.mm.kernel.g.azz().b(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, this);
                Log.i("MicroMsg.DeepLinkHelper", "[oneliang][doDeepLink][onSceneEnd]:errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                boolean z = false;
                if (qVar != null && (qVar instanceof l)) {
                    l lVar = (l) qVar;
                    Log.d("MicroMsg.DeepLinkHelper", "bitset:" + lVar.beW());
                    long beW = lVar.beW();
                    String bcY = g.bcY(lVar.beQ());
                    if (g.bM(bcY, beW)) {
                        try {
                            Log.i("MicroMsg.DeepLinkHelper", "[oneliang] uri: %s", bcY);
                            z = g.a(context, lVar.beY(), lVar.bfa(), bcY);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11405, bcY, 1, Integer.valueOf(i2), str2, Util.nullAsNil(str4));
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.DeepLinkHelper", e2, "", "");
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11405, bcY, 0, Integer.valueOf(i2), str2, Util.nullAsNil(str4));
                        }
                    } else {
                        Log.i("MicroMsg.DeepLinkHelper", "[oneliang] no permission");
                        Intent intent = new Intent();
                        intent.setFlags(268435456);
                        intent.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                        intent.putExtra("rawUrl", g.JSL);
                        intent.putExtra("geta8key_session_id", lVar.beY());
                        intent.putExtra("geta8key_cookie", lVar.bfa());
                        Context context = MMApplicationContext.getContext();
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/DeepLinkHelper$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/DeepLinkHelper$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11405, bcY, 0, Integer.valueOf(i2), str2, Util.nullAsNil(str4));
                        z = true;
                    }
                }
                if (aVar != null) {
                    aVar.a(i2, i3, str, qVar, z);
                }
                AppMethodBeat.o(124343);
            }
        });
        com.tencent.mm.kernel.g.azz().a(lVar, 0);
        AppMethodBeat.o(124355);
    }

    public static void a(Context context, String str, int i2, a aVar, String str2, String str3) {
        AppMethodBeat.i(124356);
        a(context, str, i2, null, aVar, str2, str3);
        AppMethodBeat.o(124356);
    }

    public static void a(final Context context, final String str, final int i2, final Bundle bundle, final a aVar, String str2, String str3) {
        AppMethodBeat.i(124357);
        LinkedList linkedList = new LinkedList();
        eg egVar = new eg();
        if (!Util.isNullOrNil(str2) && !Util.isNullOrNil(str3)) {
            Log.i("MicroMsg.DeepLinkHelper", "package name = %s, package signature = %s", str2, str3);
            egVar.qGp = str2;
            egVar.signature = str3;
            linkedList.add(egVar);
        }
        if (bde(str)) {
            AppMethodBeat.o(124357);
            return;
        }
        ac acVar = new ac(str, i2, linkedList);
        com.tencent.mm.kernel.g.azz().a(1200, new com.tencent.mm.ak.i() {
            /* class com.tencent.mm.pluginsdk.g.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:16:0x00b7  */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x0195  */
            @Override // com.tencent.mm.ak.i
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onSceneEnd(int r12, int r13, java.lang.String r14, com.tencent.mm.ak.q r15) {
                /*
                // Method dump skipped, instructions count: 645
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.g.AnonymousClass2.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
            }
        });
        com.tencent.mm.kernel.g.azz().a(acVar, 0);
        AppMethodBeat.o(124357);
    }

    public static void a(Context context, String str, int i2, a aVar) {
        AppMethodBeat.i(124358);
        a(context, str, i2, null, aVar, null, null);
        AppMethodBeat.o(124358);
    }

    public static void a(Context context, String str, int i2, Bundle bundle, a aVar) {
        AppMethodBeat.i(124359);
        a(context, str, i2, bundle, aVar, null, null);
        AppMethodBeat.o(124359);
    }

    public static boolean a(Context context, int i2, byte[] bArr, String str) {
        AppMethodBeat.i(124361);
        boolean a2 = a(context, str, 0, i2, bArr, (String) null);
        AppMethodBeat.o(124361);
        return a2;
    }

    public static boolean O(Context context, String str, String str2) {
        AppMethodBeat.i(124362);
        boolean a2 = a(context, str, 1, (int) System.currentTimeMillis(), new byte[0], str2);
        AppMethodBeat.o(124362);
        return a2;
    }

    private static boolean a(Context context, String str, int i2, int i3, byte[] bArr, String str2) {
        AppMethodBeat.i(124364);
        boolean a2 = a(context, str, i2, null, i3, bArr, str2, null);
        AppMethodBeat.o(124364);
        return a2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0c9b  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0ca7  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:456:0x1595  */
    /* JADX WARNING: Removed duplicated region for block: B:472:0x161c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(final android.content.Context r18, java.lang.String r19, int r20, android.os.Bundle r21, int r22, byte[] r23, java.lang.String r24, com.tencent.mm.pluginsdk.g.a r25) {
        /*
        // Method dump skipped, instructions count: 5716
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.g.a(android.content.Context, java.lang.String, int, android.os.Bundle, int, byte[], java.lang.String, com.tencent.mm.pluginsdk.g$a):boolean");
    }

    private static void ax(Context context, int i2) {
        String string;
        AppMethodBeat.i(124367);
        if (!ChannelUtil.isNokiaAol && LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA)) {
            string = context.getString(R.string.j1o);
        } else if (LocaleUtil.getApplicationLanguage().equals(LocaleUtil.HONGKONG)) {
            string = context.getString(R.string.j1p);
        } else if (LocaleUtil.getApplicationLanguage().equals(LocaleUtil.TAIWAN)) {
            string = context.getString(R.string.j1q);
        } else {
            string = context.getString(R.string.j1r);
        }
        Log.d("MicroMsg.DeepLinkHelper", "using faq webpage");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("show_feedback", false);
        intent.putExtra("KShowFixToolsBtn", true);
        intent.putExtra("geta8key_session_id", i2);
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(124367);
    }

    private static String bdf(String str) {
        AppMethodBeat.i(124368);
        String str2 = null;
        if (!Util.isNullOrNil(str)) {
            Uri parse = Uri.parse(str);
            str2 = parse.getScheme() + "://" + parse.getHost() + parse.getPath();
        }
        AppMethodBeat.o(124368);
        return str2;
    }

    public static void P(final Context context, String str, String str2) {
        AppMethodBeat.i(124369);
        if (bde(str2)) {
            AppMethodBeat.o(124369);
            return;
        }
        final com.tencent.mm.ui.base.q a2 = com.tencent.mm.ui.base.h.a(context, "", true, (DialogInterface.OnCancelListener) null);
        int i2 = 6;
        if (!Util.isNullOrNil(str)) {
            if (ab.Eq(str)) {
                i2 = 7;
            } else if (ab.IT(str)) {
                i2 = 9;
            }
        }
        a(context, str2, i2, new a() {
            /* class com.tencent.mm.pluginsdk.g.AnonymousClass5 */

            @Override // com.tencent.mm.pluginsdk.g.a
            public final void a(int i2, int i3, String str, q qVar, boolean z) {
                ekq bfD;
                AppMethodBeat.i(212215);
                Log.i("MicroMsg.DeepLinkHelper", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(z));
                if (a2 != null && a2.isShowing()) {
                    a2.dismiss();
                }
                if (!(qVar == null || i2 == 0 || i3 == 0 || !(qVar instanceof ac) || (bfD = ((ac) qVar).bfD()) == null || context == null || Util.isNullOrNil(bfD.NjR))) {
                    u.makeText(context, context.getString(R.string.zb) + " : " + Util.nullAsNil(bfD.NjR), 0).show();
                }
                AppMethodBeat.o(212215);
            }
        });
        AppMethodBeat.o(124369);
    }

    private static void c(i iVar) {
        AppMethodBeat.i(124370);
        if (iVar == null) {
            AppMethodBeat.o(124370);
            return;
        }
        String optString = iVar.optString("package_info");
        if (Util.isNullOrNil(optString)) {
            Log.i("MicroMsg.DeepLinkHelper", "package_info is null in invokeData");
            AppMethodBeat.o(124370);
            return;
        }
        try {
            f fVar = new f(optString);
            if (fVar.length() <= 0) {
                AppMethodBeat.o(124370);
                return;
            }
            String str = com.tencent.mm.kernel.g.aAh().cachePath + "TempMiniProgram/";
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < fVar.length(); i2++) {
                i iVar2 = new i(fVar.getString(i2));
                String optString2 = iVar2.optString("downloadUrl");
                long optLong = iVar2.optLong("expireTime");
                String optString3 = iVar2.optString("extraBytes");
                String optString4 = iVar2.optString("filePath");
                String optString5 = iVar2.optString("fileMd5");
                if (!Util.isNullOrNil(optString5) && !Util.isNullOrNil(optString2) && !Util.isNullOrNil(optString4) && !Util.isNullOrNil(optString3) && optLong > 0) {
                    if (!optString4.startsWith("content") || !s.YS(optString4)) {
                        Log.i("MicroMsg.DeepLinkHelper", "file not Exists, path = %s", optString4);
                    } else {
                        if (!s.YS(str)) {
                            s.boN(str);
                        }
                        String str2 = str + Util.safeFormatString("%s.%s", optString5, s.akC(optString4));
                        if (s.nw(optString4, str2) <= 0) {
                            Log.e("MicroMsg.DeepLinkHelper", "file copy failed");
                        } else {
                            byte[] decodeHexString = Util.decodeHexString(optString3);
                            a.C0735a aVar = new a.C0735a();
                            aVar.aO(decodeHexString);
                            Log.i("MicroMsg.DeepLinkHelper", aVar.toString());
                            aVar.mYe = optLong;
                            aVar.mYc = optString5;
                            aVar.mYd = optString2;
                            arrayList.add(new Pair(aVar, str2));
                        }
                    }
                }
            }
            ((com.tencent.mm.plugin.appbrand.launching.b.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.launching.b.a.a.class)).bO(arrayList);
            AppMethodBeat.o(124370);
        } catch (Exception e2) {
            Log.e("MicroMsg.DeepLinkHelper", e2.getMessage());
            AppMethodBeat.o(124370);
        }
    }

    public static void cf(Context context, String str) {
        AppMethodBeat.i(124371);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url is null. finish");
            AppMethodBeat.o(124371);
        } else if (str.startsWith("weixin://dl/login/phone_view")) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("cc");
            String queryParameter2 = parse.getQueryParameter("num");
            Log.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI cc:%s num:%s", queryParameter, queryParameter2);
            Intent intent = new Intent();
            intent.putExtra("couttry_code", queryParameter);
            intent.putExtra("input_mobile_number", queryParameter2);
            intent.putExtra("from_deep_link", true);
            intent.putExtra("mobile_input_purpose", 1);
            intent.addFlags(268435456);
            c.b(context, "account", ".ui.MobileInputUI", intent);
            AppMethodBeat.o(124371);
        } else if (str.startsWith("weixin://dl/login/common_view")) {
            String queryParameter3 = Uri.parse(str).getQueryParameter(ch.COL_USERNAME);
            Log.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI  username:%s", queryParameter3);
            Intent intent2 = new Intent();
            intent2.putExtra("login_username", queryParameter3);
            intent2.putExtra("from_deep_link", true);
            intent2.addFlags(268435456);
            c.b(context, "account", ".ui.LoginUI", intent2);
            AppMethodBeat.o(124371);
        } else {
            Log.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url not Correct:%s", str);
            AppMethodBeat.o(124371);
        }
    }

    public static boolean ce(Context context, String str) {
        AppMethodBeat.i(212219);
        boolean a2 = a(context, str, 0, (int) System.currentTimeMillis(), new byte[0], (String) null);
        AppMethodBeat.o(212219);
        return a2;
    }

    public static boolean a(Context context, String str, int i2, Bundle bundle, String str2, a aVar) {
        AppMethodBeat.i(124363);
        boolean a2 = a(context, str, i2, bundle, (int) System.currentTimeMillis(), new byte[0], str2, aVar);
        AppMethodBeat.o(124363);
        return a2;
    }

    public static void il(Context context) {
        AppMethodBeat.i(124366);
        ax(context, (int) System.currentTimeMillis());
        AppMethodBeat.o(124366);
    }
}
