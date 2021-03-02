package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.q;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.minusscreen.a;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0004J.\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0004H\u0002J\u001c\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030)H\u0016J@\u0010*\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100H\u0016J \u00102\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u0004H\u0016J\b\u00103\u001a\u00020.H\u0016R\u0014\u0010\b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "layoutResId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(ILcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "MAX_NAME_COUNT", "getMAX_NAME_COUNT", "()I", "TAG", "", "thumbLoaderOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getThumbLoaderOption", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getLayoutId", "getNickName", "context", "Landroid/content/Context;", "item", "getTimeShowString", "time", "loadImage", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "imgView", "Landroid/widget/ImageView;", "defaultImgView", "defaultBgContainer", "Landroid/view/View;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "makeTimeString", "d", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "useBottomGradient", "ui-multitask_release"})
public abstract class d extends e<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> {
    final com.tencent.mm.loader.c.e Aer;
    com.tencent.mm.plugin.multitask.ui.minusscreen.d.a Aes;
    final String TAG;
    private final int tDB = R.layout.b7a;
    final int tDx;

    public d(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a aVar) {
        this.Aes = aVar;
        this.TAG = "MicroMsg.MultiTask.MinusScreenRoundCornerConvert";
        e.a aVar2 = new e.a();
        aVar2.hZJ = true;
        aVar2.hZI = true;
        this.Aer = aVar2.aJT();
        this.tDx = 5;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar, int i2, int i3, boolean z, List list) {
        a(hVar, aVar, i2, i3, z, (List<Object>) list);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return this.tDB;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public void a(RecyclerView recyclerView, h hVar, int i2) {
        View findViewById;
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        RecyclerView.a adapter = recyclerView.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        Log.i(this.TAG, "onCreateViewHolder itemCount:" + itemCount + ", layoutPosition:" + hVar.lQ());
        if (itemCount == 2) {
            View findViewById2 = hVar.aus.findViewById(R.id.e24);
            if (findViewById2 != null) {
                MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
                findViewById2.setTranslationX((float) MultiTaskUIC.Agf);
                MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
                findViewById2.setTranslationY((float) MultiTaskUIC.Age);
                ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
                MultiTaskUIC.a aVar3 = MultiTaskUIC.Ago;
                layoutParams.height = MultiTaskUIC.AfZ;
                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                MultiTaskUIC.a aVar4 = MultiTaskUIC.Ago;
                layoutParams2.width = MultiTaskUIC.AfY;
                RoundedCornerFrameLayout roundedCornerFrameLayout = (RoundedCornerFrameLayout) hVar.aus.findViewById(R.id.fnq);
                if (roundedCornerFrameLayout != null) {
                    ViewGroup.LayoutParams layoutParams3 = roundedCornerFrameLayout.getLayoutParams();
                    MultiTaskUIC.a aVar5 = MultiTaskUIC.Ago;
                    layoutParams3.height = MultiTaskUIC.Agd;
                }
                findViewById2.requestLayout();
            }
        } else if (itemCount == 3) {
            View findViewById3 = hVar.aus.findViewById(R.id.e24);
            if (findViewById3 != null) {
                MultiTaskUIC.a aVar6 = MultiTaskUIC.Ago;
                findViewById3.setTranslationY((float) MultiTaskUIC.Agh);
                ViewGroup.LayoutParams layoutParams4 = findViewById3.getLayoutParams();
                MultiTaskUIC.a aVar7 = MultiTaskUIC.Ago;
                layoutParams4.height = MultiTaskUIC.kn;
                ViewGroup.LayoutParams layoutParams5 = findViewById3.getLayoutParams();
                MultiTaskUIC.a aVar8 = MultiTaskUIC.Ago;
                layoutParams5.width = MultiTaskUIC.qmd;
                RoundedCornerFrameLayout roundedCornerFrameLayout2 = (RoundedCornerFrameLayout) hVar.aus.findViewById(R.id.fnq);
                if (roundedCornerFrameLayout2 != null) {
                    ViewGroup.LayoutParams layoutParams6 = roundedCornerFrameLayout2.getLayoutParams();
                    MultiTaskUIC.a aVar9 = MultiTaskUIC.Ago;
                    layoutParams6.height = MultiTaskUIC.Agb;
                }
                findViewById3.requestLayout();
            }
        } else if (itemCount >= 4 && (findViewById = hVar.aus.findViewById(R.id.e24)) != null) {
            ViewGroup.LayoutParams layoutParams7 = findViewById.getLayoutParams();
            MultiTaskUIC.a aVar10 = MultiTaskUIC.Ago;
            layoutParams7.height = MultiTaskUIC.kn;
            ViewGroup.LayoutParams layoutParams8 = findViewById.getLayoutParams();
            MultiTaskUIC.a aVar11 = MultiTaskUIC.Ago;
            layoutParams8.width = MultiTaskUIC.qmd;
            RoundedCornerFrameLayout roundedCornerFrameLayout3 = (RoundedCornerFrameLayout) hVar.aus.findViewById(R.id.fnq);
            if (roundedCornerFrameLayout3 != null) {
                ViewGroup.LayoutParams layoutParams9 = roundedCornerFrameLayout3.getLayoutParams();
                MultiTaskUIC.a aVar12 = MultiTaskUIC.Ago;
                layoutParams9.height = MultiTaskUIC.Agb;
            }
            findViewById.requestLayout();
        }
    }

    public void a(h hVar, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar, int i2, int i3, boolean z, List<Object> list) {
        p.h(hVar, "holder");
        p.h(aVar, "item");
        Log.d(this.TAG, "onBindViewHolder, position:".concat(String.valueOf(i2)));
        View findViewById = hVar.aus.findViewById(R.id.fnz);
        TextView textView = (TextView) hVar.aus.findViewById(R.id.fnw);
        TextView textView2 = (TextView) hVar.aus.findViewById(R.id.fny);
        MMImageView mMImageView = (MMImageView) hVar.aus.findViewById(R.id.fo1);
        MinusScreenRoundFrameLayout minusScreenRoundFrameLayout = (MinusScreenRoundFrameLayout) hVar.aus.findViewById(R.id.fnn);
        TextView textView3 = (TextView) hVar.aus.findViewById(R.id.fnx);
        RoundedCornerFrameLayout roundedCornerFrameLayout = (RoundedCornerFrameLayout) hVar.aus.findViewById(R.id.fnq);
        WeImageView weImageView = (WeImageView) hVar.aus.findViewById(R.id.fnt);
        ImageView imageView = (ImageView) hVar.Mn(R.id.fns);
        if (imageView != null) {
            imageView.setOnClickListener(new b(this, aVar, hVar));
        }
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        textView.setText(a(context, aVar));
        if (Util.isNullOrNil(aVar.Aen.erh().title)) {
            p.g(textView2, "title");
            textView2.setVisibility(8);
            p.g(findViewById, "tagContainerView");
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams == null) {
                throw new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = at.fromDPToPix(hVar.getContext(), 16);
            findViewById.setLayoutParams(marginLayoutParams);
        } else {
            p.g(textView2, "title");
            textView2.setVisibility(0);
            textView2.setText(aVar.Aen.erh().title);
            p.g(findViewById, "tagContainerView");
            ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
            if (layoutParams2 == null) {
                throw new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams2.topMargin = at.fromDPToPix(hVar.getContext(), 6);
            findViewById.setLayoutParams(marginLayoutParams2);
        }
        if (!Util.isNullOrNil(aVar.Aen.erh().tag)) {
            textView3.setText(aVar.Aen.erh().tag);
            p.g(textView3, "tagView");
            textView3.setVisibility(0);
        } else {
            p.g(textView3, "tagView");
            textView3.setVisibility(8);
        }
        minusScreenRoundFrameLayout.setUseBottomGradient(erF());
        if (aVar.Aen.erh().MwT) {
            p.g(weImageView, "defaultBgView");
            weImageView.setVisibility(0);
            p.g(mMImageView, "imgView");
            mMImageView.setVisibility(8);
            Context context2 = hVar.getContext();
            p.g(context2, "holder.context");
            roundedCornerFrameLayout.setBackgroundColor(context2.getResources().getColor(R.color.a1j));
            com.tencent.mm.plugin.multitask.ui.minusscreen.e.a aVar2 = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.Aep;
            weImageView.setImageResource(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.RR(aVar.Aen.field_type));
            com.tencent.mm.plugin.multitask.h hVar2 = com.tencent.mm.plugin.multitask.h.zZn;
            q.bcV().a(com.tencent.mm.plugin.multitask.h.g(aVar.Aen), mMImageView);
            return;
        }
        p.g(weImageView, "defaultBgView");
        weImageView.setVisibility(8);
        p.g(mMImageView, "imgView");
        mMImageView.setVisibility(0);
        roundedCornerFrameLayout.setBackgroundColor(0);
        MultiTaskInfo multiTaskInfo = aVar.Aen;
        MMImageView mMImageView2 = mMImageView;
        WeImageView weImageView2 = weImageView;
        p.g(roundedCornerFrameLayout, "defaultBgContainer");
        RoundedCornerFrameLayout roundedCornerFrameLayout2 = roundedCornerFrameLayout;
        p.h(multiTaskInfo, "multiTaskInfo");
        p.h(mMImageView2, "imgView");
        p.h(weImageView2, "defaultImgView");
        p.h(roundedCornerFrameLayout2, "defaultBgContainer");
        p.h(hVar, "holder");
        com.tencent.mm.plugin.multitask.h hVar3 = com.tencent.mm.plugin.multitask.h.zZn;
        String g2 = com.tencent.mm.plugin.multitask.h.g(multiTaskInfo);
        com.tencent.mm.av.a.a bcV = q.bcV();
        com.tencent.mm.plugin.multitask.h hVar4 = com.tencent.mm.plugin.multitask.h.zZn;
        bcV.a(g2, mMImageView2, com.tencent.mm.plugin.multitask.h.eqz(), new a(this, hVar, g2, mMImageView2, multiTaskInfo, weImageView2, roundedCornerFrameLayout2));
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ d Aet;
        final /* synthetic */ com.tencent.mm.plugin.multitask.ui.minusscreen.b.a Aez;
        final /* synthetic */ h qhp;

        b(d dVar, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar, h hVar) {
            this.Aet = dVar;
            this.Aez = aVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(236527);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.multitask.ui.minusscreen.d.a aVar = this.Aet.Aes;
            if (aVar != null) {
                aVar.a(this.Aez, this.qhp);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(236527);
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public void a(RecyclerView recyclerView, WxRecyclerAdapter<?> wxRecyclerAdapter) {
        p.h(recyclerView, "recyclerView");
        p.h(wxRecyclerAdapter, "adapter");
        super.a(recyclerView, wxRecyclerAdapter);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\tH\n¢\u0006\u0004\b\u000b\u0010\f"}, hxF = {"<anonymous>", "", "url", "", "view", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "extraObj", "", "", "onImageLoadComplete", "(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;[Ljava/lang/Object;)V"})
    public static final class a implements k {
        final /* synthetic */ d Aet;
        final /* synthetic */ String Aeu;
        final /* synthetic */ ImageView Aev;
        final /* synthetic */ View Aew;
        final /* synthetic */ h qhp;
        final /* synthetic */ MultiTaskInfo uLz;
        final /* synthetic */ ImageView xmv;

        a(d dVar, h hVar, String str, ImageView imageView, MultiTaskInfo multiTaskInfo, ImageView imageView2, View view) {
            this.Aet = dVar;
            this.qhp = hVar;
            this.Aeu = str;
            this.xmv = imageView;
            this.uLz = multiTaskInfo;
            this.Aev = imageView2;
            this.Aew = view;
        }

        @Override // com.tencent.mm.av.a.c.k
        public final void a(String str, View view, Bitmap bitmap, Object[] objArr) {
            View view2;
            x xVar = null;
            AppMethodBeat.i(236526);
            if (!(view instanceof ImageView)) {
                view2 = null;
            } else {
                view2 = view;
            }
            ImageView imageView = (ImageView) view2;
            if (!(imageView == null || bitmap == null)) {
                Log.i(this.Aet.TAG, "loadImage callback " + imageView.hashCode() + ' ' + bitmap);
                RecyclerView recyclerView = this.qhp.getRecyclerView();
                RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
                if (layoutManager instanceof GridLayoutManager) {
                    xVar = layoutManager;
                }
                GridLayoutManager gridLayoutManager = (GridLayoutManager) xVar;
                int ki = gridLayoutManager != null ? gridLayoutManager.ki() : 1;
                a.C1525a aVar = com.tencent.mm.plugin.multitask.ui.minusscreen.a.AdH;
                float deviceWidth = ((float) (ao.getDeviceWidth() - (a.C1525a.erB() * (ki + 1)))) / (((float) ki) * ((float) bitmap.getWidth()));
                Matrix matrix = new Matrix();
                matrix.setScale(deviceWidth, deviceWidth);
                com.tencent.mm.ac.d.h(new b(imageView, matrix, bitmap));
                xVar = x.SXb;
            }
            if (xVar == null) {
                q.bcV().a(this.Aeu, this.xmv);
                com.tencent.mm.ac.d.h(new C1528a(this));
                x xVar2 = x.SXb;
            }
            AppMethodBeat.o(236526);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ Matrix Aey;
            final /* synthetic */ Bitmap cKG;
            final /* synthetic */ ImageView xmv;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(ImageView imageView, Matrix matrix, Bitmap bitmap) {
                super(0);
                this.xmv = imageView;
                this.Aey = matrix;
                this.cKG = bitmap;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(236525);
                this.xmv.setImageMatrix(this.Aey);
                this.xmv.setImageBitmap(this.cKG);
                x xVar = x.SXb;
                AppMethodBeat.o(236525);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert$loadImage$1$2$1"})
        /* renamed from: com.tencent.mm.plugin.multitask.ui.minusscreen.view.d$a$a  reason: collision with other inner class name */
        static final class C1528a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ a Aex;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1528a(a aVar) {
                super(0);
                this.Aex = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(236524);
                this.Aex.uLz.erh().MwT = true;
                this.Aex.Aev.setVisibility(0);
                this.Aex.xmv.setVisibility(8);
                View view = this.Aex.Aew;
                Context context = this.Aex.qhp.getContext();
                p.g(context, "holder.context");
                view.setBackgroundColor(context.getResources().getColor(R.color.a1j));
                ImageView imageView = this.Aex.Aev;
                com.tencent.mm.plugin.multitask.ui.minusscreen.e.a aVar = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.Aep;
                imageView.setImageResource(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.RR(this.Aex.uLz.field_type));
                x xVar = x.SXb;
                AppMethodBeat.o(236524);
                return xVar;
            }
        }
    }

    public boolean erF() {
        return false;
    }

    static String xt(int i2) {
        if (i2 < 10) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i2));
        }
        return String.valueOf(i2);
    }

    public String a(Context context, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar) {
        p.h(context, "context");
        p.h(aVar, "item");
        return aVar.Aen.erh().nickname;
    }
}
