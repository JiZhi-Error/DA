package com.tencent.mm.plugin.topstory.ui.multitask;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Objects;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/topstory/ui/multitask/TopStoryMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "ui-topstory_release"})
public final class b extends com.tencent.mm.plugin.multitask.a.b {
    public b(Activity activity) {
        super(activity);
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final Activity getActivity() {
        AppMethodBeat.i(236423);
        Activity activity = (Activity) Objects.requireNonNull(super.getActivity());
        AppMethodBeat.o(236423);
        return activity;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b
    public final void setActivity(Activity activity) {
        AppMethodBeat.i(236424);
        super.setActivity(activity);
        AppMethodBeat.o(236424);
    }
}
