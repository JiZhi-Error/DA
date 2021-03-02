package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class a extends RecyclerView.a<RecyclerView.v> implements c.b {
    g Eig;
    private LinkedHashMap<String, m> Eih = new LinkedHashMap<>();
    int Eii;
    int bgColor;
    private Context context;
    private LinearLayoutManager vKp;

    public a(g gVar, int i2, Context context2, LinearLayoutManager linearLayoutManager) {
        AppMethodBeat.i(97063);
        this.vKp = linearLayoutManager;
        this.Eig = gVar;
        this.bgColor = i2;
        this.context = context2;
        AppMethodBeat.o(97063);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(97064);
        C1726a aVar = new C1726a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c5, viewGroup, false));
        AppMethodBeat.o(97064);
        return aVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2) {
        AppMethodBeat.i(97065);
        Log.i("MicroMsg.ContentAdapter", "display page " + this.Eig.id + ", pos " + i2);
        C1726a aVar = (C1726a) vVar;
        aVar.opU.removeAllViews();
        z zVar = this.Eig.Eli.get(i2);
        m mVar = this.Eih.get(zVar.DZi);
        int i3 = this.bgColor;
        if (zVar.DZn != null && zVar.DZn.length() > 0) {
            try {
                i3 = Color.parseColor(zVar.DZn);
            } catch (Exception e2) {
                Log.e("MicroMsg.ContentAdapter", "parse cellBackgroundColor error: %s", zVar.DZn);
            }
        }
        aVar.opU.setBackgroundColor(i3);
        if (mVar != null) {
            mVar.b(this.Eig.Eli.get(i2));
        } else {
            mVar = ay.a(aVar.opU.getContext(), zVar, aVar.opU, i3);
            if (mVar != null) {
                this.Eih.put(zVar.DZi, mVar);
            }
        }
        if (mVar != null) {
            View view = mVar.getView();
            if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            aVar.opU.addView(view);
        }
        if (i2 == 0) {
            m next = fdY().iterator().next();
            if (next != null && (next instanceof v)) {
                HashMap hashMap = new HashMap();
                hashMap.put("startIndex", Integer.valueOf(this.Eii));
                next.aQ(hashMap);
            }
            AppMethodBeat.o(97065);
            return;
        }
        if (mVar instanceof v) {
            mVar.aQ(new HashMap());
        }
        AppMethodBeat.o(97065);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        return i2;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(97066);
        int size = this.Eig.Eli.size();
        AppMethodBeat.o(97066);
        return size;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b
    public final boolean Zd(int i2) {
        AppMethodBeat.i(97067);
        if (i2 < this.vKp.ks() || i2 > this.vKp.ku()) {
            Log.v("MicroMsg.ContentAdapter", "index %d not visible");
            AppMethodBeat.o(97067);
            return false;
        }
        m mVar = this.Eih.get(this.Eig.Eli.get(i2).DZi);
        if (mVar != null) {
            Log.d("MicroMsg.ContentAdapter", "comp %s, isExposure %s", mVar, Boolean.valueOf(mVar.fdm()));
            boolean fdm = mVar.fdm();
            AppMethodBeat.o(97067);
            return fdm;
        }
        AppMethodBeat.o(97067);
        return false;
    }

    public final m fdW() {
        AppMethodBeat.i(97068);
        try {
            m mVar = this.Eih.get(this.Eig.Eli.get(this.vKp.ku()).DZi);
            AppMethodBeat.o(97068);
            return mVar;
        } catch (Exception e2) {
            AppMethodBeat.o(97068);
            return null;
        }
    }

    public final m fdX() {
        AppMethodBeat.i(97069);
        try {
            m mVar = this.Eih.get(this.Eig.Eli.get(this.vKp.ku() - 1).DZi);
            AppMethodBeat.o(97069);
            return mVar;
        } catch (Exception e2) {
            AppMethodBeat.o(97069);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b
    public final boolean Ze(int i2) {
        AppMethodBeat.i(97070);
        boolean Zi = i.Zi(this.Eig.Eli.get(i2).type);
        AppMethodBeat.o(97070);
        return Zi;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b
    public final void a(int i2, c cVar) {
        AppMethodBeat.i(97071);
        z zVar = this.Eig.Eli.get(i2);
        m mVar = this.Eih.get(zVar.DZi);
        if (mVar != null) {
            mVar.eWZ();
            mVar.eXb();
            if (zVar.type == 61 || zVar.type == 62) {
                ArrayList<Integer> arrayList = new ArrayList();
                for (Map.Entry<Integer, c.a> entry : cVar.Ebw.entrySet()) {
                    if (entry.getValue().DXw) {
                        arrayList.add(entry.getKey());
                    }
                }
                for (Integer num : arrayList) {
                    int intValue = num.intValue();
                    if (intValue != i2 && Zd(intValue)) {
                        m Zh = Zh(intValue);
                        if (Zh instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) {
                            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) Zh;
                            if (aVar.DXr && this.Eig.xwi && intValue == 0) {
                                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) mVar).fcJ();
                            } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) mVar).DXr) {
                                aVar.fcJ();
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(97071);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b
    public final void Zf(int i2) {
        AppMethodBeat.i(97072);
        m Zh = Zh(i2);
        if (i.Zi(Zh.fdk().type)) {
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) Zh).eXc();
        }
        AppMethodBeat.o(97072);
    }

    private m Zh(int i2) {
        AppMethodBeat.i(97073);
        m mVar = this.Eih.get(this.Eig.Eli.get(i2).DZi);
        AppMethodBeat.o(97073);
        return mVar;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b
    public final void Zc(int i2) {
        AppMethodBeat.i(97074);
        if (i2 < 0 || i2 >= this.Eig.Eli.size()) {
            Log.w("MicroMsg.ContentAdapter", "endExposure index[%d], size[%d]", Integer.valueOf(i2), Integer.valueOf(this.Eig.Eli.size()));
            AppMethodBeat.o(97074);
            return;
        }
        m mVar = this.Eih.get(this.Eig.Eli.get(i2).DZi);
        if (mVar != null) {
            mVar.eXa();
        }
        AppMethodBeat.o(97074);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b
    public final void onDestroy() {
        AppMethodBeat.i(97075);
        for (Map.Entry<String, m> entry : this.Eih.entrySet()) {
            entry.getValue().eXd();
        }
        AppMethodBeat.o(97075);
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.a$a  reason: collision with other inner class name */
    public class C1726a extends RecyclerView.v {
        private LinearLayout opU;

        public C1726a(View view) {
            super(view);
            AppMethodBeat.i(97062);
            this.opU = (LinearLayout) view.findViewById(R.id.be9);
            AppMethodBeat.o(97062);
        }
    }

    public final void a(g gVar) {
        AppMethodBeat.i(97076);
        if (this.Eig != gVar) {
            this.Eig = gVar;
            this.atj.notifyChanged();
        }
        AppMethodBeat.o(97076);
    }

    public final Collection<m> fdY() {
        AppMethodBeat.i(97077);
        if (this.Eih == null) {
            List list = Collections.EMPTY_LIST;
            AppMethodBeat.o(97077);
            return list;
        }
        Collection<m> values = this.Eih.values();
        AppMethodBeat.o(97077);
        return values;
    }
}
