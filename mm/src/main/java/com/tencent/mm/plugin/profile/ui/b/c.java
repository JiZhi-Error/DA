package com.tencent.mm.plugin.profile.ui.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.io.IOException;

public final class c extends BitmapDrawable implements u.a {
    private String url;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(android.content.res.Resources r8, java.lang.String r9) {
        /*
            r7 = this;
            r6 = 27608(0x6bd8, float:3.8687E-41)
            r1 = 1
            r2 = 0
            com.tencent.mm.model.ay$c r0 = com.tencent.mm.model.ay.a.iDs
            if (r0 == 0) goto L_0x0038
            com.tencent.mm.model.ay$c r0 = com.tencent.mm.model.ay.a.iDs
            r3 = 16
            java.lang.String r0 = r0.rV(r3)
            r3 = 1073741824(0x40000000, float:2.0)
            android.graphics.Bitmap r0 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory.decodeFile(r0, r3)
        L_0x0016:
            java.lang.String r3 = "MicroMsg.UrlDrawable"
            java.lang.String r4 = "verify bmp is null ? %B"
            java.lang.Object[] r5 = new java.lang.Object[r1]
            if (r0 != 0) goto L_0x003a
        L_0x0020:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r5[r2] = r1
            com.tencent.mm.sdk.platformtools.Log.i(r3, r4, r5)
            r7.<init>(r8, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            r7.url = r9
            com.tencent.mm.platformtools.u.a(r7)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x0038:
            r0 = 0
            goto L_0x0016
        L_0x003a:
            r1 = r2
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.b.c.<init>(android.content.res.Resources, java.lang.String):void");
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(27609);
        Bitmap a2 = u.a(new s() {
            /* class com.tencent.mm.plugin.profile.ui.b.c.AnonymousClass1 */

            @Override // com.tencent.mm.platformtools.s
            public final boolean blE() {
                return false;
            }

            @Override // com.tencent.mm.platformtools.s
            public final boolean blD() {
                return false;
            }

            @Override // com.tencent.mm.platformtools.s
            public final Bitmap a(Bitmap bitmap, s.a aVar, String str) {
                AppMethodBeat.i(27603);
                if (s.a.NET == aVar) {
                    try {
                        BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.UrlDrawable", e2, "", new Object[0]);
                        Log.w("MicroMsg.UrlDrawable", "save bitmap fail");
                    }
                }
                Log.d("MicroMsg.UrlDrawable", "get bitmap, from %s", aVar.toString());
                AppMethodBeat.o(27603);
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

            @Override // com.tencent.mm.platformtools.s
            public final String blA() {
                AppMethodBeat.i(27604);
                StringBuilder sb = new StringBuilder();
                bg.aVF();
                String sb2 = sb.append(com.tencent.mm.model.c.aTh()).append(MD5Util.getMD5String(c.this.url)).toString();
                AppMethodBeat.o(27604);
                return sb2;
            }

            @Override // com.tencent.mm.platformtools.s
            public final String blC() {
                AppMethodBeat.i(27605);
                String str = c.this.url;
                AppMethodBeat.o(27605);
                return str;
            }

            @Override // com.tencent.mm.platformtools.s
            public final Bitmap blF() {
                return null;
            }

            @Override // com.tencent.mm.platformtools.s
            public final String blB() {
                AppMethodBeat.i(27606);
                String str = c.this.url;
                AppMethodBeat.o(27606);
                return str;
            }

            @Override // com.tencent.mm.platformtools.s
            public final String getCacheKey() {
                AppMethodBeat.i(27607);
                String str = c.this.url;
                AppMethodBeat.o(27607);
                return str;
            }
        });
        if (a2 == null || a2.isRecycled()) {
            a2 = null;
        }
        Rect bounds = getBounds();
        if (a2 != null) {
            canvas.drawBitmap(a2, (Rect) null, bounds, (Paint) null);
        }
        AppMethodBeat.o(27609);
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, Bitmap bitmap) {
        AppMethodBeat.i(27610);
        if (this.url.equals(str)) {
            invalidateSelf();
        }
        AppMethodBeat.o(27610);
    }
}
