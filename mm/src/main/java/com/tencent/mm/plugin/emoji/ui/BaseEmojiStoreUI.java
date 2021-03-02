package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class BaseEmojiStoreUI extends EmojiBaseActivity implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, i, j.a, j.b, k.a, MStorage.IOnStorageChange, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e {
    private static Map<String, Long> rex;
    protected View GQ;
    private ProgressDialog jZH;
    public ListView mListView;
    private boolean mwr;
    public com.tencent.mm.plugin.emoji.a.a.a rbD;
    private c rbL;
    protected EmojiStoreVpHeader rdY;
    protected View rdZ;
    protected boolean reA = false;
    private LinkedList<EmotionBanner> reB = new LinkedList<>();
    private LinkedList<EmotionBannerSet> reC = new LinkedList<>();
    protected StoreBannerEmojiView rea;
    protected MMPullDownView reb;
    protected TextView rec;
    protected boolean red = false;
    int ree = -1;
    private View reg;
    protected byte[] reh;
    private final int rei = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY;
    private final int rej = 20001;
    private final int rek = 2002;
    protected final int rel = 131074;
    private final int rem = 131075;
    private final int ren = 131076;
    private final String reo = "product_id";
    private final String rep = "progress";
    private final String rer = "status";
    private o res;
    private int reu;
    private g rev;
    protected j rew;
    private IListener rey;
    protected h rez;

    /* access modifiers changed from: protected */
    public abstract int cGH();

    /* access modifiers changed from: protected */
    public abstract int cGI();

    /* access modifiers changed from: protected */
    public abstract com.tencent.mm.plugin.emoji.a.a.a cGJ();

    /* access modifiers changed from: protected */
    public abstract int cGQ();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rew = new j();
        initView();
        this.reu = getIntent().getIntExtra("preceding_scence", 2);
        if (com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO != null) {
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.add(this);
        }
        this.rey = new a(this, (byte) 0);
        EventCenter.instance.addListener(this.rey);
        this.rew.owO = this;
        this.rew.rbD = this.rbD;
        this.rew.rbG = cGH();
        this.rew.rbJ = this;
        boolean cGX = cGX();
        if (cGX) {
            cGX = cGV();
        }
        J(false, cGX);
        if (rex == null) {
            rex = new HashMap();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", Long.valueOf(currentTimeMillis));
        rex.put(getClass().toString(), Long.valueOf(currentTimeMillis));
        this.rbL = new c(1005);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        com.tencent.mm.kernel.g.aAg().hqi.a(411, this);
        com.tencent.mm.kernel.g.aAg().hqi.a(v2helper.EMethodSetNgStrength, this);
        com.tencent.mm.kernel.g.aAg().hqi.a(413, this);
        com.tencent.mm.kernel.g.aAg().hqi.a(717, this);
        if (cGN() && this.rdY != null) {
            this.rdY.cHN();
        }
        Boolean bool = Boolean.FALSE;
        this.rew.rbE = false;
        if (this.rbD != null && this.rbD.qXZ != null) {
            this.rbD.qXZ.cFq();
            this.rbD.refreshView();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        com.tencent.mm.kernel.g.aAg().hqi.b(411, this);
        com.tencent.mm.kernel.g.aAg().hqi.b(v2helper.EMethodSetNgStrength, this);
        com.tencent.mm.kernel.g.aAg().hqi.b(413, this);
        com.tencent.mm.kernel.g.aAg().hqi.b(717, this);
        cGT();
        if (cGN() && this.rdY != null) {
            this.rdY.cHO();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.rbD != null) {
            this.rbD.clear();
            this.rbD = null;
        }
        if (cGN() && this.rdY != null) {
            this.rdY.clear();
        }
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.remove(this);
        EventCenter.instance.removeListener(this.rey);
        com.tencent.mm.kernel.g.aAg().hqi.a(this.rez);
        if (this.rew != null) {
            j jVar = this.rew;
            jVar.rbD = null;
            jVar.rbJ = null;
            jVar.owO = null;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a2r;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = TextUtils.isEmpty(str) ? "" : str;
        Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "jacks [onSceneEnd] errType:%d,errCode:%d,errMsg:%s", objArr);
        cGW();
        switch (qVar.getType()) {
            case 411:
                if (qVar instanceof o) {
                    a(i2, i3, str, (o) qVar);
                    return;
                }
                return;
            case 413:
                r rVar = (r) qVar;
                if (i2 == 0 && i3 == 0) {
                    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.blc(rVar.rcD);
                    Message message = new Message();
                    message.what = 2002;
                    message.obj = getContext().getString(R.string.zf);
                    l(message);
                } else {
                    Message message2 = new Message();
                    message2.what = 2002;
                    message2.obj = getContext().getString(R.string.bs7);
                    l(message2);
                }
                fC(20001, 800);
                return;
            case v2helper.EMethodSetNgStrength /*{ENCODED_INT: 423}*/:
                if (qVar instanceof h) {
                    h hVar = (h) qVar;
                    if (i2 == 0 && i3 == 0) {
                        a(hVar);
                        return;
                    }
                    final String str2 = hVar.rcD;
                    final String str3 = hVar.rcF;
                    final String str4 = hVar.rcE;
                    final String str5 = hVar.rcH;
                    com.tencent.mm.ui.base.h.a(this, getString(R.string.bu8, new Object[]{str4}), "", new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(108784);
                            BaseEmojiStoreUI.this.e(str2, str3, str4, null, str5);
                            BaseEmojiStoreUI.this.cGU();
                            Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", str2);
                            BaseEmojiStoreUI.this.dd(str2, 0);
                            AppMethodBeat.o(108784);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    dc(hVar.rcD, -1);
                    return;
                }
                return;
            case 717:
                if (i2 == 0 && i3 == 0) {
                    this.reh = null;
                    J(false, true);
                    return;
                }
                return;
            default:
                Log.e("MicroMsg.emoji.BaseEmojiStoreUI", "unknow scene type");
                return;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        if (cGN() || cGO()) {
            if (i2 == 0) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                return;
            }
            i2--;
        }
        if (i2 < 0 || i2 >= this.rbD.getCount()) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            return;
        }
        a(this.rbD.getItem(i2), i2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    }

    /* access modifiers changed from: protected */
    public void a(f fVar, int i2) {
        if (fVar == null) {
            Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "item is null.");
        } else if (fVar.qYk == f.a.cellset) {
            EmotionBannerSet emotionBannerSet = fVar.qYm;
            if (emotionBannerSet == null) {
                Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
            } else {
                com.tencent.mm.plugin.emoji.e.k.a(getContext(), emotionBannerSet, false);
            }
        } else {
            EmotionSummary emotionSummary = fVar.qYl;
            if (emotionSummary == null) {
                Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
                return;
            }
            com.tencent.mm.plugin.emoji.e.k.a(getContext(), emotionSummary, cGH(), fVar.mStatus, fVar.HH, getIntent().getStringExtra("to_talker_name"), cGI());
        }
    }

    /* access modifiers changed from: protected */
    public void cGG() {
        this.rbD = cGJ();
        this.rbD.qYa = this;
    }

    /* access modifiers changed from: protected */
    public void amV(String str) {
    }

    /* access modifiers changed from: protected */
    public void cGK() {
    }

    /* access modifiers changed from: protected */
    public void cGL() {
        if (cGM()) {
            this.reb = (MMPullDownView) findViewById(R.id.ep2);
            if (this.reb != null) {
                this.reb.setTopViewVisible(false);
                this.reb.setAtTopCallBack(this);
                this.reb.setOnBottomLoadDataListener(this);
                this.reb.setAtBottomCallBack(this);
                this.reb.setBottomViewVisible(false);
                this.reb.setIsBottomShowAll(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean cGM() {
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        setBackBtn(new b(this, (byte) 0));
        cGG();
        this.GQ = findViewById(R.id.c2g);
        this.rec = (TextView) this.GQ.findViewById(R.id.c2p);
        this.reg = getLayoutInflater().inflate(R.layout.a2q, (ViewGroup) null);
        this.reg.setVisibility(8);
        if (cGN()) {
            this.rdY = new EmojiStoreVpHeader(getContext());
        }
        if (cGO()) {
            this.rdZ = LayoutInflater.from(this).inflate(R.layout.a3m, (ViewGroup) null);
            int i2 = EmojiStoreVpHeader.getScreenWH(getContext())[0];
            this.rdZ.setLayoutParams(new AbsListView.LayoutParams(i2, ((i2 * 3) / 8) + 1));
            this.rea = (StoreBannerEmojiView) this.rdZ.findViewById(R.id.byw);
        }
        this.mListView = (ListView) findViewById(16908298);
        this.mListView.setOnItemClickListener(this);
        if (cGN()) {
            this.mListView.addHeaderView(this.rdY);
        } else if (cGO()) {
            this.mListView.addHeaderView(this.rdZ);
        }
        if (cGY()) {
            this.mListView.addFooterView(this.reg);
        }
        cGK();
        this.mListView.setAdapter((ListAdapter) this.rbD);
        this.mListView.setOnScrollListener(this);
        this.rbD.qXY = this.mListView;
        cGL();
    }

    /* access modifiers changed from: protected */
    public final void J(boolean z, boolean z2) {
        this.mwr = true;
        if (z) {
            this.reg.setVisibility(0);
        }
        bo(this.reh);
        cGS();
        Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z && !z2) {
            bnj();
        }
    }

    @Override // com.tencent.mm.ui.base.MMPullDownView.e
    public final boolean cAj() {
        J(true, false);
        Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
        return true;
    }

    @Override // com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity
    public final void j(Message message) {
        switch (message.what) {
            case 2002:
                String str = (String) message.obj;
                if (isFinishing()) {
                    Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
                    return;
                } else if (this.jZH != null) {
                    this.jZH.setMessage(str);
                    return;
                } else {
                    return;
                }
            case 20001:
                cGW();
                return;
            case NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY:
                c((GetEmotionListResponse) message.obj);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity
    public void k(Message message) {
        String string;
        String string2;
        switch (message.what) {
            case 131074:
                if (this.rbD != null) {
                    this.rbD.notifyDataSetChanged();
                    cGZ();
                    return;
                }
                return;
            case 131075:
                if (this.rbD != null && message.getData() != null && (string2 = message.getData().getString("product_id")) != null) {
                    this.rbD.dd(string2, message.getData().getInt("progress"));
                    return;
                }
                return;
            case 131076:
                if (this.rbD != null && message.getData() != null && (string = message.getData().getString("product_id")) != null) {
                    this.rbD.dc(string, message.getData().getInt("status"));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements MenuItem.OnMenuItemClickListener {
        private b() {
        }

        /* synthetic */ b(BaseEmojiStoreUI baseEmojiStoreUI, byte b2) {
            this();
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(108788);
            BaseEmojiStoreUI.this.finish();
            AppMethodBeat.o(108788);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean cGN() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean cGO() {
        return false;
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.ree == 0 || this.mwr) {
            Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
            return;
        }
        J(true, false);
        Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, String str, o oVar) {
        boolean z;
        if (oVar == null || oVar.mType != cGQ()) {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(cGQ());
            objArr[1] = Integer.valueOf(oVar == null ? -1 : oVar.mType);
            Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "no some scene type. this ui type:%d callbak type:%d", objArr);
            return;
        }
        this.mwr = false;
        this.reg.setVisibility(8);
        g gVar = null;
        try {
            gVar = o.a(oVar.cGx());
        } catch (Exception e2) {
            Log.printInfoStack("MicroMsg.emoji.BaseEmojiStoreUI", "deal NetGetEmotionList error:%s", e2.toString());
        }
        if (gVar != null) {
            if (i2 == 0 || i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.GQ.setVisibility(8);
                this.red = false;
                this.reh = oVar.rcY;
                if (i3 == 0) {
                    GetEmotionListResponse cGx = oVar.cGx();
                    a(gVar, false, true);
                    b(cGx);
                    this.ree = 0;
                    return;
                } else if (i3 == 2) {
                    GetEmotionListResponse cGx2 = oVar.cGx();
                    a(this.ree, gVar, false, false);
                    cGP();
                    b(cGx2);
                    this.ree = 2;
                    return;
                } else if (i3 == 3) {
                    a(this.ree, gVar, false, false);
                    this.ree = 1;
                    return;
                } else {
                    this.GQ.setVisibility(0);
                    this.red = true;
                    if (cGQ() == 7) {
                        this.rec.setText(R.string.bvu);
                        return;
                    } else {
                        this.rec.setText(R.string.buh);
                        return;
                    }
                }
            }
        }
        if (!this.reA) {
            this.GQ.setVisibility(0);
            this.red = true;
            this.rec.setText(R.string.bui);
        }
    }

    private void cGP() {
        com.tencent.mm.plugin.emoji.a.a.b.a(this.rbD.qXZ, this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dd(String str, int i2) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("progress", i2);
        obtain.what = 131075;
        l(obtain);
    }

    private void dc(String str, int i2) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("status", i2);
        obtain.what = 131076;
        l(obtain);
    }

    /* access modifiers changed from: protected */
    public final h e(String str, String str2, String str3, String str4, String str5) {
        this.rez = new h(str, str2, str3, str4, str5);
        return this.rez;
    }

    private o bo(byte[] bArr) {
        o oVar;
        int cGQ = cGQ();
        int bp = bp(bArr);
        int cGR = cGR();
        if (bArr != null) {
            Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", bArr.toString());
            oVar = new o(cGQ, bArr, bp);
            if (cGQ == 7) {
                oVar.rda = cGR;
            }
        } else {
            Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
            oVar = new o(cGQ, bp);
            if (cGQ == 7) {
                oVar.rda = cGR;
            }
        }
        this.res = oVar;
        return oVar;
    }

    public int cGR() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int bp(byte[] bArr) {
        return this.reu;
    }

    private void cGS() {
        com.tencent.mm.kernel.g.aAg().hqi.a(this.res, 0);
    }

    /* access modifiers changed from: protected */
    public final void cGT() {
        com.tencent.mm.kernel.g.aAg().hqi.a(this.res);
    }

    /* access modifiers changed from: protected */
    public final void cGU() {
        com.tencent.mm.kernel.g.aAg().hqi.a(this.rez, 0);
    }

    /* access modifiers changed from: protected */
    public boolean cGV() {
        boolean z;
        GetEmotionListResponse akx = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpQ.akx(cGQ());
        g a2 = o.a(akx);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(cGQ());
        objArr[1] = Integer.valueOf(akx == null ? 0 : akx.EmotionCount);
        Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "load cache type: %d, size: %d", objArr);
        if (a2 == null) {
            return false;
        }
        if (a2.rbt.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", Integer.valueOf(a2.rbt.size()));
            a(a2, true, false);
            return z;
        }
        Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
        return z;
    }

    /* access modifiers changed from: protected */
    public final void bnj() {
        if (isFinishing()) {
            Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        getString(R.string.zb);
        this.jZH = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(108785);
                BaseEmojiStoreUI.this.cGT();
                BaseEmojiStoreUI.cHa();
                AppMethodBeat.o(108785);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void cGW() {
        if (this.jZH != null && this.jZH.isShowing()) {
            this.jZH.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void a(g gVar, boolean z, boolean z2) {
        Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
        if (gVar != null && gVar.rbt.size() > 0) {
            this.reA = true;
            this.GQ.setVisibility(8);
            this.red = false;
        }
        a(this.ree, gVar, z, z2);
        cGP();
    }

    private void a(int i2, g gVar, boolean z, boolean z2) {
        boolean z3 = false;
        Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "");
        switch (i2) {
            case -1:
                this.rev = gVar;
                z3 = true;
                break;
            case 1:
                this.rev = gVar;
                z3 = true;
                break;
            case 2:
                if (this.rev == null) {
                    this.rev = new g();
                }
                if (gVar != null) {
                    this.rev.FX(gVar.rbs);
                    this.rev.dg(gVar.rbt);
                }
                z3 = true;
                break;
        }
        if (this.rev != null) {
            this.rev.cFZ();
        }
        a(z3, this.rev, z, z2);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, g gVar, boolean z2, boolean z3) {
        if (this.rev != null && z) {
            if (cGN()) {
                if (this.rev == null || this.rev.rbu == null || this.rev.rbu.BannerSummary == null) {
                    Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
                } else {
                    this.reB = (LinkedList) this.rev.rbv;
                    this.reC = (LinkedList) this.rev.rbw;
                    if (this.reB != null) {
                        this.rdY.d(this.reB, this.reC);
                    } else if (this.rev.rbu != null) {
                        this.reB = new LinkedList<>();
                        this.reB.add(this.rev.rbu);
                        this.rdY.d(this.reB, this.reC);
                    }
                }
            }
            if (this.rbD != null) {
                this.rbD.b(this.rev);
            }
        }
    }

    private void b(GetEmotionListResponse getEmotionListResponse) {
        if (this.ree == -1) {
            Message obtain = Message.obtain();
            obtain.what = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY;
            obtain.obj = getEmotionListResponse;
            m(obtain);
        }
    }

    /* access modifiers changed from: protected */
    public void c(GetEmotionListResponse getEmotionListResponse) {
        int i2 = 0;
        if (getEmotionListResponse != null) {
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(getEmotionListResponse == null ? 0 : getEmotionListResponse.EmotionCount);
            if (!(getEmotionListResponse == null || getEmotionListResponse.ReqBuf == null)) {
                i2 = getEmotionListResponse.ReqBuf.computeSize();
            }
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(cGQ());
            Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", objArr);
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpQ.a(cGQ(), getEmotionListResponse);
        }
    }

    @Override // com.tencent.mm.ui.base.MMPullDownView.d
    public final boolean cAk() {
        return false;
    }

    @Override // com.tencent.mm.ui.base.MMPullDownView.c
    public final boolean cAl() {
        return false;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        if (!TextUtils.isEmpty(str) && str.equals("delete_group")) {
            cHg();
            fC(131074, 50);
        }
    }

    public void i(String str, int i2, int i3, String str2) {
        com.tencent.mm.plugin.emoji.a.a.c cVar;
        Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i2), Integer.valueOf(i3), str2);
        if (this.rbD != null && (cVar = this.rbD.qXZ) != null) {
            if (i2 == 6) {
                dd(str, i3);
            } else {
                Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", Integer.valueOf(i2));
                dc(str, i2);
            }
            f amb = cVar.amb(str);
            if (amb != null) {
                amb.qYo = str2;
            }
        }
    }

    @Override // com.tencent.mm.plugin.emoji.model.j.a
    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        Object[] objArr = new Object[3];
        objArr[0] = aVar.getProductId();
        objArr[1] = TextUtils.isEmpty(aVar.cFd()) ? "" : aVar.cFd();
        objArr[2] = Integer.valueOf(aVar.cFc());
        Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", objArr);
        if (aVar.cFc() == 9) {
            String string = getString(R.string.zi);
            if (isFinishing()) {
                Log.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            } else {
                getString(R.string.zb);
                this.jZH = com.tencent.mm.ui.base.h.a((Context) this, string, true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI.AnonymousClass4 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(108786);
                        BaseEmojiStoreUI.cHa();
                        AppMethodBeat.o(108786);
                    }
                });
            }
        }
        this.rew.a(aVar);
    }

    /* access modifiers changed from: protected */
    public boolean cGX() {
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.model.k.a
    public final void Y(ArrayList<com.tencent.mm.pluginsdk.model.q> arrayList) {
        Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
        if (this.rbD != null) {
            com.tencent.mm.plugin.emoji.a.a.b.a(arrayList, this.rbD.qXZ);
            if (this.rfA != null) {
                this.rfA.removeMessages(131074);
                this.rfA.sendEmptyMessage(131074);
            }
        }
    }

    @Override // com.tencent.mm.plugin.emoji.model.j.b
    public final void d(String str, String str2, String str3, String str4, String str5) {
        e(str, str2, str3, str4, str5);
        cGU();
    }

    @Override // com.tencent.mm.plugin.emoji.model.j.b
    public final void cGa() {
        this.reh = null;
        this.ree = -1;
        J(false, false);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Log.d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + i2 + "  resultCode:" + i3);
        super.onActivityResult(i2, i3, intent);
        this.rew.onActivityResult(i2, i3, intent);
    }

    /* access modifiers changed from: protected */
    public boolean cGY() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public class a extends IListener<dp> {
        private a() {
            AppMethodBeat.i(161086);
            this.__eventId = dp.class.getName().hashCode();
            AppMethodBeat.o(161086);
        }

        /* synthetic */ a(BaseEmojiStoreUI baseEmojiStoreUI, byte b2) {
            this();
            AppMethodBeat.i(161087);
            this.__eventId = dp.class.getName().hashCode();
            AppMethodBeat.o(161087);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dp dpVar) {
            AppMethodBeat.i(108787);
            dp dpVar2 = dpVar;
            BaseEmojiStoreUI.this.i(dpVar2.dGC.productId, dpVar2.dGC.status, dpVar2.dGC.progress, dpVar2.dGC.dGD);
            AppMethodBeat.o(108787);
            return false;
        }
    }

    public void cGZ() {
    }

    /* access modifiers changed from: protected */
    public void a(h hVar) {
        dd(hVar.rcD, 0);
    }

    static /* synthetic */ void cHa() {
        com.tencent.mm.kernel.g.aAg().hqi.cancel(413);
    }
}
