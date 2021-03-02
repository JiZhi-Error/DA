package com.tencent.mm.plugin.multitask.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.crq;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001eJ\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J.\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0016\u001a\u00020\u0005H&J\b\u0010\u0017\u001a\u00020\u0005H&J\b\u0010\u0018\u001a\u00020\u0005H&J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent;", "Lcom/tencent/mm/ui/component/IUIComponent;", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onMultiTaskChange", "", "event", "", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskItemDelete", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onTaskBarItemExposed", "supportMultiTaskType", "", "multiTaskType", "", "MultiTaskMode", "plugin-multitask_release"})
public interface a {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "", "(Ljava/lang/String;I)V", "MODE_SHOW_SINGLE_SCENE", "MODE_SHOW_MULTI_SCENE", "MODE_SHOW_SNAPSHOT_SCENE", "MODE_NONE", "plugin-multitask_release"})
    public enum b {
        MODE_SHOW_SINGLE_SCENE,
        MODE_SHOW_MULTI_SCENE,
        MODE_SHOW_SNAPSHOT_SCENE,
        MODE_NONE;

        static {
            AppMethodBeat.i(200645);
            AppMethodBeat.o(200645);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(200647);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(200647);
            return bVar;
        }
    }

    void a(View view, MultiTaskInfo multiTaskInfo, crq crq, Object obj);

    b dks();

    @l(hxD = {1, 1, 16})
    /* renamed from: com.tencent.mm.plugin.multitask.ui.a$a  reason: collision with other inner class name */
    public static final class C1520a {
        public static /* synthetic */ void a(a aVar, View view, MultiTaskInfo multiTaskInfo, crq crq) {
            AppMethodBeat.i(200644);
            aVar.a(view, multiTaskInfo, crq, null);
            AppMethodBeat.o(200644);
        }
    }
}
