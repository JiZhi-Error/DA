package com.tencent.mm.plugin.multitalk.ui.a;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.doodle.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\rH\u0016J\u0012\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\rJ\b\u0010 \u001a\u00020\u0019H\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "editPhotoDoodlePlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin;", "editPhotoDoodlePluginRoot", "Landroid/widget/RelativeLayout;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkDoodleStatus", "", "onBackPress", "onClick", "v", "Landroid/view/View;", "refreshDoodleLayout", "isLand", "reset", "setVisibility", "visibility", "", "plugin-multitalk_release"})
public final class d implements View.OnClickListener, t {
    private boolean isSelected;
    private final ImageView tkI;
    private com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
    public b zQF;
    public final RelativeLayout zQG;
    private ViewGroup zQH;

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(android.view.ViewGroup r6, com.tencent.mm.plugin.recordvideo.plugin.parent.d r7) {
        /*
        // Method dump skipped, instructions count: 163
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.ui.a.d.<init>(android.view.ViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d):void");
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
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(239756);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(239756);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    public final void onClick(View view) {
        AppMethodBeat.i(239751);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        this.isSelected = !this.isSelected;
        if (this.isSelected) {
            c cVar = c.BXI;
            c.aLu("KEY_CLICK_DOODLE_COUNT_INT");
            c cVar2 = c.BXI;
            c.VH(7);
            this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), R.raw.icons_filled_duddle, this.tkI.getResources().getColor(R.color.afp)));
            d.b.a(this.wgr, d.c.BVE);
        } else {
            d.b.a(this.wgr, d.c.BVI);
            this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), R.raw.icons_filled_duddle, -1));
        }
        eox();
        a.a(this, "com/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(239751);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(239752);
        this.isSelected = false;
        eox();
        d.b.a(this.wgr, d.c.BVI);
        this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), R.raw.icons_filled_duddle, -1));
        AppMethodBeat.o(239752);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(239753);
        this.tkI.setVisibility(i2);
        RelativeLayout relativeLayout = this.zQG;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i2);
            AppMethodBeat.o(239753);
            return;
        }
        AppMethodBeat.o(239753);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    private void eox() {
        AppMethodBeat.i(239754);
        if (this.isSelected) {
            b bVar = this.zQF;
            if (bVar != null) {
                bVar.l(0);
                AppMethodBeat.o(239754);
                return;
            }
            AppMethodBeat.o(239754);
            return;
        }
        b bVar2 = this.zQF;
        if (bVar2 != null) {
            bVar2.l(4);
            AppMethodBeat.o(239754);
            return;
        }
        AppMethodBeat.o(239754);
    }
}
