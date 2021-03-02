package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.cc;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 d2\u00020\u00012\u00020\u0002:\u0001dB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010I\u001a\u00020:2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\nH\u0002J\b\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u00020NH\u0002J\b\u0010P\u001a\u00020NH\u0002J\b\u0010Q\u001a\u00020NH\u0002J\b\u0010R\u001a\u00020NH\u0002J,\u0010S\u001a\u00020N2\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\u0010V\u001a\u0004\u0018\u00010\r2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\u0018\u0010Y\u001a\u00020N2\u0006\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020\nJ\u0010\u0010Z\u001a\u00020N2\u0006\u0010[\u001a\u00020:H\u0002J\u0010\u0010\\\u001a\u00020N2\b\u0010J\u001a\u0004\u0018\u00010KJ&\u0010]\u001a\u00020N2\b\u0010^\u001a\u0004\u0018\u00010\r2\b\u0010_\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010+\u001a\u00020\nH\u0002J\b\u0010`\u001a\u00020NH\u0002J\b\u0010a\u001a\u00020NH\u0002J\b\u0010b\u001a\u00020NH\u0002J\u001c\u0010c\u001a\u00020N2\b\u0010J\u001a\u0004\u0018\u00010K2\b\b\u0002\u0010+\u001a\u00020\nH\u0002R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u00020\u001c8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u0010\u0010$\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000f\"\u0004\b=\u0010\u0011R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0011\u0010D\u001a\u00020E¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u000e\u0010H\u001a\u000206X\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activityAvatarIcon", "", "getActivityAvatarIcon", "()Ljava/lang/String;", "setActivityAvatarIcon", "(Ljava/lang/String;)V", "activityCreateSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "activityCreatorNickName", "getActivityCreatorNickName", "setActivityCreatorNickName", "activityDesc", "getActivityDesc", "setActivityDesc", "activityDescSheet", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "getActivityEvent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "setActivityEvent", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;)V", "activityName", "getActivityName", "setActivityName", "activityPostSheet", "activityTopicId", "", "getActivityTopicId", "()J", "setActivityTopicId", "(J)V", "activityType", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "coverUrl", "getCoverUrl", "setCoverUrl", "descTextView", "Landroid/widget/TextView;", "iconImageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isEnablePost", "", "localCoverUrl", "getLocalCoverUrl", "setLocalCoverUrl", "mediaWidget", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "getMediaWidget", "()Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "setMediaWidget", "(Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;)V", "onClickListener", "Landroid/view/View$OnClickListener;", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "titleTextView", "confirmActivityType", "intent", "Landroid/content/Intent;", "srcActivityType", "deleteActivity", "", "doCheckScene", "jumpToActivityDesc", "jumpToPost", "jumpToSelectActivity", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "setEnable", "isEnable", "setIntentParam", "setText", "title", "desc", "showCreateActivitySheet", "showDescActivitySheet", "showPostActivitySheet", "update", "Companion", "plugin-finder_release"})
public final class FinderExtendActivityView extends FrameLayout implements i {
    private static final int wlA = 5001;
    private static final int wlB = 5002;
    public static final a wlC = new a((byte) 0);
    private static final int wlw = 3001;
    private static final int wlx = 3002;
    private static final int wly = 4001;
    private static final int wlz = 4002;
    private String UVp = "";
    private String UVq = "";
    private boolean UVr = true;
    private String activityName = "";
    private g contact;
    private String coverUrl = "";
    private long dBT;
    private TextView gtI;
    private final View.OnClickListener ko = new e(this);
    private TextView oqv;
    private String trC = "";
    private int trD = 100;
    private String trk = "";
    private com.tencent.mm.plugin.finder.widget.post.a vRf;
    private azs vTF = new azs();
    private WeImageView wlt;
    private com.tencent.mm.ui.widget.a.e wlv;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView$Companion;", "", "()V", "ACTIVITY_TYPE_CREATE", "", "ACTIVITY_TYPE_NONE", "ACTIVITY_TYPE_SELECT", "MENU_ID_CREATE_DELETE", "MENU_ID_CREATE_MODIFY", "MENU_ID_DESC_DETAIL", "MENU_ID_DESC_EXIT", "MENU_ID_PARTICIPATE", "MENU_ID_POST_ACTIVITY", "REQUEST_CODE_PARTICIPATE_ACTIVITY", "REQUEST_CODE_PRE_POST_ACTIVITY", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(254776);
        AppMethodBeat.o(254776);
    }

    public final void setActivityEvent(azs azs) {
        AppMethodBeat.i(254768);
        p.h(azs, "<set-?>");
        this.vTF = azs;
        AppMethodBeat.o(254768);
    }

    public final azs getActivityEvent() {
        AppMethodBeat.i(254767);
        azs azs = this.vTF;
        azs.twd = this.dBT;
        String str = this.activityName;
        if (str == null) {
            str = "";
        }
        azs.eventName = str;
        String str2 = this.UVp;
        if (str2 == null) {
            str2 = "";
        }
        azs.LJx = str2;
        new StringBuilder("get activityEvent ").append(this.vTF.eventName).append(" eventTopicId:").append(this.vTF.twd);
        h.hkS();
        azs azs2 = this.vTF;
        AppMethodBeat.o(254767);
        return azs2;
    }

    public final g getContact() {
        return this.contact;
    }

    public final void setContact(g gVar) {
        this.contact = gVar;
    }

    public final com.tencent.mm.plugin.finder.widget.post.a getMediaWidget() {
        return this.vRf;
    }

    public final void setMediaWidget(com.tencent.mm.plugin.finder.widget.post.a aVar) {
        this.vRf = aVar;
    }

    public final String getLocalCoverUrl() {
        return this.trC;
    }

    public final void setLocalCoverUrl(String str) {
        this.trC = str;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final void setActivityName(String str) {
        this.activityName = str;
    }

    public final String getActivityCreatorNickName() {
        return this.UVp;
    }

    public final void setActivityCreatorNickName(String str) {
        this.UVp = str;
    }

    public final String getActivityAvatarIcon() {
        return this.UVq;
    }

    public final void setActivityAvatarIcon(String str) {
        this.UVq = str;
    }

    public final String getActivityDesc() {
        return this.trk;
    }

    public final void setActivityDesc(String str) {
        this.trk = str;
    }

    public final long getActivityTopicId() {
        return this.dBT;
    }

    public final void setActivityTopicId(long j2) {
        this.dBT = j2;
    }

    public final View.OnClickListener getOnClickListener() {
        return this.ko;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ FinderExtendActivityView wlD;

        e(FinderExtendActivityView finderExtendActivityView) {
            this.wlD = finderExtendActivityView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(261527);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendActivityView$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            switch (this.wlD.trD) {
                case 100:
                    FinderExtendActivityView.a(this.wlD);
                    break;
                case 101:
                    FinderExtendActivityView.h(this.wlD);
                    break;
                case 102:
                    FinderExtendActivityView.d(this.wlD);
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261527);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderExtendActivityView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(254774);
        View inflate = aa.jQ(getContext()).inflate(R.layout.ai5, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.gf0);
        p.g(findViewById, "view.findViewById(R.id.post_activity_item_title)");
        this.gtI = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.gez);
        p.g(findViewById2, "view.findViewById(R.id.post_activity_item_desc)");
        this.oqv = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.eq);
        p.g(findViewById3, "view.findViewById(R.id.activity_flag_icon)");
        this.wlt = (WeImageView) findViewById3;
        setOnClickListener(this.ko);
        AppMethodBeat.o(254774);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderExtendActivityView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(254775);
        View inflate = aa.jQ(getContext()).inflate(R.layout.ai5, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.gf0);
        p.g(findViewById, "view.findViewById(R.id.post_activity_item_title)");
        this.gtI = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.gez);
        p.g(findViewById2, "view.findViewById(R.id.post_activity_item_desc)");
        this.oqv = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.eq);
        p.g(findViewById3, "view.findViewById(R.id.activity_flag_icon)");
        this.wlt = (WeImageView) findViewById3;
        setOnClickListener(this.ko);
        AppMethodBeat.o(254775);
    }

    public final void b(Intent intent, int i2) {
        AppMethodBeat.i(254769);
        p.h(intent, "intent");
        if (c(intent, i2)) {
            this.trD = i2;
            d(intent, i2);
        }
        hVz();
        AppMethodBeat.o(254769);
    }

    private final void hVz() {
        AppMethodBeat.i(261528);
        g gVar = this.contact;
        if (gVar != null) {
            if (this.trD == 100) {
                com.tencent.mm.kernel.g.azz().a(4050, this);
                com.tencent.mm.kernel.g.azz().b(new cc(gVar.getUsername(), null, null, null, 0, 1, 30));
            }
            AppMethodBeat.o(261528);
            return;
        }
        AppMethodBeat.o(261528);
    }

    private static boolean c(Intent intent, int i2) {
        AppMethodBeat.i(254770);
        if ((!intent.hasExtra("key_topic_id") || !(i2 == 101 || i2 == 102)) && i2 != 100) {
            AppMethodBeat.o(254770);
            return false;
        }
        AppMethodBeat.o(254770);
        return true;
    }

    private final void d(Intent intent, int i2) {
        AppMethodBeat.i(254771);
        if (intent != null) {
            this.activityName = intent.getStringExtra("key_activity_name");
            this.trk = intent.getStringExtra("key_activity_desc");
            this.UVp = intent.getStringExtra("key_nick_name");
            this.UVq = intent.getStringExtra("key_avatar_url");
            this.dBT = intent.getLongExtra("key_topic_id", 0);
            if (i2 != 100) {
                int i3 = i2 == 102 ? 1 : 2;
                com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
                com.tencent.mm.plugin.finder.report.i.dz(com.tencent.mm.ac.d.zs(this.dBT), i3);
            }
            switch (i2) {
                case 101:
                    this.trC = intent.getStringExtra("key_activity_local_cover_url");
                    this.coverUrl = intent.getStringExtra("key_cover_url");
                    break;
                case 102:
                    this.coverUrl = intent.getStringExtra("key_cover_url");
                    break;
                default:
                    this.trC = "";
                    this.coverUrl = "";
                    break;
            }
            P(this.activityName, this.trk, i2);
            AppMethodBeat.o(254771);
            return;
        }
        AppMethodBeat.o(254771);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001d, code lost:
        if (r9 == null) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void P(java.lang.String r8, java.lang.String r9, int r10) {
        /*
        // Method dump skipped, instructions count: 160
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.view.FinderExtendActivityView.P(java.lang.String, java.lang.String, int):void");
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$showCreateActivitySheet$1$1"})
    public static final class b implements o.f {
        final /* synthetic */ FinderExtendActivityView wlD;

        b(FinderExtendActivityView finderExtendActivityView) {
            this.wlD = finderExtendActivityView;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(254761);
            p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.a(FinderExtendActivityView.wlA, this.wlD.getResources().getColor(R.color.FG_0), this.wlD.getResources().getString(R.string.ch0));
                mVar.a(FinderExtendActivityView.wlB, this.wlD.getResources().getColor(R.color.FG_0), this.wlD.getResources().getString(R.string.cgr));
            }
            AppMethodBeat.o(254761);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$showCreateActivitySheet$1$2"})
    public static final class c implements o.g {
        final /* synthetic */ FinderExtendActivityView wlD;

        c(FinderExtendActivityView finderExtendActivityView) {
            this.wlD = finderExtendActivityView;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(254762);
            p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            if (itemId == FinderExtendActivityView.wlA) {
                FinderExtendActivityView.a(this.wlD);
                AppMethodBeat.o(254762);
                return;
            }
            if (itemId == FinderExtendActivityView.wlB) {
                FinderExtendActivityView.e(this.wlD);
            }
            AppMethodBeat.o(254762);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$showCreateActivitySheet$1$3"})
    public static final class d implements e.b {
        final /* synthetic */ FinderExtendActivityView wlD;

        d(FinderExtendActivityView finderExtendActivityView) {
            this.wlD = finderExtendActivityView;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(254763);
            this.wlD.wlv = null;
            AppMethodBeat.o(254763);
        }
    }

    public final void setIntentParam(Intent intent) {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(254773);
        if (intent != null) {
            g gVar = this.contact;
            if (gVar == null || (str = gVar.field_username) == null) {
                str = "";
            }
            intent.putExtra("key_user_name", str);
            if (Util.isNullOrNil(this.UVp)) {
                g gVar2 = this.contact;
                if (gVar2 == null || (str2 = gVar2.getNickname()) == null) {
                    str2 = "";
                }
            } else {
                str2 = this.UVp;
            }
            intent.putExtra("key_nick_name", str2);
            if (Util.isNullOrNil(this.UVq)) {
                g gVar3 = this.contact;
                if (gVar3 == null || (str3 = gVar3.cXH()) == null) {
                    str3 = "";
                }
            } else {
                str3 = this.UVq;
            }
            intent.putExtra("key_avatar_url", str3);
            intent.putExtra("key_topic_id", this.dBT);
            String str4 = this.activityName;
            if (str4 == null) {
                str4 = "";
            }
            intent.putExtra("key_activity_name", str4);
            String str5 = this.trk;
            if (str5 == null) {
                str5 = "";
            }
            intent.putExtra("key_activity_desc", str5);
            if (this.trD == 101) {
                String str6 = this.trC;
                if (str6 == null) {
                    str6 = "";
                }
                intent.putExtra("key_activity_local_cover_url", str6);
                String str7 = this.coverUrl;
                if (str7 == null) {
                    str7 = "";
                }
                p.g(intent.putExtra("key_cover_url", str7), "putExtra(ConstantsUI.Fin…TY_COVER, coverUrl ?: \"\")");
            } else if (this.trD == 102) {
                String str8 = this.coverUrl;
                if (str8 == null) {
                    str8 = "";
                }
                intent.putExtra("key_cover_url", str8);
                intent.putExtra("key_is_from_post", true);
            }
            intent.putExtra("key_activity_type", this.trD);
            AppMethodBeat.o(254773);
            return;
        }
        AppMethodBeat.o(254773);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(261529);
        if (qVar instanceof cc) {
            com.tencent.mm.kernel.g.azz().b(4050, this);
            if (i2 == 0 && i3 == 0) {
                setEnable(true);
                AppMethodBeat.o(261529);
                return;
            } else if (i3 == -4064) {
                setEnable(false);
            }
        }
        AppMethodBeat.o(261529);
    }

    private final void setEnable(boolean z) {
        AppMethodBeat.i(261530);
        this.UVr = z;
        if (z) {
            setAlpha(1.0f);
            setOnClickListener(this.ko);
            TextView textView = this.oqv;
            Context context = getContext();
            p.g(context, "context");
            textView.setTextColor(context.getResources().getColor(R.color.FG_2));
            this.oqv.setText(R.string.cgp);
            AppMethodBeat.o(261530);
            return;
        }
        setAlpha(0.3f);
        setOnClickListener(null);
        TextView textView2 = this.oqv;
        Context context2 = getContext();
        p.g(context2, "context");
        textView2.setTextColor(context2.getResources().getColor(R.color.BW_0_Alpha_0_8));
        this.oqv.setText(R.string.j9t);
        AppMethodBeat.o(261530);
    }

    public static final /* synthetic */ void a(FinderExtendActivityView finderExtendActivityView) {
        AppMethodBeat.i(254777);
        Intent intent = new Intent();
        finderExtendActivityView.setIntentParam(intent);
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        Context context = finderExtendActivityView.getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(254777);
            throw tVar;
        }
        com.tencent.mm.plugin.finder.utils.a.c((MMActivity) context, intent);
        AppMethodBeat.o(254777);
    }

    public static final /* synthetic */ void d(FinderExtendActivityView finderExtendActivityView) {
        AppMethodBeat.i(254779);
        Intent intent = new Intent();
        finderExtendActivityView.setIntentParam(intent);
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        Context context = finderExtendActivityView.getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(254779);
            throw tVar;
        }
        com.tencent.mm.plugin.finder.utils.a.d((MMActivity) context, intent);
        AppMethodBeat.o(254779);
    }

    public static final /* synthetic */ void e(FinderExtendActivityView finderExtendActivityView) {
        AppMethodBeat.i(254780);
        finderExtendActivityView.b(new Intent(), 100);
        AppMethodBeat.o(254780);
    }

    public static final /* synthetic */ void h(FinderExtendActivityView finderExtendActivityView) {
        AppMethodBeat.i(254781);
        if (finderExtendActivityView.wlv == null) {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(finderExtendActivityView.getContext(), 1, false);
            eVar.a(new b(finderExtendActivityView));
            eVar.a(new c(finderExtendActivityView));
            eVar.b(new d(finderExtendActivityView));
            finderExtendActivityView.wlv = eVar;
        }
        com.tencent.mm.ui.widget.a.e eVar2 = finderExtendActivityView.wlv;
        if (eVar2 != null) {
            if (!eVar2.isShowing()) {
                eVar2.dGm();
            }
            AppMethodBeat.o(254781);
            return;
        }
        AppMethodBeat.o(254781);
    }
}
