package com.tencent.mm.plugin.finder.ui;

import android.app.ProgressDialog;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\fH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderConversationXXUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "()V", "tipDialog", "Landroid/app/ProgressDialog;", "getTipDialog", "()Landroid/app/ProgressDialog;", "setTipDialog", "(Landroid/app/ProgressDialog;)V", "doSomethingOnConvDel", "", "getLayoutId", "", "getTitleResId", "isLastHiSession", "", "onChattingUIExit", "showMoreSheet", "updateActionBar", "talkerType", "plugin-finder_release"})
public final class FinderConversationXXUI extends FinderConversationParentUI {
    private HashMap _$_findViewCache;
    private ProgressDialog gtM;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.finder.ui.FinderConversationParentUI, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252236);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252236);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.finder.ui.FinderConversationParentUI, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252235);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252235);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.finder.ui.FinderConversationParentUI, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.finder.ui.FinderConversationParentUI
    public final int getLayoutId() {
        return R.layout.a_8;
    }

    @Override // com.tencent.mm.plugin.finder.ui.FinderConversationParentUI
    public final int dzb() {
        return R.string.ck3;
    }

    @Override // com.tencent.mm.plugin.finder.ui.FinderConversationParentUI
    public final void dyZ() {
        AppMethodBeat.i(252233);
        ProgressDialog progressDialog = this.gtM;
        if (progressDialog != null) {
            Log.i("Finder.FinderConversationParentUI", "datasize " + this.vHP.ppH.isEmpty());
            if (this.vHP.ppH.isEmpty() && progressDialog.isShowing()) {
                Log.i("Finder.FinderConversationParentUI", "clear hello conv finish");
                ProgressDialog progressDialog2 = this.gtM;
                if (progressDialog2 != null) {
                    progressDialog2.dismiss();
                }
                this.gtM = null;
            }
            AppMethodBeat.o(252233);
            return;
        }
        AppMethodBeat.o(252233);
    }

    @Override // com.tencent.mm.j.a.b, com.tencent.mm.plugin.finder.ui.FinderConversationParentUI, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
    public final boolean any() {
        boolean z;
        AppMethodBeat.i(252234);
        if (this.vHP.ppH.size() != 1 || this.vHP.ppH.get(0).field_type == 1) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            setResult(1);
            finish();
            overridePendingTransition(0, 0);
            AppMethodBeat.o(252234);
            return true;
        }
        boolean any = super.any();
        AppMethodBeat.o(252234);
        return any;
    }
}
