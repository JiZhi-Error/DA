package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cr.d;
import com.tencent.mm.g.a.il;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.plugin.setting.model.b;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.f;

@a(17)
public class SettingsFontUI extends MMActivity {
    private int DbO = 0;
    private int DbP = 2;
    private int DbQ = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) R.dimen.xb);
    private float DbR = 1.0f;
    float DbS = 1.0f;
    float DbT = 1.0f;
    int DbU;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsFontUI() {
        AppMethodBeat.i(74154);
        AppMethodBeat.o(74154);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74155);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(74155);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bqv;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        int i2;
        AppMethodBeat.i(74156);
        setMMTitle(R.string.gva);
        this.DbR = gW(getContext());
        this.DbS = this.DbR;
        Log.i("MicroMsg.SettingsFontUI", "fontSizeBefore=" + this.DbR);
        final ImageView imageView = (ImageView) findViewById(R.id.au4);
        final ImageView imageView2 = (ImageView) findViewById(R.id.x2);
        final ImageView imageView3 = (ImageView) findViewById(R.id.x3);
        final MMNeat7extView mMNeat7extView = (MMNeat7extView) findViewById(R.id.hmk);
        final MMNeat7extView mMNeat7extView2 = (MMNeat7extView) findViewById(R.id.hmi);
        final MMNeat7extView mMNeat7extView3 = (MMNeat7extView) findViewById(R.id.hmj);
        a.b.c(imageView, z.aTY());
        this.DbQ = (int) (((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.xb)) / com.tencent.mm.cc.a.gvi());
        mMNeat7extView2.setMaxWidth(this.DbQ);
        mMNeat7extView3.setMaxWidth(this.DbQ);
        FontSelectorView fontSelectorView = (FontSelectorView) findViewById(R.id.d8a);
        float gW = gW(getContext());
        if (gW != com.tencent.mm.plugin.setting.a.gV(getContext())) {
            com.tencent.mm.plugin.setting.a.g(getContext(), gW);
        }
        if (gW < com.tencent.mm.cb.a.iW(getContext()) || gW > com.tencent.mm.cb.a.jd(getContext())) {
            gW = com.tencent.mm.cb.a.iW(getContext());
        }
        if (gW == com.tencent.mm.cb.a.iW(getContext())) {
            i2 = 0;
        } else if (gW == com.tencent.mm.cb.a.iY(getContext())) {
            i2 = 2;
        } else if (gW == com.tencent.mm.cb.a.iZ(getContext())) {
            i2 = 3;
        } else if (gW == com.tencent.mm.cb.a.ja(getContext())) {
            i2 = 4;
        } else if (gW == com.tencent.mm.cb.a.jb(getContext())) {
            i2 = 5;
        } else if (gW == com.tencent.mm.cb.a.jc(getContext())) {
            i2 = 6;
        } else if (gW == com.tencent.mm.cb.a.jd(getContext())) {
            i2 = 7;
        } else {
            i2 = 1;
        }
        fontSelectorView.setSliderIndex(i2);
        fontSelectorView.setOnChangeListener(new FontSelectorView.a() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.setting.ui.widget.FontSelectorView.a
            public final void ig(int i2) {
                float jd;
                float gvu;
                b bVar;
                AppMethodBeat.i(74151);
                SettingsFontUI.this.DbU = i2;
                AppCompatActivity context = SettingsFontUI.this.getContext();
                if (context == null) {
                    Log.e("MicroMsg.FontSizeService", "onChangeFontSize get null");
                    bVar = new b();
                } else {
                    switch (i2) {
                        case 0:
                            jd = com.tencent.mm.cb.a.iW(context);
                            gvu = ((float) com.tencent.mm.cc.a.gvu()) / 440.0f;
                            break;
                        case 1:
                        default:
                            jd = com.tencent.mm.cb.a.iX(context);
                            gvu = ((float) com.tencent.mm.cc.a.gvu()) / 400.0f;
                            break;
                        case 2:
                            jd = com.tencent.mm.cb.a.iY(context);
                            gvu = ((float) com.tencent.mm.cc.a.gvu()) / 360.0f;
                            break;
                        case 3:
                            jd = com.tencent.mm.cb.a.iZ(context);
                            gvu = (((float) com.tencent.mm.cc.a.gvu()) / 360.0f) * 1.12f;
                            break;
                        case 4:
                            jd = com.tencent.mm.cb.a.ja(context);
                            gvu = (((float) com.tencent.mm.cc.a.gvu()) / 340.0f) * 1.125f;
                            break;
                        case 5:
                            jd = com.tencent.mm.cb.a.jb(context);
                            gvu = (((float) com.tencent.mm.cc.a.gvu()) / 340.0f) * 1.4f;
                            break;
                        case 6:
                            jd = com.tencent.mm.cb.a.jc(context);
                            gvu = (((float) com.tencent.mm.cc.a.gvu()) / 340.0f) * 1.55f;
                            break;
                        case 7:
                            jd = com.tencent.mm.cb.a.jd(context);
                            gvu = (((float) com.tencent.mm.cc.a.gvu()) / 340.0f) * 1.65f;
                            break;
                    }
                    if (!com.tencent.mm.cb.a.jf(context)) {
                        gvu = jd;
                    }
                    b bVar2 = new b();
                    bVar2.CXG = jd;
                    bVar2.CXH = gvu;
                    bVar = bVar2;
                }
                SettingsFontUI.this.DbS = bVar.CXG;
                SettingsFontUI.this.DbT = bVar.CXH;
                mMNeat7extView.setTextSize(0, ((float) at.aH(SettingsFontUI.this.getContext(), R.dimen.is)) * SettingsFontUI.this.DbT);
                mMNeat7extView2.setTextSize(0, ((float) at.aH(SettingsFontUI.this.getContext(), R.dimen.is)) * SettingsFontUI.this.DbT);
                mMNeat7extView3.setTextSize(0, ((float) at.aH(SettingsFontUI.this.getContext(), R.dimen.is)) * SettingsFontUI.this.DbT);
                SettingsFontUI.this.setMMTitleSize(((float) com.tencent.mm.cb.a.aH(context, R.dimen.f3058c)) * com.tencent.mm.cb.a.ji(context));
                if (com.tencent.mm.cb.a.jf(SettingsFontUI.this.getContext())) {
                    SettingsFontUI.a(SettingsFontUI.this, imageView, i2);
                    SettingsFontUI.a(SettingsFontUI.this, imageView2, i2);
                    SettingsFontUI.a(SettingsFontUI.this, imageView3, i2);
                }
                AppMethodBeat.o(74151);
            }
        });
        this.DbP = com.tencent.mm.cb.a.jg(getContext());
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74152);
                h.INSTANCE.a(11609, Integer.valueOf(SettingsFontUI.this.DbO), Integer.valueOf(SettingsFontUI.this.DbP), 0);
                Log.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%s , changeFontSize: %s, curFontSize:%s", 11609, Integer.valueOf(SettingsFontUI.this.DbO), Integer.valueOf(SettingsFontUI.this.DbP));
                SettingsFontUI.this.finish();
                AppMethodBeat.o(74152);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(256538);
                SettingsFontUI.a(SettingsFontUI.this, SettingsFontUI.this.DbR);
                AppMethodBeat.o(256538);
                return true;
            }
        }, null, t.b.GREEN);
        AppMethodBeat.o(74156);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(74157);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            h.INSTANCE.a(11609, Integer.valueOf(this.DbO), Integer.valueOf(this.DbP), 0);
            Log.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%s , changeFontSize: %s, curFontSize:%s", 11609, Integer.valueOf(this.DbO), Integer.valueOf(this.DbP));
            finish();
            AppMethodBeat.o(74157);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(74157);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(74158);
        if (i2 == 4 && keyEvent.getAction() == 1) {
            h.INSTANCE.a(11609, Integer.valueOf(this.DbO), Integer.valueOf(this.DbP), 0);
            Log.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%s , changeFontSize: %s, curFontSize:%s", 11609, Integer.valueOf(this.DbO), Integer.valueOf(this.DbP));
            finish();
            AppMethodBeat.o(74158);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(74158);
        return onKeyDown;
    }

    private static float gW(Context context) {
        AppMethodBeat.i(74160);
        float je = com.tencent.mm.cb.a.je(context);
        if (!(je == com.tencent.mm.cb.a.iX(context) || je == com.tencent.mm.cb.a.iW(context) || je == com.tencent.mm.cb.a.iY(context) || je == com.tencent.mm.cb.a.iZ(context) || je == com.tencent.mm.cb.a.ja(context) || je == com.tencent.mm.cb.a.jb(context) || je == com.tencent.mm.cb.a.jc(context) || je == com.tencent.mm.cb.a.jd(context))) {
            je = com.tencent.mm.cb.a.iX(context);
        }
        AppMethodBeat.o(74160);
        return je;
    }

    static /* synthetic */ void a(SettingsFontUI settingsFontUI, ImageView imageView, int i2) {
        AppMethodBeat.i(256540);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        float gvu = ((float) com.tencent.mm.cc.a.gvu()) / ((float) com.tencent.mm.plugin.setting.a.Xm(i2));
        if (layoutParams != null) {
            layoutParams.width = (int) (((float) com.tencent.mm.cb.a.aH(settingsFontUI.getContext(), R.dimen.jx)) * gvu);
            layoutParams.height = (int) (gvu * ((float) com.tencent.mm.cb.a.aH(settingsFontUI.getContext(), R.dimen.jx)));
            imageView.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(256540);
    }

    static /* synthetic */ void a(SettingsFontUI settingsFontUI, final float f2) {
        AppMethodBeat.i(256541);
        if (settingsFontUI.DbS != f2) {
            f.a aVar = new f.a(settingsFontUI.getContext());
            aVar.bow(settingsFontUI.getContext().getResources().getString(R.string.glw)).Dq(true);
            aVar.c(new f.c() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI.AnonymousClass4 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                    int i2;
                    AppMethodBeat.i(256539);
                    if (z) {
                        if (!com.tencent.mm.cb.a.jf(SettingsFontUI.this.getContext())) {
                            SettingsFontUI.this.DbT = SettingsFontUI.this.DbS;
                        }
                        if (SettingsFontUI.this.DbS != f2) {
                            SettingsFontUI.this.DbO = 1;
                        } else {
                            SettingsFontUI.this.DbO = 0;
                        }
                        AppCompatActivity context = SettingsFontUI.this.getContext();
                        float f2 = SettingsFontUI.this.DbS;
                        int i3 = SettingsFontUI.this.DbU;
                        com.tencent.mm.cb.a.h(context, f2);
                        com.tencent.mm.plugin.setting.a.g(context, f2);
                        SharedPreferences.Editor edit = context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit();
                        edit.putInt("current_text_size_index_key", i3);
                        Log.i("MicroMsg.FontSizeService", "set CURRENT_TEXT_INDEX_KEY result: ".concat(String.valueOf(edit.commit())));
                        com.tencent.mm.plugin.webview.k.f.zz(true);
                        SettingsFontUI.this.DbP = com.tencent.mm.cb.a.jg(SettingsFontUI.this.getContext());
                        h.INSTANCE.a(11609, Integer.valueOf(SettingsFontUI.this.DbO), Integer.valueOf(SettingsFontUI.this.DbP), 0);
                        Log.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", 11609, Integer.valueOf(SettingsFontUI.this.DbO), Integer.valueOf(SettingsFontUI.this.DbP));
                        AppCompatActivity context2 = SettingsFontUI.this.getContext();
                        float f3 = f2;
                        float gV = com.tencent.mm.plugin.setting.a.gV(context2);
                        Log.i("MicroMsg.FontSizeService", "fontSizeAfter=".concat(String.valueOf(gV)));
                        if (context2 != null) {
                            i2 = context2.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getInt("current_text_size_index_key", 1);
                        } else {
                            i2 = 1;
                        }
                        int gvu = com.tencent.mm.cc.a.gvu();
                        int Xm = com.tencent.mm.plugin.setting.a.Xm(i2);
                        if (Xm != gvu) {
                            com.tencent.mm.cc.a.ajy(Xm);
                            Intent intent = new Intent();
                            intent.putExtra("Intro_Need_Clear_Top ", true);
                            c.jRt.o(intent, context2);
                            com.tencent.mm.bv.a.iH(MMApplicationContext.getContext());
                            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                            Object obj = new Object();
                            com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/setting/FontSizeDao", "restartApp", "(Landroid/content/Context;F)V", "java/lang/System_EXEC_", "exit", "(I)V");
                            System.exit(((Integer) a2.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/setting/FontSizeDao", "restartApp", "(Landroid/content/Context;F)V", "java/lang/System_EXEC_", "exit", "(I)V");
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("Intro_Need_Clear_Top ", true);
                            c.jRt.o(intent2, context2);
                            il ilVar = new il();
                            ilVar.dNd.dNe = f3;
                            ilVar.dNd.dNf = gV;
                            EventCenter.instance.publish(ilVar);
                            d.bpG("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                        }
                        SettingsFontUI.this.finish();
                    }
                    AppMethodBeat.o(256539);
                }
            }).show();
            AppMethodBeat.o(256541);
            return;
        }
        h.INSTANCE.a(11609, Integer.valueOf(settingsFontUI.DbO), Integer.valueOf(settingsFontUI.DbP), 0);
        Log.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%s , changeFontSize: %s, curFontSize:%s", 11609, Integer.valueOf(settingsFontUI.DbO), Integer.valueOf(settingsFontUI.DbP));
        settingsFontUI.finish();
        AppMethodBeat.o(256541);
    }
}
