package com.tencent.mm.plugin.finder.activity.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.activity.a;
import com.tencent.mm.plugin.finder.activity.uic.FinderActivityTabUIC;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b#*\u0002\u001f4\u0018\u0000 Y2\u00020\u0001:\u0001YB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u0002072\u0006\u00109\u001a\u00020+J\u0006\u0010:\u001a\u000207J\b\u0010;\u001a\u00020\u000bH\u0002J\u0010\u0010<\u001a\u00020)2\b\u0010=\u001a\u0004\u0018\u00010\u0019J\b\u0010>\u001a\u00020\u000bH\u0002J\b\u0010?\u001a\u00020+H\u0002J\u0010\u0010@\u001a\u0002072\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010A\u001a\u000207H\u0002J\u0010\u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020\u0006H\u0002J\u0006\u0010D\u001a\u000207J\u0006\u0010E\u001a\u000207J\u0010\u0010F\u001a\u0002072\b\u0010=\u001a\u0004\u0018\u00010\u0019J\b\u0010G\u001a\u000207H\u0002J\u0010\u0010H\u001a\u0002072\u0006\u00109\u001a\u00020+H\u0002J\b\u0010I\u001a\u00020\u000bH\u0002J\u001a\u0010J\u001a\u0002072\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010=\u001a\u0004\u0018\u00010\u0019J\u0010\u0010K\u001a\u0002072\u0006\u00109\u001a\u00020+H\u0002J\u0010\u0010L\u001a\u0002072\u0006\u0010M\u001a\u00020\u000bH\u0002J(\u0010N\u001a\u0002072\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020+H\u0002J\u0010\u0010R\u001a\u0002072\u0006\u0010S\u001a\u00020\u000bH\u0002J\b\u0010T\u001a\u000207H\u0002J\b\u0010U\u001a\u000207H\u0002J\b\u0010V\u001a\u000207H\u0002J\u0012\u0010W\u001a\u0002072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010X\u001a\u000207H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u000204X\u0004¢\u0006\u0004\n\u0002\u00105¨\u0006Z"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "activityDesc", "", "activityEventId", "", "activityName", "activityParticipateCount", "", "adContainer", "Landroid/widget/LinearLayout;", "adTextView", "Landroid/widget/TextView;", "avatarUrl", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "coverUrl", "descText", "endTimeTextView", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "finderTopicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getFinderTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setFinderTopicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$finderTopicInfoListener$1;", "fromObjectId", "headerAvatarView", "Landroid/widget/ImageView;", "headerDescTextView", "headerNameTextView", "headerParticipateTextView", "headerTitleTextView", "headerView", "Landroid/view/View;", "isReceivedTopic", "", "nickName", "participateBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "participateBtn", "participateIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "participateText", "removeEvent", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$removeEvent$1", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$removeEvent$1;", "changeParticipateButton", "", "changeParticipateView", "isFinished", "destroy", "getAvailableDescWidth", "getHeaderView", "topicInfo", "getIconWidth", "handleAccountStatus", "initHeaderView", "initParam", "loadAvatar", "url", "onResume", "participate", "refreshHeader", "reportMiniProgram", "setCoverStyle", "setDetailTextMaxHeight", "setHeaderView", "setNormalStyle", "setParticipateText", "count", "setSuffixedDesc", "maxLineNum", "textView", "isCovered", "setTextColor", "textColor", "setView", "showAccountBottomSheet", "showBottomSheet", "showMiniProgram", "showParticipateBottomSheet", "Companion", "plugin-finder_release"})
public final class a {
    public static final C1087a tsi = new C1087a((byte) 0);
    private TextView QqX;
    private boolean UGV;
    LinearLayout UHD;
    TextView UHE;
    String activityName = "";
    public String coverUrl = "";
    public final MMActivity gte;
    private View kgo;
    String kog = "";
    String nickName = "";
    aqk tqo;
    private TextView trd;
    private TextView tre;
    private ImageView trf;
    private TextView trg;
    private TextView trh;
    public LinearLayout tri;
    private String trj = "";
    String trk = "";
    long trm;
    long trn;
    bds tro;
    public WeImageView tsc;
    public TextView tsd;
    int tse;
    private com.tencent.mm.ui.widget.a.e tsf;
    private final b tsg;
    private final d tsh;

    static {
        AppMethodBeat.i(242179);
        AppMethodBeat.o(242179);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "detailSuffix", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a tsj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar) {
            super(1);
            this.tsj = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(242159);
            p.h(str, "detailSuffix");
            a.c(this.tsj);
            x xVar = x.SXb;
            AppMethodBeat.o(242159);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showBottomSheet$1$4$1", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$$special$$inlined$let$lambda$1"})
    public static final class n extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a tsj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(a aVar) {
            super(1);
            this.tsj = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(260157);
            p.h(str, LocaleUtil.ITALIAN);
            Log.i("Finder.ActivityHeader", "setAnnounceView");
            y yVar = y.vXH;
            y.mk(this.tsj.gte);
            x xVar = x.SXb;
            AppMethodBeat.o(260157);
            return xVar;
        }
    }

    public a(MMActivity mMActivity) {
        p.h(mMActivity, "context");
        AppMethodBeat.i(242178);
        this.gte = mMActivity;
        a.C1086a aVar = com.tencent.mm.plugin.finder.activity.a.tqf;
        com.tencent.e.f.h.hkS();
        com.tencent.mm.plugin.finder.activity.a.tqe = null;
        this.tsg = new b(this);
        this.tsh = new d(this);
        AppMethodBeat.o(242178);
    }

    public static final /* synthetic */ void k(a aVar) {
        AppMethodBeat.i(260167);
        aVar.hSA();
        AppMethodBeat.o(260167);
    }

    public static final /* synthetic */ void l(a aVar) {
        AppMethodBeat.i(260168);
        aVar.hSE();
        AppMethodBeat.o(260168);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$Companion;", "", "()V", "CREATE_ACCOUNT_REQUEST_CODE", "", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.activity.view.a$a  reason: collision with other inner class name */
    public static final class C1087a {
        private C1087a() {
        }

        public /* synthetic */ C1087a(byte b2) {
            this();
        }
    }

    public final void dR(View view) {
        AppMethodBeat.i(242165);
        if (view != null) {
            dS(view);
            cXD();
            cXv();
            x xVar = x.SXb;
            com.tencent.mm.kernel.g.azz().b(new cd(13));
            this.tsg.alive();
            this.tsh.alive();
        }
        this.kgo = view;
        AppMethodBeat.o(242165);
    }

    public final void hSA() {
        String str;
        bbn bbn = null;
        AppMethodBeat.i(260158);
        aqk aqk = this.tqo;
        String str2 = aqk != null ? aqk.IRp : null;
        if (!Util.isNullOrNil(str2)) {
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            if (str2 == null) {
                str = "";
            } else {
                str = str2;
            }
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
            if (fH != null) {
                bbn = fH.dIx();
            }
            com.tencent.mm.plugin.finder.report.k.a(str, 1, bbn, com.tencent.mm.ac.d.zs(this.trm));
        }
        AppMethodBeat.o(260158);
    }

    public final void destroy() {
        AppMethodBeat.i(242166);
        this.tsg.dead();
        this.tsh.dead();
        a.C1086a aVar = com.tencent.mm.plugin.finder.activity.a.tqf;
        com.tencent.e.f.h.hkS();
        com.tencent.mm.plugin.finder.activity.a.tqe = null;
        AppMethodBeat.o(242166);
    }

    private final void cXD() {
        AppMethodBeat.i(242168);
        Intent intent = this.gte.getIntent();
        this.nickName = intent.getStringExtra("key_nick_name");
        this.activityName = intent.getStringExtra("key_activity_name");
        this.trk = intent.getStringExtra("key_activity_desc");
        this.kog = intent.getStringExtra("key_avatar_url");
        this.coverUrl = intent.getStringExtra("key_cover_url");
        this.tse = intent.getIntExtra("key_activity_participate_count", 0);
        this.trm = intent.getLongExtra("key_activity_id", 0);
        AppMethodBeat.o(242168);
    }

    private final void dS(View view) {
        a aVar;
        AppMethodBeat.i(242169);
        this.trd = (TextView) view.findViewById(R.id.fc);
        this.tre = (TextView) view.findViewById(R.id.f6);
        this.QqX = (TextView) view.findViewById(R.id.jt6);
        this.trf = (ImageView) view.findViewById(R.id.f5);
        TextView textView = (TextView) view.findViewById(R.id.f8);
        if (textView != null) {
            ao.a(textView.getPaint(), 0.8f);
            aVar = this;
        } else {
            textView = null;
            aVar = this;
        }
        aVar.trg = textView;
        this.trh = (TextView) view.findViewById(R.id.f9);
        this.tri = (LinearLayout) view.findViewById(R.id.f_);
        LinearLayout linearLayout = this.tri;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new c(this));
        }
        TextView textView2 = this.tre;
        if (textView2 != null) {
            textView2.setOnTouchListener(new o(textView2.getContext()));
        }
        this.tsc = (WeImageView) view.findViewById(R.id.fa);
        this.tsd = (TextView) view.findViewById(R.id.fb);
        this.UHD = (LinearLayout) this.gte.findViewById(R.id.jt2);
        this.UHE = (TextView) this.gte.findViewById(R.id.jt3);
        LinearLayout linearLayout2 = this.UHD;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new j(this));
        }
        ImageView imageView = this.trf;
        if (imageView != null) {
            imageView.setOnClickListener(new k(this));
            AppMethodBeat.o(242169);
            return;
        }
        AppMethodBeat.o(242169);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ a tsj;

        c(a aVar) {
            this.tsj = aVar;
        }

        public final void onClick(View view) {
            int i2;
            aqk aqk;
            aqk aqk2;
            AppMethodBeat.i(260152);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (a.f(this.tsj)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(260152);
                return;
            }
            y yVar = y.vXH;
            bds bds = this.tsj.tro;
            if (bds == null || (aqk2 = bds.LNz) == null) {
                i2 = 0;
            } else {
                i2 = aqk2.ViD;
            }
            bds bds2 = this.tsj.tro;
            boolean bd = y.bd(i2, (bds2 == null || (aqk = bds2.LNz) == null) ? 0 : aqk.endTime);
            Log.i("Finder.ActivityHeader", "participateBtn onClick isFinished : ".concat(String.valueOf(bd)));
            if (!bd) {
                this.tsj.hSB();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260152);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class j implements View.OnClickListener {
        final /* synthetic */ a tsj;

        j(a aVar) {
            this.tsj = aVar;
        }

        public final void onClick(View view) {
            String str;
            String str2;
            AppMethodBeat.i(260153);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            aqk aqk = this.tsj.tqo;
            if (aqk != null) {
                StringBuilder sb = new StringBuilder();
                FinderContact finderContact = aqk.contact;
                if (finderContact == null || (str = finderContact.username) == null) {
                    str = "";
                }
                String sb2 = sb.append(str).append(':').append(Util.getUuidRandom()).toString();
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                String str3 = aqk.IRp;
                if (str3 == null) {
                    str2 = "";
                } else {
                    str2 = str3;
                }
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tsj.gte);
                com.tencent.mm.plugin.finder.report.k.a(str2, 2, fH != null ? fH.dIx() : null, com.tencent.mm.ac.d.zs(this.tsj.trm));
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                MMActivity mMActivity = this.tsj.gte;
                String str4 = aqk.IRp;
                if (str4 == null) {
                    str4 = "";
                }
                String str5 = aqk.ViB;
                if (str5 == null) {
                    str5 = "";
                }
                com.tencent.mm.plugin.finder.utils.a.a(mMActivity, str4, str5, 1191, sb2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260153);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class k implements View.OnClickListener {
        final /* synthetic */ a tsj;

        k(a aVar) {
            this.tsj = aVar;
        }

        public final void onClick(View view) {
            FinderContact finderContact;
            AppMethodBeat.i(260154);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            aqk aqk = this.tsj.tqo;
            intent.putExtra("finder_username", (aqk == null || (finderContact = aqk.contact) == null) ? null : finderContact.username);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a(this.tsj.gte, intent, 0, 1, false, 64);
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(this.tsj.gte, intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$initHeaderView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260154);
        }
    }

    public final void hSB() {
        Long l2 = null;
        AppMethodBeat.i(260159);
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        aqk aqk = this.tqo;
        long j2 = aqk != null ? aqk.twd : 0;
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
        com.tencent.mm.plugin.finder.report.k.a(2, j2, fH != null ? fH.dIx() : null);
        StringBuilder sb = new StringBuilder();
        p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
        String sb2 = sb.append(com.tencent.mm.kernel.a.ayV()).append('_').append(Util.nowMilliSecond()).toString();
        com.tencent.mm.plugin.finder.activity.b bVar = com.tencent.mm.plugin.finder.activity.b.tqg;
        aqk aqk2 = this.tqo;
        if (aqk2 != null) {
            l2 = Long.valueOf(aqk2.twd);
        }
        if (com.tencent.mm.plugin.finder.activity.b.b(l2, 9)) {
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.fr(this.gte);
        }
        com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.as(9, false);
        com.tencent.mm.plugin.finder.report.i iVar2 = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.auI(sb2);
        hSD();
        AppMethodBeat.o(260159);
    }

    private void hSC() {
        aqk aqk;
        AppMethodBeat.i(260160);
        bds bds = this.tro;
        if (bds == null || (aqk = bds.LNz) == null) {
            AppMethodBeat.o(260160);
            return;
        }
        y yVar = y.vXH;
        if (y.bd(aqk.ViD, aqk.endTime)) {
            WeImageView weImageView = this.tsc;
            if (weImageView != null) {
                weImageView.setVisibility(8);
            }
            TextView textView = this.tsd;
            if (textView != null) {
                textView.setText(this.gte.getResources().getString(R.string.j9z));
                AppMethodBeat.o(260160);
                return;
            }
            AppMethodBeat.o(260160);
            return;
        }
        WeImageView weImageView2 = this.tsc;
        if (weImageView2 != null) {
            weImageView2.setVisibility(0);
        }
        TextView textView2 = this.tsd;
        if (textView2 != null) {
            textView2.setText(this.gte.getResources().getString(R.string.ch2));
            AppMethodBeat.o(260160);
            return;
        }
        AppMethodBeat.o(260160);
    }

    private final void hSD() {
        AppMethodBeat.i(260161);
        if (this.tsf == null) {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.gte, 1, true);
            View inflate = aa.jQ(this.gte).inflate(R.layout.ak1, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.fzc);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.wm);
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
            if (asG != null) {
                p.g(textView, "nicknameTv");
                textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, asG.getNickname()));
                com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
                com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(asG.field_avatarUrl);
                p.g(imageView, "avatarIv");
                com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                dka.a(aVar2, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
            }
            eVar.V(inflate, true);
            eVar.a(i.tsm);
            eVar.a(new g(this));
            eVar.b(new h(this));
            this.tsf = eVar;
        }
        com.tencent.mm.ui.widget.a.e eVar2 = this.tsf;
        if (eVar2 != null) {
            if (!eVar2.isShowing()) {
                eVar2.dGm();
            }
            AppMethodBeat.o(260161);
            return;
        }
        AppMethodBeat.o(260161);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class i implements o.f {
        public static final i tsm = new i();

        static {
            AppMethodBeat.i(242164);
            AppMethodBeat.o(242164);
        }

        i() {
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(242163);
            p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.kV(1001, R.string.um);
                mVar.kV(1002, R.string.uv);
            }
            AppMethodBeat.o(242163);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showParticipateBottomSheet$1$3"})
    public static final class g implements o.g {
        final /* synthetic */ a tsj;

        g(a aVar) {
            this.tsj = aVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            String str;
            String str2;
            String str3;
            String str4;
            FinderContact finderContact;
            FinderContact finderContact2;
            FinderContact finderContact3;
            String str5 = null;
            AppMethodBeat.i(242161);
            Intent intent = new Intent();
            p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == 1001) {
                intent.putExtra("key_finder_post_router", 2);
            } else if (menuItem.getItemId() == 1002) {
                intent.putExtra("key_finder_post_router", 3);
            }
            intent.putExtra("key_finder_post_from", 5);
            StringBuilder sb = new StringBuilder();
            p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
            intent.putExtra("key_finder_post_id", sb.append(com.tencent.mm.kernel.a.ayV()).append('_').append(Util.nowMilliSecond()).toString());
            intent.putExtra("key_finder_post_from", 9);
            intent.putExtra("saveActivity", true);
            intent.putExtra("key_activity_type", 102);
            aqk aqk = this.tsj.tqo;
            if (aqk == null || (finderContact3 = aqk.contact) == null || (str = finderContact3.username) == null) {
                str = "";
            }
            intent.putExtra("key_user_name", str);
            aqk aqk2 = this.tsj.tqo;
            if (aqk2 == null || (finderContact2 = aqk2.contact) == null || (str2 = finderContact2.nickname) == null) {
                str2 = "";
            }
            intent.putExtra("key_nick_name", str2);
            aqk aqk3 = this.tsj.tqo;
            if (aqk3 == null || (finderContact = aqk3.contact) == null || (str3 = finderContact.headUrl) == null) {
                str3 = "";
            }
            intent.putExtra("key_avatar_url", str3);
            String str6 = this.tsj.coverUrl;
            if (str6 == null) {
                str6 = "";
            }
            intent.putExtra("key_cover_url", str6);
            aqk aqk4 = this.tsj.tqo;
            intent.putExtra("key_topic_id", aqk4 != null ? Long.valueOf(aqk4.twd) : null);
            aqk aqk5 = this.tsj.tqo;
            if (aqk5 != null) {
                str4 = aqk5.eventName;
            } else {
                str4 = null;
            }
            intent.putExtra("key_activity_name", str4);
            aqk aqk6 = this.tsj.tqo;
            if (aqk6 != null) {
                str5 = aqk6.description;
            }
            intent.putExtra("key_activity_desc", str5);
            a.C1086a aVar = com.tencent.mm.plugin.finder.activity.a.tqf;
            p.h(intent, "intent");
            com.tencent.e.f.h.hkS();
            if (com.tencent.mm.plugin.finder.activity.a.tqe == null) {
                com.tencent.mm.plugin.finder.activity.a.tqe = new Intent();
            }
            Intent intent2 = com.tencent.mm.plugin.finder.activity.a.tqe;
            if (intent2 != null) {
                a.C1086a aVar2 = com.tencent.mm.plugin.finder.activity.a.tqf;
                a.C1086a.a(intent, intent2);
            }
            com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(this.tsj.gte, intent);
            AppMethodBeat.o(242161);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showParticipateBottomSheet$1$4"})
    public static final class h implements e.b {
        final /* synthetic */ a tsj;

        h(a aVar) {
            this.tsj = aVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(242162);
            this.tsj.tsf = null;
            AppMethodBeat.o(242162);
        }
    }

    /* access modifiers changed from: package-private */
    public final void cXv() {
        boolean z;
        aqk aqk;
        aqk aqk2;
        aqk aqk3;
        long j2 = 0;
        int i2 = 0;
        AppMethodBeat.i(242170);
        TextView textView = this.trg;
        if (textView != null) {
            MMActivity mMActivity = this.gte;
            String str = this.nickName;
            textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(mMActivity, str != null ? str : ""));
        }
        TextView textView2 = this.trd;
        if (textView2 != null) {
            textView2.setText(this.activityName);
        }
        if (!Util.isNullOrNil(this.coverUrl)) {
            z = true;
        } else {
            z = false;
        }
        TextView textView3 = this.trd;
        if (textView3 != null) {
            ao.a(textView3.getPaint(), 0.8f);
        }
        String str2 = this.kog;
        if (str2 == null) {
            str2 = "";
        }
        asB(str2);
        TextView textView4 = this.tre;
        if (textView4 != null) {
            Resources resources = textView4.getResources();
            Object[] objArr = new Object[1];
            String str3 = this.trk;
            if (str3 == null) {
                str3 = "";
            }
            objArr[0] = str3;
            String string = resources.getString(R.string.ch8, objArr);
            p.g(string, "resources.getString(R.st…efix, activityDesc ?: \"\")");
            if (kotlin.n.n.nm(string, "\n")) {
                int length = string.length() - 1;
                if (string == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(242170);
                    throw tVar;
                }
                string = string.substring(0, length);
                p.g(string, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            a(string, textView4, z);
        }
        TextView textView5 = this.tsd;
        if (textView5 != null) {
            ao.a(textView5.getPaint(), 0.8f);
        }
        hSC();
        bds bds = this.tro;
        long j3 = (bds == null || (aqk3 = bds.LNz) == null) ? 0 : aqk3.endTime;
        if (j3 == 0) {
            Log.i("Finder.ActivityHeader", "no endTime");
            TextView textView6 = this.QqX;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
        } else {
            TextView textView7 = this.QqX;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
            TextView textView8 = this.QqX;
            if (textView8 != null) {
                y yVar = y.vXH;
                textView8.setText(y.b(j3 * 1000, this.gte));
            }
        }
        hSE();
        y yVar2 = y.vXH;
        bds bds2 = this.tro;
        if (!(bds2 == null || (aqk2 = bds2.LNz) == null)) {
            i2 = aqk2.ViD;
        }
        bds bds3 = this.tro;
        if (!(bds3 == null || (aqk = bds3.LNz) == null)) {
            j2 = aqk.endTime;
        }
        boolean bd = y.bd(i2, j2);
        if (z) {
            Fs(bd);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderActivityTabUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderActivityTabUIC.class)).hSz();
            AppMethodBeat.o(242170);
            return;
        }
        Fr(bd);
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        ((FinderActivityTabUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderActivityTabUIC.class)).cXo();
        AppMethodBeat.o(242170);
    }

    private final void hSE() {
        AppMethodBeat.i(260162);
        bds bds = this.tro;
        String string = this.gte.getString(R.string.cgz, new Object[]{com.tencent.mm.plugin.finder.utils.k.gm(2, bds != null ? bds.LzC : 0)});
        p.g(string, "context.getString(R.stri…ene.SCENE_WX, feedCount))");
        TextView textView = this.trh;
        if (textView != null) {
            textView.setText(string);
            AppMethodBeat.o(260162);
            return;
        }
        AppMethodBeat.o(260162);
    }

    private final void asB(String str) {
        AppMethodBeat.i(242172);
        ImageView imageView = this.trf;
        if (imageView != null) {
            if (!Util.isNullOrNil(str)) {
                com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
                com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(str);
                com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                dka.a(aVar, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
            }
            AppMethodBeat.o(242172);
            return;
        }
        AppMethodBeat.o(242172);
    }

    private final void a(String str, TextView textView, boolean z) {
        int color;
        String sb;
        AppMethodBeat.i(260163);
        if (Util.isNullOrNil(str)) {
            Log.i("SimpleUIComponent", "desc " + str + ", maxLineNum:2");
            AppMethodBeat.o(260163);
            return;
        }
        int cXw = cXw();
        TextPaint paint = textView.getPaint();
        if (z) {
            color = this.gte.getResources().getColor(R.color.BW_100_Alpha_0_8);
        } else {
            color = this.gte.getResources().getColor(R.color.FG_0);
        }
        StaticLayout staticLayout = new StaticLayout(str, 0, str.length(), paint, cXw, Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
        if (staticLayout.getLineCount() <= 2) {
            textView.setText(str);
            AppMethodBeat.o(260163);
            return;
        }
        int lineEnd = staticLayout.getLineEnd(1);
        int lineEnd2 = staticLayout.getLineEnd(0);
        int dimension = (int) this.gte.getResources().getDimension(R.dimen.c5);
        Drawable m2 = ar.m(this.gte, R.raw.icons_outlined_arrow, color);
        m2.setBounds(0, 0, dimension, (int) this.gte.getResources().getDimension(R.dimen.cb));
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(m2, 1);
        String string = textView.getContext().getString(R.string.j_c);
        p.g(string, "textView.context.getStri….finder_desc_suffix_text)");
        StaticLayout staticLayout2 = new StaticLayout(str, lineEnd2, lineEnd, paint, (int) ((((float) cXw) - textView.getPaint().measureText(string)) - ((float) dimension)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
        if (staticLayout2.getLineCount() > 0) {
            int lineEnd3 = staticLayout2.getLineEnd(0);
            if (str.charAt(lineEnd3 - 1) == '\n') {
                StringBuilder sb2 = new StringBuilder();
                int i2 = lineEnd3 - 1;
                if (str == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(260163);
                    throw tVar;
                }
                String substring = str.substring(0, i2);
                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb = sb2.append(substring).append(string).append(' ').toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                if (str == null) {
                    t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(260163);
                    throw tVar2;
                }
                String substring2 = str.substring(0, lineEnd3);
                p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb = sb3.append(substring2).append(string).append(' ').toString();
            }
            SpannableString spannableString = new SpannableString(sb);
            spannableString.setSpan(aVar, sb.length() - 1, sb.length(), 17);
            spannableString.setSpan(new com.tencent.mm.plugin.finder.view.l(string, color, this.gte.getResources().getColor(R.color.ac_), false, false, new e(this)), 0, sb.length(), 17);
            textView.setText(spannableString);
        }
        AppMethodBeat.o(260163);
    }

    private final int cXw() {
        AppMethodBeat.i(242174);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = this.gte.getWindowManager();
        p.g(windowManager, "context.windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int aH = displayMetrics.widthPixels - com.tencent.mm.cb.a.aH(this.gte, R.dimen.cn);
        AppMethodBeat.o(242174);
        return aH;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showAccountBottomSheet$1$1"})
    public static final class l implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.finder.view.d tOn;
        final /* synthetic */ a tsj;

        l(a aVar, com.tencent.mm.plugin.finder.view.d dVar) {
            this.tsj = aVar;
            this.tOn = dVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260155);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showAccountBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tOn.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showAccountBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260155);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showAccountBottomSheet$1$2"})
    public static final class m implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.finder.view.d tOn;
        final /* synthetic */ a tsj;

        m(a aVar, com.tencent.mm.plugin.finder.view.d dVar) {
            this.tsj = aVar;
            this.tOn = dVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260156);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showAccountBottomSheet$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.tsj.gte);
            if (castActivityOrNull != null) {
                y yVar = y.vXH;
                if (y.bE(castActivityOrNull)) {
                    Intent intent = new Intent();
                    intent.putExtra("key_create_scene", 3);
                    intent.putExtra("scene", 2);
                    com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.d(this.tsj.gte, intent, (int) com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
                }
            }
            this.tOn.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showAccountBottomSheet$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260156);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.finder.view.d tru;

        f(com.tencent.mm.plugin.finder.view.d dVar) {
            this.tru = dVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242160);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showBottomSheet$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tru.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$showBottomSheet$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242160);
        }
    }

    private final void Fs(boolean z) {
        AppMethodBeat.i(260164);
        setTextColor(this.gte.getResources().getColor(R.color.BW_100_Alpha_0_8));
        TextView textView = this.trh;
        if (textView != null) {
            textView.setTextColor(this.gte.getResources().getColor(R.color.BW_100_Alpha_0_5));
        }
        if (z) {
            LinearLayout linearLayout = this.tri;
            if (linearLayout != null) {
                linearLayout.setBackgroundResource(R.drawable.cuh);
            }
            TextView textView2 = this.tsd;
            if (textView2 != null) {
                textView2.setTextColor(this.gte.getResources().getColor(R.color.BW_100_Alpha_0_3));
                AppMethodBeat.o(260164);
                return;
            }
            AppMethodBeat.o(260164);
            return;
        }
        LinearLayout linearLayout2 = this.tri;
        if (linearLayout2 != null) {
            linearLayout2.setBackgroundResource(R.drawable.cug);
        }
        int color = this.gte.getResources().getColor(R.color.am);
        WeImageView weImageView = this.tsc;
        if (weImageView != null) {
            weImageView.setIconColor(color);
        }
        TextView textView3 = this.tsd;
        if (textView3 != null) {
            textView3.setTextColor(color);
            AppMethodBeat.o(260164);
            return;
        }
        AppMethodBeat.o(260164);
    }

    private final void Fr(boolean z) {
        AppMethodBeat.i(260165);
        setTextColor(this.gte.getResources().getColor(R.color.FG_0));
        TextView textView = this.trh;
        if (textView != null) {
            textView.setTextColor(this.gte.getResources().getColor(R.color.FG_1));
        }
        if (z) {
            LinearLayout linearLayout = this.tri;
            if (linearLayout != null) {
                linearLayout.setBackgroundResource(R.drawable.cui);
            }
            TextView textView2 = this.tsd;
            if (textView2 != null) {
                textView2.setTextColor(this.gte.getResources().getColor(R.color.FG_2));
                AppMethodBeat.o(260165);
                return;
            }
            AppMethodBeat.o(260165);
            return;
        }
        LinearLayout linearLayout2 = this.tri;
        if (linearLayout2 != null) {
            linearLayout2.setBackgroundResource(R.drawable.a38);
        }
        int color = this.gte.getResources().getColor(R.color.am);
        WeImageView weImageView = this.tsc;
        if (weImageView != null) {
            weImageView.setIconColor(color);
        }
        TextView textView3 = this.tsd;
        if (textView3 != null) {
            textView3.setTextColor(color);
            AppMethodBeat.o(260165);
            return;
        }
        AppMethodBeat.o(260165);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class b extends IListener<ih> {
        final /* synthetic */ a tsj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.tsj = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ih ihVar) {
            ih.a aVar;
            View view;
            bds bds;
            long j2;
            aqk aqk;
            String str;
            String str2;
            ih.a aVar2;
            bds bds2;
            bbn bbn = null;
            AppMethodBeat.i(242154);
            ih ihVar2 = ihVar;
            this.tsj.tqo = (ihVar2 == null || (aVar2 = ihVar2.dMT) == null || (bds2 = aVar2.dMU) == null) ? null : bds2.LNz;
            if (!(ihVar2 == null || (aVar = ihVar2.dMT) == null)) {
                if (aVar.responseCode == 0) {
                    if (!this.tsj.UGV) {
                        a.k(this.tsj);
                        this.tsj.UGV = true;
                    }
                    a aVar3 = this.tsj;
                    ih.a aVar4 = ihVar2.dMT;
                    if (aVar4 != null) {
                        bds = aVar4.dMU;
                    } else {
                        bds = null;
                    }
                    aVar3.tro = bds;
                    bds bds3 = aVar3.tro;
                    aVar3.tqo = bds3 != null ? bds3.LNz : null;
                    if (!(bds == null || (aqk = bds.LNz) == null)) {
                        aVar3.activityName = aqk.eventName;
                        aVar3.trk = aqk.description;
                        aVar3.tse = bds.LzC;
                        aVar3.trm = aqk.twd;
                        aVar3.coverUrl = aqk.coverImgUrl;
                        aVar3.trn = aqk.LCz;
                        FinderContact finderContact = aqk.contact;
                        if (finderContact != null) {
                            str = finderContact.nickname;
                        } else {
                            str = null;
                        }
                        aVar3.nickName = str;
                        FinderContact finderContact2 = aqk.contact;
                        if (finderContact2 != null) {
                            str2 = finderContact2.headUrl;
                        } else {
                            str2 = null;
                        }
                        aVar3.kog = str2;
                        Log.i("Finder.ActivityHeader", "avatarUrl: " + aVar3.kog + " activityParticipateCount:" + aVar3.tse + " coverUrl:" + aVar3.coverUrl + " nickName:" + aVar3.nickName);
                        aVar3.cXv();
                        if (aqk != null) {
                            if (!Util.isNullOrNil(aqk.IRp)) {
                                LinearLayout linearLayout = aVar3.UHD;
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(0);
                                }
                                TextView textView = aVar3.UHE;
                                if (textView != null) {
                                    textView.setText(aqk.ViC);
                                }
                            } else {
                                LinearLayout linearLayout2 = aVar3.UHD;
                                if (linearLayout2 != null) {
                                    linearLayout2.setVisibility(8);
                                }
                            }
                        }
                    }
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    aqk aqk2 = this.tsj.tqo;
                    if (aqk2 != null) {
                        j2 = aqk2.twd;
                    } else {
                        j2 = 0;
                    }
                    FinderReporterUIC.a aVar5 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tsj.gte);
                    if (fH != null) {
                        bbn = fH.dIx();
                    }
                    com.tencent.mm.plugin.finder.report.k.a(1, j2, bbn);
                } else if ((aVar.responseCode == -4056 || aVar.responseCode == -4058 || aVar.responseCode == -4063) && (view = this.tsj.kgo) != null) {
                    view.setVisibility(8);
                }
            }
            AppMethodBeat.o(242154);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$removeEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class d extends IListener<com.tencent.mm.g.a.f> {
        final /* synthetic */ a tsj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(a aVar) {
            this.tsj = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.f fVar) {
            AppMethodBeat.i(242158);
            if (fVar != null) {
                com.tencent.mm.ac.d.h(new C1088a(this));
            }
            AppMethodBeat.o(242158);
            return false;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$removeEvent$1$callback$1$1"})
        /* renamed from: com.tencent.mm.plugin.finder.activity.view.a$d$a  reason: collision with other inner class name */
        static final class C1088a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ d tsl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1088a(d dVar) {
                super(0);
                this.tsl = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(242157);
                if (this.tsl.tsj.tse > 0) {
                    a aVar = this.tsl.tsj;
                    aVar.tse--;
                    a aVar2 = this.tsl.tsj;
                    int unused = this.tsl.tsj.tse;
                    a.l(aVar2);
                    Log.i("Finder.ActivityHeader", "activityParticipateCount minus: " + this.tsl.tsj.tse);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(242157);
                return xVar;
            }
        }
    }

    private final void setTextColor(int i2) {
        AppMethodBeat.i(242177);
        TextView textView = this.trg;
        if (textView != null) {
            textView.setTextColor(i2);
        }
        TextView textView2 = this.trd;
        if (textView2 != null) {
            textView2.setTextColor(i2);
        }
        TextView textView3 = this.tre;
        if (textView3 != null) {
            textView3.setTextColor(i2);
        }
        TextView textView4 = this.QqX;
        if (textView4 != null) {
            textView4.setTextColor(i2);
            AppMethodBeat.o(242177);
            return;
        }
        AppMethodBeat.o(242177);
    }

    public static final /* synthetic */ boolean f(a aVar) {
        AppMethodBeat.i(260166);
        y yVar = y.vXH;
        switch (y.dCL()) {
            case 1:
                u.makeText(aVar.gte, (int) R.string.d3l, 0).show();
                break;
            case 2:
                com.tencent.mm.plugin.finder.view.d dVar = new com.tencent.mm.plugin.finder.view.d(aVar.gte);
                dVar.Ml(R.layout.abo);
                dVar.lJI.findViewById(R.id.ai8).setOnClickListener(new l(aVar, dVar));
                dVar.lJI.findViewById(R.id.bhy).setOnClickListener(new m(aVar, dVar));
                dVar.dGm();
                break;
            case 3:
            case 6:
                AppMethodBeat.o(260166);
                return false;
            case 4:
                u.makeText(aVar.gte, (int) R.string.cgf, 0).show();
                break;
            case 5:
                u.makeText(aVar.gte, (int) R.string.d8n, 0).show();
                break;
            default:
                Log.d("FinderFollowTopicHeaderView", "not one of six state");
                break;
        }
        AppMethodBeat.o(260166);
        return true;
    }

    public static final /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(242180);
        com.tencent.mm.plugin.finder.view.d dVar = new com.tencent.mm.plugin.finder.view.d(aVar.gte);
        dVar.Ml(R.layout.a97);
        TextView textView = (TextView) dVar.lJI.findViewById(R.id.cje);
        if (textView != null) {
            ao.a(textView.getPaint(), 0.8f);
            textView.setText(textView.getResources().getString(R.string.ch6));
        }
        TextView textView2 = (TextView) dVar.lJI.findViewById(R.id.cjd);
        if (textView2 != null) {
            textView2.setText(aVar.trk);
        }
        View findViewById = dVar.lJI.findViewById(R.id.cjc);
        if (findViewById != null) {
            findViewById.setOnClickListener(new f(dVar));
        }
        TextView textView3 = (TextView) dVar.lJI.findViewById(R.id.jsz);
        if (textView3 != null) {
            String string = aVar.gte.getResources().getString(R.string.j9p);
            p.g(string, "context.resources.getStr…r_activity_announce_name)");
            String string2 = aVar.gte.getResources().getString(R.string.j_5, string);
            p.g(string2, "context.resources.getStr…n_announce, announceName)");
            SpannableString spannableString = new SpannableString(string2);
            spannableString.setSpan(new com.tencent.mm.plugin.finder.view.l(string2, aVar.gte.getResources().getColor(R.color.vj), aVar.gte.getResources().getColor(R.color.ac_), false, false, new n(aVar)), string2.length() - string.length(), string2.length(), 17);
            textView3.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(aVar.gte));
            textView3.setText(spannableString);
        }
        dVar.dGm();
        AppMethodBeat.o(242180);
    }
}
