package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.aa;

public class EmojiStoreV2SingleRecommendView extends ChatFooterPanel.RecommendView implements View.OnClickListener, j.b {
    private MMHandler czp = new MMHandler() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(109357);
            switch (message.what) {
                case 131074:
                    AppMethodBeat.o(109357);
                    return;
                case 131075:
                    int i2 = message.getData().getInt("progress");
                    if (Util.isNullOrNil(message.getData().getString("product_id"))) {
                        Log.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                        AppMethodBeat.o(109357);
                        return;
                    }
                    if (EmojiStoreV2SingleRecommendView.this.rmC != null) {
                        EmojiStoreV2SingleRecommendView.this.rmC.setVisibility(8);
                    }
                    if (EmojiStoreV2SingleRecommendView.this.rmD != null) {
                        EmojiStoreV2SingleRecommendView.this.rmD.setVisibility(0);
                        EmojiStoreV2SingleRecommendView.this.rmD.setProgress(i2);
                        AppMethodBeat.o(109357);
                        return;
                    }
                    break;
                case 131076:
                    message.getData().getInt("status");
                    if (!Util.isNullOrNil(message.getData().getString("product_id"))) {
                        if (EmojiStoreV2SingleRecommendView.this.rmC != null) {
                            EmojiStoreV2SingleRecommendView.this.rmC.setVisibility(0);
                            EmojiStoreV2SingleRecommendView.cIl();
                        }
                        if (EmojiStoreV2SingleRecommendView.this.rmD != null) {
                            EmojiStoreV2SingleRecommendView.this.rmD.setVisibility(8);
                            EmojiStoreV2SingleRecommendView.this.rmD.setProgress(0);
                            break;
                        }
                    } else {
                        Log.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                        AppMethodBeat.o(109357);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(109357);
        }
    };
    private ViewGroup nmW;
    private String rcq;
    private h rdV;
    protected final int rel = 131074;
    private final int rem = 131075;
    private final int ren = 131076;
    private final String reo = "product_id";
    private final String rep = "progress";
    private final String rer = "status";
    private ImageView rhG;
    private String ria;
    private TextView rmA;
    private TextView rmB;
    private Button rmC;
    private ProgressBar rmD;
    private EmojiGroupInfo rmE;
    private boolean rmF = true;
    private IListener rmG = new IListener<dp>() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView.AnonymousClass2 */

        {
            AppMethodBeat.i(161097);
            this.__eventId = dp.class.getName().hashCode();
            AppMethodBeat.o(161097);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dp dpVar) {
            AppMethodBeat.i(109358);
            dp dpVar2 = dpVar;
            if (dpVar2 instanceof dp) {
                EmojiStoreV2SingleRecommendView.this.ria = dpVar2.dGC.dGD;
                if (!Util.isNullOrNil(dpVar2.dGC.productId) && dpVar2.dGC.productId.equalsIgnoreCase(EmojiStoreV2SingleRecommendView.this.rcq)) {
                    EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView = EmojiStoreV2SingleRecommendView.this;
                    String str = dpVar2.dGC.productId;
                    int i2 = dpVar2.dGC.status;
                    int i3 = dpVar2.dGC.progress;
                    Log.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i2), Integer.valueOf(i3), dpVar2.dGC.dGD);
                    if (i2 == 6) {
                        Message obtain = Message.obtain();
                        obtain.getData().putString("product_id", str);
                        obtain.getData().putInt("progress", i3);
                        obtain.what = 131075;
                        emojiStoreV2SingleRecommendView.l(obtain);
                    } else {
                        Log.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product status:%d", Integer.valueOf(i2));
                        Message obtain2 = Message.obtain();
                        obtain2.getData().putString("product_id", str);
                        obtain2.getData().putInt("status", i2);
                        obtain2.what = 131076;
                        emojiStoreV2SingleRecommendView.l(obtain2);
                    }
                }
            }
            AppMethodBeat.o(109358);
            return false;
        }
    };
    private ImageView rmz;

    static /* synthetic */ void cIl() {
    }

    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(109360);
        init();
        AppMethodBeat.o(109360);
    }

    @TargetApi(11)
    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(109361);
        init();
        AppMethodBeat.o(109361);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(109362);
        super.onAttachedToWindow();
        Log.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
        EventCenter.instance.addListener(this.rmG);
        AppMethodBeat.o(109362);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(109363);
        super.onDetachedFromWindow();
        Log.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onDetachedFromWindow");
        EventCenter.instance.removeListener(this.rmG);
        AppMethodBeat.o(109363);
    }

    private void init() {
        AppMethodBeat.i(109364);
        if (this.rmF) {
            this.nmW = (ViewGroup) aa.jQ(getContext()).inflate(R.layout.a3h, this);
        } else {
            this.nmW = (ViewGroup) aa.jQ(getContext()).inflate(R.layout.a3i, this);
        }
        this.rhG = (ImageView) this.nmW.findViewById(R.id.bzo);
        this.rmz = (ImageView) this.nmW.findViewById(R.id.c05);
        this.rmA = (TextView) this.nmW.findViewById(R.id.c27);
        this.rmB = (TextView) this.nmW.findViewById(R.id.c2_);
        this.rmC = (Button) this.nmW.findViewById(R.id.bzv);
        this.rmD = (ProgressBar) this.nmW.findViewById(R.id.bzx);
        AppMethodBeat.o(109364);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView
    public void setProductID(String str) {
        AppMethodBeat.i(109365);
        this.rcq = str;
        if (Util.isNullOrNil(this.rcq)) {
            this.nmW.setVisibility(8);
            AppMethodBeat.o(109365);
            return;
        }
        this.rmE = k.getEmojiStorageMgr().OpO.di(this.rcq, false);
        this.rhG.setOnClickListener(this);
        this.rmC.setOnClickListener(this);
        this.nmW.setOnClickListener(this);
        setTitleName(this.rmE);
        this.rmD.setVisibility(8);
        q.bcV().a(this.rmE.field_BigIconUrl, this.rmz, e.j(this.rcq, this.rmE.field_BigIconUrl, new Object[0]));
        AppMethodBeat.o(109365);
    }

    private void setTitleName(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.i(109366);
        if (this.rmC != null) {
            switch (emojiGroupInfo.field_buttonType) {
                case 1:
                    this.rmC.setVisibility(0);
                    this.rmC.setText(R.string.bu7);
                    break;
                case 2:
                    this.rmC.setVisibility(0);
                    this.rmC.setText(R.string.f0a);
                    break;
                default:
                    this.rmC.setVisibility(8);
                    break;
            }
        }
        if (!Util.isNullOrNil(emojiGroupInfo.field_packName)) {
            this.rmA.setText(emojiGroupInfo.field_packName);
        }
        if (this.rmB != null) {
            if (!Util.isNullOrNil(emojiGroupInfo.field_recommandWord)) {
                this.rmB.setVisibility(0);
                this.rmB.setText(emojiGroupInfo.field_recommandWord);
                AppMethodBeat.o(109366);
                return;
            }
            this.rmB.setVisibility(8);
        }
        AppMethodBeat.o(109366);
    }

    @Override // com.tencent.mm.plugin.emoji.model.j.b
    public final void d(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(240183);
        g.aAg().hqi.a(new h(str, str2, str3, null, str5), 0);
        AppMethodBeat.o(240183);
    }

    @Override // com.tencent.mm.plugin.emoji.model.j.b
    public final void cGa() {
    }

    public final void l(Message message) {
        AppMethodBeat.i(109368);
        if (this.czp != null) {
            this.czp.sendMessage(message);
        }
        AppMethodBeat.o(109368);
    }

    private void f(EmotionSummary emotionSummary) {
        AppMethodBeat.i(109369);
        Intent intent = new Intent();
        intent.setClass(getContext(), EmojiStoreDetailUI.class);
        intent.putExtra("extra_id", emotionSummary.ProductID);
        intent.putExtra("extra_name", emotionSummary.PackName);
        intent.putExtra("extra_copyright", emotionSummary.PackCopyright);
        intent.putExtra("extra_coverurl", emotionSummary.CoverUrl);
        intent.putExtra("extra_description", emotionSummary.PackDesc);
        intent.putExtra("extra_price", emotionSummary.PackPrice);
        intent.putExtra("extra_type", emotionSummary.PackType);
        intent.putExtra("extra_flag", emotionSummary.PackFlag);
        intent.putExtra("extra_price_num", emotionSummary.PriceNum);
        intent.putExtra("extra_price_type", emotionSummary.PriceType);
        intent.putExtra("preceding_scence", 108);
        intent.putExtra("call_by", 1);
        intent.putExtra("download_entrance_scene", 8);
        intent.putExtra("check_clickflag", false);
        Context context = getContext();
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(109369);
    }

    public void onClick(View view) {
        AppMethodBeat.i(109370);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view == this.rhG) {
            k.getEmojiStorageMgr().OpO.blc(this.rcq);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12068, 2, this.rcq, Integer.valueOf(this.rmE.field_recommandType));
        } else if (view == this.nmW) {
            f(this.rmE.hYh());
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12068, 4, this.rcq, Integer.valueOf(this.rmE.field_recommandType));
        } else if (view != this.rmC) {
            Log.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "do nothing");
        } else if (this.rmE.field_buttonType == 1) {
            this.rdV = new h(this.rcq);
            g.aAg().hqi.a(this.rdV, 0);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12068, 3, this.rcq, Integer.valueOf(this.rmE.field_recommandType));
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12066, 0, 8, "", this.rcq);
        } else if (this.rmE.field_buttonType == 2) {
            f(this.rmE.hYh());
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12068, 4, this.rcq, Integer.valueOf(this.rmE.field_recommandType));
        } else {
            Log.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "unknown buttonType do nothing.");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109370);
    }
}
