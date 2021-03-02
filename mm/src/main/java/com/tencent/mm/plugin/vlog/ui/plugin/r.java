package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector;
import com.tencent.mm.plugin.vlog.ui.widget.a;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\n \f*\u0004\u0018\u00010\u00140\u0014X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "colorPicker", "Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "kotlin.jvm.PlatformType", "iconColor", "", "isSelected", "", "getLayout", "()Landroid/view/ViewGroup;", "pencilBtn", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "close", "", "onBackPress", "reset", "resetIconColor", "setVisibility", "visibility", "plugin-vlog_release"})
public final class r implements t {
    final a GHI;
    final ImageView GHJ;
    boolean isSelected;
    private int uzt;
    private final ViewGroup wgq;
    final d wgr;
    final EditorPanelHolder wji = ((EditorPanelHolder) this.wgq.findViewById(R.id.bxa));

    public r(ViewGroup viewGroup, d dVar) {
        p.h(viewGroup, "layout");
        p.h(dVar, "status");
        AppMethodBeat.i(191356);
        this.wgq = viewGroup;
        this.wgr = dVar;
        EditorPanelHolder editorPanelHolder = this.wji;
        p.g(editorPanelHolder, "holder");
        this.GHI = new a(editorPanelHolder);
        this.GHJ = (ImageView) this.wgq.findViewById(R.id.bwu);
        this.uzt = -1;
        ImageView imageView = this.GHJ;
        ImageView imageView2 = this.GHJ;
        p.g(imageView2, "pencilBtn");
        imageView.setImageDrawable(ar.m(imageView2.getContext(), R.raw.icons_filled_duddle, -1));
        this.GHJ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.r.AnonymousClass1 */
            final /* synthetic */ r GHK;

            {
                this.GHK = r1;
            }

            public final void onClick(View view) {
                boolean z;
                AppMethodBeat.i(191347);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                r rVar = this.GHK;
                if (!this.GHK.isSelected) {
                    z = true;
                } else {
                    z = false;
                }
                rVar.isSelected = z;
                if (this.GHK.isSelected) {
                    c cVar = c.BXI;
                    c.aLu("KEY_CLICK_DOODLE_COUNT_INT");
                    c cVar2 = c.BXI;
                    c.VH(7);
                    ImageView imageView = this.GHK.GHJ;
                    ImageView imageView2 = this.GHK.GHJ;
                    p.g(imageView2, "pencilBtn");
                    Context context = imageView2.getContext();
                    ImageView imageView3 = this.GHK.GHJ;
                    p.g(imageView3, "pencilBtn");
                    imageView.setImageDrawable(ar.m(context, R.raw.icons_filled_duddle, imageView3.getResources().getColor(R.color.afp)));
                    d.b.a(this.GHK.wgr, d.c.BVE);
                    a aVar = this.GHK.GHI;
                    if (!aVar.isInit) {
                        aVar.isInit = true;
                        aVar.wji.setCloseTouchOutside(false);
                        aVar.wji.setOutsideTouchable(true);
                        TextColorSelector fEz = aVar.fEz();
                        View fDm = aVar.fDm();
                        p.g(fDm, "panelRoot");
                        fEz.setRadiusNormalInner((float) com.tencent.mm.cb.a.fromDPToPix(fDm.getContext(), 10));
                        TextColorSelector fEz2 = aVar.fEz();
                        View fDm2 = aVar.fDm();
                        p.g(fDm2, "panelRoot");
                        fEz2.setRadiusNormalOuter(fDm2.getResources().getDimension(R.dimen.c5));
                        aVar.fEz().setRadiusSelectInner(aVar.fEz().getRadiusNormalOuter());
                        TextColorSelector fEz3 = aVar.fEz();
                        View fDm3 = aVar.fDm();
                        p.g(fDm3, "panelRoot");
                        fEz3.setRadiusSelectOuter(fDm3.getResources().getDimension(R.dimen.cb));
                        aVar.fEz().setColorList(a.GQw);
                        aVar.fEz().setSelected(2);
                        aVar.fEz().setColorSelectedCallback(new a.c(aVar));
                        ((ImageView) aVar.GQu.getValue()).setOnClickListener(new a.d(aVar));
                        ((ImageView) aVar.vLW.getValue()).setOnClickListener(new a.e(aVar));
                    }
                    this.GHK.wji.setShow(true);
                    a aVar2 = this.GHK.GHI;
                    a.AbstractC1884a aVar3 = aVar2.GQv;
                    if (aVar3 != null) {
                        aVar3.acC(aVar2.fEz().getSelected());
                    }
                } else {
                    this.GHK.close();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPhotoPencilPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191347);
            }
        });
        this.GHI.GQv = new a.AbstractC1884a(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.r.AnonymousClass2 */
            final /* synthetic */ r GHK;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.GHK = r1;
            }

            @Override // com.tencent.mm.plugin.vlog.ui.widget.a.AbstractC1884a
            public final void acC(int i2) {
                AppMethodBeat.i(191348);
                Bundle bundle = new Bundle();
                bundle.putInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT", i2);
                this.GHK.wgr.a(d.c.BVL, bundle);
                AppMethodBeat.o(191348);
            }

            @Override // com.tencent.mm.plugin.vlog.ui.widget.a.AbstractC1884a
            public final void XT() {
                AppMethodBeat.i(191349);
                d.b.a(this.GHK.wgr, d.c.BVM);
                AppMethodBeat.o(191349);
            }

            @Override // com.tencent.mm.plugin.vlog.ui.widget.a.AbstractC1884a
            public final void onClose() {
                AppMethodBeat.i(191350);
                this.GHK.isSelected = false;
                this.GHK.close();
                AppMethodBeat.o(191350);
            }
        };
        AppMethodBeat.o(191356);
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
        AppMethodBeat.i(191357);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191357);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191351);
        ImageView imageView = this.GHJ;
        p.g(imageView, "pencilBtn");
        imageView.setVisibility(i2);
        AppMethodBeat.o(191351);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(191352);
        this.isSelected = false;
        close();
        AppMethodBeat.o(191352);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(191353);
        if (this.wji.bJw()) {
            this.isSelected = false;
            close();
            AppMethodBeat.o(191353);
            return true;
        }
        AppMethodBeat.o(191353);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void close() {
        AppMethodBeat.i(191354);
        this.wji.setShow(false);
        d.b.a(this.wgr, d.c.BVI);
        ImageView imageView = this.GHJ;
        ImageView imageView2 = this.GHJ;
        p.g(imageView2, "pencilBtn");
        imageView.setImageDrawable(ar.m(imageView2.getContext(), R.raw.icons_filled_duddle, this.uzt));
        this.wji.setShow(false);
        AppMethodBeat.o(191354);
    }

    public final void VC(int i2) {
        AppMethodBeat.i(191355);
        this.uzt = i2;
        ImageView imageView = this.GHJ;
        ImageView imageView2 = this.GHJ;
        p.g(imageView2, "pencilBtn");
        imageView.setImageDrawable(ar.m(imageView2.getContext(), R.raw.icons_filled_duddle, i2));
        AppMethodBeat.o(191355);
    }
}
