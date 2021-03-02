package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditTextView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderEditTextUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "editFooter", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter;", "editView", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditTextView;", "getLayoutId", "", "goBack", "", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "restore", "saveTextData", "switchAlignMode", "alignMode", "plugin-finder_release"})
public final class FinderEditTextUI extends MMFinderUI {
    final String TAG = "Finder.FinderEditTextUI";
    private HashMap _$_findViewCache;
    private FinderEditTextView vJJ;
    private FinderEditFooter vJK;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252310);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252310);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252309);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252309);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static final /* synthetic */ FinderEditTextView a(FinderEditTextUI finderEditTextUI) {
        AppMethodBeat.i(167233);
        FinderEditTextView finderEditTextView = finderEditTextUI.vJJ;
        if (finderEditTextView == null) {
            p.btv("editView");
        }
        AppMethodBeat.o(167233);
        return finderEditTextView;
    }

    public static final /* synthetic */ void a(FinderEditTextUI finderEditTextUI, int i2) {
        AppMethodBeat.i(167234);
        finderEditTextUI.Ll(i2);
        AppMethodBeat.o(167234);
    }

    public static final /* synthetic */ void b(FinderEditTextUI finderEditTextUI) {
        AppMethodBeat.i(167235);
        finderEditTextUI.goBack();
        AppMethodBeat.o(167235);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(167228);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(167228);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(167229);
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.afz));
        addTextOptionMenu(1, getString(R.string.x5), new c(this), null, t.b.GREEN);
        View findViewById = findViewById(R.id.bwb);
        p.g(findViewById, "findViewById(R.id.edit_view)");
        this.vJJ = (FinderEditTextView) findViewById;
        View findViewById2 = findViewById(R.id.bvr);
        p.g(findViewById2, "findViewById(R.id.edit_footer)");
        this.vJK = (FinderEditFooter) findViewById2;
        FinderEditTextView finderEditTextView = this.vJJ;
        if (finderEditTextView == null) {
            p.btv("editView");
        }
        finderEditTextView.setTextMaxLines(10);
        FinderEditTextView finderEditTextView2 = this.vJJ;
        if (finderEditTextView2 == null) {
            p.btv("editView");
        }
        finderEditTextView2.setTextCursorDrawable(R.drawable.a70);
        FinderEditTextView finderEditTextView3 = this.vJJ;
        if (finderEditTextView3 == null) {
            p.btv("editView");
        }
        finderEditTextView3.setTextGravity(8388611);
        FinderEditTextView finderEditTextView4 = this.vJJ;
        if (finderEditTextView4 == null) {
            p.btv("editView");
        }
        finderEditTextView4.setTextInputType(147457);
        FinderEditTextView finderEditTextView5 = this.vJJ;
        if (finderEditTextView5 == null) {
            p.btv("editView");
        }
        String string = getString(R.string.d5j);
        p.g(string, "getString(R.string.finder_post_text_hint)");
        finderEditTextView5.setTextHint(string);
        FinderEditTextView finderEditTextView6 = this.vJJ;
        if (finderEditTextView6 == null) {
            p.btv("editView");
        }
        MMEditText mMEditText = finderEditTextView6.wkS;
        if (mMEditText == null) {
            p.btv("editText");
        }
        mMEditText.requestFocus();
        String stringExtra = getIntent().getStringExtra("saveText");
        if (!Util.isNullOrNil(stringExtra)) {
            FinderEditTextView finderEditTextView7 = this.vJJ;
            if (finderEditTextView7 == null) {
                p.btv("editView");
            }
            p.g(stringExtra, "textStr");
            finderEditTextView7.awW(stringExtra);
        }
        int intExtra = getIntent().getIntExtra("saveAlign", -1);
        if (intExtra > 0) {
            Ll(intExtra);
        }
        showVKB();
        FinderEditFooter finderEditFooter = this.vJK;
        if (finderEditFooter == null) {
            p.btv("editFooter");
        }
        finderEditFooter.setAlignModeChangeListener(new d(this));
        FinderEditFooter finderEditFooter2 = this.vJK;
        if (finderEditFooter2 == null) {
            p.btv("editFooter");
        }
        finderEditFooter2.setSmileyTextOperationListener(new e(this));
        setBackBtn(new f(this));
        AppMethodBeat.o(167229);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderEditTextUI vJL;

        c(FinderEditTextUI finderEditTextUI) {
            this.vJL = finderEditTextUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167223);
            FinderEditTextUI.a(this.vJL).setTextCursorVisible(false);
            Bitmap bitmapFromView = BitmapUtil.getBitmapFromView(FinderEditTextUI.a(this.vJL));
            if (bitmapFromView != null) {
                al alVar = al.waC;
                String str = al.dEG() + "text_" + System.nanoTime() + ".tmp";
                BitmapUtil.saveBitmapToImage(bitmapFromView, 80, Bitmap.CompressFormat.JPEG, str, true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                Intent intent = new Intent();
                intent.putExtra("postType", 7);
                intent.putExtra("hideDescEdit", true);
                intent.putExtra("postMediaList", arrayList);
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(this.vJL, intent);
                this.vJL.finish();
            }
            AppMethodBeat.o(167223);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderEditTextUI$initView$2", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "onAlignModeChange", "", "alignMode", "", "plugin-finder_release"})
    public static final class d implements FinderEditFooter.a {
        final /* synthetic */ FinderEditTextUI vJL;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderEditTextUI finderEditTextUI) {
            this.vJL = finderEditTextUI;
        }

        @Override // com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter.a
        public final void Lm(int i2) {
            AppMethodBeat.i(167224);
            Log.i(this.vJL.TAG, "alignMode changed to ".concat(String.valueOf(i2)));
            FinderEditTextUI.a(this.vJL, i2);
            AppMethodBeat.o(167224);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderEditTextUI$initView$3", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
    public static final class e implements ChatFooterPanel.a {
        final /* synthetic */ FinderEditTextUI vJL;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderEditTextUI finderEditTextUI) {
            this.vJL = finderEditTextUI;
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void append(String str) {
            AppMethodBeat.i(167225);
            if (!Util.isNullOrNil(str)) {
                FinderEditTextView a2 = FinderEditTextUI.a(this.vJL);
                if (str == null) {
                    p.hyc();
                }
                a2.awW(str);
            }
            AppMethodBeat.o(167225);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHC() {
            AppMethodBeat.i(167226);
            MMEditText mMEditText = FinderEditTextUI.a(this.vJL).wkS;
            if (mMEditText == null) {
                p.btv("editText");
            }
            InputConnection inputConnection = mMEditText.getInputConnection();
            if (inputConnection != null) {
                inputConnection.sendKeyEvent(new KeyEvent(0, 67));
                inputConnection.sendKeyEvent(new KeyEvent(1, 67));
                AppMethodBeat.o(167226);
                return;
            }
            AppMethodBeat.o(167226);
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void eP(boolean z) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
        public final void aHD() {
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class f implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderEditTextUI vJL;

        f(FinderEditTextUI finderEditTextUI) {
            this.vJL = finderEditTextUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167227);
            FinderEditTextUI.b(this.vJL);
            AppMethodBeat.o(167227);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(167230);
        goBack();
        AppMethodBeat.o(167230);
    }

    private final void goBack() {
        AppMethodBeat.i(167231);
        FinderEditTextView finderEditTextView = this.vJJ;
        if (finderEditTextView == null) {
            p.btv("editView");
        }
        if (Util.isNullOrNil(finderEditTextView.getText().toString())) {
            finish();
            AppMethodBeat.o(167231);
            return;
        }
        h.a((Context) this, (int) R.string.db0, 0, (int) R.string.db4, (int) R.string.db3, true, (DialogInterface.OnClickListener) new a(this), (DialogInterface.OnClickListener) new b(this), (int) R.color.cc);
        AppMethodBeat.o(167231);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class a implements DialogInterface.OnClickListener {
        final /* synthetic */ FinderEditTextUI vJL;

        a(FinderEditTextUI finderEditTextUI) {
            this.vJL = finderEditTextUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(167221);
            Parcel obtain = Parcel.obtain();
            p.g(obtain, "Parcel.obtain()");
            FinderEditTextUI.c(this.vJL);
            this.vJL.getIntent().writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            com.tencent.mm.kernel.e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_OPEN_UPLOAD_DRAFT_STRING_SYNC, com.tencent.e.f.e.bytesToHexString(marshall));
            this.vJL.finish();
            AppMethodBeat.o(167221);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class b implements DialogInterface.OnClickListener {
        final /* synthetic */ FinderEditTextUI vJL;

        b(FinderEditTextUI finderEditTextUI) {
            this.vJL = finderEditTextUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(167222);
            com.tencent.mm.kernel.e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_OPEN_UPLOAD_DRAFT_STRING_SYNC, "");
            this.vJL.finish();
            AppMethodBeat.o(167222);
        }
    }

    private final void Ll(int i2) {
        AppMethodBeat.i(167232);
        FinderEditFooter.b bVar = FinderEditFooter.wBZ;
        if (i2 == FinderEditFooter.wBV) {
            FinderEditTextView finderEditTextView = this.vJJ;
            if (finderEditTextView == null) {
                p.btv("editView");
            }
            finderEditTextView.setTextGravity(8388611);
        } else {
            FinderEditFooter.b bVar2 = FinderEditFooter.wBZ;
            if (i2 == FinderEditFooter.wBW) {
                FinderEditTextView finderEditTextView2 = this.vJJ;
                if (finderEditTextView2 == null) {
                    p.btv("editView");
                }
                finderEditTextView2.setTextGravity(1);
            }
        }
        getIntent().putExtra("saveAlign", i2);
        AppMethodBeat.o(167232);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a_d;
    }

    public static final /* synthetic */ void c(FinderEditTextUI finderEditTextUI) {
        AppMethodBeat.i(167236);
        Intent intent = finderEditTextUI.getIntent();
        FinderEditTextView finderEditTextView = finderEditTextUI.vJJ;
        if (finderEditTextView == null) {
            p.btv("editView");
        }
        intent.putExtra("saveText", finderEditTextView.getText());
        AppMethodBeat.o(167236);
    }
}
