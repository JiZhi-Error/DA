package com.tencent.mm.plugin.base.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class MMPluginProvider extends ContentProvider {
    private static final UriMatcher ncB;
    private c pdp = new c();

    public MMPluginProvider() {
        AppMethodBeat.i(22166);
        AppMethodBeat.o(22166);
    }

    static {
        AppMethodBeat.i(22173);
        UriMatcher uriMatcher = new UriMatcher(-1);
        ncB = uriMatcher;
        uriMatcher.addURI(WeChatAuthorities.AUTHORITIES_SDK_PLUGIN_PROVIDER(), "sharedpref", 2);
        AppMethodBeat.o(22173);
    }

    /* access modifiers changed from: protected */
    public static abstract class a {
        private Context context = null;

        protected a() {
        }

        public boolean eI(Context context2) {
            this.context = context2;
            return true;
        }
    }

    public String getType(Uri uri) {
        AppMethodBeat.i(22167);
        switch (ncB.match(uri)) {
            case 2:
                AppMethodBeat.o(22167);
                break;
            default:
                AppMethodBeat.o(22167);
                break;
        }
        return null;
    }

    public boolean onCreate() {
        AppMethodBeat.i(22168);
        Log.i("MicroMsg.MMPluginProvider", "onCreate");
        this.pdp.eI(getContext());
        AppMethodBeat.o(22168);
        return true;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(22169);
        Log.v("MicroMsg.MMPluginProvider", "plugin insert".concat(String.valueOf(uri)));
        switch (ncB.match(uri)) {
            case 2:
                AppMethodBeat.o(22169);
                break;
            default:
                Log.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(uri)));
                AppMethodBeat.o(22169);
                break;
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        AppMethodBeat.i(22170);
        Log.v("MicroMsg.MMPluginProvider", "plugin delete".concat(String.valueOf(uri)));
        switch (ncB.match(uri)) {
            case 2:
                AppMethodBeat.o(22170);
                break;
            default:
                Log.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(uri)));
                AppMethodBeat.o(22170);
                break;
        }
        return 0;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(22171);
        Log.i("MicroMsg.MMPluginProvider", "plugin query".concat(String.valueOf(uri)));
        switch (ncB.match(uri)) {
            case 2:
                Cursor b2 = c.b(strArr, strArr2);
                AppMethodBeat.o(22171);
                return b2;
            default:
                Log.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(uri)));
                AppMethodBeat.o(22171);
                return null;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AppMethodBeat.i(22172);
        Log.d("MicroMsg.MMPluginProvider", "plugin update".concat(String.valueOf(uri)));
        switch (ncB.match(uri)) {
            case 2:
                AppMethodBeat.o(22172);
                break;
            default:
                Log.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(uri)));
                AppMethodBeat.o(22172);
                break;
        }
        return 0;
    }
}
