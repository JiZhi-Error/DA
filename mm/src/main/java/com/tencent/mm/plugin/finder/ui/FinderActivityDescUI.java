package com.tencent.mm.plugin.finder.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.activity.uic.FinderActivityDescUIC;
import com.tencent.mm.plugin.finder.loader.g;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tavkit.component.TAVExporter;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0014J\u0018\u0010\n\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J,\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderActivityDescUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "descContainer", "Landroid/view/View;", "fixActionBar", "", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setFullScreen", "plugin-finder_release"})
public final class FinderActivityDescUI extends MMFinderUI implements i {
    private HashMap _$_findViewCache;
    private View uhh;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252105);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252105);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252104);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252104);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(252102);
        super.onCreate(bundle);
        View findViewById = findViewById(R.id.en);
        p.g(findViewById, "findViewById(R.id.activity_desc_container)");
        this.uhh = findViewById;
        getController().setStatusBarColor(getResources().getColor(R.color.ac_));
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setBackgroundDrawable(new ColorDrawable(0));
            supportActionBar.hide();
        }
        int statusBarHeight = au.getStatusBarHeight(this);
        View view = this.uhh;
        if (view == null) {
            p.btv("descContainer");
        }
        int paddingTop = view.getPaddingTop();
        View view2 = this.uhh;
        if (view2 == null) {
            p.btv("descContainer");
        }
        view2.setPadding(0, statusBarHeight + paddingTop, 0, 0);
        getController().setStatusBarColor(getResources().getColor(R.color.ac_));
        setBackBtn(new a(this));
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderActivityDescUIC finderActivityDescUIC = (FinderActivityDescUIC) com.tencent.mm.ui.component.a.b(this).get(FinderActivityDescUIC.class);
        View findViewById2 = finderActivityDescUIC.getActivity().findViewById(R.id.f8);
        p.g(findViewById2, "activity.findViewById(R.…vity_profile_header_name)");
        finderActivityDescUIC.tqS = (TextView) findViewById2;
        View findViewById3 = finderActivityDescUIC.getActivity().findViewById(R.id.cjm);
        p.g(findViewById3, "activity.findViewById(R.id.finder_activity_name)");
        finderActivityDescUIC.tqT = (TextView) findViewById3;
        View findViewById4 = finderActivityDescUIC.getActivity().findViewById(R.id.cjb);
        p.g(findViewById4, "activity.findViewById(R.id.finder_activity_desc)");
        finderActivityDescUIC.tqU = (TextView) findViewById4;
        View findViewById5 = finderActivityDescUIC.getActivity().findViewById(R.id.cjs);
        p.g(findViewById5, "activity.findViewById(R.…activity_post_cancel_btn)");
        finderActivityDescUIC.hPV = (WeImageView) findViewById5;
        View findViewById6 = finderActivityDescUIC.getActivity().findViewById(R.id.ck2);
        p.g(findViewById6, "activity.findViewById(R.…nder_activity_post_title)");
        finderActivityDescUIC.hbb = (TextView) findViewById6;
        View findViewById7 = finderActivityDescUIC.getActivity().findViewById(R.id.ew);
        p.g(findViewById7, "activity.findViewById(R.id.activity_post_cover)");
        finderActivityDescUIC.cxe = (ImageView) findViewById7;
        View findViewById8 = finderActivityDescUIC.getActivity().findViewById(R.id.f2);
        p.g(findViewById8, "activity.findViewById(R.…ivity_profile_cover_mask)");
        finderActivityDescUIC.tqR = (ImageView) findViewById8;
        View findViewById9 = finderActivityDescUIC.getActivity().findViewById(R.id.jt5);
        p.g(findViewById9, "activity.findViewById(R.…_profile_cover_container)");
        finderActivityDescUIC.UGZ = (ViewGroup) findViewById9;
        String stringExtra = finderActivityDescUIC.getIntent().getStringExtra("key_cover_url");
        Log.i("Finder.ActivityDescUIC", "initView coverUrl:".concat(String.valueOf(stringExtra)));
        if (!Util.isNullOrNil(stringExtra)) {
            if (stringExtra == null) {
                str = "";
            } else {
                str = stringExtra;
            }
            g gVar = new g(str);
            m mVar = m.uJa;
            b<o, Bitmap> bQ = m.djY().bQ(gVar);
            m mVar2 = m.uJa;
            com.tencent.mm.loader.b<o, Bitmap> a2 = bQ.a(m.a(m.a.PROFILE_COVER)).a(new FinderActivityDescUIC.e(finderActivityDescUIC, stringExtra));
            ImageView imageView = finderActivityDescUIC.cxe;
            if (imageView == null) {
                p.btv("coverImageView");
            }
            a2.c(imageView);
            AppCompatActivity activity = finderActivityDescUIC.getActivity();
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(252102);
                throw tVar;
            }
            ((MMActivity) activity).getController().updataStatusBarIcon(true);
            finderActivityDescUIC.Ii(finderActivityDescUIC.getResources().getColor(R.color.BW_100_Alpha_0_8));
            int color = finderActivityDescUIC.getResources().getColor(R.color.pg);
            TextView textView = finderActivityDescUIC.tqU;
            if (textView == null) {
                p.btv("activityDescText");
            }
            textView.setTextColor(color);
            TextView textView2 = finderActivityDescUIC.tqU;
            if (textView2 == null) {
                p.btv("activityDescText");
            }
            textView2.setHintTextColor(finderActivityDescUIC.getResources().getColor(R.color.BW_100_Alpha_0_3));
            TextView textView3 = finderActivityDescUIC.tqT;
            if (textView3 == null) {
                p.btv("activityNameText");
            }
            textView3.setTextColor(color);
            ImageView imageView2 = finderActivityDescUIC.cxe;
            if (imageView2 == null) {
                p.btv("coverImageView");
            }
            imageView2.setVisibility(0);
            ViewGroup viewGroup = finderActivityDescUIC.UGZ;
            if (viewGroup == null) {
                p.btv("coverMaskContainer");
            }
            viewGroup.setVisibility(0);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            AppCompatActivity activity2 = finderActivityDescUIC.getActivity();
            if (activity2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(252102);
                throw tVar2;
            }
            WindowManager windowManager = activity2.getWindowManager();
            p.g(windowManager, "(activity as Activity).windowManager");
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            float f2 = ((float) displayMetrics.widthPixels) * 1.3333334f;
            ImageView imageView3 = finderActivityDescUIC.tqR;
            if (imageView3 == null) {
                p.btv("coverMaskImageView");
            }
            ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
            if (layoutParams == null) {
                t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                AppMethodBeat.o(252102);
                throw tVar3;
            }
            layoutParams.height = (int) f2;
            ImageView imageView4 = finderActivityDescUIC.tqR;
            if (imageView4 == null) {
                p.btv("coverMaskImageView");
            }
            imageView4.setLayoutParams(layoutParams);
            ImageView imageView5 = finderActivityDescUIC.cxe;
            if (imageView5 == null) {
                p.btv("coverImageView");
            }
            imageView5.post(new FinderActivityDescUIC.b(finderActivityDescUIC));
        } else {
            AppCompatActivity activity3 = finderActivityDescUIC.getActivity();
            if (activity3 == null) {
                t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(252102);
                throw tVar4;
            }
            ((MMActivity) activity3).getController().updataStatusBarIcon(ao.isDarkMode());
            finderActivityDescUIC.Ii(finderActivityDescUIC.getResources().getColor(R.color.FG_0));
            int color2 = finderActivityDescUIC.getResources().getColor(R.color.fo);
            TextView textView4 = finderActivityDescUIC.tqU;
            if (textView4 == null) {
                p.btv("activityDescText");
            }
            textView4.setTextColor(color2);
            TextView textView5 = finderActivityDescUIC.tqT;
            if (textView5 == null) {
                p.btv("activityNameText");
            }
            textView5.setTextColor(color2);
            TextView textView6 = finderActivityDescUIC.tqU;
            if (textView6 == null) {
                p.btv("activityDescText");
            }
            textView6.setHintTextColor(finderActivityDescUIC.getResources().getColor(R.color.FG_2));
            ImageView imageView6 = finderActivityDescUIC.cxe;
            if (imageView6 == null) {
                p.btv("coverImageView");
            }
            imageView6.setVisibility(8);
            ViewGroup viewGroup2 = finderActivityDescUIC.UGZ;
            if (viewGroup2 == null) {
                p.btv("coverMaskContainer");
            }
            viewGroup2.setVisibility(8);
        }
        View findViewById10 = finderActivityDescUIC.getActivity().findViewById(R.id.f5);
        p.g(findViewById10, "activity.findViewById(R.…ty_profile_header_avatar)");
        finderActivityDescUIC.tqQ = (ImageView) findViewById10;
        String stringExtra2 = finderActivityDescUIC.getIntent().getStringExtra("key_avatar_url");
        m mVar3 = m.uJa;
        d<o> dka = m.dka();
        com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(stringExtra2);
        ImageView imageView7 = finderActivityDescUIC.tqQ;
        if (imageView7 == null) {
            p.btv("avatarImage");
        }
        m mVar4 = m.uJa;
        dka.a(aVar2, imageView7, m.a(m.a.AVATAR));
        String stringExtra3 = finderActivityDescUIC.getIntent().getStringExtra("key_nick_name");
        TextView textView7 = finderActivityDescUIC.tqS;
        if (textView7 == null) {
            p.btv("nickNameText");
        }
        textView7.setText(com.tencent.mm.pluginsdk.ui.span.l.c(finderActivityDescUIC.getActivity(), stringExtra3));
        TextView textView8 = finderActivityDescUIC.tqT;
        if (textView8 == null) {
            p.btv("activityNameText");
        }
        textView8.setText(finderActivityDescUIC.getIntent().getStringExtra("key_activity_name"));
        String stringExtra4 = finderActivityDescUIC.getIntent().getStringExtra("key_activity_desc");
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        finderActivityDescUIC.UHa = stringExtra4;
        View findViewById11 = finderActivityDescUIC.getActivity().findViewById(R.id.cjf);
        p.g(findViewById11, "activity.findViewById(R.…finder_activity_exit_btn)");
        finderActivityDescUIC.tqV = (TextView) findViewById11;
        TextView textView9 = finderActivityDescUIC.tqV;
        if (textView9 == null) {
            p.btv("exitActivityBtn");
        }
        textView9.setOnClickListener(FinderActivityDescUIC.c.tqZ);
        WeImageView weImageView = finderActivityDescUIC.hPV;
        if (weImageView == null) {
            p.btv("backBtn");
        }
        weImageView.setOnClickListener(new FinderActivityDescUIC.d(finderActivityDescUIC));
        String string = finderActivityDescUIC.getResources().getString(R.string.ch8, finderActivityDescUIC.UHa);
        p.g(string, "resources.getString(R.st…_prefix, descTextContent)");
        TextView textView10 = finderActivityDescUIC.tqU;
        if (textView10 == null) {
            p.btv("activityDescText");
        }
        textView10.setMovementMethod(ScrollingMovementMethod.getInstance());
        TextView textView11 = finderActivityDescUIC.tqU;
        if (textView11 == null) {
            p.btv("activityDescText");
        }
        textView11.setText(string);
        AppMethodBeat.o(252102);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderActivityDescUI vHa;

        a(FinderActivityDescUI finderActivityDescUI) {
            this.vHa = finderActivityDescUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(252101);
            this.vHa.finish();
            AppMethodBeat.o(252101);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(252103);
        Set<Class<? extends UIComponent>> of = ak.setOf(FinderActivityDescUIC.class);
        AppMethodBeat.o(252103);
        return of;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a96;
    }
}
