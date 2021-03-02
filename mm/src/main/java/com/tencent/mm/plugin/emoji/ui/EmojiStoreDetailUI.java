package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.an.f;
import com.tencent.mm.av.a.c.l;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.c.e;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.m;
import com.tencent.mm.plugin.emoji.f.p;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.PackThumbExt;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.vfs.o;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.wxmm.v2helper;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;

public class EmojiStoreDetailUI extends MMActivity implements View.OnClickListener, i, MStorage.IOnStorageChange {
    private static d riu = new d((byte) 0);
    private View GQ;
    private int HH;
    private ProgressDialog jZH;
    private Context mContext;
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass18 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(108996);
            switch (message.what) {
                case 1001:
                    EmojiStoreDetailUI.e(EmojiStoreDetailUI.this);
                    AppMethodBeat.o(108996);
                    return;
                case 1002:
                    EmojiStoreDetailUI.f(EmojiStoreDetailUI.this);
                    AppMethodBeat.o(108996);
                    return;
                case 1003:
                    EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
                    AppMethodBeat.o(108996);
                    return;
                case 1004:
                    if (EmojiStoreDetailUI.this.rhD.getVisibility() == 0) {
                        EmojiStoreDetailUI.this.rhD.setVisibility(8);
                        EmojiStoreDetailUI.this.rhH.setVisibility(0);
                        EmojiStoreDetailUI.this.rhG.setVisibility(0);
                    }
                    EmojiStoreDetailUI.this.qWX.setProgress(EmojiStoreDetailUI.this.HH);
                    AppMethodBeat.o(108996);
                    return;
                case 1005:
                    EmojiStoreDetailUI.this.rhy.scrollTo(0, 0);
                    AppMethodBeat.o(108996);
                    return;
                case 1006:
                    EmojiStoreDetailUI.n(EmojiStoreDetailUI.this);
                    AppMethodBeat.o(108996);
                    return;
                case 1007:
                    EmojiStoreDetailUI.this.cHC();
                    AppMethodBeat.o(108996);
                    return;
                default:
                    Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow message, cannt handle.");
                    AppMethodBeat.o(108996);
                    return;
            }
        }
    };
    private int mNumColumns;
    private int mPadding;
    private ProgressBar qWX;
    private long rbH = 0;
    private String rbI = "";
    private com.tencent.mm.plugin.emoji.h.c rbL;
    private as rbN;
    private String rcD;
    private String rcE;
    private String rcF;
    private EmotionDetail reN = new EmotionDetail();
    private String reO = "";
    private int reu;
    private IListener rey = new IListener<dp>() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161092);
            this.__eventId = dp.class.getName().hashCode();
            AppMethodBeat.o(161092);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dp dpVar) {
            AppMethodBeat.i(108981);
            dp dpVar2 = dpVar;
            if (EmojiStoreDetailUI.this.rcD == null || dpVar2.dGC.productId == null || !dpVar2.dGC.productId.equals(EmojiStoreDetailUI.this.rcD)) {
                AppMethodBeat.o(108981);
            } else {
                EmojiStoreDetailUI.this.i(dpVar2.dGC.productId, dpVar2.dGC.status, dpVar2.dGC.progress, dpVar2.dGC.dGD);
                AppMethodBeat.o(108981);
            }
            return false;
        }
    };
    private TextView rhA;
    private MMAutoSizeTextView rhB;
    private TextView rhC;
    private TextView rhD;
    private TextView rhE;
    private EmojiDetailGridView rhF;
    private ImageView rhG;
    private View rhH;
    private TextView rhI;
    private TextView rhJ;
    private View rhK;
    private int rhL;
    private View rhM;
    private ProgressBar rhN;
    private View rhO;
    private ImageView rhP;
    private TextView rhQ;
    private View rhR;
    private View rhS;
    private TextView rhT;
    private Button rhU;
    private DonorsAvatarView rhV;
    private TextView rhW;
    private int rhX;
    private int rhY;
    private int rhZ;
    private int rhl;
    private String rhm;
    private boolean rhn;
    private boolean rho = false;
    private int rhp = -1;
    private m rhq;
    private h rhr;
    private p rhs;
    private a rht;
    private GetEmotionRewardResponse rhu = null;
    private boolean rhv;
    private TextView rhw;
    private View rhx;
    private EmojiDetailScrollView rhy;
    private BannerEmojiView rhz;
    private String ria;
    private boolean rib;
    private int ric;
    private int rid = -1;
    private String rie;
    private String rif;
    private String rig;
    private String[] rih = new String[1];
    private boolean rii = false;
    private View rij;
    private boolean rik = true;
    private bms ril;
    private boolean rim = false;
    private boolean rin = true;
    private boolean rio = false;
    private q rip;
    private View.OnClickListener riq = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass12 */

        public final void onClick(View view) {
            AppMethodBeat.i(108989);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + LocaleUtil.getApplicationLanguage());
            Intent intent = new Intent();
            intent.putExtra("rawUrl", EmojiStoreDetailUI.this.getString(R.string.bt_) + LocaleUtil.getApplicationLanguage());
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            com.tencent.mm.br.c.b(EmojiStoreDetailUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108989);
        }
    };
    private View.OnClickListener rir = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass15 */

        public final void onClick(View view) {
            AppMethodBeat.i(108993);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + LocaleUtil.getApplicationLanguage());
            Intent intent = new Intent();
            intent.putExtra("title", EmojiStoreDetailUI.this.getString(R.string.bu1));
            intent.putExtra("rawUrl", EmojiStoreDetailUI.this.getString(R.string.bs0) + LocaleUtil.getApplicationLanguage());
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            com.tencent.mm.br.c.b(EmojiStoreDetailUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108993);
        }
    };
    private View.OnClickListener ris = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass16 */

        public final void onClick(View view) {
            AppMethodBeat.i(108994);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardUI.class);
            intent.putExtra("extra_id", EmojiStoreDetailUI.this.rcD);
            intent.putExtra("extra_name", EmojiStoreDetailUI.this.reN.PackName);
            if (!(EmojiStoreDetailUI.this.reN == null || EmojiStoreDetailUI.this.reN.PersonalDesigner == null)) {
                intent.putExtra("name", EmojiStoreDetailUI.this.reN.PersonalDesigner.Name);
            }
            intent.putExtra("scene", EmojiStoreDetailUI.this.rhZ);
            intent.putExtra("pageType", 1);
            intent.putExtra("searchID", EmojiStoreDetailUI.this.rbH);
            EmojiStoreDetailUI emojiStoreDetailUI = EmojiStoreDetailUI.this;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(emojiStoreDetailUI, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            emojiStoreDetailUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(emojiStoreDetailUI, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12738, EmojiStoreDetailUI.this.rcD, 1, Integer.valueOf(EmojiStoreDetailUI.this.rhZ), 0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108994);
        }
    };
    private View.OnClickListener rit = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass17 */

        public final void onClick(View view) {
            AppMethodBeat.i(108995);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardDetailUI.class);
            intent.putExtra("extra_id", EmojiStoreDetailUI.this.rcD);
            intent.putExtra("extra_iconurl", EmojiStoreDetailUI.this.reN.IconUrl);
            intent.putExtra("extra_name", EmojiStoreDetailUI.this.reN.PackName);
            if (EmojiStoreDetailUI.this.reN.PersonalDesigner != null) {
                intent.putExtra("name", EmojiStoreDetailUI.this.reN.PersonalDesigner.Name);
            }
            EmojiStoreDetailUI emojiStoreDetailUI = EmojiStoreDetailUI.this;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(emojiStoreDetailUI, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            emojiStoreDetailUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(emojiStoreDetailUI, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108995);
        }
    };
    private l riv = new l() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass19 */

        @Override // com.tencent.mm.av.a.c.l
        public final void AC(long j2) {
            AppMethodBeat.i(176192);
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10930, EmojiStoreDetailUI.this.rcD + "," + j2);
            AppMethodBeat.o(176192);
        }
    };
    private k.a riw = new k.a() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass14 */

        @Override // com.tencent.mm.pluginsdk.model.k.a
        public final void Y(ArrayList<com.tencent.mm.pluginsdk.model.q> arrayList) {
            AppMethodBeat.i(176191);
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onQueryFinish] %s", objArr);
            EmojiStoreDetailUI.this.ric = 12;
            if (arrayList != null && arrayList.size() > 0) {
                com.tencent.mm.pluginsdk.model.q qVar = arrayList.get(0);
                Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "onQueryFinish: %s", qVar);
                if (qVar.JVq == 10232) {
                    EmojiStoreDetailUI.this.rhp = 4;
                    EmojiStoreDetailUI.this.rie = qVar.JVn;
                    EmojiStoreDetailUI.this.rif = qVar.JVo;
                    EmojiStoreDetailUI.this.rig = new BigDecimal(qVar.JVp).divide(new BigDecimal(1000000)).toString();
                } else {
                    EmojiStoreDetailUI.this.rhp = 10;
                    EmojiStoreDetailUI.this.rid = qVar.JVq;
                }
                EmojiStoreDetailUI.this.Ga(1002);
            }
            AppMethodBeat.o(176191);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreDetailUI() {
        AppMethodBeat.i(109009);
        AppMethodBeat.o(109009);
    }

    static /* synthetic */ void A(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.i(176198);
        emojiStoreDetailUI.cHK();
        AppMethodBeat.o(176198);
    }

    static /* synthetic */ void f(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.i(109044);
        emojiStoreDetailUI.cHA();
        AppMethodBeat.o(109044);
    }

    static /* synthetic */ void g(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.i(109045);
        emojiStoreDetailUI.cHF();
        AppMethodBeat.o(109045);
    }

    static /* synthetic */ void n(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.i(109046);
        emojiStoreDetailUI.lt(false);
        AppMethodBeat.o(109046);
    }

    static /* synthetic */ void q(EmojiStoreDetailUI emojiStoreDetailUI) {
        AppMethodBeat.i(109049);
        emojiStoreDetailUI.cHw();
        AppMethodBeat.o(109049);
    }

    /* access modifiers changed from: package-private */
    public static class d implements com.tencent.mm.av.a.c.k {
        WeakReference<EmojiStoreDetailUI> cMO;

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        @Override // com.tencent.mm.av.a.c.k
        public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.i(176195);
            Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "[cpan] on image load complete url:%s", str);
            if (this.cMO == null) {
                AppMethodBeat.o(176195);
                return;
            }
            EmojiStoreDetailUI emojiStoreDetailUI = this.cMO.get();
            if (emojiStoreDetailUI == null) {
                AppMethodBeat.o(176195);
                return;
            }
            if (bitmap != null) {
                emojiStoreDetailUI.Ga(1006);
            }
            AppMethodBeat.o(176195);
        }
    }

    static {
        AppMethodBeat.i(176199);
        AppMethodBeat.o(176199);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109010);
        super.onCreate(bundle);
        if (!g.aAc()) {
            finish();
            AppMethodBeat.o(109010);
            return;
        }
        this.rib = z.aUn();
        this.rbL = new com.tencent.mm.plugin.emoji.h.c(2003);
        Intent intent = getIntent();
        this.rcD = getIntent().getStringExtra("extra_id");
        this.reu = getIntent().getIntExtra("preceding_scence", -1);
        this.rcE = getIntent().getStringExtra("extra_name");
        this.rhl = getIntent().getIntExtra("call_by", -1);
        String stringExtra = getIntent().getStringExtra("sns_object_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.rcD = EmojiLogic.amt(stringExtra);
            this.reu = 0;
            this.reu = 10;
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10993, 3, this.rcD);
        }
        if (TextUtils.isEmpty(this.rcD)) {
            Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
            finish();
        }
        if (this.reu == -1) {
            Log.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
            finish();
        }
        this.rik = intent.getBooleanExtra("check_clickflag", true);
        this.ria = intent.getStringExtra("cdn_client_id");
        this.rhZ = intent.getIntExtra("download_entrance_scene", 0);
        this.rio = intent.getBooleanExtra("from_popup", false);
        this.rbH = intent.getLongExtra("searchID", 0);
        this.rbI = Util.nullAs(intent.getStringExtra("docID"), "");
        String stringExtra2 = intent.getStringExtra("extra_copyright");
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.reN.PackCopyright = stringExtra2;
        }
        String stringExtra3 = intent.getStringExtra("extra_coverurl");
        if (!TextUtils.isEmpty(stringExtra3)) {
            this.reN.CoverUrl = stringExtra3;
        }
        String stringExtra4 = intent.getStringExtra("extra_description");
        if (!TextUtils.isEmpty(stringExtra4)) {
            this.reN.PackDesc = stringExtra4;
        }
        String stringExtra5 = intent.getStringExtra("extra_price");
        if (!TextUtils.isEmpty(stringExtra5)) {
            this.reN.PackPrice = stringExtra5;
        }
        int intExtra = intent.getIntExtra("extra_type", -1);
        if (intExtra != -1) {
            this.reN.PackType = intExtra;
        }
        int intExtra2 = intent.getIntExtra("extra_flag", -1);
        if (intExtra2 != -1) {
            this.reN.PackFlag = intExtra2;
        }
        String stringExtra6 = intent.getStringExtra("extra_price_type");
        if (!TextUtils.isEmpty(stringExtra6)) {
            this.reN.PriceType = stringExtra6;
        }
        String stringExtra7 = intent.getStringExtra("extra_price_num");
        if (!TextUtils.isEmpty(stringExtra7)) {
            this.reN.PriceNum = stringExtra7;
        }
        if (this.rib) {
            this.ric = 11;
            k.a(this, this.rih, this.riw);
        }
        this.rhn = intent.getBooleanExtra("reward_tip", false);
        String stringExtra8 = intent.getStringExtra("action_report");
        if (!Util.isNullOrNil(stringExtra8)) {
            this.rbN = new as(stringExtra8);
        }
        this.rih[0] = this.rcD;
        this.reN.ProductID = this.rcD;
        this.reN.PackName = this.rcE;
        this.reN.ShareDesc = this.rhm;
        this.reN.PriceNum = "-1";
        this.reN.Version = -1;
        this.mContext = this;
        riu.cMO = new WeakReference<>(this);
        initView();
        if (!com.tencent.mm.plugin.emoji.h.a.ang(this.rcD)) {
            if (this.reN == null) {
                this.rhq = new m(this.rcD, this.reu);
            } else if (Util.isNullOrNil(this.reO) || !this.reO.equalsIgnoreCase(LocaleUtil.getCurrentLanguage(this.mContext))) {
                this.rhq = new m(this.rcD, this.reu);
            } else {
                this.rhq = new m(this.rcD, this.reu, this.reN.Version);
            }
            g.aAg().hqi.a(this.rhq, 0);
            if (this.rhl == -1 || this.rhl == 3) {
                this.rhx.setVisibility(8);
                this.GQ.setVisibility(8);
                getString(R.string.zb);
                this.jZH = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass4 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(176184);
                        g.aAg().hqi.a(EmojiStoreDetailUI.this.rhq);
                        EmojiStoreDetailUI.this.rhw.setText(R.string.bui);
                        EmojiStoreDetailUI.q(EmojiStoreDetailUI.this);
                        AppMethodBeat.o(176184);
                    }
                });
            }
            cHx();
            if (this.rik) {
                g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.l(this.rcD), 0);
            } else {
                this.rim = true;
                this.ril = EmojiLogic.cFW();
            }
        } else {
            AppCompatActivity context = getContext();
            EmotionDetail emotionDetail = new EmotionDetail();
            emotionDetail.ProductID = new StringBuilder().append(EmojiGroupInfo.VkN).toString();
            emotionDetail.PackName = context.getString(R.string.bvz);
            emotionDetail.PackDesc = context.getString(R.string.bvx);
            emotionDetail.PackAuthInfo = context.getString(R.string.bvv);
            emotionDetail.PackPrice = "";
            emotionDetail.PackType = 0;
            emotionDetail.PackFlag = 1;
            emotionDetail.CoverUrl = "";
            emotionDetail.PackExpire = 0;
            emotionDetail.PackCopyright = context.getString(R.string.bvw);
            emotionDetail.PanelUrl = "";
            emotionDetail.PriceNum = "";
            emotionDetail.PriceType = "";
            emotionDetail.TimeLimitStr = context.getString(R.string.bvy);
            this.reN = emotionDetail;
            this.rim = true;
            this.ril = EmojiLogic.cFW();
            cHz();
        }
        cHA();
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.add(this);
        EventCenter.instance.addListener(this.rey);
        g.aAg().hqi.a(822, this);
        i(this.rcD, getIntent().getIntExtra("extra_status", -1), getIntent().getIntExtra("extra_progress", 0), this.ria);
        this.rin = true;
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12740, 1, "", this.rcD, "", Integer.valueOf(this.rhZ), 26);
        if (this.rhn && this.rhy != null) {
            this.mHandler.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass20 */

                public final void run() {
                    AppMethodBeat.i(176193);
                    EmojiStoreDetailUI.this.rhy.fullScroll(130);
                    AppMethodBeat.o(176193);
                }
            }, 0);
        }
        AppMethodBeat.o(109010);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a2l;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109011);
        if (!Util.isNullOrNil(this.rcE)) {
            setMMTitle(this.rcE);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass21 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(176194);
                EmojiStoreDetailUI.this.finish();
                AppMethodBeat.o(176194);
                return true;
            }
        });
        this.mPadding = com.tencent.mm.cb.a.aG(this.mContext, R.dimen.a23);
        this.rhX = getResources().getDimensionPixelSize(R.dimen.a22);
        this.rhX = com.tencent.mm.cb.a.aG(this.mContext, R.dimen.a22);
        this.mNumColumns = 4;
        this.rhy = (EmojiDetailScrollView) findViewById(R.id.hcv);
        this.GQ = findViewById(R.id.c2g);
        this.rhw = (TextView) this.GQ.findViewById(R.id.c2p);
        this.rhx = findViewById(R.id.c1w);
        this.rhz = (BannerEmojiView) findViewById(R.id.c06);
        this.rhz.setMinimumHeight((int) (((float) (((this.rhz.getRight() - this.rhz.getLeft()) - this.rhz.getPaddingRight()) - this.rhz.getPaddingLeft())) * 0.56f));
        this.rhA = (TextView) findViewById(R.id.c26);
        this.rhB = (MMAutoSizeTextView) findViewById(R.id.c27);
        this.rhC = (TextView) findViewById(R.id.bzq);
        this.rhD = (TextView) findViewById(R.id.c29);
        this.rhE = (TextView) findViewById(R.id.bzu);
        this.rhL = com.tencent.mm.cb.a.jn(getContext());
        this.rhM = findViewById(R.id.byu);
        this.rhF = (EmojiDetailGridView) findViewById(R.id.c02);
        if (com.tencent.mm.plugin.emoji.h.a.ang(this.rcD)) {
            this.rht = new b();
        } else {
            this.rht = new a();
        }
        this.rhH = findViewById(R.id.c1j);
        this.qWX = (ProgressBar) findViewById(R.id.bzx);
        this.rhG = (ImageView) findViewById(R.id.bzo);
        this.rhG.setOnClickListener(this);
        this.rhH.setVisibility(8);
        this.rhG.setVisibility(8);
        this.qWX.setProgress(0);
        this.rhF.setAdapter((ListAdapter) this.rht);
        this.rhF.setColumnWidth(this.rhX);
        this.rhF.setNumColumns(this.mNumColumns);
        this.rhF.setHorizontalSpacing(this.mPadding);
        this.rhF.setVerticalSpacing(this.mPadding);
        this.rhF.setEmojiDetailScrollView(this.rhy);
        this.rhF.setFromDetail(true);
        this.rhF.setIsShowPopWin(true);
        this.rhF.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(176183);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Object item = adapterView.getAdapter().getItem(i2);
                if (item instanceof EmojiInfo) {
                    EmojiInfo emojiInfo = (EmojiInfo) item;
                    ait ait = new ait();
                    if (Util.isNullOrNil(ait.Md5) || ait.Md5.equals(emojiInfo.field_md5)) {
                        ait.Md5 = com.tencent.mm.plugin.emoji.h.b.fX(emojiInfo.field_md5, ait.Md5);
                        ait.Md5 = com.tencent.mm.plugin.emoji.h.b.fX(ait.Md5, "");
                        ait.Url = com.tencent.mm.plugin.emoji.h.b.fX(emojiInfo.field_cdnUrl, ait.Url);
                        ait.ThumbUrl = com.tencent.mm.plugin.emoji.h.b.fX(emojiInfo.field_thumbUrl, ait.ThumbUrl);
                        ait.Lsl = com.tencent.mm.plugin.emoji.h.b.fX(emojiInfo.field_designerID, ait.Lsl);
                        ait.EncryptUrl = com.tencent.mm.plugin.emoji.h.b.fX(emojiInfo.field_encrypturl, ait.EncryptUrl);
                        ait.AesKey = com.tencent.mm.plugin.emoji.h.b.fX(emojiInfo.field_aeskey, ait.AesKey);
                        ait.ProductID = com.tencent.mm.plugin.emoji.h.b.fX(emojiInfo.field_groupId, ait.ProductID);
                        ait.ExternUrl = com.tencent.mm.plugin.emoji.h.b.fX(emojiInfo.field_externUrl, ait.ExternUrl);
                        ait.ExternMd5 = com.tencent.mm.plugin.emoji.h.b.fX(emojiInfo.field_externMd5, ait.ExternMd5);
                        ait.ActivityID = com.tencent.mm.plugin.emoji.h.b.fX(emojiInfo.field_activityid, ait.ActivityID);
                        ait.Lsm = com.tencent.mm.plugin.emoji.h.b.fX(emojiInfo.field_attachedText, ait.Lsm);
                        ait.Lsn = com.tencent.mm.plugin.emoji.h.b.fX(emojiInfo.field_attachTextColor, ait.Lsn);
                        ait.Lso = com.tencent.mm.plugin.emoji.h.b.fX(emojiInfo.field_lensId, ait.Lso);
                    }
                    EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, ait);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12787, 0, 0, emojiInfo.field_md5, Long.valueOf(EmojiStoreDetailUI.this.rbH), emojiInfo.field_designerID, emojiInfo.field_groupId, 26);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(176183);
            }
        });
        this.rhD.setOnClickListener(this);
        this.rhK = findViewById(R.id.i5y);
        this.rhI = (TextView) findViewById(R.id.c1o);
        this.rhJ = (TextView) findViewById(R.id.bzp);
        this.rhI.setOnClickListener(this.riq);
        this.rhJ.setOnClickListener(this.rir);
        this.rhN = (ProgressBar) findViewById(R.id.c00);
        this.rhN.setVisibility(this.rib ? 0 : 8);
        this.rij = findViewById(R.id.c0d);
        if (WeChatBrands.Business.Entries.MeStickerDeclare.banned()) {
            this.rhK.setVisibility(8);
        }
        this.rhR = findViewById(R.id.bzt);
        this.rhO = findViewById(R.id.bne);
        this.rhP = (ImageView) findViewById(R.id.bnk);
        this.rhQ = (TextView) findViewById(R.id.bnu);
        this.rhS = findViewById(R.id.c1k);
        this.rhT = (TextView) findViewById(R.id.h62);
        this.rhU = (Button) findViewById(R.id.h63);
        this.rhW = (TextView) findViewById(R.id.h67);
        this.rhV = (DonorsAvatarView) findViewById(R.id.h61);
        this.rhU.setOnClickListener(this.ris);
        this.rhW.setOnClickListener(this.rit);
        AppMethodBeat.o(109011);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(109012);
        super.onStart();
        AppMethodBeat.o(109012);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(109013);
        super.onResume();
        g.aAg().hqi.a(412, this);
        g.aAg().hqi.a(521, this);
        g.aAg().hqi.a(v2helper.EMethodSetNgStrength, this);
        g.aAg().hqi.a(413, this);
        this.rii = false;
        if (!this.rin) {
            cHx();
            Ga(1007);
        }
        cHy();
        this.rin = false;
        Ga(1001);
        AppMethodBeat.o(109013);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(109014);
        super.onPause();
        g.aAg().hqi.b(412, this);
        g.aAg().hqi.b(521, this);
        g.aAg().hqi.b(v2helper.EMethodSetNgStrength, this);
        g.aAg().hqi.b(413, this);
        AppMethodBeat.o(109014);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(109015);
        super.onStop();
        AppMethodBeat.o(109015);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109016);
        super.onDestroy();
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.remove(this);
        EventCenter.instance.removeListener(this.rey);
        g.aAg().hqi.b(822, this);
        if (this.rhF != null) {
            this.rhF.hfZ();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(109016);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(109017);
        bundle.putInt("status", this.rhp);
        bundle.putInt("progress", this.HH);
        AppMethodBeat.o(109017);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.i(109018);
        this.rhp = bundle.getInt("status");
        this.HH = bundle.getInt("progress");
        AppMethodBeat.o(109018);
    }

    public void onClick(View view) {
        String string;
        AppMethodBeat.i(109019);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        int id = view.getId();
        if (id == R.id.c29) {
            if (this.rhp != 7) {
                switch (this.rhp) {
                    case -1:
                        Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                        break;
                    case 0:
                    case 3:
                        if (this.rio) {
                            e eVar = e.hcl;
                            e.pl(6);
                        }
                        cHK();
                        this.rhp = 6;
                        cHF();
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12066, 1, Integer.valueOf(this.rhZ), "", this.rcD, Long.valueOf(this.rbH), this.rbI);
                        if (this.rbN != null) {
                            this.rbN.eqm = 4;
                            this.rbN.bfK();
                            break;
                        }
                        break;
                    case 1:
                    case 2:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    default:
                        Log.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", Integer.valueOf(this.rhp));
                        break;
                    case 4:
                        if (!this.rii) {
                            if (this.rio) {
                                e eVar2 = e.hcl;
                                e.pl(6);
                            }
                            Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", this.rcD, this.reN.PackPrice, this.reN.PriceType);
                            Intent intent = new Intent();
                            intent.putExtra("key_product_id", this.rcD);
                            if (this.rib) {
                                intent.putExtra("key_currency_type", this.rif);
                                intent.putExtra("key_price", this.rif + this.rig);
                            } else {
                                intent.putExtra("key_currency_type", this.reN.PriceType);
                                intent.putExtra("key_price", this.reN.PriceNum);
                            }
                            com.tencent.mm.br.c.b(this, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12066, 2, Integer.valueOf(this.rhZ), "", this.rcD, Long.valueOf(this.rbH), this.rbI);
                            this.rii = true;
                            break;
                        }
                        break;
                    case 5:
                        this.rhp = 3;
                        cHF();
                        break;
                    case 10:
                    case 12:
                        switch (this.rid) {
                            case 10233:
                                string = getString(R.string.bsp);
                                break;
                            case 10234:
                                string = getString(R.string.bsg);
                                break;
                            case 10235:
                                string = getString(R.string.bwk);
                                break;
                            default:
                                string = getString(R.string.bwp);
                                break;
                        }
                        com.tencent.mm.ui.base.h.c(this, string, null, true);
                        break;
                    case 11:
                        Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                        break;
                }
            } else {
                String stringExtra = getIntent().getStringExtra("to_talker_name");
                if (this.rio) {
                    g.aAg().hqi.a(new r(this.rcD, 2), 0);
                    this.rip = q.a(this, getString(R.string.ek_), true, 0, null);
                } else if (Util.isNullOrNil(stringExtra) || !this.rho) {
                    this.rbL.N(this);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12069, 2, this.rcD);
                } else {
                    com.tencent.mm.plugin.emoji.h.c.a(stringExtra, this.rcD, this);
                }
                Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(11076, "0, ");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109019);
        } else if (id == R.id.bzx) {
            cHJ();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109019);
        } else if (id == R.id.bzo) {
            cHJ();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109019);
        } else {
            Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109019);
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(109020);
        Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.jZH != null && this.jZH.isShowing()) {
            this.jZH.dismiss();
        }
        switch (qVar.getType()) {
            case 412:
                if (qVar instanceof m) {
                    Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
                    m mVar = (m) qVar;
                    if (mVar == null || Util.isNullOrNil(mVar.rcD) || !mVar.rcD.equalsIgnoreCase(this.rcD)) {
                        Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                        AppMethodBeat.o(109020);
                        return;
                    } else if (i2 == 0) {
                        if (i3 == 0) {
                            this.reN = mVar.cGv();
                            Ga(1002);
                            AppMethodBeat.o(109020);
                            return;
                        } else if (i3 == 1) {
                            cHv();
                            AppMethodBeat.o(109020);
                            return;
                        } else {
                            this.rhw.setText(R.string.buh);
                            cHw();
                            AppMethodBeat.o(109020);
                            return;
                        }
                    } else if (i3 == 5) {
                        if (!(mVar == null || mVar.cGv() == null)) {
                            this.reN.PackFlag = mVar.cGv().PackFlag;
                        }
                        Ga(1002);
                        AppMethodBeat.o(109020);
                        return;
                    } else if (i3 == 1) {
                        cHv();
                        AppMethodBeat.o(109020);
                        return;
                    } else {
                        this.rhy.setVisibility(8);
                        this.GQ.setVisibility(0);
                        this.rhw.setText(R.string.bui);
                        cHw();
                        AppMethodBeat.o(109020);
                        return;
                    }
                }
                break;
            case 413:
                if (this.rip != null) {
                    this.rip.dismiss();
                    this.rip = null;
                }
                if (i2 != 0 || i3 != 0) {
                    com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(R.string.bwm), "", "", getContext().getString(R.string.w1), null, null);
                    break;
                } else {
                    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.blc(((r) qVar).rcD);
                    this.rhp = 3;
                    cHF();
                    AppMethodBeat.o(109020);
                    return;
                }
            case v2helper.EMethodSetNgStrength /*{ENCODED_INT: 423}*/:
                if (qVar instanceof h) {
                    Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
                    h hVar = (h) qVar;
                    if (hVar != this.rhr || Util.isNullOrNil(hVar.rcD) || !hVar.rcD.equalsIgnoreCase(this.rcD)) {
                        Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                        AppMethodBeat.o(109020);
                        return;
                    } else if (i2 == 0 && i3 == 0) {
                        this.ria = hVar.iYT;
                        this.rhp = 6;
                        cHF();
                        AppMethodBeat.o(109020);
                        return;
                    } else {
                        this.rhp = -1;
                        cHF();
                        String str2 = this.rcE;
                        com.tencent.mm.ui.base.h.a(this, String.format(getString(R.string.bu8), str2), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass9 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(176188);
                                EmojiStoreDetailUI.this.rhr = new h(EmojiStoreDetailUI.this.rcD, EmojiStoreDetailUI.this.rcF, EmojiStoreDetailUI.this.rcE);
                                EmojiStoreDetailUI.A(EmojiStoreDetailUI.this);
                                EmojiStoreDetailUI.this.rhp = 6;
                                EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
                                AppMethodBeat.o(176188);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass10 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(108988);
                                AppMethodBeat.o(108988);
                            }
                        });
                        AppMethodBeat.o(109020);
                        return;
                    }
                }
                break;
            case 521:
                Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDesc");
                com.tencent.mm.plugin.emoji.f.l lVar = (com.tencent.mm.plugin.emoji.f.l) qVar;
                if (lVar == null || Util.isNullOrNil(lVar.rcq) || !lVar.rcq.equalsIgnoreCase(this.rcD)) {
                    Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                } else {
                    if (i2 == 0 && i3 == 0) {
                        this.ril = (bms) lVar.rr.iLL.iLR;
                    } else {
                        this.ril = null;
                    }
                    this.rim = true;
                    cHG();
                }
                this.rim = true;
                cHG();
                AppMethodBeat.o(109020);
                return;
            case 822:
                if (qVar instanceof p) {
                    Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
                    if (i2 == 0 && i3 == 0) {
                        this.rhu = ((p) qVar).cGz();
                        Ga(1007);
                        AppMethodBeat.o(109020);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(109020);
    }

    private void cHv() {
        AppMethodBeat.i(109021);
        this.GQ.setVisibility(0);
        this.rhx.setVisibility(8);
        this.rhy.setVisibility(8);
        this.rhw.setText(R.string.bso);
        AppMethodBeat.o(109021);
    }

    private void cHw() {
        AppMethodBeat.i(109022);
        Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
        if (this.reN == null || this.reN.PackFlag == 0) {
            this.GQ.setVisibility(0);
            this.rhx.setVisibility(8);
        }
        AppMethodBeat.o(109022);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(109023);
        Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 2001) {
            String str = "";
            int i4 = 0;
            if (intent != null) {
                i4 = intent.getIntExtra("key_err_code", 0);
                Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "errCode:".concat(String.valueOf(i4)));
                str = intent.getStringExtra("key_err_msg");
                Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "errMsg:".concat(String.valueOf(str)));
            }
            this.rii = false;
            if (i3 != -1) {
                this.rhp = -1;
                cHF();
                if (z.aUn()) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(166, 6, 1, false);
                    AppMethodBeat.o(109023);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(166, 2, 1, false);
                AppMethodBeat.o(109023);
            } else if (intent != null && i4 == 0) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_series_ids");
                if (stringArrayListExtra == null || !stringArrayListExtra.contains(this.rcD)) {
                    this.rhp = -1;
                    cHF();
                    amQ(str);
                    AppMethodBeat.o(109023);
                    return;
                }
                for (int i5 = 0; i5 < stringArrayListExtra.size(); i5++) {
                    if (this.rcD.equals(stringArrayListExtra.get(i5))) {
                        this.rcF = stringArrayListExtra2.get(i5);
                    }
                }
                this.reN.PackFlag = 1;
                cHK();
                this.rhp = 6;
                com.tencent.mm.ui.base.h.cD(this, str);
                if (z.aUn()) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(166, 4, 1, false);
                    AppMethodBeat.o(109023);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(166, 0, 1, false);
                AppMethodBeat.o(109023);
            } else if (intent != null && i4 == 100000002) {
                cHK();
                this.rhp = 6;
                this.rht.notifyDataSetChanged();
                if (z.aUn()) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(166, 7, 1, false);
                    AppMethodBeat.o(109023);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(166, 3, 1, false);
                AppMethodBeat.o(109023);
            } else if (intent == null || i4 != 1) {
                this.rhp = -1;
                cHF();
                amQ(str);
                if (z.aUn()) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(166, 5, 1, false);
                    AppMethodBeat.o(109023);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(166, 1, 1, false);
                AppMethodBeat.o(109023);
            } else {
                this.rhp = -1;
                cHF();
                if (z.aUn()) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(166, 6, 1, false);
                    AppMethodBeat.o(109023);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(166, 2, 1, false);
                AppMethodBeat.o(109023);
            }
        } else {
            if (i2 == 2002) {
                if (i3 == -1) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!Util.isNullOrNil(stringExtra)) {
                        Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "..".concat(String.valueOf(stringExtra)));
                        String str2 = this.rcD;
                        String str3 = this.reN.PackName;
                        String str4 = this.reN.PackDesc;
                        String str5 = this.reN.IconUrl;
                        String str6 = this.reN.OldRedirectUrl;
                        int i6 = this.reN.PackFlag;
                        ((j) g.af(j.class)).a(this, stringExtra, getResources().getString(R.string.tw) + str3, getString(R.string.yq), getString(R.string.b97), str5, 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0284: INVOKE  
                              (wrap: com.tencent.mm.pluginsdk.j : 0x0275: CHECK_CAST (r14v1 com.tencent.mm.pluginsdk.j) = (com.tencent.mm.pluginsdk.j) (wrap: com.tencent.mm.kernel.c.a : 0x0270: INVOKE  (r2v34 com.tencent.mm.kernel.c.a) = (wrap: java.lang.Class : 0x026e: CONST_CLASS   com.tencent.mm.pluginsdk.j.class) type: STATIC call: com.tencent.mm.kernel.g.af(java.lang.Class):com.tencent.mm.kernel.c.a))
                              (r16v0 'this' com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI A[IMMUTABLE_TYPE, THIS])
                              (r3v4 'stringExtra' java.lang.String)
                              (wrap: java.lang.String : ?: STR_CONCAT  
                              (wrap: java.lang.String : 0x0247: INVOKE  
                              (wrap: android.content.res.Resources : 0x0240: INVOKE  (r16v0 'this' com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: com.tencent.mm.ui.MMActivity.getResources():android.content.res.Resources)
                              (wrap: int : ?: SGET   com.tencent.mm.R.string.tw int)
                             type: VIRTUAL call: android.content.res.Resources.getString(int):java.lang.String)
                              (r5v7 'str3' java.lang.String)
                            )
                              (wrap: java.lang.String : 0x0261: INVOKE  (r12v0 java.lang.String) = 
                              (r16v0 'this' com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI A[IMMUTABLE_TYPE, THIS])
                              (wrap: int : ?: SGET   com.tencent.mm.R.string.yq int)
                             type: VIRTUAL call: com.tencent.mm.ui.MMActivity.getString(int):java.lang.String)
                              (wrap: java.lang.String : 0x026a: INVOKE  (r13v0 java.lang.String) = 
                              (r16v0 'this' com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI A[IMMUTABLE_TYPE, THIS])
                              (wrap: int : ?: SGET   com.tencent.mm.R.string.b97 int)
                             type: VIRTUAL call: com.tencent.mm.ui.MMActivity.getString(int):java.lang.String)
                              (r7v0 'str5' java.lang.String)
                              (wrap: com.tencent.mm.plugin.emoji.e.j$1 : 0x027b: CONSTRUCTOR  (r2v35 com.tencent.mm.plugin.emoji.e.j$1) = 
                              (r3v4 'stringExtra' java.lang.String)
                              (r4v7 'str2' java.lang.String)
                              (r5v7 'str3' java.lang.String)
                              (r6v6 'str4' java.lang.String)
                              (r7v0 'str5' java.lang.String)
                              (r8v0 'str6' java.lang.String)
                              (r9v0 'i6' int)
                              (r16v0 'this' com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI A[IMMUTABLE_TYPE, THIS])
                             call: com.tencent.mm.plugin.emoji.e.j.1.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.tencent.mm.ui.MMActivity):void type: CONSTRUCTOR)
                             type: INTERFACE call: com.tencent.mm.pluginsdk.j.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.tencent.mm.pluginsdk.ui.applet.y$a):void in method: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.onActivityResult(int, int, android.content.Intent):void, file: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x027b: CONSTRUCTOR  (r2v35 com.tencent.mm.plugin.emoji.e.j$1) = 
                              (r3v4 'stringExtra' java.lang.String)
                              (r4v7 'str2' java.lang.String)
                              (r5v7 'str3' java.lang.String)
                              (r6v6 'str4' java.lang.String)
                              (r7v0 'str5' java.lang.String)
                              (r8v0 'str6' java.lang.String)
                              (r9v0 'i6' int)
                              (r16v0 'this' com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI A[IMMUTABLE_TYPE, THIS])
                             call: com.tencent.mm.plugin.emoji.e.j.1.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.tencent.mm.ui.MMActivity):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.onActivityResult(int, int, android.content.Intent):void, file: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 34 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.emoji.e.j, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 40 more
                            */
                        /*
                        // Method dump skipped, instructions count: 773
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.onActivityResult(int, int, android.content.Intent):void");
                    }

                    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
                    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                        AppMethodBeat.i(109024);
                        Ga(1001);
                        AppMethodBeat.o(109024);
                    }

                    private void amQ(String str) {
                        AppMethodBeat.i(109025);
                        if (TextUtils.isEmpty(str)) {
                            str = getString(R.string.bt6);
                        }
                        com.tencent.mm.ui.base.h.d(this, str, "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        AppMethodBeat.o(109025);
                    }

                    private void cHx() {
                        AppMethodBeat.i(109026);
                        this.rhu = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpS.blu(this.rcD);
                        AppMethodBeat.o(109026);
                    }

                    private void cHy() {
                        AppMethodBeat.i(109027);
                        if (com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackFlag, 64) && n.auV()) {
                            this.rhs = new p(this.rcD, p.rde);
                            g.aAg().hqi.a(this.rhs, 0);
                        }
                        AppMethodBeat.o(109027);
                    }

                    private boolean cHz() {
                        AppMethodBeat.i(109028);
                        boolean cHz = com.tencent.mm.plugin.emoji.h.a.cHz();
                        this.rhv = cHz;
                        this.rhp = cHz ? 7 : 3;
                        AppMethodBeat.o(109028);
                        return cHz;
                    }

                    private void cHA() {
                        AppMethodBeat.i(109029);
                        if (!Util.isNullOrNil(this.reN.PackName)) {
                            setMMTitle(this.reN.PackName);
                            this.rcE = this.reN.PackName;
                        }
                        Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", this.reN.PanelUrl);
                        this.rhx.setVisibility(0);
                        this.GQ.setVisibility(8);
                        lt(true);
                        this.rhB.setText(this.reN.PackName);
                        this.rhC.setText(this.reN.PackCopyright);
                        this.rhE.setText(this.reN.PackDesc);
                        if (com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackType, 1)) {
                            this.rhA.setVisibility(8);
                        } else {
                            this.rhA.setVisibility(0);
                            this.rhA.setText(R.string.bwo);
                        }
                        cHE();
                        cHF();
                        cHG();
                        cHH();
                        cHI();
                        this.rhB.setMaxWidth((((this.rhL - this.rhM.getWidth()) - (com.tencent.mm.cb.a.aG(getContext(), R.dimen.ir) * 2)) - this.rhA.getWidth()) - (com.tencent.mm.cb.a.aG(getContext(), R.dimen.i1) * 2));
                        this.rhB.setVisibility(8);
                        this.rhB.setVisibility(0);
                        cHB();
                        cHD();
                        cHC();
                        AppMethodBeat.o(109029);
                    }

                    private void lt(boolean z) {
                        AppMethodBeat.i(109030);
                        EmojiInfo emojiInfo = null;
                        if (!Util.isNullOrNil(this.reN.CoverUrl)) {
                            if (z) {
                                String str = this.rcD;
                                String str2 = this.reN.CoverUrl;
                                com.tencent.mm.cb.a.getDensity(this.mContext);
                                emojiInfo = EmojiLogic.a(str, str2, riu);
                            } else {
                                String str3 = this.rcD;
                                String str4 = this.reN.CoverUrl;
                                com.tencent.mm.cb.a.getDensity(this.mContext);
                                emojiInfo = EmojiLogic.H(str3, 4, str4);
                            }
                        }
                        if (!(emojiInfo == null || this.rhz == null)) {
                            this.rhz.setImageFilePath(emojiInfo.hYx());
                        }
                        if (com.tencent.mm.plugin.emoji.h.a.ang(this.rcD)) {
                            this.rhz.setImageResource(R.drawable.bpb);
                        }
                        AppMethodBeat.o(109030);
                    }

                    private void cHB() {
                        AppMethodBeat.i(109031);
                        if (this.reN.PersonalDesigner == null || this.reN.PersonalDesigner.DesignerUin == 0 || this.rhZ == 6) {
                            this.rhR.setVisibility(8);
                            this.rhO.setVisibility(8);
                            AppMethodBeat.o(109031);
                            return;
                        }
                        this.rhR.setVisibility(0);
                        this.rhO.setVisibility(0);
                        com.tencent.mm.av.q.bcV().a(this.reN.PersonalDesigner.HeadUrl, this.rhP, com.tencent.mm.plugin.emoji.e.e.fR(this.rcD, this.reN.PersonalDesigner.HeadUrl));
                        this.rhQ.setText(this.reN.PersonalDesigner.Name);
                        this.rhO.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass5 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(176185);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Intent intent = new Intent();
                                intent.setClass(EmojiStoreDetailUI.this.getContext(), EmojiStoreV2DesignerUI.class);
                                intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, EmojiStoreDetailUI.this.reN.PersonalDesigner.DesignerUin);
                                intent.putExtra("name", EmojiStoreDetailUI.this.reN.PersonalDesigner.Name);
                                intent.putExtra("headurl", EmojiStoreDetailUI.this.reN.PersonalDesigner.HeadUrl);
                                intent.putExtra("rediret_url", EmojiStoreDetailUI.this.reN.OldRedirectUrl);
                                intent.putExtra("searchID", EmojiStoreDetailUI.this.rbH);
                                intent.putExtra("extra_scence", 26);
                                AppCompatActivity context = EmojiStoreDetailUI.this.getContext();
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(176185);
                            }
                        });
                        AppMethodBeat.o(109031);
                    }

                    public final void cHC() {
                        AppMethodBeat.i(109032);
                        if (!com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackFlag, 64) || !n.auV()) {
                            this.rhS.setVisibility(8);
                            AppMethodBeat.o(109032);
                        } else if (this.rhu != null) {
                            this.rhS.setVisibility(0);
                            this.rhU.setText(R.string.bv3);
                            this.rhT.setText(this.rhu.Reward.LsK);
                            this.rhT.setLongClickable(false);
                            if (this.rhu.DonorNum > 0) {
                                this.rhW.setVisibility(0);
                                String valueOf = String.valueOf(this.rhu.DonorNum);
                                String format = String.format(getString(R.string.bv7), Integer.valueOf(this.rhu.DonorNum));
                                SpannableString spannableString = new SpannableString(format);
                                int indexOf = format.indexOf(valueOf);
                                if (indexOf >= 0) {
                                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.n5)), indexOf, valueOf.length() + indexOf, 33);
                                }
                                this.rhW.setText(spannableString);
                            } else {
                                this.rhW.setVisibility(8);
                            }
                            if (this.rhu.Donors == null || this.rhu.Donors.size() <= 0) {
                                this.rhV.setVisibility(8);
                                AppMethodBeat.o(109032);
                                return;
                            }
                            this.rhV.setVisibility(0);
                            this.rhV.d(this.rcD, this.rhu.Donors);
                            AppMethodBeat.o(109032);
                        } else {
                            this.rhS.setVisibility(8);
                            cHy();
                            AppMethodBeat.o(109032);
                        }
                    }

                    private void cHD() {
                        AppMethodBeat.i(109033);
                        if ((this.reN.PackFlag & 32) == 32) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.rhJ.getLayoutParams();
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.rhI.getLayoutParams();
                            this.rhJ.setVisibility(0);
                            layoutParams.weight = 1.0f;
                            layoutParams.gravity = 3;
                            layoutParams.leftMargin = com.tencent.mm.cb.a.aG(getContext(), R.dimen.ir);
                            this.rhJ.setLayoutParams(layoutParams);
                            this.rhJ.setGravity(3);
                            layoutParams2.weight = 1.0f;
                            layoutParams2.gravity = 5;
                            layoutParams2.rightMargin = com.tencent.mm.cb.a.aG(getContext(), R.dimen.ir);
                            this.rhI.setLayoutParams(layoutParams2);
                            this.rhI.setGravity(5);
                            AppMethodBeat.o(109033);
                            return;
                        }
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.rhI.getLayoutParams();
                        layoutParams3.gravity = 17;
                        this.rhI.setLayoutParams(layoutParams3);
                        this.rhI.setGravity(17);
                        this.rhJ.setVisibility(8);
                        AppMethodBeat.o(109033);
                    }

                    private void cHE() {
                        AppMethodBeat.i(109034);
                        if (com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackType, 8)) {
                            this.rhY = 0;
                        } else if (com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackType, 4)) {
                            this.rhY = 0;
                        } else if (this.rib || !TextUtils.isEmpty(this.reN.PackPrice)) {
                            this.rhY = 1;
                        } else {
                            this.rhY = 0;
                        }
                        Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", Integer.valueOf(this.reN.PackFlag));
                        if (com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackFlag, 8) && com.tencent.mm.plugin.emoji.a.a.e.FT(this.reN.PackType)) {
                            this.rhp = 8;
                        } else if (com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackFlag, 1) || com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackType, 8)) {
                            this.rhp = 3;
                        } else if (com.tencent.mm.plugin.emoji.a.a.e.FT(this.reN.PackType)) {
                            this.rhp = 0;
                        } else if (!this.rib && (TextUtils.isEmpty(this.reN.PriceNum) || this.reN.PriceNum.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
                            this.rhp = 0;
                        } else if (!this.rib) {
                            this.rhp = 4;
                        } else if (TextUtils.isEmpty(this.rie)) {
                            this.rhp = this.ric;
                        } else {
                            this.rhp = 4;
                        }
                        if (this.rhv) {
                            this.rhp = 7;
                        }
                        AppMethodBeat.o(109034);
                    }

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    private void cHF() {
                        AppMethodBeat.i(109035);
                        if (com.tencent.mm.plugin.emoji.h.a.ang(this.rcD)) {
                            cHz();
                        }
                        switch (this.rhp) {
                            case -1:
                                cHE();
                                cHF();
                                break;
                            case 0:
                                this.rhN.setVisibility(8);
                                this.rhD.setTextColor(getResources().getColorStateList(R.color.ag5));
                                this.rhD.setBackgroundResource(R.drawable.k7);
                                this.rhD.setText(R.string.bu7);
                                this.rhD.setEnabled(true);
                                break;
                            case 1:
                            case 2:
                            case 9:
                            default:
                                Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", Integer.valueOf(this.rhp));
                                break;
                            case 3:
                                this.rhN.setVisibility(8);
                                this.rhD.setTextColor(getResources().getColorStateList(R.color.ag5));
                                this.rhD.setBackgroundResource(R.drawable.k7);
                                this.rhD.setText(R.string.bu7);
                                this.rhD.setEnabled(true);
                                break;
                            case 4:
                                this.rhN.setVisibility(8);
                                this.rhD.setTextColor(getResources().getColorStateList(R.color.ag5));
                                this.rhD.setBackgroundResource(R.drawable.k7);
                                this.rhD.setEnabled(true);
                                if (this.rib) {
                                    if (!Util.isNullOrNil(this.rie)) {
                                        this.rhD.setText(this.rie);
                                        break;
                                    } else {
                                        this.rhD.setText("");
                                        break;
                                    }
                                } else {
                                    this.rhD.setText(this.reN.PackPrice);
                                    this.rhp = 4;
                                    break;
                                }
                            case 5:
                                this.rhN.setVisibility(8);
                                this.rhD.setBackgroundResource(R.drawable.k7);
                                this.rhD.setText(R.string.bu7);
                                this.rhD.setEnabled(true);
                                this.rhN.setVisibility(0);
                                this.rhD.setVisibility(0);
                                this.rhD.setBackgroundResource(R.drawable.brg);
                                this.rhD.setText("");
                                this.rhD.setEnabled(false);
                                this.rhH.setVisibility(8);
                                this.qWX.setProgress(0);
                                this.rhG.setVisibility(4);
                                break;
                            case 6:
                                this.rhN.setVisibility(8);
                                this.rhD.setEnabled(false);
                                this.rhH.setVisibility(0);
                                this.rhG.setVisibility(0);
                                this.rhD.setVisibility(4);
                                if (this.rhl != 3) {
                                }
                                break;
                            case 7:
                                this.rhN.setVisibility(8);
                                this.rhD.setVisibility(0);
                                this.rhD.setEnabled(true);
                                if (this.rio) {
                                    this.rhD.setText(R.string.bta);
                                    this.rhD.setTextColor(getResources().getColorStateList(R.color.tv));
                                    this.rhD.setBackgroundResource(R.drawable.k9);
                                } else {
                                    this.rhD.setTextColor(getResources().getColorStateList(R.color.ag5));
                                    this.rhD.setText(R.string.bw2);
                                    this.rhD.setBackgroundResource(R.drawable.k7);
                                }
                                this.rhH.setVisibility(8);
                                this.qWX.setProgress(0);
                                this.rhG.setVisibility(4);
                                if (this.rhl != 3) {
                                }
                                break;
                            case 8:
                                this.rhN.setVisibility(8);
                                this.rhD.setTextColor(getResources().getColorStateList(R.color.mr));
                                this.rhD.setBackgroundResource(R.drawable.kd);
                                this.rhD.setText(R.string.bu_);
                                this.rhD.setEnabled(false);
                                break;
                            case 10:
                            case 12:
                                this.rhN.setVisibility(8);
                                this.rhD.setVisibility(0);
                                this.rhD.setBackgroundResource(R.drawable.k7);
                                this.rhD.setText(R.string.buu);
                                this.rhD.setEnabled(true);
                                this.rhH.setVisibility(8);
                                this.qWX.setProgress(0);
                                this.rhG.setVisibility(4);
                                break;
                            case 11:
                                this.rhN.setVisibility(0);
                                this.rhD.setVisibility(0);
                                this.rhD.setBackgroundResource(R.drawable.brg);
                                this.rhD.setText("");
                                this.rhD.setEnabled(false);
                                this.rhH.setVisibility(8);
                                this.qWX.setProgress(0);
                                this.rhG.setVisibility(4);
                                break;
                        }
                        cHG();
                        AppMethodBeat.o(109035);
                    }

                    private void cHG() {
                        AppMethodBeat.i(109036);
                        if (this.rim && ((this.ril == null || (this.ril.LVu & 1) != 1) && ((this.reN == null || !com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackFlag, 1)) && this.ril != null && !TextUtils.isEmpty(this.ril.LVt)))) {
                            this.rhD.setText(this.ril.LVt);
                            this.rhD.setTextColor(getContext().getResources().getColor(R.color.u_));
                            this.rhD.setBackgroundDrawable(null);
                            this.rhD.setEnabled(false);
                        }
                        AppMethodBeat.o(109036);
                    }

                    private void cHH() {
                        AppMethodBeat.i(109037);
                        if (com.tencent.mm.plugin.emoji.h.a.ang(this.rcD) || !(this.reN.ThumbExtList == null || this.reN.ThumbExtList.size() <= 0 || this.reN.ThumbExtList.get(0).PreviewUrl == null)) {
                            this.rij.setVisibility(0);
                        } else {
                            this.rij.setVisibility(8);
                        }
                        this.rhF.setProductId(this.rcD);
                        if (this.rht != null) {
                            this.rht.notifyDataSetInvalidated();
                        }
                        AppMethodBeat.o(109037);
                    }

                    private void cHI() {
                        AppMethodBeat.i(109038);
                        Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", new StringBuilder().append(this.reN.PackFlag).toString());
                        if ((this.reN.PackFlag & 16) == 16) {
                            addIconOptionMenu(0, R.raw.icons_outlined_share, new MenuItem.OnMenuItemClickListener() {
                                /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass6 */

                                public final boolean onMenuItemClick(MenuItem menuItem) {
                                    AppMethodBeat.i(176186);
                                    Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "on shard click.");
                                    EmojiStoreDetailUI.r(EmojiStoreDetailUI.this);
                                    AppMethodBeat.o(176186);
                                    return true;
                                }
                            });
                        }
                        AppMethodBeat.o(109038);
                    }

                    private void cHJ() {
                        AppMethodBeat.i(109039);
                        com.tencent.mm.ui.base.h.a(this, (int) R.string.btz, 0, (int) R.string.bvq, (int) R.string.bu2, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass7 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(176187);
                                if (com.tencent.mm.plugin.emoji.h.a.ang(EmojiStoreDetailUI.this.rcD)) {
                                    Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
                                    com.tencent.mm.plugin.emoji.f.a.cGm().cGo();
                                } else {
                                    g.aAg().hqi.a(EmojiStoreDetailUI.this.rhr);
                                }
                                if (!TextUtils.isEmpty(EmojiStoreDetailUI.this.ria)) {
                                    f.baQ().Oc(EmojiStoreDetailUI.this.ria);
                                    Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", EmojiStoreDetailUI.this.ria);
                                }
                                if (com.tencent.mm.plugin.emoji.a.a.e.fA(EmojiStoreDetailUI.this.reN.PackFlag, 1) || com.tencent.mm.plugin.emoji.a.a.e.FT(EmojiStoreDetailUI.this.reN.PackType)) {
                                    EmojiStoreDetailUI.this.rhp = 3;
                                } else {
                                    EmojiStoreDetailUI.this.rhp = -1;
                                }
                                com.tencent.mm.plugin.emoji.model.k.cGk().h(EmojiStoreDetailUI.this.rcD, EmojiStoreDetailUI.this.rhp, 0, EmojiStoreDetailUI.this.ria);
                                EmojiStoreDetailUI.this.rhH.setVisibility(8);
                                EmojiStoreDetailUI.this.qWX.setProgress(0);
                                EmojiStoreDetailUI.this.rhG.setVisibility(4);
                                EmojiStoreDetailUI.this.rhD.setVisibility(0);
                                int unused = EmojiStoreDetailUI.this.rhl;
                                EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
                                g.aAg().hqi.a(new r(EmojiStoreDetailUI.this.rcD, 2), 0);
                                AppMethodBeat.o(176187);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass8 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(108987);
                                AppMethodBeat.o(108987);
                            }
                        });
                        AppMethodBeat.o(109039);
                    }

                    /* access modifiers changed from: package-private */
                    public class a extends BaseAdapter implements com.tencent.mm.view.a.a {
                        public a() {
                        }

                        public int getCount() {
                            AppMethodBeat.i(109000);
                            if (EmojiStoreDetailUI.this.reN == null) {
                                AppMethodBeat.o(109000);
                                return 0;
                            }
                            int i2 = EmojiStoreDetailUI.this.reN.PackThumbCnt;
                            AppMethodBeat.o(109000);
                            return i2;
                        }

                        public Object getItem(int i2) {
                            AppMethodBeat.i(109001);
                            if (EmojiStoreDetailUI.this.reN == null || EmojiStoreDetailUI.this.reN.ThumbExtList == null || EmojiStoreDetailUI.this.reN.ThumbExtList.size() <= 0 || EmojiStoreDetailUI.this.reN.ThumbExtList.get(i2) == null || EmojiStoreDetailUI.this.reN.ThumbExtList.get(i2).PreviewUrl == null) {
                                AppMethodBeat.o(109001);
                                return null;
                            }
                            Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks get preview : %d", Integer.valueOf(i2));
                            PackThumbExt packThumbExt = EmojiStoreDetailUI.this.reN.ThumbExtList.get(i2);
                            EmojiInfo emojiInfo = new EmojiInfo();
                            emojiInfo.field_md5 = packThumbExt.Md5;
                            emojiInfo.field_thumbUrl = packThumbExt.ThumbUrl;
                            emojiInfo.field_cdnUrl = packThumbExt.CDNUrl;
                            emojiInfo.field_aeskey = packThumbExt.AesKey;
                            emojiInfo.field_encrypturl = packThumbExt.EncryptUrl;
                            emojiInfo.field_externUrl = packThumbExt.ExternUrl;
                            emojiInfo.field_externMd5 = packThumbExt.ExternMd5;
                            emojiInfo.field_activityid = packThumbExt.ActivityID;
                            emojiInfo.field_groupId = EmojiStoreDetailUI.this.rcD;
                            emojiInfo.field_catalog = 84;
                            emojiInfo.field_reserved4 |= EmojiInfo.Vll;
                            AppMethodBeat.o(109001);
                            return emojiInfo;
                        }

                        public long getItemId(int i2) {
                            return (long) i2;
                        }

                        public View getView(int i2, View view, ViewGroup viewGroup) {
                            c cVar;
                            AppMethodBeat.i(109002);
                            if (view == null || view.getTag() == null) {
                                view = LayoutInflater.from(EmojiStoreDetailUI.this.mContext).inflate(R.layout.a2n, (ViewGroup) null);
                                c cVar2 = new c(view);
                                view.setTag(cVar2);
                                cVar = cVar2;
                            } else {
                                cVar = (c) view.getTag();
                            }
                            if (EmojiStoreDetailUI.this.rhF.Rnf) {
                                cVar.riz.setBackgroundResource(R.drawable.smiley_item_bg2);
                            } else {
                                cVar.riz.setBackgroundDrawable(null);
                            }
                            String str = "";
                            if (EmojiStoreDetailUI.this.reN.PackThumbList != null) {
                                str = com.tencent.mm.platformtools.z.a(EmojiStoreDetailUI.this.reN.PackThumbList.get(i2));
                            }
                            com.tencent.mm.av.q.bcV().a(str, cVar.riz, com.tencent.mm.plugin.emoji.e.e.fQ(EmojiStoreDetailUI.this.rcD, str));
                            AppMethodBeat.o(109002);
                            return view;
                        }
                    }

                    /* access modifiers changed from: package-private */
                    public class b extends a {
                        private ArrayList<EmojiInfo> riy;

                        @Override // com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.a
                        public final /* synthetic */ Object getItem(int i2) {
                            AppMethodBeat.i(109007);
                            EmojiInfo FY = FY(i2);
                            AppMethodBeat.o(109007);
                            return FY;
                        }

                        public b() {
                            super();
                            AppMethodBeat.i(109003);
                            this.riy = new ArrayList<>();
                            this.riy = (ArrayList) com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.amo(com.tencent.mm.plugin.emoji.h.a.cIr());
                            AppMethodBeat.o(109003);
                        }

                        @Override // com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.a
                        public final int getCount() {
                            AppMethodBeat.i(109004);
                            if (this.riy == null) {
                                AppMethodBeat.o(109004);
                                return 0;
                            }
                            int size = this.riy.size();
                            AppMethodBeat.o(109004);
                            return size;
                        }

                        private EmojiInfo FY(int i2) {
                            AppMethodBeat.i(109005);
                            if (this.riy == null) {
                                AppMethodBeat.o(109005);
                                return null;
                            }
                            EmojiInfo emojiInfo = this.riy.get(i2);
                            AppMethodBeat.o(109005);
                            return emojiInfo;
                        }

                        @Override // com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.a
                        public final long getItemId(int i2) {
                            return (long) i2;
                        }

                        @Override // com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.a
                        public final View getView(int i2, View view, ViewGroup viewGroup) {
                            c cVar;
                            AppMethodBeat.i(109006);
                            if (view == null || view.getTag() == null) {
                                view = LayoutInflater.from(EmojiStoreDetailUI.this.mContext).inflate(R.layout.a2n, (ViewGroup) null);
                                cVar = new c(view);
                                view.setTag(cVar);
                            } else {
                                cVar = (c) view.getTag();
                            }
                            cVar.riz.setBackgroundResource(R.drawable.smiley_item_bg2);
                            EmojiInfo FY = FY(i2);
                            com.tencent.mm.av.q.bcV().a((Util.isNullOrNil(FY.getContent()) ? FY.getName() : FY.getContent()).split("\\.")[0], cVar.riz, com.tencent.mm.plugin.emoji.e.e.cFG());
                            AppMethodBeat.o(109006);
                            return view;
                        }
                    }

                    class c {
                        SquareImageView riz;

                        public c(View view) {
                            AppMethodBeat.i(109008);
                            this.riz = (SquareImageView) view.findViewById(R.id.bob);
                            this.riz.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            AppMethodBeat.o(109008);
                        }
                    }

                    public final void i(String str, int i2, int i3, String str2) {
                        AppMethodBeat.i(109040);
                        Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", str, Integer.valueOf(i2), Integer.valueOf(i3), str2);
                        if (Util.isNullOrNil(str) || !str.equals(this.rcD)) {
                            AppMethodBeat.o(109040);
                            return;
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            this.ria = str2;
                        }
                        if (i2 == -1) {
                            if (this.rhp != -1) {
                                this.rhp = -1;
                                Ga(1003);
                                AppMethodBeat.o(109040);
                                return;
                            }
                        } else if (i2 == 7) {
                            this.rhp = 7;
                            Ga(1003);
                            AppMethodBeat.o(109040);
                            return;
                        } else if (i2 != 6) {
                            Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "[onExchange] do nothing.");
                        } else if (!TextUtils.isEmpty(str) && str.equals(this.rcD)) {
                            this.rhp = 6;
                            this.HH = i3;
                            Ga(1004);
                            AppMethodBeat.o(109040);
                            return;
                        }
                        AppMethodBeat.o(109040);
                    }

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    private void cHK() {
                        AppMethodBeat.i(109041);
                        if (com.tencent.mm.plugin.emoji.h.a.ang(this.rcD)) {
                            com.tencent.mm.plugin.emoji.f.a.cGm();
                            com.tencent.mm.plugin.emoji.f.a.cGn();
                            AppMethodBeat.o(109041);
                            return;
                        }
                        this.rhr = new h(this.rcD, this.rcF, this.rcE);
                        g.aAg().hqi.a(this.rhr, 0);
                        switch (this.reu) {
                            case 9:
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11598, 2, this.rcD);
                                break;
                            case 10:
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11598, 1, this.rcD);
                                AppMethodBeat.o(109041);
                                return;
                            case 11:
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11598, 3, this.rcD);
                                AppMethodBeat.o(109041);
                                return;
                        }
                        AppMethodBeat.o(109041);
                    }

                    public final void Ga(int i2) {
                        AppMethodBeat.i(109042);
                        if (this.mHandler != null) {
                            this.mHandler.sendEmptyMessage(i2);
                        }
                        AppMethodBeat.o(109042);
                    }

                    static /* synthetic */ void e(EmojiStoreDetailUI emojiStoreDetailUI) {
                        AppMethodBeat.i(109043);
                        if (!com.tencent.mm.plugin.emoji.h.a.ang(emojiStoreDetailUI.rcD)) {
                            if (g.aAh().isSDCardAvailable() && com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.blb(emojiStoreDetailUI.rcD)) {
                                if (com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.bld(emojiStoreDetailUI.rcD) > 0) {
                                    StringBuilder sb = new StringBuilder();
                                    com.tencent.mm.emoji.e.a aVar = com.tencent.mm.emoji.e.a.hdT;
                                    o oVar = new o(sb.append(com.tencent.mm.emoji.e.a.awt()).append(emojiStoreDetailUI.rcD).toString());
                                    if (oVar.exists()) {
                                        o[] het = oVar.het();
                                        if (het == null || het.length <= 0) {
                                            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.blc(emojiStoreDetailUI.rcD);
                                            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blo(emojiStoreDetailUI.rcD);
                                        } else {
                                            emojiStoreDetailUI.rhv = true;
                                            emojiStoreDetailUI.rhp = 7;
                                            emojiStoreDetailUI.cHF();
                                            AppMethodBeat.o(109043);
                                            return;
                                        }
                                    }
                                } else {
                                    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blo(emojiStoreDetailUI.rcD);
                                }
                            }
                            emojiStoreDetailUI.rhv = false;
                        }
                        AppMethodBeat.o(109043);
                    }

                    static /* synthetic */ void a(EmojiStoreDetailUI emojiStoreDetailUI, ait ait) {
                        AppMethodBeat.i(176196);
                        try {
                            Intent intent = new Intent();
                            intent.putExtra("extra_object", ait.toByteArray());
                            intent.setClass(emojiStoreDetailUI.getContext(), EmojiStoreV2SingleProductDialogUI.class);
                            intent.putExtra("add_source", 8);
                            intent.putExtra("entrance_scene", 26);
                            emojiStoreDetailUI.startActivityForResult(intent, 2004);
                            emojiStoreDetailUI.overridePendingTransition(R.anim.dd, R.anim.di);
                            AppMethodBeat.o(176196);
                        } catch (IOException e2) {
                            Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreDetailUI", e2, "EmojiInfo error", new Object[0]);
                            AppMethodBeat.o(176196);
                        }
                    }

                    static /* synthetic */ void r(EmojiStoreDetailUI emojiStoreDetailUI) {
                        AppMethodBeat.i(176197);
                        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(emojiStoreDetailUI.mContext, 1, false);
                        eVar.HLX = new o.f() {
                            /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass11 */

                            @Override // com.tencent.mm.ui.base.o.f
                            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                                AppMethodBeat.i(176189);
                                mVar.b(1001, EmojiStoreDetailUI.this.getString(R.string.btp), R.raw.bottomsheet_icon_transmit);
                                mVar.b(1000, EmojiStoreDetailUI.this.getString(R.string.btq), R.raw.bottomsheet_icon_moment);
                                AppMethodBeat.o(176189);
                            }
                        };
                        eVar.HLY = new o.g() {
                            /* class com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.AnonymousClass13 */

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                AppMethodBeat.i(176190);
                                switch (menuItem.getItemId()) {
                                    case 1001:
                                        com.tencent.mm.plugin.emoji.e.j.eY(EmojiStoreDetailUI.this.getContext());
                                        EmojiStoreDetailUI.this.getContext().overridePendingTransition(R.anim.dq, R.anim.bs);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13224, 0, 2, EmojiStoreDetailUI.this.rcD, "");
                                        AppMethodBeat.o(176190);
                                        return;
                                    case 1000:
                                        com.tencent.mm.plugin.emoji.e.j.a(EmojiStoreDetailUI.this.getContext(), EmojiStoreDetailUI.this.reN.PackName + EmojiStoreDetailUI.this.getString(R.string.bvp), EmojiStoreDetailUI.this.reN.PackDesc, EmojiStoreDetailUI.this.reN.IconUrl, EmojiStoreDetailUI.this.reN.OldRedirectUrl, EmojiLogic.amG(EmojiStoreDetailUI.this.rcD), 4);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13224, 0, 1, EmojiStoreDetailUI.this.rcD, "");
                                        break;
                                }
                                AppMethodBeat.o(176190);
                            }
                        };
                        eVar.dGm();
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13224, 0, 0, "", "");
                        AppMethodBeat.o(176197);
                    }
                }
