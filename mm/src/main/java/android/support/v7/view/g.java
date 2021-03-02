package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.v7.a.a;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.k;
import android.support.v7.widget.x;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class g extends MenuInflater {
    static final Class<?>[] adM;
    static final Class<?>[] adN;
    final Object[] adO;
    final Object[] adP = this.adO;
    Object adQ;
    Context mContext;

    static {
        Class<?>[] clsArr = {Context.class};
        adM = clsArr;
        adN = clsArr;
    }

    public g(Context context) {
        super(context);
        this.mContext = context;
        this.adO = new Object[]{context};
    }

    public final void inflate(int i2, Menu menu) {
        if (!(menu instanceof android.support.v4.a.a.a)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.mContext.getResources().getLayout(i2);
            a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (IOException e3) {
            throw new InflateException("Error inflating menu XML", e3);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        boolean z;
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got ".concat(String.valueOf(name)));
                }
            }
        }
        boolean z2 = false;
        Object obj = null;
        boolean z3 = false;
        int i2 = eventType;
        while (!z2) {
            switch (i2) {
                case 1:
                    throw new RuntimeException("Unexpected end of document");
                case 2:
                    if (!z3) {
                        String name2 = xmlPullParser.getName();
                        if (name2.equals("group")) {
                            bVar.c(attributeSet);
                            z = z2;
                            continue;
                        } else if (name2.equals("item")) {
                            bVar.d(attributeSet);
                            z = z2;
                        } else if (name2.equals("menu")) {
                            a(xmlPullParser, attributeSet, bVar.hH());
                            z = z2;
                        } else {
                            z = z2;
                            obj = name2;
                            z3 = true;
                        }
                        i2 = xmlPullParser.next();
                        z2 = z;
                    }
                    break;
                case 3:
                    String name3 = xmlPullParser.getName();
                    if (!z3 || !name3.equals(obj)) {
                        if (name3.equals("group")) {
                            bVar.hF();
                            z = z2;
                        } else if (name3.equals("item")) {
                            if (!bVar.adZ) {
                                if (bVar.aes == null || !bVar.aes.hasSubMenu()) {
                                    bVar.hG();
                                    z = z2;
                                } else {
                                    bVar.hH();
                                    z = z2;
                                }
                            }
                        } else if (name3.equals("menu")) {
                            z = true;
                        }
                        i2 = xmlPullParser.next();
                        z2 = z;
                    } else {
                        z = z2;
                        obj = null;
                        z3 = false;
                        continue;
                        i2 = xmlPullParser.next();
                        z2 = z;
                    }
                    break;
            }
            z = z2;
            i2 = xmlPullParser.next();
            z2 = z;
        }
    }

    static Object N(Object obj) {
        Context context = obj;
        while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context;
    }

    /* access modifiers changed from: package-private */
    public static class a implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] adR = {MenuItem.class};
        private Object adQ;
        private Method mMethod;

        public a(Object obj, String str) {
            this.adQ = obj;
            Class<?> cls = obj.getClass();
            try {
                this.mMethod = cls.getMethod(str, adR);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.mMethod.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.mMethod.invoke(this.adQ, menuItem)).booleanValue();
                }
                this.mMethod.invoke(this.adQ, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        private Menu adS;
        private int adT;
        private int adU;
        private int adV;
        private int adW;
        private boolean adX;
        private boolean adY;
        boolean adZ;
        private int aea;
        private int aeb;
        private CharSequence aec;
        private CharSequence aed;
        private int aee;
        private char aef;
        private int aeg;
        private char aeh;
        private int aei;
        private int aej;
        private boolean aek;
        private boolean ael;
        private boolean aem;
        private int aen;
        private int aeo;
        private String aep;
        private String aeq;
        private String aer;
        android.support.v4.view.b aes;
        private CharSequence aet;
        private CharSequence aeu;
        private ColorStateList aev = null;
        private PorterDuff.Mode aew = null;

        public b(Menu menu) {
            this.adS = menu;
            hF();
        }

        public final void hF() {
            this.adT = 0;
            this.adU = 0;
            this.adV = 0;
            this.adW = 0;
            this.adX = true;
            this.adY = true;
        }

        public final void c(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.mContext.obtainStyledAttributes(attributeSet, a.C0040a.MenuGroup);
            this.adT = obtainStyledAttributes.getResourceId(1, 0);
            this.adU = obtainStyledAttributes.getInt(3, 0);
            this.adV = obtainStyledAttributes.getInt(4, 0);
            this.adW = obtainStyledAttributes.getInt(5, 0);
            this.adX = obtainStyledAttributes.getBoolean(2, true);
            this.adY = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }

        public final void d(AttributeSet attributeSet) {
            boolean z = true;
            TypedArray obtainStyledAttributes = g.this.mContext.obtainStyledAttributes(attributeSet, a.C0040a.MenuItem);
            this.aea = obtainStyledAttributes.getResourceId(2, 0);
            this.aeb = (obtainStyledAttributes.getInt(5, this.adU) & -65536) | (obtainStyledAttributes.getInt(6, this.adV) & 65535);
            this.aec = obtainStyledAttributes.getText(7);
            this.aed = obtainStyledAttributes.getText(8);
            this.aee = obtainStyledAttributes.getResourceId(0, 0);
            this.aef = D(obtainStyledAttributes.getString(9));
            this.aeg = obtainStyledAttributes.getInt(16, 4096);
            this.aeh = D(obtainStyledAttributes.getString(10));
            this.aei = obtainStyledAttributes.getInt(20, 4096);
            if (obtainStyledAttributes.hasValue(11)) {
                this.aej = obtainStyledAttributes.getBoolean(11, false) ? 1 : 0;
            } else {
                this.aej = this.adW;
            }
            this.aek = obtainStyledAttributes.getBoolean(3, false);
            this.ael = obtainStyledAttributes.getBoolean(4, this.adX);
            this.aem = obtainStyledAttributes.getBoolean(1, this.adY);
            this.aen = obtainStyledAttributes.getInt(21, -1);
            this.aer = obtainStyledAttributes.getString(12);
            this.aeo = obtainStyledAttributes.getResourceId(13, 0);
            this.aep = obtainStyledAttributes.getString(15);
            this.aeq = obtainStyledAttributes.getString(14);
            if (this.aeq == null) {
                z = false;
            }
            if (z && this.aeo == 0 && this.aep == null) {
                this.aes = (android.support.v4.view.b) newInstance(this.aeq, g.adN, g.this.adP);
            } else {
                this.aes = null;
            }
            this.aet = obtainStyledAttributes.getText(17);
            this.aeu = obtainStyledAttributes.getText(22);
            if (obtainStyledAttributes.hasValue(19)) {
                this.aew = x.a(obtainStyledAttributes.getInt(19, -1), this.aew);
            } else {
                this.aew = null;
            }
            if (obtainStyledAttributes.hasValue(18)) {
                this.aev = obtainStyledAttributes.getColorStateList(18);
            } else {
                this.aev = null;
            }
            obtainStyledAttributes.recycle();
            this.adZ = false;
        }

        private static char D(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.aek).setVisible(this.ael).setEnabled(this.aem).setCheckable(this.aej > 0).setTitleCondensed(this.aed).setIcon(this.aee);
            if (this.aen >= 0) {
                menuItem.setShowAsAction(this.aen);
            }
            if (this.aer != null) {
                if (g.this.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                g gVar = g.this;
                if (gVar.adQ == null) {
                    gVar.adQ = g.N(gVar.mContext);
                }
                menuItem.setOnMenuItemClickListener(new a(gVar.adQ, this.aer));
            }
            if (this.aej >= 2) {
                if (menuItem instanceof j) {
                    ((j) menuItem).ab(true);
                } else if (menuItem instanceof k) {
                    k kVar = (k) menuItem;
                    try {
                        if (kVar.agX == null) {
                            kVar.agX = ((android.support.v4.a.a.b) kVar.afm).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        kVar.agX.invoke(kVar.afm, Boolean.TRUE);
                    } catch (Exception e2) {
                    }
                }
            }
            if (this.aep != null) {
                menuItem.setActionView((View) newInstance(this.aep, g.adM, g.this.adO));
            } else {
                z = false;
            }
            if (this.aeo > 0 && !z) {
                menuItem.setActionView(this.aeo);
            }
            if (this.aes != null) {
                android.support.v4.view.b bVar = this.aes;
                if (menuItem instanceof android.support.v4.a.a.b) {
                    ((android.support.v4.a.a.b) menuItem).a(bVar);
                }
            }
            CharSequence charSequence = this.aet;
            if (menuItem instanceof android.support.v4.a.a.b) {
                ((android.support.v4.a.a.b) menuItem).k(charSequence);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.aeu;
            if (menuItem instanceof android.support.v4.a.a.b) {
                ((android.support.v4.a.a.b) menuItem).l(charSequence2);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setTooltipText(charSequence2);
            }
            char c2 = this.aef;
            int i2 = this.aeg;
            if (menuItem instanceof android.support.v4.a.a.b) {
                ((android.support.v4.a.a.b) menuItem).setAlphabeticShortcut(c2, i2);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setAlphabeticShortcut(c2, i2);
            }
            char c3 = this.aeh;
            int i3 = this.aei;
            if (menuItem instanceof android.support.v4.a.a.b) {
                ((android.support.v4.a.a.b) menuItem).setNumericShortcut(c3, i3);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setNumericShortcut(c3, i3);
            }
            if (this.aew != null) {
                PorterDuff.Mode mode = this.aew;
                if (menuItem instanceof android.support.v4.a.a.b) {
                    ((android.support.v4.a.a.b) menuItem).setIconTintMode(mode);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    menuItem.setIconTintMode(mode);
                }
            }
            if (this.aev != null) {
                ColorStateList colorStateList = this.aev;
                if (menuItem instanceof android.support.v4.a.a.b) {
                    ((android.support.v4.a.a.b) menuItem).setIconTintList(colorStateList);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    menuItem.setIconTintList(colorStateList);
                }
            }
        }

        public final void hG() {
            this.adZ = true;
            a(this.adS.add(this.adT, this.aea, this.aeb, this.aec));
        }

        public final SubMenu hH() {
            this.adZ = true;
            SubMenu addSubMenu = this.adS.addSubMenu(this.adT, this.aea, this.aeb, this.aec);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        private <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = g.this.mContext.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                return null;
            }
        }
    }
}
