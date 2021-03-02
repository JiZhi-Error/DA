package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class i {
    private static HashMap<String, Constructor<?>> OZk = new HashMap<>();
    private static final Class<?>[] OZl = {Context.class, AttributeSet.class};
    private final Object[] mConstructorArgs = new Object[2];
    private final Context mContext;

    static {
        AppMethodBeat.i(142625);
        AppMethodBeat.o(142625);
    }

    public i(Context context) {
        AppMethodBeat.i(142619);
        this.mContext = context;
        AppMethodBeat.o(142619);
    }

    public final void a(int i2, f fVar) {
        AppMethodBeat.i(142620);
        XmlResourceParser xml = this.mContext.getResources().getXml(i2);
        try {
            a(xml, fVar);
        } finally {
            xml.close();
            AppMethodBeat.o(142620);
        }
    }

    private void a(XmlPullParser xmlPullParser, f fVar) {
        AppMethodBeat.i(142621);
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
                        AppMethodBeat.o(142621);
                        throw inflateException;
                    }
                    d(xmlPullParser.getName(), asAttributeSet);
                    a(xmlPullParser, fVar, asAttributeSet);
                } catch (InflateException e2) {
                    AppMethodBeat.o(142621);
                    throw e2;
                } catch (XmlPullParserException e3) {
                    InflateException inflateException2 = new InflateException(e3.getMessage());
                    inflateException2.initCause(e3);
                    AppMethodBeat.o(142621);
                    throw inflateException2;
                } catch (IOException e4) {
                    InflateException inflateException3 = new InflateException(xmlPullParser.getPositionDescription() + ": " + e4.getMessage());
                    inflateException3.initCause(e4);
                    AppMethodBeat.o(142621);
                    throw inflateException3;
                }
            } finally {
                AppMethodBeat.o(142621);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0062, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0063, code lost:
        r2 = new java.lang.StringBuilder().append(r10.getPositionDescription()).append(": Error inflating class ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0079, code lost:
        if (r9 != null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007b, code lost:
        r8 = r9 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x008c, code lost:
        r1 = new android.view.InflateException(r2.append(r8).toString());
        r1.initCause(r0);
        com.tencent.matrix.trace.core.AppMethodBeat.o(142622);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009d, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009f, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(142622);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a2, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a3, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a4, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a9, code lost:
        r0 = r10.getPositionDescription();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c2, code lost:
        if ("(null): Error inflating class ".concat(java.lang.String.valueOf(r2)) != null) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c4, code lost:
        r0 = r2.getClass().getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cd, code lost:
        r0 = "(null)";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0062 A[ExcHandler: NoSuchMethodException (r0v14 'e' java.lang.NoSuchMethodException A[CUSTOM_DECLARE]), Splitter:B:3:0x0017] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009e A[ExcHandler: ClassNotFoundException (r0v13 'e' java.lang.ClassNotFoundException A[CUSTOM_DECLARE]), Splitter:B:3:0x0017] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.mm.ui.base.preference.Preference a(java.lang.String r8, java.lang.String r9, android.util.AttributeSet r10) {
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.base.preference.i.a(java.lang.String, java.lang.String, android.util.AttributeSet):com.tencent.mm.ui.base.preference.Preference");
    }

    private Preference d(String str, AttributeSet attributeSet) {
        Preference a2;
        AppMethodBeat.i(142623);
        try {
            if (-1 == str.indexOf(46)) {
                a2 = a(str, "com.tencent.mm.ui.base.preference.", attributeSet);
            } else {
                a2 = a(str, (String) null, attributeSet);
            }
            AppMethodBeat.o(142623);
            return a2;
        } catch (InflateException e2) {
            AppMethodBeat.o(142623);
            throw e2;
        } catch (ClassNotFoundException e3) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e3);
            AppMethodBeat.o(142623);
            throw inflateException;
        } catch (Exception e4) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e4);
            AppMethodBeat.o(142623);
            throw inflateException2;
        }
    }

    private void a(XmlPullParser xmlPullParser, f fVar, AttributeSet attributeSet) {
        AppMethodBeat.i(142624);
        int depth = xmlPullParser.getDepth();
        int next = xmlPullParser.next();
        while (true) {
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next != 2) {
                    next = xmlPullParser.next();
                } else {
                    fVar.a(d(xmlPullParser.getName(), attributeSet), -1);
                    next = xmlPullParser.next();
                }
            }
        }
        AppMethodBeat.o(142624);
    }
}
