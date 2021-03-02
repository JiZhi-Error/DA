package com.tencent.mapsdk.raster.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mapsdk.rastercore.core.MapContext;
import com.tencent.mapsdk.rastercore.tools.IO;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class BitmapDescriptorFactory {
    public static BitmapDescriptor fromResource(int i2) {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2;
        BitmapDescriptor bitmapDescriptor = null;
        AppMethodBeat.i(87523);
        try {
            Context context = MapContext.getContext();
            if (context != null) {
                inputStream2 = context.getResources().openRawResource(i2);
                try {
                    bitmapDescriptor = fromBitmap(BitmapFactory.decodeStream(inputStream2));
                    IO.safeClose(inputStream2);
                    AppMethodBeat.o(87523);
                } catch (Exception e2) {
                    IO.safeClose(inputStream2);
                    AppMethodBeat.o(87523);
                    return bitmapDescriptor;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    IO.safeClose(inputStream);
                    AppMethodBeat.o(87523);
                    throw th;
                }
            } else {
                IO.safeClose(null);
                AppMethodBeat.o(87523);
            }
        } catch (Exception e3) {
            inputStream2 = null;
            IO.safeClose(inputStream2);
            AppMethodBeat.o(87523);
            return bitmapDescriptor;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            IO.safeClose(inputStream);
            AppMethodBeat.o(87523);
            throw th;
        }
        return bitmapDescriptor;
    }

    public static BitmapDescriptor fromView(View view) {
        BitmapDescriptor bitmapDescriptor = null;
        AppMethodBeat.i(87524);
        try {
            Context context = MapContext.getContext();
            if (context != null) {
                FrameLayout frameLayout = new FrameLayout(context);
                frameLayout.addView(view);
                frameLayout.destroyDrawingCache();
                bitmapDescriptor = fromBitmap(getViewBitmap(frameLayout));
                AppMethodBeat.o(87524);
            } else {
                AppMethodBeat.o(87524);
            }
        } catch (Exception e2) {
            AppMethodBeat.o(87524);
        }
        return bitmapDescriptor;
    }

    private static Bitmap getViewBitmap(View view) {
        AppMethodBeat.i(87525);
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap copy = view.getDrawingCache().copy(Bitmap.Config.ARGB_8888, false);
        AppMethodBeat.o(87525);
        return copy;
    }

    public static BitmapDescriptor fromPath(String str) {
        AppMethodBeat.i(87526);
        try {
            BitmapDescriptor fromBitmap = fromBitmap(BitmapFactory.decodeFile(str));
            AppMethodBeat.o(87526);
            return fromBitmap;
        } catch (Exception e2) {
            AppMethodBeat.o(87526);
            return null;
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        AppMethodBeat.i(87527);
        try {
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/".concat(String.valueOf(str)));
            Bitmap decodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
            AppMethodBeat.o(87527);
            return fromBitmap;
        } catch (Exception e2) {
            AppMethodBeat.o(87527);
            return null;
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        AppMethodBeat.i(87528);
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
            BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
            AppMethodBeat.o(87528);
            return fromBitmap;
        } catch (Exception e2) {
            AppMethodBeat.o(87528);
            return null;
        }
    }

    public static BitmapDescriptor defaultMarker() {
        AppMethodBeat.i(87529);
        BitmapDescriptor fromAsset = fromAsset("marker.png");
        AppMethodBeat.o(87529);
        return fromAsset;
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        AppMethodBeat.i(87530);
        if (bitmap == null) {
            AppMethodBeat.o(87530);
            return null;
        }
        BitmapDescriptor bitmapDescriptor = new BitmapDescriptor(bitmap);
        AppMethodBeat.o(87530);
        return bitmapDescriptor;
    }
}
