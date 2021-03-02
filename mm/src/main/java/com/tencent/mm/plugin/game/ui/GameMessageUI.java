package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public class GameMessageUI extends GameCenterActivity implements AdapterView.OnItemClickListener, i {
    private int gog = 0;
    private int gwE;
    private TextView jZO;
    private AbsListView.OnScrollListener xPk = new AbsListView.OnScrollListener() {
        /* class com.tencent.mm.plugin.game.ui.GameMessageUI.AnonymousClass4 */

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(42300);
            if (i2 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !GameMessageUI.this.xUZ.cwg()) {
                GameMessageUI.this.xUZ.dWt();
                GameMessageUI.this.xUZ.onNotifyChange(null, null);
            }
            AppMethodBeat.o(42300);
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }
    };
    private ListView xUY;
    private n xUZ;
    private View xVa;
    private int xVb = 1;
    private boolean xVc = false;
    private boolean xVd = false;
    private String xVe = "";
    private long xVf;
    private DialogInterface.OnClickListener xVg;
    private DialogInterface.OnClickListener xVh;

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameMessageUI() {
        AppMethodBeat.i(42302);
        AppMethodBeat.o(42302);
    }

    static /* synthetic */ void a(GameMessageUI gameMessageUI) {
        AppMethodBeat.i(42312);
        gameMessageUI.goBack();
        AppMethodBeat.o(42312);
    }

    static /* synthetic */ void a(GameMessageUI gameMessageUI, int i2) {
        AppMethodBeat.i(42313);
        gameMessageUI.OA(i2);
        AppMethodBeat.o(42313);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42303);
        super.onCreate(bundle);
        g.azz().a(573, this);
        this.gog = getIntent().getIntExtra("game_unread_msg_count", 0);
        this.xVe = getIntent().getStringExtra("game_manage_url");
        this.xVf = getIntent().getLongExtra("game_msg_ui_from_msgid", 0);
        Log.i("MicroMsg.GameMessageUI", "init msgId:%d", Long.valueOf(this.xVf));
        initView();
        ((e) g.af(e.class)).dSJ();
        r.dVt();
        AppMethodBeat.o(42303);
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(42304);
        super.onResume();
        this.xUZ.notifyDataSetChanged();
        if (this.xVd && this.xVa != null) {
            this.xUY.removeHeaderView(this.xVa);
        }
        AppMethodBeat.o(42304);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(42305);
        setMMTitle(R.string.dqv);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.GameMessageUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42296);
                GameMessageUI.a(GameMessageUI.this);
                AppMethodBeat.o(42296);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.t2), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.GameMessageUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42298);
                GameMessageUI.this.xVg = new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.game.ui.GameMessageUI.AnonymousClass2.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(42297);
                        ((f) g.af(f.class)).dSK().dVA();
                        GameMessageUI.this.xUZ.anq();
                        GameMessageUI.this.xUZ.notifyDataSetChanged();
                        AppMethodBeat.o(42297);
                    }
                };
                GameMessageUI.this.xVh = new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.game.ui.GameMessageUI.AnonymousClass2.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                };
                h.a(GameMessageUI.this.getContext(), (int) R.string.dny, 0, GameMessageUI.this.xVg, GameMessageUI.this.xVh);
                AppMethodBeat.o(42298);
                return false;
            }
        });
        this.gwE = getIntent().getIntExtra("game_report_from_scene", 0);
        this.xUY = (ListView) findViewById(R.id.dhs);
        this.xUY.setOnItemClickListener(this);
        if (this.gog > 20) {
            if (com.tencent.mm.plugin.game.model.e.gc(this)) {
                this.xVa = View.inflate(this, R.layout.ary, null);
                this.xVa.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.game.ui.GameMessageUI.AnonymousClass5 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(42301);
                        b bVar = new b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/game/ui/GameMessageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (!Util.isNullOrNil(GameMessageUI.this.xVe)) {
                            com.tencent.mm.game.report.f.a(GameMessageUI.this.getContext(), 13, 1302, 1, c.aQ(GameMessageUI.this.getContext(), GameMessageUI.this.xVe), GameMessageUI.this.gwE, null);
                        }
                        GameMessageUI.this.xVd = true;
                        a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(42301);
                    }
                });
                this.xUY.addHeaderView(this.xVa);
                this.xVa.setVisibility(0);
                com.tencent.mm.plugin.game.model.e.gd(this);
            } else if (this.xVa != null) {
                this.xVa.setVisibility(8);
            }
        }
        o oVar = new o();
        oVar.xGb = true;
        this.xUZ = new n(this, oVar, this.gwE, this.xVf);
        this.xUZ.Bh(true);
        OA(8);
        this.xUZ.a(new s.a() {
            /* class com.tencent.mm.plugin.game.ui.GameMessageUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
                AppMethodBeat.i(42299);
                if (GameMessageUI.this.xUZ.getCount() == 0) {
                    GameMessageUI.this.xUY.setVisibility(8);
                    GameMessageUI.a(GameMessageUI.this, 0);
                    GameMessageUI.this.enableOptionMenu(false);
                    AppMethodBeat.o(42299);
                    return;
                }
                GameMessageUI.this.xUY.setVisibility(0);
                GameMessageUI.a(GameMessageUI.this, 8);
                GameMessageUI.this.enableOptionMenu(true);
                AppMethodBeat.o(42299);
            }
        });
        this.xUY.setOnScrollListener(this.xPk);
        this.xUY.setAdapter((ListAdapter) this.xUZ);
        ListView listView = this.xUY;
        n nVar = this.xUZ;
        Log.i("MicroMsg.GameMessageAdapter", "init position:%d", Integer.valueOf(nVar.xUz));
        if (nVar.xUz > nVar.getCount() - 1) {
            nVar.xUz = nVar.getCount() - 1;
        }
        listView.setSelection(nVar.xUz);
        com.tencent.mm.game.report.f.a(getContext(), 13, 1300, 0, 1, 0, null, this.gwE, 0, null, null, null);
        AppMethodBeat.o(42305);
    }

    private void OA(int i2) {
        AppMethodBeat.i(42306);
        if (this.jZO == null) {
            this.jZO = (TextView) findViewById(R.id.dhq);
        }
        this.jZO.setVisibility(i2);
        AppMethodBeat.o(42306);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(42307);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(42307);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(42307);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(42308);
        ((f) g.af(f.class)).dSK().dVx();
        finish();
        AppMethodBeat.o(42308);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.arp;
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(42309);
        super.onDestroy();
        if (this.xUZ != null) {
            this.xUZ.ebf();
        }
        g.azz().b(573, this);
        ((f) g.af(f.class)).dSK().dVy();
        ((f) g.af(f.class)).dSK().dVx();
        AppMethodBeat.o(42309);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        int b2;
        int b3;
        AppMethodBeat.i(42310);
        b bVar = new b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        a.b("com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        o oVar = (o) adapterView.getAdapter().getItem(i2);
        if (oVar == null) {
            Log.e("MicroMsg.GameMessageUI", "get message null: position:[%d]", Integer.valueOf(i2));
            a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(42310);
            return;
        }
        oVar.dVl();
        String a2 = com.tencent.mm.game.report.f.a(null, null, oVar.xFX, null);
        if (oVar.field_msgType == 100) {
            if (!Util.isNullOrNil(oVar.xFE)) {
                o.g gVar = oVar.xFj.get(oVar.xFE);
                if (gVar == null) {
                    a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(42310);
                    return;
                }
                int a3 = p.a(this, oVar, gVar, oVar.field_appId, 1301);
                if (a3 != 0) {
                    com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, a3, 0, oVar.field_appId, this.gwE, oVar.xFV, oVar.field_gameMsgId, oVar.xFW, a2);
                }
            }
            a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(42310);
        } else if (oVar.xFZ == 0) {
            switch (oVar.field_msgType) {
                case 2:
                case 5:
                    if (com.tencent.mm.pluginsdk.model.app.h.s(this, oVar.field_appId)) {
                        com.tencent.mm.plugin.game.model.e.at(this, oVar.field_appId);
                        b3 = 3;
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", oVar.field_appId);
                        bundle.putInt("game_report_from_scene", 1301);
                        b3 = c.b(this, oVar.field_appId, null, bundle);
                    }
                    com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, b3, 0, oVar.field_appId, this.gwE, oVar.field_msgType, oVar.field_gameMsgId, oVar.xFW, a2);
                    break;
                case 6:
                    if (!Util.isNullOrNil(oVar.xFz)) {
                        b3 = c.aQ(this, oVar.xFz);
                        com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, b3, 0, oVar.field_appId, this.gwE, oVar.field_msgType, oVar.field_gameMsgId, oVar.xFW, a2);
                        break;
                    }
                    break;
                case 10:
                case 11:
                    if (!Util.isNullOrNil(oVar.xEW)) {
                        b3 = c.aQ(this, oVar.xEW);
                        com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, b3, 0, oVar.field_appId, this.gwE, oVar.field_msgType, oVar.field_gameMsgId, oVar.xFW, a2);
                        break;
                    }
                    break;
            }
            a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(42310);
        } else {
            switch (oVar.xFZ) {
                case 1:
                    if (!Util.isNullOrNil(oVar.field_appId)) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putCharSequence("game_app_id", oVar.field_appId);
                        bundle2.putInt("game_report_from_scene", 1301);
                        com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, c.b(this, oVar.field_appId, null, bundle2), 0, oVar.field_appId, this.gwE, oVar.field_msgType, oVar.field_gameMsgId, oVar.xFW, a2);
                        break;
                    } else {
                        Log.e("MicroMsg.GameMessageUI", "appid is null");
                        a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(42310);
                        return;
                    }
                case 2:
                    if (com.tencent.mm.pluginsdk.model.app.h.s(this, oVar.field_appId)) {
                        com.tencent.mm.plugin.game.model.e.at(this, oVar.field_appId);
                        b2 = 3;
                    } else {
                        Bundle bundle3 = new Bundle();
                        bundle3.putCharSequence("game_app_id", oVar.field_appId);
                        bundle3.putInt("game_report_from_scene", 1301);
                        b2 = c.b(this, oVar.field_appId, null, bundle3);
                    }
                    com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, b2, 0, oVar.field_appId, this.gwE, oVar.field_msgType, oVar.field_gameMsgId, oVar.xFW, a2);
                    break;
                case 3:
                    if (Util.isNullOrNil(oVar.xGa)) {
                        Log.e("MicroMsg.GameMessageUI", "jumpurl is null");
                        break;
                    } else {
                        com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, c.aQ(this, oVar.xGa), 0, oVar.field_appId, this.gwE, oVar.field_msgType, oVar.field_gameMsgId, oVar.xFW, a2);
                        break;
                    }
                default:
                    Log.e("MicroMsg.GameMessageUI", "unknowed jumptype : " + oVar.xFZ);
                    break;
            }
            a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(42310);
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(42311);
        Log.i("MicroMsg.GameMessageUI", "onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(qVar.getType()));
        if (i2 == 0 && i3 == 0) {
            if (qVar.getType() == 573) {
                OA(8);
                this.xUZ.onNotifyChange(null, null);
                AppMethodBeat.o(42311);
                return;
            }
        } else if (this.xUZ.getCount() > 0) {
            Log.i("MicroMsg.GameMessageUI", "has local message, do not show error tips");
            AppMethodBeat.o(42311);
            return;
        } else if (com.tencent.mm.plugin.game.a.a.jRu.a(this, i2, i3, str)) {
            AppMethodBeat.o(42311);
            return;
        } else {
            Toast.makeText(this, getString(R.string.dp_, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
        }
        AppMethodBeat.o(42311);
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity
    public final int getScene() {
        return 13;
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity
    public final int dWi() {
        return 1300;
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity
    public final int dWj() {
        return this.gwE;
    }
}
