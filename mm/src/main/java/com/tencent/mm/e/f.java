package com.tencent.mm.e;

import android.graphics.Canvas;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.mm.cache.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/artists/FilterArtist;", "Lcom/tencent/mm/artists/BaseArtist;", "Lcom/tencent/mm/cache/FilterCache;", "()V", "TAG", "", "getType", "Lcom/tencent/mm/artists/ArtistType;", "onAlive", "", "onDeadDraw", "canvas", "Landroid/graphics/Canvas;", "onDraw", "onUndo", "select", FirebaseAnalytics.b.INDEX, "", "colorWeight", "", "plugin-photoedit-sdk_release"})
public final class f extends b<e> {
    private final String TAG = "MicroMsg.FilterArtist";

    @Override // com.tencent.mm.e.b
    public final a XS() {
        return a.FILTER;
    }

    @Override // com.tencent.mm.e.b
    public final void XT() {
    }

    @Override // com.tencent.mm.e.b
    public final void onAlive() {
        AppMethodBeat.i(163139);
        super.onAlive();
        e eVar = (e) XU();
        if (eVar != null) {
            b presenter = getPresenter();
            p.g(presenter, "presenter");
            eVar.gpE = presenter.gtm();
            AppMethodBeat.o(163139);
            return;
        }
        AppMethodBeat.o(163139);
    }

    @Override // com.tencent.mm.e.b
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(163140);
        p.h(canvas, "canvas");
        e eVar = (e) XU();
        if (eVar != null) {
            eVar.a(canvas, false);
        }
        Log.i(this.TAG, "lxl artist draw");
        AppMethodBeat.o(163140);
    }

    @Override // com.tencent.mm.e.b
    public final void d(Canvas canvas) {
        AppMethodBeat.i(163141);
        p.h(canvas, "canvas");
        e eVar = (e) XU();
        if (eVar != null) {
            eVar.a(canvas, false);
        }
        Log.i(this.TAG, "lxl artist onDeadDraw");
        AppMethodBeat.o(163141);
    }
}
