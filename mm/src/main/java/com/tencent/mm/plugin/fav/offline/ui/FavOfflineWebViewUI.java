package com.tencent.mm.plugin.fav.offline.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.plugin.fav.offline.b.a;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import java.io.IOException;
import java.util.LinkedList;

public class FavOfflineWebViewUI extends MMActivity {
    private boolean gvP = true;
    private String mUrl;
    private a tcM;
    private MMWebView tcN;
    private FrameLayout tcO;
    private g tcP;
    private a tcQ;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a7t;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73583);
        super.onCreate(bundle);
        this.mUrl = getIntent().getStringExtra("key_path");
        long longExtra = getIntent().getLongExtra("key_detail_info_id", 0);
        if (longExtra == 0) {
            Log.e("MicroMsg.offline.FavOfflineWebViewUI", "favLocalId is 0l!!!");
            finish();
            AppMethodBeat.o(73583);
            return;
        }
        this.tcM = ((PluginFavOffline) com.tencent.mm.kernel.g.ah(PluginFavOffline.class)).getFavOfflineStorage().ask(this.mUrl);
        if (this.tcM == null) {
            Log.e("MicroMsg.offline.FavOfflineWebViewUI", "favOffline is null!!!");
            finish();
            AppMethodBeat.o(73583);
            return;
        }
        this.tcP = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(longExtra);
        if (this.tcP == null) {
            Log.e("MicroMsg.offline.FavOfflineWebViewUI", "curInfo is null!!!");
            finish();
            AppMethodBeat.o(73583);
            return;
        }
        Log.i("MicroMsg.offline.FavOfflineWebViewUI", "mUrl : %s", this.mUrl);
        if (Util.isNullOrNil(this.mUrl)) {
            Log.e("MicroMsg.offline.FavOfflineWebViewUI", "mUrl is null!!!");
            finish();
            AppMethodBeat.o(73583);
            return;
        }
        this.tcQ = new a(this, this.tcM);
        initView();
        AppMethodBeat.o(73583);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(73584);
        super.initView();
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        setBackGroundColorResource(R.color.afz);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.offline.ui.FavOfflineWebViewUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73575);
                FavOfflineWebViewUI.this.finish();
                AppMethodBeat.o(73575);
                return true;
            }
        }, R.raw.actionbar_icon_dark_close);
        addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.offline.ui.FavOfflineWebViewUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73580);
                Log.d("MicroMsg.offline.FavOfflineWebViewUI", "onMenuItemClick click");
                e eVar = new e((Context) FavOfflineWebViewUI.this.getContext(), 0, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.fav.offline.ui.FavOfflineWebViewUI.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(73576);
                        mVar.a(2, (CharSequence) FavOfflineWebViewUI.this.getString(R.string.c8s), R.raw.icons_filled_share, FavOfflineWebViewUI.this.getResources().getColor(R.color.Brand), false);
                        mVar.a(3, (CharSequence) FavOfflineWebViewUI.this.getString(R.string.c8t), R.raw.bottomsheet_icon_moment, false);
                        AppMethodBeat.o(73576);
                    }
                };
                eVar.QNH = new o.f() {
                    /* class com.tencent.mm.plugin.fav.offline.ui.FavOfflineWebViewUI.AnonymousClass2.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(73577);
                        mVar.aS(0, R.string.c8r, R.raw.bottomsheet_icon_addtag);
                        mVar.aS(1, R.string.c8q, R.raw.bottomsheet_icon_del);
                        AppMethodBeat.o(73577);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.fav.offline.ui.FavOfflineWebViewUI.AnonymousClass2.AnonymousClass3 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        String str;
                        AppMethodBeat.i(73578);
                        Intent intent = new Intent();
                        switch (menuItem.getItemId()) {
                            case 2:
                                new LinkedList().add(FavOfflineWebViewUI.this.tcP);
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("scene_from", 1);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("select_fav_local_id", FavOfflineWebViewUI.this.tcP.field_localId);
                                intent.putExtra("Retr_Msg_Type", 2);
                                c.c(FavOfflineWebViewUI.this, ".ui.transmit.SelectConversationUI", intent, 1);
                                AppMethodBeat.o(73578);
                                return;
                            case 3:
                                String str2 = "";
                                if (FavOfflineWebViewUI.this.tcP.field_favProto.LwS != null) {
                                    anq anq = FavOfflineWebViewUI.this.tcP.field_favProto.LwS;
                                    String str3 = FavOfflineWebViewUI.this.tcP.field_favProto.title;
                                    if (!Util.isNullOrNil(anq.title)) {
                                        str3 = anq.title;
                                    }
                                    str = anq.thumbUrl;
                                    str2 = str3;
                                } else {
                                    str = "";
                                }
                                intent.putExtra("Ksnsupload_link", FavOfflineWebViewUI.this.mUrl);
                                intent.putExtra("Ksnsupload_title", str2);
                                intent.putExtra("Ksnsupload_imgurl", str);
                                intent.putExtra("Ksnsupload_imgbuf", s.aW(b.a(b.c(FavOfflineWebViewUI.this.tcP)), 0, -1));
                                intent.putExtra("Ksnsupload_type", 1);
                                intent.putExtra("need_result", true);
                                c.a((Context) FavOfflineWebViewUI.this, "sns", ".ui.SnsUploadUI", intent, 2, false);
                                break;
                        }
                        AppMethodBeat.o(73578);
                    }
                };
                eVar.QNK = new o.g() {
                    /* class com.tencent.mm.plugin.fav.offline.ui.FavOfflineWebViewUI.AnonymousClass2.AnonymousClass4 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(73579);
                        Intent intent = new Intent();
                        switch (menuItem.getItemId()) {
                            case 0:
                                intent.putExtra("key_fav_scene", 4);
                                intent.putExtra("key_fav_item_id", FavOfflineWebViewUI.this.tcP.field_localId);
                                b.b(FavOfflineWebViewUI.this.getContext(), ".ui.FavTagEditUI", intent);
                                AppMethodBeat.o(73579);
                                return;
                            case 1:
                                b.a(FavOfflineWebViewUI.this.tcP, (Runnable) null);
                                FavOfflineWebViewUI.this.finish();
                                break;
                        }
                        AppMethodBeat.o(73579);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(73580);
                return true;
            }
        });
        this.tcN = MMWebView.a.a(this, getContentView(), R.id.jkk);
        this.tcO = (FrameLayout) findViewById(R.id.do4);
        this.tcN.getSettings().setJavaScriptEnabled(true);
        this.tcN.getSettings().hsL();
        this.tcN.getSettings().hsP();
        this.tcN.getSettings().hsQ();
        this.tcN.addJavascriptInterface(this.tcQ, "java_obj");
        this.tcN.setWebViewClient(new ac() {
            /* class com.tencent.mm.plugin.fav.offline.ui.FavOfflineWebViewUI.AnonymousClass3 */

            @Override // com.tencent.xweb.ac
            public final boolean a(WebView webView, String str) {
                return true;
            }

            @Override // com.tencent.xweb.ac
            public final void b(WebView webView, String str) {
                AppMethodBeat.i(73581);
                Log.d("MicroMsg.offline.FavOfflineWebViewUI", "onPageFinished URL:".concat(String.valueOf(str)));
                if (webView != null && FavOfflineWebViewUI.this.gvP) {
                    webView.evaluateJavascript("javascript:function setJsAcion(){document.querySelectorAll('img').forEach(function(img){img.addEventListener('click',function(){window.java_obj.doImgPreview(img.src)}) });var div = document.createElement('div');\ndiv.innerHTML = '<div style=\"padding: 8px 16px 4px;background: #FFFFFF;\"><div style=\"padding:12px 16px;background: #F7F7F7;-webkit-border-radius:4px;border-radius:4px;color: rgba(0,0,0,.5);font-size:17px;line-height:1.4;\">当前网络不可用，正在使用离线模式阅读</div></div>';\nvar parentNode = document.getElementById('js_article');\nvar oldNode = document.getElementsByClassName('rich_media_inner')[0];\nparentNode.insertBefore(div.firstChild, oldNode);}", null);
                    webView.evaluateJavascript("javascript:setJsAcion()", null);
                    FavOfflineWebViewUI.this.gvP = false;
                }
                AppMethodBeat.o(73581);
            }
        });
        String uri = FileProviderHelper.getUriForFile(getContext(), new com.tencent.mm.vfs.o(s.k(s.k(this.tcM.field_path, false), false))).toString();
        Log.d("MicroMsg.offline.FavOfflineWebViewUI", "basePath:%s", uri);
        try {
            this.tcN.loadDataWithBaseURL(uri, s.boY(this.tcM.field_path), "text/html", ProtocolPackage.ServerEncoding, null);
            AppMethodBeat.o(73584);
        } catch (IOException e2) {
            AppMethodBeat.o(73584);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(73585);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 1:
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                Log.d("MicroMsg.offline.FavOfflineWebViewUI", "select %s for sending", stringExtra);
                if (!Util.isNullOrNil(stringExtra)) {
                    if (!new k().u(this.tcP)) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(this.tcP);
                        final q a2 = h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
                        l.a(getContext(), stringExtra, intent.getStringExtra("custom_send_text"), linkedList, new Runnable() {
                            /* class com.tencent.mm.plugin.fav.offline.ui.FavOfflineWebViewUI.AnonymousClass4 */

                            public final void run() {
                                AppMethodBeat.i(73582);
                                a2.dismiss();
                                com.tencent.mm.ui.widget.snackbar.b.r(FavOfflineWebViewUI.this, FavOfflineWebViewUI.this.getString(R.string.c8o));
                                AppMethodBeat.o(73582);
                            }
                        });
                        break;
                    } else {
                        h.cD(getApplicationContext(), getString(R.string.cbu));
                        AppMethodBeat.o(73585);
                        return;
                    }
                } else {
                    AppMethodBeat.o(73585);
                    return;
                }
        }
        AppMethodBeat.o(73585);
    }
}
