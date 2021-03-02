package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.protocal.protobuf.zk;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import java.net.URLEncoder;
import java.util.ArrayList;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareToTimeLineUI extends AutoLoginActivity implements i {
    private ProgressDialog gtM = null;
    private Intent intent;
    private Intent nUx;

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final boolean exA() {
        AppMethodBeat.i(39178);
        if (!bg.aVG() || bg.azj()) {
            Log.w("MicroMsg.ShareToTimeLine", "not login");
            gXT();
            AppMethodBeat.o(39178);
            return true;
        }
        AppMethodBeat.o(39178);
        return false;
    }

    private void gXT() {
        String str;
        AppMethodBeat.i(39179);
        Intent intent2 = getIntent();
        if (intent2 == null) {
            Log.e("MicroMsg.ShareToTimeLine", "launch : fail, intent is null");
            gXw();
            finish();
            AppMethodBeat.o(39179);
            return;
        }
        String action = intent2.getAction();
        Bundle extras = IntentUtil.getExtras(intent2);
        if (Util.isNullOrNil(action)) {
            Log.e("MicroMsg.ShareToTimeLine", "launch : fail, action is null");
            gXw();
            finish();
            AppMethodBeat.o(39179);
            return;
        }
        String stringExtra = IntentUtil.getStringExtra(intent2, "Kdescription");
        String resolveType = getIntent().resolveType(this);
        if (Util.isNullOrNil(resolveType)) {
            gXw();
            finish();
            AppMethodBeat.o(39179);
        } else if (!resolveType.contains("image")) {
            gXw();
            finish();
            AppMethodBeat.o(39179);
        } else if (!action.equals("android.intent.action.SEND") || extras == null) {
            Log.e("MicroMsg.ShareToTimeLine", "launch : fail, uri is null");
            gXw();
            finish();
            AppMethodBeat.o(39179);
        } else {
            Log.i("MicroMsg.ShareToTimeLine", "send signal: ".concat(String.valueOf(action)));
            Parcelable parcelable = extras.getParcelable("android.intent.extra.STREAM");
            if (parcelable != null && (parcelable instanceof Uri)) {
                Uri uri = (Uri) parcelable;
                if (!Util.isUriSafeToBeCopySrc(uri)) {
                    Log.e("MicroMsg.ShareToTimeLine", "deal : fail, not accept, %s", uri);
                    gXw();
                    finish();
                    AppMethodBeat.o(39179);
                    return;
                }
                String filePath = Util.getFilePath(this, uri);
                if (Util.isNullOrNil(filePath) || !new o(filePath).exists() || (Build.VERSION.SDK_INT >= 30 && !new o(filePath).canRead())) {
                    str = e.a(getContentResolver(), uri, 2);
                } else {
                    str = filePath;
                }
                if (Util.isNullOrNil(str) || !Util.isImageFilename(str)) {
                    if (intent2.getBooleanExtra("Ksnsupload_empty_img", false)) {
                        as(str, stringExtra, 4);
                        AppMethodBeat.o(39179);
                        return;
                    }
                    gXw();
                    finish();
                    AppMethodBeat.o(39179);
                } else if (bnU(str)) {
                    as(str, stringExtra, 0);
                    AppMethodBeat.o(39179);
                } else {
                    gXw();
                    finish();
                    AppMethodBeat.o(39179);
                }
            } else if (intent2.getBooleanExtra("Ksnsupload_empty_img", false)) {
                as(null, stringExtra, 4);
                AppMethodBeat.o(39179);
            } else {
                gXw();
                finish();
                AppMethodBeat.o(39179);
            }
        }
    }

    private static boolean bnU(String str) {
        AppMethodBeat.i(39180);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(39180);
            return false;
        }
        boolean isImgFile = ImgUtil.isImgFile(str);
        AppMethodBeat.o(39180);
        return isImgFile;
    }

    private void as(String str, String str2, int i2) {
        AppMethodBeat.i(39181);
        Intent intent2 = new Intent();
        ArrayList arrayList = new ArrayList();
        if (!Util.isNullOrNil(str)) {
            intent2.putExtra("sns_kemdia_path", str);
            intent2.putExtra("KFilterId", -1);
            arrayList.add(str);
        }
        if (!Util.isNullOrNil(str2)) {
            intent2.putExtra("Kdescription", str2);
        }
        if (i2 == 4 && Util.isNullOrNil(str) && !Util.isNullOrNil(str2)) {
            arrayList.add(str2);
        }
        if (!bg.aVG() || bg.azj()) {
            if (!Util.isNullOrNil(str)) {
                Intent intent3 = new Intent(this, ShareToTimeLineUI.class);
                intent3.putExtra("android.intent.extra.STREAM", FileProviderHelper.getUriForFile(getContext(), new o(str)));
                intent3.addFlags(32768).addFlags(268435456);
                intent3.setType("image/*");
                intent3.setAction("android.intent.action.SEND");
                MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(268435456).addFlags(32768), intent3);
            } else {
                gXw();
            }
            finish();
            AppMethodBeat.o(39181);
            return;
        }
        intent2.putExtra("K_go_to_SnsTimeLineUI", true);
        intent2.putExtra("Ksnsupload_source", 12);
        if (i2 == 0) {
            intent2.putExtra("KBlockAdd", true);
        }
        intent2.setClassName(this, "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
        this.nUx = intent2;
        g gVar = null;
        switch (i2) {
            case 0:
                gVar = new g(1, arrayList, getCallerPackage());
                break;
            case 4:
                gVar = new g(5, arrayList, getCallerPackage());
                break;
        }
        if (gVar != null) {
            bg.azz().a(837, this);
            com.tencent.mm.kernel.g.azz().a(gVar, 0);
            showDialog();
        }
        AppMethodBeat.o(39181);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(39182);
        bg.azz().b(837, this);
        super.onDestroy();
        AppMethodBeat.o(39182);
    }

    private void gXw() {
        AppMethodBeat.i(39183);
        Toast.makeText(this, (int) R.string.h0z, 1).show();
        AppMethodBeat.o(39183);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final boolean ab(Intent intent2) {
        return true;
    }

    private void showDialog() {
        AppMethodBeat.i(39184);
        getString(R.string.zb);
        this.gtM = h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.tools.ShareToTimeLineUI.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(39176);
                ShareToTimeLineUI.this.finish();
                AppMethodBeat.o(39176);
            }
        });
        AppMethodBeat.o(39184);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final void a(AutoLoginActivity.a aVar, Intent intent2) {
        AppMethodBeat.i(39185);
        switch (aVar) {
            case LOGIN_OK:
                this.intent = intent2;
                int i2 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SystemShareControlBitset"), 0);
                Log.i("MicroMsg.ShareToTimeLine", "now permission = %d", Integer.valueOf(i2));
                if ((i2 & 2) > 0) {
                    Log.e("MicroMsg.ShareToTimeLine", "now allowed to share to friend");
                    finish();
                    AppMethodBeat.o(39185);
                    return;
                }
                String stringExtra = IntentUtil.getStringExtra(intent2, "android.intent.extra.TEXT");
                Log.i("MicroMsg.ShareToTimeLine", "postLogin, text = %s", stringExtra);
                if (!Util.isNullOrNil(stringExtra)) {
                    String format = String.format("weixin://dl/business/systemshare/?txt=%s", URLEncoder.encode(stringExtra));
                    showDialog();
                    bg.azz().a(1200, this);
                    bg.azz().a(new ac(format, 15, null), 0);
                    AppMethodBeat.o(39185);
                    return;
                }
                gXT();
                AppMethodBeat.o(39185);
                return;
            default:
                finish();
                AppMethodBeat.o(39185);
                return;
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(39186);
        Log.i("MicroMsg.ShareToTimeLine", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        bg.azz().b(1200, this);
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
        }
        if (!(qVar instanceof ac)) {
            if (qVar instanceof g) {
                if (i2 == 0 && i3 == 0) {
                    a bl = new a().bl(this.nUx);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else if (qVar.getReqResp() != null) {
                    zk zkVar = (zk) ((d) qVar.getReqResp()).iLL.iLR;
                    if (zkVar == null || Util.isNullOrNil(zkVar.LkJ)) {
                        a bl2 = new a().bl(this.nUx);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl2.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareToTimeLineUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("rawUrl", zkVar.LkJ);
                        intent2.putExtra("showShare", false);
                        intent2.putExtra("show_bottom", false);
                        intent2.putExtra("needRedirect", false);
                        c.b(this, "webview", ".ui.tools.WebViewUI", intent2);
                    }
                }
            }
            AppMethodBeat.o(39186);
        } else if (i2 == 0 && i3 == 0) {
            gXT();
            AppMethodBeat.o(39186);
            return;
        } else {
            gXw();
        }
        finish();
        AppMethodBeat.o(39186);
    }
}
