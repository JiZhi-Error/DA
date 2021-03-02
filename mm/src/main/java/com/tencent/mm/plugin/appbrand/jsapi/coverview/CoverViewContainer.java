package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView;
import com.tencent.mm.plugin.appbrand.page.bz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class CoverViewContainer extends AppBrandNativeContainerView implements g, bz {
    private static HashMap<Integer, CoverViewContainer> lSV = new HashMap<>();
    private View atQ;
    private float dsy;
    private float dsz;
    private float gPO;
    private float lSR;
    private float[] lSS;
    private int lST;
    private Paint lSU;
    public boolean lSW;
    public String lSX;
    private int lSY;
    private boolean lSZ;
    private String lTa;
    private long lTb;
    GradientDrawable lTc;
    float[] lTd;
    private a lTe;
    private int mBgColor;
    private View.OnClickListener mOnClickListener;
    private int mScreenHeight;
    private int mScreenWidth;
    private int viewId;

    public interface a {
        void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2);
    }

    static {
        AppMethodBeat.i(221236);
        AppMethodBeat.o(221236);
    }

    public CoverViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(140657);
        this.lSU = new Paint();
        this.lSW = false;
        this.lSX = "";
        this.lSZ = false;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.lTc = new GradientDrawable();
        this.lTd = new float[8];
        init();
        AppMethodBeat.o(140657);
    }

    public CoverViewContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(140658);
        this.lSU = new Paint();
        this.lSW = false;
        this.lSX = "";
        this.lSZ = false;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.lTc = new GradientDrawable();
        this.lTd = new float[8];
        init();
        AppMethodBeat.o(140658);
    }

    public void setTargetView(View view) {
        AppMethodBeat.i(140659);
        this.atQ = view;
        super.addView(view, 0, new ViewGroup.LayoutParams(-1, -1));
        AppMethodBeat.o(140659);
    }

    public CoverViewContainer(Context context, View view) {
        super(context);
        AppMethodBeat.i(140660);
        this.lSU = new Paint();
        this.lSW = false;
        this.lSX = "";
        this.lSZ = false;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.lTc = new GradientDrawable();
        this.lTd = new float[8];
        setTargetView(view);
        init();
        AppMethodBeat.o(140660);
    }

    private void init() {
        AppMethodBeat.i(140661);
        this.lSU.setStyle(Paint.Style.STROKE);
        this.lSU.setAntiAlias(true);
        setWillNotDraw(false);
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (this.mScreenWidth == 0) {
            this.mScreenWidth = windowManager.getDefaultDisplay().getWidth();
            this.mScreenHeight = windowManager.getDefaultDisplay().getHeight();
        }
        AppMethodBeat.o(140661);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bz
    public final boolean c(Canvas canvas) {
        AppMethodBeat.i(221226);
        if (getWidth() == 0 || getHeight() == 0) {
            AppMethodBeat.o(221226);
        } else {
            canvas.save();
            canvas.clipRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            draw(canvas);
            canvas.restore();
            AppMethodBeat.o(221226);
        }
        return true;
    }

    public void draw(Canvas canvas) {
        boolean z;
        float f2 = 0.0f;
        AppMethodBeat.i(140662);
        if (this.lSS == null || this.lSS.length <= 0) {
            boolean z2 = this.lSR > 0.0f;
            if (z2) {
                canvas.save();
                Path path = new Path();
                path.addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), this.lSR, this.lSR, Path.Direction.CW);
                canvas.clipPath(path);
            }
            if (this.mBgColor != 0) {
                canvas.drawColor(this.mBgColor);
            }
            if (this.gPO > 0.0f) {
                float f3 = this.gPO / 2.0f;
                canvas.drawRoundRect(new RectF(f3, f3, ((float) getWidth()) - f3, ((float) getHeight()) - f3), this.lSR, this.lSR, this.lSU);
                if (z2) {
                    canvas.restore();
                }
                canvas.save();
                Path path2 = new Path();
                if (this.lSR > 0.0f && this.lSR - this.gPO > 0.0f) {
                    f2 = this.lSR - this.gPO;
                }
                path2.addRoundRect(new RectF(this.gPO, this.gPO, ((float) getWidth()) - this.gPO, ((float) getHeight()) - this.gPO), f2, f2, Path.Direction.CW);
                canvas.clipPath(path2);
                z = true;
            } else {
                z = z2;
            }
            super.draw(canvas);
            if (z) {
                canvas.restore();
            }
            AppMethodBeat.o(140662);
            return;
        }
        super.draw(canvas);
        AppMethodBeat.o(140662);
    }

    public final <T> T aB(Class<T> cls) {
        AppMethodBeat.i(140663);
        try {
            if (cls.isAssignableFrom(this.atQ.getClass())) {
                T t = (T) this.atQ;
                AppMethodBeat.o(140663);
                return t;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(140663);
        return null;
    }

    private Drawable getShadowDrawable() {
        AppMethodBeat.i(221227);
        if (this.mBgColor != 0) {
            this.lTc.setColor(this.mBgColor);
        }
        this.lTd[0] = this.lSS[0];
        this.lTd[1] = this.lSS[0];
        this.lTd[2] = this.lSS[1];
        this.lTd[3] = this.lSS[1];
        this.lTd[4] = this.lSS[3];
        this.lTd[5] = this.lSS[3];
        this.lTd[6] = this.lSS[2];
        this.lTd[7] = this.lSS[2];
        this.lTc.setCornerRadii(this.lTd);
        if (this.gPO > 0.0f && this.lST != 0) {
            this.lTc.setStroke((int) this.gPO, this.lST);
        }
        GradientDrawable gradientDrawable = this.lTc;
        AppMethodBeat.o(221227);
        return gradientDrawable;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        AppMethodBeat.i(140664);
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > getChildCount() - 1) {
            i2 = getChildCount() - 1;
        }
        super.addView(view, i2 + 1);
        AppMethodBeat.o(140664);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(140665);
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > getChildCount() - 1) {
            i2 = getChildCount() - 1;
        }
        super.addView(view, i2 + 1, layoutParams);
        AppMethodBeat.o(140665);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.g
    public void setBorderRadius(float f2) {
        this.lSR = f2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.g
    public void setBorderRadius(float[] fArr) {
        AppMethodBeat.i(221228);
        this.lSS = fArr;
        if (this.lSS != null && this.lSS.length > 0) {
            setBackground(getShadowDrawable());
        }
        AppMethodBeat.o(221228);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.g
    public void setBorderColor(int i2) {
        AppMethodBeat.i(140666);
        this.lST = i2;
        this.lSU.setColor(i2);
        AppMethodBeat.o(140666);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.g
    public void setBorderWidth(float f2) {
        AppMethodBeat.i(140667);
        this.gPO = f2;
        this.lSU.setStrokeWidth(f2);
        AppMethodBeat.o(140667);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.g
    public void setBgColor(int i2) {
        this.mBgColor = i2;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(140668);
        boolean contains = cu(this).contains(motionEvent.getRawX(), motionEvent.getRawY());
        if (motionEvent.getActionMasked() != 0 || K(motionEvent.getX(), motionEvent.getY()) || contains) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(140668);
            return dispatchTouchEvent;
        }
        AppMethodBeat.o(140668);
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean K(float f2, float f3) {
        AppMethodBeat.i(140669);
        if (this.lSR <= 0.0f) {
            AppMethodBeat.o(140669);
            return true;
        }
        double pow = Math.pow((double) this.lSR, 2.0d);
        float width = (float) getWidth();
        float height = (float) getHeight();
        if (f2 < this.lSR) {
            if (f3 < this.lSR) {
                if (Math.pow((double) (this.lSR - f2), 2.0d) + Math.pow((double) (this.lSR - f3), 2.0d) > pow) {
                    AppMethodBeat.o(140669);
                    return false;
                }
            } else if (f3 > height - this.lSR) {
                if (Math.pow((double) ((this.lSR + f3) - height), 2.0d) + Math.pow((double) (this.lSR - f2), 2.0d) > pow) {
                    AppMethodBeat.o(140669);
                    return false;
                }
            }
        } else if (f2 > width - this.lSR) {
            if (f3 < this.lSR) {
                if (Math.pow((double) ((this.lSR + f2) - width), 2.0d) + Math.pow((double) (this.lSR - f3), 2.0d) > pow) {
                    AppMethodBeat.o(140669);
                    return false;
                }
            } else if (f3 > height - this.lSR) {
                if (Math.pow((double) ((this.lSR + f3) - height), 2.0d) + Math.pow((double) ((this.lSR + f2) - width), 2.0d) > pow) {
                    AppMethodBeat.o(140669);
                    return false;
                }
            }
        }
        AppMethodBeat.o(140669);
        return true;
    }

    public static RectF cu(View view) {
        AppMethodBeat.i(140670);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        RectF rectF = new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + view.getWidth()), (float) (iArr[1] + view.getHeight()));
        AppMethodBeat.o(140670);
        return rectF;
    }

    public boolean bGj() {
        return false;
    }

    public final void a(boolean z, int i2, String str) {
        AppMethodBeat.i(221229);
        this.lSW = z;
        this.viewId = i2;
        if (z) {
            this.lSX = str;
            lSV.put(Integer.valueOf(i2), this);
            AppMethodBeat.o(221229);
            return;
        }
        lSV.remove(Integer.valueOf(i2));
        AppMethodBeat.o(221229);
    }

    public static void xb(int i2) {
        AppMethodBeat.i(221230);
        lSV.remove(Integer.valueOf(i2));
        AppMethodBeat.o(221230);
    }

    public final void eb(int i2, int i3) {
        this.viewId = i2;
        this.lSY = i3;
    }

    public void setIsInterceptEvent(boolean z) {
        this.lSZ = z;
    }

    public void setDragConfig(String str) {
        this.lTa = str;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2 = 0;
        AppMethodBeat.i(221231);
        Log.d("MicroMsg.CoverViewContainer", "event: " + motionEvent.getAction());
        CoverViewContainer coverViewContainer = null;
        if (this.lSW) {
            coverViewContainer = this;
        } else if (this.lSY > 0) {
            coverViewContainer = lSV.get(Integer.valueOf(this.lSY));
        }
        if (this.lSW || (this.lSZ && a(coverViewContainer, this))) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.dsy = motionEvent.getRawX();
                    this.dsz = motionEvent.getRawY();
                    this.lTb = System.currentTimeMillis();
                    if (coverViewContainer != null) {
                        a("start", coverViewContainer, motionEvent);
                        break;
                    }
                    break;
                case 1:
                    long currentTimeMillis = System.currentTimeMillis() - this.lTb;
                    if (this.lTb != 0 && currentTimeMillis < 300 && currentTimeMillis >= 0 && this.mOnClickListener != null) {
                        this.mOnClickListener.onClick(this);
                    }
                    if (coverViewContainer != null) {
                        a("end", coverViewContainer, motionEvent);
                        break;
                    }
                    break;
                case 2:
                    float rawX = motionEvent.getRawX() - this.dsy;
                    float rawY = motionEvent.getRawY() - this.dsz;
                    if (coverViewContainer != null && (Math.abs(rawX) > 1.0f || Math.abs(rawY) > 1.0f)) {
                        int x = (int) (rawX + coverViewContainer.getX());
                        int y = (int) (rawY + coverViewContainer.getY());
                        if (x < 0) {
                            x = 0;
                        } else if (coverViewContainer.getWidth() + x > this.mScreenWidth) {
                            x = this.mScreenWidth - coverViewContainer.getWidth();
                        }
                        coverViewContainer.setX((float) x);
                        if (y >= 0) {
                            if (coverViewContainer.getHeight() + y > this.mScreenHeight) {
                                i2 = this.mScreenHeight - coverViewContainer.getHeight();
                            } else {
                                i2 = y;
                            }
                        }
                        coverViewContainer.setY((float) i2);
                        this.dsy = motionEvent.getRawX();
                        this.dsz = motionEvent.getRawY();
                        a("dragging", coverViewContainer, motionEvent);
                        break;
                    }
            }
            AppMethodBeat.o(221231);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(221231);
        return onTouchEvent;
    }

    public void setOnCustomerClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setDragEventCallback(a aVar) {
        this.lTe = aVar;
    }

    private boolean a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        AppMethodBeat.i(221232);
        if (viewGroup == viewGroup2) {
            AppMethodBeat.o(221232);
            return false;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt == viewGroup2) {
                AppMethodBeat.o(221232);
                return true;
            } else if ((childAt instanceof ViewGroup) && a((ViewGroup) childAt, viewGroup2)) {
                AppMethodBeat.o(221232);
                return true;
            }
        }
        AppMethodBeat.o(221232);
        return false;
    }

    private void a(String str, CoverViewContainer coverViewContainer, MotionEvent motionEvent) {
        AppMethodBeat.i(221233);
        if (this.lTe != null) {
            this.lTe.a(str, coverViewContainer.lSX, O(coverViewContainer, coverViewContainer.viewId), y(motionEvent));
        }
        AppMethodBeat.o(221233);
    }

    private static JSONObject O(View view, int i2) {
        AppMethodBeat.i(221234);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewId", i2);
            jSONObject.put("left", (double) com.tencent.mm.plugin.appbrand.ac.g.aS(view.getX()));
            jSONObject.put("top", (double) com.tencent.mm.plugin.appbrand.ac.g.aS(view.getY()));
            AppMethodBeat.o(221234);
            return jSONObject;
        } catch (JSONException e2) {
            AppMethodBeat.o(221234);
            return null;
        }
    }

    private JSONObject y(MotionEvent motionEvent) {
        AppMethodBeat.i(221235);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewId", this.viewId);
            jSONObject.put("x", (double) com.tencent.mm.plugin.appbrand.ac.g.aS(motionEvent.getRawX()));
            jSONObject.put("y", (double) com.tencent.mm.plugin.appbrand.ac.g.aS(motionEvent.getRawY()));
            AppMethodBeat.o(221235);
            return jSONObject;
        } catch (JSONException e2) {
            AppMethodBeat.o(221235);
            return null;
        }
    }
}
