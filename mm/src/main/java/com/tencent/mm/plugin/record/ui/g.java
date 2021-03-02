package com.tencent.mm.plugin.record.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.record.ui.h;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.s;

public final class g extends n implements h.a {
    @Override // com.tencent.mm.plugin.record.ui.h.a
    public final void a(h.a.C1632a aVar) {
        amj amj;
        String str;
        boolean z;
        anq anq;
        String str2;
        String str3;
        boolean z2;
        String str4 = null;
        AppMethodBeat.i(27865);
        ImageView imageView = aVar.dKU;
        aml aml = aVar.dKT;
        long j2 = aVar.BHU;
        int i2 = aVar.dKV;
        int i3 = aVar.width;
        int i4 = aVar.height;
        if (imageView == null) {
            AppMethodBeat.o(27865);
        } else if (!e.apn()) {
            imageView.setImageResource(R.drawable.bjn);
            AppMethodBeat.o(27865);
        } else if (aml == null) {
            imageView.setImageResource(i2);
            AppMethodBeat.o(27865);
        } else {
            switch (aml.dataType) {
                case 4:
                case 15:
                    super.a(imageView, aml, j2, aml.dFN, i2, i3, i4);
                    AppMethodBeat.o(27865);
                    return;
                case 5:
                    if (aml.Lwh != null) {
                        anq = aml.Lwh.LwS;
                        amt amt = aml.Lwh.IXu;
                        if (amt == null || amt.iwc != 5 || !((b) com.tencent.mm.kernel.g.af(b.class)).cld()) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        z = z2;
                    } else {
                        Log.w("MicroMsg.RecordMsgImgService", "webpage: get data proto item null, dataid[%s]", aml.dLl);
                        z = false;
                        anq = null;
                    }
                    if (anq == null) {
                        str2 = null;
                    } else {
                        str2 = anq.thumbUrl;
                    }
                    if (Util.isNullOrNil(str2)) {
                        str3 = aml.dFN;
                    } else {
                        str3 = str2;
                    }
                    if (z) {
                        str3 = com.tencent.mm.api.b.u(str3, 4);
                    }
                    super.a(imageView, aml, j2, str3, i2, i3, i4);
                    AppMethodBeat.o(27865);
                    return;
                case 7:
                case 29:
                    String a2 = super.a(imageView, aml, j2, aml.dFN, i2, i3, i4);
                    if (!(aml.Lwh == null || aml.Lwh.Lxs == null)) {
                        aml.Lwh.Lxs.jfz = a2;
                        AppMethodBeat.o(27865);
                        return;
                    }
                case 10:
                    if (aml.Lwh == null) {
                        Log.w("MicroMsg.RecordMsgImgService", "good: get data proto item null, dataid[%s]", aml.dLl);
                        AppMethodBeat.o(27865);
                        return;
                    }
                    ana ana = aml.Lwh.LwU;
                    if (ana != null) {
                        this.BGZ.a(imageView, null, ana.thumbUrl, i2, i3, i4);
                        AppMethodBeat.o(27865);
                        return;
                    }
                    break;
                case 11:
                    if (aml.Lwh == null) {
                        Log.w("MicroMsg.RecordMsgImgService", "product: get data proto item null, dataid[%s]", aml.dLl);
                        AppMethodBeat.o(27865);
                        return;
                    }
                    ana ana2 = aml.Lwh.LwU;
                    if (ana2 != null) {
                        this.BGZ.a(imageView, null, ana2.thumbUrl, i2, i3, i4);
                        AppMethodBeat.o(27865);
                        return;
                    }
                    break;
                case 14:
                    if (aml.Lwh == null) {
                        Log.w("MicroMsg.RecordMsgImgService", "tv: get data proto item null, dataid[%s]", aml.dLl);
                        AppMethodBeat.o(27865);
                        return;
                    }
                    ank ank = aml.Lwh.LwW;
                    if (ank != null) {
                        this.BGZ.a(imageView, null, ank.thumbUrl, i2, i3, i4);
                        AppMethodBeat.o(27865);
                        return;
                    }
                    break;
                case 19:
                    if (aml.Lwh != null) {
                        amj = aml.Lwh.Lxf;
                    } else {
                        Log.w("MicroMsg.RecordMsgImgService", "appbrand: get data proto item null, dataid[%s]", aml.dLl);
                        amj = null;
                    }
                    if (amj != null) {
                        str4 = amj.iconUrl;
                    }
                    if (Util.isNullOrNil(str4)) {
                        str = aml.dFN;
                    } else {
                        str = str4;
                    }
                    super.a(imageView, aml, j2, str, i2, i3, i4);
                    AppMethodBeat.o(27865);
                    return;
                case 22:
                    if (aml.Lwh == null || aml.Lwh.Lxk == null || Util.isNullOrNil(aml.Lwh.Lxk.mediaList) || Util.isNullOrNil(aml.Lwh.Lxk.mediaList.getFirst().thumbUrl)) {
                        imageView.setImageDrawable(ar.m(imageView.getContext(), R.raw.icons_outlined_finder_icon, imageView.getContext().getResources().getColor(R.color.Orange)));
                        AppMethodBeat.o(27865);
                        return;
                    }
                    this.BGZ.a(imageView, null, aml.Lwh.Lxk.mediaList.getFirst().thumbUrl, i2, i3, i4);
                    AppMethodBeat.o(27865);
                    return;
                default:
                    Log.w("MicroMsg.RecordMsgImgService", "attach thumb, pass data type is %d", Integer.valueOf(aml.dataType));
                    break;
            }
            AppMethodBeat.o(27865);
        }
    }

    @Override // com.tencent.mm.plugin.record.ui.h.a
    public final Bitmap a(h.a.c cVar) {
        AppMethodBeat.i(27866);
        Bitmap b2 = super.b(cVar.dKT, cVar.BHU);
        AppMethodBeat.o(27866);
        return b2;
    }

    @Override // com.tencent.mm.plugin.record.ui.h.a
    public final Bitmap a(h.a.b bVar) {
        Bitmap bitmap;
        int i2;
        int i3;
        AppMethodBeat.i(27867);
        aml aml = bVar.dKT;
        long j2 = bVar.BHU;
        boolean z = bVar.dKW;
        int i4 = bVar.maxWidth;
        if (!e.apn()) {
            bitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjn);
        } else {
            String c2 = p.c(aml, j2);
            if (Util.isNullOrNil(c2) || !s.YS(c2)) {
                Log.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", Boolean.FALSE, c2);
                bitmap = null;
            } else {
                bitmap = this.tgj.get(c2);
                if (bitmap != null) {
                    Log.d("MicroMsg.RecordMsgImgService", "get bm from cache %s", c2);
                } else if (z) {
                    bitmap = null;
                } else {
                    Log.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", c2);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    Bitmap decodeFile = BitmapFactory.decodeFile(c2, options);
                    if (decodeFile != null) {
                        Log.i("MicroMsg.RecordMsgImgService", "bitmap recycle %s", decodeFile);
                        decodeFile.recycle();
                    }
                    int i5 = options.outHeight;
                    int i6 = options.outWidth;
                    Log.d("MicroMsg.RecordMsgImgService", "width: %s, height: %s", Integer.valueOf(i6), Integer.valueOf(i5));
                    if (i6 > i4) {
                        i5 = (options.outHeight * i4) / options.outWidth;
                        i6 = i4;
                    }
                    int max = Math.max(1, i6);
                    int max2 = Math.max(1, i5);
                    if (max > i4) {
                        max2 = (options.outHeight * i4) / options.outWidth;
                    } else {
                        i4 = max;
                    }
                    int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(c2);
                    if (exifOrientation == 90 || exifOrientation == 270) {
                        i3 = i4;
                        i2 = max2;
                    } else {
                        i3 = max2;
                        i2 = i4;
                    }
                    Bitmap extractThumbNail = BitmapUtil.extractThumbNail(c2, i3, i2, false);
                    if (extractThumbNail == null) {
                        Log.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = ".concat(String.valueOf(c2)));
                        bitmap = null;
                    } else {
                        bitmap = BitmapUtil.rotate(extractThumbNail, (float) exifOrientation);
                        this.tgj.put(c2, bitmap);
                    }
                }
            }
        }
        if (bitmap == null && !z) {
            boolean a2 = super.a(aml, j2);
            Log.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", Boolean.valueOf(a2));
            if (a2) {
                p.b(aml, j2, a2);
            }
        }
        AppMethodBeat.o(27867);
        return bitmap;
    }

    @Override // com.tencent.mm.plugin.record.ui.h.a
    public final void eIr() {
        AppMethodBeat.i(27868);
        super.destory();
        AppMethodBeat.o(27868);
    }
}
