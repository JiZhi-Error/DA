package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public abstract class d extends l {
    public abstract c getWindowAndroid();

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public String getAppId() {
        if (getRuntime() == null) {
            return null;
        }
        return getRuntime().mAppId;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final Context getContext() {
        if (getRuntime() == null) {
            return MMApplicationContext.getContext();
        }
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(getRuntime().mContext);
        if (castActivityOrNull != null) {
            return castActivityOrNull;
        }
        Context context = getRuntime().mContext;
        return context == null ? MMApplicationContext.getContext() : context;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public final boolean a(n nVar) {
        if (!isRunning() || !getRuntime().a(nVar)) {
            return super.a(nVar);
        }
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public final <T extends m> T av(Class<T> cls) {
        T t;
        return (getRuntime() == null || (t = (T) getRuntime().d(cls, false)) == null) ? (T) super.av(cls) : t;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public final <T extends n> T aw(Class<T> cls) {
        T t;
        return (!isRunning() || (t = (T) getRuntime().aw(cls)) == null) ? (T) super.aw(cls) : t;
    }

    public final q bqY() {
        AppBrandRuntime runtime = getRuntime();
        if (runtime == null) {
            return null;
        }
        return bg.M(runtime);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public b getAppState() {
        if (!isRunning()) {
            return b.DESTROYED;
        }
        return getRuntime().kAH.kQM.bwY();
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public com.tencent.mm.plugin.appbrand.appstorage.q getFileSystem() {
        if (!isRunning()) {
            return super.getFileSystem();
        }
        return getRuntime().getFileSystem();
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public com.tencent.mm.plugin.appbrand.widget.dialog.m getDialogContainer() {
        if (!isRunning()) {
            return super.getDialogContainer();
        }
        return getRuntime().jCK;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public final <T extends com.tencent.luggage.a.b> T M(Class<T> cls) {
        T t;
        if (ICommLibReader.class == cls) {
            return (T) super.M(cls);
        }
        AppBrandRuntime runtime = getRuntime();
        return (runtime == null || (t = (T) ((com.tencent.luggage.a.b) runtime.af(cls))) == null) ? (T) super.M(cls) : t;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k
    public final ICommLibReader bqZ() {
        return (ICommLibReader) M(ICommLibReader.class);
    }

    public final void a(ICommLibReader iCommLibReader) {
        if (iCommLibReader == null) {
            throw new NullPointerException();
        }
        super.a(ICommLibReader.class, iCommLibReader);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public boolean isRunning() {
        AppBrandRuntime runtime = getRuntime();
        return runtime != null && !runtime.isDestroyed();
    }
}
