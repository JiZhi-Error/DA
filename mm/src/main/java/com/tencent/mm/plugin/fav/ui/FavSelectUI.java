package com.tencent.mm.plugin.fav.ui;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.n.c;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.q;
import java.util.HashSet;
import java.util.Set;

public class FavSelectUI extends FavBaseUI {
    private View.OnClickListener dec = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.FavSelectUI.AnonymousClass5 */

        public final void onClick(View view) {
            AppMethodBeat.i(106876);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/fav/ui/FavSelectUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            int intValue = ((Integer) view.getTag()).intValue();
            Intent intent = new Intent();
            intent.putExtra("key_preset_search_type", intValue);
            intent.putExtra("key_to_user", FavSelectUI.this.toUser);
            intent.putExtra("key_fav_item_id", FavSelectUI.this.tfB);
            intent.putExtra("key_search_type", 1);
            intent.putExtra("key_enter_fav_search_from", 1);
            p.b(FavSelectUI.this.getContext(), FavSelectUI.this.tfC.thl, intent);
            a.a(this, "com/tencent/mm/plugin/fav/ui/FavSelectUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(106876);
        }
    };
    private String tfB;
    private com.tencent.mm.plugin.fav.ui.a.b tfC = null;
    private Set<Integer> tfD = new HashSet();
    private k tfE = new k();
    private String toUser;

    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavSelectUI() {
        AppMethodBeat.i(106877);
        AppMethodBeat.o(106877);
    }

    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(106878);
        super.onCreate(bundle);
        this.toUser = getIntent().getStringExtra("key_to_user");
        this.tfB = getIntent().getStringExtra("key_fav_item_id");
        if (this.tfB != null) {
            for (String str : this.tfB.split(",")) {
                int i2 = Util.getInt(str, Integer.MAX_VALUE);
                if (Integer.MAX_VALUE != i2) {
                    this.tfD.add(Integer.valueOf(i2));
                }
            }
        }
        this.tfD.remove(3);
        this.tfC.k(this.tfD);
        this.tfE.taE = false;
        this.tfE.taF = false;
        this.tfC.a(this.tfE);
        this.workerHandler.post(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.FavSelectUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(106870);
                FavSelectUI.this.tfC.cWm();
                FavSelectUI.this.cVE();
                AppMethodBeat.o(106870);
            }
        });
        addIconOptionMenu(0, R.raw.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavSelectUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(106871);
                FavSelectUI.a(FavSelectUI.this, new Intent());
                AppMethodBeat.o(106871);
                return true;
            }
        });
        setMMTitle(R.string.cc5);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavSelectUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(106872);
                FavSelectUI.this.finish();
                AppMethodBeat.o(106872);
                return true;
            }
        });
        AppMethodBeat.o(106878);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(106879);
        final b.C1049b bVar = (b.C1049b) view.getTag();
        if (bVar == null) {
            Log.w("MicroMsg.FavSelectUI", "on item click, holder is null");
            AppMethodBeat.o(106879);
        } else if (bVar.tbr == null) {
            Log.w("MicroMsg.FavSelectUI", "on item click, info is null");
            AppMethodBeat.o(106879);
        } else {
            g gVar = bVar.tbr;
            h.b(gVar.field_localId, 1, 1, (i2 - this.tdb.getHeaderViewsCount()) - 1);
            if (gVar.field_type == 19 && c.a(gVar.field_favProto.Lxf)) {
                com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.string.f3144a));
                AppMethodBeat.o(106879);
            } else if (gVar.field_type == 3) {
                com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.string.f3147d));
                AppMethodBeat.o(106879);
            } else if (gVar.field_type != 8 || !ab.IT(this.toUser)) {
                int i3 = R.string.c9h;
                if (gVar.field_type == 18) {
                    i3 = R.string.c9g;
                }
                long j3 = gVar.field_datatotalsize;
                Log.i("MicroMsg.FavSelectUI", "fav total size:%s", Long.valueOf(j3));
                if (j3 > c.aqu()) {
                    com.tencent.mm.ui.widget.snackbar.b.r(this, getString(i3, new Object[]{Util.getSizeKB(c.aqu())}));
                    AppMethodBeat.o(106879);
                    return;
                }
                ((com.tencent.mm.plugin.fav.a.ab) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ab.class)).a(getContext(), this.toUser, bVar.tbr, true, new y.a() {
                    /* class com.tencent.mm.plugin.fav.ui.FavSelectUI.AnonymousClass4 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                    public final void a(boolean z, String str, int i2) {
                        AppMethodBeat.i(106875);
                        FavSelectUI.this.hideVKB();
                        if (z) {
                            final q a2 = com.tencent.mm.ui.base.h.a((Context) FavSelectUI.this.getContext(), FavSelectUI.this.getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
                            l.a(FavSelectUI.this.getContext(), FavSelectUI.this.toUser, str, bVar.tbr, new Runnable() {
                                /* class com.tencent.mm.plugin.fav.ui.FavSelectUI.AnonymousClass4.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(106874);
                                    if (a2 != null) {
                                        a2.dismiss();
                                    }
                                    com.tencent.mm.ui.widget.snackbar.b.r(FavSelectUI.this, FavSelectUI.this.getString(R.string.c8o));
                                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                        /* class com.tencent.mm.plugin.fav.ui.FavSelectUI.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(106873);
                                            FavSelectUI.this.finish();
                                            AppMethodBeat.o(106873);
                                        }
                                    }, 1800);
                                    AppMethodBeat.o(106874);
                                }
                            });
                        }
                        AppMethodBeat.o(106875);
                    }
                });
                AppMethodBeat.o(106879);
            } else {
                com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.string.f3145b));
                AppMethodBeat.o(106879);
            }
        }
    }

    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI
    public final com.tencent.mm.plugin.fav.ui.a.a cVz() {
        AppMethodBeat.i(106880);
        if (this.tfC == null) {
            getContext();
            this.tfC = new com.tencent.mm.plugin.fav.ui.a.b(this.tdg, false);
        }
        com.tencent.mm.plugin.fav.ui.a.b bVar = this.tfC;
        AppMethodBeat.o(106880);
        return bVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI
    public final void cVA() {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI
    public final boolean cVB() {
        AppMethodBeat.i(106881);
        if (((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().getCount() > 0) {
            AppMethodBeat.o(106881);
            return true;
        }
        AppMethodBeat.o(106881);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI
    public final void cVC() {
        AppMethodBeat.i(106882);
        this.hSx.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.bd4, 0, 0);
        this.hSx.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 10));
        this.hSx.setText(R.string.c9v);
        AppMethodBeat.o(106882);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI
    public final View.OnClickListener cVD() {
        return this.dec;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(106883);
        if (i2 == 0 && -1 == i3) {
            finish();
            AppMethodBeat.o(106883);
            return;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(106883);
    }

    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(106884);
        super.onDestroy();
        if (this.tfC != null) {
            this.tfC.finish();
        }
        AppMethodBeat.o(106884);
    }

    static /* synthetic */ void a(FavSelectUI favSelectUI, Intent intent) {
        AppMethodBeat.i(106885);
        intent.putExtra("key_to_user", favSelectUI.toUser);
        intent.putExtra("key_fav_item_id", favSelectUI.tfB);
        intent.putExtra("key_search_type", 1);
        intent.putExtra("key_enter_fav_search_from", 1);
        Bundle bundle = null;
        if (Build.VERSION.SDK_INT >= 21 && !ao.isDarkMode()) {
            bundle = ActivityOptions.makeSceneTransitionAnimation(favSelectUI, new Pair[0]).toBundle();
        }
        com.tencent.mm.plugin.fav.a.b.a(favSelectUI.getContext(), ".ui.FavSearchUI", intent, 0, bundle);
        AppMethodBeat.o(106885);
    }
}
