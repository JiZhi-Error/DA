package com.tencent.mm.plugin.taskbar;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.ListView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.model.d;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.g.a.abm;
import com.tencent.mm.plugin.taskbar.api.HeaderContainer;
import com.tencent.mm.plugin.taskbar.api.b;
import com.tencent.mm.plugin.taskbar.api.c;
import com.tencent.mm.plugin.taskbar.ui.TaskBarContainer;
import com.tencent.mm.plugin.taskbar.ui.a.e;
import com.tencent.mm.sdk.event.EventCenter;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0015\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b$J\u0015\u0010%\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b&J\b\u0010'\u001a\u00020\rH\u0016J\u0018\u0010(\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/TaskBarViewService;", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService;", "()V", "dynamicBgService", "Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBgServiceImpl;", "glSurfaceView", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "listeners", "Landroid/util/SparseArray;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "Lkotlin/collections/HashSet;", "addTaskBarEventListener", "", "type", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getBackgroundView", "Landroid/view/View;", "context", "Landroid/content/Context;", "getMyAppBrandHeaderAnimController", "Lcom/tencent/mm/plugin/taskbar/api/HeaderAnimController;", "listView", "Landroid/widget/ListView;", "headerContainer", "Lcom/tencent/mm/plugin/taskbar/api/HeaderContainer;", "getMyAppBrandHeaderContainer", "initEnableBackgroundView", "isEnableBackgroundView", "", "notifyClickTaskBarItem", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "notifyClickTaskBarItem$plugin_taskbar_release", "notifyExposeTaskBarItem", "notifyExposeTaskBarItem$plugin_taskbar_release", "notifyRemoveTaskBarItem", "notifyRemoveTaskBarItem$plugin_taskbar_release", "notifyTaskBarDataUpdated", "removeTaskBarEventListener", "Companion", "plugin-taskbar_release"})
public final class i implements c {
    public static final a Vbo = new a((byte) 0);
    private DynamicBackgroundGLSurfaceView FSg;
    private final e FSh = new e();
    final SparseArray<HashSet<c.a>> jfY = new SparseArray<>();

    static {
        AppMethodBeat.i(263577);
        AppMethodBeat.o(263577);
    }

    public i() {
        AppMethodBeat.i(238439);
        d dVar = d.gRj;
        d.a(this.FSh);
        AppMethodBeat.o(238439);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/TaskBarViewService$Companion;", "", "()V", "TAG", "", "plugin-taskbar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.taskbar.api.c
    public final HeaderContainer hn(Context context) {
        AppMethodBeat.i(238432);
        p.h(context, "context");
        TaskBarContainer taskBarContainer = new TaskBarContainer(context);
        AppMethodBeat.o(238432);
        return taskBarContainer;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.c
    public final b a(Context context, ListView listView, HeaderContainer headerContainer) {
        AppMethodBeat.i(238433);
        p.h(context, "context");
        p.h(listView, "listView");
        p.h(headerContainer, "headerContainer");
        com.tencent.mm.plugin.taskbar.ui.a aVar = new com.tencent.mm.plugin.taskbar.ui.a(context, listView, headerContainer);
        AppMethodBeat.o(238433);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.c
    public final void fuu() {
        AppMethodBeat.i(238434);
        e.fur();
        AppMethodBeat.o(238434);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.c
    public final boolean fuv() {
        AppMethodBeat.i(238435);
        boolean atB = e.atB();
        AppMethodBeat.o(238435);
        return atB;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.c
    public final View ho(Context context) {
        AppMethodBeat.i(238436);
        p.h(context, "context");
        com.tencent.mm.dynamicbackground.a.c.a(com.tencent.mm.plugin.taskbar.ui.a.d.FVe);
        if (this.FSg == null) {
            Context applicationContext = context.getApplicationContext();
            p.g(applicationContext, "context.applicationContext");
            this.FSg = new DynamicBackgroundGLSurfaceView(applicationContext, null, 2);
        }
        DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView = this.FSg;
        if (dynamicBackgroundGLSurfaceView == null) {
            p.hyc();
        }
        DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView2 = dynamicBackgroundGLSurfaceView;
        AppMethodBeat.o(238436);
        return dynamicBackgroundGLSurfaceView2;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.c
    public final void a(int i2, c.a aVar) {
        AppMethodBeat.i(238437);
        p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        HashSet<c.a> hashSet = this.jfY.get(i2);
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        hashSet.add(aVar);
        this.jfY.put(i2, hashSet);
        AppMethodBeat.o(238437);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.c
    public final void b(int i2, c.a aVar) {
        AppMethodBeat.i(238438);
        p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        HashSet<c.a> hashSet = this.jfY.get(i2);
        if (hashSet != null) {
            hashSet.remove(aVar);
            AppMethodBeat.o(238438);
            return;
        }
        AppMethodBeat.o(238438);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.c
    public final void hWP() {
        AppMethodBeat.i(263576);
        EventCenter.instance.publish(new abm());
        AppMethodBeat.o(263576);
    }
}
