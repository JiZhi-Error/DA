package com.tencent.mm.plugin.webview.ui.tools.video;

import android.graphics.Bitmap;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u0006\u0010\u0010\u001a\u00020\u0004J \u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ*\u0010\u001d\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010\u001d\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/video/MPVideoPreviewDataMgr;", "", "()V", "TAG", "", "abTestOn", "", "getAbTestOn", "()Z", "abTestOn$delegate", "Lkotlin/Lazy;", "videoManager", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getInitialParams", "", "Ljava/lang/Object;", "getOnReceiveNativeData", "getVideo", "vid", "parseNativeData", "", "nativeData", "prepareOnReceivePageData", "reportByLeaveForMPGateway", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "reportOnLeaveForMP", "json", "Lorg/json/JSONObject;", "saveVideo", "playTime", "", "expireTime", "bitmap", "Landroid/graphics/Bitmap;", "plugin-webview_release"})
public final class a {
    private static final f JxL = g.ah(C2001a.JxO);
    public static final MMKVSlotManager JxM;
    public static final a JxN = new a();

    public static boolean gic() {
        AppMethodBeat.i(210669);
        boolean booleanValue = ((Boolean) JxL.getValue()).booleanValue();
        AppMethodBeat.o(210669);
        return booleanValue;
    }

    static {
        AppMethodBeat.i(210674);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("MicroMsg.MPVideoPreviewDataMgr");
        p.g(mmkv, "MultiProcessMMKV.getMMKV(TAG)");
        JxM = new MMKVSlotManager(mmkv, 600);
        AppMethodBeat.o(210674);
    }

    private a() {
    }

    public final void bbh(String str) {
        AppMethodBeat.i(210670);
        try {
            String optString = new JSONObject(str).optString("video_data");
            if (Util.isNullOrNil(optString)) {
                Log.i("MicroMsg.MPVideoPreviewDataMgr", "reportByLeaveForMPGateway video_data null");
                AppMethodBeat.o(210670);
                return;
            }
            JSONObject jSONObject = new JSONObject(optString);
            a(jSONObject.optString("vid"), (int) Util.getFloat(jSONObject.optString("lastPlayedTime"), 0.0f), (int) Util.getFloat(jSONObject.optString("lastPlayedTimeExpiredTime"), 0.0f), null);
            AppMethodBeat.o(210670);
        } catch (Exception e2) {
            Log.i("MicroMsg.MPVideoPreviewDataMgr", "reportByLeaveForMPGateway, ex = %s", e2.getMessage());
            AppMethodBeat.o(210670);
        }
    }

    public static void a(String str, int i2, int i3, Bitmap bitmap) {
        String str2;
        AppMethodBeat.i(210671);
        if (!gic()) {
            AppMethodBeat.o(210671);
            return;
        }
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) JxM.getSlot();
        multiProcessMMKV.encode("MicroMsg.MPVideoPreviewDataMgr_" + str + "_playTime", i2);
        multiProcessMMKV.encode("MicroMsg.MPVideoPreviewDataMgr_" + str + "_expire", i3);
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            p.g(encodeToString, "android.util.Base64.enco…roid.util.Base64.DEFAULT)");
            str2 = encodeToString;
        } else {
            str2 = "";
        }
        ((MultiProcessMMKV) JxM.getSlot()).encode("MicroMsg.MPVideoPreviewDataMgr_" + str + "_bitmap", str2);
        AppMethodBeat.o(210671);
    }

    public static void bbi(String str) {
        Integer num = null;
        AppMethodBeat.i(210672);
        if (!gic()) {
            AppMethodBeat.o(210672);
            return;
        }
        Map<String, Object> bbj = bbj(str);
        if (bbj == null) {
            Log.i("MicroMsg.MPVideoPreviewDataMgr", "prepareOnReceivePageData vid not found");
            ((MultiProcessMMKV) JxM.getSlot()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
            AppMethodBeat.o(210672);
            return;
        }
        ((MultiProcessMMKV) JxM.getSlot()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", str);
        StringBuilder sb = new StringBuilder("prepareOnReceivePageData len = ");
        Object obj = bbj.get("videoInitialSnapshot");
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str2 = (String) obj;
        if (str2 != null) {
            num = Integer.valueOf(str2.length());
        }
        Log.v("MicroMsg.MPVideoPreviewDataMgr", sb.append(num).toString());
        AppMethodBeat.o(210672);
    }

    public static Map<String, Object> bbj(String str) {
        HashMap hashMap;
        int i2;
        AppMethodBeat.i(210673);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.MPVideoPreviewDataMgr", "getVideo vid null");
            AppMethodBeat.o(210673);
            return null;
        }
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) JxM.getSlot();
        int i3 = multiProcessMMKV.getInt("MicroMsg.MPVideoPreviewDataMgr_" + str + "_playTime", 0);
        int i4 = multiProcessMMKV.getInt("MicroMsg.MPVideoPreviewDataMgr_" + str + "_expire", 0);
        boolean z = System.currentTimeMillis() / 1000 > ((long) i4);
        if (i3 == 0 || i4 == 0 || z) {
            hashMap = null;
        } else {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("videoInitialTime", Integer.valueOf(i3));
            String string = multiProcessMMKV.getString("MicroMsg.MPVideoPreviewDataMgr_" + str + "_bitmap", "");
            if (string == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.Object");
                AppMethodBeat.o(210673);
                throw tVar;
            }
            hashMap2.put("videoInitialSnapshot", string);
            hashMap = hashMap2;
        }
        StringBuilder append = new StringBuilder("getVideo vid = ").append(str).append(", map size = ");
        if (hashMap != null) {
            i2 = hashMap.size();
        } else {
            i2 = 0;
        }
        Log.i("MicroMsg.MPVideoPreviewDataMgr", append.append(i2).toString());
        HashMap hashMap3 = hashMap;
        AppMethodBeat.o(210673);
        return hashMap3;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.video.a$a  reason: collision with other inner class name */
    static final class C2001a extends q implements kotlin.g.a.a<Boolean> {
        public static final C2001a JxO = new C2001a();

        static {
            AppMethodBeat.i(210668);
            AppMethodBeat.o(210668);
        }

        C2001a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(210667);
            if (((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_open_timeline_video_preview, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(210667);
            return valueOf;
        }
    }
}
