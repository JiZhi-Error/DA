package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDiskIOException;
import android.graphics.BitmapFactory;
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
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.n.h;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.protocal.protobuf.zk;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SelectNoSupportUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareImgUI extends AutoLoginActivity implements i {
    private DialogInterface.OnCancelListener CJj = null;
    ArrayList<String> Qpb = null;
    private ArrayList<q> Qwz = new ArrayList<>();
    String filePath = null;
    private ProgressDialog gtM = null;
    private MMHandler handler = new MMHandler() {
        /* class com.tencent.mm.ui.tools.ShareImgUI.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(39133);
            if (Util.isNullOrNil(ShareImgUI.this.filePath)) {
                Log.e("MicroMsg.ShareImgUI", "launch : fail, filePath is null");
                ShareImgUI.d(ShareImgUI.this);
                ShareImgUI.this.finish();
                AppMethodBeat.o(39133);
                return;
            }
            ShareImgUI.c(ShareImgUI.this);
            AppMethodBeat.o(39133);
        }
    };
    private Intent intent = null;
    Intent nUx = null;
    Uri uri = null;

    /* access modifiers changed from: package-private */
    public interface b {
        void br(ArrayList<String> arrayList);
    }

    public interface c {
        void gXx();
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShareImgUI() {
        AppMethodBeat.i(39140);
        AppMethodBeat.o(39140);
    }

    static /* synthetic */ void b(ShareImgUI shareImgUI) {
        AppMethodBeat.i(39155);
        shareImgUI.aon(1);
        AppMethodBeat.o(39155);
    }

    static /* synthetic */ int bnT(String str) {
        AppMethodBeat.i(39161);
        int bnM = bnM(str);
        AppMethodBeat.o(39161);
        return bnM;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final boolean ab(Intent intent2) {
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final boolean exA() {
        AppMethodBeat.i(39141);
        if (!bg.aVG() || bg.azj()) {
            Log.w("MicroMsg.ShareImgUI", "not login");
            this.intent = getIntent();
            brd();
            AppMethodBeat.o(39141);
            return true;
        }
        AppMethodBeat.o(39141);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(234466);
        super.onCreate(bundle);
        Log.i("MicroMsg.ShareImgUI", "ShareImgUI onCreate %d", Integer.valueOf(hashCode()));
        AppMethodBeat.o(234466);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(234467);
        super.onResume();
        Log.i("MicroMsg.ShareImgUI", "ShareImgUI onResume %d", Integer.valueOf(hashCode()));
        AppMethodBeat.o(234467);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(234468);
        super.onPause();
        Log.i("MicroMsg.ShareImgUI", "ShareImgUI onPause %d", Integer.valueOf(hashCode()));
        AppMethodBeat.o(234468);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final void a(AutoLoginActivity.a aVar, Intent intent2) {
        AppMethodBeat.i(39142);
        switch (aVar) {
            case LOGIN_OK:
                this.intent = intent2;
                int i2 = Util.getInt(h.aqJ().getValue("SystemShareControlBitset"), 0);
                Log.i("MicroMsg.ShareImgUI", "now permission = %d", Integer.valueOf(i2));
                if ((i2 & 1) > 0) {
                    Log.e("MicroMsg.ShareImgUI", "now allowed to share to friend");
                    finish();
                    AppMethodBeat.o(39142);
                    return;
                }
                String stringExtra = IntentUtil.getStringExtra(intent2, "android.intent.extra.TEXT");
                Log.i("MicroMsg.ShareImgUI", "postLogin, text = %s", stringExtra);
                if (!Util.isNullOrNil(stringExtra)) {
                    String format = String.format("weixin://dl/business/systemshare/?txt=%s", URLEncoder.encode(stringExtra));
                    showDialog();
                    bg.azz().b(1200, this);
                    bg.azz().a(1200, this);
                    ac acVar = new ac(format, 15, null);
                    bg.azz().a(acVar, 0);
                    this.Qwz.add(acVar);
                    AppMethodBeat.o(39142);
                    return;
                }
                brd();
                AppMethodBeat.o(39142);
                return;
            default:
                finish();
                com.tencent.mm.ui.base.b.kd(this);
                AppMethodBeat.o(39142);
                return;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(39143);
        bg.azz().b(1200, this);
        bg.azz().b(837, this);
        dismissDialog();
        super.onDestroy();
        AppMethodBeat.o(39143);
    }

    private void brd() {
        Parcelable parcelable;
        AppMethodBeat.i(39144);
        if (this.intent == null) {
            Log.e("MicroMsg.ShareImgUI", "launch : fail, intent is null");
            aon(0);
            finish();
            AppMethodBeat.o(39144);
            return;
        }
        String action = this.intent.getAction();
        Bundle extras = this.intent.getExtras();
        if (Util.isNullOrNil(action)) {
            Log.e("MicroMsg.ShareImgUI", "launch : fail, action is null");
            aon(0);
            finish();
            AppMethodBeat.o(39144);
            return;
        }
        if (!(extras == null || (parcelable = extras.getParcelable("android.intent.extra.STREAM")) == null || !(parcelable instanceof Uri))) {
            this.uri = (Uri) parcelable;
            if (!Util.isUriSafeToBeCopySrc(this.uri)) {
                Log.e("MicroMsg.ShareImgUI", "launch : fail, not accepted: %s", this.uri);
                aon(0);
                finish();
                AppMethodBeat.o(39144);
                return;
            }
        }
        showDialog();
        if (action.equals("android.intent.action.SEND")) {
            Log.i("MicroMsg.ShareImgUI", "send signal: ".concat(String.valueOf(action)));
            if (this.uri == null) {
                boolean bG = bG(getIntent());
                Log.i("MicroMsg.ShareImgUI", "dealWithText: %b", Boolean.valueOf(bG));
                if (!bG) {
                    aon(0);
                    finish();
                }
                AppMethodBeat.o(39144);
                return;
            }
            ThreadPool.post(new a(this.uri, new c() {
                /* class com.tencent.mm.ui.tools.ShareImgUI.AnonymousClass1 */

                @Override // com.tencent.mm.ui.tools.ShareImgUI.c
                public final void gXx() {
                    AppMethodBeat.i(39131);
                    ShareImgUI.this.handler.sendEmptyMessage(0);
                    AppMethodBeat.o(39131);
                }
            }), "ShareImgUI_getFilePath");
            AppMethodBeat.o(39144);
        } else if (!action.equals("android.intent.action.SEND_MULTIPLE") || extras == null || !extras.containsKey("android.intent.extra.STREAM")) {
            Log.e("MicroMsg.ShareImgUI", "launch : fail, uri is null");
            aon(0);
            finish();
            AppMethodBeat.o(39144);
        } else {
            Log.i("MicroMsg.ShareImgUI", "send multi: ".concat(String.valueOf(action)));
            a(extras, new b() {
                /* class com.tencent.mm.ui.tools.ShareImgUI.AnonymousClass2 */

                @Override // com.tencent.mm.ui.tools.ShareImgUI.b
                public final void br(ArrayList<String> arrayList) {
                    AppMethodBeat.i(39132);
                    ShareImgUI.this.Qpb = arrayList;
                    if (ShareImgUI.this.Qpb == null || ShareImgUI.this.Qpb.size() == 0) {
                        Log.e("MicroMsg.ShareImgUI", "launch : fail, filePathList is null");
                        ShareImgUI.b(ShareImgUI.this);
                        ShareImgUI.this.finish();
                        AppMethodBeat.o(39132);
                        return;
                    }
                    Iterator<String> it = ShareImgUI.this.Qpb.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (ImgUtil.isGif(next)) {
                            Log.i("MicroMsg.ShareImgUI", "%s is not image", next);
                            ShareImgUI.b(ShareImgUI.this);
                            ShareImgUI.this.finish();
                            AppMethodBeat.o(39132);
                            return;
                        }
                    }
                    String resolveType = ShareImgUI.this.getIntent().resolveType(ShareImgUI.this);
                    if (resolveType == null || !resolveType.contains("image")) {
                        Log.i("MicroMsg.ShareImgUI", "mime type is not image, try to set it");
                        ShareImgUI.this.getIntent().setDataAndType(ShareImgUI.this.getIntent().getData(), "image/*");
                    }
                    ShareImgUI.c(ShareImgUI.this);
                    AppMethodBeat.o(39132);
                }
            });
            AppMethodBeat.o(39144);
        }
    }

    private boolean gXR() {
        AppMethodBeat.i(39145);
        Intent intent2 = new Intent(this, ShareImgUI.class);
        if ("android.intent.action.SEND".equals(getIntent().getAction())) {
            if (!Util.isNullOrNil(this.filePath)) {
                intent2.putExtra("android.intent.extra.STREAM", FileProviderHelper.getUriForFile(this, new o(this.filePath)));
                intent2.setAction("android.intent.action.SEND");
                intent2.setType(getIntent().getType());
            } else {
                AppMethodBeat.o(39145);
                return false;
            }
        } else if (!"android.intent.action.SEND_MULTIPLE".equals(getIntent().getAction())) {
            AppMethodBeat.o(39145);
            return false;
        } else if (!Util.isNullOrNil(this.Qpb)) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.Qpb.size());
            Iterator<String> it = this.Qpb.iterator();
            while (it.hasNext()) {
                arrayList.add(FileProviderHelper.getUriForFile(this, new o(it.next())));
            }
            intent2.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            intent2.setAction("android.intent.action.SEND_MULTIPLE");
            intent2.setType(getIntent().getType());
        } else {
            AppMethodBeat.o(39145);
            return false;
        }
        intent2.addFlags(67108864);
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent2);
        AppMethodBeat.o(39145);
        return true;
    }

    private void a(final Bundle bundle, final b bVar) {
        AppMethodBeat.i(39146);
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.ui.tools.ShareImgUI.AnonymousClass4 */

            public final void run() {
                ShareImgUI shareImgUI;
                b bVar;
                ArrayList arrayList;
                AppMethodBeat.i(39135);
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("android.intent.extra.STREAM");
                if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
                    Log.e("MicroMsg.ShareImgUI", "getParcelableArrayList failed");
                    ShareImgUI.a(ShareImgUI.this, bVar, (ArrayList) null);
                    AppMethodBeat.o(39135);
                    return;
                }
                final CountDownLatch countDownLatch = new CountDownLatch(parcelableArrayList.size());
                final boolean[] zArr = {false};
                final ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    final Parcelable parcelable = (Parcelable) it.next();
                    String str = BuildConfig.COMMAND;
                    if (parcelable != null) {
                        str = parcelable.toString();
                    }
                    ThreadPool.post(new Runnable() {
                        /* class com.tencent.mm.ui.tools.ShareImgUI.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(39134);
                            if (!ShareImgUI.a(ShareImgUI.this, concurrentLinkedQueue, parcelable)) {
                                zArr[0] = true;
                            }
                            countDownLatch.countDown();
                            AppMethodBeat.o(39134);
                        }
                    }, "getMultiSendFilePathListItem".concat(String.valueOf(str)));
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e2) {
                    Log.printErrStackTrace("MicroMsg.ShareImgUI", e2, "hy: timeout when getmulti", new Object[0]);
                    ShareImgUI.a(ShareImgUI.this, bVar, (ArrayList) null);
                }
                ArrayList arrayList2 = new ArrayList(concurrentLinkedQueue);
                if (zArr[0]) {
                    Log.d("MicroMsg.ShareImgUI", "hy: has non path img");
                    shareImgUI = ShareImgUI.this;
                    bVar = bVar;
                } else {
                    Log.i("MicroMsg.ShareImgUI", "hy: getMultiSendFilePathList done. using: %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    shareImgUI = ShareImgUI.this;
                    bVar = bVar;
                    if (arrayList2.size() > 0) {
                        arrayList = arrayList2;
                        ShareImgUI.a(shareImgUI, bVar, arrayList);
                        AppMethodBeat.o(39135);
                    }
                }
                arrayList = null;
                ShareImgUI.a(shareImgUI, bVar, arrayList);
                AppMethodBeat.o(39135);
            }
        }, "getMultiSendFilePathList");
        AppMethodBeat.o(39146);
    }

    private boolean bG(Intent intent2) {
        AppMethodBeat.i(39147);
        if (intent2 == null) {
            Log.e("MicroMsg.ShareImgUI", "intent is null");
            AppMethodBeat.o(39147);
            return false;
        }
        String stringExtra = IntentUtil.getStringExtra(intent2, "android.intent.extra.TEXT");
        String stringExtra2 = IntentUtil.getStringExtra(intent2, "android.intent.extra.SUBJECT");
        if (stringExtra == null || stringExtra.length() == 0) {
            Log.i("MicroMsg.ShareImgUI", "text is null");
            AppMethodBeat.o(39147);
            return false;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXTextObject(stringExtra));
        wXMediaMessage.description = stringExtra;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = null;
        req.message = wXMediaMessage;
        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        bundle.putInt(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
        bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
        bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
        Intent intent3 = new Intent();
        intent3.setClass(this, SelectConversationUI.class);
        intent3.putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("animation_pop_in", true));
        if (!bg.aVG() || bg.azj()) {
            Log.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
        } else {
            bg.azz().b(837, this);
            bg.azz().a(837, this);
            ArrayList arrayList = new ArrayList();
            arrayList.add(stringExtra2 + "|" + stringExtra);
            g gVar = new g(5, arrayList, getCallerPackage());
            com.tencent.mm.kernel.g.azz().a(gVar, 0);
            this.Qwz.add(gVar);
            showDialog();
            this.nUx = intent3;
        }
        AppMethodBeat.o(39147);
        return true;
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        private c QwJ;
        private Uri mUri;

        public a(Uri uri, c cVar) {
            this.mUri = uri;
            this.QwJ = cVar;
        }

        public final void run() {
            AppMethodBeat.i(39139);
            try {
                ShareImgUI.this.filePath = ShareImgUI.a(ShareImgUI.this, this.mUri);
                if (Util.isNullOrNil(ShareImgUI.this.filePath) || !new o(ShareImgUI.this.filePath).exists() || (Build.VERSION.SDK_INT >= 30 && !new o(ShareImgUI.this.filePath).canRead())) {
                    if (ShareImgUI.bnT(ShareImgUI.this.getContentResolver().getType(this.mUri)) == 3) {
                        ShareImgUI.this.filePath = e.b(ShareImgUI.this.getContentResolver(), this.mUri);
                    } else {
                        ShareImgUI.this.filePath = e.a(ShareImgUI.this.getContentResolver(), this.mUri, 1);
                    }
                }
                if (this.QwJ != null) {
                    this.QwJ.gXx();
                    AppMethodBeat.o(39139);
                    return;
                }
            } catch (NullPointerException e2) {
                Log.printErrStackTrace("MicroMsg.ShareImgUI", e2, "", new Object[0]);
                ShareImgUI.this.filePath = null;
                if (this.QwJ != null) {
                    this.QwJ.gXx();
                    AppMethodBeat.o(39139);
                    return;
                }
            } catch (SQLiteDiskIOException e3) {
                Log.printErrStackTrace("MicroMsg.ShareImgUI", e3, "", new Object[0]);
                ShareImgUI.this.filePath = null;
                if (this.QwJ != null) {
                    this.QwJ.gXx();
                    AppMethodBeat.o(39139);
                    return;
                }
            } catch (IllegalAccessException e4) {
                Log.printErrStackTrace("MicroMsg.ShareImgUI", e4, "", new Object[0]);
                ShareImgUI.this.filePath = null;
                if (this.QwJ != null) {
                    this.QwJ.gXx();
                    AppMethodBeat.o(39139);
                    return;
                }
            } catch (Throwable th) {
                if (this.QwJ != null) {
                    this.QwJ.gXx();
                }
                AppMethodBeat.o(39139);
                throw th;
            }
            AppMethodBeat.o(39139);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d9 A[SYNTHETIC, Splitter:B:36:0x00d9] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00de A[Catch:{ Exception -> 0x01e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e3 A[Catch:{ Exception -> 0x01e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0163 A[SYNTHETIC, Splitter:B:59:0x0163] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0168 A[Catch:{ Exception -> 0x0172 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x016d A[Catch:{ Exception -> 0x0172 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x019f A[SYNTHETIC, Splitter:B:70:0x019f] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a4 A[Catch:{ Exception -> 0x01ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01a9 A[Catch:{ Exception -> 0x01ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01b7 A[SYNTHETIC, Splitter:B:80:0x01b7] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01bc A[Catch:{ Exception -> 0x01c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01c1 A[Catch:{ Exception -> 0x01c8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(android.net.Uri r11, android.database.Cursor r12) {
        /*
        // Method dump skipped, instructions count: 509
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.tools.ShareImgUI.a(android.net.Uri, android.database.Cursor):java.lang.String");
    }

    private static int bnM(String str) {
        AppMethodBeat.i(39149);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.ShareImgUI", "map : mimeType is null");
            AppMethodBeat.o(39149);
            return -1;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.equalsIgnoreCase("image/gif")) {
            AppMethodBeat.o(39149);
            return 5;
        } else if (lowerCase.contains("image")) {
            AppMethodBeat.o(39149);
            return 0;
        } else if (lowerCase.contains("video")) {
            AppMethodBeat.o(39149);
            return 1;
        } else {
            Log.d("MicroMsg.ShareImgUI", "map : unknown mimetype, send as file");
            AppMethodBeat.o(39149);
            return 3;
        }
    }

    private void aon(int i2) {
        AppMethodBeat.i(39150);
        switch (i2) {
            case 1:
                Toast.makeText(this, (int) R.string.h0u, 1).show();
                AppMethodBeat.o(39150);
                return;
            default:
                Toast.makeText(this, (int) R.string.h0x, 1).show();
                AppMethodBeat.o(39150);
                return;
        }
    }

    private void gXS() {
        AppMethodBeat.i(39151);
        Toast.makeText(this, (int) R.string.bs3, 1).show();
        finish();
        AppMethodBeat.o(39151);
    }

    private void showDialog() {
        AppMethodBeat.i(39152);
        if (this.gtM == null || !this.gtM.isShowing()) {
            if (this.CJj == null) {
                this.CJj = new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.ui.tools.ShareImgUI.AnonymousClass6 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(39137);
                        ShareImgUI.e(ShareImgUI.this);
                        ShareImgUI.this.finish();
                        AppMethodBeat.o(39137);
                    }
                };
            }
            getString(R.string.zb);
            this.gtM = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.a06), true, this.CJj);
            AppMethodBeat.o(39152);
            return;
        }
        AppMethodBeat.o(39152);
    }

    private void dismissDialog() {
        AppMethodBeat.i(39153);
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
        }
        AppMethodBeat.o(39153);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(39154);
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = str;
        objArr[3] = Integer.valueOf(qVar != null ? qVar.getType() : -1);
        objArr[4] = Integer.valueOf(hashCode());
        Log.i("MicroMsg.ShareImgUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s, type: %d, hashCode: %d", objArr);
        if (qVar != null) {
            this.Qwz.remove(qVar);
        }
        dismissDialog();
        if (qVar instanceof ac) {
            if (i2 == 0 && i3 == 0) {
                brd();
            } else {
                finish();
            }
        }
        if (qVar instanceof g) {
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(this.nUx);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/tools/ShareImgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareImgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else if (qVar.getReqResp() != null) {
                zk zkVar = (zk) ((d) qVar.getReqResp()).iLL.iLR;
                if (zkVar == null || Util.isNullOrNil(zkVar.LkJ)) {
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(this.nUx);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/ui/tools/ShareImgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareImgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", zkVar.LkJ);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    intent2.putExtra("needRedirect", false);
                    com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", intent2);
                }
            }
            finish();
        }
        AppMethodBeat.o(39154);
    }

    static /* synthetic */ void c(ShareImgUI shareImgUI) {
        g gVar;
        WXMediaMessage.IMediaObject wXImageObject;
        AppMethodBeat.i(39156);
        Intent intent2 = shareImgUI.getIntent();
        int bnM = bnM(intent2.resolveType(shareImgUI));
        if (bnM == 0 && ImgUtil.isGif(shareImgUI.filePath)) {
            Log.i("MicroMsg.ShareImgUI", "fix msg type to emoji.");
            bnM = 5;
        }
        Log.i("MicroMsg.ShareImgUI", "filepath:[%s], msgType:%d", shareImgUI.filePath, Integer.valueOf(bnM));
        if (bnM == -1) {
            Log.e("MicroMsg.ShareImgUI", "launch, msgType is invalid");
            shareImgUI.finish();
            AppMethodBeat.o(39156);
        } else if (shareImgUI.Qpb != null && bnM == 0 && shareImgUI.Qpb.size() > 9) {
            intent2.setClass(shareImgUI, SelectNoSupportUI.class);
            intent2.putExtra("sharePictureTo", "friend");
            intent2.addFlags(268435456).addFlags(67108864);
            shareImgUI.nUx = intent2;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(shareImgUI.nUx);
            com.tencent.mm.hellhoundlib.a.a.a(shareImgUI, bl.axQ(), "com/tencent/mm/ui/tools/ShareImgUI", "deal", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            shareImgUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(shareImgUI, "com/tencent/mm/ui/tools/ShareImgUI", "deal", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            shareImgUI.finish();
            AppMethodBeat.o(39156);
        } else if (Util.isNullOrNil(shareImgUI.filePath) || !Util.isImageFilename(shareImgUI.filePath) || ImgUtil.isImgFile(shareImgUI.filePath)) {
            if (bnM == 5 && !Util.isNullOrNil(shareImgUI.filePath)) {
                long boW = s.boW(shareImgUI.filePath);
                if (boW > ((long) com.tencent.mm.n.c.aqp())) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13459, Long.valueOf(boW), 1, "", 2);
                    shareImgUI.gXS();
                    AppMethodBeat.o(39156);
                    return;
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                if ((BitmapUtil.decodeFile(shareImgUI.filePath, options) != null && options.outHeight > com.tencent.mm.n.c.aqo()) || options.outWidth > com.tencent.mm.n.c.aqo()) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13459, Long.valueOf(boW), 1, "", 2);
                    shareImgUI.gXS();
                    AppMethodBeat.o(39156);
                    return;
                }
            }
            if (!Util.isNullOrNil(shareImgUI.filePath) && bnM == 3) {
                String str = shareImgUI.filePath;
                if (str == null || str.length() == 0) {
                    Log.e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is empty");
                    Toast.makeText(shareImgUI, (int) R.string.h0v, 1).show();
                    shareImgUI.finish();
                    AppMethodBeat.o(39156);
                } else if (!Util.isFilePathSafeToBeCopySrc(str)) {
                    Log.e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is refer to private file.");
                    Toast.makeText(shareImgUI, (int) R.string.h0v, 1).show();
                    shareImgUI.finish();
                    AppMethodBeat.o(39156);
                } else {
                    long boW2 = s.boW(str);
                    Log.i("MicroMsg.ShareImgUI", "filelength: [%d]", Long.valueOf(boW2));
                    if (boW2 == 0) {
                        Log.e("MicroMsg.ShareImgUI", "dealWithFile fail, fileLength is 0");
                        Toast.makeText(shareImgUI, (int) R.string.h0v, 1).show();
                        shareImgUI.finish();
                        AppMethodBeat.o(39156);
                    } else if (boW2 > 10485760) {
                        Log.e("MicroMsg.ShareImgUI", "summerbig dealWithFile fail, fileLength is too large fileLength[%d],filePath[%s] ", Long.valueOf(boW2), str);
                        Toast.makeText(shareImgUI, shareImgUI.getString(R.string.h0w, new Object[]{10}), 1).show();
                        shareImgUI.finish();
                        AppMethodBeat.o(39156);
                    } else {
                        switch (bnM) {
                            case 0:
                                wXImageObject = new WXImageObject();
                                ((WXImageObject) wXImageObject).setImagePath(str);
                                break;
                            default:
                                wXImageObject = new WXFileObject(str);
                                break;
                        }
                        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXImageObject);
                        wXMediaMessage.title = new o(str).getName();
                        wXMediaMessage.description = Util.getSizeKB(boW2);
                        SendMessageToWX.Req req = new SendMessageToWX.Req();
                        req.transaction = null;
                        req.message = wXMediaMessage;
                        Bundle bundle = new Bundle();
                        req.toBundle(bundle);
                        bundle.putInt(ConstantsAPI.SDK_VERSION, com.tencent.mm.opensdk.constants.Build.SDK_INT);
                        bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
                        bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
                        Intent intent3 = new Intent();
                        intent3.setClass(shareImgUI, SelectConversationUI.class);
                        intent3.putExtra("Select_Conv_NextStep", new Intent(shareImgUI, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("animation_pop_in", true));
                        if (!bg.aVG() || bg.azj()) {
                            Log.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
                            MMWizardActivity.b(shareImgUI, new Intent(shareImgUI, SimpleLoginUI.class), shareImgUI.getIntent().addFlags(67108864));
                            AppMethodBeat.o(39156);
                            return;
                        }
                        com.tencent.mm.kernel.g.azz().b(837, shareImgUI);
                        com.tencent.mm.kernel.g.azz().a(837, shareImgUI);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str);
                        g gVar2 = new g(4, arrayList, shareImgUI.getCallerPackage());
                        com.tencent.mm.kernel.g.azz().a(gVar2, 0);
                        shareImgUI.Qwz.add(gVar2);
                        shareImgUI.showDialog();
                        shareImgUI.nUx = intent3;
                        AppMethodBeat.o(39156);
                    }
                }
            } else if (IntentUtil.getBooleanExtra(shareImgUI.getIntent(), "Intro_Switch", false) || !bg.aVG() || bg.azj()) {
                if (!shareImgUI.gXR()) {
                    shareImgUI.aon(0);
                    shareImgUI.finish();
                }
                AppMethodBeat.o(39156);
            } else {
                intent2.setData(shareImgUI.uri);
                intent2.setClass(shareImgUI, MsgRetransmitUI.class);
                intent2.addFlags(268435456).addFlags(67108864);
                intent2.putExtra("Retr_File_Name", shareImgUI.filePath);
                intent2.putStringArrayListExtra("Retr_File_Path_List", shareImgUI.Qpb);
                intent2.putExtra("Retr_Msg_Type", bnM);
                intent2.putExtra("Retr_Scene", 1);
                intent2.putExtra("Retr_start_where_you_are", false);
                bg.azz().b(837, shareImgUI);
                bg.azz().a(837, shareImgUI);
                ArrayList arrayList2 = new ArrayList();
                if (!Util.isNullOrNil(shareImgUI.filePath)) {
                    arrayList2.add(shareImgUI.filePath);
                } else {
                    arrayList2.addAll(shareImgUI.Qpb);
                }
                if (bnM == 1) {
                    gVar = new g(3, arrayList2, shareImgUI.getCallerPackage());
                } else {
                    gVar = new g(1, arrayList2, shareImgUI.getCallerPackage());
                }
                com.tencent.mm.kernel.g.azz().a(gVar, 0);
                shareImgUI.Qwz.add(gVar);
                shareImgUI.showDialog();
                shareImgUI.nUx = intent2;
                AppMethodBeat.o(39156);
            }
        } else {
            Log.w("MicroMsg.ShareImgUI", "try to share illegal image.");
            shareImgUI.aon(0);
            shareImgUI.finish();
            AppMethodBeat.o(39156);
        }
    }

    static /* synthetic */ void d(ShareImgUI shareImgUI) {
        AppMethodBeat.i(39157);
        shareImgUI.aon(0);
        AppMethodBeat.o(39157);
    }

    static /* synthetic */ boolean a(ShareImgUI shareImgUI, ConcurrentLinkedQueue concurrentLinkedQueue, Parcelable parcelable) {
        String filePath2;
        AppMethodBeat.i(169900);
        if (parcelable == null || !(parcelable instanceof Uri)) {
            Log.e("MicroMsg.ShareImgUI", "getMultiSendFilePath failed, error parcelable, %s", parcelable);
        } else {
            Uri uri2 = (Uri) parcelable;
            if (!Util.isUriSafeToBeCopySrc(uri2) || uri2.getScheme() == null) {
                Log.e("MicroMsg.ShareImgUI", "unaccepted uri: ".concat(String.valueOf(uri2)));
            } else {
                if (com.tencent.mm.compatible.util.d.oD(30)) {
                    filePath2 = Util.getFilePath(shareImgUI, uri2);
                    if (filePath2 != null && !new o(filePath2).canRead()) {
                        filePath2 = uri2.toString();
                    }
                } else {
                    filePath2 = Util.getFilePath(shareImgUI, uri2);
                }
                Log.i("MicroMsg.ShareImgUI", "multiSend uri: %s, original filePath: %s", uri2.toString(), filePath2);
                String beo = e.beo(filePath2);
                if (Util.isNullOrNil(beo)) {
                    Log.e("MicroMsg.ShareImgUI", "[-] getMultiSendFilePath : fail, filePath is null.");
                } else if (!Util.isImageFilename(beo) || !ImgUtil.isImgFile(beo)) {
                    Log.w("MicroMsg.ShareImgUI", "multisend tries to send illegal img: ".concat(String.valueOf(beo)));
                } else {
                    Log.i("MicroMsg.ShareImgUI", "multisend file path: ".concat(String.valueOf(beo)));
                    concurrentLinkedQueue.add(beo);
                    AppMethodBeat.o(169900);
                    return true;
                }
            }
        }
        AppMethodBeat.o(169900);
        return false;
    }

    static /* synthetic */ void a(ShareImgUI shareImgUI, final b bVar, final ArrayList arrayList) {
        AppMethodBeat.i(39159);
        if (bVar != null) {
            shareImgUI.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.ui.tools.ShareImgUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(39136);
                    bVar.br(arrayList);
                    AppMethodBeat.o(39136);
                }
            });
        }
        AppMethodBeat.o(39159);
    }

    static /* synthetic */ String a(ShareImgUI shareImgUI, Uri uri2) {
        AppMethodBeat.i(39160);
        if (uri2 == null) {
            Log.e("MicroMsg.ShareImgUI", "uri is null!");
            AppMethodBeat.o(39160);
            return null;
        }
        String scheme = uri2.getScheme();
        if (Util.isNullOrNil(scheme)) {
            Log.e("MicroMsg.ShareImgUI", "input uri error. %s", uri2);
            AppMethodBeat.o(39160);
            return null;
        } else if (scheme.equalsIgnoreCase("file")) {
            Log.i("MicroMsg.ShareImgUI", "getFilePath : scheme is SCHEME_FILE");
            String path = uri2.getPath();
            String beo = e.beo(path);
            if (beo != null) {
                AppMethodBeat.o(39160);
                return beo;
            }
            Log.e("MicroMsg.ShareImgUI", "[-] getFilePath : fail, safePath is null.");
            IllegalAccessException illegalAccessException = new IllegalAccessException("safePath is null while process path: ".concat(String.valueOf(path)));
            AppMethodBeat.o(39160);
            throw illegalAccessException;
        } else if (scheme.equalsIgnoreCase("content")) {
            Log.i("MicroMsg.ShareImgUI", "getFilePath : scheme is SCHEME_CONTENT: " + uri2.toString());
            Cursor query = shareImgUI.getContentResolver().query(uri2, null, null, null, null);
            if (query == null) {
                Log.e("MicroMsg.ShareImgUI", "getFilePath : fail, cursor is null");
                AppMethodBeat.o(39160);
                return null;
            } else if (query.getCount() <= 0 || !query.moveToFirst()) {
                query.close();
                Log.e("MicroMsg.ShareImgUI", "getFilePath : fail, cursor getCount is 0 or moveToFirst fail");
                AppMethodBeat.o(39160);
                return null;
            } else {
                String lowerCase = uri2.toString().toLowerCase();
                if (lowerCase.startsWith("content://com.android.contacts/contacts/as_vcard") || lowerCase.startsWith("content://com.android.contacts/contacts/as_multi_vcard") || lowerCase.startsWith("content://com.mediatek.calendarimporter") || ((shareImgUI.intent != null && shareImgUI.intent.getType().equals("text/x-vcalendar")) || ae.gKE.gGM == 1)) {
                    String a2 = shareImgUI.a(uri2, query);
                    AppMethodBeat.o(39160);
                    return a2;
                }
                query.close();
                String filePath2 = Util.getFilePath(shareImgUI, uri2);
                AppMethodBeat.o(39160);
                return filePath2;
            }
        } else {
            Log.e("MicroMsg.ShareImgUI", "unknown scheme");
            AppMethodBeat.o(39160);
            return null;
        }
    }

    static /* synthetic */ void e(ShareImgUI shareImgUI) {
        AppMethodBeat.i(234469);
        Iterator<q> it = shareImgUI.Qwz.iterator();
        while (it.hasNext()) {
            com.tencent.mm.kernel.g.azz().a(it.next());
        }
        AppMethodBeat.o(234469);
    }
}
