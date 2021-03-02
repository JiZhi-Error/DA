package com.tencent.mm.ui.websearch;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.websearch.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.smtt.sdk.WebView;

@a(7)
public class WebSearchVoiceUI extends MMActivity {
    private com.tencent.mm.pluginsdk.ui.websearch.a QBw;
    private View QBx;
    private int QBy;
    private b Qoh = null;
    private String dVO;
    private int scene;
    private String sessionId;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cbi;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39588);
        super.onCreate(bundle);
        setBackBtnColorFilter(WebView.NIGHT_MODE_COLOR);
        setMMTitleColor(WebView.NIGHT_MODE_COLOR);
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(R.color.afd));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.afd)));
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.websearch.WebSearchVoiceUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39584);
                WebSearchVoiceUI.this.finish();
                AppMethodBeat.o(39584);
                return true;
            }
        });
        if (getIntent() != null) {
            this.sessionId = getIntent().getStringExtra("sessionId");
            this.dVO = getIntent().getStringExtra("subSessionId");
            this.scene = getIntent().getIntExtra("key_scene", -1);
            this.QBy = getIntent().getIntExtra("key_is_nav_voice", 0);
        }
        this.QBx = findViewById(R.id.jag);
        this.mController.hideTitleView();
        if (this.QBw == null) {
            this.QBw = new com.tencent.mm.pluginsdk.ui.websearch.a(getContext());
            this.QBw.setCallback(new a.AbstractC2035a() {
                /* class com.tencent.mm.ui.websearch.WebSearchVoiceUI.AnonymousClass2 */

                @Override // com.tencent.mm.pluginsdk.ui.websearch.a.AbstractC2035a
                public final void gpc() {
                    AppMethodBeat.i(39585);
                    WebSearchVoiceUI.this.setResult(0);
                    h.INSTANCE.a(15178, 4, Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.this.sessionId, WebSearchVoiceUI.this.dVO, Integer.valueOf(WebSearchVoiceUI.this.scene), Integer.valueOf(WebSearchVoiceUI.this.QBy));
                    WebSearchVoiceUI.this.finish();
                    AppMethodBeat.o(39585);
                }

                @Override // com.tencent.mm.pluginsdk.ui.websearch.a.AbstractC2035a
                public final void bez(String str) {
                    AppMethodBeat.i(39586);
                    if (!TextUtils.isEmpty(str) && str.length() > 2) {
                        str = str.substring(0, str.length() - 1);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("text", str);
                    WebSearchVoiceUI.this.setResult(0, intent);
                    h.INSTANCE.a(15178, 3, Long.valueOf(System.currentTimeMillis()), str, WebSearchVoiceUI.this.sessionId, WebSearchVoiceUI.this.dVO, Integer.valueOf(WebSearchVoiceUI.this.scene), Integer.valueOf(WebSearchVoiceUI.this.QBy));
                    WebSearchVoiceUI.this.finish();
                    AppMethodBeat.o(39586);
                }

                @Override // com.tencent.mm.pluginsdk.ui.websearch.a.AbstractC2035a
                public final void zQ(boolean z) {
                    AppMethodBeat.i(39587);
                    if (z) {
                        h.INSTANCE.a(15178, 2, Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.this.sessionId, WebSearchVoiceUI.this.dVO, Integer.valueOf(WebSearchVoiceUI.this.scene), Integer.valueOf(WebSearchVoiceUI.this.QBy));
                    }
                    AppMethodBeat.o(39587);
                }
            });
        }
        this.QBw.grz();
        com.tencent.mm.pluginsdk.ui.websearch.a aVar = this.QBw;
        Log.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", Integer.valueOf(aVar.Khj), Boolean.valueOf(aVar.Koo));
        if (aVar.Koo) {
            aVar.Koo = false;
            View findViewById = aVar.findViewById(R.id.j_1);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int i2 = aVar.Khj;
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, i2);
            }
            layoutParams.height = i2;
            findViewById.setLayoutParams(layoutParams);
            aVar.grB();
            aVar.requestLayout();
        }
        this.QBw.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        ((ViewGroup) findViewById(R.id.h8v)).addView(this.QBw, layoutParams2);
        h.INSTANCE.a(15178, 1, Long.valueOf(System.currentTimeMillis()), "", this.sessionId, this.dVO, Integer.valueOf(this.scene), Integer.valueOf(this.QBy));
        AppMethodBeat.o(39588);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity
    public void initSwipeBack() {
        AppMethodBeat.i(39589);
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            this.Qoh = new b(this);
            this.Qoh.addView(childAt, new FrameLayout.LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.Qoh);
            getSwipeBackLayout().setContentView(this.Qoh);
        }
        com.tencent.mm.ui.statusbar.a.e(getContentView(), getStatusBarColor(), true);
        AppMethodBeat.o(39589);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public boolean initNavigationSwipeBack() {
        AppMethodBeat.i(39590);
        boolean initNavigationSwipeBack = super.initNavigationSwipeBack();
        if (!isSupportNavigationSwipeBack()) {
            com.tencent.mm.ui.statusbar.a.e(getContentView(), getStatusBarColor(), true);
        }
        AppMethodBeat.o(39590);
        return initNavigationSwipeBack;
    }

    private int getStatusBarColor() {
        AppMethodBeat.i(39591);
        int color = getResources().getColor(R.color.afd);
        AppMethodBeat.o(39591);
        return color;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(39592);
        super.onBackPressed();
        setResult(0);
        finish();
        AppMethodBeat.o(39592);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(39593);
        super.onDestroy();
        if (this.QBw != null) {
            this.QBw.destroy();
        }
        AppMethodBeat.o(39593);
    }
}
