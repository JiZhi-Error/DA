package com.tencent.mm.plugin.finder.preload.tabPreload;

import android.arch.lifecycle.Observer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.preload.tabPreload.a;
import com.tencent.mm.plugin.finder.preload.tabPreload.f;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.component.UIComponentPlugin;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0010\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0001;B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0019\u001a\u00020\u001a\"\b\b\u0000\u0010\u001b*\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001dJ\u0010\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&J\u0016\u0010'\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&J\u0010\u0010(\u001a\u0004\u0018\u00010\u00182\u0006\u0010$\u001a\u00020\u000eJ\u0006\u0010)\u001a\u00020\u000eJ\u000e\u0010*\u001a\u00020&2\u0006\u0010$\u001a\u00020\u000eJ\u000e\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020-J\u0012\u0010.\u001a\u00020\u001a2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u00101\u001a\u00020\u001a2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u00102\u001a\u00020\u001a2\b\u00103\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u00104\u001a\u00020\u001aJ\u0006\u00105\u001a\u00020\u001aJ\u000e\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u000eJ\u0006\u0010:\u001a\u00020\u001aR\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Landroid/arch/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "homeTabStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getHomeTabStateVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "homeTabStateVM$delegate", "Lkotlin/Lazy;", "lastTargetEnterTabType", "", "mainUiIndexChangeListener", "com/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1;", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "getServerConfig", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "supportTabPreload", "", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "clearPreloadCache", "", "T", "clazz", "Ljava/lang/Class;", "enterFinderLoad", "intent", "Landroid/content/Intent;", "getAlivePreloadWorker", "getInnerTime", "", "tabType", "isRedDot", "", "getOuterTime", "getServer", "getTargetEnterTabType", "isAutoRefresh", "isEnable", "source", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "onAppBackground", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "", "onAppForeground", "onChanged", "result", "onEnterFinder", "onExitFinder", "onRedDotRevoke", "ctrInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "performConfigChange", "setup", "Companion", "plugin-finder_release"})
public final class FinderStreamTabPreloadCore extends UIComponentPlugin<PluginFinder> implements Observer<h.a>, o {
    public static final a uUR = new a((byte) 0);
    public final List<f> uUN = j.listOf((Object[]) new f[]{new d(this), new b(this), new c(this), new e(this)});
    private final f uUO = g.ah(b.uUS);
    public final c uUP = new c(this);
    private int uUQ = -1;

    static {
        AppMethodBeat.i(249571);
        AppMethodBeat.o(249571);
    }

    public final FinderHomeTabStateVM dlH() {
        AppMethodBeat.i(249558);
        FinderHomeTabStateVM finderHomeTabStateVM = (FinderHomeTabStateVM) this.uUO.getValue();
        AppMethodBeat.o(249558);
        return finderHomeTabStateVM;
    }

    public FinderStreamTabPreloadCore() {
        AppMethodBeat.i(249570);
        AppMethodBeat.o(249570);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.arch.lifecycle.Observer
    public final /* synthetic */ void onChanged(h.a aVar) {
        AppMethodBeat.i(249559);
        if (aVar != null) {
            int dHR = dlH().dHR();
            Log.i("Finder.StreamTabPreloadCore", "[onChanged] lastTargetEnterTabType=" + this.uUQ + " targetEnterTabType=" + dHR);
            Iterator<T> it = this.uUN.iterator();
            while (it.hasNext()) {
                it.next().gc(this.uUQ, dHR);
            }
            this.uUQ = dHR;
        }
        AppMethodBeat.o(249559);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final <T extends f> void aM(Class<T> cls) {
        AppMethodBeat.i(249557);
        p.h(cls, "clazz");
        for (T t : this.uUN) {
            if (p.j(t.getClass(), cls)) {
                t.nM(true);
            }
        }
        AppMethodBeat.o(249557);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore$mainUiIndexChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HomeUITabChangeEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class c extends IListener<kt> {
        final /* synthetic */ FinderStreamTabPreloadCore uUT;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(FinderStreamTabPreloadCore finderStreamTabPreloadCore) {
            this.uUT = finderStreamTabPreloadCore;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(kt ktVar) {
            AppMethodBeat.i(249556);
            kt ktVar2 = ktVar;
            p.h(ktVar2, "event");
            if (ktVar2.dPO.currentIndex == 2) {
                for (f fVar : this.uUT.uUN) {
                    if (fVar.uVd.compareAndSet(false, true) && !fVar.uVa) {
                        long dlK = fVar.dlK();
                        long aWA = dlK - (fVar.uUZ <= 0 ? 0 : cl.aWA() - fVar.uUZ);
                        Log.i(fVar.TAG, "[performEnterFindMoreFriendTab] expired=" + dlK + " delayed=" + aWA);
                        fVar.uVb.a(fVar.uVf, aWA, "performEnterFindMoreFriendTab");
                    }
                }
            } else {
                for (f fVar2 : this.uUT.uUN) {
                    if (fVar2.uVd.compareAndSet(true, false)) {
                        Log.i(fVar2.TAG, "[performExitFindMoreFriendTab]");
                        fVar2.uVb.aut("performExitFindMoreFriendTab");
                        fVar2.uUZ = cl.aWA();
                    }
                }
            }
            AppMethodBeat.o(249556);
            return false;
        }
    }

    public final void JM(int i2) {
        AppMethodBeat.i(249563);
        bcy dlI = dlI();
        Iterator<T> it = this.uUN.iterator();
        while (it.hasNext()) {
            it.next().a(i2, dlI);
        }
        AppMethodBeat.o(249563);
    }

    public final boolean JN(int i2) {
        AppMethodBeat.i(249564);
        boolean JN = dlH().JN(i2);
        AppMethodBeat.o(249564);
        return JN;
    }

    public static boolean a(f.c cVar) {
        boolean z;
        AppMethodBeat.i(249566);
        p.h(cVar, "source");
        if (!((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).showFinderEntry()) {
            Log.i("Finder.StreamTabPreloadCore", "finder entry close then return");
            AppMethodBeat.o(249566);
            return false;
        } else if (cVar == f.c.EnterLoad) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            boolean dwY = com.tencent.mm.plugin.finder.storage.c.dwY();
            AppMethodBeat.o(249566);
            return dwY;
        } else {
            if ((z.aUd() & 34359738368L) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i("Finder.StreamTabPreloadCore", "finder find more ui entry close then return");
                AppMethodBeat.o(249566);
                return false;
            }
            com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (!com.tencent.mm.plugin.finder.storage.c.dsl()) {
                Log.i("Finder.StreamTabPreloadCore", "isEnablePreloadStreamRefresh false then return");
                AppMethodBeat.o(249566);
                return false;
            }
            AppMethodBeat.o(249566);
            return true;
        }
    }

    public static bcy dlI() {
        AppMethodBeat.i(249567);
        bcy bcy = new bcy();
        try {
            e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_TIMELINE_PRELOAD_REFRESH_CONFIG_STRING_SYNC, "");
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(249567);
                throw tVar;
            }
            bcy.parseFrom(Util.decodeHexString((String) obj));
            AppMethodBeat.o(249567);
            return bcy;
        } catch (Exception e2) {
            Log.printErrStackTrace("Finder.StreamTabPreloadCore", e2, "", new Object[0]);
        }
    }

    public static long al(int i2, boolean z) {
        long j2;
        AppMethodBeat.i(249568);
        switch (i2) {
            case 1:
                if (z) {
                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.duf().value().intValue() < 0) {
                        j2 = ((long) dlI().LMg) * 1000;
                        break;
                    } else {
                        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        j2 = (long) com.tencent.mm.plugin.finder.storage.c.duf().value().intValue();
                        break;
                    }
                } else {
                    com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.duj().value().intValue() < 0) {
                        j2 = ((long) dlI().LMk) * 1000;
                        break;
                    } else {
                        com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        j2 = (long) com.tencent.mm.plugin.finder.storage.c.duj().value().intValue();
                        break;
                    }
                }
            case 2:
                if (z) {
                    com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.duh().value().intValue() < 0) {
                        j2 = ((long) dlI().LMi) * 1000;
                        break;
                    } else {
                        com.tencent.mm.plugin.finder.storage.c cVar6 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        j2 = (long) com.tencent.mm.plugin.finder.storage.c.duh().value().intValue();
                        break;
                    }
                } else {
                    com.tencent.mm.plugin.finder.storage.c cVar7 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.dul().value().intValue() < 0) {
                        j2 = ((long) dlI().LMm) * 1000;
                        break;
                    } else {
                        com.tencent.mm.plugin.finder.storage.c cVar8 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        j2 = (long) com.tencent.mm.plugin.finder.storage.c.dul().value().intValue();
                        break;
                    }
                }
            case 3:
                if (z) {
                    com.tencent.mm.plugin.finder.storage.c cVar9 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.due().value().intValue() < 0) {
                        j2 = ((long) dlI().LMf) * 1000;
                        break;
                    } else {
                        com.tencent.mm.plugin.finder.storage.c cVar10 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        j2 = (long) com.tencent.mm.plugin.finder.storage.c.due().value().intValue();
                        break;
                    }
                } else {
                    com.tencent.mm.plugin.finder.storage.c cVar11 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.dui().value().intValue() < 0) {
                        j2 = ((long) dlI().LMj) * 1000;
                        break;
                    } else {
                        com.tencent.mm.plugin.finder.storage.c cVar12 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        j2 = (long) com.tencent.mm.plugin.finder.storage.c.dui().value().intValue();
                        break;
                    }
                }
            case 4:
                if (z) {
                    com.tencent.mm.plugin.finder.storage.c cVar13 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.dug().value().intValue() < 0) {
                        j2 = ((long) dlI().LMh) * 1000;
                        break;
                    } else {
                        com.tencent.mm.plugin.finder.storage.c cVar14 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        j2 = (long) com.tencent.mm.plugin.finder.storage.c.dug().value().intValue();
                        break;
                    }
                } else {
                    com.tencent.mm.plugin.finder.storage.c cVar15 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.duk().value().intValue() < 0) {
                        j2 = ((long) dlI().LMl) * 1000;
                        break;
                    } else {
                        com.tencent.mm.plugin.finder.storage.c cVar16 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        j2 = (long) com.tencent.mm.plugin.finder.storage.c.duk().value().intValue();
                        break;
                    }
                }
            default:
                j2 = Long.MAX_VALUE;
                break;
        }
        Log.i("Finder.StreamTabPreloadCore", "[getOuterTime] tabType=" + i2 + " withRedDot=" + z + " time=" + j2 + "s ");
        if (j2 <= 0) {
            AppMethodBeat.o(249568);
            return MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        AppMethodBeat.o(249568);
        return j2;
    }

    public static long JO(int i2) {
        long j2;
        AppMethodBeat.i(249569);
        switch (i2) {
            case 1:
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dur().value().intValue() < 0) {
                    j2 = ((long) dlI().LMs) * 1000;
                    break;
                } else {
                    com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    j2 = (long) com.tencent.mm.plugin.finder.storage.c.dur().value().intValue();
                    break;
                }
            case 2:
                com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dut().value().intValue() < 0) {
                    j2 = ((long) dlI().LMu) * 1000;
                    break;
                } else {
                    com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    j2 = (long) com.tencent.mm.plugin.finder.storage.c.dut().value().intValue();
                    break;
                }
            case 3:
                com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.duq().value().intValue() < 0) {
                    j2 = ((long) dlI().LMr) * 1000;
                    break;
                } else {
                    com.tencent.mm.plugin.finder.storage.c cVar6 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    j2 = (long) com.tencent.mm.plugin.finder.storage.c.duq().value().intValue();
                    break;
                }
            case 4:
                com.tencent.mm.plugin.finder.storage.c cVar7 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dus().value().intValue() < 0) {
                    j2 = ((long) dlI().LMt) * 1000;
                    break;
                } else {
                    com.tencent.mm.plugin.finder.storage.c cVar8 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    j2 = (long) com.tencent.mm.plugin.finder.storage.c.dus().value().intValue();
                    break;
                }
            default:
                j2 = Long.MAX_VALUE;
                break;
        }
        Log.i("Finder.StreamTabPreloadCore", "[getInnerTime] tabType=" + i2 + " withRedDot=false time=" + j2 + 's');
        if (j2 <= 0) {
            AppMethodBeat.o(249569);
            return MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        AppMethodBeat.o(249569);
        return j2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<FinderHomeTabStateVM> {
        public static final b uUS = new b();

        static {
            AppMethodBeat.i(249555);
            AppMethodBeat.o(249555);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderHomeTabStateVM invoke() {
            AppMethodBeat.i(249554);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderHomeTabStateVM finderHomeTabStateVM = (FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
            AppMethodBeat.o(249554);
            return finderHomeTabStateVM;
        }
    }

    @Override // com.tencent.mm.app.o
    public final void onAppForeground(String str) {
        boolean z;
        AppMethodBeat.i(249560);
        for (T t : this.uUN) {
            if (t.uVc.compareAndSet(true, false)) {
                Log.i(t.TAG, "[performForeground]");
                a aVar = t.uVb;
                a.AbstractRunnableC1255a andSet = aVar.uUM.getAndSet(null);
                if (andSet != null) {
                    aVar.uOI.removeCallbacks(andSet);
                    aVar.a(andSet, andSet.gY, "resume");
                    Log.i(aVar.TAG, "[resume] delay=" + andSet.gY + "ms hash=" + andSet.hashCode());
                    z = true;
                } else {
                    Log.i(aVar.TAG, "[resume] failure. runnable is null");
                    z = false;
                }
                if (!z && t.uVd.get() && !t.uVa) {
                    t.uVb.a(t.uVf, t.dlK(), "performForeground");
                }
            }
        }
        AppMethodBeat.o(249560);
    }

    @Override // com.tencent.mm.app.o
    public final void onAppBackground(String str) {
        AppMethodBeat.i(249561);
        for (T t : this.uUN) {
            if (t.uVc.compareAndSet(false, true) && !t.uVa) {
                Log.i(t.TAG, "[performBackground]");
                a aVar = t.uVb;
                a.AbstractRunnableC1255a aVar2 = t.uVf;
                p.h(aVar2, "runnable");
                aVar.uUM.set(aVar2);
                aVar.uOI.removeCallbacks(aVar2);
                long currentTimeMillis = System.currentTimeMillis() - aVar2.time;
                aVar2.gY -= currentTimeMillis;
                Log.i(aVar.TAG, "[pause] has cost=" + currentTimeMillis + "ms delay=" + aVar2.gY + "ms hash=" + aVar2.hashCode());
            }
        }
        AppMethodBeat.o(249561);
    }

    public final f JL(int i2) {
        T t;
        boolean z;
        AppMethodBeat.i(249562);
        Iterator<T> it = this.uUN.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (next.dLS == i2) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        T t2 = t;
        AppMethodBeat.o(249562);
        return t2;
    }

    public final void c(k kVar) {
        int i2;
        AppMethodBeat.i(249565);
        p.h(kVar, "ctrInfo");
        switch (kVar.field_ctrInfo.type) {
            case 7:
                i2 = 1;
                break;
            case 8:
                i2 = 3;
                break;
            case 1003:
                i2 = 2;
                break;
            case 1004:
                i2 = 4;
                break;
            default:
                i2 = 0;
                break;
        }
        f JL = JL(i2);
        if (JL != null) {
            JL.nM(true);
        }
        Log.i("Finder.StreamTabPreloadCore", "[onRedDotRevoke] tabType=".concat(String.valueOf(i2)));
        AppMethodBeat.o(249565);
    }
}
