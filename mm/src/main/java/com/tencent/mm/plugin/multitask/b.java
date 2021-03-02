package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/multitask/GetMultiInfoListTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-multitask_release"})
public final class b implements com.tencent.mm.ipcinvoker.b<IPCVoid, MultiTaskListParcel> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public final /* synthetic */ void invoke(IPCVoid iPCVoid, d<MultiTaskListParcel> dVar) {
        AppMethodBeat.i(200279);
        p.h(iPCVoid, "data");
        p.h(dVar, "callback");
        ((PluginMultiTask) g.ah(PluginMultiTask.class)).getMultiTaskInfoList(new a(dVar));
        AppMethodBeat.o(200279);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/multitask/GetMultiInfoListTask$invoke$1", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "onGetMultiTaskInfoList", "", "multiTaskInfoList", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "plugin-multitask_release"})
    public static final class a implements com.tencent.mm.plugin.multitask.c.a {
        final /* synthetic */ d kFf;

        a(d dVar) {
            this.kFf = dVar;
        }

        @Override // com.tencent.mm.plugin.multitask.c.a
        public final void bC(List<? extends MultiTaskInfo> list) {
            AppMethodBeat.i(200278);
            p.h(list, "multiTaskInfoList");
            this.kFf.bn(new MultiTaskListParcel(list));
            AppMethodBeat.o(200278);
        }
    }
}
