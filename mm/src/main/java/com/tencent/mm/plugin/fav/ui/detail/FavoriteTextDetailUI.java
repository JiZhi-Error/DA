package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.n.c;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.a.e;

public class FavoriteTextDetailUI extends BaseFavDetailReportUI {
    private static final int tjb = c.aql();
    private l contextMenuHelper;
    private g tcP;
    private long tiR;
    private TextView tjc;
    private g tjd;
    private o.g tje = new o.g() {
        /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.AnonymousClass3 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(107242);
            switch (menuItem.getItemId()) {
                case 1:
                    if (!(FavoriteTextDetailUI.this.tcP == null || FavoriteTextDetailUI.this.tcP.field_favProto == null)) {
                        ClipboardHelper.setText(FavoriteTextDetailUI.this.tcP.field_favProto.desc);
                        h.cD(FavoriteTextDetailUI.this.getContext(), FavoriteTextDetailUI.this.getContext().getString(R.string.ta));
                        break;
                    }
            }
            AppMethodBeat.o(107242);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavoriteTextDetailUI() {
        AppMethodBeat.i(107244);
        AppMethodBeat.o(107244);
    }

    static /* synthetic */ void c(FavoriteTextDetailUI favoriteTextDetailUI) {
        AppMethodBeat.i(235336);
        favoriteTextDetailUI.cWE();
        AppMethodBeat.o(235336);
    }

    static {
        AppMethodBeat.i(107254);
        AppMethodBeat.o(107254);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a8d;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI
    public final MMLoadScrollView cWr() {
        AppMethodBeat.i(107245);
        MMLoadScrollView mMLoadScrollView = (MMLoadScrollView) findViewById(R.id.hcs);
        AppMethodBeat.o(107245);
        return mMLoadScrollView;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(107246);
        super.onCreate(bundle);
        this.tjc = (TextView) findViewById(R.id.ar8);
        this.tiR = getIntent().getLongExtra("key_detail_info_id", -1);
        com.tencent.mm.pluginsdk.wallet.h.setPayChannel(5);
        this.contextMenuHelper = new l(getContext());
        this.contextMenuHelper.a(this.tjc, this, this.tje);
        setMMTitle(getString(R.string.c9_));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(107236);
                FavoriteTextDetailUI.this.finish();
                AppMethodBeat.o(107236);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.hp_, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(107241);
                e eVar = new e((Context) FavoriteTextDetailUI.this.getContext(), 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(107237);
                        if (FavoriteTextDetailUI.this.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
                            mVar.d(2, FavoriteTextDetailUI.this.getString(R.string.cc8));
                        }
                        mVar.d(0, FavoriteTextDetailUI.this.getString(R.string.c9q));
                        mVar.d(1, FavoriteTextDetailUI.this.getString(R.string.cbv));
                        mVar.d(3, FavoriteTextDetailUI.this.getString(R.string.c9s));
                        mVar.d(4, FavoriteTextDetailUI.this.getString(R.string.tf));
                        AppMethodBeat.o(107237);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.AnonymousClass2.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(107240);
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (!(FavoriteTextDetailUI.this.tcP == null || FavoriteTextDetailUI.this.tcP.field_favProto == null)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("key_value", FavoriteTextDetailUI.this.tcP.field_favProto.desc);
                                    intent.putExtra("key_max_count", FavoriteTextDetailUI.tjb);
                                    intent.putExtra("key_show_confirm", true);
                                    intent.putExtra("key_fav_item_id", FavoriteTextDetailUI.this.tcP.field_id);
                                    b.a(FavoriteTextDetailUI.this, ".ui.FavTextEditUI", intent, 1);
                                    FavoriteTextDetailUI.this.thD.tat++;
                                    AppMethodBeat.o(107240);
                                    return;
                                }
                            case 1:
                                j.a(FavoriteTextDetailUI.this, FavoriteTextDetailUI.this.tiR, FavoriteTextDetailUI.this.thD);
                                AppMethodBeat.o(107240);
                                return;
                            case 2:
                                if (!(FavoriteTextDetailUI.this.tcP == null || FavoriteTextDetailUI.this.tcP.field_favProto == null)) {
                                    FavoriteTextDetailUI.this.thD.tar++;
                                    b.c(FavoriteTextDetailUI.this.tcP.field_favProto.desc, FavoriteTextDetailUI.this);
                                    com.tencent.mm.plugin.fav.a.h.w(FavoriteTextDetailUI.this.tcP.field_localId, 1);
                                    AppMethodBeat.o(107240);
                                    return;
                                }
                            case 3:
                                Intent intent2 = new Intent();
                                intent2.putExtra("key_fav_scene", 2);
                                intent2.putExtra("key_fav_item_id", FavoriteTextDetailUI.this.tcP.field_localId);
                                b.b(FavoriteTextDetailUI.this.getContext(), ".ui.FavTagEditUI", intent2);
                                FavoriteTextDetailUI.this.thD.tau++;
                                AppMethodBeat.o(107240);
                                return;
                            case 4:
                                h.a(FavoriteTextDetailUI.this.getContext(), FavoriteTextDetailUI.this.getString(R.string.th), "", new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.AnonymousClass2.AnonymousClass2.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(107239);
                                        final q a2 = h.a((Context) FavoriteTextDetailUI.this.getContext(), FavoriteTextDetailUI.this.getString(R.string.th), false, (DialogInterface.OnCancelListener) null);
                                        b.b(FavoriteTextDetailUI.this.tiR, new Runnable() {
                                            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.AnonymousClass2.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(107238);
                                                FavoriteTextDetailUI.this.thD.tav = true;
                                                a2.dismiss();
                                                Log.d("MicroMsg.FavoriteTextDetailUI", "do del, local id %d", Long.valueOf(FavoriteTextDetailUI.this.tiR));
                                                FavoriteTextDetailUI.this.finish();
                                                AppMethodBeat.o(107238);
                                            }
                                        });
                                        AppMethodBeat.o(107239);
                                    }
                                }, (DialogInterface.OnClickListener) null);
                                break;
                        }
                        AppMethodBeat.o(107240);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(107241);
                return true;
            }
        });
        AppMethodBeat.o(107246);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(107247);
        super.onDestroy();
        AppMethodBeat.o(107247);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(107248);
        super.onResume();
        cWE();
        AppMethodBeat.o(107248);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(107249);
        super.onPause();
        AppMethodBeat.o(107249);
    }

    private void cWE() {
        AppMethodBeat.i(107250);
        this.tcP = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.tiR);
        H(this.tcP);
        if (this.tcP == null || this.tcP.field_favProto == null) {
            Log.w("MicroMsg.FavoriteTextDetailUI", "id[%d] info is null, return", Long.valueOf(this.tiR));
            AppMethodBeat.o(107250);
            return;
        }
        a.a(this, this.tcP);
        if (this.tjd == null || this.tjd.field_edittime != this.tcP.field_edittime) {
            this.tjd = this.tcP;
            this.tjc.setText(this.tcP.field_favProto.desc);
            com.tencent.mm.pluginsdk.ui.span.l.a(this.tjc, 1, 3, t.grX(), com.tencent.mm.pluginsdk.ui.span.l.Krf);
            AppMethodBeat.o(107250);
            return;
        }
        Log.w("MicroMsg.FavoriteTextDetailUI", "not change, return");
        AppMethodBeat.o(107250);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(107251);
        contextMenu.add(0, 1, 0, getString(R.string.t_));
        AppMethodBeat.o(107251);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(107252);
        if (1 == i2 && -1 == i3) {
            h.cD(getContext(), getString(R.string.ym));
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(107243);
                    FavoriteTextDetailUI.c(FavoriteTextDetailUI.this);
                    AppMethodBeat.o(107243);
                }
            }, 250);
            AppMethodBeat.o(107252);
            return;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(107252);
    }
}
