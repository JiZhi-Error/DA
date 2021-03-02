package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.reward.a.a;
import com.tencent.mm.plugin.collect.reward.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QrRewardSetMoneyUI extends QrRewardBaseUI {
    private String desc;
    private String lRD;
    private TextView mPa;
    private int qyg;
    private ImageView qyu;
    private MMGridView qzf;
    private Button qzg;
    private MMEditText qzh;
    private TextView qzi;
    private TextView qzj;
    private SparseArray<WalletFormView> qzk;
    private List<Integer> qzl;
    private List<Integer> qzm;
    private boolean qzn = false;
    private Runnable qzo = new Runnable() {
        /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.AnonymousClass5 */

        public final void run() {
            AppMethodBeat.i(64014);
            QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this);
            AppMethodBeat.o(64014);
        }
    };
    private TextWatcher qzp = new TextWatcher() {
        /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.AnonymousClass6 */

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(64015);
            if (editable.toString().startsWith(".")) {
                editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            String obj = editable.toString();
            int indexOf = obj.indexOf(".");
            int length = obj.length();
            if (indexOf >= 0 && length - indexOf > 3) {
                editable.delete(indexOf + 3, length);
            } else if (indexOf > 6) {
                editable.delete(6, indexOf);
            } else if (indexOf == -1 && length > 6) {
                editable.delete(6, length);
            }
            MMHandlerThread.removeRunnable(QrRewardSetMoneyUI.this.qzo);
            MMHandlerThread.postToMainThreadDelayed(QrRewardSetMoneyUI.this.qzo, 50);
            AppMethodBeat.o(64015);
        }
    };

    @Override // com.tencent.mm.plugin.collect.reward.ui.QrRewardBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public QrRewardSetMoneyUI() {
        AppMethodBeat.i(64019);
        AppMethodBeat.o(64019);
    }

    @Override // com.tencent.mm.plugin.collect.reward.ui.QrRewardBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64020);
        super.onCreate(bundle);
        setMMTitle(R.string.fs7);
        addSceneEndListener(1562);
        List<String> stringToList = Util.stringToList((String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_QR_REWARD_AMT_LIST_STRING_SYNC, ""), ",");
        this.qzl = new ArrayList();
        if (stringToList.isEmpty()) {
            Log.i("MicroMsg.QrRewardSetMoneyUI", "use client hardcode amt list");
            this.qzl = Arrays.asList(b.qxL);
        } else {
            for (String str : stringToList) {
                this.qzl.add(Integer.valueOf(Util.getInt(str, 0)));
            }
        }
        this.qzm = new ArrayList(this.qzl);
        this.qyg = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_QR_REWARD_MAX_AMT_INT_SYNC, Integer.valueOf((int) com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT))).intValue();
        this.qzn = getIntent().getBooleanExtra("key_first_flag", false);
        this.desc = getIntent().getStringExtra("key_desc_word");
        this.qzk = new SparseArray<>();
        cAg();
        initView();
        AppMethodBeat.o(64020);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64021);
        this.qzf = (MMGridView) findViewById(R.id.gpo);
        this.qzg = (Button) findViewById(R.id.gpn);
        this.qzi = (TextView) findViewById(R.id.gpk);
        this.qyu = (ImageView) findViewById(R.id.gpl);
        this.qzh = (MMEditText) findViewById(R.id.gpp);
        this.mPa = (TextView) findViewById(R.id.gpq);
        this.qzj = (TextView) findViewById(R.id.gpm);
        String aUa = z.aUa();
        if (Util.isNullOrNil(aUa)) {
            aUa = z.aUb();
        }
        this.mPa.setText(l.c(getContext(), aUa));
        a.b.a(this.qyu, z.aTY(), 0.06f, false);
        this.qzf.setAdapter((ListAdapter) new a(this, (byte) 0));
        if (!Util.isNullOrNil(this.desc)) {
            this.qzh.setText(l.b(this, this.desc, this.qzh.getTextSize()));
        }
        this.qzi.setText(getString(R.string.fs4, new Object[]{new StringBuilder().append(Math.round(((float) this.qyg) / 100.0f)).toString()}));
        if (this.qzn) {
            this.qzg.setText(R.string.frl);
            this.qzj.setVisibility(8);
        }
        this.qzg.setOnClickListener(new x() {
            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.x
            public final void czW() {
                AppMethodBeat.i(64010);
                if (!QrRewardSetMoneyUI.a(QrRewardSetMoneyUI.this)) {
                    QrRewardSetMoneyUI.b(QrRewardSetMoneyUI.this);
                } else {
                    Log.i("MicroMsg.QrRewardSetMoneyUI", "amt error!");
                }
                h.INSTANCE.a(14721, 1, 2);
                AppMethodBeat.o(64010);
            }
        });
        AppMethodBeat.o(64021);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bkb;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64022);
        super.onDestroy();
        removeSceneEndListener(1562);
        MMHandlerThread.removeRunnable(this.qzo);
        AppMethodBeat.o(64022);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64023);
        if (qVar instanceof com.tencent.mm.plugin.collect.reward.a.g) {
            final com.tencent.mm.plugin.collect.reward.a.g gVar = (com.tencent.mm.plugin.collect.reward.a.g) qVar;
            gVar.a(new a.AbstractC0930a() {
                /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.collect.reward.a.a.AbstractC0930a
                public final void g(q qVar) {
                    AppMethodBeat.i(64013);
                    QrRewardSetMoneyUI.this.lRD = gVar.qxG.Cog;
                    QrRewardSetMoneyUI.this.desc = gVar.qxG.desc;
                    Intent intent = new Intent();
                    intent.putExtra("key_desc", gVar.qxG.desc);
                    intent.putExtra("key_photo_url", gVar.qxG.Cog);
                    intent.putExtra("key_photo_aeskey", gVar.qxG.Lhl);
                    intent.putExtra("key_photo_width", gVar.qxG.Lhq);
                    intent.putExtra("key_icon_width", gVar.qxG.Lhm);
                    intent.putExtra("key_return_from_first", QrRewardSetMoneyUI.this.qzn);
                    QrRewardSetMoneyUI.this.setResult(-1, intent);
                    QrRewardSetMoneyUI.this.finish();
                    AppMethodBeat.o(64013);
                }
            }).b(new a.AbstractC0930a() {
                /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.collect.reward.a.a.AbstractC0930a
                public final void g(q qVar) {
                    AppMethodBeat.i(64012);
                    Log.e("MicroMsg.QrRewardSetMoneyUI", "set code error: %s, %s", Integer.valueOf(gVar.qxG.dDN), gVar.qxG.qwn);
                    if (!Util.isNullOrNil(gVar.qxG.qwn)) {
                        Toast.makeText(QrRewardSetMoneyUI.this, gVar.qxG.qwn, 1).show();
                        AppMethodBeat.o(64012);
                        return;
                    }
                    Toast.makeText(QrRewardSetMoneyUI.this, (int) R.string.fs2, 1).show();
                    AppMethodBeat.o(64012);
                }
            }).c(new a.AbstractC0930a() {
                /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.collect.reward.a.a.AbstractC0930a
                public final void g(q qVar) {
                    AppMethodBeat.i(64011);
                    Log.e("MicroMsg.QrRewardSetMoneyUI", "net error: %s", qVar);
                    AppMethodBeat.o(64011);
                }
            });
        }
        AppMethodBeat.o(64023);
        return false;
    }

    private boolean cAf() {
        AppMethodBeat.i(64024);
        for (int i2 = 0; i2 < this.qzl.size(); i2++) {
            if (!this.qzl.get(i2).equals(this.qzm.get(i2))) {
                Log.i("MicroMsg.QrRewardSetMoneyUI", "modify money: %s, %s", this.qzl.get(i2), this.qzm.get(i2));
                AppMethodBeat.o(64024);
                return true;
            }
        }
        AppMethodBeat.o(64024);
        return false;
    }

    private void cAg() {
        AppMethodBeat.i(64025);
        for (int i2 = 0; i2 < this.qzm.size(); i2++) {
            WalletFormView walletFormView = (WalletFormView) LayoutInflater.from(getContext()).inflate(R.layout.bk_, (ViewGroup) null);
            walletFormView.a(this.qzp);
            int intValue = this.qzm.get(i2).intValue();
            int i3 = intValue / 100;
            double d2 = ((double) intValue) / 100.0d;
            if (d2 > ((double) i3)) {
                walletFormView.setText(String.format("%.2f", Double.valueOf(d2)));
            } else {
                walletFormView.setText(String.format("%d", Integer.valueOf(i3)));
            }
            setEditFocusListener(walletFormView, 2, false);
            this.qzk.put(i2, walletFormView);
        }
        AppMethodBeat.o(64025);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(QrRewardSetMoneyUI qrRewardSetMoneyUI, byte b2) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(64016);
            int size = QrRewardSetMoneyUI.this.qzm.size();
            AppMethodBeat.o(64016);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(64017);
            Object obj = QrRewardSetMoneyUI.this.qzm.get(i2);
            AppMethodBeat.o(64017);
            return obj;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            View view2;
            AppMethodBeat.i(64018);
            if (view == null) {
                view2 = (View) QrRewardSetMoneyUI.this.qzk.get(i2);
            } else {
                view2 = view;
            }
            AppMethodBeat.o(64018);
            return view2;
        }
    }

    static /* synthetic */ boolean a(QrRewardSetMoneyUI qrRewardSetMoneyUI) {
        AppMethodBeat.i(64026);
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < qrRewardSetMoneyUI.qzk.size(); i2++) {
            WalletFormView walletFormView = qrRewardSetMoneyUI.qzk.get(i2);
            int round = (int) Math.round(Util.getDouble(walletFormView.getText(), 0.0d) * 100.0d);
            qrRewardSetMoneyUI.qzm.set(i2, Integer.valueOf(round));
            if (round > qrRewardSetMoneyUI.qyg) {
                walletFormView.setContentTextColorRes(R.color.a3);
                z2 = true;
            } else {
                if (round <= 0) {
                    z = true;
                }
                walletFormView.setContentTextColorRes(R.color.a2x);
            }
        }
        if (z2) {
            if (!qrRewardSetMoneyUI.qzi.isShown()) {
                qrRewardSetMoneyUI.qzi.startAnimation(AnimationUtils.loadAnimation(qrRewardSetMoneyUI, R.anim.cc));
                qrRewardSetMoneyUI.qzi.setVisibility(0);
            }
            qrRewardSetMoneyUI.qzg.setEnabled(false);
        } else if (z) {
            qrRewardSetMoneyUI.qzg.setEnabled(false);
        } else {
            if (qrRewardSetMoneyUI.qzi.isShown()) {
                qrRewardSetMoneyUI.qzi.startAnimation(AnimationUtils.loadAnimation(qrRewardSetMoneyUI, R.anim.d5));
                qrRewardSetMoneyUI.qzi.setVisibility(8);
            }
            qrRewardSetMoneyUI.qzg.setEnabled(true);
        }
        AppMethodBeat.o(64026);
        return z2;
    }

    static /* synthetic */ void b(QrRewardSetMoneyUI qrRewardSetMoneyUI) {
        AppMethodBeat.i(64027);
        Log.i("MicroMsg.QrRewardSetMoneyUI", "do set code");
        com.tencent.mm.plugin.collect.reward.a.g gVar = new com.tencent.mm.plugin.collect.reward.a.g(new LinkedList(qrRewardSetMoneyUI.qzm), qrRewardSetMoneyUI.qzh.getText().toString().replace("\n", ""), qrRewardSetMoneyUI.qzn, qrRewardSetMoneyUI.cAf());
        gVar.M(qrRewardSetMoneyUI);
        qrRewardSetMoneyUI.doSceneProgress(gVar, true);
        AppMethodBeat.o(64027);
    }
}
