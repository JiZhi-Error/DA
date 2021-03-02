package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\fJ\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "onUIEnterInvokeProxy", "Lcom/tencent/luggage/sdk/launching/OnWXAppResultListener;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "onUIExitInvokeProxy", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "(Lcom/tencent/luggage/sdk/launching/OnWXAppResultListener;Lcom/tencent/luggage/sdk/launching/OnWXAppResultListener;)V", "isUIExitInvokeIgnored", "", "describeContents", "", "onUIEnter", "", "onUIExit", "isFinish", "setIgnoreUIExitInvoke", "ignore", "writeToParcel", "dest", "flags", "Companion", "MM", "plugin-appbrand-integration_release"})
public final class WeAppOpenUICallbackIPCProxy implements Parcelable {
    public static final Parcelable.Creator<WeAppOpenUICallbackIPCProxy> CREATOR = new b();
    public static final a mXz = new a((byte) 0);
    public boolean mXw;
    public com.tencent.luggage.sdk.launching.a<IPCVoid> mXx;
    private com.tencent.luggage.sdk.launching.a<IPCBoolean> mXy;

    public WeAppOpenUICallbackIPCProxy(com.tencent.luggage.sdk.launching.a<IPCVoid> aVar, com.tencent.luggage.sdk.launching.a<IPCBoolean> aVar2) {
        p.h(aVar, "onUIEnterInvokeProxy");
        p.h(aVar2, "onUIExitInvokeProxy");
        AppMethodBeat.i(228738);
        this.mXx = aVar;
        this.mXy = aVar2;
        AppMethodBeat.o(228738);
    }

    public final void hY(boolean z) {
        AppMethodBeat.i(228736);
        if (this.mXw) {
            AppMethodBeat.o(228736);
            return;
        }
        this.mXy.b(new IPCBoolean(z));
        AppMethodBeat.o(228736);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WeAppOpenUICallbackIPCProxy(android.os.Parcel r5) {
        /*
            r4 = this;
            r3 = 228739(0x37d83, float:3.20532E-40)
            java.lang.String r0 = "source"
            kotlin.g.b.p.h(r5, r0)
            com.tencent.luggage.sdk.launching.a r0 = com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper.a(r5)
            java.lang.String r1 = "OnWXAppResultXPCWrapper.readFromParcel(source)"
            kotlin.g.b.p.g(r0, r1)
            com.tencent.luggage.sdk.launching.a r1 = com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper.a(r5)
            java.lang.String r2 = "OnWXAppResultXPCWrapper.readFromParcel(source)"
            kotlin.g.b.p.g(r1, r2)
            r4.<init>(r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy.<init>(android.os.Parcel):void");
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(228737);
        p.h(parcel, "dest");
        OnWXAppResultXPCWrapper.a(this.mXx, parcel);
        OnWXAppResultXPCWrapper.a(this.mXy, parcel);
        AppMethodBeat.o(228737);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy;", "plugin-appbrand-integration_release"})
    public static final class b implements Parcelable.Creator<WeAppOpenUICallbackIPCProxy> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WeAppOpenUICallbackIPCProxy createFromParcel(Parcel parcel) {
            AppMethodBeat.i(228726);
            p.h(parcel, "source");
            WeAppOpenUICallbackIPCProxy weAppOpenUICallbackIPCProxy = new WeAppOpenUICallbackIPCProxy(parcel);
            AppMethodBeat.o(228726);
            return weAppOpenUICallbackIPCProxy;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WeAppOpenUICallbackIPCProxy[] newArray(int i2) {
            return new WeAppOpenUICallbackIPCProxy[i2];
        }
    }

    static {
        AppMethodBeat.i(228740);
        AppMethodBeat.o(228740);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0007H\u0007J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$MM;", "", "()V", "TAG", "", "mReleasedUICallbacks", "Ljava/util/WeakHashMap;", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenUICallback;", "", "mUICallbackHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "beforeStartAppBrandUI", "", "initConfig", "targetProcess", "isUICallbackReleased", "uiCallback", "markUICallbackReleased", "stashUICallback", "launchParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "plugin-appbrand-integration_release"})
    public static final class c {
        private static final ConcurrentHashMap<AppBrandInitConfigWC, i> mXA = new ConcurrentHashMap<>();
        private static final WeakHashMap<i, Boolean> mXB = new WeakHashMap<>();
        public static final c mXC = new c();

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "onWXAppResult", "com/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$MM$beforeStartAppBrandUI$1$2"})
        static final class b<R extends Parcelable> implements com.tencent.luggage.sdk.launching.a<IPCBoolean> {
            final /* synthetic */ AtomicReference mXD;
            final /* synthetic */ String mXE;
            final /* synthetic */ AppBrandInitConfigWC mXF;
            final /* synthetic */ a mXG;

            b(AtomicReference atomicReference, a aVar, String str, AppBrandInitConfigWC appBrandInitConfigWC) {
                this.mXD = atomicReference;
                this.mXG = aVar;
                this.mXE = str;
                this.mXF = appBrandInitConfigWC;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Parcelable] */
            @Override // com.tencent.luggage.sdk.launching.a
            public final /* synthetic */ void b(IPCBoolean iPCBoolean) {
                boolean z = true;
                AppMethodBeat.i(228728);
                IPCBoolean iPCBoolean2 = iPCBoolean;
                i iVar = (i) this.mXD.get();
                if (iVar != null) {
                    c cVar = c.mXC;
                    if (!c.d(iVar)) {
                        if (iPCBoolean2 == null || !iPCBoolean2.value) {
                            z = false;
                        }
                        iVar.gC(z);
                        this.mXD.set(null);
                        h.a(this.mXE, this.mXG);
                        AppMethodBeat.o(228728);
                    }
                }
                this.mXD.set(null);
                h.a(this.mXE, this.mXG);
                AppMethodBeat.o(228728);
            }
        }

        static {
            AppMethodBeat.i(228734);
            AppMethodBeat.o(228734);
        }

        private c() {
        }

        public static final /* synthetic */ boolean d(i iVar) {
            AppMethodBeat.i(228735);
            boolean c2 = c(iVar);
            AppMethodBeat.o(228735);
            return c2;
        }

        public static final void b(i iVar) {
            AppMethodBeat.i(228730);
            p.h(iVar, "uiCallback");
            synchronized (mXB) {
                try {
                    mXB.put(iVar, Boolean.TRUE);
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(228730);
                }
            }
        }

        private static boolean c(i iVar) {
            boolean containsKey;
            AppMethodBeat.i(228731);
            synchronized (mXB) {
                try {
                    containsKey = mXB.containsKey(iVar);
                } finally {
                    AppMethodBeat.o(228731);
                }
            }
            return containsKey;
        }

        public static final void a(AppBrandInitConfigWC appBrandInitConfigWC, LaunchParcel launchParcel) {
            ParcelableMultiTaskData parcelableMultiTaskData;
            AppMethodBeat.i(228732);
            p.h(appBrandInitConfigWC, "initConfig");
            p.h(launchParcel, "launchParcel");
            u uVar = u.mTD;
            g yi = u.yi(launchParcel.mYS);
            i iVar = yi != null ? yi.kHN : null;
            if (iVar != null && !c(iVar)) {
                mXA.put(appBrandInitConfigWC, iVar);
            }
            appBrandInitConfigWC.lei = yi != null ? yi.kHO : false;
            if (yi != null) {
                parcelableMultiTaskData = yi.kHP;
            } else {
                parcelableMultiTaskData = null;
            }
            appBrandInitConfigWC.kHP = parcelableMultiTaskData;
            AppMethodBeat.o(228732);
        }

        public static final void a(AppBrandInitConfigWC appBrandInitConfigWC, String str) {
            AppMethodBeat.i(228733);
            p.h(appBrandInitConfigWC, "initConfig");
            if (str == null) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(915, 35);
                Log.w("MicroMsg.WeAppOpenUICallbackIPCProxy", "beforeStartAppBrandUI: [%s]", android.util.Log.getStackTraceString(new Throwable()));
                AppMethodBeat.o(228733);
                return;
            }
            i remove = mXA.remove(appBrandInitConfigWC);
            if (remove != null) {
                AtomicReference atomicReference = new AtomicReference(remove);
                a aVar = new a(atomicReference, str, appBrandInitConfigWC);
                h.b(str, aVar);
                appBrandInitConfigWC.leh = new WeAppOpenUICallbackIPCProxy(new C0732c(atomicReference), new b(atomicReference, aVar, str, appBrandInitConfigWC));
                AppMethodBeat.o(228733);
                return;
            }
            AppMethodBeat.o(228733);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$MM$beforeStartAppBrandUI$1$processDiedListener$1", "Lcom/tencent/mm/ipcinvoker/IRemoteProcDied;", "onDied", "", "plugin-appbrand-integration_release"})
        public static final class a implements m {
            final /* synthetic */ AtomicReference mXD;
            final /* synthetic */ String mXE;
            final /* synthetic */ AppBrandInitConfigWC mXF;

            a(AtomicReference atomicReference, String str, AppBrandInitConfigWC appBrandInitConfigWC) {
                this.mXD = atomicReference;
                this.mXE = str;
                this.mXF = appBrandInitConfigWC;
            }

            @Override // com.tencent.mm.ipcinvoker.m
            public final void aye() {
                AppMethodBeat.i(228727);
                h.a(this.mXE, this);
                i iVar = (i) this.mXD.get();
                if (iVar != null) {
                    c cVar = c.mXC;
                    if (!c.d(iVar)) {
                        iVar.buf();
                        this.mXD.set(null);
                        AppMethodBeat.o(228727);
                        return;
                    }
                }
                this.mXD.set(null);
                AppMethodBeat.o(228727);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "onWXAppResult"})
        /* renamed from: com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy$c$c  reason: collision with other inner class name */
        static final class C0732c<R extends Parcelable> implements com.tencent.luggage.sdk.launching.a<IPCVoid> {
            final /* synthetic */ AtomicReference mXD;

            C0732c(AtomicReference atomicReference) {
                this.mXD = atomicReference;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Parcelable] */
            @Override // com.tencent.luggage.sdk.launching.a
            public final /* synthetic */ void b(IPCVoid iPCVoid) {
                AppMethodBeat.i(228729);
                i iVar = (i) this.mXD.get();
                if (iVar != null) {
                    c cVar = c.mXC;
                    if (!c.d(iVar)) {
                        iVar.bue();
                        AppMethodBeat.o(228729);
                        return;
                    }
                }
                this.mXD.set(null);
                AppMethodBeat.o(228729);
            }
        }
    }
}
