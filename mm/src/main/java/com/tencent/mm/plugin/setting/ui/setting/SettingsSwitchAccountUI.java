package com.tencent.mm.plugin.setting.ui.setting;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.ui.LoginPasswordUI;
import com.tencent.mm.plugin.account.ui.LoginVoiceUI;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.expt.b.e;
import com.tencent.mm.plugin.setting.SwitchAccountReceiver;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.h;
import com.tencent.recovery.wx.util.WXUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@a(19)
public class SettingsSwitchAccountUI extends MMActivity implements i {
    private SwitchAccountGridView CYW;
    private Map<String, SwitchAccountModel> CZa = new HashMap();
    private boolean Dcl;
    private TextView Dej;
    private View Dek;
    private TextView Del;
    private ValueAnimator Dem;
    private MTimerHandler Den;
    private boolean Deo;
    private boolean Dep;
    private BroadcastReceiver Deq = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(74433);
            Log.i("MicroMsg.SettingsSwitchAccountUI", "onReceive %s", intent.getAction());
            SettingsSwitchAccountUI.this.unregisterReceiver(SettingsSwitchAccountUI.this.Deq);
            if (Util.nullAsNil(intent.getAction()).equals("action_kill_mm_process")) {
                g.aAf();
                com.tencent.mm.kernel.a.hold();
                g.aAi().FS("switch account ,delay logout");
                Mars.onSingalCrash(0);
                Log.appenderFlush();
                SettingsSwitchAccountUI.this.finish();
                Log.i("MicroMsg.SettingsSwitchAccountUI", "try to kill mm pid %d", Integer.valueOf(Process.myPid()));
                EventCenter.instance.publish(new xh());
            }
            AppMethodBeat.o(74433);
        }
    };
    private TextView kaq;
    private String klw;
    private int scene;
    private TextView titleView;
    private View tql;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsSwitchAccountUI() {
        AppMethodBeat.i(74445);
        AppMethodBeat.o(74445);
    }

    static /* synthetic */ void b(SettingsSwitchAccountUI settingsSwitchAccountUI, String str) {
        AppMethodBeat.i(74463);
        settingsSwitchAccountUI.aNe(str);
        AppMethodBeat.o(74463);
    }

    static /* synthetic */ void c(SettingsSwitchAccountUI settingsSwitchAccountUI) {
        AppMethodBeat.i(74465);
        settingsSwitchAccountUI.goBack();
        AppMethodBeat.o(74465);
    }

    static /* synthetic */ void eTy() {
        AppMethodBeat.i(74464);
        logout();
        AppMethodBeat.o(74464);
    }

    static /* synthetic */ void f(SettingsSwitchAccountUI settingsSwitchAccountUI) {
        AppMethodBeat.i(74466);
        settingsSwitchAccountUI.eTv();
        AppMethodBeat.o(74466);
    }

    static /* synthetic */ void j(SettingsSwitchAccountUI settingsSwitchAccountUI) {
        AppMethodBeat.i(74467);
        settingsSwitchAccountUI.eTx();
        AppMethodBeat.o(74467);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74446);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(74446);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74447);
        setMMTitle("");
        showMMLogo();
        getSupportActionBar().hide();
        getController().p(this, getContext().getResources().getColor(R.color.afz));
        this.scene = getIntent().getIntExtra("key_scene", 0);
        this.tql = findViewById(R.id.if7);
        this.Dek = findViewById(R.id.if5);
        this.titleView = (TextView) findViewById(R.id.if6);
        this.Del = (TextView) findViewById(R.id.if1);
        this.Dej = (TextView) findViewById(R.id.if2);
        this.kaq = (TextView) findViewById(R.id.if0);
        this.CYW = (SwitchAccountGridView) findViewById(R.id.if4);
        this.CYW.setRowCount(1);
        this.CYW.setOnClickAvatarListener(new SwitchAccountGridView.b() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.b
            public final void aNg(String str) {
                AppMethodBeat.i(74436);
                if (Util.isNullOrNil(str)) {
                    MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putString("last_switch_account_to_wx_username", "").commit();
                    if (SettingsSwitchAccountUI.this.scene == 0) {
                        SettingsSwitchAccountUI.eTy();
                        AppMethodBeat.o(74436);
                        return;
                    }
                    Intent intent = new Intent(SettingsSwitchAccountUI.this, MobileInputUI.class);
                    intent.putExtra("mobile_input_purpose", 1);
                    intent.putExtra("from_switch_account", true);
                    SettingsSwitchAccountUI settingsSwitchAccountUI = SettingsSwitchAccountUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(settingsSwitchAccountUI, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$2", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    settingsSwitchAccountUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(settingsSwitchAccountUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$2", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    b.kb(SettingsSwitchAccountUI.this);
                    AppMethodBeat.o(74436);
                } else if (SettingsSwitchAccountUI.this.scene == 0) {
                    SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, str);
                    AppMethodBeat.o(74436);
                } else {
                    SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, str);
                    AppMethodBeat.o(74436);
                }
            }
        });
        if (this.scene == 0) {
            Intent intent = new Intent(this, SwitchAccountReceiver.class);
            intent.putExtra("switch_process_action_code_key", "action_switch_account");
            MMApplicationContext.getContext().sendBroadcast(intent);
            this.kaq.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(74437);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    SettingsSwitchAccountUI.c(SettingsSwitchAccountUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(74437);
                }
            });
        } else {
            this.kaq.setVisibility(8);
        }
        Set<String> aWo = ch.iFO.aWo();
        g.aAf();
        if (com.tencent.mm.kernel.a.azo()) {
            this.klw = (String) g.aAh().azQ().get(2, (Object) null);
        } else {
            this.klw = bf.iDu.aA(WXUtil.LAST_LOGIN_WEXIN_USERNAME, "");
        }
        Log.i("MicroMsg.SettingsSwitchAccountUI", "scene %d， lastLoginWxUsername %s", Integer.valueOf(this.scene), this.klw);
        if (Util.isNullOrNil(this.klw) || aWo.contains(this.klw)) {
            if (!aWo.isEmpty()) {
                for (String str : aWo) {
                    this.CZa.put(str, new SwitchAccountModel(str, ch.iFO.getString(str, WXUtil.LAST_LOGIN_USERNAME), ch.iFO.getString(str, "last_avatar_path"), ch.iFO.getString(str, "last_logout_no_pwd_ticket"), Util.safeParseInt(ch.iFO.getString(str, "last_login_use_voice"))));
                }
            }
        } else if (this.scene != 2 || ch.iFO.KJ(this.klw)) {
            String aA = bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, "");
            String aVx = bf.iDu.aVx();
            String aA2 = bf.iDu.aA("last_login_use_voice", "");
            this.CZa.put(this.klw, new SwitchAccountModel(this.klw, aA, aVx, ch.iFO.getString(this.klw, "last_logout_no_pwd_ticket"), Util.safeParseInt(aA2)));
        }
        if (this.CZa.size() == 0) {
            Intent intent2 = new Intent(this, MobileInputUI.class);
            intent2.putExtra("mobile_input_purpose", 1);
            intent2.putExtra("can_finish", true);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
            b.ke(this);
        }
        this.CYW.aG(this.CZa);
        if (this.scene == 1) {
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0);
            String string = sharedPreferences.getString("last_switch_account_to_wx_username", "");
            sharedPreferences.edit().putBoolean("transit_to_switch_account", false).commit();
            Log.i("MicroMsg.SettingsSwitchAccountUI", "switch to %s", string);
            if (!Util.isNullOrNil(string)) {
                g.aAf();
                if (com.tencent.mm.kernel.a.azo()) {
                    Log.w("MicroMsg.SettingsSwitchAccountUI", "already login ,quit");
                    finish();
                } else {
                    aNe(string);
                }
            } else {
                this.Deo = false;
                Intent intent3 = new Intent(this, MobileInputUI.class);
                intent3.putExtra("mobile_input_purpose", 1);
                intent3.putExtra("from_switch_account", true);
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                b.ke(this);
            }
        } else if (this.scene == 0) {
            this.CYW.setLastLoginWxUsername(this.klw);
        }
        this.CYW.eTN();
        eTv();
        this.CYW.setOnDeleteAvatarListener(new SwitchAccountGridView.c() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.c
            public final void aNh(final String str) {
                AppMethodBeat.i(74439);
                h.c(SettingsSwitchAccountUI.this, SettingsSwitchAccountUI.this.getString(R.string.guy, new Object[]{((SwitchAccountModel) SettingsSwitchAccountUI.this.CZa.get(str)).username}), SettingsSwitchAccountUI.this.getString(R.string.zb), SettingsSwitchAccountUI.this.getString(R.string.a0_), SettingsSwitchAccountUI.this.getString(R.string.x6), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.AnonymousClass6.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(74438);
                        Log.i("MicroMsg.SettingsSwitchAccountUI", "delete %s", str);
                        SettingsSwitchAccountUI.this.Dep = true;
                        ch.iFO.KH(str);
                        SettingsSwitchAccountUI.this.CZa.remove(str);
                        SwitchAccountGridView switchAccountGridView = SettingsSwitchAccountUI.this.CYW;
                        String str = str;
                        if (switchAccountGridView.Dgg.contains(str)) {
                            int indexOf = switchAccountGridView.Dgg.indexOf(str);
                            switchAccountGridView.Dgg.remove(str);
                            switchAccountGridView.Dgh.remove(indexOf);
                            switchAccountGridView.Dgi.remove(indexOf);
                        }
                        SettingsSwitchAccountUI.this.CYW.eTN();
                        SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
                        if (SettingsSwitchAccountUI.this.scene == 0) {
                            if (ch.iFO.aWo().size() > 0) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 1, 4, ch.iFO.aWp());
                                AppMethodBeat.o(74438);
                                return;
                            }
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 0, 4, ch.iFO.aWp());
                        }
                        AppMethodBeat.o(74438);
                    }
                }, null);
                AppMethodBeat.o(74439);
            }
        });
        this.Dem = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.Dem.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.AnonymousClass7 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(74440);
                SettingsSwitchAccountUI.this.CYW.setTranslationY((-((Float) valueAnimator.getAnimatedValue()).floatValue()) * ((float) SettingsSwitchAccountUI.this.CYW.getHeight()));
                AppMethodBeat.o(74440);
            }
        });
        this.Dem.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.AnonymousClass8 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(74441);
                Log.i("MicroMsg.SettingsSwitchAccountUI", "up animation end");
                Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(SettingsSwitchAccountUI.this);
                bZ.addFlags(67108864);
                SettingsSwitchAccountUI settingsSwitchAccountUI = SettingsSwitchAccountUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
                com.tencent.mm.hellhoundlib.a.a.a(settingsSwitchAccountUI, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$6", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                settingsSwitchAccountUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(settingsSwitchAccountUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$6", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                SettingsSwitchAccountUI.this.finish();
                b.kd(SettingsSwitchAccountUI.this);
                AppMethodBeat.o(74441);
            }
        });
        this.Dem.setDuration(500L);
        AppMethodBeat.o(74447);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(74449);
        if (i2 == 4) {
            goBack();
            AppMethodBeat.o(74449);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(74449);
        return onKeyDown;
    }

    private void aNe(String str) {
        AppMethodBeat.i(74450);
        SwitchAccountModel switchAccountModel = this.CZa.get(str);
        if (switchAccountModel != null && !this.Deo) {
            this.Deo = true;
            g.azz().a(new t(str, switchAccountModel.username, switchAccountModel.CXT, ""), 0);
            this.CYW.setSwitchToWxUsername(str);
            this.CYW.eTN();
            eTv();
        }
        AppMethodBeat.o(74450);
    }

    private void eTv() {
        AppMethodBeat.i(74451);
        if (this.Deo) {
            this.Dej.setVisibility(8);
            AppMethodBeat.o(74451);
        } else if (this.CZa.size() <= 1 && this.scene == 0) {
            this.Dej.setVisibility(8);
            this.Dcl = false;
            this.CYW.setDeleteState(false);
            AppMethodBeat.o(74451);
        } else if (!this.Dcl) {
            this.titleView.setText(R.string.gv2);
            this.Del.setVisibility(8);
            this.Dej.setText(getString(R.string.gv0));
            this.Dej.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.AnonymousClass9 */

                public final void onClick(View view) {
                    AppMethodBeat.i(74442);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!SettingsSwitchAccountUI.this.Dcl) {
                        SettingsSwitchAccountUI.this.Dcl = true;
                        SettingsSwitchAccountUI.this.CYW.setDeleteState(SettingsSwitchAccountUI.this.Dcl);
                        SettingsSwitchAccountUI.this.CYW.eTN();
                        SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
                        if (ch.iFO.aWo().size() > 1) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 1, 3, ch.iFO.aWp());
                        } else {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 0, 3, ch.iFO.aWp());
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(74442);
                }
            });
            AppMethodBeat.o(74451);
        } else {
            this.titleView.setText(R.string.gv0);
            this.Del.setVisibility(0);
            if (this.Dep) {
                this.Dej.setText(getString(R.string.vl));
                this.Dej.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.AnonymousClass10 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(74443);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        SettingsSwitchAccountUI.this.Dcl = false;
                        SettingsSwitchAccountUI.this.Dep = false;
                        SettingsSwitchAccountUI.this.CYW.setDeleteState(false);
                        SettingsSwitchAccountUI.this.CYW.eTN();
                        SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
                        if (SettingsSwitchAccountUI.this.CYW.getAccountCount() == 0) {
                            if (ch.iFO.aWo().size() > 1) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 1, 11, ch.iFO.aWp());
                            } else {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 0, 11, ch.iFO.aWp());
                            }
                            Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(SettingsSwitchAccountUI.this);
                            bZ.addFlags(67108864);
                            SettingsSwitchAccountUI settingsSwitchAccountUI = SettingsSwitchAccountUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
                            com.tencent.mm.hellhoundlib.a.a.a(settingsSwitchAccountUI, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            settingsSwitchAccountUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(settingsSwitchAccountUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            SettingsSwitchAccountUI.this.finish();
                            b.kd(SettingsSwitchAccountUI.this);
                            SettingsSwitchAccountUI.this.Deo = false;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(74443);
                    }
                });
                AppMethodBeat.o(74451);
                return;
            }
            this.Dej.setText(getString(R.string.sz));
            this.Dej.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.AnonymousClass11 */

                public final void onClick(View view) {
                    AppMethodBeat.i(74444);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    SettingsSwitchAccountUI.this.Dcl = false;
                    SettingsSwitchAccountUI.this.Dep = false;
                    SettingsSwitchAccountUI.this.CYW.setDeleteState(false);
                    SettingsSwitchAccountUI.this.CYW.eTN();
                    SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(74444);
                }
            });
            AppMethodBeat.o(74451);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(74452);
        super.onResume();
        Log.i("MicroMsg.SettingsSwitchAccountUI", "onResume");
        f.e(true, true, true);
        if (this.scene == 1 || this.scene == 2) {
            g.azz().a(701, this);
            g.azz().a(252, this);
        }
        if (this.scene == 0) {
            g.azz().a(281, this);
            g.azz().a(282, this);
            g.azz().a(255, this);
        }
        this.CYW.eTN();
        eTv();
        if ((this.scene == 1 || this.scene == 2) && g.aAc() && g.aAf().hpY) {
            Log.i("MicroMsg.SettingsSwitchAccountUI", "account initialized");
            this.Deo = true;
            Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
            bZ.addFlags(67108864);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
            b.kd(this);
        }
        AppMethodBeat.o(74452);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(74453);
        super.onStop();
        Log.i("MicroMsg.SettingsSwitchAccountUI", "onStop");
        f.e(false, true, true);
        if (this.scene == 1) {
            SwitchAccountGridView switchAccountGridView = this.CYW;
            if (switchAccountGridView.jUE) {
                switchAccountGridView.jUE = false;
                if (switchAccountGridView.Dgf != null) {
                    switchAccountGridView.Dgf.end();
                }
            }
        }
        g.azz().b(701, this);
        g.azz().b(252, this);
        g.azz().b(281, this);
        g.azz().b(282, this);
        g.azz().b(255, this);
        AppMethodBeat.o(74453);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(74454);
        Log.i("MicroMsg.SettingsSwitchAccountUI", "errCode %d, errMsg %s, scene %s, type  %d, this %s", Integer.valueOf(i3), str, qVar, Integer.valueOf(qVar.getType()), this);
        if (qVar.getType() == 252 || qVar.getType() == 701) {
            if (i2 == 0 && i3 == 0) {
                this.tql.setVisibility(4);
                this.Dek.setVisibility(4);
                SwitchAccountGridView switchAccountGridView = this.CYW;
                if (!switchAccountGridView.jUE) {
                    if (switchAccountGridView.Dgf == null && !Util.isNullOrNil(switchAccountGridView.Dge)) {
                        int min = Math.min(2, switchAccountGridView.Dgg.size());
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(min) {
                            /* class com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.AnonymousClass4 */
                            final /* synthetic */ int Dgo;

                            {
                                this.Dgo = r2;
                            }

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AppMethodBeat.i(74641);
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                Log.i("MicroMsg.SwitchAccountGridView", "value %f", Float.valueOf(floatValue));
                                for (int i2 = 0; i2 < this.Dgo; i2++) {
                                    if (!((String) SwitchAccountGridView.this.Dgg.get(i2)).equals(SwitchAccountGridView.this.Dge)) {
                                        ((View) SwitchAccountGridView.this.Dgi.get(i2)).setAlpha(1.0f - floatValue);
                                    }
                                }
                                if (this.Dgo < SwitchAccountGridView.this.getChildCount()) {
                                    ((View) SwitchAccountGridView.this.Dgi.get(this.Dgo)).setTranslationX(((float) ((View) SwitchAccountGridView.this.Dgi.get(this.Dgo)).getWidth()) * floatValue);
                                }
                                AppMethodBeat.o(74641);
                            }
                        });
                        ofFloat.setDuration(200L);
                        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(min) {
                            /* class com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.AnonymousClass5 */
                            final /* synthetic */ int Dgo;

                            {
                                this.Dgo = r2;
                            }

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AppMethodBeat.i(74642);
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                Log.i("MicroMsg.SwitchAccountGridView", "value %f", Float.valueOf(floatValue));
                                for (int i2 = 0; i2 < this.Dgo; i2++) {
                                    if (((String) SwitchAccountGridView.this.Dgg.get(i2)).equals(SwitchAccountGridView.this.Dge)) {
                                        ((View) SwitchAccountGridView.this.Dgi.get(i2)).setTranslationX(((float) (((SwitchAccountGridView.this.getWidth() / 2) - (((View) SwitchAccountGridView.this.Dgi.get(i2)).getWidth() * i2)) - (((View) SwitchAccountGridView.this.Dgi.get(i2)).getWidth() / 2))) * floatValue);
                                        AppMethodBeat.o(74642);
                                        return;
                                    }
                                }
                                AppMethodBeat.o(74642);
                            }
                        });
                        ofFloat2.setDuration(300L);
                        switchAccountGridView.Dgf = new AnimatorSet();
                        switchAccountGridView.Dgf.addListener(new AnimatorListenerAdapter() {
                            /* class com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.AnonymousClass6 */

                            public final void onAnimationEnd(Animator animator) {
                                AppMethodBeat.i(74643);
                                Log.i("MicroMsg.SwitchAccountGridView", "avatar animator end");
                                SwitchAccountGridView.this.jUE = false;
                                if (SwitchAccountGridView.this.Dgk != null) {
                                    SwitchAccountGridView.this.Dgk.eTz();
                                }
                                AppMethodBeat.o(74643);
                            }
                        });
                        switchAccountGridView.Dgf.playSequentially(ofFloat, ofFloat2);
                    }
                    if (switchAccountGridView.Dgf != null) {
                        switchAccountGridView.jUE = true;
                        switchAccountGridView.Dgf.start();
                    }
                }
                com.tencent.mm.kernel.a.unhold();
                l.boe();
                com.tencent.mm.platformtools.t.dr(this);
                if (ch.iFO.aWo().size() > 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 1, 0, ch.iFO.aWp());
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 0, 0, ch.iFO.aWp());
                }
                this.CYW.setOnAnimatorEndListener(new SwitchAccountGridView.a() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.a
                    public final void eTz() {
                        AppMethodBeat.i(74434);
                        SettingsSwitchAccountUI.this.CYW.setLastLoginWxUsername(z.aTY());
                        SettingsSwitchAccountUI.this.CYW.setSwitchToWxUsername("");
                        SettingsSwitchAccountUI.this.CYW.eTN();
                        SettingsSwitchAccountUI.this.Dem.start();
                        AppMethodBeat.o(74434);
                    }
                });
            } else {
                this.CYW.setSwitchToWxUsername("");
                this.Deo = false;
                h.cD(this, getString(R.string.gv1));
                String str2 = ((t) qVar).jjZ;
                if (!Util.isNullOrNil(str2) && this.CZa.containsKey(str2)) {
                    Intent intent = new Intent();
                    SwitchAccountModel switchAccountModel = this.CZa.get(str2);
                    Log.i("MicroMsg.SettingsSwitchAccountUI", "wxID %s, plugSwitch: %d", str2, Integer.valueOf(switchAccountModel.CXU));
                    if (WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned() || (switchAccountModel.CXU & 131072) == 0) {
                        intent.setClass(this, LoginPasswordUI.class);
                    } else {
                        intent.setClass(this, LoginVoiceUI.class);
                    }
                    intent.putExtra("switch_login_wx_id", str2);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    b.ke(this);
                }
                if (ch.iFO.aWo().size() > 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 1, 1, ch.iFO.aWp());
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 0, 1, ch.iFO.aWp());
                }
            }
        }
        if (qVar.getType() == 255) {
            if (((u) qVar).jkh == 2) {
                if (i2 == 0 && i3 == 0) {
                    eTw();
                    AppMethodBeat.o(74454);
                    return;
                } else if (i3 == -3 && i2 == 4) {
                    if (ch.iFO.aWo().size() > 1) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 1, 7, ch.iFO.aWp());
                    } else {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 0, 7, ch.iFO.aWp());
                    }
                    Intent intent2 = new Intent(getContext(), RegByMobileSetPwdUI.class);
                    intent2.putExtra("kintent_hint", getString(R.string.fzz));
                    startActivityForResult(intent2, 701);
                    AppMethodBeat.o(74454);
                    return;
                } else if (c.jRu.a(this, i2, i3, str)) {
                    AppMethodBeat.o(74454);
                    return;
                }
            }
        } else if (qVar.getType() == 282) {
            g.aAf();
            if (com.tencent.mm.kernel.a.azo()) {
                String str3 = ((ckc) ((s) qVar).rr.iLL.iLR).MpB;
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(str3 == null ? -1 : str3.length());
                Log.d("MicroMsg.SettingsSwitchAccountUI", "logout return noPwdTicket[%s]", objArr);
                if (Util.isNullOrNil(str3)) {
                    Log.i("MicroMsg.SettingsSwitchAccountUI", "no pwd ticket is null!");
                }
                String aTY = z.aTY();
                Log.i("MicroMsg.SettingsSwitchAccountUI", "logout return username[%s]", aTY);
                ch.iFO.l(aTY, "last_logout_no_pwd_ticket", str3);
                if (this.Den != null && !this.Den.stopped()) {
                    this.Den.stopTimer();
                    eTx();
                }
            }
        }
        AppMethodBeat.o(74454);
    }

    private void goBack() {
        AppMethodBeat.i(74455);
        Log.i("MicroMsg.SettingsSwitchAccountUI", "go back");
        if (this.scene == 2 || this.scene == 1) {
            Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
            bZ.addFlags(67108864);
            bZ.putExtra("can_finish", true);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
            b.kd(this);
            this.Deo = false;
            AppMethodBeat.o(74455);
            return;
        }
        finish();
        AppMethodBeat.o(74455);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74456);
        super.onDestroy();
        try {
            unregisterReceiver(this.Deq);
            AppMethodBeat.o(74456);
        } catch (Exception e2) {
            AppMethodBeat.o(74456);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.br_;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(74457);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 701 && i3 == -1) {
            eTw();
        }
        AppMethodBeat.o(74457);
    }

    private static void logout() {
        AppMethodBeat.i(74458);
        if (!(g.azz() == null || g.azz().iMw == null)) {
            g.azz().iMw.fz(false);
        }
        EventCenter.instance.publish(new hd());
        g.aAf();
        Log.w("MicroMsg.SettingsSwitchAccountUI", "dklogout User LOGOUT Now uin:%d , clear cookie", Integer.valueOf(com.tencent.mm.kernel.a.getUin()));
        com.tencent.mm.modelstat.c.bgb().commitNow();
        ((e) g.af(e.class)).logout();
        u uVar = new u(2);
        uVar.jkg = 1;
        g.azz().a(uVar, 0);
        AppMethodBeat.o(74458);
    }

    private void eTw() {
        AppMethodBeat.i(74459);
        if (com.tencent.mm.kernel.a.qd(g.aAf().hpS)) {
            g.azz().a(new ae(2), 0);
        }
        g.azz().a(new s(), 0);
        this.CYW.setLogoutState(true);
        this.CYW.eTN();
        if (this.Den == null) {
            this.Den = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.AnonymousClass3 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(74435);
                    SettingsSwitchAccountUI.j(SettingsSwitchAccountUI.this);
                    AppMethodBeat.o(74435);
                    return false;
                }
            }, false);
            this.Den.startTimer(8000);
        }
        AppMethodBeat.o(74459);
    }

    private void eTx() {
        AppMethodBeat.i(74460);
        Log.i("MicroMsg.SettingsSwitchAccountUI", "switch account logout");
        c.jRu.Xe();
        this.kaq.setVisibility(8);
        this.Dej.setVisibility(8);
        ma maVar = new ma();
        maVar.dRA.status = 0;
        maVar.dRA.bDZ = 0;
        EventCenter.instance.publish(maVar);
        ad adVar = new ad();
        adVar.dDb.dDc = true;
        EventCenter.instance.publish(adVar);
        MMEntryLock.unlock("show_whatsnew");
        com.tencent.mm.kernel.l.s(this, true);
        com.tencent.mm.platformtools.t.Q(this, null);
        if (g.aAc()) {
            bf.iDu.Km(com.tencent.mm.aj.c.Me(z.aTY()));
        }
        Log.i("MicroMsg.SettingsSwitchAccountUI", "last login username in sp %s", bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, ""));
        Map<String, String> aUS = z.aUS();
        if (Util.isNullOrNil(aUS.get(WXUtil.LAST_LOGIN_USERNAME))) {
            aUS.put(WXUtil.LAST_LOGIN_USERNAME, bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, ""));
        }
        ch.iFO.h(z.aTY(), aUS);
        MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", true).commit();
        aNf(z.aTY());
        AppMethodBeat.o(74460);
    }

    private void aNf(String str) {
        AppMethodBeat.i(74461);
        registerReceiver(this.Deq, new IntentFilter("action_kill_mm_process"));
        Intent intent = new Intent(this, FakeSwitchAccountUI.class);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.addAll(this.CZa.values());
        intent.putParcelableArrayListExtra("key_switch_account_users", arrayList);
        intent.putExtra("key_switch_from_wx_username", str);
        MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("transit_to_switch_account", true).commit();
        String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this);
        float ez = com.tencent.mm.cb.a.ez(this);
        intent.putExtra("key_langauage_code", loadApplicationLanguage);
        intent.putExtra("key_font_scale_size", ez);
        Log.i("MicroMsg.SettingsSwitchAccountUI", "mm pid %d", Integer.valueOf(Process.myPid()));
        intent.putExtra("key_mm_process_pid", Process.myPid());
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        b.ke(this);
        AppMethodBeat.o(74461);
    }

    static /* synthetic */ void a(SettingsSwitchAccountUI settingsSwitchAccountUI, String str) {
        AppMethodBeat.i(74462);
        Log.i("MicroMsg.SettingsSwitchAccountUI", "switch to %s, current %s", str, settingsSwitchAccountUI.klw);
        if (!str.equals(settingsSwitchAccountUI.klw)) {
            logout();
            MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putString("last_switch_account_to_wx_username", str).commit();
            AppMethodBeat.o(74462);
            return;
        }
        settingsSwitchAccountUI.finish();
        AppMethodBeat.o(74462);
    }
}
