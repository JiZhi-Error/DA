package com.tencent.mm.plugin.extaccessories;

import android.graphics.Bitmap;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.rk;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.extaccessories.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
public class SubCoreExtAccessories$RegistSpenBuddyEventListener$1 implements SlookWritingBuddy.ImageWritingListener {
    final /* synthetic */ rk sOK;
    final /* synthetic */ b.a sOL;

    SubCoreExtAccessories$RegistSpenBuddyEventListener$1(b.a aVar, rk rkVar) {
        this.sOL = aVar;
        this.sOK = rkVar;
    }

    @Override // com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener
    public void onImageReceived(Bitmap bitmap) {
        String str;
        AppMethodBeat.i(24541);
        Log.i("MicroMsg.extaccessories.SubCoreExtAccessories", "onImageReceived");
        if (bitmap == null) {
            Log.e("MicroMsg.extaccessories.SubCoreExtAccessories", "img is null");
            this.sOK.dXZ.dYa.beB(null);
            AppMethodBeat.o(24541);
        } else if (!e.apn()) {
            Log.e("MicroMsg.extaccessories.SubCoreExtAccessories", "SDCard not available");
            this.sOK.dXZ.dYa.beB(null);
            AppMethodBeat.o(24541);
        } else {
            bg.aVz();
            b bVar = (b) cg.KG("plugin.extaccessories");
            if (bVar == null) {
                Log.w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
                bVar = new b();
                bg.aVz().a("plugin.extaccessories", bVar);
            }
            String sb = new StringBuilder().append(System.currentTimeMillis()).toString();
            if (!bg.aAc() || Util.isNullOrNil(sb)) {
                str = "";
            } else {
                str = bVar.hqG + "image/spen/spen_" + sb;
            }
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.extaccessories.SubCoreExtAccessories", "filePath is null");
                this.sOK.dXZ.dYa.beB(null);
                AppMethodBeat.o(24541);
                return;
            }
            try {
                if (bitmap.getWidth() > 1000 || bitmap.getHeight() > 1000) {
                    Log.d("MicroMsg.extaccessories.SubCoreExtAccessories", "spen image %d, %d, need scale", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, true);
                    if (!(bitmap == createScaledBitmap || createScaledBitmap == null)) {
                        Log.i("MicroMsg.extaccessories.SubCoreExtAccessories", "bitmap recycle %s", bitmap.toString());
                        bitmap.recycle();
                        bitmap = createScaledBitmap;
                    }
                }
                BitmapUtil.saveBitmapToImage(bitmap, 55, Bitmap.CompressFormat.JPEG, str, true);
                Log.d("MicroMsg.extaccessories.SubCoreExtAccessories", "save spen temp image : %s", str);
                this.sOK.dXZ.dYa.beB(str);
                AppMethodBeat.o(24541);
            } catch (Exception e2) {
                Log.e("MicroMsg.extaccessories.SubCoreExtAccessories", "Exception %s", e2.getMessage());
                Log.printErrStackTrace("MicroMsg.extaccessories.SubCoreExtAccessories", e2, "", new Object[0]);
                this.sOK.dXZ.dYa.beB(null);
                AppMethodBeat.o(24541);
            }
        }
    }
}
