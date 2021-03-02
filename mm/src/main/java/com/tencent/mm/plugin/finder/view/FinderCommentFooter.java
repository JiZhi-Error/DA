package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ad;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0004\u0001\u0001B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010u\u001a\u00020\u0011H\u0002J$\u0010v\u001a\u00020\u000b2\b\u0010w\u001a\u0004\u0018\u0001022\u0006\u0010x\u001a\u0002022\b\u0010y\u001a\u0004\u0018\u00010;H\u0002J \u0010z\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u001d2\u0006\u0010{\u001a\u00020|2\b\b\u0002\u0010}\u001a\u00020\u0011J \u0010~\u001a\u00020\u000b2\u0006\u0010w\u001a\u0002022\u0006\u0010\u001a\u0002022\b\u0010y\u001a\u0004\u0018\u00010;J!\u0010\u0001\u001a\u00020\u000b2\u0006\u0010w\u001a\u0002022\u0006\u0010\u001a\u0002022\b\u0010y\u001a\u0004\u0018\u00010;J\u0010\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u000202J\u0015\u0010\u0001\u001a\u00020\u000b2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0012\u0010\u0001\u001a\u0002022\u0007\u0010\u0001\u001a\u000202H\u0002J\u0007\u0010\u0001\u001a\u00020SJ1\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u00172\u0007\u0010\u0001\u001a\u00020\u001d2\u0014\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000b0\u0001H\u0002J\t\u0010\u0001\u001a\u00020\u000bH\u0014J\u0007\u0010\u0001\u001a\u00020\u000bJ\u0012\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u0011H\u0002J\u001b\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u001d2\u0007\u0010\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0001\u001a\u00020\u000bH\u0002J\u0012\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u0011H\u0002J\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0010\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u0011R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u001d@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\u001a\u0010,\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R\u001a\u0010.\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015R\u000e\u00100\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0019\"\u0004\bH\u0010\u001bR\u001a\u0010I\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001f\"\u0004\bK\u0010!R$\u0010L\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u001d@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001f\"\u0004\bN\u0010!R\u001a\u0010O\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0013\"\u0004\bQ\u0010\u0015R\u001a\u0010R\u001a\u00020SX.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020YX.¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u000e\u0010^\u001a\u00020_X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010`\u001a\u00020SX.¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010U\"\u0004\bb\u0010WR\"\u0010c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\r\"\u0004\be\u0010\u000fR\u001a\u0010f\u001a\u00020gX.¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001a\u0010l\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0019\"\u0004\bn\u0010\u001bR\u001a\u0010o\u001a\u00020gX.¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010i\"\u0004\bq\u0010kR\u001a\u0010r\u001a\u00020SX.¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010U\"\u0004\bt\u0010W¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "banSwitchScene", "", "getBanSwitchScene", "()Z", "setBanSwitchScene", "(Z)V", "commentEditTextLayout", "Landroid/view/View;", "getCommentEditTextLayout", "()Landroid/view/View;", "setCommentEditTextLayout", "(Landroid/view/View;)V", "commentTextLimit", "", "getCommentTextLimit", "()I", "setCommentTextLimit", "(I)V", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "value", "footerMode", "getFooterMode", "setFooterMode", "isFrozen", "setFrozen", "isSelfProfile", "setSelfProfile", "isShowKeyboard", "lastActionStr", "", "getLastActionStr", "()Ljava/lang/String;", "setLastActionStr", "(Ljava/lang/String;)V", "lastFromName", "getLastFromName", "setLastFromName", "lastTag", "", "getLastTag", "()Ljava/lang/Object;", "setLastTag", "(Ljava/lang/Object;)V", "modeChangeCallback", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "getModeChangeCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "setModeChangeCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;)V", "replyBtn", "getReplyBtn", "setReplyBtn", "replyBtnWidth", "getReplyBtnWidth", "setReplyBtnWidth", "scene", "getScene", "setScene", "sendBtnEnabled", "getSendBtnEnabled", "setSendBtnEnabled", "smileyBtn", "Landroid/widget/ImageView;", "getSmileyBtn", "()Landroid/widget/ImageView;", "setSmileyBtn", "(Landroid/widget/ImageView;)V", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "switchSceneAvatar", "getSwitchSceneAvatar", "setSwitchSceneAvatar", "switchSceneListener", "getSwitchSceneListener", "setSwitchSceneListener", "switchSceneName", "Landroid/widget/TextView;", "getSwitchSceneName", "()Landroid/widget/TextView;", "setSwitchSceneName", "(Landroid/widget/TextView;)V", "switchSceneTip", "getSwitchSceneTip", "setSwitchSceneTip", "switchSceneTipTv", "getSwitchSceneTipTv", "setSwitchSceneTipTv", "targetAvatar", "getTargetAvatar", "setTargetAvatar", "canSwitchScene", "changeReplyTo", "fromName", "actionStr", "tag", "changeReplyToAndFocus", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "showRemark", "changeReplyToCommenter", "toName", "changeReplyToPoster", "changeSelfName", "selfName", "checkShowReplyBtn", "s", "Landroid/text/Editable;", "ellipseName", "name", "getAvatarView", "initSelectItem", "item1", "itemScene", "onItemSelect", "Lkotlin/Function1;", "onFinishInflate", "onHideKeyBoardOrSmileyPanel", "onHideSmileyPanel", "isMoveAnim", "onKeyboardHeightChanged", "height", "isResized", "onSceneSwitch", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "refreshCommentScene", "refreshSwitchSceneView", "showVKB", "isShow", "Companion", "IModeChangeCallback", "plugin-finder_release"})
public final class FinderCommentFooter extends LinearLayout implements com.tencent.mm.ui.tools.g {
    public static final a wlh = new a((byte) 0);
    public SmileyPanel hQS;
    private int hQT = at.aH(getContext(), R.dimen.cp);
    private boolean hQU;
    private int scene = 2;
    private boolean uLZ;
    private boolean uMD;
    public ImageView wkN;
    public TextView wkO;
    public View wkP;
    public TextView wkQ;
    public ImageView wkR;
    public MMEditText wkS;
    public View wkT;
    public View wkU;
    public ImageView wkV;
    private int wkW;
    private float wkX = ((float) KeyBoardUtil.getKeyBordHeightPx(getContext()));
    private boolean wkY;
    private b wkZ;
    private kotlin.g.a.a<x> wla;
    private kotlin.g.a.a<x> wlb;
    private boolean wlc;
    public int wld;
    public String wle = "";
    private String wlf = "";
    private Object wlg;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "", "onModeChange", "", "from", "", "to", "plugin-finder_release"})
    public interface b {
        void onModeChange(int i2, int i3);
    }

    static {
        AppMethodBeat.i(168295);
        AppMethodBeat.o(168295);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class m implements View.OnClickListener {
        final /* synthetic */ FinderCommentFooter wlk;

        m(FinderCommentFooter finderCommentFooter) {
            this.wlk = finderCommentFooter;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "selectScene", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2$1$1"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.b<Integer, x> {
            final /* synthetic */ d tru;
            final /* synthetic */ m wlo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, m mVar) {
                super(1);
                this.tru = dVar;
                this.wlo = mVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(254749);
                if (num.intValue() != this.wlo.wlk.getScene()) {
                    FinderCommentFooter.a(this.wlo.wlk);
                }
                this.tru.bMo();
                x xVar = x.SXb;
                AppMethodBeat.o(254749);
                return xVar;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "selectScene", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2$1$2"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.b<Integer, x> {
            final /* synthetic */ d tru;
            final /* synthetic */ m wlo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(d dVar, m mVar) {
                super(1);
                this.tru = dVar;
                this.wlo = mVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(254750);
                if (num.intValue() != this.wlo.wlk.getScene()) {
                    FinderCommentFooter.a(this.wlo.wlk);
                }
                this.tru.bMo();
                x xVar = x.SXb;
                AppMethodBeat.o(254750);
                return xVar;
            }
        }

        public final void onClick(View view) {
            AppMethodBeat.i(254751);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dsR() > 0) {
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                com.tencent.mm.plugin.finder.storage.c.KR(0);
                this.wlk.getSwitchSceneTip().setVisibility(8);
                d dVar = new d(this.wlk.getContext());
                dVar.Ml(R.layout.akc);
                ao.a(((TextView) dVar.lJI.findViewById(R.id.d06)).getPaint(), 0.8f);
                View findViewById = dVar.lJI.findViewById(R.id.d04);
                FinderCommentFooter finderCommentFooter = this.wlk;
                kotlin.g.b.p.g(findViewById, "item1");
                FinderCommentFooter.a(finderCommentFooter, findViewById, 1, new a(dVar, this));
                View findViewById2 = dVar.lJI.findViewById(R.id.d05);
                FinderCommentFooter finderCommentFooter2 = this.wlk;
                kotlin.g.b.p.g(findViewById2, "item2");
                FinderCommentFooter.a(finderCommentFooter2, findViewById2, 2, new b(dVar, this));
                dVar.dGm();
            } else {
                FinderCommentFooter.a(this.wlk);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254751);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$Companion;", "", "()V", "MODE_DEFAULT", "", "MODE_KEYBOARD", "MODE_SMILEY", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public FinderCommentFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(168294);
        AppMethodBeat.o(168294);
    }

    public final ImageView getSwitchSceneAvatar() {
        AppMethodBeat.i(178476);
        ImageView imageView = this.wkN;
        if (imageView == null) {
            kotlin.g.b.p.btv("switchSceneAvatar");
        }
        AppMethodBeat.o(178476);
        return imageView;
    }

    public final void setSwitchSceneAvatar(ImageView imageView) {
        AppMethodBeat.i(178477);
        kotlin.g.b.p.h(imageView, "<set-?>");
        this.wkN = imageView;
        AppMethodBeat.o(178477);
    }

    public final TextView getSwitchSceneName() {
        AppMethodBeat.i(178478);
        TextView textView = this.wkO;
        if (textView == null) {
            kotlin.g.b.p.btv("switchSceneName");
        }
        AppMethodBeat.o(178478);
        return textView;
    }

    public final void setSwitchSceneName(TextView textView) {
        AppMethodBeat.i(178479);
        kotlin.g.b.p.h(textView, "<set-?>");
        this.wkO = textView;
        AppMethodBeat.o(178479);
    }

    public final View getSwitchSceneTip() {
        AppMethodBeat.i(178480);
        View view = this.wkP;
        if (view == null) {
            kotlin.g.b.p.btv("switchSceneTip");
        }
        AppMethodBeat.o(178480);
        return view;
    }

    public final void setSwitchSceneTip(View view) {
        AppMethodBeat.i(178481);
        kotlin.g.b.p.h(view, "<set-?>");
        this.wkP = view;
        AppMethodBeat.o(178481);
    }

    public final TextView getSwitchSceneTipTv() {
        AppMethodBeat.i(178482);
        TextView textView = this.wkQ;
        if (textView == null) {
            kotlin.g.b.p.btv("switchSceneTipTv");
        }
        AppMethodBeat.o(178482);
        return textView;
    }

    public final void setSwitchSceneTipTv(TextView textView) {
        AppMethodBeat.i(178483);
        kotlin.g.b.p.h(textView, "<set-?>");
        this.wkQ = textView;
        AppMethodBeat.o(178483);
    }

    public final SmileyPanel getSmileyPanel() {
        AppMethodBeat.i(168275);
        SmileyPanel smileyPanel = this.hQS;
        if (smileyPanel == null) {
            kotlin.g.b.p.btv("smileyPanel");
        }
        AppMethodBeat.o(168275);
        return smileyPanel;
    }

    public final void setSmileyPanel(SmileyPanel smileyPanel) {
        AppMethodBeat.i(168276);
        kotlin.g.b.p.h(smileyPanel, "<set-?>");
        this.hQS = smileyPanel;
        AppMethodBeat.o(168276);
    }

    public final ImageView getSmileyBtn() {
        AppMethodBeat.i(168277);
        ImageView imageView = this.wkR;
        if (imageView == null) {
            kotlin.g.b.p.btv("smileyBtn");
        }
        AppMethodBeat.o(168277);
        return imageView;
    }

    public final void setSmileyBtn(ImageView imageView) {
        AppMethodBeat.i(168278);
        kotlin.g.b.p.h(imageView, "<set-?>");
        this.wkR = imageView;
        AppMethodBeat.o(168278);
    }

    public final MMEditText getEditText() {
        AppMethodBeat.i(168279);
        MMEditText mMEditText = this.wkS;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("editText");
        }
        AppMethodBeat.o(168279);
        return mMEditText;
    }

    public final void setEditText(MMEditText mMEditText) {
        AppMethodBeat.i(168280);
        kotlin.g.b.p.h(mMEditText, "<set-?>");
        this.wkS = mMEditText;
        AppMethodBeat.o(168280);
    }

    public final View getReplyBtn() {
        AppMethodBeat.i(168281);
        View view = this.wkT;
        if (view == null) {
            kotlin.g.b.p.btv("replyBtn");
        }
        AppMethodBeat.o(168281);
        return view;
    }

    public final void setReplyBtn(View view) {
        AppMethodBeat.i(168282);
        kotlin.g.b.p.h(view, "<set-?>");
        this.wkT = view;
        AppMethodBeat.o(168282);
    }

    public final View getCommentEditTextLayout() {
        AppMethodBeat.i(168283);
        View view = this.wkU;
        if (view == null) {
            kotlin.g.b.p.btv("commentEditTextLayout");
        }
        AppMethodBeat.o(168283);
        return view;
    }

    public final void setCommentEditTextLayout(View view) {
        AppMethodBeat.i(168284);
        kotlin.g.b.p.h(view, "<set-?>");
        this.wkU = view;
        AppMethodBeat.o(168284);
    }

    public final ImageView getTargetAvatar() {
        AppMethodBeat.i(168285);
        ImageView imageView = this.wkV;
        if (imageView == null) {
            kotlin.g.b.p.btv("targetAvatar");
        }
        AppMethodBeat.o(168285);
        return imageView;
    }

    public final void setTargetAvatar(ImageView imageView) {
        AppMethodBeat.i(168286);
        kotlin.g.b.p.h(imageView, "<set-?>");
        this.wkV = imageView;
        AppMethodBeat.o(168286);
    }

    public final int getCommentTextLimit() {
        return this.wkW;
    }

    public final void setCommentTextLimit(int i2) {
        this.wkW = i2;
    }

    public final void setFrozen(boolean z) {
        this.wkY = z;
    }

    public final b getModeChangeCallback() {
        return this.wkZ;
    }

    public final void setModeChangeCallback(b bVar) {
        this.wkZ = bVar;
    }

    public final kotlin.g.a.a<x> getBackClickListener() {
        return this.wla;
    }

    public final void setBackClickListener(kotlin.g.a.a<x> aVar) {
        this.wla = aVar;
    }

    public final kotlin.g.a.a<x> getSwitchSceneListener() {
        return this.wlb;
    }

    public final void setSwitchSceneListener(kotlin.g.a.a<x> aVar) {
        this.wlb = aVar;
    }

    public final int getReplyBtnWidth() {
        return this.hQT;
    }

    public final void setReplyBtnWidth(int i2) {
        this.hQT = i2;
    }

    public final boolean getSendBtnEnabled() {
        return this.hQU;
    }

    public final void setSendBtnEnabled(boolean z) {
        this.hQU = z;
    }

    public final int getScene() {
        return this.scene;
    }

    public final void setScene(int i2) {
        AppMethodBeat.i(254754);
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
            Log.printInfoStack("Finder.FinderCommentFooter", "set footer scene:".concat(String.valueOf(i2)), new Object[0]);
        }
        this.scene = i2;
        AppMethodBeat.o(254754);
    }

    public final void setSelfProfile(boolean z) {
        this.uLZ = z;
    }

    public final boolean getBanSwitchScene() {
        return this.wlc;
    }

    public final void setBanSwitchScene(boolean z) {
        this.wlc = z;
    }

    public final int getFooterMode() {
        return this.wld;
    }

    public final void setFooterMode(int i2) {
        AppMethodBeat.i(168287);
        b bVar = this.wkZ;
        if (bVar != null) {
            bVar.onModeChange(this.wld, i2);
        }
        this.wld = i2;
        AppMethodBeat.o(168287);
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(int i2, boolean z) {
        AppMethodBeat.i(168288);
        boolean z2 = i2 > 0;
        if (this.wkY) {
            AppMethodBeat.o(168288);
            return;
        }
        if (i2 > 0 && i2 != ((int) this.wkX)) {
            KeyBoardUtil.saveKeyBordHeightPx(getContext(), i2);
            this.wkX = (float) i2;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) this.wkX);
            SmileyPanel smileyPanel = this.hQS;
            if (smileyPanel == null) {
                kotlin.g.b.p.btv("smileyPanel");
            }
            smileyPanel.setLayoutParams(layoutParams);
        }
        if (this.uMD != z2) {
            this.uMD = z2;
            if (z2) {
                animate().setDuration(90).translationY(0.0f).setListener(new i(this)).start();
            } else if (this.wld == 2 || this.wld == 0) {
                animate().setDuration(180).translationY(this.wkX).setListener(new j(this)).start();
            }
        }
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dsR() <= 0 || !dGz()) {
            View view = this.wkP;
            if (view == null) {
                kotlin.g.b.p.btv("switchSceneTip");
            }
            view.setVisibility(8);
            AppMethodBeat.o(168288);
            return;
        }
        View view2 = this.wkP;
        if (view2 == null) {
            kotlin.g.b.p.btv("switchSceneTip");
        }
        view2.setVisibility(0);
        AppMethodBeat.o(168288);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onKeyboardHeightChanged$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class i implements Animator.AnimatorListener {
        final /* synthetic */ FinderCommentFooter wlk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(FinderCommentFooter finderCommentFooter) {
            this.wlk = finderCommentFooter;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(254747);
            this.wlk.setFooterMode(2);
            AppMethodBeat.o(254747);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onKeyboardHeightChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class j implements Animator.AnimatorListener {
        final /* synthetic */ FinderCommentFooter wlk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(FinderCommentFooter finderCommentFooter) {
            this.wlk = finderCommentFooter;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(254748);
            this.wlk.setFooterMode(0);
            AppMethodBeat.o(254748);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        AppMethodBeat.i(168289);
        super.onFinishInflate();
        View findViewById = findViewById(R.id.b9_);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.comment_scene_avatar)");
        this.wkN = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.b9b);
        kotlin.g.b.p.g(findViewById2, "findViewById(R.id.comment_scene_name)");
        this.wkO = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.b9e);
        kotlin.g.b.p.g(findViewById3, "findViewById(R.id.comment_switch_scene_tip_layout)");
        this.wkP = findViewById3;
        View findViewById4 = findViewById(R.id.b9f);
        kotlin.g.b.p.g(findViewById4, "findViewById(R.id.comment_switch_scene_tip_tv)");
        this.wkQ = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.ht_);
        kotlin.g.b.p.g(findViewById5, "findViewById(R.id.smiley_btn)");
        this.wkR = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.b8q);
        kotlin.g.b.p.g(findViewById6, "findViewById(R.id.comment_et)");
        this.wkS = (MMEditText) findViewById6;
        View findViewById7 = findViewById(R.id.b9g);
        kotlin.g.b.p.g(findViewById7, "findViewById(R.id.comment_target_avatar)");
        this.wkV = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.h35);
        kotlin.g.b.p.g(findViewById8, "findViewById(R.id.reply_btn)");
        this.wkT = findViewById8;
        View findViewById9 = findViewById(R.id.b8r);
        kotlin.g.b.p.g(findViewById9, "findViewById(R.id.comment_et_layout)");
        this.wkU = findViewById9;
        if (ao.isDarkMode()) {
            View view = this.wkP;
            if (view == null) {
                kotlin.g.b.p.btv("switchSceneTip");
            }
            view.setBackgroundResource(R.drawable.a46);
        } else {
            View view2 = this.wkP;
            if (view2 == null) {
                kotlin.g.b.p.btv("switchSceneTip");
            }
            view2.setBackgroundResource(R.drawable.a44);
        }
        ImageView imageView = this.wkR;
        if (imageView == null) {
            kotlin.g.b.p.btv("smileyBtn");
        }
        imageView.setTag(Boolean.FALSE);
        SmileyPanel l2 = ad.l(getContext(), false);
        kotlin.g.b.p.g(l2, "SmileyPanelFactory.getSmileyPanel(context, false)");
        this.hQS = l2;
        SmileyPanel smileyPanel = this.hQS;
        if (smileyPanel == null) {
            kotlin.g.b.p.btv("smileyPanel");
        }
        smileyPanel.setEntranceScene(ChatFooterPanel.tvw);
        SmileyPanel smileyPanel2 = this.hQS;
        if (smileyPanel2 == null) {
            kotlin.g.b.p.btv("smileyPanel");
        }
        smileyPanel2.setBackgroundResource(R.drawable.c9_);
        SmileyPanel smileyPanel3 = this.hQS;
        if (smileyPanel3 == null) {
            kotlin.g.b.p.btv("smileyPanel");
        }
        smileyPanel3.goD();
        SmileyPanel smileyPanel4 = this.hQS;
        if (smileyPanel4 == null) {
            kotlin.g.b.p.btv("smileyPanel");
        }
        smileyPanel4.goE();
        SmileyPanel smileyPanel5 = this.hQS;
        if (smileyPanel5 == null) {
            kotlin.g.b.p.btv("smileyPanel");
        }
        smileyPanel5.zN(false);
        SmileyPanel smileyPanel6 = this.hQS;
        if (smileyPanel6 == null) {
            kotlin.g.b.p.btv("smileyPanel");
        }
        smileyPanel6.setVisibility(4);
        SmileyPanel smileyPanel7 = this.hQS;
        if (smileyPanel7 == null) {
            kotlin.g.b.p.btv("smileyPanel");
        }
        smileyPanel7.onResume();
        SmileyPanel smileyPanel8 = this.hQS;
        if (smileyPanel8 == null) {
            kotlin.g.b.p.btv("smileyPanel");
        }
        smileyPanel8.setOnTextOperationListener(new d(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) this.wkX);
        SmileyPanel smileyPanel9 = this.hQS;
        if (smileyPanel9 == null) {
            kotlin.g.b.p.btv("smileyPanel");
        }
        smileyPanel9.setLayoutParams(layoutParams);
        SmileyPanel smileyPanel10 = this.hQS;
        if (smileyPanel10 == null) {
            kotlin.g.b.p.btv("smileyPanel");
        }
        addView(smileyPanel10, layoutParams);
        ImageView imageView2 = this.wkR;
        if (imageView2 == null) {
            kotlin.g.b.p.btv("smileyBtn");
        }
        imageView2.setOnClickListener(new e(this));
        setTranslationY(this.wkX);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wkW = com.tencent.mm.plugin.finder.storage.c.dsz().value().intValue() * 2;
        View view3 = this.wkT;
        if (view3 == null) {
            kotlin.g.b.p.btv("replyBtn");
        }
        view3.setVisibility(8);
        MMEditText mMEditText = this.wkS;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("editText");
        }
        mMEditText.addTextChangedListener(new f(this));
        MMEditText mMEditText2 = this.wkS;
        if (mMEditText2 == null) {
            kotlin.g.b.p.btv("editText");
        }
        com.tencent.mm.ui.tools.b.c.f(mMEditText2).lv(0, this.wkW).a((c.a) null);
        dGx();
        AppMethodBeat.o(168289);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
    public static final class d implements ChatFooterPanel.a {
        final /* synthetic */ FinderCommentFooter wlk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderCommentFooter finderCommentFooter) {
            this.wlk = finderCommentFooter;
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void append(String str) {
            AppMethodBeat.i(168256);
            this.wlk.getEditText().bol(str);
            AppMethodBeat.o(168256);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHC() {
            AppMethodBeat.i(168257);
            if (this.wlk.getEditText().getInputConnection() != null) {
                this.wlk.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                this.wlk.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
            }
            AppMethodBeat.o(168257);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void eP(boolean z) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHD() {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ FinderCommentFooter wlk;

        e(FinderCommentFooter finderCommentFooter) {
            this.wlk = finderCommentFooter;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168258);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.ImageView");
                AppMethodBeat.o(168258);
                throw tVar;
            }
            Object tag = ((ImageView) view).getTag();
            if (tag == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Boolean");
                AppMethodBeat.o(168258);
                throw tVar2;
            }
            FinderCommentFooter.a(this.wlk, !((Boolean) tag).booleanValue());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168258);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
    public static final class f implements TextWatcher {
        final /* synthetic */ FinderCommentFooter wlk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(FinderCommentFooter finderCommentFooter) {
            this.wlk = finderCommentFooter;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ f wll;

            a(f fVar) {
                this.wll = fVar;
            }

            public final void run() {
                AppMethodBeat.i(261525);
                FinderCommentFooter.a(this.wll.wlk, this.wll.wlk.getEditText().getText());
                AppMethodBeat.o(261525);
            }
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(254746);
            this.wlk.getEditText().postDelayed(new a(this), 160);
            AppMethodBeat.o(254746);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class o implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FinderCommentFooter wlk;

        o(FinderCommentFooter finderCommentFooter) {
            this.wlk = finderCommentFooter;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(261517);
            Object animatedValue = valueAnimator != null ? valueAnimator.getAnimatedValue() : null;
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(261517);
                throw tVar;
            }
            float intValue = (float) ((Integer) animatedValue).intValue();
            ViewGroup.LayoutParams layoutParams = this.wlk.getReplyBtn().getLayoutParams();
            layoutParams.width = kotlin.h.a.cR(intValue);
            this.wlk.getReplyBtn().setLayoutParams(layoutParams);
            this.wlk.getReplyBtn().setAlpha(intValue / ((float) this.wlk.getReplyBtnWidth()));
            AppMethodBeat.o(261517);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderCommentFooter$checkShowReplyBtn$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class p implements Animator.AnimatorListener {
        final /* synthetic */ FinderCommentFooter wlk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        p(FinderCommentFooter finderCommentFooter) {
            this.wlk = finderCommentFooter;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(261518);
            ViewGroup.LayoutParams layoutParams = this.wlk.getReplyBtn().getLayoutParams();
            layoutParams.width = this.wlk.getReplyBtnWidth();
            this.wlk.getReplyBtn().setLayoutParams(layoutParams);
            this.wlk.getReplyBtn().setAlpha(1.0f);
            AppMethodBeat.o(261518);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(261519);
            ViewGroup.LayoutParams layoutParams = this.wlk.getReplyBtn().getLayoutParams();
            layoutParams.width = this.wlk.getReplyBtnWidth();
            this.wlk.getReplyBtn().setLayoutParams(layoutParams);
            this.wlk.getReplyBtn().setAlpha(1.0f);
            AppMethodBeat.o(261519);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(261520);
            this.wlk.getReplyBtn().setVisibility(0);
            AppMethodBeat.o(261520);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class q implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FinderCommentFooter wlk;

        q(FinderCommentFooter finderCommentFooter) {
            this.wlk = finderCommentFooter;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(261521);
            Object animatedValue = valueAnimator != null ? valueAnimator.getAnimatedValue() : null;
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(261521);
                throw tVar;
            }
            float intValue = (float) ((Integer) animatedValue).intValue();
            ViewGroup.LayoutParams layoutParams = this.wlk.getReplyBtn().getLayoutParams();
            layoutParams.width = kotlin.h.a.cR(intValue);
            this.wlk.getReplyBtn().setLayoutParams(layoutParams);
            this.wlk.getReplyBtn().setAlpha(intValue / ((float) this.wlk.getReplyBtnWidth()));
            AppMethodBeat.o(261521);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderCommentFooter$checkShowReplyBtn$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class r implements Animator.AnimatorListener {
        final /* synthetic */ FinderCommentFooter wlk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        r(FinderCommentFooter finderCommentFooter) {
            this.wlk = finderCommentFooter;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(261522);
            this.wlk.getReplyBtn().setVisibility(8);
            AppMethodBeat.o(261522);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(261523);
            this.wlk.getReplyBtn().setVisibility(8);
            AppMethodBeat.o(261523);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(261524);
            this.wlk.getReplyBtn().setVisibility(0);
            AppMethodBeat.o(261524);
        }
    }

    public final void dGx() {
        AppMethodBeat.i(178484);
        View view = this.wkP;
        if (view == null) {
            kotlin.g.b.p.btv("switchSceneTip");
        }
        view.setVisibility(8);
        dGy();
        View findViewById = findViewById(R.id.b9d);
        if (dGz()) {
            findViewById.findViewById(R.id.b9a).setVisibility(0);
            findViewById.setOnClickListener(new m(this));
        } else {
            findViewById.setOnClickListener(n.wlp);
            View findViewById2 = findViewById.findViewById(R.id.b9a);
            kotlin.g.b.p.g(findViewById2, "switchClickLayout.findVi…>(R.id.comment_scene_btn)");
            findViewById2.setVisibility(8);
        }
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dsR() > 0) {
            View view2 = this.wkP;
            if (view2 == null) {
                kotlin.g.b.p.btv("switchSceneTip");
            }
            view2.setVisibility(0);
        }
        ImageView imageView = this.wkV;
        if (imageView == null) {
            kotlin.g.b.p.btv("targetAvatar");
        }
        imageView.setVisibility(8);
        MMEditText mMEditText = this.wkS;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("editText");
        }
        Context context = mMEditText.getContext();
        kotlin.g.b.p.g(context, "this.context");
        Context context2 = mMEditText.getContext();
        kotlin.g.b.p.g(context2, "this.context");
        mMEditText.setPadding((int) context.getResources().getDimension(R.dimen.ct), 0, (int) context2.getResources().getDimension(R.dimen.ct), 0);
        AppMethodBeat.o(178484);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class n implements View.OnClickListener {
        public static final n wlp = new n();

        static {
            AppMethodBeat.i(254753);
            AppMethodBeat.o(254753);
        }

        n() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(254752);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254752);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ kotlin.g.a.b wli;
        final /* synthetic */ int wlj;

        c(kotlin.g.a.b bVar, int i2) {
            this.wli = bVar;
            this.wlj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(178472);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCommentFooter$initSelectItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.wli.invoke(Integer.valueOf(this.wlj));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCommentFooter$initSelectItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178472);
        }
    }

    public final void dGy() {
        String str;
        AppMethodBeat.i(178485);
        if (this.scene == 2) {
            ImageView imageView = this.wkN;
            if (imageView == null) {
                kotlin.g.b.p.btv("switchSceneAvatar");
            }
            com.tencent.mm.ui.g.a.a.c(imageView, z.aTY());
            TextView textView = this.wkQ;
            if (textView == null) {
                kotlin.g.b.p.btv("switchSceneTipTv");
            }
            textView.setText(R.string.d_n);
        } else {
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
            if (asG == null || (str = asG.cXH()) == null) {
                str = "";
            }
            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(str);
            ImageView imageView2 = this.wkN;
            if (imageView2 == null) {
                kotlin.g.b.p.btv("switchSceneAvatar");
            }
            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
            dka.a(aVar2, imageView2, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
            TextView textView2 = this.wkQ;
            if (textView2 == null) {
                kotlin.g.b.p.btv("switchSceneTipTv");
            }
            textView2.setText(R.string.d_n);
        }
        TextView textView3 = this.wkO;
        if (textView3 == null) {
            kotlin.g.b.p.btv("switchSceneName");
        }
        Context context = getContext();
        y yVar = y.vXH;
        textView3.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, y.LD(this.scene)));
        y yVar2 = y.vXH;
        awP(y.LD(this.scene));
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dsR() <= 0) {
            View view = this.wkP;
            if (view == null) {
                kotlin.g.b.p.btv("switchSceneTip");
            }
            if (view.getVisibility() == 0) {
                View view2 = this.wkP;
                if (view2 == null) {
                    kotlin.g.b.p.btv("switchSceneTip");
                }
                view2.setVisibility(8);
            }
        }
        AppMethodBeat.o(178485);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onShowSmileyPanel$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
    public static final class k implements View.OnLayoutChangeListener {
        final /* synthetic */ FinderCommentFooter wlk;
        final /* synthetic */ kotlin.g.a.a wln;

        k(FinderCommentFooter finderCommentFooter, kotlin.g.a.a aVar) {
            this.wlk = finderCommentFooter;
            this.wln = aVar;
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            AppMethodBeat.i(168273);
            this.wlk.getSmileyPanel().removeOnLayoutChangeListener(this);
            this.wln.invoke();
            AppMethodBeat.o(168273);
        }
    }

    public final void oW(boolean z) {
        AppMethodBeat.i(168290);
        if (this.wkY) {
            AppMethodBeat.o(168290);
            return;
        }
        ImageView imageView = this.wkR;
        if (imageView == null) {
            kotlin.g.b.p.btv("smileyBtn");
        }
        imageView.setImageResource(R.drawable.of);
        ImageView imageView2 = this.wkR;
        if (imageView2 == null) {
            kotlin.g.b.p.btv("smileyBtn");
        }
        imageView2.setTag(Boolean.FALSE);
        if (z) {
            animate().setInterpolator(new DecelerateInterpolator()).setDuration(220).translationY(this.wkX).setListener(new g(this, z)).start();
            AppMethodBeat.o(168290);
            return;
        }
        SmileyPanel smileyPanel = this.hQS;
        if (smileyPanel == null) {
            kotlin.g.b.p.btv("smileyPanel");
        }
        smileyPanel.animate().alpha(0.0f).setDuration(220).setListener(new h(this)).start();
        AppMethodBeat.o(168290);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class g implements Animator.AnimatorListener {
        final /* synthetic */ FinderCommentFooter wlk;
        final /* synthetic */ boolean wlm;

        g(FinderCommentFooter finderCommentFooter, boolean z) {
            this.wlk = finderCommentFooter;
            this.wlm = z;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(168269);
            this.wlk.getSmileyPanel().setVisibility(4);
            this.wlk.getSmileyBtn().setImageResource(R.drawable.of);
            if (this.wlm) {
                this.wlk.setFooterMode(0);
            }
            AppMethodBeat.o(168269);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class h implements Animator.AnimatorListener {
        final /* synthetic */ FinderCommentFooter wlk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(FinderCommentFooter finderCommentFooter) {
            this.wlk = finderCommentFooter;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(168270);
            this.wlk.getSmileyPanel().setAlpha(1.0f);
            this.wlk.getSmileyPanel().setVisibility(4);
            AppMethodBeat.o(168270);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public final void hk(String str, String str2) {
        AppMethodBeat.i(178486);
        kotlin.g.b.p.h(str, "fromName");
        kotlin.g.b.p.h(str2, "toName");
        f(this.wle, " " + getResources().getString(R.string.b8s), null);
        AppMethodBeat.o(178486);
    }

    public final void e(String str, String str2, Object obj) {
        AppMethodBeat.i(178487);
        kotlin.g.b.p.h(str, "fromName");
        kotlin.g.b.p.h(str2, "toName");
        f(this.wle, " " + getResources().getString(R.string.b8p, str2), obj);
        AppMethodBeat.o(178487);
    }

    private void awP(String str) {
        AppMethodBeat.i(254755);
        kotlin.g.b.p.h(str, "selfName");
        f(awQ(str), this.wlf, this.wlg);
        AppMethodBeat.o(254755);
    }

    private final boolean dGz() {
        AppMethodBeat.i(178488);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dsP().value().intValue() == 1 && !this.uLZ) {
            y yVar = y.vXH;
            if (y.dCB() && !this.wlc) {
                AppMethodBeat.o(178488);
                return true;
            }
        }
        AppMethodBeat.o(178488);
        return false;
    }

    public final String getLastFromName() {
        return this.wle;
    }

    public final void setLastFromName(String str) {
        AppMethodBeat.i(254756);
        kotlin.g.b.p.h(str, "<set-?>");
        this.wle = str;
        AppMethodBeat.o(254756);
    }

    public final String getLastActionStr() {
        return this.wlf;
    }

    public final void setLastActionStr(String str) {
        AppMethodBeat.i(254757);
        kotlin.g.b.p.h(str, "<set-?>");
        this.wlf = str;
        AppMethodBeat.o(254757);
    }

    public final Object getLastTag() {
        return this.wlg;
    }

    public final void setLastTag(Object obj) {
        this.wlg = obj;
    }

    public final void f(String str, String str2, Object obj) {
        String str3;
        AppMethodBeat.i(254758);
        if (str == null) {
            str3 = "";
        } else {
            str3 = str;
        }
        this.wle = str3;
        this.wlf = str2;
        this.wlg = obj;
        String I = kotlin.g.b.p.I(str, str2);
        MMEditText mMEditText = this.wkS;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("editText");
        }
        mMEditText.setHint(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), I));
        MMEditText mMEditText2 = this.wkS;
        if (mMEditText2 == null) {
            kotlin.g.b.p.btv("editText");
        }
        mMEditText2.setTag(obj);
        MMEditText mMEditText3 = this.wkS;
        if (mMEditText3 == null) {
            kotlin.g.b.p.btv("editText");
        }
        if (!mMEditText3.hasFocus()) {
            MMEditText mMEditText4 = this.wkS;
            if (mMEditText4 == null) {
                kotlin.g.b.p.btv("editText");
            }
            mMEditText4.requestFocus();
        }
        AppMethodBeat.o(254758);
    }

    public final String awQ(String str) {
        AppMethodBeat.i(254759);
        com.tencent.mm.plugin.finder.convert.d dVar = com.tencent.mm.plugin.finder.convert.d.tyZ;
        Context context = getContext();
        kotlin.g.b.p.g(context, "context");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int Z = com.tencent.mm.plugin.finder.convert.d.Z(context, com.tencent.mm.plugin.finder.storage.c.drZ());
        com.tencent.mm.plugin.finder.convert.d dVar2 = com.tencent.mm.plugin.finder.convert.d.tyZ;
        Context context2 = getContext();
        kotlin.g.b.p.g(context2, "context");
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        int Z2 = com.tencent.mm.plugin.finder.convert.d.Z(context2, com.tencent.mm.plugin.finder.storage.c.drZ() + 1);
        com.tencent.mm.plugin.finder.convert.d dVar3 = com.tencent.mm.plugin.finder.convert.d.tyZ;
        MMEditText mMEditText = this.wkS;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("editText");
        }
        TextPaint paint = mMEditText.getPaint();
        kotlin.g.b.p.g(paint, "editText.paint");
        String a2 = com.tencent.mm.plugin.finder.convert.d.a(paint, str, Z, Z2);
        AppMethodBeat.o(254759);
        return a2;
    }

    public final void cH(boolean z) {
        MMFragmentActivity mMFragmentActivity = null;
        AppMethodBeat.i(168292);
        if (this.wkY) {
            AppMethodBeat.o(168292);
        } else if (this.uMD && z) {
            AppMethodBeat.o(168292);
        } else if (z) {
            Context context = getContext();
            if (context instanceof MMFragmentActivity) {
                mMFragmentActivity = context;
            }
            MMFragmentActivity mMFragmentActivity2 = (MMFragmentActivity) mMFragmentActivity;
            if (mMFragmentActivity2 != null) {
                mMFragmentActivity2.showVKB();
                AppMethodBeat.o(168292);
                return;
            }
            AppMethodBeat.o(168292);
        } else {
            Context context2 = getContext();
            if (context2 instanceof MMFragmentActivity) {
                mMFragmentActivity = context2;
            }
            MMFragmentActivity mMFragmentActivity3 = mMFragmentActivity;
            if (mMFragmentActivity3 != null) {
                mMFragmentActivity3.hideVKB();
                AppMethodBeat.o(168292);
                return;
            }
            AppMethodBeat.o(168292);
        }
    }

    public final ImageView getAvatarView() {
        AppMethodBeat.i(168293);
        ImageView imageView = this.wkV;
        if (imageView == null) {
            kotlin.g.b.p.btv("targetAvatar");
        }
        AppMethodBeat.o(168293);
        return imageView;
    }

    public static final /* synthetic */ void a(FinderCommentFooter finderCommentFooter, boolean z) {
        boolean z2;
        AppMethodBeat.i(168296);
        if (!finderCommentFooter.wkY) {
            if (!z) {
                finderCommentFooter.setFooterMode(2);
                finderCommentFooter.oW(false);
                MMEditText mMEditText = finderCommentFooter.wkS;
                if (mMEditText == null) {
                    kotlin.g.b.p.btv("editText");
                }
                mMEditText.setShowSoftInputOnFocus(true);
                MMEditText mMEditText2 = finderCommentFooter.wkS;
                if (mMEditText2 == null) {
                    kotlin.g.b.p.btv("editText");
                }
                mMEditText2.requestFocus();
                Context context = finderCommentFooter.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                    AppMethodBeat.o(168296);
                    throw tVar;
                }
                ((MMFragmentActivity) context).showVKB();
            } else {
                if (finderCommentFooter.wld != 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!finderCommentFooter.wkY) {
                    SmileyPanel smileyPanel = finderCommentFooter.hQS;
                    if (smileyPanel == null) {
                        kotlin.g.b.p.btv("smileyPanel");
                    }
                    smileyPanel.setVisibility(0);
                    ImageView imageView = finderCommentFooter.wkR;
                    if (imageView == null) {
                        kotlin.g.b.p.btv("smileyBtn");
                    }
                    imageView.setImageResource(R.drawable.of);
                    ImageView imageView2 = finderCommentFooter.wkR;
                    if (imageView2 == null) {
                        kotlin.g.b.p.btv("smileyBtn");
                    }
                    imageView2.setTag(Boolean.TRUE);
                    if (z2) {
                        l lVar = new l(finderCommentFooter);
                        SmileyPanel smileyPanel2 = finderCommentFooter.hQS;
                        if (smileyPanel2 == null) {
                            kotlin.g.b.p.btv("smileyPanel");
                        }
                        if (((float) smileyPanel2.getHeight()) <= 0.0f) {
                            SmileyPanel smileyPanel3 = finderCommentFooter.hQS;
                            if (smileyPanel3 == null) {
                                kotlin.g.b.p.btv("smileyPanel");
                            }
                            smileyPanel3.addOnLayoutChangeListener(new k(finderCommentFooter, lVar));
                        } else {
                            lVar.invoke();
                        }
                    } else {
                        SmileyPanel smileyPanel4 = finderCommentFooter.hQS;
                        if (smileyPanel4 == null) {
                            kotlin.g.b.p.btv("smileyPanel");
                        }
                        smileyPanel4.setAlpha(0.0f);
                        SmileyPanel smileyPanel5 = finderCommentFooter.hQS;
                        if (smileyPanel5 == null) {
                            kotlin.g.b.p.btv("smileyPanel");
                        }
                        smileyPanel5.animate().alpha(1.0f).setDuration(220).setListener(null).start();
                    }
                }
                finderCommentFooter.setFooterMode(1);
                Context context2 = finderCommentFooter.getContext();
                if (context2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                    AppMethodBeat.o(168296);
                    throw tVar2;
                }
                ((MMFragmentActivity) context2).hideVKB();
            }
            if (z) {
                ImageView imageView3 = finderCommentFooter.wkR;
                if (imageView3 == null) {
                    kotlin.g.b.p.btv("smileyBtn");
                }
                imageView3.setImageResource(R.drawable.oh);
                AppMethodBeat.o(168296);
                return;
            }
            ImageView imageView4 = finderCommentFooter.wkR;
            if (imageView4 == null) {
                kotlin.g.b.p.btv("smileyBtn");
            }
            imageView4.setImageResource(R.drawable.of);
        }
        AppMethodBeat.o(168296);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class l extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderCommentFooter wlk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(FinderCommentFooter finderCommentFooter) {
            super(0);
            this.wlk = finderCommentFooter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(168274);
            this.wlk.animate().setInterpolator(new DecelerateInterpolator()).setDuration(220).setListener(null).translationY(0.0f).start();
            x xVar = x.SXb;
            AppMethodBeat.o(168274);
            return xVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.tencent.mm.plugin.finder.view.FinderCommentFooter r8, android.text.Editable r9) {
        /*
        // Method dump skipped, instructions count: 175
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.view.FinderCommentFooter.a(com.tencent.mm.plugin.finder.view.FinderCommentFooter, android.text.Editable):void");
    }

    public static final /* synthetic */ void a(FinderCommentFooter finderCommentFooter, View view, int i2, kotlin.g.a.b bVar) {
        String str;
        AppMethodBeat.i(178489);
        ImageView imageView = (ImageView) view.findViewById(R.id.dt5);
        TextView textView = (TextView) view.findViewById(R.id.ipm);
        TextView textView2 = (TextView) view.findViewById(R.id.bmr);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.h76);
        if (finderCommentFooter.scene == i2) {
            kotlin.g.b.p.g(imageView2, "checkIv");
            imageView2.setVisibility(0);
        } else {
            kotlin.g.b.p.g(imageView2, "checkIv");
            imageView2.setVisibility(8);
        }
        Context context = finderCommentFooter.getContext();
        y yVar = y.vXH;
        textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, y.LD(i2)));
        if (i2 == 1) {
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
            if (asG == null || (str = asG.cXH()) == null) {
                str = "";
            }
            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(str);
            kotlin.g.b.p.g(imageView, "avatarIv");
            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
            dka.a(aVar2, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
            textView.setText(R.string.d_o);
        } else {
            com.tencent.mm.ui.g.a.a.c(imageView, z.aTY());
            textView.setText(R.string.d_p);
        }
        view.setOnClickListener(new c(bVar, i2));
        AppMethodBeat.o(178489);
    }

    public static final /* synthetic */ void a(FinderCommentFooter finderCommentFooter) {
        AppMethodBeat.i(178490);
        kotlin.g.a.a<x> aVar = finderCommentFooter.wlb;
        if (aVar != null) {
            aVar.invoke();
        }
        y yVar = y.vXH;
        finderCommentFooter.setScene(y.LF(finderCommentFooter.scene));
        finderCommentFooter.dGy();
        AppMethodBeat.o(178490);
    }
}
