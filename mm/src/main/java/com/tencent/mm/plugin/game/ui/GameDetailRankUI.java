package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class GameDetailRankUI extends MMActivity {
    public static String EXTRA_SESSION_ID = "extra_session_id";
    public static String xQy = "gameDetailRankDataKey";
    private String appId;
    private ListView xQv;
    private GameRankHeadView xQw;
    private i xQx;

    public static class a {
        public String xQA;
        public String xQB;
        c xQC;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42005);
        super.onCreate(bundle);
        ad.b JW = ad.aVe().JW(getIntent().getStringExtra(EXTRA_SESSION_ID));
        if (JW == null) {
            finish();
            AppMethodBeat.o(42005);
            return;
        }
        a aVar = (a) JW.get(xQy);
        this.xQv = (ListView) findViewById(R.id.dey);
        if (!Util.isNullOrNil(aVar.xQA) && !Util.isNullOrNil(aVar.xQB)) {
            View inflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.aq0, (ViewGroup) this.xQv, false);
            this.xQw = (GameRankHeadView) inflate.findViewById(R.id.dif);
            this.xQv.addHeaderView(inflate);
            this.xQw.setData(aVar);
        }
        this.xQx = new i(this);
        this.xQx.Ve = R.layout.apu;
        this.xQv.setAdapter((ListAdapter) this.xQx);
        this.appId = aVar.xQC.field_appId;
        if (Util.isNullOrNil(this.appId)) {
            finish();
            AppMethodBeat.o(42005);
            return;
        }
        initView();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.game.ui.GameDetailRankUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(42003);
                GameDetailRankUI.this.xQx.a(new aa(GameDetailRankUI.this.appId));
                AppMethodBeat.o(42003);
            }
        });
        AppMethodBeat.o(42005);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(42006);
        super.onResume();
        AppMethodBeat.o(42006);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(42007);
        super.onDestroy();
        k.b(this.xQw.xQH);
        AppMethodBeat.o(42007);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.apt;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(42008);
        setMMTitle(h.r(getContext(), this.appId));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.GameDetailRankUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42004);
                GameDetailRankUI.this.finish();
                AppMethodBeat.o(42004);
                return true;
            }
        });
        AppMethodBeat.o(42008);
    }
}
