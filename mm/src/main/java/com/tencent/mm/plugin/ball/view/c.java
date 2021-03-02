package com.tencent.mm.plugin.ball.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.h;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.ball.c.d;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.view.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c implements d {
    private static final int oZA = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.a6b);
    private static final int oZB = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.a5y);
    private static final int oZC = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.a6o);
    private static final int oZD = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.a62);
    private static final int oZE = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.a60);
    private static final int oZF = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.a6a);
    private static final int oZG = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.a5x);
    private static final int oZH = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.a6n);
    private static final int oZI = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.a61);
    private static final int oZJ = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.a5z);
    private final Context mContext;
    public final b oZK;
    private final C0854c oZL;
    private String oZM;
    private final Map<String, Integer> oZN;
    private final b oZO = new b() {
        /* class com.tencent.mm.plugin.ball.view.c.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.ball.view.c.b
        public final void a(Bitmap bitmap, a aVar) {
            AppMethodBeat.i(106406);
            if (!aVar.oZR.equals(c.this.oZM)) {
                Log.i("MicroMsg.FloatBallCrescentViewHelper", "OnBitmapLoad, listKey not same");
                AppMethodBeat.o(106406);
                return;
            }
            int i2 = aVar.index;
            Log.i("MicroMsg.FloatBallCrescentViewHelper", "OnBitmapLoad, index:%d, bitmap:%s", Integer.valueOf(i2), bitmap);
            b bVar = c.this.oZK;
            if (!bVar.mInited && i2 >= 0 && i2 < bVar.oZk.size()) {
                Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, before init, oldBitmap:%s, newBitmap:%s", bVar.oZk.get(i2).bitmap, bitmap);
                bVar.oZk.get(i2).bitmap = bitmap;
            } else if (i2 < 0 || i2 >= bVar.oZd.size()) {
                Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, invalid range, index:%s, size:%s", Integer.valueOf(i2), Integer.valueOf(bVar.oZd.size()));
            } else {
                Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, after init, oldBitmap:%s, newBitmap:%s", bVar.oZd.get(i2).cjn().bitmap, bitmap);
                bVar.oZd.get(i2).cjn().bitmap = bitmap;
                if (!bVar.nmN) {
                    Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, not animating");
                    bVar.postInvalidate();
                } else {
                    Log.i("MicroMsg.FloatBallCrescentView", "updateIconInfoBitmap, is animating");
                }
            }
            c.a(c.this, bitmap, i2, c.this.oZM);
            AppMethodBeat.o(106406);
        }
    };

    /* access modifiers changed from: package-private */
    public interface b {
        void a(Bitmap bitmap, a aVar);
    }

    static /* synthetic */ void a(c cVar, Bitmap bitmap, int i2, String str) {
        AppMethodBeat.i(106427);
        cVar.a(bitmap, i2, str);
        AppMethodBeat.o(106427);
    }

    static /* synthetic */ int cjo() {
        AppMethodBeat.i(106428);
        int BO = BO(1);
        AppMethodBeat.o(106428);
        return BO;
    }

    static {
        AppMethodBeat.i(106429);
        AppMethodBeat.o(106429);
    }

    public c(Context context) {
        AppMethodBeat.i(106422);
        this.oZK = new b(context);
        this.mContext = context;
        this.oZL = new C0854c(this.mContext);
        this.oZN = new HashMap();
        AppMethodBeat.o(106422);
    }

    @Override // com.tencent.mm.plugin.ball.c.d
    public final void a(List<BallInfo> list, BallInfo ballInfo) {
        AppMethodBeat.i(106423);
        List<BallInfo> cm = com.tencent.mm.plugin.ball.f.d.cm(list);
        String cq = cq(cm);
        if (cq.equals(this.oZM)) {
            Log.i("MicroMsg.FloatBallCrescentViewHelper", "onFloatBallInfoChanged, list key not change");
            AppMethodBeat.o(106423);
            return;
        }
        this.oZM = cq;
        int size = cm.size();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            b.d dVar = new b.d();
            this.oZL.a(cm.get(i2), dVar, i2, this.oZM, this.oZO);
            if (dVar.isValid()) {
                arrayList.add(dVar);
                if (dVar.bitmap != null) {
                    a(dVar.bitmap, i2, this.oZM);
                }
            }
        }
        this.oZK.a(arrayList, BO(size), BP(size), cp(cm));
        AppMethodBeat.o(106423);
    }

    private static int BO(int i2) {
        if (i2 == 1) {
            return oZA;
        }
        if (i2 == 2) {
            return oZB;
        }
        if (i2 == 3) {
            return oZC;
        }
        if (i2 == 4) {
            return oZD;
        }
        return oZE;
    }

    private static int BP(int i2) {
        if (i2 == 1) {
            return oZF;
        }
        if (i2 == 2) {
            return oZG;
        }
        if (i2 == 3) {
            return oZH;
        }
        if (i2 == 4) {
            return oZI;
        }
        return oZJ;
    }

    private int cp(List<BallInfo> list) {
        int i2;
        AppMethodBeat.i(106424);
        int i3 = Integer.MIN_VALUE;
        HashMap hashMap = new HashMap();
        for (int i4 = 0; i4 < list.size(); i4++) {
            hashMap.put(list.get(i4).key + "_" + list.get(i4).type, Integer.valueOf(i4));
        }
        int size = list.size() - this.oZN.size();
        if (this.oZN.size() != 0) {
            if (size == -1) {
                Iterator<Map.Entry<String, Integer>> it = this.oZN.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i2 = Integer.MIN_VALUE;
                        break;
                    }
                    Map.Entry<String, Integer> next = it.next();
                    if (!hashMap.containsKey(next.getKey())) {
                        i2 = next.getValue().intValue();
                        break;
                    }
                }
                i3 = i2;
            } else if (size == 1) {
                for (int i5 = 0; i5 < list.size(); i5++) {
                    if (!this.oZN.containsKey(list.get(i5).key + "_" + list.get(i5).type)) {
                        i3 = i5;
                    }
                }
            }
        }
        this.oZN.clear();
        this.oZN.putAll(hashMap);
        AppMethodBeat.o(106424);
        return i3;
    }

    private static String cq(List<BallInfo> list) {
        AppMethodBeat.i(106425);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            BallInfo ballInfo = list.get(i2);
            sb.append(ballInfo.key).append(ballInfo.type).append(ballInfo.icon).append(ballInfo.noe).append("|");
        }
        String mD5String = MD5Util.getMD5String(sb.toString());
        AppMethodBeat.o(106425);
        return mD5String;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.ball.view.c$c  reason: collision with other inner class name */
    public static final class C0854c {
        final Context mContext;
        final h<String, Bitmap> oZS = new h<>(24);
        final Map<Integer, Integer> oZT = new HashMap();
        final com.tencent.mm.svg.a.a oZU = new com.tencent.mm.svg.a.a();

        C0854c(Context context) {
            AppMethodBeat.i(106414);
            this.mContext = context;
            AppMethodBeat.o(106414);
        }

        public final void a(BallInfo ballInfo, b.d dVar, int i2, String str, b bVar) {
            AppMethodBeat.i(106415);
            if (a(J(ballInfo), dVar)) {
                Log.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadResource");
                AppMethodBeat.o(106415);
            } else if (b(ballInfo, dVar, i2, str, bVar)) {
                Log.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadIconUrl");
                AppMethodBeat.o(106415);
            } else {
                Log.i("MicroMsg.FloatBallCrescentViewHelper", "load, loadDefault");
                a(ballInfo, dVar);
                AppMethodBeat.o(106415);
            }
        }

        private boolean a(int i2, b.d dVar) {
            AppMethodBeat.i(106417);
            if (i2 == -1) {
                AppMethodBeat.o(106417);
                return false;
            }
            try {
                dVar.bitmap = BQ(i2);
                AppMethodBeat.o(106417);
                return true;
            } catch (Exception e2) {
                Log.w("MicroMsg.FloatBallCrescentViewHelper", "loadResource exp:%s", e2.getCause());
                AppMethodBeat.o(106417);
                return false;
            }
        }

        private boolean b(BallInfo ballInfo, b.d dVar, int i2, String str, b bVar) {
            AppMethodBeat.i(106418);
            String str2 = ballInfo.icon;
            if (Util.isNullOrNil(str2)) {
                AppMethodBeat.o(106418);
                return false;
            }
            Bitmap bitmap = (Bitmap) this.oZS.get(MD5Util.getMD5String(str2));
            if (bitmap == null || bitmap.isRecycled()) {
                a aVar = new a((byte) 0);
                aVar.url = str2;
                aVar.index = i2;
                aVar.oZR = str;
                a(aVar, bVar);
                AppMethodBeat.o(106418);
                return false;
            }
            dVar.bitmap = bitmap;
            Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadIconUrl, from cache");
            AppMethodBeat.o(106418);
            return true;
        }

        private boolean a(BallInfo ballInfo, b.d dVar) {
            int i2;
            AppMethodBeat.i(106419);
            if (ballInfo.oWr) {
                Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadDefault, passive icon res");
                i2 = com.tencent.mm.plugin.ball.f.d.BM(ballInfo.state);
            } else {
                i2 = -1;
            }
            if (i2 == -1) {
                Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadDefault, default icon res");
                i2 = com.tencent.mm.plugin.ball.f.d.BL(ballInfo.type);
            }
            dVar.bitmap = BQ(i2);
            AppMethodBeat.o(106419);
            return true;
        }

        private Bitmap BQ(int i2) {
            AppMethodBeat.i(106420);
            String mD5String = MD5Util.getMD5String(String.valueOf(i2));
            Bitmap bitmap = (Bitmap) this.oZS.get(mD5String);
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.oZU.j(this.mContext.getResources(), i2)) {
                    Log.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap svg, resId:%s", Integer.valueOf(i2));
                    Bitmap i3 = com.tencent.mm.svg.a.a.i(this.mContext.getResources(), i2);
                    if (i3 != null && !i3.isRecycled()) {
                        int width = i3.getWidth();
                        bitmap = com.tencent.mm.svg.a.a.b(this.mContext.getResources(), i2, (float) ((((double) c.oZA) * 1.0d) / ((double) width)));
                        i3.recycle();
                    }
                } else {
                    Log.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap normal, resId:%s", Integer.valueOf(i2));
                    bitmap = BitmapFactory.decodeResource(this.mContext.getResources(), i2);
                }
                this.oZS.put(mD5String, bitmap);
                AppMethodBeat.o(106420);
            } else {
                Log.i("MicroMsg.FloatBallCrescentViewHelper", "getResourceBitmap, from cache");
                AppMethodBeat.o(106420);
            }
            return bitmap;
        }

        private void a(final a aVar, final b bVar) {
            AppMethodBeat.i(106421);
            final String str = aVar.url;
            final int i2 = aVar.index;
            com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k() {
                /* class com.tencent.mm.plugin.ball.view.c.C0854c.AnonymousClass1 */

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void aYg() {
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void I(final Bitmap bitmap) {
                    AppMethodBeat.i(106409);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.ball.view.c.C0854c.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(106408);
                            Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadBitmapFromUrl, onBitmapLoaded, url:%s", str);
                            C0854c.this.oZS.put(MD5Util.getMD5String(str), bitmap);
                            bVar.a(bitmap, aVar);
                            AppMethodBeat.o(106408);
                        }
                    });
                    AppMethodBeat.o(106409);
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void oD() {
                    AppMethodBeat.i(106410);
                    AppMethodBeat.o(106410);
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                public final String Lb() {
                    AppMethodBeat.i(106411);
                    String mD5String = MD5Util.getMD5String(String.format("%s#%d", str, Integer.valueOf(i2)));
                    AppMethodBeat.o(106411);
                    return mD5String;
                }
            }, str, new b.h() {
                /* class com.tencent.mm.plugin.ball.view.c.C0854c.AnonymousClass2 */

                @Override // com.tencent.mm.modelappbrand.a.b.h
                public final Bitmap J(Bitmap bitmap) {
                    AppMethodBeat.i(106412);
                    int cjo = c.cjo();
                    float width = ((float) cjo) / ((float) bitmap.getWidth());
                    float height = ((float) cjo) / ((float) bitmap.getHeight());
                    Log.i("MicroMsg.FloatBallCrescentViewHelper", "loadBitmapFromUrl, transform targetSize:%d scaled:%f", Integer.valueOf(cjo), Float.valueOf(height));
                    Matrix matrix = new Matrix();
                    matrix.postScale(width, height);
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    bitmap.recycle();
                    AppMethodBeat.o(106412);
                    return createBitmap;
                }

                @Override // com.tencent.mm.modelappbrand.a.c
                public final String Lb() {
                    AppMethodBeat.i(106413);
                    String mD5String = MD5Util.getMD5String(String.format("%s#%d", str, Integer.valueOf(i2)));
                    AppMethodBeat.o(106413);
                    return mD5String;
                }
            });
            AppMethodBeat.o(106421);
        }

        private static int J(BallInfo ballInfo) {
            int i2;
            AppMethodBeat.i(176976);
            if (ballInfo.oWr) {
                i2 = com.tencent.mm.plugin.ball.f.d.BM(ballInfo.state);
            } else {
                i2 = -1;
            }
            if (i2 == -1) {
                i2 = ballInfo.noe;
            }
            AppMethodBeat.o(176976);
            return i2;
        }
    }

    private void a(Bitmap bitmap, final int i2, final String str) {
        AppMethodBeat.i(106426);
        com.tencent.mm.plugin.ball.f.d.a(bitmap, new d.a() {
            /* class com.tencent.mm.plugin.ball.view.c.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.ball.f.d.a
            public final void BN(int i2) {
                AppMethodBeat.i(106407);
                if (!str.equals(c.this.oZM)) {
                    Log.i("MicroMsg.FloatBallCrescentViewHelper", "pickColor listKey not same");
                    AppMethodBeat.o(106407);
                    return;
                }
                b bVar = c.this.oZK;
                int i3 = i2;
                if (i3 < 0 || i3 >= bVar.oZd.size()) {
                    AppMethodBeat.o(106407);
                    return;
                }
                bVar.oZd.get(i3).cjn().oZx = i2;
                if (!bVar.nmN) {
                    bVar.postInvalidate();
                }
                AppMethodBeat.o(106407);
            }
        });
        AppMethodBeat.o(106426);
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        int index;
        String oZR;
        String url;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
