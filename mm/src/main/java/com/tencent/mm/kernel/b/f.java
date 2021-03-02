package com.tencent.mm.kernel.b;

import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.j;
import java.util.HashSet;
import junit.framework.Assert;

public abstract class f implements d {
    private static final String TAG = "MMKernel.Plugin";
    private volatile boolean mConfigured = false;
    private boolean mDependencyMade = false;
    private boolean mInstalled = false;
    private boolean mIsPendingPlugin = false;
    private boolean mMakingDependencies = false;
    private HashSet<c> mPins = new HashSet<>();

    public void invokeInstalled() {
        this.mInstalled = true;
        installed();
        detectAlias();
    }

    private final void detectAlias() {
        Class<?>[] interfaces = getClass().getInterfaces();
        for (Class<?> cls : interfaces) {
            if (a.class.isAssignableFrom(cls)) {
                alias(cls);
            }
        }
    }

    public void markAsPendingPlugin() {
        this.mIsPendingPlugin = true;
    }

    public boolean isPendingPlugin() {
        return this.mIsPendingPlugin;
    }

    public void installed() {
    }

    public void dependency() {
    }

    public void configure(g gVar) {
    }

    public void uninstalled() {
        this.mConfigured = false;
        this.mInstalled = false;
    }

    public void invokeDependency() {
        this.mMakingDependencies = true;
        dependency();
        checkIfNeedDefaultDependency();
        this.mDependencyMade = true;
        this.mMakingDependencies = false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.tencent.mm.kernel.a.a.a<java.lang.Class<? extends com.tencent.mm.kernel.b.f>> */
    /* JADX WARN: Multi-variable type inference failed */
    private void checkIfNeedDefaultDependency() {
        Class<? extends a> cls;
        if (!h.aAl().aAd().hqu.bF(getClass()) && (cls = h.aAl().aAd().hqx) != null) {
            dependsOn(cls);
            j.i(TAG, "plugin[%s] not specific any depOn, we using default one [%s]", this, cls);
        }
    }

    public void invokeConfigure(g gVar) {
        configure(gVar);
        this.mConfigured = true;
    }

    public void alias(Class<? extends a> cls) {
        Assert.assertNotNull(cls);
        Assert.assertTrue(cls.isInstance(this));
        h.aAl().aAd().k(getClass(), cls);
    }

    public synchronized void pin(c cVar) {
        if (!this.mPins.contains(cVar)) {
            this.mPins.add(cVar);
            h.aAl().aAd().a(cVar.getClass(), new e(cVar));
        }
    }

    public synchronized void unpin(c cVar) {
        if (this.mPins.contains(cVar)) {
            this.mPins.remove(cVar);
            h.aAl().aAd().ag(cVar.getClass());
        }
    }

    /* access modifiers changed from: protected */
    public void dependsOnRoot() {
        if (!this.mMakingDependencies) {
            j.w(TAG, "Ignore this dependency. It's not dependency phase now!", new Object[0]);
        } else {
            h.aAl().aAd().l(getClass(), getClass());
        }
    }

    /* access modifiers changed from: protected */
    public void dependsOn(Class<? extends a> cls) {
        if (!this.mMakingDependencies) {
            j.w(TAG, "Ignore this dependency. It's not dependency phase now!", new Object[0]);
        } else {
            h.aAl().aAd().l(getClass(), cls);
        }
    }

    public String identify() {
        return getClass().getSimpleName();
    }

    public boolean isConfigured() {
        return this.mConfigured;
    }

    public boolean isDependencyMade() {
        return this.mDependencyMade;
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public String name() {
        return toString();
    }

    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(super.hashCode());
    }

    public String[] ofProcesses() {
        return new String[0];
    }

    public int hashCode() {
        return name().hashCode();
    }
}
