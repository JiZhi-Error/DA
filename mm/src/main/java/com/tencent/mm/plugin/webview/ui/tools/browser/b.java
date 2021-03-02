package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010H\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0007J$\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J\"\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0007J\"\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0003J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0007J\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0007J\u001a\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J&\u0010%\u001a\u00020&2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0007J\u0010\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseDialogHelper;", "", "()V", "BUNDLE_KEY_TARGET_INTENT", "", "BUNDLE_KEY_TARGET_URL", "TAG", "qqBrowserHelper", "Lcom/tencent/mm/pluginsdk/model/QQBrowserHelper;", "createBrowserChooser", "Landroid/content/Intent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "target", "url", "filterBrowserList", "", "Landroid/content/pm/ResolveInfo;", "resolveList", "getAppDisplayName", "context", "Landroid/content/Context;", "resolveInfo", "getBrowserInfo", AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "getBrowserList", "getBrowserListInternal", "isQQBrowser", "", "isSystemApplication", "loadIconForResolveInfo", "Landroid/graphics/drawable/Drawable;", "loadIconFromResourceId", ShareConstants.RES_PATH, "Landroid/content/res/Resources;", "resId", "", "openInBrowser", "", "tryFixIntentData", "intent", "BrowserSettingResult", "plugin-webview_release"})
public final class b {
    public static final b JlA = new b();
    private static r Jlz;

    static {
        AppMethodBeat.i(210415);
        AppMethodBeat.o(210415);
    }

    private b() {
    }

    public static final Intent a(Activity activity, Intent intent, String str) {
        AppMethodBeat.i(210407);
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        Log.v("MicroMsg.BrowserChooseDialogHelper", "alvinluo createBrowserChooser activity: %s, url: %s", activity, str);
        Bundle bundle = new Bundle();
        bundle.putString("target_url", str);
        bundle.putParcelable("target_intent", intent);
        intent.putExtra("targeturl", str);
        Intent intent2 = new Intent();
        intent2.setClass(activity, BrowserChooseUI.class);
        intent2.putExtra("scene", 4);
        intent2.putExtra("targetintent", intent);
        intent2.putExtra("transferback", bundle);
        AppMethodBeat.o(210407);
        return intent2;
    }

    public static final List<ResolveInfo> as(Context context, Intent intent) {
        boolean z;
        ArrayList queryIntentActivities;
        AppMethodBeat.i(210408);
        p.h(context, "context");
        if (intent == null) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(210408);
            return arrayList;
        }
        intent.addCategory("android.intent.category.BROWSABLE");
        Uri data = intent.getData();
        String uri = data != null ? data.toString() : null;
        String str = uri;
        if (str == null || str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z && (n.J(uri, "https://view.inews.qq.com", false) || n.J(uri, "http://view.inews.qq.com", false))) {
            Intent intent2 = new Intent(intent);
            intent2.setData(Uri.parse("https://mp.weixin.qq.com"));
            intent = intent2;
        }
        PackageManager packageManager = context.getPackageManager();
        if (Build.VERSION.SDK_INT >= 23) {
            queryIntentActivities = packageManager != null ? packageManager.queryIntentActivities(intent, 131072) : null;
        } else {
            queryIntentActivities = packageManager != null ? packageManager.queryIntentActivities(intent, 65536) : null;
        }
        if (queryIntentActivities == null) {
            queryIntentActivities = new ArrayList();
        }
        List<ResolveInfo> il = il(queryIntentActivities);
        AppMethodBeat.o(210408);
        return il;
    }

    public static final ResolveInfo N(Context context, String str, String str2) {
        List<ResolveInfo> queryIntentActivities;
        AppMethodBeat.i(210409);
        p.h(context, "context");
        p.h(str, AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        if (str.length() == 0) {
            AppMethodBeat.o(210409);
            return null;
        }
        d dVar = d.JlK;
        if (d.ggu()) {
            d dVar2 = d.JlK;
            if (d.baB(str)) {
                AppMethodBeat.o(210409);
                return null;
            }
        }
        if (str2 == null) {
            str2 = "";
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
        intent.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || (queryIntentActivities = packageManager.queryIntentActivities(intent, 65536)) == null) {
            AppMethodBeat.o(210409);
            return null;
        }
        ResolveInfo resolveInfo = (ResolveInfo) j.L(queryIntentActivities, 0);
        AppMethodBeat.o(210409);
        return resolveInfo;
    }

    private static List<ResolveInfo> il(List<? extends ResolveInfo> list) {
        int i2;
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        ActivityInfo activityInfo;
        ApplicationInfo applicationInfo;
        ActivityInfo activityInfo2;
        Integer num = null;
        AppMethodBeat.i(210410);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                T next = it.next();
                Object[] objArr = new Object[1];
                objArr[0] = (next == null || (activityInfo2 = ((ResolveInfo) next).activityInfo) == null) ? null : activityInfo2.packageName;
                Log.v("MicroMsg.BrowserChooseDialogHelper", "alvinluo filterBrowserList packageName: %s", objArr);
                if (next != null) {
                    if (next == null || (activityInfo = ((ResolveInfo) next).activityInfo) == null || (applicationInfo = activityInfo.applicationInfo) == null) {
                        i2 = 0;
                    } else {
                        i2 = applicationInfo.flags;
                    }
                    if ((i2 & 1) > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        Object[] objArr2 = new Object[1];
                        ActivityInfo activityInfo3 = ((ResolveInfo) next).activityInfo;
                        objArr2[0] = activityInfo3 != null ? activityInfo3.packageName : null;
                        Log.i("MicroMsg.BrowserChooseDialogHelper", "alvinluo filterBrowserList package: %s is system application", objArr2);
                        arrayList3.add(next);
                    } else {
                        d dVar = d.JlK;
                        ActivityInfo activityInfo4 = ((ResolveInfo) next).activityInfo;
                        if (d.baA(activityInfo4 != null ? activityInfo4.packageName : null)) {
                            ActivityInfo activityInfo5 = ((ResolveInfo) next).activityInfo;
                            if (activityInfo5 != null) {
                                str3 = activityInfo5.packageName;
                            } else {
                                str3 = null;
                            }
                            if (Jlz == null) {
                                Jlz = new r();
                            }
                            r rVar = Jlz;
                            if (rVar == null) {
                                p.hyc();
                            }
                            if (str3 == null) {
                                str4 = null;
                            } else if (str3 == null) {
                                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                                AppMethodBeat.o(210410);
                                throw tVar;
                            } else {
                                str4 = str3.toLowerCase();
                                p.g(str4, "(this as java.lang.String).toLowerCase()");
                            }
                            if (rVar.bdn(str4)) {
                                arrayList4.add(next);
                            } else {
                                arrayList2.add(next);
                            }
                        } else {
                            d dVar2 = d.JlK;
                            if (d.ggu()) {
                                d dVar3 = d.JlK;
                                ActivityInfo activityInfo6 = ((ResolveInfo) next).activityInfo;
                                if (activityInfo6 != null) {
                                    str = activityInfo6.packageName;
                                } else {
                                    str = null;
                                }
                                if (d.baB(str)) {
                                    Object[] objArr3 = new Object[1];
                                    ActivityInfo activityInfo7 = ((ResolveInfo) next).activityInfo;
                                    if (activityInfo7 != null) {
                                        str2 = activityInfo7.packageName;
                                    } else {
                                        str2 = null;
                                    }
                                    objArr3[0] = str2;
                                    Log.i("MicroMsg.BrowserChooseDialogHelper", "alvinluo filterBrowserList package: %s is in block list", objArr3);
                                }
                            }
                            arrayList.add(next);
                        }
                    }
                }
            }
        }
        arrayList.addAll(0, arrayList3);
        arrayList.addAll(arrayList3.size(), arrayList4);
        arrayList.addAll(arrayList4.size() + arrayList3.size(), arrayList2);
        Object[] objArr4 = new Object[5];
        if (list != null) {
            num = Integer.valueOf(list.size());
        }
        objArr4[0] = num;
        objArr4[1] = Integer.valueOf(arrayList.size());
        objArr4[2] = Integer.valueOf(arrayList3.size());
        objArr4[3] = Integer.valueOf(arrayList4.size());
        objArr4[4] = Integer.valueOf(arrayList2.size());
        Log.i("MicroMsg.BrowserChooseDialogHelper", "alvinluo filterBrowserList resolveList: %s, finalList: %s, systemBrowserCount: %d, qqBrowserList: %s, filteredAllowList: %s", objArr4);
        ArrayList arrayList5 = arrayList;
        AppMethodBeat.o(210410);
        return arrayList5;
    }

    public static final Drawable a(Context context, ResolveInfo resolveInfo) {
        String str = null;
        AppMethodBeat.i(210411);
        p.h(context, "context");
        if (resolveInfo == null) {
            AppMethodBeat.o(210411);
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            AppMethodBeat.o(210411);
            return null;
        }
        try {
            if (!(resolveInfo.resolvePackageName == null || resolveInfo.icon == 0)) {
                Resources resourcesForApplication = packageManager.getResourcesForApplication(resolveInfo.resolvePackageName);
                p.g(resourcesForApplication, "packageManager.getResour…eInfo.resolvePackageName)");
                Drawable d2 = d(resourcesForApplication, resolveInfo.icon);
                if (d2 != null) {
                    AppMethodBeat.o(210411);
                    return d2;
                }
            }
            int iconResource = resolveInfo.getIconResource();
            if (iconResource != 0) {
                Resources resourcesForApplication2 = packageManager.getResourcesForApplication(resolveInfo.activityInfo.packageName);
                p.g(resourcesForApplication2, "packageManager.getResour…activityInfo.packageName)");
                Drawable d3 = d(resourcesForApplication2, iconResource);
                if (d3 != null) {
                    Object[] objArr = new Object[2];
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null) {
                        str = activityInfo.packageName;
                    }
                    objArr[0] = str;
                    objArr[1] = Integer.valueOf(iconResource);
                    Log.d("MicroMsg.BrowserChooseDialogHelper", "loadIconForResolveInfo %s, iconRes %d done", objArr);
                    AppMethodBeat.o(210411);
                    return d3;
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.BrowserChooseDialogHelper", "Couldn't find resources for package", e2);
        }
        Drawable loadIcon = resolveInfo.loadIcon(packageManager);
        AppMethodBeat.o(210411);
        return loadIcon;
    }

    private static Drawable d(Resources resources, int i2) {
        Drawable drawable;
        AppMethodBeat.i(210412);
        try {
            drawable = com.tencent.mm.cc.b.f(resources, i2);
        } catch (Resources.NotFoundException e2) {
            drawable = null;
        }
        AppMethodBeat.o(210412);
        return drawable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0060, code lost:
        if (r0 == null) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String b(android.content.Context r4, android.content.pm.ResolveInfo r5) {
        /*
        // Method dump skipped, instructions count: 133
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.browser.b.b(android.content.Context, android.content.pm.ResolveInfo):java.lang.String");
    }

    public static final void a(Context context, Intent intent, ResolveInfo resolveInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        ActivityInfo activityInfo;
        ActivityInfo activityInfo2;
        Uri data;
        ActivityInfo activityInfo3;
        AppMethodBeat.i(210414);
        if (intent != null) {
            try {
                str = intent.getStringExtra("targeturl");
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.BrowserChooseDialogHelper", e2, "onBrowserItemClick exception", new Object[0]);
                AppMethodBeat.o(210414);
                return;
            }
        } else {
            str = null;
        }
        Object[] objArr = new Object[3];
        if (resolveInfo == null || (activityInfo3 = resolveInfo.activityInfo) == null) {
            str2 = null;
        } else {
            str2 = activityInfo3.packageName;
        }
        objArr[0] = str2;
        objArr[1] = (intent == null || (data = intent.getData()) == null) ? null : data.toString();
        objArr[2] = str;
        Log.i("MicroMsg.BrowserChooseDialogHelper", "alvinluo openInBrowser package: %s, uri: %s, url: %s", objArr);
        u.gmF();
        r rVar = (r) u.A(0, null);
        if (resolveInfo == null || (activityInfo2 = resolveInfo.activityInfo) == null) {
            str3 = null;
        } else {
            str3 = activityInfo2.packageName;
        }
        if (rVar.bdn(str3)) {
            rVar.cg(context, str);
            AppMethodBeat.o(210414);
            return;
        }
        if (intent != null) {
            intent.addFlags(524288);
            if (resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null || (str4 = activityInfo.packageName) == null) {
                str4 = "";
            }
            intent.setPackage(str4);
        } else {
            intent = null;
        }
        if (d.oD(29)) {
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
            if (activity != null) {
                activity.send(context, 1, null, a.JlB, null);
                AppMethodBeat.o(210414);
                return;
            }
            AppMethodBeat.o(210414);
        } else if (context != null) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseDialogHelper", "openInBrowser", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/pm/ResolveInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseDialogHelper", "openInBrowser", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/pm/ResolveInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(210414);
        } else {
            AppMethodBeat.o(210414);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\n0\n2\u000e\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\f0\fH\n¢\u0006\u0002\b\r"}, hxF = {"<anonymous>", "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "kotlin.jvm.PlatformType", "intent", "Landroid/content/Intent;", "resultCode", "", "resultData", "", "resultExtras", "Landroid/os/Bundle;", "onSendFinished"})
    public static final class a implements PendingIntent.OnFinished {
        public static final a JlB = new a();

        static {
            AppMethodBeat.i(210406);
            AppMethodBeat.o(210406);
        }

        a() {
        }

        public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i2, String str, Bundle bundle) {
            AppMethodBeat.i(210405);
            Log.i("MicroMsg.BrowserChooseDialogHelper", "onSendFinished resultCode: %d, , resultData: %s", Integer.valueOf(i2), str);
            AppMethodBeat.o(210405);
        }
    }
}
