package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0011¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTouchMediaPreviewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "attach", "", "find", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setScaleListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "Companion", "plugin-finder_release"})
public final class FinderTouchMediaPreviewUIC extends UIComponent {
    public static final a wAS = new a((byte) 0);

    static {
        AppMethodBeat.i(256039);
        AppMethodBeat.o(256039);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderTouchMediaPreviewUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(256038);
        AppMethodBeat.o(256038);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTouchMediaPreviewUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private TouchMediaPreviewLayout dIP() {
        AppMethodBeat.i(256036);
        TouchMediaPreviewLayout touchMediaPreviewLayout = (TouchMediaPreviewLayout) getActivity().findViewById(R.id.iub);
        AppMethodBeat.o(256036);
        return touchMediaPreviewLayout;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(256037);
        TouchMediaPreviewLayout dIP = dIP();
        if (dIP == null || !dIP.QFs) {
            boolean onBackPressed = super.onBackPressed();
            AppMethodBeat.o(256037);
            return onBackPressed;
        }
        TouchMediaPreviewLayout dIP2 = dIP();
        if (dIP2 != null) {
            dIP2.gZk();
        }
        AppMethodBeat.o(256037);
        return true;
    }
}
