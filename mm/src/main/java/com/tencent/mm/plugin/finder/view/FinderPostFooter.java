package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ad;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u0000 R2\u00020\u0001:\u0002RSB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J>\u0010F\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u0015J\b\u0010G\u001a\u00020\u001fH\u0014J\b\u0010H\u001a\u00020\u001fH\u0002J\u000e\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\u000fJ\b\u0010K\u001a\u00020\u001fH\u0002J\u001a\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u0002042\b\b\u0002\u0010N\u001a\u000204H\u0002J\u000e\u0010O\u001a\u00020\u001f2\u0006\u0010P\u001a\u000204J\u000e\u0010Q\u001a\u00020\u001f2\u0006\u0010P\u001a\u000204R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000206X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020BX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0017\"\u0004\bE\u0010\u0019¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "setActivity", "(Lcom/tencent/mm/ui/MMActivity;)V", "activityReqCode", "", "getActivityReqCode", "()I", "setActivityReqCode", "(I)V", "atBtn", "Landroid/view/View;", "getAtBtn", "()Landroid/view/View;", "setAtBtn", "(Landroid/view/View;)V", "atReqCode", "getAtReqCode", "setAtReqCode", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "container", "getContainer", "setContainer", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "iTopicCallback", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "getITopicCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "setITopicCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;)V", "isShowKeyboard", "", "smileyBtn", "Landroid/widget/ImageView;", "getSmileyBtn", "()Landroid/widget/ImageView;", "setSmileyBtn", "(Landroid/widget/ImageView;)V", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "topicBtn", "getTopicBtn", "setTopicBtn", "initView", "onFinishInflate", "onHideSmileyPanel", "onKeyboardHeightChanged", "height", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "showAtBtn", "show", "showTopicBtn", "Companion", "ITopicCallback", "plugin-finder_release"})
public final class FinderPostFooter extends LinearLayout {
    public static final a wot = new a((byte) 0);
    public MMActivity activity;
    public SmileyPanel hQS;
    public View jxm;
    public ImageView wkR;
    public MMEditText wkS;
    public float wkX = ((float) KeyBoardUtil.getKeyBordHeightPx(getContext()));
    private kotlin.g.a.a<x> wla;
    public View woo;
    public View wop;
    public int woq;
    public int wor;
    public b wos;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "", "onTopicClick", "", "plugin-finder_release"})
    public interface b {
        void dAB();
    }

    static {
        AppMethodBeat.i(168396);
        AppMethodBeat.o(168396);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public FinderPostFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(168395);
        AppMethodBeat.o(168395);
    }

    public final MMActivity getActivity() {
        AppMethodBeat.i(254895);
        MMActivity mMActivity = this.activity;
        if (mMActivity == null) {
            p.btv(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        }
        AppMethodBeat.o(254895);
        return mMActivity;
    }

    public final void setActivity(MMActivity mMActivity) {
        AppMethodBeat.i(254896);
        p.h(mMActivity, "<set-?>");
        this.activity = mMActivity;
        AppMethodBeat.o(254896);
    }

    public final SmileyPanel getSmileyPanel() {
        AppMethodBeat.i(168386);
        SmileyPanel smileyPanel = this.hQS;
        if (smileyPanel == null) {
            p.btv("smileyPanel");
        }
        AppMethodBeat.o(168386);
        return smileyPanel;
    }

    public final void setSmileyPanel(SmileyPanel smileyPanel) {
        AppMethodBeat.i(168387);
        p.h(smileyPanel, "<set-?>");
        this.hQS = smileyPanel;
        AppMethodBeat.o(168387);
    }

    public final ImageView getSmileyBtn() {
        AppMethodBeat.i(168388);
        ImageView imageView = this.wkR;
        if (imageView == null) {
            p.btv("smileyBtn");
        }
        AppMethodBeat.o(168388);
        return imageView;
    }

    public final void setSmileyBtn(ImageView imageView) {
        AppMethodBeat.i(168389);
        p.h(imageView, "<set-?>");
        this.wkR = imageView;
        AppMethodBeat.o(168389);
    }

    public final View getTopicBtn() {
        AppMethodBeat.i(254897);
        View view = this.woo;
        if (view == null) {
            p.btv("topicBtn");
        }
        AppMethodBeat.o(254897);
        return view;
    }

    public final void setTopicBtn(View view) {
        AppMethodBeat.i(254898);
        p.h(view, "<set-?>");
        this.woo = view;
        AppMethodBeat.o(254898);
    }

    public final View getAtBtn() {
        AppMethodBeat.i(254899);
        View view = this.wop;
        if (view == null) {
            p.btv("atBtn");
        }
        AppMethodBeat.o(254899);
        return view;
    }

    public final void setAtBtn(View view) {
        AppMethodBeat.i(254900);
        p.h(view, "<set-?>");
        this.wop = view;
        AppMethodBeat.o(254900);
    }

    public final MMEditText getEditText() {
        return this.wkS;
    }

    public final void setEditText(MMEditText mMEditText) {
        this.wkS = mMEditText;
    }

    public final kotlin.g.a.a<x> getBackClickListener() {
        return this.wla;
    }

    public final void setBackClickListener(kotlin.g.a.a<x> aVar) {
        this.wla = aVar;
    }

    public final View getContainer() {
        return this.jxm;
    }

    public final void setContainer(View view) {
        this.jxm = view;
    }

    public final int getAtReqCode() {
        return this.woq;
    }

    public final void setAtReqCode(int i2) {
        this.woq = i2;
    }

    public final int getActivityReqCode() {
        return this.wor;
    }

    public final void setActivityReqCode(int i2) {
        this.wor = i2;
    }

    public final b getITopicCallback() {
        AppMethodBeat.i(254901);
        b bVar = this.wos;
        if (bVar == null) {
            p.btv("iTopicCallback");
        }
        AppMethodBeat.o(254901);
        return bVar;
    }

    public final void setITopicCallback(b bVar) {
        AppMethodBeat.i(254902);
        p.h(bVar, "<set-?>");
        this.wos = bVar;
        AppMethodBeat.o(254902);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ b wou;

        public c(b bVar) {
            this.wou = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(254891);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.wou.dAB();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254891);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ MMActivity nbB;
        final /* synthetic */ int wov = 20001;

        public d(MMActivity mMActivity) {
            this.nbB = mMActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(254892);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("key_scene", 1);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.c(this.nbB, intent, this.wov);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254892);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        public static final e wow = new e();

        static {
            AppMethodBeat.i(254894);
            AppMethodBeat.o(254894);
        }

        e() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(254893);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254893);
        }
    }

    public final void oX(boolean z) {
        AppMethodBeat.i(254903);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!com.tencent.mm.plugin.finder.storage.c.drN() || !z) {
            View view = this.woo;
            if (view == null) {
                p.btv("topicBtn");
            }
            view.setVisibility(8);
            AppMethodBeat.o(254903);
            return;
        }
        View view2 = this.woo;
        if (view2 == null) {
            p.btv("topicBtn");
        }
        view2.setVisibility(0);
        AppMethodBeat.o(254903);
    }

    public final void oY(boolean z) {
        AppMethodBeat.i(254904);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!com.tencent.mm.plugin.finder.storage.c.drO() || !z) {
            View view = this.wop;
            if (view == null) {
                p.btv("atBtn");
            }
            view.setVisibility(8);
            AppMethodBeat.o(254904);
            return;
        }
        View view2 = this.wop;
        if (view2 == null) {
            p.btv("atBtn");
        }
        view2.setVisibility(0);
        AppMethodBeat.o(254904);
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        AppMethodBeat.i(168390);
        super.onFinishInflate();
        View findViewById = findViewById(R.id.ht_);
        p.g(findViewById, "findViewById(R.id.smiley_btn)");
        this.wkR = (ImageView) findViewById;
        this.wkS = (MMEditText) findViewById(R.id.b8q);
        ImageView imageView = this.wkR;
        if (imageView == null) {
            p.btv("smileyBtn");
        }
        imageView.setTag(Boolean.FALSE);
        SmileyPanel l = ad.l(getContext(), false);
        p.g(l, "SmileyPanelFactory.getSmileyPanel(context, false)");
        this.hQS = l;
        SmileyPanel smileyPanel = this.hQS;
        if (smileyPanel == null) {
            p.btv("smileyPanel");
        }
        smileyPanel.setEntranceScene(ChatFooterPanel.tvw);
        SmileyPanel smileyPanel2 = this.hQS;
        if (smileyPanel2 == null) {
            p.btv("smileyPanel");
        }
        smileyPanel2.setBackgroundResource(R.drawable.c9_);
        SmileyPanel smileyPanel3 = this.hQS;
        if (smileyPanel3 == null) {
            p.btv("smileyPanel");
        }
        smileyPanel3.goD();
        SmileyPanel smileyPanel4 = this.hQS;
        if (smileyPanel4 == null) {
            p.btv("smileyPanel");
        }
        smileyPanel4.goE();
        SmileyPanel smileyPanel5 = this.hQS;
        if (smileyPanel5 == null) {
            p.btv("smileyPanel");
        }
        smileyPanel5.zN(false);
        SmileyPanel smileyPanel6 = this.hQS;
        if (smileyPanel6 == null) {
            p.btv("smileyPanel");
        }
        smileyPanel6.setVisibility(4);
        SmileyPanel smileyPanel7 = this.hQS;
        if (smileyPanel7 == null) {
            p.btv("smileyPanel");
        }
        smileyPanel7.onResume();
        SmileyPanel smileyPanel8 = this.hQS;
        if (smileyPanel8 == null) {
            p.btv("smileyPanel");
        }
        smileyPanel8.setOnTextOperationListener(new f(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) this.wkX);
        SmileyPanel smileyPanel9 = this.hQS;
        if (smileyPanel9 == null) {
            p.btv("smileyPanel");
        }
        smileyPanel9.setLayoutParams(layoutParams);
        SmileyPanel smileyPanel10 = this.hQS;
        if (smileyPanel10 == null) {
            p.btv("smileyPanel");
        }
        addView(smileyPanel10, layoutParams);
        ImageView imageView2 = this.wkR;
        if (imageView2 == null) {
            p.btv("smileyBtn");
        }
        imageView2.setOnClickListener(new g(this));
        MMEditText mMEditText = this.wkS;
        if (mMEditText != null) {
            mMEditText.setBackListener(new h(this));
            AppMethodBeat.o(168390);
            return;
        }
        AppMethodBeat.o(168390);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
    public static final class f implements ChatFooterPanel.a {
        final /* synthetic */ FinderPostFooter wox;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(FinderPostFooter finderPostFooter) {
            this.wox = finderPostFooter;
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void append(String str) {
            AppMethodBeat.i(168381);
            MMEditText editText = this.wox.getEditText();
            if (editText != null) {
                editText.bol(str);
                AppMethodBeat.o(168381);
                return;
            }
            AppMethodBeat.o(168381);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHC() {
            InputConnection inputConnection;
            InputConnection inputConnection2;
            AppMethodBeat.i(168382);
            MMEditText editText = this.wox.getEditText();
            if (!(editText == null || (inputConnection2 = editText.getInputConnection()) == null)) {
                inputConnection2.sendKeyEvent(new KeyEvent(0, 67));
            }
            MMEditText editText2 = this.wox.getEditText();
            if (editText2 == null || (inputConnection = editText2.getInputConnection()) == null) {
                AppMethodBeat.o(168382);
                return;
            }
            inputConnection.sendKeyEvent(new KeyEvent(1, 67));
            AppMethodBeat.o(168382);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void eP(boolean z) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHD() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ FinderPostFooter wox;

        g(FinderPostFooter finderPostFooter) {
            this.wox = finderPostFooter;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168383);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.ImageView");
                AppMethodBeat.o(168383);
                throw tVar;
            }
            Object tag = ((ImageView) view).getTag();
            if (tag == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Boolean");
                AppMethodBeat.o(168383);
                throw tVar2;
            }
            FinderPostFooter.a(this.wox, !((Boolean) tag).booleanValue());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168383);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onBack"})
    static final class h implements MMEditText.a {
        final /* synthetic */ FinderPostFooter wox;

        h(FinderPostFooter finderPostFooter) {
            this.wox = finderPostFooter;
        }

        @Override // com.tencent.mm.ui.widget.MMEditText.a
        public final void onBack() {
            AppMethodBeat.i(168384);
            kotlin.g.a.a<x> backClickListener = this.wox.getBackClickListener();
            if (backClickListener != null) {
                backClickListener.invoke();
                AppMethodBeat.o(168384);
                return;
            }
            AppMethodBeat.o(168384);
        }
    }

    static /* synthetic */ void a(FinderPostFooter finderPostFooter, boolean z) {
        AppMethodBeat.i(168392);
        finderPostFooter.R(z, true);
        AppMethodBeat.o(168392);
    }

    public final void R(boolean z, boolean z2) {
        AppMethodBeat.i(168391);
        if (!z) {
            aHz();
            if (z2) {
                Context context = getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(168391);
                    throw tVar;
                }
                ((MMActivity) context).showVKB();
            }
        } else {
            dHa();
            Context context2 = getContext();
            if (context2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(168391);
                throw tVar2;
            }
            ((MMActivity) context2).hideVKB();
        }
        if (z) {
            ImageView imageView = this.wkR;
            if (imageView == null) {
                p.btv("smileyBtn");
            }
            imageView.setImageResource(R.drawable.oh);
            AppMethodBeat.o(168391);
            return;
        }
        ImageView imageView2 = this.wkR;
        if (imageView2 == null) {
            p.btv("smileyBtn");
        }
        imageView2.setImageResource(R.drawable.of);
        AppMethodBeat.o(168391);
    }

    private final void dHa() {
        AppMethodBeat.i(168393);
        SmileyPanel smileyPanel = this.hQS;
        if (smileyPanel == null) {
            p.btv("smileyPanel");
        }
        smileyPanel.setVisibility(0);
        ImageView imageView = this.wkR;
        if (imageView == null) {
            p.btv("smileyBtn");
        }
        imageView.setImageResource(R.drawable.of);
        ImageView imageView2 = this.wkR;
        if (imageView2 == null) {
            p.btv("smileyBtn");
        }
        imageView2.setTag(Boolean.TRUE);
        SmileyPanel smileyPanel2 = this.hQS;
        if (smileyPanel2 == null) {
            p.btv("smileyPanel");
        }
        smileyPanel2.setAlpha(0.0f);
        SmileyPanel smileyPanel3 = this.hQS;
        if (smileyPanel3 == null) {
            p.btv("smileyPanel");
        }
        smileyPanel3.animate().alpha(1.0f).setDuration(220).setListener(null).start();
        AppMethodBeat.o(168393);
    }

    private final void aHz() {
        AppMethodBeat.i(168394);
        ImageView imageView = this.wkR;
        if (imageView == null) {
            p.btv("smileyBtn");
        }
        imageView.setImageResource(R.drawable.of);
        ImageView imageView2 = this.wkR;
        if (imageView2 == null) {
            p.btv("smileyBtn");
        }
        imageView2.setTag(Boolean.FALSE);
        SmileyPanel smileyPanel = this.hQS;
        if (smileyPanel == null) {
            p.btv("smileyPanel");
        }
        smileyPanel.animate().alpha(0.0f).setDuration(220).setListener(new i(this)).start();
        AppMethodBeat.o(168394);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderPostFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class i implements Animator.AnimatorListener {
        final /* synthetic */ FinderPostFooter wox;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(FinderPostFooter finderPostFooter) {
            this.wox = finderPostFooter;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(168385);
            this.wox.getSmileyPanel().setAlpha(1.0f);
            this.wox.getSmileyPanel().setVisibility(4);
            AppMethodBeat.o(168385);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }
}
