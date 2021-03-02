package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001+B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0012J\u0006\u0010$\u001a\u00020\u000fJ\b\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\"H\u0016J\u000e\u0010'\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0012J\u0006\u0010(\u001a\u00020\"J\u0006\u0010)\u001a\u00020\"J\u0006\u0010*\u001a\u00020\"R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR#\u0010\u001b\u001a\n \t*\u0004\u0018\u00010\u001c0\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "isPlaying", "", "listeners", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "statusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getStatusIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "statusIcon$delegate", "useOperatePlaying", "addPlayStatusListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "needPlay", "onPause", "onResume", "removePlayStatusListener", "showPauseStatus", "showPlayStatus", "syncOperatePlaying", "PlayStatusListener", "plugin-vlog_release"})
public final class v implements t {
    private final f GIa = g.ah(new c(this));
    public boolean GIb = this.gVd;
    boolean gVd = true;
    private final List<a> listeners = new ArrayList();
    ViewGroup parent;
    private final f tMy = g.ah(new b(this));
    d wgr;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "", "onVideoPause", "", "onVideoPlay", "plugin-vlog_release"})
    public interface a {
        void onVideoPause();

        void onVideoPlay();
    }

    private final WeImageView fDD() {
        AppMethodBeat.i(191423);
        WeImageView weImageView = (WeImageView) this.GIa.getValue();
        AppMethodBeat.o(191423);
        return weImageView;
    }

    private final Context getContext() {
        AppMethodBeat.i(191422);
        Context context = (Context) this.tMy.getValue();
        AppMethodBeat.o(191422);
        return context;
    }

    public v(ViewGroup viewGroup, d dVar) {
        p.h(viewGroup, "parent");
        p.h(dVar, "status");
        AppMethodBeat.i(191429);
        this.parent = viewGroup;
        this.wgr = dVar;
        fDD().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.v.AnonymousClass1 */
            final /* synthetic */ v GIc;

            {
                this.GIc = r1;
            }

            public final void onClick(View view) {
                d.c cVar;
                AppMethodBeat.i(191419);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.GIc.gVd) {
                    this.GIc.fDF();
                    cVar = d.c.BVr;
                } else {
                    this.GIc.fDE();
                    cVar = d.c.BVs;
                }
                this.GIc.GIb = this.GIc.gVd;
                Bundle bundle = new Bundle();
                bundle.putBoolean("PARAM_1_BOOLEAN", true);
                this.GIc.wgr.a(cVar, bundle);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191419);
            }
        });
        AppMethodBeat.o(191429);
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
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(191430);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191430);
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

    public final void fDE() {
        AppMethodBeat.i(191424);
        fDD().setImageDrawable(ar.m(getContext(), R.raw.icons_filled_pause, -1));
        this.gVd = true;
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onVideoPlay();
        }
        AppMethodBeat.o(191424);
    }

    public final void fDF() {
        AppMethodBeat.i(191425);
        fDD().setImageDrawable(ar.m(getContext(), R.raw.icons_filled_play, -1));
        this.gVd = false;
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onVideoPause();
        }
        AppMethodBeat.o(191425);
    }

    public final void fDG() {
        this.GIb = this.gVd;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(191426);
        p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.add(aVar);
        AppMethodBeat.o(191426);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
        AppMethodBeat.i(191427);
        if (this.GIb) {
            fDE();
            d.b.a(this.wgr, d.c.BVs);
        }
        AppMethodBeat.o(191427);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
        AppMethodBeat.i(191428);
        fDF();
        d.b.a(this.wgr, d.c.BVr);
        AppMethodBeat.o(191428);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Context> {
        final /* synthetic */ v GIc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(v vVar) {
            super(0);
            this.GIc = vVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Context invoke() {
            AppMethodBeat.i(191420);
            Context context = this.GIc.parent.getContext();
            AppMethodBeat.o(191420);
            return context;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ v GIc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(v vVar) {
            super(0);
            this.GIc = vVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(191421);
            WeImageView weImageView = (WeImageView) this.GIc.parent.findViewById(R.id.j8r);
            AppMethodBeat.o(191421);
            return weImageView;
        }
    }
}
