package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.b.a.hf;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.luckymoney.a.c;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.ay;
import com.tencent.mm.plugin.luckymoney.model.az;
import com.tencent.mm.plugin.luckymoney.model.bd;
import com.tencent.mm.plugin.luckymoney.model.be;
import com.tencent.mm.plugin.luckymoney.model.bi;
import com.tencent.mm.plugin.luckymoney.ui.l;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.utils.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bwe;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.ui.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@i
@a(7)
public class LuckyMoneyNotHookReceiveUI extends LuckyMoneyBaseUI {
    private static HashMap<String, bwe> zgd = new HashMap<>();
    private String UXO;
    private String UXP;
    private int UXQ;
    private Set<String> UXS = new HashSet();
    private WeImageView UYq;
    private ResultReceiver UYr;
    private long gof;
    private int gwE;
    private String mRa;
    private int maxSize = 0;
    private TextView nAB;
    private ViewGroup nmW;
    private int qBv;
    private d.a rbg = new d.a() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.emoji.model.d.a
        public final void a(final boolean z, final EmojiInfo emojiInfo) {
            AppMethodBeat.i(65732);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(65731);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(65730);
                            if (!(emojiInfo == null || LuckyMoneyNotHookReceiveUI.this.rfq == null || !LuckyMoneyNotHookReceiveUI.this.rfq.getMd5().equals(emojiInfo.getMd5()))) {
                                if (z) {
                                    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings success.");
                                    LuckyMoneyNotHookReceiveUI.this.rfq = k.getEmojiStorageMgr().OpN.blk(LuckyMoneyNotHookReceiveUI.this.rfq.getMd5());
                                    LuckyMoneyNotHookReceiveUI.this.yUo.setVisibility(8);
                                    LuckyMoneyNotHookReceiveUI.this.yUm.setVisibility(0);
                                    LuckyMoneyNotHookReceiveUI.egu();
                                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this, LuckyMoneyNotHookReceiveUI.this.rfq);
                                    AppMethodBeat.o(65730);
                                    return;
                                }
                                Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings error.");
                                LuckyMoneyNotHookReceiveUI.this.yUo.setVisibility(8);
                                LuckyMoneyNotHookReceiveUI.this.yUn.setVisibility(0);
                                LuckyMoneyNotHookReceiveUI.egu();
                            }
                            AppMethodBeat.o(65730);
                        }
                    });
                    AppMethodBeat.o(65731);
                }
            });
            AppMethodBeat.o(65732);
        }
    };
    private String rcU;
    private EmojiInfo rfq;
    private long startTime;
    private int textSize = 0;
    private q tipDialog = null;
    private String xGm;
    private ImageView yQt;
    private TextView yRk;
    private Button yRl;
    private View yRm;
    private ImageView yRn;
    private TextView yRo;
    private String yUc;
    private LinearLayout yUh;
    private TextView yUi;
    private View yUj;
    private ImageView yUk;
    private RelativeLayout yUl;
    private BaseEmojiView yUm;
    private TextView yUn;
    private LinearLayout yUo;
    private ProgressBar yUp;
    private String yUq;
    private ae yUs = null;
    public int yUt = 0;
    private bd yXY;
    private TextView yln;
    private int zbZ;
    private long zdW = 0;
    private int zdY = 3;
    private com.tencent.mm.ak.i zdZ = new com.tencent.mm.ak.i() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass13 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            kb cGq;
            AppMethodBeat.i(258699);
            if (Util.isEqual(qVar.getType(), 697) && (qVar instanceof e)) {
                e eVar = (e) qVar;
                if (i2 == 0 && i3 == 0 && (cGq = eVar.cGq()) != null && cGq.KOp != null && cGq.KOp.size() > 0 && Util.isEqual(cGq.KOp.get(0).Md5, LuckyMoneyNotHookReceiveUI.this.rfq.getMd5())) {
                    LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, false);
                }
            }
            AppMethodBeat.o(258699);
        }
    };
    private int zdu;
    private hf zdz;
    private int zeb = 0;
    private String zge;
    private boolean zgf = false;

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyNotHookReceiveUI() {
        AppMethodBeat.i(65742);
        AppMethodBeat.o(65742);
    }

    static /* synthetic */ void a(LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI, Intent intent) {
        AppMethodBeat.i(258709);
        luckyMoneyNotHookReceiveUI.aH(intent);
        AppMethodBeat.o(258709);
    }

    static /* synthetic */ void a(LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI, ay ayVar) {
        AppMethodBeat.i(258710);
        luckyMoneyNotHookReceiveUI.a(ayVar);
        AppMethodBeat.o(258710);
    }

    static /* synthetic */ void a(LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI, bwe bwe) {
        AppMethodBeat.i(258711);
        luckyMoneyNotHookReceiveUI.a(bwe);
        AppMethodBeat.o(258711);
    }

    static /* synthetic */ void a(LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI, boolean z) {
        AppMethodBeat.i(258705);
        luckyMoneyNotHookReceiveUI.qM(z);
        AppMethodBeat.o(258705);
    }

    static /* synthetic */ int awY(int i2) {
        AppMethodBeat.i(258707);
        int PY = PY(i2);
        AppMethodBeat.o(258707);
        return PY;
    }

    static /* synthetic */ void b(LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI, EmojiInfo emojiInfo) {
        AppMethodBeat.i(65757);
        luckyMoneyNotHookReceiveUI.A(emojiInfo);
        AppMethodBeat.o(65757);
    }

    static /* synthetic */ void egu() {
    }

    static /* synthetic */ View h(LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI) {
        AppMethodBeat.i(213423);
        View contentView = luckyMoneyNotHookReceiveUI.getContentView();
        AppMethodBeat.o(213423);
        return contentView;
    }

    static /* synthetic */ View i(LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI) {
        AppMethodBeat.i(258706);
        View contentView = luckyMoneyNotHookReceiveUI.getContentView();
        AppMethodBeat.o(258706);
        return contentView;
    }

    static /* synthetic */ int m(LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI) {
        AppMethodBeat.i(258708);
        int egt = luckyMoneyNotHookReceiveUI.egt();
        AppMethodBeat.o(258708);
        return egt;
    }

    static {
        AppMethodBeat.i(213427);
        AppMethodBeat.o(213427);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        ah bdVar;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(65743);
        fixStatusbar(true);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.ac_));
        }
        this.startTime = Util.currentTicks();
        this.yUq = getIntent().getStringExtra("key_native_url");
        this.zge = getIntent().getStringExtra("key_cropname");
        this.gof = getIntent().getLongExtra("key_msgid", 0);
        this.qBv = getIntent().getIntExtra("key_material_flag", 0);
        this.zbZ = getIntent().getIntExtra("scene_id", 1002);
        this.mRa = getIntent().getStringExtra("key_username");
        this.gwE = getIntent().getIntExtra("key_from", 0);
        this.UXO = getIntent().getStringExtra("key_live_id");
        this.UXP = getIntent().getStringExtra("key_live_attach");
        this.UYr = (ResultReceiver) getIntent().getParcelableExtra("key_open_result_receiver");
        this.UXQ = getIntent().getIntExtra("key_live_anchor_type", 0);
        Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "nativeUrl= " + Util.nullAsNil(this.yUq));
        initView();
        Uri parse = Uri.parse(Util.nullAsNil(this.yUq));
        try {
            this.yUc = parse.getQueryParameter("sendid");
        } catch (Exception e2) {
        }
        this.yUs = t.fQE().aVA(this.yUq);
        if (this.yUs == null || this.yUs.field_receiveAmount <= 0 || Util.milliSecondsToNow(this.yUs.field_receiveTime) >= Util.MILLSECONDS_OF_DAY) {
            if (!Util.isNullOrNil(this.yUc)) {
                int i2 = Util.getInt(parse.getQueryParameter("channelid"), 1);
                this.xGm = parse.getQueryParameter("sendusername");
                String stringExtra = getIntent().getStringExtra("key_username");
                if (af.rQ(this.zbZ)) {
                    bdVar = new be(i2, this.yUc, this.yUq, getIntent().getIntExtra("key_way", 0), "v1.0");
                } else if (this.gwE == 3) {
                    bdVar = new com.tencent.mm.plugin.luckymoney.model.a.e(i2, this.yUc, this.yUq, getIntent().getIntExtra("key_way", 0), "v1.0", stringExtra, getIntent().getStringExtra("key_live_id"), getIntent().getStringExtra("key_live_attach"), this.UXQ);
                } else {
                    bdVar = new bd(i2, this.yUc, this.yUq, getIntent().getIntExtra("key_way", 0), "v1.0", stringExtra);
                }
                m mVar = m.vli;
                s.bh bhVar = s.bh.EXPOSE_RED_PACKET_UI;
                s.bg bgVar = s.bg.UNKNOWN;
                if (this.gwE == 3) {
                    z = true;
                } else {
                    z = false;
                }
                mVar.a(bhVar, bgVar, z);
                if (ab.IN(stringExtra)) {
                    String stringExtra2 = getIntent().getStringExtra("key_emoji_md5");
                    if (Util.isNullOrNil(stringExtra2)) {
                        z2 = false;
                    }
                    bdVar.yWK = 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0247: IPUT  
                          (wrap: com.tencent.mm.plugin.luckymoney.model.s$6 : 0x0244: CONSTRUCTOR  (r2v14 com.tencent.mm.plugin.luckymoney.model.s$6) = (r10v2 'z2' boolean), (r1v31 'stringExtra2' java.lang.String) call: com.tencent.mm.plugin.luckymoney.model.s.6.<init>(boolean, java.lang.String):void type: CONSTRUCTOR)
                          (r0v40 'bdVar' com.tencent.mm.plugin.luckymoney.model.ah)
                         com.tencent.mm.plugin.luckymoney.model.ah.yWK com.tencent.mm.plugin.luckymoney.model.ah$a in method: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.onCreate(android.os.Bundle):void, file: classes6.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0244: CONSTRUCTOR  (r2v14 com.tencent.mm.plugin.luckymoney.model.s$6) = (r10v2 'z2' boolean), (r1v31 'stringExtra2' java.lang.String) call: com.tencent.mm.plugin.luckymoney.model.s.6.<init>(boolean, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.onCreate(android.os.Bundle):void, file: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 31 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.luckymoney.model.s, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 35 more
                        */
                    /*
                    // Method dump skipped, instructions count: 708
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.onCreate(android.os.Bundle):void");
                }

                @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onDestroy() {
                    AppMethodBeat.i(65744);
                    super.onDestroy();
                    if (this.zeb == 1 || this.zeb == 2) {
                        this.zdz = new hf();
                        this.zdz.eEH = 9;
                        this.zdz.bfK();
                    }
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.dismiss();
                    }
                    k.cGd().rbg = null;
                    g.aAg().hqi.b(697, this.zdZ);
                    for (String str : this.UXS) {
                        ay.a.iDq.JZ(str);
                    }
                    this.UXS.clear();
                    AppMethodBeat.o(65744);
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onResume() {
                    AppMethodBeat.i(65745);
                    super.onResume();
                    this.zdW = Util.nowSecond();
                    AppMethodBeat.o(65745);
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onPause() {
                    AppMethodBeat.i(65746);
                    super.onPause();
                    com.tencent.mm.modelstat.d.m("LuckyMoneyReceiveUI", this.zdW, Util.nowSecond());
                    AppMethodBeat.o(65746);
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
                public void finish() {
                    AppMethodBeat.i(65747);
                    super.finish();
                    overridePendingTransition(0, R.anim.bo);
                    AppMethodBeat.o(65747);
                }

                @Override // com.tencent.mm.ui.MMFragmentActivity
                public boolean enableActivityAnimation() {
                    return false;
                }

                @Override // com.tencent.mm.ui.MMActivity
                public void initView() {
                    AppMethodBeat.i(65748);
                    this.yUj = findViewById(R.id.f47);
                    this.nmW = (ViewGroup) findViewById(R.id.f44);
                    this.yUh = (LinearLayout) findViewById(R.id.f4r);
                    this.yQt = (ImageView) findViewById(R.id.f45);
                    this.yRk = (TextView) findViewById(R.id.f46);
                    this.nAB = (TextView) findViewById(R.id.f48);
                    this.yln = (TextView) findViewById(R.id.f4b);
                    this.yUl = (RelativeLayout) findViewById(R.id.f0a);
                    this.yUm = (BaseEmojiView) findViewById(R.id.f07);
                    this.yUn = (TextView) findViewById(R.id.f4q);
                    this.yUo = (LinearLayout) findViewById(R.id.f1m);
                    this.yUp = (ProgressBar) findViewById(R.id.c0c);
                    this.yRl = (Button) findViewById(R.id.f4f);
                    this.yRo = (TextView) findViewById(R.id.f4c);
                    this.yRm = findViewById(R.id.f4d);
                    this.yRn = (ImageView) findViewById(R.id.ey1);
                    this.yUk = (ImageView) findViewById(R.id.f3z);
                    this.yUi = (TextView) findViewById(R.id.f4g);
                    this.UYq = (WeImageView) findViewById(R.id.f4e);
                    this.UYq.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass10 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(65736);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            LuckyMoneyNotHookReceiveUI.e(LuckyMoneyNotHookReceiveUI.this);
                            LuckyMoneyNotHookReceiveUI.this.finish();
                            h.INSTANCE.a(22105, 4, Long.valueOf(Util.ticksToNow(LuckyMoneyNotHookReceiveUI.this.startTime) / 1000));
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(65736);
                        }
                    });
                    if (this.gwE == 3) {
                        this.UYq.setEnableColorFilter(true);
                        this.UYq.setImageResource(R.raw.icons_outlined_close2);
                        this.UYq.setIconColor(getResources().getColor(R.color.am));
                    } else {
                        this.UYq.setEnableColorFilter(false);
                        this.UYq.setImageResource(R.drawable.aet);
                    }
                    this.yUn.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass11 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(258697);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, true);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(258697);
                        }
                    });
                    this.nAB.setLines(2);
                    android.support.v4.widget.q.d(this.nAB);
                    this.maxSize = (int) (((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.ab3)) * 1.125f);
                    this.textSize = com.tencent.mm.cb.a.aG(getContext(), R.dimen.ab3);
                    this.textSize = this.textSize > this.maxSize ? this.maxSize : this.textSize;
                    getContentView().setVisibility(8);
                    showLoading();
                    eeN();
                    AppMethodBeat.o(65748);
                }

                private void hWi() {
                    AppMethodBeat.i(258702);
                    if (this.UYr != null) {
                        this.UYr.send(-1, null);
                    }
                    AppMethodBeat.o(258702);
                }

                private void hWj() {
                    AppMethodBeat.i(258703);
                    if (this.UYr != null) {
                        this.UYr.send(1, null);
                    }
                    AppMethodBeat.o(258703);
                }

                public final void showLoading() {
                    AppMethodBeat.i(213418);
                    this.tipDialog = com.tencent.mm.ui.base.h.a((Context) getContext(), 3, (int) R.style.lj, getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass17 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(258698);
                            if (LuckyMoneyNotHookReceiveUI.this.tipDialog != null && LuckyMoneyNotHookReceiveUI.this.tipDialog.isShowing()) {
                                LuckyMoneyNotHookReceiveUI.this.tipDialog.dismiss();
                            }
                            LuckyMoneyNotHookReceiveUI.this.zbX.forceCancel();
                            if (LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 8 || LuckyMoneyNotHookReceiveUI.i(LuckyMoneyNotHookReceiveUI.this).getVisibility() == 4) {
                                Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "user cancel & finish");
                                LuckyMoneyNotHookReceiveUI.this.finish();
                            }
                            AppMethodBeat.o(258698);
                        }
                    });
                    AppMethodBeat.o(213418);
                }

                private void eeN() {
                    AppMethodBeat.i(65749);
                    if (this.yRl == null) {
                        AppMethodBeat.o(65749);
                        return;
                    }
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.TL(this.yRl.getId());
                    String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
                    if (loadApplicationLanguage == null || loadApplicationLanguage.length() <= 0 || (!loadApplicationLanguage.equals(LocaleUtil.CHINA) && !loadApplicationLanguage.equals(LocaleUtil.TAIWAN) && !loadApplicationLanguage.equals(LocaleUtil.HONGKONG))) {
                        this.yRl.setBackgroundResource(R.drawable.afv);
                        this.yRl.setText(R.string.er0);
                        AppMethodBeat.o(65749);
                        return;
                    }
                    AppMethodBeat.o(65749);
                }

                private void qM(boolean z) {
                    AppMethodBeat.i(65750);
                    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle:%s", Boolean.TRUE);
                    this.yUn.setVisibility(8);
                    this.zeb = 1;
                    if (z) {
                        this.zdY = 3;
                    } else {
                        this.zdY--;
                        if (this.zdY == 0) {
                            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle fail!");
                            this.yUo.setVisibility(8);
                            this.yUn.setVisibility(0);
                            this.zeb = 2;
                            AppMethodBeat.o(65750);
                            return;
                        }
                    }
                    this.rfq = k.getEmojiStorageMgr().OpN.blk(this.rcU);
                    if (this.rfq == null) {
                        this.rfq = new EmojiInfo();
                        this.rfq.field_md5 = this.rcU;
                        this.rfq.field_type = this.zdu;
                    } else if (com.tencent.mm.vfs.s.boW(this.rfq.hYx()) > 0 || this.rfq.NA() || this.rfq.hYm()) {
                        this.yUm.setVisibility(0);
                        A(this.rfq);
                        AppMethodBeat.o(65750);
                        return;
                    }
                    if (z) {
                        this.yUm.setVisibility(8);
                        this.yUo.setVisibility(0);
                        k.cGd().rbg = this.rbg;
                    }
                    k.cGd().u(this.rfq);
                    g.aAg().hqi.a(697, this.zdZ);
                    AppMethodBeat.o(65750);
                }

                private void A(EmojiInfo emojiInfo) {
                    AppMethodBeat.i(65751);
                    this.zeb = 4;
                    this.yUm.setEmojiInfo(emojiInfo);
                    this.zdz = new hf();
                    this.zdz.eEH = 8;
                    this.zdz.bfK();
                    AppMethodBeat.o(65751);
                }

                @Override // com.tencent.mm.ui.MMActivity
                public int getLayoutId() {
                    return R.layout.b4b;
                }

                @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
                public final boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                    com.tencent.mm.ak.q aoVar;
                    AppMethodBeat.i(65753);
                    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "onSceneEnd() errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " netsceneType:" + qVar.getType());
                    if (qVar instanceof bd) {
                        if (this.tipDialog != null && this.tipDialog.isShowing()) {
                            this.tipDialog.dismiss();
                        }
                        if (i2 == 0 && i3 == 0) {
                            this.yXY = (bd) qVar;
                            this.yUt = this.yXY.yUt;
                            h.INSTANCE.a(11701, 5, Integer.valueOf(PY(this.yXY.egY)), Integer.valueOf(egt()), 0, 1);
                            ae aVA = t.fQE().aVA(this.yUq);
                            if (aVA == null) {
                                aVA = new ae();
                            }
                            aVA.field_mNativeUrl = this.yUq;
                            aVA.field_hbType = this.yXY.egY;
                            aVA.field_hbStatus = this.yXY.egZ;
                            aVA.field_receiveStatus = this.yXY.eha;
                            aVA.field_sendId = this.yUc;
                            aVA.field_sender = this.mRa;
                            t.fQE().a(aVA);
                            if (aVA.field_hbType == 3) {
                                com.tencent.mm.plugin.luckymoney.b.a.eex().aDq(this.mRa);
                            }
                            if (this.yXY.eha == 2) {
                                if (af.rQ(this.zbZ)) {
                                    aoVar = new ap(this.yUc, this.yUq, "v1.0");
                                } else if (this.gwE == 3) {
                                    aoVar = new com.tencent.mm.plugin.luckymoney.model.a.d(this.yUc, this.yUq, "v1.0", this.UXO, this.UXP, this.UXQ);
                                } else {
                                    aoVar = new ao(this.yUc, 11, 0, this.yUq, "v1.0");
                                }
                                doSceneProgress(aoVar, false);
                                hWi();
                            } else {
                                if (!Util.isNullOrNil(this.yXY.yXh)) {
                                    this.zdz = new hf();
                                    this.zdz.eEH = 7;
                                    this.zdz.bfK();
                                }
                                if (this.yXY.UXx == 1) {
                                    this.yQt.setVisibility(8);
                                } else {
                                    af.a(this.yQt, this.yXY.yVe, this.yXY.yVy);
                                }
                                String stringExtra = getIntent().getStringExtra("key_username");
                                if (af.rQ(this.zbZ)) {
                                    if (ab.IN(stringExtra)) {
                                        if (!Util.isNullOrNil(this.yXY.yVy) && Util.isNullOrNil(this.yXY.yXN)) {
                                            this.yXY.yXN = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.yXY.yVy);
                                        }
                                        this.yRk.setText(this.yXY.yXN);
                                    } else if (Util.isNullOrNil(this.yXY.yVy) || !Util.isNullOrNil(this.yXY.yXN)) {
                                        af.a(getContext(), this.yRk, this.yXY.yXN);
                                    } else {
                                        this.yXY.yXN = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.yXY.yVy);
                                        af.a(getContext(), this.yRk, getString(R.string.eso, new Object[]{this.yXY.yXN}));
                                    }
                                } else if (ab.IN(stringExtra)) {
                                    this.yRk.setText(this.yXY.yXN);
                                } else if (this.yXY.egY == 3) {
                                    af.a(getContext(), this.yRk, getString(R.string.esp, new Object[]{this.yXY.yXN}));
                                } else {
                                    if (this.gwE == 3) {
                                        if (this.yXY.UXB) {
                                            g.aAi();
                                            as bjK = ((l) g.af(l.class)).aSN().bjK(this.yXY.yVy);
                                            if (bjK == null || Util.isNullOrNil(bjK.field_username)) {
                                                Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "do get contact: %s", this.yXY.yVy);
                                                this.UXS.add(this.yXY.yVy);
                                                ay.a.iDq.a(this.yXY.yVy, "", new ay.b.a() {
                                                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass14 */

                                                    @Override // com.tencent.mm.model.ay.b.a
                                                    public final void p(String str, boolean z) {
                                                        AppMethodBeat.i(258701);
                                                        Log.v("MicroMsg.LuckyMoneyParseHelper", "getContact suc, user: %s", str);
                                                        if (z) {
                                                            com.tencent.f.h.RTc.aW(new Runnable() {
                                                                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass14.AnonymousClass1 */

                                                                public final void run() {
                                                                    AppMethodBeat.i(258700);
                                                                    LuckyMoneyNotHookReceiveUI.this.UXS.remove(LuckyMoneyNotHookReceiveUI.this.yXY.yVy);
                                                                    LuckyMoneyNotHookReceiveUI.this.yXY.yXN = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(LuckyMoneyNotHookReceiveUI.this.yXY.yVy);
                                                                    af.a(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyNotHookReceiveUI.this.yRk, LuckyMoneyNotHookReceiveUI.this.getString(R.string.esp, new Object[]{LuckyMoneyNotHookReceiveUI.this.yXY.yXN}));
                                                                    AppMethodBeat.o(258700);
                                                                }
                                                            });
                                                        }
                                                        AppMethodBeat.o(258701);
                                                    }
                                                });
                                            } else {
                                                af.a(getContext(), this.yRk, getString(R.string.esp, new Object[]{this.yXY.yXN}));
                                            }
                                        } else {
                                            af.a(getContext(), this.yRk, this.yXY.yXN);
                                        }
                                    }
                                    af.a(getContext(), this.yRk, getString(R.string.eso, new Object[]{this.yXY.yXN}));
                                }
                                if (this.yXY.egY == 1 && this.yXY.egZ == 4 && !af.rQ(this.zbZ) && this.gwE != 3) {
                                    h.INSTANCE.a(22105, 1);
                                    egs();
                                }
                                String stringExtra2 = getIntent().getStringExtra("key_live_error_msg");
                                if (!Util.isNullOrNil(stringExtra2)) {
                                    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "live errorMsg: %s", stringExtra2);
                                }
                                final boolean z = false;
                                if (this.yXY.eha == 1 || this.yXY.egZ == 4 || this.yXY.egZ == 5 || this.yXY.egZ == 1 || !Util.isNullOrNil(stringExtra2)) {
                                    this.yRl.setVisibility(8);
                                    if (!Util.isNullOrNil(stringExtra2)) {
                                        this.nAB.setText(stringExtra2);
                                        this.nAB.setVisibility(0);
                                    } else {
                                        if (!Util.isNullOrNil(this.yXY.yRQ)) {
                                            this.nAB.setText(this.yXY.yRQ);
                                            this.nAB.setVisibility(0);
                                        } else {
                                            this.nAB.setVisibility(8);
                                        }
                                        if (!Util.isNullOrNil(this.yXY.yVb)) {
                                            this.yln.setText(this.yXY.yVb);
                                            this.yln.setVisibility(0);
                                            this.yln.setSingleLine(false);
                                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.yRm.getLayoutParams();
                                            layoutParams.bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 30.0f);
                                            this.yRm.setLayoutParams(layoutParams);
                                            hWj();
                                            z = true;
                                        }
                                    }
                                    this.yln.setVisibility(8);
                                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.yRm.getLayoutParams();
                                    layoutParams2.bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 30.0f);
                                    this.yRm.setLayoutParams(layoutParams2);
                                    hWj();
                                    z = true;
                                } else {
                                    if (!Util.isNullOrNil(this.yXY.yVb)) {
                                        this.nAB.setText(this.yXY.yVb);
                                        this.nAB.setVisibility(0);
                                        m.vli.a(s.bh.ONLY_WX_IDENTIFY_INTERRUPT_NOTIFY, s.bg.UNKNOWN, true);
                                    }
                                    if (!Util.isNullOrNil(this.yXY.yPK)) {
                                        af.a(getContext(), this.yln, this.yXY.yPK);
                                        this.yln.setVisibility(0);
                                        this.nAB.setVisibility(8);
                                    }
                                    if (!Util.isNullOrNil(this.yXY.yXh) && Util.isEqual(this.yUt, 1)) {
                                        this.rcU = this.yXY.yXh;
                                        this.zdu = this.yXY.yXi;
                                        this.yUl.setVisibility(0);
                                        qM(true);
                                    }
                                    this.yRl.setOnClickListener(new View.OnClickListener() {
                                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass15 */

                                        public final void onClick(View view) {
                                            AppMethodBeat.i(65741);
                                            b bVar = new b();
                                            bVar.bm(view);
                                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                            ((com.tencent.mm.pluginsdk.wallet.b) g.af(com.tencent.mm.pluginsdk.wallet.b.class)).he(10, 3);
                                            h.INSTANCE.a(11701, 5, Integer.valueOf(LuckyMoneyNotHookReceiveUI.awY(LuckyMoneyNotHookReceiveUI.this.yXY.egY)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.m(LuckyMoneyNotHookReceiveUI.this)), 0, 2);
                                            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "open btn click!");
                                            LuckyMoneyNotHookReceiveUI.this.yRl.setClickable(false);
                                            m.vli.a(s.bh.CLICK_OPEN_RED_PACKET, s.bg.UNKNOWN, true);
                                            LuckyMoneyNotHookReceiveUI.this.aDF("");
                                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(65741);
                                        }
                                    });
                                }
                                if ((z.aTY().equals(this.xGm) || ((this.yXY.egY == 1 && this.yXY.egZ == 4) || (this.yXY.egY == 3 && this.yXY.egZ == 4))) && Util.isNullOrNil(stringExtra2)) {
                                    if (this.yXY.egY == 1) {
                                        this.yRo.setText(R.string.eoi);
                                    }
                                    this.yRm.setVisibility(0);
                                    this.yRm.setOnClickListener(new View.OnClickListener() {
                                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass2 */

                                        public final void onClick(View view) {
                                            AppMethodBeat.i(258690);
                                            b bVar = new b();
                                            bVar.bm(view);
                                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                            if (z) {
                                                h.INSTANCE.a(11701, 6, Integer.valueOf(LuckyMoneyNotHookReceiveUI.awY(LuckyMoneyNotHookReceiveUI.this.yXY.egY)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.m(LuckyMoneyNotHookReceiveUI.this)), 0, 1);
                                            }
                                            Intent intent = new Intent();
                                            intent.setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
                                            intent.putExtra("key_native_url", LuckyMoneyNotHookReceiveUI.this.yXY.egX);
                                            intent.putExtra("key_sendid", LuckyMoneyNotHookReceiveUI.this.yXY.yQE);
                                            intent.putExtra("key_lucky_money_can_received", true);
                                            intent.putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
                                            intent.putExtra("scene_id", LuckyMoneyNotHookReceiveUI.this.zbZ);
                                            intent.putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.this.gof);
                                            LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, intent);
                                            LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI = LuckyMoneyNotHookReceiveUI.this;
                                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                            com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyNotHookReceiveUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            luckyMoneyNotHookReceiveUI.startActivity((Intent) bl.pG(0));
                                            com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyNotHookReceiveUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            LuckyMoneyNotHookReceiveUI.this.finish();
                                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(258690);
                                        }
                                    });
                                    this.yRn.setVisibility(8);
                                } else {
                                    this.yRm.setVisibility(8);
                                    this.yRn.setVisibility(8);
                                }
                                if (ab.IN(stringExtra) && this.yXY.yXS == null) {
                                    this.yXY.yXS = new bi();
                                }
                                if (this.yXY.yXS != null) {
                                    String stringExtra3 = getIntent().getStringExtra("key_receive_envelope_url");
                                    String stringExtra4 = getIntent().getStringExtra("key_receive_envelope_md5");
                                    if (!Util.isNullOrNil(stringExtra3)) {
                                        Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use bubble xml content");
                                        if (this.yXY.yXS.yXW == null) {
                                            this.yXY.yXS.yXW = new cbe();
                                        }
                                        this.yXY.yXS.yXW.MgC = new cbf();
                                        this.yXY.yXS.yXW.MgC.igW = stringExtra3;
                                        this.yXY.yXS.yXW.MgC.MgX = stringExtra4;
                                    }
                                    cbe cbe = this.yXY.yXS.yXW;
                                    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "render envelope");
                                    if (cbe != null) {
                                        ((com.tencent.mm.plugin.luckymoney.a.a) g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.yUk, cbe, null);
                                        this.yUk.setVisibility(0);
                                        this.yRn.setVisibility(8);
                                        this.zgf = true;
                                        if (this.qBv == 2) {
                                            this.yUi.setVisibility(0);
                                        } else {
                                            this.yUi.setVisibility(8);
                                        }
                                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.yUh.getLayoutParams();
                                        layoutParams3.topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 88.0f);
                                        this.yUh.setLayoutParams(layoutParams3);
                                        af.s(this.yln);
                                        af.s(this.nAB);
                                        af.s(this.yRk);
                                        String str2 = "";
                                        if (cbe.MgC != null) {
                                            str2 = cbe.MgC.igW;
                                        }
                                        c.bC(2, str2);
                                    }
                                    getIntent().getStringExtra("key_username");
                                    if (!Util.isNullOrNil(this.yXY.yXS.yXW.MgB)) {
                                        this.zge = this.yXY.yXS.yXW.MgB;
                                    }
                                } else {
                                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.yUh.getLayoutParams();
                                    if (!Util.isNullOrNil(this.rcU)) {
                                        layoutParams4.topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 88.0f);
                                    } else {
                                        layoutParams4.topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 118.0f);
                                    }
                                    if (com.tencent.mm.cc.a.gvi() != 1.0f) {
                                        layoutParams4.topMargin = (int) (((float) layoutParams4.topMargin) / com.tencent.mm.cc.a.gvi());
                                    }
                                    this.yUh.setLayoutParams(layoutParams4);
                                }
                                if (this.gwE == 3) {
                                    this.nmW.setBackgroundResource(R.drawable.cv_);
                                    com.tencent.mm.ui.ao.q(this, getResources().getColor(R.color.ac));
                                    findViewById(R.id.k0u).setVisibility(8);
                                } else if (com.tencent.mm.ui.ao.isDarkMode()) {
                                    this.nmW.setBackgroundResource(R.color.BW_0_Alpha_0_8);
                                    com.tencent.mm.ui.ao.q(this, getResources().getColor(R.color.BW_0_Alpha_0_8));
                                } else {
                                    this.nmW.setBackgroundResource(R.color.yr);
                                    com.tencent.mm.ui.ao.q(this, getResources().getColor(R.color.yr));
                                }
                                getContentView().setVisibility(0);
                                this.yUj.setVisibility(0);
                                af.eo(this.yUj);
                            }
                            AppMethodBeat.o(65753);
                            return true;
                        }
                        AppMethodBeat.o(65753);
                        return false;
                    }
                    if (qVar instanceof com.tencent.mm.plugin.luckymoney.model.ay) {
                        if (this.tipDialog != null && this.tipDialog.isShowing()) {
                            this.tipDialog.dismiss();
                        }
                        af.d(this.yRl);
                        this.yRl.setClickable(true);
                        eeN();
                        if (i2 == 0 && i3 == 0) {
                            final com.tencent.mm.plugin.luckymoney.model.ay ayVar = (com.tencent.mm.plugin.luckymoney.model.ay) qVar;
                            l.a(this, l.a.NOTSET);
                            if (ayVar.isJumpRemind() && ayVar.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.g() {
                                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass3 */

                                @Override // com.tencent.mm.wallet_core.c.g
                                public final void eeY() {
                                    AppMethodBeat.i(65733);
                                    LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, ayVar);
                                    AppMethodBeat.o(65733);
                                }
                            })) {
                                AppMethodBeat.o(65753);
                                return true;
                            } else if (com.tencent.mm.plugin.wallet_core.utils.c.a(ayVar.yXE)) {
                                setContentViewVisibility(4);
                                new com.tencent.mm.plugin.wallet_core.utils.c(this).a(ayVar.yXE, new c.a() {
                                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass4 */

                                    @Override // com.tencent.mm.plugin.wallet_core.utils.c.a
                                    public final void a(cfl cfl) {
                                        AppMethodBeat.i(258691);
                                        if (cfl.action == 2) {
                                            LuckyMoneyNotHookReceiveUI.this.showLoading();
                                            LuckyMoneyNotHookReceiveUI.this.aDF(ayVar.yXG);
                                            AppMethodBeat.o(258691);
                                            return;
                                        }
                                        LuckyMoneyNotHookReceiveUI.this.finish();
                                        AppMethodBeat.o(258691);
                                    }
                                });
                                AppMethodBeat.o(65753);
                                return true;
                            } else {
                                a(ayVar);
                                if (this.zgf) {
                                    h.INSTANCE.dN(991, 13);
                                }
                                AppMethodBeat.o(65753);
                                return true;
                            }
                        } else if (i3 == 416) {
                            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                                this.tipDialog.dismiss();
                            }
                            Bundle bundle = new Bundle();
                            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNotHookReceiveUI");
                            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                            this.yRl.setBackgroundResource(R.drawable.c97);
                            boolean a2 = af.a(this, i3, qVar, bundle, false, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass5 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            }, null, 1003);
                            AppMethodBeat.o(65753);
                            return a2;
                        } else if (i3 == 419) {
                            com.tencent.mm.ui.base.h.a(getContext(), str, "", getContext().getString(R.string.eoj), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass6 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(258692);
                                    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "click AlertDialog");
                                    LuckyMoneyNotHookReceiveUI.this.finish();
                                    AppMethodBeat.o(258692);
                                }
                            });
                            AppMethodBeat.o(65753);
                            return true;
                        }
                    } else if (qVar instanceof ao) {
                        if (this.tipDialog != null && this.tipDialog.isShowing()) {
                            this.tipDialog.dismiss();
                        }
                        if (i2 == 0 && i3 == 0) {
                            ao aoVar2 = (ao) qVar;
                            Intent intent = new Intent();
                            intent.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
                            intent.putExtra("key_lucky_money_can_received", true);
                            try {
                                com.tencent.mm.plugin.luckymoney.a.b.a(this.yUc, aoVar2.yWT);
                                intent.putExtra("key_jump_from", 2);
                            } catch (Exception e2) {
                                Log.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e2.getLocalizedMessage());
                            }
                            intent.putExtra("key_native_url", this.yUq);
                            intent.putExtra("key_sendid", this.yUc);
                            intent.putExtra("key_anim_slide", true);
                            intent.putExtra("key_detail_emoji_md5", aoVar2.yXh);
                            intent.putExtra("key_detail_emoji_type", aoVar2.yXi);
                            intent.putExtra("key_username", getIntent().getStringExtra("key_username"));
                            intent.putExtra("scene_id", this.zbZ);
                            intent.putExtra("key_emoji_switch", aoVar2.yXj);
                            intent.putExtra("key_msgid", this.gof);
                            aH(intent);
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            finish();
                            AppMethodBeat.o(65753);
                            return true;
                        }
                        com.tencent.mm.ui.base.h.cD(this, str);
                        finish();
                        AppMethodBeat.o(65753);
                        return true;
                    }
                    AppMethodBeat.o(65753);
                    return false;
                }

                private void egs() {
                    AppMethodBeat.i(213419);
                    if (!com.tencent.mm.plugin.luckymoney.ui.a.a.bfV()) {
                        Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "random drop this time");
                        AppMethodBeat.o(213419);
                        return;
                    }
                    bwe bwe = zgd.get(this.yUc);
                    if (bwe != null) {
                        Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use cache response this time");
                        a(bwe);
                        AppMethodBeat.o(213419);
                        return;
                    }
                    String stringExtra = getIntent().getStringExtra("key_packet_id");
                    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "do get time limit promot: %s", stringExtra);
                    new com.tencent.mm.plugin.luckymoney.model.e(stringExtra).aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<bwe>>() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass7 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Object call(c.a<bwe> aVar) {
                            AppMethodBeat.i(258693);
                            c.a<bwe> aVar2 = aVar;
                            Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "do confirm errType: %s, errCode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                            if (aVar2.errType == 0 && aVar2.errCode == 0 && aVar2.iLC != null) {
                                if (!Util.isNullOrNil(LuckyMoneyNotHookReceiveUI.this.yUc)) {
                                    LuckyMoneyNotHookReceiveUI.zgd.put(LuckyMoneyNotHookReceiveUI.this.yUc, aVar2.iLC);
                                }
                                LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, (bwe) aVar2.iLC);
                                com.tencent.mm.plugin.luckymoney.ui.a.a.gW(((bwe) aVar2.iLC).Mcb, ((bwe) aVar2.iLC).Mcc);
                            }
                            AppMethodBeat.o(258693);
                            return null;
                        }
                    }).a(this);
                    AppMethodBeat.o(213419);
                }

                private void a(final bwe bwe) {
                    AppMethodBeat.i(213420);
                    if (bwe.Mca) {
                        Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "show envelope promo");
                        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.f3x);
                        CdnImageView cdnImageView = (CdnImageView) viewGroup.findViewById(R.id.f3w);
                        TextView textView = (TextView) viewGroup.findViewById(R.id.f3y);
                        textView.setMaxWidth(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), (((com.tencent.mm.cb.a.E(getContext(), com.tencent.mm.cb.a.jn(getContext())) - 24) - 20) - 36) - 18));
                        f.G(textView);
                        cdnImageView.setRoundCorner(true);
                        cdnImageView.setUrl(bwe.iwv);
                        textView.setText(bwe.title);
                        if (bwe.Mce != null) {
                            GradientDrawable gradientDrawable = new GradientDrawable();
                            gradientDrawable.setShape(0);
                            gradientDrawable.setCornerRadius((float) com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 24));
                            long colorByMode = ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(bwe.Mce.LrI, bwe.Mce.LrJ);
                            if (colorByMode != -1) {
                                gradientDrawable.setColor(com.tencent.mm.plugin.wallet_core.utils.g.argbColor(colorByMode));
                            }
                            viewGroup.setBackground(gradientDrawable);
                        }
                        if (bwe.Mcd != null) {
                            long colorByMode2 = ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).getColorByMode(bwe.Mcd.LrI, bwe.Mcd.LrJ);
                            if (colorByMode2 != -1) {
                                textView.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.argbColor(colorByMode2));
                            }
                        }
                        viewGroup.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass8 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(213417);
                                b bVar = new b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                f.bn(LuckyMoneyNotHookReceiveUI.this.getContext(), bwe.url);
                                h.INSTANCE.a(22105, 3, 0, bwe.Mcf);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(213417);
                            }
                        });
                        viewGroup.setVisibility(0);
                        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.c8);
                        loadAnimation.setInterpolator(new DecelerateInterpolator());
                        loadAnimation.setDuration(300);
                        loadAnimation.setFillAfter(true);
                        loadAnimation.setFillEnabled(true);
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.n);
                        loadAnimation2.setDuration(300);
                        loadAnimation2.setFillEnabled(true);
                        loadAnimation2.setFillAfter(true);
                        AnimationSet animationSet = new AnimationSet(false);
                        animationSet.addAnimation(loadAnimation);
                        animationSet.addAnimation(loadAnimation2);
                        viewGroup.startAnimation(animationSet);
                        h.INSTANCE.a(22105, 2, 0, bwe.Mcf);
                        animationSet.setAnimationListener(new Animation.AnimationListener() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass12 */

                            public final void onAnimationStart(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                AppMethodBeat.i(258694);
                                Rect rect = new Rect();
                                viewGroup.getGlobalVisibleRect(rect);
                                if (rect.bottom >= com.tencent.mm.ui.ao.gx(LuckyMoneyNotHookReceiveUI.this.getContext()).y) {
                                    Log.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "over bottom");
                                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
                                    if (marginLayoutParams != null) {
                                        marginLayoutParams.topMargin = com.tencent.mm.wallet_core.ui.noscale.a.axx(16);
                                        viewGroup.setLayoutParams(marginLayoutParams);
                                    }
                                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) LuckyMoneyNotHookReceiveUI.this.UYq.getLayoutParams();
                                    if (marginLayoutParams2 != null) {
                                        marginLayoutParams2.topMargin = com.tencent.mm.wallet_core.ui.noscale.a.axx(16);
                                        LuckyMoneyNotHookReceiveUI.this.UYq.setLayoutParams(marginLayoutParams2);
                                    }
                                }
                                AppMethodBeat.o(258694);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }
                        });
                    }
                    AppMethodBeat.o(213420);
                }

                private void aH(Intent intent) {
                    AppMethodBeat.i(163761);
                    intent.putExtra("key_detail_envelope_url", getIntent().getStringExtra("key_detail_envelope_url"));
                    intent.putExtra("key_detail_envelope_md5", getIntent().getStringExtra("key_detail_envelope_md5"));
                    intent.putExtra("key_about_url", getIntent().getStringExtra("key_about_url"));
                    intent.putExtra("key_store_action_type", getIntent().getStringExtra("key_store_action_type"));
                    intent.putExtra("key_story_url", getIntent().getStringExtra("key_story_url"));
                    intent.putExtra("key_cropname", getIntent().getStringExtra("key_cropname"));
                    intent.putExtra("key_packet_id", getIntent().getStringExtra("key_packet_id"));
                    intent.putExtra("key_has_story", getIntent().getBooleanExtra("key_has_story", false));
                    intent.putExtra("key_material_flag", this.qBv);
                    intent.putExtra("key_from", getIntent().getIntExtra("key_from", 0));
                    intent.putExtra("key_live_id", getIntent().getStringExtra("key_live_id"));
                    intent.putExtra("key_live_attach", getIntent().getStringExtra("key_live_attach"));
                    intent.putExtra("key_live_anchor_type", getIntent().getIntExtra("key_live_anchor_type", 0));
                    AppMethodBeat.o(163761);
                }

                private void a(final com.tencent.mm.plugin.luckymoney.model.ay ayVar) {
                    AppMethodBeat.i(65754);
                    com.tencent.mm.plugin.luckymoney.model.q qVar = ayVar.yWT;
                    if (qVar.eha == 2) {
                        Intent intent = new Intent();
                        intent.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
                        intent.putExtra("key_lucky_intercept_win_after", ayVar.yXF);
                        intent.putExtra("key_lucky_money_can_received", true);
                        try {
                            com.tencent.mm.plugin.luckymoney.a.b.a(this.yUc, ayVar.yWT);
                            intent.putExtra("key_jump_from", 2);
                        } catch (Exception e2) {
                            Log.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e2.getLocalizedMessage());
                        }
                        intent.putExtra("key_native_url", ayVar.egX);
                        intent.putExtra("key_sendid", ayVar.yQE);
                        aH(intent);
                        if (com.tencent.mm.n.h.aqJ().getInt("PlayCoinSound", 0) > 0) {
                            intent.putExtra("play_sound", true);
                        }
                        if (ayVar.yRu != null) {
                            intent.putExtra("key_realname_guide_helper", ayVar.yRu);
                        }
                        intent.putExtra("key_username", getIntent().getStringExtra("key_username"));
                        intent.putExtra("scene_id", this.zbZ);
                        intent.putExtra("key_emoji_switch", ayVar.yXj);
                        intent.putExtra("key_detail_emoji_md5", ayVar.yXh);
                        intent.putExtra("key_detail_emoji_type", ayVar.yXi);
                        intent.putExtra("key_msgid", this.gof);
                        intent.putExtra("scene_id", this.zbZ);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/NetSceneOpenLuckyMoney;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        finish();
                        String stringExtra = getIntent().getStringExtra("key_username");
                        if (!ab.IN(stringExtra)) {
                            ae aVA = t.fQE().aVA(this.yUq);
                            if (aVA == null) {
                                aVA = new ae();
                            }
                            aVA.field_mNativeUrl = this.yUq;
                            aVA.field_receiveAmount = qVar.eht;
                            aVA.field_receiveTime = System.currentTimeMillis();
                            aVA.field_hbStatus = qVar.egZ;
                            aVA.field_receiveStatus = qVar.eha;
                            aVA.field_sender = stringExtra;
                            aVA.field_sendId = this.yUc;
                            aVA.field_exclusiveUsername = getIntent().getStringExtra("key_exclusive_username");
                            if (aVA.field_receiveAmount > 0) {
                                t.fQE().a(aVA);
                                if (aVA.field_hbType == 3) {
                                    com.tencent.mm.plugin.luckymoney.b.a.eex().aDq(stringExtra);
                                }
                            }
                        }
                        hWi();
                        AppMethodBeat.o(65754);
                        return;
                    }
                    this.yRl.setBackgroundResource(R.drawable.cf8);
                    this.yRl.setText(R.string.eqx);
                    this.yRl.setOnClickListener(null);
                    this.yRl.setVisibility(8);
                    if (!Util.isNullOrNil(qVar.yRQ)) {
                        this.nAB.setText(qVar.yRQ);
                        this.nAB.setVisibility(0);
                    } else {
                        this.nAB.setVisibility(8);
                    }
                    this.yln.setText(qVar.yVb);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.yRm.getLayoutParams();
                    layoutParams.bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 30.0f);
                    this.yRm.setLayoutParams(layoutParams);
                    if (z.aTY().equals(this.xGm) || qVar.egY == 1) {
                        this.yRm.setVisibility(0);
                        this.yRm.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.AnonymousClass16 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(258695);
                                b bVar = new b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Intent intent = new Intent();
                                if (ayVar.yRu != null) {
                                    intent.putExtra("key_realname_guide_helper", ayVar.yRu);
                                }
                                intent.setClass(LuckyMoneyNotHookReceiveUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
                                intent.putExtra("key_lucky_money_can_received", true);
                                intent.putExtra("key_native_url", ayVar.egX);
                                intent.putExtra("key_sendid", ayVar.yQE);
                                intent.putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
                                intent.putExtra("scene_id", LuckyMoneyNotHookReceiveUI.this.zbZ);
                                intent.putExtra("key_emoji_switch", ayVar.yXj);
                                intent.putExtra("key_detail_emoji_md5", ayVar.yXh);
                                intent.putExtra("key_detail_emoji_type", ayVar.yXi);
                                intent.putExtra("key_msgid", LuckyMoneyNotHookReceiveUI.this.gof);
                                LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, intent);
                                LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI = LuckyMoneyNotHookReceiveUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyNotHookReceiveUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                luckyMoneyNotHookReceiveUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyNotHookReceiveUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                LuckyMoneyNotHookReceiveUI.this.finish();
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(258695);
                            }
                        });
                        this.yRn.setVisibility(8);
                    } else {
                        this.yRm.setVisibility(8);
                        this.yRn.setVisibility(8);
                    }
                    if (qVar.egY == 1 && qVar.egZ == 4 && !af.rQ(this.zbZ) && this.gwE != 3) {
                        egs();
                    }
                    hWj();
                    AppMethodBeat.o(65754);
                }

                private int egt() {
                    AppMethodBeat.i(65755);
                    if (z.aTY().equals(this.xGm)) {
                        AppMethodBeat.o(65755);
                        return 1;
                    }
                    AppMethodBeat.o(65755);
                    return 0;
                }

                private static int PY(int i2) {
                    if (i2 == 1) {
                        return 1;
                    }
                    if (i2 == 0) {
                        return 2;
                    }
                    return 0;
                }

                public final void aDF(String str) {
                    String str2;
                    ah ayVar;
                    boolean z;
                    AppMethodBeat.i(213421);
                    if (str == null) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if (af.rQ(this.zbZ)) {
                        ayVar = new az(this.yXY.msgType, this.yXY.channelId, this.yXY.yQE, this.yXY.egX, af.efj(), z.aUa(), stringExtra, "v1.0", this.yXY.yXR);
                    } else if (this.gwE == 3) {
                        ayVar = new com.tencent.mm.plugin.luckymoney.model.a.b(this.yXY.msgType, this.yXY.channelId, this.yXY.yQE, this.yXY.egX, af.efj(), z.aUa(), stringExtra, "v1.0", this.yXY.yXR, str2, getIntent().getStringExtra("key_live_id"), getIntent().getStringExtra("key_live_attach"), this.UXQ);
                    } else {
                        ayVar = new com.tencent.mm.plugin.luckymoney.model.ay(this.yXY.msgType, this.yXY.channelId, this.yXY.yQE, this.yXY.egX, af.efj(), z.aUa(), stringExtra, "v1.0", this.yXY.yXR, str2);
                    }
                    if (ab.IN(stringExtra)) {
                        String stringExtra2 = getIntent().getStringExtra("key_emoji_md5");
                        if (!Util.isNullOrNil(stringExtra2)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ayVar.yWK = 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005f: IPUT  
                              (wrap: com.tencent.mm.plugin.luckymoney.model.s$7 : 0x005c: CONSTRUCTOR  (r3v4 com.tencent.mm.plugin.luckymoney.model.s$7) = (r1v13 'z' boolean), (r2v5 'stringExtra2' java.lang.String) call: com.tencent.mm.plugin.luckymoney.model.s.7.<init>(boolean, java.lang.String):void type: CONSTRUCTOR)
                              (r0v9 'ayVar' com.tencent.mm.plugin.luckymoney.model.ah)
                             com.tencent.mm.plugin.luckymoney.model.ah.yWK com.tencent.mm.plugin.luckymoney.model.ah$a in method: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.aDF(java.lang.String):void, file: classes6.dex
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
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005c: CONSTRUCTOR  (r3v4 com.tencent.mm.plugin.luckymoney.model.s$7) = (r1v13 'z' boolean), (r2v5 'stringExtra2' java.lang.String) call: com.tencent.mm.plugin.luckymoney.model.s.7.<init>(boolean, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.aDF(java.lang.String):void, file: classes6.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 19 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.luckymoney.model.s, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 23 more
                            */
                        /*
                        // Method dump skipped, instructions count: 227
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.aDF(java.lang.String):void");
                    }

                    static /* synthetic */ void e(LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI) {
                        AppMethodBeat.i(258704);
                        if (luckyMoneyNotHookReceiveUI.UYr != null) {
                            luckyMoneyNotHookReceiveUI.UYr.send(0, null);
                        }
                        AppMethodBeat.o(258704);
                    }
                }
