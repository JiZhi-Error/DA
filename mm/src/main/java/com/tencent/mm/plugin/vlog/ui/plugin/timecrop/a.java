package com.tencent.mm.plugin.vlog.ui.plugin.timecrop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\"\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020\u0010H\u0016J\b\u00109\u001a\u000207H\u0016J\u0010\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020\u0017H\u0016J\u0012\u0010<\u001a\u0002072\b\u0010=\u001a\u0004\u0018\u000105H\u0016J\u0010\u0010>\u001a\u0002072\b\u0010?\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010@\u001a\u0002072\u0006\u0010A\u001a\u00020\u0010J\u000e\u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020DJ\u0010\u0010E\u001a\u0002072\u0006\u0010F\u001a\u00020GH\u0016R#\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0011\u001a\n \n*\u0004\u0018\u00010\u00120\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0019\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001a\u0010\fR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0004¢\u0006\u0004\n\u0002\u0010#R\u000e\u0010$\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u000e\u001a\u0004\b(\u0010)R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R#\u0010/\u001a\n \n*\u0004\u0018\u000100008BX\u0002¢\u0006\f\n\u0004\b3\u0010\u000e\u001a\u0004\b1\u00102R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelImg", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelImg", "()Landroid/widget/ImageView;", "cancelImg$delegate", "Lkotlin/Lazy;", "confirmed", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "cropEnd", "", "cropStart", "doneImg", "getDoneImg", "doneImg$delegate", "editTimeData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "Landroid/view/ViewGroup;", "getPanelRoot", "()Landroid/view/ViewGroup;", "panelRoot$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "timeRangeEnd", "timeRangeStart", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "trackCropView$delegate", "videoSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEditData", "data", "setEnableLengthEdit", "enable", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVisibility", "visibility", "", "Companion", "plugin-vlog_release"})
public final class a implements t, e.c {
    public static final C1873a GMC = new C1873a((byte) 0);
    private e.AbstractC1868e GGT;
    private final kotlin.f GGj = kotlin.g.ah(new i(this));
    private final kotlin.f GGk = kotlin.g.ah(new j(this));
    private boolean GGs;
    private long GHo;
    private long GHp;
    private long GHq;
    private long GHr;
    public com.tencent.mm.plugin.recordvideo.ui.editor.item.a GMA;
    private final h GMB = new h(this);
    private final kotlin.f GMw = kotlin.g.ah(new b(this));
    private final kotlin.f GMx = kotlin.g.ah(new g(this));
    private long GMy;
    private long GMz;
    private boolean gKM;
    private final kotlin.f tMy = kotlin.g.ah(new f(this));
    final com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
    final EditorPanelHolder wji;

    static {
        AppMethodBeat.i(191844);
        AppMethodBeat.o(191844);
    }

    private final TimeCropViewGroup fDn() {
        AppMethodBeat.i(191836);
        TimeCropViewGroup timeCropViewGroup = (TimeCropViewGroup) this.GGk.getValue();
        AppMethodBeat.o(191836);
        return timeCropViewGroup;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ a GMD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(1);
            this.GMD = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar;
            long j2;
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar2;
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar3;
            AppMethodBeat.i(191826);
            if (!bool.booleanValue()) {
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar = this.GMD.GMA;
                if (aVar != null) {
                    aVar.Ceu = null;
                }
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar2 = this.GMD.GMA;
                if (!(aVar2 == null || (dVar3 = aVar2.Cev) == null)) {
                    dVar3.ai(this.GMD.GMy, this.GMD.GMz);
                }
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar3 = this.GMD.GMA;
                if (aVar3 == null || (dVar2 = aVar3.Cev) == null) {
                    j2 = this.GMD.GHq;
                } else {
                    j2 = dVar2.Cgx.getTime();
                }
                this.GMD.GMA = null;
                d.b.a(this.GMD.wgr, d.c.BWv);
                com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar4 = this.GMD.wgr;
                d.c cVar = d.c.BWi;
                Bundle bundle = new Bundle();
                bundle.putLong("PARAM_1_LONG", j2);
                dVar4.a(cVar, bundle);
            } else {
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar4 = this.GMD.GMA;
                if (!(aVar4 == null || (dVar = aVar4.Cev) == null)) {
                    dVar.ai(0, 2147483647L);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(191826);
            return xVar;
        }
    }

    public a(EditorPanelHolder editorPanelHolder, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(editorPanelHolder, "holder");
        p.h(dVar, "status");
        AppMethodBeat.i(191843);
        this.wji = editorPanelHolder;
        this.wgr = dVar;
        AppMethodBeat.o(191843);
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
        AppMethodBeat.i(191845);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191845);
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

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.timecrop.a$a  reason: collision with other inner class name */
    public static final class C1873a {
        private C1873a() {
        }

        public /* synthetic */ C1873a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
    static final class i extends q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ a GMD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(a aVar) {
            super(0);
            this.GMD = aVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.timecrop.a$i$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC1874a implements View.OnClickListener {
            public static final View$OnClickListenerC1874a GME = new View$OnClickListenerC1874a();

            static {
                AppMethodBeat.i(191833);
                AppMethodBeat.o(191833);
            }

            View$OnClickListenerC1874a() {
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191832);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$panelRoot$2$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$panelRoot$2$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191832);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(191834);
            View inflate = LayoutInflater.from(this.GMD.wji.getContext()).inflate(R.layout.c6e, (ViewGroup) this.GMD.wji, false);
            EditorPanelHolder editorPanelHolder = this.GMD.wji;
            p.g(inflate, LocaleUtil.ITALIAN);
            EditorPanelHolder.a(editorPanelHolder, inflate);
            inflate.setOnClickListener(View$OnClickListenerC1874a.GME);
            if (inflate == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(191834);
                throw tVar;
            }
            ViewGroup viewGroup = (ViewGroup) inflate;
            AppMethodBeat.o(191834);
            return viewGroup;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"})
    public static final class h implements TimeCropViewGroup.a {
        final /* synthetic */ a GMD;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(a aVar) {
            this.GMD = aVar;
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup.a
        public final void d(long j2, long j3, boolean z) {
            Long l;
            long j4;
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar;
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar2;
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar3;
            Long l2 = null;
            AppMethodBeat.i(191831);
            StringBuilder append = new StringBuilder("onCropCallback: [").append(j2).append(", ").append(j3).append("], onUp:").append(z).append(", showTime start:");
            com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar = this.GMD.GMA;
            if (aVar == null || (dVar3 = aVar.Cev) == null) {
                l = null;
            } else {
                l = Long.valueOf(dVar3.getStart());
            }
            StringBuilder append2 = append.append(l).append(" end:");
            com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar2 = this.GMD.GMA;
            if (!(aVar2 == null || (dVar2 = aVar2.Cev) == null)) {
                l2 = Long.valueOf(dVar2.getEnd());
            }
            Log.i("MicroMsg.VLogTimeEditPlugin", append2.append(l2).toString());
            if (this.GMD.GHq != j2) {
                this.GMD.GHq = j2;
                this.GMD.GHr = j3;
                j4 = this.GMD.GHq;
            } else {
                this.GMD.GHq = j2;
                this.GMD.GHr = j3;
                j4 = this.GMD.GHr;
            }
            com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar3 = this.GMD.GMA;
            if (!(aVar3 == null || (dVar = aVar3.Ceu) == null)) {
                dVar.ai(this.GMD.GHq, this.GMD.GHr);
            }
            com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar4 = this.GMD.wgr;
            d.c cVar = d.c.BWk;
            Bundle bundle = new Bundle();
            bundle.putLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG", this.GMD.GHq);
            bundle.putLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG", this.GMD.GHr);
            bundle.putLong("EDIT_CROP_VLOG_SEEKTIME_LONG", j4);
            bundle.putBoolean("EDIT_CROP_VLOG_ON_UP_BOOLEAN", z);
            dVar4.a(cVar, bundle);
            AppMethodBeat.o(191831);
        }
    }

    private final void aTL() {
        AppMethodBeat.i(191837);
        if (this.gKM) {
            AppMethodBeat.o(191837);
            return;
        }
        this.gKM = true;
        this.wji.setCloseTouchOutside(true);
        fDn().setCallback(this.GMB);
        fDn().setRealTimeCallback(this.GMB);
        this.wji.setOnVisibleChangeCallback(new c(this));
        ((ImageView) this.GMw.getValue()).setOnClickListener(new d(this));
        ((ImageView) this.GMx.getValue()).setOnClickListener(new e(this));
        AppMethodBeat.o(191837);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ a GMD;

        d(a aVar) {
            this.GMD = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(191827);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GMD.wji.setShow(false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191827);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ a GMD;

        e(a aVar) {
            this.GMD = aVar;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar;
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar2;
            AppMethodBeat.i(191828);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.GMD.GMy == this.GMD.GHq && this.GMD.GMz == this.GMD.GHr) {
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar = this.GMD.GMA;
                if (!(aVar == null || (dVar2 = aVar.Cev) == null)) {
                    dVar2.ai(this.GMD.GHq, this.GMD.GHr);
                }
            } else {
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar2 = this.GMD.GMA;
                if (!(aVar2 == null || (dVar = aVar2.Cev) == null)) {
                    dVar.Cgx.a(null);
                    dVar.Cgx.Il(this.GMD.GHq);
                    dVar.Cgy.a(dVar.Cgx);
                    dVar.Cgy.Il(this.GMD.GHr - this.GMD.GHq);
                }
            }
            com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar3 = this.GMD.GMA;
            if (aVar3 != null) {
                aVar3.Ceu = null;
            }
            this.GMD.GMA = null;
            this.GMD.wji.setShow(false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191828);
        }
    }

    public final void setEnableLengthEdit(boolean z) {
        AppMethodBeat.i(191838);
        fDn().setEnableLengthEdit(z);
        AppMethodBeat.o(191838);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191839);
        if (i2 == 8) {
            this.GGs = false;
            this.wji.setShow(false);
        }
        AppMethodBeat.o(191839);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(191840);
        if (this.wji.bJw()) {
            this.GGs = false;
            this.wji.setShow(false);
            AppMethodBeat.o(191840);
            return true;
        }
        AppMethodBeat.o(191840);
        return false;
    }

    public final void setTrack(ac acVar) {
        AppMethodBeat.i(191841);
        p.h(acVar, "composition");
        com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar = this.GMA;
        if (aVar != null) {
            this.GGs = false;
            aTL();
            this.GHo = acVar.Gez.hfo().getStartUs() / 1000;
            this.GHp = acVar.Gez.hfo().getEndUs() / 1000;
            if (aVar.Cev.Cgy.getTime() > this.GHp) {
                com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c cVar = aVar.Cev.Cgy;
                cVar.Il(cVar.offset + (this.GHp - aVar.Cev.Cgy.getTime()));
            }
            this.GHq = aVar.Cev.Cgx.getTime();
            this.GHr = aVar.Cev.Cgy.getTime();
            this.GMy = this.GHq;
            this.GMz = this.GHr;
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d(0, false, 3);
            dVar.ai(this.GMy, this.GMz);
            aVar.Ceu = dVar;
            Log.i("MicroMsg.VLogTimeEditPlugin", "time range:" + aVar.Cev);
            TimeCropViewGroup fDn = fDn();
            com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar2 = this.GMA;
            if (aVar2 == null) {
                p.hyc();
            }
            long start = aVar2.Cev.getStart();
            com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar3 = this.GMA;
            if (aVar3 == null) {
                p.hyc();
            }
            fDn.a(acVar, start, aVar3.Cev.getEnd());
            this.wji.setShow(true);
            AppMethodBeat.o(191841);
            return;
        }
        AppMethodBeat.o(191841);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void a(e.AbstractC1868e eVar) {
        this.GGT = eVar;
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void onProgress(long j2) {
        AppMethodBeat.i(191842);
        fDn().setProgress(j2);
        AppMethodBeat.o(191842);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends q implements kotlin.g.a.a<Context> {
        final /* synthetic */ a GMD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a aVar) {
            super(0);
            this.GMD = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Context invoke() {
            AppMethodBeat.i(191829);
            Context context = this.GMD.wji.getContext();
            AppMethodBeat.o(191829);
            return context;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
    static final class j extends q implements kotlin.g.a.a<TimeCropViewGroup> {
        final /* synthetic */ a GMD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(a aVar) {
            super(0);
            this.GMD = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TimeCropViewGroup invoke() {
            AppMethodBeat.i(191835);
            View findViewById = a.g(this.GMD).findViewById(R.id.ium);
            TimeCropSliderSeekBar seekSlider = ((TimeCropViewGroup) findViewById).getSeekSlider();
            if (seekSlider != null) {
                seekSlider.fEg();
            }
            TimeCropViewGroup timeCropViewGroup = (TimeCropViewGroup) findViewById;
            AppMethodBeat.o(191835);
            return timeCropViewGroup;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ a GMD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(0);
            this.GMD = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(191825);
            ImageView imageView = (ImageView) a.g(this.GMD).findViewById(R.id.bw8);
            AppMethodBeat.o(191825);
            return imageView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ a GMD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(a aVar) {
            super(0);
            this.GMD = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(191830);
            ImageView imageView = (ImageView) a.g(this.GMD).findViewById(R.id.bw9);
            AppMethodBeat.o(191830);
            return imageView;
        }
    }

    public static final /* synthetic */ ViewGroup g(a aVar) {
        AppMethodBeat.i(191846);
        ViewGroup viewGroup = (ViewGroup) aVar.GGj.getValue();
        AppMethodBeat.o(191846);
        return viewGroup;
    }
}
