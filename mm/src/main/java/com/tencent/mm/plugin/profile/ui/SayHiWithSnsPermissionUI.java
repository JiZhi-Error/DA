package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.b.o;
import com.tencent.mm.openim.b.q;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.o.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SayHiWithSnsPermissionUI extends MMActivity implements i {
    private String Azx;
    private MMSwitchBtn BhO;
    private MMSwitchBtn BhP;
    private WeImageView BhQ;
    private WeImageView BhR;
    private boolean BhS = false;
    private boolean BhT = false;
    private EditText Bii;
    private EditText Bij;
    private View Bik;
    private TextView Bil;
    private boolean Bim;
    private boolean Bin;
    private boolean Bio = false;
    private boolean Bip = false;
    private CharSequence Biq = null;
    final boolean[] Bir = {true};
    final boolean[] Bis = {false};
    private int Bit = 0;
    int Biu = 1;
    int Biv = 1;
    private String cgo;
    private String chatroomName;
    private long dUy = System.currentTimeMillis();
    private ProgressDialog gtM = null;
    private int kgm;
    private int[] kmr = new int[8];
    private String nickName;
    int scene = 11;
    private String userName;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SayHiWithSnsPermissionUI() {
        AppMethodBeat.i(27407);
        AppMethodBeat.o(27407);
    }

    static /* synthetic */ void n(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        AppMethodBeat.i(27420);
        sayHiWithSnsPermissionUI.sL(false);
        AppMethodBeat.o(27420);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(27408);
        super.onCreate(bundle);
        setActionbarColor(getContext().getResources().getColor(R.color.afz));
        hideActionbarLine();
        setMMTitle("");
        initView();
        bg.azz().a(30, this);
        bg.azz().a(d.CTRL_INDEX, this);
        bg.azz().a(JsApiGetRecentUsageList.CTRL_INDEX, this);
        AppMethodBeat.o(27408);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bnl;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(27409);
        super.onResume();
        AppMethodBeat.o(27409);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(27410);
        super.onStop();
        AppMethodBeat.o(27410);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(27411);
        bg.azz().b(30, this);
        bg.azz().b(d.CTRL_INDEX, this);
        bg.azz().b(JsApiGetRecentUsageList.CTRL_INDEX, this);
        h.INSTANCE.a(14036, Integer.valueOf(this.kmr[0]), Integer.valueOf(this.kmr[1]), Integer.valueOf(this.kmr[2]), Integer.valueOf(this.kmr[3]), Integer.valueOf(this.kmr[4]), Integer.valueOf(this.kmr[5]), Integer.valueOf(this.kmr[6]), Integer.valueOf(this.kmr[7]), this.userName);
        super.onDestroy();
        removeAllOptionMenu();
        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_ver_usr");
        AppMethodBeat.o(27411);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        boolean z2;
        bn bkv;
        String str;
        as Kn;
        AppMethodBeat.i(27412);
        this.Bim = getIntent().getBooleanExtra("sayhi_with_sns_perm_send_verify", false);
        this.Bin = getIntent().getBooleanExtra("sayhi_with_sns_perm_add_remark", false);
        this.userName = getIntent().getStringExtra("Contact_User");
        this.kgm = getIntent().getIntExtra("Contact_Scene", 9);
        this.chatroomName = getIntent().getStringExtra("room_name");
        this.cgo = getIntent().getStringExtra("Contact_RemarkName");
        this.nickName = getIntent().getStringExtra("Contact_Nick");
        this.Azx = getIntent().getStringExtra("Contact_RoomNickname");
        this.Bik = findViewById(R.id.fin);
        this.Bil = (TextView) findViewById(R.id.fio);
        this.BhS = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("MMSocialBlackListFlag", BuildInfo.DEBUG ? 1 : 0) == 1;
        if (!this.BhS) {
            findViewById(R.id.ihs).setVisibility(8);
        }
        g.aAi();
        as Kn2 = ((l) g.af(l.class)).aSN().Kn(this.userName);
        if (g.aAh().azQ().getInt(ar.a.USERINFO_EXCEED_FRIEND_LIMIT_FLAG_INT_SYNC, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.Bio = z;
        this.BhO = (MMSwitchBtn) findViewById(R.id.g0p).findViewById(R.id.g0t);
        getIntent().getBooleanExtra("sayhi_with_sns_permission", false);
        this.BhO.setCheck(Kn2.arB());
        this.BhQ = (WeImageView) findViewById(R.id.ihp);
        this.BhR = (WeImageView) findViewById(R.id.hzp);
        this.BhP = (MMSwitchBtn) findViewById(R.id.hwu).findViewById(R.id.g10);
        this.BhP.setCheck(aKt(this.userName));
        findViewById(R.id.a_s).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(27392);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SayHiWithSnsPermissionUI.this.hideVKB();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27392);
            }
        });
        int i2 = Kn2.fuA;
        Log.d("MicroMsg.SayHiWithSnsPermissionUI", "sex:%d", Integer.valueOf(i2));
        TextView textView = (TextView) findViewById(R.id.g0u);
        if (i2 == 1) {
            textView.setText(R.string.h99);
        } else if (i2 == 2) {
            textView.setText(R.string.h98);
        }
        TextView textView2 = (TextView) findViewById(R.id.g11);
        if (i2 == 1) {
            textView2.setText(R.string.h59);
        } else if (i2 == 2) {
            textView2.setText(R.string.h58);
        }
        boolean bjp = as.bjp(this.userName);
        this.Bip = bjp;
        if (bjp) {
            findViewById(R.id.ihs).setVisibility(8);
            View findViewById = findViewById(R.id.g0p);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            ((TextView) findViewById(R.id.g0s)).setText(R.string.fqq);
            if (i2 == 1) {
                textView2.setText(R.string.fq1);
            } else if (i2 == 2) {
                textView2.setText(R.string.fpz);
            }
        } else {
            t tVar = t.Vay;
            t.hU(findViewById(R.id.g0s));
            dmp();
        }
        if (this.Bim) {
            this.Bii = (EditText) findViewById(R.id.h_j);
            c.f(this.Bii).aoq(100).a((c.a) null);
            this.Bii.setFilters(com.tencent.mm.pluginsdk.ui.tools.l.KvQ);
            this.Bii.addTextChangedListener(new TextWatcher() {
                /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.AnonymousClass3 */

                public final void afterTextChanged(Editable editable) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    AppMethodBeat.i(27393);
                    if (SayHiWithSnsPermissionUI.this.Bir[0]) {
                        SayHiWithSnsPermissionUI.this.Bir[0] = false;
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIL("ie_ver_usr");
                    }
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIM("ie_ver_usr");
                    AppMethodBeat.o(27393);
                }
            });
            ((LinearLayout) this.Bii.getParent()).setVisibility(0);
            bg.aVF();
            CharSequence charSequence = (String) com.tencent.mm.model.c.azQ().get(294913, (Object) null);
            String aUa = z.aUa();
            if (aUa == null) {
                aUa = "";
            }
            String string = getString(R.string.gki);
            if (string.length() + aUa.length() > 50) {
                str = aUa.substring(0, 50 - string.length());
            } else {
                str = aUa;
            }
            if (!Util.isNullOrNil(this.chatroomName) && (Kn = ((l) g.af(l.class)).aSN().Kn(this.chatroomName)) != null && !Util.isNullOrNil(Kn.field_nickname)) {
                String displayName = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Ke(this.chatroomName).getDisplayName(z.aTY());
                if (Util.isNullOrNil((CharSequence) displayName)) {
                    displayName = str;
                }
                Log.i("MicroMsg.SayHiWithSnsPermissionUI", "chatroomName:%s nick:%s", this.chatroomName, Kn.field_nickname);
                charSequence = com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), getResources().getString(R.string.gkj, Kn.field_nickname, displayName), this.Bii.getTextSize());
                this.Biq = charSequence;
            }
            if (Util.isNullOrNil(this.Biq)) {
                this.Biq = com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), String.format(string, str), this.Bii.getTextSize());
            }
            if (Util.isNullOrNil(charSequence)) {
                this.Bii.setText(this.Biq);
            } else {
                this.Bii.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), charSequence, this.Bii.getTextSize()));
            }
            this.Bii.clearFocus();
        }
        if (this.Bin) {
            this.Bij = (EditText) findViewById(R.id.h_m);
            ((LinearLayout) this.Bij.getParent()).setVisibility(0);
            if (!this.Bim) {
                this.Bij.clearFocus();
            }
            c.f(this.Bij).aoq(100).a((c.a) null);
            this.Bij.setFilters(com.tencent.mm.pluginsdk.ui.tools.l.KvQ);
            if (!this.Bim) {
                ((TextView) findViewById(R.id.ipm)).setText(R.string.fqo);
                this.kmr[0] = 1;
            }
            if (!Util.isNullOrNil(this.cgo)) {
                this.Bij.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), this.cgo, this.Bij.getTextSize()));
                this.kmr[6] = 1;
            } else {
                if (!Util.isNullOrNil(this.nickName)) {
                    this.Bij.setHint(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), this.nickName, this.Bij.getTextSize()));
                    this.Bij.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.AnonymousClass4 */

                        public final void onFocusChange(View view, boolean z) {
                            AppMethodBeat.i(27394);
                            if (z) {
                                if (!Util.isNullOrNil(SayHiWithSnsPermissionUI.this.Bij.getHint()) && Util.isNullOrNil(SayHiWithSnsPermissionUI.this.Bij.getText())) {
                                    SayHiWithSnsPermissionUI.this.Bij.setText(SayHiWithSnsPermissionUI.this.Bij.getHint());
                                    SayHiWithSnsPermissionUI.this.Bij.setHint((CharSequence) null);
                                }
                                SayHiWithSnsPermissionUI.this.Bij.setSelection(SayHiWithSnsPermissionUI.this.Bij.getText().length());
                            }
                            AppMethodBeat.o(27394);
                        }
                    });
                }
                switch (this.kgm) {
                    case 8:
                    case 14:
                        if (!Util.isNullOrNil(this.Azx) && !this.Azx.equals(this.Bij.getText().toString())) {
                            this.Bik.setVisibility(0);
                            this.Bil.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(getString(R.string.bfd, new Object[]{this.Azx})), this.Bil.getTextSize()));
                            m mVar = new m(getString(R.string.j40));
                            mVar.setSpan(new a(this.Azx), 0, mVar.length(), 17);
                            this.Bil.append(" ");
                            this.Bil.append(mVar);
                            this.Bil.setMovementMethod(LinkMovementMethod.getInstance());
                            this.kmr[3] = 2;
                            z2 = true;
                            break;
                        } else {
                            z2 = false;
                            break;
                        }
                    case 9:
                    case 12:
                    default:
                        z2 = false;
                        break;
                    case 10:
                    case 11:
                    case 13:
                        com.tencent.mm.plugin.account.friend.a.a SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(this.userName);
                        if (SR != null && !Util.isNullOrNil(SR.bnK()) && !SR.bnK().equals(this.Bij.getText().toString())) {
                            this.Bik.setVisibility(0);
                            this.Bil.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(getString(R.string.bfe, new Object[]{SR.bnK()})), this.Bil.getTextSize()));
                            m mVar2 = new m(getString(R.string.j40));
                            mVar2.setSpan(new a(SR.bnK()), 0, mVar2.length(), 17);
                            this.Bil.append(" ");
                            this.Bil.append(mVar2);
                            this.Bil.setMovementMethod(LinkMovementMethod.getInstance());
                            this.kmr[3] = 1;
                            z2 = true;
                            break;
                        } else {
                            z2 = false;
                            break;
                        }
                        break;
                }
                if (!this.Bim && !z2 && (bkv = com.tencent.mm.bj.d.bgM().bkv(this.userName)) != null) {
                    com.tencent.mm.pluginsdk.ui.preference.b c2 = com.tencent.mm.pluginsdk.ui.preference.b.c(this, bkv);
                    if (!Util.isNullOrNil(c2.iAq) && !c2.iAq.equals(getString(R.string.ddm))) {
                        String substring = getString(R.string.gki).substring(0, getString(R.string.gki).indexOf("%s"));
                        String str2 = c2.iAq;
                        if (c2.iAq.startsWith(substring)) {
                            str2 = c2.iAq.substring(substring.length());
                        }
                        this.Bik.setVisibility(0);
                        this.Bil.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(getString(R.string.bfg, new Object[]{c2.iAq})), this.Bil.getTextSize()));
                        m mVar3 = new m(getString(R.string.j40));
                        mVar3.setSpan(new a(str2), 0, mVar3.length(), 17);
                        this.Bil.append(" ");
                        this.Bil.append(mVar3);
                        this.Bil.setMovementMethod(LinkMovementMethod.getInstance());
                        this.kmr[3] = 3;
                    }
                }
            }
        }
        String string2 = getString(R.string.yq);
        if (!this.Bim) {
            string2 = getString(R.string.vl);
        }
        final String TN = com.tencent.mm.plugin.normsg.a.c.TN(3);
        addTextOptionMenu(0, string2, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i2;
                AppMethodBeat.i(27399);
                if (SayHiWithSnsPermissionUI.this.gtM == null || !SayHiWithSnsPermissionUI.this.gtM.isShowing()) {
                    if (SayHiWithSnsPermissionUI.this.Bis[0]) {
                        SayHiWithSnsPermissionUI.this.Bis[0] = false;
                    } else {
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aA("ce_ver_usr", "<VerifyUsr>", TN);
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.a("ce_ver_usr", MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 65535));
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIQ("ce_ver_usr");
                    }
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.eW(TN, 3);
                    if (SayHiWithSnsPermissionUI.this.Bim) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(SayHiWithSnsPermissionUI.this.userName);
                        LinkedList linkedList2 = new LinkedList();
                        linkedList2.add(Integer.valueOf(SayHiWithSnsPermissionUI.this.kgm));
                        String f2 = SayHiWithSnsPermissionUI.f(SayHiWithSnsPermissionUI.this);
                        HashMap hashMap = new HashMap();
                        int i3 = 0;
                        if (SayHiWithSnsPermissionUI.this.BhQ.getVisibility() != 0) {
                            if (SayHiWithSnsPermissionUI.this.BhO.QDw) {
                                i3 = 1;
                            }
                            if (SayHiWithSnsPermissionUI.this.BhP.QDw) {
                                i3 |= 2;
                            }
                        }
                        if (SayHiWithSnsPermissionUI.this.BhQ.getVisibility() == 0) {
                            i3 |= 8;
                        }
                        SayHiWithSnsPermissionUI.this.Bit = i3;
                        hashMap.put(SayHiWithSnsPermissionUI.this.userName, Integer.valueOf(i3));
                        Log.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", Integer.valueOf(i3));
                        if (SayHiWithSnsPermissionUI.this.Bip) {
                            final o oVar = new o(SayHiWithSnsPermissionUI.this.userName, f2, SayHiWithSnsPermissionUI.this.getIntent().getStringExtra(e.d.OyT), i3);
                            bg.azz().a(oVar, 0);
                            SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.this;
                            AppCompatActivity context = SayHiWithSnsPermissionUI.this.getContext();
                            SayHiWithSnsPermissionUI.this.getString(R.string.zb);
                            sayHiWithSnsPermissionUI.gtM = com.tencent.mm.ui.base.h.a((Context) context, SayHiWithSnsPermissionUI.this.getString(R.string.gko), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.AnonymousClass5.AnonymousClass1 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(27395);
                                    bg.azz().a(oVar);
                                    AppMethodBeat.o(27395);
                                }
                            });
                        } else {
                            String stringExtra = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_user_name");
                            String stringExtra2 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_nick_name");
                            final aa aaVar = new aa(SayHiWithSnsPermissionUI.this, null);
                            aaVar.content = f2;
                            aaVar.mw(stringExtra, stringExtra2);
                            aaVar.Kgh = hashMap;
                            aaVar.chatroomName = SayHiWithSnsPermissionUI.this.chatroomName;
                            aaVar.z(linkedList, linkedList2);
                            SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI2 = SayHiWithSnsPermissionUI.this;
                            AppCompatActivity context2 = SayHiWithSnsPermissionUI.this.getContext();
                            SayHiWithSnsPermissionUI.this.getString(R.string.zb);
                            sayHiWithSnsPermissionUI2.gtM = com.tencent.mm.ui.base.h.a((Context) context2, SayHiWithSnsPermissionUI.this.getString(R.string.gko), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.AnonymousClass5.AnonymousClass2 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(27396);
                                    aaVar.gpI();
                                    AppMethodBeat.o(27396);
                                }
                            });
                        }
                    } else if (SayHiWithSnsPermissionUI.this.Bin) {
                        String stringExtra3 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("Verify_ticket");
                        int i4 = 0;
                        if (SayHiWithSnsPermissionUI.this.BhQ.getVisibility() != 0) {
                            if (SayHiWithSnsPermissionUI.this.BhO.QDw) {
                                i4 = 1;
                            }
                            if (SayHiWithSnsPermissionUI.this.BhP.QDw) {
                                i4 |= 2;
                            }
                        }
                        if (SayHiWithSnsPermissionUI.this.BhQ.getVisibility() == 0) {
                            i2 = i4 | 8;
                        } else {
                            i2 = i4;
                        }
                        SayHiWithSnsPermissionUI.this.Bit = i2;
                        Log.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", Integer.valueOf(i2));
                        if (SayHiWithSnsPermissionUI.this.Bip) {
                            final q qVar = new q(SayHiWithSnsPermissionUI.this.userName, stringExtra3, i2);
                            bg.azz().a(qVar, 0);
                            SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI3 = SayHiWithSnsPermissionUI.this;
                            AppCompatActivity context3 = SayHiWithSnsPermissionUI.this.getContext();
                            SayHiWithSnsPermissionUI.this.getString(R.string.zb);
                            sayHiWithSnsPermissionUI3.gtM = com.tencent.mm.ui.base.h.a((Context) context3, SayHiWithSnsPermissionUI.this.getString(R.string.bac), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.AnonymousClass5.AnonymousClass3 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(27397);
                                    bg.azz().a(qVar);
                                    AppMethodBeat.o(27397);
                                }
                            });
                        } else {
                            final p pVar = new p(SayHiWithSnsPermissionUI.this.userName, stringExtra3, SayHiWithSnsPermissionUI.this.kgm, SayHiWithSnsPermissionUI.this.chatroomName, i2);
                            bg.azz().a(pVar, 0);
                            SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI4 = SayHiWithSnsPermissionUI.this;
                            AppCompatActivity context4 = SayHiWithSnsPermissionUI.this.getContext();
                            SayHiWithSnsPermissionUI.this.getString(R.string.zb);
                            sayHiWithSnsPermissionUI4.gtM = com.tencent.mm.ui.base.h.a((Context) context4, SayHiWithSnsPermissionUI.this.getString(R.string.bac), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.AnonymousClass5.AnonymousClass4 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(27398);
                                    bg.azz().a(pVar);
                                    AppMethodBeat.o(27398);
                                }
                            });
                        }
                    }
                    long longExtra = SayHiWithSnsPermissionUI.this.getIntent().getLongExtra("key_msg_id", 0);
                    if (com.tencent.mm.plugin.messenger.e.a.Hh(longExtra)) {
                        com.tencent.mm.plugin.messenger.e.a.Q(longExtra, 4);
                    }
                    AppMethodBeat.o(27399);
                    return false;
                }
                AppMethodBeat.o(27399);
                return false;
            }
        }, null, new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.AnonymousClass6 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(27400);
                switch (motionEvent.getAction()) {
                    case 0:
                    case 5:
                        SayHiWithSnsPermissionUI.this.Bis[0] = true;
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aA("ce_ver_usr", "<VerifyUsr>", TN);
                        break;
                    case 1:
                    case 6:
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.a("ce_ver_usr", motionEvent);
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIQ("ce_ver_usr");
                        break;
                }
                AppMethodBeat.o(27400);
                return false;
            }
        }, t.b.GREEN);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(27401);
                if (SayHiWithSnsPermissionUI.this.Bin) {
                    SayHiWithSnsPermissionUI.this.kmr[1] = 1;
                }
                SayHiWithSnsPermissionUI.this.finish();
                SayHiWithSnsPermissionUI.n(SayHiWithSnsPermissionUI.this);
                AppMethodBeat.o(27401);
                return true;
            }
        });
        AppMethodBeat.o(27412);
    }

    private void dmp() {
        int i2 = 8;
        int i3 = 4;
        AppMethodBeat.i(27413);
        this.BhQ.setVisibility((this.Bio || this.BhT) ? 0 : 4);
        WeImageView weImageView = this.BhR;
        if (!this.Bio && !this.BhT) {
            i3 = 0;
        }
        weImageView.setVisibility(i3);
        ((View) this.BhQ.getParent()).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(27402);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SayHiWithSnsPermissionUI.this.BhQ.setVisibility(0);
                SayHiWithSnsPermissionUI.this.BhR.setVisibility(4);
                SayHiWithSnsPermissionUI.this.findViewById(R.id.g0r).setVisibility(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27402);
            }
        });
        ((View) this.BhR.getParent()).setOnClickListener(this.BhT ? null : new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(27403);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SayHiWithSnsPermissionUI.this.BhQ.setVisibility(4);
                SayHiWithSnsPermissionUI.this.BhR.setVisibility(0);
                SayHiWithSnsPermissionUI.this.findViewById(R.id.g0r).setVisibility(0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27403);
            }
        });
        findViewById(R.id.g0r).setVisibility((!this.BhS || (!this.Bio && !this.BhT)) ? 0 : 8);
        ((TextView) findViewById(R.id.hzq)).setTextColor(this.BhT ? getResources().getColor(R.color.uj) : getResources().getColor(R.color.a2x));
        View findViewById = findViewById(R.id.ihq);
        if (this.BhT) {
            i2 = 0;
        }
        findViewById.setVisibility(i2);
        this.Bio = false;
        AppMethodBeat.o(27413);
    }

    private String eEW() {
        AppMethodBeat.i(27414);
        String str = "";
        if (!(this.Bij == null || this.Bij.getText() == null)) {
            str = this.Bij.getText().toString();
        }
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(27414);
            return str;
        } else if (str.length() <= 50) {
            AppMethodBeat.o(27414);
            return str;
        } else {
            String substring = str.substring(0, 50);
            AppMethodBeat.o(27414);
            return substring;
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        int i4;
        int i5;
        AppMethodBeat.i(27415);
        long currentTimeMillis = System.currentTimeMillis();
        Log.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        try {
            if (this.gtM != null) {
                this.gtM.dismiss();
                this.gtM = null;
            }
            if (this.Bip && this.BhP.QDw && !aKt(this.userName)) {
                bg.aVF();
                as Kn = com.tencent.mm.model.c.aSN().Kn(this.userName);
                LinkedList linkedList = new LinkedList();
                linkedList.add(Kn.field_username);
                pr prVar = new pr();
                prVar.dVH.list = linkedList;
                prVar.dVH.dJY = 1;
                prVar.dVH.dVI = 5;
                prVar.dVH.dLQ = true;
                EventCenter.instance.publish(prVar);
            }
            if (this.Bim) {
                String trim = this.Bii.getText().toString().trim();
                if (Util.isNullOrNil(trim) || trim.equals(this.Biq) || !Util.isNullOrNil(this.chatroomName)) {
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(294913, "");
                } else {
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(294913, trim);
                }
            }
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.ui.base.h.cD(this, getString(R.string.gkn));
                au.aI(this.userName, 1);
                re reVar = new re();
                reVar.dXU.username = this.userName;
                reVar.dXU.type = 1;
                EventCenter.instance.publish(reVar);
                if (this.kgm == 17 && (qVar instanceof p)) {
                    long longExtra = getIntent().getLongExtra("key_msg_id", 0);
                    if (longExtra > 0) {
                        ca Hb = ((l) g.af(l.class)).eiy().Hb(longExtra);
                        if (Hb.field_msgId > 0) {
                            Hb.gDF();
                            ((l) g.af(l.class)).eiy().a(longExtra, Hb);
                        }
                    }
                }
                if (this.Bin) {
                    String eEW = eEW();
                    if (!Util.isNullOrNil(eEW)) {
                        Log.i("MicroMsg.SayHiWithSnsPermissionUI", "set temp remark of %s", this.userName);
                        bg.aVF();
                        as Kn2 = com.tencent.mm.model.c.aSN().Kn(this.userName);
                        Kn2.BD(eEW);
                        bg.aVF();
                        cn aEZ = com.tencent.mm.model.c.aSO().aEZ(this.userName);
                        aEZ.field_encryptUsername = this.userName;
                        aEZ.field_conRemark = eEW;
                        bg.aVF();
                        com.tencent.mm.model.c.aSO().replace(aEZ);
                        bg.aVF();
                        com.tencent.mm.model.c.aSN().ao(Kn2);
                        this.kmr[2] = 1;
                        if (!Util.isNullOrNil(this.nickName) && !eEW.equals(this.nickName)) {
                            this.kmr[5] = 1;
                        }
                    } else if (!Util.isNullOrNil(this.nickName)) {
                        this.kmr[2] = 0;
                    } else {
                        this.kmr[2] = 2;
                    }
                    List linkedList2 = new LinkedList();
                    if (qVar instanceof p) {
                        int i6 = ((p) qVar).dKy;
                        linkedList2 = ((p) qVar).JVj;
                        i4 = i6;
                    } else {
                        if (qVar instanceof q) {
                            linkedList2.add(((q) qVar).jGZ);
                        }
                        i4 = 0;
                    }
                    if (i4 == 3 || (qVar instanceof q)) {
                        bn bkv = com.tencent.mm.bj.d.bgM().bkv(this.userName);
                        bg.aVF();
                        as Kn3 = com.tencent.mm.model.c.aSN().Kn(this.userName);
                        if (linkedList2 != null && linkedList2.contains(this.userName)) {
                            if (((int) Kn3.gMZ) == 0) {
                                Kn3 = com.tencent.mm.pluginsdk.ui.preference.b.a(bkv);
                                Kn3.setUsername(this.userName);
                                bg.aVF();
                                if (!com.tencent.mm.model.c.aSN().ap(Kn3)) {
                                    Log.e("MicroMsg.SayHiWithSnsPermissionUI", "canAddContact fail, insert fail");
                                }
                            }
                            ab.B(Kn3);
                            bg.getNotification().alb();
                            com.tencent.mm.bj.d.bgN().gP(this.userName, 1);
                            com.tencent.mm.pluginsdk.ui.preference.b.cC(this.userName, this.kgm);
                        }
                        bg.aVF();
                        as Kn4 = com.tencent.mm.model.c.aSN().Kn(this.userName);
                        vx vxVar = new vx();
                        vxVar.ebX.ebZ = true;
                        vxVar.ebX.ebY = false;
                        vxVar.ebX.username = this.userName;
                        EventCenter.instance.publish(vxVar);
                        if (this.BhO.QDw) {
                            ab.v(Kn4);
                        } else {
                            ab.w(Kn4);
                        }
                        vx vxVar2 = new vx();
                        vxVar2.ebX.ebZ = false;
                        vxVar2.ebX.ebY = true;
                        vxVar2.ebX.username = this.userName;
                        vxVar2.ebX.eca = aKt(this.userName);
                        String str2 = this.userName;
                        if (!this.BhP.QDw) {
                            i5 = 2;
                        } else {
                            i5 = 1;
                        }
                        LinkedList linkedList3 = new LinkedList();
                        linkedList3.add(str2);
                        pr prVar2 = new pr();
                        prVar2.dVH.list = linkedList3;
                        prVar2.dVH.dJY = i5;
                        prVar2.dVH.dVI = 5;
                        EventCenter.instance.publish(prVar2);
                        EventCenter.instance.publish(vxVar2);
                        if (getIntent().getBooleanExtra("sayhi_with_jump_to_profile", false)) {
                            Intent intent = new Intent();
                            intent.putExtra("friend_message_transfer_username", this.userName);
                            intent.setAction("friend_message_accept_" + this.userName);
                            intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.eq);
                            intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.en);
                            com.tencent.mm.br.c.b(this, "subapp", ".ui.friend.FMessageTransferUI", intent);
                        }
                    }
                }
                getIntent().putExtra("CONTACT_INFO_UI_SOURCE", 7);
                h.INSTANCE.a(16055, Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(getIntent())), 1, 1, this.userName);
                setResult(-1, getIntent());
                finish();
                sL(true);
                if ((this.Bit & 8) == 0) {
                    g.aAh().azQ().set(ar.a.USERINFO_EXCEED_FRIEND_LIMIT_FLAG_INT_SYNC, (Object) 0);
                }
            } else if (i2 == 4 && i3 == -24 && !Util.isNullOrNil(str)) {
                Toast.makeText(this, str, 1).show();
            } else if (i2 == 4 && ((i3 == -2 || i3 == -101) && !Util.isNullOrNil(str))) {
                com.tencent.mm.ui.base.h.a(this, str, "", getString(R.string.x_), (DialogInterface.OnClickListener) null);
            } else if (this.Bim && (i3 == -24 || i3 == -34)) {
                Toast.makeText(this, (int) R.string.ddu, 0).show();
            } else if (i2 == 4 && i3 == -3400 && this.BhS) {
                this.BhT = true;
                g.aAh().azQ().set(ar.a.USERINFO_EXCEED_FRIEND_LIMIT_FLAG_INT_SYNC, (Object) 1);
                if (!Util.isNullOrNil(str)) {
                    ((TextView) findViewById(R.id.ihq)).setText(str);
                }
                dmp();
                f.a aVar = new f.a(this);
                aVar.bow(str).Dq(true).boB(getString(R.string.fpo)).apa(R.string.fpp);
                aVar.c(new f.c() {
                    /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.AnonymousClass10 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(27404);
                        SayHiWithSnsPermissionUI.this.hideVKB();
                        if (!z) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + LocaleUtil.getCurrentLanguage(SayHiWithSnsPermissionUI.this));
                            intent.putExtra("showShare", false);
                            intent.putExtra("show_bottom", false);
                            com.tencent.mm.br.c.b(SayHiWithSnsPermissionUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        }
                        AppMethodBeat.o(27404);
                    }
                }).show();
            } else {
                Toast.makeText(this, (int) R.string.gkm, 0).show();
            }
            Log.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(27415);
        } catch (Exception e2) {
            Log.e("MicroMsg.SayHiWithSnsPermissionUI", "exception in onSceneEnd : " + e2.getMessage());
            Log.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(27415);
        } catch (Throwable th) {
            Log.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(27415);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends ClickableSpan {
        public String remark;

        public a(String str) {
            this.remark = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(27405);
            SayHiWithSnsPermissionUI.this.Bij.setText(com.tencent.mm.pluginsdk.ui.span.l.b(SayHiWithSnsPermissionUI.this, Util.nullAsNil(this.remark), SayHiWithSnsPermissionUI.this.Bij.getTextSize()));
            SayHiWithSnsPermissionUI.this.Bij.setSelection(SayHiWithSnsPermissionUI.this.Bij.getText().length());
            SayHiWithSnsPermissionUI.this.Bik.setVisibility(8);
            SayHiWithSnsPermissionUI.this.kmr[4] = 1;
            AppMethodBeat.o(27405);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(27406);
            textPaint.setColor(SayHiWithSnsPermissionUI.this.getResources().getColor(R.color.fx));
            textPaint.setUnderlineText(false);
            AppMethodBeat.o(27406);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(27417);
        if (i2 == 4) {
            this.kmr[0] = 1;
            finish();
            sL(false);
            AppMethodBeat.o(27417);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(27417);
        return onKeyDown;
    }

    private void sL(boolean z) {
        AppMethodBeat.i(27418);
        final int i2 = this.Bim ? 1 : z ? 2 : 3;
        if (Util.isNullOrNil(eEW())) {
            this.Biu = 3;
        } else if (eEW().equals(this.nickName) || eEW().equals(this.Azx)) {
            this.Biu = 2;
        }
        if (this.BhT) {
            this.Biv = 6;
        } else if ((this.Bit & 8) != 0) {
            this.Biv = 5;
        } else if ((this.Bit & 1) != 0 && (this.Bit & 2) != 0) {
            this.Biv = 4;
        } else if ((this.Bit & 2) != 0) {
            this.Biv = 3;
        } else if ((this.Bit & 1) != 0) {
            this.Biv = 2;
        }
        switch (this.kgm) {
            case 1:
                this.scene = 4;
                break;
            case 3:
                this.scene = 3;
                break;
            case 6:
            case 10:
            case 13:
            case 21:
            case 52:
                this.scene = 1;
                break;
            case 14:
                this.scene = 7;
                break;
            case 15:
                this.scene = 2;
                break;
            case 17:
                this.scene = 5;
                break;
            case 18:
            case 44:
                this.scene = 9;
                break;
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
                this.scene = 10;
                break;
            case 30:
            case 45:
            case 49:
                this.scene = 6;
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                this.scene = 8;
                break;
            case h.a.CTRL_INDEX:
            case 79:
            case 181:
            case 182:
                this.scene = 12;
                break;
            default:
                this.scene = 11;
                break;
        }
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(231899);
                bg.aVF();
                int c2 = com.tencent.mm.model.c.aSN().c(ab.iCO, z.aTY(), "weixin", "helper_entry", "filehelper");
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(18713, SayHiWithSnsPermissionUI.this.userName, Integer.valueOf(i2), Integer.valueOf(SayHiWithSnsPermissionUI.this.Biu), Integer.valueOf(SayHiWithSnsPermissionUI.this.Biv), Integer.valueOf(SayHiWithSnsPermissionUI.this.scene), 2, Long.valueOf(System.currentTimeMillis() - SayHiWithSnsPermissionUI.this.dUy), Integer.valueOf(c2));
                AppMethodBeat.o(231899);
            }
        });
        AppMethodBeat.o(27418);
    }

    private static boolean aKt(String str) {
        AppMethodBeat.i(27416);
        boolean aKt = com.tencent.mm.plugin.sns.b.o.DCP.aKt(str);
        AppMethodBeat.o(27416);
        return aKt;
    }

    static /* synthetic */ String f(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        AppMethodBeat.i(27419);
        String trim = sayHiWithSnsPermissionUI.Bii.getText().toString().trim();
        if (trim.length() <= 50) {
            AppMethodBeat.o(27419);
            return trim;
        }
        String substring = trim.substring(0, 50);
        AppMethodBeat.o(27419);
        return substring;
    }
}
