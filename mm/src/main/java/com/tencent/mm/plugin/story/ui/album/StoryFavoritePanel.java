package com.tencent.mm.plugin.story.ui.album;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.x;

public final class StoryFavoritePanel extends RelativeLayout {
    private static final int FzB;
    static final int FzC = 1;
    public static final a FzD = new a((byte) 0);
    final int BPk = 2;
    private kotlin.g.a.b<? super c, x> FzA;
    final int Fzn;
    final int Fzo = 1;
    private final int Fzp = 3;
    TextView Fzq;
    TextView Fzr;
    RecyclerView Fzs;
    e Fzt = new e();
    private final float Fzu = (com.tencent.mm.cb.a.getDensity(getContext()) * 1.0f);
    final ArrayList<c> Fzv = new ArrayList<>();
    final ArrayList<j> Fzw = new ArrayList<>();
    private int Fzx;
    private q<? super c, ? super Integer, ? super Boolean, x> Fzy;
    private m<? super c, ? super Integer, x> Fzz;
    final String TAG = "MicroMsg.StoryFavoritePanel";
    private final int att = 4;
    boolean dJM;
    int fromScene = FzB;
    private boolean qhf;

    static final class i extends kotlin.g.b.q implements kotlin.g.a.b<j, Boolean> {
        final /* synthetic */ long FsG;
        final /* synthetic */ StoryFavoritePanel FzE;
        final /* synthetic */ boolean FzJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(StoryFavoritePanel storyFavoritePanel, boolean z, long j2) {
            super(1);
            this.FzE = storyFavoritePanel;
            this.FzJ = z;
            this.FsG = j2;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(j jVar) {
            boolean z;
            AppMethodBeat.i(119897);
            j jVar2 = jVar;
            p.h(jVar2, LocaleUtil.ITALIAN);
            if (jVar2.field_storyID == this.FsG) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(119897);
            return valueOf;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119905);
        AppMethodBeat.o(119905);
    }

    public final ArrayList<c> getMDatas() {
        return this.Fzv;
    }

    public final ArrayList<j> getMCheckedDatas() {
        return this.Fzw;
    }

    public final int getCheckedFavTime() {
        return this.Fzx;
    }

    public final void setCheckedFavTime(int i2) {
        this.Fzx = i2;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.q<? super com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$c, ? super java.lang.Integer, ? super java.lang.Boolean, kotlin.x>, kotlin.g.a.q<com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$c, java.lang.Integer, java.lang.Boolean, kotlin.x> */
    public final q<c, Integer, Boolean, x> getMOnCheckItemListener() {
        return this.Fzy;
    }

    public final void setMOnCheckItemListener(q<? super c, ? super Integer, ? super Boolean, x> qVar) {
        this.Fzy = qVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$c, ? super java.lang.Integer, kotlin.x>, kotlin.g.a.m<com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$c, java.lang.Integer, kotlin.x> */
    public final m<c, Integer, x> getMOnFavItemClickListener() {
        return this.Fzz;
    }

    public final void setMOnFavItemClickListener(m<? super c, ? super Integer, x> mVar) {
        this.Fzz = mVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$c, kotlin.x>, kotlin.g.a.b<com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$c, kotlin.x> */
    public final kotlin.g.a.b<c, x> getMOnAddItemClickListener() {
        return this.FzA;
    }

    public final void setMOnAddItemClickListener(kotlin.g.a.b<? super c, x> bVar) {
        this.FzA = bVar;
    }

    public final boolean getMIsAll() {
        return this.qhf;
    }

    public final void setMIsAll(boolean z) {
        this.qhf = z;
    }

    public final void setSelf(boolean z) {
        this.dJM = z;
    }

    public final int getFromScene() {
        return this.fromScene;
    }

    public final void setFromScene(int i2) {
        this.fromScene = i2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryFavoritePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(119903);
        init();
        AppMethodBeat.o(119903);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryFavoritePanel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(119904);
        init();
        AppMethodBeat.o(119904);
    }

    private final void init() {
        AppMethodBeat.i(119898);
        View.inflate(getContext(), R.layout.bz4, this);
        this.Fzq = (TextView) findViewById(R.id.i77);
        this.Fzr = (TextView) findViewById(R.id.i6x);
        this.Fzs = (RecyclerView) findViewById(R.id.i72);
        getContext();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.att);
        gridLayoutManager.a(new h(this));
        RecyclerView recyclerView = this.Fzs;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        RecyclerView recyclerView2 = this.Fzs;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.Fzt);
        }
        RecyclerView recyclerView3 = this.Fzs;
        if (recyclerView3 != null) {
            recyclerView3.b(new b());
        }
        RecyclerView recyclerView4 = this.Fzs;
        if (recyclerView4 != null) {
            recyclerView4.setItemAnimator(null);
            AppMethodBeat.o(119898);
            return;
        }
        AppMethodBeat.o(119898);
    }

    public static final class h extends GridLayoutManager.b {
        final /* synthetic */ StoryFavoritePanel FzE;

        h(StoryFavoritePanel storyFavoritePanel) {
            this.FzE = storyFavoritePanel;
        }

        @Override // android.support.v7.widget.GridLayoutManager.b
        public final int bX(int i2) {
            AppMethodBeat.i(119896);
            if (this.FzE.Fzt.getItemViewType(i2) == this.FzE.BPk) {
                int i3 = this.FzE.att;
                AppMethodBeat.o(119896);
                return i3;
            }
            AppMethodBeat.o(119896);
            return 1;
        }
    }

    public final void setup(int i2) {
        this.fromScene = i2;
    }

    public final void v(List<j> list, List<j> list2) {
        AppMethodBeat.i(119899);
        p.h(list, "checkableStory");
        p.h(list2, "checkedStory");
        Log.i(this.TAG, "updateFavStory " + list.size() + ' ' + list2.size());
        TextView textView = this.Fzr;
        if (textView != null) {
            textView.setVisibility(8);
        }
        RecyclerView recyclerView = this.Fzs;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        this.Fzv.clear();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.Fzv.add(new c(it.next(), this.Fzp));
        }
        this.Fzv.add(new c(new j(), this.BPk));
        for (T t : list2) {
            if (this.Fzx == 0 || ((j) t).field_createTime < this.Fzx) {
                Log.d(this.TAG, "add to CheckedList: " + ((j) t).field_storyID);
                this.Fzw.add(t);
            }
        }
        j jVar = (j) kotlin.a.j.kv(list2);
        this.Fzx = jVar != null ? jVar.field_createTime : 0;
        this.Fzt.notifyDataSetChanged();
        AppMethodBeat.o(119899);
    }

    public final void aSC(String str) {
        AppMethodBeat.i(119900);
        p.h(str, "tip");
        TextView textView = this.Fzr;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.Fzq;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        RecyclerView recyclerView = this.Fzs;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        TextView textView3 = this.Fzr;
        if (textView3 != null) {
            textView3.setText(str);
            AppMethodBeat.o(119900);
            return;
        }
        AppMethodBeat.o(119900);
    }

    public final void a(RecyclerView.l lVar) {
        AppMethodBeat.i(119901);
        p.h(lVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        RecyclerView recyclerView = this.Fzs;
        if (recyclerView != null) {
            recyclerView.a(lVar);
            AppMethodBeat.o(119901);
            return;
        }
        AppMethodBeat.o(119901);
    }

    public final class e extends RecyclerView.a<RecyclerView.v> {
        public e() {
            StoryFavoritePanel.this = r1;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(119890);
            p.h(viewGroup, "parent");
            if (i2 == StoryFavoritePanel.this.Fzn) {
                View inflate = aa.jQ(StoryFavoritePanel.this.getContext()).inflate(R.layout.byy, viewGroup, false);
                StoryFavoritePanel storyFavoritePanel = StoryFavoritePanel.this;
                p.g(inflate, "itemView");
                f fVar = new f(storyFavoritePanel, inflate);
                AppMethodBeat.o(119890);
                return fVar;
            } else if (i2 == StoryFavoritePanel.this.BPk) {
                StoryFavoritePanel storyFavoritePanel2 = StoryFavoritePanel.this;
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bz7, viewGroup, false);
                p.g(inflate2, "LayoutInflater.from(pare…ng_layout, parent, false)");
                b bVar = new b(storyFavoritePanel2, inflate2);
                AppMethodBeat.o(119890);
                return bVar;
            } else if (i2 == StoryFavoritePanel.this.Fzp) {
                StoryFavoritePanel storyFavoritePanel3 = StoryFavoritePanel.this;
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bz1, viewGroup, false);
                p.g(inflate3, "LayoutInflater.from(pare…lect_item, parent, false)");
                d dVar = new d(storyFavoritePanel3, inflate3);
                AppMethodBeat.o(119890);
                return dVar;
            } else {
                View inflate4 = aa.jQ(StoryFavoritePanel.this.getContext()).inflate(R.layout.byz, viewGroup, false);
                StoryFavoritePanel storyFavoritePanel4 = StoryFavoritePanel.this;
                p.g(inflate4, "itemView");
                g gVar = new g(storyFavoritePanel4, inflate4);
                AppMethodBeat.o(119890);
                return gVar;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(119891);
            int i3 = StoryFavoritePanel.this.getMDatas().get(i2).type;
            AppMethodBeat.o(119891);
            return i3;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(119892);
            int size = StoryFavoritePanel.this.getMDatas().size();
            AppMethodBeat.o(119892);
            return size;
        }

        /* JADX WARNING: Removed duplicated region for block: B:38:0x010c  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x015b  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x01ad  */
        @Override // android.support.v7.widget.RecyclerView.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(android.support.v7.widget.RecyclerView.v r13, int r14) {
            /*
            // Method dump skipped, instructions count: 498
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.e.a(android.support.v7.widget.RecyclerView$v, int):void");
        }

        static final class a implements View.OnClickListener {
            final /* synthetic */ RecyclerView.v AuS;
            final /* synthetic */ c FzG;
            final /* synthetic */ e FzH;
            final /* synthetic */ int oeZ;

            a(c cVar, e eVar, RecyclerView.v vVar, int i2) {
                this.FzG = cVar;
                this.FzH = eVar;
                this.AuS = vVar;
                this.oeZ = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(222919);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.b<c, x> mOnAddItemClickListener = StoryFavoritePanel.this.getMOnAddItemClickListener();
                if (mOnAddItemClickListener != null) {
                    mOnAddItemClickListener.invoke(this.FzG);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(222919);
            }
        }

        static final class b implements View.OnClickListener {
            final /* synthetic */ RecyclerView.v AuS;
            final /* synthetic */ c FzG;
            final /* synthetic */ e FzH;
            final /* synthetic */ int oeZ;

            b(c cVar, e eVar, RecyclerView.v vVar, int i2) {
                this.FzG = cVar;
                this.FzH = eVar;
                this.AuS = vVar;
                this.oeZ = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(222920);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                m<c, Integer, x> mOnFavItemClickListener = StoryFavoritePanel.this.getMOnFavItemClickListener();
                if (mOnFavItemClickListener != null) {
                    mOnFavItemClickListener.invoke(this.FzG, Integer.valueOf(this.oeZ));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(222920);
            }
        }

        /* access modifiers changed from: package-private */
        public static final class c implements CompoundButton.OnCheckedChangeListener {
            final /* synthetic */ RecyclerView.v AuS;
            final /* synthetic */ c FzG;
            final /* synthetic */ e FzH;
            final /* synthetic */ int oeZ;

            c(c cVar, e eVar, RecyclerView.v vVar, int i2) {
                this.FzG = cVar;
                this.FzH = eVar;
                this.AuS = vVar;
                this.oeZ = i2;
            }

            /* JADX WARNING: Removed duplicated region for block: B:17:0x006d  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onCheckedChanged(android.widget.CompoundButton r10, boolean r11) {
                /*
                // Method dump skipped, instructions count: 244
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.e.c.onCheckedChanged(android.widget.CompoundButton, boolean):void");
            }
        }

        static final class d implements View.OnClickListener {
            final /* synthetic */ RecyclerView.v AuS;
            final /* synthetic */ e FzH;
            final /* synthetic */ int oeZ;

            d(e eVar, RecyclerView.v vVar, int i2) {
                this.FzH = eVar;
                this.AuS = vVar;
                this.oeZ = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(222923);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ((d) this.AuS).FzF.setChecked(!((d) this.AuS).FzF.isChecked());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(222923);
            }
        }

        /* renamed from: com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel$e$e */
        static final class View$OnClickListenerC1778e implements View.OnClickListener {
            final /* synthetic */ RecyclerView.v AuS;
            final /* synthetic */ c FzG;
            final /* synthetic */ e FzH;
            final /* synthetic */ int oeZ;

            View$OnClickListenerC1778e(c cVar, e eVar, RecyclerView.v vVar, int i2) {
                this.FzG = cVar;
                this.FzH = eVar;
                this.AuS = vVar;
                this.oeZ = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(222924);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter$onBindViewHolder$$inlined$let$lambda$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                m<c, Integer, x> mOnFavItemClickListener = StoryFavoritePanel.this.getMOnFavItemClickListener();
                if (mOnFavItemClickListener != null) {
                    mOnFavItemClickListener.invoke(this.FzG, Integer.valueOf(this.oeZ));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter$onBindViewHolder$$inlined$let$lambda$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(222924);
            }
        }
    }

    public final void vK(boolean z) {
        AppMethodBeat.i(119902);
        this.qhf = z;
        if (!this.Fzv.isEmpty()) {
            this.Fzt.ci(this.Fzt.getItemCount() - 1);
        }
        AppMethodBeat.o(119902);
    }

    public final class g extends RecyclerView.v {
        ImageView FyS;
        final /* synthetic */ StoryFavoritePanel FzE;
        private TextView jUO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(StoryFavoritePanel storyFavoritePanel, View view) {
            super(view);
            p.h(view, "itemView");
            this.FzE = storyFavoritePanel;
            AppMethodBeat.i(119895);
            View findViewById = view.findViewById(R.id.i70);
            p.g(findViewById, "itemView.findViewById(R.…lbum_fav_item_normal_img)");
            this.FyS = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.i71);
            p.g(findViewById2, "itemView.findViewById(R.…album_fav_item_normal_tv)");
            this.jUO = (TextView) findViewById2;
            AppMethodBeat.o(119895);
        }
    }

    public final class f extends RecyclerView.v {
        final /* synthetic */ StoryFavoritePanel FzE;
        ImageView kc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(StoryFavoritePanel storyFavoritePanel, View view) {
            super(view);
            p.h(view, "itemView");
            this.FzE = storyFavoritePanel;
            AppMethodBeat.i(119894);
            View findViewById = view.findViewById(R.id.i6y);
            p.g(findViewById, "itemView.findViewById(R.…y_album_fav_item_add_img)");
            this.kc = (ImageView) findViewById;
            AppMethodBeat.o(119894);
        }
    }

    public static final class c {
        final j Fqr;
        final int type;

        public c(j jVar, int i2) {
            p.h(jVar, "storyInfo");
            AppMethodBeat.i(119882);
            this.Fqr = jVar;
            this.type = i2;
            AppMethodBeat.o(119882);
        }
    }

    public final class b extends RecyclerView.v {
        ViewGroup FyL;
        ImageView FyM;
        final /* synthetic */ StoryFavoritePanel FzE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(StoryFavoritePanel storyFavoritePanel, View view) {
            super(view);
            p.h(view, "view");
            this.FzE = storyFavoritePanel;
            AppMethodBeat.i(119881);
            View findViewById = view.findViewById(R.id.epm);
            p.g(findViewById, "view.findViewById(R.id.loading_more_state)");
            this.FyL = (ViewGroup) findViewById;
            View findViewById2 = view.findViewById(R.id.k9);
            p.g(findViewById2, "view.findViewById(R.id.album_is_all_view)");
            this.FyM = (ImageView) findViewById2;
            AppMethodBeat.o(119881);
        }
    }

    public final class d extends RecyclerView.v {
        ImageView FyS;
        final /* synthetic */ StoryFavoritePanel FzE;
        CheckBox FzF;
        View clickArea;
        ImageView tkK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(StoryFavoritePanel storyFavoritePanel, View view) {
            super(view);
            p.h(view, "view");
            this.FzE = storyFavoritePanel;
            AppMethodBeat.i(119883);
            View findViewById = this.aus.findViewById(R.id.i75);
            p.g(findViewById, "itemView.findViewById(R.…album_fav_select_item_iv)");
            this.FyS = (ImageView) findViewById;
            View findViewById2 = this.aus.findViewById(R.id.i74);
            p.g(findViewById2, "itemView.findViewById(R.…fav_select_item_check_iv)");
            this.FzF = (CheckBox) findViewById2;
            View findViewById3 = this.aus.findViewById(R.id.i76);
            p.g(findViewById3, "itemView.findViewById(R.…_select_item_normal_mask)");
            this.tkK = (ImageView) findViewById3;
            View findViewById4 = this.aus.findViewById(R.id.i73);
            p.g(findViewById4, "itemView.findViewById(R.…v_select_item_check_area)");
            this.clickArea = findViewById4;
            AppMethodBeat.o(119883);
        }
    }
}
