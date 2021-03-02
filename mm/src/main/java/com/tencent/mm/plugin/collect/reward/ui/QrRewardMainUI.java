package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.appbrand.jsapi.k.aa;
import com.tencent.mm.plugin.collect.reward.a.a;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.plugin.collect.reward.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.smtt.sdk.TbsMediaPlayer;

public class QrRewardMainUI extends QrRewardBaseUI {
    private String desc;
    private String ega;
    private int iconWidth;
    private TextView jVn;
    private String lRD;
    private boolean mIsOpen = false;
    private ScrollView qyA;
    private String qyB;
    private String qyC;
    private String qyD;
    private int qyE;
    private boolean qyF;
    private boolean qyG;
    private final int qyn = a.fromDPToPix((Context) getContext(), 200);
    private RelativeLayout qyo;
    private Button qyp;
    private ViewGroup qyq;
    private ViewGroup qyr;
    private RelativeLayout qys;
    private CdnImageView qyt;
    private ImageView qyu;
    private ImageView qyv;
    private MMEditText qyw;
    private TextView qyx;
    private TextView qyy;
    private TextView qyz;
    private String username;

    @Override // com.tencent.mm.plugin.collect.reward.ui.QrRewardBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public QrRewardMainUI() {
        AppMethodBeat.i(63961);
        AppMethodBeat.o(63961);
    }

    static /* synthetic */ void a(QrRewardMainUI qrRewardMainUI, String str, String str2) {
        AppMethodBeat.i(63984);
        qrRewardMainUI.n(str, str2, false);
        AppMethodBeat.o(63984);
    }

    static /* synthetic */ void a(QrRewardMainUI qrRewardMainUI, boolean z) {
        AppMethodBeat.i(63978);
        qrRewardMainUI.kO(z);
        AppMethodBeat.o(63978);
    }

    static /* synthetic */ void b(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(63977);
        qrRewardMainUI.cAd();
        AppMethodBeat.o(63977);
    }

    static /* synthetic */ void cAe() {
    }

    static /* synthetic */ void i(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(63982);
        qrRewardMainUI.cAb();
        AppMethodBeat.o(63982);
    }

    static /* synthetic */ void l(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(63985);
        qrRewardMainUI.cAa();
        AppMethodBeat.o(63985);
    }

    static /* synthetic */ void m(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(63986);
        qrRewardMainUI.cAc();
        AppMethodBeat.o(63986);
    }

    static /* synthetic */ void q(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(63989);
        qrRewardMainUI.czX();
        AppMethodBeat.o(63989);
    }

    @Override // com.tencent.mm.plugin.collect.reward.ui.QrRewardBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(63962);
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        addSceneEndListener(1323);
        addSceneEndListener(1649);
        this.qyE = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_QR_REWARD_PHOTO_WIDTH_INT_SYNC, Integer.valueOf((int) TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR))).intValue();
        this.iconWidth = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_QR_REWARD_ICON_WIDTH_INT_SYNC, Integer.valueOf((int) aa.CTRL_INDEX))).intValue();
        this.desc = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_QR_REWARD_DESC_STRING_SYNC, "");
        this.qyB = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, "");
        this.qyC = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_QR_REWARD_BOTTOM_STR_STRING_SYNC, "");
        this.qyD = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_QR_REWARD_BOTTOM_URL_STRING_SYNC, "");
        this.lRD = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_QR_REWARD_LAST_PHOTO_URL_STRING_SYNC, "");
        if (!Util.isNullOrNil((String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_QR_REWARD_AMT_LIST_STRING_SYNC, ""))) {
            this.qyG = true;
        }
        this.username = z.aTY();
        setMMTitle(R.string.frs);
        initView();
        if (!com.tencent.mm.plugin.collect.reward.b.a.czR().czS() || !this.qyG) {
            z = false;
        } else {
            z = true;
        }
        Log.i("MicroMsg.QrRewardMainUI", "do get code: %s", Boolean.valueOf(z));
        b bVar = new b(z);
        bVar.M(this);
        if (z) {
            doSceneProgress(bVar, false);
            AppMethodBeat.o(63962);
            return;
        }
        doSceneProgress(bVar, true);
        AppMethodBeat.o(63962);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(63963);
        this.qyo = (RelativeLayout) findViewById(R.id.h96);
        this.qyp = (Button) findViewById(R.id.gp3);
        this.qyq = (ViewGroup) findViewById(R.id.gp2);
        this.qyr = (ViewGroup) findViewById(R.id.gp1);
        this.qyt = (CdnImageView) findViewById(R.id.gow);
        this.jVn = (TextView) findViewById(R.id.gp0);
        this.qyu = (ImageView) findViewById(R.id.gov);
        this.qyv = (ImageView) findViewById(R.id.gou);
        this.qys = (RelativeLayout) findViewById(R.id.gox);
        this.qyw = (MMEditText) findViewById(R.id.goy);
        this.qyx = (TextView) findViewById(R.id.gp5);
        this.qyz = (TextView) findViewById(R.id.gp8);
        this.qyy = (TextView) findViewById(R.id.got);
        a.b.a(this.qyu, this.username, 0.03f, true);
        try {
            this.qyw.setText(l.b(getContext(), this.qyB, this.qyw.getTextSize()));
            this.qyw.setSelection(this.qyB.length());
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.QrRewardMainUI", e2, "", new Object[0]);
        }
        this.qyw.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass1 */
            int qyH = 0;

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(63942);
                Log.d("MicroMsg.QrRewardMainUI", "s: %s, %s", editable.toString(), Integer.valueOf(editable.length()));
                String obj = editable.toString();
                if (Util.isNullOrNil(obj)) {
                    this.qyH = 0;
                } else if (this.qyH == 0) {
                    if (((com.tencent.mm.plugin.emoji.b.a) g.af(com.tencent.mm.plugin.emoji.b.a.class)).M(obj) || ((com.tencent.mm.plugin.emoji.b.a) g.af(com.tencent.mm.plugin.emoji.b.a.class)).N(obj)) {
                        this.qyH = editable.length();
                    } else {
                        this.qyH = 1;
                    }
                }
                editable.delete(this.qyH, editable.length());
                AppMethodBeat.o(63942);
            }
        });
        this.qyw.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass10 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(63952);
                Log.i("MicroMsg.QrRewardMainUI", "action: %s", Integer.valueOf(i2));
                QrRewardMainUI.this.qyB = QrRewardMainUI.this.qyw.getText().toString();
                QrRewardMainUI.b(QrRewardMainUI.this);
                if (Util.isNullOrNil(QrRewardMainUI.this.qyB)) {
                    QrRewardMainUI.a(QrRewardMainUI.this, true);
                }
                QrRewardMainUI.this.hideVKB();
                AppMethodBeat.o(63952);
                return false;
            }
        });
        this.qyv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(63953);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/reward/ui/QrRewardMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.QrRewardMainUI", "click avatar");
                QrRewardMainUI.this.hideVKB();
                QrRewardMainUI.d(QrRewardMainUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(63953);
            }
        });
        this.qyx.setClickable(true);
        this.qyx.setOnTouchListener(new o(this));
        q qVar = new q(new q.a() {
            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass12 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
            public final void dF(View view) {
                AppMethodBeat.i(63954);
                Log.i("MicroMsg.QrRewardMainUI", "click save code");
                p.a(QrRewardMainUI.this, new Runnable() {
                    /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass12.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(213160);
                        QrRewardMainUI.e(QrRewardMainUI.this);
                        h.INSTANCE.a(14721, 1, 5);
                        AppMethodBeat.o(213160);
                    }
                }, new Runnable() {
                    /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass12.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(213161);
                        Toast.makeText(QrRewardMainUI.this, (int) R.string.gao, 1).show();
                        AppMethodBeat.o(213161);
                    }
                });
                AppMethodBeat.o(63954);
            }
        });
        SpannableString spannableString = new SpannableString(getString(R.string.frx));
        spannableString.setSpan(qVar, 0, spannableString.length(), 18);
        this.qyx.setText(spannableString);
        this.qyz.setClickable(true);
        this.qyz.setOnTouchListener(new o(this));
        q qVar2 = new q(new q.a() {
            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass13 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
            public final void dF(View view) {
                AppMethodBeat.i(63955);
                Log.i("MicroMsg.QrRewardMainUI", "click set code, %s", Boolean.valueOf(QrRewardMainUI.this.qyG));
                QrRewardMainUI.b(QrRewardMainUI.this, false);
                AppMethodBeat.o(63955);
            }
        });
        SpannableString spannableString2 = new SpannableString(getString(R.string.fs7));
        spannableString2.setSpan(qVar2, 0, spannableString2.length(), 18);
        this.qyz.setText(spannableString2);
        czX();
        cAa();
        cAc();
        cAb();
        AppMethodBeat.o(63963);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(63964);
        if (qVar instanceof b) {
            final b bVar = (b) qVar;
            bVar.a(new a.AbstractC0930a() {
                /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass16 */

                @Override // com.tencent.mm.plugin.collect.reward.a.a.AbstractC0930a
                public final void g(com.tencent.mm.ak.q qVar) {
                    AppMethodBeat.i(63959);
                    QrRewardMainUI.this.qyB = bVar.qxA.pqv;
                    QrRewardMainUI.this.qyE = bVar.qxA.Lhq;
                    QrRewardMainUI.this.iconWidth = bVar.qxA.Lhm;
                    QrRewardMainUI.this.desc = bVar.qxA.desc;
                    QrRewardMainUI.this.ega = bVar.qxA.HTZ;
                    QrRewardMainUI.this.mIsOpen = !bVar.qxA.Lhk;
                    QrRewardMainUI.this.qyC = bVar.qxA.pTK;
                    QrRewardMainUI.this.qyD = bVar.qxA.Lho;
                    QrRewardMainUI.this.qyG = true;
                    QrRewardMainUI.i(QrRewardMainUI.this);
                    if (!QrRewardMainUI.this.mIsOpen) {
                        QrRewardMainUI.k(QrRewardMainUI.this);
                    } else {
                        QrRewardMainUI.a(QrRewardMainUI.this, bVar.qxA.Cog, bVar.qxA.Lhl);
                        QrRewardMainUI.l(QrRewardMainUI.this);
                        QrRewardMainUI.m(QrRewardMainUI.this);
                    }
                    QrRewardMainUI.this.lRD = bVar.qxA.Cog;
                    QrRewardMainUI.cAe();
                    Log.d("MicroMsg.QrRewardMainUI", "url: %s", QrRewardMainUI.this.lRD);
                    AppMethodBeat.o(63959);
                }
            }).b(new a.AbstractC0930a() {
                /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass15 */

                @Override // com.tencent.mm.plugin.collect.reward.a.a.AbstractC0930a
                public final void g(com.tencent.mm.ak.q qVar) {
                    boolean z = true;
                    AppMethodBeat.i(63958);
                    Log.e("MicroMsg.QrRewardMainUI", "get code error: %s, %s", Integer.valueOf(bVar.qxA.dDN), bVar.qxA.qwn);
                    if (bVar.qxA.dDN == 416) {
                        Object[] objArr = new Object[1];
                        if (bVar.qxA.LgT != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        Log.d("MicroMsg.QrRewardMainUI", "realNameInfo:%s", objArr);
                        QrRewardMainUI.this.qyo.setVisibility(4);
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".reward.ui.CollectMainUI");
                        bundle.putString("realname_verify_process_jump_plugin", "collect");
                        QrRewardMainUI qrRewardMainUI = QrRewardMainUI.this;
                        int i2 = bVar.qxA.dDN;
                        dju dju = bVar.qxA.LgT;
                        new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass15.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(63957);
                                Log.i("MicroMsg.QrRewardMainUI", "RealnameVerifyUtil cancel");
                                AppMethodBeat.o(63957);
                            }
                        };
                        com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(qrRewardMainUI, i2, dju, bundle, 1011);
                        AppMethodBeat.o(63958);
                        return;
                    }
                    if (!Util.isNullOrNil(bVar.qxA.qwn)) {
                        Toast.makeText(QrRewardMainUI.this, bVar.qxA.qwn, 0).show();
                    }
                    if (!bVar.qxB) {
                        QrRewardMainUI.b(QrRewardMainUI.this, false);
                    }
                    AppMethodBeat.o(63958);
                }
            }).c(new a.AbstractC0930a() {
                /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass14 */

                @Override // com.tencent.mm.plugin.collect.reward.a.a.AbstractC0930a
                public final void g(com.tencent.mm.ak.q qVar) {
                    AppMethodBeat.i(63956);
                    Log.e("MicroMsg.QrRewardMainUI", "net error: %s", qVar);
                    if (!bVar.qxB) {
                        QrRewardMainUI.b(QrRewardMainUI.this, false);
                    }
                    AppMethodBeat.o(63956);
                }
            });
            AppMethodBeat.o(63964);
        } else {
            if (qVar instanceof com.tencent.mm.plugin.collect.reward.a.h) {
                final com.tencent.mm.plugin.collect.reward.a.h hVar = (com.tencent.mm.plugin.collect.reward.a.h) qVar;
                hVar.a(new a.AbstractC0930a() {
                    /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.collect.reward.a.a.AbstractC0930a
                    public final void g(com.tencent.mm.ak.q qVar) {
                        AppMethodBeat.i(63944);
                        Log.i("MicroMsg.QrRewardMainUI", "set succ: %s, %s", hVar.pqv, QrRewardMainUI.this.qyw.getText());
                        if (hVar.pqv.equals(QrRewardMainUI.this.qyB)) {
                            g.aAh().azQ().set(ar.a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, QrRewardMainUI.this.qyB);
                            QrRewardMainUI.m(QrRewardMainUI.this);
                        }
                        AppMethodBeat.o(63944);
                    }
                }).b(new a.AbstractC0930a() {
                    /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.collect.reward.a.a.AbstractC0930a
                    public final void g(com.tencent.mm.ak.q qVar) {
                        AppMethodBeat.i(63943);
                        Log.e("MicroMsg.QrRewardMainUI", "set word error: %s, %s", Integer.valueOf(hVar.qxH.dDN), hVar.qxH.qwn);
                        QrRewardMainUI.this.qyB = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, "");
                        QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.o(QrRewardMainUI.this));
                        QrRewardMainUI.this.qyw.setText("");
                        QrRewardMainUI.m(QrRewardMainUI.this);
                        if (!Util.isNullOrNil(hVar.qxH.qwn)) {
                            Toast.makeText(QrRewardMainUI.this, hVar.qxH.qwn, 0).show();
                        }
                        AppMethodBeat.o(63943);
                    }
                }).c(new a.AbstractC0930a() {
                    /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass17 */

                    @Override // com.tencent.mm.plugin.collect.reward.a.a.AbstractC0930a
                    public final void g(com.tencent.mm.ak.q qVar) {
                        AppMethodBeat.i(63960);
                        Log.e("MicroMsg.QrRewardMainUI", "net error: %s", qVar);
                        QrRewardMainUI.this.qyB = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, "");
                        QrRewardMainUI.a(QrRewardMainUI.this, QrRewardMainUI.o(QrRewardMainUI.this));
                        QrRewardMainUI.this.qyw.setText("");
                        QrRewardMainUI.m(QrRewardMainUI.this);
                        AppMethodBeat.o(63960);
                    }
                });
                this.qyw.clearFocus();
                this.qyw.setCursorVisible(false);
            }
            AppMethodBeat.o(63964);
        }
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onKeyboardStateChanged() {
        AppMethodBeat.i(63965);
        super.onKeyboardStateChanged();
        Log.i("MicroMsg.QrRewardMainUI", "key board changed: %s", Integer.valueOf(keyboardState()));
        if (keyboardState() == 2) {
            this.qyB = this.qyw.getText().toString();
            cAd();
            if (Util.isNullOrNil(this.qyB)) {
                kO(true);
            }
        }
        AppMethodBeat.o(63965);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(63966);
        if (i2 != 1) {
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == -1) {
            this.desc = intent.getStringExtra("key_desc");
            this.qyE = intent.getIntExtra("key_photo_width", TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
            this.iconWidth = intent.getIntExtra("key_icon_width", aa.CTRL_INDEX);
            boolean booleanExtra = intent.getBooleanExtra("key_return_from_first", true);
            Log.i("MicroMsg.QrRewardMainUI", "return from first: %s", Boolean.valueOf(booleanExtra));
            if (booleanExtra) {
                this.qyr.setVisibility(0);
                this.qyq.setVisibility(8);
            }
            this.qyG = true;
            cAa();
            String stringExtra = intent.getStringExtra("key_photo_url");
            n(stringExtra, intent.getStringExtra("key_photo_aeskey"), true);
            this.lRD = stringExtra;
            AppMethodBeat.o(63966);
            return;
        }
        AppMethodBeat.o(63966);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bk6;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(63967);
        super.onDestroy();
        removeSceneEndListener(1323);
        removeSceneEndListener(1649);
        com.tencent.mm.plugin.collect.reward.b.a czR = com.tencent.mm.plugin.collect.reward.b.a.czR();
        Log.d("MicroMsg.QrRewardCdnDownloadHelper", "do clear callback");
        if (czR.oPn != null) {
            Log.i("MicroMsg.QrRewardCdnDownloadHelper", "callback size: %s", Integer.valueOf(czR.oPn.size()));
            czR.oPn.clear();
        }
        AppMethodBeat.o(63967);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needExecuteBackListener() {
        return false;
    }

    private void n(String str, String str2, boolean z) {
        AppMethodBeat.i(63968);
        boolean z2 = this.lRD != null && this.lRD.equals(str);
        boolean czS = com.tencent.mm.plugin.collect.reward.b.a.czR().czS();
        Log.i("MicroMsg.QrRewardMainUI", "do download photo: %s, same url: %s, pic exist: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(czS));
        if (z || !z2 || !czS) {
            com.tencent.mm.plugin.collect.reward.b.a.czR().a(str, str2, new a.AbstractC0931a() {
                /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass6 */

                @Override // com.tencent.mm.plugin.collect.reward.b.a.AbstractC0931a
                public final void Y(String str, int i2, int i3) {
                    AppMethodBeat.i(63948);
                    Log.i("MicroMsg.QrRewardMainUI", "callback ret: %s, %s, %s", str, Integer.valueOf(i2), Integer.valueOf(i3));
                    if (i2 == 0 && i3 == 0) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass6.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(63947);
                                QrRewardMainUI.q(QrRewardMainUI.this);
                                AppMethodBeat.o(63947);
                            }
                        });
                    }
                    AppMethodBeat.o(63948);
                }
            });
        }
        AppMethodBeat.o(63968);
    }

    private void czX() {
        AppMethodBeat.i(63969);
        if (com.tencent.mm.plugin.collect.reward.b.a.czR().czS()) {
            this.qyt.aM(com.tencent.mm.plugin.collect.reward.b.a.czR().czU(), this.qyn, this.qyn);
            this.qys.setVisibility(0);
            AppMethodBeat.o(63969);
            return;
        }
        this.qys.setVisibility(4);
        AppMethodBeat.o(63969);
    }

    private void czY() {
        AppMethodBeat.i(63970);
        int round = Math.round(((float) this.qyn) * ((((float) this.iconWidth) * 1.0f) / ((float) this.qyE)));
        if (round <= 0) {
            round = 248;
        }
        ViewGroup.LayoutParams layoutParams = this.qyv.getLayoutParams();
        layoutParams.width = round;
        layoutParams.height = round;
        this.qyv.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.qyu.getLayoutParams();
        layoutParams2.width = round;
        layoutParams2.height = round;
        this.qyu.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.qyw.getLayoutParams();
        layoutParams3.width = round - 30;
        layoutParams3.height = round - 30;
        this.qyw.setLayoutParams(layoutParams3);
        this.qyw.setTextSize(0, (float) ((round * 2) / 3));
        this.qyr.requestLayout();
        AppMethodBeat.o(63970);
    }

    private void czZ() {
        AppMethodBeat.i(63971);
        if (!Util.isNullOrNil(this.desc)) {
            this.jVn.setText(l.b(this, getString(R.string.fs9, new Object[]{this.desc}), this.jVn.getTextSize()));
            AppMethodBeat.o(63971);
            return;
        }
        this.jVn.setText("");
        AppMethodBeat.o(63971);
    }

    private void cAa() {
        AppMethodBeat.i(63972);
        czY();
        czZ();
        kO(Util.isNullOrNil(this.qyB));
        AppMethodBeat.o(63972);
    }

    private void cAb() {
        AppMethodBeat.i(63973);
        if (!Util.isNullOrNil(this.qyC)) {
            this.qyy.setClickable(true);
            this.qyy.setOnTouchListener(new o(this));
            q qVar = new q(new q.a() {
                /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass7 */

                @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                public final void dF(View view) {
                    AppMethodBeat.i(63949);
                    Log.d("MicroMsg.QrRewardMainUI", "go to: %s", QrRewardMainUI.this.qyD);
                    f.o(QrRewardMainUI.this.getContext(), QrRewardMainUI.this.qyD, false);
                    h.INSTANCE.a(14721, 1, 6);
                    AppMethodBeat.o(63949);
                }
            });
            SpannableString spannableString = new SpannableString(this.qyC);
            spannableString.setSpan(qVar, 0, spannableString.length(), 18);
            this.qyy.setText(spannableString);
            this.qyy.setVisibility(0);
            AppMethodBeat.o(63973);
            return;
        }
        this.qyy.setVisibility(8);
        AppMethodBeat.o(63973);
    }

    private void kO(boolean z) {
        AppMethodBeat.i(63974);
        Log.i("MicroMsg.QrRewardMainUI", "switch mode: %s", Boolean.valueOf(z));
        if (z) {
            this.qyu.setVisibility(0);
            this.qyw.setVisibility(4);
            a.b.a(this.qyu, this.username, 0.03f, true);
            AppMethodBeat.o(63974);
            return;
        }
        this.qyu.setVisibility(4);
        this.qyw.setVisibility(0);
        AppMethodBeat.o(63974);
    }

    private void cAd() {
        AppMethodBeat.i(63976);
        Log.i("MicroMsg.QrRewardMainUI", "do set photo word");
        com.tencent.mm.plugin.collect.reward.a.h hVar = new com.tencent.mm.plugin.collect.reward.a.h(this.qyB);
        hVar.M(this);
        doSceneProgress(hVar, true);
        AppMethodBeat.o(63976);
    }

    private void cAc() {
        AppMethodBeat.i(63975);
        if (!Util.isNullOrNil(this.qyB)) {
            this.qyw.setText(l.b(getContext(), this.qyB, this.qyw.getTextSize()));
            this.qyw.setSelection(this.qyB.length());
        }
        AppMethodBeat.o(63975);
    }

    static /* synthetic */ void d(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(63979);
        e eVar = new e((Context) qrRewardMainUI, 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(63945);
                mVar.a(1, QrRewardMainUI.this.getString(R.string.frt), QrRewardMainUI.o(QrRewardMainUI.this) ? QrRewardMainUI.this.getString(R.string.frz) : "", 0);
                mVar.a(2, QrRewardMainUI.this.getString(R.string.fru), !QrRewardMainUI.o(QrRewardMainUI.this) ? QrRewardMainUI.this.getString(R.string.frz) : "", 0);
                AppMethodBeat.o(63945);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(63946);
                switch (menuItem.getItemId()) {
                    case 1:
                        QrRewardMainUI.this.qyB = "";
                        QrRewardMainUI.b(QrRewardMainUI.this);
                        QrRewardMainUI.a(QrRewardMainUI.this, true);
                        h.INSTANCE.a(14721, 1, 3);
                        AppMethodBeat.o(63946);
                        return;
                    case 2:
                        QrRewardMainUI.a(QrRewardMainUI.this, false);
                        QrRewardMainUI.p(QrRewardMainUI.this);
                        h.INSTANCE.a(14721, 1, 4);
                        AppMethodBeat.o(63946);
                        return;
                    default:
                        Log.i("MicroMsg.QrRewardMainUI", "unknown menu: %s", Integer.valueOf(menuItem.getItemId()));
                        QrRewardMainUI.a(QrRewardMainUI.this, true);
                        AppMethodBeat.o(63946);
                        return;
                }
            }
        };
        eVar.dGm();
        AppMethodBeat.o(63979);
    }

    static /* synthetic */ void e(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(63980);
        if (!qrRewardMainUI.qyF) {
            qrRewardMainUI.qyA = (ScrollView) ((ViewStub) qrRewardMainUI.findViewById(R.id.gp6)).inflate();
            TextView textView = (TextView) qrRewardMainUI.qyA.findViewById(R.id.gpb);
            textView.setText(l.b(qrRewardMainUI, qrRewardMainUI.getString(R.string.fry, new Object[]{f.hs(f.getDisplayName(qrRewardMainUI.username), 10)}), textView.getTextSize()));
            qrRewardMainUI.qyF = true;
        }
        final ImageView imageView = (ImageView) qrRewardMainUI.qyA.findViewById(R.id.gp9);
        final ViewGroup viewGroup = (ViewGroup) qrRewardMainUI.qyA.findViewById(R.id.gpr);
        if (!Util.isNullOrNil(qrRewardMainUI.desc)) {
            ((TextView) qrRewardMainUI.qyA.findViewById(R.id.gpa)).setText(l.b(qrRewardMainUI, qrRewardMainUI.getString(R.string.fs9, new Object[]{qrRewardMainUI.desc}), qrRewardMainUI.jVn.getTextSize()));
        }
        qrRewardMainUI.qyA.setVisibility(4);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(63950);
                Log.d("MicroMsg.QrRewardMainUI", "height: %d, width: %d", Integer.valueOf(viewGroup.getHeight()), Integer.valueOf(viewGroup.getWidth()));
                Bitmap createBitmap = Bitmap.createBitmap(QrRewardMainUI.this.qys.getWidth(), QrRewardMainUI.this.qys.getHeight(), Bitmap.Config.ARGB_8888);
                QrRewardMainUI.this.qys.draw(new Canvas(createBitmap));
                imageView.setImageBitmap(createBitmap);
                Bitmap createBitmap2 = Bitmap.createBitmap(viewGroup.getWidth(), viewGroup.getHeight(), Bitmap.Config.ARGB_8888);
                viewGroup.draw(new Canvas(createBitmap2));
                try {
                    String str = s.getSysCameraDirPath() + "mm_reward_qrcode_" + System.currentTimeMillis() + ".png";
                    BitmapUtil.saveBitmapToImage(createBitmap2, 100, Bitmap.CompressFormat.PNG, AndroidMediaUtil.getFriendlySdcardPath(str), false);
                    Toast.makeText(QrRewardMainUI.this.getContext(), QrRewardMainUI.this.getString(R.string.bjr, new Object[]{str}), 1).show();
                    s.refreshMediaScanner(str, QrRewardMainUI.this.getContext());
                } catch (Exception e2) {
                    Log.w("MicroMsg.QrRewardMainUI", "save fixed amount qrcode failed!" + e2.getMessage());
                }
                QrRewardMainUI.this.qyA.setVisibility(8);
                Log.i("MicroMsg.QrRewardMainUI", "bitmap recycle %s", createBitmap2.toString());
                createBitmap2.recycle();
                AppMethodBeat.o(63950);
            }
        }, 250);
        AppMethodBeat.o(63980);
    }

    static /* synthetic */ void b(QrRewardMainUI qrRewardMainUI, boolean z) {
        AppMethodBeat.i(63981);
        Log.i("MicroMsg.QrRewardMainUI", "goto set money");
        Intent intent = new Intent(qrRewardMainUI.getContext(), QrRewardSetMoneyUI.class);
        intent.putExtra("key_first_flag", z);
        if (!Util.isNullOrNil(qrRewardMainUI.desc)) {
            intent.putExtra("key_desc_word", qrRewardMainUI.desc);
        }
        qrRewardMainUI.startActivityForResult(intent, 1);
        AppMethodBeat.o(63981);
    }

    static /* synthetic */ void k(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(63983);
        Log.i("MicroMsg.QrRewardMainUI", "show first guide view");
        qrRewardMainUI.qyr.setVisibility(8);
        qrRewardMainUI.qyq.setVisibility(0);
        qrRewardMainUI.qyp.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(63951);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/reward/ui/QrRewardMainUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.QrRewardMainUI", "open click");
                QrRewardMainUI.b(QrRewardMainUI.this, true);
                h.INSTANCE.a(14721, 1, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardMainUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(63951);
            }
        });
        AppMethodBeat.o(63983);
    }

    static /* synthetic */ boolean o(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(63987);
        boolean isNullOrNil = Util.isNullOrNil(qrRewardMainUI.qyB);
        AppMethodBeat.o(63987);
        return isNullOrNil;
    }

    static /* synthetic */ void p(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(63988);
        qrRewardMainUI.qyw.setCursorVisible(true);
        qrRewardMainUI.qyw.requestFocus();
        qrRewardMainUI.qyw.requestFocusFromTouch();
        qrRewardMainUI.showVKB();
        AppMethodBeat.o(63988);
    }
}
