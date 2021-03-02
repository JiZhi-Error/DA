package com.tencent.mm;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.e;
import com.tencent.mm.api.u;
import com.tencent.mm.api.x;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.l;
import com.tencent.mm.view.m;
import com.tencent.mm.view.o;

public final class b extends ab {
    private com.tencent.mm.view.a dgg;
    private x dgh;

    @Override // com.tencent.mm.api.ab
    public final e bB(Context context) {
        AppMethodBeat.i(9098);
        if (this.dgg == null) {
            Log.d("MicroMsg.MMPhotoEditorImpl", "mDrawingView == null, create a new one");
            if (this.diP.diR == ab.c.diY) {
                this.dgg = new o(context);
            } else if (this.diP.diR == ab.c.PHOTO) {
                this.dgg = new m(context);
            } else if (this.diP.diR == ab.c.SCREEN) {
                this.dgg = new l(context);
            }
        } else {
            Log.d("MicroMsg.MMPhotoEditorImpl", "recycled");
            if (this.dgg.getParent() != null) {
                ((ViewGroup) this.dgg.getParent()).removeView(this.dgg);
            }
        }
        this.dgg.setup(this.diP);
        com.tencent.mm.view.a aVar = this.dgg;
        AppMethodBeat.o(9098);
        return aVar;
    }

    @Override // com.tencent.mm.api.ab
    public final void a(ab.a aVar) {
        AppMethodBeat.i(9101);
        super.a(aVar);
        ArtistCacheManager.alA().Dn(Util.nullAs(this.diP.path, "MicroMsg.MMPhotoEditorImpl"));
        c.alF().Dp(Util.nullAs(this.diP.path, "MicroMsg.MMPhotoEditorImpl"));
        AppMethodBeat.o(9101);
    }

    @Override // com.tencent.mm.api.ab
    public final x Um() {
        AppMethodBeat.i(9103);
        if (this.dgh == null) {
            this.dgh = new com.tencent.mm.bz.c(this.dgg.getPresenter());
        }
        x xVar = this.dgh;
        AppMethodBeat.o(9103);
        return xVar;
    }

    public static class a implements ab.b {
        @Override // com.tencent.mm.api.ab.b
        public final ab Uo() {
            AppMethodBeat.i(9097);
            b bVar = new b();
            AppMethodBeat.o(9097);
            return bVar;
        }
    }

    @Override // com.tencent.mm.api.ab
    public final void Un() {
        AppMethodBeat.i(9104);
        ArtistCacheManager.alA().alB();
        AppMethodBeat.o(9104);
    }

    @Override // com.tencent.mm.api.ab
    public final void a(u uVar) {
        AppMethodBeat.i(9099);
        this.dgg.getPresenter().a(uVar, !Um().VE());
        AppMethodBeat.o(9099);
    }

    @Override // com.tencent.mm.api.ab
    public final boolean Ul() {
        AppMethodBeat.i(9100);
        boolean Ul = this.dgg.getPresenter().Ul();
        AppMethodBeat.o(9100);
        return Ul;
    }

    @Override // com.tencent.mm.api.ab
    public final void onDestroy() {
        AppMethodBeat.i(9102);
        if (this.diP != null && !this.diP.diS) {
            ArtistCacheManager.alA().Do(Util.nullAs(this.diP.path, "MicroMsg.MMPhotoEditorImpl"));
        }
        if (this.dgg != null) {
            this.dgg.getPresenter().onDestroy();
        }
        try {
            this.dgg.getChatFooterPanel().destroy();
            AppMethodBeat.o(9102);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMPhotoEditorImpl", "[onDestroy] may be has destory!");
            AppMethodBeat.o(9102);
        }
    }
}
