package com.tencent.mm.chatroom.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.x;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
@Deprecated
public class RoomAnnouncementUI extends MMActivity {
    private WebView gxL;
    private boolean gxM;
    private String roomId;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12686);
        super.onCreate(bundle);
        this.gxM = getIntent().getBooleanExtra("need_bind_mobile", false);
        this.roomId = getIntent().getStringExtra("RoomInfo_Id");
        initView();
        AppMethodBeat.o(12686);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(12687);
        super.onResume();
        AppMethodBeat.o(12687);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(12688);
        super.onPause();
        AppMethodBeat.o(12688);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(12689);
        if (this.gxL != null) {
            this.gxL.setVisibility(8);
            ((ViewGroup) this.gxL.getParent()).removeView(this.gxL);
            this.gxL.removeAllViews();
            this.gxL.destroy();
            this.gxL = null;
            System.gc();
        }
        super.onDestroy();
        AppMethodBeat.o(12689);
    }

    @Override // com.tencent.mm.ui.MMActivity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void initView() {
        AppMethodBeat.i(12690);
        setMMTitle(R.string.g_8);
        this.gxL = MMWebView.a.r(this, R.id.jkk);
        this.gxL.getSettings().setJavaScriptEnabled(true);
        this.gxL.getSettings().hsU();
        this.gxL.getSettings().setBuiltInZoomControls(true);
        this.gxL.getSettings().setUseWideViewPort(true);
        this.gxL.getSettings().setLoadWithOverviewMode(true);
        this.gxL.getSettings().hsN();
        this.gxL.getSettings().hsM();
        this.gxL.getSettings().setGeolocationEnabled(false);
        this.gxL.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        this.gxL.setWebChromeClient(new x() {
            /* class com.tencent.mm.chatroom.ui.RoomAnnouncementUI.AnonymousClass1 */

            @Override // com.tencent.xweb.x
            public final boolean a(WebView webView, String str, String str2, JsResult jsResult) {
                AppMethodBeat.i(12683);
                h.d(RoomAnnouncementUI.this, str2, null, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.chatroom.ui.RoomAnnouncementUI.AnonymousClass1.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(12682);
                        RoomAnnouncementUI.this.gxL.requestFocus();
                        AppMethodBeat.o(12682);
                    }
                });
                jsResult.cancel();
                AppMethodBeat.o(12683);
                return true;
            }
        });
        this.gxL.setWebViewClient(new ac() {
            /* class com.tencent.mm.chatroom.ui.RoomAnnouncementUI.AnonymousClass2 */

            @Override // com.tencent.xweb.ac
            public final boolean a(WebView webView, String str) {
                AppMethodBeat.i(12684);
                if (str.equals("weixin://chatroom/upgradeagree")) {
                    b.a(RoomAnnouncementUI.this, RoomAnnouncementUI.this.roomId, RoomAnnouncementUI.this.gxM);
                    AppMethodBeat.o(12684);
                    return true;
                }
                AppMethodBeat.o(12684);
                return false;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.RoomAnnouncementUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12685);
                RoomAnnouncementUI.this.setResult(0);
                RoomAnnouncementUI.this.finish();
                AppMethodBeat.o(12685);
                return true;
            }
        });
        this.gxL.loadUrl(getString(R.string.awq, new Object[]{LocaleUtil.getApplicationLanguage()}));
        AppMethodBeat.o(12690);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ph;
    }
}
