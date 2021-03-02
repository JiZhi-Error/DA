package com.tencent.weui.base.preference;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class c {
    private static HashMap<String, Constructor<?>> OZk = new HashMap<>();
    private static final Class<?>[] OZl = {Context.class, AttributeSet.class};
    private final Object[] mConstructorArgs = new Object[2];
    final Context mContext;

    static {
        AppMethodBeat.i(160018);
        AppMethodBeat.o(160018);
    }

    public c(Context context) {
        AppMethodBeat.i(160013);
        this.mContext = context;
        AppMethodBeat.o(160013);
    }

    /* access modifiers changed from: package-private */
    public final void a(XmlPullParser xmlPullParser, a aVar) {
        AppMethodBeat.i(160014);
        synchronized (this.mConstructorArgs) {
            try {
                AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                this.mConstructorArgs[0] = this.mContext;
                try {
                    int next = xmlPullParser.next();
                    while (next != 2 && next != 1) {
                        next = xmlPullParser.next();
                    }
                    if (next != 2) {
                        InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
                        AppMethodBeat.o(160014);
                        throw inflateException;
                    }
                    e(xmlPullParser.getName(), asAttributeSet);
                    a(xmlPullParser, aVar, asAttributeSet);
                } catch (InflateException e2) {
                    AppMethodBeat.o(160014);
                    throw e2;
                } catch (XmlPullParserException e3) {
                    InflateException inflateException2 = new InflateException(e3.getMessage());
                    inflateException2.initCause(e3);
                    AppMethodBeat.o(160014);
                    throw inflateException2;
                } catch (IOException e4) {
                    InflateException inflateException3 = new InflateException(xmlPullParser.getPositionDescription() + ": " + e4.getMessage());
                    inflateException3.initCause(e4);
                    AppMethodBeat.o(160014);
                    throw inflateException3;
                }
            } finally {
                AppMethodBeat.o(160014);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        r2 = new java.lang.StringBuilder().append(r9.getPositionDescription()).append(": Error inflating class ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0060, code lost:
        if (r8 != null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0062, code lost:
        r7 = r8 + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0073, code lost:
        r1 = new android.view.InflateException(r2.append(r7).toString());
        r1.initCause(r0);
        com.tencent.matrix.trace.core.AppMethodBeat.o(160015);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0084, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0085, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0086, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(160015);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0089, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008a, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008b, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0090, code lost:
        r0 = r9.getPositionDescription();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a9, code lost:
        if ("(null): Error inflating class ".concat(java.lang.String.valueOf(r2)) != null) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ab, code lost:
        r0 = r2.getClass().getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b4, code lost:
        r0 = "(null)";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A[ExcHandler: NoSuchMethodException (r0v14 'e' java.lang.NoSuchMethodException A[CUSTOM_DECLARE]), Splitter:B:2:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0085 A[ExcHandler: ClassNotFoundException (r0v13 'e' java.lang.ClassNotFoundException A[CUSTOM_DECLARE]), Splitter:B:2:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.preference.Preference b(java.lang.String r7, java.lang.String r8, android.util.AttributeSet r9) {
        /*
        // Method dump skipped, instructions count: 190
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.weui.base.preference.c.b(java.lang.String, java.lang.String, android.util.AttributeSet):android.preference.Preference");
    }

    private Preference e(String str, AttributeSet attributeSet) {
        Preference b2;
        AppMethodBeat.i(160016);
        try {
            if (-1 == str.indexOf(46)) {
                b2 = b(str, "android.preference.", attributeSet);
            } else {
                b2 = b(str, null, attributeSet);
            }
            AppMethodBeat.o(160016);
            return b2;
        } catch (InflateException e2) {
            AppMethodBeat.o(160016);
            throw e2;
        } catch (ClassNotFoundException e3) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e3);
            AppMethodBeat.o(160016);
            throw inflateException;
        } catch (Exception e4) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e4);
            AppMethodBeat.o(160016);
            throw inflateException2;
        }
    }

    private void a(XmlPullParser xmlPullParser, a aVar, AttributeSet attributeSet) {
        AppMethodBeat.i(160017);
        int depth = xmlPullParser.getDepth();
        int next = xmlPullParser.next();
        while (true) {
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next != 2) {
                    next = xmlPullParser.next();
                } else {
                    aVar.a(e(xmlPullParser.getName(), attributeSet));
                    next = xmlPullParser.next();
                }
            }
        }
        AppMethodBeat.o(160017);
    }
}
