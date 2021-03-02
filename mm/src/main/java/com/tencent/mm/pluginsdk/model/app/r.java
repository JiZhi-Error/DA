package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.pluginsdk.model.app.IPCInstallApp;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.permission.d;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;

public final class r {
    public static String bdM(String str) {
        AppMethodBeat.i(151780);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.toLowerCase());
        stringBuffer.append("mMHc ItnStR");
        String messageDigest = g.getMessageDigest(stringBuffer.toString().getBytes());
        AppMethodBeat.o(151780);
        return messageDigest;
    }

    private static void a(final Context context, final Intent intent, final a aVar, boolean z) {
        AppMethodBeat.i(151781);
        Log.i("MicroMsg.ApplicationUtil", "installApp");
        if (z && Build.BRAND.equals("vivo")) {
            intent.putExtra("installDir", true);
            Log.i("MicroMsg.ApplicationUtil", "is vivo, try to prevent the interception");
        }
        try {
            if (Build.VERSION.SDK_INT < 26 || context.getPackageManager().canRequestPackageInstalls()) {
                Log.i("MicroMsg.ApplicationUtil", "install directly");
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installApp", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/pluginsdk/permission/InstallApkListener;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installApp", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/pluginsdk/permission/InstallApkListener;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                if (aVar != null) {
                    aVar.hk(true);
                }
                AppMethodBeat.o(151781);
                return;
            }
            Log.i("MicroMsg.ApplicationUtil", "request install apk permission");
            b.a(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + context.getPackageName())), MMApplicationContext.getContext().getString(R.string.flp), MMApplicationContext.getContext().getString(R.string.e3p), new d() {
                /* class com.tencent.mm.pluginsdk.model.app.r.AnonymousClass1 */

                @Override // com.tencent.mm.pluginsdk.permission.d
                public final void Xq(int i2) {
                    AppMethodBeat.i(151777);
                    Log.i("MicroMsg.ApplicationUtil", "onRequestPermissionsResult, resultCode = %d", Integer.valueOf(i2));
                    if (i2 == -1) {
                        try {
                            Context context = context;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/model/app/ApplicationUtil$1", "onRequestPermissionsResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/model/app/ApplicationUtil$1", "onRequestPermissionsResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.ApplicationUtil", e2, "install app failed! %s", intent);
                        }
                        if (aVar != null) {
                            aVar.hk(true);
                            AppMethodBeat.o(151777);
                            return;
                        }
                    } else {
                        Log.e("MicroMsg.ApplicationUtil", "no get!!!");
                        Toast.makeText(MMApplicationContext.getContext(), (int) R.string.fdq, 1).show();
                        if (aVar != null) {
                            aVar.hk(false);
                        }
                    }
                    AppMethodBeat.o(151777);
                }
            });
            AppMethodBeat.o(151781);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ApplicationUtil", e2, "install app failed! %s", intent);
            if (aVar != null) {
                aVar.hk(false);
            }
        }
    }

    protected static void a(Context context, String str, a aVar, boolean z) {
        AppMethodBeat.i(151782);
        Intent intent = new Intent("android.intent.action.VIEW");
        FileProviderHelper.setIntentDataAndType(context, intent, new o(str), "application/vnd.android.package-archive", false);
        intent.addFlags(268435456);
        a(context, intent, aVar, z);
        AppMethodBeat.o(151782);
    }

    public static void b(Context context, String str, final a aVar, boolean z) {
        AppMethodBeat.i(151783);
        if (MMApplicationContext.isMainProcess()) {
            a(context, str, aVar, z);
            AppMethodBeat.o(151783);
            return;
        }
        h.a(MainProcessIPCService.dkO, new IPCInstallApp.IPCInstallAppParam(1, str, null, z), IPCInstallApp.class, new com.tencent.mm.ipcinvoker.d<IPCBoolean>() {
            /* class com.tencent.mm.pluginsdk.model.app.r.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCBoolean iPCBoolean) {
                AppMethodBeat.i(151778);
                IPCBoolean iPCBoolean2 = iPCBoolean;
                if (aVar != null) {
                    if (iPCBoolean2.value) {
                        aVar.hk(true);
                        AppMethodBeat.o(151778);
                        return;
                    }
                    aVar.hk(false);
                }
                AppMethodBeat.o(151778);
            }
        });
        AppMethodBeat.o(151783);
    }

    protected static void a(Context context, Uri uri, a aVar, boolean z) {
        AppMethodBeat.i(151784);
        Intent intent = new Intent("android.intent.action.VIEW");
        FileProviderHelper.setIntentDataAndType(context, intent, uri, "application/vnd.android.package-archive", false);
        intent.addFlags(268435456);
        a(context, intent, aVar, z);
        AppMethodBeat.o(151784);
    }

    public static void l(Context context, Uri uri) {
        AppMethodBeat.i(151785);
        if (MMApplicationContext.isMainProcess()) {
            a(context, uri, (a) null, false);
            AppMethodBeat.o(151785);
            return;
        }
        h.a(MainProcessIPCService.dkO, new IPCInstallApp.IPCInstallAppParam(2, "", uri, false), IPCInstallApp.class, new com.tencent.mm.ipcinvoker.d<IPCBoolean>() {
            /* class com.tencent.mm.pluginsdk.model.app.r.AnonymousClass3 */
            final /* synthetic */ a qJU = null;

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCBoolean iPCBoolean) {
                AppMethodBeat.i(151779);
                IPCBoolean iPCBoolean2 = iPCBoolean;
                if (this.qJU != null) {
                    if (iPCBoolean2.value) {
                        this.qJU.hk(true);
                        AppMethodBeat.o(151779);
                        return;
                    }
                    this.qJU.hk(false);
                }
                AppMethodBeat.o(151779);
            }
        });
        AppMethodBeat.o(151785);
    }

    public static boolean ck(Context context, String str) {
        AppMethodBeat.i(151786);
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.addFlags(268435456);
        if (getPackageInfo(context, "com.android.vending") != null) {
            Log.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is installed, url = %s", str);
            intent.setPackage("com.android.vending");
        } else {
            Log.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is not installed, url = %s", str);
        }
        try {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installAppWithGP", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installAppWithGP", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(151786);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.ApplicationUtil", "installAppWithGP first, ex = %s", e2.getMessage());
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", parse);
                intent2.addFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installAppWithGP", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installAppWithGP", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(151786);
                return true;
            } catch (Exception e3) {
                Log.e("MicroMsg.ApplicationUtil", "installAppWithGP second, ex = %s", e3.getMessage());
                AppMethodBeat.o(151786);
                return false;
            }
        }
    }

    public static boolean s(Context context, String str) {
        AppMethodBeat.i(151787);
        if (getPackageInfo(context, str) != null) {
            AppMethodBeat.o(151787);
            return true;
        }
        AppMethodBeat.o(151787);
        return false;
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        AppMethodBeat.i(151788);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.ApplicationUtil", "getPackageInfo, packageName is null");
            AppMethodBeat.o(151788);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.w("MicroMsg.ApplicationUtil", "app not installed, packageName = ".concat(String.valueOf(str)));
            }
            AppMethodBeat.o(151788);
        }
        return packageInfo;
    }

    public static String bdN(String str) {
        AppMethodBeat.i(151789);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(151789);
            return null;
        }
        try {
            PackageInfo packageArchiveInfo = MMApplicationContext.getContext().getPackageManager().getPackageArchiveInfo(str, 0);
            if (packageArchiveInfo == null) {
                RuntimeException runtimeException = new RuntimeException("info is null; ".concat(String.valueOf(str)));
                AppMethodBeat.o(151789);
                throw runtimeException;
            }
            Log.i("MicroMsg.ApplicationUtil", "get package name from archive filepath  :%s, package name is : %s", str, packageArchiveInfo.packageName);
            String str2 = packageArchiveInfo.packageName;
            AppMethodBeat.o(151789);
            return str2;
        } catch (Exception e2) {
            Log.e("MicroMsg.ApplicationUtil", "get package name from archive file path, failed : %s", e2.getMessage());
            AppMethodBeat.o(151789);
            return null;
        }
    }

    public static int bdO(String str) {
        AppMethodBeat.i(151790);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(151790);
            return 0;
        }
        try {
            PackageInfo packageArchiveInfo = MMApplicationContext.getContext().getPackageManager().getPackageArchiveInfo(str, 0);
            if (packageArchiveInfo == null) {
                RuntimeException runtimeException = new RuntimeException("info is null; ".concat(String.valueOf(str)));
                AppMethodBeat.o(151790);
                throw runtimeException;
            }
            Log.i("MicroMsg.ApplicationUtil", "get package version code from archive filepath  :%s, package version code is : %d", str, Integer.valueOf(packageArchiveInfo.versionCode));
            int i2 = packageArchiveInfo.versionCode;
            AppMethodBeat.o(151790);
            return i2;
        } catch (Exception e2) {
            Log.e("MicroMsg.ApplicationUtil", "get package version code from archive file path, failed : %s", e2.getMessage());
            AppMethodBeat.o(151790);
            return 0;
        }
    }
}
