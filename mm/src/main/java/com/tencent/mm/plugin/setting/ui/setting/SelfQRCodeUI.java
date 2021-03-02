package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.FileObserver;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.b.a.ks;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.appbrand.jsapi.k.w;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.protocal.protobuf.chc;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.o;

@i
public class SelfQRCodeUI extends MMSecDataActivity implements com.tencent.mm.ak.i {
    private static final String PATH = (g.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/");
    private ImageView CYP = null;
    private byte[] CYQ = null;
    private boolean CZB = false;
    private LinearLayout CZC;
    private b CZD;
    private ProgressDialog gtM = null;
    private Bitmap iKs = null;
    private ImageView nnL = null;
    private TextView pvG = null;
    private long qAb;
    private String userName = "";
    private TextView vIf = null;

    /* access modifiers changed from: package-private */
    public interface a {
        byte[] eSN();

        String eSO();

        String eSP();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SelfQRCodeUI selfQRCodeUI, int i2) {
        AppMethodBeat.i(256483);
        selfQRCodeUI.Xo(i2);
        AppMethodBeat.o(256483);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bq6;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73966);
        super.onCreate(bundle);
        hideActionbarLine();
        this.CZD = new b(this);
        this.CZD.start();
        com.tencent.mm.kernel.g.azz().a(168, this);
        com.tencent.mm.kernel.g.azz().a(w.CTRL_INDEX, this);
        initView();
        this.CYP.post(new Runnable() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(73952);
                int width = SelfQRCodeUI.this.CYP.getWidth();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SelfQRCodeUI.this.CYP.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = width;
                SelfQRCodeUI.this.CYP.setLayoutParams(layoutParams);
                AppMethodBeat.o(73952);
            }
        });
        SecDataUIC.a aVar = SecDataUIC.CWq;
        chc chc = (chc) SecDataUIC.a.b(this, 3, chc.class);
        if (chc != null && "launch_type_my_qrcode".equals(chc.Mmm)) {
            ks ksVar = new ks();
            ksVar.elF = 3;
            ksVar.eXj = 1;
            ksVar.bfK();
            com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
            com.tencent.mm.util.b.a(ksVar);
        }
        AppMethodBeat.o(73966);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(73967);
        com.tencent.mm.kernel.g.azz().b(168, this);
        com.tencent.mm.kernel.g.azz().b(w.CTRL_INDEX, this);
        if (this.CZD != null) {
            this.CZD.stop();
        }
        if (this.iKs != null && !this.iKs.isRecycled()) {
            Log.i("MicroMsg.SelfQRCodeNewUI", "bitmap recycle %s", this.iKs.toString());
            this.iKs.recycle();
        }
        super.onDestroy();
        AppMethodBeat.o(73967);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(73968);
        super.onResume();
        if (ab.Iw(this.userName) || com.tencent.mm.al.g.Ng(this.userName)) {
            AppMethodBeat.o(73968);
            return;
        }
        View findViewById = findViewById(R.id.hjp);
        this.qAb = z.aUd();
        Log.d("MicroMsg.SelfQRCodeNewUI", (this.qAb & 2) + ",extstatus:" + this.qAb);
        if ((this.qAb & 2) != 0) {
            findViewById.setVisibility(0);
            this.CYP.setAlpha(0.1f);
            findViewById(R.id.hjo).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.AnonymousClass10 */

                public final void onClick(View view) {
                    AppMethodBeat.i(73957);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    c.V(SelfQRCodeUI.this, "setting", ".ui.setting.SettingsAddMeUI");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(73957);
                }
            });
            AppMethodBeat.o(73968);
            return;
        }
        findViewById.setVisibility(8);
        this.CYP.setAlpha(1.0f);
        AppMethodBeat.o(73968);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        String str;
        AppMethodBeat.i(73969);
        this.userName = getIntent().getStringExtra("from_userName");
        if (Util.isNullOrNil(this.userName)) {
            this.userName = z.aTY();
        }
        if (z.aTY().equals(this.userName)) {
            this.CZB = true;
        }
        if (ab.Iw(this.userName)) {
            setMMTitle(R.string.gtf);
            ((TextView) findViewById(R.id.goj)).setText("");
            enableOptionMenu(false);
        } else if (com.tencent.mm.al.g.Ng(this.userName)) {
            setMMTitle(R.string.bxp);
            ((TextView) findViewById(R.id.goj)).setText(R.string.bxq);
            enableOptionMenu(false);
        } else {
            setMMTitle(R.string.gt4);
        }
        this.CZC = (LinearLayout) findViewById(R.id.go5);
        this.CYP = (ImageView) findViewById(R.id.hjm);
        this.nnL = (ImageView) findViewById(R.id.dod);
        this.pvG = (TextView) findViewById(R.id.fz8);
        this.vIf = (TextView) findViewById(R.id.brq);
        this.CZC.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.AnonymousClass7 */

            public final boolean onPreDraw() {
                AppMethodBeat.i(73954);
                SelfQRCodeUI.this.CZC.getViewTreeObserver().removeOnPreDrawListener(this);
                int fromDPToPix = at.fromDPToPix(SelfQRCodeUI.this.getContext(), 500);
                if (SelfQRCodeUI.this.CZC.getWidth() > fromDPToPix) {
                    ViewGroup.LayoutParams layoutParams = SelfQRCodeUI.this.CZC.getLayoutParams();
                    layoutParams.width = fromDPToPix;
                    SelfQRCodeUI.this.CZC.setLayoutParams(layoutParams);
                }
                AppMethodBeat.o(73954);
                return true;
            }
        });
        if (!ab.Iw(this.userName) && !com.tencent.mm.al.g.Ng(this.userName)) {
            String str2 = (String) com.tencent.mm.kernel.g.aAh().azQ().get(42, (Object) null);
            String string = getString(R.string.v1);
            if (!Util.isNullOrNil(str2)) {
                str = string + str2;
            } else {
                String str3 = (String) com.tencent.mm.kernel.g.aAh().azQ().get(2, (Object) null);
                as.bjx(str3);
                str = string + str3;
            }
            Log.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", str);
            if (this.iKs == null) {
                Log.d("MicroMsg.SelfQRCodeNewUI", "%s", "bitmap == null");
                Xo(1);
            } else {
                this.CYP.setImageBitmap(this.iKs);
            }
            a.b.c(this.nnL, z.aTY());
            String str4 = (String) com.tencent.mm.kernel.g.aAh().azQ().get(4, (Object) null);
            Log.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", str4);
            this.pvG.setText(l.e((Context) this, (CharSequence) str4, com.tencent.mm.cb.a.aG(getContext(), R.dimen.hc)));
            bz aWj = bz.aWj();
            String nullAsNil = Util.nullAsNil(aWj.getProvince());
            String str5 = aa.It(nullAsNil) + " " + Util.nullAsNil(aWj.getCity());
            Log.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", str5);
            this.vIf.setText(str5);
            switch (Util.nullAs((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(12290, (Object) null), 0)) {
                case 1:
                    this.pvG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.tencent.mm.cb.a.l(this, R.raw.ic_sex_male), (Drawable) null);
                    break;
                case 2:
                    this.pvG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.tencent.mm.cb.a.l(this, R.raw.ic_sex_female), (Drawable) null);
                    break;
            }
        } else {
            Xo(1);
            a.b.c(this.nnL, this.userName);
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.userName);
            this.pvG.setSingleLine(false);
            this.pvG.setMaxLines(3);
            if (ab.Iz(this.userName)) {
                this.pvG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.raw.open_im_main_logo), (Drawable) null);
            } else {
                this.pvG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (Kn != null) {
                String str6 = Kn.field_nickname;
                if (Util.isNullOrNil(str6)) {
                    str6 = ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Ke(this.userName).field_displayname;
                }
                this.pvG.setText(l.b(this, str6, this.pvG.getTextSize()));
            } else {
                this.pvG.setVisibility(8);
            }
            this.vIf.setVisibility(8);
        }
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.AnonymousClass8 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73955);
                SelfQRCodeUI.c(SelfQRCodeUI.this);
                AppMethodBeat.o(73955);
                return true;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.AnonymousClass9 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73956);
                SelfQRCodeUI.this.hideVKB();
                SelfQRCodeUI.this.finish();
                AppMethodBeat.o(73956);
                return true;
            }
        });
        AppMethodBeat.o(73969);
    }

    private void Xo(int i2) {
        int i3;
        final q qVar;
        AppMethodBeat.i(73970);
        if (this.CZB) {
            i3 = Util.nullAsNil((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(66561, (Object) null));
        } else {
            i3 = 0;
        }
        if (ab.Iy(this.userName)) {
            qVar = new com.tencent.mm.openim.b.g(this.userName);
            com.tencent.mm.kernel.g.azz().a(qVar, 0);
        } else {
            com.tencent.mm.bc.a aVar = new com.tencent.mm.bc.a(this.userName, i3, i2);
            com.tencent.mm.kernel.g.azz().a(aVar, 0);
            qVar = aVar;
        }
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.gtM = h.a((Context) context, getString(R.string.gj7), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.AnonymousClass13 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(256480);
                com.tencent.mm.kernel.g.azz().a(qVar);
                if (ab.Iw(SelfQRCodeUI.this.userName) || com.tencent.mm.al.g.Ng(SelfQRCodeUI.this.userName)) {
                    SelfQRCodeUI.this.finish();
                }
                AppMethodBeat.o(256480);
            }
        });
        AppMethodBeat.o(73970);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(73971);
        Log.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (qVar instanceof com.tencent.mm.bc.a) {
            final com.tencent.mm.bc.a aVar = (com.tencent.mm.bc.a) qVar;
            a(i2, i3, str, new a() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.a
                public final byte[] eSN() {
                    return aVar.jhH;
                }

                @Override // com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.a
                public final String eSO() {
                    return aVar.jhF;
                }

                @Override // com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.a
                public final String eSP() {
                    return aVar.jhG;
                }
            });
            AppMethodBeat.o(73971);
            return;
        }
        if (qVar instanceof com.tencent.mm.openim.b.g) {
            brn brn = (brn) ((d) ((com.tencent.mm.openim.b.g) qVar).getReqResp()).iLL.iLR;
            final byte[] bArr = brn.LYR.zy;
            final String str2 = brn.KDA;
            a(i2, i3, str, new a() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.a
                public final byte[] eSN() {
                    return bArr;
                }

                @Override // com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.a
                public final String eSO() {
                    return str2;
                }

                @Override // com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.a
                public final String eSP() {
                    return str2;
                }
            });
        }
        AppMethodBeat.o(73971);
    }

    private void a(int i2, int i3, String str, a aVar) {
        AppMethodBeat.i(73972);
        if (com.tencent.mm.plugin.setting.c.jRu.b(getContext(), i2, i3, str)) {
            AppMethodBeat.o(73972);
        } else if (i2 == 0 && i3 == 0) {
            this.CYQ = aVar.eSN();
            this.iKs = BitmapUtil.decodeByteArray(this.CYQ);
            if (ab.Iw(this.userName) || com.tencent.mm.al.g.Ng(this.userName)) {
                enableOptionMenu(true);
                String eSO = aVar.eSO();
                if (!Util.isNullOrNil(eSO)) {
                    ((TextView) findViewById(R.id.goj)).setText(eSO);
                }
            } else if (this.CZB) {
                String eSP = aVar.eSP();
                TextView textView = (TextView) findViewById(R.id.ioz);
                View view = (View) textView.getParent();
                if (!Util.isNullOrNil(eSP)) {
                    textView.setText(eSP);
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.AnonymousClass6 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(256477);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            SelfQRCodeUI.h(SelfQRCodeUI.this);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(256477);
                        }
                    });
                    view.setVisibility(0);
                } else {
                    view.setVisibility(8);
                }
            }
            this.CYP.setImageBitmap(this.iKs);
            AppMethodBeat.o(73972);
        } else {
            Toast.makeText(this, getString(R.string.dg5, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
            AppMethodBeat.o(73972);
        }
    }

    public static void eSM() {
        AppMethodBeat.i(73973);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 14, 1, true);
        AppMethodBeat.o(73973);
    }

    static {
        AppMethodBeat.i(73978);
        AppMethodBeat.o(73978);
    }

    public class b extends FileObserver {
        private MMActivity CZH;
        private String CZI;

        public b(MMActivity mMActivity) {
            super(SelfQRCodeUI.PATH, 8);
            AppMethodBeat.i(73962);
            this.CZH = mMActivity;
            AppMethodBeat.o(73962);
        }

        public final void onEvent(int i2, String str) {
            AppMethodBeat.i(73963);
            if (str != null && i2 == 8 && (this.CZI == null || !str.equalsIgnoreCase(this.CZI))) {
                this.CZI = str;
                FileProviderHelper.getUriForFile(SelfQRCodeUI.this.getContext(), new o(SelfQRCodeUI.PATH + str));
                SelfQRCodeUI.eSM();
                Log.i("MicroMsg.SelfQRCodeNewUI$ScreenshotObserver", "Send event to listener.");
            }
            AppMethodBeat.o(73963);
        }

        public final void start() {
            AppMethodBeat.i(73964);
            super.startWatching();
            AppMethodBeat.o(73964);
        }

        public final void stop() {
            AppMethodBeat.i(73965);
            super.stopWatching();
            AppMethodBeat.o(73965);
        }
    }

    static /* synthetic */ void c(SelfQRCodeUI selfQRCodeUI) {
        AppMethodBeat.i(73974);
        e eVar = new e((Context) selfQRCodeUI, 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.AnonymousClass14 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(256481);
                boolean Iw = ab.Iw(SelfQRCodeUI.this.userName);
                boolean Ng = com.tencent.mm.al.g.Ng(SelfQRCodeUI.this.userName);
                if (!Ng && !Iw) {
                    mVar.kV(2, R.string.gj4);
                }
                mVar.kV(1, R.string.gj8);
                if (!Ng) {
                    mVar.kV(3, R.string.gjn);
                }
                if (SelfQRCodeUI.this.CZB) {
                    mVar.kV(4, R.string.gjm);
                }
                AppMethodBeat.o(256481);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(256475);
                switch (menuItem.getItemId()) {
                    case 1:
                        SelfQRCodeUI.g(SelfQRCodeUI.this);
                        AppMethodBeat.o(256475);
                        return;
                    case 2:
                        SelfQRCodeUI.a(SelfQRCodeUI.this, 0);
                        AppMethodBeat.o(256475);
                        return;
                    case 3:
                        if (!com.tencent.mm.q.a.o(SelfQRCodeUI.this.getContext(), true)) {
                            SelfQRCodeUI.this.getContext();
                            if (!com.tencent.mm.bh.e.bgF() && !com.tencent.mm.q.a.r(SelfQRCodeUI.this.getContext(), true)) {
                                c.V(SelfQRCodeUI.this.getContext(), "scanner", ".ui.BaseScanUI");
                                AppMethodBeat.o(256475);
                                return;
                            }
                        }
                        break;
                    case 4:
                        SelfQRCodeUI.h(SelfQRCodeUI.this);
                        break;
                }
                AppMethodBeat.o(256475);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(73974);
    }

    static /* synthetic */ void g(SelfQRCodeUI selfQRCodeUI) {
        AppMethodBeat.i(256482);
        p.a(selfQRCodeUI, new Runnable() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.AnonymousClass11 */

            /* JADX WARNING: Removed duplicated region for block: B:30:0x00cd A[SYNTHETIC, Splitter:B:30:0x00cd] */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x00dd A[SYNTHETIC, Splitter:B:38:0x00dd] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 241
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.AnonymousClass11.run():void");
            }
        }, new Runnable() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(256479);
                Toast.makeText(SelfQRCodeUI.this, (int) R.string.gao, 1).show();
                AppMethodBeat.o(256479);
            }
        });
        AppMethodBeat.o(256482);
    }

    static /* synthetic */ void h(SelfQRCodeUI selfQRCodeUI) {
        AppMethodBeat.i(256484);
        h.a((Context) selfQRCodeUI, true, selfQRCodeUI.getString(R.string.g5q), selfQRCodeUI.getString(R.string.g5r), selfQRCodeUI.getString(R.string.g5s), selfQRCodeUI.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(256476);
                SelfQRCodeUI.a(SelfQRCodeUI.this, 2);
                AppMethodBeat.o(256476);
            }
        }, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(256484);
    }
}
