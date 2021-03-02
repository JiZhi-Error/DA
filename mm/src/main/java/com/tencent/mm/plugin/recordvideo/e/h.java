package com.tencent.mm.plugin.recordvideo.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012J\u0016\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/util/SecondCutUtil;", "", "()V", "APPID_SECONDCUT", "", "DOWNLOAD_FROM_SNS_HOME", "DOWNLOAD_FROM_VIDEO_CORP", "DOWNLOAD_SECONDCUT_URL", "PACKAGE_NAME_SECONDCUT", "PRE_SCHEMA_SECONDCUT", "PUBLIC_KEY_SECONDCUT", "SCENE_MOMENTS", "TAG", "getSecondCutEditIntent", "Landroid/content/Intent;", "scene", "videoPath", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "videoBitrate", "width", "height", "getSecondCutHomeIntent", "takeSecondCutSigh", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/content/Context;", "intent", "plugin-recordvideo_release"})
public final class h {
    public static final h Cix = new h();

    static {
        AppMethodBeat.i(238005);
        AppMethodBeat.o(238005);
    }

    private h() {
    }

    public static void ao(Context context, Intent intent) {
        AppMethodBeat.i(238002);
        p.h(context, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(intent, "intent");
        try {
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/recordvideo/util/SecondCutUtil", "takeSecondCutSigh", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/recordvideo/util/SecondCutUtil", "takeSecondCutSigh", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(R.anim.ei, -1);
                AppMethodBeat.o(238002);
                return;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SecondCutUtil", "takeSecondCutSigh: error " + e2.getMessage());
        }
        AppMethodBeat.o(238002);
    }

    public static Intent b(String str, String str2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(238003);
        p.h(str, "scene");
        p.h(str2, "videoPath");
        Log.i("MicroMsg.SecondCutUtil", "getSecondCutEditIntent >>>videoPath: " + str2 + " >>>width: " + i4 + " >>>height: " + i5 + " >>>duration: " + i2 + " >>> videoBitrate: " + i3);
        byte[] bytes = str2.getBytes(d.UTF_8);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes, 10);
        Intent intent = new Intent();
        intent.setData(Uri.parse("miaojian://createvideo?scene=" + str + "&assetPaths=" + encodeToString + "&maxDuration=" + i2 + "&bitrate=" + i3 + "&resolution=" + i4 + ',' + i5 + "&from=2"));
        intent.setPackage("com.tencent.phoenix");
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(268435456);
        AppMethodBeat.o(238003);
        return intent;
    }

    public static Intent fm(String str, int i2) {
        AppMethodBeat.i(238004);
        p.h(str, "scene");
        Intent intent = new Intent();
        intent.setData(Uri.parse("miaojian://createvideo?scene=" + str + "&maxDuration=" + i2 + "&from=1"));
        intent.setPackage("com.tencent.phoenix");
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(268435456);
        AppMethodBeat.o(238004);
        return intent;
    }
}
