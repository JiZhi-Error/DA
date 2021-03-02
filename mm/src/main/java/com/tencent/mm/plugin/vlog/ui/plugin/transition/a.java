package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.plugin.vlog.ui.plugin.transition.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020$H\u0016J\u001a\u0010)\u001a\u00020$2\u0006\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\fH\u0016J\u0016\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\fR\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\n \n*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditTransitionPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$EditTransitionListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "editSelectTrack", "", "getEditSelectTrack", "()I", "setEditSelectTrack", "(I)V", "editStartLoopTimeMs", "", "getEditStartLoopTimeMs", "()J", "setEditStartLoopTimeMs", "(J)V", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "transitionEditView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "onApplyTransitionToAll", "", "editTransitionIndex", "effect", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "onClose", "onSetTransition", "setVisibility", "visibility", "showEditTransitionDialog", "transitionIndex", "order", "Companion", "plugin-vlog_release"})
public final class a implements t, b.AbstractC1878b {
    public static final C1877a GNz = new C1877a((byte) 0);
    private final b GNw;
    public int GNx;
    public long GNy;
    private final Context context = this.parent.getContext();
    private ViewGroup parent;
    d wgr;
    private final EditorPanelHolder wji = ((EditorPanelHolder) this.parent.findViewById(R.id.bxu));

    static {
        AppMethodBeat.i(191969);
        AppMethodBeat.o(191969);
    }

    public a(ViewGroup viewGroup, d dVar) {
        p.h(viewGroup, "parent");
        p.h(dVar, "status");
        AppMethodBeat.i(191968);
        this.parent = viewGroup;
        this.wgr = dVar;
        Context context2 = this.context;
        p.g(context2, "context");
        this.GNw = new b(context2);
        this.GNx = -1;
        this.parent.setVisibility(0);
        EditorPanelHolder.a(this.wji, this.GNw);
        this.wji.setOnVisibleChangeCallback(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.transition.a.AnonymousClass1 */
            final /* synthetic */ a GNA;

            {
                this.GNA = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(191962);
                if (!bool.booleanValue()) {
                    d.b.a(this.GNA.wgr, d.c.BWA);
                    d.b.a(this.GNA.wgr, d.c.BWz);
                } else {
                    d.b.a(this.GNA.wgr, d.c.BWK);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(191962);
                return xVar;
            }
        });
        this.GNw.setEditTransitionListener(this);
        AppMethodBeat.o(191968);
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
        AppMethodBeat.i(191970);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191970);
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

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditTransitionPlugin$Companion;", "", "()V", "TAG", "", "TRANS_LOOP_TIME", "", "plugin-vlog_release"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.transition.a$a  reason: collision with other inner class name */
    public static final class C1877a {
        private C1877a() {
        }

        public /* synthetic */ C1877a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191963);
        if (i2 == 0) {
            d.b.a(this.wgr, d.c.BWw);
            AppMethodBeat.o(191963);
            return;
        }
        d.b.a(this.wgr, d.c.BWx);
        AppMethodBeat.o(191963);
    }

    public final void jx(int i2, int i3) {
        AppMethodBeat.i(191964);
        this.GNw.jy(i2, i3);
        this.wji.setShow(true);
        AppMethodBeat.o(191964);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.transition.b.AbstractC1878b
    public final void a(int i2, a.C1849a aVar) {
        int i3;
        AppMethodBeat.i(191965);
        d dVar = this.wgr;
        d.c cVar = d.c.BWC;
        Bundle bundle = new Bundle();
        bundle.putInt("EDIT_SELECT_TRANSITION_INDEX", i2);
        if (aVar != null) {
            i3 = aVar.order;
        } else {
            i3 = 0;
        }
        bundle.putInt("EDIT_TRANSITION_EFFECT_ID", i3);
        dVar.a(cVar, bundle);
        AppMethodBeat.o(191965);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.transition.b.AbstractC1878b
    public final void b(int i2, a.C1849a aVar) {
        int i3;
        AppMethodBeat.i(191966);
        d dVar = this.wgr;
        d.c cVar = d.c.BWB;
        Bundle bundle = new Bundle();
        bundle.putInt("EDIT_SELECT_TRANSITION_INDEX", i2);
        if (aVar != null) {
            com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
            com.tencent.mm.plugin.vlog.model.local.a.b(aVar);
        }
        if (aVar != null) {
            i3 = aVar.order;
        } else {
            i3 = 0;
        }
        bundle.putInt("EDIT_TRANSITION_EFFECT_ID", i3);
        dVar.a(cVar, bundle);
        AppMethodBeat.o(191966);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.transition.b.AbstractC1878b
    public final void onClose() {
        AppMethodBeat.i(191967);
        this.wji.setShow(false);
        AppMethodBeat.o(191967);
    }
}
