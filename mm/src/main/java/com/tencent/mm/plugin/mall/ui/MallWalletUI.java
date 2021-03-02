package com.tencent.mm.plugin.mall.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.xo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mall.a.j;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.csv;
import com.tencent.mm.protocal.protobuf.csw;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.egg;
import com.tencent.mm.protocal.protobuf.ehc;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MallWalletUI extends WalletBaseUI implements MStorageEx.IOnStorageChange {
    private static final int zmZ = a.fromDPToPix(MMApplicationContext.getContext(), 8);
    private Dialog mProgressDialog;
    private boolean zio = false;
    private LinearLayout zna;
    private LinearLayout znb;
    private egg znc;
    private Dialog znd;
    private j.a zne;
    private boolean znf = false;
    private IListener<xo> zng = new IListener<xo>() {
        /* class com.tencent.mm.plugin.mall.ui.MallWalletUI.AnonymousClass1 */

        {
            AppMethodBeat.i(162268);
            this.__eventId = xo.class.getName().hashCode();
            AppMethodBeat.o(162268);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xo xoVar) {
            AppMethodBeat.i(162269);
            xo xoVar2 = xoVar;
            if (!(xoVar2 == null || xoVar2.edO == null || !Util.isEqual(xoVar2.edO.viewId, "fqf_cell"))) {
                Log.i("MicroMsg.MallWalletUI", "%s click", xoVar2.edO.viewId);
                MallWalletUI.this.znf = true;
            }
            AppMethodBeat.o(162269);
            return false;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallWalletUI() {
        AppMethodBeat.i(162275);
        AppMethodBeat.o(162275);
    }

    static /* synthetic */ void a(MallWalletUI mallWalletUI, boolean z) {
        AppMethodBeat.i(162276);
        mallWalletUI.is(z);
        AppMethodBeat.o(162276);
    }

    static {
        AppMethodBeat.i(66181);
        AppMethodBeat.o(66181);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(66170);
        fixStatusbar(true);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.kz));
        hideActionbarLine();
        setMMTitle("");
        initView();
        ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
        this.zne = new j.a() {
            /* class com.tencent.mm.plugin.mall.ui.MallWalletUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.mall.a.j.a
            public final void b(dil dil) {
                AppMethodBeat.i(162272);
                Log.i("MicroMsg.MallWalletUI", "cache callback");
                if (MallWalletUI.this.mProgressDialog != null) {
                    MallWalletUI.this.mProgressDialog.dismiss();
                    MallWalletUI.this.mProgressDialog = null;
                }
                MallWalletUI.this.znc = dil.MMX;
                MallWalletUI.a(MallWalletUI.this, true);
                AppMethodBeat.o(162272);
            }

            @Override // com.tencent.mm.plugin.mall.a.j.a
            public final void c(final dil dil) {
                AppMethodBeat.i(162273);
                Log.i("MicroMsg.MallWalletUI", "net callback: %s", dil);
                if (MallWalletUI.this.mProgressDialog != null) {
                    MallWalletUI.this.mProgressDialog.dismiss();
                    MallWalletUI.this.mProgressDialog = null;
                }
                if (dil != null) {
                    if (dil.MMX != null) {
                        MallWalletUI.this.znc = dil.MMX;
                        MallWalletUI.a(MallWalletUI.this, false);
                    }
                    if (dil.KEP != null && dil.KEP.type == 13) {
                        MallWalletUI.this.runOnUiThread(new Runnable() {
                            /* class com.tencent.mm.plugin.mall.ui.MallWalletUI.AnonymousClass2.AnonymousClass1 */

                            /* JADX DEBUG: Multi-variable search result rejected for r6v22, resolved type: com.tencent.mm.ui.widget.MMSwitchBtn */
                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARNING: Removed duplicated region for block: B:111:0x00f3 A[SYNTHETIC] */
                            /* JADX WARNING: Removed duplicated region for block: B:49:0x01b2  */
                            /* JADX WARNING: Removed duplicated region for block: B:64:0x02b2  */
                            /* JADX WARNING: Removed duplicated region for block: B:69:0x02c8  */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void run() {
                                /*
                                // Method dump skipped, instructions count: 934
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mall.ui.MallWalletUI.AnonymousClass2.AnonymousClass1.run():void");
                            }
                        });
                    }
                }
                AppMethodBeat.o(162273);
            }
        };
        Y(true, true);
        this.zng.alive();
        AppMethodBeat.o(66170);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b6d;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(66171);
        this.zna = (LinearLayout) findViewById(R.id.fsm);
        this.znb = (LinearLayout) findViewById(R.id.fsl);
        AppMethodBeat.o(66171);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(66172);
        super.onResume();
        if (this.znf) {
            Log.i("MicroMsg.MallWalletUI", "fenfu refresh");
            this.znf = false;
            Y(false, false);
        }
        AppMethodBeat.o(66172);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(66173);
        super.onPause();
        AppMethodBeat.o(66173);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(66174);
        super.onDestroy();
        this.zng.dead();
        j.a(this.zne);
        ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
        AppMethodBeat.o(66174);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(66175);
        Log.i("MicroMsg.MallWalletUI", "requestCode: %s, resultCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 65281 || i2 == 65286) {
            Y(false, false);
            AppMethodBeat.o(66175);
            return;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(66175);
    }

    private void Y(boolean z, boolean z2) {
        AppMethodBeat.i(66176);
        Log.i("MicroMsg.MallWalletUI", "do query wechat wallet");
        if (z2) {
            this.mProgressDialog = h.c(this, false, null);
        }
        j.a(this.zne, true, z);
        AppMethodBeat.o(66176);
    }

    private void is(boolean z) {
        AppMethodBeat.i(66177);
        if (this.znc != null) {
            csv csv = this.znc.Ngk;
            if (csv != null) {
                setMMTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(this, csv.KEN, (g.a) null));
                csw csw = csv.MxU;
                AnonymousClass3 r2 = new g.a() {
                    /* class com.tencent.mm.plugin.mall.ui.MallWalletUI.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.wallet_core.utils.g.a
                    public final void a(dqe dqe) {
                        AppMethodBeat.i(66169);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16502, 1);
                        AppMethodBeat.o(66169);
                    }
                };
                if (!(csw == null || csw.type != 2 || csw.Lov == null)) {
                    addTextOptionMenu(0, com.tencent.mm.plugin.wallet_core.utils.g.a(this, csw.Lov), new MenuItem.OnMenuItemClickListener(csw, r2, this) {
                        /* class com.tencent.mm.plugin.wallet_core.utils.g.AnonymousClass7 */
                        final /* synthetic */ a IoY;
                        final /* synthetic */ csw Ipc;
                        final /* synthetic */ MMActivity val$activity;

                        {
                            this.Ipc = r1;
                            this.IoY = r2;
                            this.val$activity = r3;
                        }

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            AppMethodBeat.i(71657);
                            ehf ehf = this.Ipc.Lov;
                            ArrayList<dqe> arrayList = new ArrayList();
                            if (!(ehf == null || ehf.NgT == null || ehf.NgT.isEmpty())) {
                                Iterator<ehc> it = ehf.NgT.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(it.next().KEP);
                                }
                            }
                            for (dqe dqe : arrayList) {
                                if (this.IoY != null) {
                                    new Object[1][0] = menuItem;
                                    g.a(this.val$activity, dqe, (Bundle) null);
                                    a aVar = this.IoY;
                                    new Object[1][0] = menuItem;
                                    aVar.a(dqe);
                                } else {
                                    g.a(this.val$activity, dqe, (Bundle) null);
                                }
                            }
                            AppMethodBeat.o(71657);
                            return false;
                        }
                    });
                }
            }
            Log.i("MicroMsg.MallWalletUI", "section size: %s", this.znc.MaA);
            int childCount = this.zna.getChildCount();
            int size = this.znc.MaA.size();
            for (int i2 = 0; i2 < size; i2++) {
                cdv cdv = this.znc.MaA.get(i2);
                if (i2 < childCount) {
                    Log.d("MicroMsg.MallWalletUI", "update layout");
                    ((MallWalletSectionView) this.zna.getChildAt(i2)).a(cdv, z);
                } else {
                    Log.d("MicroMsg.MallWalletUI", "insert layout");
                    MallWalletSectionView mallWalletSectionView = new MallWalletSectionView(getContext());
                    mallWalletSectionView.a(cdv, z);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.topMargin = zmZ;
                    mallWalletSectionView.setLayoutParams(layoutParams);
                    this.zna.addView(mallWalletSectionView, layoutParams);
                }
            }
            if (childCount > size) {
                Log.d("MicroMsg.MallWalletUI", "remove layout");
                this.zna.removeViews(size, childCount - size);
            }
            fv(this.znc.Ngl);
        }
        AppMethodBeat.o(66177);
    }

    private void fv(List<ehf> list) {
        AppMethodBeat.i(66178);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(66178);
            return;
        }
        this.znb.removeAllViews();
        int i2 = 0;
        list.size();
        for (ehf ehf : list) {
            TextView textView = new TextView(this);
            com.tencent.mm.plugin.wallet_core.utils.g.a(textView, ehf, new g.a() {
                /* class com.tencent.mm.plugin.mall.ui.MallWalletUI.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.wallet_core.utils.g.a
                public final void a(dqe dqe) {
                    int i2;
                    AppMethodBeat.i(162274);
                    String str = "";
                    if (dqe.type == 1) {
                        str = dqe.url;
                        i2 = 1;
                    } else if (dqe.type == 2 && dqe.MTh != null) {
                        str = dqe.MTh.username;
                        i2 = 2;
                    } else if (dqe.type == 4 || dqe.type == 5) {
                        str = dqe.url;
                        i2 = 3;
                    } else {
                        i2 = 0;
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16502, 2, str, Integer.valueOf(i2));
                    AppMethodBeat.o(162274);
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i2 != 0) {
                layoutParams.topMargin = a.fromDPToPix((Context) this, 8);
            }
            this.znb.addView(textView, layoutParams);
            i2++;
        }
        AppMethodBeat.o(66178);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(66179);
        if (mStorageEx == ((com.tencent.mm.plugin.wxpay.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg() && i2 == 4) {
            Log.i("MicroMsg.MallWalletUI", "on cache update: %s", obj);
            if (obj.equals("USERINFO_NEW_BALANCE_LONG") || obj.equals("USERINFO_NEW_LQT_LONG")) {
                is(false);
            }
        }
        AppMethodBeat.o(66179);
    }
}
