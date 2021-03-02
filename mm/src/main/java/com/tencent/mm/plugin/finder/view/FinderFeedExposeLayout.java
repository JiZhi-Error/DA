package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\\B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJH\u0010A\u001a\u00020+2\u0006\u0010B\u001a\u00020C2\u0006\u0010)\u001a\u00020&2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020+0E2\n\u0010F\u001a\u00060?R\u00020\u00002\u0006\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\tH\u0002J\u001e\u0010I\u001a\u00020+2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020&0K2\u0006\u0010L\u001a\u00020\tH\u0002J\u0018\u0010M\u001a\u00020+2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0002J\u0010\u0010P\u001a\u00020\f2\u0006\u0010)\u001a\u00020&H\u0002J\u0012\u0010P\u001a\u00020\f2\b\u0010Q\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010R\u001a\u00020\f2\u0006\u0010)\u001a\u00020&H\u0002J\u0010\u0010S\u001a\u00020\f2\u0006\u0010)\u001a\u00020&H\u0002J\u0010\u0010T\u001a\u00020\f2\u0006\u0010)\u001a\u00020&H\u0002Jt\u0010U\u001a\u00020+2\u0006\u0010V\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020&0K2\u0006\u0010L\u001a\u00020\t2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t26\u0010$\u001a2\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\f¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020+0%J\u001c\u0010X\u001a\u00020+2\n\u0010F\u001a\u00060?R\u00020\u00002\u0006\u0010Y\u001a\u00020ZH\u0002J\u000e\u0010[\u001a\u00020+2\u0006\u0010L\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R@\u0010$\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\f¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020+\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000RN\u0010/\u001a6\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(0\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020+\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104RN\u00105\u001a6\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(0\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020+\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u001a\u00108\u001a\u00020.X.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R&\u0010=\u001a\u001a\u0012\b\u0012\u00060?R\u00020\u00000>j\f\u0012\b\u0012\u00060?R\u00020\u0000`@X\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "COMMENT_FRIEND_CAN_CLICK_VALUE", "", "LIKE_COMMENT_EDU_VALUE", "MAX_COMMENT_COUNT", "getMAX_COMMENT_COUNT", "()I", "MAX_COMMENT_NAME_COUNT_VALUE", "REAL_NAME_LIKE_AVATAR_RADIUS_VALUE", "TAG", "", "commentIconContainer", "Landroid/view/View;", "getCommentIconContainer", "()Landroid/view/View;", "setCommentIconContainer", "(Landroid/view/View;)V", "commentsLayout", "getCommentsLayout", "()Landroid/widget/LinearLayout;", "setCommentsLayout", "(Landroid/widget/LinearLayout;)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "lastClickExposeCommentTime", "", "likeClickListener", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "Lkotlin/ParameterName;", "name", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "isLike", "", "likeLayout", "likeTv", "Landroid/widget/TextView;", "onCommentClickListener", "view", "getOnCommentClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnCommentClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onCommentLongClickListener", "getOnCommentLongClickListener", "setOnCommentLongClickListener", "seeAllCommentsTv", "getSeeAllCommentsTv", "()Landroid/widget/TextView;", "setSeeAllCommentsTv", "(Landroid/widget/TextView;)V", "viewHolderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$ViewHolder;", "Lkotlin/collections/ArrayList;", "attachStyle", "contentBuilder", "Landroid/text/SpannableStringBuilder;", "onFriendClick", "Lkotlin/Function1;", "holder", "start", "end", "fillCommentsLayout", "list", "Ljava/util/LinkedList;", "totalCommentCount", "fillLikeTv", "totalLikeCount", "friendLikeCount", "isFriend", ch.COL_USERNAME, "isPoster", "isReplyPoster", "isSelf", "setExposeInfo", "feedConvert", "commentList", "setSpanTouch", "text", "Landroid/text/Spannable;", "updateCommentCount", "ViewHolder", "plugin-finder_release"})
public final class FinderFeedExposeLayout extends LinearLayout {
    private final String TAG;
    private TextView hPG;
    private FinderItem tHo;
    private View vKh;
    private final int wmg = com.tencent.mm.plugin.finder.storage.c.dux().value().intValue();
    private final int wmh;
    private final int wmi;
    private final boolean wmj;
    private final ArrayList<a> wmk;
    private LinearLayout wml;
    public TextView wmm;
    public View wmn;
    private kotlin.g.a.m<? super FinderCommentInfo, ? super Boolean, x> wmo;
    private kotlin.g.a.m<? super View, ? super FinderCommentInfo, x> wmp;
    private kotlin.g.a.m<? super View, ? super FinderCommentInfo, x> wmq;
    private final int wmr;
    private long wms;

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", ch.COL_USERNAME, "", "invoke", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$onFriendClick$1"})
    public static final class b extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FinderFeedExposeLayout wmu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderFeedExposeLayout finderFeedExposeLayout) {
            super(1);
            this.wmu = finderFeedExposeLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            long j2;
            AppMethodBeat.i(168334);
            String str2 = str;
            p.h(str2, ch.COL_USERNAME);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.wmu.getContext();
            p.g(context, "context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            if (fH != null) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                FinderItem finderItem = this.wmu.tHo;
                if (finderItem != null) {
                    j2 = finderItem.getId();
                } else {
                    j2 = 0;
                }
                com.tencent.mm.plugin.finder.report.k.a(1, j2, fH.tCE, 2, str2);
            }
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context2 = this.wmu.getContext();
            p.g(context2, "context");
            com.tencent.mm.plugin.finder.utils.a.d(str2, context2);
            x xVar = x.SXb;
            AppMethodBeat.o(168334);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<String, x> {
        public static final e wmv = new e();

        static {
            AppMethodBeat.i(254799);
            AppMethodBeat.o(254799);
        }

        e() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(254798);
            p.h(str, LocaleUtil.ITALIAN);
            x xVar = x.SXb;
            AppMethodBeat.o(254798);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<String, x> {
        public static final f wmw = new f();

        static {
            AppMethodBeat.i(254801);
            AppMethodBeat.o(254801);
        }

        f() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(254800);
            p.h(str, LocaleUtil.ITALIAN);
            x xVar = x.SXb;
            AppMethodBeat.o(254800);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class g extends q implements kotlin.g.a.b<String, x> {
        public static final g wmx = new g();

        static {
            AppMethodBeat.i(254803);
            AppMethodBeat.o(254803);
        }

        g() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(254802);
            p.h(str, LocaleUtil.ITALIAN);
            x xVar = x.SXb;
            AppMethodBeat.o(254802);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class h extends q implements kotlin.g.a.b<String, x> {
        public static final h wmy = new h();

        static {
            AppMethodBeat.i(254805);
            AppMethodBeat.o(254805);
        }

        h() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(254804);
            p.h(str, LocaleUtil.ITALIAN);
            x xVar = x.SXb;
            AppMethodBeat.o(254804);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class i extends q implements kotlin.g.a.b<String, x> {
        public static final i wmz = new i();

        static {
            AppMethodBeat.i(254807);
            AppMethodBeat.o(254807);
        }

        i() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(254806);
            p.h(str, LocaleUtil.ITALIAN);
            x xVar = x.SXb;
            AppMethodBeat.o(254806);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class j extends q implements kotlin.g.a.b<String, x> {
        public static final j wmA = new j();

        static {
            AppMethodBeat.i(254809);
            AppMethodBeat.o(254809);
        }

        j() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(254808);
            p.h(str, LocaleUtil.ITALIAN);
            x xVar = x.SXb;
            AppMethodBeat.o(254808);
            return xVar;
        }
    }

    public FinderFeedExposeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(168349);
        setOrientation(1);
        View inflate = aa.jQ(getContext()).inflate(R.layout.a_y, (ViewGroup) null);
        addView(inflate, new LinearLayout.LayoutParams(-1, -2));
        View findViewById = inflate.findViewById(R.id.ceq);
        p.g(findViewById, "view.findViewById(R.id.feed_expose_comment)");
        this.wml = (LinearLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.ces);
        p.g(findViewById2, "view.findViewById(R.id.feed_expose_like_layout)");
        this.vKh = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.cer);
        p.g(findViewById3, "view.findViewById(R.id.feed_expose_like)");
        this.hPG = (TextView) findViewById3;
        ao.a(this.hPG.getPaint(), 0.8f);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wmh = com.tencent.mm.plugin.finder.storage.c.dsq().value().intValue();
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wmi = com.tencent.mm.plugin.finder.storage.c.drZ();
        com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wmj = com.tencent.mm.plugin.finder.storage.c.drL();
        this.TAG = "Finder.FinderFeedExposeLayout";
        this.wmk = new ArrayList<>();
        this.wmr = 3;
        AppMethodBeat.o(168349);
    }

    public FinderFeedExposeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(168350);
        setOrientation(1);
        View inflate = aa.jQ(getContext()).inflate(R.layout.a_y, (ViewGroup) null);
        addView(inflate, new LinearLayout.LayoutParams(-1, -2));
        View findViewById = inflate.findViewById(R.id.ceq);
        p.g(findViewById, "view.findViewById(R.id.feed_expose_comment)");
        this.wml = (LinearLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.ces);
        p.g(findViewById2, "view.findViewById(R.id.feed_expose_like_layout)");
        this.vKh = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.cer);
        p.g(findViewById3, "view.findViewById(R.id.feed_expose_like)");
        this.hPG = (TextView) findViewById3;
        ao.a(this.hPG.getPaint(), 0.8f);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wmh = com.tencent.mm.plugin.finder.storage.c.dsq().value().intValue();
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wmi = com.tencent.mm.plugin.finder.storage.c.drZ();
        com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wmj = com.tencent.mm.plugin.finder.storage.c.drL();
        this.TAG = "Finder.FinderFeedExposeLayout";
        this.wmk = new ArrayList<>();
        this.wmr = 3;
        AppMethodBeat.o(168350);
    }

    public final LinearLayout getCommentsLayout() {
        return this.wml;
    }

    public final void setCommentsLayout(LinearLayout linearLayout) {
        AppMethodBeat.i(168340);
        p.h(linearLayout, "<set-?>");
        this.wml = linearLayout;
        AppMethodBeat.o(168340);
    }

    public final TextView getSeeAllCommentsTv() {
        AppMethodBeat.i(254811);
        TextView textView = this.wmm;
        if (textView == null) {
            p.btv("seeAllCommentsTv");
        }
        AppMethodBeat.o(254811);
        return textView;
    }

    public final void setSeeAllCommentsTv(TextView textView) {
        AppMethodBeat.i(168341);
        p.h(textView, "<set-?>");
        this.wmm = textView;
        AppMethodBeat.o(168341);
    }

    public final View getCommentIconContainer() {
        AppMethodBeat.i(254812);
        View view = this.wmn;
        if (view == null) {
            p.btv("commentIconContainer");
        }
        AppMethodBeat.o(254812);
        return view;
    }

    public final void setCommentIconContainer(View view) {
        AppMethodBeat.i(178492);
        p.h(view, "<set-?>");
        this.wmn = view;
        AppMethodBeat.o(178492);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super android.view.View, ? super com.tencent.mm.protocal.protobuf.FinderCommentInfo, kotlin.x>, kotlin.g.a.m<android.view.View, com.tencent.mm.protocal.protobuf.FinderCommentInfo, kotlin.x> */
    public final kotlin.g.a.m<View, FinderCommentInfo, x> getOnCommentClickListener() {
        return this.wmp;
    }

    public final void setOnCommentClickListener(kotlin.g.a.m<? super View, ? super FinderCommentInfo, x> mVar) {
        this.wmp = mVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super android.view.View, ? super com.tencent.mm.protocal.protobuf.FinderCommentInfo, kotlin.x>, kotlin.g.a.m<android.view.View, com.tencent.mm.protocal.protobuf.FinderCommentInfo, kotlin.x> */
    public final kotlin.g.a.m<View, FinderCommentInfo, x> getOnCommentLongClickListener() {
        return this.wmq;
    }

    public final void setOnCommentLongClickListener(kotlin.g.a.m<? super View, ? super FinderCommentInfo, x> mVar) {
        this.wmq = mVar;
    }

    public final int getMAX_COMMENT_COUNT() {
        return this.wmr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r7, com.tencent.mm.plugin.finder.storage.FinderItem r8, java.util.LinkedList<com.tencent.mm.protocal.protobuf.FinderCommentInfo> r9, int r10, int r11, int r12, kotlin.g.a.m<? super com.tencent.mm.protocal.protobuf.FinderCommentInfo, ? super java.lang.Boolean, kotlin.x> r13) {
        /*
        // Method dump skipped, instructions count: 325
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout.a(android.view.View, com.tencent.mm.plugin.finder.storage.FinderItem, java.util.LinkedList, int, int, int, kotlin.g.a.m):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class k<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(168337);
            int a2 = kotlin.b.a.a(Long.valueOf(t2.displayid), Long.valueOf(t.displayid));
            AppMethodBeat.o(168337);
            return a2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class l<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(254810);
            int a2 = kotlin.b.a.a(Long.valueOf(t2.displayid), Long.valueOf(t.displayid));
            AppMethodBeat.o(254810);
            return a2;
        }
    }

    public final void Mo(int i2) {
        AppMethodBeat.i(168343);
        if (i2 > 0) {
            TextView textView = this.wmm;
            if (textView == null) {
                p.btv("seeAllCommentsTv");
            }
            textView.setVisibility(0);
            TextView textView2 = this.wmm;
            if (textView2 == null) {
                p.btv("seeAllCommentsTv");
            }
            textView2.setText(com.tencent.mm.plugin.finder.utils.k.gm(2, i2));
            TextView textView3 = this.wmm;
            if (textView3 == null) {
                p.btv("seeAllCommentsTv");
            }
            ao.a(textView3.getPaint(), 0.8f);
        } else {
            TextView textView4 = this.wmm;
            if (textView4 == null) {
                p.btv("seeAllCommentsTv");
            }
            textView4.setText(getContext().getString(R.string.cje));
            TextView textView5 = this.wmm;
            if (textView5 == null) {
                p.btv("seeAllCommentsTv");
            }
            ao.b(textView5.getPaint());
        }
        View view = this.wmn;
        if (view == null) {
            p.btv("commentIconContainer");
        }
        view.setOnClickListener(new n(this));
        AppMethodBeat.o(168343);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class n implements View.OnClickListener {
        final /* synthetic */ FinderFeedExposeLayout wmu;

        n(FinderFeedExposeLayout finderFeedExposeLayout) {
            this.wmu = finderFeedExposeLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168339);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$updateCommentCount$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderItem finderItem = this.wmu.tHo;
            if (finderItem != null && finderItem.isCommentClose()) {
                this.wmu.getSeeAllCommentsTv().setVisibility(8);
            }
            kotlin.g.a.m<View, FinderCommentInfo, x> onCommentClickListener = this.wmu.getOnCommentClickListener();
            if (onCommentClickListener != null) {
                onCommentClickListener.invoke(this.wmu.getSeeAllCommentsTv(), null);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$updateCommentCount$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168339);
        }
    }

    private final void f(LinkedList<FinderCommentInfo> linkedList, int i2) {
        boolean z;
        AppMethodBeat.i(168344);
        Mo(i2);
        if (linkedList.size() == 0) {
            this.wml.setVisibility(8);
            AppMethodBeat.o(168344);
            return;
        }
        this.wml.setVisibility(0);
        LinearLayout linearLayout = this.wml;
        Context context = getContext();
        p.g(context, "context");
        linearLayout.setDividerDrawable(context.getResources().getDrawable(R.drawable.y3));
        this.wml.setShowDividers(2);
        LinearLayout linearLayout2 = this.wml;
        Context context2 = getContext();
        p.g(context2, "context");
        linearLayout2.setDividerPadding(context2.getResources().getDimensionPixelSize(R.dimen.ct));
        int size = this.wmk.size();
        int max = Math.max(linkedList.size(), this.wmr);
        for (int i3 = size; i3 < max; i3++) {
            View inflate = aa.jQ(getContext()).inflate(R.layout.c39, (ViewGroup) null);
            ArrayList<a> arrayList = this.wmk;
            p.g(inflate, "view");
            arrayList.add(new a(this, inflate));
            this.wml.addView(inflate, new LinearLayout.LayoutParams(-1, -2));
        }
        Iterator<T> it = this.wmk.iterator();
        while (it.hasNext()) {
            it.next().aus.setVisibility(8);
        }
        Log.i(this.TAG, "fillCommentsLayout");
        int i4 = 0;
        for (T t : linkedList) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                kotlin.a.j.hxH();
            }
            T t2 = t;
            if (i4 < this.wmr) {
                a aVar = this.wmk.get(i4);
                p.g(aVar, "viewHolderList[index]");
                a aVar2 = aVar;
                aVar2.aus.setVisibility(0);
                b bVar = new b(this);
                aVar2.pIN.setOnTouchListener(null);
                if (this.wmg == 1) {
                    TextView textView = aVar2.pIN;
                    p.g(textView, "holder.nicknameTv");
                    textView.setMaxLines(2);
                }
                if (t2.replyCommentId == 0) {
                    com.tencent.mm.plugin.finder.convert.d dVar = com.tencent.mm.plugin.finder.convert.d.tyZ;
                    TextView textView2 = aVar2.pIN;
                    p.g(textView2, "holder.nicknameTv");
                    TextPaint paint = textView2.getPaint();
                    p.g(paint, "holder.nicknameTv.paint");
                    String str = t2.nickname;
                    com.tencent.mm.plugin.finder.convert.d dVar2 = com.tencent.mm.plugin.finder.convert.d.tyZ;
                    Context context3 = getContext();
                    p.g(context3, "context");
                    int Z = com.tencent.mm.plugin.finder.convert.d.Z(context3, this.wmi);
                    com.tencent.mm.plugin.finder.convert.d dVar3 = com.tencent.mm.plugin.finder.convert.d.tyZ;
                    Context context4 = getContext();
                    p.g(context4, "context");
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), com.tencent.mm.plugin.finder.convert.d.a(paint, str, Z, com.tencent.mm.plugin.finder.convert.d.Z(context4, this.wmi + 1))));
                    if (!Util.isNullOrNil(t2.username) && b((FinderCommentInfo) t2)) {
                        a(spannableStringBuilder, t2, e.wmv, aVar2, 0, spannableStringBuilder.length());
                    } else if (isFriend(t2.username)) {
                        a(spannableStringBuilder, t2, bVar, aVar2, 0, spannableStringBuilder.length());
                    } else {
                        y yVar = y.vXH;
                        if (y.awn(t2.username)) {
                            a(spannableStringBuilder, t2, bVar, aVar2, 0, spannableStringBuilder.length());
                        } else {
                            a(spannableStringBuilder, t2, f.wmw, aVar2, 0, spannableStringBuilder.length());
                        }
                    }
                    spannableStringBuilder.append((CharSequence) getContext().getString(R.string.cjd)).append((CharSequence) o.a(t2));
                    TextView textView3 = aVar2.pIN;
                    p.g(textView3, "holder.nicknameTv");
                    textView3.setText(spannableStringBuilder);
                } else {
                    Context context5 = getContext();
                    String str2 = t2.nickname;
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(com.tencent.mm.pluginsdk.ui.span.l.c(context5, str2 != null ? str2 : ""));
                    if (b((FinderCommentInfo) t2)) {
                        a(spannableStringBuilder2, t2, g.wmx, aVar2, 0, spannableStringBuilder2.length());
                    } else if (isFriend(t2.username)) {
                        a(spannableStringBuilder2, t2, bVar, aVar2, 0, spannableStringBuilder2.length());
                    } else {
                        y yVar2 = y.vXH;
                        if (y.awn(t2.username)) {
                            a(spannableStringBuilder2, t2, bVar, aVar2, 0, spannableStringBuilder2.length());
                        } else {
                            a(spannableStringBuilder2, t2, h.wmy, aVar2, 0, spannableStringBuilder2.length());
                        }
                    }
                    if (!Util.isNullOrNil(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), t2.replyNickname)) && t2.replyCommentId != 0) {
                        spannableStringBuilder2.append((CharSequence) (" " + getContext().getString(R.string.cjp) + ' '));
                        SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), t2.replyNickname);
                        int length = spannableStringBuilder2.length();
                        spannableStringBuilder2.append((CharSequence) c2);
                        if ((t2.displayFlag & 4) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            a(spannableStringBuilder2, t2, i.wmz, aVar2, length, spannableStringBuilder2.length());
                        } else if (isFriend(t2.reply_username)) {
                            a(spannableStringBuilder2, t2, bVar, aVar2, length, spannableStringBuilder2.length());
                        } else {
                            y yVar3 = y.vXH;
                            if (y.awn(t2.reply_username)) {
                                a(spannableStringBuilder2, t2, bVar, aVar2, length, spannableStringBuilder2.length());
                            } else {
                                a(spannableStringBuilder2, t2, j.wmA, aVar2, length, spannableStringBuilder2.length());
                            }
                        }
                    }
                    spannableStringBuilder2.append((CharSequence) getContext().getString(R.string.cjd));
                    spannableStringBuilder2.append((CharSequence) o.a(t2));
                    TextView textView4 = aVar2.pIN;
                    p.g(textView4, "holder.nicknameTv");
                    textView4.setText(spannableStringBuilder2);
                }
                if (c((FinderCommentInfo) t2)) {
                    ImageView imageView = aVar2.wmt;
                    p.g(imageView, "holder.headerIv");
                    imageView.setVisibility(0);
                    if (this.wmh == 1) {
                        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                        com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dkb = com.tencent.mm.plugin.finder.loader.m.dkb();
                        com.tencent.mm.plugin.finder.loader.a aVar3 = new com.tencent.mm.plugin.finder.loader.a(t2.headUrl);
                        ImageView imageView2 = aVar2.wmt;
                        p.g(imageView2, "holder.headerIv");
                        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                        dkb.a(aVar3, imageView2, com.tencent.mm.plugin.finder.loader.m.a(m.a.WX_AVATAR));
                    } else {
                        com.tencent.mm.plugin.finder.loader.m mVar3 = com.tencent.mm.plugin.finder.loader.m.uJa;
                        com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
                        com.tencent.mm.plugin.finder.loader.a aVar4 = new com.tencent.mm.plugin.finder.loader.a(t2.headUrl);
                        ImageView imageView3 = aVar2.wmt;
                        p.g(imageView3, "holder.headerIv");
                        com.tencent.mm.plugin.finder.loader.m mVar4 = com.tencent.mm.plugin.finder.loader.m.uJa;
                        dka.a(aVar4, imageView3, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
                    }
                    TextView textView5 = aVar2.pIN;
                    p.g(textView5, "holder.nicknameTv");
                    textView5.setMaxLines(1);
                } else {
                    ImageView imageView4 = aVar2.wmt;
                    p.g(imageView4, "holder.headerIv");
                    imageView4.setVisibility(8);
                }
                TextView textView6 = aVar2.pIN;
                p.g(textView6, "holder.nicknameTv");
                textView6.setTag(t2.username);
                aVar2.aus.setOnClickListener(new c(t2, this));
                aVar2.aus.setOnLongClickListener(new d(t2, this));
                i4 = i5;
            } else {
                i4 = i5;
            }
        }
        AppMethodBeat.o(168344);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$7"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ FinderCommentInfo tAq;
        final /* synthetic */ FinderFeedExposeLayout wmu;

        c(FinderCommentInfo finderCommentInfo, FinderFeedExposeLayout finderFeedExposeLayout) {
            this.tAq = finderCommentInfo;
            this.wmu = finderFeedExposeLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168335);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            long currentTimeMillis = System.currentTimeMillis();
            Log.d(this.wmu.TAG, "lastClickExposeCommentTime " + this.wmu.wms + ", curTime:" + currentTimeMillis);
            if (currentTimeMillis - this.wmu.wms < 1000) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(168335);
                return;
            }
            this.wmu.wms = currentTimeMillis;
            kotlin.g.a.m<View, FinderCommentInfo, x> onCommentClickListener = this.wmu.getOnCommentClickListener();
            if (onCommentClickListener != null) {
                p.g(view, LocaleUtil.ITALIAN);
                onCommentClickListener.invoke(view, this.tAq);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168335);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$2$8"})
    public static final class d implements View.OnLongClickListener {
        final /* synthetic */ FinderCommentInfo tAq;
        final /* synthetic */ FinderFeedExposeLayout wmu;

        d(FinderCommentInfo finderCommentInfo, FinderFeedExposeLayout finderFeedExposeLayout) {
            this.tAq = finderCommentInfo;
            this.wmu = finderFeedExposeLayout;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(168336);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            kotlin.g.a.m<View, FinderCommentInfo, x> onCommentLongClickListener = this.wmu.getOnCommentLongClickListener();
            if (onCommentLongClickListener != null) {
                p.g(view, LocaleUtil.ITALIAN);
                onCommentLongClickListener.invoke(view, this.tAq);
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$fillCommentsLayout$$inlined$forEachIndexed$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(168336);
            return true;
        }
    }

    private final void a(SpannableStringBuilder spannableStringBuilder, FinderCommentInfo finderCommentInfo, kotlin.g.a.b<? super String, x> bVar, a aVar, int i2, int i3) {
        AppMethodBeat.i(254814);
        if (this.wmj) {
            String str = finderCommentInfo.username;
            if (str == null) {
                str = "";
            }
            Context context = getContext();
            p.g(context, "context");
            int color = context.getResources().getColor(R.color.Link_80);
            Context context2 = getContext();
            p.g(context2, "context");
            spannableStringBuilder.setSpan(new l(str, color, context2.getResources().getColor(R.color.BW_0_Alpha_0_2), true, false, bVar), i2, i3, 17);
            a(aVar, spannableStringBuilder);
        }
        AppMethodBeat.o(254814);
    }

    private final void a(a aVar, Spannable spannable) {
        AppMethodBeat.i(168346);
        aVar.pIN.setOnTouchListener(new m(this, spannable, aVar));
        AppMethodBeat.o(168346);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    public static final class m implements View.OnTouchListener {
        final /* synthetic */ Spannable vJd;
        final /* synthetic */ a wmB;
        final /* synthetic */ FinderFeedExposeLayout wmu;

        m(FinderFeedExposeLayout finderFeedExposeLayout, Spannable spannable, a aVar) {
            this.wmu = finderFeedExposeLayout;
            this.vJd = spannable;
            this.wmB = aVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z;
            ClickableSpan[] clickableSpanArr;
            AppMethodBeat.i(168338);
            p.g(motionEvent, "event");
            int action = motionEvent.getAction();
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(168338);
                throw tVar;
            }
            TextView textView = (TextView) view;
            Spannable spannable = this.vJd;
            if ((action == 1 || action == 3) && (clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, this.vJd.length(), ClickableSpan.class)) != null) {
                for (ClickableSpan clickableSpan : clickableSpanArr) {
                    if (clickableSpan instanceof com.tencent.mm.pluginsdk.ui.span.p) {
                        ((com.tencent.mm.pluginsdk.ui.span.p) clickableSpan).setIsPressed(false);
                        this.wmB.pIN.invalidate();
                    }
                }
            }
            if (action == 1 || action == 0) {
                int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                int scrollX = x + textView.getScrollX();
                int scrollY = y + textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
                ClickableSpan[] clickableSpanArr2 = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr2.length != 0) {
                    ClickableSpan clickableSpan2 = clickableSpanArr2[0];
                    if (action == 1) {
                        clickableSpan2.onClick(textView);
                    } else if (action == 0) {
                        if (clickableSpan2 instanceof com.tencent.mm.pluginsdk.ui.span.p) {
                            ((com.tencent.mm.pluginsdk.ui.span.p) clickableSpan2).setIsPressed(true);
                            this.wmB.pIN.invalidate();
                        }
                        Selection.setSelection(spannable, spannable.getSpanStart(clickableSpan2), spannable.getSpanEnd(clickableSpan2));
                    }
                    z = true;
                    Log.i(this.wmu.TAG, "touch " + motionEvent.getX() + ", " + motionEvent.getY() + ", ret:" + z);
                    AppMethodBeat.o(168338);
                    return z;
                }
                Selection.removeSelection(spannable);
            }
            z = false;
            Log.i(this.wmu.TAG, "touch " + motionEvent.getX() + ", " + motionEvent.getY() + ", ret:" + z);
            AppMethodBeat.o(168338);
            return z;
        }
    }

    private static boolean b(FinderCommentInfo finderCommentInfo) {
        AppMethodBeat.i(178493);
        y yVar = y.vXH;
        boolean LG = y.LG(finderCommentInfo.displayFlag);
        AppMethodBeat.o(178493);
        return LG;
    }

    private static boolean isFriend(String str) {
        AppMethodBeat.i(168347);
        boolean isFriend = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).isFriend(str);
        AppMethodBeat.o(168347);
        return isFriend;
    }

    private static boolean c(FinderCommentInfo finderCommentInfo) {
        AppMethodBeat.i(254815);
        y yVar = y.vXH;
        boolean LI = y.LI(finderCommentInfo.extFlag);
        AppMethodBeat.o(254815);
        return LI;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout$ViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/view/FinderFeedExposeLayout;Landroid/view/View;)V", "headerIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getHeaderIv", "()Landroid/widget/ImageView;", "getItemView", "()Landroid/view/View;", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "plugin-finder_release"})
    public final class a {
        final View aus;
        final TextView pIN = ((TextView) this.aus.findViewById(R.id.fzc));
        final ImageView wmt = ((ImageView) this.aus.findViewById(R.id.doe));
        final /* synthetic */ FinderFeedExposeLayout wmu;

        public a(FinderFeedExposeLayout finderFeedExposeLayout, View view) {
            p.h(view, "itemView");
            this.wmu = finderFeedExposeLayout;
            AppMethodBeat.i(168333);
            this.aus = view;
            AppMethodBeat.o(168333);
        }
    }
}
