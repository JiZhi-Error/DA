package com.tencent.mm.plugin.webview.h;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.x;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.e;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J$\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J \u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J2\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/webview/preload/WebViewNativePageUtil;", "", "()V", "SHARE_FUN_FLAG_FRIEND", "", "SHARE_FUN_FLAG_TIMELINE", "TAG", "", "checkParam", "itemShowType", "data", "Lorg/json/JSONObject;", "doHandleMPPageAction", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "msgHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/MsgHandler;", "callbacker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_Callback_AIDL;", "doHandleSearchItemDetailPage", "fillNativePageData", "", "bundle", "Landroid/os/Bundle;", "fillNativePageMPMsgInfo", "fillNativePagePosData", "context", "Landroid/content/Context;", "currentInfoStr", Constants.PARAM_DENSITY, "", "intent", "Landroid/content/Intent;", "isFullScreen", "plugin-webview_release"})
public final class g {
    public static final g JcO = new g();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(82516);
        AppMethodBeat.o(82516);
    }

    private g() {
    }

    public static final void a(Bundle bundle, int i2, JSONObject jSONObject) {
        AppMethodBeat.i(175654);
        p.h(bundle, "bundle");
        p.h(jSONObject, "data");
        Log.i(TAG, "fillNativePageData itemShowType ".concat(String.valueOf(i2)));
        bundle.putString("url", jSONObject.optString("url"));
        if (jSONObject.has("item_show_type")) {
            bundle.putInt("item_show_type", jSONObject.getInt("item_show_type"));
        }
        if (jSONObject.has("scene")) {
            bundle.putInt("scene", jSONObject.optInt("scene"));
            bundle.putInt(e.b.OyQ, jSONObject.optInt("scene"));
        }
        if (jSONObject.has("subscene")) {
            bundle.putInt("subscene", jSONObject.optInt("subscene"));
            bundle.putInt(e.b.OyR, jSONObject.optInt("subscene"));
        }
        if (jSONObject.has("openType")) {
            bundle.putInt("openType", jSONObject.optInt("openType"));
        }
        if (jSONObject.has("currentInfo")) {
            bundle.putString("currentInfo", jSONObject.optString("currentInfo"));
        }
        if (jSONObject.has("channelSessionId")) {
            bundle.putString("biz_video_channel_session_id", jSONObject.optString("channelSessionId"));
        }
        bundle.putBoolean("isNativePage", true);
        bundle.putInt("biz_video_session_id", ab.getSessionId());
        b(bundle, i2, jSONObject);
        AppMethodBeat.o(175654);
    }

    private static void b(Bundle bundle, int i2, JSONObject jSONObject) {
        AppMethodBeat.i(175655);
        p.h(bundle, "bundle");
        p.h(jSONObject, "data");
        if (i2 == 5) {
            x xVar = new x();
            xVar.dHc = jSONObject.optString("srcUserName");
            xVar.iAg = jSONObject.optString("srcDisplayName");
            if (jSONObject.has("url")) {
                xVar.iAi.url = jSONObject.optString("url");
            } else if (jSONObject.has("jumpUrl")) {
                xVar.iAi.url = jSONObject.optString("jumpUrl");
            }
            xVar.iAi.title = jSONObject.optString("title");
            xVar.iAi.iAq = jSONObject.optString("digest");
            xVar.iAi.iAo = jSONObject.optString("cover");
            xVar.iAi.type = i2;
            xVar.iAi.time = (long) jSONObject.optInt("pubTime");
            xVar.iAi.iAs = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
            xVar.iAi.videoWidth = jSONObject.optInt("videoWidth");
            xVar.iAi.videoHeight = jSONObject.optInt("videoHeight");
            xVar.iAi.vid = jSONObject.optString("vid");
            xVar.z(bundle);
        }
        AppMethodBeat.o(175655);
    }

    public static final String c(int i2, JSONObject jSONObject) {
        AppMethodBeat.i(175656);
        p.h(jSONObject, "data");
        if (i2 == 5 && ((b) com.tencent.mm.kernel.g.af(b.class)).CQ(i2) && !z.gsK()) {
            if (!jSONObject.has("srcUserName")) {
                AppMethodBeat.o(175656);
                return "invalid srcUserName";
            } else if (!jSONObject.has("srcDisplayName")) {
                AppMethodBeat.o(175656);
                return "invalid srcDisplayName";
            } else if (!jSONObject.has("title")) {
                AppMethodBeat.o(175656);
                return "invalid title";
            } else if (!jSONObject.has("pubTime")) {
                AppMethodBeat.o(175656);
                return "invalid cover";
            } else if (!jSONObject.has("cover")) {
                AppMethodBeat.o(175656);
                return "invalid cover";
            } else if (!jSONObject.has("vid")) {
                AppMethodBeat.o(175656);
                return "invalid vid";
            }
        }
        AppMethodBeat.o(175656);
        return "";
    }

    public static final void a(Context context, String str, float f2, Intent intent, boolean z) {
        AppMethodBeat.i(82513);
        p.h(context, "context");
        p.h(intent, "intent");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(82513);
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("pos");
            if (optJSONObject != null) {
                int eu = au.eu(context);
                int statusBarHeight = au.getStatusBarHeight(context);
                int optDouble = (int) (optJSONObject.optDouble("width") * ((double) f2));
                int optDouble2 = (int) (optJSONObject.optDouble("height") * ((double) f2));
                int optDouble3 = (int) (optJSONObject.optDouble("x") * ((double) f2));
                int optDouble4 = (int) (((double) (z ? 0 : eu + statusBarHeight)) + (optJSONObject.optDouble("y") * ((double) f2)));
                intent.putExtra("img_gallery_width", optDouble).putExtra("img_gallery_height", optDouble2).putExtra("img_gallery_left", optDouble3).putExtra("img_gallery_top", optDouble4);
                Log.d(TAG, "fillNativePagePosData left %d, top %d, w %d, h %d, density %f,screenHeight %d", Integer.valueOf(optDouble3), Integer.valueOf(optDouble4), Integer.valueOf(optDouble), Integer.valueOf(optDouble2), Float.valueOf(f2), Integer.valueOf(a.jo(context)));
                AppMethodBeat.o(82513);
                return;
            }
        } catch (Exception e2) {
            Log.e(TAG, "fillNativePagePosData exp " + e2.getMessage());
        }
        AppMethodBeat.o(82513);
    }

    public static final boolean a(n nVar, f fVar, com.tencent.mm.plugin.webview.stub.f fVar2) {
        String str;
        int i2;
        int i3;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3 = null;
        int i4 = 0;
        boolean z = false;
        AppMethodBeat.i(210369);
        p.h(nVar, "msg");
        p.h(fVar, "msgHandler");
        Object obj = nVar.params.get(NativeProtocol.WEB_DIALOG_ACTION);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(210369);
            throw tVar;
        }
        String str2 = (String) obj;
        Log.i(TAG, "doHandleMPPageAction action=%s", str2);
        if (Util.isNullOrNil(str2)) {
            fVar.a(nVar, "handleMPPageAction:fail action is empty", (Map<String, Object>) null);
            AppMethodBeat.o(210369);
            return false;
        }
        Bundle bundle4 = new Bundle();
        bundle4.putString(NativeProtocol.WEB_DIALOG_ACTION, str2);
        if (p.j("writeComment", str2)) {
            Object obj2 = nVar.params.get(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            if (obj2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210369);
                throw tVar2;
            }
            String str3 = (String) obj2;
            Object obj3 = nVar.params.get("comment_id");
            if (obj3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210369);
                throw tVar3;
            }
            long j2 = Util.getLong((String) obj3, 0);
            bundle4.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, str3);
            bundle4.putLong("commentTopicId", j2);
            if (fVar2 != null) {
                try {
                    fVar2.j(201, bundle4);
                } catch (RemoteException e2) {
                    Log.e(TAG, "doHandleHaoKanAction e=%s", e2.getMessage());
                }
            }
            fVar.a(nVar, "handleMPPageAction:ok", (Map<String, Object>) null);
            AppMethodBeat.o(210369);
            return true;
        } else if (p.j("writeCommentReply", str2)) {
            Object obj4 = nVar.params.get("comment_id");
            if (obj4 == null) {
                t tVar4 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210369);
                throw tVar4;
            }
            long j3 = Util.getLong((String) obj4, 0);
            Object obj5 = nVar.params.get("reply_content");
            if (obj5 == null) {
                t tVar5 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210369);
                throw tVar5;
            }
            String str4 = (String) obj5;
            Object obj6 = nVar.params.get("personal_comment_id");
            if (obj6 == null) {
                t tVar6 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210369);
                throw tVar6;
            }
            int i5 = Util.getInt((String) obj6, 0);
            bundle4.putLong("commentTopicId", j3);
            bundle4.putString("reply_content", str4);
            bundle4.putInt("personal_comment_id", i5);
            if (fVar2 != null) {
                try {
                    fVar2.j(201, bundle4);
                } catch (RemoteException e3) {
                    Log.e(TAG, "doHandleHaoKanAction e=%s", e3.getMessage());
                }
            }
            fVar.a(nVar, "handleMPPageAction:ok", (Map<String, Object>) null);
            AppMethodBeat.o(210369);
            return true;
        } else if (p.j("share", str2)) {
            try {
                bundle4.putString(IssueStorage.COLUMN_EXT_INFO, (String) nVar.params.get(IssueStorage.COLUMN_EXT_INFO));
                if (fVar2 != null) {
                    fVar2.j(201, bundle4);
                }
            } catch (RemoteException e4) {
                Log.e(TAG, "doHandleMPPageAction e=%s", e4.getMessage());
            }
            fVar.a(nVar, "handleMPPageAction:ok", (Map<String, Object>) null);
            AppMethodBeat.o(210369);
            return true;
        } else if (p.j("showToast", str2)) {
            Object obj7 = nVar.params.get("wording");
            if (obj7 == null) {
                t tVar7 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210369);
                throw tVar7;
            }
            String str5 = (String) obj7;
            Object obj8 = nVar.params.get("status");
            if (obj8 == null) {
                t tVar8 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210369);
                throw tVar8;
            }
            bundle4.putString("wording", str5);
            bundle4.putString("status", (String) obj8);
            if (fVar2 != null) {
                try {
                    fVar2.j(201, bundle4);
                } catch (RemoteException e5) {
                    Log.e(TAG, "doHandleMPPageAction e=%s", e5.getMessage());
                }
            }
            fVar.a(nVar, "handleMPPageAction:ok", (Map<String, Object>) null);
            AppMethodBeat.o(210369);
            return true;
        } else if (p.j("switchVideo", str2)) {
            JSONObject jSONObject = nVar.ISf;
            p.g(jSONObject, "msg.rawParams");
            a(bundle4, 5, jSONObject);
            if (fVar2 != null) {
                try {
                    fVar2.j(201, bundle4);
                } catch (RemoteException e6) {
                    Log.e(TAG, "doHandleMPPageAction e=%s", e6.getMessage());
                }
            }
            fVar.a(nVar, "handleMPPageAction:ok", (Map<String, Object>) null);
            AppMethodBeat.o(210369);
            return true;
        } else if (p.j("createAdWebview", str2)) {
            Object obj9 = nVar.params.get("adUrl");
            if (obj9 == null) {
                t tVar9 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210369);
                throw tVar9;
            }
            bundle4.putString("adUrl", (String) obj9);
            if (fVar2 != null) {
                try {
                    bundle2 = fVar2.j(201, bundle4);
                } catch (RemoteException e7) {
                    Log.e(TAG, "doHandleMPPageAction e=%s", e7.getMessage());
                }
            } else {
                bundle2 = null;
            }
            if (bundle2 == null) {
                p.hyc();
            }
            z = bundle2.getBoolean("ret");
            if (z) {
                fVar.a(nVar, "handleMPPageAction:ok", (Map<String, Object>) null);
            } else {
                fVar.a(nVar, "handleMPPageAction:fail", (Map<String, Object>) null);
            }
            AppMethodBeat.o(210369);
            return true;
        } else if (p.j("closeAdWebview", str2)) {
            if (fVar2 != null) {
                try {
                    fVar2.j(201, bundle4);
                } catch (RemoteException e8) {
                    Log.e(TAG, "doHandleMPPageAction e=%s", e8.getMessage());
                }
            }
            fVar.a(nVar, "handleMPPageAction:ok", (Map<String, Object>) null);
            AppMethodBeat.o(210369);
            return true;
        } else if (p.j("adWebviewReady", str2)) {
            if (fVar2 != null) {
                try {
                    fVar2.j(201, bundle4);
                } catch (RemoteException e9) {
                    Log.e(TAG, "doHandleMPPageAction e=%s", e9.getMessage());
                }
            }
            fVar.a(nVar, "handleMPPageAction:ok", (Map<String, Object>) null);
            AppMethodBeat.o(210369);
            return true;
        } else if (p.j("closeDotWebview", str2) || p.j("hideDotWebview", str2)) {
            try {
                Object obj10 = nVar.params.get("webviewId");
                if (obj10 == null) {
                    t tVar10 = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(210369);
                    throw tVar10;
                }
                bundle4.putInt("webviewId", Util.getInt((String) obj10, 0));
                if (fVar2 != null) {
                    fVar2.j(201, bundle4);
                }
                fVar.a(nVar, "handleMPPageAction:ok", (Map<String, Object>) null);
                AppMethodBeat.o(210369);
                return true;
            } catch (RemoteException e10) {
                Log.e(TAG, "doHandleMPPageAction e=%s", e10.getMessage());
            }
        } else if (p.j("dotWebViewReady", str2)) {
            try {
                Object obj11 = nVar.params.get("webviewId");
                if (obj11 == null) {
                    t tVar11 = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(210369);
                    throw tVar11;
                }
                bundle4.putInt("webviewId", Util.getInt((String) obj11, 0));
                if (fVar2 != null) {
                    fVar2.j(201, bundle4);
                }
                fVar.a(nVar, "handleMPPageAction:ok", (Map<String, Object>) null);
                AppMethodBeat.o(210369);
                return true;
            } catch (RemoteException e11) {
                Log.e(TAG, "doHandleMPPageAction e=%s", e11.getMessage());
            }
        } else if (p.j("setDotScriptData", str2)) {
            try {
                Object obj12 = nVar.params.get("data");
                if (obj12 == null) {
                    t tVar12 = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(210369);
                    throw tVar12;
                }
                bundle4.putString("data", (String) obj12);
                if (fVar2 != null) {
                    fVar2.j(201, bundle4);
                }
                fVar.a(nVar, "handleMPPageAction:ok", (Map<String, Object>) null);
                AppMethodBeat.o(210369);
                return true;
            } catch (RemoteException e12) {
                Log.e(TAG, "doHandleMPPageAction e=%s", e12.getMessage());
            }
        } else if (p.j("getMPVideoState", str2)) {
            if (fVar2 != null) {
                try {
                    bundle = fVar2.j(201, bundle4);
                } catch (RemoteException e13) {
                    Log.e(TAG, "doHandleMPPageAction e=%s", e13.getMessage());
                }
            } else {
                bundle = null;
            }
            bundle3 = bundle;
            HashMap hashMap = new HashMap();
            if (bundle3 != null) {
                hashMap.put("currentTime", Integer.valueOf(bundle3.getInt("currentTime")));
                hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(bundle3.getInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION)));
                hashMap.put("state", bundle3.getString("state"));
                hashMap.put("vid", bundle3.getString("vid"));
            }
            fVar.a(nVar, "handleMPPageAction:ok", hashMap);
            AppMethodBeat.o(210369);
            return true;
        } else if (p.j("sendMPPageData", str2)) {
            Object obj13 = nVar.params.get("data");
            if (obj13 == null) {
                t tVar13 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210369);
                throw tVar13;
            }
            bundle4.putString("data", (String) obj13);
            Object obj14 = nVar.params.get("sendTo");
            if (obj14 == null) {
                t tVar14 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210369);
                throw tVar14;
            }
            bundle4.putString("sendTo", (String) obj14);
            if (nVar.params.containsKey("webviewId")) {
                Object obj15 = nVar.params.get("webviewId");
                if (obj15 == null) {
                    t tVar15 = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(210369);
                    throw tVar15;
                }
                i3 = Util.getInt((String) obj15, 0);
            } else {
                i3 = 0;
            }
            bundle4.putInt("webviewId", i3);
            if (fVar2 != null) {
                try {
                    fVar2.j(201, bundle4);
                } catch (RemoteException e14) {
                    Log.e(TAG, "doHandleMPPageAction e=%s", e14.getMessage());
                }
            }
            fVar.a(nVar, "handleMPPageAction:ok", (Map<String, Object>) null);
            AppMethodBeat.o(210369);
            return true;
        } else if (p.j("setWebviewBackground", str2)) {
            Object obj16 = nVar.params.get("backgroundColor");
            if (obj16 == null) {
                t tVar16 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210369);
                throw tVar16;
            }
            bundle4.putString("backgroundColor", (String) obj16);
            if (fVar2 != null) {
                try {
                    fVar2.j(201, bundle4);
                } catch (RemoteException e15) {
                    Log.e(TAG, "doHandleMPPageAction e=%s", e15.getMessage());
                }
            }
            fVar.a(nVar, "handleMPPageAction:ok", (Map<String, Object>) null);
            AppMethodBeat.o(210369);
            return true;
        } else if (p.j("opPlayer", str2)) {
            Object obj17 = nVar.params.get("opType");
            if (obj17 == null) {
                t tVar17 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210369);
                throw tVar17;
            }
            bundle4.putString("opType", (String) obj17);
            if (fVar2 != null) {
                try {
                    fVar2.j(201, bundle4);
                } catch (RemoteException e16) {
                    Log.e(TAG, "doHandleMPPageAction e=%s", e16.getMessage());
                }
            }
            fVar.a(nVar, "handleMPPageAction:ok", (Map<String, Object>) null);
            AppMethodBeat.o(210369);
            return true;
        } else if (p.j("paySuccess", str2)) {
            Map<String, Object> map = nVar.params;
            p.g(map, "msg.params");
            if (map.containsKey("fullUrl")) {
                Object obj18 = nVar.params.get("fullUrl");
                if (obj18 == null) {
                    t tVar18 = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(210369);
                    throw tVar18;
                }
                str = (String) obj18;
            } else {
                Object obj19 = nVar.params.get("url");
                if (obj19 == null) {
                    t tVar19 = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(210369);
                    throw tVar19;
                }
                str = (String) obj19;
            }
            Map<String, Object> map2 = nVar.params;
            p.g(map2, "msg.params");
            if (map2.containsKey("itemShowType")) {
                Object obj20 = nVar.params.get("itemShowType");
                if (obj20 == null) {
                    t tVar20 = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(210369);
                    throw tVar20;
                }
                i2 = Util.getInt((String) obj20, -1);
            } else {
                i2 = -1;
            }
            if (Util.isNullOrNil(str)) {
                fVar.a(nVar, "handleMPPageAction:fail_url_is_null", (Map<String, Object>) null);
                AppMethodBeat.o(210369);
                return true;
            }
            ((b) com.tencent.mm.kernel.g.af(b.class)).cE(str, i2);
            fVar.a(nVar, "handleMPPageAction:ok", (Map<String, Object>) null);
            AppMethodBeat.o(210369);
            return true;
        } else if (p.j("isGPVersion", str2)) {
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = hashMap2;
            if (ChannelUtil.isGPVersion() || com.tencent.mm.model.z.aUn()) {
                i4 = 1;
            }
            hashMap3.put("GPVersion", Integer.valueOf(i4));
            fVar.a(nVar, "handleMPPageAction:ok", hashMap2);
            AppMethodBeat.o(210369);
            return true;
        } else {
            fVar.a(nVar, "handleMPPageAction:fail, action not support", (Map<String, Object>) null);
            AppMethodBeat.o(210369);
            return false;
        }
    }

    public static final boolean b(n nVar, f fVar, com.tencent.mm.plugin.webview.stub.f fVar2) {
        AppMethodBeat.i(210370);
        p.h(nVar, "msg");
        p.h(fVar, "msgHandler");
        if (!((b) com.tencent.mm.kernel.g.af(b.class)).CR(5)) {
            AppMethodBeat.o(210370);
            return false;
        }
        int optInt = nVar.ISf.optInt("itemType", -1);
        Bundle bundle = new Bundle();
        if (optInt >= 0) {
            bundle.putString("url", nVar.ISf.optString("jumpUrl"));
            bundle.putInt("item_show_type", optInt);
            bundle.putInt("scene", nVar.ISf.optInt("scene"));
            bundle.putInt("openType", -1);
            if (optInt == 5 && ((b) com.tencent.mm.kernel.g.af(b.class)).CQ(optInt)) {
                JSONObject jSONObject = nVar.ISf;
                p.g(jSONObject, "msg.rawParams");
                if (Util.isNullOrNil(c(optInt, jSONObject))) {
                    if (nVar.ISf.has("currentInfo")) {
                        bundle.putString("currentInfo", nVar.ISf.optString("currentInfo"));
                    }
                    if (nVar.ISf.has("scene")) {
                        bundle.putInt(e.b.OyQ, nVar.ISf.optInt("scene"));
                    }
                    bundle.putInt(e.b.OyR, nVar.ISf.optInt("subScene"));
                    bundle.putString("KPublisherId", nVar.ISf.optString("publishId"));
                    bundle.putInt("biz_video_session_id", ab.getSessionId());
                    bundle.putBoolean("isNativePage", true);
                    JSONObject jSONObject2 = nVar.ISf;
                    p.g(jSONObject2, "msg.rawParams");
                    b(bundle, optInt, jSONObject2);
                    h.INSTANCE.idkeyStat(1061, 20, 1, false);
                }
            }
            Bundle j2 = fVar2 != null ? fVar2.j(200, bundle) : null;
            if (j2 == null || !j2.getBoolean("success")) {
                AppMethodBeat.o(210370);
                return false;
            }
            AppMethodBeat.o(210370);
            return true;
        }
        AppMethodBeat.o(210370);
        return false;
    }
}
