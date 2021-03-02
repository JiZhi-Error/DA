package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.a.b;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/IAppBrandPreloadedWidgetProvider;", "Lcom/tencent/luggage/base/ICustomize;", "getPreloadedWidget", "WIDGET", "Landroid/view/View;", "clazz", "Ljava/lang/Class;", "ctx", "Landroid/content/Context;", "(Ljava/lang/Class;Landroid/content/Context;)Landroid/view/View;", "luggage-wxa-app_release"})
public interface ba extends b {
    <WIDGET extends View> WIDGET a(Class<WIDGET> cls, Context context);
}
