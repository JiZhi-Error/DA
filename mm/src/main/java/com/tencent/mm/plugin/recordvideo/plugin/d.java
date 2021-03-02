package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rJ\b\u0010 \u001a\u00020\u001bH\u0002J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u001bH\u0016J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\rH\u0016J\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "inputPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;)V", "addTipGroup", "Landroid/widget/RelativeLayout;", "defaultVisibility", "", "getDefaultVisibility", "()I", "setDefaultVisibility", "(I)V", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "editText", "", "text", "", "color", "bgColor", "initSafeArea", "name", "", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "updateLayout", "bottomMargin", "plugin-recordvideo_release"})
public final class d implements View.OnClickListener, t {
    public final EditorInputView BPY;
    private final RelativeLayout BQb;
    public int BQc = 4;
    private ViewGroup parent;
    com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;

    public d(ViewGroup viewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar, EditorInputView editorInputView) {
        p.h(viewGroup, "parent");
        p.h(dVar, "status");
        p.h(editorInputView, "inputPanel");
        AppMethodBeat.i(75482);
        this.parent = viewGroup;
        this.wgr = dVar;
        this.BPY = editorInputView;
        View findViewById = this.parent.findViewById(R.id.bww);
        p.g(findViewById, "parent.findViewById(R.id.editor_add_tip_group)");
        this.BQb = (RelativeLayout) findViewById;
        this.BQb.setOnClickListener(this);
        this.BPY.setConfirmBtnBg(R.drawable.axi);
        this.BPY.setOnVisibleChangeCallback(new b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.d.AnonymousClass1 */
            final /* synthetic */ d BQd;

            {
                this.BQd = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(75474);
                if (bool.booleanValue()) {
                    d.b.a(this.BQd.wgr, d.c.BUV);
                } else {
                    d.b.a(this.BQd.wgr, d.c.BVj);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(75474);
                return xVar;
            }
        });
        this.BPY.setTipCallback(new EditorInputView.b(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.d.AnonymousClass2 */
            final /* synthetic */ d BQd;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.BQd = r1;
            }

            @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView.b
            public final void d(CharSequence charSequence, String str) {
                AppMethodBeat.i(237277);
                p.h(str, "font");
                this.BQd.BPY.setShow(false);
                if (charSequence != null) {
                    if (!(charSequence.length() == 0)) {
                        this.BQd.BQb.setVisibility(8);
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", charSequence);
                        bundle.putInt("PARAM_EDIT_TEXT_COLOR", -1);
                        bundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", 0);
                        this.BQd.wgr.a(d.c.BVb, bundle);
                        AppMethodBeat.o(237277);
                    }
                }
                this.BQd.BQb.setVisibility(0);
                Bundle bundle2 = new Bundle();
                bundle2.putCharSequence("PARAM_EDIT_TEXT_CONTENT", charSequence);
                bundle2.putInt("PARAM_EDIT_TEXT_COLOR", -1);
                bundle2.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", 0);
                this.BQd.wgr.a(d.c.BVb, bundle2);
                AppMethodBeat.o(237277);
            }

            @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView.b
            public final void onCancel() {
                AppMethodBeat.i(75476);
                this.BQd.BPY.setShow(false);
                AppMethodBeat.o(75476);
            }
        });
        Point az = au.az(this.parent.getContext());
        int i2 = az.y;
        int i3 = az.x;
        float f2 = ((float) i2) / ((float) i3);
        float f3 = (((float) i3) - (((float) i2) / 2.18f)) / 2.0f;
        if (f2 <= 1.78f || f2 < 2.18f) {
            this.BPY.bL(f3);
        }
        AppMethodBeat.o(75482);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
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
        AppMethodBeat.i(237278);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237278);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    public final void VD(int i2) {
        AppMethodBeat.i(75477);
        ViewGroup.LayoutParams layoutParams = this.BQb.getLayoutParams();
        if (layoutParams == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(75477);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i2;
        AppMethodBeat.o(75477);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(75478);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        this.BPY.mode = 1;
        this.BPY.setShow(true);
        EditorInputView.c cVar = EditorInputView.Cdg;
        int i2 = EditorInputView.Cde;
        EditorInputView.c cVar2 = EditorInputView.Cdg;
        this.BPY.g("", i2, EditorInputView.Cdf);
        c cVar3 = c.BXI;
        c.VH(18);
        a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75478);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(75479);
        this.BQb.setVisibility(i2);
        AppMethodBeat.o(75479);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(75480);
        if (this.BPY.bJw()) {
            this.BPY.setShow(false);
            AppMethodBeat.o(75480);
            return true;
        }
        AppMethodBeat.o(75480);
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return "plugin_tip";
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(75481);
        ViewGroup.LayoutParams layoutParams = this.BQb.getLayoutParams();
        if (layoutParams == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(75481);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = at.fromDPToPix(this.BQb.getContext(), 44);
        this.BQb.setVisibility(this.BQc);
        AppMethodBeat.o(75481);
    }
}
