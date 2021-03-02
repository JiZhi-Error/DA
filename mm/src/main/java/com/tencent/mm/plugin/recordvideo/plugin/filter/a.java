package com.tencent.mm.plugin.recordvideo.plugin.filter;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0016\u001a\u00020\u0017J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "filterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkFilterStatus", "", "name", "", "onClick", "v", "Landroid/view/View;", "release", "reset", "setPreImage", "bitmap", "Landroid/graphics/Bitmap;", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class a implements View.OnClickListener, t {
    public final PhotoFilterPlugin BTj;
    private boolean isSelected;
    private final ImageView tkI;
    private d wgr;
    private ViewGroup zQH;

    public a(ViewGroup viewGroup, d dVar) {
        p.h(viewGroup, "viewGroup");
        p.h(dVar, "status");
        AppMethodBeat.i(163448);
        this.zQH = viewGroup;
        this.wgr = dVar;
        View findViewById = this.zQH.findViewById(R.id.cij);
        p.g(findViewById, "viewGroup.findViewById(R.id.filter_layout)");
        this.BTj = (PhotoFilterPlugin) findViewById;
        this.BTj.setStatus(this.wgr);
        View findViewById2 = this.zQH.findViewById(R.id.bwo);
        p.g(findViewById2, "viewGroup.findViewById(R.id.editor_add_filter)");
        this.tkI = (ImageView) findViewById2;
        this.tkI.setVisibility(0);
        this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), R.raw.icons_outlined_filters, -1));
        this.tkI.setOnClickListener(this);
        AppMethodBeat.o(163448);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
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
        AppMethodBeat.i(237396);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237396);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    public final void onClick(View view) {
        AppMethodBeat.i(163443);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        this.isSelected = !this.isSelected;
        if (this.isSelected) {
            this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), R.raw.icons_outlined_filters, this.tkI.getResources().getColor(R.color.Orange)));
        } else {
            d.b.a(this.wgr, d.c.BVT);
            this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), R.raw.icons_outlined_filters, -1));
        }
        eKN();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163443);
    }

    private void eKN() {
        AppMethodBeat.i(163444);
        if (this.isSelected) {
            this.BTj.setVisibility(0);
            AppMethodBeat.o(163444);
            return;
        }
        this.BTj.setVisibility(4);
        AppMethodBeat.o(163444);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(163445);
        this.isSelected = false;
        eKN();
        d.b.a(this.wgr, d.c.BVT);
        this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), R.raw.icons_outlined_filters, -1));
        AppMethodBeat.o(163445);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return "plugin_filter";
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(163446);
        this.tkI.setVisibility(i2);
        AppMethodBeat.o(163446);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(163447);
        com.tencent.mm.x.a aVar = com.tencent.mm.x.a.hiy;
        com.tencent.mm.x.a.stop();
        AppMethodBeat.o(163447);
    }
}
