package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.wy;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;

@a(3)
public class WebWXLogoutUI extends MMActivity implements i, bc {
    private IListener DLr = new IListener<wy>() {
        /* class com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.AnonymousClass9 */

        {
            AppMethodBeat.i(161475);
            this.__eventId = wy.class.getName().hashCode();
            AppMethodBeat.o(161475);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wy wyVar) {
            AppMethodBeat.i(30222);
            Log.d("MicroMsg.WebWXLogoutUI", "status Notify function");
            if (wyVar.edp.dJY == 8) {
                WebWXLogoutUI.this.finish();
            }
            AppMethodBeat.o(30222);
            return false;
        }
    };
    private ProgressDialog Dav = null;
    private ImageView EpU;
    private int GyC;
    private View JFA;
    private WeImageView JFB;
    private WeImageView JFC;
    private int JFD;
    private Animator JFE;
    private int JFF;
    private GridLayout JFG;
    private boolean JFq = false;
    private boolean JFy;
    private View JFz;
    private int Jmd;
    private boolean pPO;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WebWXLogoutUI() {
        AppMethodBeat.i(30223);
        AppMethodBeat.o(30223);
    }

    static /* synthetic */ void b(WebWXLogoutUI webWXLogoutUI, boolean z) {
        AppMethodBeat.i(30236);
        webWXLogoutUI.zC(z);
        AppMethodBeat.o(30236);
    }

    static /* synthetic */ boolean b(WebWXLogoutUI webWXLogoutUI) {
        AppMethodBeat.i(30237);
        boolean gjf = webWXLogoutUI.gjf();
        AppMethodBeat.o(30237);
        return gjf;
    }

    static /* synthetic */ void c(WebWXLogoutUI webWXLogoutUI, boolean z) {
        AppMethodBeat.i(30238);
        webWXLogoutUI.zB(z);
        AppMethodBeat.o(30238);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cc1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(30224);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.f6do);
        AppMethodBeat.o(30224);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30225);
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.JFF = getIntent().getIntExtra("intent.key.online_version", 0);
        }
        initView();
        overridePendingTransition(R.anim.dq, R.anim.s);
        bg.azz().a(281, this);
        bg.azz().a(l.CTRL_INDEX, this);
        bg.aVF();
        c.a(this);
        EventCenter.instance.addListener(this.DLr);
        AppMethodBeat.o(30225);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(30226);
        super.onPause();
        if (this.JFq && bg.aAc()) {
            bfx bfx = new bfx();
            bfx.LPB = 27;
            bfx.BsD = z.aqE() ? 1 : 2;
            bg.aVF();
            c.aSM().d(new k.a(23, bfx));
            this.JFq = false;
        }
        AppMethodBeat.o(30226);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(30227);
        super.onDestroy();
        overridePendingTransition(R.anim.s, R.anim.f6do);
        bg.azz().b(281, this);
        bg.azz().b(l.CTRL_INDEX, this);
        bg.aVF();
        c.b(this);
        EventCenter.instance.removeListener(this.DLr);
        AppMethodBeat.o(30227);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        AppMethodBeat.i(30228);
        setMMTitle("");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(30213);
                WebWXLogoutUI.this.finish();
                AppMethodBeat.o(30213);
                return true;
            }
        }, R.raw.actionbar_icon_close_black);
        if (!Util.isNullOrNil(o.jjL) && o.bfc() == 6) {
            addIconOptionMenu(10001, R.raw.icons_outlined_help, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.AnonymousClass2 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(30214);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", o.jjL + "&lang=" + LocaleUtil.getApplicationLanguage());
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", false);
                    com.tencent.mm.br.c.b(WebWXLogoutUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(30214);
                    return false;
                }
            });
        }
        hideActionbarLine();
        this.JFG = (GridLayout) findViewById(R.id.jl9);
        this.EpU = (ImageView) findViewById(R.id.i5e);
        if (!(7 == o.bfc()) || !o.bfi()) {
            z = false;
        } else {
            z = true;
        }
        if (!g.apN() || z) {
            this.JFG.removeView(findViewById(R.id.b42));
            this.JFy = false;
        } else {
            this.JFA = findViewById(R.id.jl6);
            this.JFC = (WeImageView) findViewById(R.id.du4);
            if (z.aqE()) {
                this.JFy = true;
            } else {
                this.JFy = false;
            }
            zC(this.JFy);
            this.JFA.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(30215);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    WebWXLogoutUI.this.JFy = !WebWXLogoutUI.this.JFy;
                    WebWXLogoutUI.b(WebWXLogoutUI.this, WebWXLogoutUI.this.JFy);
                    WebWXLogoutUI.b(WebWXLogoutUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(30215);
                }
            });
        }
        Log.i("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + o.bfg());
        if (!o.bfg()) {
            findViewById(R.id.er2).setVisibility(0);
            final Animator loadAnimator = AnimatorInflater.loadAnimator(this, R.animator.f3011f);
            loadAnimator.setTarget(findViewById(R.id.jld));
            this.JFE = AnimatorInflater.loadAnimator(this, R.animator.f3012g);
            this.JFE.setTarget(findViewById(R.id.jld));
            this.JFE.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.AnonymousClass4 */

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(30216);
                    super.onAnimationEnd(animator);
                    WebWXLogoutUI.c(WebWXLogoutUI.this, WebWXLogoutUI.this.pPO);
                    AppMethodBeat.o(30216);
                }
            });
            this.pPO = o.bfe();
            this.JFz = findViewById(R.id.jlb);
            this.JFB = (WeImageView) findViewById(R.id.dtz);
            zB(this.pPO);
            this.JFz.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(30217);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (WebWXLogoutUI.this.pPO) {
                        WebWXLogoutUI.this.JFz.setBackgroundResource(R.drawable.pb);
                        WebWXLogoutUI.this.JFB.setIconColor(WebWXLogoutUI.this.getResources().getColor(R.color.FG_0));
                    } else {
                        WebWXLogoutUI.this.JFz.setBackgroundResource(R.drawable.pc);
                        WebWXLogoutUI.this.JFB.setIconColor(WebWXLogoutUI.this.getResources().getColor(R.color.BW_100_Alpha_0_8));
                    }
                    WebWXLogoutUI.f(WebWXLogoutUI.this);
                    WebWXLogoutUI.this.findViewById(R.id.jld).setVisibility(0);
                    loadAnimator.start();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(30217);
                }
            });
        } else {
            this.JFG.removeView(findViewById(R.id.er2));
        }
        Log.i("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + o.bfh());
        if (!o.bfh()) {
            findViewById(R.id.jl8).setVisibility(0);
            findViewById(R.id.jl7).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(30218);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", "filehelper");
                    intent.putExtra("key_show_bottom_app_panel", true);
                    com.tencent.mm.plugin.webwx.a.jRt.d(intent, WebWXLogoutUI.this);
                    Log.d("MicroMsg.WebWXLogoutUI", "clicked file transfer bt, start filehelper");
                    WebWXLogoutUI.this.finish();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(30218);
                }
            });
        } else {
            this.JFG.removeView(findViewById(R.id.jl8));
        }
        gje();
        Button button = (Button) findViewById(R.id.jli);
        if (!Util.isNullOrNil(o.jjJ)) {
            button.setText(o.jjJ);
        }
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(30219);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.WebWXLogoutUI", "logout webwx");
                WebWXLogoutUI.g(WebWXLogoutUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30219);
            }
        });
        if (o.bfc() == 1) {
            Drawable drawable = getResources().getDrawable(R.raw.connect_pc);
            Drawable drawable2 = getResources().getDrawable(R.raw.connect_pc_mute);
            if (!(drawable == null || drawable2 == null)) {
                this.GyC = drawable.getIntrinsicWidth();
                this.JFD = drawable2.getIntrinsicWidth();
            }
        } else if (o.bfc() == 2) {
            Drawable drawable3 = getResources().getDrawable(R.raw.connect_mac);
            Drawable drawable4 = getResources().getDrawable(R.raw.connect_mac_mute);
            if (!(drawable3 == null || drawable4 == null)) {
                this.GyC = drawable3.getIntrinsicWidth();
                this.JFD = drawable4.getIntrinsicWidth();
            }
        }
        int eu = au.eu(getContext());
        int ay = au.ay(getContext());
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            getWindowManager().getDefaultDisplay().getSize(point);
        }
        int i2 = point.y;
        Log.d("MicroMsg.WebWXLogoutUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", Integer.valueOf(ay), Integer.valueOf(i2), Integer.valueOf(eu));
        this.Jmd = (((int) (((double) i2) / 4.0d)) - ay) - eu;
        updateStatus();
        AppMethodBeat.o(30228);
    }

    private void gje() {
        AppMethodBeat.i(30229);
        Log.i("MicroMsg.WebWXLogoutUI", "grid child count %d", Integer.valueOf(this.JFG.getChildCount()));
        if (this.JFG.getChildCount() > 1) {
            for (int i2 = 0; i2 < this.JFG.getChildCount(); i2++) {
                GridLayout.LayoutParams layoutParams = (GridLayout.LayoutParams) this.JFG.getChildAt(i2).getLayoutParams();
                if (i2 == 0) {
                    layoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 30);
                } else if (i2 == this.JFG.getChildCount() - 1) {
                    layoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 30);
                } else {
                    layoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 30);
                    layoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 30);
                }
                this.JFG.getChildAt(i2).setLayoutParams(layoutParams);
            }
        }
        AppMethodBeat.o(30229);
    }

    private void updateStatus() {
        AppMethodBeat.i(30230);
        if (!Util.isNullOrNil(o.jjD)) {
            ((TextView) findViewById(R.id.i5c)).setText(o.jjD);
            if (o.bfc() == 1) {
                if (!this.JFy) {
                    this.EpU.setImageResource(R.raw.connect_pc_mute);
                    this.EpU.setPadding(this.JFD - this.GyC, this.Jmd, 0, 0);
                    AppMethodBeat.o(30230);
                    return;
                }
            } else if (o.bfc() == 2) {
                if (this.JFy) {
                    ((TextView) findViewById(R.id.glu)).setText(R.string.j1_);
                } else if (!g.apN()) {
                    ((TextView) findViewById(R.id.glu)).setText("");
                }
                if (this.pPO) {
                    ((TextView) findViewById(R.id.i5c)).setText(getString(R.string.j0u, new Object[]{"Mac"}));
                    this.EpU.setImageResource(R.raw.connect_mac_lock);
                    this.EpU.setPadding(0, this.Jmd, 0, 0);
                    if (g.apN() && !this.JFy) {
                        ((TextView) findViewById(R.id.glu)).setText(R.string.j0q);
                        this.EpU.setImageResource(R.raw.connect_mac_mute_lock);
                        this.EpU.setPadding(this.JFD - this.GyC, this.Jmd, 0, 0);
                        AppMethodBeat.o(30230);
                        return;
                    }
                } else {
                    ((TextView) findViewById(R.id.i5c)).setText(getString(R.string.j0x, new Object[]{"Mac"}));
                    this.EpU.setImageResource(R.raw.connect_mac);
                    this.EpU.setPadding(0, this.Jmd, 0, 0);
                    if (g.apN() && !this.JFy) {
                        ((TextView) findViewById(R.id.glu)).setText(R.string.j0q);
                        this.EpU.setImageResource(R.raw.connect_mac_mute);
                        this.EpU.setPadding(this.JFD - this.GyC, this.Jmd, 0, 0);
                        AppMethodBeat.o(30230);
                        return;
                    }
                }
            } else if (o.bfc() == 3) {
                this.EpU.setImageResource(R.raw.connect_ipad);
                this.EpU.setPadding(0, this.Jmd, 0, 0);
                AppMethodBeat.o(30230);
                return;
            } else if (o.bfc() == 7) {
                this.EpU.setImageResource(R.raw.connect_kidwatch_big);
                this.EpU.setPadding(0, this.Jmd, 0, 0);
                AppMethodBeat.o(30230);
                return;
            } else if (o.bfc() == 6) {
                this.EpU.setImageResource(R.raw.connect_car);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.EpU.getLayoutParams();
                layoutParams.width = com.tencent.mm.cb.a.aG(this, R.dimen.ape);
                layoutParams.height = com.tencent.mm.cb.a.aG(this, R.dimen.ape);
                layoutParams.topMargin = this.Jmd;
                this.EpU.setLayoutParams(layoutParams);
                this.EpU.setAlpha(0.3f);
                ((TextView) findViewById(R.id.glu)).setText("");
                if (!Util.isNullOrNil(o.jjC)) {
                    ((TextView) findViewById(R.id.boy)).setText(o.jjC);
                    findViewById(R.id.boy).setVisibility(0);
                }
                AppMethodBeat.o(30230);
                return;
            } else if (o.bfc() == 8) {
                if (this.JFy) {
                    this.EpU.setImageResource(R.raw.connect_android_pad);
                    this.EpU.setPadding(0, this.Jmd, 0, 0);
                } else {
                    this.EpU.setImageResource(R.raw.connect_android_pad_mute);
                    this.EpU.setPadding(this.JFD - this.GyC, this.Jmd, 0, 0);
                }
                ((TextView) findViewById(R.id.glu)).setText("");
                AppMethodBeat.o(30230);
                return;
            }
            this.EpU.setImageResource(R.raw.connect_pc);
            this.EpU.setPadding(0, this.Jmd, 0, 0);
        }
        AppMethodBeat.o(30230);
    }

    private void zB(boolean z) {
        AppMethodBeat.i(30231);
        if (this.JFz != null) {
            if (z) {
                this.JFz.setBackgroundResource(R.drawable.pc);
                ((TextView) findViewById(R.id.jlc)).setText(R.string.j1a);
                AppMethodBeat.o(30231);
                return;
            }
            this.JFz.setBackgroundResource(R.drawable.pb);
            ((TextView) findViewById(R.id.jlc)).setText(R.string.j0t);
        }
        AppMethodBeat.o(30231);
    }

    private void zC(boolean z) {
        AppMethodBeat.i(30232);
        if (this.JFA != null) {
            if (z) {
                this.JFA.setBackgroundResource(R.drawable.pb);
                this.JFC.setIconColor(getResources().getColor(R.color.FG_0));
                AppMethodBeat.o(30232);
                return;
            }
            this.JFA.setBackgroundResource(R.drawable.pc);
            this.JFC.setIconColor(getResources().getColor(R.color.BW_100_Alpha_0_8));
        }
        AppMethodBeat.o(30232);
    }

    private boolean gjf() {
        int i2;
        AppMethodBeat.i(30233);
        if (!bg.aAc()) {
            AppMethodBeat.o(30233);
            return false;
        }
        int aUe = z.aUe();
        if (this.JFy) {
            i2 = aUe | 8192;
        } else {
            i2 = aUe & -8193;
        }
        g.oI(i2);
        bg.aVF();
        c.azQ().set(40, Integer.valueOf(i2));
        this.JFq = true;
        updateStatus();
        AppMethodBeat.o(30233);
        return true;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(30234);
        if (this.Dav != null) {
            this.Dav.dismiss();
            this.Dav = null;
        }
        if (qVar.getType() == 281) {
            if (!(i2 == 0 && i3 == 0)) {
                Toast.makeText(this, (int) R.string.j18, 1).show();
            }
            finish();
            AppMethodBeat.o(30234);
            return;
        }
        if (qVar.getType() == 792) {
            int i4 = ((com.tencent.mm.plugin.webwx.a.b) qVar).dJY;
            if (this.JFE != null) {
                this.JFE.start();
            }
            if (i2 == 0 && i3 == 0) {
                this.pPO = i4 == 1;
                o.fK(this.pPO);
                updateStatus();
                Object[] objArr = new Object[1];
                objArr[0] = this.pPO ? "lock" : "unlock";
                Log.d("MicroMsg.WebWXLogoutUI", "%s extDevice success", objArr);
            } else if (i4 == 1) {
                Toast.makeText(this, (int) R.string.j0v, 0).show();
                AppMethodBeat.o(30234);
                return;
            } else {
                Toast.makeText(this, (int) R.string.j1b, 0).show();
                AppMethodBeat.o(30234);
                return;
            }
        }
        AppMethodBeat.o(30234);
    }

    @Override // com.tencent.mm.model.bc
    public final void aVw() {
        AppMethodBeat.i(30235);
        bg.aVF();
        if (!c.azn()) {
            finish();
            AppMethodBeat.o(30235);
            return;
        }
        if (o.bfe() && !this.pPO) {
            Log.d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
            this.pPO = true;
            zB(this.pPO);
            updateStatus();
        }
        AppMethodBeat.o(30235);
    }

    static /* synthetic */ void f(WebWXLogoutUI webWXLogoutUI) {
        AppMethodBeat.i(179742);
        if (webWXLogoutUI.pPO) {
            bg.azz().a(new com.tencent.mm.plugin.webwx.a.b(2), 0);
            Log.d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : UNLOCK");
            AppMethodBeat.o(179742);
            return;
        }
        bg.azz().a(new com.tencent.mm.plugin.webwx.a.b(1), 0);
        Log.d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : LOCK");
        AppMethodBeat.o(179742);
    }

    static /* synthetic */ boolean g(WebWXLogoutUI webWXLogoutUI) {
        AppMethodBeat.i(179743);
        if (webWXLogoutUI.JFF == o.bff()) {
            h.c(webWXLogoutUI.getContext(), o.jjK, webWXLogoutUI.getString(R.string.zb), webWXLogoutUI.getString(R.string.j17), webWXLogoutUI.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(30221);
                    final ae aeVar = new ae(1);
                    bg.azz().a(aeVar, 0);
                    WebWXLogoutUI webWXLogoutUI = WebWXLogoutUI.this;
                    AppCompatActivity context = WebWXLogoutUI.this.getContext();
                    WebWXLogoutUI.this.getString(R.string.zb);
                    webWXLogoutUI.Dav = h.a((Context) context, (String) null, true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.AnonymousClass8.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(30220);
                            bg.azz().a(aeVar);
                            if (WebWXLogoutUI.this.Dav != null) {
                                WebWXLogoutUI.this.Dav.cancel();
                            }
                            AppMethodBeat.o(30220);
                        }
                    });
                    AppMethodBeat.o(30221);
                }
            }, null);
        } else {
            webWXLogoutUI.finish();
        }
        AppMethodBeat.o(179743);
        return true;
    }
}
