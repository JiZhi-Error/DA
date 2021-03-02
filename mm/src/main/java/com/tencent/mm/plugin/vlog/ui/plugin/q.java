package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.ui.ar;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012J \u0010\"\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0002J\u0012\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\fH\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0013\u001a\n \n*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "editIndex", "", "getEditIndex", "()I", "setEditIndex", "(I)V", "editTransitionPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditTransitionPlugin;", "layout", "getLayout", "()Landroid/view/ViewGroup;", "layout$delegate", "Lkotlin/Lazy;", "getParent", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "attachEditTransitionPlugin", "", "plugin", "loadMenuLayout", "iconRes", "titleRes", "onClick", "v", "Landroid/view/View;", "setVisibility", "visibility", "plugin-vlog_release"})
public final class q implements View.OnClickListener, t {
    private com.tencent.mm.plugin.vlog.ui.plugin.transition.a GEi;
    public int GyM = -1;
    private final Context context = this.parent.getContext();
    ViewGroup parent;
    private d wgr;
    private final f xmB = g.ah(new a(this));

    public q(ViewGroup viewGroup, d dVar) {
        p.h(viewGroup, "parent");
        p.h(dVar, "status");
        AppMethodBeat.i(191345);
        this.parent = viewGroup;
        this.wgr = dVar;
        View findViewById = this.parent.findViewById(R.id.fcz);
        p.g(findViewById, "parent.findViewById(R.id.menu_crop)");
        e((ViewGroup) findViewById, R.raw.icons_filled_crop, R.string.clm);
        View findViewById2 = this.parent.findViewById(R.id.fd4);
        p.g(findViewById2, "parent.findViewById(R.id.menu_emoji)");
        e((ViewGroup) findViewById2, R.raw.icons_filled_sticker, R.string.clo);
        View findViewById3 = this.parent.findViewById(R.id.fdp);
        p.g(findViewById3, "parent.findViewById(R.id.menu_text)");
        e((ViewGroup) findViewById3, R.raw.icons_filled_text, R.string.clq);
        View findViewById4 = this.parent.findViewById(R.id.fdo);
        p.g(findViewById4, "parent.findViewById(R.id.menu_speed)");
        e((ViewGroup) findViewById4, R.raw.icons_outline_change_speed, R.string.clp);
        AppMethodBeat.o(191345);
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
        AppMethodBeat.i(191346);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191346);
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

    public final void a(com.tencent.mm.plugin.vlog.ui.plugin.transition.a aVar) {
        AppMethodBeat.i(191341);
        p.h(aVar, "plugin");
        this.GEi = aVar;
        AppMethodBeat.o(191341);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(191342);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.fcz) {
            d dVar = this.wgr;
            d.c cVar = d.c.BWg;
            Bundle bundle = new Bundle();
            bundle.putInt("EDIT_VLOG_SELECT_TRACK", this.GyM);
            dVar.a(cVar, bundle);
        } else if (valueOf != null && valueOf.intValue() == R.id.fd4) {
            d.b.a(this.wgr, d.c.BUX);
        } else if (valueOf != null && valueOf.intValue() == R.id.fdp) {
            d.b.a(this.wgr, d.c.BUZ);
        } else if (valueOf != null && valueOf.intValue() == R.id.fdo) {
            d.b.a(this.wgr, d.c.BWj);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191342);
    }

    private final void e(ViewGroup viewGroup, int i2, int i3) {
        AppMethodBeat.i(191344);
        View findViewById = viewGroup.findViewById(R.id.ipm);
        p.g(findViewById, "layout.findViewById<TextView>(R.id.title)");
        ((TextView) findViewById).setText(com.tencent.mm.cb.a.aI(this.context, i3));
        ((ImageView) viewGroup.findViewById(R.id.dt5)).setImageDrawable(ar.m(this.context, i2, -1));
        viewGroup.setOnClickListener(this);
        AppMethodBeat.o(191344);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191343);
        ViewGroup viewGroup = (ViewGroup) this.xmB.getValue();
        p.g(viewGroup, "layout");
        viewGroup.setVisibility(i2);
        AppMethodBeat.o(191343);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ q GHH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(q qVar) {
            super(0);
            this.GHH = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(191340);
            ViewGroup viewGroup = (ViewGroup) this.GHH.parent.findViewById(R.id.bvy);
            AppMethodBeat.o(191340);
            return viewGroup;
        }
    }
}
