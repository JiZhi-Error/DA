package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.ui.LabelSlider;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00107\u001a\u00020\u0011H\u0016J\u000e\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u0019R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0014\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0015\u0010\rR7\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R4\u0010$\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\b0\b \u000b*\u0012\u0012\u000e\b\u0001\u0012\n \u000b*\u0004\u0018\u00010\b0\b0%0%X\u0004¢\u0006\u0004\n\u0002\u0010&R#\u0010'\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u000f\u001a\u0004\b(\u0010\rR\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00190+X\u0004¢\u0006\u0002\n\u0000R5\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010!R\u000e\u0010/\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R#\u00100\u001a\n \u000b*\u0004\u0018\u000101018BX\u0002¢\u0006\f\n\u0004\b4\u0010\u000f\u001a\u0004\b2\u00103R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/TrackDurationScalePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "confirmed", "", "currentScaleIndex", "", "doneBtn", "getDoneBtn", "doneBtn$delegate", "finishScaleCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "scale", "", "getFinishScaleCallback", "()Lkotlin/jvm/functions/Function1;", "setFinishScaleCallback", "(Lkotlin/jvm/functions/Function1;)V", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "labelList", "", "[Ljava/lang/String;", "panelRoot", "getPanelRoot", "panelRoot$delegate", "playRateList", "", "scaleCallback", "getScaleCallback", "setScaleCallback", "setupPlayRate", "slider", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider;", "getSlider", "()Lcom/tencent/mm/plugin/vlog/ui/LabelSlider;", "slider$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "onBackPress", "setup", "currentPlayRate", "plugin-vlog_release"})
public final class ae implements t {
    private final kotlin.f GGj = kotlin.g.ah(new d(this));
    boolean GGs;
    private final kotlin.f GIJ = kotlin.g.ah(new i(this));
    private final kotlin.f GIK = kotlin.g.ah(new b(this));
    final List<Float> GIL = j.listOf((Object[]) new Float[]{Float.valueOf(0.5f), Float.valueOf(0.75f), Float.valueOf(1.0f), Float.valueOf(1.5f), Float.valueOf(2.0f)});
    private final String[] GIM;
    float GIN;
    int GIO;
    kotlin.g.a.b<? super Float, x> GIP;
    kotlin.g.a.b<? super Float, x> GIQ;
    final String TAG = "MicroMsg.TrackDurationScalePlugin";
    private final kotlin.f vJB = kotlin.g.ah(new a(this));
    final com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
    public final EditorPanelHolder wji;

    private final LabelSlider fDP() {
        AppMethodBeat.i(191513);
        LabelSlider labelSlider = (LabelSlider) this.GIJ.getValue();
        AppMethodBeat.o(191513);
        return labelSlider;
    }

    private final View fDQ() {
        AppMethodBeat.i(191515);
        View view = (View) this.GIK.getValue();
        AppMethodBeat.o(191515);
        return view;
    }

    private final View getCancelBtn() {
        AppMethodBeat.i(191514);
        View view = (View) this.vJB.getValue();
        AppMethodBeat.o(191514);
        return view;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class c extends q implements kotlin.g.a.b<Float, x> {
        final /* synthetic */ ae GIR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ae aeVar) {
            super(1);
            this.GIR = aeVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Float f2) {
            AppMethodBeat.i(191506);
            float floatValue = f2.floatValue();
            Bundle bundle = new Bundle();
            bundle.putFloat("EDIT_TRACK_DURATION_SCALE", floatValue);
            this.GIR.wgr.a(d.c.BWn, bundle);
            x xVar = x.SXb;
            AppMethodBeat.o(191506);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class e extends q implements kotlin.g.a.b<Float, x> {
        final /* synthetic */ ae GIR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ae aeVar) {
            super(1);
            this.GIR = aeVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Float f2) {
            AppMethodBeat.i(191508);
            float floatValue = f2.floatValue();
            Bundle bundle = new Bundle();
            bundle.putFloat("EDIT_TRACK_DURATION_SCALE", floatValue);
            this.GIR.wgr.a(d.c.BWm, bundle);
            x xVar = x.SXb;
            AppMethodBeat.o(191508);
            return xVar;
        }
    }

    public ae(EditorPanelHolder editorPanelHolder, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(editorPanelHolder, "holder");
        p.h(dVar, "status");
        AppMethodBeat.i(191518);
        this.wji = editorPanelHolder;
        this.wgr = dVar;
        Context context = this.wji.getContext();
        p.g(context, "holder.context");
        String[] stringArray = context.getResources().getStringArray(R.array.at);
        p.g(stringArray, "holder.context.resources…dit_duration_scale_array)");
        this.GIM = stringArray;
        this.GIN = 1.0f;
        this.GIP = new c(this);
        this.GIQ = new e(this);
        this.wji.setOnVisibleChangeCallback(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.ae.AnonymousClass1 */
            final /* synthetic */ ae GIR;

            {
                this.GIR = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(191503);
                if (!bool.booleanValue()) {
                    if (!this.GIR.GGs) {
                        kotlin.g.a.b<? super Float, x> bVar = this.GIR.GIP;
                        if (bVar != null) {
                            bVar.invoke(Float.valueOf(this.GIR.GIN));
                        }
                    } else {
                        kotlin.g.a.b<? super Float, x> bVar2 = this.GIR.GIP;
                        if (bVar2 != null) {
                            bVar2.invoke(this.GIR.GIL.get(this.GIR.GIO));
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(191503);
                return xVar;
            }
        });
        this.wji.setCloseTouchOutside(false);
        AppMethodBeat.o(191518);
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
        AppMethodBeat.i(191519);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191519);
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

    public final void ch(float f2) {
        AppMethodBeat.i(191516);
        this.GIN = f2;
        int indexOf = this.GIL.indexOf(Float.valueOf(f2));
        if (indexOf < 0) {
            indexOf = this.GIL.size() / 2;
        }
        this.GIO = indexOf;
        fDP().setLabelCount(this.GIL.size());
        fDP().setSelection(indexOf);
        fDP().setLabels(kotlin.a.e.W(this.GIM));
        fDP().setCallback(new f(this));
        getCancelBtn().setOnClickListener(new g(this));
        fDQ().setOnClickListener(new h(this));
        this.GGs = false;
        this.wji.setShow(true);
        AppMethodBeat.o(191516);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/TrackDurationScalePlugin$setup$1", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "onSelected", "", FirebaseAnalytics.b.INDEX, "", "plugin-vlog_release"})
    public static final class f implements LabelSlider.a {
        final /* synthetic */ ae GIR;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(ae aeVar) {
            this.GIR = aeVar;
        }

        @Override // com.tencent.mm.plugin.vlog.ui.LabelSlider.a
        public final void Ir(int i2) {
            AppMethodBeat.i(191509);
            Log.i(this.GIR.TAG, "onSelected: ".concat(String.valueOf(i2)));
            this.GIR.GIO = i2;
            kotlin.g.a.b<? super Float, x> bVar = this.GIR.GIQ;
            if (bVar != null) {
                bVar.invoke(this.GIR.GIL.get(i2));
                AppMethodBeat.o(191509);
                return;
            }
            AppMethodBeat.o(191509);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class g implements View.OnClickListener {
        final /* synthetic */ ae GIR;

        g(ae aeVar) {
            this.GIR = aeVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(191510);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/TrackDurationScalePlugin$setup$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GIR.GGs = false;
            this.GIR.wji.setShow(false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/TrackDurationScalePlugin$setup$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191510);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class h implements View.OnClickListener {
        final /* synthetic */ ae GIR;

        h(ae aeVar) {
            this.GIR = aeVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(191511);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/TrackDurationScalePlugin$setup$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GIR.GGs = true;
            this.GIR.wji.setShow(false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/TrackDurationScalePlugin$setup$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191511);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(191517);
        if (this.wji.bJw()) {
            this.wji.setShow(false);
            AppMethodBeat.o(191517);
            return true;
        }
        AppMethodBeat.o(191517);
        return false;
    }

    public static final /* synthetic */ View a(ae aeVar) {
        AppMethodBeat.i(191520);
        View view = (View) aeVar.GGj.getValue();
        AppMethodBeat.o(191520);
        return view;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ ae GIR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ae aeVar) {
            super(0);
            this.GIR = aeVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191507);
            View inflate = LayoutInflater.from(this.GIR.wji.getContext()).inflate(R.layout.azd, (ViewGroup) this.GIR.wji, false);
            EditorPanelHolder editorPanelHolder = this.GIR.wji;
            p.g(inflate, LocaleUtil.ITALIAN);
            EditorPanelHolder.a(editorPanelHolder, inflate);
            AppMethodBeat.o(191507);
            return inflate;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends q implements kotlin.g.a.a<LabelSlider> {
        final /* synthetic */ ae GIR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(ae aeVar) {
            super(0);
            this.GIR = aeVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LabelSlider invoke() {
            AppMethodBeat.i(191512);
            LabelSlider labelSlider = (LabelSlider) ae.a(this.GIR).findViewById(R.id.iun);
            AppMethodBeat.o(191512);
            return labelSlider;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ ae GIR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ae aeVar) {
            super(0);
            this.GIR = aeVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191504);
            View findViewById = ae.a(this.GIR).findViewById(R.id.iul);
            AppMethodBeat.o(191504);
            return findViewById;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ ae GIR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ae aeVar) {
            super(0);
            this.GIR = aeVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191505);
            View findViewById = ae.a(this.GIR).findViewById(R.id.iuo);
            AppMethodBeat.o(191505);
            return findViewById;
        }
    }
}
