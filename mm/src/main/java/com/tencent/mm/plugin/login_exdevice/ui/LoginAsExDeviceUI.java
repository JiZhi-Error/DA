package com.tencent.mm.plugin.login_exdevice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.network.d;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.login_exdevice.a.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.protobuf.bpy;
import com.tencent.mm.protocal.protobuf.ckg;
import com.tencent.mm.protocal.protobuf.dge;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;

public class LoginAsExDeviceUI extends MMActivity implements i {
    private String UUID;
    private ProgressDialog klA;
    private x kmF = new x();
    private ImageView yOA;
    private TextView yOB;
    private ImageView yOC;
    private TextView yOD;
    private Button yOE;
    private Button yOF;
    private TextView yOG;
    private byte[] yOH;
    private int yOI = 200;
    private ImageView yOu;
    private ImageView yOv;
    private Button yOw;
    private View yOx;
    private View yOy;
    private View yOz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LoginAsExDeviceUI() {
        AppMethodBeat.i(231749);
        AppMethodBeat.o(231749);
    }

    static /* synthetic */ void a(LoginAsExDeviceUI loginAsExDeviceUI) {
        AppMethodBeat.i(231763);
        loginAsExDeviceUI.goBack();
        AppMethodBeat.o(231763);
    }

    static /* synthetic */ void e(LoginAsExDeviceUI loginAsExDeviceUI) {
        AppMethodBeat.i(231764);
        loginAsExDeviceUI.eeo();
        AppMethodBeat.o(231764);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(231750);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(231750);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        String str = null;
        AppMethodBeat.i(231751);
        this.yOx = findViewById(R.id.esd);
        this.yOu = (ImageView) this.yOx.findViewById(R.id.erm);
        this.yOw = (Button) this.yOx.findViewById(R.id.erl);
        this.yOG = (TextView) this.yOx.findViewById(R.id.erj);
        this.yOv = (ImageView) this.yOx.findViewById(R.id.goi);
        this.yOy = findViewById(R.id.es4);
        this.yOC = (ImageView) this.yOy.findViewById(R.id.es6);
        this.yOD = (TextView) this.yOy.findViewById(R.id.es7);
        this.yOE = (Button) this.yOy.findViewById(R.id.es5);
        this.yOF = (Button) this.yOy.findViewById(R.id.iez);
        this.yOz = findViewById(R.id.eri);
        this.yOA = (ImageView) this.yOz.findViewById(R.id.ery);
        this.yOB = (TextView) this.yOz.findViewById(R.id.erz);
        setActionbarColor(getResources().getColor(R.color.f3045c));
        hideActionbarLine();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.login_exdevice.ui.LoginAsExDeviceUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(231738);
                LoginAsExDeviceUI.a(LoginAsExDeviceUI.this);
                AppMethodBeat.o(231738);
                return true;
            }
        }, R.raw.actionbar_icon_close_black);
        if (Util.isNullOrNil(null, null, null, null) || !str.equals(null)) {
            setMMTitle(getResources().getString(R.string.elk));
            eeo();
            AppMethodBeat.o(231751);
            return;
        }
        setMMTitle(getResources().getString(R.string.emf));
        this.yOx.setVisibility(8);
        this.yOy.setVisibility(0);
        Bitmap Mq = e.Mq(null);
        if (Mq != null) {
            this.yOC.setImageBitmap(Mq);
        }
        if (!Util.isNullOrNil((String) null)) {
            this.yOD.setText(l.c(getContext(), null));
        } else {
            this.yOD.setText((CharSequence) null);
        }
        this.yOE.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.login_exdevice.ui.LoginAsExDeviceUI.AnonymousClass3 */
            final /* synthetic */ String yOK = null;
            final /* synthetic */ String yOL = null;

            public final void onClick(View view) {
                AppMethodBeat.i(231740);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.azz().a(new c(this.yOK, Base64.decode(this.yOL, 0)), 0);
                if (LoginAsExDeviceUI.this.klA != null) {
                    LoginAsExDeviceUI.this.klA.dismiss();
                }
                LoginAsExDeviceUI.this.klA = h.a((Context) LoginAsExDeviceUI.this, LoginAsExDeviceUI.this.getString(R.string.ekc), true, (DialogInterface.OnCancelListener) null);
                a.a(this, "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231740);
            }
        });
        this.yOF.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.login_exdevice.ui.LoginAsExDeviceUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(231741);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LoginAsExDeviceUI.this.setMMTitle(LoginAsExDeviceUI.this.getResources().getString(R.string.elk));
                LoginAsExDeviceUI.this.yOx.setVisibility(0);
                LoginAsExDeviceUI.this.yOy.setVisibility(8);
                LoginAsExDeviceUI.e(LoginAsExDeviceUI.this);
                a.a(this, "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231741);
            }
        });
        AppMethodBeat.o(231751);
    }

    private void eeo() {
        AppMethodBeat.i(231752);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.login_exdevice.ui.LoginAsExDeviceUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(231742);
                g.azz().a(new com.tencent.mm.plugin.login_exdevice.a.b(), 0);
                if (LoginAsExDeviceUI.this.klA != null) {
                    LoginAsExDeviceUI.this.klA.dismiss();
                }
                LoginAsExDeviceUI.this.klA = h.a((Context) LoginAsExDeviceUI.this, LoginAsExDeviceUI.this.getString(R.string.ekc), true, (DialogInterface.OnCancelListener) null);
                AppMethodBeat.o(231742);
            }
        }, 0);
        AppMethodBeat.o(231752);
    }

    private void eep() {
        AppMethodBeat.i(231753);
        this.UUID = null;
        this.yOH = null;
        this.yOu.setImageResource(R.drawable.c29);
        this.yOu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.login_exdevice.ui.LoginAsExDeviceUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(231743);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LoginAsExDeviceUI.e(LoginAsExDeviceUI.this);
                a.a(this, "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231743);
            }
        });
        eer();
        AppMethodBeat.o(231753);
    }

    private void eeq() {
        long j2;
        AppMethodBeat.i(231754);
        Log.i("MicroMsg.LoginAsExDeviceUI", "doCheckLogin %s", Util.getStack());
        AnonymousClass8 r2 = new Runnable() {
            /* class com.tencent.mm.plugin.login_exdevice.ui.LoginAsExDeviceUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(231746);
                g.azz().a(new com.tencent.mm.plugin.login_exdevice.a.a(LoginAsExDeviceUI.this.UUID, LoginAsExDeviceUI.this.yOH), 0);
                AppMethodBeat.o(231746);
            }
        };
        if (this.yOI > 2000) {
            j2 = 2000;
        } else {
            int i2 = this.yOI + 200;
            this.yOI = i2;
            j2 = (long) i2;
        }
        MMHandlerThread.postToMainThreadDelayed(r2, j2);
        AppMethodBeat.o(231754);
    }

    private void eer() {
        AppMethodBeat.i(231755);
        if (Util.isNullOrNil(this.UUID) || this.yOH == null) {
            this.yOw.setVisibility(0);
            if (this.yOG != null) {
                this.yOG.setVisibility(8);
            }
            if (this.yOv != null) {
                this.yOv.setVisibility(0);
            }
            this.yOw.setText(R.string.elg);
            this.yOw.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.login_exdevice.ui.LoginAsExDeviceUI.AnonymousClass9 */

                public final void onClick(View view) {
                    AppMethodBeat.i(231747);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    LoginAsExDeviceUI.e(LoginAsExDeviceUI.this);
                    a.a(this, "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(231747);
                }
            });
        } else {
            this.yOw.setText(R.string.em2);
            if (this.yOG != null) {
                this.yOG.setVisibility(0);
            }
            if (this.yOv != null) {
                this.yOv.setVisibility(8);
                AppMethodBeat.o(231755);
                return;
            }
        }
        AppMethodBeat.o(231755);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(231756);
        if (i2 == 4) {
            goBack();
            AppMethodBeat.o(231756);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(231756);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(231757);
        super.onResume();
        g.azz().a(502, this);
        g.azz().a(503, this);
        g.azz().a(701, this);
        g.azz().a(252, this);
        g.azz().a(com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.a.CTRL_INDEX, this);
        AppMethodBeat.o(231757);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(231758);
        g.azz().b(502, this);
        g.azz().b(503, this);
        g.azz().b(701, this);
        g.azz().b(252, this);
        g.azz().b(com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.a.CTRL_INDEX, this);
        super.onStop();
        AppMethodBeat.o(231758);
    }

    private void goBack() {
        AppMethodBeat.i(231759);
        finish();
        overridePendingTransition(R.anim.s, R.anim.f6do);
        AppMethodBeat.o(231759);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        AppMethodBeat.i(231760);
        int i2 = getResources().getConfiguration().orientation;
        if (BuildInfo.EX_DEVICE_LOGIN) {
            AppMethodBeat.o(231760);
            return R.layout.b2h;
        } else if (i2 == 2) {
            AppMethodBeat.o(231760);
            return R.layout.b2j;
        } else {
            AppMethodBeat.o(231760);
            return R.layout.b2i;
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        AppMethodBeat.i(231761);
        Log.i("MicroMsg.LoginAsExDeviceUI", "errType %d, errCode %d, errMsg %s, sceneType:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(qVar.getType()));
        if (this.klA != null) {
            this.klA.dismiss();
        }
        if (qVar.getType() == 502) {
            if (i2 == 0 && i3 == 0) {
                this.yOu.setImageBitmap(BitmapUtil.decodeByteArray(z.a(((bpy) ((com.tencent.mm.plugin.login_exdevice.a.b) qVar).hJu.iLL.iLR).LXP)));
                this.yOH = z.a(((bpy) ((com.tencent.mm.plugin.login_exdevice.a.b) qVar).hJu.iLL.iLR).LXR);
                this.UUID = ((bpy) ((com.tencent.mm.plugin.login_exdevice.a.b) qVar).hJu.iLL.iLR).UUID;
                Log.i("MicroMsg.LoginAsExDeviceUI", "get UUID %s", this.UUID);
                eer();
                this.yOI = 200;
                eeq();
                AppMethodBeat.o(231761);
                return;
            }
            Log.i("MicroMsg.LoginAsExDeviceUI", "get login qrcode failed!");
            eep();
            com.tencent.mm.plugin.report.service.h.INSTANCE.Ip(5);
            AppMethodBeat.o(231761);
        } else if (qVar.getType() == 503) {
            if (i2 == 0 && i3 == 0) {
                ckg een = ((com.tencent.mm.plugin.login_exdevice.a.a) qVar).een();
                if (een != null) {
                    Log.i("MicroMsg.LoginAsExDeviceUI", "uuid %s, UUID %s, imgurl:%s, nickName:%s, status:%s, expire %d", een.UUID, this.UUID, een.MpD, een.oUJ, Integer.valueOf(een.oTW), Integer.valueOf(een.KCC));
                    if (Util.isNullOrNil(een.UUID, this.UUID) || !this.UUID.equals(een.UUID)) {
                        Log.i("MicroMsg.LoginAsExDeviceUI", "check login qrcode failed! uuid invalid");
                        eep();
                        com.tencent.mm.plugin.report.service.h.INSTANCE.Ip(6);
                        AppMethodBeat.o(231761);
                        return;
                    }
                    switch (een.oTW) {
                        case 1:
                            this.yOz.setVisibility(0);
                            this.yOx.setVisibility(8);
                            this.yOy.setVisibility(8);
                            this.yOB.setText(een.oUJ);
                            if (!Util.isNullOrNil(een.MpD)) {
                                final String str3 = een.MpD;
                                com.tencent.f.h.RTc.aX(new Runnable() {
                                    /* class com.tencent.mm.plugin.login_exdevice.ui.LoginAsExDeviceUI.AnonymousClass7 */

                                    public final void run() {
                                        AppMethodBeat.i(231745);
                                        try {
                                            Bitmap decodeStream = BackwardSupportUtil.BitmapFactory.decodeStream(d.w(str3, 10000, com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT));
                                            if (decodeStream != null) {
                                                final Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(decodeStream, true, (float) at.aH(LoginAsExDeviceUI.this.getContext(), R.dimen.cb));
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.login_exdevice.ui.LoginAsExDeviceUI.AnonymousClass7.AnonymousClass1 */

                                                    public final void run() {
                                                        AppMethodBeat.i(231744);
                                                        LoginAsExDeviceUI.this.yOA.setImageBitmap(roundedCornerBitmap);
                                                        AppMethodBeat.o(231744);
                                                    }
                                                });
                                            }
                                            AppMethodBeat.o(231745);
                                        } catch (Exception e2) {
                                            Log.e("MicroMsg.LoginAsExDeviceUI", "download avatar failed");
                                            Log.printErrStackTrace("MicroMsg.LoginAsExDeviceUI", e2, "", new Object[0]);
                                            AppMethodBeat.o(231745);
                                        }
                                    }
                                });
                            }
                            eeq();
                            AppMethodBeat.o(231761);
                            return;
                        case 2:
                            String str4 = een.UserName;
                            String str5 = een.KQi;
                            if (!Util.isNullOrNil(een.UserName, een.KQi)) {
                                this.yOz.setVisibility(0);
                                this.yOx.setVisibility(8);
                                this.yOy.setVisibility(8);
                                g.azz().a(new t(str4, str5, 0, "", "", "", 0, "", true, false), 0);
                                if (this.klA != null) {
                                    this.klA.dismiss();
                                }
                                this.klA = h.a((Context) this, getString(R.string.emm), true, (DialogInterface.OnCancelListener) null);
                                AppMethodBeat.o(231761);
                                return;
                            }
                            Log.e("MicroMsg.LoginAsExDeviceUI", "login error when confirm, usename and pwd is empty or null");
                            AppMethodBeat.o(231761);
                            return;
                        case 3:
                            eep();
                            com.tencent.mm.plugin.report.service.h.INSTANCE.Ip(6);
                            AppMethodBeat.o(231761);
                            return;
                        default:
                            eeq();
                            AppMethodBeat.o(231761);
                            return;
                    }
                } else {
                    Log.i("MicroMsg.LoginAsExDeviceUI", "check login qrcode failed! loginnotify invalid");
                    eep();
                    com.tencent.mm.plugin.report.service.h.INSTANCE.Ip(6);
                    AppMethodBeat.o(231761);
                }
            } else {
                Log.i("MicroMsg.LoginAsExDeviceUI", "check login qrcode failed!");
                eep();
                com.tencent.mm.plugin.report.service.h.INSTANCE.Ip(6);
                AppMethodBeat.o(231761);
            }
        } else if (qVar.getType() == 252 || qVar.getType() == 701) {
            boolean z = false;
            if (i2 == 4 && (i3 == -16 || i3 == -17)) {
                z = true;
                bg.azz().a(new bu(new bu.a() {
                    /* class com.tencent.mm.plugin.login_exdevice.ui.LoginAsExDeviceUI.AnonymousClass10 */

                    @Override // com.tencent.mm.model.bu.a
                    public final void a(com.tencent.mm.network.g gVar) {
                        AppMethodBeat.i(231748);
                        if (gVar == null) {
                            AppMethodBeat.o(231748);
                            return;
                        }
                        bg.aVF();
                        gVar.aZh().a(new byte[0], new byte[0], new byte[0], com.tencent.mm.model.c.getUin());
                        AppMethodBeat.o(231748);
                    }
                }), 0);
            }
            if (z || (i2 == 0 && i3 == 0)) {
                bg.unhold();
                com.tencent.mm.plugin.account.friend.a.l.boe();
                String str6 = ((t) qVar).account;
                bf.iDu.aO("last_login_exdevice_weixin_username", str6);
                byte[] a2 = z.a(((j.g) ((t) qVar).iMO.getRespObj()).Kzw.Nky.KKZ);
                if (a2 != null && a2.length > 0) {
                    bf.iDu.aO("last_login_exdevice_auth_key", Base64.encodeToString(a2, 0));
                }
                if (!as.bjx(str6) || Util.isNullOrNil(((t) qVar).ajx())) {
                    str2 = str6;
                } else {
                    str2 = ((t) qVar).ajx();
                }
                y.St(str2);
                com.tencent.mm.platformtools.t.dr(this);
                this.kmF.b(this, new Runnable() {
                    /* class com.tencent.mm.plugin.login_exdevice.ui.LoginAsExDeviceUI.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(231739);
                        Intent bZ = com.tencent.mm.plugin.login_exdevice.a.jRt.bZ(LoginAsExDeviceUI.this);
                        bZ.addFlags(67108864);
                        LoginAsExDeviceUI loginAsExDeviceUI = LoginAsExDeviceUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
                        a.a(loginAsExDeviceUI, bl.axQ(), "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$10", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        loginAsExDeviceUI.startActivity((Intent) bl.pG(0));
                        a.a(loginAsExDeviceUI, "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$10", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        LoginAsExDeviceUI.this.finish();
                        LoginAsExDeviceUI.this.overridePendingTransition(R.anim.s, R.anim.s);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.Ip(7);
                        AppMethodBeat.o(231739);
                    }
                });
                AppMethodBeat.o(231761);
                return;
            }
            Log.i("MicroMsg.LoginAsExDeviceUI", "login failed!");
            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
            if (Dk == null || !Dk.a(this, null, null)) {
                eep();
                AppMethodBeat.o(231761);
                return;
            }
            AppMethodBeat.o(231761);
        } else {
            if (qVar.getType() == 654) {
                if (i2 == 0 && i3 == 0) {
                    this.UUID = ((dge) ((c) qVar).hJu.iLL.iLR).UUID;
                    this.yOH = z.a(((dge) ((c) qVar).hJu.iLL.iLR).LXR);
                    this.yOI = 200;
                    eeq();
                    AppMethodBeat.o(231761);
                    return;
                }
                Log.i("MicroMsg.LoginAsExDeviceUI", "push loginurl failed");
                setMMTitle(getResources().getString(R.string.elk));
                this.yOx.setVisibility(0);
                this.yOy.setVisibility(8);
                eep();
            }
            AppMethodBeat.o(231761);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(231762);
        this.kmF.a(this, i2, strArr, iArr);
        AppMethodBeat.o(231762);
    }
}
