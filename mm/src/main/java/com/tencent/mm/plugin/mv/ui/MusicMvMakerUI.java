package com.tencent.mm.plugin.mv.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.on;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.p;
import com.tencent.mm.plugin.gallery.ui.c;
import com.tencent.mm.plugin.music.ui.transition.GravityArcMotion;
import com.tencent.mm.plugin.mv.a.d;
import com.tencent.mm.plugin.mv.ui.adapter.b;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerDataUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerItemEditUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvSaveDraftUIC;
import com.tencent.mm.plugin.mv.ui.view.FTSSearchNoActionBarView;
import com.tencent.mm.plugin.mv.ui.view.FirstRowLayoutManager;
import com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMachineFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyFavFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyLikeFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyPostFragment;
import com.tencent.mm.plugin.mv.ui.view.MusicMvTabSearchFragment;
import com.tencent.mm.plugin.thumbplayer.view.MMTPRecyclerVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import kotlin.a.ak;
import kotlin.x;

@com.tencent.mm.ui.base.a(33)
@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020.H\u0014J\u0018\u0010/\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020201\u0018\u000100H\u0016J$\u00103\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u0001052\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020,\u0018\u000107H\u0002J\u001a\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020:2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0012\u0010;\u001a\u00020,2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u00020,H\u0014J\u001a\u0010?\u001a\u00020,2\u0006\u00109\u001a\u00020@2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020.H\u0016J\b\u0010C\u001a\u00020,H\u0014J\b\u0010D\u001a\u00020,H\u0014J\b\u0010E\u001a\u00020,H\u0016R#\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR#\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\f0\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR#\u0010\u0010\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0011\u0010\bR#\u0010\u0013\u001a\n \u0006*\u0004\u0018\u00010\u00140\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0018\u001a\n \u0006*\u0004\u0018\u00010\u00190\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u001d\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\bR#\u0010 \u001a\n \u0006*\u0004\u0018\u00010!0!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\n\u001a\u0004\b\"\u0010#R#\u0010%\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0002¢\u0006\f\n\u0004\b'\u0010\n\u001a\u0004\b&\u0010\bR#\u0010(\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b)\u0010\b¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/MusicMvMakerUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$IChoosePanelActionListener;", "()V", "albumAnimationContainer", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getAlbumAnimationContainer", "()Landroid/view/View;", "albumAnimationContainer$delegate", "Lkotlin/Lazy;", "albumFakeThumb", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "getAlbumFakeThumb", "()Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "albumFakeThumb$delegate", "cancelBtn", "getCancelBtn", "cancelBtn$delegate", "mvCardRV", "Landroid/support/v7/widget/RecyclerView;", "getMvCardRV", "()Landroid/support/v7/widget/RecyclerView;", "mvCardRV$delegate", "mvChooseView", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView;", "getMvChooseView", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView;", "mvChooseView$delegate", "mvItemEditBottomLine", "getMvItemEditBottomLine", "mvItemEditBottomLine$delegate", "mvItemEditThumb", "Landroid/widget/ImageView;", "getMvItemEditThumb", "()Landroid/widget/ImageView;", "mvItemEditThumb$delegate", "mvListEditBottomLine", "getMvListEditBottomLine", "mvListEditBottomLine$delegate", "nextBtn", "getNextBtn", "nextBtn$delegate", "finish", "", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "makeMediaThumbTransition", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "onAnimationEnd", "Lkotlin/Function0;", "onAlbumItemClicked", "data", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFeederItemClicked", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "onHeaderCameraClicked", "minDuration", "onPause", "onResume", "onSearchBarClicked", "Companion", "plugin-mv_release"})
public final class MusicMvMakerUI extends BaseMusicMvUI implements MusicMVCardChooseView.b {
    public static final a Arf = new a((byte) 0);
    private static int mEX;
    private static int mEY;
    private final kotlin.f Ard = kotlin.g.ah(new d(this));
    private final kotlin.f Are = kotlin.g.ah(new c(this));
    private final kotlin.f Auz = kotlin.g.ah(new n(this));
    private final kotlin.f UZG = kotlin.g.ah(new q(this));
    private final kotlin.f UZH = kotlin.g.ah(new o(this));
    private final kotlin.f UZI = kotlin.g.ah(new k(this));
    private final kotlin.f UZJ = kotlin.g.ah(new l(this));
    private final kotlin.f UZK = kotlin.g.ah(new p(this));
    private HashMap _$_findViewCache;
    private final kotlin.f vJB = kotlin.g.ah(new m(this));

    static {
        AppMethodBeat.i(256907);
        AppMethodBeat.o(256907);
    }

    private final View hWA() {
        AppMethodBeat.i(259215);
        View view = (View) this.UZI.getValue();
        AppMethodBeat.o(259215);
        return view;
    }

    private final MMRoundCornerImageView hWB() {
        AppMethodBeat.i(259216);
        MMRoundCornerImageView mMRoundCornerImageView = (MMRoundCornerImageView) this.UZJ.getValue();
        AppMethodBeat.o(259216);
        return mMRoundCornerImageView;
    }

    private final RecyclerView hWC() {
        AppMethodBeat.i(259217);
        RecyclerView recyclerView = (RecyclerView) this.Auz.getValue();
        AppMethodBeat.o(259217);
        return recyclerView;
    }

    private final View hWy() {
        AppMethodBeat.i(259213);
        View view = (View) this.UZG.getValue();
        AppMethodBeat.o(259213);
        return view;
    }

    private final MusicMVCardChooseView hWz() {
        AppMethodBeat.i(259214);
        MusicMVCardChooseView musicMVCardChooseView = (MusicMVCardChooseView) this.UZH.getValue();
        AppMethodBeat.o(259214);
        return musicMVCardChooseView;
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(256911);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(256911);
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(256910);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(256910);
        return view;
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MusicMvMakerUI() {
        AppMethodBeat.i(256906);
        AppMethodBeat.o(256906);
    }

    public static final /* synthetic */ MusicMVCardChooseView a(MusicMvMakerUI musicMvMakerUI) {
        AppMethodBeat.i(259218);
        MusicMVCardChooseView hWz = musicMvMakerUI.hWz();
        AppMethodBeat.o(259218);
        return hWz;
    }

    public static final /* synthetic */ View b(MusicMvMakerUI musicMvMakerUI) {
        AppMethodBeat.i(259219);
        View hWA = musicMvMakerUI.hWA();
        AppMethodBeat.o(259219);
        return hWA;
    }

    public static final /* synthetic */ MMRoundCornerImageView c(MusicMvMakerUI musicMvMakerUI) {
        AppMethodBeat.i(259220);
        MMRoundCornerImageView hWB = musicMvMakerUI.hWB();
        AppMethodBeat.o(259220);
        return hWB;
    }

    public static final /* synthetic */ View g(MusicMvMakerUI musicMvMakerUI) {
        AppMethodBeat.i(259224);
        View hWy = musicMvMakerUI.hWy();
        AppMethodBeat.o(259224);
        return hWy;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/MusicMvMakerUI$Companion;", "", "()V", "TAG", "", "screenHeight", "", "screenWidth", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(256896);
        Set<Class<? extends UIComponent>> importUIComponents = super.importUIComponents();
        if (importUIComponents != null) {
            Set<Class<? extends UIComponent>> b2 = ak.b(importUIComponents, ak.setOf((Object[]) new Class[]{MusicMvMakerEditUIC.class, MusicMvMakerItemEditUIC.class, MusicMvMakerDataUIC.class, MusicMvSaveDraftUIC.class}));
            AppMethodBeat.o(256896);
            return b2;
        }
        AppMethodBeat.o(256896);
        return null;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.beg;
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(256897);
        super.onCreate(bundle);
        hideTitleView();
        AppCompatActivity context = getContext();
        kotlin.g.b.p.g(context, "context");
        setActionbarColor(context.getResources().getColor(R.color.ac_));
        hideActionbarLine();
        View view = (View) this.vJB.getValue();
        if (view != null) {
            view.setOnClickListener(new f(this));
        }
        View hWy = hWy();
        if (hWy != null) {
            hWy.setOnClickListener(new g(this));
        }
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(this).get(MusicMvMakerDataUIC.class);
        kotlin.g.b.p.g(viewModel, "UICProvider.of(this).get…MakerDataUIC::class.java)");
        MusicMvMakerDataUIC musicMvMakerDataUIC = (MusicMvMakerDataUIC) viewModel;
        musicMvMakerDataUIC.Auy = new h(this, musicMvMakerDataUIC);
        com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
        csp csp = musicMvMakerDataUIC.AqY;
        com.tencent.mm.plugin.finder.report.i.as(10, (csp != null ? csp.localId : 0) != 0);
        com.tencent.mm.plugin.finder.report.i iVar2 = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.Kp(5);
        com.tencent.mm.plugin.finder.report.i iVar3 = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.music.model.e.a aVar2 = musicMvMakerDataUIC.AkC;
        if (aVar2 == null || (str = aVar2.field_musicId) == null) {
            str = "";
        }
        com.tencent.mm.plugin.finder.report.i.auE(str);
        com.tencent.mm.plugin.finder.report.i iVar4 = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.Kq(2);
        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
        ((MusicMvMakerItemEditUIC) com.tencent.mm.ui.component.a.b(this).get(MusicMvMakerItemEditUIC.class)).Avl = new i(this);
        AppMethodBeat.o(256897);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ MusicMvMakerUI Arg;

        f(MusicMvMakerUI musicMvMakerUI) {
            this.Arg = musicMvMakerUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256882);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this.Arg).get(MusicMvMakerEditUIC.class)).onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256882);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ MusicMvMakerUI Arg;

        g(MusicMvMakerUI musicMvMakerUI) {
            this.Arg = musicMvMakerUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256883);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            MusicMvMakerEditUIC musicMvMakerEditUIC = (MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this.Arg).get(MusicMvMakerEditUIC.class);
            Intent intent = new Intent(musicMvMakerEditUIC.getActivity(), MusicMvMakerPreviewUI.class);
            csp d2 = musicMvMakerEditUIC.d(musicMvMakerEditUIC.AqY);
            if (d2 != null) {
                intent.putExtra("key_track_data", d2.toByteArray());
            }
            intent.putExtra("key_seek_to_start", true);
            com.tencent.mm.ac.d.a(intent, musicMvMakerEditUIC.getActivity().getIntent(), "key_mv_from_scene");
            com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
            com.tencent.mm.plugin.music.model.c.sm(true);
            AppCompatActivity activity = musicMvMakerEditUIC.getActivity();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC", "onNextBtnClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC", "onNextBtnClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.mv.a.l lVar = com.tencent.mm.plugin.mv.a.l.UZs;
            on hWv = com.tencent.mm.plugin.mv.a.l.hWv();
            hWv.PV(6);
            hWv.bfK();
            com.tencent.mm.util.b bVar2 = com.tencent.mm.util.b.QYu;
            com.tencent.mm.util.b.a(hWv);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256883);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$3", "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnDataReadyListener;", "onInitDataReady", "", "plugin-mv_release"})
    public static final class h implements com.tencent.mm.plugin.mv.ui.uic.a.b {
        final /* synthetic */ MusicMvMakerUI Arg;
        final /* synthetic */ MusicMvMakerDataUIC Ark;

        h(MusicMvMakerUI musicMvMakerUI, MusicMvMakerDataUIC musicMvMakerDataUIC) {
            this.Arg = musicMvMakerUI;
            this.Ark = musicMvMakerDataUIC;
        }

        @Override // com.tencent.mm.plugin.mv.ui.uic.a.b
        public final void evE() {
            String str;
            FTSEditTextView ftsEditText;
            ImageButton clearBtn;
            FTSEditTextView ftsEditText2;
            FTSEditTextView ftsEditText3;
            FTSEditTextView ftsEditText4;
            FTSEditTextView ftsEditText5;
            FTSEditTextView ftsEditText6;
            FTSEditTextView ftsEditText7;
            FTSEditTextView ftsEditText8;
            FTSEditTextView ftsEditText9;
            FinderObjectDesc finderObjectDesc;
            axw axw;
            LinkedList<axz> linkedList;
            FinderObjectDesc finderObjectDesc2;
            axw axw2;
            LinkedList<axz> linkedList2;
            com.tencent.mm.plugin.mv.a.d dVar;
            LinkedList<axz> linkedList3;
            axz axz;
            com.tencent.mm.plugin.music.model.e i2;
            AppMethodBeat.i(256889);
            MusicMvMakerUI musicMvMakerUI = this.Arg;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.b(musicMvMakerUI).get(MusicMvMakerEditUIC.class);
            kotlin.g.b.p.g(viewModel, "UICProvider.of(activity)…MakerEditUIC::class.java)");
            MusicMvMakerEditUIC musicMvMakerEditUIC = (MusicMvMakerEditUIC) viewModel;
            musicMvMakerEditUIC.AqY = this.Ark.AqY;
            musicMvMakerEditUIC.AkC = this.Ark.AkC;
            musicMvMakerEditUIC.fromScene = musicMvMakerEditUIC.getIntent().getIntExtra("key_mv_from_scene", 0);
            WxRecyclerView evW = musicMvMakerEditUIC.evW();
            kotlin.g.b.p.g(evW, "mvCardRV");
            evW.setItemAnimator(null);
            WxRecyclerView evW2 = musicMvMakerEditUIC.evW();
            kotlin.g.b.p.g(evW2, "mvCardRV");
            evW2.setLayoutManager(musicMvMakerEditUIC.getLayoutManager());
            WxRecyclerView evW3 = musicMvMakerEditUIC.evW();
            kotlin.g.b.p.g(evW3, "mvCardRV");
            evW3.setAdapter(musicMvMakerEditUIC.getAdapter());
            musicMvMakerEditUIC.evW().setPadding(MusicMvMakerEditUIC.f.getPadding(), 0, MusicMvMakerEditUIC.f.getPadding(), 0);
            musicMvMakerEditUIC.AuC.gRD = com.tencent.mm.cb.a.jn(musicMvMakerEditUIC.getContext());
            musicMvMakerEditUIC.evW().addOnLayoutChangeListener(new MusicMvMakerEditUIC.i(musicMvMakerEditUIC));
            musicMvMakerEditUIC.evW().b(musicMvMakerEditUIC.evX());
            musicMvMakerEditUIC.AtW.hbS = new MusicMvMakerEditUIC.j(musicMvMakerEditUIC);
            musicMvMakerEditUIC.getAdapter().a(new MusicMvMakerEditUIC.k(musicMvMakerEditUIC));
            csp csp = musicMvMakerEditUIC.AqY;
            if (csp != null) {
                d.b bVar = com.tencent.mm.plugin.mv.a.d.Aps;
                com.tencent.mm.plugin.music.model.e.a aVar2 = musicMvMakerEditUIC.AkC;
                kotlin.g.b.p.h(csp, "trackData");
                LinkedList linkedList4 = new LinkedList();
                LinkedList linkedList5 = new LinkedList();
                com.tencent.mm.plugin.music.model.e eVar = (aVar2 == null || (i2 = com.tencent.mm.plugin.music.model.o.euD().i(aVar2)) == null) ? null : i2;
                FinderObject finderObject = csp.MxE;
                if (!(finderObject == null || (finderObjectDesc2 = finderObject.objectDesc) == null || (axw2 = finderObjectDesc2.mvInfo) == null || (linkedList2 = axw2.LId) == null)) {
                    int i3 = 0;
                    for (T t : linkedList2) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            kotlin.a.j.hxH();
                        }
                        T t2 = t;
                        d.b bVar2 = com.tencent.mm.plugin.mv.a.d.Aps;
                        kotlin.g.b.p.g(t2, "mvTrack");
                        LinkedList<FinderObject> linkedList6 = csp.LDi;
                        kotlin.g.b.p.g(linkedList6, "trackData.refObjectList");
                        com.tencent.mm.plugin.mv.a.d a2 = d.b.a(t2, eVar, linkedList6);
                        axw axw3 = csp.MxG;
                        if (axw3 == null || (linkedList3 = axw3.LId) == null || (axz = (axz) kotlin.a.j.L(linkedList3, i3)) == null) {
                            dVar = null;
                        } else {
                            d.b bVar3 = com.tencent.mm.plugin.mv.a.d.Aps;
                            LinkedList<FinderObject> linkedList7 = csp.LDi;
                            kotlin.g.b.p.g(linkedList7, "trackData.refObjectList");
                            com.tencent.mm.plugin.mv.a.d a3 = d.b.a(axz, eVar, linkedList7);
                            a3.type = 0;
                            if (!kotlin.g.b.p.j(t2.LIm, axz.LIm)) {
                                a2.Apq = a3;
                                dVar = a3;
                            } else {
                                a2.type = 0;
                                dVar = a3;
                            }
                        }
                        linkedList4.add(a2);
                        if (dVar == null) {
                            dVar = a2;
                        }
                        linkedList5.add(dVar);
                        i3 = i4;
                    }
                }
                kotlin.o oVar = new kotlin.o(linkedList4, linkedList5);
                A a4 = oVar.first;
                B b2 = oVar.second;
                Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "updateMusicItemList size:" + a4.size() + ", origin size:" + b2.size());
                musicMvMakerEditUIC.kgc.clear();
                musicMvMakerEditUIC.kgc.addAll(a4);
                musicMvMakerEditUIC.AuA.clear();
                musicMvMakerEditUIC.AuA.addAll(b2);
                musicMvMakerEditUIC.getAdapter().notifyDataSetChanged();
                musicMvMakerEditUIC.evW().post(new MusicMvMakerEditUIC.v(musicMvMakerEditUIC));
                ArrayList arrayList = new ArrayList();
                arrayList.add(0L);
                FinderObject finderObject2 = csp.MxE;
                if (!(finderObject2 == null || (finderObjectDesc = finderObject2.objectDesc) == null || (axw = finderObjectDesc.mvInfo) == null || (linkedList = axw.LId) == null)) {
                    LinkedList<axz> linkedList8 = linkedList;
                    ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(linkedList8, 10));
                    for (T t3 : linkedList8) {
                        arrayList2.add(Long.valueOf(t3.Ghu + ((long) t3.LIl)));
                    }
                    arrayList.addAll(arrayList2);
                }
                musicMvMakerEditUIC.evX().fD(arrayList);
            }
            musicMvMakerEditUIC.AuG = new MMTPRecyclerVideoLayout(musicMvMakerEditUIC.getActivity());
            MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout = musicMvMakerEditUIC.AuG;
            if (mMTPRecyclerVideoLayout != null) {
                mMTPRecyclerVideoLayout.fxf();
            }
            MMTPRecyclerVideoLayout mMTPRecyclerVideoLayout2 = musicMvMakerEditUIC.AuG;
            if (mMTPRecyclerVideoLayout2 != null) {
                mMTPRecyclerVideoLayout2.setId(R.id.fqq);
            }
            musicMvMakerEditUIC.AuE = new a(this);
            MusicMvMakerUI.mEX = com.tencent.mm.cb.a.jn(musicMvMakerUI);
            MusicMvMakerUI.mEY = au.az(musicMvMakerUI).y;
            com.tencent.mm.plugin.music.model.e.a aVar3 = this.Ark.AkC;
            if (aVar3 != null) {
                int i5 = (int) (((float) MusicMvMakerUI.mEY) * 0.45f);
                int fromDPToPix = MusicMvMakerUI.mEY - com.tencent.mm.cb.a.fromDPToPix((Context) musicMvMakerUI, 64);
                MusicMVCardChooseView a5 = MusicMvMakerUI.a(this.Arg);
                if (a5 != null) {
                    MusicMvMakerUI musicMvMakerUI2 = musicMvMakerUI;
                    kotlin.g.b.p.h(musicMvMakerUI2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                    kotlin.g.b.p.h(aVar3, "music");
                    a5.activity = musicMvMakerUI2;
                    a5.AkC = aVar3;
                    a5.minHeight = i5;
                    a5.maxHeight = fromDPToPix;
                    a5.mEX = com.tencent.mm.cb.a.jn(a5.getContext());
                    View.inflate(a5.getContext(), R.layout.be3, a5);
                    MusicMVCardChooseView.a(a5, a5.minHeight);
                    RelativeLayout relativeLayout = (RelativeLayout) a5._$_findCachedViewById(R.id.doo);
                    if (relativeLayout != null) {
                        relativeLayout.setOnClickListener(new MusicMVCardChooseView.h(a5));
                    }
                    a5.ewl();
                    a5.qUd = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_jump_to_record_media, true);
                    a5.AwC = (RecyclerView) a5.findViewById(R.id.j4);
                    Context context = a5.getContext();
                    kotlin.g.b.p.g(context, "context");
                    a5.AwD = new com.tencent.mm.plugin.mv.ui.adapter.b(context);
                    b.c.a aVar4 = new b.c.a();
                    com.tencent.mm.plugin.mv.ui.adapter.b bVar4 = a5.AwD;
                    if (bVar4 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    b.c.a aVar5 = aVar4;
                    bVar4.xns.remove(aVar5);
                    bVar4.xns.add(aVar5);
                    RecyclerView recyclerView = a5.AwC;
                    if (recyclerView != null) {
                        recyclerView.setAdapter(a5.AwD);
                    }
                    MMActivity mMActivity = a5.activity;
                    FirstRowLayoutManager firstRowLayoutManager = new FirstRowLayoutManager(mMActivity != null ? mMActivity.getContext() : null, 4);
                    RecyclerView recyclerView2 = a5.AwC;
                    if (recyclerView2 != null) {
                        recyclerView2.setLayoutManager(firstRowLayoutManager);
                    }
                    com.tencent.mm.plugin.gallery.ui.c dSf = new c.a(a5.getContext()).NP(R.dimen.af2).NO(R.dimen.af2).dSd().dSe().dSf();
                    RecyclerView recyclerView3 = a5.AwC;
                    if (recyclerView3 != null) {
                        recyclerView3.b(dSf);
                    }
                    RecyclerView recyclerView4 = a5.AwC;
                    if (recyclerView4 != null) {
                        recyclerView4.a(new MusicMVCardChooseView.g(a5, firstRowLayoutManager));
                    }
                    RecyclerView recyclerView5 = a5.AwC;
                    if (recyclerView5 != null) {
                        recyclerView5.setOnFlingListener(a5.AwU);
                    }
                    com.tencent.mm.plugin.mv.ui.adapter.b bVar5 = a5.AwD;
                    if (bVar5 != null) {
                        bVar5.ArL = a5.ArL;
                    }
                    MMActivity mMActivity2 = a5.activity;
                    String[] strArr = {"android.permission.READ_EXTERNAL_STORAGE"};
                    MMActivity mMActivity3 = a5.activity;
                    String string = mMActivity3 != null ? mMActivity3.getString(R.string.flp) : null;
                    MMActivity mMActivity4 = a5.activity;
                    a5.xot = com.tencent.mm.pluginsdk.permission.b.a(mMActivity2, strArr, 145, string, mMActivity4 != null ? mMActivity4.getString(R.string.dlz) : null);
                    Log.i("MicroMsg.Mv.MusicMVCardChooseView", "checkPermission checkMediaStorage[%b]", Boolean.valueOf(a5.xot));
                    a5.Axa = MusicMVCardChooseView.c.CREATE;
                    MMActivity mMActivity5 = a5.activity;
                    MMActivity mMActivity6 = a5.activity;
                    if (mMActivity6 != null) {
                        str = mMActivity6.getString(R.string.a06);
                    } else {
                        str = null;
                    }
                    a5.gtM = com.tencent.mm.ui.base.q.b(mMActivity5, str, false, 0, null);
                    com.tencent.mm.plugin.gallery.model.o dQK = com.tencent.mm.plugin.gallery.model.e.dQK();
                    kotlin.g.b.p.g(dQK, "GalleryCore.getMediaQueryService()");
                    dQK.NG(a5.het);
                    com.tencent.mm.plugin.gallery.model.o dQK2 = com.tencent.mm.plugin.gallery.model.e.dQK();
                    kotlin.g.b.p.g(dQK2, "GalleryCore.getMediaQueryService()");
                    dQK2.setQueryType(a5.xos);
                    Log.i("MicroMsg.Mv.MusicMVCardChooseView", "query source: " + a5.het + ", queryType: " + a5.xos);
                    a5.initView();
                    if (a5.xot) {
                        com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.iub).aSq();
                        com.tencent.mm.plugin.gallery.a.dQq().setScene(a5.het);
                        Log.i("MicroMsg.Mv.MusicMVCardChooseView", "start queryMediaInAlbums %s", a5);
                        com.tencent.mm.plugin.gallery.model.e.dQK().a(a5);
                        a5.xov = MusicMVCardChooseView.ewo();
                        com.tencent.mm.plugin.gallery.model.e.dQK().ax("", a5.xov);
                        RecyclerView recyclerView6 = a5.AwC;
                        if (recyclerView6 != null) {
                            recyclerView6.postDelayed(new MusicMVCardChooseView.v(a5), 300);
                        }
                        p.a aVar6 = com.tencent.mm.plugin.gallery.model.p.xjw;
                        com.tencent.mm.plugin.gallery.model.p.xjv.a(new com.tencent.mm.plugin.gallery.model.l());
                        p.a aVar7 = com.tencent.mm.plugin.gallery.model.p.xjw;
                        com.tencent.mm.plugin.gallery.model.p.xjv.a(new com.tencent.mm.plugin.gallery.model.q());
                    }
                    com.tencent.mm.plugin.gallery.model.e.dQS();
                    a5.AwE = (RelativeLayout) a5.findViewById(R.id.ckp);
                    RelativeLayout relativeLayout2 = a5.AwE;
                    if (relativeLayout2 != null) {
                        relativeLayout2.setVisibility(4);
                    }
                    a5.AwF = (RelativeLayout) a5.findViewById(R.id.d01);
                    a5.AwG = (WeImageView) a5.findViewById(R.id.hd9);
                    WeImageView weImageView = a5.AwG;
                    if (weImageView != null) {
                        weImageView.setOnClickListener(new MusicMVCardChooseView.i(a5));
                    }
                    a5.AwI = (FTSSearchNoActionBarView) a5.findViewById(R.id.hf7);
                    FTSSearchNoActionBarView fTSSearchNoActionBarView = a5.AwI;
                    if (fTSSearchNoActionBarView != null) {
                        fTSSearchNoActionBarView.setSearchViewListener(a5);
                    }
                    FTSSearchNoActionBarView fTSSearchNoActionBarView2 = a5.AwI;
                    if (!(fTSSearchNoActionBarView2 == null || (ftsEditText9 = fTSSearchNoActionBarView2.getFtsEditText()) == null)) {
                        ftsEditText9.setHint(a5.getContext().getString(R.string.yn));
                    }
                    FTSSearchNoActionBarView fTSSearchNoActionBarView3 = a5.AwI;
                    if (!(fTSSearchNoActionBarView3 == null || (ftsEditText8 = fTSSearchNoActionBarView3.getFtsEditText()) == null)) {
                        Context context2 = a5.getContext();
                        kotlin.g.b.p.g(context2, "context");
                        ftsEditText8.setHintColor(context2.getResources().getColor(R.color.BW_100_Alpha_0_5));
                    }
                    FTSSearchNoActionBarView fTSSearchNoActionBarView4 = a5.AwI;
                    if (!(fTSSearchNoActionBarView4 == null || (ftsEditText7 = fTSSearchNoActionBarView4.getFtsEditText()) == null)) {
                        Context context3 = a5.getContext();
                        kotlin.g.b.p.g(context3, "context");
                        ftsEditText7.setTextColor(context3.getResources().getColor(R.color.BW_100_Alpha_0_8));
                    }
                    FTSSearchNoActionBarView fTSSearchNoActionBarView5 = a5.AwI;
                    if (!(fTSSearchNoActionBarView5 == null || (ftsEditText6 = fTSSearchNoActionBarView5.getFtsEditText()) == null)) {
                        ftsEditText6.setFtsEditTextListener(a5);
                    }
                    FTSSearchNoActionBarView fTSSearchNoActionBarView6 = a5.AwI;
                    if (!(fTSSearchNoActionBarView6 == null || (ftsEditText5 = fTSSearchNoActionBarView6.getFtsEditText()) == null)) {
                        ftsEditText5.setCanDeleteTag(false);
                    }
                    FTSSearchNoActionBarView fTSSearchNoActionBarView7 = a5.AwI;
                    if (!(fTSSearchNoActionBarView7 == null || (ftsEditText4 = fTSSearchNoActionBarView7.getFtsEditText()) == null)) {
                        ftsEditText4.gUA();
                    }
                    FTSSearchNoActionBarView fTSSearchNoActionBarView8 = a5.AwI;
                    if (!(fTSSearchNoActionBarView8 == null || (ftsEditText3 = fTSSearchNoActionBarView8.getFtsEditText()) == null)) {
                        ftsEditText3.hideVKB();
                    }
                    FTSSearchNoActionBarView fTSSearchNoActionBarView9 = a5.AwI;
                    if (!(fTSSearchNoActionBarView9 == null || (ftsEditText2 = fTSSearchNoActionBarView9.getFtsEditText()) == null)) {
                        ftsEditText2.gWY();
                    }
                    FTSSearchNoActionBarView fTSSearchNoActionBarView10 = a5.AwI;
                    if (!(fTSSearchNoActionBarView10 == null || (ftsEditText = fTSSearchNoActionBarView10.getFtsEditText()) == null || (clearBtn = ftsEditText.getClearBtn()) == null)) {
                        clearBtn.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
                    }
                    a5.AwH = (LinearLayout) a5.findViewById(R.id.her);
                    LinearLayout linearLayout = a5.AwH;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    a5.AwJ = (MusicMvTabSearchFragment) a5.findViewById(R.id.g8k);
                    MusicMvTabSearchFragment musicMvTabSearchFragment = a5.AwJ;
                    if (musicMvTabSearchFragment != null) {
                        musicMvTabSearchFragment.a(a5.AwY);
                    }
                    MusicMvTabSearchFragment musicMvTabSearchFragment2 = a5.AwJ;
                    if (musicMvTabSearchFragment2 != null) {
                        MusicMVCardChooseView.f fVar = a5.AwZ;
                        kotlin.g.b.p.h(fVar, "resultListener");
                        musicMvTabSearchFragment2.Azf = fVar;
                    }
                    MusicMvTabSearchFragment musicMvTabSearchFragment3 = a5.AwJ;
                    if (musicMvTabSearchFragment3 != null) {
                        musicMvTabSearchFragment3.setOnFlingListener(a5.AwU);
                    }
                    a5.vtJ = (TextView) a5.findViewById(R.id.g01);
                    a5.AwK = (LinearLayout) a5.findViewById(R.id.epl);
                    a5.AwL = (LinearLayout) a5.findViewById(R.id.ft0);
                    a5.AwM = (LinearLayout) a5.findViewById(R.id.ft2);
                    a5.AwN = (LinearLayout) a5.findViewById(R.id.fsu);
                    a5.AwO = (LinearLayout) a5.findViewById(R.id.ft1);
                    a5.AwP = (MusicMvTabMachineFragment) a5.findViewById(R.id.g8g);
                    a5.AwQ = (MusicMvTabMyPostFragment) a5.findViewById(R.id.g8j);
                    a5.AwR = (MusicMvTabMyFavFragment) a5.findViewById(R.id.g8h);
                    a5.AwS = (MusicMvTabMyLikeFragment) a5.findViewById(R.id.g8i);
                    MusicMvTabMyFavFragment musicMvTabMyFavFragment = a5.AwR;
                    if (musicMvTabMyFavFragment != null) {
                        musicMvTabMyFavFragment.a(a5.AwY);
                    }
                    MusicMvTabMachineFragment musicMvTabMachineFragment = a5.AwP;
                    if (musicMvTabMachineFragment != null) {
                        musicMvTabMachineFragment.a(a5.AwY);
                    }
                    MusicMvTabMyPostFragment musicMvTabMyPostFragment = a5.AwQ;
                    if (musicMvTabMyPostFragment != null) {
                        musicMvTabMyPostFragment.a(a5.AwY);
                    }
                    MusicMvTabMyLikeFragment musicMvTabMyLikeFragment = a5.AwS;
                    if (musicMvTabMyLikeFragment != null) {
                        musicMvTabMyLikeFragment.a(a5.AwY);
                    }
                    MusicMvTabMachineFragment musicMvTabMachineFragment2 = a5.AwP;
                    if (musicMvTabMachineFragment2 != null) {
                        musicMvTabMachineFragment2.a(a5.AkC, null);
                    }
                    MusicMvTabMyPostFragment musicMvTabMyPostFragment2 = a5.AwQ;
                    if (musicMvTabMyPostFragment2 != null) {
                        musicMvTabMyPostFragment2.a(a5.AkC, null);
                    }
                    MusicMvTabMyFavFragment musicMvTabMyFavFragment2 = a5.AwR;
                    if (musicMvTabMyFavFragment2 != null) {
                        musicMvTabMyFavFragment2.a(a5.AkC, null);
                    }
                    MusicMvTabMyLikeFragment musicMvTabMyLikeFragment2 = a5.AwS;
                    if (musicMvTabMyLikeFragment2 != null) {
                        musicMvTabMyLikeFragment2.a(a5.AkC, null);
                    }
                    MusicMvTabMachineFragment musicMvTabMachineFragment3 = a5.AwP;
                    if (musicMvTabMachineFragment3 != null) {
                        musicMvTabMachineFragment3.setOnFlingListener(a5.AwU);
                    }
                    MusicMvTabMyPostFragment musicMvTabMyPostFragment3 = a5.AwQ;
                    if (musicMvTabMyPostFragment3 != null) {
                        musicMvTabMyPostFragment3.setOnFlingListener(a5.AwU);
                    }
                    MusicMvTabMyFavFragment musicMvTabMyFavFragment3 = a5.AwR;
                    if (musicMvTabMyFavFragment3 != null) {
                        musicMvTabMyFavFragment3.setOnFlingListener(a5.AwU);
                    }
                    MusicMvTabMyLikeFragment musicMvTabMyLikeFragment3 = a5.AwS;
                    if (musicMvTabMyLikeFragment3 != null) {
                        musicMvTabMyLikeFragment3.setOnFlingListener(a5.AwU);
                    }
                    LinearLayout linearLayout2 = a5.AwL;
                    if (linearLayout2 != null) {
                        linearLayout2.setOnClickListener(new MusicMVCardChooseView.j(a5));
                    }
                    LinearLayout linearLayout3 = a5.AwM;
                    if (linearLayout3 != null) {
                        linearLayout3.setOnClickListener(new MusicMVCardChooseView.k(a5));
                    }
                    LinearLayout linearLayout4 = a5.AwN;
                    if (linearLayout4 != null) {
                        linearLayout4.setOnClickListener(new MusicMVCardChooseView.l(a5));
                    }
                    LinearLayout linearLayout5 = a5.AwO;
                    if (linearLayout5 != null) {
                        linearLayout5.setOnClickListener(new MusicMVCardChooseView.m(a5));
                    }
                    Log.i("MicroMsg.Mv.MusicMVCardChooseView", "init completed");
                }
                MusicMVCardChooseView a6 = MusicMvMakerUI.a(this.Arg);
                if (a6 != null) {
                    MusicMvMakerUI musicMvMakerUI3 = musicMvMakerUI;
                    kotlin.g.b.p.h(musicMvMakerUI3, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                    a6.AwV = musicMvMakerUI3;
                }
            }
            View g2 = MusicMvMakerUI.g(this.Arg);
            kotlin.g.b.p.g(g2, "nextBtn");
            com.tencent.mm.ui.component.a aVar8 = com.tencent.mm.ui.component.a.PRN;
            g2.setEnabled(((MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this.Arg).get(MusicMvMakerEditUIC.class)).evZ());
            AppMethodBeat.o(256889);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$3$onInitDataReady$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MVEditActionCallback;", "onEditItem", "", "position", "", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "fromSelectNewItem", "", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "onItemSelected", "onRollback", "onTakePhotoFinished", "plugin-mv_release"})
        public static final class a implements MusicMvMakerEditUIC.e {
            final /* synthetic */ h Arl;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(h hVar) {
                this.Arl = hVar;
            }

            @Override // com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.e
            public final void b(com.tencent.mm.plugin.mv.a.d dVar) {
                AppMethodBeat.i(256885);
                kotlin.g.b.p.h(dVar, "item");
                MusicMVCardChooseView a2 = MusicMvMakerUI.a(this.Arl.Arg);
                if (a2 != null) {
                    int durationMs = dVar.getDurationMs();
                    MusicMVCardChooseView.Axc = durationMs;
                    com.tencent.mm.plugin.mv.ui.adapter.b bVar = a2.AwD;
                    if (bVar != null) {
                        bVar.ArJ = durationMs;
                        bVar.notifyDataSetChanged();
                    }
                    MusicMvTabMachineFragment musicMvTabMachineFragment = a2.AwP;
                    if (musicMvTabMachineFragment != null) {
                        musicMvTabMachineFragment.setVideoDuration(durationMs);
                    }
                    MusicMvTabMyPostFragment musicMvTabMyPostFragment = a2.AwQ;
                    if (musicMvTabMyPostFragment != null) {
                        musicMvTabMyPostFragment.setVideoDuration(durationMs);
                    }
                    MusicMvTabMyFavFragment musicMvTabMyFavFragment = a2.AwR;
                    if (musicMvTabMyFavFragment != null) {
                        musicMvTabMyFavFragment.setVideoDuration(durationMs);
                    }
                    MusicMvTabMyLikeFragment musicMvTabMyLikeFragment = a2.AwS;
                    if (musicMvTabMyLikeFragment != null) {
                        musicMvTabMyLikeFragment.setVideoDuration(durationMs);
                    }
                    MusicMvTabSearchFragment musicMvTabSearchFragment = a2.AwJ;
                    if (musicMvTabSearchFragment != null) {
                        musicMvTabSearchFragment.setVideoDuration(durationMs);
                        AppMethodBeat.o(256885);
                        return;
                    }
                    AppMethodBeat.o(256885);
                    return;
                }
                AppMethodBeat.o(256885);
            }

            @Override // com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.e
            public final void evF() {
                AppMethodBeat.i(256886);
                MusicMVCardChooseView a2 = MusicMvMakerUI.a(this.Arl.Arg);
                if (a2 != null) {
                    com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.iub).aSq();
                    com.tencent.mm.plugin.gallery.a.dQq().setScene(a2.het);
                    Log.i("MicroMsg.Mv.MusicMVCardChooseView", "start queryMediaInAlbums %s", a2);
                    com.tencent.mm.plugin.gallery.model.e.dQK().a(a2);
                    a2.xov = MusicMVCardChooseView.ewo();
                    com.tencent.mm.plugin.gallery.model.e.dQK().ax("", a2.xov);
                    p.a aVar = com.tencent.mm.plugin.gallery.model.p.xjw;
                    com.tencent.mm.plugin.gallery.model.p.xjv.a(new com.tencent.mm.plugin.gallery.model.l());
                    p.a aVar2 = com.tencent.mm.plugin.gallery.model.p.xjw;
                    com.tencent.mm.plugin.gallery.model.p.xjv.a(new com.tencent.mm.plugin.gallery.model.q());
                    AppMethodBeat.o(256886);
                    return;
                }
                AppMethodBeat.o(256886);
            }

            @Override // com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.e
            public final void a(com.tencent.mm.plugin.mv.a.d dVar, boolean z, com.tencent.mm.plugin.mv.a.f fVar) {
                AppMethodBeat.i(256887);
                kotlin.g.b.p.h(dVar, "item");
                if (fVar != null) {
                    View b2 = MusicMvMakerUI.b(this.Arl.Arg);
                    kotlin.g.b.p.g(b2, "albumAnimationContainer");
                    b2.setVisibility(0);
                    MusicMvMakerUI.c(this.Arl.Arg).setRadius(com.tencent.mm.cb.a.fromDPToPix((Context) this.Arl.Arg.getContext(), 12));
                    ImageView d2 = MusicMvMakerUI.d(this.Arl.Arg);
                    kotlin.g.b.p.g(d2, "mvItemEditThumb");
                    ImageView imageView = d2;
                    MMRoundCornerImageView c2 = MusicMvMakerUI.c(this.Arl.Arg);
                    kotlin.g.b.p.g(c2, "albumFakeThumb");
                    MMRoundCornerImageView mMRoundCornerImageView = c2;
                    kotlin.g.b.p.h(imageView, "to");
                    kotlin.g.b.p.h(mMRoundCornerImageView, "animateView");
                    Animator a2 = fVar.a(com.tencent.mm.plugin.mv.a.g.eC(imageView), mMRoundCornerImageView, false);
                    a2.addListener(new C1544a(this));
                    a2.setDuration(250);
                    a2.start();
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    ((MusicMvMakerItemEditUIC) com.tencent.mm.ui.component.a.b(this.Arl.Arg).get(MusicMvMakerItemEditUIC.class)).setShow(true);
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    ((MusicMvMakerItemEditUIC) com.tencent.mm.ui.component.a.b(this.Arl.Arg).get(MusicMvMakerItemEditUIC.class)).d(dVar);
                    View e2 = MusicMvMakerUI.e(this.Arl.Arg);
                    kotlin.g.b.p.g(e2, "mvItemEditBottomLine");
                    float y = e2.getY();
                    View f2 = MusicMvMakerUI.f(this.Arl.Arg);
                    kotlin.g.b.p.g(f2, "mvListEditBottomLine");
                    MusicMvMakerUI.a(this.Arl.Arg).animate().translationY(y - f2.getY()).start();
                    com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                    ((MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this.Arl.Arg).get(MusicMvMakerEditUIC.class)).AuF = z;
                    MusicMvMakerUI.a(this.Arl.Arg).AwT = false;
                    AppMethodBeat.o(256887);
                    return;
                }
                com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
                ((MusicMvMakerItemEditUIC) com.tencent.mm.ui.component.a.b(this.Arl.Arg).get(MusicMvMakerItemEditUIC.class)).setShow(true);
                com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
                ((MusicMvMakerItemEditUIC) com.tencent.mm.ui.component.a.b(this.Arl.Arg).get(MusicMvMakerItemEditUIC.class)).d(dVar);
                View e3 = MusicMvMakerUI.e(this.Arl.Arg);
                kotlin.g.b.p.g(e3, "mvItemEditBottomLine");
                float y2 = e3.getY();
                View f3 = MusicMvMakerUI.f(this.Arl.Arg);
                kotlin.g.b.p.g(f3, "mvListEditBottomLine");
                MusicMvMakerUI.a(this.Arl.Arg).animate().translationY(y2 - f3.getY()).start();
                com.tencent.mm.ui.component.a aVar6 = com.tencent.mm.ui.component.a.PRN;
                ((MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this.Arl.Arg).get(MusicMvMakerEditUIC.class)).AuF = z;
                MusicMvMakerUI.a(this.Arl.Arg).AwT = false;
                AppMethodBeat.o(256887);
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$3$onInitDataReady$1$onEditItem$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
            /* renamed from: com.tencent.mm.plugin.mv.ui.MusicMvMakerUI$h$a$a  reason: collision with other inner class name */
            public static final class C1544a extends AnimatorListenerAdapter {
                final /* synthetic */ a Arm;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                C1544a(a aVar) {
                    this.Arm = aVar;
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(256884);
                    View b2 = MusicMvMakerUI.b(this.Arm.Arl.Arg);
                    kotlin.g.b.p.g(b2, "albumAnimationContainer");
                    b2.setVisibility(8);
                    AppMethodBeat.o(256884);
                }
            }

            @Override // com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.e
            public final void c(com.tencent.mm.plugin.mv.a.d dVar) {
                AppMethodBeat.i(256888);
                kotlin.g.b.p.h(dVar, "item");
                View g2 = MusicMvMakerUI.g(this.Arl.Arg);
                kotlin.g.b.p.g(g2, "nextBtn");
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                g2.setEnabled(((MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this.Arl.Arg).get(MusicMvMakerEditUIC.class)).evZ());
                AppMethodBeat.o(256888);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$4", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;", "onCancel", "", "isScrollEdit", "", "onConfirm", "plugin-mv_release"})
    public static final class i implements MusicMvMakerItemEditUIC.b {
        final /* synthetic */ MusicMvMakerUI Arg;

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "position", "", "itemData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "invoke"})
        static final class d extends kotlin.g.b.q implements kotlin.g.a.m<Integer, com.tencent.mm.plugin.mv.a.d, x> {
            final /* synthetic */ boolean UZL;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(boolean z) {
                super(2);
                this.UZL = z;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Integer num, com.tencent.mm.plugin.mv.a.d dVar) {
                AppMethodBeat.i(259209);
                int intValue = num.intValue();
                com.tencent.mm.plugin.mv.a.d dVar2 = dVar;
                kotlin.g.b.p.h(dVar2, "itemData");
                com.tencent.mm.plugin.mv.a.l lVar = com.tencent.mm.plugin.mv.a.l.UZs;
                boolean z = this.UZL;
                kotlin.g.b.p.h(dVar2, "data");
                on hWv = com.tencent.mm.plugin.mv.a.l.hWv();
                hWv.bvJ(dVar2.adk());
                hWv.bvK(dVar2.hWt());
                hWv.PY((long) com.tencent.mm.plugin.mv.a.l.UZp);
                hWv.Qa((long) intValue);
                hWv.Qb((long) com.tencent.mm.plugin.mv.a.l.UZo);
                hWv.Qd(dVar2.hWu());
                hWv.Qc(z ? 1 : 2);
                hWv.PV(5);
                hWv.bfK();
                com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
                com.tencent.mm.util.b.a(hWv);
                x xVar = x.SXb;
                AppMethodBeat.o(259209);
                return xVar;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "position", "", "itemData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "invoke"})
        static final class e extends kotlin.g.b.q implements kotlin.g.a.m<Integer, com.tencent.mm.plugin.mv.a.d, x> {
            final /* synthetic */ boolean UZL;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(boolean z) {
                super(2);
                this.UZL = z;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Integer num, com.tencent.mm.plugin.mv.a.d dVar) {
                AppMethodBeat.i(259210);
                int intValue = num.intValue();
                com.tencent.mm.plugin.mv.a.d dVar2 = dVar;
                kotlin.g.b.p.h(dVar2, "itemData");
                com.tencent.mm.plugin.mv.a.l lVar = com.tencent.mm.plugin.mv.a.l.UZs;
                boolean z = this.UZL;
                kotlin.g.b.p.h(dVar2, "data");
                on hWv = com.tencent.mm.plugin.mv.a.l.hWv();
                hWv.bvJ(dVar2.adk());
                hWv.bvK(dVar2.hWt());
                hWv.PY((long) com.tencent.mm.plugin.mv.a.l.UZp);
                hWv.Qa((long) intValue);
                hWv.Qb((long) com.tencent.mm.plugin.mv.a.l.UZo);
                hWv.Qd(dVar2.hWu());
                hWv.Qc(z ? 1 : 2);
                hWv.PV(4);
                hWv.bfK();
                com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
                com.tencent.mm.util.b.a(hWv);
                x xVar = x.SXb;
                AppMethodBeat.o(259210);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(MusicMvMakerUI musicMvMakerUI) {
            this.Arg = musicMvMakerUI;
        }

        @Override // com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerItemEditUIC.b
        public final void FD(boolean z) {
            com.tencent.mm.plugin.mv.a.d dVar;
            AppMethodBeat.i(259211);
            View b2 = MusicMvMakerUI.b(this.Arg);
            kotlin.g.b.p.g(b2, "albumAnimationContainer");
            b2.setVisibility(0);
            MusicMvMakerUI.c(this.Arg).setRadius(com.tencent.mm.cb.a.fromDPToPix((Context) this.Arg.getContext(), 12));
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.b(this.Arg).get(MusicMvMakerEditUIC.class);
            kotlin.g.b.p.g(viewModel, "UICProvider.of(this@Musi…MakerEditUIC::class.java)");
            MusicMvMakerEditUIC musicMvMakerEditUIC = (MusicMvMakerEditUIC) viewModel;
            if (z) {
                musicMvMakerEditUIC.thl = true;
            }
            View evY = musicMvMakerEditUIC.evY();
            ImageView d2 = MusicMvMakerUI.d(this.Arg);
            kotlin.g.b.p.g(d2, "mvItemEditThumb");
            if (evY == null) {
                kotlin.g.b.p.hyc();
            }
            MMRoundCornerImageView c2 = MusicMvMakerUI.c(this.Arg);
            kotlin.g.b.p.g(c2, "albumFakeThumb");
            Animator a2 = com.tencent.mm.plugin.mv.a.g.a(d2, evY, c2, false);
            a2.addListener(new b(this));
            a2.setDuration(250);
            a2.start();
            MusicMvMakerUI.a(this.Arg).animate().translationY(0.0f).setListener(new c(this)).start();
            musicMvMakerEditUIC.k(new e(z));
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            MusicMvMakerEditUIC musicMvMakerEditUIC2 = (MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this.Arg).get(MusicMvMakerEditUIC.class);
            Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "disableCurrentSyncMusic");
            if (musicMvMakerEditUIC2.AtW.hbQ + 1 < musicMvMakerEditUIC2.getAdapter().getItemCount() && (dVar = (com.tencent.mm.plugin.mv.a.d) kotlin.a.j.L(musicMvMakerEditUIC2.kgc, musicMvMakerEditUIC2.AtW.hbQ)) != null) {
                dVar.Apn = false;
            }
            com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
            ((MusicMvMakerItemEditUIC) com.tencent.mm.ui.component.a.b(this.Arg).get(MusicMvMakerItemEditUIC.class)).setShow(false);
            MusicMvMakerUI.a(this.Arg).AwT = true;
            View g2 = MusicMvMakerUI.g(this.Arg);
            kotlin.g.b.p.g(g2, "nextBtn");
            com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
            g2.setEnabled(((MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this.Arg).get(MusicMvMakerEditUIC.class)).evZ());
            AppMethodBeat.o(259211);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$4$onConfirm$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
        public static final class b extends AnimatorListenerAdapter {
            final /* synthetic */ i Arn;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            b(i iVar) {
                this.Arn = iVar;
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(256891);
                View b2 = MusicMvMakerUI.b(this.Arn.Arg);
                kotlin.g.b.p.g(b2, "albumAnimationContainer");
                b2.setVisibility(8);
                AppMethodBeat.o(256891);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$4$onConfirm$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
        public static final class c extends AnimatorListenerAdapter {
            final /* synthetic */ i Arn;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            c(i iVar) {
                this.Arn = iVar;
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(256892);
                MusicMvMakerUI.a(this.Arn.Arg).animate().setListener(null);
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                MusicMvMakerEditUIC musicMvMakerEditUIC = (MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this.Arn.Arg).get(MusicMvMakerEditUIC.class);
                Log.d("MicroMsg.Mv.MusicMvMakerEditUIC", "moveToNextItem, lastPos:" + musicMvMakerEditUIC.tex);
                if (musicMvMakerEditUIC.tex + 1 < musicMvMakerEditUIC.getAdapter().getItemCount()) {
                    WxRecyclerView evW = musicMvMakerEditUIC.evW();
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(musicMvMakerEditUIC.tex + 1, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(evW, a2.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC", "moveToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                    evW.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(evW, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC", "moveToNextItem", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                }
                AppMethodBeat.o(256892);
            }
        }

        @Override // com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerItemEditUIC.b
        public final void FE(boolean z) {
            AppMethodBeat.i(259212);
            View b2 = MusicMvMakerUI.b(this.Arg);
            kotlin.g.b.p.g(b2, "albumAnimationContainer");
            b2.setVisibility(0);
            MusicMvMakerUI.c(this.Arg).setRadius(com.tencent.mm.cb.a.fromDPToPix((Context) this.Arg.getContext(), 12));
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.b(this.Arg).get(MusicMvMakerEditUIC.class);
            kotlin.g.b.p.g(viewModel, "UICProvider.of(this@Musi…MakerEditUIC::class.java)");
            MusicMvMakerEditUIC musicMvMakerEditUIC = (MusicMvMakerEditUIC) viewModel;
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            View evY = ((MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this.Arg).get(MusicMvMakerEditUIC.class)).evY();
            ImageView d2 = MusicMvMakerUI.d(this.Arg);
            kotlin.g.b.p.g(d2, "mvItemEditThumb");
            if (evY == null) {
                kotlin.g.b.p.hyc();
            }
            MMRoundCornerImageView c2 = MusicMvMakerUI.c(this.Arg);
            kotlin.g.b.p.g(c2, "albumFakeThumb");
            Animator a2 = com.tencent.mm.plugin.mv.a.g.a(d2, evY, c2, musicMvMakerEditUIC.AuF);
            a2.addListener(new a(this));
            a2.setDuration(250);
            a2.start();
            musicMvMakerEditUIC.k(new d(z));
            com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
            ((MusicMvMakerItemEditUIC) com.tencent.mm.ui.component.a.b(this.Arg).get(MusicMvMakerItemEditUIC.class)).setShow(false);
            if (musicMvMakerEditUIC.AuF && musicMvMakerEditUIC.tex >= 0 && musicMvMakerEditUIC.tex < musicMvMakerEditUIC.kgc.size()) {
                com.tencent.mm.plugin.mv.a.d dVar = musicMvMakerEditUIC.kgc.get(musicMvMakerEditUIC.tex);
                kotlin.g.b.p.g(dVar, "dataList[lastPos]");
                com.tencent.mm.plugin.mv.a.d dVar2 = dVar;
                int i2 = musicMvMakerEditUIC.tex;
                com.tencent.mm.plugin.mv.a.d dVar3 = dVar2.Apq;
                if (dVar3 != null) {
                    dVar3.uOQ = dVar2.uOQ;
                    musicMvMakerEditUIC.kgc.set(i2, dVar3);
                    musicMvMakerEditUIC.getAdapter().ci(i2);
                    musicMvMakerEditUIC.Tq(i2);
                }
            }
            MusicMvMakerUI.a(this.Arg).animate().translationY(0.0f).start();
            MusicMvMakerUI.a(this.Arg).AwT = true;
            View g2 = MusicMvMakerUI.g(this.Arg);
            kotlin.g.b.p.g(g2, "nextBtn");
            com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
            g2.setEnabled(((MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this.Arg).get(MusicMvMakerEditUIC.class)).evZ());
            AppMethodBeat.o(259212);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$4$onCancel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
        public static final class a extends AnimatorListenerAdapter {
            final /* synthetic */ i Arn;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(i iVar) {
                this.Arn = iVar;
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(256890);
                MMRoundCornerImageView c2 = MusicMvMakerUI.c(this.Arn.Arg);
                kotlin.g.b.p.g(c2, "albumFakeThumb");
                c2.setAlpha(1.0f);
                View b2 = MusicMvMakerUI.b(this.Arn.Arg);
                kotlin.g.b.p.g(b2, "albumAnimationContainer");
                b2.setVisibility(8);
                AppMethodBeat.o(256890);
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(256898);
        super.onResume();
        MusicMVCardChooseView hWz = hWz();
        if (hWz != null) {
            hWz.xoh = false;
        }
        com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
        com.tencent.mm.plugin.music.model.c.onResume();
        com.tencent.mm.plugin.music.model.l lVar = com.tencent.mm.plugin.music.model.l.AkI;
        com.tencent.mm.plugin.music.model.l.aq(this);
        AppMethodBeat.o(256898);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(256899);
        super.onPause();
        MusicMVCardChooseView hWz = hWz();
        if (hWz != null) {
            hWz.xoh = true;
        }
        com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
        com.tencent.mm.plugin.music.model.c.hWr();
        AppMethodBeat.o(256899);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(256900);
        super.onDestroy();
        MusicMVCardChooseView hWz = hWz();
        if (hWz != null) {
            com.tencent.mm.plugin.gallery.model.e.dQK().b(hWz);
            TabLayout tabLayout = hWz.AwB;
            if (tabLayout != null) {
                tabLayout.b(hWz.AwX);
            }
            MusicMvTabSearchFragment musicMvTabSearchFragment = hWz.AwJ;
            if (musicMvTabSearchFragment != null) {
                musicMvTabSearchFragment.onDestroy();
            }
            MusicMvTabMyFavFragment musicMvTabMyFavFragment = hWz.AwR;
            if (musicMvTabMyFavFragment != null) {
                musicMvTabMyFavFragment.onDestroy();
            }
            MusicMvTabMachineFragment musicMvTabMachineFragment = hWz.AwP;
            if (musicMvTabMachineFragment != null) {
                musicMvTabMachineFragment.onDestroy();
            }
            MusicMvTabMyPostFragment musicMvTabMyPostFragment = hWz.AwQ;
            if (musicMvTabMyPostFragment != null) {
                musicMvTabMyPostFragment.onDestroy();
            }
            MusicMvTabMyLikeFragment musicMvTabMyLikeFragment = hWz.AwS;
            if (musicMvTabMyLikeFragment != null) {
                musicMvTabMyLikeFragment.onDestroy();
                AppMethodBeat.o(256900);
                return;
            }
            AppMethodBeat.o(256900);
            return;
        }
        AppMethodBeat.o(256900);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(256901);
        super.finish();
        AppMethodBeat.o(256901);
    }

    private final void a(com.tencent.mm.plugin.mv.a.f fVar, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(256902);
        if (fVar == null) {
            aVar.invoke();
            AppMethodBeat.o(256902);
            return;
        }
        View hWA = hWA();
        kotlin.g.b.p.g(hWA, "albumAnimationContainer");
        hWA.setVisibility(0);
        MMRoundCornerImageView hWB = hWB();
        kotlin.g.b.p.g(hWB, "albumFakeThumb");
        fVar.i(hWB);
        hWB().setRadius(0);
        int[] iArr = new int[2];
        hWC().getLocationInWindow(iArr);
        int i2 = iArr[0];
        RecyclerView hWC = hWC();
        kotlin.g.b.p.g(hWC, "mvCardRV");
        iArr[0] = i2 + ((hWC.getWidth() - fVar.ApT.getWidth()) / 2);
        int i3 = iArr[1];
        RecyclerView hWC2 = hWC();
        kotlin.g.b.p.g(hWC2, "mvCardRV");
        iArr[1] = i3 + ((hWC2.getHeight() - fVar.ApT.getHeight()) / 2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(hWB(), "x", "y", new GravityArcMotion().getPath((float) fVar.ApS.x, (float) fVar.ApS.y, (float) iArr[0], (float) iArr[1]));
        kotlin.g.b.p.g(ofFloat, "pathAnimator");
        ofFloat.setInterpolator(new android.support.v4.view.b.b());
        ofFloat.setDuration(400L);
        ofFloat.addListener(new b(this, aVar));
        ofFloat.start();
        AppMethodBeat.o(256902);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$makeMediaThumbTransition$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ MusicMvMakerUI Arg;
        final /* synthetic */ kotlin.g.a.a Arh;

        b(MusicMvMakerUI musicMvMakerUI, kotlin.g.a.a aVar) {
            this.Arg = musicMvMakerUI;
            this.Arh = aVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(256878);
            MusicMvMakerUI.c(this.Arg).animate().alpha(0.0f).setDuration(200).withEndAction(new a(this)).start();
            kotlin.g.a.a aVar = this.Arh;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(256878);
                return;
            }
            AppMethodBeat.o(256878);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ b Ari;

            a(b bVar) {
                this.Ari = bVar;
            }

            public final void run() {
                AppMethodBeat.i(256877);
                View b2 = MusicMvMakerUI.b(this.Ari.Arg);
                kotlin.g.b.p.g(b2, "albumAnimationContainer");
                b2.setVisibility(8);
                AppMethodBeat.o(256877);
            }
        }
    }

    @Override // com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.b
    public final void a(GalleryItem.VideoMediaItem videoMediaItem, com.tencent.mm.plugin.mv.a.f fVar) {
        AppMethodBeat.i(256903);
        kotlin.g.b.p.h(videoMediaItem, "data");
        a(fVar, new e(this, videoMediaItem));
        AppMethodBeat.o(256903);
    }

    @Override // com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.b
    public final void a(MusicMvTabFragment.f fVar, com.tencent.mm.plugin.mv.a.f fVar2) {
        AppMethodBeat.i(256904);
        kotlin.g.b.p.h(fVar, "data");
        a(fVar2, new j(this, fVar));
        AppMethodBeat.o(256904);
    }

    @Override // com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView.b
    public final void Tk(int i2) {
        AppMethodBeat.i(256905);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        MusicMvMakerEditUIC musicMvMakerEditUIC = (MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this).get(MusicMvMakerEditUIC.class);
        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
        kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
        euj.etW().pause();
        Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "takePhoto, minDuration:".concat(String.valueOf(i2)));
        Intent intent = new Intent(musicMvMakerEditUIC.getActivity(), MusicMvRouterUI.class);
        intent.putExtra("KEY_MUSIC_ROUTER", 1);
        intent.putExtra("KEY_REQUIRE_VIDEO_DURATION", i2);
        com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
        com.tencent.mm.plugin.music.model.c.sm(true);
        musicMvMakerEditUIC.getActivity().startActivityForResult(intent, 1024);
        AppMethodBeat.o(256905);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ MusicMvMakerUI Arg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(MusicMvMakerUI musicMvMakerUI) {
            super(0);
            this.Arg = musicMvMakerUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(256880);
            View findViewById = this.Arg.findViewById(R.id.frk);
            AppMethodBeat.o(256880);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ MusicMvMakerUI Arg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(MusicMvMakerUI musicMvMakerUI) {
            super(0);
            this.Arg = musicMvMakerUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(256879);
            View findViewById = this.Arg.findViewById(R.id.fr9);
            AppMethodBeat.o(256879);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ MusicMvMakerUI Arg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(MusicMvMakerUI musicMvMakerUI) {
            super(0);
            this.Arg = musicMvMakerUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(259204);
            View findViewById = this.Arg.findViewById(R.id.ai9);
            AppMethodBeat.o(259204);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ MusicMvMakerUI Arg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(MusicMvMakerUI musicMvMakerUI) {
            super(0);
            this.Arg = musicMvMakerUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(259208);
            View findViewById = this.Arg.findViewById(R.id.fyy);
            AppMethodBeat.o(259208);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<MusicMVCardChooseView> {
        final /* synthetic */ MusicMvMakerUI Arg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(MusicMvMakerUI musicMvMakerUI) {
            super(0);
            this.Arg = musicMvMakerUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MusicMVCardChooseView invoke() {
            AppMethodBeat.i(259206);
            MusicMVCardChooseView musicMVCardChooseView = (MusicMVCardChooseView) this.Arg.findViewById(R.id.fr1);
            AppMethodBeat.o(259206);
            return musicMVCardChooseView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ MusicMvMakerUI Arg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(MusicMvMakerUI musicMvMakerUI) {
            super(0);
            this.Arg = musicMvMakerUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(259202);
            View findViewById = this.Arg.findViewById(R.id.im);
            AppMethodBeat.o(259202);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<MMRoundCornerImageView> {
        final /* synthetic */ MusicMvMakerUI Arg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(MusicMvMakerUI musicMvMakerUI) {
            super(0);
            this.Arg = musicMvMakerUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMRoundCornerImageView invoke() {
            AppMethodBeat.i(259203);
            MMRoundCornerImageView mMRoundCornerImageView = (MMRoundCornerImageView) this.Arg.findViewById(R.id.in);
            AppMethodBeat.o(259203);
            return mMRoundCornerImageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ MusicMvMakerUI Arg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(MusicMvMakerUI musicMvMakerUI) {
            super(0);
            this.Arg = musicMvMakerUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(259207);
            ImageView imageView = (ImageView) this.Arg.findViewById(R.id.frb);
            AppMethodBeat.o(259207);
            return imageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<RecyclerView> {
        final /* synthetic */ MusicMvMakerUI Arg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(MusicMvMakerUI musicMvMakerUI) {
            super(0);
            this.Arg = musicMvMakerUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView invoke() {
            AppMethodBeat.i(259205);
            RecyclerView recyclerView = (RecyclerView) this.Arg.findViewById(R.id.fr0);
            AppMethodBeat.o(259205);
            return recyclerView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ MusicMvMakerUI Arg;
        final /* synthetic */ GalleryItem.VideoMediaItem Arj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(MusicMvMakerUI musicMvMakerUI, GalleryItem.VideoMediaItem videoMediaItem) {
            super(0);
            this.Arg = musicMvMakerUI;
            this.Arj = videoMediaItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(256881);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            MusicMvMakerEditUIC musicMvMakerEditUIC = (MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this.Arg).get(MusicMvMakerEditUIC.class);
            GalleryItem.VideoMediaItem videoMediaItem = this.Arj;
            kotlin.g.b.p.h(videoMediaItem, "data");
            Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "updateAlbumItem:".concat(String.valueOf(videoMediaItem)));
            if (musicMvMakerEditUIC.kgc.size() != 0) {
                int i2 = musicMvMakerEditUIC.AtW.hbQ;
                com.tencent.mm.plugin.mv.a.d dVar = musicMvMakerEditUIC.kgc.get(i2);
                kotlin.g.b.p.g(dVar, "dataList[pos]");
                com.tencent.mm.plugin.mv.a.d dVar2 = dVar;
                com.tencent.mm.plugin.mv.a.d dVar3 = new com.tencent.mm.plugin.mv.a.d();
                d.b bVar = com.tencent.mm.plugin.mv.a.d.Aps;
                d.b.a(dVar2, dVar3);
                kotlin.g.b.p.g(musicMvMakerEditUIC.AuA.get(i2), "initMusicDataList[pos]");
                dVar3.Apq = dVar2;
                musicMvMakerEditUIC.kgc.set(i2, dVar3);
                d.b bVar2 = com.tencent.mm.plugin.mv.a.d.Aps;
                kotlin.g.b.p.h(videoMediaItem, "videoItem");
                kotlin.g.b.p.h(dVar3, "item");
                dVar3.type = 1;
                dVar3.Apo = new d.f(videoMediaItem);
                String auA = videoMediaItem.auA();
                kotlin.g.b.p.g(auA, "videoItem.uniqueValue()");
                String dRh = videoMediaItem.dRh();
                kotlin.g.b.p.g(dRh, "videoItem.originalPath");
                d.i iVar = new d.i(auA, dRh, (long) videoMediaItem.jkS);
                iVar.videoWidth = videoMediaItem.videoWidth;
                iVar.videoHeight = videoMediaItem.videoHeight;
                dVar3.App = iVar;
                com.tencent.mm.plugin.mv.a.l lVar = com.tencent.mm.plugin.mv.a.l.UZs;
                com.tencent.mm.plugin.mv.a.l.a(i2, dVar3);
                musicMvMakerEditUIC.a(i2, dVar3, new MusicMvMakerEditUIC.t(musicMvMakerEditUIC, i2, dVar3));
            }
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            ((MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this.Arg).get(MusicMvMakerEditUIC.class)).thl = true;
            x xVar = x.SXb;
            AppMethodBeat.o(256881);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ MusicMvMakerUI Arg;
        final /* synthetic */ MusicMvTabFragment.f Aro;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(MusicMvMakerUI musicMvMakerUI, MusicMvTabFragment.f fVar) {
            super(0);
            this.Arg = musicMvMakerUI;
            this.Aro = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(256895);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            MusicMvMakerEditUIC musicMvMakerEditUIC = (MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this.Arg).get(MusicMvMakerEditUIC.class);
            MusicMvTabFragment.f fVar = this.Aro;
            kotlin.g.b.p.h(fVar, "data");
            Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "updateFinderItem:".concat(String.valueOf(fVar)));
            if (musicMvMakerEditUIC.kgc.size() != 0) {
                int i2 = musicMvMakerEditUIC.AtW.hbQ;
                com.tencent.mm.plugin.mv.a.d dVar = musicMvMakerEditUIC.kgc.get(i2);
                kotlin.g.b.p.g(dVar, "dataList[pos]");
                com.tencent.mm.plugin.mv.a.d dVar2 = dVar;
                com.tencent.mm.plugin.mv.a.d dVar3 = new com.tencent.mm.plugin.mv.a.d();
                d.b bVar = com.tencent.mm.plugin.mv.a.d.Aps;
                d.b.a(dVar2, dVar3);
                kotlin.g.b.p.g(musicMvMakerEditUIC.AuA.get(i2), "initMusicDataList[pos]");
                dVar3.Apq = dVar2;
                musicMvMakerEditUIC.kgc.set(i2, dVar3);
                d.b bVar2 = com.tencent.mm.plugin.mv.a.d.Aps;
                kotlin.g.b.p.h(fVar, "data");
                kotlin.g.b.p.h(dVar3, "item");
                dVar3.type = 2;
                FinderObject finderObject = fVar.feedObject;
                if (finderObject == null) {
                    kotlin.g.b.p.hyc();
                }
                dVar3.Apo = new d.C1543d(finderObject);
                FinderObject finderObject2 = fVar.feedObject;
                if (finderObject2 == null) {
                    kotlin.g.b.p.hyc();
                }
                dVar3.App = new d.e(finderObject2);
                com.tencent.mm.plugin.mv.a.l lVar = com.tencent.mm.plugin.mv.a.l.UZs;
                com.tencent.mm.plugin.mv.a.l.a(i2, dVar3);
                musicMvMakerEditUIC.a(i2, dVar3, new MusicMvMakerEditUIC.u(musicMvMakerEditUIC, i2, dVar3));
            }
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            ((MusicMvMakerEditUIC) com.tencent.mm.ui.component.a.b(this.Arg).get(MusicMvMakerEditUIC.class)).thl = true;
            x xVar = x.SXb;
            AppMethodBeat.o(256895);
            return xVar;
        }
    }

    public static final /* synthetic */ ImageView d(MusicMvMakerUI musicMvMakerUI) {
        AppMethodBeat.i(259221);
        ImageView imageView = (ImageView) musicMvMakerUI.UZK.getValue();
        AppMethodBeat.o(259221);
        return imageView;
    }

    public static final /* synthetic */ View e(MusicMvMakerUI musicMvMakerUI) {
        AppMethodBeat.i(259222);
        View view = (View) musicMvMakerUI.Are.getValue();
        AppMethodBeat.o(259222);
        return view;
    }

    public static final /* synthetic */ View f(MusicMvMakerUI musicMvMakerUI) {
        AppMethodBeat.i(259223);
        View view = (View) musicMvMakerUI.Ard.getValue();
        AppMethodBeat.o(259223);
        return view;
    }
}
