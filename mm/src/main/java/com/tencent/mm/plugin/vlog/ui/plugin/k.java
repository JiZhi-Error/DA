package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropSliderSeekBar;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001!\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0002EFB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u00101\u001a\u000202J\b\u00103\u001a\u000202H\u0002J\b\u00104\u001a\u00020\u0010H\u0016J\b\u00105\u001a\u000202H\u0016J\u0010\u00106\u001a\u0002022\u0006\u00107\u001a\u00020\u0012H\u0016J\u0012\u00108\u001a\u0002022\b\u00109\u001a\u0004\u0018\u000100H\u0016J\u000e\u0010:\u001a\u0002022\u0006\u0010;\u001a\u00020\u0010J\u0016\u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u0012J\u000e\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020AJ\u0010\u0010B\u001a\u0002022\u0006\u0010C\u001a\u00020DH\u0016R#\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R#\u0010\u001d\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u001e\u0010\fR\u0010\u0010 \u001a\u00020!X\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010#\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R#\u0010%\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0002¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b&\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R#\u0010*\u001a\n \n*\u0004\u0018\u00010+0+8BX\u0002¢\u0006\f\n\u0004\b.\u0010\u000e\u001a\u0004\b,\u0010-R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "confirmed", "", "cropEnd", "", "cropStart", "editCallback", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "getEditCallback", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "setEditCallback", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;)V", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "okBtn", "getOkBtn", "okBtn$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "getPanelRoot", "panelRoot$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "trackCropView$delegate", "videoSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "cancel", "", "checkInit", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEnableLengthEdit", "enable", "setTimeRange", "start", "end", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVisibility", "visibility", "", "Companion", "EditCallback", "plugin-vlog_release"})
public final class k implements t, e.c {
    public static final a GHu = new a((byte) 0);
    private e.AbstractC1868e GGT;
    private final kotlin.f GGj = kotlin.g.ah(new C1871k(this));
    private final kotlin.f GGk = kotlin.g.ah(new l(this));
    boolean GGs;
    final kotlin.f GHn = kotlin.g.ah(new i(this));
    long GHo;
    long GHp;
    long GHq;
    long GHr;
    b GHs;
    final j GHt = new j(this);
    boolean gKM;
    final kotlin.f vJB = kotlin.g.ah(new c(this));
    final com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
    final EditorPanelHolder wji;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "", "onCrop", "", "start", "", "end", "onCropStart", "onDelete", "onFinish", "plugin-vlog_release"})
    public interface b {
        void ay(long j2, long j3);

        void eMs();

        void fDo();

        void onFinish();
    }

    static {
        AppMethodBeat.i(191306);
        AppMethodBeat.o(191306);
    }

    /* access modifiers changed from: package-private */
    public final View fDm() {
        AppMethodBeat.i(191299);
        View view = (View) this.GGj.getValue();
        AppMethodBeat.o(191299);
        return view;
    }

    /* access modifiers changed from: package-private */
    public final TimeCropViewGroup fDn() {
        AppMethodBeat.i(191300);
        TimeCropViewGroup timeCropViewGroup = (TimeCropViewGroup) this.GGk.getValue();
        AppMethodBeat.o(191300);
        return timeCropViewGroup;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ k GHv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(k kVar) {
            super(1);
            this.GHv = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(191290);
            if (!bool.booleanValue()) {
                Bundle bundle = new Bundle();
                bundle.putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", (int) this.GHv.GHq);
                this.GHv.wgr.a(d.c.BUW, bundle);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(191290);
            return xVar;
        }
    }

    public k(EditorPanelHolder editorPanelHolder, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(editorPanelHolder, "holder");
        p.h(dVar, "status");
        AppMethodBeat.i(191305);
        this.wji = editorPanelHolder;
        this.wgr = dVar;
        AppMethodBeat.o(191305);
    }

    public static final /* synthetic */ View b(k kVar) {
        AppMethodBeat.i(191308);
        View fDm = kVar.fDm();
        AppMethodBeat.o(191308);
        return fDm;
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
        AppMethodBeat.i(191307);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191307);
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

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"})
    public static final class j implements TimeCropViewGroup.a {
        final /* synthetic */ k GHv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(k kVar) {
            this.GHv = kVar;
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup.a
        public final void d(long j2, long j3, boolean z) {
            long j4;
            AppMethodBeat.i(191296);
            if (this.GHv.GHq != j2) {
                this.GHv.GHq = j2;
                this.GHv.GHr = j3;
                j4 = this.GHv.GHq;
            } else {
                this.GHv.GHq = j2;
                this.GHv.GHr = j3;
                j4 = this.GHv.GHr;
            }
            com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar = this.GHv.wgr;
            d.c cVar = d.c.BWk;
            Bundle bundle = new Bundle();
            bundle.putLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG", this.GHv.GHq);
            bundle.putLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG", this.GHv.GHr);
            dVar.a(cVar, bundle);
            if (z) {
                b bVar = this.GHv.GHs;
                if (bVar != null) {
                    bVar.ay(j2, j3);
                }
                e.AbstractC1868e eVar = this.GHv.GGT;
                if (eVar != null) {
                    eVar.Lb(this.GHv.GHq);
                }
                e.AbstractC1868e eVar2 = this.GHv.GGT;
                if (eVar2 != null) {
                    eVar2.resume();
                    AppMethodBeat.o(191296);
                    return;
                }
                AppMethodBeat.o(191296);
                return;
            }
            b bVar2 = this.GHv.GHs;
            if (bVar2 != null) {
                bVar2.fDo();
            }
            e.AbstractC1868e eVar3 = this.GHv.GGT;
            if (eVar3 != null) {
                eVar3.pause();
            }
            e.AbstractC1868e eVar4 = this.GHv.GGT;
            if (eVar4 != null) {
                eVar4.Lb(j4);
                AppMethodBeat.o(191296);
                return;
            }
            AppMethodBeat.o(191296);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ k GHv;

        e(k kVar) {
            this.GHv = kVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(191291);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GHv.cancel();
            this.GHv.wji.setShow(false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191291);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ k GHv;

        f(k kVar) {
            this.GHv = kVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(191292);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b bVar2 = this.GHv.GHs;
            if (bVar2 != null) {
                bVar2.onFinish();
            }
            this.GHv.wji.setShow(false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191292);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class g implements View.OnClickListener {
        final /* synthetic */ k GHv;

        g(k kVar) {
            this.GHv = kVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(191293);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b bVar2 = this.GHv.GHs;
            if (bVar2 != null) {
                bVar2.eMs();
            }
            this.GHv.wji.setShow(false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191293);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class h implements View.OnClickListener {
        final /* synthetic */ k GHv;

        h(k kVar) {
            this.GHv = kVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(191294);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b bVar2 = this.GHv.GHs;
            if (bVar2 != null) {
                bVar2.eMs();
            }
            this.GHv.wji.setShow(false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191294);
        }
    }

    public final void cancel() {
        AppMethodBeat.i(191301);
        this.GHq = this.GHo;
        this.GHr = this.GHp;
        b bVar = this.GHs;
        if (bVar != null) {
            bVar.ay(this.GHq, this.GHr);
        }
        b bVar2 = this.GHs;
        if (bVar2 != null) {
            bVar2.onFinish();
            AppMethodBeat.o(191301);
            return;
        }
        AppMethodBeat.o(191301);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191302);
        if (i2 == 8) {
            this.GGs = false;
            b bVar = this.GHs;
            if (bVar != null) {
                bVar.onFinish();
            }
            this.wji.setShow(false);
        }
        AppMethodBeat.o(191302);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(191303);
        if (this.wji.bJw()) {
            this.GGs = false;
            b bVar = this.GHs;
            if (bVar != null) {
                bVar.onFinish();
            }
            this.wji.setShow(false);
            AppMethodBeat.o(191303);
            return true;
        }
        AppMethodBeat.o(191303);
        return false;
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void a(e.AbstractC1868e eVar) {
        this.GGT = eVar;
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void onProgress(long j2) {
        AppMethodBeat.i(191304);
        fDn().setProgress(j2);
        AppMethodBeat.o(191304);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.k$k  reason: collision with other inner class name */
    static final class C1871k extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ k GHv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1871k(k kVar) {
            super(0);
            this.GHv = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191297);
            View inflate = LayoutInflater.from(this.GHv.wji.getContext()).inflate(R.layout.a0x, (ViewGroup) this.GHv.wji, false);
            EditorPanelHolder editorPanelHolder = this.GHv.wji;
            p.g(inflate, LocaleUtil.ITALIAN);
            EditorPanelHolder.a(editorPanelHolder, inflate);
            AppMethodBeat.o(191297);
            return inflate;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l extends q implements kotlin.g.a.a<TimeCropViewGroup> {
        final /* synthetic */ k GHv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(k kVar) {
            super(0);
            this.GHv = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TimeCropViewGroup invoke() {
            AppMethodBeat.i(191298);
            View findViewById = k.b(this.GHv).findViewById(R.id.ium);
            TimeCropSliderSeekBar seekSlider = ((TimeCropViewGroup) findViewById).getSeekSlider();
            if (seekSlider != null) {
                seekSlider.fEg();
            }
            TimeCropViewGroup timeCropViewGroup = (TimeCropViewGroup) findViewById;
            AppMethodBeat.o(191298);
            return timeCropViewGroup;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ k GHv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(k kVar) {
            super(0);
            this.GHv = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191289);
            View findViewById = k.b(this.GHv).findViewById(R.id.f5p);
            AppMethodBeat.o(191289);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ k GHv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(k kVar) {
            super(0);
            this.GHv = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191295);
            View findViewById = k.b(this.GHv).findViewById(R.id.f5q);
            AppMethodBeat.o(191295);
            return findViewById;
        }
    }
}
