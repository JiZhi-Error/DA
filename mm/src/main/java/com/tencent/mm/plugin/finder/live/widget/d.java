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
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003789B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010+\u001a\u00020\u001aH\u0002J\u0018\u0010,\u001a\u00020\u001a2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019J\b\u0010.\u001a\u00020\u001aH\u0002J\b\u0010/\u001a\u00020\u001aH\u0002J\u0010\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u0017H\u0002J\u0006\u00102\u001a\u00020\u001aJ\u0006\u00103\u001a\u00020\u001aJ\u0010\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u000206H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0010*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0010*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u001a\u0018\u00010 X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n \u0010*\u0004\u0018\u00010%0%X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n \u0010*\u0004\u0018\u00010'0'X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n \u0010*\u0004\u0018\u00010)0)X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n \u0010*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget;", "", "beautyPanelRoot", "Landroid/widget/RelativeLayout;", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;)V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget$CameraOptBeautyAdapter;", "beautyList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget$BeautyInfo;", "Lkotlin/collections/ArrayList;", "closeGroup", "kotlin.jvm.PlatformType", "curSelectedBeauty", "curSelecterView", "Landroid/view/View;", "list", "Landroid/support/v7/widget/RecyclerView;", "maxTranslationX", "", "onCloseCallback", "Lkotlin/Function0;", "", "getOnCloseCallback", "()Lkotlin/jvm/functions/Function0;", "setOnCloseCallback", "(Lkotlin/jvm/functions/Function0;)V", "onSelectedBeauty", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "beautyInfo", "seekBar", "Landroid/widget/SeekBar;", "seekBarDefaultIcon", "Landroid/widget/ImageView;", "seekBarTv", "Landroid/widget/TextView;", "vibrator", "checkSeekBar", "hidePanel", "endAction", "loadBeautyInfo", "moveDefaultIcon", "moveProgressIndicator", "progress", "resetState", "showBeautyPanel", "vibrate", "value", "", "BeautyInfo", "CameraOptBeautyAdapter", "CameraOptBeautyViewHolder", "plugin-finder_release"})
public final class d {
    final String TAG = "Finder.FinderLiveCameraOptBeautyWidget";
    final Object hQn = this.uFP.getContext().getSystemService("vibrator");
    final com.tencent.mm.live.core.core.trtc.a hSS;
    final SeekBar oyP = ((SeekBar) this.uFP.findViewById(R.id.cp0));
    final TextView uFF = ((TextView) this.uFP.findViewById(R.id.cp3));
    final ImageView uFG = ((ImageView) this.uFP.findViewById(R.id.cp1));
    private final RecyclerView uFH = ((RecyclerView) this.uFP.findViewById(R.id.coz));
    private final b uFI = new b();
    final ArrayList<a> uFJ = new ArrayList<>();
    a uFK;
    final kotlin.g.a.b<a, x> uFL;
    View uFM;
    int uFN;
    public kotlin.g.a.a<x> uFO;
    public final RelativeLayout uFP;
    private final RelativeLayout uzD = ((RelativeLayout) this.uFP.findViewById(R.id.coy));

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget$BeautyInfo;", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<a, Boolean> {
        public static final e uFV = new e();

        static {
            AppMethodBeat.i(248048);
            AppMethodBeat.o(248048);
        }

        e() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(a aVar) {
            boolean z;
            AppMethodBeat.i(248047);
            a aVar2 = aVar;
            p.h(aVar2, LocaleUtil.ITALIAN);
            int i2 = aVar2.key;
            e.c cVar = e.c.hxm;
            if (i2 == e.c.aCm()) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(248047);
            return valueOf;
        }
    }

    public d(RelativeLayout relativeLayout, com.tencent.mm.live.core.core.trtc.a aVar) {
        p.h(relativeLayout, "beautyPanelRoot");
        AppMethodBeat.i(248055);
        this.uFP = relativeLayout;
        this.hSS = aVar;
        this.uFP.setOnClickListener(AnonymousClass1.uFQ);
        this.uFP.setTranslationY((float) au.az(this.uFP.getContext()).y);
        this.uzD.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.d.AnonymousClass2 */
            final /* synthetic */ d uFR;

            {
                this.uFR = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(248033);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a<x> aVar = this.uFR.uFO;
                if (aVar != null) {
                    aVar.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248033);
            }
        });
        djy();
        this.uFK = (a) j.kt(this.uFJ);
        RecyclerView recyclerView = this.uFH;
        p.g(recyclerView, "list");
        recyclerView.setAdapter(this.uFI);
        RecyclerView recyclerView2 = this.uFH;
        p.g(recyclerView2, "list");
        this.uFP.getContext();
        recyclerView2.setLayoutManager(new LinearLayoutManager(0, false));
        this.oyP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.d.AnonymousClass3 */
            final /* synthetic */ d uFR;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.uFR = r1;
            }

            public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                Integer num;
                Integer num2;
                HashMap<Integer, Integer> hashMap;
                HashMap<Integer, Integer> hashMap2;
                HashMap<Integer, Integer> hashMap3;
                AppMethodBeat.i(248034);
                String str = this.uFR.TAG;
                StringBuilder sb = new StringBuilder("curSelectedBeauty:");
                a aVar = this.uFR.uFK;
                Log.i(str, sb.append(aVar != null ? Integer.valueOf(aVar.key) : null).append(", onProgressChanged:").append(i2).append(", fromUser:").append(z).append(", maxTranslationX:").append(this.uFR.uFN).toString());
                a aVar2 = this.uFR.uFK;
                if (aVar2 != null) {
                    if (seekBar != null) {
                        d.a(this.uFR, i2);
                        o oVar = o.ujN;
                        com.tencent.mm.live.core.b.a aGk = o.aGk();
                        if (!(aGk == null || (hashMap3 = aGk.hDh) == null)) {
                            hashMap3.put(Integer.valueOf(aVar2.key), Integer.valueOf(i2));
                        }
                        com.tencent.mm.live.core.core.trtc.a aVar3 = this.uFR.hSS;
                        if (aVar3 != null) {
                            o oVar2 = o.ujN;
                            aVar3.hAr.a(o.aGk());
                        }
                        o oVar3 = o.ujN;
                        com.tencent.mm.live.core.b.a dfV = o.dfV();
                        if (dfV == null || (hashMap2 = dfV.hDh) == null || (num = hashMap2.get(Integer.valueOf(aVar2.key))) == null) {
                            num = 0;
                        }
                        p.g(num, "FinderLiveService.defaul…nfigMap?.get(it.key) ?: 0");
                        int intValue = num.intValue();
                        o oVar4 = o.ujN;
                        com.tencent.mm.live.core.b.a aGk2 = o.aGk();
                        if (aGk2 == null || (hashMap = aGk2.hDh) == null || (num2 = hashMap.get(Integer.valueOf(aVar2.key))) == null) {
                            num2 = 0;
                        }
                        p.g(num2, "FinderLiveService.beauty…nfigMap?.get(it.key) ?: 0");
                        int intValue2 = num2.intValue();
                        if (z) {
                            ImageView imageView = this.uFR.uFG;
                            p.g(imageView, "seekBarDefaultIcon");
                            if (imageView.getVisibility() == 0 && intValue == intValue2) {
                                d dVar = this.uFR;
                                if (dVar.hQn instanceof Vibrator) {
                                    ((Vibrator) dVar.hQn).vibrate(10);
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(248034);
                    return;
                }
                AppMethodBeat.o(248034);
            }

            public final void onStartTrackingTouch(SeekBar seekBar) {
            }

            public final void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.uFL = new kotlin.g.a.b<a, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.d.AnonymousClass4 */
            final /* synthetic */ d uFR;

            {
                this.uFR = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(a aVar) {
                AppMethodBeat.i(248035);
                a aVar2 = aVar;
                p.h(aVar2, LocaleUtil.ITALIAN);
                this.uFR.uFK = aVar2;
                this.uFR.djx();
                x xVar = x.SXb;
                AppMethodBeat.o(248035);
                return xVar;
            }
        };
        djx();
        AppMethodBeat.o(248055);
    }

    /* access modifiers changed from: package-private */
    public final void djw() {
        Integer num;
        HashMap<Integer, Integer> hashMap;
        AppMethodBeat.i(248051);
        a aVar = this.uFK;
        if (aVar != null) {
            o oVar = o.ujN;
            com.tencent.mm.live.core.b.a dfV = o.dfV();
            if (dfV == null || (hashMap = dfV.hDh) == null || (num = hashMap.get(Integer.valueOf(aVar.key))) == null) {
                num = 0;
            }
            p.g(num, "FinderLiveService.defaul…nfigMap?.get(it.key) ?: 0");
            int intValue = num.intValue();
            SeekBar seekBar = this.oyP;
            p.g(seekBar, "seekBar");
            float max = ((float) intValue) / ((float) seekBar.getMax());
            SeekBar seekBar2 = this.oyP;
            p.g(seekBar2, "seekBar");
            int measuredWidth = seekBar2.getMeasuredWidth();
            SeekBar seekBar3 = this.oyP;
            p.g(seekBar3, "seekBar");
            int paddingStart = measuredWidth - seekBar3.getPaddingStart();
            SeekBar seekBar4 = this.oyP;
            p.g(seekBar4, "seekBar");
            float paddingEnd = max * ((float) (paddingStart - seekBar4.getPaddingEnd()));
            Log.i(this.TAG, "moveProgressIndicator progress:" + intValue + " translationX:" + paddingEnd);
            ImageView imageView = this.uFG;
            p.g(imageView, "seekBarDefaultIcon");
            imageView.setTranslationX(kotlin.k.j.aJ(paddingEnd, (float) this.uFN));
            AppMethodBeat.o(248051);
            return;
        }
        AppMethodBeat.o(248051);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void djx() {
        /*
        // Method dump skipped, instructions count: 220
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.widget.d.djx():void");
    }

    private final void djy() {
        String str;
        AppMethodBeat.i(248053);
        e.c cVar = e.c.hxm;
        int aCn = e.c.aCn();
        for (int i2 = 0; i2 < aCn; i2++) {
            e.c cVar2 = e.c.hxm;
            if (i2 == e.c.aCh()) {
                Context context = this.uFP.getContext();
                p.g(context, "beautyPanelRoot.context");
                str = context.getResources().getString(R.string.crb);
            } else {
                e.c cVar3 = e.c.hxm;
                if (i2 == e.c.aCi()) {
                    Context context2 = this.uFP.getContext();
                    p.g(context2, "beautyPanelRoot.context");
                    str = context2.getResources().getString(R.string.cr_);
                } else {
                    e.c cVar4 = e.c.hxm;
                    if (i2 == e.c.aCl()) {
                        Context context3 = this.uFP.getContext();
                        p.g(context3, "beautyPanelRoot.context");
                        str = context3.getResources().getString(R.string.cr9);
                    } else {
                        e.c cVar5 = e.c.hxm;
                        if (i2 == e.c.aCj()) {
                            Context context4 = this.uFP.getContext();
                            p.g(context4, "beautyPanelRoot.context");
                            str = context4.getResources().getString(R.string.cr8);
                        } else {
                            e.c cVar6 = e.c.hxm;
                            if (i2 == e.c.aCm()) {
                                Context context5 = this.uFP.getContext();
                                p.g(context5, "beautyPanelRoot.context");
                                str = context5.getResources().getString(R.string.cr7);
                            } else {
                                e.c cVar7 = e.c.hxm;
                                if (i2 == e.c.aCk()) {
                                    Context context6 = this.uFP.getContext();
                                    p.g(context6, "beautyPanelRoot.context");
                                    str = context6.getResources().getString(R.string.cra);
                                } else {
                                    str = "";
                                }
                            }
                        }
                    }
                }
            }
            p.g(str, "when(i) {\n              …          }\n            }");
            this.uFJ.add(new a(i2, str));
        }
        j.c((List) this.uFJ, (kotlin.g.a.b) e.uFV);
        AppMethodBeat.o(248053);
    }

    public final void djz() {
        AppMethodBeat.i(248054);
        com.tencent.mm.ac.d.h(new f(this));
        AppMethodBeat.o(248054);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget$BeautyInfo;", "", "key", "", "title", "", "(ILjava/lang/String;)V", "getKey", "()I", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-finder_release"})
    public static final class a {
        final int key;
        final String title;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (kotlin.g.b.p.j(r3.title, r4.title) != false) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 248039(0x3c8e7, float:3.47577E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.live.widget.d.a
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.finder.live.widget.d$a r4 = (com.tencent.mm.plugin.finder.live.widget.d.a) r4
                int r0 = r3.key
                int r1 = r4.key
                if (r0 != r1) goto L_0x0023
                java.lang.String r0 = r3.title
                java.lang.String r1 = r4.title
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
            L_0x001e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0022:
                return r0
            L_0x0023:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.widget.d.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(248038);
            int i2 = this.key * 31;
            String str = this.title;
            int hashCode = (str != null ? str.hashCode() : 0) + i2;
            AppMethodBeat.o(248038);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(248037);
            String str = "BeautyInfo(key=" + this.key + ", title=" + this.title + ")";
            AppMethodBeat.o(248037);
            return str;
        }

        public a(int i2, String str) {
            p.h(str, "title");
            AppMethodBeat.i(248036);
            this.key = i2;
            this.title = str;
            AppMethodBeat.o(248036);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u001c\u0010\u000b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget$CameraOptBeautyAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget$CameraOptBeautyViewHolder;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget;", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "plugin-finder_release"})
    public final class b extends RecyclerView.a<c> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ c a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(248041);
            p.h(viewGroup, "parent");
            d dVar = d.this;
            View inflate = View.inflate(viewGroup.getContext(), R.layout.ada, null);
            p.g(inflate, "View.inflate(parent.cont…ra_opt_beauty_item, null)");
            c cVar = new c(dVar, inflate);
            AppMethodBeat.o(248041);
            return cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(c cVar, int i2) {
            boolean z;
            AppMethodBeat.i(248043);
            c cVar2 = cVar;
            p.h(cVar2, "holder");
            if (i2 == 0) {
                View view = cVar2.aus;
                View view2 = cVar2.aus;
                p.g(view2, "holder.itemView");
                int fromDPToPix = at.fromDPToPix(view2.getContext(), 32);
                View view3 = cVar2.aus;
                p.g(view3, "holder.itemView");
                int paddingTop = view3.getPaddingTop();
                View view4 = cVar2.aus;
                p.g(view4, "holder.itemView");
                int paddingRight = view4.getPaddingRight();
                View view5 = cVar2.aus;
                p.g(view5, "holder.itemView");
                view.setPadding(fromDPToPix, paddingTop, paddingRight, view5.getPaddingBottom());
            } else {
                View view6 = cVar2.aus;
                View view7 = cVar2.aus;
                p.g(view7, "holder.itemView");
                int paddingTop2 = view7.getPaddingTop();
                View view8 = cVar2.aus;
                p.g(view8, "holder.itemView");
                int paddingRight2 = view8.getPaddingRight();
                View view9 = cVar2.aus;
                p.g(view9, "holder.itemView");
                view6.setPadding(0, paddingTop2, paddingRight2, view9.getPaddingBottom());
            }
            TextView textView = cVar2.hbb;
            p.g(textView, "holder.title");
            textView.setText(d.this.uFJ.get(i2).title);
            TextView textView2 = cVar2.hbb;
            p.g(textView2, "holder.title");
            a aVar = d.this.uFK;
            if (aVar == null || aVar.key != d.this.uFJ.get(i2).key) {
                z = false;
            } else {
                z = true;
            }
            textView2.setActivated(z);
            a aVar2 = d.this.uFK;
            if (aVar2 != null && aVar2.key == d.this.uFJ.get(i2).key) {
                d.this.uFM = cVar2.hbb;
            }
            cVar2.hbb.setOnClickListener(new a(this, i2));
            AppMethodBeat.o(248043);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(248042);
            int size = d.this.uFJ.size();
            AppMethodBeat.o(248042);
            return size;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ b uFS;

            a(b bVar, int i2) {
                this.uFS = bVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(248040);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget$CameraOptBeautyAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a aVar = (a) j.L(d.this.uFJ, this.gUj);
                if (aVar != null) {
                    View view2 = d.this.uFM;
                    if (view2 != null) {
                        view2.setActivated(false);
                    }
                    d.this.uFM = view;
                    View view3 = d.this.uFM;
                    if (view3 != null) {
                        view3.setActivated(true);
                    }
                    kotlin.g.a.b<a, x> bVar2 = d.this.uFL;
                    if (bVar2 != null) {
                        bVar2.invoke(aVar);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget$CameraOptBeautyAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248040);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget$CameraOptBeautyViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget;Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTitle", "()Landroid/widget/TextView;", "plugin-finder_release"})
    public final class c extends RecyclerView.v {
        final TextView hbb;
        final /* synthetic */ d uFR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d dVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.uFR = dVar;
            AppMethodBeat.i(248044);
            this.hbb = (TextView) view.findViewById(R.id.cot);
            AppMethodBeat.o(248044);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d uFR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(d dVar) {
            super(0);
            this.uFR = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(248050);
            this.uFR.uFP.animate().translationY(0.0f).setDuration(200).setListener(null).start();
            if (this.uFR.uFN == 0) {
                this.uFR.uFP.post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.finder.live.widget.d.f.AnonymousClass1 */
                    final /* synthetic */ f uFW;

                    {
                        this.uFW = r1;
                    }

                    public final void run() {
                        Integer num;
                        HashMap<Integer, Integer> hashMap;
                        AppMethodBeat.i(248049);
                        String str = this.uFW.uFR.TAG;
                        StringBuilder sb = new StringBuilder("seekBar.width:");
                        SeekBar seekBar = this.uFW.uFR.oyP;
                        p.g(seekBar, "seekBar");
                        StringBuilder append = sb.append(seekBar.getWidth()).append(" seekBar.measuredWidth:");
                        SeekBar seekBar2 = this.uFW.uFR.oyP;
                        p.g(seekBar2, "seekBar");
                        StringBuilder append2 = append.append(seekBar2.getMeasuredWidth()).append(" seekBarTv.width:");
                        TextView textView = this.uFW.uFR.uFF;
                        p.g(textView, "seekBarTv");
                        Log.i(str, append2.append(textView.getWidth()).toString());
                        d dVar = this.uFW.uFR;
                        SeekBar seekBar3 = this.uFW.uFR.oyP;
                        p.g(seekBar3, "seekBar");
                        int width = seekBar3.getWidth();
                        TextView textView2 = this.uFW.uFR.uFF;
                        p.g(textView2, "seekBarTv");
                        dVar.uFN = width - textView2.getWidth();
                        a aVar = this.uFW.uFR.uFK;
                        if (aVar != null) {
                            o oVar = o.ujN;
                            com.tencent.mm.live.core.b.a aGk = o.aGk();
                            if (aGk == null || (hashMap = aGk.hDh) == null || (num = hashMap.get(Integer.valueOf(aVar.key))) == null) {
                                num = 0;
                            }
                            p.g(num, "FinderLiveService.beauty…nfigMap?.get(it.key) ?: 0");
                            d.a(this.uFW.uFR, num.intValue());
                            this.uFW.uFR.djw();
                            AppMethodBeat.o(248049);
                            return;
                        }
                        AppMethodBeat.o(248049);
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(248050);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.live.widget.d$d  reason: collision with other inner class name */
    public static final class C1206d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d uFR;
        final /* synthetic */ kotlin.g.a.a uFT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1206d(d dVar, kotlin.g.a.a aVar) {
            super(0);
            this.uFR = dVar;
            this.uFT = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(248046);
            this.uFR.uFP.animate().translationY((float) au.az(this.uFR.uFP.getContext()).y).setDuration(200).setListener(new AnimatorListenerAdapter(this) {
                /* class com.tencent.mm.plugin.finder.live.widget.d.C1206d.AnonymousClass1 */
                final /* synthetic */ C1206d uFU;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.uFU = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(248045);
                    kotlin.g.a.a aVar = this.uFU.uFT;
                    if (aVar != null) {
                        aVar.invoke();
                        AppMethodBeat.o(248045);
                        return;
                    }
                    AppMethodBeat.o(248045);
                }
            }).start();
            x xVar = x.SXb;
            AppMethodBeat.o(248046);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(d dVar, int i2) {
        AppMethodBeat.i(248056);
        SeekBar seekBar = dVar.oyP;
        p.g(seekBar, "seekBar");
        float max = ((float) i2) / ((float) seekBar.getMax());
        SeekBar seekBar2 = dVar.oyP;
        p.g(seekBar2, "seekBar");
        int measuredWidth = seekBar2.getMeasuredWidth();
        SeekBar seekBar3 = dVar.oyP;
        p.g(seekBar3, "seekBar");
        int paddingStart = measuredWidth - seekBar3.getPaddingStart();
        SeekBar seekBar4 = dVar.oyP;
        p.g(seekBar4, "seekBar");
        float paddingEnd = ((float) (paddingStart - seekBar4.getPaddingEnd())) * max;
        Log.i(dVar.TAG, "moveProgressIndicator progress:" + i2 + " translationX:" + paddingEnd);
        TextView textView = dVar.uFF;
        p.g(textView, "seekBarTv");
        textView.setText(i2 <= 0 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "+".concat(String.valueOf(i2)));
        TextView textView2 = dVar.uFF;
        p.g(textView2, "seekBarTv");
        textView2.setTranslationX(kotlin.k.j.aJ(paddingEnd, (float) dVar.uFN));
        AppMethodBeat.o(248056);
    }
}
