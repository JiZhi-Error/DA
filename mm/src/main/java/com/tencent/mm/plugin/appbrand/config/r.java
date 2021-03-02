package com.tencent.mm.plugin.appbrand.config;

import android.os.Looper;
import com.tencent.f.j.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MStorage;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\u0001J)\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\u0001J)\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\n0\n2\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\u0001J)\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b2\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\u0001J\u0019\u0010\f\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\r0\rH\u0001J\t\u0010\u000e\u001a\u00020\u0004H\u0001J\u0019\u0010\u000e\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bH\u0001J1\u0010\u000e\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\b\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00110\u0011H\u0001J\t\u0010\u0012\u001a\u00020\u0004H\u0001J\t\u0010\u0013\u001a\u00020\u000fH\u0001J\u0019\u0010\u0014\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\u0001J\u0019\u0010\u0015\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\r0\rH\u0001J\t\u0010\u0016\u001a\u00020\u0004H\u0001¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/MStorageProxyForWxaAttrStorage;", "Lcom/tencent/mm/sdk/storage/IStorage;", "()V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "Lcom/tencent/threadpool/serial/Serial;", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "doNotify", "", "p2", "", "lock", "lockCount", "remove", "removeLoadedListener", "unlock", "plugin-appbrand-integration_release"})
public abstract class r implements IStorage {
    private final /* synthetic */ z lfG;

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void add(a aVar, MStorage.IOnStorageChange iOnStorageChange) {
        this.lfG.add(aVar, iOnStorageChange);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void add(MStorage.IOnStorageChange iOnStorageChange) {
        this.lfG.add(iOnStorageChange);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void add(MStorage.IOnStorageChange iOnStorageChange, Looper looper) {
        this.lfG.add(iOnStorageChange, looper);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void add(String str, MStorage.IOnStorageChange iOnStorageChange) {
        this.lfG.add(str, iOnStorageChange);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void addLoadedListener(MStorage.IOnStorageLoaded iOnStorageLoaded) {
        this.lfG.addLoadedListener(iOnStorageLoaded);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void doNotify() {
        this.lfG.doNotify();
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void doNotify(String str) {
        this.lfG.doNotify(str);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void doNotify(String str, int i2, Object obj) {
        this.lfG.doNotify(str, i2, obj);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void lock() {
        this.lfG.lock();
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public int lockCount() {
        return this.lfG.lockCount();
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void remove(MStorage.IOnStorageChange iOnStorageChange) {
        this.lfG.remove(iOnStorageChange);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void removeLoadedListener(MStorage.IOnStorageLoaded iOnStorageLoaded) {
        this.lfG.removeLoadedListener(iOnStorageLoaded);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void unlock() {
        this.lfG.unlock();
    }

    public r() {
        z buC = n.buC();
        p.g(buC, "SubCoreAppBrand.getWxaContactStorage()");
        this.lfG = buC;
    }
}
