package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.zk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.snackbar.a;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;

@com.tencent.mm.ui.base.a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141010", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class AddFavoriteUI extends MMActivity implements i {
    private cz Qpa;
    ArrayList<String> Qpb = null;
    private MMHandler Qpc = new MMHandler() {
        /* class com.tencent.mm.ui.tools.AddFavoriteUI.AnonymousClass10 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(38946);
            AddFavoriteUI.d(AddFavoriteUI.this);
            Log.i("MicroMsg.AddFavoriteUI", "dealWithText: %b", Boolean.valueOf(AddFavoriteUI.e(AddFavoriteUI.this)));
            AppMethodBeat.o(38946);
        }
    };
    private MMHandler Qpd = new MMHandler() {
        /* class com.tencent.mm.ui.tools.AddFavoriteUI.AnonymousClass11 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(38947);
            AddFavoriteUI.d(AddFavoriteUI.this);
            AddFavoriteUI.f(AddFavoriteUI.this);
            AppMethodBeat.o(38947);
        }
    };
    String filePath = null;
    private ProgressDialog gtM = null;
    private MMHandler handler = new MMHandler() {
        /* class com.tencent.mm.ui.tools.AddFavoriteUI.AnonymousClass12 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(38948);
            AddFavoriteUI.d(AddFavoriteUI.this);
            if (Util.isNullOrNil(AddFavoriteUI.this.filePath) || (Util.isImageFilename(AddFavoriteUI.this.filePath) && !AddFavoriteUI.bnN(AddFavoriteUI.this.filePath))) {
                Log.e("MicroMsg.AddFavoriteUI", "launch : fail, filePath is null or file is not a valid img.");
                AddFavoriteUI.g(AddFavoriteUI.this);
                AddFavoriteUI.this.finish();
                AppMethodBeat.o(38948);
                return;
            }
            AddFavoriteUI.h(AddFavoriteUI.this);
            AppMethodBeat.o(38948);
        }
    };
    private Intent intent = null;
    Uri uri = null;

    public interface b {
        void gXx();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AddFavoriteUI() {
        AppMethodBeat.i(38953);
        AppMethodBeat.o(38953);
    }

    static /* synthetic */ int bnO(String str) {
        AppMethodBeat.i(38977);
        int bnM = bnM(str);
        AppMethodBeat.o(38977);
        return bnM;
    }

    static /* synthetic */ void d(AddFavoriteUI addFavoriteUI) {
        AppMethodBeat.i(38970);
        addFavoriteUI.dismissDialog();
        AppMethodBeat.o(38970);
    }

    static /* synthetic */ boolean e(AddFavoriteUI addFavoriteUI) {
        AppMethodBeat.i(38971);
        boolean gXv = addFavoriteUI.gXv();
        AppMethodBeat.o(38971);
        return gXv;
    }

    static /* synthetic */ void g(AddFavoriteUI addFavoriteUI) {
        AppMethodBeat.i(38974);
        addFavoriteUI.gXw();
        AppMethodBeat.o(38974);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38954);
        Log.i("MicroMsg.AddFavoriteUI", "on create");
        super.onCreate(bundle);
        setTitleVisibility(8);
        int intExtra = IntentUtil.getIntExtra(getIntent(), "wizard_activity_result_code", 0);
        switch (intExtra) {
            case -1:
            case 0:
                NotifyReceiver.akF();
                initView();
                AppMethodBeat.o(38954);
                return;
            case 1:
                finish();
                AppMethodBeat.o(38954);
                return;
            default:
                Log.e("MicroMsg.AddFavoriteUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(intExtra)));
                finish();
                AppMethodBeat.o(38954);
                return;
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(38955);
        Log.i("MicroMsg.AddFavoriteUI", "on SaveInstanceState");
        super.onSaveInstanceState(bundle);
        AppMethodBeat.o(38955);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent2) {
        AppMethodBeat.i(38956);
        Log.i("MicroMsg.AddFavoriteUI", "on NewIntent");
        super.onNewIntent(intent2);
        AppMethodBeat.o(38956);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.i(38957);
        Log.i("MicroMsg.AddFavoriteUI", "on RestoreInstanceState");
        super.onRestoreInstanceState(bundle);
        AppMethodBeat.o(38957);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(38958);
        Log.i("MicroMsg.AddFavoriteUI", "on Destroy");
        bg.azz().b(837, this);
        super.onDestroy();
        AppMethodBeat.o(38958);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    private void gXu() {
        AppMethodBeat.i(38960);
        Intent intent2 = new Intent(this, AddFavoriteUI.class);
        intent2.setAction("android.intent.action.SEND");
        intent2.putExtra("android.intent.extra.STREAM", Util.isNullOrNil(this.filePath) ? null : FileProviderHelper.getUriForFile(getContext(), new o(this.filePath)));
        intent2.addFlags(268435456).addFlags(32768);
        intent2.setType(getIntent().getType());
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent2);
        AppMethodBeat.o(38960);
    }

    private boolean gXv() {
        AppMethodBeat.i(38961);
        this.intent = getIntent();
        if (this.intent == null) {
            Log.e("MicroMsg.AddFavoriteUI", "intent is null");
            AppMethodBeat.o(38961);
            return false;
        }
        String stringExtra = IntentUtil.getStringExtra(this.intent, "android.intent.extra.TEXT");
        if (stringExtra == null || stringExtra.length() == 0) {
            Log.i("MicroMsg.AddFavoriteUI", "text is null");
            AppMethodBeat.o(38961);
            return false;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXTextObject(stringExtra));
        wXMediaMessage.description = stringExtra;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = null;
        req.message = wXMediaMessage;
        int type = req.message.getType();
        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        bundle.putInt(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
        bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
        bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
        if (!bg.aVG() || bg.azj()) {
            Log.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
            finish();
        } else {
            cz czVar = new cz();
            String str = s.bpb(this.filePath) + "." + s.akC(this.filePath);
            if (type == 1) {
                Boolean.valueOf(h.b(czVar, stringExtra, 13));
            } else {
                Boolean.valueOf(h.a(czVar, 13, this.filePath, str, "", false));
            }
            czVar.dFZ.activity = this;
            czVar.dFZ.dGg = new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.tools.AddFavoriteUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(38940);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(38940);
                }
            };
            czVar.dFZ.dGh = new a.c() {
                /* class com.tencent.mm.ui.tools.AddFavoriteUI.AnonymousClass4 */

                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                public final void onShow() {
                }

                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                public final void onHide() {
                    AppMethodBeat.i(38941);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(38941);
                }

                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                public final void bDY() {
                }
            };
            this.Qpa = czVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add(stringExtra);
            g gVar = new g(5, arrayList, getCallerPackage());
            bg.azz().a(837, this);
            com.tencent.mm.kernel.g.azz().a(gVar, 0);
            showDialog();
        }
        AppMethodBeat.o(38961);
        return true;
    }

    private void n(int i2, String str, boolean z) {
        g gVar;
        WXMediaMessage.IMediaObject iMediaObject;
        AppMethodBeat.i(38962);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, filePath is empty");
            AppMethodBeat.o(38962);
            return;
        }
        long boW = s.boW(str);
        Log.i("MicroMsg.AddFavoriteUI", "filelength: [%d]", Long.valueOf(boW));
        if (boW == 0) {
            Log.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is 0");
            Toast.makeText(this, (int) R.string.c_l, 1).show();
            finish();
            AppMethodBeat.o(38962);
            return;
        }
        int favSizeLimit = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavSizeLimit(z, i2);
        int favSizeLimitInMB = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavSizeLimitInMB(z, i2);
        if (boW > ((long) favSizeLimit)) {
            Log.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is too large");
            Toast.makeText(this, getString(R.string.ccw, new Object[]{Integer.valueOf(favSizeLimitInMB)}), 1).show();
            finish();
            AppMethodBeat.o(38962);
        } else if (!bg.aVG() || bg.azj()) {
            Log.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
            finish();
            gXu();
            AppMethodBeat.o(38962);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            cz czVar = new cz();
            String str2 = s.bpb(str) + "." + s.akC(str);
            switch (i2) {
                case 2:
                    iMediaObject = new WXImageObject();
                    ((WXImageObject) iMediaObject).setImagePath(str);
                    gVar = new g(1, arrayList, getCallerPackage());
                    h.a(czVar, 13, str);
                    break;
                case 3:
                default:
                    WXMediaMessage.IMediaObject wXFileObject = new WXFileObject(str);
                    gVar = new g(4, arrayList, getCallerPackage());
                    h.a(czVar, 13, str, str2, "", z);
                    iMediaObject = wXFileObject;
                    break;
                case 4:
                    WXMediaMessage.IMediaObject wXVideoFileObject = new WXVideoFileObject(str);
                    g gVar2 = new g(3, arrayList, getCallerPackage());
                    h.a(czVar, 13, str, null, 0, str2, "", z);
                    gVar = gVar2;
                    iMediaObject = wXVideoFileObject;
                    break;
            }
            WXMediaMessage wXMediaMessage = new WXMediaMessage(iMediaObject);
            wXMediaMessage.title = new o(str).getName();
            if (Util.isNullOrNil((String) null)) {
                wXMediaMessage.description = Util.getSizeKB(boW);
            } else {
                wXMediaMessage.description = null;
            }
            if (boW < 30720) {
                wXMediaMessage.thumbData = s.aW(str, 0, -1);
            } else {
                Log.i("MicroMsg.AddFavoriteUI", "thumb data is exceed 30k, ignore");
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = null;
            req.message = wXMediaMessage;
            Bundle bundle = new Bundle();
            req.toBundle(bundle);
            bundle.putInt(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
            bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
            bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
            czVar.dFZ.activity = this;
            czVar.dFZ.dGg = new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.tools.AddFavoriteUI.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(38942);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(38942);
                }
            };
            czVar.dFZ.dGh = new a.c() {
                /* class com.tencent.mm.ui.tools.AddFavoriteUI.AnonymousClass6 */

                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                public final void onShow() {
                }

                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                public final void onHide() {
                    AppMethodBeat.i(38943);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(38943);
                }

                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                public final void bDY() {
                }
            };
            this.Qpa = czVar;
            com.tencent.mm.kernel.g.azz().a(837, this);
            com.tencent.mm.kernel.g.azz().a(gVar, 0);
            showDialog();
            AppMethodBeat.o(38962);
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        private b Qpf;
        private Uri mUri;

        public a(Uri uri, b bVar) {
            this.mUri = uri;
            this.Qpf = bVar;
        }

        public final void run() {
            AppMethodBeat.i(38952);
            try {
                AddFavoriteUI.this.filePath = AddFavoriteUI.a(AddFavoriteUI.this, this.mUri);
                if (Util.isNullOrNil(AddFavoriteUI.this.filePath) || !new o(AddFavoriteUI.this.filePath).exists() || (Build.VERSION.SDK_INT >= 30 && !new o(AddFavoriteUI.this.filePath).canRead())) {
                    if (AddFavoriteUI.bnO(AddFavoriteUI.this.getContentResolver().getType(this.mUri)) == 2) {
                        AddFavoriteUI.this.filePath = e.a(AddFavoriteUI.this.getContentResolver(), this.mUri, 1);
                    } else {
                        AddFavoriteUI.this.filePath = e.b(AddFavoriteUI.this.getContentResolver(), this.mUri);
                    }
                }
                if (this.Qpf != null) {
                    this.Qpf.gXx();
                    AppMethodBeat.o(38952);
                    return;
                }
            } catch (IllegalAccessException e2) {
                Log.printErrStackTrace("MicroMsg.AddFavoriteUI", e2, "", new Object[0]);
                AddFavoriteUI.this.filePath = null;
                if (this.Qpf != null) {
                    this.Qpf.gXx();
                    AppMethodBeat.o(38952);
                    return;
                }
            } catch (Throwable th) {
                if (this.Qpf != null) {
                    this.Qpf.gXx();
                }
                AppMethodBeat.o(38952);
                throw th;
            }
            AppMethodBeat.o(38952);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0207 A[Catch:{ Exception -> 0x020e }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0160 A[SYNTHETIC, Splitter:B:61:0x0160] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0165 A[Catch:{ Exception -> 0x016e }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x016a A[Catch:{ Exception -> 0x016e }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x019c A[SYNTHETIC, Splitter:B:73:0x019c] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a1 A[Catch:{ Exception -> 0x01aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01a6 A[Catch:{ Exception -> 0x01aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01d9 A[SYNTHETIC, Splitter:B:85:0x01d9] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01de A[Catch:{ Exception -> 0x01e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e3 A[Catch:{ Exception -> 0x01e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01fd A[SYNTHETIC, Splitter:B:96:0x01fd] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0202 A[Catch:{ Exception -> 0x020e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(android.net.Uri r11, android.database.Cursor r12) {
        /*
        // Method dump skipped, instructions count: 582
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.tools.AddFavoriteUI.a(android.net.Uri, android.database.Cursor):java.lang.String");
    }

    private static int bnM(String str) {
        AppMethodBeat.i(38964);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AddFavoriteUI", "map : mimeType is null");
            AppMethodBeat.o(38964);
            return -1;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("image") || lowerCase.equals("application/vnd.google.panorama360+jpg")) {
            AppMethodBeat.o(38964);
            return 2;
        } else if (lowerCase.contains("video")) {
            AppMethodBeat.o(38964);
            return 4;
        } else {
            Log.d("MicroMsg.AddFavoriteUI", "map : unknown mimetype, send as file");
            AppMethodBeat.o(38964);
            return 8;
        }
    }

    private void gXw() {
        AppMethodBeat.i(38965);
        aon(0);
        Toast.makeText(this, (int) R.string.h0x, 1).show();
        AppMethodBeat.o(38965);
    }

    private void aon(int i2) {
        AppMethodBeat.i(38966);
        switch (i2) {
            case 1:
                Toast.makeText(this, (int) R.string.h0u, 1).show();
                AppMethodBeat.o(38966);
                return;
            default:
                Toast.makeText(this, (int) R.string.h0x, 1).show();
                AppMethodBeat.o(38966);
                return;
        }
    }

    private void showDialog() {
        AppMethodBeat.i(38967);
        getString(R.string.zb);
        this.gtM = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.tools.AddFavoriteUI.AnonymousClass7 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(38967);
    }

    private void dismissDialog() {
        AppMethodBeat.i(38968);
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
        }
        AppMethodBeat.o(38968);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(38969);
        Log.i("MicroMsg.AddFavoriteUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        dismissDialog();
        if (qVar instanceof g) {
            if (i2 == 0 && i3 == 0) {
                if (this.Qpa != null) {
                    EventCenter.instance.publish(this.Qpa);
                    this.Qpa = null;
                    AppMethodBeat.o(38969);
                    return;
                }
            } else if (qVar.getReqResp() != null) {
                zk zkVar = (zk) ((d) qVar.getReqResp()).iLL.iLR;
                if (zkVar != null && !Util.isNullOrNil(zkVar.LkJ)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", zkVar.LkJ);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    intent2.putExtra("needRedirect", false);
                    c.b(this, "webview", ".ui.tools.WebViewUI", intent2);
                    finish();
                    AppMethodBeat.o(38969);
                    return;
                } else if (this.Qpa != null) {
                    EventCenter.instance.publish(this.Qpa);
                    this.Qpa = null;
                }
            }
        }
        AppMethodBeat.o(38969);
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x016b A[SYNTHETIC] */
    @Override // com.tencent.mm.ui.MMActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
        // Method dump skipped, instructions count: 556
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.tools.AddFavoriteUI.initView():void");
    }

    static /* synthetic */ void f(AddFavoriteUI addFavoriteUI) {
        ArrayList<? extends Parcelable> arrayList;
        AppMethodBeat.i(38972);
        Log.i("MicroMsg.AddFavoriteUI", "filepath:[%s]", addFavoriteUI.filePath);
        int bnM = bnM(addFavoriteUI.getIntent().resolveType(addFavoriteUI));
        if (bnM == -1) {
            Log.e("MicroMsg.AddFavoriteUI", "launch, msgType is invalid");
            addFavoriteUI.finish();
            AppMethodBeat.o(38972);
            return;
        }
        Log.i("MicroMsg.AddFavoriteUI", "filepath:[%s] dealWithMultiItem msgType is %d", addFavoriteUI.filePath, Integer.valueOf(bnM));
        if (bnM == 8 && !Util.isNullOrNil(addFavoriteUI.filePath)) {
            addFavoriteUI.n(bnM, addFavoriteUI.filePath, false);
            AppMethodBeat.o(38972);
        } else if (IntentUtil.getBooleanExtra(addFavoriteUI.getIntent(), "Intro_Switch", false) || !bg.aVG() || bg.azj()) {
            Intent intent2 = new Intent(addFavoriteUI, AddFavoriteUI.class);
            intent2.setAction("android.intent.action.SEND_MULTIPLE");
            if (Util.isNullOrNil(addFavoriteUI.Qpb)) {
                arrayList = new ArrayList<>(0);
            } else {
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(addFavoriteUI.Qpb.size());
                Iterator<String> it = addFavoriteUI.Qpb.iterator();
                while (it.hasNext()) {
                    arrayList2.add(FileProviderHelper.getUriForFile(addFavoriteUI.getContext(), new o(it.next())));
                }
                arrayList = arrayList2;
            }
            intent2.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            intent2.addFlags(268435456).addFlags(32768);
            intent2.setType(addFavoriteUI.getIntent().getType());
            MMWizardActivity.b(addFavoriteUI, new Intent(addFavoriteUI, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent2);
            addFavoriteUI.finish();
            AppMethodBeat.o(38972);
        } else {
            cz czVar = new cz();
            ArrayList<String> arrayList3 = addFavoriteUI.Qpb;
            if (arrayList3 == null || arrayList3.isEmpty()) {
                Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or paths is empty");
                czVar.dFZ.dGe = R.string.c_2;
            } else if (arrayList3.size() > 9) {
                czVar.dFZ.dGe = R.string.c_9;
            } else {
                Log.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple images), paths %s sourceType %d", arrayList3, 13);
                anb anb = new anb();
                anh anh = new anh();
                for (String str : arrayList3) {
                    if (!Util.isNullOrNil(str)) {
                        aml aml = new aml();
                        aml.ajd(2);
                        aml.bgt(str);
                        aml.At(true);
                        anb.ppH.add(aml);
                    }
                }
                anh.bhf(z.aTY());
                anh.bhg(z.aTY());
                anh.ajm(13);
                anh.MA(Util.nowMilliSecond());
                anb.a(anh);
                czVar.dFZ.title = "";
                czVar.dFZ.dGb = anb;
                czVar.dFZ.type = 2;
            }
            czVar.dFZ.activity = addFavoriteUI;
            czVar.dFZ.dGg = new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.tools.AddFavoriteUI.AnonymousClass13 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(38949);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(38949);
                }
            };
            czVar.dFZ.dGh = new a.c() {
                /* class com.tencent.mm.ui.tools.AddFavoriteUI.AnonymousClass14 */

                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                public final void onShow() {
                }

                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                public final void onHide() {
                    AppMethodBeat.i(38950);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(38950);
                }

                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                public final void bDY() {
                }
            };
            bg.azz().a(837, addFavoriteUI);
            com.tencent.mm.kernel.g.azz().a(new g(1, addFavoriteUI.Qpb, addFavoriteUI.getCallerPackage()), 0);
            addFavoriteUI.showDialog();
            addFavoriteUI.Qpa = czVar;
            AppMethodBeat.o(38972);
        }
    }

    static /* synthetic */ boolean bnN(String str) {
        AppMethodBeat.i(38973);
        boolean isImgFile = ImgUtil.isImgFile(str);
        AppMethodBeat.o(38973);
        return isImgFile;
    }

    static /* synthetic */ void h(AddFavoriteUI addFavoriteUI) {
        AppMethodBeat.i(38975);
        Log.i("MicroMsg.AddFavoriteUI", "filepath:[%s]", addFavoriteUI.filePath);
        int bnM = bnM(addFavoriteUI.getIntent().resolveType(addFavoriteUI));
        if (bnM == -1) {
            Log.e("MicroMsg.AddFavoriteUI", "launch, msgType is invalid");
            addFavoriteUI.finish();
            AppMethodBeat.o(38975);
            return;
        }
        Log.i("MicroMsg.AddFavoriteUI", "filepath:[%s] dealWithSimpleItem msgType is %d", addFavoriteUI.filePath, Integer.valueOf(bnM));
        if (!Util.isNullOrNil(addFavoriteUI.filePath)) {
            addFavoriteUI.n(bnM, addFavoriteUI.filePath, true);
            AppMethodBeat.o(38975);
        } else if (IntentUtil.getBooleanExtra(addFavoriteUI.getIntent(), "Intro_Switch", false) || !bg.aVG() || bg.azj()) {
            addFavoriteUI.finish();
            addFavoriteUI.gXu();
            AppMethodBeat.o(38975);
        } else {
            cz czVar = new cz();
            h.a(czVar, 13, addFavoriteUI.filePath);
            czVar.dFZ.activity = addFavoriteUI;
            czVar.dFZ.dGg = new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.tools.AddFavoriteUI.AnonymousClass15 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(38951);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(38951);
                }
            };
            czVar.dFZ.dGh = new a.c() {
                /* class com.tencent.mm.ui.tools.AddFavoriteUI.AnonymousClass2 */

                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                public final void onShow() {
                }

                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                public final void onHide() {
                    AppMethodBeat.i(38939);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(38939);
                }

                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                public final void bDY() {
                }
            };
            EventCenter.instance.publish(czVar);
            AppMethodBeat.o(38975);
        }
    }

    static /* synthetic */ String a(AddFavoriteUI addFavoriteUI, Uri uri2) {
        AppMethodBeat.i(38976);
        String scheme = uri2.getScheme();
        if (Util.isNullOrNil(scheme)) {
            Log.e("MicroMsg.AddFavoriteUI", "input uri error. %s", uri2);
            AppMethodBeat.o(38976);
            return null;
        } else if (scheme.equalsIgnoreCase("file")) {
            Log.i("MicroMsg.AddFavoriteUI", "getFilePath : scheme is SCHEME_FILE");
            String path = uri2.getPath();
            String beo = e.beo(path);
            if (beo != null) {
                AppMethodBeat.o(38976);
                return beo;
            }
            Log.e("MicroMsg.AddFavoriteUI", "[-] getFilePath : fail, safePath is null.");
            IllegalAccessException illegalAccessException = new IllegalAccessException("safePath is null while process path: ".concat(String.valueOf(path)));
            AppMethodBeat.o(38976);
            throw illegalAccessException;
        } else if (scheme.equalsIgnoreCase("content")) {
            Log.i("MicroMsg.AddFavoriteUI", "getFilePath : scheme is SCHEME_CONTENT: " + uri2.toString());
            Cursor query = addFavoriteUI.getContentResolver().query(uri2, null, null, null, null);
            if (query == null) {
                Log.e("MicroMsg.AddFavoriteUI", "getFilePath : fail, cursor is null");
                AppMethodBeat.o(38976);
                return null;
            } else if (query.getCount() <= 0 || !query.moveToFirst()) {
                query.close();
                Log.e("MicroMsg.AddFavoriteUI", "getFilePath : fail, cursor getCount is 0 or moveToFirst fail");
                AppMethodBeat.o(38976);
                return null;
            } else {
                String lowerCase = uri2.toString().toLowerCase();
                if (lowerCase.startsWith("content://com.android.contacts/contacts/as_vcard") || lowerCase.startsWith("content://com.android.contacts/contacts/as_multi_vcard") || lowerCase.startsWith("content://com.mediatek.calendarimporter") || ((addFavoriteUI.intent != null && addFavoriteUI.intent.getType().equals("text/x-vcalendar")) || ae.gKE.gGM == 1)) {
                    String a2 = addFavoriteUI.a(uri2, query);
                    AppMethodBeat.o(38976);
                    return a2;
                }
                query.close();
                String filePath2 = Util.getFilePath(addFavoriteUI, uri2);
                AppMethodBeat.o(38976);
                return filePath2;
            }
        } else {
            Log.e("MicroMsg.AddFavoriteUI", "unknown scheme");
            AppMethodBeat.o(38976);
            return null;
        }
    }
}
