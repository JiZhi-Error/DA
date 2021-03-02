package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.by;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010.\u001a\u00020\u0019H\u0014J\b\u0010/\u001a\u000200H\u0002J\u0012\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u000200H\u0014J,\u00105\u001a\u0002002\u0006\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u00192\b\u00108\u001a\u0004\u0018\u00010\u00052\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u000200H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u001a\u0010#\u001a\u00020$X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "button", "Landroid/widget/Button;", "getButton", "()Landroid/widget/Button;", "setButton", "(Landroid/widget/Button;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "pageState", "", "readCheckBox", "Landroid/widget/CheckBox;", "getReadCheckBox", "()Landroid/widget/CheckBox;", "setReadCheckBox", "(Landroid/widget/CheckBox;)V", "readContentTv", "getReadContentTv", "setReadContentTv", "readLayout", "Landroid/widget/LinearLayout;", "getReadLayout", "()Landroid/widget/LinearLayout;", "setReadLayout", "(Landroid/widget/LinearLayout;)V", "tipDialog", "Landroid/app/Dialog;", "titleTv", "getTitleTv", "setTitleTv", "getLayoutId", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshView", "plugin-finder_release"})
public final class FinderOriginalRequestUI extends MMFinderUI implements i {
    private final String TAG = "Finder.FinderOriginalRequestUI";
    private HashMap _$_findViewCache;
    public TextView hPW;
    private Dialog tipDialog;
    public TextView titleTv;
    public WeImageView ubT;
    public LinearLayout ubU;
    public CheckBox ubV;
    public TextView ubW;
    public Button ubX;
    private int ubY;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245447);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245447);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245446);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245446);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final Button dek() {
        AppMethodBeat.i(245441);
        Button button = this.ubX;
        if (button == null) {
            p.btv("button");
        }
        AppMethodBeat.o(245441);
        return button;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ahx;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(245442);
        super.onCreate(bundle);
        com.tencent.mm.plugin.finder.utils.p pVar = com.tencent.mm.plugin.finder.utils.p.vVY;
        if (com.tencent.mm.plugin.finder.utils.p.dBW() == 3) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.ubY = 2;
        }
        setActionbarColor(getResources().getColor(R.color.afz));
        setMMTitle("");
        setBackBtn(new c(this));
        View findViewById = findViewById(R.id.g6n);
        p.g(findViewById, "findViewById(R.id.original_icon_iv)");
        this.ubT = (WeImageView) findViewById;
        View findViewById2 = findViewById(R.id.g6y);
        p.g(findViewById2, "findViewById(R.id.original_title_tv)");
        this.titleTv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.g6l);
        p.g(findViewById3, "findViewById(R.id.original_desc_tv)");
        this.hPW = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.g6k);
        p.g(findViewById4, "findViewById(R.id.original_checkbox_layout)");
        this.ubU = (LinearLayout) findViewById4;
        View findViewById5 = findViewById(R.id.g6j);
        p.g(findViewById5, "findViewById(R.id.original_checkbox)");
        this.ubV = (CheckBox) findViewById5;
        View findViewById6 = findViewById(R.id.g6v);
        p.g(findViewById6, "findViewById(R.id.original_read_tv)");
        this.ubW = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.aib);
        p.g(findViewById7, "findViewById(R.id.cancel_btn)");
        this.ubX = (Button) findViewById7;
        CheckBox checkBox = this.ubV;
        if (checkBox == null) {
            p.btv("readCheckBox");
        }
        checkBox.setOnCheckedChangeListener(new a(this));
        LinearLayout linearLayout = this.ubU;
        if (linearLayout == null) {
            p.btv("readLayout");
        }
        linearLayout.setOnClickListener(new b(this));
        refreshView();
        g.azz().a(3785, this);
        AppMethodBeat.o(245442);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderOriginalRequestUI ubZ;

        c(FinderOriginalRequestUI finderOriginalRequestUI) {
            this.ubZ = finderOriginalRequestUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245437);
            this.ubZ.finish();
            AppMethodBeat.o(245437);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245443);
        super.onDestroy();
        g.azz().b(3785, this);
        AppMethodBeat.o(245443);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
    static final class a implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ FinderOriginalRequestUI ubZ;

        a(FinderOriginalRequestUI finderOriginalRequestUI) {
            this.ubZ = finderOriginalRequestUI;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.i(245435);
            this.ubZ.dek().setClickable(z);
            this.ubZ.dek().setEnabled(z);
            AppMethodBeat.o(245435);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ FinderOriginalRequestUI ubZ;

        b(FinderOriginalRequestUI finderOriginalRequestUI) {
            this.ubZ = finderOriginalRequestUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245436);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            CheckBox checkBox = this.ubZ.ubV;
            if (checkBox == null) {
                p.btv("readCheckBox");
            }
            checkBox.toggle();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245436);
        }
    }

    private final void refreshView() {
        AppMethodBeat.i(245444);
        if (this.ubY == 1) {
            WeImageView weImageView = this.ubT;
            if (weImageView == null) {
                p.btv("iconIv");
            }
            weImageView.setImageResource(R.raw.icons_filled_done2);
            WeImageView weImageView2 = this.ubT;
            if (weImageView2 == null) {
                p.btv("iconIv");
            }
            weImageView2.setIconColor(getResources().getColor(R.color.Brand));
            TextView textView = this.titleTv;
            if (textView == null) {
                p.btv("titleTv");
            }
            textView.setText(getString(R.string.d4p));
            TextView textView2 = this.hPW;
            if (textView2 == null) {
                p.btv("descTv");
            }
            textView2.setText(R.string.d4o);
            LinearLayout linearLayout = this.ubU;
            if (linearLayout == null) {
                p.btv("readLayout");
            }
            linearLayout.setVisibility(8);
            Button button = this.ubX;
            if (button == null) {
                p.btv("button");
            }
            button.setClickable(true);
            Button button2 = this.ubX;
            if (button2 == null) {
                p.btv("button");
            }
            button2.setEnabled(true);
            Button button3 = this.ubX;
            if (button3 == null) {
                p.btv("button");
            }
            button3.setText(R.string.vl);
            Button button4 = this.ubX;
            if (button4 == null) {
                p.btv("button");
            }
            button4.setOnClickListener(new d(this));
            AppMethodBeat.o(245444);
        } else if (this.ubY == 0) {
            WeImageView weImageView3 = this.ubT;
            if (weImageView3 == null) {
                p.btv("iconIv");
            }
            weImageView3.setImageResource(R.raw.finder_original);
            WeImageView weImageView4 = this.ubT;
            if (weImageView4 == null) {
                p.btv("iconIv");
            }
            weImageView4.setIconColor(getResources().getColor(R.color.Orange_100));
            TextView textView3 = this.titleTv;
            if (textView3 == null) {
                p.btv("titleTv");
            }
            textView3.setText(getString(R.string.d4h));
            TextView textView4 = this.hPW;
            if (textView4 == null) {
                p.btv("descTv");
            }
            textView4.setText(getString(R.string.d4e));
            String string = getString(R.string.d4b);
            p.g(string, "getString(R.string.finde…original_agree_tips_link)");
            String string2 = getString(R.string.d4a, new Object[]{string});
            p.g(string2, "getString(R.string.finde…_agree_tips, readingText)");
            com.tencent.mm.plugin.finder.utils.p pVar = com.tencent.mm.plugin.finder.utils.p.vVY;
            AppCompatActivity context = getContext();
            p.g(context, "context");
            AppCompatActivity appCompatActivity = context;
            com.tencent.mm.plugin.finder.utils.p pVar2 = com.tencent.mm.plugin.finder.utils.p.vVY;
            String dBT = com.tencent.mm.plugin.finder.utils.p.dBT();
            TextView textView5 = this.ubW;
            if (textView5 == null) {
                p.btv("readContentTv");
            }
            com.tencent.mm.plugin.finder.utils.p.a(appCompatActivity, dBT, string2, string, textView5, this.TAG);
            LinearLayout linearLayout2 = this.ubU;
            if (linearLayout2 == null) {
                p.btv("readLayout");
            }
            linearLayout2.setVisibility(0);
            Button button5 = this.ubX;
            if (button5 == null) {
                p.btv("button");
            }
            button5.setVisibility(0);
            Button button6 = this.ubX;
            if (button6 == null) {
                p.btv("button");
            }
            button6.setText(R.string.d4c);
            Button button7 = this.ubX;
            if (button7 == null) {
                p.btv("button");
            }
            button7.setOnClickListener(new e(this));
            AppMethodBeat.o(245444);
        } else {
            WeImageView weImageView5 = this.ubT;
            if (weImageView5 == null) {
                p.btv("iconIv");
            }
            weImageView5.setImageResource(R.raw.icons_filled_error);
            WeImageView weImageView6 = this.ubT;
            if (weImageView6 == null) {
                p.btv("iconIv");
            }
            weImageView6.setIconColor(getResources().getColor(R.color.Orange_100));
            TextView textView6 = this.titleTv;
            if (textView6 == null) {
                p.btv("titleTv");
            }
            textView6.setText(R.string.d4v);
            String string3 = getString(R.string.d4b);
            p.g(string3, "getString(R.string.finde…original_agree_tips_link)");
            com.tencent.mm.plugin.finder.utils.p pVar3 = com.tencent.mm.plugin.finder.utils.p.vVY;
            if (com.tencent.mm.plugin.finder.utils.p.dBX()) {
                com.tencent.mm.plugin.finder.utils.p pVar4 = com.tencent.mm.plugin.finder.utils.p.vVY;
                AppCompatActivity context2 = getContext();
                p.g(context2, "context");
                AppCompatActivity appCompatActivity2 = context2;
                com.tencent.mm.plugin.finder.utils.p pVar5 = com.tencent.mm.plugin.finder.utils.p.vVY;
                String dBT2 = com.tencent.mm.plugin.finder.utils.p.dBT();
                String string4 = getString(R.string.d4u, new Object[]{string3});
                p.g(string4, "getString(R.string.finde…nal_spam_desc2, linkText)");
                TextView textView7 = this.hPW;
                if (textView7 == null) {
                    p.btv("descTv");
                }
                com.tencent.mm.plugin.finder.utils.p.a(appCompatActivity2, dBT2, string4, string3, textView7, this.TAG);
            } else {
                com.tencent.mm.plugin.finder.utils.p pVar6 = com.tencent.mm.plugin.finder.utils.p.vVY;
                AppCompatActivity context3 = getContext();
                p.g(context3, "context");
                AppCompatActivity appCompatActivity3 = context3;
                com.tencent.mm.plugin.finder.utils.p pVar7 = com.tencent.mm.plugin.finder.utils.p.vVY;
                String dBT3 = com.tencent.mm.plugin.finder.utils.p.dBT();
                com.tencent.mm.plugin.finder.utils.p pVar8 = com.tencent.mm.plugin.finder.utils.p.vVY;
                String string5 = getString(R.string.d4t, new Object[]{string3, String.valueOf(com.tencent.mm.plugin.finder.utils.p.dBY())});
                p.g(string5, "getString(R.string.finde….getSpamDay().toString())");
                TextView textView8 = this.hPW;
                if (textView8 == null) {
                    p.btv("descTv");
                }
                com.tencent.mm.plugin.finder.utils.p.a(appCompatActivity3, dBT3, string5, string3, textView8, this.TAG);
            }
            LinearLayout linearLayout3 = this.ubU;
            if (linearLayout3 == null) {
                p.btv("readLayout");
            }
            linearLayout3.setVisibility(8);
            Button button8 = this.ubX;
            if (button8 == null) {
                p.btv("button");
            }
            button8.setVisibility(8);
            AppMethodBeat.o(245444);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ FinderOriginalRequestUI ubZ;

        d(FinderOriginalRequestUI finderOriginalRequestUI) {
            this.ubZ = finderOriginalRequestUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245438);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.ubZ.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245438);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ FinderOriginalRequestUI ubZ;

        e(FinderOriginalRequestUI finderOriginalRequestUI) {
            this.ubZ = finderOriginalRequestUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245440);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            String aUg = z.aUg();
            if (Util.isNullOrNil(aUg)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(245440);
                return;
            }
            Dialog dialog = this.ubZ.tipDialog;
            if (dialog != null) {
                dialog.show();
            } else {
                FinderOriginalRequestUI finderOriginalRequestUI = this.ubZ;
                finderOriginalRequestUI.getContext().getString(R.string.zb);
                finderOriginalRequestUI.tipDialog = h.a((Context) finderOriginalRequestUI.getContext(), finderOriginalRequestUI.getContext().getString(R.string.a06), false, (DialogInterface.OnCancelListener) a.uca);
            }
            p.g(aUg, ch.COL_USERNAME);
            g.azz().b(new by(aUg, (byte) 0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245440);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
        static final class a implements DialogInterface.OnCancelListener {
            public static final a uca = new a();

            static {
                AppMethodBeat.i(245439);
                AppMethodBeat.o(245439);
            }

            a() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(245445);
        Dialog dialog = this.tipDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            this.ubY = 1;
            refreshView();
            AppMethodBeat.o(245445);
            return;
        }
        u.makeText(this, (int) R.string.d32, 0).show();
        AppMethodBeat.o(245445);
    }
}
