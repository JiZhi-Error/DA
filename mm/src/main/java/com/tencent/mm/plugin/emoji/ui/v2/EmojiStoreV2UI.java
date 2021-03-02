package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.j;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cr.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.y.c;
import java.util.HashMap;

@i
public class EmojiStoreV2UI extends MMActivity {
    private int rmJ = 0;
    private HashMap<Integer, EmojiStoreV2BaseFragment> rmU = new HashMap<>();
    EmojiStoreV2TabView rmV;
    private EmojiStoreV2ViewPager rmW;
    private a rmX;
    private boolean rmY = true;
    private boolean rmZ = false;
    private int rna = -1;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreV2UI() {
        AppMethodBeat.i(109400);
        AppMethodBeat.o(109400);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109401);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.rna = getIntent().getIntExtra("download_entrance_scene", -1);
        String value = h.aqJ().getValue("ShowPersonalEmotion");
        Log.i("MicroMsg.emoji.EmojiStoreV2UI", "get dynamic config value:%s", value);
        if (Util.isNullOrNil(value) || Util.safeParseInt(value) != 1) {
            this.rmY = false;
        } else {
            this.rmY = true;
        }
        if (this.rmY) {
            this.rmJ = getIntent().getIntExtra("emoji_tab", 0);
        }
        initView();
        g.aAk().postToWorker(new b((byte) 0));
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_EMOJI_STORE_NEW_ORIGINAL_BOOLEAN, Boolean.FALSE)).booleanValue();
        if (this.rmV != null) {
            this.rmV.lC(booleanValue);
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(406, 0, 1, false);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(406, 2, System.currentTimeMillis() - currentTimeMillis, false);
        AppMethodBeat.o(109401);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(109402);
        super.onResume();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI.AnonymousClass4 */

            public final boolean queueIdle() {
                AppMethodBeat.i(109391);
                Log.i("MicroMsg.emoji.EmojiStoreV2UI", "now try to activity the tools process");
                d.hiy();
                AppMethodBeat.o(109391);
                return false;
            }
        });
        AppMethodBeat.o(109402);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a3k;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109403);
        addIconOptionMenu(0, R.string.yn, R.raw.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109388);
                EmojiStoreV2UI.a(EmojiStoreV2UI.this);
                AppMethodBeat.o(109388);
                return false;
            }
        });
        addIconOptionMenu(1, R.string.wg, R.raw.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109389);
                Intent intent = new Intent();
                intent.putExtra("10931", 1);
                intent.setClass(EmojiStoreV2UI.this, EmojiMineUI.class);
                EmojiStoreV2UI emojiStoreV2UI = EmojiStoreV2UI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(emojiStoreV2UI, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2UI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                emojiStoreV2UI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(emojiStoreV2UI, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2UI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(109389);
                return false;
            }
        });
        this.rmV = (EmojiStoreV2TabView) findViewById(R.id.c24);
        this.rmW = (EmojiStoreV2ViewPager) findViewById(R.id.c23);
        this.rmW.setOffscreenPageLimit(0);
        this.rmX = new a(this, this.rmW, this.rmY);
        if (!this.rmY) {
            this.rmV.setVisibility(8);
            AppMethodBeat.o(109403);
            return;
        }
        this.rmV.setVisibility(0);
        EventCenter.instance.addListener(this.rmV.rmR);
        AppMethodBeat.o(109403);
    }

    static final class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(109399);
            c.axV().A(262147, false);
            c.axV().A(262149, false);
            c.axV().cQ(262147, 266244);
            c.axV().cQ(262149, 266244);
            g.aAh().azQ().set(208899, Boolean.FALSE);
            g.aAh().azQ().set(208913, Boolean.FALSE);
            AppMethodBeat.o(109399);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109404);
        super.onDestroy();
        if (this.rmU != null) {
            this.rmU.clear();
        }
        if (this.rmV != null) {
            EventCenter.instance.removeListener(this.rmV.rmR);
        }
        AppMethodBeat.o(109404);
    }

    public final EmojiStoreV2BaseFragment Ge(int i2) {
        EmojiStoreV2BaseFragment emojiStoreV2BaseFragment = null;
        AppMethodBeat.i(109405);
        if (i2 < 0) {
            AppMethodBeat.o(109405);
            return null;
        } else if (this.rmU.containsKey(Integer.valueOf(i2))) {
            EmojiStoreV2BaseFragment emojiStoreV2BaseFragment2 = this.rmU.get(Integer.valueOf(i2));
            AppMethodBeat.o(109405);
            return emojiStoreV2BaseFragment2;
        } else {
            switch (i2) {
                case 0:
                    emojiStoreV2BaseFragment = (EmojiStoreV2BaseFragment) Fragment.instantiate(this, EmojiStoreV2MainFragment.class.getName(), null);
                    break;
                case 1:
                    emojiStoreV2BaseFragment = (EmojiStoreV2BaseFragment) Fragment.instantiate(this, EmojiStoreV2PersonFragment.class.getName(), null);
                    break;
                default:
                    Log.w("MicroMsg.emoji.EmojiStoreV2UI", "create fragment failed.");
                    break;
            }
            Log.d("MicroMsg.emoji.EmojiStoreV2UI", "create fragment index:%d", Integer.valueOf(i2));
            if (emojiStoreV2BaseFragment != null) {
                emojiStoreV2BaseFragment.setParent(this);
            }
            this.rmU.put(Integer.valueOf(i2), emojiStoreV2BaseFragment);
            AppMethodBeat.o(109405);
            return emojiStoreV2BaseFragment;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(109406);
        super.onActivityResult(i2, i3, intent);
        Log.d("MicroMsg.emoji.EmojiStoreV2UI", "onActivityResult . requestCode:" + i2 + "  resultCode:" + i3);
        if (!(this.rmX == null || this.rmX.Gf(this.rmJ) == null)) {
            this.rmX.Gf(this.rmJ).onActivityResult(i2, i3, intent);
        }
        AppMethodBeat.o(109406);
    }

    /* access modifiers changed from: package-private */
    public class a extends j implements ViewPager.OnPageChangeListener, EmojiStoreV2TabView.a {
        private boolean rmY = false;
        private WxViewPager rnc;

        @Override // android.support.v4.app.j
        public final /* synthetic */ Fragment getItem(int i2) {
            AppMethodBeat.i(109398);
            EmojiStoreV2BaseFragment Gf = Gf(i2);
            AppMethodBeat.o(109398);
            return Gf;
        }

        public a(FragmentActivity fragmentActivity, WxViewPager wxViewPager, boolean z) {
            super(fragmentActivity.getSupportFragmentManager());
            AppMethodBeat.i(109392);
            this.rmY = z;
            this.rnc = wxViewPager;
            this.rnc.setAdapter(this);
            this.rnc.setOnPageChangeListener(this);
            this.rnc.setCurrentItem(EmojiStoreV2UI.this.rmJ);
            com.tencent.mm.compatible.util.d.oE(11);
            if (EmojiStoreV2UI.this.rmV != null) {
                EmojiStoreV2UI.this.rmV.setOnTabClickListener(this);
            }
            AppMethodBeat.o(109392);
        }

        public final EmojiStoreV2BaseFragment Gf(int i2) {
            AppMethodBeat.i(109393);
            EmojiStoreV2BaseFragment Ge = EmojiStoreV2UI.this.Ge(i2);
            AppMethodBeat.o(109393);
            return Ge;
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            if (this.rmY) {
                return 2;
            }
            return 1;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i2, float f2, int i3) {
            AppMethodBeat.i(109394);
            if (EmojiStoreV2UI.this.rmV != null) {
                EmojiStoreV2UI.this.rmV.p(i2, f2);
            }
            AppMethodBeat.o(109394);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i2) {
            AppMethodBeat.i(109395);
            Log.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageSelected :%d", Integer.valueOf(i2));
            EmojiStoreV2UI.this.rmJ = i2;
            if (EmojiStoreV2UI.this.rmV != null) {
                EmojiStoreV2UI.this.rmV.setTo(i2);
            }
            if (EmojiStoreV2UI.this.rmJ == 1 && !EmojiStoreV2UI.this.rmZ) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12090, new Object[0]);
                EmojiStoreV2UI emojiStoreV2UI = EmojiStoreV2UI.this;
                g.aAh().azQ().set(ar.a.USERINFO_EMOJI_STORE_NEW_ORIGINAL_BOOLEAN, Boolean.FALSE);
                if (emojiStoreV2UI.rmV != null) {
                    emojiStoreV2UI.rmV.lC(false);
                }
                EmojiStoreV2UI.this.rmZ = true;
            }
            AppMethodBeat.o(109395);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i2) {
            AppMethodBeat.i(109396);
            Log.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageScrollStateChanged state:%d", Integer.valueOf(i2));
            if (i2 == 0 && EmojiStoreV2UI.this.Ge(EmojiStoreV2UI.this.rmJ) != null) {
                EmojiStoreV2UI.this.Ge(EmojiStoreV2UI.this.rmJ).cIa();
            }
            AppMethodBeat.o(109396);
        }

        @Override // com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.a
        public final void onTabClick(int i2) {
            AppMethodBeat.i(109397);
            if (i2 != EmojiStoreV2UI.this.rmJ) {
                this.rnc.setCurrentItem(i2, false);
            }
            EmojiStoreV2UI.this.rmJ = i2;
            AppMethodBeat.o(109397);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void a(EmojiStoreV2UI emojiStoreV2UI) {
        AppMethodBeat.i(109407);
        ((com.tencent.mm.plugin.websearch.api.i) g.af(com.tencent.mm.plugin.websearch.api.i.class)).a(MMApplicationContext.getContext(), new Runnable() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI.AnonymousClass3 */

            public final void run() {
                int i2;
                AppMethodBeat.i(109390);
                Intent fXX = ai.fXX();
                ai.f(fXX, EmojiStoreV2UI.this.rna == 17 ? 50 : 24);
                fXX.putExtra("ftsneedkeyboard", true);
                fXX.putExtra("key_load_js_without_delay", true);
                fXX.putExtra("ftsInitToSearch", true);
                com.tencent.mm.br.c.b(EmojiStoreV2UI.this.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", fXX);
                if (EmojiStoreV2UI.this.rmJ == 0) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13054, Integer.valueOf(i2), 0, "");
                AppMethodBeat.o(109390);
            }
        });
        AppMethodBeat.o(109407);
    }
}
