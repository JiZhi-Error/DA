package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.h.h;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.cedit.api.c;
import com.tencent.mm.ui.widget.cedit.api.d;
import com.tencent.mm.ui.widget.edittext.a;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;

@a(17)
public class SnsCommentUI extends MMActivity implements i {
    SnsInfo DqO;
    private c EDk;
    private boolean EDl = false;
    private boolean EDm = false;
    private int dJN;
    private int ecf;
    private q tipDialog = null;
    private int vOR = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98682);
        super.onCreate(bundle);
        this.ecf = getIntent().getIntExtra("sns_comment_localId", 0);
        this.vOR = getIntent().getIntExtra("sns_comment_type", 0);
        this.dJN = getIntent().getIntExtra("sns_source", 0);
        g.aAi();
        g.aAg().hqi.a(213, this);
        initView();
        AppMethodBeat.o(98682);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(98683);
        super.onPause();
        if (this.EDk != null) {
            String trim = this.EDk.getText().toString().trim();
            g.aAi();
            g.aAh().azQ().set(68408, trim);
            if (!Util.isNullOrNil(trim)) {
                g.aAi();
                g.aAh().azQ().set(7489, Integer.valueOf(this.EDk.getPasterLen()));
            } else {
                g.aAi();
                g.aAh().azQ().set(7489, (Object) 0);
            }
        }
        this.EDk.onPause();
        AppMethodBeat.o(98683);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(98684);
        super.onResume();
        showVKB();
        this.EDk.refresh(((PluginWebSearch) g.ah(PluginWebSearch.class)).isUseSysEditText());
        AppMethodBeat.o(98684);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(98685);
        super.onDestroy();
        g.aAi();
        g.aAg().hqi.b(213, this);
        this.EDk.destroy();
        AppMethodBeat.o(98685);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(98686);
        this.EDk = (c) findViewById(R.id.be9);
        this.EDk.refresh(((PluginWebSearch) g.ah(PluginWebSearch.class)).isUseSysEditText());
        this.EDk.gYJ();
        this.EDk.a(((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseBrands(), ((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseItems(), LocaleUtil.getCurrentLanguage(getContext()), new a.e() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.widget.edittext.a.e
            public final void A(List<a.c> list, int i2) {
                AppMethodBeat.i(203563);
                long aWB = (long) cl.aWB();
                if (!(!((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag() || i2 == 8 || i2 == 1)) {
                    list.add(new a.c(SnsCommentUI.this.getContext().getString(R.string.hk_), 2));
                    if (SnsCommentUI.this.DqO == null) {
                        SnsCommentUI.this.DqO = aj.faO().Zr(SnsCommentUI.this.ecf);
                    }
                    SnsCommentFooter.a(SnsCommentUI.this.getContext(), SnsCommentUI.this.DqO, false, "", 1, "", aWB);
                }
                AppMethodBeat.o(203563);
            }

            @Override // com.tencent.mm.ui.widget.edittext.a.e
            public final void a(View view, a.c cVar, String str) {
                AppMethodBeat.i(203564);
                long aWB = (long) cl.aWB();
                if (cVar.id == 2) {
                    SnsCommentUI.this.EDk.getText().insert(SnsCommentUI.this.EDk.getSelectionStart(), SnsCommentUI.this.getContext().getString(R.string.hk_));
                    SnsCommentFooter.a(SnsCommentUI.this.getContext(), SnsCommentUI.this.DqO, false, "", 2, "", aWB);
                }
                AppMethodBeat.o(203564);
            }
        });
        this.EDk.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentUI.AnonymousClass6 */
            private List<ForegroundColorSpan> EDf = new LinkedList();

            {
                AppMethodBeat.i(203565);
                AppMethodBeat.o(203565);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(203566);
                Editable text = SnsCommentUI.this.EDk.getText();
                for (ForegroundColorSpan foregroundColorSpan : this.EDf) {
                    text.removeSpan(foregroundColorSpan);
                }
                this.EDf.clear();
                String obj = SnsCommentUI.this.EDk.getText().toString();
                if (((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag()) {
                    Matcher matcher = k.a.Krb.matcher(obj);
                    while (matcher.find()) {
                        int start = matcher.start();
                        int end = matcher.end();
                        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(SnsCommentUI.this.getResources().getColor(R.color.Link_100));
                        this.EDf.add(foregroundColorSpan2);
                        text.setSpan(foregroundColorSpan2, start, end, 33);
                    }
                }
                AppMethodBeat.o(203566);
            }
        });
        addTextOptionMenu(0, getString(R.string.yq), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int aqj;
                AppMethodBeat.i(98679);
                if (SnsCommentUI.this.vOR == 0) {
                    com.tencent.mm.n.c.aqk();
                }
                if (SnsCommentUI.this.vOR == 2) {
                    aqj = 200;
                } else {
                    aqj = com.tencent.mm.n.c.aqj();
                }
                d.a(SnsCommentUI.this.EDk).aoq(aqj).CN(true).a(new c.a() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsCommentUI.AnonymousClass2.AnonymousClass1 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.tools.b.c.a
                    public final void Tw(String str) {
                        AppMethodBeat.i(98677);
                        String trim = SnsCommentUI.this.EDk.getText().toString().trim();
                        SnsCommentUI.this.EDk.setText("");
                        if (trim.length() > 0) {
                            switch (SnsCommentUI.this.vOR) {
                                case 0:
                                    SnsCommentUI.this.hideVKB();
                                    SnsCommentUI.a(SnsCommentUI.this, trim);
                                    AppMethodBeat.o(98677);
                                    return;
                                case 1:
                                    SnsCommentUI.this.hideVKB();
                                    SnsCommentUI.b(SnsCommentUI.this, trim);
                                    AppMethodBeat.o(98677);
                                    return;
                                case 2:
                                    SnsCommentUI.this.hideVKB();
                                    long longExtra = SnsCommentUI.this.getIntent().getLongExtra("sns_id", 0);
                                    long longExtra2 = SnsCommentUI.this.getIntent().getLongExtra("action_st_time", 0);
                                    String nullAs = Util.nullAs(SnsCommentUI.this.getIntent().getStringExtra("sns_uxinfo"), "");
                                    String str2 = Util.nullAs(SnsCommentUI.this.getIntent().getStringExtra("sns_actionresult"), "") + "|4:1:" + trim;
                                    long currentTimeMillis = System.currentTimeMillis();
                                    h fcp = aj.faG().fcp();
                                    if (fcp != null && fcp.fcq()) {
                                        String str3 = fcp.DQT;
                                        String str4 = fcp.DQS;
                                        Log.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + nullAs + " actionresult: " + str2 + " " + longExtra2 + " " + currentTimeMillis);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11988, str3, str4, "", "", r.Jb(longExtra), nullAs, str2, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000));
                                        SnsCommentUI.this.EDm = true;
                                        SnsCommentUI.this.finish();
                                        break;
                                    } else {
                                        AppMethodBeat.o(98677);
                                        return;
                                    }
                                    break;
                            }
                        }
                        AppMethodBeat.o(98677);
                    }

                    @Override // com.tencent.mm.ui.tools.b.c.a
                    public final void Tx(String str) {
                    }

                    @Override // com.tencent.mm.ui.tools.b.c.a
                    public final void dv(String str) {
                        AppMethodBeat.i(163119);
                        com.tencent.mm.ui.base.h.n(SnsCommentUI.this, R.string.hc2, R.string.hc3);
                        AppMethodBeat.o(163119);
                    }
                });
                AppMethodBeat.o(98679);
                return false;
            }
        }, null, t.b.GREEN);
        if (this.vOR == 0) {
            setMMTitle(R.string.h5j);
        } else if (this.vOR == 1) {
            setMMTitle(R.string.hcb);
            g.aAi();
            String nullAs = Util.nullAs((String) g.aAh().azQ().get(68408, ""), "");
            g.aAi();
            this.EDk.setPasterLen(Util.nullAs((Integer) g.aAh().azQ().get(7489, (Object) 0), 0));
            this.EDk.append(Util.nullAs(nullAs, ""));
            if (nullAs == null || nullAs.length() <= 0) {
                enableOptionMenu(false);
            } else {
                enableOptionMenu(true);
            }
        } else if (this.vOR == 2) {
            setMMTitle(R.string.h33);
            enableOptionMenu(false);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(98680);
                SnsCommentUI.this.hideVKB();
                SnsCommentUI.this.finish();
                AppMethodBeat.o(98680);
                return true;
            }
        });
        this.EDk.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentUI.AnonymousClass4 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(98681);
                if (SnsCommentUI.this.EDk.getText().toString().trim().length() > 0) {
                    SnsCommentUI.this.enableOptionMenu(true);
                    AppMethodBeat.o(98681);
                    return;
                }
                SnsCommentUI.this.enableOptionMenu(false);
                AppMethodBeat.o(98681);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        AppMethodBeat.o(98686);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bvn;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(98687);
        Log.i("MicroMsg.SnsCommentUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " type = " + qVar.getType() + " @" + hashCode());
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        switch (qVar.getType()) {
            case 213:
                if (this.EDl) {
                    finish();
                    break;
                }
                break;
        }
        AppMethodBeat.o(98687);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(98688);
        super.finish();
        if (!this.EDm && this.vOR == 2) {
            long longExtra = getIntent().getLongExtra("sns_id", 0);
            long longExtra2 = getIntent().getLongExtra("action_st_time", 0);
            String nullAs = Util.nullAs(getIntent().getStringExtra("sns_uxinfo"), "");
            String str = Util.nullAs(getIntent().getStringExtra("sns_actionresult"), "") + "|4:0:";
            long currentTimeMillis = System.currentTimeMillis();
            h fcp = aj.faG().fcp();
            if (fcp == null || !fcp.fcq()) {
                AppMethodBeat.o(98688);
                return;
            }
            String str2 = fcp.DQT;
            String str3 = fcp.DQS;
            Log.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + nullAs + " actionresult: " + str + " " + longExtra2 + " " + currentTimeMillis);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11988, str2, str3, "", "", r.Jb(longExtra), nullAs, str, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000));
        }
        AppMethodBeat.o(98688);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(98689);
        if (i2 == 4) {
            hideVKB();
            finish();
            AppMethodBeat.o(98689);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(98689);
        return onKeyDown;
    }

    static /* synthetic */ void a(SnsCommentUI snsCommentUI, String str) {
        AppMethodBeat.i(98690);
        SnsInfo Zr = aj.faO().Zr(snsCommentUI.ecf);
        if (Zr != null) {
            snsCommentUI.EDl = true;
            if (Zr.isExtFlag()) {
                aq.a.a(Zr, 2, str, "", snsCommentUI.dJN);
            } else {
                aq.a.a(Zr.field_userName, 3, str, Zr, snsCommentUI.dJN);
            }
            snsCommentUI.hideVKB();
            snsCommentUI.getString(R.string.zb);
            snsCommentUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) snsCommentUI, snsCommentUI.getString(R.string.ys), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsCommentUI.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            e.DUQ.fcy().eOA = 2;
        }
        AppMethodBeat.o(98690);
    }

    static /* synthetic */ void b(SnsCommentUI snsCommentUI, String str) {
        AppMethodBeat.i(98691);
        if (!snsCommentUI.isFinishing()) {
            z.aTY();
            bf bfVar = new bf(2, snsCommentUI.getContext());
            bfVar.aPw(str);
            if (snsCommentUI.EDk.getPasterLen() > com.tencent.mm.plugin.sns.c.a.DCT) {
                bfVar.YF(2);
            }
            bfVar.commit();
            snsCommentUI.setResult(-1);
            snsCommentUI.finish();
        }
        AppMethodBeat.o(98691);
    }
}
