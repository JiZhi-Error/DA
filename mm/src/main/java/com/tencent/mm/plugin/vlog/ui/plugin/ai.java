package com.tencent.mm.plugin.vlog.ui.plugin;

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
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class ai implements t, e.c {
    e.AbstractC1868e GGT;
    e.AbstractC1868e GGU;
    private final kotlin.f GGj = kotlin.g.ah(new h(this));
    private final kotlin.f GGk = kotlin.g.ah(new i(this));
    private final kotlin.f GGl = kotlin.g.ah(new e(this));
    private final kotlin.f GGm = kotlin.g.ah(new a(this));
    private final kotlin.f GGn = kotlin.g.ah(new f(this));
    boolean GGs;
    private long GHo;
    private long GHp;
    long GHq;
    long GHr;
    private float GJA = 1.0f;
    private long GJB;
    private final g GJC = new g(this);
    private long GJz;
    final String TAG = "MicroMsg.VLogTrackEditPlugin";
    private boolean gKM;
    final com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
    final EditorPanelHolder wji;

    private final TextView dpN() {
        AppMethodBeat.i(191565);
        TextView textView = (TextView) this.GGl.getValue();
        AppMethodBeat.o(191565);
        return textView;
    }

    public final TrackCropView fDR() {
        AppMethodBeat.i(191564);
        TrackCropView trackCropView = (TrackCropView) this.GGk.getValue();
        AppMethodBeat.o(191564);
        return trackCropView;
    }

    public static final class d extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ ai GJD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ai aiVar) {
            super(1);
            this.GJD = aiVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(191555);
            if (!bool.booleanValue()) {
                Bundle bundle = new Bundle();
                bundle.putLong("EDIT_VLOG_TRACK_CROP_START", this.GJD.GHq);
                bundle.putLong("EDIT_VLOG_TRAKC_CROP_END", this.GJD.GHr);
                bundle.putBoolean("EDIT_VLOG_TRACK_CROP_CONFIRM", this.GJD.GGs);
                bundle.putBoolean("EDIT_VLOG_TRACK_CROP_CHANGE", false);
                bundle.putInt("EDIT_TRACK_DURATION_CUT_COUNT", this.GJD.fDR().getCutCnt());
                bundle.putInt("EDIT_TRACK_DURATION_SCROLL_COUNT", this.GJD.fDR().getDragCnt());
                this.GJD.wgr.a(d.c.BWc, bundle);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(191555);
            return xVar;
        }
    }

    public ai(EditorPanelHolder editorPanelHolder, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(editorPanelHolder, "holder");
        p.h(dVar, "status");
        AppMethodBeat.i(191574);
        this.wji = editorPanelHolder;
        this.wgr = dVar;
        AppMethodBeat.o(191574);
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
        AppMethodBeat.i(191575);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191575);
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

    public static final class g implements TrackCropView.a {
        final /* synthetic */ ai GJD;

        g(ai aiVar) {
            this.GJD = aiVar;
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView.a
        public final void az(long j2, long j3) {
            AppMethodBeat.i(191558);
            this.GJD.GHq = j2;
            this.GJD.GHr = j3;
            this.GJD.eTf();
            AppMethodBeat.o(191558);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView.a
        public final void ay(long j2, long j3) {
            AppMethodBeat.i(191559);
            Log.i(this.GJD.TAG, "onScrollStateChanged: " + j2 + ", " + j3);
            Bundle bundle = new Bundle();
            this.GJD.GHq = j2;
            this.GJD.GHr = j3;
            this.GJD.eTf();
            bundle.putLong("EDIT_VLOG_TRACK_CROP_START", j2);
            bundle.putLong("EDIT_VLOG_TRAKC_CROP_END", j3);
            bundle.putBoolean("EDIT_VLOG_TRACK_CROP_CHANGE", true);
            this.GJD.wgr.a(d.c.BWc, bundle);
            e.AbstractC1868e eVar = this.GJD.GGT;
            if (eVar != null) {
                eVar.resume();
                AppMethodBeat.o(191559);
                return;
            }
            AppMethodBeat.o(191559);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView.a
        public final void pause() {
            AppMethodBeat.i(191560);
            e.AbstractC1868e eVar = this.GJD.GGT;
            if (eVar != null) {
                eVar.pause();
            }
            e.AbstractC1868e eVar2 = this.GJD.GGU;
            if (eVar2 != null) {
                eVar2.pause();
                AppMethodBeat.o(191560);
                return;
            }
            AppMethodBeat.o(191560);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView.a
        public final void seekTo(long j2) {
            AppMethodBeat.i(191561);
            e.AbstractC1868e eVar = this.GJD.GGT;
            if (eVar != null) {
                eVar.Lb(j2);
                AppMethodBeat.o(191561);
                return;
            }
            AppMethodBeat.o(191561);
        }
    }

    public static final class b implements View.OnClickListener {
        final /* synthetic */ ai GJD;

        b(ai aiVar) {
            this.GJD = aiVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(191553);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GJD.GGs = false;
            this.GJD.wji.setShow(false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191553);
        }
    }

    public static final class c implements View.OnClickListener {
        final /* synthetic */ ai GJD;

        c(ai aiVar) {
            this.GJD = aiVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(191554);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GJD.GGs = true;
            this.GJD.wji.setShow(false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191554);
        }
    }

    public final void a(e.AbstractC1868e eVar, e.AbstractC1868e eVar2) {
        this.GGT = eVar;
        this.GGU = eVar2;
    }

    public final void setEnableLengthEdit(boolean z) {
        AppMethodBeat.i(191566);
        fDR().setEnableLengthEdit(z);
        AppMethodBeat.o(191566);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191567);
        if (i2 == 8) {
            this.GGs = false;
            this.wji.setShow(false);
        }
        AppMethodBeat.o(191567);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(191568);
        if (this.wji.bJw()) {
            this.GGs = false;
            this.wji.setShow(false);
            AppMethodBeat.o(191568);
            return true;
        }
        AppMethodBeat.o(191568);
        return false;
    }

    public static /* synthetic */ void a(ai aiVar, ad adVar, boolean z, long j2, int i2) {
        AppMethodBeat.i(191570);
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            j2 = MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        aiVar.a(adVar, z, j2);
        AppMethodBeat.o(191570);
    }

    private void a(ad adVar, boolean z, long j2) {
        AppMethodBeat.i(191569);
        p.h(adVar, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
        if (!z || this.GHr == 0) {
            this.GGs = false;
            if (!this.gKM) {
                this.gKM = true;
                this.wji.setCloseTouchOutside(false);
                fDR().setCallback(this.GJC);
                ImageView imageView = (ImageView) this.GGm.getValue();
                if (imageView != null) {
                    imageView.setOnClickListener(new b(this));
                }
                ImageView imageView2 = (ImageView) this.GGn.getValue();
                if (imageView2 != null) {
                    imageView2.setOnClickListener(new c(this));
                }
                this.wji.setOnVisibleChangeCallback(new d(this));
            }
            ad adVar2 = new ad(adVar.path, adVar.type);
            adVar2.KR(adVar.GzA.GJB);
            adVar2.KP((long) (((float) adVar.GzA.GJB) / adVar.GzA.mwH));
            adVar2.setPlayRate(adVar.GzA.mwH);
            adVar2.GzA.Rhd = 0;
            adVar2.GzA.Rhe = adVar2.GzA.endTimeMs;
            adVar2.GzA.gKp();
            this.GJz = adVar.GzA.startTimeMs;
            this.GHo = adVar.GzA.GGz;
            this.GHp = Math.min(adVar.GzA.GGA, j2);
            this.GJA = adVar.GzA.mwH;
            this.GHq = (long) (((float) this.GHo) / this.GJA);
            this.GHr = (long) (((float) this.GHp) / this.GJA);
            this.GJB = adVar.GzA.GJB;
            ac acVar = new ac(j.listOf(adVar2));
            acVar.at((long) (((float) this.GHo) / adVar.GzA.mwH), (long) (((float) this.GHp) / adVar.GzA.mwH));
            TrackCropView.a(fDR(), acVar);
            this.wji.setShow(true);
            eTf();
            AppMethodBeat.o(191569);
            return;
        }
        this.GJC.ay(this.GHq, this.GHr);
        AppMethodBeat.o(191569);
    }

    public final void eTf() {
        AppMethodBeat.i(191571);
        int round = Math.round((((float) this.GJB) / this.GJA) / 1000.0f);
        int round2 = Math.round(((float) (this.GHr - this.GHq)) / 1000.0f);
        TextView dpN = dpN();
        p.g(dpN, "hintText");
        dpN.setText(this.wji.getContext().getString(R.string.hy2, Integer.valueOf(round), Integer.valueOf(round2)));
        AppMethodBeat.o(191571);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void a(e.AbstractC1868e eVar) {
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void onProgress(long j2) {
        AppMethodBeat.i(191572);
        if (this.wji.bJw()) {
            fDR().setProgress(j2);
        }
        AppMethodBeat.o(191572);
    }

    public final boolean isShowing() {
        AppMethodBeat.i(191573);
        if (this.wji.getVisibility() == 0) {
            AppMethodBeat.o(191573);
            return true;
        }
        AppMethodBeat.o(191573);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static final class h extends q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ ai GJD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(ai aiVar) {
            super(0);
            this.GJD = aiVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(191562);
            View inflate = LayoutInflater.from(this.GJD.wji.getContext()).inflate(R.layout.c6f, (ViewGroup) this.GJD.wji, false);
            EditorPanelHolder editorPanelHolder = this.GJD.wji;
            p.g(inflate, LocaleUtil.ITALIAN);
            EditorPanelHolder.a(editorPanelHolder, inflate);
            if (inflate == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(191562);
                throw tVar;
            }
            ViewGroup viewGroup = (ViewGroup) inflate;
            AppMethodBeat.o(191562);
            return viewGroup;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class i extends q implements kotlin.g.a.a<TrackCropView> {
        final /* synthetic */ ai GJD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(ai aiVar) {
            super(0);
            this.GJD = aiVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TrackCropView invoke() {
            AppMethodBeat.i(191563);
            TrackCropView trackCropView = (TrackCropView) ai.a(this.GJD).findViewById(R.id.ium);
            AppMethodBeat.o(191563);
            return trackCropView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class e extends q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ ai GJD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ai aiVar) {
            super(0);
            this.GJD = aiVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(191556);
            TextView textView = (TextView) ai.a(this.GJD).findViewById(R.id.j92);
            AppMethodBeat.o(191556);
            return textView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ ai GJD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ai aiVar) {
            super(0);
            this.GJD = aiVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(191552);
            ImageView imageView = (ImageView) ai.a(this.GJD).findViewById(R.id.j8y);
            AppMethodBeat.o(191552);
            return imageView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class f extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ ai GJD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(ai aiVar) {
            super(0);
            this.GJD = aiVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(191557);
            ImageView imageView = (ImageView) ai.a(this.GJD).findViewById(R.id.j8z);
            AppMethodBeat.o(191557);
            return imageView;
        }
    }

    public static final /* synthetic */ ViewGroup a(ai aiVar) {
        AppMethodBeat.i(191576);
        ViewGroup viewGroup = (ViewGroup) aiVar.GGj.getValue();
        AppMethodBeat.o(191576);
        return viewGroup;
    }
}
