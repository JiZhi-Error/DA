package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.o;

@a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141031", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareScreenImgUI extends MMActivity {
    String filePath = null;
    private ProgressDialog gtM = null;
    private MMHandler handler = new MMHandler() {
        /* class com.tencent.mm.ui.tools.ShareScreenImgUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(39162);
            ShareScreenImgUI.a(ShareScreenImgUI.this);
            if (Util.isNullOrNil(ShareScreenImgUI.this.filePath)) {
                Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
                ShareScreenImgUI.b(ShareScreenImgUI.this);
                ShareScreenImgUI.this.finish();
                AppMethodBeat.o(39162);
                return;
            }
            ShareScreenImgUI.c(ShareScreenImgUI.this);
            AppMethodBeat.o(39162);
        }
    };
    private Intent intent = null;
    Uri uri = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShareScreenImgUI() {
        AppMethodBeat.i(39163);
        AppMethodBeat.o(39163);
    }

    static /* synthetic */ void c(ShareScreenImgUI shareScreenImgUI) {
        AppMethodBeat.i(39171);
        shareScreenImgUI.gXT();
        AppMethodBeat.o(39171);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39164);
        super.onCreate(bundle);
        setMMTitle("");
        int intExtra = IntentUtil.getIntExtra(getIntent(), "wizard_activity_result_code", 0);
        switch (intExtra) {
            case -1:
            case 0:
                NotifyReceiver.akF();
                initView();
                AppMethodBeat.o(39164);
                return;
            case 1:
                finish();
                AppMethodBeat.o(39164);
                return;
            default:
                Log.e("MicroMsg.ShareScreenImgUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(intExtra)));
                finish();
                AppMethodBeat.o(39164);
                return;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    private void gXT() {
        AppMethodBeat.i(39166);
        Log.i("MicroMsg.ShareScreenImgUI", "filepath:[%s]", this.filePath);
        Intent intent2 = getIntent();
        int bnM = bnM(intent2.resolveType(this));
        if (bnM == -1) {
            Log.e("MicroMsg.ShareScreenImgUI", "launch, msgType is invalid");
            finish();
            AppMethodBeat.o(39166);
            return;
        }
        if (!IntentUtil.getBooleanExtra(getIntent(), "Intro_Switch", false) && bg.aVG() && !bg.azj()) {
            intent2.setData(this.uri);
            intent2.setClass(this, MsgRetransmitUI.class);
            intent2.putExtra("Retr_File_Name", this.filePath);
            intent2.putExtra("Retr_Msg_Type", bnM);
            intent2.putExtra("Retr_Scene", 1);
            intent2.putExtra("Retr_start_where_you_are", false);
            intent2.addFlags(67108864);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/tools/ShareScreenImgUI", "deal", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareScreenImgUI", "deal", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } else if (!Util.isNullOrNil(this.filePath)) {
            Intent intent3 = new Intent(this, ShareImgUI.class);
            intent3.putExtra("android.intent.extra.STREAM", FileProviderHelper.getUriForFile(getContext(), new o(this.filePath)));
            intent3.addFlags(67108864);
            intent3.setType("image/*");
            intent3.setAction("android.intent.action.SEND");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent3);
        } else {
            gXU();
        }
        finish();
        AppMethodBeat.o(39166);
    }

    private static int bnM(String str) {
        AppMethodBeat.i(39167);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.ShareScreenImgUI", "map : mimeType is null");
            AppMethodBeat.o(39167);
            return -1;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("image") || (Build.VERSION.SDK_INT >= 28 && lowerCase.contains("heic"))) {
            AppMethodBeat.o(39167);
            return 0;
        }
        Log.d("MicroMsg.ShareScreenImgUI", "map : unknown mimetype, send as file");
        AppMethodBeat.o(39167);
        return 3;
    }

    private void gXU() {
        AppMethodBeat.i(39168);
        Toast.makeText(this, (int) R.string.h0x, 1).show();
        AppMethodBeat.o(39168);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(39165);
        this.intent = getIntent();
        if (this.intent == null) {
            Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, intent is null");
            gXU();
            finish();
            AppMethodBeat.o(39165);
            return;
        }
        Log.i("MicroMsg.ShareScreenImgUI", "intent = " + this.intent);
        String action = this.intent.getAction();
        this.uri = this.intent.getData();
        if (Util.isNullOrNil(action)) {
            Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, action is null");
            gXU();
            finish();
            AppMethodBeat.o(39165);
        } else if (action.equals("android.intent.action.VIEW")) {
            Log.i("MicroMsg.ShareScreenImgUI", "send signal: ".concat(String.valueOf(action)));
            if (this.uri == null || !Util.isUriSafeToBeCopySrc(this.uri)) {
                Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, not accepted: %s", this.uri);
                gXU();
                finish();
                AppMethodBeat.o(39165);
                return;
            }
            getString(R.string.zb);
            this.gtM = h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.tools.ShareScreenImgUI.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            Uri uri2 = this.uri;
            this.filePath = Util.getFilePath(this, uri2);
            if (Util.isNullOrNil(this.filePath) || !new o(this.filePath).exists() || (Build.VERSION.SDK_INT >= 30 && !new o(this.filePath).canRead())) {
                this.filePath = e.a(getContentResolver(), uri2, 1);
            }
            this.filePath = this.filePath;
            if (Util.isNullOrNil(this.filePath) || !ImgUtil.isImgFile(this.filePath)) {
                Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
                gXU();
                finish();
                AppMethodBeat.o(39165);
                return;
            }
            gXT();
            AppMethodBeat.o(39165);
        } else {
            Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, uri is null");
            gXU();
            finish();
            AppMethodBeat.o(39165);
        }
    }

    static /* synthetic */ void a(ShareScreenImgUI shareScreenImgUI) {
        AppMethodBeat.i(39169);
        if (shareScreenImgUI.gtM != null && shareScreenImgUI.gtM.isShowing()) {
            shareScreenImgUI.gtM.dismiss();
        }
        AppMethodBeat.o(39169);
    }

    static /* synthetic */ void b(ShareScreenImgUI shareScreenImgUI) {
        AppMethodBeat.i(39170);
        shareScreenImgUI.gXU();
        AppMethodBeat.o(39170);
    }
}
