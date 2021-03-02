package com.tencent.mm.plugin.finder.activity.uic;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0001-B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0007J\u0012\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002J(\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)H\u0002J\u0012\u0010*\u001a\u00020\u00162\b\b\u0001\u0010+\u001a\u00020\u0019H\u0002J\b\u0010,\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "activityDescText", "Landroid/widget/TextView;", "activityNameText", "avatarImage", "Landroid/widget/ImageView;", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "coverImageView", "coverMaskContainer", "Landroid/view/ViewGroup;", "coverMaskImageView", "descTextContent", "", "exitActivityBtn", "nickNameText", "title", "adjustCoverImageView", "", "adjustCoverMaskImageView", "getAvailableDescWidth", "", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setCover", "coverUrl", "setCoverMaskMargin", "setCoverStyle", "setNormalStyle", "setSuffixedDesc", "descText", "maxLineNum", "textView", "isCovered", "", "setTextColors", "color", "showBottomSheet", "Companion", "plugin-finder_release"})
public final class FinderActivityDescUIC extends UIComponent {
    public static final a tqX = new a((byte) 0);
    public ViewGroup UGZ;
    public String UHa = "";
    public ImageView cxe;
    public WeImageView hPV;
    public TextView hbb;
    public ImageView tqQ;
    public ImageView tqR;
    public TextView tqS;
    public TextView tqT;
    public TextView tqU;
    public TextView tqV;

    static {
        AppMethodBeat.i(242062);
        AppMethodBeat.o(242062);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    public static final class e<T, R> implements com.tencent.mm.loader.f.e<o, Bitmap> {
        final /* synthetic */ FinderActivityDescUIC tqY;
        final /* synthetic */ String tra;

        public e(FinderActivityDescUIC finderActivityDescUIC, String str) {
            this.tqY = finderActivityDescUIC;
            this.tra = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<o> aVar, g gVar, Bitmap bitmap) {
            AppMethodBeat.i(242058);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                com.tencent.mm.ac.d.h(new a(this));
                Log.i("Finder.ActivityDescUIC", "[handleActivityProfileCover] [" + bitmap2.getWidth() + ':' + bitmap2.getHeight() + "] allocationByteCount=" + Util.getSizeKB((long) bitmap2.getAllocationByteCount()) + " coverUrl=" + this.tra);
                AppMethodBeat.o(242058);
                return;
            }
            AppMethodBeat.o(242058);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$setCover$1$1$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ e trb;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(e eVar) {
                super(0);
                this.trb = eVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(242057);
                FinderActivityDescUIC.a(this.trb.tqY).setVisibility(0);
                x xVar = x.SXb;
                AppMethodBeat.o(242057);
                return xVar;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderActivityDescUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(242061);
        AppMethodBeat.o(242061);
    }

    public static final /* synthetic */ ImageView a(FinderActivityDescUIC finderActivityDescUIC) {
        AppMethodBeat.i(242063);
        ImageView imageView = finderActivityDescUIC.cxe;
        if (imageView == null) {
            p.btv("coverImageView");
        }
        AppMethodBeat.o(242063);
        return imageView;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$Companion;", "", "()V", "FIX_RATIO", "", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(242059);
        super.onCreate(bundle);
        AppMethodBeat.o(242059);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.a96;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        public static final c tqZ = new c();

        static {
            AppMethodBeat.i(242055);
            AppMethodBeat.o(242055);
        }

        c() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242054);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242054);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ FinderActivityDescUIC tqY;

        public d(FinderActivityDescUIC finderActivityDescUIC) {
            this.tqY = finderActivityDescUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242056);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.tqY.getActivity().isFinishing()) {
                this.tqY.getActivity().finish();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242056);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ FinderActivityDescUIC tqY;

        public b(FinderActivityDescUIC finderActivityDescUIC) {
            this.tqY = finderActivityDescUIC;
        }

        public final void run() {
            AppMethodBeat.i(242053);
            ViewGroup.LayoutParams layoutParams = FinderActivityDescUIC.a(this.tqY).getLayoutParams();
            layoutParams.height = (int) (((float) FinderActivityDescUIC.a(this.tqY).getWidth()) * 1.3333334f);
            FinderActivityDescUIC.a(this.tqY).setLayoutParams(layoutParams);
            AppMethodBeat.o(242053);
        }
    }

    public final void Ii(int i2) {
        AppMethodBeat.i(242060);
        TextView textView = this.tqS;
        if (textView == null) {
            p.btv("nickNameText");
        }
        textView.setTextColor(i2);
        WeImageView weImageView = this.hPV;
        if (weImageView == null) {
            p.btv("backBtn");
        }
        weImageView.setIconColor(i2);
        TextView textView2 = this.hbb;
        if (textView2 == null) {
            p.btv("title");
        }
        textView2.setTextColor(i2);
        AppMethodBeat.o(242060);
    }
}
