package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;

public class EmojiStoreTopicUI extends BaseEmojiStoreUI {
    private int mScene;
    private int riA;
    private String riB;
    private String riC;
    private String riD;
    private String riE;
    private String riF;

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final void cGG() {
        AppMethodBeat.i(109055);
        super.cGG();
        AppMethodBeat.o(109055);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109056);
        super.onCreate(bundle);
        h.INSTANCE.a(12740, 3, "", "", Integer.valueOf(this.riA), 11, 11);
        AppMethodBeat.o(109056);
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109057);
        this.riA = getIntent().getIntExtra("topic_id", -1);
        this.riB = getIntent().getStringExtra("topic_name");
        this.riE = getIntent().getStringExtra("topic_ad_url");
        this.riC = getIntent().getStringExtra("topic_icon_url");
        this.riD = getIntent().getStringExtra("topic_desc");
        this.riF = getIntent().getStringExtra("sns_object_data");
        this.mScene = getIntent().getIntExtra("extra_scence", 0);
        if (!Util.isNullOrNil(this.riF)) {
            this.riA = EmojiLogic.amI(this.riF);
            this.riB = EmojiLogic.amJ(this.riF);
            this.riC = EmojiLogic.amL(this.riF);
            this.riD = EmojiLogic.amK(this.riF);
            this.riE = EmojiLogic.amM(this.riF);
        }
        setMMTitle(this.riB);
        super.initView();
        addIconOptionMenu(0, R.raw.icons_outlined_share, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109051);
                Log.d("MicroMsg.emoji.EmojiStoreTopicUI", "on shard click.");
                if (Util.isNullOrNil(EmojiStoreTopicUI.this.riB) || Util.isNullOrNil(EmojiStoreTopicUI.this.riC)) {
                    Log.i("MicroMsg.emoji.EmojiStoreTopicUI", "name or url is null.");
                } else {
                    EmojiStoreTopicUI.c(EmojiStoreTopicUI.this);
                }
                AppMethodBeat.o(109051);
                return true;
            }
        });
        showOptionMenu(0, false);
        amV(this.riE);
        AppMethodBeat.o(109057);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final void amV(String str) {
        AppMethodBeat.i(109058);
        if (!(this.rdZ == null || this.rea == null || Util.isNullOrNil(str))) {
            a.getDensity(this);
            EmojiInfo H = EmojiLogic.H("Toptic", 8, str);
            if (H == null) {
                q.bcV().a(str, (ImageView) null, e.j("Toptic", str, "Toptic", "BANNER"), new k() {
                    /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI.AnonymousClass2 */

                    @Override // com.tencent.mm.av.a.c.k
                    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(109052);
                        EmojiStoreTopicUI emojiStoreTopicUI = EmojiStoreTopicUI.this;
                        if (emojiStoreTopicUI.rfA != null) {
                            emojiStoreTopicUI.rfA.sendEmptyMessage(1009);
                        }
                        AppMethodBeat.o(109052);
                    }
                });
                AppMethodBeat.o(109058);
                return;
            }
            this.rea.setImageFilePath(H.hYx());
        }
        AppMethodBeat.o(109058);
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(109059);
        super.onResume();
        AppMethodBeat.o(109059);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final void a(g gVar, boolean z, boolean z2) {
        AppMethodBeat.i(109060);
        super.a(gVar, z, z2);
        AppMethodBeat.o(109060);
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(109061);
        cGW();
        if (i2 == 2002 && i3 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!Util.isNullOrNil(stringExtra)) {
                Log.d("MicroMsg.emoji.EmojiStoreTopicUI", "..".concat(String.valueOf(stringExtra)));
                int i4 = this.riA;
                String str = this.riB;
                String str2 = this.riD;
                String str3 = this.riC;
                String str4 = this.riE;
                com.tencent.mm.plugin.emoji.model.k.cGf();
                j.a(this, stringExtra, 26, i4, str, str2, str3, str4, 0, f.cFI());
            }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(109061);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final void a(boolean z, g gVar, boolean z2, boolean z3) {
        AppMethodBeat.i(109062);
        super.a(z, gVar, z2, z3);
        AppMethodBeat.o(109062);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final int cGQ() {
        return 7;
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final int cGR() {
        return this.riA;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final boolean cGX() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final com.tencent.mm.plugin.emoji.a.a.a cGJ() {
        AppMethodBeat.i(109063);
        com.tencent.mm.plugin.emoji.a.f fVar = new com.tencent.mm.plugin.emoji.a.f(getContext());
        AppMethodBeat.o(109063);
        return fVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final boolean cGO() {
        AppMethodBeat.i(109064);
        if (Util.isNullOrNil(this.riE)) {
            AppMethodBeat.o(109064);
            return false;
        }
        AppMethodBeat.o(109064);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final boolean cGN() {
        return false;
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity
    public final void k(Message message) {
        AppMethodBeat.i(109065);
        super.k(message);
        if (message.what == 1009) {
            amV(this.riE);
        }
        AppMethodBeat.o(109065);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final int cGH() {
        return 11;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final int cGI() {
        return 14;
    }

    @Override // com.tencent.mm.ak.i, com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(109066);
        super.onSceneEnd(i2, i3, str, qVar);
        if (this.red) {
            showOptionMenu(0, false);
            AppMethodBeat.o(109066);
            return;
        }
        showOptionMenu(0, true);
        AppMethodBeat.o(109066);
    }

    static /* synthetic */ void c(EmojiStoreTopicUI emojiStoreTopicUI) {
        AppMethodBeat.i(109067);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) emojiStoreTopicUI.getContext(), 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(109053);
                mVar.b(1001, EmojiStoreTopicUI.this.getString(R.string.btp), R.raw.bottomsheet_icon_transmit);
                mVar.b(1000, EmojiStoreTopicUI.this.getString(R.string.btq), R.raw.bottomsheet_icon_moment);
                AppMethodBeat.o(109053);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(109054);
                switch (menuItem.getItemId()) {
                    case 1001:
                        j.eY(EmojiStoreTopicUI.this.getContext());
                        EmojiStoreTopicUI.this.getContext().overridePendingTransition(R.anim.dq, R.anim.bs);
                        h.INSTANCE.a(13224, 1, 2, "", Integer.valueOf(EmojiStoreTopicUI.this.riA));
                        AppMethodBeat.o(109054);
                        return;
                    case 1000:
                        AppCompatActivity context = EmojiStoreTopicUI.this.getContext();
                        String str = EmojiStoreTopicUI.this.riB;
                        String str2 = EmojiStoreTopicUI.this.riD;
                        String str3 = EmojiStoreTopicUI.this.riC;
                        com.tencent.mm.plugin.emoji.model.k.cGf();
                        j.a(context, str, str2, str3, f.cFI(), EmojiLogic.a(EmojiStoreTopicUI.this.riA, EmojiStoreTopicUI.this.riB, EmojiStoreTopicUI.this.riD, EmojiStoreTopicUI.this.riC, EmojiStoreTopicUI.this.riE, 0), 13);
                        h.INSTANCE.a(13224, 1, 1, "", Integer.valueOf(EmojiStoreTopicUI.this.riA));
                        break;
                }
                AppMethodBeat.o(109054);
            }
        };
        eVar.dGm();
        h.INSTANCE.a(13224, 1, 0, "", Integer.valueOf(emojiStoreTopicUI.riA));
        AppMethodBeat.o(109067);
    }
}
