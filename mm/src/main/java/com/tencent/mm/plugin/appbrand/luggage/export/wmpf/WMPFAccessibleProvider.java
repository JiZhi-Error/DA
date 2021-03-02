package com.tencent.mm.plugin.appbrand.luggage.export.wmpf;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.appbrand.luggage.export.wmpf.WMPFQRCodeDetectProxyUI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016JK\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0016J9\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u0018¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFAccessibleProvider;", "Landroid/content/ContentProvider;", "()V", "delete", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "selection", "", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", SearchIntents.EXTRA_QUERY, "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Constants", "plugin-appbrand-integration_release"})
public final class WMPFAccessibleProvider extends ContentProvider {
    private static final boolean ENABLE;
    private static final UriMatcher ncB;
    public static final a ncC = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFAccessibleProvider$Constants;", "", "()V", "AUTHORITY", "", "CODE_DETECT_QRCODE", "", "CV_KEY_DETECT_QRCODE_BYTES", "ENABLE", "", "getENABLE", "()Z", "PATH_DETECT_QRCODE", "TAG", "sUriMatcher", "Landroid/content/UriMatcher;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        boolean z = false;
        AppMethodBeat.i(229037);
        UriMatcher uriMatcher = new UriMatcher(-1);
        ncB = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.export.wmpf.provider", "detect_qrcode", 1);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || WeChatEnvironment.hasDebugger()) {
            z = true;
        }
        ENABLE = z;
        AppMethodBeat.o(229037);
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(229032);
        p.h(uri, ShareConstants.MEDIA_URI);
        if (!ENABLE) {
            AppMethodBeat.o(229032);
        } else if (contentValues == null) {
            AppMethodBeat.o(229032);
        } else {
            if (ncB.match(uri) == 1) {
                h.RTc.aX(new b(this, contentValues.getAsByteArray("CV_KEY_DETECT_QRCODE_BYTES")));
            }
            AppMethodBeat.o(229032);
        }
        return null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ WMPFAccessibleProvider ncD;
        final /* synthetic */ byte[] ncE;

        b(WMPFAccessibleProvider wMPFAccessibleProvider, byte[] bArr) {
            this.ncD = wMPFAccessibleProvider;
            this.ncE = bArr;
        }

        public final void run() {
            Context context;
            AppMethodBeat.i(229031);
            Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(this.ncE, 0, this.ncE.length);
            String str = com.tencent.mm.loader.j.b.aKX() + "wmpf_qrcode.png";
            s.boN(com.tencent.mm.loader.j.b.aKX());
            BitmapUtil.saveBitmapToImage(decodeByteArray, 100, Bitmap.CompressFormat.PNG, str, true);
            try {
                WMPFQRCodeDetectProxyUI.a aVar = WMPFQRCodeDetectProxyUI.ncG;
                Context context2 = this.ncD.getContext();
                p.h(str, "qrcodePath");
                if (context2 == null) {
                    context = MMApplicationContext.getContext();
                } else {
                    context = context2;
                }
                Intent putExtra = new Intent(context, WMPFQRCodeDetectProxyUI.class).addFlags(268435456).putExtra("KEY_QRCODE_PATH", str);
                if (context2 == null) {
                    context2 = MMApplicationContext.getContext();
                }
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(putExtra);
                com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI$Companion", "waitFor", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context2.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI$Companion", "waitFor", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(229031);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.AppBrand.WMPFAccessibleProvider", th, "WMPFQRCodeDetectProxyUI.waitFor", new Object[0]);
                AppMethodBeat.o(229031);
            }
        }
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(229033);
        p.h(uri, ShareConstants.MEDIA_URI);
        AppMethodBeat.o(229033);
        return null;
    }

    public final boolean onCreate() {
        return true;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AppMethodBeat.i(229034);
        p.h(uri, ShareConstants.MEDIA_URI);
        AppMethodBeat.o(229034);
        return 0;
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        AppMethodBeat.i(229035);
        p.h(uri, ShareConstants.MEDIA_URI);
        AppMethodBeat.o(229035);
        return 0;
    }

    public final String getType(Uri uri) {
        AppMethodBeat.i(229036);
        p.h(uri, ShareConstants.MEDIA_URI);
        AppMethodBeat.o(229036);
        return null;
    }
}
