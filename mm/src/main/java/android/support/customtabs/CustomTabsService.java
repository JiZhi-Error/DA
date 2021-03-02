package android.support.customtabs;

import android.app.Service;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.e;
import android.support.v4.e.a;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class CustomTabsService extends Service {
    private final Map<IBinder, IBinder.DeathRecipient> gA = new a();
    private e.a gB = new e.a() {
        /* class android.support.customtabs.CustomTabsService.AnonymousClass1 */

        @Override // android.support.customtabs.e
        public final boolean aK() {
            return CustomTabsService.this.aK();
        }

        @Override // android.support.customtabs.e
        public final boolean a(d dVar) {
            final c cVar = new c(dVar);
            try {
                AnonymousClass1 r2 = new IBinder.DeathRecipient() {
                    /* class android.support.customtabs.CustomTabsService.AnonymousClass1.AnonymousClass1 */

                    public final void binderDied() {
                        CustomTabsService.this.a(cVar);
                    }
                };
                synchronized (CustomTabsService.this.gA) {
                    dVar.asBinder().linkToDeath(r2, 0);
                    CustomTabsService.this.gA.put(dVar.asBinder(), r2);
                }
                return CustomTabsService.this.aL();
            } catch (RemoteException e2) {
                return false;
            }
        }

        @Override // android.support.customtabs.e
        public final boolean b(d dVar) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new c(dVar);
            return customTabsService.aM();
        }

        @Override // android.support.customtabs.e
        public final Bundle aN() {
            return CustomTabsService.this.aN();
        }

        @Override // android.support.customtabs.e
        public final boolean c(d dVar) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new c(dVar);
            return customTabsService.aO();
        }

        @Override // android.support.customtabs.e
        public final boolean d(d dVar) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new c(dVar);
            return customTabsService.aP();
        }

        @Override // android.support.customtabs.e
        public final int e(d dVar) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new c(dVar);
            return customTabsService.aQ();
        }

        @Override // android.support.customtabs.e
        public final boolean f(d dVar) {
            CustomTabsService customTabsService = CustomTabsService.this;
            new c(dVar);
            return customTabsService.aR();
        }
    };

    /* access modifiers changed from: protected */
    public abstract boolean aK();

    /* access modifiers changed from: protected */
    public abstract boolean aL();

    /* access modifiers changed from: protected */
    public abstract boolean aM();

    /* access modifiers changed from: protected */
    public abstract Bundle aN();

    /* access modifiers changed from: protected */
    public abstract boolean aO();

    /* access modifiers changed from: protected */
    public abstract boolean aP();

    /* access modifiers changed from: protected */
    public abstract int aQ();

    /* access modifiers changed from: protected */
    public abstract boolean aR();

    /* access modifiers changed from: protected */
    public final boolean a(c cVar) {
        try {
            synchronized (this.gA) {
                IBinder aS = cVar.aS();
                aS.unlinkToDeath(this.gA.get(aS), 0);
                this.gA.remove(aS);
            }
            return true;
        } catch (NoSuchElementException e2) {
            return false;
        }
    }
}
