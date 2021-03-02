package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c;
import com.tencent.xweb.i;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

public final class j {
    private static long Jbq = 0;
    private static int Jbr = -1;
    private static int Jbs = -1;
    private static boolean Jbt = false;
    private static Map<String, String> Jbu = new HashMap();

    static {
        AppMethodBeat.i(79211);
        AppMethodBeat.o(79211);
    }

    public static void gdB() {
        AppMethodBeat.i(79204);
        Jbq = System.currentTimeMillis();
        AppMethodBeat.o(79204);
    }

    public static void a(Bundle bundle, MMWebView mMWebView, Bundle bundle2, boolean z) {
        AppMethodBeat.i(182699);
        if (System.currentTimeMillis() - Jbq < 1000) {
            AppMethodBeat.o(182699);
            return;
        }
        String string = bundle.getString("url");
        String string2 = bundle.getString("filePath");
        String[] strArr = new String[1];
        if (!Util.isNullOrNil(string2)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = BitmapUtil.decodeFile(string2, options);
            if (decodeFile != null) {
                Log.i("MicroMsg.WebViewPreviewImgHelper", "recycle bitmap:%s", decodeFile.toString());
                decodeFile.recycle();
                strArr[0] = string2;
                if (Util.isNullOrNil(string2) || Util.isNullOrNil(string)) {
                    Log.w("MicroMsg.WebViewPreviewImgHelper", "imagePreview failed url is null");
                    AppMethodBeat.o(182699);
                }
                strArr[0] = string;
                Intent intent = new Intent();
                intent.putExtra("nowUrl", string);
                intent.putExtra("urlList", strArr);
                intent.putExtra("type", -255);
                intent.putExtra("isFromWebView", true);
                intent.putExtra("isOuntLink", true);
                boolean z2 = true;
                String str = "";
                try {
                    String url = mMWebView.getUrl();
                    String cookie = c.hsp().getCookie(url);
                    Log.i("MicroMsg.WebViewPreviewImgHelper", "url = %s, cookie = %s", url, cookie);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("cookie", cookie);
                    float gvp = a.gvp();
                    if (mMWebView != null && mMWebView.getWebCoreType() == WebView.c.WV_KIND_CW && XWalkEnvironment.getUsingCustomContext()) {
                        gvp = mMWebView.getResources().getDisplayMetrics().density;
                    }
                    bundle3.putFloat(Constants.PARAM_DENSITY, gvp);
                    String string3 = bundle3.getString("cookie", null);
                    if (!Util.isNullOrNil(string3)) {
                        intent.putExtra("cookie", string3);
                    }
                    if (bundle2 != null) {
                        String string4 = bundle2.getString("preChatName");
                        String string5 = bundle2.getString("preUsername");
                        String string6 = bundle2.getString("rawUrl");
                        str = bundle2.getString("url");
                        int i2 = bundle2.getInt("getA8KeyScene");
                        String JX = ad.JX("ImgPreview");
                        ad.b G = ad.aVe().G(JX, true);
                        G.l("preUsername", string4);
                        G.l("preChatName", string5);
                        G.l("url", str);
                        G.l("Contact_Sub_Scene", 6);
                        G.l("Contact_Scene_Note", string);
                        G.l("rawUrl", string6);
                        if (i2 == 53 || i2 == 52) {
                            Log.i("MicroMsg.WebViewPreviewImgHelper", "not allow to ScanQRCode");
                            z2 = false;
                        }
                        intent.putExtra("img_gallery_session_id", JX);
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.WebViewPreviewImgHelper", "getCookie fail : %s", e2.getMessage());
                }
                intent.putExtra("shouldShowScanQrCodeMenu", z2);
                Bundle bundle4 = new Bundle();
                bundle4.putInt("stat_scene", 4);
                bundle4.putString("stat_url", str);
                intent.putExtra("_stat_obj", bundle4);
                Context context = MMApplicationContext.getContext();
                if (gdD()) {
                    int eu = au.eu(context);
                    int ay = au.ay(context);
                    int i3 = (int) bundle.getFloat("width");
                    int i4 = (int) bundle.getFloat("height");
                    int i5 = (int) bundle.getFloat("left");
                    int i6 = (int) (((float) (z ? 0 : eu + ay)) + bundle.getFloat("top"));
                    int jo = com.tencent.mm.cb.a.jo(context);
                    Log.d("MicroMsg.WebViewPreviewImgHelper", "doPreviewImg left %d, top %d, w %d, h %d", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i3), Integer.valueOf(i4));
                    intent.putExtra("img_gallery_width", i3).putExtra("img_gallery_height", i4).putExtra("img_gallery_left", i5).putExtra("img_gallery_top", i6);
                    if (i3 > 0 && i4 > 0 && i4 < jo) {
                        intent.putExtra("shouldRunDragAnimation", true);
                    }
                }
                com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "subapp", ".ui.gallery.GestureGalleryUI", intent);
                AppMethodBeat.o(182699);
                return;
            }
            Log.i("MicroMsg.WebViewPreviewImgHelper", "decode fail %s", string2);
        }
        string2 = "";
        if (Util.isNullOrNil(string2)) {
        }
        Log.w("MicroMsg.WebViewPreviewImgHelper", "imagePreview failed url is null");
        AppMethodBeat.o(182699);
    }

    public static void c(e eVar) {
        AppMethodBeat.i(79206);
        if (eVar == null) {
            AppMethodBeat.o(79206);
            return;
        }
        try {
            eVar.j(108, new Bundle());
            AppMethodBeat.o(79206);
        } catch (RemoteException e2) {
            AppMethodBeat.o(79206);
        }
    }

    public static void gdC() {
        AppMethodBeat.i(182700);
        EventCenter.instance.publish(new cf());
        AppMethodBeat.o(182700);
    }

    public static boolean gdD() {
        AppMethodBeat.i(79207);
        if (Jbr == -1) {
            Jbr = ((b) g.af(b.class)).a(b.a.clicfg_webview_preview_img_with_ani, 1);
            Log.i("MicroMsg.WebViewPreviewImgHelper", "shouldShowAnimation %d", Integer.valueOf(Jbr));
        }
        if (Jbr == 1) {
            AppMethodBeat.o(79207);
            return true;
        }
        AppMethodBeat.o(79207);
        return false;
    }

    public static void a(Map<String, Object> map, MMWebView mMWebView) {
        boolean z;
        AppMethodBeat.i(79208);
        if (mMWebView == null || map == null) {
            AppMethodBeat.o(79208);
            return;
        }
        if (Jbs == -1) {
            Jbs = ((b) g.af(b.class)).a(b.a.clicfg_open_xweb_url_to_path_v2, 1);
            Log.i("MicroMsg.WebViewPreviewImgHelper", "openXWebUrlToPath %d", Integer.valueOf(Jbs));
        }
        if (Jbs == 1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(79208);
            return;
        }
        final String str = (String) map.get("current");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(79208);
            return;
        }
        Log.d("MicroMsg.WebViewPreviewImgHelper", "start getImageBitmapToFile");
        String str2 = com.tencent.mm.loader.l.b.aLN() + "/reader_" + com.tencent.mm.b.g.getMessageDigest(str.getBytes()) + ".jpg";
        if (s.YS(str2)) {
            Log.i("MicroMsg.WebViewPreviewImgHelper", "getImageBitmapToFile savePath exist");
            Jbu.put(str, str2);
            Jbt = true;
            AppMethodBeat.o(79208);
            return;
        }
        Jbt = mMWebView.getImageBitmapToFile(str, str2, "", new i() {
            /* class com.tencent.mm.plugin.webview.modeltools.j.AnonymousClass1 */

            @Override // com.tencent.xweb.i
            public final void cV(int i2, String str) {
                AppMethodBeat.i(79203);
                Log.i("MicroMsg.WebViewPreviewImgHelper", "onFinishImageBitmapToFile result %d", Integer.valueOf(i2));
                if (j.Jbt) {
                    h.INSTANCE.idkeyStat(1059, i2 == 0 ? 0 : 1, 1, false);
                }
                if (i2 != 0) {
                    AppMethodBeat.o(79203);
                    return;
                }
                j.Jbu.put(str, str);
                AppMethodBeat.o(79203);
            }
        });
        AppMethodBeat.o(79208);
    }

    public static String aZt(String str) {
        String str2 = null;
        AppMethodBeat.i(79209);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(79209);
        } else if (!Jbt) {
            AppMethodBeat.o(79209);
        } else {
            str2 = Jbu.get(str);
            if (!Util.isNullOrNil(str2)) {
                h.INSTANCE.idkeyStat(1059, 2, 1, false);
            } else {
                h.INSTANCE.idkeyStat(1059, 5, 1, false);
            }
            AppMethodBeat.o(79209);
        }
        return str2;
    }

    public static boolean aZu(String str) {
        AppMethodBeat.i(79210);
        if (Util.isNullOrNil(str) || !s.YS(str)) {
            Log.i("MicroMsg.WebViewPreviewImgHelper", "checkCurrentPath path is null");
            AppMethodBeat.o(79210);
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(str, options);
        if (options.outWidth <= 1 || options.outHeight <= 1) {
            Log.i("MicroMsg.WebViewPreviewImgHelper", "checkCurrentPath file path invalid: %s", str);
            h.INSTANCE.idkeyStat(1059, 4, 1, false);
            AppMethodBeat.o(79210);
            return false;
        }
        h.INSTANCE.idkeyStat(1059, 3, 1, false);
        Log.i("MicroMsg.WebViewPreviewImgHelper", "checkCurrentPath path: %s", str);
        AppMethodBeat.o(79210);
        return true;
    }
}
