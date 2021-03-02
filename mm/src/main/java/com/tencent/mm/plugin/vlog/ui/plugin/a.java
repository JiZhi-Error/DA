package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.plugin.vlog.ui.plugin.v;
import com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView;
import com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackRecyclerView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0003*\u0001+\u0018\u0000 `2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001`B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020FJ\b\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020\u0012H\u0016J\b\u0010K\u001a\u00020IH\u0016J\u0010\u0010L\u001a\u00020I2\u0006\u0010M\u001a\u00020\u0014H\u0016J\u0012\u0010N\u001a\u00020I2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\"\u0010O\u001a\u00020I2\b\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010P\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\u0012H\u0016J\b\u0010R\u001a\u00020IH\u0016J\b\u0010S\u001a\u00020IH\u0016J\u0016\u0010T\u001a\u00020F2\u0006\u0010G\u001a\u00020F2\u0006\u0010U\u001a\u00020\u0012J\u000e\u0010V\u001a\u00020I2\u0006\u0010W\u001a\u00020\u0012J\u001a\u0010X\u001a\u00020I2\b\u0010Y\u001a\u0004\u0018\u00010;2\b\u0010Z\u001a\u0004\u0018\u00010;J\u0018\u0010[\u001a\u00020I2\u0006\u0010G\u001a\u00020F2\b\b\u0002\u0010&\u001a\u00020\u0014J\u0010\u0010\\\u001a\u00020I2\u0006\u0010]\u001a\u00020^H\u0016J\b\u0010_\u001a\u00020IH\u0002R#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0017\u001a\n \f*\u0004\u0018\u00010\u00180\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR#\u0010\u001c\u001a\n \f*\u0004\u0018\u00010\u001d0\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R#\u0010'\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b(\u0010\u000eR\u0010\u0010*\u001a\u00020+X\u0004¢\u0006\u0004\n\u0002\u0010,R\u001b\u0010-\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b.\u0010%R#\u00100\u001a\n \f*\u0004\u0018\u00010\u00180\u00188BX\u0002¢\u0006\f\n\u0004\b2\u0010\u0010\u001a\u0004\b1\u0010\u001aR#\u00103\u001a\n \f*\u0004\u0018\u000104048BX\u0002¢\u0006\f\n\u0004\b7\u0010\u0010\u001a\u0004\b5\u00106R\u000e\u00108\u001a\u000209X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R#\u0010@\u001a\n \f*\u0004\u0018\u00010A0A8BX\u0002¢\u0006\f\n\u0004\bD\u0010\u0010\u001a\u0004\bB\u0010C¨\u0006a"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelView", "()Landroid/widget/ImageView;", "cancelView$delegate", "Lkotlin/Lazy;", "confirmed", "", "cutDuration", "", "getCutDuration", "()J", "externalStatusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getExternalStatusIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "externalStatusIcon$delegate", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "getLayout", "()Landroid/view/ViewGroup;", "maxTrackEnd", "okView", "getOkView", "okView$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1;", "panelRoot", "getPanelRoot", "panelRoot$delegate", "playStatusIcon", "getPlayStatusIcon", "playStatusIcon$delegate", "progressIndicator", "Landroid/view/View;", "getProgressIndicator", "()Landroid/view/View;", "progressIndicator$delegate", "restorer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer;", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "sourceDuration", "getSourceDuration", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "trackCropView$delegate", "cache", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "composition", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "onUpdate", "seekTo", "seekToOriginPosition", "onVideoPause", "onVideoPlay", "restore", "restoreTrackTime", "setEnableLengthEdit", "enable", "setMediaPlayer", "videoSeeker", "audioSeeker", "setTrack", "setVisibility", "visibility", "", "updateHint", "Companion", "plugin-vlog_release"})
public final class a implements t, e.c, e.d, v.a {
    public static final C1859a GGv = new C1859a((byte) 0);
    private e.AbstractC1868e GDw;
    private final kotlin.f GGj = kotlin.g.ah(new k(this));
    private final kotlin.f GGk = kotlin.g.ah(new n(this));
    private final kotlin.f GGl = kotlin.g.ah(new h(this));
    private final kotlin.f GGm = kotlin.g.ah(new b(this));
    private final kotlin.f GGn = kotlin.g.ah(new i(this));
    private final kotlin.f GGo = kotlin.g.ah(new m(this));
    private final kotlin.f GGp = kotlin.g.ah(new g(this));
    private final kotlin.f GGq = kotlin.g.ah(new l(this));
    private long GGr;
    private boolean GGs;
    private final b GGt = new b();
    private final j GGu = new j(this);
    private boolean gKM;
    final ViewGroup wgq;
    final com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
    private final EditorPanelHolder wji;

    static {
        AppMethodBeat.i(191165);
        AppMethodBeat.o(191165);
    }

    private final TextView dpN() {
        AppMethodBeat.i(191151);
        TextView textView = (TextView) this.GGl.getValue();
        AppMethodBeat.o(191151);
        return textView;
    }

    private final MultiTrackCropView fCP() {
        AppMethodBeat.i(191150);
        MultiTrackCropView multiTrackCropView = (MultiTrackCropView) this.GGk.getValue();
        AppMethodBeat.o(191150);
        return multiTrackCropView;
    }

    private final WeImageView fCQ() {
        AppMethodBeat.i(191152);
        WeImageView weImageView = (WeImageView) this.GGq.getValue();
        AppMethodBeat.o(191152);
        return weImageView;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ a GGw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a aVar) {
            super(1);
            this.GGw = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(191137);
            if (!bool.booleanValue()) {
                com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar = this.GGw.wgr;
                d.c cVar = d.c.BWd;
                Bundle bundle = new Bundle();
                bundle.putBoolean("EDIT_VLOG_TRACK_CROP_CONFIRM", this.GGw.GGs);
                dVar.a(cVar, bundle);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(191137);
            return xVar;
        }
    }

    public a(ViewGroup viewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(viewGroup, "layout");
        p.h(dVar, "status");
        AppMethodBeat.i(191164);
        this.wgq = viewGroup;
        this.wgr = dVar;
        Context context = this.wgq.getContext();
        p.g(context, "layout.context");
        EditorPanelHolder editorPanelHolder = new EditorPanelHolder(context);
        this.wgq.addView(editorPanelHolder);
        editorPanelHolder.setVisibility(8);
        this.wji = editorPanelHolder;
        AppMethodBeat.o(191164);
    }

    public static final /* synthetic */ void g(a aVar) {
        AppMethodBeat.i(191170);
        aVar.eTf();
        AppMethodBeat.o(191170);
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
        AppMethodBeat.i(191166);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191166);
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

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.a$a  reason: collision with other inner class name */
    public static final class C1859a {
        private C1859a() {
        }

        public /* synthetic */ C1859a(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\tH\u0016¨\u0006\u0011"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$OnCropCallback;", "onTapDown", "", "position", "", "left", "", "startTimeMs", "", "endTimeMs", "onTapMove", "onTapUp", "pause", "resume", "seekTo", "time", "plugin-vlog_release"})
    public static final class j implements MultiTrackCropView.b {
        final /* synthetic */ a GGw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(a aVar) {
            this.GGw = aVar;
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView.b
        public final void a(int i2, boolean z, long j2, long j3) {
            AppMethodBeat.i(191141);
            View e2 = a.e(this.GGw);
            p.g(e2, "progressIndicator");
            e2.setVisibility(4);
            e.AbstractC1868e eVar = this.GGw.GDw;
            if (eVar != null) {
                eVar.pause();
            }
            com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar = this.GGw.wgr;
            d.c cVar = d.c.BWe;
            Bundle bundle = new Bundle();
            bundle.putInt("EDIT_COMPOSITION_TRACK_INDEX", i2);
            bundle.putBoolean("EDIT_COMPOSITION_LEFT", z);
            bundle.putLong("EDIT_VLOG_TRACK_CROP_START", j2);
            bundle.putLong("EDIT_VLOG_TRAKC_CROP_END", j3);
            dVar.a(cVar, bundle);
            AppMethodBeat.o(191141);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView.b
        public final void b(int i2, boolean z, long j2, long j3) {
            AppMethodBeat.i(191142);
            View e2 = a.e(this.GGw);
            p.g(e2, "progressIndicator");
            e2.setVisibility(0);
            com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar = this.GGw.wgr;
            d.c cVar = d.c.BWf;
            Bundle bundle = new Bundle();
            bundle.putInt("EDIT_COMPOSITION_TRACK_INDEX", i2);
            bundle.putBoolean("EDIT_COMPOSITION_LEFT", z);
            bundle.putLong("EDIT_VLOG_TRACK_CROP_START", j2);
            bundle.putLong("EDIT_VLOG_TRAKC_CROP_END", j3);
            dVar.a(cVar, bundle);
            a.g(this.GGw);
            AppMethodBeat.o(191142);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView.b
        public final void fCR() {
            AppMethodBeat.i(191143);
            a.g(this.GGw);
            AppMethodBeat.o(191143);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView.b
        public final void pause() {
            AppMethodBeat.i(191144);
            e.AbstractC1868e eVar = this.GGw.GDw;
            if (eVar != null) {
                eVar.pause();
                AppMethodBeat.o(191144);
                return;
            }
            AppMethodBeat.o(191144);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView.b
        public final void seekTo(long j2) {
            AppMethodBeat.i(191145);
            e.AbstractC1868e eVar = this.GGw.GDw;
            if (eVar != null) {
                eVar.Lb(j2);
                AppMethodBeat.o(191145);
                return;
            }
            AppMethodBeat.o(191145);
        }
    }

    private final void aTL() {
        AppMethodBeat.i(191153);
        if (this.gKM) {
            AppMethodBeat.o(191153);
            return;
        }
        this.gKM = true;
        this.wji.setCloseTouchOutside(false);
        fCP().setCallback(this.GGu);
        ((ImageView) this.GGm.getValue()).setOnClickListener(new c(this));
        ((ImageView) this.GGn.getValue()).setOnClickListener(new d(this));
        fCQ().setOnClickListener(new e(this));
        this.wji.setOnVisibleChangeCallback(new f(this));
        AppMethodBeat.o(191153);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ a GGw;

        c(a aVar) {
            this.GGw = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(191134);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GGw.GGs = false;
            this.GGw.wji.setShow(false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191134);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ a GGw;

        d(a aVar) {
            this.GGw = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(191135);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GGw.GGs = true;
            this.GGw.wji.setShow(false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191135);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ a GGw;

        e(a aVar) {
            this.GGw = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(191136);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a.c(this.GGw).performClick();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191136);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191154);
        if (i2 == 8) {
            this.GGs = false;
            this.wji.setShow(false);
        }
        AppMethodBeat.o(191154);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(191155);
        if (this.wji.bJw()) {
            this.GGs = false;
            this.wji.setShow(false);
            AppMethodBeat.o(191155);
            return true;
        }
        AppMethodBeat.o(191155);
        return false;
    }

    public final ac c(ac acVar) {
        AppMethodBeat.i(191156);
        p.h(acVar, "composition");
        ac c2 = this.GGt.c(acVar);
        AppMethodBeat.o(191156);
        return c2;
    }

    public final ac c(ac acVar, boolean z) {
        AppMethodBeat.i(191157);
        p.h(acVar, "composition");
        ac c2 = this.GGt.c(acVar, z);
        AppMethodBeat.o(191157);
        return c2;
    }

    public final void b(ac acVar, long j2) {
        AppMethodBeat.i(191158);
        p.h(acVar, "composition");
        this.GGs = false;
        aTL();
        this.GGr = j2;
        this.wji.setShow(true);
        fCP().setTrack(acVar);
        eTf();
        AppMethodBeat.o(191158);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void a(e.AbstractC1868e eVar) {
        this.GDw = eVar;
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.d
    public final void a(ac acVar, long j2, boolean z) {
        AppMethodBeat.i(191160);
        if (acVar != null && j2 >= 0) {
            MultiTrackCropView fCP = fCP();
            p.h(acVar, "composition");
            if (fCP.GPB) {
                fCP.GPB = false;
                Log.d("MicroMsg.MultiTrackCropView", "onUpdateComposition, seekTo: ".concat(String.valueOf(j2)));
                fCP.GPC = true;
                fCP.GPD = j2;
                fCP.GJb = true;
                int i2 = fCP.GPz + ((int) ((((float) ((j2 - fCP.wbl) * ((long) fCP.GJa))) * 1.0f) / ((float) (fCP.GhH - fCP.wbl))));
                MultiTrackRecyclerView multiTrackRecyclerView = fCP.GPx;
                if (multiTrackRecyclerView == null) {
                    p.btv("recyclerView");
                }
                multiTrackRecyclerView.smoothScrollBy(i2 - fCP.FVU, 0);
            }
        }
        AppMethodBeat.o(191160);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void onProgress(long j2) {
        AppMethodBeat.i(191161);
        if (this.wji.bJw()) {
            fCP().setProgress(j2);
        }
        AppMethodBeat.o(191161);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.v.a
    public final void onVideoPlay() {
        AppMethodBeat.i(191162);
        fCQ().setImageDrawable(ar.m(this.wgq.getContext(), R.raw.icons_filled_pause, -1));
        AppMethodBeat.o(191162);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.v.a
    public final void onVideoPause() {
        AppMethodBeat.i(191163);
        fCQ().setImageDrawable(ar.m(this.wgq.getContext(), R.raw.icons_filled_play, -1));
        AppMethodBeat.o(191163);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
    static final class k extends q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ a GGw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(a aVar) {
            super(0);
            this.GGw = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(191146);
            View inflate = LayoutInflater.from(this.GGw.wji.getContext()).inflate(R.layout.ayl, (ViewGroup) this.GGw.wji, false);
            EditorPanelHolder editorPanelHolder = this.GGw.wji;
            p.g(inflate, LocaleUtil.ITALIAN);
            EditorPanelHolder.a(editorPanelHolder, inflate);
            if (inflate == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(191146);
                throw tVar;
            }
            ViewGroup viewGroup = (ViewGroup) inflate;
            AppMethodBeat.o(191146);
            return viewGroup;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class n extends q implements kotlin.g.a.a<MultiTrackCropView> {
        final /* synthetic */ a GGw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(a aVar) {
            super(0);
            this.GGw = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiTrackCropView invoke() {
            AppMethodBeat.i(191149);
            MultiTrackCropView multiTrackCropView = (MultiTrackCropView) a.d(this.GGw).findViewById(R.id.ium);
            AppMethodBeat.o(191149);
            return multiTrackCropView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ a GGw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(a aVar) {
            super(0);
            this.GGw = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(191139);
            TextView textView = (TextView) a.d(this.GGw).findViewById(R.id.j92);
            AppMethodBeat.o(191139);
            return textView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ a GGw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(0);
            this.GGw = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(191133);
            ImageView imageView = (ImageView) a.d(this.GGw).findViewById(R.id.j8y);
            AppMethodBeat.o(191133);
            return imageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ a GGw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(a aVar) {
            super(0);
            this.GGw = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(191140);
            ImageView imageView = (ImageView) a.d(this.GGw).findViewById(R.id.j8z);
            AppMethodBeat.o(191140);
            return imageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ a GGw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(a aVar) {
            super(0);
            this.GGw = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191148);
            View findViewById = a.d(this.GGw).findViewById(R.id.j90);
            AppMethodBeat.o(191148);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ a GGw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(a aVar) {
            super(0);
            this.GGw = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(191138);
            WeImageView weImageView = (WeImageView) this.GGw.wgq.findViewById(R.id.j8r);
            AppMethodBeat.o(191138);
            return weImageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l extends q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ a GGw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(a aVar) {
            super(0);
            this.GGw = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(191147);
            WeImageView weImageView = (WeImageView) a.d(this.GGw).findViewById(R.id.j8r);
            AppMethodBeat.o(191147);
            return weImageView;
        }
    }

    private final void eTf() {
        AppMethodBeat.i(191159);
        long L = kotlin.h.a.L((double) (((float) fCP().getCutDuration()) / 1000.0f));
        long L2 = kotlin.h.a.L((double) (((float) Math.min(this.GGr, fCP().getCutDuration())) / 1000.0f));
        TextView dpN = dpN();
        p.g(dpN, "hintText");
        dpN.setText(this.wji.getContext().getString(R.string.hy2, Long.valueOf(L), Long.valueOf(L2)));
        TextView dpN2 = dpN();
        p.g(dpN2, "hintText");
        dpN2.setVisibility(fCP().getSourceDuration() > this.GGr ? 0 : 4);
        AppMethodBeat.o(191159);
    }

    public static final /* synthetic */ WeImageView c(a aVar) {
        AppMethodBeat.i(191167);
        WeImageView weImageView = (WeImageView) aVar.GGp.getValue();
        AppMethodBeat.o(191167);
        return weImageView;
    }

    public static final /* synthetic */ ViewGroup d(a aVar) {
        AppMethodBeat.i(191168);
        ViewGroup viewGroup = (ViewGroup) aVar.GGj.getValue();
        AppMethodBeat.o(191168);
        return viewGroup;
    }

    public static final /* synthetic */ View e(a aVar) {
        AppMethodBeat.i(191169);
        View view = (View) aVar.GGo.getValue();
        AppMethodBeat.o(191169);
        return view;
    }
}
