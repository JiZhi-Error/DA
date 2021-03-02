package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Vibrator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.live.core.d.a;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u000278B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010+\u001a\u00020\u001aH\u0002J\u0018\u0010,\u001a\u00020\u001a2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019J\b\u0010.\u001a\u00020\u001aH\u0002J\b\u0010/\u001a\u00020\u001aH\u0002J\u0010\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u0017H\u0002J\u0006\u00102\u001a\u00020\u001aJ\u0006\u00103\u001a\u00020\u001aJ\u0010\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u000206H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0012j\b\u0012\u0004\u0012\u00020\u000e`\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \f*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u001a\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n \f*\u0004\u0018\u00010%0%X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n \f*\u0004\u0018\u00010'0'X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n \f*\u0004\u0018\u00010)0)X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n \f*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget;", "", "filterPanelRoot", "Landroid/widget/RelativeLayout;", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;)V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget$CameraOptFilterAdapter;", "closeGroup", "kotlin.jvm.PlatformType", "curSelectedFilter", "Lcom/tencent/mm/live/core/util/LiveFilterUtil$FilterInfo;", "curSelectedView", "Landroid/view/View;", "filterList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "Landroid/support/v7/widget/RecyclerView;", "maxTranslationX", "", "onCloseCallback", "Lkotlin/Function0;", "", "getOnCloseCallback", "()Lkotlin/jvm/functions/Function0;", "setOnCloseCallback", "(Lkotlin/jvm/functions/Function0;)V", "onSelectedFilter", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "filterInfo", "seekBar", "Landroid/widget/SeekBar;", "seekBarDefaultIcon", "Landroid/widget/ImageView;", "seekBarTv", "Landroid/widget/TextView;", "vibrator", "checkSeekBar", "hidePanel", "endAction", "loadFilterInfo", "moveDefaultIcon", "moveProgressIndicator", "progress", "resetState", "showFilterPanel", "vibrate", "value", "", "CameraOptFilterAdapter", "CameraOptFilterViewHolder", "plugin-finder_release"})
public final class e {
    final String TAG = "Finder.FinderLiveCameraOptFilterWidget";
    final ArrayList<a.C0387a> filterList = new ArrayList<>();
    final Object hQn = this.uGb.getContext().getSystemService("vibrator");
    final com.tencent.mm.live.core.core.trtc.a hSS;
    final SeekBar oyP = ((SeekBar) this.uGb.findViewById(R.id.cp9));
    final TextView uFF = ((TextView) this.uGb.findViewById(R.id.cpb));
    final ImageView uFG = ((ImageView) this.uGb.findViewById(R.id.cp_));
    private final RecyclerView uFH = ((RecyclerView) this.uGb.findViewById(R.id.cp8));
    int uFN;
    public kotlin.g.a.a<x> uFO;
    private a uFX = new a();
    a.C0387a uFY;
    View uFZ;
    kotlin.g.a.b<? super a.C0387a, x> uGa;
    public final RelativeLayout uGb;
    private final RelativeLayout uzD = ((RelativeLayout) this.uGb.findViewById(R.id.cp7));

    public e(RelativeLayout relativeLayout, com.tencent.mm.live.core.core.trtc.a aVar) {
        T t;
        boolean z;
        p.h(relativeLayout, "filterPanelRoot");
        AppMethodBeat.i(248075);
        this.uGb = relativeLayout;
        this.hSS = aVar;
        this.uGb.setOnClickListener(AnonymousClass1.uGc);
        this.uGb.setTranslationY((float) au.az(this.uGb.getContext()).y);
        this.uzD.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.e.AnonymousClass2 */
            final /* synthetic */ e uGd;

            {
                this.uGd = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(248059);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a<x> aVar = this.uGd.uFO;
                if (aVar != null) {
                    aVar.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248059);
            }
        });
        this.oyP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.e.AnonymousClass3 */
            final /* synthetic */ e uGd;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.uGd = r1;
            }

            public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                int i3;
                Integer num = null;
                AppMethodBeat.i(248060);
                String str = this.uGd.TAG;
                StringBuilder sb = new StringBuilder("curSelectedFilter:");
                a.C0387a aVar = this.uGd.uFY;
                Log.i(str, sb.append(aVar != null ? Integer.valueOf(aVar.key) : null).append(", onProgressChanged:").append(i2).append(", fromUser:").append(z).append(", maxTranslationX:").append(this.uGd.uFN).toString());
                if (!(this.uGd.uFY == null || seekBar == null)) {
                    e.a(this.uGd, i2);
                    o oVar = o.ujN;
                    HashMap<Integer, a.C0387a> dfX = o.dfX();
                    a.C0387a aVar2 = this.uGd.uFY;
                    if (aVar2 != null) {
                        num = Integer.valueOf(aVar2.key);
                    }
                    a.C0387a aVar3 = dfX.get(num);
                    if (aVar3 != null) {
                        aVar3.value = i2;
                    }
                    o oVar2 = o.ujN;
                    com.tencent.mm.live.core.b.b aGl = o.aGl();
                    if (aGl != null) {
                        aGl.hDk = i2;
                    }
                    com.tencent.mm.live.core.core.trtc.a aVar4 = this.uGd.hSS;
                    if (aVar4 != null) {
                        o oVar3 = o.ujN;
                        aVar4.a(o.aGl());
                    }
                    o oVar4 = o.ujN;
                    int dfW = o.dfW();
                    o oVar5 = o.ujN;
                    com.tencent.mm.live.core.b.b aGl2 = o.aGl();
                    if (aGl2 != null) {
                        i3 = aGl2.hDk;
                    } else {
                        i3 = 0;
                    }
                    if (z) {
                        ImageView imageView = this.uGd.uFG;
                        p.g(imageView, "seekBarDefaultIcon");
                        if (imageView.getVisibility() == 0 && dfW == i3) {
                            e eVar = this.uGd;
                            if (eVar.hQn instanceof Vibrator) {
                                ((Vibrator) eVar.hQn).vibrate(10);
                            }
                        }
                    }
                }
                AppMethodBeat.o(248060);
            }

            public final void onStartTrackingTouch(SeekBar seekBar) {
            }

            public final void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        djA();
        Iterator<T> it = this.filterList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            int i2 = next.key;
            o oVar = o.ujN;
            com.tencent.mm.live.core.b.b aGl = o.aGl();
            if (aGl == null || i2 != aGl.hDi) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        this.uFY = t;
        RecyclerView recyclerView = this.uFH;
        p.g(recyclerView, "list");
        recyclerView.setAdapter(this.uFX);
        RecyclerView recyclerView2 = this.uFH;
        p.g(recyclerView2, "list");
        this.uGb.getContext();
        recyclerView2.setLayoutManager(new LinearLayoutManager(0, false));
        this.uGa = new kotlin.g.a.b<a.C0387a, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.e.AnonymousClass4 */
            final /* synthetic */ e uGd;

            {
                this.uGd = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(a.C0387a aVar) {
                AppMethodBeat.i(248061);
                a.C0387a aVar2 = aVar;
                p.h(aVar2, LocaleUtil.ITALIAN);
                this.uGd.uFY = aVar2;
                o oVar = o.ujN;
                com.tencent.mm.live.core.b.b aGl = o.aGl();
                if (aGl != null) {
                    aGl.hDi = aVar2.key;
                }
                o oVar2 = o.ujN;
                com.tencent.mm.live.core.b.b aGl2 = o.aGl();
                if (aGl2 != null) {
                    aGl2.hDj = aVar2.path;
                }
                o oVar3 = o.ujN;
                com.tencent.mm.live.core.b.b aGl3 = o.aGl();
                if (aGl3 != null) {
                    aGl3.hDk = aVar2.value;
                }
                this.uGd.djx();
                com.tencent.mm.live.core.core.trtc.a aVar3 = this.uGd.hSS;
                if (aVar3 != null) {
                    o oVar4 = o.ujN;
                    aVar3.a(o.aGl());
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248061);
                return xVar;
            }
        };
        djx();
        AppMethodBeat.o(248075);
    }

    /* access modifiers changed from: package-private */
    public final void djw() {
        AppMethodBeat.i(248071);
        o oVar = o.ujN;
        int dfW = o.dfW();
        SeekBar seekBar = this.oyP;
        p.g(seekBar, "seekBar");
        float max = ((float) dfW) / ((float) seekBar.getMax());
        SeekBar seekBar2 = this.oyP;
        p.g(seekBar2, "seekBar");
        int measuredWidth = seekBar2.getMeasuredWidth();
        SeekBar seekBar3 = this.oyP;
        p.g(seekBar3, "seekBar");
        int paddingStart = measuredWidth - seekBar3.getPaddingStart();
        SeekBar seekBar4 = this.oyP;
        p.g(seekBar4, "seekBar");
        float paddingEnd = max * ((float) (paddingStart - seekBar4.getPaddingEnd()));
        Log.i(this.TAG, "moveProgressIndicator progress:" + dfW + " translationX:" + paddingEnd);
        ImageView imageView = this.uFG;
        p.g(imageView, "seekBarDefaultIcon");
        imageView.setTranslationX(j.aJ(paddingEnd, (float) this.uFN));
        AppMethodBeat.o(248071);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void djx() {
        /*
        // Method dump skipped, instructions count: 159
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.widget.e.djx():void");
    }

    private final void djA() {
        AppMethodBeat.i(248073);
        ArrayList<a.C0387a> arrayList = this.filterList;
        Context context = this.uGb.getContext();
        p.g(context, "filterPanelRoot.context");
        String string = context.getResources().getString(R.string.cse);
        p.g(string, "filterPanelRoot.context.….finder_live_filter_none)");
        arrayList.add(new a.C0387a(-1, "", string, 0));
        o oVar = o.ujN;
        for (Map.Entry<Integer, a.C0387a> entry : o.dfX().entrySet()) {
            this.filterList.add(entry.getValue());
        }
        AppMethodBeat.o(248073);
    }

    public final void djB() {
        AppMethodBeat.i(248074);
        com.tencent.mm.ac.d.h(new d(this));
        AppMethodBeat.o(248074);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget$CameraOptFilterAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget$CameraOptFilterViewHolder;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget;", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget;)V", "bindFilterPreview", "", "holder", "position", "", "getItemCount", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "plugin-finder_release"})
    public final class a extends RecyclerView.a<b> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(248063);
            p.h(viewGroup, "parent");
            e eVar = e.this;
            View inflate = View.inflate(viewGroup.getContext(), R.layout.adb, null);
            p.g(inflate, "View.inflate(parent.cont…ra_opt_filter_item, null)");
            b bVar = new b(eVar, inflate);
            AppMethodBeat.o(248063);
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(b bVar, int i2) {
            boolean z;
            AppMethodBeat.i(248065);
            b bVar2 = bVar;
            p.h(bVar2, "holder");
            if (i2 == 0) {
                View view = bVar2.aus;
                View view2 = bVar2.aus;
                p.g(view2, "holder.itemView");
                int fromDPToPix = at.fromDPToPix(view2.getContext(), 32);
                View view3 = bVar2.aus;
                p.g(view3, "holder.itemView");
                int paddingTop = view3.getPaddingTop();
                View view4 = bVar2.aus;
                p.g(view4, "holder.itemView");
                int paddingRight = view4.getPaddingRight();
                View view5 = bVar2.aus;
                p.g(view5, "holder.itemView");
                view.setPadding(fromDPToPix, paddingTop, paddingRight, view5.getPaddingBottom());
            } else {
                View view6 = bVar2.aus;
                View view7 = bVar2.aus;
                p.g(view7, "holder.itemView");
                int paddingTop2 = view7.getPaddingTop();
                View view8 = bVar2.aus;
                p.g(view8, "holder.itemView");
                int paddingRight2 = view8.getPaddingRight();
                View view9 = bVar2.aus;
                p.g(view9, "holder.itemView");
                view6.setPadding(0, paddingTop2, paddingRight2, view9.getPaddingBottom());
            }
            a.C0387a aVar = e.this.filterList.get(i2);
            p.g(aVar, "filterList[position]");
            a.C0387a aVar2 = aVar;
            View view10 = bVar2.uGf;
            p.g(view10, "holder.group");
            a.C0387a aVar3 = e.this.uFY;
            if (aVar3 == null || aVar3.key != e.this.filterList.get(i2).key) {
                z = false;
            } else {
                z = true;
            }
            view10.setActivated(z);
            a.C0387a aVar4 = e.this.uFY;
            if (aVar4 != null && aVar4.key == e.this.filterList.get(i2).key) {
                e.this.uFZ = bVar2.uGf;
            }
            a.C0387a aVar5 = e.this.filterList.get(i2);
            p.g(aVar5, "filterList[position]");
            int i3 = aVar5.key;
            e.C0383e eVar = e.C0383e.hxP;
            if (i3 == e.C0383e.aCI()) {
                RoundCornerImageView roundCornerImageView = bVar2.uGg;
                RoundCornerImageView roundCornerImageView2 = bVar2.uGg;
                p.g(roundCornerImageView2, "holder.thumb");
                Context context = roundCornerImageView2.getContext();
                p.g(context, "holder.thumb.context");
                roundCornerImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.aho));
            } else {
                e.C0383e eVar2 = e.C0383e.hxP;
                if (i3 == e.C0383e.aCH()) {
                    RoundCornerImageView roundCornerImageView3 = bVar2.uGg;
                    RoundCornerImageView roundCornerImageView4 = bVar2.uGg;
                    p.g(roundCornerImageView4, "holder.thumb");
                    Context context2 = roundCornerImageView4.getContext();
                    p.g(context2, "holder.thumb.context");
                    roundCornerImageView3.setImageDrawable(context2.getResources().getDrawable(R.drawable.apn));
                } else {
                    e.C0383e eVar3 = e.C0383e.hxP;
                    if (i3 == e.C0383e.aCM()) {
                        RoundCornerImageView roundCornerImageView5 = bVar2.uGg;
                        RoundCornerImageView roundCornerImageView6 = bVar2.uGg;
                        p.g(roundCornerImageView6, "holder.thumb");
                        Context context3 = roundCornerImageView6.getContext();
                        p.g(context3, "holder.thumb.context");
                        roundCornerImageView5.setImageDrawable(context3.getResources().getDrawable(R.drawable.a7w));
                    } else {
                        e.C0383e eVar4 = e.C0383e.hxP;
                        if (i3 == e.C0383e.aCG()) {
                            RoundCornerImageView roundCornerImageView7 = bVar2.uGg;
                            RoundCornerImageView roundCornerImageView8 = bVar2.uGg;
                            p.g(roundCornerImageView8, "holder.thumb");
                            Context context4 = roundCornerImageView8.getContext();
                            p.g(context4, "holder.thumb.context");
                            roundCornerImageView7.setImageDrawable(context4.getResources().getDrawable(R.drawable.ey));
                        } else {
                            e.C0383e eVar5 = e.C0383e.hxP;
                            if (i3 == e.C0383e.aCF()) {
                                RoundCornerImageView roundCornerImageView9 = bVar2.uGg;
                                RoundCornerImageView roundCornerImageView10 = bVar2.uGg;
                                p.g(roundCornerImageView10, "holder.thumb");
                                Context context5 = roundCornerImageView10.getContext();
                                p.g(context5, "holder.thumb.context");
                                roundCornerImageView9.setImageDrawable(context5.getResources().getDrawable(R.drawable.b70));
                            } else {
                                e.C0383e eVar6 = e.C0383e.hxP;
                                if (i3 == e.C0383e.aCJ()) {
                                    RoundCornerImageView roundCornerImageView11 = bVar2.uGg;
                                    RoundCornerImageView roundCornerImageView12 = bVar2.uGg;
                                    p.g(roundCornerImageView12, "holder.thumb");
                                    Context context6 = roundCornerImageView12.getContext();
                                    p.g(context6, "holder.thumb.context");
                                    roundCornerImageView11.setImageDrawable(context6.getResources().getDrawable(R.drawable.a9l));
                                } else {
                                    e.C0383e eVar7 = e.C0383e.hxP;
                                    if (i3 == e.C0383e.aCL()) {
                                        RoundCornerImageView roundCornerImageView13 = bVar2.uGg;
                                        RoundCornerImageView roundCornerImageView14 = bVar2.uGg;
                                        p.g(roundCornerImageView14, "holder.thumb");
                                        Context context7 = roundCornerImageView14.getContext();
                                        p.g(context7, "holder.thumb.context");
                                        roundCornerImageView13.setImageDrawable(context7.getResources().getDrawable(R.drawable.a6p));
                                    } else {
                                        e.C0383e eVar8 = e.C0383e.hxP;
                                        if (i3 == e.C0383e.aCK()) {
                                            RoundCornerImageView roundCornerImageView15 = bVar2.uGg;
                                            RoundCornerImageView roundCornerImageView16 = bVar2.uGg;
                                            p.g(roundCornerImageView16, "holder.thumb");
                                            Context context8 = roundCornerImageView16.getContext();
                                            p.g(context8, "holder.thumb.context");
                                            roundCornerImageView15.setImageDrawable(context8.getResources().getDrawable(R.drawable.a93));
                                        } else {
                                            RoundCornerImageView roundCornerImageView17 = bVar2.uGg;
                                            RoundCornerImageView roundCornerImageView18 = bVar2.uGg;
                                            p.g(roundCornerImageView18, "holder.thumb");
                                            Context context9 = roundCornerImageView18.getContext();
                                            p.g(context9, "holder.thumb.context");
                                            roundCornerImageView17.setImageDrawable(context9.getResources().getDrawable(R.drawable.aq5));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            TextView textView = bVar2.uGh;
            p.g(textView, "holder.name");
            textView.setText(aVar2.title);
            bVar2.uGf.setOnClickListener(new View$OnClickListenerC1207a(this, i2));
            AppMethodBeat.o(248065);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(248064);
            int size = e.this.filterList.size();
            AppMethodBeat.o(248064);
            return size;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.finder.live.widget.e$a$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC1207a implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ a uGe;

            View$OnClickListenerC1207a(a aVar, int i2) {
                this.uGe = aVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(248062);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget$CameraOptFilterAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.C0387a aVar = (a.C0387a) kotlin.a.j.L(e.this.filterList, this.gUj);
                if (aVar != null) {
                    View view2 = e.this.uFZ;
                    if (view2 != null) {
                        view2.setActivated(false);
                    }
                    e.this.uFZ = view;
                    View view3 = e.this.uFZ;
                    if (view3 != null) {
                        view3.setActivated(true);
                    }
                    kotlin.g.a.b<? super a.C0387a, x> bVar2 = e.this.uGa;
                    if (bVar2 != null) {
                        bVar2.invoke(aVar);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget$CameraOptFilterAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248062);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\n \u0006*\u0004\u0018\u00010\u000e0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget$CameraOptFilterViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget;Landroid/view/View;)V", "group", "kotlin.jvm.PlatformType", "getGroup", "()Landroid/view/View;", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "thumb", "Lcom/tencent/mm/ui/widget/RoundCornerImageView;", "getThumb", "()Lcom/tencent/mm/ui/widget/RoundCornerImageView;", "plugin-finder_release"})
    public final class b extends RecyclerView.v {
        final /* synthetic */ e uGd;
        final View uGf;
        final RoundCornerImageView uGg;
        final TextView uGh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(e eVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.uGd = eVar;
            AppMethodBeat.i(248066);
            this.uGf = view.findViewById(R.id.co2);
            this.uGg = (RoundCornerImageView) view.findViewById(R.id.co4);
            this.uGh = (TextView) view.findViewById(R.id.co3);
            AppMethodBeat.o(248066);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e uGd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(e eVar) {
            super(0);
            this.uGd = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(248070);
            this.uGd.uGb.animate().translationY(0.0f).setDuration(200).setListener(null).start();
            if (this.uGd.uFN == 0) {
                this.uGd.uGb.post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.finder.live.widget.e.d.AnonymousClass1 */
                    final /* synthetic */ d uGj;

                    {
                        this.uGj = r1;
                    }

                    public final void run() {
                        int i2;
                        AppMethodBeat.i(248069);
                        e eVar = this.uGj.uGd;
                        SeekBar seekBar = this.uGj.uGd.oyP;
                        p.g(seekBar, "seekBar");
                        int measuredWidth = seekBar.getMeasuredWidth();
                        TextView textView = this.uGj.uGd.uFF;
                        p.g(textView, "seekBarTv");
                        eVar.uFN = measuredWidth - textView.getMeasuredWidth();
                        a.C0387a aVar = this.uGj.uGd.uFY;
                        if (aVar != null) {
                            o oVar = o.ujN;
                            a.C0387a aVar2 = o.dfX().get(Integer.valueOf(aVar.key));
                            if (aVar2 != null) {
                                i2 = aVar2.value;
                            } else {
                                i2 = 0;
                            }
                            e.a(this.uGj.uGd, i2);
                            this.uGj.uGd.djw();
                            AppMethodBeat.o(248069);
                            return;
                        }
                        AppMethodBeat.o(248069);
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(248070);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ kotlin.g.a.a uFT;
        final /* synthetic */ e uGd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(e eVar, kotlin.g.a.a aVar) {
            super(0);
            this.uGd = eVar;
            this.uFT = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(248068);
            this.uGd.uGb.animate().translationY((float) au.az(this.uGd.uGb.getContext()).y).setDuration(200).setListener(new AnimatorListenerAdapter(this) {
                /* class com.tencent.mm.plugin.finder.live.widget.e.c.AnonymousClass1 */
                final /* synthetic */ c uGi;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.uGi = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(248067);
                    kotlin.g.a.a aVar = this.uGi.uFT;
                    if (aVar != null) {
                        aVar.invoke();
                        AppMethodBeat.o(248067);
                        return;
                    }
                    AppMethodBeat.o(248067);
                }
            }).start();
            x xVar = x.SXb;
            AppMethodBeat.o(248068);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(e eVar, int i2) {
        AppMethodBeat.i(248076);
        SeekBar seekBar = eVar.oyP;
        p.g(seekBar, "seekBar");
        float max = ((float) i2) / ((float) seekBar.getMax());
        SeekBar seekBar2 = eVar.oyP;
        p.g(seekBar2, "seekBar");
        int measuredWidth = seekBar2.getMeasuredWidth();
        SeekBar seekBar3 = eVar.oyP;
        p.g(seekBar3, "seekBar");
        int paddingStart = measuredWidth - seekBar3.getPaddingStart();
        SeekBar seekBar4 = eVar.oyP;
        p.g(seekBar4, "seekBar");
        float paddingEnd = ((float) (paddingStart - seekBar4.getPaddingEnd())) * max;
        TextView textView = eVar.uFF;
        p.g(textView, "seekBarTv");
        textView.setText(i2 <= 0 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "+".concat(String.valueOf(i2)));
        TextView textView2 = eVar.uFF;
        p.g(textView2, "seekBarTv");
        textView2.setTranslationX(j.aJ(paddingEnd, (float) eVar.uFN));
        AppMethodBeat.o(248076);
    }
}
