package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.widget.GameGridLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h extends RecyclerView {
    private View rkW;
    private int xAC;
    private int xAD;
    a xAE;
    private boolean xAF;
    private boolean xAG;
    private Set<Integer> xAH = new HashSet();

    public h(Context context, int i2, int i3) {
        super(context);
        AppMethodBeat.i(204112);
        this.xAC = i2;
        this.xAD = i3;
        this.xAE = new a(getContext());
        getContext();
        GameGridLayoutManager gameGridLayoutManager = new GameGridLayoutManager();
        gameGridLayoutManager.apR = new GridLayoutManager.b() {
            /* class com.tencent.mm.plugin.game.media.h.AnonymousClass1 */

            @Override // android.support.v7.widget.GridLayoutManager.b
            public final int bX(int i2) {
                AppMethodBeat.i(40976);
                int itemViewType = h.this.xAE.getItemViewType(i2);
                if (itemViewType == Integer.MAX_VALUE || itemViewType == 2147483646 || itemViewType == 1 || itemViewType == 2) {
                    AppMethodBeat.o(40976);
                    return 2;
                }
                AppMethodBeat.o(40976);
                return 1;
            }
        };
        setLayoutManager(gameGridLayoutManager);
        a(new b());
        this.rkW = LayoutInflater.from(getContext()).inflate(R.layout.aq9, (ViewGroup) this, false);
        this.rkW.setVisibility(8);
        a aVar = this.xAE;
        aVar.xAK.add(this.rkW);
        setAdapter(this.xAE);
        AppMethodBeat.o(204112);
    }

    public final void b(LinkedList<e> linkedList, boolean z, boolean z2) {
        AppMethodBeat.i(40991);
        this.xAF = z;
        this.xAG = z2;
        this.rkW.setVisibility(8);
        a aVar = this.xAE;
        aVar.xAL.clear();
        aVar.xAL.addAll(linkedList);
        aVar.atj.notifyChanged();
        AppMethodBeat.o(40991);
    }

    public final boolean Of(int i2) {
        AppMethodBeat.i(40992);
        int ku = ((LinearLayoutManager) getLayoutManager()).ku();
        if (i2 != 0 || !this.xAF || ku < this.xAE.getItemCount() - 2) {
            AppMethodBeat.o(40992);
            return false;
        }
        this.rkW.setVisibility(0);
        AppMethodBeat.o(40992);
        return true;
    }

    public final void setOnItemClickListener(com.tencent.mm.plugin.appbrand.widget.recyclerview.b bVar) {
        this.xAE.oEh = bVar;
    }

    public final e Og(int i2) {
        AppMethodBeat.i(40993);
        e Og = this.xAE.Og(i2);
        AppMethodBeat.o(40993);
        return Og;
    }

    /* access modifiers changed from: package-private */
    public class a extends RecyclerView.a<c> {
        private Context mContext;
        private ViewGroup oEd;
        private ViewGroup oEe;
        com.tencent.mm.plugin.appbrand.widget.recyclerview.b oEh;
        LinkedList<View> xAJ = new LinkedList<>();
        LinkedList<View> xAK = new LinkedList<>();
        LinkedList<e> xAL = new LinkedList<>();

        static /* synthetic */ int a(a aVar, int i2) {
            AppMethodBeat.i(164008);
            int FO = aVar.FO(i2);
            AppMethodBeat.o(164008);
            return FO;
        }

        static /* synthetic */ void a(a aVar, int i2, String str, String str2) {
            AppMethodBeat.i(164009);
            aVar.e(i2, 2, str, str2);
            AppMethodBeat.o(164009);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(c cVar, int i2) {
            AppMethodBeat.i(40985);
            final c cVar2 = cVar;
            int itemViewType = getItemViewType(i2);
            if (itemViewType == Integer.MAX_VALUE || itemViewType == 2147483646 || itemViewType == 2) {
                AppMethodBeat.o(40985);
                return;
            }
            final int i3 = i2 - (this.xAJ.isEmpty() ? 0 : 1);
            final e Og = Og(i3);
            if (Og != null) {
                if (Og.xuJ) {
                    cVar2.xAP.setText(Og.xuL);
                } else {
                    cVar2.nNv.setImageBitmap(null);
                    cVar2.xAQ.setText(Og.xuN);
                    cVar2.xAS.setText(Og.title);
                    if (Og.dLQ) {
                        r.i(cVar2.nNv, Og.videoUrl);
                        cVar2.xAR.setVisibility(8);
                    } else {
                        c.a aVar = new c.a();
                        aVar.prefixPath = p.xCG;
                        aVar.jbf = true;
                        com.tencent.mm.av.a.a.bdb().a(Og.xuM, cVar2.nNv, aVar.bdv(), new com.tencent.mm.av.a.c.h() {
                            /* class com.tencent.mm.plugin.game.media.h.a.AnonymousClass1 */

                            @Override // com.tencent.mm.av.a.c.h
                            public final void b(String str, View view) {
                            }

                            @Override // com.tencent.mm.av.a.c.h
                            public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                                return null;
                            }

                            @Override // com.tencent.mm.av.a.c.h
                            public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                                AppMethodBeat.i(40977);
                                if (!(bVar == null || bVar.bitmap == null)) {
                                    Log.i("MicroMsg.GameHaowanRecycleView", "load thumb:%s, from:%d", str, Integer.valueOf(bVar.from));
                                }
                                AppMethodBeat.o(40977);
                            }
                        });
                        cVar2.xAR.setData(Og.xuO);
                    }
                    if (!h.this.xAG && !h.this.xAH.contains(Integer.valueOf(Og.hashCode()))) {
                        h.this.xAH.add(Integer.valueOf(Og.hashCode()));
                        e(FO(i3), 1, Og.appId, Og.psI);
                    }
                }
                if (this.oEh != null) {
                    cVar2.aus.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.game.media.h.a.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(40978);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameHaowanRecycleView$GameHaowanAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            a.this.oEh.Q(cVar2.aus, i3);
                            a.a(a.this, a.a(a.this, i3), Og.appId, Og.psI);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameHaowanRecycleView$GameHaowanAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(40978);
                        }
                    });
                }
            }
            AppMethodBeat.o(40985);
        }

        a(Context context) {
            AppMethodBeat.i(40979);
            this.mContext = context;
            AppMethodBeat.o(40979);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            int i2 = 0;
            AppMethodBeat.i(40980);
            int size = (this.xAJ.isEmpty() ? 0 : 1) + this.xAL.size();
            if (!this.xAK.isEmpty()) {
                i2 = 1;
            }
            int i3 = size + i2;
            AppMethodBeat.o(40980);
            return i3;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            int i3;
            AppMethodBeat.i(40981);
            if (i2 < 0 || i2 >= getItemCount()) {
                AppMethodBeat.o(40981);
                return 0;
            } else if (i2 == 0 && !this.xAJ.isEmpty()) {
                AppMethodBeat.o(40981);
                return Integer.MAX_VALUE;
            } else if (i2 != getItemCount() - 1 || this.xAK.isEmpty()) {
                if (this.xAJ.isEmpty()) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                int i4 = i2 - i3;
                if (i4 < 0 || i4 >= this.xAL.size()) {
                    AppMethodBeat.o(40981);
                    return 0;
                }
                e eVar = this.xAL.get(i4);
                if (eVar != null && eVar.xuJ) {
                    AppMethodBeat.o(40981);
                    return 1;
                } else if (eVar == null || !eVar.xuK) {
                    AppMethodBeat.o(40981);
                    return 0;
                } else {
                    AppMethodBeat.o(40981);
                    return 2;
                }
            } else {
                AppMethodBeat.o(40981);
                return 2147483646;
            }
        }

        public final e Og(int i2) {
            AppMethodBeat.i(40982);
            if (i2 < 0 || i2 >= this.xAL.size()) {
                AppMethodBeat.o(40982);
                return null;
            }
            e eVar = this.xAL.get(i2);
            AppMethodBeat.o(40982);
            return eVar;
        }

        private int FO(int i2) {
            int i3 = 0;
            AppMethodBeat.i(40983);
            if (i2 < 0 || i2 >= this.xAL.size()) {
                AppMethodBeat.o(40983);
                return i2;
            }
            for (int i4 = 0; i4 < i2 + 1; i4++) {
                e eVar = this.xAL.get(i4);
                if (eVar.xuJ || eVar.xuK) {
                    i3 = i3;
                } else {
                    i3++;
                }
            }
            AppMethodBeat.o(40983);
            return i3;
        }

        private void e(int i2, int i3, String str, String str2) {
            int i4;
            AppMethodBeat.i(40984);
            if (h.this.xAC == 8762) {
                i4 = 7;
            } else {
                i4 = 6;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("videoid", str2);
            com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), h.this.xAC, i2, i3, str, h.this.xAD, com.tencent.mm.game.report.b.a.c(i4, hashMap));
            AppMethodBeat.o(40984);
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ c a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(40986);
            if (i2 == Integer.MAX_VALUE) {
                if (this.oEd == null) {
                    this.oEd = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c1a, viewGroup, false);
                }
                this.oEd.removeAllViews();
                Iterator<View> it = this.xAJ.iterator();
                while (it.hasNext()) {
                    this.oEd.addView(it.next());
                }
                c cVar = new c(this.oEd);
                AppMethodBeat.o(40986);
                return cVar;
            } else if (i2 == 2147483646) {
                if (this.oEe == null) {
                    this.oEe = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c1a, viewGroup, false);
                }
                this.oEe.removeAllViews();
                Iterator<View> it2 = this.xAK.iterator();
                while (it2.hasNext()) {
                    this.oEe.addView(it2.next());
                }
                c cVar2 = new c(this.oEe);
                AppMethodBeat.o(40986);
                return cVar2;
            } else if (i2 == 1) {
                c cVar3 = new c(LayoutInflater.from(this.mContext).inflate(R.layout.at3, viewGroup, false));
                AppMethodBeat.o(40986);
                return cVar3;
            } else if (i2 == 2) {
                c cVar4 = new c(LayoutInflater.from(this.mContext).inflate(R.layout.aql, viewGroup, false));
                AppMethodBeat.o(40986);
                return cVar4;
            } else {
                c cVar5 = new c(LayoutInflater.from(this.mContext).inflate(R.layout.at1, viewGroup, false));
                AppMethodBeat.o(40986);
                return cVar5;
            }
        }
    }

    static class c extends RecyclerView.v {
        public ImageView nNv;
        public TextView xAP;
        public TextView xAQ;
        public GameVideoTagContainer xAR;
        public TextView xAS;
        public ImageView xAT;

        public c(View view) {
            super(view);
            AppMethodBeat.i(40989);
            this.xAP = (TextView) view.findViewById(R.id.in2);
            this.nNv = (ImageView) view.findViewById(R.id.j51);
            this.xAQ = (TextView) view.findViewById(R.id.c77);
            this.xAR = (GameVideoTagContainer) view.findViewById(R.id.j6l);
            this.xAS = (TextView) view.findViewById(R.id.j6t);
            this.xAT = (ImageView) view.findViewById(R.id.dj3);
            AppMethodBeat.o(40989);
        }
    }

    static class b extends RecyclerView.h {
        private int mSize = at.fromDPToPix(MMApplicationContext.getContext(), 1);

        public b() {
            AppMethodBeat.i(40987);
            AppMethodBeat.o(40987);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(40988);
            RecyclerView.bw(view);
            GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
            int i2 = ((GridLayoutManager) recyclerView.getLayoutManager()).apM;
            Log.i("MicroMsg.GameHaowanRecycleView", "getItemOffsets, spanSize = %d, spanCount = %d, index = %d", Integer.valueOf(layoutParams.apU), Integer.valueOf(i2), Integer.valueOf(layoutParams.apT));
            if (layoutParams.apU == i2) {
                rect.set(0, 0, 0, 0);
                AppMethodBeat.o(40988);
            } else if (layoutParams.apT == 0) {
                rect.set(0, this.mSize, this.mSize, this.mSize);
                AppMethodBeat.o(40988);
            } else {
                rect.set(this.mSize, this.mSize, 0, this.mSize);
                AppMethodBeat.o(40988);
            }
        }
    }
}
