package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "isCurrentResume", "", "lastExposeFollowTipsId", "", "lastExposeFriendTipsId", "lastExposeLbsTipsId", "lastExposeMachineTipsId", "lastExposePersonalCenterTipsId", "checkPersonCenterRedDotReport", "", NativeProtocol.WEB_DIALOG_ACTION, "", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "getCurrentTabType", "getPersonalCenterRect", "outRect", "Landroid/graphics/Rect;", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "registerRedDot", "plugin-finder_release"})
public final class FinderHomeTabUIC extends FinderTabUIC {
    private boolean uPU;
    private String wwA = "";
    private String www = "";
    private String wwx = "";
    private String wwy = "";
    private String wwz = "";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class c<T> implements Observer<h.a> {
        final /* synthetic */ FinderHomeTabUIC wxi;

        c(FinderHomeTabUIC finderHomeTabUIC) {
            this.wxi = finderHomeTabUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            bbi bbi;
            AppMethodBeat.i(255616);
            h.a aVar2 = aVar;
            Log.i("Finder.FinderTabUIC", "[MENU_ID_PROFILE] red=" + (aVar2 != null && aVar2.dEF));
            if (aVar2 != null) {
                if (aVar2.dEF) {
                    k kVar = aVar2.tKT;
                    if (kVar == null || (bbi = kVar.field_ctrInfo) == null || bbi.type != 2) {
                        ImageView imageView = (ImageView) this.wxi.getActivity().findViewById(R.id.ga6);
                        p.g(imageView, "activity.personalCenterTabRed");
                        imageView.setVisibility(0);
                        FinderHomeTabUIC.a(this.wxi, 1);
                        AppMethodBeat.o(255616);
                        return;
                    }
                    i.a aVar3 = i.tLi;
                    if (i.a.dbp()) {
                        ImageView imageView2 = (ImageView) this.wxi.getActivity().findViewById(R.id.ga6);
                        p.g(imageView2, "activity.personalCenterTabRed");
                        imageView2.setVisibility(0);
                        FinderHomeTabUIC.a(this.wxi, 1);
                        AppMethodBeat.o(255616);
                        return;
                    }
                } else {
                    ImageView imageView3 = (ImageView) this.wxi.getActivity().findViewById(R.id.ga6);
                    p.g(imageView3, "activity.personalCenterTabRed");
                    imageView3.setVisibility(4);
                }
                AppMethodBeat.o(255616);
                return;
            }
            AppMethodBeat.o(255616);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class d<T> implements Observer<h.a> {
        final /* synthetic */ FinderHomeTabUIC wxi;

        d(FinderHomeTabUIC finderHomeTabUIC) {
            this.wxi = finderHomeTabUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            String str;
            long j2;
            bbi bbi;
            AppMethodBeat.i(255617);
            h.a aVar2 = aVar;
            com.tencent.mm.plugin.finder.view.tabcomp.a MI = this.wxi.MI(3);
            if (MI != null) {
                Log.i("Finder.FinderTabUIC", "[registerRedDot] TAB_TYPE_FOLLOW isShow=" + (aVar2 != null ? Boolean.valueOf(aVar2.dEF) : null));
                if (aVar2 != null) {
                    if (aVar2.dEF) {
                        k kVar = aVar2.tKT;
                        if (kVar == null || (str = kVar.field_tipsId) == null) {
                            str = "";
                        }
                        MI.by("", true);
                        if ((!p.j(this.wxi.wwx, str)) && this.wxi.uPU) {
                            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                            k kVar3 = aVar2.tKT;
                            if (kVar3 == null || (bbi = kVar3.field_ctrInfo) == null) {
                                j2 = 0;
                            } else {
                                j2 = bbi.feedId;
                            }
                            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wxi.getActivity());
                            bbn dIx = fH != null ? fH.dIx() : null;
                            com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
                            com.tencent.mm.plugin.finder.report.k.a("2", 7, 1, 1, 0, 0, str, (String) null, j2, dIx, ((FinderHomeUIC) com.tencent.mm.ui.component.a.b(this.wxi.getActivity()).get(FinderHomeUIC.class)).dIf(), 0, 2176);
                            this.wxi.wwx = str;
                            k kVar4 = aVar2.tKT;
                            bdo bdo = aVar2.tKS;
                            if (!(kVar4 == null || bdo == null)) {
                                j jVar = j.vft;
                                FinderReporterUIC.a aVar5 = FinderReporterUIC.wzC;
                                FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.wxi.getActivity());
                                j.a("2", kVar4, bdo, 1, fH2 != null ? fH2.dIx() : null, 0, FinderHomeTabUIC.c(this.wxi), 32);
                                AppMethodBeat.o(255617);
                                return;
                            }
                        }
                    } else {
                        this.wxi.wwx = "";
                        MI.by("", false);
                    }
                    AppMethodBeat.o(255617);
                    return;
                }
                AppMethodBeat.o(255617);
                return;
            }
            AppMethodBeat.o(255617);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class e<T> implements Observer<h.a> {
        final /* synthetic */ FinderHomeTabUIC wxi;

        e(FinderHomeTabUIC finderHomeTabUIC) {
            this.wxi = finderHomeTabUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            String str;
            long j2;
            bbi bbi;
            AppMethodBeat.i(255618);
            h.a aVar2 = aVar;
            com.tencent.mm.plugin.finder.view.tabcomp.a MI = this.wxi.MI(1);
            if (MI != null) {
                Log.i("Finder.FinderTabUIC", "[registerRedDot] TAB_TYPE_FRIEND isShow=" + (aVar2 != null ? Boolean.valueOf(aVar2.dEF) : null));
                if (aVar2 != null) {
                    if (aVar2.dEF) {
                        MI.by("", true);
                        k kVar = aVar2.tKT;
                        if (kVar == null || (str = kVar.field_tipsId) == null) {
                            str = "";
                        }
                        if ((!p.j(this.wxi.wwy, str)) && this.wxi.uPU) {
                            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                            k kVar3 = aVar2.tKT;
                            if (kVar3 == null || (bbi = kVar3.field_ctrInfo) == null) {
                                j2 = 0;
                            } else {
                                j2 = bbi.feedId;
                            }
                            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wxi.getActivity());
                            com.tencent.mm.plugin.finder.report.k.a("2", 8, 1, 1, 0, 0, str, (String) null, j2, fH != null ? fH.dIx() : null, FinderHomeTabUIC.c(this.wxi), 0, 2176);
                            this.wxi.wwy = str;
                            k kVar4 = aVar2.tKT;
                            bdo bdo = aVar2.tKS;
                            if (!(kVar4 == null || bdo == null)) {
                                j jVar = j.vft;
                                FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
                                FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.wxi.getActivity());
                                j.a("2", kVar4, bdo, 1, fH2 != null ? fH2.dIx() : null, 0, FinderHomeTabUIC.c(this.wxi), 32);
                                AppMethodBeat.o(255618);
                                return;
                            }
                        }
                    } else {
                        this.wxi.wwy = "";
                        MI.by("", false);
                    }
                    AppMethodBeat.o(255618);
                    return;
                }
                AppMethodBeat.o(255618);
                return;
            }
            AppMethodBeat.o(255618);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class f<T> implements Observer<h.a> {
        final /* synthetic */ FinderHomeTabUIC wxi;

        f(FinderHomeTabUIC finderHomeTabUIC) {
            this.wxi = finderHomeTabUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            String str;
            AppMethodBeat.i(255619);
            h.a aVar2 = aVar;
            com.tencent.mm.plugin.finder.view.tabcomp.a MI = this.wxi.MI(4);
            if (MI != null) {
                Log.i("Finder.FinderTabUIC", "[registerRedDot] TAB_TYPE_MACHINE isShow=" + (aVar2 != null ? Boolean.valueOf(aVar2.dEF) : null));
                if (aVar2 != null) {
                    if (aVar2.dEF) {
                        MI.by("", true);
                        k kVar = aVar2.tKT;
                        if (kVar == null || (str = kVar.field_tipsId) == null) {
                            str = "";
                        }
                        if ((!p.j(this.wxi.wwz, str)) && this.wxi.uPU) {
                            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wxi.getActivity());
                            bbn dIx = fH != null ? fH.dIx() : null;
                            com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
                            com.tencent.mm.plugin.finder.report.k.a("2", 3, 1, 1, 2, 0, str, (String) null, 0, dIx, ((FinderHomeUIC) com.tencent.mm.ui.component.a.b(this.wxi.getActivity()).get(FinderHomeUIC.class)).dIf(), 0, 2432);
                            this.wxi.wwz = str;
                            k kVar3 = aVar2.tKT;
                            bdo bdo = aVar2.tKS;
                            if (!(kVar3 == null || bdo == null)) {
                                j jVar = j.vft;
                                FinderReporterUIC.a aVar5 = FinderReporterUIC.wzC;
                                FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.wxi.getActivity());
                                j.a("2", kVar3, bdo, 1, fH2 != null ? fH2.dIx() : null, 0, FinderHomeTabUIC.c(this.wxi), 32);
                                AppMethodBeat.o(255619);
                                return;
                            }
                        }
                    } else {
                        this.wxi.wwz = "";
                        MI.by("", false);
                    }
                    AppMethodBeat.o(255619);
                    return;
                }
                AppMethodBeat.o(255619);
                return;
            }
            AppMethodBeat.o(255619);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class g<T> implements Observer<h.a> {
        final /* synthetic */ FinderHomeTabUIC wxi;

        g(FinderHomeTabUIC finderHomeTabUIC) {
            this.wxi = finderHomeTabUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            String str;
            AppMethodBeat.i(255620);
            h.a aVar2 = aVar;
            if (aVar2 != null) {
                if (aVar2.dEF) {
                    ImageView imageView = (ImageView) this.wxi.getActivity().findViewById(R.id.e_p);
                    p.g(imageView, "activity.lbsEntranceTabRed");
                    imageView.setVisibility(0);
                    k kVar = aVar2.tKT;
                    if (kVar == null || (str = kVar.field_tipsId) == null) {
                        str = "";
                    }
                    if ((!p.j(this.wxi.wwA, str)) && this.wxi.uPU) {
                        com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wxi.getActivity());
                        com.tencent.mm.plugin.finder.report.k.a("2", 3, 1, 1, 1, 0, str, (String) null, 0, fH != null ? fH.dIx() : null, 0, 0, 3456);
                        this.wxi.wwA = str;
                        k kVar3 = aVar2.tKT;
                        bdo bdo = aVar2.tKS;
                        if (!(kVar3 == null || bdo == null)) {
                            j jVar = j.vft;
                            FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.wxi.getActivity());
                            j.a("2", kVar3, bdo, 1, fH2 != null ? fH2.dIx() : null, 0, 2, 32);
                            AppMethodBeat.o(255620);
                            return;
                        }
                    }
                } else {
                    this.wxi.wwA = "";
                    ImageView imageView2 = (ImageView) this.wxi.getActivity().findViewById(R.id.e_p);
                    p.g(imageView2, "activity.lbsEntranceTabRed");
                    imageView2.setVisibility(4);
                }
                AppMethodBeat.o(255620);
                return;
            }
            AppMethodBeat.o(255620);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderHomeTabUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255626);
        AppMethodBeat.o(255626);
    }

    public static final /* synthetic */ void a(FinderHomeTabUIC finderHomeTabUIC, int i2) {
        AppMethodBeat.i(255627);
        finderHomeTabUIC.Mu(i2);
        AppMethodBeat.o(255627);
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC
    public final IFinderTabProvider cXB() {
        AppMethodBeat.i(255621);
        com.tencent.mm.plugin.finder.viewmodel.hometab.c cVar = new com.tencent.mm.plugin.finder.viewmodel.hometab.c();
        AppMethodBeat.o(255621);
        return cVar;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateAfter(Bundle bundle) {
        AppMethodBeat.i(255622);
        super.onCreateAfter(bundle);
        ActionBar supportActionBar = getActivity().getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        ((WeImageView) getActivity().findViewById(R.id.e_n)).setOnClickListener(new a(this));
        ((WeImageView) getActivity().findViewById(R.id.ga5)).setOnClickListener(new b(this));
        h hVar = h.tKR;
        h hVar2 = h.tKR;
        h.a(h.daN(), getActivity(), new c(this));
        h hVar3 = h.tKR;
        h hVar4 = h.tKR;
        h.a(h.daQ(), getActivity(), new d(this));
        h hVar5 = h.tKR;
        h hVar6 = h.tKR;
        h.a(h.daR(), getActivity(), new e(this));
        h hVar7 = h.tKR;
        h hVar8 = h.tKR;
        h.a(h.daT(), getActivity(), new f(this));
        h hVar9 = h.tKR;
        h hVar10 = h.tKR;
        h.a(h.daU(), getActivity(), new g(this));
        Mu(1);
        AppMethodBeat.o(255622);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ FinderHomeTabUIC wxi;

        a(FinderHomeTabUIC finderHomeTabUIC) {
            this.wxi = finderHomeTabUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255614);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeTabUIC$onCreateAfter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
            com.tencent.mm.plugin.finder.report.h.dnS();
            Intent intent = new Intent();
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a(this.wxi.getActivity(), intent, 0, 0, true, 60);
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            AppCompatActivity activity = this.wxi.getActivity();
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255614);
                throw tVar;
            }
            com.tencent.mm.plugin.finder.utils.a.b((MMActivity) activity, intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeTabUIC$onCreateAfter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255614);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ FinderHomeTabUIC wxi;

        b(FinderHomeTabUIC finderHomeTabUIC) {
            this.wxi = finderHomeTabUIC;
        }

        public final void onClick(View view) {
            boolean z;
            bdo bdo = null;
            AppMethodBeat.i(255615);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeTabUIC$onCreateAfter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wxi.getActivity());
            com.tencent.mm.plugin.finder.report.e c2 = fH != null ? FinderReporterUIC.c(fH) : null;
            if (c2 instanceof o) {
                e.a aVar2 = com.tencent.mm.plugin.finder.report.e.vdS;
                ((o) c2).auL(e.a.ah(ae.b(s.U("feedActionType", 3))));
            }
            FinderHomeTabUIC.a(this.wxi, 2);
            Intent intent = new Intent();
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            k asX = ((PluginFinder) ah).getRedDotManager().asX("TLPersonalCenter");
            if (asX != null) {
                bdo = asX.atl("TLPersonalCenter");
            }
            if (bdo != null) {
                z = true;
            } else {
                z = false;
            }
            FinderSelfUI.a aVar3 = FinderSelfUI.vOh;
            intent.putExtra(FinderSelfUI.vOf, z);
            FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a(this.wxi.getActivity(), intent, 0, 0, false, 124);
            com.tencent.mm.plugin.finder.utils.a aVar5 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.z(this.wxi.getActivity(), intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeTabUIC$onCreateAfter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255615);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(255623);
        super.onResume();
        this.uPU = true;
        AppMethodBeat.o(255623);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(255624);
        super.onPause();
        this.uPU = false;
        AppMethodBeat.o(255624);
    }

    private final void Mu(int i2) {
        AppMethodBeat.i(255625);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(getActivity());
        bbn dIx = fH != null ? fH.dIx() : null;
        i.a aVar2 = i.tLi;
        this.www = i.a.a(i2, dIx, this.www);
        AppMethodBeat.o(255625);
    }

    public static final /* synthetic */ int c(FinderHomeTabUIC finderHomeTabUIC) {
        AppMethodBeat.i(255628);
        int i2 = finderHomeTabUIC.getActiveFragment().dLS;
        AppMethodBeat.o(255628);
        return i2;
    }
}
