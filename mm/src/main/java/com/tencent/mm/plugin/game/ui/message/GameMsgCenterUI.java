package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.protobuf.bh;
import com.tencent.mm.plugin.game.protobuf.ct;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GameMsgCenterUI extends MMActivity {
    private int fromScene;
    private int xXW = 0;
    private TextView xXX;
    private TabItemView xXY;
    private TabItemView xXZ;
    private CustomViewPager xYa;
    private a xYb;
    private b xYc;
    private int xYd;
    private int xYe;
    private int xYf = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(183878);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        boolean aln = ar.aln(getResources().getColor(R.color.afz));
        View contentView = getContentView();
        int color = getResources().getColor(R.color.afz);
        if (!aln) {
            z = true;
        } else {
            z = false;
        }
        com.tencent.mm.ui.statusbar.a.e(contentView, color, z);
        this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
        String stringExtra = getIntent().getStringExtra("game_msg_ui_from_msgid");
        int intExtra = getIntent().getIntExtra("game_msg_center_tab_type", 0);
        if (intExtra == 1) {
            this.xXW = 1;
        } else if (intExtra == 2) {
            this.xXW = 2;
        } else {
            o aAk = ((f) g.af(f.class)).dSK().aAk(stringExtra);
            if (aAk != null) {
                this.xXW = aAk.field_showType;
            }
        }
        if (this.xXW == 0) {
            this.xYd = ((f) g.af(f.class)).dSK().Op(1);
            this.xYe = ((f) g.af(f.class)).dSK().Op(2);
            if (this.xYd > 0 || this.xYe <= 0) {
                this.xXW = 1;
            } else {
                this.xXW = 2;
            }
        }
        findViewById(R.id.dr).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(183870);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                GameMsgCenterUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(183870);
            }
        });
        findViewById(R.id.e9).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(204315);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e eVar = new e((Context) GameMsgCenterUI.this.getContext(), 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(204309);
                        if (GameMsgCenterUI.this.xYf == 0) {
                            mVar.kV(0, R.string.dnu);
                            AppMethodBeat.o(204309);
                            return;
                        }
                        mVar.kV(1, R.string.dru);
                        mVar.kV(2, R.string.dnw);
                        AppMethodBeat.o(204309);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI.AnonymousClass2.AnonymousClass2 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        String str;
                        AppMethodBeat.i(204314);
                        Log.i("MicroMsg.GameMsgCenterUI", "bottomSheet itemId:%d", Integer.valueOf(menuItem.getItemId()));
                        d.a aVar = new d.a(GameMsgCenterUI.this.getContext());
                        aVar.Dk(false);
                        aVar.aoW(R.string.sz).d(new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI.AnonymousClass2.AnonymousClass2.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        final HashMap hashMap = new HashMap();
                        switch (menuItem.getItemId()) {
                            case 0:
                                aVar.aoS(R.string.dnv);
                                aVar.aoV(R.string.t2).c(new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI.AnonymousClass2.AnonymousClass2.AnonymousClass3 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(204311);
                                        ((f) g.af(f.class)).dSK().Oq(1);
                                        if (GameMsgCenterUI.this.xYb != null) {
                                            GameMsgCenterUI.this.xYb.refreshView();
                                        }
                                        hashMap.put("tab", "1");
                                        hashMap.put("actionstatus", "2");
                                        com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.this.fromScene, com.tencent.mm.game.report.f.t(hashMap));
                                        AppMethodBeat.o(204311);
                                    }
                                }).f(new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI.AnonymousClass2.AnonymousClass2.AnonymousClass2 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(204310);
                                        hashMap.put("tab", "1");
                                        hashMap.put("actionstatus", "1");
                                        com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.this.fromScene, com.tencent.mm.game.report.f.t(hashMap));
                                        AppMethodBeat.o(204310);
                                    }
                                });
                                aVar.hbn().show();
                                hashMap.put("tab", "1");
                                hashMap.put("actionstatus", "2");
                                com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1306, 1, 2, GameMsgCenterUI.this.fromScene, com.tencent.mm.game.report.f.t(hashMap));
                                AppMethodBeat.o(204314);
                                return;
                            case 1:
                                bh dTb = com.tencent.mm.plugin.game.commlib.a.dTb();
                                if (dTb != null && !Util.isNullOrNil(dTb.xKD)) {
                                    Iterator<ct> it = dTb.xKD.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            ct next = it.next();
                                            if (next.xMB == 1 && !Util.isNullOrNil(next.xIy)) {
                                                str = next.xIy;
                                            }
                                        }
                                    }
                                }
                                str = "https://game.weixin.qq.com/cgi-bin/h5/static/gamecenter/subscription_list.html?wechat_pkgid=gamecenter_subscription_list&ssid=5";
                                c.aQ(GameMsgCenterUI.this.getContext(), str);
                                hashMap.put("tab", "2");
                                hashMap.put("actionstatus", "1");
                                com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1306, 1, 2, GameMsgCenterUI.this.fromScene, com.tencent.mm.game.report.f.t(hashMap));
                                AppMethodBeat.o(204314);
                                return;
                            case 2:
                                aVar.aoS(R.string.dnx);
                                aVar.aoV(R.string.t2).c(new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI.AnonymousClass2.AnonymousClass2.AnonymousClass5 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(204313);
                                        ((f) g.af(f.class)).dSK().Oq(2);
                                        if (GameMsgCenterUI.this.xYc != null) {
                                            GameMsgCenterUI.this.xYc.refreshView();
                                        }
                                        hashMap.put("tab", "2");
                                        hashMap.put("actionstatus", "2");
                                        com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.this.fromScene, com.tencent.mm.game.report.f.t(hashMap));
                                        AppMethodBeat.o(204313);
                                    }
                                }).f(new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI.AnonymousClass2.AnonymousClass2.AnonymousClass4 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(204312);
                                        hashMap.put("tab", "2");
                                        hashMap.put("actionstatus", "1");
                                        com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.this.fromScene, com.tencent.mm.game.report.f.t(hashMap));
                                        AppMethodBeat.o(204312);
                                    }
                                });
                                aVar.hbn().show();
                                hashMap.put("tab", "2");
                                hashMap.put("actionstatus", "2");
                                com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1306, 1, 2, GameMsgCenterUI.this.fromScene, com.tencent.mm.game.report.f.t(hashMap));
                                break;
                        }
                        AppMethodBeat.o(204314);
                    }
                };
                eVar.dGm();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(204315);
            }
        });
        this.xXX = (TextView) findViewById(R.id.ec);
        View findViewById = findViewById(R.id.eb);
        this.xXX.setVisibility(0);
        findViewById.setVisibility(8);
        if (this.xXW == 2) {
            this.xXX.setText(R.string.dr5);
        } else {
            this.xXX.setText(R.string.dr4);
        }
        this.xXY = (TabItemView) findViewById(R.id.igj);
        this.xXY.setShowType(1);
        this.xXZ = (TabItemView) findViewById(R.id.igk);
        this.xXZ.setShowType(2);
        this.xYa = (CustomViewPager) findViewById(R.id.fdv);
        a aVar = new a(getSupportFragmentManager());
        GameMsgCenterFragment gameMsgCenterFragment = new GameMsgCenterFragment();
        this.xYb = new a(this, this.fromScene, this.xXW == 1);
        this.xYb.setNewMessageCount(this.xYd);
        gameMsgCenterFragment.contentView = this.xYb;
        aVar.a(gameMsgCenterFragment);
        GameMsgCenterFragment gameMsgCenterFragment2 = new GameMsgCenterFragment();
        if (this.xXW == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.xYc = new b(this, this.fromScene, z2);
        this.xYc.setNewMessageCount(this.xYe);
        gameMsgCenterFragment2.contentView = this.xYc;
        aVar.a(gameMsgCenterFragment2);
        this.xYa.setCanSlide(false);
        this.xYa.setAdapter(aVar);
        this.xXY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(183871);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                GameMsgCenterUI.this.setCurrentItem(0);
                com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1303, 1, 2, GameMsgCenterUI.this.fromScene, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(183871);
            }
        });
        this.xXZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(183872);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                GameMsgCenterUI.this.setCurrentItem(1);
                com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1303, 2, 2, GameMsgCenterUI.this.fromScene, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(183872);
            }
        });
        this.xYa.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI.AnonymousClass5 */

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i2, float f2, int i3) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                AppMethodBeat.i(183873);
                Log.i("MicroMsg.GameMsgCenterUI", "onPageSelected:%d", Integer.valueOf(i2));
                GameMsgCenterUI.this.setCurrentItem(i2);
                AppMethodBeat.o(183873);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i2) {
            }
        });
        if (this.xXW == 2) {
            this.xXY.setUnreadCount(((f) g.af(f.class)).dSK().Op(1));
            setCurrentItem(1);
            AppMethodBeat.o(183878);
            return;
        }
        this.xXZ.setUnreadCount(((f) g.af(f.class)).dSK().Op(2));
        setCurrentItem(0);
        AppMethodBeat.o(183878);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.arq;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        Cursor cursor;
        Cursor cursor2;
        AppMethodBeat.i(183879);
        super.onDestroy();
        if (this.xYb != null) {
            a aVar = this.xYb;
            if (!(aVar.xXS == null || (cursor2 = aVar.xXS.xYn.To) == null)) {
                cursor2.close();
            }
        }
        if (this.xYc != null) {
            b bVar = this.xYc;
            if (!(bVar.xYl == null || (cursor = bVar.xYl.xYB.To) == null)) {
                cursor.close();
            }
        }
        ((f) g.af(f.class)).dSK().dVy();
        AppMethodBeat.o(183879);
    }

    public final void setCurrentItem(int i2) {
        AppMethodBeat.i(183880);
        this.xYf = i2 % 2;
        if (this.xYf == 0) {
            this.xXY.setSelected(true);
            this.xXZ.setSelected(false);
            if (this.xYb != null) {
                this.xYb.resume();
            }
        } else {
            this.xXY.setSelected(false);
            this.xXZ.setSelected(true);
            if (this.xYc != null) {
                this.xYc.resume();
            }
        }
        this.xYa.setCurrentItem(this.xYf);
        AppMethodBeat.o(183880);
    }

    static class a extends i {
        private List<GameMsgCenterFragment> xYk = new ArrayList();

        public a(android.support.v4.app.g gVar) {
            super(gVar);
            AppMethodBeat.i(183874);
            AppMethodBeat.o(183874);
        }

        public final void a(GameMsgCenterFragment gameMsgCenterFragment) {
            AppMethodBeat.i(183875);
            this.xYk.add(gameMsgCenterFragment);
            AppMethodBeat.o(183875);
        }

        @Override // android.support.v4.app.i
        public final Fragment getItem(int i2) {
            AppMethodBeat.i(183876);
            List<GameMsgCenterFragment> list = this.xYk;
            GameMsgCenterFragment gameMsgCenterFragment = list.get(i2 % list.size());
            AppMethodBeat.o(183876);
            return gameMsgCenterFragment;
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            AppMethodBeat.i(183877);
            int size = this.xYk.size();
            AppMethodBeat.o(183877);
            return size;
        }
    }

    public static class GameMsgCenterFragment extends Fragment {
        View contentView;

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return this.contentView;
        }
    }
}
