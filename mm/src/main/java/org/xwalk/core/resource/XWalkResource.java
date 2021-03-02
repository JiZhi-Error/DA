package org.xwalk.core.resource;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class XWalkResource extends Resources {
    private WeakReference<Context> mWeChatContext;

    public XWalkResource(Resources resources, Context context) {
        super(resources.getAssets(), context.getResources().getDisplayMetrics(), resources.getConfiguration());
        AppMethodBeat.i(155344);
        this.mWeChatContext = new WeakReference<>(context);
        AppMethodBeat.o(155344);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(155345);
        super.updateConfiguration(configuration, getDisplayMetrics());
        AppMethodBeat.o(155345);
    }

    public DisplayMetrics getDisplayMetrics() {
        AppMethodBeat.i(155346);
        Context context = this.mWeChatContext.get();
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            AppMethodBeat.o(155346);
            return displayMetrics;
        }
        DisplayMetrics displayMetrics2 = super.getDisplayMetrics();
        AppMethodBeat.o(155346);
        return displayMetrics2;
    }
}
