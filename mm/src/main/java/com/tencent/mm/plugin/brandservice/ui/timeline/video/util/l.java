package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.x;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.e;
import kotlin.g.b.p;
import kotlin.n.n;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0012H\u0007J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0012H\u0007J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0012H\u0007J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0007H\u0007J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0004H\u0007J\u000e\u0010$\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0012J \u0010%\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0007H\u0007J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0004J0\u0010*\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u000200H\u0007J0\u00101\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0012J\u0018\u00107\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoUtil;", "", "()V", "REQUEST_CODE_APP_MSG", "", "REQUEST_SHARE_TO_TIME_LINE", "TAG", "", "bizVideoPlayTime", "maxVideoPlaySaveTime", "addAutoPlayId", "url", "autoPlayId", "clearInvalidLastPlayTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "convertMsgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "intent", "Landroid/content/Intent;", "mpMsgInfo", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "convertOtherMsgInfo", "msg", "getBizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItemFromAppMsg", "getLastPlayTime", "key", "getMPMsgInfo", "getNumStr", "context", "Landroid/content/Context;", "num", "getVideoFullCoverPath", "goToWebViewUI", "isSIMFree", "", "isWifi", "simType", "onVideoMsgClick", "msgId", "", "msgSvrId", "msgIndex", "bundle", "Landroid/os/Bundle;", "setCoverByUrl", "cover", "Landroid/widget/ImageView;", "coverUrl", "width", "height", "setLastPlayTime", "time", "plugin-brandservice_release"})
public final class l {
    private static final String TAG = TAG;
    public static final l pLy = new l();

    static {
        AppMethodBeat.i(7319);
        AppMethodBeat.o(7319);
    }

    private l() {
    }

    public static final void a(Context context, long j2, long j3, int i2, Bundle bundle) {
        String str;
        String str2;
        boolean z;
        String str3;
        String str4;
        v vVar;
        AppMethodBeat.i(175544);
        p.h(context, "context");
        p.h(bundle, "bundle");
        Intent intent = new Intent();
        intent.putExtra("biz_video_msg_id", j2);
        intent.putExtra("biz_video_msg_svr_id", j3);
        intent.putExtra("KPublisherId", "msg_".concat(String.valueOf(j3)));
        intent.putExtra("biz_video_msg_index", i2);
        intent.putExtra("biz_video_session_id", ab.getSessionId());
        intent.putExtras(bundle);
        intent.putExtra("webpageTitle", bundle.getString("webpageTitle"));
        p.h(intent, "intent");
        x xVar = new x();
        xVar.iAh = intent.getStringExtra("KPublisherId");
        xVar.dHp = intent.getStringExtra("sns_local_id");
        xVar.msgId = intent.getLongExtra("biz_video_msg_id", -1);
        if (xVar.msgId > -1) {
            a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service<IMessen…engerStorage::class.java)");
            ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy().Hb(xVar.msgId);
            p.g(Hb, "msgInfo");
            if (Hb.gAt() || Hb.dOQ()) {
                p.h(intent, "intent");
                p.h(xVar, "mpMsgInfo");
                p.h(Hb, "msgInfo");
                xVar.dTS = intent.getLongExtra("biz_video_msg_svr_id", 0);
                xVar.iAf = intent.getIntExtra("biz_video_msg_index", 0);
                xVar.userName = Hb.ajO();
                p.h(Hb, "msgInfo");
                p.h(xVar, "mpMsgInfo");
                if (Hb.gAt() || !Hb.dOQ()) {
                    u a2 = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).a(Hb.ajL(), Hb.getContent());
                    if (a2 == null || Util.isNullOrNil(a2.iAd)) {
                        Log.w(TAG, "getBizReaderItem reader is null");
                        vVar = null;
                    } else {
                        xVar.dHc = a2.eag;
                        xVar.iAg = a2.eah;
                        if (xVar.iAf >= a2.iAd.size()) {
                            vVar = (v) a2.iAd.get(0);
                        } else {
                            vVar = (v) a2.iAd.get(xVar.iAf);
                        }
                    }
                } else {
                    p.h(Hb, "msgInfo");
                    p.h(xVar, "mpMsgInfo");
                    k.b HD = k.b.HD(Hb.getContent());
                    if (HD == null) {
                        Log.w(TAG, "parse content fail");
                        vVar = null;
                    } else {
                        v vVar2 = new v();
                        xVar.dHc = HD.eag;
                        xVar.iAg = HD.eah;
                        vVar2.url = HD.url;
                        vVar2.title = HD.title;
                        vVar2.iAq = HD.description;
                        vVar2.iAo = HD.thumburl;
                        e eVar = (e) HD.as(e.class);
                        if (eVar == null) {
                            Log.w(TAG, "piece content fail");
                            vVar = null;
                        } else {
                            vVar2.vid = eVar.vid;
                            vVar2.time = (long) eVar.iwd;
                            vVar2.type = eVar.iwc;
                            vVar2.iwf = eVar.iwf;
                            vVar2.iAs = eVar.duration;
                            vVar2.videoWidth = eVar.videoWidth;
                            vVar2.videoHeight = eVar.videoHeight;
                            xVar.iwg = eVar.iwg;
                            vVar = vVar2;
                        }
                    }
                }
                xVar.iAi = vVar;
                xVar.type = Hb.getType();
            }
        }
        xVar.t(intent);
        int i3 = bundle.getInt(e.b.OyQ, 10000);
        int i4 = bundle.getInt(e.b.OyR, 10000);
        String string = bundle.getString("biz_video_autoplay_id", "");
        if (Util.isNullOrNil(xVar.iAi.url)) {
            Log.e(TAG, "onVideoMsgClick url is null, %s", Util.getStack());
            AppMethodBeat.o(175544);
            return;
        }
        intent.putExtra("srcUsername", xVar.ajO());
        intent.putExtra("srcDisplayname", xVar.iAg);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (i3 == 90) {
            c cVar = c.pne;
            c.t(4, xVar.ajO(), xVar.iAi.url);
        }
        String d2 = ((b) g.af(b.class)).d(xVar.iAi.url, i3, i4, currentTimeMillis);
        p.g(d2, "redirectUrl");
        p.g(string, "autoPlayId");
        int sessionId = ab.getSessionId();
        if (d2 == null || !n.e(d2, "mp.weixin.qq.com") || (sessionId <= 0 && Util.isNullOrNil(string))) {
            str = d2;
        } else {
            String str5 = "";
            int a3 = n.a((CharSequence) d2, "#", 0, false, 6);
            if (a3 > 0) {
                str2 = d2.substring(0, a3);
                p.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring = d2.substring(a3);
                p.g(substring, "(this as java.lang.String).substring(startIndex)");
                str5 = substring;
            } else {
                str2 = d2;
            }
            if (!n.e(d2, "?")) {
                str2 = str2 + "?";
                z = true;
            } else {
                z = false;
            }
            if (!Util.isNullOrNil(string)) {
                str3 = str2 + "&autoplayid=" + string;
            } else {
                str3 = str2;
            }
            if (z) {
                str4 = n.j(str3, "?&", "?", false);
            } else {
                str4 = str3;
            }
            str = str4 + str5;
        }
        if (!((b) g.af(b.class)).a(context, str, xVar.iAi.type, i3, i4, intent)) {
            intent.putExtra("rawUrl", xVar.iAi.url);
            com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(175544);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        if (r0.equals(com.tencent.mm.sdk.platformtools.LocaleUtil.CHINA) != false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        r0 = r4.getString(com.tencent.mm.R.string.f3m);
        kotlin.g.b.p.g(r0, "context.getString(R.string.mp_100000)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0047, code lost:
        if (r5 < 100000) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
        r0 = com.tenpay.android.wechat.PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT + r0 + '+';
        com.tencent.matrix.trace.core.AppMethodBeat.o(7312);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006a, code lost:
        if (r0.equals(com.tencent.mm.sdk.platformtools.LocaleUtil.TAIWAN) != false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0074, code lost:
        if (r0.equals(com.tencent.mm.sdk.platformtools.LocaleUtil.HONGKONG) != false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
        r0 = (r5 / 10000) + '.' + ((r5 % 10000) / 1000) + r0;
        com.tencent.matrix.trace.core.AppMethodBeat.o(7312);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String T(android.content.Context r4, int r5) {
        /*
        // Method dump skipped, instructions count: 198
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.T(android.content.Context, int):java.lang.String");
    }

    public static final void a(Context context, x xVar, String str) {
        AppMethodBeat.i(7313);
        p.h(context, "context");
        p.h(xVar, "msgInfo");
        p.h(str, "url");
        Intent intent = new Intent();
        intent.putExtra("KPublisherId", xVar.iAh);
        intent.putExtra("pre_username", xVar.ajO());
        intent.putExtra("preUsername", xVar.ajO());
        intent.putExtra("preChatName", xVar.ajO());
        intent.putExtra("rawUrl", str);
        intent.putExtra("geta8key_username", xVar.ajO());
        com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(7313);
    }

    public static final int aiT(String str) {
        AppMethodBeat.i(7314);
        p.h(str, "key");
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("bizVideoPlayTime");
        p.g(mmkv, "mmkv");
        String[] allKeys = mmkv.allKeys();
        if (allKeys != null) {
            for (String str2 : allKeys) {
                p.g(str2, LocaleUtil.ITALIAN);
                if (!n.nm(str2, "PlayTime")) {
                    if (Math.abs(System.currentTimeMillis() - mmkv.decodeLong(str2, 0)) > 7200000) {
                        mmkv.remove(str2);
                        mmkv.remove(str2 + ":PlayTime");
                    }
                }
            }
        }
        if (Math.abs(System.currentTimeMillis() - mmkv.decodeLong(str, 0)) > 7200000) {
            AppMethodBeat.o(7314);
            return 0;
        }
        int decodeInt = mmkv.decodeInt(str + ":PlayTime", 0);
        AppMethodBeat.o(7314);
        return decodeInt;
    }

    public static final void cL(String str, int i2) {
        AppMethodBeat.i(7315);
        p.h(str, "key");
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("bizVideoPlayTime");
        mmkv.encode(str, System.currentTimeMillis());
        mmkv.encode(str + ":PlayTime", i2);
        AppMethodBeat.o(7315);
    }

    public static void a(ImageView imageView, String str, int i2, int i3, x xVar) {
        String str2;
        AppMethodBeat.i(7316);
        p.h(str, "coverUrl");
        p.h(xVar, "msgInfo");
        Log.i(TAG, "setCover coverUrl=%s", str);
        if (Util.isNullOrNil(str) || imageView == null) {
            AppMethodBeat.o(7316);
            return;
        }
        imageView.setContentDescription(imageView.getContext().getString(R.string.az3));
        com.tencent.mm.av.a.a bdb = com.tencent.mm.av.a.a.bdb();
        c.a a2 = new c.a().bdp().dr(i2, i3).a(new com.tencent.mm.pluginsdk.ui.applet.n(4)).a(new com.tencent.mm.pluginsdk.ui.applet.e(4));
        p.h(xVar, "msgInfo");
        if (!Util.isNullOrNil(xVar.iAj)) {
            Object obj = xVar.iAj.get(0);
            p.g(obj, "msgInfo.coverPath[0]");
            str2 = (String) obj;
        } else {
            str2 = "";
        }
        bdb.a(str, imageView, a2.OS(str2).bdv(), null, new m(4, i2, i3, null, null));
        AppMethodBeat.o(7316);
    }

    public static boolean A(boolean z, int i2) {
        AppMethodBeat.i(7318);
        if (z) {
            AppMethodBeat.o(7318);
            return true;
        }
        Log.i(TAG, "simType: %s", Integer.valueOf(i2));
        if (i2 == 1 || i2 == 0) {
            AppMethodBeat.o(7318);
            return true;
        }
        AppMethodBeat.o(7318);
        return false;
    }
}
