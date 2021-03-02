package com.tencent.mm.plugin.finder.activity.uic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r*\u0001\u0016\u0018\u0000 <2\u00020\u0001:\u0001<B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u0006H\u0002J\u0012\u0010.\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020*H\u0016J\u0010\u00102\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u0010J\u0010\u00104\u001a\u00020*2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020'H\u0002J \u00107\u001a\u00020*2\u0006\u0010\f\u001a\u00020\u00062\u0006\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020\u001dH\u0002J\b\u0010:\u001a\u00020*H\u0002J\b\u0010;\u001a\u00020*H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/ui/MMFragmentActivity;)V", "activityDesc", "", "activityEventId", "", "activityName", "avatarUrl", "coverUrl", "descText", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "finderTopicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getFinderTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setFinderTopicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$finderTopicInfoListener$1;", "fromObjectId", "headerAvatarView", "Landroid/widget/ImageView;", "headerCoverView", "headerDescTextView", "Landroid/widget/TextView;", "headerNameTextView", "headerParticipateTextView", "headerTitleTextView", "headerView", "Landroid/view/View;", "nickName", "participateBtn", "Landroid/widget/LinearLayout;", "participateCount", "", "getAvailableDescWidth", "initParam", "", "initView", "loadAvatar", "url", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "refreshHeader", "topicInfo", "setCover", "setParticipateText", "count", "setSuffixedDesc", "maxLineNum", "textView", "setView", "showBottomSheet", "Companion", "plugin-finder_release"})
public final class FinderActivityHeaderUIC extends UIComponent {
    public static final a trq = new a((byte) 0);
    String activityName = "";
    String coverUrl = "";
    private View kgo;
    String kog = "";
    String nickName = "";
    private ImageView tqi;
    private aqk tqo;
    private TextView trd;
    private TextView tre;
    private ImageView trf;
    private TextView trg;
    private TextView trh;
    private LinearLayout tri;
    private String trj = "";
    String trk = "";
    int trl;
    long trm;
    long trn;
    bds tro;
    private final b trp = new b(this);

    static {
        AppMethodBeat.i(242085);
        AppMethodBeat.o(242085);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    public static final class d<T, R> implements com.tencent.mm.loader.f.e<o, Bitmap> {
        final /* synthetic */ String tra;
        final /* synthetic */ FinderActivityHeaderUIC trr;

        d(FinderActivityHeaderUIC finderActivityHeaderUIC, String str) {
            this.trr = finderActivityHeaderUIC;
            this.tra = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<o> aVar, g gVar, Bitmap bitmap) {
            AppMethodBeat.i(242072);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                com.tencent.mm.ac.d.h(new a(this));
                Log.i("SimpleUIComponent", "[handleActivityProfileCover] [" + bitmap2.getWidth() + ':' + bitmap2.getHeight() + "] allocationByteCount=" + Util.getSizeKB((long) bitmap2.getAllocationByteCount()) + " coverUrl=" + this.tra);
                AppMethodBeat.o(242072);
                return;
            }
            AppMethodBeat.o(242072);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$setCover$1$1$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ d trt;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar) {
                super(0);
                this.trt = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(242071);
                FinderActivityHeaderUIC.a(this.trt.trr).setVisibility(0);
                x xVar = x.SXb;
                AppMethodBeat.o(242071);
                return xVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "detailSuffix", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FinderActivityHeaderUIC trr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderActivityHeaderUIC finderActivityHeaderUIC) {
            super(1);
            this.trr = finderActivityHeaderUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(242073);
            p.h(str, "detailSuffix");
            FinderActivityHeaderUIC.b(this.trr);
            x xVar = x.SXb;
            AppMethodBeat.o(242073);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderActivityHeaderUIC(MMFragmentActivity mMFragmentActivity) {
        super(mMFragmentActivity);
        p.h(mMFragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(242084);
        AppMethodBeat.o(242084);
    }

    public static final /* synthetic */ ImageView a(FinderActivityHeaderUIC finderActivityHeaderUIC) {
        AppMethodBeat.i(242086);
        ImageView imageView = finderActivityHeaderUIC.tqi;
        if (imageView == null) {
            p.btv("headerCoverView");
        }
        AppMethodBeat.o(242086);
        return imageView;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$Companion;", "", "()V", "IS_MOCK_DATA", "", "MENU_ID_SET_NO_FOLLOW_CONFIRM", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(242075);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.nickName = intent.getStringExtra("key_nick_name");
        this.activityName = intent.getStringExtra("key_activity_name");
        this.trk = intent.getStringExtra("key_activity_desc");
        this.kog = intent.getStringExtra("key_avatar_url");
        this.coverUrl = intent.getStringExtra("key_cover_url");
        this.trl = intent.getIntExtra("key_activity_participate_count", 0);
        this.trm = intent.getLongExtra("key_activity_id", 0);
        View findViewById = getActivity().findViewById(R.id.f4);
        p.g(findViewById, "activity.findViewById(R.….activity_profile_header)");
        this.kgo = findViewById;
        View findViewById2 = getActivity().findViewById(R.id.f1);
        p.g(findViewById2, "activity.findViewById(R.id.activity_profile_cover)");
        this.tqi = (ImageView) findViewById2;
        View view = this.kgo;
        if (view == null) {
            p.btv("headerView");
        }
        TextView textView = (TextView) view.findViewById(R.id.fc);
        p.g(textView, "headerView.activity_profile_header_title");
        this.trd = textView;
        View view2 = this.kgo;
        if (view2 == null) {
            p.btv("headerView");
        }
        TextView textView2 = (TextView) view2.findViewById(R.id.f6);
        p.g(textView2, "headerView.activity_profile_header_desc");
        this.tre = textView2;
        View view3 = this.kgo;
        if (view3 == null) {
            p.btv("headerView");
        }
        ImageView imageView = (ImageView) view3.findViewById(R.id.f5);
        p.g(imageView, "headerView.activity_profile_header_avatar");
        this.trf = imageView;
        View view4 = this.kgo;
        if (view4 == null) {
            p.btv("headerView");
        }
        TextView textView3 = (TextView) view4.findViewById(R.id.f8);
        p.g(textView3, "headerView.activity_profile_header_name");
        this.trg = textView3;
        View view5 = this.kgo;
        if (view5 == null) {
            p.btv("headerView");
        }
        TextView textView4 = (TextView) view5.findViewById(R.id.f9);
        p.g(textView4, "headerView.activity_profile_header_participate");
        this.trh = textView4;
        View view6 = this.kgo;
        if (view6 == null) {
            p.btv("headerView");
        }
        LinearLayout linearLayout = (LinearLayout) view6.findViewById(R.id.f_);
        p.g(linearLayout, "headerView.activity_profile_header_participate_btn");
        this.tri = linearLayout;
        LinearLayout linearLayout2 = this.tri;
        if (linearLayout2 == null) {
            p.btv("participateBtn");
        }
        linearLayout2.setOnClickListener(c.trs);
        cXv();
        TextView textView5 = this.tre;
        if (textView5 == null) {
            p.btv("headerDescTextView");
        }
        textView5.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(textView5.getContext()));
        this.trp.alive();
        AppMethodBeat.o(242075);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(242076);
        super.onDestroy();
        this.trp.dead();
        AppMethodBeat.o(242076);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        public static final c trs = new c();

        static {
            AppMethodBeat.i(242070);
            AppMethodBeat.o(242070);
        }

        c() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242069);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242069);
        }
    }

    /* access modifiers changed from: package-private */
    public final void cXv() {
        AppMethodBeat.i(242077);
        TextView textView = this.trd;
        if (textView == null) {
            p.btv("headerTitleTextView");
        }
        AppCompatActivity activity = getActivity();
        String str = this.nickName;
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(activity, str != null ? str : ""));
        TextView textView2 = this.trg;
        if (textView2 == null) {
            p.btv("headerNameTextView");
        }
        textView2.setText(this.activityName);
        String str2 = this.kog;
        if (str2 == null) {
            str2 = "";
        }
        asB(str2);
        String str3 = this.trk;
        if (str3 == null) {
            str3 = "";
        }
        TextView textView3 = this.tre;
        if (textView3 == null) {
            p.btv("headerDescTextView");
        }
        a(str3, textView3);
        Ij(this.trl);
        String str4 = this.coverUrl;
        if (str4 == null) {
            str4 = "";
        }
        setCover(str4);
        AppMethodBeat.o(242077);
    }

    private final void setCover(String str) {
        AppMethodBeat.i(242078);
        com.tencent.mm.plugin.finder.loader.g gVar = new com.tencent.mm.plugin.finder.loader.g(str);
        m mVar = m.uJa;
        com.tencent.mm.loader.a.b<o, Bitmap> bQ = m.djY().bQ(gVar);
        m mVar2 = m.uJa;
        com.tencent.mm.loader.b<o, Bitmap> a2 = bQ.a(m.a(m.a.PROFILE_COVER)).a(new d(this, str));
        ImageView imageView = this.tqi;
        if (imageView == null) {
            p.btv("headerCoverView");
        }
        a2.c(imageView);
        AppMethodBeat.o(242078);
    }

    private final void Ij(int i2) {
        AppMethodBeat.i(242079);
        String string = getActivity().getString(R.string.cgz, new Object[]{k.gm(2, i2)});
        p.g(string, "activity.getString(R.str…ewScene.SCENE_WX, count))");
        TextView textView = this.trh;
        if (textView == null) {
            p.btv("headerParticipateTextView");
        }
        textView.setText(string);
        AppMethodBeat.o(242079);
    }

    private final void asB(String str) {
        AppMethodBeat.i(242080);
        if (!Util.isNullOrNil(str)) {
            m mVar = m.uJa;
            com.tencent.mm.loader.d<o> dka = m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(str);
            ImageView imageView = this.trf;
            if (imageView == null) {
                p.btv("headerAvatarView");
            }
            m mVar2 = m.uJa;
            dka.a(aVar, imageView, m.a(m.a.AVATAR));
        }
        AppMethodBeat.o(242080);
    }

    private final void a(String str, TextView textView) {
        AppMethodBeat.i(242081);
        if (Util.isNullOrNil(str)) {
            Log.i("SimpleUIComponent", "desc " + str + ", maxLineNum:2");
            AppMethodBeat.o(242081);
            return;
        }
        int cXw = cXw();
        TextPaint paint = textView.getPaint();
        StaticLayout staticLayout = new StaticLayout(str, 0, str.length(), paint, cXw, Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
        if (staticLayout.getLineCount() <= 2) {
            textView.setText(str);
            AppMethodBeat.o(242081);
            return;
        }
        int lineEnd = staticLayout.getLineEnd(1);
        int lineEnd2 = staticLayout.getLineEnd(0);
        String string = textView.getContext().getString(R.string.j_c);
        p.g(string, "textView.context.getStri….finder_desc_suffix_text)");
        StaticLayout staticLayout2 = new StaticLayout(str, lineEnd2, lineEnd, paint, (int) (((float) cXw) - textView.getPaint().measureText(string)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
        if (staticLayout2.getLineCount() > 0) {
            int lineEnd3 = staticLayout2.getLineEnd(0);
            StringBuilder sb = new StringBuilder();
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(242081);
                throw tVar;
            }
            String substring = str.substring(0, lineEnd3);
            p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String sb2 = sb.append(substring).append(string).toString();
            SpannableString spannableString = new SpannableString(sb2);
            spannableString.setSpan(new com.tencent.mm.plugin.finder.view.l(string, getResources().getColor(R.color.Link_80), getResources().getColor(R.color.BW_0_Alpha_0_2), false, false, new e(this)), lineEnd3 + 3, sb2.length(), 17);
            textView.setText(spannableString);
        }
        AppMethodBeat.o(242081);
    }

    private final int cXw() {
        AppMethodBeat.i(242082);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = getActivity().getWindowManager();
        p.g(windowManager, "activity.windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int aH = displayMetrics.widthPixels - com.tencent.mm.cb.a.aH(getActivity(), R.dimen.cn);
        AppMethodBeat.o(242082);
        return aH;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.finder.view.d tru;

        f(com.tencent.mm.plugin.finder.view.d dVar) {
            this.tru = dVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242074);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$showBottomSheet$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tru.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$showBottomSheet$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242074);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class b extends IListener<ih> {
        final /* synthetic */ FinderActivityHeaderUIC trr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(FinderActivityHeaderUIC finderActivityHeaderUIC) {
            this.trr = finderActivityHeaderUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ih ihVar) {
            bds bds;
            aqk aqk;
            ih.a aVar;
            ih.a aVar2;
            bds bds2;
            String str = null;
            AppMethodBeat.i(242068);
            ih ihVar2 = ihVar;
            this.trr.tqo = (ihVar2 == null || (aVar2 = ihVar2.dMT) == null || (bds2 = aVar2.dMU) == null) ? null : bds2.LNz;
            FinderActivityHeaderUIC finderActivityHeaderUIC = this.trr;
            if (ihVar2 == null || (aVar = ihVar2.dMT) == null) {
                bds = null;
            } else {
                bds = aVar.dMU;
            }
            finderActivityHeaderUIC.tro = bds;
            if (!(bds == null || (aqk = bds.LNz) == null)) {
                finderActivityHeaderUIC.activityName = aqk.eventName;
                finderActivityHeaderUIC.trk = aqk.description;
                finderActivityHeaderUIC.trl = aqk.LCy;
                finderActivityHeaderUIC.trm = aqk.twd;
                finderActivityHeaderUIC.coverUrl = aqk.coverImgUrl;
                finderActivityHeaderUIC.trn = aqk.LCz;
                FinderContact finderContact = aqk.contact;
                finderActivityHeaderUIC.nickName = finderContact != null ? finderContact.nickname : null;
                FinderContact finderContact2 = aqk.contact;
                if (finderContact2 != null) {
                    str = finderContact2.headUrl;
                }
                finderActivityHeaderUIC.kog = str;
                Log.i("SimpleUIComponent", "avatarUrl: " + finderActivityHeaderUIC.kog);
                finderActivityHeaderUIC.cXv();
            }
            AppMethodBeat.o(242068);
            return true;
        }
    }

    public static final /* synthetic */ void b(FinderActivityHeaderUIC finderActivityHeaderUIC) {
        AppMethodBeat.i(242087);
        com.tencent.mm.plugin.finder.view.d dVar = new com.tencent.mm.plugin.finder.view.d(finderActivityHeaderUIC.getContext());
        dVar.Ml(R.layout.a97);
        TextView textView = (TextView) dVar.lJI.findViewById(R.id.cje);
        if (textView != null) {
            ao.a(textView.getPaint(), 0.8f);
            textView.setText(textView.getResources().getString(R.string.ch6));
        }
        TextView textView2 = (TextView) dVar.lJI.findViewById(R.id.cjd);
        if (textView2 != null) {
            ao.a(textView2.getPaint(), 0.8f);
            textView2.setText(finderActivityHeaderUIC.trj);
        }
        View findViewById = dVar.lJI.findViewById(R.id.cjc);
        if (findViewById != null) {
            findViewById.setOnClickListener(new f(dVar));
        }
        dVar.dGm();
        AppMethodBeat.o(242087);
    }
}
