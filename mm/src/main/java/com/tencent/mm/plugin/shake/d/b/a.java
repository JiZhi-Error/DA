package com.tencent.mm.plugin.shake.d.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

public final class a extends BitmapDrawable implements u.a {
    private static Bitmap Djh;
    private static final Paint iuG;
    private String Djf;
    private s Djg;
    private int hZB;
    private ImageView tkI;
    private int type;
    private String username;

    static {
        AppMethodBeat.i(28358);
        Paint paint = new Paint();
        iuG = paint;
        paint.setAntiAlias(true);
        iuG.setFilterBitmap(true);
        AppMethodBeat.o(28358);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(28354);
        Log.i("MicroMsg.ShakeAvatarDrawable", "album username[%s], url[%s], type[%d], attr[%s]", this.username, this.Djf, Integer.valueOf(this.type), toString());
        if (4 == this.type || (k.XA(this.type) && 6 != this.type)) {
            Bitmap bitmap = null;
            if (4 == this.type) {
                this.Djg = new C1692a(this.Djf);
                bitmap = u.a(this.Djg);
            } else if (k.XA(this.type) && 6 != this.type) {
                this.Djg = new b(this.Djf);
                bitmap = u.a(this.Djg);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                Log.i("MicroMsg.ShakeAvatarDrawable", "bm is null or recycled, album url[%s]", this.Djf);
                bitmap = as(this.tkI, this.hZB);
            }
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, getBounds(), iuG);
            }
            AppMethodBeat.o(28354);
            return;
        }
        AppMethodBeat.o(28354);
    }

    private static Bitmap as(View view, int i2) {
        AppMethodBeat.i(28355);
        if (view == null) {
            Bitmap bitmap = Djh;
            AppMethodBeat.o(28355);
            return bitmap;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (Djh == null || Djh.getWidth() != measuredWidth) {
            if (i2 > 0) {
                try {
                    Djh = BitmapUtil.transformDrawableToBitmap(view.getResources().getDrawable(i2));
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", e2, "", new Object[0]);
                }
            } else {
                Djh = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
            }
            if (Djh.getWidth() != measuredWidth && measuredWidth > 0 && measuredHeight > 0) {
                Djh = Bitmap.createScaledBitmap(Djh, measuredWidth, measuredHeight, true);
            }
        }
        Bitmap bitmap2 = Djh;
        AppMethodBeat.o(28355);
        return bitmap2;
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, final Bitmap bitmap) {
        AppMethodBeat.i(28356);
        Log.i("MicroMsg.ShakeAvatarDrawable", "type[%d] notifyKey[%s] albumUrl[%s]", Integer.valueOf(this.type), str, this.Djf);
        if (this.Djg != null && str.equals(this.Djg.blC()) && (4 == this.type || (k.XA(this.type) && 6 != this.type))) {
            this.tkI.post(new Runnable() {
                /* class com.tencent.mm.plugin.shake.d.b.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(28350);
                    a.this.tkI.setImageBitmap(bitmap);
                    AppMethodBeat.o(28350);
                }
            });
        }
        AppMethodBeat.o(28356);
    }

    public static String aKj(String str) {
        AppMethodBeat.i(28357);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath: but url is null");
            AppMethodBeat.o(28357);
            return null;
        }
        String eUQ = i.eUQ();
        if (Util.isNullOrNil(eUQ)) {
            Log.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath, but save dir is null");
            AppMethodBeat.o(28357);
            return null;
        }
        String format = String.format("%s/%s", eUQ, g.getMessageDigest(str.getBytes()));
        AppMethodBeat.o(28357);
        return format;
    }

    /* renamed from: com.tencent.mm.plugin.shake.d.b.a$a  reason: collision with other inner class name */
    static class C1692a implements s {
        private String Djf;

        public C1692a(String str) {
            this.Djf = str;
        }

        @Override // com.tencent.mm.platformtools.s
        public final String blA() {
            AppMethodBeat.i(28351);
            String aKj = a.aKj(this.Djf);
            AppMethodBeat.o(28351);
            return aKj;
        }

        @Override // com.tencent.mm.platformtools.s
        public final String blB() {
            return this.Djf;
        }

        @Override // com.tencent.mm.platformtools.s
        public final String blC() {
            return this.Djf;
        }

        @Override // com.tencent.mm.platformtools.s
        public final String getCacheKey() {
            return this.Djf;
        }

        @Override // com.tencent.mm.platformtools.s
        public final boolean blD() {
            return true;
        }

        @Override // com.tencent.mm.platformtools.s
        public final boolean blE() {
            return false;
        }

        @Override // com.tencent.mm.platformtools.s
        public final Bitmap blF() {
            AppMethodBeat.i(28352);
            Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjn);
            AppMethodBeat.o(28352);
            return decodeResource;
        }

        @Override // com.tencent.mm.platformtools.s
        public final Bitmap a(Bitmap bitmap, s.a aVar, String str) {
            AppMethodBeat.i(28353);
            if (s.a.NET == aVar) {
                try {
                    BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, a.aKj(this.Djf), false);
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", e2, "", new Object[0]);
                    Log.w("MicroMsg.ShakeAvatarDrawable", "save bitmap fail");
                }
            }
            Log.d("MicroMsg.ShakeAvatarDrawable", "get bitmap, from %s", aVar.toString());
            AppMethodBeat.o(28353);
            return bitmap;
        }

        @Override // com.tencent.mm.platformtools.s
        public final void blG() {
        }

        @Override // com.tencent.mm.platformtools.s
        public final void ad(String str, boolean z) {
        }

        @Override // com.tencent.mm.platformtools.s
        public final void a(s.a aVar, String str) {
        }

        @Override // com.tencent.mm.platformtools.s
        public final s.b blz() {
            return null;
        }
    }
}
