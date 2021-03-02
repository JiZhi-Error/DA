package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static ImageView a(Context context, PhotosContent photosContent, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        AppMethodBeat.i(202202);
        if (context == null || photosContent == null) {
            AppMethodBeat.o(202202);
            return null;
        }
        try {
            View childAt = photosContent.getChildAt(i2);
            if (childAt != null) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                ImageView imageView = new ImageView(context);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams);
                marginLayoutParams2.width = i3;
                marginLayoutParams2.height = i3;
                imageView.setImageDrawable(a.l(context, R.drawable.brd));
                imageView.setLayoutParams(marginLayoutParams2);
                AppMethodBeat.o(202202);
                return imageView;
            }
            Log.e("AddWeAppIconHelper", "getEachImageViewLayoutParams is null");
            AppMethodBeat.o(202202);
            return null;
        } catch (Throwable th) {
            Log.e("AddWeAppIconHelper", th.toString());
        }
    }
}
