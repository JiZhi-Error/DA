package com.tencent.mm.plugin.multitask.ui.panel;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.plugin.multitask.h;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskPanelContainer;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a;
import com.tencent.mm.plugin.multitask.ui.panel.a;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.plugin.multitask.ui.uic.SnapShotMultiTaskUIC;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\n\u0018\u0000 *2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001*B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J4\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001c\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u001cH\u0016R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel;", "Lcom/tencent/mm/plugin/multitask/ui/panel/BaseMultiTaskPanel;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$OnItemListener;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "onCreateInstanceState", "Landroid/os/Bundle;", "(Landroid/support/v7/app/AppCompatActivity;Landroid/os/Bundle;)V", "multiTaskEventListener", "com/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel$multiTaskEventListener$1", "Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel$multiTaskEventListener$1;", "teenModeDataChangedListener", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "initPanelWindowContainer", "", "container", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskPanelContainer;", "onCreate", "savedInstanceState", "onDestroy", "onGridItemClick", "firstView", "Landroid/view/View;", "targetView", "curPos", "", "taskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "needEnterAnim", "", "onGridItemDelete", "onGridItemExposed", "onNotifyChange", "event", "", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "supportMultiTaskType", "multiTaskType", "Companion", "ui-multitask_release"})
public final class b extends a implements MultiTaskMinusScreenUIC.b, MStorage.IOnStorageChange {
    public static final a AeL = new a((byte) 0);
    private final C1530b AeK;
    private com.tencent.mm.plugin.teenmode.a.c kIM;

    static {
        AppMethodBeat.i(236582);
        AppMethodBeat.o(236582);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel$multiTaskEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MulitTaskEvent;", "callback", "", "event", "ui-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.ui.panel.b$b  reason: collision with other inner class name */
    public static final class C1530b extends IListener<mt> {
        final /* synthetic */ b AeM;
        final /* synthetic */ AppCompatActivity uQi;

        C1530b(b bVar, AppCompatActivity appCompatActivity) {
            this.AeM = bVar;
            this.uQi = appCompatActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mt mtVar) {
            mt.a aVar;
            boolean z;
            View rootView;
            AppMethodBeat.i(236567);
            mt mtVar2 = mtVar;
            if (!(mtVar2 == null || (aVar = mtVar2.dSq) == null)) {
                if (aVar.dSr == 0) {
                    MultiTaskUIComponent multiTaskUIComponent = this.AeM.AeG;
                    if ((multiTaskUIComponent != null ? multiTaskUIComponent.dks() : null) != a.b.MODE_NONE) {
                        String str = aVar.id;
                        g gVar = g.zZj;
                        if (!p.j(str, g.eqx())) {
                            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                            MultiTaskUIC multiTaskUIC = (MultiTaskUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(MultiTaskUIC.class);
                            if (multiTaskUIC.erO()) {
                                multiTaskUIC.erT();
                            }
                        }
                    }
                    MultiTaskInfo multiTaskInfo = new MultiTaskInfo();
                    multiTaskInfo.field_type = aVar.type;
                    multiTaskInfo.field_id = aVar.id;
                    b bVar = this.AeM;
                    p.h(multiTaskInfo, "multiTaskInfo");
                    if (bVar.AeH.containsKey(multiTaskInfo.field_id)) {
                        z.f fVar = new z.f();
                        fVar.SYG = (T) bVar.AeH.get(multiTaskInfo.field_id);
                        T t = fVar.SYG;
                        if (p.j((t == null || (rootView = t.getRootView()) == null) ? null : rootView.getParent(), bVar.AeE)) {
                            com.tencent.mm.ac.d.h(new a.C1529a(fVar));
                        }
                        if (!p.j(fVar.SYG, bVar.AeG) || bVar.AeG == null) {
                            T t2 = fVar.SYG;
                            if (t2 != null) {
                                t2.dkr();
                            }
                        } else {
                            bVar.dkr();
                            bVar.AeG = null;
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        Log.i("MicroMsg.MultiTask.MinusScreenPanel", "HideMultiTaskEvent, hideUIComponent, id:%s", multiTaskInfo.field_id);
                    }
                } else if (aVar.dSr == 1) {
                    com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                    ((MultiTaskUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(MultiTaskUIC.class)).m(false, false, true);
                    Log.i("MicroMsg.MultiTask.MinusScreenPanel", "showHome");
                } else if (aVar.dSr == 2) {
                    e aAh = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    aAh.azQ().set(ar.a.USERINFO_MULTITASK_LAST_SHOW_ID_AND_TIME_STRING_SYNC, "");
                    Log.i("MicroMsg.MultiTask.MinusScreenPanel", "reset show id");
                }
            }
            AppMethodBeat.o(236567);
            return false;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(AppCompatActivity appCompatActivity, Bundle bundle) {
        super(appCompatActivity, bundle);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(236581);
        this.AeK = new C1530b(this, appCompatActivity);
        this.kIM = new d(appCompatActivity);
        AppMethodBeat.o(236581);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDataChanged"})
    static final class d implements com.tencent.mm.plugin.teenmode.a.c {
        final /* synthetic */ AppCompatActivity uQi;

        d(AppCompatActivity appCompatActivity) {
            this.uQi = appCompatActivity;
        }

        @Override // com.tencent.mm.plugin.teenmode.a.c
        public final void onDataChanged() {
            AppMethodBeat.i(236573);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.multitask.ui.panel.b.d.AnonymousClass1 */
                final /* synthetic */ d AeR;

                {
                    this.AeR = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(236572);
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    ((MultiTaskUIC) com.tencent.mm.ui.component.a.b(this.AeR.uQi).get(MultiTaskUIC.class)).sk(true);
                    x xVar = x.SXb;
                    AppMethodBeat.o(236572);
                    return xVar;
                }
            });
            AppMethodBeat.o(236573);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.ui.panel.a
    public final void a(MultiTaskPanelContainer multiTaskPanelContainer) {
        AppMethodBeat.i(236574);
        p.h(multiTaskPanelContainer, "container");
        MultiTaskInfo multiTaskInfo = new MultiTaskInfo();
        g gVar = g.zZj;
        multiTaskInfo.field_id = g.eqw();
        MultiTaskUIComponent i2 = i(multiTaskInfo);
        if (i2 != null) {
            View rootView = i2.getRootView();
            MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
            rootView.setPadding(0, 0, MultiTaskUIC.Agi, 0);
            if (i2 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
                AppMethodBeat.o(236574);
                throw tVar;
            }
            ((MultiTaskMinusScreenUIC) i2).Afp = this;
        }
        super.a(multiTaskPanelContainer);
        AppMethodBeat.o(236574);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel$Companion;", "", "()V", "TAG", "", "ui-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(236575);
        HashSet<MultiTaskUIComponent> hashSet = new HashSet();
        hashSet.addAll(this.uiComponents);
        for (MultiTaskUIComponent multiTaskUIComponent : hashSet) {
            multiTaskUIComponent.a(mStorageEventData);
        }
        AppMethodBeat.o(236575);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a, com.tencent.mm.plugin.multitask.ui.panel.a
    public final a.b dks() {
        return a.b.MODE_SHOW_SINGLE_SCENE;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.panel.a
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(236576);
        super.onCreate(bundle);
        com.tencent.mm.plugin.multitask.model.a multiTaskStorage = ((PluginMultiTask) com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).getMultiTaskStorage();
        if (multiTaskStorage != null) {
            multiTaskStorage.add(this);
        }
        ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).a(this.kIM);
        this.AeK.alive();
        g gVar = g.zZj;
        MultiTaskUIComponent bK = bK(0, g.eqw());
        if (bK == null) {
            AppMethodBeat.o(236576);
        } else if (bK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
            AppMethodBeat.o(236576);
            throw tVar;
        } else {
            ((MultiTaskMinusScreenUIC) bK).onCreate(bundle);
            AppMethodBeat.o(236576);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.ui.panel.a
    public final void onDestroy() {
        AppMethodBeat.i(236577);
        super.onDestroy();
        com.tencent.mm.plugin.multitask.model.a multiTaskStorage = ((PluginMultiTask) com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).getMultiTaskStorage();
        if (multiTaskStorage != null) {
            multiTaskStorage.remove(this);
        }
        ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).b(this.kIM);
        this.AeK.dead();
        g gVar = g.zZj;
        MultiTaskUIComponent bK = bK(0, g.eqw());
        if (bK == null) {
            AppMethodBeat.o(236577);
        } else if (bK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
            AppMethodBeat.o(236577);
            throw tVar;
        } else {
            ((MultiTaskMinusScreenUIC) bK).onDestroy();
            AppMethodBeat.o(236577);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC.b
    public final void a(View view, View view2, int i2, MultiTaskInfo multiTaskInfo, boolean z) {
        View view3;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(236578);
        p.h(multiTaskInfo, "taskInfo");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a.b(this.tUQ).get(MultiTaskUIC.class);
        if (MultiTaskUIC.RU(multiTaskInfo.field_type)) {
            ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(this.tUQ);
            Log.i("MicroMsg.MultiTask.MinusScreenPanel", "onGridItemClick, is TeenMode!");
            AppMethodBeat.o(236578);
            return;
        }
        crq crq = new crq();
        crq.MwD = z;
        com.tencent.mm.plugin.multitask.f.c cVar = com.tencent.mm.plugin.multitask.f.c.AgL;
        if (view2 != null) {
            view3 = view2.findViewById(R.id.fnq);
        } else {
            view3 = null;
        }
        o<String, Integer> ez = com.tencent.mm.plugin.multitask.f.c.ez(view3);
        crq.lcm = ez.first;
        if ((ez.second.intValue() & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        crq.MwF = z2;
        if ((ez.second.intValue() & 4) == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        crq.MwG = z3;
        h hVar = h.zZn;
        String str = multiTaskInfo.field_id;
        p.g(str, "taskInfo.field_id");
        crq.MwC = h.aGJ(str);
        h hVar2 = h.zZn;
        crq.MwE = h.eqA();
        com.tencent.mm.plugin.multitask.f.c cVar2 = com.tencent.mm.plugin.multitask.f.c.AgL;
        crq.AbG = com.tencent.mm.plugin.multitask.f.c.ey(view);
        crq.MwH = i2;
        if (z) {
            g gVar = g.zZj;
            MultiTaskUIComponent aGP = aGP(g.eqx());
            if (aGP == null) {
                AppMethodBeat.o(236578);
            } else if (aGP == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.SnapShotMultiTaskUIC");
                AppMethodBeat.o(236578);
                throw tVar;
            } else {
                ((SnapShotMultiTaskUIC) aGP).a(view2, multiTaskInfo, crq, (Object) new c(this, view2, multiTaskInfo, crq));
                AppMethodBeat.o(236578);
            }
        } else {
            MultiTaskUIComponent i3 = i(multiTaskInfo);
            if (i3 != null) {
                crq.Jrc = System.currentTimeMillis();
                a.C1520a.a(i3, view2, multiTaskInfo, crq);
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                ((MultiTaskUIC) com.tencent.mm.ui.component.a.b(this.tUQ).get(MultiTaskUIC.class)).l(multiTaskInfo);
                Log.i("MicroMsg.MultiTask.MinusScreenPanel", "needEnterAnim false, onGridItemClick, id:%s", multiTaskInfo.field_id);
                AppMethodBeat.o(236578);
                return;
            }
            AppMethodBeat.o(236578);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel$onGridItemClick$1$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "ui-multitask_release"})
    public static final class c implements com.tencent.mm.plugin.multitask.c.c {
        final /* synthetic */ b AeM;
        final /* synthetic */ View AeN;
        final /* synthetic */ MultiTaskInfo AeO;
        final /* synthetic */ crq AeP;

        c(b bVar, View view, MultiTaskInfo multiTaskInfo, crq crq) {
            this.AeM = bVar;
            this.AeN = view;
            this.AeO = multiTaskInfo;
            this.AeP = crq;
        }

        @Override // com.tencent.mm.plugin.multitask.c.c
        public final void RL(int i2) {
            AppMethodBeat.i(236570);
            com.tencent.f.h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.plugin.multitask.ui.panel.b.c.AnonymousClass1 */
                final /* synthetic */ c AeQ;

                {
                    this.AeQ = r1;
                }

                public final void run() {
                    AppMethodBeat.i(236568);
                    MultiTaskUIComponent i2 = this.AeQ.AeM.i(this.AeQ.AeO);
                    if (i2 != null) {
                        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                        ((MultiTaskUIC) com.tencent.mm.ui.component.a.b(this.AeQ.AeM.tUQ).get(MultiTaskUIC.class)).l(this.AeQ.AeO);
                        this.AeQ.AeP.Jrc = System.currentTimeMillis();
                        a.C1520a.a(i2, this.AeQ.AeN, this.AeQ.AeO, this.AeQ.AeP);
                        Log.i("MicroMsg.MultiTask.MinusScreenPanel", "onAnimationCancel,onGridItemClick, id:%s", this.AeQ.AeO.field_id);
                        AppMethodBeat.o(236568);
                        return;
                    }
                    AppMethodBeat.o(236568);
                }
            });
            AppMethodBeat.o(236570);
        }

        @Override // com.tencent.mm.plugin.multitask.c.c
        public final void g(Bitmap bitmap, int i2) {
            AppMethodBeat.i(236571);
            com.tencent.f.h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.plugin.multitask.ui.panel.b.c.AnonymousClass2 */
                final /* synthetic */ c AeQ;

                {
                    this.AeQ = r1;
                }

                public final void run() {
                    AppMethodBeat.i(236569);
                    MultiTaskUIComponent i2 = this.AeQ.AeM.i(this.AeQ.AeO);
                    if (i2 != null) {
                        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                        ((MultiTaskUIC) com.tencent.mm.ui.component.a.b(this.AeQ.AeM.tUQ).get(MultiTaskUIC.class)).l(this.AeQ.AeO);
                        this.AeQ.AeP.Jrc = System.currentTimeMillis();
                        a.C1520a.a(i2, this.AeQ.AeN, this.AeQ.AeO, this.AeQ.AeP);
                        Log.i("MicroMsg.MultiTask.MinusScreenPanel", "onAnimationEnd, onGridItemClick, id:%s", this.AeQ.AeO.field_id);
                        AppMethodBeat.o(236569);
                        return;
                    }
                    AppMethodBeat.o(236569);
                }
            });
            AppMethodBeat.o(236571);
        }

        @Override // com.tencent.mm.plugin.multitask.c.c
        public final void a(Bitmap bitmap, boolean z, int i2) {
        }
    }

    @Override // com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC.b
    public final void j(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(236579);
        p.h(multiTaskInfo, "taskInfo");
        MultiTaskUIComponent i2 = i(multiTaskInfo);
        if (i2 != null) {
            i2.dF(multiTaskInfo);
        }
        String str = multiTaskInfo.field_id;
        p.g(str, "taskInfo.field_id");
        aGO(str);
        Log.i("MicroMsg.MultiTask.MinusScreenPanel", "onGridItemDelete, id:%s", multiTaskInfo.field_id);
        AppMethodBeat.o(236579);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC.b
    public final void k(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(236580);
        p.h(multiTaskInfo, "taskInfo");
        MultiTaskUIComponent i2 = i(multiTaskInfo);
        if (i2 != null) {
            i2.a(multiTaskInfo);
            AppMethodBeat.o(236580);
            return;
        }
        AppMethodBeat.o(236580);
    }
}
