package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0014J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateNormalModeSelectPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "containerLayout", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "tabLayout", "Landroid/support/design/widget/TabLayout;", "isInTemplateMode", "", "selectNormalMode", "", "selectTemplateMode", "setShowContainer", "show", "setVisibility", "visibility", "", "Companion", "plugin-vlog_release"})
public final class ac implements t {
    public static final a GIx = new a((byte) 0);
    private final InsectRelativeLayout GIw;
    private ViewGroup parent;
    private final TabLayout wAv;
    d wgr;

    static {
        AppMethodBeat.i(191475);
        AppMethodBeat.o(191475);
    }

    public ac(ViewGroup viewGroup, d dVar) {
        p.h(viewGroup, "parent");
        p.h(dVar, "status");
        AppMethodBeat.i(191474);
        this.parent = viewGroup;
        this.wgr = dVar;
        View findViewById = this.parent.findViewById(R.id.ij4);
        p.g(findViewById, "parent.findViewById(R.id…al_mode_switch_container)");
        this.GIw = (InsectRelativeLayout) findViewById;
        View findViewById2 = this.parent.findViewById(R.id.ij5);
        p.g(findViewById2, "parent.findViewById(R.id…ate_normal_mode_switcher)");
        this.wAv = (TabLayout) findViewById2;
        Log.i("MicroMsg.TemplateNormalModeSelectPlugin", "init tabLayout.tabCount:" + this.wAv.getTabCount());
        this.GIw.setDiscardKeyboard(true);
        int tabCount = this.wAv.getTabCount() - 1;
        for (int i2 = 0; i2 < tabCount; i2++) {
            View childAt = this.wAv.getChildAt(0);
            if (childAt == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(191474);
                throw tVar;
            }
            View childAt2 = ((ViewGroup) childAt).getChildAt(i2);
            p.g(childAt2, "tab");
            ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
            if (layoutParams == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(191474);
                throw tVar2;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMarginEnd(com.tencent.mm.cb.a.aG(this.parent.getContext(), R.dimen.ci));
            childAt2.setLayoutParams(marginLayoutParams);
        }
        this.wAv.a(new TabLayout.c(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.ac.AnonymousClass1 */
            final /* synthetic */ ac GIy;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.GIy = r1;
            }

            @Override // android.support.design.widget.TabLayout.b
            public final void k(TabLayout.f fVar) {
            }

            @Override // android.support.design.widget.TabLayout.b
            public final void j(TabLayout.f fVar) {
            }

            @Override // android.support.design.widget.TabLayout.b
            public final void i(TabLayout.f fVar) {
                AppMethodBeat.i(191470);
                if (fVar == null) {
                    AppMethodBeat.o(191470);
                } else if (fVar.getPosition() == 1) {
                    Log.i("MicroMsg.TemplateNormalModeSelectPlugin", "onSelect template mode");
                    d.b.a(this.GIy.wgr, d.c.BWR);
                    AppMethodBeat.o(191470);
                } else {
                    if (fVar.getPosition() == 0) {
                        Log.i("MicroMsg.TemplateNormalModeSelectPlugin", "onSelect normal mode");
                        d.b.a(this.GIy.wgr, d.c.BWS);
                    }
                    AppMethodBeat.o(191470);
                }
            }
        });
        wI(false);
        AppMethodBeat.o(191474);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(191476);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191476);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateNormalModeSelectPlugin$Companion;", "", "()V", "NormalPos", "", "TAG", "", "TemplatePos", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final boolean fDO() {
        AppMethodBeat.i(191471);
        if (this.wAv.getSelectedTabPosition() == 1) {
            AppMethodBeat.o(191471);
            return true;
        }
        AppMethodBeat.o(191471);
        return false;
    }

    public final void wI(boolean z) {
        AppMethodBeat.i(191472);
        this.GIw.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(191472);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191473);
        this.wAv.setVisibility(i2);
        AppMethodBeat.o(191473);
    }
}
