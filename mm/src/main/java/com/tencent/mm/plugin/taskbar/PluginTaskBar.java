package com.tencent.mm.plugin.taskbar;

import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.c;
import com.tencent.mm.plugin.taskbar.h;
import com.tencent.mm.plugin.taskbar.ui.section.g;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001FB\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ8\u0010\u001c\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bJ\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\"0!H\u0016J\u0012\u0010#\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0014H\u0016J\u0012\u0010'\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u0015\u001a\u00020\bJ\u0012\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020)0,2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\b\u0010.\u001a\u00020\u0014H\u0016J\b\u0010/\u001a\u00020\bH\u0016J\u0015\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020)H\u0000¢\u0006\u0002\b2J\u0015\u00103\u001a\u00020\u00142\u0006\u00101\u001a\u00020)H\u0000¢\u0006\u0002\b4J\u0015\u00105\u001a\u00020\u00142\u0006\u00101\u001a\u00020)H\u0000¢\u0006\u0002\b6J\u0012\u00107\u001a\u00020\u00142\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020\u0014H\u0016J\"\u0010;\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0017H\u0016J&\u0010?\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\b2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00140BH\u0002J2\u0010C\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010D\u001a\u00020=J@\u0010E\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010D\u001a\u00020=H\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/PluginTaskBar;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/taskbar/IPluginTaskBar;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Landroid/arch/lifecycle/ViewModelStoreOwner;", "()V", "TAG", "", "taskBarStorage", "Lcom/tencent/mm/plugin/taskbar/TaskBarStorage;", "getTaskBarStorage", "()Lcom/tencent/mm/plugin/taskbar/TaskBarStorage;", "setTaskBarStorage", "(Lcom/tencent/mm/plugin/taskbar/TaskBarStorage;)V", "taskBarViewService", "Lcom/tencent/mm/plugin/taskbar/TaskBarViewService;", "viewModelStore", "Landroid/arch/lifecycle/ViewModelStore;", "addOrUpdateTaskInfo", "", "id", "type", "", "showData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "data", "", "addOrUpdateTaskInfoByBitmap", "bitmap", "Landroid/graphics/Bitmap;", "addToMultiTask", "collectDatabaseFactory", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "execute", "getInnerTaskInfoById", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getTaskInfoById", "getTaskInfoByType", "", "getViewModelStore", "installed", "name", "notifyClickTaskBarItem", "multiTaskInfo", "notifyClickTaskBarItem$plugin_taskbar_release", "notifyExposeTaskBarItem", "notifyExposeTaskBarItem$plugin_taskbar_release", "notifyRemoveTaskBarItem", "notifyRemoveTaskBarItem$plugin_taskbar_release", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "removeTaskInfo", "isNotify", "", "scene", "saveBitmapToImageProtected", "path", "callback", "Lkotlin/Function0;", "updateTaskInfo", "updateBitmapOnly", "updateTaskInfoByBitmap", "Companion", "plugin-taskbar_release"})
public final class PluginTaskBar extends com.tencent.mm.kernel.b.f implements ViewModelStoreOwner, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, d {
    public static final a FRW = new a((byte) 0);
    private final ViewModelStore FE = new ViewModelStore();
    private h FRU;
    private final i FRV = new i();
    private final String TAG = "MicroMsg.TaskBar.PluginTaskBar";

    static {
        AppMethodBeat.i(238420);
        AppMethodBeat.o(238420);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback"})
    public static final class d<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ PluginTaskBar FRX;

        d(PluginTaskBar pluginTaskBar) {
            this.FRX = pluginTaskBar;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            boolean z;
            AppMethodBeat.i(238398);
            Bundle bundle = (Bundle) obj;
            String str = this.FRX.TAG;
            StringBuilder sb = new StringBuilder("removeTaskInfo invoker callback result:");
            if (bundle != null) {
                z = bundle.getBoolean("result");
            } else {
                z = false;
            }
            Log.i(str, sb.append(z).toString());
            AppMethodBeat.o(238398);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback", "com/tencent/mm/plugin/taskbar/PluginTaskBar$addOrUpdateTaskInfoByBitmap$3$1"})
    static final class e<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ PluginTaskBar FRX;
        final /* synthetic */ Bundle Vbh;

        e(PluginTaskBar pluginTaskBar, Bundle bundle) {
            this.FRX = pluginTaskBar;
            this.Vbh = bundle;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            boolean z;
            AppMethodBeat.i(263567);
            Bundle bundle = (Bundle) obj;
            String str = this.FRX.TAG;
            StringBuilder sb = new StringBuilder("invoker callback result:");
            if (bundle != null) {
                z = bundle.getBoolean("result");
            } else {
                z = false;
            }
            Log.i(str, sb.append(z).toString());
            AppMethodBeat.o(263567);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        public static final f Vbj = new f();

        static {
            AppMethodBeat.i(263568);
            AppMethodBeat.o(263568);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback", "com/tencent/mm/plugin/taskbar/PluginTaskBar$updateTaskInfoByBitmap$3$1"})
    static final class i<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ PluginTaskBar FRX;
        final /* synthetic */ Bundle Vbh;

        i(PluginTaskBar pluginTaskBar, Bundle bundle) {
            this.FRX = pluginTaskBar;
            this.Vbh = bundle;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            boolean z;
            AppMethodBeat.i(263572);
            Bundle bundle = (Bundle) obj;
            String str = this.FRX.TAG;
            StringBuilder sb = new StringBuilder("invoker callback result:");
            if (bundle != null) {
                z = bundle.getBoolean("result");
            } else {
                z = false;
            }
            Log.i(str, sb.append(z).toString());
            AppMethodBeat.o(263572);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends q implements kotlin.g.a.a<x> {
        public static final j Vbl = new j();

        static {
            AppMethodBeat.i(263573);
            AppMethodBeat.o(263573);
        }

        j() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public PluginTaskBar() {
        AppMethodBeat.i(238419);
        AppMethodBeat.o(238419);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/PluginTaskBar$Companion;", "", "()V", "ADD_TYPE_ADD", "", "ADD_TYPE_UPDATE", "plugin-taskbar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final h getTaskBarStorage() {
        return this.FRU;
    }

    public final void setTaskBarStorage(h hVar) {
        this.FRU = hVar;
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void configure(com.tencent.mm.kernel.b.g gVar) {
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void installed() {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(238400);
        if (gVar != null) {
            if (gVar.aBb()) {
                com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.taskbar.api.c.class, this.FRV);
                com.tencent.mm.plugin.taskbar.ui.a.b bVar = com.tencent.mm.plugin.taskbar.ui.a.b.FVa;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                com.tencent.mm.plugin.taskbar.ui.a.b.init(context);
            }
            AppMethodBeat.o(238400);
            return;
        }
        AppMethodBeat.o(238400);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public final String name() {
        return "PluginTaskBar";
    }

    public final void notifyClickTaskBarItem$plugin_taskbar_release(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(238401);
        p.h(multiTaskInfo, "multiTaskInfo");
        i iVar = this.FRV;
        p.h(multiTaskInfo, "multiTaskInfo");
        Log.i("MicroMsg.TaskBarViewService", "notifyClick " + multiTaskInfo.erh().title + ' ' + multiTaskInfo.field_id + ' ' + multiTaskInfo.field_type);
        HashSet<c.a> hashSet = iVar.jfY.get(multiTaskInfo.field_type);
        if (hashSet != null) {
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().b(multiTaskInfo);
            }
            AppMethodBeat.o(238401);
            return;
        }
        AppMethodBeat.o(238401);
    }

    public final void notifyExposeTaskBarItem$plugin_taskbar_release(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(238402);
        p.h(multiTaskInfo, "multiTaskInfo");
        i iVar = this.FRV;
        p.h(multiTaskInfo, "multiTaskInfo");
        HashSet<c.a> hashSet = iVar.jfY.get(multiTaskInfo.field_type);
        if (hashSet != null) {
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a(multiTaskInfo);
            }
            AppMethodBeat.o(238402);
            return;
        }
        AppMethodBeat.o(238402);
    }

    public final void notifyRemoveTaskBarItem$plugin_taskbar_release(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(238403);
        p.h(multiTaskInfo, "multiTaskInfo");
        i iVar = this.FRV;
        p.h(multiTaskInfo, "multiTaskInfo");
        Log.i("MicroMsg.TaskBarViewService", "notifyRemoveTaskBarItem " + multiTaskInfo.erh().title + ' ' + multiTaskInfo.field_id + ' ' + multiTaskInfo.field_type);
        HashSet<c.a> hashSet = iVar.jfY.get(multiTaskInfo.field_type);
        if (hashSet != null) {
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().c(multiTaskInfo);
            }
            AppMethodBeat.o(238403);
            return;
        }
        AppMethodBeat.o(238403);
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void dependency() {
        AppMethodBeat.i(238404);
        super.dependency();
        if (MMApplicationContext.isMainProcess()) {
            dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        }
        AppMethodBeat.o(238404);
    }

    @Override // com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(238405);
        Log.i(this.TAG, "onAccountRelease");
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("TaskBarInfo".hashCode()), c.FRY);
        AppMethodBeat.o(238405);
        return hashMap;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    static final class c implements h.b {
        public static final c FRY = new c();

        static {
            AppMethodBeat.i(238397);
            AppMethodBeat.o(238397);
        }

        c() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(238396);
            h.a aVar = h.FSe;
            String[] strArr = h.SQL_CREATE;
            AppMethodBeat.o(238396);
            return strArr;
        }
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(238406);
        Log.i(this.TAG, "onAccountInitialized");
        if (this.FRU == null) {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            com.tencent.mm.storagebase.h dataDB = aAh.getDataDB();
            p.g(dataDB, "MMKernel.storage().dataDB");
            this.FRU = new h(dataDB);
        }
        AppMethodBeat.o(238406);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(238407);
        Log.i(this.TAG, "onAccountRelease");
        this.FRU = null;
        AppMethodBeat.o(238407);
    }

    public final void addToMultiTask(String str) {
        AppMethodBeat.i(238408);
        p.h(str, "id");
        MultiTaskInfo innerTaskInfoById = getInnerTaskInfoById(str);
        if (innerTaskInfoById != null) {
            f fVar = f.FSa;
            String aGJ = f.aGJ(str);
            com.tencent.mm.plugin.multitask.h hVar = com.tencent.mm.plugin.multitask.h.zZn;
            s.nw(aGJ, com.tencent.mm.plugin.multitask.h.aGJ(str));
            com.tencent.mm.plugin.multitask.model.a multiTaskStorage = ((PluginMultiTask) com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).getMultiTaskStorage();
            if (multiTaskStorage == null) {
                AppMethodBeat.o(238408);
            } else if (multiTaskStorage.aGM(str) == null) {
                multiTaskStorage.h(innerTaskInfoById);
                com.tencent.mm.plugin.multitask.d.a aVar = com.tencent.mm.plugin.multitask.d.a.AbZ;
                com.tencent.mm.plugin.multitask.d.a.a(innerTaskInfoById, 3, 2, "", "");
                AppMethodBeat.o(238408);
            } else {
                multiTaskStorage.a(innerTaskInfoById, new String[0]);
                com.tencent.mm.plugin.multitask.d.a aVar2 = com.tencent.mm.plugin.multitask.d.a.AbZ;
                com.tencent.mm.plugin.multitask.d.a.a(innerTaskInfoById, 3, 1, "", "");
                AppMethodBeat.o(238408);
            }
        } else {
            AppMethodBeat.o(238408);
        }
    }

    @Override // com.tencent.mm.plugin.taskbar.d
    public final void removeTaskInfo(String str, boolean z, int i2) {
        AppMethodBeat.i(238409);
        Log.i(this.TAG, "removeTaskInfo " + str + ' ' + z + ' ' + i2);
        if (!MMApplicationContext.isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putInt("scene", i2);
            com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, b.class, new d(this));
            AppMethodBeat.o(238409);
        } else if (!com.tencent.mm.kernel.g.aAc()) {
            AppMethodBeat.o(238409);
        } else if (str != null) {
            f fVar = f.FSa;
            String aGJ = f.aGJ(str);
            if (s.YS(aGJ)) {
                s.deleteFile(aGJ);
            }
            h hVar = this.FRU;
            if (hVar != null) {
                p.h(str, "id");
                MultiTaskInfo aGM = hVar.aGM(str);
                if (aGM != null) {
                    Log.i("MicroMsg.TaskBarStorage", ShareConstants.RES_DEL_TITLE + aGM.field_type + ' ' + aGM.field_id + ' ' + aGM.erh().title + ' ' + i2);
                    hVar.delete(aGM, false, new String[0]);
                    if (z) {
                        h.b bVar = new h.b();
                        p.h(aGM, "<set-?>");
                        bVar.Agu = aGM;
                        bVar.FSf = i2;
                        hVar.doNotify(MStorageEventData.EventType.SINGLE, 5, bVar);
                    }
                    AppMethodBeat.o(238409);
                    return;
                }
                AppMethodBeat.o(238409);
                return;
            }
            AppMethodBeat.o(238409);
        } else {
            AppMethodBeat.o(238409);
        }
    }

    private final void saveBitmapToImageProtected(Bitmap bitmap, String str, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(263574);
        com.tencent.f.h.RTc.aY(new g(this, bitmap, str, aVar));
        AppMethodBeat.o(263574);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ PluginTaskBar FRX;
        final /* synthetic */ Bitmap cKG;
        final /* synthetic */ kotlin.g.a.a ihE;
        final /* synthetic */ String lCM;

        g(PluginTaskBar pluginTaskBar, Bitmap bitmap, String str, kotlin.g.a.a aVar) {
            this.FRX = pluginTaskBar;
            this.cKG = bitmap;
            this.lCM = str;
            this.ihE = aVar;
        }

        public final void run() {
            AppMethodBeat.i(263569);
            try {
                BitmapUtil.saveBitmapToImage(this.cKG, 100, Bitmap.CompressFormat.JPEG, this.lCM, false);
            } catch (Throwable th) {
                Log.e(this.FRX.TAG, "save bitmap failed! " + this.lCM, th);
            } finally {
                this.ihE.invoke();
                AppMethodBeat.o(263569);
            }
        }
    }

    @Override // com.tencent.mm.plugin.taskbar.d
    public final void addOrUpdateTaskInfoByBitmap(String str, int i2, cru cru, Bitmap bitmap, byte[] bArr) {
        byte[] bArr2;
        String str2 = null;
        AppMethodBeat.i(238411);
        Log.i(this.TAG, "addTaskInfoByBitmap id:" + str + " type:" + i2 + " bitmap:" + (bitmap != null ? Integer.valueOf(bitmap.getByteCount()) : null));
        if (str == null) {
            AppMethodBeat.o(238411);
        } else if (!MMApplicationContext.isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.putInt("addType", 1);
            bundle.putString("id", str);
            bundle.putInt("type", i2);
            if (cru != null) {
                bArr2 = cru.toByteArray();
            } else {
                bArr2 = null;
            }
            bundle.putByteArray("showData", bArr2);
            bundle.putByteArray("data", bArr);
            if (bitmap != null) {
                z.f fVar = new z.f();
                StringBuilder sb = new StringBuilder();
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    str2 = externalCacheDir.getAbsolutePath();
                }
                fVar.SYG = (T) sb.append(str2).append("taskbar").append(str).toString();
                if (s.YS(fVar.SYG)) {
                    s.deleteFile(fVar.SYG);
                }
                saveBitmapToImageProtected(bitmap, fVar.SYG, new b(fVar, this, str, bundle));
                AppMethodBeat.o(238411);
                return;
            }
            com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, a.class, new e(this, bundle));
            AppMethodBeat.o(238411);
        } else if (!com.tencent.mm.kernel.g.aAc()) {
            AppMethodBeat.o(238411);
        } else {
            if (bitmap != null) {
                f fVar2 = f.FSa;
                String aGJ = f.aGJ(str);
                if (s.YS(aGJ)) {
                    s.deleteFile(aGJ);
                }
                saveBitmapToImageProtected(bitmap, aGJ, f.Vbj);
                g.a aVar = com.tencent.mm.plugin.taskbar.ui.section.g.FVL;
                if (g.a.axi(i2)) {
                    f fVar3 = f.FSa;
                    com.tencent.mm.av.a.a.c cVar = e.Vbn;
                    p.g(cVar, "SNAPSHOT_LOADER_OPTION");
                    String f2 = f.f(aGJ, cVar);
                    com.tencent.mm.av.q.bcV().OR(f2);
                    com.tencent.mm.av.q.bcV().h(f2, bitmap);
                }
            }
            addOrUpdateTaskInfo(str, i2, cru, bArr);
            AppMethodBeat.o(238411);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004d, code lost:
        if (r0 == null) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addOrUpdateTaskInfo(java.lang.String r6, int r7, com.tencent.mm.protocal.protobuf.cru r8, byte[] r9) {
        /*
        // Method dump skipped, instructions count: 153
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.taskbar.PluginTaskBar.addOrUpdateTaskInfo(java.lang.String, int, com.tencent.mm.protocal.protobuf.cru, byte[]):void");
    }

    @Override // com.tencent.mm.plugin.taskbar.d
    public final void updateTaskInfoByBitmap(String str, int i2, cru cru, Bitmap bitmap, byte[] bArr, boolean z) {
        byte[] bArr2;
        String str2 = null;
        AppMethodBeat.i(238413);
        Log.i(this.TAG, "updateTaskInfoByBitmap id:" + str + " type:" + i2 + " bitmap:" + (bitmap != null ? Integer.valueOf(bitmap.getByteCount()) : null) + " updateBitmapOnly:" + z);
        if (str == null) {
            AppMethodBeat.o(238413);
        } else if (!MMApplicationContext.isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.putInt("addType", 2);
            bundle.putString("id", str);
            bundle.putInt("type", i2);
            if (cru != null) {
                bArr2 = cru.toByteArray();
            } else {
                bArr2 = null;
            }
            bundle.putByteArray("showData", bArr2);
            bundle.putByteArray("data", bArr);
            bundle.putBoolean("updateBitmapOnly", z);
            if (bitmap != null) {
                z.f fVar = new z.f();
                StringBuilder sb = new StringBuilder();
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    str2 = externalCacheDir.getAbsolutePath();
                }
                fVar.SYG = (T) sb.append(str2).append("taskbar").append(str).toString();
                if (s.YS(fVar.SYG)) {
                    s.deleteFile(fVar.SYG);
                }
                saveBitmapToImageProtected(bitmap, fVar.SYG, new h(fVar, this, str, bundle));
                AppMethodBeat.o(238413);
                return;
            }
            com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, a.class, new i(this, bundle));
            AppMethodBeat.o(238413);
        } else if (!com.tencent.mm.kernel.g.aAc()) {
            AppMethodBeat.o(238413);
        } else {
            if (bitmap != null) {
                f fVar2 = f.FSa;
                String aGJ = f.aGJ(str);
                if (s.YS(aGJ)) {
                    s.deleteFile(aGJ);
                }
                saveBitmapToImageProtected(bitmap, aGJ, j.Vbl);
                g.a aVar = com.tencent.mm.plugin.taskbar.ui.section.g.FVL;
                if (g.a.axi(i2)) {
                    f fVar3 = f.FSa;
                    com.tencent.mm.av.a.a.c cVar = e.Vbn;
                    p.g(cVar, "SNAPSHOT_LOADER_OPTION");
                    com.tencent.mm.av.q.bcV().h(f.f(aGJ, cVar), bitmap);
                }
            }
            updateTaskInfo(str, i2, cru, bArr, z);
            AppMethodBeat.o(238413);
        }
    }

    public final void updateTaskInfo(String str, int i2, cru cru, byte[] bArr, boolean z) {
        AppMethodBeat.i(238414);
        p.h(str, "id");
        MultiTaskInfo innerTaskInfoById = getInnerTaskInfoById(str);
        if (innerTaskInfoById != null) {
            Log.i(this.TAG, "updateTaskInfo id:" + str + " type:" + i2 + " updateBitmapOnly:" + z);
            innerTaskInfoById.field_updateTime = System.currentTimeMillis();
            if (!z) {
                innerTaskInfoById.field_showData = cru;
                if (bArr != null) {
                    innerTaskInfoById.field_data = bArr;
                }
            }
            h hVar = this.FRU;
            if (hVar != null) {
                hVar.a(innerTaskInfoById, new String[0]);
                AppMethodBeat.o(238414);
                return;
            }
            AppMethodBeat.o(238414);
            return;
        }
        AppMethodBeat.o(238414);
    }

    @Override // com.tencent.mm.plugin.taskbar.d
    public final List<MultiTaskInfo> getTaskInfoByType(int i2) {
        AppMethodBeat.i(238415);
        h hVar = this.FRU;
        if (hVar != null) {
            Cursor rawQuery = hVar.db.rawQuery("SELECT * FROM TaskBarInfo WHERE type = ? ORDER BY updateTime DESC;", new String[]{String.valueOf(i2)});
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                MultiTaskInfo multiTaskInfo = new MultiTaskInfo();
                multiTaskInfo.convertFrom(rawQuery);
                arrayList.add(multiTaskInfo);
            }
            rawQuery.close();
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(238415);
            return arrayList2;
        }
        ArrayList arrayList3 = new ArrayList();
        AppMethodBeat.o(238415);
        return arrayList3;
    }

    @Override // com.tencent.mm.plugin.taskbar.d
    public final MultiTaskInfo getTaskInfoById(String str) {
        AppMethodBeat.i(238416);
        p.h(str, "id");
        if (MMApplicationContext.isMainProcess()) {
            MultiTaskInfo innerTaskInfoById = getInnerTaskInfoById(str);
            AppMethodBeat.o(238416);
            return innerTaskInfoById;
        }
        AppMethodBeat.o(238416);
        return null;
    }

    public final MultiTaskInfo getInnerTaskInfoById(String str) {
        AppMethodBeat.i(238418);
        p.h(str, "id");
        h hVar = this.FRU;
        if (hVar != null) {
            MultiTaskInfo aGM = hVar.aGM(str);
            AppMethodBeat.o(238418);
            return aGM;
        }
        AppMethodBeat.o(238418);
        return null;
    }

    @Override // android.arch.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        return this.FE;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/taskbar/PluginTaskBar$addOrUpdateTaskInfoByBitmap$2$1"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ PluginTaskBar FRX;
        final /* synthetic */ z.f UJE;
        final /* synthetic */ Bundle Vbh;
        final /* synthetic */ String pAg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(z.f fVar, PluginTaskBar pluginTaskBar, String str, Bundle bundle) {
            super(0);
            this.UJE = fVar;
            this.FRX = pluginTaskBar;
            this.pAg = str;
            this.Vbh = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(263566);
            this.Vbh.putString("path", this.UJE.SYG);
            com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, this.Vbh, a.class, new com.tencent.mm.ipcinvoker.d<ResultType>(this) {
                /* class com.tencent.mm.plugin.taskbar.PluginTaskBar.b.AnonymousClass1 */
                final /* synthetic */ b Vbi;

                {
                    this.Vbi = r1;
                }

                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Object obj) {
                    boolean z;
                    AppMethodBeat.i(263565);
                    Bundle bundle = (Bundle) obj;
                    String str = this.Vbi.FRX.TAG;
                    StringBuilder sb = new StringBuilder("invoker callback result:");
                    if (bundle != null) {
                        z = bundle.getBoolean("result");
                    } else {
                        z = false;
                    }
                    Log.i(str, sb.append(z).toString());
                    AppMethodBeat.o(263565);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(263566);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/taskbar/PluginTaskBar$updateTaskInfoByBitmap$2$1"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ PluginTaskBar FRX;
        final /* synthetic */ z.f UJE;
        final /* synthetic */ Bundle Vbh;
        final /* synthetic */ String pAg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(z.f fVar, PluginTaskBar pluginTaskBar, String str, Bundle bundle) {
            super(0);
            this.UJE = fVar;
            this.FRX = pluginTaskBar;
            this.pAg = str;
            this.Vbh = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(263571);
            this.Vbh.putString("path", this.UJE.SYG);
            com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, this.Vbh, a.class, new com.tencent.mm.ipcinvoker.d<ResultType>(this) {
                /* class com.tencent.mm.plugin.taskbar.PluginTaskBar.h.AnonymousClass1 */
                final /* synthetic */ h Vbk;

                {
                    this.Vbk = r1;
                }

                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Object obj) {
                    boolean z;
                    AppMethodBeat.i(263570);
                    Bundle bundle = (Bundle) obj;
                    String str = this.Vbk.FRX.TAG;
                    StringBuilder sb = new StringBuilder("invoker callback result:");
                    if (bundle != null) {
                        z = bundle.getBoolean("result");
                    } else {
                        z = false;
                    }
                    Log.i(str, sb.append(z).toString());
                    AppMethodBeat.o(263570);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(263571);
            return xVar;
        }
    }
}
