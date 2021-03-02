package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.support.v4.app.Fragment;
import android.util.Pair;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a;
import com.tencent.mm.plugin.expt.hellhound.core.d;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u000201B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001a\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010 \u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010$\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010#2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0010H\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0010H\u0002J\u0012\u0010,\u001a\u00020\u001a2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0018\u0010/\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010#2\u0006\u0010\u001c\u001a\u00020\u001dR\u0014\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R8\u0010\u0013\u001a,\u0012\u0004\u0012\u00020\u0015\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0015\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00180\u00170\u00160\u0014X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor;", "", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;)V", "launcherUIClass", "Ljava/lang/Class;", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/ui/MMFragmentActivity;", "mCallback", "mChatProxy", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatUIFragmentProxy;", "mHasScrollChanged", "", "mLastFragmentIndex", "", "mListener", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "methodInfoMap", "Ljava/util/HashMap;", "", "", "", "Landroid/util/Pair;", "callbackMMFragmentActivityWhenResume", "", "mmfActivity", AppMeasurement.Param.TIMESTAMP, "", "doMonitor4MMFragmentActivity", "mmfa", "doMonitorViewPagerEvent", "fragmentPauseCallback", "fa", "Landroid/support/v4/app/FragmentActivity;", "monitor", "launcherUI", "onChatAction", "msgType", "onPageScrollStateChanged", "state", "onPageSelected", "position", "onSwipEvent", "lf", "Landroid/support/v4/app/Fragment;", "unmonitor", "Companion", "MethodListener", "plugin-expt_release"})
public final class e {
    public static final a sAg = new a((byte) 0);
    WeakReference<MMFragmentActivity> mActivityRef;
    Class<?> sAa;
    b sAb;
    private int sAc;
    c sAd;
    final HashMap<String, Map<String, List<Pair<String, String>>>> sAe = new HashMap<>();
    private boolean sAf;
    d szZ;

    static {
        AppMethodBeat.i(122562);
        AppMethodBeat.o(122562);
    }

    public e(d dVar) {
        AppMethodBeat.i(122561);
        this.szZ = dVar;
        this.sAd = new b();
        try {
            a.C1025a aVar = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.szr;
            this.sAa = a.C1025a.getClass("com.tencent.mm.ui.LauncherUI");
            this.sAb = new b(this.szZ);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FragmentLauncherUIMonitor", e2, "FragmentLauncherUIMonitor", new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create("onPageSelected", "(I)V"));
        arrayList.add(Pair.create("onPageScrollStateChanged", "(I)V"));
        HashMap hashMap = new HashMap();
        hashMap.put("android/support/v4/view/ViewPager$OnPageChangeListener", arrayList);
        this.sAe.put("com/tencent/mm/ui/MainTabUI$TabsAdapter", hashMap);
        AppMethodBeat.o(122561);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ:\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor$MethodListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor;)V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    final class b implements c {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(184272);
            if (objArr != null) {
                if (objArr.length == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    z2 = false;
                }
                if (z2) {
                    if (p.j(str2, "onPageSelected")) {
                        e eVar = e.this;
                        Object obj2 = objArr[0];
                        if (obj2 == null) {
                            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                            AppMethodBeat.o(184272);
                            throw tVar;
                        }
                        e.a(eVar, ((Integer) obj2).intValue());
                        AppMethodBeat.o(184272);
                        return;
                    } else if (p.j(str2, "onPageScrollStateChanged")) {
                        e eVar2 = e.this;
                        Object obj3 = objArr[0];
                        if (obj3 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                            AppMethodBeat.o(184272);
                            throw tVar2;
                        }
                        e.b(eVar2, ((Integer) obj3).intValue());
                    }
                }
            }
            AppMethodBeat.o(184272);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }

    public static final /* synthetic */ void a(e eVar, int i2) {
        MMFragmentActivity mMFragmentActivity;
        d dVar;
        d dVar2;
        Class<?> cls;
        Class<?> cls2;
        AppMethodBeat.i(161612);
        WeakReference<MMFragmentActivity> weakReference = eVar.mActivityRef;
        if (weakReference == null || (mMFragmentActivity = weakReference.get()) == null) {
            AppMethodBeat.o(161612);
            return;
        }
        p.g(mMFragmentActivity, "mActivityRef?.get() ?: return");
        Fragment a2 = h.a(mMFragmentActivity, eVar.sAc);
        Fragment a3 = h.a(mMFragmentActivity, i2);
        Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "fragment, onPageSelected: runOnEnter: lastPos=" + eVar.sAc + ", curPos=" + i2 + ", activity=" + mMFragmentActivity.getClass().getCanonicalName() + ", lastFrag=" + ((a2 == null || (cls2 = a2.getClass()) == null) ? null : cls2.getCanonicalName()) + ", curFrag=" + ((a3 == null || (cls = a3.getClass()) == null) ? null : cls.getCanonicalName()));
        if (eVar.sAf) {
            String GT = h.GT(eVar.sAc);
            erd erd = new erd();
            erd.id = GT;
            erd.timestamp = System.currentTimeMillis();
            erd.NoL = GT;
            erd.dMl = a2 == null ? BuildConfig.COMMAND : com.tencent.mm.plugin.expt.hellhound.core.b.aoE(a2.getClass().getName());
            erd.NoN = a2 != null ? a2.hashCode() : -1;
            erd.typeName = erd.dMl;
            erd.NoM = erd.dMl;
            erd.eventId = com.tencent.mm.plugin.expt.hellhound.core.b.c.d.GLIDE.value;
            erd.type = 0;
            Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "FragmentMonitor, onSwipEvent: pos=" + eVar.sAc + "\n, page.name=" + erd.dMl + "\n, page.hashCode=" + erd.NoN + "\n, EventId=" + com.tencent.mm.plugin.expt.hellhound.core.b.c.d.GLIDE + "\n, resId=" + GT);
            com.tencent.mm.plugin.expt.hellhound.core.b.c.e eVar2 = com.tencent.mm.plugin.expt.hellhound.core.b.c.e.sAU;
            com.tencent.mm.plugin.expt.hellhound.core.b.c.e.a(erd);
            eVar.sAf = false;
        }
        eVar.sAc = i2;
        long currentTimeMillis = System.currentTimeMillis();
        if (!(a2 == null || (dVar2 = eVar.szZ) == null)) {
            dVar2.a(mMFragmentActivity, a2.getClass().getCanonicalName(), a2.hashCode(), currentTimeMillis, true);
        }
        if (a3 == null || (dVar = eVar.szZ) == null) {
            AppMethodBeat.o(161612);
            return;
        }
        dVar.a(mMFragmentActivity, a3, a3.getClass().getCanonicalName(), a3.hashCode(), currentTimeMillis, true);
        AppMethodBeat.o(161612);
    }

    public static final /* synthetic */ void b(e eVar, int i2) {
        if (i2 == 1) {
            eVar.sAf = true;
        }
    }
}
