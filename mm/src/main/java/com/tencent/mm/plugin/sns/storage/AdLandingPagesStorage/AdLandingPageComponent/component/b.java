package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends m {
    int Ebt;
    private RecyclerView Ebu;
    private C1719b Ebv;
    private Map<Integer, a> Ebw = new HashMap();
    Set<Integer> Ebx = new HashSet();
    LinearLayoutManager vKp;

    class c extends RecyclerView.l {
        int EbC = Integer.MAX_VALUE;
        private int EbD = -1;
        private int EbE = -1;
        private long EbF = 0;
        Runnable EbG = new Runnable() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(96399);
                if (c.this.EbC == 1) {
                    c cVar = c.this;
                    Log.d("AdLandingCarouselComp", "onDraggin first visible " + b.this.vKp.ks() + ", last visible " + b.this.vKp.ku());
                    b.a(b.this);
                    c.this.hak.postDelayed(c.this.EbG, 100);
                }
                AppMethodBeat.o(96399);
            }
        };
        RecyclerView hak;
        private LinearLayoutManager pcs;

        public c(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
            AppMethodBeat.i(96400);
            this.hak = recyclerView;
            this.pcs = linearLayoutManager;
            AppMethodBeat.o(96400);
        }

        private void fcV() {
            AppMethodBeat.i(96401);
            this.hak.getHandler().removeCallbacks(this.EbG);
            AppMethodBeat.o(96401);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(96402);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 != this.EbC) {
                if (i2 != 1) {
                    fcV();
                }
                switch (i2) {
                    case 0:
                        b.a(b.this);
                        if (this.EbC == 2) {
                            int ks = this.pcs.ks();
                            int ku = this.pcs.ku();
                            if (ku >= this.EbD) {
                                if (ks > this.EbE) {
                                    m(this.EbE, ks, System.currentTimeMillis() - this.EbF);
                                    break;
                                }
                            } else {
                                m(ku, this.EbD, System.currentTimeMillis() - this.EbF);
                                break;
                            }
                        }
                        break;
                    case 1:
                        fcV();
                        this.hak.postDelayed(this.EbG, 100);
                        break;
                    case 2:
                        this.EbD = this.pcs.ks();
                        this.EbE = this.pcs.ku();
                        this.EbF = System.currentTimeMillis();
                        break;
                }
            }
            this.EbC = i2;
            Log.d("AdLandingCarouselComp", "state ".concat(String.valueOf(i2)));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(96402);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(96403);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(96403);
        }

        private void m(int i2, int i3, long j2) {
            AppMethodBeat.i(96404);
            Log.d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
            b.a(b.this, i2, i3, j2);
            AppMethodBeat.o(96404);
        }
    }

    public b(Context context, r rVar, ViewGroup viewGroup) {
        super(context, rVar, viewGroup);
        AppMethodBeat.i(96405);
        this.Ebt = com.tencent.mm.cb.a.fromDPToPix(context, 12);
        AppMethodBeat.o(96405);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.buc;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(96406);
        this.Ebu = (RecyclerView) this.contentView.findViewById(R.id.gy0);
        this.Ebu.setBackgroundColor(((r) this.EcX).backgroundColor);
        Iterator<z> it = ((r) this.EcX).DYI.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            z next = it.next();
            if (next instanceof t) {
                int i3 = ((int) (next.paddingTop + next.paddingBottom + ((t) next).height)) + (this.Ebt << 1);
                if (i2 <= i3) {
                    i2 = i3;
                }
            }
            i2 = i2;
        }
        ViewGroup.LayoutParams layoutParams = this.Ebu.getLayoutParams();
        layoutParams.height = i2;
        this.Ebu.setLayoutParams(layoutParams);
        this.Ebv = new C1719b(this, (byte) 0);
        this.Ebu.setAdapter(this.Ebv);
        this.vKp = new LinearLayoutManager();
        this.vKp.setOrientation(0);
        this.Ebu.setLayoutManager(this.vKp);
        this.Ebu.a(new c(this.Ebu, this.vKp));
        this.Ebu.setNestedScrollingEnabled(false);
        this.Ebu.setHasFixedSize(true);
        AppMethodBeat.o(96406);
    }

    private void fcS() {
        AppMethodBeat.i(96407);
        if (this.vKp != null) {
            iz(this.vKp.ks(), this.vKp.ku());
        }
        AppMethodBeat.o(96407);
    }

    private void iz(int i2, int i3) {
        AppMethodBeat.i(96408);
        while (i2 <= i3) {
            a aVar = this.Ebw.get(Integer.valueOf(i2));
            if (aVar == null) {
                aVar = new a(this, (byte) 0);
                this.Ebw.put(Integer.valueOf(i2), aVar);
            }
            aVar.fcT();
            i2++;
        }
        AppMethodBeat.o(96408);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(96409);
        super.eWZ();
        fcS();
        AppMethodBeat.o(96409);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXa() {
        AppMethodBeat.i(96410);
        super.eXa();
        if (this.vKp != null) {
            int ks = this.vKp.ks();
            int ku = this.vKp.ku();
            for (int i2 = ks; i2 <= ku; i2++) {
                a aVar = this.Ebw.get(Integer.valueOf(i2));
                if (aVar != null) {
                    aVar.fcU();
                }
            }
        }
        AppMethodBeat.o(96410);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean G(JSONArray jSONArray) {
        AppMethodBeat.i(96411);
        if (jSONArray == null) {
            AppMethodBeat.o(96411);
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        if (super.bp(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        try {
            Map<Integer, a> map = this.Ebw;
            Set<Integer> set = this.Ebx;
            this.Ebx = new HashSet();
            this.Ebw = new HashMap();
            for (Map.Entry<Integer, a> entry : map.entrySet()) {
                z zVar = ((r) this.EcX).DYI.get(entry.getKey().intValue());
                if (!zVar.DZr && (zVar instanceof t)) {
                    t tVar = (t) zVar;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cid", ((r) this.EcX).DYI.get(entry.getKey().intValue()).DZi);
                    jSONObject2.put(f.COL_EXPOSURECOUNT, entry.getValue().count);
                    jSONObject2.put("stayTime", entry.getValue().time);
                    if (set.contains(entry.getKey())) {
                        String mD5String = MD5Util.getMD5String(tVar.DYK);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("urlMd5", mD5String);
                        jSONObject3.put("needDownload", 1);
                        jSONObject2.put("imgUrlInfo", jSONObject3);
                    }
                    jSONArray.put(jSONObject2);
                }
            }
            AppMethodBeat.o(96411);
            return true;
        } catch (JSONException e2) {
            Log.e("AdLandingCarouselComp", Util.stackTraceToString(e2));
            AppMethodBeat.o(96411);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b$b  reason: collision with other inner class name */
    class C1719b extends RecyclerView.a<a> {
        private C1719b() {
        }

        /* synthetic */ C1719b(b bVar, byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(a aVar, int i2) {
            AppMethodBeat.i(96397);
            a aVar2 = aVar;
            z zVar = b.b(b.this).DYI.get(i2);
            if (zVar instanceof t) {
                aVar2.EbA.b((t) zVar);
                if (!aVar2.EbA.Ecz) {
                    b.this.Ebx.add(Integer.valueOf(i2));
                }
                View view = aVar2.EbA.contentView;
                int paddingRight = view.getPaddingRight();
                if (i2 != b.b(b.this).DYI.size() - 1) {
                    paddingRight += b.this.Ebt;
                }
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + b.this.Ebt, paddingRight, view.getPaddingBottom() + b.this.Ebt);
            }
            AppMethodBeat.o(96397);
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b$b$a */
        class a extends RecyclerView.v {
            private h EbA;

            public a(View view, h hVar) {
                super(view);
                this.EbA = hVar;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(96396);
            int size = b.b(b.this).DYI.size();
            AppMethodBeat.o(96396);
            return size;
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(96398);
            h hVar = new h(viewGroup.getContext(), viewGroup);
            a aVar = new a(hVar.getView(), hVar);
            AppMethodBeat.o(96398);
            return aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public class a {
        long Eby;
        int count;
        boolean isVisible;
        long time;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void fcT() {
            AppMethodBeat.i(96394);
            if (this.isVisible) {
                AppMethodBeat.o(96394);
                return;
            }
            this.isVisible = true;
            this.Eby = System.currentTimeMillis();
            this.count++;
            AppMethodBeat.o(96394);
        }

        /* access modifiers changed from: package-private */
        public final void fcU() {
            AppMethodBeat.i(96395);
            if (this.isVisible) {
                this.isVisible = false;
                if (this.Eby > 0) {
                    this.time += System.currentTimeMillis() - this.Eby;
                    this.Eby = 0;
                }
            }
            AppMethodBeat.o(96395);
        }
    }

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(96412);
        bVar.fcS();
        int ks = bVar.vKp.ks();
        int ku = bVar.vKp.ku();
        for (Map.Entry<Integer, a> entry : bVar.Ebw.entrySet()) {
            if (entry.getKey().intValue() < ks || entry.getKey().intValue() > ku) {
                entry.getValue().fcU();
            }
        }
        AppMethodBeat.o(96412);
    }

    static /* synthetic */ void a(b bVar, int i2, int i3, long j2) {
        int i4;
        AppMethodBeat.i(96413);
        if (i2 > i3) {
            Log.e("AdLandingCarouselComp", "wtf start > end");
            AppMethodBeat.o(96413);
            return;
        }
        bVar.iz(i2, i3);
        if (i3 == i2) {
            i4 = 1;
        } else {
            i4 = (i3 - i2) + 1;
        }
        long j3 = j2 / ((long) i4);
        while (i2 <= i3) {
            a aVar = bVar.Ebw.get(Integer.valueOf(i2));
            if (aVar != null && aVar.isVisible) {
                aVar.isVisible = false;
                aVar.Eby = 0;
                aVar.time += j3;
            }
            i2++;
        }
        AppMethodBeat.o(96413);
    }

    static /* synthetic */ r b(b bVar) {
        return (r) bVar.EcX;
    }
}
