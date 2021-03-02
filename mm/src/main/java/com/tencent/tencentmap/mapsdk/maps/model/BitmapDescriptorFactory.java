package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static AtomicInteger sAttachIndex = new AtomicInteger(0);
    private static List<TencentMapContext> sTencentMapContextList = new CopyOnWriteArrayList();

    private BitmapDescriptorFactory() {
    }

    static {
        AppMethodBeat.i(193606);
        AppMethodBeat.o(193606);
    }

    public static void attachMapContext(TencentMapContext tencentMapContext) {
        AppMethodBeat.i(181049);
        if (!sTencentMapContextList.contains(tencentMapContext)) {
            sTencentMapContextList.add(tencentMapContext);
            sAttachIndex.incrementAndGet();
        }
        AppMethodBeat.o(181049);
    }

    public static void detachMapContext(TencentMapContext tencentMapContext) {
        AppMethodBeat.i(193604);
        if (sTencentMapContextList.remove(tencentMapContext)) {
            sAttachIndex.decrementAndGet();
        }
        AppMethodBeat.o(193604);
    }

    private static TencentMapContext getActiveMapContext() {
        AppMethodBeat.i(193605);
        int i2 = sAttachIndex.get();
        if (i2 <= 0 || i2 > sTencentMapContextList.size()) {
            AppMethodBeat.o(193605);
            return null;
        }
        TencentMapContext tencentMapContext = sTencentMapContextList.get(i2 - 1);
        AppMethodBeat.o(193605);
        return tencentMapContext;
    }

    public static BitmapDescriptor fromResource(int i2) {
        AppMethodBeat.i(173083);
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            BitmapDescriptor fromResource = fromResource(activeMapContext, i2);
            AppMethodBeat.o(173083);
            return fromResource;
        }
        AppMethodBeat.o(173083);
        return null;
    }

    public static BitmapDescriptor fromAsset(String str) {
        AppMethodBeat.i(173084);
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            BitmapDescriptor fromAsset = fromAsset(activeMapContext, str);
            AppMethodBeat.o(173084);
            return fromAsset;
        }
        AppMethodBeat.o(173084);
        return null;
    }

    public static BitmapDescriptor fromFile(String str) {
        AppMethodBeat.i(173085);
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            BitmapDescriptor fromFile = fromFile(activeMapContext, str);
            AppMethodBeat.o(173085);
            return fromFile;
        }
        AppMethodBeat.o(173085);
        return null;
    }

    public static BitmapDescriptor fromPath(String str) {
        AppMethodBeat.i(173086);
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            BitmapDescriptor fromPath = fromPath(activeMapContext, str);
            AppMethodBeat.o(173086);
            return fromPath;
        }
        AppMethodBeat.o(173086);
        return null;
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        AppMethodBeat.i(173089);
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            BitmapDescriptor fromBitmap = fromBitmap(activeMapContext, bitmap);
            AppMethodBeat.o(173089);
            return fromBitmap;
        }
        AppMethodBeat.o(173089);
        return null;
    }

    public static BitmapDescriptor fromView(View view) {
        AppMethodBeat.i(173090);
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            BitmapDescriptor fromView = fromView(activeMapContext, view);
            AppMethodBeat.o(173090);
            return fromView;
        }
        AppMethodBeat.o(173090);
        return null;
    }

    public static BitmapDescriptor defaultMarker() {
        AppMethodBeat.i(173087);
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            BitmapDescriptor defaultMarker = defaultMarker(activeMapContext);
            AppMethodBeat.o(173087);
            return defaultMarker;
        }
        AppMethodBeat.o(173087);
        return null;
    }

    public static BitmapDescriptor defaultMarker(float f2) {
        AppMethodBeat.i(173088);
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            BitmapDescriptor defaultMarker = defaultMarker(activeMapContext, f2);
            AppMethodBeat.o(173088);
            return defaultMarker;
        }
        AppMethodBeat.o(173088);
        return null;
    }

    public static BitmapDescriptor fromResource(TencentMapContext tencentMapContext, int i2) {
        AppMethodBeat.i(181050);
        BitmapDescriptor createBitmapDescriptor = tencentMapContext.createBitmapDescriptor(i2, 1);
        AppMethodBeat.o(181050);
        return createBitmapDescriptor;
    }

    public static BitmapDescriptor fromAsset(TencentMapContext tencentMapContext, String str) {
        AppMethodBeat.i(181051);
        BitmapDescriptor createBitmapDescriptor = tencentMapContext.createBitmapDescriptor(str, 2);
        AppMethodBeat.o(181051);
        return createBitmapDescriptor;
    }

    public static BitmapDescriptor fromFile(TencentMapContext tencentMapContext, String str) {
        AppMethodBeat.i(181052);
        BitmapDescriptor createBitmapDescriptor = tencentMapContext.createBitmapDescriptor(str, 3);
        AppMethodBeat.o(181052);
        return createBitmapDescriptor;
    }

    public static BitmapDescriptor fromPath(TencentMapContext tencentMapContext, String str) {
        AppMethodBeat.i(181053);
        BitmapDescriptor createBitmapDescriptor = tencentMapContext.createBitmapDescriptor(str, 4);
        AppMethodBeat.o(181053);
        return createBitmapDescriptor;
    }

    public static BitmapDescriptor defaultMarker(TencentMapContext tencentMapContext) {
        AppMethodBeat.i(181054);
        BitmapDescriptor createBitmapDescriptor = tencentMapContext.createBitmapDescriptor(5);
        AppMethodBeat.o(181054);
        return createBitmapDescriptor;
    }

    public static BitmapDescriptor defaultMarker(TencentMapContext tencentMapContext, float f2) {
        AppMethodBeat.i(181055);
        BitmapDescriptor createBitmapDescriptor = tencentMapContext.createBitmapDescriptor(f2, 6);
        AppMethodBeat.o(181055);
        return createBitmapDescriptor;
    }

    public static BitmapDescriptor fromBitmap(TencentMapContext tencentMapContext, Bitmap bitmap) {
        AppMethodBeat.i(181056);
        if (bitmap == null) {
            AppMethodBeat.o(181056);
            return null;
        }
        BitmapDescriptor createBitmapDescriptor = tencentMapContext.createBitmapDescriptor(createBitmapFromBitmap(bitmap), 7);
        AppMethodBeat.o(181056);
        return createBitmapDescriptor;
    }

    private static Bitmap createBitmapFromBitmap(Bitmap bitmap) {
        AppMethodBeat.i(181057);
        Bitmap bitmap2 = null;
        try {
            bitmap2 = Bitmap.createBitmap(bitmap);
        } catch (OutOfMemoryError e2) {
        }
        AppMethodBeat.o(181057);
        return bitmap2;
    }

    public static BitmapDescriptor fromView(TencentMapContext tencentMapContext, View view) {
        AppMethodBeat.i(181058);
        if (view == null) {
            AppMethodBeat.o(181058);
            return null;
        }
        try {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache = view.getDrawingCache();
            BitmapDescriptor fromBitmap = fromBitmap(tencentMapContext, drawingCache);
            if (drawingCache != null) {
                drawingCache.recycle();
            }
            view.destroyDrawingCache();
            AppMethodBeat.o(181058);
            return fromBitmap;
        } catch (Exception e2) {
            AppMethodBeat.o(181058);
            return null;
        }
    }
}
