package com.tencent.mm.plugin.multitask;

import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.model.a;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 W2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002WXB\u0005¢\u0006\u0002\u0010\u0006J4\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J>\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0014\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020#0\"H\u0016J\u0012\u0010$\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0014H\u0016J\u0012\u0010(\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J \u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u0017J\u0010\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u0015\u001a\u00020\bJ\b\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020\u00142\b\u00101\u001a\u0004\u0018\u000102H\u0016J\"\u00103\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u0017H\u0016J\u0012\u00104\u001a\u0004\u0018\u00010-2\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0016\u00105\u001a\b\u0012\u0004\u0012\u00020-062\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u00107\u001a\u00020\u0012H\u0016J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020-H\u0016J\u0010\u0010;\u001a\u0002092\u0006\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010<\u001a\u00020\u0014H\u0016J\b\u0010=\u001a\u000209H\u0016J\b\u0010>\u001a\u000209H\u0016J\b\u0010?\u001a\u00020\bH\u0016J\u0012\u0010@\u001a\u00020\u00142\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020\u0014H\u0016J\"\u0010D\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0010\u0010E\u001a\f\u0012\u0006\b\u0001\u0012\u00020G\u0018\u00010FH\u0016J\u0012\u0010H\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010I\u001a\u00020\u00142\b\u0010:\u001a\u0004\u0018\u00010-2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0018\u0010J\u001a\u00020\u00142\u0006\u0010K\u001a\u00020\u00172\b\u0010L\u001a\u0004\u0018\u00010\u001dJ\u001a\u0010M\u001a\u00020\u00142\u0006\u0010K\u001a\u00020\u00172\b\u0010N\u001a\u0004\u0018\u00010\u001dH\u0016J \u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010Q\u001a\u00020\u00142\b\u0010R\u001a\u0004\u0018\u00010SJ(\u0010T\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ4\u0010U\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J*\u0010V\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0002X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, hxF = {"Lcom/tencent/mm/plugin/multitask/PluginMultiTask;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/multitask/IPluginMultiTask;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Landroid/arch/lifecycle/ViewModelStoreOwner;", "()V", "TAG", "", "appForegroundListener", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "multiTaskStorage", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskStorage;", "getMultiTaskStorage", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskStorage;", "setMultiTaskStorage", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskStorage;)V", "viewModelStore", "Landroid/arch/lifecycle/ViewModelStore;", "addTaskInfo", "", "id", "type", "", "showData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "data", "", "reportdata", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "addTaskInfoByBitmap", "bitmap", "Landroid/graphics/Bitmap;", "collectDatabaseFactory", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "execute", "getInnerMultiTaskItemPosition", "curPos", "way", "getInnerTaskInfoById", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getMultiTaskFloatBallPosition", "Landroid/graphics/Point;", "getMultiTaskInfoList", "callback", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "getMultiTaskItemPosition", "getTaskInfoById", "getTaskInfoByType", "", "getViewModelStore", "hasTaskInfo", "", "multiTaskInfo", "hasTaskInfoById", "installed", "isDataEmpty", "isMultiTaskMode", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "registerMultiTaskUIC", "clazz", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "removeTaskInfoAndCoverImg", "reportAddTaskInfo", "reportInnerMultiTaskInfo", "reportType", "multiTaskReportData", "reportMultiTaskInfo", "reportInfo", "sendMultiTaskEvent", "eventType", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/multitask/PluginMultiTask$OnMultiTaskUICListener;", "updateTaskInfo", "updateTaskInfoByBitmap", "updateTaskInfoByTitle", "Companion", "OnMultiTaskUICListener", "plugin-multitask_release"})
public final class PluginMultiTask extends com.tencent.mm.kernel.b.f implements ViewModelStoreOwner, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, d {
    private static final HashMap<Integer, Class<? extends MultiTaskUIComponent>> zZs = new HashMap<>();
    private static b zZt;
    public static final a zZu = new a((byte) 0);
    private final ViewModelStore FE = new ViewModelStore();
    private final String TAG = "MicroMsg.MultiTask.PluginMultiTask";
    private final o.a appForegroundListener = new d(this);
    private com.tencent.mm.plugin.multitask.model.a zZr;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH&¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/multitask/PluginMultiTask$OnMultiTaskUICListener;", "", "getMultiTaskItemPosition", "", "id", "curPos", "", "way", "hasCurrentMultiInfo", "", "isDataEmpty", "markWechatForeground", "", "foreground", "plugin-multitask_release"})
    public interface b {
        boolean aGK(String str);

        String getMultiTaskItemPosition(String str, int i2, int i3);

        boolean isDataEmpty();

        void jK(boolean z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback"})
    static final class c<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ PluginMultiTask zZv;

        c(PluginMultiTask pluginMultiTask) {
            this.zZv = pluginMultiTask;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            boolean z;
            AppMethodBeat.i(200307);
            Bundle bundle = (Bundle) obj;
            String str = this.zZv.TAG;
            StringBuilder sb = new StringBuilder("addTaskInfoByBitmap invoker callback result:");
            if (bundle != null) {
                z = bundle.getBoolean("result");
            } else {
                z = false;
            }
            Log.i(str, sb.append(z).toString());
            AppMethodBeat.o(200307);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel;", "onCallback"})
    static final class f<T> implements com.tencent.mm.ipcinvoker.d<MultiTaskListParcel> {
        final /* synthetic */ com.tencent.mm.plugin.multitask.c.a zZx;

        f(com.tencent.mm.plugin.multitask.c.a aVar) {
            this.zZx = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.tencent.mm.plugin.multitask.c.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(MultiTaskListParcel multiTaskListParcel) {
            List<? extends MultiTaskInfo> list;
            AppMethodBeat.i(200312);
            MultiTaskListParcel multiTaskListParcel2 = multiTaskListParcel;
            if (multiTaskListParcel2 == null || multiTaskListParcel2.zZk == null || (list = multiTaskListParcel2.zZk) == null || list.isEmpty()) {
                if (this.zZx != null) {
                    this.zZx.bC(new ArrayList());
                }
            } else if (this.zZx != null) {
                this.zZx.bC(multiTaskListParcel2.zZk);
                AppMethodBeat.o(200312);
                return;
            }
            AppMethodBeat.o(200312);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback"})
    static final class g<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ PluginMultiTask zZv;

        g(PluginMultiTask pluginMultiTask) {
            this.zZv = pluginMultiTask;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            boolean z;
            AppMethodBeat.i(200313);
            Bundle bundle = (Bundle) obj;
            String str = this.zZv.TAG;
            StringBuilder sb = new StringBuilder("reportMultiTaskInfo invoker callback result:");
            if (bundle != null) {
                z = bundle.getBoolean("result");
            } else {
                z = false;
            }
            Log.i(str, sb.append(z).toString());
            AppMethodBeat.o(200313);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback"})
    static final class h<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ PluginMultiTask zZv;

        h(PluginMultiTask pluginMultiTask) {
            this.zZv = pluginMultiTask;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            boolean z;
            AppMethodBeat.i(200314);
            Bundle bundle = (Bundle) obj;
            String str = this.zZv.TAG;
            StringBuilder sb = new StringBuilder("hideMultiTaskUIC invoker callback result:");
            if (bundle != null) {
                z = bundle.getBoolean("result");
            } else {
                z = false;
            }
            Log.i(str, sb.append(z).toString());
            AppMethodBeat.o(200314);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback", "com/tencent/mm/plugin/multitask/PluginMultiTask$updateTaskInfoByBitmap$1$3"})
    static final class i<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ String pAg;
        final /* synthetic */ int zZA;
        final /* synthetic */ byte[] zZB;
        final /* synthetic */ PluginMultiTask zZv;
        final /* synthetic */ cru zZy;
        final /* synthetic */ Bitmap zZz;

        i(PluginMultiTask pluginMultiTask, cru cru, Bitmap bitmap, String str, int i2, byte[] bArr) {
            this.zZv = pluginMultiTask;
            this.zZy = cru;
            this.zZz = bitmap;
            this.pAg = str;
            this.zZA = i2;
            this.zZB = bArr;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            boolean z;
            AppMethodBeat.i(200315);
            Bundle bundle = (Bundle) obj;
            String str = this.zZv.TAG;
            StringBuilder sb = new StringBuilder("updateTaskInfoByBitmap invoker callback result:");
            if (bundle != null) {
                z = bundle.getBoolean("result");
            } else {
                z = false;
            }
            Log.i(str, sb.append(z).toString());
            AppMethodBeat.o(200315);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback", "com/tencent/mm/plugin/multitask/PluginMultiTask$updateTaskInfoByTitle$1$1"})
    static final class j<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ String pAg;
        final /* synthetic */ int zZA;
        final /* synthetic */ byte[] zZB;
        final /* synthetic */ PluginMultiTask zZv;
        final /* synthetic */ cru zZy;

        j(PluginMultiTask pluginMultiTask, String str, int i2, cru cru, byte[] bArr) {
            this.zZv = pluginMultiTask;
            this.pAg = str;
            this.zZA = i2;
            this.zZy = cru;
            this.zZB = bArr;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            boolean z;
            AppMethodBeat.i(200316);
            Bundle bundle = (Bundle) obj;
            String str = this.zZv.TAG;
            StringBuilder sb = new StringBuilder("updateTaskInfoByTitle invoker callback result:");
            if (bundle != null) {
                z = bundle.getBoolean("result");
            } else {
                z = false;
            }
            Log.i(str, sb.append(z).toString());
            AppMethodBeat.o(200316);
        }
    }

    public PluginMultiTask() {
        AppMethodBeat.i(200342);
        AppMethodBeat.o(200342);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002RA\u0010\u0003\u001a2\u0012\u0004\u0012\u00020\u0005\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00060\u0004j\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0006`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/multitask/PluginMultiTask$Companion;", "", "()V", "ItemSelectors", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "Lkotlin/collections/HashMap;", "getItemSelectors", "()Ljava/util/HashMap;", "mListener", "Lcom/tencent/mm/plugin/multitask/PluginMultiTask$OnMultiTaskUICListener;", "getMListener", "()Lcom/tencent/mm/plugin/multitask/PluginMultiTask$OnMultiTaskUICListener;", "setMListener", "(Lcom/tencent/mm/plugin/multitask/PluginMultiTask$OnMultiTaskUICListener;)V", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(200343);
        AppMethodBeat.o(200343);
    }

    public final com.tencent.mm.plugin.multitask.model.a getMultiTaskStorage() {
        return this.zZr;
    }

    public final void setMultiTaskStorage(com.tencent.mm.plugin.multitask.model.a aVar) {
        this.zZr = aVar;
    }

    public final void setListener(b bVar) {
        zZt = bVar;
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void configure(com.tencent.mm.kernel.b.g gVar) {
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void installed() {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public final String name() {
        return "PluginMultiTask";
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void dependency() {
    }

    @Override // com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(200317);
        Log.i(this.TAG, "onAccountRelease");
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("MultiTaskInfo".hashCode()), e.zZw);
        AppMethodBeat.o(200317);
        return hashMap;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    static final class e implements h.b {
        public static final e zZw = new e();

        static {
            AppMethodBeat.i(200311);
            AppMethodBeat.o(200311);
        }

        e() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(200310);
            a.C1519a aVar = com.tencent.mm.plugin.multitask.model.a.AbX;
            String[] dax = com.tencent.mm.plugin.multitask.model.a.dax();
            AppMethodBeat.o(200310);
            return dax;
        }
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(200318);
        Log.i(this.TAG, "onAccountRelease");
        this.zZr = null;
        this.appForegroundListener.dead();
        zZt = null;
        AppMethodBeat.o(200318);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(200319);
        if (this.zZr == null) {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            com.tencent.mm.storagebase.h dataDB = aAh.getDataDB();
            p.g(dataDB, "MMKernel.storage().dataDB");
            this.zZr = new com.tencent.mm.plugin.multitask.model.a(dataDB);
        }
        this.appForegroundListener.alive();
        AppMethodBeat.o(200319);
    }

    @Override // com.tencent.mm.plugin.multitask.d
    public final void getMultiTaskInfoList(com.tencent.mm.plugin.multitask.c.a aVar) {
        ArrayList arrayList;
        AppMethodBeat.i(200320);
        Log.i(this.TAG, "getMultiTaskInfoList");
        if (!MMApplicationContext.isMainProcess()) {
            XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, b.class, new f(aVar));
            AppMethodBeat.o(200320);
        } else if (aVar != null) {
            com.tencent.mm.plugin.multitask.model.a aVar2 = this.zZr;
            if (aVar2 != null) {
                arrayList = aVar2.eri();
            } else {
                arrayList = new ArrayList();
            }
            aVar.bC(arrayList);
            AppMethodBeat.o(200320);
        } else {
            AppMethodBeat.o(200320);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.d
    public final void registerMultiTaskUIC(int i2, Class<? extends MultiTaskUIComponent> cls) {
        AppMethodBeat.i(200321);
        Log.i(this.TAG, "registerMultiTaskUIC type:" + i2 + " clazzUic:" + cls);
        if (MMApplicationContext.isMainProcess()) {
            zZs.put(Integer.valueOf(i2), cls);
        }
        AppMethodBeat.o(200321);
    }

    @Override // com.tencent.mm.plugin.multitask.d
    public final void sendMultiTaskEvent(int i2, String str, int i3) {
        AppMethodBeat.i(200322);
        p.h(str, "id");
        if (MMApplicationContext.isMainProcess()) {
            mt mtVar = new mt();
            mtVar.dSq.dSr = i2;
            mtVar.dSq.type = i3;
            mtVar.dSq.id = str;
            EventCenter.instance.publish(mtVar);
            AppMethodBeat.o(200322);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putInt("type", i3);
        bundle.putInt("event_type", i2);
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, e.class, new h(this));
        AppMethodBeat.o(200322);
    }

    @Override // com.tencent.mm.plugin.multitask.d
    public final void addTaskInfoByBitmap(String str, int i2, cru cru, Bitmap bitmap, byte[] bArr, crt crt) {
        byte[] bArr2 = null;
        AppMethodBeat.i(200323);
        p.h(str, "id");
        p.h(cru, "showData");
        Log.i(this.TAG, "addTaskInfoByBitmap id:" + str + " type:" + i2 + " bitmap:" + (bitmap != null ? Integer.valueOf(bitmap.getByteCount()) : null));
        if (MMApplicationContext.isMainProcess()) {
            cru.MwT = false;
            if (bitmap != null) {
                h hVar = h.zZn;
                String aGJ = h.aGJ(str);
                if (s.YS(aGJ)) {
                    s.deleteFile(aGJ);
                }
                g gVar = g.zZj;
                h hVar2 = h.zZn;
                q.bcV().OR(g.e(aGJ, h.eqz()));
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, aGJ, false);
            } else {
                cru.MwT = true;
                Log.i(this.TAG, "addTaskInfoByBitmap showData defaultBg mainProcess");
            }
            addTaskInfo(str, i2, cru, bArr, crt);
            AppMethodBeat.o(200323);
            return;
        }
        Bundle bundle = new Bundle();
        cru.MwT = false;
        if (bitmap != null) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            File externalCacheDir = context.getExternalCacheDir();
            String I = p.I(externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null, str);
            if (s.YS(I)) {
                s.deleteFile(I);
            }
            BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, I, false);
            bundle.putString("path", I);
        } else {
            cru.MwT = true;
            Log.i(this.TAG, "addTaskInfoByBitmap showData defaultBg");
        }
        bundle.putString("id", str);
        bundle.putInt("type", i2);
        bundle.putByteArray("showData", cru.toByteArray());
        bundle.putByteArray("data", bArr);
        if (crt != null) {
            bArr2 = crt.toByteArray();
        }
        bundle.putByteArray("reportdata", bArr2);
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, a.class, new c(this));
        AppMethodBeat.o(200323);
    }

    @Override // com.tencent.mm.plugin.multitask.d
    public final void updateTaskInfoByBitmap(String str, int i2, cru cru, Bitmap bitmap, byte[] bArr) {
        AppMethodBeat.i(200324);
        p.h(str, "id");
        p.h(cru, "showData");
        Log.i(this.TAG, "updateTaskInfoByBitmap id:" + str + " type:" + i2 + " bitmap:" + (bitmap != null ? Integer.valueOf(bitmap.getByteCount()) : null));
        if (MMApplicationContext.isMainProcess()) {
            cru.MwT = false;
            if (bitmap != null) {
                h hVar = h.zZn;
                String aGJ = h.aGJ(str);
                if (s.YS(aGJ)) {
                    s.deleteFile(aGJ);
                }
                g gVar = g.zZj;
                h hVar2 = h.zZn;
                q.bcV().OR(g.e(aGJ, h.eqz()));
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, aGJ, false);
            } else {
                cru.MwT = true;
                Log.i(this.TAG, "updateTaskInfoByBitmap showData defaultBg mainProcess");
            }
            updateTaskInfo(str, i2, cru, bArr);
            AppMethodBeat.o(200324);
            return;
        }
        Bundle bundle = new Bundle();
        cru.MwT = false;
        if (bitmap != null) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            File externalCacheDir = context.getExternalCacheDir();
            String I = p.I(externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null, str);
            if (s.YS(I)) {
                s.deleteFile(I);
            }
            BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, I, false);
            bundle.putString("path", I);
        } else {
            cru.MwT = true;
            Log.i(this.TAG, "updateTaskInfoByBitmap showData defaultBg");
        }
        bundle.putString("id", str);
        bundle.putInt("type", i2);
        bundle.putByteArray("showData", cru.toByteArray());
        bundle.putByteArray("data", bArr);
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, l.class, new i(this, cru, bitmap, str, i2, bArr));
        AppMethodBeat.o(200324);
    }

    @Override // com.tencent.mm.plugin.multitask.d
    public final void reportMultiTaskInfo(int i2, crt crt) {
        byte[] bArr = null;
        AppMethodBeat.i(200325);
        String str = this.TAG;
        Object[] objArr = new Object[3];
        objArr[0] = crt != null ? crt.MwM : null;
        objArr[1] = crt != null ? Integer.valueOf(crt.dUm) : null;
        objArr[2] = Integer.valueOf(i2);
        Log.d(str, "reportMultiTaskInfo, itemid: %s, itemtype: %d, reporttype: %d", objArr);
        if (MMApplicationContext.isMainProcess()) {
            reportInnerMultiTaskInfo(i2, crt);
            AppMethodBeat.o(200325);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("reporttype", i2);
        if (crt != null) {
            bArr = crt.toByteArray();
        }
        bundle.putByteArray("reportdata", bArr);
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, j.class, new g(this));
        AppMethodBeat.o(200325);
    }

    @Override // com.tencent.mm.plugin.multitask.d
    public final boolean isMultiTaskMode() {
        AppMethodBeat.i(200326);
        boolean isMultiTaskMode = ao.isMultiTaskMode();
        AppMethodBeat.o(200326);
        return isMultiTaskMode;
    }

    @Override // com.tencent.mm.plugin.multitask.d
    public final boolean isDataEmpty() {
        AppMethodBeat.i(200327);
        b bVar = zZt;
        if (bVar != null) {
            boolean isDataEmpty = bVar.isDataEmpty();
            AppMethodBeat.o(200327);
            return isDataEmpty;
        }
        com.tencent.mm.plugin.multitask.model.a aVar = this.zZr;
        if (aVar != null) {
            boolean isEmpty = aVar.eri().isEmpty();
            AppMethodBeat.o(200327);
            return isEmpty;
        }
        AppMethodBeat.o(200327);
        return false;
    }

    public final String getInnerMultiTaskItemPosition(String str, int i2, int i3) {
        AppMethodBeat.i(200328);
        p.h(str, "id");
        b bVar = zZt;
        if (bVar != null) {
            String multiTaskItemPosition = bVar.getMultiTaskItemPosition(str, i2, i3);
            AppMethodBeat.o(200328);
            return multiTaskItemPosition;
        }
        AppMethodBeat.o(200328);
        return null;
    }

    @Override // com.tencent.mm.plugin.multitask.d
    public final String getMultiTaskItemPosition(String str, int i2, int i3) {
        AppMethodBeat.i(200329);
        p.h(str, "id");
        if (MMApplicationContext.isMainProcess()) {
            String innerMultiTaskItemPosition = getInnerMultiTaskItemPosition(str, i2, i3);
            AppMethodBeat.o(200329);
            return innerMultiTaskItemPosition;
        }
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putInt("curPos", i2);
        bundle.putInt("way", i3);
        IPCString iPCString = (IPCString) com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, m.class);
        if (iPCString != null) {
            String str2 = iPCString.value;
            AppMethodBeat.o(200329);
            return str2;
        }
        AppMethodBeat.o(200329);
        return null;
    }

    public final void reportInnerMultiTaskInfo(int i2, crt crt) {
        AppMethodBeat.i(200330);
        if (crt != null) {
            if (i2 == 2) {
                com.tencent.mm.plugin.multitask.d.a aVar = com.tencent.mm.plugin.multitask.d.a.AbZ;
                com.tencent.mm.plugin.multitask.d.a.a(crt);
                com.tencent.mm.plugin.multitask.d.a aVar2 = com.tencent.mm.plugin.multitask.d.a.AbZ;
                com.tencent.mm.plugin.multitask.d.a.a(crt.dUm, crt.VjZ);
                AppMethodBeat.o(200330);
                return;
            } else if (i2 == 3) {
                com.tencent.mm.plugin.multitask.d.a aVar3 = com.tencent.mm.plugin.multitask.d.a.AbZ;
                com.tencent.mm.plugin.multitask.d.a.b(crt);
            }
        }
        AppMethodBeat.o(200330);
    }

    @Override // com.tencent.mm.plugin.multitask.d
    public final void updateTaskInfoByTitle(String str, int i2, cru cru, byte[] bArr) {
        AppMethodBeat.i(200331);
        p.h(str, "id");
        p.h(cru, "showData");
        if (MMApplicationContext.isMainProcess()) {
            updateTaskInfo(str, i2, cru, bArr);
            AppMethodBeat.o(200331);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putInt("type", i2);
        bundle.putByteArray("showData", cru.toByteArray());
        bundle.putByteArray("data", bArr);
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, k.class, new j(this, str, i2, cru, bArr));
        AppMethodBeat.o(200331);
    }

    @Override // com.tencent.mm.plugin.multitask.d
    public final void removeTaskInfoAndCoverImg(String str) {
        AppMethodBeat.i(200332);
        if (str != null) {
            h hVar = h.zZn;
            String aGJ = h.aGJ(str);
            if (s.YS(aGJ)) {
                s.deleteFile(aGJ);
            }
            com.tencent.mm.plugin.multitask.model.a aVar = this.zZr;
            if (aVar != null) {
                p.h(str, "id");
                MultiTaskInfo aGM = aVar.aGM(str);
                if (aGM != null && aVar.delete(aGM, false, new String[0])) {
                    aVar.doNotify(MStorageEventData.EventType.SINGLE, 5, aGM);
                }
            }
            ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).aBz(str);
            AppMethodBeat.o(200332);
            return;
        }
        AppMethodBeat.o(200332);
    }

    public final void reportAddTaskInfo(MultiTaskInfo multiTaskInfo, crt crt) {
        crp crp;
        AppMethodBeat.i(200333);
        if (crt == null || (crp = crt.MwO) == null) {
            AppMethodBeat.o(200333);
            return;
        }
        com.tencent.mm.plugin.multitask.d.a aVar = com.tencent.mm.plugin.multitask.d.a.AbZ;
        com.tencent.mm.plugin.multitask.d.a.a(multiTaskInfo, crp.MwA, crp.jii, crt.sGQ, crp.MwB);
        AppMethodBeat.o(200333);
    }

    @Override // com.tencent.mm.plugin.multitask.d
    public final void addTaskInfo(String str, int i2, cru cru, byte[] bArr, crt crt) {
        AppMethodBeat.i(200334);
        p.h(str, "id");
        p.h(cru, "showData");
        Log.i(this.TAG, "addTaskInfo id:" + str + " type:" + i2);
        MultiTaskInfo multiTaskInfo = new MultiTaskInfo();
        multiTaskInfo.field_id = str;
        multiTaskInfo.field_type = i2;
        multiTaskInfo.field_createTime = cl.aWA();
        multiTaskInfo.field_updateTime = cl.aWA();
        multiTaskInfo.field_showData = cru;
        multiTaskInfo.field_data = bArr;
        com.tencent.mm.plugin.multitask.model.a aVar = this.zZr;
        if (aVar != null) {
            p.h(multiTaskInfo, "item");
            if (!aVar.delete(multiTaskInfo, false, new String[0])) {
                aVar.h(multiTaskInfo);
            } else if (aVar.insertNotify(multiTaskInfo, false)) {
                aVar.doNotify(MStorageEventData.EventType.SINGLE, 8, multiTaskInfo);
            }
        }
        reportAddTaskInfo(multiTaskInfo, crt);
        ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).d(multiTaskInfo);
        AppMethodBeat.o(200334);
    }

    public final void updateTaskInfo(String str, int i2, cru cru, byte[] bArr) {
        MultiTaskInfo aGM;
        AppMethodBeat.i(200335);
        p.h(str, "id");
        p.h(cru, "showData");
        com.tencent.mm.plugin.multitask.model.a aVar = this.zZr;
        if (aVar == null || (aGM = aVar.aGM(str)) == null) {
            AppMethodBeat.o(200335);
            return;
        }
        aGM.field_updateTime = cl.aWA();
        aGM.field_type = i2;
        aGM.field_showData = cru;
        if (bArr != null) {
            aGM.field_data = bArr;
        }
        com.tencent.mm.plugin.multitask.model.a aVar2 = this.zZr;
        if (aVar2 != null) {
            aVar2.a(aGM, new String[0]);
        }
        ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(aGM);
        AppMethodBeat.o(200335);
    }

    public final List<MultiTaskInfo> getTaskInfoByType(int i2) {
        AppMethodBeat.i(200336);
        com.tencent.mm.plugin.multitask.model.a aVar = this.zZr;
        if (aVar != null) {
            Cursor rawQuery = aVar.db.rawQuery("SELECT * FROM MultiTaskInfo WHERE type = ? ORDER BY createTime DESC;", new String[]{String.valueOf(i2)});
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                MultiTaskInfo multiTaskInfo = new MultiTaskInfo();
                multiTaskInfo.convertFrom(rawQuery);
                arrayList.add(multiTaskInfo);
            }
            rawQuery.close();
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(200336);
            return arrayList2;
        }
        ArrayList arrayList3 = new ArrayList();
        AppMethodBeat.o(200336);
        return arrayList3;
    }

    @Override // com.tencent.mm.plugin.multitask.d
    public final MultiTaskInfo getTaskInfoById(String str) {
        AppMethodBeat.i(200337);
        p.h(str, "id");
        if (MMApplicationContext.isMainProcess()) {
            MultiTaskInfo innerTaskInfoById = getInnerTaskInfoById(str);
            AppMethodBeat.o(200337);
            return innerTaskInfoById;
        }
        AppMethodBeat.o(200337);
        return null;
    }

    public final MultiTaskInfo getInnerTaskInfoById(String str) {
        AppMethodBeat.i(200338);
        p.h(str, "id");
        com.tencent.mm.plugin.multitask.model.a aVar = this.zZr;
        if (aVar != null) {
            MultiTaskInfo aGM = aVar.aGM(str);
            AppMethodBeat.o(200338);
            return aGM;
        }
        AppMethodBeat.o(200338);
        return null;
    }

    public final boolean hasTaskInfoById(String str) {
        AppMethodBeat.i(200339);
        p.h(str, "id");
        b bVar = zZt;
        if (bVar != null) {
            boolean aGK = bVar.aGK(str);
            AppMethodBeat.o(200339);
            return aGK;
        }
        com.tencent.mm.plugin.multitask.model.a aVar = this.zZr;
        if ((aVar != null ? aVar.aGM(str) : null) != null) {
            AppMethodBeat.o(200339);
            return true;
        }
        AppMethodBeat.o(200339);
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.d
    public final boolean hasTaskInfo(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(200340);
        p.h(multiTaskInfo, "multiTaskInfo");
        if (MMApplicationContext.isMainProcess()) {
            String str = multiTaskInfo.field_id;
            p.g(str, "multiTaskInfo.field_id");
            boolean hasTaskInfoById = hasTaskInfoById(str);
            AppMethodBeat.o(200340);
            return hasTaskInfoById;
        }
        IPCBoolean iPCBoolean = (IPCBoolean) com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCString(multiTaskInfo.field_id), c.class);
        if (iPCBoolean != null) {
            boolean z = iPCBoolean.value;
            AppMethodBeat.o(200340);
            return z;
        }
        AppMethodBeat.o(200340);
        return false;
    }

    @Override // android.arch.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        return this.FE;
    }

    @Override // com.tencent.mm.plugin.multitask.d
    public final Point getMultiTaskFloatBallPosition() {
        AppMethodBeat.i(200341);
        Point point = new Point(0, f.oYW);
        AppMethodBeat.o(200341);
        return point;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/multitask/PluginMultiTask$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "", "onAppForeground", "plugin-multitask_release"})
    public static final class d extends o.a {
        final /* synthetic */ PluginMultiTask zZv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(PluginMultiTask pluginMultiTask) {
            this.zZv = pluginMultiTask;
        }

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(200308);
            p.h(str, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            Log.i(this.zZv.TAG, "onAppForeground, activity:%s", str);
            if (AppForegroundDelegate.INSTANCE.Wc() && com.tencent.mm.kernel.g.aAc()) {
                boolean isTopApplication = Util.isTopApplication(MMApplicationContext.getContext());
                Log.i(this.zZv.TAG, "onAppForeground isTopApplication: %b", Boolean.valueOf(isTopApplication));
                if (isTopApplication) {
                    a aVar = PluginMultiTask.zZu;
                    b bVar = PluginMultiTask.zZt;
                    if (bVar != null) {
                        bVar.jK(true);
                        AppMethodBeat.o(200308);
                        return;
                    }
                }
            }
            AppMethodBeat.o(200308);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(200309);
            p.h(str, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            Log.i(this.zZv.TAG, "onAppBackground, activity:%s", str);
            a aVar = PluginMultiTask.zZu;
            b bVar = PluginMultiTask.zZt;
            if (bVar != null) {
                bVar.jK(AppForegroundDelegate.INSTANCE.Wc());
                AppMethodBeat.o(200309);
                return;
            }
            AppMethodBeat.o(200309);
        }
    }
}
