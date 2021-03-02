package com.tencent.mm.plugin.game.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.f.h;
import com.tencent.luggage.e.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.vfs.s;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends bs<i> {
    private static final String xwF = (b.c(b.a.ONE_MONTH) + "haowan/");
    private static final int xwG = ("choose_media_request_code".hashCode() & 65535);
    private q gxX;
    private DialogInterface.OnCancelListener mcu;

    static {
        AppMethodBeat.i(83062);
        AppMethodBeat.o(83062);
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "chooseHaowanMedia";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(com.tencent.luggage.d.b<i>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(final Context context, String str, final br.a aVar) {
        AppMethodBeat.i(83058);
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            aVar.i("invalid_params", null);
            AppMethodBeat.o(83058);
            return;
        }
        int optInt = Zc.optInt("mediaType", 3);
        Zc.optString("mediaTag");
        int optInt2 = Zc.optInt("limitCount", 9);
        int optInt3 = Zc.optInt("galleryType");
        JSONArray optJSONArray = Zc.optJSONArray("albumInfos");
        boolean optBoolean = Zc.optBoolean("ignoreVideoPreview", true);
        int optInt4 = Zc.optInt("sourceSceneId");
        Intent intent = new Intent();
        intent.putExtra("key_can_select_video_and_pic", true);
        intent.putExtra("key_send_raw_image", false);
        ((MMActivity) context).mmSetOnActivityResultCallback(new MMActivity.a() {
            /* class com.tencent.mm.plugin.game.luggage.b.f.AnonymousClass1 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, final Intent intent) {
                AppMethodBeat.i(83057);
                if (i2 == f.xwG) {
                    if (i3 == -1) {
                        String stringExtra = intent.getStringExtra("key_video_info");
                        if (!Util.isNullOrNil(stringExtra)) {
                            Log.i("MicroMsg.JsApiChooseHaowanMedia", "video, result: %s", stringExtra);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("type", 2);
                                jSONObject.put("localIds", stringExtra);
                                jSONObject.put("appId", intent.getStringExtra("key_game_video_appid"));
                                jSONObject.put("appName", intent.getStringExtra("key_game_video_appname"));
                                jSONObject.put("transInfo", intent.getStringExtra("key_game_trans_info"));
                            } catch (JSONException e2) {
                            }
                            aVar.i(null, jSONObject);
                        } else {
                            final ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                            if (!Util.isNullOrNil(stringArrayListExtra)) {
                                f.a(f.this, context);
                                h.RTc.aX(new Runnable() {
                                    /* class com.tencent.mm.plugin.game.luggage.b.f.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(83056);
                                        final String au = f.au(stringArrayListExtra);
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.plugin.game.luggage.b.f.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(83055);
                                                if (f.this.gxX != null) {
                                                    f.this.gxX.dismiss();
                                                }
                                                JSONObject jSONObject = new JSONObject();
                                                try {
                                                    jSONObject.put("type", 1);
                                                    jSONObject.put("localIds", au);
                                                    jSONObject.put("appId", intent.getStringExtra("key_game_video_appid"));
                                                    jSONObject.put("appName", intent.getStringExtra("key_game_video_appname"));
                                                } catch (JSONException e2) {
                                                }
                                                aVar.i(null, jSONObject);
                                                AppMethodBeat.o(83055);
                                            }
                                        });
                                        AppMethodBeat.o(83056);
                                    }
                                });
                            } else if (intent.getBooleanExtra("key_game_haowan_text", false)) {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("type", 3);
                                    jSONObject2.put("appId", intent.getStringExtra("key_game_video_appid"));
                                    jSONObject2.put("appName", intent.getStringExtra("key_game_video_appname"));
                                } catch (JSONException e3) {
                                }
                                aVar.i(null, jSONObject2);
                            } else {
                                aVar.i("cancel", null);
                            }
                        }
                    } else {
                        aVar.i("cancel", null);
                    }
                    ((MMActivity) context).mmSetOnActivityResultCallback(null);
                }
                AppMethodBeat.o(83057);
            }
        });
        intent.putExtra("max_select_count", optInt2);
        intent.putExtra("query_source_type", 15);
        intent.putExtra("query_media_type", optInt);
        intent.putExtra("show_header_view", false);
        intent.addFlags(67108864);
        if (optJSONArray != null) {
            intent.putExtra("game_haowan_local_albums_info", optJSONArray.toString());
        }
        intent.putExtra("game_haowan_ignore_video_preview", optBoolean);
        intent.putExtra("game_haowan_source_scene_id", optInt4);
        if (optInt3 == 2) {
            c.b(context, "game", ".media.GameTabGalleryUI", intent, xwG);
        } else if (optInt3 == 1) {
            c.b(context, "game", ".media.GamePublishGalleryUI", intent, xwG);
        } else {
            aVar.i("galleryType is invalid", null);
            AppMethodBeat.o(83058);
            return;
        }
        ((Activity) context).overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
        AppMethodBeat.o(83058);
    }

    private static String hE(String str, String str2) {
        AppMethodBeat.i(83059);
        int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
        if (orientationInDegree != 0) {
            int i2 = orientationInDegree % v2helper.VOIP_ENC_HEIGHT_LV1;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
                if (decodeFile == null) {
                    Log.e("MicroMsg.JsApiChooseHaowanMedia", "rotate image, get null bmp");
                    AppMethodBeat.o(83059);
                    return str;
                }
                Bitmap rotate = BitmapUtil.rotate(decodeFile, (float) i2);
                Log.i("MicroMsg.JsApiChooseHaowanMedia", "doRotate, dstPath : %s", str2);
                try {
                    BitmapUtil.saveBitmapToImage(rotate, 80, a.d(options) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG, str2, true);
                    if (a.d(options)) {
                        com.tencent.mm.plugin.appbrand.l.b.dk(str, str2);
                    }
                    AppMethodBeat.o(83059);
                    return str2;
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiChooseHaowanMedia", "rotate image, exception occurred when saving | %s", e2);
                    s.deleteFile(str2);
                    AppMethodBeat.o(83059);
                    return str;
                }
            } catch (OutOfMemoryError e3) {
                AppMethodBeat.o(83059);
                return str;
            } catch (NullPointerException e4) {
                AppMethodBeat.o(83059);
                return str;
            }
        } else {
            AppMethodBeat.o(83059);
            return str;
        }
    }

    static /* synthetic */ void a(f fVar, Context context) {
        AppMethodBeat.i(83060);
        fVar.mcu = new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.game.luggage.b.f.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        };
        context.getString(R.string.zb);
        fVar.gxX = com.tencent.mm.ui.base.h.a(context, context.getString(R.string.e_8), false, fVar.mcu);
        AppMethodBeat.o(83060);
    }

    static /* synthetic */ String au(ArrayList arrayList) {
        boolean z;
        String str;
        AppMethodBeat.i(83061);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            long currentTimeMillis = System.currentTimeMillis();
            String str3 = xwF + "microMsg.image." + currentTimeMillis + "." + (str2.hashCode() & 65535);
            String str4 = xwF + "microMsg.thumb." + currentTimeMillis + "." + (str2.hashCode() & 65535);
            if (Util.isNullOrNil(str2) || Exif.fromFile(str2).getOrientationInDegree() == 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                str = hE(str2, str3);
            } else if (s.nw(str2, str3) > 0) {
                str = str3;
            } else {
                str = str2;
            }
            WebViewJSSDKFileItem ma = WebViewJSSDKFileItem.ma(str, str4);
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
            ma.width = imageOptions.outWidth;
            ma.height = imageOptions.outHeight;
            ((WebViewJSSDKImageItem) ma).xlR = ImgUtil.isGif(str);
            String str5 = ma.dJX;
            g.gdv().a(ma);
            Log.i("MicroMsg.JsApiChooseHaowanMedia", "now filepath is : %s, local id is : %s", str, str5);
            arrayList2.add(str5);
        }
        String bd = ay.bd(arrayList2);
        Log.i("MicroMsg.JsApiChooseHaowanMedia", "after parse to json data : %s", bd);
        AppMethodBeat.o(83061);
        return bd;
    }
}
