package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;

public final class s implements com.tencent.mm.platformtools.s {
    private boolean JVy;
    private boolean dKW;
    private long jqE;
    private long jqF;
    private String kSm;
    private String url;

    public static String bdu(String str) {
        AppMethodBeat.i(116445);
        if (g.aAf().azp()) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            String format = String.format("%s%s", "wcf://bizimg/", com.tencent.mm.b.g.getMessageDigest(sb.append(com.tencent.mm.kernel.a.ayV()).append(str).toString().getBytes()));
            AppMethodBeat.o(116445);
            return format;
        }
        AppMethodBeat.o(116445);
        return "";
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blA() {
        AppMethodBeat.i(116446);
        String bdu = bdu(this.url);
        AppMethodBeat.o(116446);
        return bdu;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blB() {
        AppMethodBeat.i(116447);
        String OO = t.OO(this.url);
        AppMethodBeat.o(116447);
        return OO;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blC() {
        return this.url;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String getCacheKey() {
        AppMethodBeat.i(116448);
        String str = this.url + this.kSm;
        AppMethodBeat.o(116448);
        return str;
    }

    @Override // com.tencent.mm.platformtools.s
    public final boolean blD() {
        return false;
    }

    @Override // com.tencent.mm.platformtools.s
    public final boolean blE() {
        return this.dKW;
    }

    public static final class a {

        /* renamed from: h  reason: collision with root package name */
        public int f1527h;
        public int w;
        public int x;
        public int y;

        public final String toString() {
            AppMethodBeat.i(116444);
            String format = String.format("crop area[x=%d,y=%d,h=%d,w=%d]", Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.f1527h), Integer.valueOf(this.w));
            AppMethodBeat.o(116444);
            return format;
        }
    }

    @Override // com.tencent.mm.platformtools.s
    public final Bitmap a(Bitmap bitmap, s.a aVar, String str) {
        int i2;
        int i3;
        Resources resources;
        AppMethodBeat.i(116449);
        if (s.a.NET == aVar) {
            String str2 = this.kSm;
            a aVar2 = new a();
            Context context = MMApplicationContext.getContext();
            DisplayMetrics displayMetrics = null;
            if (!(context == null || (resources = context.getResources()) == null)) {
                displayMetrics = resources.getDisplayMetrics();
            }
            if (displayMetrics != null) {
                if ("@T".equals(str2)) {
                    i2 = (int) (displayMetrics.density * 167.0f);
                    i3 = (int) (((float) displayMetrics.widthPixels) - (60.0f * displayMetrics.density));
                } else {
                    int i4 = (int) (displayMetrics.density * 50.0f);
                    i2 = i4;
                    i3 = i4;
                }
            } else if ("@T".equals(str2)) {
                i2 = TbsListener.ErrorCode.ERROR_ONE_WIZARD_CREATE_FAIL;
                i3 = Integer.MAX_VALUE;
            } else {
                i2 = 100;
                i3 = 100;
            }
            aVar2.w = i3;
            aVar2.f1527h = i2;
            Log.d("MicroMsg.ReaaderAppGetPicStrategy", aVar2.toString());
            bitmap = BitmapUtil.getCenterCropBitmap(bitmap, aVar2.w, aVar2.f1527h, true);
            try {
                Log.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", bdu(this.url));
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, bdu(this.url), false);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ReaaderAppGetPicStrategy", e2, "", new Object[0]);
                Log.e("MicroMsg.ReaaderAppGetPicStrategy", "save image %s fail", this.url);
            }
            AppMethodBeat.o(116449);
        } else {
            AppMethodBeat.o(116449);
        }
        return bitmap;
    }

    @Override // com.tencent.mm.platformtools.s
    public final void blG() {
        AppMethodBeat.i(116450);
        this.jqE = Util.nowMilliSecond();
        if (this.JVy) {
            Log.d("MicroMsg.ReaaderAppGetPicStrategy", "beforeGetPicFromNet, from biz msg");
            h.INSTANCE.idkeyStat(86, 0, 1, false);
        }
        AppMethodBeat.o(116450);
    }

    @Override // com.tencent.mm.platformtools.s
    public final void ad(String str, boolean z) {
        AppMethodBeat.i(116451);
        this.jqF = Util.nowMilliSecond();
        boolean z2 = false;
        if (t.bcZ() && !Util.isNullOrNil(str) && t.fm(t.OO(this.url)) && str.equals("image/webp")) {
            z2 = true;
        }
        if (this.JVy) {
            if (!z) {
                Log.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image failed");
                h.INSTANCE.idkeyStat(86, 2, 1, false);
                if (z2) {
                    Log.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image failed");
                    h.INSTANCE.idkeyStat(86, 15, 1, false);
                    AppMethodBeat.o(116451);
                    return;
                }
            } else {
                long j2 = this.jqF - this.jqE;
                Log.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image success, used %d", Long.valueOf(j2));
                h.INSTANCE.idkeyStat(86, 4, j2, false);
                if (z2) {
                    Log.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image success");
                    h.INSTANCE.idkeyStat(86, 17, j2, false);
                    h.INSTANCE.idkeyStat(86, 13, 1, false);
                }
            }
        }
        AppMethodBeat.o(116451);
    }

    @Override // com.tencent.mm.platformtools.s
    public final void a(s.a aVar, String str) {
        AppMethodBeat.i(116452);
        if (aVar == s.a.NET && this.JVy && t.bcZ() && !Util.isNullOrNil(str) && t.fm(t.OO(this.url)) && str.equals("image/webp")) {
            Log.d("MicroMsg.ReaaderAppGetPicStrategy", "decode download webp picture failed");
            h.INSTANCE.idkeyStat(86, 14, 1, false);
        }
        AppMethodBeat.o(116452);
    }

    @Override // com.tencent.mm.platformtools.s
    public final Bitmap blF() {
        AppMethodBeat.i(116453);
        Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjn);
        AppMethodBeat.o(116453);
        return decodeResource;
    }

    @Override // com.tencent.mm.platformtools.s
    public final s.b blz() {
        return null;
    }
}
