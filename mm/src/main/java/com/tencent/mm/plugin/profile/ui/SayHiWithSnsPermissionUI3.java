package com.tencent.mm.plugin.profile.ui;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
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
import android.view.ViewGroup;
import android.view.ViewParent;
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
import com.tencent.mm.plugin.expt.b.b;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SayHiWithSnsPermissionUI3 extends MMActivity implements i {
    private String Azx;
    private MMSwitchBtn BhO;
    private MMSwitchBtn BhP;
    private WeImageView BhQ;
    private WeImageView BhR;
    private boolean BhS = false;
    private boolean BhT = false;
    private int BiI = 0;
    private TextView Bia;
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
    private String cgo;
    private String chatroomName;
    private long dUy = System.currentTimeMillis();
    private ProgressDialog gtM = null;
    private int kgm;
    private int[] kmr = new int[8];
    private String nickName;
    private String userName;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SayHiWithSnsPermissionUI3() {
        AppMethodBeat.i(231918);
        AppMethodBeat.o(231918);
    }

    static /* synthetic */ void a(SayHiWithSnsPermissionUI3 sayHiWithSnsPermissionUI3, Object obj, int i2, int i3, int i4, Runnable runnable) {
        AppMethodBeat.i(258858);
        sayHiWithSnsPermissionUI3.a(obj, i2, i3, i4, runnable);
        AppMethodBeat.o(258858);
    }

    static /* synthetic */ void c(SayHiWithSnsPermissionUI3 sayHiWithSnsPermissionUI3) {
        AppMethodBeat.i(231931);
        sayHiWithSnsPermissionUI3.eEX();
        AppMethodBeat.o(231931);
    }

    static /* synthetic */ int g(SayHiWithSnsPermissionUI3 sayHiWithSnsPermissionUI3) {
        int i2 = sayHiWithSnsPermissionUI3.BiI;
        sayHiWithSnsPermissionUI3.BiI = i2 + 1;
        return i2;
    }

    static /* synthetic */ void r(SayHiWithSnsPermissionUI3 sayHiWithSnsPermissionUI3) {
        AppMethodBeat.i(258857);
        sayHiWithSnsPermissionUI3.sL(false);
        AppMethodBeat.o(258857);
    }

    static /* synthetic */ String u(SayHiWithSnsPermissionUI3 sayHiWithSnsPermissionUI3) {
        AppMethodBeat.i(258859);
        String eEW = sayHiWithSnsPermissionUI3.eEW();
        AppMethodBeat.o(258859);
        return eEW;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(231919);
        super.onCreate(bundle);
        setActionbarColor(getContext().getResources().getColor(R.color.afz));
        hideActionbarLine();
        setMMTitle("");
        initView();
        bg.azz().a(30, this);
        bg.azz().a(d.CTRL_INDEX, this);
        bg.azz().a(JsApiGetRecentUsageList.CTRL_INDEX, this);
        AppMethodBeat.o(231919);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        boolean z;
        AppMethodBeat.i(258853);
        if (((b) g.af(b.class)).a(b.a.clicfg_add_friends_without_choose_permission_icon_order, 0) != 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(258853);
            return R.layout.bnn;
        }
        AppMethodBeat.o(258853);
        return R.layout.cg3;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(231920);
        super.onResume();
        AppMethodBeat.o(231920);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(231921);
        super.onStop();
        AppMethodBeat.o(231921);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(231922);
        bg.azz().b(30, this);
        bg.azz().b(d.CTRL_INDEX, this);
        bg.azz().b(JsApiGetRecentUsageList.CTRL_INDEX, this);
        h.INSTANCE.a(14036, Integer.valueOf(this.kmr[0]), Integer.valueOf(this.kmr[1]), Integer.valueOf(this.kmr[2]), Integer.valueOf(this.kmr[3]), Integer.valueOf(this.kmr[4]), Integer.valueOf(this.kmr[5]), Integer.valueOf(this.kmr[6]), Integer.valueOf(this.kmr[7]), this.userName);
        super.onDestroy();
        removeAllOptionMenu();
        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_ver_usr");
        AppMethodBeat.o(231922);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        boolean z2;
        bn bkv;
        String str;
        as Kn;
        AppMethodBeat.i(231923);
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
        this.Bia = (TextView) findViewById(R.id.ihq);
        this.BhP = (MMSwitchBtn) findViewById(R.id.hwu).findViewById(R.id.g10);
        this.BhP.setCheck(aKt(this.userName));
        findViewById(R.id.a_s).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(231900);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SayHiWithSnsPermissionUI3.this.hideVKB();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231900);
            }
        });
        int i2 = Kn2.fuA;
        Log.d("MicroMsg.SayHiWithSnsPermissionUI3", "sex:%d", Integer.valueOf(i2));
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
            View findViewById = findViewById(R.id.g0r);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        } else {
            ((View) this.BhQ.getParent()).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(231904);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (SayHiWithSnsPermissionUI3.this.BhQ.getVisibility() != 0) {
                        SayHiWithSnsPermissionUI3.this.BhQ.setVisibility(0);
                        SayHiWithSnsPermissionUI3.this.BhR.setVisibility(4);
                        SayHiWithSnsPermissionUI3.this.updateOptionMenuStyle(0, t.b.GREEN);
                        SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(231904);
                }
            });
            ((View) this.BhR.getParent()).setOnClickListener(this.BhT ? null : new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(231905);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (SayHiWithSnsPermissionUI3.this.BhR.getVisibility() != 0) {
                        SayHiWithSnsPermissionUI3.this.BhQ.setVisibility(4);
                        SayHiWithSnsPermissionUI3.this.BhR.setVisibility(0);
                        SayHiWithSnsPermissionUI3.this.updateOptionMenuStyle(0, t.b.GREEN);
                        SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(231905);
                }
            });
        }
        if (this.Bip) {
            this.BhP.setCheck(true);
        }
        if (this.Bim) {
            this.Bii = (EditText) findViewById(R.id.h_j);
            c.f(this.Bii).aoq(100).a((c.a) null);
            this.Bii.setFilters(com.tencent.mm.pluginsdk.ui.tools.l.KvQ);
            this.Bii.addTextChangedListener(new TextWatcher() {
                /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass7 */

                public final void afterTextChanged(Editable editable) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    AppMethodBeat.i(231906);
                    if (SayHiWithSnsPermissionUI3.this.Bir[0]) {
                        SayHiWithSnsPermissionUI3.this.Bir[0] = false;
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIL("ie_ver_usr");
                    }
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIM("ie_ver_usr");
                    AppMethodBeat.o(231906);
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
                Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "chatroomName:%s nick:%s", this.chatroomName, Kn.field_nickname);
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
                        /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass8 */

                        public final void onFocusChange(View view, boolean z) {
                            AppMethodBeat.i(231907);
                            if (z) {
                                if (!Util.isNullOrNil(SayHiWithSnsPermissionUI3.this.Bij.getHint()) && Util.isNullOrNil(SayHiWithSnsPermissionUI3.this.Bij.getText())) {
                                    SayHiWithSnsPermissionUI3.this.Bij.setText(SayHiWithSnsPermissionUI3.this.Bij.getHint());
                                    SayHiWithSnsPermissionUI3.this.Bij.setHint((CharSequence) null);
                                }
                                SayHiWithSnsPermissionUI3.this.Bij.setSelection(SayHiWithSnsPermissionUI3.this.Bij.getText().length());
                            }
                            AppMethodBeat.o(231907);
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
                        break;
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
            /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass9 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i2;
                int i3;
                int i4;
                AppMethodBeat.i(231912);
                if (SayHiWithSnsPermissionUI3.this.gtM == null || !SayHiWithSnsPermissionUI3.this.gtM.isShowing()) {
                    if (SayHiWithSnsPermissionUI3.this.Bis[0]) {
                        SayHiWithSnsPermissionUI3.this.Bis[0] = false;
                    } else {
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aA("ce_ver_usr", "<VerifyUsr>", TN);
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.a("ce_ver_usr", MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 65535));
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIQ("ce_ver_usr");
                    }
                    if (SayHiWithSnsPermissionUI3.this.BhQ.getVisibility() == 0 || SayHiWithSnsPermissionUI3.this.BhR.getVisibility() == 0) {
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.eW(TN, 3);
                        if (SayHiWithSnsPermissionUI3.this.Bim) {
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(SayHiWithSnsPermissionUI3.this.userName);
                            LinkedList linkedList2 = new LinkedList();
                            linkedList2.add(Integer.valueOf(SayHiWithSnsPermissionUI3.this.kgm));
                            String k = SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this);
                            HashMap hashMap = new HashMap();
                            if (SayHiWithSnsPermissionUI3.this.BhQ.getVisibility() != 0) {
                                if (SayHiWithSnsPermissionUI3.this.BhO.QDw) {
                                    i4 = 1;
                                } else {
                                    i4 = 0;
                                }
                                if (SayHiWithSnsPermissionUI3.this.BhP.QDw) {
                                    i4 |= 2;
                                }
                            } else {
                                i4 = 0;
                            }
                            if (SayHiWithSnsPermissionUI3.this.BhQ.getVisibility() == 0) {
                                i4 |= 8;
                            }
                            SayHiWithSnsPermissionUI3.this.Bit = i4;
                            hashMap.put(SayHiWithSnsPermissionUI3.this.userName, Integer.valueOf(i4));
                            Log.d("MicroMsg.SayHiWithSnsPermissionUI3", "select sns permission, %s", Integer.valueOf(i4));
                            if (SayHiWithSnsPermissionUI3.this.Bip) {
                                final o oVar = new o(SayHiWithSnsPermissionUI3.this.userName, k, SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra(e.d.OyT), i4);
                                bg.azz().a(oVar, 0);
                                SayHiWithSnsPermissionUI3 sayHiWithSnsPermissionUI3 = SayHiWithSnsPermissionUI3.this;
                                AppCompatActivity context = SayHiWithSnsPermissionUI3.this.getContext();
                                SayHiWithSnsPermissionUI3.this.getString(R.string.zb);
                                sayHiWithSnsPermissionUI3.gtM = com.tencent.mm.ui.base.h.a((Context) context, SayHiWithSnsPermissionUI3.this.getString(R.string.gko), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass9.AnonymousClass1 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(231908);
                                        bg.azz().a(oVar);
                                        AppMethodBeat.o(231908);
                                    }
                                });
                            } else {
                                String stringExtra = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("source_from_user_name");
                                String stringExtra2 = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("source_from_nick_name");
                                final aa aaVar = new aa(SayHiWithSnsPermissionUI3.this, null);
                                aaVar.content = k;
                                aaVar.mw(stringExtra, stringExtra2);
                                aaVar.Kgh = hashMap;
                                aaVar.chatroomName = SayHiWithSnsPermissionUI3.this.chatroomName;
                                aaVar.z(linkedList, linkedList2);
                                SayHiWithSnsPermissionUI3 sayHiWithSnsPermissionUI32 = SayHiWithSnsPermissionUI3.this;
                                AppCompatActivity context2 = SayHiWithSnsPermissionUI3.this.getContext();
                                SayHiWithSnsPermissionUI3.this.getString(R.string.zb);
                                sayHiWithSnsPermissionUI32.gtM = com.tencent.mm.ui.base.h.a((Context) context2, SayHiWithSnsPermissionUI3.this.getString(R.string.gko), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass9.AnonymousClass2 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(231909);
                                        aaVar.gpI();
                                        AppMethodBeat.o(231909);
                                    }
                                });
                            }
                        } else if (SayHiWithSnsPermissionUI3.this.Bin) {
                            String stringExtra3 = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("Verify_ticket");
                            if (SayHiWithSnsPermissionUI3.this.BhQ.getVisibility() != 0) {
                                if (SayHiWithSnsPermissionUI3.this.BhO.QDw) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                if (SayHiWithSnsPermissionUI3.this.BhP.QDw) {
                                    i2 |= 2;
                                }
                            } else {
                                i2 = 0;
                            }
                            if (SayHiWithSnsPermissionUI3.this.BhQ.getVisibility() == 0) {
                                i3 = i2 | 8;
                            } else {
                                i3 = i2;
                            }
                            SayHiWithSnsPermissionUI3.this.Bit = i3;
                            Log.d("MicroMsg.SayHiWithSnsPermissionUI3", "select sns permission, %s", Integer.valueOf(i3));
                            if (SayHiWithSnsPermissionUI3.this.Bip) {
                                final q qVar = new q(SayHiWithSnsPermissionUI3.this.userName, stringExtra3, i3);
                                bg.azz().a(qVar, 0);
                                SayHiWithSnsPermissionUI3 sayHiWithSnsPermissionUI33 = SayHiWithSnsPermissionUI3.this;
                                AppCompatActivity context3 = SayHiWithSnsPermissionUI3.this.getContext();
                                SayHiWithSnsPermissionUI3.this.getString(R.string.zb);
                                sayHiWithSnsPermissionUI33.gtM = com.tencent.mm.ui.base.h.a((Context) context3, SayHiWithSnsPermissionUI3.this.getString(R.string.bac), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass9.AnonymousClass3 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(231910);
                                        bg.azz().a(qVar);
                                        AppMethodBeat.o(231910);
                                    }
                                });
                            } else {
                                final p pVar = new p(SayHiWithSnsPermissionUI3.this.userName, stringExtra3, SayHiWithSnsPermissionUI3.this.kgm, SayHiWithSnsPermissionUI3.this.chatroomName, i3);
                                bg.azz().a(pVar, 0);
                                SayHiWithSnsPermissionUI3 sayHiWithSnsPermissionUI34 = SayHiWithSnsPermissionUI3.this;
                                AppCompatActivity context4 = SayHiWithSnsPermissionUI3.this.getContext();
                                SayHiWithSnsPermissionUI3.this.getString(R.string.zb);
                                sayHiWithSnsPermissionUI34.gtM = com.tencent.mm.ui.base.h.a((Context) context4, SayHiWithSnsPermissionUI3.this.getString(R.string.bac), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass9.AnonymousClass4 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(231911);
                                        bg.azz().a(pVar);
                                        AppMethodBeat.o(231911);
                                    }
                                });
                            }
                        }
                        AppMethodBeat.o(231912);
                    } else {
                        SayHiWithSnsPermissionUI3.f(SayHiWithSnsPermissionUI3.this);
                        SayHiWithSnsPermissionUI3.g(SayHiWithSnsPermissionUI3.this);
                        AppMethodBeat.o(231912);
                    }
                } else {
                    AppMethodBeat.o(231912);
                }
                return false;
            }
        }, null, new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass10 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(231913);
                switch (motionEvent.getAction()) {
                    case 0:
                    case 5:
                        SayHiWithSnsPermissionUI3.this.Bis[0] = true;
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aA("ce_ver_usr", "<VerifyUsr>", TN);
                        break;
                    case 1:
                    case 6:
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.a("ce_ver_usr", motionEvent);
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIQ("ce_ver_usr");
                        break;
                }
                AppMethodBeat.o(231913);
                return false;
            }
        }, t.b.TRANSPARENT_GREEN_TEXT);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass11 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(231914);
                if (SayHiWithSnsPermissionUI3.this.Bin) {
                    SayHiWithSnsPermissionUI3.this.kmr[1] = 1;
                }
                SayHiWithSnsPermissionUI3.this.finish();
                SayHiWithSnsPermissionUI3.r(SayHiWithSnsPermissionUI3.this);
                AppMethodBeat.o(231914);
                return true;
            }
        });
        AppMethodBeat.o(231923);
    }

    private void eEX() {
        ViewParent parent;
        ViewParent parent2;
        AppMethodBeat.i(231924);
        if (this.BhQ.getVisibility() == 0) {
            parent2 = this.BhQ.getParent();
            parent = this.BhR.getParent();
        } else {
            parent = this.BhQ.getParent();
            parent2 = this.BhR.getParent();
        }
        ((View) parent2).setBackgroundResource(R.drawable.qy);
        ((View) parent).setBackgroundResource(R.drawable.qz);
        Iterator it = a((ViewGroup) parent2, TextView.class).iterator();
        while (it.hasNext()) {
            ((TextView) it.next()).setTextColor(getResources().getColor(R.color.Brand));
        }
        ArrayList a2 = a((ViewGroup) parent, TextView.class);
        ((TextView) a2.get(0)).setTextColor(getResources().getColor(R.color.a2x));
        ((TextView) a2.get(1)).setTextColor(getResources().getColor(R.color.uj));
        TextView textView = (TextView) findViewById(R.id.iht);
        textView.setText(R.string.fqp);
        textView.setTextColor(getResources().getColor(R.color.FG_1));
        AppMethodBeat.o(231924);
    }

    private void a(final Object obj, int i2, int i3, int i4, final Runnable runnable) {
        AppMethodBeat.i(258854);
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i2), Integer.valueOf(i3));
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass4 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(258849);
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (obj instanceof TextView) {
                    ((TextView) obj).setTextColor(intValue);
                    AppMethodBeat.o(258849);
                    return;
                }
                if (obj instanceof GradientDrawable) {
                    ((GradientDrawable) obj).setColor(intValue);
                }
                AppMethodBeat.o(258849);
            }
        });
        ofObject.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass13 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(258850);
                if (runnable != null) {
                    runnable.run();
                }
                AppMethodBeat.o(258850);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        ofObject.setDuration((long) i4);
        ofObject.start();
        AppMethodBeat.o(258854);
    }

    private static <T extends View> ArrayList<T> a(ViewGroup viewGroup, Class<T> cls) {
        AppMethodBeat.i(231925);
        ArrayList<T> arrayList = new ArrayList<>();
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                arrayList.addAll(a((ViewGroup) childAt, cls));
            }
            if (cls.isInstance(childAt)) {
                arrayList.add(cls.cast(childAt));
            }
        }
        AppMethodBeat.o(231925);
        return arrayList;
    }

    private String eEW() {
        AppMethodBeat.i(231926);
        String str = "";
        if (this.Bij.getText() != null) {
            str = this.Bij.getText().toString();
        }
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(231926);
            return str;
        } else if (str.length() <= 50) {
            AppMethodBeat.o(231926);
            return str;
        } else {
            String substring = str.substring(0, 50);
            AppMethodBeat.o(231926);
            return substring;
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AnonymousClass2 r3;
        int color;
        int i4;
        int i5;
        AppMethodBeat.i(231927);
        long currentTimeMillis = System.currentTimeMillis();
        Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        try {
            if (this.gtM != null) {
                this.gtM.dismiss();
                this.gtM = null;
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
                        Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "set temp remark of %s", this.userName);
                        bg.aVF();
                        as Kn = com.tencent.mm.model.c.aSN().Kn(this.userName);
                        Kn.BD(eEW);
                        bg.aVF();
                        cn aEZ = com.tencent.mm.model.c.aSO().aEZ(this.userName);
                        aEZ.field_encryptUsername = this.userName;
                        aEZ.field_conRemark = eEW;
                        bg.aVF();
                        com.tencent.mm.model.c.aSO().replace(aEZ);
                        bg.aVF();
                        com.tencent.mm.model.c.aSN().ao(Kn);
                        this.kmr[2] = 1;
                        if (!Util.isNullOrNil(this.nickName) && !eEW.equals(this.nickName)) {
                            this.kmr[5] = 1;
                        }
                    } else if (!Util.isNullOrNil(this.nickName)) {
                        this.kmr[2] = 0;
                    } else {
                        this.kmr[2] = 2;
                    }
                    List linkedList = new LinkedList();
                    if (qVar instanceof p) {
                        int i6 = ((p) qVar).dKy;
                        linkedList = ((p) qVar).JVj;
                        i4 = i6;
                    } else {
                        if (qVar instanceof q) {
                            linkedList.add(((q) qVar).jGZ);
                        }
                        i4 = 0;
                    }
                    if (i4 == 3 || (qVar instanceof q)) {
                        bn bkv = com.tencent.mm.bj.d.bgM().bkv(this.userName);
                        bg.aVF();
                        as Kn2 = com.tencent.mm.model.c.aSN().Kn(this.userName);
                        if (linkedList != null && linkedList.contains(this.userName)) {
                            if (((int) Kn2.gMZ) == 0) {
                                Kn2 = com.tencent.mm.pluginsdk.ui.preference.b.a(bkv);
                                Kn2.setUsername(this.userName);
                                bg.aVF();
                                if (!com.tencent.mm.model.c.aSN().ap(Kn2)) {
                                    Log.e("MicroMsg.SayHiWithSnsPermissionUI3", "canAddContact fail, insert fail");
                                }
                            }
                            ab.B(Kn2);
                            bg.getNotification().alb();
                            com.tencent.mm.bj.d.bgN().gP(this.userName, 1);
                            com.tencent.mm.pluginsdk.ui.preference.b.cC(this.userName, this.kgm);
                        }
                        bg.aVF();
                        as Kn3 = com.tencent.mm.model.c.aSN().Kn(this.userName);
                        vx vxVar = new vx();
                        vxVar.ebX.ebZ = true;
                        vxVar.ebX.ebY = false;
                        vxVar.ebX.username = this.userName;
                        EventCenter.instance.publish(vxVar);
                        if (this.BhO.QDw) {
                            ab.v(Kn3);
                        } else {
                            ab.w(Kn3);
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
                        LinkedList linkedList2 = new LinkedList();
                        linkedList2.add(str2);
                        pr prVar = new pr();
                        prVar.dVH.list = linkedList2;
                        prVar.dVH.dJY = i5;
                        prVar.dVH.dVI = 5;
                        EventCenter.instance.publish(prVar);
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
                    this.Bia.setText(str);
                }
                this.BhQ.setVisibility((this.Bio || this.BhT) ? 0 : 4);
                this.BhR.setVisibility((this.Bio || this.BhT) ? 4 : 0);
                ((View) this.BhQ.getParent()).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass12 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(231915);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (SayHiWithSnsPermissionUI3.this.BhQ.getVisibility() != 0) {
                            SayHiWithSnsPermissionUI3.this.BhQ.setVisibility(0);
                            SayHiWithSnsPermissionUI3.this.BhR.setVisibility(4);
                            SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(231915);
                    }
                });
                View view = (View) this.BhR.getParent();
                if (this.BhT) {
                    r3 = null;
                } else {
                    r3 = new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(231901);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (SayHiWithSnsPermissionUI3.this.BhR.getVisibility() != 0) {
                                SayHiWithSnsPermissionUI3.this.BhQ.setVisibility(4);
                                SayHiWithSnsPermissionUI3.this.BhR.setVisibility(0);
                                SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(231901);
                        }
                    };
                }
                view.setOnClickListener(r3);
                findViewById(R.id.g0r).setVisibility(8);
                TextView textView = (TextView) findViewById(R.id.hzq);
                if (this.BhT) {
                    color = getResources().getColor(R.color.uj);
                } else {
                    color = getResources().getColor(R.color.a2x);
                }
                textView.setTextColor(color);
                if (this.BhT) {
                    this.Bia.setVisibility(0);
                }
                this.Bio = false;
                eEX();
                f.a aVar = new f.a(this);
                aVar.bow(str).Dq(true).boB(getString(R.string.fpo)).apa(R.string.fpp);
                aVar.c(new f.c() {
                    /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass14 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(258851);
                        SayHiWithSnsPermissionUI3.this.hideVKB();
                        if (!z) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + LocaleUtil.getCurrentLanguage(SayHiWithSnsPermissionUI3.this));
                            intent.putExtra("showShare", false);
                            intent.putExtra("show_bottom", false);
                            com.tencent.mm.br.c.b(SayHiWithSnsPermissionUI3.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        }
                        AppMethodBeat.o(258851);
                    }
                }).show();
            } else {
                Toast.makeText(this, (int) R.string.gkm, 0).show();
            }
            Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "[onCreate] %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(231927);
        } catch (Exception e2) {
            Log.e("MicroMsg.SayHiWithSnsPermissionUI3", "exception in onSceneEnd : " + e2.getMessage());
            Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "[onCreate] %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(231927);
        } catch (Throwable th) {
            Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "[onCreate] %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(231927);
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
            AppMethodBeat.i(231916);
            SayHiWithSnsPermissionUI3.this.Bij.setText(com.tencent.mm.pluginsdk.ui.span.l.b(SayHiWithSnsPermissionUI3.this, Util.nullAsNil(this.remark), SayHiWithSnsPermissionUI3.this.Bij.getTextSize()));
            SayHiWithSnsPermissionUI3.this.Bij.setSelection(SayHiWithSnsPermissionUI3.this.Bij.getText().length());
            SayHiWithSnsPermissionUI3.this.Bik.setVisibility(8);
            SayHiWithSnsPermissionUI3.this.kmr[4] = 1;
            AppMethodBeat.o(231916);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(231917);
            textPaint.setColor(SayHiWithSnsPermissionUI3.this.getResources().getColor(R.color.fx));
            textPaint.setUnderlineText(false);
            AppMethodBeat.o(231917);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(231929);
        if (i2 == 4) {
            this.kmr[0] = 1;
            finish();
            sL(false);
            AppMethodBeat.o(231929);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(231929);
        return onKeyDown;
    }

    private void sL(final boolean z) {
        AppMethodBeat.i(231930);
        com.tencent.f.h.RTc.aY(new Runnable() {
            /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass15 */

            public final void run() {
                int i2;
                int i3;
                int i4;
                AppMethodBeat.i(258852);
                int i5 = SayHiWithSnsPermissionUI3.this.Bim ? 1 : z ? 2 : 3;
                if (Util.isNullOrNil(SayHiWithSnsPermissionUI3.u(SayHiWithSnsPermissionUI3.this))) {
                    i2 = 3;
                } else if (SayHiWithSnsPermissionUI3.u(SayHiWithSnsPermissionUI3.this).equals(SayHiWithSnsPermissionUI3.this.nickName) || SayHiWithSnsPermissionUI3.u(SayHiWithSnsPermissionUI3.this).equals(SayHiWithSnsPermissionUI3.this.Azx)) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                if (SayHiWithSnsPermissionUI3.this.BhT) {
                    i3 = 6;
                } else if ((SayHiWithSnsPermissionUI3.this.Bit & 8) != 0) {
                    i3 = 5;
                } else if ((SayHiWithSnsPermissionUI3.this.Bit & 1) != 0 && (SayHiWithSnsPermissionUI3.this.Bit & 2) != 0) {
                    i3 = 4;
                } else if ((SayHiWithSnsPermissionUI3.this.Bit & 2) != 0) {
                    i3 = 3;
                } else if ((SayHiWithSnsPermissionUI3.this.Bit & 1) != 0) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                switch (SayHiWithSnsPermissionUI3.this.kgm) {
                    case 1:
                        i4 = 4;
                        break;
                    case 3:
                        i4 = 3;
                        break;
                    case 6:
                    case 10:
                    case 13:
                    case 21:
                    case 52:
                        i4 = 1;
                        break;
                    case 14:
                        i4 = 7;
                        break;
                    case 15:
                        i4 = 2;
                        break;
                    case 17:
                        i4 = 5;
                        break;
                    case 18:
                    case 44:
                        i4 = 9;
                        break;
                    case 22:
                    case 23:
                    case 24:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                        i4 = 10;
                        break;
                    case 30:
                    case 45:
                    case 49:
                        i4 = 6;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        i4 = 8;
                        break;
                    case h.a.CTRL_INDEX:
                    case 79:
                    case 181:
                    case 182:
                        i4 = 12;
                        break;
                    default:
                        i4 = 11;
                        break;
                }
                bg.aVF();
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(18713, SayHiWithSnsPermissionUI3.this.userName, Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), 2, Long.valueOf(System.currentTimeMillis() - SayHiWithSnsPermissionUI3.this.dUy), Integer.valueOf(com.tencent.mm.model.c.aSN().c(ab.iCO, z.aTY(), "weixin", "helper_entry", "filehelper")), Integer.valueOf(SayHiWithSnsPermissionUI3.this.BiI));
                AppMethodBeat.o(258852);
            }
        });
        AppMethodBeat.o(231930);
    }

    private static boolean aKt(String str) {
        AppMethodBeat.i(231928);
        boolean aKt = com.tencent.mm.plugin.sns.b.o.DCP.aKt(str);
        AppMethodBeat.o(231928);
        return aKt;
    }

    static /* synthetic */ void f(SayHiWithSnsPermissionUI3 sayHiWithSnsPermissionUI3) {
        AppMethodBeat.i(258855);
        TextView textView = (TextView) sayHiWithSnsPermissionUI3.findViewById(R.id.iht);
        ArrayList<View> arrayList = new ArrayList();
        arrayList.add((View) sayHiWithSnsPermissionUI3.BhQ.getParent());
        arrayList.add((View) sayHiWithSnsPermissionUI3.BhR.getParent());
        textView.setText(R.string.fpu);
        sayHiWithSnsPermissionUI3.a(textView, sayHiWithSnsPermissionUI3.getResources().getColor(R.color.FG_1), sayHiWithSnsPermissionUI3.getResources().getColor(R.color.Red_100), 300, null);
        final int color = sayHiWithSnsPermissionUI3.getResources().getColor(R.color.ag1);
        final int color2 = sayHiWithSnsPermissionUI3.getResources().getColor(R.color.BW_97);
        for (View view : arrayList) {
            final GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
            sayHiWithSnsPermissionUI3.a(gradientDrawable, color, color2, 300, new Runnable() {
                /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(258848);
                    SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, gradientDrawable, color2, color, 150, new Runnable() {
                        /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(258847);
                            SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, gradientDrawable, color, color2, 250, new Runnable() {
                                /* class com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(258846);
                                    gradientDrawable.setColor((ColorStateList) null);
                                    AppMethodBeat.o(258846);
                                }
                            });
                            AppMethodBeat.o(258847);
                        }
                    });
                    AppMethodBeat.o(258848);
                }
            });
        }
        AppMethodBeat.o(258855);
    }

    static /* synthetic */ String k(SayHiWithSnsPermissionUI3 sayHiWithSnsPermissionUI3) {
        AppMethodBeat.i(258856);
        String trim = sayHiWithSnsPermissionUI3.Bii.getText().toString().trim();
        if (trim.length() <= 50) {
            AppMethodBeat.o(258856);
            return trim;
        }
        String substring = trim.substring(0, 50);
        AppMethodBeat.o(258856);
        return substring;
    }
}
