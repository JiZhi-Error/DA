package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.webkit.WebIconDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IconListener;

@Deprecated
public class WebIconDatabase extends z {

    /* renamed from: a  reason: collision with root package name */
    private static WebIconDatabase f1902a;

    @Deprecated
    public interface a {
        void a(String str, Bitmap bitmap);
    }

    public void open(String str) {
        AppMethodBeat.i(54679);
        if (isX5Core()) {
            getWebIconDBImpl().open(str);
            AppMethodBeat.o(54679);
            return;
        }
        android.webkit.WebIconDatabase.getInstance().open(str);
        AppMethodBeat.o(54679);
    }

    public void close() {
        AppMethodBeat.i(54680);
        if (isX5Core()) {
            getWebIconDBImpl().close();
            AppMethodBeat.o(54680);
            return;
        }
        android.webkit.WebIconDatabase.getInstance().close();
        AppMethodBeat.o(54680);
    }

    public void removeAllIcons() {
        AppMethodBeat.i(54681);
        if (isX5Core()) {
            getWebIconDBImpl().removeAllIcons();
            AppMethodBeat.o(54681);
            return;
        }
        android.webkit.WebIconDatabase.getInstance().removeAllIcons();
        AppMethodBeat.o(54681);
    }

    public void requestIconForPageUrl(String str, final a aVar) {
        AppMethodBeat.i(54682);
        if (isX5Core()) {
            getWebIconDBImpl().requestIconForPageUrl(str, new IconListener() {
                /* class com.tencent.smtt.sdk.WebIconDatabase.AnonymousClass1 */

                @Override // com.tencent.smtt.export.external.interfaces.IconListener
                public void onReceivedIcon(String str, Bitmap bitmap) {
                    AppMethodBeat.i(54625);
                    aVar.a(str, bitmap);
                    AppMethodBeat.o(54625);
                }
            });
            AppMethodBeat.o(54682);
            return;
        }
        android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(str, new WebIconDatabase.IconListener() {
            /* class com.tencent.smtt.sdk.WebIconDatabase.AnonymousClass2 */

            public void onReceivedIcon(String str, Bitmap bitmap) {
                AppMethodBeat.i(54563);
                aVar.a(str, bitmap);
                AppMethodBeat.o(54563);
            }
        });
        AppMethodBeat.o(54682);
    }

    public void bulkRequestIconForPageUrl(ContentResolver contentResolver, String str, a aVar) {
    }

    public void retainIconForPageUrl(String str) {
        AppMethodBeat.i(54683);
        if (isX5Core()) {
            getWebIconDBImpl().retainIconForPageUrl(str);
            AppMethodBeat.o(54683);
            return;
        }
        android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(str);
        AppMethodBeat.o(54683);
    }

    public void releaseIconForPageUrl(String str) {
        AppMethodBeat.i(54684);
        if (isX5Core()) {
            getWebIconDBImpl().releaseIconForPageUrl(str);
            AppMethodBeat.o(54684);
            return;
        }
        android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(str);
        AppMethodBeat.o(54684);
    }

    public static WebIconDatabase getInstance() {
        AppMethodBeat.i(54685);
        WebIconDatabase a2 = a();
        AppMethodBeat.o(54685);
        return a2;
    }

    private static synchronized WebIconDatabase a() {
        WebIconDatabase webIconDatabase;
        synchronized (WebIconDatabase.class) {
            AppMethodBeat.i(54686);
            if (f1902a == null) {
                f1902a = new WebIconDatabase();
            }
            webIconDatabase = f1902a;
            AppMethodBeat.o(54686);
        }
        return webIconDatabase;
    }

    private WebIconDatabase() {
    }
}
