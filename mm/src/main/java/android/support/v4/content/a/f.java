package android.support.v4.content.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.a.c;
import android.support.v4.graphics.d;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class f {
    public static Drawable c(Resources resources, int i2, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i2, theme);
        }
        return resources.getDrawable(i2);
    }

    public static abstract class a {
        public abstract void D(int i2);

        public abstract void a(Typeface typeface);

        public final void a(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                /* class android.support.v4.content.a.f.a.AnonymousClass1 */

                public final void run() {
                    a.this.a(typeface);
                }
            });
        }

        public final void a(final int i2, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                /* class android.support.v4.content.a.f.a.AnonymousClass2 */

                public final void run() {
                    a.this.D(i2);
                }
            });
        }
    }

    public static Typeface a(Context context, int i2, TypedValue typedValue, int i3, a aVar) {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i2, typedValue, i3, aVar, true);
    }

    public static Typeface a(Context context, int i2, TypedValue typedValue, int i3, a aVar, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        Typeface a2 = a(context, resources, typedValue, i2, i3, aVar, null, z);
        if (a2 != null || aVar != null) {
            return a2;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i2) + " could not be retrieved.");
    }

    private static Typeface a(Context context, Resources resources, TypedValue typedValue, int i2, int i3, a aVar, Handler handler, boolean z) {
        if (typedValue.string == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i2) + "\" (" + Integer.toHexString(i2) + ") is not a Font: " + typedValue);
        }
        String charSequence = typedValue.string.toString();
        if (!charSequence.startsWith("res/")) {
            if (aVar != null) {
                aVar.a(-3, (Handler) null);
            }
            return null;
        }
        Typeface a2 = d.a(resources, i2, i3);
        if (a2 == null) {
            try {
                if (charSequence.toLowerCase().endsWith(".xml")) {
                    c.a a3 = c.a(resources.getXml(i2), resources);
                    if (a3 != null) {
                        return d.a(context, a3, resources, i2, i3, aVar, null, z);
                    }
                    if (aVar != null) {
                        aVar.a(-3, (Handler) null);
                    }
                    return null;
                }
                Typeface a4 = d.a(context, resources, i2, charSequence, i3);
                if (aVar == null) {
                    return a4;
                }
                if (a4 != null) {
                    aVar.a(a4, (Handler) null);
                    return a4;
                }
                aVar.a(-3, (Handler) null);
                return a4;
            } catch (IOException | XmlPullParserException e2) {
                if (aVar != null) {
                    aVar.a(-3, (Handler) null);
                }
                return null;
            }
        } else if (aVar == null) {
            return a2;
        } else {
            aVar.a(a2, (Handler) null);
            return a2;
        }
    }
}
