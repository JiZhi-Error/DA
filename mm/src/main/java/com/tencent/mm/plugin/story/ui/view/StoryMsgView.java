package com.tencent.mm.plugin.story.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.e.b;
import com.tencent.mm.plugin.story.f.d.g;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.ui.a.k;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010b\u001a\u000200H\u0002J\u001a\u0010c\u001a\u0002002\u0006\u0010/\u001a\u00020\t2\b\b\u0002\u0010d\u001a\u00020\u001bH\u0002J\u0010\u0010e\u001a\u0002002\u0006\u0010\u0018\u001a\u00020fH\u0002J\u0006\u0010g\u001a\u000200J\b\u0010h\u001a\u000200H\u0002J\u000e\u0010i\u001a\u0002002\u0006\u0010/\u001a\u00020\tJ\u0006\u0010j\u001a\u00020\u001bJ\u0006\u0010k\u001a\u000200J&\u0010l\u001a\u0002002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020\u001bJ\u0006\u0010r\u001a\u000200J\u000e\u0010s\u001a\u0002002\u0006\u0010t\u001a\u00020\u001bJ\u0006\u0010u\u001a\u000200J\u0006\u0010v\u001a\u000200J\u000e\u0010w\u001a\u0002002\u0006\u0010q\u001a\u00020\u001bJ\u0016\u0010x\u001a\u0002002\u0006\u0010y\u001a\u00020\u001b2\u0006\u0010\\\u001a\u00020]J\u000e\u0010z\u001a\u0002002\u0006\u0010{\u001a\u00020\u001bR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000Ra\u0010*\u001aI\u0012\u0013\u0012\u00110\t¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\t¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b('\u0012\u0004\u0012\u000200\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104Ra\u00105\u001aI\u0012\u0013\u0012\u00110\t¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(6\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\t¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(8\u0012\u0004\u0012\u000200\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00102\"\u0004\b:\u00104RL\u0010;\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b('\u0012\u0004\u0012\u000200\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R7\u0010A\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000200\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010G\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001e\u0010M\u001a\u0012\u0012\u0004\u0012\u00020O0Nj\b\u0012\u0004\u0012\u00020O`PX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u000e¢\u0006\u0002\n\u0000R.\u0010T\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010S0Uj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010S`VX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010W\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u000e\u0010\\\u001a\u00020]X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020aX\u0004¢\u0006\u0002\n\u0000¨\u0006|"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "TRANS_OFFSET", "TRANS_Y", "", "actionView", "Lcom/tencent/mm/plugin/story/ui/view/StoryActionView;", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryMsgListAdapter;", "bgArea", "Landroid/view/View;", "blankArea", "closeBtn", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "commentInputSuccess", "", "commentInputView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgInputView;", "getCommentInputView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryMsgInputView;", "setCommentInputView", "(Lcom/tencent/mm/plugin/story/ui/view/StoryMsgInputView;)V", "curPosition", "getCurPosition", "()I", "setCurPosition", "(I)V", "isSelf", "isVisited", "listRoot", "onMsgPanelStateCallback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "state", FirebaseAnalytics.b.INDEX, "", "getOnMsgPanelStateCallback", "()Lkotlin/jvm/functions/Function3;", "setOnMsgPanelStateCallback", "(Lkotlin/jvm/functions/Function3;)V", "onPageScrollCallback", "p0", "p1", "p2", "getOnPageScrollCallback", "setOnPageScrollCallback", "onPageSelectedCallback", "Lkotlin/Function2;", "getOnPageSelectedCallback", "()Lkotlin/jvm/functions/Function2;", "setOnPageSelectedCallback", "(Lkotlin/jvm/functions/Function2;)V", "onPageStateCallback", "Lkotlin/Function1;", "getOnPageStateCallback", "()Lkotlin/jvm/functions/Function1;", "setOnPageStateCallback", "(Lkotlin/jvm/functions/Function1;)V", "outsideClickListener", "Lkotlin/Function0;", "getOutsideClickListener", "()Lkotlin/jvm/functions/Function0;", "setOutsideClickListener", "(Lkotlin/jvm/functions/Function0;)V", "pages", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgListView;", "Lkotlin/collections/ArrayList;", "replyCommentId", "saveContent", "", "saveReplyContentCache", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "sessionId", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "storyId", "", "storyOwner", "toUser", "viewPager", "Landroid/support/v4/view/ViewPager;", "animateClose", "animateOpen", "onlyAnim", "deleteComment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "initBackArea", "onActionSelected", "onBack", "postVisit", "setup", "scene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "isActive", "show", "showInputDialog", "isReply", "switchImageMode", "switchVideoMode", "toggleActiveState", "updateCommentId", "success", "updateUnreadTip", "hasUnread", "plugin-story_release"})
public final class StoryMsgView extends RelativeLayout {
    private kotlin.g.a.a<Boolean> FCB;
    private boolean FCo;
    CharSequence FCq;
    private LinkedHashMap<String, CharSequence> FCr;
    public final View FDA;
    private final View FDB;
    public final StoryActionView FDC;
    public k FDD;
    public boolean FDE;
    public StoryMsgInputView FDF;
    private m<? super Integer, ? super Boolean, x> FDG;
    private q<? super Integer, ? super Float, ? super Integer, x> FDH;
    private kotlin.g.a.b<? super Integer, x> FDI;
    private q<? super Integer, ? super Integer, ? super Boolean, x> FDJ;
    private int FDK;
    private final float FDy;
    private final int FDz;
    public g FoU;
    public String Foa;
    private int Fob;
    public final ArrayList<StoryMsgListView> Fyt;
    private final String TAG;
    public boolean dJM;
    public long edx;
    private final View hRd;
    private final View hRx;
    private String sessionId;
    String toUser;
    final ViewPager uO;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryMsgView(final Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120269);
        this.TAG = "MicroMsg.StoryMsgView";
        this.FDy = (float) au.az(context).y;
        this.FDz = at.fromDPToPix(context, 3);
        this.Fyt = new ArrayList<>();
        this.toUser = "";
        this.Foa = "";
        this.FCr = new LinkedHashMap<>();
        View.inflate(context, R.layout.c0o, this);
        View findViewById = findViewById(R.id.ic6);
        p.g(findViewById, "findViewById(R.id.story_msg_view_pager)");
        this.uO = (ViewPager) findViewById;
        View findViewById2 = findViewById(R.id.ibw);
        p.g(findViewById2, "findViewById(R.id.story_msg_close_img)");
        this.hRd = findViewById2;
        View findViewById3 = findViewById(R.id.ibs);
        p.g(findViewById3, "findViewById(R.id.story_msg_blank_area)");
        this.hRx = findViewById3;
        View findViewById4 = findViewById(R.id.ic2);
        p.g(findViewById4, "findViewById(R.id.story_msg_input_view)");
        this.FDF = (StoryMsgInputView) findViewById4;
        View findViewById5 = findViewById(R.id.ic3);
        p.g(findViewById5, "findViewById(R.id.story_msg_list_root)");
        this.FDA = findViewById5;
        View findViewById6 = findViewById(R.id.ibq);
        p.g(findViewById6, "findViewById(R.id.story_msg_action_view)");
        this.FDC = (StoryActionView) findViewById6;
        View findViewById7 = findViewById(R.id.ibr);
        p.g(findViewById7, "findViewById(R.id.story_msg_bg_area)");
        this.FDB = findViewById7;
        ViewGroup.LayoutParams layoutParams = this.FDF.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(120269);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = au.aD(context);
        this.FDD = new k(this.dJM);
        this.uO.setAdapter(this.FDD);
        this.uO.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryMsgView.AnonymousClass1 */
            final /* synthetic */ StoryMsgView FDL;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.FDL = r1;
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i2) {
                AppMethodBeat.i(120245);
                kotlin.g.a.b<Integer, x> onPageStateCallback = this.FDL.getOnPageStateCallback();
                if (onPageStateCallback != null) {
                    onPageStateCallback.invoke(Integer.valueOf(i2));
                }
                StoryActionView storyActionView = this.FDL.FDC;
                if (storyActionView.dJM) {
                    Log.d(storyActionView.TAG, "onPageChangedState state:" + i2 + " scrollDirection:" + storyActionView.EOS);
                    storyActionView.vp = i2;
                    if (storyActionView.vp == 2) {
                        storyActionView.FBu = true;
                        AppMethodBeat.o(120245);
                        return;
                    } else if (storyActionView.vp == 0) {
                        storyActionView.EOS = -1;
                        storyActionView.FBu = false;
                        storyActionView.FBv = -1.0f;
                    }
                }
                AppMethodBeat.o(120245);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i2, float f2, int i3) {
                AppMethodBeat.i(120246);
                q<Integer, Float, Integer, x> onPageScrollCallback = this.FDL.getOnPageScrollCallback();
                if (onPageScrollCallback != null) {
                    onPageScrollCallback.d(Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3));
                }
                StoryActionView storyActionView = this.FDL.FDC;
                Log.d(storyActionView.TAG, "curIndex:" + i2 + " offset:" + f2 + " p2:" + i3 + " readyAnimation:" + storyActionView.FBu + " scrollDirection:" + storyActionView.EOS + " lastOffset:" + storyActionView.FBv);
                if (storyActionView.dJM) {
                    if (storyActionView.vp == 1 && i2 == 0) {
                        int i4 = storyActionView.FBi >>> 24;
                        int i5 = storyActionView.FBj >>> 24;
                        float max = Math.max(Math.min(f2, 1.0f), 0.0f);
                        int max2 = (Math.max(Math.min((int) (((float) i4) - (((float) (i4 - i5)) * max)), i4), i5) << 24) | 16777215;
                        int max3 = (Math.max(Math.min((int) (((float) i5) + (((float) (i4 - i5)) * max)), i4), i5) << 24) | 16777215;
                        float max4 = Math.max(Math.min(storyActionView.FBg - ((storyActionView.FBg - storyActionView.FBh) * max), storyActionView.FBg), storyActionView.FBh);
                        float max5 = Math.max(Math.min((max * (storyActionView.FBg - storyActionView.FBh)) + storyActionView.FBh, storyActionView.FBg), storyActionView.FBh);
                        Log.d(storyActionView.TAG, "outOffset:" + (max2 - i4) + "  inOffset:" + (max3 - i5));
                        storyActionView.FBo.setTextColor(max2);
                        storyActionView.FBo.setTextSize(0, max4);
                        storyActionView.FBp.setTextColor(max3);
                        storyActionView.FBp.setTextSize(0, max5);
                    }
                    if (storyActionView.FBv > f2) {
                        storyActionView.EOS = storyActionView.FBl;
                    } else if (storyActionView.FBv < f2) {
                        storyActionView.EOS = storyActionView.FBk;
                    }
                    if (!(!storyActionView.FBu || storyActionView.FBv == -1.0f || storyActionView.FBv == 0.0f)) {
                        storyActionView.FBu = false;
                        if (storyActionView.EOS == storyActionView.FBk) {
                            storyActionView.w(storyActionView.FBp);
                            storyActionView.x(storyActionView.FBo);
                        } else if (storyActionView.EOS == storyActionView.FBl) {
                            storyActionView.w(storyActionView.FBo);
                            storyActionView.x(storyActionView.FBp);
                        }
                    }
                    storyActionView.FBv = f2;
                }
                AppMethodBeat.o(120246);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList;
                LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList2;
                LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList3;
                AppMethodBeat.i(120247);
                this.FDL.setCurPosition(i2);
                m<Integer, Boolean, x> onPageSelectedCallback = this.FDL.getOnPageSelectedCallback();
                if (onPageSelectedCallback != null) {
                    onPageSelectedCallback.invoke(Integer.valueOf(i2), Boolean.valueOf(this.FDL.dJM));
                }
                StoryActionView storyActionView = this.FDL.FDC;
                if (storyActionView != null) {
                    storyActionView.sTB = i2;
                    if (storyActionView.dJM) {
                        if (i2 == 0) {
                            storyActionView.a(false, storyActionView.FBo);
                        } else if (i2 == 1) {
                            storyActionView.a(false, storyActionView.FBp);
                        }
                        Log.d(storyActionView.TAG, "onPageChanged index:".concat(String.valueOf(i2)));
                    }
                }
                if (!this.FDL.dJM) {
                    StoryMsgListView storyMsgListView = (StoryMsgListView) this.FDL.Fyt.get(i2);
                    g gVar = this.FDL.FoU;
                    storyMsgListView.hA((gVar == null || (linkedList = gVar.FoQ) == null) ? new ArrayList() : linkedList);
                    AppMethodBeat.o(120247);
                } else if (i2 == 0) {
                    StoryMsgListView storyMsgListView2 = (StoryMsgListView) this.FDL.Fyt.get(0);
                    g gVar2 = this.FDL.FoU;
                    storyMsgListView2.hA((gVar2 == null || (linkedList3 = gVar2.FoS) == null) ? new ArrayList() : linkedList3);
                    this.FDL.getCommentInputView().fse();
                    this.FDL.getCommentInputView().setVisibility(8);
                    h hVar = h.FuH;
                    b.a aVar = com.tencent.mm.plugin.story.e.b.FlA;
                    h.aSo(b.a.Jc(this.FDL.edx));
                    h hVar2 = h.FuH;
                    h.vU(false);
                    AppMethodBeat.o(120247);
                } else {
                    if (i2 == 1) {
                        StoryMsgListView storyMsgListView3 = (StoryMsgListView) this.FDL.Fyt.get(1);
                        g gVar3 = this.FDL.FoU;
                        storyMsgListView3.hA((gVar3 == null || (linkedList2 = gVar3.FoQ) == null) ? new ArrayList() : linkedList2);
                        h hVar3 = h.FuH;
                        b.a aVar2 = com.tencent.mm.plugin.story.e.b.FlA;
                        h.aSp(b.a.Jc(this.FDL.edx));
                        h hVar4 = h.FuH;
                        h.vV(false);
                    }
                    AppMethodBeat.o(120247);
                }
            }
        });
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryMsgView.AnonymousClass2 */
            final /* synthetic */ StoryMsgView FDL;

            {
                this.FDL = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120248);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a<Boolean> outsideClickListener = this.FDL.getOutsideClickListener();
                if (outsideClickListener != null) {
                    outsideClickListener.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120248);
            }
        });
        this.FDC.setOnActionClicked(new kotlin.g.a.b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryMsgView.AnonymousClass3 */
            final /* synthetic */ StoryMsgView FDL;

            {
                this.FDL = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(120249);
                int intValue = num.intValue();
                StoryMsgView storyMsgView = this.FDL;
                if (storyMsgView.FDA.getVisibility() == 0) {
                    storyMsgView.uO.setCurrentItem(intValue);
                } else {
                    StoryMsgView.a(storyMsgView, intValue);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120249);
                return xVar;
            }
        });
        this.FDB.setOnClickListener(new c(this));
        this.hRd.setOnClickListener(new d(this));
        this.hRx.setOnClickListener(new e(this));
        k kVar = this.FDD;
        if (kVar != null) {
            kVar.Fyp = new f(this);
        }
        k kVar2 = this.FDD;
        if (kVar2 != null) {
            kVar2.Fyo = new kotlin.g.a.b<com.tencent.mm.plugin.story.f.b.a, x>(this) {
                /* class com.tencent.mm.plugin.story.ui.view.StoryMsgView.AnonymousClass4 */
                final /* synthetic */ StoryMsgView FDL;

                {
                    this.FDL = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(com.tencent.mm.plugin.story.f.b.a aVar) {
                    String string;
                    AppMethodBeat.i(120251);
                    final com.tencent.mm.plugin.story.f.b.a aVar2 = aVar;
                    p.h(aVar2, LocaleUtil.ITALIAN);
                    if (this.FDL.getCommentInputView().getInputType() != -1) {
                        this.FDL.getCommentInputView().fse();
                    } else {
                        j.b bVar = j.Fmy;
                        if (!Util.isEqual(j.b.fau(), aVar2.dRL)) {
                            this.FDL.toUser = aVar2.dRL;
                            this.FDL.Fob = aVar2.FnS;
                            StoryMsgView storyMsgView = this.FDL;
                            storyMsgView.FDF.a(storyMsgView.FCq, storyMsgView.toUser, true);
                            storyMsgView.FDF.setVisibility$2563266(true);
                        } else {
                            if (aVar2.Fob == 0) {
                                string = context.getResources().getString(R.string.hgt);
                            } else {
                                string = context.getResources().getString(R.string.hgu);
                            }
                            p.g(string, "if (it.replyCommentId ==…_reply)\n                }");
                            f.a aVar3 = new f.a(context);
                            aVar3.bow(string).boA(context.getString(R.string.tf)).apb(-65536).Dq(true);
                            aVar3.c(new f.c(this) {
                                /* class com.tencent.mm.plugin.story.ui.view.StoryMsgView.AnonymousClass4.AnonymousClass1 */
                                final /* synthetic */ AnonymousClass4 FDM;

                                {
                                    this.FDM = r1;
                                }

                                @Override // com.tencent.mm.ui.widget.a.f.c
                                public final void e(boolean z, String str) {
                                    AppMethodBeat.i(120250);
                                    if (z) {
                                        StoryMsgView.a(this.FDM.FDL, aVar2);
                                    }
                                    AppMethodBeat.o(120250);
                                }
                            }).show();
                        }
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(120251);
                    return xVar;
                }
            };
        }
        k kVar3 = this.FDD;
        if (kVar3 != null) {
            kVar3.Fyq = new kotlin.g.a.b<Integer, x>(this) {
                /* class com.tencent.mm.plugin.story.ui.view.StoryMsgView.AnonymousClass5 */
                final /* synthetic */ StoryMsgView FDL;

                {
                    this.FDL = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Integer num) {
                    AppMethodBeat.i(120252);
                    this.FDL.FDA.setTranslationY(Math.min(Math.max(this.FDL.FDA.getTranslationY() - ((float) num.intValue()), 0.0f), this.FDL.FDy));
                    x xVar = x.SXb;
                    AppMethodBeat.o(120252);
                    return xVar;
                }
            };
        }
        k kVar4 = this.FDD;
        if (kVar4 != null) {
            kVar4.Fyr = new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.story.ui.view.StoryMsgView.AnonymousClass6 */
                final /* synthetic */ StoryMsgView FDL;

                {
                    this.FDL = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(120253);
                    if (this.FDL.FDA.getTranslationY() < this.FDL.FDy) {
                        if (this.FDL.FDA.getTranslationY() > ((float) (this.FDL.FDA.getMeasuredHeight() / 10))) {
                            StoryMsgView.a(this.FDL);
                        } else {
                            StoryMsgView.c(this.FDL, this.FDL.getCurPosition());
                        }
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(120253);
                    return xVar;
                }
            };
        }
        this.FDF.setCommentInputCallback(new m<String, Boolean, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryMsgView.AnonymousClass7 */
            final /* synthetic */ StoryMsgView FDL;

            {
                this.FDL = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(String str, Boolean bool) {
                LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList;
                LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList2;
                ArrayList<com.tencent.mm.plugin.story.f.b.a> arrayList;
                LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList3;
                LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList4;
                AppMethodBeat.i(120254);
                String str2 = str;
                boolean booleanValue = bool.booleanValue();
                p.h(str2, "content");
                this.FDL.FCo = booleanValue;
                if (booleanValue) {
                    this.FDL.FCr.remove(this.FDL.toUser);
                    this.FDL.FCq = null;
                    com.tencent.mm.plugin.story.f.b.a b2 = com.tencent.mm.plugin.story.f.b.b.Fom.b(this.FDL.edx, str2, this.FDL.toUser, this.FDL.getSessionId(), this.FDL.Foa, this.FDL.Fob);
                    g gVar = this.FDL.FoU;
                    if (!(gVar == null || (linkedList4 = gVar.FoQ) == null)) {
                        linkedList4.add(b2);
                    }
                    g gVar2 = this.FDL.FoU;
                    if (!(gVar2 == null || (linkedList3 = gVar2.commentList) == null)) {
                        linkedList3.add(b2);
                    }
                    k kVar = this.FDL.FDD;
                    if (!(kVar == null || (arrayList = kVar.FwY) == null)) {
                        arrayList.add(b2);
                    }
                    if (this.FDL.dJM) {
                        StoryMsgListView storyMsgListView = (StoryMsgListView) this.FDL.Fyt.get(1);
                        g gVar3 = this.FDL.FoU;
                        storyMsgListView.hA((gVar3 == null || (linkedList2 = gVar3.FoQ) == null) ? new ArrayList() : linkedList2);
                    } else {
                        StoryMsgListView storyMsgListView2 = (StoryMsgListView) this.FDL.Fyt.get(0);
                        g gVar4 = this.FDL.FoU;
                        storyMsgListView2.hA((gVar4 == null || (linkedList = gVar4.FoQ) == null) ? new ArrayList() : linkedList);
                    }
                }
                if (this.FDL.dJM) {
                    this.FDL.getCommentInputView().setVisibility(8);
                    g gVar5 = this.FDL.FoU;
                    if (gVar5 != null) {
                        this.FDL.FDC.a(gVar5);
                    }
                }
                this.FDL.Fob = 0;
                x xVar = x.SXb;
                AppMethodBeat.o(120254);
                return xVar;
            }
        });
        this.FDA.setTranslationY(this.FDy);
        this.FDA.setVisibility(8);
        AppMethodBeat.o(120269);
    }

    public static final /* synthetic */ void a(StoryMsgView storyMsgView) {
        AppMethodBeat.i(120272);
        storyMsgView.animateClose();
        AppMethodBeat.o(120272);
    }

    public static final /* synthetic */ void c(StoryMsgView storyMsgView, int i2) {
        AppMethodBeat.i(120274);
        storyMsgView.aZ(i2, true);
        AppMethodBeat.o(120274);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final StoryMsgInputView getCommentInputView() {
        return this.FDF;
    }

    public final void setCommentInputView(StoryMsgInputView storyMsgInputView) {
        AppMethodBeat.i(120262);
        p.h(storyMsgInputView, "<set-?>");
        this.FDF = storyMsgInputView;
        AppMethodBeat.o(120262);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super java.lang.Integer, ? super java.lang.Boolean, kotlin.x>, kotlin.g.a.m<java.lang.Integer, java.lang.Boolean, kotlin.x> */
    public final m<Integer, Boolean, x> getOnPageSelectedCallback() {
        return this.FDG;
    }

    public final void setOnPageSelectedCallback(m<? super Integer, ? super Boolean, x> mVar) {
        this.FDG = mVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.q<? super java.lang.Integer, ? super java.lang.Float, ? super java.lang.Integer, kotlin.x>, kotlin.g.a.q<java.lang.Integer, java.lang.Float, java.lang.Integer, kotlin.x> */
    public final q<Integer, Float, Integer, x> getOnPageScrollCallback() {
        return this.FDH;
    }

    public final void setOnPageScrollCallback(q<? super Integer, ? super Float, ? super Integer, x> qVar) {
        this.FDH = qVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Integer, kotlin.x>, kotlin.g.a.b<java.lang.Integer, kotlin.x> */
    public final kotlin.g.a.b<Integer, x> getOnPageStateCallback() {
        return this.FDI;
    }

    public final void setOnPageStateCallback(kotlin.g.a.b<? super Integer, x> bVar) {
        this.FDI = bVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.q<? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Boolean, kotlin.x>, kotlin.g.a.q<java.lang.Integer, java.lang.Integer, java.lang.Boolean, kotlin.x> */
    public final q<Integer, Integer, Boolean, x> getOnMsgPanelStateCallback() {
        return this.FDJ;
    }

    public final void setOnMsgPanelStateCallback(q<? super Integer, ? super Integer, ? super Boolean, x> qVar) {
        this.FDJ = qVar;
    }

    public final kotlin.g.a.a<Boolean> getOutsideClickListener() {
        return this.FCB;
    }

    public final void setOutsideClickListener(kotlin.g.a.a<Boolean> aVar) {
        this.FCB = aVar;
    }

    public final int getCurPosition() {
        return this.FDK;
    }

    public final void setCurPosition(int i2) {
        this.FDK = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryMsgView(Context context) {
        this(context, null, 0);
        p.h(context, "context");
        AppMethodBeat.i(120270);
        AppMethodBeat.o(120270);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryMsgView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120271);
        AppMethodBeat.o(120271);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ StoryMsgView FDL;

        c(StoryMsgView storyMsgView) {
            this.FDL = storyMsgView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(120258);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgView$initBackArea$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.FDL.getCommentInputView().getInputType() != -1) {
                this.FDL.getCommentInputView().fse();
            } else {
                StoryMsgView.a(this.FDL);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgView$initBackArea$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120258);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ StoryMsgView FDL;

        d(StoryMsgView storyMsgView) {
            this.FDL = storyMsgView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(120259);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgView$initBackArea$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            StoryMsgView.a(this.FDL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgView$initBackArea$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120259);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ StoryMsgView FDL;

        e(StoryMsgView storyMsgView) {
            this.FDL = storyMsgView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(120260);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryMsgView$initBackArea$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.FDL.getCommentInputView().getInputType() != -1) {
                this.FDL.getCommentInputView().fse();
            } else {
                StoryMsgView.a(this.FDL);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryMsgView$initBackArea$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120260);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/story/ui/view/StoryMsgView$animateClose$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-story_release"})
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ StoryMsgView FDL;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(StoryMsgView storyMsgView) {
            this.FDL = storyMsgView;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(120255);
            this.FDL.FDA.setVisibility(8);
            AppMethodBeat.o(120255);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(120256);
            q<Integer, Integer, Boolean, x> onMsgPanelStateCallback = this.FDL.getOnMsgPanelStateCallback();
            if (onMsgPanelStateCallback != null) {
                onMsgPanelStateCallback.d(0, Integer.valueOf(this.FDL.uO.getCurrentItem()), Boolean.valueOf(this.FDL.dJM));
            }
            StoryActionView storyActionView = this.FDL.FDC;
            storyActionView.FBw = false;
            if (storyActionView.dJM) {
                storyActionView.FBo.setBackground(storyActionView.getResources().getDrawable(R.drawable.awl));
                storyActionView.FBp.setBackground(storyActionView.getResources().getDrawable(R.drawable.awl));
                g gVar = storyActionView.FoU;
                if (gVar == null || !gVar.FoO) {
                    storyActionView.a(false, storyActionView.FBp);
                } else {
                    storyActionView.a(true, storyActionView.FBp);
                }
                g gVar2 = storyActionView.FoU;
                if (gVar2 == null || !gVar2.FoN) {
                    storyActionView.a(false, storyActionView.FBo);
                } else {
                    storyActionView.a(true, storyActionView.FBo);
                }
                storyActionView.y(storyActionView.FBo);
                storyActionView.y(storyActionView.FBp);
            } else {
                storyActionView.FBt.setVisibility(0);
            }
            this.FDL.getCommentInputView().fse();
            this.FDL.getCommentInputView().setVisibility(8);
            h hVar = h.FuH;
            h.vU(true);
            h hVar2 = h.FuH;
            h.vV(true);
            AppMethodBeat.o(120256);
        }
    }

    public final void animateClose() {
        AppMethodBeat.i(120263);
        this.FDA.animate().setListener(new a(this)).translationY(this.FDy).start();
        AppMethodBeat.o(120263);
    }

    static /* synthetic */ void a(StoryMsgView storyMsgView, int i2) {
        AppMethodBeat.i(120265);
        storyMsgView.aZ(i2, false);
        AppMethodBeat.o(120265);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/view/StoryMsgView$animateOpen$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "plugin-story_release"})
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ StoryMsgView FDL;
        final /* synthetic */ boolean FDO;
        final /* synthetic */ int puW;

        b(StoryMsgView storyMsgView, boolean z, int i2) {
            this.FDL = storyMsgView;
            this.FDO = z;
            this.puW = i2;
        }

        public final void onAnimationStart(Animator animator) {
            LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList;
            boolean z;
            LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList2;
            LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList3;
            LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList4;
            AppMethodBeat.i(120257);
            if (this.FDO) {
                AppMethodBeat.o(120257);
                return;
            }
            this.FDL.FDA.setVisibility(0);
            if (this.FDL.dJM) {
                this.FDL.uO.setCurrentItem(this.puW);
                StoryMsgListView storyMsgListView = (StoryMsgListView) this.FDL.Fyt.get(0);
                g gVar = this.FDL.FoU;
                storyMsgListView.hA((gVar == null || (linkedList4 = gVar.FoS) == null) ? new ArrayList() : linkedList4);
                StoryMsgListView storyMsgListView2 = (StoryMsgListView) this.FDL.Fyt.get(1);
                g gVar2 = this.FDL.FoU;
                storyMsgListView2.hA((gVar2 == null || (linkedList3 = gVar2.FoQ) == null) ? new ArrayList() : linkedList3);
                if (this.puW == 0) {
                    h hVar = h.FuH;
                    b.a aVar = com.tencent.mm.plugin.story.e.b.FlA;
                    h.aSo(b.a.Jc(this.FDL.edx));
                    h hVar2 = h.FuH;
                    h.vU(false);
                } else if (this.puW == 1) {
                    h hVar3 = h.FuH;
                    b.a aVar2 = com.tencent.mm.plugin.story.e.b.FlA;
                    h.aSp(b.a.Jc(this.FDL.edx));
                    h hVar4 = h.FuH;
                    h.vV(false);
                }
            } else {
                StoryMsgListView storyMsgListView3 = (StoryMsgListView) this.FDL.Fyt.get(this.puW);
                g gVar3 = this.FDL.FoU;
                storyMsgListView3.hA((gVar3 == null || (linkedList2 = gVar3.FoQ) == null) ? new ArrayList() : linkedList2);
                StoryMsgInputView.a(this.FDL.getCommentInputView(), this.FDL.FCq);
                StoryMsgInputView commentInputView = this.FDL.getCommentInputView();
                g gVar4 = this.FDL.FoU;
                if (gVar4 != null) {
                    linkedList = gVar4.FoQ;
                } else {
                    linkedList = null;
                }
                LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList5 = linkedList;
                if (linkedList5 == null || linkedList5.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                commentInputView.setVisibility$2563266(z);
                this.FDL.toUser = this.FDL.Foa;
            }
            StoryActionView storyActionView = this.FDL.FDC;
            int i2 = this.puW;
            storyActionView.FBw = true;
            storyActionView.sTB = i2;
            if (storyActionView.dJM) {
                storyActionView.FBo.setBackground(null);
                storyActionView.FBp.setBackground(null);
                if (i2 == 0) {
                    storyActionView.w(storyActionView.FBo);
                    storyActionView.x(storyActionView.FBp);
                    storyActionView.a(false, storyActionView.FBo);
                } else if (i2 == 1) {
                    storyActionView.w(storyActionView.FBp);
                    storyActionView.x(storyActionView.FBo);
                    storyActionView.a(false, storyActionView.FBp);
                }
            } else {
                storyActionView.FBt.setVisibility(8);
            }
            q<Integer, Integer, Boolean, x> onMsgPanelStateCallback = this.FDL.getOnMsgPanelStateCallback();
            if (onMsgPanelStateCallback != null) {
                onMsgPanelStateCallback.d(3, Integer.valueOf(this.puW), Boolean.valueOf(this.FDL.dJM));
                AppMethodBeat.o(120257);
                return;
            }
            AppMethodBeat.o(120257);
        }
    }

    private final void aZ(int i2, boolean z) {
        AppMethodBeat.i(120264);
        this.FDK = i2;
        this.FDA.animate().setListener(new b(this, z, i2)).translationY(0.0f).start();
        AppMethodBeat.o(120264);
    }

    public final void show() {
        AppMethodBeat.i(120266);
        this.FDC.setVisibility(0);
        if (this.FDA.getVisibility() == 0) {
            aZ(this.FDK, false);
            AppMethodBeat.o(120266);
        } else if (this.dJM) {
            g gVar = this.FoU;
            if (gVar == null || !gVar.FoN) {
                g gVar2 = this.FoU;
                if (gVar2 != null) {
                    if (gVar2.FoO) {
                        aZ(1, false);
                    }
                    AppMethodBeat.o(120266);
                    return;
                }
                AppMethodBeat.o(120266);
                return;
            }
            aZ(0, false);
            AppMethodBeat.o(120266);
        } else {
            g gVar3 = this.FoU;
            if (gVar3 != null) {
                if (gVar3.FoO) {
                    aZ(0, false);
                }
                AppMethodBeat.o(120266);
                return;
            }
            AppMethodBeat.o(120266);
        }
    }

    public final void hide() {
        AppMethodBeat.i(120267);
        this.FDC.setVisibility(8);
        if (this.FDA.getVisibility() != 8) {
            animateClose();
        }
        AppMethodBeat.o(120267);
    }

    public final void fsi() {
        int i2;
        LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList;
        LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList2;
        ArrayList<com.tencent.mm.plugin.story.f.b.a> arrayList;
        LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList3;
        int i3 = 0;
        AppMethodBeat.i(120268);
        if (com.tencent.mm.plugin.story.c.a.e.Fln.fng() && !this.dJM && !this.FDE) {
            Log.i(this.TAG, "post visit");
            this.FDE = true;
            com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
            long j2 = this.edx;
            String str = this.Foa;
            String str2 = this.sessionId;
            String str3 = this.Foa;
            p.h(str, "toUsername");
            p.h(str3, "storyOwner");
            Log.i(com.tencent.mm.plugin.story.f.b.b.TAG, "postVisit: " + j2 + "  " + str + ", false");
            a.e eVar = a.e.FvO;
            com.tencent.mm.plugin.story.f.b.a a2 = com.tencent.mm.plugin.story.f.b.b.a(bVar, j2, str, "", false, str2, str3, 0, a.e.frq(), 128);
            a2.FnY = true;
            g gVar = this.FoU;
            if (!(gVar == null || (linkedList3 = gVar.FoS) == null)) {
                linkedList3.add(a2);
            }
            k kVar = this.FDD;
            if (kVar == null || (arrayList = kVar.Fys) == null) {
                AppMethodBeat.o(120268);
                return;
            }
            arrayList.add(a2);
            AppMethodBeat.o(120268);
        } else if (this.dJM) {
            Log.i(this.TAG, "skip this post visit, but rpt. isSelf:" + this.dJM + " isBubbled:" + this.FDE);
            h hVar = h.FuH;
            b.a aVar = com.tencent.mm.plugin.story.e.b.FlA;
            String Jc = b.a.Jc(this.edx);
            g gVar2 = this.FoU;
            if (gVar2 == null || (linkedList2 = gVar2.FoS) == null) {
                i2 = 0;
            } else {
                i2 = linkedList2.size();
            }
            g gVar3 = this.FoU;
            if (!(gVar3 == null || (linkedList = gVar3.FoQ) == null)) {
                i3 = linkedList.size();
            }
            h.aC(Jc, i2, i3);
            AppMethodBeat.o(120268);
        } else {
            Log.i(this.TAG, "skip this post visit. isSelf:" + this.dJM + " isBubbled:" + this.FDE);
            AppMethodBeat.o(120268);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ StoryMsgView FDL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(StoryMsgView storyMsgView) {
            super(0);
            this.FDL = storyMsgView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(120261);
            if (this.FDL.getCommentInputView().getInputType() != -1) {
                this.FDL.getCommentInputView().fse();
            } else {
                StoryMsgView.a(this.FDL);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(120261);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(StoryMsgView storyMsgView, com.tencent.mm.plugin.story.f.b.a aVar) {
        Integer num;
        LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList;
        LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList2;
        ArrayList<com.tencent.mm.plugin.story.f.b.a> arrayList;
        LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList3;
        LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList4;
        boolean z;
        AppMethodBeat.i(120273);
        com.tencent.mm.plugin.story.f.b.b.Fom.b(aVar.edx, aVar.FnS, storyMsgView.sessionId, aVar.content);
        g gVar = storyMsgView.FoU;
        if (gVar == null || (linkedList4 = gVar.FoQ) == null) {
            num = null;
        } else {
            Iterator<com.tencent.mm.plugin.story.f.b.a> it = linkedList4.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                com.tencent.mm.plugin.story.f.b.a next = it.next();
                if (aVar.FnS == 0 || next.FnS == 0) {
                    z = Util.isEqual(next.content, aVar.content);
                } else {
                    z = next.FnS == aVar.FnS;
                }
                if (z) {
                    break;
                }
                i2++;
            }
            num = Integer.valueOf(i2);
        }
        if (!(num == null || num.intValue() == -1)) {
            g gVar2 = storyMsgView.FoU;
            if (!(gVar2 == null || (linkedList3 = gVar2.FoQ) == null)) {
                linkedList3.remove(num.intValue());
            }
            k kVar = storyMsgView.FDD;
            if (!(kVar == null || (arrayList = kVar.FwY) == null)) {
                arrayList.remove(num.intValue());
            }
            if (storyMsgView.dJM) {
                StoryMsgListView storyMsgListView = storyMsgView.Fyt.get(1);
                g gVar3 = storyMsgView.FoU;
                storyMsgListView.hA((gVar3 == null || (linkedList2 = gVar3.FoQ) == null) ? new ArrayList() : linkedList2);
            } else {
                StoryMsgListView storyMsgListView2 = storyMsgView.Fyt.get(0);
                g gVar4 = storyMsgView.FoU;
                storyMsgListView2.hA((gVar4 == null || (linkedList = gVar4.FoQ) == null) ? new ArrayList() : linkedList);
            }
            g gVar5 = storyMsgView.FoU;
            if (gVar5 != null) {
                storyMsgView.FDC.a(gVar5);
                AppMethodBeat.o(120273);
                return;
            }
        }
        AppMethodBeat.o(120273);
    }
}
