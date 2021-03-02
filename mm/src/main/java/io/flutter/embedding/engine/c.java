package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.arch.lifecycle.Lifecycle;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import io.flutter.plugin.a.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class c implements io.flutter.embedding.engine.plugins.a.b, io.flutter.embedding.engine.plugins.b {
    private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.a> SOn = new HashMap();
    private final a.b SOo;
    private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.a.a> SOp = new HashMap();
    private b SOq;
    private boolean SOr = false;
    private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.d.a> SOs = new HashMap();
    private Service SOt;
    private C2247c SOu;
    private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.b.a> SOv = new HashMap();
    private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.c.a> SOw = new HashMap();
    private ContentProvider SOx;
    private Activity activity;
    private BroadcastReceiver broadcastReceiver;
    private final a wJi;

    /* access modifiers changed from: package-private */
    /* renamed from: io.flutter.embedding.engine.c$c  reason: collision with other inner class name */
    public static class C2247c {
    }

    c(Context context, a aVar, io.flutter.embedding.engine.a.a aVar2) {
        AppMethodBeat.i(214934);
        this.wJi = aVar;
        this.SOo = new a.b(context, aVar, aVar.SNW, aVar.SMr, aVar.platformViewsController.STj, new a(aVar2, (byte) 0));
        AppMethodBeat.o(214934);
    }

    public final void destroy() {
        AppMethodBeat.i(10166);
        io.flutter.a.hwd();
        hwH();
        removeAll();
        AppMethodBeat.o(10166);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.Map<java.lang.Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.a> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.util.Map<java.lang.Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.c.a> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.util.Map<java.lang.Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.b.a> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.util.Map<java.lang.Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.d.a> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: java.util.Map<java.lang.Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.a.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.embedding.engine.plugins.b
    public final void a(io.flutter.embedding.engine.plugins.a aVar) {
        AppMethodBeat.i(214935);
        if (this.SOn.containsKey(aVar.getClass())) {
            new StringBuilder("Attempted to register plugin (").append(aVar).append(") but it was already registered with this FlutterEngine (").append(this.wJi).append(").");
            io.flutter.a.hwf();
            AppMethodBeat.o(214935);
            return;
        }
        new StringBuilder("Adding plugin: ").append(aVar);
        io.flutter.a.hwd();
        this.SOn.put(aVar.getClass(), aVar);
        aVar.a(this.SOo);
        if (aVar instanceof io.flutter.embedding.engine.plugins.a.a) {
            io.flutter.embedding.engine.plugins.a.a aVar2 = (io.flutter.embedding.engine.plugins.a.a) aVar;
            this.SOp.put(aVar.getClass(), aVar2);
            if (hwI()) {
                aVar2.a(this.SOq);
            }
        }
        if (aVar instanceof io.flutter.embedding.engine.plugins.d.a) {
            this.SOs.put(aVar.getClass(), (io.flutter.embedding.engine.plugins.d.a) aVar);
        }
        if (aVar instanceof io.flutter.embedding.engine.plugins.b.a) {
            this.SOv.put(aVar.getClass(), (io.flutter.embedding.engine.plugins.b.a) aVar);
        }
        if (aVar instanceof io.flutter.embedding.engine.plugins.c.a) {
            this.SOw.put(aVar.getClass(), (io.flutter.embedding.engine.plugins.c.a) aVar);
        }
        AppMethodBeat.o(214935);
    }

    @Override // io.flutter.embedding.engine.plugins.b
    public final void A(Set<io.flutter.embedding.engine.plugins.a> set) {
        AppMethodBeat.i(214936);
        for (io.flutter.embedding.engine.plugins.a aVar : set) {
            a(aVar);
        }
        AppMethodBeat.o(214936);
    }

    private void B(Set<Class<? extends io.flutter.embedding.engine.plugins.a>> set) {
        AppMethodBeat.i(10167);
        for (Class<? extends io.flutter.embedding.engine.plugins.a> cls : set) {
            io.flutter.embedding.engine.plugins.a aVar = this.SOn.get(cls);
            if (aVar != null) {
                new StringBuilder("Removing plugin: ").append(aVar);
                io.flutter.a.hwd();
                if (aVar instanceof io.flutter.embedding.engine.plugins.a.a) {
                    if (hwI()) {
                        ((io.flutter.embedding.engine.plugins.a.a) aVar).sU();
                    }
                    this.SOp.remove(cls);
                }
                if (aVar instanceof io.flutter.embedding.engine.plugins.d.a) {
                    this.SOs.remove(cls);
                }
                if (aVar instanceof io.flutter.embedding.engine.plugins.b.a) {
                    this.SOv.remove(cls);
                }
                if (aVar instanceof io.flutter.embedding.engine.plugins.c.a) {
                    this.SOw.remove(cls);
                }
                aVar.b(this.SOo);
                this.SOn.remove(cls);
            }
        }
        AppMethodBeat.o(10167);
    }

    private void removeAll() {
        AppMethodBeat.i(10168);
        B(new HashSet(this.SOn.keySet()));
        this.SOn.clear();
        AppMethodBeat.o(10168);
    }

    private void hwH() {
        AppMethodBeat.i(10169);
        if (hwI()) {
            hwK();
            AppMethodBeat.o(10169);
        } else if (hwN()) {
            hwO();
            AppMethodBeat.o(10169);
        } else if (hwP()) {
            hwQ();
            AppMethodBeat.o(10169);
        } else {
            if (hwR()) {
                hwS();
            }
            AppMethodBeat.o(10169);
        }
    }

    private boolean hwI() {
        return this.activity != null;
    }

    @Override // io.flutter.embedding.engine.plugins.a.b
    public final void a(Activity activity2, Lifecycle lifecycle) {
        AppMethodBeat.i(10170);
        new StringBuilder("Attaching to an Activity: ").append(activity2).append(".").append(this.SOr ? " This is after a config change." : "");
        io.flutter.a.hwd();
        hwH();
        this.activity = activity2;
        this.SOq = new b(activity2, lifecycle);
        this.wJi.platformViewsController.a(activity2, this.wJi.SMr, this.wJi.SNW);
        for (io.flutter.embedding.engine.plugins.a.a aVar : this.SOp.values()) {
            if (this.SOr) {
                aVar.b(this.SOq);
            } else {
                aVar.a(this.SOq);
            }
        }
        this.SOr = false;
        AppMethodBeat.o(10170);
    }

    @Override // io.flutter.embedding.engine.plugins.a.b
    public final void hwJ() {
        AppMethodBeat.i(10171);
        if (hwI()) {
            new StringBuilder("Detaching from an Activity for config changes: ").append(this.activity);
            io.flutter.a.hwd();
            this.SOr = true;
            for (io.flutter.embedding.engine.plugins.a.a aVar : this.SOp.values()) {
                aVar.sV();
            }
            this.wJi.platformViewsController.detach();
            this.activity = null;
            this.SOq = null;
            AppMethodBeat.o(10171);
            return;
        }
        io.flutter.a.hwg();
        AppMethodBeat.o(10171);
    }

    @Override // io.flutter.embedding.engine.plugins.a.b
    public final void hwK() {
        AppMethodBeat.i(10172);
        if (hwI()) {
            new StringBuilder("Detaching from an Activity: ").append(this.activity);
            io.flutter.a.hwd();
            for (io.flutter.embedding.engine.plugins.a.a aVar : this.SOp.values()) {
                aVar.sU();
            }
            this.wJi.platformViewsController.detach();
            this.activity = null;
            this.SOq = null;
            AppMethodBeat.o(10172);
            return;
        }
        io.flutter.a.hwg();
        AppMethodBeat.o(10172);
    }

    @Override // io.flutter.embedding.engine.plugins.a.b
    public final boolean a(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(10173);
        io.flutter.a.hwd();
        if (hwI()) {
            boolean z = false;
            for (m.d dVar : this.SOq.SOA) {
                z = dVar.a(i2, strArr, iArr) || z;
            }
            AppMethodBeat.o(10173);
            return z;
        }
        io.flutter.a.hwg();
        AppMethodBeat.o(10173);
        return false;
    }

    @Override // io.flutter.embedding.engine.plugins.a.b
    public final boolean onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(10174);
        io.flutter.a.hwd();
        if (hwI()) {
            boolean z = false;
            for (m.a aVar : this.SOq.SOB) {
                z = aVar.onActivityResult(i2, i3, intent) || z;
            }
            AppMethodBeat.o(10174);
            return z;
        }
        io.flutter.a.hwg();
        AppMethodBeat.o(10174);
        return false;
    }

    @Override // io.flutter.embedding.engine.plugins.a.b
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(10175);
        io.flutter.a.hwd();
        if (hwI()) {
            for (m.b bVar : this.SOq.SOC) {
                bVar.onNewIntent(intent);
            }
            AppMethodBeat.o(10175);
            return;
        }
        io.flutter.a.hwg();
        AppMethodBeat.o(10175);
    }

    @Override // io.flutter.embedding.engine.plugins.a.b
    public final void onUserLeaveHint() {
        AppMethodBeat.i(10176);
        io.flutter.a.hwd();
        if (hwI()) {
            for (m.e eVar : this.SOq.SOD) {
                eVar.onUserLeaveHint();
            }
            AppMethodBeat.o(10176);
            return;
        }
        io.flutter.a.hwg();
        AppMethodBeat.o(10176);
    }

    @Override // io.flutter.embedding.engine.plugins.a.b
    public final void hwL() {
        AppMethodBeat.i(214937);
        io.flutter.a.hwd();
        if (hwI()) {
            Iterator<Object> it = this.SOq.SOE.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(214937);
            return;
        }
        io.flutter.a.hwg();
        AppMethodBeat.o(214937);
    }

    @Override // io.flutter.embedding.engine.plugins.a.b
    public final void hwM() {
        AppMethodBeat.i(214938);
        io.flutter.a.hwd();
        if (hwI()) {
            Iterator<Object> it = this.SOq.SOE.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(214938);
            return;
        }
        io.flutter.a.hwg();
        AppMethodBeat.o(214938);
    }

    private boolean hwN() {
        return this.SOt != null;
    }

    private void hwO() {
        AppMethodBeat.i(10177);
        if (hwN()) {
            new StringBuilder("Detaching from a Service: ").append(this.SOt);
            io.flutter.a.hwd();
            Iterator<io.flutter.embedding.engine.plugins.d.a> it = this.SOs.values().iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.SOt = null;
            this.SOu = null;
            AppMethodBeat.o(10177);
            return;
        }
        io.flutter.a.hwg();
        AppMethodBeat.o(10177);
    }

    private boolean hwP() {
        return this.broadcastReceiver != null;
    }

    private void hwQ() {
        AppMethodBeat.i(10178);
        if (hwP()) {
            new StringBuilder("Detaching from BroadcastReceiver: ").append(this.broadcastReceiver);
            io.flutter.a.hwd();
            Iterator<io.flutter.embedding.engine.plugins.b.a> it = this.SOv.values().iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(10178);
            return;
        }
        io.flutter.a.hwg();
        AppMethodBeat.o(10178);
    }

    private boolean hwR() {
        return this.SOx != null;
    }

    private void hwS() {
        AppMethodBeat.i(10179);
        if (hwR()) {
            new StringBuilder("Detaching from ContentProvider: ").append(this.SOx);
            io.flutter.a.hwd();
            Iterator<io.flutter.embedding.engine.plugins.c.a> it = this.SOw.values().iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(10179);
            return;
        }
        io.flutter.a.hwg();
        AppMethodBeat.o(10179);
    }

    static class a implements a.AbstractC2251a {
        final io.flutter.embedding.engine.a.a SOy;

        /* synthetic */ a(io.flutter.embedding.engine.a.a aVar, byte b2) {
            this(aVar);
        }

        private a(io.flutter.embedding.engine.a.a aVar) {
            this.SOy = aVar;
        }

        @Override // io.flutter.embedding.engine.plugins.a.AbstractC2251a
        public final String btc(String str) {
            AppMethodBeat.i(214932);
            String btd = this.SOy.btd(str);
            AppMethodBeat.o(214932);
            return btd;
        }

        @Override // io.flutter.embedding.engine.plugins.a.AbstractC2251a
        public final String op(String str, String str2) {
            AppMethodBeat.i(214933);
            String lookupKeyForAsset = this.SOy.getLookupKeyForAsset(str, str2);
            AppMethodBeat.o(214933);
            return lookupKeyForAsset;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements io.flutter.embedding.engine.plugins.a.c {
        final Set<m.d> SOA = new HashSet();
        final Set<m.a> SOB = new HashSet();
        final Set<m.b> SOC = new HashSet();
        final Set<m.e> SOD = new HashSet();
        final Set<Object> SOE = new HashSet();
        private final HiddenLifecycleReference SOz;
        private final Activity activity;

        public b(Activity activity2, Lifecycle lifecycle) {
            AppMethodBeat.i(214939);
            this.activity = activity2;
            this.SOz = new HiddenLifecycleReference(lifecycle);
            AppMethodBeat.o(214939);
        }

        @Override // io.flutter.embedding.engine.plugins.a.c
        public final Activity getActivity() {
            return this.activity;
        }
    }
}
