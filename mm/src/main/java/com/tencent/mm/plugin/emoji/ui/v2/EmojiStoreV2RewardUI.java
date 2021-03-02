package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.p;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.GridInScrollView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.EmotionPrice;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;

public class EmojiStoreV2RewardUI extends MMActivity implements AdapterView.OnItemClickListener, i {
    private ProgressDialog jZH;
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(109270);
            switch (message.what) {
                case 1001:
                    String str = (String) message.obj;
                    if (Util.isNullOrNil(str) || !s.YS(str)) {
                        Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "path is null or file no exists");
                        AppMethodBeat.o(109270);
                        return;
                    }
                    EmojiStoreV2RewardUI.this.rlo.setImageFilePath(str);
                    EmojiStoreV2RewardUI.this.rlo.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (EmojiStoreV2RewardUI.this.rlk != null && EmojiStoreV2RewardUI.this.rlk.isRunning()) {
                        EmojiStoreV2RewardUI.this.rlk.stop();
                        AppMethodBeat.o(109270);
                        return;
                    }
                    break;
                case 1002:
                    EmojiStoreV2RewardUI.c(EmojiStoreV2RewardUI.this);
                    break;
            }
            AppMethodBeat.o(109270);
        }
    };
    public int rbG;
    private String rbM;
    public String rcq;
    private Button rhU;
    private GetEmotionRewardResponse rhu;
    public boolean rlA = false;
    private View.OnClickListener rlB = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(109271);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (EmojiStoreV2RewardUI.this.rlv != null) {
                EmotionPrice Gc = EmojiStoreV2RewardUI.this.rlv.Gc(0);
                if (EmojiStoreV2RewardUI.this.rls.getText() != null) {
                    Gc.Number = EmojiStoreV2RewardUI.this.rls.getText().toString();
                    EmojiStoreV2RewardUI.a(EmojiStoreV2RewardUI.this, EmojiStoreV2RewardUI.this.rcq, Gc);
                } else {
                    Log.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mRewardInputView is null");
                }
            } else {
                Log.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mAdapter is null.");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109271);
        }
    };
    private View.OnClickListener rlC = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(109272);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (EmojiStoreV2RewardUI.this.rlz == a.NORMAL) {
                EmojiStoreV2RewardUI.a(EmojiStoreV2RewardUI.this, a.CUSTOM);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109272);
        }
    };
    private TextWatcher rlD = new TextWatcher() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.AnonymousClass4 */

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(109273);
            if (EmojiStoreV2RewardUI.this.rhU != null) {
                if (editable != null && editable.length() > 0) {
                    String obj = editable.toString();
                    int indexOf = obj.indexOf(".");
                    if (indexOf > 0 && (obj.length() - indexOf) - 1 > 2) {
                        editable.delete(indexOf + 3, indexOf + 4);
                    }
                    float f2 = 0.0f;
                    try {
                        f2 = Float.valueOf(editable.toString()).floatValue();
                    } catch (NumberFormatException e2) {
                    }
                    if (f2 > 200.0f || f2 < 1.0f) {
                        EmojiStoreV2RewardUI.this.rls.getContentEditText().setTextColor(EmojiStoreV2RewardUI.this.getContext().getResources().getColor(R.color.a5c));
                    } else {
                        EmojiStoreV2RewardUI.this.rls.getContentEditText().setTextColor(EmojiStoreV2RewardUI.this.getContext().getResources().getColor(R.color.a2x));
                        EmojiStoreV2RewardUI.this.rhU.setEnabled(true);
                        AppMethodBeat.o(109273);
                        return;
                    }
                }
                EmojiStoreV2RewardUI.this.rhU.setEnabled(false);
            }
            AppMethodBeat.o(109273);
        }
    };
    private com.tencent.mm.plugin.emoji.model.i rlE = new com.tencent.mm.plugin.emoji.model.i(new k() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.AnonymousClass5 */

        @Override // com.tencent.mm.av.a.c.k
        public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.i(109274);
            if (!Util.isNullOrNil(str) && str.equalsIgnoreCase(EmojiStoreV2RewardUI.this.rlx)) {
                Message message = new Message();
                message.what = 1001;
                message.obj = EmojiStoreV2RewardUI.this.rly;
                EmojiStoreV2RewardUI.this.mHandler.sendMessage(message);
            }
            AppMethodBeat.o(109274);
        }
    });
    private AnimationDrawable rlk;
    public int rln;
    private EmojiStoreV2RewardBannerView rlo;
    private GridInScrollView rlp;
    private View rlq;
    private View rlr;
    private MMFormInputView rls;
    private TextView rlt;
    private TextView rlu;
    private b rlv;
    private com.tencent.mm.plugin.emoji.f.b rlw;
    private String rlx;
    private String rly;
    private a rlz = a.NORMAL;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreV2RewardUI() {
        AppMethodBeat.i(109287);
        AppMethodBeat.o(109287);
    }

    static /* synthetic */ void a(EmojiStoreV2RewardUI emojiStoreV2RewardUI, a aVar) {
        AppMethodBeat.i(109303);
        emojiStoreV2RewardUI.a(aVar);
        AppMethodBeat.o(109303);
    }

    static /* synthetic */ void a(EmojiStoreV2RewardUI emojiStoreV2RewardUI, String str, EmotionPrice emotionPrice) {
        AppMethodBeat.i(109302);
        emojiStoreV2RewardUI.a(str, emotionPrice);
        AppMethodBeat.o(109302);
    }

    static /* synthetic */ void c(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        AppMethodBeat.i(109301);
        emojiStoreV2RewardUI.updateView();
        AppMethodBeat.o(109301);
    }

    /* access modifiers changed from: package-private */
    public enum a {
        NORMAL,
        CUSTOM;

        public static a valueOf(String str) {
            AppMethodBeat.i(109279);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(109279);
            return aVar;
        }

        static {
            AppMethodBeat.i(109280);
            AppMethodBeat.o(109280);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a3c;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109288);
        super.onCreate(bundle);
        this.rcq = getIntent().getStringExtra("extra_id");
        this.rbM = getIntent().getStringExtra("name");
        this.rbG = getIntent().getIntExtra("scene", 0);
        this.rln = getIntent().getIntExtra("pageType", 0);
        initView();
        this.rhu = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpS.blu(this.rcq);
        if (this.rhu == null || this.rhu.Reward == null) {
            lB(false);
        } else {
            q.bcV().a(this.rhu.Reward.LsM, (ImageView) null, e.k(this.rcq, this.rhu.Reward.LsM, new Object[0]));
            q.bcV().a(this.rhu.Reward.LsN, (ImageView) null, e.k(this.rcq, this.rhu.Reward.LsN, new Object[0]));
        }
        updateView();
        g.aAg().hqi.a(830, this);
        g.aAg().hqi.a(822, this);
        h.INSTANCE.idkeyStat(408, 0, 1, false);
        AppMethodBeat.o(109288);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109289);
        g.aAg().hqi.b(830, this);
        g.aAg().hqi.b(822, this);
        if (this.rlk != null && this.rlk.isRunning()) {
            this.rlk.stop();
        }
        q.bcV().a((String) null, this.rlo);
        this.rlE.rbC = null;
        this.rlE = null;
        super.onDestroy();
        AppMethodBeat.o(109289);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(109290);
        Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", new StringBuilder().append(keyboardState()).toString());
        if (this.rlz == a.NORMAL) {
            if (this.rlA) {
                h.INSTANCE.idkeyStat(408, 2, 1, false);
            } else {
                h.INSTANCE.idkeyStat(408, 1, 1, false);
                h.INSTANCE.a(12738, this.rcq, Integer.valueOf(this.rln), Integer.valueOf(this.rbG), 4);
            }
            super.onBackPressed();
            AppMethodBeat.o(109290);
            return;
        }
        a(a.NORMAL);
        AppMethodBeat.o(109290);
    }

    private void a(a aVar) {
        AppMethodBeat.i(109291);
        if (aVar == a.CUSTOM) {
            this.rlz = a.CUSTOM;
            if (this.rlr != null) {
                this.rlr.setVisibility(0);
                this.rlr.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd));
                this.rls.getContentEditText().requestFocus();
                showVKB();
                this.rlq.setVisibility(8);
                AppMethodBeat.o(109291);
                return;
            }
        } else {
            hideVKB();
            this.mHandler.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(109275);
                    EmojiStoreV2RewardUI.l(EmojiStoreV2RewardUI.this);
                    AppMethodBeat.o(109275);
                }
            }, 300);
        }
        AppMethodBeat.o(109291);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109292);
        if (Util.isNullOrNil(this.rbM)) {
            setMMTitle(R.string.bv3);
        } else {
            setMMTitle(getString(R.string.bvl, new Object[]{this.rbM}));
        }
        setMMSubTitle(R.string.j1m);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109276);
                EmojiStoreV2RewardUI.this.onBackPressed();
                AppMethodBeat.o(109276);
                return true;
            }
        });
        this.rlq = findViewById(R.id.h68);
        this.rlr = findViewById(R.id.h69);
        this.rls = (MMFormInputView) findViewById(R.id.h6_);
        this.rhU = (Button) findViewById(R.id.h6a);
        this.rhU.setOnClickListener(this.rlB);
        this.rhU.setEnabled(false);
        this.rls.setInputType(8194);
        this.rls.addTextChangedListener(this.rlD);
        this.rls.getContentEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
        this.rlt = (TextView) findViewById(R.id.h66);
        this.rlt.setOnClickListener(this.rlC);
        this.rlu = (TextView) findViewById(R.id.h64);
        this.rlo = (EmojiStoreV2RewardBannerView) findViewById(R.id.a2s);
        this.rlp = (GridInScrollView) findViewById(16908298);
        this.rlv = new b();
        this.rlp.setAdapter((ListAdapter) this.rlv);
        this.rlp.setOnItemClickListener(this);
        this.rlk = (AnimationDrawable) getResources().getDrawable(R.drawable.emoji_doge_loading);
        AppMethodBeat.o(109292);
    }

    private void updateView() {
        AppMethodBeat.i(109293);
        if (this.rhu != null) {
            this.rlt.setVisibility(0);
            this.rlu.setVisibility(0);
            if (this.rhu.Reward == null || Util.isNullOrNil(this.rhu.Reward.LsL)) {
                this.rlo.setBackgroundDrawable(getResources().getDrawable(R.drawable.t_));
                this.rlo.setImageDrawable(this.rlk);
                this.rlo.setScaleType(ImageView.ScaleType.CENTER);
                this.rlk.start();
            } else {
                this.rlx = this.rhu.Reward.LsL;
                com.tencent.mm.emoji.e.a aVar = com.tencent.mm.emoji.e.a.hdT;
                this.rly = EmojiLogic.j(com.tencent.mm.emoji.e.a.awt(), this.rcq, this.rlx);
                if (s.YS(this.rly)) {
                    this.rlo.setImageFilePath(this.rly);
                    this.rlo.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (this.rlk != null && this.rlk.isRunning()) {
                        this.rlk.stop();
                    }
                } else {
                    q.bcV().a(this.rlx, this.rlo, e.k(this.rcq, this.rlx, new Object[0]), this.rlE);
                    this.rlo.setBackgroundDrawable(getResources().getDrawable(R.drawable.t_));
                    this.rlo.setImageDrawable(this.rlk);
                    this.rlo.setScaleType(ImageView.ScaleType.CENTER);
                    this.rlk.start();
                }
            }
        } else {
            this.rlt.setVisibility(8);
            this.rlu.setVisibility(8);
        }
        if (this.rhu == null || this.rhu.Price == null) {
            this.rlp.setVisibility(8);
            AppMethodBeat.o(109293);
            return;
        }
        this.rlp.setVisibility(0);
        this.rlv.Z(this.rhu.Price);
        AppMethodBeat.o(109293);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        EmotionPrice Gc;
        AppMethodBeat.i(109294);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        if (!(this.rlv == null || (Gc = this.rlv.Gc(i2)) == null)) {
            Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "onItemClick position:%d", Integer.valueOf(i2));
            a(this.rcq, Gc);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(109294);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(109295);
        switch (i2) {
            case TXLiteAVCode.EVT_ROOM_REQUEST_IP_SUCC:
                if (i3 != -1) {
                    if (i3 != 0) {
                        if (!this.rlA) {
                            this.rlA = true;
                            h.INSTANCE.a(12738, this.rcq, Integer.valueOf(this.rln), Integer.valueOf(this.rbG), 2);
                        }
                        h.INSTANCE.idkeyStat(408, 4, 1, false);
                        break;
                    } else {
                        h.INSTANCE.a(12738, this.rcq, Integer.valueOf(this.rln), Integer.valueOf(this.rbG), 3);
                        h.INSTANCE.idkeyStat(408, 3, 1, false);
                        AppMethodBeat.o(109295);
                        return;
                    }
                } else {
                    cIf();
                    h.INSTANCE.a(12738, this.rcq, Integer.valueOf(this.rln), Integer.valueOf(this.rbG), 1);
                    h.INSTANCE.idkeyStat(408, 9, 1, false);
                    lB(true);
                    finish();
                    AppMethodBeat.o(109295);
                    return;
                }
        }
        AppMethodBeat.o(109295);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(109296);
        if (this.jZH != null && this.jZH.isShowing()) {
            this.jZH.dismiss();
        }
        int type = qVar.getType();
        switch (type) {
            case 822:
                if (qVar instanceof p) {
                    p pVar = (p) qVar;
                    if (i2 == 0 && i3 == 0) {
                        Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward success.");
                        this.rhu = pVar.cGz();
                        q.bcV().a(this.rhu.Reward.LsM, (ImageView) null, e.k(this.rcq, this.rhu.Reward.LsM, new Object[0]));
                        this.mHandler.sendEmptyMessage(1002);
                        AppMethodBeat.o(109296);
                        return;
                    }
                    Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward failed.");
                    AppMethodBeat.o(109296);
                    return;
                }
                break;
            case 830:
                com.tencent.mm.plugin.emoji.f.b bVar = (com.tencent.mm.plugin.emoji.f.b) qVar;
                if (i2 == 0 && i3 == 0) {
                    boolean isSwitch2InWxAppPay = ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).isSwitch2InWxAppPay(bVar.cGp().KKR);
                    Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doEmojiReward, isSwitch2InWxAppPay:%b", Boolean.valueOf(isSwitch2InWxAppPay));
                    if (isSwitch2InWxAppPay) {
                        ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startInWxAppPayUseCase(this, bVar.cGp().KKR, "", "", 5, 0);
                        AppMethodBeat.o(109296);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("extinfo_key_10", true);
                    AppCompatActivity context = getContext();
                    String str2 = bVar.cGp().KKR;
                    String str3 = bVar.cGp().hik;
                    if (!Util.isNullOrNil(str2)) {
                        PayInfo ap = f.ap(str2, str3, 5);
                        ap.iqp = bundle;
                        f.a(context, ap, TXLiteAVCode.EVT_ROOM_REQUEST_IP_SUCC);
                    }
                    AppMethodBeat.o(109296);
                    return;
                } else if (i2 == 4) {
                    if (!this.rlA) {
                        this.rlA = true;
                        h.INSTANCE.a(12738, this.rcq, Integer.valueOf(this.rln), Integer.valueOf(this.rbG), 2);
                    }
                    if (i3 == com.tencent.mm.plugin.emoji.f.b.rcn) {
                        h.INSTANCE.idkeyStat(408, 6, 1, false);
                        if (Util.isNullOrNil(str)) {
                            amW(getString(R.string.bv9));
                            AppMethodBeat.o(109296);
                            return;
                        }
                        amW(str);
                        AppMethodBeat.o(109296);
                        return;
                    } else if (i3 == com.tencent.mm.plugin.emoji.f.b.rco) {
                        h.INSTANCE.idkeyStat(408, 7, 1, false);
                        if (Util.isNullOrNil(str)) {
                            amW(getString(R.string.bva));
                            AppMethodBeat.o(109296);
                            return;
                        }
                        amW(str);
                        AppMethodBeat.o(109296);
                        return;
                    } else if (i3 == com.tencent.mm.plugin.emoji.f.b.rcp) {
                        h.INSTANCE.idkeyStat(408, 5, 1, false);
                        if (Util.isNullOrNil(str)) {
                            amW(getString(R.string.bv_));
                            AppMethodBeat.o(109296);
                            return;
                        }
                        amW(str);
                        AppMethodBeat.o(109296);
                        return;
                    } else {
                        h.INSTANCE.idkeyStat(408, 8, 1, false);
                        Toast.makeText(this, getString(R.string.bty), 0).show();
                        AppMethodBeat.o(109296);
                        return;
                    }
                } else {
                    if (!this.rlA) {
                        this.rlA = true;
                        h.INSTANCE.a(12738, this.rcq, Integer.valueOf(this.rln), Integer.valueOf(this.rbG), 2);
                    }
                    h.INSTANCE.idkeyStat(408, 8, 1, false);
                    Toast.makeText(this, getString(R.string.bty), 0).show();
                    AppMethodBeat.o(109296);
                    return;
                }
            default:
                Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "unknown scene. type:%d", Integer.valueOf(type));
                break;
        }
        AppMethodBeat.o(109296);
    }

    private void a(String str, EmotionPrice emotionPrice) {
        AppMethodBeat.i(109297);
        bnj();
        this.rlw = new com.tencent.mm.plugin.emoji.f.b(str, emotionPrice);
        g.aAg().hqi.a(this.rlw, 0);
        AppMethodBeat.o(109297);
    }

    private void bnj() {
        AppMethodBeat.i(109298);
        getString(R.string.zb);
        this.jZH = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.AnonymousClass8 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(109277);
                g.aAg().hqi.a(EmojiStoreV2RewardUI.this.rlw);
                AppMethodBeat.o(109277);
            }
        });
        AppMethodBeat.o(109298);
    }

    private void amW(String str) {
        AppMethodBeat.i(109299);
        com.tencent.mm.ui.base.h.a(getContext(), str, (String) null, getString(R.string.bts), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.AnonymousClass9 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(109299);
    }

    public final void cIf() {
        AppMethodBeat.i(240182);
        Intent intent = new Intent();
        intent.setClass(this, EmojiStoreV2RewardThanksUI.class);
        intent.putExtra("extra_id", this.rcq);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "startThanksUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI", "startThanksUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(240182);
    }

    public final void lB(boolean z) {
        AppMethodBeat.i(109300);
        Log.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doGetRewardScene");
        if (z) {
            g.aAg().hqi.a(new p(this.rcq, p.rde), 0);
            AppMethodBeat.o(109300);
            return;
        }
        g.aAg().hqi.a(new p(this.rcq, p.rdf), 0);
        bnj();
        AppMethodBeat.o(109300);
    }

    /* access modifiers changed from: package-private */
    public class b extends BaseAdapter {
        private LinkedList<EmotionPrice> rld;

        b() {
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(109285);
            EmotionPrice Gc = Gc(i2);
            AppMethodBeat.o(109285);
            return Gc;
        }

        public final void Z(LinkedList<EmotionPrice> linkedList) {
            AppMethodBeat.i(109281);
            if (this.rld == null) {
                this.rld = new LinkedList<>();
            }
            this.rld.clear();
            this.rld.addAll(linkedList);
            notifyDataSetChanged();
            AppMethodBeat.o(109281);
        }

        public final int getCount() {
            AppMethodBeat.i(109282);
            if (this.rld == null) {
                AppMethodBeat.o(109282);
                return 0;
            }
            int size = this.rld.size();
            AppMethodBeat.o(109282);
            return size;
        }

        public final EmotionPrice Gc(int i2) {
            AppMethodBeat.i(109283);
            if (i2 < 0 || i2 > getCount()) {
                AppMethodBeat.o(109283);
                return null;
            } else if (this.rld == null) {
                AppMethodBeat.o(109283);
                return null;
            } else {
                EmotionPrice emotionPrice = this.rld.get(i2);
                AppMethodBeat.o(109283);
                return emotionPrice;
            }
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(109284);
            if (view == null || view.getTag() == null) {
                view = aa.jQ(EmojiStoreV2RewardUI.this.getContext()).inflate(R.layout.a3a, (ViewGroup) null);
                cVar = new c(view);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            EmotionPrice Gc = Gc(i2);
            if (Gc != null) {
                cVar.rlJ.setVisibility(0);
                cVar.rlJ.setText(Gc.Number + Gc.Label);
            } else {
                cVar.rlJ.setVisibility(8);
            }
            AppMethodBeat.o(109284);
            return view;
        }
    }

    class c {
        TextView rlJ;

        public c(View view) {
            AppMethodBeat.i(109286);
            this.rlJ = (TextView) view.findViewById(R.id.ggz);
            AppMethodBeat.o(109286);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void l(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        AppMethodBeat.i(109304);
        emojiStoreV2RewardUI.rlz = a.NORMAL;
        if (emojiStoreV2RewardUI.rlr != null) {
            emojiStoreV2RewardUI.rlr.setVisibility(8);
            emojiStoreV2RewardUI.rlq.setVisibility(0);
            emojiStoreV2RewardUI.rlr.startAnimation(AnimationUtils.loadAnimation(emojiStoreV2RewardUI.getContext(), R.anim.di));
        }
        AppMethodBeat.o(109304);
    }
}
