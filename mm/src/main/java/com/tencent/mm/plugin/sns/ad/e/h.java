package com.tencent.mm.plugin.sns.ad.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class h {
    public static boolean a(ADXml aDXml, ADInfo aDInfo) {
        return (aDXml == null || aDXml.adFinderInfo == null || aDInfo == null || aDInfo.adActionType != 9) ? false : true;
    }

    public static boolean a(Context context, ADXml aDXml, ADInfo aDInfo, long j2, int i2) {
        AppMethodBeat.i(259424);
        try {
            if (a(aDXml, aDInfo)) {
                boolean a2 = a(context, aDInfo.uxInfo, aDXml.adFinderInfo.finderUsername, aDXml.adFinderInfo.objectNonceId, aDXml.adFinderInfo.DrX, j2, i2);
                AppMethodBeat.o(259424);
                return a2;
            }
        } catch (Throwable th) {
            Log.e("FinderAdJumpHelper", "checkJumpFinderFeedsDetailUI exp=" + th.toString());
        }
        AppMethodBeat.o(259424);
        return false;
    }

    private static boolean a(Context context, String str, String str2, String str3, String str4, long j2, int i2) {
        AppMethodBeat.i(259425);
        try {
            String aB = aB(str, r.Jb(j2), i2);
            Intent intent = new Intent();
            intent.putExtra("report_scene", 3);
            intent.putExtra("from_user", str2);
            intent.putExtra("feed_encrypted_object_id", str4);
            intent.putExtra("feed_object_nonceId", str3);
            intent.putExtra("key_from_user_name", str2);
            intent.putExtra("tab_type", 5);
            intent.putExtra("key_detail_comment_scene", 42);
            intent.putExtra("is_from_ad", true);
            intent.putExtra("key_extra_info", aB);
            intent.putExtra("key_comment_scene", 37);
            ((aj) g.ah(aj.class)).fillContextIdToIntent(4, 4, 42, intent);
            ((aj) g.ah(aj.class)).enterFinderShareFeedUI(context, intent);
            Log.i("FinderAdJumpHelper", "doJumpFinderFeedsDetailUI, adInfoExtra=" + aB + ", objectNonceId=" + str3 + ", finderUsername=" + str2 + ", exportId=" + str4);
            AppMethodBeat.o(259425);
            return true;
        } catch (Throwable th) {
            Log.e("FinderAdJumpHelper", "doJumpFinderFeedsDetailUI exp=" + th.toString());
            AppMethodBeat.o(259425);
            return false;
        }
    }

    public static boolean b(Context context, ADXml aDXml, ADInfo aDInfo, long j2, int i2) {
        AppMethodBeat.i(259426);
        try {
            if (a(aDXml, aDInfo)) {
                ADXml.a aVar = aDXml.adFinderInfo;
                boolean a2 = a(context, aVar.finderUsername, aDInfo.uxInfo, r.Jb(j2), i2);
                AppMethodBeat.o(259426);
                return a2;
            }
        } catch (Throwable th) {
            Log.e("FinderAdJumpHelper", "checkJumpFinderProfileUI exp=" + th.toString());
        }
        AppMethodBeat.o(259426);
        return false;
    }

    public static boolean a(Context context, String str, String str2, String str3, int i2) {
        AppMethodBeat.i(259427);
        try {
            String aB = aB(str2, str3, i2);
            Log.i("FinderAdJumpHelper", "doJumpToFinderProfileUI, finderUsername=" + str + ", adInfoExtra=" + aB + ", scene=" + i2);
            Intent intent = new Intent();
            intent.putExtra("key_from_profile_share_scene", 3);
            intent.putExtra("key_enter_profile_type", 1);
            intent.putExtra("finder_username", str);
            intent.putExtra("key_comment_scene", 37);
            intent.putExtra("is_from_ad", true);
            intent.putExtra("key_extra_info", aB);
            ((aj) g.ah(aj.class)).fillContextIdToIntent(4, 4, 32, intent);
            ((aj) g.ah(aj.class)).enterFinderProfileUI(context, intent);
            AppMethodBeat.o(259427);
            return true;
        } catch (Throwable th) {
            Log.e("FinderAdJumpHelper", "doJumpToFinderProfileUI exp=" + th.toString());
            AppMethodBeat.o(259427);
            return false;
        }
    }

    public static boolean a(Context context, SnsInfo snsInfo, int i2) {
        boolean z;
        AppMethodBeat.i(201932);
        if (!(context == null || snsInfo == null)) {
            try {
                if (snsInfo.getAdInfo(i2) != null) {
                    ADXml adXml = snsInfo.getAdXml();
                    if (adXml == null || adXml.headClickType != 4 || adXml.adHeadFinderProfile == null) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        boolean a2 = a(context, snsInfo.getAdXml().adHeadFinderProfile.finderUsername, snsInfo.getAdInfo(i2).uxInfo, r.Jb(snsInfo.field_snsId), 0);
                        AppMethodBeat.o(201932);
                        return a2;
                    }
                }
            } catch (Throwable th) {
                Log.e("FinderAdJumpHelper", "jumpToFinderProfileUI exp=" + th.toString());
                AppMethodBeat.o(201932);
                return false;
            }
        }
        AppMethodBeat.o(201932);
        return false;
    }

    public static String aB(String str, String str2, int i2) {
        AppMethodBeat.i(259428);
        try {
            String Fg = Fg(str);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uxinfo", Util.nullAsNil(Fg));
            jSONObject2.put("snsid", str2);
            jSONObject2.put("scene", i2);
            jSONObject.put("sns_ad", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            Log.d("FinderAdJumpHelper", "makeAdInfoExtra, ret=".concat(String.valueOf(jSONObject3)));
            AppMethodBeat.o(259428);
            return jSONObject3;
        } catch (Exception e2) {
            Log.e("FinderAdJumpHelper", "makeAdInfoExtra, exp=" + e2.toString());
            AppMethodBeat.o(259428);
            return "";
        }
    }

    private static String Fg(String str) {
        AppMethodBeat.i(201934);
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            } catch (Exception e2) {
                Log.e("FinderAdJumpHelper", "urlEncode exp=" + e2.toString());
            }
        }
        AppMethodBeat.o(201934);
        return str;
    }
}
