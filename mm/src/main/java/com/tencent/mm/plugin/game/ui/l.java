package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.ui.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class l extends m {
    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void Ot(int i2) {
        AppMethodBeat.i(42217);
        super.Ot(i2);
        AppMethodBeat.o(42217);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void a(m.a aVar) {
        AppMethodBeat.i(42209);
        super.a(aVar);
        AppMethodBeat.o(42209);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void aAA(String str) {
        AppMethodBeat.i(42204);
        super.aAA(str);
        AppMethodBeat.o(42204);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void aAB(String str) {
        AppMethodBeat.i(42205);
        super.aAB(str);
        AppMethodBeat.o(42205);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void aAC(String str) {
        AppMethodBeat.i(42206);
        super.aAC(str);
        AppMethodBeat.o(42206);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList] */
    @Override // com.tencent.mm.plugin.game.ui.m, com.tencent.mm.plugin.game.ui.a
    public final /* bridge */ /* synthetic */ void aU(LinkedList<c> linkedList) {
        AppMethodBeat.i(42215);
        super.aU(linkedList);
        AppMethodBeat.o(42215);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList] */
    @Override // com.tencent.mm.plugin.game.ui.m, com.tencent.mm.plugin.game.ui.a
    public final /* bridge */ /* synthetic */ void aV(LinkedList<c> linkedList) {
        AppMethodBeat.i(42214);
        super.aV(linkedList);
        AppMethodBeat.o(42214);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void aj(View view, int i2) {
        AppMethodBeat.i(42208);
        super.aj(view, i2);
        AppMethodBeat.o(42208);
    }

    @Override // com.tencent.mm.plugin.game.ui.m, com.tencent.mm.plugin.game.ui.a
    public final /* bridge */ /* synthetic */ void clear() {
        AppMethodBeat.i(42207);
        super.clear();
        AppMethodBeat.o(42207);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void f(SparseArray sparseArray) {
        AppMethodBeat.i(42210);
        super.f(sparseArray);
        AppMethodBeat.o(42210);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ int getItemViewType(int i2) {
        AppMethodBeat.i(42213);
        int itemViewType = super.getItemViewType(i2);
        AppMethodBeat.o(42213);
        return itemViewType;
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(42211);
        View view2 = super.getView(i2, view, viewGroup);
        AppMethodBeat.o(42211);
        return view2;
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ int getViewTypeCount() {
        AppMethodBeat.i(42212);
        int viewTypeCount = super.getViewTypeCount();
        AppMethodBeat.o(42212);
        return viewTypeCount;
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void refresh() {
        AppMethodBeat.i(42216);
        super.refresh();
        AppMethodBeat.o(42216);
    }

    @Override // com.tencent.mm.plugin.game.ui.m
    public final /* bridge */ /* synthetic */ void setSourceScene(int i2) {
        AppMethodBeat.i(42218);
        super.setSourceScene(i2);
        AppMethodBeat.o(42218);
    }

    public l(Context context) {
        super(context);
        this.xTV = R.layout.arc;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.game.ui.m
    public final void a(c cVar, m.b bVar, int i2) {
        AppMethodBeat.i(42202);
        bVar.xUg.setText(new StringBuilder().append(cVar.position).toString());
        bVar.xUg.setVisibility(this.xTX ? 0 : 8);
        Bitmap aAz = aAz(cVar.field_appId);
        if (aAz == null || aAz.isRecycled()) {
            bVar.xUh.setImageResource(R.drawable.beg);
        } else {
            bVar.xUh.setImageBitmap(aAz);
        }
        bVar.xTl.setText(cVar.field_appName);
        if (Util.isNullOrNil(cVar.xDU)) {
            bVar.xUj.setVisibility(8);
        } else {
            bVar.xUj.setVisibility(0);
            bVar.xUj.setText(cVar.xDU);
        }
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
                    Log.e("MicroMsg.GameLibraryListAdapter", e2.getMessage());
                } catch (Exception e3) {
                    Log.e("MicroMsg.GameLibraryListAdapter", e3.getMessage());
                }
            }
            bVar.xUi.setVisibility(8);
        }
        bVar.xUm.setTextSize(this.xQD);
        bVar.xUl.setOnClickListener(this.xRt);
        bVar.xUm.setOnClickListener(this.xRt);
        bVar.xUl.setTag(cVar);
        bVar.xUm.setTag(cVar);
        this.xQI.a(bVar.xUm, bVar.xUl, cVar, (com.tencent.mm.plugin.game.model.l) this.xUa.get(cVar.field_appId));
        bVar.xUn.setData(cVar.xEc);
        bVar.xUo.removeAllViews();
        View view = (View) this.xUb.get(i2);
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeAllViews();
            }
            bVar.xUo.addView(view);
        }
        AppMethodBeat.o(42202);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.game.ui.m
    public final void a(c cVar, m.b bVar) {
        AppMethodBeat.i(42203);
        bVar.xUp.removeAllViews();
        if (!Util.isNullOrNil(cVar.xDY)) {
            View inflate = View.inflate(this.mContext, R.layout.aqs, null);
            com.tencent.mm.av.a.a bcV = q.bcV();
            String str = cVar.xDY;
            c.a aVar = new c.a();
            aVar.jbe = true;
            bcV.a(str, (ImageView) inflate.findViewById(R.id.dg2), aVar.bdv());
            bVar.xUp.addView(inflate, new ViewGroup.LayoutParams(-1, a.fromDPToPix(this.mContext, 100)));
        }
        AppMethodBeat.o(42203);
    }
}
