package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.t;
import kotlin.x;

public final class FinderTagView extends RelativeLayout {
    private static final int wpr = -1;
    private static final int wps = -2;
    private static final int wpt = R.id.cm6;
    public static final long wpu = -1;
    public static final a wpv = new a((byte) 0);
    private int bxP = -1;
    public View gvQ;
    public FinderTagFlowLayout wpd;
    public View wpe;
    ArrayList<View> wpf = new ArrayList<>();
    public ArrayList<View> wpg = new ArrayList<>();
    public HashMap<Long, Integer> wph = new HashMap<>();
    public dmk wpi;
    boolean wpj;
    private kotlin.g.a.a<x> wpk;
    kotlin.g.a.a<x> wpl;
    private int wpm;
    public int wpn;
    private b wpo = new b();
    private c wpp = new c(this, this);
    private d wpq = new d(this);

    public static final class b {
        int bg = R.color.f3045c;
        boolean wpA = true;
        int wpw = R.drawable.a23;
        int wpx = R.drawable.a24;
        int wpy = R.color.a2x;
        int wpz = R.color.ag2;
    }

    public static final /* synthetic */ void a(FinderTagView finderTagView, boolean z, View view) {
        AppMethodBeat.i(254992);
        finderTagView.a(z, view, -1);
        AppMethodBeat.o(254992);
    }

    public FinderTagView(Context context) {
        super(context);
        AppMethodBeat.i(254989);
        init(context);
        AppMethodBeat.o(254989);
    }

    public FinderTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(254990);
        init(context);
        AppMethodBeat.o(254990);
    }

    public final FinderTagFlowLayout getTagLayout() {
        AppMethodBeat.i(254970);
        FinderTagFlowLayout finderTagFlowLayout = this.wpd;
        if (finderTagFlowLayout == null) {
            p.btv("tagLayout");
        }
        AppMethodBeat.o(254970);
        return finderTagFlowLayout;
    }

    public final void setTagLayout(FinderTagFlowLayout finderTagFlowLayout) {
        AppMethodBeat.i(254971);
        p.h(finderTagFlowLayout, "<set-?>");
        this.wpd = finderTagFlowLayout;
        AppMethodBeat.o(254971);
    }

    public final View getOpBtn() {
        AppMethodBeat.i(254972);
        View view = this.wpe;
        if (view == null) {
            p.btv("opBtn");
        }
        AppMethodBeat.o(254972);
        return view;
    }

    public final void setOpBtn(View view) {
        AppMethodBeat.i(254973);
        p.h(view, "<set-?>");
        this.wpe = view;
        AppMethodBeat.o(254973);
    }

    public final ArrayList<View> getFoldedView() {
        return this.wpf;
    }

    public final void setFoldedView(ArrayList<View> arrayList) {
        AppMethodBeat.i(254974);
        p.h(arrayList, "<set-?>");
        this.wpf = arrayList;
        AppMethodBeat.o(254974);
    }

    public final ArrayList<View> getAllAddViews() {
        return this.wpg;
    }

    public final void setAllAddViews(ArrayList<View> arrayList) {
        AppMethodBeat.i(254975);
        p.h(arrayList, "<set-?>");
        this.wpg = arrayList;
        AppMethodBeat.o(254975);
    }

    public final int getSelectedIndex() {
        return this.bxP;
    }

    public final void setSelectedIndex(int i2) {
        this.bxP = i2;
    }

    public final HashMap<Long, Integer> getTagClickMap() {
        return this.wph;
    }

    public final void setTagClickMap(HashMap<Long, Integer> hashMap) {
        AppMethodBeat.i(254976);
        p.h(hashMap, "<set-?>");
        this.wph = hashMap;
        AppMethodBeat.o(254976);
    }

    public final dmk getTagData() {
        AppMethodBeat.i(254977);
        dmk dmk = this.wpi;
        if (dmk == null) {
            p.btv("tagData");
        }
        AppMethodBeat.o(254977);
        return dmk;
    }

    public final void setTagData(dmk dmk) {
        AppMethodBeat.i(254978);
        p.h(dmk, "<set-?>");
        this.wpi = dmk;
        AppMethodBeat.o(254978);
    }

    public final void setFolded(boolean z) {
        this.wpj = z;
    }

    public final kotlin.g.a.a<x> getOnFlodListener() {
        return this.wpk;
    }

    public final void setOnFlodListener(kotlin.g.a.a<x> aVar) {
        this.wpk = aVar;
    }

    public final kotlin.g.a.a<x> getOnExpandListener() {
        return this.wpl;
    }

    public final void setOnExpandListener(kotlin.g.a.a<x> aVar) {
        this.wpl = aVar;
    }

    public final int getHasExpandBtn() {
        return this.wpm;
    }

    public final void setHasExpandBtn(int i2) {
        this.wpm = i2;
    }

    public final void setClickExpand(int i2) {
        this.wpn = i2;
    }

    public final View getRoot() {
        AppMethodBeat.i(254979);
        View view = this.gvQ;
        if (view == null) {
            p.btv("root");
        }
        AppMethodBeat.o(254979);
        return view;
    }

    public final void setRoot(View view) {
        AppMethodBeat.i(254980);
        p.h(view, "<set-?>");
        this.gvQ = view;
        AppMethodBeat.o(254980);
    }

    public final b getConfig() {
        return this.wpo;
    }

    public final void setConfig(b bVar) {
        AppMethodBeat.i(254981);
        p.h(bVar, "value");
        Context context = getContext();
        if (context == null) {
            p.hyc();
        }
        setBackgroundColor(context.getResources().getColor(bVar.bg));
        AppMethodBeat.o(254981);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(254991);
        AppMethodBeat.o(254991);
    }

    public final class c implements View.OnClickListener {
        private final FinderTagView wpB;
        final /* synthetic */ FinderTagView wpC;

        public c(FinderTagView finderTagView, FinderTagView finderTagView2) {
            p.h(finderTagView2, "tagView");
            this.wpC = finderTagView;
            AppMethodBeat.i(254963);
            this.wpB = finderTagView2;
            AppMethodBeat.o(254963);
        }

        public final void onClick(View view) {
            AppMethodBeat.i(254962);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderTagView finderTagView = this.wpB;
            if (finderTagView.wpj) {
                for (T t : finderTagView.wpf) {
                    FinderTagFlowLayout finderTagFlowLayout = finderTagView.wpd;
                    if (finderTagFlowLayout == null) {
                        p.btv("tagLayout");
                    }
                    finderTagFlowLayout.addView(t);
                }
                finderTagView.wpf.clear();
                finderTagView.wpj = false;
                finderTagView.dHg();
                kotlin.g.a.a<x> aVar = finderTagView.wpl;
                if (aVar != null) {
                    aVar.invoke();
                }
            }
            this.wpC.setClickExpand(1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254962);
        }
    }

    public static final class d implements View.OnClickListener {
        private final FinderTagView wpB;

        public d(FinderTagView finderTagView) {
            p.h(finderTagView, "tagView");
            AppMethodBeat.i(254965);
            this.wpB = finderTagView;
            AppMethodBeat.o(254965);
        }

        public final void onClick(View view) {
            AppMethodBeat.i(254964);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.wpB.dHh();
            this.wpB.dHg();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254964);
        }
    }

    public final c getExpandListener() {
        return this.wpp;
    }

    public final void setExpandListener(c cVar) {
        AppMethodBeat.i(254982);
        p.h(cVar, "<set-?>");
        this.wpp = cVar;
        AppMethodBeat.o(254982);
    }

    public final d getFlodListener() {
        return this.wpq;
    }

    public final void setFlodListener(d dVar) {
        AppMethodBeat.i(254983);
        p.h(dVar, "<set-?>");
        this.wpq = dVar;
        AppMethodBeat.o(254983);
    }

    private void init(Context context) {
        AppMethodBeat.i(254984);
        View inflate = aa.jQ(context).inflate(R.layout.age, this);
        p.g(inflate, "MMLayoutInflater.getInfl…chinetab_tag_layout,this)");
        this.gvQ = inflate;
        View view = this.gvQ;
        if (view == null) {
            p.btv("root");
        }
        View findViewById = view.findViewById(R.id.czx);
        p.g(findViewById, "root.findViewById(R.id.finder_machine_tag_layout)");
        this.wpd = (FinderTagFlowLayout) findViewById;
        View view2 = this.gvQ;
        if (view2 == null) {
            p.btv("root");
        }
        View findViewById2 = view2.findViewById(R.id.czz);
        p.g(findViewById2, "root.findViewById(R.id.finder_machine_tag_op_icon)");
        this.wpe = findViewById2;
        if (context == null) {
            p.hyc();
        }
        setBackgroundColor(context.getResources().getColor(this.wpo.bg));
        AppMethodBeat.o(254984);
    }

    public final void dHg() {
        AppMethodBeat.i(254985);
        FinderTagFlowLayout finderTagFlowLayout = this.wpd;
        if (finderTagFlowLayout == null) {
            p.btv("tagLayout");
        }
        finderTagFlowLayout.post(new g(this));
        AppMethodBeat.o(254985);
    }

    public static final class g implements Runnable {
        final /* synthetic */ FinderTagView wpC;

        g(FinderTagView finderTagView) {
            this.wpC = finderTagView;
        }

        public final void run() {
            AppMethodBeat.i(254969);
            if (this.wpC.getTagLayout().woZ.size() <= 1 && this.wpC.getFoldedView().isEmpty()) {
                this.wpC.pa(false);
                AppMethodBeat.o(254969);
            } else if (this.wpC.wpj) {
                this.wpC.pa(true);
                this.wpC.getOpBtn().setRotation(90.0f);
                this.wpC.getOpBtn().setOnClickListener(this.wpC.getExpandListener());
                AppMethodBeat.o(254969);
            } else if (this.wpC.getConfig().wpA) {
                this.wpC.getOpBtn().setRotation(-90.0f);
                this.wpC.getOpBtn().setOnClickListener(this.wpC.getFlodListener());
                this.wpC.pa(true);
                AppMethodBeat.o(254969);
            } else {
                this.wpC.pa(false);
                AppMethodBeat.o(254969);
            }
        }
    }

    public final void pa(boolean z) {
        AppMethodBeat.i(254986);
        if (z) {
            this.wpm = 1;
            View view = this.wpe;
            if (view == null) {
                p.btv("opBtn");
            }
            view.setVisibility(0);
            View findViewById = findViewById(R.id.czy);
            p.g(findViewById, "findViewById<View>(R.id.finder_machine_tag_op_bg)");
            findViewById.setVisibility(0);
            View findViewById2 = findViewById(R.id.czw);
            p.g(findViewById2, "findViewById<View>(R.id.finder_machine_op_layout)");
            findViewById2.setVisibility(0);
            AppMethodBeat.o(254986);
            return;
        }
        View view2 = this.wpe;
        if (view2 == null) {
            p.btv("opBtn");
        }
        view2.setOnClickListener(null);
        View view3 = this.wpe;
        if (view3 == null) {
            p.btv("opBtn");
        }
        view3.setVisibility(8);
        View findViewById3 = findViewById(R.id.czy);
        p.g(findViewById3, "findViewById<View>(R.id.finder_machine_tag_op_bg)");
        findViewById3.setVisibility(8);
        View findViewById4 = findViewById(R.id.czw);
        p.g(findViewById4, "findViewById<View>(R.id.finder_machine_op_layout)");
        findViewById4.setVisibility(8);
        AppMethodBeat.o(254986);
    }

    public final void dHh() {
        AppMethodBeat.i(254987);
        FinderTagFlowLayout finderTagFlowLayout = this.wpd;
        if (finderTagFlowLayout == null) {
            p.btv("tagLayout");
        }
        finderTagFlowLayout.post(new e(this));
        AppMethodBeat.o(254987);
    }

    public static final class e implements Runnable {
        final /* synthetic */ FinderTagView wpC;

        e(FinderTagView finderTagView) {
            this.wpC = finderTagView;
        }

        public final void run() {
            AppMethodBeat.i(254966);
            if (!this.wpC.wpj) {
                int size = this.wpC.getTagLayout().woZ.size();
                this.wpC.getFoldedView().clear();
                for (int i2 = 1; i2 < size; i2++) {
                    List<View> list = this.wpC.getTagLayout().woZ.get(i2);
                    p.g(list, "tagLayout.mAllViews[i]");
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        this.wpC.getFoldedView().add(it.next());
                    }
                }
                Iterator<T> it2 = this.wpC.getFoldedView().iterator();
                while (it2.hasNext()) {
                    this.wpC.getTagLayout().removeView(it2.next());
                }
                this.wpC.setFolded(true);
                this.wpC.dHg();
                kotlin.g.a.a<x> onFlodListener = this.wpC.getOnFlodListener();
                if (onFlodListener != null) {
                    onFlodListener.invoke();
                    AppMethodBeat.o(254966);
                    return;
                }
            }
            AppMethodBeat.o(254966);
        }
    }

    public static final class f implements View.OnClickListener {
        final /* synthetic */ FinderTagView wpC;

        public f(FinderTagView finderTagView) {
            this.wpC = finderTagView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(254968);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderTagView$genItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a aVar = FinderTagView.wpv;
            Object tag = view.getTag(FinderTagView.wpr);
            if (tag == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
                AppMethodBeat.o(254968);
                throw tVar;
            }
            boolean booleanValue = ((Boolean) tag).booleanValue();
            final z.d dVar = new z.d();
            a aVar2 = FinderTagView.wpv;
            Object tag2 = view.getTag(FinderTagView.wps);
            if (tag2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(254968);
                throw tVar2;
            }
            dVar.SYE = ((Integer) tag2).intValue();
            int size = this.wpC.getAllAddViews().size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 == dVar.SYE) {
                    FinderTagView finderTagView = this.wpC;
                    View view2 = this.wpC.getAllAddViews().get(i2);
                    p.g(view2, "allAddViews[i]");
                    FinderTagView.a(finderTagView, true, view2);
                } else {
                    FinderTagView finderTagView2 = this.wpC;
                    View view3 = this.wpC.getAllAddViews().get(i2);
                    p.g(view3, "allAddViews[i]");
                    FinderTagView.a(finderTagView2, false, view3);
                }
            }
            if (!booleanValue) {
                new MMHandler().postUI(new Runnable(this) {
                    /* class com.tencent.mm.plugin.finder.view.FinderTagView.f.AnonymousClass1 */
                    final /* synthetic */ f wpD;

                    {
                        this.wpD = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(254967);
                        FinderTagView finderTagView = this.wpD.wpC;
                        bds bds = this.wpD.wpC.getTagData().MPW.get(dVar.SYE);
                        p.g(bds, "tagData.topic_list[indexClick]");
                        FinderTagView.a(finderTagView, bds);
                        AppMethodBeat.o(254967);
                    }
                });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$genItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254968);
        }
    }

    public final void a(boolean z, View view, int i2) {
        AppMethodBeat.i(254988);
        if (i2 >= 0) {
            view.setTag(wps, Integer.valueOf(i2));
        }
        view.setTag(wpr, Boolean.valueOf(z));
        TextView textView = (TextView) view.findViewById(R.id.czv);
        if (z) {
            View view2 = this.gvQ;
            if (view2 == null) {
                p.btv("root");
            }
            Context context = view2.getContext();
            p.g(context, "root.context");
            textView.setTextColor(context.getResources().getColor(this.wpo.wpz));
            textView.setBackgroundResource(this.wpo.wpx);
            AppMethodBeat.o(254988);
            return;
        }
        View view3 = this.gvQ;
        if (view3 == null) {
            p.btv("root");
        }
        Context context2 = view3.getContext();
        p.g(context2, "root.context");
        textView.setTextColor(context2.getResources().getColor(this.wpo.wpy));
        textView.setBackgroundResource(this.wpo.wpw);
        AppMethodBeat.o(254988);
    }

    public static final /* synthetic */ void a(FinderTagView finderTagView, bds bds) {
        AppMethodBeat.i(254993);
        finderTagView.wph.put(Long.valueOf(bds.twp), 1);
        ig igVar = new ig();
        igVar.dMR.dMS = bds;
        EventCenter.instance.publish(igVar);
        AppMethodBeat.o(254993);
    }
}
