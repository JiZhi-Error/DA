package com.tencent.mm.plugin.webview.ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.i.a;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiResumeDownloadTaskForNative;
import com.tencent.mm.plugin.appbrand.jsapi.k.ab;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class OpenFileChooserUI extends MMActivity {
    private boolean EsU;
    private boolean Jeu;
    private int Jev;
    private int Jew;
    private String Jex;
    private boolean Jey = false;
    private DialogInterface.OnCancelListener Jez = null;
    private int count;
    private int das;
    private ProgressDialog gtM = null;
    private int het;
    private String lPw;
    private String lPx;
    private int xos;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ int a(OpenFileChooserUI openFileChooserUI, String str) {
        AppMethodBeat.i(79663);
        int bae = openFileChooserUI.bae(str);
        AppMethodBeat.o(79663);
        return bae;
    }

    static /* synthetic */ String c(OpenFileChooserUI openFileChooserUI, String str) {
        AppMethodBeat.i(79667);
        String bad = openFileChooserUI.bad(str);
        AppMethodBeat.o(79667);
        return bad;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0129  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
        // Method dump skipped, instructions count: 942
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.onCreate(android.os.Bundle):void");
    }

    private boolean ger() {
        AppMethodBeat.i(79654);
        Log.i("MicroMsg.OpenFileChooserUI", "avaiableMem = %d", Long.valueOf(Util.getAvailableMemoryMB(this)));
        if (Util.getAvailableMemoryMB(this) <= 200) {
            AppMethodBeat.o(79654);
            return false;
        }
        AppMethodBeat.o(79654);
        return true;
    }

    private SightParams xi(int i2) {
        AppMethodBeat.i(79655);
        String str = "microMsg_" + System.currentTimeMillis();
        this.lPw = b.aKV() + str + ".mp4";
        this.lPx = b.aKV() + str + ".jpeg";
        int intExtra = getIntent().getIntExtra("key_pick_local_media_duration", 60);
        SightParams sightParams = new SightParams(3, 1);
        sightParams.zsH = this.Jev == 16 ? 1 : 2;
        sightParams.mode = i2;
        if (sightParams.irT == null) {
            sightParams.irT = new VideoTransPara();
        }
        sightParams.irT.duration = intExtra;
        sightParams.v(str, this.lPw, this.lPx, AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", "capture", Long.valueOf(System.currentTimeMillis()), "jpg"));
        AppMethodBeat.o(79655);
        return sightParams;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(79656);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.OpenFileChooserUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(79656);
            return;
        }
        Log.i("MicroMsg.OpenFileChooserUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 16:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.fl0), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(175753);
                            OpenFileChooserUI openFileChooserUI = OpenFileChooserUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(openFileChooserUI, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/OpenFileChooserUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            openFileChooserUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(openFileChooserUI, "com/tencent/mm/plugin/webview/ui/tools/OpenFileChooserUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(175753);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    break;
                } else {
                    s.d(getContext(), b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
                    AppMethodBeat.o(79656);
                    return;
                }
        }
        AppMethodBeat.o(79656);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, final int i3, final Intent intent) {
        o oVar = null;
        AppMethodBeat.i(79657);
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            Intent intent2 = new Intent();
            intent2.putExtra("key_pick_local_media_show_memory_warning", this.Jey);
            setResult(i3, intent2);
            finish();
            AppMethodBeat.o(79657);
            return;
        }
        switch (i2) {
            case 1:
            case 3:
                com.tencent.mm.plugin.webview.a.a.aj(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(79652);
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                        boolean booleanExtra = intent.getBooleanExtra("isTakePhoto", false);
                        boolean booleanExtra2 = intent.getBooleanExtra("CropImage_Compress_Img", true);
                        ArrayList arrayList = new ArrayList();
                        for (String str : stringArrayListExtra) {
                            WebViewJSSDKFileItem byx = WebViewJSSDKFileItem.byx(str);
                            String str2 = byx.dJX;
                            byx.laV = booleanExtra2;
                            g.gdv().a(byx);
                            Log.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", str, str2);
                            arrayList.add(str2);
                        }
                        String bb = ay.bb(arrayList);
                        Log.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", bb);
                        Intent intent = new Intent();
                        intent.putExtra("key_pick_local_pic_callback_local_ids", bb);
                        intent.putExtra("key_pick_local_pic_source_type", booleanExtra ? "camera" : FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                        intent.putExtra("key_pick_local_media_show_memory_warning", OpenFileChooserUI.this.Jey);
                        OpenFileChooserUI.this.setResult(i3, intent);
                        OpenFileChooserUI.this.finish();
                        AppMethodBeat.o(79652);
                    }
                });
                AppMethodBeat.o(79657);
                return;
            case 2:
                String h2 = s.h(getContext().getApplicationContext(), intent, b.aKV());
                if (Util.isNullOrNil(h2)) {
                    Log.w("MicroMsg.OpenFileChooserUI", "take photo, but result is null");
                    setResult(-2, intent);
                    finish();
                    AppMethodBeat.o(79657);
                    return;
                }
                Log.i("MicroMsg.OpenFileChooserUI", "take photo, result[%s]", h2);
                Intent intent3 = new Intent();
                intent3.putExtra("key_send_raw_image", this.Jeu);
                intent3.putExtra("max_select_count", this.das);
                intent3.putExtra("query_source_type", this.het);
                ArrayList<String> arrayList = new ArrayList<>(1);
                arrayList.add(h2);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.putExtra("preview_image", true);
                intent3.addFlags(67108864);
                c.b(this, "gallery", ".ui.GalleryEntryUI", intent3, 3);
                AppMethodBeat.o(79657);
                return;
            case 4:
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                    Log.e("MicroMsg.OpenFileChooserUI", "choose video failed, path is null");
                    setResult(1);
                    finish();
                    AppMethodBeat.o(79657);
                    return;
                }
                Log.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_GALLERY_VIDEO");
                Log.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", stringArrayListExtra.get(0));
                if (this.Jew == 1 && !aad(this.lPx)) {
                    Log.i("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
                }
                bac(stringArrayListExtra.get(0));
                AppMethodBeat.o(79657);
                return;
            case 5:
                if (new o(this.lPw).exists()) {
                    bac(this.lPw);
                    AppMethodBeat.o(79657);
                    return;
                }
                Log.e("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_VIDEO, file not exist : %s", this.lPw);
                setResult(1);
                finish();
                AppMethodBeat.o(79657);
                return;
            case 6:
                Log.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_SIGHT_VIDEO");
                if (intent != null) {
                    Log.i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        Log.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        finish();
                        AppMethodBeat.o(79657);
                        return;
                    }
                    this.lPw = sightCaptureResult.zsA;
                    Log.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", this.lPw);
                    if (!aad(this.lPx) && aad(sightCaptureResult.zsB)) {
                        this.lPx = sightCaptureResult.zsB;
                    }
                    if (!TextUtils.isEmpty(this.lPw)) {
                        oVar = new o(this.lPw);
                    }
                    if (oVar == null || !oVar.exists()) {
                        Log.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", this.lPw);
                    } else {
                        Log.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", this.lPw);
                        bac(this.lPw);
                        AppMethodBeat.o(79657);
                        return;
                    }
                }
                Log.e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                finish();
                AppMethodBeat.o(79657);
                return;
            case 7:
                Log.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
                if (intent != null) {
                    Log.i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    SightCaptureResult sightCaptureResult2 = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult2 == null) {
                        Log.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        finish();
                        AppMethodBeat.o(79657);
                        return;
                    } else if (sightCaptureResult2.zsy) {
                        String str = sightCaptureResult2.zsG;
                        if (Util.isNullOrNil(str)) {
                            Log.e("MicroMsg.OpenFileChooserUI", "picture_picturePath file is not exist! path:%s", str);
                            setResult(1);
                            finish();
                            AppMethodBeat.o(79657);
                            return;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        WebViewJSSDKFileItem byx = WebViewJSSDKFileItem.byx(str);
                        byx.laV = true;
                        byx.mediaType = 1;
                        g.gdv().a(byx);
                        arrayList2.add(byx.dJX);
                        Log.i("MicroMsg.OpenFileChooserUI", "filepath is : %s, local id is : %s", str, byx.dJX);
                        String bb = Util.isEqual(this.Jex, JsApiChooseImage.NAME) ? ay.bb(arrayList2) : ay.bc(arrayList2);
                        Log.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", bb);
                        Intent intent4 = new Intent();
                        intent4.putExtra("key_pick_local_media_local_ids", bb);
                        intent4.putExtra("key_pick_local_media_callback_type", 2);
                        intent4.putExtra("key_pick_local_media_show_memory_warning", this.Jey);
                        intent4.putExtra("key_pick_local_pic_source_type", this.EsU ? "camera" : FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                        setResult(i3, intent4);
                        finish();
                        AppMethodBeat.o(79657);
                        return;
                    } else {
                        this.lPw = sightCaptureResult2.zsA;
                        Log.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", this.lPw);
                        if (!aad(this.lPx) && aad(sightCaptureResult2.zsB)) {
                            this.lPx = sightCaptureResult2.zsB;
                        }
                        o oVar2 = !TextUtils.isEmpty(this.lPw) ? new o(this.lPw) : null;
                        if (oVar2 == null || !oVar2.exists()) {
                            Log.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", this.lPw);
                        } else {
                            Log.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", this.lPw);
                            bac(this.lPw);
                            AppMethodBeat.o(79657);
                            return;
                        }
                    }
                }
                Log.e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                finish();
                AppMethodBeat.o(79657);
                return;
            case 8:
                Log.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
                ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra2 == null || stringArrayListExtra2.size() <= 0) {
                    ArrayList<String> stringArrayListExtra3 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", true);
                    if (stringArrayListExtra3 == null) {
                        Log.e("MicroMsg.OpenFileChooserUI", "chosen is null");
                        setResult(1);
                        finish();
                        AppMethodBeat.o(79657);
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (String str2 : stringArrayListExtra3) {
                        WebViewJSSDKFileItem byx2 = WebViewJSSDKFileItem.byx(str2);
                        String str3 = byx2.dJX;
                        byx2.laV = booleanExtra;
                        g.gdv().a(byx2);
                        Log.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", str2, str3);
                        arrayList3.add(str3);
                    }
                    String bb2 = Util.isEqual(this.Jex, JsApiChooseImage.NAME) ? ay.bb(arrayList3) : ay.bc(arrayList3);
                    Log.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", bb2);
                    Intent intent5 = new Intent();
                    intent5.putExtra("key_pick_local_media_local_ids", bb2);
                    intent5.putExtra("key_pick_local_media_show_memory_warning", this.Jey);
                    intent5.putExtra("key_pick_local_media_callback_type", 2);
                    intent5.putExtra("key_pick_local_pic_source_type", this.EsU ? "camera" : FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                    setResult(i3, intent5);
                    finish();
                    AppMethodBeat.o(79657);
                    return;
                }
                bac(stringArrayListExtra2.get(0));
                AppMethodBeat.o(79657);
                return;
            default:
                Log.e("MicroMsg.OpenFileChooserUI", "unknown request code = %d", Integer.valueOf(i2));
                setResult(1);
                finish();
                AppMethodBeat.o(79657);
                return;
        }
    }

    private void bac(final String str) {
        AppMethodBeat.i(79658);
        this.Jez = new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.AnonymousClass7 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(175754);
                OpenFileChooserUI.this.setResult(0);
                OpenFileChooserUI.this.finish();
                AppMethodBeat.o(175754);
            }
        };
        getString(R.string.zb);
        this.gtM = h.a((Context) this, getString(R.string.iza), true, this.Jez);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.AnonymousClass8 */

            public final void run() {
                final String c2;
                final String d2;
                AppMethodBeat.i(175762);
                ArrayList arrayList = new ArrayList();
                int a2 = OpenFileChooserUI.a(OpenFileChooserUI.this, str);
                if (a2 == -50002) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(175756);
                            if (OpenFileChooserUI.this.het == 7 && OpenFileChooserUI.this.xos == 2) {
                                h.a((Context) OpenFileChooserUI.this, OpenFileChooserUI.this.getString(R.string.izb), OpenFileChooserUI.this.getString(R.string.zb), OpenFileChooserUI.this.getString(R.string.w1), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.AnonymousClass8.AnonymousClass1.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(175755);
                                        OpenFileChooserUI.this.setResult(1);
                                        OpenFileChooserUI.this.finish();
                                        AppMethodBeat.o(175755);
                                    }
                                });
                                AppMethodBeat.o(175756);
                                return;
                            }
                            Toast.makeText(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(R.string.hwm), 0).show();
                            OpenFileChooserUI.this.setResult(1);
                            OpenFileChooserUI.this.finish();
                            AppMethodBeat.o(175756);
                        }
                    });
                    AppMethodBeat.o(175762);
                    return;
                }
                if (a2 == -50006) {
                    c2 = OpenFileChooserUI.G(str, arrayList);
                    OpenFileChooserUI.b(OpenFileChooserUI.this, str);
                    d2 = OpenFileChooserUI.d(OpenFileChooserUI.this);
                } else if (a2 == 1) {
                    c2 = OpenFileChooserUI.c(OpenFileChooserUI.this, str);
                    OpenFileChooserUI.b(OpenFileChooserUI.this, str);
                    d2 = OpenFileChooserUI.d(OpenFileChooserUI.this);
                    if (Util.isNullOrNil(c2) && OpenFileChooserUI.this.het == 7 && OpenFileChooserUI.this.xos == 2) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.AnonymousClass8.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(175758);
                                h.a((Context) OpenFileChooserUI.this, OpenFileChooserUI.this.getString(R.string.izc), OpenFileChooserUI.this.getString(R.string.zb), OpenFileChooserUI.this.getString(R.string.w1), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.AnonymousClass8.AnonymousClass2.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(175757);
                                        OpenFileChooserUI.this.setResult(1);
                                        OpenFileChooserUI.this.finish();
                                        AppMethodBeat.o(175757);
                                    }
                                });
                                AppMethodBeat.o(175758);
                            }
                        });
                        AppMethodBeat.o(175762);
                        return;
                    }
                } else {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.AnonymousClass8.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(175759);
                            OpenFileChooserUI.this.setResult(1);
                            OpenFileChooserUI.this.finish();
                            AppMethodBeat.o(175759);
                        }
                    });
                    AppMethodBeat.o(175762);
                    return;
                }
                if (!Util.isNullOrNil(c2)) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.AnonymousClass8.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(175760);
                            Intent intent = new Intent();
                            intent.putExtra("key_pick_local_media_callback_type", 1);
                            intent.putExtra("key_pick_local_media_local_id", c2);
                            intent.putExtra("key_pick_local_media_thumb_local_id", d2);
                            Log.i("MicroMsg.OpenFileChooserUI", "thumbLocalId:%s", d2);
                            OpenFileChooserUI.this.setResult(-1, intent);
                            OpenFileChooserUI.this.finish();
                            AppMethodBeat.o(175760);
                        }
                    });
                    AppMethodBeat.o(175762);
                    return;
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.AnonymousClass8.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(175761);
                        OpenFileChooserUI.this.setResult(1);
                        OpenFileChooserUI.this.finish();
                        AppMethodBeat.o(175761);
                    }
                });
                AppMethodBeat.o(175762);
            }
        });
        AppMethodBeat.o(79658);
    }

    private String bad(String str) {
        d dVar;
        AppMethodBeat.i(79659);
        try {
            dVar = new d();
            dVar.setDataSource(str);
        } catch (Exception e2) {
            Log.e("MicroMsg.OpenFileChooserUI", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e2);
            dVar = null;
        }
        if (dVar == null) {
            AppMethodBeat.o(79659);
            return null;
        }
        int i2 = Util.getInt(dVar.extractMetadata(18), 0);
        int i3 = Util.getInt(dVar.extractMetadata(19), 0);
        int i4 = Util.getInt(dVar.extractMetadata(9), 0);
        dVar.release();
        dVar.release();
        WebViewJSSDKVideoItem byz = WebViewJSSDKFileItem.byz(str);
        byz.duration = (i4 + 500) / 1000;
        byz.width = i2;
        byz.height = i3;
        byz.size = (int) com.tencent.mm.vfs.s.boW(str);
        if (this.Jew == 1) {
            byz.lPx = this.lPx;
        }
        g.gdv().a(byz);
        String str2 = byz.dJX;
        AppMethodBeat.o(79659);
        return str2;
    }

    private int bae(String str) {
        a.C0304a aVar;
        boolean z;
        int i2;
        AppMethodBeat.i(79660);
        Intent intent = new Intent();
        intent.setData(Uri.parse("file://".concat(String.valueOf(str))));
        NetStatusUtil.is2G(this);
        try {
            aVar = com.tencent.mm.compatible.i.a.j(this, intent);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.OpenFileChooserUI", e2, "", new Object[0]);
            aVar = null;
        }
        if (aVar == null) {
            Log.e("MicroMsg.OpenFileChooserUI", "compressVideo filed.");
            AppMethodBeat.o(79660);
            return -50005;
        }
        String str2 = aVar.filename;
        boolean Sx = com.tencent.mm.plugin.a.c.Sx(str2);
        Log.i("MicroMsg.OpenFileChooserUI", "isMp4 = %b", Boolean.valueOf(Sx));
        int i3 = -10000;
        if (Sx) {
            i3 = SightVideoJNI.shouldRemuxingVFS(str2, JsApiResumeDownloadTaskForNative.CTRL_INDEX, 500, 26214400, 300000.0d, 1000000);
            Log.i("MicroMsg.OpenFileChooserUI", "check remuxing, ret %d", Integer.valueOf(i3));
        }
        if (i3 == -1 || !Sx) {
            int boW = (int) com.tencent.mm.vfs.s.boW(str2);
            Log.i("MicroMsg.OpenFileChooserUI", "fileLenght = %d", Integer.valueOf(boW));
            if (boW > 26214400) {
                i3 = -1;
            } else {
                i3 = 1;
            }
        }
        switch (i3) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                AppMethodBeat.o(79660);
                return -50002;
            case 0:
                z = true;
                i2 = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                z = false;
                i2 = 1;
                break;
            default:
                Log.e("MicroMsg.OpenFileChooserUI", "unknown check type");
                AppMethodBeat.o(79660);
                return -50001;
        }
        if (z) {
            i2 = -50006;
        }
        Log.i("MicroMsg.OpenFileChooserUI", "finish to import %s  ret %d | duration %d", str2, Integer.valueOf(i2), Integer.valueOf(aVar.duration / 1000));
        AppMethodBeat.o(79660);
        return i2;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(79661);
        super.onDestroy();
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
        }
        AppMethodBeat.o(79661);
    }

    private static boolean aad(String str) {
        AppMethodBeat.i(79662);
        if (!TextUtils.isEmpty(str)) {
            o oVar = new o(str);
            Log.i("MicroMsg.OpenFileChooserUI", "thumbFilePath:%s", str);
            if (oVar.exists()) {
                Log.i("MicroMsg.OpenFileChooserUI", "video thumb file is exist");
                AppMethodBeat.o(79662);
                return true;
            }
            Log.e("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
            AppMethodBeat.o(79662);
            return false;
        }
        Log.e("MicroMsg.OpenFileChooserUI", "video thumb file path is null");
        AppMethodBeat.o(79662);
        return false;
    }

    static /* synthetic */ String G(String str, List list) {
        AppMethodBeat.i(79664);
        int[] iArr = new int[2];
        m.d(str, iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PInt pInt3 = new PInt();
        PInt pInt4 = new PInt();
        e.a(str, pInt, pInt2, pInt3, pInt4, new PInt());
        String str2 = b.aKV() + "microMsg." + System.currentTimeMillis() + ".mp4";
        int remuxingVFS = SightVideoJNI.remuxingVFS(str, str2, i2, i3, com.tencent.mm.plugin.sight.base.c.Dmd, com.tencent.mm.plugin.sight.base.c.Dmc, 8, 2, 25.0f, (float) pInt4.value, null, 0, false, 0, 51);
        Log.i("MicroMsg.OpenFileChooserUI", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", str, str2, Integer.valueOf(remuxingVFS), Integer.valueOf(i2), Integer.valueOf(i3));
        WebViewJSSDKVideoItem byz = WebViewJSSDKFileItem.byz(str2);
        byz.width = i2;
        byz.height = i3;
        byz.duration = remuxingVFS;
        byz.size = (int) com.tencent.mm.vfs.s.boW(str2);
        list.add(byz.dJX);
        g.gdv().a(byz);
        String str3 = byz.dJX;
        AppMethodBeat.o(79664);
        return str3;
    }

    static /* synthetic */ void b(OpenFileChooserUI openFileChooserUI, String str) {
        o oVar;
        String str2 = null;
        AppMethodBeat.i(79665);
        if (openFileChooserUI.Jew == 0) {
            Log.e("MicroMsg.OpenFileChooserUI", "don't need thumb image");
            AppMethodBeat.o(79665);
            return;
        }
        if (!TextUtils.isEmpty(openFileChooserUI.lPx)) {
            oVar = new o(openFileChooserUI.lPx);
        } else {
            Log.e("MicroMsg.OpenFileChooserUI", "thumbFilePath is empty!");
            oVar = null;
        }
        if (oVar == null || !oVar.exists()) {
            Log.e("MicroMsg.OpenFileChooserUI", "file == null or file not exist for path:%s!", openFileChooserUI.lPx);
            String name = new o(str).getName();
            if (!TextUtils.isEmpty(name) && name.contains(".")) {
                str2 = name.substring(0, name.lastIndexOf("."));
            }
            if (TextUtils.isEmpty(str2)) {
                openFileChooserUI.lPx = b.aKV() + ("microMsg_" + System.currentTimeMillis()) + ".jpeg";
            } else if (b.aKV() == null || !b.aKV().endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                openFileChooserUI.lPx = b.aKV() + FilePathGenerator.ANDROID_DIR_SEP + str2 + ".jpeg";
            } else {
                openFileChooserUI.lPx = b.aKV() + str2 + ".jpeg";
            }
            if (!new o(openFileChooserUI.lPx).exists()) {
                Log.i("MicroMsg.OpenFileChooserUI", "file not exist for path:%s!", openFileChooserUI.lPx);
                Log.i("MicroMsg.OpenFileChooserUI", "create new thumb path:%s!", openFileChooserUI.lPx);
                Bitmap createVideoThumbnail = BitmapUtil.createVideoThumbnail(str, 1);
                if (createVideoThumbnail == null) {
                    Log.e("MicroMsg.OpenFileChooserUI", "createVideoThumbnail bitmap fail for path:%s!", openFileChooserUI.lPx);
                    AppMethodBeat.o(79665);
                    return;
                }
                try {
                    BitmapUtil.saveBitmapToImage(ThumbnailUtils.extractThumbnail(createVideoThumbnail, ab.CTRL_INDEX, 400, 2), 30, Bitmap.CompressFormat.JPEG, openFileChooserUI.lPx, true);
                    AppMethodBeat.o(79665);
                } catch (IOException e2) {
                    Log.e("MicroMsg.OpenFileChooserUI", "saveBitmapToImage exist IOException:" + e2.getMessage());
                    AppMethodBeat.o(79665);
                }
            } else {
                Log.i("MicroMsg.OpenFileChooserUI", "file is exist for path:%s!", openFileChooserUI.lPx);
                AppMethodBeat.o(79665);
            }
        } else {
            Log.i("MicroMsg.OpenFileChooserUI", "file is exist!, path:%s", openFileChooserUI.lPx);
            AppMethodBeat.o(79665);
        }
    }

    static /* synthetic */ String d(OpenFileChooserUI openFileChooserUI) {
        AppMethodBeat.i(79666);
        if (!TextUtils.isEmpty(openFileChooserUI.lPx)) {
            WebViewJSSDKFileItem byx = WebViewJSSDKFileItem.byx(openFileChooserUI.lPx);
            byx.lPx = openFileChooserUI.lPx;
            byx.laV = true;
            byx.mediaType = 1;
            g.gdv().a(byx);
            String str = byx.dJX;
            AppMethodBeat.o(79666);
            return str;
        }
        AppMethodBeat.o(79666);
        return "";
    }
}
