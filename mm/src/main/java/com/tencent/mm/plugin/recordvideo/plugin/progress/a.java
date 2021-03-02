package com.tencent.mm.plugin.recordvideo.plugin.progress;

import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0006\u0010\u001a\u001a\u00020\u0010J\u0014\u0010\u001b\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "progressBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getProgressBar", "()Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "setProgressBar", "(Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "prepareDelete", "", "delete", "", "removeCurrentProgress", "verify", "", "(Ljava/lang/Integer;)V", "reset", "setVisibility", "visibility", "subFinish", "updateProgress", "subProgress", "Ljava/util/ArrayList;", "", "plugin-recordvideo_release"})
public final class a implements t {
    public HorizontalSubProgressBar BXq;
    private d wgr;

    public a(HorizontalSubProgressBar horizontalSubProgressBar, d dVar) {
        p.h(horizontalSubProgressBar, "progressBar");
        p.h(dVar, "status");
        AppMethodBeat.i(237430);
        this.BXq = horizontalSubProgressBar;
        this.wgr = dVar;
        AppMethodBeat.o(237430);
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
        AppMethodBeat.i(237431);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237431);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    public final void aJ(ArrayList<Float> arrayList) {
        AppMethodBeat.i(237425);
        p.h(arrayList, "subProgress");
        this.BXq.aJ(arrayList);
        AppMethodBeat.o(237425);
    }

    public final void rl(boolean z) {
        AppMethodBeat.i(237426);
        this.BXq.rl(z);
        AppMethodBeat.o(237426);
    }

    public final void m(Integer num) {
        AppMethodBeat.i(237427);
        this.BXq.m(num);
        AppMethodBeat.o(237427);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(237428);
        if (i2 == 0) {
            this.BXq.bringToFront();
        }
        this.BXq.setVisibility(i2);
        AppMethodBeat.o(237428);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(237429);
        HorizontalSubProgressBar horizontalSubProgressBar = this.BXq;
        horizontalSubProgressBar.BXo = false;
        horizontalSubProgressBar.zBc.clear();
        horizontalSubProgressBar.postInvalidate();
        AppMethodBeat.o(237429);
    }
}
