package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.card.compat.a.a;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.dxy;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class l {
    private static SimpleDateFormat qkZ = null;
    private static SimpleDateFormat qla = null;
    private static SimpleDateFormat qlb = null;

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        AppMethodBeat.i(113811);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected() || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
            AppMethodBeat.o(113811);
            return false;
        }
        AppMethodBeat.o(113811);
        return true;
    }

    public static int ake(String str) {
        AppMethodBeat.i(113812);
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            Log.e("MicroMsg.CardUtil", "string format error");
            AppMethodBeat.o(113812);
        } else {
            try {
                String upperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(255, Integer.parseInt(upperCase.substring(0, 2), 16), Integer.parseInt(upperCase.substring(2, 4), 16), Integer.parseInt(upperCase.substring(4, 6), 16));
                AppMethodBeat.o(113812);
            } catch (Exception e2) {
                Log.e("MicroMsg.CardUtil", e2.toString());
                AppMethodBeat.o(113812);
            }
        }
        return rgb;
    }

    public static int convertStringToRGB(String str, int i2) {
        AppMethodBeat.i(113813);
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            Log.e("MicroMsg.CardUtil", "string format error");
            AppMethodBeat.o(113813);
        } else {
            try {
                String upperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(i2, Integer.parseInt(upperCase.substring(0, 2), 16), Integer.parseInt(upperCase.substring(2, 4), 16), Integer.parseInt(upperCase.substring(4, 6), 16));
                AppMethodBeat.o(113813);
            } catch (Exception e2) {
                Log.e("MicroMsg.CardUtil", e2.toString());
                AppMethodBeat.o(113813);
            }
        }
        return rgb;
    }

    public static ShapeDrawable U(Context context, int i2) {
        AppMethodBeat.i(113814);
        ShapeDrawable fi = fi(i2, context.getResources().getDimensionPixelOffset(R.dimen.uw));
        AppMethodBeat.o(113814);
        return fi;
    }

    public static ShapeDrawable fi(int i2, int i3) {
        AppMethodBeat.i(113815);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i3, (float) i3, (float) i3, (float) i3, (float) i3, (float) i3, (float) i3, (float) i3}, null, null));
        shapeDrawable.getPaint().setColor(i2);
        AppMethodBeat.o(113815);
        return shapeDrawable;
    }

    public static ShapeDrawable e(Context context, int i2, int i3) {
        AppMethodBeat.i(113816);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.iu);
        float[] fArr = {(float) i3, (float) i3, (float) i3, (float) i3, (float) i3, (float) i3, (float) i3, (float) i3};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF((float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize), fArr));
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(i2);
        paint.setStrokeWidth((float) dimensionPixelSize);
        AppMethodBeat.o(113816);
        return shapeDrawable;
    }

    public static List<b> cX(List<vj> list) {
        AppMethodBeat.i(113817);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(113817);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            vj vjVar = list.get(i2);
            b bVar = new b();
            bVar.title = vjVar.title;
            bVar.pRY = vjVar.pRY;
            bVar.pWf = vjVar.pWf;
            bVar.url = vjVar.url;
            bVar.LfD = vjVar.LfD;
            bVar.pSj = false;
            bVar.LfE = vjVar.LfE;
            bVar.LfF = vjVar.LfF;
            bVar.qGB = vjVar.qGB;
            bVar.Leo = vjVar.Leo;
            bVar.Lep = vjVar.Lep;
            bVar.pSi = 1;
            arrayList.add(bVar);
        }
        AppMethodBeat.o(113817);
        return arrayList;
    }

    public static String AF(long j2) {
        AppMethodBeat.i(113818);
        long j3 = 1000 * j2;
        new GregorianCalendar().setTimeInMillis(j3);
        if (qkZ == null) {
            qkZ = new SimpleDateFormat("yyyy.MM.dd");
        }
        String format = qkZ.format(new Date(j3));
        AppMethodBeat.o(113818);
        return format;
    }

    public static boolean isNumeric(String str) {
        AppMethodBeat.i(113819);
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.o(113819);
        return matches;
    }

    public static Bitmap Y(Bitmap bitmap) {
        boolean z = true;
        AppMethodBeat.i(113820);
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(90.0f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        StringBuilder sb = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        Log.d("MicroMsg.CardUtil", sb.append(z).append("  degree:90.0").toString());
        AppMethodBeat.o(113820);
        return createBitmap;
    }

    public static void Z(Bitmap bitmap) {
        AppMethodBeat.i(113821);
        if (bitmap != null && !bitmap.isRecycled()) {
            Log.i("MicroMsg.CardUtil", "bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        AppMethodBeat.o(113821);
    }

    public static boolean b(CardInfo cardInfo) {
        AppMethodBeat.i(113822);
        if (cardInfo == null) {
            Log.e("MicroMsg.CardUtil", "processCardObject fail, card is null");
            AppMethodBeat.o(113822);
            return false;
        }
        CardInfo ajk = am.ctQ().ajk(cardInfo.field_card_id);
        if (ajk == null) {
            boolean insert = am.ctQ().insert(cardInfo);
            Log.d("MicroMsg.CardUtil", "processCardObject, insertRet = %b", Boolean.valueOf(insert));
            if (!insert) {
                Log.e("MicroMsg.CardUtil", "processCardObject, insert fail");
            }
            AppMethodBeat.o(113822);
            return insert;
        }
        cardInfo.field_stickyIndex = ajk.field_stickyIndex;
        cardInfo.field_stickyEndTime = ajk.field_stickyEndTime;
        cardInfo.field_stickyAnnouncement = ajk.field_stickyAnnouncement;
        boolean update = am.ctQ().update(cardInfo, new String[0]);
        Log.d("MicroMsg.CardUtil", "processCardObject, updateRet = %b", Boolean.valueOf(update));
        AppMethodBeat.o(113822);
        return update;
    }

    public static void a(com.tencent.mm.plugin.card.base.b bVar, String str, String str2, int i2) {
        byte[] bArr;
        int i3;
        k.b bVar2 = null;
        AppMethodBeat.i(113823);
        Bitmap a2 = u.a(new m(bVar.csQ().iwv));
        if (a2 != null) {
            bArr = BitmapUtil.Bitmap2Bytes(a2);
        } else {
            bArr = null;
        }
        a aVar = (a) g.af(a.class);
        if (bVar != null) {
            if (i2 == 23) {
                i2 = 2;
                i3 = 1;
            } else {
                i3 = 0;
            }
            StringBuilder sb = new StringBuilder();
            k.b bVar3 = new k.b();
            if (bVar.csQ() != null) {
                bVar3.title = bVar.csS().MXq;
                bVar3.description = bVar.csQ().title;
                bVar3.type = 16;
                bVar3.dDG = 0;
                bVar3.iwL = 3;
                bVar3.appId = bVar.csQ().dNI;
                bVar3.iwc = 0;
                bVar3.thumburl = bVar.csQ().iwv;
                bVar3.ixV = i2;
                bVar3.ixU = bVar.csQ().gTG;
                bVar3.url = bVar.csQ().LeG;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("<from_username>").append(bVar.csW()).append("</from_username>");
            if (EH(i2)) {
                sb2.append("<card_id>").append(bVar.csV()).append("</card_id>");
            } else if (i2 == 5) {
                sb2.append("<card_id>").append(bVar.csU()).append("</card_id>");
            }
            sb2.append("<card_type>").append(bVar.csQ().nHh).append("</card_type>");
            sb2.append("<from_scene>").append(i2).append("</from_scene>");
            sb2.append("<color>").append(bVar.csQ().ixw).append("</color>");
            sb2.append("<card_type_name>").append(bVar.csQ().pTn).append("</card_type_name>");
            sb2.append("<brand_name>").append(bVar.csQ().gTG).append("</brand_name>");
            if (TextUtils.isEmpty(str2)) {
                sb2.append("<card_ext></card_ext>");
            } else {
                sb2.append("<card_ext>").append(str2).append("</card_ext>");
            }
            sb2.append("<is_recommend>").append(i3).append("</is_recommend>");
            sb2.append("<recommend_card_id>").append(bVar.csU()).append("</recommend_card_id>");
            bVar3.ixT = sb.append(sb2.toString()).toString();
            bVar3.dPu = k.b.a(bVar3, null, null);
            bVar2 = bVar3;
        }
        aVar.a(bVar2, bVar.csQ().dNI, bVar.csQ().gTG, str, bArr);
        AppMethodBeat.o(113823);
    }

    public static void fB(String str, String str2) {
        AppMethodBeat.i(113824);
        if (!Util.isNullOrNil(str)) {
            tw twVar = new tw();
            twVar.eaq.dkV = str2;
            twVar.eaq.content = str;
            twVar.eaq.type = ab.JG(str2);
            twVar.eaq.flags = 0;
            EventCenter.instance.publish(twVar);
        }
        AppMethodBeat.o(113824);
    }

    public static boolean EH(int i2) {
        return i2 == 0 || i2 == 1 || i2 == 2 || i2 == 9 || i2 == 12 || i2 == 17 || i2 == 21;
    }

    public static boolean EI(int i2) {
        return i2 == 7 || i2 == 8 || i2 == 16 || i2 == 26;
    }

    public static boolean EJ(int i2) {
        return i2 == 3 || i2 == 4 || i2 == 5 || i2 == 15;
    }

    public static boolean Eg(int i2) {
        switch (i2) {
            case 0:
            case 10:
            case 11:
            case 20:
            case 30:
                return true;
            default:
                return false;
        }
    }

    public static void cxE() {
        AppMethodBeat.i(113825);
        Integer num = (Integer) g.aAh().azQ().get(282883, (Object) null);
        if (num == null || num.intValue() != 1) {
            Log.i("MicroMsg.CardUtil", "open card entrance");
            g.aAh().azQ().set(282883, (Object) 1);
            AppMethodBeat.o(113825);
            return;
        }
        Log.i("MicroMsg.CardUtil", "card entrance is open");
        AppMethodBeat.o(113825);
    }

    public static boolean cxF() {
        AppMethodBeat.i(113826);
        Integer num = (Integer) g.aAh().azQ().get(282883, (Object) null);
        if (num == null || num.intValue() != 1) {
            AppMethodBeat.o(113826);
            return false;
        }
        AppMethodBeat.o(113826);
        return true;
    }

    public static void cxG() {
        AppMethodBeat.i(113827);
        Integer num = (Integer) g.aAh().azQ().get(ar.a.USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC, (Object) 0);
        if (num == null || num.intValue() != 1) {
            Log.i("MicroMsg.CardUtil", "open share card entrance");
            g.aAh().azQ().set(ar.a.USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC, (Object) 1);
            AppMethodBeat.o(113827);
            return;
        }
        Log.i("MicroMsg.CardUtil", "share card entrance is open");
        AppMethodBeat.o(113827);
    }

    public static boolean cxH() {
        AppMethodBeat.i(113828);
        Integer num = (Integer) g.aAh().azQ().get(ar.a.USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC, (Object) null);
        if (num == null || num.intValue() != 1) {
            AppMethodBeat.o(113828);
            return false;
        }
        AppMethodBeat.o(113828);
        return true;
    }

    public static String f(Context context, float f2) {
        AppMethodBeat.i(113829);
        if (f2 <= 0.0f) {
            AppMethodBeat.o(113829);
            return "";
        } else if (f2 > 0.0f && f2 < 1000.0f) {
            String string = context.getString(R.string.aoh, new StringBuilder().append((int) f2).toString());
            AppMethodBeat.o(113829);
            return string;
        } else if (f2 >= 1000.0f) {
            String string2 = context.getString(R.string.aog, new DecimalFormat("0.00").format((double) (f2 / 1000.0f)));
            AppMethodBeat.o(113829);
            return string2;
        } else {
            AppMethodBeat.o(113829);
            return "";
        }
    }

    public static boolean bcc() {
        AppMethodBeat.i(113830);
        try {
            boolean isProviderEnabled = ((LocationManager) MMApplicationContext.getContext().getSystemService(FirebaseAnalytics.b.LOCATION)).isProviderEnabled("gps");
            AppMethodBeat.o(113830);
            return isProviderEnabled;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CardUtil", e2, "", new Object[0]);
            AppMethodBeat.o(113830);
            return false;
        }
    }

    public static boolean bcd() {
        AppMethodBeat.i(113831);
        try {
            boolean isProviderEnabled = ((LocationManager) MMApplicationContext.getContext().getSystemService(FirebaseAnalytics.b.LOCATION)).isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
            AppMethodBeat.o(113831);
            return isProviderEnabled;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CardUtil", e2, "", new Object[0]);
            AppMethodBeat.o(113831);
            return false;
        }
    }

    public static boolean a(ShareCardInfo shareCardInfo) {
        AppMethodBeat.i(113832);
        if (shareCardInfo == null) {
            Log.e("MicroMsg.CardUtil", "processShareCardObject fail, card is null");
            AppMethodBeat.o(113832);
            return false;
        }
        ShareCardInfo ajA = am.ctY().ajA(shareCardInfo.field_card_id);
        if (ajA == null) {
            boolean insert = am.ctY().insert(shareCardInfo);
            Log.d("MicroMsg.CardUtil", "processShareCardObject, insertRet = %b", Boolean.valueOf(insert));
            if (!insert) {
                Log.e("MicroMsg.CardUtil", "processShareCardObject, insert fail");
            } else {
                com.tencent.mm.plugin.card.sharecard.a.b.ft(shareCardInfo.field_card_id, shareCardInfo.field_card_tp_id);
            }
            AppMethodBeat.o(113832);
            return insert;
        }
        shareCardInfo.field_categoryType = ajA.field_categoryType;
        shareCardInfo.field_itemIndex = ajA.field_itemIndex;
        boolean update = am.ctY().update(shareCardInfo, new String[0]);
        Log.d("MicroMsg.CardUtil", "processShareCardObject, updateRet = %b", Boolean.valueOf(update));
        AppMethodBeat.o(113832);
        return update;
    }

    public static boolean h(com.tencent.mm.plugin.card.base.b bVar) {
        boolean z;
        AppMethodBeat.i(113833);
        if (bVar instanceof CardInfo) {
            z = am.ctQ().update((CardInfo) bVar, new String[0]);
            if (!z) {
                Log.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", bVar.csU());
            }
        } else if (bVar instanceof ShareCardInfo) {
            z = am.ctY().update((ShareCardInfo) bVar, new String[0]);
            if (!z) {
                Log.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", bVar.csU());
            }
        } else {
            z = false;
        }
        AppMethodBeat.o(113833);
        return z;
    }

    public static void akf(String str) {
        AppMethodBeat.i(113834);
        g.aAh().azQ().set(ar.a.USERINFO_CARD_SHARECARD_LAYOUT_JSON_STRING_SYNC, str);
        AppMethodBeat.o(113834);
    }

    public static String cxI() {
        AppMethodBeat.i(113835);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_CARD_SHARECARD_LAYOUT_JSON_STRING_SYNC, "");
        AppMethodBeat.o(113835);
        return str;
    }

    public static String akg(String str) {
        AppMethodBeat.i(113836);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(113836);
            return "";
        }
        String Is = aa.Is(str);
        String displayName = aa.getDisplayName(str);
        if (!TextUtils.isEmpty(Is)) {
            AppMethodBeat.o(113836);
            return Is;
        } else if (!TextUtils.isEmpty(displayName)) {
            AppMethodBeat.o(113836);
            return displayName;
        } else {
            AppMethodBeat.o(113836);
            return str;
        }
    }

    public static ArrayList<String> cY(List<String> list) {
        AppMethodBeat.i(113837);
        if (list == null || list.isEmpty()) {
            Log.e("MicroMsg.CardUtil", "getContactNamesFromLabels labels is empty!");
            AppMethodBeat.o(113837);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        HashSet hashSet = new HashSet();
        for (String str : list) {
            List<String> aCK = com.tencent.mm.plugin.label.a.a.ecg().aCK(com.tencent.mm.plugin.label.a.a.ecg().aCH(str));
            if (aCK == null || aCK.size() == 0) {
                Log.e("MicroMsg.CardUtil", "getContactNamesFromLabels, namelist get bu label is null");
            } else {
                hashSet.addAll(aCK);
            }
        }
        arrayList.addAll(hashSet);
        AppMethodBeat.o(113837);
        return arrayList;
    }

    public static ArrayList<String> cZ(List<String> list) {
        AppMethodBeat.i(113838);
        if (list == null || list.isEmpty()) {
            Log.e("MicroMsg.CardUtil", "getContactIdsFromLabels labels is empty!");
            AppMethodBeat.o(113838);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : list) {
            String aCH = com.tencent.mm.plugin.label.a.a.ecg().aCH(str);
            if (!TextUtils.isEmpty(aCH)) {
                arrayList.add(aCH);
            }
        }
        AppMethodBeat.o(113838);
        return arrayList;
    }

    public static String akh(String str) {
        LinkedList linkedList;
        AppMethodBeat.i(113839);
        List<String> asList = Arrays.asList(str.split(","));
        LinkedList linkedList2 = new LinkedList();
        if (g.aAc()) {
            if (asList == null || asList.size() == 0) {
                linkedList = linkedList2;
                String listToString = Util.listToString(linkedList, ",");
                AppMethodBeat.o(113839);
                return listToString;
            }
            for (String str2 : asList) {
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str2);
                if (!(Kn == null || ((int) Kn.gMZ) == 0)) {
                    str2 = Kn.arJ();
                }
                linkedList2.add(str2);
            }
        }
        linkedList = linkedList2;
        String listToString2 = Util.listToString(linkedList, ",");
        AppMethodBeat.o(113839);
        return listToString2;
    }

    public static dxy a(int i2, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        AppMethodBeat.i(113840);
        Log.i("MicroMsg.CardUtil", "getShareTag()");
        dxy dxy = new dxy();
        if (i2 == 2) {
            if (arrayList != null && arrayList.size() > 0) {
                dxy.MXB.addAll(arrayList);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    String str = arrayList2.get(i3);
                    if (!TextUtils.isEmpty(str) && isNumeric(str)) {
                        arrayList3.add(Integer.valueOf(Util.getInt(str, 0)));
                    }
                }
                dxy.MXD.addAll(arrayList3);
            }
        } else if (i2 == 3) {
            if (arrayList != null && arrayList.size() > 0) {
                dxy.MXC.addAll(arrayList);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                ArrayList arrayList4 = new ArrayList();
                for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                    String str2 = arrayList2.get(i4);
                    if (!TextUtils.isEmpty(str2) && isNumeric(str2)) {
                        arrayList4.add(Integer.valueOf(Util.getInt(str2, 0)));
                    }
                }
                dxy.MXE.addAll(arrayList4);
            }
        }
        AppMethodBeat.o(113840);
        return dxy;
    }

    public static boolean a(abz abz, String str) {
        AppMethodBeat.i(113841);
        if (!BV(abz.LfD)) {
            Log.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
            AppMethodBeat.o(113841);
            return false;
        } else if (aki(str)) {
            Log.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
            AppMethodBeat.o(113841);
            return false;
        } else {
            Log.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            AppMethodBeat.o(113841);
            return true;
        }
    }

    public static boolean a(b bVar, String str) {
        AppMethodBeat.i(113842);
        if (!BV(bVar.LfD)) {
            Log.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
            AppMethodBeat.o(113842);
            return false;
        } else if (aki(str)) {
            Log.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
            AppMethodBeat.o(113842);
            return false;
        } else {
            Log.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            AppMethodBeat.o(113842);
            return true;
        }
    }

    private static boolean BV(long j2) {
        AppMethodBeat.i(113843);
        if ((8 & j2) > 0) {
            Log.i("MicroMsg.CardUtil", "shouldShowWarning show the warning!");
            AppMethodBeat.o(113843);
            return true;
        }
        AppMethodBeat.o(113843);
        return false;
    }

    private static boolean aki(String str) {
        AppMethodBeat.i(113844);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.CardUtil", "hasShowTheWarning card_id or title is empty!");
            AppMethodBeat.o(113844);
            return true;
        }
        Log.i("MicroMsg.CardUtil", "hasShowWarning()");
        String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC, "");
        if (TextUtils.isEmpty(str2)) {
            Log.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
            AppMethodBeat.o(113844);
            return false;
        }
        String[] split = str2.split(",");
        if (split == null || split.length == 0) {
            Log.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
            AppMethodBeat.o(113844);
            return false;
        }
        for (String str3 : split) {
            if (str.equals(str3)) {
                AppMethodBeat.o(113844);
                return true;
            }
        }
        AppMethodBeat.o(113844);
        return false;
    }

    public static void akj(String str) {
        AppMethodBeat.i(113845);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.CardUtil", "setShowWarningFlag card_id or title is empty!");
            AppMethodBeat.o(113845);
            return;
        }
        Log.i("MicroMsg.CardUtil", "setShowWarningFlag()");
        String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC, "");
        if (TextUtils.isEmpty(str2)) {
            Log.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
        } else {
            String[] split = str2.split(",");
            if (split == null || split.length == 0) {
                Log.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
                str2 = str;
            }
            boolean z = false;
            for (String str3 : split) {
                if (str.equals(str3)) {
                    z = true;
                }
            }
            str = !z ? str2 + "," + str : str2;
        }
        g.aAh().azQ().set(ar.a.USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC, str);
        AppMethodBeat.o(113845);
    }

    public static String Y(String str, long j2) {
        AppMethodBeat.i(113846);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(113846);
            return "";
        }
        float f2 = am.ctW().gmv;
        float f3 = am.ctW().gmu;
        if (f2 == -1000.0f || f3 == -85.0f) {
            Log.e("MicroMsg.CardUtil", "getRedirectUrl() location info is empty!");
            AppMethodBeat.o(113846);
            return str;
        } else if ((16 & j2) > 0) {
            String replace = str.replace("#", ("&longitude=" + f2 + "&latitude=" + f3) + "#");
            Log.i("MicroMsg.CardUtil", "getRedirectUrl originalUrl:".concat(String.valueOf(str)));
            Log.i("MicroMsg.CardUtil", "getRedirectUrl afterwardsUrl:".concat(String.valueOf(replace)));
            AppMethodBeat.o(113846);
            return replace;
        } else {
            AppMethodBeat.o(113846);
            return str;
        }
    }

    public static int akk(String str) {
        AppMethodBeat.i(113847);
        if (TextUtils.isEmpty(str) || str.equals(z.aTY())) {
            AppMethodBeat.o(113847);
            return 0;
        }
        AppMethodBeat.o(113847);
        return 1;
    }

    public static Drawable h(Context context, String str, int i2) {
        AppMethodBeat.i(113848);
        ShapeDrawable e2 = e(context, ake(str), i2);
        ShapeDrawable fi = fi(ake(str), i2);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, fi);
        stateListDrawable.addState(new int[0], e2);
        AppMethodBeat.o(113848);
        return stateListDrawable;
    }

    public static ColorStateList ap(Context context, String str) {
        AppMethodBeat.i(113849);
        int[][] iArr = {new int[]{16842919, 16842910}, new int[0]};
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{context.getResources().getColor(R.color.ag2), ake(str)});
        AppMethodBeat.o(113849);
        return colorStateList;
    }

    public static int cT(String str, int i2) {
        AppMethodBeat.i(113850);
        int fj = fj(Color.parseColor(str), i2);
        AppMethodBeat.o(113850);
        return fj;
    }

    public static int fj(int i2, int i3) {
        AppMethodBeat.i(113851);
        if (i3 <= 0) {
            AppMethodBeat.o(113851);
            return i2;
        }
        int fj = com.tencent.mm.ui.ar.fj(i2, i3);
        AppMethodBeat.o(113851);
        return fj;
    }

    public static void aq(Context context, String str) {
        AppMethodBeat.i(113852);
        if (!Util.isNullOrNil(str)) {
            Toast.makeText(MMApplicationContext.getContext(), str, 1).show();
            AppMethodBeat.o(113852);
            return;
        }
        h.c(context, context.getString(R.string.atv), "", false);
        AppMethodBeat.o(113852);
    }

    public static void ar(Context context, String str) {
        AppMethodBeat.i(113853);
        if (Util.isNullOrNil(str)) {
            str = context.getString(R.string.atv);
        }
        h.c(context, str, "", false);
        AppMethodBeat.o(113853);
    }
}
