package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponentActivity;
import com.tencent.mm.ui.component.UIComponentFragment;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0011\u0018\u0000 92\u00020\u0001:\u00019B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u00142\u0006\u0010\"\u001a\u00020\u0001H\u0002J\u001c\u0010#\u001a\u0004\u0018\u00010\r2\b\u0010\"\u001a\u0004\u0018\u00010\u00012\u0006\u0010$\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u0004\u0018\u00010&J\u0012\u0010%\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010'J\u001a\u0010(\u001a\u0004\u0018\u00010\r2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0010\u0010)\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010\nJ\u0016\u0010+\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u0016\u0010/\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u0016\u00100\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u0016\u00101\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u000e\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u000204J\b\u00105\u001a\u00020\u001fH\u0002J\b\u00106\u001a\u00020\u001fH\u0002J\u0010\u00107\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010\nJ\u0006\u00108\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R8\u0010\u0017\u001a,\u0012\u0004\u0012\u00020\n\u0012\"\u0012 \u0012\u0004\u0012\u00020\n\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00190\u001a0\u00190\u0018X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback;", "", "()V", "enterFinderHomeUI", "", "exitFinderHomeUI", "field_activity", "Ljava/lang/reflect/Field;", "field_fragments", "finish2PageName", "", "mCurFragmentRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "mCurPosition", "", "mFinderFragmmentListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1;", "mFinderHomeUICRef", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "mLastFragmentRef", "mLastPosition", "mMethodMap", "Ljava/util/HashMap;", "Landroid/util/Pair;", "", "mMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderHomeMonitor;", "startActivity2PageName", "cacheFinderHomeUI", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "getActivity", "caller", "getCurFragment", "position", "getCurFragmentOfFinderHomeUI", "Landroid/support/v4/app/Fragment;", "Landroid/app/Activity;", "getFragment", "monitor", "pageName", "onFinderHomeUIPaused", "Landroid/support/v4/app/FragmentActivity;", AppMeasurement.Param.TIMESTAMP, "", "onFinderHomeUIResumed", "onFinderLbsStreamListUIPaused", "onFinderLbsStreamListUIResumed", "registerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "resetOnPaused", "resetOnResumed", "unmonitor", "unregisterListener", "Companion", "plugin-expt_release"})
public final class b {
    public static final a sEj = new a((byte) 0);
    int afB = -1;
    private Field field_activity;
    private Field field_fragments;
    String sDY;
    String sDZ;
    boolean sEa;
    boolean sEb = true;
    com.tencent.mm.plugin.expt.hellhound.a.b.b sEc;
    WeakReference<UIComponentActivity> sEd;
    private WeakReference<UIComponentFragment> sEe;
    private WeakReference<UIComponentFragment> sEf;
    private int sEg = -1;
    final HashMap<String, Pair<String, List<Pair<String, String>>>> sEh = new HashMap<>();
    final C1014b sEi;

    static {
        AppMethodBeat.i(220907);
        AppMethodBeat.o(220907);
    }

    public b() {
        AppMethodBeat.i(220906);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("onUserVisibleFragmentChange", "(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V"));
        arrayList.add(new Pair("onFragmentChange", "(IIII)V"));
        this.sEh.put("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$", new Pair<>("com/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver", arrayList));
        try {
            Class<?> cls = Class.forName("com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver");
            p.g(cls, "Class.forName(NAME_FinderFragmentChangeObserver)");
            this.field_activity = cls.getDeclaredField(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            Field field = this.field_activity;
            if (field != null) {
                field.setAccessible(true);
            }
            this.field_fragments = cls.getDeclaredField("fragments");
            Field field2 = this.field_fragments;
            if (field2 != null) {
                field2.setAccessible(true);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FinderFragmentCallback", e2, "FinderFragmentCallback reflect crash: " + e2.getMessage(), new Object[0]);
        }
        this.afB = -1;
        this.sDY = null;
        this.sDZ = null;
        this.sEa = false;
        this.sEb = true;
        this.sEc = new com.tencent.mm.plugin.expt.hellhound.a.b.b();
        this.sEi = new C1014b(this);
        AppMethodBeat.o(220906);
    }

    public static final /* synthetic */ UIComponentActivity a(b bVar, Object obj) {
        AppMethodBeat.i(220910);
        UIComponentActivity dg = bVar.dg(obj);
        AppMethodBeat.o(220910);
        return dg;
    }

    public static final /* synthetic */ UIComponentFragment a(b bVar, Object obj, int i2) {
        AppMethodBeat.i(220908);
        UIComponentFragment l = bVar.l(obj, i2);
        AppMethodBeat.o(220908);
        return l;
    }

    public static final /* synthetic */ UIComponentFragment b(b bVar, Object obj, int i2) {
        AppMethodBeat.i(220909);
        UIComponentFragment m = bVar.m(obj, i2);
        AppMethodBeat.o(220909);
        return m;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$Companion;", "", "()V", "DESC_onFragmentChange_1", "", "DESC_onFragmentChange_2", "HEADER", "NAME_FinderFragmentChangeObserver", "NAME_activity", "NAME_fragments", "NAME_onFragmentChange_1", "NAME_onFragmentChange_2", "SUPER", "TAG", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ:\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderFragmentCallback$mFinderFragmmentListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.a.b.b.b$b  reason: collision with other inner class name */
    public static final class C1014b implements c {
        final /* synthetic */ b sEk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1014b(b bVar) {
            this.sEk = bVar;
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            String str4;
            Class<?> cls;
            Class<?> cls2;
            Class<?> cls3;
            Class<?> cls4;
            AppMethodBeat.i(220900);
            if (str == null || !n.J(str, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeUIC$fragmentChangeObserver$", false)) {
                AppMethodBeat.o(220900);
                return;
            }
            if (!p.j("onUserVisibleFragmentChange", str2) || !p.j("(ZILcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", str3)) {
                if (p.j("onFragmentChange", str2) && p.j("(IIII)V", str3) && objArr != null && objArr.length >= 4) {
                    b bVar = this.sEk;
                    Object obj2 = objArr[0];
                    if (obj2 == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(220900);
                        throw tVar;
                    }
                    bVar.afB = ((Integer) obj2).intValue();
                    b bVar2 = this.sEk;
                    Object obj3 = objArr[1];
                    if (obj3 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(220900);
                        throw tVar2;
                    }
                    bVar2.sEg = ((Integer) obj3).intValue();
                    if (obj != null) {
                        UIComponentFragment a2 = b.a(this.sEk, obj, this.sEk.sEg);
                        UIComponentFragment b2 = b.b(this.sEk, obj, this.sEk.afB);
                        UIComponentActivity a3 = b.a(this.sEk, obj);
                        if (a3 == null) {
                            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                            AppMethodBeat.o(220900);
                            throw tVar3;
                        }
                        MMActivity mMActivity = (MMActivity) a3;
                        b.a(this.sEk, (UIComponentActivity) mMActivity);
                        com.tencent.mm.plugin.expt.hellhound.a.b.b bVar3 = this.sEk.sEc;
                        if (!(bVar3 == null || mMActivity == null)) {
                            String name = (a2 == null || (cls4 = a2.getClass()) == null) ? null : cls4.getName();
                            if (!p.j(name, (b2 == null || (cls3 = b2.getClass()) == null) ? null : cls3.getName()) || name == null) {
                                long currentTimeMillis = System.currentTimeMillis();
                                StringBuilder append = new StringBuilder("switchFragment, cur=").append((a2 == null || (cls2 = a2.getClass()) == null) ? null : cls2.getName()).append(", last=");
                                if (b2 == null || (cls = b2.getClass()) == null) {
                                    str4 = null;
                                } else {
                                    str4 = cls.getName();
                                }
                                Log.i("HABBYGE-MALI.FinderHomeMonitor", append.append(str4).toString());
                                if (b2 != null) {
                                    bVar3.b(mMActivity, b2, currentTimeMillis, 1);
                                }
                                if (a2 != null) {
                                    bVar3.a(mMActivity, a2, currentTimeMillis, 0);
                                }
                            }
                            AppMethodBeat.o(220900);
                            return;
                        }
                    }
                }
            } else if (objArr != null && objArr.length >= 3) {
                Object obj4 = objArr[0];
                if (obj4 == null) {
                    t tVar4 = new t("null cannot be cast to non-null type kotlin.Boolean");
                    AppMethodBeat.o(220900);
                    throw tVar4;
                }
                boolean booleanValue = ((Boolean) obj4).booleanValue();
                Object obj5 = objArr[1];
                if (obj5 == null) {
                    t tVar5 = new t("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(220900);
                    throw tVar5;
                }
                int intValue = ((Integer) obj5).intValue();
                Object obj6 = objArr[2];
                if (obj6 == null) {
                    t tVar6 = new t("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentFragment");
                    AppMethodBeat.o(220900);
                    throw tVar6;
                }
                UIComponentFragment uIComponentFragment = (UIComponentFragment) obj6;
                if (!booleanValue) {
                    if (intValue == this.sEk.afB) {
                        this.sEk.sEe = new WeakReference(uIComponentFragment);
                    }
                    AppMethodBeat.o(220900);
                    return;
                } else if (intValue == this.sEk.sEg) {
                    this.sEk.sEf = new WeakReference(uIComponentFragment);
                    AppMethodBeat.o(220900);
                    return;
                }
            }
            AppMethodBeat.o(220900);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }

    /* access modifiers changed from: package-private */
    public final UIComponentFragment l(Object obj, int i2) {
        UIComponentFragment uIComponentFragment = null;
        AppMethodBeat.i(220901);
        if (obj == null || i2 < 0) {
            WeakReference<UIComponentFragment> weakReference = this.sEf;
            if (weakReference != null) {
                UIComponentFragment uIComponentFragment2 = weakReference.get();
                AppMethodBeat.o(220901);
                return uIComponentFragment2;
            }
            AppMethodBeat.o(220901);
            return null;
        }
        try {
            uIComponentFragment = m(obj, i2);
        } catch (Exception e2) {
            WeakReference<UIComponentFragment> weakReference2 = this.sEf;
            if (weakReference2 != null) {
                uIComponentFragment = weakReference2.get();
            }
        }
        AppMethodBeat.o(220901);
        return uIComponentFragment;
    }

    private final UIComponentFragment m(Object obj, int i2) {
        UIComponentFragment uIComponentFragment;
        AppMethodBeat.i(220902);
        if (i2 < 0) {
            AppMethodBeat.o(220902);
            return null;
        }
        try {
            Field field = this.field_fragments;
            Object obj2 = field != null ? field.get(obj) : null;
            if (obj2 == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.collections.List<*>");
                AppMethodBeat.o(220902);
                throw tVar;
            }
            Object obj3 = ((List) obj2).get(i2);
            if (obj3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentFragment");
                AppMethodBeat.o(220902);
                throw tVar2;
            }
            uIComponentFragment = (UIComponentFragment) obj3;
            AppMethodBeat.o(220902);
            return uIComponentFragment;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FinderFragmentCallback", e2, "getFragment exception: " + e2.getMessage(), new Object[0]);
            uIComponentFragment = null;
        }
    }

    private final UIComponentActivity dg(Object obj) {
        UIComponentActivity uIComponentActivity;
        Object obj2;
        AppMethodBeat.i(220903);
        try {
            Field field = this.field_activity;
            if (field != null) {
                obj2 = field.get(obj);
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentActivity");
                AppMethodBeat.o(220903);
                throw tVar;
            }
            uIComponentActivity = (UIComponentActivity) obj2;
            AppMethodBeat.o(220903);
            return uIComponentActivity;
        } catch (Exception e2) {
            uIComponentActivity = null;
        }
    }

    public final void b(FragmentActivity fragmentActivity, long j2) {
        Class<?> cls;
        AppMethodBeat.i(220904);
        p.h(fragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        com.tencent.mm.plugin.expt.hellhound.a.b.b bVar = this.sEc;
        if (bVar != null) {
            p.h(fragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            bVar.sCE = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar2 = bVar.sCE;
            if (bVar2 == null) {
                p.btv("statyTimeStaticHome");
            }
            bVar2.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar3 = bVar.sCE;
            if (bVar3 == null) {
                p.btv("statyTimeStaticHome");
            }
            bVar3.dMl = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(fragmentActivity.getClass().getName());
            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar4 = bVar.sCE;
            if (bVar4 == null) {
                p.btv("statyTimeStaticHome");
            }
            bVar4.sGC = j2;
            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar5 = bVar.sCE;
            if (bVar5 == null) {
                p.btv("statyTimeStaticHome");
            }
            bVar5.sGF = "143";
            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar6 = bVar.sCE;
            if (bVar6 == null) {
                p.btv("statyTimeStaticHome");
            }
            bVar6.dYn = c.b.EXPOSURE.value;
            Log.i("HABBYGE-MALI.FinderHomeMonitor", "onFinderHomeUIResume...");
        }
        if (this.sDZ != null && (!p.j(fragmentActivity.getClass().getName(), this.sDZ)) && !this.sEa) {
            cOH();
            com.tencent.mm.plugin.expt.hellhound.a.b.b bVar7 = this.sEc;
            if (bVar7 != null) {
                bVar7.a(fragmentActivity, j2, true);
                AppMethodBeat.o(220904);
                return;
            }
            AppMethodBeat.o(220904);
        } else if (this.sEa) {
            cOH();
            AppMethodBeat.o(220904);
        } else {
            com.tencent.mm.plugin.expt.hellhound.a.b.b bVar8 = this.sEc;
            if (bVar8 != null) {
                p.h(fragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                Fragment ae = com.tencent.mm.plugin.expt.hellhound.a.b.b.ae(fragmentActivity);
                Log.d("HABBYGE-MALI.FinderHomeMonitor", "switch2Front: " + ((ae == null || (cls = ae.getClass()) == null) ? null : cls.getName()));
                if (ae != null) {
                    bVar8.a(fragmentActivity, ae, j2, 2);
                    AppMethodBeat.o(220904);
                    return;
                }
            }
            AppMethodBeat.o(220904);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        if (kotlin.g.b.p.j(r0.dMl, r3) != false) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(android.support.v4.app.FragmentActivity r11, long r12) {
        /*
        // Method dump skipped, instructions count: 315
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.b.b.b.c(android.support.v4.app.FragmentActivity, long):void");
    }

    private final void cOH() {
        this.sEa = false;
        this.sDZ = null;
        this.sDY = null;
    }

    private final void cOI() {
        this.sEb = false;
        this.sDY = null;
    }

    public static final /* synthetic */ void a(b bVar, UIComponentActivity uIComponentActivity) {
        AppMethodBeat.i(220911);
        if (uIComponentActivity == null) {
            AppMethodBeat.o(220911);
            return;
        }
        WeakReference<UIComponentActivity> weakReference = bVar.sEd;
        if ((weakReference != null ? weakReference.get() : null) == null) {
            bVar.sEd = new WeakReference<>(uIComponentActivity);
        }
        AppMethodBeat.o(220911);
    }
}
