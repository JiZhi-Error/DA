package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.cr.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.xweb.f;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class a {
    private static Intent Ksv;
    private static WeakReference<Activity> Ksw;
    public static HashMap<String, String> Ksx = new HashMap<>();
    public static HashMap<String, String> Ksy;

    public static boolean mE(String str, String str2) {
        AppMethodBeat.i(204763);
        Context context = MMApplicationContext.getContext();
        o oVar = new o(str);
        Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - path:%s, isExisted:%b, size:%d fileExt: %s", str, Boolean.valueOf(oVar.exists()), Long.valueOf(oVar.length()), str2);
        if (!oVar.exists()) {
            Log.e("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - Cannot open file not existed!");
            AppMethodBeat.o(204763);
            return false;
        }
        String bfm = bfm(str2);
        String bfj = bfj(bfm);
        if (bfj.equals("com.baidu.searchbox")) {
            bfk(bfm);
            bfj = "";
        }
        if (!bfj.equals("")) {
            Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - User exist always config, package is %s", bfj);
            if (TbsConfig.APP_QB.equals(bfj)) {
                Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - open file by qb(default)");
                AppMethodBeat.o(204763);
                return false;
            }
            Intent S = S(context, bfm, str);
            S.setPackage(bfj);
            if (Util.isIntentAvailable(context, S)) {
                Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - Always package support mimeType %s", bfm);
                AppMethodBeat.o(204763);
                return true;
            }
            Log.i("MicroMsg.AppChooserIntentUtil", "ifHasDefaultThirdAppAndCanOpenIt - Always package do not support mimeType %s", bfm);
            AppMethodBeat.o(204763);
            return false;
        }
        AppMethodBeat.o(204763);
        return false;
    }

    public static boolean a(String str, String str2, int i2, ach ach) {
        AppMethodBeat.i(204764);
        boolean a2 = a(str, str2, "", i2, ach);
        AppMethodBeat.o(204764);
        return a2;
    }

    public static boolean ao(String str, String str2, int i2) {
        AppMethodBeat.i(109485);
        boolean a2 = a(str, str2, "", i2, (ach) null);
        AppMethodBeat.o(109485);
        return a2;
    }

    public static boolean bl(String str, String str2, String str3) {
        AppMethodBeat.i(204765);
        boolean a2 = a(str, str2, str3, 2, (ach) null);
        AppMethodBeat.o(204765);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, com.tencent.mm.protocal.protobuf.ach r19) {
        /*
        // Method dump skipped, instructions count: 495
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.tools.a.a(java.lang.String, java.lang.String, java.lang.String, int, com.tencent.mm.protocal.protobuf.ach):boolean");
    }

    private static boolean a(String str, String str2, String str3, String str4, int i2, ach ach) {
        AppMethodBeat.i(204767);
        boolean a2 = a(str, str2, str3, str4, i2, false, ach);
        AppMethodBeat.o(204767);
        return a2;
    }

    private static boolean b(String str, String str2, String str3, String str4, int i2) {
        AppMethodBeat.i(204768);
        boolean a2 = a(str, str2, str3, str4, i2, true, (ach) null);
        AppMethodBeat.o(204768);
        return a2;
    }

    private static boolean a(String str, String str2, String str3, String str4, int i2, boolean z, ach ach) {
        HandOffFile handOffFile;
        AppMethodBeat.i(204769);
        Context context = MMApplicationContext.getContext();
        d.kT(MMApplicationContext.getContext());
        if (f.a(str2, f.a.NONE, false, new Intent()) != f.a.XWEB || z) {
            if (((b) g.af(b.class)).a(b.a.clicfg_qb_document_action_flag, true)) {
                h gsv = h.gsv();
                String str5 = gsv.mFilePath;
                String str6 = gsv.nhr;
                String str7 = gsv.mFileName;
                int i3 = gsv.qpr;
                StringBuilder sb = new StringBuilder();
                sb.append(cl.aWy());
                String bhK = s.bhK(str);
                if (!Util.isNullOrNil(bhK)) {
                    sb.append("_");
                    sb.append(bhK);
                }
                String sb2 = sb.toString();
                if (gsv.Abp != null) {
                    handOffFile = HandOffFile.fromMultiTask(gsv.Abp);
                } else {
                    handOffFile = null;
                }
                Intent a2 = a(context, str, str2, str3, sb2, i2, ach);
                if (Util.isIntentAvailable(context, a2)) {
                    String str8 = (String) g.aAh().azQ().get(ar.a.USERINFO_FLOAT_BALL_FILES_QB_VERIFY_FILE_PATH_STRING_SYNC, "");
                    if (Util.isNullOrNil(str8) || !Util.isEqual(str5, str8)) {
                        g.aAh().azQ().set(ar.a.USERINFO_FLOAT_BALL_FILES_QB_VERIFY_FILE_PATH_STRING_SYNC, str5);
                        g.aAh().azQ().set(ar.a.USERINFO_FLOAT_BALL_FILES_QB_VERIFY_STRING_SYNC, sb2);
                    } else {
                        String str9 = (String) g.aAh().azQ().get(ar.a.USERINFO_FLOAT_BALL_FILES_QB_VERIFY_STRING_SYNC, "");
                        StringBuilder sb3 = new StringBuilder();
                        if (Util.isNullOrNil(str9)) {
                            sb3.append(sb2);
                        } else {
                            sb3.append(str9).append(",").append(sb2);
                        }
                        g.aAh().azQ().set(ar.a.USERINFO_FLOAT_BALL_FILES_QB_VERIFY_STRING_SYNC, sb3.toString());
                    }
                    g.aAh().azQ().set(ar.a.USERINFO_FLOAT_BALL_FILES_QB_VERIFY_USE_FREQUENCY_INT_SYNC, (Object) 0);
                    f.nX(com.tencent.mm.cr.a.bpF(str), str2);
                    f.nY(str2, "QQBROWSER");
                    try {
                        Context context2 = MMApplicationContext.getContext();
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(a2);
                        com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context2.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        h.INSTANCE.a(11168, 5, Integer.valueOf(i2));
                        MultiTaskInfo multiTaskInfo = gsv.Abp;
                        HandOff handOff = null;
                        if (multiTaskInfo != null) {
                            handOff = ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).aBx(multiTaskInfo.field_id);
                        }
                        if (handOff == null) {
                            handOff = ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYm();
                        }
                        if (handOff instanceof HandOffFile) {
                            handOff.setHandOffType(1);
                            handOff.setKey(HandOff.generateKey(1, 1));
                            ((HandOffFile) handOff).saveToMultiTaskInfo(gsv.Abp);
                            ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).j(handOff);
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.AppChooserIntentUtil", "startByQb() (by QQBrowserDocumentIntent) Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                    }
                    AppMethodBeat.o(204769);
                    return false;
                }
                h gsv2 = h.gsv();
                gsv2.b(str5, str6, str7, i3, ach);
                if (handOffFile != null) {
                    handOffFile.saveToMultiTaskInfo(gsv2.Abp);
                }
            }
            Intent T = T(context, str4, str);
            if (Util.isIntentAvailable(context, T)) {
                f.nX(com.tencent.mm.cr.a.bpF(str), str2);
                f.nY(str2, "QQBROWSER");
                try {
                    Context context3 = MMApplicationContext.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(T);
                    com.tencent.mm.hellhoundlib.a.a.a(context3, bl2.axQ(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context3.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context3, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startByQb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    h.INSTANCE.a(11168, 5, Integer.valueOf(i2));
                    AppMethodBeat.o(204769);
                    return false;
                } catch (Exception e3) {
                    Log.e("MicroMsg.AppChooserIntentUtil", "startByQb() (by QQBrowserIntent) Exception:%s %s", e3.getClass().getSimpleName(), e3.getMessage());
                }
            }
        }
        AppMethodBeat.o(204769);
        return true;
    }

    public static void b(Activity activity, String str, String str2, int i2) {
        AppMethodBeat.i(109488);
        a(activity, str, str2, "", i2);
        AppMethodBeat.o(109488);
    }

    public static void a(Activity activity, String str, String str2, String str3, int i2) {
        AppMethodBeat.i(109489);
        a(activity, str, str2, str3, i2, (ach) null);
        AppMethodBeat.o(109489);
    }

    public static void a(Activity activity, String str, String str2, String str3, int i2, ach ach) {
        AppMethodBeat.i(204770);
        o oVar = new o(str);
        Log.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", str, Boolean.valueOf(oVar.exists()), Long.valueOf(oVar.length()));
        if (!oVar.exists()) {
            Log.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
            AppMethodBeat.o(204770);
            return;
        }
        Context context = MMApplicationContext.getContext();
        String bfm = bfm(str2);
        String bfj = bfj(bfm);
        if (bfj.equals("com.baidu.searchbox")) {
            bfk(bfm);
            bfj = "";
        }
        if (!bfj.equals("")) {
            Log.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", bfj);
            if (!TbsConfig.APP_QB.equals(bfj) || b(str, str2, str3, bfm, i2)) {
                Intent S = S(MMApplicationContext.getContext(), bfm, str);
                S.setPackage(bfj);
                if (ach != null) {
                    try {
                        S.putExtra("key_multi_task_common_info", ach.toByteArray());
                    } catch (Exception e2) {
                        Log.e("MicroMsg.AppChooserIntentUtil", "invoke startAppChooserWhenOnCreate Exception! Error:%s", e2.getMessage());
                    }
                }
                if (Util.isIntentAvailable(context, S)) {
                    Log.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType %s", bfm);
                    f.nX(com.tencent.mm.cr.a.bpF(str), str2);
                    f.nY(str2, "THIRDAPP");
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(S);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooser", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "startAppChooser", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(204770);
                    return;
                }
                Log.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType %s", bfm);
            } else {
                Log.i("MicroMsg.AppChooserIntentUtil", "open file by qb(default)");
                AppMethodBeat.o(204770);
                return;
            }
        }
        if (!a(str, str2, str3, bfm, i2, ach)) {
            Log.i("MicroMsg.AppChooserIntentUtil", "open file by qb");
            AppMethodBeat.o(204770);
            return;
        }
        a(activity, str, str2, str3, S(context, bfm, str), i2, !r.io(MMApplicationContext.getContext()));
        AppMethodBeat.o(204770);
    }

    public static boolean c(Activity activity, String str, String str2, int i2) {
        AppMethodBeat.i(109490);
        String bfm = bfm(str2);
        Uri uriForFile = FileProviderHelper.getUriForFile(activity, new o(str));
        Bundle bundle = new Bundle();
        Intent S = S(activity, bfm, str);
        bundle.putString("targeturl", uriForFile.toString());
        bundle.putString("filepath", str);
        bundle.putString("fileext", str2);
        bundle.putParcelable("targetintent", S);
        Intent intent = new Intent(activity, AppChooserUI.class);
        intent.putExtra("type", 0);
        intent.putExtra("title", activity.getResources().getString(R.string.b3m));
        intent.putExtra("mimetype", bfm);
        intent.putExtra("targetintent", S);
        intent.putExtra("transferback", bundle);
        intent.putExtra("scene", i2);
        intent.putExtra("openWay", true);
        activity.startActivityForResult(intent, 2);
        AppMethodBeat.o(109490);
        return true;
    }

    public static void b(final MMActivity mMActivity, String str, String str2) {
        AppMethodBeat.i(109491);
        String bfm = bfm(str2);
        bfk(bfm);
        Uri uriForFile = FileProviderHelper.getUriForFile(mMActivity, new o(str));
        Bundle bundle = new Bundle();
        Intent S = S(mMActivity, bfm, str);
        bundle.putString("targeturl", uriForFile.toString());
        bundle.putString("filepath", str);
        bundle.putString("fileext", str2);
        bundle.putParcelable("targetintent", S);
        Intent intent = new Intent();
        intent.putExtra("type", 0);
        intent.putExtra("title", mMActivity.getResources().getString(R.string.b3m));
        intent.putExtra("mimetype", bfm);
        intent.putExtra("targetintent", S);
        intent.putExtra("transferback", bundle);
        intent.putExtra("scene", 8);
        intent.putExtra("openWay", true);
        c.a(mMActivity, ".pluginsdk.ui.tools.AppChooserUI", intent, 2, new MMActivity.a() {
            /* class com.tencent.mm.pluginsdk.ui.tools.a.AnonymousClass1 */
            final /* synthetic */ int gsA = 8;

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(109484);
                a.a((Activity) mMActivity, i2, i3, intent, true, (int) R.string.bny, (int) R.string.bnz, this.gsA);
                AppMethodBeat.o(109484);
            }
        });
        AppMethodBeat.o(109491);
    }

    private static void a(Activity activity, String str, String str2, String str3, Intent intent, int i2, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(109492);
        String bfm = bfm(str2);
        Uri uriForFile = FileProviderHelper.getUriForFile(activity, new o(str));
        Bundle bundle = new Bundle();
        if (uriForFile != null) {
            bundle.putString("targeturl", uriForFile.toString());
        }
        bundle.putString("filepath", str);
        bundle.putString("fileext", str2);
        bundle.putParcelable("targetintent", intent);
        Intent intent2 = new Intent();
        intent2.putExtra("type", 0);
        intent2.putExtra("title", activity.getResources().getString(R.string.b3m));
        intent2.putExtra("needupate", false);
        if (!z) {
            z2 = true;
        }
        intent2.putExtra("not_show_recommend_app", z2);
        intent2.putExtra("mimetype", bfm);
        intent2.putExtra("targetintent", intent);
        intent2.putExtra("transferback", bundle);
        intent2.putExtra("scene", i2);
        if (i2 == 7) {
            ((com.tencent.mm.choosemsgfile.compat.a) g.af(com.tencent.mm.choosemsgfile.compat.a.class)).g(activity, str, str2);
        } else {
            a((Context) activity, str, str2, str3, i2, (ach) null);
        }
        Ksv = intent2;
        Ksw = new WeakReference<>(activity);
        AppMethodBeat.o(109492);
    }

    private static void a(Context context, String str, String str2, String str3, int i2, ach ach) {
        AppMethodBeat.i(204771);
        Intent intent = new Intent();
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        intent.putExtra("file_name", str3);
        intent.putExtra("sence", i2);
        if (ach != null) {
            try {
                intent.putExtra("key_multi_task_common_info", ach.toByteArray());
            } catch (Exception e2) {
                Log.e("MicroMsg.AppChooserIntentUtil", "invoke openByMiniQB Exception! Error:%s", e2.getMessage());
            }
        }
        intent.addFlags(268435456);
        intent.setComponent(new ComponentName(e.n.Ozn, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
        context.sendBroadcast(intent);
        AppMethodBeat.o(204771);
    }

    public static void bq(Intent intent) {
        AppMethodBeat.i(109494);
        try {
            boolean booleanExtra = intent.getBooleanExtra("MINIQB_OPEN_RET_VAL", false);
            intent.getStringExtra("file_path");
            String stringExtra = intent.getStringExtra("file_ext");
            Log.i("MicroMsg.AppChooserIntentUtil", "miniQB retVal:%b", Boolean.valueOf(booleanExtra));
            if (!g.aAc()) {
                AppMethodBeat.o(109494);
                return;
            }
            String str = (String) g.aAh().azQ().get(ar.a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, "");
            if (!booleanExtra) {
                str = str.replace(stringExtra, "");
            } else if (!str.contains(stringExtra)) {
                str = str.concat(stringExtra);
            }
            g.aAh().azQ().set(ar.a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, str);
            if (!(booleanExtra || Ksv == null || Ksw == null || Ksw.get() == null)) {
                Ksv.setClass(Ksw.get(), AppChooserUI.class);
                Ksw.get().startActivityForResult(Ksv, 2);
            }
            Ksv = null;
            AppMethodBeat.o(109494);
        } catch (Exception e2) {
            AppMethodBeat.o(109494);
        }
    }

    public static void a(Activity activity, int i2, int i3, Intent intent, boolean z, int i4, int i5, int i6) {
        AppMethodBeat.i(109496);
        if (i2 == 2) {
            if (-1 == i3 && intent != null) {
                String stringExtra = intent.getStringExtra("selectpkg");
                Intent intent2 = (Intent) intent.getBundleExtra("transferback").getParcelable("targetintent");
                if (intent2 != null) {
                    Log.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI select package name %s and target intent is not null", stringExtra);
                    Intent intent3 = new Intent(intent2);
                    intent3.setPackage(stringExtra);
                    if (Util.isIntentAvailable(activity, intent3)) {
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "handlerResultOfAppChooserUI", "(Landroid/app/Activity;IILandroid/content/Intent;ZIII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        activity.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/pluginsdk/ui/tools/AppChooserIntentUtil", "handlerResultOfAppChooserUI", "(Landroid/app/Activity;IILandroid/content/Intent;ZIII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        if (TbsConfig.APP_QB.equals(stringExtra)) {
                            h.INSTANCE.a(11168, 5, Integer.valueOf(i6));
                            AppMethodBeat.o(109496);
                            return;
                        }
                    } else {
                        Log.e("MicroMsg.AppChooserIntentUtil", "Always Intent is not support mimetype");
                        if (z) {
                            a(activity, intent, i4, i5);
                        }
                    }
                    AppMethodBeat.o(109496);
                    return;
                }
                Log.e("MicroMsg.AppChooserIntentUtil", "AppChooserUI target intent is null in handlerResultOfAppChooserUI");
                if (z) {
                    a(activity, intent, i4, i5);
                }
                AppMethodBeat.o(109496);
                return;
            } else if (4098 == i3) {
                Log.e("MicroMsg.AppChooserIntentUtil", "Not Found App Support media type");
                if (z) {
                    a(activity, intent, i4, i5);
                    AppMethodBeat.o(109496);
                    return;
                }
            } else if (4097 == i3) {
                Log.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is no choice");
                if (z) {
                    a(activity, intent, i4, i5);
                    AppMethodBeat.o(109496);
                    return;
                }
            } else {
                Log.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is not ok or data is null");
            }
        }
        AppMethodBeat.o(109496);
    }

    private static void a(final Activity activity, Intent intent, int i2, int i3) {
        AppMethodBeat.i(184245);
        if (intent != null) {
            intent.getStringExtra("mimetype");
        }
        if (!Ksy.containsKey("")) {
            com.tencent.mm.ui.base.h.n(activity, i2, i3);
            AppMethodBeat.o(184245);
        } else if (!NetStatusUtil.isWifi(activity)) {
            f.a aVar = new f.a(MMApplicationContext.getContext());
            aVar.bow(activity.getString(R.string.hld)).Dq(true).apa(R.string.dgd);
            aVar.c(new f.c() {
                /* class com.tencent.mm.pluginsdk.ui.tools.a.AnonymousClass3 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                    AppMethodBeat.i(184243);
                    if (z) {
                        f.a bow = new f.a(activity).bow(activity.getString(R.string.hle));
                        bow.JnN = true;
                        bow.apa(R.string.w0).b(new f.c() {
                            /* class com.tencent.mm.pluginsdk.ui.tools.a.AnonymousClass3.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.widget.a.f.c
                            public final void e(boolean z, String str) {
                                AppMethodBeat.i(184242);
                                x.a.zK(true);
                                AppMethodBeat.o(184242);
                            }
                        }).show();
                    }
                    AppMethodBeat.o(184243);
                }
            }).b(new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.pluginsdk.ui.tools.a.AnonymousClass2 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(184241);
                    as.d("dancy", "OnDismissListener ", new Object[0]);
                    AppMethodBeat.o(184241);
                }
            }).show();
            AppMethodBeat.o(184245);
        } else {
            f.a bow = new f.a(activity).bow(activity.getString(R.string.hlf));
            bow.JnN = true;
            bow.apa(R.string.w0).b(new f.c() {
                /* class com.tencent.mm.pluginsdk.ui.tools.a.AnonymousClass4 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                    AppMethodBeat.i(184244);
                    x.a.zK(true);
                    AppMethodBeat.o(184244);
                }
            }).show();
            AppMethodBeat.o(184245);
        }
    }

    private static Intent S(Context context, String str, String str2) {
        AppMethodBeat.i(109497);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(268435456);
        FileProviderHelper.setIntentDataAndType(context, intent, new o(str2), str, false);
        try {
            Log.i("MicroMsg.AppChooserIntentUtil", "createNormalIntent %s %s %s", str, str2, intent.toString());
        } catch (Exception e2) {
        }
        AppMethodBeat.o(109497);
        return intent;
    }

    private static Intent T(Context context, String str, String str2) {
        AppMethodBeat.i(109498);
        Intent intent = new Intent();
        intent.setPackage(TbsConfig.APP_QB);
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        FileProviderHelper.setIntentDataAndType(context, intent, new o(str2), str, false);
        try {
            Log.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserIntent %s %s %s", str, str2, intent.toString());
        } catch (Exception e2) {
        }
        AppMethodBeat.o(109498);
        return intent;
    }

    private static Intent a(Context context, String str, String str2, String str3, String str4, int i2, ach ach) {
        AppMethodBeat.i(204772);
        Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
        intent.setPackage(TbsConfig.APP_QB);
        intent.addFlags(268435456);
        intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
        intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 4);
        intent.putExtra("key_reader_sdk_id", 1);
        intent.putExtra("key_reader_sdk_type", 0);
        intent.putExtra("key_reader_sdk_format", str2);
        intent.putExtra("key_reader_sdk_path", str);
        a(intent, context, str, str2, str3, str4, i2, ach);
        String str5 = Ksy.get(str2);
        if (Util.isNullOrNil(str5)) {
            str5 = bfm(str2);
        }
        FileProviderHelper.setIntentDataAndType(context, intent, new o(str), str5, false);
        try {
            Log.i("MicroMsg.AppChooserIntentUtil", "createQQBrowserDocumentIntent %s %s %s %s %s %s", str5, str, intent.toString(), intent.getExtras(), str2, Integer.valueOf(i2));
        } catch (Exception e2) {
        }
        AppMethodBeat.o(204772);
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0311  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.Intent a(android.content.Intent r10, android.content.Context r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, int r16, com.tencent.mm.protocal.protobuf.ach r17) {
        /*
        // Method dump skipped, instructions count: 788
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.tools.a.a(android.content.Intent, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.tencent.mm.protocal.protobuf.ach):android.content.Intent");
    }

    private static boolean iA(Context context) {
        AppMethodBeat.i(109501);
        try {
            context.getPackageManager().getReceiverInfo(new ComponentName(TbsConfig.APP_QB, "com.tencent.mtt.external.reader.ReaderSdkReceive"), 131072);
            Log.i("MicroMsg.AppChooserIntentUtil", "ifSupportFloatBallInQb() true");
            AppMethodBeat.o(109501);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.i("MicroMsg.AppChooserIntentUtil", "ifSupportFloatBallInQb() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(109501);
            return false;
        }
    }

    private static String bfj(String str) {
        AppMethodBeat.i(109502);
        String str2 = (String) g.aAh().azQ().get(bfl(str), "");
        AppMethodBeat.o(109502);
        return str2;
    }

    private static void bfk(String str) {
        AppMethodBeat.i(109503);
        if (!g.aAc()) {
            AppMethodBeat.o(109503);
            return;
        }
        g.aAh().azQ().set(bfl(str), "");
        AppMethodBeat.o(109503);
    }

    private static int bfl(String str) {
        AppMethodBeat.i(109504);
        if (str != null) {
            int hashCode = 274528 + str.hashCode();
            AppMethodBeat.o(109504);
            return hashCode;
        }
        AppMethodBeat.o(109504);
        return 274528;
    }

    private static String bfm(String str) {
        String mimeTypeFromExtension;
        AppMethodBeat.i(109505);
        if (Util.isNullOrNil(str)) {
            mimeTypeFromExtension = "application/octet-stream";
        } else {
            mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
            if (Util.isNullOrNil(mimeTypeFromExtension)) {
                mimeTypeFromExtension = Ksx.get(str);
            }
            if (Util.isNullOrNil(mimeTypeFromExtension)) {
                if (str.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                    mimeTypeFromExtension = "application/octet-stream";
                } else {
                    mimeTypeFromExtension = "application/".concat(String.valueOf(str));
                }
            }
        }
        Log.i("MicroMsg.AppChooserIntentUtil", "getMimeTypeByExt fileExt: %s mimeType: %s", str, mimeTypeFromExtension);
        AppMethodBeat.o(109505);
        return mimeTypeFromExtension;
    }

    static {
        AppMethodBeat.i(109506);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String[] split = s.boY("assets:///mimetype.txt").split("\n");
            for (String str : split) {
                String[] split2 = str.split(",");
                if (split2 == null || split2.length <= 1 || Util.isNullOrNil(split2[0]) || Util.isNullOrNil(split2[1])) {
                    Log.i("MicroMsg.AppChooserIntentUtil", "mimeType %s", str);
                } else {
                    Ksx.put(split2[0].trim(), split2[1].trim());
                }
            }
            Log.i("MicroMsg.AppChooserIntentUtil", "read from mimetype text %d %d %d", Integer.valueOf(split.length), Integer.valueOf(Ksx.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.AppChooserIntentUtil", e2, "read mimeType from asset", new Object[0]);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        Ksy = hashMap;
        hashMap.put("txt", "mtt/txt");
        Ksy.put("epub", "mtt/epub");
        Ksy.put("pdf", "mtt/pdf");
        Ksy.put("doc", "mtt/doc");
        Ksy.put("xls", "mtt/xls");
        Ksy.put("ppt", "mtt/ppt");
        Ksy.put("docx", "mtt/docx");
        Ksy.put("xlsx", "mtt/xlsx");
        Ksy.put("pptx", "mtt/pptx");
        Ksy.put("chm", "mtt/chm");
        Ksy.put("ini", "mtt/ini");
        Ksy.put("log", "mtt/log");
        Ksy.put("bat", "mtt/bat");
        Ksy.put("php", "mtt/php");
        Ksy.put("lrc", "mtt/lrc");
        Ksy.put("js", "mtt/js");
        AppMethodBeat.o(109506);
    }
}
