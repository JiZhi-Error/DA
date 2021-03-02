package com.tencent.mm.plugin.game.ui.chat_tab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI;
import com.tencent.mm.plugin.game.luggage.g.f;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.game.ui.chat_tab.GameTabData2;
import com.tencent.mm.plugin.gamelife.a.c;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;

public class GameWebTabUI extends LuggageGameWebViewUI implements f.a {
    private int pzw = 0;
    private GameTabWidget2 xWR;
    private BroadcastReceiver xWV = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI.AnonymousClass4 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(204285);
            if (intent != null && "com.tencent.mm.game.ACTION_EXIT".equals(intent.getAction()) && GameWebTabUI.this != null && !GameWebTabUI.this.isFinishing()) {
                Log.i("MicroMsg.GameWebTabUI", "GameWebTabUI exit!");
                GameWebTabUI.this.finish();
            }
            AppMethodBeat.o(204285);
        }
    };
    private String xXH;
    private GameTabData2 xXI;
    private boolean xXJ = true;
    private d<Bundle> xXK = new d<Bundle>() {
        /* class com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Bundle bundle) {
            AppMethodBeat.i(204277);
            Bundle bundle2 = bundle;
            if (bundle2 != null) {
                GameWebTabUI.a(GameWebTabUI.this, bundle2.getInt("msg_unread_count"), bundle2.getInt("notify_unread_count"));
            }
            AppMethodBeat.o(204277);
        }
    };

    @Override // com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameWebTabUI() {
        AppMethodBeat.i(204293);
        AppMethodBeat.o(204293);
    }

    static /* synthetic */ void a(GameWebTabUI gameWebTabUI, GameTabData2.TabItem tabItem) {
        AppMethodBeat.i(204303);
        gameWebTabUI.a(tabItem, true);
        AppMethodBeat.o(204303);
    }

    @Override // com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(204294);
        super.onCreate(bundle);
        Log.i("MicroMsg.GameWebTabUI", "onCreate");
        if (this.xwg == null) {
            finish();
            AppMethodBeat.o(204294);
            return;
        }
        this.xWR = a.b(this, this.xwg.ctl);
        this.xXI = (GameTabData2) getIntent().getParcelableExtra("game_tab_data");
        this.xXH = getIntent().getStringExtra("game_tab_key");
        if (this.xXI != null) {
            for (final GameTabData2.TabItem tabItem : this.xXI.avn()) {
                if (tabItem.dLS == 2 && !Util.isNullOrNil(tabItem.jumpUrl) && !tabItem.xHB.equalsIgnoreCase(this.xXH) && !tabItem.xXk) {
                    this.xwg.ctl.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(204276);
                            if (GameWebTabUI.this.isFinishing() || GameWebTabUI.this.isDestroyed()) {
                                AppMethodBeat.o(204276);
                                return;
                            }
                            GameWebTabUI.a(GameWebTabUI.this, tabItem);
                            AppMethodBeat.o(204276);
                        }
                    }, (long) (tabItem.xXl * 1000));
                }
            }
        }
        this.xwg.cts.LA().cDn = this;
        if (this.xwg.ctl instanceof ViewGroup) {
            final FrameLayout frameLayout = this.xwg.ctl;
            frameLayout.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
                /* class com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI.AnonymousClass5 */

                public final void onChildViewAdded(View view, View view2) {
                    AppMethodBeat.i(204286);
                    if ((view2.getTag() instanceof String) && "game_float_view_tag".equalsIgnoreCase((String) view2.getTag())) {
                        int indexOfChild = frameLayout.indexOfChild(view2);
                        Log.i("MicroMsg.GameWebTabUI", "float page index2:%d", Integer.valueOf(indexOfChild));
                        if (indexOfChild >= 0) {
                            frameLayout.removeView(GameWebTabUI.this.xWR);
                            frameLayout.addView(GameWebTabUI.this.xWR, indexOfChild - 1);
                        }
                    }
                    AppMethodBeat.o(204286);
                }

                public final void onChildViewRemoved(View view, View view2) {
                }
            });
            int indexOfChild = frameLayout.indexOfChild(frameLayout.findViewWithTag("game_float_view_tag"));
            Log.i("MicroMsg.GameWebTabUI", "float page index1:%d", Integer.valueOf(indexOfChild));
            if (indexOfChild >= 0) {
                frameLayout.removeView(this.xWR);
                frameLayout.addView(this.xWR, indexOfChild);
            }
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.game.ACTION_EXIT");
        registerReceiver(this.xWV, intentFilter, com.tencent.mm.plugin.game.a.xtn, null);
        h.a(MainProcessIPCService.dkO, new IPCInteger(1), a.class, this.xXK);
        AppMethodBeat.o(204294);
    }

    @Override // com.tencent.luggage.h.f.a
    public final boolean Pg() {
        AppMethodBeat.i(204295);
        a.gk(this);
        AppMethodBeat.o(204295);
        return true;
    }

    @Override // com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI
    public final void dTn() {
        AppMethodBeat.i(204296);
        a.gk(this);
        AppMethodBeat.o(204296);
    }

    @Override // com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI
    public final void dTo() {
        AppMethodBeat.i(204297);
        super.dTo();
        if (this.xwj != null) {
            this.xwj.xxS = new f.a() {
                /* class com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.game.luggage.g.f.a
                public final void Oa(final int i2) {
                    AppMethodBeat.i(204279);
                    Log.i("MicroMsg.GameWebTabUI", "showGameTab, isShowTab:%d", Integer.valueOf(i2));
                    com.tencent.f.h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(204278);
                            if (i2 == 0) {
                                GameWebTabUI.this.xWR.setVisibility(8);
                                AppMethodBeat.o(204278);
                                return;
                            }
                            if (i2 == 1) {
                                GameWebTabUI.this.xWR.setVisibility(0);
                            }
                            AppMethodBeat.o(204278);
                        }
                    });
                    AppMethodBeat.o(204279);
                }

                @Override // com.tencent.mm.plugin.game.luggage.g.f.a
                public final int dTE() {
                    AppMethodBeat.i(204280);
                    int height = GameWebTabUI.this.xWR.getHeight();
                    int zB = g.zB(height);
                    Log.i("MicroMsg.GameWebTabUI", "tabHeight:%d, heightInH5:%d", Integer.valueOf(height), Integer.valueOf(zB));
                    AppMethodBeat.o(204280);
                    return zB;
                }

                @Override // com.tencent.mm.plugin.game.luggage.g.f.a
                public final void Ob(int i2) {
                    AppMethodBeat.i(204281);
                    Log.i("MicroMsg.GameWebTabUI", "disableTabSwitch, isSwitchEnable:%d", Integer.valueOf(i2));
                    if (GameWebTabUI.this.xWR == null) {
                        AppMethodBeat.o(204281);
                    } else if (i2 == 0) {
                        GameWebTabUI.this.xWR.setTabSwitchEnable(false);
                        AppMethodBeat.o(204281);
                    } else {
                        if (i2 == 1) {
                            GameWebTabUI.this.xWR.setTabSwitchEnable(true);
                        }
                        AppMethodBeat.o(204281);
                    }
                }

                @Override // com.tencent.mm.plugin.game.luggage.g.f.a
                public final String dTF() {
                    AppMethodBeat.i(204282);
                    if (GameWebTabUI.this.xXI != null) {
                        String json = GameWebTabUI.this.xXI.toJson();
                        AppMethodBeat.o(204282);
                        return json;
                    }
                    AppMethodBeat.o(204282);
                    return "";
                }

                @Override // com.tencent.mm.plugin.game.luggage.g.f.a
                public final void setPageChanging(boolean z) {
                    AppMethodBeat.i(204283);
                    if (GameWebTabUI.this.xWR != null) {
                        GameWebTabUI.this.xWR.setPageChanging(z);
                    }
                    AppMethodBeat.o(204283);
                }

                @Override // com.tencent.mm.plugin.game.luggage.g.f.a
                public final boolean Lw() {
                    AppMethodBeat.i(204284);
                    if (GameWebTabUI.this.xWR != null) {
                        boolean z = GameWebTabUI.this.xWR.xXs;
                        AppMethodBeat.o(204284);
                        return z;
                    }
                    AppMethodBeat.o(204284);
                    return true;
                }
            };
        }
        AppMethodBeat.o(204297);
    }

    private void a(GameTabData2.TabItem tabItem, boolean z) {
        AppMethodBeat.i(204298);
        if (tabItem == null || this.xwj == null) {
            AppMethodBeat.o(204298);
            return;
        }
        com.tencent.mm.plugin.game.luggage.g.f fVar = this.xwj;
        String str = tabItem.xHB;
        String str2 = tabItem.jumpUrl;
        if (!Util.isNullOrNil(str) && !Util.isNullOrNil(str2) && !fVar.xxQ.containsKey(str) && fVar.xxT != null) {
            Log.i("MicroMsg.GameTabWebPage", "insertTabHomeWeb, tabKey:%s, url:%s", str, str2);
            Bundle bundle = new Bundle();
            bundle.putAll(fVar.mParams);
            bundle.putString("rawUrl", str2);
            i iVar = new i(fVar.ctg, null, bundle);
            if (iVar.gbC() != null) {
                iVar.gbC().gbW();
            }
            iVar.xyT = fVar;
            iVar.xyU = z;
            if (fVar.pQZ != null && fVar.pQZ.isPaused() && z) {
                iVar.xyW = true;
                Log.i("MicroMsg.GameTabWebPage", "mockFetchFcp, url:%s", str2);
            }
            fVar.a(iVar, str);
            fVar.xxT.addView(iVar.mContentView, 0, new FrameLayout.LayoutParams(-1, -1));
            iVar.g(str2, bundle);
            fVar.xxQ.put(str, iVar);
        }
        Log.i("MicroMsg.GameWebTabUI", "Preload tabItem[key:%s, url:%s, isPreload:%b]", tabItem.xHB, tabItem.jumpUrl, Boolean.valueOf(z));
        AppMethodBeat.o(204298);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        i iVar;
        AppMethodBeat.i(204299);
        super.onNewIntent(intent);
        overridePendingTransition(R.anim.cd, R.anim.cd);
        Log.i("MicroMsg.GameWebTabUI", "onNewIntent");
        if (intent == null) {
            AppMethodBeat.o(204299);
            return;
        }
        setIntent(intent);
        String stringExtra = intent.getStringExtra("game_tab_key");
        if (Util.nullAsNil(this.xXH).equalsIgnoreCase(stringExtra)) {
            AppMethodBeat.o(204299);
            return;
        }
        this.xXH = stringExtra;
        String stringExtra2 = intent.getStringExtra("game_red_dot_tab_key");
        if (this.xWR != null) {
            this.xWR.hP(stringExtra, stringExtra2);
        }
        if (this.xXI == null || this.xwj == null) {
            AppMethodBeat.o(204299);
            return;
        }
        a((GameTabData2.TabItem) this.xXI.xWX.get(stringExtra), false);
        com.tencent.mm.plugin.game.luggage.g.f fVar = this.xwj;
        if (!Util.isNullOrNil(stringExtra) && (iVar = fVar.xxQ.get(stringExtra)) != null) {
            Log.i("MicroMsg.GameTabWebPage", "switch to tab: %s", stringExtra);
            if (!(iVar instanceof com.tencent.mm.plugin.game.luggage.g.f) || fVar.xxU == null) {
                iVar.mContentView.bringToFront();
            } else {
                fVar.xxU.bringToFront();
            }
            fVar.xxV = iVar;
        }
        if (this.xWR != null) {
            this.xWR.bringToFront();
        }
        AppMethodBeat.o(204299);
    }

    @Override // com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(204300);
        super.onResume();
        if (!this.xXJ) {
            h.a(MainProcessIPCService.dkO, new IPCInteger(3), a.class, this.xXK);
        }
        this.xXJ = false;
        AppMethodBeat.o(204300);
    }

    @Override // com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(204301);
        super.onDestroy();
        Log.i("MicroMsg.GameWebTabUI", "onDestroy");
        unregisterReceiver(this.xWV);
        h.a(MainProcessIPCService.dkO, new IPCInteger(2), a.class, null);
        a.gk(this);
        AppMethodBeat.o(204301);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(204302);
        super.onConfigurationChanged(configuration);
        if (this.pzw != configuration.orientation) {
            Log.i("MicroMsg.GameWebTabUI", "orientation:%d", Integer.valueOf(configuration.orientation));
            if (this.xWR != null) {
                this.xWR.dWE();
            }
            this.pzw = configuration.orientation;
        }
        AppMethodBeat.o(204302);
    }

    static class a implements b<IPCInteger, Bundle> {
        private MStorage.IOnStorageChange xWT = new MStorage.IOnStorageChange() {
            /* class com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI.a.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
            public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                AppMethodBeat.i(204287);
                if ((mStorageEventData.obj instanceof com.tencent.mm.plugin.gamelife.e.a) && a.this.xXQ != null) {
                    a.this.xXQ.bn(a.dWG());
                }
                AppMethodBeat.o(204287);
            }
        };
        private com.tencent.mm.pluginsdk.c.a xWU = new com.tencent.mm.pluginsdk.c.a() {
            /* class com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI.a.AnonymousClass2 */

            @Override // com.tencent.mm.pluginsdk.c.a
            public final void g(IEvent iEvent) {
                AppMethodBeat.i(204288);
                if ((iEvent instanceof iy) && a.this.xXQ != null) {
                    a.this.xXQ.bn(a.dWG());
                }
                AppMethodBeat.o(204288);
            }
        };
        private d<Bundle> xXQ;

        private a() {
            AppMethodBeat.i(204289);
            AppMethodBeat.o(204289);
        }

        static /* synthetic */ Bundle dWG() {
            AppMethodBeat.i(204292);
            Bundle dWF = dWF();
            AppMethodBeat.o(204292);
            return dWF;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x0028  */
        @Override // com.tencent.mm.ipcinvoker.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ void invoke(com.tencent.mm.ipcinvoker.type.IPCInteger r8, com.tencent.mm.ipcinvoker.d<android.os.Bundle> r9) {
            /*
            // Method dump skipped, instructions count: 116
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI.a.invoke(java.lang.Object, com.tencent.mm.ipcinvoker.d):void");
        }

        private static Bundle dWF() {
            AppMethodBeat.i(204290);
            int dWZ = ((c) com.tencent.mm.kernel.g.af(c.class)).dWZ();
            int NY = ((com.tencent.mm.plugin.game.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.c.class)).NY(1);
            int NY2 = ((com.tencent.mm.plugin.game.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.c.class)).NY(2);
            Bundle bundle = new Bundle();
            bundle.putInt("msg_unread_count", dWZ + NY);
            bundle.putInt("notify_unread_count", NY2);
            AppMethodBeat.o(204290);
            return bundle;
        }
    }

    static /* synthetic */ void a(GameWebTabUI gameWebTabUI, int i2, int i3) {
        boolean z = true;
        AppMethodBeat.i(204304);
        Log.d("MicroMsg.GameWebTabUI", "get unread count: %d", Integer.valueOf(i2));
        if (gameWebTabUI.xWR != null) {
            GameTabWidget2 gameTabWidget2 = gameWebTabUI.xWR;
            if (i3 <= 0) {
                z = false;
            }
            gameTabWidget2.aA(i2, z);
        }
        AppMethodBeat.o(204304);
    }
}
