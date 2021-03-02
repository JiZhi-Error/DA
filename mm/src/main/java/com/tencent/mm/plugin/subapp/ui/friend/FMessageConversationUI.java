package com.tencent.mm.plugin.subapp.ui.friend;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bj.c;
import com.tencent.mm.bj.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.s;

public class FMessageConversationUI extends MMActivity {
    private String BqF;
    private ListView FKL;
    private a FKM;
    private View FKN;
    private View FKO;
    private TextView FKP;
    private long FKQ;
    private b FKw;
    private o.g plk = new o.g() {
        /* class com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.AnonymousClass8 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(232075);
            c.f(FMessageConversationUI.this.FKQ, FMessageConversationUI.this.BqF);
            AppMethodBeat.o(232075);
        }
    };
    private int ppd = 0;
    private int ppe = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FMessageConversationUI() {
        AppMethodBeat.i(29044);
        AppMethodBeat.o(29044);
    }

    static /* synthetic */ void a(FMessageConversationUI fMessageConversationUI) {
        AppMethodBeat.i(29052);
        fMessageConversationUI.updateStatus();
        AppMethodBeat.o(29052);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29045);
        super.onCreate(bundle);
        setMMTitle(R.string.ddk);
        hideActionbarLine();
        try {
            bg.getNotification().alb();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FMessageConversationUI", e2, "try cancel notification fail", new Object[0]);
        }
        if (!bg.aAc()) {
            finish();
            AppMethodBeat.o(29045);
            return;
        }
        initView();
        AppMethodBeat.o(29045);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(29046);
        super.onPause();
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(143618, (Object) 0);
        AppMethodBeat.o(29046);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(29047);
        super.onResume();
        if (!bg.aAc()) {
            finish();
            AppMethodBeat.o(29047);
            return;
        }
        if (this.FKP != null && Util.isOverseasUser(this)) {
            this.FKP.setText(R.string.ddq);
        }
        AppMethodBeat.o(29047);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(29048);
        super.onDestroy();
        if (this.FKw != null) {
            d.bgN().remove(this.FKw);
        }
        if (!g.aAf().azp()) {
            Log.w("MicroMsg.FMessageConversationUI", "account not init.");
            AppMethodBeat.o(29048);
            return;
        }
        f.KW("1");
        d.bgN().gCQ();
        AppMethodBeat.o(29048);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(29049);
        if (com.tencent.mm.model.a.g.aWT().KR("1") != null) {
            String str = com.tencent.mm.model.a.g.aWT().KR("1").value;
            if (!str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                str.equals("1");
            }
            f.KV("1");
        }
        this.FKw = new b(getContext());
        d.bgN().add(this.FKw);
        this.FKw.a(new s.a() {
            /* class com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
                AppMethodBeat.i(29037);
                FMessageConversationUI.a(FMessageConversationUI.this);
                AppMethodBeat.o(29037);
            }
        });
        this.FKL = (ListView) findViewById(R.id.d74);
        this.FKN = LayoutInflater.from(getContext()).inflate(R.layout.am7, (ViewGroup) null);
        this.FKN.findViewById(R.id.hf7).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(29038);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent putExtra = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
                Bundle bundle = null;
                if (Build.VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(FMessageConversationUI.this, new Pair[0]).toBundle();
                }
                com.tencent.mm.plugin.fts.a.d.b(FMessageConversationUI.this.getContext(), ".ui.FTSAddFriendUI", putExtra, bundle);
                a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29038);
            }
        });
        this.FKL.addHeaderView(this.FKN);
        this.FKO = LayoutInflater.from(getContext()).inflate(R.layout.am3, (ViewGroup) null);
        this.FKO.findViewById(R.id.gp).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(29039);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (l.bnZ() != l.a.SUCC) {
                    Intent intent = new Intent(FMessageConversationUI.this.getContext(), BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 5);
                    MMWizardActivity.ay(FMessageConversationUI.this.getContext(), intent);
                } else {
                    FMessageConversationUI fMessageConversationUI = FMessageConversationUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(FMessageConversationUI.this.getContext(), MobileFriendUI.class));
                    a.a(fMessageConversationUI, bl.axQ(), "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    fMessageConversationUI.startActivity((Intent) bl.pG(0));
                    a.a(fMessageConversationUI, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29039);
            }
        });
        this.FKL.addHeaderView(this.FKO);
        this.FKL.setAdapter((ListAdapter) this.FKw);
        updateStatus();
        this.FKL.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.AnonymousClass4 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(232072);
                switch (motionEvent.getAction()) {
                    case 0:
                        FMessageConversationUI.this.ppd = (int) motionEvent.getRawX();
                        FMessageConversationUI.this.ppe = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(232072);
                return false;
            }
        });
        final com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(this);
        this.FKL.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.AnonymousClass5 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(232073);
                if (i2 < FMessageConversationUI.this.FKL.getHeaderViewsCount()) {
                    Log.w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
                    AppMethodBeat.o(232073);
                    return true;
                }
                aVar.a(view, i2 - FMessageConversationUI.this.FKL.getHeaderViewsCount(), j2, FMessageConversationUI.this, FMessageConversationUI.this.plk, FMessageConversationUI.this.ppd, FMessageConversationUI.this.ppe);
                AppMethodBeat.o(232073);
                return true;
            }
        });
        this.FKM = new a(getContext(), this.FKw, this.FKL.getHeaderViewsCount() > 0);
        this.FKL.setOnItemClickListener(this.FKM);
        addTextOptionMenu(0, getString(R.string.ezw), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29042);
                Intent intent = new Intent(FMessageConversationUI.this, AddMoreFriendsUI.class);
                intent.putExtra("invite_friend_scene", 3);
                FMessageConversationUI fMessageConversationUI = FMessageConversationUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(fMessageConversationUI, bl.axQ(), "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$6", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                fMessageConversationUI.startActivity((Intent) bl.pG(0));
                a.a(fMessageConversationUI, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$6", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(29042);
                return true;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(232074);
                FMessageConversationUI.this.finish();
                AppMethodBeat.o(232074);
                return true;
            }
        });
        AppMethodBeat.o(29049);
    }

    private void updateStatus() {
        AppMethodBeat.i(29050);
        if (this.FKw.getCount() > 0) {
            this.FKN.findViewById(R.id.hf7).setVisibility(0);
            this.FKO.findViewById(R.id.gr).setVisibility(8);
            enableOptionMenu(0, true);
            AppMethodBeat.o(29050);
            return;
        }
        this.FKN.findViewById(R.id.hf7).setVisibility(8);
        this.FKO.findViewById(R.id.gr).setVisibility(0);
        enableOptionMenu(0, false);
        AppMethodBeat.o(29050);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.am2;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(29051);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        bl blVar = (bl) this.FKw.getItem(adapterContextMenuInfo.position);
        if (blVar == null) {
            Log.e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            AppMethodBeat.o(29051);
            return;
        }
        if (!Util.isNullOrNil(blVar.field_displayName)) {
            contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.l.c(this, blVar.field_displayName));
        }
        contextMenu.add(0, 0, 0, R.string.tf);
        this.FKQ = blVar.field_fmsgSysRowId;
        this.BqF = blVar.field_talker;
        AppMethodBeat.o(29051);
    }
}
