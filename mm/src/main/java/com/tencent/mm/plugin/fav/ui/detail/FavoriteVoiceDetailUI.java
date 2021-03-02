package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.ui.FavChatVoiceView;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import java.util.Iterator;

public class FavoriteVoiceDetailUI extends BaseFavDetailReportUI implements MStorage.IOnStorageChange {
    private n tbL;
    private g tbr;
    private long tiR;
    private FavChatVoiceView tjx;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a8e;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(107284);
        super.onCreate(bundle);
        setMMTitle(getString(R.string.c9_));
        this.tiR = getIntent().getLongExtra("key_detail_info_id", -1);
        String stringExtra = getIntent().getStringExtra("key_detail_data_id");
        this.tbr = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.tiR);
        if (this.tbr == null) {
            Log.w("MicroMsg.FavoriteDetailUI", "get fav item info error");
            finish();
        } else {
            if (!Util.isNullOrNil(stringExtra)) {
                Iterator<aml> it = this.tbr.field_favProto.ppH.iterator();
                while (it.hasNext()) {
                    if (!it.next().dLl.equals(stringExtra)) {
                        it.remove();
                    }
                }
            }
            H(this.tbr);
            this.tbL = new n();
            this.tjx = (FavChatVoiceView) findViewById(R.id.cba);
            this.tjx.setVoiceHelper(this.tbL);
            a.a(this, this.tbr);
            aml c2 = b.c(this.tbr);
            String d2 = b.d(c2);
            int arN = b.arN(c2.LvC);
            if (!s.YS(d2)) {
                b.m(this.tbr);
            }
            this.tjx.I(d2, arN, m.J(this, (int) b.DO((long) c2.duration)).toString());
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(107278);
                    FavoriteVoiceDetailUI.this.finish();
                    AppMethodBeat.o(107278);
                    return true;
                }
            });
            addIconOptionMenu(0, R.string.hp_, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.AnonymousClass2 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(107283);
                    e eVar = new e((Context) FavoriteVoiceDetailUI.this.getContext(), 1, false);
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                            AppMethodBeat.i(107279);
                            mVar.d(0, FavoriteVoiceDetailUI.this.getString(R.string.c9s));
                            mVar.kV(2, R.string.cbv);
                            mVar.d(1, FavoriteVoiceDetailUI.this.getContext().getString(R.string.tf));
                            AppMethodBeat.o(107279);
                        }
                    };
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.AnonymousClass2.AnonymousClass2 */

                        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(107282);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    Intent intent = new Intent();
                                    intent.putExtra("key_fav_scene", 2);
                                    intent.putExtra("key_fav_item_id", FavoriteVoiceDetailUI.this.tbr.field_localId);
                                    b.b(FavoriteVoiceDetailUI.this.getContext(), ".ui.FavTagEditUI", intent);
                                    FavoriteVoiceDetailUI.this.thD.tau++;
                                    AppMethodBeat.o(107282);
                                    return;
                                case 1:
                                    h.a(FavoriteVoiceDetailUI.this.getContext(), FavoriteVoiceDetailUI.this.getString(R.string.th), "", new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.AnonymousClass2.AnonymousClass2.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(107281);
                                            final q a2 = h.a((Context) FavoriteVoiceDetailUI.this.getContext(), FavoriteVoiceDetailUI.this.getString(R.string.th), false, (DialogInterface.OnCancelListener) null);
                                            final long j2 = FavoriteVoiceDetailUI.this.tbr.field_localId;
                                            final long j3 = (long) FavoriteVoiceDetailUI.this.tbr.field_id;
                                            b.b(FavoriteVoiceDetailUI.this.tbr.field_localId, new Runnable() {
                                                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.AnonymousClass2.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(107280);
                                                    FavoriteVoiceDetailUI.this.thD.tav = true;
                                                    a2.dismiss();
                                                    Log.d("MicroMsg.FavoriteDetailUI", "do del fav voice, local id %d, fav id %d", Long.valueOf(j2), Long.valueOf(j3));
                                                    FavoriteVoiceDetailUI.this.finish();
                                                    AppMethodBeat.o(107280);
                                                }
                                            });
                                            AppMethodBeat.o(107281);
                                        }
                                    }, (DialogInterface.OnClickListener) null);
                                    AppMethodBeat.o(107282);
                                    return;
                                case 2:
                                    j.a(FavoriteVoiceDetailUI.this, FavoriteVoiceDetailUI.this.tiR, FavoriteVoiceDetailUI.this.thD);
                                    break;
                            }
                            AppMethodBeat.o(107282);
                        }
                    };
                    eVar.dGm();
                    AppMethodBeat.o(107283);
                    return true;
                }
            });
        }
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().add(this);
        AppMethodBeat.o(107284);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(107285);
        super.onDestroy();
        if (this.tjx != null) {
            this.tjx.stopPlay();
        }
        if (this.tbL != null) {
            this.tbL.destroy();
        }
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().remove(this);
        AppMethodBeat.o(107285);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(107286);
        super.onResume();
        AppMethodBeat.o(107286);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(107287);
        super.onPause();
        this.tbL.pause();
        AppMethodBeat.o(107287);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(107288);
        this.tbr = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.tiR);
        if (this.tbr == null) {
            Log.w("MicroMsg.FavoriteDetailUI", "on notify changed, get fav item info error");
            finish();
            AppMethodBeat.o(107288);
        } else if (this.tbr.field_itemStatus != 10) {
            AppMethodBeat.o(107288);
        } else if (mStorageEventData == null || mStorageEventData.stg == null) {
            AppMethodBeat.o(107288);
        } else {
            if (this.tbr.field_favProto.ppH.size() > 0) {
                aml c2 = b.c(this.tbr);
                String d2 = b.d(c2);
                int arN = b.arN(c2.LvC);
                Log.i("MicroMsg.FavoriteDetailUI", "on notify changed, favVoiceView.updateInfo");
                this.tjx.I(d2, arN, m.J(this, (int) b.DO((long) c2.duration)).toString());
            }
            AppMethodBeat.o(107288);
        }
    }
}
