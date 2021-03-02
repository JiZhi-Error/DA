package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.content.a.g;
import android.support.v4.e.a;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import com.tencent.mm.R;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class q {
    private static final Class<?>[] CL = {Context.class, AttributeSet.class};
    private static final a<String, Constructor> CM = new a<>();
    private final Context mContext;

    private q(Context context) {
        this.mContext = context;
    }

    public static q O(Context context) {
        return new q(context);
    }

    public final Transition dQ() {
        XmlResourceParser xml = this.mContext.getResources().getXml(R.transition.f3173c);
        try {
            Transition a2 = a(xml, Xml.asAttributeSet(xml), (Transition) null);
            xml.close();
            return a2;
        } catch (XmlPullParserException e2) {
            throw new InflateException(e2.getMessage(), e2);
        } catch (IOException e3) {
            throw new InflateException(xml.getPositionDescription() + ": " + e3.getMessage(), e3);
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    private Transition a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) {
        Transition transition2;
        int depth = xmlPullParser.getDepth();
        TransitionSet transitionSet = transition instanceof TransitionSet ? (TransitionSet) transition : null;
        Transition transition3 = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if ("fade".equals(name)) {
                        transition2 = new Fade(this.mContext, attributeSet);
                    } else if ("changeBounds".equals(name)) {
                        transition2 = new ChangeBounds(this.mContext, attributeSet);
                    } else if ("slide".equals(name)) {
                        transition2 = new Slide(this.mContext, attributeSet);
                    } else if ("explode".equals(name)) {
                        transition2 = new Explode(this.mContext, attributeSet);
                    } else if ("changeImageTransform".equals(name)) {
                        transition2 = new ChangeImageTransform(this.mContext, attributeSet);
                    } else if ("changeTransform".equals(name)) {
                        transition2 = new ChangeTransform(this.mContext, attributeSet);
                    } else if ("changeClipBounds".equals(name)) {
                        transition2 = new ChangeClipBounds(this.mContext, attributeSet);
                    } else if ("autoTransition".equals(name)) {
                        transition2 = new AutoTransition(this.mContext, attributeSet);
                    } else if ("changeScroll".equals(name)) {
                        transition2 = new ChangeScroll(this.mContext, attributeSet);
                    } else if ("transitionSet".equals(name)) {
                        transition2 = new TransitionSet(this.mContext, attributeSet);
                    } else if ("transition".equals(name)) {
                        transition2 = (Transition) a(attributeSet, Transition.class, "transition");
                    } else if ("targets".equals(name)) {
                        b(xmlPullParser, attributeSet, transition);
                        transition2 = transition3;
                    } else if ("arcMotion".equals(name)) {
                        if (transition == null) {
                            throw new RuntimeException("Invalid use of arcMotion element");
                        }
                        transition.a(new ArcMotion(this.mContext, attributeSet));
                        transition2 = transition3;
                    } else if ("pathMotion".equals(name)) {
                        if (transition == null) {
                            throw new RuntimeException("Invalid use of pathMotion element");
                        }
                        transition.a((PathMotion) a(attributeSet, PathMotion.class, "pathMotion"));
                        transition2 = transition3;
                    } else if (!"patternPathMotion".equals(name)) {
                        throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                    } else if (transition == null) {
                        throw new RuntimeException("Invalid use of patternPathMotion element");
                    } else {
                        transition.a(new PatternPathMotion(this.mContext, attributeSet));
                        transition2 = transition3;
                    }
                    if (transition2 != null) {
                        if (!xmlPullParser.isEmptyElementTag()) {
                            a(xmlPullParser, attributeSet, transition2);
                        }
                        if (transitionSet != null) {
                            transitionSet.c(transition2);
                            transition3 = null;
                        } else if (transition != null) {
                            throw new InflateException("Could not add transition to another transition.");
                        }
                    }
                    transition3 = transition2;
                }
            }
        }
        return transition3;
    }

    private Object a(AttributeSet attributeSet, Class cls, String str) {
        Object newInstance;
        Class<? extends U> asSubclass;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        if (attributeValue == null) {
            throw new InflateException(str + " tag must have a 'class' attribute");
        }
        try {
            synchronized (CM) {
                Constructor<? extends U> constructor = CM.get(attributeValue);
                if (constructor == null && (asSubclass = this.mContext.getClassLoader().loadClass(attributeValue).asSubclass(cls)) != null) {
                    constructor = asSubclass.getConstructor(CL);
                    constructor.setAccessible(true);
                    CM.put(attributeValue, constructor);
                }
                newInstance = constructor.newInstance(this.mContext, attributeSet);
            }
            return newInstance;
        } catch (Exception e2) {
            throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e2);
        }
    }

    private void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                if (xmlPullParser.getName().equals("target")) {
                    TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, p.BQ);
                    int b2 = g.b(obtainStyledAttributes, xmlPullParser, "targetId", 1);
                    if (b2 != 0) {
                        transition.an(b2);
                    } else {
                        int b3 = g.b(obtainStyledAttributes, xmlPullParser, "excludeId", 2);
                        if (b3 != 0) {
                            transition.f(b3, true);
                        } else {
                            String c2 = g.c(obtainStyledAttributes, xmlPullParser, "targetName", 4);
                            if (c2 != null) {
                                transition.q(c2);
                            } else {
                                String c3 = g.c(obtainStyledAttributes, xmlPullParser, "excludeName", 5);
                                if (c3 != null) {
                                    transition.b(c3, true);
                                } else {
                                    String c4 = g.c(obtainStyledAttributes, xmlPullParser, "excludeClass", 3);
                                    if (c4 != null) {
                                        try {
                                            transition.a((Class) Class.forName(c4), true);
                                        } catch (ClassNotFoundException e2) {
                                            obtainStyledAttributes.recycle();
                                            throw new RuntimeException("Could not create ".concat(String.valueOf(c4)), e2);
                                        }
                                    } else {
                                        String c5 = g.c(obtainStyledAttributes, xmlPullParser, "targetClass", 0);
                                        if (c5 != null) {
                                            transition.h(Class.forName(c5));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    obtainStyledAttributes.recycle();
                } else {
                    throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                }
            }
        }
    }
}
