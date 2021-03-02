package com.tencent.mm.plugin.fav.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.d;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.a.a;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.p;
import com.tencent.mm.plugin.fav.ui.widget.b;
import com.tencent.mm.plugin.fav.ui.widget.c;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.vfs.o;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteIndexUI extends FavBaseUI implements b.c, c.a {
    private l contextMenuHelper;
    private View.OnClickListener dec = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass4 */

        public final void onClick(View view) {
            AppMethodBeat.i(106996);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/fav/ui/FavoriteIndexUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            int intValue = ((Integer) view.getTag()).intValue();
            Intent intent = new Intent();
            intent.putExtra("key_enter_fav_search_from", 0);
            intent.putExtra("key_preset_search_type", intValue);
            p.b(FavoriteIndexUI.this.getContext(), FavoriteIndexUI.this.tgs.thl, intent);
            a.a(this, "com/tencent/mm/plugin/fav/ui/FavoriteIndexUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(106996);
        }
    };
    private long startTime = 0;
    private int[] tef = new int[2];
    private g teg;
    private g teh;
    private com.tencent.mm.plugin.fav.ui.widget.b tei;
    private AdapterView.OnItemLongClickListener tej = new AdapterView.OnItemLongClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass19 */

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(107018);
            if (i2 < FavoriteIndexUI.this.tdb.getHeaderViewsCount()) {
                Log.w("MicroMsg.FavoriteIndexUI", "on header view long click, ignore");
                AppMethodBeat.o(107018);
            } else {
                FavoriteIndexUI.a(FavoriteIndexUI.this, view, i2, j2, FavoriteIndexUI.this.tef);
                AppMethodBeat.o(107018);
            }
            return true;
        }
    };
    private int tgr = 0;
    private com.tencent.mm.plugin.fav.ui.a.b tgs;
    private int tgt = 0;
    private i tgu = new i() {
        /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass17 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(107016);
            Log.i("MicroMsg.FavoriteIndexUI", "onUsedCapacityChanged");
            FavoriteIndexUI.this.tde.post(new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass17.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(107015);
                    FavoriteIndexUI.this.tde.cWR();
                    AppMethodBeat.o(107015);
                }
            });
            AppMethodBeat.o(107016);
        }
    };

    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavoriteIndexUI() {
        AppMethodBeat.i(107024);
        AppMethodBeat.o(107024);
    }

    static /* synthetic */ void b(FavoriteIndexUI favoriteIndexUI) {
        AppMethodBeat.i(107048);
        favoriteIndexUI.cVM();
        AppMethodBeat.o(107048);
    }

    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(107025);
        this.tdh = this;
        Log.i("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex");
        super.onCreate(bundle);
        if (((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUP() == null) {
            Log.e("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex, but favorite db is null ,return");
            finish();
            AppMethodBeat.o(107025);
            return;
        }
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().mx(false);
        setMMTitle(R.string.c_s);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(106993);
                if (FavoriteIndexUI.this.tgs.thl) {
                    FavoriteIndexUI.b(FavoriteIndexUI.this);
                    AppMethodBeat.o(106993);
                } else {
                    FavoriteIndexUI.this.finish();
                    AppMethodBeat.o(106993);
                }
                return true;
            }
        });
        this.tdb.setOnItemLongClickListener(this.tej);
        this.tdb.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass12 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(107010);
                switch (motionEvent.getAction()) {
                    case 0:
                        FavoriteIndexUI.this.tef[0] = (int) motionEvent.getRawX();
                        FavoriteIndexUI.this.tef[1] = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(107010);
                return false;
            }
        });
        com.tencent.mm.kernel.g.azz().a(438, this.tgu);
        com.tencent.mm.kernel.g.azz().a(401, this.tgu);
        this.contextMenuHelper = new l(this);
        addIconOptionMenu(11, R.string.c8_, R.raw.actionbar_icon_dark_add, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(106995);
                FavoriteIndexUI.h(FavoriteIndexUI.this);
                AppMethodBeat.o(106995);
                return true;
            }
        });
        this.tei = new com.tencent.mm.plugin.fav.ui.widget.b();
        this.tei.dQ(findViewById(R.id.cbt));
        this.tei.tmy = new b.a() {
            /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.fav.ui.widget.b.a
            public final void cVS() {
                AppMethodBeat.i(106999);
                if (!FavoriteIndexUI.a(FavoriteIndexUI.this.tgs.mE(false), FavoriteIndexUI.this, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass5.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(106997);
                        FavoriteIndexUI.a(FavoriteIndexUI.this.getContext(), 4105, FavoriteIndexUI.this.tgs, FavoriteIndexUI.this.teh);
                        AppMethodBeat.o(106997);
                    }
                })) {
                    AppMethodBeat.o(106999);
                    return;
                }
                FavoriteIndexUI.a(FavoriteIndexUI.this.getContext(), 4105, FavoriteIndexUI.this.tgs, FavoriteIndexUI.this.teh);
                AppMethodBeat.o(106999);
            }

            @Override // com.tencent.mm.plugin.fav.ui.widget.b.a
            public final void cVF() {
                AppMethodBeat.i(107000);
                h.a(FavoriteIndexUI.this.getContext(), FavoriteIndexUI.this.getString(R.string.c96), "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass5.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(106998);
                        List<g> mE = FavoriteIndexUI.this.tgs.mE(true);
                        p.a(FavoriteIndexUI.this.getContext(), mE, (p.a) null);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11125, Integer.valueOf(mE.size()), 3);
                        if (FavoriteIndexUI.this.tgs.thl) {
                            FavoriteIndexUI.b(FavoriteIndexUI.this);
                        }
                        AppMethodBeat.o(106998);
                    }
                }, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(107000);
            }

            @Override // com.tencent.mm.plugin.fav.ui.widget.b.a
            public final void cVT() {
                AppMethodBeat.i(107001);
                if (FavoriteIndexUI.this.tgs.cWp() <= 0) {
                    AppMethodBeat.o(107001);
                } else if (FavoriteIndexUI.this.tgs.cWp() > 1) {
                    Intent intent = new Intent();
                    intent.putExtra("key_fav_scene", 3);
                    com.tencent.mm.plugin.fav.a.b.a(FavoriteIndexUI.this.getContext(), ".ui.FavTagEditUI", intent, 4104);
                    com.tencent.mm.plugin.fav.a.i.arT("FavTagEditUI");
                    AppMethodBeat.o(107001);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_fav_scene", 3);
                    intent2.putExtra("key_fav_item_id", FavoriteIndexUI.this.tgs.mE(false).get(0).field_localId);
                    com.tencent.mm.plugin.fav.a.b.b(FavoriteIndexUI.this.getContext(), ".ui.FavTagEditUI", intent2);
                    com.tencent.mm.plugin.fav.a.i.arT("FavTagEditUI");
                    if (FavoriteIndexUI.this.tgs.thl) {
                        FavoriteIndexUI.b(FavoriteIndexUI.this);
                    }
                    AppMethodBeat.o(107001);
                }
            }
        };
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass16 */

            public final void run() {
                AppMethodBeat.i(107014);
                long currentTimeMillis = System.currentTimeMillis();
                List<g> cUW = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUW();
                if (cUW != null) {
                    Log.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem getInvalid favitems , size = %d,start time = %s", Integer.valueOf(cUW.size()), Long.valueOf(currentTimeMillis));
                    if (cUW.size() == 0) {
                        AppMethodBeat.o(107014);
                        return;
                    }
                    int size = cUW.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().A(cUW.get(i2));
                    }
                    Log.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem  cost time = %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                AppMethodBeat.o(107014);
            }
        });
        d.cUs().a((d.a) null);
        e.cVJ();
        com.tencent.mm.plugin.fav.a.i.start();
        com.tencent.mm.pluginsdk.h.a((MMFragmentActivity) this, getContentView());
        AppMethodBeat.o(107025);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI
    public final void cVE() {
        AppMethodBeat.i(107026);
        super.cVE();
        this.hAk.post(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass18 */

            public final void run() {
                AppMethodBeat.i(107017);
                AppMethodBeat.o(107017);
            }
        });
        AppMethodBeat.o(107026);
    }

    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(107027);
        super.onDestroy();
        if (((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUP() == null) {
            AppMethodBeat.o(107027);
            return;
        }
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().mx(true);
        if (this.tgs != null) {
            this.tgs.finish();
        }
        oc ocVar = new oc();
        ocVar.dUe.type = 12;
        EventCenter.instance.publish(ocVar);
        com.tencent.mm.kernel.g.azz().b(438, this.tgu);
        com.tencent.mm.kernel.g.azz().b(401, this.tgu);
        com.tencent.mm.plugin.fav.a.i.end();
        e.cVI();
        AppMethodBeat.o(107027);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(107028);
        if (4 != i2 || !this.tgs.thl) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(107028);
            return onKeyUp;
        }
        cVM();
        AppMethodBeat.o(107028);
        return true;
    }

    private void cVM() {
        AppMethodBeat.i(107029);
        this.tgs.a(false, (g) null);
        this.tdb.setOnItemLongClickListener(this.tej);
        showOptionMenu(11, true);
        this.tei.hide();
        AppMethodBeat.o(107029);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(107030);
        switch (this.tgr) {
            case 0:
                if (this.tgs != null) {
                    this.tgs.onItemClick(adapterView, view, i2, j2);
                    b.C1049b bVar = (b.C1049b) view.getTag();
                    if (bVar != null) {
                        if (bVar.tbr != null) {
                            Log.i("MicroMsg.FavoriteIndexUI", "click type is %d", Integer.valueOf(bVar.tbr.field_type));
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12746, Integer.valueOf(bVar.tbr.field_type), 0, Integer.valueOf(i2 - 1));
                            break;
                        } else {
                            Log.w("MicroMsg.FavoriteIndexUI", "on item click, info is null..");
                            AppMethodBeat.o(107030);
                            return;
                        }
                    } else {
                        Log.w("MicroMsg.FavoriteIndexUI", "on item click, holder is null..");
                        AppMethodBeat.o(107030);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(107030);
    }

    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI
    public final com.tencent.mm.plugin.fav.ui.a.a cVz() {
        AppMethodBeat.i(107031);
        if (this.tgs == null) {
            getContext();
            this.tgs = new com.tencent.mm.plugin.fav.ui.a.b(this.tdg, false);
            this.tgs.a(new a.AbstractC1046a() {
                /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass22 */

                @Override // com.tencent.mm.plugin.fav.ui.a.a.AbstractC1046a
                public final void cWe() {
                    AppMethodBeat.i(107022);
                    FavoriteIndexUI.this.tde.mJ(true);
                    AppMethodBeat.o(107022);
                }
            });
            this.tgs.ths = this;
            this.tgs.scene = 1;
            this.tgs.thv = this.tdb;
        }
        com.tencent.mm.plugin.fav.ui.a.b bVar = this.tgs;
        AppMethodBeat.o(107031);
        return bVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI
    public final void cVA() {
        AppMethodBeat.i(107032);
        this.tde.post(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass23 */

            public final void run() {
                AppMethodBeat.i(107023);
                FavoriteIndexUI.this.tde.cWR();
                AppMethodBeat.o(107023);
            }
        });
        AppMethodBeat.o(107032);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI
    public final boolean cVB() {
        int cUQ;
        AppMethodBeat.i(107033);
        switch (this.tgr) {
            case 3:
                cUQ = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUQ();
                break;
            default:
                cUQ = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().getCount();
                break;
        }
        if (cUQ > 0) {
            AppMethodBeat.o(107033);
            return true;
        }
        AppMethodBeat.o(107033);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI
    @SuppressLint({"ResourceType"})
    public final void cVC() {
        AppMethodBeat.i(107034);
        switch (this.tgr) {
            case 3:
                this.hSx.setCompoundDrawablesWithIntrinsicBounds(0, R.raw.fav_list_img_default, 0, 0);
                this.hSx.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 10));
                this.hSx.setText(R.string.c9w);
                AppMethodBeat.o(107034);
                return;
            default:
                this.hSx.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.bd4, 0, 0);
                this.hSx.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 10));
                this.hSx.setText(R.string.c9v);
                AppMethodBeat.o(107034);
                return;
        }
    }

    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(107035);
        long currentTimeMillis = System.currentTimeMillis();
        super.onResume();
        this.hAk.post(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(106994);
                if (FavoriteIndexUI.this.tde != null) {
                    FavoriteIndexUI.this.tde.cWR();
                }
                AppMethodBeat.o(106994);
            }
        });
        Log.d("MicroMsg.FavoriteIndexUI", "on resume use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        com.tencent.mm.plugin.fav.a.i.arT(getClass().getSimpleName());
        AppMethodBeat.o(107035);
    }

    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(107036);
        super.onPause();
        com.tencent.mm.plugin.fav.a.i.arU(getClass().getSimpleName());
        AppMethodBeat.o(107036);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI
    public final View.OnClickListener cVD() {
        return this.dec;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fav.ui.FavBaseUI
    public final void initHeaderView() {
        AppMethodBeat.i(107037);
        super.initHeaderView();
        this.tde.mJ(false);
        AppMethodBeat.o(107037);
    }

    private void f(List<g> list, String str, String str2) {
        AppMethodBeat.i(107038);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(107038);
        } else if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(107038);
        } else {
            boolean Eq = ab.Eq(str2);
            k kVar = new k();
            LinkedList<g> linkedList = new LinkedList();
            for (g gVar : list) {
                if (!kVar.u(gVar)) {
                    com.tencent.mm.plugin.fav.a.h.b(gVar.field_localId, 1, 0, this.tgt);
                    linkedList.add(gVar);
                    m.a(Eq ? m.c.Chatroom : m.c.Chat, gVar, m.d.Samll, Eq ? v.Ie(str2) : 0);
                }
            }
            if (linkedList.isEmpty()) {
                Log.i("MicroMsg.FavoriteIndexUI", "after filter, nothing");
                h.cD(getApplicationContext(), getString(R.string.cbu));
                AppMethodBeat.o(107038);
                return;
            }
            final com.tencent.mm.ui.base.q a2 = h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
            l.a(getContext(), str2, str, linkedList, new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(107005);
                    a2.dismiss();
                    com.tencent.mm.ui.widget.snackbar.b.r(FavoriteIndexUI.this, FavoriteIndexUI.this.getString(R.string.c8o));
                    AppMethodBeat.o(107005);
                }
            });
            LinkedList linkedList2 = new LinkedList();
            for (g gVar2 : linkedList) {
                if (gVar2 != null && gVar2.field_type == 5) {
                    String str3 = "";
                    if (gVar2.field_favProto.LwS != null) {
                        str3 = gVar2.field_favProto.LwS.LyC;
                    }
                    if (gVar2.field_favProto.Lya != null && Util.isNullOrNil(str3)) {
                        str3 = gVar2.field_favProto.Lya.link;
                    }
                    if (!Util.isNullOrNil(str3)) {
                        Log.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", 13378, str3, Long.valueOf(this.startTime), 4, 1, 1);
                        String str4 = "";
                        try {
                            str4 = URLEncoder.encode(str3, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                        } catch (UnsupportedEncodingException e2) {
                            Log.printErrStackTrace("MicroMsg.FavoriteIndexUI", e2, "", new Object[0]);
                        }
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13378, str4, Long.valueOf(this.startTime), 4, 1, 1);
                    }
                } else if (gVar2 != null && gVar2.field_type == 20) {
                    bcj bcj = gVar2.field_favProto.Lxk;
                    linkedList2.add(new Pair(bcj.objectId, bcj.objectNonceId));
                }
            }
            if (linkedList2.size() > 0) {
                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).shareStatsReport(linkedList2, false);
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11125, Integer.valueOf(linkedList.size()), 1);
            AppMethodBeat.o(107038);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(107039);
        super.onConfigurationChanged(configuration);
        com.tencent.mm.pluginsdk.h.a((MMFragmentActivity) this, getContentView());
        AppMethodBeat.o(107039);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        String str;
        AppMethodBeat.i(107040);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 4105:
            case 4106:
                com.tencent.mm.plugin.fav.a.i.arU(".ui.transmit.SelectConversationUI");
                break;
        }
        Log.i("MicroMsg.FavoriteIndexUI", "onActivityResult reqCode: %d, retCod: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != -1) {
            if ((this.teh != null && this.teh.field_type == 5) || (this.teg != null && this.teg.field_type == 5)) {
                String str2 = "";
                if (this.teg == null || this.teg.field_favProto.Lya == null) {
                    if (this.teh.field_favProto.LwS != null) {
                        str2 = this.teh.field_favProto.LwS.LyC;
                    }
                    if (this.teh.field_favProto.Lya != null && Util.isNullOrNil(str2)) {
                        str2 = this.teh.field_favProto.Lya.link;
                    }
                } else {
                    str2 = this.teg.field_favProto.Lya.link;
                }
                if (!Util.isNullOrNil(str2)) {
                    Log.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", 13378, str2, Long.valueOf(this.startTime), 4, 1, 3);
                    try {
                        str = URLEncoder.encode(str2, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    } catch (UnsupportedEncodingException e2) {
                        Log.printErrStackTrace("MicroMsg.FavoriteIndexUI", e2, "", new Object[0]);
                        str = "";
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13378, str, Long.valueOf(this.startTime), 4, 1, 3);
                }
            }
            AppMethodBeat.o(107040);
            return;
        }
        char c2 = 2;
        String stringExtra = intent.getStringExtra("custom_send_text");
        switch (i2) {
            case 4096:
                final ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                    c2 = 0;
                    this.workerHandler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass9 */

                        public final void run() {
                            AppMethodBeat.i(107007);
                            FavoriteIndexUI.this.tcY = true;
                            k.dI(stringArrayListExtra);
                            AppMethodBeat.o(107007);
                        }
                    });
                    break;
                } else {
                    Log.e("MicroMsg.FavoriteIndexUI", "onActivityResult pathList is null or nil");
                    AppMethodBeat.o(107040);
                    return;
                }
                break;
            case 4097:
                final double doubleExtra = intent.getDoubleExtra("kwebmap_slat", 0.0d);
                final double doubleExtra2 = intent.getDoubleExtra("kwebmap_lng", 0.0d);
                final int intExtra = intent.getIntExtra("kwebmap_scale", 0);
                final String nullAs = Util.nullAs(intent.getStringExtra("Kwebmap_locaion"), "");
                final CharSequence charSequenceExtra = intent.getCharSequenceExtra("kRemark");
                final String stringExtra2 = intent.getStringExtra("kPoiName");
                final ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("kTags");
                this.workerHandler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass10 */

                    public final void run() {
                        AppMethodBeat.i(107008);
                        FavoriteIndexUI.this.tcY = true;
                        double d2 = doubleExtra;
                        double d3 = doubleExtra2;
                        int i2 = intExtra;
                        String str = nullAs;
                        CharSequence charSequence = charSequenceExtra;
                        String str2 = stringExtra2;
                        ArrayList<String> arrayList = stringArrayListExtra2;
                        ams ams = new ams();
                        ams.bgW(str);
                        ams.C(d2);
                        ams.B(d3);
                        ams.aji(i2);
                        ams.bgX(str2);
                        g gVar = new g();
                        gVar.field_type = 6;
                        gVar.field_sourceType = 6;
                        gVar.field_favProto.d(ams);
                        if (charSequence != null && !Util.isNullOrNil(charSequence.toString())) {
                            gVar.field_favProto.bhc(charSequence.toString());
                            gVar.field_favProto.My(Util.nowMilliSecond());
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10873, 6);
                        }
                        k.G(gVar);
                        if (arrayList != null && !arrayList.isEmpty()) {
                            for (String str3 : arrayList) {
                                gVar.arS(str3);
                            }
                        }
                        b.C(gVar);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10648, 3, 0);
                        com.tencent.mm.plugin.fav.a.b.DN(gVar.field_localId);
                        long j2 = gVar.field_localId;
                        g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(j2);
                        if (!(DY == null || DY.field_favProto.LwQ == null)) {
                            com.tencent.mm.plugin.fav.a.b.a(j2, DY.field_favProto.LwQ, "", "", new ArrayList(), FavoriteIndexUI.this.getContext());
                        }
                        AppMethodBeat.o(107008);
                    }
                });
                c2 = 0;
                break;
            case 4098:
                String h2 = s.h(getApplicationContext(), intent, com.tencent.mm.plugin.image.d.aSY());
                if (h2 != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 4);
                    intent2.putExtra("CropImage_Filter", true);
                    intent2.putExtra("CropImage_ImgPath", h2);
                    intent2.setClassName(getContext(), "com.tencent.mm.ui.tools.CropImageNewUI");
                    startActivityForResult(intent2, 4099);
                    break;
                } else {
                    Log.w("MicroMsg.FavoriteIndexUI", "take picture result path is null");
                    AppMethodBeat.o(107040);
                    return;
                }
            case 4099:
                String stringExtra3 = intent.getStringExtra("CropImage_OutputPath");
                if (stringExtra3 != null) {
                    c2 = 0;
                    final ArrayList arrayList = new ArrayList();
                    arrayList.add(stringExtra3);
                    this.workerHandler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass8 */

                        public final void run() {
                            AppMethodBeat.i(107006);
                            FavoriteIndexUI.this.tcY = true;
                            k.dI(arrayList);
                            AppMethodBeat.o(107006);
                        }
                    });
                    break;
                } else {
                    Log.w("MicroMsg.FavoriteIndexUI", "crop picture resutl path is null");
                    AppMethodBeat.o(107040);
                    return;
                }
            case 4100:
                String stringExtra4 = intent.getStringExtra("choosed_file_path");
                if (!Util.isNullOrNil(stringExtra4)) {
                    o oVar = new o(stringExtra4);
                    if (oVar.exists()) {
                        if (oVar.length() < ((long) ((af) com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimit(true))) {
                            if (Util.isNullOrNil(stringExtra4)) {
                                z = false;
                            } else {
                                o oVar2 = new o(stringExtra4);
                                if (!oVar2.exists()) {
                                    z = false;
                                } else {
                                    g gVar = new g();
                                    gVar.field_type = 8;
                                    gVar.field_sourceType = 6;
                                    k.G(gVar);
                                    gVar.field_favProto.bhd(oVar2.getName());
                                    aml aml = new aml();
                                    aml.bgt(stringExtra4);
                                    aml.At(true);
                                    aml.bgf(oVar2.getName());
                                    aml.ajd(gVar.field_type);
                                    aml.bgp(com.tencent.mm.vfs.s.akC(stringExtra4));
                                    gVar.field_favProto.ppH.add(aml);
                                    b.C(gVar);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10648, 5, 0);
                                    z = true;
                                }
                            }
                            if (!z) {
                                c2 = 1;
                                break;
                            } else {
                                c2 = 0;
                                this.tcY = true;
                                break;
                            }
                        } else {
                            c2 = 4;
                            break;
                        }
                    } else {
                        c2 = 1;
                        break;
                    }
                } else {
                    c2 = 1;
                    break;
                }
            case 4101:
            case 4102:
                c2 = 0;
                this.tcY = true;
                break;
            case 4103:
                long longExtra = intent.getLongExtra("key_fav_result_local_id", -1);
                if (-1 == longExtra) {
                    AppMethodBeat.o(107040);
                    return;
                }
                int p = this.tgs.p(longExtra, "");
                if (-1 == p) {
                    AppMethodBeat.o(107040);
                    return;
                }
                this.tdb.removeFooterView(this.tdc);
                this.tdb.setSelection(p);
                AppMethodBeat.o(107040);
                return;
            case 4104:
                final List<g> mE = this.tgs.mE(false);
                final String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
                if (!mE.isEmpty() && stringArrayExtra != null && stringArrayExtra.length > 0) {
                    final com.tencent.mm.ui.base.q a2 = h.a((Context) getContext(), "", false, (DialogInterface.OnCancelListener) null);
                    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass6 */

                        public final void run() {
                            AppMethodBeat.i(107004);
                            FavoriteIndexUI.b(mE, stringArrayExtra);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass6.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(107002);
                                    a2.dismiss();
                                    AppMethodBeat.o(107002);
                                }

                                public final String toString() {
                                    AppMethodBeat.i(107003);
                                    String str = super.toString() + "|batchAddFavTags";
                                    AppMethodBeat.o(107003);
                                    return str;
                                }
                            });
                            AppMethodBeat.o(107004);
                        }
                    });
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11125, Integer.valueOf(stringArrayExtra.length), 2);
                    break;
                }
            case 4105:
                String stringExtra5 = intent.getStringExtra("Select_Conv_User");
                Log.d("MicroMsg.FavoriteIndexUI", "select %s for sending", stringExtra5);
                f(this.tgs.mE(false), stringExtra, stringExtra5);
                break;
            case 4106:
                String stringExtra6 = intent.getStringExtra("Select_Conv_User");
                Log.d("MicroMsg.FavoriteIndexUI", "select %s for sending", stringExtra6);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.teh);
                f(arrayList2, stringExtra, stringExtra6);
                break;
        }
        if (c2 == 0) {
            h.cD(getContext(), getString(R.string.caf));
            AppMethodBeat.o(107040);
        } else if (1 == c2) {
            h.cD(getContext(), getString(R.string.c_1));
            AppMethodBeat.o(107040);
        } else if (3 == c2) {
            Toast.makeText(getContext(), getString(R.string.ccv), 1).show();
            AppMethodBeat.o(107040);
        } else if (4 == c2) {
            Toast.makeText(getContext(), getString(R.string.ccw, new Object[]{Integer.valueOf(((af) com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimitInMB(true))}), 1).show();
            AppMethodBeat.o(107040);
        } else {
            if (this.tgs.thl) {
                cVM();
            }
            AppMethodBeat.o(107040);
        }
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b.c
    public final void Ec(long j2) {
        AppMethodBeat.i(107041);
        if (this.tgs.thl) {
            this.tei.gf(this.tgs.cWp() > 0);
        }
        AppMethodBeat.o(107041);
    }

    @Override // com.tencent.mm.ui.MMActivity
    @SuppressLint({"ResourceType"})
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(107042);
        MenuItem add = menu.add(0, 10, 0, R.string.hpa);
        add.setIcon(ar.m(getContext(), R.raw.actionbar_icon_dark_search, getResources().getColor(R.color.FG_0)));
        add.setShowAsAction(2);
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        AppMethodBeat.o(107042);
        return onCreateOptionsMenu;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        AppMethodBeat.i(107043);
        if (menuItem.getItemId() == 10) {
            Intent intent = new Intent();
            intent.putExtra("key_enter_fav_search_from", 0);
            p.a(getContext(), this.tgs.thl, intent);
            AppMethodBeat.o(107043);
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        AppMethodBeat.o(107043);
        return onOptionsItemSelected;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(107044);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(107044);
            return;
        }
        Log.i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                if (iArr[0] == 0) {
                    com.tencent.mm.plugin.fav.a.b.a(this, ".ui.FavPostVoiceUI", new Intent(), 4102);
                    BackwardSupportUtil.AnimationHelper.overridePendingTransition(this, 0, 0);
                    AppMethodBeat.o(107044);
                    return;
                }
                h.a((Context) this, getString(R.string.flb), "", getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass11 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(107009);
                        dialogInterface.dismiss();
                        FavoriteIndexUI favoriteIndexUI = FavoriteIndexUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        com.tencent.mm.hellhoundlib.a.a.a(favoriteIndexUI, bl.axQ(), "com/tencent/mm/plugin/fav/ui/FavoriteIndexUI$19", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        favoriteIndexUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(favoriteIndexUI, "com/tencent/mm/plugin/fav/ui/FavoriteIndexUI$19", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(107009);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass13 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(107011);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(107011);
                    }
                });
                AppMethodBeat.o(107044);
                return;
            case 64:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.fl_), "", getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass14 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(107012);
                            dialogInterface.dismiss();
                            FavoriteIndexUI favoriteIndexUI = FavoriteIndexUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(favoriteIndexUI, bl.axQ(), "com/tencent/mm/plugin/fav/ui/FavoriteIndexUI$21", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            favoriteIndexUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(favoriteIndexUI, "com/tencent/mm/plugin/fav/ui/FavoriteIndexUI$21", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(107012);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass15 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(107013);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(107013);
                        }
                    });
                    break;
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
                    intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.br);
                    intent.putExtra("map_view_type", 3);
                    com.tencent.mm.br.c.b(this, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent, 4097);
                    AppMethodBeat.o(107044);
                    return;
                }
        }
        AppMethodBeat.o(107044);
    }

    @Override // com.tencent.mm.plugin.fav.ui.widget.c.a
    public final void cWd() {
        AppMethodBeat.i(107045);
        Intent intent = new Intent();
        intent.putExtra("key_enter_fav_cleanui_from", 0);
        com.tencent.mm.plugin.fav.a.b.b(getContext(), ".ui.FavCleanUI", intent);
        AppMethodBeat.o(107045);
    }

    public static void b(List<g> list, String[] strArr) {
        AppMethodBeat.i(107046);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(107046);
        } else if (strArr == null || strArr.length <= 0) {
            AppMethodBeat.o(107046);
        } else {
            LinkedList<g> linkedList = new LinkedList();
            for (g gVar : list) {
                boolean z = false;
                for (String str : strArr) {
                    z |= gVar.arS(str);
                }
                if (z) {
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(gVar, ch.COL_LOCALID);
                    com.tencent.mm.plugin.fav.a.b.p(gVar);
                    linkedList.add(gVar);
                }
            }
            for (g gVar2 : linkedList) {
                com.tencent.mm.plugin.fav.a.b.a(gVar2, 3);
            }
            AppMethodBeat.o(107046);
        }
    }

    public static boolean a(List<g> list, Context context, DialogInterface.OnClickListener onClickListener) {
        int i2;
        AppMethodBeat.i(107047);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(107047);
            return true;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        new k();
        boolean z = false;
        int i7 = 0;
        for (g gVar : list) {
            if (!(gVar == null || gVar.field_favProto == null || gVar.field_favProto.ppH == null)) {
                if (gVar.field_type == 3) {
                    i5++;
                } else if (gVar.field_type != 19 || !c.a(gVar.field_favProto.Lxf)) {
                    Iterator<aml> it = gVar.field_favProto.ppH.iterator();
                    int i8 = 0;
                    while (it.hasNext()) {
                        aml next = it.next();
                        if (next.Lwv == 2) {
                            i3++;
                        } else if (next.Lwv == 1) {
                            i4++;
                        } else {
                            i8++;
                        }
                    }
                    if (k.v(gVar)) {
                        i2 = i6 + 1;
                        if (i8 > 0) {
                            i8--;
                        }
                    } else {
                        i2 = i6;
                    }
                    if (!z && i8 == gVar.field_favProto.ppH.size()) {
                        z = true;
                    }
                    z = z;
                    i6 = i2;
                } else {
                    i7++;
                }
            }
        }
        if (1 == list.size()) {
            if (list.get(0).field_type == 14 && (i3 > 0 || i4 > 0)) {
                h.cD(context, context.getString(R.string.c9i));
                AppMethodBeat.o(107047);
                return false;
            } else if (i3 > 0) {
                h.cD(context, context.getString(R.string.c9j, Integer.valueOf(((af) com.tencent.mm.kernel.g.ah(af.class)).getFavSizeLimitInMB(true, list.get(0).field_type))));
                AppMethodBeat.o(107047);
                return false;
            } else if (i4 > 0) {
                switch (list.get(0).field_type) {
                    case 2:
                        h.cD(context, context.getString(R.string.c9l));
                        break;
                    case 4:
                    case 16:
                        h.cD(context, context.getString(R.string.c9m));
                        break;
                    case 8:
                        h.cD(context, context.getString(R.string.c9k));
                        break;
                }
                AppMethodBeat.o(107047);
                return false;
            } else if (i6 > 0) {
                h.cD(context, context.getString(R.string.f3146c));
                AppMethodBeat.o(107047);
                return false;
            } else if (i5 > 0) {
                h.cD(context, context.getString(R.string.f3147d));
                AppMethodBeat.o(107047);
                return false;
            } else if (i7 > 0) {
                h.cD(context, context.getString(R.string.f3144a));
                AppMethodBeat.o(107047);
                return false;
            }
        } else if (i3 > 0 || i4 > 0 || i6 > 0 || i5 > 0 || i7 > 0) {
            if (z) {
                h.a(context, context.getString(R.string.c9o), "", context.getString(R.string.b98), context.getString(R.string.b96), onClickListener, (DialogInterface.OnClickListener) null, (int) R.color.afp);
            } else {
                h.cD(context, context.getString(R.string.c9n));
            }
            AppMethodBeat.o(107047);
            return false;
        }
        AppMethodBeat.o(107047);
        return true;
    }

    static /* synthetic */ void a(FavoriteIndexUI favoriteIndexUI, View view, final int i2, long j2, int[] iArr) {
        AppMethodBeat.i(107049);
        new com.tencent.mm.ui.widget.b.a(favoriteIndexUI.getContext(), view).a(view, i2, j2, new View.OnCreateContextMenuListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass20 */

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(107019);
                k kVar = new k();
                g Id = FavoriteIndexUI.this.tgs.Id((i2 - FavoriteIndexUI.this.tdb.getHeaderViewsCount()) - 1);
                boolean u = kVar.u(Id);
                if (!u) {
                    contextMenu.add(0, 3, 0, R.string.cbt);
                }
                if (u && com.tencent.mm.plugin.fav.a.b.g(Id)) {
                    contextMenu.add(0, 3, 0, R.string.cbt);
                }
                if (Id.field_type == 8) {
                    aml c2 = com.tencent.mm.plugin.fav.a.b.c(Id);
                    if (com.tencent.mm.plugin.fav.a.b.g(c2) && !com.tencent.mm.plugin.fav.a.b.h(c2)) {
                        contextMenu.add(0, 4, 0, R.string.cai);
                    }
                }
                contextMenu.add(0, 2, 0, R.string.c9s);
                contextMenu.add(0, 0, 0, R.string.c94);
                contextMenu.add(0, 1, 0, R.string.ca8);
                AppMethodBeat.o(107019);
            }
        }, new o.g() {
            /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass21 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(107021);
                switch (FavoriteIndexUI.this.tgr) {
                    case 0:
                        if (menuItem == null) {
                            AppMethodBeat.o(107021);
                            return;
                        }
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (i2 < FavoriteIndexUI.this.tdb.getHeaderViewsCount()) {
                                    AppMethodBeat.o(107021);
                                    return;
                                }
                                Log.i("MicroMsg.FavoriteIndexUI", "do delete, long click info is %s", Integer.valueOf(i2));
                                com.tencent.mm.plugin.fav.a.b.a(FavoriteIndexUI.this.tgs.Id((i2 - FavoriteIndexUI.this.tdb.getHeaderViewsCount()) - 1), (Runnable) null);
                                AppMethodBeat.o(107021);
                                return;
                            case 1:
                                FavoriteIndexUI.this.startTime = Util.nowSecond();
                                Log.i("MicroMsg.FavoriteIndexUI", "do edit, long click info is %s", Integer.valueOf(i2));
                                FavoriteIndexUI.this.teg = FavoriteIndexUI.this.tgs.Id((i2 - FavoriteIndexUI.this.tdb.getHeaderViewsCount()) - 1);
                                FavoriteIndexUI.b(FavoriteIndexUI.this, FavoriteIndexUI.this.teg);
                                AppMethodBeat.o(107021);
                                return;
                            case 2:
                                Log.i("MicroMsg.FavoriteIndexUI", "do tag, long click info is %s", Integer.valueOf(i2));
                                g Id = FavoriteIndexUI.this.tgs.Id((i2 - FavoriteIndexUI.this.tdb.getHeaderViewsCount()) - 1);
                                Intent intent = new Intent();
                                intent.putExtra("key_fav_scene", 4);
                                intent.putExtra("key_fav_item_id", Id.field_localId);
                                com.tencent.mm.plugin.fav.a.b.b(FavoriteIndexUI.this.getContext(), ".ui.FavTagEditUI", intent);
                                com.tencent.mm.plugin.fav.a.i.arT("FavTagEditUI");
                                AppMethodBeat.o(107021);
                                return;
                            case 3:
                                FavoriteIndexUI.this.startTime = Util.nowSecond();
                                Log.i("MicroMsg.FavoriteIndexUI", "do transmit, long click info is %s", Integer.valueOf(i2));
                                FavoriteIndexUI.this.tgt = (i2 - FavoriteIndexUI.this.tdb.getHeaderViewsCount()) - 1;
                                FavoriteIndexUI.this.teh = FavoriteIndexUI.this.tgs.Id(FavoriteIndexUI.this.tgt);
                                FavoriteIndexUI.this.teh = FavoriteIndexUI.this.teh.cUC();
                                if (FavoriteIndexUI.this.teh == null) {
                                    AppMethodBeat.o(107021);
                                    return;
                                }
                                LinkedList linkedList = new LinkedList();
                                linkedList.add(FavoriteIndexUI.this.teh);
                                if (!FavoriteIndexUI.a(linkedList, FavoriteIndexUI.this, new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.AnonymousClass21.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(107020);
                                        FavoriteIndexUI.a(FavoriteIndexUI.this.getContext(), 4106, FavoriteIndexUI.this.tgs, FavoriteIndexUI.this.teh);
                                        AppMethodBeat.o(107020);
                                    }
                                })) {
                                    AppMethodBeat.o(107021);
                                    return;
                                }
                                FavoriteIndexUI.a(FavoriteIndexUI.this.getContext(), 4106, FavoriteIndexUI.this.tgs, FavoriteIndexUI.this.teh);
                                AppMethodBeat.o(107021);
                                return;
                            case 4:
                                g Id2 = FavoriteIndexUI.this.tgs.Id((i2 - FavoriteIndexUI.this.tdb.getHeaderViewsCount()) - 1);
                                and and = new and();
                                and.ecL = 1;
                                ((y) com.tencent.mm.kernel.g.af(y.class)).a(FavoriteIndexUI.this.getContext(), Id2, and);
                                break;
                        }
                        AppMethodBeat.o(107021);
                        return;
                    default:
                        AppMethodBeat.o(107021);
                        return;
                }
            }
        }, iArr[0], iArr[1]);
        AppMethodBeat.o(107049);
    }

    static /* synthetic */ void b(FavoriteIndexUI favoriteIndexUI, g gVar) {
        AppMethodBeat.i(107050);
        favoriteIndexUI.tgs.a(true, gVar);
        favoriteIndexUI.tdb.setOnItemLongClickListener(null);
        favoriteIndexUI.showOptionMenu(11, false);
        favoriteIndexUI.tei.mI(false);
        AppMethodBeat.o(107050);
    }

    static /* synthetic */ void a(Context context, int i2, com.tencent.mm.plugin.fav.ui.a.b bVar, g gVar) {
        boolean z;
        AppMethodBeat.i(235323);
        long j2 = 0;
        String str = "";
        int i3 = R.string.c9f;
        if (4105 == i2) {
            if (bVar != null) {
                j2 = bVar.cWq();
            }
            str = "fav_multi_send,";
        } else if (4106 == i2) {
            if (gVar != null) {
                j2 = gVar.field_datatotalsize;
            }
            if (gVar.field_type == 18) {
                i3 = R.string.c9g;
            } else {
                i3 = R.string.c9h;
            }
            str = "fav_trans_send,";
        }
        Log.i("MicroMsg.FavoriteMenuHelper", "%s totalSize:%s", str, Long.valueOf(j2));
        if (j2 > com.tencent.mm.n.c.aqu()) {
            h.cD(context, context.getString(i3, Util.getSizeKB(com.tencent.mm.n.c.aqu())));
            z = true;
        } else {
            z = false;
        }
        if (!z && p.b(context, i2, bVar, gVar)) {
            com.tencent.mm.plugin.fav.a.i.arT(".ui.transmit.SelectConversationUI");
        }
        AppMethodBeat.o(235323);
    }

    static /* synthetic */ void h(FavoriteIndexUI favoriteIndexUI) {
        AppMethodBeat.i(235324);
        long currentTimeMillis = System.currentTimeMillis();
        oc ocVar = new oc();
        ocVar.dUe.field_localId = currentTimeMillis;
        ocVar.dUe.context = favoriteIndexUI.getContext();
        ocVar.dUe.type = 9;
        EventCenter.instance.publish(ocVar);
        od odVar = new od();
        odVar.dUq.context = favoriteIndexUI.getContext();
        odVar.dUq.type = 3;
        odVar.dUq.dUm = 1;
        EventCenter.instance.publish(odVar);
        AppMethodBeat.o(235324);
    }
}
