package com.tencent.mm.plugin.appbrand.app;

import android.content.ContentValues;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.tencent.luggage.wxa.storage.WxaCriticalDataProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/app/AppBrandCriticalDataProvider;", "Lcom/tencent/luggage/wxa/storage/WxaCriticalDataProvider;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "insert", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "contentValues", "Landroid/content/ContentValues;", "onAccountInitialized", "", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "provideDatabase", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-appbrand-integration_release"})
public final class AppBrandCriticalDataProvider extends WxaCriticalDataProvider implements c {
    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(50158);
        super.Pq();
        AppMethodBeat.o(50158);
    }

    @Override // com.tencent.luggage.wxa.storage.WxaCriticalDataProvider
    public final ISQLiteDatabase Pp() {
        AppMethodBeat.i(50159);
        r.a buy = n.buy();
        if (buy != null) {
            c(x.class, n.buC());
            c(bh.class, n.buL());
            g.aAi().by(buy);
        } else {
            buy = null;
        }
        r.a aVar = buy;
        AppMethodBeat.o(50159);
        return aVar;
    }

    @Override // com.tencent.luggage.wxa.storage.WxaCriticalDataProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        int i2;
        AppMethodBeat.i(50160);
        p.h(uri, ShareConstants.MEDIA_URI);
        Uri insert = super.insert(uri, contentValues);
        if (insert != null && p(uri) == 5) {
            if (p.j(contentValues != null ? contentValues.getAsString("CONTENT_KEY_ACTION") : null, "ACTION_FLUSH_WXA_DEBUG_PKG_INFO")) {
                String asString = contentValues.getAsString("CONTENT_KEY_APPID");
                Integer asInteger = contentValues.getAsInteger("CONTENT_KEY_PKG_TYPE");
                if (asInteger != null) {
                    i2 = asInteger.intValue();
                } else {
                    i2 = -1;
                }
                String str = asString;
                if (!(str == null || str.length() == 0) && i2 != -1) {
                    h.bWb().cl(asString, i2);
                }
            }
        }
        AppMethodBeat.o(50160);
        return insert;
    }
}
