package com.tencent.toybrick.b;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.as;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a;
import com.tencent.toybrick.e.b;
import com.tencent.toybrick.e.c;
import com.tencent.toybrick.ui.BaseToyUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b extends RecyclerView.a<com.tencent.toybrick.f.a> implements View.OnClickListener {
    public ArrayList<g> Sng;
    public LinkedList<g> Snh;
    public HashMap<g, Integer> Sni;
    private SparseArray<g> Snj;
    private com.tencent.toybrick.e.b Snk;
    public a.C2220a Snl;
    private Context mContext;

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ com.tencent.toybrick.f.a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(159926);
        com.tencent.toybrick.f.a asy = asy(i2);
        AppMethodBeat.o(159926);
        return asy;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(com.tencent.toybrick.f.a aVar, int i2) {
        AppMethodBeat.i(159925);
        com.tencent.toybrick.f.a aVar2 = aVar;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            aVar2.aus.setTag(aVar2);
            g asz = asz(i2);
            aVar2.SoF = asz;
            asz.a(aVar2);
            as.d("VerticalToyAdapter", "[onBindViewHolder] cost:%sms toyBrick:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), aVar2.SoF.SnT);
            AppMethodBeat.o(159925);
        } catch (Throwable th) {
            as.d("VerticalToyAdapter", "[onBindViewHolder] cost:%sms toyBrick:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), aVar2.SoF.SnT);
            AppMethodBeat.o(159925);
            throw th;
        }
    }

    public b(Context context, a.C2220a aVar) {
        int i2 = 0;
        AppMethodBeat.i(159919);
        a(new a(this, (byte) 0));
        this.mContext = context;
        this.Snl = aVar;
        LinkedList<g> linkedList = aVar.Soh;
        Iterator<g> it = linkedList.iterator();
        while (it.hasNext()) {
            it.next().bJH = i2;
            i2++;
        }
        this.Snh = linkedList;
        this.Snj = new SparseArray<>();
        this.Sni = new HashMap<>();
        this.Sng = new ArrayList<>();
        this.Snk = new com.tencent.toybrick.e.b(this);
        com.tencent.toybrick.e.b bVar = this.Snk;
        bVar.mMainHandler.removeCallbacks(bVar.Soo);
        Handler handler = bVar.mMainHandler;
        b.AnonymousClass1 r2 = new Runnable() {
            /* class com.tencent.toybrick.e.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(159965);
                com.tencent.toybrick.b.b bVar = b.this.vjo.get();
                if (bVar != null) {
                    a.hpK().execute(new RunnableC2222b(bVar.Snl.Soi, bVar.Snh, bVar.Sng));
                }
                AppMethodBeat.o(159965);
            }
        };
        bVar.Soo = r2;
        handler.post(r2);
        AppMethodBeat.o(159919);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(159920);
        g asz = asz(i2);
        int layoutResource = asz.getLayoutResource();
        this.Snj.put(layoutResource, asz);
        AppMethodBeat.o(159920);
        return layoutResource;
    }

    private com.tencent.toybrick.f.a asy(int i2) {
        AppMethodBeat.i(159921);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            View inflate = LayoutInflater.from(this.mContext).inflate(i2, (ViewGroup) null);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            inflate.setOnClickListener(this);
            com.tencent.toybrick.f.a hM = this.Snj.get(i2).hM(inflate);
            as.d("VerticalToyAdapter", "[onCreateViewHolder] cost:%sms toyBrick:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), this.Snj.get(i2).SnT);
            AppMethodBeat.o(159921);
            return hM;
        } catch (Throwable th) {
            as.d("VerticalToyAdapter", "[onCreateViewHolder] cost:%sms toyBrick:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), this.Snj.get(i2).SnT);
            AppMethodBeat.o(159921);
            throw th;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(159922);
        int size = this.Sng.size();
        AppMethodBeat.o(159922);
        return size;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(159923);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/toybrick/adapter/VerticalToyAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        asz(((com.tencent.toybrick.f.a) view.getTag()).lR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/toybrick/adapter/VerticalToyAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159923);
    }

    class a extends RecyclerView.c {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3) {
            AppMethodBeat.i(159918);
            super.onItemRangeChanged(i2, i3);
            as.d("NotifyObserver", "[onItemRangeChanged] positionStart:%d, itemCount:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            g asz = b.this.asz(i2);
            if (!(asz == null || asz.SnU == null)) {
                c.execute(new c.d(asz, asz.SnU, new c.b<g>() {
                    /* class com.tencent.toybrick.b.b.a.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, boolean] */
                    @Override // com.tencent.toybrick.e.c.b
                    public final /* synthetic */ void g(g gVar, boolean z) {
                        BaseToyUI.a aVar;
                        AppMethodBeat.i(159917);
                        g gVar2 = gVar;
                        if (gVar2.isVisible != z) {
                            if (gVar2.isVisible != z) {
                                gVar2.isVisible = z;
                                if (z) {
                                    aVar = BaseToyUI.a.INSERT;
                                } else {
                                    aVar = BaseToyUI.a.REMOVE;
                                }
                                gVar2.mMainHandler.removeCallbacks(gVar2.SnS);
                                Handler handler = gVar2.mMainHandler;
                                f.AnonymousClass1 r2 = new Runnable(aVar) {
                                    /* class com.tencent.toybrick.c.f.AnonymousClass1 */
                                    final /* synthetic */ BaseToyUI.a SnV;

                                    {
                                        this.SnV = r2;
                                    }

                                    public final void run() {
                                        AppMethodBeat.i(159954);
                                        as.d("ToyBrick", "requestUpdate! ToyBrick:%s type:%s", f.this.SnT, this.SnV);
                                        AppMethodBeat.o(159954);
                                    }
                                };
                                gVar2.SnS = r2;
                                handler.post(r2);
                            }
                            if (z) {
                                b.a(b.this, gVar2);
                                AppMethodBeat.o(159917);
                                return;
                            }
                            b.a(b.this, (f) gVar2);
                        }
                        AppMethodBeat.o(159917);
                    }
                }));
            }
            AppMethodBeat.o(159918);
        }
    }

    public final g asz(int i2) {
        AppMethodBeat.i(159924);
        if (this.Sng.size() > i2) {
            g gVar = this.Sng.get(i2);
            AppMethodBeat.o(159924);
            return gVar;
        }
        AppMethodBeat.o(159924);
        return null;
    }

    static /* synthetic */ void a(b bVar, g gVar) {
        boolean z;
        AppMethodBeat.i(159927);
        if (bVar.Sng.indexOf(gVar) < 0) {
            Iterator<g> it = bVar.Sng.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Integer num = bVar.Sni.get(it.next());
                int intValue = num == null ? -1 : num.intValue();
                Integer num2 = bVar.Sni.get(gVar);
                if (intValue < (num2 == null ? -1 : num2.intValue())) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    bVar.Sng.add(i2, gVar);
                    bVar.cj(i2);
                    AppMethodBeat.o(159927);
                    return;
                }
                i2++;
            }
        }
        AppMethodBeat.o(159927);
    }

    static /* synthetic */ void a(b bVar, f fVar) {
        AppMethodBeat.i(159928);
        int indexOf = bVar.Sng.indexOf(fVar);
        if (indexOf >= 0) {
            bVar.Sng.remove(indexOf);
            bVar.ck(indexOf);
        }
        AppMethodBeat.o(159928);
    }
}
