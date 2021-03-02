package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.webview.luggage.b.n;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONArray;
import org.json.JSONObject;

public class m extends FrameLayout {
    private View DuB;
    private g ISU;
    public b IUh;
    private View IUi;
    private ImageView IUj;
    protected LinearLayout IUk;
    private ImageView IUl;
    private TextView IUm;
    private o IUn;
    protected n IUo;
    private x IUp;
    public d IUq = null;
    private boolean IUr = false;
    private int IUs;
    private boolean IUt;
    private boolean IUu;
    int IUv = -1;
    private boolean IUw = false;
    public Integer IUx;
    public boolean IUy;
    private View.OnClickListener IUz = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.webview.luggage.m.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(210921);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (m.this.ISU == null) {
                a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(210921);
                return;
            }
            m.this.ISU.ctS.a(new com.tencent.luggage.d.d() {
                /* class com.tencent.mm.plugin.webview.luggage.m.AnonymousClass2.AnonymousClass1 */

                @Override // com.tencent.luggage.d.d
                public final String name() {
                    return "onNavigationBarRightButtonClick";
                }

                @Override // com.tencent.luggage.d.d
                public final JSONObject Ld() {
                    AppMethodBeat.i(210920);
                    JSONObject jSONObject = new JSONObject();
                    AppMethodBeat.o(210920);
                    return jSONObject;
                }
            });
            a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(210921);
        }
    };
    protected Context mContext;
    private TextView mPa;
    private String mTitle;
    private ImageView nZa;
    private int ziP = R.raw.actionbar_quit_webview_icon;

    static /* synthetic */ void a(m mVar, boolean z) {
        AppMethodBeat.i(210933);
        mVar.zd(z);
        AppMethodBeat.o(210933);
    }

    public m(g gVar) {
        super(gVar.mContext);
        AppMethodBeat.i(78384);
        setId(R.id.f5e);
        this.mContext = gVar.mContext;
        this.ISU = gVar;
        setBackgroundColor(0);
        this.IUh = new c(this.mContext);
        addView(this.IUh, -1, -1);
        this.IUs = android.support.v4.content.b.n(this.mContext, R.color.bj);
        this.DuB = aa.jQ(getContext()).inflate(R.layout.cbk, (ViewGroup) this, false);
        setActionBarViewColor(this.IUs);
        this.IUh.addView(this.DuB, new FrameLayout.LayoutParams(-1, getActionBarHeight()));
        this.IUi = this.DuB.findViewById(R.id.f_z);
        this.IUj = (ImageView) this.DuB.findViewById(R.id.brt);
        this.nZa = (ImageView) this.DuB.findViewById(R.id.dr);
        this.nZa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.luggage.m.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(78375);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!m.this.gbB()) {
                    m.this.dTG();
                }
                a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(78375);
            }
        });
        this.mPa = (TextView) this.DuB.findViewById(R.id.ipm);
        this.IUk = (LinearLayout) this.DuB.findViewById(R.id.e_);
        this.IUl = (ImageView) this.DuB.findViewById(R.id.e9);
        this.IUl.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.luggage.m.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(78376);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                m.this.dTH();
                a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(78376);
            }
        });
        this.IUl.setClickable(false);
        this.IUm = (TextView) this.DuB.findViewById(R.id.ea);
        this.IUm.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.luggage.m.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(78377);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                m.this.dTH();
                a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(78377);
            }
        });
        this.IUm.setClickable(false);
        if (com.tencent.mm.cb.a.jk(getContext())) {
            this.mPa.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.t)) * com.tencent.mm.cb.a.ji(getContext()));
        }
        AppMethodBeat.o(78384);
    }

    public void onDestroy() {
    }

    public void onForeground() {
    }

    public void setOptionEnable(boolean z) {
        AppMethodBeat.i(78385);
        if (z) {
            this.IUl.setClickable(true);
            this.IUm.setClickable(true);
            AppMethodBeat.o(78385);
            return;
        }
        this.IUl.setClickable(false);
        this.IUm.setClickable(false);
        AppMethodBeat.o(78385);
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitleText(String str) {
        AppMethodBeat.i(78386);
        Log.d("MicroMsg.GameWebViewActionBar", "setTitleText, title: %s", str);
        this.mTitle = str;
        this.mPa.setText(str);
        AppMethodBeat.o(78386);
    }

    public void setTitleColor(int i2) {
        AppMethodBeat.i(78387);
        this.mPa.setTextColor(i2);
        AppMethodBeat.o(78387);
    }

    /* access modifiers changed from: protected */
    public void setBackBtn(int i2) {
        AppMethodBeat.i(182686);
        this.ziP = i2;
        this.nZa.setImageResource(i2);
        AppMethodBeat.o(182686);
    }

    /* access modifiers changed from: protected */
    public n getMenuHelp() {
        AppMethodBeat.i(78388);
        if (this.IUo == null) {
            this.IUo = new n();
        }
        n nVar = this.IUo;
        AppMethodBeat.o(78388);
        return nVar;
    }

    public void dTH() {
        AppMethodBeat.i(78389);
        boolean z = false;
        if (getContext() instanceof MMActivity) {
            z = ((MMActivity) getContext()).hideVKBHavingResult();
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.m.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(78378);
                m.this.IUn = new o(m.this.ISU, m.this.getMenuHelp());
                AppMethodBeat.o(78378);
            }
        }, z ? 100 : 0);
        AppMethodBeat.o(78389);
    }

    public void dTI() {
        AppMethodBeat.i(78390);
        if (this.IUn != null) {
            this.IUn.gca();
        }
        AppMethodBeat.o(78390);
    }

    public final void gbW() {
        AppMethodBeat.i(210924);
        this.IUw = true;
        if (this.IUj != null) {
            this.IUj.setVisibility(8);
        }
        if (this.IUi != null) {
            this.IUi.setVisibility(8);
        }
        AppMethodBeat.o(210924);
    }

    private int getActionBarHeight() {
        AppMethodBeat.i(78391);
        int eu = au.eu(MMApplicationContext.getContext());
        AppMethodBeat.o(78391);
        return eu;
    }

    public int getTopBarHeight() {
        AppMethodBeat.i(210925);
        int height = this.IUh.getHeight();
        AppMethodBeat.o(210925);
        return height;
    }

    public void dTG() {
        AppMethodBeat.i(78392);
        this.ISU.hb(true);
        AppMethodBeat.o(78392);
    }

    public final void gbX() {
        AppMethodBeat.i(78393);
        getMenuHelp().gbX();
        AppMethodBeat.o(78393);
    }

    public final void gbY() {
        AppMethodBeat.i(78394);
        getMenuHelp().gbY();
        AppMethodBeat.o(78394);
    }

    public final void T(JSONArray jSONArray) {
        AppMethodBeat.i(78395);
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                getMenuHelp().aYA(jSONArray.optString(i2));
            }
        }
        AppMethodBeat.o(78395);
    }

    public final void U(JSONArray jSONArray) {
        AppMethodBeat.i(78396);
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                getMenuHelp().aYB(jSONArray.optString(i2));
            }
        }
        AppMethodBeat.o(78396);
    }

    public final boolean gbB() {
        AppMethodBeat.i(78398);
        if (this.IUp == null || !this.IUp.gci()) {
            AppMethodBeat.o(78398);
            return false;
        }
        String gcj = this.IUp.gcj();
        String gck = this.IUp.gck();
        String gcl = this.IUp.gcl();
        Log.i("MicroMsg.GameWebViewActionBar", "use js api close window confirm info : %s, %s, %s", gcj, gck, gcl);
        View inflate = View.inflate(getContext(), R.layout.b7f, null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.ffe);
        checkBox.setChecked(false);
        checkBox.setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.ffg);
        textView.setText(gcj);
        textView.setTextColor(getResources().getColor(R.color.a2x));
        TextView textView2 = (TextView) inflate.findViewById(R.id.fff);
        textView2.setTextColor(getResources().getColor(R.color.a2x));
        textView2.setVisibility(8);
        this.IUq = h.a(getContext(), true, "", inflate, gck, gcl, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.luggage.m.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(78379);
                m.this.IUq = null;
                m.this.dTG();
                AppMethodBeat.o(78379);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.luggage.m.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(78380);
                m.this.IUq = null;
                AppMethodBeat.o(78380);
            }
        });
        AppMethodBeat.o(78398);
        return true;
    }

    private void setActionBarColor(int i2) {
        boolean z = true;
        AppMethodBeat.i(78399);
        Log.i("MicroMsg.GameWebViewActionBar", "setActionBarColor, color : %d", Integer.valueOf(i2));
        if (i2 == 0) {
            i2 = getResources().getColor(R.color.afz);
        }
        boolean ze = ze(ar.aln(i2));
        b bVar = this.IUh;
        if (ze) {
            z = false;
        }
        com.tencent.mm.ui.statusbar.a.e(bVar, i2, z);
        this.IUx = Integer.valueOf(i2);
        this.IUy = ze;
        setActionBarViewColor(i2);
        pK(ze);
        AppMethodBeat.o(78399);
    }

    /* access modifiers changed from: protected */
    public void pK(boolean z) {
        AppMethodBeat.i(210926);
        if (!z) {
            this.mPa.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.nZa.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.webview.luggage.m.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(78381);
                    m.this.nZa.setColorFilter(WebView.NIGHT_MODE_COLOR);
                    AppMethodBeat.o(78381);
                }
            }, 100);
            if (!this.IUr) {
                this.IUl.setImageResource(R.raw.actionbar_icon_dark_more);
                AppMethodBeat.o(210926);
                return;
            }
        } else {
            this.mPa.setTextColor(-1);
            this.nZa.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.webview.luggage.m.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(210922);
                    m.this.nZa.setColorFilter(-1);
                    AppMethodBeat.o(210922);
                }
            }, 100);
            if (!this.IUr) {
                this.IUl.setImageResource(R.raw.actionbar_icon_light_more);
            }
        }
        AppMethodBeat.o(210926);
    }

    public final void k(int i2, boolean z, boolean z2) {
        AppMethodBeat.i(210927);
        this.IUs = i2;
        this.IUt = z;
        this.IUu = z2;
        if (!this.IUt || !(this.IUx == null || this.IUx.intValue() == 0)) {
            setActionBarColor(i2);
            AppMethodBeat.o(210927);
            return;
        }
        setImmersiveStyle(z2);
        AppMethodBeat.o(210927);
    }

    public void setActionBarColorValue(int i2) {
        this.IUs = i2;
    }

    public void setIconDark(int i2) {
        this.IUv = i2;
    }

    /* access modifiers changed from: package-private */
    public final void zd(boolean z) {
        AppMethodBeat.i(210928);
        if (this.IUl != null) {
            if (z) {
                this.IUl.setVisibility(8);
                AppMethodBeat.o(210928);
                return;
            }
            this.IUl.setVisibility(0);
        }
        AppMethodBeat.o(210928);
    }

    public void setNavigationBarButtons(Bundle bundle) {
        final Bitmap bitmap = null;
        AppMethodBeat.i(78400);
        if (bundle == null) {
            AppMethodBeat.o(78400);
            return;
        }
        String string = bundle.getString("set_navigation_bar_buttons_left_text_color");
        final boolean z = bundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
        final String string2 = bundle.getString("set_navigation_bar_buttons_text");
        String string3 = bundle.getString("set_navigation_bar_buttons_icon_data");
        String string4 = bundle.getString("set_navigation_bar_buttons_text_color");
        final boolean z2 = bundle.getBoolean("set_navigation_bar_buttons_need_click_event", false);
        e.gw(string, WebView.NIGHT_MODE_COLOR);
        final int bag = (int) e.bag(string4);
        if (!Util.isNullOrNil(string3)) {
            try {
                bitmap = e.bah(string3);
            } catch (Exception e2) {
                Log.e("MicroMsg.GameWebViewActionBar", "setNavigationBarButtons, decode base64 image, exception = %s", e2);
            }
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.m.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(210923);
                if (m.this == null || m.this.ISU == null) {
                    AppMethodBeat.o(210923);
                } else if (z) {
                    m.a(m.this, true);
                    AppMethodBeat.o(210923);
                } else {
                    m.a(m.this, false);
                    if (m.this.IUl == null || m.this.IUm == null) {
                        AppMethodBeat.o(210923);
                        return;
                    }
                    m.this.IUr = false;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        m.this.IUl.setVisibility(0);
                        m.this.IUl.setImageBitmap(bitmap);
                        m.this.IUm.setVisibility(8);
                        m.this.IUr = true;
                    } else if (!Util.isNullOrNil(string2)) {
                        m.this.IUl.setVisibility(8);
                        m.this.IUm.setVisibility(0);
                        m.this.IUm.setText(string2);
                        if (bag != -1) {
                            m.this.IUm.setTextColor(bag);
                        }
                    }
                    if (z2) {
                        m.this.IUl.setOnClickListener(m.this.IUz);
                        m.this.IUm.setOnClickListener(m.this.IUz);
                    }
                    AppMethodBeat.o(210923);
                }
            }
        });
        AppMethodBeat.o(78400);
    }

    private void setImmersiveStyle(boolean z) {
        AppMethodBeat.i(210929);
        Log.i("MicroMsg.GameWebViewActionBar", "setImmersiveStyle");
        boolean ze = ze(z);
        com.tencent.mm.ui.statusbar.a.e(this.IUh, 0, !ze);
        this.IUx = 0;
        this.IUy = ze;
        setActionBarViewColor(0);
        this.mPa.setVisibility(8);
        this.IUj.setVisibility(8);
        this.nZa.setImageAlpha(255);
        this.IUl.setImageAlpha(255);
        pK(ze);
        AppMethodBeat.o(210929);
    }

    private void setActionBarViewColor(int i2) {
        AppMethodBeat.i(210930);
        if (this.DuB != null) {
            this.DuB.setBackgroundColor(i2);
            if (((float) ((i2 >> 24) & 255)) / 255.0f > 0.0f) {
                this.DuB.setClickable(true);
                AppMethodBeat.o(210930);
                return;
            }
            this.DuB.setClickable(false);
        }
        AppMethodBeat.o(210930);
    }

    public final void gbZ() {
        AppMethodBeat.i(210931);
        setImmersiveStyle(this.IUu);
        AppMethodBeat.o(210931);
    }

    public void setAlpha(float f2) {
        AppMethodBeat.i(210932);
        if (f2 < 0.0f || f2 > 1.0f) {
            AppMethodBeat.o(210932);
        } else if (f2 == 0.0f) {
            gbZ();
            AppMethodBeat.o(210932);
        } else {
            int i2 = (int) (255.0f * f2);
            this.mPa.setVisibility(0);
            if (this.IUw) {
                this.IUj.setVisibility(8);
            } else {
                this.IUj.setVisibility(0);
            }
            setActionBarColor((((this.IUs >> 16) & 255) << 16) | (i2 << 24) | (((this.IUs >> 8) & 255) << 8) | (this.IUs & 255));
            this.mPa.setAlpha(f2);
            this.IUj.setImageAlpha(i2);
            this.nZa.setImageAlpha(i2);
            this.IUl.setImageAlpha(i2);
            AppMethodBeat.o(210932);
        }
    }

    private boolean ze(boolean z) {
        switch (this.IUv) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return z;
        }
    }

    public void setCloseWindowConfirmInfo(Bundle bundle) {
        x xVar;
        AppMethodBeat.i(78397);
        if (bundle == null) {
            xVar = null;
        } else {
            xVar = new x(bundle);
        }
        this.IUp = xVar;
        AppMethodBeat.o(78397);
    }
}
