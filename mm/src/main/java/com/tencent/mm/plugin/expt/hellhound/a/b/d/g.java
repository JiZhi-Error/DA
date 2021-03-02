package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.expt.hellhound.a.a.a.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J.\u0010\u0017\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020!H\u0002J\u001a\u0010\"\u001a\u00020!2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010#\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ProfileParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "dataList_field", "Ljava/lang/reflect/Field;", "feedLoaderRef", "Ljava/lang/ref/WeakReference;", "", "feedObject_field", "feedObject_item_field", "id_field", "mActivityRef", "nickname_field", "sessionBuffer_field", "username_field", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedItem", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "initParams", "", "isAd", "setRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-expt_release"})
public final class g implements b {
    public static final a sHr = new a((byte) 0);
    private WeakReference<Activity> mActivityRef;
    private Field sHj;
    private WeakReference<Object> sHk;
    private Field sHl;
    private Field sHm;
    private Field sHn;
    private Field sHo;
    private Field sHp;
    private Field sHq;

    static {
        AppMethodBeat.i(221090);
        AppMethodBeat.o(221090);
    }

    public g(Activity activity) {
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(221089);
        this.mActivityRef = new WeakReference<>(activity);
        AppMethodBeat.o(221089);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ProfileParamsCatcher$Companion;", "", "()V", "ACTIVITY_BASE_NAME", "", "BaseFinderFeed_NAME", "COMPONENT_BASE_NAME", "DataStore_NAME", "FeedObject_NAME", "FinderItem_NAME", "FinderProfileFeedFragment_NAME", "FinderProfileFeedUIC_NAME", "FinderTabProvider_NAME", "FinderTabUIC_NAME", "TAG", "dataList_field_name", "feedLoader_method_name", "feedObject_field_name", "feedObject_field_name_of_item", "fragments_field_name", "id_field_name", "mainUIC_field_name", "mainUIC_frag_field_name", "nickname_field_name", "sessionBuffer_field_name", "tabProvider_field_name", "username_field_name", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final boolean cPt() {
        Activity activity;
        AppMethodBeat.i(221083);
        if (this.sHk != null) {
            WeakReference<Object> weakReference = this.sHk;
            if ((weakReference != null ? weakReference.get() : null) != null) {
                AppMethodBeat.o(221083);
                return true;
            }
        }
        if (this.mActivityRef != null) {
            WeakReference<Activity> weakReference2 = this.mActivityRef;
            if (weakReference2 != null) {
                activity = weakReference2.get();
            } else {
                activity = null;
            }
            if (activity != null) {
                try {
                    Class<?> cls = Class.forName("com.tencent.mm.ui.component.UIComponentActivity");
                    p.g(cls, "Class.forName(ACTIVITY_BASE_NAME)");
                    Field declaredField = cls.getDeclaredField("mainUIC");
                    p.g(declaredField, "UIComponentActivity_Clas…Field(mainUIC_field_name)");
                    declaredField.setAccessible(true);
                    WeakReference<Activity> weakReference3 = this.mActivityRef;
                    Object obj = declaredField.get(weakReference3 != null ? weakReference3.get() : null);
                    Class<?> cls2 = Class.forName("com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC");
                    p.g(cls2, "Class.forName(FinderTabUIC_NAME)");
                    Field declaredField2 = cls2.getDeclaredField("tabProvider");
                    p.g(declaredField2, "FinderTabUIC_Class.getDe…d(tabProvider_field_name)");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(obj);
                    Class<?> cls3 = Class.forName("com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider");
                    p.g(cls3, "Class.forName(FinderTabProvider_NAME)");
                    Field declaredField3 = cls3.getDeclaredField("fragments");
                    p.g(declaredField3, "FinderTabProvider_Class.…eld(fragments_field_name)");
                    declaredField3.setAccessible(true);
                    Object obj3 = declaredField3.get(obj2);
                    if (obj3 == null) {
                        t tVar = new t("null cannot be cast to non-null type java.util.LinkedList<*>");
                        AppMethodBeat.o(221083);
                        throw tVar;
                    }
                    Class<?> cls4 = Class.forName("com.tencent.mm.plugin.finder.profile.FinderProfileFeedFragment");
                    p.g(cls4, "Class.forName(FinderProfileFeedFragment_NAME)");
                    Iterator it = ((LinkedList) obj3).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (cls4.isInstance(next)) {
                            Class<?> cls5 = Class.forName("com.tencent.mm.ui.component.UIComponentFragment");
                            p.g(cls5, "Class.forName(COMPONENT_BASE_NAME)");
                            Field declaredField4 = cls5.getDeclaredField("mainUIC");
                            p.g(declaredField4, "COMPONENT_Class.getDecla…(mainUIC_frag_field_name)");
                            declaredField4.setAccessible(true);
                            Object obj4 = declaredField4.get(next);
                            Class<?> cls6 = Class.forName("com.tencent.mm.plugin.finder.profile.uic.FinderProfileFeedUIC");
                            p.g(cls6, "Class.forName(FinderProfileFeedUIC_NAME)");
                            Method declaredMethod = cls6.getDeclaredMethod("getFeedLoader", new Class[0]);
                            p.g(declaredMethod, "FinderProfileFeedUIC_Cla…d(feedLoader_method_name)");
                            declaredMethod.setAccessible(true);
                            this.sHk = new WeakReference<>(declaredMethod.invoke(obj4, new Object[0]));
                            Class<?> cls7 = Class.forName("com.tencent.mm.plugin.finder.feed.model.internal.DataStore");
                            p.g(cls7, "Class.forName(DataStore_NAME)");
                            Field declaredField5 = cls7.getDeclaredField("dataList");
                            p.g(declaredField5, "DataStore_Class.getDecla…ield(dataList_field_name)");
                            this.sHj = declaredField5;
                            Field field = this.sHj;
                            if (field == null) {
                                p.btv("dataList_field");
                            }
                            field.setAccessible(true);
                            Class<?> cls8 = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                            p.g(cls8, "Class.forName(BaseFinderFeed_NAME)");
                            Field declaredField6 = cls8.getDeclaredField("feedObject");
                            p.g(declaredField6, "BaseFinderFeed_Class.get…ld(feedObject_field_name)");
                            this.sHl = declaredField6;
                            Field field2 = this.sHl;
                            if (field2 == null) {
                                p.btv("feedObject_field");
                            }
                            field2.setAccessible(true);
                            Class<?> cls9 = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
                            p.g(cls9, "Class.forName(FinderItem_NAME)");
                            Field declaredField7 = cls9.getDeclaredField("feedObject");
                            p.g(declaredField7, "finderItem_Class.getDecl…bject_field_name_of_item)");
                            this.sHm = declaredField7;
                            Field field3 = this.sHm;
                            if (field3 == null) {
                                p.btv("feedObject_item_field");
                            }
                            field3.setAccessible(true);
                            Class<?> cls10 = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
                            p.g(cls10, "Class.forName(FeedObject_NAME)");
                            Field declaredField8 = cls10.getDeclaredField("id");
                            p.g(declaredField8, "FinderObject_NAME.getDeclaredField(id_field_name)");
                            this.sHn = declaredField8;
                            Field field4 = this.sHn;
                            if (field4 == null) {
                                p.btv("id_field");
                            }
                            field4.setAccessible(true);
                            Field declaredField9 = cls10.getDeclaredField(ch.COL_USERNAME);
                            p.g(declaredField9, "FinderObject_NAME.getDec…ield(username_field_name)");
                            this.sHp = declaredField9;
                            Field field5 = this.sHp;
                            if (field5 == null) {
                                p.btv("username_field");
                            }
                            field5.setAccessible(true);
                            Field declaredField10 = cls10.getDeclaredField("nickname");
                            p.g(declaredField10, "FinderObject_NAME.getDec…ield(nickname_field_name)");
                            this.sHo = declaredField10;
                            Field field6 = this.sHo;
                            if (field6 == null) {
                                p.btv("nickname_field");
                            }
                            field6.setAccessible(true);
                            Field declaredField11 = cls10.getDeclaredField("sessionBuffer");
                            p.g(declaredField11, "FinderObject_NAME.getDec…sessionBuffer_field_name)");
                            this.sHq = declaredField11;
                            Field field7 = this.sHq;
                            if (field7 == null) {
                                p.btv("sessionBuffer_field");
                            }
                            field7.setAccessible(true);
                        }
                    }
                    AppMethodBeat.o(221083);
                    return true;
                } catch (Exception e2) {
                    Log.e("HABBYGE-MALI.ProfileParamsCatcher", "init, reflect exception: " + e2.getMessage());
                    AppMethodBeat.o(221083);
                    return false;
                }
            }
        }
        AppMethodBeat.o(221083);
        return false;
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String ac(View view, int i2) {
        AppMethodBeat.i(221084);
        Object Hh = Hh(i2);
        if (Hh != null) {
            try {
                Field field = this.sHl;
                if (field == null) {
                    p.btv("feedObject_field");
                }
                Object obj = field.get(Hh);
                Field field2 = this.sHm;
                if (field2 == null) {
                    p.btv("feedObject_item_field");
                }
                Object obj2 = field2.get(obj);
                Field field3 = this.sHn;
                if (field3 == null) {
                    p.btv("id_field");
                }
                Object obj3 = field3.get(obj2);
                if (obj3 == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Long");
                    AppMethodBeat.o(221084);
                    throw tVar;
                }
                String zs = com.tencent.mm.plugin.expt.hellhound.core.b.zs(((Long) obj3).longValue());
                AppMethodBeat.o(221084);
                return zs;
            } catch (Exception e2) {
                Log.e("HABBYGE-MALI.ProfileParamsCatcher", "ProfileParamsCatcher, getFeedItem crash: " + e2.getMessage());
                AppMethodBeat.o(221084);
                return null;
            }
        } else {
            AppMethodBeat.o(221084);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final void a(View view, PInt pInt, PInt pInt2, int i2) {
        pInt.value = 0;
        pInt2.value = 0;
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String ad(View view, int i2) {
        AppMethodBeat.i(221085);
        Object Hh = Hh(i2);
        if (Hh != null) {
            try {
                Field field = this.sHl;
                if (field == null) {
                    p.btv("feedObject_field");
                }
                Object obj = field.get(Hh);
                Field field2 = this.sHm;
                if (field2 == null) {
                    p.btv("feedObject_item_field");
                }
                Object obj2 = field2.get(obj);
                Field field3 = this.sHp;
                if (field3 == null) {
                    p.btv("username_field");
                }
                Object obj3 = field3.get(obj2);
                if (!(obj3 instanceof String)) {
                    obj3 = null;
                }
                String str = (String) obj3;
                AppMethodBeat.o(221085);
                return str;
            } catch (Exception e2) {
                Log.e("HABBYGE-MALI.ProfileParamsCatcher", "ProfileParamsCatcher, getFeedUserName crash: " + e2.getMessage());
                AppMethodBeat.o(221085);
                return null;
            }
        } else {
            AppMethodBeat.o(221085);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String ae(View view, int i2) {
        AppMethodBeat.i(221086);
        Object Hh = Hh(i2);
        if (Hh != null) {
            try {
                Field field = this.sHl;
                if (field == null) {
                    p.btv("feedObject_field");
                }
                Object obj = field.get(Hh);
                Field field2 = this.sHm;
                if (field2 == null) {
                    p.btv("feedObject_item_field");
                }
                Object obj2 = field2.get(obj);
                Field field3 = this.sHo;
                if (field3 == null) {
                    p.btv("nickname_field");
                }
                Object obj3 = field3.get(obj2);
                if (!(obj3 instanceof String)) {
                    obj3 = null;
                }
                String str = (String) obj3;
                AppMethodBeat.o(221086);
                return str;
            } catch (Exception e2) {
                Log.e("HABBYGE-MALI.ProfileParamsCatcher", "ProfileParamsCatcher, getFeedNickName crash: " + e2.getMessage());
                AppMethodBeat.o(221086);
                return null;
            }
        } else {
            AppMethodBeat.o(221086);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final boolean dP(View view) {
        return false;
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final void setRecyclerView(RecyclerView recyclerView) {
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String GY(int i2) {
        AppMethodBeat.i(221087);
        Object Hh = Hh(i2);
        if (Hh != null) {
            try {
                Field field = this.sHl;
                if (field == null) {
                    p.btv("feedObject_field");
                }
                Object obj = field.get(Hh);
                Field field2 = this.sHm;
                if (field2 == null) {
                    p.btv("feedObject_item_field");
                }
                Object obj2 = field2.get(obj);
                Field field3 = this.sHq;
                if (field3 == null) {
                    p.btv("sessionBuffer_field");
                }
                Object obj3 = field3.get(obj2);
                if (!(obj3 instanceof String)) {
                    obj3 = null;
                }
                String str = (String) obj3;
                AppMethodBeat.o(221087);
                return str;
            } catch (Exception e2) {
                Log.e("HABBYGE-MALI.ProfileParamsCatcher", "ProfileParamsCatcher, getSessionBuffer crash: " + e2.getMessage());
                AppMethodBeat.o(221087);
                return null;
            }
        } else {
            AppMethodBeat.o(221087);
            return null;
        }
    }

    private final Object Hh(int i2) {
        AppMethodBeat.i(221088);
        if (cPt()) {
            try {
                Field field = this.sHj;
                if (field == null) {
                    p.btv("dataList_field");
                }
                WeakReference<Object> weakReference = this.sHk;
                Object obj = field.get(weakReference != null ? weakReference.get() : null);
                if (obj instanceof ArrayList) {
                    if ((!((Collection) obj).isEmpty()) && i2 >= 0 && i2 < ((ArrayList) obj).size()) {
                        Object obj2 = ((ArrayList) obj).get(i2);
                        AppMethodBeat.o(221088);
                        return obj2;
                    }
                }
            } catch (Exception e2) {
                Log.e("HABBYGE-MALI.ProfileParamsCatcher", "getfeedItem, reflect exception: " + e2.getMessage());
            }
        }
        AppMethodBeat.o(221088);
        return null;
    }
}
