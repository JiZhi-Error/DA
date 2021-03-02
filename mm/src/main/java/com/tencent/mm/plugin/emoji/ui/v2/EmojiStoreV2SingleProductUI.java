package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.d;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.f.j;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.v2.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.aiw;
import com.tencent.mm.protocal.protobuf.bmg;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.contact.LabelContainerView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.snackbar.b;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreV2SingleProductUI extends MMActivity implements AbsListView.OnScrollListener, i {
    private View agA;
    private String goe;
    private boolean isLoading = false;
    private ProgressDialog jZH;
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(109319);
            switch (message.what) {
                case 1001:
                    if (EmojiStoreV2SingleProductUI.this.rmi != null) {
                        EmojiStoreV2SingleProductUI.this.rmi.setVisibility(8);
                        AppMethodBeat.o(109319);
                        return;
                    }
                    break;
                case 1002:
                    if (EmojiStoreV2SingleProductUI.this.rmi != null) {
                        EmojiStoreV2SingleProductUI.this.rmi.setVisibility(0);
                    }
                    sendEmptyMessage(1003);
                    AppMethodBeat.o(109319);
                    return;
                case 1004:
                    EmojiStoreV2SingleProductUI.b(EmojiStoreV2SingleProductUI.this);
                    break;
            }
            AppMethodBeat.o(109319);
        }
    };
    private int mScene;
    private long rbH;
    private String rcQ;
    private String rcS;
    private int rjT = 0;
    private MMPullDownView rks;
    private j rku;
    private int rlV;
    private String rlW;
    private int rlX = -1;
    private String rlY;
    private String rlZ;
    private String rma;
    private String rmb;
    private String rmc;
    private int rmd = 0;
    private PreViewListGridView rme;
    private a rmf;
    private View rmg;
    private TextView rmh;
    private View rmi;
    private boolean rmj = true;
    private bmg rmk;
    private byte[] rml;
    private int rmm = -1;
    private String rmn;
    private LabelContainerView rmo;
    private TextView rmp;
    private MMTagPanel rmq;
    private HashMap<String, Integer> rmr = new HashMap<>();
    private ArrayList<String> rms;
    private boolean rmt = false;
    private IListener rmu = new IListener<dm>() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.AnonymousClass6 */

        {
            AppMethodBeat.i(161096);
            this.__eventId = dm.class.getName().hashCode();
            AppMethodBeat.o(161096);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dm dmVar) {
            AppMethodBeat.i(109325);
            if (!(EmojiStoreV2SingleProductUI.this.rmf == null || EmojiStoreV2SingleProductUI.this.mHandler == null)) {
                EmojiStoreV2SingleProductUI.this.mHandler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.AnonymousClass6.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(109324);
                        EmojiStoreV2SingleProductUI.this.rmf.notifyDataSetInvalidated();
                        AppMethodBeat.o(109324);
                    }
                });
            }
            AppMethodBeat.o(109325);
            return false;
        }
    };
    private MMPullDownView.e rmv = new MMPullDownView.e() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.AnonymousClass7 */

        @Override // com.tencent.mm.ui.base.MMPullDownView.e
        public final boolean cAj() {
            AppMethodBeat.i(109326);
            Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "onBottom");
            EmojiStoreV2SingleProductUI.e(EmojiStoreV2SingleProductUI.this);
            AppMethodBeat.o(109326);
            return true;
        }
    };
    private MMPullDownView.c rmw = new MMPullDownView.c() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.AnonymousClass8 */

        @Override // com.tencent.mm.ui.base.MMPullDownView.c
        public final boolean cAl() {
            return false;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreV2SingleProductUI() {
        AppMethodBeat.i(109334);
        AppMethodBeat.o(109334);
    }

    static /* synthetic */ void b(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        AppMethodBeat.i(109353);
        emojiStoreV2SingleProductUI.amZ();
        AppMethodBeat.o(109353);
    }

    static /* synthetic */ void e(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        AppMethodBeat.i(109354);
        emojiStoreV2SingleProductUI.cIg();
        AppMethodBeat.o(109354);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a3g;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x020e, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r9.rcS) != false) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0214, code lost:
        if (r9.rjT == 0) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x021a, code lost:
        if (r9.rlV == 0) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0224, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r9.rcQ) != false) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x022a, code lost:
        if (r9.rlX == 0) goto L_0x0111;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0231  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r10) {
        /*
        // Method dump skipped, instructions count: 612
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(109336);
        super.onResume();
        EventCenter.instance.addListener(this.rmu);
        AppMethodBeat.o(109336);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(109337);
        super.onPause();
        EventCenter.instance.removeListener(this.rmu);
        AppMethodBeat.o(109337);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109338);
        g.aAg().hqi.b(TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, this);
        g.aAg().hqi.b(d.CTRL_INDEX, this);
        super.onDestroy();
        AppMethodBeat.o(109338);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(109339);
        switch (i2) {
            case 2002:
                if (i3 == -1) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!Util.isNullOrNil(stringExtra)) {
                        Log.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "..".concat(String.valueOf(stringExtra)));
                        int i4 = this.rlX;
                        String str = this.rlY;
                        String str2 = this.rma;
                        String str3 = this.rlZ;
                        String str4 = this.rmb;
                        int i5 = this.rmd;
                        k.cGf();
                        com.tencent.mm.plugin.emoji.e.j.a(this, stringExtra, 27, i4, str, str2, str3, str4, i5, f.cFI());
                        break;
                    }
                }
                break;
            case 5001:
                if (i3 == -1) {
                    b.r(this, getContext().getString(R.string.yt));
                    break;
                }
                break;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(109339);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109340);
        if (this.rmd != 6 || Util.isNullOrNil(this.rlY)) {
            setMMTitle(R.string.buz);
        } else {
            setMMTitle(this.rlY);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.AnonymousClass9 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109327);
                if (EmojiStoreV2SingleProductUI.this.rmo == null || EmojiStoreV2SingleProductUI.this.rmo.getVisibility() != 0) {
                    EmojiStoreV2SingleProductUI.this.finish();
                } else {
                    EmojiStoreV2SingleProductUI.this.rmo.setVisibility(8);
                    EmojiStoreV2SingleProductUI.this.showOptionMenu(1001, EmojiStoreV2SingleProductUI.this.rmj);
                    EmojiStoreV2SingleProductUI.this.setMMTitle(R.string.buz);
                }
                AppMethodBeat.o(109327);
                return false;
            }
        });
        this.rmf = new a(getContext());
        this.rmf.rni = new a.AbstractC0964a() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.AnonymousClass10 */

            @Override // com.tencent.mm.plugin.emoji.ui.v2.a.AbstractC0964a
            public final void FP(int i2) {
                ait Gg;
                AppMethodBeat.i(109328);
                if (!(EmojiStoreV2SingleProductUI.this.rme == null || EmojiStoreV2SingleProductUI.this.rmf == null || (Gg = EmojiStoreV2SingleProductUI.this.rmf.Gg(i2)) == null)) {
                    try {
                        Intent intent = new Intent();
                        intent.putExtra("Select_Conv_User", EmojiStoreV2SingleProductUI.this.goe);
                        intent.putExtra("extra_object", Gg.toByteArray());
                        intent.putExtra("scene", EmojiStoreV2SingleProductUI.this.mScene);
                        intent.putExtra("searchID", EmojiStoreV2SingleProductUI.this.rbH);
                        intent.putExtra("add_source", 5);
                        intent.putExtra("entrance_scene", 29);
                        intent.setClass(EmojiStoreV2SingleProductUI.this.getContext(), EmojiStoreV2SingleProductDialogUI.class);
                        EmojiStoreV2SingleProductUI.this.startActivityForResult(intent, 5001);
                        EmojiStoreV2SingleProductUI.this.overridePendingTransition(R.anim.dd, R.anim.di);
                        h.INSTANCE.a(12787, Integer.valueOf(EmojiStoreV2SingleProductUI.this.mScene), 0, Gg.Md5, Long.valueOf(EmojiStoreV2SingleProductUI.this.rbH), Gg.Lsl, Gg.ProductID, 29);
                        AppMethodBeat.o(109328);
                        return;
                    } catch (Exception e2) {
                    }
                }
                AppMethodBeat.o(109328);
            }
        };
        this.rme = (PreViewListGridView) findViewById(R.id.ecm);
        this.agA = aa.jQ(getContext()).inflate(R.layout.a33, (ViewGroup) null);
        this.rmg = this.agA.findViewById(R.id.c0e);
        this.rmh = (TextView) this.agA.findViewById(R.id.c25);
        this.rme.addHeaderView(this.agA);
        this.rmi = aa.jQ(getContext()).inflate(R.layout.a2q, (ViewGroup) null);
        this.rme.addFooterView(this.rmi);
        this.rmi.setVisibility(8);
        this.rme.setAdapter((ListAdapter) this.rmf);
        this.rme.setOnScrollListener(this);
        this.rks = (MMPullDownView) findViewById(R.id.ep3);
        this.rks.setTopViewVisible(false);
        this.rks.setOnBottomLoadDataListener(this.rmv);
        this.rks.setAtBottomCallBack(this.rmw);
        this.rks.setBottomViewVisible(false);
        this.rks.setIsBottomShowAll(false);
        this.rks.setIsReturnSuperDispatchWhenCancel(true);
        this.rmo = (LabelContainerView) findViewById(R.id.hhh);
        this.rmp = (TextView) this.rmo.findViewById(16908310);
        this.rmp.setText(R.string.ebu);
        this.rmq = (MMTagPanel) this.rmo.findViewById(R.id.bcb);
        this.rmq.setTagSelectedBG(R.drawable.ay9);
        this.rmq.setTagSelectedTextColorRes(R.color.afp);
        this.rmn = getString(R.string.bvr);
        this.rmo.setOnLabelContainerListener(new LabelContainerView.a() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.AnonymousClass11 */

            @Override // com.tencent.mm.ui.contact.LabelContainerView.a
            public final void cIi() {
                AppMethodBeat.i(109329);
                if (EmojiStoreV2SingleProductUI.this.rmo != null) {
                    EmojiStoreV2SingleProductUI.this.rmo.clearFocus();
                }
                EmojiStoreV2SingleProductUI.this.rmo.requestFocus();
                EmojiStoreV2SingleProductUI.this.rmo.setVisibility(8);
                EmojiStoreV2SingleProductUI.this.showOptionMenu(1001, EmojiStoreV2SingleProductUI.this.rmj);
                EmojiStoreV2SingleProductUI.this.setMMTitle(R.string.buz);
                AppMethodBeat.o(109329);
            }

            @Override // com.tencent.mm.ui.contact.LabelContainerView.a
            public final void cIj() {
                AppMethodBeat.i(109330);
                EmojiStoreV2SingleProductUI.this.hideVKB();
                AppMethodBeat.o(109330);
            }
        });
        this.rmq.setCallBack(new MMTagPanel.a() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.AnonymousClass12 */

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void anb(String str) {
                AppMethodBeat.i(109331);
                if (!Util.isNullOrNil(EmojiStoreV2SingleProductUI.this.rmn) && !Util.isNullOrNil(str) && str.equals(EmojiStoreV2SingleProductUI.this.rmn)) {
                    EmojiStoreV2SingleProductUI.this.rmq.dn(EmojiStoreV2SingleProductUI.this.rmn, true);
                }
                AppMethodBeat.o(109331);
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void anc(String str) {
                AppMethodBeat.i(109332);
                EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this, str);
                AppMethodBeat.o(109332);
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void and(String str) {
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void E(boolean z, int i2) {
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void cIk() {
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void ane(String str) {
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void anf(String str) {
            }
        });
        addIconOptionMenu(1001, R.drawable.bw4, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.AnonymousClass13 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109333);
                if (EmojiStoreV2SingleProductUI.this.rmo != null) {
                    EmojiStoreV2SingleProductUI.this.rmo.setVisibility(0);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(EmojiStoreV2SingleProductUI.this.rmn);
                    EmojiStoreV2SingleProductUI.this.rmq.a(arrayList, EmojiStoreV2SingleProductUI.this.rms);
                    EmojiStoreV2SingleProductUI.this.setMMTitle(R.string.bvm);
                    EmojiStoreV2SingleProductUI.this.showOptionMenu(1001, false);
                    h.INSTANCE.kvStat(12788, "1");
                }
                AppMethodBeat.o(109333);
                return false;
            }
        });
        addIconOptionMenu(1002, R.raw.icons_outlined_share, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109320);
                Log.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "on shard click.");
                EmojiStoreV2SingleProductUI.o(EmojiStoreV2SingleProductUI.this);
                AppMethodBeat.o(109320);
                return true;
            }
        });
        showOptionMenu(1001, false);
        showOptionMenu(1002, false);
        AppMethodBeat.o(109340);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(109341);
        if (this.rmo == null || this.rmo.getVisibility() != 0) {
            super.onBackPressed();
            AppMethodBeat.o(109341);
            return;
        }
        this.rmo.setVisibility(8);
        showOptionMenu(1001, this.rmj);
        setMMTitle(R.string.buz);
        AppMethodBeat.o(109341);
    }

    private void amZ() {
        AppMethodBeat.i(109342);
        if (this.rmt) {
            Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to update page.");
            AppMethodBeat.o(109342);
            return;
        }
        this.rml = null;
        switch (this.rmd) {
            case 1:
                this.rmk = k.getEmojiStorageMgr().OpT.bls(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                if (this.rmk == null || this.rmk.LVc == null || this.rmf == null) {
                    amY(getString(R.string.a06));
                } else {
                    a(this.rmk);
                    this.rmf.ad(this.rmk.LVc);
                }
                this.rmj = true;
                h.INSTANCE.a(12875, 0, "");
                break;
            case 2:
            case 3:
                showOptionMenu(1001, false);
                this.rmj = false;
                h.INSTANCE.a(12875, 1, this.rcS);
                break;
            case 4:
                showOptionMenu(1001, false);
                this.rmn = this.rlW;
                ana(this.rmn);
                this.rmj = false;
                h.INSTANCE.a(12875, 1, "");
                break;
            case 5:
                this.rmn = "";
                ana(this.rcQ);
                this.rmj = false;
                h.INSTANCE.a(12875, 2, "");
                break;
            case 6:
                this.rmn = "";
                showOptionMenu(1001, false);
                showOptionMenu(1002, true);
                h.INSTANCE.a(12875, 3, "");
                break;
        }
        bs(this.rml);
        AppMethodBeat.o(109342);
    }

    private void amY(String str) {
        AppMethodBeat.i(109343);
        if (isFinishing()) {
            Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[showLoadingDialog] acitivity is finished.");
            AppMethodBeat.o(109343);
            return;
        }
        getString(R.string.zb);
        this.jZH = com.tencent.mm.ui.base.h.a((Context) this, str, true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(109321);
                if (EmojiStoreV2SingleProductUI.this.rku != null) {
                    g.aAg().hqi.a(EmojiStoreV2SingleProductUI.this.rku);
                }
                AppMethodBeat.o(109321);
            }
        });
        AppMethodBeat.o(109343);
    }

    private void cGW() {
        AppMethodBeat.i(109344);
        if (this.jZH != null && this.jZH.isShowing()) {
            this.jZH.dismiss();
        }
        AppMethodBeat.o(109344);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void bs(byte[] bArr) {
        AppMethodBeat.i(109345);
        this.rml = null;
        switch (this.rmd) {
            case 1:
                g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.i(1, this.rjT, this.rlV, this.rcQ, this.rlX, bArr), 0);
                AppMethodBeat.o(109345);
                return;
            case 2:
            case 3:
                g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.i(2, this.rjT, this.rlV, this.rcQ, this.rlX, bArr), 0);
                AppMethodBeat.o(109345);
                return;
            case 4:
                g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.i(3, this.rjT, this.rlV, this.rcQ, this.rlX, bArr), 0);
                AppMethodBeat.o(109345);
                return;
            case 5:
                g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.i(4, this.rjT, this.rlV, this.rcQ, this.rlX, bArr), 0);
                AppMethodBeat.o(109345);
                return;
            case 6:
                g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.i(5, this.rjT, this.rlV, this.rcQ, this.rlX, bArr), 0);
                break;
        }
        AppMethodBeat.o(109345);
    }

    private void a(bmg bmg) {
        boolean z = false;
        AppMethodBeat.i(109346);
        if (bmg == null || bmg.LVd == null || bmg.LVd.size() <= 0) {
            showOptionMenu(1001, false);
        } else {
            if (this.rmj) {
                z = true;
            }
            showOptionMenu(1001, z);
            if (this.rmq != null) {
                if (this.rms == null) {
                    this.rms = new ArrayList<>();
                } else {
                    this.rms.clear();
                }
                if (this.rmr == null) {
                    this.rmr = new HashMap<>();
                }
                this.rmr.clear();
                this.rms.add(getString(R.string.bvr));
                Iterator<aiw> it = bmg.LVd.iterator();
                while (it.hasNext()) {
                    aiw next = it.next();
                    if (next != null && !Util.isNullOrNil(next.Lsu)) {
                        this.rms.add(next.Lsu);
                        this.rmr.put(next.Lsu, Integer.valueOf(next.Lst));
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.rmn);
                this.rmq.a(arrayList, this.rms);
                AppMethodBeat.o(109346);
                return;
            }
        }
        AppMethodBeat.o(109346);
    }

    private void ana(String str) {
        AppMethodBeat.i(109347);
        if (!(this.rmg == null || this.rmh == null)) {
            switch (this.rmd) {
                case 4:
                    if (!Util.isNullOrNil(str)) {
                        this.rmh.setText(getString(R.string.bvs, new Object[]{str}));
                        this.rmh.setVisibility(0);
                        this.rmg.setVisibility(0);
                        break;
                    }
                    break;
                case 5:
                    if (!Util.isNullOrNil(str)) {
                        this.rmh.setText(getString(R.string.bvn, new Object[]{str}));
                        this.rmh.setVisibility(0);
                        this.rmg.setVisibility(0);
                        break;
                    }
                    break;
            }
            if (Util.isNullOrNil(str)) {
                this.rmh.setText("");
                this.rmh.setVisibility(8);
                this.rmg.setVisibility(8);
            }
        }
        AppMethodBeat.o(109347);
    }

    private void cIg() {
        AppMethodBeat.i(109348);
        if (!this.isLoading) {
            bs(this.rml);
            this.isLoading = true;
            this.mHandler.sendEmptyMessageDelayed(1002, 200);
        }
        AppMethodBeat.o(109348);
    }

    private void aa(LinkedList<ait> linkedList) {
        AppMethodBeat.i(109349);
        if (!(this.rmf == null || linkedList == null)) {
            if (this.rmm == -1) {
                this.rmf.ad(linkedList);
                AppMethodBeat.o(109349);
                return;
            }
            a aVar = this.rmf;
            if (aVar.qXp == null) {
                aVar.qXp = new ArrayList();
            }
            aVar.qXp.addAll(linkedList);
            aVar.notifyDataSetChanged();
        }
        AppMethodBeat.o(109349);
    }

    private void cIh() {
        AppMethodBeat.i(109350);
        Toast.makeText(getContext(), getString(R.string.bwp), 0).show();
        AppMethodBeat.o(109350);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(109351);
        int type = qVar.getType();
        if (type == 821) {
            cGW();
            com.tencent.mm.plugin.emoji.f.i iVar = (com.tencent.mm.plugin.emoji.f.i) qVar;
            bmg cGs = iVar.cGs();
            this.isLoading = false;
            if (this.rmi != null) {
                this.rmi.setVisibility(8);
                this.mHandler.removeMessages(1002);
                this.mHandler.sendEmptyMessageDelayed(1001, 200);
            }
            int i4 = iVar.kfa;
            if (((i2 == 0 && i3 == 0) || (i2 == 4 && (i3 == 2 || i3 == 3))) && ((this.rml == null || this.rml.length <= 0) && i4 != 3)) {
                a(cGs);
            }
            if (i2 == 0 || i2 == 4) {
                this.rml = iVar.rcO;
                if (i3 == 0) {
                    aa(cGs.LVc);
                    this.rmm = 0;
                    AppMethodBeat.o(109351);
                } else if (i3 == 2) {
                    aa(cGs.LVc);
                    this.rmm = 2;
                    AppMethodBeat.o(109351);
                } else if (i3 == 3) {
                    this.rmm = -1;
                    aa(cGs.LVc);
                    AppMethodBeat.o(109351);
                } else {
                    cIh();
                    AppMethodBeat.o(109351);
                }
            } else {
                cIh();
                AppMethodBeat.o(109351);
            }
        } else {
            if (type == 239) {
                cGW();
                if (i3 == 0 && i2 == 0) {
                    bmi cGt = ((j) qVar).cGt();
                    if (!(cGt == null || cGt.LVe == null)) {
                        this.rjT = cGt.LVe.DesignerUin;
                        if (this.mHandler != null) {
                            this.mHandler.sendEmptyMessage(1004);
                        }
                    }
                    AppMethodBeat.o(109351);
                    return;
                }
                showOptionMenu(1001, false);
                com.tencent.mm.ui.base.h.c(getContext(), getString(R.string.bs9), null, true);
                Log.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "open single product ui failed.");
            }
            AppMethodBeat.o(109351);
        }
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(109352);
        if (i2 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.rmm == 2 && !this.isLoading) {
            Log.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "No More List.");
            cIg();
            Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
        }
        if (!(i2 == 0 || this.rme == null)) {
            this.rme.cIq();
        }
        AppMethodBeat.o(109352);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void a(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI, String str) {
        AppMethodBeat.i(109355);
        emojiStoreV2SingleProductUI.setMMTitle(R.string.buz);
        emojiStoreV2SingleProductUI.showOptionMenu(1001, emojiStoreV2SingleProductUI.rmj);
        if (emojiStoreV2SingleProductUI.rmr == null || !emojiStoreV2SingleProductUI.rmr.containsKey(str)) {
            emojiStoreV2SingleProductUI.rml = null;
            emojiStoreV2SingleProductUI.rmm = -1;
            emojiStoreV2SingleProductUI.rmn = emojiStoreV2SingleProductUI.getString(R.string.bvr);
            emojiStoreV2SingleProductUI.rmd = 1;
            emojiStoreV2SingleProductUI.rlV = 0;
            emojiStoreV2SingleProductUI.bs(emojiStoreV2SingleProductUI.rml);
            emojiStoreV2SingleProductUI.ana("");
        } else {
            emojiStoreV2SingleProductUI.rmm = -1;
            emojiStoreV2SingleProductUI.rmn = str;
            emojiStoreV2SingleProductUI.rmd = 4;
            emojiStoreV2SingleProductUI.rlV = emojiStoreV2SingleProductUI.rmr.get(emojiStoreV2SingleProductUI.rmn).intValue();
            emojiStoreV2SingleProductUI.bs(null);
            emojiStoreV2SingleProductUI.ana(str);
        }
        if (emojiStoreV2SingleProductUI.rmo != null) {
            emojiStoreV2SingleProductUI.rmo.setVisibility(8);
        }
        AppMethodBeat.o(109355);
    }

    static /* synthetic */ void o(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        AppMethodBeat.i(109356);
        e eVar = new e((Context) emojiStoreV2SingleProductUI.getContext(), 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(109322);
                mVar.b(1001, EmojiStoreV2SingleProductUI.this.getString(R.string.btp), R.raw.bottomsheet_icon_transmit);
                mVar.b(1000, EmojiStoreV2SingleProductUI.this.getString(R.string.btq), R.raw.bottomsheet_icon_moment);
                AppMethodBeat.o(109322);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(109323);
                switch (menuItem.getItemId()) {
                    case 1001:
                        com.tencent.mm.plugin.emoji.e.j.eY(EmojiStoreV2SingleProductUI.this.getContext());
                        EmojiStoreV2SingleProductUI.this.getContext().overridePendingTransition(R.anim.dq, R.anim.bs);
                        h.INSTANCE.a(13224, 2, 2, "", Integer.valueOf(EmojiStoreV2SingleProductUI.this.rlX));
                        AppMethodBeat.o(109323);
                        return;
                    case 1000:
                        AppCompatActivity context = EmojiStoreV2SingleProductUI.this.getContext();
                        String str = EmojiStoreV2SingleProductUI.this.rlY;
                        String str2 = EmojiStoreV2SingleProductUI.this.rma;
                        String str3 = EmojiStoreV2SingleProductUI.this.rlZ;
                        k.cGf();
                        com.tencent.mm.plugin.emoji.e.j.a(context, str, str2, str3, f.cFI(), EmojiLogic.a(EmojiStoreV2SingleProductUI.this.rlX, EmojiStoreV2SingleProductUI.this.rlY, EmojiStoreV2SingleProductUI.this.rma, EmojiStoreV2SingleProductUI.this.rlZ, EmojiStoreV2SingleProductUI.this.rmb, EmojiStoreV2SingleProductUI.this.rmd), 12);
                        h.INSTANCE.a(13224, 2, 1, "", Integer.valueOf(EmojiStoreV2SingleProductUI.this.rlX));
                        break;
                }
                AppMethodBeat.o(109323);
            }
        };
        eVar.dGm();
        h.INSTANCE.a(13224, 2, 0, "", Integer.valueOf(emojiStoreV2SingleProductUI.rlX));
        AppMethodBeat.o(109356);
    }
}
