package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderWxMsgUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "commentCnt", "", "likeCnt", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "objectLikeLikeCnt", "objectRecommendLikeCnt", "wxContact", "Lcom/tencent/mm/storage/Contact;", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onResume", "onStop", "plugin-finder_release"})
public final class FinderWxMsgUIC extends UIComponent implements FinderMsgContract.MsgViewCallback.UICallbackListener {
    private final FinderMsgContract.MsgPresenter vJX = new FinderMsgContract.MsgPresenter(2, 1, new int[]{3, 2, 7, 8, 11});
    private as wBE;
    private int wBF;
    private int wBG;
    private int wBH;
    private int wBI;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderWxMsgUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(256097);
        AppMethodBeat.o(256097);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(256092);
        super.onCreate(bundle);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        this.wBE = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(z.aTY());
        as asVar = this.wBE;
        if (asVar != null) {
            AppCompatActivity activity = getActivity();
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(256092);
                throw tVar;
            }
            ((MMActivity) activity).setMMTitle(getActivity().getString(R.string.d2f, new Object[]{asVar.arI()}));
        }
        AppCompatActivity activity2 = getActivity();
        if (activity2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(256092);
            throw tVar2;
        }
        ((MMActivity) activity2).setBackBtn(new a(this));
        AppCompatActivity activity3 = getActivity();
        if (activity3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(256092);
            throw tVar3;
        }
        FinderMsgContract.MsgViewCallback msgViewCallback = new FinderMsgContract.MsgViewCallback((MMActivity) activity3, getRootView(), this.vJX, this);
        this.vJX.a(msgViewCallback);
        msgViewCallback.initView();
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        this.wBF = aAh.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_COMMENT_INT_SYNC, 0);
        e aAh2 = g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        this.wBG = aAh2.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_LIKE_INT_SYNC, 0);
        e aAh3 = g.aAh();
        p.g(aAh3, "MMKernel.storage()");
        this.wBH = aAh3.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_LIKE_INT_SYNC, 0);
        e aAh4 = g.aAh();
        p.g(aAh4, "MMKernel.storage()");
        this.wBI = aAh4.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_LIKE_INT_SYNC, 0);
        e aAh5 = g.aAh();
        p.g(aAh5, "MMKernel.storage()");
        aAh5.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_COMMENT_INT_SYNC, (Object) 0);
        e aAh6 = g.aAh();
        p.g(aAh6, "MMKernel.storage()");
        aAh6.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_LIKE_INT_SYNC, (Object) 0);
        e aAh7 = g.aAh();
        p.g(aAh7, "MMKernel.storage()");
        aAh7.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_LIEK_LIKE_INT_SYNC, (Object) 0);
        e aAh8 = g.aAh();
        p.g(aAh8, "MMKernel.storage()");
        aAh8.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_RECOMMEND_LIKE_INT_SYNC, (Object) 0);
        e aAh9 = g.aAh();
        p.g(aAh9, "MMKernel.storage()");
        aAh9.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_FOLLOW_ACCEPT_INT_SYNC, (Object) 0);
        com.tencent.mm.kernel.b.a ah = g.ah(aj.class);
        p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
        ((aj) ah).getRedDotManager().asV("TLWxBubble");
        AppMethodBeat.o(256092);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderWxMsgUIC wBJ;

        a(FinderWxMsgUIC finderWxMsgUIC) {
            this.wBJ = finderWxMsgUIC;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(256091);
            this.wBJ.getActivity().finish();
            AppMethodBeat.o(256091);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(256093);
        super.onResume();
        this.vJX.uYq = System.currentTimeMillis();
        AppMethodBeat.o(256093);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStop() {
        AppMethodBeat.i(256094);
        super.onStop();
        this.vJX.onStop();
        AppMethodBeat.o(256094);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.ala;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(256095);
        super.onDestroy();
        this.vJX.onDetach();
        AppMethodBeat.o(256095);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener
    public final void a(ao aoVar) {
        AppMethodBeat.i(256096);
        p.h(aoVar, "mention");
        AppMethodBeat.o(256096);
    }
}
