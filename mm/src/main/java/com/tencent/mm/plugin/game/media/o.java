package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.game.api.g;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.s;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class o implements g {
    @Override // com.tencent.mm.plugin.game.api.g
    public final void ap(String str, String str2, String str3) {
        AppMethodBeat.i(41143);
        Log.i("MicroMsg.Haowan.GameVideoEditorLauncher", "businessType:%s; appid:%s; extInfo:%s", str, str2, str3);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            String optString = jSONObject.optString("videoPath");
            String optString2 = jSONObject.optString("videoUrl");
            String optString3 = jSONObject.optString("thumbUrl");
            boolean z = jSONObject.optInt("needEdit", 0) == 1;
            String str4 = "";
            try {
                str4 = URLEncoder.encode(jSONObject.optString("gameInfo"), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e2) {
                Log.i("MicroMsg.Haowan.GameVideoEditorLauncher", "err:%s", e2.getMessage());
            }
            a(null, 3, str, str2, optString, optString2, optString3, z, str4, 0, null, 12);
            AppMethodBeat.o(41143);
        } catch (Exception e3) {
            n.d(str, "json is invalid", str2, -3, "json is invalid");
            AppMethodBeat.o(41143);
        }
    }

    @Override // com.tencent.mm.plugin.game.api.g
    public final void a(Context context, String str, String str2, String str3, int i2, Bundle bundle) {
        AppMethodBeat.i(174302);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appName", str2);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.Haowan.GameVideoEditorLauncher", e2, "hy: put appname failed!", new Object[0]);
        }
        a(context, 2, null, str, str3, null, null, true, jSONObject.toString(), i2, bundle, 30);
        AppMethodBeat.o(174302);
    }

    @Override // com.tencent.mm.plugin.game.api.g
    public final void a(Context context, String str, int i2, Bundle bundle, int i3) {
        AppMethodBeat.i(204136);
        a(context, 4, null, null, str, null, null, true, null, i2, bundle, i3);
        AppMethodBeat.o(204136);
    }

    @Override // com.tencent.mm.plugin.game.api.g
    public final void a(Context context, String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(204137);
        a(context, 5, null, str3, null, str, str2, true, null, i2, null, i3);
        AppMethodBeat.o(204137);
    }

    @Override // com.tencent.mm.plugin.game.api.g
    public final void a(Context context, int i2, String str, String str2, String str3, String str4, int i3, Bundle bundle, int i4) {
        AppMethodBeat.i(204138);
        a(context, i2, null, str, str2, str3, str4, true, null, i3, bundle, i4);
        AppMethodBeat.o(204138);
    }

    private static void a(Context context, int i2, String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i3, Bundle bundle, int i4) {
        boolean z2;
        AppMethodBeat.i(204139);
        Log.i("MicroMsg.Haowan.GameVideoEditorLauncher", "goToEditor, from[%d], businessType[%s], appid[%s], videoPath[%s], videoUrl[%s], needEdit[%b], gameInfo[%s]", Integer.valueOf(i2), str, str2, str3, str4, Boolean.valueOf(z), str6);
        Intent intent = new Intent();
        intent.putExtra("from", i2);
        intent.putExtra("business_type", str);
        intent.putExtra("appid", str2);
        intent.putExtra("video_path", str3);
        intent.putExtra("video_url", str4);
        intent.putExtra("thumb_url", str5);
        intent.putExtra("need_edit", z);
        intent.putExtra("game_info", str6);
        intent.putExtra("ext_data", bundle);
        intent.putExtra("game_haowan_source_scene_id", i4);
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        if (!Util.isNullOrNil(str3) && s.YS(str3)) {
            z2 = false;
        } else if (Util.isNullOrNil(str4)) {
            Log.e("MicroMsg.Haowan.GameVideoEditorLauncher", "videoPath and videoUrl is invalid");
            if (i2 == 3) {
                n.d(str, "videoPath and videoUrl is invalid", str2, -3, "videoPath and videoUrl is invalid");
            }
            AppMethodBeat.o(204139);
            return;
        } else if (z) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (context instanceof Activity) {
                c.b(context, "game", ".media.GameVideoDownloadUI", intent, i3);
                AppMethodBeat.o(204139);
                return;
            }
            c.b(MMApplicationContext.getContext(), "game", ".media.GameVideoDownloadUI", intent);
            AppMethodBeat.o(204139);
        } else if (context instanceof Activity) {
            c.b(context, "game", ".media.GameVideoEditorProxyUI", intent, i3);
            AppMethodBeat.o(204139);
        } else {
            c.b(MMApplicationContext.getContext(), "game", ".media.GameVideoEditorProxyUI", intent);
            AppMethodBeat.o(204139);
        }
    }
}
