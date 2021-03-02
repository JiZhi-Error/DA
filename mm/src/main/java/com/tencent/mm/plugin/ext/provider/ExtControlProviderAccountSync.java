package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderAccountSync extends ExtContentProviderBase {
    private static final UriMatcher sNf;

    static {
        AppMethodBeat.i(24421);
        UriMatcher uriMatcher = new UriMatcher(-1);
        sNf = uriMatcher;
        uriMatcher.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ACCOUNTSYNC(), "accountSync", 1);
        AppMethodBeat.o(24421);
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public String getType(Uri uri) {
        return null;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public boolean onCreate() {
        return true;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(24420);
        Log.d("MicroMsg.ExtControlAccountSyncProvider", "query()");
        a(uri, getContext(), sNf);
        if (uri == null) {
            HF(3);
            AppMethodBeat.o(24420);
            return null;
        } else if (Util.isNullOrNil(this.sMZ) || Util.isNullOrNil(cSt())) {
            HF(3);
            AppMethodBeat.o(24420);
            return null;
        } else if (!ckf()) {
            HF(1);
            MatrixCursor matrixCursor = this.pem;
            AppMethodBeat.o(24420);
            return matrixCursor;
        } else if (!fe(getContext())) {
            Log.w("MicroMsg.ExtControlAccountSyncProvider", "invalid appid ! return null");
            HF(2);
            AppMethodBeat.o(24420);
            return null;
        } else {
            switch (sNf.match(uri)) {
                case 1:
                    Log.i("MicroMsg.ExtControlAccountSyncProvider", "startContactSync()");
                    if (EventCenter.instance.publish(new gb())) {
                        HF(0);
                    } else {
                        Log.e("MicroMsg.ExtControlAccountSyncProvider", "AccountHelper == null");
                        HF(4);
                    }
                    AppMethodBeat.o(24420);
                    return null;
                default:
                    HF(3);
                    AppMethodBeat.o(24420);
                    return null;
            }
        }
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
