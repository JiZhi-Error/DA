package com.tencent.mm.plugin.record.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.HashSet;

public class n {
    protected k BGZ = new k() {
        /* class com.tencent.mm.plugin.record.b.n.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.ui.tools.k
        public final s i(String str, String str2, int i2, int i3) {
            AppMethodBeat.i(27806);
            r rVar = new r(str, str2, i2, i3);
            AppMethodBeat.o(27806);
            return rVar;
        }
    };
    private HashSet<String> BHa = new HashSet<>();
    private HashMap<String, f.a> BHb = new HashMap<>();
    private HashMap<String, String[]> tgh = new HashMap<>();
    protected com.tencent.mm.b.f<String, Bitmap> tgj = new b(10, getClass());

    public n() {
        AppMethodBeat.i(27807);
        AppMethodBeat.o(27807);
    }

    public final void destory() {
        AppMethodBeat.i(27808);
        this.BGZ.destroy();
        this.tgh.clear();
        this.BHa.clear();
        this.BGZ = null;
        this.tgh = null;
        this.BHa = null;
        AppMethodBeat.o(27808);
    }

    public final Bitmap a(aml aml, long j2, boolean z) {
        String c2;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z2 = true;
        AppMethodBeat.i(27810);
        if (!e.apn()) {
            Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjn);
            AppMethodBeat.o(27810);
            return decodeResource;
        }
        if (z) {
            c2 = p.f(aml, j2);
        } else {
            c2 = p.c(aml, j2);
        }
        if (Util.isNullOrNil(c2) || !com.tencent.mm.vfs.s.YS(c2)) {
            Log.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", Boolean.valueOf(z), c2);
            AppMethodBeat.o(27810);
            return null;
        }
        Bitmap bitmap = this.tgj.get(c2);
        if (bitmap != null) {
            AppMethodBeat.o(27810);
            return bitmap;
        }
        Log.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", c2);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(c2, options);
        if (decodeFile != null) {
            Log.i("MicroMsg.RecordMsgImgService", "bitmap recycled %s", decodeFile);
            decodeFile.recycle();
        }
        boolean z3 = LongBitmapHandler.isLongHorizontal(options.outWidth, options.outHeight) && options.outWidth > 480;
        if (!LongBitmapHandler.isLongVertical(options.outWidth, options.outHeight) || options.outHeight <= 480) {
            z2 = false;
        }
        if (z3 || z2) {
            i3 = options.outHeight;
            i2 = options.outWidth;
        } else {
            i3 = 960;
            i2 = 960;
        }
        int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(c2);
        if (exifOrientation == 90 || exifOrientation == 270) {
            i5 = i2;
            i4 = i3;
        } else {
            i5 = i3;
            i4 = i2;
        }
        Bitmap extractThumbNail = BitmapUtil.extractThumbNail(c2, i5, i4, false);
        if (extractThumbNail == null) {
            Log.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = ".concat(String.valueOf(c2)));
            AppMethodBeat.o(27810);
            return null;
        }
        Bitmap rotate = BitmapUtil.rotate(extractThumbNail, (float) exifOrientation);
        this.tgj.put(c2, rotate);
        AppMethodBeat.o(27810);
        return rotate;
    }

    public final Bitmap b(aml aml, long j2) {
        AppMethodBeat.i(27811);
        Bitmap a2 = a(aml, j2, true);
        if (a2 == null) {
            boolean a3 = a(aml, j2);
            Log.d("MicroMsg.RecordMsgImgService", "get thumb fail, try download, can retry:%B", Boolean.valueOf(a3));
            p.c(aml, j2, a3);
        }
        AppMethodBeat.o(27811);
        return a2;
    }

    /* access modifiers changed from: protected */
    public final String a(ImageView imageView, aml aml, long j2, String str, int i2, int i3, int i4) {
        String[] strArr;
        AppMethodBeat.i(258860);
        String str2 = p.arI(aml.dLl) + "@" + String.valueOf(j2);
        if (aml.dLl != null) {
            String[] strArr2 = this.tgh.get(str2);
            if (strArr2 == null || strArr2.length <= 0) {
                strArr = new String[]{p.f(aml, j2)};
                this.tgh.put(str2, strArr);
            } else {
                strArr = strArr2;
            }
            this.BGZ.a(imageView, strArr, str, i2, i3, i4);
            if (this.BHa.contains(str2)) {
                String str3 = strArr[0];
                AppMethodBeat.o(258860);
                return str3;
            }
            this.BHa.add(str2);
            if (!new o(strArr[0]).exists() && (!Util.isNullOrNil(aml.iwX) || !Util.isNullOrNil(aml.iwO))) {
                p.c(aml, j2, a(aml, j2));
            }
            String str4 = strArr[0];
            AppMethodBeat.o(258860);
            return str4;
        }
        AppMethodBeat.o(258860);
        return null;
    }

    public final boolean a(aml aml, long j2) {
        AppMethodBeat.i(27809);
        String g2 = p.g(aml.dLl, j2, true);
        f.a aVar = this.BHb.get(g2);
        if (aVar == null) {
            this.BHb.put(g2, new f.a());
            AppMethodBeat.o(27809);
            return true;
        } else if (aVar.apr() > 30000) {
            aVar.gLm = SystemClock.elapsedRealtime();
            AppMethodBeat.o(27809);
            return true;
        } else {
            AppMethodBeat.o(27809);
            return false;
        }
    }
}
