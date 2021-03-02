package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.k.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import junit.framework.Assert;

public final class c {
    a QhC;

    c(a aVar) {
        this.QhC = aVar;
    }

    public final int a(d dVar) {
        boolean z = true;
        AppMethodBeat.i(38770);
        Assert.assertTrue(dVar != null);
        if (dVar.QhE == null) {
            z = false;
        }
        Assert.assertTrue(z);
        Drawable a2 = a(this.QhC.Kaz, dVar.QhD.getContext());
        if (a2 == null) {
            AppMethodBeat.o(38770);
            return -1;
        }
        dVar.QhD.setBackgroundDrawable(a2);
        dVar.QhE.setVisibility(this.QhC.Kau ? 0 : 8);
        AppMethodBeat.o(38770);
        return 0;
    }

    private static Drawable a(Map<String, String> map, Context context) {
        Bitmap decodeFile;
        AppMethodBeat.i(38771);
        if (map == null || map.size() <= 0) {
            AppMethodBeat.o(38771);
            return null;
        }
        String str = map.get(BackwardSupportUtil.BitmapFactory.getDisplaySizeType(context));
        if (str == null) {
            str = map.get(BackwardSupportUtil.BitmapFactory.getDisplayDensityType(context));
        }
        if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(38771);
            return null;
        }
        a.EnumC2020a bel = a.bel(str);
        if (bel == a.EnumC2020a.ERROR) {
            AppMethodBeat.o(38771);
            return null;
        }
        String bek = a.bek(str);
        if (Util.nullAsNil(bek).length() <= 0) {
            AppMethodBeat.o(38771);
            return null;
        }
        try {
            if (bel == a.EnumC2020a.ASSET) {
                decodeFile = BackwardSupportUtil.BitmapFactory.decodeStream(context.getAssets().open(bek), com.tencent.mm.cb.a.getDensity(context));
            } else {
                decodeFile = BackwardSupportUtil.BitmapFactory.decodeFile(bek, com.tencent.mm.cb.a.getDensity(context));
            }
            if (decodeFile == null) {
                Log.e("MicroMsg.ADListView.Message", "get Bitmap failed type:" + bel + " path:" + bek);
                AppMethodBeat.o(38771);
                return null;
            }
            byte[] ninePatchChunk = decodeFile.getNinePatchChunk();
            if (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, displayMetrics.widthPixels, (displayMetrics.widthPixels * decodeFile.getHeight()) / decodeFile.getWidth(), true);
                if (createScaledBitmap != null) {
                    if (decodeFile != createScaledBitmap) {
                        Log.i("MicroMsg.ADListView.Message", "recycle bitmap:%s", decodeFile);
                        decodeFile.recycle();
                    }
                    decodeFile = createScaledBitmap;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(decodeFile);
                bitmapDrawable.setTargetDensity(displayMetrics);
                AppMethodBeat.o(38771);
                return bitmapDrawable;
            }
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(decodeFile, ninePatchChunk, new Rect(), null);
            AppMethodBeat.o(38771);
            return ninePatchDrawable;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ADListView.Message", e2, "", new Object[0]);
            AppMethodBeat.o(38771);
            return null;
        }
    }
}
