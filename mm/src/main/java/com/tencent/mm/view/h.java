package com.tencent.mm.view;

import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0001\u0014J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\nH&¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/view/IMediaBannerIndicator;", "", "getCount", "", "getCurrentIndex", "getOnSelectedPageListener", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "getView", "Landroid/view/View;", "isShowOnlyOneIndicator", "", "setCount", "", "count", "setCurrentIndex", FirebaseAnalytics.b.INDEX, "setOnSelectedPageListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setShowOnlyOneIndicator", "isShow", "OnSelectedPageListener", "libmmui_release"})
public interface h {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "", "onSelected", "", FirebaseAnalytics.b.INDEX, "", "libmmui_release"})
    public interface a {
        void Ir(int i2);
    }

    int getCount();

    View getView();

    void setCount(int i2);

    void setCurrentIndex(int i2);

    void setOnSelectedPageListener(a aVar);

    void setShowOnlyOneIndicator(boolean z);
}
