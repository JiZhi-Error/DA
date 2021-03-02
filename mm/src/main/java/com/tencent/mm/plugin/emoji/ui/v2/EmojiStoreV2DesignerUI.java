package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.c.d;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.emoji.ui.v2.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.List;

public class EmojiStoreV2DesignerUI extends MMActivity implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, i, j.a, j.b, MMPullDownView.c, MMPullDownView.e {
    private View agA;
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.AnonymousClass9 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(109150);
            switch (message.what) {
                case 10001:
                    EmojiStoreV2DesignerUI.this.ly(false);
                    AppMethodBeat.o(109150);
                    return;
                case 10002:
                    EmojiStoreV2DesignerUI.c(EmojiStoreV2DesignerUI.this);
                    AppMethodBeat.o(109150);
                    return;
                case ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL /*{ENCODED_INT: 10003}*/:
                    EmojiStoreV2DesignerUI.b(EmojiStoreV2DesignerUI.this);
                    AppMethodBeat.o(109150);
                    return;
                case 131075:
                    if (EmojiStoreV2DesignerUI.this.reH == null || message.getData() == null) {
                        AppMethodBeat.o(109150);
                        return;
                    }
                    String string = message.getData().getString("product_id");
                    if (string == null) {
                        AppMethodBeat.o(109150);
                        return;
                    }
                    EmojiStoreV2DesignerUI.this.reH.dd(string, message.getData().getInt("progress"));
                    AppMethodBeat.o(109150);
                    return;
                case 131076:
                    if (EmojiStoreV2DesignerUI.this.reH != null && message.getData() != null) {
                        String string2 = message.getData().getString("product_id");
                        if (string2 != null) {
                            EmojiStoreV2DesignerUI.this.reH.dc(string2, message.getData().getInt("status"));
                            break;
                        } else {
                            AppMethodBeat.o(109150);
                            return;
                        }
                    } else {
                        AppMethodBeat.o(109150);
                        return;
                    }
            }
            AppMethodBeat.o(109150);
        }
    };
    private ListView mListView;
    private int mScene;
    private boolean mwr;
    private long rbH;
    private String rbI;
    private String rbM;
    private String rcS;
    f reH;
    private int ree = -1;
    private byte[] reh;
    protected final int rel = 131074;
    private final int rem = 131075;
    private final int ren = 131076;
    private final String reo = "product_id";
    private final String rep = "progress";
    private final String rer = "status";
    private g rev;
    private j rew;
    private IListener rey = new IListener<dp>() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161095);
            this.__eventId = dp.class.getName().hashCode();
            AppMethodBeat.o(161095);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dp dpVar) {
            c cVar;
            com.tencent.mm.plugin.emoji.a.a.f amb;
            AppMethodBeat.i(109143);
            dp dpVar2 = dpVar;
            EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = EmojiStoreV2DesignerUI.this;
            String str = dpVar2.dGC.productId;
            int i2 = dpVar2.dGC.status;
            int i3 = dpVar2.dGC.progress;
            String str2 = dpVar2.dGC.dGD;
            Log.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i2), Integer.valueOf(i3), str2);
            if (i2 == 6) {
                emojiStoreV2DesignerUI.dd(str, i3);
            } else {
                Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "product status:%d", Integer.valueOf(i2));
                emojiStoreV2DesignerUI.dc(str, i2);
            }
            if (!(emojiStoreV2DesignerUI.reH == null || (cVar = emojiStoreV2DesignerUI.reH.qXZ) == null || (amb = cVar.amb(str)) == null)) {
                amb.qYo = str2;
            }
            AppMethodBeat.o(109143);
            return false;
        }
    };
    private h rez;
    private int rjT;
    private String rjU;
    private String rjV;
    private List<String> rjW;
    private as rjX;
    private View rjY;
    private BannerEmojiView rjZ;
    private q rkA;
    private TextView rka;
    private TextView rkb;
    private View rkc;
    private View rkd;
    private TextView rke;
    private ImageView rkf;
    private TextView rkg;
    private TextView rkh;
    View rki;
    private List<ait> rkj = new ArrayList();
    private View rkk;
    PreViewListGridView rkl;
    private a rkm;
    View rkn;
    View rko;
    View rkp;
    TextView rkq;
    View rkr;
    private MMPullDownView rks;
    private bsp rkt;
    private com.tencent.mm.plugin.emoji.f.j rku;
    private com.tencent.mm.ui.base.q rkv;
    private ay.b.a rkw = new ay.b.a() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.AnonymousClass8 */

        @Override // com.tencent.mm.model.ay.b.a
        public final void p(String str, boolean z) {
            AppMethodBeat.i(109149);
            Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContactCallBack username:%s,succ:%b", str, Boolean.valueOf(z));
            if (z) {
                EmojiStoreV2DesignerUI.this.rjX = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str);
                EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this);
            }
            AppMethodBeat.o(109149);
        }
    };
    private final int rkx = 10001;
    private final int rky = 10002;
    private final int rkz = ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreV2DesignerUI() {
        AppMethodBeat.i(109157);
        AppMethodBeat.o(109157);
    }

    static /* synthetic */ void a(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        AppMethodBeat.i(109182);
        emojiStoreV2DesignerUI.cIb();
        AppMethodBeat.o(109182);
    }

    static /* synthetic */ void a(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI, String str) {
        AppMethodBeat.i(109188);
        emojiStoreV2DesignerUI.dd(str, 0);
        AppMethodBeat.o(109188);
    }

    static /* synthetic */ void b(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        AppMethodBeat.i(109183);
        emojiStoreV2DesignerUI.amZ();
        AppMethodBeat.o(109183);
    }

    static /* synthetic */ void c(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        AppMethodBeat.i(109184);
        emojiStoreV2DesignerUI.updateData();
        AppMethodBeat.o(109184);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a2y;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01ce  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
        // Method dump skipped, instructions count: 510
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(109159);
        super.onResume();
        com.tencent.mm.kernel.g.aAg().hqi.a(v2helper.EMethodSetNgStrength, this);
        AppMethodBeat.o(109159);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(109160);
        super.onPause();
        com.tencent.mm.kernel.g.aAg().hqi.b(v2helper.EMethodSetNgStrength, this);
        AppMethodBeat.o(109160);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109161);
        super.onDestroy();
        d dVar = d.hcj;
        d.awd().iu("");
        d dVar2 = d.hcj;
        d.pl(5);
        if (this.rkA != null) {
            com.tencent.mm.kernel.g.aAg().hqi.a(this.rkA);
        }
        com.tencent.mm.kernel.g.aAg().hqi.b(TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, this);
        com.tencent.mm.kernel.g.aAg().hqi.b(TAVExporter.VIDEO_EXPORT_WIDTH, this);
        EventCenter.instance.removeListener(this.rey);
        if (this.mHandler != null) {
            this.mHandler.removeMessages(10002);
            this.mHandler.removeMessages(10001);
            this.mHandler = null;
        }
        AppMethodBeat.o(109161);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109162);
        if (!Util.isNullOrNil(this.rbM)) {
            setMMTitle(this.rbM);
        }
        this.agA = aa.jQ(getContext()).inflate(R.layout.a2u, (ViewGroup) null);
        this.rjY = this.agA.findViewById(R.id.bnj);
        this.rjZ = (BannerEmojiView) this.rjY.findViewById(R.id.byw);
        this.rka = (TextView) this.agA.findViewById(R.id.bnl);
        this.rkb = (TextView) this.agA.findViewById(R.id.bnh);
        this.rkc = this.agA.findViewById(R.id.bnf);
        this.rkd = this.agA.findViewById(R.id.bne);
        this.rke = (TextView) this.agA.findViewById(R.id.bnu);
        this.rkf = (ImageView) this.agA.findViewById(R.id.bnk);
        this.rkg = (TextView) this.agA.findViewById(R.id.bni);
        this.rkh = (TextView) this.agA.findViewById(R.id.bnv);
        this.rki = this.agA.findViewById(R.id.bnm);
        this.rkk = this.agA.findViewById(R.id.bnq);
        this.rkk.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(109151);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                EmojiStoreV2DesignerUI.e(EmojiStoreV2DesignerUI.this);
                a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109151);
            }
        });
        this.rkl = (PreViewListGridView) this.agA.findViewById(R.id.bnp);
        this.rkm = new a(getContext());
        this.rkm.rni = new a.AbstractC0964a() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.AnonymousClass11 */

            @Override // com.tencent.mm.plugin.emoji.ui.v2.a.AbstractC0964a
            public final void FP(int i2) {
                ait Gg;
                AppMethodBeat.i(109152);
                if (!(EmojiStoreV2DesignerUI.this.rkl == null || EmojiStoreV2DesignerUI.this.rkm == null || (Gg = EmojiStoreV2DesignerUI.this.rkm.Gg(i2)) == null)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12787, 1, 0, Gg.Md5, Long.valueOf(EmojiStoreV2DesignerUI.this.rbH), Gg.Lsl, Gg.ProductID, 6);
                    try {
                        Intent intent = new Intent();
                        intent.putExtra("extra_object", Gg.toByteArray());
                        intent.putExtra("add_source", 5);
                        intent.putExtra("entrance_scene", 6);
                        intent.setClass(EmojiStoreV2DesignerUI.this.getContext(), EmojiStoreV2SingleProductDialogUI.class);
                        EmojiStoreV2DesignerUI.this.startActivityForResult(intent, 2004);
                        EmojiStoreV2DesignerUI.this.overridePendingTransition(R.anim.dd, R.anim.di);
                        AppMethodBeat.o(109152);
                        return;
                    } catch (Exception e2) {
                    }
                }
                AppMethodBeat.o(109152);
            }
        };
        this.rkl.setAdapter((ListAdapter) this.rkm);
        this.rkn = this.agA.findViewById(R.id.bnr);
        this.rko = this.agA.findViewById(R.id.bns);
        this.rkp = this.agA.findViewById(R.id.bnq);
        this.rkq = (TextView) this.agA.findViewById(R.id.bnt);
        this.rkr = this.agA.findViewById(R.id.bno);
        this.rks = (MMPullDownView) findViewById(R.id.ep2);
        this.rks.setOnBottomLoadDataListener(this);
        this.rks.setAtBottomCallBack(this);
        this.rks.setBottomViewVisible(false);
        this.rks.setIsBottomShowAll(false);
        this.mListView = (ListView) findViewById(16908298);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnScrollListener(this);
        this.rkd.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(109153);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                EmojiStoreV2DesignerUI.i(EmojiStoreV2DesignerUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109153);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.AnonymousClass13 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109154);
                EmojiStoreV2DesignerUI.this.finish();
                AppMethodBeat.o(109154);
                return false;
            }
        });
        addIconOptionMenu(0, R.raw.icons_outlined_share, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.AnonymousClass14 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109155);
                Log.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "on shard click.");
                EmojiStoreV2DesignerUI.j(EmojiStoreV2DesignerUI.this);
                AppMethodBeat.o(109155);
                return true;
            }
        });
        AppMethodBeat.o(109162);
    }

    private void amZ() {
        AppMethodBeat.i(109163);
        setMMTitle(this.rbM);
        this.reH = new f(getContext());
        this.reH.df(this.rjW);
        this.mListView.addHeaderView(this.agA);
        this.mListView.setAdapter((ListAdapter) this.reH);
        this.reH.qYa = this;
        this.reH.qXv = n.auV();
        this.reH.qXw = false;
        this.rka.setText(this.rbM);
        this.rkt = k.getEmojiStorageMgr().OpQ.blw(String.valueOf(this.rjT));
        this.rew = new j();
        this.rew.owO = this;
        this.rew.rbD = this.reH;
        this.rew.rbG = 6;
        this.rew.rbJ = this;
        this.rew.rbM = this.rbM;
        this.rew.rbH = this.rbH;
        this.rew.rbI = this.rbI;
        if (this.rkt != null) {
            c(q.a(this.rkt));
            dj(this.rkt.KOp);
        }
        updateData();
        br(this.reh);
        AppMethodBeat.o(109163);
    }

    private void updateData() {
        AppMethodBeat.i(109164);
        if (this.rkt == null) {
            Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data failed. data is null.");
            AppMethodBeat.o(109164);
            return;
        }
        ly(true);
        if (!Util.isNullOrNil(this.rkt.KOR)) {
            Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", this.rkt.KOR);
            this.rjX = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(this.rkt.KOR);
        } else {
            Log.w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
            this.rkc.setVisibility(8);
            this.rkd.setVisibility(8);
        }
        if ((this.rjX == null || ((int) this.rjX.gMZ) == 0) && ay.a.iDq != null) {
            Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", this.rkt.KOR);
            ay.a.iDq.a(this.rkt.KOR, "", this.rkw);
        }
        this.rkg.setText(R.string.bw4);
        if (!Util.isNullOrNil(this.rkt.Desc)) {
            this.rkb.setText(this.rkt.Desc);
            this.rkb.setVisibility(0);
        } else {
            this.rkb.setVisibility(8);
        }
        cIb();
        if (this.rev == null || this.rev.rbt == null || this.rev.rbt.isEmpty()) {
            this.rkh.setVisibility(8);
            AppMethodBeat.o(109164);
            return;
        }
        this.rkh.setVisibility(0);
        AppMethodBeat.o(109164);
    }

    /* access modifiers changed from: protected */
    public final void ly(boolean z) {
        AppMethodBeat.i(109165);
        if (this.rkt == null) {
            Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header failed. data is null.");
            AppMethodBeat.o(109165);
            return;
        }
        if (this.rjZ != null && !Util.isNullOrNil(this.rkt.LZs)) {
            String str = this.rkt.LZs;
            com.tencent.mm.cb.a.getDensity(this);
            EmojiInfo H = EmojiLogic.H("Designer", 8, str);
            if (H != null) {
                this.rjZ.setImageFilePath(H.hYx());
            } else if (z) {
                com.tencent.mm.av.q.bcV().a(this.rkt.LZs, (ImageView) null, e.j("Designer", this.rkt.LZs, "Designer", "BANNER"), new com.tencent.mm.av.a.c.k() {
                    /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.AnonymousClass15 */

                    @Override // com.tencent.mm.av.a.c.k
                    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(109156);
                        if (EmojiStoreV2DesignerUI.this.mHandler != null) {
                            EmojiStoreV2DesignerUI.this.mHandler.sendEmptyMessage(10001);
                        }
                        AppMethodBeat.o(109156);
                    }
                });
                AppMethodBeat.o(109165);
                return;
            } else {
                Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "updateDesignerHeader failed");
                AppMethodBeat.o(109165);
                return;
            }
        }
        AppMethodBeat.o(109165);
    }

    private void cIb() {
        AppMethodBeat.i(109166);
        if (this.rjX == null || ((int) this.rjX.gMZ) == 0) {
            this.rkd.setVisibility(8);
            this.rkc.setVisibility(8);
            AppMethodBeat.o(109166);
            return;
        }
        this.rkd.setVisibility(0);
        this.rkc.setVisibility(0);
        if (!Util.isNullOrNil(this.rjX.arI())) {
            this.rke.setText(this.rjX.arI());
        } else {
            this.rke.setText(this.rjX.field_username);
        }
        a.b.d(this.rkf, this.rjX.field_username);
        this.rkg.setEnabled(true);
        AppMethodBeat.o(109166);
    }

    private void br(byte[] bArr) {
        AppMethodBeat.i(109167);
        this.mwr = true;
        this.rkA = new q(this.rjT, bArr);
        com.tencent.mm.kernel.g.aAg().hqi.a(this.rkA, 0);
        AppMethodBeat.o(109167);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(109168);
        switch (qVar.getType()) {
            case TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL /*{ENCODED_INT: 239}*/:
                if (this.rkv != null && this.rkv.isShowing()) {
                    this.rkv.dismiss();
                }
                if (i3 == 0 && i2 == 0) {
                    bmi cGt = ((com.tencent.mm.plugin.emoji.f.j) qVar).cGt();
                    if (!(cGt == null || cGt.LVe == null)) {
                        this.rjT = cGt.LVe.DesignerUin;
                        this.rbM = cGt.LVe.Name;
                        this.rjU = cGt.LVe.HeadUrl;
                        if (this.mHandler != null) {
                            this.mHandler.sendEmptyMessage(ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL);
                        }
                    }
                    AppMethodBeat.o(109168);
                    return;
                }
                showOptionMenu(0, false);
                com.tencent.mm.ui.base.h.c(getContext(), getString(R.string.bs9), null, true);
                Log.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
                AppMethodBeat.o(109168);
                return;
            case v2helper.EMethodSetNgStrength /*{ENCODED_INT: 423}*/:
                if (qVar instanceof h) {
                    h hVar = (h) qVar;
                    if (i2 == 0 && i3 == 0) {
                        dd(hVar.rcD, 0);
                        AppMethodBeat.o(109168);
                        return;
                    }
                    final String str2 = hVar.rcD;
                    final String str3 = hVar.rcF;
                    final String str4 = hVar.rcE;
                    final String str5 = hVar.rcH;
                    com.tencent.mm.ui.base.h.a(this, getString(R.string.bu8, new Object[]{str4}), "", new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(109145);
                            EmojiStoreV2DesignerUI.this.X(str2, str3, str4);
                            EmojiStoreV2DesignerUI.this.cGU();
                            Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", str2);
                            EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this, str2);
                            AppMethodBeat.o(109145);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    dc(hVar.rcD, -1);
                    AppMethodBeat.o(109168);
                    return;
                }
                break;
            case TAVExporter.VIDEO_EXPORT_WIDTH /*{ENCODED_INT: 720}*/:
                if (qVar instanceof q) {
                    this.mwr = false;
                    if (i2 == 0 || i2 == 4) {
                        q qVar2 = (q) qVar;
                        g a2 = q.a(qVar2.cGA());
                        if (i3 == 0) {
                            this.rkt = qVar2.cGA();
                            c(a2);
                        } else if (i3 == 2) {
                            this.rkt = qVar2.cGA();
                            b(this.ree, a2);
                            this.ree = 2;
                        } else if (i3 == 3) {
                            this.rkt = qVar2.cGA();
                            b(this.ree, a2);
                            this.ree = 1;
                            Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", Integer.valueOf(i3));
                        }
                        if (this.reh == null && this.rkt != null) {
                            k.getEmojiStorageMgr().OpQ.a(String.valueOf(this.rjT), qVar2.cGA());
                            this.rkj = this.rkt.KOp;
                            dj(this.rkj);
                        }
                        this.reh = qVar2.rcY;
                        AppMethodBeat.o(109168);
                        return;
                    }
                    Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
                    AppMethodBeat.o(109168);
                    return;
                }
                break;
            default:
                Log.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "unknow scene type");
                break;
        }
        AppMethodBeat.o(109168);
    }

    private void dj(final List<ait> list) {
        boolean z = true;
        AppMethodBeat.i(109169);
        String value = com.tencent.mm.n.h.aqJ().getValue("ShowDesignerEmoji");
        Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", value);
        if (Util.isNullOrNil(value) || Util.safeParseInt(value) != 1) {
            z = false;
        }
        if (list == null || list.size() <= 0 || !z) {
            this.rki.setVisibility(8);
            AppMethodBeat.o(109169);
            return;
        }
        this.rki.setVisibility(0);
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.AnonymousClass2 */

                public final void run() {
                    boolean z;
                    int i2 = 8;
                    AppMethodBeat.i(109144);
                    EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = EmojiStoreV2DesignerUI.this;
                    if (list.size() > 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (emojiStoreV2DesignerUI.rkl != null) {
                        emojiStoreV2DesignerUI.rkl.setVisibility(0);
                    }
                    if (emojiStoreV2DesignerUI.rko != null) {
                        emojiStoreV2DesignerUI.rko.setVisibility(0);
                    }
                    if (emojiStoreV2DesignerUI.rkn != null) {
                        emojiStoreV2DesignerUI.rkn.setVisibility(0);
                    }
                    if (emojiStoreV2DesignerUI.rkp != null) {
                        emojiStoreV2DesignerUI.rkp.setVisibility(z ? 0 : 8);
                    }
                    if (emojiStoreV2DesignerUI.rkq != null) {
                        emojiStoreV2DesignerUI.rkq.setText(R.string.buy);
                    }
                    if (emojiStoreV2DesignerUI.rkr != null) {
                        View view = emojiStoreV2DesignerUI.rkr;
                        if (z) {
                            i2 = 0;
                        }
                        view.setVisibility(i2);
                    }
                    if (emojiStoreV2DesignerUI.rki != null) {
                        emojiStoreV2DesignerUI.rki.setPadding(0, 0, 0, 0);
                    }
                    AppMethodBeat.o(109144);
                }
            });
        }
        this.rkm.ad(list);
        AppMethodBeat.o(109169);
    }

    private void c(g gVar) {
        AppMethodBeat.i(109170);
        b(this.ree, gVar);
        this.ree = 0;
        AppMethodBeat.o(109170);
    }

    private void b(int i2, g gVar) {
        boolean z = true;
        AppMethodBeat.i(109171);
        switch (i2) {
            case -1:
                this.rev = gVar;
                break;
            case 0:
                this.rev = gVar;
                break;
            case 1:
                this.rev = gVar;
                break;
            case 2:
                if (this.rev == null) {
                    this.rev = new g();
                }
                this.rev.FX(gVar.rbs);
                this.rev.dg(gVar.rbt);
                break;
            default:
                z = false;
                break;
        }
        lz(z);
        AppMethodBeat.o(109171);
    }

    private void lz(boolean z) {
        AppMethodBeat.i(109172);
        if (this.rev != null && z) {
            if (this.reH != null) {
                this.reH.b(this.rev);
            }
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(10002);
            }
        }
        AppMethodBeat.o(109172);
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(109173);
        if (i2 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
            if (this.ree == 0 || this.mwr) {
                Log.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
                AppMethodBeat.o(109173);
                return;
            }
            br(this.reh);
            Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
        }
        AppMethodBeat.o(109173);
    }

    @Override // com.tencent.mm.ui.base.MMPullDownView.e
    public final boolean cAj() {
        return true;
    }

    @Override // com.tencent.mm.ui.base.MMPullDownView.c
    public final boolean cAl() {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        com.tencent.mm.plugin.emoji.a.a.f FN;
        AppMethodBeat.i(109174);
        b bVar = new b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        if (!(this.reH == null || (FN = this.reH.getItem(i2 - this.mListView.getHeaderViewsCount())) == null)) {
            Intent intent = new Intent();
            intent.setClass(this, EmojiStoreDetailUI.class);
            EmotionSummary emotionSummary = FN.qYl;
            if (emotionSummary == null) {
                intent = null;
            } else {
                d dVar = d.hcj;
                d.awd().iu(emotionSummary.ProductID);
                d dVar2 = d.hcj;
                d.pl(4);
                d dVar3 = d.hcj;
                d.awd().iu("");
                intent.putExtra("extra_id", emotionSummary.ProductID);
                intent.putExtra("extra_name", emotionSummary.PackName);
                intent.putExtra("extra_copyright", emotionSummary.PackCopyright);
                intent.putExtra("extra_coverurl", emotionSummary.CoverUrl);
                intent.putExtra("extra_description", emotionSummary.PackDesc);
                intent.putExtra("extra_price", emotionSummary.PackPrice);
                intent.putExtra("extra_type", emotionSummary.PackType);
                intent.putExtra("extra_flag", emotionSummary.PackFlag);
                intent.putExtra("preceding_scence", 106);
                intent.putExtra("download_entrance_scene", 6);
                intent.putExtra("call_by", 1);
                intent.putExtra("check_clickflag", false);
                intent.putExtra("extra_status", FN.mStatus);
                intent.putExtra("extra_progress", FN.HH);
                intent.putExtra("searchID", this.rbH);
                String stringExtra = getIntent().getStringExtra("to_talker_name");
                if (!Util.isNullOrNil(stringExtra)) {
                    intent.putExtra("to_talker_name", stringExtra);
                }
            }
            if (intent != null) {
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(109174);
    }

    @Override // com.tencent.mm.plugin.emoji.model.j.a
    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        AppMethodBeat.i(109175);
        Object[] objArr = new Object[3];
        objArr[0] = aVar.getProductId();
        objArr[1] = TextUtils.isEmpty(aVar.cFd()) ? "" : aVar.cFd();
        objArr[2] = Integer.valueOf(aVar.cFc());
        Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", objArr);
        aVar.cFc();
        d dVar = d.hcj;
        d.awd().iu(aVar.getProductId());
        d dVar2 = d.hcj;
        d.pl(3);
        d dVar3 = d.hcj;
        d.awd().iu("");
        this.rew.a(aVar);
        AppMethodBeat.o(109175);
    }

    @Override // com.tencent.mm.plugin.emoji.model.j.b
    public final void d(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(240180);
        X(str, str2, str3);
        cGU();
        AppMethodBeat.o(240180);
    }

    @Override // com.tencent.mm.plugin.emoji.model.j.b
    public final void cGa() {
    }

    /* access modifiers changed from: protected */
    public final h X(String str, String str2, String str3) {
        AppMethodBeat.i(240181);
        this.rez = new h(str, str2, str3);
        h hVar = this.rez;
        AppMethodBeat.o(240181);
        return hVar;
    }

    /* access modifiers changed from: protected */
    public final void cGU() {
        AppMethodBeat.i(109178);
        com.tencent.mm.kernel.g.aAg().hqi.a(this.rez, 0);
        AppMethodBeat.o(109178);
    }

    /* access modifiers changed from: package-private */
    public final void dd(String str, int i2) {
        AppMethodBeat.i(109179);
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("progress", i2);
        obtain.what = 131075;
        if (this.mHandler != null) {
            this.mHandler.sendMessage(obtain);
        }
        AppMethodBeat.o(109179);
    }

    /* access modifiers changed from: package-private */
    public final void dc(String str, int i2) {
        AppMethodBeat.i(109180);
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("status", i2);
        obtain.what = 131076;
        if (this.mHandler != null) {
            this.mHandler.sendMessage(obtain);
        }
        AppMethodBeat.o(109180);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(109181);
        this.rew.onActivityResult(i2, i3, intent);
        if (i2 == 2002) {
            if (i3 == -1) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                if (Util.isNullOrNil(stringExtra) || this.rkt == null) {
                    Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "member or data is null.");
                } else {
                    Log.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "..".concat(String.valueOf(stringExtra)));
                    String str = this.rbM;
                    String str2 = this.rkt.Desc;
                    int i4 = this.rjT;
                    String str3 = this.rjV;
                    String str4 = this.rbM;
                    String str5 = this.rkt.HeadUrl;
                    ((com.tencent.mm.pluginsdk.j) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.j.class)).a(this, stringExtra, getResources().getString(R.string.ti) + str, getString(R.string.yq), getString(R.string.b97), str5, 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a6: INVOKE  
                          (wrap: com.tencent.mm.pluginsdk.j : 0x0095: CHECK_CAST (r12v1 com.tencent.mm.pluginsdk.j) = (com.tencent.mm.pluginsdk.j) (wrap: com.tencent.mm.kernel.c.a : 0x0090: INVOKE  (r3v23 com.tencent.mm.kernel.c.a) = (wrap: java.lang.Class : 0x008e: CONST_CLASS   com.tencent.mm.pluginsdk.j.class) type: STATIC call: com.tencent.mm.kernel.g.af(java.lang.Class):com.tencent.mm.kernel.c.a))
                          (r19v0 'this' com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI A[IMMUTABLE_TYPE, THIS])
                          (r4v1 'stringExtra' java.lang.String)
                          (wrap: java.lang.String : ?: STR_CONCAT  
                          (wrap: java.lang.String : 0x0067: INVOKE  
                          (wrap: android.content.res.Resources : 0x0060: INVOKE  (r19v0 'this' com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: com.tencent.mm.ui.MMActivity.getResources():android.content.res.Resources)
                          (wrap: int : ?: SGET   com.tencent.mm.R.string.ti int)
                         type: VIRTUAL call: android.content.res.Resources.getString(int):java.lang.String)
                          (r9v0 'str' java.lang.String)
                        )
                          (wrap: java.lang.String : 0x0081: INVOKE  (r15v0 java.lang.String) = 
                          (r19v0 'this' com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI A[IMMUTABLE_TYPE, THIS])
                          (wrap: int : ?: SGET   com.tencent.mm.R.string.yq int)
                         type: VIRTUAL call: com.tencent.mm.ui.MMActivity.getString(int):java.lang.String)
                          (wrap: java.lang.String : 0x008a: INVOKE  (r16v0 java.lang.String) = 
                          (r19v0 'this' com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI A[IMMUTABLE_TYPE, THIS])
                          (wrap: int : ?: SGET   com.tencent.mm.R.string.b97 int)
                         type: VIRTUAL call: com.tencent.mm.ui.MMActivity.getString(int):java.lang.String)
                          (r10v0 'str5' java.lang.String)
                          (wrap: com.tencent.mm.plugin.emoji.e.j$2 : 0x009b: CONSTRUCTOR  (r3v24 com.tencent.mm.plugin.emoji.e.j$2) = 
                          (r4v1 'stringExtra' java.lang.String)
                          (r5v2 'str4' java.lang.String)
                          (r6v1 'str2' java.lang.String)
                          (r7v0 'i4' int)
                          (r8v0 'str3' java.lang.String)
                          (r9v0 'str' java.lang.String)
                          (r10v0 'str5' java.lang.String)
                          (r19v0 'this' com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI A[IMMUTABLE_TYPE, THIS])
                         call: com.tencent.mm.plugin.emoji.e.j.2.<init>(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, com.tencent.mm.ui.MMActivity):void type: CONSTRUCTOR)
                         type: INTERFACE call: com.tencent.mm.pluginsdk.j.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.tencent.mm.pluginsdk.ui.applet.y$a):void in method: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.onActivityResult(int, int, android.content.Intent):void, file: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x009b: CONSTRUCTOR  (r3v24 com.tencent.mm.plugin.emoji.e.j$2) = 
                          (r4v1 'stringExtra' java.lang.String)
                          (r5v2 'str4' java.lang.String)
                          (r6v1 'str2' java.lang.String)
                          (r7v0 'i4' int)
                          (r8v0 'str3' java.lang.String)
                          (r9v0 'str' java.lang.String)
                          (r10v0 'str5' java.lang.String)
                          (r19v0 'this' com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI A[IMMUTABLE_TYPE, THIS])
                         call: com.tencent.mm.plugin.emoji.e.j.2.<init>(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, com.tencent.mm.ui.MMActivity):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.onActivityResult(int, int, android.content.Intent):void, file: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 29 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.emoji.e.j, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 35 more
                        */
                    /*
                    // Method dump skipped, instructions count: 217
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.onActivityResult(int, int, android.content.Intent):void");
                }

                @Override // com.tencent.mm.ui.MMActivity
                public int getForceOrientation() {
                    return 1;
                }

                static /* synthetic */ void e(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
                    AppMethodBeat.i(109185);
                    if (emojiStoreV2DesignerUI.rjT != 0) {
                        Intent intent = new Intent();
                        intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, emojiStoreV2DesignerUI.rjT);
                        intent.setClass(emojiStoreV2DesignerUI.getContext(), EmojiStoreV2SingleProductUI.class);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(emojiStoreV2DesignerUI, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "jumpToSingleProduct", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        emojiStoreV2DesignerUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(emojiStoreV2DesignerUI, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2DesignerUI", "jumpToSingleProduct", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    AppMethodBeat.o(109185);
                }

                static /* synthetic */ void i(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
                    AppMethodBeat.i(109186);
                    if (emojiStoreV2DesignerUI.rkt != null && !Util.isNullOrNil(emojiStoreV2DesignerUI.rkt.KOR)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", emojiStoreV2DesignerUI.rkt.KOR);
                        com.tencent.mm.br.c.b(emojiStoreV2DesignerUI.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12067, 3, "", "", "", "");
                    }
                    AppMethodBeat.o(109186);
                }

                static /* synthetic */ void j(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
                    AppMethodBeat.i(109187);
                    com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) emojiStoreV2DesignerUI.getContext(), 1, false);
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.AnonymousClass5 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(109146);
                            mVar.b(1001, EmojiStoreV2DesignerUI.this.getString(R.string.btp), R.raw.bottomsheet_icon_transmit);
                            mVar.b(1000, EmojiStoreV2DesignerUI.this.getString(R.string.btq), R.raw.bottomsheet_icon_moment);
                            AppMethodBeat.o(109146);
                        }
                    };
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.AnonymousClass6 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(109147);
                            switch (menuItem.getItemId()) {
                                case 1001:
                                    com.tencent.mm.plugin.emoji.e.j.eY(EmojiStoreV2DesignerUI.this.getContext());
                                    EmojiStoreV2DesignerUI.this.getContext().overridePendingTransition(R.anim.dq, R.anim.bs);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13224, 3, 2, "", Integer.valueOf(EmojiStoreV2DesignerUI.this.rjT));
                                    AppMethodBeat.o(109147);
                                    return;
                                case 1000:
                                    if (EmojiStoreV2DesignerUI.this.rkt != null) {
                                        com.tencent.mm.plugin.emoji.e.j.a(EmojiStoreV2DesignerUI.this.getContext(), EmojiStoreV2DesignerUI.this.rkt.Name + EmojiStoreV2DesignerUI.this.getString(R.string.bu5), EmojiStoreV2DesignerUI.this.rkt.Desc, EmojiStoreV2DesignerUI.this.rkt.HeadUrl, EmojiStoreV2DesignerUI.this.rjV, EmojiLogic.v(EmojiStoreV2DesignerUI.this.rjT, EmojiStoreV2DesignerUI.this.rbM, EmojiStoreV2DesignerUI.this.rjV), 10);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13224, 3, 1, "", Integer.valueOf(EmojiStoreV2DesignerUI.this.rjT));
                                        break;
                                    }
                                    break;
                            }
                            AppMethodBeat.o(109147);
                        }
                    };
                    eVar.dGm();
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13224, 3, 0, "", Integer.valueOf(emojiStoreV2DesignerUI.rjT));
                    AppMethodBeat.o(109187);
                }
            }
