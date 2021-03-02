package com.tencent.mm.plugin.appbrand.phonenumber;

import android.view.View;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManagerView;", "", "getView", "Landroid/view/View;", "updateView", "", "showDelete", "", "phoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "luggage-wechat-full-sdk_release"})
public interface p {
    void b(boolean z, List<PhoneItem> list);

    View getView();
}
