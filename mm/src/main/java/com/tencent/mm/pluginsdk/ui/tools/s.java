package com.tencent.mm.pluginsdk.ui.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMFragment;

public final class s {
    private static String filePath = null;

    public static boolean a(Fragment fragment, Intent intent, String str, int i2) {
        AppMethodBeat.i(116214);
        Log.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4, "MicroMsg.TakePhotoUtil")));
        SightParams sightParams = new SightParams(1, i2);
        String Qv = t.Qv(str);
        o.bhj();
        String Qw = t.Qw(Qv);
        o.bhj();
        sightParams.v(Qv, Qw, t.Qx(Qv), AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", "capture", Long.valueOf(System.currentTimeMillis()), "jpg"));
        intent.putExtra("KEY_SIGHT_PARAMS", sightParams);
        c.a(fragment, "mmsight", ".ui.SightCaptureUI", intent, 226);
        fragment.getActivity().overridePendingTransition(R.anim.ei, -1);
        AppMethodBeat.o(116214);
        return true;
    }

    public static boolean ax(Context context, Intent intent) {
        AppMethodBeat.i(116215);
        boolean d2 = d(context, intent, "");
        AppMethodBeat.o(116215);
        return d2;
    }

    public static boolean d(Context context, Intent intent, String str) {
        AppMethodBeat.i(186125);
        boolean a2 = a(context, 17, intent, 2, str);
        AppMethodBeat.o(186125);
        return a2;
    }

    public static boolean a(Context context, int i2, Intent intent, int i3, int i4) {
        AppMethodBeat.i(116217);
        boolean a2 = a(context, i2, intent, i3, "", i4, "");
        AppMethodBeat.o(116217);
        return a2;
    }

    private static boolean a(Context context, int i2, Intent intent, int i3, String str) {
        AppMethodBeat.i(204065);
        boolean a2 = a(context, 17, intent, 2, "", 0, str);
        AppMethodBeat.o(204065);
        return a2;
    }

    public static boolean e(Context context, Intent intent, String str) {
        AppMethodBeat.i(116219);
        boolean a2 = a(context, 8, intent, 1, str, 0, "");
        AppMethodBeat.o(116219);
        return a2;
    }

    private static boolean a(Context context, int i2, Intent intent, int i3, String str, int i4, String str2) {
        AppMethodBeat.i(116220);
        Log.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4, "MicroMsg.TakePhotoUtil")));
        SightParams sightParams = null;
        if (intent != null) {
            sightParams = (SightParams) intent.getParcelableExtra("KEY_SIGHT_PARAMS");
        }
        if (sightParams == null) {
            sightParams = new SightParams(i3, i4);
        }
        sightParams.vPa = str2;
        if (sightParams == null) {
            Log.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
        } else {
            intent.putExtra("KEY_SIGHT_PARAMS", sightParams);
        }
        if (i3 == 1) {
            String Qv = t.Qv(str);
            o.bhj();
            String Qw = t.Qw(Qv);
            o.bhj();
            sightParams.v(Qv, Qw, t.Qx(Qv), AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", "capture", Long.valueOf(System.currentTimeMillis()), "jpg"));
        }
        if (sightParams == null) {
            Log.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
        } else {
            intent.putExtra("KEY_SIGHT_PARAMS", sightParams);
        }
        c.b(context, "mmsight", ".ui.SightCaptureUI", intent, i2);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.ei, -1);
        }
        AppMethodBeat.o(116220);
        return true;
    }

    private static boolean g(Context context, Intent intent, String str) {
        AppMethodBeat.i(116222);
        SightParams sightParams = null;
        if (intent != null) {
            sightParams = (SightParams) intent.getParcelableExtra("KEY_SIGHT_PARAMS");
        }
        if (sightParams == null) {
            sightParams = new SightParams(2, 0);
        }
        sightParams.vPa = str;
        if (sightParams == null) {
            Log.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
        } else {
            String str2 = sightParams.vPa;
            if (Util.isNullOrNil(str2)) {
                str2 = Util.nowMilliSecond() + "_" + Util.getRandomString(5);
            }
            StringBuilder sb = new StringBuilder("weishi://camera?forceNoShowLogin=1");
            Log.d("MicroMsg.TakePhotoUtil", "weishi_url = %s", sb.toString());
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(sb.toString()));
            intent.setPackage("com.tencent.weishi");
            intent.setFlags(268435456);
            U(context, intent.getPackage(), str2);
        }
        try {
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSight", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSight", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(R.anim.ei, -1);
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.TakePhotoUtil", "takeWeishiSight Exception: %s", e2.getMessage());
        }
        AppMethodBeat.o(116222);
        return true;
    }

    public static boolean a(Context context, Intent intent, String str, String str2) {
        AppMethodBeat.i(116223);
        SightParams sightParams = (SightParams) intent.getParcelableExtra("KEY_SIGHT_PARAMS");
        if (sightParams == null) {
            sightParams = new SightParams(2, 0);
        }
        sightParams.vPa = str;
        if (sightParams == null) {
            Log.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
        } else {
            String str3 = sightParams.vPa;
            if (Util.isNullOrNil(str3)) {
                str3 = Util.nowMilliSecond() + "_" + Util.getRandomString(5);
            }
            if (Util.isNullOrNil(str2)) {
                Log.e("MicroMsg.TakePhotoUtil", "path is null");
            }
            if (!new com.tencent.mm.vfs.o(str2).exists()) {
                Log.e("MicroMsg.TakePhotoUtil", "file is not exists");
            }
            String bfE = bfE(str2);
            Log.d("MicroMsg.TakePhotoUtil", "weishi_uri = %s", bfE);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(bfE));
            intent.setPackage("com.tencent.weishi");
            intent.setFlags(268435456);
            U(context, intent.getPackage(), str3);
        }
        try {
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSightToEdit", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/ui/tools/TakePhotoUtil", "takeWeiShiSightToEdit", "(Landroid/content/Context;ILandroid/content/Intent;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(R.anim.ei, -1);
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.TakePhotoUtil", "takeWeishiSight Exception: %s", e2.getMessage());
        }
        AppMethodBeat.o(116223);
        return true;
    }

    public static String bfE(String str) {
        AppMethodBeat.i(116224);
        String str2 = "weishi://videoEdit?videoPath=" + str + "&activity_id=WxPublisherAct&update=1";
        AppMethodBeat.o(116224);
        return str2;
    }

    private static void U(Context context, String str, String str2) {
        AppMethodBeat.i(116225);
        context.getSharedPreferences("opensdk_shareTicket", 0).edit().putString(str, str2).apply();
        AppMethodBeat.o(116225);
    }

    public static boolean a(MMFragment mMFragment, String str, String str2) {
        AppMethodBeat.i(116226);
        boolean b2 = b(mMFragment, str, str2);
        Log.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", str, str2, 201, Boolean.valueOf(b2));
        AppMethodBeat.o(116226);
        return b2;
    }

    private static boolean b(MMFragment mMFragment, String str, String str2) {
        AppMethodBeat.i(116227);
        if (mMFragment == null) {
            Log.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys fragment is null!");
            AppMethodBeat.o(116227);
            return false;
        } else if (com.tencent.mm.q.a.o(mMFragment.getContext(), true) || com.tencent.mm.q.a.cA(mMFragment.getContext()) || com.tencent.mm.q.a.cE(mMFragment.getContext())) {
            AppMethodBeat.o(116227);
            return false;
        } else {
            filePath = com.tencent.mm.vfs.s.k(str + str2, true);
            Log.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
            cq(mMFragment.getContext(), filePath);
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(str);
            if (!oVar.exists()) {
                try {
                    oVar.mkdirs();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.TakePhotoUtil", e2, "", new Object[0]);
                }
            }
            if (!oVar.exists()) {
                Log.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. ".concat(String.valueOf(str)));
                AppMethodBeat.o(116227);
                return false;
            }
            intent.putExtra("output", FileProviderHelper.getUriForFile(mMFragment.getContext(), new com.tencent.mm.vfs.o(filePath)));
            try {
                mMFragment.startActivityForResult(intent, 201);
                AppMethodBeat.o(116227);
                return true;
            } catch (ActivityNotFoundException e3) {
                Log.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + e3.getMessage());
                AppMethodBeat.o(116227);
                return false;
            }
        }
    }

    public static boolean d(Activity activity, String str, String str2, int i2) {
        AppMethodBeat.i(116228);
        boolean e2 = e(activity, str, str2, i2);
        Log.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", str, str2, Integer.valueOf(i2), Boolean.valueOf(e2));
        AppMethodBeat.o(116228);
        return e2;
    }

    private static void cq(Context context, String str) {
        AppMethodBeat.i(116230);
        SharedPreferences.Editor edit = context.getSharedPreferences("system_config_prefs", 0).edit();
        edit.putString("camera_file_path", str);
        edit.commit();
        AppMethodBeat.o(116230);
    }

    public static boolean c(Activity activity, int i2, Intent intent) {
        AppMethodBeat.i(116231);
        a(activity, i2, 1, 0, intent);
        AppMethodBeat.o(116231);
        return true;
    }

    public static boolean aY(Activity activity) {
        AppMethodBeat.i(116232);
        a(activity, 2, 1, 0, 1, (Intent) null);
        AppMethodBeat.o(116232);
        return true;
    }

    public static boolean aZ(Activity activity) {
        AppMethodBeat.i(116233);
        a(activity, 205, 1, 11, (Intent) null);
        AppMethodBeat.o(116233);
        return true;
    }

    public static boolean f(Fragment fragment) {
        AppMethodBeat.i(116234);
        a(fragment, 200, 1, 0, 1, "", "");
        AppMethodBeat.o(116234);
        return true;
    }

    public static boolean o(Activity activity, int i2) {
        AppMethodBeat.i(116235);
        a(activity, i2, 1, 5, (Intent) null);
        AppMethodBeat.o(116235);
        return true;
    }

    public static boolean ba(Activity activity) {
        AppMethodBeat.i(116236);
        a(activity, 300, 1, 24, (Intent) null);
        AppMethodBeat.o(116236);
        return true;
    }

    public static void a(Fragment fragment, int i2, String str, String str2, Intent intent) {
        AppMethodBeat.i(116237);
        a(fragment, 217, 9, i2, 1, str, str2, intent);
        AppMethodBeat.o(116237);
    }

    public static void a(Fragment fragment, String str, String str2) {
        AppMethodBeat.i(116238);
        a(fragment, 217, 9, 9, 3, str, str2);
        AppMethodBeat.o(116238);
    }

    public static void a(Fragment fragment, String str, String str2, Intent intent) {
        AppMethodBeat.i(116239);
        a(fragment, 217, 9, 3, 3, str, str2, intent);
        AppMethodBeat.o(116239);
    }

    public static void a(Activity activity, int i2, int i3, int i4, Intent intent) {
        AppMethodBeat.i(116240);
        a(activity, i2, i3, i4, intent, true);
        AppMethodBeat.o(116240);
    }

    public static void a(Activity activity, int i2, int i3, int i4, Intent intent, boolean z) {
        Bundle extras;
        AppMethodBeat.i(204066);
        Intent intent2 = new Intent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            intent2.putExtras(extras);
        }
        intent2.putExtra("max_select_count", i3);
        intent2.putExtra("query_source_type", i4);
        intent2.putExtra("need_to_clear_top", z);
        if (z) {
            intent2.addFlags(67108864);
        }
        c.b(activity, "gallery", ".ui.GalleryEntryUI", intent2, i2);
        AppMethodBeat.o(204066);
    }

    public static void a(Activity activity, int i2, int i3, int i4, int i5, Intent intent) {
        Bundle extras;
        AppMethodBeat.i(116241);
        Intent intent2 = new Intent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            intent2.putExtras(extras);
        }
        intent2.putExtra("max_select_count", i3);
        intent2.putExtra("query_source_type", i4);
        intent2.putExtra("query_media_type", i5);
        intent2.putExtra("show_header_view", false);
        intent2.addFlags(67108864);
        c.b(activity, "gallery", ".ui.GalleryEntryUI", intent2, i2);
        AppMethodBeat.o(116241);
    }

    private static void a(Fragment fragment, int i2, int i3, int i4, int i5, String str, String str2) {
        AppMethodBeat.i(116242);
        a(fragment, i2, i3, i4, i5, str, str2, null);
        AppMethodBeat.o(116242);
    }

    private static void a(Fragment fragment, int i2, int i3, int i4, int i5, String str, String str2, Intent intent) {
        AppMethodBeat.i(116243);
        Log.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 706, 4, "MicroMsg.TakePhotoUtil")));
        if (intent == null) {
            intent = new Intent();
        }
        if (!Util.isNullOrNil(str2)) {
            intent.putExtra("GalleryUI_FromUser", str);
            intent.putExtra("GalleryUI_ToUser", str2);
        }
        intent.putExtra("max_select_count", i3);
        intent.putExtra("query_source_type", i4);
        intent.putExtra("query_media_type", i5);
        if (ac.jPB) {
            intent.putExtra("show_header_view", true);
        } else {
            intent.putExtra("show_header_view", false);
        }
        intent.addFlags(67108864);
        intent.putExtra("animation_push_up_in", true);
        c.a(fragment, "gallery", ".ui.AlbumPreviewUI", intent, i2);
        AppMethodBeat.o(116243);
    }

    public static void e(Activity activity, int i2, int i3, Intent intent) {
        AppMethodBeat.i(116244);
        intent.putExtra("max_select_count", i2);
        intent.putExtra("query_media_type", 2);
        intent.putExtra("query_source_type", i3);
        intent.addFlags(67108864);
        c.b(activity, "gallery", ".ui.GalleryEntryUI", intent, 4);
        AppMethodBeat.o(116244);
    }

    public static void a(Activity activity, String str, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(116245);
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(str);
        if (oVar.exists()) {
            oVar.delete();
        }
        Intent intent = new Intent();
        intent.putExtra("output", FileProviderHelper.getUriForFile(activity, oVar));
        intent.putExtra("android.intent.extra.videoQuality", i4);
        intent.putExtra("android.intent.extras.CAMERA_FACING", z ? 1 : 0);
        if (i3 > 0) {
            intent.putExtra("android.intent.extra.durationLimit", i3);
        }
        intent.setAction("android.media.action.VIDEO_CAPTURE");
        intent.addCategory("android.intent.category.DEFAULT");
        activity.startActivityForResult(intent, i2);
        AppMethodBeat.o(116245);
    }

    public static String h(Context context, Intent intent, String str) {
        AppMethodBeat.i(116246);
        if (filePath == null) {
            filePath = context.getSharedPreferences("system_config_prefs", 0).getString("camera_file_path", null);
        }
        if (!com.tencent.mm.vfs.s.YS(filePath)) {
            filePath = com.tencent.mm.ui.tools.a.i(context, intent, str);
        }
        AndroidMediaUtil.refreshMediaScanner(filePath, context);
        String str2 = filePath;
        AppMethodBeat.o(116246);
        return str2;
    }

    public static void l(String str, final Context context) {
        AppMethodBeat.i(116247);
        p.a(context, str, new p.a() {
            /* class com.tencent.mm.pluginsdk.ui.tools.s.AnonymousClass1 */

            @Override // com.tencent.mm.platformtools.p.a
            public final void bP(String str, String str2) {
                AppMethodBeat.i(204063);
                Toast.makeText(context, context.getString(R.string.e2z, str2), 1).show();
                AppMethodBeat.o(204063);
            }

            @Override // com.tencent.mm.platformtools.p.a
            public final void bQ(String str, String str2) {
                AppMethodBeat.i(204064);
                Toast.makeText(context, context.getString(R.string.gao), 1).show();
                AppMethodBeat.o(204064);
            }
        });
        AppMethodBeat.o(116247);
    }

    public static void refreshMediaScanner(String str, Context context) {
        AppMethodBeat.i(259526);
        AndroidMediaUtil.refreshMediaScanner(str, context);
        AppMethodBeat.o(259526);
    }

    @TargetApi(8)
    public static String getSysCameraDirPath() {
        AppMethodBeat.i(177105);
        String sysCameraDirPath = AndroidMediaUtil.getSysCameraDirPath();
        AppMethodBeat.o(177105);
        return sysCameraDirPath;
    }

    public static String getToastSysCameraPath() {
        AppMethodBeat.i(116250);
        String toastSysCameraPath = AndroidMediaUtil.getToastSysCameraPath();
        AppMethodBeat.o(116250);
        return toastSysCameraPath;
    }

    public static boolean f(Context context, Intent intent, String str) {
        AppMethodBeat.i(116221);
        boolean g2 = g(context, intent, str);
        AppMethodBeat.o(116221);
        return g2;
    }

    private static boolean e(Activity activity, String str, String str2, int i2) {
        AppMethodBeat.i(116229);
        if (com.tencent.mm.q.a.o(activity, true) || com.tencent.mm.q.a.cA(activity) || com.tencent.mm.q.a.cE(activity)) {
            AppMethodBeat.o(116229);
            return false;
        }
        Log.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4, "MicroMsg.TakePhotoUtil")));
        filePath = com.tencent.mm.vfs.s.k(str + str2, true);
        Log.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
        cq(activity, filePath);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(str);
        if (!oVar.exists()) {
            try {
                oVar.mkdirs();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TakePhotoUtil", e2, "", new Object[0]);
            }
        }
        if (!oVar.exists()) {
            Log.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. ".concat(String.valueOf(str)));
            AppMethodBeat.o(116229);
            return false;
        }
        intent.putExtra("output", FileProviderHelper.getUriForFile(activity, new com.tencent.mm.vfs.o(filePath)));
        try {
            activity.startActivityForResult(intent, i2);
            AppMethodBeat.o(116229);
            return true;
        } catch (Exception e3) {
            Log.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + e3.getMessage());
            AppMethodBeat.o(116229);
            return false;
        }
    }
}
