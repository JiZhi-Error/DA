package com.tencent.mm.plugin.finder.nearby;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "isCurrentResume", "", "buildTab", "", "checkAddFootPrintRedDot", "getNearbyTab", "Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$NearbyTab;", FirebaseAnalytics.b.INDEX, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "registerRedDot", "setMenuType", "menuType", "setNearbyVideoTabTitle", "title", "", "setTabIndex", "findByTag", "Landroid/support/design/widget/TabLayout$Tab;", "Landroid/support/design/widget/TabLayout;", "any", "", "Companion", "NearbyTab", "plugin-finder_release"})
public final class NearbyActionBarUIC extends UIComponent {
    public static final a uPV = new a((byte) 0);
    private boolean uPU;

    static {
        AppMethodBeat.i(248990);
        AppMethodBeat.o(248990);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class h<T> implements Observer<h.a> {
        final /* synthetic */ NearbyActionBarUIC uPY;
        final /* synthetic */ TabLayout uQc;

        h(NearbyActionBarUIC nearbyActionBarUIC, TabLayout tabLayout) {
            this.uPY = nearbyActionBarUIC;
            this.uQc = tabLayout;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            Object tag;
            Boolean bool;
            bdo bdo;
            Integer num = null;
            AppMethodBeat.i(248979);
            h.a aVar2 = aVar;
            TabLayout tabLayout = this.uQc;
            p.g(tabLayout, "tabLayout");
            TabLayout.f a2 = NearbyActionBarUIC.a(tabLayout, (Object) 1002);
            if (a2 == null || (tag = a2.getTag()) == null) {
                AppMethodBeat.o(248979);
            } else if (tag == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC.NearbyTab");
                AppMethodBeat.o(248979);
                throw tVar;
            } else {
                StringBuilder sb = new StringBuilder("[registerRedDot] TAB_NEARBY_TYPE_VIDEO isShow=");
                if (aVar2 != null) {
                    bool = Boolean.valueOf(aVar2.dEF);
                } else {
                    bool = null;
                }
                StringBuilder append = sb.append(bool).append(" show_type=");
                if (!(aVar2 == null || (bdo = aVar2.tKS) == null)) {
                    num = Integer.valueOf(bdo.xGz);
                }
                Log.i("NearbyActionBarUIC", append.append(num).toString());
                if (aVar2 == null || !aVar2.dEF) {
                    ImageView imageView = ((b) tag).uPX;
                    if (imageView != null) {
                        imageView.setVisibility(4);
                        AppMethodBeat.o(248979);
                        return;
                    }
                    AppMethodBeat.o(248979);
                    return;
                }
                ImageView imageView2 = ((b) tag).uPX;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                    AppMethodBeat.o(248979);
                    return;
                }
                AppMethodBeat.o(248979);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class i<T> implements Observer<h.a> {
        final /* synthetic */ NearbyActionBarUIC uPY;
        final /* synthetic */ TabLayout uQc;

        i(NearbyActionBarUIC nearbyActionBarUIC, TabLayout tabLayout) {
            this.uPY = nearbyActionBarUIC;
            this.uQc = tabLayout;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            Object tag;
            Boolean bool;
            bdo bdo;
            Integer num = null;
            AppMethodBeat.i(248980);
            h.a aVar2 = aVar;
            TabLayout tabLayout = this.uQc;
            p.g(tabLayout, "tabLayout");
            TabLayout.f a2 = NearbyActionBarUIC.a(tabLayout, (Object) 1001);
            if (a2 == null || (tag = a2.getTag()) == null) {
                AppMethodBeat.o(248980);
            } else if (tag == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC.NearbyTab");
                AppMethodBeat.o(248980);
                throw tVar;
            } else {
                StringBuilder sb = new StringBuilder("[registerRedDot] TAB_NEARBY_TYPE_LIVE isShow=");
                if (aVar2 != null) {
                    bool = Boolean.valueOf(aVar2.dEF);
                } else {
                    bool = null;
                }
                StringBuilder append = sb.append(bool).append(" show_type=");
                if (!(aVar2 == null || (bdo = aVar2.tKS) == null)) {
                    num = Integer.valueOf(bdo.xGz);
                }
                Log.i("NearbyActionBarUIC", append.append(num).toString());
                if (aVar2 == null || !aVar2.dEF) {
                    ImageView imageView = ((b) tag).uPX;
                    if (imageView != null) {
                        imageView.setVisibility(4);
                        AppMethodBeat.o(248980);
                        return;
                    }
                    AppMethodBeat.o(248980);
                    return;
                }
                ImageView imageView2 = ((b) tag).uPX;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                    AppMethodBeat.o(248980);
                    return;
                }
                AppMethodBeat.o(248980);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class j<T> implements Observer<h.a> {
        final /* synthetic */ NearbyActionBarUIC uPY;
        final /* synthetic */ TabLayout uQc;

        j(NearbyActionBarUIC nearbyActionBarUIC, TabLayout tabLayout) {
            this.uPY = nearbyActionBarUIC;
            this.uQc = tabLayout;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            Object tag;
            bdo bdo;
            bdo bdo2;
            Integer num = null;
            AppMethodBeat.i(248981);
            h.a aVar2 = aVar;
            TabLayout tabLayout = this.uQc;
            p.g(tabLayout, "tabLayout");
            TabLayout.f a2 = NearbyActionBarUIC.a(tabLayout, (Object) 1003);
            if (a2 == null || (tag = a2.getTag()) == null) {
                AppMethodBeat.o(248981);
            } else if (tag == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC.NearbyTab");
                AppMethodBeat.o(248981);
                throw tVar;
            } else {
                StringBuilder append = new StringBuilder("[registerRedDot] TAB_NEARBY_TYPE_PERSON isShow=").append(aVar2 != null ? Boolean.valueOf(aVar2.dEF) : null).append(" show_type=");
                if (!(aVar2 == null || (bdo2 = aVar2.tKS) == null)) {
                    num = Integer.valueOf(bdo2.xGz);
                }
                Log.i("NearbyActionBarUIC", append.append(num).toString());
                if (aVar2 != null && aVar2.dEF) {
                    bdo bdo3 = aVar2.tKS;
                    if (bdo3 == null || bdo3.xGz != 101) {
                        ImageView imageView = ((b) tag).uPX;
                        if (imageView != null) {
                            imageView.setVisibility(0);
                        }
                        WeImageView weImageView = ((b) tag).uPW;
                        if (weImageView != null) {
                            weImageView.setVisibility(4);
                            AppMethodBeat.o(248981);
                            return;
                        }
                        AppMethodBeat.o(248981);
                        return;
                    }
                    ImageView imageView2 = ((b) tag).uPX;
                    if (imageView2 != null) {
                        imageView2.setVisibility(4);
                    }
                    WeImageView weImageView2 = ((b) tag).uPW;
                    if (weImageView2 != null) {
                        weImageView2.setVisibility(0);
                        AppMethodBeat.o(248981);
                        return;
                    }
                    AppMethodBeat.o(248981);
                } else if (aVar2 == null || (bdo = aVar2.tKS) == null || bdo.xGz != 101) {
                    ImageView imageView3 = ((b) tag).uPX;
                    if (imageView3 != null) {
                        imageView3.setVisibility(4);
                    }
                    WeImageView weImageView3 = ((b) tag).uPW;
                    if (weImageView3 != null) {
                        weImageView3.setVisibility(com.tencent.mm.bp.a.Xm() ? 4 : 0);
                        AppMethodBeat.o(248981);
                        return;
                    }
                    AppMethodBeat.o(248981);
                } else {
                    WeImageView weImageView4 = ((b) tag).uPW;
                    if (weImageView4 != null) {
                        weImageView4.setVisibility(4);
                        AppMethodBeat.o(248981);
                        return;
                    }
                    AppMethodBeat.o(248981);
                }
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$Companion;", "", "()V", "MENU_TYPE_LIVE", "", "MENU_TYPE_PERSON", "MENU_TYPE_VIDEO", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyActionBarUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(248989);
        AppMethodBeat.o(248989);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(248983);
        ActionBar supportActionBar = getActivity().getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        ((LinearLayout) getActivity().findViewById(R.id.xy)).setOnClickListener(new d(this));
        ((HardTouchableLayout) getActivity().findViewById(R.id.ig6)).setOnSingleClickListener(new e(this));
        ((HardTouchableLayout) getActivity().findViewById(R.id.ig6)).setOnDoubleClickListener(new f(this));
        ((ConstraintLayout) getActivity().findViewById(R.id.ful)).setOnClickListener(new g(this));
        TextView textView = (TextView) getActivity().findViewById(R.id.fum);
        if (textView != null) {
            textView.setTextSize(1, 15.0f);
        }
        a aVar = a.uQd;
        a.dlh();
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        if (((NearbyHomeUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(NearbyHomeUIC.class)).fragments.size() == 2) {
            HardTouchableLayout hardTouchableLayout = (HardTouchableLayout) getActivity().findViewById(R.id.ig6);
            p.g(hardTouchableLayout, "activity.tab_container_htl");
            ViewGroup.LayoutParams layoutParams = hardTouchableLayout.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
                AppMethodBeat.o(248983);
                throw tVar;
            }
            ((ConstraintLayout.LayoutParams) layoutParams).leftMargin = 0;
        }
        TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.igb);
        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
        int i2 = 0;
        for (T t : ((NearbyHomeUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(NearbyHomeUIC.class)).fragments) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            T t2 = t;
            TabLayout.f cW = tabLayout.cW();
            p.g(cW, "tabLayout.newTab()");
            b bVar = new b(cW, t2.dLS);
            if (!TextUtils.isEmpty(t2.title)) {
                bVar.setTitle(t2.title);
            } else {
                String string = getContext().getString(t2.uQk);
                p.g(string, "context.getString(fragment.titleId)");
                bVar.setTitle(string);
            }
            bVar.index = i2;
            tabLayout.a(bVar.vq, false);
            i2 = i3;
        }
        tabLayout.a(new c(this));
        TabLayout tabLayout2 = (TabLayout) getActivity().findViewById(R.id.igb);
        com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h hVar2 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dbc(), getActivity(), new h(this, tabLayout2));
        com.tencent.mm.plugin.finder.extension.reddot.h hVar3 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h hVar4 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dbd(), getActivity(), new i(this, tabLayout2));
        com.tencent.mm.plugin.finder.extension.reddot.h hVar5 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h hVar6 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dbe(), getActivity(), new j(this, tabLayout2));
        AppMethodBeat.o(248983);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ NearbyActionBarUIC uPY;

        d(NearbyActionBarUIC nearbyActionBarUIC) {
            this.uPY = nearbyActionBarUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248972);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.uPY.getActivity().onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248972);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class e implements HardTouchableLayout.g {
        final /* synthetic */ NearbyActionBarUIC uPY;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(NearbyActionBarUIC nearbyActionBarUIC) {
            this.uPY = nearbyActionBarUIC;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.g
        public final void b(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(248974);
            p.h(view, "view");
            Log.i("NearbyActionBarUIC", "onDoubleClick ...");
            com.tencent.f.h.RTc.aV(new a(this));
            AppMethodBeat.o(248974);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ e uPZ;

            a(e eVar) {
                this.uPZ = eVar;
            }

            public final void run() {
                AppMethodBeat.i(248973);
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                AbsNearByFragment dlj = ((NearbyHomeUIC) com.tencent.mm.ui.component.a.b(this.uPZ.uPY.getActivity()).get(NearbyHomeUIC.class)).dlj();
                if (dlj != null) {
                    dlj.dll();
                    AppMethodBeat.o(248973);
                    return;
                }
                AppMethodBeat.o(248973);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class f implements HardTouchableLayout.b {
        final /* synthetic */ NearbyActionBarUIC uPY;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(NearbyActionBarUIC nearbyActionBarUIC) {
            this.uPY = nearbyActionBarUIC;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.b
        public final void a(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(248976);
            p.h(view, "view");
            p.h(motionEvent, "e");
            Log.i("NearbyActionBarUIC", "onDoubleClick ...");
            com.tencent.f.h.RTc.aV(new a(this));
            AppMethodBeat.o(248976);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ f uQa;

            a(f fVar) {
                this.uQa = fVar;
            }

            public final void run() {
                AppMethodBeat.i(248975);
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                AbsNearByFragment dlj = ((NearbyHomeUIC) com.tencent.mm.ui.component.a.b(this.uQa.uPY.getActivity()).get(NearbyHomeUIC.class)).dlj();
                if (dlj != null) {
                    dlj.dlm();
                    AppMethodBeat.o(248975);
                    return;
                }
                AppMethodBeat.o(248975);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ NearbyActionBarUIC uPY;

        g(NearbyActionBarUIC nearbyActionBarUIC) {
            this.uPY = nearbyActionBarUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248978);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("NearbyActionBarUIC", "onMenuClick ...");
            y yVar = y.vXH;
            if (y.isFastClick()) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248978);
                return;
            }
            com.tencent.f.h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC.g.AnonymousClass1 */
                final /* synthetic */ g uQb;

                {
                    this.uQb = r1;
                }

                public final void run() {
                    AppMethodBeat.i(248977);
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    AbsNearByFragment dlj = ((NearbyHomeUIC) com.tencent.mm.ui.component.a.b(this.uQb.uPY.getActivity()).get(NearbyHomeUIC.class)).dlj();
                    if (dlj != null) {
                        dlj.dlk();
                        AppMethodBeat.o(248977);
                        return;
                    }
                    AppMethodBeat.o(248977);
                }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248978);
        }
    }

    public final void Jx(int i2) {
        TabLayout.f ab;
        AppMethodBeat.i(248984);
        TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.igb);
        if (tabLayout == null || (ab = tabLayout.ab(i2)) == null) {
            AppMethodBeat.o(248984);
            return;
        }
        p.g(ab, "this");
        if (!ab.isSelected()) {
            ab.select();
        }
        AppMethodBeat.o(248984);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0017J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0017J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0017¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$buildTab$2", "Landroid/support/design/widget/TabLayout$BaseOnTabSelectedListener;", "Landroid/support/design/widget/TabLayout$Tab;", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder_release"})
    public static final class c implements TabLayout.b<TabLayout.f> {
        final /* synthetic */ NearbyActionBarUIC uPY;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(NearbyActionBarUIC nearbyActionBarUIC) {
            this.uPY = nearbyActionBarUIC;
        }

        @Override // android.support.design.widget.TabLayout.b
        @SuppressLint({"ResourceType"})
        public final void k(TabLayout.f fVar) {
            AppMethodBeat.i(248969);
            p.h(fVar, "t");
            AppMethodBeat.o(248969);
        }

        @Override // android.support.design.widget.TabLayout.b
        @SuppressLint({"ResourceType"})
        public final void j(TabLayout.f fVar) {
            AppMethodBeat.i(248970);
            p.h(fVar, "t");
            Object tag = fVar.getTag();
            if (tag instanceof b) {
                ((b) tag).setTextColor(R.color.l4);
                ((b) tag).setTextBold(false);
                switch (((b) tag).dLS) {
                    case 1003:
                        NearbyActionBarUIC.dlg();
                        break;
                }
            }
            AppMethodBeat.o(248970);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.support.design.widget.TabLayout.b
        @SuppressLint({"ResourceType"})
        public final void i(TabLayout.f fVar) {
            AppMethodBeat.i(248971);
            p.h(fVar, "t");
            Object tag = fVar.getTag();
            if (tag instanceof b) {
                ((b) tag).setTextColor(R.color.a2x);
                ((b) tag).setTextBold(true);
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                ((NearbyHomeUIC) com.tencent.mm.ui.component.a.b(this.uPY.getActivity()).get(NearbyHomeUIC.class)).Jz(((b) tag).dLS);
                switch (((b) tag).dLS) {
                    case 1001:
                        NearbyActionBarUIC.a(this.uPY, 1);
                        break;
                    case 1002:
                        NearbyActionBarUIC.a(this.uPY, 2);
                        AppMethodBeat.o(248971);
                        return;
                    case 1003:
                        NearbyActionBarUIC.a(this.uPY, 3);
                        NearbyActionBarUIC.dlg();
                        AppMethodBeat.o(248971);
                        return;
                }
            }
            AppMethodBeat.o(248971);
        }
    }

    public static void dlg() {
        AppMethodBeat.i(248985);
        if (!com.tencent.mm.bp.a.Xm()) {
            Log.i("NearbyActionBarUIC", "checkAddFootPrintRedDot: add footprint red dot");
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            ((PluginFinder) ah).getRedDotManager().tJA.dbs();
            AppMethodBeat.o(248985);
            return;
        }
        Log.i("NearbyActionBarUIC", "checkAddFootPrintRedDot: clear footprint red dot");
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah2).getRedDotManager().Iy(1014);
        AppMethodBeat.o(248985);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(248986);
        super.onResume();
        this.uPU = true;
        AppMethodBeat.o(248986);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(248987);
        super.onPause();
        this.uPU = false;
        AppMethodBeat.o(248987);
    }

    public static TabLayout.f a(TabLayout tabLayout, Object obj) {
        AppMethodBeat.i(248988);
        p.h(tabLayout, "$this$findByTag");
        p.h(obj, "any");
        int tabCount = tabLayout.getTabCount();
        for (int i2 = 0; i2 < tabCount; i2++) {
            TabLayout.f ab = tabLayout.ab(i2);
            if ((ab != null ? ab.getTag() : null) instanceof b) {
                Object tag = ab.getTag();
                if (tag == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC.NearbyTab");
                    AppMethodBeat.o(248988);
                    throw tVar;
                }
                int i3 = ((b) tag).dLS;
                if ((obj instanceof Integer) && i3 == ((Integer) obj).intValue()) {
                    AppMethodBeat.o(248988);
                    return ab;
                }
            }
        }
        AppMethodBeat.o(248988);
        return null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u000203J\u000e\u00104\u001a\u0002012\u0006\u00105\u001a\u00020\u0005J\u000e\u00106\u001a\u0002012\u0006\u00107\u001a\u000208R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\"\"\u0004\b/\u0010$¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$NearbyTab;", "", "tab", "Landroid/support/design/widget/TabLayout$Tab;", "tabType", "", "(Landroid/support/design/widget/TabLayout$Tab;I)V", "bigTabRedIv", "Landroid/widget/ImageView;", "getBigTabRedIv", "()Landroid/widget/ImageView;", "setBigTabRedIv", "(Landroid/widget/ImageView;)V", FirebaseAnalytics.b.INDEX, "getIndex", "()I", "setIndex", "(I)V", "getTab", "()Landroid/support/design/widget/TabLayout$Tab;", "setTab", "(Landroid/support/design/widget/TabLayout$Tab;)V", "tabRedIcon", "Landroid/view/ViewGroup;", "getTabRedIcon", "()Landroid/view/ViewGroup;", "setTabRedIcon", "(Landroid/view/ViewGroup;)V", "tabRedIv", "getTabRedIv", "setTabRedIv", "tabRedTv", "Landroid/widget/TextView;", "getTabRedTv", "()Landroid/widget/TextView;", "setTabRedTv", "(Landroid/widget/TextView;)V", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "setTextBold", "", "isBold", "", "setTextColor", "id", "setTitle", "title", "", "plugin-finder_release"})
    public static final class b {
        int dLS;
        int index;
        TextView titleTv;
        WeImageView uPW;
        ImageView uPX;
        TabLayout.f vq;

        @SuppressLint({"ResourceType"})
        public b(TabLayout.f fVar, int i2) {
            WeImageView weImageView;
            ImageView imageView;
            TextView textView;
            ImageView imageView2;
            TextView textView2;
            ImageView imageView3;
            p.h(fVar, "tab");
            AppMethodBeat.i(248968);
            this.vq = fVar;
            this.dLS = i2;
            this.vq.g(this);
            switch (this.dLS) {
                case 1001:
                    this.vq.aj(R.layout.bf8);
                    View customView = this.vq.getCustomView();
                    if (customView != null) {
                        textView2 = (TextView) customView.findViewById(R.id.ifz);
                    } else {
                        textView2 = null;
                    }
                    if (textView2 == null) {
                        p.hyc();
                    }
                    this.titleTv = textView2;
                    View customView2 = this.vq.getCustomView();
                    if (customView2 != null) {
                        imageView3 = (ImageView) customView2.findViewById(R.id.ifw);
                    } else {
                        imageView3 = null;
                    }
                    if (imageView3 == null) {
                        p.hyc();
                    }
                    this.uPX = imageView3;
                    TextView textView3 = this.titleTv;
                    if (textView3 != null) {
                        textView3.setTextSize(1, 15.0f);
                        AppMethodBeat.o(248968);
                        return;
                    }
                    AppMethodBeat.o(248968);
                    return;
                case 1002:
                    this.vq.aj(R.layout.bf8);
                    View customView3 = this.vq.getCustomView();
                    if (customView3 != null) {
                        textView = (TextView) customView3.findViewById(R.id.ifz);
                    } else {
                        textView = null;
                    }
                    if (textView == null) {
                        p.hyc();
                    }
                    this.titleTv = textView;
                    View customView4 = this.vq.getCustomView();
                    if (customView4 != null) {
                        imageView2 = (ImageView) customView4.findViewById(R.id.ifw);
                    } else {
                        imageView2 = null;
                    }
                    if (imageView2 == null) {
                        p.hyc();
                    }
                    this.uPX = imageView2;
                    TextView textView4 = this.titleTv;
                    if (textView4 != null) {
                        textView4.setTextSize(1, 15.0f);
                        AppMethodBeat.o(248968);
                        return;
                    }
                    AppMethodBeat.o(248968);
                    return;
                case 1003:
                    this.vq.aj(R.layout.bf9);
                    View customView5 = this.vq.getCustomView();
                    TextView textView5 = customView5 != null ? (TextView) customView5.findViewById(R.id.ifz) : null;
                    if (textView5 == null) {
                        p.hyc();
                    }
                    this.titleTv = textView5;
                    TextView textView6 = this.titleTv;
                    if (textView6 != null) {
                        textView6.setTextSize(1, 15.0f);
                    }
                    View customView6 = this.vq.getCustomView();
                    if (customView6 != null) {
                        weImageView = (WeImageView) customView6.findViewById(R.id.ig2);
                    } else {
                        weImageView = null;
                    }
                    if (weImageView == null) {
                        p.hyc();
                    }
                    this.uPW = weImageView;
                    View customView7 = this.vq.getCustomView();
                    if (customView7 != null) {
                        imageView = (ImageView) customView7.findViewById(R.id.ifw);
                    } else {
                        imageView = null;
                    }
                    if (imageView == null) {
                        p.hyc();
                    }
                    this.uPX = imageView;
                    if (com.tencent.mm.bp.a.Xm()) {
                        WeImageView weImageView2 = this.uPW;
                        if (weImageView2 != null) {
                            weImageView2.setVisibility(4);
                            AppMethodBeat.o(248968);
                            return;
                        }
                        AppMethodBeat.o(248968);
                        return;
                    }
                    WeImageView weImageView3 = this.uPW;
                    if (weImageView3 != null) {
                        weImageView3.setVisibility(0);
                        AppMethodBeat.o(248968);
                        return;
                    }
                    AppMethodBeat.o(248968);
                    return;
                default:
                    this.vq.aj(R.layout.ac9);
                    AppMethodBeat.o(248968);
                    return;
            }
        }

        public final void setTitle(String str) {
            AppMethodBeat.i(248965);
            p.h(str, "title");
            TextView textView = this.titleTv;
            if (textView != null) {
                textView.setText(str);
                AppMethodBeat.o(248965);
                return;
            }
            AppMethodBeat.o(248965);
        }

        public final void setTextColor(int i2) {
            AppMethodBeat.i(248966);
            TextView textView = this.titleTv;
            if (textView != null) {
                View customView = this.vq.getCustomView();
                if (customView == null) {
                    p.hyc();
                }
                p.g(customView, "tab.customView!!");
                Context context = customView.getContext();
                p.g(context, "tab.customView!!.context");
                textView.setTextColor(context.getResources().getColor(i2));
                AppMethodBeat.o(248966);
                return;
            }
            AppMethodBeat.o(248966);
        }

        public final void setTextBold(boolean z) {
            AppMethodBeat.i(248967);
            TextView textView = this.titleTv;
            if (textView == null) {
                AppMethodBeat.o(248967);
            } else if (z) {
                ao.a(textView.getPaint(), 0.8f);
                AppMethodBeat.o(248967);
            } else {
                TextPaint paint = textView.getPaint();
                p.g(paint, "it.paint");
                paint.setFakeBoldText(false);
                TextPaint paint2 = textView.getPaint();
                p.g(paint2, "it.paint");
                paint2.setStrokeWidth(0.0f);
                AppMethodBeat.o(248967);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class k extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String tzM;
        final /* synthetic */ NearbyActionBarUIC uPY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(NearbyActionBarUIC nearbyActionBarUIC, String str) {
            super(0);
            this.uPY = nearbyActionBarUIC;
            this.tzM = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            TextView textView;
            AppMethodBeat.i(248982);
            if (!TextUtils.isEmpty(this.tzM)) {
                b a2 = NearbyActionBarUIC.a(this.uPY);
                if (!(a2 == null || (textView = a2.titleTv) == null)) {
                    textView.setText(this.tzM);
                }
                if (this.tzM.length() != 2) {
                    int length = (this.tzM.length() - 2) * com.tencent.mm.live.core.view.c.dip2px(this.uPY.getActivity(), 15.0f);
                    if (((HardTouchableLayout) this.uPY.getActivity().findViewById(R.id.ig6)) != null) {
                        HardTouchableLayout hardTouchableLayout = (HardTouchableLayout) this.uPY.getActivity().findViewById(R.id.ig6);
                        p.g(hardTouchableLayout, "activity.tab_container_htl");
                        if (hardTouchableLayout.getLayoutParams() != null) {
                            HardTouchableLayout hardTouchableLayout2 = (HardTouchableLayout) this.uPY.getActivity().findViewById(R.id.ig6);
                            p.g(hardTouchableLayout2, "activity.tab_container_htl");
                            ViewGroup.LayoutParams layoutParams = hardTouchableLayout2.getLayoutParams();
                            if (layoutParams == null) {
                                t tVar = new t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
                                AppMethodBeat.o(248982);
                                throw tVar;
                            }
                            ((ConstraintLayout.LayoutParams) layoutParams).leftMargin -= length;
                        }
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(248982);
            return xVar;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void a(NearbyActionBarUIC nearbyActionBarUIC, int i2) {
        AppMethodBeat.i(248991);
        switch (i2) {
            case 1:
                ConstraintLayout constraintLayout = (ConstraintLayout) nearbyActionBarUIC.getActivity().findViewById(R.id.ful);
                p.g(constraintLayout, "activity.nearby_menu");
                constraintLayout.setVisibility(0);
                TextView textView = (TextView) nearbyActionBarUIC.getActivity().findViewById(R.id.fum);
                p.g(textView, "activity.nearby_menu_live");
                textView.setVisibility(0);
                WeImageView weImageView = (WeImageView) nearbyActionBarUIC.getActivity().findViewById(R.id.fun);
                p.g(weImageView, "activity.nearby_menu_person");
                weImageView.setVisibility(8);
                AppMethodBeat.o(248991);
                return;
            case 2:
                ConstraintLayout constraintLayout2 = (ConstraintLayout) nearbyActionBarUIC.getActivity().findViewById(R.id.ful);
                p.g(constraintLayout2, "activity.nearby_menu");
                constraintLayout2.setVisibility(4);
                break;
            case 3:
                ConstraintLayout constraintLayout3 = (ConstraintLayout) nearbyActionBarUIC.getActivity().findViewById(R.id.ful);
                p.g(constraintLayout3, "activity.nearby_menu");
                constraintLayout3.setVisibility(0);
                TextView textView2 = (TextView) nearbyActionBarUIC.getActivity().findViewById(R.id.fum);
                p.g(textView2, "activity.nearby_menu_live");
                textView2.setVisibility(8);
                WeImageView weImageView2 = (WeImageView) nearbyActionBarUIC.getActivity().findViewById(R.id.fun);
                p.g(weImageView2, "activity.nearby_menu_person");
                weImageView2.setVisibility(0);
                AppMethodBeat.o(248991);
                return;
        }
        AppMethodBeat.o(248991);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        if (r0 == null) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC.b a(com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC r3) {
        /*
            r2 = 248992(0x3cca0, float:3.48912E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            android.support.v7.app.AppCompatActivity r0 = r3.getActivity()
            android.support.v4.app.FragmentActivity r0 = (android.support.v4.app.FragmentActivity) r0
            r1 = 2131308839(0x7f093127, float:1.8235945E38)
            android.view.View r0 = r0.findViewById(r1)
            android.support.design.widget.TabLayout r0 = (android.support.design.widget.TabLayout) r0
            if (r0 == 0) goto L_0x003a
            r1 = 0
            android.support.design.widget.TabLayout$f r0 = r0.ab(r1)
            if (r0 == 0) goto L_0x003a
            java.lang.String r1 = "it"
            kotlin.g.b.p.g(r0, r1)
            java.lang.Object r0 = r0.getTag()
            if (r0 != 0) goto L_0x0036
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC.NearbyTab"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0036:
            com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC$b r0 = (com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC.b) r0
            if (r0 != 0) goto L_0x003b
        L_0x003a:
            r0 = 0
        L_0x003b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC.a(com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC):com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC$b");
    }
}
