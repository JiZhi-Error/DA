package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.y;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.webview.ui.tools.media.h;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0015\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u001e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryMpVideoReport;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "()V", "enterId", "", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "report17149", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "opType", "reportPause", "reportPlay", "updateMpVideoReportParams", "ui", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryUI;", "oldPos", "newPos", "Companion", "app_release"})
public final class f extends h {
    public static final a Pyo = new a((byte) 0);
    private static final String TAG = TAG;
    int pHu = ((int) (this.pLN / 1000));
    private long pLN = System.currentTimeMillis();

    public f() {
        AppMethodBeat.i(39735);
        AppMethodBeat.o(39735);
    }

    public final void a(ImageGalleryUI imageGalleryUI, int i2, int i3) {
        ca amt;
        y cG;
        int i4;
        j jVar;
        k amM;
        j jVar2;
        AppMethodBeat.i(39731);
        p.h(imageGalleryUI, "ui");
        if (i2 > 0 && (amt = imageGalleryUI.Pwu.amt(i2)) != null && amt.cWK() && (cG = j.cG(amt)) != null) {
            this.pLC = (int) (System.currentTimeMillis() - this.pLN);
            b bVar = imageGalleryUI.Pwu;
            if (bVar == null || (jVar = bVar.PwB) == null || (amM = jVar.amM(i2)) == null || (jVar2 = amM.PAO) == null) {
                i4 = 0;
            } else {
                i4 = jVar2.getCurrentPosition();
            }
            this.pLB = i4;
            a(cG, 2, this.pHu);
        }
        if (i3 > 0) {
            if (i2 > 0) {
                imageGalleryUI.PyB.jpW = 0;
            } else {
                imageGalleryUI.PyB.jpW = 1;
            }
            ca amt2 = imageGalleryUI.Pwu.amt(i3);
            if (amt2 == null || !amt2.cWK()) {
                AppMethodBeat.o(39731);
                return;
            }
            this.pLN = System.currentTimeMillis();
            this.scene = imageGalleryUI.getIntent().getIntExtra("KOpenArticleSceneFromScene", 1);
            this.pHw = 10000;
            y cG2 = j.cG(amt2);
            if (cG2 == null) {
                Log.w(TAG, "report17537 mpShareVideoInfo is null");
                AppMethodBeat.o(39731);
                return;
            }
            this.pLE = ab.IS(cG2.dHc);
            a(cG2, 1, this.pHu);
        }
        AppMethodBeat.o(39731);
    }

    public final void cA(ca caVar) {
        AppMethodBeat.i(39732);
        if (caVar == null || !caVar.cWK()) {
            AppMethodBeat.o(39732);
            return;
        }
        if (this.jpW != 4) {
            if (this.jpW != 3) {
                i(caVar, 8);
            }
            this.jpW = 3;
        }
        AppMethodBeat.o(39732);
    }

    public final void cB(ca caVar) {
        AppMethodBeat.i(39733);
        if (caVar == null || !caVar.cWK()) {
            AppMethodBeat.o(39733);
            return;
        }
        if (this.jpW != 2) {
            i(caVar, getPlayType());
            this.jpW = 2;
        }
        AppMethodBeat.o(39733);
    }

    public final void i(ca caVar, int i2) {
        AppMethodBeat.i(39734);
        if (caVar == null || !caVar.cWK()) {
            AppMethodBeat.o(39734);
            return;
        }
        a(j.cG(caVar), i2, this.pHu);
        AppMethodBeat.o(39734);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryMpVideoReport$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(39736);
        AppMethodBeat.o(39736);
    }
}
