package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001$B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \n*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \n*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\n \n*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin$FuncType;", "normalFuncLayout", "okBtn", "rotateImg", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "onBackPress", "", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "FuncType", "plugin-recordvideo_release"})
public final class r implements View.OnClickListener, t {
    private final ViewGroup BQB = ((ViewGroup) this.wgR.findViewById(R.id.dce));
    private final ViewGroup BQC = ((ViewGroup) this.wgR.findViewById(R.id.bie));
    private final ImageView BQD = ((ImageView) this.wgR.findViewById(R.id.bii));
    private final ImageView BQE = ((ImageView) this.wgR.findViewById(R.id.bih));
    private a BQV = a.DEFAULT;
    private final Button hPX = ((Button) this.wgR.findViewById(R.id.bid));
    private final Button hSq = ((Button) this.wgR.findViewById(R.id.bib));
    private ViewGroup wgR;
    private d wgr;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin$FuncType;", "", "(Ljava/lang/String;I)V", "CROP_FUNC", "NORMAL_FUNC", "DEFAULT", "plugin-recordvideo_release"})
    enum a {
        CROP_FUNC,
        NORMAL_FUNC,
        DEFAULT;

        static {
            AppMethodBeat.i(75579);
            AppMethodBeat.o(75579);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(75581);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(75581);
            return aVar;
        }
    }

    public r(ViewGroup viewGroup, d dVar) {
        p.h(viewGroup, "view");
        p.h(dVar, "status");
        AppMethodBeat.i(75585);
        this.wgR = viewGroup;
        this.wgr = dVar;
        ViewGroup viewGroup2 = this.BQC;
        p.g(viewGroup2, "cropFuncLayout");
        viewGroup2.setVisibility(4);
        this.wgR.findViewById(R.id.bw2);
        this.BQD.setImageDrawable(ar.m(this.wgR.getContext(), R.raw.undo_normal, -1));
        this.BQE.setImageDrawable(ar.m(this.wgR.getContext(), R.raw.icons_filled_refresh, -1));
        this.hSq.setOnClickListener(this);
        this.hPX.setOnClickListener(this);
        this.BQD.setOnClickListener(this);
        this.BQE.setOnClickListener(this);
        AppMethodBeat.o(75585);
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
        AppMethodBeat.i(237299);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237299);
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

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(75582);
        this.wgR.setVisibility(i2);
        AppMethodBeat.o(75582);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(75583);
        if (this.BQV == a.CROP_FUNC) {
            d.b.a(this.wgr, d.c.BVO);
            AppMethodBeat.o(75583);
            return true;
        }
        AppMethodBeat.o(75583);
        return false;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(75584);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.bib) {
            ViewGroup viewGroup = this.BQB;
            p.g(viewGroup, "normalFuncLayout");
            viewGroup.setVisibility(0);
            ViewGroup viewGroup2 = this.BQC;
            p.g(viewGroup2, "cropFuncLayout");
            viewGroup2.setVisibility(4);
            d.b.a(this.wgr, d.c.BVO);
        } else if (valueOf != null && valueOf.intValue() == R.id.bid) {
            ViewGroup viewGroup3 = this.BQB;
            p.g(viewGroup3, "normalFuncLayout");
            viewGroup3.setVisibility(0);
            ViewGroup viewGroup4 = this.BQC;
            p.g(viewGroup4, "cropFuncLayout");
            viewGroup4.setVisibility(4);
            d.b.a(this.wgr, d.c.BVP);
        } else if (valueOf != null && valueOf.intValue() == R.id.bii) {
            d.b.a(this.wgr, d.c.BVR);
        } else if (valueOf != null && valueOf.intValue() == R.id.bih) {
            d.b.a(this.wgr, d.c.BVQ);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75584);
    }
}
