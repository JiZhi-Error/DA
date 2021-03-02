package com.tencent.mm.plugin.finder.video;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u000b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u000eR\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/RecordCountdownPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "countdownContainer", "countdownText", "Landroid/widget/TextView;", "countdownTimer", "com/tencent/mm/plugin/finder/video/RecordCountdownPlugin$countdownTimer$1", "Lcom/tencent/mm/plugin/finder/video/RecordCountdownPlugin$countdownTimer$1;", "cancelCountdown", "", "setVisibility", "visibility", "", "startCountdown", "Companion", "plugin-finder_release"})
public final class v implements t {
    public static final a wgs = new a((byte) 0);
    final ViewGroup wgn;
    final TextView wgo;
    final b wgp = new b(this);
    private final ViewGroup wgq;
    private final d wgr;

    static {
        AppMethodBeat.i(254409);
        AppMethodBeat.o(254409);
    }

    public v(ViewGroup viewGroup, d dVar) {
        p.h(viewGroup, "layout");
        p.h(dVar, "status");
        AppMethodBeat.i(254408);
        this.wgq = viewGroup;
        this.wgr = dVar;
        View findViewById = this.wgq.findViewById(R.id.bge);
        p.g(findViewById, "layout.findViewById(R.id.countdown_container)");
        this.wgn = (ViewGroup) findViewById;
        View findViewById2 = this.wgq.findViewById(R.id.bgj);
        p.g(findViewById2, "layout.findViewById(R.id.countdown_text)");
        this.wgo = (TextView) findViewById2;
        AppMethodBeat.o(254408);
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
        AppMethodBeat.i(254410);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(254410);
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

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/RecordCountdownPlugin$Companion;", "", "()V", "COUNTDOWN_DURATION", "", "COUNTDOWN_INTERVAL", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/video/RecordCountdownPlugin$countdownTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "plugin-finder_release"})
    public static final class b extends CountDownTimer {
        final /* synthetic */ v wgt;

        /* JADX WARN: Incorrect types in method signature: (J)V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(v vVar) {
            super(3000, 1000);
            this.wgt = vVar;
        }

        public final void onFinish() {
            AppMethodBeat.i(254406);
            this.wgt.wgn.setVisibility(8);
            d.b.a(this.wgt.wgr, d.c.BUP);
            AppMethodBeat.o(254406);
        }

        public final void onTick(long j2) {
            AppMethodBeat.i(254407);
            this.wgt.wgo.setText(String.valueOf(kotlin.h.a.cR(((float) j2) / 1000.0f)));
            AppMethodBeat.o(254407);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
    }
}
