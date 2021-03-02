package com.tencent.mm.plugin.exdevice.g.a;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.an.f;
import com.tencent.mm.br.c;
import com.tencent.mm.i.a;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import junit.framework.Assert;

public final class e {
    public static void a(final Context context, final ImageView imageView, final String str) {
        AppMethodBeat.i(23509);
        Assert.assertTrue(imageView != null);
        if (MMHandlerThread.isMainThread()) {
            b(imageView, str, R.color.kw);
            AppMethodBeat.o(23509);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.g.a.e.AnonymousClass1 */
            final /* synthetic */ int rCl = R.color.kw;

            public final void run() {
                AppMethodBeat.i(23506);
                e.b(imageView, str, this.rCl);
                AppMethodBeat.o(23506);
            }
        });
        AppMethodBeat.o(23509);
    }

    static void b(ImageView imageView, String str, int i2) {
        AppMethodBeat.i(23510);
        if (Util.isNullOrNil(str) || "#".equals(str)) {
            Log.d("MicroMsg.ExdeviceRankUtil", "hy: url is null or nill. set to default picture resource");
            imageView.setImageResource(i2);
            AppMethodBeat.o(23510);
            return;
        }
        Log.d("MicroMsg.ExdeviceRankUtil", "hy: set url to %s", str);
        ad.cKO().a(str, imageView, ad.any(str));
        AppMethodBeat.o(23510);
    }

    public static void e(final MMActivity mMActivity) {
        AppMethodBeat.i(23511);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) mMActivity.getContext(), 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.exdevice.g.a.e.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(23507);
                mVar.d(0, mMActivity.getString(R.string.bz6));
                AppMethodBeat.o(23507);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.exdevice.g.a.e.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(23508);
                if (menuItem.getItemId() == 0) {
                    MMActivity mMActivity = mMActivity;
                    Intent intent = new Intent();
                    intent.putExtra("query_source_type", 9);
                    intent.putExtra("query_media_type", 1);
                    intent.putExtra("max_select_count", 1);
                    c.b(mMActivity, "gallery", ".ui.AlbumPreviewUI", intent, 1001);
                }
                AppMethodBeat.o(23508);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(23511);
    }

    public static boolean a(MMActivity mMActivity, int i2, int i3, Intent intent, String str) {
        AppMethodBeat.i(23512);
        if (i2 == 1001 && i3 == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                Intent intent2 = new Intent(mMActivity, ImageCropUI.class);
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_OutputPath", b.aKZ() + "temp.cover");
                intent2.putExtra("CropImage_ImgPath", stringArrayListExtra.get(0));
                mMActivity.startActivityForResult(intent2, 1002);
                AppMethodBeat.o(23512);
                return true;
            }
        } else if (i2 == 1002 && i3 == -1) {
            String anA = d.anA(b.aKZ() + "temp.cover");
            c cKV = ad.cKV();
            cKV.appName = str;
            long currentTimeMillis = System.currentTimeMillis();
            cKV.rCh = com.tencent.mm.an.c.a("uploadexdeivce", currentTimeMillis, z.aUL().field_username, String.valueOf(currentTimeMillis));
            String str2 = cKV.rCh;
            g gVar = new g();
            gVar.taskName = "task_ExdevicePictureUploader";
            gVar.gqy = cKV;
            gVar.field_mediaId = str2;
            gVar.field_fullpath = anA;
            gVar.field_thumbpath = "";
            gVar.field_fileType = a.gpY;
            gVar.field_talker = "";
            gVar.field_priority = a.gpL;
            gVar.field_needStorage = true;
            gVar.field_isStreamMedia = false;
            gVar.field_appType = 200;
            gVar.field_bzScene = 2;
            if (!f.baQ().f(gVar)) {
                Log.e("MicroMsg.ExdevicePictureUploader", "hy: cdntra addSendTask failed. clientid:%s", str2);
            }
            AppMethodBeat.o(23512);
            return true;
        }
        AppMethodBeat.o(23512);
        return false;
    }
}
