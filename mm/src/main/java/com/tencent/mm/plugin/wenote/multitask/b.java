package com.tencent.mm.plugin.wenote.multitask;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "canConvertToTranslucent", "", "Companion", "app_release"})
public final class b extends com.tencent.mm.plugin.multitask.a.b {
    public static final a JJp = new a((byte) 0);
    private Activity activity;

    static {
        AppMethodBeat.i(230923);
        AppMethodBeat.o(230923);
    }

    public b(Activity activity2) {
        super(activity2);
        this.activity = activity2;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final Activity getActivity() {
        return this.activity;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b
    public final void setActivity(Activity activity2) {
        this.activity = activity2;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final boolean bCI() {
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskPageAdapter$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
