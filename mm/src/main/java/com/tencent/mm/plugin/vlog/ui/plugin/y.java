package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.vlog.ui.widget.PagInputView;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/PagEditTextPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getLayout", "()Landroid/view/ViewGroup;", "pagInputView", "Lcom/tencent/mm/plugin/vlog/ui/widget/PagInputView;", "kotlin.jvm.PlatformType", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "editPag", "", "text", "", "onBackPress", "", "plugin-vlog_release"})
public final class y implements t {
    final PagInputView GIo = ((PagInputView) this.wgq.findViewById(R.id.bxi));
    private final ViewGroup wgq;
    final d wgr;

    public y(ViewGroup viewGroup, d dVar) {
        p.h(viewGroup, "layout");
        p.h(dVar, "status");
        AppMethodBeat.i(191457);
        this.wgq = viewGroup;
        this.wgr = dVar;
        this.GIo.setTextChangeCallback(new b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.y.AnonymousClass1 */
            final /* synthetic */ y GIp;

            {
                this.GIp = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(191454);
                boolean booleanValue = bool.booleanValue();
                this.GIp.GIo.setShow(false);
                if (booleanValue) {
                    Bundle bundle = new Bundle();
                    bundle.putString("EDIT_PAG_CHANGE_TEXT", this.GIp.GIo.getResult());
                    this.GIp.wgr.a(d.c.BWI, bundle);
                }
                d.b.a(this.GIp.wgr, d.c.BVj);
                x xVar = x.SXb;
                AppMethodBeat.o(191454);
                return xVar;
            }
        });
        AppMethodBeat.o(191457);
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
        AppMethodBeat.i(191458);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191458);
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
    }

    public final void aUm(String str) {
        AppMethodBeat.i(191455);
        p.h(str, "text");
        this.GIo.setup(str);
        this.GIo.setShow(true);
        AppMethodBeat.o(191455);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        boolean z;
        AppMethodBeat.i(191456);
        if (this.GIo.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.GIo.setShow(false);
            d.b.a(this.wgr, d.c.BVj);
            AppMethodBeat.o(191456);
            return true;
        }
        AppMethodBeat.o(191456);
        return false;
    }
}
