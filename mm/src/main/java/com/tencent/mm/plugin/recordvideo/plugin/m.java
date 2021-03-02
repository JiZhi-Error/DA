package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000bJ\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "editPhotoDoodlePlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkDoodleStatus", "", "hideDooldeLayout", "hideMosaic", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "onBackPress", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class m implements View.OnClickListener, t {
    public final PhotoDoodlePlugin BQL;
    private boolean isSelected;
    private final ImageView tkI;
    private d wgr;
    private ViewGroup zQH;

    public m(ViewGroup viewGroup, d dVar) {
        p.h(viewGroup, "viewGroup");
        p.h(dVar, "status");
        AppMethodBeat.i(75562);
        this.zQH = viewGroup;
        this.wgr = dVar;
        View findViewById = this.zQH.findViewById(R.id.bt0);
        p.g(findViewById, "viewGroup.findViewById(R.id.doddle_layout)");
        this.BQL = (PhotoDoodlePlugin) findViewById;
        this.BQL.setStatus(this.wgr);
        View findViewById2 = this.zQH.findViewById(R.id.bwu);
        p.g(findViewById2, "viewGroup.findViewById(R.id.editor_add_pencil)");
        this.tkI = (ImageView) findViewById2;
        this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), R.raw.icons_filled_duddle, -1));
        this.tkI.setOnClickListener(this);
        AppMethodBeat.o(75562);
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
        AppMethodBeat.i(237294);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237294);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    public final void onClick(View view) {
        AppMethodBeat.i(75559);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
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
        a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75559);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(75560);
        this.isSelected = false;
        eox();
        d.b.a(this.wgr, d.c.BVI);
        this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), R.raw.icons_filled_duddle, -1));
        AppMethodBeat.o(75560);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(237293);
        this.tkI.setVisibility(i2);
        AppMethodBeat.o(237293);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    public final void eox() {
        AppMethodBeat.i(75561);
        if (this.isSelected) {
            this.BQL.setVisibility(0);
            AppMethodBeat.o(75561);
            return;
        }
        this.BQL.setVisibility(4);
        AppMethodBeat.o(75561);
    }
}
