package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.jj;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.g.f;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.plugin.story.ui.a.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020/H\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u001fH\u0002J\u0018\u00104\u001a\u00020/2\u0006\u00105\u001a\u00020\u000f2\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020/H\u0002J\b\u00109\u001a\u00020/H\u0002J\b\u0010:\u001a\u000207H\u0002J\b\u0010;\u001a\u00020/H\u0016J\b\u0010<\u001a\u00020/H\u0014J\b\u0010=\u001a\u00020/H\u0016J\b\u0010>\u001a\u00020/H\u0016J\b\u0010?\u001a\u00020/H\u0014J\b\u0010@\u001a\u00020/H\u0016J\b\u0010A\u001a\u00020/H\u0016J\b\u0010B\u001a\u00020/H\u0016J\b\u0010C\u001a\u00020/H\u0016J\b\u0010D\u001a\u00020/H\u0016J\u0010\u0010E\u001a\u00020/2\u0006\u0010!\u001a\u00020\nH\u0016J\b\u0010F\u001a\u00020/H\u0002J\b\u0010G\u001a\u00020/H\u0002J\b\u0010H\u001a\u00020/H\u0002R\u000e\u0010\f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R@\u0010\u0018\u001a4\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001a0\u0019j\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u001aj\b\u0012\u0004\u0012\u00020\u0011`\u001c`\u001bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u001aj\b\u0012\u0004\u0012\u00020\u000f`\u001cX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001aj\b\u0012\u0004\u0012\u00020\u001f`\u001cX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u001aj\b\u0012\u0004\u0012\u00020\u000f`\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryHeaderTipView;", "Lcom/tencent/mm/plugin/story/api/AbsStoryHeaderTipView;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ContactSyncStateListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AVATAR_COUNT_LIMIT", "AVATAR_ITEM_MARGIN", "TAG", "", "TIP_ANIMATION_DELAY", "", "TIP_MODE_NORMAL", "TIP_MODE_SIMPLE", "TIP_TRANSLATION", "contentGroup", "Landroid/view/View;", "curMode", "friendlyReplyMap", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Lkotlin/collections/ArrayList;", "friendlyUnreadList", "newestList", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$StoryFetcherItemEntity;", "preloadCache", "snsType", "stageGroup", "stageItemAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter;", "stageView", "Lcom/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup;", "tipGroup", "Landroid/widget/RelativeLayout;", "tipIcon", "Landroid/widget/ImageView;", "tipTitleTv", "Landroid/widget/TextView;", "tipUnreadTv", "doReportExpose", "", "genGalleryList", "getAvatarItem", "Lcom/tencent/mm/plugin/story/ui/view/StoryAvatarItemView;", "item", "goStoryGallery", ch.COL_USERNAME, "isReply", "", "initAvatarsView", "initTipView", "needShow", "notifyUserListChange", "onAttachedToWindow", "onCreateView", "onDestroyView", "onDetachedFromWindow", "onListScroll", "onPauseView", "onResumeView", "onScrollIdle", "resetStoryHeader", "setSnsType", "showDeleteAllDialog", "updateTipWithAnim", "updateView", "plugin-story_release"})
public final class StoryHeaderTipView extends AbsStoryHeaderTipView implements l.b {
    private final int FCQ = 5;
    private final long FCR = 100;
    private final int FCS = com.tencent.mm.cb.a.fromDPToPix(getContext(), 30);
    private final int FCT = com.tencent.mm.cb.a.fromDPToPix(getContext(), -70);
    private final int FCU = 1;
    private RelativeLayout FCV;
    private ImageView FCW;
    private TextView FCX;
    private TextView FCY;
    private StoryHeaderStageGroup FCZ;
    private j FDa;
    private View FDb;
    private final ArrayList<String> FDc = new ArrayList<>();
    private ArrayList<l.d> FDd = new ArrayList<>();
    private LinkedHashMap<String, ArrayList<Long>> FDe = new LinkedHashMap<>();
    private ArrayList<String> FDf = new ArrayList<>();
    private int FdB;
    private final String TAG = "MicroMsg.StoryHeaderTipView";
    private int hQV = -1;
    private View hVz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryHeaderTipView(Context context) {
        super(context, null, 0);
        p.h(context, "context");
        AppMethodBeat.i(120201);
        View.inflate(getContext(), R.layout.c0x, this);
        View findViewById = findViewById(R.id.i0h);
        p.g(findViewById, "findViewById(R.id.sns_story_header_tip_group)");
        this.FCV = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.i0i);
        p.g(findViewById2, "findViewById(R.id.sns_story_header_tip_icon)");
        this.FCW = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.i0j);
        p.g(findViewById3, "findViewById(R.id.sns_story_header_tip_stage)");
        this.FCZ = (StoryHeaderStageGroup) findViewById3;
        View findViewById4 = findViewById(R.id.icl);
        p.g(findViewById4, "findViewById(R.id.story_…header_tip_content_group)");
        this.hVz = findViewById4;
        View findViewById5 = findViewById(R.id.i0p);
        p.g(findViewById5, "findViewById(R.id.sns_story_header_tip_unread)");
        this.FCX = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.i0o);
        p.g(findViewById6, "findViewById(R.id.sns_story_header_tip_title)");
        this.FCY = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.i0n);
        p.g(findViewById7, "findViewById(R.id.sns_st…y_header_tip_stage_group)");
        this.FDb = findViewById7;
        this.FDa = new j();
        this.FDa.Fyk = new m<String, Boolean, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView.AnonymousClass1 */
            final /* synthetic */ StoryHeaderTipView FDg;

            {
                this.FDg = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(String str, Boolean bool) {
                AppMethodBeat.i(120184);
                final String str2 = str;
                final boolean booleanValue = bool.booleanValue();
                p.h(str2, ch.COL_USERNAME);
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                final int i2 = aAh.azQ().getInt(ar.a.USERINFO_STORY_BIG_MOUTH_GUIDE_INT, 0);
                if (i2 <= 0) {
                    Context context = this.FDg.getContext();
                    p.g(context, "context");
                    final com.tencent.mm.plugin.story.ui.sns.b bVar = new com.tencent.mm.plugin.story.ui.sns.b(context);
                    View inflate = View.inflate(this.FDg.getContext(), R.layout.bzd, null);
                    p.g(inflate, "guideView");
                    bVar.setContentView(inflate);
                    bVar.FzP = new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 FDh;

                        {
                            this.FDh = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(120183);
                            StoryHeaderTipView.b(this.FDh.FDg);
                            StoryHeaderTipView.a(this.FDh.FDg, str2, booleanValue);
                            bVar.cancel();
                            e aAh = g.aAh();
                            p.g(aAh, "MMKernel.storage()");
                            aAh.azQ().set(ar.a.USERINFO_STORY_BIG_MOUTH_GUIDE_INT, Integer.valueOf(i2 + 1));
                            x xVar = x.SXb;
                            AppMethodBeat.o(120183);
                            return xVar;
                        }
                    };
                    bVar.show();
                } else {
                    StoryHeaderTipView.b(this.FDg);
                    StoryHeaderTipView.a(this.FDg, str2, booleanValue);
                    this.FDg.FDc.remove(str2);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120184);
                return xVar;
            }
        };
        this.FCZ.setContentAdapter(this.FDa);
        this.FCZ.setOnDeleteClick(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView.AnonymousClass2 */
            final /* synthetic */ StoryHeaderTipView FDg;

            {
                this.FDg = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(120185);
                StoryHeaderTipView.e(this.FDg);
                x xVar = x.SXb;
                AppMethodBeat.o(120185);
                return xVar;
            }
        });
        ImageView imageView = this.FCW;
        Context context2 = getContext();
        p.g(context2, "context");
        imageView.setImageDrawable(context2.getResources().getDrawable(R.raw.icons_outlined_one_day_video));
        this.FCV.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView.AnonymousClass3 */
            final /* synthetic */ StoryHeaderTipView FDg;

            {
                this.FDg = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120187);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String concat = "99_".concat(String.valueOf(System.currentTimeMillis()));
                h hVar = h.FuH;
                h.fqE().wN(concat);
                h hVar2 = h.FuH;
                h.fqE().lG((int) System.currentTimeMillis());
                h hVar3 = h.FuH;
                h hVar4 = h.FuH;
                h.aaW(h.fqE().ahr());
                Context context = this.FDg.getContext();
                p.g(context, "context");
                com.tencent.mm.plugin.story.ui.sns.c cVar = new com.tencent.mm.plugin.story.ui.sns.c(context);
                Context context2 = this.FDg.getContext();
                p.g(context2, "context");
                cVar.setContentView(new com.tencent.mm.plugin.story.ui.sns.d(context2, new a(cVar)));
                cVar.show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120187);
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView$3$a */
            static final class a implements View.OnClickListener {
                final /* synthetic */ com.tencent.mm.plugin.story.ui.sns.c Fko;

                a(com.tencent.mm.plugin.story.ui.sns.c cVar) {
                    this.Fko = cVar;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(120186);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView$3$entranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    this.Fko.cancel();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView$3$entranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(120186);
                }
            }
        });
        AppMethodBeat.o(120201);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryHeaderTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(120202);
        View.inflate(getContext(), R.layout.c0x, this);
        View findViewById = findViewById(R.id.i0h);
        p.g(findViewById, "findViewById(R.id.sns_story_header_tip_group)");
        this.FCV = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.i0i);
        p.g(findViewById2, "findViewById(R.id.sns_story_header_tip_icon)");
        this.FCW = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.i0j);
        p.g(findViewById3, "findViewById(R.id.sns_story_header_tip_stage)");
        this.FCZ = (StoryHeaderStageGroup) findViewById3;
        View findViewById4 = findViewById(R.id.icl);
        p.g(findViewById4, "findViewById(R.id.story_…header_tip_content_group)");
        this.hVz = findViewById4;
        View findViewById5 = findViewById(R.id.i0p);
        p.g(findViewById5, "findViewById(R.id.sns_story_header_tip_unread)");
        this.FCX = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.i0o);
        p.g(findViewById6, "findViewById(R.id.sns_story_header_tip_title)");
        this.FCY = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.i0n);
        p.g(findViewById7, "findViewById(R.id.sns_st…y_header_tip_stage_group)");
        this.FDb = findViewById7;
        this.FDa = new j();
        this.FDa.Fyk = new m<String, Boolean, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView.AnonymousClass1 */
            final /* synthetic */ StoryHeaderTipView FDg;

            {
                this.FDg = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(String str, Boolean bool) {
                AppMethodBeat.i(120184);
                final String str2 = str;
                final boolean booleanValue = bool.booleanValue();
                p.h(str2, ch.COL_USERNAME);
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                final int i2 = aAh.azQ().getInt(ar.a.USERINFO_STORY_BIG_MOUTH_GUIDE_INT, 0);
                if (i2 <= 0) {
                    Context context = this.FDg.getContext();
                    p.g(context, "context");
                    final com.tencent.mm.plugin.story.ui.sns.b bVar = new com.tencent.mm.plugin.story.ui.sns.b(context);
                    View inflate = View.inflate(this.FDg.getContext(), R.layout.bzd, null);
                    p.g(inflate, "guideView");
                    bVar.setContentView(inflate);
                    bVar.FzP = new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 FDh;

                        {
                            this.FDh = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(120183);
                            StoryHeaderTipView.b(this.FDh.FDg);
                            StoryHeaderTipView.a(this.FDh.FDg, str2, booleanValue);
                            bVar.cancel();
                            e aAh = g.aAh();
                            p.g(aAh, "MMKernel.storage()");
                            aAh.azQ().set(ar.a.USERINFO_STORY_BIG_MOUTH_GUIDE_INT, Integer.valueOf(i2 + 1));
                            x xVar = x.SXb;
                            AppMethodBeat.o(120183);
                            return xVar;
                        }
                    };
                    bVar.show();
                } else {
                    StoryHeaderTipView.b(this.FDg);
                    StoryHeaderTipView.a(this.FDg, str2, booleanValue);
                    this.FDg.FDc.remove(str2);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120184);
                return xVar;
            }
        };
        this.FCZ.setContentAdapter(this.FDa);
        this.FCZ.setOnDeleteClick(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView.AnonymousClass2 */
            final /* synthetic */ StoryHeaderTipView FDg;

            {
                this.FDg = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(120185);
                StoryHeaderTipView.e(this.FDg);
                x xVar = x.SXb;
                AppMethodBeat.o(120185);
                return xVar;
            }
        });
        ImageView imageView = this.FCW;
        Context context2 = getContext();
        p.g(context2, "context");
        imageView.setImageDrawable(context2.getResources().getDrawable(R.raw.icons_outlined_one_day_video));
        this.FCV.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView.AnonymousClass3 */
            final /* synthetic */ StoryHeaderTipView FDg;

            {
                this.FDg = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120187);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String concat = "99_".concat(String.valueOf(System.currentTimeMillis()));
                h hVar = h.FuH;
                h.fqE().wN(concat);
                h hVar2 = h.FuH;
                h.fqE().lG((int) System.currentTimeMillis());
                h hVar3 = h.FuH;
                h hVar4 = h.FuH;
                h.aaW(h.fqE().ahr());
                Context context = this.FDg.getContext();
                p.g(context, "context");
                com.tencent.mm.plugin.story.ui.sns.c cVar = new com.tencent.mm.plugin.story.ui.sns.c(context);
                Context context2 = this.FDg.getContext();
                p.g(context2, "context");
                cVar.setContentView(new com.tencent.mm.plugin.story.ui.sns.d(context2, new a(cVar)));
                cVar.show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120187);
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView$3$a */
            static final class a implements View.OnClickListener {
                final /* synthetic */ com.tencent.mm.plugin.story.ui.sns.c Fko;

                a(com.tencent.mm.plugin.story.ui.sns.c cVar) {
                    this.Fko = cVar;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(120186);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView$3$entranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    this.Fko.cancel();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView$3$entranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(120186);
                }
            }
        });
        AppMethodBeat.o(120202);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryHeaderTipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(120203);
        View.inflate(getContext(), R.layout.c0x, this);
        View findViewById = findViewById(R.id.i0h);
        p.g(findViewById, "findViewById(R.id.sns_story_header_tip_group)");
        this.FCV = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.i0i);
        p.g(findViewById2, "findViewById(R.id.sns_story_header_tip_icon)");
        this.FCW = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.i0j);
        p.g(findViewById3, "findViewById(R.id.sns_story_header_tip_stage)");
        this.FCZ = (StoryHeaderStageGroup) findViewById3;
        View findViewById4 = findViewById(R.id.icl);
        p.g(findViewById4, "findViewById(R.id.story_…header_tip_content_group)");
        this.hVz = findViewById4;
        View findViewById5 = findViewById(R.id.i0p);
        p.g(findViewById5, "findViewById(R.id.sns_story_header_tip_unread)");
        this.FCX = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.i0o);
        p.g(findViewById6, "findViewById(R.id.sns_story_header_tip_title)");
        this.FCY = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.i0n);
        p.g(findViewById7, "findViewById(R.id.sns_st…y_header_tip_stage_group)");
        this.FDb = findViewById7;
        this.FDa = new j();
        this.FDa.Fyk = new m<String, Boolean, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView.AnonymousClass1 */
            final /* synthetic */ StoryHeaderTipView FDg;

            {
                this.FDg = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(String str, Boolean bool) {
                AppMethodBeat.i(120184);
                final String str2 = str;
                final boolean booleanValue = bool.booleanValue();
                p.h(str2, ch.COL_USERNAME);
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                final int i2 = aAh.azQ().getInt(ar.a.USERINFO_STORY_BIG_MOUTH_GUIDE_INT, 0);
                if (i2 <= 0) {
                    Context context = this.FDg.getContext();
                    p.g(context, "context");
                    final com.tencent.mm.plugin.story.ui.sns.b bVar = new com.tencent.mm.plugin.story.ui.sns.b(context);
                    View inflate = View.inflate(this.FDg.getContext(), R.layout.bzd, null);
                    p.g(inflate, "guideView");
                    bVar.setContentView(inflate);
                    bVar.FzP = new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 FDh;

                        {
                            this.FDh = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(120183);
                            StoryHeaderTipView.b(this.FDh.FDg);
                            StoryHeaderTipView.a(this.FDh.FDg, str2, booleanValue);
                            bVar.cancel();
                            e aAh = g.aAh();
                            p.g(aAh, "MMKernel.storage()");
                            aAh.azQ().set(ar.a.USERINFO_STORY_BIG_MOUTH_GUIDE_INT, Integer.valueOf(i2 + 1));
                            x xVar = x.SXb;
                            AppMethodBeat.o(120183);
                            return xVar;
                        }
                    };
                    bVar.show();
                } else {
                    StoryHeaderTipView.b(this.FDg);
                    StoryHeaderTipView.a(this.FDg, str2, booleanValue);
                    this.FDg.FDc.remove(str2);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120184);
                return xVar;
            }
        };
        this.FCZ.setContentAdapter(this.FDa);
        this.FCZ.setOnDeleteClick(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView.AnonymousClass2 */
            final /* synthetic */ StoryHeaderTipView FDg;

            {
                this.FDg = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(120185);
                StoryHeaderTipView.e(this.FDg);
                x xVar = x.SXb;
                AppMethodBeat.o(120185);
                return xVar;
            }
        });
        ImageView imageView = this.FCW;
        Context context2 = getContext();
        p.g(context2, "context");
        imageView.setImageDrawable(context2.getResources().getDrawable(R.raw.icons_outlined_one_day_video));
        this.FCV.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView.AnonymousClass3 */
            final /* synthetic */ StoryHeaderTipView FDg;

            {
                this.FDg = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120187);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String concat = "99_".concat(String.valueOf(System.currentTimeMillis()));
                h hVar = h.FuH;
                h.fqE().wN(concat);
                h hVar2 = h.FuH;
                h.fqE().lG((int) System.currentTimeMillis());
                h hVar3 = h.FuH;
                h hVar4 = h.FuH;
                h.aaW(h.fqE().ahr());
                Context context = this.FDg.getContext();
                p.g(context, "context");
                com.tencent.mm.plugin.story.ui.sns.c cVar = new com.tencent.mm.plugin.story.ui.sns.c(context);
                Context context2 = this.FDg.getContext();
                p.g(context2, "context");
                cVar.setContentView(new com.tencent.mm.plugin.story.ui.sns.d(context2, new a(cVar)));
                cVar.show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120187);
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView$3$a */
            static final class a implements View.OnClickListener {
                final /* synthetic */ com.tencent.mm.plugin.story.ui.sns.c Fko;

                a(com.tencent.mm.plugin.story.ui.sns.c cVar) {
                    this.Fko = cVar;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(120186);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView$3$entranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    this.Fko.cancel();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView$3$entranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(120186);
                }
            }
        });
        AppMethodBeat.o(120203);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class c implements DialogInterface.OnClickListener {
        final /* synthetic */ StoryHeaderTipView FDg;

        c(StoryHeaderTipView storyHeaderTipView) {
            this.FDg = storyHeaderTipView;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(120190);
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.f.j.Fmx = cl.aWz() + 10;
            for (l.d dVar : this.FDg.FDd) {
                ArrayList<Long> arrayList = com.tencent.mm.plugin.story.f.f.a.FpB.fnl().get(dVar.username);
                if (arrayList != null) {
                    Iterator<T> it = arrayList.iterator();
                    while (it.hasNext()) {
                        long longValue = it.next().longValue();
                        com.tencent.mm.plugin.story.f.b.b bVar2 = com.tencent.mm.plugin.story.f.b.b.Fom;
                        com.tencent.mm.plugin.story.f.b.b.Kk(longValue);
                    }
                }
            }
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            ao azQ = aAh.azQ();
            ar.a aVar = ar.a.USERINFO_STORY_SNS_ALL_READ_TIME_LONG;
            j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
            azQ.set(aVar, Long.valueOf(j.b.fop()));
            com.tencent.mm.plugin.story.f.f.a aVar2 = com.tencent.mm.plugin.story.f.f.a.FpB;
            com.tencent.mm.plugin.story.f.f.a.fpf();
            h hVar = h.FuH;
            h.vW(true);
            AppMethodBeat.o(120190);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class d implements DialogInterface.OnClickListener {
        public static final d FDn = new d();

        static {
            AppMethodBeat.i(120192);
            AppMethodBeat.o(120192);
        }

        d() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(120191);
            h hVar = h.FuH;
            h.vW(false);
            AppMethodBeat.o(120191);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ ArrayList FDl;
        final /* synthetic */ ArrayList FDm;

        a(ArrayList arrayList, ArrayList arrayList2) {
            this.FDl = arrayList;
            this.FDm = arrayList2;
        }

        public final void run() {
            int i2;
            int i3;
            AppMethodBeat.i(120188);
            String concat = "99_".concat(String.valueOf(System.currentTimeMillis()));
            h hVar = h.FuH;
            h.fqE().wN(concat);
            h hVar2 = h.FuH;
            h.fqE().lG((int) System.currentTimeMillis());
            StringBuilder sb = new StringBuilder();
            ArrayList<l.d> arrayList = this.FDl;
            synchronized (arrayList) {
                try {
                    i2 = 0;
                    int i4 = 0;
                    for (l.d dVar : arrayList) {
                        if (i4 < 6) {
                            sb.append(dVar.username).append("|");
                        }
                        if (dVar.fnp()) {
                            i3 = i2 + 1;
                        } else {
                            i3 = i2;
                        }
                        i4++;
                        i2 = i3;
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(120188);
                }
            }
            int lastIndexOf = sb.lastIndexOf("|");
            if (lastIndexOf != -1) {
                sb.deleteCharAt(lastIndexOf);
            }
            StringBuilder sb2 = new StringBuilder();
            ArrayList<String> arrayList2 = this.FDm;
            synchronized (arrayList2) {
                try {
                    for (String str : arrayList2) {
                        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
                        p.g(Kn, "contact");
                        if (Kn.arA()) {
                            h hVar3 = h.FuH;
                            jj fqE = h.fqE();
                            fqE.lL(fqE.aht() + 1);
                        }
                        sb2.append(str).append("|");
                    }
                    x xVar2 = x.SXb;
                } catch (Throwable th) {
                    throw th;
                }
            }
            int lastIndexOf2 = sb2.lastIndexOf("|");
            if (lastIndexOf2 != -1) {
                sb2.deleteCharAt(lastIndexOf2);
            }
            h hVar4 = h.FuH;
            h.fqE().lI(this.FDl.size());
            h hVar5 = h.FuH;
            h.fqE().wO(sb.toString());
            h hVar6 = h.FuH;
            h.fqE().sd((long) i2);
            h hVar7 = h.FuH;
            h hVar8 = h.FuH;
            h.aaW(h.fqE().ahr());
            h hVar9 = h.FuH;
            h.fqF();
            AppMethodBeat.o(120188);
        }
    }

    private final boolean fsd() {
        return this.FdB == 1;
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView
    public final void onCreateView() {
        AppMethodBeat.i(120193);
        com.tencent.mm.plugin.story.f.f.a.FpB.a(this);
        AppMethodBeat.o(120193);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView
    public final void fmT() {
        AppMethodBeat.i(120194);
        com.tencent.mm.plugin.story.f.f.a aVar = com.tencent.mm.plugin.story.f.f.a.FpB;
        com.tencent.mm.plugin.story.f.f.a.fpf();
        AppMethodBeat.o(120194);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView
    public final void onDestroyView() {
        AppMethodBeat.i(120195);
        com.tencent.mm.plugin.story.f.f.a.FpB.b(this);
        AppMethodBeat.o(120195);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ StoryHeaderTipView FDg;

        b(StoryHeaderTipView storyHeaderTipView) {
            this.FDg = storyHeaderTipView;
        }

        public final void run() {
            AppMethodBeat.i(120189);
            StoryHeaderTipView.c(this.FDg);
            if (this.FDg.FDd.size() > 0) {
                ((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).preloadForSnsUser(((l.d) this.FDg.FDd.get(0)).username, false);
            }
            AppMethodBeat.o(120189);
        }
    }

    @Override // com.tencent.mm.plugin.story.api.l.b
    public final void fkX() {
        AppMethodBeat.i(120196);
        MMHandlerThread.postToMainThread(new b(this));
        AppMethodBeat.o(120196);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView
    public final void setSnsType(int i2) {
        this.FdB = i2;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(120197);
        super.onAttachedToWindow();
        Log.d(this.TAG, "onAttachedToWindow");
        AppMethodBeat.o(120197);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(120198);
        super.onDetachedFromWindow();
        Log.d(this.TAG, "onDetachedFromWindow");
        AppMethodBeat.o(120198);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView
    public final void fmU() {
        AppMethodBeat.i(120199);
        if (fsd() && getVisibility() == 0) {
            StoryHeaderStageGroup storyHeaderStageGroup = this.FCZ;
            Log.d(storyHeaderStageGroup.TAG, "onListScroll");
            storyHeaderStageGroup.fsc();
        }
        AppMethodBeat.o(120199);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView
    public final void fjz() {
        AppMethodBeat.i(120200);
        if (fsd() && getVisibility() == 0) {
            StoryHeaderStageGroup storyHeaderStageGroup = this.FCZ;
            if (storyHeaderStageGroup.FCJ != null) {
                RecyclerView.a adapter = storyHeaderStageGroup.FCJ.getAdapter();
                if ((adapter != null ? adapter.getItemCount() : 0) > 0) {
                    RecyclerView recyclerView = storyHeaderStageGroup.FCJ;
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup", "resetHeader", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                    recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup", "resetHeader", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                }
            }
        }
        AppMethodBeat.o(120200);
    }

    public static final /* synthetic */ void b(StoryHeaderTipView storyHeaderTipView) {
        AppMethodBeat.i(120204);
        storyHeaderTipView.FDe.clear();
        storyHeaderTipView.FDf.clear();
        for (T t : storyHeaderTipView.FDd) {
            String str = t.username;
            ArrayList<Long> arrayList = storyHeaderTipView.FDe.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            p.g(arrayList, "friendlyReplyMap[username] ?: ArrayList()");
            if (t.fnp()) {
                ArrayList<Long> arrayList2 = com.tencent.mm.plugin.story.f.f.a.FpB.fnl().get(str);
                if (arrayList2 != null) {
                    arrayList.addAll(arrayList2);
                }
                if ((!arrayList.isEmpty()) && storyHeaderTipView.FDe.get(str) == null) {
                    p.g(str, ch.COL_USERNAME);
                    storyHeaderTipView.FDe.put(str, arrayList);
                }
            } else {
                storyHeaderTipView.FDf.add(str);
            }
        }
        Log.i(storyHeaderTipView.TAG, "genGalleryList friendlyReplyMap:" + storyHeaderTipView.FDe + " friendlyUnreadList:" + storyHeaderTipView.FDf);
        AppMethodBeat.o(120204);
    }

    public static final /* synthetic */ void a(StoryHeaderTipView storyHeaderTipView, String str, boolean z) {
        long B;
        AppMethodBeat.i(120205);
        Log.i(storyHeaderTipView.TAG, "select username:".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.addAll(storyHeaderTipView.FDe.keySet());
            com.tencent.mm.plugin.story.g.d dVar = com.tencent.mm.plugin.story.g.d.FrG;
            B = com.tencent.mm.plugin.story.api.p.FkJ.a(arrayList, storyHeaderTipView.FDe, com.tencent.mm.plugin.story.g.d.fpE());
        } else {
            arrayList.addAll(storyHeaderTipView.FDf);
            com.tencent.mm.plugin.story.g.d dVar2 = com.tencent.mm.plugin.story.g.d.FrG;
            int fpC = com.tencent.mm.plugin.story.g.d.fpC();
            com.tencent.mm.plugin.story.g.d dVar3 = com.tencent.mm.plugin.story.g.d.FrG;
            B = com.tencent.mm.plugin.story.api.p.FkJ.B(arrayList, fpC | com.tencent.mm.plugin.story.g.d.fpD());
        }
        int indexOf = arrayList.indexOf(str);
        Intent intent = new Intent(storyHeaderTipView.getContext(), StoryBrowseUI.class);
        intent.putExtra("data_seed_key", B);
        intent.putExtra("v_position", indexOf);
        intent.putExtra("gallery_session_id", "");
        Context context = storyHeaderTipView.getContext();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView", "goStoryGallery", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView", "goStoryGallery", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(120205);
    }

    public static final /* synthetic */ void c(StoryHeaderTipView storyHeaderTipView) {
        T t;
        boolean z;
        String str = null;
        AppMethodBeat.i(120206);
        if (!storyHeaderTipView.fsd()) {
            storyHeaderTipView.setVisibility(8);
            AppMethodBeat.o(120206);
            return;
        }
        storyHeaderTipView.FDd.clear();
        ArrayList<l.d> arrayList = storyHeaderTipView.FDd;
        com.tencent.mm.plugin.story.f.f.a aVar = com.tencent.mm.plugin.story.f.f.a.FpB;
        arrayList.addAll(com.tencent.mm.plugin.story.f.f.a.fpd());
        com.tencent.mm.plugin.story.ui.a.j jVar = storyHeaderTipView.FDa;
        ArrayList<l.d> arrayList2 = storyHeaderTipView.FDd;
        p.h(arrayList2, "newDatas");
        jVar.Fyl.clear();
        jVar.Fyl.addAll(arrayList2);
        jVar.notifyDataSetChanged();
        ArrayList<l.d> arrayList3 = storyHeaderTipView.FDd;
        if (arrayList3 == null || arrayList3.isEmpty()) {
            storyHeaderTipView.setVisibility(8);
        } else {
            storyHeaderTipView.setVisibility(0);
        }
        String str2 = storyHeaderTipView.TAG;
        StringBuilder append = new StringBuilder("unreadList.size:").append(com.tencent.mm.plugin.story.f.f.a.FpB.fnj().size()).append(", readList.size:").append(com.tencent.mm.plugin.story.f.f.a.FpB.fnn().size()).append(", replyList.size:");
        com.tencent.mm.plugin.story.f.f.a aVar2 = com.tencent.mm.plugin.story.f.f.a.FpB;
        Log.d(str2, append.append(com.tencent.mm.plugin.story.f.f.a.fpc().size()).append(", friendlyList.size:").append(storyHeaderTipView.FDd.size()).toString());
        if (storyHeaderTipView.FDd.size() == 0) {
            storyHeaderTipView.setVisibility(8);
            storyHeaderTipView.FDc.clear();
            AppMethodBeat.o(120206);
            return;
        }
        storyHeaderTipView.setVisibility(0);
        ArrayList arrayList4 = new ArrayList(com.tencent.mm.plugin.story.f.f.a.FpB.fnn());
        ArrayList arrayList5 = new ArrayList(storyHeaderTipView.FDd);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.eJP().post(new a(arrayList5, arrayList4));
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_preload_with_enter_pop_sns, 1) == 1) {
            Iterator<T> it = storyHeaderTipView.FDd.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                if (!storyHeaderTipView.FDc.contains(next.username)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    t = next;
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                str = t2.username;
            }
            if (str != null) {
                storyHeaderTipView.FDc.add(str);
                f.a aVar3 = f.FrJ;
                com.tencent.mm.plugin.story.f.d.h ct = f.a.ct(str, false);
                if (ct != null) {
                    com.tencent.mm.plugin.story.ui.view.gallery.m.FHB.C(kotlin.a.j.listOf(ct.FoT), 5);
                    AppMethodBeat.o(120206);
                    return;
                }
            }
        }
        AppMethodBeat.o(120206);
    }

    public static final /* synthetic */ void e(StoryHeaderTipView storyHeaderTipView) {
        AppMethodBeat.i(120207);
        com.tencent.mm.ui.base.h.a(storyHeaderTipView.getContext(), 0, (int) R.string.hgi, (int) R.string.hgh, (int) R.string.sz, true, (DialogInterface.OnClickListener) new c(storyHeaderTipView), (DialogInterface.OnClickListener) d.FDn, (int) R.color.aah);
        AppMethodBeat.o(120207);
    }
}
