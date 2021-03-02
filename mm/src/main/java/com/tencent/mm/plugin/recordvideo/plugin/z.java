package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFocusPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "startTimeStamp", "", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "Companion", "plugin-recordvideo_release"})
public final class z implements t {
    public static final a BRL = new a((byte) 0);
    private long mvz = Util.currentTicks();
    private final CameraFrontSightView rsV;
    private final MMSightCaptureTouchView rsW;
    private View view;

    static {
        AppMethodBeat.i(75640);
        AppMethodBeat.o(75640);
    }

    public z(View view2, final d dVar) {
        p.h(view2, "view");
        p.h(dVar, "status");
        AppMethodBeat.i(75639);
        this.view = view2;
        View findViewById = this.view.findViewById(R.id.ajd);
        p.g(findViewById, "view.findViewById(R.id.capture_focus_frame)");
        this.rsV = (CameraFrontSightView) findViewById;
        View findViewById2 = this.view.findViewById(R.id.ajg);
        p.g(findViewById2, "view.findViewById(R.id.capture_touch_view)");
        this.rsW = (MMSightCaptureTouchView) findViewById2;
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.view.getContext(), 120);
        this.rsV.hd(fromDPToPix, fromDPToPix);
        this.rsW.setTouchCallback(new MMSightCaptureTouchView.a(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.z.AnonymousClass1 */
            final /* synthetic */ z BRM;

            {
                this.BRM = r1;
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void I(float f2, float f3) {
                AppMethodBeat.i(75635);
                Bundle bundle = new Bundle();
                bundle.putFloat("PARAM_POINT_X", f2);
                bundle.putFloat("PARAM_POINT_Y", f3);
                dVar.a(d.c.BUu, bundle);
                this.BRM.rsV.aa(f2, f3);
                AppMethodBeat.o(75635);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void cJL() {
                AppMethodBeat.i(75636);
                if (Util.ticksToNow(this.BRM.mvz) < 1000) {
                    AppMethodBeat.o(75636);
                    return;
                }
                this.BRM.mvz = Util.currentTicks();
                d.b.a(dVar, d.c.BUt);
                AppMethodBeat.o(75636);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void bqQ() {
                AppMethodBeat.i(75637);
                Bundle bundle = new Bundle();
                bundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
                bundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
                bundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
                dVar.a(d.c.BUs, bundle);
                AppMethodBeat.o(75637);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a
            public final void bqR() {
                AppMethodBeat.i(75638);
                Bundle bundle = new Bundle();
                bundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
                bundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
                bundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
                dVar.a(d.c.BUs, bundle);
                AppMethodBeat.o(75638);
            }
        });
        AppMethodBeat.o(75639);
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
        AppMethodBeat.i(237348);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237348);
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

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFocusPlugin$Companion;", "", "()V", "FLIP_BLOCK_TIME", "", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(237347);
        p.h(recordConfigProvider, "config");
        this.rsV.setFocusColor(recordConfigProvider.BOn.gLS);
        AppMethodBeat.o(237347);
    }
}
