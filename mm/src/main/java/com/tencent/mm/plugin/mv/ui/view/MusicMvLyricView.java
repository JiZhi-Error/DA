package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class MusicMvLyricView extends RelativeLayout {
    private static final int AxL = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    private static final int Ayk = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 320);
    public static final a Ayl = new a((byte) 0);
    private com.tencent.mm.plugin.music.model.e Amv;
    private int Amw;
    private List<e> Aor;
    private WxRecyclerView Aye;
    public final MusicMvMarqueeTextView Ayf;
    private h Ayg;
    private boolean Ayh;
    private ae Ayi;
    private final m Ayj;
    private View jxm;
    private ArrayList<f> kgc;
    private WxRecyclerAdapter<f> tFp;
    private LinearLayoutManager vKp;

    public interface h {
        void Hu(long j2);

        void evS();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvLyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View findViewById;
        p.h(context, "context");
        AppMethodBeat.i(257570);
        this.kgc = new ArrayList<>();
        this.Aor = new ArrayList();
        this.Amw = -1;
        this.Ayj = new m(this);
        this.jxm = View.inflate(context, R.layout.be_, this);
        this.tFp = new WxRecyclerAdapter<>(new i(this), this.kgc, true);
        View view = this.jxm;
        this.Aye = view != null ? (WxRecyclerView) view.findViewById(R.id.f5m) : null;
        WxRecyclerView wxRecyclerView = this.Aye;
        if (wxRecyclerView != null) {
            wxRecyclerView.setAdapter(this.tFp);
        }
        getContext();
        this.vKp = new LinearLayoutManager(1, false);
        WxRecyclerView wxRecyclerView2 = this.Aye;
        if (wxRecyclerView2 != null) {
            wxRecyclerView2.setLayoutManager(this.vKp);
        }
        WxRecyclerView wxRecyclerView3 = this.Aye;
        if (wxRecyclerView3 != null) {
            wxRecyclerView3.b(new j());
        }
        WxRecyclerView wxRecyclerView4 = this.Aye;
        if (wxRecyclerView4 != null) {
            wxRecyclerView4.a(this.Ayj);
        }
        WxRecyclerAdapter<f> wxRecyclerAdapter = this.tFp;
        if (wxRecyclerAdapter != null) {
            wxRecyclerAdapter.RqP = new k(this);
        }
        View view2 = this.jxm;
        if (!(view2 == null || (findViewById = view2.findViewById(R.id.xy)) == null)) {
            findViewById.setOnClickListener(new l(this));
        }
        setTag(this);
        View findViewById2 = findViewById(R.id.i2e);
        p.g(findViewById2, "findViewById(R.id.song_info_tv)");
        this.Ayf = (MusicMvMarqueeTextView) findViewById2;
        this.Ayf.setTextSize((float) com.tencent.mm.cb.a.fromDPToPix(context, 17));
        this.Ayf.setTextColor(-1);
        AppMethodBeat.o(257570);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(257572);
        AppMethodBeat.o(257572);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MusicMvLyricView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(257571);
        AppMethodBeat.o(257571);
    }

    public final h getEventListener() {
        return this.Ayg;
    }

    public final void setEventListener(h hVar) {
        this.Ayg = hVar;
    }

    public static final class m extends RecyclerView.l {
        final /* synthetic */ MusicMvLyricView Aym;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(257564);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(257564);
        }

        m(MusicMvLyricView musicMvLyricView) {
            this.Aym = musicMvLyricView;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(257563);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (!this.Aym.Ayh && i2 == 1) {
                this.Aym.Ayh = true;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(257563);
        }
    }

    public final void setVisibility(int i2) {
        AppMethodBeat.i(257566);
        super.setVisibility(i2);
        if (i2 == 8) {
            this.Ayh = false;
        }
        AppMethodBeat.o(257566);
    }

    public static final class i implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ MusicMvLyricView Aym;

        i(MusicMvLyricView musicMvLyricView) {
            this.Aym = musicMvLyricView;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(257559);
            Log.i("MicroMsg.MusicMvCommentView", "getItemConvert, type:".concat(String.valueOf(i2)));
            g gVar = new g();
            AppMethodBeat.o(257559);
            return gVar;
        }
    }

    public static final class j extends RecyclerView.h {
        j() {
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(257560);
            p.h(rect, "outRect");
            p.h(view, "view");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            int bw = RecyclerView.bw(view);
            RecyclerView.a adapter = recyclerView.getAdapter();
            int itemCount = adapter != null ? adapter.getItemCount() : 0;
            if (bw == 0) {
                rect.top = MusicMvLyricView.Ayk;
                AppMethodBeat.o(257560);
            } else if (bw == itemCount - 1) {
                rect.top = MusicMvLyricView.AxL;
                rect.bottom = MusicMvLyricView.Ayk;
                AppMethodBeat.o(257560);
            } else {
                rect.top = MusicMvLyricView.AxL;
                AppMethodBeat.o(257560);
            }
        }
    }

    public static final class k implements g.c<com.tencent.mm.view.recyclerview.h> {
        final /* synthetic */ MusicMvLyricView Aym;

        k(MusicMvLyricView musicMvLyricView) {
            this.Aym = musicMvLyricView;
        }

        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<com.tencent.mm.view.recyclerview.h> aVar, View view, int i2, com.tencent.mm.view.recyclerview.h hVar) {
            AppMethodBeat.i(257561);
            p.h(aVar, "adapter");
            p.h(view, "view");
            p.h(hVar, "holder");
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) aVar;
            if (i2 >= 0 || i2 < wxRecyclerAdapter.getItemCount()) {
                this.Aym.Ayh = true;
                MusicMvLyricView.a(this.Aym, this.Aym.Amw, i2);
                h eventListener = this.Aym.getEventListener();
                if (eventListener != null) {
                    eventListener.Hu(((f) ((WxRecyclerAdapter) aVar).data.get(i2)).Ayn.time);
                    AppMethodBeat.o(257561);
                    return;
                }
                AppMethodBeat.o(257561);
                return;
            }
            Log.e("MicroMsg.MusicMvCommentView", "invalid position:".concat(String.valueOf(i2)));
            AppMethodBeat.o(257561);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class l implements View.OnClickListener {
        final /* synthetic */ MusicMvLyricView Aym;

        l(MusicMvLyricView musicMvLyricView) {
            this.Aym = musicMvLyricView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257562);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$prepareViews$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            h eventListener = this.Aym.getEventListener();
            if (eventListener != null) {
                eventListener.evS();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$prepareViews$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257562);
        }
    }

    public final void setLyricObj(com.tencent.mm.plugin.music.model.e eVar) {
        ArrayList<D> arrayList;
        ArrayList<D> arrayList2;
        AppMethodBeat.i(257567);
        this.Amv = eVar;
        if (this.Amv == null) {
            Log.e("MicroMsg.MusicMvCommentView", "null == lyricObj, maybe you not setLyricObj, check ！！！");
            AppMethodBeat.o(257567);
            return;
        }
        com.tencent.mm.plugin.music.model.e eVar2 = this.Amv;
        if (eVar2 != null) {
            this.Aor.clear();
            WxRecyclerAdapter<f> wxRecyclerAdapter = this.tFp;
            if (!(wxRecyclerAdapter == null || (arrayList2 = wxRecyclerAdapter.data) == null)) {
                arrayList2.clear();
            }
            int euw = eVar2.euw();
            for (int i2 = 0; i2 < euw; i2++) {
                e.a SQ = eVar2.SQ(i2);
                p.g(SQ, "lyricObj.getSentence(i)");
                if (!SQ.isEmpty()) {
                    long j2 = SQ.timestamp;
                    String str = SQ.content;
                    p.g(str, "sentence.content");
                    e eVar3 = new e(j2, str);
                    f fVar = new f(eVar3);
                    this.Aor.add(eVar3);
                    WxRecyclerAdapter<f> wxRecyclerAdapter2 = this.tFp;
                    if (!(wxRecyclerAdapter2 == null || (arrayList = wxRecyclerAdapter2.data) == null)) {
                        arrayList.add(fVar);
                    }
                }
            }
            WxRecyclerAdapter<f> wxRecyclerAdapter3 = this.tFp;
            if (wxRecyclerAdapter3 != null) {
                wxRecyclerAdapter3.notifyDataSetChanged();
                AppMethodBeat.o(257567);
                return;
            }
            AppMethodBeat.o(257567);
            return;
        }
        AppMethodBeat.o(257567);
    }

    public static /* synthetic */ void a(MusicMvLyricView musicMvLyricView, long j2) {
        AppMethodBeat.i(257569);
        musicMvLyricView.E(j2, true);
        AppMethodBeat.o(257569);
    }

    public final void E(long j2, boolean z) {
        AppMethodBeat.i(257568);
        com.tencent.mm.ac.d.h(new n(this, j2, z));
        AppMethodBeat.o(257568);
    }

    public class d extends ae {
        final /* synthetic */ MusicMvLyricView Aym;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(MusicMvLyricView musicMvLyricView, Context context) {
            super(context);
            p.h(context, "context");
            this.Aym = musicMvLyricView;
            AppMethodBeat.i(257552);
            AppMethodBeat.o(257552);
        }

        @Override // android.support.v7.widget.ae, android.support.v7.widget.RecyclerView.r
        public final void a(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
            AppMethodBeat.i(257550);
            p.h(view, "targetView");
            p.h(sVar, "state");
            p.h(aVar, NativeProtocol.WEB_DIALOG_ACTION);
            if (this.Aym.Ayh) {
                WxRecyclerView wxRecyclerView = this.Aym.Aye;
                int height = wxRecyclerView != null ? wxRecyclerView.getHeight() : 0;
                int top = view.getTop();
                int bottom = view.getBottom();
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.Aym.getContext(), 75);
                if (top < fromDPToPix) {
                    int i2 = fromDPToPix - top;
                    aVar.a(0, -i2, cc(i2), this.VQ);
                    AppMethodBeat.o(257550);
                    return;
                }
                if (height - bottom < fromDPToPix) {
                    int i3 = (height - fromDPToPix) - bottom;
                    aVar.a(0, -i3, cc(i3), this.VQ);
                }
                AppMethodBeat.o(257550);
                return;
            }
            int[] iArr = new int[2];
            WxRecyclerView wxRecyclerView2 = this.Aym.Aye;
            if (wxRecyclerView2 != null) {
                wxRecyclerView2.getLocationInWindow(iArr);
            }
            int height2 = ((((int) (((float) this.Aym.getHeight()) * 0.37f)) - iArr[1]) - view.getTop()) + MusicMvLyricView.AxL;
            aVar.a(0, -height2, cc(height2), this.VQ);
            AppMethodBeat.o(257550);
        }

        @Override // android.support.v7.widget.ae
        public float a(DisplayMetrics displayMetrics) {
            AppMethodBeat.i(257551);
            p.h(displayMetrics, "displayMetrics");
            float f2 = 300.0f / ((float) displayMetrics.densityDpi);
            AppMethodBeat.o(257551);
            return f2;
        }
    }

    public final class b extends d {
        final /* synthetic */ MusicMvLyricView Aym;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MusicMvLyricView musicMvLyricView, Context context) {
            super(musicMvLyricView, context);
            p.h(context, "context");
            this.Aym = musicMvLyricView;
            AppMethodBeat.i(257547);
            AppMethodBeat.o(257547);
        }

        @Override // android.support.v7.widget.ae, com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView.d
        public final float a(DisplayMetrics displayMetrics) {
            AppMethodBeat.i(257546);
            p.h(displayMetrics, "displayMetrics");
            float f2 = 25.0f / ((float) displayMetrics.densityDpi);
            AppMethodBeat.o(257546);
            return f2;
        }
    }

    public final class c extends d {
        final /* synthetic */ MusicMvLyricView Aym;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(MusicMvLyricView musicMvLyricView, Context context) {
            super(musicMvLyricView, context);
            p.h(context, "context");
            this.Aym = musicMvLyricView;
            AppMethodBeat.i(257549);
            AppMethodBeat.o(257549);
        }

        @Override // android.support.v7.widget.ae
        public final int cc(int i2) {
            return 1;
        }

        @Override // android.support.v7.widget.ae, com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView.d
        public final float a(DisplayMetrics displayMetrics) {
            AppMethodBeat.i(257548);
            p.h(displayMetrics, "displayMetrics");
            float f2 = 0.1f / ((float) displayMetrics.densityDpi);
            AppMethodBeat.o(257548);
            return f2;
        }
    }

    public final class g extends com.tencent.mm.view.recyclerview.e<f> {
        public g() {
            MusicMvLyricView.this = r1;
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, f fVar, int i2, int i3, boolean z, List list) {
            AppMethodBeat.i(257558);
            f fVar2 = fVar;
            p.h(hVar, "holder");
            p.h(fVar2, "item");
            TextView textView = (TextView) hVar.Mn(R.id.f5k);
            if (textView != null) {
                textView.setText(fVar2.Ayn.text);
            }
            if (fVar2.Ayn.bfW) {
                TextView textView2 = (TextView) hVar.Mn(R.id.f5k);
                if (textView2 != null) {
                    Context context = MusicMvLyricView.this.getContext();
                    p.g(context, "context");
                    textView2.setTextColor(context.getResources().getColor(R.color.am));
                    AppMethodBeat.o(257558);
                    return;
                }
                AppMethodBeat.o(257558);
                return;
            }
            TextView textView3 = (TextView) hVar.Mn(R.id.f5k);
            if (textView3 != null) {
                Context context2 = MusicMvLyricView.this.getContext();
                p.g(context2, "context");
                textView3.setTextColor(context2.getResources().getColor(R.color.BW_100_Alpha_0_5));
                AppMethodBeat.o(257558);
                return;
            }
            AppMethodBeat.o(257558);
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final int getLayoutId() {
            return R.layout.be9;
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
            AppMethodBeat.i(257557);
            p.h(recyclerView, "recyclerView");
            p.h(hVar, "holder");
            AppMethodBeat.o(257557);
        }
    }

    public static final class f implements com.tencent.mm.view.recyclerview.a {
        final e Ayn;

        public f(e eVar) {
            p.h(eVar, "lyricInfo");
            AppMethodBeat.i(257556);
            this.Ayn = eVar;
            AppMethodBeat.o(257556);
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            AppMethodBeat.i(257555);
            long hashCode = (long) this.Ayn.hashCode();
            AppMethodBeat.o(257555);
            return hashCode;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return 7;
        }
    }

    public static final class e implements Comparable<e> {
        boolean bfW = false;
        String text;
        long time;

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(e eVar) {
            AppMethodBeat.i(257553);
            e eVar2 = eVar;
            p.h(eVar2, "entry");
            int i2 = (int) (this.time - eVar2.time);
            AppMethodBeat.o(257553);
            return i2;
        }

        public e(long j2, String str) {
            p.h(str, "text");
            AppMethodBeat.i(257554);
            this.time = j2;
            this.text = str;
            AppMethodBeat.o(257554);
        }
    }

    public static final class n extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ MusicMvLyricView Aym;
        final /* synthetic */ boolean Ayo;
        final /* synthetic */ long uLo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(MusicMvLyricView musicMvLyricView, long j2, boolean z) {
            super(0);
            this.Aym = musicMvLyricView;
            this.uLo = j2;
            this.Ayo = z;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int b2;
            boolean z;
            View view;
            d dVar;
            ae aeVar;
            boolean z2 = false;
            AppMethodBeat.i(257565);
            if (MusicMvLyricView.d(this.Aym) && (b2 = MusicMvLyricView.b(this.Aym, this.uLo)) >= 0) {
                if (this.uLo < 1000 || b2 < 5) {
                    this.Aym.Ayh = false;
                    z = true;
                } else {
                    z = false;
                }
                if (b2 != this.Aym.Amw) {
                    MusicMvLyricView.a(this.Aym, this.Aym.Amw, b2);
                    if (this.Ayo) {
                        LinearLayoutManager linearLayoutManager = this.Aym.vKp;
                        if ((linearLayoutManager != null ? linearLayoutManager.findViewByPosition(this.Aym.Amw) : null) != null) {
                            z2 = true;
                        }
                        if (!this.Aym.Ayh || z2) {
                            if (!(this.Aym.Ayi instanceof b) || (aeVar = this.Aym.Ayi) == null || !aeVar.isRunning()) {
                                WxRecyclerView wxRecyclerView = this.Aym.Aye;
                                if (wxRecyclerView != null) {
                                    wxRecyclerView.kQ();
                                }
                                if (z) {
                                    MusicMvLyricView musicMvLyricView = this.Aym;
                                    Context context = this.Aym.getContext();
                                    p.g(context, "context");
                                    dVar = new b(musicMvLyricView, context);
                                } else {
                                    MusicMvLyricView musicMvLyricView2 = this.Aym;
                                    Context context2 = this.Aym.getContext();
                                    p.g(context2, "context");
                                    dVar = new d(musicMvLyricView2, context2);
                                }
                                dVar.ct(b2);
                                this.Aym.Ayi = dVar;
                                LinearLayoutManager linearLayoutManager2 = this.Aym.vKp;
                                if (linearLayoutManager2 != null) {
                                    linearLayoutManager2.startSmoothScroll(dVar);
                                }
                            } else {
                                ae aeVar2 = this.Aym.Ayi;
                                if (aeVar2 != null) {
                                    aeVar2.ct(b2);
                                }
                            }
                        }
                    }
                }
                if (!this.Ayo) {
                    LinearLayoutManager linearLayoutManager3 = this.Aym.vKp;
                    if (linearLayoutManager3 != null) {
                        view = linearLayoutManager3.findViewByPosition(b2);
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        MusicMvLyricView musicMvLyricView3 = this.Aym;
                        Context context3 = this.Aym.getContext();
                        p.g(context3, "context");
                        c cVar = new c(musicMvLyricView3, context3);
                        cVar.ct(b2);
                        LinearLayoutManager linearLayoutManager4 = this.Aym.vKp;
                        if (linearLayoutManager4 != null) {
                            linearLayoutManager4.startSmoothScroll(cVar);
                        }
                    } else {
                        int[] iArr = new int[2];
                        WxRecyclerView wxRecyclerView2 = this.Aym.Aye;
                        if (wxRecyclerView2 != null) {
                            wxRecyclerView2.getLocationInWindow(iArr);
                        }
                        int height = ((int) (((float) this.Aym.getHeight()) * 0.37f)) - iArr[1];
                        LinearLayoutManager linearLayoutManager5 = this.Aym.vKp;
                        if (linearLayoutManager5 != null) {
                            linearLayoutManager5.ah(b2, height);
                        }
                    }
                }
                this.Aym.Amw = b2;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(257565);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(MusicMvLyricView musicMvLyricView, int i2, int i3) {
        ArrayList<D> arrayList;
        f fVar;
        e eVar;
        ArrayList<D> arrayList2;
        f fVar2;
        e eVar2;
        AppMethodBeat.i(257573);
        if (i2 >= 0) {
            WxRecyclerAdapter<f> wxRecyclerAdapter = musicMvLyricView.tFp;
            if (!(wxRecyclerAdapter == null || (arrayList2 = wxRecyclerAdapter.data) == null || (fVar2 = (f) arrayList2.get(i2)) == null || (eVar2 = fVar2.Ayn) == null)) {
                eVar2.bfW = false;
            }
            WxRecyclerAdapter<f> wxRecyclerAdapter2 = musicMvLyricView.tFp;
            if (wxRecyclerAdapter2 != null) {
                wxRecyclerAdapter2.ci(i2);
            }
        }
        WxRecyclerAdapter<f> wxRecyclerAdapter3 = musicMvLyricView.tFp;
        if (!(wxRecyclerAdapter3 == null || (arrayList = wxRecyclerAdapter3.data) == null || (fVar = (f) arrayList.get(i3)) == null || (eVar = fVar.Ayn) == null)) {
            eVar.bfW = true;
        }
        WxRecyclerAdapter<f> wxRecyclerAdapter4 = musicMvLyricView.tFp;
        if (wxRecyclerAdapter4 != null) {
            wxRecyclerAdapter4.ci(i3);
            AppMethodBeat.o(257573);
            return;
        }
        AppMethodBeat.o(257573);
    }

    public static final /* synthetic */ boolean d(MusicMvLyricView musicMvLyricView) {
        AppMethodBeat.i(257574);
        if (!musicMvLyricView.Aor.isEmpty()) {
            AppMethodBeat.o(257574);
            return true;
        }
        AppMethodBeat.o(257574);
        return false;
    }

    public static final /* synthetic */ int b(MusicMvLyricView musicMvLyricView, long j2) {
        AppMethodBeat.i(257575);
        int size = musicMvLyricView.Aor.size();
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            if (j2 < musicMvLyricView.Aor.get(i3).time) {
                size = i3 - 1;
            } else if (i3 + 1 >= musicMvLyricView.Aor.size() || j2 < musicMvLyricView.Aor.get(i3 + 1).time) {
                AppMethodBeat.o(257575);
                return i3;
            } else {
                i2 = i3 + 1;
            }
        }
        AppMethodBeat.o(257575);
        return 0;
    }
}
