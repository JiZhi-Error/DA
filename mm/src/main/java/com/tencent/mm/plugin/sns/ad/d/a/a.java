package com.tencent.mm.plugin.sns.ad.d.a;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public static String aND(String str) {
        AppMethodBeat.i(201876);
        String aNC = aNC(str);
        if (!TextUtils.isEmpty(aNC)) {
            AppMethodBeat.o(201876);
            return aNC;
        }
        Log.d("SnsAd.H5PrefetchHelper", "the usePrefetch return value is ".concat(String.valueOf(str)));
        AppMethodBeat.o(201876);
        return str;
    }

    public static void gL(List<String> list) {
        AppMethodBeat.i(201877);
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            e.a aVar = new e.a();
            aVar.url = str;
            aVar.pmM = 181;
            arrayList.add(aVar);
        }
        e eVar = (e) g.af(e.class);
        if (eVar != null) {
            eVar.cu(arrayList);
            Log.d("SnsAd.H5PrefetchHelper", "the h5 prefetch is done");
        }
        AppMethodBeat.o(201877);
    }

    public static String[] a(Collection<String> collection, String str, String str2, String str3, String str4) {
        String str5;
        AppMethodBeat.i(201878);
        if (c.isEmpty(collection)) {
            AppMethodBeat.o(201878);
            return null;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                next = ap.n(next, "traceid=" + str + "&aid=" + str2);
            }
            if (TextUtils.isEmpty(str3)) {
                Log.i("SnsAd.H5PrefetchHelper", "processNativeLandingH5PrefetchUrl, use orig_UxInfo:".concat(String.valueOf(str4)));
                str5 = str4;
            } else {
                Log.i("SnsAd.H5PrefetchHelper", "processNativeLandingH5PrefetchUrl, use updated_UxInfo:".concat(String.valueOf(str3)));
                str5 = str3;
            }
            String aNC = aNC(r.kb(next, str5));
            if (!TextUtils.isEmpty(aNC)) {
                linkedList.add(aNC);
            }
        }
        String[] strArr = (String[]) linkedList.toArray(new String[0]);
        AppMethodBeat.o(201878);
        return strArr;
    }

    public static String aNC(String str) {
        AppMethodBeat.i(201875);
        try {
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(201875);
                return "";
            }
            Uri parse = Uri.parse(str);
            if (parse == null || !"1".equals(parse.getQueryParameter("canPrefetch"))) {
                AppMethodBeat.o(201875);
                return "";
            }
            String uri = parse.buildUpon().appendQueryParameter("prefetch", "1").build().toString();
            AppMethodBeat.o(201875);
            return uri;
        } catch (Throwable th) {
            AppMethodBeat.o(201875);
            return "";
        }
    }
}
