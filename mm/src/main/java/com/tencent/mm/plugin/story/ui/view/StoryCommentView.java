package com.tencent.mm.plugin.story.ui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import kotlin.a.t;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 w2\u00020\u00012\u00020\u0002:\u0001wB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010^\u001a\u00020$2\u0006\u0010_\u001a\u00020\u0013H\u0002J\u0006\u0010`\u001a\u00020$J\b\u0010a\u001a\u00020$H\u0002J\b\u0010b\u001a\u00020$H\u0016J\b\u0010c\u001a\u00020$H\u0002J\b\u0010d\u001a\u00020#H\u0016J\u0006\u0010e\u001a\u00020$J\u0010\u0010f\u001a\u00020$2\u0006\u0010g\u001a\u00020#H\u0002J\u0006\u0010h\u001a\u00020$J\b\u0010i\u001a\u00020$H\u0002J&\u0010j\u001a\u00020$2\u0006\u0010_\u001a\u00020\u001b2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020n2\u0006\u00105\u001a\u00020#J\b\u0010o\u001a\u00020$H\u0016J\b\u0010p\u001a\u00020$H\u0002J\b\u0010q\u001a\u00020$H\u0002J\u0006\u0010r\u001a\u00020$J\u0010\u0010s\u001a\u00020$2\u0006\u0010U\u001a\u00020\nH\u0016J\u0006\u0010t\u001a\u00020$J\u000e\u0010u\u001a\u00020$2\u0006\u0010v\u001a\u00020#R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014`\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R \u0010 \u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\"\u0010=\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R \u0010F\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0!X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u000e¢\u0006\u0002\n\u0000R.\u0010I\u001a\"\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010H0\u0012j\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010H`\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010J\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0010\u0010O\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R7\u0010Q\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\bS\u0012\b\bT\u0012\u0004\b\b(U\u0012\u0004\u0012\u00020$\u0018\u00010RX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u000e\u0010Z\u001a\u00020[X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000¨\u0006x"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/story/contract/CommentContract$IView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarConfetti", "Lcom/tencent/mm/particles/ConfettiManager;", "avatarConfettiIndex", "avatarGenerator", "Lcom/tencent/mm/particles/ConfettiGenerator;", "avatarMap", "Ljava/util/LinkedHashMap;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Landroid/graphics/drawable/LayerDrawable;", "Lkotlin/collections/LinkedHashMap;", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "commentClickHelper", "Lcom/tencent/mm/plugin/story/ui/view/ViewClickHelper;", "commentData", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "commentDialog", "Lcom/tencent/mm/plugin/story/ui/view/CommentInputDialog;", "commentHint", "Landroid/widget/TextView;", "commentInputCallback", "Lkotlin/Function2;", "", "", "", "commentInputSuccess", "commentOtherGroup", "Landroid/view/View;", "commentOthersBubbleIv", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentBubbleView;", "commentOthersInputIv", "commentRecycler", "Landroid/support/v7/widget/RecyclerView;", "commentSelfActionIv", "commentSelfGroup", "contentView", "currState", "generator", "hasConfetti", "hideHintRunnable", "Ljava/lang/Runnable;", "isActive", "isBubbled", "isContact", "isReply", "isSelf", "itemContainer", "Lcom/tencent/mm/plugin/story/ui/view/CommentsContainer;", "maskView", "outsideClickListener", "Lkotlin/Function0;", "getOutsideClickListener", "()Lkotlin/jvm/functions/Function0;", "setOutsideClickListener", "(Lkotlin/jvm/functions/Function0;)V", "penddingState", "replyCommentId", "replyIndex", "replyInputCallback", "saveContent", "", "saveReplyContentCache", "sessionId", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "smallConfetti", "smallGenerator", "stateChangeCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "state", "getStateChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setStateChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "storyId", "", "storyOwner", "toUser", "deleteComment", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "destroy", "emitClickBubble", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "hideItemContainer", "onBack", "pause", "postBubble", "isBtn", "resume", "saveReplyContent", "setup", "scene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "show", "showBubbleHint", "showItemContainer", "switchImageMode", "switchState", "switchVideoMode", "toggleActiveState", "active", "Companion", "plugin-story_release"})
public final class StoryCommentView extends RelativeLayout {
    private static final int[] Cdb = {-372399, -352965, -15616, -7220480, -16268960, -15683841, -15432210, -10197008};
    public static final a FCD = new a((byte) 0);
    public static final String TAG = TAG;
    public final com.tencent.mm.plugin.story.ui.a.e FBS;
    private final m<String, Boolean, x> FBY;
    private kotlin.g.a.b<? super Integer, x> FCA;
    private kotlin.g.a.a<Boolean> FCB;
    private final m<com.tencent.mm.plugin.story.f.b.a, Boolean, x> FCC;
    public final CommentsContainer FCc;
    private final TextView FCd;
    private final StoryCommentBubbleView FCe;
    private final StoryCommentBubbleView FCf;
    private final StoryCommentBubbleView FCg;
    public final View FCh;
    public final View FCi;
    public boolean FCj;
    public com.tencent.mm.plugin.story.f.d.g FCk;
    public int FCl;
    public boolean FCm;
    public c FCn;
    private boolean FCo;
    private boolean FCp;
    public CharSequence FCq;
    public LinkedHashMap<String, CharSequence> FCr;
    private final com.tencent.mm.particles.b FCs;
    private final com.tencent.mm.particles.b FCt;
    private com.tencent.mm.particles.b FCu;
    private boolean FCv;
    private int FCw;
    private int FCx;
    public final LinkedHashMap<com.tencent.mm.plugin.story.f.b.a, LayerDrawable> FCy;
    public final g FCz;
    public String Foa;
    public int Fob;
    private final RecyclerView FwW;
    public final View contentView;
    public boolean dJM;
    public long edx;
    public int iFU;
    public boolean isActive;
    private final View maskView;
    private final Runnable rtb;
    private String sessionId;
    public String toUser;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "content", "", "success", "", "invoke"})
    static final class b extends q implements m<String, Boolean, x> {
        final /* synthetic */ StoryCommentView FCE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(StoryCommentView storyCommentView) {
            super(2);
            this.FCE = storyCommentView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(String str, Boolean bool) {
            StoryCommentInputView storyCommentInputView;
            StoryCommentInputView storyCommentInputView2;
            StoryCommentInputView storyCommentInputView3;
            AppMethodBeat.i(120148);
            String str2 = str;
            boolean booleanValue = bool.booleanValue();
            p.h(str2, "content");
            this.FCE.FCo = booleanValue;
            if (!this.FCE.FCp) {
                if (booleanValue) {
                    this.FCE.FCr.remove(this.FCE.toUser);
                    this.FCE.FCq = null;
                    this.FCE.FCk.commentList.add(com.tencent.mm.plugin.story.f.b.b.Fom.b(this.FCE.edx, str2, this.FCE.toUser, this.FCE.getSessionId(), this.FCE.Foa, this.FCE.Fob));
                    CommentsContainer.a(this.FCE.FCc, this.FCE.FCk.commentList);
                    this.FCE.FCc.restart();
                }
                c cVar = this.FCE.FCn;
                if (cVar != null) {
                    cVar.dismiss();
                }
            } else if (booleanValue) {
                this.FCE.FCr.remove(this.FCE.toUser);
                this.FCE.FCq = null;
                com.tencent.mm.plugin.story.f.b.a b2 = com.tencent.mm.plugin.story.f.b.b.Fom.b(this.FCE.edx, str2, this.FCE.toUser, this.FCE.getSessionId(), this.FCE.Foa, this.FCE.Fob);
                this.FCE.FCk.commentList.add(b2);
                this.FCE.FCk.FoQ.add(b2);
                CommentsContainer.a(this.FCE.FCc, this.FCE.FCk.commentList);
                c cVar2 = this.FCE.FCn;
                if (!(cVar2 == null || (storyCommentInputView3 = cVar2.FAE) == null)) {
                    storyCommentInputView3.aj(this.FCE.FCk.commentList);
                }
                c cVar3 = this.FCE.FCn;
                if (!(cVar3 == null || (storyCommentInputView2 = cVar3.FAE) == null)) {
                    storyCommentInputView2.FBS.notifyDataSetChanged();
                }
                c cVar4 = this.FCE.FCn;
                if (!(cVar4 == null || (storyCommentInputView = cVar4.FAE) == null)) {
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.FCE.FCk.commentList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(storyCommentInputView, a2.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryCommentView$commentInputCallback$1", "invoke", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
                    storyCommentInputView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(storyCommentInputView, "com/tencent/mm/plugin/story/ui/view/StoryCommentView$commentInputCallback$1", "invoke", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
                }
            } else {
                c cVar5 = this.FCE.FCn;
                if (cVar5 != null) {
                    cVar5.dismiss();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(120148);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "isReply", "", "invoke"})
    static final class c extends q implements m<com.tencent.mm.plugin.story.f.b.a, Boolean, x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ StoryCommentView FCE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(StoryCommentView storyCommentView, Context context) {
            super(2);
            this.FCE = storyCommentView;
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(com.tencent.mm.plugin.story.f.b.a aVar, Boolean bool) {
            String string;
            StoryCommentInputView storyCommentInputView;
            AppMethodBeat.i(120150);
            final com.tencent.mm.plugin.story.f.b.a aVar2 = aVar;
            boolean booleanValue = bool.booleanValue();
            p.h(aVar2, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            if (booleanValue) {
                StoryCommentView.g(this.FCE);
                this.FCE.toUser = aVar2.dRL;
                this.FCE.Fob = aVar2.FnS;
                c cVar = this.FCE.FCn;
                if (!(cVar == null || (storyCommentInputView = cVar.FAE) == null)) {
                    storyCommentInputView.a((CharSequence) this.FCE.FCr.get(this.FCE.toUser), this.FCE.toUser, true);
                }
            } else {
                if (aVar2.Fob == 0) {
                    string = this.$context.getResources().getString(R.string.hgs);
                } else {
                    string = this.$context.getResources().getString(R.string.hgu);
                }
                p.g(string, "if (comment.replyComment…lete_reply)\n            }");
                f.a aVar3 = new f.a(this.$context);
                aVar3.bow(string).boA(this.$context.getString(R.string.tf)).apb(-65536).Dq(true);
                aVar3.c(new f.c(this) {
                    /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.c.AnonymousClass1 */
                    final /* synthetic */ c FCI;

                    {
                        this.FCI = r1;
                    }

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(120149);
                        if (z) {
                            StoryCommentView.a(this.FCI.FCE, aVar2);
                        }
                        AppMethodBeat.o(120149);
                    }
                }).show();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(120150);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<View, x> {
        final /* synthetic */ StoryCommentView FCE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(StoryCommentView storyCommentView) {
            super(1);
            this.FCE = storyCommentView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(View view) {
            AppMethodBeat.i(120152);
            p.h(view, LocaleUtil.ITALIAN);
            StoryCommentView.a(this.FCE, false);
            x xVar = x.SXb;
            AppMethodBeat.o(120152);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryCommentView(final Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120162);
        this.Foa = "";
        this.FCk = new com.tencent.mm.plugin.story.f.d.g();
        this.iFU = 2;
        this.FCl = 2;
        this.FCr = new LinkedHashMap<>();
        this.FCv = true;
        this.toUser = "";
        this.FCx = -1;
        this.FCy = new LinkedHashMap<>();
        View.inflate(context, R.layout.bzt, this);
        View findViewById = findViewById(R.id.i8l);
        p.g(findViewById, "findViewById(R.id.story_comment_item_container)");
        this.FCc = (CommentsContainer) findViewById;
        View findViewById2 = findViewById(R.id.i8z);
        p.g(findViewById2, "findViewById(R.id.story_comment_recycler)");
        this.FwW = (RecyclerView) findViewById2;
        View findViewById3 = findViewById(R.id.i8u);
        p.g(findViewById3, "findViewById(R.id.story_comment_mask_view)");
        this.maskView = findViewById3;
        View findViewById4 = findViewById(R.id.i8_);
        p.g(findViewById4, "findViewById(R.id.story_comment_hint)");
        this.FCd = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.i90);
        p.g(findViewById5, "findViewById(R.id.story_comment_root_view)");
        this.contentView = findViewById5;
        View findViewById6 = findViewById(R.id.i92);
        p.g(findViewById6, "findViewById(R.id.story_comment_self_bubble_icon)");
        this.FCe = (StoryCommentBubbleView) findViewById6;
        View findViewById7 = findViewById(R.id.i8w);
        p.g(findViewById7, "findViewById(R.id.story_…mment_others_bubble_icon)");
        this.FCf = (StoryCommentBubbleView) findViewById7;
        View findViewById8 = findViewById(R.id.i8x);
        p.g(findViewById8, "findViewById(R.id.story_…ment_others_comment_icon)");
        this.FCg = (StoryCommentBubbleView) findViewById8;
        View findViewById9 = findViewById(R.id.i91);
        p.g(findViewById9, "findViewById(R.id.story_comment_self_action_group)");
        this.FCh = findViewById9;
        View findViewById10 = findViewById(R.id.i8v);
        p.g(findViewById10, "findViewById(R.id.story_…ment_others_action_group)");
        this.FCi = findViewById10;
        com.tencent.mm.ac.d.f(this.FCd);
        this.maskView.setVisibility(8);
        this.FCc.setItemClickListener(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.AnonymousClass1 */
            final /* synthetic */ StoryCommentView FCE;

            {
                this.FCE = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(120132);
                this.FCE.xN(3);
                x xVar = x.SXb;
                AppMethodBeat.o(120132);
                return xVar;
            }
        });
        this.FCe.setImageDrawable(ar.m(context, R.raw.icons_filled_chats, -1));
        this.FCg.setImageDrawable(ar.m(context, R.raw.icons_filled_chats, -1));
        this.FBS = new com.tencent.mm.plugin.story.ui.a.e();
        this.FwW.setLayoutManager(new LinearLayoutManager());
        this.FwW.setAdapter(this.FBS);
        this.FwW.setVisibility(8);
        this.FwW.setFocusable(false);
        this.FBS.FxO = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.AnonymousClass6 */
            final /* synthetic */ StoryCommentView FCE;

            {
                this.FCE = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(120137);
                this.FCE.xN(2);
                x xVar = x.SXb;
                AppMethodBeat.o(120137);
                return xVar;
            }
        };
        this.FBS.FxN = new m<com.tencent.mm.plugin.story.f.b.a, Boolean, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.AnonymousClass7 */
            final /* synthetic */ StoryCommentView FCE;

            {
                this.FCE = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.story.f.b.a aVar, Boolean bool) {
                String string;
                AppMethodBeat.i(120139);
                final com.tencent.mm.plugin.story.f.b.a aVar2 = aVar;
                boolean booleanValue = bool.booleanValue();
                p.h(aVar2, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
                if (booleanValue) {
                    this.FCE.toUser = aVar2.dRL;
                    this.FCE.Fob = aVar2.FnS;
                    this.FCE.FCx = this.FCE.FCk.commentList.indexOf(aVar2);
                    this.FCE.xN(5);
                } else {
                    if (aVar2.Fob == 0) {
                        string = context.getResources().getString(R.string.hgs);
                    } else {
                        string = context.getResources().getString(R.string.hgu);
                    }
                    p.g(string, "if (comment.replyComment…_reply)\n                }");
                    f.a aVar3 = new f.a(context);
                    aVar3.bow(string).boA(context.getString(R.string.tf)).apb(-65536).Dq(true);
                    aVar3.c(new f.c(this) {
                        /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.AnonymousClass7.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass7 FCF;

                        {
                            this.FCF = r1;
                        }

                        @Override // com.tencent.mm.ui.widget.a.f.c
                        public final void e(boolean z, String str) {
                            AppMethodBeat.i(120138);
                            if (z) {
                                StoryCommentView.a(this.FCF.FCE, aVar2);
                            }
                            AppMethodBeat.o(120138);
                        }
                    }).show();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120139);
                return xVar;
            }
        };
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.bo_);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, 48);
        final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeResource, fromDPToPix, fromDPToPix, true);
        this.FCs = new com.tencent.mm.particles.b() {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.AnonymousClass8 */

            @Override // com.tencent.mm.particles.b
            public final /* synthetic */ com.tencent.mm.particles.a.b a(Random random) {
                AppMethodBeat.i(120140);
                Bitmap bitmap = createScaledBitmap;
                p.g(bitmap, "scaled");
                b bVar = new b(bitmap);
                AppMethodBeat.o(120140);
                return bVar;
            }
        };
        this.FCt = new com.tencent.mm.particles.b() {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.AnonymousClass9 */

            @Override // com.tencent.mm.particles.b
            public final /* synthetic */ com.tencent.mm.particles.a.b a(Random random) {
                AppMethodBeat.i(120141);
                Bitmap bitmap = createScaledBitmap;
                p.g(bitmap, "scaled");
                d dVar = new d(bitmap);
                AppMethodBeat.o(120141);
                return dVar;
            }
        };
        this.FCu = new com.tencent.mm.particles.b(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.AnonymousClass10 */
            final /* synthetic */ StoryCommentView FCE;

            {
                this.FCE = r1;
            }

            @Override // com.tencent.mm.particles.b
            public final /* synthetic */ com.tencent.mm.particles.a.b a(Random random) {
                Object invoke;
                AppMethodBeat.i(120142);
                this.FCE.FCw %= this.FCE.FCy.size();
                Set entrySet = this.FCE.FCy.entrySet();
                p.g(entrySet, "avatarMap.entries");
                Set set = entrySet;
                int i2 = this.FCE.FCw;
                p.h(set, "$this$elementAt");
                if (set instanceof List) {
                    invoke = ((List) set).get(i2);
                } else {
                    t.b bVar = new t.b(i2);
                    p.h(set, "$this$elementAtOrElse");
                    p.h(bVar, "defaultValue");
                    if (set instanceof List) {
                        List list = (List) set;
                        invoke = (i2 < 0 || i2 > kotlin.a.j.kq(list)) ? bVar.invoke(Integer.valueOf(i2)) : list.get(i2);
                    } else {
                        if (i2 >= 0) {
                            Iterator it = set.iterator();
                            int i3 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Object next = it.next();
                                int i4 = i3 + 1;
                                if (i2 == i3) {
                                    invoke = next;
                                    break;
                                }
                                i3 = i4;
                            }
                        }
                        invoke = bVar.invoke(Integer.valueOf(i2));
                    }
                }
                p.g(invoke, "avatarMap.entries.elementAt(avatarConfettiIndex)");
                Map.Entry entry = (Map.Entry) invoke;
                boolean z = ((com.tencent.mm.plugin.story.f.b.a) entry.getKey()).FnW;
                Object value = entry.getValue();
                p.g(value, "entry.value");
                LayerDrawable layerDrawable = (LayerDrawable) value;
                if (z) {
                    layerDrawable.getDrawable(0).setColorFilter(context.getResources().getColor(R.color.Indigo), PorterDuff.Mode.SRC_ATOP);
                    ((com.tencent.mm.plugin.story.f.b.a) entry.getKey()).FnW = false;
                } else {
                    layerDrawable.getDrawable(0).setColorFilter(context.getResources().getColor(R.color.a_s), PorterDuff.Mode.SRC_ATOP);
                }
                this.FCE.FCw++;
                a aVar = new a(layerDrawable);
                AppMethodBeat.o(120142);
                return aVar;
            }
        };
        this.rtb = new Runnable(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.AnonymousClass11 */
            final /* synthetic */ StoryCommentView FCE;

            {
                this.FCE = r1;
            }

            public final void run() {
                AppMethodBeat.i(120144);
                this.FCE.FCd.animate().cancel();
                this.FCE.FCd.animate().alpha(0.0f).withEndAction(new Runnable(this) {
                    /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.AnonymousClass11.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass11 FCH;

                    {
                        this.FCH = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(120143);
                        this.FCH.FCE.FCd.setVisibility(8);
                        AppMethodBeat.o(120143);
                    }
                }).start();
                AppMethodBeat.o(120144);
            }
        };
        this.FCe.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.AnonymousClass12 */
            final /* synthetic */ StoryCommentView FCE;

            {
                this.FCE = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120145);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!this.FCE.FCk.commentList.isEmpty()) {
                    if (this.FCE.iFU == 3) {
                        this.FCE.xN(2);
                        com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
                        com.tencent.mm.plugin.story.h.h.aaT(1);
                    } else {
                        this.FCE.xN(3);
                        com.tencent.mm.plugin.story.h.h hVar2 = com.tencent.mm.plugin.story.h.h.FuH;
                        com.tencent.mm.plugin.story.h.h.aaT(2);
                        com.tencent.mm.plugin.story.h.h hVar3 = com.tencent.mm.plugin.story.h.h.FuH;
                        com.tencent.mm.plugin.story.h.h.fqm().sj(4);
                        com.tencent.mm.plugin.story.h.h hVar4 = com.tencent.mm.plugin.story.h.h.FuH;
                        com.tencent.mm.plugin.story.h.h.fqm().wR(String.valueOf(this.FCE.edx));
                        com.tencent.mm.plugin.story.h.h hVar5 = com.tencent.mm.plugin.story.h.h.FuH;
                        com.tencent.mm.plugin.story.h.h.fqn();
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120145);
            }
        });
        this.FCf.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.AnonymousClass13 */
            final /* synthetic */ StoryCommentView FCE;

            {
                this.FCE = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120146);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i(StoryCommentView.TAG, "CommentBubble click");
                StoryCommentView.a(this.FCE, true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120146);
            }
        });
        this.FCg.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.AnonymousClass2 */
            final /* synthetic */ StoryCommentView FCE;

            {
                this.FCE = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120133);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i(StoryCommentView.TAG, "commentEditGroup click");
                this.FCE.xN(1);
                com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.aaT(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120133);
            }
        });
        this.FCz = new g(this);
        this.FCz.FEm = new kotlin.g.a.b<View, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.AnonymousClass3 */
            final /* synthetic */ StoryCommentView FCE;

            {
                this.FCE = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(View view) {
                AppMethodBeat.i(120134);
                p.h(view, LocaleUtil.ITALIAN);
                if (this.FCE.iFU == 3) {
                    this.FCE.xN(2);
                } else {
                    kotlin.g.a.a<Boolean> outsideClickListener = this.FCE.getOutsideClickListener();
                    if (outsideClickListener != null) {
                        outsideClickListener.invoke();
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(120134);
                return xVar;
            }
        };
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.AnonymousClass4 */
            final /* synthetic */ StoryCommentView FCE;

            {
                this.FCE = r1;
            }

            public final void onClick(View view) {
                boolean z;
                AppMethodBeat.i(120135);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g gVar = this.FCE.FCz;
                gVar.ipv = true;
                gVar.FEp++;
                if (gVar.FEp == 1 && gVar.FEn == null && gVar.FEo == null) {
                    z = true;
                } else if (gVar.FEp == 2 && gVar.FEo == null) {
                    z = true;
                } else if (gVar.FEp == 3) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    gVar.fsj();
                }
                MMHandlerThread.removeRunnable(gVar.FEr);
                MMHandlerThread.postToMainThreadDelayed(gVar.FEr, gVar.FEq);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120135);
            }
        });
        setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentView.AnonymousClass5 */
            final /* synthetic */ StoryCommentView FCE;

            {
                this.FCE = r1;
            }

            public final boolean onLongClick(View view) {
                boolean booleanValue;
                Boolean invoke;
                AppMethodBeat.i(120136);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentView$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                if (this.FCE.iFU == 3) {
                    booleanValue = false;
                } else {
                    kotlin.g.a.a<Boolean> outsideClickListener = this.FCE.getOutsideClickListener();
                    booleanValue = (outsideClickListener == null || (invoke = outsideClickListener.invoke()) == null) ? false : invoke.booleanValue();
                }
                com.tencent.mm.hellhoundlib.a.a.a(booleanValue, this, "com/tencent/mm/plugin/story/ui/view/StoryCommentView$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(120136);
                return booleanValue;
            }
        });
        int aD = au.aD(context);
        Log.i(TAG, "LogStory: navigationHeight ".concat(String.valueOf(aD)));
        findViewById(R.id.i85).setPadding(0, 0, 0, aD);
        this.FBY = new b(this);
        this.FCC = new c(this, context);
        AppMethodBeat.o(120162);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryCommentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120163);
        AppMethodBeat.o(120163);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryCommentView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(120164);
        AppMethodBeat.o(120164);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView$Companion;", "", "()V", "ColorArray", "", "getColorArray", "()[I", "TAG", "", "TypeAll", "", "TypeReply", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(120165);
        AppMethodBeat.o(120165);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Integer, kotlin.x>, kotlin.g.a.b<java.lang.Integer, kotlin.x> */
    public final kotlin.g.a.b<Integer, x> getStateChangeCallback() {
        return this.FCA;
    }

    public final void setStateChangeCallback(kotlin.g.a.b<? super Integer, x> bVar) {
        this.FCA = bVar;
    }

    public final kotlin.g.a.a<Boolean> getOutsideClickListener() {
        return this.FCB;
    }

    public final void setOutsideClickListener(kotlin.g.a.a<Boolean> aVar) {
        this.FCB = aVar;
    }

    public final void show() {
        AppMethodBeat.i(120159);
        this.contentView.setVisibility(0);
        if (this.FCl == 2) {
            if (this.contentView.getVisibility() == 0 && this.iFU == 2 && this.FCc.dLD) {
                this.FCk.FnW = false;
                this.FCc.resume();
                if (!this.dJM && this.FCj) {
                    com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh, "storage()");
                    int i2 = aAh.azQ().getInt(ar.a.USERINFO_STORY_BUBBLE_COUNT_INT, 0);
                    if (i2 < 3) {
                        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh2, "storage()");
                        aAh2.azQ().set(ar.a.USERINFO_STORY_BUBBLE_COUNT_INT, Integer.valueOf(i2 + 1));
                        this.FCd.animate().cancel();
                        this.FCd.setVisibility(0);
                        this.FCd.animate().alpha(1.0f).start();
                        MMHandlerThread.removeRunnable(this.rtb);
                        MMHandlerThread.postToMainThreadDelayed(this.rtb, 3000);
                    }
                }
            }
            AppMethodBeat.o(120159);
            return;
        }
        if (this.FCl == 3) {
            xN(3);
            RecyclerView.LayoutManager layoutManager = this.FwW.getLayoutManager();
            if (layoutManager != null) {
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.FCk.commentList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(layoutManager, a2.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
                layoutManager.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(layoutManager, "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
                AppMethodBeat.o(120159);
                return;
            }
        }
        AppMethodBeat.o(120159);
    }

    public final void xN(int i2) {
        StoryCommentInputView storyCommentInputView;
        StoryCommentInputView storyCommentInputView2;
        StoryCommentInputView storyCommentInputView3;
        StoryCommentInputView storyCommentInputView4;
        StoryCommentInputView storyCommentInputView5;
        StoryCommentInputView storyCommentInputView6;
        StoryCommentInputView storyCommentInputView7;
        StoryCommentInputView storyCommentInputView8;
        StoryCommentInputView storyCommentInputView9;
        StoryCommentInputView storyCommentInputView10;
        StoryCommentInputView storyCommentInputView11;
        StoryCommentInputView storyCommentInputView12;
        StoryCommentInputView storyCommentInputView13;
        StoryCommentInputView storyCommentInputView14;
        StoryCommentInputView storyCommentInputView15;
        StoryCommentInputView storyCommentInputView16;
        AppMethodBeat.i(120161);
        Log.i(TAG, "switchState " + i2 + ' ' + Util.getStack());
        if (this.iFU == i2) {
            AppMethodBeat.o(120161);
            return;
        }
        this.iFU = i2;
        this.FCl = i2;
        switch (i2) {
            case 1:
                this.toUser = this.Foa;
                this.Fob = 0;
                this.FCc.pause();
                this.FwW.setVisibility(8);
                this.FCc.setVisibility(8);
                this.FCp = false;
                Context context = getContext();
                p.g(context, "context");
                this.FCn = new c(context);
                c cVar = this.FCn;
                if (!(cVar == null || (storyCommentInputView16 = cVar.FAE) == null)) {
                    storyCommentInputView16.setHostStory(this.FBS.FxM);
                }
                c cVar2 = this.FCn;
                if (!(cVar2 == null || (storyCommentInputView15 = cVar2.FAE) == null)) {
                    storyCommentInputView15.setCommentInputCallback(this.FBY);
                }
                c cVar3 = this.FCn;
                if (!(cVar3 == null || (storyCommentInputView14 = cVar3.FAE) == null)) {
                    storyCommentInputView14.setCommentReplyCallback(this.FCC);
                }
                c cVar4 = this.FCn;
                if (!(cVar4 == null || (storyCommentInputView13 = cVar4.FAE) == null)) {
                    StoryCommentInputView.a(storyCommentInputView13, this.FCq);
                }
                c cVar5 = this.FCn;
                if (!(cVar5 == null || (storyCommentInputView12 = cVar5.FAE) == null)) {
                    storyCommentInputView12.frZ();
                }
                c cVar6 = this.FCn;
                if (!(cVar6 == null || (storyCommentInputView11 = cVar6.FAE) == null)) {
                    storyCommentInputView11.aj(this.FCk.commentList);
                }
                c cVar7 = this.FCn;
                if (!(cVar7 == null || (storyCommentInputView10 = cVar7.FAE) == null)) {
                    storyCommentInputView10.FBS.notifyDataSetChanged();
                }
                c cVar8 = this.FCn;
                if (!(cVar8 == null || (storyCommentInputView9 = cVar8.FAE) == null)) {
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.FCk.commentList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(storyCommentInputView9, a2.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "switchState", "(I)V", "Undefined", "scrollToPosition", "(I)V");
                    storyCommentInputView9.scrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(storyCommentInputView9, "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "switchState", "(I)V", "Undefined", "scrollToPosition", "(I)V");
                }
                c cVar9 = this.FCn;
                if (cVar9 != null) {
                    cVar9.show();
                }
                this.FCo = false;
                c cVar10 = this.FCn;
                if (cVar10 != null) {
                    cVar10.setOnDismissListener(new f(this));
                    break;
                }
                break;
            case 2:
                this.toUser = this.Foa;
                this.Fob = 0;
                if (this.dJM) {
                    this.FCh.setVisibility(0);
                    this.FCi.setVisibility(8);
                } else {
                    this.FCh.setVisibility(8);
                    this.FCi.setVisibility(0);
                }
                this.maskView.animate().cancel();
                this.maskView.animate().alpha(0.0f).start();
                this.FwW.animate().alpha(0.0f).withEndAction(new i(this)).start();
                this.FCc.animate().cancel();
                this.FCc.setVisibility(0);
                this.FCc.setAlpha(1.0f);
                if (this.isActive) {
                    this.FCc.resume();
                }
                c cVar11 = this.FCn;
                if (cVar11 != null) {
                    cVar11.dismiss();
                    break;
                }
                break;
            case 3:
                this.toUser = this.Foa;
                this.Fob = 0;
                this.maskView.animate().cancel();
                this.maskView.setVisibility(0);
                this.maskView.animate().alpha(1.0f).start();
                this.FCc.animate().alpha(0.0f).withEndAction(new j(this)).start();
                this.FwW.animate().cancel();
                this.FwW.setVisibility(0);
                this.FwW.setAlpha(1.0f);
                this.FBS.hw(this.FCk.commentList);
                this.FBS.notifyDataSetChanged();
                this.FBS.FxL = true;
                this.FwW.setAdapter(this.FBS);
                RecyclerView recyclerView = this.FwW;
                com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(this.FCk.commentList.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a3.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "switchState", "(I)V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView.scrollToPosition(((Integer) a3.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "switchState", "(I)V", "Undefined", "scrollToPosition", "(I)V");
                this.FwW.post(new k(this));
                break;
            case 5:
                this.FCc.pause();
                this.FCc.setVisibility(8);
                this.FwW.animate().alpha(0.0f).withEndAction(new g(this)).start();
                this.FCp = true;
                Context context2 = getContext();
                p.g(context2, "context");
                this.FCn = new c(context2);
                c cVar12 = this.FCn;
                if (!(cVar12 == null || (storyCommentInputView8 = cVar12.FAE) == null)) {
                    storyCommentInputView8.setHostStory(this.FBS.FxM);
                }
                c cVar13 = this.FCn;
                if (!(cVar13 == null || (storyCommentInputView7 = cVar13.FAE) == null)) {
                    storyCommentInputView7.setCommentInputCallback(this.FBY);
                }
                c cVar14 = this.FCn;
                if (!(cVar14 == null || (storyCommentInputView6 = cVar14.FAE) == null)) {
                    storyCommentInputView6.setCommentReplyCallback(this.FCC);
                }
                c cVar15 = this.FCn;
                if (!(cVar15 == null || (storyCommentInputView5 = cVar15.FAE) == null)) {
                    storyCommentInputView5.a(this.FCr.get(this.toUser), this.toUser, true);
                }
                c cVar16 = this.FCn;
                if (!(cVar16 == null || (storyCommentInputView4 = cVar16.FAE) == null)) {
                    storyCommentInputView4.frZ();
                }
                c cVar17 = this.FCn;
                if (!(cVar17 == null || (storyCommentInputView3 = cVar17.FAE) == null)) {
                    storyCommentInputView3.aj(this.FCk.commentList);
                }
                c cVar18 = this.FCn;
                if (!(cVar18 == null || (storyCommentInputView2 = cVar18.FAE) == null)) {
                    storyCommentInputView2.FBS.notifyDataSetChanged();
                }
                c cVar19 = this.FCn;
                if (!(cVar19 == null || (storyCommentInputView = cVar19.FAE) == null)) {
                    com.tencent.mm.hellhoundlib.b.a a4 = com.tencent.mm.hellhoundlib.b.c.a(this.FCx, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(storyCommentInputView, a4.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "switchState", "(I)V", "Undefined", "scrollToPosition", "(I)V");
                    storyCommentInputView.scrollToPosition(((Integer) a4.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(storyCommentInputView, "com/tencent/mm/plugin/story/ui/view/StoryCommentView", "switchState", "(I)V", "Undefined", "scrollToPosition", "(I)V");
                }
                c cVar20 = this.FCn;
                if (cVar20 != null) {
                    cVar20.show();
                }
                this.FCo = false;
                c cVar21 = this.FCn;
                if (cVar21 != null) {
                    cVar21.setOnDismissListener(new h(this));
                    break;
                }
                break;
        }
        kotlin.g.a.b<? super Integer, x> bVar = this.FCA;
        if (bVar != null) {
            bVar.invoke(Integer.valueOf(this.iFU));
            AppMethodBeat.o(120161);
            return;
        }
        AppMethodBeat.o(120161);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    public static final class f implements DialogInterface.OnDismissListener {
        final /* synthetic */ StoryCommentView FCE;

        f(StoryCommentView storyCommentView) {
            this.FCE = storyCommentView;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            StoryCommentInputView storyCommentInputView;
            StoryCommentInputView storyCommentInputView2;
            AppMethodBeat.i(120153);
            this.FCE.xN(2);
            if (!this.FCE.FCo) {
                StoryCommentView storyCommentView = this.FCE;
                c cVar = this.FCE.FCn;
                storyCommentView.FCq = (cVar == null || (storyCommentInputView2 = cVar.FAE) == null) ? null : storyCommentInputView2.getContent();
            }
            c cVar2 = this.FCE.FCn;
            if (cVar2 == null || (storyCommentInputView = cVar2.FAE) == null) {
                AppMethodBeat.o(120153);
                return;
            }
            storyCommentInputView.destroy();
            AppMethodBeat.o(120153);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ StoryCommentView FCE;

        g(StoryCommentView storyCommentView) {
            this.FCE = storyCommentView;
        }

        public final void run() {
            AppMethodBeat.i(120154);
            this.FCE.FwW.setVisibility(8);
            this.FCE.FwW.setAlpha(1.0f);
            AppMethodBeat.o(120154);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    public static final class h implements DialogInterface.OnDismissListener {
        final /* synthetic */ StoryCommentView FCE;

        h(StoryCommentView storyCommentView) {
            this.FCE = storyCommentView;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            StoryCommentInputView storyCommentInputView;
            AppMethodBeat.i(120155);
            if (!this.FCE.FCo) {
                StoryCommentView.g(this.FCE);
            }
            this.FCE.xN(2);
            c cVar = this.FCE.FCn;
            if (cVar == null || (storyCommentInputView = cVar.FAE) == null) {
                AppMethodBeat.o(120155);
                return;
            }
            storyCommentInputView.destroy();
            AppMethodBeat.o(120155);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class i implements Runnable {
        final /* synthetic */ StoryCommentView FCE;

        i(StoryCommentView storyCommentView) {
            this.FCE = storyCommentView;
        }

        public final void run() {
            AppMethodBeat.i(120156);
            this.FCE.FwW.setVisibility(8);
            this.FCE.FwW.setAlpha(1.0f);
            AppMethodBeat.o(120156);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class j implements Runnable {
        final /* synthetic */ StoryCommentView FCE;

        j(StoryCommentView storyCommentView) {
            this.FCE = storyCommentView;
        }

        public final void run() {
            AppMethodBeat.i(120157);
            this.FCE.FCc.pause();
            this.FCE.FCc.setAlpha(1.0f);
            AppMethodBeat.o(120157);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class k implements Runnable {
        final /* synthetic */ StoryCommentView FCE;

        k(StoryCommentView storyCommentView) {
            this.FCE = storyCommentView;
        }

        public final void run() {
            AppMethodBeat.i(120158);
            this.FCE.FBS.FxL = false;
            Log.i(StoryCommentView.TAG, "LogStory: comment recycler count is " + this.FCE.FwW.getChildCount());
            int childCount = this.FCE.FwW.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.FCE.FwW.getChildAt(i2);
                if (childAt instanceof CommentItemView) {
                    CommentItemView commentItemView = (CommentItemView) childAt;
                    int childCount2 = this.FCE.FwW.getChildCount() - i2;
                    long j2 = ((long) childCount2) * 30;
                    float fromDPToPix = ((float) (childCount2 + 1)) * ((float) com.tencent.mm.cb.a.fromDPToPix(commentItemView.getContext(), 16));
                    commentItemView.setAlpha(0.0f);
                    commentItemView.setTranslationY(fromDPToPix);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(commentItemView, "translationY", fromDPToPix, 0.0f);
                    p.g(ofFloat, "transAnim");
                    ofFloat.setDuration(150L);
                    ofFloat.setStartDelay(j2);
                    ofFloat.start();
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(commentItemView, "alpha", 0.0f, 1.0f);
                    p.g(ofFloat2, "alphaAnim");
                    ofFloat2.setDuration(150L);
                    ofFloat2.setStartDelay(j2);
                    ofFloat2.start();
                }
            }
            AppMethodBeat.o(120158);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ StoryCommentView FCE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(StoryCommentView storyCommentView) {
            super(0);
            this.FCE = storyCommentView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(120151);
            Log.i(StoryCommentView.TAG, "itemContainer.onLoop callback currState:" + this.FCE.iFU + ", itemContainer.isPause:" + this.FCE.FCc.dLD + ' ' + this.FCE.FCc);
            CommentsContainer.a(this.FCE.FCc, this.FCE.FCk.commentList);
            if (this.FCE.iFU == 2 && !this.FCE.FCc.dLD) {
                this.FCE.FCc.setOnLoop(null);
                this.FCE.FCc.pause();
                this.FCE.FCc.restart();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(120151);
            return xVar;
        }
    }

    public final void hide() {
        AppMethodBeat.i(120160);
        this.FCc.pause();
        this.contentView.setVisibility(8);
        AppMethodBeat.o(120160);
    }

    public static final /* synthetic */ void a(StoryCommentView storyCommentView, boolean z) {
        boolean z2;
        AppMethodBeat.i(120166);
        if (storyCommentView.dJM || !storyCommentView.FCj || storyCommentView.FCm) {
            if (z) {
                com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.aaT(6);
            }
            AppMethodBeat.o(120166);
            return;
        }
        storyCommentView.FCm = true;
        com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
        long j2 = storyCommentView.edx;
        String str = storyCommentView.toUser;
        if (!z) {
            z2 = true;
        } else {
            z2 = false;
        }
        String str2 = storyCommentView.sessionId;
        String str3 = storyCommentView.Foa;
        p.h(str, "toUsername");
        p.h(str3, "storyOwner");
        Log.i(com.tencent.mm.plugin.story.f.b.b.TAG, "postBubble: " + j2 + "  " + str + ", " + z2);
        com.tencent.mm.plugin.story.f.b.a a2 = com.tencent.mm.plugin.story.f.b.b.a(bVar, j2, str, "", z2, str2, str3, 0, 0, 384);
        a2.FnY = true;
        storyCommentView.FCk.commentList.add(a2);
        CommentsContainer.a(storyCommentView.FCc, storyCommentView.FCk.commentList);
        storyCommentView.FCc.restart();
        if (z) {
            com.tencent.mm.plugin.story.h.h hVar2 = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.aaT(5);
            AppMethodBeat.o(120166);
            return;
        }
        com.tencent.mm.plugin.story.h.h hVar3 = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.aaT(7);
        AppMethodBeat.o(120166);
    }

    public static final /* synthetic */ void g(StoryCommentView storyCommentView) {
        StoryCommentInputView storyCommentInputView;
        AppMethodBeat.i(120167);
        LinkedHashMap<String, CharSequence> linkedHashMap = storyCommentView.FCr;
        String str = storyCommentView.toUser;
        c cVar = storyCommentView.FCn;
        linkedHashMap.put(str, (cVar == null || (storyCommentInputView = cVar.FAE) == null) ? null : storyCommentInputView.getContent());
        if (storyCommentView.FCr.size() > 3) {
            LinkedHashMap<String, CharSequence> linkedHashMap2 = storyCommentView.FCr;
            Set<String> keySet = storyCommentView.FCr.keySet();
            p.g(keySet, "saveReplyContentCache.keys");
            String str2 = (String) kotlin.a.j.f(keySet);
            if (str2 == null) {
                str2 = "";
            }
            linkedHashMap2.remove(str2);
        }
        AppMethodBeat.o(120167);
    }

    public static final /* synthetic */ void a(StoryCommentView storyCommentView, com.tencent.mm.plugin.story.f.b.a aVar) {
        StoryCommentInputView storyCommentInputView;
        StoryCommentInputView storyCommentInputView2;
        boolean z;
        AppMethodBeat.i(120168);
        com.tencent.mm.plugin.story.f.b.b.Fom.b(aVar.edx, aVar.FnS, storyCommentView.sessionId, aVar.content);
        Iterator<com.tencent.mm.plugin.story.f.b.a> it = storyCommentView.FCk.commentList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            com.tencent.mm.plugin.story.f.b.a next = it.next();
            if (next.FnS == 0) {
                z = Util.isEqual(next.content, aVar.content);
            } else {
                z = next.FnS == aVar.FnS;
            }
            if (z) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            storyCommentView.FCk.commentList.remove(i2);
            CommentsContainer.a(storyCommentView.FCc, storyCommentView.FCk.commentList);
            storyCommentView.FBS.hw(storyCommentView.FCk.commentList);
            c cVar = storyCommentView.FCn;
            if (!(cVar == null || (storyCommentInputView2 = cVar.FAE) == null)) {
                storyCommentInputView2.aj(storyCommentView.FCk.commentList);
            }
            c cVar2 = storyCommentView.FCn;
            if (!(cVar2 == null || (storyCommentInputView = cVar2.FAE) == null)) {
                storyCommentInputView.FBS.notifyDataSetChanged();
            }
            storyCommentView.FBS.ck(i2);
        }
        AppMethodBeat.o(120168);
    }
}
