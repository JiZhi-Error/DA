package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.q;
import com.tencent.mm.b.p;
import com.tencent.mm.emoji.e.c;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.f.m;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.e;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.IOException;
import java.util.ArrayList;

public class CustomSmileyPreviewUI extends MMActivity implements AdapterView.OnItemClickListener, i, j.a, j.b {
    private final String TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    private EmojiInfo gWm;
    private String gwx;
    private ListView mListView;
    private String productId;
    f reH;
    private View reI;
    private ImageView reJ;
    private TextView reK;
    private TextView reL;
    private bmi reM;
    private EmotionDetail reN = new EmotionDetail();
    private String reO;
    long reP;
    private ScaleRelativeLayout reQ;
    private TextView reR;
    private BaseEmojiView reS;
    private ViewGroup reT;
    private ImageView reU;
    private TextView reV;
    private TextView reW;
    private Button reX;
    private j reY;
    private bmq reZ;
    private IListener rey = new IListener<dp>() {
        /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass9 */

        {
            AppMethodBeat.i(161088);
            this.__eventId = dp.class.getName().hashCode();
            AppMethodBeat.o(161088);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dp dpVar) {
            c cVar;
            com.tencent.mm.plugin.emoji.a.a.f amb;
            AppMethodBeat.i(108799);
            dp dpVar2 = dpVar;
            if (dpVar2 != null && !Util.isNullOrNil(CustomSmileyPreviewUI.this.productId) && CustomSmileyPreviewUI.this.productId.equals(dpVar2.dGC.productId)) {
                CustomSmileyPreviewUI customSmileyPreviewUI = CustomSmileyPreviewUI.this;
                String str = dpVar2.dGC.productId;
                int i2 = dpVar2.dGC.status;
                int i3 = dpVar2.dGC.progress;
                String str2 = dpVar2.dGC.dGD;
                Log.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i2), Integer.valueOf(i3), str2);
                if (i2 == 6) {
                    MMHandlerThread.postToMainThread(new Runnable(str, i3) {
                        /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass6 */
                        final /* synthetic */ String raF;
                        final /* synthetic */ int val$progress;

                        {
                            this.raF = r2;
                            this.val$progress = r3;
                        }

                        public final void run() {
                            AppMethodBeat.i(108796);
                            if (Util.isNullOrNil(this.raF)) {
                                Log.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                                AppMethodBeat.o(108796);
                                return;
                            }
                            if (!(CustomSmileyPreviewUI.this.reH == null || CustomSmileyPreviewUI.this.reH.qXZ == null)) {
                                CustomSmileyPreviewUI.this.reH.dd(this.raF, this.val$progress);
                                CustomSmileyPreviewUI.this.reH.refreshView();
                            }
                            AppMethodBeat.o(108796);
                        }
                    });
                } else {
                    Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "product status:%d", Integer.valueOf(i2));
                    MMHandlerThread.postToMainThread(new Runnable(str, i2) {
                        /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass7 */
                        final /* synthetic */ int joN;
                        final /* synthetic */ String raF;

                        {
                            this.raF = r2;
                            this.joN = r3;
                        }

                        public final void run() {
                            AppMethodBeat.i(108797);
                            if (Util.isNullOrNil(this.raF)) {
                                Log.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                                AppMethodBeat.o(108797);
                                return;
                            }
                            if (!(CustomSmileyPreviewUI.this.reH == null || CustomSmileyPreviewUI.this.reH.qXZ == null)) {
                                CustomSmileyPreviewUI.this.reH.dc(this.raF, this.joN);
                            }
                            AppMethodBeat.o(108797);
                        }
                    });
                }
                if (!(customSmileyPreviewUI.reH == null || (cVar = customSmileyPreviewUI.reH.qXZ) == null || (amb = cVar.amb(str)) == null)) {
                    amb.qYo = str2;
                }
            }
            AppMethodBeat.o(108799);
            return false;
        }
    };
    private h rez;
    private long rfa;
    String rfb;
    private String rfc;
    private String rfd;
    private boolean rfe = false;
    private Runnable rff = new Runnable() {
        /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(108789);
            if (CustomSmileyPreviewUI.this.reR != null) {
                CustomSmileyPreviewUI.this.reR.setText(((d) g.ah(d.class)).getEmojiMgr().amp(CustomSmileyPreviewUI.this.gWm.getMd5()));
            }
            AppMethodBeat.o(108789);
        }
    };
    private Runnable rfg = new Runnable() {
        /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass8 */

        public final void run() {
            AppMethodBeat.i(108798);
            CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.this.productId, CustomSmileyPreviewUI.this.gWm);
            AppMethodBeat.o(108798);
        }
    };
    private IListener rfh = new IListener<sw>() {
        /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass10 */

        {
            AppMethodBeat.i(161089);
            this.__eventId = sw.class.getName().hashCode();
            AppMethodBeat.o(161089);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sw swVar) {
            AppMethodBeat.i(108801);
            sw swVar2 = swVar;
            if (CustomSmileyPreviewUI.this.rfa != 0 && swVar2.dZp.dZs == CustomSmileyPreviewUI.this.rfa) {
                Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "msg is revoked.");
                com.tencent.mm.ui.base.h.a((Context) CustomSmileyPreviewUI.this.getContext(), swVar2.dZp.dZq, "", CustomSmileyPreviewUI.this.getString(R.string.x_), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass10.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(108800);
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                        CustomSmileyPreviewUI.this.finish();
                        AppMethodBeat.o(108800);
                    }
                });
            }
            AppMethodBeat.o(108801);
            return false;
        }
    };
    private int scene;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CustomSmileyPreviewUI() {
        AppMethodBeat.i(108809);
        AppMethodBeat.o(108809);
    }

    static /* synthetic */ void a(CustomSmileyPreviewUI customSmileyPreviewUI, String str, EmojiInfo emojiInfo) {
        AppMethodBeat.i(108824);
        customSmileyPreviewUI.a(str, emojiInfo);
        AppMethodBeat.o(108824);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.yv;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(108810);
        super.onCreate(bundle);
        g.aAg().hqi.a(412, this);
        g.aAg().hqi.a(521, this);
        g.aAg().hqi.a(411, this);
        g.aAg().hqi.a(TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, this);
        g.aAg().hqi.a(368, this);
        EventCenter.instance.addListener(this.rey);
        EventCenter.instance.addListener(this.rfh);
        initView();
        String str = "";
        if (!(this.reM == null || this.reM.LVe == null)) {
            str = p.getString(this.reM.LVe.DesignerUin);
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12740, 4, str, this.gWm.field_groupId, "", Integer.valueOf(this.scene), 9, "", "", "", new StringBuilder().append(this.reP).toString());
        AppMethodBeat.o(108810);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(108811);
        super.onResume();
        AppMethodBeat.o(108811);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(108812);
        super.onStart();
        AppMethodBeat.o(108812);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(108813);
        super.onPause();
        AppMethodBeat.o(108813);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(108814);
        g.aAg().hqi.b(412, this);
        g.aAg().hqi.b(521, this);
        g.aAg().hqi.b(411, this);
        g.aAg().hqi.b(TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, this);
        g.aAg().hqi.b(368, this);
        EventCenter.instance.removeListener(this.rey);
        EventCenter.instance.removeListener(this.rfh);
        super.onDestroy();
        MMHandlerThread.removeRunnable(this.rff);
        MMHandlerThread.removeRunnable(this.rfg);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12789, 7, this.gWm.getMd5(), 1, this.gWm.field_designerID, this.gWm.field_groupId, this.rfb, "", "", "", this.gWm.field_activityid, Long.valueOf(this.reP));
        AppMethodBeat.o(108814);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        AppMethodBeat.i(108815);
        setMMTitle("");
        String stringExtra = getIntent().getStringExtra("custom_smiley_preview_md5");
        this.reP = cl.aWy();
        this.scene = getIntent().getIntExtra("scene", 9);
        this.rfa = getIntent().getLongExtra("msg_id", 0);
        this.rfb = getIntent().getStringExtra("msg_sender");
        this.rfc = getIntent().getStringExtra("msg_content");
        this.gwx = getIntent().getStringExtra("room_id");
        this.rfd = getIntent().getStringExtra("talker_username");
        Log.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", stringExtra);
        String nullAsNil = Util.nullAsNil(stringExtra);
        if (TextUtils.isEmpty(nullAsNil)) {
            Log.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
            finish();
        }
        this.reQ = (ScaleRelativeLayout) findViewById(R.id.c1g);
        this.reR = (TextView) findViewById(R.id.bjw);
        this.reS = (BaseEmojiView) findViewById(R.id.bjx);
        View findViewById = findViewById(R.id.c1b);
        ((ImageView) findViewById(R.id.c1c)).setImageDrawable(ar.m(this, R.raw.emoticonstore_capture_icon, -1));
        if (CrashReportFactory.hasDebuger() || BuildInfo.IS_FLAVOR_RED) {
            this.reS.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass11 */

                public final void onClick(View view) {
                    AppMethodBeat.i(108802);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "emoji is hevc %s", Boolean.valueOf(CustomSmileyPreviewUI.this.reS.isHevc));
                    a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(108802);
                }
            });
        }
        this.gWm = k.getEmojiStorageMgr().OpN.blk(nullAsNil);
        if (this.gWm == null) {
            finish();
            AppMethodBeat.o(108815);
            return;
        }
        e eVar = e.gVM;
        e.a(this.gWm, this.reS, (i.a) null);
        if (com.tencent.mm.plugin.emoji.h.b.z(this.gWm)) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        this.reQ.post(new Runnable() {
            /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(108803);
                ScaleRelativeLayout scaleRelativeLayout = CustomSmileyPreviewUI.this.reQ;
                scaleRelativeLayout.aXt = Math.min(Math.min(((float) scaleRelativeLayout.getMeasuredWidth()) / ((float) CustomSmileyPreviewUI.this.reS.getMeasuredWidth()), ((float) scaleRelativeLayout.getMeasuredHeight()) / ((float) CustomSmileyPreviewUI.this.reS.getMeasuredHeight())), 3.0f);
                scaleRelativeLayout.rnz = scaleRelativeLayout.aXt * 1.5f;
                AppMethodBeat.o(108803);
            }
        });
        String amp = ((d) g.ah(d.class)).getEmojiMgr().amp(this.gWm.getMd5());
        if (this.reR != null && !Util.isNullOrNil(amp)) {
            this.reR.setText(amp);
            this.reS.setContentDescription(amp);
        }
        this.reT = (ViewGroup) findViewById(R.id.c1e);
        this.reU = (ImageView) findViewById(R.id.c1d);
        this.reV = (TextView) findViewById(R.id.c1h);
        this.reW = (TextView) findViewById(R.id.c1f);
        this.reX = (Button) findViewById(R.id.c1a);
        Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "loadLensInfo: %s", this.gWm.field_lensId);
        this.reT.setVisibility(8);
        if (!Util.isNullOrNil(this.gWm.field_lensId)) {
            com.tencent.mm.sticker.c.d.a(this, this.gWm.field_lensId, new com.tencent.mm.sticker.c.c() {
                /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass15 */

                @Override // com.tencent.mm.sticker.c.c
                public final void a(int i2, final chz chz) {
                    AppMethodBeat.i(108808);
                    Object[] objArr = new Object[1];
                    objArr[0] = chz == null ? "" : chz.Lso;
                    Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "onResult: %s", objArr);
                    CustomSmileyPreviewUI.this.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass15.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(108807);
                            if (chz != null) {
                                CustomSmileyPreviewUI.this.reT.setVisibility(0);
                                com.tencent.mm.sticker.loader.h hVar = com.tencent.mm.sticker.loader.h.NNV;
                                com.tencent.mm.sticker.loader.h.getLoader().bQ(new com.tencent.mm.sticker.loader.a(chz)).c(CustomSmileyPreviewUI.this.reU);
                                CustomSmileyPreviewUI.this.reV.setText(chz.Name);
                                if (!Util.isNullOrNil(chz.LVe.Name)) {
                                    CustomSmileyPreviewUI.this.reW.setVisibility(0);
                                    CustomSmileyPreviewUI.this.reW.setText(chz.LVe.Name);
                                } else {
                                    CustomSmileyPreviewUI.this.reW.setVisibility(8);
                                }
                                CustomSmileyPreviewUI.this.reX.setOnClickListener(new View.OnClickListener() {
                                    /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass15.AnonymousClass1.AnonymousClass1 */

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(108806);
                                        b bVar = new b();
                                        bVar.bm(view);
                                        a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$9$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        com.tencent.mm.plugin.emojicapture.api.b.w(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.this.gWm.getMd5(), CustomSmileyPreviewUI.this.rfd);
                                        a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$9$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(108806);
                                    }
                                });
                            }
                            AppMethodBeat.o(108807);
                        }
                    });
                    AppMethodBeat.o(108808);
                }
            });
        }
        String stringExtra2 = getIntent().getStringExtra("custom_smiley_preview_appid");
        getIntent().getStringExtra("custom_smiley_preview_appname");
        TextView textView = (TextView) findViewById(R.id.uh);
        com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(stringExtra2, true, false);
        if (!(o == null || o.field_appName == null)) {
            o.field_appName.trim().length();
        }
        textView.setVisibility(8);
        this.productId = this.gWm.field_groupId;
        g.aAg().hqi.a(new l(this.productId), 0);
        this.mListView = (ListView) findViewById(16908298);
        this.reH = new f(getContext());
        this.reH.qYa = this;
        this.reH.qXt = true;
        this.reH.qXw = false;
        this.mListView.setOnItemClickListener(this);
        this.mListView.setAdapter((ListAdapter) this.reH);
        this.reH.qXY = this.mListView;
        if (!Util.isNullOrNil(this.productId)) {
            com.tencent.mm.storage.emotion.l blt = k.getEmojiStorageMgr().OpR.blt(this.productId);
            if (!(blt == null || blt.field_content == null)) {
                GetEmotionDetailResponse getEmotionDetailResponse = new GetEmotionDetailResponse();
                try {
                    getEmotionDetailResponse.parseFrom(blt.field_content);
                    this.reN = getEmotionDetailResponse.EmotionDetail;
                    this.reO = blt.field_lan;
                } catch (IOException e2) {
                    Log.e("MicroMsg.emoji.CustomSmileyPreviewUI", "exception:%s", Util.stackTraceToString(e2));
                }
            }
            if (this.reN == null || Util.isNullOrNil(this.reO) || !this.reO.equalsIgnoreCase(LocaleUtil.getCurrentLanguage(getContext()))) {
                g.aAg().hqi.a(new m(this.productId, 1), 0);
            } else {
                c cHc = cHc();
                if (this.reH != null) {
                    this.reH.a(cHc);
                }
                g.aAg().hqi.a(new m(this.productId, 1, this.reN.Version), 0);
            }
        }
        this.reY = new j();
        this.reY.owO = this;
        this.reY.rbD = this.reH;
        this.reY.rbG = 9;
        this.reY.rbJ = this;
        this.rfe = k.getEmojiStorageMgr().OpP.blg(this.productId);
        a(this.productId, this.gWm);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass13 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(108804);
                CustomSmileyPreviewUI.this.finish();
                AppMethodBeat.o(108804);
                return true;
            }
        });
        if (this.gWm.field_catalog == EmojiInfo.VkW || this.gWm.hYm()) {
            z = false;
        } else {
            z = true;
        }
        if (this.gWm.field_catalog == EmojiInfo.VkW || Util.isNullOrNil(this.gWm.field_groupId) || (!Util.isNullOrNil(this.gWm.field_groupId) && ((d) g.ah(d.class)).getEmojiMgr().amq(this.gWm.field_groupId))) {
            z = true;
        }
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass14 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(108805);
                CustomSmileyPreviewUI.g(CustomSmileyPreviewUI.this);
                AppMethodBeat.o(108805);
                return true;
            }
        });
        showOptionMenu(z);
        this.reI = findViewById(R.id.bne);
        this.reJ = (ImageView) this.reI.findViewById(R.id.bnk);
        this.reK = (TextView) this.reI.findViewById(R.id.bnu);
        this.reL = (TextView) this.reI.findViewById(R.id.bni);
        this.reI.setVisibility(8);
        if (this.gWm != null && !Util.isNullOrNil(this.gWm.field_designerID)) {
            this.reM = k.getEmojiStorageMgr().OpT.blr(this.gWm.field_designerID);
            g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.j(this.gWm.field_designerID), 0);
        }
        if (this.gWm != null && !Util.isNullOrNil(this.gWm.field_activityid)) {
            this.reZ = k.getEmojiStorageMgr().OpQ.blx(this.gWm.field_activityid);
            String str = this.gWm.field_activityid;
            String str2 = this.gWm.field_md5;
            if (this.reZ == null || !(this.reZ == null || this.reZ.LVr == null || ((long) this.reZ.LVr.LsJ) >= System.currentTimeMillis() / 1000)) {
                g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.k(str, str2), 0);
            } else {
                Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "no need to load emoji activity");
            }
        }
        cHb();
        this.reI.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(108790);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (CustomSmileyPreviewUI.this.reM == null || CustomSmileyPreviewUI.this.reM.LVe == null) {
                    Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
                } else {
                    Intent intent = new Intent();
                    intent.setClass(CustomSmileyPreviewUI.this.getContext(), EmojiStoreV2DesignerUI.class);
                    intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, CustomSmileyPreviewUI.this.reM.LVe.DesignerUin);
                    intent.putExtra("name", CustomSmileyPreviewUI.this.reM.LVe.Name);
                    intent.putExtra("headurl", CustomSmileyPreviewUI.this.reM.LVe.HeadUrl);
                    intent.putExtra("extra_scence", 9);
                    AppCompatActivity context = CustomSmileyPreviewUI.this.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    a.a(context, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    a.a(context, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(108790);
            }
        });
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr = new Object[5];
        objArr[0] = 2;
        objArr[1] = this.productId;
        objArr[2] = nullAsNil;
        objArr[3] = this.gWm == null ? "" : this.gWm.field_designerID;
        objArr[4] = this.gWm == null ? "" : this.gWm.field_activityid;
        hVar.a(12067, objArr);
        AppMethodBeat.o(108815);
    }

    private void cHb() {
        AppMethodBeat.i(108816);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(108792);
                if (CustomSmileyPreviewUI.this.reZ != null && CustomSmileyPreviewUI.this.reZ.LVr != null) {
                    CustomSmileyPreviewUI.this.reI.setVisibility(0);
                    CustomSmileyPreviewUI.this.reK.setText(CustomSmileyPreviewUI.this.reZ.LVr.Name);
                    if (Util.isNullOrNil(CustomSmileyPreviewUI.this.reZ.LVr.IconUrl)) {
                        CustomSmileyPreviewUI.this.reJ.setVisibility(8);
                    } else {
                        CustomSmileyPreviewUI.this.reJ.setVisibility(0);
                        q.bcV().a(CustomSmileyPreviewUI.this.reZ.LVr.IconUrl, CustomSmileyPreviewUI.this.reJ, com.tencent.mm.plugin.emoji.e.e.fS(CustomSmileyPreviewUI.this.gWm.field_groupId, CustomSmileyPreviewUI.this.reZ.LVr.IconUrl));
                    }
                    CustomSmileyPreviewUI.this.reL.setText(R.string.br0);
                    CustomSmileyPreviewUI.this.reI.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass3.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(108791);
                            b bVar = new b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.this.reZ.LVr.LsI);
                            a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(108791);
                        }
                    });
                    CustomSmileyPreviewUI.this.mListView.setVisibility(8);
                    AppMethodBeat.o(108792);
                } else if (CustomSmileyPreviewUI.this.reM == null || CustomSmileyPreviewUI.this.reM.LVe == null) {
                    CustomSmileyPreviewUI.this.reI.setVisibility(8);
                    AppMethodBeat.o(108792);
                } else {
                    CustomSmileyPreviewUI.this.reI.setVisibility(0);
                    CustomSmileyPreviewUI.this.reK.setText(CustomSmileyPreviewUI.this.reM.LVe.Name);
                    q.bcV().a(CustomSmileyPreviewUI.this.reM.LVe.HeadUrl, CustomSmileyPreviewUI.this.reJ, com.tencent.mm.plugin.emoji.e.e.fR(CustomSmileyPreviewUI.this.gWm.field_groupId, CustomSmileyPreviewUI.this.reM.LVe.HeadUrl));
                    CustomSmileyPreviewUI.this.mListView.setVisibility(8);
                    AppMethodBeat.o(108792);
                }
            }
        });
        AppMethodBeat.o(108816);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(108818);
        switch (qVar.getType()) {
            case TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL /*{ENCODED_INT: 239}*/:
                this.reM = ((com.tencent.mm.plugin.emoji.f.j) qVar).cGt();
                cHb();
                AppMethodBeat.o(108818);
                return;
            case 368:
                if (i3 != 0) {
                    Log.w("MicroMsg.emoji.CustomSmileyPreviewUI", "get activity failed.");
                    break;
                } else {
                    com.tencent.mm.plugin.emoji.f.k kVar = (com.tencent.mm.plugin.emoji.f.k) qVar;
                    bmq bmq = (bmq) kVar.rr.iLL.iLR;
                    if (!(bmq == null || bmq.LVr == null)) {
                        bmq.LVr.LsJ = ((int) (System.currentTimeMillis() / 1000)) + bmq.LVr.LsJ;
                        ((d) g.ah(d.class)).getEmojiStorageMgr().OpQ.a(kVar.rcT, bmq);
                    }
                    this.reZ = bmq;
                    cHb();
                    AppMethodBeat.o(108818);
                    return;
                }
            case 411:
                if (qVar instanceof o) {
                    k.getEmojiStorageMgr().OpQ.a(12, ((o) qVar).cGx());
                    AppMethodBeat.o(108818);
                    return;
                }
                break;
            case 412:
                if (qVar instanceof m) {
                    m mVar = (m) qVar;
                    if (i2 == 0) {
                        if (i3 == 0) {
                            this.reN = mVar.cGv();
                            if (this.reN == null || TextUtils.isEmpty(this.productId) || !this.productId.equals(this.reN.ProductID)) {
                                Object[] objArr = new Object[2];
                                objArr[0] = this.productId;
                                objArr[1] = this.reN == null ? "" : this.reN.ProductID;
                                Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id] cureent:%s,scene:%s", objArr);
                                AppMethodBeat.o(108818);
                                return;
                            }
                            c cHc = cHc();
                            if (this.reH != null) {
                                this.reH.a(cHc);
                            }
                            Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.reN.ProductID);
                            AppMethodBeat.o(108818);
                            return;
                        } else if (i3 == 1) {
                            AppMethodBeat.o(108818);
                            return;
                        }
                    } else if (i3 == 5) {
                        if (this.reN == null || mVar.cGv() == null || TextUtils.isEmpty(this.productId) || !this.productId.equals(this.reN.ProductID) || this.reN.PackFlag == mVar.cGv().PackFlag) {
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = this.productId;
                            objArr2[1] = this.reN == null ? "" : this.reN.ProductID;
                            Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s", objArr2);
                            AppMethodBeat.o(108818);
                            return;
                        }
                        this.reN.PackFlag = mVar.cGv().PackFlag;
                        c cHc2 = cHc();
                        if (this.reH != null) {
                            this.reH.a(cHc2);
                        }
                        Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.reN.ProductID);
                        AppMethodBeat.o(108818);
                        return;
                    }
                }
                break;
            case 521:
                if (i3 == 0) {
                    MMHandlerThread.postToMainThread(this.rfg);
                    MMHandlerThread.postToMainThreadDelayed(this.rff, 500);
                    AppMethodBeat.o(108818);
                    return;
                }
                break;
        }
        AppMethodBeat.o(108818);
    }

    private c cHc() {
        AppMethodBeat.i(108819);
        ArrayList arrayList = new ArrayList();
        EmotionSummary emotionSummary = new EmotionSummary();
        emotionSummary.CoverUrl = this.reN.CoverUrl;
        emotionSummary.IconUrl = this.reN.IconUrl;
        emotionSummary.PackName = this.reN.PackName;
        emotionSummary.PackFlag = this.reN.PackFlag;
        emotionSummary.PackDesc = this.reN.PackDesc;
        emotionSummary.PackExpire = this.reN.PackExpire;
        emotionSummary.PackType = this.reN.PackType;
        emotionSummary.PackPrice = this.reN.PackPrice;
        emotionSummary.PriceNum = this.reN.PriceNum;
        emotionSummary.PriceType = this.reN.PriceType;
        emotionSummary.ProductID = this.reN.ProductID;
        arrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(emotionSummary));
        c cVar = new c(arrayList);
        AppMethodBeat.o(108819);
        return cVar;
    }

    private void a(String str, EmojiInfo emojiInfo) {
        AppMethodBeat.i(108820);
        if (Util.isNullOrNil(str) || emojiInfo == null) {
            AppMethodBeat.o(108820);
            return;
        }
        if (!Util.isNullOrNil(str) && emojiInfo.field_catalog != EmojiGroupInfo.VkO && emojiInfo.field_catalog != EmojiGroupInfo.VkN && ((emojiInfo.field_type != EmojiInfo.Vla || emojiInfo.field_type != EmojiInfo.Vlb) && k.getEmojiStorageMgr().OpP.blf(str))) {
            if (this.mListView != null) {
                this.mListView.setVisibility(0);
            }
            if (this.reH != null) {
                this.reH.qXu = this.rfe;
                this.reH.notifyDataSetChanged();
                AppMethodBeat.o(108820);
                return;
            }
        } else if (this.mListView != null) {
            this.mListView.setVisibility(8);
        }
        AppMethodBeat.o(108820);
    }

    @Override // com.tencent.mm.plugin.emoji.model.j.a
    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        AppMethodBeat.i(108821);
        Object[] objArr = new Object[3];
        objArr[0] = aVar.getProductId();
        objArr[1] = TextUtils.isEmpty(aVar.cFd()) ? "" : aVar.cFd();
        objArr[2] = Integer.valueOf(aVar.cFc());
        Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", objArr);
        this.reY.a(aVar);
        AppMethodBeat.o(108821);
    }

    @Override // com.tencent.mm.plugin.emoji.model.j.b
    public final void cGa() {
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(108823);
        b bVar = new b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        if (this.reH == null || i2 < 0 || i2 >= this.reH.getCount()) {
            a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(108823);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12789, 4, this.gWm.getMd5(), 1, this.gWm.field_designerID, this.gWm.field_groupId, "", "", "", "", this.gWm.field_activityid, Long.valueOf(this.reP));
        com.tencent.mm.plugin.emoji.a.a.f FN = this.reH.getItem(i2);
        Intent intent = new Intent();
        intent.setClass(this, EmojiStoreDetailUI.class);
        EmotionSummary emotionSummary = FN.qYl;
        if (emotionSummary == null) {
            intent = null;
        } else {
            intent.putExtra("extra_id", emotionSummary.ProductID);
            intent.putExtra("extra_name", emotionSummary.PackName);
            intent.putExtra("extra_copyright", emotionSummary.PackCopyright);
            intent.putExtra("extra_coverurl", emotionSummary.CoverUrl);
            intent.putExtra("extra_description", emotionSummary.PackDesc);
            intent.putExtra("extra_price", emotionSummary.PackPrice);
            intent.putExtra("extra_type", emotionSummary.PackType);
            intent.putExtra("extra_flag", emotionSummary.PackFlag);
            intent.putExtra("preceding_scence", 4);
            intent.putExtra("call_by", 1);
            intent.putExtra("download_entrance_scene", 9);
            intent.putExtra("check_clickflag", true);
            intent.putExtra("extra_status", FN.mStatus);
            intent.putExtra("extra_progress", FN.HH);
            String stringExtra = getIntent().getStringExtra("to_talker_name");
            if (!Util.isNullOrNil(stringExtra)) {
                intent.putExtra("to_talker_name", stringExtra);
            }
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        a.a(this, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(108823);
    }

    @Override // com.tencent.mm.plugin.emoji.model.j.b
    public final void d(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(240157);
        this.rez = new h(str, str2, str3, null, str5);
        g.aAg().hqi.a(this.rez, 0);
        AppMethodBeat.o(240157);
    }

    static /* synthetic */ void g(CustomSmileyPreviewUI customSmileyPreviewUI) {
        AppMethodBeat.i(108825);
        EmojiInfo blk = k.getEmojiStorageMgr().OpN.blk(customSmileyPreviewUI.gWm.getMd5());
        if (blk != null) {
            customSmileyPreviewUI.gWm = blk;
        }
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) customSmileyPreviewUI, 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(108793);
                if (CustomSmileyPreviewUI.this.gWm.field_catalog != EmojiInfo.VkW && !CustomSmileyPreviewUI.this.gWm.hYm()) {
                    mVar.kV(0, R.string.dn);
                }
                mVar.kV(1, R.string.g5j);
                com.tencent.mm.pluginsdk.a.d emojiMgr = ((d) g.ah(d.class)).getEmojiMgr();
                EmojiInfo unused = CustomSmileyPreviewUI.this.gWm;
                if (emojiMgr.cFM() && (Util.isNullOrNil(CustomSmileyPreviewUI.this.rfd) || !as.bjw(CustomSmileyPreviewUI.this.rfd))) {
                    mVar.kV(2, R.string.bt8);
                }
                mVar.kV(3, R.string.bsb);
                AppMethodBeat.o(108793);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass5 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(108794);
                switch (menuItem.getItemId()) {
                    case 0:
                        CustomSmileyPreviewUI customSmileyPreviewUI = CustomSmileyPreviewUI.this;
                        EmojiInfo blk = k.getEmojiStorageMgr().OpN.blk(customSmileyPreviewUI.getIntent().getStringExtra("custom_smiley_preview_md5"));
                        if (blk == null) {
                            Log.w("MicroMsg.emoji.CustomSmileyPreviewUI", "[cpan] save custom emoji failed. emoji is null.");
                            AppMethodBeat.o(108794);
                            return;
                        }
                        if (blk.field_catalog != EmojiInfo.VkS) {
                            if (blk.field_catalog == EmojiInfo.VkW) {
                                com.tencent.mm.ui.base.h.cD(customSmileyPreviewUI, customSmileyPreviewUI.getString(R.string.h9));
                                AppMethodBeat.o(108794);
                                return;
                            }
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12789, 3, blk.getMd5(), 1, blk.field_designerID, blk.field_groupId, "", "", "", "", "", blk.field_activityid, Long.valueOf(customSmileyPreviewUI.reP));
                            k.cGf().a(customSmileyPreviewUI.getContext(), blk, 4, customSmileyPreviewUI.rfb);
                        }
                        AppMethodBeat.o(108794);
                        return;
                    case 1:
                        new com.tencent.mm.emoji.e.c(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.this.gWm, false, new c.a() {
                            /* class com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.AnonymousClass5.AnonymousClass1 */

                            @Override // com.tencent.mm.emoji.e.c.a
                            public final void dQ(boolean z) {
                                AppMethodBeat.i(240156);
                                if (z) {
                                    CustomSmileyPreviewUI.u(CustomSmileyPreviewUI.this);
                                }
                                AppMethodBeat.o(240156);
                            }
                        });
                        AppMethodBeat.o(108794);
                        return;
                    case 2:
                        CustomSmileyPreviewUI.this.setResult(-1);
                        com.tencent.mm.plugin.emojicapture.api.b.w(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.this.gWm.getMd5(), CustomSmileyPreviewUI.this.rfd);
                        break;
                    case 3:
                        CustomSmileyPreviewUI.v(CustomSmileyPreviewUI.this);
                        AppMethodBeat.o(108794);
                        return;
                }
                AppMethodBeat.o(108794);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(108825);
    }

    static /* synthetic */ void a(CustomSmileyPreviewUI customSmileyPreviewUI, String str) {
        AppMethodBeat.i(161090);
        Intent intent = new Intent();
        intent.putExtra("showShare", true);
        intent.putExtra("rawUrl", str);
        com.tencent.mm.br.c.b(customSmileyPreviewUI, "webview", ".ui.tools.WebViewUI", intent);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12789, 4, customSmileyPreviewUI.gWm.getMd5(), 1, customSmileyPreviewUI.gWm.field_designerID, customSmileyPreviewUI.gWm.field_groupId, "", "", "", "", customSmileyPreviewUI.gWm.field_activityid);
        AppMethodBeat.o(161090);
    }

    static /* synthetic */ void u(CustomSmileyPreviewUI customSmileyPreviewUI) {
        AppMethodBeat.i(108828);
        String stringExtra = customSmileyPreviewUI.getIntent().getStringExtra("custom_smiley_preview_md5");
        int intExtra = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Compress_Type", intExtra);
        com.tencent.mm.plugin.emoji.c.jRt.k(intent, customSmileyPreviewUI);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12789, 1, customSmileyPreviewUI.gWm.getMd5(), 1, customSmileyPreviewUI.gWm.field_designerID, customSmileyPreviewUI.gWm.field_groupId, customSmileyPreviewUI.rfb, "", "", "", customSmileyPreviewUI.gWm.field_activityid, Long.valueOf(customSmileyPreviewUI.reP));
        AppMethodBeat.o(108828);
    }

    static /* synthetic */ void v(CustomSmileyPreviewUI customSmileyPreviewUI) {
        AppMethodBeat.i(161091);
        Intent intent = new Intent();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(customSmileyPreviewUI.rfc);
        intent.putStringArrayListExtra("k_outside_expose_proof_item_list", arrayList);
        if (Util.isNullOrNil(customSmileyPreviewUI.gwx)) {
            intent.putExtra("k_username", customSmileyPreviewUI.rfb);
        } else {
            intent.putExtra("k_username", customSmileyPreviewUI.gwx);
        }
        intent.putExtra("k_expose_msg_id", customSmileyPreviewUI.rfa);
        intent.putExtra("k_expose_msg_type", 47);
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format(e.C2115e.OyU, 51));
        com.tencent.mm.br.c.b(customSmileyPreviewUI, "webview", ".ui.tools.WebViewUI", intent);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12789, 6, customSmileyPreviewUI.gWm.getMd5(), 1, customSmileyPreviewUI.gWm.field_designerID, customSmileyPreviewUI.gWm.field_groupId, customSmileyPreviewUI.rfb, "", "", "", customSmileyPreviewUI.gWm.field_activityid, Long.valueOf(customSmileyPreviewUI.reP));
        AppMethodBeat.o(161091);
    }
}
