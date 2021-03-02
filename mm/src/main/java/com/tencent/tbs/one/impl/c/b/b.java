package com.tencent.tbs.one.impl.c.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.f;
import java.lang.reflect.Method;

public final class b extends ContextWrapper {

    /* renamed from: b  reason: collision with root package name */
    private static Method f2539b;

    /* renamed from: a  reason: collision with root package name */
    public a f2540a;

    /* renamed from: c  reason: collision with root package name */
    private Resources f2541c;

    /* renamed from: d  reason: collision with root package name */
    private Resources.Theme f2542d;

    /* renamed from: e  reason: collision with root package name */
    private String f2543e;

    static {
        AppMethodBeat.i(173868);
        try {
            f2539b = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            AppMethodBeat.o(173868);
        } catch (Throwable th) {
            AppMethodBeat.o(173868);
        }
    }

    public b(Context context, String str) {
        super(context);
        AppMethodBeat.i(173858);
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            if (applicationInfo != null) {
                this.f2543e = applicationInfo.packageName;
                applicationInfo.sourceDir = str;
                applicationInfo.publicSourceDir = str;
                try {
                    this.f2541c = context.getPackageManager().getResourcesForApplication(applicationInfo);
                } catch (Throwable th) {
                    this.f2541c = a(context, str);
                }
                if (this.f2541c != null) {
                    this.f2542d = this.f2541c.newTheme();
                    Resources.Theme theme = getBaseContext().getTheme();
                    if (theme != null) {
                        this.f2542d.setTo(theme);
                    }
                    int i2 = applicationInfo.theme;
                    if (i2 != 0) {
                        this.f2542d.applyStyle(i2, true);
                    }
                } else {
                    f.b("Failed to create resource info from %s", str);
                }
            } else {
                f.b("Failed to get application info from %s", str);
            }
        } else {
            f.b("Failed to get package info from %s", str);
        }
        this.f2540a = new a(this);
        AppMethodBeat.o(173858);
    }

    private Intent a(Intent intent) {
        AppMethodBeat.i(173865);
        ComponentName component = intent.getComponent();
        if (component != null) {
            intent.setComponent(new ComponentName(getBaseContext(), component.getClassName()));
        }
        AppMethodBeat.o(173865);
        return intent;
    }

    private static Resources a(Context context, String str) {
        AppMethodBeat.i(173857);
        if (f2539b == null) {
            AppMethodBeat.o(173857);
            return null;
        }
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            f2539b.invoke(assetManager, str);
            Resources resources = context.getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Configuration configuration = resources.getConfiguration();
            Class<?> cls = resources.getClass();
            if (!"android.taobao.atlas.runtime.DelegateResources".equals(cls.getName())) {
                try {
                    Resources resources2 = (Resources) cls.getConstructor(AssetManager.class, DisplayMetrics.class, Configuration.class).newInstance(assetManager, displayMetrics, configuration);
                    AppMethodBeat.o(173857);
                    return resources2;
                } catch (Throwable th) {
                }
            }
            Resources resources3 = new Resources(assetManager, displayMetrics, configuration);
            AppMethodBeat.o(173857);
            return resources3;
        } catch (Throwable th2) {
            f.b("Failed to new resources from %s", str, th2);
            AppMethodBeat.o(173857);
            return null;
        }
    }

    public final AssetManager getAssets() {
        AssetManager assets;
        AppMethodBeat.i(173862);
        Resources resources = getResources();
        if (resources == null || (assets = resources.getAssets()) == null) {
            AssetManager assets2 = super.getAssets();
            AppMethodBeat.o(173862);
            return assets2;
        }
        AppMethodBeat.o(173862);
        return assets;
    }

    public final String getPackageName() {
        AppMethodBeat.i(173859);
        if (this.f2543e != null) {
            String str = this.f2543e;
            AppMethodBeat.o(173859);
            return str;
        }
        String packageName = super.getPackageName();
        AppMethodBeat.o(173859);
        return packageName;
    }

    public final Resources getResources() {
        AppMethodBeat.i(173861);
        if (this.f2541c != null) {
            Resources resources = this.f2541c;
            AppMethodBeat.o(173861);
            return resources;
        }
        Resources resources2 = super.getResources();
        AppMethodBeat.o(173861);
        return resources2;
    }

    @Override // android.content.Context, android.content.ContextWrapper
    public final Object getSystemService(String str) {
        AppMethodBeat.i(173860);
        if ("layout_inflater".equals(str)) {
            a aVar = this.f2540a;
            AppMethodBeat.o(173860);
            return aVar;
        }
        Object systemService = super.getSystemService(str);
        AppMethodBeat.o(173860);
        return systemService;
    }

    public final Resources.Theme getTheme() {
        AppMethodBeat.i(173863);
        if (this.f2542d != null) {
            Resources.Theme theme = this.f2542d;
            AppMethodBeat.o(173863);
            return theme;
        }
        Resources.Theme theme2 = super.getTheme();
        AppMethodBeat.o(173863);
        return theme2;
    }

    public final void setTheme(int i2) {
        AppMethodBeat.i(173864);
        if (this.f2542d != null) {
            this.f2542d.applyStyle(i2, true);
            AppMethodBeat.o(173864);
            return;
        }
        super.setTheme(i2);
        AppMethodBeat.o(173864);
    }

    public final void startActivity(Intent intent) {
        AppMethodBeat.i(173866);
        super.startActivity(a(intent));
        AppMethodBeat.o(173866);
    }

    public final ComponentName startService(Intent intent) {
        AppMethodBeat.i(173867);
        ComponentName startService = super.startService(a(intent));
        AppMethodBeat.o(173867);
        return startService;
    }
}
