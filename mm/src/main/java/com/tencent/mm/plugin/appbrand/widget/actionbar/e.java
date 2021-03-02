package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public interface e {
    void destroy();

    View getActionView();

    int getBackgroundColor();

    void gz(boolean z);

    void setBackButtonClickListener(View.OnClickListener onClickListener);

    void setBackgroundColor(int i2);

    void setCloseButtonClickListener(View.OnClickListener onClickListener);

    void setForegroundColor(int i2);

    void setForegroundStyle(String str);

    void setLoadingIconVisibility(boolean z);

    void setMainTitle(CharSequence charSequence);

    public enum a {
        BLACK(WebView.NIGHT_MODE_COLOR),
        WHITE(-1);
        
        public final int omu;

        public static a valueOf(String str) {
            AppMethodBeat.i(219629);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(219629);
            return aVar;
        }

        static {
            AppMethodBeat.i(219631);
            AppMethodBeat.o(219631);
        }

        private a(int i2) {
            this.omu = i2;
        }

        public static a afW(String str) {
            AppMethodBeat.i(219630);
            if (!TextUtils.isEmpty(str)) {
                a[] values = values();
                for (a aVar : values) {
                    if (aVar.name().equalsIgnoreCase(str)) {
                        AppMethodBeat.o(219630);
                        return aVar;
                    }
                }
            }
            a aVar2 = WHITE;
            AppMethodBeat.o(219630);
            return aVar2;
        }

        public static a zP(int i2) {
            return i2 == -1 ? WHITE : BLACK;
        }
    }
}
