package com.tencent.mm.plugin.emojicapture.model.a;

import android.support.v7.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\fJ\u0010\u0010\u001e\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u001f\u001a\u00020\u00142\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0!H\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendData;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "(Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;Landroid/support/v7/widget/RecyclerView$Adapter;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerRecommendCallback;", "preferIndex", "", "recommendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "selectedId", "updateSelection", "", "onInsert", "", "start", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "setPreferIndex", FirebaseAnalytics.b.INDEX, "setSelection", "updateData", "lensList", "", "plugin-emojicapture_release"})
public final class i implements c {
    private final String TAG = "MicroMsg.StickerRecommendData";
    private final RecyclerView.a<?> hbg;
    private final LinkedList<c> roR = new LinkedList<>();
    private String rpt;
    public int rpu = 1;
    private boolean rpv = true;
    private final h rpw;

    public i(h hVar, RecyclerView.a<?> aVar) {
        p.h(hVar, "callback");
        p.h(aVar, "adapter");
        AppMethodBeat.i(CdnLogic.kAppTypeFestivalVideo);
        this.rpw = hVar;
        this.hbg = aVar;
        AppMethodBeat.o(CdnLogic.kAppTypeFestivalVideo);
    }

    public final void setSelection(String str) {
        this.rpt = str;
        this.rpv = true;
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.a.c
    public final void ad(List<c> list) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(253);
        p.h(list, "lensList");
        Log.i(this.TAG, "updateData: " + list.size() + ", " + Util.getStack());
        this.roR.clear();
        this.roR.addAll(list);
        this.rpw.ad(this.roR);
        if (this.rpv) {
            if (!list.isEmpty()) {
                if (this.rpt == null) {
                    int i4 = this.rpu;
                    this.rpv = false;
                    i3 = i4;
                } else {
                    Iterator<c> it = list.iterator();
                    int i5 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i2 = -1;
                            break;
                        } else if (p.j(it.next().NMJ.Lso, this.rpt)) {
                            i2 = i5;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    if (i2 > 0) {
                        this.rpv = false;
                        i3 = i2;
                    }
                }
                this.rpw.Gn(i3);
            }
        }
        AppMethodBeat.o(253);
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.a.c
    public final void fH(int i2, int i3) {
        AppMethodBeat.i(254);
        this.hbg.as(i2, i3);
        AppMethodBeat.o(254);
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.a.c
    public final void fI(int i2, int i3) {
        AppMethodBeat.i(255);
        this.hbg.at(i2, i3);
        AppMethodBeat.o(255);
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.a.c
    public final void fJ(int i2, int i3) {
        AppMethodBeat.i(256);
        this.hbg.ar(i2, i3);
        AppMethodBeat.o(256);
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.a.c
    public final void fK(int i2, int i3) {
        AppMethodBeat.i(CdnLogic.kAppTypeFestivalImage);
        this.hbg.aq(i2, i3);
        AppMethodBeat.o(CdnLogic.kAppTypeFestivalImage);
    }
}
