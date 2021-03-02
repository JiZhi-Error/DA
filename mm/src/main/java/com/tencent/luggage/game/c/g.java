package com.tencent.luggage.game.c;

import android.content.Context;
import android.view.View;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.InputStream;

public interface g {

    public interface a {
        void Mb();
    }

    a Ma();

    void a(b bVar);

    void aF(Context context);

    void destroy();

    void dp(String str);

    View getView();

    void loadUrl(String str);

    void requestLayout();

    void setTranslationY(float f2);

    void setVisibility(int i2);

    public static abstract class b {
        public static String cvx = "WAGameVConsole.html";

        public abstract void LZ();

        public abstract boolean dn(String str);

        /* renamed from: do  reason: not valid java name */
        public abstract InputStream m4do(String str);

        public class a {
            public InputStream aFm;
            public String charset;
            public String mimeType;

            a(String str, String str2, InputStream inputStream) {
                this.mimeType = str;
                this.charset = str2;
                this.aFm = inputStream;
            }
        }

        public final a dr(String str) {
            InputStream inputStream = m4do(str);
            if (inputStream == null) {
                return null;
            }
            return new a(MimeTypeUtil.getMimeTypeByFilePath(str), MimeTypeUtil.ContentType.DEFAULT_CHARSET, inputStream);
        }
    }
}
