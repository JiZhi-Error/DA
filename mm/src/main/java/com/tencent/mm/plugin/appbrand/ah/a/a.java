package com.tencent.mm.plugin.appbrand.ah.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/wxa_redirecting_page/export/WxaRedirectingPageExportApi;", "", "()V", "WXBizEntryActivityPendingMap", "api-protocol_release"})
public final class a {
    public static final a oFx = new a();

    static {
        AppMethodBeat.i(194333);
        AppMethodBeat.o(194333);
    }

    private a() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0004J\u0013\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0004J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/wxa_redirecting_page/export/WxaRedirectingPageExportApi$WXBizEntryActivityPendingMap;", "", "()V", "TAG", "", "map", "Landroid/util/SparseArray;", "Landroid/app/Activity;", "finish", "invokeTicket", "get", "remove", "set", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "api-protocol_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ah.a.a$a  reason: collision with other inner class name */
    public static final class C0537a {
        private static final SparseArray<Activity> mHa = new SparseArray<>();
        public static final C0537a oFy = new C0537a();

        static {
            AppMethodBeat.i(194332);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Application");
                AppMethodBeat.o(194332);
                throw tVar;
            }
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.ac.a() {
                /* class com.tencent.mm.plugin.appbrand.ah.a.a.C0537a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.ac.a
                public final void onActivityDestroyed(Activity activity) {
                    AppMethodBeat.i(194328);
                    super.onActivityDestroyed(activity);
                    if (activity != null) {
                        C0537a aVar = C0537a.oFy;
                        if (C0537a.mHa.size() > 0) {
                            C0537a aVar2 = C0537a.oFy;
                            int indexOfValue = C0537a.mHa.indexOfValue(activity);
                            if (indexOfValue >= 0) {
                                C0537a aVar3 = C0537a.oFy;
                                C0537a.mHa.removeAt(indexOfValue);
                            }
                            AppMethodBeat.o(194328);
                            return;
                        }
                    }
                    AppMethodBeat.o(194328);
                }
            });
            AppMethodBeat.o(194332);
        }

        private C0537a() {
        }

        public static final void b(String str, Activity activity) {
            AppMethodBeat.i(194330);
            p.h(str, "invokeTicket");
            p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            mHa.put(str.hashCode(), activity);
            AppMethodBeat.o(194330);
        }

        public static Activity agm(String str) {
            Activity activity;
            ComponentName componentName;
            String className;
            AppMethodBeat.i(194331);
            p.h(str, "invokeTicket");
            p.h(str, "invokeTicket");
            int indexOfKey = mHa.indexOfKey(str.hashCode());
            if (indexOfKey >= 0) {
                Activity valueAt = mHa.valueAt(indexOfKey);
                mHa.removeAt(indexOfKey);
                activity = valueAt;
            } else {
                activity = null;
            }
            if (activity == null) {
                Activity activity2 = (Activity) new C0538a(str).invoke();
                AppMethodBeat.o(194331);
                return activity2;
            }
            ActivityManager.RunningTaskInfo currentTaskInfo = Util.getCurrentTaskInfo(activity, activity.getTaskId());
            if (currentTaskInfo == null || (componentName = currentTaskInfo.baseActivity) == null || (className = componentName.getClassName()) == null || !n.nm(className, "WXEntryActivity") || Build.VERSION.SDK_INT < 21) {
                activity.finish();
                Log.i("MicroMsg.WxaRedirectingPageExportApi.WXBizEntryActivityPendingMap", "finish with ticket:" + str + ", invoke finish(), wxBizEntryActivity:" + activity.hashCode());
            } else {
                activity.finishAndRemoveTask();
                Log.i("MicroMsg.WxaRedirectingPageExportApi.WXBizEntryActivityPendingMap", "finish with ticket:" + str + ", invoke finishAndRemoveTask(), wxBizEntryActivity:" + activity.hashCode());
            }
            AppMethodBeat.o(194331);
            return activity;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ah.a.a$a$a  reason: collision with other inner class name */
        static final class C0538a extends q implements kotlin.g.a.a {
            final /* synthetic */ String oFz;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0538a(String str) {
                super(0);
                this.oFz = str;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(194329);
                Log.e("MicroMsg.WxaRedirectingPageExportApi.WXBizEntryActivityPendingMap", "finish with ticket:" + this.oFz + ", get null wxBizEntryActivity");
                AppMethodBeat.o(194329);
                return null;
            }
        }
    }
}
