package android.support.d.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.a.g;
import android.support.v4.graphics.c;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class e {
    public static Animator a(Context context, Resources resources, Resources.Theme theme, int i2) {
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = resources.getAnimation(i2);
            Animator a2 = a(context, resources, theme, xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), null, 0, 1.0f);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            return a2;
        } catch (XmlPullParserException e2) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
            notFoundException.initCause(e2);
            throw notFoundException;
        } catch (IOException e3) {
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
            notFoundException2.initCause(e3);
            throw notFoundException2;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements TypeEvaluator<c.b[]> {
        private c.b[] xg;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public final /* synthetic */ c.b[] evaluate(float f2, c.b[] bVarArr, c.b[] bVarArr2) {
            c.b[] bVarArr3 = bVarArr;
            c.b[] bVarArr4 = bVarArr2;
            if (!c.a(bVarArr3, bVarArr4)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (this.xg == null || !c.a(this.xg, bVarArr3)) {
                this.xg = c.a(bVarArr3);
            }
            for (int i2 = 0; i2 < bVarArr3.length; i2++) {
                this.xg[i2].a(bVarArr3[i2], bVarArr4[i2], f2);
            }
            return this.xg;
        }

        a() {
        }
    }

    private static PropertyValuesHolder a(TypedArray typedArray, int i2, int i3, int i4, String str) {
        boolean z;
        PropertyValuesHolder propertyValuesHolder;
        int i5;
        int i6;
        int i7;
        float f2;
        float f3;
        float f4;
        TypedValue peekValue = typedArray.peekValue(i3);
        boolean z2 = peekValue != null;
        int i8 = z2 ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i4);
        boolean z3 = peekValue2 != null;
        int i9 = z3 ? peekValue2.type : 0;
        if (i2 == 4) {
            if ((!z2 || !al(i8)) && (!z3 || !al(i9))) {
                i2 = 0;
            } else {
                i2 = 3;
            }
        }
        if (i2 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (i2 == 2) {
            String string = typedArray.getString(i3);
            String string2 = typedArray.getString(i4);
            c.b[] y = c.y(string);
            c.b[] y2 = c.y(string2);
            if (!(y == null && y2 == null)) {
                if (y != null) {
                    a aVar = new a();
                    if (y2 == null) {
                        return PropertyValuesHolder.ofObject(str, aVar, y);
                    } else if (!c.a(y, y2)) {
                        throw new InflateException(" Can't morph from " + string + " to " + string2);
                    } else {
                        return PropertyValuesHolder.ofObject(str, aVar, y, y2);
                    }
                } else if (y2 != null) {
                    return PropertyValuesHolder.ofObject(str, new a(), y2);
                }
            }
            return null;
        }
        f fVar = null;
        if (i2 == 3) {
            fVar = f.dz();
        }
        if (z) {
            if (z2) {
                if (i8 == 5) {
                    f3 = typedArray.getDimension(i3, 0.0f);
                } else {
                    f3 = typedArray.getFloat(i3, 0.0f);
                }
                if (z3) {
                    if (i9 == 5) {
                        f4 = typedArray.getDimension(i4, 0.0f);
                    } else {
                        f4 = typedArray.getFloat(i4, 0.0f);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f3, f4);
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f3);
                }
            } else {
                if (i9 == 5) {
                    f2 = typedArray.getDimension(i4, 0.0f);
                } else {
                    f2 = typedArray.getFloat(i4, 0.0f);
                }
                propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f2);
            }
        } else if (z2) {
            if (i8 == 5) {
                i6 = (int) typedArray.getDimension(i3, 0.0f);
            } else if (al(i8)) {
                i6 = typedArray.getColor(i3, 0);
            } else {
                i6 = typedArray.getInt(i3, 0);
            }
            if (z3) {
                if (i9 == 5) {
                    i7 = (int) typedArray.getDimension(i4, 0.0f);
                } else if (al(i9)) {
                    i7 = typedArray.getColor(i4, 0);
                } else {
                    i7 = typedArray.getInt(i4, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i6, i7);
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i6);
            }
        } else if (z3) {
            if (i9 == 5) {
                i5 = (int) typedArray.getDimension(i4, 0.0f);
            } else if (al(i9)) {
                i5 = typedArray.getColor(i4, 0);
            } else {
                i5 = typedArray.getInt(i4, 0);
            }
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5);
        } else {
            propertyValuesHolder = null;
        }
        if (propertyValuesHolder == null || fVar == null) {
            return propertyValuesHolder;
        }
        propertyValuesHolder.setEvaluator(fVar);
        return propertyValuesHolder;
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f2, XmlPullParser xmlPullParser) {
        long a2 = (long) g.a(typedArray, xmlPullParser, FFmpegMetadataRetriever.METADATA_KEY_DURATION, 1, 300);
        long a3 = (long) g.a(typedArray, xmlPullParser, "startOffset", 2, 0);
        int a4 = g.a(typedArray, xmlPullParser, "valueType", 7, 4);
        if (g.a(xmlPullParser, "valueFrom") && g.a(xmlPullParser, "valueTo")) {
            if (a4 == 4) {
                TypedValue peekValue = typedArray.peekValue(5);
                boolean z = peekValue != null;
                int i2 = z ? peekValue.type : 0;
                TypedValue peekValue2 = typedArray.peekValue(6);
                boolean z2 = peekValue2 != null;
                int i3 = z2 ? peekValue2.type : 0;
                if ((!z || !al(i2)) && (!z2 || !al(i3))) {
                    a4 = 0;
                } else {
                    a4 = 3;
                }
            }
            PropertyValuesHolder a5 = a(typedArray, a4, 5, 6, "");
            if (a5 != null) {
                valueAnimator.setValues(a5);
            }
        }
        valueAnimator.setDuration(a2);
        valueAnimator.setStartDelay(a3);
        valueAnimator.setRepeatCount(g.a(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(g.a(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
            String c2 = g.c(typedArray2, xmlPullParser, "pathData", 1);
            if (c2 != null) {
                String c3 = g.c(typedArray2, xmlPullParser, "propertyXName", 2);
                String c4 = g.c(typedArray2, xmlPullParser, "propertyYName", 3);
                if (c3 == null && c4 == null) {
                    throw new InflateException(typedArray2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                a(c.x(c2), objectAnimator, 0.5f * f2, c3, c4);
                return;
            }
            objectAnimator.setPropertyName(g.c(typedArray2, xmlPullParser, "propertyName", 0));
        }
    }

    private static void a(Path path, ObjectAnimator objectAnimator, float f2, String str, String str2) {
        int i2;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float f3 = 0.0f;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        do {
            f3 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f3));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f3 / f2)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        int i3 = 0;
        float f4 = f3 / ((float) (min - 1));
        float f5 = 0.0f;
        int i4 = 0;
        while (i4 < min) {
            pathMeasure2.getPosTan(f5 - ((Float) arrayList.get(i3)).floatValue(), fArr3, null);
            fArr[i4] = fArr3[0];
            fArr2[i4] = fArr3[1];
            f5 += f4;
            if (i3 + 1 >= arrayList.size() || f5 <= ((Float) arrayList.get(i3 + 1)).floatValue()) {
                i2 = i3;
            } else {
                i2 = i3 + 1;
                pathMeasure2.nextContour();
            }
            i4++;
            i3 = i2;
        }
        PropertyValuesHolder propertyValuesHolder = null;
        PropertyValuesHolder propertyValuesHolder2 = null;
        if (str != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str, fArr);
        }
        if (str2 != null) {
            propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str2, fArr2);
        }
        if (propertyValuesHolder == null) {
            objectAnimator.setValues(propertyValuesHolder2);
        } else if (propertyValuesHolder2 == null) {
            objectAnimator.setValues(propertyValuesHolder);
        } else {
            objectAnimator.setValues(propertyValuesHolder, propertyValuesHolder2);
        }
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i2, float f2) {
        boolean z;
        ArrayList arrayList;
        ValueAnimator valueAnimator = null;
        ArrayList arrayList2 = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        valueAnimator = a(context, resources, theme, attributeSet, f2, xmlPullParser);
                        z = false;
                    } else if (name.equals("animator")) {
                        valueAnimator = a(context, resources, theme, attributeSet, null, f2, xmlPullParser);
                        z = false;
                    } else if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray a2 = g.a(resources, theme, attributeSet, a.wR);
                        a(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, g.a(a2, xmlPullParser, "ordering", 0, 0), f2);
                        a2.recycle();
                        z = false;
                        valueAnimator = animatorSet2;
                    } else if (name.equals("propertyValuesHolder")) {
                        PropertyValuesHolder[] a3 = a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                        if (!(a3 == null || valueAnimator == null || !(valueAnimator instanceof ValueAnimator))) {
                            valueAnimator.setValues(a3);
                        }
                        z = true;
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (animatorSet != null && !z) {
                        if (arrayList2 == null) {
                            arrayList = new ArrayList();
                        } else {
                            arrayList = arrayList2;
                        }
                        arrayList.add(valueAnimator);
                        arrayList2 = arrayList;
                    }
                }
            }
        }
        if (!(animatorSet == null || arrayList2 == null)) {
            Animator[] animatorArr = new Animator[arrayList2.size()];
            Iterator it = arrayList2.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                animatorArr[i3] = (Animator) it.next();
                i3++;
            }
            if (i2 == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return valueAnimator;
    }

    private static PropertyValuesHolder[] a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        ArrayList arrayList;
        PropertyValuesHolder propertyValuesHolder;
        PropertyValuesHolder propertyValuesHolder2;
        int size;
        int i2;
        int i3;
        int i4;
        ArrayList arrayList2 = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType != 3 && eventType != 1) {
                if (eventType != 2) {
                    xmlPullParser.next();
                } else {
                    if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                        TypedArray a2 = g.a(resources, theme, attributeSet, a.wS);
                        String c2 = g.c(a2, xmlPullParser, "propertyName", 3);
                        int a3 = g.a(a2, xmlPullParser, "valueType", 2, 4);
                        ArrayList arrayList3 = null;
                        int i5 = a3;
                        while (true) {
                            int next = xmlPullParser.next();
                            if (next != 3 && next != 1) {
                                if (xmlPullParser.getName().equals("keyframe")) {
                                    if (i5 == 4) {
                                        TypedArray a4 = g.a(resources, theme, Xml.asAttributeSet(xmlPullParser), a.wT);
                                        TypedValue a5 = g.a(a4, xmlPullParser, "value");
                                        if (!(a5 != null) || !al(a5.type)) {
                                            i4 = 0;
                                        } else {
                                            i4 = 3;
                                        }
                                        a4.recycle();
                                        i5 = i4;
                                    }
                                    TypedArray a6 = g.a(resources, theme, Xml.asAttributeSet(xmlPullParser), a.wT);
                                    Keyframe keyframe = null;
                                    float a7 = g.a(a6, xmlPullParser, "fraction", 3, -1.0f);
                                    TypedValue a8 = g.a(a6, xmlPullParser, "value");
                                    boolean z = a8 != null;
                                    if (i5 != 4) {
                                        i3 = i5;
                                    } else if (!z || !al(a8.type)) {
                                        i3 = 0;
                                    } else {
                                        i3 = 3;
                                    }
                                    if (z) {
                                        switch (i3) {
                                            case 0:
                                                keyframe = Keyframe.ofFloat(a7, g.a(a6, xmlPullParser, "value", 0, 0.0f));
                                                break;
                                            case 1:
                                            case 3:
                                                keyframe = Keyframe.ofInt(a7, g.a(a6, xmlPullParser, "value", 0, 0));
                                                break;
                                        }
                                    } else if (i3 == 0) {
                                        keyframe = Keyframe.ofFloat(a7);
                                    } else {
                                        keyframe = Keyframe.ofInt(a7);
                                    }
                                    int b2 = g.b(a6, xmlPullParser, "interpolator", 1);
                                    if (b2 > 0) {
                                        keyframe.setInterpolator(d.loadInterpolator(context, b2));
                                    }
                                    a6.recycle();
                                    if (keyframe != null) {
                                        if (arrayList3 == null) {
                                            arrayList3 = new ArrayList();
                                        }
                                        arrayList3.add(keyframe);
                                    }
                                    xmlPullParser.next();
                                }
                                arrayList3 = arrayList3;
                                i5 = i5;
                            } else if (arrayList3 != null || (size = arrayList3.size()) <= 0) {
                                propertyValuesHolder = null;
                            } else {
                                Keyframe keyframe2 = (Keyframe) arrayList3.get(0);
                                Keyframe keyframe3 = (Keyframe) arrayList3.get(size - 1);
                                float fraction = keyframe3.getFraction();
                                if (fraction >= 1.0f) {
                                    i2 = size;
                                } else if (fraction < 0.0f) {
                                    keyframe3.setFraction(1.0f);
                                    i2 = size;
                                } else {
                                    arrayList3.add(arrayList3.size(), a(keyframe3, 1.0f));
                                    i2 = size + 1;
                                }
                                float fraction2 = keyframe2.getFraction();
                                if (fraction2 != 0.0f) {
                                    if (fraction2 < 0.0f) {
                                        keyframe2.setFraction(0.0f);
                                    } else {
                                        arrayList3.add(0, a(keyframe2, 0.0f));
                                        i2++;
                                    }
                                }
                                Keyframe[] keyframeArr = new Keyframe[i2];
                                arrayList3.toArray(keyframeArr);
                                for (int i6 = 0; i6 < i2; i6++) {
                                    Keyframe keyframe4 = keyframeArr[i6];
                                    if (keyframe4.getFraction() < 0.0f) {
                                        if (i6 == 0) {
                                            keyframe4.setFraction(0.0f);
                                        } else if (i6 == i2 - 1) {
                                            keyframe4.setFraction(1.0f);
                                        } else {
                                            int i7 = i6 + 1;
                                            int i8 = i6;
                                            while (i7 < i2 - 1 && keyframeArr[i7].getFraction() < 0.0f) {
                                                i8 = i7;
                                                i7++;
                                            }
                                            a(keyframeArr, keyframeArr[i8 + 1].getFraction() - keyframeArr[i6 - 1].getFraction(), i6, i8);
                                        }
                                    }
                                }
                                propertyValuesHolder = PropertyValuesHolder.ofKeyframe(c2, keyframeArr);
                                if (i5 == 3) {
                                    propertyValuesHolder.setEvaluator(f.dz());
                                }
                            }
                        }
                        if (arrayList3 != null) {
                        }
                        propertyValuesHolder = null;
                        if (propertyValuesHolder == null) {
                            propertyValuesHolder2 = a(a2, a3, 0, 1, c2);
                        } else {
                            propertyValuesHolder2 = propertyValuesHolder;
                        }
                        if (propertyValuesHolder2 != null) {
                            if (arrayList2 == null) {
                                arrayList = new ArrayList();
                            } else {
                                arrayList = arrayList2;
                            }
                            arrayList.add(propertyValuesHolder2);
                        } else {
                            arrayList = arrayList2;
                        }
                        a2.recycle();
                    } else {
                        arrayList = arrayList2;
                    }
                    xmlPullParser.next();
                    arrayList2 = arrayList;
                }
            }
        }
        if (arrayList2 == null) {
            return null;
        }
        int size2 = arrayList2.size();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[size2];
        for (int i9 = 0; i9 < size2; i9++) {
            propertyValuesHolderArr[i9] = (PropertyValuesHolder) arrayList2.get(i9);
        }
        return propertyValuesHolderArr;
    }

    private static Keyframe a(Keyframe keyframe, float f2) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f2);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f2);
        }
        return Keyframe.ofObject(f2);
    }

    private static void a(Keyframe[] keyframeArr, float f2, int i2, int i3) {
        float f3 = f2 / ((float) ((i3 - i2) + 2));
        while (i2 <= i3) {
            keyframeArr[i2].setFraction(keyframeArr[i2 - 1].getFraction() + f3);
            i2++;
        }
    }

    private static ObjectAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f2, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        a(context, resources, theme, attributeSet, objectAnimator, f2, xmlPullParser);
        return objectAnimator;
    }

    private static ValueAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) {
        TypedArray a2 = g.a(resources, theme, attributeSet, a.wQ);
        TypedArray a3 = g.a(resources, theme, attributeSet, a.wU);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        a(valueAnimator, a2, a3, f2, xmlPullParser);
        int b2 = g.b(a2, xmlPullParser, "interpolator", 0);
        if (b2 > 0) {
            valueAnimator.setInterpolator(d.loadInterpolator(context, b2));
        }
        a2.recycle();
        if (a3 != null) {
            a3.recycle();
        }
        return valueAnimator;
    }

    private static boolean al(int i2) {
        return i2 >= 28 && i2 <= 31;
    }
}
