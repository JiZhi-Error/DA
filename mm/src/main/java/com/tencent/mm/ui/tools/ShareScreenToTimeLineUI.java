package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vfs.o;

@a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141031", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareScreenToTimeLineUI extends MMActivity {
    String filePath = null;
    Uri uri = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39172);
        super.onCreate(bundle);
        setMMTitle("");
        int intExtra = IntentUtil.getIntExtra(getIntent(), "wizard_activity_result_code", 0);
        switch (intExtra) {
            case -1:
            case 0:
                NotifyReceiver.akF();
                bg.azz().a(new bu(new bu.a() {
                    /* class com.tencent.mm.ui.tools.ShareScreenToTimeLineUI.AnonymousClass1 */

                    @Override // com.tencent.mm.model.bu.a
                    public final void a(g gVar) {
                    }
                }), 0);
                initView();
                AppMethodBeat.o(39172);
                return;
            case 1:
                finish();
                AppMethodBeat.o(39172);
                return;
            default:
                Log.e("MicroMsg.ShareScreenToTimeLineUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(intExtra)));
                finish();
                AppMethodBeat.o(39172);
                return;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(39173);
        Intent intent = getIntent();
        if (intent == null) {
            Log.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, intent is null");
            gXw();
            finish();
            AppMethodBeat.o(39173);
            return;
        }
        String action = intent.getAction();
        this.uri = intent.getData();
        if (Util.isNullOrNil(action)) {
            Log.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, action is null");
            gXw();
            finish();
            AppMethodBeat.o(39173);
            return;
        }
        String stringExtra = IntentUtil.getStringExtra(intent, "Kdescription");
        String resolveType = getIntent().resolveType(this);
        if (Util.isNullOrNil(resolveType)) {
            gXw();
            finish();
            AppMethodBeat.o(39173);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            if (!resolveType.contains("heic") && !resolveType.contains("image")) {
                gXw();
                finish();
                AppMethodBeat.o(39173);
                return;
            }
        } else if (!resolveType.contains("image")) {
            gXw();
            finish();
            AppMethodBeat.o(39173);
            return;
        }
        if (action.equals("android.intent.action.VIEW")) {
            Log.i("MicroMsg.ShareScreenToTimeLineUI", "send signal: ".concat(String.valueOf(action)));
            if (!Util.isUriSafeToBeCopySrc(this.uri)) {
                Log.e("MicroMsg.ShareScreenToTimeLineUI", "fail, not accepted: %s", this.uri);
                gXw();
                finish();
                AppMethodBeat.o(39173);
                return;
            }
            Uri uri2 = this.uri;
            this.filePath = Util.getFilePath(this, uri2);
            if (Util.isNullOrNil(this.filePath) || !new o(this.filePath).exists()) {
                this.filePath = e.a(getContentResolver(), uri2, 1);
            }
            this.filePath = this.filePath;
            if (Util.isNullOrNil(this.filePath) || !new o(this.filePath).exists() || (Build.VERSION.SDK_INT >= 30 && !new o(this.filePath).canRead())) {
                this.filePath = e.a(getContentResolver(), this.uri, 2);
            }
            if (Util.isNullOrNil(this.filePath) || !Util.isImageFilename(this.filePath)) {
                if (IntentUtil.getBooleanExtra(intent, "Ksnsupload_empty_img", false)) {
                    no(this.filePath, stringExtra);
                    AppMethodBeat.o(39173);
                    return;
                }
                gXw();
                finish();
                AppMethodBeat.o(39173);
            } else if (ImgUtil.isImgFile(this.filePath)) {
                no(this.filePath, stringExtra);
                AppMethodBeat.o(39173);
            } else {
                gXw();
                finish();
                AppMethodBeat.o(39173);
            }
        } else {
            Log.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, uri is null");
            gXw();
            finish();
            AppMethodBeat.o(39173);
        }
    }

    private void no(String str, String str2) {
        AppMethodBeat.i(39174);
        Intent intent = new Intent();
        if (!Util.isNullOrNil(str)) {
            intent.putExtra("sns_kemdia_path", str);
            intent.putExtra("KFilterId", -1);
        }
        if (!Util.isNullOrNil(str2)) {
            intent.putExtra("Kdescription", str2);
        }
        if (bg.aVG() && !bg.azj()) {
            intent.putExtra("K_go_to_SnsTimeLineUI", true);
            c.b(this, "sns", ".ui.SnsUploadUI", intent);
        } else if (!Util.isNullOrNil(str)) {
            Intent intent2 = new Intent(this, ShareToTimeLineUI.class);
            intent2.putExtra("android.intent.extra.STREAM", FileProviderHelper.getUriForFile(getContext(), new o(str)));
            intent2.addFlags(32768).addFlags(268435456);
            intent2.setType("image/*");
            intent2.setAction("android.intent.action.SEND");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent2);
        } else {
            gXw();
        }
        finish();
        AppMethodBeat.o(39174);
    }

    private void gXw() {
        AppMethodBeat.i(39175);
        Toast.makeText(this, (int) R.string.h0z, 1).show();
        AppMethodBeat.o(39175);
    }
}
