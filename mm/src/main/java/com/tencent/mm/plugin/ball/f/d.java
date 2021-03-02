package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.support.v7.d.b;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ball.f.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class d {
    private static Map<String, Integer> oYD;
    private static Boolean oYE = null;
    private static Integer oYF = null;

    public interface a {
        void BN(int i2);
    }

    public static boolean h(Collection collection) {
        AppMethodBeat.i(106338);
        if (collection == null || collection.isEmpty()) {
            AppMethodBeat.o(106338);
            return false;
        }
        AppMethodBeat.o(106338);
        return true;
    }

    private static boolean i(Collection collection) {
        AppMethodBeat.i(106339);
        if (!h(collection) || collection.size() != 1) {
            AppMethodBeat.o(106339);
            return false;
        }
        AppMethodBeat.o(106339);
        return true;
    }

    public static List<BallInfo> cd(List<BallInfo> list) {
        AppMethodBeat.i(106340);
        if (h(list)) {
            Collections.sort(list, new Comparator<BallInfo>() {
                /* class com.tencent.mm.plugin.ball.f.d.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(BallInfo ballInfo, BallInfo ballInfo2) {
                    BallInfo ballInfo3 = ballInfo;
                    BallInfo ballInfo4 = ballInfo2;
                    if (ballInfo3.oWr && !ballInfo4.oWr) {
                        return 1;
                    }
                    if (!ballInfo3.oWr && ballInfo4.oWr) {
                        return -1;
                    }
                    if (ballInfo3.createTime > ballInfo4.createTime) {
                        return -1;
                    }
                    if (ballInfo3.createTime >= ballInfo4.createTime) {
                        return 0;
                    }
                    return 1;
                }
            });
            AppMethodBeat.o(106340);
            return list;
        }
        Vector vector = new Vector();
        AppMethodBeat.o(106340);
        return vector;
    }

    public static List<BallInfo> ce(List<BallInfo> list) {
        AppMethodBeat.i(106341);
        if (h(list)) {
            Collections.sort(list, new Comparator<BallInfo>() {
                /* class com.tencent.mm.plugin.ball.f.d.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(BallInfo ballInfo, BallInfo ballInfo2) {
                    BallInfo ballInfo3 = ballInfo;
                    BallInfo ballInfo4 = ballInfo2;
                    if (ballInfo3.createTime > ballInfo4.createTime) {
                        return -1;
                    }
                    if (ballInfo3.createTime < ballInfo4.createTime) {
                        return 1;
                    }
                    return 0;
                }
            });
            AppMethodBeat.o(106341);
            return list;
        }
        Vector vector = new Vector();
        AppMethodBeat.o(106341);
        return vector;
    }

    public static boolean cf(List<BallInfo> list) {
        AppMethodBeat.i(106342);
        if (h(list)) {
            for (BallInfo ballInfo : list) {
                if (!ballInfo.oWr) {
                    AppMethodBeat.o(106342);
                    return true;
                }
            }
        }
        AppMethodBeat.o(106342);
        return false;
    }

    public static List<BallInfo> cg(List<BallInfo> list) {
        AppMethodBeat.i(106343);
        if (h(list)) {
            Vector vector = new Vector();
            for (BallInfo ballInfo : list) {
                if (!ballInfo.oWr) {
                    vector.add(ballInfo);
                }
            }
            AppMethodBeat.o(106343);
            return vector;
        }
        Vector vector2 = new Vector();
        AppMethodBeat.o(106343);
        return vector2;
    }

    public static List<BallInfo> ch(List<BallInfo> list) {
        AppMethodBeat.i(106344);
        if (h(list)) {
            Vector vector = new Vector();
            for (BallInfo ballInfo : list) {
                if (ballInfo.oWr) {
                    vector.add(ballInfo);
                }
            }
            AppMethodBeat.o(106344);
            return vector;
        }
        Vector vector2 = new Vector();
        AppMethodBeat.o(106344);
        return vector2;
    }

    public static List<BallInfo> ci(List<BallInfo> list) {
        AppMethodBeat.i(106345);
        if (h(list)) {
            Vector vector = new Vector();
            for (BallInfo ballInfo : list) {
                if (!ballInfo.nno) {
                    vector.add(ballInfo);
                }
            }
            AppMethodBeat.o(106345);
            return vector;
        }
        Vector vector2 = new Vector();
        AppMethodBeat.o(106345);
        return vector2;
    }

    public static List<BallInfo> cj(List<BallInfo> list) {
        AppMethodBeat.i(217063);
        if (h(list)) {
            Vector vector = new Vector();
            for (BallInfo ballInfo : list) {
                if (!H(ballInfo)) {
                    vector.add(ballInfo);
                }
            }
            AppMethodBeat.o(217063);
            return vector;
        }
        Vector vector2 = new Vector();
        AppMethodBeat.o(217063);
        return vector2;
    }

    public static BallInfo ck(List<BallInfo> list) {
        AppMethodBeat.i(217064);
        if (h(list)) {
            for (BallInfo ballInfo : list) {
                if (H(ballInfo)) {
                    AppMethodBeat.o(217064);
                    return ballInfo;
                }
            }
        }
        AppMethodBeat.o(217064);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.plugin.ball.model.BallInfo cl(java.util.List<com.tencent.mm.plugin.ball.model.BallInfo> r5) {
        /*
            r4 = 217065(0x34fe9, float:3.04173E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            boolean r0 = h(r5)
            if (r0 == 0) goto L_0x002c
            java.util.Iterator r1 = r5.iterator()
        L_0x0010:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x002c
            java.lang.Object r0 = r1.next()
            com.tencent.mm.plugin.ball.model.BallInfo r0 = (com.tencent.mm.plugin.ball.model.BallInfo) r0
            int r2 = r0.type
            r3 = 17
            if (r2 == r3) goto L_0x0028
            int r2 = r0.type
            r3 = 19
            if (r2 != r3) goto L_0x0010
        L_0x0028:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x002b:
            return r0
        L_0x002c:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ball.f.d.cl(java.util.List):com.tencent.mm.plugin.ball.model.BallInfo");
    }

    public static List<BallInfo> cm(List<BallInfo> list) {
        AppMethodBeat.i(106346);
        List<BallInfo> cg = cg(ci(list));
        AppMethodBeat.o(106346);
        return cg;
    }

    public static List<BallInfo> d(List<BallInfo> list, BallInfo ballInfo) {
        AppMethodBeat.i(106347);
        if (f(list, ballInfo)) {
            Log.i("MicroMsg.FloatBallUtil", "filterBallInfoListForFloatMenu, single ball info true");
            Vector vector = new Vector();
            AppMethodBeat.o(106347);
            return vector;
        } else if (h(list)) {
            Vector vector2 = new Vector();
            for (BallInfo ballInfo2 : list) {
                if (!ballInfo2.nno) {
                    vector2.add(ballInfo2);
                }
            }
            AppMethodBeat.o(106347);
            return vector2;
        } else {
            Vector vector3 = new Vector();
            AppMethodBeat.o(106347);
            return vector3;
        }
    }

    public static boolean H(BallInfo ballInfo) {
        return ballInfo != null && (ballInfo.type == 9 || ballInfo.type == 21 || ballInfo.type == 23 || ballInfo.type == 24);
    }

    public static boolean I(BallInfo ballInfo) {
        return ballInfo != null && (ballInfo.type == 17 || ballInfo.type == 19);
    }

    public static boolean cn(List<BallInfo> list) {
        AppMethodBeat.i(217066);
        if (h(list)) {
            for (BallInfo ballInfo : list) {
                if (H(ballInfo)) {
                    AppMethodBeat.o(217066);
                    return true;
                }
            }
        }
        AppMethodBeat.o(217066);
        return false;
    }

    public static boolean e(List<BallInfo> list, BallInfo ballInfo) {
        AppMethodBeat.i(106348);
        if (h(list)) {
            for (BallInfo ballInfo2 : list) {
                if (!ballInfo2.equals(ballInfo)) {
                    AppMethodBeat.o(106348);
                    return true;
                }
            }
        }
        AppMethodBeat.o(106348);
        return false;
    }

    public static boolean f(List<BallInfo> list, BallInfo ballInfo) {
        AppMethodBeat.i(106349);
        if (!i(list) || !list.contains(ballInfo)) {
            AppMethodBeat.o(106349);
            return false;
        }
        AppMethodBeat.o(106349);
        return true;
    }

    public static int eV(int i2, int i3) {
        return i2 | i3;
    }

    public static int eW(int i2, int i3) {
        return (i3 ^ -1) & i2;
    }

    private static boolean eX(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public static int BK(int i2) {
        int i3 = 0;
        while (i2 != 0) {
            i3++;
            i2 &= i2 - 1;
        }
        return i3;
    }

    public static int cjg() {
        AppMethodBeat.i(106352);
        e.ciJ();
        int ciK = e.ciK();
        AppMethodBeat.o(106352);
        return ciK;
    }

    public static int cjh() {
        AppMethodBeat.i(106353);
        e.ciJ();
        int ciL = e.ciL();
        AppMethodBeat.o(106353);
        return ciL;
    }

    public static e.a T(int i2, int i3, int i4) {
        AppMethodBeat.i(106354);
        Context context = MMApplicationContext.getContext();
        Point point = new Point(com.tencent.mm.cb.a.jn(context), com.tencent.mm.cb.a.jo(context));
        int i5 = point.x / 2;
        int i6 = point.y / 2;
        int i7 = (i4 / 2) + i3;
        if (i2 <= i5 && i7 <= i6) {
            e.a aVar = e.a.TOP_LEFT;
            AppMethodBeat.o(106354);
            return aVar;
        } else if (i2 <= i5) {
            e.a aVar2 = e.a.BOTTOM_LEFT;
            AppMethodBeat.o(106354);
            return aVar2;
        } else if (i7 <= i6) {
            e.a aVar3 = e.a.TOP_RIGHT;
            AppMethodBeat.o(106354);
            return aVar3;
        } else {
            e.a aVar4 = e.a.BOTTOM_RIGHT;
            AppMethodBeat.o(106354);
            return aVar4;
        }
    }

    public static boolean q(View view, int i2, int i3) {
        AppMethodBeat.i(106355);
        if (view == null) {
            AppMethodBeat.o(106355);
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i4 = iArr[0];
        int i5 = iArr[1];
        boolean contains = new Rect(i4, i5, view.getWidth() + i4, view.getHeight() + i5).contains(i2, i3);
        AppMethodBeat.o(106355);
        return contains;
    }

    public static int BL(int i2) {
        switch (i2) {
            case 1:
                return R.raw.float_ball_icon_appbrand_default;
            case 2:
            case 5:
            case 7:
            default:
                return R.raw.float_ball_icon_webpage_default;
            case 3:
                return R.raw.float_ball_icon_fav_default;
            case 4:
                return R.raw.float_ball_icon_files_default;
            case 6:
                return R.raw.float_ball_icon_music_default;
            case 8:
                return R.raw.float_ball_icon_topstory_default;
        }
    }

    public static int BM(int i2) {
        AppMethodBeat.i(106356);
        if (eX(i2, 1)) {
            AppMethodBeat.o(106356);
            return R.raw.float_ball_state_location;
        } else if (eX(i2, 2) || eX(i2, 128)) {
            AppMethodBeat.o(106356);
            return R.raw.float_ball_state_music;
        } else if (eX(i2, 16)) {
            AppMethodBeat.o(106356);
            return R.raw.float_ball_state_game_download_stable;
        } else if (eX(i2, 32)) {
            AppMethodBeat.o(106356);
            return R.raw.float_ball_state_mike_on;
        } else if (eX(i2, 64)) {
            AppMethodBeat.o(106356);
            return R.raw.float_ball_state_mike_off;
        } else if (eX(i2, 256)) {
            AppMethodBeat.o(106356);
            return R.raw.float_ball_state_message;
        } else {
            AppMethodBeat.o(106356);
            return -1;
        }
    }

    public static int co(List<BallInfo> list) {
        AppMethodBeat.i(106357);
        int i2 = 0;
        for (BallInfo ballInfo : list) {
            i2 = ballInfo.state | i2;
        }
        AppMethodBeat.o(106357);
        return i2;
    }

    public static ResultReceiver b(ResultReceiver resultReceiver) {
        AppMethodBeat.i(106358);
        Parcel obtain = Parcel.obtain();
        resultReceiver.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        AppMethodBeat.o(106358);
        return resultReceiver2;
    }

    public static Integer agX(String str) {
        AppMethodBeat.i(106359);
        Integer num = oYD.get(str);
        AppMethodBeat.o(106359);
        return num;
    }

    static {
        AppMethodBeat.i(106363);
        HashMap hashMap = new HashMap();
        oYD = hashMap;
        hashMap.put("doc", Integer.valueOf((int) R.raw.file_float_ball_icon_word));
        oYD.put("docx", Integer.valueOf((int) R.raw.file_float_ball_icon_word));
        oYD.put("ppt", Integer.valueOf((int) R.raw.file_float_ball_icon_ppt));
        oYD.put("pptx", Integer.valueOf((int) R.raw.file_float_ball_icon_ppt));
        oYD.put("xls", Integer.valueOf((int) R.raw.file_float_ball_icon_excel));
        oYD.put("xlsx", Integer.valueOf((int) R.raw.file_float_ball_icon_excel));
        oYD.put("pdf", Integer.valueOf((int) R.raw.file_float_ball_icon_pdf));
        oYD.put("numbers", Integer.valueOf((int) R.raw.file_float_ball_icon_numbers));
        oYD.put("pages", Integer.valueOf((int) R.raw.file_float_ball_icon_pages));
        oYD.put("key", Integer.valueOf((int) R.raw.file_float_ball_icon_key));
        oYD.put("txt", Integer.valueOf((int) R.raw.file_float_ball_icon_txt));
        oYD.put("unknown", Integer.valueOf((int) R.raw.file_float_ball_icon_default));
        AppMethodBeat.o(106363);
    }

    public static void a(Bitmap bitmap, final a aVar) {
        AppMethodBeat.i(106360);
        if (bitmap == null || bitmap.isRecycled()) {
            Log.i("MicroMsg.FloatBallUtil", "getPrimaryColor, bitmap is null");
            aVar.BN(0);
            AppMethodBeat.o(106360);
            return;
        }
        b.d(bitmap).a(new b.c() {
            /* class com.tencent.mm.plugin.ball.f.d.AnonymousClass3 */
            final /* synthetic */ int oYH = 0;

            @Override // android.support.v7.d.b.c
            public final void a(b bVar) {
                AppMethodBeat.i(106337);
                if (bVar != null) {
                    b.d dVar = bVar.abt;
                    if (dVar != null) {
                        aVar.BN(dVar.abF);
                        AppMethodBeat.o(106337);
                        return;
                    }
                    Log.i("MicroMsg.FloatBallUtil", "getPrimaryColor, palette generated but swatch is null");
                    aVar.BN(this.oYH);
                    AppMethodBeat.o(106337);
                    return;
                }
                Log.i("MicroMsg.FloatBallUtil", "getPrimaryColor, palette generated fail");
                aVar.BN(this.oYH);
                AppMethodBeat.o(106337);
            }
        });
        AppMethodBeat.o(106360);
    }

    public static boolean eF(Context context) {
        AppMethodBeat.i(106361);
        if (oYE == null) {
            oYE = Boolean.valueOf(ao.aQ(context));
        }
        boolean booleanValue = oYE.booleanValue();
        AppMethodBeat.o(106361);
        return booleanValue;
    }

    public static int aP(Context context) {
        AppMethodBeat.i(106362);
        if (!eF(context)) {
            AppMethodBeat.o(106362);
            return 0;
        }
        if (oYF == null) {
            oYF = Integer.valueOf(ao.aP(context));
        }
        int intValue = oYF.intValue();
        AppMethodBeat.o(106362);
        return intValue;
    }

    public static boolean a(BallInfo ballInfo, long j2) {
        AppMethodBeat.i(258548);
        boolean aG = aG(ballInfo.crj, j2);
        AppMethodBeat.o(258548);
        return aG;
    }

    public static boolean aG(long j2, long j3) {
        return (j2 == 0 || j3 == 0 || j3 - j2 > 1000) ? false : true;
    }
}
