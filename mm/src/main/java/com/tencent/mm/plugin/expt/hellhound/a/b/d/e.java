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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J.\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001c\u0010 \u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\"\u001a\u00020#2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010$\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX.¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/MixSearchParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "feedList_Field", "Ljava/lang/reflect/Field;", "feedObject_Field", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "nickname_Field", "presenterRef", "Ljava/lang/ref/WeakReference;", "", "recyclerViewRef", "Landroid/support/v7/widget/RecyclerView;", "sessionBuffer_Field", "username_Field", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedItem", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"})
public final class e implements b {
    public static final a sHh = new a((byte) 0);
    private Field sCe;
    private WeakReference<RecyclerView> sFA;
    private Method sFF;
    private Field sFG;
    private Field sGU;
    private WeakReference<Object> sHd;
    private Field sHe;
    private Field sHf;
    private Field sHg;

    static {
        AppMethodBeat.i(221065);
        AppMethodBeat.o(221065);
    }

    public e(Activity activity) {
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(221064);
        try {
            Class<?> cls = Class.forName("com.tencent.mm.plugin.finder.search.FinderMixSearchUI");
            p.g(cls, "Class.forName(ACTIVITY_NAME)");
            Field declaredField = cls.getDeclaredField("presenter");
            p.g(declaredField, "FinderMixSearchUI_Class.…eld(presenter_Field_Name)");
            declaredField.setAccessible(true);
            this.sHd = new WeakReference<>(declaredField.get(activity));
            Class<?> cls2 = Class.forName("com.tencent.mm.plugin.finder.search.FinderMixSearchPresenter");
            p.g(cls2, "Class.forName(FinderMixSearchPresenter_Name)");
            Field declaredField2 = cls2.getDeclaredField("feedList");
            p.g(declaredField2, "FinderMixSearchPresenter…ield(feedList_Field_Name)");
            this.sHe = declaredField2;
            Field field = this.sHe;
            if (field == null) {
                p.btv("feedList_Field");
            }
            field.setAccessible(true);
            Class<?> cls3 = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
            p.g(cls3, "Class.forName(BaseFinderFeed_Name)");
            Field declaredField3 = cls3.getDeclaredField("feedObject");
            p.g(declaredField3, "BaseFinderFeed_Class.get…ld(feedObject_Field_Name)");
            this.sCe = declaredField3;
            Field field2 = this.sCe;
            if (field2 == null) {
                p.btv("feedObject_Field");
            }
            field2.setAccessible(true);
            Class<?> cls4 = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
            p.g(cls4, "Class.forName(FinderItem_Name)");
            Method declaredMethod = cls4.getDeclaredMethod("getFinderObject", new Class[0]);
            p.g(declaredMethod, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
            this.sFF = declaredMethod;
            Method method = this.sFF;
            if (method == null) {
                p.btv("getFinderObject_Method");
            }
            method.setAccessible(true);
            Class<?> cls5 = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
            p.g(cls5, "Class.forName(FinderObject_Name)");
            Field declaredField4 = cls5.getDeclaredField("id");
            p.g(declaredField4, "FinderObject_Class.getDeclaredField(id_Name)");
            this.sGU = declaredField4;
            Field field3 = this.sGU;
            if (field3 == null) {
                p.btv("id_Field");
            }
            field3.setAccessible(true);
            Field declaredField5 = cls5.getDeclaredField("nickname");
            p.g(declaredField5, "FinderObject_Class.getDeclaredField(nickname_Name)");
            this.sHf = declaredField5;
            Field field4 = this.sHf;
            if (field4 == null) {
                p.btv("nickname_Field");
            }
            field4.setAccessible(true);
            Field declaredField6 = cls5.getDeclaredField(ch.COL_USERNAME);
            p.g(declaredField6, "FinderObject_Class.getDeclaredField(username_Name)");
            this.sHg = declaredField6;
            Field field5 = this.sHg;
            if (field5 == null) {
                p.btv("username_Field");
            }
            field5.setAccessible(true);
            Field declaredField7 = cls5.getDeclaredField("sessionBuffer");
            p.g(declaredField7, "FinderObject_Class.getDe…Field(sessionBuffer_Name)");
            this.sFG = declaredField7;
            Field field6 = this.sFG;
            if (field6 == null) {
                p.btv("sessionBuffer_Field");
            }
            field6.setAccessible(true);
            AppMethodBeat.o(221064);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", e2, "init, reflect exception: " + e2.getMessage(), new Object[0]);
            AppMethodBeat.o(221064);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/MixSearchParamsCatcher$Companion;", "", "()V", "ACTIVITY_NAME", "", "BaseFinderFeed_Name", "FinderItem_Name", "FinderMixSearchPresenter_Name", "FinderObject_Name", "HEADER_COUNT", "", "TAG", "feedList_Field_Name", "feedObject_Field_Name", "getFinderObject_Name", "id_Name", "nickname_Name", "presenter_Field_Name", "sessionBuffer_Name", "username_Name", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String ac(View view, int i2) {
        AppMethodBeat.i(221058);
        Object Hh = Hh(i2);
        if (Hh != null) {
            try {
                Field field = this.sCe;
                if (field == null) {
                    p.btv("feedObject_Field");
                }
                Object obj = field.get(Hh);
                Method method = this.sFF;
                if (method == null) {
                    p.btv("getFinderObject_Method");
                }
                Object invoke = method.invoke(obj, new Object[0]);
                Field field2 = this.sGU;
                if (field2 == null) {
                    p.btv("id_Field");
                }
                Object obj2 = field2.get(invoke);
                if (obj2 == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Long");
                    AppMethodBeat.o(221058);
                    throw tVar;
                }
                String zs = com.tencent.mm.plugin.expt.hellhound.core.b.zs(((Long) obj2).longValue());
                AppMethodBeat.o(221058);
                return zs;
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", e2, "MixSearchParamsCatcher, getFeedId crash: " + e2.getMessage(), new Object[0]);
                AppMethodBeat.o(221058);
                return null;
            }
        } else {
            AppMethodBeat.o(221058);
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
        AppMethodBeat.i(221059);
        Object Hh = Hh(i2);
        if (Hh != null) {
            try {
                Field field = this.sCe;
                if (field == null) {
                    p.btv("feedObject_Field");
                }
                Object obj = field.get(Hh);
                Method method = this.sFF;
                if (method == null) {
                    p.btv("getFinderObject_Method");
                }
                Object invoke = method.invoke(obj, new Object[0]);
                Field field2 = this.sHg;
                if (field2 == null) {
                    p.btv("username_Field");
                }
                Object obj2 = field2.get(invoke);
                if (!(obj2 instanceof String)) {
                    obj2 = null;
                }
                String str = (String) obj2;
                AppMethodBeat.o(221059);
                return str;
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", e2, "MixSearchParamsCatcher, getFeedUserName crash: " + e2.getMessage(), new Object[0]);
                AppMethodBeat.o(221059);
                return null;
            }
        } else {
            AppMethodBeat.o(221059);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String ae(View view, int i2) {
        AppMethodBeat.i(221060);
        Object Hh = Hh(i2);
        if (Hh != null) {
            try {
                Field field = this.sCe;
                if (field == null) {
                    p.btv("feedObject_Field");
                }
                Object obj = field.get(Hh);
                Method method = this.sFF;
                if (method == null) {
                    p.btv("getFinderObject_Method");
                }
                Object invoke = method.invoke(obj, new Object[0]);
                Field field2 = this.sHf;
                if (field2 == null) {
                    p.btv("nickname_Field");
                }
                Object obj2 = field2.get(invoke);
                if (!(obj2 instanceof String)) {
                    obj2 = null;
                }
                String str = (String) obj2;
                AppMethodBeat.o(221060);
                return str;
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", e2, "MixSearchParamsCatcher, getFeedNickName crash: " + e2.getMessage(), new Object[0]);
                AppMethodBeat.o(221060);
                return null;
            }
        } else {
            AppMethodBeat.o(221060);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final boolean dP(View view) {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        if ((r0 != null ? r0.get() : null) == null) goto L_0x001c;
     */
    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setRecyclerView(android.support.v7.widget.RecyclerView r3) {
        /*
            r2 = this;
            r1 = 221061(0x35f85, float:3.09772E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            if (r3 != 0) goto L_0x000c
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
        L_0x000b:
            return
        L_0x000c:
            java.lang.ref.WeakReference<android.support.v7.widget.RecyclerView> r0 = r2.sFA
            if (r0 == 0) goto L_0x001c
            java.lang.ref.WeakReference<android.support.v7.widget.RecyclerView> r0 = r2.sFA
            if (r0 == 0) goto L_0x0027
            java.lang.Object r0 = r0.get()
            android.support.v7.widget.RecyclerView r0 = (android.support.v7.widget.RecyclerView) r0
        L_0x001a:
            if (r0 != 0) goto L_0x0023
        L_0x001c:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r3)
            r2.sFA = r0
        L_0x0023:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            goto L_0x000b
        L_0x0027:
            r0 = 0
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.b.d.e.setRecyclerView(android.support.v7.widget.RecyclerView):void");
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String GY(int i2) {
        AppMethodBeat.i(221062);
        Object Hh = Hh(i2);
        if (Hh != null) {
            try {
                Field field = this.sCe;
                if (field == null) {
                    p.btv("feedObject_Field");
                }
                Object obj = field.get(Hh);
                Method method = this.sFF;
                if (method == null) {
                    p.btv("getFinderObject_Method");
                }
                Object invoke = method.invoke(obj, new Object[0]);
                Field field2 = this.sFG;
                if (field2 == null) {
                    p.btv("sessionBuffer_Field");
                }
                Object obj2 = field2.get(invoke);
                if (!(obj2 instanceof String)) {
                    obj2 = null;
                }
                String str = (String) obj2;
                AppMethodBeat.o(221062);
                return str;
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", e2, "MixSearchParamsCatcher, getSessionBuffer crash: " + e2.getMessage(), new Object[0]);
                AppMethodBeat.o(221062);
                return null;
            }
        } else {
            AppMethodBeat.o(221062);
            return null;
        }
    }

    private final Object Hh(int i2) {
        AppMethodBeat.i(221063);
        try {
            Field field = this.sHe;
            if (field == null) {
                p.btv("feedList_Field");
            }
            WeakReference<Object> weakReference = this.sHd;
            if (weakReference == null) {
                p.btv("presenterRef");
            }
            Object obj = field.get(weakReference.get());
            if (obj instanceof ArrayList) {
                if ((!((Collection) obj).isEmpty()) && i2 >= 0 && i2 < ((ArrayList) obj).size()) {
                    Object obj2 = ((ArrayList) obj).get(i2);
                    AppMethodBeat.o(221063);
                    return obj2;
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", e2, "getfeedItem, reflect exception: " + e2.getMessage(), new Object[0]);
        }
        AppMethodBeat.o(221063);
        return null;
    }
}
