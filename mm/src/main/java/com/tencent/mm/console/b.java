package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.console.a.c;
import com.tencent.mm.console.a.d;
import com.tencent.mm.console.a.e;
import com.tencent.mm.console.a.f;
import com.tencent.mm.console.a.g;
import com.tencent.mm.console.a.h;
import com.tencent.mm.console.a.i;
import com.tencent.mm.console.a.j;
import com.tencent.mm.console.a.k;
import com.tencent.mm.console.a.l;
import com.tencent.mm.console.a.m;
import com.tencent.mm.console.a.n;
import com.tencent.mm.console.a.o;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    private static final HashSet<String> gMn;

    static /* synthetic */ boolean C(Context context, String str) {
        AppMethodBeat.i(20138);
        boolean B = B(context, str);
        AppMethodBeat.o(20138);
        return B;
    }

    static {
        AppMethodBeat.i(20139);
        e.init();
        j.init();
        k.init();
        g.init();
        h.init();
        c.init();
        d.init();
        n.init();
        i.init();
        l.init();
        o.init();
        m.init();
        try {
            Class.forName("com.tencent.mm.console.a.b.a");
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.CommandProcessor", th, "", new Object[0]);
        }
        com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a.a(), "//fsd");
        com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a.b(), "//hcsetting");
        com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a(), "//clearrecent");
        com.tencent.mm.console.a.b.init();
        com.tencent.mm.sdcard_migrate.c.init();
        f.init();
        HashSet<String> hashSet = new HashSet<>();
        gMn = hashSet;
        hashSet.add("//uplog");
        gMn.add("//pullxlog");
        gMn.add("//upcrash");
        gMn.add("//getfpkey");
        gMn.add("//voipdebug");
        gMn.add("//setkey");
        gMn.add("//wxcamera");
        gMn.add("//deletetbs");
        gMn.add("//setNfcOpenUrl");
        AppMethodBeat.o(20139);
    }

    private static int Et(String str) {
        AppMethodBeat.i(20130);
        if (!str.startsWith("//") || str.length() <= 2) {
            AppMethodBeat.o(20130);
            return 0;
        }
        int indexOf = str.indexOf(" ");
        if (indexOf == -1) {
            indexOf = str.length();
        }
        try {
            int i2 = Util.getInt(str.substring(2, indexOf), 0);
            int i3 = com.tencent.mm.protocal.d.KyO % 256;
            if (i3 == 0 || i2 < i3 || i2 % i3 != 0) {
                AppMethodBeat.o(20130);
                return 0;
            }
            int i4 = i2 / i3;
            AppMethodBeat.o(20130);
            return i4;
        } catch (Exception e2) {
            AppMethodBeat.o(20130);
            return 0;
        }
    }

    private static String Eu(String str) {
        AppMethodBeat.i(20131);
        int indexOf = str.indexOf(" ");
        if (indexOf < 0) {
            AppMethodBeat.o(20131);
            return "";
        }
        String trim = str.substring(indexOf).trim();
        AppMethodBeat.o(20131);
        return trim;
    }

    private static boolean Ev(String str) {
        AppMethodBeat.i(20132);
        Iterator<String> it = gMn.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                AppMethodBeat.o(20132);
                return true;
            }
        }
        AppMethodBeat.o(20132);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:429:0x132e  */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x1368  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x02aa A[SYNTHETIC, Splitter:B:86:0x02aa] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02b8 A[SYNTHETIC, Splitter:B:91:0x02b8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean h(final android.content.Context r12, final java.lang.String r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 18028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.console.b.h(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    private static boolean B(Context context, String str) {
        AppMethodBeat.i(20134);
        StringBuffer stringBuffer = new StringBuffer();
        if (!Util.isNullOrNil(str)) {
            stringBuffer.append(str + "\n\n");
        }
        stringBuffer.append("Default RSA Info:\n");
        stringBuffer.append("ClientVersion: " + BuildInfo.CLIENT_VERSION + "\n");
        stringBuffer.append("BASE_RSA_PUBLIC_VERSION = 199\n");
        stringBuffer.append(new StringBuilder("BASE_RSA_PUBLIC_KEYN = ADA9E573417691226521F9FF1B3732DF83EDA19BA60870A357E430135298469E68EF31E9E2109CA5E0CA661F769FCB2FE33A3021B9A790D5DFCA6720A439BEF69E138FAB1B05475228FD33BB11D07321A6DB4DB2689CA850C483630855DB7EDDD8B4505349DA863677E3EB78A46B5912FAE11BDE92BE9D98E3E2F2A47E03777E8795A51D67D7CC4B86EDEBD3D8968AAC51A58FFDBAA068750E4771BD364911B22420F96F8B0D7730455CC8CE1933B406C38675A9540E51C11C9872F692E2EC693448913781D1A8DD61A1FCC97B8B078CA06DDE9EBC35A1A22A697831879588F52BD6A108E1EE6519C518EDC887F65587D7F769C22E81131940085E6FAED67FCF len(512)\n").toString());
        stringBuffer.append("BASE_RSA_PUBLIC_KEYE = 010001\n\n");
        stringBuffer.append("REQ_RSA_PUBLIC_VERSION = 200\n");
        stringBuffer.append(new StringBuilder("REQ_RSA_PUBLIC_KEYN = 9357B6A18EE981DDA2C3CBBF39F5D308FC21656F30CF2EE7D75F6E9CB12928B972364B1AC57E2FB1F4ECC113A4060B9E97EEEF868FBD2623DDEFF77C3A048507F65DF9200CE4B2321E8D39B414C0663A8A10F6278543D28B2939BC8BD5CC7BE9A95F868C4F3C4F758C6A78ADD98BDE33D56E58377B10DD7F225426B5B27F4038302BE2DCA9332B8EC57B5E29C90B7A7DE6417D7378CB1D8B51E68BE1E99B2EB5EB49E613DCFF3FAED6F8C4875F6425F1AF6AEF3358403E4B0A92E456E1D5BE84999907A1246F2BECE05683959614312026492BDC302F82F38AD2EE99FDDB8675736274989B2389E95E80F8B597E69FD6A2CCB279226A578465EF9D50D29AE5ED len(512)\n").toString());
        stringBuffer.append("REQ_RSA_PUBLIC_KEYE = 010001\n");
        Log.i("MicroMsg.CommandProcessor", "summercert dumpdefaultrsa " + stringBuffer.toString());
        if (!CrashReportFactory.hasDebuger()) {
            AppMethodBeat.o(20134);
            return false;
        }
        TextView textView = new TextView(context);
        textView.setText(stringBuffer.toString());
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setTextColor(context.getResources().getColor(R.color.FG_0));
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.kb);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        com.tencent.mm.ui.base.h.a(context, (String) null, textView, (DialogInterface.OnClickListener) null);
        if (ac.gtV()) {
            Toast.makeText(context, "dump file:" + com.tencent.mm.loader.j.b.aKJ() + "DefaultRSARef.java", 1).show();
        }
        AppMethodBeat.o(20134);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ea A[SYNTHETIC, Splitter:B:21:0x00ea] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fc A[SYNTHETIC, Splitter:B:30:0x00fc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.StringBuilder oL(int r9) {
        /*
        // Method dump skipped, instructions count: 270
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.console.b.oL(int):java.lang.StringBuilder");
    }

    private static void oM(int i2) {
        AppMethodBeat.i(20136);
        SharedPreferences sharedPreferences = MultiProcSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "sp_sns_dynswitch_stg", 4, false);
        switch (i2) {
            case -1:
                sharedPreferences.edit().remove("st_sw_use_vcodec_img").commit();
                AppMethodBeat.o(20136);
                return;
            case 0:
                sharedPreferences.edit().putBoolean("st_sw_use_vcodec_img", false).commit();
                AppMethodBeat.o(20136);
                return;
            case 1:
                sharedPreferences.edit().putBoolean("st_sw_use_vcodec_img", true).commit();
                AppMethodBeat.o(20136);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Bad op parameter: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(20136);
                throw illegalArgumentException;
        }
    }

    private static void oN(int i2) {
        AppMethodBeat.i(20137);
        SharedPreferences sharedPreferences = MultiProcSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "sp_sns_dynswitch_stg", 4, false);
        switch (i2) {
            case -1:
                sharedPreferences.edit().remove("st_sw_use_wxpc_img").commit();
                AppMethodBeat.o(20137);
                return;
            case 0:
                sharedPreferences.edit().putBoolean("st_sw_use_wxpc_img", false).commit();
                AppMethodBeat.o(20137);
                return;
            case 1:
                sharedPreferences.edit().putBoolean("st_sw_use_wxpc_img", true).commit();
                AppMethodBeat.o(20137);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Bad op parameter: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(20137);
                throw illegalArgumentException;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements com.tencent.mm.ipcinvoker.b {
        private a() {
        }

        @Override // com.tencent.mm.ipcinvoker.b
        public void invoke(Object obj, com.tencent.mm.ipcinvoker.d dVar) {
            AppMethodBeat.i(231506);
            com.tencent.xweb.d.lA(MMApplicationContext.getContext());
            Log.i("MicroMsg.CommandProcessor", "ClearGameA8keyCookie before, cookie : %s", com.tencent.xweb.c.hsp().getCookie("." + WeChatHosts.domainString(R.string.e1h)));
            com.tencent.xweb.c.hsp().setCookie("." + WeChatHosts.domainString(R.string.e1h), "cookie_passkey=; max-age=0");
            com.tencent.xweb.c.hsp().setCookie("." + WeChatHosts.domainString(R.string.e1h), "uin=; max-age=0; httponly");
            com.tencent.xweb.c.hsp().setCookie("." + WeChatHosts.domainString(R.string.e1h), "key=; max-age=0; httponly");
            com.tencent.xweb.c.hsp().setCookie("." + WeChatHosts.domainString(R.string.e1h), "pass_ticket=; max-age=0; httponly");
            com.tencent.xweb.d.hsr();
            com.tencent.xweb.d.sync();
            Log.i("MicroMsg.CommandProcessor", "ClearGameA8keyCookie end, cookie : %s", com.tencent.xweb.c.hsp().getCookie("." + WeChatHosts.domainString(R.string.e1h)));
            AppMethodBeat.o(231506);
        }
    }
}
