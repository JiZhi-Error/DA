package com.tencent.mm.plugin.finder.video.plugin.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.af;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.effect.FinderFilterLayoutManager;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0003!\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u001d\u001a\u00020\u000f2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018J-\u0010\u001f\u001a\u00020\u000f2%\b\u0002\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nR\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00060\u001cR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "adapter", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter;", "itemClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pos", "", "layoutManager", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager;", "selectChangeListener", "position", "selectIndex", "selectTypeList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "selectTypeView", "Landroid/support/v7/widget/RecyclerView;", "snapHelper", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordLinearSnapHelper;", "setData", "title", "setSelectChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Companion", "RecordLinearSnapHelper", "RecordTypeAdapter", "plugin-finder_release"})
public final class RecordTypeSelectView extends RelativeLayout {
    public static final a whA = new a((byte) 0);
    private kotlin.g.a.b<? super Integer, x> hXE;
    private RecyclerView wht;
    private ArrayList<String> whu = new ArrayList<>();
    private int whv;
    private c whw;
    private FinderFilterLayoutManager whx;
    private b why;
    private kotlin.g.a.b<? super Integer, x> whz;

    static {
        AppMethodBeat.i(254519);
        AppMethodBeat.o(254519);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class d extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ RecordTypeSelectView whB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(RecordTypeSelectView recordTypeSelectView) {
            super(1);
            this.whB = recordTypeSelectView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(254516);
            int intValue = num.intValue();
            this.whB.whv = intValue;
            kotlin.g.a.b bVar = this.whB.whz;
            if (bVar != null) {
                bVar.invoke(Integer.valueOf(this.whB.whv));
            }
            this.whB.whw.notifyDataSetChanged();
            FinderFilterLayoutManager finderFilterLayoutManager = this.whB.whx;
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(intValue, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(finderFilterLayoutManager, a2.axQ(), "com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$itemClickListener$1", "invoke", "(I)V", "Undefined", "scrollToPosition", "(I)V");
            finderFilterLayoutManager.scrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(finderFilterLayoutManager, "com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$itemClickListener$1", "invoke", "(I)V", "Undefined", "scrollToPosition", "(I)V");
            x xVar = x.SXb;
            AppMethodBeat.o(254516);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordTypeSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(254518);
        this.whw = new c(this, context);
        this.whx = new FinderFilterLayoutManager(context);
        this.why = new b();
        this.hXE = new d(this);
        LayoutInflater.from(context).inflate(R.layout.aja, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.hit);
        p.g(findViewById, "findViewById(R.id.select_type_list)");
        this.wht = (RecyclerView) findViewById;
        this.wht.setLayoutManager(this.whx);
        this.wht.setAdapter(this.whw);
        this.why.f(this.wht);
        AppMethodBeat.o(254518);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void setData(ArrayList<String> arrayList) {
        AppMethodBeat.i(254517);
        p.h(arrayList, "title");
        this.whu.addAll(arrayList);
        this.whw.notifyDataSetChanged();
        AppMethodBeat.o(254517);
    }

    public final void setSelectChangeListener(kotlin.g.a.b<? super Integer, x> bVar) {
        this.whz = bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordLinearSnapHelper;", "Landroid/support/v7/widget/LinearSnapHelper;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;)V", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "findSnapView", "findTargetSnapPosition", "", "velocityX", "velocityY", "plugin-finder_release"})
    public final class b extends af {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // android.support.v7.widget.at, android.support.v7.widget.af
        public final int[] a(RecyclerView.LayoutManager layoutManager, View view) {
            AppMethodBeat.i(254507);
            p.h(layoutManager, "layoutManager");
            p.h(view, "targetView");
            int[] a2 = super.a(layoutManager, view);
            AppMethodBeat.o(254507);
            return a2;
        }

        @Override // android.support.v7.widget.at, android.support.v7.widget.af
        public final int a(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
            AppMethodBeat.i(254508);
            int a2 = super.a(layoutManager, i2, i3);
            AppMethodBeat.o(254508);
            return a2;
        }

        @Override // android.support.v7.widget.at, android.support.v7.widget.af
        public final View a(RecyclerView.LayoutManager layoutManager) {
            Object obj;
            Object obj2;
            AppMethodBeat.i(254509);
            View a2 = super.a(layoutManager);
            Log.i("MicroMsg.RecordTypeSelectView", "findSnapView " + (a2 != null ? a2.getTag() : null));
            int i2 = RecordTypeSelectView.this.whv;
            if (a2 != null) {
                obj = a2.getTag();
            } else {
                obj = null;
            }
            if (!(obj instanceof Integer) || i2 != ((Integer) obj).intValue()) {
                RecordTypeSelectView recordTypeSelectView = RecordTypeSelectView.this;
                if (a2 != null) {
                    obj2 = a2.getTag();
                } else {
                    obj2 = null;
                }
                Integer num = (Integer) obj2;
                recordTypeSelectView.whv = num != null ? num.intValue() : 0;
                kotlin.g.a.b bVar = RecordTypeSelectView.this.whz;
                if (bVar != null) {
                    bVar.invoke(Integer.valueOf(RecordTypeSelectView.this.whv));
                }
                RecordTypeSelectView.this.whw.notifyDataSetChanged();
            }
            AppMethodBeat.o(254509);
            return a2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getItemCount", "", "getSpecialMargin", "width", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
    public final class c extends RecyclerView.a<RecyclerView.v> {
        private Context context;
        final /* synthetic */ RecordTypeSelectView whB;

        public c(RecordTypeSelectView recordTypeSelectView, Context context2) {
            p.h(context2, "context");
            this.whB = recordTypeSelectView;
            AppMethodBeat.i(254515);
            this.context = context2;
            AppMethodBeat.o(254515);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, hxF = {"com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
        public static final class b extends RecyclerView.v {
            final /* synthetic */ View rsM;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(View view, View view2) {
                super(view2);
                this.rsM = view;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(254511);
            p.h(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.aj_, viewGroup, false);
            b bVar = new b(inflate, inflate);
            AppMethodBeat.o(254511);
            return bVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(254512);
            int size = this.whB.whu.size();
            AppMethodBeat.o(254512);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            int i3;
            int i4 = 0;
            AppMethodBeat.i(254513);
            p.h(vVar, "viewHolder");
            View view = vVar.aus;
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(254513);
                throw tVar;
            }
            TextView textView = (TextView) view;
            textView.setText((CharSequence) this.whB.whu.get(i2));
            float measureText = textView.getPaint().measureText((String) this.whB.whu.get(i2)) + ((float) com.tencent.mm.cb.a.aG(this.context, R.dimen.ci));
            Log.d("MicroMsg.RecordTypeSelectView", "onBindViewHolder pos:" + i2 + " width:" + measureText);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
                AppMethodBeat.o(254513);
                throw tVar2;
            }
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            if (i2 == 0) {
                i3 = Mh((int) measureText);
            } else {
                i3 = 0;
            }
            layoutParams2.setMarginStart(i3);
            ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
            if (layoutParams3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
                AppMethodBeat.o(254513);
                throw tVar3;
            }
            RecyclerView.LayoutParams layoutParams4 = (RecyclerView.LayoutParams) layoutParams3;
            if (i2 == getItemCount() - 1) {
                i4 = Mh((int) measureText);
            }
            layoutParams4.setMarginEnd(i4);
            textView.setAlpha(i2 == this.whB.whv ? 1.0f : 0.5f);
            textView.setTag(Integer.valueOf(i2));
            textView.setOnClickListener(new a(this, i2));
            AppMethodBeat.o(254513);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ c whC;

            a(c cVar, int i2) {
                this.whC = cVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(254510);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.whC.whB.hXE.invoke(Integer.valueOf(this.gUj));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(254510);
            }
        }

        private final int Mh(int i2) {
            AppMethodBeat.i(254514);
            int jn = (com.tencent.mm.cb.a.jn(this.context) - i2) / 2;
            AppMethodBeat.o(254514);
            return jn;
        }
    }
}
