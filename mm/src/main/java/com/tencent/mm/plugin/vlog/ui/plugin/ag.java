package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.vlog.player.c;
import com.tencent.mm.plugin.vlog.player.k;
import com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewPlayerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPreloadPlayView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getPreviewHeight", "", "getPreviewWidth", "isRendering", "", "onDetach", "", "onPause", "onResume", "release", "renderScript", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "setMute", "mute", "Companion", "plugin-vlog_release"})
public final class ag implements t {
    public static final a GIU = new a((byte) 0);
    public VLogPreloadPlayView GIT;
    d wgr;

    static {
        AppMethodBeat.i(111167);
        AppMethodBeat.o(111167);
    }

    public ag(VLogPreloadPlayView vLogPreloadPlayView, d dVar) {
        p.h(vLogPreloadPlayView, "videoPreloadPlayView");
        p.h(dVar, "status");
        AppMethodBeat.i(111166);
        this.GIT = vLogPreloadPlayView;
        this.wgr = dVar;
        this.GIT.setOnSizeChangedListener(new m<Integer, Integer, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.ag.AnonymousClass1 */
            final /* synthetic */ ag GIV;

            {
                this.GIV = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Integer num, Integer num2) {
                AppMethodBeat.i(111161);
                int intValue = num.intValue();
                int intValue2 = num2.intValue();
                Log.i("MicroMsg.VLogPreviewPlayerPlugin", "onSizeChanged " + intValue + ' ' + intValue2);
                Bundle bundle = new Bundle();
                bundle.putInt("PARAM_WIDTH_INT", intValue);
                bundle.putInt("PARAM_HEIGHT_INT", intValue2);
                this.GIV.wgr.a(d.c.BVV, bundle);
                x xVar = x.SXb;
                AppMethodBeat.o(111161);
                return xVar;
            }
        });
        AppMethodBeat.o(111166);
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
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(191525);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191525);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewPlayerPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
        k kVar;
        AppMethodBeat.i(111162);
        VLogPreloadPlayView vLogPreloadPlayView = this.GIT;
        Log.i("MicroMsg.VLogPreloadPlayView", "resume");
        vLogPreloadPlayView.GOq = true;
        c cVar = vLogPreloadPlayView.GCP;
        if (!(cVar == null || (kVar = cVar.GBp) == null)) {
            kVar.j(new c.f(cVar));
        }
        vLogPreloadPlayView.n(vLogPreloadPlayView.ipT);
        AppMethodBeat.o(111162);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
        k kVar;
        AppMethodBeat.i(111163);
        VLogPreloadPlayView vLogPreloadPlayView = this.GIT;
        Log.i("MicroMsg.VLogPreloadPlayView", "pause");
        vLogPreloadPlayView.GOq = false;
        c cVar = vLogPreloadPlayView.GCP;
        if (!(cVar == null || (kVar = cVar.GBp) == null)) {
            kVar.j(new c.C1853c(cVar));
        }
        MMHandler mMHandler = vLogPreloadPlayView.GOo;
        if (mMHandler != null) {
            mMHandler.removeCallbacksAndMessages(null);
        }
        k kVar2 = vLogPreloadPlayView.GBp;
        if (kVar2 != null) {
            kVar2.fCo();
            AppMethodBeat.o(111163);
            return;
        }
        AppMethodBeat.o(111163);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(111164);
        VLogPreloadPlayView vLogPreloadPlayView = this.GIT;
        StringBuilder append = new StringBuilder("release  vLogDirector:").append(vLogPreloadPlayView.GCP).append("  ");
        c cVar = vLogPreloadPlayView.GCP;
        Log.i("MicroMsg.VLogPreloadPlayView", append.append(cVar != null ? cVar.hashCode() : 0).toString());
        c cVar2 = vLogPreloadPlayView.GCP;
        if (cVar2 != null) {
            cVar2.release();
        }
        k kVar = vLogPreloadPlayView.GBp;
        if (kVar != null) {
            kVar.release();
        }
        MMHandler mMHandler = vLogPreloadPlayView.GOo;
        if (mMHandler != null) {
            mMHandler.removeCallbacksAndMessages(null);
        }
        vLogPreloadPlayView.GOn.quitSafely();
        vLogPreloadPlayView.setSurfaceTextureListener(null);
        AppMethodBeat.o(111164);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
        AppMethodBeat.i(111165);
        VLogPreloadPlayView vLogPreloadPlayView = this.GIT;
        c cVar = vLogPreloadPlayView.GCP;
        if (cVar != null) {
            cVar.release();
        }
        k kVar = vLogPreloadPlayView.GBp;
        if (kVar != null) {
            kVar.release();
            AppMethodBeat.o(111165);
            return;
        }
        AppMethodBeat.o(111165);
    }
}
