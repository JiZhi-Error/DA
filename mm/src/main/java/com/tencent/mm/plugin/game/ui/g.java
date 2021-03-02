package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.ui.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class g extends m {
    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void Ot(int i2) {
        AppMethodBeat.i(41941);
        super.Ot(i2);
        AppMethodBeat.o(41941);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void a(m.a aVar) {
        AppMethodBeat.i(41933);
        super.a(aVar);
        AppMethodBeat.o(41933);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void aAA(String str) {
        AppMethodBeat.i(41928);
        super.aAA(str);
        AppMethodBeat.o(41928);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void aAB(String str) {
        AppMethodBeat.i(41929);
        super.aAB(str);
        AppMethodBeat.o(41929);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void aAC(String str) {
        AppMethodBeat.i(41930);
        super.aAC(str);
        AppMethodBeat.o(41930);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList] */
    @Override // com.tencent.mm.plugin.game.ui.m, com.tencent.mm.plugin.game.ui.a
    public final /* bridge */ /* synthetic */ void aU(LinkedList<c> linkedList) {
        AppMethodBeat.i(41939);
        super.aU(linkedList);
        AppMethodBeat.o(41939);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList] */
    @Override // com.tencent.mm.plugin.game.ui.m, com.tencent.mm.plugin.game.ui.a
    public final /* bridge */ /* synthetic */ void aV(LinkedList<c> linkedList) {
        AppMethodBeat.i(41938);
        super.aV(linkedList);
        AppMethodBeat.o(41938);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void aj(View view, int i2) {
        AppMethodBeat.i(41932);
        super.aj(view, i2);
        AppMethodBeat.o(41932);
    }

    @Override // com.tencent.mm.plugin.game.ui.m, com.tencent.mm.plugin.game.ui.a
    public final /* bridge */ /* synthetic */ void clear() {
        AppMethodBeat.i(41931);
        super.clear();
        AppMethodBeat.o(41931);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void f(SparseArray sparseArray) {
        AppMethodBeat.i(41934);
        super.f(sparseArray);
        AppMethodBeat.o(41934);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ int getItemViewType(int i2) {
        AppMethodBeat.i(41937);
        int itemViewType = super.getItemViewType(i2);
        AppMethodBeat.o(41937);
        return itemViewType;
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(41935);
        View view2 = super.getView(i2, view, viewGroup);
        AppMethodBeat.o(41935);
        return view2;
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ int getViewTypeCount() {
        AppMethodBeat.i(41936);
        int viewTypeCount = super.getViewTypeCount();
        AppMethodBeat.o(41936);
        return viewTypeCount;
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void refresh() {
        AppMethodBeat.i(41940);
        super.refresh();
        AppMethodBeat.o(41940);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void setSourceScene(int i2) {
        AppMethodBeat.i(41942);
        super.setSourceScene(i2);
        AppMethodBeat.o(41942);
    }

    public g(Context context) {
        super(context);
        this.xTV = R.layout.aph;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.game.ui.m
    public final void a(c cVar, m.b bVar, int i2) {
        AppMethodBeat.i(41927);
        bVar.xUg.setText(new StringBuilder().append(cVar.position).toString());
        Bitmap aAz = aAz(cVar.field_appId);
        if (aAz == null || aAz.isRecycled()) {
            bVar.xUh.setImageResource(R.drawable.beg);
        } else {
            bVar.xUh.setImageBitmap(aAz);
        }
        bVar.xTl.setText(cVar.field_appName);
        if (Util.isNullOrNil(cVar.xDV)) {
            bVar.xUk.setVisibility(8);
        } else {
            bVar.xUk.setVisibility(0);
            bVar.xUk.setText(cVar.xDV);
        }
        if (!Util.isNullOrNil(cVar.xEe)) {
            bVar.xUi.setVisibility(0);
            bVar.xUi.setText(cVar.xEe.get(0));
        } else {
            if (!Util.isNullOrNil(cVar.xEh)) {
                bVar.xUi.setVisibility(0);
                bVar.xUi.setText(cVar.xEh);
                try {
                    bVar.xUi.setBackgroundDrawable(e.fi(Color.parseColor(cVar.xEi), a.fromDPToPix(this.mContext, 10)));
                } catch (IllegalArgumentException e2) {
                    Log.e("MicroMsg.GameCenterListAdapter", e2.getMessage());
                } catch (Exception e3) {
                    Log.e("MicroMsg.GameCenterListAdapter", e3.getMessage());
                }
            }
            bVar.xUi.setVisibility(8);
        }
        bVar.xUm.setTextSize(this.xQD);
        bVar.xUl.setOnClickListener(this.xRt);
        bVar.xUm.setOnClickListener(this.xRt);
        bVar.xUl.setTag(cVar);
        bVar.xUm.setTag(cVar);
        this.xQI.a(bVar.xUm, bVar.xUl, cVar, (l) this.xUa.get(cVar.field_appId));
        bVar.xUn.setData(cVar.xEc);
        AppMethodBeat.o(41927);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.game.ui.m
    public final void a(c cVar, m.b bVar) {
    }
}
